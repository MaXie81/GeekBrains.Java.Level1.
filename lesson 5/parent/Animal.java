package parent;

abstract public class Animal {
    // поля-переменные
    final private String nameAnimalClass;
    final private String nameAnimal;

    final private int   limRun;
    final private int   limSwim;
    final private float limJump;

    // Конструктор
    protected Animal(
            String  nameAnimalClass,
            String  nameAnimal,
            int     limRun,
            int     limSwim,
            float   limJump
    ) {
        Variation.setPctMax(25);

        this.nameAnimalClass    = nameAnimalClass;
        this.nameAnimal         = nameAnimal;
        this.limRun             = Variation.getVal(limRun);
        this.limSwim            = Variation.getVal(limSwim);
        this.limJump            = Variation.getVal(limJump);
    }
    // Основные поля-методы
    public void doRun(int dist) {
        if (dist <= limRun)
            System.out.println(getName() + " пробежала расстояние " + dist + " м.");
        else
            System.out.println(getName() + " не смогла пробежать расстояние " + dist + " м. Максимально возможное расстояние: " + limRun + " м.");
    }
    public void doJump(float height) {
        if (height <= limJump)
            System.out.println(getName() + " перепрыгнула препятствие высотой " + height + " метров.");
        else
            System.out.println(getName() + " не смогла перепрыгнуть препятствие высотой " + height + " м. Максимально возможная высота: " + limJump + " м.");
    }
    protected void doSwim(int dist) {                       // подлежит переопределению в Классах-потомках
        if (dist <= limSwim)
            System.out.println(getName() + " проплыла расстояние " + dist + " м.");
        else
            System.out.println(getName() + " не смогла пробежать расстояние " + dist + " м. Максимально возможное расстояние: " + limSwim + " м.");
    }
    // Вспомогательные методы
    private String getName() {
        return nameAnimalClass + " по кличке " + '\"' + nameAnimal + '\"';
    }
    protected String getClassName() {
        return nameAnimalClass;
    }
    public void getInfo() {
        System.out.println("________________________________________");
        System.out.println("Данные");
        System.out.println("класс: "    + "\t\t"    + nameAnimalClass);
        System.out.println("кличка: "   + "\t"      + nameAnimal + "\n");
        System.out.println("Лимиты");
        System.out.println("бег: "      + "\t\t"    + limRun);
        System.out.println("плавание: " + "\t"      + limSwim);
        System.out.println("прыжки: "   + "\t"      + limJump + "\n");
    }
}
