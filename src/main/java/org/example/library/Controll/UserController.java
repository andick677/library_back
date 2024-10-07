package org.example.library.Controll;

import org.example.library.Dto.UserRequest;
import org.example.library.Model.User;
import org.example.library.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/getuser")
    public ResponseEntity<User> getUser(@RequestBody UserRequest userRequest){
        User user = userService.getUser(userRequest);



        System.out.println("被呼叫到了");

        if(user!=null){
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest){
        int UserId = userService.createUser(userRequest);

        User user = userService.getUserId(UserId);

        System.out.println("被呼叫到了");

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
