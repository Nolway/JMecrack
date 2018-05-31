/*    */ package formes2;
/*    */ 
/*    */ import IhmMCD.IhmEntiteRelation;
/*    */ import Merise.Attribut;
/*    */ import Merise2.Attribut2;
/*    */ import ihm.Principale;
/*    */ import java.awt.Component;
/*    */ import java.awt.event.ActionEvent;
/*    */ import java.awt.event.ActionListener;
/*    */ import java.util.ArrayList;
/*    */ import javax.swing.AbstractCellEditor;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JButton;
/*    */ import javax.swing.JTable;
/*    */ import javax.swing.table.TableCellEditor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ProprieteBoutonCellEditor
/*    */   extends AbstractCellEditor
/*    */   implements TableCellEditor, ActionListener
/*    */ {
/*    */   private Attribut2 attribut;
/*    */   private ArrayList<Attribut> list;
/*    */   private Principale frm;
/*    */   JTable table;
/*    */   JButton bt;
/*    */   Object entite;
/*    */   private Attribut2 attributPere;
/*    */   
/*    */   public ProprieteBoutonCellEditor(ArrayList<Attribut> list, Principale frm, Object ent, Attribut2 attPere)
/*    */   {
/* 36 */     this.list = list;
/* 37 */     this.attribut = null;
/* 38 */     this.frm = frm;
/* 39 */     this.entite = ent;
/* 40 */     this.attributPere = attPere;
/*    */   }
/*    */   
/*    */ 
/*    */   public Object getCellEditorValue()
/*    */   {
/* 46 */     return this.attribut;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
/*    */   {
/* 53 */     this.bt = new JButton("");
/*    */     
/* 55 */     this.bt.addActionListener(this);
/* 56 */     this.bt.setVisible(true);
/* 57 */     this.attribut = ((Attribut2)this.list.get(row));
/* 58 */     this.bt.setIcon(new ImageIcon(getClass().getResource("/Images/oeil.png")));
/* 59 */     this.table = table;
/* 60 */     return this.bt;
/*    */   }
/*    */   
/*    */   public void setListAttribut(ArrayList<Attribut> list)
/*    */   {
/* 65 */     this.list = list;
/*    */   }
/*    */   
/*    */   public void actionPerformed(ActionEvent event)
/*    */   {
/* 70 */     if (this.attribut != null)
/*    */     {
/*    */ 
/* 73 */       new FormeProprieteAttribut2(this.frm, true, this.attribut, this.attribut.getListeAttributs(), this.entite, true, this.attributPere).setVisible(true);
/*    */       
/* 75 */       if (!(this.entite instanceof IhmEntiteRelation)) {
/* 76 */         this.attribut.setKey("");
/* 77 */         this.attribut.setHistorisation("");
/*    */       }
/* 79 */       this.table.repaint();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\ProprieteBoutonCellEditor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */