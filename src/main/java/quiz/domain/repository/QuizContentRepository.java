package quiz.domain.repository;

import quiz.domain.object.QuizContent;

import java.util.Optional;

public interface QuizContentRepository {

    /**
     * クイズ内容取得
     * @return クイズ
     */
    Optional<QuizContent> findById(String quiz_id);
}
