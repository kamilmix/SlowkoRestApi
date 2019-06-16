package pl.lodz.uni.math.kamilmucha.SlowkoRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lodz.uni.math.kamilmucha.SlowkoRestApi.model.Zestaw;

import java.util.Optional;


@Repository
public interface ZestawRepository extends JpaRepository<Zestaw, Long> {
    @Override
    Optional<Zestaw> findById(Long aLong);
}
