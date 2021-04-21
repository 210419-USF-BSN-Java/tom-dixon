package assignment01;

public class App {
	
	public static void main(String[] args) {
		Assignment1 a1 = new Assignment1();
		
		System.out.println(a1.printNumberInWord(7)); // SEVEN
		System.out.println(a1.printNumberInWord(10)); // OTHER

		System.out.println(a1.reverse("hello")); // olleh
		System.out.println(a1.reverse2("hello")); // olleh
	}

}
