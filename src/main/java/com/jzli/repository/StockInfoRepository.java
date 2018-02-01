package com.jzli.repository;

import com.jzli.bean.StockInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

/**
 * =======================================================
 *
 * @Company 产品技术部
 * @Date ：2018/2/1
 * @Author ：李金钊
 * @Version ：0.0.1
 * @Description ：
 * ========================================================
 */
@Repository
public class StockInfoRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void add(StockInfo stockInfo) {
        StockInfo stockInfo1 = get(stockInfo.getId());
        if (ObjectUtils.isEmpty(stockInfo1)) {
            mongoTemplate.insert(stockInfo);
        }
    }

    public StockInfo get(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, StockInfo.class);
    }

}
