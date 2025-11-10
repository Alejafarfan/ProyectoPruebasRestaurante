package Estructurales.Proxy.modelo;

public class Kitchen implements KitchenService {
    private final String chefName;
    private final int preparationTime;
    private final String specialty;


    public Kitchen(String chefName, int preparationTime, String specialty) {
        this.chefName = chefName;
        this.preparationTime = preparationTime;
        this.specialty = specialty;
    }
        public String prepareDish(String dishName) {
        return "Dish prepared: " + dishName + " by chef " + chefName;
    }

    @Override
    public void prepareOrder(String dish) {
        System.out.println("El chef " + chefName + " está preparando la orden " + dish +
                           " (especialidad: " + specialty + ")");
        try {
            Thread.sleep(preparationTime * 100L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("El chef avisa que la orden de " + dish + " está lista.");
    }

    public String getChefName() { return chefName; }
    public int getPreparationTime() { return preparationTime; }
    public String getSpecialty() { return specialty; }
}

