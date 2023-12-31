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
public class Add_User extends javax.swing.JInternalFrame {
    
    ResultSet rs;
    KoneksiDatabase con;
    
    // Metode untuk memuat data dari database ke dalam tabel
    private void loadTabel() {
    // Menentukan nama kolom yang akan ditampilkan dalam tabel
    String namaKolom[] = {"id_user", "nama", "username", "password", "type"};
    // Mengambil data dari database berdasarkan nama kolom
    rs = con.querySelect(namaKolom, "user");
    // Menetapkan model tabel dengan hasil query dari database
    tabel_user.setModel(new ResultSetTable(rs));
    // Membersihkan field input setelah memuat data
    clear();
    }
    // Metode untuk membersihkan field input
    private void clear() {
    // Mengosongkan field-field input
    id.setText("");
    nama.setText("");
    user.setText("");
    status.setSelectedItem("Owner");
    pass.setText("");
    Cari.setText("");
    }


    /**
     * Creates new form Add_User
     */
    public Add_User() {        
        con =new KoneksiDatabase(new Database.Parameter().HOST_DB,new Database.Parameter().USERNAME_DB,new Database.Parameter().PASSWORD_DB);
        initComponents();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_user = new javax.swing.JTable();
        btntambah = new usu.widget.ButtonGlass();
        btnedit = new usu.widget.ButtonGlass();
        btndelete = new usu.widget.ButtonGlass();
        btnrefresh = new usu.widget.ButtonGlass();
        panelGlass1 = new usu.widget.glass.PanelGlass();
        user = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        btncari = new usu.widget.ButtonGlass();
        Cari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel_user.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        tabel_user.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tabel_user.setForeground(new java.awt.Color(0, 51, 255));
        tabel_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nama", "Username", "Password", "Type"
            }
        ));
        tabel_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_userMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_user);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 1020, 210));

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
        getContentPane().add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 130, -1));

        btnedit.setForeground(new java.awt.Color(0, 51, 255));
        btnedit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/pencil_edit.png"))); // NOI18N
        btnedit.setText("EDIT");
        btnedit.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnedit.setOpaque(true);
        btnedit.setPreferredSize(new java.awt.Dimension(130, 47));
        btnedit.setRoundRect(true);
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        getContentPane().add(btnedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 110, -1));

        btndelete.setForeground(new java.awt.Color(0, 51, 255));
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-delete-40.png"))); // NOI18N
        btndelete.setText("HAPUS");
        btndelete.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btndelete.setOpaque(true);
        btndelete.setPreferredSize(new java.awt.Dimension(130, 47));
        btndelete.setRoundRect(true);
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 140, -1));

        btnrefresh.setForeground(new java.awt.Color(0, 51, 255));
        btnrefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-refresh-40 (1).png"))); // NOI18N
        btnrefresh.setText("REFRESH");
        btnrefresh.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btnrefresh.setOpaque(true);
        btnrefresh.setRoundRect(true);
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btnrefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 400, 140, -1));

        panelGlass1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));

        user.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        user.setForeground(new java.awt.Color(0, 51, 255));
        user.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        nama.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        nama.setForeground(new java.awt.Color(0, 51, 255));
        nama.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        pass.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        pass.setForeground(new java.awt.Color(0, 51, 255));
        pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 255));
        jLabel2.setText("ID USER           :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setText("USERNAME      :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setText("PASSWORD     :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 255));
        jLabel5.setText("STATUS            :");

        status.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        status.setForeground(new java.awt.Color(0, 51, 255));
        status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Owner", "Admin" }));
        status.setToolTipText("");
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/user_add (1) (1).png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 255));
        jLabel8.setText("NAMA              :");

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
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(id, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(68, 68, 68))))
        );
        panelGlass1Layout.setVerticalGroup(
            panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGlass1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelGlass1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(panelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(panelGlass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 930, 200));

        jLabel15.setFont(new java.awt.Font("Lucida Fax", 1, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 255));
        jLabel15.setText("TAMBAH USER");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, -1, -1));

        btncari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/search_lense.png"))); // NOI18N
        btncari.setRoundRect(true);
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });
        getContentPane().add(btncari, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 460, -1, -1));

        Cari.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Cari.setForeground(new java.awt.Color(0, 51, 255));
        Cari.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(Cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 970, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/bgputih1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -90, -1, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        try {
        // Memeriksa apakah semua field isian sudah diisi
        if (!id.getText().isEmpty() && !nama.getText().isEmpty() && !user.getText().isEmpty() && !pass.getText().isEmpty()) {
            // Menyiapkan array kolom dan isi untuk proses update
            String kolom[] = {"id_user", "nama", "username", "password", "type"};
            String isi[] = {id.getText(), nama.getText(), user.getText(), pass.getText(), status.getSelectedItem().toString()};
            // Mendapatkan ID dari baris yang dipilih di tabel
            String selectedUserId = String.valueOf(tabel_user.getValueAt(tabel_user.getSelectedRow(), 0));
            // Melakukan proses update data
            con.queryUpdate("user", kolom, isi, "id_user='" + selectedUserId + "'");
            // Menampilkan pesan sukses
            JOptionPane.showMessageDialog(this, "Data Berhasil Diedit");
        } else {
            // Menampilkan pesan jika ada field yang kosong
            JOptionPane.showMessageDialog(this, "Data isian ada yang kosong");
        }
    } catch (Exception e) {
        // Menampilkan pesan kesalahan jika terjadi error
        JOptionPane.showMessageDialog(this, "Error edit data");
    }
    // Memuat ulang tabel setelah proses edit data
    loadTabel();
    // Membersihkan input setelah proses edit data
    clear();
    }//GEN-LAST:event_btneditActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
    try {
        // Memeriksa apakah semua field isian sudah diisi sebelum melakukan input data
    if (!nama.getText().isEmpty() && !user.getText().isEmpty() && !pass.getText().isEmpty()) {
        // Menyiapkan array kolom dan isi untuk proses insert data ke tabel 'user'
        String kolom[] = {"id_user", "nama", "username", "password", "type"};
        String isi[] = {id.getText(), nama.getText(), user.getText(), pass.getText(), status.getSelectedItem().toString()};
        // Menjalankan fungsi queryInsert() untuk memasukkan data baru ke tabel 'user' dan mendapatkan ID yang baru ditambahkan
        System.out.println(con.queryInsert("user", kolom, isi));
        // Menampilkan pesan sukses setelah data berhasil ditambahkan
        JOptionPane.showMessageDialog(this, "User Berhasil ditambahkan");
    } else {
        // Menampilkan pesan jika ada field isian yang kosong
        JOptionPane.showMessageDialog(this, "Data User Masih ada yang Kosong");
    }
    } catch (Exception e) {
    // Menangani exception yang mungkin terjadi, misalnya jika terjadi kesalahan dalam proses input data
    JOptionPane.showMessageDialog(this, "Error input data");
    System.out.println("salah");
    }
    // Memuat ulang tabel setelah proses input data
    loadTabel();
    // Membersihkan input setelah proses input data
    clear();
    }//GEN-LAST:event_btntambahActionPerformed

    private void tabel_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_userMouseClicked
       id.setText(String.valueOf(tabel_user.getValueAt(tabel_user.getSelectedRow(),0)));
       nama.setText(String.valueOf(tabel_user.getValueAt(tabel_user.getSelectedRow(),1)));
       user.setText(String.valueOf( tabel_user.getValueAt(tabel_user.getSelectedRow(),2)));
       pass.setText(String.valueOf( tabel_user.getValueAt(tabel_user.getSelectedRow(),3)));
       status.setSelectedItem(String.valueOf(tabel_user.getValueAt(tabel_user.getSelectedRow(),4)));
    }//GEN-LAST:event_tabel_userMouseClicked

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
    try {
        // Memeriksa apakah ID sudah diisi sebelum melakukan penghapusan
        if (!id.getText().isEmpty()) {
            // Konfirmasi pengguna untuk menghapus data
            int option = JOptionPane.showConfirmDialog(this, "Yakin menghapus data?", "Peringatan", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                // Melakukan penghapusan data jika pengguna menekan tombol OK
                con.queryDelete("user", "id_user='" + id.getText() + "'");
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            } else {
                // Kembali jika pengguna membatalkan penghapusan
                return;
            }
        } else {
            // Menampilkan pesan jika ID belum diisi
            JOptionPane.showMessageDialog(this, "Pilih ID terlebih dahulu");
        }
    } catch (Exception e) {
        // Menampilkan pesan kesalahan jika terjadi error
        JOptionPane.showMessageDialog(this, "Error hapus data");
    }
    // Memuat ulang tabel setelah penghapusan data
    loadTabel();
    // Membersihkan input setelah penghapusan data
    clear();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
         loadTabel();
    }//GEN-LAST:event_btnrefreshActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
    // Memeriksa apakah field pencarian kosong
    if (Cari.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Isikan data pencarian");
    } else {
        try {
            // Menyiapkan array kolom yang akan dicari
            String kolom[] = {"nama", "username", "type"};
            // Melakukan query pencarian dengan menggunakan fungsi querySelect
            rs = con.querySelect(kolom, "user", "nama LIKE '%" + Cari.getText() + "%' OR type LIKE '%" + Cari.getText() + "%'");
            // Menetapkan model tabel dengan hasil pencarian
            tabel_user.setModel(new Database.ResultSetTable(rs));
        } catch (Exception e) {
            // Menangani exception yang mungkin terjadi selama proses pencarian
            JOptionPane.showMessageDialog(this, "Pencarian Error");
        }
    }
    // Membersihkan field pencarian setelah proses pencarian
    clear();
    }//GEN-LAST:event_btncariActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed

    }//GEN-LAST:event_statusActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cari;
    private usu.widget.ButtonGlass btncari;
    private usu.widget.ButtonGlass btndelete;
    private usu.widget.ButtonGlass btnedit;
    private usu.widget.ButtonGlass btnrefresh;
    private usu.widget.ButtonGlass btntambah;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nama;
    private usu.widget.glass.PanelGlass panelGlass1;
    private javax.swing.JPasswordField pass;
    private javax.swing.JComboBox status;
    private javax.swing.JTable tabel_user;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables

}
