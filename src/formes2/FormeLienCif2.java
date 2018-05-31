/*     */ package formes2;
/*     */ 
/*     */ import IhmMCD2.IhmLienCIF2;
/*     */ import java.awt.Graphics2D;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class FormeLienCif2 extends javax.swing.JDialog
/*     */ {
/*     */   ihm.Principale frm;
/*     */   IhmLienCIF2 lien;
/*     */   private javax.swing.JButton jBtAnnuler;
/*     */   private javax.swing.JButton jBtHsitorique;
/*     */   private javax.swing.JButton jBtOK;
/*     */   private javax.swing.JCheckBox jCBDefaut;
/*     */   private javax.swing.JCheckBox jCBFleche;
/*     */   private javax.swing.JCheckBox jCBTout;
/*     */   private JLabel jLabFond;
/*     */   private JLabel jLabNom;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel12;
/*     */   private JLabel jLabel14;
/*     */   private JLabel jLabel15;
/*     */   private JLabel jLabel9;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JPanel jPanel4;
/*     */   private javax.swing.JPanel jPanelAprecu;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JSpinner jSpNBCassure;
/*     */   private javax.swing.JTextPane jTACommentaire;
/*     */   private javax.swing.JTextField jTFNom;
/*     */   private javax.swing.JTabbedPane jTabbedPane1;
/*     */   
/*     */   public FormeLienCif2(ihm.Principale frm, boolean modal, IhmLienCIF2 lien, int x, int y)
/*     */   {
/*  38 */     super(frm, modal);
/*  39 */     this.frm = frm;
/*  40 */     this.lien = lien;
/*  41 */     initComponents();
/*  42 */     setLocation(frm.getX() + 290, frm.getY() + 120);
/*  43 */     initData();
/*  44 */     this.jBtAnnuler.setMnemonic(65);
/*  45 */     this.jBtOK.setMnemonic(10);
/*     */   }
/*     */   
/*     */   private void initData() {
/*  49 */     this.jTFNom.setText(this.lien.getNom());
/*  50 */     this.jLabFond.setBackground(this.lien.getClLienCIF2());
/*  51 */     this.jLabNom.setBackground(this.lien.getClLienNomCIF2());
/*  52 */     this.jSpNBCassure.setValue(Integer.valueOf(this.lien.getPointCassure().size()));
/*  53 */     this.jCBFleche.setSelected(this.lien.isFleche());
/*  54 */     this.jTACommentaire.setText(this.lien.getCommentaire());
/*  55 */     if ((this.lien.getEntiteRelation() instanceof IhmMCD2.IhmRelation2)) {
/*  56 */       this.jCBFleche.setEnabled(false);
/*     */     }
/*  58 */     if ((this.lien.getEntiteRelation() instanceof IhmMCD2.IhmEntite2)) {
/*  59 */       this.jCBFleche.setEnabled(true);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private java.awt.Color choixDeCouleur(java.awt.Color color, String titre)
/*     */   {
/*  66 */     java.awt.Color col = javax.swing.JColorChooser.showDialog(this, titre, color);
/*  67 */     if (col == null) return color;
/*  68 */     return col;
/*     */   }
/*     */   
/*     */ 
/*     */   private void modifierPointDeCassure()
/*     */   {
/*  74 */     int nb = this.lien.getPointCassure().size();
/*  75 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/*  76 */     if (total > nb) {
/*  77 */       ajouterPointDeCassure();
/*  78 */       return;
/*     */     }
/*  80 */     if (total < nb) {
/*  81 */       supprimerPointDeCassure();
/*     */     }
/*     */   }
/*     */   
/*     */   private void ajouterPointDeCassure() {
/*  86 */     int nb = this.lien.getPointCassure().size();
/*  87 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/*     */     
/*  89 */     int x = 0;
/*  90 */     int y = 0;
/*  91 */     int dx = 10;int dy = 12;
/*     */     
/*     */ 
/*     */ 
/*  95 */     if (nb > 0) {
/*  96 */       x = ((IhmMCD2.IhmPoint)this.lien.getPointCassure().get(nb - 1)).getX();
/*  97 */       y = ((IhmMCD2.IhmPoint)this.lien.getPointCassure().get(nb - 1)).getY();
/*     */     }
/*     */     else {
/* 100 */       x = (this.lien.getEntiteRelation().getCentreX() + this.lien.getCif().getCentreX()) / 2;
/* 101 */       y = (this.lien.getEntiteRelation().getCentreY() + this.lien.getCif().getCentreY()) / 2;
/*     */     }
/*     */     
/* 104 */     for (int i = nb; i < total; i++) {
/* 105 */       IhmMCD2.IhmPoint p = new IhmMCD2.IhmPoint(x + dx, y + dy);
/* 106 */       x += dx;
/* 107 */       y += dy;
/* 108 */       this.lien.getPointCassure().add(p);
/*     */     }
/*     */   }
/*     */   
/*     */   private void supprimerPointDeCassure()
/*     */   {
/* 114 */     int nb = this.lien.getPointCassure().size();
/* 115 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/* 116 */     for (int i = nb; i > total; i--) {
/* 117 */       this.lien.getPointCassure().remove(i - 1);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void dessinerApercuEntite()
/*     */   {
/* 127 */     Graphics2D g = (Graphics2D)this.jPanelAprecu.getGraphics();
/* 128 */     g.setFont(new java.awt.Font("Tahoma", 1, 11));
/*     */     
/* 130 */     String nom = this.jTFNom.getText().trim().length() == 0 ? "NomLien" : this.jTFNom.getText().trim();
/* 131 */     String nomEntite = this.lien == null ? "Entite" : ((IhmMCD2.IhmEntite2)this.lien.getEntiteRelation()).getEntite().getNom();
/*     */     
/* 133 */     nomEntite = nomEntite.substring(0, nomEntite.length() < 15 ? nomEntite.length() : 15);
/* 134 */     nom = nom.substring(0, nom.length() < 10 ? nom.length() : 10);
/*     */     
/* 136 */     int wNom = g.getFontMetrics().stringWidth(nomEntite);
/* 137 */     g.setColor(java.awt.Color.WHITE);
/*     */     
/* 139 */     g.fillRect(0, 0, this.jPanelAprecu.getWidth(), this.jPanelAprecu.getHeight());
/*     */     
/*     */ 
/*     */ 
/* 143 */     int cifx = 10;
/* 144 */     int cify = 80;
/* 145 */     int cifw = 38;
/* 146 */     int cifh = 36;
/* 147 */     java.awt.geom.RoundRectangle2D rCif = new java.awt.geom.RoundRectangle2D.Double(cifx, cify, cifw, cifh, cifh, cifh);
/* 148 */     g.setColor(this.lien.getCif().getClFond2());
/* 149 */     g.fill(rCif);
/*     */     
/* 151 */     g.setColor(this.lien.getCif().getClCadre2());
/* 152 */     g.draw(rCif);
/*     */     
/* 154 */     g.setColor(this.lien.getCif().getClText2());
/* 155 */     int tail = g.getFontMetrics().stringWidth("C I F");
/* 156 */     g.drawString("C I F", cifx + 3 + (cifw - tail) / 2, cify + cifh - 14);
/*     */     
/*     */ 
/* 159 */     g.setColor(((IhmMCD2.IhmEntite2)this.lien.getEntiteRelation()).getClFond2());
/* 160 */     java.awt.geom.RoundRectangle2D rRectT = new java.awt.geom.RoundRectangle2D.Double(160.0D, 40.0D, 100.0D, 100.0D, 0.0D, 0.0D);
/* 161 */     g.fill(rRectT);
/* 162 */     g.setColor(java.awt.Color.BLACK);
/* 163 */     g.draw(rRectT);
/*     */     
/* 165 */     g.drawLine(160, 60, 260, 60);
/* 166 */     g.drawString(nomEntite, 160 + (100 - wNom) / 2, 57);
/*     */     
/*     */ 
/*     */ 
/* 170 */     g.setColor(this.jLabFond.getBackground());
/* 171 */     g.drawLine(48, 98, 160, 98);
/*     */     
/*     */ 
/* 174 */     if (this.jCBFleche.isSelected()) {
/* 175 */       int[] xtab = { 160, 157, 157 };
/* 176 */       int[] ytab = { 98, 95, 101 };
/* 177 */       g.fillPolygon(xtab, ytab, 3);
/*     */     }
/*     */     
/*     */ 
/* 181 */     g.setColor(this.jLabNom.getBackground());
/* 182 */     g.drawString(nom, 58 + (80 - wNom) / 2, 95);
/*     */   }
/*     */   
/*     */   private void dessinerApercuRelation()
/*     */   {
/* 187 */     Graphics2D g = (Graphics2D)this.jPanelAprecu.getGraphics();
/* 188 */     g.setFont(new java.awt.Font("Tahoma", 1, 11));
/*     */     
/* 190 */     String nom = this.jTFNom.getText().trim().length() == 0 ? "NomLien" : this.jTFNom.getText().trim();
/* 191 */     String nomEntite = this.lien == null ? "Entite" : ((IhmMCD2.IhmRelation2)this.lien.getEntiteRelation()).getRelation().getNom();
/*     */     
/* 193 */     nomEntite = nomEntite.substring(0, nomEntite.length() < 15 ? nomEntite.length() : 15);
/* 194 */     nom = nom.substring(0, nom.length() < 10 ? nom.length() : 10);
/*     */     
/* 196 */     int wNom = g.getFontMetrics().stringWidth(nomEntite);
/* 197 */     g.setColor(java.awt.Color.WHITE);
/*     */     
/* 199 */     g.fillRect(0, 0, this.jPanelAprecu.getWidth(), this.jPanelAprecu.getHeight());
/*     */     
/*     */ 
/*     */ 
/* 203 */     int cifx = 10;
/* 204 */     int cify = 80;
/* 205 */     int cifw = 38;
/* 206 */     int cifh = 36;
/* 207 */     java.awt.geom.RoundRectangle2D rCif = new java.awt.geom.RoundRectangle2D.Double(cifx, cify, cifw, cifh, cifh, cifh);
/* 208 */     g.setColor(this.lien.getCif().getClFond2());
/* 209 */     g.fill(rCif);
/*     */     
/* 211 */     g.setColor(this.lien.getCif().getClCadre2());
/* 212 */     g.draw(rCif);
/*     */     
/* 214 */     g.setColor(this.lien.getCif().getClText2());
/* 215 */     int tail = g.getFontMetrics().stringWidth("C I F");
/* 216 */     g.drawString("C I F", cifx + 3 + (cifw - tail) / 2, cify + cifh - 14);
/*     */     
/*     */ 
/* 219 */     g.setColor(((IhmMCD2.IhmRelation2)this.lien.getEntiteRelation()).getClFond2());
/* 220 */     java.awt.geom.RoundRectangle2D rRectT = new java.awt.geom.RoundRectangle2D.Double(160.0D, 70.0D, 100.0D, 56.0D, 50.0D, 50.0D);
/* 221 */     g.fill(rRectT);
/* 222 */     g.setColor(java.awt.Color.BLACK);
/* 223 */     g.draw(rRectT);
/*     */     
/* 225 */     g.drawLine(160, 98, 260, 98);
/* 226 */     g.drawString(nomEntite, 160 + (100 - wNom) / 2, 95);
/*     */     
/*     */ 
/*     */ 
/* 230 */     g.setColor(this.jLabFond.getBackground());
/* 231 */     g.drawLine(48, 98, 160, 98);
/*     */     
/*     */ 
/* 234 */     if (this.jCBFleche.isSelected()) {
/* 235 */       int[] xtab = { 160, 155, 155 };
/* 236 */       int[] ytab = { 98, 94, 102 };
/* 237 */       g.fillPolygon(xtab, ytab, 3);
/*     */     }
/*     */     
/*     */ 
/* 241 */     g.setColor(this.jLabNom.getBackground());
/* 242 */     g.drawString(nom, 58 + (80 - wNom) / 2, 95);
/*     */   }
/*     */   
/*     */   private void dessinerApercu() {
/* 246 */     if ((this.lien.getEntiteRelation() instanceof IhmMCD2.IhmRelation2)) {
/* 247 */       dessinerApercuRelation();
/*     */     }
/*     */     
/* 250 */     if ((this.lien.getEntiteRelation() instanceof IhmMCD2.IhmEntite2)) {
/* 251 */       dessinerApercuEntite();
/*     */     }
/*     */   }
/*     */   
/*     */   private void appliquerCoulerDefaut()
/*     */   {
/* 257 */     ihm.FormeInterneMCD.clLienCIF2 = this.jLabFond.getBackground();
/* 258 */     ihm.FormeInterneMCD.clLienNomCIF2 = this.jLabNom.getBackground();
/*     */   }
/*     */   
/*     */   private void appliquerCoulerToutLien() {
/* 262 */     java.util.ArrayList<IhmMCD.IhmLienCif> liste = this.frm.getPage().getListelienCIF();
/*     */     
/* 264 */     for (int i = 0; i < liste.size(); i++) {
/* 265 */       IhmLienCIF2 l = (IhmLienCIF2)liste.get(i);
/* 266 */       l.setClLienCIF2(this.jLabFond.getBackground());
/* 267 */       l.setClLienNomCIF2(this.jLabNom.getBackground());
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
/* 281 */     this.jLabel1 = new JLabel();
/* 282 */     this.jTFNom = new javax.swing.JTextField();
/* 283 */     this.jTabbedPane1 = new javax.swing.JTabbedPane();
/* 284 */     this.jPanel1 = new javax.swing.JPanel();
/* 285 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 286 */     this.jTACommentaire = new javax.swing.JTextPane();
/* 287 */     this.jBtHsitorique = new javax.swing.JButton();
/* 288 */     this.jPanel2 = new javax.swing.JPanel();
/* 289 */     this.jPanel4 = new javax.swing.JPanel();
/* 290 */     this.jLabFond = new JLabel();
/* 291 */     this.jLabel12 = new JLabel();
/* 292 */     this.jLabel15 = new JLabel();
/* 293 */     this.jLabNom = new JLabel();
/* 294 */     this.jPanelAprecu = new javax.swing.JPanel();
/* 295 */     this.jLabel14 = new JLabel();
/* 296 */     this.jLabel9 = new JLabel();
/* 297 */     this.jCBTout = new javax.swing.JCheckBox();
/* 298 */     this.jCBDefaut = new javax.swing.JCheckBox();
/* 299 */     this.jCBFleche = new javax.swing.JCheckBox();
/* 300 */     this.jSpNBCassure = new javax.swing.JSpinner();
/* 301 */     this.jBtAnnuler = new javax.swing.JButton();
/* 302 */     this.jBtOK = new javax.swing.JButton();
/*     */     
/* 304 */     setDefaultCloseOperation(2);
/* 305 */     setTitle("Propriétés lien CIF");
/* 306 */     setResizable(false);
/*     */     
/* 308 */     this.jLabel1.setText("Nom lien ");
/*     */     
/* 310 */     this.jTFNom.setEnabled(false);
/* 311 */     this.jTFNom.addFocusListener(new java.awt.event.FocusAdapter() {
/*     */       public void focusLost(java.awt.event.FocusEvent evt) {
/* 313 */         FormeLienCif2.this.jTFNomFocusLost(evt);
/*     */       }
/*     */       
/* 316 */     });
/* 317 */     this.jScrollPane1.setViewportView(this.jTACommentaire);
/*     */     
/* 319 */     this.jBtHsitorique.setText("Historique...");
/* 320 */     this.jBtHsitorique.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 322 */         FormeLienCif2.this.jBtHsitoriqueActionPerformed(evt);
/*     */       }
/*     */       
/* 325 */     });
/* 326 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 327 */     this.jPanel1.setLayout(jPanel1Layout);
/* 328 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 547, 32767).addComponent(this.jBtHsitorique)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 337 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 211, 32767).addGap(18, 18, 18).addComponent(this.jBtHsitorique).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 347 */     this.jTabbedPane1.addTab("Commeantaire", this.jPanel1);
/*     */     
/* 349 */     this.jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
/*     */       public void componentShown(java.awt.event.ComponentEvent evt) {
/* 351 */         FormeLienCif2.this.jPanel2ComponentShown(evt);
/*     */       }
/*     */       
/* 354 */     });
/* 355 */     this.jLabFond.setBackground(new java.awt.Color(0, 0, 0));
/* 356 */     this.jLabFond.setHorizontalAlignment(0);
/* 357 */     this.jLabFond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 358 */     this.jLabFond.setCursor(new java.awt.Cursor(12));
/* 359 */     this.jLabFond.setOpaque(true);
/* 360 */     this.jLabFond.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 362 */         FormeLienCif2.this.jLabFondMouseClicked(evt);
/*     */       }
/*     */       
/* 365 */     });
/* 366 */     this.jLabel12.setHorizontalAlignment(0);
/* 367 */     this.jLabel12.setText("Trait");
/*     */     
/* 369 */     this.jLabel15.setHorizontalAlignment(0);
/* 370 */     this.jLabel15.setText("Nom");
/*     */     
/* 372 */     this.jLabNom.setBackground(new java.awt.Color(255, 51, 0));
/* 373 */     this.jLabNom.setHorizontalAlignment(0);
/* 374 */     this.jLabNom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 375 */     this.jLabNom.setCursor(new java.awt.Cursor(12));
/* 376 */     this.jLabNom.setOpaque(true);
/* 377 */     this.jLabNom.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 379 */         FormeLienCif2.this.jLabNomMouseClicked(evt);
/*     */       }
/*     */       
/* 382 */     });
/* 383 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 384 */     this.jPanel4.setLayout(jPanel4Layout);
/* 385 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel12).addComponent(this.jLabel15)).addGap(54, 54, 54).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabFond, -1, 55, 32767).addComponent(this.jLabNom, -1, 55, 32767)).addGap(62, 62, 62)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 398 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addGap(16, 16, 16).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(this.jLabFond, -1, -1, 32767).addComponent(this.jLabel12, -1, -1, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jLabNom, -1, 14, 32767).addComponent(this.jLabel15)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 412 */     this.jPanelAprecu.setBackground(new java.awt.Color(255, 255, 255));
/* 413 */     this.jPanelAprecu.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 415 */         FormeLienCif2.this.jPanelAprecuMouseClicked(evt);
/*     */       }
/*     */       
/* 418 */     });
/* 419 */     GroupLayout jPanelAprecuLayout = new GroupLayout(this.jPanelAprecu);
/* 420 */     this.jPanelAprecu.setLayout(jPanelAprecuLayout);
/* 421 */     jPanelAprecuLayout.setHorizontalGroup(jPanelAprecuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 264, 32767));
/*     */     
/*     */ 
/*     */ 
/* 425 */     jPanelAprecuLayout.setVerticalGroup(jPanelAprecuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 177, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 430 */     this.jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 431 */     this.jLabel14.setForeground(new java.awt.Color(0, 0, 153));
/* 432 */     this.jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/oeil.png")));
/* 433 */     this.jLabel14.setText("Aperçu");
/* 434 */     this.jLabel14.setCursor(new java.awt.Cursor(12));
/* 435 */     this.jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 437 */         FormeLienCif2.this.jLabel14MouseClicked(evt);
/*     */       }
/*     */       
/* 440 */     });
/* 441 */     this.jLabel9.setText("Points de cassure ");
/*     */     
/* 443 */     this.jCBTout.setText("Appliquer ces couleurs à tous les liens CIFs");
/*     */     
/* 445 */     this.jCBDefaut.setText("Couleurs par défaut");
/*     */     
/* 447 */     this.jCBFleche.setText("Cible");
/*     */     
/* 449 */     this.jSpNBCassure.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
/*     */     
/* 451 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 452 */     this.jPanel2.setLayout(jPanel2Layout);
/* 453 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jCBFleche).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, 32767).addComponent(this.jLabel14).addGap(104, 104, 104)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jCBTout).addContainerGap()).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jCBDefaut).addGap(131, 131, 131)).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel9).addGap(18, 18, 18).addComponent(this.jSpNBCassure, -1, 98, 32767)).addComponent(this.jPanel4, javax.swing.GroupLayout.Alignment.LEADING, -2, -1, -2)).addContainerGap(354, 32767)))).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(293, 32767).addComponent(this.jPanelAprecu, -2, -1, -2).addContainerGap())));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 483 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel4, -2, -1, -2).addGap(35, 35, 35).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.jSpNBCassure, -2, 28, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, 32767).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jCBFleche).addGap(18, 18, 18).addComponent(this.jCBTout)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel14).addGap(18, 18, 18).addComponent(this.jCBDefaut))).addContainerGap()).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanelAprecu, -2, -1, -2).addContainerGap(86, 32767))));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 510 */     this.jTabbedPane1.addTab("Affichage", this.jPanel2);
/*     */     
/* 512 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 513 */     this.jBtAnnuler.setText("Annuler");
/* 514 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 516 */         FormeLienCif2.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 519 */     });
/* 520 */     this.jBtOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 521 */     this.jBtOK.setText("Valider");
/* 522 */     this.jBtOK.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 524 */         FormeLienCif2.this.jBtOKActionPerformed(evt);
/*     */       }
/*     */       
/* 527 */     });
/* 528 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 529 */     getContentPane().setLayout(layout);
/* 530 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, -1, 572, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jTFNom, -1, 511, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.jBtAnnuler).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtOK, -2, 111, -2))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 546 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFNom, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTabbedPane1, -1, 302, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jBtOK).addComponent(this.jBtAnnuler)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 562 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtHsitoriqueActionPerformed(java.awt.event.ActionEvent evt) {
/* 566 */     new FormeHistorique(this.frm, true, this.lien.getHistorique(), "", "").setVisible(true);
/*     */   }
/*     */   
/*     */   private void jLabFondMouseClicked(java.awt.event.MouseEvent evt) {
/* 570 */     this.jLabFond.setBackground(choixDeCouleur(this.jLabFond.getBackground(), "Couleur Cadre"));
/* 571 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabNomMouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 576 */     this.jLabNom.setBackground(choixDeCouleur(this.jLabNom.getBackground(), "Couleur Fond"));
/* 577 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jPanelAprecuMouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 582 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabel14MouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 587 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 592 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtOKActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 597 */     this.lien.setNom(this.jTFNom.getText().trim());
/* 598 */     this.lien.setCode(this.jTFNom.getText().trim().toUpperCase());
/* 599 */     this.lien.setCommentaire(this.jTACommentaire.getText());
/*     */     
/* 601 */     this.lien.setFleche(this.jCBFleche.isSelected());
/*     */     
/* 603 */     this.lien.setClLienCIF2(this.jLabFond.getBackground());
/* 604 */     this.lien.setClLienNomCIF2(this.jLabNom.getBackground());
/*     */     
/* 606 */     this.lien.ajouterModification();
/* 607 */     if (this.jCBDefaut.isSelected()) {
/* 608 */       appliquerCoulerDefaut();
/*     */     }
/* 610 */     if (this.jCBTout.isSelected()) {
/* 611 */       appliquerCoulerToutLien();
/*     */     }
/* 613 */     modifierPointDeCassure();
/* 614 */     dispose();
/*     */   }
/*     */   
/*     */   private void jTFNomFocusLost(java.awt.event.FocusEvent evt) {
/* 618 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {
/* 622 */     dessinerApercu();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeLienCif2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */