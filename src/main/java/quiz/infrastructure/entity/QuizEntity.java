package quiz.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import quiz.domain.object.Quiz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="quizzes")
public class QuizEntity {
    @Id
    @Column(name="quiz_id")
    private String quizId;

    @Column(name="category")
    private String category;

    @Column(name="overview")
    private String overview;

    @Column(name="type")
    private String type;


    /**
     * ドメインオブジェクトからインスタンスを生成
     *
     * @param quiz ドメインオブジェクト
     * @return QuizEntity
     */
    public static QuizEntity build(Quiz quiz) {
        return QuizEntity.builder()
                .quizId(quiz.getQuizId())
                .category(quiz.getCategory())
                .overview(quiz.getOverview())
                .type(quiz.getType())
                .build();
    }

    /**
     * ドメインオブジェクトへ変換
     *
     * @return QuizBody
     */
    public Quiz toDomainQuiz() {
        return Quiz.builder()
                .quizId(this.quizId)
                .category(this.category)
                .overview(this.overview)
                .type(this.type)
                .build();
    }
}
