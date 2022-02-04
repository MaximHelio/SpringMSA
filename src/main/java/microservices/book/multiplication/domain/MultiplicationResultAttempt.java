package microservices.book.multiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * {@link User}가 {@link Multiplication}을 계산한 답안을 정의한 클래스
 */
// 모든 상수 필드를 갖는 생성자를 만듦
@RequiredArgsConstructor
// 모든 필드의 getter를 만듦
@Getter
// 해당 클래스의 toString() 메서드를 일기 쉽게 만듦
@ToString
// equals()와 hashCode() 메서드를 만듦
@EqualsAndHashCode
public final class MultiplicationResultAttempt {

    private final User user;
    private final Multiplication multiplication;
    private final int resultAttempt;

    //JSON (역)직렬화를 위한 빈 생성자
    MultiplicationResultAttempt(){
        user = null;
        multiplication = null;
        resultAttempt = -1;
    }
}
