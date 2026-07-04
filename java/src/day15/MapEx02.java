package day15;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapEx02 {

	public static void main(String[] args) {
		
		// Map 을 이용한 반복문 예제
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("2024160001", "고길동");
		map.put("2024160002", "홍길동");
		map.put("2024135001", "임꺽정");
		
		// 방법1. keySet을 이용하여 set 으로 만든후 set 을 반복문을 이용하여 원하는 작업
		
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		
		// 방법2. EntrySet 을 이용. Entry 클래스를 이용하여 set 으로 만들고, 반복문을 활용
		
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		
		Iterator<Map.Entry<String, String>> it2 = entrySet.iterator();
		
		while(it2.hasNext()) {
			Map.Entry<String, String> tmp = it2.next();
			String key = tmp.getKey();
			String value = tmp.getValue();
			System.out.println(key + " : " + value);
		}
	}

}
