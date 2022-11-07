package com.example.simple_dao.dao;

import com.example.simple_dao.entity.Car;


import java.util.List;

/**
 * Created by Asus on 31.01.2018.
 */
public interface CarDAO {
    
    void add(Car car);
    
    List<Car> getAll();

    void addCar(Car car);
    
    Car getById(int id);
    
    void updatePrice(int price, int carId);
    
    void remove(String mark);
    
}
