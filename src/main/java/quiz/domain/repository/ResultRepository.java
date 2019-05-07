package quiz.domain.repository;

import quiz.domain.object.Result;

import java.util.Optional;

public interface ResultRepository {

    /**
     * 結果検索
     *
     * @param quiz_id 検索したいクイズのID
     * @return 結果
     */
    Optional<Result> findById(String quiz_id);

    /**
     * 結果更新
     *
     * @param results 更新対象のクイズ結果
     * @return 結果
     */
    Result save(Result results);
}
