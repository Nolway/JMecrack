/*    */ package formes2;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.awt.Font;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.DefaultTableCellRenderer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ProprieteEntiteTableRenderDico
/*    */   extends DefaultTableCellRenderer
/*    */ {
/*    */   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
/*    */   {
/* 24 */     super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
/*    */     
/* 26 */     if (row % 2 == 1) {
/* 27 */       setFont(new Font("Tahoma", 1, 12));
/*    */       
/* 29 */       setBackground(Color.WHITE);
/*    */     } else {
/* 31 */       setFont(new Font("Tahoma", 1, 12));
/* 32 */       setBackground(new Color(175, 203, 229, 90));
/*    */     }
/* 34 */     if (isSelected)
/*    */     {
/* 36 */       setBackground(Color.cyan);
/*    */     }
/*    */     
/* 39 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\ProprieteEntiteTableRenderDico.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */