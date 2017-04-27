package quiz;

import java.util.ArrayList;
import java.util.Iterator;

public class HangmanGame {

	private String word;
	boolean isBlank = true;


	public HangmanGame(String word) {
		this.word = word;

	}

	public void setDefault(){
		System.out.println("\n문제: ");

		for(int i=0; i<word.length(); i++){
			System.out.print("□ ");
		}
		System.out.println();
	}//setBlank

	public void setWord(ArrayList<String> arr){
		System.out.println("\n문제: ");

		for(int i=0; i<word.length(); i++){
			
			isBlank = true;
			
			for(int j=0; j<arr.size(); j++){
				if( word.substring(i, i+1).equalsIgnoreCase(arr.get(j)) ){
					System.out.print(arr.get(j) + " ");
					isBlank = false;		//맞춘 알파벳 출력후 네모 처리하지 않게
					break;
				}
			}
			
			//일치하지 않는 값은 네모처리
			if(isBlank == true){
				System.out.print("□ ");
			}
			
		}
		System.out.println();

	}//setWord

}
