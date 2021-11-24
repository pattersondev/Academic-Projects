package signz.product;

import java.awt.Color;
import java.util.StringTokenizer;

/**
 * Itemized product class for pa4.
 * 
 * @author Sam Patterson
 * @version 10/19/2021
 */
public class ItemizedProduct extends AbstractProduct {
    private double dollarAmount;
    private int quantityAvailable;
    private int quantityPer;
    private String priceBasis;
    private Color color;

    /**
     * Implicit value constructor.
     */
    protected ItemizedProduct() {
        color = Color.BLUE;
    }

    /**
     * Explicit value constructor.
     * 
     * @param productNumber does things
     * @param description does things
     * @param quantityAvailable does things
     * @param dollarAmount does things
     * @param quantityPer does things
     * @param priceBasis does things
     */
    public ItemizedProduct(int productNumber, String description,
            int quantityAvailable, double dollarAmount, int quantityPer,
            String priceBasis) {
        super(productNumber, Color.BLUE, description);
        this.dollarAmount = dollarAmount;
        this.quantityAvailable = quantityAvailable;
        this.quantityPer = quantityPer;
        this.priceBasis = priceBasis;
    }

    /**
     * Adjusts available quantity.
     * 
     * @param amount to change by
     */
    public void changeQuantityAvailable(int amount) {
        quantityAvailable += amount;
        if (quantityAvailable < 0) {
            quantityAvailable = 0;
        }
    }

    /**
     * Formats string representation of object.
     * 
     * @param s string to format
     * 
     * @return tokenizer
     */
    @Override
    protected StringTokenizer fromString(String s) {
        super.fromString(s);
        StringTokenizer use = new StringTokenizer(s, ",");
        quantityAvailable = Integer.parseInt(use.nextToken());
        dollarAmount = Double.parseDouble(use.nextToken());
        quantityPer = Integer.parseInt(use.nextToken());
        priceBasis = use.nextToken();
        return use;
    }

    @Override
    protected String getPriceDescription() {
        if (quantityPer == 1) {
            return formatPrice(dollarAmount) + String.format(" %s", priceBasis);
        }

        return formatPrice(dollarAmount)
                + String.format("for %2d %s", quantityPer, priceBasis);
    }

    @Override
    public boolean isAvailable() {
        return quantityAvailable > 0;
    }

    /**
     * Creates an itemized product from a string.
     * 
     * @param s string to convert
     * @return itemized product
     */
    public static ItemizedProduct parseItemizedProduct(String s) {
        ItemizedProduct result = new ItemizedProduct();
        result.fromString(s);
        return result;
    }
}
