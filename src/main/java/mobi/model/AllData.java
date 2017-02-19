package mobi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import mobi.model.dishCategory.DishCategories;
import mobi.model.dishes.Dishes;
import mobi.model.establishment.Establishments;
import mobi.model.events.Events;
import mobi.model.settlements.Settlements;
import mobi.model.supercategory.Supercategories;

public class AllData {

    private Settlements settlements;
    private Establishments establishments;
    private Dishes dishes;
    private Supercategories supercategories;
    @JsonProperty("dish_categories")
    private DishCategories dishCategories;
    private Events events;

    public AllData(Settlements settlements, Establishments establishments, Dishes dishes, Supercategories supercategories, DishCategories dishCategories, Events events) {
        this.settlements = settlements;
        this.establishments = establishments;
        this.dishes = dishes;
        this.supercategories = supercategories;
        this.dishCategories = dishCategories;
        this.events = events;
    }

    public Events getEvents() {
        return events;
    }

    public void setEvents(Events events) {
        this.events = events;
    }

    public Supercategories getSupercategories() {
        return supercategories;
    }

    public void setSupercategories(Supercategories supercategories) {
        this.supercategories = supercategories;
    }

    public DishCategories getDishCategories() {
        return dishCategories;
    }

    public void setDishCategories(DishCategories dishCategories) {
        this.dishCategories = dishCategories;
    }

    public Settlements getSettlements() {
        return settlements;
    }

    public void setSettlements(Settlements settlements) {
        this.settlements = settlements;
    }

    public Establishments getEstablishments() {
        return establishments;
    }

    public void setEstablishments(Establishments establishments) {
        this.establishments = establishments;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }
}
