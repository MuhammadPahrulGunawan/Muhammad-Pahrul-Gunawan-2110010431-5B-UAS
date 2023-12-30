import Database.KoneksiDatabase;
import Database.ResultSetTable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author User
 */
public class Form_Transaksi extends javax.swing.JInternalFrame {
    ResultSet rs;
    KoneksiDatabase con;
    static String noktp;
    static String nama;
    static String alamat;
    static String tlp;
    String status1;
    /**
     * Creates new form Form_Transaksi
     */
    public Form_Transaksi(String noktp, String nama, String alamat, String tlp) {
       // Inisialisasi objek KoneksiDatabase dengan parameter yang sesuai
        con = new KoneksiDatabase(
        new Database.Parameter().HOST_DB,
        new Database.Parameter().USERNAME_DB,
        new Database.Parameter().PASSWORD_DB
    );
        // Inisialisasi komponen GUI
        initComponents();
        // Mengatur label dengan data yang diterima sebagai parameter
        lbl_noktp.setText(noktp);
        lblNama.setText(nama);
        lbl_alamat.setText(alamat);
        lbl_tlp.setText(tlp);
        // Memuat data mobil dan tabel
        loadMobil();
        loadTabel();
    }
    private void loadMobil() {  // mengambil database
         try {
        rs = con.querySelectAll("tb_mobil");
        // Menghapus item yang sudah ada sebelum menambahkan yang baru
        clearComboBox(boxnopol);

        while (rs.next()) {
            // Menambahkan item nopol ke dalam ComboBox
            boxnopol.addItem(rs.getString("nopol"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(Form_Peminjam.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    // Metode untuk membersihkan item dalam JComboBox
    private void clearComboBox(JComboBox comboBox) {
    comboBox.removeAllItems();
}
    // Metode untuk menambahkan item ke dalam JComboBox
    private void addItemToComboBox(JComboBox comboBox, String item) {
    comboBox.addItem(item);
}
 
public void hitungselisih() {
    try {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        // Ambil tanggal dari jDateChooser1
        Date Tanggal1 = jDateChooser1.getDate();
        // Ambil tanggal dari jDateChooser2
        Date Tanggal2 = jDateChooser2.getDate();
        // Periksa apakah kedua tanggal tidak null
        if (Tanggal1 != null && Tanggal2 != null) {
            long selisih = Tanggal2.getTime() - Tanggal1.getTime();
            long lama = selisih / (24 * 60 * 60 * 1000);
            // Update teksfield dengan selisih hari
            txt_lama.setText(Long.toString(lama));
            // Ambil harga sewa dari label dan parsing ke integer
            int harga_sewa = 0;
            try {
                harga_sewa = Integer.parseInt(lbl_harga.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Format harga tidak valid");
                return; // Keluar dari metode jika parsing gagal
            }
            // Hitung total dan update teksfield total
            int total = harga_sewa * (int) lama;
            txt_total.setText(Integer.toString(total));
        } else {
            JOptionPane.showMessageDialog(this, "Masukkan Tanggal Peminjaman dan Tanggal Pengembalian");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Terjadi kesalahan");
        e.printStackTrace();
    }
}
    private void loadTabel() {
    // Daftar nama kolom yang akan ditampilkan dalam tabel
    String namaKolom[] = {"id_transaksi", "peminjam", "nopol", "tgl_pinjaman", "tgl_kembali", "harga", "lama", "total"};
    
    // Mengambil ResultSet berdasarkan nama kolom dari tabel tb_transaksi
    rs = con.querySelect(namaKolom, "tb_transaksi");
    
    // Mengatur model tabel dengan hasil query dari database
    table_transaksi.setModel(new ResultSetTable(rs));
}
    private void create() {
        try {
        // Memeriksa apakah nama tidak kosong
        if (!lblNama.getText().isEmpty()) {
            // Memeriksa ketersediaan mobil
            if (!jikakeluar()) {
                JOptionPane.showMessageDialog(this, "Mohon MAAF Mobil ini sedang tidak tersedia");
            } else {
                // Daftar kolom yang akan diisi dalam tabel transaksi dan laporan
                String kolom[] = {"peminjam", "nopol", "tgl_pinjaman", "tgl_kembali", "harga", "lama", "total"};
                
                // Mengambil tanggal dari jDateChooser1 dan jDateChooser2
                java.util.Date tgl = (java.util.Date) this.jDateChooser1.getDate();
                java.util.Date tgl1 = (java.util.Date) this.jDateChooser2.getDate();
                
                // Daftar isi yang akan dimasukkan ke dalam tabel transaksi dan laporan
                String isi[] = {lblNama.getText(), boxnopol.getSelectedItem().toString(), new java.sql.Date(tgl.getTime()).toString(), new java.sql.Date(tgl1.getTime()).toString(), lbl_harga.getText(), txt_lama.getText(), txt_total.getText()};
                
                // Menyimpan data transaksi ke dalam tabel transaksi
                System.out.println(con.queryInsert("tb_transaksi", kolom, isi));
                
                // Menyimpan data transaksi ke dalam tabel laporan
                String kol[] = {"peminjam", "nopol", "tgl_peminjaman", "tgl_kembali", "harga", "lama", "total"};
                System.out.println(con.queryInsert("tb_laporan", kol, isi));
                
                // Menampilkan pesan sukses
                JOptionPane.showMessageDialog(this, "Data Transaksi Berhasil Disimpan");
                
                // Melakukan pengecekan status dan menambah data peminjam
                cekstatus();
                add_peminjam();
            }
        } else {
            // Menampilkan pesan jika ada data yang kosong
            JOptionPane.showMessageDialog(this, "Data ada yang kosong");
        }
    } catch (Exception e) {
        // Menampilkan pesan kesalahan jika gagal input data
        JOptionPane.showMessageDialog(this, "Gagal input data");
        System.out.println("salah");
    }
    // Me-refresh tabel dan membersihkan input setelah penyimpanan data
    loadTabel();
    clear();
    }
    private void clear() {
        txt_total.setText("");
        txt_lama.setText("");  
    }
    public void cekstatus() throws SQLException {
    // Mengambil data mobil berdasarkan nomor polisi (nopol) dari ComboBox
    rs = con.querySelectAll("tb_mobil", "nopol ='" + boxnopol.getSelectedItem().toString() + "'");
    // Mengambil status mobil dari hasil kueri
    while (rs.next()) {
        status1 = rs.getString("status");   
    }
    // Menetapkan status baru ("Keluar")
    String update_status = "Keluar";
    String kolom[] = {"status"};
    String isi[] = {update_status};
    // Memperbarui status mobil dalam database
    con.queryUpdate("tb_mobil", kolom, isi, "nopol='" + boxnopol.getSelectedItem().toString() + "'");
}
    public boolean jikakeluar() throws SQLException {
    boolean hasil;
    // Mengambil data mobil berdasarkan nomor polisi (nopol) dari ComboBox
    rs = con.querySelectAll("tb_mobil", "nopol ='" + boxnopol.getSelectedItem().toString() + "'");
    // Mengambil status mobil dari hasil kueri
    while (rs.next()) {
        status1 = rs.getString("status");
    }
    // Menentukan hasil berdasarkan status mobil
    if (status1.equals("Keluar")) {
        hasil = false; // Mobil sudah keluar
    } else {
        hasil = true;  // Mobil masih tersedia
    }
    return hasil;
}
    public void add_peminjam() {
    // Daftar kolom yang akan diisi dalam tabel tb_peminjam
    String kolom[] = {"noktp","nama", "alamat", "telp"};
    // Daftar isi yang akan dimasukkan ke dalam tabel tb_peminjam
    String isi[] = {lbl_noktp.getText(), lblNama.getText(), lbl_alamat.getText(), lbl_tlp.getText()};
    // Menyimpan data peminjam ke dalam tabel tb_peminjam
    System.out.println(con.queryInsert("tb_peminjam", kolom, isi));
    // Menampilkan pesan sukses
    JOptionPane.showMessageDialog(this, "Data Peminjam Berhasil Disimpan");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        panelGlass1 = new usu.widget.glass.PanelGlass();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lbl_alamat = new javax.swing.JLabel();
        lbl_tlp = new javax.swing.JLabel();
        lbl_noktp = new javax.swing.JLabel();
        panelGlass3 = new usu.widget.glass.PanelGlass();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_lama = new javax.swing.JTextField();
        txt_total = new javax.swing.JLabel();
        btn_hitung = new usu.widget.ButtonGlass();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        panelGlass2 = new usu.widget.glass.PanelGlass();
        boxnopol = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lbl_merek = new javax.swing.JLabel();
        lbl_tipe = new javax.swing.JLabel();
        lbl_tahun = new javax.swing.JLabel();
        lbl_harga = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        lbl_status = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnhapus = new usu.widget.ButtonGlass();
        btn_refresh = new usu.widget.ButtonGlass();
        btntambah = new usu.widget.ButtonGlass();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_transaksi = new javax.swing.JTable();
        btnkembali = new usu.widget.ButtonGlass();
        jLabel18 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel7.setText("jLabel7");

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Lucida Fax", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setText("TRANSAKSI MOBIL");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 6, -1, -1));

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGlass1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/small ktp.png"))); // NOI18N
        jLabel2.setText("DATA PEMINJAM");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.blue);
        jLabel4.setText("NAMA");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(java.awt.Color.blue);
        jLabel5.setText("ALAMAT");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel22.setForeground(java.awt.Color.blue);
        jLabel22.setText("NO. TELP");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 255));
        jLabel23.setText(":");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setText(":");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 255));
        jLabel11.setText(":");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel24.setForeground(java.awt.Color.blue);
        jLabel24.setText("NO. KTP");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 255));
        jLabel25.setText(":");

        lblNama.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblNama.setForeground(java.awt.Color.blue);
        lblNama.setText("Nama");

        lbl_alamat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_alamat.setForeground(java.awt.Color.blue);
        lbl_alamat.setText("Alamat");

        lbl_tlp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_tlp.setForeground(java.awt.Color.blue);
        lbl_tlp.setText("No. Telp");

        lbl_noktp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_noktp.setForeground(java.awt.Color.blue);
        lbl_noktp.setText("NO. Ktp");

        javax.swing.GroupLayout panelGlass1Layout = new javax.swing.GroupLayout(panelGlass1);
        panelGlass1.setLayout(panelGlass1Layout);
        panelGlass1Layout.setHorizontalGroup(
            panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass1Layout.createSequentialGroup()
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(lbl_noktp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_tlp, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelGlass1Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelGlass1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelGlass1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNama, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 114, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(37, 37, 37))
        );
        panelGlass1Layout.setVerticalGroup(
            panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(lbl_noktp))
                .addGap(18, 18, 18)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11)
                    .addComponent(lblNama))
                .addGap(18, 18, 18)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(lbl_alamat))
                .addGap(18, 18, 18)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23)
                    .addComponent(lbl_tlp))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        kGradientPanel1.add(panelGlass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 380, 280));

        panelGlass3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(java.awt.Color.blue);
        jLabel14.setText("TANGGAL PEMINJAMAN");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setForeground(java.awt.Color.blue);
        jLabel15.setText("LAMA PEMINJAMAN");

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel32.setForeground(java.awt.Color.blue);
        jLabel32.setText("TANGGAL PENGEMBALIAN");

        jLabel37.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 255));
        jLabel37.setText(":");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 255));
        jLabel16.setText(":");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 255));
        jLabel17.setText(":");

        txt_lama.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        txt_total.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_total.setForeground(new java.awt.Color(255, 0, 0));
        txt_total.setText("Total");

        btn_hitung.setForeground(new java.awt.Color(0, 51, 255));
        btn_hitung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-calculator-32.png"))); // NOI18N
        btn_hitung.setText("Hitung");
        btn_hitung.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btn_hitung.setOpaque(true);
        btn_hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hitungActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel40.setText("RP");
        jLabel40.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel41.setText("Hari");

        jDateChooser1.setDateFormatString("dd, MM, yyyy");

        jDateChooser2.setDateFormatString("dd, MM, yyyy");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-date-64.png"))); // NOI18N
        jLabel3.setText("TANGGAL");

        javax.swing.GroupLayout panelGlass3Layout = new javax.swing.GroupLayout(panelGlass3);
        panelGlass3.setLayout(panelGlass3Layout);
        panelGlass3Layout.setHorizontalGroup(
            panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass3Layout.createSequentialGroup()
                .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel32)
                            .addGroup(panelGlass3Layout.createSequentialGroup()
                                .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(btn_hitung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelGlass3Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelGlass3Layout.createSequentialGroup()
                                        .addComponent(jLabel37)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelGlass3Layout.createSequentialGroup()
                                        .addComponent(jLabel40)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelGlass3Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(txt_lama, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel41))))))
                    .addGroup(panelGlass3Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelGlass3Layout.setVerticalGroup(
            panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel16))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(jLabel37))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(txt_lama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_hitung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelGlass3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txt_total))))
                .addGap(29, 29, 29))
        );

        kGradientPanel1.add(panelGlass3, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 140, 360, 280));

        panelGlass2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        boxnopol.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        boxnopol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxnopolActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(java.awt.Color.blue);
        jLabel8.setText("MEREK MOBIL");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(java.awt.Color.blue);
        jLabel9.setText("NO. POLISI");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel27.setForeground(java.awt.Color.blue);
        jLabel27.setText("TIPE MOBIL");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel29.setForeground(java.awt.Color.blue);
        jLabel29.setText("TAHUN MOBIL");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 255));
        jLabel30.setText(":");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 255));
        jLabel31.setText(":");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 255));
        jLabel12.setText(":");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 255));
        jLabel13.setText(":");

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel33.setForeground(java.awt.Color.blue);
        jLabel33.setText("HARGA (/HARI)");

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 255));
        jLabel34.setText(":");

        lbl_merek.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_merek.setForeground(new java.awt.Color(255, 0, 0));
        lbl_merek.setText("LabelMerek");

        lbl_tipe.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_tipe.setForeground(new java.awt.Color(255, 0, 0));
        lbl_tipe.setText("LabelTipe");

        lbl_tahun.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_tahun.setForeground(new java.awt.Color(255, 0, 0));
        lbl_tahun.setText("LabelTahun");

        lbl_harga.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_harga.setForeground(new java.awt.Color(255, 0, 0));
        lbl_harga.setText("LabelHarga");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel36.setForeground(java.awt.Color.blue);
        jLabel36.setText("STATUS");

        lbl_status.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_status.setForeground(new java.awt.Color(255, 0, 0));
        lbl_status.setText("Status");

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 255));
        jLabel38.setText(":");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-car-64.png"))); // NOI18N
        jLabel1.setText("DATA MOBIL");

        javax.swing.GroupLayout panelGlass2Layout = new javax.swing.GroupLayout(panelGlass2);
        panelGlass2.setLayout(panelGlass2Layout);
        panelGlass2Layout.setHorizontalGroup(
            panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass2Layout.createSequentialGroup()
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass2Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelGlass2Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_tipe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelGlass2Layout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_status, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelGlass2Layout.createSequentialGroup()
                                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxnopol, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_merek, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelGlass2Layout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelGlass2Layout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelGlass2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelGlass2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(84, 84, 84))
        );
        panelGlass2Layout.setVerticalGroup(
            panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(boxnopol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(lbl_merek))
                .addGap(18, 18, 18)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel31)
                    .addComponent(lbl_tipe))
                .addGap(18, 18, 18)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(lbl_tahun))
                .addGap(18, 18, 18)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jLabel34)
                    .addComponent(lbl_harga))
                .addGap(18, 18, 18)
                .addGroup(panelGlass2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel38)
                    .addComponent(lbl_status))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        kGradientPanel1.add(panelGlass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(406, 140, 320, 280));

        btnhapus.setForeground(new java.awt.Color(0, 51, 255));
        btnhapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-delete-40.png"))); // NOI18N
        btnhapus.setText("HAPUS");
        btnhapus.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnhapus.setOpaque(true);
        btnhapus.setRoundRect(true);
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnhapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(709, 456, -1, -1));

        btn_refresh.setForeground(new java.awt.Color(0, 51, 255));
        btn_refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-refresh-40 (1).png"))); // NOI18N
        btn_refresh.setText("REFRESH");
        btn_refresh.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btn_refresh.setOpaque(true);
        btn_refresh.setRoundRect(true);
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(948, 456, -1, -1));

        btntambah.setForeground(new java.awt.Color(0, 51, 255));
        btntambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-add-40.png"))); // NOI18N
        btntambah.setText("TAMBAH");
        btntambah.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btntambah.setOpaque(true);
        btntambah.setRoundRect(true);
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(561, 456, -1, -1));

        table_transaksi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        table_transaksi.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        table_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama  Peminjam", "No Polisi", "Harga", "Tgl Pinjam", "Tgl Kembali", "Lama Pinjam", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table_transaksi);

        kGradientPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 515, 1080, 162));

        btnkembali.setForeground(new java.awt.Color(0, 51, 255));
        btnkembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-back-40.png"))); // NOI18N
        btnkembali.setText("KEMBALI");
        btnkembali.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnkembali.setOpaque(true);
        btnkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembaliActionPerformed(evt);
            }
        });
        kGradientPanel1.add(btnkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 456, -1, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Logo (1).png"))); // NOI18N
        kGradientPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, -1, -1));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1100, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
    loadTabel();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
       try {
        // Mengambil nilai ID dari baris yang dipilih di tabel
        String id = String.valueOf(table_transaksi.getValueAt(table_transaksi.getSelectedRow(), 0));

        // Konfirmasi pengguna untuk menghapus data
        int option = JOptionPane.showConfirmDialog(this, "Yakin menghapus data?", "Peringatan", JOptionPane.OK_CANCEL_OPTION);
       
        if (option == JOptionPane.OK_OPTION) {
            // Melakukan penghapusan data jika pengguna menekan tombol OK
            con.queryDelete("tb_transaksi", "id_transaksi=" + id);
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
        } else {
            // Kembali jika pengguna membatalkan penghapusan
            return;
        }
    } catch (Exception e) {
        // Menampilkan pesan jika tidak ada baris yang dipilih
        JOptionPane.showMessageDialog(this, "Pilih DATA yang ingin dihapus!");
    }

    // Memuat ulang tabel setelah penghapusan data
    loadTabel();

    // Membersihkan input setelah penghapusan data
    clear();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void boxnopolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxnopolActionPerformed
    updateLabelsBasedOnSelectedNopol();
    }
    // Metode untuk memperbarui label berdasarkan item yang dipilih dari ComboBox
    private void updateLabelsBasedOnSelectedNopol() {
    String selectedNopol = (String) boxnopol.getSelectedItem();
    ResultSet rst = con.querySelectAll("tb_mobil", "nopol='" + selectedNopol + "'");
    try {
        while (rst.next()) {
            this.lbl_merek.setText(rst.getString("merek"));
            this.lbl_tipe.setText(rst.getString("tipe"));
            this.lbl_tahun.setText(rst.getString("tahun"));
            this.lbl_harga.setText(rst.getString("harga"));
            this.lbl_status.setText(rst.getString("status"));
        }
    } catch (SQLException ex) {
        Logger.getLogger(Form_Transaksi.class.getName()).log(Level.SEVERE, null, ex);
}
    }//GEN-LAST:event_boxnopolActionPerformed

    private void btn_hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hitungActionPerformed
        hitungselisih();
    }//GEN-LAST:event_btn_hitungActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        create();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
    // Membersihkan jDesktopPane sebelum menampilkan Form_Peminjam baru
    Home.jDesktopPane1.removeAll();   // Menghapus semua komponen yang ada di dalam jDesktopPane
    Home.jDesktopPane1.repaint();     // Melakukan repaint agar tampilan jDesktopPane bersih dan segar
    // Membuat instance baru dari Form_Peminjam
    Form_Peminjam fp = new Form_Peminjam();
    // Menampilkan Form_Peminjam
    fp.setVisible(true);
    // Menambahkan Form_Peminjam ke dalam jDesktopPane
    Home.jDesktopPane1.add(fp);
    }//GEN-LAST:event_btnkembaliActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxnopol;
    private usu.widget.ButtonGlass btn_hitung;
    private usu.widget.ButtonGlass btn_refresh;
    private usu.widget.ButtonGlass btnhapus;
    private usu.widget.ButtonGlass btnkembali;
    private usu.widget.ButtonGlass btntambah;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lbl_alamat;
    private javax.swing.JLabel lbl_harga;
    private javax.swing.JLabel lbl_merek;
    private javax.swing.JLabel lbl_noktp;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_tahun;
    private javax.swing.JLabel lbl_tipe;
    private javax.swing.JLabel lbl_tlp;
    private usu.widget.glass.PanelGlass panelGlass1;
    private usu.widget.glass.PanelGlass panelGlass2;
    private usu.widget.glass.PanelGlass panelGlass3;
    private javax.swing.JTable table_transaksi;
    private javax.swing.JTextField txt_lama;
    private javax.swing.JLabel txt_total;
    // End of variables declaration//GEN-END:variables

}
