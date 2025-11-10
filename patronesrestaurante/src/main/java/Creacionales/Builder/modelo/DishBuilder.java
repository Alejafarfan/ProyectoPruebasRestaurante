package Creacionales.Builder.modelo;

public abstract class DishBuilder {
    protected Dish dish;

    public void createNewDish() {
        dish = new Dish();
    }

    public Dish getDish() {
        return dish;
    }

    public abstract void buildName();
    public abstract void buildMainIngredient();
    public abstract void buildSideIngredients();
    public abstract void buildDrink();
    public abstract void buildPrice();
}
