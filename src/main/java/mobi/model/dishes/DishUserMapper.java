package mobi.model.dishes;

import mobi.model.dishes.Dish;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishUserMapper implements RowMapper<Dish> {
    @Override
    public Dish mapRow(ResultSet rs, int i) throws SQLException {
        Dish dish = new Dish();
        dish.setId(rs.getLong("id"));
        dish.setTitle(rs.getString("title"));
        dish.setDescription(rs.getString("description"));
        dish.setImageUrl(rs.getString("image_url"));
        dish.setPrice(rs.getInt("price"));
        dish.setEstablishmentId(rs.getLong("establishment_id"));
        dish.setDishCategory(rs.getLong("dish_category"));
        return dish;
    }
}
