/*    */ package IhmMLD;
/*    */ 
/*    */ import IhmMCD.IhmEntite;
/*    */ import Merise.Entite;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MLDEntiteCardinalite
/*    */ {
/*    */   private IhmEntite entite;
/*    */   private String cardinalite;
/*    */   private String nomLien;
/*    */   
/*    */   public MLDEntiteCardinalite(IhmEntite entite, String cardinalite, String nomLien)
/*    */   {
/* 20 */     this.entite = entite;
/* 21 */     this.cardinalite = cardinalite;
/* 22 */     this.nomLien = nomLien;
/*    */   }
/*    */   
/*    */   public String getCardinalite() {
/* 26 */     return this.cardinalite;
/*    */   }
/*    */   
/*    */   public IhmEntite getEntite() {
/* 30 */     return this.entite;
/*    */   }
/*    */   
/*    */   public void setCardinalite(String cardinalite) {
/* 34 */     this.cardinalite = cardinalite;
/*    */   }
/*    */   
/*    */   public void setEntite(IhmEntite entite) {
/* 38 */     this.entite = entite;
/*    */   }
/*    */   
/*    */   public void afficherEntiteCardinalite() {
/* 42 */     System.out.print(this.entite.getEntite().getNom() + " : " + this.cardinalite + "--\t");
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMLD\MLDEntiteCardinalite.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */