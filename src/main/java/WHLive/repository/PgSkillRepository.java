package WHLive.repository;

import WHLive.model.Pg;
import WHLive.model.PgSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PgSkillRepository extends JpaRepository<PgSkill, Long> {

    @Query("SELECT s " +
            " FROM PgSkill s " +
            "WHERE s.pg = :pg ")
    PgSkill getAllByPG(Pg pg);
}