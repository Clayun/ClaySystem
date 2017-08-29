package com.mcylm.clay.service.openstackService.utils;

import com.google.common.io.Closeables;
import org.jclouds.ContextBuilder;
import org.jclouds.openstack.nova.v2_0.NovaApi;
import org.jclouds.openstack.nova.v2_0.domain.Server;
import org.jclouds.openstack.nova.v2_0.features.ServerApi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Set;

/**
 * Created by Mikesam on 2017/8/29.
 */
public class JCloudsNova implements Closeable{

    private final NovaApi novaApi;
    private final Set<String> regions;
    public static void main(String[] args) throws IOException {
        JCloudsNova jcloudsNova = new JCloudsNova();
        try {
            jcloudsNova.listServers();
            jcloudsNova.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jcloudsNova.close();
        }

    }

    public JCloudsNova() {
        String provider = "openstack-nova";
        String identity = "admin:admin";                               // tenantName:userName
        String credential = "admin";                        //密码

        novaApi = ContextBuilder.newBuilder(provider)
                .endpoint("http://43.248.137.162:5000/v2.0")//我的地址
                .credentials(identity, credential)
                .buildApi(NovaApi.class);
        regions = novaApi.getConfiguredRegions();
    }
    //可用可不用
    private void listServers() {
        for (String region : regions) {
            ServerApi serverApi = novaApi.getServerApi(region);
            System.out.println("Servers in " + region);
            for (Server server : serverApi.listInDetail().concat()) {
                System.out.println("  " + server);
            }
        }
    }

    public void close() throws IOException {
        Closeables.close(novaApi, true);
    }
}
