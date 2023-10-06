package com.example.Test_Service.Service;

import com.example.Test_Service.Entity.ProductEntity;
import com.example.Test_Service.Entity.UserEntity;
import com.example.Test_Service.Exception.CustomException;
import com.example.Test_Service.Repository.ProductRepository;
import com.example.Test_Service.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceImpTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private ProductRepository productRepository;
    @Autowired
    private UserService userService;
//    @Test
//    public void testManyToManyRelation(){
//    List<ProductEntity> product1 = new ArrayList<>();
//    List<ProductEntity> product2 = new ArrayList<>();
//    product1.add(new ProductEntity(1,"laptop"));
//    product1.add(new ProductEntity(2,"phone"));
//    product2.add(new ProductEntity(2,"phone"));}


    @Test
    void findallUser() {

        List<UserEntity> user1 = userService.findallUser();
        assertEquals(5,user1.size());
    }

    @Test
    void findUserById() {
        UserEntity user1 = userService.findUserById(3);
        assertEquals("user1",user1.getUserName());
    }

    @Test
    void saveUser() throws CustomException.EmptyFieldException {
        UserEntity user1 = userService.saveUser(new UserEntity(3,"user1", "user1@example.com"));
        assertEquals("user1",user1.getUserName());
    }

    @Test
    void updateUser() throws CustomException.EmptyFieldException {
        UserEntity user1 = userService.updateUser(new UserEntity(1,"user2", "user2@example.com"));
        assertEquals("user2",user1.getUserName());
    }

//    @Test
//    void deleteUser() {
//        //userService.deleteUser(3);
//        String status = userService.findUserById(3);
//        if(user1 != null)
//        {
//            assertEquals("user1",user1.getUserName());
//        }
//        assertNull(user1);
//    }
}