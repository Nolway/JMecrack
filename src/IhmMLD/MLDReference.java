/*    */ package IhmMLD;
/*    */ 
/*    */ import Merise.Attribut;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MLDReference
/*    */ {
/*    */   private Attribut attribut;
/*    */   private String nomAttibutRef;
/*    */   private String nomTableRef;
/*    */   private String nomTableAct;
/*    */   
/*    */   public MLDReference(Attribut attribut, String nomAttibut, String nomTableRef, String nomTableAct)
/*    */   {
/* 21 */     this.attribut = attribut;
/* 22 */     this.nomAttibutRef = nomAttibut;
/* 23 */     this.nomTableRef = nomTableRef;
/* 24 */     this.nomTableAct = nomTableAct;
/*    */   }
/*    */   
/*    */   public Attribut getAttribut() {
/* 28 */     return this.attribut;
/*    */   }
/*    */   
/*    */   public String getNomAttibutRef() {
/* 32 */     return this.nomAttibutRef;
/*    */   }
/*    */   
/*    */   public String getNomTableAct() {
/* 36 */     return this.nomTableAct;
/*    */   }
/*    */   
/*    */   public String getNomTableRef() {
/* 40 */     return this.nomTableRef;
/*    */   }
/*    */   
/*    */   public void setNomAttibutRef(String nomAttibutRef) {
/* 44 */     this.nomAttibutRef = nomAttibutRef;
/*    */   }
/*    */   
/*    */   public void setNomTableAct(String nomTableAct) {
/* 48 */     this.nomTableAct = nomTableAct;
/*    */   }
/*    */   
/*    */   public void setNomTableRef(String nomTableRef) {
/* 52 */     this.nomTableRef = nomTableRef;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMLD\MLDReference.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */