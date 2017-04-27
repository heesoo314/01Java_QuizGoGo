package quiz;

/**
 * 문제 정보를 가지고 있는 클래스
 * @author Elzenaro
 *
 */
public class Quest{
	
	private String answer;
	private String ex;
	private String view;
	
	public Quest(String answer, String ex) {
		super();
		this.answer = answer;
		this.ex = ex;
	}
	public Quest() {
		// TODO Auto-generated constructor stub
	}
	
	public void showExample(){
		
		System.out.printf("%s\n",ex);
		System.out.println("━━━━━━━━━━━━━");
		System.out.printf("초성힌트 : %s\n",view);
		System.out.println("━━━━━━━━━━━━━");
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getEx() {
		return ex;
	}
	public void setEx(String ex) {
		this.ex = ex;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	
}
