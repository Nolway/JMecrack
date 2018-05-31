/*     */ package formes;
/*     */ 
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class FormeImporterDomaine extends javax.swing.JDialog
/*     */ {
/*     */   private ihm.Principale frm;
/*     */   private IhmMCD.IhmProjet projet;
/*     */   private java.util.ArrayList<Merise.Domaine> listeDomaine;
/*     */   private javax.swing.JButton jBtAjouter;
/*     */   private javax.swing.JButton jBtAnnuler;
/*     */   private javax.swing.JButton jBtSupprimer;
/*     */   private javax.swing.JButton jBtValider;
/*     */   private javax.swing.JButton jBtVisualiser;
/*     */   private javax.swing.JButton jBtVisualiser2;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JList jListDomaine;
/*     */   private javax.swing.JList jListDomaineNew;
/*     */   private javax.swing.JList jListMCD;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JPanel jPanel3;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JScrollPane jScrollPane2;
/*     */   private javax.swing.JScrollPane jScrollPane3;
/*     */   
/*     */   public FormeImporterDomaine(ihm.Principale frm, IhmMCD.IhmProjet projet, boolean modal)
/*     */   {
/*  32 */     super(frm, modal);
/*  33 */     initComponents();
/*  34 */     this.frm = frm;
/*  35 */     setLocation(frm.getX() + 250, frm.getY() + 100);
/*     */     
/*  37 */     this.projet = projet;
/*  38 */     this.listeDomaine = new java.util.ArrayList();
/*  39 */     copierListAttribut(projet.getFormeMCD().getPage().getListeDomaine());
/*  40 */     remplirListeMCD();
/*  41 */     this.jBtAnnuler.setMnemonic(65);
/*  42 */     this.jBtValider.setMnemonic(10);
/*  43 */     this.jBtSupprimer.setMnemonic(83);
/*  44 */     this.jBtSupprimer.setMnemonic(67);
/*  45 */     this.jBtVisualiser.setMnemonic(86);
/*  46 */     this.jBtVisualiser2.setMnemonic(73);
/*     */   }
/*     */   
/*     */   private void copierListAttribut(java.util.ArrayList<Merise.Domaine> lD) {
/*  50 */     for (int i = 0; i < this.projet.getFormeMCD().getPage().getListeDomaine().size(); i++)
/*  51 */       this.listeDomaine.add(((Merise.Domaine)this.projet.getFormeMCD().getPage().getListeDomaine().get(i)).copierDomaine());
/*     */   }
/*     */   
/*     */   private void remplirListeMCD() {
/*  55 */     java.util.ArrayList<IhmMCD.IhmProjet> listPro = new java.util.ArrayList();
/*  56 */     for (int i = 0; i < this.frm.getListeProjet().size(); i++) {
/*  57 */       if (this.frm.getListeProjet().get(i) != this.projet) listPro.add(this.frm.getListeProjet().get(i));
/*     */     }
/*  59 */     this.jListMCD.setListData(listPro.toArray());
/*  60 */     if (listPro.size() > 0) {
/*  61 */       this.jListMCD.setSelectedIndex(0);
/*  62 */       this.jListDomaine.setListData(((IhmMCD.IhmProjet)listPro.get(0)).getFormeMCD().getPage().getListeDomaine().toArray());
/*     */     }
/*  64 */     this.jListDomaineNew.setListData(this.listeDomaine.toArray());
/*     */   }
/*     */   
/*     */   private boolean existeAttribut(Merise.Domaine d) {
/*  68 */     for (int i = 0; i < this.listeDomaine.size(); i++) {
/*  69 */       if (d.getNom().equals(((Merise.Domaine)this.listeDomaine.get(i)).getNom()))
/*  70 */         return true;
/*     */     }
/*  72 */     return false;
/*     */   }
/*     */   
/*     */   private void ajouterAttribut(Merise.Domaine d) {
/*  76 */     if (!existeAttribut(d)) this.listeDomaine.add(d.copierDomaine());
/*     */   }
/*     */   
/*     */   private void supprimerAttribut() {
/*  80 */     int[] att = this.jListDomaineNew.getSelectedIndices();
/*  81 */     if (att.length > 0) this.projet.getFormeMCD().setModifier(true);
/*  82 */     for (int i = att.length - 1; i >= 0; i--) {
/*  83 */       this.listeDomaine.remove(att[i]);
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
/*  97 */     this.jPanel1 = new javax.swing.JPanel();
/*  98 */     this.jLabel1 = new javax.swing.JLabel();
/*  99 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 100 */     this.jListMCD = new javax.swing.JList();
/* 101 */     this.jLabel2 = new javax.swing.JLabel();
/* 102 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/* 103 */     this.jListDomaine = new javax.swing.JList();
/* 104 */     this.jBtVisualiser = new javax.swing.JButton();
/* 105 */     this.jPanel3 = new javax.swing.JPanel();
/* 106 */     this.jScrollPane3 = new javax.swing.JScrollPane();
/* 107 */     this.jListDomaineNew = new javax.swing.JList();
/* 108 */     this.jLabel3 = new javax.swing.JLabel();
/* 109 */     this.jBtSupprimer = new javax.swing.JButton();
/* 110 */     this.jBtVisualiser2 = new javax.swing.JButton();
/* 111 */     this.jPanel2 = new javax.swing.JPanel();
/* 112 */     this.jBtValider = new javax.swing.JButton();
/* 113 */     this.jBtAnnuler = new javax.swing.JButton();
/* 114 */     this.jBtAjouter = new javax.swing.JButton();
/*     */     
/* 116 */     setDefaultCloseOperation(2);
/* 117 */     setTitle("Importer les domaines");
/*     */     
/* 119 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 121 */     this.jLabel1.setText("Liste des MCD");
/*     */     
/* 123 */     this.jListMCD.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 125 */         FormeImporterDomaine.this.jListMCDMouseClicked(evt);
/*     */       }
/* 127 */     });
/* 128 */     this.jListMCD.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyReleased(java.awt.event.KeyEvent evt) {
/* 130 */         FormeImporterDomaine.this.jListMCDKeyReleased(evt);
/*     */       }
/* 132 */     });
/* 133 */     this.jScrollPane1.setViewportView(this.jListMCD);
/*     */     
/* 135 */     this.jLabel2.setText("Liste des domaines du MCD sélectionné ");
/*     */     
/* 137 */     this.jScrollPane2.setViewportView(this.jListDomaine);
/*     */     
/* 139 */     this.jBtVisualiser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/importer.png")));
/* 140 */     this.jBtVisualiser.setText("Visualiser ");
/* 141 */     this.jBtVisualiser.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 143 */         FormeImporterDomaine.this.jBtVisualiserActionPerformed(evt);
/*     */       }
/*     */       
/* 146 */     });
/* 147 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 148 */     this.jPanel1.setLayout(jPanel1Layout);
/* 149 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, -1, 253, 32767).addComponent(this.jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, -1, 253, 32767).addComponent(this.jLabel1, javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel2, javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jBtVisualiser, -2, 127, -2)).addContainerGap()));
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
/* 161 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 119, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane2, -2, 227, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtVisualiser).addContainerGap(-1, 32767)));
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
/* 177 */     this.jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 179 */     this.jListDomaineNew.setBackground(new java.awt.Color(236, 255, 249));
/* 180 */     this.jScrollPane3.setViewportView(this.jListDomaineNew);
/*     */     
/* 182 */     this.jLabel3.setText("Nouvelle liste des domaines  ");
/*     */     
/* 184 */     this.jBtSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/supprimer.png")));
/* 185 */     this.jBtSupprimer.setText("Supprimer ");
/* 186 */     this.jBtSupprimer.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 188 */         FormeImporterDomaine.this.jBtSupprimerActionPerformed(evt);
/*     */       }
/*     */       
/* 191 */     });
/* 192 */     this.jBtVisualiser2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/importer.png")));
/* 193 */     this.jBtVisualiser2.setText("Visualiser");
/* 194 */     this.jBtVisualiser2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 196 */         FormeImporterDomaine.this.jBtVisualiser2ActionPerformed(evt);
/*     */       }
/*     */       
/* 199 */     });
/* 200 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 201 */     this.jPanel3.setLayout(jPanel3Layout);
/* 202 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -1, 284, 32767).addComponent(this.jLabel3).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jBtVisualiser2, -2, 126, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, 32767).addComponent(this.jBtSupprimer, -2, 123, -2))).addContainerGap()));
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
/* 215 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -1, 377, 32767).addGap(11, 11, 11).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jBtSupprimer).addComponent(this.jBtVisualiser2)).addContainerGap()));
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
/* 229 */     this.jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 231 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 232 */     this.jBtValider.setText("Valider ");
/* 233 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 235 */         FormeImporterDomaine.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 238 */     });
/* 239 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 240 */     this.jBtAnnuler.setText("Annuler ");
/* 241 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 243 */         FormeImporterDomaine.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 246 */     });
/* 247 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 248 */     this.jPanel2.setLayout(jPanel2Layout);
/* 249 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(403, 32767).addComponent(this.jBtAnnuler, -2, 120, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtValider, -2, 104, -2).addGap(19, 19, 19)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 258 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 268 */     this.jBtAjouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flecheAdroite.PNG")));
/* 269 */     this.jBtAjouter.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 271 */         FormeImporterDomaine.this.jBtAjouterActionPerformed(evt);
/*     */       }
/*     */       
/* 274 */     });
/* 275 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 276 */     getContentPane().setLayout(layout);
/* 277 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtAjouter, -2, 57, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel3, -1, -1, 32767)).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
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
/* 291 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jBtAjouter).addGap(180, 180, 180)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))).addComponent(this.jPanel2, -2, -1, -2).addContainerGap()));
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
/* 308 */     pack();
/*     */   }
/*     */   
/*     */   private void jListMCDMouseClicked(java.awt.event.MouseEvent evt) {
/* 312 */     IhmMCD.IhmProjet p = (IhmMCD.IhmProjet)this.jListMCD.getSelectedValue();
/* 313 */     if (p != null) this.jListDomaine.setListData(p.getFormeMCD().getPage().getListeDomaine().toArray());
/*     */   }
/*     */   
/*     */   private void jListMCDKeyReleased(java.awt.event.KeyEvent evt) {
/* 317 */     IhmMCD.IhmProjet p = (IhmMCD.IhmProjet)this.jListMCD.getSelectedValue();
/* 318 */     if (p != null) this.jListDomaine.setListData(p.getFormeMCD().getPage().getListeDomaine().toArray());
/*     */   }
/*     */   
/*     */   private void jBtSupprimerActionPerformed(java.awt.event.ActionEvent evt) {
/* 322 */     supprimerAttribut();
/* 323 */     this.jListDomaineNew.setListData(this.listeDomaine.toArray());
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(java.awt.event.ActionEvent evt) {
/* 327 */     this.projet.getFormeMCD().getPage().setListeDomaine(this.listeDomaine);
/* 328 */     this.projet.getFormeMCD().setModifier(true);
/* 329 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt) {
/* 333 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtAjouterActionPerformed(java.awt.event.ActionEvent evt) {
/* 337 */     int[] ind = this.jListDomaine.getSelectedIndices();
/* 338 */     for (int i = 0; i < ind.length; i++) {
/* 339 */       ajouterAttribut((Merise.Domaine)this.jListDomaine.getSelectedValues()[i]);
/*     */     }
/* 341 */     this.jListDomaineNew.setListData(this.listeDomaine.toArray());
/*     */   }
/*     */   
/*     */   private void jBtVisualiserActionPerformed(java.awt.event.ActionEvent evt) {
/* 345 */     IhmMCD.IhmProjet p = (IhmMCD.IhmProjet)this.jListMCD.getSelectedValue();
/* 346 */     int ind = this.jListDomaine.getSelectedIndex();
/* 347 */     if (this.jListDomaine.getSelectedIndex() >= 0) {
/* 348 */       new FormeDomaine(this.frm, true, (Merise.Domaine)this.jListDomaine.getSelectedValue()).setVisible(true);
/* 349 */       if (p != null) this.jListDomaine.setListData(p.getFormeMCD().getPage().getListeDomaine().toArray());
/* 350 */       this.jListDomaine.setSelectedIndex(ind);
/* 351 */     } else { javax.swing.JOptionPane.showMessageDialog(this, "INFO : Aucun domaine n'est sélectionné !! ");
/*     */     }
/*     */   }
/*     */   
/* 355 */   private void jBtVisualiser2ActionPerformed(java.awt.event.ActionEvent evt) { int ind = this.jListDomaine.getSelectedIndex();
/* 356 */     if (this.jListDomaineNew.getSelectedIndex() >= 0) {
/* 357 */       new FormeDomaine(this.frm, true, (Merise.Domaine)this.jListDomaineNew.getSelectedValue()).setVisible(true);
/* 358 */       this.jListDomaineNew.setListData(this.listeDomaine.toArray());
/* 359 */       this.jListDomaineNew.setSelectedIndex(ind);
/* 360 */     } else { javax.swing.JOptionPane.showMessageDialog(this, "INFO : Aucun domaine n'est sélectionné !! ");
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeImporterDomaine.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */