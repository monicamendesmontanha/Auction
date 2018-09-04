package auction;

public class Appraiser {

    private double greatestOfAll = Double.NEGATIVE_INFINITY;
    private double lowestOfAll = Double.POSITIVE_INFINITY;

    public void evaluates(Auction auction) {
        for(Bid bid : auction.getBids()) {
            if (bid.getValue() > greatestOfAll) greatestOfAll = bid.getValue();
            else if (bid.getValue() < lowestOfAll) lowestOfAll = bid.getValue();
        }
    }

    public double getHigherBid() {
        return greatestOfAll;
    }

    public double getLowestBid() {
        return lowestOfAll;
    }
}
