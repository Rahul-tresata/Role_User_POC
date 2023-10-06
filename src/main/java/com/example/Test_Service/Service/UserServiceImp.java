package com.example.Test_Service.Service;

import com.example.Test_Service.Entity.UserEntity;
import com.example.Test_Service.Exception.CustomException;
import com.example.Test_Service.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> findallUser() {
        List<UserEntity> user = userRepository.findAll();
        if (user.isEmpty())
        {
            throw new CustomException.UserNotFoundException("No data found for user");
        }
        else {
            return user;
        }
    }

    @Override
    public UserEntity findUserById(int id) {
        UserEntity user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new CustomException.UserNotFoundException("User not found with ID: " + id);
        }
        return user;

    }

    @Override
    public UserEntity saveUser(UserEntity user) throws CustomException.EmptyFieldException {
        if(user.getUserName().isEmpty() || user.getEmail().isEmpty())
        {
            throw new CustomException.EmptyFieldException("Name or Email Id is null");
        }
        return userRepository.save(user);
    }

    @Override
    public UserEntity updateUser(UserEntity user) throws CustomException.EmptyFieldException {
        if(user.getUserName().isEmpty() || user.getEmail().isEmpty())
        {
            throw new CustomException.EmptyFieldException("Name or Email Id is null");
        }
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(int id) {
        if (userRepository.existsById(id))
        {
            userRepository.deleteById(id);
            return "User Deleted";
        }
        else
        {
            return "User Not Found";
        }
    }
}
