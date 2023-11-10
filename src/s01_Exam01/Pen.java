package s01_Exam01;

import java.util.concurrent.CopyOnWriteArrayList;

public class Pen {
	private String color;
	private int height;
	
	void writeMessage(String message) {
		System.out.println("Your Message : "+message);
	}
	
	public void setColor(String color) {
		if("red".equals(color) || "green".equals(color) || "back".equals(color)) {
			this.color=color;
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	public String getColor() {
		return color;
	}
	
	public void setHeight(int height) {
		this.height=height;
	}
	
	public int getHeight() {
		return height;
	}

}
