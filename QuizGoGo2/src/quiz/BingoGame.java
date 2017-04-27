package quiz;

public class BingoGame {

	private int num[][];
	private int bingo = 0;

	public BingoGame( int num[][] ) {
		this.num = num;
		//this.check = check;
	}

	public int getBingo() {
		return bingo;
	}

	//현재 빙고판 출력
	public void showBingo(){

		System.out.println("\n[나의 빙고판(체크된 숫자는 0으로 표시)]");

		

		System.out.println("┏━━┳━━┳━━┓");

		for(int i=0; i<num.length; i++){
			for(int j=0; j<num[i].length; j++){
				System.out.printf("┃ %2d ", num[i][j]);
			}
			System.out.print("┃");

			if(i<2)
				System.out.println("\n┣━━╋━━╋━━┫");
		}
		System.out.println("\n┗━━┻━━┻━━┛");


		//		for(int i=0; i<num.length; i++){
		//			for(int j=0; j<num[i].length; j++){
		//				System.out.printf("┃ %2d ", num[i][j]);
		//			}
		//			System.out.println();
		//		}
		//		System.out.println("---------------------------");

	}//showBingo

	//숫자를 입력하면 0으로 바꾸고 빙고칸 체크
	public void checkNum(int n){

		for(int i=0; i<num.length; i++){
			for(int j=0; j<num[i].length; j++){
				if(n == num[i][j]){
					num[i][j] = 0;

				}
			}
		}

	}//checkNum

	//빙고여부 확인
	public int isBingo( int num[][] ){

		bingo = 0;

		//대각선 일치
		if( num[0][0] + num[1][1] + num[2][2] == 0 ){
			bingo++;
		}

		if( num[0][2] + num[1][1] + num[2][0] == 0 ){
			bingo++;
		}

		//행일치
		for(int i=0; i<num.length; i++){
			if( num[i][0] + num[i][1] + num[i][2] == 0 ){
				bingo++;
			}
		}

		//열일치
		for(int i=0; i<num.length; i++){
			if( num[0][i] + num[1][i] + num[2][i] == 0 ){
				bingo++;
			}
		}

		return bingo;

	}//isBingo



}
