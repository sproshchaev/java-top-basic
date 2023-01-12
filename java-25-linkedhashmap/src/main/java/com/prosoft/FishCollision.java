package com.prosoft;

/**
 * Класс FishCollision. Искусственно создается коллизия, хеш код для объектов класса вычисляется только на основании
 * текстового значения name, метод equals() по-прежнему считает объекты равными только в случае совпадения
 * значений всех трех полей
 */
public class FishCollision {
    private String name;
    private double weight;
    private double price;

    public FishCollision(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    /**
     * Переопределение метода equals()
     * Метод equals() считает объекты равными только в случае совпадения значений всех трех полей
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof FishCollision)) {
            return false;
        }
        FishCollision tmp = (FishCollision) o;
        return (tmp.name.equals(this.name) &&
                tmp.weight == this.weight &&
                tmp.price == (this.price));
    }

    /**
     * Переопределение метода hashCode()
     * Хеш код для объектов класса вычисляется только на основании текстового значения name
     *
     * @return
     */
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    /**
     * Переопределение метода toString()
     *
     * @return
     */
    @Override
    public String toString() {
        return "FishCollision{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
