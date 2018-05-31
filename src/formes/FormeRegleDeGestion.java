/*    */ package formes;
/*    */ 
/*    */ import Outil.ProprieteMCD;
/*    */ import ihm.FormeInterneMCD;
/*    */ import ihm.Principale;
/*    */ import java.awt.Color;
/*    */ import java.awt.Container;
/*    */ import java.awt.event.MouseEvent;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.GroupLayout.Alignment;
/*    */ import javax.swing.GroupLayout.ParallelGroup;
/*    */ import javax.swing.GroupLayout.SequentialGroup;
/*    */ import javax.swing.JFrame;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTextArea;
/*    */ 
/*    */ public class FormeRegleDeGestion extends JFrame
/*    */ {
/*    */   Principale frm;
/*    */   ProprieteMCD propreteMcd;
/*    */   private JScrollPane jScrollPane1;
/*    */   private JTextArea jTARegleGestion;
/*    */   
/*    */   public FormeRegleDeGestion(Principale frm)
/*    */   {
/* 26 */     initComponents();
/* 27 */     setLocation(frm.getX() + frm.getWidth() - getWidth() - 10, frm.getY() + frm.getHeight() - getHeight() - 10);
/* 28 */     this.frm = frm;
/*    */   }
/*    */   
/*    */   public void setText(String s) {
/* 32 */     this.jTARegleGestion.setText(s);
/*    */   }
/*    */   
/*    */   public String getText() {
/* 36 */     return this.jTARegleGestion.getText();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private void initComponents()
/*    */   {
/* 48 */     this.jScrollPane1 = new JScrollPane();
/* 49 */     this.jTARegleGestion = new JTextArea();
/*    */     
/* 51 */     setDefaultCloseOperation(2);
/* 52 */     setTitle("Régles de gestion");
/* 53 */     setAlwaysOnTop(true);
/* 54 */     setBackground(new Color(153, 153, 153));
/*    */     
/* 56 */     this.jTARegleGestion.setColumns(20);
/* 57 */     this.jTARegleGestion.setEditable(false);
/* 58 */     this.jTARegleGestion.setRows(5);
/* 59 */     this.jTARegleGestion.addMouseListener(new java.awt.event.MouseAdapter() {
/*    */       public void mouseClicked(MouseEvent evt) {
/* 61 */         FormeRegleDeGestion.this.jTARegleGestionMouseClicked(evt);
/*    */       }
/* 63 */     });
/* 64 */     this.jScrollPane1.setViewportView(this.jTARegleGestion);
/*    */     
/* 66 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 67 */     getContentPane().setLayout(layout);
/* 68 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 571, 32767).addContainerGap()));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 75 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 195, 32767).addContainerGap()));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 83 */     pack();
/*    */   }
/*    */   
/*    */   private void jTARegleGestionMouseClicked(MouseEvent evt) {
/* 87 */     if (evt.getClickCount() == 2) {
/* 88 */       FormeText f = new FormeText(this.frm, true, this.frm.getFormeMCD().getPage().getProprieteMCD(), true);
/* 89 */       f.setTitle("Règles de gestion");
/* 90 */       f.setVisible(true);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeRegleDeGestion.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */