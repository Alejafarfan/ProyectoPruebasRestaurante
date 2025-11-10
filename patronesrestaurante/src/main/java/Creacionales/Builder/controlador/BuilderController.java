package Creacionales.Builder.controlador;

import Creacionales.Builder.modelo.*;

public class BuilderController {
    private final ChefDirector chefDirector;

    public BuilderController() {
        this.chefDirector = new ChefDirector();
    }

    public Dish buildDish(String type) {
        DishBuilder builder;
        switch (type.toLowerCase()) {
            case "vegetariano" -> builder = new VegetarianDishBuilder();
            case "gourmet" -> builder = new GourmetDishBuilder();
            default -> builder = new DailyMenuBuilder();
        }
        chefDirector.setBuilder(builder);
        return chefDirector.constructDish();
    }
}
