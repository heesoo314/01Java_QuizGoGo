package quiz;

import java.util.Random;
import java.util.Scanner;

import frame.Quiz;


public class MakeOne implements Quiz {

	@Override
	public int make() {

		System.out.println();
		System.out.println("------------------[나머지 만들기]------------------");
		System.out.println();

		//int isSuccess = 0;
		Scanner sc = new Scanner(System.in);

		MakeOneTime time = new MakeOneTime();
		time.start();

		int quiz = new Random().nextInt(1000)+2500; 	//제시된 문제
		int nam = new Random().nextInt(5)+1;			//최종적으로 구할 나머지

		System.out.println("  * 구할 나머지는 [ " + nam + " ] 입니다 *  ");

		outer : while(true){

			System.out.println("문제 : " + quiz);
			System.out.print(">> ");
			int input = sc.nextInt();

			if(input > 5){
				System.out.println("숫자가 너무커요 다시!");
				continue outer;

			} else {

				quiz /= input;

				//더이상 나눌 수 없는 경우
				if(quiz <= nam){
					if(quiz%input == nam){	
						System.out.println("성공");
						time.setEnd(1);
						break;
						
					}else{
						System.out.println("실패");
						time.setEnd(0);
						break;
					}
				}
				
				if(time.getEnd() == 2){
					System.out.println("시간초과");
					time.setEnd(0);
					break;
				}
			}
		}
		return time.getEnd();	//성공하면 1, 실패 또는 시간초과하면 0


	} //make()

	@Override
	public String[] story() {
		String[] msg = {"나머지 미로에 도착한 당신!",
				"주어진 숫자를 0~5로 연속하여 나눕니다.", 
				"최종적으로 남은 나머지를 주어진 값과 동일하게 만들어 탈출하세요.",
		"15초가 지나면 게임오버!!!"};
		return msg;
	}

}
