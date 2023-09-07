
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Student extends javax.swing.JFrame {

    PreparedStatement ps;
    ResultSet rs;
    
    Connection connection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/java6-7", "root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
    
    public void getData(){
        DefaultTableModel model=(DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            ps=connection().prepareStatement("SELECT * FROM `student`");
            rs=ps.executeQuery();
            while(rs.next()){
                Object [] objects={
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("gender")
                        ,rs.getFloat("score")
                };
                model.addRow(objects);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    public Student() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgGender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rb_female = new javax.swing.JRadioButton();
        rb_male = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        txt_score = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn_update = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Information");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1200, -1));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel2.setText("Stu-Id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, -1, 50));

        txt_id.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        txt_id.setText("Auto Id");
        txt_id.setEnabled(false);
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 300, 50));

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel3.setText("Gender");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, 50));

        txt_name.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jPanel1.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 300, 50));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel4.setText("Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, 50));

        bgGender.add(rb_female);
        rb_female.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        rb_female.setText("Female");
        jPanel1.add(rb_female, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, -1, 50));

        bgGender.add(rb_male);
        rb_male.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        rb_male.setText("Male");
        jPanel1.add(rb_male, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, 50));

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel5.setText("Score");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, -1, 50));

        txt_score.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jPanel1.add(txt_score, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 300, 50));

        table.setAutoCreateRowSorter(true);
        table.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stu-id", "Name", "Gender", "Score"
            }
        ));
        table.setRowHeight(35);
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(true);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMaxWidth(90);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 620, 280));

        btn_update.setBackground(new java.awt.Color(255, 153, 51));
        btn_update.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        btn_update.setForeground(new java.awt.Color(255, 255, 255));
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });
        jPanel1.add(btn_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, 150, 50));

        btn_save.setBackground(new java.awt.Color(28, 85, 255));
        btn_save.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("Save");
        btn_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_saveMouseExited(evt);
            }
        });
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        jPanel1.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, 150, 50));

        btn_exit.setBackground(new java.awt.Color(0, 204, 51));
        btn_exit.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        btn_exit.setForeground(new java.awt.Color(255, 255, 255));
        btn_exit.setText("Exit");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });
        jPanel1.add(btn_exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 480, 150, 50));

        btn_delete.setBackground(new java.awt.Color(255, 0, 0));
        btn_delete.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Delete");
        btn_delete.setToolTipText("");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        jPanel1.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 480, 150, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1200, 628));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseEntered
        
    }//GEN-LAST:event_btn_saveMouseEntered

    private void btn_saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveMouseExited
        
    }//GEN-LAST:event_btn_saveMouseExited

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // get data from window form
        String name   = txt_name.getText();
        String gender = (rb_male.isSelected()==true)?"Male":"Female";
        String _score   =txt_score.getText();     
        // insert data into database
        if(!name.isEmpty() && !gender.isEmpty() && !_score.isEmpty()){
            float score=Float.parseFloat(_score);
            try { 
                ps=connection().prepareStatement("INSERT INTO `student`(`name`, `gender`, `score`) VALUES (?,?,?)");
                ps.setString(1, name);
                ps.setString(2, gender);
                ps.setFloat(3, score);
                int i=ps.executeUpdate();
                if(i>0){
                    JOptionPane.showMessageDialog(this, "Successs");
                    getData();
                }else{
                    JOptionPane.showMessageDialog(this, "Error");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Something wrong");
        }
        
        
    }//GEN-LAST:event_btn_saveActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        DefaultTableModel model=(DefaultTableModel) table.getModel();
        int row=table.getSelectedRow();
        txt_id.setText(model.getValueAt(row, 0).toString());
        txt_name.setText(model.getValueAt(row, 1).toString());
        String gender = model.getValueAt(row, 2).toString();
        if(gender=="Male"){
            rb_male.setSelected(true);
        }else{
            rb_female.setSelected(true);
        }
        txt_score.setText(model.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tableMouseClicked

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // get data from window form
        String name   = txt_name.getText();
        String gender = (rb_male.isSelected()==true)?"Male":"Female";
        String _score   =txt_score.getText();     
        int id=Integer.parseInt(txt_id.getText());
        // insert data into database
        if(!name.isEmpty() && !gender.isEmpty() && !_score.isEmpty()){
            float score=Float.parseFloat(_score);
            String sql="UPDATE `student` SET `name`=?,`gender`=?,`score`=? WHERE id=?";
            try {
                ps=connection().prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, gender);
                ps.setFloat(3, score);
                ps.setInt(4, id);
                int i=ps.executeUpdate();
                if(i>0){
                    JOptionPane.showMessageDialog(this, "Success");
                    getData();
                }else{
                    JOptionPane.showMessageDialog(this, "Error");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        int id=Integer.parseInt(txt_id.getText());
        String sql="DELETE FROM `student` WHERE id=?";
        try {
            ps=connection().prepareStatement(sql);
            ps.setInt(1, id);
            int i=ps.executeUpdate();
            if(i>0){
                JOptionPane.showMessageDialog(this, "Success");
                getData();
            }else{
                JOptionPane.showMessageDialog(this, "Error");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        getData();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgGender;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_female;
    private javax.swing.JRadioButton rb_male;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_score;
    // End of variables declaration//GEN-END:variables
}
