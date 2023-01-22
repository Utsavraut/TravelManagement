package com.system.travelmanagement.service.impl;

import com.system.travelmanagement.Pojo.UserPojo;
import com.system.travelmanagement.Repo.UserRepo;
import com.system.travelmanagement.Entity.User;
import com.system.travelmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public final UserRepo userRepo ;

    @Override
    public String saveUser(UserPojo userPojo) {


        User user = new User();
        if(userPojo.getId()!=null){
            user.setId(userPojo.getId());
        }
        user.setEmail(userPojo.getEmail());
        user.setFullname(userPojo.getFullname());
        user.setMobileNo(userPojo.getMobile_no());
        user.setPassword(userPojo.getPassword());
        userRepo.save(user);
        return "created";
    }

    public List<User> fetchAll(){
        return this.userRepo.findAll();
    }

    @Override
    public User fetchById(Integer id) {
        return  userRepo.findById(id).orElseThrow(()->new RuntimeException("not found"));
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }

//    @Override
}
