package com.Soham.User.Management.System.Controller;

import com.Soham.User.Management.System.Entity.User;
import com.Soham.User.Management.System.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    public UserService userService;

    public UserController() {
    }

    @GetMapping("allUsers")
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @GetMapping("user/{userID}")
    public String getUser(@PathVariable int userID){
        return userService.getUser(userID);
    }

    @DeleteMapping("user/{userID}")
    public String deleteUser(@PathVariable  int userID){
        return userService.deleteUser(userID);
    }

    @PutMapping("user/{userID}/{Name}/{UserName}/{Address}/{Phone_Number}")
    public String updateUserInfo(@PathVariable int userID,@PathVariable String Name,@PathVariable String UserName,@PathVariable String Address,@PathVariable String Phone_Number){
        return userService.updateUserInfo(userID,Name,UserName,Address,Phone_Number);
    }

    @PostMapping("user/{userId}/{Name}/{UserName}/{Address}/{Phone_Number}")
    public String addUser(@PathVariable int userId,@PathVariable String Name,@PathVariable String UserName,@PathVariable String Address,@PathVariable String Phone_Number){
        return userService.addUser(userId,Name,UserName,Address,Phone_Number);
    }

}
