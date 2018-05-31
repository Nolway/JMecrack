/*    */ package formes2;
/*    */ 
/*    */ import java.awt.Component;
/*    */ import javax.swing.AbstractCellEditor;
/*    */ import javax.swing.JCheckBox;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.TableCellEditor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CheckBoxCellEditor
/*    */   extends AbstractCellEditor
/*    */   implements TableCellEditor
/*    */ {
/*    */   JCheckBox choix;
/*    */   
/*    */   public CheckBoxCellEditor()
/*    */   {
/* 25 */     this.choix = new JCheckBox();
/*    */   }
/*    */   
/*    */   public Object getCellEditorValue()
/*    */   {
/* 30 */     return Boolean.valueOf(this.choix.isSelected());
/*    */   }
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
/*    */ 
/*    */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
/*    */   {
/* 46 */     return this.choix;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\CheckBoxCellEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */