package quiz;

public class MakeOneTime extends Thread{
	
	private int end = 10;
	
	@Override
	public void run() {
		
		try {
			for(int i = 1; i <= 20; i++){
				
				Thread.sleep(1000);

				if(i == 10){
					System.out.println("10초 남았어요 빨리빨리");
				}else if(i == 20){
					System.out.println("아이고... 끝났네 수고했어요");
					this.end = 2;
				}
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
}
