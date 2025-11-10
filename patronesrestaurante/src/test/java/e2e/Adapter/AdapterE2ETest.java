package e2e.Adapter;

import Estructurales.Adapter.controlador.AdapterController;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThatCode;

class AdapterE2ETest {

    @Test
    void flujoCompletoDePagosDebeEjecutarseSinErrores() {
        AdapterController controller = new AdapterController();
        assertThatCode(controller::ejecutarPagos)
            .doesNotThrowAnyException();
    }

    @Test
    void multiplesFlujosSecuencialesNoDebenLanzarErrores() {
        AdapterController controller = new AdapterController();
        assertThatCode(() -> {
            for (int i = 0; i < 5; i++) {
                controller.ejecutarPagos();
            }
        }).doesNotThrowAnyException();
    }

    @Test
    void flujosConcurrentesDebenEjecutarseSinExcepciones() {
        AdapterController controller = new AdapterController();
        assertThatCode(() -> {
            ExecutorService exec = Executors.newFixedThreadPool(6);
            try {
                List<Callable<Void>> tareas = IntStream.range(0, 10)
                        .mapToObj(i -> (Callable<Void>) () -> {
                            controller.ejecutarPagos();
                            return null;
                        })
                        .collect(Collectors.toList());
                exec.invokeAll(tareas).forEach(f -> {
                    try { f.get(); } catch (Exception e) { throw new RuntimeException(e); }
                });
            } finally {
                exec.shutdownNow();
            }
        }).doesNotThrowAnyException();
    }
}
