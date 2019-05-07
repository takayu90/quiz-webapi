package quiz.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quiz.domain.object.Quiz;
import quiz.domain.repository.QuizRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {

    @NonNull
    private final QuizRepository quizRepository;

    /**
     * クイズ検索
     */
    public Optional<Quiz> find(String quiz_id) {
        return this.quizRepository.findById(quiz_id);
    }
}
