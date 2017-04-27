package quiz;

import frame.Quiz;

public class CloverChance implements Quiz {

	@Override
	public int make() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String[] story() {
		String[] msg = {"네잎클로버를 찾으셨습니다. ",
				        "1칸 전진합니다..."  };
		return msg;
		
	}

}
