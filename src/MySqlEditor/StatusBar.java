/*    */ package MySqlEditor;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.GroupLayout.Alignment;
/*    */ import javax.swing.GroupLayout.ParallelGroup;
/*    */ import javax.swing.GroupLayout.SequentialGroup;
/*    */ import javax.swing.ImageIcon;
/*    */ import javax.swing.JLabel;
/*    */ import javax.swing.JPanel;
/*    */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*    */ import javax.swing.LayoutStyle.ComponentPlacement;
/*    */ 
/*    */ public class StatusBar
/*    */   extends JPanel
/*    */ {
/*    */   private JLabel labInfo;
/*    */   private JTextField findField;
/*    */   private JLabel labClose;
/*    */   
/*    */   public StatusBar()
/*    */   {
/* 23 */     this.labInfo = new JLabel("Find  :");
/* 24 */     this.labClose = new JLabel();
/* 25 */     this.findField = new JTextField();
/*    */     
/* 27 */     setBackground(new Color(153, 153, 153));
/* 28 */     this.labClose.setIcon(new ImageIcon(getClass().getResource("close.png")));
/*    */     
/*    */ 
/* 31 */     GroupLayout jPanel3Layout = new GroupLayout(this);
/* 32 */     setLayout(jPanel3Layout);
/* 33 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.labClose).addGap(28, 28, 28).addComponent(this.labInfo).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.findField, -1, 644, 32767).addContainerGap()));
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
/* 44 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.labClose).addComponent(this.labInfo).addComponent(this.findField, -2, -1, -2)).addContainerGap(-1, 32767)));
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
/*    */   public JTextField getFindField()
/*    */   {
/* 59 */     return this.findField;
/*    */   }
/*    */   
/*    */   public JLabel getLabClose() {
/* 63 */     return this.labClose;
/*    */   }
/*    */   
/*    */   public JLabel getLabInfo() {
/* 67 */     return this.labInfo;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MySqlEditor\StatusBar.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */