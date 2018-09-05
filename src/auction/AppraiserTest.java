package auction;

import org.junit.Assert;
import org.junit.Test;

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

        Assert.assertEquals(expectedHigher, auctioneer.getHighestBid(), 0.00001);
        Assert.assertEquals(expectedLower, auctioneer.getLowestBid(), 0.00001);

    }
}
