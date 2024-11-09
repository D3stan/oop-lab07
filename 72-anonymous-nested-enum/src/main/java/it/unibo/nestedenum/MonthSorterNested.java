package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    public enum Month {
        JANUARY(31, "january"), 
        FEBRUARY(28, "february"), 
        MARCH(31, "march"), 
        APRIL(30, "april"), 
        MAY(31, "May"), 
        JUNE(30, "June"),
        JULY(31, "July"), 
        AUGUST(31, "August"), 
        SEPTEMBER(30, "September"), 
        OCTOBER(31, "October"), 
        NOVEMBER(30, "November"), 
        DECEMBER(31, "December");


        private final int days;
        private final String name;

        private Month(final int days, final String name) {
            this.days = days;
            this.name = name;
        }

        public int getDays() {
            return this.days;
        }

        public Month fromString(String month) {
            JANUARY.name();
            return JANUARY;
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }
}
