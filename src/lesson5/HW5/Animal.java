package lesson5.HW5;

public class Animal {

    protected String nameAnimal;
    protected int runDistance;
    protected int swimDistance;
    protected float jumpHeight;

    public Animal(String nameAnimal,int runDistance, int swimDistance, float jumpHeight) {
        this.nameAnimal = nameAnimal;
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
        this.jumpHeight = jumpHeight;
    }


    void running() {
        System.out.println(nameAnimal + " пробежала " + runDistance +"м" );
    }

    void swimming() {
        System.out.println(nameAnimal + " проплыла " + swimDistance +"м" );
    }

    void jumping() {
        System.out.println(nameAnimal + " прыгнула на  " + jumpHeight +"м");
    }

}

