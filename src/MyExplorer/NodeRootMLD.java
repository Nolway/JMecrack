/*    */ package MyExplorer;
/*    */ 
/*    */ import ihm.FormeInterneMLD;
/*    */ import javax.swing.tree.DefaultMutableTreeNode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NodeRootMLD
/*    */   extends DefaultMutableTreeNode
/*    */ {
/*    */   private FormeInterneMLD formeMLD;
/*    */   
/*    */   public NodeRootMLD(FormeInterneMLD formeMLD)
/*    */   {
/* 20 */     this.formeMLD = formeMLD;
/*    */   }
/*    */   
/*    */   public FormeInterneMLD getFormeMLD() {
/* 24 */     return this.formeMLD;
/*    */   }
/*    */   
/*    */   public void setFormeMLD(FormeInterneMLD formeMLD) {
/* 28 */     this.formeMLD = formeMLD;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 33 */     return "MLD ";
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyExplorer\NodeRootMLD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */