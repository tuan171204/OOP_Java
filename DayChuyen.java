//package FileJava.DoAnMyPham;
import java.util.Scanner;
public class DayChuyen extends SanPham {
    private float kichthuoc;
    private String hatDinh;
    DayChuyen(){
        super();
        this.kichthuoc = 0;
        this.hatDinh = null;
    };
    DayChuyen(String masp, String tensp,int soluong, double dongia,String chatlieu,float kichthuoc, String hatDinh){
        super(masp,tensp,soluong,dongia,chatlieu);
        this.kichthuoc = kichthuoc;
        this.hatDinh = hatDinh;
    }
    //abstract
    @Override public  void thongTin(){
        System.out.println("Toi la day chuyen!!");
    }
    //
    @Override public void nhapByKeyboard(){
        super.nhapByKeyboard();
        System.out.print("Kich thuoc: ");
        this.kichthuoc = sc.nextFloat();
        sc.nextLine();
        System.out.print("Hat Dinh: ");
        this.hatDinh =  sc.nextLine();   
    }
    @Override public void xuat(){
        super.toString();
        System.out.println(super.toString()+"\t\t"+this.kichthuoc
        +"\t\t"+this.hatDinh);
    }
    // Ham Get
    public float getKichThuoc(){
        return this.kichthuoc;
    }
    public String gethatDinh(){
        return this.hatDinh;
    }
    //Ham set
    public void set(String hatDinh, float kichthuoc){
        this.hatDinh = hatDinh;
        this.kichthuoc = kichthuoc;
    }
}
