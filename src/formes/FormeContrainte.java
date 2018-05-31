/*     */ package formes;
/*     */ 
/*     */ import IhmMCD.IhmContrainte;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JRadioButton;
/*     */ 
/*     */ public class FormeContrainte extends javax.swing.JDialog
/*     */ {
/*     */   private IhmMCD.IhmEntiteRelation contrainte;
/*     */   private javax.swing.ButtonGroup buttonGroup1;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private JRadioButton jRBEgal;
/*     */   private JRadioButton jRBI;
/*     */   private JRadioButton jRBPlus;
/*     */   private JRadioButton jRBT;
/*     */   private JRadioButton jRBX;
/*     */   
/*     */   public FormeContrainte(java.awt.Frame parent, boolean modal, IhmMCD.IhmEntiteRelation contrainte, int x, int y)
/*     */   {
/*  27 */     super(parent, modal);
/*  28 */     initComponents();
/*  29 */     setLocation(500, 400);
/*  30 */     this.contrainte = contrainte;
/*  31 */     this.jButton1.setMnemonic(10);
/*  32 */     this.jButton2.setMnemonic(65);
/*  33 */     initierChoix();
/*     */   }
/*     */   
/*     */   private void initierChoix() {
/*  37 */     if (((IhmContrainte)this.contrainte).getNom().trim().equals("+")) this.jRBPlus.setSelected(true);
/*  38 */     if (((IhmContrainte)this.contrainte).getNom().trim().equals("=")) this.jRBEgal.setSelected(true);
/*  39 */     if (((IhmContrainte)this.contrainte).getNom().trim().equals("I")) this.jRBI.setSelected(true);
/*  40 */     if (((IhmContrainte)this.contrainte).getNom().trim().equals("X")) this.jRBX.setSelected(true);
/*  41 */     if (((IhmContrainte)this.contrainte).getNom().trim().equals("T")) this.jRBT.setSelected(true);
/*     */   }
/*     */   
/*     */   private void setChoix() {
/*  45 */     if (this.jRBPlus.isSelected()) ((IhmContrainte)this.contrainte).setNom("+");
/*  46 */     if (this.jRBEgal.isSelected()) ((IhmContrainte)this.contrainte).setNom("=");
/*  47 */     if (this.jRBI.isSelected()) ((IhmContrainte)this.contrainte).setNom("I");
/*  48 */     if (this.jRBT.isSelected()) ((IhmContrainte)this.contrainte).setNom("T");
/*  49 */     if (this.jRBX.isSelected()) { ((IhmContrainte)this.contrainte).setNom("X");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  61 */     this.buttonGroup1 = new javax.swing.ButtonGroup();
/*  62 */     this.jPanel1 = new javax.swing.JPanel();
/*  63 */     this.jRBX = new JRadioButton();
/*  64 */     this.jRBI = new JRadioButton();
/*  65 */     this.jRBT = new JRadioButton();
/*  66 */     this.jRBEgal = new JRadioButton();
/*  67 */     this.jRBPlus = new JRadioButton();
/*  68 */     this.jButton1 = new JButton();
/*  69 */     this.jButton2 = new JButton();
/*     */     
/*  71 */     setDefaultCloseOperation(2);
/*  72 */     setTitle("Choix de contrainte");
/*  73 */     setResizable(false);
/*     */     
/*  75 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/*  77 */     this.buttonGroup1.add(this.jRBX);
/*  78 */     this.jRBX.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  79 */     this.jRBX.setText("X");
/*     */     
/*  81 */     this.buttonGroup1.add(this.jRBI);
/*  82 */     this.jRBI.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  83 */     this.jRBI.setText("I");
/*     */     
/*  85 */     this.buttonGroup1.add(this.jRBT);
/*  86 */     this.jRBT.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  87 */     this.jRBT.setText("T");
/*     */     
/*  89 */     this.buttonGroup1.add(this.jRBEgal);
/*  90 */     this.jRBEgal.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  91 */     this.jRBEgal.setText("=");
/*     */     
/*  93 */     this.buttonGroup1.add(this.jRBPlus);
/*  94 */     this.jRBPlus.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  95 */     this.jRBPlus.setText("+");
/*     */     
/*  97 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  98 */     this.jPanel1.setLayout(jPanel1Layout);
/*  99 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jRBX).addGap(26, 26, 26).addComponent(this.jRBI).addGap(33, 33, 33).addComponent(this.jRBT).addGap(26, 26, 26).addComponent(this.jRBEgal).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, 32767).addComponent(this.jRBPlus).addContainerGap()));
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
/* 114 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRBX).addComponent(this.jRBPlus).addComponent(this.jRBI).addComponent(this.jRBT).addComponent(this.jRBEgal)).addContainerGap(16, 32767)));
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
/* 127 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 128 */     this.jButton1.setText("OK");
/* 129 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 131 */         FormeContrainte.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/* 134 */     });
/* 135 */     this.jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 136 */     this.jButton2.setText("Annuler");
/* 137 */     this.jButton2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 139 */         FormeContrainte.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/* 142 */     });
/* 143 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 144 */     getContentPane().setLayout(layout);
/* 145 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton2, -2, 97, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -2, 86, -2))).addContainerGap()));
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
/* 157 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addGap(11, 11, 11)));
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
/* 169 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 173 */     dispose();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 177 */     setChoix();
/* 178 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeContrainte.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */