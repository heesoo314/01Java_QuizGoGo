package quiz;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import frame.Quiz;

public class HangMan implements Quiz {


	@Override
	public int make() {

		System.out.println();
		System.out.println("---------------------------[행맨 게임]---------------------------");
		System.out.println("                         (제시어 : 과일)                         ");
		System.out.println();

		//제시어 : 과일
		String[] quiz = {"apple", "banana", "blueberry", "grape", "lemon", "mango","melon", 
				"orange", "peach", "strawberry", "watermelon"};

		ArrayList<String> inputs = new ArrayList<String>(); //맞춘 알파벳

		Scanner sc = new Scanner(System.in);

		int n = new Random().nextInt(quiz.length);
		String word = quiz[n];
		int count = 5;
		boolean isSuccess = false;

		HangmanGame hg = new HangmanGame(word);
		hg.setDefault();

		while(count>0){

			System.out.println("남은 횟수: " + count);
			count--;
			System.out.println("------------------------------");

			//			System.out.println("1.알파벳맞추기");
			//			System.out.println("2.정답맞추기");
			//			System.out.println("etc.중도포기");
			System.out.print(">> ");

			String select = sc.next();

			if(select.length() == 1){

				//System.out.print(">> ");
				//String input = sc.next();

				//if(word.contains((char)select)){

				inputs.add(select.trim());
				hg.setWord(inputs);
				//}
				//System.out.println(inputs);

			}else{
				//System.out.print(">> ");
				//String input2 = sc.next();

				if(word.equals(select.trim())){
					System.out.println("성공!");
					isSuccess = true;
					break;
				}

			}

		}//while

		if(isSuccess == true)
			return 1;
		else
			return 0;

	}//make()

	@Override
	public String[] story() {
		String[] msg = {"당신은 감옥에 갇혔습니다.",
				"행맨을 시작합니다.",
		"5번 이내에 성공해야 미션을 클리어 할 수 있습니다."};
		return msg;

	}


}
