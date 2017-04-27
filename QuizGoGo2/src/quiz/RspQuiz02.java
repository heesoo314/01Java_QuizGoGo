package quiz;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import frame.Quiz;

public class RspQuiz02 implements Quiz {

	@Override
	public int make() {

		System.out.println();
		System.out.println("----------------------[가위바위보 하나빼기]----------------------");
		System.out.println();

		Scanner sc = new Scanner(System.in);

		String[] str = {"s" , "r" , "p"};
		int win = 0, lose = 0, draw = 0;

		int usercount=0;
		int comcount = 0;

		while (true) {

			ArrayList<String> arr = new ArrayList<>();
			arr.clear();

			//0:가위, 1:바위 2:보 			
			System.out.println("\n가위(s) | 바위 (r) | 보 (p) : ");

			//user
			System.out.print("User 왼손 : ");
			arr.add(sc.next());//왼손
			System.out.print("User 오른손 : ");
			arr.add(sc.next());//오른손

			//com
			int com = new Random().nextInt(3);
			int com2 = new Random().nextInt(3);
			arr.add(str[com]);
			arr.add(str[com2]);
			System.out.println("COM 왼손 : "+str[com]);
			System.out.println("COM 오른손 : "+str[com2]);
			

			System.out.println("\n하나빼기!");
			arr.remove(new Random().nextInt(2)+2);

			System.out.println("무엇을 내시겠습니까? 왼손(1) | 오른손(2)");
			System.out.print(">> ");
			int select = sc.nextInt();
			if(select == 1){ 
				arr.set(1, "x");	//왼손을 낼 경우 오른손 값을 바꾼다
				System.out.println(arr.get(0) + " VS " + arr.get(2));
			}else if(select == 2){ //오른손을 낼 경우 왼손 값을 바꾼다
				arr.set(0, "x");
				System.out.println(arr.get(1) + " VS " + arr.get(2));
			}

			for(int i=0; i<2; i++){
				String rsp = arr.get(i);
				switch ( rsp ){
				case "s":
					usercount = 0;
					break;
				case "r" :
					usercount = 1;
					break;
				case "p" :
					usercount = 2;
					break;

				}
			}
			if (arr.get(2).equalsIgnoreCase("s")) 
				comcount=0; 
			else if (arr.get(2).equalsIgnoreCase("r")) 
				comcount=1;
			else if (arr.get(2).equalsIgnoreCase("p")) 
				comcount=2;
			
			//판정
			if (usercount-comcount == -2 || usercount-comcount == 1) {
				System.out.println("당신이 이겼습니다.");
				win++;
			} else if (usercount-comcount ==0) {
				System.out.println("무승부입니다.");
				draw++;
			} else {
				System.out.println("당신이 졌습니다.");
				lose++;
			}

			System.out.println(win + "승 " + draw + "무 " + lose + "패");
			
			System.out.println("---------------------------\n");

			if (win == 1 || lose ==1) {
				break;
			}
		}//while
		
		if (win == 1) {
			return 1;
		}else {
			return 0;
		}




	}

	@Override
	public String[] story() {
		String[] msg = {"가위바위보의 신이 재도전을 신청합니다.",
				"좀더어려운 가위바위보 하나빼기를 시작합니다.",
		"먼저 이겨야 미션을 클리어 할 수 있습니다."};
		return msg;

	}

}
