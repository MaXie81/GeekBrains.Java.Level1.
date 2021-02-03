package child;

import parent.Animal;

public class Cat extends Animal {               // Класс "Кошка"
    public Cat(String name) {
        super(
            "Кошка",
             name,
            200,
            0,
            2.0f
        );
    }
    @Override
    public void doSwim(int dist) {
        System.out.println(getClassName() + " не может плавать!");
    }
}
