package quiz.domain.repository;

import quiz.domain.object.Quiz;

import java.util.List;

public interface QuizRepository {

    /**
     * クイズ検索
     * @param quizId ID
     * @param category カテゴリ
     * @param type タイプ
     * @return クイズ
     */
    List<Quiz> find(String quizId, String category, String type);
}
