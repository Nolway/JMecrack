/*    */ package MyExplorerBD;
/*    */ 
/*    */ import composantSQL.Column;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NodeColumn
/*    */   extends NodeBD
/*    */ {
/*    */   private Column colonne;
/*    */   
/*    */   public NodeColumn(Column colonne)
/*    */   {
/* 19 */     this.colonne = colonne;
/*    */   }
/*    */   
/*    */   public Column getColumn() {
/* 23 */     return this.colonne;
/*    */   }
/*    */   
/*    */   public void setColumn(Column table) {
/* 27 */     this.colonne = table;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 32 */     return this.colonne.getName();
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyExplorerBD\NodeColumn.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */