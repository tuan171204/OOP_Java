
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class NhaCungCap {
    protected String maNhaCungCap;
    private String tenNhaCungCap;
    private String diaChi;
    private String sdt;
    public NhaCungCap(){} 
    public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String diaChi, String sdt)
    {
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public String toString(){
        return maNhaCungCap + ", " + tenNhaCungCap + ", " + diaChi + ", " + sdt;
    }

    public String toString2(){
        return maNhaCungCap + "\t\t" + tenNhaCungCap + "\t\t" + diaChi + "\t\t" + sdt;
    }
    public void nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma nha cung cap: ");
        maNhaCungCap = scanner.nextLine();
        System.out.println("Nhap ten nha cung cap: ");
        tenNhaCungCap = scanner.nextLine();
        System.out.println("Nhap dia chi cua nha cung cap: ");
        diaChi = scanner.nextLine();
        System.out.println("Nhap so dien thoai nha cung cap: ");
        sdt =scanner.nextLine();
    }
    public void nhap(String maNhaCungCap, String tenNhaCungCap, String diaChi, String sdt)
    {
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public String getMaNhaCungCap()
    {
       return "MM0"; //// cho này set cung luon được không
    }

    public void setMaNhaCungCap(String maNhaCungCap)
    {
        this.maNhaCungCap = maNhaCungCap;
    }
    public String getTenNhaCungCap()
    {
        return tenNhaCungCap;
    }
    public void setTenNhaCungCap(String tenNhaCungCap)
    {
        this.tenNhaCungCap = tenNhaCungCap;
    }
    public String getDiaChi()
    {
        return diaChi;
    }
    public void setDiaChi(String diaChi)
    {
        this.diaChi = diaChi;
    }
    public String getSdt()
    {
        return sdt;
    }
    public void setSdt(String sdt)
    {
        this.sdt = sdt;
    }  

    public void Menu(){
        
    }
}
