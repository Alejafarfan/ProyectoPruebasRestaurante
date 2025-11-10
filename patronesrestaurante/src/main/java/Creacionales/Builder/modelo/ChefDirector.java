package Creacionales.Builder.modelo;

public class ChefDirector {
    private DishBuilder builder;

    public void setBuilder(DishBuilder builder) {
        this.builder = builder;
    }

    public Dish constructDish() {
        builder.createNewDish();
        builder.buildName();
        builder.buildMainIngredient();
        builder.buildSideIngredients();
        builder.buildDrink();
        builder.buildPrice();
        return builder.getDish();
    }
}

