package epam.learning.ex3;

import java.time.LocalDate;
import java.time.DayOfWeek;

import java.util.ArrayList;
import java.util.EnumSet;

public class HolidayCalendar {

    private ArrayList<OffDay> offDayArrayList;
    private EnumSet <Holiday> holidayEnumSet;

    public ArrayList<OffDay> getOffDayArrayList() {
        return offDayArrayList;
    }

    public EnumSet<Holiday> getHolidayEnumSet() {
        return holidayEnumSet;
    }

    public void setOffDayArrayList(ArrayList<OffDay> offDayArrayList) {
        this.offDayArrayList = offDayArrayList;
    }

    public HolidayCalendar () {

        offDayArrayList = new ArrayList<>();
        holidayEnumSet = EnumSet.allOf(Holiday.class);

    }

    public void print () {
        for (OffDay offDay : offDayArrayList) {
            if (offDay.year != 0) {
                System.out.println("Year = " + offDay.year);
            }
            System.out.println("Month = " + offDay.month);
            System.out.println("Day of month = " + offDay.dayOfMonth);
            if (offDay.description.length() != 0) {
                System.out.println("Information about this day");
                System.out.println(offDay.description.toString());
            }
        }
    }

    public class OffDay {

        private int year;
        private int month;
        private int dayOfMonth;
        private boolean isOffDay;
        private StringBuilder description;

        public OffDay(int year, int month, int dayOfMonth){

            this.year = year;
            this.month = month;
            this.dayOfMonth = dayOfMonth;
            this.isOffDay = check();
            this.description = new StringBuilder();

        }

        public OffDay(int month, int dayOfMonth){

            this.month = month;
            this.dayOfMonth = dayOfMonth;
            this.isOffDay = check();
            this.description = new StringBuilder();
            this.year = LocalDate.now().getYear();

        }

        public int getDayOfMonth() {
            return dayOfMonth;
        }

        public int getMonth() {
            return month;
        }

        public int getYear() {
            return year;
        }

        public StringBuilder getDescription() {
            return description;
        }

        public void setDayOfMonth(int dayOfMonth) {
            this.dayOfMonth = dayOfMonth;
        }

        public void setDescription(StringBuilder description) {
            this.description = description;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public void setOffDay(boolean offDay) {
            isOffDay = offDay;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public boolean check () {

            LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
            if (localDate.getDayOfWeek() == DayOfWeek.SATURDAY || localDate.getDayOfWeek() == DayOfWeek.SUNDAY ) {
                return true;
            }

            for (Holiday holiday: holidayEnumSet) {
                if (holiday.getDayOfMonth() == dayOfMonth && holiday.getMonth() == month ) {
                    return true;
                }
            }

            return false;
        }


        public void add () {
            if (isOffDay) {
                HolidayCalendar.this.offDayArrayList.add(this);
            } else {
                System.out.println("this day is not an off day");
            }

        }

        public void writeDescription (String description) {
            this.description.replace(0, description.length(), "");
            this.description.append(description);
        }

        public void appendDescription (String description) {
            this.description.append(description);
        }
    }
}

