package auction;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuctionTest {

    @Test
    public void mustReceiveOneBid() {
        Auction auction = new Auction("Macbook Pro 15");
        assertEquals(0, auction.getBids().size());

        auction.proposes(new Bid(new User("John"), 2000));

        assertEquals(1, auction.getBids().size());
        assertEquals(2000.0, auction.getBids().get(0).getValue(), 0.00001);
    }

    @Test
    public void mustReceiveSeveralBids() {
        Auction auction = new Auction("Macbook Pro 15");
        auction.proposes(new Bid(new User("John"), 2000));
        auction.proposes(new Bid(new User("Steve"), 3000));

        assertEquals(2, auction.getBids().size());
        assertEquals(2000.0, auction.getBids().get(0).getValue(), 0.00001);
        assertEquals(3000.0, auction.getBids().get(1).getValue(), 0.00001);
    }
}
