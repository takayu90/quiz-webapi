package quiz.application.resource;

import lombok.Data;
import quiz.domain.object.Result;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class ResultBody {

    @NotBlank
    private String quizId;
    @NotBlank
    private String userId;
    private String answer;
    private Date startDate;
    private Date endDate;

    /**
     * ドメインオブジェクトへ変換
     * @return ドメインオブジェクト
     */
    public Result toDomainObject() {
        return Result.builder()
                .quizId(this.quizId)
                .userId(this.userId)
                .answer(this.answer)
                .startDate(new java.sql.Date(this.startDate.getTime()))
                .endDate(new java.sql.Date(this.endDate.getTime()))
                .build();
    }
}
