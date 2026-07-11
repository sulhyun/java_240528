package com.core.boot03.web.service;

import org.springframework.stereotype.Service;

import com.core.boot03.common.MyLogger;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogDemoService {

	private final MyLogger myLogger;
	
	public void logic(String id) {
		myLogger.log("service id: " + id);
	}
}
