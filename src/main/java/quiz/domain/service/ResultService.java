package quiz.domain.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import quiz.domain.object.Result;
import quiz.domain.repository.ResultRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResultService {

    @NonNull
    private final ResultRepository resultRepository;

    /**
     * 結果検索
     */
    public Optional<Result> findById(String quiz_id) {
        return this.resultRepository.findById(quiz_id);
    }

    /**
     * 結果検索
     */
    public Result save(Result result) {
        return this.resultRepository.save(result);
    }
}
