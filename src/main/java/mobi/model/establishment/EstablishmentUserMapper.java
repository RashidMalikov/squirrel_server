package mobi.model.establishment;

import mobi.model.dishes.Dish;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EstablishmentUserMapper implements RowMapper<Establishment> {
    @Override
    public Establishment mapRow(ResultSet rs, int i) throws SQLException {
        Establishment establishment = new Establishment();
        establishment.setId(rs.getLong("id"));
        establishment.setTitle(rs.getString("title"));
        establishment.setDescription(rs.getString("description"));
        establishment.setPhoneNumber(rs.getString("phone_number"));
        establishment.setImageUrl(rs.getString("image_url"));
        establishment.setAddress(rs.getString("address"));
            establishment.setSettlementId(rs.getLong("settlement_id"));
        return establishment;
    }
}
