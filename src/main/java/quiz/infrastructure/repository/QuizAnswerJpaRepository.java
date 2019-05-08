package quiz.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.infrastructure.entity.QuizAnswerEntity;

/**
 * JPAを利用するためのインタフェース
 */
public interface QuizAnswerJpaRepository extends JpaRepository<QuizAnswerEntity, String> {
}
