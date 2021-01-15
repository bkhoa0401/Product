package com.ecommerce.wFlowerService.controller;

import com.ecommerce.wFlowerService.entity.User;
import com.ecommerce.wFlowerService.entity.request.ChangePasswordRequest;
import com.ecommerce.wFlowerService.entity.request.LoginRequest;
import com.ecommerce.wFlowerService.entity.request.ResetPasswordRequest;
import com.ecommerce.wFlowerService.entity.response.BaseResponse;
import com.ecommerce.wFlowerService.entity.response.LoginResponse;
import com.ecommerce.wFlowerService.security.JwtTokenProvider;
import com.ecommerce.wFlowerService.security.bean.CustomUserDetails;
import com.ecommerce.wFlowerService.service.IUserService;
import com.ecommerce.wFlowerService.utils.ERRORCODE;
import com.ecommerce.wFlowerService.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    IUserService iUserService;

    // authen

    @PostMapping("/login")
    private ResponseEntity<BaseResponse> login(@RequestBody LoginRequest login) {

        try {
            Authentication authentication = authenticationManager.authenticate
                    (new UsernamePasswordAuthenticationToken(login.getLoginID(), login.getPassword()));
            String token = jwtTokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());

            User userResult = ((CustomUserDetails) authentication.getPrincipal()).getUser();

            LoginResponse loginResponse = new LoginResponse(userResult);
            loginResponse.setToken(token);
            return new ResponseEntity(loginResponse, HttpStatus.OK);

        } catch (DisabledException ex) {
            return new ResponseEntity(new BaseResponse(ERRORCODE.ACCOUNTISLOCKED), HttpStatus.OK);
        } catch (BadCredentialsException ex) {
            iUserService.increaseFailLoginCount(login.getLoginID());
            return new ResponseEntity(new BaseResponse(ERRORCODE.USERNAMEORPASSWORDNOTCORRECT), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/checkauth")
    private ResponseEntity<BaseResponse<Boolean>> checkAuth(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        boolean isExpire = iUserService.checkAuth(token);

        return new ResponseEntity(new BaseResponse(isExpire), HttpStatus.OK);
    }

    @PutMapping("/changepass")
    private ResponseEntity<BaseResponse> changePassword(HttpServletRequest request,
                                                        @RequestBody ChangePasswordRequest changePasswordRequest) {
        if (Utils.checkUserNameFTokenAndUserNameFromBIsMatched(request, changePasswordRequest.getUsername())) {
            return new ResponseEntity<>(iUserService.changePassword(changePasswordRequest), HttpStatus.OK);
        }
        return new ResponseEntity(new BaseResponse(ERRORCODE.TOKENNOTVALID), HttpStatus.UNAUTHORIZED);
    }

    @PutMapping("/resetpass")
    private ResponseEntity<BaseResponse> resetPassword(HttpServletRequest request,
                                                       @RequestBody ResetPasswordRequest resetPasswordRequest) {
        if (Utils.checkUserNameFTokenAndUserNameFromBIsMatched(request, resetPasswordRequest.getUsername())) {
            return new ResponseEntity<>(iUserService.resetPassword(resetPasswordRequest), HttpStatus.OK);
        }
        return new ResponseEntity(new BaseResponse(ERRORCODE.TOKENNOTVALID), HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    private ResponseEntity<BaseResponse> createUser(@RequestBody User user) {
        if (user != null) {
            return new ResponseEntity(iUserService.createUser(user), HttpStatus.OK);
        }
        return new ResponseEntity(new BaseResponse(ERRORCODE.FAIL), HttpStatus.BAD_REQUEST);
    }

    // manage user
    @GetMapping("/api/users")
    private ResponseEntity<BaseResponse> getUsers() {
       return new ResponseEntity(new BaseResponse(iUserService.getUsers()), HttpStatus.OK);
    }
}
