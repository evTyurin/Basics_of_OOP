package epam.learning.ex3;

public enum Holiday {

    LABOR_DAY (5, 1),
    CRISTMAS (12, 25);

    private final int month;
    private final int dayOfMonth;

    Holiday (int month, int dayOfMonth) {
        this.month = month;
        this.dayOfMonth = dayOfMonth;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public int getMonth() {
        return month;
    }

}

