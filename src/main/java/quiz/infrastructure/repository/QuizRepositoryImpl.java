package quiz.infrastructure.repository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import quiz.domain.object.Quiz;
import quiz.domain.repository.QuizRepository;
import quiz.infrastructure.entity.QuizEntity;

import java.util.List;
import java.util.Optional;

/**
 * 永続化の実装クラス
 * ドメインオブジェクトをEntityに変換してJPAをラップする
 */
@Repository
@RequiredArgsConstructor
public class QuizRepositoryImpl implements QuizRepository {

    @NonNull
    private final QuizJpaRepository quizJpaRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<QuizEntity> findAll() {
        return this.quizJpaRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Quiz> findById(String quiz_id) {
        return this.quizJpaRepository.findById(quiz_id)
                .map(QuizEntity::toDomainQuiz);
    }
}
