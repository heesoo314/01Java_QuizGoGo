package quiz;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import frame.Quiz;

public class IndianPoker implements Quiz{

	@Override
	public int make() {
		
		System.out.println();
		System.out.println("------------------[인디언 포커]------------------");
		System.out.println();
		
		int round = 0;
		int life = 3;
		int wincount = 0;
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> arr = new ArrayList<>();		//user(내카드)
		ArrayList<Integer> arr2 = new ArrayList<>();	//com(상대카드)
		for(int i = 1; i <= 12; i++){
			arr.add(i);		
			arr2.add(i);	
		}

		outer : while(true){
			
			round++;
			
			int user = new Random().nextInt(arr.size());
			int com = new Random().nextInt(arr2.size());
			
			System.out.println("\n       (라운드 " + round + ")       ");
			System.out.println("com 카드 : " + arr2.get(com));
			System.out.println("내 카드 : ?");
			
			System.out.println("---------------------");
			System.out.println("1.배팅  |  2.다이");
			System.out.print(">> ");
			
			int select = sc.nextInt();
			
			switch( select ){
			
			case 1: 
				
				System.out.println("★☆  내카드 : "+ arr.get(user) + " ★☆");
				
				if(arr2.get(com) >= arr.get(user)){
					//컴이 나보다 크거나 같은 경우 목숨 -1
					life--;
					System.out.println("LOSE");
				}else{
					//컴이 나보다 작은 같은 경우 win+1
					wincount++;
					System.out.println("WIN ");
				}
				
				arr.remove(user);
				arr2.remove(com);
				break;
				
			case 2:
				
				System.out.println("★☆ 내카드 : "+ arr.get(user) + " ★☆");
				
				if(arr2.get(com) >= arr.get(user)){
					//컴이 나보다 크거나 같은 경우 목숨 유지
					System.out.println("휴=3 다행이다.");
				}else{
					//컴이 나보다 작은 같은 경우 life-1
					life--;
					System.out.println("실수하셨습니다.");
				}
				
				arr.remove(user);
				arr2.remove(com);
				break;
				
				default :
					System.out.println("다시 입력하세요.");
					continue outer;
			}//switch
			
			System.out.println("목숨: " + life + " 이긴 횟수: " + wincount+"/3");
			
			if(life == 0){
				System.out.println("실패");
				return 0;
			}//if
			
			if(wincount == 3){
				System.out.println("성공");
				return 1;
			}
		}//while
	}

	@Override
	public String[] story() {
		String[] msg = { "당신은 강원랜드에 놀러왔습니다.", 
						"인디언포커를 시작합니다.",
						"3번을 이겨야 미션을 클리어 할 수 있습니다." };
		return msg;

	}

}
