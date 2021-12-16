/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author ram
 */
public class FitSuppWorkRequest extends WorkRequest{
    String suppName ;
    int supQuantity;
    String suppMessage;

    public String getSuppName() {
        return suppName;
    }

    public void setSuppName(String suppName) {
        this.suppName = suppName;
    }

    public int getSupQuantity() {
        return supQuantity;
    }

    public void setSupQuantity(int supQuantity) {
        this.supQuantity = supQuantity;
    }

    public String getSuppMessage() {
        return suppMessage;
    }

    public void setSuppMessage(String suppMessage) {
        this.suppMessage = suppMessage;
    }
    
    
}
