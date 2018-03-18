package yundong.whu.liesmars.xp.data;

import java.util.HashMap;
import java.util.Map;

import yundong.whu.liesmars.xp.data.EcsVM;
import yundong.whu.liesmars.xp.data.PhysicalServer;
import yundong.whu.liesmars.xp.data.PredictionDimension;

public class MetaData {
	
	private Map<String, EcsVM> ecsMap ;
	private PhysicalServer physicalServer ;
	private PredictionDimension dimension ;
	private long predictionStart , predictionEnd ;
	
	public MetaData() {
		ecsMap = new HashMap<>();
	}
	
	public void init(PhysicalServer server, PredictionDimension dimension, long predStart, long predEnd) {
		physicalServer = server;
		this.dimension = dimension;
		predictionStart = predStart;
		predictionEnd = predEnd;
	}
	
	public PhysicalServer getPhysicalServer() {
		return physicalServer;
	}
	
	public void addEcs(String ecsName, EcsVM vm) {
		ecsMap.put(ecsName, vm);
	}
	
	public int getEcsTypeNumbers() {
		return ecsMap.size();
	}
	
	public PredictionDimension getBoxingFactor() {
		return dimension;
	}
	
	public long getPredictionStart() {
		return predictionStart;
	}
	
	public long getPredictionEnd() {
		return predictionEnd;
	}
	
}
