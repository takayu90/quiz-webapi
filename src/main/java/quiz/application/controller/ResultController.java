package quiz.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import quiz.application.resource.ResultBody;
import quiz.domain.QuizException;
import quiz.domain.object.Result;
import quiz.domain.service.ResultService;

import java.util.List;

@RestController
public class ResultController {

    @Autowired
    private ResultService resultService;

    /**
     * クイズ結果検索<br>
     *     どちらも指定 -> 1つの結果を取得
     *     クイズIDを指定 -> クイズの結果を一覧
     *     ユーザIDを指定 -> ユーザの結果を一覧
     * @param quizId ID
     * @param userId ユーザID
     * @return クイズ
     */
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Result> searchResult(@RequestParam(name="id") String quizId,
                                     @RequestParam(name="user") String userId) {
        if (StringUtils.isEmpty(quizId) && StringUtils.isEmpty(userId)) {
            return null;
        }
        return this.resultService.searchResult(quizId, userId);
    }

    /**
     * クイズ登録(開始)
     * @return クイズ
     */
    @RequestMapping("/start")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Result start(@RequestBody @Validated ResultBody resultBody) throws QuizException {
        Result result = resultBody.toDomainObject();
        if (result.getStartDate() == null) {
            throw new QuizException("startDateが指定されていません");
        }
        return this.resultService.start(result);
    }

    /**
     * クイズ登録(回答)
     * @return クイズ
     */
    @RequestMapping("/end")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Result end(@RequestBody @Validated ResultBody resultBody) throws QuizException {
        Result result = resultBody.toDomainObject();
        if (result.getEndDate() == null) {
            throw new QuizException("endDateが指定されていません");
        }
        return this.resultService.end(result);
    }
}
