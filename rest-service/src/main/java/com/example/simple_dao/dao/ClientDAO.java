package com.example.simple_dao.dao;

import com.example.simple_dao.entity.Client;


import java.util.List;

/**
 * Created by Asus on 31.01.2018.
 */
public interface ClientDAO {

    void addClient(Client client);

    List<Client > getAllClient ();

    Client getById(int id);

     void updatePhone(String phone, int id);

     void remove(String name);

}
