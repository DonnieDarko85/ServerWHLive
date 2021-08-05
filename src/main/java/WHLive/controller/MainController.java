package WHLive.controller;

import WHLive.model.User;
import WHLive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/soci")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "tessera"));
    }

    @GetMapping(path="/soci/{id}")
    public @ResponseBody Optional<User> getUserById(@PathVariable("id") long id) {
        return userRepository.findById(id);
    }

    @PostMapping(path="/login")
    public @ResponseBody TokenResponse login(@RequestBody LoginValue body) {
        //Get user
        User u = userRepository.getUserByTessera(Integer.parseInt(body.tessera));
        //Chek password
        if(!u.getPassword().equals(body.password)){
            return new TokenResponse(null);
        }
        //Generate auth token save and return it
        String authToken = UUID.randomUUID().toString();
        u.setAuthToken(authToken);
        //Set expiration of login token
        Calendar c = new GregorianCalendar();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_YEAR, 30);
        u.setAuthExpire(c.getTime());
        userRepository.save(u);
        return new TokenResponse(authToken);
    }

    public static class LoginValue {
        private String tessera;
        private String password;

        LoginValue(){}

        public void setTessera(String tessera) {
            this.tessera = tessera;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class TokenResponse {

        private String token;

        public TokenResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
