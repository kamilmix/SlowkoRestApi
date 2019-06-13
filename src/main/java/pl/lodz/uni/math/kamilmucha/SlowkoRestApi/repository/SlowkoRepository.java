package pl.lodz.uni.math.kamilmucha.SlowkoRestApi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lodz.uni.math.kamilmucha.SlowkoRestApi.model.Slowko;

import java.util.Optional;

@Repository
public interface SlowkoRepository extends JpaRepository<Slowko, Long> {
    Page<Slowko> findByZestawId(Long postId, Pageable pageable);
    Optional<Slowko> findByIdAndZestawId(Long id, Long postId);
}
