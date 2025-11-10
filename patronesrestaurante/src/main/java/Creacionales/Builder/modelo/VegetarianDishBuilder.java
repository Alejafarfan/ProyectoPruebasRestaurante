package Creacionales.Builder.modelo;

public class VegetarianDishBuilder extends DishBuilder {

    @Override
    public void buildName() {
        dish.setName("Menú Vegetariano");
    }

    @Override
    public void buildMainIngredient() {
        dish.setMainIngredient("Tofu con verduras salteadas");
    }

    @Override
    public void buildSideIngredients() {
        dish.addSideIngredient("Arroz integral");
        dish.addSideIngredient("Ensalada fresca");
    }

    @Override
    public void buildDrink() {
        dish.setDrink("Jugo natural de naranja");
    }

    @Override
    public void buildPrice() {
        dish.setPrice(18000);
    }
}
