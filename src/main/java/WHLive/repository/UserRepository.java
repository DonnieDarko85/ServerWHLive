package WHLive.repository;

import WHLive.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u where u.tessera = :tessera")
    User getUserByTessera(int tessera);
}