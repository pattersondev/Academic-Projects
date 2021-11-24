package signz;

import java.awt.Color;

/**
 * Displayable interface for pa4.
 * 
 * @author Sam Patterson
 * @version 10/19/2021
 */
public interface Displayable {
    /**
     * Getter for alignment.
     * 
     * @return alignment
     */
    int getAlignment();

    /**
     * Getter for color.
     * 
     * @return color
     */
    Color getColor();

    /**
     * Getter for size.
     * 
     * @return size
     */
    int getSize();

    /**
     * Getter for style.
     * 
     * @return style
     */
    int getStyle();

    /**
     * Getter for text.
     * 
     * @return text
     */
    String getText();
}
