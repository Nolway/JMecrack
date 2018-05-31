/*     */ package formes;
/*     */ 
/*     */ import IhmMCD.IhmLien;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComboBox;
/*     */ 
/*     */ public class FormeCardinalite extends javax.swing.JDialog
/*     */ {
/*     */   private IhmLien lien;
/*     */   private String cardi;
/*     */   private ihm.Principale frm;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JComboBox jCBCardinalite;
/*     */   private JCheckBox jCBLienRelatif;
/*     */   private JCheckBox jCBPointCassure;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JTextField jTFNom;
/*     */   
/*     */   public FormeCardinalite(ihm.Principale frm, boolean modal, IhmLien lien, int x, int y)
/*     */   {
/*  28 */     super(frm, modal);
/*  29 */     initComponents();
/*  30 */     this.frm = frm;
/*  31 */     setLocation(500, 300);
/*  32 */     this.lien = lien;
/*  33 */     if (lien.getCardinalite().indexOf(")") >= 0) {
/*  34 */       this.jCBLienRelatif.setSelected(true);
/*  35 */       this.cardi = lien.getCardinalite();
/*     */     }
/*     */     
/*  38 */     activerCardinalite();
/*  39 */     this.jCBPointCassure.setSelected(lien.isCassure());
/*  40 */     this.jTFNom.setText(lien.getNom());
/*  41 */     this.jButton1.setMnemonic(10);
/*  42 */     this.jButton2.setMnemonic(65);
/*     */   }
/*     */   
/*     */   private void activerCardinalite() {
/*  46 */     String c = this.lien.getCardinalite();
/*  47 */     c = c.replace("(", "");
/*  48 */     c = c.replace(")", "");
/*  49 */     if (c.equals("0,1")) {
/*  50 */       this.jCBCardinalite.setSelectedIndex(0);
/*  51 */       this.jCBLienRelatif.setEnabled(false);
/*     */     }
/*  53 */     if (c.equals("1,1")) {
/*  54 */       this.jCBCardinalite.setSelectedIndex(1);
/*  55 */       this.jCBLienRelatif.setEnabled(true);
/*     */     }
/*  57 */     if (c.equals("0,n")) {
/*  58 */       this.jCBCardinalite.setSelectedIndex(2);
/*  59 */       this.jCBLienRelatif.setEnabled(false);
/*     */     }
/*  61 */     if (c.equals("1,n")) {
/*  62 */       this.jCBCardinalite.setSelectedIndex(3);
/*  63 */       this.jCBLienRelatif.setEnabled(false);
/*     */     }
/*     */   }
/*     */   
/*     */   private String getCardinalite() {
/*  68 */     String c = "";
/*  69 */     if (this.jCBCardinalite.getSelectedIndex() >= 0) c = this.jCBCardinalite.getSelectedItem().toString();
/*  70 */     if ((this.jCBLienRelatif.isEnabled()) && 
/*  71 */       (this.jCBLienRelatif.isSelected())) { c = "(" + c + ")";
/*     */     }
/*  73 */     return c;
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
/*  84 */     this.jLabel1 = new javax.swing.JLabel();
/*  85 */     this.jCBCardinalite = new JComboBox();
/*  86 */     this.jButton1 = new JButton();
/*  87 */     this.jButton2 = new JButton();
/*  88 */     this.jCBPointCassure = new JCheckBox();
/*  89 */     this.jTFNom = new javax.swing.JTextField();
/*  90 */     this.jLabel2 = new javax.swing.JLabel();
/*  91 */     this.jCBLienRelatif = new JCheckBox();
/*     */     
/*  93 */     setDefaultCloseOperation(2);
/*  94 */     setTitle("Cardinalite");
/*  95 */     setResizable(false);
/*     */     
/*  97 */     this.jLabel1.setText("Cardinalité de la relation : ");
/*     */     
/*  99 */     this.jCBCardinalite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0,1", "1,1", "0,n", "1,n" }));
/* 100 */     this.jCBCardinalite.addItemListener(new java.awt.event.ItemListener() {
/*     */       public void itemStateChanged(java.awt.event.ItemEvent evt) {
/* 102 */         FormeCardinalite.this.jCBCardinaliteItemStateChanged(evt);
/*     */       }
/* 104 */     });
/* 105 */     this.jCBCardinalite.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 107 */         FormeCardinalite.this.jCBCardinaliteActionPerformed(evt);
/*     */       }
/*     */       
/* 110 */     });
/* 111 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 112 */     this.jButton1.setText("OK");
/* 113 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 115 */         FormeCardinalite.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/* 118 */     });
/* 119 */     this.jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 120 */     this.jButton2.setText("Annuler");
/* 121 */     this.jButton2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 123 */         FormeCardinalite.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/* 126 */     });
/* 127 */     this.jCBPointCassure.setText("Point de cassure .....");
/* 128 */     this.jCBPointCassure.setHorizontalAlignment(11);
/* 129 */     this.jCBPointCassure.setHorizontalTextPosition(2);
/*     */     
/* 131 */     this.jLabel2.setText("Nom du lien :");
/*     */     
/* 133 */     this.jCBLienRelatif.setText("Lien relatif ");
/* 134 */     this.jCBLienRelatif.setHorizontalAlignment(11);
/* 135 */     this.jCBLienRelatif.setHorizontalTextPosition(2);
/*     */     
/* 137 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 138 */     getContentPane().setLayout(layout);
/* 139 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.jTFNom, -1, 174, 32767)).addGroup(layout.createSequentialGroup().addGap(87, 87, 87).addComponent(this.jButton2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -1, 82, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jCBPointCassure).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, 32767).addComponent(this.jCBLienRelatif)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1, -2, 145, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCBCardinalite, 0, 105, 32767))))).addContainerGap()));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 166 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFNom, -2, -1, -2).addComponent(this.jLabel2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jCBCardinalite, -2, -1, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBLienRelatif).addComponent(this.jCBPointCassure)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap()));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 188 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 195 */     this.lien.setCardinalite(getCardinalite());
/* 196 */     if ((!this.lien.isCassure()) && (this.jCBPointCassure.isSelected())) {
/* 197 */       this.lien.initPointCassure();
/*     */     }
/* 199 */     this.lien.setNom(this.jTFNom.getText().trim());
/* 200 */     this.lien.setCassure(this.jCBPointCassure.isSelected());
/* 201 */     this.frm.getFormeMCD().setModifier(true);
/* 202 */     dispose();
/*     */   }
/*     */   
/*     */ 
/*     */   private void jCBCardinaliteActionPerformed(java.awt.event.ActionEvent evt) {}
/*     */   
/*     */   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 210 */     dispose();
/*     */   }
/*     */   
/*     */   private void jCBCardinaliteItemStateChanged(java.awt.event.ItemEvent evt) {
/* 214 */     if (!this.jCBCardinalite.getSelectedItem().toString().equals("1,1")) {
/* 215 */       this.jCBLienRelatif.setEnabled(false);
/*     */     } else {
/* 217 */       this.jCBLienRelatif.setEnabled(true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeCardinalite.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */