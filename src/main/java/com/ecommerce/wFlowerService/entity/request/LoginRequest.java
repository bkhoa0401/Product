package com.ecommerce.wFlowerService.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String loginID;
    private String password;
}
