package org.test.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of {@link AngGrpSearchRepository} to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class AngGrpSearchRepositoryMockConfiguration {

    @MockBean
    private AngGrpSearchRepository mockAngGrpSearchRepository;
}
