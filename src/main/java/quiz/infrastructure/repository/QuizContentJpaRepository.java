package quiz.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.infrastructure.entity.QuizContentEntity;

/**
 * JPAを利用するためのインタフェース
 */
public interface QuizContentJpaRepository extends JpaRepository<QuizContentEntity, String> {
}
