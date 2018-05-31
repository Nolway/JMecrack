/*    */ package composantSQL;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Table
/*    */ {
/*    */   private String name;
/*    */   private ArrayList<Column> columnList;
/*    */   private String comment;
/*    */   
/*    */   public Table(String name, String comment)
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
/*    */   public void addColumn(Column col)
/*    */   {
/* 52 */     this.columnList.add(col);
/*    */   }
/*    */   
/*    */   public void removeColumn(Column col) {
/* 56 */     this.columnList.remove(col);
/*    */   }
/*    */   
/*    */   public Table copier() {
/* 60 */     Table t = new Table(this.name, this.comment);
/* 61 */     for (int i = 0; i < this.columnList.size(); i++) {
/* 62 */       t.getColumnList().add(((Column)getColumnList().get(i)).copier());
/*    */     }
/* 64 */     return t;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 69 */     return this.name;
/*    */   }
/*    */   
/*    */   public void afficherTable() {
/* 73 */     System.out.println("========== : table " + this.name + "  =========");
/* 74 */     for (int i = 0; i < this.columnList.size(); i++) {
/* 75 */       System.out.println(((Column)this.columnList.get(i)).toString());
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\composantSQL\Table.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */