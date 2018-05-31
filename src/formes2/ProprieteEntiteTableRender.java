/*    */ package formes2;
/*    */ 
/*    */ import Merise.Attribut;
/*    */ import Merise2.Attribut2;
/*    */ import java.awt.Color;
/*    */ import java.awt.Component;
/*    */ import java.awt.Font;
/*    */ import java.util.ArrayList;
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
/*    */ public class ProprieteEntiteTableRender
/*    */   extends DefaultTableCellRenderer
/*    */ {
/* 22 */   static Color c1 = new Color(250, 250, 250);
/* 23 */   static Color c2 = new Color(255, 255, 200);
/* 24 */   static Color cSel = new Color(160, 170, 255);
/* 25 */   static Color cCompo = new Color(255, 150, 125);
/* 26 */   static Font font = new Font("Tahoma", 1, 12);
/* 27 */   ArrayList<Attribut> listeAttribut = null;
/*    */   
/*    */ 
/*    */   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
/*    */   {
/* 32 */     super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
/*    */     
/* 34 */     if (row % 2 == 1) {
/* 35 */       setFont(font);
/* 36 */       setBackground(c1);
/*    */     } else {
/* 38 */       setFont(font);
/* 39 */       setBackground(c2);
/*    */     }
/* 41 */     if ((this.listeAttribut != null) && 
/* 42 */       (((Attribut2)this.listeAttribut.get(row)).getListeAttributs().size() > 0)) {
/* 43 */       setFont(font);
/* 44 */       setBackground(cCompo);
/*    */     }
/*    */     
/* 47 */     if (isSelected) {
/* 48 */       setBackground(cSel);
/*    */     }
/*    */     
/* 51 */     return this;
/*    */   }
/*    */   
/*    */   public ArrayList<Attribut> getListeAttribut() {
/* 55 */     return this.listeAttribut;
/*    */   }
/*    */   
/*    */   public void setListeAttribut(ArrayList<Attribut> listeAttribut) {
/* 59 */     this.listeAttribut = listeAttribut;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\ProprieteEntiteTableRender.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */