package com.system.travelmanagement.service.impl;
import com.system.travelmanagement.Entity.User;
import com.system.travelmanagement.Pojo.UserPojo;
import com.system.travelmanagement.Repo.UserRepo;
import com.system.travelmanagement.config.PasswordEncoderUtil;
import com.system.travelmanagement.exception.AppException;
import com.system.travelmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;


    @Override
    public String saveUser(UserPojo userPojo) {

        User user = new User();


        user.setEmail(userPojo.getEmail());
        user.setFullname(userPojo.getFullname());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));
        userRepo.save(user);
        return "Created";

    }

    @Override
    public UserPojo findByEmail(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
        return new UserPojo(user);
    }
}
