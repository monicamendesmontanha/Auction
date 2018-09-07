package auction;

public class AuctionBuilder {


    private Auction auction;

    public AuctionBuilder to(String description) {
        this.auction = new Auction(description);
        return this;
    }

    public AuctionBuilder bid(User user, double value) {
        auction.proposes(new Bid(user, value));
        return this;
    }

    public Auction builds() {
        return auction;
    }
}
