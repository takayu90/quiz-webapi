package quiz.infrastructure.repository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import quiz.domain.object.Quiz;
import quiz.domain.repository.QuizRepository;
import quiz.infrastructure.entity.QuizEntity;

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
public class QuizRepositoryImpl implements QuizRepository {

    @NonNull
    private final QuizJpaRepository quizJpaRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Quiz> find(String quizId, String category, String type) {
        List<QuizEntity> list = this.quizJpaRepository.findAll(Specification
                .where(this.idEqual(quizId))
                .and(this.categoryEqual(category))
                .and(this.typeEqual(type))
        );
        return list.stream().map(QuizEntity::toDomainObject).collect(Collectors.toList());
    }

    /**
     * 検索条件指定(ID)
     *
     * @param quizId ID
     * @return Specification
     */
    private Specification<QuizEntity> idEqual(String quizId) {
        return StringUtils.isEmpty(quizId) ? null : new Specification<QuizEntity>() {
            @Override
            public Predicate toPredicate(Root<QuizEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("quizId"), quizId);
            }
        };
    }

    /**
     * 検索条件指定(カテゴリ)
     *
     * @param category カテゴリ
     * @return Specification
     */
    private Specification<QuizEntity> categoryEqual(String category) {
        return StringUtils.isEmpty(category) ? null : new Specification<QuizEntity>() {
            @Override
            public Predicate toPredicate(Root<QuizEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("category"), category);
            }
        };
    }

    /**
     * 検索条件指定(タイプ)
     *
     * @param type タイプ
     * @return Specification
     */
    private Specification<QuizEntity> typeEqual(String type) {
        return StringUtils.isEmpty(type) ? null : new Specification<QuizEntity>() {
            @Override
            public Predicate toPredicate(Root<QuizEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("type"), type);
            }
        };
    }
}
