
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class PhieuNhap {
    private String maPhieuNhap;
    private String maNhaCungCap;
    private double tongTien;
    private String ngayLapPhieuNhap;
    private String status ;
    private NhaCungCap ncc = new NhaCungCap();
    Scanner sc = new Scanner(System.in);

    // constructor
    public PhieuNhap() {}

    public PhieuNhap(String maPhieuNhap, String maNhaCungCap, double tongTien, String ngayLapPhieuNhap, String status) {
        this.maPhieuNhap = maPhieuNhap;
        this.maNhaCungCap = maNhaCungCap;
        this.tongTien = tongTien;
        this.ngayLapPhieuNhap = ngayLapPhieuNhap;
        this.status = status;
    }
    public void nhap(){
        // System.out.println("Nhap ma phieu nhap: ");
        // this.maPhieuNhap = sc.nextLine();
        System.out.println("Nhap ma nha cung cap: ");
        this.maNhaCungCap = ncc.getMaNhaCungCap();
        // System.out.println("Nhap so luong: ");
        // this.tongSoLuong = Integer.parseInt(sc.nextLine());
        // System.out.println("Nhap tong tien: ");
        // this.tongTien =  Double.parseDouble(sc.nextLine());
        System.out.println("Ngay lap phieu");
        this.ngayLapPhieuNhap =  sc.nextLine();
    }
    public void xuat(){
        System.out.println(maPhieuNhap+"\t\t"+maNhaCungCap+"\t\t"+tongTien+"\t\t"+ngayLapPhieuNhap);
    }
    public String toString(){
        return maPhieuNhap+", "+maNhaCungCap+", "+tongTien+", "+ngayLapPhieuNhap+", "+status;
    }
    public void xoa(){
        this.status = "0";
    }
    
    /// getter
    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }
    public Double getTongTien() {
        return this.tongTien;
    }
    public String getNgayLapPhieu(){
        return this.ngayLapPhieuNhap;
    }
    public String getStatus() {
        return status;
    }
    ///setter
    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public void setTongTien(double tongtien){
        this.tongTien = tongtien;
    }
    public void setNgayLapPhieu(String ngaylapphieu){
        this.ngayLapPhieuNhap = ngaylapphieu;
    }
}
