/*    */ package MyExplorer;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Font;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.GroupLayout.Alignment;
/*    */ import javax.swing.GroupLayout.ParallelGroup;
/*    */ import javax.swing.GroupLayout.SequentialGroup;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JScrollPane;
/*    */ import javax.swing.JTextArea;
import javax.swing.LayoutStyle;
/*    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*    */ 
/*    */ public class ConsolePane
/*    */   extends JPanel
/*    */ {
/*    */   private JLabel jLabel1;
/*    */   private JScrollPane jScrollPane1;
/*    */   private JTextArea rapport;
/*    */   
/*    */   public ConsolePane()
/*    */   {
/* 24 */     initComponents();
/*    */   }
/*    */   
/*    */   public JTextArea getRapport() {
/* 28 */     return this.rapport;
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
/*    */   private void initComponents()
/*    */   {
/* 41 */     this.jScrollPane1 = new JScrollPane();
/* 42 */     this.rapport = new JTextArea();
/* 43 */     this.jLabel1 = new JLabel();
/*    */     
/* 45 */     setBackground(new Color(153, 153, 255));
/*    */     
/* 47 */     this.rapport.setColumns(20);
/* 48 */     this.rapport.setEditable(false);
/* 49 */     this.rapport.setRows(2);
/* 50 */     this.jScrollPane1.setViewportView(this.rapport);
/*    */     
/* 52 */     this.jLabel1.setFont(new Font("Tahoma", 1, 11));
/* 53 */     this.jLabel1.setText("Console :");
/*    */     
/* 55 */     GroupLayout layout = new GroupLayout(this);
/* 56 */     setLayout(layout);
/* 57 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel1, -2, 58, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 466, 32767)));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 65 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addComponent(this.jLabel1, -1, -1, 32767).addGap(29, 29, 29)).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 63, 32767));
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyExplorer\ConsolePane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */