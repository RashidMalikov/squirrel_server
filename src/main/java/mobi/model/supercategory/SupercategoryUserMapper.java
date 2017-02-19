package mobi.model.supercategory;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupercategoryUserMapper implements RowMapper<Supercategory> {
    @Override
    public Supercategory mapRow(ResultSet rs, int i) throws SQLException {
        Supercategory supercategory = new Supercategory();
        supercategory.setId(rs.getLong("id"));
        supercategory.setTitle(rs.getString("title"));
        supercategory.setImageUrl(rs.getString("image_url"));
        return supercategory;
    }
}
