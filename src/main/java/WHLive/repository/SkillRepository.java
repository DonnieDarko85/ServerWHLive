package WHLive.repository;

import WHLive.model.PG;
import WHLive.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SkillRepository extends JpaRepository<Skill, Long> {

    @Query("SELECT s FROM Skill s")
    Iterable<Skill> getAllSkills();
}