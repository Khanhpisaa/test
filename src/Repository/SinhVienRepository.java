package Repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import DAO.DBContext;
import Model.SinhVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class SinhVienRepository {
    private Connection conn;

    public SinhVienRepository() {
        try {
            this.conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<SinhVien> fillAll(){
        ArrayList<SinhVien> listSV = new ArrayList<>();
            try {
                String sql = "SELECT * FROM STUDENTS";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                String ma = rs.getString("masv");
                String ten = rs.getString("hoten");
                String email = rs.getString("Email");
                String sdt = rs.getString("sdt");
                int gioiTinh = rs.getInt("gioitinh");
                String diaChi = rs.getString("diachi");
                
                SinhVien sv = new SinhVien(ma, ten, email, gioiTinh, sdt, diaChi);
                listSV.add(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return listSV;
    }
    public void create(SinhVien sv)
    {
        String sql = "INSERT INTO STUDENTS (masv,hoten,gioitinh,sdt,diachi,Email) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, sv.getMaSV());
            ps.setString(2, sv.getHoTen());
            ps.setInt(3, sv.getGioiTinh());
            ps.setString(4, sv.getSĐT());
            ps.setString(5, sv.getDiaChi());
            ps.setString(6, sv.getEmail());
            
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(SinhVien sv)
    {
        String sql = "update STUDENTS set hoten = ?, Email = ?,sdt = ?,gioitinh = ?,diachi = ? where masv = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
         
            ps.setString(1, sv.getHoTen());
            ps.setString(2, sv.getEmail());
            ps.setString(3, sv.getSĐT());
            ps.setInt(4, sv.getGioiTinh());
            ps.setString(5, sv.getDiaChi());
            ps.setString(6, sv.getMaSV());
            
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    public void delelte(String ma)
    {
        String sql = "DELETE FROM STUDENTS WHERE masv = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}    
