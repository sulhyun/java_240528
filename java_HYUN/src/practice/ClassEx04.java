package practice;

public class ClassEx04 {
	
	/* 메서드
	 * 1. 한가지 기능만 수행하도록 하는것이 좋음
	 * 2. 반복적으로 수행되어야 하는 여러 문장을 하나의 메서드로 정의하는 것이 좋음
	 * 3. 관련된 여러 문장을 하나의 메서드로 만드는것이 좋음*/
	
	public static void main(String[] args) {
		
		MyTv2 t = new MyTv2();
		
		t.setChannel(10);
		System.out.println("CH: " + t.getChannel());
		
		t.setVolume(20);
		System.out.println("VOL: " + t.getVolume());
		
	}
}

class MyTv2 {
	private boolean isPowerOn;
	private int channel;
	private int volume;
	private int preChannel;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	public boolean isPowerOn() {
		return isPowerOn;
	}
	public void setPowerOn(boolean isPowerOn) {
		this.isPowerOn = isPowerOn;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		if(channel > MAX_CHANNEL || channel < MIN_CHANNEL) {
			return;
		}
		this.channel = channel;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		if(volume > MAX_VOLUME || volume < MIN_VOLUME) {
			return;
		}
		this.volume = volume;
	}
	
	
}
