package day10;

import java.util.Scanner;

public class VocabularyEx01 {

	/* 메뉴
	 * 1. 단어 등록
	 * 2. 단어 수정
	 * 3. 단어 검색
	 * 4. 단어 삭제
	 * 5. 종료
	 * 메뉴 선택 : 
	 * */

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		final int WORD_MAX = 2; // 
		Word[] list = new Word[WORD_MAX]; // 단어 리스트
		int wordCount = 0; // 저장된 단어 갯수
		int menu; // 메뉴
		String word, wordClass, meaning;
		Word tmp;
		int index;
		// 반복 : 종료를 선택하지 않을 때까지
		do {
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			menu = scan.nextInt();
			// 선택한 메뉴에 따른 기능 실행
			switch(menu) {
			case 1:
				if(wordCount == list.length) {
					System.out.println("더이상 등록할 수 없습니다.");
					break;
				}
				// 단어 정보(단어, 품사, 의미)를 입력
				System.out.print("단어 입력 : ");
				word = scan.next();
				System.out.print("품사 입력 : ");
				wordClass = scan.next();
				System.out.print("의미 입력 : ");
				meaning = scan.next();
				// 입력한 단어 정보를 이용하여 단어 객체를 생성
				tmp = new Word(word, wordClass, meaning);
				// 단어 리스트에 단어 객체를 저장 => 마지막으로 저장된 위치 다음에 단어 객체를 저장
				list[wordCount] = tmp;
				list[wordCount].print();
				// 저장된 단어 개수를 1 증가
				wordCount++;
				// 단어 리스트를 정렬(알파벳순으로)
				// 문자열1이 앞이면 음수
				// 문자열1이 뒤이면 양수
				for (int i = 0; i < wordCount - 1; i++) {
					for (int j = 0; j < wordCount - 1 - i; j++) {
						if(list[j].getWord().compareTo(list[j+1].getWord()) > 0) {
							Word str = list[j];
							list[j] = list[j + 1];
							list[j + 1] = str;
						}
					}
				}
				// 문자열이 순서대로 정렬됐는지 확인
				int num = 1;
				for (Word word2 : list) {
					if(word2 != null) {
						System.out.println(num + ". " + word2.getWord());
					}
					num++;
				}
				break;
			case 2:
				// 단어를 입력
				System.out.print("단어 입력 : ");
				word = scan.next();
				index = -1;
				// 입력받은 단어로 객체 생성
				tmp = new Word(word, "", "");
				// tmp list 둘 중 하나라도 초기화 되있지 않으면 index -1 저장
				if (tmp != null || list != null) {
					index = -1;
				}
				// tmp 단어가 list 단어 중에 있다면 i를 index에 저장
				for(int i = 0; i < wordCount; i++) {
					if(tmp.getWord().equals(list[i].getWord())) {
						index = i;
						break;
					}

				}
				System.out.println("단어 수정 기능 구현 중입니다.");
				System.out.print("단어 입력 : ");
				word = scan.next();
				System.out.print("품사 입력 : ");
				wordClass = scan.next();
				System.out.print("의미 입력 : ");
				meaning = scan.next();
				list[index].updateWord(word, wordClass, meaning);
				list[index].print();
				break;
			case 3:
				// 단어를 입력
				System.out.print("단어 입력 : ");
				word = scan.next();
				index = -1;
				// 입력받은 단어로 객체 생성
				tmp = new Word(word, "", "");
				// tmp list 둘 중 하나라도 초기화 되있지 않으면 index -1 저장
				if (tmp != null || list != null) {
					index = -1;
				}
				// tmp 단어가 list 단어 중에 있다면 i를 index에 저장
				for(int i = 0; i < wordCount; i++) {
					if(tmp.getWord().equals(list[i].getWord())) {
						index = i;
						break;
					}
				}
				// 일치하는 단어가 없다면
				if (index == -1) {
					System.out.println("일치하는 단어가 없습니다.");
					break;
				}
				System.out.println("단어 검색 기능 구현중입니다.");
				// 있다면 해당 객체를 출력
				list[index].print();	
				break;
			case 4: 
				// 단어를 입력
				System.out.print("단어 입력 : ");
				word = scan.next();
				index = -1;
				// 입력받은 단어로 객체 생성
				tmp = new Word(word, "", "");
				// tmp list 둘 중 하나라도 초기화 되있지 않으면 index -1 저장
				if (tmp != null || list != null) {
					index = -1;
				}
				// tmp 단어가 list 단어 중에 있다면 i를 index에 저장
				for(int i = 0; i < wordCount; i++) {
					if(tmp.getWord().equals(list[i].getWord())) {
						index = i;
						break;
					}
				}
				System.out.println("단어 삭제 기능 구현중입니다.");
				// 해당 객체를 생성자를 이용하여 초기화
				list[index] = new Word();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
			}
		} while(menu != 5);
	}
	/* 기능 : 메뉴를 출력*/
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 단어 등록");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 검색");
		System.out.println("4. 단어 삭제");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택 : ");
	}


	/** 기능 : 단어 배열과 검색할 단어 정보가 주어지면 몇 번지에 있는지 알려주는 메서드
	 * @param list 단어 배열
	 * @param tmp 검색할 단어 정보
	 * @param wordCount 비교할 단어 수
	 * @return 검색한 단어 정보의 위치(번지)가 없으면 -1을 반환 */
	public static int indexOf(Word[] list, int count, Word tmp) {
		if(list == null || tmp == null) {
			return -1;
		}
		for(int i = 0; i < count; i++) {
			// 단어가 같으면
			if (tmp.getWord().equals(list[i].getWord())) {
				return i;
			}
		}
		return -1;
	}	


/* 영어 단어를 관리하기 위한 Word 클래스를 만들고,
	 * 필요한 멤버변수들을 선언해보세요.
	 * */
}
class Word {
	// 단어, 뜻, 품사(명사,동사,형용사)
	private String word, meaning, wordClass;

	// 디폴트 생성자
	public Word() {}
	// 생성자
	public Word(String word, String wordClass, String meaning) {
		this.word = word;
		this.wordClass = wordClass;
		this.meaning = meaning;
	}

	// 필요한 기능
	/* 기능 : 단어를 출력하는 메소드
	 * */
	public void print() {
		System.out.println("--------------------");
		System.out.println("단어 : " + word);
		System.out.println("품사 : " + wordClass);
		System.out.println("의미 : " + meaning);
		System.out.println("--------------------");
	}

	public void updateWord(String word, String wordClass, String meaning) {
		this.word = word;
		this.wordClass = wordClass;
		this.meaning = meaning;
	}

	// getter setter
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public String getWordClass() {
		return wordClass;
	}
	public void setWordClass(String wordClass) {
		this.wordClass = wordClass;
	}


}