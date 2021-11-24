package utilities;

/**
 * String filter interface for pa4.
 * 
 * @author Sam Patterson
 * @version 10/19/2021
 */
public interface StringFilter {
    /**
     * Checks if string should pass.
     * 
     * @param candidate string to check
     * @return boolean
     */
    boolean shouldPassThrough(String candidate);
}
