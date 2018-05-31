/*    */ package MyExplorer;
/*    */ 
/*    */ import IhmMCD.IhmRelation;
/*    */ import Merise.Relation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NodeRelation
/*    */   extends NodeEntiteRelation
/*    */ {
/*    */   IhmRelation relation;
/*    */   
/*    */   public NodeRelation(IhmRelation relation)
/*    */   {
/* 19 */     this.relation = relation;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 24 */     if (this.relation.getRelation().getNom() == null) return "vide";
/* 25 */     if (this.relation.getRelation().getNom().trim().length() == 0) return "vide";
/* 26 */     return this.relation.getRelation().getNom();
/*    */   }
/*    */   
/*    */   public IhmRelation getRelation() {
/* 30 */     return this.relation;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyExplorer\NodeRelation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */