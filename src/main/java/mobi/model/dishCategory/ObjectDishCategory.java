package mobi.model.dishCategory;

public class ObjectDishCategory {

    private DishCategories dishcategory;

    public ObjectDishCategory(DishCategories dishes) {
        this.dishcategory = dishes;
    }

    public DishCategories getDishes() {
        return dishcategory;
    }

    public void setDishes(DishCategories dishes) {
        this.dishcategory = dishes;
    }
}
