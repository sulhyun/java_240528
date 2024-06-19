package practice;

public class ClassEx05 {

	public static void main(String[] args) {
		
		CaptionTv ctv = new CaptionTv(false, 10, false);
		ctv.channel = 10;
		ctv.channelDown();
		ctv.displayCaption("Hello World");
		ctv.caption = true;
		ctv.displayCaption("Hello World");
		ctv.power();
		ctv.displayCaption("Hello World");
		
	}

}

class Tv{
	
	boolean power;
	int channel;
	
	void power() {
		power = !power;
	}
	
	void channelUp() {
		++channel;
	}
	
	void channelDown() {
		--channel;
	}
	
	public Tv(boolean power, int channel) {
		this.power = power;
		this.channel = channel;
	}
}

class CaptionTv extends Tv {
	
	boolean caption;
	
	public CaptionTv(boolean power, int channel, boolean caption) {
		super(power, channel);
		this.caption = caption;
	}
	
	void displayCaption(String text) {
		if(caption && power) {
			System.out.println(text);
		}
	}
}