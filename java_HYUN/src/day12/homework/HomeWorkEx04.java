package day12.homework;

public class HomeWorkEx04 {

	public static void main(String[] args) {
		
		MyTv t = new MyTv();
		
		t.channel = 100;
		t.volume = 0;
		System.out.println("CH : " + t.channel + ", VOL : " + t.volume);
		
		t.channelDown();
		t.volumDown();
		System.out.println("CH : " + t.channel + ", VOL : " + t.volume);
		
		t.volume = 100;
		t.channelUp();
		t.volumUp();
		System.out.println("CH : " + t.channel + ", VOL : " + t.volume);
	}

}

class MyTv {
	
	boolean isPowerOn;
	int channel;
	int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 100;
	
	// isPowerOn의 값이 true => false, false => true
	void turnOnOff() {
		isPowerOn = !isPowerOn;
	}
	
	// volume 의 값이 MAX_VOLUME 보다 작을때만 값을 1증가시킨다.
	void volumUp() {
		if(volume >= MAX_VOLUME) {
			return;
		}
		
		++volume;
	}
	
	// volume 의 값이 MIN_VOLUME 보다 클 때만 값을 1감소시킨다
	void volumDown() {
		if(volume <= MIN_VOLUME) {
			return;
		}
		
		--volume;
	}
	
	/* channel 의 값을 1증가시킨다.
	 * 만약 channel 이 MAX_CHANNEL 이면, channel 의 값을 MIN_CHANNEL로 바꾼다.*/
	void channelUp() {
		if (channel == MAX_CHANNEL) {
			channel = MIN_CHANNEL;
		}
		
		++channel;
	}
	
	/* channel 의 값을 1감소시킨다.
	 * 만약 channel 이 MIN_CHANNEL 이면, channel 의 값을 MAX_CHANNEL로 바꾼다.*/
	void channelDown() {
		if (channel == MIN_CHANNEL) {
			channel = MAX_CHANNEL;
		}
		
		--channel;
	}
	
	
	
	
	
	
}