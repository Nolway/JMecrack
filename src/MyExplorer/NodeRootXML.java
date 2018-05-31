/*    */ package MyExplorer;
/*    */ 
/*    */ import ihm.FormeInterneXML;
/*    */ import javax.swing.tree.DefaultMutableTreeNode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NodeRootXML
/*    */   extends DefaultMutableTreeNode
/*    */ {
/*    */   private FormeInterneXML formeXML;
/*    */   
/*    */   public NodeRootXML(FormeInterneXML formeXML)
/*    */   {
/* 20 */     this.formeXML = formeXML;
/*    */   }
/*    */   
/*    */   public FormeInterneXML getFormeXML() {
/* 24 */     return this.formeXML;
/*    */   }
/*    */   
/*    */   public void setFormeXML(FormeInterneXML formeXML) {
/* 28 */     this.formeXML = formeXML;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 33 */     return "XML ";
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyExplorer\NodeRootXML.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */