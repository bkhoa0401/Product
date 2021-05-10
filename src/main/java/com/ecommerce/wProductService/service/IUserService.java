package com.ecommerce.wProductService.service;

import com.ecommerce.wProductService.entity.User;
import com.ecommerce.wProductService.entity.request.ChangePasswordRequest;
import com.ecommerce.wProductService.entity.request.ResetPasswordRequest;
import com.ecommerce.wProductService.entity.response.BaseResponse;

import java.util.List;

public interface IUserService {

    //manage user
    BaseResponse createUser(User user);
    List<User> getUsers();
    void increaseFailLoginCount(String username);


    // authen
    boolean checkAuth(String token);
    BaseResponse changePassword(ChangePasswordRequest changePasswordRequest);
    BaseResponse resetPassword(ResetPasswordRequest resetPasswordRequest);
}
