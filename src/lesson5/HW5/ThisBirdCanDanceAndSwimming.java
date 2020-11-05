package lesson5.HW5;

public class ThisBirdCanDanceAndSwimming extends Bird {

    public ThisBirdCanDanceAndSwimming(String nameAnimal, int runDistance, int swimDistance, float jumpHeight, String dancingInWater) {
        super(nameAnimal, runDistance, swimDistance, jumpHeight, dancingInWater);
    }
    @Override
    void swimAndDance(){
        swimDistance = 100500;
        System.out.println(nameAnimal + dancingInWater + swimDistance +" м.");
    }



}

