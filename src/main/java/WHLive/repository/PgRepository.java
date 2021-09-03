package WHLive.repository;

import WHLive.model.Pg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PgRepository extends JpaRepository<Pg, Long> {

    @Query("SELECT pg " +
            " FROM Pg pg " +
            "WHERE pg.user.tessera = :tessera " +
            "  AND status = 1")
    Pg getActivePgForTessera(int tessera);
}