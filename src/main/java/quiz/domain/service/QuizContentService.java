package quiz.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quiz.domain.object.QuizContent;
import quiz.domain.repository.QuizContentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizContentService {

    @NonNull
    private final QuizContentRepository quizContentRepository;

    /**
     * クイズ内容検索
     */
    public Optional<QuizContent> findById(String quiz_id) {
        return this.quizContentRepository.findById(quiz_id);
    }
}
