package Q1.pubV0;


import java.util.HashMap;

class Drink {
    private String name;
    private int price;

    private static HashMap<String, Integer> ingredients = new HashMap<String, Integer>() {
        {
            put("rum", 65);
            put("grenadine", 10);
            put("lime juice", 10);
            put("green stuff", 10);
            put("tonic water", 20);
            put("gin", 85);
        }
    };

    Drink(String name, int price) {
        this.name = name;
        this.price = price;
    }

    Drink(String name, String[] ingredients) {
        this.name = name;
        price = 0;
        for (String i : ingredients)
            price += Drink.ingredients.get(i);
    }

    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }
}
