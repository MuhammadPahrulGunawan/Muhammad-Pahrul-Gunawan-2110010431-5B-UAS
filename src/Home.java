import javax.swing.ImageIcon;
/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author User
 */
public class Home extends javax.swing.JFrame {
     //metode untuk owner
    public void owner() {
        btn_addcar.setVisible(true);
        btn_formPeminjam.setVisible(true);
        btn_adduser.setVisible(true);
        btn_logout.setVisible(true);
        btn_login.setVisible(false);
        btn_hargasewa.setVisible(false);
        btn_formPengembalian.setVisible(true);
        btn_cetak.setVisible(true);
        btn_about.setVisible(false);
    }
    //metode untuk user
    public void user() {
        btn_addcar.setVisible(true);
        btn_formPeminjam.setVisible(true);
        btn_adduser.setVisible(false);
        btn_logout.setVisible(true);
        btn_hargasewa.setVisible(false);
        btn_login.setVisible(false);
        btn_formPengembalian.setVisible(true);
        btn_cetak.setVisible(true);
        btn_about.setVisible(false);
    }

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        btn_logout.setVisible(false);
        btn_addcar.setVisible(false);
        btn_formPeminjam.setVisible(false);
        btn_adduser.setVisible(false);
        btn_formPengembalian.setVisible(false);
        btn_cetak.setVisible(false);
        btn_about.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new BG();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_formPeminjam = new usu.widget.ButtonGlass();
        btn_adduser = new usu.widget.ButtonGlass();
        btn_login = new usu.widget.ButtonGlass();
        btn_logout = new usu.widget.ButtonGlass();
        btn_exit = new usu.widget.ButtonGlass();
        btn_formPengembalian = new usu.widget.ButtonGlass();
        btn_addcar = new usu.widget.ButtonGlass();
        btn_about = new usu.widget.ButtonGlass();
        btn_cetak = new usu.widget.ButtonGlass();
        btn_hargasewa = new usu.widget.ButtonGlass();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APLIKASI RENTAL MOBIL V.25.05\n");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkStartColor(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/sss.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Britannic Bold", 2, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("AL");

        jLabel3.setFont(new java.awt.Font("Britannic Bold", 0, 48)); // NOI18N
        jLabel3.setText("FATIH");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 0));
        jLabel4.setText("RENTAL MOBIL");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Logo (1).png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Lucida Fax", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Create By :");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("MUHAMMAD PAHRUL GUNAWAN");

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap(345, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addGap(369, 369, 369))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(294, 294, 294))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(69, 69, 69))
        );

        jDesktopPane1.add(kGradientPanel2);
        kGradientPanel2.setBounds(-10, 0, 1130, 780);

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 1250, 760));

        btn_formPeminjam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/pinjam.png"))); // NOI18N
        btn_formPeminjam.setText("PINJAM MOBIL");
        btn_formPeminjam.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btn_formPeminjam.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_formPeminjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_formPeminjamActionPerformed(evt);
            }
        });
        getContentPane().add(btn_formPeminjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 210, 80));

        btn_adduser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-add-user-64.png"))); // NOI18N
        btn_adduser.setText("TAMBAH USER");
        btn_adduser.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btn_adduser.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_adduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adduserActionPerformed(evt);
            }
        });
        getContentPane().add(btn_adduser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 210, 80));

        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-login-52.png"))); // NOI18N
        btn_login.setText("LOG IN");
        btn_login.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btn_login.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        getContentPane().add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 210, 80));

        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-back-40 (1).png"))); // NOI18N
        btn_logout.setText("KEMBALI");
        btn_logout.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btn_logout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 210, 80));

        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-exit-64.png"))); // NOI18N
        btn_exit.setText("EXIT");
        btn_exit.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btn_exit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        getContentPane().add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, 210, 80));

        btn_formPengembalian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/kembali.png"))); // NOI18N
        btn_formPengembalian.setText("PENGEMBALIAN MOBIL");
        btn_formPengembalian.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btn_formPengembalian.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_formPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_formPengembalianActionPerformed(evt);
            }
        });
        getContentPane().add(btn_formPengembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 210, 80));

        btn_addcar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-add-car-64.png"))); // NOI18N
        btn_addcar.setText("TAMBAH MOBIL");
        btn_addcar.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btn_addcar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_addcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addcarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_addcar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 210, 80));

        btn_about.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-about-64.png"))); // NOI18N
        btn_about.setText("ABOUT");
        btn_about.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btn_about.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aboutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_about, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 210, 80));

        btn_cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons8-printer-64.png"))); // NOI18N
        btn_cetak.setText("CETAK LAPORAN");
        btn_cetak.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btn_cetak.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cetakActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 210, 80));

        btn_hargasewa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/hargasewa.png"))); // NOI18N
        btn_hargasewa.setText("HARGA SEWA");
        btn_hargasewa.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        btn_hargasewa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_hargasewa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hargasewaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_hargasewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 210, 70));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/WALPAPER (1).jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 310, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_adduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adduserActionPerformed
        // Hapus semua komponen dari jDesktopPane1
        jDesktopPane1.removeAll();
        // Perbarui tampilan jDesktopPane1
        jDesktopPane1.repaint();
        // Buat instance baru dari Add_User
        Add_User fm = new Add_User();
        // Atur properti atau lakukan inisialisasi yang diperlukan untuk fm
        // Buat frame Add_User terlihat
        fm.setVisible(true);
        // Tambahkan frame Add_User ke jDesktopPane1
        jDesktopPane1.add(fm);
    }//GEN-LAST:event_btn_adduserActionPerformed

    private void btn_formPeminjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_formPeminjamActionPerformed
        // Hapus semua komponen dari jDesktopPane1
        jDesktopPane1.removeAll();
        // Repaint (menggambar ulang) jDesktopPane1 agar tampilan bersih
        jDesktopPane1.repaint();
        // Buat instance baru dari Form_Peminjam
        Form_Peminjam fm = new Form_Peminjam();
        // Buat frame Form_Peminjam terlihat
        fm.setVisible(true);
        // Tambahkan frame Form_Peminjam ke jDesktopPane1
        jDesktopPane1.add(fm);
    }//GEN-LAST:event_btn_formPeminjamActionPerformed

    private void btn_addcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addcarActionPerformed
        // Hapus semua komponen dari jDesktopPane1
        jDesktopPane1.removeAll();
        // Repaint (menggambar ulang) jDesktopPane1 agar tampilan bersih
        jDesktopPane1.repaint();
        // Buat instance baru dari Add_Car
        Add_Car fm = new Add_Car();
        // Buat frame Add_Car terlihat
        fm.setVisible(true);
        // Tambahkan frame Add_Car ke jDesktopPane1
        jDesktopPane1.add(fm); 
    }//GEN-LAST:event_btn_addcarActionPerformed

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        // Melakukan repaint pada jDesktopPane1 (mungkin untuk membersihkan tampilan sebelum berganti jendela)
        jDesktopPane1.repaint();
        // Menutup atau membuang frame atau window saat ini 
        dispose();
        // Membuat instance baru dari kelas Login
        Login fm = new Login();
        // Menetapkan frame Login agar terlihat atau tampil di layar
        fm.setVisible(true);

    }//GEN-LAST:event_btn_loginActionPerformed

    private void btn_formPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_formPengembalianActionPerformed
        // Menghapus semua komponen yang ada di jDesktopPane1
        jDesktopPane1.removeAll();
        // Melakukan repaint pada jDesktopPane1 
        jDesktopPane1.repaint();
        // Membuat instance baru dari kelas Form_Pengembalian
        Form_Pengembalian fm = new Form_Pengembalian();
        // Menetapkan frame Form_Pengembalian agar terlihat atau tampil di layar
        fm.setVisible(true);
        // Menambahkan frame Form_Pengembalian ke dalam jDesktopPane1, sehingga frame tersebut dapat ditampilkan di dalam area kerja utama aplikasi
        jDesktopPane1.add(fm);
    }//GEN-LAST:event_btn_formPengembalianActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // Menghapus semua komponen yang ada di jDesktopPane1
        jDesktopPane1.removeAll();
        // Melakukan repaint pada jDesktopPane1 
        jDesktopPane1.repaint();
        // Menetapkan tombol btn_login agar terlihat di layar
        btn_login.setVisible(true);
        // Menetapkan tombol btn_hargasewa agar terlihat di layar
        btn_hargasewa.setVisible(true);
        // Menetapkan tombol btn_logout agar tidak terlihat di layar
        btn_logout.setVisible(false);
        // Menetapkan tombol btn_addcar agar tidak terlihat di layar
        btn_addcar.setVisible(false);
        // Menetapkan tombol btn_formPeminjam agar tidak terlihat di layar
        btn_formPeminjam.setVisible(false);
        // Menetapkan tombol btn_adduser agar tidak terlihat di layar
        btn_adduser.setVisible(false);
        // Menetapkan tombol btn_formPengembalian agar tidak terlihat di layar
        btn_formPengembalian.setVisible(false);
        // Menetapkan tombol btn_cetak agar tidak terlihat di layar
        btn_cetak.setVisible(false);
        // Menetapkan tombol btn_about agar terlihat di layar
        btn_about.setVisible(true);
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aboutActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        About fm = new About();
        fm.setVisible(true);
        jDesktopPane1.add(fm);
    }//GEN-LAST:event_btn_aboutActionPerformed

    private void btn_hargasewaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hargasewaActionPerformed
        jDesktopPane1.repaint();
        dispose();
        Harga_Sewa h = new Harga_Sewa();
        h.setVisible(true);
    }//GEN-LAST:event_btn_hargasewaActionPerformed

    private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        Cetak_Laporan fm = new Cetak_Laporan();
        fm.setVisible(true);
        jDesktopPane1.add(fm);
    }//GEN-LAST:event_btn_cetakActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Home().setVisible(true);
            }
        });
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static usu.widget.ButtonGlass btn_about;
    public static usu.widget.ButtonGlass btn_addcar;
    public static usu.widget.ButtonGlass btn_adduser;
    public static usu.widget.ButtonGlass btn_cetak;
    public static usu.widget.ButtonGlass btn_exit;
    public static usu.widget.ButtonGlass btn_formPeminjam;
    public static usu.widget.ButtonGlass btn_formPengembalian;
    public static usu.widget.ButtonGlass btn_hargasewa;
    public static usu.widget.ButtonGlass btn_login;
    public static usu.widget.ButtonGlass btn_logout;
    public static javax.swing.JDesktopPane jDesktopPane1;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static keeptoo.KGradientPanel kGradientPanel2;
    // End of variables declaration//GEN-END:variables
}
