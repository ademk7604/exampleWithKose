package s05_polymorphism;

public class Test {
	
	public static void main(String[] args) {
		Dog dogyy = new Dog();
		System.out.println(dogyy.hareket());
		Snake snake =new Snake();
		System.out.println(snake.hareket());
	}
	
	
	public static int toplama(int a, int b) {
		return a+b;
	}
	public static int toplama(int a, int b, int c) {
		return a+b+c;
	}
	
	public static int toplama(String  x, int y) {
		return 0; 
	}
	
	

}
class Animal{
	public String hareket() {
		return "hareket ederim.";
	}
	
}
class Dog extends Animal{
	public String hareket() {
		return "Kosarim.";
	}
}
class Snake extends Animal{
	
}
