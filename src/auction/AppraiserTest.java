package auction;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AppraiserTest {

    @Test
    public void mustUnderstandBidsInAscendingOrder() {
        User dan = new User("Dan");
        User july = new User("July");
        User rapha = new User("Rapha");

        Auction auction = new Auction("Playstation 4");

        auction.proposes(new Bid(dan, 250.0));
        auction.proposes(new Bid(july, 300.0));
        auction.proposes(new Bid(rapha, 400.0));

        Appraiser auctioneer = new Appraiser();
        auctioneer.evaluates (auction);

        double expectedHigher = 400;
        double expectedLower = 250;

        assertEquals(expectedHigher, auctioneer.getHighestBid(), 0.00001);
        assertEquals(expectedLower, auctioneer.getLowestBid(), 0.00001);

    }

    @Test
    public void mustUnderstandAuctionWithOnlyOneBid() {
        User john = new User("John");
        Auction auction = new Auction("Playstation 4");

        auction.proposes(new Bid(john, 1000.0));

        Appraiser auctioneer = new Appraiser();
        auctioneer.evaluates(auction);

        assertEquals(1000.0, auctioneer.getHighestBid(), 0.00001);
        assertEquals(1000.0, auctioneer.getLowestBid(), 0.00001);
    }

    @Test
    public void mustFindTheHighestThreeBids() {
        User dan = new User("Dan");
        User july = new User("July");
        Auction auction = new Auction("Playstation 4");

        auction.proposes(new Bid (dan, 100.0));
        auction.proposes(new Bid (july, 200.0));
        auction.proposes(new Bid (dan, 400.0));
        auction.proposes(new Bid (july, 300.0));

        Appraiser auctioneer = new Appraiser();
        auctioneer.evaluates(auction);

        List<Bid> highests = auctioneer.getThreeHighestBids();
        assertEquals(3, highests.size());
        assertEquals(400.0, highests.get(0).getValue(), 0.00001);
        assertEquals(300.0, highests.get(1).getValue(), 0.00001);
        assertEquals(200.0, highests.get(2).getValue(), 0.00001);
    }
}
