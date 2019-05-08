package quiz.infrastructure.repository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import quiz.domain.object.QuizContent;
import quiz.domain.repository.QuizContentRepository;
import quiz.infrastructure.entity.QuizContentEntity;

import java.util.Optional;

/**
 * 永続化の実装クラス
 * ドメインオブジェクトをEntityに変換してJPAをラップする
 */
@Repository
@RequiredArgsConstructor
public class QuizContentRepositoryImpl implements QuizContentRepository {

    @NonNull
    private final QuizContentJpaRepository quizContentJpaRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<QuizContent> findById(String quiz_id) {
        return this.quizContentJpaRepository.findById(quiz_id)
                .map(QuizContentEntity::toDomainQuizContent);
    }
}
