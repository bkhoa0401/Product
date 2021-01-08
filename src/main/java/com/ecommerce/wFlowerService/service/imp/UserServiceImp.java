package com.ecommerce.wFlowerService.service.imp;

import com.ecommerce.wFlowerService.entity.Role;
import com.ecommerce.wFlowerService.entity.User;
import com.ecommerce.wFlowerService.entity.request.ChangePasswordRequest;
import com.ecommerce.wFlowerService.entity.request.ResetPasswordRequest;
import com.ecommerce.wFlowerService.entity.response.BaseResponse;
import com.ecommerce.wFlowerService.repository.IRoleRepository;
import com.ecommerce.wFlowerService.repository.IUserRepository;
import com.ecommerce.wFlowerService.security.JwtTokenProvider;
import com.ecommerce.wFlowerService.security.bean.CustomUserDetails;
import com.ecommerce.wFlowerService.service.IUserService;
import com.ecommerce.wFlowerService.utils.ERRORCODE;
import com.ecommerce.wFlowerService.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements IUserService, UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    IRoleRepository roleRepository;

    @Value("${fail.login.count}")
    private int failLoginCount;

    @Bean
    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // authen
    @Override
    public boolean checkAuth(String token) {
        return tokenProvider.validateToken(token);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

    @Override
    public BaseResponse changePassword(ChangePasswordRequest changePasswordRequest) {
        User user = userRepository.findUserByUsername(changePasswordRequest.getUsername());
        if (user == null) {
            return new BaseResponse(ERRORCODE.USERNOTFOUND);
        }
        if (!passwordEncoder().matches(changePasswordRequest.getOldPass(), user.getPassword())) {
            return new BaseResponse(ERRORCODE.PASSWORDNOTMATHCED);
        }
        user.setPassword(passwordEncoder().encode(changePasswordRequest.getNewPass()));
        userRepository.save(user);

        return new BaseResponse("Change password success");
    }

    @Override
    public BaseResponse resetPassword(ResetPasswordRequest resetPasswordRequest) {
        User user = userRepository.findUserByUsername(resetPasswordRequest.getUsername());
        if (user == null) {
            return new BaseResponse(ERRORCODE.USERNOTFOUND);
        }
        String newPass = Utils.generateKey(7);
        user.setPassword(passwordEncoder().encode(newPass));
        userRepository.save(user);

        return new BaseResponse(newPass + " is new password");
    }

    // manage user
    @Override
    public BaseResponse createUser(User user) {
        //user.setPassword(passwordEncoder().encode(Utils.generateKey(7)));

        User userIsExist = userRepository.findUserByUsername(user.getUsername());
        if (userIsExist != null) {
            return new BaseResponse(ERRORCODE.USERNAMEISEXIST);
        }

        user.setPassword(passwordEncoder().encode("12wqasxz"));
        user.setEnable("T");

        Role userRole = roleRepository.findRoleByName("ROLE_USER");
        user.setRoleID(userRole);
        userRepository.save(user);
        return new BaseResponse();
    }

    @Override
    public List<User> getUsers() {
        Role userRole = roleRepository.findRoleByName("ROLE_USER");
        List<User> users = userRepository.findUserByRoleID(userRole);

        return users;
    }

    @Override
    public void increaseFailLoginCount(String username) {
        User user = userRepository.findUserByUsername(username);
        int failLogin = user.getFailLoginCount();
        if (failLogin == failLoginCount) {
            user.setEnable("F");
        } else {
            failLogin = failLogin + 1;
            user.setFailLoginCount(failLogin);
        }
        userRepository.save(user);
    }
}
