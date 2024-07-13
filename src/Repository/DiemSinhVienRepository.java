package Repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import DAO.DBContext;
import Model.QlyDiem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class DiemSinhVienRepository {
    private Connection conn;
    public DiemSinhVienRepository(){
        try {
            this.conn = DBContext.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<QlyDiem> fillAll(){
        ArrayList<QlyDiem> listDSV = new ArrayList<>();
            try {
           String sql = " SELECT top 3 masv, hoTen, tienganh, tinhoc, gdtc, ROUND((tienganh + tinhoc + gdtc) / 3.0, 2) AS diemTB FROM GRADE ORDER BY diemTB DESC";
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
         
                while (rs.next()) {
                    String ma = rs.getString("masv");
                    String ten = rs.getString("hoTen");
                    int ta = rs.getInt("tienganh");
                    int th = rs.getInt("tinhoc");
                    int gdtc = rs.getInt("gdtc");
                    QlyDiem qlD = new QlyDiem(ma, ten, ta, th, gdtc);
                    listDSV.add(qlD);
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    return listDSV;
    }
    public void insert(QlyDiem qlD){
        String sql = "insert into GRADE (masv,hoTen,tienganh,tinhoc,gdtc) values (?,?,?,?,?)";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, qlD.getMaSV());
                ps.setString(2, qlD.getHoTen());
                ps.setDouble(3, qlD.getTiengAnh());
                ps.setDouble(4, qlD.getTinHoc());
                ps.setDouble(5, qlD.getGDTC());
                ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delelte(String ma)
    {
        String sql = "DELETE FROM GRADE WHERE masv = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ma);
            ps.execute();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void update(QlyDiem qlD)
    {
        String sql = "update GRADE set  hoTen = ?, tienganh = ?, tinhoc = ?, gdtc = ? where masv = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, qlD.getHoTen());
            ps.setDouble(2, qlD.getTiengAnh());
            ps.setDouble(3, qlD.getTinHoc());
            ps.setDouble(4, qlD.getGDTC());
            ps.setString(5, qlD.getMaSV());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
