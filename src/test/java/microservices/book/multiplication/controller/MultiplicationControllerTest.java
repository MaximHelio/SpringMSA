package microservices.book.multiplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.service.MultiplicationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
// 스프링의 웹 애플리케이션 컨텍스트 초기화. MVC레이어와 관련된 설정만 불러옴. MockMvc빈도 불러옴
@WebMvcTest(MultiplicationController.class)
public class MultiplicationControllerTest {
    // 스프링이 진짜 빈(MultiplicationServiceImpl)대신 목 개체를 주입해야하기 때문에, 목 객체는 given()메서드에서지정한 대로 값을 반환
    @MockBean
    private MultiplicationService multiplicationService;

    @Autowired
    private MockMvc mvc;

    // 이 객체는 initFields() 메소드를 이용해 자동으로 초기화
    // JacksonTester 객체를 사용해 JSON의 내용을 쉽게 확인할 수 있음. JacksonTester 객체는 자동으로 설정할 수 있고, @JacksonTest 애너테이션을 이용해 자동으로 주입 가능
    private JacksonTester<Multiplication> json;

    // WebMvcTest를 사용하기 때문에 수동으로 설정해야함
    @Before
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
    }

    @Test
    public void getRandomMultiplicationTest() throws Exception {
        // given
        given(multiplicationService.createRandomMultiplication())
                .willReturn(new Multiplication(70, 20));

        // when
        MockHttpServletResponse response = mvc.perform(
                get("/multiplications/random")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString())
                .isEqualTo(json.write(new Multiplication(70, 20)).getJson());
    }

}
