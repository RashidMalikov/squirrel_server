package mobi.controller;

import mobi.model.*;
import mobi.model.dishCategory.DishCategories;
import mobi.model.dishCategory.DishCategoriesUserMapper;
import mobi.model.dishCategory.DishCategory;
import mobi.model.dishCategory.ObjectDishCategory;
import mobi.model.dishes.Dish;
import mobi.model.dishes.DishUserMapper;
import mobi.model.dishes.Dishes;
import mobi.model.dishes.ObjectDish;
import mobi.model.establishment.Establishment;
import mobi.model.establishment.EstablishmentUserMapper;
import mobi.model.establishment.Establishments;
import mobi.model.establishment.ObjectEstablishment;
import mobi.model.events.Event;
import mobi.model.events.EventUserMapper;
import mobi.model.events.Events;
import mobi.model.events.ObjectEvent;
import mobi.model.settlements.ObjectSettlement;
import mobi.model.settlements.Settlement;
import mobi.model.settlements.SettlementUserMapper;
import mobi.model.settlements.Settlements;
import mobi.model.supercategory.ObjectSupercategory;
import mobi.model.supercategory.Supercategories;
import mobi.model.supercategory.Supercategory;
import mobi.model.supercategory.SupercategoryUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/settlements")
    public ObjectSettlement settlemets(@RequestParam(value = "time", defaultValue = "0") String time) {

        return new ObjectSettlement(getSettlement(time));
    }

    private Settlements getSettlement(String time) {
        String sqlNew = "SELECT id, title FROM settlements where updated_at > ? and deleted = 0";
        List<Settlement> settlementsNew = jdbcTemplate.query(sqlNew, new Object[]{time},
                new SettlementUserMapper());

        String sqlUpdate = "SELECT id, title FROM settlements where updated_at > ? and created_at < ? and deleted = 0";
        List<Settlement> settlementsUpdated = jdbcTemplate.query(sqlUpdate, new Object[]{time, time},
                new SettlementUserMapper());

        String sqlDeleted = "SELECT id, title FROM settlements where updated_at > ? and deleted = 1";
        List<Long> settlementsIDDeleted = jdbcTemplate.query(sqlDeleted, new Object[]{time},
                new ObjectId());

        return new Settlements(settlementsNew, settlementsUpdated, settlementsIDDeleted);

    }

    @RequestMapping("/establishments")
    public ObjectEstablishment establishments(@RequestParam(value = "time", defaultValue = "0") String time,
                                              @RequestParam(defaultValue = "-1") long settlement_id) {

        return new ObjectEstablishment(getEstablishment(time, settlement_id));
    }

    private Establishments getEstablishment(String time, long settlement_id) {
        String sqlNew;
        List<Establishment> establishmentNew;
        String sqlUpdate;
        List<Establishment> establishmentsUpdated;
        String sqlDeleted;
        List<Long> establishmentsIDDeleted;
        if (settlement_id == -1) {
            sqlNew = "SELECT id, title, description, image_url, phone_number, address,  settlement_id, createdAt, updatedAt FROM establishments where updatedAt > ? and deleted = 0";
            establishmentNew = jdbcTemplate.query(sqlNew, new Object[]{time},
                    new EstablishmentUserMapper());

            sqlUpdate = "SELECT id, title, description, image_url, phone_number, address,  settlement_id, createdAt, updatedAt FROM establishments where updatedAt > ? and createdAt < ? and deleted = 0";
            establishmentsUpdated = jdbcTemplate.query(sqlUpdate, new Object[]{time, time},
                    new EstablishmentUserMapper());

            sqlDeleted = "SELECT id, title, description, image_url, phone_number, address,  settlement_id, createdAt, updatedAt FROM establishments where updatedAt > ? and deleted = 1";
            establishmentsIDDeleted = jdbcTemplate.query(sqlDeleted, new Object[]{time},
                    new ObjectId());
        } else {
            sqlNew = "SELECT id, title, description, image_url, phone_number, address,  settlement_id, createdAt, updatedAt FROM establishments where settlement_id = ? and updatedAt > ? and deleted = 0";
            establishmentNew = jdbcTemplate.query(sqlNew, new Object[]{settlement_id, time},
                    new EstablishmentUserMapper());
            sqlUpdate = "SELECT id, title, description, image_url, phone_number, address,  settlement_id, createdAt, updatedAt FROM establishments where settlement_id = ? and createdAt < ? and deleted = 0";
            establishmentsUpdated = jdbcTemplate.query(sqlUpdate, new Object[]{settlement_id, time, time},
                    new EstablishmentUserMapper());
            sqlDeleted = "SELECT id, title, description, image_url, phone_number, address,  settlement_id, createdAt, updatedAt FROM establishments where settlement_id = ? and deleted = 1";
            establishmentsIDDeleted = jdbcTemplate.query(sqlDeleted, new Object[]{settlement_id, time},
                    new ObjectId());
        }

        return new Establishments(establishmentNew, establishmentsUpdated, establishmentsIDDeleted);
    }


    @RequestMapping("/dishes")
    public ObjectDish greeting(@RequestParam(value = "time", defaultValue = "0") String time,
                               @RequestParam(defaultValue = "-1") long establishment_id,
                               @RequestParam(defaultValue = "-1") long category_id) {

        return new ObjectDish(getDishes(time, establishment_id, category_id));
    }

    private Dishes getDishes(String time, long establishment_id, long category_id) {
        String sqlNew;
        List<Dish> dishesNew;
        String sqlUpdate;
        List<Dish> dishesUpdated;
        String sqlDeleted;
        List<Long> dishesIDDeleted;
        if (establishment_id == -1 && category_id == -1) {
            sqlNew = "SELECT id, title, description, image_url, price, establishment_id, dish_category, createdAt, updatedAt FROM dishes where updatedAt > ? and deleted = 0";
            dishesNew = jdbcTemplate.query(sqlNew, new Object[]{time},
                    new DishUserMapper());

            sqlUpdate = "SELECT id, title, description, image_url, price, establishment_id, dish_category, createdAt, updatedAt FROM dishes where updatedAt > ? and createdAt < ? and deleted = 0";
            dishesUpdated = jdbcTemplate.query(sqlUpdate, new Object[]{time, time},
                    new DishUserMapper());

            sqlDeleted = "SELECT id, title, description, image_url, price, establishment_id, dish_category, createdAt, updatedAt FROM dishes where updatedAt > ? and deleted = 1";
            dishesIDDeleted = jdbcTemplate.query(sqlDeleted, new Object[]{time},
                    new ObjectId());
        } else {
            sqlNew = "SELECT id, title, description, image_url, price, establishment_id, dish_category, createdAt, updatedAt FROM dishes where establishment_id = ? and dish_category = ? and updatedAt > ? and deleted = 0";
            dishesNew = jdbcTemplate.query(sqlNew, new Object[]{establishment_id, category_id, time},
                    new DishUserMapper());
            sqlUpdate = "SELECT id, title, description, image_url, price, establishment_id, dish_category, createdAt, updatedAt FROM dishes where establishment_id = ? and dish_category = ? and updatedAt > ? and createdAt < ? and deleted = 0";
            dishesUpdated = jdbcTemplate.query(sqlUpdate, new Object[]{establishment_id, category_id, time, time},
                    new DishUserMapper());
            sqlDeleted = "SELECT id, title, description, image_url, price, establishment_id, dish_category, createdAt, updatedAt FROM dishes where  establishment_id = ? and dish_category = ? and updatedAt > ? and deleted = 1";
            dishesIDDeleted = jdbcTemplate.query(sqlDeleted, new Object[]{establishment_id, category_id, time},
                    new ObjectId());
        }

        return new Dishes(dishesNew, dishesUpdated, dishesIDDeleted);

    }

    @RequestMapping("/data")
    public AllData allData(@RequestParam(value = "time", defaultValue = "0") String time) {
        return new AllData(
                getSettlement(time),
                getEstablishment(time, -1),
                getDishes(time, -1, -1),
                getSupercategories(time),
                getDishCategories(time, -1),
                getEvent(time));
    }

    @RequestMapping("/supercategories")
    public ObjectSupercategory supercategory(@RequestParam(value = "time", defaultValue = "0") String time) {

        return new ObjectSupercategory(getSupercategories(time));

    }

    private Supercategories getSupercategories(String time) {

        String sqlNew;
        List<Supercategory> supercategoriesNew;
        String sqlUpdate;
        List<Supercategory> supercategoriesUpdated;
        String sqlDeleted;
        List<Long> supercategoriesIDDeleted;

        sqlNew = "SELECT id, title, image_url, createdAt, updatedAt FROM supercategories where updatedAt > ? and deleted = 0";
        supercategoriesNew = jdbcTemplate.query(sqlNew, new Object[]{time},
                new SupercategoryUserMapper());

        sqlUpdate = "SELECT id, title, image_url, createdAt, updatedAt FROM supercategories where updatedAt > ? and createdAt < ? and deleted = 0";
        supercategoriesUpdated = jdbcTemplate.query(sqlUpdate, new Object[]{time, time},
                new SupercategoryUserMapper());

        sqlDeleted = "SELECT id, title, image_url, createdAt, updatedAt FROM supercategories where updatedAt > ? and deleted = 1";
        supercategoriesIDDeleted = jdbcTemplate.query(sqlDeleted, new Object[]{time},
                new ObjectId());

        return new Supercategories(supercategoriesNew, supercategoriesUpdated, supercategoriesIDDeleted);
    }

    @RequestMapping("/dishcategories")
    public ObjectDishCategory dishCategory(@RequestParam(value = "time", defaultValue = "0") String time,
                                           @RequestParam(defaultValue = "-1") long establishment_id) {

        return new ObjectDishCategory(getDishCategories(time, establishment_id));
    }

    private DishCategories getDishCategories(String time, long establishment_id) {

        String sqlNew;
        List<DishCategory> dishCategoriesNew;
        String sqlUpdate;
        List<DishCategory> dishCategoriesUpdated;
        String sqlDeleted;
        List<Long> dishCategoriesIDDeleted;

        if (establishment_id == -1) {

            sqlNew = "SELECT id, title, image_url, establishment_id, createdAt, updatedAt FROM dish_categories where updatedAt > ? and deleted = 0";
            dishCategoriesNew = jdbcTemplate.query(sqlNew, new Object[]{time},
                    new DishCategoriesUserMapper());

            sqlUpdate = "SELECT id, title, image_url, establishment_id, createdAt, updatedAt FROM dish_categories where updatedAt > ? and createdAt < ? and deleted = 0";
            dishCategoriesUpdated = jdbcTemplate.query(sqlUpdate, new Object[]{time, time},
                    new DishCategoriesUserMapper());

            sqlDeleted = "SELECT id, title, image_url, establishment_id, createdAt, updatedAt FROM dish_categories where updatedAt > ? and deleted = 1";
            dishCategoriesIDDeleted = jdbcTemplate.query(sqlDeleted, new Object[]{time},
                    new ObjectId());

        } else {

            sqlNew = "SELECT id, title, image_url, establishment_id, createdAt, updatedAt FROM dish_categories where updatedAt > ? and establishment_id = ? and deleted = 0";
            dishCategoriesNew = jdbcTemplate.query(sqlNew, new Object[]{time, establishment_id},
                    new DishCategoriesUserMapper());

            sqlUpdate = "SELECT id, title, image_url, establishment_id, createdAt, updatedAt FROM dish_categories where updatedAt > ? and createdAt < ? and establishment_id = ? and deleted = 0";
            dishCategoriesUpdated = jdbcTemplate.query(sqlUpdate, new Object[]{time, time, establishment_id},
                    new DishCategoriesUserMapper());

            sqlDeleted = "SELECT id, title, image_url, establishment_id, createdAt, updatedAt FROM dish_categories where updatedAt > ? and establishment_id = ? and deleted = 1";
            dishCategoriesIDDeleted = jdbcTemplate.query(sqlDeleted, new Object[]{time, establishment_id},
                    new ObjectId());

        }

        return new DishCategories(dishCategoriesNew, dishCategoriesUpdated, dishCategoriesIDDeleted);
    }


    @RequestMapping("/events")
    public ObjectEvent events(@RequestParam(value = "time", defaultValue = "0") String time) {

        return new ObjectEvent(getEvent(time));
    }


    private Events getEvent(String time) {
        String sqlNew = "SELECT id, title, description, image_url FROM events where updatedAt > ? and deleted = 0";
        List<Event> settlementsNew = jdbcTemplate.query(sqlNew, new Object[]{time},
                new EventUserMapper());

        String sqlUpdate = "SELECT id, title, description, image_url FROM events where updatedAt > ? and createdAt < ? and deleted = 0";
        List<Event> settlementsUpdated = jdbcTemplate.query(sqlUpdate, new Object[]{time, time},
                new EventUserMapper());

        String sqlDeleted = "SELECT id, title, description, image_url FROM events where updatedAt > ? and deleted = 1";
        List<Long> settlementsIDDeleted = jdbcTemplate.query(sqlDeleted, new Object[]{time},
                new ObjectId());

        return new Events(settlementsNew, settlementsUpdated, settlementsIDDeleted);

    }

}
