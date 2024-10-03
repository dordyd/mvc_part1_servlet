package hello.servlet.basic;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@Data
//@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class HelloData {

    @NonNull
    private Long id;

    @NotEmpty
    private String username;

    @Range(min=19, max=100)
    private int age;
}
