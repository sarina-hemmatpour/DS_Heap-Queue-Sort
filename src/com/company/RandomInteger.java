package com.company;
import java.util.ArrayList;
import java.util.Random;

public class RandomInteger {

    private ArrayList<Integer> randomIntegerNumbers;

    public ArrayList<Integer> getRandomIntegerNumbers() {
        return randomIntegerNumbers;
    }

    public void setRandomIntegerNumbers(ArrayList<Integer> randomIntegerNumbers) {
        this.randomIntegerNumbers = randomIntegerNumbers;
    }

    public RandomInteger() {
        this.randomIntegerNumbers = new ArrayList<>();
    }

    public void generateRandomInteger()
    {
        for (int i=0 ; i<1000000 ; i++)
        {
            Random random=new Random();
            int upperBound=Integer.MAX_VALUE;
            randomIntegerNumbers.add(random.nextInt(1000000));
        }
    }
}
