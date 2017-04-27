package quiz;

import java.util.Random;
import java.util.Scanner;

import frame.Quiz;

public class NonsenseQuiz implements Quiz {

	@Override
	public int make() {
		
		System.out.println();
		System.out.println("----------------------[넌센스 퀴즈]----------------------");
		System.out.println();
		
		int count = 0;
		boolean isSuccess = false;
		
		String[][] quiz = { {"서울에서 가장 추운 대학교는?","서울시립대"},
							{"고양이를 가장 싫어하는 동물은?", "미어캣"},
							{"한 입 베어먹은 사과를 표현하는 말은?", "파인애플"},
							{"소와 개가 길을 가다 부딪히면?", "소개팅"},
							{"세상에서 가장 외로운 몬스터는?", "솔로몬"},
							{"몸에 해로운 청바지는?", "유해진"},
							{"둘리가 재학중인 고등학교는?", "빙하타고"},
							{"세상에서 가장 가난한 왕은?", "최저임금"},
							{"신데렐라가 잠 못자면?", "모짜렐라"},
							{"왕이 궁에 가기 싫을 때 하는 말은?", "궁시렁궁시렁"}};

		
		Scanner sc = new Scanner(System.in);
		int n = new Random().nextInt(quiz.length);
		System.out.println("문제: " + quiz[n][0]);

		while(count < 3){

			System.out.print(">> ");
			String input = sc.next();
			count++;

			if(quiz[n][1].equals(input.trim())){
				System.out.println("성공!!!");
				isSuccess = true;
				break;
			}else{
				System.out.println("실패");
			}
			
		}//while
		
		if(isSuccess == true)
			return 1;
		else
			return 0;
		
	}//make()

	@Override
	public String[] story() {
		String[] msg = {"넌센스퀴즈의 세계에 오신 것을 환영합니다!",
						"기회는 단 3번!!! 아재신과 대결에서 그를 이겨보세요.",
						"(한글 선택 후 입력 커서를 조정해주세요.)"};
		return msg;

	}

}
