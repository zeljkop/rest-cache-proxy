package com.fexco.rest.service;

import javax.servlet.http.HttpServletRequest;

public interface RestService {

	String fetchResponseFromBackend(final HttpServletRequest req);
}
