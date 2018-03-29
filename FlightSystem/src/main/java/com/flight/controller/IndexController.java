package com.flight.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 * 主页跳转
 */
@Controller
public class IndexController {

	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
}
