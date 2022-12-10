package com.chen;

import com.alibaba.fastjson.JSON;
import com.chen.pojo.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.AsyncSearchClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;

@SpringBootTest
class EsApiApplicationTests {

    @Qualifier("restHighLevelClient")
    @Autowired
    private RestHighLevelClient client;

    @Test
    void contextLoads() {
        AsyncSearchClient asyncSearchClient = client.asyncSearch();
        System.out.println(asyncSearchClient);
    }

    /**
     * 创建索引
     *
     * @throws IOException
     */
    @Test
    void testCreateIndex() throws IOException {
        //1 创建索引请求
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("chenyuchao");

        //2 客户端执行请求 并获得响应
        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);

        System.out.println(createIndexResponse);
    }

    @Test
    void testExistIndex() throws IOException {
        GetIndexRequest getIndexRequest = new GetIndexRequest("chenyuchao");
        boolean exists = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    @Test
    void testDeleteIndex() throws IOException {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("chenyuchao");
        AcknowledgedResponse delete = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        System.out.println(delete);
    }

    /**
     * 测试添加文档
     */
    @Test
    void testAddDocument() throws IOException {
        //创建对象
        User user = new User("陈宇超", 44);

        //创建请求
        IndexRequest indexRequest = new IndexRequest("chenyuchao");

        //规则
        indexRequest.id("1");
        indexRequest.timeout(TimeValue.timeValueSeconds(1));
        indexRequest.timeout("1s");

        //将我们的数据放入请求
        IndexRequest source = indexRequest.source(JSON.toJSONString(user), XContentType.JSON);

        //客户端发送请求
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);

        System.out.println(indexResponse.toString());
        System.out.println(indexResponse.status());
    }

    /**
     * 获取文档，判断是否存在 get/index/doc/1
     */
    @Test
    void testIsExitsDocument() throws IOException {
        GetRequest getRequest = new GetRequest("chenyuchao", "2");
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");

        boolean exists = client.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * 获得文档的信息
     *
     * @throws IOException
     */
    @Test
    void testGetDocument() throws IOException {
        GetRequest getRequest = new GetRequest("chenyuchao", "1");
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        //打印文档的数据
        System.out.println(getResponse.getSourceAsString());

    }

    //更新文档信息
    @Test
    void testUpdateDocument() throws IOException {
        UpdateRequest updateRequest = new UpdateRequest("chenyuchao", "1");

        User user = new User("chenyuchao", 1000);

        updateRequest.doc(JSON.toJSONString(user), XContentType.JSON);

        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);

        System.out.println(updateRequest.toString());
    }

    //删除文档信息
    @Test
    void testDeleteDocument() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("chenyuchao", "1");

        deleteRequest.timeout("1s");

        DeleteResponse delete = client.delete(deleteRequest, RequestOptions.DEFAULT);

        System.out.println(delete.status());
        System.out.println(delete);
    }

    //批量插入数据
    @Test
    void testBulkRequest() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");

        ArrayList<User> userList = new ArrayList<>();

        userList.add(new User("chenyuchao", 12));
        userList.add(new User("chenyuchao", 13));
        userList.add(new User("chenyuchao", 14));
        userList.add(new User("chenyuchao", 17));
        userList.add(new User("chenyuchao", 112));
        userList.add(new User("chenyuchao", 132));
        userList.add(new User("chenyuchao", 1312));
        userList.add(new User("chenyuchao", 133));
        userList.add(new User("chenyuchao", 55));
        userList.add(new User("chenyuchao", 12));
        userList.add(new User("chenyuchao", 12));

        for (int i = 0; i < userList.size(); i++) {
            bulkRequest.add(new IndexRequest("chenyuchao")
                    .id("" + (i + 1))
                    .source(JSON.toJSONString(userList.get(i)), XContentType.JSON));
        }
        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);

        System.out.println(bulkResponse.status());
        //是否失败
        System.out.println(bulkResponse.hasFailures());

    }

    //测试搜索
    @Test
    void testSearch(){
        
    }
}
