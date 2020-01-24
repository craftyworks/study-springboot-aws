package com.ddam40.study.springboot.aws.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
  @GetMapping("/")
  public String index() {
    return "index";
  }
	
}