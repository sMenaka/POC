package lk.nie.planningDepOauthService.repository;
import dep.planning.core.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserDetailRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String userName);
}
