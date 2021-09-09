package WHLive.repository;

import WHLive.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedNativeQuery;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u where u.tessera = :tessera")
    User getUserByTessera(int tessera);

    @Query("SELECT u FROM User u where u.authToken = :token")
    User getUserByToken(String token);

    @Query(value = "SELECT u.* FROM user u where u.session_token = :token and u.session_expire >= NOW()", nativeQuery = true)
    User getUserBySessionToken(String token);
}