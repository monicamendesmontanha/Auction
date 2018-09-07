package auction;

import java.util.Objects;

public class Bid {

    private User user;
    private double value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bid bid = (Bid) o;
        return Double.compare(bid.value, value) == 0 &&
                Objects.equals(user, bid.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, value);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public Bid(User user, double value) {
        this.user = user;
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public double getValue() {
        return value;
    }

}
