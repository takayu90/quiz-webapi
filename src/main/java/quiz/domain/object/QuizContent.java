package quiz.domain.object;

import lombok.Builder;
import lombok.Data;

/**
 * クイズ
 */
@Data
@Builder
public class QuizContent {
    /**
     * クイズID
     */
    private String quizId;
    /**
     * クイズ内容
     */
    private String content;
    /**
     * 選択肢1
     */
    private String selection1;
    /**
     * 選択肢2
     */
    private String selection2;
    /**
     * 選択肢3
     */
    private String selection3;
    /**
     * 選択肢4
     */
    private String selection4;
}
