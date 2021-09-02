package WHLive.controller;

import WHLive.messages.*;
import WHLive.model.PG;
import WHLive.model.Skill;
import WHLive.model.User;
import WHLive.repository.PgRepository;
import WHLive.repository.SkillRepository;
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
    @Autowired
    private SkillRepository skillRepository;

    @GetMapping(path="/soci")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "tessera"));
    }

    @PostMapping(path="/login")
    public @ResponseBody LoginResponse login(@RequestBody LoginRequest body) {
        //Get user
        User u = userRepository.getUserByTessera(Integer.parseInt(body.getTessera()));
        //TODO THIS IS BULLISH!
        //Chek password
        if(!u.getPassword().equals(body.getPassword())){
            return new LoginResponse(null, null,-1, null, null);
        }
        //Generate auth token save and return it
        String authToken = UUID.randomUUID().toString();
        //Generate session token save and return it
        String sessionToken = UUID.randomUUID().toString();
        u.setAuthToken(authToken);
        u.setSessionToken(sessionToken);
        //Set expiration of login token
        Calendar c = new GregorianCalendar();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_YEAR, 30);
        u.setAuthExpire(c.getTime());
        userRepository.save(u);
        return new LoginResponse(authToken, sessionToken, u.getTessera(), u.getFirstName(), u.getLastName());
    }

    @PostMapping(path="/checkToken")
    public @ResponseBody CheckTokenResponse checkToken(@RequestBody CheckTokenRequest body) {
        User u = userRepository.getUserByToken(body.getToken());
        if(u == null) return null;
        //Generate session token save and return it
        String sessionToken = UUID.randomUUID().toString();
        u.setSessionToken(sessionToken);
        userRepository.save(u);
        return new CheckTokenResponse(sessionToken, u.getTessera(), u.getFirstName(), u.getLastName());
    }

    @PostMapping(path="/newPg")
    public @ResponseBody CreatePGResponse newPg(@RequestBody CreatePGRequest body) {
        User u = userRepository.getUserBySessionToken(body.getSessionToken());
        System.out.println(body.getSessionToken());
        if(u == null) return new CreatePGResponse(-1L, true, "Auth Error!");

        PG oldPg = pgRepository.getActivePgForTessera(u.getTessera());
        if(oldPg != null){
            return new CreatePGResponse(-1L, true, "Hai già un PG attivo!");
        }

        PG newPg = new PG();
        newPg.setBg(body.getBg());
        newPg.setFaction(body.getFaction());
        newPg.setRace(body.getRace());
        newPg.setName(body.getName());
        newPg.setUser(u);
        newPg.setCreationDate(new Date());
        newPg.setStatus(1);
        pgRepository.save(newPg);

        return new CreatePGResponse(newPg.getId(), false, "");
    }

    @PostMapping(path="/getActivePgForTessera")
    public @ResponseBody GetPersonaggioResponse getActivePgForTessera(@RequestBody GetPersonaggioRequest body) {
        PG pg = pgRepository.getActivePgForTessera(body.getTessera());
        GetPersonaggioResponse resp = null;
        if(pg == null) {
            resp = new GetPersonaggioResponse(0,0L,"","","",0,"",0,0,"");
        }else{
            resp = new GetPersonaggioResponse(1,pg.getId(),pg.getName(),pg.getRace(),pg.getFaction(),
                    pg.getStatus(),pg.getImageUrl(),pg.getCareerRank(),pg.getCorruptionRank(),pg.getBg());
        }
        return resp;
    }

    @GetMapping(path="/getAllSkills")
    public @ResponseBody Iterable<Skill> getAllSkills() {
        return skillRepository.getAllSkills();
    }
}
