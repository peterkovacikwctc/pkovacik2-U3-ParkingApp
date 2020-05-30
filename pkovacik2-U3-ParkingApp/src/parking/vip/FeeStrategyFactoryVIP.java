/**
 * The FeeStrategyFactoryVIP is not used in this program.
 *
 * It could be used by writing the following code into the ParkingAppDriver:
 * FeeStrategyFactory factory = FeeStrategyFactoryVIP.getInstance();
 */

package parking.vip;

import parking.FeeStrategy;
import parking.FeeStrategyFactory;
import parking.TicketType;

public class FeeStrategyFactoryVIP implements FeeStrategyFactory {

    private static FeeStrategyFactoryVIP instance = null;

    private FeeStrategyFactoryVIP() {

    }

    public static FeeStrategyFactoryVIP getInstance() {
        if (instance == null) {
            synchronized (FeeStrategyFactoryVIP.class) {
                if (instance == null)
                    instance = new FeeStrategyFactoryVIP();
            }
        }
        return instance;
    }

    public FeeStrategy implement(TicketType strategyName) {
        switch (strategyName) {
            case MinMax:
                return new MinMaxVIPFee();
            case SpecialEvent:
                return new SpecialEventVIPFee();
            case LostTicket:
                return new LostTicketVIPFee();
        }
        return null;
    }

}
