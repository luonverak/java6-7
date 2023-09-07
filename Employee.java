package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Employee extends javax.swing.JFrame {

    MySQL mysql = new MySQL();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    PreparedStatement ps;
    ResultSet rs;
    // fetch data

    void getData() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        String sql = "SELECT id, CONCAT(firstname,' ',lastname) as fullname,gender,position,dsw,salary FROM employee ORDER BY id DESC";
        try {
            ps = mysql.connection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object object[] = {
                    rs.getInt("id"),
                    rs.getString("fullname"),
                    rs.getString("gender"),
                    rs.getString("position"),
                    rs.getString("dsw"),
                    rs.getFloat("salary")
                };
                model.addRow(object);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Employee() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgGender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rbfemale = new javax.swing.JRadioButton();
        rbmale = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        position = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        calender = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        salary = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        kButton1 = new com.k33ptoo.components.KButton();
        kButton2 = new com.k33ptoo.components.KButton();
        kButton3 = new com.k33ptoo.components.KButton();
        kButton4 = new com.k33ptoo.components.KButton();
        id = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1409, 794));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel2.setText("Firstname");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 117, -1, 50));

        firstname.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        firstname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        firstname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(51, 153, 255)));
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        jPanel1.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 120, 300, 50));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel4.setText("Gender");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 200, 106, 50));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel3.setText("Lastname");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(976, 117, -1, 50));

        lastname.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        lastname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lastname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(51, 153, 255)));
        jPanel1.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 120, 300, 50));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 212, 517, 366));

        bgGender.add(rbfemale);
        rbfemale.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        rbfemale.setText("Female");
        rbfemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbfemaleActionPerformed(evt);
            }
        });
        jPanel1.add(rbfemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(777, 200, -1, 50));

        bgGender.add(rbmale);
        rbmale.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        rbmale.setText("Male");
        jPanel1.add(rbmale, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 200, -1, 50));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel5.setText("Position");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(976, 200, -1, 50));

        position.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mobile", "Web ", "Network" }));
        jPanel1.add(position, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 200, 300, 50));

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel6.setText("DSW");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 280, 106, 50));

        calender.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jPanel1.add(calender, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 280, 300, 50));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel7.setText("Salary");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(976, 280, -1, 50));

        salary.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        salary.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salary.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 5, 0, new java.awt.Color(51, 153, 255)));
        jPanel1.add(salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 283, 300, 50));

        table.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fullname", "Gender", "Position", "DSW", "Salary"
            }
        ));
        table.setRowHeight(35);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(0);
            table.getColumnModel().getColumn(0).setPreferredWidth(0);
            table.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 351, 876, 257));

        kButton1.setText("Save");
        kButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        kButton1.setkEndColor(new java.awt.Color(51, 102, 255));
        kButton1.setkHoverEndColor(new java.awt.Color(0, 51, 255));
        kButton1.setkStartColor(new java.awt.Color(0, 0, 204));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 665, -1, -1));

        kButton2.setText("Update");
        kButton2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(kButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 665, -1, -1));

        kButton3.setText("Exit");
        kButton3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        kButton3.setkEndColor(new java.awt.Color(153, 255, 255));
        kButton3.setkHoverEndColor(new java.awt.Color(51, 204, 255));
        kButton3.setkStartColor(new java.awt.Color(0, 153, 255));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(kButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1196, 665, -1, -1));

        kButton4.setText("Delete");
        kButton4.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        kButton4.setkEndColor(new java.awt.Color(255, 102, 102));
        kButton4.setkHoverEndColor(new java.awt.Color(255, 0, 0));
        kButton4.setkStartColor(new java.awt.Color(204, 0, 0));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(kButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(969, 665, -1, -1));

        id.setFont(new java.awt.Font("Helvetica Neue", 0, 5)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setBorder(null);
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 740, 170, -1));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 40)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Employee Information");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 890, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 800));

        setSize(new java.awt.Dimension(1409, 794));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void rbfemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbfemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbfemaleActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_kButton3ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        String firstname = this.firstname.getText();
        String lastname = this.lastname.getText();
        String gender = (rbmale.isSelected() == true) ? "Male" : "Female";
        String position = this.position.getSelectedItem().toString();
        String date = sdf.format(this.calender.getDate());
        String salary = this.salary.getText();
        if (!firstname.isEmpty() && !lastname.isEmpty() && !gender.isEmpty() && !position.isEmpty() && !date.isEmpty() && !salary.isEmpty()) {
            float _salary = Float.parseFloat(salary);
            String sql = "INSERT INTO `employee`(`firstname`, `lastname`, `gender`, `position`, `dsw`, `salary`) VALUES (?,?,?,?,?,?)";
            try {
                ps = mysql.connection().prepareStatement(sql);
                ps.setString(1, firstname);
                ps.setString(2, lastname);
                ps.setString(3, gender);
                ps.setString(4, position);
                ps.setString(5, date);
                ps.setString(6, salary);
                int i = ps.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(this, "Success");
                    getData();
                } else {
                    JOptionPane.showMessageDialog(this, "Error");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("eror");
        }
    }//GEN-LAST:event_kButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        this.calender.setDate(new Date());
        getData();
    }//GEN-LAST:event_formWindowOpened

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int row = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        id.setText(model.getValueAt(row, 0).toString());
        String name = table.getValueAt(row, 1).toString();
        String[] line = name.split(" ");
        firstname.setText(line[0]);
        lastname.setText(line[1]);
        String gender = model.getValueAt(row, 2).toString();
        if ("Male".equals(gender)) {
            rbmale.setSelected(true);
        } else {
            rbfemale.setSelected(true);
        }
        position.setSelectedItem(model.getValueAt(row, 3));
        salary.setText(model.getValueAt(row, 5).toString());
        try {
            String date = table.getValueAt(row, 4).toString();
            calender.setDate(sdf.parse(date));
        } catch (ParseException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        String firstname = this.firstname.getText();
        String lastname = this.lastname.getText();
        String gender = (rbmale.isSelected() == true) ? "Male" : "Female";
        String position = this.position.getSelectedItem().toString();
        String date = sdf.format(this.calender.getDate());
        String salary = this.salary.getText();
        int id = Integer.parseInt(this.id.getText());
        if (!firstname.isEmpty() && !lastname.isEmpty() && !gender.isEmpty() && !position.isEmpty() && !date.isEmpty() && !salary.isEmpty()) {
            float _salary = Float.parseFloat(salary);
            String sql = "UPDATE `employee` SET `firstname`=?,`lastname`=?,`gender`=?,`position`=?,`dsw`=?,`salary`=? WHERE id=?";
            try {
                ps = mysql.connection().prepareStatement(sql);
                ps.setString(1, firstname);
                ps.setString(2, lastname);
                ps.setString(3, gender);
                ps.setString(4, position);
                ps.setString(5, date);
                ps.setString(6, salary);
                ps.setInt(7, id);
                int i = ps.executeUpdate();
                if (i > 0) {
                    JOptionPane.showMessageDialog(this, "Success");
                    getData();
                } else {
                    JOptionPane.showMessageDialog(this, "Error");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("eror");
        }
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        int id = Integer.parseInt(this.id.getText());
        String sql = "DELETE FROM `employee` WHERE id=?";
        try {
            ps = mysql.connection().prepareStatement(sql);
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(this, "Success");
                getData();
            } else {
                JOptionPane.showMessageDialog(this, "Error");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_kButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgGender;
    private com.toedter.calendar.JDateChooser calender;
    private javax.swing.JTextField firstname;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton4;
    private javax.swing.JTextField lastname;
    private javax.swing.JComboBox<String> position;
    private javax.swing.JRadioButton rbfemale;
    private javax.swing.JRadioButton rbmale;
    private javax.swing.JTextField salary;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
