package com.fexco.rest.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fexco.rest.service.RestService;

@RestController
public class PassTroughRestController {

	@Autowired
	RestService restService;

	@RequestMapping(path = "/**", method = RequestMethod.GET, produces = "application/json")
	public String forwardRequest(HttpServletRequest req) {
		return restService.fetchResponseFromBackend(req);
	}
}
