package mobi.model;

import mobi.model.settlements.Settlement;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SettlementUserMapper implements RowMapper<Settlement> {
    @Override
    public Settlement mapRow(ResultSet rs, int i) throws SQLException {
        Settlement settlement = new Settlement();
        settlement.setId(rs.getLong("id"));
        settlement.setTitle(rs.getString("title"));
        return settlement;
    }
}
