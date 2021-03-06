package assignment01;
import java.util.Arrays;
import java.util.Collections;

public class Assignment1 {

		public String printNumberInWord(int number) {
			String result;
			switch(number) {
			case(0):
				result = "ZERO";
				break;
			case(1):
				result = "ONE";
				break;
			case(2):
				result = "TWO";
				break;
			case(3):
				result = "THREE";
				break;
			case(4):
				result = "FOUR";
				break;		
			case(5):
				result = "FIVE";
				break;
			case(6):
				result = "SIX";
				break;
			case(7):
				result = "SEVEN";
				break;
			case(8):
				result = "EIGHT";
				break;
			case(9):
				result = "NINE";
				break;
			default:
				result = "OTHER";
			
			}
				
				return result;
}

		public String reverse(String string) {
			String reversed = "";
			// Split string
			String[] strArr = string.split("");
			// Reverse
			Collections.reverse(Arrays.asList(strArr));
			// Join
			for(String s: strArr) {
				reversed = reversed.concat(s);
			}
			return reversed;
		}
		
		public String reverse2(String string) {
			String reversed = "";
			// Split string
			String[] strArr = string.split("");

			// Reverse and join
			for(int i = string.length() - 1; i >= 0; i-- ) {
				reversed = reversed.concat(strArr[i]);
			}
			return reversed;
		}
}


