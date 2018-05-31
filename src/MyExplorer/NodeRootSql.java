/*    */ package MyExplorer;
/*    */ 
/*    */ import ihm.FormeInterneSQL;
/*    */ import javax.swing.tree.DefaultMutableTreeNode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NodeRootSql
/*    */   extends DefaultMutableTreeNode
/*    */ {
/*    */   private FormeInterneSQL formeSql;
/*    */   
/*    */   public NodeRootSql(FormeInterneSQL formSql)
/*    */   {
/* 20 */     this.formeSql = formSql;
/*    */   }
/*    */   
/*    */   public FormeInterneSQL getFormeSql() {
/* 24 */     return this.formeSql;
/*    */   }
/*    */   
/*    */   public void setFormeSql(FormeInterneSQL formeSql) {
/* 28 */     this.formeSql = formeSql;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 33 */     return "SQL ";
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyExplorer\NodeRootSql.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */