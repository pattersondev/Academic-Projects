/**
 * Weighted product class for pa4.
 * 
 * @author Sam Patterson
 * @version 10/19/2021
 */

package signz.product;

import java.awt.Color;
import java.util.StringTokenizer;

/**
 * Weighted Product class.
 * 
 * @author Sam Patterson
 * @version 10/19/2021
 */
public class WeighedProduct extends AbstractProduct {
    private double dollarsPerOunce;
    private double ouncesAvailable;

    /**
     * Zero parameter constructor.
     */
    protected WeighedProduct() {
        super.getColor();
    }

    /**
     * Multiple value constructor.
     * 
     * @param productNumber of product
     * @param description of product
     * @param ouncesAvailable of product
     * @param dollarsPerOunce of product
     */
    public WeighedProduct(int productNumber, String description,
            double ouncesAvailable, double dollarsPerOunce) {
        super(productNumber, Color.GREEN, description);

        this.dollarsPerOunce = dollarsPerOunce;
        this.ouncesAvailable = ouncesAvailable;
    }

    /**
     * Changes the amount of ounces available.
     * 
     * @param amount to change by
     */
    public void changeOuncesAvailable(double amount) {
        ouncesAvailable += amount;
        if (ouncesAvailable < 0) {
            ouncesAvailable = 0;
        }
    }

    /**
     * Takes in a string representation of an object and formats it.
     * 
     * @param s is a string
     * @return the tokenizer
     */
    protected StringTokenizer fromString(String s) {
        super.fromString(s);
        StringTokenizer use = new StringTokenizer(s, ",");
        dollarsPerOunce = Double.parseDouble(use.nextToken());
        ouncesAvailable = Double.parseDouble(use.nextToken());
        return use;
    }

    @Override
    protected String getPriceDescription() {
        return formatPrice(dollarsPerOunce) + " per ounce";
    }

    @Override
    public boolean isAvailable() {
        return ouncesAvailable >= 1;
    }

    /**
     * Creates an object from a string.
     * 
     * @param s to create object from
     * @return new object
     */
    public static WeighedProduct parseWeighedProduct(String s) {
        WeighedProduct result = new WeighedProduct();
        result.fromString(s);
        return result;
    }

}
