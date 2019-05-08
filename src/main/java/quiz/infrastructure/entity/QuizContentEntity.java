package quiz.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import quiz.domain.object.QuizContent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="quiz_contents")
public class QuizContentEntity {
    @Id
    @Column(name="quiz_id")
    private String quizId;

    @Column(name="content")
    private String content;

    @Column(name="selection1")
    private String selection1;

    @Column(name="selection2")
    private String selection2;

    @Column(name="selection3")
    private String selection3;

    @Column(name="selection4")
    private String selection4;


    /**
     * ドメインオブジェクトからインスタンスを生成
     *
     * @param quizContent ドメインオブジェクト
     * @return QuizContentEntity
     */
    public static QuizContentEntity build(QuizContent quizContent) {
        return QuizContentEntity.builder()
                .quizId(quizContent.getQuizId())
                .content(quizContent.getContent())
                .selection1(quizContent.getSelection1())
                .selection2(quizContent.getSelection2())
                .selection3(quizContent.getSelection3())
                .selection4(quizContent.getSelection4())
                .build();
    }

    /**
     * ドメインオブジェクトへ変換
     *
     * @return QuizContent
     */
    public QuizContent toDomainQuizContent() {
        return QuizContent.builder()
                .quizId(this.quizId)
                .content(this.content)
                .selection1(this.selection1)
                .selection2(this.selection2)
                .selection3(this.selection3)
                .selection4(this.selection4)
                .build();
    }
}
