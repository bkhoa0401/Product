package com.ecommerce.wFlowerService.entity.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginResponse<T> extends BaseResponse{
    public LoginResponse(T mainResult){
       super(mainResult);
    }
    private String token;
}
