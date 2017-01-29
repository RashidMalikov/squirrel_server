package mobi.controller;

import mobi.model.*;
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

    @RequestMapping("/settlement")
    public SettlementData greeting(@RequestParam(value="time", defaultValue="0") String time) {
        String sqlNew = "SELECT id, title FROM settlement where updated_at > ? and deleted = 0";
        List<Settlement> settlementsNew = jdbcTemplate.query(sqlNew, new Object[]{time},
                new SettlementUserMapper());

        String sqlUpdate = "SELECT id, title FROM settlement where updated_at > ? and created_at < ? and deleted = 0";
        List<Settlement> settlementsUpdated = jdbcTemplate.query(sqlUpdate, new Object[]{time, time},
                new SettlementUserMapper());

        String sqlDeleted = "SELECT id, title FROM settlement where updated_at > ? and deleted = 1";
        List<Long> settlementsIDDeleted = jdbcTemplate.query(sqlDeleted, new Object[]{time},
                new SettlementsId());

        return new SettlementData(new SettlementDTO(settlementsNew, settlementsUpdated, settlementsIDDeleted));
    }

    @RequestMapping("/foo")
    public String foo(@RequestParam(value="time", defaultValue="0") String time) {
        return "";
    }
}
