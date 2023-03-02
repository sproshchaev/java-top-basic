package com.prosoft.controller;

import com.prosoft.domain.Car;
import com.prosoft.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Класс CarController
 */
@Controller
public class CarController {

    private final CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/welcome")
    public String welcomePage(Model model) {
        return "welcome";
    }

    /**
     * Хендлер для запросов, выводящих список всех автомобилей http://localhost:8080/cars
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
     * Хендлер для запросов с передачей id в качестве параметра http://localhost:8080/car?id=1
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

}
