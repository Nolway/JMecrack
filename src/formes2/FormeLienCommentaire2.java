/*     */ package formes2;
/*     */ 
/*     */ import IhmMCD2.IhmLienCommentaire2;
/*     */ import IhmMCD2.IhmPoint;
/*     */ import ihm.Principale;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JSpinner;
/*     */ 
/*     */ public class FormeLienCommentaire2 extends javax.swing.JDialog
/*     */ {
/*     */   Principale frm;
/*     */   IhmLienCommentaire2 lien;
/*     */   private JButton jBtAnnuler;
/*     */   private JButton jBtHistorique;
/*     */   private JButton jBtValider;
/*     */   private javax.swing.JLabel jLabel9;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private JSpinner jSpNBCassure;
/*     */   
/*     */   public FormeLienCommentaire2(Principale parent, boolean modal, IhmLienCommentaire2 lien)
/*     */   {
/*  28 */     super(parent, modal);
/*  29 */     initComponents();
/*  30 */     this.frm = parent;
/*  31 */     this.lien = lien;
/*  32 */     setLocation(this.frm.getX() + 320, this.frm.getY() + 160);
/*  33 */     initData();
/*  34 */     this.jBtAnnuler.setMnemonic(65);
/*  35 */     this.jBtValider.setMnemonic(10);
/*     */   }
/*     */   
/*     */   private void initData() {
/*  39 */     this.jSpNBCassure.setValue(Integer.valueOf(this.lien.getPointCassure().size()));
/*     */   }
/*     */   
/*     */ 
/*     */   private void modifierPointDeCassure()
/*     */   {
/*  45 */     int nb = this.lien.getPointCassure().size();
/*  46 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/*  47 */     if (total > nb) {
/*  48 */       ajouterPointDeCassure();
/*  49 */       return;
/*     */     }
/*  51 */     if (total < nb) {
/*  52 */       supprimerPointDeCassure();
/*     */     }
/*     */   }
/*     */   
/*     */   private void ajouterPointDeCassure() {
/*  57 */     int nb = this.lien.getPointCassure().size();
/*  58 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/*     */     
/*  60 */     int x = 0;
/*  61 */     int y = 0;
/*  62 */     int dx = 10;int dy = 12;
/*     */     
/*     */ 
/*     */ 
/*  66 */     if (nb > 0) {
/*  67 */       x = ((IhmPoint)this.lien.getPointCassure().get(nb - 1)).getX();
/*  68 */       y = ((IhmPoint)this.lien.getPointCassure().get(nb - 1)).getY();
/*     */     }
/*     */     else {
/*  71 */       x = (this.lien.getEntiteRelation().getCentreX() + this.lien.getCommentaire().getCentreX()) / 2;
/*  72 */       y = (this.lien.getEntiteRelation().getCentreY() + this.lien.getCommentaire().getCentreY()) / 2;
/*     */     }
/*     */     
/*  75 */     for (int i = nb; i < total; i++) {
/*  76 */       IhmPoint p = new IhmPoint(x + dx, y + dy);
/*  77 */       x += dx;
/*  78 */       y += dy;
/*  79 */       this.lien.getPointCassure().add(p);
/*     */     }
/*     */   }
/*     */   
/*     */   private void supprimerPointDeCassure() {
/*  84 */     int nb = this.lien.getPointCassure().size();
/*  85 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/*  86 */     for (int i = nb; i > total; i--) {
/*  87 */       this.lien.getPointCassure().remove(i - 1);
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
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 102 */     this.jPanel1 = new javax.swing.JPanel();
/* 103 */     this.jLabel9 = new javax.swing.JLabel();
/* 104 */     this.jBtHistorique = new JButton();
/* 105 */     this.jSpNBCassure = new JSpinner();
/* 106 */     this.jBtAnnuler = new JButton();
/* 107 */     this.jBtValider = new JButton();
/*     */     
/* 109 */     setDefaultCloseOperation(2);
/* 110 */     setTitle("Propriétés lien commentaire");
/* 111 */     setResizable(false);
/*     */     
/* 113 */     this.jLabel9.setText("Points de cassure ");
/*     */     
/* 115 */     this.jBtHistorique.setText("Historique ...");
/* 116 */     this.jBtHistorique.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 118 */         FormeLienCommentaire2.this.jBtHistoriqueActionPerformed(evt);
/*     */       }
/*     */       
/* 121 */     });
/* 122 */     this.jSpNBCassure.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
/*     */     
/* 124 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 125 */     this.jPanel1.setLayout(jPanel1Layout);
/* 126 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jBtHistorique)).addGroup(jPanel1Layout.createSequentialGroup().addGap(191, 191, 191).addComponent(this.jLabel9).addGap(18, 18, 18).addComponent(this.jSpNBCassure, -1, 98, 32767))).addContainerGap()));
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
/* 140 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jSpNBCassure, -2, 27, -2).addComponent(this.jLabel9)).addGap(18, 18, 18).addComponent(this.jBtHistorique).addContainerGap(-1, 32767)));
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
/* 152 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 153 */     this.jBtAnnuler.setText("Annuler");
/* 154 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 156 */         FormeLienCommentaire2.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 159 */     });
/* 160 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 161 */     this.jBtValider.setText("Valider");
/* 162 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 164 */         FormeLienCommentaire2.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 167 */     });
/* 168 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 169 */     getContentPane().setLayout(layout);
/* 170 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jBtAnnuler, -2, 107, -2).addGap(18, 18, 18).addComponent(this.jBtValider, -2, 95, -2))).addContainerGap()));
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
/* 182 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap()));
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
/* 194 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(ActionEvent evt) {
/* 198 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(ActionEvent evt) {
/* 202 */     modifierPointDeCassure();
/* 203 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtHistoriqueActionPerformed(ActionEvent evt) {
/* 207 */     new FormeHistorique(this.frm, true, this.lien.getHistorique(), "", "").setVisible(true);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeLienCommentaire2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */