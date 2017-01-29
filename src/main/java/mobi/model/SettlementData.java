package mobi.model;

public class SettlementData {
    private SettlementDTO settlements;

    public SettlementData(SettlementDTO settlements) {
        this.settlements = settlements;
    }

    public SettlementDTO getSettlements() {
        return settlements;
    }

    public void setSettlements(SettlementDTO settlements) {
        this.settlements = settlements;
    }
}
