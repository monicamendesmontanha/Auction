package auction;

import org.junit.Test;

public class AppraiserTest {

    @Test
    public void main() {
        User dan = new User("Dan");
        User july = new User("July");
        User rapha = new User("Rapha");

        Auction auction = new Auction("Playstation 4");

        auction.proposes(new Bid(dan, 250.0));
        auction.proposes(new Bid(july, 300.0));
        auction.proposes(new Bid(rapha, 400.0));

        Appraiser auctioneer = new Appraiser();
        auctioneer.evaluates (auction);

        System.out.println("The higher bid: " + auctioneer.getHigherBid());
        System.out.println("The lowest bid: " + auctioneer.getLowestBid());

        double expectedHigher = 400;
        double expectedLower = 250;

        System.out.println(expectedHigher == auctioneer.getHigherBid());
        System.out.println(expectedLower == auctioneer.getLowestBid());

    }
}
