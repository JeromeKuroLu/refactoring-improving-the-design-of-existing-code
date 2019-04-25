package chapter01.ver01;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
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
        String result = "Rental Record for " + getName() + System.getProperty("line.separator");
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement(); // 取得一笔租借记。
            // determine amounts for each line
            double thisAmount;
            thisAmount = each.getAmount();
            frequentRenterPoints = each.getFrequentRenterPoints(frequentRenterPoints);
            // show figures for this rental（显示此笔租借记录）
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        // add footer lines（结尾打印）
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints
                + " frequent renter points";
        return result;
    }

}
