//package FileJava.DoAnMyPham;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class SanPham {
    Scanner sc = new Scanner(System.in);
    private String masp;
    private String tensp;
    private int soluong;
    private double dongia;
    private String chatlieu;
    // constructor
    SanPham(String masp, String tensp, int soluong, double dongia, String chatlieu){
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia =  dongia;
        this.chatlieu = chatlieu;
    }
    SanPham(){
        this.masp = "";
        this.tensp = "";
        this.soluong = 0;
        this.dongia = 0;
        this.chatlieu = "";
    }
    public void nhapByKeyboard(){     
        // System.out.println("Nhap ma san phan: "); // kiem tra truoc khi nhap.
        // this.masp = sc.nextLine();
        System.out.println("Nhap ten san phan: ");
        this.tensp = sc.nextLine();
        System.out.println("Nhap so luong san phan: ");
        this.soluong = sc.nextInt();
        System.out.println("Nhap donn gia: ");
        this.dongia = sc.nextInt();  
        sc.nextLine();  
        System.out.println("Nhap chat lieu: ");
        this.chatlieu = sc.nextLine();
    }
    // abstract
    public abstract void thongTin();
    ////
    public void xuat(){
        System.out.println("Ma sp:"+this.masp);
        System.out.println("Ten sp:"+this.tensp);
        System.out.println("So luong:"+this.soluong);
        System.out.println("Don gia:"+this.dongia);
        System.out.println("Chat lieu:"+this.chatlieu);    
    }
    @Override
    public String toString() {
        return this.masp + 
               "\t"+this.tensp + 
               "\t"+this.soluong +
               "\t"+this.dongia +
               "\t\t"+this.chatlieu;
    }
    //getter
    public int getSoluong (){
        return this.soluong;
    }
    public String getMasp(){
        return this.masp;
    }
    public String getTenSp(){
        return this.tensp;
    }
    public String getChatLieu(){
        return this.chatlieu;
    }
    public double getDonGia(){
        return this.dongia;
    }
    ///// setter
    public void setMasp(String ma){
        this.masp = ma;
    }
    
    public void setSoLuong(int sl){
        this.soluong = sl + this.soluong;
    }
    public void setGia(double gia){
        this.dongia = gia;
    }
    //// ham tru so luong;
    public void setSoLuongBan(int sl){
        this.soluong = this.soluong - sl;
    }

    public void setSoLuongTra(int sl){
        this.soluong = this.soluong + sl;
    }
}
