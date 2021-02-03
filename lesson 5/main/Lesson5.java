package main;

import child.Bird;
import child.Cat;
import child.Dog;
import child.Horse;

import java.util.Random;

public class Lesson5 {
    private static int i;
    private static Random rand = new Random();
    
    public static void main(String[] args) {
        Cat[] cats      = {new Cat("Васька"), new Cat("Мурка"), new Cat("Барсик")};
        Dog[] dogs      = {new Dog("Палкан"), new Dog("Лайка"), new Dog("Хмурый")};
        Horse[] horses  = {new Horse("Блонди"), new Horse("Спартак"), new Horse("Ночька")};
        Bird[] birds    = {new Bird("Петруха"), new Bird("Каркуша"), new Bird("Галка")};

        i = rand.nextInt(3);
        cats[i].getInfo();
        cats[i].doRun(200);
        cats[i].doSwim(3);
        cats[i].doJump(1.95f);

        i = rand.nextInt(3);
        dogs[i].getInfo();
        dogs[i].doRun(500);
        dogs[i].doSwim(10);
        dogs[i].doJump(0.51f);

        i = rand.nextInt(3);
        birds[i].getInfo();
        birds[i].doRun(5);
        birds[i].doSwim(1);
        birds[i].doJump(0.19f);

        i = rand.nextInt(3);
        horses[i].getInfo();
        horses[i].doRun(1600);
        horses[i].doSwim(97);
        horses[i].doJump(3.2f);
    }
}
