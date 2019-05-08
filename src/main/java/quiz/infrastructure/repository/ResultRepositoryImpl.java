package quiz.infrastructure.repository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import quiz.domain.object.Result;
import quiz.domain.repository.ResultRepository;
import quiz.infrastructure.entity.ResultEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 永続化の実装クラス
 * ドメインオブジェクトをEntityに変換してJPAをラップする
 */
@Repository
@RequiredArgsConstructor
public class ResultRepositoryImpl implements ResultRepository {

    @NonNull
    private final ResultJpaRepository resultJpaRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Result> find(String quizId, String userId) {
        List<ResultEntity> list = this.resultJpaRepository.findAll(Specification
                .where(this.idEqual(quizId))
                .and(this.userIdEqual(userId))
        );
        return list.stream().map(ResultEntity::toDomainObject).collect(Collectors.toList());
    }

    /**
     * 検索条件指定(ID)
     * @param quizId ID
     * @return Specification
     */
    private Specification<ResultEntity> idEqual(String quizId) {
        return StringUtils.isEmpty(quizId) ? null : new Specification<ResultEntity>() {
            @Override
            public Predicate toPredicate(Root<ResultEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("quizId"), quizId);
            }
        };
    }

    /**
     * 検索条件指定(ユーザID)
     * @param userId ユーザID
     * @return Specification
     */
    private Specification<ResultEntity> userIdEqual(String userId) {
        return StringUtils.isEmpty(userId) ? null : new Specification<ResultEntity>() {
            @Override
            public Predicate toPredicate(Root<ResultEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("userId"), userId);
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Result save(Result result) {
        return this.resultJpaRepository.save(ResultEntity.build(result)).toDomainObject();
    }
}
