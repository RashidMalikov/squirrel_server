package mobi.model.dishes;

import mobi.model.dishes.Dishes;

public class ObjectDish {

    private Dishes dishes;

    public ObjectDish(Dishes dishes) {
        this.dishes = dishes;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }
}
