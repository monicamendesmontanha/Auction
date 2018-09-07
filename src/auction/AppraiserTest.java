package auction;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

public class AppraiserTest {

    private Appraiser auctioneer;
    private User dan;
    private User july;
    private User rapha;

    @Before
    public void createsAppraiser() {
        this.auctioneer = new Appraiser();
        this.dan = new User("Dan");
        this.july = new User("July");
        this.rapha = new User("Rapha");
    }

    @Test(expected = RuntimeException.class)
    public void mustNotEvaluateAnAuctionWithoutBids() {
        Auction auction = new CreatorOfAuction().to("Playstation 4").builds();

        auctioneer.evaluates(auction);
    }

    @Test
    public void mustUnderstandBidsInAscendingOrder() {

        Auction auction = new Auction("Playstation 4");

        auction.proposes(new Bid(dan, 250.0));
        auction.proposes(new Bid(july, 300.0));
        auction.proposes(new Bid(rapha, 400.0));

        auctioneer.evaluates (auction);

        double expectedHigher = 400;
        double expectedLower = 250;

        assertThat(auctioneer.getHighestBid(), equalTo(400.0));
        assertThat(auctioneer.getLowestBid(), equalTo(250.0));
    }

    @Test
    public void mustUnderstandAuctionWithOnlyOneBid() {
        Auction auction = new Auction("Playstation 4");

        auction.proposes(new Bid(dan, 1000.0));

        auctioneer.evaluates(auction);

        assertEquals(1000.0, auctioneer.getHighestBid(), 0.00001);
        assertEquals(1000.0, auctioneer.getLowestBid(), 0.00001);
    }

    @Test
    public void mustFindTheHighestThreeBids() {

        Auction auction = new CreatorOfAuction().to("Playstation 4")
            .bid(dan, 100.0)
            .bid(july, 200.0)
            .bid(dan, 300.0)
            .bid(july, 400.0)
            .builds();

        auctioneer.evaluates(auction);

        List<Bid> highests = auctioneer.getThreeHighestBids();
        assertEquals(3, highests.size());

        assertThat(highests, hasItems(
                new Bid(july, 400),
                new Bid(dan, 300),
                new Bid(july, 200)
        ));
    }

}
