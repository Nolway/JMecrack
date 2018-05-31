/*    */ package ihm;
/*    */ 
/*    */ import java.awt.Container;
/*    */ import java.awt.event.KeyAdapter;
/*    */ import java.awt.event.KeyEvent;
/*    */ import java.beans.PropertyVetoException;
/*    */ import javax.swing.GroupLayout;
/*    */ import javax.swing.GroupLayout.Alignment;
/*    */ import javax.swing.GroupLayout.ParallelGroup;
/*    */ import javax.swing.JInternalFrame;
/*    */ import javax.swing.event.InternalFrameEvent;
/*    */ import javax.swing.event.InternalFrameListener;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FormeInterneMerise
/*    */   extends JInternalFrame
/*    */ {
/*    */   private Principale formePrincipale;
/*    */   
/*    */   public FormeInterneMerise(Principale formePrincipale)
/*    */   {
/* 25 */     initComponents();
/* 26 */     setClosable(true);
/* 27 */     setIconifiable(true);
/* 28 */     setMaximizable(true);
/* 29 */     setResizable(true);
/* 30 */     setVisible(true);
/* 31 */     this.formePrincipale = formePrincipale;
/*    */   }
/*    */   
/*    */   public Principale getFormePrincipale() {
/* 35 */     return this.formePrincipale;
/*    */   }
/*    */   
/*    */   public void setFormePrincipale(Principale frm) {
/* 39 */     this.formePrincipale = frm;
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
/*    */   private void initComponents()
/*    */   {
/* 53 */     setDefaultCloseOperation(1);
/*    */     try {
/* 55 */       setSelected(true);
/*    */     } catch (PropertyVetoException e1) {
/* 57 */       e1.printStackTrace();
/*    */     }
/* 59 */     addInternalFrameListener(new InternalFrameListener() {
/*    */       public void internalFrameActivated(InternalFrameEvent evt) {
/* 61 */         FormeInterneMerise.this.formInternalFrameActivated(evt);
/*    */       }
/*    */       
/*    */       public void internalFrameClosed(InternalFrameEvent evt) {}
/*    */       
/*    */       public void internalFrameClosing(InternalFrameEvent evt) {}
/*    */       
/*    */       public void internalFrameDeactivated(InternalFrameEvent evt) {}
/*    */       
/*    */       public void internalFrameDeiconified(InternalFrameEvent evt) {}
/*    */       
/*    */       public void internalFrameIconified(InternalFrameEvent evt) {}
/*    */       
/*    */       public void internalFrameOpened(InternalFrameEvent evt) {}
/* 75 */     });
/* 76 */     addKeyListener(new KeyAdapter() {
/*    */       public void keyPressed(KeyEvent evt) {
/* 78 */         FormeInterneMerise.this.formKeyPressed(evt);
/*    */       }
/*    */       
/* 81 */     });
/* 82 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 83 */     getContentPane().setLayout(layout);
/* 84 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 554, 32767));
/*    */     
/*    */ 
/*    */ 
/* 88 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 395, 32767));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 93 */     pack();
/*    */   }
/*    */   
/*    */   private void formInternalFrameActivated(InternalFrameEvent evt) {}
/*    */   
/*    */   private void formKeyPressed(KeyEvent evt) {}
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\ihm\FormeInterneMerise.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */