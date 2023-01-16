package com.example.aspectSpring.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Component
public class GreetingsImpl implements Greetings {
    private Long id;
    private String msg;

    @Override
    public void sayHello() {
        System.out.printf("Greetings, %s\n", getMsg());
    }
}
