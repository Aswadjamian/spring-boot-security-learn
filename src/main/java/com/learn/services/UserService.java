package com.learn.services;
import com.learn.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> list= new ArrayList();

    UserService(){
        list.add(new User("asvad","123","aswad@123"));
        list.add(new User("xyz","786","xyzd@123"));
        list.add(new User("deepak","12345","deepakd@123"));
        list.add(new User("sonu","2280","sonu@123"));
    }

    /*get list of user*/
    public List<User> getAllUsers(){
        return this.list;
    }
    /*get Singe user*/
    public User getUser(String username){
        return this.list.stream().filter((user)-> user.getUsername().equals(username)).findAny().orElse(null);
    }

    /*Add New User*/
    public User addUser(User user){
        this.list.add(user);
        return  user;
    }


}
