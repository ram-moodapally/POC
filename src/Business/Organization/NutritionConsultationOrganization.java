/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;
import Business.Role.NutritionConsultantRole;
import Business.Role.Role;
import Business.Role.UserRole;
import java.util.ArrayList;


/**
 *
 * @author shreyasprasad
 */
public class NutritionConsultationOrganization extends  Organization{
 
    public NutritionConsultationOrganization(){
        super(Organization.Type.NutritionConsultation.getValue());
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new NutritionConsultantRole());
        return roles;
    }    



}


   
    
  