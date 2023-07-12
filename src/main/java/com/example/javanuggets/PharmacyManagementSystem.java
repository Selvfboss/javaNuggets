package com.example.javanuggets;


import java.io.*;
import java.sql.*;
import java.util.*;



public class PharmacyManagementSystem {
    private Connection connection;
    private HashMap<Integer, Drug> drugs;
    private HashMap<Integer, Supplier> suppliers;
    private HashMap<Integer, Buyer> buyers;
    private ArrayList<Purchase> purchaseHistory;

    public PharmacyManagementSystem() {
        drugs = new HashMap<>();
        suppliers = new HashMap<>();
        buyers = new HashMap<>();
        purchaseHistory = new ArrayList<>();
    }

    //Function to search supplier by location
    public void searchSupplierByLocation(String location) {
        List<Integer> supplierId = new ArrayList<>();

        for (Supplier supplier : suppliers.values()) {
            if (supplier.getLocation().equalsIgnoreCase(location)) {
                supplierId.add(supplier.getId());
            }
        }

        for(int i = 0; i < supplierId.size(); i++){
            System.out.println(supplierId.get(i));
        }
    }

    //Function to add supplier to the hashtable
    public void addSupplier(String name, String contactNumber, String location, String email) {
        Supplier supplier = new Supplier(name, contactNumber, location, email);
        int supplierID = supplier.getId();
        suppliers.put(supplierID, supplier);
    }


    // Database connection setup
    public void connectToDatabase(String url, String username, String password) throws SQLException {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database Connected Successfully");
        } catch (SQLException error) {
            System.out.println(error);
        }
    }

}
