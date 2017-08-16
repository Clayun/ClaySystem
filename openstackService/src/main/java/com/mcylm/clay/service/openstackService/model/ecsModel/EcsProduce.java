package com.mcylm.clay.service.openstackService.model.ecsModel;

import java.util.List;

/**
 * Created by Mikesam on 2017/8/15.
 */
public class EcsProduce {

    private List<EcsCpu> ecsCpuList;
    private List<EcsExpandDisk> ecsExpandDiskList;
    private List<EcsIp> ecsIpList;
    private List<EcsMemory> ecsMemoryList;
    private List<EcsOsDisk> ecsOsDiskList;
    private List<EcsTape> ecsTapeList;

    public List<EcsCpu> getEcsCpuList() {
        return ecsCpuList;
    }

    public void setEcsCpuList(List<EcsCpu> ecsCpuList) {
        this.ecsCpuList = ecsCpuList;
    }

    public List<EcsExpandDisk> getEcsExpandDiskList() {
        return ecsExpandDiskList;
    }

    public void setEcsExpandDiskList(List<EcsExpandDisk> ecsExpandDiskList) {
        this.ecsExpandDiskList = ecsExpandDiskList;
    }

    public List<EcsIp> getEcsIpList() {
        return ecsIpList;
    }

    public void setEcsIpList(List<EcsIp> ecsIpList) {
        this.ecsIpList = ecsIpList;
    }

    public List<EcsMemory> getEcsMemoryList() {
        return ecsMemoryList;
    }

    public void setEcsMemoryList(List<EcsMemory> ecsMemoryList) {
        this.ecsMemoryList = ecsMemoryList;
    }

    public List<EcsOsDisk> getEcsOsDiskList() {
        return ecsOsDiskList;
    }

    public void setEcsOsDiskList(List<EcsOsDisk> ecsOsDiskList) {
        this.ecsOsDiskList = ecsOsDiskList;
    }

    public List<EcsTape> getEcsTapeList() {
        return ecsTapeList;
    }

    public void setEcsTapeList(List<EcsTape> ecsTapeList) {
        this.ecsTapeList = ecsTapeList;
    }
}
