package child;

import parent.Animal;

public class Bird extends Animal {              // Класс "Птица"
    public Bird(String name) {
        super(
            "Птица",
             name,
            5,
            0,
            0.2f
        );
    }
    @Override
    public void doSwim(int dist) {
        System.out.println(getClassName() + " не может плавать!");
    }
}
