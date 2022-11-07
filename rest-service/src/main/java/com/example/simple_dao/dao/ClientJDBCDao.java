package com.example.simple_dao.dao;

import com.example.simple_dao.entity.Client;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientJDBCDao implements ClientDAO {

    @Override
    public void addClient(Client client) {

        Connection connection = null;
        // Создаем соединение и готовим выражение.
        connection = getConnection();
        PreparedStatement statement;

        try {
            // По условию метода в случае отсутствия данных о марке вернет -1

            // После этого мы добавляем в табицу cars значения марки, модели, цены. Это мы подготовили запрос, но еше не выполнили.
            // Нам нужно будет заполнить данные вместо знаков ? И дать команду execute
            statement = connection.prepareStatement("INSERT INTO clients(name, age, phone) VALUES (?, ?, ?)");

            // Прописываем выражения для вставки в таблицу cars
            statement.setString(1, client.getName());
            statement.setInt(2, client.getAge());
            statement.setString(3, client.getPhone());

         //   statement.setInt(1, markId);  name
         //   statement.setString(2, car.getModel());
         //   statement.setInt(3, car.getPrice());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<Client> getAllClient() {
        // Создаем промежуточный список куда будут добавляться результаты.
        List<Client> allClients = new ArrayList<>();
        // Объявляем соединение и готовим выражение
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            // Выбираем набор полей, используя join
            statement = connection.prepareStatement("SELECT * FROM clients");

            ResultSet rs = statement.executeQuery();
            // Забираем из результирующего набора получившиеся записи. Колонки это порядковые номера нашего запроса.
            while (rs.next()) {
                long id = rs.getLong(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String phone = rs.getString(4);

                // Создаем объекты с выгруженными данными и добавляем в коллекцию.
                Client client = new Client();
                client.setId(id);
                client.setName(name);
                client.setAge(age);
                client.setPhone(phone);
                allClients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Если не возникает исключительных ситуаций, то список возвращается в качестве результата.
        return allClients;
    }

    @Override
    public Client getById(int id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();
        try {
            // Создаем запрос на получение авто по айди
            preparedStatement = connection.prepareStatement("SELECT * FROM clients WHERE id_clients = ? ");

            // выполняем выражение передавая id из параметра метода
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            //  значения считываем в объект
            if (rs.next()) {
                long id_new = rs.getLong(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String phone = rs.getString(4);



                Client client = new Client();
                client.setId(id_new );
                client.setName(name);
                client.setAge(age);
                client.setPhone(phone);
                return client;



            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && preparedStatement != null) {

                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    @Override
    public void updatePhone(String phone, int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement("UPDATE clients SET phone = ? WHERE id_clients = ?");
            // Передаем вместо знаков ? значения из входных параметров: в первое - цену, во второй знак ? - айди авто
            preparedStatement.setString(1, phone);
            preparedStatement.setInt(2, id);

            // Записываем, сколько значений обновлено
            int updatedValues = preparedStatement.executeUpdate();

            System.out.println("Values updated: " + updatedValues);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && preparedStatement != null) {

                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void remove(String name_1) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {
            // Для начала мы получаем id марки, используя метод из данного класса
            // Даже, если такого значения не будет и метод вернет нам -1, то ничего страшного - с таким id записей нет априори
           // int markId = getMarkId(mark, connection);
            preparedStatement = connection.prepareStatement("DELETE FROM clients WHERE name = ? ");
            // Подставляем в наш запрос полученное значение id марки
            preparedStatement.setString(1, name_1);

            // Получаем количество удаленных записей
            int deletedValues = preparedStatement.executeUpdate();

            System.out.println("Values deleted: " + deletedValues);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && preparedStatement != null) {

                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // Чтобы мы не обращались постоянно к connection, используем метод соединения.
    // В случае ошибки будет возвращаться нулл.
    private Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsshop?useSSL=false", "root", "root");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
