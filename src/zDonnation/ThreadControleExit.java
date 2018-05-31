/*    */ package zDonnation;
/*    */ 
/*    */ import Outil.Parametres;
/*    */ import ihm.Principale;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ThreadControleExit
/*    */   extends Thread
/*    */ {
/*    */   Principale frm;
/*    */   FormeNewDonnation frmDon;
/*    */   boolean firstExec;
/*    */   int duree1;
/*    */   int duree2;
/*    */   
/*    */   public ThreadControleExit(Principale frm)
/*    */   {
/* 25 */     this.frm = frm;
/* 26 */     this.firstExec = Parametres.firstExec;
/* 27 */     start();
/*    */   }
/*    */   
/*    */   private int dureeAleatoire() {
/* 31 */     double quinze = 300.0D;
/* 32 */     quinze *= Math.random();
/* 33 */     return (int)quinze;
/*    */   }
/*    */   
/*    */   private int dureeAleatoire2()
/*    */   {
/* 38 */     double quinze = 900.0D;
/* 39 */     quinze *= Math.random();
/* 40 */     return (int)quinze;
/*    */   }
/*    */   
/*    */ 
/*    */   private int getFirstDuree()
/*    */   {
/* 46 */     if (this.firstExec) return 600 + dureeAleatoire();
/* 47 */     return 420 + dureeAleatoire();
/*    */   }
/*    */   
/*    */   private int getEndDuree()
/*    */   {
/* 52 */     if (this.firstExec) return 480 + dureeAleatoire();
/* 53 */     return 300 + dureeAleatoire();
/*    */   }
/*    */   
/*    */   public void run()
/*    */   {
/*    */     try {
/* 59 */       int dur1 = getFirstDuree();int dur2 = getEndDuree();
/* 60 */       JOptionPane.showMessageDialog(this.frm, " Certaines fonctionnalités sont désactivées, \n elles ne sont pas encore développées :" + dur1 / 60 + " : " + dur2 / 60);
/*    */       
/* 62 */       TimeUnit.SECONDS.sleep(dur1);
/*    */       for (;;) {
/* 64 */         new FormeNewDonnation(this.frm, true).setVisible(true);
/* 65 */         dur2 = getEndDuree();
/* 66 */         TimeUnit.SECONDS.sleep(dur2);
/*    */       }
/*    */       
/*    */     }
/*    */     catch (InterruptedException ex)
/*    */     {
/* 72 */       ex.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\zDonnation\ThreadControleExit.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */