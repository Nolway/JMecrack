/*    */ package Contrainte;
/*    */ 
/*    */ import Merise.Attribut;
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AttributReference
/*    */   implements Serializable
/*    */ {
/*    */   Attribut attribut;
/*    */   Attribut attributRef;
/*    */   
/*    */   public AttributReference(Attribut attribut, Attribut attributRef)
/*    */   {
/* 20 */     this.attribut = attribut;
/* 21 */     this.attributRef = attributRef;
/*    */   }
/*    */   
/*    */   public Attribut getAttribut() {
/* 25 */     return this.attribut;
/*    */   }
/*    */   
/*    */   public Attribut getAttributRef() {
/* 29 */     return this.attributRef;
/*    */   }
/*    */   
/*    */   public void setAttribut(Attribut attribut) {
/* 33 */     this.attribut = attribut;
/*    */   }
/*    */   
/*    */   public void setAttributRef(Attribut attributRef) {
/* 37 */     this.attributRef = attributRef;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 42 */     if (this.attribut == null) return "===Attribut null";
/* 43 */     if (this.attributRef == null) return "==> Attribut Ref null";
/* 44 */     return "<" + this.attribut.getNom() + "," + this.attributRef.getNom() + ">";
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Contrainte\AttributReference.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */