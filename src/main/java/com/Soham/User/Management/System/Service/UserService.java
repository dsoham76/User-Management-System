package com.Soham.User.Management.System.Service;

import com.Soham.User.Management.System.Entity.User;
import com.Soham.User.Management.System.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserRepo userRepo;

    public String addUser(int userId,String Name,String UserName,String Address,String Phone_Number){
        userRepo.addUser(userId,Name,UserName,Address,Phone_Number);
        return "User has been added.";
    }

    public List<User> getAllUsers(){
        return userRepo.getAllUser();
    }

    public String deleteUser(int userId){

        return userRepo.deleteUser(userId);
    }

    public String updateUserInfo(int userId,String Name,String UserName,String Address,String Phone_Number){
        for(User u: userRepo.getAllUser()){
            if(userId==u.getUserId()){
                u.setName(Name);
                u.setUserName(UserName);
                u.setAddress(Address);
                u.setPhone_Number(Phone_Number);
                return "User's info has been updated.";
            }
        }
        return "User does not exist.";

    }

    public String getUser(int userID) {
        for(User user:userRepo.getAllUser()){
            if(user.getUserId()==userID){
                return "User ID:"+user.getUserId()+"\n"+"Name:"+user.getName()+"\n"+"User Name:"+user.getName()+"\n"+"Address:"+user.getAddress()+"\n"+"Phone Number:"+user.getPhone_Number();
            }
        }

        return "User "+userID+" does not exist.";
    }





}
