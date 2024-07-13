package Model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class QlyDiem {
    private String  maSV;
    private String  HoTen;
    private double tiengAnh;
    private double  tinHoc;
    private double  GDTC;

    public QlyDiem() {
    }

    public QlyDiem(String maSV, String HoTen, double tiengAnh, double tinHoc, double GDTC) {
        this.maSV = maSV;
        this.HoTen = HoTen;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.GDTC = GDTC;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public double getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(double tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public double getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(double tinHoc) {
        this.tinHoc = tinHoc;
    }

    public double getGDTC() {
        return GDTC;
    }

    public void setGDTC(double GDTC) {
        this.GDTC = GDTC;
    }
    

    public double getDiemTB() {
        double diemTB = (tiengAnh + tinHoc + GDTC) / 3;
        double diemTBTron = Math.round(diemTB * 100) / 100.0;
        return diemTBTron;
    }
    public Object[] dataRow(){
        return new Object[]{
          maSV,HoTen,tiengAnh,tinHoc,GDTC,getDiemTB()
        };
    }

}
