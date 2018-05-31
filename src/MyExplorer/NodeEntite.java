/*    */ package MyExplorer;
/*    */ 
/*    */ import IhmMCD.IhmEntite;
/*    */ import Merise.Entite;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NodeEntite
/*    */   extends NodeEntiteRelation
/*    */ {
/*    */   IhmEntite entite;
/*    */   
/*    */   public NodeEntite(IhmEntite relation)
/*    */   {
/* 19 */     this.entite = relation;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 24 */     return this.entite.getEntite().getNom();
/*    */   }
/*    */   
/*    */   public IhmEntite getEntite() {
/* 28 */     return this.entite;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyExplorer\NodeEntite.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */