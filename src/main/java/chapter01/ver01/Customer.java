package chapter01.ver01;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private static final String PRE_AMOUNT_LOG_STR = "Amount owed is ";

    private static final String PRE_FRE_RENT_POINT_LOG_STR = "You earned ";

    private static final String POST_AMOUNT_LOG_STR = System.getProperty("line.separator");

    private static final String POST_FRE_RENT_POINT_LOG_STR = " frequent renter points";

    private String name; // 姓名

    private Vector rentals = new Vector(); // 租借记

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0; // 总消费金。
        int frequentRenterPoints = 0; // 常客积点
        StringBuilder result =
                new StringBuilder("Rental Record for " + getName() + System.getProperty("line.separator"));
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement(); // 取得一笔租借记。
            // determine amounts for each line
            double thisAmount;
            thisAmount = each.getAmount();
            frequentRenterPoints = each.getFrequentRenterPoints(frequentRenterPoints);
            // show figures for this rental（显示此笔租借记录）
            result.append(each.printRentalRecord(thisAmount));
            totalAmount += thisAmount;
        }
        // add footer lines（结尾打印）
        result.append(printLog(totalAmount, PRE_AMOUNT_LOG_STR, POST_AMOUNT_LOG_STR))
                .append(printLog(frequentRenterPoints, PRE_FRE_RENT_POINT_LOG_STR, POST_FRE_RENT_POINT_LOG_STR));
        return result.toString();
    }

    private String printLog(double value, String preStr, String postStr) {
        return preStr + value + postStr;
    }

}
