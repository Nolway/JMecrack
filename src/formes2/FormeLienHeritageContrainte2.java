/*     */ package formes2;
/*     */ 
/*     */ import IhmMCD2.IhmLienContrainteHeritage2;
/*     */ import java.awt.Graphics2D;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class FormeLienHeritageContrainte2 extends javax.swing.JDialog
/*     */ {
/*     */   ihm.Principale frm;
/*     */   IhmLienContrainteHeritage2 lien;
/*     */   private javax.swing.JButton jBtAnnuler;
/*     */   private javax.swing.JButton jBtHsitorique;
/*     */   private javax.swing.JButton jBtOK;
/*     */   private javax.swing.JCheckBox jCBDefaut;
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
/*     */   public FormeLienHeritageContrainte2(ihm.Principale parent, boolean modal, IhmLienContrainteHeritage2 lien)
/*     */   {
/*  39 */     super(parent, modal);
/*  40 */     initComponents();
/*  41 */     this.frm = parent;
/*  42 */     this.lien = lien;
/*     */     
/*  44 */     setLocation(this.frm.getX() + 290, this.frm.getY() + 120);
/*  45 */     initData();
/*  46 */     this.jBtAnnuler.setMnemonic(65);
/*  47 */     this.jBtOK.setMnemonic(10);
/*     */   }
/*     */   
/*     */   private void initData()
/*     */   {
/*  52 */     this.jTFNom.setText(this.lien.getNom());
/*  53 */     this.jLabFond.setBackground(this.lien.getClLienHeritage2());
/*  54 */     this.jLabNom.setBackground(this.lien.getClLienNomHeritage2());
/*  55 */     this.jSpNBCassure.setValue(Integer.valueOf(this.lien.getPointCassure().size()));
/*     */     
/*  57 */     this.jTACommentaire.setText(this.lien.getCommentaire());
/*     */   }
/*     */   
/*     */ 
/*     */   private java.awt.Color choixDeCouleur(java.awt.Color color, String titre)
/*     */   {
/*  63 */     java.awt.Color col = javax.swing.JColorChooser.showDialog(this, titre, color);
/*  64 */     if (col == null) return color;
/*  65 */     return col;
/*     */   }
/*     */   
/*     */ 
/*     */   private void modifierPointDeCassure()
/*     */   {
/*  71 */     int nb = this.lien.getPointCassure().size();
/*  72 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/*  73 */     if (total > nb) {
/*  74 */       ajouterPointDeCassure();
/*  75 */       return;
/*     */     }
/*  77 */     if (total < nb) {
/*  78 */       supprimerPointDeCassure();
/*     */     }
/*     */   }
/*     */   
/*     */   private void ajouterPointDeCassure() {
/*  83 */     int nb = this.lien.getPointCassure().size();
/*  84 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/*     */     
/*  86 */     int x = 0;
/*  87 */     int y = 0;
/*  88 */     int dx = 10;int dy = 12;
/*     */     
/*     */ 
/*     */ 
/*  92 */     if (nb > 0) {
/*  93 */       x = ((IhmMCD2.IhmPoint)this.lien.getPointCassure().get(nb - 1)).getX();
/*  94 */       y = ((IhmMCD2.IhmPoint)this.lien.getPointCassure().get(nb - 1)).getY();
/*     */     }
/*     */     else {
/*  97 */       x = (this.lien.getEntiteRelation().getCentreX() + this.lien.getHeritage().getCentreX()) / 2;
/*  98 */       y = (this.lien.getEntiteRelation().getCentreY() + this.lien.getHeritage().getCentreY()) / 2;
/*     */     }
/*     */     
/* 101 */     for (int i = nb; i < total; i++) {
/* 102 */       IhmMCD2.IhmPoint p = new IhmMCD2.IhmPoint(x + dx, y + dy);
/* 103 */       x += dx;
/* 104 */       y += dy;
/* 105 */       this.lien.getPointCassure().add(p);
/*     */     }
/*     */   }
/*     */   
/*     */   private void supprimerPointDeCassure()
/*     */   {
/* 111 */     int nb = this.lien.getPointCassure().size();
/* 112 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/* 113 */     for (int i = nb; i > total; i--) {
/* 114 */       this.lien.getPointCassure().remove(i - 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private void appliquerCoulerDefaut()
/*     */   {
/* 120 */     ihm.FormeInterneMCD.clLienHeritage2 = this.jLabFond.getBackground();
/* 121 */     ihm.FormeInterneMCD.clLienNomHeritage2 = this.jLabNom.getBackground();
/*     */   }
/*     */   
/*     */   private void appliquerCoulerToutLien() {
/* 125 */     java.util.ArrayList<IhmMCD.IhmLienContrainteHeritage> liste = this.frm.getPage().getListeLienContrainteHeritage();
/*     */     
/* 127 */     for (int i = 0; i < liste.size(); i++) {
/* 128 */       IhmLienContrainteHeritage2 l = (IhmLienContrainteHeritage2)liste.get(i);
/* 129 */       l.setClLienHeritage2(this.jLabFond.getBackground());
/* 130 */       l.setClLienNomHeritage2(this.jLabNom.getBackground());
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerApercu() {
/* 135 */     dessinerApercuEntite();
/*     */   }
/*     */   
/*     */   private void dessinerApercuEntite()
/*     */   {
/* 140 */     Graphics2D g = (Graphics2D)this.jPanelAprecu.getGraphics();
/* 141 */     g.setFont(new java.awt.Font("Tahoma", 1, 11));
/*     */     
/* 143 */     String nom = this.jTFNom.getText().trim().length() == 0 ? "NomLien" : this.jTFNom.getText().trim();
/* 144 */     String nomEntite = this.lien == null ? "Entite" : ((IhmMCD2.IhmEntite2)this.lien.getEntiteRelation()).getEntite().getNom();
/*     */     
/* 146 */     nomEntite = nomEntite.substring(0, nomEntite.length() < 15 ? nomEntite.length() : 15);
/* 147 */     nom = nom.substring(0, nom.length() < 10 ? nom.length() : 10);
/*     */     
/* 149 */     int wNom = g.getFontMetrics().stringWidth(nomEntite);
/* 150 */     g.setColor(java.awt.Color.WHITE);
/*     */     
/* 152 */     g.fillRect(0, 0, this.jPanelAprecu.getWidth(), this.jPanelAprecu.getHeight());
/*     */     
/*     */ 
/*     */ 
/* 156 */     int cifx = 6;
/* 157 */     int cify = 70;
/* 158 */     int cifw = 38;
/* 159 */     int cifh = 36;
/*     */     
/* 161 */     int[] x = { cifx + cifw / 2, cifx, cifx + cifw };
/* 162 */     int[] y = { cify, cify + cifh, cify + cifh };
/* 163 */     g.setColor(this.lien.getHeritage().getClFond2());
/* 164 */     g.fillPolygon(x, y, 3);
/* 165 */     g.setColor(this.lien.getHeritage().getClCadre2());
/* 166 */     g.drawPolygon(x, y, 3);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 174 */     g.setColor(this.lien.getHeritage().getClText2());
/* 175 */     String ncnt = this.lien.getHeritage().getNom();
/* 176 */     int tail = g.getFontMetrics().stringWidth(ncnt);
/* 177 */     g.drawString(ncnt, cifx + 3 + (cifw - tail) / 2, cify + cifh - 6);
/*     */     
/*     */ 
/* 180 */     g.setColor(((IhmMCD2.IhmEntite2)this.lien.getEntiteRelation()).getClFond2());
/* 181 */     java.awt.geom.RoundRectangle2D rRectT = new java.awt.geom.RoundRectangle2D.Double(160.0D, 40.0D, 100.0D, 100.0D, 0.0D, 0.0D);
/* 182 */     g.fill(rRectT);
/* 183 */     g.setColor(java.awt.Color.BLACK);
/* 184 */     g.draw(rRectT);
/*     */     
/* 186 */     g.drawLine(160, 60, 260, 60);
/* 187 */     g.drawString(nomEntite, 160 + (100 - wNom) / 2, 57);
/*     */     
/*     */ 
/*     */ 
/* 191 */     g.setColor(this.jLabFond.getBackground());
/* 192 */     g.drawLine(42, 98, 160, 98);
/*     */     
/*     */ 
/*     */ 
/* 196 */     int[] xtab = { 160, 157, 157 };
/* 197 */     int[] ytab = { 98, 95, 101 };
/* 198 */     g.fillPolygon(xtab, ytab, 3);
/*     */     
/*     */ 
/*     */ 
/* 202 */     g.setColor(this.jLabNom.getBackground());
/* 203 */     g.drawString(nom, 58 + (80 - wNom) / 2, 95);
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
/* 218 */     this.jTFNom = new javax.swing.JTextField();
/* 219 */     this.jLabel1 = new JLabel();
/* 220 */     this.jTabbedPane1 = new javax.swing.JTabbedPane();
/* 221 */     this.jPanel1 = new javax.swing.JPanel();
/* 222 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 223 */     this.jTACommentaire = new javax.swing.JTextPane();
/* 224 */     this.jBtHsitorique = new javax.swing.JButton();
/* 225 */     this.jPanel2 = new javax.swing.JPanel();
/* 226 */     this.jPanel4 = new javax.swing.JPanel();
/* 227 */     this.jLabFond = new JLabel();
/* 228 */     this.jLabel12 = new JLabel();
/* 229 */     this.jLabel15 = new JLabel();
/* 230 */     this.jLabNom = new JLabel();
/* 231 */     this.jPanelAprecu = new javax.swing.JPanel();
/* 232 */     this.jLabel14 = new JLabel();
/* 233 */     this.jLabel9 = new JLabel();
/* 234 */     this.jCBTout = new javax.swing.JCheckBox();
/* 235 */     this.jCBDefaut = new javax.swing.JCheckBox();
/* 236 */     this.jSpNBCassure = new javax.swing.JSpinner();
/* 237 */     this.jBtAnnuler = new javax.swing.JButton();
/* 238 */     this.jBtOK = new javax.swing.JButton();
/*     */     
/* 240 */     setDefaultCloseOperation(2);
/* 241 */     setTitle("Propriétés Lien Héritage");
/* 242 */     setResizable(false);
/*     */     
/* 244 */     this.jTFNom.addFocusListener(new java.awt.event.FocusAdapter() {
/*     */       public void focusLost(java.awt.event.FocusEvent evt) {
/* 246 */         FormeLienHeritageContrainte2.this.jTFNomFocusLost(evt);
/*     */       }
/*     */       
/* 249 */     });
/* 250 */     this.jLabel1.setText("Nom lien ");
/*     */     
/* 252 */     this.jScrollPane1.setViewportView(this.jTACommentaire);
/*     */     
/* 254 */     this.jBtHsitorique.setText("Historique...");
/* 255 */     this.jBtHsitorique.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 257 */         FormeLienHeritageContrainte2.this.jBtHsitoriqueActionPerformed(evt);
/*     */       }
/*     */       
/* 260 */     });
/* 261 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 262 */     this.jPanel1.setLayout(jPanel1Layout);
/* 263 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 520, 32767).addComponent(this.jBtHsitorique)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 272 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 181, 32767).addGap(18, 18, 18).addComponent(this.jBtHsitorique).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 282 */     this.jTabbedPane1.addTab("Commeantaire", this.jPanel1);
/*     */     
/* 284 */     this.jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
/*     */       public void componentShown(java.awt.event.ComponentEvent evt) {
/* 286 */         FormeLienHeritageContrainte2.this.jPanel2ComponentShown(evt);
/*     */       }
/*     */       
/* 289 */     });
/* 290 */     this.jLabFond.setBackground(new java.awt.Color(0, 0, 0));
/* 291 */     this.jLabFond.setHorizontalAlignment(0);
/* 292 */     this.jLabFond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 293 */     this.jLabFond.setCursor(new java.awt.Cursor(12));
/* 294 */     this.jLabFond.setOpaque(true);
/* 295 */     this.jLabFond.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 297 */         FormeLienHeritageContrainte2.this.jLabFondMouseClicked(evt);
/*     */       }
/*     */       
/* 300 */     });
/* 301 */     this.jLabel12.setHorizontalAlignment(0);
/* 302 */     this.jLabel12.setText("Trait");
/*     */     
/* 304 */     this.jLabel15.setHorizontalAlignment(0);
/* 305 */     this.jLabel15.setText("Nom");
/*     */     
/* 307 */     this.jLabNom.setBackground(new java.awt.Color(255, 51, 0));
/* 308 */     this.jLabNom.setHorizontalAlignment(0);
/* 309 */     this.jLabNom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 310 */     this.jLabNom.setCursor(new java.awt.Cursor(12));
/* 311 */     this.jLabNom.setOpaque(true);
/* 312 */     this.jLabNom.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 314 */         FormeLienHeritageContrainte2.this.jLabNomMouseClicked(evt);
/*     */       }
/*     */       
/* 317 */     });
/* 318 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 319 */     this.jPanel4.setLayout(jPanel4Layout);
/* 320 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel12).addComponent(this.jLabel15)).addGap(54, 54, 54).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabFond, -1, 55, 32767).addComponent(this.jLabNom, -1, 55, 32767)).addGap(62, 62, 62)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 333 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addGap(16, 16, 16).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabFond, -1, -1, 32767).addComponent(this.jLabel12, -1, -1, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, 32767).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabNom, -1, 14, 32767).addComponent(this.jLabel15)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 347 */     this.jPanelAprecu.setBackground(new java.awt.Color(255, 255, 255));
/* 348 */     this.jPanelAprecu.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 350 */         FormeLienHeritageContrainte2.this.jPanelAprecuMouseClicked(evt);
/*     */       }
/*     */       
/* 353 */     });
/* 354 */     GroupLayout jPanelAprecuLayout = new GroupLayout(this.jPanelAprecu);
/* 355 */     this.jPanelAprecu.setLayout(jPanelAprecuLayout);
/* 356 */     jPanelAprecuLayout.setHorizontalGroup(jPanelAprecuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 291, 32767));
/*     */     
/*     */ 
/*     */ 
/* 360 */     jPanelAprecuLayout.setVerticalGroup(jPanelAprecuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 162, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 365 */     this.jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 366 */     this.jLabel14.setForeground(new java.awt.Color(0, 0, 153));
/* 367 */     this.jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/oeil.png")));
/* 368 */     this.jLabel14.setText("Aperçu");
/* 369 */     this.jLabel14.setCursor(new java.awt.Cursor(12));
/* 370 */     this.jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 372 */         FormeLienHeritageContrainte2.this.jLabel14MouseClicked(evt);
/*     */       }
/*     */       
/* 375 */     });
/* 376 */     this.jLabel9.setText("Points de cassure ");
/*     */     
/* 378 */     this.jCBTout.setText("Appliquer ces couleurs à tous les liens de l'héritage");
/*     */     
/* 380 */     this.jCBDefaut.setText("Couleurs par défaut");
/*     */     
/* 382 */     this.jSpNBCassure.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
/*     */     
/* 384 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 385 */     this.jPanel2.setLayout(jPanel2Layout);
/* 386 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jCBTout).addGap(60, 60, 60).addComponent(this.jCBDefaut)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel9).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jSpNBCassure)).addComponent(this.jPanel4, GroupLayout.Alignment.LEADING, -2, -1, -2))).addContainerGap(82, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(377, 32767).addComponent(this.jLabel14).addGap(103, 103, 103)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(239, 32767).addComponent(this.jPanelAprecu, -2, -1, -2).addContainerGap())));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 412 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGap(39, 39, 39).addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.jSpNBCassure, -2, 28, -2)).addGap(25, 25, 25).addComponent(this.jLabel14).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBTout).addComponent(this.jCBDefaut)).addContainerGap()).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanelAprecu, -1, -1, 32767).addGap(71, 71, 71))));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 435 */     this.jTabbedPane1.addTab("Affichage", this.jPanel2);
/*     */     
/* 437 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 438 */     this.jBtAnnuler.setText("Annuler");
/* 439 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 441 */         FormeLienHeritageContrainte2.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 444 */     });
/* 445 */     this.jBtOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 446 */     this.jBtOK.setText("Valider");
/* 447 */     this.jBtOK.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 449 */         FormeLienHeritageContrainte2.this.jBtOKActionPerformed(evt);
/*     */       }
/*     */       
/* 452 */     });
/* 453 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 454 */     getContentPane().setLayout(layout);
/* 455 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jTabbedPane1, GroupLayout.Alignment.LEADING, -1, 545, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jTFNom, -1, 484, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.jBtAnnuler).addGap(18, 18, 18).addComponent(this.jBtOK, -2, 104, -2))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 471 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFNom, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.jTabbedPane1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtOK).addComponent(this.jBtAnnuler)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 487 */     pack();
/*     */   }
/*     */   
/*     */   private void jTFNomFocusLost(java.awt.event.FocusEvent evt) {
/* 491 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jBtHsitoriqueActionPerformed(java.awt.event.ActionEvent evt) {
/* 495 */     new FormeHistorique(this.frm, true, this.lien.getHistorique(), "", "").setVisible(true);
/*     */   }
/*     */   
/*     */   private void jLabFondMouseClicked(java.awt.event.MouseEvent evt) {
/* 499 */     this.jLabFond.setBackground(choixDeCouleur(this.jLabFond.getBackground(), "Couleur Cadre"));
/* 500 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabNomMouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 505 */     this.jLabNom.setBackground(choixDeCouleur(this.jLabNom.getBackground(), "Couleur Fond"));
/* 506 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jPanelAprecuMouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 511 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabel14MouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 516 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt)
/*     */   {
/* 521 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt) {
/* 525 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtOKActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 530 */     this.lien.setNom(this.jTFNom.getText().trim());
/* 531 */     this.lien.setCode(this.jTFNom.getText().trim().toUpperCase());
/* 532 */     this.lien.setCommentaire(this.jTACommentaire.getText());
/*     */     
/*     */ 
/*     */ 
/* 536 */     this.lien.setClLienHeritage2(this.jLabFond.getBackground());
/* 537 */     this.lien.setClLienNomHeritage2(this.jLabNom.getBackground());
/*     */     
/* 539 */     this.lien.ajouterModification();
/* 540 */     if (this.jCBDefaut.isSelected()) {
/* 541 */       appliquerCoulerDefaut();
/*     */     }
/* 543 */     if (this.jCBTout.isSelected()) {
/* 544 */       appliquerCoulerToutLien();
/*     */     }
/* 546 */     modifierPointDeCassure();
/* 547 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeLienHeritageContrainte2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */