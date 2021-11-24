package signz.text;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * Formatted Text class for PA3.
 * 
 * @author Sam Patterson
 * @version 9/29/2021
 *
 */
public class FormattedText implements signz.Displayable {
    private Color color;
    private int alignment;
    private int size;
    private int style;
    private String text;

    /**
     * Five parameter construct for Formatted text object.
     * 
     * @param text to write
     * @param color of text
     * @param style of text
     * @param size of text
     * @param alignment of text
     */
    public FormattedText(String text, Color color, int style, int size,
            int alignment) {
        this.text = text;
        this.color = color;
        this.style = style;
        this.size = size;
        this.alignment = alignment;
    }

    /**
     * Default value constructor.
     * 
     * @param text to write
     */
    public FormattedText(String text) {
        this(text, Color.BLACK, Font.PLAIN, 24, SwingConstants.CENTER);
    }

    public int getAlignment() {
        return alignment;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public int getStyle() {
        return style;
    }

    public String getText() {
        return text;
    }

}
