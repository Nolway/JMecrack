/*     */ package formes;
/*     */ 
/*     */ import IhmMCD.IhmLienContrainteHeritage;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class FormeLienHeritageContrainte extends JDialog
/*     */ {
/*     */   private IhmLienContrainteHeritage lien;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JCheckBox jCBPointCassure;
/*     */   private JLabel jLabel2;
/*     */   private JTextField jTFNom;
/*     */   
/*     */   public FormeLienHeritageContrainte(java.awt.Frame parent, boolean modal, IhmLienContrainteHeritage lien)
/*     */   {
/*  27 */     super(parent, modal);
/*  28 */     initComponents();
/*  29 */     setLocation(200, 300);
/*  30 */     this.lien = lien;
/*  31 */     this.jButton2.setMnemonic(65);
/*  32 */     this.jButton1.setMnemonic(10);
/*  33 */     if (lien != null) {
/*  34 */       this.jCBPointCassure.setSelected(lien.isCassure());
/*  35 */       this.jTFNom.setText(lien.getNom());
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
/*     */   private void initComponents()
/*     */   {
/*  48 */     this.jTFNom = new JTextField();
/*  49 */     this.jLabel2 = new JLabel();
/*  50 */     this.jCBPointCassure = new JCheckBox();
/*  51 */     this.jButton2 = new JButton();
/*  52 */     this.jButton1 = new JButton();
/*     */     
/*  54 */     setDefaultCloseOperation(2);
/*  55 */     setTitle("Lien Heritage");
/*  56 */     setResizable(false);
/*     */     
/*  58 */     this.jLabel2.setText("Nom du lien :");
/*     */     
/*  60 */     this.jCBPointCassure.setText("    Point de cassure");
/*  61 */     this.jCBPointCassure.setHorizontalAlignment(11);
/*  62 */     this.jCBPointCassure.setHorizontalTextPosition(4);
/*     */     
/*  64 */     this.jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/*  65 */     this.jButton2.setText("Annuler");
/*  66 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  68 */         FormeLienHeritageContrainte.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/*  71 */     });
/*  72 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/*  73 */     this.jButton1.setText("OK");
/*  74 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  76 */         FormeLienHeritageContrainte.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  79 */     });
/*  80 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  81 */     getContentPane().setLayout(layout);
/*  82 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBPointCassure).addGroup(layout.createSequentialGroup().addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.jTFNom, -1, 202, 32767)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -2, 88, -2))).addContainerGap()));
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
/*  98 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFNom, -2, -1, -2).addComponent(this.jLabel2)).addGap(18, 18, 18).addComponent(this.jCBPointCassure).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton2).addComponent(this.jButton1)).addContainerGap(20, 32767)));
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
/* 114 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 118 */     dispose();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 122 */     if ((!this.lien.isCassure()) && (this.jCBPointCassure.isSelected())) {
/* 123 */       this.lien.initPointCassure();
/*     */     }
/* 125 */     this.lien.setNom(this.jTFNom.getText().trim());
/* 126 */     this.lien.setCassure(this.jCBPointCassure.isSelected());
/* 127 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeLienHeritageContrainte.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */