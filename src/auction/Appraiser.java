package auction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Appraiser {

    private double highestOffAll = Double.NEGATIVE_INFINITY;
    private double lowestOfAll = Double.POSITIVE_INFINITY;
    private List<Bid> highests;

    public void evaluates(Auction auction) {

        if(auction.getBids().size() == 0) {
            throw new RuntimeException("Can not rate an auction without bids!");
        }

        for(Bid bid : auction.getBids()) {
            if (bid.getValue() > highestOffAll) {
                highestOffAll = bid.getValue();
            }

            if (bid.getValue() < lowestOfAll) {
                lowestOfAll = bid.getValue();
            }
        }

        highests = new ArrayList<>(auction.getBids());
        Collections.sort(highests, new Comparator<Bid>() {

            public int compare(Bid o1, Bid o2) {
                if(o1.getValue() < o2.getValue()) return 1;
                if(o1.getValue() > o2.getValue()) return -1;
                return 0;
            }
        });
        highests = highests.subList(0, highests.size() > 3 ? 3 : highests.size());
    }

    public List<Bid> getThreeHighestBids(){
        return highests;
    }

    public double getHighestBid() {
        return highestOffAll;
    }

    public double getLowestBid() {
        return lowestOfAll;
    }
}
