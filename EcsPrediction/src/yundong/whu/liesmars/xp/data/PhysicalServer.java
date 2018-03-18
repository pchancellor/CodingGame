package yundong.whu.liesmars.xp.data;

public class PhysicalServer {

	private int cpuCores ;
	private int memory ;
	private int disk ;
	
	public PhysicalServer(int cpuCores, int memory, int disk) {
		this.cpuCores = cpuCores;
		this.disk = disk;
		this.memory = memory;
	}
	
	public int getCpuCores() {
		return cpuCores;
	}
	
	/**
	 * 内存大小，单位是MB
	 * @return
	 */
	public int getMemory() {
		return memory;
	}
	
	/**
	 * 磁盘大小，单位是GB
	 * @return
	 */
	public int getDisk() {
		return disk;
	}
	
}
