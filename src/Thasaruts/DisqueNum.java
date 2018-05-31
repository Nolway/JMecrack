/*    */ package Thasaruts;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DisqueNum
/*    */   implements Serializable
/*    */ {
/*    */   String nom;
/*    */   String numero;
/*    */   
/*    */   public DisqueNum()
/*    */   {
/* 19 */     this.nom = "";
/* 20 */     this.numero = "";
/*    */   }
/*    */   
/*    */   public String getNom() {
/* 24 */     return this.nom;
/*    */   }
/*    */   
/*    */   public String getNumero() {
/* 28 */     return this.numero;
/*    */   }
/*    */   
/*    */   public void setNom(String nom) {
/* 32 */     this.nom = nom;
/*    */   }
/*    */   
/*    */   public void setNumero(String numero) {
/* 36 */     this.numero = numero;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Thasaruts\DisqueNum.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */