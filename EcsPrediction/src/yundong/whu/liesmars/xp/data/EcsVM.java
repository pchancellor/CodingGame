package yundong.whu.liesmars.xp.data;

public class EcsVM {

	private String flavorName ;
	private int cpuCores ;
	private int memory ;//MB
	
	public EcsVM(String flavorName, int cpuCores, int memory) {
		this.flavorName = flavorName;
		this.cpuCores = cpuCores;
		this.memory = memory;
	}
	
	public String getFlavorName() {
		return flavorName;
	}
	
	public int getCpuCores() {
		return cpuCores;
	}
	
	/**
	 * 内存单位是MB
	 * @return
	 */
	public int getMemory() {
		return memory;
	}
	
}
