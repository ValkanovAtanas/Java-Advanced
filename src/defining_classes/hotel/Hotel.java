package defining_classes.hotel;

import defining_classes.car_salesman.Car;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Hotel {
    private String name;
    private int capacity;
    private int count = 0;
    private List<Car> carList;

    public Hotel (String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.carList = new ArrayList<>();
    }

    public boolean remove (String name) {

        return false;
    }



    }

