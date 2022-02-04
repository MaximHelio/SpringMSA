package microservices.book.multiplication.controller;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 해당 컨트롤러와 @RequestMapping(또는 @GetMapping)이 붙은 메서드가 응답 내용 자체를 반환한다는 뜻
// 만약 @Controller 사용하면, 클래스나 모든 메서드에 @ResponseBody 붙여야 함 즉, @RequestController = @Controller + @ResponseBody
@RestController
// 클래스 내 모든 메서드에 최사우이 경로 지정
@RequestMapping("/multiplications")
final class MultiplicationController {

    private final MultiplicationService multiplicationService;

    @Autowired
    public MultiplicationController(final MultiplicationService multiplicationService){
        this.multiplicationService = multiplicationService;
    }
    // @RequestMapping(method=RequestMethod.GET)을 줄여 쓴 것.
    @GetMapping("/random")
    Multiplication getRandomMultiplication() {
        return multiplicationService.createRandomMultiplication();
    }
}
