package market.data;

import market.dto.UserActivity;
import org.springframework.data.repository.CrudRepository;

public interface UserActivityRepository extends CrudRepository<UserActivity, Long> {
}
