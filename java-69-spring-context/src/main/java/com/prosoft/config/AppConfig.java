package com.prosoft.config;

import com.prosoft.domain.Aircraft;
import com.prosoft.domain.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * (2) Класс конфигурации позволяет добавлять бины в контекст Spring.
 * Аннотация @ComponentScan необходима для сканирования классов с аннотацией @Component
 */
@Configuration
@ComponentScan(basePackages = "com.prosoft.domain")
public class AppConfig {

    /**
     * Метод car() создает один бин класса Car
     * Для добавления бина в контекст нужно определить метод с аннотацией @Bean, возвращающий экземпляр объекта,
     *
     * @return
     */
    @Bean
    public Car car() {
        return new Car("bmw", "black");
    }

    /**
     * Методы aircraft1(), aircraft2(), aircraft3() создают три бина класса Aircraft
     * @return
     */
    @Bean
    public Aircraft aircraft1() {
        return new Aircraft("Boeing", "Delta");
    }

    @Bean
    public Aircraft aircraft2() {
        return new Aircraft("Boeing", "American Airlines");
    }

    @Bean
    public Aircraft aircraft3() {
        return new Aircraft("Airbus", "Lufthansa");
    }

}
