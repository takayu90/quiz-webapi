package quiz.domain.object;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * クイズ
 */
@Data
@Builder
public class Result {
    /**
     * クイズID
     */
    private String quizId;
    /**
     * ユーザーID
     */
    private String userId;
    /**
     * 正解/不正解
     */
    private String isCorrect;
    /**
     * 開始日時
     */
    private Date startDate;
    /**
     * 終了日時
     */
    private Date endDate;
}
