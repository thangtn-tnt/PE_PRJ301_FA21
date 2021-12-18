/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BEAN.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trương Nhựt Thăng
 */
public class StaffDAO {

    //Insert new Staff
    public static boolean insert(Connection conn, String id, String name, String phone, String date) {
        String sql = "insert into STAFF values (?,?,?,?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, phone);
            ps.setString(4, date);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
        }
        return false;
    }

    //Show all Staff List
    public static List<Staff> show(Connection conn) {
        List<Staff> list = new ArrayList<>();
        String query = "Select * from STAFF";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Staff(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
            return list;
        } catch (SQLException e) {
        }
        return null;
    }

    //Delete by ID
    public static void delete(Connection conn, String id) {
        String sql = "DELETE FROM STAFF\n"
                + "      WHERE IDStaff = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
