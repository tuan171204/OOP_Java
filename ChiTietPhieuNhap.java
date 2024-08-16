import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.Scanner;
public class ChiTietPhieuNhap {
    private String maPhieuNhap;
    private String maSanPham;
    private int soLuong;
    private double donGia;
    private double thanhTien ;
    private String status;
     Scanner scanner = new Scanner(System.in);
   // constructor
    public ChiTietPhieuNhap(){}
    public ChiTietPhieuNhap(String maPhieuNhap, String maSanPham, int soLuong, double donGia, double thanhtien,String status)
    {
        this.maPhieuNhap = maPhieuNhap;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhtien;
        this.status = status;
    }
    public ChiTietPhieuNhap( ChiTietPhieuNhap x)    
    {
         this.maPhieuNhap = x.maPhieuNhap;
        this.maSanPham = x.maSanPham;
        this.soLuong = x.soLuong;
        this.donGia = x.donGia;
        this.thanhTien = x.thanhTien;
    }
    public void nhap()
    { 
        // System.out.println("Nhap ma phieu nhap: ");
        // maPhieuNhap = scanner.nextLine(); // mã phiếu nhập sẽ được điền ở bên phiếu nhập.
        System.out.println("Nhap ma san pham: ");
        maSanPham = scanner.nextLine(); // mã sản phẩm sẽ điền ở bên phiếu nhập.
        System.out.println("Nhap so luong san pham: ");
        soLuong = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap gia cua san pham: ");
        donGia = Double.parseDouble(scanner.nextLine());
        this.thanhTien = this.soLuong * this.donGia;
    }
    public void xuat()
    {   
        System.out.println( maPhieuNhap+"\t\t" + maSanPham+"\t\t" + soLuong+
        "\t\t" + donGia+ "\t\t" + thanhTien+"\t\t"+status);
    }
    public String toString(){
        return maPhieuNhap+", " + maSanPham+
        ", " + soLuong+ ", " + donGia+", "+thanhTien+", "+status;
    }
    public void xoa(){
        this.status  = "0";
    }
    public String getMaPhieuNhap()
    {
        return maPhieuNhap;
    }
    public void setMaPhieuNhap( String maPhieuNhap)
    {
        this.maPhieuNhap = maPhieuNhap;
    }
    public String getMaSanPham()
    {
        return maSanPham;
    }
    public void setMaSanPham( String maSanPham)
    {
        this.maSanPham = maSanPham;
    }
    public int getSoLuong()
    {
        return soLuong;
    }
    public void setSoLuong(int soLuong)
    {
        this.soLuong = soLuong;
    }
    public double getDonGia(){
        return donGia;
    }
    public void setDonGia( double donGia)
    {
        this.donGia = donGia;
    }
    public  double getThanhTien()
    {
        return thanhTien;
    }
    public void setThanhTien(double thanhTien)
    {
        this.thanhTien = thanhTien;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }
}
