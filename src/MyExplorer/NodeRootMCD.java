/*    */ package MyExplorer;
/*    */ 
/*    */ import ihm.FormeInterneMCD;
/*    */ import javax.swing.tree.DefaultMutableTreeNode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NodeRootMCD
/*    */   extends DefaultMutableTreeNode
/*    */ {
/*    */   private FormeInterneMCD formeMCD;
/*    */   
/*    */   public NodeRootMCD(FormeInterneMCD formeMCD)
/*    */   {
/* 20 */     this.formeMCD = formeMCD;
/*    */   }
/*    */   
/*    */   public FormeInterneMCD getFormeMCD() {
/* 24 */     return this.formeMCD;
/*    */   }
/*    */   
/*    */   public void setFormeMCD(FormeInterneMCD formeMCD) {
/* 28 */     this.formeMCD = formeMCD;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 32 */     return "MCD ";
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyExplorer\NodeRootMCD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */