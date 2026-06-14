package com.servlet.boot4.web.frontcontroller.v3;

import java.util.Map;

import com.servlet.boot4.web.frontcontroller.ModelView;

public interface ControllerV3 {

	ModelView process(Map<String, String> paramMap);
	
}
