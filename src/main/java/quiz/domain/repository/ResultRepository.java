package quiz.domain.repository;

import quiz.domain.object.Result;

import java.util.List;

public interface ResultRepository {

    /**
     * 結果検索
     *
     * @param quiz_id ID
     * @param userId ユーザID
     * @return 結果
     */
    List<Result> find(String quiz_id, String userId);

    /**
     * 結果更新
     *
     * @param result 更新対象のクイズ結果
     * @return 結果
     */
    Result save(Result result);
}
