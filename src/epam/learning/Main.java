package epam.learning;

import epam.learning.ex1.Directory;
import epam.learning.ex1.TextFile;
import epam.learning.ex2.Payment;
import epam.learning.ex3.HolidayCalendar;

public class Main {

    public static void main(String[] args) {

//        Directory directory = new Directory("D:\\testDirectory");
//
//        TextFile textFile1 = new TextFile("D:\\testDirectory\\first.txt");
//
//        TextFile textFile2 = new TextFile("D:\\testDirectory", "second.nnn");
//
//        TextFile textFile3 = new TextFile("D:\\testDirectory", "third.doc");
//
//        textFile1.append("Hello friend!");
//        textFile1.append("Nice to meet you");
//
//        textFile1.renameTo("newFirst.doc");
//
//        textFile1.delete();
//
//        textFile1.renameTo("superFirst.txt");

        Payment payment = new Payment();

        Payment.Product product1 =  payment.new Product("iPhone X", 500, "smartphone");
        Payment.Product product2 =  payment.new Product("Samsung S20", 400, "smartphone");
        Payment.Product product3 =  payment.new Product("Samsung S20", 400, "smartphone");
        Payment.Product product4 =  payment.new Product("Samsung S20", 400, "smartphone");
        Payment.Product product5 =  payment.new Product("Samsung S21", 1500, "smartphone");

        product1.add();
        product2.add();
        product3.add();
        product4.add();
        product5.add();

        payment.print();

        System.out.println("__________");

        product1.remove();
        product2.remove();
        payment.print();

        System.out.println("__________");


        HolidayCalendar hc = new HolidayCalendar();

        HolidayCalendar.OffDay offDay1 = hc.new OffDay(2021, 9, 19);
        HolidayCalendar.OffDay offDay2 = hc.new OffDay(1992, 2, 29);
        HolidayCalendar.OffDay offDay3 = hc.new OffDay(2000, 5, 1);
        HolidayCalendar.OffDay offDay4 = hc.new OffDay(2021, 9, 22);
        HolidayCalendar.OffDay offDay5 = hc.new OffDay( 9, 24);

        offDay1.add();
        offDay2.add();
        offDay3.add();
        offDay4.add();
        offDay5.add();

        hc.print();


        offDay2.writeDescription("It's my birthday");

        hc.print();

        offDay5.check();



    }
}


