package be.pxl.mockitis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SettlementTest {

    @Test
    public void settlement_WhenMoreSettlersAssignedToDefenseThanAmountOfRaiders_CanDefendItself() throws Exception {
        ArrayList<Raider> raidersThatWillAttackYourBase = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            raidersThatWillAttackYourBase.add(new Raider());
        }

        Raiders raiders = new RaidersBuilder().withRaiders(raidersThatWillAttackYourBase).withHasLegendary(false).build();

        Settler defender = new SettlerBuilder().withAssignedToDefense(true).build();
        Settler farmer = new SettlerBuilder().withAssignedToDefense(false).build();
        Settler clerk =  new SettlerBuilder().withAssignedToDefense(false).build();

        List<Settler> settlers = Arrays.asList(defender, farmer, clerk);
        Settlement settlement = new Settlement(settlers);

        assertThat(settlement.defend(raiders)).isTrue();
    }

    @Test
    public void settlement_WhenEqualSettlersAssignedToDefenseThanAmountOfRaiders_CanDefendItself() throws Exception {
        ArrayList<Raider> raidersThatWillAttackYourBase = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            raidersThatWillAttackYourBase.add(new Raider());
        }

        Raiders raiders = new RaidersBuilder().withRaiders(raidersThatWillAttackYourBase).withHasLegendary(false).build();

        Settler defender = new SettlerBuilder().withAssignedToDefense(true).build();
        Settler farmer = new SettlerBuilder().withAssignedToDefense(true).build();
        Settler clerk =  new SettlerBuilder().withAssignedToDefense(false).build();

        List<Settler> settlers = Arrays.asList(defender, farmer, clerk);
        Settlement settlement = new Settlement(settlers);

        assertThat(settlement.defend(raiders)).isTrue();
    }

    @Test
    public void settlement_WhenLessSettlersAssignedToDefenseThanAmountOfRaiders_CanNotDefendItself() throws Exception {
        ArrayList<Raider> raidersThatWillAttackYourBase = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            raidersThatWillAttackYourBase.add(new Raider());
        }

        Raiders raiders = new RaidersBuilder().withRaiders(raidersThatWillAttackYourBase).withHasLegendary(false).build();

        Settler defender = new SettlerBuilder().withAssignedToDefense(true).build();
        Settler farmer = new SettlerBuilder().withAssignedToDefense(false).build();
        Settler clerk =  new SettlerBuilder().withAssignedToDefense(false).build();

        List<Settler> settlers = Arrays.asList(defender, farmer, clerk);
        Settlement settlement = new Settlement(settlers);

        assertThat(settlement.defend(raiders)).isFalse();
    }
}
