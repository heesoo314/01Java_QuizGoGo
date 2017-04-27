package quiz;

import java.util.Random;
import java.util.Scanner;

import frame.Quiz;

public class WordPerfect implements Quiz {

	@Override
	public int make() {
		System.out.println();
		System.out.println("-------------------[단어 스펠링 맞추기]-------------------");
		System.out.println();
		
		String[] strArr = { "ELEPHANT", "SQUARREL", "RAINBOW", "INCREPAS" };
		Random random = new Random();

		Scanner sc = new Scanner(System.in);
		String answer = "";

		int select = random.nextInt(strArr.length);

		System.out.println("제시한 단어의 스펠링을 맞추어 보세요");
		RandomSpeller rs = new RandomSpeller(strArr[select]);
		System.out.println("문제 : " + rs.makeRandomWords());

		while (true) {

			System.out.print("정답은? : ");
			answer = sc.next();
			
			if (answer.equalsIgnoreCase(strArr[select])) {
				System.out.println(answer + "는 정답입니다.");
				break;
			} else {
				System.out.println(answer + "는 오답입니다.");
			}

		}
		return 1;
	}

	@Override
	public String[] story() {
		String[] msg = {"당신은 깜깜한 동굴속에 있습니다.",
				        "제시한 단어의 철자를 정확하게 맞혀주세요",
		                "......................."};
		return msg;
	}

}


