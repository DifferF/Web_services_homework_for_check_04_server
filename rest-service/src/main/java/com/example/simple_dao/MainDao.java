package com.example.simple_dao;

import com.example.simple_dao.dao.CarDAO;
import com.example.simple_dao.dao.ClientDAO;
import com.example.simple_dao.dao.DAOFactory;
import com.example.simple_dao.dao.IDAOFactory;
import com.example.simple_dao.entity.Car;
import com.example.simple_dao.entity.Client;

import java.util.List;


public class MainDao {

    public static void main(String[] args) {
       // creatorCar();
       // dellCarMark();
    }

    public static void creatorClient(String name, int age, String phone){
        // Сначала создаем фабрику - получаем ее экземпляр.
        IDAOFactory factory = DAOFactory.getInstance();
        // Затем с помощью нашей фабрики получаем CarJDBCDao
        ClientDAO clientsDao = factory.getClientDAO();
        Client client = new Client();
        client.setName(name);
        client.setAge(age);
        client.setPhone(phone);
        clientsDao.addClient(client);
    }

    public static void creatorCar(){
        // Сначала создаем фабрику - получаем ее экземпляр.
        IDAOFactory factory = DAOFactory.getInstance();
        // Затем с помощью нашей фабрики получаем CarJDBCDao
        CarDAO carDao = factory.getCarDAO();
        Car car = new Car();
        car.setMark("Марка");
        car.setModel("Модель");
        car.setPrice(12000);
        carDao.addCar(car);
    }

    public static List<Client> allClient(){
        // Сначала создаем фабрику - получаем ее экземпляр.
        IDAOFactory factory = DAOFactory.getInstance();
        // Затем с помощью нашей фабрики получаем CarJDBCDao
        ClientDAO clientsDao = factory.getClientDAO();

        List<Client> clients = clientsDao.getAllClient();

//        for (Client client1 : clients) {
//            System.out.println(client1.getId() + " " + client1.getName() + " " + client1.getAge() + " " + client1.getPhone());
//        }


        return clients;
    }

    public static void allCar(){
        // Сначала создаем фабрику - получаем ее экземпляр.
        IDAOFactory factory = DAOFactory.getInstance();
        // Затем с помощью нашей фабрики получаем CarJDBCDao
        CarDAO carDao = factory.getCarDAO();
        // Получение всех машин
        List<Car> cars = carDao.getAll();
        for (Car car : cars) {
        System.out.println(car.getId() + " " + car.getMark()
                    + " " + car.getModel() + " " + car.getPrice());
        }
    }

    public static void getByIdCar(){
        // Сначала создаем фабрику - получаем ее экземпляр.
        IDAOFactory factory = DAOFactory.getInstance();
        // Затем с помощью нашей фабрики получаем CarJDBCDao
        CarDAO carDao = factory.getCarDAO();
        // Ищем машину по айди
        Car car = carDao.getById(1);
        System.out.println(car.getId() + " " + car.getMark()
                + " " + car.getModel() + " " + car.getPrice());
    }

        public static void getByIdClient(){
            // Сначала создаем фабрику - получаем ее экземпляр.
            IDAOFactory factory = DAOFactory.getInstance();
            // Затем с помощью нашей фабрики получаем CarJDBCDao
            ClientDAO clientsDao = factory.getClientDAO();
            Client client_2 = clientsDao.getById(1);
            System.out.println(client_2.getId() + " " + client_2.getName() + " " + client_2.getAge() + " " + client_2.getPhone());
        }

        public static void updatePhone(){
                // Сначала создаем фабрику - получаем ее экземпляр.
                IDAOFactory factory = DAOFactory.getInstance();
                // Затем с помощью нашей фабрики получаем CarJDBCDao
                ClientDAO clientsDao = factory.getClientDAO();
               clientsDao.updatePhone("u932u0932",6);
        }

        public static void updatePrice(){
            // Сначала создаем фабрику - получаем ее экземпляр.
            IDAOFactory factory = DAOFactory.getInstance();
            // Затем с помощью нашей фабрики получаем CarJDBCDao
            CarDAO carDao = factory.getCarDAO();
            // Обновляем цену по айди
            carDao.updatePrice(1500,2);
        }

        public static void dellClients(String clientName){
            // Сначала создаем фабрику - получаем ее экземпляр.
            IDAOFactory factory = DAOFactory.getInstance();
            // Затем с помощью нашей фабрики получаем CarJDBCDao
            ClientDAO clientsDao = factory.getClientDAO();
            clientsDao.remove(clientName);
        }

        public static void dellCarMark(){
            // Сначала создаем фабрику - получаем ее экземпляр.
            IDAOFactory factory = DAOFactory.getInstance();
            // Затем с помощью нашей фабрики получаем CarJDBCDao
            CarDAO carDao = factory.getCarDAO();
            // Удаляем авто определенной марки
            carDao.remove("22");
        }


}
