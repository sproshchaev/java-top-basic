package com.prosoft;

import java.io.*;

/**
 * java-45-serializable
 */
public class Main {
    public static void main(String[] args) {

        Fish fish = new Fish("salmon", 2.5, 180);
        serialize(fish, "fish.txt");
        Fish deserializeFish = (Fish) deserialize("fish.txt");
        System.out.println(deserializeFish);
    }

    /**
     * Метод serialize() выполняет сериализацию, получает в качестве параметра объект для сериализации и имя файла,
     * в который надо записать сериализованный объект.
     * Примечание: Создается символьный поток для вывода в файл. Вокруг этого потока создается поток ObjectOutputStream.
     * Затем выполняется запись в поток переданного объекта. Метод универсальный и будет работать с объектами любого типа.
     * Запись выполняется методом writeObject().
     *
     * @param object
     * @param fileName
     */
    public static void serialize(Object object, String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(object);
        } catch (FileNotFoundException ex) {
            System.err.println("File not found:");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Input/Output error:");
            ex.printStackTrace();
        }
    }

    /**
     * Метод deserialize() выполняет десериализацию - получает имя файла, содержащего сериализованный объект,
     * и возвращает десериализованный объект из этого файла.
     * <p>
     * Примечание: Создает символьный поток для чтения файла, оборачивает этот поток потоком ObjectInputStream,
     * и выполняет чтение методом readObject().
     *
     * @param fileName
     * @return
     */
    public static Object deserialize(String fileName) {
        Object object = null;
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            object = objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.err.println("File not found:");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Input/Output error:");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.err.println("Class not found:");
            ex.printStackTrace();
        }
        return object;
    }

}
