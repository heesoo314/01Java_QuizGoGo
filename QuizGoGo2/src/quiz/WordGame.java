package quiz;

import java.util.ArrayList;
import java.util.Random;

public class WordGame extends Thread{
	
	private String[] data;
	//쓰레드 정지 flag
	private ArrayList<String> arr;
	private boolean isPlaying = true;
	
	public WordGame(ArrayList<String> arr, String[] data) {
		
		this.arr = arr;
		this.data = data;
	}
	
	public ArrayList<String> getArr() {
		return arr;
	}
	
	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}
	
	public boolean isPlaying() {
		return isPlaying;
	}

	@Override
	public void run() {
		while(isPlaying) {
			//3초간격으로 준비된 단어를 arr에 추가
			
			int rnd = new Random().nextInt(data.length);
			arr.add(data[rnd]);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
