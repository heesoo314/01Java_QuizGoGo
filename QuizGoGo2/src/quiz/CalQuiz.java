package quiz;

import java.util.Random;
import java.util.Scanner;

import frame.Quiz;

public class CalQuiz implements Quiz {

	@Override
	public int make() {

		System.out.println();
		System.out.println("-------------------------[암 산 게 임]-------------------------");
		System.out.println();

		Scanner sc = new Scanner(System.in);

		int count = 0;			//3번 맞춰야 미션 클리어
		String[] ops = {"+", "-", "*", "/"};

		while(count < 3){

			int op = new Random().nextInt(ops.length);

			int[] nums = new int[2];
			if(op == 3){
				do{
					for(int i=0; i<2; i++){
						nums[i] = new Random().nextInt(50);
					}
				}while(nums[1] == 0 || nums[0]%nums[1] != 0);	
				//num2(나누는 수)가 0이 되거나, 나눈 결과값을 정수로 받기 위해

			}else{
				for(int i=0; i<2; i++){
					nums[i] = new Random().nextInt(50);
				}
			}

			Calculator cal = new Calculator();
			int result = cal.getResult(nums[0], nums[1], ops[op]);

			System.out.printf("문제%d: %d %s ? = %d\n", count+1, nums[0], ops[op], result);
			System.out.print(">> ");

			int input = sc.nextInt();
			if(input == nums[1]){
				System.out.println("성공");
				count++;
			}else{
				System.out.println("실패");
			}
		}
		return 1;
	}

	@Override
	public String[] story() {
		String[] msg = {"당신은 숫자지옥에 갇혔습니다.",
						"1~50까지의 숫자를 이용하여 암산게임을 시작합니다.",
						"3번을 성공해야 미션을 클리어 할 수 있습니다."};
		return msg;

	}

}
