package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImpl;


@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarServiceImpl carServiceImpl;

    @GetMapping
    public String getCars(@RequestParam(required = false) Integer count, Model model) {
        if (count == null || count >= carServiceImpl.getAllCars().size()) {
            model.addAttribute("cars", carServiceImpl.getAllCars());
        } else {
            model.addAttribute("cars", carServiceImpl.getCars(count));
        }
        return "cars";
    }
}

