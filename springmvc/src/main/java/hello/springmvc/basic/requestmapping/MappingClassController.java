package hello.springmvc.basic.requestmapping;


import org.springframework.web.bind.annotation.*;

@RestController
public class MappingClassController {

    /**
     * User get:  GET     '/users'
     * User create: POST    '/users'
     * User find:   GET     '/users/{userId}'
     * User modify: PATCH   '/users/{userId}'
     * User delet:  DELETE  '/users/{userId}'
     *
     */


    @GetMapping("/mapping/users")
    public String user(){
        return "get all user";
    }

    @PostMapping("/mapping/users")
    public String addUser(){
        return "user created";
    }


    @GetMapping("/mapping/users/{userId}")
    public String findUser(@PathVariable String userId){
        return "get userId" + userId ;
    }


    @PatchMapping("/mapping/users/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update userId" + userId;

    }@DeleteMapping("/mapping/users/{userId}")
    public String deleteUser(@PathVariable String userId){
        return "delete userId" + userId;
    }




}
