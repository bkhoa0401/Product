package com.ecommerce.wFlowerService.log;

import javax.servlet.http.HttpServletRequest;

public interface ILogService {
    void logRequest(HttpServletRequest request, Object body);
    void logResponse(HttpServletRequest request,Object body);
}
