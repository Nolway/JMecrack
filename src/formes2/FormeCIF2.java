/*     */ package formes2;
/*     */ 
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class FormeCIF2 extends javax.swing.JDialog
/*     */ {
/*     */   ihm.Principale frm;
/*     */   IhmMCD2.IhmCIF2 cif;
/*     */   private javax.swing.JButton jBtAnnuler;
/*     */   private javax.swing.JButton jBtHistorique;
/*     */   private javax.swing.JButton jBtOK;
/*     */   private javax.swing.JCheckBox jCBDefaut;
/*     */   private javax.swing.JCheckBox jCBTout;
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
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JPanel jPanel4;
/*     */   private javax.swing.JPanel jPanelAprecu;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JTextArea jTACommentaire;
/*     */   private javax.swing.JTabbedPane jTabbedPane1;
/*     */   
/*     */   public FormeCIF2(ihm.Principale frm, boolean modal, IhmMCD2.IhmCIF2 cif)
/*     */   {
/*  38 */     super(frm, modal);
/*  39 */     this.frm = frm;
/*  40 */     this.cif = cif;
/*  41 */     initComponents();
/*  42 */     setLocation(frm.getX() + 290, frm.getY() + 150);
/*  43 */     initailiserData();
/*  44 */     this.jBtAnnuler.setMnemonic(65);
/*  45 */     this.jBtOK.setMnemonic(10);
/*     */   }
/*     */   
/*     */   private void initailiserData()
/*     */   {
/*  50 */     this.jLabCadre.setBackground(this.cif.getClCadre2());
/*  51 */     this.jLabFond.setBackground(this.cif.getClFond2());
/*  52 */     this.jLabTexte.setBackground(this.cif.getClText2());
/*  53 */     this.jLabActif.setBackground(this.cif.getClLienActiver());
/*  54 */     this.jTACommentaire.setText(this.cif.getCommentaire());
/*     */   }
/*     */   
/*     */   private java.awt.Color choixDeCouleur(java.awt.Color color, String titre)
/*     */   {
/*  59 */     java.awt.Color col = javax.swing.JColorChooser.showDialog(this, titre, color);
/*  60 */     if (col == null) return color;
/*  61 */     return col;
/*     */   }
/*     */   
/*     */   private void appliquerToutCif() {
/*  65 */     java.util.ArrayList<IhmMCD.IhmCIF> liste = this.frm.getPage().getListeCIF();
/*     */     
/*  67 */     for (int i = 0; i < liste.size(); i++) {
/*  68 */       IhmMCD2.IhmCIF2 c = (IhmMCD2.IhmCIF2)liste.get(i);
/*  69 */       c.setClFond2(this.jLabFond.getBackground());
/*  70 */       c.setClCadre2(this.jLabCadre.getBackground());
/*  71 */       c.setClText2(this.jLabTexte.getBackground());
/*  72 */       c.setClLienActiver(this.jLabActif.getBackground());
/*     */     }
/*     */   }
/*     */   
/*     */   private void appliquerCouleurCIFDefaut() {
/*  77 */     ihm.FormeInterneMCD.clCIFFond2 = this.jLabFond.getBackground();
/*  78 */     ihm.FormeInterneMCD.clCIFCadre2 = this.jLabCadre.getBackground();
/*  79 */     ihm.FormeInterneMCD.clCIFText2 = this.jLabTexte.getBackground();
/*  80 */     ihm.FormeInterneMCD.clLienActiverCIF2 = this.jLabActif.getBackground();
/*     */   }
/*     */   
/*     */   private void dessinerApercu() {
/*  84 */     java.awt.Graphics2D g = (java.awt.Graphics2D)this.jPanelAprecu.getGraphics();
/*  85 */     g.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  86 */     String nom = "C I F";
/*  87 */     java.awt.Color clgard = g.getColor();
/*     */     
/*  89 */     int x = this.jPanelAprecu.getWidth() / 5;
/*  90 */     int y = this.jPanelAprecu.getHeight() / 2;
/*  91 */     int w = 38;
/*  92 */     int h = 36;
/*     */     
/*  94 */     g.setColor(this.jLabActif.getBackground());
/*  95 */     g.drawLine(x, 0, x + w / 2, y + h / 2);
/*  96 */     g.drawLine(x + w / 2, y + h / 2, this.jPanelAprecu.getWidth(), y + h / 2);
/*     */     
/*  98 */     g.drawLine(x + w / 2, y + h / 2, this.jPanelAprecu.getWidth(), this.jPanelAprecu.getHeight());
/*     */     
/* 100 */     java.awt.geom.RoundRectangle2D rRect = new java.awt.geom.RoundRectangle2D.Double(x, y, w, h, h, h);
/* 101 */     g.setColor(this.jLabFond.getBackground());
/* 102 */     g.fill(rRect);
/* 103 */     g.setColor(this.jLabCadre.getBackground());
/* 104 */     g.draw(rRect);
/* 105 */     g.setColor(this.jLabTexte.getBackground());
/* 106 */     int tail = g.getFontMetrics().stringWidth(nom);
/*     */     
/* 108 */     java.awt.Font f = g.getFont();
/* 109 */     g.setFont(new java.awt.Font("ARIAL", 1, 12));
/* 110 */     g.drawString(nom, x + 1 + (w - tail) / 2, y + h - 14);
/*     */     
/* 112 */     g.setFont(f);
/* 113 */     g.setColor(clgard);
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
/* 126 */     this.jTabbedPane1 = new javax.swing.JTabbedPane();
/* 127 */     this.jPanel1 = new javax.swing.JPanel();
/* 128 */     this.jLabel1 = new JLabel();
/* 129 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 130 */     this.jTACommentaire = new javax.swing.JTextArea();
/* 131 */     this.jBtHistorique = new javax.swing.JButton();
/* 132 */     this.jPanel2 = new javax.swing.JPanel();
/* 133 */     this.jPanelAprecu = new javax.swing.JPanel();
/* 134 */     this.jPanel4 = new javax.swing.JPanel();
/* 135 */     this.jLabCadre = new JLabel();
/* 136 */     this.jLabel12 = new JLabel();
/* 137 */     this.jLabel13 = new JLabel();
/* 138 */     this.jLabel15 = new JLabel();
/* 139 */     this.jLabFond = new JLabel();
/* 140 */     this.jLabTexte = new JLabel();
/* 141 */     this.jLabActif = new JLabel();
/* 142 */     this.jLabel2 = new JLabel();
/* 143 */     this.jLabel14 = new JLabel();
/* 144 */     this.jCBDefaut = new javax.swing.JCheckBox();
/* 145 */     this.jCBTout = new javax.swing.JCheckBox();
/* 146 */     this.jBtAnnuler = new javax.swing.JButton();
/* 147 */     this.jBtOK = new javax.swing.JButton();
/*     */     
/* 149 */     setDefaultCloseOperation(2);
/* 150 */     setTitle("Propriétés CIF");
/* 151 */     setResizable(false);
/*     */     
/* 153 */     this.jLabel1.setText("Commentaire ");
/*     */     
/* 155 */     this.jTACommentaire.setColumns(20);
/* 156 */     this.jTACommentaire.setRows(5);
/* 157 */     this.jScrollPane1.setViewportView(this.jTACommentaire);
/*     */     
/* 159 */     this.jBtHistorique.setText("Historique...");
/* 160 */     this.jBtHistorique.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 162 */         FormeCIF2.this.jBtHistoriqueActionPerformed(evt);
/*     */       }
/*     */       
/* 165 */     });
/* 166 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 167 */     this.jPanel1.setLayout(jPanel1Layout);
/* 168 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 548, 32767).addComponent(this.jLabel1).addComponent(this.jBtHistorique)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 178 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 162, 32767).addGap(18, 18, 18).addComponent(this.jBtHistorique).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 190 */     this.jTabbedPane1.addTab("Commentaire ", this.jPanel1);
/*     */     
/* 192 */     this.jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
/*     */       public void componentShown(java.awt.event.ComponentEvent evt) {
/* 194 */         FormeCIF2.this.jPanel2ComponentShown(evt);
/*     */       }
/*     */       
/* 197 */     });
/* 198 */     this.jPanelAprecu.setBackground(new java.awt.Color(255, 255, 255));
/* 199 */     this.jPanelAprecu.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 201 */         FormeCIF2.this.jPanelAprecuMouseClicked(evt);
/*     */       }
/*     */       
/* 204 */     });
/* 205 */     GroupLayout jPanelAprecuLayout = new GroupLayout(this.jPanelAprecu);
/* 206 */     this.jPanelAprecu.setLayout(jPanelAprecuLayout);
/* 207 */     jPanelAprecuLayout.setHorizontalGroup(jPanelAprecuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 278, 32767));
/*     */     
/*     */ 
/*     */ 
/* 211 */     jPanelAprecuLayout.setVerticalGroup(jPanelAprecuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 182, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 216 */     this.jLabCadre.setBackground(new java.awt.Color(0, 0, 0));
/* 217 */     this.jLabCadre.setHorizontalAlignment(0);
/* 218 */     this.jLabCadre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 219 */     this.jLabCadre.setCursor(new java.awt.Cursor(12));
/* 220 */     this.jLabCadre.setOpaque(true);
/* 221 */     this.jLabCadre.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 223 */         FormeCIF2.this.jLabCadreMouseClicked(evt);
/*     */       }
/*     */       
/* 226 */     });
/* 227 */     this.jLabel12.setHorizontalAlignment(0);
/* 228 */     this.jLabel12.setText("Cadre");
/*     */     
/* 230 */     this.jLabel13.setHorizontalAlignment(0);
/* 231 */     this.jLabel13.setText("Texte");
/*     */     
/* 233 */     this.jLabel15.setHorizontalAlignment(0);
/* 234 */     this.jLabel15.setText("Fond");
/*     */     
/* 236 */     this.jLabFond.setBackground(new java.awt.Color(255, 51, 0));
/* 237 */     this.jLabFond.setHorizontalAlignment(0);
/* 238 */     this.jLabFond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 239 */     this.jLabFond.setCursor(new java.awt.Cursor(12));
/* 240 */     this.jLabFond.setOpaque(true);
/* 241 */     this.jLabFond.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 243 */         FormeCIF2.this.jLabFondMouseClicked(evt);
/*     */       }
/*     */       
/* 246 */     });
/* 247 */     this.jLabTexte.setBackground(new java.awt.Color(0, 0, 0));
/* 248 */     this.jLabTexte.setHorizontalAlignment(0);
/* 249 */     this.jLabTexte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 250 */     this.jLabTexte.setCursor(new java.awt.Cursor(12));
/* 251 */     this.jLabTexte.setOpaque(true);
/* 252 */     this.jLabTexte.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 254 */         FormeCIF2.this.jLabTexteMouseClicked(evt);
/*     */       }
/*     */       
/* 257 */     });
/* 258 */     this.jLabActif.setBackground(new java.awt.Color(0, 0, 0));
/* 259 */     this.jLabActif.setHorizontalAlignment(0);
/* 260 */     this.jLabActif.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 261 */     this.jLabActif.setCursor(new java.awt.Cursor(12));
/* 262 */     this.jLabActif.setOpaque(true);
/* 263 */     this.jLabActif.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 265 */         FormeCIF2.this.jLabActifMouseClicked(evt);
/*     */       }
/*     */       
/* 268 */     });
/* 269 */     this.jLabel2.setText("Lien CiIF Actif");
/*     */     
/* 271 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 272 */     this.jPanel4.setLayout(jPanel4Layout);
/* 273 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel12).addComponent(this.jLabel15).addComponent(this.jLabel13).addComponent(this.jLabel2)).addGap(61, 61, 61).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabCadre, -1, 55, 32767).addComponent(this.jLabActif, -1, 55, 32767).addComponent(this.jLabTexte, -1, 55, 32767).addComponent(this.jLabFond, -1, 55, 32767)).addGap(18, 18, 18)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 290 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jLabel12).addComponent(this.jLabCadre, -2, 20, -2)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabFond, -1, 17, 32767).addComponent(this.jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel13, javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jLabTexte, javax.swing.GroupLayout.Alignment.TRAILING, -2, 18, -2)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jLabActif, -2, 18, -2).addComponent(this.jLabel2)).addGap(16, 16, 16)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 312 */     this.jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 313 */     this.jLabel14.setForeground(new java.awt.Color(0, 0, 153));
/* 314 */     this.jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/oeil.png")));
/* 315 */     this.jLabel14.setText("Aperçu");
/* 316 */     this.jLabel14.setCursor(new java.awt.Cursor(12));
/* 317 */     this.jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 319 */         FormeCIF2.this.jLabel14MouseClicked(evt);
/*     */       }
/*     */       
/* 322 */     });
/* 323 */     this.jCBDefaut.setText("Couleurs par défaut");
/* 324 */     this.jCBDefaut.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 326 */         FormeCIF2.this.jCBDefautMouseClicked(evt);
/*     */       }
/*     */       
/* 329 */     });
/* 330 */     this.jCBTout.setText("Appliquer à toutes les CIF ");
/* 331 */     this.jCBTout.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 333 */         FormeCIF2.this.jCBToutMouseClicked(evt);
/*     */       }
/*     */       
/* 336 */     });
/* 337 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 338 */     this.jPanel2.setLayout(jPanel2Layout);
/* 339 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, 32767).addComponent(this.jPanelAprecu, -2, -1, -2)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jCBTout).addGap(18, 18, 18).addComponent(this.jCBDefaut).addGap(146, 146, 146).addComponent(this.jLabel14).addGap(29, 29, 29))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 357 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(29, 29, 29).addComponent(this.jPanel4, -2, -1, -2)).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanelAprecu, -1, -1, 32767))).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, 32767).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jCBTout).addComponent(this.jCBDefaut)).addContainerGap()).addGroup(jPanel2Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel14).addContainerGap()))));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 380 */     this.jTabbedPane1.addTab("Affichage", this.jPanel2);
/*     */     
/* 382 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 383 */     this.jBtAnnuler.setText("Annuler");
/* 384 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 386 */         FormeCIF2.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 389 */     });
/* 390 */     this.jBtOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 391 */     this.jBtOK.setText("Valider");
/* 392 */     this.jBtOK.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 394 */         FormeCIF2.this.jBtOKActionPerformed(evt);
/*     */       }
/*     */       
/* 397 */     });
/* 398 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 399 */     getContentPane().setLayout(layout);
/* 400 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING, -1, 573, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jBtAnnuler).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtOK, -2, 104, -2))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 412 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -1, 273, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jBtOK).addComponent(this.jBtAnnuler)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 424 */     pack();
/*     */   }
/*     */   
/*     */   private void jLabCadreMouseClicked(MouseEvent evt) {
/* 428 */     this.jLabCadre.setBackground(choixDeCouleur(this.jLabCadre.getBackground(), "Couleur Cadre"));
/* 429 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabFondMouseClicked(MouseEvent evt)
/*     */   {
/* 434 */     this.jLabFond.setBackground(choixDeCouleur(this.jLabFond.getBackground(), "Couleur Fond"));
/* 435 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabTexteMouseClicked(MouseEvent evt)
/*     */   {
/* 440 */     this.jLabTexte.setBackground(choixDeCouleur(this.jLabTexte.getBackground(), "Couleur Texte"));
/* 441 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabel14MouseClicked(MouseEvent evt)
/*     */   {
/* 446 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 451 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtOKActionPerformed(java.awt.event.ActionEvent evt) {
/* 455 */     this.cif.setClCadre2(this.jLabCadre.getBackground());
/* 456 */     this.cif.setClFond2(this.jLabFond.getBackground());
/* 457 */     this.cif.setClText2(this.jLabTexte.getBackground());
/* 458 */     this.cif.setClLienActiver(this.jLabActif.getBackground());
/* 459 */     this.cif.setCommentaire(this.jTACommentaire.getText());
/*     */     
/* 461 */     this.cif.ajouterModification();
/* 462 */     if (this.jCBTout.isSelected()) {
/* 463 */       appliquerToutCif();
/*     */     }
/* 465 */     if (this.jCBDefaut.isSelected()) {
/* 466 */       appliquerCouleurCIFDefaut();
/*     */     }
/* 468 */     dispose();
/*     */   }
/*     */   
/*     */   private void jLabActifMouseClicked(MouseEvent evt) {
/* 472 */     this.jLabActif.setBackground(choixDeCouleur(this.jLabActif.getBackground(), "Couleur Fond"));
/* 473 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jBtHistoriqueActionPerformed(java.awt.event.ActionEvent evt) {
/* 477 */     new FormeHistorique(this.frm, true, this.cif.getHistorique(), "", "").setVisible(true);
/*     */   }
/*     */   
/*     */   private void jPanelAprecuMouseClicked(MouseEvent evt) {
/* 481 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {
/* 485 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jCBToutMouseClicked(MouseEvent evt) {
/* 489 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jCBDefautMouseClicked(MouseEvent evt) {
/* 493 */     dessinerApercu();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeCIF2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */