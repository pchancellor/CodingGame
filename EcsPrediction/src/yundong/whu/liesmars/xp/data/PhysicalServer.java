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
	 * �ڴ��С����λ��MB
	 * @return
	 */
	public int getMemory() {
		return memory;
	}
	
	/**
	 * ���̴�С����λ��GB
	 * @return
	 */
	public int getDisk() {
		return disk;
	}
	
}
