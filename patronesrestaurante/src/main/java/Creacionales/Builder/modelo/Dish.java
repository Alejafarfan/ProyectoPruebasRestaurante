package Creacionales.Builder.modelo;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private String name;
    private String mainIngredient;
    private List<String> sideIngredients;
    private String drink;
    private double price;

    public Dish() {
        this.sideIngredients = new ArrayList<>();
    }

    public void setName(String name) { this.name = name; }
    public void setMainIngredient(String mainIngredient) { this.mainIngredient = mainIngredient; }
    public void addSideIngredient(String ingredient) { this.sideIngredients.add(ingredient); }
    public void setDrink(String drink) { this.drink = drink; }
    public void setPrice(double price) { this.price = price; }

    public String getName() { return name; }
    public String getMainIngredient() { return mainIngredient; }
    public List<String> getSideIngredients() { return new ArrayList<>(sideIngredients); }
    public String getDrink() { return drink; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Plato: " + name +
                "\nPrincipal: " + mainIngredient +
                "\nAcompañamientos: " + sideIngredients +
                "\nBebida: " + drink +
                "\nPrecio: $" + price;
    }
}
