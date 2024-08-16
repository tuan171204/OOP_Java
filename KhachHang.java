import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class KhachHang {
    private String maKhachHang;
    private String tenKhachHang;
    private String soDienThoai;
    private String diaChi;
    private String gioiTinh;
    private String phanLoai; 
    // set bằng truyền tham số là số nguyên'
    // 0 là chưa có bậc
    // 1 là đồng ( số lần mua >= 2 && tổng tiền >= 500 )
    // 2 là bạc  ( số lần mua >= 3 && tổng tiền >= 800 )
    // 3 là vàng ( số lần mua >= 5 && tổng tiền >= 1200 )
    // 4 là bạch kim ( số lần mua >= 7 && tổng tiền >= 1700 )
    // lấy ý tưởng từ thẻ thành viên siêu thị CoopMart
    // số lần mua thể hiện mức độ thân thiết/ ( trung thành ) với cửa hàng -> phải có
    // tổng tiền coi như một điều kiện để đạt cấp độ mới
    // khi tạo khách hàng mới thì mặc định là 0
    
    Scanner sc = new Scanner(System.in);

    // constructor
    KhachHang() {}
    KhachHang(String maKhachHang, String tenKhachHang, String soDienThoai, String diaChi, String gioiTinh, String phanLoai) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.phanLoai = phanLoai;
    }

    public void nhap() {
        System.out.println("Nhap thong tin khach hang:");
        // System.out.print("Ma khach hang: "); // ly do la can check trc khi nhap;
        // this.maKhachHang = this.sc.nextLine();
        System.out.print("Ten khach hang: ");
        this.tenKhachHang = this.sc.nextLine();
        System.out.print("So dien thoai: ");
        this.soDienThoai = this.sc.nextLine();
        System.out.print("Dia chi: ");
        this.diaChi = this.sc.nextLine();
        System.out.print("Gioi tinh: ");
        this.gioiTinh = this.sc.nextLine();
    }

    public void hienThiThongTin() {
        String result = String.format("Ma khach hang: %s Ten khach hang: %s So dien thoai: %s Dia chi: %s Gioi tinh: %s",
            this.maKhachHang, this.tenKhachHang, this.soDienThoai, this.diaChi, this.gioiTinh);
        System.out.println(result);
    }

    public String toString() {
        return this.maKhachHang +", " + this.tenKhachHang +
            ", " + this.soDienThoai + ", " + this.diaChi + ", " + this.gioiTinh + ", " +this.phanLoai;
    }
    //getter
    public String getMaKhachHang() {
        return this.maKhachHang;
    }

    public String getTenKhachHang() {
        return this.tenKhachHang;
    }

    public String getsoDienThoai() {
        return this.soDienThoai;
    }

    public String getdiaChi() {
        return this.diaChi;
    }

    public String getgioiTinh() {
        return this.gioiTinh;
    }
    //setter
    public void setMaKhachHang(String ma) {
        this.maKhachHang = ma;
    }
    public void setTenKhachHang(String ten){
        this.tenKhachHang  = ten;
    }
    public void setSoDienThoai(String sdt){
        this.soDienThoai = sdt;
    }
    public void setDiaChi(String diachi){
        this.diaChi = diachi;
    }
    public void setGioiTinh(String gioitinh){
        this.gioiTinh =  gioitinh;
    }

    public void setPhanLoai( int phanLoai){
       if ( phanLoai == 0){
        this.phanLoai = "Not Yet";
       }
       if ( phanLoai == 1 ){
        this.phanLoai = "Bronze";
       }
       if ( phanLoai == 2 ){
        this.phanLoai = "Silver";
       }
       if ( phanLoai == 3 ){
        this.phanLoai = "Gold";
       }
       if ( phanLoai == 4 ){
        this.phanLoai = "Platinum";
       }
    }

    public String getPhanLoai (){
        return this.phanLoai;
    }
}

