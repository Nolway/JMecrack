/*     */ package formes;
/*     */ 
/*     */ import Merise.Domaine;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ 
/*     */ public class FormeDomaine extends javax.swing.JDialog
/*     */ {
/*     */   private ihm.Principale frm;
/*     */   private Domaine domaineSel1;
/*     */   private Domaine domaineSel;
/*     */   private JButton jBtAnnuler;
/*     */   private JButton jBtCreer;
/*     */   private JButton jBtDescendre;
/*     */   private JButton jBtModifier;
/*     */   private JButton jBtMonter;
/*     */   private JButton jBtSupprimer;
/*     */   private JButton jBtValider;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JList jListValeur;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JTextField jTFDomaine;
/*     */   private javax.swing.JTextField jTFValeur;
/*     */   
/*     */   public FormeDomaine(ihm.Principale frm, boolean modal, Domaine domaine)
/*     */   {
/*  31 */     super(frm, modal);
/*  32 */     initComponents();
/*  33 */     this.frm = frm;
/*  34 */     setLocation(frm.getX() + 250, frm.getY() + 150);
/*  35 */     this.domaineSel = domaine;
/*     */     
/*  37 */     this.jBtValider.setMnemonic(10);
/*  38 */     this.jBtAnnuler.setMnemonic(65);
/*  39 */     this.jBtCreer.setMnemonic(67);
/*  40 */     this.jBtDescendre.setMnemonic(68);
/*  41 */     this.jBtModifier.setMnemonic(77);
/*  42 */     this.jBtMonter.setMnemonic(85);
/*  43 */     this.jBtSupprimer.setMnemonic(83);
/*     */     
/*  45 */     if (domaine == null) {
/*  46 */       this.domaineSel1 = new Domaine("nouveau_domain");
/*  47 */       this.domaineSel = null;
/*  48 */       this.jTFDomaine.setText(this.domaineSel1.getNom());
/*     */     } else {
/*  50 */       this.domaineSel1 = domaine.copierDomaine();
/*  51 */       this.jTFDomaine.setText(this.domaineSel1.getNom());
/*  52 */       this.jListValeur.setListData(this.domaineSel1.getListeValeurs().toArray());
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean existeValeurListe(String val) {
/*  57 */     for (int i = 0; i < this.domaineSel1.getListeValeurs().size(); i++) {
/*  58 */       if (((String)this.domaineSel1.getListeValeurs().get(i)).toString().toUpperCase().equals(val.toUpperCase())) {
/*  59 */         return true;
/*     */       }
/*     */     }
/*  62 */     return false;
/*     */   }
/*     */   
/*     */   private boolean existeDomaine(Domaine d, String str) {
/*  66 */     for (int i = 0; i < this.frm.getPage().getListeDomaine().size(); i++) {
/*  67 */       if ((d != this.frm.getPage().getListeDomaine().get(i)) && 
/*  68 */         (str.trim().toUpperCase().equals(((Domaine)this.frm.getPage().getListeDomaine().get(i)).getNom().toUpperCase()))) {
/*  69 */         return true;
/*     */       }
/*     */     }
/*     */     
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isDomaineKey(String str) {
/*  77 */     for (int i = 0; i < Outil.Parametres.DomaineDefini.length; i++) {
/*  78 */       if (str.trim().toUpperCase().equals(Outil.Parametres.DomaineDefini[i].toUpperCase())) {
/*  79 */         return true;
/*     */       }
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   private void remplacerDomaine(Domaine d1, Domaine d2) {
/*  86 */     for (int i = 0; i < this.frm.getPage().getListeDomaine().size(); i++) {
/*  87 */       if (d1 == this.frm.getPage().getListeDomaine().get(i)) {
/*  88 */         this.frm.getPage().getListeDomaine().set(i, d2);
/*  89 */         return;
/*     */       }
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
/* 104 */     this.jPanel1 = new javax.swing.JPanel();
/* 105 */     this.jLabel1 = new javax.swing.JLabel();
/* 106 */     this.jTFDomaine = new javax.swing.JTextField();
/* 107 */     this.jPanel2 = new javax.swing.JPanel();
/* 108 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 109 */     this.jListValeur = new javax.swing.JList();
/* 110 */     this.jLabel2 = new javax.swing.JLabel();
/* 111 */     this.jLabel3 = new javax.swing.JLabel();
/* 112 */     this.jTFValeur = new javax.swing.JTextField();
/* 113 */     this.jBtMonter = new JButton();
/* 114 */     this.jBtDescendre = new JButton();
/* 115 */     this.jBtSupprimer = new JButton();
/* 116 */     this.jBtModifier = new JButton();
/* 117 */     this.jBtCreer = new JButton();
/* 118 */     this.jBtValider = new JButton();
/* 119 */     this.jBtAnnuler = new JButton();
/*     */     
/* 121 */     setDefaultCloseOperation(2);
/* 122 */     setTitle("Définition du domaines");
/* 123 */     setResizable(false);
/*     */     
/* 125 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 127 */     this.jLabel1.setText("Nom domaine : ");
/*     */     
/* 129 */     javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this.jPanel1);
/* 130 */     this.jPanel1.setLayout(jPanel1Layout);
/* 131 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTFDomaine, -1, 430, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 140 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFDomaine, -2, -1, -2)).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 150 */     this.jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 152 */     this.jListValeur.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseReleased(java.awt.event.MouseEvent evt) {
/* 154 */         FormeDomaine.this.jListValeurMouseReleased(evt);
/*     */       }
/* 156 */     });
/* 157 */     this.jListValeur.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyReleased(java.awt.event.KeyEvent evt) {
/* 159 */         FormeDomaine.this.jListValeurKeyReleased(evt);
/*     */       }
/* 161 */     });
/* 162 */     this.jScrollPane1.setViewportView(this.jListValeur);
/*     */     
/* 164 */     this.jLabel2.setText("Liste de valeurs");
/*     */     
/* 166 */     this.jLabel3.setText("Valeur : ");
/*     */     
/* 168 */     this.jBtMonter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/monter.png")));
/* 169 */     this.jBtMonter.setToolTipText("Faire monter");
/* 170 */     this.jBtMonter.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 172 */         FormeDomaine.this.jBtMonterActionPerformed(evt);
/*     */       }
/*     */       
/* 175 */     });
/* 176 */     this.jBtDescendre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/descendre.png")));
/* 177 */     this.jBtDescendre.setToolTipText("Faire descendre");
/* 178 */     this.jBtDescendre.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 180 */         FormeDomaine.this.jBtDescendreActionPerformed(evt);
/*     */       }
/*     */       
/* 183 */     });
/* 184 */     this.jBtSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/supprimer.png")));
/* 185 */     this.jBtSupprimer.setToolTipText("Supprimer");
/* 186 */     this.jBtSupprimer.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 188 */         FormeDomaine.this.jBtSupprimerActionPerformed(evt);
/*     */       }
/*     */       
/* 191 */     });
/* 192 */     this.jBtModifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/modifier.png")));
/* 193 */     this.jBtModifier.setToolTipText("Modifier");
/* 194 */     this.jBtModifier.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 196 */         FormeDomaine.this.jBtModifierActionPerformed(evt);
/*     */       }
/*     */       
/* 199 */     });
/* 200 */     this.jBtCreer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ajouter.png")));
/* 201 */     this.jBtCreer.setToolTipText("Créer");
/* 202 */     this.jBtCreer.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 204 */         FormeDomaine.this.jBtCreerActionPerformed(evt);
/*     */       }
/*     */       
/* 207 */     });
/* 208 */     javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this.jPanel2);
/* 209 */     this.jPanel2.setLayout(jPanel2Layout);
/* 210 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTFValeur).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtModifier).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtCreer)).addComponent(this.jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, -2, 453, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jBtSupprimer, -1, -1, 32767).addComponent(this.jBtDescendre, -1, -1, 32767).addComponent(this.jBtMonter, -1, -1, 32767)))).addContainerGap()));
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
/* 234 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 175, -2)).addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addGap(49, 49, 49).addComponent(this.jBtMonter).addGap(18, 18, 18).addComponent(this.jBtDescendre).addGap(18, 18, 18).addComponent(this.jBtSupprimer))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTFValeur, -2, -1, -2)).addComponent(this.jBtCreer).addComponent(this.jBtModifier)).addContainerGap(17, 32767)));
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
/* 260 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 261 */     this.jBtValider.setText("Valider");
/* 262 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 264 */         FormeDomaine.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 267 */     });
/* 268 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 269 */     this.jBtAnnuler.setText("Annuler");
/* 270 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 272 */         FormeDomaine.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 275 */     });
/* 276 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/* 277 */     getContentPane().setLayout(layout);
/* 278 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jBtAnnuler, -2, 97, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtValider))).addContainerGap()));
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
/* 291 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap(-1, 32767)));
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
/* 305 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtCreerActionPerformed(java.awt.event.ActionEvent evt) {
/* 309 */     if (this.jTFValeur.getText().trim().length() > 0) {
/* 310 */       if (!existeValeurListe(this.jTFValeur.getText())) {
/* 311 */         this.domaineSel1.getListeValeurs().add(this.jTFValeur.getText());
/* 312 */         this.jListValeur.setListData(this.domaineSel1.getListeValeurs().toArray());
/* 313 */         this.jTFValeur.setText("");
/*     */       } else {
/* 315 */         javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : La valeur existe déja dans la liste !! ");
/*     */       }
/*     */     } else {
/* 318 */       javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : La valeur ne doit pas être vide !! ");
/*     */     }
/*     */   }
/*     */   
/*     */   private void jListValeurMouseReleased(java.awt.event.MouseEvent evt) {
/* 323 */     if (this.jListValeur.getSelectedIndex() >= 0)
/* 324 */       this.jTFValeur.setText(((String)this.domaineSel1.getListeValeurs().get(this.jListValeur.getSelectedIndex())).toString());
/*     */   }
/*     */   
/*     */   private void jListValeurKeyReleased(java.awt.event.KeyEvent evt) {
/* 328 */     if (this.jListValeur.getSelectedIndex() >= 0)
/* 329 */       this.jTFValeur.setText(((String)this.domaineSel1.getListeValeurs().get(this.jListValeur.getSelectedIndex())).toString());
/*     */   }
/*     */   
/*     */   private void jBtModifierActionPerformed(java.awt.event.ActionEvent evt) {
/* 333 */     if (this.jListValeur.getSelectedIndex() >= 0) {
/* 334 */       if (this.jTFValeur.getText().trim().length() > 0) {
/* 335 */         if (!existeValeurListe(this.jTFValeur.getText())) {
/* 336 */           this.domaineSel1.getListeValeurs().set(this.jListValeur.getSelectedIndex(), this.jTFValeur.getText());
/* 337 */           this.jListValeur.setListData(this.domaineSel1.getListeValeurs().toArray());
/* 338 */           this.jTFValeur.setText("");
/*     */         } else {
/* 340 */           javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : La valeur existe déja dans la liste !! ");
/*     */         }
/*     */       } else {
/* 343 */         javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : La valeur ne doit pas être vide !! ");
/*     */       }
/*     */     } else {
/* 346 */       javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : aucune valeur n'est sélectionnée pour la modification !! ");
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBtMonterActionPerformed(java.awt.event.ActionEvent evt) {
/* 351 */     int index1 = this.jListValeur.getSelectedIndex();
/* 352 */     if (index1 > 0) {
/* 353 */       String s = (String)this.domaineSel1.getListeValeurs().get(this.jListValeur.getSelectedIndex() - 1);
/* 354 */       this.domaineSel1.getListeValeurs().set(index1 - 1, ((String)this.domaineSel1.getListeValeurs().get(index1)).toString());
/* 355 */       this.domaineSel1.getListeValeurs().set(index1, s);
/* 356 */       this.jListValeur.setListData(this.domaineSel1.getListeValeurs().toArray());
/* 357 */       this.jListValeur.setSelectedIndex(index1 - 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBtDescendreActionPerformed(java.awt.event.ActionEvent evt) {
/* 362 */     int index1 = this.jListValeur.getSelectedIndex();
/* 363 */     if (index1 < this.domaineSel1.getListeValeurs().size() - 1) {
/* 364 */       String s = (String)this.domaineSel1.getListeValeurs().get(this.jListValeur.getSelectedIndex() + 1);
/* 365 */       this.domaineSel1.getListeValeurs().set(index1 + 1, ((String)this.domaineSel1.getListeValeurs().get(index1)).toString());
/* 366 */       this.domaineSel1.getListeValeurs().set(index1, s);
/* 367 */       this.jListValeur.setListData(this.domaineSel1.getListeValeurs().toArray());
/* 368 */       this.jListValeur.setSelectedIndex(index1 + 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBtSupprimerActionPerformed(java.awt.event.ActionEvent evt) {
/* 373 */     int[] att = this.jListValeur.getSelectedIndices();
/* 374 */     for (int i = att.length - 1; i >= 0; i--) {
/* 375 */       this.domaineSel1.getListeValeurs().remove(att[i]);
/*     */     }
/* 377 */     this.jListValeur.setListData(this.domaineSel1.getListeValeurs().toArray());
/* 378 */     this.jTFValeur.setText("");
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt) {
/* 382 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(java.awt.event.ActionEvent evt) {
/* 386 */     if (this.jTFDomaine.getText().trim().length() > 0) {
/* 387 */       if (this.domaineSel1.getListeValeurs().size() != 0) {
/* 388 */         if (this.domaineSel == null) {
/* 389 */           if (!existeDomaine(this.domaineSel, this.jTFDomaine.getText())) {
/* 390 */             if (!isDomaineKey(this.jTFDomaine.getText())) {
/* 391 */               this.domaineSel1.setNom(this.jTFDomaine.getText().trim());
/* 392 */               this.frm.getPage().getListeDomaine().add(this.domaineSel1);
/* 393 */               this.frm.getProjetSel().getFormeMCD().setModifier(true);
/* 394 */               dispose();
/* 395 */             } else { javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : le nom du domaine est un mot réservé !! ");
/* 396 */             } } else javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : le nom du domaine existe déja dans la liste des domaines !! ");
/*     */         }
/* 398 */         else if (!existeDomaine(this.domaineSel, this.jTFDomaine.getText())) {
/* 399 */           if (!isDomaineKey(this.jTFDomaine.getText())) {
/* 400 */             this.domaineSel1.setNom(this.jTFDomaine.getText().trim());
/* 401 */             remplacerDomaine(this.domaineSel, this.domaineSel1);
/* 402 */             this.frm.getProjetSel().getFormeMCD().setModifier(true);
/* 403 */             dispose();
/* 404 */           } else { javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : le nom du domaine est un mot réservé !! ");
/*     */           }
/* 406 */         } else javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : le nm du domaine existe déja dans la liste des domaines !! ");
/*     */       } else
/* 408 */         javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : aucune valeur n'est définie pour ce domaine !! ");
/*     */     } else {
/* 410 */       javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Le nom du domaine ne doit pas être vide !! ");
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeDomaine.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */