package com.prosoft.domain;

import org.springframework.stereotype.Component;

/**
 * (8) Класс Train
 * Экземпляры класса добавляется в контекст через стереотипную аннотацию @Component и @ComponentScan.
 * Работает с версией Java не ниже 11
 * Для использования аннотации @PostConstruct необходимо в pom.xml добавить зависимость:
 *
 * <dependency>
 * <groupId>Javax.annotation</groupId>
 * <artifactId>Javax.annotation-api</artifactId>
 * <version>1.3.2</version>
 * </dependency>
 */
@Component
public class Train {
    private long id;
    private String name;

    public Train() {
    }

    public Train(String name) {
        this.name = name;
    }
}
