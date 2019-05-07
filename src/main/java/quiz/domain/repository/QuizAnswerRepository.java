package quiz.domain.repository;

import quiz.domain.object.QuizAnswer;

import java.util.Optional;

public interface QuizAnswerRepository {

    /**
     * クイズ検索
     *
     * @param quiz_id 検索したいクイズのID
     * @return クイズ
     */
    Optional<QuizAnswer> findById(String quiz_id);
}
