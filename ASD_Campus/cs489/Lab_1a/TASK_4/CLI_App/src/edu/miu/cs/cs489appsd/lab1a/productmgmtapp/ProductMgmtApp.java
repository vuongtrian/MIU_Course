package edu.miu.cs.cs489appsd.lab1a.productmgmtapp;

import edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model.Product;

import java.time.LocalDate;
import java.util.Arrays;

public class ProductMgmtApp {
    public static void main(String[] args) {
        Product[] products = new Product[] {
                new Product(3128874119L, "Banana", LocalDate.of(2023, 01, 24), 124, 0.55D),
                new Product(2927458265L, "Apple", LocalDate.of(2022, 12, 9), 18, 1.09D),
                new Product(9189927460L, "Carrot", LocalDate.of(2023, 03, 31), 89, 2.99D),
        };

        printProducts(products);

    }

    public static void printProducts (Product[] products) {
        Arrays.sort(products);
        printJSON(products);
        System.out.println("------------------");
        printXML(products);
        System.out.println("------------------");
        printCSV(products);
    }

    public static void printJSON (Product[] products) {
        System.out.println("Printed in JSON Format");
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (Product p : products) {
            sb.append("\t{ ").append(p.toString()).append(" },\n");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void printXML (Product[] products) {
        System.out.println("Printed in XML Format");
        System.out.println("<?xml version=\"1.0\"?>");
        StringBuilder sb = new StringBuilder();
        sb.append("<products>\n");
        for(Product p : products) {
            sb.append("\t<product ").append(p.toString()).append(" />\n");
        }
        sb.append("</products>");
        System.out.println(sb.toString());
    }

    public static void printCSV (Product[] products) {
        System.out.println("Printed in Comma-Separated Value(CSV) Format");
        StringBuilder sb = new StringBuilder();
        for(Product p : products) {
            sb.append(p.getProductId())
                    .append(", ").append(p.getName())
                    .append(", ").append(p.getDateSupplied())
                    .append(", ").append(p.getQuantityInStock())
                    .append(", ").append(p.getUnitPrice())
                    .append("\n");
        }
        System.out.println(sb.toString());
    }
}
