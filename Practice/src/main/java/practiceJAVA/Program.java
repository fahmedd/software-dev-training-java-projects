package practiceJAVA;

public class Program {

	public static int countWords(String s) {
		//Word count//
		String[] SplitString = s.split(" ");
//		
//	    int count= 1;	    
//		for (int i=0; i<SplitString.length -1; i++) {
//			System.out.println(count++);
//		}
		return SplitString.length;   //return s.split(" ").length;
	}
	
	// s.split("")- character count
//}
//if (str1.charAt(i) == ' ') 
//{
//    wordCount++;
//} 

//////////////////////////
//public static boolean isEqual(int num1, int num2) {
//	boolean ifEqual= false;
//		if (num1 == num2){
//			ifEqual= true;
//		} else {
//			ifEqual= false;
//		}
//	return ifEqual;
//}
/////// 	public static boolean isEqual(int num1, int num2) {
//if(num1 == num2)
//	return true;
//else
//	return false;
//}

//return ((num1 - num2) == 0) ? true : false;


public static int countTrue(boolean[] arr) {
	int count=0;
	for(int i=0; i< arr.length; i++){
		if (arr[i] == true){
			count++;
			//System.out.println(count);
		}
	}
	return count;
}

}

