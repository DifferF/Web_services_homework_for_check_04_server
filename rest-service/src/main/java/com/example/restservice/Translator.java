package com.example.restservice;

public class Translator {

    public static void main(String[] args) {

     //   System.out.println(wordsTranslator("совет"));
    }

    private String worldTranslator;

    public Translator(String worldTranslator) {
        this.worldTranslator = worldTranslator;
    }

    public Translator() {
    }

    public static String wordsTranslator(String world){

        switch (world){
            case "я":
            case "0":
                world = "I";
                break;
            case "совет":
            case "1":
                world = "Advice";
                break;
            case "холст" :
            case "2":
                world = "Canvas";
                break;
            case "дополнение" :
            case "3":
                 world = "Complement";
                 break;
            case "пустыня" :
            case "4":
                world = "Desert";
                break;
            case "молочные_продукты" :
            case "5":
                world = "Dairy";
                break;
            case "окружать" :
            case "6":
                world = "Envelop";
                break;
            case "свободный" :
            case "7":
                world = "Loose";
                break;
            case "директор_школы" :
            case "8":
                world = "Principal";
                break;
            case "довольно" :
            case "9":
                world = "Quite";
                break;
            default: world = "Такого_слова_нет";
                 break;
        }
        return world;
    }

}
