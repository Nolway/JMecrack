/*     */ package formes;
/*     */ 
/*     */ import IhmMCD.IhmHeritage;
/*     */ import java.awt.event.ActionEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JRadioButton;
/*     */ 
/*     */ public class FormeContrainteHeritage extends javax.swing.JDialog
/*     */ {
/*     */   private IhmHeritage heritage;
/*     */   private ihm.Principale frm;
/*     */   private javax.swing.ButtonGroup buttonGroup1;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private JRadioButton jRBEgal;
/*     */   private JRadioButton jRBT;
/*     */   private JRadioButton jRBX;
/*     */   private JRadioButton jRBXT;
/*     */   
/*     */   public FormeContrainteHeritage(ihm.Principale frm, boolean modal, IhmHeritage heritage)
/*     */   {
/*  27 */     super(frm, modal);
/*  28 */     initComponents();
/*  29 */     this.frm = frm;
/*  30 */     setLocation(300, 200);
/*  31 */     this.heritage = heritage;
/*  32 */     initierChoix();
/*  33 */     this.jButton1.setMnemonic(10);
/*  34 */     this.jButton2.setMnemonic(65);
/*     */   }
/*     */   
/*     */   private void initierChoix() {
/*  38 */     if (unSeulLienHeritage()) {
/*  39 */       this.jRBEgal.setSelected(true);
/*  40 */       this.jRBXT.setEnabled(false);
/*  41 */       this.jRBX.setEnabled(false);
/*  42 */       this.jRBT.setEnabled(false);
/*  43 */       this.heritage.setNom("");
/*     */     } else {
/*  45 */       if (this.heritage.getNom().trim().equals("")) this.jRBEgal.setSelected(true);
/*  46 */       if (this.heritage.getNom().trim().equals("XT")) this.jRBXT.setSelected(true);
/*  47 */       if (this.heritage.getNom().trim().equals("X")) this.jRBX.setSelected(true);
/*  48 */       if (this.heritage.getNom().trim().equals("T")) this.jRBT.setSelected(true);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean unSeulLienHeritage() {
/*  53 */     int n = this.frm.getProjetSel().getFormeMCD().getPage().getListeLienContrainteHeritage().size();
/*  54 */     int cpt = 0;
/*  55 */     for (int i = 0; i < n; i++) {
/*  56 */       if (((IhmMCD.IhmLienContrainteHeritage)this.frm.getProjetSel().getFormeMCD().getPage().getListeLienContrainteHeritage().get(i)).getHeritage().equals(this.heritage)) {
/*  57 */         cpt++;
/*     */       }
/*  59 */       if (cpt > 2) return false;
/*     */     }
/*  61 */     return true;
/*     */   }
/*     */   
/*     */   private void setChoix() {
/*  65 */     if (this.jRBEgal.isSelected()) this.heritage.setNom("");
/*  66 */     if (this.jRBXT.isSelected()) this.heritage.setNom("XT");
/*  67 */     if (this.jRBT.isSelected()) this.heritage.setNom("T");
/*  68 */     if (this.jRBX.isSelected()) { this.heritage.setNom("X");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  79 */     this.buttonGroup1 = new javax.swing.ButtonGroup();
/*  80 */     this.jPanel1 = new javax.swing.JPanel();
/*  81 */     this.jRBX = new JRadioButton();
/*  82 */     this.jRBXT = new JRadioButton();
/*  83 */     this.jRBT = new JRadioButton();
/*  84 */     this.jRBEgal = new JRadioButton();
/*  85 */     this.jButton2 = new JButton();
/*  86 */     this.jButton1 = new JButton();
/*     */     
/*  88 */     setDefaultCloseOperation(2);
/*  89 */     setTitle("Contrainte sur l'héritage");
/*  90 */     setResizable(false);
/*     */     
/*  92 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/*  94 */     this.buttonGroup1.add(this.jRBX);
/*  95 */     this.jRBX.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  96 */     this.jRBX.setText("X");
/*     */     
/*  98 */     this.buttonGroup1.add(this.jRBXT);
/*  99 */     this.jRBXT.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 100 */     this.jRBXT.setText("XT");
/*     */     
/* 102 */     this.buttonGroup1.add(this.jRBT);
/* 103 */     this.jRBT.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 104 */     this.jRBT.setText("T");
/*     */     
/* 106 */     this.buttonGroup1.add(this.jRBEgal);
/* 107 */     this.jRBEgal.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 108 */     this.jRBEgal.setText("rien");
/*     */     
/* 110 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 111 */     this.jPanel1.setLayout(jPanel1Layout);
/* 112 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jRBX).addGap(18, 18, 18).addComponent(this.jRBXT).addGap(18, 18, 18).addComponent(this.jRBT).addGap(18, 18, 18).addComponent(this.jRBEgal).addContainerGap(47, 32767)));
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
/* 125 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRBX).addComponent(this.jRBXT).addComponent(this.jRBT).addComponent(this.jRBEgal)).addContainerGap(16, 32767)));
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
/* 137 */     this.jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 138 */     this.jButton2.setText("Annuler");
/* 139 */     this.jButton2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 141 */         FormeContrainteHeritage.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/* 144 */     });
/* 145 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 146 */     this.jButton1.setText("OK");
/* 147 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 149 */         FormeContrainteHeritage.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/* 152 */     });
/* 153 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 154 */     getContentPane().setLayout(layout);
/* 155 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -2, 66, -2))).addContainerGap()));
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
/* 167 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap(-1, 32767)));
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
/* 179 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 183 */     if (unSeulLienHeritage()) {
/* 184 */       this.heritage.setNom("");
/*     */     }
/* 186 */     dispose();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 190 */     setChoix();
/* 191 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeContrainteHeritage.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */