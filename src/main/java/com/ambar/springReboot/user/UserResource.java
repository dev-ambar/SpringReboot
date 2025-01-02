package com.ambar.springReboot.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("v1/api/users")
public class UserResource {

    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers()
    {
        List<User> users = userService.getUsers();
          return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id)
    {
         User user = userService.getUserById(id);
         if(user!=null)
         return new ResponseEntity<>(user, HttpStatus.OK);
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<User>createUser(@RequestBody User user)
    {
             User createdUser = userService.addUser(user);
             /*return new ResponseEntity<>(createdUser,HttpStatus.CREATED);*/
             URI location = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                     .buildAndExpand(createdUser.getId()).toUri();
              return ResponseEntity.created(location).build();

    }
}
