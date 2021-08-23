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
    public @ResponseBody LoginResponse login(@RequestBody LoginRequest body) {
        //Get user
        User u = userRepository.getUserByTessera(Integer.parseInt(body.tessera));
        //TODO THIS IS BULLISH!
        //Chek password
        System.out.println(body.password);
        if(!u.getPassword().equals(body.password)){
            return new LoginResponse(null, null,-1, null, null);
        }
        //Generate auth token save and return it
        String authToken = UUID.randomUUID().toString();
        //Generate session token save and return it
        String sessionToken = UUID.randomUUID().toString();
        u.setAuthToken(authToken);
        //Set expiration of login token
        Calendar c = new GregorianCalendar();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_YEAR, 30);
        u.setAuthExpire(c.getTime());
        userRepository.save(u);
        return new LoginResponse(authToken, sessionToken, u.getTessera(), u.getFirstName(), u.getLastName());
    }

    @PostMapping(path="/checkToken")
    public @ResponseBody CheckTokenResponse login(@RequestBody CheckTokenRequest body) {
        User u = userRepository.getUserByToken(body.token);
        if(u == null) return null;
        //Generate session token save and return it
        String sessionToken = UUID.randomUUID().toString();
        return new CheckTokenResponse(sessionToken, u.getTessera(), u.getFirstName(), u.getLastName());
    }

    public static class LoginRequest {
        private String tessera;
        private String password;

        LoginRequest(){}

        public void setTessera(String tessera) {
            this.tessera = tessera;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    public static class LoginResponse {
        private String authToken;
        private String sessionToken;
        private int tessera;
        private String firstName;
        private String lastName;

        public LoginResponse(String authToken, String sessionToken, int tessera, String firstName, String lastName) {
            this.authToken = authToken;
            this.tessera = tessera;
            this.firstName = firstName;
            this.lastName = lastName;
            this.sessionToken = sessionToken;
        }

        public String getAuthToken() {
            return authToken;
        }

        public void setAuthToken(String token) {
            this.authToken = token;
        }

        public int getTessera() {return tessera;}

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

        public String getSessionToken() {
            return sessionToken;
        }

        public void setSessionToken(String sessionToken) {
            this.sessionToken = sessionToken;
        }
    }

    public static class CheckTokenRequest {
        private String token;

        CheckTokenRequest(){}

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    public static class CheckTokenResponse {
        private String sessionToken;
        private int tessera;
        private String firstName;
        private String lastName;

        CheckTokenResponse(String sessionToken, int tessera, String firstName, String lastName){
            this.sessionToken = sessionToken;
            this.tessera = tessera;
            this.firstName = firstName;
            this.lastName= lastName;
        }

        public String getSessionToken() {
            return sessionToken;
        }

        public void setSessionToken(String sessionToken) {
            this.sessionToken = sessionToken;
        }

        public int getTessera() {
            return tessera;
        }

        public void setTessera(int tessera) {
            this.tessera = tessera;
        }public String getFirstName() {
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
