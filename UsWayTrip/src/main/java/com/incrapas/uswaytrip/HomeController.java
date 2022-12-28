package com.incrapas.uswaytrip;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import common.ViewPath;


@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		//return ViewPath.MAIN + "index.jsp";
		return ViewPath.USER + "index.jsp";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return ViewPath.USER + "index.jsp";
	}
	
}
