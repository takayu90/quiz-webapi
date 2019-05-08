package quiz.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import quiz.domain.object.Result;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "results")
public class ResultEntity {

    @Id
    @Column(name="quiz_id")
    private String quizId;

    @Column(name="user_id")
    private String userId;

    @Column(name="is_correct")
    private String isCorrect;

    @Column(name="start_date")
    private Date startDate;
    
    @Column(name="end_date")
    private Date endDate;

    @Column(name="elapsed_time")
    private Time elapsedTime;

    /**
     * ドメインオブジェクトからインスタンスを生成
     *
     * @param result ドメインオブジェクト
     * @return ResultEntity
     */
    public static ResultEntity build(Result result) {
        return ResultEntity.builder()
                .quizId(result.getQuizId())
                .userId(result.getUserId())
                .isCorrect(result.getIsCorrect())
                .startDate(result.getStartDate())
                .endDate(result.getEndDate())
                .elapsedTime(result.getElapsedTime())
                .build();
    }

    /**
     * ドメインオブジェクトへ変換
     *
     * @return Result
     */
    public Result toDomainObject() {
        return Result.builder()
                .quizId(this.quizId)
                .userId(this.userId)
                .isCorrect(this.isCorrect)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .elapsedTime(this.elapsedTime)
                .build();
    }
}
