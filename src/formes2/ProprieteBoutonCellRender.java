/*    */ package formes2;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.awt.Font;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.TableCellRenderer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ProprieteBoutonCellRender
/*    */   extends JButton
/*    */   implements TableCellRenderer
/*    */ {
/*    */   public ProprieteBoutonCellRender()
/*    */   {
/* 24 */     setText("");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
/*    */   {
/* 33 */     setText("" + (row + 1));
/* 34 */     setFont(new Font("Tahoma", 1, 8));
/*    */     
/* 36 */     if (row % 2 == 1) {
/* 37 */       setBackground(Color.WHITE);
/*    */     } else {
/* 39 */       setBackground(Color.LIGHT_GRAY);
/*    */     }
/*    */     
/* 42 */     if (isSelected) {
/* 43 */       setBackground(table.getSelectionBackground());
/*    */     }
/*    */     
/* 46 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\ProprieteBoutonCellRender.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */