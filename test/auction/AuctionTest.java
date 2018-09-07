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

    @Test
    public void mustNotAcceptTwoConsecutiveBidsFromTheSameUser() {
        Auction auction = new Auction("Macbook Pro 15");
        User john = new User("John");

        auction.proposes(new Bid(john, 2000.0));
        auction.proposes(new Bid(john, 3000.0));

        assertEquals(1, auction.getBids().size());
        assertEquals(2000.0, auction.getBids().get(0).getValue(), 0.00001);
    }

    @Test
    public void mustNotAcceptFiveBidsFromTheSameUser() {
        Auction auction = new Auction("Macbook Pro 15");
        User john = new User("John");
        User bill = new User("Bill");

        auction.proposes(new Bid(john, 2000.0));
        auction.proposes(new Bid(bill, 3000.0));

        auction.proposes(new Bid(john, 4000.0));
        auction.proposes(new Bid(bill, 5000.0));

        auction.proposes(new Bid(john, 6000.0));
        auction.proposes(new Bid(bill, 7000.0));

        auction.proposes(new Bid(john, 8000.0));
        auction.proposes(new Bid(bill, 9000.0));

        auction.proposes(new Bid(john, 10000.0));
        auction.proposes(new Bid(bill, 11000.0));

        //must be igonored
        auction.proposes(new Bid(john, 12000.0));

        assertEquals(10, auction.getBids().size());
        assertEquals(11000.0, auction.getBids().get(auction.getBids().size()-1).getValue(), 0.00001);
    }

}
