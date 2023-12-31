import Database.KoneksiDatabase;
import Database.ResultSetTable;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Add_Car extends javax.swing.JInternalFrame {
    private void loadTabel() {
    String namaKolom[] = {"id_mobil","merek","tipe","tahun","nopol","harga","status"};
    rs=con.querySelect(namaKolom,"tb_mobil");
    tablemobil.setModel(new ResultSetTable(rs));
    }
    // Metode untuk membersihkan nilai elemen-elemen input
    private void clear() {
    // Mengosongkan nilai dari elemen-elemen input
    id.setText("");
    merek.setText("");
    tipe.setText("");
    tahun.setSelectedItem("2012");
    nopol.setText("");
    harga.setText("");
    }
    // Metode untuk me REFRESH teks dari komponen teks di dalam form
    public void Refresh() {
        id.setText("");
        merek.setText("");
        tipe.setText("");
        nopol.setText("");
        harga.setText("");
        tahun.setSelectedItem("");
        status.setSelectedIndex(0); 
        Cari.setText("");
    }
    ResultSet rs;
    KoneksiDatabase con;
    
    /**
     * Creates new form Add_Car
     */
    public Add_Car() {
        initComponents();    
        con =new KoneksiDatabase(new Database.Parameter().HOST_DB,new Database.Parameter().USERNAME_DB,new Database.Parameter().PASSWORD_DB);
        loadTabel();         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGlass1 = new usu.widget.glass.PanelGlass();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        merek = new javax.swing.JTextField();
        tipe = new javax.swing.JTextField();
        tahun = new javax.swing.JComboBox();
        nopol = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnTambah = new usu.widget.ButtonGlass();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablemobil = new javax.swing.JTable();
        btnedit = new usu.widget.ButtonGlass();
        btnhapus = new usu.widget.ButtonGlass();
        btnrefresh = new usu.widget.ButtonGlass();
        Cari = new javax.swing.JTextField();
        btncari = new usu.widget.ButtonGlass();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelGlass1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setText("TAHUN PRODUKSI");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setText("TYPE MOBIL");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setText("KODE MOBIL");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 255));
        jLabel7.setText("NO. POLISI");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("HARGA SEWA");

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 255));
        jLabel10.setText(":");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 255));
        jLabel11.setText(":");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 255));
        jLabel13.setText(":");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText(":");

        merek.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        merek.setForeground(new java.awt.Color(0, 51, 255));
        merek.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        merek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                merekActionPerformed(evt);
            }
        });

        tipe.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tipe.setForeground(new java.awt.Color(0, 51, 255));
        tipe.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tahun.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tahun.setForeground(new java.awt.Color(0, 51, 255));
        tahun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000" }));
        tahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tahunActionPerformed(evt);
            }
        });

        nopol.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        nopol.setForeground(new java.awt.Color(0, 51, 255));
        nopol.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nopol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nopolActionPerformed(evt);
            }
        });

        harga.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        harga.setForeground(new java.awt.Color(0, 51, 255));
        harga.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 255));
        jLabel8.setText("STATUS");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 255));
        jLabel9.setText(":");

        status.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        status.setForeground(new java.awt.Color(0, 51, 255));
        status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TERSEDIA", "KELUAR" }));
        status.setToolTipText("");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/TambahMobil_(1)-transformed.png"))); // NOI18N

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 255));
        jLabel17.setText(":");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 255));
        jLabel19.setText("MEREK MOBIL");

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 255));
        jLabel20.setText(":");

        id.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        id.setForeground(new java.awt.Color(0, 51, 255));
        id.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout panelGlass1Layout = new javax.swing.GroupLayout(panelGlass1);
        panelGlass1.setLayout(panelGlass1Layout);
        panelGlass1Layout.setHorizontalGroup(
            panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelGlass1Layout.createSequentialGroup()
                                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelGlass1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nopol, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelGlass1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelGlass1Layout.createSequentialGroup()
                                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelGlass1Layout.createSequentialGroup()
                                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelGlass1Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGlass1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                            .addComponent(merek)
                            .addComponent(tipe))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        panelGlass1Layout.setVerticalGroup(
            panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(merek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(tipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel17)
                            .addComponent(tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel7)
                            .addComponent(nopol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGlass1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel8))
                            .addGroup(panelGlass1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        getContentPane().add(panelGlass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 1040, 260));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Lucida Fax", 1, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 255));
        jLabel15.setText("TAMBAH MOBIL");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Logo (1).png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Britannic Bold", 2, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("AL");

        jLabel14.setFont(new java.awt.Font("Britannic Bold", 0, 48)); // NOI18N
        jLabel14.setText("FATIH");

        btnTambah.setForeground(new java.awt.Color(0, 51, 255));
        btnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-add-40.png"))); // NOI18N
        btnTambah.setText("TAMBAH");
        btnTambah.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnTambah.setOpaque(true);
        btnTambah.setRoundRect(true);
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        tablemobil.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        tablemobil.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tablemobil.setForeground(new java.awt.Color(0, 51, 255));
        tablemobil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Merek Mobil", "Type Mobil", "Tahun Produksi", "No. Polisi", "Harga Sewa", "Status"
            }
        ));
        tablemobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablemobilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablemobil);

        btnedit.setForeground(new java.awt.Color(0, 51, 255));
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/pencil_edit.png"))); // NOI18N
        btnedit.setText("EDIT");
        btnedit.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnedit.setOpaque(true);
        btnedit.setRoundRect(true);
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

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

        btnrefresh.setForeground(new java.awt.Color(0, 51, 255));
        btnrefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-refresh-40 (1).png"))); // NOI18N
        btnrefresh.setText("Refresh");
        btnrefresh.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnrefresh.setOpaque(true);
        btnrefresh.setRoundRect(true);
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });

        Cari.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Cari.setForeground(new java.awt.Color(0, 51, 255));
        Cari.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btncari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/search_lense.png"))); // NOI18N
        btncari.setOpaque(true);
        btncari.setRoundRect(true);
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(301, 301, 301)
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, 951, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel14))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(496, 496, 496)
                                    .addComponent(btnrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)))
                .addGap(285, 285, 285)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnedit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
      try {
        // Memeriksa apakah semua input diberikan sebelum melakukan penyuntingan data
        if (!id.getText().isEmpty() && !merek.getText().isEmpty() &&
        !tipe.getText().isEmpty() && !nopol.getText().isEmpty() &&
        !harga.getText().isEmpty()) {
        // Mengumpulkan nilai dari elemen-elemen input dan menyiapkannya untuk pembaruan
        String kolom[] = {"id_mobil", "merek", "tipe", "tahun", "nopol", "harga", "status"};
        String isi[] = {
            id.getText(),
            merek.getText(),
            tipe.getText(),
            tahun.getSelectedItem().toString(),
            nopol.getText(),
            harga.getText(),
            status.getSelectedItem().toString()
        };
        // Melakukan pembaruan data pada tabel 'tb_mobil' berdasarkan id_mobil tertentu
        con.queryUpdate("tb_mobil", kolom, isi,
            "id_mobil='" + String.valueOf(tablemobil.getValueAt(tablemobil.getSelectedRow(), 0)) + "'");
        // Menampilkan pesan sukses setelah berhasil menyunting data
        JOptionPane.showMessageDialog(this, "Data Berhasil Diedit");
    } else {
        // Menampilkan pesan kesalahan jika ada data isian yang kosong
        JOptionPane.showMessageDialog(this, "Data isian ada yang kosong");
    }
    } catch (Exception e) {
    // Menampilkan pesan kesalahan jika terjadi masalah saat menyunting data
    JOptionPane.showMessageDialog(this, "Error mengedit data: " + e.getMessage());
    }
    // Memuat ulang tabel setelah pembaruan data
    loadTabel();
    // Mengosongkan input setelah pembaruan
    clear();
    }//GEN-LAST:event_btneditActionPerformed

    private void nopolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nopolActionPerformed
       
    }//GEN-LAST:event_nopolActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        try {
        // Memeriksa apakah semua input diberikan sebelum menyimpan data
        if (!id.getText().isEmpty() &&
            !merek.getText().isEmpty() &&
            !tipe.getText().isEmpty() &&
            !nopol.getText().isEmpty() &&
            !harga.getText().isEmpty()) {
            // Menyiapkan data untuk disimpan ke dalam tabel
            String kolom[] = {"id_mobil", "merek", "tipe", "tahun", "nopol", "harga", "status"};
            String isi[] = {
                id.getText(),
                merek.getText(),
                tipe.getText(),
                tahun.getSelectedItem().toString(),
                nopol.getText(),
                harga.getText(),
                status.getSelectedItem().toString()
            };
            // Memanggil metode queryInsert untuk menyimpan data ke dalam tabel
            String numRowsAffected = con.queryInsert("tb_mobil", kolom, isi);
            // Menampilkan jumlah baris yang berhasil disimpan (opsional)
            System.out.println(numRowsAffected + " baris berhasil disimpan");
            // Menampilkan pesan sukses setelah berhasil menyimpan data
            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
        } else {
            // Menampilkan pesan kesalahan jika ada data isian yang kosong
            JOptionPane.showMessageDialog(this, "Data isian ada yang kosong");
        } 
    } catch (Exception e) {
        // Menampilkan pesan kesalahan jika terjadi masalah saat menyimpan data
        JOptionPane.showMessageDialog(this, "Error input data: " + e.getMessage());
        System.out.println("salah");
    }
    // Memuat ulang tabel setelah menyimpan data
    loadTabel();
    // Mengosongkan input setelah penyimpanan data
    clear();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
      if (Cari.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Isikan data pencarian");
    } else {
        try {
            // Melakukan pencarian data berdasarkan kriteria tertentu
            String keyword = Cari.getText();
            String query = "id_mobil LIKE '%" + keyword + "%' OR merek LIKE '%" + keyword + "%' OR tipe LIKE '%" + keyword + "%' OR nopol LIKE '%" + keyword + "%' OR harga LIKE '%" + keyword + "%' OR tahun LIKE '%" + keyword + "%'";
            rs = con.querySelectAll("tb_mobil", query);
            // Menampilkan hasil pencarian pada tabel
            tablemobil.setModel(new Database.ResultSetTable(rs));
        } catch (Exception e) {
            // Menampilkan pesan kesalahan jika terjadi masalah saat pencarian
            JOptionPane.showMessageDialog(this, "Pencarian Error: " + e.getMessage());
        }
    }
    // Mengosongkan input setelah pencarian
    clear();
    }//GEN-LAST:event_btncariActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
      try {
        // Memeriksa apakah ada baris yang dipilih sebelum menghapus
        if (tablemobil.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris terlebih dahulu");
            return;
        }
        // Menampilkan dialog konfirmasi sebelum menghapus
        if (JOptionPane.showConfirmDialog(this, "Yakin menghapus data?", "Peringatan", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            // Menghapus data berdasarkan id_mobil
            con.queryDelete("tb_mobil", "id_mobil='" + id.getText() + "'");
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
        } else {
            // Pengguna membatalkan penghapusan
            return;
        }
    } catch (Exception e) {
        // Menampilkan pesan kesalahan jika terjadi masalah saat menghapus data
        JOptionPane.showMessageDialog(this, "Error menghapus data: " + e.getMessage());
    }
    // Memuat ulang tabel setelah menghapus data
    loadTabel();
    // Mengosongkan input setelah penghapusan data
    clear();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        loadTabel();
        Refresh();
    }//GEN-LAST:event_btnrefreshActionPerformed

    private void tablemobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablemobilMouseClicked
    // Memeriksa apakah ada baris yang dipilih sebelum mengambil data
    if (tablemobil.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(this, "Pilih baris terlebih dahulu");
        return;
    }
    // Mengisi elemen input dengan data dari baris yang dipilih
    id.setText(String.valueOf(tablemobil.getValueAt(tablemobil.getSelectedRow(),0)));
    merek.setText(String.valueOf(tablemobil.getValueAt(tablemobil.getSelectedRow(),1)));
    tipe.setText(String.valueOf( tablemobil.getValueAt(tablemobil.getSelectedRow(),2)));
    tahun.setSelectedItem(String.valueOf(tablemobil.getValueAt(tablemobil.getSelectedRow(),3)));
    nopol.setText(String.valueOf( tablemobil.getValueAt(tablemobil.getSelectedRow(),4)));
    harga.setText(String.valueOf( tablemobil.getValueAt(tablemobil.getSelectedRow(),5)));
    status.setSelectedItem(String.valueOf(tablemobil.getValueAt(tablemobil.getSelectedRow(),6)));
    }//GEN-LAST:event_tablemobilMouseClicked

    private void merekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_merekActionPerformed
        
    }//GEN-LAST:event_merekActionPerformed

    private void tahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tahunActionPerformed
       
    }//GEN-LAST:event_tahunActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cari;
    private usu.widget.ButtonGlass btnTambah;
    private usu.widget.ButtonGlass btncari;
    private usu.widget.ButtonGlass btnedit;
    private usu.widget.ButtonGlass btnhapus;
    private usu.widget.ButtonGlass btnrefresh;
    private javax.swing.JTextField harga;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField merek;
    private javax.swing.JTextField nopol;
    private usu.widget.glass.PanelGlass panelGlass1;
    private javax.swing.JComboBox status;
    private javax.swing.JTable tablemobil;
    private javax.swing.JComboBox tahun;
    private javax.swing.JTextField tipe;
    // End of variables declaration//GEN-END:variables

}
