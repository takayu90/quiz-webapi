package quiz.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import quiz.domain.object.QuizAnswer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="quiz_answers")
public class QuizAnswerEntity {
    @Id
    @Column(name="quiz_id")
    private String quizId;

    @Column(name="answer")
    private String answer;

    /**
     * ドメインオブジェクトからインスタンスを生成
     *
     * @param quizAnswer ドメインオブジェクト
     * @return QuizAnswerEntity
     */
    public static QuizAnswerEntity build(QuizAnswer quizAnswer) {
        return QuizAnswerEntity.builder()
                .quizId(quizAnswer.getQuizId())
                .answer(quizAnswer.getAnswer())
                .build();
    }

    /**
     * ドメインオブジェクトへ変換
     *
     * @return QuizAnswer
     */
    public QuizAnswer toDomainQuizAnswer() {
        return QuizAnswer.builder()
                .quizId(this.quizId)
                .answer(this.answer)
                .build();
    }
}
