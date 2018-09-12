package Q1.pubV0;


import java.util.ArrayList;

class Pub {
    private static final String ONE_BEER = "hansa",
            ONE_CIDER = "grans",
            A_PROPER_CIDER = "strongbow",
            GT = "gt",
            BACARDI_SPECIAL = "bacardi_special";
    private static ArrayList<Drink> menu = new ArrayList<Drink>() {
        {
            add(new Drink(ONE_BEER, 74));
            add(new Drink(ONE_CIDER, 103));
            add(new Drink(A_PROPER_CIDER, 110));
            add(new Drink(GT, new String[]{"green stuff", "tonic water", "gin"}));
            add(new Drink(BACARDI_SPECIAL, new String[]{"rum", "grenadine", "lime juice", "gin"}));
        }
    };

    Pub() {
    }

    int computeCost(String drink, boolean student, int amount) {
        if (amount > 2 && (drink.equals(GT) || drink.equals(BACARDI_SPECIAL)))
            throw new RuntimeException("Too many drinks, max 2.");

        int price = -1;
        for (Drink d : menu)
            if (d.getName().equals(drink))
                price = d.getPrice();
        if (price == -1)
            throw new RuntimeException("No such drink exists");

        if (student && (drink == ONE_CIDER || drink == ONE_BEER || drink == A_PROPER_CIDER)) {
            price -= price / 10;
        }
        return price * amount;
    }

    void addDrinkToMenu(String name, int value) {
        menu.add(new Drink(name, value));
    }

    void removeDrinksFromMenu(String name) {
        for (Drink d : menu)
            if (d.getName().equals(name)) {
                menu.remove(d);
                break;
            }
    }
}
