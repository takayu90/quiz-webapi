package quiz.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import quiz.domain.object.Quiz;
import quiz.domain.object.QuizAnswer;
import quiz.domain.object.QuizContent;
import quiz.domain.service.QuizService;

import java.util.List;
import java.util.Optional;

@RestController
public class QuizController {

    @Autowired
    private QuizService quizService;

    /**
     * クイズ検索
     * @param category カテゴリ(オプション)
     * @param type タイプ(オプション)
     * @return クイズ
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Quiz> find(@RequestParam(name="id") String quizId,
                           @RequestParam(name="category") String category,
                           @RequestParam(name="type") String type) {
        return this.quizService.find(quizId, category, type);
    }

     /**
     * クイズ内容検索
     * @param quizId 検索したいクイズID
     * @return クイズ
     */
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Optional<QuizContent> findContentById(@RequestParam(name="id") String quizId) {
        return this.quizService.findContentById(quizId);
    }

    /**
     * クイズ回答検索
     * @param quizId 検索したいクイズID
     * @return クイズ
     */
    @RequestMapping(value = "/answer", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Optional<QuizAnswer> findAnswerById(@RequestParam(name="id") String quizId) {
        return this.quizService.findAnswerById(quizId);
    }
}
