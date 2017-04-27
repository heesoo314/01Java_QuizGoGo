package splash;

public class Splash {

	static public void displaySplash(int stage) {
		System.out.println();
		System.out.println();
		System.out.println("************************************************************");
		System.out.println("*                                                          *");
		System.out.println("*                퀴즈 고고~~      (" + stage + ") 단계                 *");
		System.out.println("*                                                          *");
		System.out.println("************************************************************");
		
		System.out.println();
		System.out.println();

		//④①②③④⑤⑥⑦⑧⑨⑩⑪⑫⑬⑭⑮▣●↓▼
		
      //displayStage(0);
	}
	
	static public void displayStage(int stage) {

		String space = "  ";

		for (int i = 1; i < stage; i++) {
			space += "    ";
		}
		 
		if (stage != 0) {
			System.out.print(space + "▼");
		}
		System.out.println();
		System.out.println("┏━┳━┳━┳━┳━┳━┳━┳━┳━┳━┳━┳━┳━┳━┳━┓");
		System.out.println("┃①┃②┃③┃④┃⑤┃⑥┃⑦┃⑧┃⑨┃⑩┃⑪┃⑫┃⑬┃⑭┃⑮┃");
		System.out.println("┗━┻━┻━┻━┻━┻━┻━┻━┻━┻━┻━┻━┻━┻━┻━┛");
		System.out.println();
	}
	
	static public void clear() {
		for (int i=0;i<80;i++) {
			System.out.println();
		}
			

	}
}
