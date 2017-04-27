package info;

public class QuizInfo {
	
	private int quizNo;
	private int quizType;
	private int limtTime;	
	private int difficulty;
	

	
	public QuizInfo(int quizNo, int quizType, int limtTime, int difficulty) {
		this.quizNo = quizNo;
		this.quizType = quizType;
		this.limtTime = limtTime;
		this.difficulty = difficulty;
	}
	
	
	public int getQuizNo() {
		return quizNo;
	}
	public void setQuizNo(int quizNo) {
		this.quizNo = quizNo;
	}
	public int getLimtTime() {
		return limtTime;
	}
	public void setLimtTime(int limtTime) {
		this.limtTime = limtTime;
	}
	public int getQuizType() {
		return quizType;
	}
	public void setQuizType(int quizType) {
		this.quizType = quizType;
	}
	
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public int getDifficulty() {
		return difficulty;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getQuizNo() + ":" + this.getQuizType();
	}
	
	
	
}


