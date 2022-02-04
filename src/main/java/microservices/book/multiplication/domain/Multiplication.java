package microservices.book.multiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 애플리케이션에서 곱셈을 나타내는 클래스 (a * b)
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
// final로 선언 => 해당 클래스의 모든 필드는 getter로만 접근 가능, 해당 클래스는 불변
// 불변성 => 다중 스레드 환경에서 일어날 수 있는 여러 문제에서 안전하게 만들어줌
public final class Multiplication {

    // 두 인수
    private final int factorA;
    private final int factorB;

    // JSON (역)직렬화를 위한 빈 생성자
    Multiplication() {
        this(0, 0);
    }
}
