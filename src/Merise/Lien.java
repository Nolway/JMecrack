/*    */ package Merise;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Lien
/*    */   implements Serializable
/*    */ {
/*    */   private Entite entite;
/*    */   private Relation relation;
/*    */   private String cardinalite;
/*    */   
/*    */   public Lien(Entite entite, Relation relation, String cardinalite)
/*    */   {
/* 20 */     this.entite = entite;
/* 21 */     this.relation = relation;
/* 22 */     this.cardinalite = cardinalite;
/*    */   }
/*    */   
/*    */   public Lien(Entite entite, Relation relation) {
/* 26 */     this.entite = entite;
/* 27 */     this.relation = relation;
/* 28 */     this.cardinalite = "0,n";
/*    */   }
/*    */   
/*    */   public String getCardinalite() {
/* 32 */     return this.cardinalite;
/*    */   }
/*    */   
/*    */   public Entite getEntite() {
/* 36 */     return this.entite;
/*    */   }
/*    */   
/*    */   public Relation getRelation() {
/* 40 */     return this.relation;
/*    */   }
/*    */   
/*    */   public void setCardinalite(String cardinalite) {
/* 44 */     this.cardinalite = cardinalite;
/*    */   }
/*    */   
/*    */   public void setEntite(Entite entite) {
/* 48 */     this.entite = entite;
/*    */   }
/*    */   
/*    */   public void setRelation(Relation relation) {
/* 52 */     this.relation = relation;
/*    */   }
/*    */   
/*    */   public Lien copier() {
/* 56 */     return new Lien(getEntite().copier(), getRelation().copier(), getCardinalite());
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Merise\Lien.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */