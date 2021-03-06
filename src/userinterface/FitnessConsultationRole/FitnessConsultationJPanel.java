/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userinterface.FitnessConsultationRole;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.ConsultationEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.FitnessConsultationOrganization;
import Business.Organization.HealthConsultationOrganization;
import Business.Organization.Organization;
import Business.Organization.WellnessPlatformOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.FitnessWorkRequest;
import Business.WorkQueue.UserDoctorWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shreyasprasad
 */
public class FitnessConsultationJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UserJPanel
     */
  
    JPanel userProcessContainer;
    private WellnessPlatformOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private  WellnessPlatformOrganization wellnessPlatformOrganization;
    private FitnessConsultationOrganization FitnessConsultationOrganization;
    private Network network;
    private EcoSystem system;
     private DB4OUtil db = DB4OUtil.getInstance();
     private Organization fcOrganisation;

    public FitnessConsultationJPanel(JPanel userProcessContainer, UserAccount account, FitnessConsultationOrganization fitnessConsultationOrganization, Enterprise enterprise, EcoSystem system, Network network) {
         initComponents();
         this.userProcessContainer= userProcessContainer;
        this.userAccount=account;
        this.enterprise=enterprise;
        this.FitnessConsultationOrganization =fitnessConsultationOrganization;
        this.system=system;
        this.network= network;
        populateTable();
    }




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        studyCaseBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        fcTable = new javax.swing.JTable();
        assignMeBtn = new javax.swing.JButton();

        jLabel1.setText("Welcome to Fitness world");

        studyCaseBtn.setText("Study Case");
        studyCaseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studyCaseBtnActionPerformed(evt);
            }
        });

        fcTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(fcTable);

        assignMeBtn.setText("Assign to Me");
        assignMeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignMeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184))
            .addGroup(layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(assignMeBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
                .addComponent(studyCaseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignMeBtn)
                    .addComponent(studyCaseBtn))
                .addGap(58, 58, 58))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(196, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void populateTable(){ // popolate the fitness request table
          DefaultTableModel model = (DefaultTableModel)fcTable.getModel();
        
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (enterprise instanceof ConsultationEnterprise) {
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization instanceof FitnessConsultationOrganization) {
                            fcOrganisation = organization;
                            break;
                        }
                    }
                }

            }
        }
      
       model.setRowCount(0);
        for (WorkRequest reqQueue : fcOrganisation.getWorkQueue().getWorkRequestList()){
            FitnessWorkRequest fcWorkRequest = (FitnessWorkRequest)reqQueue;
            Object[] row = new Object[7];
            row[0]= fcWorkRequest;
            row[1] = fcWorkRequest.getHeight();
            row[2] = fcWorkRequest.getWeight();
            row[3] = fcWorkRequest.getStatus();
            //row[4] = hcWorkRequest;
            model.addRow(row);
        }
        
    }
    
    private void studyCaseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studyCaseBtnActionPerformed
        // TODO add your handling code here:

        // select the work queue.
        int selectedHCRequest = fcTable.getSelectedRow();

        if(selectedHCRequest >= 0){

            FitnessWorkRequest FCrequest =(FitnessWorkRequest)fcTable.getValueAt(selectedHCRequest, 0);
           // System.out.println("recevier from table "+FCrequest.getReceiver().getUsername());
            System.out.println("recevier User account "+userAccount.getUsername());
            if(FCrequest.getReceiver().getUsername().equalsIgnoreCase(userAccount.getUsername())){
                FCrequest.setStatus("prescription");
                FitnessConsultantSupplementJPanel processWorkRequestJPanel = new FitnessConsultantSupplementJPanel(userProcessContainer, userAccount, wellnessPlatformOrganization, enterprise, system);
                userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            }
            else{
                JOptionPane.showMessageDialog(null, "Person is selected by nother Fitness Consultant");
            }

        }else{
            JOptionPane.showMessageDialog(null, "Please Select any row");
        }

    }//GEN-LAST:event_studyCaseBtnActionPerformed

    private void assignMeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignMeBtnActionPerformed
        // TODO add your handling code here:
        
        /*
        // allow assign only if the status is waiting.. else return 
        int selectedHCRequest = hcTable.getSelectedRow();
        
         if(selectedHCRequest >= 0){
             UserDoctorWorkRequest HCPcrequest =(UserDoctorWorkRequest)hcTable.getValueAt(selectedHCRequest, 0);
            String status = HCPcrequest.getStatus();
            if(status.equalsIgnoreCase("waiting")){ // positive case
                //System.out.println("you are assigned to "+this.userAccount.getUsername());
                HCPcrequest.setReceiver(userAccount);
                System.out.println("The receiver is "+HCPcrequest.getReceiver());
                HCPcrequest.setStatus("Assigned");   
            }
            else{
                JOptionPane.showMessageDialog(null, "Sorry, patient is already assigned. Please select another Person ");
                return;
            }
         }
         else{
             System.out.println("Please select a row");
         }
         
         
         // pupulate the fresh updated table 
         populateTable();
        */

        // allow assign only if the status is waiting.. else return
        int selectedFCRequest = fcTable.getSelectedRow();

        if(selectedFCRequest >= 0){
            FitnessWorkRequest FCrequest =(FitnessWorkRequest)fcTable.getValueAt(selectedFCRequest, 0);
            String status = FCrequest.getStatus();
            if(status.equalsIgnoreCase("waiting")){ // positive case
                //System.out.println("you are assigned to "+this.userAccount.getUsername());
                FCrequest.setReceiver(userAccount);
                System.out.println("The receiver is "+FCrequest.getReceiver());
                FCrequest.setStatus("Assigned");
            }
            else{
                JOptionPane.showMessageDialog(null, "Sorry, person is already assigned to other fitness consultant. Please select another Person ");
                return;
            }
        }
        else{
            System.out.println("Please select a row");
        }

        // pupulate the fresh updated table
        populateTable();

    }//GEN-LAST:event_assignMeBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignMeBtn;
    private javax.swing.JTable fcTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton studyCaseBtn;
    // End of variables declaration//GEN-END:variables
}
