package com.ecommerce.wProductService.entity.request;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String loginID;
    private String password;

    @Override
    public String toString() {
        return "LoginRequest{" +
                "loginID='" + loginID + '\''+
                '}';
    }
}
