package quiz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

import frame.Quiz;

public class Bingo implements Quiz {

	@Override
	public int make() {

		System.out.println();
		System.out.println("----------------------[빙 고 게 임]----------------------");
		System.out.println();

/*		System.out.println();
		System.out.println("┏━┳━┳━┓");
		System.out.println("┃①┃②┃③┃");
		System.out.println("┣━╋━╋━┫");
		System.out.println("┃④┃⑤┃⑥┃");
		System.out.println("┣━╋━╋━┫");
		System.out.println("┃⑦┃⑧┃⑨┃");
		System.out.println("┗━┻━┻━┛");
		System.out.println();
*/


		Scanner sc = new Scanner(System.in);

		// 1~9까지의 숫자가 입력될 빙고판
		int com[][] = new int[3][3];
		int user[][] = new int[3][3];

		int count = 0;	// user(count==0), com(count==1)
		ArrayList<Integer> lotto = new ArrayList<>();

		while(count <= 2){
			//1~20까지의 중복되지 않는 랜덤숫자가 어레이리스트 생성		
			int arr_index = 0;
			lotto.clear(); //초기화
			
			outer : for (int i=0; i<9;) {
				lotto.add( new Random().nextInt(20)+1 );
				for (int j=0; j<i; j++) {
					if (lotto.get(i) == lotto.get(j)) {
						lotto.remove(i);
						continue outer;  
					}
				}
				i++;
			}
			count++;

			if(count == 1){
				//user 빙고판 입력
				for(int i=0; i<com.length; i++){
					for(int j=0; j<com[i].length; j++){
						com[i][j] = lotto.get(arr_index);
						arr_index++;
					}
				}

			}else if(count == 2){
				//com 빙고판 입력
				for(int i=0; i<user.length; i++){
					for(int j=0; j<user[i].length; j++){
						user[i][j] = lotto.get(arr_index);
						arr_index++;
					}
				}
			}

		} //while


		BingoGame bg = new BingoGame(user);
		BingoGame bg2 = new BingoGame(com);

		//빙고판 출력
		bg.showBingo();
		//bg2.showBingo();

		while(true){

			//빙고숫자 맞추기 (순서: user->com)
			//숫자 체크하면 0으로 바뀜
			System.out.print("user >> ");
			int input = sc.nextInt();

			for(int i=0; i<lotto.size(); i++){
				if(input == lotto.get(i)){
					lotto.remove(i);
				}
			}

			bg.checkNum(input);
			bg2.checkNum(input);
			bg.isBingo(user);
			bg2.isBingo(com);
			bg.showBingo();
			//bg2.showBingo();

			System.out.println("user 빙고 : "+ bg.getBingo());
			System.out.println("com 빙고 : " + bg2.getBingo());
			System.out.println();

			if(bg.getBingo() >= 3){
				System.out.println("성공");
				return 1;
			}else if(bg2.getBingo() >= 3){
				System.out.println("실패");
				return 0;
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			int r = new Random().nextInt(lotto.size());
			int input2 = lotto.get(r);
			lotto.remove(r);

			System.out.println("com >> "+ input2);

			bg.checkNum(input2);
			bg2.checkNum(input2);
			bg.isBingo(user);
			bg2.isBingo(com);
			bg.showBingo();
			//bg2.showBingo();

			System.out.println("user 빙고 : "+ bg.getBingo());
			System.out.println("com 빙고 : " + bg2.getBingo());
			System.out.println();

			if(bg.getBingo() >= 3){
				System.out.println("성공");
				return 1;
			}else if(bg2.getBingo() >= 3){
				System.out.println("실패");
				return 0;
			}

		}//while

	}

	@Override
	public String[] story() {
		String[] msg = {"죽음의 빙고판 위에 오른 당신!",
		"주어진 빙고판을 이용하여 먼저 3빙고를 외춰주세요."};
		return msg;
	}
}
