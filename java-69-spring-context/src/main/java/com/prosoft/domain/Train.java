package com.prosoft.domain;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * (8) Класс Train
 * Экземпляры класса добавляется в контекст через стереотипную аннотацию @Component и @ComponentScan.
 * Работает с версией Java не ниже 11
 * Для использования аннотации @PostConstruct необходимо в pom.xml добавить зависимость:
 *
 * <dependency>
 *     <groupId>Javax.annotation</groupId>
 *     <artifactId>Javax.annotation-api</artifactId>
 *     <version>1.3.2</version>
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

    /**
     * Метод с аннотацией @PostConstruct Spring вызовет после того, как закончится выполнение конструктора
     */
    @PostConstruct
    public void init() {
        this.name = "067К KIEV - WARSAW";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return id == train.id && Objects.equals(name, train.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
