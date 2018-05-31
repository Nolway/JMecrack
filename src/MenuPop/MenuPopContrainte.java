/*     */ package MenuPop;
/*     */ 
/*     */ import IhmMCD.BarOutil;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.Action;
/*     */ import javax.swing.ButtonGroup;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JCheckBoxMenuItem;
/*     */ import javax.swing.JPopupMenu;
/*     */ import javax.swing.JPopupMenu.Separator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MenuPopContrainte
/*     */   extends JPopupMenu
/*     */   implements Action
/*     */ {
/*     */   private JCheckBoxMenuItem popMenuR;
/*     */   private JCheckBoxMenuItem popMenuCif;
/*     */   private Font fontgr;
/*     */   private Font fontnor;
/*     */   private BarOutil bar;
/*     */   
/*     */   public MenuPopContrainte(BarOutil bar)
/*     */   {
/*  31 */     this.bar = bar;
/*  32 */     ButtonGroup bg = new ButtonGroup();
/*  33 */     this.popMenuR = new JCheckBoxMenuItem("");
/*     */     
/*     */ 
/*     */ 
/*  37 */     this.popMenuCif = new JCheckBoxMenuItem("Contrainte CIF");
/*     */     
/*  39 */     this.fontgr = new Font("Tahoma", 1, 11);
/*  40 */     this.fontnor = new Font("Tahoma", 0, 11);
/*     */     
/*  42 */     this.popMenuCif.setActionCommand("CIF");
/*  43 */     this.popMenuR.setActionCommand("=");
/*     */     
/*     */ 
/*  46 */     this.popMenuCif.setSelected(true);
/*  47 */     this.popMenuCif.setIcon(new ImageIcon(getClass().getResource("/Images/cif.png")));
/*     */     
/*  49 */     this.popMenuR.setIcon(new ImageIcon(getClass().getResource("/Images/Contrainte=.png")));
/*     */     
/*     */ 
/*     */ 
/*  53 */     this.popMenuR.addActionListener(this);
/*     */     
/*  55 */     this.popMenuCif.addActionListener(this);
/*     */     
/*     */ 
/*     */ 
/*  59 */     bg.add(this.popMenuR);
/*     */     
/*  61 */     bg.add(this.popMenuCif);
/*     */     
/*  63 */     add(this.popMenuCif);
/*  64 */     add(new JPopupMenu.Separator());
/*  65 */     add(this.popMenuR);
/*     */     
/*     */ 
/*  68 */     setFontMenu();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void setFontMenu()
/*     */   {
/*  75 */     this.popMenuCif.setFont(this.fontnor);
/*  76 */     this.popMenuR.setFont(this.fontnor);
/*     */     
/*     */ 
/*  79 */     this.popMenuCif.setText("CIF");
/*  80 */     this.popMenuR.setText("Contrainte Relation ");
/*     */     
/*     */ 
/*  83 */     if (this.popMenuCif.isSelected()) {
/*  84 */       this.popMenuCif.setFont(this.fontgr);
/*  85 */       this.popMenuCif.setText("CIF ");
/*     */     }
/*  87 */     if (this.popMenuR.isSelected()) {
/*  88 */       this.popMenuR.setFont(this.fontgr);
/*  89 */       this.popMenuR.setText("Contrainte Relation");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Object getValue(String key)
/*     */   {
/* 102 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void putValue(String key, Object value) {}
/*     */   
/*     */ 
/*     */   public void actionPerformed(ActionEvent e)
/*     */   {
/* 111 */     if (e.getActionCommand().equals("CIF")) {
/* 112 */       setFontMenu();
/* 113 */       this.bar.setEtat("CIF");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 121 */     if (e.getActionCommand().equals("=")) {
/* 122 */       setFontMenu();
/* 123 */       this.bar.setEtat("CONTRAINTE=");
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MenuPop\MenuPopContrainte.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */