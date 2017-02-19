package mobi.model.establishment;

import java.util.List;

public class Establishments {

    private List<Establishment> created;
    private List<Establishment> updated;
    private List<Long> deleted;

    public Establishments(List<Establishment> created, List<Establishment> updated, List<Long> deleted) {
        this.created = created;
        this.updated = updated;
        this.deleted = deleted;
    }

    public List getCreated() {
        return created;
    }

    public void setCreated(List created) {
        this.created = created;
    }

    public List getUpdated() {
        return updated;
    }

    public void setUpdated(List updated) {
        this.updated = updated;
    }

    public List<Long> getDeleted() {
        return deleted;
    }

    public void setDeleted(List<Long> deleted) {
        this.deleted = deleted;
    }

}
