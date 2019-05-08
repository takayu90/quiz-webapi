package quiz.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quiz.domain.object.Result;
import quiz.domain.repository.ResultRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {

    @NonNull
    private final ResultRepository resultRepository;

    /**
     * 結果検索
     * @param quizId ID
     * @param userId ユーザID
     * @return 結果
     */
    public List<Result> searchResult(String quizId, String userId) {
        return this.resultRepository.find(quizId, userId);
    }

    /**
     * 回答開始
     * @param result
     */
    public Result start(Result result) {
        // 回答終了時に更新するものはクリアする
        result.setAnswer("");
        result.setIsCorrect("");
        result.setEndDate(null);
        result.setElapsedTime(null);
        return this.resultRepository.save(result);
    }

    /**
     * 回答終了・チェック
     * @param result
     */
    public Result end(Result result) {
        List<Result> list = this.searchResult(result.getQuizId(), result.getUserId());
        Result answer = list.get(0);
        answer.setEndDate(result.getEndDate());
        // TODO
        return this.resultRepository.save(result);
    }
}
