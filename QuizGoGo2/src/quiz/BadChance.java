package quiz;

import frame.Quiz;

public class BadChance implements Quiz {

	@Override
	public int make() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] story() {
		String[] msg = {"정글 밀림속에 갇혀버렸습니다.  ",
				        "-1칸 되돌아갑니다...."  };
		return msg;
		
	}

}
