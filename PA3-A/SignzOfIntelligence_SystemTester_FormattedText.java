import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * A main class that can be used to test SignzOfIntelligence using FormattedText
 * objects.
 * 
 * @author Ann E. Koder, MarkItz
 * @version PA3
 */
public class SignzOfIntelligence_SystemTester_FormattedText {
    private static final Color GOLD = new Color(0xAD, 0x9C, 0x65);
    private static final Color PURPLE = new Color(0x45, 0x00, 0x84);
    private static final int LARGE = 24;
    private static final int SMALL = 18;

    /**
     * The entry point of the application.
     * 
     * @param args The command-line arguments (which are ignored)
     */
    public static void main(String[] args) {
        FormattedText[] lines;
        Sign eastDoor;
        Sign expressCheckout;
        Signage[] signages;
        ShowList checkout;
        ShowList door;

        if (args == null || args.length != 2) {
            System.out.println(
                    "Required command-line arguments: "
                    + "ShowList|FilteringShowList and Checkout|Door");
            System.exit(1);
        }

        signages = new Signage[3];

        // signage[0]
        lines = new FormattedText[1];
        lines[0] = new FormattedText("Welcome to Madison's Grocery", PURPLE,
                Font.ITALIC, LARGE, SwingConstants.CENTER);
        signages[0] = new Signage("Welcome", "In", lines);

        // signage[1]
        lines = new FormattedText[5];
        lines[0] = new FormattedText(
                "We accept the following forms of payment:");
        lines[1] = new FormattedText("JACard", GOLD, Font.PLAIN, SMALL,
                SwingConstants.CENTER);
        lines[2] = new FormattedText("Cash", GOLD, Font.PLAIN, SMALL,
                SwingConstants.CENTER);
        lines[3] = new FormattedText("Major Credit/Debit Cards", GOLD,
                Font.PLAIN, SMALL, SwingConstants.CENTER);
        lines[4] = new FormattedText("ApplePay and GooglePay", GOLD, Font.PLAIN,
                SMALL, SwingConstants.CENTER);
        signages[1] = new Signage("Payments", "InOut", lines);

        // signage[2]
        lines = new FormattedText[2];
        lines[0] = new FormattedText("Do you have your own bags?");
        lines[1] = new FormattedText(
                "If not, would you like paper or plastic?");
        signages[2] = new Signage("Bags", "Out", lines);

        checkout = null;
        door = null;
        if (args[0].equalsIgnoreCase("ShowList")) {
            checkout = new ShowList(signages, "Checkout");
            door = new ShowList(signages, "Door");
        } else if (args[0].equalsIgnoreCase("FilteringShowList")) {
            checkout = new FilteringShowList(signages, "Checkout", "Out");
            door = new FilteringShowList(signages, "Door", "In");
        }

        if (args[1].equalsIgnoreCase("Checkout") && checkout != null) {
            expressCheckout = new Sign(checkout, "Express Checkout");
            expressCheckout.setVisible(true);
        } else if (args[1].equalsIgnoreCase("Door") && door != null) {
            eastDoor = new Sign(door, "East Door");
            eastDoor.setVisible(true);
        }

    }
}
