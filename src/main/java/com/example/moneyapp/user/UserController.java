package com.example.moneyapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserRepository userRepo;
    private UserMapper mapper;
    private UserService userService;

    public UserController(UserRepository userRepo, UserMapper mapper, UserService userService) {
        this.userRepo = userRepo;
        this.mapper = mapper;
        this.userService = userService;
    }


    @GetMapping
    @ResponseBody
    public List<UserDto> getUsers() {
        return userRepo.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(toList());
    }

    @GetMapping("/test")
    @ResponseBody
    public List<UserAuthDto> getUsersLoginDetails() {
        return userRepo.findAll()
                .stream()
                .map(mapper::toTest)
                .collect(toList());
    }

    @PutMapping("/{id}/update")
    public UserDto updateUser(@PathVariable(value="id") Integer id, @RequestBody User user) {
        return this.userService.updateUser(id, user);
//        System.out.println(response);

//        UserDto updatedUserDto = new UserDto()
//        if (response == null) {
//            return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
