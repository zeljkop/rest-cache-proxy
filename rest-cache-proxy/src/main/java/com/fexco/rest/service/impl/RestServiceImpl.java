package com.fexco.rest.service.impl;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fexco.rest.service.RestService;

@Service
public class RestServiceImpl implements RestService {

	static final Logger LOG = LoggerFactory.getLogger(RestServiceImpl.class);

    @Value("${rest.api.protocol}")
    String protocol;

    @Value("${rest.api.host}")
    String host;

    @Value("${rest.api.port}")
    String port;

    @Value("${rest.api.key}")
    String apiKeyl;

    @Autowired
    RestTemplate rt;

    private String baseUrl;

    @PostConstruct
    private void init() {
    	this.baseUrl = protocol	.concat(host)
    							.concat(port.isEmpty() ? "" : ":")
    							.concat(port);
    }

	@Override
	@Cacheable(key = "#uri", cacheNames = {"rspEntityCache"})
	public String fetchResponseFromBackend(String uri, HttpServletRequest req) {
		String url = this.baseUrl	.concat(req.getRequestURI())
									.concat(req.getQueryString() == null ? "" : req.getQueryString());
		LOG.info(">>>>>>> {}", url);
		return rt.exchange(url, HttpMethod.GET, null, String.class, new Object[]{}).getBody();
	}

}
