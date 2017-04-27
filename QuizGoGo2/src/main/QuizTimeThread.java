package main;

public class QuizTimeThread extends Thread {

	private int timeElepsed = 0;
	
	public void setTimeElepsed(int timeElepsed) {
		this.timeElepsed = timeElepsed;
	}
	public int getTimeElepsed() {
		return timeElepsed;
	}


	@Override
	public void run() {

		// 경과시간체크
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			timeElepsed += 1;
		}
	}
}

