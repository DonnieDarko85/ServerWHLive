package WHLive.repository;

import WHLive.model.Pg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PgRepository extends JpaRepository<Pg, Long> {

    @Query(value = "SELECT pg.* " +
            " FROM pg pg " +
            "WHERE pg.user_tessera = :tessera " +
            "  AND pg.status = 1 " +
            "LIMIT 0,1",
            nativeQuery = true)
    Pg getActivePgForTessera(int tessera);
}