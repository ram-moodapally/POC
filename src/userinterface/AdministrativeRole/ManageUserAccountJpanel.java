/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;


/**
 *
 * @author vgout
 */
public class ManageUserAccountJpanel extends javax.swing.JPanel {
    private JPanel container;
    private Enterprise enterprise;
    private static Logger log = Logger.getLogger(ManageUserAccountJpanel.class);
    private static final String CLASS_NAME = ManageUserAccountJpanel.class.getName();
    /**
     * Creates new form ManageUserAccountJpanel
     */
    public ManageUserAccountJpanel(JPanel container, Enterprise enterprise) {
        initComponents();
        this.container = container;
        this.enterprise = enterprise;
        populateData();
        populateOrganizationComboBox();
        
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
        userTbl = new javax.swing.JTable();
        manageuserLbl = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        organizationComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        employeeComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        roleComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        createUserbtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userTbl.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        userTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        userTbl.setRowHeight(22);
        jScrollPane1.setViewportView(userTbl);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, 264));

        manageuserLbl.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        manageuserLbl.setText("Manage User Account");
        add(manageuserLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel5.setText("Organization:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 150, 30));

        organizationComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        organizationComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationComboBoxActionPerformed(evt);
            }
        });
        add(organizationComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 430, 220, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel3.setText("Employee:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 180, 30));

        employeeComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        employeeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(employeeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, 220, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setText("Role:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 90, 30));

        roleComboBox.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        roleComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(roleComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 530, 220, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("User Name:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, 140, 30));

        nametxt.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        add(nametxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 570, 220, 40));

        passwordTxt.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        add(passwordTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 620, 220, 40));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Password:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 620, 140, 30));

        backBtn.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        backBtn.setText(" Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 570, 120, 60));

        createUserbtn.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        createUserbtn.setText("Create User Account");
        createUserbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserbtnActionPerformed(evt);
            }
        });
        add(createUserbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, 310, 70));
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
         container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backBtnActionPerformed

    private void organizationComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationComboBoxActionPerformed
        // TODO add your handling code here:
           Organization organization = (Organization) organizationComboBox.getSelectedItem();
        if (organization != null){
            populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }

    }//GEN-LAST:event_organizationComboBoxActionPerformed

    private void createUserbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserbtnActionPerformed
        // TODO add your handling code here:
           String userName = nametxt.getText().trim();
        String password = passwordTxt.getText();
        Organization organization = (Organization) organizationComboBox.getSelectedItem();
        Employee employee = (Employee) employeeComboBox.getSelectedItem();
        Role role = (Role) roleComboBox.getSelectedItem();
        ArrayList<String>usernamecheck = new ArrayList<>();
        for(UserAccount e: organization.getUserAccountDirectory().getUserAccountList())
        {
            usernamecheck.add(e.getUsername());
            
        }
        if(usernamecheck.contains(userName))
        {
            JOptionPane.showMessageDialog(null,"UserName already exists");
            return;
        }
        if(userName.isEmpty()||password.isEmpty())
        {
         JOptionPane.showMessageDialog(null,"Please enter a Valid input");
            return;   
        }
        log.debug("Enterprise admin creating user with name \t" +userName+ "Role" +role+ "In Organization" +organization+ "\t" +CLASS_NAME);
        organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
        
        populateData();
        nametxt.setText("");
        passwordTxt.setText("");
    }//GEN-LAST:event_createUserbtnActionPerformed
public void populateEmployeeComboBox(Organization organization){
        employeeComboBox.removeAllItems();
        
        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
            employeeComboBox.addItem(employee);
        }
    }
 public void populateOrganizationComboBox() {
        organizationComboBox.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            organizationComboBox.addItem(organization);
        }
    }
    
private void populateRoleComboBox(Organization organization){
        roleComboBox.removeAllItems();
        for (Role role : organization.getSupportedRole()){
            roleComboBox.addItem(role);
        }
    }
 public void populateData() {

        DefaultTableModel model = (DefaultTableModel) userTbl.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[2];
                row[0] = ua;
                row[1] = ua.getRole();
                ((DefaultTableModel) userTbl.getModel()).addRow(row);
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton createUserbtn;
    private javax.swing.JComboBox employeeComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel manageuserLbl;
    private javax.swing.JTextField nametxt;
    private javax.swing.JComboBox organizationComboBox;
    private javax.swing.JTextField passwordTxt;
    private javax.swing.JComboBox roleComboBox;
    private javax.swing.JTable userTbl;
    // End of variables declaration//GEN-END:variables
}
