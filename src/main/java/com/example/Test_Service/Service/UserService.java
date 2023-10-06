package com.example.Test_Service.Service;

import com.example.Test_Service.Entity.UserEntity;
import com.example.Test_Service.Exception.CustomException;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

        List<UserEntity> findallUser() throws CustomException.UserNotFoundException;
        UserEntity findUserById(int id) throws CustomException.UserNotFoundException;
        UserEntity saveUser(UserEntity user) throws CustomException.EmptyFieldException;
        UserEntity updateUser(UserEntity user) throws CustomException.EmptyFieldException;
        String deleteUser(int id);

}
