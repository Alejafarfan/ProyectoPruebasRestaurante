package Creacionales.Builder.modelo;

public class DailyMenuBuilder extends DishBuilder {

    @Override
    public void buildName() {
        dish.setName("Menú del Día");
    }

    @Override
    public void buildMainIngredient() {
        dish.setMainIngredient("Pechuga de pollo a la plancha");
    }

    @Override
    public void buildSideIngredients() {
        dish.addSideIngredient("Arroz blanco");
        dish.addSideIngredient("Lentejas");
        dish.addSideIngredient("Ensalada de tomate");
    }

    @Override
    public void buildDrink() {
        dish.setDrink("Jugo de mora");
    }

    @Override
    public void buildPrice() {
        dish.setPrice(15000);
    }
}
