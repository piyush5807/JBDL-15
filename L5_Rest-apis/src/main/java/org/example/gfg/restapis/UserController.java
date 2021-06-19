package org.example.gfg.restapis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
public class UserController {

    // RestController - Controller + ResponseBody

    // Client - ios / android / web application / postman / command line etc.

    // id -> user
    public HashMap<Integer, User> userMap = new HashMap<Integer, User>();

    @GetMapping("/users")
    public Map<Integer, User> getUsers(){
        return userMap;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam("id") int id){
        return userMap.get(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void saveUser(@RequestBody User user){
        userMap.put(user.getId(), user);
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user){

        if(!userMap.containsKey(user.getId())){
            return;
        }

        userMap.put(user.getId(), user);
    }

    @DeleteMapping("/user/{user_id}")
    public User deleteUserById(@PathVariable("user_id") int id){
        return userMap.remove(id);
    }

}
