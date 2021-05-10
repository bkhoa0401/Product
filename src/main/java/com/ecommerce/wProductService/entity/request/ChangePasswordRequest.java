package com.ecommerce.wProductService.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordRequest {
    private String username;
    private String oldPass;
    private String newPass;

    @Override
    public String toString() {
        return "ChangePasswordRequest{" +
                "username='" + username + '\'' +
                '}';
    }
}
