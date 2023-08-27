package com.gua.es.sz;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author 86188
 */
@Component
public interface GoodsRepository extends ElasticsearchRepository<Goods,Long> {
}
