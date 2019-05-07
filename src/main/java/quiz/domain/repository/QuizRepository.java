package quiz.domain.repository;

import quiz.domain.object.Quiz;
import quiz.infrastructure.entity.QuizEntity;

import java.util.List;
import java.util.Optional;

public interface QuizRepository {

    /**
     * クイズ全件検索
     * @return クイズ
     */
    List<QuizEntity> findAll();

    /**
     * クイズ検索
     *
     * @param quiz_id 検索したいクイズのID
     * @return クイズ
     */
    Optional<Quiz> findById(String quiz_id);
}
