package auction;

public class CreatorOfAuction {


    private Auction auction;

    public CreatorOfAuction to(String description) {
        this.auction = new Auction(description);
        return this;
    }

    public CreatorOfAuction bid(User user, double value) {
        auction.proposes(new Bid(user, value));
        return this;
    }

    public Auction builds() {
        return auction;
    }
}
