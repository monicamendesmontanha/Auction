package auction;

public class AppraiserTest {

    public static void main(String[] args) {
        User dan = new User("Dan");
        User july = new User("July");
        User rapha = new User("Rapha");

        Auction auction = new Auction("Playstation 4");

        auction.proposes(new Bid(dan, 300.0));
        auction.proposes(new Bid(july, 400.0));
        auction.proposes(new Bid(rapha, 500.0));

        Appraiser auctioneer = new Appraiser();
        auctioneer.evaluates (auction);

        System.out.println(auctioneer.getHigherBid());
    }
}
