package utilities;

/**
 * Equals filter class for pa4.
 * 
 * @author Sam Patterson
 * @version 10/19/2021
 */
public class EqualsFilter implements StringFilter {
    private String target;

    /**
     * Constructor.
     * 
     * @param target does things
     */
    public EqualsFilter(String target) {
        this.target = target;
    }

    @Override
    public boolean shouldPassThrough(String candidate) {
        boolean result = false;
        if (target == null) {
            return false;
        }

        if (target.equals(candidate)) {
            result = true;
        }

        return result;
    }
}
