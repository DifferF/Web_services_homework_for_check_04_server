package com.example.restservice;

import com.example.simple_dao.MainDao;
import com.example.simple_dao.entity.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class AllController {

    @GetMapping("/translator")
    public String translatorOne(@RequestParam(value = "name", defaultValue = "Пустое_значение") String name) {
        Translator t1 = new Translator();
        return  t1.wordsTranslator(name);
    }

    @GetMapping("/wordList")
    public String[] wordList() {
        String[] charValue = new String[]{"я","совет","холст","дополнение","пустыня","молочные_продукты","окружать","свободный","директор_школы","довольно"};
        return  charValue;
    }

    @GetMapping("/creatorClient")
    public String creatorClient( @RequestParam(value = "name", defaultValue = "Test_name") String name,
                           @RequestParam(value = "age", defaultValue = "20") int age,
                           @RequestParam(value = "phone", defaultValue = "380970000") String phone) {

        String qwee = "ok";
        MainDao.creatorClient(name,age,phone);
        return  qwee;
    }

    @GetMapping("/allClient")
    public List<Client>  allClient() {

        return  MainDao.allClient();
    }
    // String request = "http://localhost:8080/allClient"

    @GetMapping("/dellClients")
    public String dellClients( @RequestParam(value = "name", defaultValue = "Test_name") String name ) {

        String qwee = "ok";
        MainDao.dellClients(name);
        return  qwee;
    }
    // String request = "http://localhost:8080/dellClients?name=testName"

}