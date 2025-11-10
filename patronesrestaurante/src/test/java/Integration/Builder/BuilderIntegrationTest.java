package Integration.Builder;

import Creacionales.Builder.controlador.BuilderController;
import Creacionales.Builder.modelo.Dish;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BuilderIntegrationTest {

    @Test
    void controllerShouldBuildDishByType() {
        BuilderController controller = new BuilderController();
        Dish dish = controller.buildDish("gourmet");
        assertEquals("Menú Gourmet", dish.getName());
        assertTrue(dish.getPrice() > 0);
    }
}

