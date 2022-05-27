package net.springio.workshops.thymeleafworkshop.bike;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

@Service
public class BikeService {
    private final SortedMap<Long, Bike> bikeMap = new TreeMap<>();

    public BikeService() {
        bikeMap.put(1L, new Bike(1L, "Trek", "Domane SL 2022"));
        bikeMap.put(2L, new Bike(2L, "Trek", "1.7"));
        bikeMap.put(3L, new Bike(3L, "Specialized", "Roubaix"));
    }

    public List<Bike> getBikes() {
        return List.copyOf(bikeMap.values());
    }

    public Bike createBike(CreateBikeParameters parameters) {
        long id = bikeMap.lastKey() + 1;
        return bikeMap.put(id, new Bike(id, parameters.brand(), parameters.type()));
    }
}
