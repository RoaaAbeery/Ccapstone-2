package com.example.capstone.Service;

import com.example.capstone.ApiException.ApiException;
import com.example.capstone.Model.User;
import com.example.capstone.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public void addUsers(User user){
        userRepository.save(user);
    }
    public void updateUser(Integer id,User user){
        User oldUser=userRepository.findUsersById(id);
        if(oldUser==null){
            throw new ApiException("User not found");
        }
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setPhone(user.getPassword());
        oldUser.setFirstName(user.getFirstName());
        oldUser.setLastName(user.getLastName());
        oldUser.setAge(user.getAge());
        userRepository.save(oldUser);

    }
    public void deleteUser(Integer id){
        User user=userRepository.findUsersById(id);
        if(user==null){
            throw new ApiException("User not found");
        }
        userRepository.delete(user);
    }
    public User check(String email,String password){
        User user=userRepository.findUsersByEmailAndPassword(email,password);
        if(user==null){
            throw new ApiException("User not found");
        }
        return user;
    }
    public void changeName(String firstName,String lastName,User user){
        User oldName=userRepository.findUsersByFirstNameAndLastName(firstName, lastName);
        if(oldName==null){
            throw new ApiException("Name not found");
        }
        oldName.setFirstName(user.getFirstName());
        oldName.setLastName(user.getLastName());
        userRepository.save(oldName);

    }
    public void changePass(Integer id,String password,User user){
        User oldPass=userRepository.findUsersByIdAndPassword(id, password);
        if(oldPass==null){
            throw new ApiException("id not found");
        }
        oldPass.setPassword(user.getPassword());
        userRepository.save(oldPass);

    }
    public List<User> getAgr(Integer age){
        List<User> users=userRepository.findUserByAge(age);
        if(users==null){
            throw new ApiException("User not found");
        }
        return users;

    }
}
