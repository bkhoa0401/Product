package com.ecommerce.wFlowerService.service;

import com.ecommerce.wFlowerService.entity.User;
import com.ecommerce.wFlowerService.entity.request.ChangePasswordRequest;
import com.ecommerce.wFlowerService.entity.request.ResetPasswordRequest;
import com.ecommerce.wFlowerService.entity.response.BaseResponse;

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
