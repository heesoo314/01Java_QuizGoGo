package quiz;

import java.util.Random;

public class RandomSpeller {
	
	private String words="";
	
	public RandomSpeller(String words) {
		this.words = words;
	}

	public StringBuilder makeRandomWords() {
		
		Random random = new Random();

		int max = this.words.length(); 
		int[] arr = new int[max];
		
		for (int i=0; i<max;i++) {
			arr[i] = random.nextInt(max);
			
			for (int j=0;j<i;j++) {
				if (arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		
/*      
 * 		for문의 증감식을 본문으로 이동할 수도 있다. (outer label 사용)
 * 
  		outer: for (int i = 0; i < max;) {
			for (int j = 0; j < i; j++) {
				arr[i] = random.nextInt(max);
				if (arr[i] == arr[j]) {
					continue outer;
				}
			}
			i++;
		}
*/
		 	
		StringBuilder sb = new StringBuilder("");
		
		for (int i=0;i<max;i++) {
			sb.append(this.words.charAt(arr[i]));
		}
		
		return sb;
	}
}
