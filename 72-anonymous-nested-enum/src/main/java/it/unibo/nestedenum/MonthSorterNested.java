package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    public enum Month {
        JANUARY(31), FEBRUARY(28), MARCH(31), APRIL(30), MAY(31), JUNE(30),
        JULY(31), AUGUST(31), SEPTEMBER(30), OCTOBER(31), NOVEMBER(30), DECEMBER(31);

        private final int days;

        private Month(final int days) {
            this.days = days;
        }

        public int getDays() {
            return this.days;
        }

        public static Month fromString(String monthName) {
            Month found = JANUARY;
            int numMatches = 0;
            for (Month month : Month.values()) {
                if (
                    month.toString().equalsIgnoreCase(monthName) || 
                    month.toString().regionMatches(true, 0, monthName, 0, monthName.length())
                ) {
                    numMatches++;
                    found = month;
                }
            }

            if (numMatches == 1) {
                return found;
            } else {
                throw new IllegalArgumentException("Month not found"); 
            }
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {
            @Override
            public int compare(String monthName1, String monthName2) {
                int daysMonth1 = Month.fromString(monthName1).getDays();
                int daysMonth2 = Month.fromString(monthName2).getDays();

                if (daysMonth1 > daysMonth2) {
                    return 1;
                } else if (daysMonth1 < daysMonth2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {
            @Override
            public int compare(String monthName1, String monthName2) {
                int daysMonth1 = Month.fromString(monthName1).ordinal();
                int daysMonth2 = Month.fromString(monthName2).ordinal();

                if (daysMonth1 >  daysMonth2) {
                    return 1;
                } else if (daysMonth1 < daysMonth2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
    }
}
