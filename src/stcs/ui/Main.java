/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stcs.ui;

/**
 *
 * @author lucas-fang
 */
public class Main {
    public static LoginUI login;
    public static StMenuUI stMenu;
    //public static AdminMenuUI adminMenu;
    public static MemberAddUI memberAdd;
    public static MemberUpdateUI memberUpdate;
    public static MemberViewUI memberView;
    //public static SocietyAddUI societyAdd;
    //public static SocietyEditUI societyEdit;
    //public static SocietyViewUI societyView;
    //public static PassChangeUI passChange;
    
    public static int st_id;
    
    public static void main(String[] args) {
        /*Create and dispaly the dialog*/
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                login = new LoginUI(new javax.swing.JFrame(),true);
                login.setVisible(true);
            }
        });
    
    }
    
}
