package practice;

public class ClassEx02 {

	public static void main(String[] args) {
		
		SutdaDeck deck = new SutdaDeck();
		
		for(int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ",");
		}
		System.out.println();
		
		deck.Shuffle();
		
		for(int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + ",");
		}
		System.out.println();
		
		System.out.println(deck.pick(5));
		System.out.println(deck.pick());
	}

}

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	SutdaDeck() {
		for(int i = 0; i < CARD_NUM; i++) {
			if(i == 0 || i == 2 || i == 7) {
				cards[i] = new SutdaCard(i + 1, true);
			}
			else {
				cards[i] = new SutdaCard(i % 10 + 1, false);
			}
		}
	}
	
	void Shuffle() {
		SutdaCard tmp;
		int min = 0, max = 19;
		for(int i = 0; i < cards.length; i++) {
			int random = (int)(Math.random() * (max - min + 1) + min);
			tmp = cards[random];
			cards[random] = cards[i];
			cards[i] = tmp;
		}
	}
	
	SutdaCard pick(int index) {
		if(0 > index || CARD_NUM - 1 < index) {
			return null;
		}
		return cards[index];
	}
	
	SutdaCard pick() {
		int min = 0, max = 19;
		int random = (int)(Math.random() * (max - min + 1) + min);
		return cards[random];
	}
	
}

class SutdaCard {
	int num;
	boolean isKwang;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang){
		this.num = num;
		this.isKwang = isKwang;
	}
	
	@Override
	public String toString() {
		return num + (isKwang ? "K" : "");
	}

}
