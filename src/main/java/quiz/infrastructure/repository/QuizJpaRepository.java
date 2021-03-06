package quiz.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import quiz.infrastructure.entity.QuizEntity;

/**
 * JPAを利用するためのインタフェース
 */
public interface QuizJpaRepository extends JpaRepository<QuizEntity, String>, JpaSpecificationExecutor<QuizEntity> {
}
