package quiz.domain.object;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

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
     * 回答
     * TODO Quizの正解と命名がかぶる
     */
    private String answer;
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
    /**
     * 終了経過時間
     */
    private Time elapsedTime;
}
