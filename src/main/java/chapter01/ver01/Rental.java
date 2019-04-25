package chapter01.ver01;

public class Rental {
    private Movie movie; // 影片
    private int daysRented; // 租期

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getAmount() {
        double thisAmount = 0;
        switch (getMovie().getPriceCode()) { // 取得影片出租价格
            case Movie.REGULAR: // 普通片
                thisAmount += 2;
                if (getDaysRented() > 2)
                    thisAmount += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE: // 新片
                thisAmount += getDaysRented() * 3;
                break;
            case Movie.CHILDREN: // 儿童。
                thisAmount += 1.5;
                if (getDaysRented() > 3)
                    thisAmount += (getDaysRented() - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    int getFrequentRenterPoints(int frequentRenterPoints) {
        // add frequent renter points （累计常客积点。
        frequentRenterPoints++;
        // add bonus for a two day new release rental
        if ((getMovie().getPriceCode() == Movie.NEW_RELEASE)
                && getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

    String printRentalRecord(double price) {
        return "\t" + getMovie().getTitle() + "\t"
                + price + "\n";
    }
}
