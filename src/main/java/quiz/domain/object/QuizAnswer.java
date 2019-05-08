package quiz.domain.object;

import lombok.Builder;
import lombok.Data;

/**
 * クイズ
 */
@Data
@Builder
public class QuizAnswer {
    /**
     * クイズID
     */
    private String quizId;
    /**
     * 正解・答え
     */
    private String answer;
}
