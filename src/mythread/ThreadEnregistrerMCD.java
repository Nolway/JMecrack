/*    */ package mythread;
/*    */ 
/*    */ import formes.FormeConstruction;
/*    */ import ihm.Principale;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JProgressBar;
/*    */ import javax.swing.SwingWorker;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ThreadEnregistrerMCD
/*    */   extends SwingWorker
/*    */ {
/*    */   private Principale frm;
/*    */   private String cheminFichier;
/*    */   
/*    */   public ThreadEnregistrerMCD(Principale frm, String cheminFichier)
/*    */   {
/* 21 */     this.frm = frm;
/* 22 */     this.cheminFichier = cheminFichier;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected Object doInBackground()
/*    */     throws Exception
/*    */   {
/* 63 */     FormeConstruction frmCons = new FormeConstruction(this.frm, true);
/* 64 */     frmCons.setModal(false);
/* 65 */     frmCons.getjLabNom().setText("Enregistrement du MCD");
/*    */     
/* 67 */     frmCons.setVisible(true);
/* 68 */     frmCons.getjProgBar().setValue(10);
/*    */     
/* 70 */     frmCons.getjProgBar().setValue(100);
/* 71 */     frmCons.dispose();
/* 72 */     return Integer.valueOf(0);
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\mythread\ThreadEnregistrerMCD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */