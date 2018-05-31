/*    */ package MyExplorer;
/*    */ 
/*    */ import IhmMLD2.MLDEntite2;
/*    */ import javax.swing.tree.DefaultMutableTreeNode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NodeEntiteMLD
/*    */   extends DefaultMutableTreeNode
/*    */ {
/*    */   private MLDEntite2 entiteMLD;
/*    */   
/*    */   public NodeEntiteMLD(MLDEntite2 entiteMLD)
/*    */   {
/* 19 */     this.entiteMLD = entiteMLD;
/*    */   }
/*    */   
/*    */   public MLDEntite2 getEntiteMLD() {
/* 23 */     return this.entiteMLD;
/*    */   }
/*    */   
/*    */   public void setEntiteMLD(MLDEntite2 entiteMLD) {
/* 27 */     this.entiteMLD = entiteMLD;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 32 */     return this.entiteMLD.getNom();
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyExplorer\NodeEntiteMLD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */