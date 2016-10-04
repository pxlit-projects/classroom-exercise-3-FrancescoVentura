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

    public RaidersBuilder withRaiders(int amountOfRaiders) {
        for (int i = 0; i < amountOfRaiders; i++) {
            this.raiders.add(new Raider());
        }

        return this;
    }

    public Raiders build(){
        Raiders raiders = new Raiders(hasLegendary);
        raiders.addAttacker(new Raider());
        return raiders;
    }

}