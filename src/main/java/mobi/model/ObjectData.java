package mobi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObjectData {

    @JsonProperty("some")
    private ObjectDTO objectDTO;

    public ObjectData(ObjectDTO objectDTO) {
        this.objectDTO = objectDTO;
    }

    public ObjectDTO getObjectDTO() {
        return objectDTO;
    }

    public void setObjectDTO(ObjectDTO objectDTO) {
        this.objectDTO = objectDTO;
    }
}
