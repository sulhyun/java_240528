package com.servlet.boot4.web.frontcontroller.v3.controller;

import java.util.Map;

import com.servlet.boot4.web.frontcontroller.ModelView;
import com.servlet.boot4.web.frontcontroller.v3.ControllerV3;

public class MemberFormControllerV3 implements ControllerV3 {

	@Override
	public ModelView process(Map<String, String> paramMap) {
		return new ModelView("form");
	}
	
}
