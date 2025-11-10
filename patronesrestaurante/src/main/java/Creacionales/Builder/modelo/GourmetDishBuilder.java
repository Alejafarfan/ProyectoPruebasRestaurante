package Creacionales.Builder.modelo;

public class GourmetDishBuilder extends DishBuilder {

    @Override
    public void buildName() {
        dish.setName("Menú Gourmet");
    }

    @Override
    public void buildMainIngredient() {
        dish.setMainIngredient("Filete mignon con salsa de vino tinto");
    }

    @Override
    public void buildSideIngredients() {
        dish.addSideIngredient("Puré de papa trufado");
        dish.addSideIngredient("Espárragos al vapor");
    }

    @Override
    public void buildDrink() {
        dish.setDrink("Copa de vino tinto");
    }

    @Override
    public void buildPrice() {
        dish.setPrice(32000);
    }
}
