/*     */ package LibraryPan;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JRadioButton;
/*     */ 
/*     */ public class FormeProprieteLibrairie extends javax.swing.JDialog
/*     */ {
/*     */   ihm.Principale frm;
/*     */   Library libSel;
/*     */   java.util.ArrayList<IhmMCD.IhmEntiteRelation> listeEntite;
/*     */   private javax.swing.ButtonGroup buttonGroup1;
/*     */   private javax.swing.ButtonGroup buttonGroup2;
/*     */   private javax.swing.JButton jBtAnnuler;
/*     */   private javax.swing.JButton jBtValider;
/*     */   private javax.swing.JButton jButton1;
/*     */   private javax.swing.JCheckBox jCBAfficherOptions;
/*     */   private javax.swing.JComboBox jComboBox1;
/*     */   private JLabel jLabUtilisation;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel10;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   
/*     */   public FormeProprieteLibrairie(ihm.Principale parent, boolean modal, Library lib)
/*     */   {
/*  35 */     super(parent, modal);
/*  36 */     initComponents();
/*  37 */     this.frm = parent;
/*  38 */     setLocation(this.frm.getX() + this.frm.getWidth() - getWidth() - 250, 50);
/*  39 */     this.libSel = lib;
/*  40 */     this.listeEntite = copierListe(lib.getListModels());
/*  41 */     initData();
/*     */   }
/*     */   
/*     */   private java.util.ArrayList<IhmMCD.IhmEntiteRelation> copierListe(java.util.ArrayList<IhmMCD.IhmEntiteRelation> liste) {
/*  45 */     java.util.ArrayList<IhmMCD.IhmEntiteRelation> l = new java.util.ArrayList();
/*  46 */     for (int i = 0; i < liste.size(); i++) {
/*  47 */       if ((liste.get(i) instanceof IhmMCD2.IhmEntite2)) {
/*  48 */         IhmMCD2.IhmEntite2 ent = (IhmMCD2.IhmEntite2)((IhmMCD2.IhmEntite2)liste.get(i)).copier();
/*  49 */         ent.setSelected(false);
/*  50 */         l.add(ent);
/*     */       }
/*  52 */       if ((liste.get(i) instanceof IhmMCD2.IhmRelation2)) {
/*  53 */         IhmMCD2.IhmRelation2 ent = (IhmMCD2.IhmRelation2)((IhmMCD2.IhmRelation2)liste.get(i)).copier();
/*  54 */         ent.setSelected(false);
/*  55 */         l.add(ent);
/*     */       }
/*     */     }
/*  58 */     return l;
/*     */   }
/*     */   
/*     */   private void corrigerAttribut(java.util.ArrayList<IhmMCD.IhmEntiteRelation> liste) {
/*  62 */     for (int i = 0; i < liste.size(); i++) {
/*  63 */       if ((liste.get(i) instanceof IhmMCD2.IhmEntite2)) {
/*  64 */         this.frm.getPage().cacherAttribut((IhmMCD2.IhmEntite2)liste.get(i));
/*     */       }
/*  66 */       if ((liste.get(i) instanceof IhmMCD2.IhmRelation2))
/*  67 */         this.frm.getPage().cacherAttribut((IhmMCD2.IhmRelation2)liste.get(i));
/*     */     }
/*     */   }
/*     */   private JLabel jLabel8;
/*     */   private JLabel jLabel9;
/*     */   private javax.swing.JList jListEntiteRelation;
/*     */   
/*     */   private int getNombreUse(IhmMCD2.IhmEntite2 ent) {
/*  75 */     if (ent == null) return 0;
/*  76 */     return ent.getNbUsedLibrairie();
/*     */   }
/*     */   
/*     */   private int getNombreUse(IhmMCD2.IhmRelation2 ent) {
/*  80 */     if (ent == null) return 0;
/*  81 */     return ent.getNbUsedLibrairie();
/*     */   }
/*     */   
/*     */   private int getNombreUse(IhmMCD.IhmEntiteRelation ent) {
/*  85 */     if (ent == null) return 0;
/*  86 */     if ((ent instanceof IhmMCD2.IhmEntite2)) { return getNombreUse((IhmMCD2.IhmEntite2)ent);
/*     */     }
/*  88 */     if ((ent instanceof IhmMCD2.IhmRelation2)) { return getNombreUse((IhmMCD2.IhmRelation2)ent);
/*     */     }
/*  90 */     return 0;
/*     */   }
/*     */   
/*     */   private void initData() {
/*  94 */     this.jTFNom.setText(this.libSel.getName());
/*  95 */     this.jTFPath.setText(this.libSel.getRepertoire());
/*  96 */     this.jTACommentaire.setText(this.libSel.getCommentaire());
/*  97 */     this.jLabUtilisation.setText("Utilisation : 0");
/*  98 */     this.jListEntiteRelation.setListData(this.listeEntite.toArray());
/*  99 */     this.jCBAfficherOptions.setSelected(Outil.Setting.afficherOptionSelectionLib);
/*     */     
/* 101 */     initCouleur();
/*     */   }
/*     */   
/*     */   private void initCouleur() {
/* 105 */     Color cl = this.libSel.getCouleur();
/* 106 */     if (cl.getRGB() == this.jRBBleu.getBackground().getRGB()) {
/* 107 */       this.jRBBleu.setSelected(true);
/*     */     }
/* 109 */     if (cl.getRGB() == this.jRBGris.getBackground().getRGB()) {
/* 110 */       this.jRBGris.setSelected(true);
/*     */     }
/* 112 */     if (cl.getRGB() == this.jRBRouge.getBackground().getRGB()) {
/* 113 */       this.jRBRouge.setSelected(true);
/*     */     }
/* 115 */     if (cl.getRGB() == this.jRBVert.getBackground().getRGB()) {
/* 116 */       this.jRBVert.setSelected(true);
/*     */     }
/*     */   }
/*     */   
/*     */   private void setCouleur() {
/* 121 */     if (this.jRBBleu.isSelected()) {
/* 122 */       this.libSel.setCouleur(this.jRBBleu.getBackground());
/*     */     }
/* 124 */     if (this.jRBGris.isSelected()) {
/* 125 */       this.libSel.setCouleur(this.jRBGris.getBackground());
/*     */     }
/* 127 */     if (this.jRBRouge.isSelected()) {
/* 128 */       this.libSel.setCouleur(this.jRBRouge.getBackground());
/*     */     }
/* 130 */     if (this.jRBVert.isSelected()) {
/* 131 */       this.libSel.setCouleur(this.jRBVert.getBackground());
/*     */     }
/* 133 */     this.frm.getPanLibibrary().setCouleurSel(this.libSel.getCouleur());
/*     */   }
/*     */   
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel3;
/*     */   
/* 139 */   private void sauvegardeTout() { this.libSel.setName(this.jTFNom.getText());
/* 140 */     this.libSel.setCommentaire(this.jTACommentaire.getText());
/* 141 */     corrigerAttribut(this.listeEntite);
/* 142 */     this.libSel.setModels(this.listeEntite);
/* 143 */     Outil.Setting.afficherOptionSelectionLib = this.jCBAfficherOptions.isSelected();
/* 144 */     setCouleur();
/*     */   }
/*     */   
/*     */   private boolean renommerLibrairie() {
/* 148 */     String nom = this.jTFNom.getText().trim();
/* 149 */     if (nom.length() == 0) {
/* 150 */       javax.swing.JOptionPane.showMessageDialog(this, "Le nom de la librairie ne doit pas être vide", "Vérification", 0);
/* 151 */       return false;
/*     */     }
/* 153 */     if (nom.toUpperCase().equals(this.libSel.getName().trim().toUpperCase())) { return true;
/*     */     }
/* 155 */     if (this.libSel.existeLibFile(nom)) {
/* 156 */       javax.swing.JOptionPane.showMessageDialog(this, "Le nom de la librairie existe déjà !!", "Vérification", 0);
/* 157 */       return false;
/*     */     }
/* 159 */     String chemin = this.libSel.getRepertoire() + this.libSel.prefixLib(nom);
/* 160 */     if (this.frm.getPanLibibrary().renameLibrairy(this.libSel, chemin, nom)) {
/* 161 */       return true;
/*     */     }
/* 163 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private javax.swing.JPanel jPanel4;
/*     */   private javax.swing.JPanel jPanel5;
/*     */   private javax.swing.JPanel jPanel6;
/*     */   private javax.swing.JPanel jPanel7;
/*     */   private JRadioButton jRBBleu;
/*     */   
/*     */   private void initComponents()
/*     */   {
/* 175 */     this.buttonGroup1 = new javax.swing.ButtonGroup();
/* 176 */     this.buttonGroup2 = new javax.swing.ButtonGroup();
/* 177 */     this.jPanel1 = new javax.swing.JPanel();
/* 178 */     this.jLabel1 = new JLabel();
/* 179 */     this.jTFNom = new javax.swing.JTextField();
/* 180 */     this.jLabel5 = new JLabel();
/* 181 */     this.jTFPath = new javax.swing.JTextField();
/* 182 */     this.jBtValider = new javax.swing.JButton();
/* 183 */     this.jBtAnnuler = new javax.swing.JButton();
/* 184 */     this.jPanel3 = new javax.swing.JPanel();
/* 185 */     this.jTabbedPane1 = new javax.swing.JTabbedPane();
/* 186 */     this.jPanel4 = new javax.swing.JPanel();
/* 187 */     this.jLabel2 = new JLabel();
/* 188 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/* 189 */     this.jListEntiteRelation = new javax.swing.JList();
/* 190 */     this.jLabel4 = new JLabel();
/* 191 */     this.jComboBox1 = new javax.swing.JComboBox();
/* 192 */     this.jLabUtilisation = new JLabel();
/* 193 */     this.jPanel6 = new javax.swing.JPanel();
/* 194 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 195 */     this.jTACommentaire = new javax.swing.JTextArea();
/* 196 */     this.jButton1 = new javax.swing.JButton();
/* 197 */     this.jLabel10 = new JLabel();
/* 198 */     this.jPanel7 = new javax.swing.JPanel();
/* 199 */     this.jPanel5 = new javax.swing.JPanel();
/* 200 */     this.jLabel3 = new JLabel();
/* 201 */     this.jRBVert = new JRadioButton();
/* 202 */     this.jRBRouge = new JRadioButton();
/* 203 */     this.jRBBleu = new JRadioButton();
/* 204 */     this.jRBGris = new JRadioButton();
/* 205 */     this.jLabel6 = new JLabel();
/* 206 */     this.jLabel7 = new JLabel();
/* 207 */     this.jLabel8 = new JLabel();
/* 208 */     this.jLabel9 = new JLabel();
/* 209 */     this.jCBAfficherOptions = new javax.swing.JCheckBox();
/*     */     
/* 211 */     setDefaultCloseOperation(2);
/* 212 */     setTitle("Propriétés de la librairie ");
/* 213 */     setResizable(false);
/*     */     
/* 215 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */     
/* 217 */     this.jLabel1.setText("Librairie ");
/*     */     
/* 219 */     this.jTFNom.setFont(new java.awt.Font("Tahoma", 1, 12));
/*     */     
/* 221 */     this.jLabel5.setText("Chemin");
/*     */     
/* 223 */     this.jTFPath.setEditable(false);
/*     */     
/* 225 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 226 */     this.jPanel1.setLayout(jPanel1Layout);
/* 227 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel5)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTFPath, -1, 427, 32767).addComponent(this.jTFNom, -1, 427, 32767)).addContainerGap()));
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
/* 240 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFNom, -2, 26, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jTFPath, -2, -1, -2)).addContainerGap(-1, 32767)));
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
/* 254 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 255 */     this.jBtValider.setText("Valider ");
/* 256 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 258 */         FormeProprieteLibrairie.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 261 */     });
/* 262 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 263 */     this.jBtAnnuler.setText("Annuler");
/* 264 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 266 */         FormeProprieteLibrairie.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 269 */     });
/* 270 */     this.jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(204, 204, 204)));
/*     */     
/* 272 */     this.jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 273 */     this.jLabel2.setText("Liste des entités et des relations ");
/*     */     
/* 275 */     this.jListEntiteRelation.setBackground(new Color(255, 255, 242));
/* 276 */     this.jListEntiteRelation.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mousePressed(java.awt.event.MouseEvent evt) {
/* 278 */         FormeProprieteLibrairie.this.jListEntiteRelationMousePressed(evt);
/*     */       }
/* 280 */     });
/* 281 */     this.jListEntiteRelation.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyReleased(java.awt.event.KeyEvent evt) {
/* 283 */         FormeProprieteLibrairie.this.jListEntiteRelationKeyReleased(evt);
/*     */       }
/* 285 */     });
/* 286 */     this.jScrollPane2.setViewportView(this.jListEntiteRelation);
/*     */     
/* 288 */     this.jLabel4.setText("Trier");
/*     */     
/* 290 */     this.jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Nom", "Type", "Nombre d'utilisation" }));
/* 291 */     this.jComboBox1.setEnabled(false);
/*     */     
/* 293 */     this.jLabUtilisation.setFont(new java.awt.Font("Tahoma", 1, 12));
/* 294 */     this.jLabUtilisation.setText("Utilisation : ");
/*     */     
/* 296 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 297 */     this.jPanel4.setLayout(jPanel4Layout);
/* 298 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING, -1, 460, 32767).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel2).addGap(75, 75, 75).addComponent(this.jLabel4).addGap(18, 18, 18).addComponent(this.jComboBox1, 0, 158, 32767)).addComponent(this.jLabUtilisation, GroupLayout.Alignment.LEADING)).addContainerGap()));
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
/* 313 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jComboBox1, -2, -1, -2).addComponent(this.jLabel4).addComponent(this.jLabel2)).addGap(18, 18, 18).addComponent(this.jScrollPane2, -1, 292, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabUtilisation).addContainerGap()));
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
/* 328 */     this.jTabbedPane1.addTab("Entité/Relation ", this.jPanel4);
/*     */     
/* 330 */     this.jTACommentaire.setColumns(20);
/* 331 */     this.jTACommentaire.setRows(5);
/* 332 */     this.jScrollPane1.setViewportView(this.jTACommentaire);
/*     */     
/* 334 */     this.jButton1.setText("Historique ...");
/* 335 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 337 */         FormeProprieteLibrairie.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/* 340 */     });
/* 341 */     this.jLabel10.setText("Commentaire ");
/*     */     
/* 343 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/* 344 */     this.jPanel6.setLayout(jPanel6Layout);
/* 345 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 460, 32767).addComponent(this.jLabel10).addComponent(this.jButton1, -2, 137, -2)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 355 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel10).addGap(9, 9, 9).addComponent(this.jScrollPane1, -1, 299, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1).addContainerGap()));
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
/* 367 */     this.jTabbedPane1.addTab("Commentaire/ historique", this.jPanel6);
/*     */     
/* 369 */     this.jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 370 */     this.jLabel3.setText("Couleur de la séléction d'une entitée ou d'une relation ");
/*     */     
/* 372 */     this.jRBVert.setBackground(new Color(0, 150, 0));
/* 373 */     this.buttonGroup1.add(this.jRBVert);
/*     */     
/* 375 */     this.jRBRouge.setBackground(new Color(255, 0, 0));
/* 376 */     this.buttonGroup1.add(this.jRBRouge);
/* 377 */     this.jRBRouge.setSelected(true);
/*     */     
/* 379 */     this.jRBBleu.setBackground(new Color(0, 0, 50));
/* 380 */     this.buttonGroup1.add(this.jRBBleu);
/*     */     
/* 382 */     this.jRBGris.setBackground(new Color(100, 100, 100));
/* 383 */     this.buttonGroup1.add(this.jRBGris);
/*     */     
/* 385 */     this.jLabel6.setBackground(new Color(255, 0, 0));
/* 386 */     this.jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 387 */     this.jLabel6.setForeground(new Color(255, 255, 255));
/* 388 */     this.jLabel6.setHorizontalAlignment(0);
/* 389 */     this.jLabel6.setText("RE");
/* 390 */     this.jLabel6.setOpaque(true);
/* 391 */     this.jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 393 */         FormeProprieteLibrairie.this.jLabel6MouseClicked(evt);
/*     */       }
/*     */       
/* 396 */     });
/* 397 */     this.jLabel7.setBackground(new Color(0, 150, 0));
/* 398 */     this.jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 399 */     this.jLabel7.setForeground(new Color(255, 255, 255));
/* 400 */     this.jLabel7.setHorizontalAlignment(0);
/* 401 */     this.jLabel7.setText("GR");
/* 402 */     this.jLabel7.setOpaque(true);
/* 403 */     this.jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 405 */         FormeProprieteLibrairie.this.jLabel7MouseClicked(evt);
/*     */       }
/*     */       
/* 408 */     });
/* 409 */     this.jLabel8.setBackground(new Color(0, 0, 50));
/* 410 */     this.jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 411 */     this.jLabel8.setForeground(new Color(255, 255, 255));
/* 412 */     this.jLabel8.setHorizontalAlignment(0);
/* 413 */     this.jLabel8.setText("BL");
/* 414 */     this.jLabel8.setOpaque(true);
/* 415 */     this.jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 417 */         FormeProprieteLibrairie.this.jLabel8MouseClicked(evt);
/*     */       }
/*     */       
/* 420 */     });
/* 421 */     this.jLabel9.setBackground(new Color(100, 100, 100));
/* 422 */     this.jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 423 */     this.jLabel9.setForeground(new Color(255, 255, 255));
/* 424 */     this.jLabel9.setHorizontalAlignment(0);
/* 425 */     this.jLabel9.setText("GR");
/* 426 */     this.jLabel9.setOpaque(true);
/* 427 */     this.jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 429 */         FormeProprieteLibrairie.this.jLabel9MouseClicked(evt);
/*     */       }
/*     */       
/* 432 */     });
/* 433 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 434 */     this.jPanel5.setLayout(jPanel5Layout);
/* 435 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3)).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jRBVert).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel7, -2, 35, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, 32767).addComponent(this.jRBRouge).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel6, -2, 35, -2).addGap(58, 58, 58).addComponent(this.jRBBleu).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel8, -2, 35, -2).addGap(72, 72, 72).addComponent(this.jRBGris).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel9, -2, 35, -2))).addContainerGap()));
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
/* 461 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel9, -1, -1, 32767).addComponent(this.jLabel7, -1, -1, 32767).addComponent(this.jRBVert, -1, -1, 32767).addComponent(this.jRBGris, -1, -1, 32767)).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jRBBleu, -1, -1, 32767).addComponent(this.jLabel8, -1, -1, 32767)).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel6, -1, -1, 32767).addComponent(this.jRBRouge, -1, -1, 32767))).addContainerGap()));
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
/* 482 */     this.jCBAfficherOptions.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 483 */     this.jCBAfficherOptions.setText("Afficher les options lors de la sélection dans toutes les librairies ");
/*     */     
/* 485 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 486 */     this.jPanel7.setLayout(jPanel7Layout);
/* 487 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBAfficherOptions).addComponent(this.jPanel5, -1, -1, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 496 */     jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addGap(93, 93, 93).addComponent(this.jPanel5, -2, -1, -2).addGap(58, 58, 58).addComponent(this.jCBAfficherOptions).addContainerGap(109, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 506 */     this.jTabbedPane1.addTab("Couleurs", this.jPanel7);
/*     */     
/* 508 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 509 */     this.jPanel3.setLayout(jPanel3Layout);
/* 510 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -1, 485, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 517 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -1, 406, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 525 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 526 */     getContentPane().setLayout(layout);
/* 527 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jBtAnnuler, -2, 107, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtValider, -2, 121, -2))).addContainerGap()));
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
/* 540 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel3, -1, -1, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap()));
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
/* 554 */     pack(); }
/*     */   
/*     */   private JRadioButton jRBGris;
/*     */   
/* 558 */   private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) { this.jRBRouge.setSelected(true); }
/*     */   
/*     */   private JRadioButton jRBRouge;
/*     */   
/* 562 */   private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) { this.jRBVert.setSelected(true); }
/*     */   
/*     */   private JRadioButton jRBVert;
/*     */   
/* 566 */   private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) { this.jRBBleu.setSelected(true); }
/*     */   
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   
/* 570 */   private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) { this.jRBGris.setSelected(true); }
/*     */   
/*     */   private javax.swing.JScrollPane jScrollPane2;
/*     */   
/* 574 */   private void jListEntiteRelationMousePressed(java.awt.event.MouseEvent evt) { int ind = this.jListEntiteRelation.getSelectedIndex();
/* 575 */     if (ind >= 0)
/* 576 */       this.jLabUtilisation.setText("Utilisation : " + getNombreUse((IhmMCD.IhmEntiteRelation)this.listeEntite.get(ind))); }
/*     */   
/*     */   private javax.swing.JTextArea jTACommentaire;
/*     */   private javax.swing.JTextField jTFNom;
/*     */   
/* 581 */   private void jListEntiteRelationKeyReleased(java.awt.event.KeyEvent evt) { int ind = this.jListEntiteRelation.getSelectedIndex();
/* 582 */     if (ind >= 0)
/* 583 */       this.jLabUtilisation.setText("Utilisation : " + getNombreUse((IhmMCD.IhmEntiteRelation)this.listeEntite.get(ind)));
/*     */   }
/*     */   
/*     */   private javax.swing.JTextField jTFPath;
/*     */   private javax.swing.JTabbedPane jTabbedPane1;
/* 588 */   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { new formes2.FormeHistorique(this.frm, true, this.libSel.getHistorique(), "", "").setVisible(true); }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 592 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(java.awt.event.ActionEvent evt) {
/* 596 */     if (renommerLibrairie()) {
/* 597 */       sauvegardeTout();
/* 598 */       this.libSel.setName(this.jTFNom.getText().trim());
/* 599 */       this.libSel.setPath(this.libSel.getRepertoire() + this.libSel.prefixLib(this.jTFNom.getText().trim()));
/* 600 */       dispose();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\LibraryPan\FormeProprieteLibrairie.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */