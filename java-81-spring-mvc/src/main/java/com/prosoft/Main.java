package com.prosoft;

import com.prosoft.domain.Car;
import com.prosoft.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * java-81-spring-mvc
 */
@SpringBootApplication
public class Main {

	/**
	 * Эмулятор заполнения базы данных данными - для упрощения примера без использования БД
	 */
	@Autowired
	private CarRepository repository;

	@PostConstruct
	public void init() {
		repository.save(new Car("bmw", "black"));
		repository.save(new Car("bmw", "red"));
	}

	/**
	 * Метод main()
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
