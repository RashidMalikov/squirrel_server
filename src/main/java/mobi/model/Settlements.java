package mobi.model;

import java.util.List;

public class Settlements {

    private List created;
    private List updated;
    private List<Long> deleted;

    public Settlements(List created, List updated, List<Long> deleted) {
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
