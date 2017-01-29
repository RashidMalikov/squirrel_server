package mobi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component
public class SettlementDAOImpl implements SettlementDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Settlement> getSettlements() {
        String sql = "SELECT id, title FROM settlement";

        List<Settlement> settlements = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(Settlement.class));
        return settlements;
    }
}
