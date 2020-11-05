package lesson5.HW5;

public class Bird extends Animal {

    protected String dancingInWater;


    public Bird(String nameAnimal,int runDistance, int swimDistance, float jumpHeight) {
        super(nameAnimal,runDistance,swimDistance,jumpHeight);
        dancingInWater = " Обычная птица не пляшет в воде,увы!";
    }


    public Bird(String nameAnimal, int runDistance, int swimDistance, float jumpHeight, String dancingInWater){
        super(nameAnimal,runDistance,swimDistance,jumpHeight);
        this.dancingInWater = dancingInWater;

    }

    void swimAndDance(){
        System.out.println(nameAnimal + dancingInWater + swimDistance +"м");
    }


}
