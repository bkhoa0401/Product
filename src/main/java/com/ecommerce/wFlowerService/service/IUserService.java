package com.ecommerce.wFlowerService.service;

import com.ecommerce.wFlowerService.entity.User;
import com.ecommerce.wFlowerService.entity.request.ChangePasswordRequest;
import com.ecommerce.wFlowerService.entity.request.ResetPasswordRequest;
import com.ecommerce.wFlowerService.entity.response.BaseResponse;

public interface IUserService {
    void createUser(User user);
    boolean checkAuth(String token);
    BaseResponse changePassword(ChangePasswordRequest changePasswordRequest);
    BaseResponse resetPassword(ResetPasswordRequest resetPasswordRequest);
}
