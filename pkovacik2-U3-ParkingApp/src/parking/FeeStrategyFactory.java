/**
 * The FeeStrategyFactory uses the factory design pattern.
 * The implement() method allows the user to enter the
 * ticket type to choose the appropriate fee strategy.
 */

package parking;

public interface FeeStrategyFactory {

    FeeStrategy implement(TicketType strategyName);
}
