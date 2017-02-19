package mobi.model.dishCategory;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DishCategoriesUserMapper implements RowMapper<DishCategory> {
    @Override
    public DishCategory mapRow(ResultSet rs, int i) throws SQLException {
        DishCategory dishCategory = new DishCategory();
        dishCategory.setId(rs.getLong("id"));
        dishCategory.setTitle(rs.getString("title"));
        dishCategory.setEstablishmentId(rs.getLong("establishment_id"));
        dishCategory.setImageUrl(rs.getString("image_url"));
        return dishCategory;
    }
}
