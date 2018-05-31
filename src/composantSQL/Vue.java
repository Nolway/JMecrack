/*    */ package composantSQL;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Vue
/*    */ {
/*    */   private String name;
/*    */   private ArrayList<Column> columnList;
/*    */   private String comment;
/*    */   
/*    */   public Vue(String name, String comment)
/*    */   {
/* 21 */     this.name = name;
/* 22 */     this.columnList = new ArrayList();
/* 23 */     this.comment = comment;
/*    */   }
/*    */   
/*    */   public ArrayList<Column> getColumnList() {
/* 27 */     return this.columnList;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 31 */     return this.name;
/*    */   }
/*    */   
/*    */   public String getComment() {
/* 35 */     return this.comment;
/*    */   }
/*    */   
/*    */   public void setColumnList(ArrayList<Column> columnList) {
/* 39 */     this.columnList = columnList;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 43 */     this.name = name;
/*    */   }
/*    */   
/*    */   public void setComment(String comment) {
/* 47 */     this.comment = comment;
/*    */   }
/*    */   
/*    */   public void addColumn(Column col) {
/* 51 */     this.columnList.add(col);
/*    */   }
/*    */   
/*    */   public void removeColumn(Column col) {
/* 55 */     this.columnList.remove(col);
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\composantSQL\Vue.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */