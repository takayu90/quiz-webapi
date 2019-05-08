package quiz.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import quiz.infrastructure.entity.ResultEntity;

/**
 * JPAを利用するためのインタフェース
 */
public interface ResultJpaRepository extends JpaRepository<ResultEntity, String>, JpaSpecificationExecutor<ResultEntity> {
}
