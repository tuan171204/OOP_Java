
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;

public class NhanVien {
    private String maNhanVien;
    private String tenNhanVien;
    private String ngaySinh;
    private String diaChi;
    private String soDienThoai;
    private String gioiTinh;
    Scanner sc = new Scanner(System.in);
    /// constructor
    NhanVien() {}

    NhanVien(String maNhanVien, String tenNhanVien, String ngaySinh, String diaChi, String soDienThoai,
            String gioiTinh) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.gioiTinh = gioiTinh;
    }

    public void nhap() {
        //System.out.println("Nhập thông tin nhân viên:");
        // System.out.print("Mã nhân viên: ");
        //this.maNhanVien = sc.nextLine();
        System.out.print("Ten nhan vien: ");
        this.tenNhanVien = sc.nextLine();
        System.out.print("Ngay sinh (theo dinh dang dd/MM/yyyy): ");
        this.ngaySinh = regexNS(sc.nextLine());
        System.out.print("Dia chi: ");
        this.diaChi = sc.nextLine();
        System.out.print("So dien thoai: ");
        this.soDienThoai = regexSdt(sc.nextLine());
        System.out.print("Gioi tinh: ");
        this.gioiTinh = sc.nextLine();
    }

    public void hienThiThongTin() {
        System.out.println(toString());
    }
    @Override
    public String toString() {
        return maNhanVien +", "+ tenNhanVien+", " + ngaySinh+", " + diaChi+", " + soDienThoai+", " + gioiTinh;
    }
    /// regex
    public String regexSdt(String sdt){
        while(true){
            if(sdt.matches("^[0-9]{10}$")){
                break;
            }
            sdt = sc.nextLine();
        }    
        return sdt;
    }
   public String regexNS(String ns){
       while(true){
           String data[] = ns.split("/");
           if(data[0].matches("^[0-9]{2}$") && (Integer.parseInt(data[0])<=31||Integer.parseInt(data[0])>=1)){
               if(data[1].matches("^[0-9]{2}$") && (Integer.parseInt(data[1])<=12||Integer.parseInt(data[1])>=1)){
                        if(data[2].matches("^[0-9]{4}$") && (Integer.parseInt(data[2])<=2023||2023-Integer.parseInt(data[2])<=100)){
                            break;
                        }

                    }
           }
           ns = sc.nextLine();
       }
       return ns;
   }
    //getter
    public String getMaNhanVien() {
        return maNhanVien;
    }
    public String getTenNhanVien() {
        return tenNhanVien;
    }
    public String getDiaChi(){
        return this.diaChi;
    }
    public String getsoDienThoai(){
        return this.soDienThoai;
    }
    public String getgioiTinh(){
        return this.gioiTinh;
    }
    public String getNgaySinh() {
        return ngaySinh;
    }
    //setter
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
