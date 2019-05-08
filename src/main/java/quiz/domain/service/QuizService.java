package quiz.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quiz.domain.object.Quiz;
import quiz.domain.object.QuizAnswer;
import quiz.domain.object.QuizContent;
import quiz.domain.repository.QuizAnswerRepository;
import quiz.domain.repository.QuizContentRepository;
import quiz.domain.repository.QuizRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {

    @NonNull
    private final QuizRepository quizRepository;
    @NonNull
    private final QuizContentRepository quizContentRepository;
    @NonNull
    private final QuizAnswerRepository quizAnswerRepository;

    /**
     * クイズ一覧検索(条件指定)
     * @param quizId ID
     * @param category カテゴリ
     * @param type タイプ
     * @return クイズ一覧
     */
    public List<Quiz> find(String quizId, String category, String type) {
        return quizRepository.find(quizId, category, type);
    }

    /**
     * クイズ内容検索
     */
    public Optional<QuizContent> findContentById(String quiz_id) {
        return this.quizContentRepository.findById(quiz_id);
    }

    /**
     * クイズ回答検索
     */
    public Optional<QuizAnswer> findAnswerById(String quiz_id) {
        return this.quizAnswerRepository.findById(quiz_id);
    }
}
