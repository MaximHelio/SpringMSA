package microservices.book.multiplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.domain.MultiplicationResultAttempt;
import microservices.book.multiplication.domain.User;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;

public class MultiplicationResultAttemptControllerTest {

    @MockBean
    private MultiplicationService multiplicationService;

    @Autowired
    private MockMvc mvc;

    // 이 객체는 initFields() 메서드를 이용해 자동으로 초기화
    private JacksonTester<MultiplicationResultAttempt> jsonResult;
    private JacksonTester<MultiplicationResultAttemptController.ResultResponse> jsonResponse;

    @Before
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());

    }

    @Test
    public void postResultReturnCorrect() throws Exception{
        genericParameterizedTest(false);
    }

    void genericParameterizedTest(final boolean correct) throws Exception {
        //given(지금 서비스를 테스트하는 것이 아님)
        given(multiplicationService
            .checkAttempt(any(MultiplicationResultAttempt.class)))
            .willReturn(correct);

        User user = new User("john");
        Multiplication multiplication = new Multiplication(50, 70);
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3500);

        //when
        MockHttpServletResponse response = mvc.perform(post("/results")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonResult.write(attempt).getJson()))
                .andReturn().getResponse();
        //then
        assertThat(respnse.getStatus()).isEqualTo(HttpStatus.OK.value())
        assertThat(response.getContents)
    }

}
