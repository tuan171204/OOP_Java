import java.util.*;
import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class DanhSachPhieuNhap {
    private PhieuNhap[] dspn ;
    Scanner  sc = new Scanner(System.in);

    public DanhSachPhieuNhap() {}
    public void nhap(){
        int sl = Integer.parseInt(sc.nextLine());
        dspn = new PhieuNhap[sl];
        for(int i=0;i<sl;i++){
            dspn[i] = new PhieuNhap();
            dspn[i].nhap();
        }
    }
    public void xuat(){
        System.out.println("maPhieuNhap\tmaNhaCungCap\ttongTien\tngayLapPhieuNhap");
        for(int i=0;i<dspn.length;i++){
            if(dspn[i]!=null && dspn[i].getStatus().equals("1")){
                dspn[i].xuat();
            }
        }
    }
    public void docFile(){
        try {
            dspn = new PhieuNhap[0];
            BufferedReader reader = new BufferedReader(new FileReader("dsPhieuNhap.txt"));
            String line;
            while((line = reader.readLine())!=null){
                String[] arr = line.split(", ");
                dspn = Arrays.copyOf(dspn, dspn.length+1);
                dspn[dspn.length-1] = new PhieuNhap(arr[0],arr[1],Double.parseDouble(arr[2]),arr[3],arr[4]);
            }
            reader.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    public void ghiFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("dsPhieuNhap.txt"));
            for(int i=0;i<dspn.length;i++){
                writer.write(dspn[i].toString());
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public void xoa(){
        System.out.println("nhap  ma phieu nhap muon xoa: ");
        String mapn = sc.nextLine();
        for(int i=0;i<dspn.length;i++){
            if(mapn.equalsIgnoreCase(dspn[i].getMaPhieuNhap())){
                dspn[i].xoa();
                break;
            }
        }
    }
    public void them(String maPN,Double tongtien){
        System.out.println(dspn.length);
        dspn = Arrays.copyOf(dspn, dspn.length+1);
        dspn[dspn.length-1] = new PhieuNhap();
        dspn[dspn.length-1].nhap(); 
        dspn[dspn.length-1].setMaPhieuNhap(maPN);
        dspn[dspn.length-1].setTongTien(tongtien);
    }
    public void nhapVaoSanPham(DanhSachChiTietPhieuNhap dsctpn, ListProduct product){
        System.out.println("Nhap ma phieu nhap can nhap vao san pham:");
        String mapn = sc.nextLine();
        for(int i=0;i<dsctpn.getDSCTPN().length;i++){
            if(mapn.equalsIgnoreCase(dsctpn.getDSCTPN()[i].getMaPhieuNhap())){
               int vitri = product.getViTri(dsctpn.getDSCTPN()[i].getMaSanPham());
               System.out.print("vitri"+vitri);
                product.setThemSoLuong(dsctpn.getDSCTPN()[i].getSoLuong(), vitri);
            }
        }
    }
    public void Menu(){     
        System.out.println("========== QUAN LY PHIEU NHAP ==========");
        System.out.println("1. Them 1 phieu nhap:");
        System.out.println("2. Xoa 1 Phieu Nhap");
        System.out.println("3. sua phieu nhap");
        System.out.println("4. Nhap Hang vao san pham");
        System.out.println("5. Xuat");
        System.out.println("6. Thoat");
        System.out.println("Lua chon: ");
    }





























    public void thongKe(){
        String [] maPN = new String[100];
        double [] tongTien = new double[100];
        boolean [] daXet = new boolean[100];
        Arrays.fill(daXet, false);
        for ( int i=0; i< dspn.length; i++){
            if ( daXet[i] == false){
                maPN[i] = dspn[i].getMaPhieuNhap();
                tongTien[i] = dspn[i].getTongTien();
                daXet[i] = true;
                for ( int j=0; j<dspn.length; j++){
                    if ( daXet[j] == false && dspn[j].getMaPhieuNhap().equals(maPN[i])){
                        tongTien[i] += dspn[j].getTongTien();
                        daXet[j] = true;
                    }
                }
            }
        }

        // tìm max 
        double max =0.0;
        String mapnmax = "";
        double tongTienmax = 0.0;
        for ( int i=0; i < maPN.length; i++){
            if ( tongTien[i] > max ){
                max = tongTien[i];
                mapnmax = maPN[i];
            }
        }

        System.out.println("Phieu nhap co tong tien lon nhat: ");
        System.out.println(mapnmax);
        System.out.println(tongTienmax);

    }
    
}
