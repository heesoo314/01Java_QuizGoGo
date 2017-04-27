package quiz;

public class Calculator {

	private int result = 0;

	public int getResult(int n1, int n2, String op){	

		switch( op ){

		case "+" :
			return n1 + n2;
		case "-" :
			return n1 - n2;
		case "*" :
			return n1 * n2;
		case "/" :
			return n1 / n2;
		default :
			return -1;
		}
	
	}
}
