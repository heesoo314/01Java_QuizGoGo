package quiz;

import java.util.ArrayList;
import java.util.Scanner;

import frame.Quiz;



public class WordQuiz implements Quiz {
	
	ArrayList<String> arr = new ArrayList<>();
	//String[] data = { "apple" };
	String[] data = { "apple", "grape", "pear" };
	
	@Override
	public int make() {
		System.out.println();		
		System.out.println("-------------------------[단어 퀴즈]-------------------------");
		System.out.println();
		
		for (int i=0;i<data.length;i++) {
			arr.add(data[i]);
		}

		WordGame wg = new WordGame(arr, data);
		wg.start();

		Scanner sc = new Scanner(System.in);

		while (true) {

			if (arr.size() == 0) {
				System.out.println("클리어");
				wg.setPlaying(false);
				break;
			}

			System.out.println(arr);
			System.out.print(">> ");

			String input = sc.next();

			// 정답처리
			for (int i = 0; i < arr.size(); i++) {
				if (input.equals(arr.get(i))) {
					arr.remove(i);
				}
			}
		}
		
		return 1;
	}

	@Override
	public String[] story() {
		String[] msg = {"3초마다 단어가 늘어납니다..",
				        "제시한 단어들을 처음부터 차례대로 타이핑하세요",
		                "......................."};
		return msg;
		
	}

}

	




