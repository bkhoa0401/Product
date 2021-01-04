package com.ecommerce.wFlowerService.entity.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordRequest {
    private String username;
    private String oldPass;
    private String newPass;
}
