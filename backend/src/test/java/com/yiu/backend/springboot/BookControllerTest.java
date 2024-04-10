package com.yiu.backend.springboot;

import com.yiu.backend.model.Book;
import com.yiu.backend.response.ApiResponse;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("dev")

@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookControllerTest {

    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    private static final Logger log = LoggerFactory.getLogger(BookServiceTests.class);

    @Test
    public void test1() throws Exception {
        template.postForEntity("http://localhost:" + port + "/books", new Book("user1", "pass1", "pass1"), Book.class);
        log.info("[添加书本成功]\n");
        // TODO 如果是返回的集合,要用 exchange 而不是 getForEntity ，后者需要自己强转类型


        ResponseEntity<ApiResponse> response2 = template.exchange("http://localhost:" + port + "/books", HttpMethod.GET, null, new ParameterizedTypeReference<ApiResponse>() {
        });
        final ApiResponse body = response2.getBody();
        log.info("[查询所有] - [{}]\n", body);
//        Integer bookId = body.getData().getId();
/*        ResponseEntity<Book> response3 = template.getForEntity("http://localhost:" + port + "/books/{id}", Book.class, bookId);
        log.info("[主键查询] - [{}]\n", response3.getBody());
        template.put("http://localhost:" + port + "/books/{id}", new Book("user1", "pass1", "pass1"), bookId);
        log.info("[修改书本成功]\n");
        template.delete("http://localhost:" + port + "/books/{id}", bookId);*/
        log.info("[删除书本成功]");
    }
}
