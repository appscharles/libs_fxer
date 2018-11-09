package com.appscharles.libs.fxer.counters;

/**
 * The type Items page counter.
 */
public class ItemsPageCounter {

    /**
     * Count long.
     *
     * @param items        the items
     * @param itemsPerPage the items per page
     * @return the long
     */
    public Integer count(Long items, Integer itemsPerPage) {
        if (items.intValue() == itemsPerPage){
            return 1;
        }
        return ((Long)((items / itemsPerPage) + 1)).intValue();
    }
}
