package frame;

public class QuizBank {

	Quiz quiz;
	
	
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	public int makeQuiz() {
		return quiz.make();

	}
	
	public void displayStory() throws InterruptedException {
		String[] story = quiz.story();
		
		for (int i=0;i<story.length;i++) {
			
			System.out.println(story[i]);
			Thread.sleep(500);
			
		}
	}
	
	
	
}
