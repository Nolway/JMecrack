/*     */ package formes2;
/*     */ 
/*     */ import IhmMLD2.MLDLienEntite2;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class FormeMLDLien2 extends javax.swing.JDialog
/*     */ {
/*     */   ihm.Principale frm;
/*     */   MLDLienEntite2 lien;
/*     */   IhmMLD.IhmPageMLD page;
/*     */   private javax.swing.JButton jBtAnnuler;
/*     */   private javax.swing.JButton jBtOK;
/*     */   private javax.swing.JCheckBox jCBAppliquer;
/*     */   private javax.swing.JComboBox jCBEpaisseur;
/*     */   private JLabel jLabClTexte;
/*     */   private JLabel jLabClTrait;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel7;
/*     */   private JLabel jLabel9;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JPanel jPanel3;
/*     */   private javax.swing.JSpinner jSpNBCassure;
/*     */   private javax.swing.JTextField jTFCode;
/*     */   private javax.swing.JTextField jTFNom;
/*     */   
/*     */   public FormeMLDLien2(ihm.Principale parent, IhmMLD.IhmPageMLD page, MLDLienEntite2 lien, boolean modal)
/*     */   {
/*  34 */     super(parent, modal);
/*  35 */     initComponents();
/*  36 */     this.frm = parent;
/*  37 */     this.page = page;
/*  38 */     this.lien = lien;
/*     */     
/*  40 */     this.jBtOK.setMnemonic(10);
/*  41 */     this.jBtAnnuler.setMnemonic(65);
/*  42 */     setLocation(this.frm.getX() + 290, this.frm.getY() + 120);
/*  43 */     initData();
/*     */   }
/*     */   
/*     */   private void initData()
/*     */   {
/*  48 */     this.jTFNom.setText(this.lien.getNom());
/*  49 */     this.jTFCode.setText(this.lien.getCode());
/*  50 */     this.jLabClTrait.setBackground(this.lien.getClLien());
/*  51 */     this.jLabClTexte.setBackground(this.lien.getClLienText());
/*  52 */     if (this.lien.getEpaisseur() == FormeProprieteMCD2.EPAISSEUR_FIN) {
/*  53 */       this.jCBEpaisseur.setSelectedIndex(0);
/*     */     }
/*  55 */     if (this.lien.getEpaisseur() == FormeProprieteMCD2.EPAISSEUR_MOYEN) {
/*  56 */       this.jCBEpaisseur.setSelectedIndex(1);
/*     */     }
/*  58 */     if (this.lien.getEpaisseur() == FormeProprieteMCD2.EPAISSEUR_GRAS) {
/*  59 */       this.jCBEpaisseur.setSelectedIndex(2);
/*     */     }
/*  61 */     this.jSpNBCassure.setValue(Integer.valueOf(this.lien.getPointCassure().size()));
/*     */     
/*  63 */     if (this.lien.getSource() == this.lien.getCible()) {
/*  64 */       ((javax.swing.SpinnerNumberModel)this.jSpNBCassure.getModel()).setMinimum(Integer.valueOf(2));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private java.awt.Color choixDeCouleur(java.awt.Color color, String titre)
/*     */   {
/*  71 */     java.awt.Color col = javax.swing.JColorChooser.showDialog(this, titre, color);
/*  72 */     if (col == null) return color;
/*  73 */     return col;
/*     */   }
/*     */   
/*     */   private void supprimerPointDeCassure() {
/*  77 */     int nb = this.lien.getPointCassure().size();
/*  78 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/*  79 */     for (int i = nb; i > total; i--) {
/*  80 */       this.lien.getPointCassure().remove(i - 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private void ajouterPointDeCassure() {
/*  85 */     int nb = this.lien.getPointCassure().size();
/*  86 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/*     */     
/*  88 */     int x = this.lien.getxCard();
/*  89 */     int y = this.lien.getyCard();
/*  90 */     int dx = 0;int dy = 0;
/*     */     
/*  92 */     if ((this.lien.getNom().trim().length() == 0) && (!this.lien.isFleche())) {
/*  93 */       this.lien.calculerXYCardianlite();
/*     */     }
/*     */     
/*  96 */     if (this.lien.getCote() == 1) {
/*  97 */       dx = -20;
/*  98 */       dy = 0;
/*  99 */       x = this.lien.getxCard() - 50;
/* 100 */       y = this.lien.getyCard();
/*     */     }
/* 102 */     if (this.lien.getCote() == 3) {
/* 103 */       dx = 20;
/* 104 */       dy = 0;
/* 105 */       x = this.lien.getxCard() + 50;
/* 106 */       y = this.lien.getyCard();
/*     */     }
/* 108 */     if (this.lien.getCote() == 2) {
/* 109 */       dx = 0;
/* 110 */       dy = -20;
/* 111 */       x = this.lien.getxCard();
/* 112 */       y = this.lien.getyCard() - 50;
/*     */     }
/* 114 */     if (this.lien.getCote() == 4) {
/* 115 */       dx = 0;
/* 116 */       dy = 20;
/* 117 */       x = this.lien.getxCard();
/* 118 */       y = this.lien.getyCard() + 50;
/*     */     }
/*     */     
/*     */ 
/* 122 */     if (nb > 0) {
/* 123 */       x = ((IhmMCD2.IhmPoint)this.lien.getPointCassure().get(nb - 1)).getX();
/* 124 */       y = ((IhmMCD2.IhmPoint)this.lien.getPointCassure().get(nb - 1)).getY();
/*     */     }
/*     */     
/* 127 */     for (int i = nb; i < total; i++) {
/* 128 */       IhmMCD2.IhmPoint p = new IhmMCD2.IhmPoint(x + dx, y + dy);
/* 129 */       x += dx;
/* 130 */       y += dy;
/* 131 */       this.lien.getPointCassure().add(p);
/*     */     }
/*     */   }
/*     */   
/*     */   private void modifierPointDeCassure() {
/* 136 */     int nb = this.lien.getPointCassure().size();
/* 137 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/* 138 */     if (total > nb) {
/* 139 */       ajouterPointDeCassure();
/* 140 */       return;
/*     */     }
/* 142 */     if (total < nb) {
/* 143 */       supprimerPointDeCassure();
/*     */     }
/*     */   }
/*     */   
/*     */   private float getEpaisseur() {
/* 148 */     if (this.jCBEpaisseur.getSelectedIndex() == 0) {
/* 149 */       return FormeProprieteMCD2.EPAISSEUR_FIN;
/*     */     }
/* 151 */     if (this.jCBEpaisseur.getSelectedIndex() == 1) {
/* 152 */       return FormeProprieteMCD2.EPAISSEUR_MOYEN;
/*     */     }
/* 154 */     if (this.jCBEpaisseur.getSelectedIndex() == 2) {
/* 155 */       return FormeProprieteMCD2.EPAISSEUR_GRAS;
/*     */     }
/* 157 */     return FormeProprieteMCD2.EPAISSEUR_FIN;
/*     */   }
/*     */   
/*     */   private void appliquerAtoutLesLien() {
/* 161 */     java.awt.Color trai = this.jLabClTrait.getBackground();
/* 162 */     java.awt.Color text = this.jLabClTexte.getBackground();
/* 163 */     float epaisseur = getEpaisseur();
/*     */     
/* 165 */     for (int i = 0; i < this.page.getListeLien().size(); i++) {
/* 166 */       ((MLDLienEntite2)this.page.getListeLien().get(i)).setClLien(trai);
/* 167 */       ((MLDLienEntite2)this.page.getListeLien().get(i)).setClLienText(text);
/* 168 */       ((MLDLienEntite2)this.page.getListeLien().get(i)).setEpaisseur(epaisseur);
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
/* 182 */     this.jLabel1 = new JLabel();
/* 183 */     this.jTFNom = new javax.swing.JTextField();
/* 184 */     this.jLabel2 = new JLabel();
/* 185 */     this.jTFCode = new javax.swing.JTextField();
/* 186 */     this.jPanel1 = new javax.swing.JPanel();
/* 187 */     this.jPanel2 = new javax.swing.JPanel();
/* 188 */     this.jLabClTrait = new JLabel();
/* 189 */     this.jLabel4 = new JLabel();
/* 190 */     this.jLabel5 = new JLabel();
/* 191 */     this.jLabClTexte = new JLabel();
/* 192 */     this.jLabel9 = new JLabel();
/* 193 */     this.jPanel3 = new javax.swing.JPanel();
/* 194 */     this.jLabel7 = new JLabel();
/* 195 */     this.jCBEpaisseur = new javax.swing.JComboBox();
/* 196 */     this.jCBAppliquer = new javax.swing.JCheckBox();
/* 197 */     this.jSpNBCassure = new javax.swing.JSpinner();
/* 198 */     this.jBtOK = new javax.swing.JButton();
/* 199 */     this.jBtAnnuler = new javax.swing.JButton();
/*     */     
/* 201 */     setDefaultCloseOperation(2);
/* 202 */     setTitle("Propriété Lien MLD");
/* 203 */     setResizable(false);
/*     */     
/* 205 */     this.jLabel1.setText("Nom");
/*     */     
/* 207 */     this.jLabel2.setText("Code");
/*     */     
/* 209 */     this.jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Couleurs"));
/*     */     
/* 211 */     this.jLabClTrait.setBackground(new java.awt.Color(255, 255, 255));
/* 212 */     this.jLabClTrait.setFont(new java.awt.Font("Tahoma", 1, 18));
/* 213 */     this.jLabClTrait.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 214 */     this.jLabClTrait.setOpaque(true);
/* 215 */     this.jLabClTrait.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 217 */         FormeMLDLien2.this.jLabClTraitMouseClicked(evt);
/*     */       }
/*     */       
/* 220 */     });
/* 221 */     this.jLabel4.setHorizontalAlignment(0);
/* 222 */     this.jLabel4.setText("Trait");
/*     */     
/* 224 */     this.jLabel5.setHorizontalAlignment(0);
/* 225 */     this.jLabel5.setText("Texte");
/*     */     
/* 227 */     this.jLabClTexte.setBackground(new java.awt.Color(255, 255, 255));
/* 228 */     this.jLabClTexte.setFont(new java.awt.Font("Tahoma", 1, 18));
/* 229 */     this.jLabClTexte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 230 */     this.jLabClTexte.setOpaque(true);
/* 231 */     this.jLabClTexte.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 233 */         FormeMLDLien2.this.jLabClTexteMouseClicked(evt);
/*     */       }
/*     */       
/* 236 */     });
/* 237 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 238 */     this.jPanel2.setLayout(jPanel2Layout);
/* 239 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jLabel4, -1, 56, 32767).addComponent(this.jLabClTrait, -1, 56, 32767)).addGap(85, 85, 85).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jLabel5, -1, 56, 32767).addComponent(this.jLabClTexte, -1, 56, 32767)).addGap(21, 21, 21)));
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
/* 252 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabClTrait, -1, -1, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel5).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabClTexte, -2, 20, -2))).addContainerGap(-1, 32767)));
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
/* 268 */     this.jLabel9.setText("Points de cassure ");
/*     */     
/* 270 */     this.jLabel7.setText("Epaisseur");
/*     */     
/* 272 */     this.jCBEpaisseur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Fin", "Moyen", "Gras" }));
/*     */     
/* 274 */     this.jCBAppliquer.setText("Appliquer les couleurs et l'épaisseur à tous les liens ");
/*     */     
/* 276 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 277 */     this.jPanel3.setLayout(jPanel3Layout);
/* 278 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jCBAppliquer).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addComponent(this.jLabel7).addGap(18, 18, 18).addComponent(this.jCBEpaisseur, -2, 148, -2))).addContainerGap(-1, 32767)));
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
/* 290 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(19, 19, 19).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jCBEpaisseur, -2, -1, -2).addComponent(this.jLabel7)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, 32767).addComponent(this.jCBAppliquer).addGap(22, 22, 22)));
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
/* 302 */     this.jSpNBCassure.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
/*     */     
/* 304 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 305 */     this.jPanel1.setLayout(jPanel1Layout);
/* 306 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -2, -1, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel9).addGap(18, 18, 18).addComponent(this.jSpNBCassure, -2, 87, -2))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, 32767).addComponent(this.jPanel3, -2, -1, -2).addContainerGap()));
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
/* 320 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, -1, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.jSpNBCassure, -2, 27, -2)))).addContainerGap()));
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
/* 335 */     this.jBtOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 336 */     this.jBtOK.setText("Valider");
/* 337 */     this.jBtOK.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 339 */         FormeMLDLien2.this.jBtOKActionPerformed(evt);
/*     */       }
/*     */       
/* 342 */     });
/* 343 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 344 */     this.jBtAnnuler.setText("Annuler");
/* 345 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 347 */         FormeMLDLien2.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 350 */     });
/* 351 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 352 */     getContentPane().setLayout(layout);
/* 353 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTFNom, -2, 242, -2).addGap(34, 34, 34).addComponent(this.jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTFCode, -1, 277, 32767)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jBtAnnuler, -2, 112, -2).addGap(18, 18, 18).addComponent(this.jBtOK, -2, 120, -2))).addContainerGap()));
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
/* 373 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFNom, -2, 28, -2).addComponent(this.jLabel2).addComponent(this.jTFCode, -2, 27, -2)).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jBtOK).addComponent(this.jBtAnnuler)).addContainerGap(-1, 32767)));
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
/* 391 */     pack();
/*     */   }
/*     */   
/*     */   private void jLabClTraitMouseClicked(java.awt.event.MouseEvent evt) {
/* 395 */     this.jLabClTrait.setBackground(choixDeCouleur(this.jLabClTrait.getBackground(), "Couleur trait"));
/*     */   }
/*     */   
/*     */   private void jLabClTexteMouseClicked(java.awt.event.MouseEvent evt) {
/* 399 */     this.jLabClTexte.setBackground(choixDeCouleur(this.jLabClTexte.getBackground(), "Couleur du nom "));
/*     */   }
/*     */   
/*     */   private void jBtOKActionPerformed(java.awt.event.ActionEvent evt) {
/* 403 */     this.lien.setNom(this.jTFNom.getText().trim());
/* 404 */     this.lien.setCode(this.jTFCode.getText().trim().toUpperCase());
/* 405 */     this.lien.setEpaisseur(getEpaisseur());
/* 406 */     this.lien.setClLien(this.jLabClTrait.getBackground());
/* 407 */     this.lien.setClLienText(this.jLabClTexte.getBackground());
/* 408 */     if (this.jCBAppliquer.isSelected()) {
/* 409 */       appliquerAtoutLesLien();
/*     */     }
/* 411 */     modifierPointDeCassure();
/* 412 */     this.page.repaint();
/* 413 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt) {
/* 417 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeMLDLien2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */