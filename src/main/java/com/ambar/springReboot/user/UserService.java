package com.ambar.springReboot.user;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserService {

     public static List<User> users = new ArrayList<>();
      static int count = 0;
     static
     {

         users.add(new User(++count, "Ambar",LocalDate.now().minusYears(30)));
         users.add(new User(++count, "Ankit",LocalDate.now().minusYears(25)));
     }

     public List<User>getUsers()
     {
          return users;
     }

    public User getUserById(int id)
    {
        Predicate<User> predicate = user ->  user.getId().equals(id);
        return users.stream().filter(predicate).findAny().orElse(null);
    }

    public User addUser(User user) {
           user.setId(++count);
           users.add(user);
           return user;
    }
}
