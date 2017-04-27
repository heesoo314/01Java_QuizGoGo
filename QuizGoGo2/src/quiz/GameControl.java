package quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class GameControl {

	private static GameControl instance = new GameControl();

	// 문제가 저장된 파일 경로
	private File file;

	// 문제를 읽어올 스트림
	private BufferedReader br;

	// 모든 문제들을 저장할 리스트 배열
	private ArrayList<Quest> qlist;

	/**
	 * 각 분야별 문제들을 저장할 리스트를 생성
	 */
	private GameControl() {

		qlist = new ArrayList<>();
		file = new File("singer.txt");
		loadQuest();
	}

	public static GameControl getInstance() {
		return instance;
	}

	/**
	 * 문제 읽어오기
	 */
	public void loadQuest() {

		int i = 0;
		try {
			String str;
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			while (true) {
				Quest q = new Quest();
				str = br.readLine();
				if (str == null)
					break;
				q.setEx(str);
				str = br.readLine();
				q.setAnswer(str);
				q.setView(makerView(str));
				
				qlist.add(q);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private String makerView(String str) {
		// TODO Auto-generated method stub
		String view = new String();
		for (int i = 0; i < str.length(); i++) {
			int no = str.charAt(i);
			view += convertor(no);
		}
		return view;
	}

	/**
	 * 해당 글자 코드를 분석하여 해당 자음으로 변경
	 * 
	 * @param no
	 *            유니코드
	 * @return 해당 자음 리턴
	 */
	private String convertor(int no) {
		// TODO Auto-generated method stub
		if (no >= '가' && no < '까')
			return "ㄱ";
		else if (no >= '까' && no < '나')
			return "ㄲ";
		else if (no >= '나' && no < '다')
			return "ㄴ";
		else if (no >= '다' && no < '따')
			return "ㄷ";
		else if (no >= '따' && no < '라')
			return "ㄸ";
		else if (no >= '라' && no < '마')
			return "ㄹ";
		else if (no >= '마' && no < '바')
			return "ㅁ";
		else if (no >= '바' && no < '빠')
			return "ㅂ";
		else if (no >= '빠' && no < '사')
			return "ㅃ";
		else if (no >= '사' && no < '싸')
			return "ㅅ";
		else if (no >= '싸' && no < '아')
			return "ㅆ";
		else if (no >= '아' && no < '자')
			return "ㅇ";
		else if (no >= '자' && no < '짜')
			return "ㅈ";
		else if (no >= '짜' && no < '차')
			return "ㅉ";
		else if (no >= '차' && no < '카')
			return "ㅊ";
		else if (no >= '카' && no < '타')
			return "ㅋ";
		else if (no >= '타' && no < '파')
			return "ㅌ";
		else if (no >= '파' && no < '하')
			return "ㅍ";
		else if (no >= '하' && no <= 55203)
			return "ㅎ";
		else
			return " ";
	}

	/**
	 * 게임 문제 생성
	 * 
	 * @return 게임 문제가 저장된 리스트
	 */
	public ArrayList<Quest> makeGame() {

		ArrayList<Quest> rlist = new ArrayList<Quest>();

		
		//qlist 문제들을 랜덤으로 출제
		int[] lotto = new int[qlist.size()];
		
		outer : for (int i = 0; i < lotto.length;) {

			lotto[i] = new Random().nextInt(qlist.size()) ;
			
			for (int j=0;j<i;j++) {
				if (lotto[i] == lotto[j]) {
					continue outer;  //outer의 증감식으로 이동
					//break;
				}
			}
			
			//System.out.printf("%02d ", lotto[i]);
			i++;
		}
		
		
		for (int i = 0; i< qlist.size(); i++) {
			rlist.add(qlist.get(lotto[i]));
		}
		
		return rlist;
	}

}
