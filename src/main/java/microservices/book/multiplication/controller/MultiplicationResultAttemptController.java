package microservices.book.multiplication.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import microservices.book.multiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 사용자가 제출한 답안을 확인하고 채점결과를 반환.
 */
@RestController
@RequestMapping("/results")
public class MultiplicationResultAttemptController {
    private final MultiplicationService multiplicationService;

    @Autowired
    MultiplicationResultAttemptontroller(final MultiplicationService multiplicationService){
        this.multiplicationService = multiplicationServic;
    }
    // TODO: POST 구현체를 추가
    @RequiredArgsConstructor
    @NoArgsConstructor(force=true)
    @Getter
    static final class ResultResponse {
        private final boolean correct;
    }
}
