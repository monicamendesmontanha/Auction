package auction;

public class Appraiser {

    private double highestOffAll = Double.NEGATIVE_INFINITY;
    private double lowestOfAll = Double.POSITIVE_INFINITY;

    public void evaluates(Auction auction) {
        for(Bid bid : auction.getBids()) {
            if (bid.getValue() > highestOffAll) {
                highestOffAll = bid.getValue();
            }

            if (bid.getValue() < lowestOfAll) {
                lowestOfAll = bid.getValue();
            }
        }
    }

    public double getHighestBid() {
        return highestOffAll;
    }

    public double getLowestBid() {
        return lowestOfAll;
    }
}
