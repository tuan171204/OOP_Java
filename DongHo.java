//package FileJava.DoAnMyPham;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class DongHo extends SanPham{
    Scanner sc = new Scanner(System.in);
    private String thuonghieu;
    private String loaimay;
    DongHo(){}
    DongHo(String masp, String tensp,int soluong, double dongia,String chatlieu,String thuonghieu, String loaimay){
        super(masp,tensp,soluong,dongia,chatlieu);
        this.loaimay = loaimay;
        this.thuonghieu = thuonghieu;
    }
    //// abstract
    @Override public  void thongTin(){
        System.out.println("Toi la dong ho!!");
    }
    /// Ham Nhap
    @Override public void nhapByKeyboard(){
        super.nhapByKeyboard();
        System.out.print("Thuong hieu: ");
        this.thuonghieu = sc.nextLine();
        System.out.print("Loai may: ");
        this.loaimay = sc.nextLine();
    }
    @Override public void xuat(){
        System.out.print(super.toString()+"\t\t" + this.thuonghieu+"\t\t"+ this.loaimay+"\n");
    }
    ////  Ham get
    public String getThuongHieu(){
        return this.thuonghieu;
    }
    public String getLoaiMay(){
        return this.loaimay;
    }
    //// Ham set
    public void set( String thuonghieu,String loaimay){
        this.loaimay = loaimay;
        this.thuonghieu = thuonghieu;
    }
}
