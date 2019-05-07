package quiz.application;

import quiz.domain.object.Quiz;

public class QuizBody {

    private String quizId;

    /**
     * ドメインオブジェクトへ変換
     * @return クイズ
     */
    public Quiz toDomainQuiz() {
        return Quiz.builder()
                .quizId(this.quizId)
                .build();
    }
}
