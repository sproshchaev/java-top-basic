package com.prosoft;

import com.prosoft.config.AppConfig;
import com.prosoft.domain.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * java-69-spring-context
 * Пример двух вариантов добавления в контекст бинов:
 * 1) с использованием аннотации @Bean
 * 2) с использованием стереотипных аннотаций @Component
 */
public class Main {
    public static void main(String[] args) {

        /**
         * (3) Настройка Spring на инициализацию контекста с использованием класса конфигурации AppConfig.class
         */
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        /**
         * (4) Получение из контекста единичного бина класса Car (бин в контекст добавлен через аннотацию @Bean)
         */
        Car car = context.getBean(Car.class);
        System.out.println("Car: " + car);

        /**
         * (5) Получение из контекста нескольких бинов класса Aircraft (бины в контекст добавлены через аннотацию @Bean)
         */
        Aircraft aircraft1 = context.getBean("aircraft1", Aircraft.class);
        Aircraft aircraft2 = context.getBean("aircraft2", Aircraft.class);
        Aircraft aircraft3 = context.getBean("aircraft3", Aircraft.class);
        System.out.println("Aircraft's: \n" + aircraft1 + ", \n" + aircraft2 + ", \n" + aircraft3);

        /**
         * (7) Получение из контекста единичного бина класса Ship (бин в контекст добавлен через стереотипную аннотацию)
         * Экземпляр класса формируется без инициализации полей
         */
        Ship ship = context.getBean(Ship.class);
        System.out.println("Ship: " + ship);

        /**
         * (8) Получение из контекста единичного бина класса Train (бин в контекст добавлен через стереотипную аннотацию)
         * Экземпляр класса инициируется через метод с аннотацией @PostConstruct
         */
        Train train = context.getBean(Train.class);
        System.out.println("Train: " + train);

        /**
         * (11) Получение из контекста единичного бина класса Train (бин в контекст добавлен через стереотипную аннотацию)
         * Внедрение бина AirCompany производиться через аннотацию @Autowired
         * После получения экземпляра класса Ticket из контекста производится инициализация полей через setter
         */
        Ticket ticket = context.getBean(Ticket.class);
        ticket.setId(1);
        ticket.getAirCompany().setName("Delta");
        System.out.println("Ticket: " + ticket);

    }
}
