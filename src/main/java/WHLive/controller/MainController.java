package WHLive.controller;

import WHLive.messages.*;
import WHLive.model.Pg;
import WHLive.model.Skill;
import WHLive.model.User;
import WHLive.repository.PgRepository;
import WHLive.repository.PgSkillRepository;
import WHLive.repository.SkillRepository;
import WHLive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/api")
@SpringBootApplication
public class MainController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PgRepository pgRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private PgSkillRepository pgSkillRepository;

    @PostMapping(path="/allUsers")
    public @ResponseBody GetAllUsersResponse getAllUsers(@RequestBody BaseRequest body) {
        System.out.println(new Date() + " *** ACTIVITY **** getAllUsers: " + body.getSessionToken());
        User u = userRepository.getUserBySessionToken(body.getSessionToken());
        if(u == null) return new GetAllUsersResponse(true, "Auth Error!");
        System.out.println(new Date() + " *** AUTH USER **** getAllUsers: " + u);
        updateSessionExpireOnActivity(u);
        return new GetAllUsersResponse(userRepository.findAll(Sort.by(Sort.Direction.ASC, "tessera")));
    }

    private void updateSessionExpireOnActivity(User u) {
        Calendar c = new GregorianCalendar();
        c.setTime(new Date());
        c.add(Calendar.HOUR, 1);
        u.setSessionExpire(c.getTime());
        userRepository.save(u);
    }

    @PostMapping(path="/login")
    public @ResponseBody LoginResponse login(@RequestBody LoginRequest body) {
        //Get user
        System.out.println(new Date() + " *** ACTIVITY **** Login: " + body.getTessera());
        User u = userRepository.getUserByTessera(Integer.parseInt(body.getTessera()));
        if(u == null) return new LoginResponse(true, "Auth Error!");
        System.out.println(new Date() + " *** AUTH USER **** Login: " + u);
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
        updateSessionExpireOnActivity(u);
        userRepository.save(u);
        return new LoginResponse(authToken, sessionToken, u.getTessera(), u.getFirstName(), u.getLastName());
    }

    @PostMapping(path="/checkToken")
    public @ResponseBody CheckTokenResponse checkToken(@RequestBody CheckTokenRequest body) {
        System.out.println(new Date() + " *** ACTIVITY **** Check auth token: " + body.getToken());
        User u = userRepository.getUserByToken(body.getToken());
        if(u == null) return new CheckTokenResponse(true, "Auth Error!");
        System.out.println(new Date() + " *** AUTH USER **** Check auth token: " + u);
        //Generate session token save and return it
        String sessionToken = UUID.randomUUID().toString();
        u.setSessionToken(sessionToken);
        updateSessionExpireOnActivity(u);
        userRepository.save(u);
        return new CheckTokenResponse(sessionToken, u.getTessera(), u.getFirstName(), u.getLastName());
    }

    @PostMapping(path="/newPg")
    public @ResponseBody CreatePGResponse newPg(@RequestBody CreatePGRequest body) {
        System.out.println(new Date() + " *** ACTIVITY **** newPg: " + body.getSessionToken());
        User u = userRepository.getUserBySessionToken(body.getSessionToken());
        if(u == null) return new CreatePGResponse(-1L, true, "Auth Error!");
        System.out.println(new Date() + " *** AUTH USER **** newPg: " + u);

        Pg oldPg = pgRepository.getActivePgForTessera(u.getTessera());
        if(oldPg != null){
            return new CreatePGResponse(-1L, true, "No more than one active Pg allowed!");
        }

        Pg newPg = new Pg();
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

    @PostMapping(path="/addSkillToPg")
    public @ResponseBody AddSkillToPgResponse addSkillToPg(@RequestBody AddSkillToPgRequest body) {
        System.out.println(new Date() + " *** ACTIVITY **** addSkillToPg: " + body.getSessionToken());
        User u = userRepository.getUserBySessionToken(body.getSessionToken());
        if(u == null) return new AddSkillToPgResponse(true, "Auth Error!", null);
        System.out.println(new Date() + " *** AUTH USER **** addSkillToPg: " + u);

        Pg pg = pgRepository.getActivePgForTessera(u.getTessera());
        if(pg == null) return new AddSkillToPgResponse(true, "Pg not present!", null);

        Iterable<Skill> skills = skillRepository.findAllById(body.getSkills());
        for (Skill skill : skills) {
            pg.getSkills().add(skill);
        }
        pgRepository.save(pg);

        return new AddSkillToPgResponse(false,"", getSkillsIds(pg));
    }

    private List<Long> getSkillsIds(Pg pg) {
        List<Long> skillsId = new ArrayList<>();
        for (Skill s: pg.getSkills()) {
            skillsId.add(s.getId());
        }
        return skillsId;
    }

    @PostMapping(path="/getActivePgForTessera")
    public @ResponseBody GetPersonaggioResponse getActivePgForTessera(@RequestBody GetPersonaggioRequest body) {
        System.out.println(new Date() + " *** ACTIVITY **** getAllUsers: " + body.getSessionToken());
        User u = userRepository.getUserBySessionToken(body.getSessionToken());
        if(u == null) return new GetPersonaggioResponse(-1L, true, "Auth Error! Invalid token");
        System.out.println(new Date() + " *** AUTH USER **** getAllUsers: " + u);

        if(u.getTessera() != body.getTessera()) return new GetPersonaggioResponse(-1L, true, "Auth Error! Tessera mismatch");

        Pg pg = pgRepository.getActivePgForTessera(body.getTessera());
        GetPersonaggioResponse resp = null;
        if(pg == null) {
            resp = new GetPersonaggioResponse(0,0L,"","","",0,"",0,0,"", null);
        }else{
            resp = new GetPersonaggioResponse(1,pg.getId(),pg.getName(),pg.getRace(),pg.getFaction(),
                    pg.getStatus(),pg.getImageUrl(),pg.getCareerRank(),pg.getCorruptionRank(),pg.getBg(), getSkillsIds(pg));
        }
        return resp;
    }

    @PostMapping(path="/getAllSkills")
    public @ResponseBody GetAllSkillResponse getAllSkills(@RequestBody BaseRequest body) {
        System.out.println(new Date() + " *** ACTIVITY **** getAllSkills: " + body.getSessionToken());
        User u = userRepository.getUserBySessionToken(body.getSessionToken());
        if(u == null) return new GetAllSkillResponse(true, "Auth Error! Invalid token");
        System.out.println(new Date() + " *** AUTH USER **** getAllSkills: " + u);

        return new GetAllSkillResponse(skillRepository.findAll());
    }

    @PostMapping(path="/editSkill")
    public @ResponseBody EditSkillResponse editSkill(@RequestBody EditSkillRequest body) {
        System.out.println(new Date() + " *** ACTIVITY **** getAllUsers: " + body.getSessionToken());
        User u = userRepository.getUserBySessionToken(body.getSessionToken());
        if(u == null) return new EditSkillResponse(true, "Auth Error! Invalid token");
        System.out.println(new Date() + " *** AUTH USER **** editSkill: " + u);
        Optional<Skill> maybeSkill = skillRepository.findById(body.getId());
        if(!maybeSkill.isPresent()) return new EditSkillResponse(true, "Skill does not exist!");
        Skill s= maybeSkill.get();
        //s.setAdvanced(body.isAdvanced());
        //s.setCareer(body.isCareer());
        s.setCost(body.getCost());
        s.setName(body.getName());
        //s.setSupreme(body.isSupreme());
        //s.setStyle(body.isStyle());
        s.setDescription(body.getDescription());
        skillRepository.save(s);

        return new EditSkillResponse(skillRepository.findAll());
    }
}
