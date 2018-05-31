/*    */ package Menu;
/*    */ 
/*    */ import IhmMCD.IhmProjet;
/*    */ import ihm.FormeInterneMCD;
/*    */ import ihm.Principale;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.beans.PropertyVetoException;
/*    */ import java.io.File;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ import javax.swing.JMenuItem;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MyMenuItem
/*    */   extends JMenuItem
/*    */   implements ActionListener
/*    */ {
/*    */   private String nom;
/*    */   private String chemin;
/*    */   private Principale frm;
/*    */   
/*    */   public MyMenuItem(Principale frm, String chemin)
/*    */   {
/* 29 */     super(chemin);
/* 30 */     this.chemin = chemin;
/* 31 */     this.frm = frm;
/* 32 */     addActionListener(this);
/*    */   }
/*    */   
/*    */   public String getChemin() {
/* 36 */     return this.chemin;
/*    */   }
/*    */   
/*    */   public String getNom() {
/* 40 */     return this.nom;
/*    */   }
/*    */   
/*    */   public void setChemin(String chemin) {
/* 44 */     this.chemin = chemin;
/*    */   }
/*    */   
/*    */   public void setNom(String nom) {
/* 48 */     this.nom = nom;
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent e) {
/* 52 */     File fil = new File(getChemin());
/* 53 */     if (fil.exists()) {
/* 54 */       IhmProjet pro = this.frm.dejaOuvertProjet(getChemin());
/* 55 */       if (pro == null) {
/* 56 */         if (this.frm.getProjetSel() != null) {
/* 57 */           if (this.frm.getProjetSel().getFormeMCD().isPageMCDVide()) {
/* 58 */             this.frm.getProjetSel().getFormeMCD().setModifier(false);
/* 59 */             this.frm.getProjetSel().getFormeMCD().ouvrirMCDAvecNomFichier(true, getChemin());
/*    */           } else {
/* 61 */             boolean mod = this.frm.getProjetSel().getFormeMCD().isModifier();
/* 62 */             this.frm.getProjetSel().getFormeMCD().setModifier(false);
/* 63 */             this.frm.getProjetSel().getFormeMCD().ouvrirMCDAvecNomFichier(false, getChemin());
/* 64 */             this.frm.getProjetSel().getFormeMCD().setModifier(mod);
/*    */           }
/*    */         }
/* 67 */         this.frm.repaint();
/*    */       } else {
/* 69 */         JOptionPane.showMessageDialog(this.frm, "Le MCD : \" " + getChemin() + " \" est déja ouvert !");
/* 70 */         this.frm.setProjetMain(pro);
/*    */         try {
/* 72 */           this.frm.getFormeMCD().setIcon(false);
/* 73 */           this.frm.getFormeMCD().setVisible(true);
/* 74 */           this.frm.getFormeMCD().toFront();
/*    */         } catch (PropertyVetoException ex) {
/* 76 */           Logger.getLogger(MyMenuItem.class.getName()).log(Level.SEVERE, null, ex);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 84 */     return this.chemin;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Menu\MyMenuItem.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */