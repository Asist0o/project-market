package market.repository;

import market.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository <RefreshToken, Long> {

    <S extends String> void save(S entity);

    Optional <?> findRefreshTokenByIdAndToken(Long id, RefreshToken token);
}
