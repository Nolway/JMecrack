/*     */ package formes2;
/*     */ 
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class FormeCommentaire2 extends javax.swing.JDialog {
/*     */   ihm.Principale frm;
/*     */   IhmMCD2.IhmCommentaire2 commentaire;
/*     */   private javax.swing.ButtonGroup buttonGroup1;
/*     */   private javax.swing.JButton jBtAnnuler;
/*     */   private javax.swing.JButton jBtHistorique;
/*     */   private javax.swing.JButton jBtValider;
/*     */   private javax.swing.JCheckBox jCBDefaut;
/*     */   private javax.swing.JCheckBox jCBOmbre;
/*     */   private javax.swing.JCheckBox jCBTout;
/*     */   private javax.swing.JLabel jLabCadre;
/*     */   private javax.swing.JLabel jLabFond;
/*     */   private javax.swing.JLabel jLabTexte;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel12;
/*     */   private javax.swing.JLabel jLabel13;
/*     */   private javax.swing.JLabel jLabel14;
/*     */   private javax.swing.JLabel jLabel15;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JPanel jPanel3;
/*     */   private javax.swing.JPanel jPanel4;
/*     */   private javax.swing.JPanel jPanelAprecu;
/*     */   private javax.swing.JRadioButton jRBCentre;
/*     */   private javax.swing.JRadioButton jRBDroite;
/*     */   private javax.swing.JRadioButton jRBGauche;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JTextArea jTACommenaire;
/*     */   private javax.swing.JTabbedPane jTabbedPane1;
/*     */   
/*  35 */   public FormeCommentaire2(ihm.Principale parent, boolean modal, IhmMCD2.IhmCommentaire2 commentaire) { super(parent, modal);
/*  36 */     initComponents();
/*  37 */     this.frm = parent;
/*  38 */     this.commentaire = commentaire;
/*  39 */     setLocation(this.frm.getX() + 300, this.frm.getY() + 150);
/*  40 */     initData();
/*  41 */     this.jBtAnnuler.setMnemonic(65);
/*  42 */     this.jBtValider.setMnemonic(10);
/*     */   }
/*     */   
/*     */   private void initData() {
/*  46 */     this.jTACommenaire.setText(this.commentaire.getCommentaire());
/*  47 */     this.jLabCadre.setBackground(this.commentaire.getClCadre());
/*  48 */     this.jLabFond.setBackground(this.commentaire.getClFond());
/*  49 */     this.jLabTexte.setBackground(this.commentaire.getClTexte());
/*  50 */     choixAligner();
/*  51 */     this.jCBOmbre.setSelected(this.commentaire.isOmbre());
/*     */   }
/*     */   
/*     */ 
/*     */   private void choixAligner()
/*     */   {
/*  57 */     if (this.commentaire.getAligner().equals("GAUCHE")) {
/*  58 */       this.jRBCentre.setSelected(false);
/*  59 */       this.jRBDroite.setSelected(false);
/*  60 */       this.jRBGauche.setSelected(true);
/*     */     }
/*  62 */     if (this.commentaire.getAligner().equals("DROITE")) {
/*  63 */       this.jRBCentre.setSelected(false);
/*  64 */       this.jRBDroite.setSelected(true);
/*  65 */       this.jRBGauche.setSelected(false);
/*     */     }
/*  67 */     if (this.commentaire.getAligner().equals("CENTRE")) {
/*  68 */       this.jRBCentre.setSelected(true);
/*  69 */       this.jRBDroite.setSelected(false);
/*  70 */       this.jRBGauche.setSelected(false);
/*     */     }
/*     */   }
/*     */   
/*  74 */   private String getChoixAligner() { if (this.jRBGauche.isSelected()) return "GAUCHE";
/*  75 */     if (this.jRBDroite.isSelected()) return "DROITE";
/*  76 */     if (this.jRBCentre.isSelected()) return "CENTRE";
/*  77 */     return "CENTRE";
/*     */   }
/*     */   
/*     */   private void appliquerDefaut() {
/*  81 */     ihm.FormeInterneMCD.clCommentaireFond2 = this.jLabFond.getBackground();
/*  82 */     ihm.FormeInterneMCD.clCommentaireCadre2 = this.jLabCadre.getBackground();
/*  83 */     ihm.FormeInterneMCD.clCommentaireText2 = this.jLabTexte.getBackground();
/*     */   }
/*     */   
/*     */   private void appliquerAToutCommentaire() {
/*  87 */     java.util.ArrayList<IhmMCD.IhmCommentaireIndip> liste = this.frm.getPage().getListeCommentaire();
/*     */     
/*  89 */     for (int i = 0; i < liste.size(); i++) {
/*  90 */       if ((liste.get(i) instanceof IhmMCD2.IhmCommentaire2)) {
/*  91 */         ((IhmMCD2.IhmCommentaire2)liste.get(i)).setClCadre(this.jLabCadre.getBackground());
/*  92 */         ((IhmMCD2.IhmCommentaire2)liste.get(i)).setClFond(this.jLabFond.getBackground());
/*  93 */         ((IhmMCD2.IhmCommentaire2)liste.get(i)).setClTexte(this.jLabTexte.getBackground());
/*  94 */         ((IhmMCD2.IhmCommentaire2)liste.get(i)).setAligner(getChoixAligner());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private java.awt.Color choixDeCouleur(java.awt.Color color, String titre) {
/* 100 */     java.awt.Color col = javax.swing.JColorChooser.showDialog(this, titre, color);
/* 101 */     if (col == null) return color;
/* 102 */     return col;
/*     */   }
/*     */   
/*     */   private void dessinerApercu() {
/* 106 */     java.awt.Graphics2D g = (java.awt.Graphics2D)this.jPanelAprecu.getGraphics();
/* 107 */     g.setFont(new java.awt.Font("Tahoma", 1, 11));
/*     */     
/* 109 */     String comm1 = "Bonjour ou Bonsoir ";
/* 110 */     String comm2 = "Voici votre commentaire";
/* 111 */     String comm3 = "A Bientôt";
/*     */     
/* 113 */     int h = g.getFontMetrics().getHeight();
/* 114 */     java.awt.Color clgard = g.getColor();
/*     */     
/* 116 */     int w1 = g.getFontMetrics().stringWidth(comm1);
/* 117 */     int w2 = g.getFontMetrics().stringWidth(comm2);
/* 118 */     int w3 = g.getFontMetrics().stringWidth(comm3);
/*     */     
/* 120 */     g.setColor(java.awt.Color.WHITE);
/* 121 */     g.fillRect(0, 0, this.jPanelAprecu.getWidth(), this.jPanelAprecu.getHeight());
/* 122 */     g.setColor(this.jLabFond.getBackground());
/* 123 */     g.fillRect(5, 5, this.jPanelAprecu.getWidth() - 10, this.jPanelAprecu.getHeight() - 10);
/* 124 */     g.setColor(this.jLabCadre.getBackground());
/* 125 */     g.drawRect(5, 5, this.jPanelAprecu.getWidth() - 10, this.jPanelAprecu.getHeight() - 10);
/*     */     
/* 127 */     g.setColor(this.jLabTexte.getBackground());
/*     */     
/* 129 */     if (this.jRBGauche.isSelected()) {
/* 130 */       g.drawString(comm1, 10, 40);
/* 131 */       g.drawString(comm2, 10, 65);
/* 132 */       g.drawString(comm3, 10, 90);
/*     */     }
/*     */     
/* 135 */     if (this.jRBDroite.isSelected()) {
/* 136 */       g.drawString(comm1, this.jPanelAprecu.getWidth() - 10 - w1, 40);
/* 137 */       g.drawString(comm2, this.jPanelAprecu.getWidth() - 10 - w2, 65);
/* 138 */       g.drawString(comm3, this.jPanelAprecu.getWidth() - 10 - w3, 90);
/*     */     }
/*     */     
/* 141 */     if (this.jRBCentre.isSelected()) {
/* 142 */       g.drawString(comm1, (this.jPanelAprecu.getWidth() - w1) / 2, 40);
/* 143 */       g.drawString(comm2, (this.jPanelAprecu.getWidth() - w2) / 2, 65);
/* 144 */       g.drawString(comm3, (this.jPanelAprecu.getWidth() - w3) / 2, 90);
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
/* 158 */     this.buttonGroup1 = new javax.swing.ButtonGroup();
/* 159 */     this.jTabbedPane1 = new javax.swing.JTabbedPane();
/* 160 */     this.jPanel1 = new javax.swing.JPanel();
/* 161 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 162 */     this.jTACommenaire = new javax.swing.JTextArea();
/* 163 */     this.jBtHistorique = new javax.swing.JButton();
/* 164 */     this.jPanel2 = new javax.swing.JPanel();
/* 165 */     this.jPanel4 = new javax.swing.JPanel();
/* 166 */     this.jLabCadre = new javax.swing.JLabel();
/* 167 */     this.jLabel12 = new javax.swing.JLabel();
/* 168 */     this.jLabel13 = new javax.swing.JLabel();
/* 169 */     this.jLabel15 = new javax.swing.JLabel();
/* 170 */     this.jLabFond = new javax.swing.JLabel();
/* 171 */     this.jLabTexte = new javax.swing.JLabel();
/* 172 */     this.jCBTout = new javax.swing.JCheckBox();
/* 173 */     this.jCBDefaut = new javax.swing.JCheckBox();
/* 174 */     this.jPanel3 = new javax.swing.JPanel();
/* 175 */     this.jRBGauche = new javax.swing.JRadioButton();
/* 176 */     this.jRBCentre = new javax.swing.JRadioButton();
/* 177 */     this.jRBDroite = new javax.swing.JRadioButton();
/* 178 */     this.jLabel1 = new javax.swing.JLabel();
/* 179 */     this.jPanelAprecu = new javax.swing.JPanel();
/* 180 */     this.jLabel14 = new javax.swing.JLabel();
/* 181 */     this.jCBOmbre = new javax.swing.JCheckBox();
/* 182 */     this.jBtValider = new javax.swing.JButton();
/* 183 */     this.jBtAnnuler = new javax.swing.JButton();
/*     */     
/* 185 */     setDefaultCloseOperation(2);
/* 186 */     setTitle("Propriétés Commentaire");
/* 187 */     setResizable(false);
/*     */     
/* 189 */     this.jTACommenaire.setColumns(20);
/* 190 */     this.jTACommenaire.setRows(5);
/* 191 */     this.jScrollPane1.setViewportView(this.jTACommenaire);
/*     */     
/* 193 */     this.jBtHistorique.setText("Historique ...");
/* 194 */     this.jBtHistorique.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 196 */         FormeCommentaire2.this.jBtHistoriqueActionPerformed(evt);
/*     */       }
/*     */       
/* 199 */     });
/* 200 */     javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this.jPanel1);
/* 201 */     this.jPanel1.setLayout(jPanel1Layout);
/* 202 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 433, 32767).addComponent(this.jBtHistorique)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 211 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 189, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtHistorique).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 221 */     this.jTabbedPane1.addTab("Commentaire ", this.jPanel1);
/*     */     
/* 223 */     this.jLabCadre.setBackground(new java.awt.Color(0, 0, 0));
/* 224 */     this.jLabCadre.setHorizontalAlignment(0);
/* 225 */     this.jLabCadre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 226 */     this.jLabCadre.setCursor(new java.awt.Cursor(12));
/* 227 */     this.jLabCadre.setOpaque(true);
/* 228 */     this.jLabCadre.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 230 */         FormeCommentaire2.this.jLabCadreMouseClicked(evt);
/*     */       }
/*     */       
/* 233 */     });
/* 234 */     this.jLabel12.setHorizontalAlignment(0);
/* 235 */     this.jLabel12.setText("Cadre");
/*     */     
/* 237 */     this.jLabel13.setHorizontalAlignment(0);
/* 238 */     this.jLabel13.setText("Texte");
/*     */     
/* 240 */     this.jLabel15.setHorizontalAlignment(0);
/* 241 */     this.jLabel15.setText("Fond");
/*     */     
/* 243 */     this.jLabFond.setBackground(new java.awt.Color(255, 51, 0));
/* 244 */     this.jLabFond.setHorizontalAlignment(0);
/* 245 */     this.jLabFond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 246 */     this.jLabFond.setCursor(new java.awt.Cursor(12));
/* 247 */     this.jLabFond.setOpaque(true);
/* 248 */     this.jLabFond.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 250 */         FormeCommentaire2.this.jLabFondMouseClicked(evt);
/*     */       }
/*     */       
/* 253 */     });
/* 254 */     this.jLabTexte.setBackground(new java.awt.Color(0, 0, 0));
/* 255 */     this.jLabTexte.setHorizontalAlignment(0);
/* 256 */     this.jLabTexte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 257 */     this.jLabTexte.setCursor(new java.awt.Cursor(12));
/* 258 */     this.jLabTexte.setOpaque(true);
/* 259 */     this.jLabTexte.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 261 */         FormeCommentaire2.this.jLabTexteMouseClicked(evt);
/*     */       }
/*     */       
/* 264 */     });
/* 265 */     javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(this.jPanel4);
/* 266 */     this.jPanel4.setLayout(jPanel4Layout);
/* 267 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel12).addComponent(this.jLabel15).addComponent(this.jLabel13)).addGap(55, 55, 55).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabCadre, javax.swing.GroupLayout.Alignment.TRAILING, -1, 55, 32767).addComponent(this.jLabFond, javax.swing.GroupLayout.Alignment.TRAILING, -1, 55, 32767).addComponent(this.jLabTexte, -1, 55, 32767)).addContainerGap()));
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
/* 282 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(17, 17, 17).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel12).addGap(18, 21, 32767).addComponent(this.jLabel15)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabCadre, -2, 20, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabFond, -1, 18, 32767))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel13).addComponent(this.jLabTexte, -2, 18, -2)).addGap(22, 22, 22)));
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
/* 302 */     this.jCBTout.setText("Appliquer à tous les Commentaires  ");
/* 303 */     this.jCBTout.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 305 */         FormeCommentaire2.this.jCBToutMouseClicked(evt);
/*     */       }
/* 307 */     });
/* 308 */     this.jCBTout.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 310 */         FormeCommentaire2.this.jCBToutActionPerformed(evt);
/*     */       }
/*     */       
/* 313 */     });
/* 314 */     this.jCBDefaut.setText("Couleurs par défaut");
/* 315 */     this.jCBDefaut.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 317 */         FormeCommentaire2.this.jCBDefautMouseClicked(evt);
/*     */       }
/* 319 */     });
/* 320 */     this.jCBDefaut.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 322 */         FormeCommentaire2.this.jCBDefautActionPerformed(evt);
/*     */       }
/*     */       
/* 325 */     });
/* 326 */     this.jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/*     */     
/* 328 */     this.buttonGroup1.add(this.jRBGauche);
/* 329 */     this.jRBGauche.setSelected(true);
/* 330 */     this.jRBGauche.setText("GAUCHE");
/* 331 */     this.jRBGauche.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 333 */         FormeCommentaire2.this.jRBGaucheActionPerformed(evt);
/*     */       }
/*     */       
/* 336 */     });
/* 337 */     this.buttonGroup1.add(this.jRBCentre);
/* 338 */     this.jRBCentre.setText("CENTRE");
/* 339 */     this.jRBCentre.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 341 */         FormeCommentaire2.this.jRBCentreActionPerformed(evt);
/*     */       }
/*     */       
/* 344 */     });
/* 345 */     this.buttonGroup1.add(this.jRBDroite);
/* 346 */     this.jRBDroite.setText("DROITE");
/* 347 */     this.jRBDroite.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 349 */         FormeCommentaire2.this.jRBDroiteActionPerformed(evt);
/*     */       }
/*     */       
/* 352 */     });
/* 353 */     javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(this.jPanel3);
/* 354 */     this.jPanel3.setLayout(jPanel3Layout);
/* 355 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jRBGauche).addGap(40, 40, 40).addComponent(this.jRBCentre).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, 32767).addComponent(this.jRBDroite).addGap(34, 34, 34)));
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
/* 366 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jRBGauche).addComponent(this.jRBDroite).addComponent(this.jRBCentre)).addContainerGap(-1, 32767)));
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
/* 377 */     this.jLabel1.setText("Aligner le texte ");
/*     */     
/* 379 */     this.jPanelAprecu.setBackground(new java.awt.Color(255, 255, 255));
/* 380 */     this.jPanelAprecu.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 382 */         FormeCommentaire2.this.jPanelAprecuMouseClicked(evt);
/*     */       }
/*     */       
/* 385 */     });
/* 386 */     javax.swing.GroupLayout jPanelAprecuLayout = new javax.swing.GroupLayout(this.jPanelAprecu);
/* 387 */     this.jPanelAprecu.setLayout(jPanelAprecuLayout);
/* 388 */     jPanelAprecuLayout.setHorizontalGroup(jPanelAprecuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 256, 32767));
/*     */     
/*     */ 
/*     */ 
/* 392 */     jPanelAprecuLayout.setVerticalGroup(jPanelAprecuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 117, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 397 */     this.jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 398 */     this.jLabel14.setForeground(new java.awt.Color(0, 0, 153));
/* 399 */     this.jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/oeil.png")));
/* 400 */     this.jLabel14.setText("Aperçu");
/* 401 */     this.jLabel14.setCursor(new java.awt.Cursor(12));
/* 402 */     this.jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 404 */         FormeCommentaire2.this.jLabel14MouseClicked(evt);
/*     */       }
/*     */       
/* 407 */     });
/* 408 */     this.jCBOmbre.setText("Ombre");
/*     */     
/* 410 */     javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this.jPanel2);
/* 411 */     this.jPanel2.setLayout(jPanel2Layout);
/* 412 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel4, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanelAprecu, -1, -1, 32767)).addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addGap(19, 19, 19).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jCBTout).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, 32767).addComponent(this.jCBDefaut).addGap(42, 42, 42)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, 32767).addComponent(this.jCBOmbre)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 277, 32767).addComponent(this.jLabel14))).addGap(11, 11, 11))))).addGap(10, 10, 10)));
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
/*     */ 
/*     */ 
/*     */ 
/* 442 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false).addComponent(this.jPanelAprecu, -1, -1, 32767).addComponent(this.jPanel4, -1, -1, 32767)).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, 32767).addComponent(this.jLabel1)).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel14))).addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jCBOmbre).addComponent(this.jPanel3, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jCBTout).addComponent(this.jCBDefaut)).addContainerGap()));
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
/* 467 */     this.jTabbedPane1.addTab("Affichage", this.jPanel2);
/*     */     
/* 469 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 470 */     this.jBtValider.setText("Valider");
/* 471 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 473 */         FormeCommentaire2.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 476 */     });
/* 477 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 478 */     this.jBtAnnuler.setText("Annuler");
/* 479 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 481 */         FormeCommentaire2.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 484 */     });
/* 485 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/* 486 */     getContentPane().setLayout(layout);
/* 487 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jBtAnnuler, -2, 107, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtValider, -2, 103, -2)).addComponent(this.jTabbedPane1)).addContainerGap()));
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
/* 499 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -1, 273, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap()));
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
/* 511 */     pack();
/*     */   }
/*     */   
/*     */   private void jLabCadreMouseClicked(java.awt.event.MouseEvent evt) {
/* 515 */     this.jLabCadre.setBackground(choixDeCouleur(this.jLabCadre.getBackground(), "Couleur Cadre"));
/* 516 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabFondMouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 521 */     this.jLabFond.setBackground(choixDeCouleur(this.jLabFond.getBackground(), "Couleur Fond"));
/* 522 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabTexteMouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 527 */     this.jLabTexte.setBackground(choixDeCouleur(this.jLabTexte.getBackground(), "Couleur Texte"));
/* 528 */     dessinerApercu();
/*     */   }
/*     */   
/*     */ 
/*     */   private void jCBToutMouseClicked(java.awt.event.MouseEvent evt) {}
/*     */   
/*     */ 
/*     */   private void jCBDefautMouseClicked(java.awt.event.MouseEvent evt) {}
/*     */   
/*     */ 
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 540 */     dispose();
/*     */   }
/*     */   
/*     */   private void jRBGaucheActionPerformed(java.awt.event.ActionEvent evt) {
/* 544 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jRBCentreActionPerformed(java.awt.event.ActionEvent evt) {
/* 548 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jRBDroiteActionPerformed(java.awt.event.ActionEvent evt) {
/* 552 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jCBToutActionPerformed(java.awt.event.ActionEvent evt) {
/* 556 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jCBDefautActionPerformed(java.awt.event.ActionEvent evt) {
/* 560 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jPanelAprecuMouseClicked(java.awt.event.MouseEvent evt) {
/* 564 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabel14MouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 569 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 574 */     String s = this.jTACommenaire.getText().trim();
/* 575 */     s = s.replace("\n", "");
/* 576 */     if (s.length() == 0) {
/* 577 */       s = s + " Votre commentaire ici";
/* 578 */       this.commentaire.setCommentaire(s);
/* 579 */     } else { this.commentaire.setCommentaire(this.jTACommenaire.getText());
/*     */     }
/*     */     
/* 582 */     this.commentaire.setClCadre(this.jLabCadre.getBackground());
/* 583 */     this.commentaire.setClFond(this.jLabFond.getBackground());
/* 584 */     this.commentaire.setClTexte(this.jLabTexte.getBackground());
/* 585 */     this.commentaire.setAligner(getChoixAligner());
/* 586 */     this.commentaire.setOmbre(this.jCBOmbre.isSelected());
/* 587 */     if (this.jCBDefaut.isSelected()) {
/* 588 */       appliquerDefaut();
/*     */     }
/* 590 */     if (this.jCBTout.isSelected()) {
/* 591 */       appliquerAToutCommentaire();
/*     */     }
/* 593 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtHistoriqueActionPerformed(java.awt.event.ActionEvent evt) {
/* 597 */     new FormeHistorique(this.frm, true, this.commentaire.getHistorique(), "", "").setVisible(true);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeCommentaire2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */