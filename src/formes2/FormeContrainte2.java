/*     */ package formes2;
/*     */ 
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class FormeContrainte2 extends javax.swing.JDialog
/*     */ {
/*     */   ihm.Principale frm;
/*     */   IhmMCD2.IhmContrainte2 cnt;
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
/*     */   public FormeContrainte2(ihm.Principale parent, boolean modal, IhmMCD2.IhmContrainte2 cnt, int x, int y)
/*     */   {
/*  37 */     super(parent, modal);
/*  38 */     initComponents();
/*  39 */     this.frm = parent;
/*  40 */     this.cnt = cnt;
/*  41 */     setLocation(this.frm.getX() + 290, this.frm.getY() + 150);
/*  42 */     initailiserData();
/*  43 */     this.jBtAnnuler.setMnemonic(65);
/*  44 */     this.jBtOK.setMnemonic(10);
/*     */   }
/*     */   
/*     */   private void initailiserData() {
/*  48 */     this.jLabCadre.setBackground(this.cnt.getClCadre2());
/*  49 */     this.jLabFond.setBackground(this.cnt.getClFond2());
/*  50 */     this.jLabTexte.setBackground(this.cnt.getClText2());
/*  51 */     this.jLabActif.setBackground(this.cnt.getClLienActiver());
/*  52 */     this.jTACommentaire.setText(this.cnt.getCommentaire());
/*  53 */     this.jCBType.setSelectedIndex(getIndexType(this.cnt.getNom()));
/*     */   }
/*     */   
/*     */   private int getIndexType(String s)
/*     */   {
/*  58 */     if (s.equals("X")) {
/*  59 */       return 0;
/*     */     }
/*  61 */     if (s.equals("T")) {
/*  62 */       return 1;
/*     */     }
/*  64 */     if (s.equals("XT")) {
/*  65 */       return 2;
/*     */     }
/*  67 */     if (s.equals("+")) {
/*  68 */       return 3;
/*     */     }
/*  70 */     if (s.equals("I")) {
/*  71 */       return 4;
/*     */     }
/*  73 */     if (s.equals("S")) {
/*  74 */       return 5;
/*     */     }
/*  76 */     if (s.equals("=")) {
/*  77 */       return 6;
/*     */     }
/*  79 */     return 0;
/*     */   }
/*     */   
/*     */   private String getTypeNomIndex(int s) {
/*  83 */     if (s == 0) {
/*  84 */       return "X";
/*     */     }
/*  86 */     if (s == 1) {
/*  87 */       return "T";
/*     */     }
/*  89 */     if (s == 2) {
/*  90 */       return "XT";
/*     */     }
/*  92 */     if (s == 3) {
/*  93 */       return "+";
/*     */     }
/*  95 */     if (s == 4) {
/*  96 */       return "I";
/*     */     }
/*  98 */     if (s == 5) {
/*  99 */       return "S";
/*     */     }
/* 101 */     if (s == 6) {
/* 102 */       return "=";
/*     */     }
/* 104 */     return "X";
/*     */   }
/*     */   
/*     */   private String getTypeContrainteIndex(int s) {
/* 108 */     return IhmMCD2.IhmContrainte2.getTypeContrainte(getTypeNomIndex(s));
/*     */   }
/*     */   
/*     */   private void dessinerApercu()
/*     */   {
/* 113 */     java.awt.Graphics2D g = (java.awt.Graphics2D)this.jPanelAprecu.getGraphics();
/* 114 */     g.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 115 */     String nom = getTypeNomIndex(this.jCBType.getSelectedIndex());
/* 116 */     java.awt.Color clgard = g.getColor();
/*     */     
/* 118 */     int x = this.jPanelAprecu.getWidth() / 5;
/* 119 */     int y = this.jPanelAprecu.getHeight() / 2;
/* 120 */     int w = 38;
/* 121 */     int h = 36;
/*     */     
/* 123 */     g.setColor(this.jLabActif.getBackground());
/* 124 */     g.drawLine(x, 0, x + w / 2, y + h / 2);
/* 125 */     g.drawLine(x + w / 2, y + h / 2, this.jPanelAprecu.getWidth(), y + h / 2);
/*     */     
/* 127 */     g.drawLine(x + w / 2, y + h / 2, this.jPanelAprecu.getWidth(), this.jPanelAprecu.getHeight());
/*     */     
/* 129 */     java.awt.geom.RoundRectangle2D rRect = new java.awt.geom.RoundRectangle2D.Double(x, y, w, h, h, h);
/* 130 */     g.setColor(this.jLabFond.getBackground());
/* 131 */     g.fill(rRect);
/* 132 */     g.setColor(this.jLabCadre.getBackground());
/* 133 */     g.draw(rRect);
/* 134 */     g.setColor(this.jLabTexte.getBackground());
/* 135 */     int tail = g.getFontMetrics().stringWidth(nom);
/*     */     
/* 137 */     java.awt.Font f = g.getFont();
/* 138 */     g.setFont(new java.awt.Font("ARIAL", 1, 12));
/* 139 */     g.drawString(nom, x + 1 + (w - tail) / 2, y + h - 14);
/*     */     
/* 141 */     g.setFont(f);
/* 142 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   private java.awt.Color choixDeCouleur(java.awt.Color color, String titre) {
/* 146 */     java.awt.Color col = javax.swing.JColorChooser.showDialog(this, titre, color);
/* 147 */     if (col == null) return color;
/* 148 */     return col;
/*     */   }
/*     */   
/*     */   private void appliquerToutContainte() {
/* 152 */     java.util.ArrayList<IhmMCD.IhmEntiteRelation> liste = this.frm.getPage().getListeContrainte();
/*     */     
/* 154 */     for (int i = 0; i < liste.size(); i++) {
/* 155 */       IhmMCD2.IhmContrainte2 c = (IhmMCD2.IhmContrainte2)liste.get(i);
/* 156 */       c.setClFond2(this.jLabFond.getBackground());
/* 157 */       c.setClCadre2(this.jLabCadre.getBackground());
/* 158 */       c.setClText2(this.jLabTexte.getBackground());
/* 159 */       c.setClLienActiver(this.jLabActif.getBackground());
/*     */     }
/*     */   }
/*     */   
/*     */   private void appliquerCouleurCOntrainteDefaut() {
/* 164 */     ihm.FormeInterneMCD.clContrainteFond2 = this.jLabFond.getBackground();
/* 165 */     ihm.FormeInterneMCD.clContrainteCadre2 = this.jLabCadre.getBackground();
/* 166 */     ihm.FormeInterneMCD.clContrainteText2 = this.jLabTexte.getBackground();
/* 167 */     ihm.FormeInterneMCD.clLienActiverContainte2 = this.jLabActif.getBackground();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 196 */     this.jTabbedPane1 = new javax.swing.JTabbedPane();
/* 197 */     this.jPanel1 = new javax.swing.JPanel();
/* 198 */     this.jLabel1 = new JLabel();
/* 199 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 200 */     this.jTACommentaire = new javax.swing.JTextArea();
/* 201 */     this.jBtHistorique = new javax.swing.JButton();
/* 202 */     this.jPanel2 = new javax.swing.JPanel();
/* 203 */     this.jPanelAprecu = new javax.swing.JPanel();
/* 204 */     this.jPanel4 = new javax.swing.JPanel();
/* 205 */     this.jLabCadre = new JLabel();
/* 206 */     this.jLabel12 = new JLabel();
/* 207 */     this.jLabel13 = new JLabel();
/* 208 */     this.jLabel15 = new JLabel();
/* 209 */     this.jLabFond = new JLabel();
/* 210 */     this.jLabTexte = new JLabel();
/* 211 */     this.jLabActif = new JLabel();
/* 212 */     this.jLabel2 = new JLabel();
/* 213 */     this.jLabel14 = new JLabel();
/* 214 */     this.jCBDefaut = new javax.swing.JCheckBox();
/* 215 */     this.jCBTout = new javax.swing.JCheckBox();
/* 216 */     this.jCBType = new javax.swing.JComboBox();
/* 217 */     this.jLabel3 = new JLabel();
/* 218 */     this.jBtAnnuler = new javax.swing.JButton();
/* 219 */     this.jBtOK = new javax.swing.JButton();
/*     */     
/* 221 */     setDefaultCloseOperation(2);
/* 222 */     setTitle("Propriété de la contrainte ");
/* 223 */     setResizable(false);
/*     */     
/* 225 */     this.jLabel1.setText("Commentaire ");
/*     */     
/* 227 */     this.jTACommentaire.setColumns(20);
/* 228 */     this.jTACommentaire.setRows(5);
/* 229 */     this.jScrollPane1.setViewportView(this.jTACommentaire);
/*     */     
/* 231 */     this.jBtHistorique.setText("Historique...");
/* 232 */     this.jBtHistorique.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 234 */         FormeContrainte2.this.jBtHistoriqueActionPerformed(evt);
/*     */       }
/*     */       
/* 237 */     });
/* 238 */     javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this.jPanel1);
/* 239 */     this.jPanel1.setLayout(jPanel1Layout);
/* 240 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 549, 32767).addComponent(this.jLabel1).addComponent(this.jBtHistorique)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 250 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 175, 32767).addGap(18, 18, 18).addComponent(this.jBtHistorique).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 262 */     this.jTabbedPane1.addTab("Commentaire ", this.jPanel1);
/*     */     
/* 264 */     this.jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
/*     */       public void componentShown(java.awt.event.ComponentEvent evt) {
/* 266 */         FormeContrainte2.this.jPanel2ComponentShown(evt);
/*     */       }
/*     */       
/* 269 */     });
/* 270 */     this.jPanelAprecu.setBackground(new java.awt.Color(255, 255, 255));
/* 271 */     this.jPanelAprecu.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 273 */         FormeContrainte2.this.jPanelAprecuMouseClicked(evt);
/*     */       }
/*     */       
/* 276 */     });
/* 277 */     javax.swing.GroupLayout jPanelAprecuLayout = new javax.swing.GroupLayout(this.jPanelAprecu);
/* 278 */     this.jPanelAprecu.setLayout(jPanelAprecuLayout);
/* 279 */     jPanelAprecuLayout.setHorizontalGroup(jPanelAprecuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 278, 32767));
/*     */     
/*     */ 
/*     */ 
/* 283 */     jPanelAprecuLayout.setVerticalGroup(jPanelAprecuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 188, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 288 */     this.jLabCadre.setBackground(new java.awt.Color(0, 0, 0));
/* 289 */     this.jLabCadre.setHorizontalAlignment(0);
/* 290 */     this.jLabCadre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 291 */     this.jLabCadre.setCursor(new java.awt.Cursor(12));
/* 292 */     this.jLabCadre.setOpaque(true);
/* 293 */     this.jLabCadre.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 295 */         FormeContrainte2.this.jLabCadreMouseClicked(evt);
/*     */       }
/*     */       
/* 298 */     });
/* 299 */     this.jLabel12.setHorizontalAlignment(0);
/* 300 */     this.jLabel12.setText("Cadre");
/*     */     
/* 302 */     this.jLabel13.setHorizontalAlignment(0);
/* 303 */     this.jLabel13.setText("Texte");
/*     */     
/* 305 */     this.jLabel15.setHorizontalAlignment(0);
/* 306 */     this.jLabel15.setText("Fond");
/*     */     
/* 308 */     this.jLabFond.setBackground(new java.awt.Color(255, 51, 0));
/* 309 */     this.jLabFond.setHorizontalAlignment(0);
/* 310 */     this.jLabFond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 311 */     this.jLabFond.setCursor(new java.awt.Cursor(12));
/* 312 */     this.jLabFond.setOpaque(true);
/* 313 */     this.jLabFond.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 315 */         FormeContrainte2.this.jLabFondMouseClicked(evt);
/*     */       }
/*     */       
/* 318 */     });
/* 319 */     this.jLabTexte.setBackground(new java.awt.Color(0, 0, 0));
/* 320 */     this.jLabTexte.setHorizontalAlignment(0);
/* 321 */     this.jLabTexte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 322 */     this.jLabTexte.setCursor(new java.awt.Cursor(12));
/* 323 */     this.jLabTexte.setOpaque(true);
/* 324 */     this.jLabTexte.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 326 */         FormeContrainte2.this.jLabTexteMouseClicked(evt);
/*     */       }
/*     */       
/* 329 */     });
/* 330 */     this.jLabActif.setBackground(new java.awt.Color(0, 0, 0));
/* 331 */     this.jLabActif.setHorizontalAlignment(0);
/* 332 */     this.jLabActif.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 333 */     this.jLabActif.setCursor(new java.awt.Cursor(12));
/* 334 */     this.jLabActif.setOpaque(true);
/* 335 */     this.jLabActif.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 337 */         FormeContrainte2.this.jLabActifMouseClicked(evt);
/*     */       }
/*     */       
/* 340 */     });
/* 341 */     this.jLabel2.setText("Lien Actif");
/*     */     
/* 343 */     javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(this.jPanel4);
/* 344 */     this.jPanel4.setLayout(jPanel4Layout);
/* 345 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel12).addComponent(this.jLabel15).addComponent(this.jLabel13).addComponent(this.jLabel2)).addGap(61, 61, 61).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabCadre, -1, 55, 32767).addComponent(this.jLabActif, -1, 55, 32767).addComponent(this.jLabTexte, -1, 55, 32767).addComponent(this.jLabFond, -1, 55, 32767)).addGap(18, 18, 18)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 362 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jLabel12).addComponent(this.jLabCadre, -2, 20, -2)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabFond, -1, 17, 32767).addComponent(this.jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel13, javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jLabTexte, javax.swing.GroupLayout.Alignment.TRAILING, -2, 18, -2)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jLabActif, -2, 18, -2).addComponent(this.jLabel2)).addGap(16, 16, 16)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 384 */     this.jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 385 */     this.jLabel14.setForeground(new java.awt.Color(0, 0, 153));
/* 386 */     this.jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/oeil.png")));
/* 387 */     this.jLabel14.setText("Aperçu");
/* 388 */     this.jLabel14.setCursor(new java.awt.Cursor(12));
/* 389 */     this.jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 391 */         FormeContrainte2.this.jLabel14MouseClicked(evt);
/*     */       }
/*     */       
/* 394 */     });
/* 395 */     this.jCBDefaut.setText("Couleurs par défaut");
/* 396 */     this.jCBDefaut.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 398 */         FormeContrainte2.this.jCBDefautMouseClicked(evt);
/*     */       }
/*     */       
/* 401 */     });
/* 402 */     this.jCBTout.setText("Appliquer à toutes les Contraintes ");
/* 403 */     this.jCBTout.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 405 */         FormeContrainte2.this.jCBToutMouseClicked(evt);
/*     */       }
/*     */       
/* 408 */     });
/* 409 */     javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this.jPanel2);
/* 410 */     this.jPanel2.setLayout(jPanel2Layout);
/* 411 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, 32767).addComponent(this.jPanelAprecu, -2, -1, -2)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jCBTout).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, 32767).addComponent(this.jLabel14).addGap(29, 29, 29)).addGroup(jPanel2Layout.createSequentialGroup().addGap(62, 62, 62).addComponent(this.jCBDefaut))))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 432 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(29, 29, 29).addComponent(this.jPanel4, -2, -1, -2)).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanelAprecu, -1, -1, 32767))).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, 32767).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jCBTout).addComponent(this.jCBDefaut)).addContainerGap()).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel14).addContainerGap()))));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 455 */     this.jTabbedPane1.addTab("Affichage", this.jPanel2);
/*     */     
/* 457 */     this.jCBType.setFont(new java.awt.Font("Tahoma", 1, 12));
/* 458 */     this.jCBType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "X   : EXCLUSION", "T   : TOTALITE", "XT : PARTITION", "+  : PARTITION", "I    : INCLUSION", "S   : SIMULTANETE", "=  : SIMULTANEITE " }));
/*     */     
/* 460 */     this.jLabel3.setText("Type contrainte ");
/*     */     
/* 462 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 463 */     this.jBtAnnuler.setText("Annuler");
/* 464 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 466 */         FormeContrainte2.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 469 */     });
/* 470 */     this.jBtOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 471 */     this.jBtOK.setText("Valider");
/* 472 */     this.jBtOK.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 474 */         FormeContrainte2.this.jBtOKActionPerformed(evt);
/*     */       }
/*     */       
/* 477 */     });
/* 478 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/* 479 */     getContentPane().setLayout(layout);
/* 480 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1, -1, 574, 32767).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, 32767).addComponent(this.jCBType, -2, 469, -2)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jBtAnnuler).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtOK, -2, 108, -2))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 496 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jCBType, -2, 33, -2).addComponent(this.jLabel3)).addGap(18, 18, 18).addComponent(this.jTabbedPane1, -1, 286, 32767).addGap(19, 19, 19).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jBtOK).addComponent(this.jBtAnnuler)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 512 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtHistoriqueActionPerformed(java.awt.event.ActionEvent evt) {
/* 516 */     new FormeHistorique(this.frm, true, this.cnt.getHistorique(), "", "").setVisible(true);
/*     */   }
/*     */   
/*     */   private void jPanelAprecuMouseClicked(java.awt.event.MouseEvent evt) {
/* 520 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabCadreMouseClicked(java.awt.event.MouseEvent evt) {
/* 524 */     this.jLabCadre.setBackground(choixDeCouleur(this.jLabCadre.getBackground(), "Couleur Cadre"));
/* 525 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabFondMouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 530 */     this.jLabFond.setBackground(choixDeCouleur(this.jLabFond.getBackground(), "Couleur Fond"));
/* 531 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabTexteMouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 536 */     this.jLabTexte.setBackground(choixDeCouleur(this.jLabTexte.getBackground(), "Couleur Texte"));
/* 537 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabActifMouseClicked(java.awt.event.MouseEvent evt) {
/* 541 */     this.jLabActif.setBackground(choixDeCouleur(this.jLabActif.getBackground(), "Couleur Fond"));
/* 542 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabel14MouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 547 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jCBDefautMouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 552 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jCBToutMouseClicked(java.awt.event.MouseEvent evt) {
/* 556 */     dessinerApercu();
/*     */   }
/*     */   
/*     */ 
/*     */   private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {}
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 564 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtOKActionPerformed(java.awt.event.ActionEvent evt) {
/* 568 */     this.cnt.setClCadre2(this.jLabCadre.getBackground());
/* 569 */     this.cnt.setClFond2(this.jLabFond.getBackground());
/* 570 */     this.cnt.setClText2(this.jLabTexte.getBackground());
/* 571 */     this.cnt.setClLienActiver(this.jLabActif.getBackground());
/* 572 */     this.cnt.setCommentaire(this.jTACommentaire.getText());
/*     */     
/* 574 */     this.cnt.ajouterModification();
/* 575 */     this.cnt.setNom(getTypeNomIndex(this.jCBType.getSelectedIndex()));
/* 576 */     this.cnt.setType(getTypeContrainteIndex(this.jCBType.getSelectedIndex()));
/*     */     
/* 578 */     if (this.jCBTout.isSelected()) {
/* 579 */       appliquerToutContainte();
/*     */     }
/* 581 */     if (this.jCBDefaut.isSelected()) {
/* 582 */       appliquerCouleurCOntrainteDefaut();
/*     */     }
/* 584 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeContrainte2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */