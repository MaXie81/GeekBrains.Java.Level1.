package child;

import parent.Animal;

public class Dog extends Animal {               // Класс "Собака"
    public Dog(String name) {
        super(
            "Собака",
             name,
            500,
            10,
            0.5f
        );
    }
    @Override
    public void doSwim(int dist) {
        super.doSwim(dist);
    }
}
