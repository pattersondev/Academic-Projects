package signz.product;

import java.awt.Color;
import java.awt.Font;
import java.util.StringTokenizer;

import javax.swing.SwingConstants;

import signz.Displayable;

/**
 * Abstract product class for pa4.
 * 
 * @author Sam Patterson
 * @version 10/19/2021
 */
public abstract class AbstractProduct implements Displayable {
    private static final String PRICE_FORMAT = "$%6.2f";
    private Color color;
    private int fieldWidth;
    private int alignment;
    private int fontSize;
    private int productNumber;
    private int style;
    private String description;

    /**
     * Implicit value constructor.
     */
    protected AbstractProduct() {
        this.fieldWidth = 6;
        this.fontSize = 24;
        this.alignment = SwingConstants.LEFT;
        this.color = Color.GREEN;
        this.style = Font.BOLD;
    }

    /**
     * Explicit value constructor.
     * 
     * @param productNumber of product
     * @param color of product
     * @param description of product
     */
    protected AbstractProduct(int productNumber, Color color,
            String description) {
        this();
        this.productNumber = productNumber;
        this.description = description;
        this.color = color;
    }

    @Override
    public int getAlignment() {
        return alignment;
    }

    @Override
    public Color getColor() {
        // TODO Auto-generated method stub
        return color;
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return fontSize;
    }

    @Override
    public int getStyle() {
        // TODO Auto-generated method stub
        return style;
    }

    @Override
    public String getText() {
        if (isAvailable()) {
            return description + " " + getPriceDescription();
        }
        return description + " " + getPriceDescription() + " " + "(Rain Check)";
    }

    /**
     * Formats the price.
     * 
     * @param price to format
     * @return formatted price
     */
    protected String formatPrice(double price) {
        return String.format(PRICE_FORMAT, price);
    }

    /**
     * Formats a string representation.
     * 
     * @param s to format
     * @return string tokenizer
     */
    protected StringTokenizer fromString(String s) {
        StringTokenizer thing = new StringTokenizer(s, ",");
        productNumber = Integer.parseInt(thing.nextToken());
        description = thing.nextToken().toString();
        return thing;
    }

    public int getProductNumber() {
        return productNumber;
    }

    /**
     * Getter for price description.
     * 
     * @return price description
     */
    protected abstract String getPriceDescription();

    /**
     * Checks if item is available.
     * 
     * @return boolean
     */
    public abstract boolean isAvailable();
}
