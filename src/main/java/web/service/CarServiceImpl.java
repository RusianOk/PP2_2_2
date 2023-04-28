package web.service;


import org.springframework.stereotype.Service;
import web.model.Car;
import java.util.Arrays;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private List<Car> cars = Arrays.asList(
            new Car("Toyota", "Camry", 2018),
            new Car("Honda", "Civic", 2020),
            new Car("Ford", "Mustang", 2019),
            new Car("Chevrolet", "Camaro", 2017),
            new Car("Tesla", "Model S", 2021)
    );

    @Override
    public List<Car> getAllCars() {
        return cars;
    }

    @Override
    public List<Car> getCars(int count) {
        if (count >= cars.size()) {
            return cars;
        }
        return cars.subList(0, count);
    }

    public List<Car> getCarsForModel(Integer count) {
        if (count == null || count >= cars.size()) {
            return getAllCars();
        } else {
            return getCars(count);
        }
    }
}
