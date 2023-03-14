package hello.springmvc.basic.requestmapping;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    /**
     * User get:  GET     '/users'
     * User create: POST    '/users'
     * User find:   GET     '/users/{userId}'
     * User modify: PATCH   '/users/{userId}'
     * User delet:  DELETE  '/users/{userId}'
     *
     */


    @GetMapping
    public String user(){
        return "get all user";
    }

    @PostMapping
    public String addUser(){
        return "user created";
    }


    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId){
        return "get userId " + userId ;
    }


    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update userId " + userId;

    }@DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId){
        return "delete userId " + userId;
    }




}
