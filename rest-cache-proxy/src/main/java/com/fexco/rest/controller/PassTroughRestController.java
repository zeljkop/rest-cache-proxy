package com.fexco.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pcw/**")
public class PassTroughRestController {

	@RequestMapping(method = RequestMethod.GET)
	public String forwardRequest() {
		return null;
	}
}
