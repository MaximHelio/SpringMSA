package microservices.book.multiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import net.bytebuddy.build.ToStringPlugin;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public final class User {
    private final String alias;

    //JSON (역)직렬화를 위한 빈 생성자
    protected User(){
        alias = null;
    }
}
