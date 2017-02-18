package mobi.model.dishes;

import java.util.List;

public class Dishes {

    private List<Dish> created;
    private List<Dish> updated;
    private List<Long> deleted;

    public Dishes(List<Dish> created, List<Dish> updated, List<Long> deleted) {
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
