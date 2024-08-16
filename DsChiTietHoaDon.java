import java.io.*;
import java.util.*;
public class DsChiTietHoaDon {
    private ChiTietHoaDon[] danhSachChiTiet ;
    Scanner  sc = new Scanner(System.in);

    public ChiTietHoaDon []getDsChiTietHoaDon(){
        return danhSachChiTiet;
    }
    public DsChiTietHoaDon(){
        danhSachChiTiet = new ChiTietHoaDon[0];
    }
    // ghi vao File
    public void ghiVaoFile(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("DsChiTietHoaDon.txt", false));
            for(int i=0;i<danhSachChiTiet.length;i++){
                if ( danhSachChiTiet[i].getStatus().equals("1")){
                writer.write(danhSachChiTiet[i].toString2());
                writer.newLine();
                }
            }
            writer.close();
        } catch (IOException e) {
            // TODO: handle exception
        }
    }

    // doc FIle
    public void nhapTuFile(){
        try {
            danhSachChiTiet = new ChiTietHoaDon[0];
            BufferedReader  reader = new BufferedReader(new FileReader("DsChiTietHoaDon.txt"));
           String line;
            while((line = reader.readLine())!=null){
                String data[] =  line.split(", ");
                danhSachChiTiet =  Arrays.copyOf(danhSachChiTiet, danhSachChiTiet.length + 1);
                danhSachChiTiet[danhSachChiTiet.length-1] = new ChiTietHoaDon(data[0], data[1],Integer.parseInt(data[2]) , Double.parseDouble(data[3]),data[5]);
            }
            reader.close();
        } catch (Exception e) {
        // TODO: handle exception
        }
    }

    public static void xoaDuLieuFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("DsChiTietHoaDon.txt", false));
            writer.write(""); // Ghi một chuỗi rỗng để xóa nội dung của file
            writer.close();
        } catch (IOException e) {
        e.printStackTrace();
        }
    }

    public double themChiTiet(String maHD, ListProduct product){
        double tongTien = 0;
        System.out.println("Nhap so luong chi tiet hoa don: ");
        int soChiTiet = Integer.parseInt(sc.nextLine());
        
        for ( int i=0; i< soChiTiet; i++){
            danhSachChiTiet = Arrays.copyOf(danhSachChiTiet, danhSachChiTiet.length + 1);
            danhSachChiTiet[danhSachChiTiet.length - 1] = new ChiTietHoaDon();
            danhSachChiTiet[danhSachChiTiet.length - 1].setMaHoaDon(maHD);
            
            System.out.println("Nhap ma san pham " + (i+1) + ": ");
            String maSP = sc.nextLine();
            
            int vitri = product.getViTri(maSP);
            if ( vitri == -1){
            do {
                System.out.println("Khong tim thay ma san pham, nhap lai: ");
                maSP = sc.nextLine();
                vitri = product.getViTri(maSP);
            } while ( vitri  == -1);
            }
            danhSachChiTiet[danhSachChiTiet.length - 1].setMaSanPham(maSP);
            double donGia = product.getDonGia(vitri);
            danhSachChiTiet[danhSachChiTiet.length - 1].setDonGia(donGia);
            
            
            System.out.println("Nhap so luong: ");
            int soLuong = Integer.parseInt(sc.nextLine());
            product.setGiamSoLuong(soLuong, vitri);
            danhSachChiTiet[danhSachChiTiet.length - 1].setSoLuong(soLuong);
            danhSachChiTiet[danhSachChiTiet.length - 1].setStatus("1");
            danhSachChiTiet[danhSachChiTiet.length - 1].setThanhTien( donGia * soLuong);
            tongTien += donGia * soLuong;
        }
        return tongTien;

    }
//// them mot chi tiet hoa don.
    public double them1ChiTiet(ListProduct product, String maHD){
       danhSachChiTiet = Arrays.copyOf(danhSachChiTiet, danhSachChiTiet.length + 1);
       danhSachChiTiet[danhSachChiTiet.length - 1] = new ChiTietHoaDon();
       danhSachChiTiet[danhSachChiTiet.length - 1].setMaHoaDon(maHD);

       System.out.println("Nhap ma san pham: ");
       String maSP = sc.nextLine();
    
       int vitri = product.getViTri(maSP);
       if ( vitri == -1 ){
        do { 
            System.out.println("Khong tim thay ma san pham, nhap lai: ");
            maSP = sc.nextLine();
            vitri = product.getViTri(maSP);
        } while ( vitri == -1);
       }
       danhSachChiTiet[danhSachChiTiet.length - 1].setMaSanPham(maSP);
       double donGia = product.getDonGia(vitri);
       danhSachChiTiet[danhSachChiTiet.length - 1].setDonGia(donGia);
       

       System.out.println("Nhap so luong: ");
       int soLuong = Integer.parseInt(sc.nextLine());
       danhSachChiTiet[danhSachChiTiet.length - 1].setSoLuong(soLuong);
       danhSachChiTiet[danhSachChiTiet.length - 1].setStatus("1");
       product.setGiamSoLuong(soLuong, vitri);
       danhSachChiTiet[danhSachChiTiet.length - 1].setThanhTien(donGia * soLuong);
      
       double tongTienMoi = 0.0;
       for ( int i=0; i< danhSachChiTiet.length; i++){
        if ( danhSachChiTiet[i].getStatus().equals("1") && 
             danhSachChiTiet[i].getMaHoaDon().equals(maHD)){
                tongTienMoi += danhSachChiTiet[i].getThanhTien();
             }
       }
       return tongTienMoi;
    }


    public void xemTatCaChiTiet(){
        int index =0;
        System.out.println("\n======TAT CA CHI TIET HOA DON======");
        System.out.println("STT\t" + "Ma hoa don\t" + "Ma san pham\t" + "So luong\t" +
                           "Don gia\t\t" + "Thanh tien");
        for ( int i=0; i< danhSachChiTiet.length; i++){
            if ( danhSachChiTiet[i].getStatus().equals("1")){
                System.out.println((index+1) + danhSachChiTiet[i].toString());
                index++;
            }
        }
    }

    public void xemChiTiet1HoaDon(ListProduct product, String maHD ){
        int index =0;
        String[] ds = new String[100]; // danh sach luu cac ma san pham cua hoa don
        System.out.println("\n====== HOA DON " + maHD + " ======");
        System.out.println("STT\t" + "Ma hoa don\t" + "Ma san pham\t" + "So luong\t" +
                           "Don gia\t\t" + "Thanh tien");
        for ( int i=0; i< danhSachChiTiet.length; i++){
            if (danhSachChiTiet[i].getStatus().equals("1") && 
                danhSachChiTiet[i].getMaHoaDon().equals(maHD))
            {
                System.out.println((index+1) + danhSachChiTiet[i].toString());
                ds[index] = danhSachChiTiet[i].getMaSanPham();
                index++;
            }
        }

        int select = 0;
        do {
            System.out.println("\n====== THONG TIN KHAC ======");
            System.out.println("1. Thong tin ve cac san pham cua hoa don ");
            System.out.println("2. Thoat");
            System.out.println("Lua chon: ");
            select = Integer.parseInt(sc.nextLine());

            switch (select){
                case 1:
                System.out.println("====== THONG TIN SAN PHAM ======");
                System.out.println("Ma san pham\t" + "Ten san pham\t\t" + "Ton kho\t\t" + "Don gia\t\t" + "Chat lieu");
                for ( int i=0; i< ds.length; i++){
                    if ( ds[i] == null){
                        break;
                    }
                    int vitri = product.getViTri(ds[i]);
                    product.xuatThongTinSp(vitri);
                }
                break;

                case 2:
                break;

                default:
                System.out.println("Lua chon khong hop le ");
            }
        } while ( select != 2);
    }


    public double suaChiTiet(String maHD, ListProduct product){
        int index =0;
        for ( int i=0; i< danhSachChiTiet.length; i++){
            if (danhSachChiTiet[i].getStatus().equals("1") &&
                danhSachChiTiet[i].getMaHoaDon().equals(maHD)) {
                System.out.println((index+1) + ". " + danhSachChiTiet[i].toString());
                index++;
            }
        }
        System.out.println("Nhap so thu tu muon sua: ");
        int select = Integer.parseInt(sc.nextLine());
        index = 1;
        for ( int i=0; i< danhSachChiTiet.length; i++){
            if (danhSachChiTiet[i].getStatus().equals("1") &&
                danhSachChiTiet[i].getMaHoaDon().equals(maHD)) {
                if ( index == select ){
                       int vitri2 = product.getViTri(danhSachChiTiet[i].getMaSanPham()); // lay vi tri ma sp cua chi tiet hoa don dang sua
                       System.out.println("Nhap ma san pham moi: ");
                       String maSP = sc.nextLine();
                       
                       int vitri = product.getViTri(maSP); // lay vi tri cua ma san pham moi 
                       if ( vitri == -1){
                        do {
                            System.out.println("Khong tim thay ma san pham, nhap lai: ");
                            maSP = sc.nextLine();
                            vitri = product.getViTri(maSP);
                        } while ( vitri == -1);
                       }
                       danhSachChiTiet[i].setMaSanPham(maSP);
                       
                       product.setTangSoLuong(danhSachChiTiet[i].getSoLuong(), vitri2); // truoc khi nhap so luong moi thi 
                       System.out.println("Nhap so luong moi: ");                     // tra lai so luong sp dang co trong chi tiet hoa don 
                       int soLuong = Integer.parseInt(sc.nextLine());
                       danhSachChiTiet[i].setSoLuong(soLuong);

                       
                       product.setGiamSoLuong(soLuong, vitri);
                       double donGia = product.getDonGia(vitri);
                       danhSachChiTiet[i].setDonGia(donGia);

                       danhSachChiTiet[i].setThanhTien(soLuong * donGia);
                       break;
                } else {
                    index++;
                }
            }
        }

        double tongTienMoi = 0.0;
        for ( int i=0; i< danhSachChiTiet.length; i++){
            if ( danhSachChiTiet[i].getMaHoaDon().equals(maHD)){
                tongTienMoi += danhSachChiTiet[i].getThanhTien();
            }
        }
        return tongTienMoi;
    }


    public void xoaChiTiet(String maHD, ListProduct product){ // hàm này dùng để xóa cùng với hóa đơn
        for ( int i=0; i< danhSachChiTiet.length; i++){
            if ( danhSachChiTiet[i].getMaHoaDon().equals(maHD)){
                int vitri = product.getViTri(danhSachChiTiet[i].getMaSanPham());
                product.setTangSoLuong(danhSachChiTiet[i].getSoLuong(), vitri);
                danhSachChiTiet[i].setStatus("0");
            }
        }


    }

    public double xoa1ChiTiet(String maHD, ListProduct product){
        int index =0;
        for ( int i=0; i< danhSachChiTiet.length; i++){
            if (danhSachChiTiet[i].getStatus().equals("1") &&
                danhSachChiTiet[i].getMaHoaDon().equals(maHD)) {
                System.out.println((index+1) + ". " + danhSachChiTiet[i].toString());
                index++;
            }
        }
        System.out.println("Nhap so thu tu muon xoa: ");
        int select = Integer.parseInt(sc.nextLine());
        index =1;
         for ( int i=0; i< danhSachChiTiet.length; i++){
            if (danhSachChiTiet[i].getStatus().equals("1") &&
                danhSachChiTiet[i].getMaHoaDon().equals(maHD)) {
                if ( index == select ){
                    int vitri = product.getViTri(danhSachChiTiet[i].getMaSanPham());
                    product.setTangSoLuong(danhSachChiTiet[i].getSoLuong(), vitri);    
                    danhSachChiTiet[i].setStatus("0");
                } else {
                    index++;
                }
            }
        }

        double tongTienMoi = 0.0;
        for ( int i=0; i< danhSachChiTiet.length; i++){
            if (danhSachChiTiet[i].getStatus().equals("1") && 
                danhSachChiTiet[i].getMaHoaDon().equals(maHD)) {
                    tongTienMoi += danhSachChiTiet[i].getThanhTien();
            }
        }
        return tongTienMoi;
    }
    
    // Get chi tiet hoa don
    public ChiTietHoaDon getcthd(String ma){
        for(int i=0;i<danhSachChiTiet.length;i++){
            if(ma.equals(danhSachChiTiet[i].getMaSanPham())){
                return danhSachChiTiet[i];
            }
        }
        return null;
    }

    // Thong ke tong doanh thu
    public void thongKeTongDoanhThu(ListProduct product){
        String[] maSP = new String[100];
        double[] tongTien = new double[100];
        int[] soLuong = new int[100];
        boolean[] daXet = new boolean[100];
        Arrays.fill(soLuong, 0);
        Arrays.fill(daXet, false);
        double tongDoanhThu = 0;
        int index =0;

        for ( int i=0; i< danhSachChiTiet.length; i++){
            if (danhSachChiTiet[i] == null)
            {
                break;
            }

            if (danhSachChiTiet[i].getStatus().equals("1") && 
                daXet[i] == false)
            {
                maSP[index] = danhSachChiTiet[i].getMaSanPham();
                tongTien[index] = danhSachChiTiet[i].getThanhTien();
                soLuong[index] = danhSachChiTiet[i].getSoLuong();
                daXet[i] = true;
                for ( int j=0; j< danhSachChiTiet.length;j++){
                    if (danhSachChiTiet[j].getStatus().equals("1") &&
                        daXet[j] == false && 
                        danhSachChiTiet[j].getMaSanPham().equals(danhSachChiTiet[i].getMaSanPham()))
                        {
                            tongTien[index] += danhSachChiTiet[j].getThanhTien();
                            soLuong[index] += danhSachChiTiet[j].getSoLuong();
                            daXet[j] = true;
                        }
                }
                tongDoanhThu += tongTien[index];
                index++;
            }
        }
        // tim san pham co doanh thu cao nhat
        String maxMaSanPham1 = maSP[0];
        String minMaSanPham1 = maSP[0];
        double maxTongTien = tongTien[0];
        double minTongTien = tongTien[0];
        for ( int i=1; i< maSP.length;i++){
            if (maSP[i] == null){
                break;
            }
            else if ( tongTien[i] > maxTongTien ){
                maxTongTien = tongTien[i];
                maxMaSanPham1 = maSP[i];
            }
            if ( tongTien[i] < minTongTien ){
                minTongTien = tongTien[i];
                minMaSanPham1 = maSP[i];
            }
        }

        // phòng trường hợp có 2 mã sản phẩm có cùng tổng tiền lớn nhất || it nhat 
        // mình dò coi có cái nào bằng tổng tiền của maxTongTien, minTongTien ở trên không
        index =0;
        int index2=0;
        String[] maxMaSanPham_1 = new String[20];
        String[] minMaSanPham_1 = new String[20];
        for ( int i =0; i< maSP.length; i++){
            if ( tongTien[i] == maxTongTien && maSP[i] != maxMaSanPham1){
                maxMaSanPham_1[index] = maSP[i];
                index++;
            } else if ( tongTien[i] == minTongTien && maSP[i] != minMaSanPham1){
                minMaSanPham_1[index2] = maSP[i];
                index2++;
            }

        }

        // tim san pham co so luong ban ra nhieu nhat
        String maxMaSanPham2 = maSP[0];
        String minMaSanPham2 = maSP[0];
        int maxSoLuong = soLuong[0];
        int minSoLuong = soLuong[0];
        for ( int i=1; i< maSP.length; i++){
            if (maSP[i] == null){
                break;
            }
            else if ( soLuong[i] > maxSoLuong){
                maxSoLuong = soLuong[i];
                maxMaSanPham2 = maSP[i];
            }
            else if ( soLuong[i] < minSoLuong){
                minSoLuong = soLuong[i];
                minMaSanPham2 = maSP[i];
            }
        }

        // phòng trường hợp có 2 mã sản phẩm có cùng số lượng lớn nhất, 
        // mình dò coi có cái nào bằng số lượng của maxSoLuong ở trên không
        index =0;
        index2= 0;
        String[] maxMaSanPham_2 = new String[20];
        String[] minMaSanPham_2 = new String[20];
        for ( int i =0; i< maSP.length; i++){
            if ( soLuong[i] == maxSoLuong && maSP[i] != maxMaSanPham2){
                maxMaSanPham_2[index] = maSP[i];
                index++;
            } else if ( soLuong[i] == minSoLuong && maSP[i] != minMaSanPham2){
                minMaSanPham_2[index2] = maSP[i];
                index2++;
            }
        }

        System.out.println("\n============ BANG THONG KE DOANH THU ============");
        System.out.println("Ma san pham\t" + "So luong ban ra\t\t" +"Doanh Thu" );
        for ( int i=0; i< maSP.length; i++){
            if (maSP[i] == null) break;
            System.out.println(maSP[i] + "\t\t\t" + soLuong[i] +"\t\t" + tongTien[i] + "$");
        }
        System.out.println("---------------------------------");
        System.out.println("+ Tong doanh thu: " + tongDoanhThu + "$\n");
        System.out.print("+ San pham co doanh thu cao nhat: " + maxMaSanPham1);
        for ( int i=0; i< maxMaSanPham_1.length; i++){
            if ( maxMaSanPham_1[i] != null){
                 System.out.print(", " + maxMaSanPham_1[i]);
            }
        }
        System.out.println(" \n- Doanh thu: " + maxTongTien + "$");
        System.out.print("\n+ San pham co doanh thu thap nhat: " + minMaSanPham1);
        for ( int i=0; i< minMaSanPham_1.length; i++){
            if ( minMaSanPham_1[i] != null){
                 System.out.print(", " + minMaSanPham_1[i]);
            }
        }
        System.out.println("\n- Doanh thu: " + minTongTien);
        
        System.out.print("\n+ San pham co so luong ban ra nhieu nhat: " + maxMaSanPham2);
        for ( int i=0; i< maxMaSanPham_2.length; i++){
            if ( maxMaSanPham_2[i] != null){
                 System.out.print(", " + maxMaSanPham_2[i]);
            }
        }
        System.out.println(" \n- So luong: " + maxSoLuong);
        System.out.print("\n+ San pham co so luong ban ra it nhat: " + minMaSanPham2);
        for ( int i=0; i< minMaSanPham_2.length; i++){
            if ( minMaSanPham_2[i] != null){
                 System.out.print(", " + minMaSanPham_2[i]);
            }
        }
        System.out.println("\n- So luong: " + minSoLuong);

        System.out.println("---------------------------------");

    }

    
    /// thong so san pham ban chay nhat theo thang
    public void thongKeSoLuong_DoanhThu(DanhSachHoaDon dshd) {
        System.out.print("Nhap nam de thong ke theo thang: ");
        String nam = sc.nextLine();
        System.out.print("Nhap thang bat dau: ");
        int thang1 =  Integer.parseInt(sc.nextLine());
        System.out.print("Nhap thang ket thuc: ");
        int thang2 = Integer.parseInt(sc.nextLine());
        int soLuong[] = new int[12];
        double doanhthu[] = new double[12];
        int thang[] = new int[12];
        ///// xuat hoa don cu the


        /////
        System.out.println("\t======TIM KIEM DON HANG TU THANG TU THANG "+thang1+" DEN THANG "+thang2+" NAM "+nam+" =======");
        System.out.println("\tMaHD\t\tMaSp\t\tSoLuong\t\tDonGia\t\tThanhTien");
        for (int i = 0; i < 12; i++){
            thang[i]=i;
            soLuong[i] = 0;
            doanhthu[i] = 0.0;
            for (int j = 0; j < danhSachChiTiet.length; j++) {
                if (danhSachChiTiet[j].getStatus().equals("1")
                        && dshd.checkNgay_Nam(danhSachChiTiet[j].getMaHoaDon(), Integer.toString(i+1), nam)) {
                            System.out.print(danhSachChiTiet[j].toString()+"\n");
                            soLuong[i]+=danhSachChiTiet[j].getSoLuong();
                            doanhthu[i]+=danhSachChiTiet[j].getThanhTien();
                }
            }
        }
        System.out.println("\n=========== THONG KE THEO THANG "+thang1+" - "+thang2+" NAM "+nam+" ==========");
        System.out.println("Thang\t\tSo Luong Ban Ra\t\t\tDoanh Thu");
        double tong =0.0;
        for(int i=thang1;i<=thang2;i++){
            tong +=doanhthu[i-1];
            System.out.println((thang[i-1]+1)+"\t\t\t"+soLuong[i-1]+"\t\t\t"+doanhthu[i-1]+"$");
        }
        System.out.println("\nTong doanh thu tu thang "+thang1+" den thang "+thang2+" la: "+tong+"$");
    }

    public ChiTietHoaDon[] getDanhSachChiTiet(){
        return danhSachChiTiet;
    }
}

