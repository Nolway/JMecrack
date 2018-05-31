/*     */ package formes2;
/*     */ 
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class FormeContrainteHeritage2 extends javax.swing.JDialog
/*     */ {
/*     */   ihm.Principale frm;
/*     */   IhmMCD2.IhmHeritage2 heritage;
/*     */   private javax.swing.JButton jBtAnnuler;
/*     */   private javax.swing.JButton jBtHistorique;
/*     */   private javax.swing.JButton jBtOK;
/*     */   private javax.swing.JCheckBox jCBDefaut;
/*     */   private javax.swing.JCheckBox jCBTout;
/*     */   private javax.swing.JComboBox jCBType;
/*     */   private JLabel jLabActif;
/*     */   private JLabel jLabCadre;
/*     */   private JLabel jLabFond;
/*     */   private JLabel jLabTexte;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel12;
/*     */   private JLabel jLabel13;
/*     */   private JLabel jLabel14;
/*     */   private JLabel jLabel15;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JPanel jPanel4;
/*     */   private javax.swing.JPanel jPanelAprecu;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JTextArea jTACommentaire;
/*     */   private javax.swing.JTabbedPane jTabbedPane1;
/*     */   
/*     */   public FormeContrainteHeritage2(ihm.Principale frm, boolean modal, IhmMCD2.IhmHeritage2 heritage) {
/*  35 */     super(frm, modal);
/*  36 */     initComponents();
/*  37 */     this.frm = frm;
/*  38 */     this.heritage = heritage;
/*  39 */     setLocation(frm.getX() + 290, frm.getY() + 150);
/*  40 */     initailiserData();
/*  41 */     this.jBtOK.setMnemonic(10);
/*  42 */     this.jBtAnnuler.setMnemonic(65);
/*  43 */     if (unSeulLienHeritage()) this.jCBType.setEnabled(false);
/*     */   }
/*     */   
/*     */   private void initailiserData()
/*     */   {
/*  48 */     this.jLabCadre.setBackground(this.heritage.getClCadre2());
/*  49 */     this.jLabFond.setBackground(this.heritage.getClFond2());
/*  50 */     this.jLabTexte.setBackground(this.heritage.getClText2());
/*  51 */     this.jLabActif.setBackground(this.heritage.getClLienActiver());
/*  52 */     this.jTACommentaire.setText(this.heritage.getCommentaire());
/*  53 */     this.jCBType.setSelectedIndex(getIndexType(this.heritage.getNom()));
/*     */   }
/*     */   
/*     */   private int getIndexType(String s) {
/*  57 */     if (s.equals("X")) {
/*  58 */       return 1;
/*     */     }
/*  60 */     if (s.equals("T")) {
/*  61 */       return 2;
/*     */     }
/*  63 */     if (s.equals("XT")) {
/*  64 */       return 3;
/*     */     }
/*  66 */     if (s.equals("+")) {
/*  67 */       return 4;
/*     */     }
/*  69 */     if (s.equals("")) {
/*  70 */       return 0;
/*     */     }
/*     */     
/*  73 */     return 0;
/*     */   }
/*     */   
/*     */   private String getTypeNomIndex(int s) {
/*  77 */     if (s == 1) {
/*  78 */       return "X";
/*     */     }
/*  80 */     if (s == 2) {
/*  81 */       return "T";
/*     */     }
/*  83 */     if (s == 3) {
/*  84 */       return "XT";
/*     */     }
/*  86 */     if (s == 4) {
/*  87 */       return "+";
/*     */     }
/*  89 */     if (s == 0) {
/*  90 */       return "";
/*     */     }
/*     */     
/*  93 */     return "X";
/*     */   }
/*     */   
/*     */   private String getTypeContrainteIndex(int s) {
/*  97 */     return getTypeNomIndex(s);
/*     */   }
/*     */   
/*     */   private void dessinerApercu() {
/* 101 */     java.awt.Graphics2D g = (java.awt.Graphics2D)this.jPanelAprecu.getGraphics();
/* 102 */     g.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 103 */     String nom = getTypeNomIndex(this.jCBType.getSelectedIndex());
/* 104 */     if (nom.trim().length() == 0) nom = "RM";
/* 105 */     java.awt.Color clgard = g.getColor();
/*     */     
/* 107 */     int x = this.jPanelAprecu.getWidth() / 5;
/* 108 */     int y = this.jPanelAprecu.getHeight() / 2;
/* 109 */     int w = 58;
/* 110 */     int h = 26;
/*     */     
/* 112 */     g.setColor(this.jLabActif.getBackground());
/* 113 */     g.drawLine(x, 0, x + w / 2, y + h / 2);
/* 114 */     g.drawLine(x + w / 2, y + h / 2, this.jPanelAprecu.getWidth(), y + h / 2);
/*     */     
/* 116 */     g.drawLine(x + w / 2, y + h / 2, this.jPanelAprecu.getWidth(), this.jPanelAprecu.getHeight());
/*     */     
/*     */ 
/* 119 */     int[] xtab = { x + w / 2, x + w, x };
/* 120 */     int[] ytab = { y, y + h, y + h };
/* 121 */     g.setColor(this.jLabFond.getBackground());
/* 122 */     g.fillPolygon(xtab, ytab, 3);
/* 123 */     g.setColor(this.jLabCadre.getBackground());
/* 124 */     g.drawPolygon(xtab, ytab, 3);
/*     */     
/* 126 */     g.setColor(this.jLabTexte.getBackground());
/* 127 */     int tail = g.getFontMetrics().stringWidth(nom);
/*     */     
/* 129 */     java.awt.Font f = g.getFont();
/* 130 */     g.setFont(new java.awt.Font("ARIAL", 1, 12));
/* 131 */     g.drawString(nom, x + 1 + (w - tail) / 2, y + h - 4);
/*     */     
/* 133 */     g.setFont(f);
/* 134 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   private boolean unSeulLienHeritage() {
/* 138 */     int n = this.frm.getPage().getListeLienContrainteHeritage().size();
/* 139 */     int cpt = 0;
/* 140 */     for (int i = 0; i < n; i++) {
/* 141 */       if (((IhmMCD.IhmLienContrainteHeritage)this.frm.getPage().getListeLienContrainteHeritage().get(i)).getHeritage().equals(this.heritage)) {
/* 142 */         cpt++;
/*     */       }
/* 144 */       if (cpt > 2) return false;
/*     */     }
/* 146 */     return true;
/*     */   }
/*     */   
/*     */   private java.awt.Color choixDeCouleur(java.awt.Color color, String titre) {
/* 150 */     java.awt.Color col = javax.swing.JColorChooser.showDialog(this, titre, color);
/* 151 */     if (col == null) return color;
/* 152 */     return col;
/*     */   }
/*     */   
/*     */   private void appliquerToutContainte() {
/* 156 */     java.util.ArrayList<IhmMCD.IhmHeritage> liste = this.frm.getPage().getListeHeritage();
/*     */     
/* 158 */     for (int i = 0; i < liste.size(); i++) {
/* 159 */       IhmMCD2.IhmHeritage2 c = (IhmMCD2.IhmHeritage2)liste.get(i);
/* 160 */       c.setClFond2(this.jLabFond.getBackground());
/* 161 */       c.setClCadre2(this.jLabCadre.getBackground());
/* 162 */       c.setClText2(this.jLabTexte.getBackground());
/* 163 */       c.setClLienActiver(this.jLabActif.getBackground());
/*     */     }
/*     */   }
/*     */   
/*     */   private void appliquerCouleurCOntrainteDefaut() {
/* 168 */     ihm.FormeInterneMCD.clHeritageFond2 = this.jLabFond.getBackground();
/* 169 */     ihm.FormeInterneMCD.clHeritageCadre2 = this.jLabCadre.getBackground();
/* 170 */     ihm.FormeInterneMCD.clHeritageText2 = this.jLabTexte.getBackground();
/* 171 */     ihm.FormeInterneMCD.clLienActiverHeritage2 = this.jLabActif.getBackground();
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
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 186 */     this.jCBType = new javax.swing.JComboBox();
/* 187 */     this.jLabel3 = new JLabel();
/* 188 */     this.jTabbedPane1 = new javax.swing.JTabbedPane();
/* 189 */     this.jPanel1 = new javax.swing.JPanel();
/* 190 */     this.jLabel1 = new JLabel();
/* 191 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 192 */     this.jTACommentaire = new javax.swing.JTextArea();
/* 193 */     this.jBtHistorique = new javax.swing.JButton();
/* 194 */     this.jPanel2 = new javax.swing.JPanel();
/* 195 */     this.jPanelAprecu = new javax.swing.JPanel();
/* 196 */     this.jPanel4 = new javax.swing.JPanel();
/* 197 */     this.jLabCadre = new JLabel();
/* 198 */     this.jLabel12 = new JLabel();
/* 199 */     this.jLabel13 = new JLabel();
/* 200 */     this.jLabel15 = new JLabel();
/* 201 */     this.jLabFond = new JLabel();
/* 202 */     this.jLabTexte = new JLabel();
/* 203 */     this.jLabActif = new JLabel();
/* 204 */     this.jLabel2 = new JLabel();
/* 205 */     this.jLabel14 = new JLabel();
/* 206 */     this.jCBDefaut = new javax.swing.JCheckBox();
/* 207 */     this.jCBTout = new javax.swing.JCheckBox();
/* 208 */     this.jBtAnnuler = new javax.swing.JButton();
/* 209 */     this.jBtOK = new javax.swing.JButton();
/*     */     
/* 211 */     setDefaultCloseOperation(2);
/* 212 */     setTitle("Propriétés de la contrainte Héritage");
/* 213 */     setResizable(false);
/*     */     
/* 215 */     this.jCBType.setFont(new java.awt.Font("Tahoma", 1, 12));
/* 216 */     this.jCBType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "X   : EXCLUSION", "T   : TOTALITE", "XT : PARTITION (EXCLUSION et TOTALITE)", "+  : PARTITION  (EXCLUSION et TOTALITE)" }));
/*     */     
/* 218 */     this.jLabel3.setText("Type contrainte ");
/*     */     
/* 220 */     this.jLabel1.setText("Commentaire ");
/*     */     
/* 222 */     this.jTACommentaire.setColumns(20);
/* 223 */     this.jTACommentaire.setRows(5);
/* 224 */     this.jScrollPane1.setViewportView(this.jTACommentaire);
/*     */     
/* 226 */     this.jBtHistorique.setText("Historique...");
/* 227 */     this.jBtHistorique.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 229 */         FormeContrainteHeritage2.this.jBtHistoriqueActionPerformed(evt);
/*     */       }
/*     */       
/* 232 */     });
/* 233 */     javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this.jPanel1);
/* 234 */     this.jPanel1.setLayout(jPanel1Layout);
/* 235 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 527, 32767).addComponent(this.jLabel1).addComponent(this.jBtHistorique)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 245 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 147, 32767).addGap(18, 18, 18).addComponent(this.jBtHistorique).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 257 */     this.jTabbedPane1.addTab("Commentaire ", this.jPanel1);
/*     */     
/* 259 */     this.jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
/*     */       public void componentShown(java.awt.event.ComponentEvent evt) {
/* 261 */         FormeContrainteHeritage2.this.jPanel2ComponentShown(evt);
/*     */       }
/*     */       
/* 264 */     });
/* 265 */     this.jPanelAprecu.setBackground(new java.awt.Color(255, 255, 255));
/* 266 */     this.jPanelAprecu.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 268 */         FormeContrainteHeritage2.this.jPanelAprecuMouseClicked(evt);
/*     */       }
/*     */       
/* 271 */     });
/* 272 */     javax.swing.GroupLayout jPanelAprecuLayout = new javax.swing.GroupLayout(this.jPanelAprecu);
/* 273 */     this.jPanelAprecu.setLayout(jPanelAprecuLayout);
/* 274 */     jPanelAprecuLayout.setHorizontalGroup(jPanelAprecuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 278, 32767));
/*     */     
/*     */ 
/*     */ 
/* 278 */     jPanelAprecuLayout.setVerticalGroup(jPanelAprecuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 174, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 283 */     this.jLabCadre.setBackground(new java.awt.Color(0, 0, 0));
/* 284 */     this.jLabCadre.setHorizontalAlignment(0);
/* 285 */     this.jLabCadre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 286 */     this.jLabCadre.setCursor(new java.awt.Cursor(12));
/* 287 */     this.jLabCadre.setOpaque(true);
/* 288 */     this.jLabCadre.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 290 */         FormeContrainteHeritage2.this.jLabCadreMouseClicked(evt);
/*     */       }
/*     */       
/* 293 */     });
/* 294 */     this.jLabel12.setHorizontalAlignment(0);
/* 295 */     this.jLabel12.setText("Cadre");
/*     */     
/* 297 */     this.jLabel13.setHorizontalAlignment(0);
/* 298 */     this.jLabel13.setText("Texte");
/*     */     
/* 300 */     this.jLabel15.setHorizontalAlignment(0);
/* 301 */     this.jLabel15.setText("Fond");
/*     */     
/* 303 */     this.jLabFond.setBackground(new java.awt.Color(255, 51, 0));
/* 304 */     this.jLabFond.setHorizontalAlignment(0);
/* 305 */     this.jLabFond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 306 */     this.jLabFond.setCursor(new java.awt.Cursor(12));
/* 307 */     this.jLabFond.setOpaque(true);
/* 308 */     this.jLabFond.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 310 */         FormeContrainteHeritage2.this.jLabFondMouseClicked(evt);
/*     */       }
/*     */       
/* 313 */     });
/* 314 */     this.jLabTexte.setBackground(new java.awt.Color(0, 0, 0));
/* 315 */     this.jLabTexte.setHorizontalAlignment(0);
/* 316 */     this.jLabTexte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 317 */     this.jLabTexte.setCursor(new java.awt.Cursor(12));
/* 318 */     this.jLabTexte.setOpaque(true);
/* 319 */     this.jLabTexte.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 321 */         FormeContrainteHeritage2.this.jLabTexteMouseClicked(evt);
/*     */       }
/*     */       
/* 324 */     });
/* 325 */     this.jLabActif.setBackground(new java.awt.Color(0, 0, 0));
/* 326 */     this.jLabActif.setHorizontalAlignment(0);
/* 327 */     this.jLabActif.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 328 */     this.jLabActif.setCursor(new java.awt.Cursor(12));
/* 329 */     this.jLabActif.setOpaque(true);
/* 330 */     this.jLabActif.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 332 */         FormeContrainteHeritage2.this.jLabActifMouseClicked(evt);
/*     */       }
/*     */       
/* 335 */     });
/* 336 */     this.jLabel2.setText("Lien Actif");
/*     */     
/* 338 */     javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(this.jPanel4);
/* 339 */     this.jPanel4.setLayout(jPanel4Layout);
/* 340 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel12).addComponent(this.jLabel15).addComponent(this.jLabel13).addComponent(this.jLabel2)).addGap(61, 61, 61).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabCadre, -1, 55, 32767).addComponent(this.jLabActif, -1, 55, 32767).addComponent(this.jLabTexte, -1, 55, 32767).addComponent(this.jLabFond, -1, 55, 32767)).addGap(18, 18, 18)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 357 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jLabel12).addComponent(this.jLabCadre, -2, 20, -2)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabFond, -1, 17, 32767).addComponent(this.jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel13, javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jLabTexte, javax.swing.GroupLayout.Alignment.TRAILING, -2, 18, -2)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jLabActif, -2, 18, -2).addComponent(this.jLabel2)).addGap(16, 16, 16)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 379 */     this.jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 380 */     this.jLabel14.setForeground(new java.awt.Color(0, 0, 153));
/* 381 */     this.jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/oeil.png")));
/* 382 */     this.jLabel14.setText("Aperçu");
/* 383 */     this.jLabel14.setCursor(new java.awt.Cursor(12));
/* 384 */     this.jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 386 */         FormeContrainteHeritage2.this.jLabel14MouseClicked(evt);
/*     */       }
/*     */       
/* 389 */     });
/* 390 */     this.jCBDefaut.setText("Couleurs par défaut");
/* 391 */     this.jCBDefaut.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 393 */         FormeContrainteHeritage2.this.jCBDefautMouseClicked(evt);
/*     */       }
/*     */       
/* 396 */     });
/* 397 */     this.jCBTout.setText("Appliquer à toutes les Contraintes ");
/* 398 */     this.jCBTout.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 400 */         FormeContrainteHeritage2.this.jCBToutMouseClicked(evt);
/*     */       }
/*     */       
/* 403 */     });
/* 404 */     javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this.jPanel2);
/* 405 */     this.jPanel2.setLayout(jPanel2Layout);
/* 406 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, 32767).addComponent(this.jPanelAprecu, -2, -1, -2)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jCBTout).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, 32767).addComponent(this.jLabel14).addGap(29, 29, 29)).addGroup(jPanel2Layout.createSequentialGroup().addGap(62, 62, 62).addComponent(this.jCBDefaut))))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 427 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(29, 29, 29).addComponent(this.jPanel4, -2, -1, -2)).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanelAprecu, -1, -1, 32767))).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, 32767).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jCBTout).addComponent(this.jCBDefaut)).addContainerGap()).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel14).addContainerGap()))));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 450 */     this.jTabbedPane1.addTab("Affichage", this.jPanel2);
/*     */     
/* 452 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 453 */     this.jBtAnnuler.setText("Annuler");
/* 454 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 456 */         FormeContrainteHeritage2.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 459 */     });
/* 460 */     this.jBtOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 461 */     this.jBtOK.setText("Valider");
/* 462 */     this.jBtOK.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 464 */         FormeContrainteHeritage2.this.jBtOKActionPerformed(evt);
/*     */       }
/*     */       
/* 467 */     });
/* 468 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/* 469 */     getContentPane().setLayout(layout);
/* 470 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1, -1, 552, 32767).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jCBType, -2, 469, -2)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jBtAnnuler).addGap(18, 18, 18).addComponent(this.jBtOK, -2, 99, -2))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 486 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jCBType, -2, 33, -2).addComponent(this.jLabel3)).addGap(18, 18, 18).addComponent(this.jTabbedPane1, -1, 258, 32767).addGap(19, 19, 19).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jBtOK).addComponent(this.jBtAnnuler)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 502 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtHistoriqueActionPerformed(java.awt.event.ActionEvent evt) {
/* 506 */     new FormeHistorique(this.frm, true, this.heritage.getHistorique(), "", "").setVisible(true);
/*     */   }
/*     */   
/*     */   private void jPanelAprecuMouseClicked(java.awt.event.MouseEvent evt) {
/* 510 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabCadreMouseClicked(java.awt.event.MouseEvent evt) {
/* 514 */     this.jLabCadre.setBackground(choixDeCouleur(this.jLabCadre.getBackground(), "Couleur Cadre"));
/* 515 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabFondMouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 520 */     this.jLabFond.setBackground(choixDeCouleur(this.jLabFond.getBackground(), "Couleur Fond"));
/* 521 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabTexteMouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 526 */     this.jLabTexte.setBackground(choixDeCouleur(this.jLabTexte.getBackground(), "Couleur Texte"));
/* 527 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabActifMouseClicked(java.awt.event.MouseEvent evt) {
/* 531 */     this.jLabActif.setBackground(choixDeCouleur(this.jLabActif.getBackground(), "Couleur Fond"));
/* 532 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabel14MouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 537 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jCBDefautMouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 542 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jCBToutMouseClicked(java.awt.event.MouseEvent evt) {
/* 546 */     dessinerApercu();
/*     */   }
/*     */   
/*     */ 
/*     */   private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {}
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 554 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtOKActionPerformed(java.awt.event.ActionEvent evt) {
/* 558 */     this.heritage.setClCadre2(this.jLabCadre.getBackground());
/* 559 */     this.heritage.setClFond2(this.jLabFond.getBackground());
/* 560 */     this.heritage.setClText2(this.jLabTexte.getBackground());
/* 561 */     this.heritage.setClLienActiver(this.jLabActif.getBackground());
/* 562 */     this.heritage.setCommentaire(this.jTACommentaire.getText());
/*     */     
/* 564 */     this.heritage.ajouterModification();
/* 565 */     this.heritage.setNom(getTypeNomIndex(this.jCBType.getSelectedIndex()));
/*     */     
/*     */ 
/* 568 */     if (this.jCBTout.isSelected()) {
/* 569 */       appliquerToutContainte();
/*     */     }
/* 571 */     if (this.jCBDefaut.isSelected()) {
/* 572 */       appliquerCouleurCOntrainteDefaut();
/*     */     }
/* 574 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeContrainteHeritage2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */