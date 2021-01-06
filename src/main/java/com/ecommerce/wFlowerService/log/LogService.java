package com.ecommerce.wFlowerService.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class LogService implements ILogService {

    @Override
    public void logRequest(HttpServletRequest request, Object body) {
        StringBuilder sb = new StringBuilder();

        sb.append("REQUEST ");
        sb.append("method=[").append(request.getMethod()).append("]");
        sb.append("path=[").append(request.getRequestURI()).append("]");

        if (body != null) {
            sb.append("body=[").append(body).append("]");
        }
        log.info(sb.toString());
    }

    @Override
    public void logResponse(HttpServletRequest request, Object body) {
        StringBuilder sb = new StringBuilder();

        sb.append("RESPONSE ");
        sb.append("method=[").append(request.getMethod()).append("]");
        sb.append("path=[").append(request.getRequestURI()).append("]");
        sb.append("responseBody=[").append(body).append("]");

        log.info(sb.toString());
    }

}
