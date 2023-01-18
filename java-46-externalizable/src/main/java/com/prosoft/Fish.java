package com.prosoft;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;

/**
 * (1) Класс Fish реализует интерфейс Externalizable
 * <p>
 * Примечание: В каждом классе, который реализует интерфейс Externalizable, должен быть конструктор без параметров,
 * такой конструктор должен быть у всех потомков этого класса.
 */
public class Fish implements Externalizable {
    private String name;
    private double weight;
    private double price;

    /**
     * Конструктор без параметров должен быть в любом классе, реализующем интерфейс Externalizable
     */
    public Fish() {
        this.name = "noname";
        this.weight = 0;
        this.price = 0;
    }

    public Fish(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    /**
     * The object implements the writeExternal method to save its contents
     * by calling the methods of DataOutput for its primitive values or
     * calling the writeObject method of ObjectOutput for objects, strings,
     * and arrays.
     *
     * @param out the stream to write the object to
     * @throws IOException Includes any I/O exceptions that may occur
     * @serialData Overriding methods should use this tag to describe
     * the data layout of this Externalizable object.
     * List the sequence of element types and, if possible,
     * relate the element to a public/protected field and/or
     * method of this Externalizable class.
     */
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
        out.writeDouble(this.price);
        out.writeDouble(this.weight);
    }

    /**
     * The object implements the readExternal method to restore its
     * contents by calling the methods of DataInput for primitive
     * types and readObject for objects, strings and arrays.  The
     * readExternal method must read the values in the same sequence
     * and with the same types as were written by writeExternal.
     *
     * @param in the stream to read data from in order to restore the object
     * @throws IOException            if I/O errors occur
     * @throws ClassNotFoundException If the class for an object being
     *                                restored cannot be found.
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
        this.price = in.readDouble();
        this.weight = in.readDouble();
    }

    /**
     * (1.1) Переопределение метода equals()
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fish fish = (Fish) o;
        return Double.compare(fish.weight, weight) == 0 && Double.compare(fish.price, price) == 0
                && Objects.equals(name, fish.name);
    }

    /**
     * (1.2) Переопределение метода hashCode()
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, weight, price);
    }

    /**
     * (1.3) Переопределение метода toString()
     *
     * @return
     */
    @Override
    public String toString() {
        return "Fish{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }


}
