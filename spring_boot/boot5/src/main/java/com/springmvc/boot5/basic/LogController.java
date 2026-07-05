package com.springmvc.boot5.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@GetMapping("/log")
	public String log() {
		String name = "Spring";
		
		/**
		 *  System.out.println();
		 *  -> 실무에서는 사용하지 않음.
		 *  이유: 개발, 운영 서버에서 로그가 다 찍힘
		 *   에러가 나와도 어디서 문제가 있는지 찾기 힘듦
		 */
		System.out.println("name: " + name);
		
		/**
		 * 로그가 출력되는 포멧
		 * -> 시간, 로그 레벨, 프로세스ID, 쓰레드 명, 클래스명, 로그 메시지
		 * 
		 * 로그 레벨
		 * -> TRACE > DEBUG > INFO > WARN > ERROR
		 * 개발 서버: debug 출력
		 * 운영 서버: info 출력
		 */
		log.trace("[TRACE] name: {}", name);
		log.debug("[DEBUG] name: {}", name);
		log.info("[INFO] name: {}", name);
		log.warn("[WARN] name: {}", name);
		log.error("[ERROR] name: {}", name);
		
		return "ok";
	}
	
}
