package practiceJAVA;

public class MainPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
		Program program= new Program();
		System.out.println(program.countWords("hi my name is"));
		
//		String s="Hi my name is";
//		String[] SplitString = s.split("\\s*");
//		
//	    int count= 1;
//	    
//		for (int i=0; i<SplitString.length; i++) {
//			System.out.println(count++);
//		}
		
		boolean[] firstArray= {true, true, false, true, false};
		System.out.println(program.countTrue(firstArray));
		
		//program.countTrue(firstArray);
	}

}
