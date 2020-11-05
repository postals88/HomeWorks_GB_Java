package lesson5.HW5;

public class Main {


    public static void main(String[] args) {
        Bird bird = new Bird("Птица", 5, 0, 0.2f);
        Horse horse = new Horse("Лошадь", 1500, 100, 3f);
        Cat cat = new Cat("Кот", 200, 0, 2f);
        Dog dog = new Dog("Собака", 500, 500, 0.5f);
        ThisBirdCanDanceAndSwimming thisBirdCanDanceAndSwimming = new ThisBirdCanDanceAndSwimming(
                "Танцущая в воде птица", 5,
                0, 0.2f,
                " чертовски круто станцевала на глубине " );
        bird.running();
        bird.swimming();
        bird.jumping();

        skippingAline();

        horse.running();
        horse.swimming();
        horse.jumping();

        skippingAline();

        cat.running();
        cat.swimming();
        cat.jumping();

        skippingAline();

        dog.running();
        dog.swimming();
        dog.jumping();

        skippingAline();

        thisBirdCanDanceAndSwimming.swimAndDance();

    }

    static void skippingAline() {
        System.out.print("\n");
    }

}

// 1) Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.(ГОТОВО)

// 2) Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
// В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).(ГОТОВО)

// 3) У каждого животного есть ограничения на действия
// (бег: кот 200 м., собака 500 м., Лошадь 1500 м., Птица 5 м.;(ГОТОВО)

// прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м.,Птица 0.2 м. ;(ГОТОВО)
//
// плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.).(ГОТОВО)

// 4) При попытке животного выполнить одно из этих действий, оно должно сообщить результат.
// (Например, dog1.run(150); -> результат: 'Пёсик пробежал!')(ГОТОВО)

// 5)* Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.(ГОТОВО,НО С ТАНЦУЮЩЕЙ ПТИЦЕЙ)