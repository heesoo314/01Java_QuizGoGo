package quiz;

import java.util.ArrayList;
import java.util.Scanner;

import frame.Quiz;

public class ChosungQuiz implements Quiz {

	@Override
	public int make() {
		System.out.println();
		System.out.println("----------------[초성 퀴즈]----------------");
		System.out.println();
		
		String answer;
		
		Scanner sc = new Scanner(System.in);

		ArrayList<Quest> list = GameControl.getInstance().makeGame();

		int score = 0;

		for (int i = 0; i < list.size(); i++) {
			System.out.print("<" + (i + 1) + "번> : ");

			list.get(i).showExample();

			// answer = br.readLine();
			System.out.print("답 : ");
			answer = sc.next();

			if (answer.equals(list.get(i).getAnswer())) {
				System.out.println("정답입니다.");
				score += 1;
			} else {
				System.out.println("오답입니다.");
				score -= 1;
			}
			
			if (score == 3) {
				System.out.println("미션 클리어 !!");
				break;
			}
		}
			
		return 1;
	}

	@Override
	public String[] story() {
		String[] msg = {"당신의 상식을 시험 합니다.",
				        "초성힌트를 참고하여 정답을 맞추세요",
						"3문제를 풀때까지 미션은 계속됩니다."};
		return msg;
		
	}

}
