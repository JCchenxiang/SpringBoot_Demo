package com.xchen.testES;

import com.xchen.utils.ElasticSearchUtils;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.Test;

import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;


public class ElasticSearchConnection {
    ElasticSearchUtils esUtils = ElasticSearchUtils.getInstance();

    /**
     * 创建索引
     * @throws Exception
     */
    @Test
    public void CreateIndex() throws Exception{
        Client client = esUtils.getClient();
        IndexResponse response = client.prepareIndex("twitter", "tweet", "1")
                .setSource(jsonBuilder()
                        .startObject()
                        .field("user", "kimchy")
                        .field("postDate", new Date())
                        .field("message", "trying out Elasticsearch")
                        .endObject()
                )
                .get();
    }

    /**
     *  根据id查询
     * @Param index：索引 type：类型 id
     */
    @Test
    public void getById(){
        GetResponse response=esUtils.getClient().prepareGet("tomcat-access-log-2019.07.12","%{type}","hlkM5GsBrQhC2lWSQujS").get();
        System.out.println(response.getSourceAsString());
    }

    /**
     *  根据索引和类型查找
     */
    @Test
    public  void queryAll(){
        SearchRequestBuilder searchRequestBuilder = esUtils.getClient().prepareSearch("tomcat-access*").setTypes("%{type}");
        SearchResponse searchResponse = searchRequestBuilder.setQuery(QueryBuilders.matchAllQuery()).execute().actionGet();
        SearchHits searchHits = searchResponse.getHits();
        System.out.println(searchHits.getTotalHits());
        for(SearchHit hit:searchHits){
            System.out.println(hit.getSourceAsString());
        }

    }


}
