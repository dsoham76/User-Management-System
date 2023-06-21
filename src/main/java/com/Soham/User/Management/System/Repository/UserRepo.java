package com.Soham.User.Management.System.Repository;

import com.Soham.User.Management.System.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {
    @Autowired
    private List<User> AllUsers;

    public void addUser(int userId,String Name,String UserName,String Address,String Phone_Number){
        User user=new User();
        user.setUserId(userId);
        user.setName(Name);
        user.setUserName(UserName);
        user.setAddress(Address);
        user.setPhone_Number(Phone_Number);
        AllUsers.add(user);
    }

    public List<User> getAllUser(){
        return AllUsers;
    }

    public String deleteUser(int userID){
        for(User user: AllUsers){
            if(user.getUserId()==userID){
                AllUsers.remove(user);
                return "User having "+userID+" has been deleted.";
            }
        }

        return "User having "+userID+" does not exist";

    }






}
