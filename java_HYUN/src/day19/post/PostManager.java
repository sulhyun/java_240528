package day19.post;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class PostManager implements Program {
	
	private Scanner sc = new Scanner(System.in);
	private List<Post> list = new ArrayList<Post>();
	private int menu;
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;
	
	private String fileName = "src/day19/exam/data.txt";
	
	@Override
	public void printMenu() {
		System.out.println("---------------------");
		System.out.println("메뉴");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 조회");
		System.out.println("5. 프로그램 종료");
		System.out.println("---------------------");
		System.out.print("메뉴 입력 : ");
	}


	@Override
	public void run() {
		load(fileName);
		do {
			// 메뉴 출력
			printMenu();
			try {
				// 메뉴 선택
				menu = sc.nextInt();
				printBar();
				// 선택한 메뉴 실행
				runMenu(menu);
			} catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("잘못된 입력입니다.");
			} catch(Exception e) {
				System.out.println("예외가 발생했습니다.");
				e.printStackTrace();
			}
		} while(menu != EXIT);
		
		save(fileName);
	}
	
	@Override
	public void load(String fileName) {
		
	}
	
	@Override
	public void save(String fileName) {
		
	}
	
	@Override
	public void runMenu(int menu) throws Exception {
		switch(menu) {
		case INSERT:
			insert();
			break;
		case UPDATE:
			update();
			break;
		case DELETE:
			delete();
			break;
		case SEARCH:
			search();
			break;
		case EXIT:
			exit();
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}

	private void exit() {
		printBar();
		System.out.println("프로그램을 종료합니다.");
		printBar();
	}


	private void search() {
		// 검색어 입력
		printBar();
		sc.nextLine();
		System.out.print("검색어(전체는 엔터) : ");
		String search = sc.nextLine();
		printBar();
		// 게시글에서 검색어가 제목 또는 내용에 들어간 게시글 리스트를 가져옴
		System.out.println("검색결과");
		for (Post tmp : list) {
			if(tmp.getTitle().contains(search) && tmp.getContents().contains(search)) {
				System.out.println(tmp);
			}
		}
		// 게시글 리스트가 비어 있으면 안내문구 출력 후 종료
		
		// 가져온 게시글 리스트를 출력
		
		// 게시글을 확인할건지 선택
		
		// 확인하지 않겠다고 하면 종료
		
		// 확인하면 게시글 번호를 입력
		
		// 입력받은 게시글 번호로 객체를 생성
		
		// 검색 리스트에서 생성된 객체와 일치하는 번지를 확인
		
		// 번지가 유효하지 않으면 안내문구 출력후 종료
		
		// 번지에 있는 게시글을 가져옴
		
		// 가져온 게시글을 출력
		
		// 메뉴로 돌아가려면... 문구 출력
		
		// 엔터를 입력받도록 처리
	}


	private void delete() {
		//삭제할 게시글 번호를 입력
		printBar();
		System.out.print("삭제할 게시글 번호 : ");
		int num = sc.nextInt();
		printBar();
		//게시글 번호에 맞는 게시글을 가져옴
		Post post = selectPost(num);
		//게시글이 없으면 종료
		if(post == null) {
			return;
		}
		//리스트에서 게시글을 삭제
		printBar();
		list.remove(post);
		System.out.println(post.getNum() + "번 게시글이 삭제되었습니다.");		
	}

	private void update() {
		// 수정할 게시글 번호를 입력
		printBar();
		System.out.print("수정할 게시글 번호 : ");
		int num = sc.nextInt();
		printBar();
		//게시글 번호에 맞는 게시글을 가져옴
		Post post = selectPost(num);
		//게시글이 없으면 종료
		if(post == null) {
			return;
		}
		// 같으면 새 제목과 내용을 입력
		printBar();
		sc.nextLine();
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String contents = sc.nextLine();
		// 가져온 객체의 제목과 내용을 입력받은 제목과 내용으로 수정
		post.update(title, contents);
		// 안내문구 출력
		printBar();
		System.out.println(post.getNum() + "번 게시글이 추가되었습니다.");
	}

	private void insert() {
		// 게시글 정보를 입력
		sc.nextLine();
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String contents = sc.nextLine();
		System.out.print("작성자 : ");
		String id = sc.next();
		System.out.print("비번 : ");
		String pw = sc.next();
		// 입력한 정보를 이용해서 게시글 객체를 생성
		Post post = new Post(title, contents, id, pw);
		// 생성한 게시글 객체를 리스트에 추가
		list.add(post);
		// 알림문구를 출력
		printBar();
		System.out.println(post.getNum() + "번 게시글이 추가되었습니다.");
		System.out.println(list);
	}
	
	public void printBar() {
		System.out.println("---------------------");
	}
	
	// 게시글 번호가 주어지면 게시글을 가져오는 메소드
	public Post selectPost(int num) {
		// 입력한 게시글 번호를 이용하여 게시글 객체를 생성
		Post post = new Post(num);
		// 리스트에서 생성한 객체가 몇번지 있는지 번지를 가져옴
		int index = list.indexOf(post);
		// 일치하는 객체가 없으면(가져온 번지가 0보다 작으면) 알림문구 출력 후 종료
		if(index < 0) {
			printBar();
			System.out.println("등록되지 않거나 삭제된 게시글 입니다.");
			return null;
		}
		// 아이디, 비번을 입력 받음
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비번 : ");
		String pw = sc.next();
		// 가져온 객체의 아이디와 비번이 입력받은 아이디와 비번과 같은지 확인해서
		post = list.get(index);
		if(!post.checkWriter(id, pw)) {
			// 같지 않으면 안내문구 출력 후 종료
			System.out.println("아이디와 비밀번호가 일치하지 않습니다");
			return null;
		}	
		return post;
	}
}
