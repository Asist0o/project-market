package market.repository;

import market.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    public Profile findByEmail(String email);

    public Profile findByBirthday(LocalDate localDate);
}
