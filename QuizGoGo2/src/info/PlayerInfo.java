package info;

import java.io.Serializable;

public class PlayerInfo implements Serializable {
	
	private String id;
	private int stage;
	private int recordTime;
	
	
	
	public PlayerInfo(String id, int stage, int recordTime) {
		super();
		this.id = id;
		this.stage = stage;
		this.recordTime = recordTime;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}
	public int getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(int recordTime) {
		this.recordTime = recordTime;
	}

	@Override
	public String toString() {	
		
		String record = Integer.toString(recordTime);
		
		return space(10,id) +  id + space(10,id) + space(4,record) + recordTime;
	}
	
	private String space(int num, String str) {
		
		String spc="";
		for (int i=0;i<(10-str.length()/2);i++)	{
			spc += " ";
		}
		return spc;

	}
	
	

}
