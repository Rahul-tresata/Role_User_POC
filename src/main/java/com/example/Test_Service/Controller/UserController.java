package com.example.Test_Service.Controller;

import com.example.Test_Service.Entity.UserEntity;
import com.example.Test_Service.Exception.CustomException;
import com.example.Test_Service.Service.ProductService;
import com.example.Test_Service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<UserEntity>> findallUser() throws CustomException.UserNotFoundException {
        return ResponseEntity.ok(userService.findallUser());
    }
    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity user) throws CustomException.EmptyFieldException {
        return new ResponseEntity(userService.saveUser(user),HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user) throws CustomException.EmptyFieldException {
        return new ResponseEntity(userService.updateUser(user),HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public UserEntity findUserById(@PathVariable int id) throws CustomException.UserNotFoundException {
        return userService.findUserById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id)
        {
            String status=userService.deleteUser(id);
            return new ResponseEntity<String>(status,HttpStatus.OK);
        }

}
