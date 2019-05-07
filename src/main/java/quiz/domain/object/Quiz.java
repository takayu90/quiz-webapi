package quiz.domain.object;

import lombok.Builder;
import lombok.Data;

/**
 * クイズ
 */
@Data
@Builder
public class Quiz {
    /**
     * クイズID
     */
    private String quizId;
    /**
     * カテゴリ
     */
    private String category;
    /**
     * 概要
     */
    private String overview;
    /**
     * タイプ
     */
    private String type;
}
