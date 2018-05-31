/*    */ package MyExplorerBD;
/*    */ 
/*    */ import Outil.Parametres;
/*    */ import composantSQL.Column;
/*    */ import java.awt.Component;
/*    */ import javax.swing.Icon;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JTree;
/*    */ import javax.swing.tree.DefaultTreeCellRenderer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MyRenderBD
/*    */   extends DefaultTreeCellRenderer
/*    */ {
/*    */   private Icon tableIcon;
/*    */   private Icon colonneIcon;
/*    */   private Icon colonneIndexIcon;
/*    */   private Icon colonneUniqueIcon;
/*    */   private Icon colonneCleIcon;
/*    */   private Icon colonneCleEtrIcon;
/*    */   
/*    */   public MyRenderBD()
/*    */   {
/* 27 */     this.tableIcon = new ImageIcon(getClass().getResource("/Images/table16.png"));
/* 28 */     this.colonneIcon = new ImageIcon(getClass().getResource("/Images/colonne16.png"));
/* 29 */     this.colonneCleIcon = new ImageIcon(getClass().getResource("/Images/colonneCle16.png"));
/* 30 */     this.colonneIndexIcon = new ImageIcon(getClass().getResource("/Images/colonneIndex16.png"));
/* 31 */     this.colonneUniqueIcon = new ImageIcon(getClass().getResource("/Images/colonneUnique16.png"));
/* 32 */     this.colonneCleEtrIcon = new ImageIcon(getClass().getResource("/Images/cleEtrangere16.png"));
/*    */   }
/*    */   
/*    */   public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus)
/*    */   {
/* 37 */     super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
/*    */     
/* 39 */     if ((value instanceof NodeTable)) {
/* 40 */       setIcon(this.tableIcon);
/*    */     }
/* 42 */     else if ((value instanceof NodeColumn)) {
/* 43 */       setIcon(this.colonneIcon);
/* 44 */       if (((NodeColumn)value).getColumn().getIndex().equals(Parametres.Index)) setIcon(this.colonneIndexIcon);
/* 45 */       if (((NodeColumn)value).getColumn().getKey().equals(Parametres.Cle)) setIcon(this.colonneCleIcon);
/* 46 */       if (((NodeColumn)value).getColumn().getIndex().equals(Parametres.Unique)) setIcon(this.colonneUniqueIcon);
/* 47 */       if (((NodeColumn)value).getColumn().getTableFrKy().trim().length() != 0) setIcon(this.colonneCleEtrIcon);
/*    */     }
/*    */     else
/*    */     {
/* 51 */       setIcon(this.tableIcon);
/*    */     }
/*    */     
/* 54 */     return this;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyExplorerBD\MyRenderBD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */