package utilities;

/**
 * Contains filter class for pa4.
 * 
 * @author Sam Patterson
 * @version 10/19/2021
 *
 */
public class ContainsFilter implements StringFilter {
    private String container;
    private boolean shouldIgnoreCase;

    /**
     * Constructor.
     * 
     * @param container does things
     * @param shouldIgnoreCase does things
     */
    public ContainsFilter(String container, boolean shouldIgnoreCase) {
        this.container = container;
        this.shouldIgnoreCase = shouldIgnoreCase;
    }

    @Override
    public boolean shouldPassThrough(String candidate) {
        boolean result = false;
        if (container == null) {
            return false;
        }

        if (shouldIgnoreCase
                && container.toLowerCase().contains(candidate.toLowerCase())) {
            result = true;
        }

        if (!shouldIgnoreCase && container.contains(candidate)) {
            result = true;
        }
        return result;
    }

}
