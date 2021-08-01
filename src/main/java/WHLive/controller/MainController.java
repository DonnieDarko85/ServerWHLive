package WHLive.controller;

import WHLive.model.User;
import WHLive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping(path="/soci")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "tessera"));
    }

    @GetMapping(path="/soci/{id}")
    public @ResponseBody Optional<User> getUserById(@PathVariable("id") long id) {
        return userRepository.findById(id);
    }
}