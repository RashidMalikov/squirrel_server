package mobi.model.events;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventUserMapper implements RowMapper<Event> {
    @Override
    public Event mapRow(ResultSet rs, int i) throws SQLException {
        Event event = new Event();
        event.setId(rs.getLong("id"));
        event.setTitle(rs.getString("title"));
        event.setDescription(rs.getString("description"));
        event.setImageUrl(rs.getString("image_url"));
        return event;
    }
}
