package quiz;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Quick02 extends Thread{
	private int timecount =0;
	private int life = 1;
	@Override
	public void run() {
		try {
			
			Thread.sleep(2000);
			while(true){
				Thread.sleep(100);
				this.timecount++;
				if(this.timecount >=20 ){
					this.life = 0;
					break;
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getTimecount() {
		return timecount;
	}
	public void setTimecount(int timecount) {
		this.timecount = timecount;
	}
	
}
