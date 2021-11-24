package signz;

import utilities.StringFilter;

/**
 * Filtering Show List class for pa3.
 * 
 * @author Sam Patterson
 * @version 9/29/2021
 *
 */
public class FilteringShowList extends ShowList implements StringFilter {
    private int size;
    private StringFilter filter;

    /**
     * Constructor filtering show list.
     * 
     * @param signages of thing
     * @param name of thing
     * @param filter thing
     */
    public FilteringShowList(Signage[] signages, String name,
            StringFilter filter) {
        super(signages, name);
        this.filter = filter;

        this.size = 0;
        for (int i = 0; i < signages.length; i++) {
            if (shouldPassThrough(signages[i].getCategory())) {
                this.size++;
            }
        }

    }

    @Override
    public Signage getNext() {
        Signage result;
        if (filter == null) {
            return null;
        }
        do {
            result = super.getNext();
        } while (result != null && !shouldPassThrough(result.getCategory()));

        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean shouldPassThrough(String candidate) {
        if (filter == null) {
            return false;
        }

        return filter.shouldPassThrough(candidate);
    }
}
