package View;



import Repository.DiemSinhVienRepository;
import Model.QlyDiem;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class DiemSinhVienJFrame extends javax.swing.JFrame {
    DiemSinhVienRepository dsvRepo = new DiemSinhVienRepository();
    public DiemSinhVienJFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.loadTable();
    }
    private void loadTable(){
        DefaultTableModel dtm = (DefaultTableModel) this.tblDSV.getModel();
            dtm.setRowCount(0);
            for (QlyDiem dsv : this.dsvRepo.fillAll()) {
                Object [] row ={
                    dsv.getMaSV(),
                    dsv.getHoTen(),
                    dsv.getTiengAnh(),
                    dsv.getTinHoc(),
                    dsv.getGDTC(),
                    (dsv.getTiengAnh()+dsv.getTinHoc()+dsv.getGDTC())/3,
                };
            dtm.addRow(row);    
        }
        Comparator<QlyDiem> comp = new Comparator<QlyDiem>() {
            @Override
            public int compare(QlyDiem o1, QlyDiem o2) {
                if (o1.getDiemTB() > o2.getDiemTB()) {
                    return -1;
                } else if (o1.getDiemTB() < o2.getDiemTB()){
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        Collections.sort(this.dsvRepo.fillAll(), comp);       
    }
     public void display(int index){
        QlyDiem dsv = this.dsvRepo.fillAll().get(index);
        txtHoTenSV.setText(dsv.getHoTen());
        txtMaSV.setText(dsv.getMaSV());
        txtTiengAnh.setText(""+dsv.getTiengAnh());
        txtTinHoc.setText(""+dsv.getTinHoc());
        txtGiaoDuc.setText(""+dsv.getGDTC());
        txtDiemTB.setText(""+dsv.getDiemTB());
    }
    public void search() {
        String timMa;
        int dem = 0;
        timMa = txtMaSV.getText();

        if (checkNullSearch() == true) {
            for (QlyDiem sv : this.dsvRepo.fillAll()) {
                if (sv.getMaSV().equals(timMa)) {
                    txtHoTenSV.setText(sv.getHoTen());
                    txtMaSV.setText(sv.getMaSV());
                    txtMaSinhVien.setText(sv.getMaSV());
                    txtTiengAnh.setText(String.valueOf(sv.getTiengAnh()));
                    txtTinHoc.setText(String.valueOf(sv.getTinHoc()));
                    txtGiaoDuc.setText(String.valueOf(sv.getGDTC()));
                    txtDiemTB.setText(String.valueOf(sv.getDiemTB()));
                    dem++;
                }
            }

            if (dem == 0) {
                JOptionPane.showMessageDialog(rootPane, "Không Tìm Thấy Sinh Viên " + txtMaSV.getText());
                txtMaSV.requestFocus();
            }
        }

    }

    public boolean checkNullSearch() {
        if (txtMaSV.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Bạn Chưa Nhập Sinh Viên!!!");
            txtMaSV.requestFocus();
            return false;
        } else {
            return true;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        lblMaSV = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblHoTen = new javax.swing.JLabel();
        lblMaSinhVien = new javax.swing.JLabel();
        lblTinHoc = new javax.swing.JLabel();
        lblTiengAnh = new javax.swing.JLabel();
        lblGDTC = new javax.swing.JLabel();
        txtMaSinhVien = new javax.swing.JTextField();
        txtTiengAnh = new javax.swing.JTextField();
        txtTinHoc = new javax.swing.JTextField();
        txtGiaoDuc = new javax.swing.JTextField();
        lblDiemTB = new javax.swing.JLabel();
        txtHoTenSV = new javax.swing.JTextField();
        txtDiemTB = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSV = new javax.swing.JTable();
        btnLast = new javax.swing.JButton();
        btnDau = new javax.swing.JButton();
        btnFisrt = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("Quản Lý Điểm Sinh Viên");

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setForeground(new java.awt.Color(3, 3, 3));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblMaSV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaSV.setText("Mã SV :");

        txtMaSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMaSV)
                .addGap(32, 32, 32)
                .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSearch)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(lblMaSV)
                    .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tìm Kiếm");

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153), new java.awt.Color(153, 153, 153)));
        jPanel2.setForeground(new java.awt.Color(3, 3, 3));

        lblHoTen.setText("Họ Tên SV :");

        lblMaSinhVien.setText("Mã SV :");

        lblTinHoc.setText("Tin Học :");

        lblTiengAnh.setText("Tiếng Anh :");

        lblGDTC.setText("Giáo Dục TC :");

        txtMaSinhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSinhVienActionPerformed(evt);
            }
        });

        lblDiemTB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDiemTB.setForeground(new java.awt.Color(51, 51, 255));
        lblDiemTB.setText("ĐIỂM TB:");

        txtDiemTB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDiemTB.setForeground(new java.awt.Color(102, 51, 255));
        txtDiemTB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiemTBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMaSinhVien)
                    .addComponent(lblTiengAnh)
                    .addComponent(lblGDTC)
                    .addComponent(lblTinHoc)
                    .addComponent(lblHoTen))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHoTenSV, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(txtTinHoc)
                            .addComponent(txtGiaoDuc))
                        .addGap(0, 116, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaSinhVien)
                            .addComponent(txtTiengAnh))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtDiemTB)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoTen)
                    .addComponent(txtHoTenSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaSinhVien)
                            .addComponent(txtMaSinhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTiengAnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTiengAnh))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTinHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTinHoc))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGDTC)
                            .addComponent(txtGiaoDuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDiemTB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 51, 255));
        jLabel10.setText("3 sinh viên có điểm cao nhất");

        tblDSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SV", "Họ Tên", "Tiếng Anh", "Tin Học", "GDTC", "Điểm TB"
            }
        ));
        tblDSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSV);

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnDau.setText("<<");
        btnDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauActionPerformed(evt);
            }
        });

        btnFisrt.setText("|<");
        btnFisrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFisrtActionPerformed(evt);
            }
        });

        btnCuoi.setText(">>");
        btnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(418, 418, 418))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnFisrt)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDau)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnCuoi)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLast))
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNew)
                                    .addComponent(btnSave)
                                    .addComponent(btnDelete)
                                    .addComponent(btnUpdate))))
                        .addGap(43, 43, 43))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnNew)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFisrt)
                        .addComponent(btnDau))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLast)
                        .addComponent(btnCuoi)))
                .addGap(38, 38, 38)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSVActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        this.search();
        this.loadTable();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtMaSinhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSinhVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSinhVienActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        this.clearForm();
        JOptionPane.showMessageDialog(this, "Refresh Successfully");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String ma = this.txtMaSinhVien.getText();
        String ten = this.txtHoTenSV.getText();
        double ta = Double.parseDouble(this.txtTiengAnh.getText());
        double th = Double.parseDouble(this.txtTinHoc.getText());
        double gdtc = Double.parseDouble(this.txtGiaoDuc.getText());
        QlyDiem qlD = new QlyDiem(ma, ten, ta, th, gdtc);
        this.dsvRepo.insert(qlD);
        this.loadTable();
        JOptionPane.showMessageDialog(this, "Saved Successfully");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String ma = this.txtMaSinhVien.getText();
        this.dsvRepo.delelte(ma);
        this.loadTable();
        JOptionPane.showMessageDialog(this, "Deleted Successfully");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtDiemTBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiemTBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiemTBActionPerformed

    private void tblDSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSVMouseClicked
        int row = this.tblDSV.getSelectedRow();
        if (row == -1) {
            return;
        }
        String ma = this.tblDSV.getValueAt(row, 0).toString();
        String ma2 = this.tblDSV.getValueAt(row, 0).toString();
        String hoTen = this.tblDSV.getValueAt(row, 1).toString();
        String ta =this.tblDSV.getValueAt(row, 2).toString();
        String th= this.tblDSV.getValueAt(row, 3).toString();
        String GDTC = this.tblDSV.getValueAt(row, 4).toString();
        String diemTB = this.tblDSV.getValueAt(row, 5).toString();
        

        this.txtMaSV.setText(ma);
        this.txtMaSinhVien.setText(ma2);
        this.txtHoTenSV.setText(hoTen);
        this.txtTiengAnh.setText(ta);
        this.txtTinHoc.setText(th); 
        this.txtGiaoDuc.setText(GDTC); 
        this.txtDiemTB.setText(diemTB);
    }//GEN-LAST:event_tblDSVMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String ma = this.txtMaSinhVien.getText();
        String ten = this.txtHoTenSV.getText();
        double ta = Double.parseDouble(this.txtTiengAnh.getText());
        double th = Double.parseDouble(this.txtTinHoc.getText());
        double gdtc = Double.parseDouble(this.txtGiaoDuc.getText());
        QlyDiem qlD = new QlyDiem(ma, ten, ta, th, gdtc);
        this.dsvRepo.update(qlD);
        this.loadTable();
        JOptionPane.showMessageDialog(this, "Updated Successfully");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiActionPerformed

        int index = 0;
        if (index>=(this.dsvRepo.fillAll().size()-1)) {
            JOptionPane.showMessageDialog(rootPane, "Bạn Đang Ở Vị Trí Sinh Viên Cuối");
        } else {
            this.display(++index);
        }
    }//GEN-LAST:event_btnCuoiActionPerformed

    private void btnFisrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFisrtActionPerformed

        int index=0;
        this.display(index);
    }//GEN-LAST:event_btnFisrtActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        
        int index = this.dsvRepo.fillAll().size()-1;
        this.display(index);
            
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauActionPerformed
        int index = 0;
        if (index>=(this.dsvRepo.fillAll().size()+1)) {
            JOptionPane.showMessageDialog(rootPane, "Bạn Đang Ở Vị Trí Sinh Viên Đầu Tiên");
        } else {
            this.display(++index);
        }
    }//GEN-LAST:event_btnDauActionPerformed
    public void clearForm(){
        this.txtMaSV.setText("");
        this.txtMaSinhVien.setText("");
        this.txtHoTenSV.setText("");
        this.txtTiengAnh.setText("");
        this.txtTinHoc.setText("");
        this.txtGiaoDuc.setText("");
        this.txtDiemTB.setText("");
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DiemSinhVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiemSinhVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiemSinhVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiemSinhVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DiemSinhVienJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDau;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFisrt;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblDiemTB;
    private javax.swing.JLabel lblGDTC;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblMaSV;
    private javax.swing.JLabel lblMaSinhVien;
    private javax.swing.JLabel lblTiengAnh;
    private javax.swing.JLabel lblTinHoc;
    private javax.swing.JTable tblDSV;
    private javax.swing.JTextField txtDiemTB;
    private javax.swing.JTextField txtGiaoDuc;
    private javax.swing.JTextField txtHoTenSV;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtMaSinhVien;
    private javax.swing.JTextField txtTiengAnh;
    private javax.swing.JTextField txtTinHoc;
    // End of variables declaration//GEN-END:variables
}
