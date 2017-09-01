package com.mcylm.clay.service.openstackService.utils;

import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;
import com.google.gson.Gson;
import com.mcylm.clay.service.openstackService.mapper.EcsMapper;
import com.mcylm.clay.service.openstackService.model.ucenter.EcsServer;
import com.mcylm.clay.service.openstackService.model.ucenter.UauthToken;
import org.jclouds.ContextBuilder;
import org.jclouds.logging.slf4j.config.SLF4JLoggingModule;
import org.jclouds.openstack.nova.v2_0.NovaApi;
import org.jclouds.openstack.nova.v2_0.domain.*;
import org.jclouds.openstack.nova.v2_0.extensions.ConsolesApi;
import org.jclouds.openstack.nova.v2_0.extensions.FloatingIPApi;
import org.jclouds.openstack.nova.v2_0.extensions.VolumeApi;
import org.jclouds.openstack.nova.v2_0.features.FlavorApi;
import org.jclouds.openstack.nova.v2_0.features.ImageApi;
import org.jclouds.openstack.nova.v2_0.features.ServerApi;


import com.google.common.collect.ImmutableSet;
import com.google.common.io.Closeables;
import com.google.inject.Module;
import org.jclouds.openstack.nova.v2_0.options.CreateServerOptions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author root
 * java操作openstack
 */
public class JCloudsNova implements Closeable {
    private final NovaApi novaApi;
    private final Set<String> regions;

    public JCloudsNova(String tenantName, String userName, String password) {
        Iterable<Module> modules = ImmutableSet.<Module>of(new SLF4JLoggingModule());
        String provider = "openstack-nova";
        String identity = tenantName + ":" + userName;                               // tenantName:userName
        String credential = password;                        //密码

        novaApi = ContextBuilder.newBuilder(provider)
                .endpoint("http://43.248.137.162:5000/v2.0")//我的地址
                .credentials(identity, credential)
                .modules(modules)
                .buildApi(NovaApi.class);
        regions = novaApi.getConfiguredRegions();
    }

    /**
     * 获取服务器的全部信息
     *
     * @return
     */
    public List<FloatingIP> getListFloatingIPs(int num) {
        List<FloatingIP> floatingIPs = new ArrayList<FloatingIP>();
        for (String region : regions) {
            Optional<FloatingIPApi> floatingIPApi = novaApi.getFloatingIPApi(region);
            FluentIterable<FloatingIP> list = floatingIPApi.get().list();
            for (int i = 0; list.iterator().hasNext(); i++) {
                if (i == num) {
                    return floatingIPs;
                }
                floatingIPs.add(list.get(i));
            }
        }
        return floatingIPs;
    }

    /**
     * 给服务器附加IP
     * @param serverCreated
     * @param floatingIPs
     */
    public void addIptoServer(ServerCreated serverCreated,List<FloatingIP> floatingIPs,String uuid,List<EcsServer> ecsServerList){
        Optional<FloatingIPApi> floatingIPApi = null;
        for (String region : regions) {
            floatingIPApi = novaApi.getFloatingIPApi(region);
        }
        for(Server server : getListServers(uuid,ecsServerList)){
            if(serverCreated.getId().equals(server.getId())){
                for(FloatingIP floatingIP : floatingIPs){
                    floatingIPApi.get().addToServer(floatingIP.getIp(),serverCreated.getId());
                }
                return;
            }
        }
    }

    /**
     * 获取用户的所有云主机
     *  @param uuid 用户的UUID
     * @return
     */
    public List<Server> getListServers(String uuid,List<EcsServer> ecsServerList) {
        List<Server> list = new ArrayList<Server>();
        ServerApi serverApi = getServerApi();
        for (Server server : serverApi.listInDetail().concat()) {
            for(EcsServer ecsServer :ecsServerList){
                if(ecsServer.getSer_uuid().equals(server.getId())){
                    list.add(server);
                    break;
                }
            }
        }
        return list;
    }

    public Server getServerById(String id){
        for (String region : regions) {
            return novaApi.getServerApi(region).get(id);
        }
        return null;
    }


    /**
     * 获取云主机类型
     *
     * @return
     */
    public List<Flavor> getListFlavors() {
        List<Flavor> list = new ArrayList<Flavor>();
        for (String region : regions) {
            FlavorApi flavorApi = novaApi.getFlavorApi(region);
            for (Flavor flavor : flavorApi.listInDetail().concat()) {
                list.add(flavor);
            }
        }
        return list;
    }

    /**
     * 获取所有的镜像文件
     * @return
     */
    public List<Image> getListImages() {
        List<Image> list = new ArrayList<Image>();
        for (String region : regions) {
            ImageApi imageApi = novaApi.getImageApi(region);
            for(Image image : imageApi.listInDetail().concat()){
                list.add(image);
            }
        }
        return list;
    }

    /**
     * 通过镜像名称获取镜像
     * @param name
     * @return
     */
    public String getImageIdByName(String name){
        for(Image image : getListImages()){
            if(image.getName().equals(name)){
                return image.getId();
            }
        }

        return null;
    }


    /**
     * 创建云主机类型
     */
    public String createFlavor(EcsServer ecsServer){
        String flavorId = StringUtils.getUuid();
        Flavor.builder();
        for (String region : regions) {
            FlavorApi flavorApi = novaApi.getFlavorApi(region);
            flavorApi.create(Flavor.builder()
                    .disk(Integer.valueOf(ecsServer.getOs_disk()))
                    .ram(Integer.valueOf(ecsServer.getMemory())*1024)
                    .swap(String.valueOf(Integer.valueOf(ecsServer.getMemory())*1024))
                    .rxtxFactor(1.0)
                    .vcpus(Integer.valueOf(ecsServer.getCpu()))
                    .id(flavorId)
                    .name(flavorId)
                    .build());
        }

        return flavorId;
    }


    /**
     * 关机指令
     *
     * @param id
     */
    public void stopInstanceById(String id) {
        Server server = getServerById(id);
        if (server.getStatus() == Server.Status.SHUTOFF) {
            return;
        }
        getServerApi().stop(id);

    }

    public ServerApi getServerApi(){
        for (String region : regions) {
            return novaApi.getServerApi(region);
        }
        return null;
    }


    /**
     * 开机指令
     *
     * @param id
     */
    public void startInstanceById(String id) {
        Server server = getServerById(id);
        if (server.getStatus() == Server.Status.ACTIVE) {
            return;
        }
        getServerApi().start(id);
    }

    /**
     * 检查服务器是否属于用户
     * @param uuid
     * @param ser_uuid
     * @param ecsServerList
     * @return
     */
//    public boolean checkServerBelongToUser(String uuid,String ser_uuid,List<EcsServer> ecsServerList){
//        List<Server> list = getListServers(uuid,ecsServerList);
//        for(Server server :list){
//            System.out.println(server.getId()+"========"+ser_uuid);
//            if(server.getId().equals(ser_uuid)){
//                System.out.println("配对成功！！！");
//                return true;
//            }
//        }
//        return false;
//    }


    /**
     * 创建镜像操作
     *
     * @param id
     */
    public void createInstanceSnapeShotById(String id) {
        getServerApi().createImageFromServer(id, id);
    }

    /**
     * 删除操作
     *
     * @param id
     */
    public void deleteInstanceById(String id) {
        getServerApi().delete(id);
    }

    public Map<String,String> getMetadataById(String id){
        return getServerApi().getMetadata(id);
    }

    public void rebootSoftInstanceById(String id){
        getServerApi().reboot(id,RebootType.SOFT);
    }

    public void rebootHardInstanceById(String id){
        getServerApi().reboot(id,RebootType.HARD);
    }

    private String getUUidByToken(String uuid) {
        String valByKey = RedisUtils.getValByKey(Base64Utils.decodeBase64String(uuid));
        Gson gson = new Gson();
        UauthToken uauthToken = gson.fromJson(valByKey, UauthToken.class);
        return uauthToken.getUuid();
    }

    public String getConsoleUrl(String id,HttpServletRequest request,boolean belong){

        String token = (String) request.getSession().getAttribute("token");
        String uuid = getUUidByToken(token);
        if(!belong){
            System.out.println("服务器不属于该用户");
            return null;
        }

        for (String region : regions) {
            Optional<ConsolesApi> consolesApi = novaApi.getConsolesApi(region);
            Console console = consolesApi.get().getConsole(id, Console.Type.NOVNC);
            URI url = console.getUrl();
            String uri = url.getScheme()+":"+url.getSchemeSpecificPart();
            return uri;
        }
        System.out.println("服务器未找到");
        return null;
    }

    public static void main(String[] args) {
        JCloudsNova jCloudsNova = new JCloudsNova("admin","admin","admin");
//        System.out.println(jCloudsNova.getConsoleUrl("0e4033d3-fe5a-408a-8357-6ed8ea931c9e"));
//        jCloudsNova.rebootSoftInstanceById("0e4033d3-fe5a-408a-8357-6ed8ea931c9e");
    }



    /**
     * 修改密码
     * @param newPassword
     * @param ser_uuid
     * @param user_uuid
     * @param ecsServerList
     */
    public void changeAdminPasswordById(String newPassword,String ser_uuid,boolean belong){
        if (belong) {
            getServerApi().changeAdminPass(ser_uuid, newPassword);
        }
    }

    /**
     * 创建云主机实例
     * @param ecsServer
     * @param availabilityZone
     * @return
     */
    public ServerCreated createInstance(EcsServer ecsServer , String availabilityZone) {
        ServerCreated serverCreated = null;
        CreateServerOptions createServerOptions = new CreateServerOptions();
        createServerOptions.adminPass(ecsServer.getPassword());
        createServerOptions.availabilityZone("nova");
        createServerOptions.networks("cea413ef-effe-441a-88d6-779903fdb90b");
        String imageId = getImageIdByName(ecsServer.getImage());
        if(imageId == null){
            System.out.println("镜像文件不存在");
            return null;
        }
        try{
            ServerApi serverApi = getServerApi();
            List<FloatingIP> floatingIPs = getListFloatingIPs(Integer.valueOf(ecsServer.getIps()));
            serverCreated = serverApi.create(ecsServer.getSer_name(), imageId, createFlavor(ecsServer), createServerOptions);
//                addIptoServer(serverCreated,floatingIPs);
        }catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("创建失败");
        }

        return serverCreated;
    }


    public void close() throws IOException {
        Closeables.close(novaApi, true);
    }
}