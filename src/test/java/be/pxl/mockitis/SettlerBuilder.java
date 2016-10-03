package be.pxl.mockitis;

public class SettlerBuilder {
    private boolean assignedToDefense;

    public SettlerBuilder withAssignedToDefense(boolean assignedToDefense) {
        this.assignedToDefense = assignedToDefense;
        return this;
    }

    public Settler build(){
        return new Settler(assignedToDefense);
    }
}