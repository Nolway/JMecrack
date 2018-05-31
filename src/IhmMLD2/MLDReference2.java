/*    */ package IhmMLD2;
/*    */ 
/*    */ import Merise2.Attribut2;
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MLDReference2
/*    */   implements Serializable
/*    */ {
/*    */   MLDEntite2 entite;
/*    */   MLDEntite2 entiteRef;
/*    */   Attribut2 attribut;
/*    */   Attribut2 attributRef;
/*    */   boolean SQLGenerer;
/*    */   
/*    */   public MLDReference2()
/*    */   {
/* 23 */     this.entite = null;
/* 24 */     this.entiteRef = null;
/* 25 */     this.attribut = null;
/* 26 */     this.attributRef = null;
/* 27 */     this.SQLGenerer = false;
/*    */   }
/*    */   
/*    */   public MLDReference2(MLDEntite2 entite, MLDEntite2 entiteRef, Attribut2 attribut, Attribut2 attributRef) {
/* 31 */     this.entite = entite;
/* 32 */     this.entiteRef = entiteRef;
/* 33 */     this.attribut = attribut;
/* 34 */     this.attributRef = attributRef;
/*    */   }
/*    */   
/*    */   public Attribut2 getAttribut() {
/* 38 */     return this.attribut;
/*    */   }
/*    */   
/*    */   public Attribut2 getAttributRef() {
/* 42 */     return this.attributRef;
/*    */   }
/*    */   
/*    */   public MLDEntite2 getEntite() {
/* 46 */     return this.entite;
/*    */   }
/*    */   
/*    */   public MLDEntite2 getEntiteRef() {
/* 50 */     return this.entiteRef;
/*    */   }
/*    */   
/*    */   public void setAttribut(Attribut2 attribut) {
/* 54 */     this.attribut = attribut;
/*    */   }
/*    */   
/*    */   public void setAttributRef(Attribut2 attributRef) {
/* 58 */     this.attributRef = attributRef;
/*    */   }
/*    */   
/*    */   public void setEntite(MLDEntite2 entite) {
/* 62 */     this.entite = entite;
/*    */   }
/*    */   
/*    */   public void setEntiteRef(MLDEntite2 entiteRef) {
/* 66 */     this.entiteRef = entiteRef;
/*    */   }
/*    */   
/*    */   public boolean iSSQLGenerer() {
/* 70 */     return this.SQLGenerer;
/*    */   }
/*    */   
/*    */   public void setSQLGenerer(boolean SQLGenerer) {
/* 74 */     this.SQLGenerer = SQLGenerer;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMLD2\MLDReference2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */