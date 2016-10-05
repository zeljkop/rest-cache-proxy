package com.fexco.rest.service;

import javax.servlet.http.HttpServletRequest;

public interface RestService {

	String fetchResponseFromBackend(String uri, final HttpServletRequest req);
}
