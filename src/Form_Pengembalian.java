import Database.KoneksiDatabase;
import Database.ResultSetTable;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.PrintJob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author User
 */
public class Form_Pengembalian extends javax.swing.JInternalFrame {
    ResultSet rs;
    KoneksiDatabase con;
    String status1;
    /**
     * Creates new form Form_Pengembalian
     */
    public Form_Pengembalian() {
        initComponents();
        con = new KoneksiDatabase(new Database.Parameter().HOST_DB, new Database.Parameter().USERNAME_DB, new Database.Parameter().PASSWORD_DB);
        loadTabel();
        loadMobil();
    }
     private void loadMobil() {  // mengambil database
    // Mengambil data dari database tabel "tb_transaksi"
    rs = con.querySelectAll("tb_transaksi");
    try {
        // Melakukan iterasi untuk setiap baris hasil query
        while (rs.next()) {
            // Menambahkan nomor polisi (nopol) ke dalam ComboBox "boxnopol"
            boxnopol.addItem(rs.getString("nopol"));
        }
    } catch (SQLException ex) {
        // Menangani exception jika terjadi kesalahan SQL
        Logger.getLogger(Form_Pengembalian.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cekstatus() throws SQLException {
    rs = con.querySelectAll("tb_mobil", "nopol ='" + boxnopol.getSelectedItem().toString() + "'");
        
        while (rs.next()) {
            status1 = rs.getString("status");
        }
        
        String update_status = "Tersedia";
        String kolom[] = {"status"};
        String isi[] = {update_status};
        con.queryUpdate("tb_mobil", kolom, isi, "nopol='" + boxnopol.getSelectedItem().toString() + "'");

    }
    

    public void hapus_transaksi() {
        if (JOptionPane.showConfirmDialog(this, "Yakin Mengembalikan Mobil ?", "Peringatan", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            con.queryDelete("tb_transaksi", "nopol='" + boxnopol.getSelectedItem().toString() + "'");
        }

    }

    private void loadTabel() {
        String namaKolom[] = {"id_transaksi", "peminjam", "nopol", "tgl_pinjaman", "tgl_kembali", "harga", "lama", "total"}; //,
        rs = con.querySelect(namaKolom, "tb_transaksi");
        table_transaksi1.setModel(new ResultSetTable(rs)); 
    }
    //METODE UNTUK CETAK LAPORAN
    public void resi() {
    // Membuat objek Login untuk digunakan nanti
    Login su = new Login();

    // Membuat objek PrintJob untuk mencetak laporan
    PrintJob p = getToolkit().getPrintJob(su, "Report", null);
    Graphics g = p.getGraphics();

    try {
        // Mendapatkan nomor polisi dari item yang dipilih
        String n = boxnopol.getSelectedItem().toString();
        
        // Mendapatkan data transaksi dari database berdasarkan nomor polisi
        rs = con.querySelectAll("tb_transaksi", "nopol='" + n + "'");
        // String id = String.valueOf(table_transaksi1.getValueAt(table_transaksi1.getSelectedRow(),0));

        if (rs.next()) {
            // Mendapatkan informasi transaksi
            String id = rs.getString("id_transaksi");
            String nama = rs.getString("peminjam");
            String nom = rs.getString("total");

            // Menggambar garis dan batas laporan
            g.drawLine(10, 75, 580, 75);
            g.drawLine(10, 75, 10, 285);
            g.drawLine(580, 75, 580, 285);
            g.drawLine(10, 285, 580, 285);

            // Menulis nomor transaksi
            g.setFont(new Font("Serif", Font.BOLD, 16));
            g.drawString("No.", 100, 102);
            g.drawString(id, 140, 101);
            g.drawString("_ _ _ _ _ _ _ _", 135, 100);

            // Menulis informasi peminjam
            g.setFont(new Font("Serif", Font.PLAIN, 13));
            g.drawString("Terima Dari", 100, 125);
            g.setFont(new Font("Serif", Font.BOLD, 14));
            g.drawString(nama, 195, 124);
            g.setFont(new Font("Serif", Font.PLAIN, 13));
            g.drawString("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _", 188, 124);

            // Menulis jumlah uang dalam bentuk terbilang
            g.drawString("Uang Sebanyak", 100, 146);
            g.setColor(java.awt.Color.GRAY);
            for (int i = 0; i <= 6; i++) {
                g.drawString("______________________________________________________", 200 - (i * 2), 135 + (i * 2));
            }
            for (int i = 0; i <= 6; i++) {
                g.drawString("______________________________________________________", 200 - (i * 2), 151 + (i * 2));
            }

            g.setColor(java.awt.Color.BLACK);
            for (int i = 0; i <= 3; i++) {
                g.drawString("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _", 100, 180 + (i * 14));
            }
            // Menggambar garis dan batas terakhir laporan
            g.drawLine(100, 250, 350, 250);
            g.setFont(new Font("Serif", Font.BOLD, 12));
            g.drawString("Terbilang Rp. ", 100, 264);
            g.setFont(new Font("Serif", Font.BOLD, 14));
            g.drawString(nom, 205, 264);
            for (int i = 0; i <= 6; i++) {
                g.setColor(java.awt.Color.GRAY);
                g.drawString("_____________________", 200 - (i * 2), 251 + (i * 2));
            }
            g.setColor(java.awt.Color.BLACK);

            g.drawLine(100, 270, 350, 270);
            g.drawLine(440, 270, 550, 270);

            // Menyelesaikan pekerjaan pencetakan
            p.end();
        } else {
            // Menampilkan pesan jika gagal mencetak
            JOptionPane.showMessageDialog(this, "Gagal Cetak!!");
        }
    } catch (SQLException | HeadlessException e) {
        // Menampilkan pesan kesalahan jika terjadi exception
        JOptionPane.showMessageDialog(this, "Error!!");
    }
    // Menutup form saat selesai mencetak dan membuka Form_Pengembalian
    dispose();
    Form_Pengembalian fm = new Form_Pengembalian();
    fm.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btncetakresi = new usu.widget.ButtonGlass();
        btnkembalikanmobil = new usu.widget.ButtonGlass();
        btndatapegawai = new usu.widget.ButtonGlass();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_transaksi1 = new javax.swing.JTable();
        panelGlass2 = new usu.widget.glass.PanelGlass();
        jLabel36 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lbl_harga = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_Lama = new javax.swing.JLabel();
        boxnopol = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_nama = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        lbl_tgl_peminjaman = new javax.swing.JLabel();
        lbl_tgl_kembali = new javax.swing.JLabel();
        lbl_hari = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_transaksi = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_total = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Lucida Fax", 1, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 255));
        jLabel15.setText("PENGEMBALIAN MOBIL");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Britannic Bold", 2, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("AL");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 630, -1, -1));

        jLabel5.setFont(new java.awt.Font("Britannic Bold", 0, 48)); // NOI18N
        jLabel5.setText("FATIH");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 630, -1, -1));

        btncetakresi.setForeground(new java.awt.Color(0, 51, 255));
        btncetakresi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-printer2-40.png"))); // NOI18N
        btncetakresi.setText("CETAK RESI PEMBAYARAN");
        btncetakresi.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btncetakresi.setMaximumSize(new java.awt.Dimension(200, 47));
        btncetakresi.setMinimumSize(new java.awt.Dimension(200, 47));
        btncetakresi.setOpaque(true);
        btncetakresi.setRoundRect(true);
        btncetakresi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetakresiActionPerformed(evt);
            }
        });
        getContentPane().add(btncetakresi, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, -1, 60));

        btnkembalikanmobil.setBorder(null);
        btnkembalikanmobil.setForeground(new java.awt.Color(0, 51, 255));
        btnkembalikanmobil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-back-40 (1).png"))); // NOI18N
        btnkembalikanmobil.setText("KEMBALIKAN MOBIL");
        btnkembalikanmobil.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnkembalikanmobil.setOpaque(true);
        btnkembalikanmobil.setRoundRect(true);
        btnkembalikanmobil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembalikanmobilActionPerformed(evt);
            }
        });
        getContentPane().add(btnkembalikanmobil, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, -1, 60));

        btndatapegawai.setForeground(new java.awt.Color(0, 51, 255));
        btndatapegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/BtnKTP.png"))); // NOI18N
        btndatapegawai.setText("DATA PEMINJAM");
        btndatapegawai.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btndatapegawai.setOpaque(true);
        btndatapegawai.setRoundRect(true);
        btndatapegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndatapegawaiActionPerformed(evt);
            }
        });
        getContentPane().add(btndatapegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 390, 240, 60));

        table_transaksi1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        table_transaksi1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        table_transaksi1.setForeground(new java.awt.Color(0, 51, 255));
        table_transaksi1.setModel(new javax.swing.table.DefaultTableModel(
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
        table_transaksi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_transaksi1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_transaksi1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 1070, 170));

        panelGlass2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        panelGlass2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 51, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("LAMA PINJAMAN");
        panelGlass2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 120, -1));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 51, 255));
        jLabel33.setText("HARGA(/HARI)");
        panelGlass2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 153));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText(":");
        panelGlass2.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 17, -1));

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 51, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText(":");
        panelGlass2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 16, -1));

        lbl_harga.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_harga.setForeground(new java.awt.Color(0, 51, 255));
        lbl_harga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_harga.setText("Label Harga");
        panelGlass2.add(lbl_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 79, -1));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText(":");
        panelGlass2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 14, -1));

        lbl_Lama.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_Lama.setForeground(new java.awt.Color(0, 51, 255));
        lbl_Lama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Lama.setText("Lama");
        panelGlass2.add(lbl_Lama, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, -1, -1));

        boxnopol.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        boxnopol.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        boxnopol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxnopolActionPerformed(evt);
            }
        });
        panelGlass2.add(boxnopol, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 200, -1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 255));
        jLabel9.setText("NO. POLISI");
        panelGlass2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        panelGlass2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 110, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 255));
        jLabel10.setText("NAMA PEMNJAM");
        panelGlass2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText(":");
        panelGlass2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 14, -1));

        lbl_nama.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_nama.setForeground(new java.awt.Color(0, 51, 255));
        lbl_nama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nama.setText("Label Nama");
        panelGlass2.add(lbl_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 51, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("TANGGAL PEMINJAMAN");
        panelGlass2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 51, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("TANGGAL PENGEMBALIAN");
        panelGlass2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, -1));

        jLabel37.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 153));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText(":");
        panelGlass2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 16, -1));

        jLabel39.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 153));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText(":");
        panelGlass2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 12, -1));

        lbl_tgl_peminjaman.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_tgl_peminjaman.setForeground(new java.awt.Color(0, 51, 255));
        lbl_tgl_peminjaman.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tgl_peminjaman.setText("Label Peminjaman");
        panelGlass2.add(lbl_tgl_peminjaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 120, -1));

        lbl_tgl_kembali.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_tgl_kembali.setForeground(new java.awt.Color(0, 51, 255));
        lbl_tgl_kembali.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tgl_kembali.setText("Label Kembali");
        panelGlass2.add(lbl_tgl_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 100, -1));

        lbl_hari.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lbl_hari.setForeground(new java.awt.Color(0, 51, 255));
        lbl_hari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_hari.setText("/HARI");
        panelGlass2.add(lbl_hari, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, -1, -1));

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

        panelGlass2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 940, 210));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("TOTAL");
        panelGlass2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("RP.");
        panelGlass2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 70, -1, -1));

        lbl_total.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_total.setForeground(new java.awt.Color(204, 0, 0));
        lbl_total.setText("Tagihan");
        panelGlass2.add(lbl_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 60, 70, 50));

        getContentPane().add(panelGlass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 1070, 160));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bgputih1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxnopolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxnopolActionPerformed
    // Mendapatkan nilai terpilih dari boxnopol
    String selectedNopol = (String) boxnopol.getSelectedItem();
    // Mengambil data dari tabel tb_transaksi berdasarkan nomor polisi (nopol) terpilih
    ResultSet rst = con.querySelectAll("tb_transaksi", "nopol='" + selectedNopol + "'");
    try {
        // Melakukan iterasi pada hasil query
        while (rst.next()) {
            // Menetapkan nilai ke label-label yang sesuai dengan data dari hasil query
            this.lbl_nama.setText(rst.getString("peminjam"));
            this.lbl_tgl_kembali.setText(rst.getString("tgl_kembali"));
            this.lbl_tgl_peminjaman.setText(rst.getString("tgl_pinjaman"));
            this.lbl_Lama.setText(rst.getString("lama"));
            this.lbl_harga.setText(rst.getString("harga"));
            this.lbl_total.setText(rst.getString("total"));
        }
    } catch (SQLException ex) {
        // Menangani exception jika terjadi kesalahan SQL
        Logger.getLogger(Form_Pengembalian.class.getName()).log(Level.SEVERE, null, ex);
}
    }//GEN-LAST:event_boxnopolActionPerformed

    private void btnkembalikanmobilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembalikanmobilActionPerformed
    try {
        // Memanggil metode untuk menghapus transaksi
        hapus_transaksi();
        // Memanggil metode untuk mengecek status mobil dan mengupdate informasinya
        cekstatus();       
        // Memuat ulang tabel setelah proses pengembalian mobil
        loadTabel();
    } catch (SQLException ex) {
        // Menangani kesalahan yang mungkin terjadi selama proses
        Logger.getLogger(Form_Pengembalian.class.getName()).log(Level.SEVERE, null, ex);
    }
   }//GEN-LAST:event_btnkembalikanmobilActionPerformed

    private void btndatapegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatapegawaiActionPerformed
    // Membersihkan jDesktopPane sebelum menampilkan Data_Peminjam baru
    Home.jDesktopPane1.removeAll();   // Menghapus semua komponen yang ada di dalam jDesktopPane
    Home.jDesktopPane1.repaint();     // Melakukan repaint agar tampilan jDesktopPane bersih dan segar
    // Membuat instance baru dari Data_Peminjam
    Data_Peminjam dp = new Data_Peminjam();
    // Menghapus teks dari komponen teks di dalam Data_Peminjam
    dp.clearTextFields();
    // Menampilkan Data_Peminjam
    dp.setVisible(true);
    // Menambahkan Data_Peminjam ke dalam jDesktopPane
    Home.jDesktopPane1.add(dp);
    }//GEN-LAST:event_btndatapegawaiActionPerformed

    private void btncetakresiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetakresiActionPerformed
        resi();
    }//GEN-LAST:event_btncetakresiActionPerformed

    private void table_transaksi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_transaksi1MouseClicked
    // Set nilai pada label dan ComboBox berdasarkan baris yang dipilih di tabel
    lbl_nama.setText(String.valueOf(table_transaksi1.getValueAt(table_transaksi1.getSelectedRow(), 1)));
    boxnopol.setSelectedItem(String.valueOf(table_transaksi1.getValueAt(table_transaksi1.getSelectedRow(), 2)));
    lbl_tgl_peminjaman.setText(String.valueOf(table_transaksi1.getValueAt(table_transaksi1.getSelectedRow(), 3)));
    lbl_tgl_kembali.setText(String.valueOf(table_transaksi1.getValueAt(table_transaksi1.getSelectedRow(), 4)));
    lbl_harga.setText(String.valueOf(table_transaksi1.getValueAt(table_transaksi1.getSelectedRow(), 5)));
    lbl_Lama.setText(String.valueOf(table_transaksi1.getValueAt(table_transaksi1.getSelectedRow(), 6)));
    lbl_total.setText(String.valueOf(table_transaksi1.getValueAt(table_transaksi1.getSelectedRow(), 7)));
    }//GEN-LAST:event_table_transaksi1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox boxnopol;
    private usu.widget.ButtonGlass btncetakresi;
    private usu.widget.ButtonGlass btndatapegawai;
    private usu.widget.ButtonGlass btnkembalikanmobil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Lama;
    private javax.swing.JLabel lbl_harga;
    private javax.swing.JLabel lbl_hari;
    private javax.swing.JLabel lbl_nama;
    private javax.swing.JLabel lbl_tgl_kembali;
    private javax.swing.JLabel lbl_tgl_peminjaman;
    private javax.swing.JLabel lbl_total;
    private usu.widget.glass.PanelGlass panelGlass2;
    private javax.swing.JTable table_transaksi;
    private javax.swing.JTable table_transaksi1;
    // End of variables declaration//GEN-END:variables

 
}
