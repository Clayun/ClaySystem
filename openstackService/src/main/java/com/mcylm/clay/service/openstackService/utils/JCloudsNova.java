package com.mcylm.clay.service.openstackService.utils;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;
import com.mcylm.clay.service.openstackService.model.ucenter.EcsServer;
import org.jclouds.ContextBuilder;
import org.jclouds.logging.slf4j.config.SLF4JLoggingModule;
import org.jclouds.openstack.nova.v2_0.NovaApi;
import org.jclouds.openstack.nova.v2_0.domain.*;
import org.jclouds.openstack.nova.v2_0.extensions.FloatingIPApi;
import org.jclouds.openstack.nova.v2_0.features.FlavorApi;
import org.jclouds.openstack.nova.v2_0.features.ImageApi;
import org.jclouds.openstack.nova.v2_0.features.ServerApi;

import com.google.common.collect.ImmutableSet;
import com.google.common.io.Closeables;
import com.google.inject.Module;
import org.jclouds.openstack.nova.v2_0.options.CreateServerOptions;
import org.jclouds.openstack.v2_0.domain.Link;

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
     * 获取公网IP类型
     *
     * @return
     */
    public List<Server> getListServers() {
        List<Server> list = new ArrayList<Server>();
        for (String region : regions) {
            ServerApi serverApi = novaApi.getServerApi(region);
            for (Server server : serverApi.listInDetail().concat()) {
                list.add(server);
            }
        }
        return list;
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

    public String getImageIdByName(String name){
        for(Image image : getListImages()){
            System.out.println(image.getName()+"    "+name);
            if(image.getName().equals(name)){
                System.out.println("配对成功");
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
            flavorApi.create(Flavor.builder().disk(Integer.valueOf(ecsServer.getOs_disk()))
                    .ram(Integer.valueOf(ecsServer.getMemory())*1024)
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
        for (String region : regions) {
            ServerApi serverApi = novaApi.getServerApi(region);
            for (Server server : serverApi.listInDetail().concat()) {
                if (server.getId().equals(id)) {
                    System.out.println("即将关闭ID为" + id + "的主机，当前状态为：" + server.getStatus());
                    if (server.getStatus() == Server.Status.SHUTOFF) {
                        System.out.println("目标服务器已关闭！");
                        return;
                    }
                    serverApi.stop(id);
                    System.out.println("已关闭ID为" + id + "的主机，当前状态为：" + server.getStatus());
                }
            }
        }

    }

    /**
     * 开机指令
     *
     * @param id
     */
    public void startInstanceById(String id) {
        for (String region : regions) {
            ServerApi serverApi = novaApi.getServerApi(region);
            for (Server server : serverApi.listInDetail().concat()) {
                if (server.getId().equals(id)) {
                    System.out.println("即将开启ID为" + id + "的主机，当前状态为：" + server.getStatus());
                    if (server.getStatus() == Server.Status.ACTIVE) {
                        System.out.println("目标服务器已启动！无需重复启动");
                        return;
                    }
                    serverApi.start(id);
                    System.out.println("已开启ID为" + id + "的主机，当前状态为：" + server.getStatus());
                }
            }
        }
    }

    /**
     * 创建镜像操作
     *
     * @param id
     */
    public void createInstanceSnapeShotById(String id) {
        for (String region : regions) {
            ServerApi serverApi = novaApi.getServerApi(region);
            for (Server server : serverApi.listInDetail().concat()) {
                if (server.getId().equals(id)) {
                    serverApi.createImageFromServer(id + "的快照", id);
                    System.out.println("正在创建ID为" + id + "的主机的快照");

                }
            }
        }
    }

    /**
     * 删除操作
     *
     * @param id
     */
    public void deleteInstanceById(String id) {
        for (String region : regions) {
            ServerApi serverApi = novaApi.getServerApi(region);
            for (Server server : serverApi.listInDetail().concat()) {
                if (server.getId().equals(id)) {
                    boolean b = serverApi.delete(id);
                    System.out.println("正在删除ID为" + id + "的主机的快照");
                    if (b) System.out.println("删除成功");
                    else System.out.println("删除失败");
                }
            }
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

        for (String region : regions) {
            ServerApi serverApi = novaApi.getServerApi(region);

            try{
                serverCreated = serverApi.create(ecsServer.getSer_name(), imageId, createFlavor(ecsServer), createServerOptions);
            }catch (Exception ex){
                ex.printStackTrace();
                System.out.println("创建失败");
            }
        }
        return serverCreated;
    }


    public void close() throws IOException {
        Closeables.close(novaApi, true);
    }
}