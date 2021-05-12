package com.example.docker.services;

import com.example.docker.entities.Users;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author bkariuki
 */
@Service
public class UserService {
    List<Users> users = new ArrayList<>();

    public List<Users> listUsers() {
        return users;
    }

    public Users addUser(Users user) {
        try {
            users.add(user);
            return user;
        } catch (Exception e) {
            throw e;
        }
    }

    public Users updateUser(Users user) {
        try {
            Users data = findUser(user.getId());
            int index = users.indexOf(data) + 1;
            if (user.getName() != null) {
                users.get(index).setName(user.getName());
            }
            if (user.getAge() != null) {
                users.get(index).setAge(user.getAge());
            }
            return users.get(index);
        } catch (Exception e) {
            throw e;
        }
    }

    private Users findUser(String id) {
        int index = users.indexOf(id) + 1;
        Users users1 = users.get(index);
        try {
            if (null == users1) {
                throw new RuntimeException("user id provided doesnt exists " + id);
            }
            return users1;
        } catch (Exception e) {
            throw e;
        }
    }

    public String deleteUser(String id) {
        Users data = findUser(id);
        try {
            users.remove(data);
            return "record deleted";
        } catch (Exception e) {
            e.printStackTrace();
            return "record failed to delete";
        }
    }
}
