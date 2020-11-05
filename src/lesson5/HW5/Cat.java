package lesson5.HW5;

public class Cat extends Animal {


    public Cat(String nameAnimal,int runDistance, int swimDistance, float jumpHeight) {
        super(nameAnimal,runDistance,swimDistance,jumpHeight);
    }
    @Override
    void running() {

        System.out.println(nameAnimal +" пробежал " + runDistance + "м.");
    }
    @Override
    void swimming() {

        System.out.println(nameAnimal+" прыгнул на " + jumpHeight + "м.");
    }
    @Override
    void jumping() {

        System.out.println(nameAnimal+" не самоубийца!Он не плавает!");
    }

}
