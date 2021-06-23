package ioc.car;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Data
public class Car {
    private String name;
    private Integer price;
}
