/**
 * The FeeStrategyFactoryVIP is used in the ParkingAppDriver with the following code:
 *
 * FeeStrategyFactory factory = FeeStrategyFactoryCommercial.getInstance();
 */

package parking.commerical;

import parking.FeeStrategy;
import parking.FeeStrategyFactory;
import parking.TicketType;

public class FeeStrategyFactoryCommercial implements FeeStrategyFactory {

    private static FeeStrategyFactoryCommercial instance = null;

    private FeeStrategyFactoryCommercial() {

    }

    public static FeeStrategyFactoryCommercial getInstance() {
        if (instance == null) {
            synchronized (FeeStrategyFactoryCommercial.class) {
                if (instance == null)
                    instance = new FeeStrategyFactoryCommercial();
            }
        }
        return instance;
    }

    public FeeStrategy implement(TicketType strategyName) {
        switch (strategyName) {
            case MinMax:
                return new MinMaxFee();
            case SpecialEvent:
                return new SpecialEventFee();
            case LostTicket:
                return new LostTicketFee();
        }
        return null;
    }

}
