package training.hl.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorsController
{
	@RequestMapping(value="/404.html")
	public String get404()
	{
		return "404";
	}
	
	@RequestMapping(value="/400.html")
	public String get400()
	{
		return "400";
	}
	
	@RequestMapping(value="/500.html")
	public String get500()
	{
		return "500";
	}
	
	@RequestMapping(value="/503.html")
	public String get503()
	{
		return "503";
	}
	
	@RequestMapping(value="/408.html")
	public String get408()
	{
		return "408";
	}
	
}
