/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectGUI;

import activity.GymEquipmentClass;
import controller.EquipmentDAOImp;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wang
 */
public class equipmentMenu extends javax.swing.JInternalFrame {
    
    int search;
    /**
     * Creates new form memberMenu
     */
    public equipmentMenu() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        
        Load();
        panelBorder();
        combo_equipmentType.setModel(new DefaultComboBoxModel<> (new String [] {
        "---Select Category ---", "Workout", "AB", "Agility", "Balance", "Bars", "Barbell", 
        "Benches", "Cardio Machines", "Dumbbell", "Cable", "Leg Machine", "Resistant Training",
        "Strength Training", "Squat"}));
        
        txt_EquipmentID.setEditable(false);
        validationError();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel_fields = new javax.swing.JPanel();
        combo_equipmentType = new javax.swing.JComboBox<>();
        spinner_quantity = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        txt_equipment_name = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        validation_equipment_name = new javax.swing.JLabel();
        validation_type = new javax.swing.JLabel();
        validation_quantity = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_equipment_add = new javax.swing.JButton();
        btn_equipment_delete = new javax.swing.JButton();
        btn_equipment_update = new javax.swing.JButton();
        btn_equipment_clear = new javax.swing.JButton();
        panel_equipmentList = new javax.swing.JPanel();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txt_EquipmentID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_equipment = new javax.swing.JTable();

        setBackground(new java.awt.Color(254, 243, 246));

        jPanel1.setBackground(new java.awt.Color(254, 243, 246));

        panel_fields.setBackground(new java.awt.Color(254, 243, 246));

        combo_equipmentType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo_equipmentType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_equipmentTypeActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Quantity");

        txt_equipment_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_equipment_nameActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Equipment Type");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setText("Equipment Name");

        validation_equipment_name.setBackground(new java.awt.Color(255, 0, 51));
        validation_equipment_name.setForeground(new java.awt.Color(255, 0, 51));
        validation_equipment_name.setText("*");

        validation_type.setBackground(new java.awt.Color(255, 0, 51));
        validation_type.setForeground(new java.awt.Color(255, 0, 51));
        validation_type.setText("*");

        validation_quantity.setBackground(new java.awt.Color(255, 0, 51));
        validation_quantity.setForeground(new java.awt.Color(255, 0, 51));
        validation_quantity.setText("*");

        javax.swing.GroupLayout panel_fieldsLayout = new javax.swing.GroupLayout(panel_fields);
        panel_fields.setLayout(panel_fieldsLayout);
        panel_fieldsLayout.setHorizontalGroup(
            panel_fieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_fieldsLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panel_fieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinner_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_equipment_name, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_fieldsLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(validation_equipment_name, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_fieldsLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(validation_type, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(combo_equipmentType, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_fieldsLayout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(validation_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        panel_fieldsLayout.setVerticalGroup(
            panel_fieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_fieldsLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(panel_fieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(validation_equipment_name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_equipment_name, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_fieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(validation_type))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_equipmentType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_fieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(validation_quantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinner_quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(254, 243, 246));

        btn_equipment_add.setBackground(new java.awt.Color(0, 181, 73));
        btn_equipment_add.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_equipment_add.setText("Add");
        btn_equipment_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_equipment_addActionPerformed(evt);
            }
        });

        btn_equipment_delete.setBackground(new java.awt.Color(174, 13, 16));
        btn_equipment_delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_equipment_delete.setText("Delete");
        btn_equipment_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_equipment_deleteActionPerformed(evt);
            }
        });

        btn_equipment_update.setBackground(new java.awt.Color(79, 118, 224));
        btn_equipment_update.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_equipment_update.setText("Update");
        btn_equipment_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_equipment_updateActionPerformed(evt);
            }
        });

        btn_equipment_clear.setBackground(new java.awt.Color(240, 194, 0));
        btn_equipment_clear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_equipment_clear.setText("Clear");
        btn_equipment_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_equipment_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_equipment_add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_equipment_update, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_equipment_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_equipment_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_equipment_add, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_equipment_update, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_equipment_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_equipment_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        panel_equipmentList.setBackground(new java.awt.Color(254, 243, 246));

        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });

        btn_search.setBackground(new java.awt.Color(223, 89, 62));
        btn_search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_search.setForeground(new java.awt.Color(255, 255, 255));
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectGUI/images/search.png"))); // NOI18N
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Equipment ID:");

        txt_EquipmentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_EquipmentIDActionPerformed(evt);
            }
        });

        tbl_equipment.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Equipment ID", "Equipment Name", "Equipment Type", "Quantity"
            }
        ));
        tbl_equipment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_equipmentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_equipment);

        javax.swing.GroupLayout panel_equipmentListLayout = new javax.swing.GroupLayout(panel_equipmentList);
        panel_equipmentList.setLayout(panel_equipmentListLayout);
        panel_equipmentListLayout.setHorizontalGroup(
            panel_equipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_equipmentListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_equipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panel_equipmentListLayout.createSequentialGroup()
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btn_search)
                        .addGap(125, 125, 125)
                        .addComponent(jLabel18)
                        .addGap(9, 9, 9)
                        .addComponent(txt_EquipmentID, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel_equipmentListLayout.setVerticalGroup(
            panel_equipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_equipmentListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_equipmentListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_EquipmentID, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_equipmentList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panel_fields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel_fields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_equipmentList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void Load(){
        EquipmentDAOImp equipment_dao = new EquipmentDAOImp();
        List<GymEquipmentClass> list = equipment_dao.list();
        DefaultTableModel DFT = (DefaultTableModel) tbl_equipment.getModel();
        DFT.setRowCount(0);
        
        for(GymEquipmentClass gymEquipment: list)
        {
            int id = gymEquipment.getEquipmentID();

            String equpmentName = gymEquipment.getEquipmentName();
            String equpmentType = gymEquipment.getEquipmentType();
            int equipment_quantity = gymEquipment.getQuantity();

            DFT.addRow(new Object[]{id, equpmentName, equpmentType, equipment_quantity});
        }          
    }
    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void combo_equipmentTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_equipmentTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_equipmentTypeActionPerformed

    private void txt_EquipmentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_EquipmentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EquipmentIDActionPerformed

    private void txt_equipment_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_equipment_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_equipment_nameActionPerformed

    private void tbl_equipmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_equipmentMouseClicked
           
        DefaultTableModel RecordTable = (DefaultTableModel)tbl_equipment.getModel();
        int SelectedRows = tbl_equipment.getSelectedRow();
        EquipmentDAOImp dao = new EquipmentDAOImp ();
            
        search = (int) (tbl_equipment.getModel().getValueAt(SelectedRows, 0));
        GymEquipmentClass gec = dao.get(search);
        
        txt_EquipmentID.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
        txt_equipment_name.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
        combo_equipmentType.setSelectedItem(RecordTable.getValueAt(SelectedRows, 2).toString());
        
        Object value = RecordTable.getValueAt(SelectedRows, 3);
        spinner_quantity.setValue(value);
        
    }//GEN-LAST:event_tbl_equipmentMouseClicked

    private void btn_equipment_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_equipment_addActionPerformed
        
        
        try{
            if(txt_equipment_name.getText().trim().isEmpty()){
                validation_equipment_name.setVisible(true);
                JOptionPane.showMessageDialog(null, "Enter equipment name!");
                return;
            }
            
            if(combo_equipmentType.getSelectedIndex()==0){
                validation_type.setVisible(true);
                JOptionPane.showMessageDialog(null, "Enter equipment type!");
                return;
            }
            
            if(spinner_quantity.getValue().equals(null)||spinner_quantity.getValue().equals(0)){
                validation_quantity.setVisible(true);
                JOptionPane.showMessageDialog(null, "Enter equipment quantity!");
                return;
            } 
            
            else{
                GymEquipmentClass equipment = new GymEquipmentClass();

                String equipmentName = txt_equipment_name.getText();
                String equipmentType = combo_equipmentType.getSelectedItem().toString();
                int quantity = (Integer) spinner_quantity.getValue();

                equipment.setEquipmentName(equipmentName);
                equipment.setEquipmentType(equipmentType);
                equipment.setQuantity(quantity);

                EquipmentDAOImp equipment_dao = new EquipmentDAOImp();
                equipment_dao.save(equipment);
                Load();

                txt_equipment_name.setText("");
                combo_equipmentType.setSelectedIndex(0);
                spinner_quantity.setValue(0);

                txt_equipment_name.requestFocus();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
        }
    }//GEN-LAST:event_btn_equipment_addActionPerformed

    private void btn_equipment_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_equipment_deleteActionPerformed
        GymEquipmentClass equipment = new GymEquipmentClass();
        
        equipment.setEquipmentID(search);
        EquipmentDAOImp equipment_dao = new EquipmentDAOImp();
        equipment_dao.delete(equipment);
        Load();
        
        txt_equipment_name.setText("");
        combo_equipmentType.setSelectedIndex(0);
        spinner_quantity.setValue(0);

        txt_equipment_name.requestFocus();
    }//GEN-LAST:event_btn_equipment_deleteActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed

            search = Integer.parseInt(txt_search.getText());
            EquipmentDAOImp equipment_dao = new EquipmentDAOImp();
            GymEquipmentClass equipment = equipment_dao.get(search);
            
            txt_EquipmentID.setText(String.valueOf(equipment.getEquipmentID()));
            txt_equipment_name.setText(equipment.getEquipmentName());
            combo_equipmentType.setSelectedItem(equipment.getEquipmentType());
            spinner_quantity.setValue(equipment.getQuantity());                        
            Load();

    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_equipment_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_equipment_updateActionPerformed
        
        try{
            if(txt_equipment_name.getText().trim().isEmpty()){
                validation_equipment_name.setVisible(true);
                JOptionPane.showMessageDialog(null, "Enter equipment name!");
                return;
            }
            
            if(combo_equipmentType.getSelectedIndex()==0){
                validation_type.setVisible(true);
                JOptionPane.showMessageDialog(null, "Enter equipment type!");
                return;
            }
            
            if(spinner_quantity.getValue().equals(null)||spinner_quantity.getValue().equals(0)){
                validation_quantity.setVisible(true);
                JOptionPane.showMessageDialog(null, "Enter equipment quantity!");
                return;
            }
            
            else{
                GymEquipmentClass equipment = new GymEquipmentClass();

                String equipmentName = txt_equipment_name.getText();
                String equipmentType = combo_equipmentType.getSelectedItem().toString();
                int quantity = (Integer) spinner_quantity.getValue();

                equipment.setEquipmentName(equipmentName);
                equipment.setEquipmentType(equipmentType);
                equipment.setQuantity(quantity);
                equipment.setEquipmentID(search);

                EquipmentDAOImp equipment_dao = new EquipmentDAOImp();
                equipment_dao.update(equipment);
                Load();

                txt_equipment_name.setText("");
                combo_equipmentType.setSelectedIndex(0);
                spinner_quantity.setValue(0);
                txt_EquipmentID.setText("");
                txt_equipment_name.requestFocus();
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please fill all fields!");
        }
    }//GEN-LAST:event_btn_equipment_updateActionPerformed

    private void btn_equipment_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_equipment_clearActionPerformed
            txt_equipment_name.setText("");
            combo_equipmentType.setSelectedIndex(0);
            spinner_quantity.setValue(0);
            txt_EquipmentID.setText("");
            txt_equipment_name.requestFocus();
            
            JOptionPane.showMessageDialog(null, "Text Field Clear!");
    }//GEN-LAST:event_btn_equipment_clearActionPerformed

    public void panelBorder(){
        
       panel_fields.setBorder(new TitledBorder(new LineBorder(new Color (16, 82, 142)), 
                "Enter Equipment", TitledBorder.DEFAULT_JUSTIFICATION, 
                TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), new Color (16, 82, 142)));
       
       panel_equipmentList.setBorder(new TitledBorder(new LineBorder(new Color (16, 82, 142)), 
                "Equipment List", TitledBorder.DEFAULT_JUSTIFICATION, 
                TitledBorder.CENTER, new Font("SansSerif", Font.PLAIN, 12), new Color (16, 82, 142)));
            
    }
    
    public void validationError(){
        
            validation_equipment_name.setVisible(false);
            validation_type.setVisible(false);
            validation_quantity.setVisible(false);
                     
                       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_equipment_add;
    private javax.swing.JButton btn_equipment_clear;
    private javax.swing.JButton btn_equipment_delete;
    private javax.swing.JButton btn_equipment_update;
    private javax.swing.JButton btn_search;
    private javax.swing.JComboBox<String> combo_equipmentType;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel_equipmentList;
    private javax.swing.JPanel panel_fields;
    private javax.swing.JSpinner spinner_quantity;
    private javax.swing.JTable tbl_equipment;
    private javax.swing.JTextField txt_EquipmentID;
    private javax.swing.JTextField txt_equipment_name;
    private javax.swing.JTextField txt_search;
    private javax.swing.JLabel validation_equipment_name;
    private javax.swing.JLabel validation_quantity;
    private javax.swing.JLabel validation_type;
    // End of variables declaration//GEN-END:variables
}