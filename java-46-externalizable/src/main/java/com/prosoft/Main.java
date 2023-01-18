package com.prosoft;

import java.io.*;

/**
 * java-46-externalizable
 */
public class Main {
    public static void main(String[] args) {
        Fish fish = new Fish("salmon", 2.5, 180);
        serialize(fish, "fishex.txt");
        Fish deserializeFish = (Fish) deserialize("fishex.txt");
        System.out.println(deserializeFish);
    }

    /**
     * Метод serialize() выполняет сериализацию
     * У сериализуемого объекта вызывается метод writeExternal(), который был переопределен в интерфейсе Externalizable
     * в классе Fish
     *
     * @param fish
     * @param fileName
     */
    public static void serialize(Fish fish, String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            fish.writeExternal(objectOutputStream);
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
     * При десериализации у экземпляра класса вызывается метод readExternal(), который был переопределен в интерфейсе
     * Externalizable в классе Fish.
     *
     * @param fileName
     * @return
     */
    public static Object deserialize(String fileName) {
        Fish fish = new Fish();
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            fish.readExternal(objectInputStream);
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
        return fish;
    }
}
