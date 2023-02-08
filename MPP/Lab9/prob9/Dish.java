package lesson9.labsolns.prob10;
import java.util.*;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type { MEAT, FISH, OTHER }

    @Override
    public String toString() {
        return name;
    }

    public static final List<Dish> menu =
            Arrays.asList( new Dish("pork", false, 800, Dish.Type.MEAT),
                           new Dish("beef", false, 700, Dish.Type.MEAT),
                           new Dish("chicken", false, 400, Dish.Type.MEAT),
                           new Dish("french fries", true, 530, Dish.Type.OTHER),
                           new Dish("rice", true, 350, Dish.Type.OTHER),
                           new Dish("season fruit", true, 120, Dish.Type.OTHER),
                           new Dish("pizza", true, 550, Dish.Type.OTHER),
                           new Dish("prawns", false, 400, Dish.Type.FISH),
                           new Dish("salmon", false, 450, Dish.Type.FISH));

    public static void main(String[] args) {
        boolean isVegetarian = menu.stream().anyMatch(Dish::isVegetarian);
        boolean healthyMenu = Dish.menu.stream().anyMatch(dish -> dish.getCalories() < 1000);
        boolean unhealthyAvailable = Dish.menu.stream().anyMatch(dish -> dish.getCalories() > 1000);
        Optional<Dish> findFirstMeatDish = menu.stream().filter(dish -> dish.getType() == Type.MEAT).findFirst();
        int calTotalCalories = menu.stream().mapToInt(Dish::getCalories).sum();
        int calTotalCaloriesMethodReference = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
    }

}