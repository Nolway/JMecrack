/*     */ package formes2;
/*     */ 
/*     */ import IhmMCD2.IhmLienContraintes2;
/*     */ import java.awt.Graphics2D;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class FormeLienContraintes2 extends javax.swing.JDialog
/*     */ {
/*     */   ihm.Principale frm;
/*     */   IhmLienContraintes2 lien;
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
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel4;
/*     */   private JPanel jPanelAprecu;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JSpinner jSpNBCassure;
/*     */   private javax.swing.JTextPane jTACommentaire;
/*     */   private javax.swing.JTextField jTFNom;
/*     */   private javax.swing.JTabbedPane jTabbedPane1;
/*     */   
/*     */   public FormeLienContraintes2(ihm.Principale parent, boolean modal, IhmLienContraintes2 lien)
/*     */   {
/*  41 */     super(parent, modal);
/*  42 */     this.frm = parent;
/*  43 */     this.lien = lien;
/*  44 */     initComponents();
/*  45 */     setLocation(this.frm.getX() + 290, this.frm.getY() + 120);
/*  46 */     initData();
/*  47 */     this.jBtAnnuler.setMnemonic(65);
/*  48 */     this.jBtOK.setMnemonic(10);
/*     */   }
/*     */   
/*     */   private void initData() {
/*  52 */     this.jTFNom.setText(this.lien.getNom());
/*  53 */     this.jLabFond.setBackground(this.lien.getClLienContrainte2());
/*  54 */     this.jLabNom.setBackground(this.lien.getClLienNomContrainte2());
/*  55 */     this.jSpNBCassure.setValue(Integer.valueOf(this.lien.getPointCassure().size()));
/*  56 */     this.jCBFleche.setSelected(this.lien.isCible());
/*  57 */     this.jTACommentaire.setText(this.lien.getCommentaire());
/*  58 */     activerDirection();
/*     */   }
/*     */   
/*     */   private void activerDirection()
/*     */   {
/*  63 */     this.jCBFleche.setEnabled(false);
/*  64 */     if ((this.lien.getEntiteRelation() instanceof IhmMCD2.IhmRelation2))
/*     */     {
/*  66 */       this.jCBFleche.setEnabled(true);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private java.awt.Color choixDeCouleur(java.awt.Color color, String titre)
/*     */   {
/*  73 */     java.awt.Color col = javax.swing.JColorChooser.showDialog(this, titre, color);
/*  74 */     if (col == null) return color;
/*  75 */     return col;
/*     */   }
/*     */   
/*     */ 
/*     */   private void modifierPointDeCassure()
/*     */   {
/*  81 */     int nb = this.lien.getPointCassure().size();
/*  82 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/*  83 */     if (total > nb) {
/*  84 */       ajouterPointDeCassure();
/*  85 */       return;
/*     */     }
/*  87 */     if (total < nb) {
/*  88 */       supprimerPointDeCassure();
/*     */     }
/*     */   }
/*     */   
/*     */   private void ajouterPointDeCassure() {
/*  93 */     int nb = this.lien.getPointCassure().size();
/*  94 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/*     */     
/*  96 */     int x = 0;
/*  97 */     int y = 0;
/*  98 */     int dx = 10;int dy = 12;
/*     */     
/*     */ 
/*     */ 
/* 102 */     if (nb > 0) {
/* 103 */       x = ((IhmMCD2.IhmPoint)this.lien.getPointCassure().get(nb - 1)).getX();
/* 104 */       y = ((IhmMCD2.IhmPoint)this.lien.getPointCassure().get(nb - 1)).getY();
/*     */     }
/*     */     else {
/* 107 */       x = (this.lien.getEntiteRelation().getCentreX() + this.lien.getContrainte().getCentreX()) / 2;
/* 108 */       y = (this.lien.getEntiteRelation().getCentreY() + this.lien.getContrainte().getCentreY()) / 2;
/*     */     }
/*     */     
/* 111 */     for (int i = nb; i < total; i++) {
/* 112 */       IhmMCD2.IhmPoint p = new IhmMCD2.IhmPoint(x + dx, y + dy);
/* 113 */       x += dx;
/* 114 */       y += dy;
/* 115 */       this.lien.getPointCassure().add(p);
/*     */     }
/*     */   }
/*     */   
/*     */   private void supprimerPointDeCassure()
/*     */   {
/* 121 */     int nb = this.lien.getPointCassure().size();
/* 122 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/* 123 */     for (int i = nb; i > total; i--) {
/* 124 */       this.lien.getPointCassure().remove(i - 1);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void dessinerApercuEntite()
/*     */   {
/* 133 */     Graphics2D g = (Graphics2D)this.jPanelAprecu.getGraphics();
/* 134 */     g.setFont(new java.awt.Font("Tahoma", 1, 11));
/*     */     
/* 136 */     String nom = this.jTFNom.getText().trim().length() == 0 ? "NomLien" : this.jTFNom.getText().trim();
/* 137 */     String nomEntite = this.lien == null ? "Entite" : ((IhmMCD2.IhmEntite2)this.lien.getEntiteRelation()).getEntite().getNom();
/*     */     
/* 139 */     nomEntite = nomEntite.substring(0, nomEntite.length() < 15 ? nomEntite.length() : 15);
/* 140 */     nom = nom.substring(0, nom.length() < 10 ? nom.length() : 10);
/*     */     
/* 142 */     int wNom = g.getFontMetrics().stringWidth(nomEntite);
/* 143 */     g.setColor(java.awt.Color.WHITE);
/*     */     
/* 145 */     g.fillRect(0, 0, this.jPanelAprecu.getWidth(), this.jPanelAprecu.getHeight());
/*     */     
/*     */ 
/*     */ 
/* 149 */     int cifx = 10;
/* 150 */     int cify = 80;
/* 151 */     int cifw = 38;
/* 152 */     int cifh = 36;
/* 153 */     java.awt.geom.RoundRectangle2D rCif = new java.awt.geom.RoundRectangle2D.Double(cifx, cify, cifw, cifh, cifh, cifh);
/* 154 */     g.setColor(((IhmMCD2.IhmContrainte2)this.lien.getContrainte()).getClFond2());
/* 155 */     g.fill(rCif);
/*     */     
/* 157 */     g.setColor(((IhmMCD2.IhmContrainte2)this.lien.getContrainte()).getClCadre2());
/* 158 */     g.draw(rCif);
/*     */     
/* 160 */     g.setColor(((IhmMCD2.IhmContrainte2)this.lien.getContrainte()).getClText2());
/* 161 */     String ncnt = ((IhmMCD2.IhmContrainte2)this.lien.getContrainte()).getNom();
/* 162 */     int tail = g.getFontMetrics().stringWidth(ncnt);
/* 163 */     g.drawString(ncnt, cifx + 3 + (cifw - tail) / 2, cify + cifh - 14);
/*     */     
/*     */ 
/* 166 */     g.setColor(((IhmMCD2.IhmEntite2)this.lien.getEntiteRelation()).getClFond2());
/* 167 */     java.awt.geom.RoundRectangle2D rRectT = new java.awt.geom.RoundRectangle2D.Double(160.0D, 40.0D, 100.0D, 100.0D, 0.0D, 0.0D);
/* 168 */     g.fill(rRectT);
/* 169 */     g.setColor(java.awt.Color.BLACK);
/* 170 */     g.draw(rRectT);
/*     */     
/* 172 */     g.drawLine(160, 60, 260, 60);
/* 173 */     g.drawString(nomEntite, 160 + (100 - wNom) / 2, 57);
/*     */     
/*     */ 
/*     */ 
/* 177 */     g.setColor(this.jLabFond.getBackground());
/* 178 */     g.drawLine(48, 98, 160, 98);
/*     */     
/*     */ 
/* 181 */     if (this.jCBFleche.isSelected()) {
/* 182 */       int[] xtab = { 160, 157, 157 };
/* 183 */       int[] ytab = { 98, 95, 101 };
/* 184 */       g.fillPolygon(xtab, ytab, 3);
/*     */     }
/*     */     
/*     */ 
/* 188 */     g.setColor(this.jLabNom.getBackground());
/* 189 */     g.drawString(nom, 58 + (80 - wNom) / 2, 95);
/*     */   }
/*     */   
/*     */   private void dessinerApercuRelation()
/*     */   {
/* 194 */     Graphics2D g = (Graphics2D)this.jPanelAprecu.getGraphics();
/* 195 */     g.setFont(new java.awt.Font("Tahoma", 1, 11));
/*     */     
/* 197 */     String nom = this.jTFNom.getText().trim().length() == 0 ? "NomLien" : this.jTFNom.getText().trim();
/* 198 */     String nomEntite = this.lien == null ? "Entite" : ((IhmMCD2.IhmRelation2)this.lien.getEntiteRelation()).getRelation().getNom();
/*     */     
/* 200 */     nomEntite = nomEntite.substring(0, nomEntite.length() < 15 ? nomEntite.length() : 15);
/* 201 */     nom = nom.substring(0, nom.length() < 10 ? nom.length() : 10);
/*     */     
/* 203 */     int wNom = g.getFontMetrics().stringWidth(nomEntite);
/* 204 */     g.setColor(java.awt.Color.WHITE);
/*     */     
/* 206 */     g.fillRect(0, 0, this.jPanelAprecu.getWidth(), this.jPanelAprecu.getHeight());
/*     */     
/*     */ 
/*     */ 
/* 210 */     int cifx = 10;
/* 211 */     int cify = 80;
/* 212 */     int cifw = 38;
/* 213 */     int cifh = 36;
/* 214 */     java.awt.geom.RoundRectangle2D rCif = new java.awt.geom.RoundRectangle2D.Double(cifx, cify, cifw, cifh, cifh, cifh);
/* 215 */     g.setColor(((IhmMCD2.IhmContrainte2)this.lien.getContrainte()).getClFond2());
/* 216 */     g.fill(rCif);
/*     */     
/* 218 */     g.setColor(((IhmMCD2.IhmContrainte2)this.lien.getContrainte()).getClCadre2());
/* 219 */     g.draw(rCif);
/*     */     
/* 221 */     g.setColor(((IhmMCD2.IhmContrainte2)this.lien.getContrainte()).getClText2());
/* 222 */     String ncnt = ((IhmMCD2.IhmContrainte2)this.lien.getContrainte()).getNom();
/* 223 */     int tail = g.getFontMetrics().stringWidth(ncnt);
/* 224 */     g.drawString(ncnt, cifx + 3 + (cifw - tail) / 2, cify + cifh - 14);
/*     */     
/*     */ 
/* 227 */     g.setColor(((IhmMCD2.IhmRelation2)this.lien.getEntiteRelation()).getClFond2());
/* 228 */     java.awt.geom.RoundRectangle2D rRectT = new java.awt.geom.RoundRectangle2D.Double(160.0D, 70.0D, 100.0D, 56.0D, 50.0D, 50.0D);
/* 229 */     g.fill(rRectT);
/* 230 */     g.setColor(java.awt.Color.BLACK);
/* 231 */     g.draw(rRectT);
/*     */     
/* 233 */     g.drawLine(160, 98, 260, 98);
/* 234 */     g.drawString(nomEntite, 160 + (100 - wNom) / 2, 95);
/*     */     
/*     */ 
/*     */ 
/* 238 */     g.setColor(this.jLabFond.getBackground());
/* 239 */     g.drawLine(48, 98, 160, 98);
/*     */     
/*     */ 
/* 242 */     if (this.jCBFleche.isSelected()) {
/* 243 */       int[] xtab = { 160, 155, 155 };
/* 244 */       int[] ytab = { 98, 94, 102 };
/* 245 */       g.fillPolygon(xtab, ytab, 3);
/*     */     }
/*     */     
/*     */ 
/* 249 */     g.setColor(this.jLabNom.getBackground());
/* 250 */     g.drawString(nom, 58 + (80 - wNom) / 2, 95);
/*     */   }
/*     */   
/*     */   private void dessinerApercu() {
/* 254 */     if ((this.lien.getEntiteRelation() instanceof IhmMCD2.IhmRelation2)) {
/* 255 */       dessinerApercuRelation();
/*     */     }
/*     */     
/* 258 */     if ((this.lien.getEntiteRelation() instanceof IhmMCD2.IhmEntite2)) {
/* 259 */       dessinerApercuEntite();
/*     */     }
/*     */   }
/*     */   
/*     */   private void appliquerCoulerDefaut()
/*     */   {
/* 265 */     ihm.FormeInterneMCD.clLienContrainte2 = this.jLabFond.getBackground();
/* 266 */     ihm.FormeInterneMCD.clLienNomContrainte2 = this.jLabNom.getBackground();
/*     */   }
/*     */   
/*     */   private void appliquerCoulerToutLien() {
/* 270 */     java.util.ArrayList<IhmMCD.IhmLienContraintes> liste = this.frm.getPage().getListeLienContrainte();
/*     */     
/* 272 */     for (int i = 0; i < liste.size(); i++) {
/* 273 */       IhmLienContraintes2 l = (IhmLienContraintes2)liste.get(i);
/* 274 */       l.setClLienContrainte2(this.jLabFond.getBackground());
/* 275 */       l.setClLienNomContrainte2(this.jLabNom.getBackground());
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
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 291 */     this.jTFNom = new javax.swing.JTextField();
/* 292 */     this.jTabbedPane1 = new javax.swing.JTabbedPane();
/* 293 */     this.jPanel1 = new JPanel();
/* 294 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 295 */     this.jTACommentaire = new javax.swing.JTextPane();
/* 296 */     this.jBtHsitorique = new javax.swing.JButton();
/* 297 */     this.jPanel2 = new JPanel();
/* 298 */     this.jPanel4 = new JPanel();
/* 299 */     this.jLabFond = new JLabel();
/* 300 */     this.jLabel12 = new JLabel();
/* 301 */     this.jLabel15 = new JLabel();
/* 302 */     this.jLabNom = new JLabel();
/* 303 */     this.jPanelAprecu = new JPanel();
/* 304 */     this.jLabel14 = new JLabel();
/* 305 */     this.jLabel9 = new JLabel();
/* 306 */     this.jCBTout = new javax.swing.JCheckBox();
/* 307 */     this.jCBDefaut = new javax.swing.JCheckBox();
/* 308 */     this.jCBFleche = new javax.swing.JCheckBox();
/* 309 */     this.jSpNBCassure = new javax.swing.JSpinner();
/* 310 */     this.jBtAnnuler = new javax.swing.JButton();
/* 311 */     this.jBtOK = new javax.swing.JButton();
/* 312 */     this.jLabel1 = new JLabel();
/*     */     
/* 314 */     setDefaultCloseOperation(2);
/* 315 */     setTitle("Propriété du lien de la contrainte");
/*     */     
/* 317 */     this.jTFNom.setEnabled(false);
/* 318 */     this.jTFNom.addFocusListener(new java.awt.event.FocusAdapter() {
/*     */       public void focusLost(java.awt.event.FocusEvent evt) {
/* 320 */         FormeLienContraintes2.this.jTFNomFocusLost(evt);
/*     */       }
/*     */       
/* 323 */     });
/* 324 */     this.jScrollPane1.setViewportView(this.jTACommentaire);
/*     */     
/* 326 */     this.jBtHsitorique.setText("Historique...");
/* 327 */     this.jBtHsitorique.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 329 */         FormeLienContraintes2.this.jBtHsitoriqueActionPerformed(evt);
/*     */       }
/*     */       
/* 332 */     });
/* 333 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 334 */     this.jPanel1.setLayout(jPanel1Layout);
/* 335 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 527, 32767).addComponent(this.jBtHsitorique)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 344 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 194, 32767).addGap(18, 18, 18).addComponent(this.jBtHsitorique).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 354 */     this.jTabbedPane1.addTab("Commeantaire", this.jPanel1);
/*     */     
/* 356 */     this.jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
/*     */       public void componentShown(java.awt.event.ComponentEvent evt) {
/* 358 */         FormeLienContraintes2.this.jPanel2ComponentShown(evt);
/*     */       }
/*     */       
/* 361 */     });
/* 362 */     this.jLabFond.setBackground(new java.awt.Color(0, 0, 0));
/* 363 */     this.jLabFond.setHorizontalAlignment(0);
/* 364 */     this.jLabFond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 365 */     this.jLabFond.setCursor(new java.awt.Cursor(12));
/* 366 */     this.jLabFond.setOpaque(true);
/* 367 */     this.jLabFond.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 369 */         FormeLienContraintes2.this.jLabFondMouseClicked(evt);
/*     */       }
/*     */       
/* 372 */     });
/* 373 */     this.jLabel12.setHorizontalAlignment(0);
/* 374 */     this.jLabel12.setText("Trait");
/*     */     
/* 376 */     this.jLabel15.setHorizontalAlignment(0);
/* 377 */     this.jLabel15.setText("Nom");
/*     */     
/* 379 */     this.jLabNom.setBackground(new java.awt.Color(255, 51, 0));
/* 380 */     this.jLabNom.setHorizontalAlignment(0);
/* 381 */     this.jLabNom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 382 */     this.jLabNom.setCursor(new java.awt.Cursor(12));
/* 383 */     this.jLabNom.setOpaque(true);
/* 384 */     this.jLabNom.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 386 */         FormeLienContraintes2.this.jLabNomMouseClicked(evt);
/*     */       }
/*     */       
/* 389 */     });
/* 390 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 391 */     this.jPanel4.setLayout(jPanel4Layout);
/* 392 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel12).addComponent(this.jLabel15)).addGap(54, 54, 54).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabFond, -1, 55, 32767).addComponent(this.jLabNom, -1, 55, 32767)).addGap(62, 62, 62)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 405 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addGap(16, 16, 16).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabFond, -1, -1, 32767).addComponent(this.jLabel12, -1, -1, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabNom, -1, 14, 32767).addComponent(this.jLabel15)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 419 */     this.jPanelAprecu.setBackground(new java.awt.Color(255, 255, 255));
/* 420 */     this.jPanelAprecu.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 422 */         FormeLienContraintes2.this.jPanelAprecuMouseClicked(evt);
/*     */       }
/*     */       
/* 425 */     });
/* 426 */     GroupLayout jPanelAprecuLayout = new GroupLayout(this.jPanelAprecu);
/* 427 */     this.jPanelAprecu.setLayout(jPanelAprecuLayout);
/* 428 */     jPanelAprecuLayout.setHorizontalGroup(jPanelAprecuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 293, 32767));
/*     */     
/*     */ 
/*     */ 
/* 432 */     jPanelAprecuLayout.setVerticalGroup(jPanelAprecuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 169, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 437 */     this.jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 438 */     this.jLabel14.setForeground(new java.awt.Color(0, 0, 153));
/* 439 */     this.jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/oeil.png")));
/* 440 */     this.jLabel14.setText("Aperçu");
/* 441 */     this.jLabel14.setCursor(new java.awt.Cursor(12));
/* 442 */     this.jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 444 */         FormeLienContraintes2.this.jLabel14MouseClicked(evt);
/*     */       }
/*     */       
/* 447 */     });
/* 448 */     this.jLabel9.setText("Points de cassure ");
/*     */     
/* 450 */     this.jCBTout.setText("Appliquer ces couleurs à tous les liens des contraintes");
/*     */     
/* 452 */     this.jCBDefaut.setText("Couleurs par défaut");
/*     */     
/* 454 */     this.jCBFleche.setText("Cible");
/*     */     
/* 456 */     this.jSpNBCassure.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
/*     */     
/* 458 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 459 */     this.jPanel2.setLayout(jPanel2Layout);
/* 460 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jCBTout).addGap(60, 60, 60).addComponent(this.jCBDefaut)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel9).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jSpNBCassure, -2, 57, -2)).addComponent(this.jPanel4, -2, -1, -2)).addContainerGap(73, 32767)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jCBFleche).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 325, 32767).addComponent(this.jLabel14).addGap(103, 103, 103)))).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(244, 32767).addComponent(this.jPanelAprecu, -2, -1, -2).addContainerGap())));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 488 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.jSpNBCassure, -2, 28, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBFleche).addComponent(this.jLabel14)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBTout).addComponent(this.jCBDefaut)).addContainerGap()).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanelAprecu, -2, -1, -2).addContainerGap(77, 32767))));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 513 */     this.jTabbedPane1.addTab("Affichage", this.jPanel2);
/*     */     
/* 515 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 516 */     this.jBtAnnuler.setText("Annuler");
/* 517 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 519 */         FormeLienContraintes2.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 522 */     });
/* 523 */     this.jBtOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 524 */     this.jBtOK.setText("Valider");
/* 525 */     this.jBtOK.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 527 */         FormeLienContraintes2.this.jBtOKActionPerformed(evt);
/*     */       }
/*     */       
/* 530 */     });
/* 531 */     this.jLabel1.setText("Nom lien ");
/*     */     
/* 533 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 534 */     getContentPane().setLayout(layout);
/* 535 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jTabbedPane1, GroupLayout.Alignment.LEADING, -1, 552, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jTFNom, -1, 491, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.jBtAnnuler).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtOK, -2, 109, -2))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 551 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFNom, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.jTabbedPane1, -1, 285, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtOK).addComponent(this.jBtAnnuler)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 567 */     pack();
/*     */   }
/*     */   
/*     */   private void jTFNomFocusLost(java.awt.event.FocusEvent evt) {
/* 571 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jBtHsitoriqueActionPerformed(java.awt.event.ActionEvent evt) {
/* 575 */     new FormeHistorique(this.frm, true, this.lien.getHistorique(), "", "").setVisible(true);
/*     */   }
/*     */   
/*     */   private void jLabFondMouseClicked(java.awt.event.MouseEvent evt) {
/* 579 */     this.jLabFond.setBackground(choixDeCouleur(this.jLabFond.getBackground(), "Couleur Cadre"));
/* 580 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabNomMouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 585 */     this.jLabNom.setBackground(choixDeCouleur(this.jLabNom.getBackground(), "Couleur Fond"));
/* 586 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jPanelAprecuMouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 591 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabel14MouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 596 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt)
/*     */   {
/* 601 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt) {
/* 605 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtOKActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 610 */     this.lien.setNom(this.jTFNom.getText().trim());
/* 611 */     this.lien.setCode(this.jTFNom.getText().trim().toUpperCase());
/* 612 */     this.lien.setCommentaire(this.jTACommentaire.getText());
/*     */     
/* 614 */     this.lien.setCible(this.jCBFleche.isSelected());
/*     */     
/* 616 */     this.lien.setClLienContrainte2(this.jLabFond.getBackground());
/* 617 */     this.lien.setClLienNomContrainte2(this.jLabNom.getBackground());
/*     */     
/* 619 */     this.lien.ajouterModification();
/* 620 */     if (this.jCBDefaut.isSelected()) {
/* 621 */       appliquerCoulerDefaut();
/*     */     }
/* 623 */     if (this.jCBTout.isSelected()) {
/* 624 */       appliquerCoulerToutLien();
/*     */     }
/* 626 */     modifierPointDeCassure();
/* 627 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeLienContraintes2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */