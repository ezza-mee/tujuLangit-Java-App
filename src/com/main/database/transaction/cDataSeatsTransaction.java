package com.main.database.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.main.database.cConnectionDatabase;

public class cDataSeatsTransaction {
    public static ArrayList<String> getNumberSeats() {
        ArrayList<String> numberSeatsList = new ArrayList<>(); 
        String query = "SELECT numberSeats FROM tbl_seats";
        try (Connection conn = cConnectionDatabase.getConnection();
                PreparedStatement state = conn.prepareStatement(query)) {

            ResultSet resultData = state.executeQuery();

            while (resultData.next()) {
                numberSeatsList.add(String.valueOf(resultData.getInt("numberSeats"))); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberSeatsList; 
    }

}
