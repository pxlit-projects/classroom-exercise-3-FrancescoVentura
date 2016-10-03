package be.pxl.mockitis;

import java.util.ArrayList;
import java.util.List;

public class RaidersBuilder {
    private boolean hasLegendary;
    private List<Raider> raiders = new ArrayList<>();

    public RaidersBuilder withHasLegendary(boolean hasLegendary) {
        this.hasLegendary = hasLegendary;
        return this;
    }

    public RaidersBuilder withRaiders(List<Raider> raiders) {
        this.raiders = raiders;
        return this;
    }

    public Raiders build(){
        Raiders raiders = new Raiders(hasLegendary);
        raiders.addAttacker(new Raider());
        return raiders;
    }
}