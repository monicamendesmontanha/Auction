package auction;

public class Appraiser {

    private double greatestOfAll = Double.NEGATIVE_INFINITY;

    public void evaluates(Auction auction) {
        for(Bid bid : auction.getBids()) {
            if(bid.getValue() > greatestOfAll) greatestOfAll = bid.getValue();
        }
    }

    public double getHigherBid() {
        return greatestOfAll;
    }
}
