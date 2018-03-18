package yundong.whu.liesmars.xp.data;

import java.util.ArrayList;
import java.util.List;

public class Dataset {

	List<Record> records ;
	
	public Dataset() {
		records = new ArrayList<>();
	}
	
	public void addRecord(String vmid, String vmSpec, long createTime, boolean preprocess) {
		Record record = new Record(vmid, vmSpec, createTime);
		if (preprocess) {
			preprocess(record);
		}
		records.add(record);
	}
	
	/**
	 * 数据预处理，剔除节假日等异常数据点
	 * @param record
	 */
	public void preprocess(Record record) {
		
	}
	
	public int getRecordNum() {
		return records.size();
	}
	
	private static class Record {
		String vmid ;
		String vmSpec ;
		long createTime ;
		
		public Record(String vmid, String vmSpec, long createTime) {
			this.vmid = vmid;
			this.vmSpec = vmSpec;
			this.createTime = createTime;
		}
		
		@Override
		public String toString() {
			return vmid+"	"+vmSpec+"	"+createTime;
		}
	}
	
}
