package child;

import parent.Animal;

public class Horse extends Animal {             // Класс "Лошадь"
    public Horse(String name) {
        super(
            "Лошадь",
             name,
            1500,
            100,
            3.0f
        );
    }
    @Override
    public void doSwim(int dist) {
        super.doSwim(dist);
    }
}
