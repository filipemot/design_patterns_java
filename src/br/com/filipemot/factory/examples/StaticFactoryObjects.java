package br.com.filipemot.factory.examples;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.stream.Stream;

public class StaticFactoryObjects {
    public static void main(String[] args){
        System.out.println(Calendar.getInstance());
        System.out.println(NumberFormat.getInstance());
        System.out.println(Stream.of(1,2,3,4));
        System.out.println(Integer.valueOf("1234"));
    }
}
