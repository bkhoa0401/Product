package com.ecommerce.wProductService.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LogService implements ILogService {

	private static final Logger logger = LoggerFactory.getLogger(LogService.class);
    @Override
    public void logRequest(HttpServletRequest request, Object body) {
        StringBuilder sb = new StringBuilder();

        sb.append("REQUEST ");
        sb.append("method=[").append(request.getMethod()).append("]");
        sb.append("path=[").append(request.getRequestURI()).append("]");

        if (body != null) {
            sb.append("body=[").append(body).append("]");
        }
        logger.info(sb.toString());
    }

    @Override
    public void logResponse(HttpServletRequest request, Object body) {
        StringBuilder sb = new StringBuilder();

        sb.append("RESPONSE ");
        sb.append("method=[").append(request.getMethod()).append("]");
        sb.append("path=[").append(request.getRequestURI()).append("]");
        sb.append("responseBody=[").append(body).append("]");

        logger.info(sb.toString());
    }

}
