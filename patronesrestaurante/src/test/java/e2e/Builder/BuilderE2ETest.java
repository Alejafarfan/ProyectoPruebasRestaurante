package e2e.Builder;

import Creacionales.Builder.controlador.BuilderController;
import Creacionales.Builder.modelo.Dish;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BuilderE2ETest {

    @Test
    void fullFlowCreatesMenuSuccessfully() {
        BuilderController controller = new BuilderController();
        Dish daily = controller.buildDish("dia");
        Dish veggie = controller.buildDish("vegetariano");

        assertNotNull(daily);
        assertNotNull(veggie);
        assertNotEquals(daily.getName(), veggie.getName());
    }
}
    

