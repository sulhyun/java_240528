package com.servlet.boot04.web.frontcontroller.v3;

import java.util.Map;

import com.servlet.boot04.web.frontcontroller.ModelView;

public interface ControllerV3 {

	ModelView process(Map<String, String> paramMap);
	
}
