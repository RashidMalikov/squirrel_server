package mobi.controller;

import mobi.model.*;
import mobi.model.dishes.Dish;
import mobi.model.dishes.DishUserMapper;
import mobi.model.dishes.Dishes;
import mobi.model.dishes.ObjectDish;
import mobi.model.settlements.ObjectSettlement;
import mobi.model.settlements.Settlement;
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
    public ObjectSettlement greeting(@RequestParam(value = "time", defaultValue = "0") String time) {
        String sqlNew = "SELECT id, title FROM settlements where updated_at > ? and deleted = 0";
        List<Settlement> settlementsNew = jdbcTemplate.query(sqlNew, new Object[]{time},
                new SettlementUserMapper());

        String sqlUpdate = "SELECT id, title FROM settlements where updated_at > ? and created_at < ? and deleted = 0";
        List<Settlement> settlementsUpdated = jdbcTemplate.query(sqlUpdate, new Object[]{time, time},
                new SettlementUserMapper());

        String sqlDeleted = "SELECT id, title FROM settlements where updated_at > ? and deleted = 1";
        List<Long> settlementsIDDeleted = jdbcTemplate.query(sqlDeleted, new Object[]{time},
                new SettlementsId());

        return new ObjectSettlement(new Settlements(settlementsNew, settlementsUpdated, settlementsIDDeleted));
    }

    @RequestMapping("/dishes")
    public ObjectDish greeting(@RequestParam(value = "time", defaultValue = "0") String time,
                               @RequestParam(defaultValue = "-1") long establishment_id,
                               @RequestParam(defaultValue = "-1") long category_id) {

        return new ObjectDish(getDishes(time, establishment_id, category_id));
    }

    private Dishes getDishes(String time, long establishment_id, long category_id){
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
                    new SettlementsId());
        } else {
            sqlNew = "SELECT id, title, description, image_url, price, establishment_id, dish_category, createdAt, updatedAt FROM dishes where establishment_id = ? and dish_category = ? and updatedAt > ? and deleted = 0";
            dishesNew = jdbcTemplate.query(sqlNew, new Object[]{establishment_id, category_id, time},
                    new DishUserMapper());
            sqlUpdate = "SELECT id, title, description, image_url, price, establishment_id, dish_category, createdAt, updatedAt FROM dishes where establishment_id = ? and dish_category = ? and updatedAt > ? and createdAt < ? and deleted = 0";
            dishesUpdated = jdbcTemplate.query(sqlUpdate, new Object[]{establishment_id, category_id, time, time},
                    new DishUserMapper());
            sqlDeleted = "SELECT id, title, description, image_url, price, establishment_id, dish_category, createdAt, updatedAt FROM dishes where  establishment_id = ? and dish_category = ? and updatedAt > ? and deleted = 1";
            dishesIDDeleted = jdbcTemplate.query(sqlDeleted, new Object[]{establishment_id, category_id, time},
                    new SettlementsId());
        }

        return new Dishes(new Dishes(dishesNew, dishesUpdated, dishesIDDeleted))

    }

    @RequestMapping("/foo")
    public String foo(@RequestParam(value = "time", defaultValue = "0") String time) {
        return "";
    }
}
