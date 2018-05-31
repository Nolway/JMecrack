/*     */ package formes2;
/*     */ 
/*     */ import IhmMCD2.IhmCadre2;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JRadioButton;
/*     */ 
/*     */ public class FormeCadre2 extends javax.swing.JDialog
/*     */ {
/*     */   private IhmMCD.IhmCadre objet;
/*     */   IhmCadre2 cadre;
/*     */   ihm.Principale frm;
/*     */   private javax.swing.ButtonGroup buttonGroup1;
/*     */   private JButton jBtAnnuler;
/*     */   private JButton jBtHistorique;
/*     */   private JButton jBtValider;
/*     */   private JCheckBox jCBDegradee;
/*     */   private JCheckBox jCBOmbre;
/*     */   private JCheckBox jCBTout;
/*     */   private JLabel jLabCadre;
/*     */   private JLabel jLabFond;
/*     */   private JLabel jLabOmbre;
/*     */   private JLabel jLabTexte;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel12;
/*     */   
/*     */   public FormeCadre2(ihm.Principale frm, boolean modal, IhmCadre2 objet)
/*     */   {
/*  38 */     super(frm, modal);
/*  39 */     initComponents();
/*  40 */     this.frm = frm;
/*  41 */     if ((objet instanceof IhmCadre2)) this.cadre = objet;
/*  42 */     setLocation(frm.getX() + 300, frm.getY() + 150);
/*  43 */     initData();
/*  44 */     this.jBtAnnuler.setMnemonic(65);
/*  45 */     this.jBtValider.setMnemonic(10);
/*     */   }
/*     */   
/*     */   private void initData()
/*     */   {
/*  50 */     this.jTACommenaire.setText(this.cadre.getCommentaire());
/*  51 */     this.jTFNom.setText(this.cadre.getNom());
/*  52 */     this.jLabCadre.setBackground(this.cadre.getClCadre2());
/*  53 */     this.jLabFond.setBackground(this.cadre.getClFond2());
/*  54 */     this.jLabTexte.setBackground(this.cadre.getClText2());
/*  55 */     this.jLabOmbre.setBackground(this.cadre.getClOmbre2());
/*  56 */     this.jCBDegradee.setSelected(this.cadre.isClDegradee());
/*     */     
/*  58 */     choixAligner();
/*  59 */     this.jCBOmbre.setSelected(this.cadre.isOmbre());
/*     */   }
/*     */   
/*     */   private void choixAligner() {
/*  63 */     if (this.cadre.getAligner().equals("GAUCHE")) {
/*  64 */       this.jRBCentre.setSelected(false);
/*  65 */       this.jRBDroite.setSelected(false);
/*  66 */       this.jRBGauche.setSelected(true);
/*     */     }
/*  68 */     if (this.cadre.getAligner().equals("DROITE")) {
/*  69 */       this.jRBCentre.setSelected(false);
/*  70 */       this.jRBDroite.setSelected(true);
/*  71 */       this.jRBGauche.setSelected(false);
/*     */     }
/*  73 */     if (this.cadre.getAligner().equals("CENTRE")) {
/*  74 */       this.jRBCentre.setSelected(true);
/*  75 */       this.jRBDroite.setSelected(false);
/*  76 */       this.jRBGauche.setSelected(false);
/*     */     }
/*     */   }
/*     */   
/*     */   private String getChoixAligner() {
/*  81 */     if (this.jRBGauche.isSelected()) return "GAUCHE";
/*  82 */     if (this.jRBDroite.isSelected()) return "DROITE";
/*  83 */     if (this.jRBCentre.isSelected()) return "CENTRE";
/*  84 */     return "CENTRE";
/*     */   }
/*     */   
/*     */   private java.awt.Color choixDeCouleur(java.awt.Color color, String titre)
/*     */   {
/*  89 */     java.awt.Color col = javax.swing.JColorChooser.showDialog(this, titre, color);
/*  90 */     if (col == null) return color;
/*  91 */     return col;
/*     */   }
/*     */   
/*     */   private void dessinerOmbre(Graphics2D g2d, int x, int y, int w, int h)
/*     */   {
/*  96 */     g2d.setColor(this.jLabOmbre.getBackground());
/*  97 */     g2d.fillRect(x + 2, y + 2, w + 3, h + 3);
/*     */   }
/*     */   
/*     */   private void dessinerNom(Graphics2D g2d, int x, int y, int w, int h, String nom) {
/* 101 */     g2d.setColor(this.jLabTexte.getBackground());
/* 102 */     String aligne = getChoixAligner();
/*     */     
/* 104 */     int hn = g2d.getFontMetrics().getHeight();
/* 105 */     int wn = g2d.getFontMetrics().stringWidth(nom);
/*     */     
/* 107 */     if (aligne.equals("GAUCHE")) {
/* 108 */       g2d.drawString(nom, x + 3, y + hn + 2);
/*     */     }
/* 110 */     if (aligne.equals("DROITE")) {
/* 111 */       g2d.drawString(nom, x + w - wn - 3, y + hn + 2);
/*     */     }
/* 113 */     if (aligne.equals("CENTRE")) {
/* 114 */       g2d.drawString(nom, x + (w - wn) / 2 - 3, y + hn + 2);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerApercu() {
/* 119 */     Graphics2D g = (Graphics2D)this.jPanelAprecu.getGraphics();
/* 120 */     int x = 10;
/* 121 */     int y = 10;
/* 122 */     int w = this.jPanelAprecu.getWidth() - 20;
/* 123 */     int h = this.jPanelAprecu.getHeight() - 20;
/*     */     
/* 125 */     if (this.jCBOmbre.isSelected()) { dessinerOmbre(g, x, y, w, h);
/*     */     }
/* 127 */     g.setFont(new java.awt.Font("Tahoma", 1, 10));
/* 128 */     g.setColor(this.jLabFond.getBackground());
/*     */     
/* 130 */     if (this.jCBDegradee.isSelected()) {
/* 131 */       g.setPaint(new java.awt.GradientPaint(x, y, this.jLabFond.getBackground(), x + w, y + h, java.awt.Color.WHITE, true));
/*     */     }
/* 133 */     g.fillRect(x, y, w, h);
/* 134 */     g.setColor(this.jLabCadre.getBackground());
/* 135 */     g.drawRect(x, y, w, h);
/*     */     
/* 137 */     dessinerNom(g, x, y, w, h, this.jTFNom.getText());
/*     */   }
/*     */   
/*     */   private void appliquerAToutCadre()
/*     */   {
/* 142 */     java.util.ArrayList<IhmMCD.IhmCadre> liste = this.frm.getPage().getListeCadre();
/*     */     
/* 144 */     String al = getChoixAligner();
/* 145 */     for (int i = 0; i < liste.size(); i++) {
/* 146 */       IhmCadre2 cad = (IhmCadre2)liste.get(i);
/* 147 */       cad.setClCadre2(this.jLabCadre.getBackground());
/* 148 */       cad.setClFond2(this.jLabFond.getBackground());
/* 149 */       cad.setClOmbre2(this.jLabOmbre.getBackground());
/* 150 */       cad.setClText2(this.jLabTexte.getBackground());
/* 151 */       cad.setAligner(al);
/* 152 */       cad.setOmbre(this.jCBOmbre.isSelected());
/* 153 */       cad.setClDegradee(this.jCBDegradee.isSelected());
/*     */     }
/*     */   }
/*     */   
/*     */   private JLabel jLabel13;
/*     */   private JLabel jLabel14;
/*     */   private JLabel jLabel15;
/*     */   private JLabel jLabel16;
/*     */   private JLabel jLabel2;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel3;
/*     */   
/*     */   private void initComponents() {
/* 167 */     this.buttonGroup1 = new javax.swing.ButtonGroup();
/* 168 */     this.jTabbedPane1 = new javax.swing.JTabbedPane();
/* 169 */     this.jPanel1 = new JPanel();
/* 170 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 171 */     this.jTACommenaire = new javax.swing.JTextArea();
/* 172 */     this.jBtHistorique = new JButton();
/* 173 */     this.jPanel2 = new JPanel();
/* 174 */     this.jPanel4 = new JPanel();
/* 175 */     this.jLabCadre = new JLabel();
/* 176 */     this.jLabel12 = new JLabel();
/* 177 */     this.jLabel13 = new JLabel();
/* 178 */     this.jLabel15 = new JLabel();
/* 179 */     this.jLabFond = new JLabel();
/* 180 */     this.jLabTexte = new JLabel();
/* 181 */     this.jLabel16 = new JLabel();
/* 182 */     this.jLabOmbre = new JLabel();
/* 183 */     this.jCBTout = new JCheckBox();
/* 184 */     this.jPanel3 = new JPanel();
/* 185 */     this.jRBGauche = new JRadioButton();
/* 186 */     this.jRBCentre = new JRadioButton();
/* 187 */     this.jRBDroite = new JRadioButton();
/* 188 */     this.jLabel1 = new JLabel();
/* 189 */     this.jPanelAprecu = new JPanel();
/* 190 */     this.jLabel14 = new JLabel();
/* 191 */     this.jCBOmbre = new JCheckBox();
/* 192 */     this.jCBDegradee = new JCheckBox();
/* 193 */     this.jBtAnnuler = new JButton();
/* 194 */     this.jBtValider = new JButton();
/* 195 */     this.jLabel2 = new JLabel();
/* 196 */     this.jTFNom = new javax.swing.JTextField();
/*     */     
/* 198 */     setDefaultCloseOperation(2);
/* 199 */     setTitle("Propriété Cadre");
/*     */     
/* 201 */     this.jTACommenaire.setColumns(20);
/* 202 */     this.jTACommenaire.setRows(5);
/* 203 */     this.jScrollPane1.setViewportView(this.jTACommenaire);
/*     */     
/* 205 */     this.jBtHistorique.setText("Historique ...");
/* 206 */     this.jBtHistorique.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 208 */         FormeCadre2.this.jBtHistoriqueActionPerformed(evt);
/*     */       }
/*     */       
/* 211 */     });
/* 212 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 213 */     this.jPanel1.setLayout(jPanel1Layout);
/* 214 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 544, 32767).addComponent(this.jBtHistorique)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 223 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 189, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtHistorique).addContainerGap(44, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 233 */     this.jTabbedPane1.addTab("Commentaire ", this.jPanel1);
/*     */     
/* 235 */     this.jLabCadre.setBackground(new java.awt.Color(0, 0, 0));
/* 236 */     this.jLabCadre.setHorizontalAlignment(0);
/* 237 */     this.jLabCadre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 238 */     this.jLabCadre.setCursor(new java.awt.Cursor(12));
/* 239 */     this.jLabCadre.setOpaque(true);
/* 240 */     this.jLabCadre.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 242 */         FormeCadre2.this.jLabCadreMouseClicked(evt);
/*     */       }
/*     */       
/* 245 */     });
/* 246 */     this.jLabel12.setHorizontalAlignment(0);
/* 247 */     this.jLabel12.setText("Cadre");
/*     */     
/* 249 */     this.jLabel13.setHorizontalAlignment(0);
/* 250 */     this.jLabel13.setText("Texte");
/*     */     
/* 252 */     this.jLabel15.setHorizontalAlignment(0);
/* 253 */     this.jLabel15.setText("Fond");
/*     */     
/* 255 */     this.jLabFond.setBackground(new java.awt.Color(255, 51, 0));
/* 256 */     this.jLabFond.setHorizontalAlignment(0);
/* 257 */     this.jLabFond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 258 */     this.jLabFond.setCursor(new java.awt.Cursor(12));
/* 259 */     this.jLabFond.setOpaque(true);
/* 260 */     this.jLabFond.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 262 */         FormeCadre2.this.jLabFondMouseClicked(evt);
/*     */       }
/*     */       
/* 265 */     });
/* 266 */     this.jLabTexte.setBackground(new java.awt.Color(0, 0, 0));
/* 267 */     this.jLabTexte.setHorizontalAlignment(0);
/* 268 */     this.jLabTexte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 269 */     this.jLabTexte.setCursor(new java.awt.Cursor(12));
/* 270 */     this.jLabTexte.setOpaque(true);
/* 271 */     this.jLabTexte.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 273 */         FormeCadre2.this.jLabTexteMouseClicked(evt);
/*     */       }
/*     */       
/* 276 */     });
/* 277 */     this.jLabel16.setHorizontalAlignment(0);
/* 278 */     this.jLabel16.setText("Ombre");
/*     */     
/* 280 */     this.jLabOmbre.setBackground(new java.awt.Color(0, 0, 0));
/* 281 */     this.jLabOmbre.setHorizontalAlignment(0);
/* 282 */     this.jLabOmbre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 283 */     this.jLabOmbre.setCursor(new java.awt.Cursor(12));
/* 284 */     this.jLabOmbre.setOpaque(true);
/* 285 */     this.jLabOmbre.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 287 */         FormeCadre2.this.jLabOmbreMouseClicked(evt);
/*     */       }
/*     */       
/* 290 */     });
/* 291 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 292 */     this.jPanel4.setLayout(jPanel4Layout);
/* 293 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel12).addComponent(this.jLabel15).addComponent(this.jLabel13).addComponent(this.jLabel16)).addGap(52, 52, 52).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabOmbre, -1, 59, 32767).addComponent(this.jLabCadre, GroupLayout.Alignment.TRAILING, -1, 59, 32767).addComponent(this.jLabFond, GroupLayout.Alignment.TRAILING, -1, 59, 32767).addComponent(this.jLabTexte, -1, 59, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 310 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(17, 17, 17).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabel12).addGap(18, 21, 32767).addComponent(this.jLabel15)).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jLabCadre, -2, 20, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabFond, -1, 18, 32767))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel13).addComponent(this.jLabTexte, -2, 18, -2)).addGap(11, 11, 11).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel16).addComponent(this.jLabOmbre, -2, 18, -2)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 334 */     this.jCBTout.setText("Appliquer à tous les Commentaires  ");
/* 335 */     this.jCBTout.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 337 */         FormeCadre2.this.jCBToutMouseClicked(evt);
/*     */       }
/* 339 */     });
/* 340 */     this.jCBTout.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 342 */         FormeCadre2.this.jCBToutActionPerformed(evt);
/*     */       }
/*     */       
/* 345 */     });
/* 346 */     this.jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/*     */     
/* 348 */     this.buttonGroup1.add(this.jRBGauche);
/* 349 */     this.jRBGauche.setText("GAUCHE");
/* 350 */     this.jRBGauche.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 352 */         FormeCadre2.this.jRBGaucheActionPerformed(evt);
/*     */       }
/*     */       
/* 355 */     });
/* 356 */     this.buttonGroup1.add(this.jRBCentre);
/* 357 */     this.jRBCentre.setText("CENTRE");
/* 358 */     this.jRBCentre.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 360 */         FormeCadre2.this.jRBCentreActionPerformed(evt);
/*     */       }
/*     */       
/* 363 */     });
/* 364 */     this.buttonGroup1.add(this.jRBDroite);
/* 365 */     this.jRBDroite.setText("DROITE");
/* 366 */     this.jRBDroite.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 368 */         FormeCadre2.this.jRBDroiteActionPerformed(evt);
/*     */       }
/*     */       
/* 371 */     });
/* 372 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 373 */     this.jPanel3.setLayout(jPanel3Layout);
/* 374 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jRBGauche).addGap(40, 40, 40).addComponent(this.jRBCentre).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, 32767).addComponent(this.jRBDroite).addGap(34, 34, 34)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 385 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRBGauche).addComponent(this.jRBDroite).addComponent(this.jRBCentre)).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 396 */     this.jLabel1.setText("Aligner le nom ");
/*     */     
/* 398 */     this.jPanelAprecu.setBackground(new java.awt.Color(255, 255, 255));
/* 399 */     this.jPanelAprecu.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 401 */         FormeCadre2.this.jPanelAprecuMouseClicked(evt);
/*     */       }
/*     */       
/* 404 */     });
/* 405 */     GroupLayout jPanelAprecuLayout = new GroupLayout(this.jPanelAprecu);
/* 406 */     this.jPanelAprecu.setLayout(jPanelAprecuLayout);
/* 407 */     jPanelAprecuLayout.setHorizontalGroup(jPanelAprecuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 363, 32767));
/*     */     
/*     */ 
/*     */ 
/* 411 */     jPanelAprecuLayout.setVerticalGroup(jPanelAprecuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 148, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 416 */     this.jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 417 */     this.jLabel14.setForeground(new java.awt.Color(0, 0, 153));
/* 418 */     this.jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/oeil.png")));
/* 419 */     this.jLabel14.setText("Aperçu");
/* 420 */     this.jLabel14.setCursor(new java.awt.Cursor(12));
/* 421 */     this.jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 423 */         FormeCadre2.this.jLabel14MouseClicked(evt);
/*     */       }
/*     */       
/* 426 */     });
/* 427 */     this.jCBOmbre.setText("Ombre");
/* 428 */     this.jCBOmbre.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 430 */         FormeCadre2.this.jCBOmbreActionPerformed(evt);
/*     */       }
/*     */       
/* 433 */     });
/* 434 */     this.jCBDegradee.setText("Couleur dégradée");
/* 435 */     this.jCBDegradee.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 437 */         FormeCadre2.this.jCBDegradeeActionPerformed(evt);
/*     */       }
/*     */       
/* 440 */     });
/* 441 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 442 */     this.jPanel2.setLayout(jPanel2Layout);
/* 443 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel4, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanelAprecu, -2, -1, -2)).addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addGap(19, 19, 19).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBTout).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -2, -1, -2).addComponent(this.jLabel1)).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(78, 78, 78).addComponent(this.jLabel14)).addGroup(jPanel2Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jCBOmbre).addGap(18, 18, 18).addComponent(this.jCBDegradee))))))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 471 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jPanel4, -1, -1, 32767).addGap(31, 31, 31)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanelAprecu, -1, -1, 32767).addGap(18, 18, 18))).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel3, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jCBTout)).addGroup(jPanel2Layout.createSequentialGroup().addGap(22, 22, 22).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBOmbre).addComponent(this.jCBDegradee)))).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel14).addGap(85, 85, 85)))).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jLabel1).addGap(100, 100, 100)))));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 505 */     this.jTabbedPane1.addTab("Affichage", this.jPanel2);
/*     */     
/* 507 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 508 */     this.jBtAnnuler.setText("Annuler");
/* 509 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 511 */         FormeCadre2.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 514 */     });
/* 515 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 516 */     this.jBtValider.setText("Valider");
/* 517 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 519 */         FormeCadre2.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 522 */     });
/* 523 */     this.jLabel2.setText("Nom ");
/*     */     
/* 525 */     this.jTFNom.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyPressed(java.awt.event.KeyEvent evt) {
/* 527 */         FormeCadre2.this.jTFNomKeyPressed(evt);
/*     */       }
/*     */       
/* 530 */       public void keyReleased(java.awt.event.KeyEvent evt) { FormeCadre2.this.jTFNomKeyReleased(evt);
/*     */       }
/*     */ 
/* 533 */     });
/* 534 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 535 */     getContentPane().setLayout(layout);
/* 536 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jTabbedPane1, GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jBtAnnuler, -2, 107, -2).addGap(28, 28, 28).addComponent(this.jBtValider, -2, 103, -2)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.jTFNom, -1, 527, 32767))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 552 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTFNom, -2, 34, -2)).addGap(18, 18, 18).addComponent(this.jTabbedPane1, -1, 306, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtAnnuler).addComponent(this.jBtValider)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 568 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtHistoriqueActionPerformed(ActionEvent evt) {
/* 572 */     new FormeHistorique(this.frm, true, this.cadre.getHistorique(), "", "").setVisible(true);
/*     */   }
/*     */   
/*     */   private void jLabCadreMouseClicked(MouseEvent evt) {
/* 576 */     this.jLabCadre.setBackground(choixDeCouleur(this.jLabCadre.getBackground(), "Couleur Cadre"));
/* 577 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabFondMouseClicked(MouseEvent evt)
/*     */   {
/* 582 */     this.jLabFond.setBackground(choixDeCouleur(this.jLabFond.getBackground(), "Couleur Fond"));
/* 583 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabTexteMouseClicked(MouseEvent evt)
/*     */   {
/* 588 */     this.jLabTexte.setBackground(choixDeCouleur(this.jLabTexte.getBackground(), "Couleur Texte"));
/* 589 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private JPanel jPanel4;
/*     */   private JPanel jPanelAprecu;
/*     */   
/*     */   private void jCBToutMouseClicked(MouseEvent evt) {}
/*     */   
/* 597 */   private void jCBToutActionPerformed(ActionEvent evt) { dessinerApercu(); }
/*     */   
/*     */   private void jRBGaucheActionPerformed(ActionEvent evt)
/*     */   {
/* 601 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jRBCentreActionPerformed(ActionEvent evt) {
/* 605 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jRBDroiteActionPerformed(ActionEvent evt) {
/* 609 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jPanelAprecuMouseClicked(MouseEvent evt) {
/* 613 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jLabel14MouseClicked(MouseEvent evt)
/*     */   {
/* 618 */     dessinerApercu();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(ActionEvent evt) {
/* 622 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(ActionEvent evt) {
/* 626 */     String s = this.jTACommenaire.getText().trim();
/* 627 */     this.cadre.setCommentaire(s);
/* 628 */     this.cadre.setNom(this.jTFNom.getText().trim());
/*     */     
/* 630 */     this.cadre.setClCadre2(this.jLabCadre.getBackground());
/* 631 */     this.cadre.setClFond2(this.jLabFond.getBackground());
/* 632 */     this.cadre.setClText2(this.jLabTexte.getBackground());
/* 633 */     this.cadre.setClOmbre2(this.jLabOmbre.getBackground());
/* 634 */     this.cadre.setAligner(getChoixAligner());
/* 635 */     this.cadre.setOmbre(this.jCBOmbre.isSelected());
/* 636 */     this.cadre.setClDegradee(this.jCBDegradee.isSelected());
/*     */     
/* 638 */     if (this.jCBTout.isSelected()) {
/* 639 */       appliquerAToutCadre();
/*     */     }
/* 641 */     dispose();
/*     */   }
/*     */   
/*     */   private void jLabOmbreMouseClicked(MouseEvent evt) {
/* 645 */     this.jLabOmbre.setBackground(choixDeCouleur(this.jLabOmbre.getBackground(), "Couleur Fond"));
/* 646 */     dessinerApercu();
/*     */   }
/*     */   
/*     */ 
/* 650 */   private void jCBOmbreActionPerformed(ActionEvent evt) { dessinerApercu(); }
/*     */   
/*     */   private JRadioButton jRBCentre;
/*     */   private JRadioButton jRBDroite;
/* 654 */   private void jCBDegradeeActionPerformed(ActionEvent evt) { dessinerApercu(); }
/*     */   
/*     */   private JRadioButton jRBGauche;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   
/*     */   private void jTFNomKeyPressed(java.awt.event.KeyEvent evt) {}
/*     */   
/*     */   private void jTFNomKeyReleased(java.awt.event.KeyEvent evt) {
/* 662 */     dessinerApercu();
/* 663 */     repaint();
/*     */   }
/*     */   
/*     */   private javax.swing.JTextArea jTACommenaire;
/*     */   private javax.swing.JTextField jTFNom;
/*     */   private javax.swing.JTabbedPane jTabbedPane1;
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeCadre2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */