package WHLive.controller;

import WHLive.messages.*;
import WHLive.model.PG;
import WHLive.model.User;
import WHLive.repository.PgRepository;
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
    @Autowired
    private PgRepository pgRepository;

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
        User u = userRepository.getUserByTessera(Integer.parseInt(body.getTessera()));
        //TODO THIS IS BULLISH!
        //Chek password
        System.out.println(body.getPassword());
        if(!u.getPassword().equals(body.getPassword())){
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
    public @ResponseBody
    CheckTokenResponse checkToken(@RequestBody CheckTokenRequest body) {
        User u = userRepository.getUserByToken(body.getToken());
        if(u == null) return null;
        //Generate session token save and return it
        String sessionToken = UUID.randomUUID().toString();
        return new CheckTokenResponse(sessionToken, u.getTessera(), u.getFirstName(), u.getLastName());
    }

    @PostMapping(path="/getUserPGs")
    public @ResponseBody Iterable<PG> getUserPGs(@RequestBody GetPersonaggioRequest body) {
        System.out.println("Body" + body);
        System.out.println("Resp" + pgRepository.getPgByTessera(body.getTessera()));
        return pgRepository.getPgByTessera(body.getTessera());
    }
}
