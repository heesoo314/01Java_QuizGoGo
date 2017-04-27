package quiz;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import frame.Quiz;

public class Quick implements Quiz {

	@Override
	public int make() {
		System.out.println();
		System.out.println("----------------[알파벳 빨리치기]----------------");
		System.out.println();

		ArrayList<String> arr = new ArrayList<>();
		String[] str = new String[('Z'-'A'+1)];
		for(int i=0; i < str.length; i++){
			str[i] = (char)('A'+i) +"";
			arr.add(str[i]);
		}
		//System.out.println(arr);

		Scanner sc = new Scanner(System.in);
		int wincount = 0;
		
		System.out.println("문구가 보이면 빠르게 문구를 입력 제한시간 1.5초!");
		Quick02 quic = new Quick02();
		quic.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("게임시작!!");

		while(true){

			String comstr = arr.get(new Random().nextInt(26));
			System.out.println(comstr);
			
			String result = sc.next();
			int fail = 0;
			for(int i = 0; i <str.length; i++){
				if(result.equalsIgnoreCase(comstr)){
					wincount++;
					System.out.println("아슬아슬하게 성공!!!");
					quic.setTimecount(0);
					break;
				}
				fail++;
			}
			if(quic.getLife() == 0 || fail == str.length){
				System.out.println("노잼 독수리타법이시네요...");
				System.out.println("LOSE!");
				quic.setLife(0);
				break;
			}
			
			if(wincount >= 5){
				System.out.println("이정도면 떨어지는 낙엽정돈 잡겠네");
				System.out.println("WIN!");
				quic.setLife(1);
				break;
			}
			
		}
		//System.out.println(quic.getLife());
		return quic.getLife();
		
	}

	@Override
	public String[] story() {
		String[] msg = {"훈련장에 방문했다",
				"랜덤으로 1.5초마다 나오는 알파벳을 입력하자",
		"시간이 지나도 입력못하면 게임오버"};
		return msg;
	}

}
