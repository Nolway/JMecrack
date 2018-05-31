/*    */ package MyExplorerBD;
/*    */ 
/*    */ import composantSQL.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NodeTable
/*    */   extends NodeBD
/*    */ {
/*    */   private Table table;
/*    */   
/*    */   public NodeTable(Table table)
/*    */   {
/* 19 */     this.table = table;
/*    */   }
/*    */   
/*    */   public Table getTable() {
/* 23 */     return this.table;
/*    */   }
/*    */   
/*    */   public void setTable(Table table) {
/* 27 */     this.table = table;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 32 */     return this.table.getName();
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyExplorerBD\NodeTable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */