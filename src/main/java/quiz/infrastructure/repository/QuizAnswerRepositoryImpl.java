package quiz.infrastructure.repository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import quiz.domain.object.QuizAnswer;
import quiz.domain.repository.QuizAnswerRepository;
import quiz.infrastructure.entity.QuizAnswerEntity;

import java.util.Optional;

/**
 * 永続化の実装クラス
 * ドメインオブジェクトをEntityに変換してJPAをラップする
 */
@Repository
@RequiredArgsConstructor
public class QuizAnswerRepositoryImpl implements QuizAnswerRepository {

    @NonNull
    private final QuizAnswerJpaRepository quizAnswerJpaRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<QuizAnswer> findById(String quiz_id) {
        return this.quizAnswerJpaRepository.findById(quiz_id)
                .map(QuizAnswerEntity::toDomainQuizAnswer);
    }
}
