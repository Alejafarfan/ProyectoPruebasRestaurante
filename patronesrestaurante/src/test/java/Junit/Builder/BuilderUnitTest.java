package Junit.Builder;

import Creacionales.Builder.modelo.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BuilderUnitTest {

    @Test
    void vegetarianDishShouldBeBuiltCorrectly() {
        ChefDirector chef = new ChefDirector();
        chef.setBuilder(new VegetarianDishBuilder());
        Dish dish = chef.constructDish();

        assertEquals("Menú Vegetariano", dish.getName());
        assertTrue(dish.getSideIngredients().contains("Arroz integral"));
    }
}

