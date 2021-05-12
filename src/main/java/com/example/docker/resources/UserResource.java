package com.example.docker.resources;

import com.example.docker.entities.Users;
import com.example.docker.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author bkariuki
 */
@RestController()
@RequestMapping("/users")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<Users> allUsers() {
        return userService.listUsers();
    }

    @PostMapping()
    public Users createUser(@RequestBody() Users user) {
        return userService.addUser(user);
    }

    @PatchMapping()
    public Users updateUser(@RequestBody() Users user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable("id") String id) {
        return userService.deleteUser(id);
    }
}
