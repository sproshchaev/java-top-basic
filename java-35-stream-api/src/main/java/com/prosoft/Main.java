package com.prosoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * java-35-stream-api
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("\nStream-api example\n");

        /**
         * Создание стрима: из коллекции
         */
        Collection<String> stringCollection = Arrays.asList("a1", "a2", "a3");
        Stream<String> collectionStream = stringCollection.stream();

        /**
         * Создание стрима: из коллекции (сокращенный вариант)
         */
        Stream<String> collectionStream2 = Arrays.asList("a1", "a2", "a3").stream();

        /**
         * Создание стрима: из значений
         */
        Stream<String> valuesStream = Stream.of("a1", "a2", "a3");

        /**
         * Создание стрима: из примитивов
         */
        IntStream intStream = IntStream.of(1, 2, 3);
        DoubleStream doubleStream = DoubleStream.of(1.1, 2.2, 3.3);

        /**
         * Создание стрима: из массива
         */
        String[] arrayString = {"a1", "a2", "a3"};
        Stream<String> arrayStream = Arrays.stream(arrayString);

        /**
         * Создание стрима: инструмент Stream.builder()
         */
        Stream<Object> objectStream = Stream.builder().add("a1").add("a2").add("a3").build();

        /**
         * Промежуточные (конвейерные) операции: filter() - отработает как фильтр, вернет значения, которые подходят под
         * заданное условие
         */
        Collection<String> stringCollection2 = Arrays.asList("a1", "a2", "a3", "a1");
        System.out.print("Use filter('a1'): " + stringCollection2 + " -> ");
        stringCollection2.stream()
                .filter("a1"::equals)
                .forEach(c -> {
                    System.out.print(c + ", ");
                });
        System.out.println("");

        /**
         * Промежуточные (конвейерные) операции: sorted() - сортирует элементы в естественном порядке
         * (можно использовать Comparator)
         */
        Collection<String> stringCollection3 = Arrays.asList("a4", "a2", "a1", "a5");
        System.out.print("Use sorted(): " + stringCollection3 + " -> ");
        stringCollection3.stream()
                .sorted()
                .forEach(c -> {
                    System.out.print(c + ", ");
                });
        System.out.println("");

        /**
         * Промежуточные (конвейерные) операции: limit() - лимитирует вывод по тому, количеству, которое будет указано
         */
        Collection<String> stringCollection4 = Arrays.asList("a4", "a2", "a1", "a5");
        System.out.print("Use limit(2): " + stringCollection4 + " -> ");
        stringCollection4.stream()
                .limit(2)
                .forEach(c -> {
                    System.out.print(c + ", ");
                });
        System.out.println("");

        /**
         * Промежуточные (конвейерные) операции: skip() - пропустит указанное количество элементов с начала коллекции
         */
        Collection<String> stringCollection5 = Arrays.asList("a1", "a2", "a3", "a4");
        System.out.print("Use skip(2): " + stringCollection5 + " -> ");
        stringCollection5.stream()
                .skip(2)
                .forEach(c -> {
                    System.out.print(c + ", ");
                });
        System.out.println("");

        /**
         * Промежуточные (конвейерные) операции: distinct() - удаление повторяющиеся элементы
         */
        Collection<String> stringCollection6 = Arrays.asList("a1", "a2", "a1", "a3");
        System.out.print("Use distinct(): " + stringCollection6 + " -> ");
        stringCollection6.stream()
                .distinct()
                .forEach(c -> {
                    System.out.print(c + ", ");
                });
        System.out.println("");

        /**
         * Промежуточные (конвейерные) операции: peek() - выполнение действий над каждым элементом, вернет стрим
         * с исходными элементами
         * peek() лучше использовать для обработки элементов в промежуточных операциях
         * На выходе peek() будет возвращать то, что получил на вход!
         * Метод peek() не требует ключевого слова return
         *
         * Пример: Use peek(): [a1, a2, a3, a4] -> A1, a1, A2, a2, A3, a3, A4, a4
         */
        Collection<String> stringCollection7 = Arrays.asList("a1", "a2", "a3", "a4");
        System.out.print("Use peek(): " + stringCollection7 + " -> ");
        stringCollection7.stream()
                .peek(c -> {
                    System.out.print(c.toUpperCase() + ", ");
                })
                .forEach(c -> {
                    System.out.print(c + ", ");
                });
        System.out.println("");

        /**
         * Промежуточные (конвейерные) операции: map() - выполнит действия над каждым элементом и вернет результат
         * Метод map() требует ключевое слово return, если операторы заключены в {}
         */
        Collection<String> stringCollection8 = Arrays.asList("a1", "a2", "a3", "a4");
        System.out.print("Use map(): " + stringCollection8 + " -> ");
        stringCollection8.stream()
                .map(c -> {
                    c = c.toUpperCase() + "!";
                    return c;
                })
                .forEach(c -> {
                    System.out.print(c + ", ");
                });
        System.out.println("");

        /**
         * Промежуточные (конвейерные) операции: mapToInt, mapToDouble, mapToLong - вернет числовой стрим
         */
        Collection<String> stringCollection9 = Arrays.asList("1", "2", "3", "4");
        System.out.print("Use mapToInt(): " + stringCollection9 + " -> ");
        stringCollection9.stream()
                .mapToInt((s) -> Integer.parseInt(s))
                .forEach(c -> {
                    System.out.print(c + ", ");
                });
        System.out.println("");

        /**
         * Терминальные операции: findFirst() - вернет элемент (тип Optional) который стоит первым
         */
        Collection<String> stringCollection10 = Arrays.asList("1", "2", "3", "4");
        System.out.print("Use findFirst(): " + stringCollection10 + " -> ");
        System.out.println(stringCollection10
                .stream()
                .findFirst()
        );

        /**
         * Терминальные операции: findAny() - вернет любой элемент, соответствующий условию
         */
        Collection<String> stringCollection11 = Arrays.asList("1", "2", "3", "2");
        System.out.print("Use findAny(): " + stringCollection11 + " -> ");
        System.out.println(stringCollection11
                .stream()
                .filter("2"::equals)
                .findAny());

        /**
         * Терминальные операции: collect() - соберет результаты обработки в коллекции
         */
        Collection<String> stringCollection12 = Arrays.asList("01", "02", "3", "4");
        System.out.print("Use collect() и Collectors.toList(): " + stringCollection12 + " -> ");
        System.out.println(
                stringCollection12.stream()
                        .filter((s) -> s.contains("0"))
                        .collect(Collectors.toList())
        );

        /**
         * Терминальные операции: collect() - соберет результаты обработки в коллекции
         * Использование статического метода Collectors.joining()
         */
        System.out.print("Use collect() и Collectors.joining(): " + stringCollection12 + " -> ");
        System.out.println(
                stringCollection12.stream()
                        .filter((s) -> s.contains("0"))
                        .collect(Collectors.joining(", "))
        );


        /**
         * Терминальные операции: count - посчитает и выведет, сколько элементов, соответствующих условию
         */
        Collection<String> stringCollection13 = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8");
        System.out.print("Use count(): " + stringCollection13 + " -> ");
        System.out.println(stringCollection13.stream()
                .count()
        );

        /**
         * Терминальные операции: anyMatch() - вернет true, когда хоть один элемент соответствует условию
         */
        Collection<String> stringCollection14 = Arrays.asList("1", "2", "3", "4", "5");
        System.out.print("Use anyMatch('5'): " + stringCollection14 + " -> ");
        System.out.println(stringCollection14.stream()
                .filter((e) -> Integer.parseInt(e) > 3)
                .anyMatch("5"::contains)
        );

        /**
         * Терминальные операции: noneMatch() - вернет true, когда ни один элемент не соответствует условиям
         */
        Collection<String> stringCollection15 = Arrays.asList("1", "2", "3", "4", "5");
        System.out.print("Use filter(>3), noneMatch('6'): " + stringCollection15 + " -> ");
        System.out.println(stringCollection14.stream()
                .filter((e) -> Integer.parseInt(e) > 3)
                .noneMatch("6"::contains)
        );

        /**
         * Терминальные операции: allMatch() - вернет true, когда все элементы соответствуют условиям
         */
        Collection<String> stringCollection16 = Arrays.asList("01", "02", "03", "04", "05");
        System.out.print("Use allMatch(contains('0')): " + stringCollection16 + " -> ");
        System.out.println(stringCollection16.stream()
                .allMatch((s) -> s.contains("0"))
        );

        /**
         * Терминальные операции: min(), max() - возвращает минимальный и максимальный элемент, используя условие
         */
        Collection<String> stringCollection17 = Arrays.asList("01", "02", "03", "04", "05");
        System.out.print("Use min()): " + stringCollection17 + " -> ");
        System.out.println(stringCollection16.stream()
                .min(String::compareTo).get()
        );

        System.out.print("Use max()): " + stringCollection17 + " -> ");
        System.out.println(stringCollection16.stream()
                .max(String::compareTo).get()
        );

        /**
         * Терминальные операции: forEach() - применит функцию ко всем элементам, но не гарантирует порядок
         */
        Collection<String> stringCollection18 = Arrays.asList("1", "2", "3", "4", "5");
        System.out.print("Use forEach()): " + stringCollection18 + " -> ");
        stringCollection18.stream()
                .forEach(c -> System.out.print(c + ", "));
        System.out.println("");

        /**
         * Терминальные операции: forEachOrdered() - применит функцию ко всем элементам по очереди, порядок выполнения
         * гарантирован
         */
        Collection<String> stringCollection19 = Arrays.asList("1", "2", "3", "4", "5");
        System.out.print("Use forEachOrdered()): " + stringCollection19 + " -> ");
        stringCollection19.stream()
                .forEachOrdered(c -> System.out.print(c + ", "));
        System.out.println("");

        /**
         * Терминальные операции: toArray() - приведет значения стрима к массиву
         */
        Collection<String> stringCollection20 = Arrays.asList("1", "2", "3", "4", "5");
        System.out.print("Use toArray()): " + stringCollection20 + " -> ");
        String[] arrayString2 = stringCollection20.stream()
                .map(String::toLowerCase).toArray(String[]::new);
        for (int i = 0; i < arrayString2.length; i++) {
            System.out.print(arrayString2[i] + ", ");
        }
        System.out.print("(size=" + arrayString2.length + ")");
        System.out.println("");

        /**
         * Терминальные операции: reduce() - преобразует все элементы в один объект
         */
        Collection<String> stringCollection21 = Arrays.asList("1", "2", "3", "4", "5");
        System.out.print("Use reduce()): " + stringCollection21 + " -> ");
        System.out.println(stringCollection21.stream()
                .reduce((x, y) -> x + " " + y)
        );

        /**
         * Терминальные операции: sum() - суммирует элементы стрима
         */
        Collection<Integer> stringCollection22 = Arrays.asList(1, 2, 3, 4, 5);
        System.out.print("Use sum()): " + stringCollection22 + " -> ");
        System.out.println(stringCollection22.stream()
                .mapToInt(Integer::intValue)
                .sum());

        /**
         * (1) Создание массива класса ArrayList()
         */
        List<Car> carList = new ArrayList<>();

        /**
         * (2) Заполнение массива через использование анонимного класса. Метод add().
         */
        carList.add(new Car("BMW", "black", 1000));
        carList.add(new Car("Audi", "green", 1500));
        carList.add(new Car("Toyota", "blue", 5500));
        carList.add(new Car("Fiat", "red", 500));
        System.out.println("\n");

        /**
         * (3) Вывести из коллекции все машины с ценами. Терминальный метод forEach().
         */
        System.out.print("Before: ");
        carList.forEach(car -> {
            System.out.print(car.getBrand() + " =" + car.getPrice() + ", ");
        });
        System.out.println("");

        /**
         * (4) Уменьшим на 10% цену всех машин, которые дороже 1000. Методы: промежуточный filter(), терминальный forEach().
         * Сначала вызываем метод stream(), который создает потоковое представление коллекции.
         * Затем для этого потока цепочкой вызываем методы filter() и forEach(), оба принимающие лямбда-выражения
         * в качестве параметров. Первый метод выбирает из коллекции элементы по заданному критерию, а второй —
         * применяет к отобранным элементам требуемую обработку (уменьшает цену на 10%)
         */
        carList.stream()
                .filter(car -> car.getPrice() > 1000)
                .forEach(car -> car.setPrice((int) (car.getPrice() * 0.9)));

        /**
         * (5) Вывод элементов коллекции. Терминальный метод forEach().
         */
        System.out.print("After: ");
        carList.forEach(car -> {
            System.out.print(car.getBrand() + " =" + car.getPrice() + ", ");
        });
        System.out.println("");

        /**
         * (6) Выбор из коллекции в отдельную коллекцию все элементы с ценой больше 1000. Методы: промежуточный filter(),
         * терминальный collect()
         * Статический метод Collectors.toList() преобразует элементы стрима в элементы коллекции List()
         */
        List<Car> carList2 = carList.stream()
                .filter(car -> car.getPrice() > 1000)
                .collect(Collectors.toList());

        /**
         * (7) Вывод элементов коллекции. Терминальный метод forEach().
         */
        System.out.print("Price > 1000: ");
        carList2.forEach(car -> {
            System.out.print(car.getBrand() + " =" + car.getPrice() + ", ");
        });
        System.out.println("");

        /**
         * (8) Вычислить суммарную стоимости всех машин в коллекции, используя оператор :: (method Reference ссылка на метод)
         * Промежуточный метод mapToDouble(), терминальный метод sum().
         */
        System.out.print("Price of all cars: ");
        System.out.println(
                carList.stream()
                        .mapToDouble(Car::getPrice)
                        .sum()
        );


    }
}
