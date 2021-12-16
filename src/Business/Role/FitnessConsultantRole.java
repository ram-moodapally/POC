/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.FitnessConsultationOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.FitnessConsultationRole.FitnessConsultationJPanel;


/**
 *
 * @author shreyasprasad
 */
public class FitnessConsultantRole  extends  Role{
    
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business,Network network) {
        return new FitnessConsultationJPanel(userProcessContainer,account,(FitnessConsultationOrganization)organization,enterprise,business,network);
    }
    
}
