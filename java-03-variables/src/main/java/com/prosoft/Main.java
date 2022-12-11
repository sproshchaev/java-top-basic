package com.prosoft;

/**
 * java-03-variables
 */
public class Main {

    /**
     * Объявление констант класса
     */
    private static final int COUNT = 100; // <- инициализация константы в месте объявления (только для статических констант)
    private final int COUNT2; // <- объявление константы с последующим объявлением в конструкторе класса (только для не статических констант)

    /**
     * Объявление констант через литералы
     */
    private static final int INT_COUNT3_1 = 3;
    private static final int INT_COUNT3_2 = 03;
    private static final int INT_COUNT3_3 = 0x3;

    private static final long LONG_COUNT4_1 = 30000l;
    private static final long LONG_COUNT4_2 = 30000L;
    private static final long LONG_COUNT4_3 = 30_000L;

    private static final float FLOAT_COUNT_1 = 3.5f;
    private static final float FLOAT_COUNT_2 = 3.5F;

    private static final double DOUBLE_COUNT_1 = 3.5;
    private static final double DOUBLE_COUNT_2 = 3.5d;
    private static final double DOUBLE_COUNT_3 = 3.5D;

    private static final boolean BOOLEAN_1 = true;
    private static final boolean BOOLEAN_2 = false;

    /**
     * Объявление полей класса
     */
    private static int myCount; // <- поле класса (по умолчанию 0), т.к. поля класса могут быть не инициализированы

    /**
     * Конструктор класса вызывается всегда, когда создается экзкмпляр класса
     */
    public Main() {

        COUNT2 = 200; // <- инициализация константы в конструкторе (только для не статических констант)

    }

    public static void main(String[] args) {

        /**
         * Слайд 23 Переменные
         */
        int count;
        count = 0;
        boolean wasFound;
        wasFound = true;
        byte i;
        i = 1;
        System.out.println("Variables: int count=" + count + ", boolean wasFound=" + wasFound + "byte i=" + i);

        /**
         * Нельзя использовать зарезервированные в Java слова при объявлении переменных
         */
        // int case = 1; не скомпилируется!

        /**
         * Слайд 25-26. Область видимости переменных. Локальная переменная и поле класса
         */
        int myCount = 5;
        someMethod(myCount); // передача переменной в качестве аргумента методу someMethod()

        System.out.println("Значение статического поля класса (по умолчанию) Main.myCount=" + Main.myCount); // поле класса
        Main.myCount = 7;    // новое значание для статического поля класса
        System.out.println("Новое значение статического поля класса Main.myCount=" + Main.myCount);

        /**
         * Слайд 27. Константы
         */
        System.out.println("Константа COUNT=" + COUNT); // <- из статического метода мы може обратиться только к статическим константам
        // System.out.println("Константа COUNT=" + COUNT2); // <- не скомпилируется! Для нестатических констант нужен экзкмпляр класса, здесь его вызвать нельзя
        Main main = new Main();
        main.useFinal(); // <- обращение к константе в методе useFinal() экземпляра класса класса Main

        /**
         * Слайд 28. Литералы
         */
        long localCount = 1L;
        System.out.println("Присвоенные значаения через литералы: localCount=" + localCount);
        System.out.println("INT_COUNT3_1=" + INT_COUNT3_1 + ", INT_COUNT3_2=" + INT_COUNT3_2 + ", INT_COUNT3_3=" + INT_COUNT3_3);
        System.out.println("LONG_COUNT4_1=" + LONG_COUNT4_1 + ", LONG_COUNT4_2=" + LONG_COUNT4_2 + ", LONG_COUNT4_3=" + LONG_COUNT4_3);
        System.out.println("FLOAT_COUNT_1=" + FLOAT_COUNT_1 + ", FLOAT_COUNT_2=" + FLOAT_COUNT_2);
        System.out.println("DOUBLE_COUNT_1=" + DOUBLE_COUNT_1 + ", DOUBLE_COUNT_2=" + DOUBLE_COUNT_2 + ", DOUBLE_COUNT_3=" + DOUBLE_COUNT_3);
        System.out.println("BOOLEAN_1=" + BOOLEAN_1 + ", BOOLEAN_2=" + BOOLEAN_2);

    }

    /**
     * В метод someMethod передается значение переменной myCount из метода main
     *
     * @param count
     */
    public static void someMethod(int count) { // <- начало блока

        int myCount = 6; // это уже другая переменная myCount, объявленная внутри блока метода
        System.out.println("count = " + count + ", myCount=" + myCount);

        System.out.println("Значение статического поля класса доступно в любом месте Main.myCount=" + Main.myCount);

    } // <- конец блока

    /**
     * Обращение к константе в методе useFinal() экземпляра класса класса Main
     * Константа COUNT2 была определена в классе Main и инициализирована в конструкторе класса
     */
    public void useFinal() {

        System.out.println("Константа COUNT2=" + COUNT2);

    }

}
