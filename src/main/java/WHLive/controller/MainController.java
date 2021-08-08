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
        System.out.println(body.password);
        if(!u.getPassword().equals(body.password)){
            return new TokenResponse(null, -1, null, null);
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
        return new TokenResponse(authToken, u.getTessera(), u.getFirstName(), u.getLastName());
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
        private int tessera;
        private String firstName;
        private String lastName;

        public TokenResponse(String token, int tessera, String firstName, String lastName) {
            this.token = token;
            this.tessera = tessera;
            this.firstName = firstName;
            this.lastName= lastName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getTessera() {
            return tessera;
        }

        public void setTessera(int tessera) {
            this.tessera = tessera;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}
