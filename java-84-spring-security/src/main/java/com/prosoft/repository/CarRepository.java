package com.prosoft.repository;


import com.prosoft.domain.Car;
import org.springframework.data.repository.CrudRepository;

/**
 * Интерфейс CarRepository
 */
public interface CarRepository extends CrudRepository<Car, Long> {

}
