package WHLive.repository;

import WHLive.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    @Query("SELECT s FROM Subscription s where s.tessera = :tessera")
    Subscription getSubscriptionByTessera(int tessera);
}