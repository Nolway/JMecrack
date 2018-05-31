/*     */ package formes;
/*     */ 
/*     */ import IhmMCD.IhmLienHeritage;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class FormeLienHeritageIndep extends javax.swing.JDialog
/*     */ {
/*     */   private IhmLienHeritage lien;
/*     */   private javax.swing.ButtonGroup buttonGroup1;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JCheckBox jCBPointCassure;
/*     */   private JLabel jLabel2;
/*     */   private JTextField jTFNom;
/*     */   
/*     */   public FormeLienHeritageIndep(java.awt.Frame parent, boolean modal, IhmLienHeritage lien, int x, int y)
/*     */   {
/*  26 */     super(parent, modal);
/*  27 */     initComponents();
/*  28 */     setLocation(500, 400);
/*  29 */     this.lien = lien;
/*  30 */     this.jButton2.setMnemonic(65);
/*  31 */     this.jButton1.setMnemonic(10);
/*  32 */     if (lien != null) { this.jCBPointCassure.setSelected(lien.isCassure());
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
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  46 */     this.buttonGroup1 = new javax.swing.ButtonGroup();
/*  47 */     this.jLabel2 = new JLabel();
/*  48 */     this.jTFNom = new JTextField();
/*  49 */     this.jCBPointCassure = new JCheckBox();
/*  50 */     this.jButton2 = new JButton();
/*  51 */     this.jButton1 = new JButton();
/*     */     
/*  53 */     setDefaultCloseOperation(2);
/*  54 */     setTitle("Proprieté du lien héritage ");
/*  55 */     setResizable(false);
/*     */     
/*  57 */     this.jLabel2.setText("Nom du lien :");
/*     */     
/*  59 */     this.jCBPointCassure.setText("    Point de cassure");
/*  60 */     this.jCBPointCassure.setHorizontalAlignment(11);
/*  61 */     this.jCBPointCassure.setHorizontalTextPosition(4);
/*     */     
/*  63 */     this.jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/*  64 */     this.jButton2.setText("Annuler");
/*  65 */     this.jButton2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  67 */         FormeLienHeritageIndep.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/*  70 */     });
/*  71 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/*  72 */     this.jButton1.setText("OK");
/*  73 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  75 */         FormeLienHeritageIndep.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  78 */     });
/*  79 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  80 */     getContentPane().setLayout(layout);
/*  81 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBPointCassure).addGroup(layout.createSequentialGroup().addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.jTFNom, -1, 267, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -2, 88, -2))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  97 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFNom, -2, -1, -2).addComponent(this.jLabel2)).addGap(18, 18, 18).addComponent(this.jCBPointCassure).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton2).addComponent(this.jButton1)).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 113 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 117 */     dispose();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 121 */     if ((!this.lien.isCassure()) && (this.jCBPointCassure.isSelected())) {
/* 122 */       this.lien.initPointCassure();
/*     */     }
/* 124 */     this.lien.setNom(this.jTFNom.getText().trim());
/* 125 */     this.lien.setCassure(this.jCBPointCassure.isSelected());
/* 126 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeLienHeritageIndep.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */