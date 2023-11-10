package s01_Exam01;

import s02_InheritanceAndImpl.Car;

public class ObjectFactory {
	public static void main(String[] args) {
		Pen firstPen = new Pen();
		firstPen.setColor("red");
		firstPen.setHeight(10);;
		String message = "Firstpen produced";
		firstPen.writeMessage(message);
		firstPen.writeMessage(firstPen.getColor()+" "+firstPen.getHeight());
		
		Pen secondPen = new Pen();
		secondPen.setColor("green");
		secondPen.setHeight(8);
		secondPen.writeMessage(secondPen.getColor()+" "+secondPen.getHeight());
		
	}

}
