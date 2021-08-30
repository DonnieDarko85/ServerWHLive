package WHLive.repository;

import WHLive.model.PG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PgRepository extends JpaRepository<PG, Long> {

    @Query("SELECT pg " +
            " FROM PG pg " +
            "WHERE pg.user.tessera = :tessera " +
            "  AND status = 1")
    PG getActivePgForTessera(int tessera);
}