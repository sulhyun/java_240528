package day15;

import java.util.HashMap;

public class MapEx01 {

	public static void main(String[] args) {
		
		// Map 기본예제
		// key 중복 불가능 value 중복 가능
		HashMap<String, String> map = new HashMap<String, String>();
		
		/* put(key, value) : key 와 value 를 추가, 이미 key 가 등록되어 있으면
		 * 새 value 를 저장하고 기존 value 를 반환 (덮어쓰기)*/
		
		map.put("admin", "admin123");
		System.out.println(map.put("admin", "admin12345"));
		
		System.out.println(map);
		
		/* remove(key) : 주어진 key 와 일치하는 키가 있으면 삭제하고 value 를 반환 */
		
		System.out.println(map.remove("admin"));
		
		System.out.println(map);
		
		map.put("abc123", "def123");
		map.put("asdasd", "def123");
		
		System.out.println(map);
		
		/* containsKey(key) : 주어진 key 와 일치하는 키가 있는지 없는지 반환*/
		System.out.println(map.containsKey("admin"));
		System.out.println(map.containsKey("asdasd"));
	}

}
