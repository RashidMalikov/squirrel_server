package mobi.model;

import java.util.List;

public class SettlementDTO {

    private List<Settlement> created;
    private List<Settlement> updated;
    private List<Long> deleted;

    public SettlementDTO(List<Settlement> created, List<Settlement> updated, List<Long> deleted) {
        this.created = created;
        this.updated = updated;
        this.deleted = deleted;
    }

    public List<Settlement> getCreated() {
        return created;
    }

    public void setCreated(List<Settlement> created) {
        this.created = created;
    }

    public List<Settlement> getUpdated() {
        return updated;
    }

    public void setUpdated(List<Settlement> updated) {
        this.updated = updated;
    }

    public List<Long> getDeleted() {
        return deleted;
    }

    public void setDeleted(List<Long> deleted) {
        this.deleted = deleted;
    }
}
