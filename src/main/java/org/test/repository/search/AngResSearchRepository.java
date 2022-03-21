package org.test.repository.search;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

import java.util.List;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.elasticsearch.search.sort.SortBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.test.domain.AngRes;

/**
 * Spring Data Elasticsearch repository for the {@link AngRes} entity.
 */
public interface AngResSearchRepository extends ElasticsearchRepository<AngRes, Long>, AngResSearchRepositoryInternal {}

interface AngResSearchRepositoryInternal {
    Page<AngRes> search(String query, Pageable pageable);
}

class AngResSearchRepositoryInternalImpl implements AngResSearchRepositoryInternal {

    private final ElasticsearchRestTemplate elasticsearchTemplate;

    AngResSearchRepositoryInternalImpl(ElasticsearchRestTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    @Override
    public Page<AngRes> search(String query, Pageable pageable) {
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(queryStringQuery(query));
        nativeSearchQuery.setPageable(pageable);
        List<AngRes> hits = elasticsearchTemplate
            .search(nativeSearchQuery, AngRes.class)
            .map(SearchHit::getContent)
            .stream()
            .collect(Collectors.toList());

        return new PageImpl<>(hits, pageable, hits.size());
    }
}
