/*    */ package MyExplorer;
/*    */ 
/*    */ import IhmMCD.IhmProjet;
/*    */ import javax.swing.tree.DefaultMutableTreeNode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NodeProjet
/*    */   extends DefaultMutableTreeNode
/*    */ {
/*    */   private IhmProjet projet;
/*    */   
/*    */   public NodeProjet(IhmProjet proj)
/*    */   {
/* 20 */     this.projet = proj;
/*    */   }
/*    */   
/*    */   public IhmProjet getProjet() {
/* 24 */     return this.projet;
/*    */   }
/*    */   
/*    */   public void setProjet(IhmProjet projet) {
/* 28 */     this.projet = projet;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 33 */     return this.projet.toString();
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyExplorer\NodeProjet.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */