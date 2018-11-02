package Classes;

import java.util.Random;

public class Die {
    private int faceValue;
    private Random random;


    public Die(){
    }

    public int rollDie (){
        random = new Random();
        setFaceValue(random.nextInt(6)+1);
        return getFaceValue();
    }
    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int value) {
        this.faceValue = value;
    }
}
