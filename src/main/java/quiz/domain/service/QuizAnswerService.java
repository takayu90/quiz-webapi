package quiz.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quiz.domain.object.QuizAnswer;
import quiz.domain.repository.QuizAnswerRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizAnswerService {

    @NonNull
    private final QuizAnswerRepository quizAnswerRepository;

    /**
     * クイズ検索
     */
    public Optional<QuizAnswer> find(String quiz_id) {
        return this.quizAnswerRepository.findById(quiz_id);
    }
}
