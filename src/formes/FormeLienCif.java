/*     */ package formes;
/*     */ 
/*     */ import IhmMCD.IhmLienCif;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ 
/*     */ public class FormeLienCif extends javax.swing.JDialog
/*     */ {
/*     */   private IhmLienCif lien;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JCheckBox jCBCible;
/*     */   private JCheckBox jCBPointCassure;
/*     */   private JLabel jLabel2;
/*     */   private JTextField jTFNom;
/*     */   
/*     */   public FormeLienCif(java.awt.Frame parent, boolean modal, IhmLienCif lien, int x, int y)
/*     */   {
/*  27 */     super(parent, modal);
/*  28 */     initComponents();
/*  29 */     setLocation(500, 400);
/*  30 */     this.lien = lien;
/*  31 */     this.jCBPointCassure.setSelected(lien.isCassure());
/*  32 */     this.jTFNom.setText(lien.getNom());
/*  33 */     this.jCBCible.setSelected(lien.isCible());
/*  34 */     this.jButton2.setMnemonic(65);
/*  35 */     this.jButton1.setMnemonic(10);
/*     */   }
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
/*  47 */     this.jTFNom = new JTextField();
/*  48 */     this.jLabel2 = new JLabel();
/*  49 */     this.jCBPointCassure = new JCheckBox();
/*  50 */     this.jButton2 = new JButton();
/*  51 */     this.jButton1 = new JButton();
/*  52 */     this.jCBCible = new JCheckBox();
/*     */     
/*  54 */     setDefaultCloseOperation(2);
/*  55 */     setTitle("Proprieté lien CIF");
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
/*  67 */         FormeLienCif.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/*  70 */     });
/*  71 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/*  72 */     this.jButton1.setText("OK");
/*  73 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  75 */         FormeLienCif.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  78 */     });
/*  79 */     this.jCBCible.setText("    Cible");
/*  80 */     this.jCBCible.setHorizontalAlignment(11);
/*  81 */     this.jCBCible.setHorizontalTextPosition(4);
/*     */     
/*  83 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  84 */     getContentPane().setLayout(layout);
/*  85 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBCible).addComponent(this.jCBPointCassure).addGroup(layout.createSequentialGroup().addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.jTFNom, -1, 207, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -2, 88, -2))).addContainerGap()));
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
/*     */ 
/* 102 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFNom, -2, -1, -2).addComponent(this.jLabel2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, 32767).addComponent(this.jCBPointCassure).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBCible).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap()));
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
/*     */ 
/*     */ 
/* 120 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 124 */     dispose();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 128 */     if ((!this.lien.isCassure()) && (this.jCBPointCassure.isSelected())) {
/* 129 */       this.lien.initPointCassure();
/*     */     }
/* 131 */     this.lien.setNom(this.jTFNom.getText().trim());
/* 132 */     this.lien.setCassure(this.jCBPointCassure.isSelected());
/* 133 */     this.lien.setCible(this.jCBCible.isSelected());
/* 134 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeLienCif.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */