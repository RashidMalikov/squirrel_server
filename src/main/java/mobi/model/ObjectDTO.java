package mobi.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

public class ObjectDTO<T> {

    private List<T> created;
    private List<T> updated;
    private List<Long> deleted;

    public ObjectDTO(List<T> created, List<T> updated, List<Long> deleted) {
        this.created = created;
        this.updated = updated;
        this.deleted = deleted;
    }

    public List<T> getCreated() {
        return created;
    }

    public void setCreated(List<T> created) {
        this.created = created;
    }

    public List<T> getUpdated() {
        return updated;
    }

    public void setUpdated(List<T> updated) {
        this.updated = updated;
    }

    public List<Long> getDeleted() {
        return deleted;
    }

    public void setDeleted(List<Long> deleted) {
        this.deleted = deleted;
    }

}
