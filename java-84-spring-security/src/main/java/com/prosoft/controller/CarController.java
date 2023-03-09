package com.prosoft.controller;

import com.prosoft.domain.Car;
import com.prosoft.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс CarController использует семантические аннотации @GetMapping, @PostMapping
 */
@Controller
public class CarController {

    private final CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    /**
     * Хендлер для GET-запросов http://localhost:8080/welcome
     *
     * @param model
     * @return
     */
    @GetMapping("/welcome")
    public String welcomePage(Model model) {
        return "welcome";
    }

    /**
     * Хендлер для GET-запросов, выводящих список всех автомобилей http://localhost:8080/cars
     *
     * @param model
     * @return
     */
    @GetMapping("/cars")
    public String carPage(Model model) {
        List<Car> carList = (List<Car>) carRepository.findAll();
        model.addAttribute("carList", carList);
        return "cars";
    }

    /**
     * Хендлер для GET-запросов с передачей id в качестве параметра http://localhost:8080/car?id=1
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/car")
    public String editPage(@RequestParam("id") long id, Model model) {
        Car car = carRepository.findById(id).get(); //orElseThrow(NotFoundException::new);
        model.addAttribute("car", car);
        return "car";
    }

    /**
     * Хендлер для POST запроса http://localhost:8080/create (через Postman)
     * Body (form-data):
     * - brand=bmw
     * - color=Yellow
     * Метод createCar создает новый автомобиль и генерирует для него новый новый id, так как в сущности Car используется аннотация
     *
     * @param brand
     * @param color
     * @param model
     * @return
     * @GeneratedValue на поле id
     */
    @PostMapping("/create")
    public String createCar(@RequestParam String brand, @RequestParam(required = false) String color, Model model) {
        Car car = carRepository.save(new Car(brand, color));
        model.addAttribute("car", car);
        return "car";
    }

    /**
     * Хендлер для PUT-запроса для изменения сущности http://localhost:8080/update (через Postman)
     * Body (form-data):
     * -id=1
     * - brand=bmw
     * - color=Yellow
     * Метод updateCar изменяет параметры автомобиля
     *
     * @param id
     * @param brand
     * @param color
     * @param model
     * @return
     */
    @PutMapping("/update")
    public String updateCar(@RequestParam long id, @RequestParam String brand, @RequestParam String color, Model model) {
        Car car = carRepository.save(new Car(id, brand, color));
        model.addAttribute("car", car);
        return "car";
    }

    /**
     * Хендлер для DELETE-запроса для изменения сущности http://localhost:8080/delete (через Postman)
     * Body (form-data):
     * -id=1
     * Метод deleteCar удаляет автомобиль
     *
     * @param id
     * @param model
     * @return
     */
    @DeleteMapping("/delete")
    public String deleteCar(@RequestParam long id, Model model) {
        carRepository.delete(new Car(id));
        return "welcome";
    }

}
