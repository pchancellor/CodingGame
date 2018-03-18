package yundong.whu.liesmars.xp.entrance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import yundong.whu.liesmars.xp.data.MetaData;
import yundong.whu.liesmars.xp.data.EcsVM;
import yundong.whu.liesmars.xp.data.PhysicalServer;
import yundong.whu.liesmars.xp.data.PredictionDimension;
import yundong.whu.liesmars.xp.data.Dataset;

public class Starter {

	public static void main(String[] args) {
		MetaData metaData = new MetaData();
		String fileName = "C:/Users/WD/Downloads/��ϰ����/�����ĵ�/����ʾ��/input_5flavors_cpu_7days.txt";
		Dataset trainingDataset = new Dataset();
		String trainingFile = "C:/Users/WD/Downloads/��ϰ����/�����ĵ�/����ʾ��/TrainData_2015.1.1_2015.2.19.txt";
		Dataset testDataset = new Dataset();
		String testFile = "C:/Users/WD/Downloads/��ϰ����/�����ĵ�/����ʾ��/TestData_2015.2.20_2015.2.27.txt";
		try {
			readMetaData(fileName, metaData);
			readData(trainingFile, trainingDataset, true);
			readData(testFile, testDataset, false);
		} catch (IOException e) {
			System.out.println("�����ļ���ʽ������");
			e.printStackTrace();
			return;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.println(metaData.getEcsTypeNumbers());
		System.out.println(trainingDataset.getRecordNum());
		System.out.println(testDataset.getRecordNum());
	}
	
	public static void readMetaData(String fileName, MetaData manager) throws Exception {
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));) {
			String line = reader.readLine();
			String[] infos = line.split(" ");
			PhysicalServer server = new PhysicalServer(Integer.valueOf(infos[0]), Integer.valueOf(infos[1]), Integer.valueOf(infos[2]));
			reader.readLine();
			
			int ecsTypes = Integer.valueOf(reader.readLine());
			for (int i = 0; i < ecsTypes; i++) {
				line = reader.readLine();
				infos = line.split(" ");
				manager.addEcs(infos[0], new EcsVM(infos[0], Integer.valueOf(infos[1]), Integer.valueOf(infos[2])));
			}
			if (manager.getEcsTypeNumbers() != ecsTypes) {
				throw new Exception("������������ƥ��");
			}
			reader.readLine();
			
			String dimension = reader.readLine();
			PredictionDimension pDimension ;
			if (dimension.equals("CPU")) {
				pDimension = PredictionDimension.cpu;
			} else if (dimension.equals("MEM")) {
				pDimension = PredictionDimension.memory;
			} else {
				throw new Exception("������Ż�ά����Ϣ��ֻ֧��CPU��MEM");
			}
			reader.readLine();
			
			String predictionStart = reader.readLine();
			String predictionEnd = reader.readLine();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			manager.init(server, pDimension, dateFormat.parse(predictionStart).getTime(), dateFormat.parse(predictionEnd).getTime());
			reader.close();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void readData(String fileName, Dataset dataset, boolean preprocess) throws FileNotFoundException {
		try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));) {
			String line ;
			String[] infos ;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			while ((line = reader.readLine()) != null) {
				infos = line.split("	");
				dataset.addRecord(infos[0], infos[1], dateFormat.parse(infos[2]).getTime(), preprocess);
			}
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		} 
	}

	public static void readTestData() {
		
	}
}
