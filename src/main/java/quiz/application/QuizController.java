package quiz.application;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import quiz.domain.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @NonNull
    private QuizService quizService;

    /**
     * クイズ検索
     * @param quiz_id 検索したいクイズID
     * @return クイズ
     */
    @ResponseStatus(HttpStatus.OK)
    public QuizBody findById(@RequestParam(name="id") String quiz_id) {
        return new QuizBody();
    }
}
