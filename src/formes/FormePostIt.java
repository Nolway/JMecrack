/*     */ package formes;
/*     */ 
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class FormePostIt extends javax.swing.JDialog {
/*     */   ihm.Principale frm;
/*     */   IhmMCD2.IhmPostIt2 postIt;
/*     */   private javax.swing.ButtonGroup buttonGroup1;
/*     */   private javax.swing.JButton jBtAnnuler;
/*     */   private javax.swing.JButton jBtValider;
/*     */   private javax.swing.JCheckBox jCBDefaut;
/*     */   private javax.swing.JCheckBox jCBTout;
/*     */   private JLabel jLabCadre;
/*     */   private JLabel jLabFond;
/*     */   private JLabel jLabPunaise;
/*     */   private JLabel jLabText;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel7;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JPanel jPanelApercu;
/*     */   private javax.swing.JRadioButton jRBCentre;
/*     */   private javax.swing.JRadioButton jRBDroite;
/*     */   private javax.swing.JRadioButton jRBGauche;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JTextArea jTANote;
/*     */   
/*     */   public FormePostIt(ihm.Principale parent, boolean modal, IhmMCD2.IhmPostIt2 postit) {
/*  34 */     super(parent, modal);
/*  35 */     this.frm = parent;
/*  36 */     initComponents();
/*  37 */     this.postIt = postit;
/*  38 */     setLocation(500, 200);
/*  39 */     this.jLabPunaise.setBackground(this.postIt.getClPunaise());
/*  40 */     this.jLabFond.setBackground(this.postIt.getClFond());
/*  41 */     this.jLabCadre.setBackground(this.postIt.getClCadre());
/*  42 */     this.jLabText.setBackground(postit.getClTexte());
/*     */     
/*  44 */     this.jTANote.setText(this.postIt.getCommentaire());
/*  45 */     paintGraphe(this.jPanelApercu.getGraphics());
/*  46 */     this.jPanelApercu.getGraphics().setColor(java.awt.Color.red);
/*  47 */     this.jPanelApercu.getGraphics().drawLine(0, 0, 100, 100);
/*  48 */     initAligner();
/*  49 */     this.jBtAnnuler.setMnemonic(65);
/*  50 */     this.jBtValider.setMnemonic(10);
/*     */   }
/*     */   
/*     */   private void initAligner() {
/*  54 */     if (this.postIt.getAligner().equals("GAUCHE")) {
/*  55 */       this.jRBCentre.setSelected(false);
/*  56 */       this.jRBDroite.setSelected(false);
/*  57 */       this.jRBGauche.setSelected(true);
/*     */     }
/*  59 */     if (this.postIt.getAligner().equals("CENTRE")) {
/*  60 */       this.jRBCentre.setSelected(true);
/*  61 */       this.jRBDroite.setSelected(false);
/*  62 */       this.jRBGauche.setSelected(false);
/*     */     }
/*  64 */     if (this.postIt.getAligner().equals("DROITE")) {
/*  65 */       this.jRBCentre.setSelected(false);
/*  66 */       this.jRBDroite.setSelected(true);
/*  67 */       this.jRBGauche.setSelected(false);
/*     */     }
/*     */   }
/*     */   
/*     */   private String getAligner() {
/*  72 */     if (this.jRBGauche.isSelected()) {
/*  73 */       return "GAUCHE";
/*     */     }
/*  75 */     if (this.jRBDroite.isSelected()) {
/*  76 */       return "DROITE";
/*     */     }
/*  78 */     if (this.jRBCentre.isSelected()) {
/*  79 */       return "CENTRE";
/*     */     }
/*  81 */     return "GAUCHE";
/*     */   }
/*     */   
/*     */   public void paintGraphe(java.awt.Graphics g) {
/*  85 */     int w = 120;
/*  86 */     int h = 80;
/*  87 */     int x = 10;
/*  88 */     int y = 10;
/*  89 */     g.setColor(java.awt.Color.WHITE);
/*  90 */     g.fillRect(0, 0, this.jPanelApercu.getWidth(), this.jPanelApercu.getHeight());
/*     */     
/*  92 */     dessinerOmbre(g, x, y, w, h);
/*  93 */     int[] xPoint = { 0, 0, 0, 0 };
/*  94 */     int[] yPoint = { 0, 0, 0, 0 };
/*  95 */     xPoint[0] = (x - 1);
/*  96 */     yPoint[0] = (y - 1);
/*     */     
/*  98 */     xPoint[1] = (x + w + 3 + 1);
/*  99 */     yPoint[1] = (y - 1);
/*     */     
/* 101 */     xPoint[2] = (x + w + 8 + 1);
/* 102 */     yPoint[2] = (y + h);
/*     */     
/* 104 */     xPoint[3] = (x + 7 - 1);
/* 105 */     yPoint[3] = (y + h);
/*     */     
/* 107 */     g.setColor(this.jLabFond.getBackground());
/* 108 */     g.drawPolygon(xPoint, yPoint, 4);
/*     */     
/* 110 */     xPoint[0] = x;
/* 111 */     yPoint[0] = y;
/*     */     
/* 113 */     xPoint[1] = (x + w + 3);
/* 114 */     yPoint[1] = y;
/*     */     
/* 116 */     xPoint[2] = (x + w + 8);
/* 117 */     yPoint[2] = (y + h);
/*     */     
/* 119 */     xPoint[3] = (x + 7);
/* 120 */     yPoint[3] = (y + h);
/*     */     
/* 122 */     java.awt.Graphics2D g2d = (java.awt.Graphics2D)g;
/*     */     
/* 124 */     g.fillPolygon(xPoint, yPoint, 4);
/* 125 */     g.setColor(java.awt.Color.GRAY);
/* 126 */     g.fillOval(x + w / 2, y, 10, 10);
/*     */     
/* 128 */     g.setColor(this.jLabPunaise.getBackground());
/* 129 */     g.fillOval(x + w / 2 + 3, y + 2, 6, 6);
/* 130 */     g.fillOval(x + w / 2 + 7, y, 10, 10);
/* 131 */     g.setColor(this.jLabText.getBackground());
/* 132 */     g.drawString("Vos notes ...", 40, 50);
/*     */   }
/*     */   
/*     */   private void dessinerOmbre(java.awt.Graphics g, int x, int y, int w, int h) {
/* 136 */     g.setColor(java.awt.Color.GRAY);
/* 137 */     g.fillRect(x, y, w, h + 3);
/*     */   }
/*     */   
/*     */   private void appliquerTout()
/*     */   {
/* 142 */     java.util.ArrayList<IhmMCD.IhmCommentaireIndip> liste = this.frm.getPage().getListeCommentaire();
/* 143 */     for (int i = 0; i < liste.size(); i++) {
/* 144 */       if ((liste.get(i) instanceof IhmMCD2.IhmPostIt2)) {
/* 145 */         IhmMCD2.IhmPostIt2 p = (IhmMCD2.IhmPostIt2)liste.get(i);
/* 146 */         p.setClCadre(this.jLabCadre.getBackground());
/* 147 */         p.setClFond(this.jLabFond.getBackground());
/* 148 */         p.setClTexte(this.jLabText.getBackground());
/* 149 */         p.setClPunaise(this.jLabPunaise.getBackground());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private java.awt.Color choixDeCouleur(java.awt.Color color, String titre) {
/* 155 */     java.awt.Color col = javax.swing.JColorChooser.showDialog(this, titre, color);
/* 156 */     if (col == null) return color;
/* 157 */     return col;
/*     */   }
/*     */   
/*     */   private void appliquerDefaut() {
/* 161 */     ihm.FormeInterneMCD.clPostItCadre2 = this.jLabCadre.getBackground();
/* 162 */     ihm.FormeInterneMCD.clPostItFond2 = this.jLabFond.getBackground();
/* 163 */     ihm.FormeInterneMCD.clPostItText2 = this.jLabText.getBackground();
/* 164 */     ihm.FormeInterneMCD.clPostItPunaise2 = this.jLabPunaise.getBackground();
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
/* 177 */     this.buttonGroup1 = new javax.swing.ButtonGroup();
/* 178 */     this.jPanel1 = new javax.swing.JPanel();
/* 179 */     this.jPanelApercu = new javax.swing.JPanel();
/* 180 */     this.jLabel1 = new JLabel();
/* 181 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 182 */     this.jTANote = new javax.swing.JTextArea();
/* 183 */     this.jLabel2 = new JLabel();
/* 184 */     this.jLabel3 = new JLabel();
/* 185 */     this.jLabel4 = new JLabel();
/* 186 */     this.jLabel5 = new JLabel();
/* 187 */     this.jLabPunaise = new JLabel();
/* 188 */     this.jLabFond = new JLabel();
/* 189 */     this.jLabCadre = new JLabel();
/* 190 */     this.jLabText = new JLabel();
/* 191 */     this.jLabel6 = new JLabel();
/* 192 */     this.jLabel7 = new JLabel();
/* 193 */     this.jPanel2 = new javax.swing.JPanel();
/* 194 */     this.jRBGauche = new javax.swing.JRadioButton();
/* 195 */     this.jRBCentre = new javax.swing.JRadioButton();
/* 196 */     this.jRBDroite = new javax.swing.JRadioButton();
/* 197 */     this.jCBTout = new javax.swing.JCheckBox();
/* 198 */     this.jCBDefaut = new javax.swing.JCheckBox();
/* 199 */     this.jBtValider = new javax.swing.JButton();
/* 200 */     this.jBtAnnuler = new javax.swing.JButton();
/*     */     
/* 202 */     setDefaultCloseOperation(2);
/* 203 */     setTitle("Note ou commentaire dans le post it");
/* 204 */     setResizable(false);
/* 205 */     addWindowListener(new java.awt.event.WindowAdapter() {
/*     */       public void windowOpened(java.awt.event.WindowEvent evt) {
/* 207 */         FormePostIt.this.formWindowOpened(evt);
/*     */       }
/*     */       
/* 210 */     });
/* 211 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 213 */     this.jPanelApercu.setBackground(new java.awt.Color(255, 255, 255));
/* 214 */     this.jPanelApercu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 216 */     javax.swing.GroupLayout jPanelApercuLayout = new javax.swing.GroupLayout(this.jPanelApercu);
/* 217 */     this.jPanelApercu.setLayout(jPanelApercuLayout);
/* 218 */     jPanelApercuLayout.setHorizontalGroup(jPanelApercuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 164, 32767));
/*     */     
/*     */ 
/*     */ 
/* 222 */     jPanelApercuLayout.setVerticalGroup(jPanelApercuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 140, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 227 */     this.jLabel1.setText("Aperçu");
/*     */     
/* 229 */     this.jTANote.setColumns(20);
/* 230 */     this.jTANote.setRows(5);
/* 231 */     this.jScrollPane1.setViewportView(this.jTANote);
/*     */     
/* 233 */     this.jLabel2.setText("Commentaire");
/*     */     
/* 235 */     this.jLabel3.setText("Punaise");
/* 236 */     this.jLabel3.setCursor(new java.awt.Cursor(0));
/* 237 */     this.jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 239 */         FormePostIt.this.jLabel3MouseClicked(evt);
/*     */       }
/*     */       
/* 242 */     });
/* 243 */     this.jLabel4.setText("Fond");
/* 244 */     this.jLabel4.setCursor(new java.awt.Cursor(12));
/* 245 */     this.jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 247 */         FormePostIt.this.jLabel4MouseClicked(evt);
/*     */       }
/*     */       
/* 250 */     });
/* 251 */     this.jLabel5.setText("Cadre");
/* 252 */     this.jLabel5.setCursor(new java.awt.Cursor(12));
/* 253 */     this.jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 255 */         FormePostIt.this.jLabel5MouseClicked(evt);
/*     */       }
/*     */       
/* 258 */     });
/* 259 */     this.jLabPunaise.setBackground(new java.awt.Color(255, 0, 0));
/* 260 */     this.jLabPunaise.setText("           ");
/* 261 */     this.jLabPunaise.setCursor(new java.awt.Cursor(12));
/* 262 */     this.jLabPunaise.setOpaque(true);
/* 263 */     this.jLabPunaise.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 265 */         FormePostIt.this.jLabPunaiseMouseClicked(evt);
/*     */       }
/*     */       
/* 268 */     });
/* 269 */     this.jLabFond.setBackground(new java.awt.Color(255, 255, 102));
/* 270 */     this.jLabFond.setText("           ");
/* 271 */     this.jLabFond.setCursor(new java.awt.Cursor(12));
/* 272 */     this.jLabFond.setOpaque(true);
/* 273 */     this.jLabFond.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 275 */         FormePostIt.this.jLabFondMouseClicked(evt);
/*     */       }
/*     */       
/* 278 */     });
/* 279 */     this.jLabCadre.setBackground(new java.awt.Color(0, 0, 0));
/* 280 */     this.jLabCadre.setText("           ");
/* 281 */     this.jLabCadre.setCursor(new java.awt.Cursor(12));
/* 282 */     this.jLabCadre.setOpaque(true);
/* 283 */     this.jLabCadre.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 285 */         FormePostIt.this.jLabCadreMouseClicked(evt);
/*     */       }
/*     */       
/* 288 */     });
/* 289 */     this.jLabText.setBackground(new java.awt.Color(0, 0, 0));
/* 290 */     this.jLabText.setText("           ");
/* 291 */     this.jLabText.setCursor(new java.awt.Cursor(12));
/* 292 */     this.jLabText.setOpaque(true);
/* 293 */     this.jLabText.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 295 */         FormePostIt.this.jLabTextMouseClicked(evt);
/*     */       }
/*     */       
/* 298 */     });
/* 299 */     this.jLabel6.setText("Texte");
/* 300 */     this.jLabel6.setCursor(new java.awt.Cursor(12));
/* 301 */     this.jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 303 */         FormePostIt.this.jLabel6MouseClicked(evt);
/*     */       }
/*     */       
/* 306 */     });
/* 307 */     this.jLabel7.setText("Aligner Texte");
/* 308 */     this.jLabel7.setCursor(new java.awt.Cursor(0));
/*     */     
/* 310 */     this.buttonGroup1.add(this.jRBGauche);
/* 311 */     this.jRBGauche.setText("GAUCHE");
/*     */     
/* 313 */     this.buttonGroup1.add(this.jRBCentre);
/* 314 */     this.jRBCentre.setText("CENTRE");
/*     */     
/* 316 */     this.buttonGroup1.add(this.jRBDroite);
/* 317 */     this.jRBDroite.setText("DROITE");
/*     */     
/* 319 */     javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this.jPanel2);
/* 320 */     this.jPanel2.setLayout(jPanel2Layout);
/* 321 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jRBGauche).addGap(41, 41, 41).addComponent(this.jRBCentre).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, 32767).addComponent(this.jRBDroite).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 332 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jRBGauche).addComponent(this.jRBDroite).addComponent(this.jRBCentre)).addContainerGap(11, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 343 */     this.jCBTout.setText("Appliquer les couleurs à tous les Postit");
/*     */     
/* 345 */     this.jCBDefaut.setText("Couleurs par défaut ");
/*     */     
/* 347 */     javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this.jPanel1);
/* 348 */     this.jPanel1.setLayout(jPanel1Layout);
/* 349 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jScrollPane1, -2, 421, -2).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel3, -2, 60, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabPunaise).addGap(81, 81, 81).addComponent(this.jLabel4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabFond).addGap(87, 87, 87).addComponent(this.jLabel5).addGap(18, 18, 18).addComponent(this.jLabCadre)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel7).addGap(26, 26, 26).addComponent(this.jPanel2, -2, -1, -2))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel6).addGap(18, 18, 18).addComponent(this.jLabText, -2, 41, -2).addGap(12, 12, 12)).addComponent(this.jPanelApercu, -1, -1, 32767)).addContainerGap()).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jCBTout).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, 32767).addComponent(this.jCBDefaut).addGap(99, 99, 99)))));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 390 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(15, 15, 15).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jLabel2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanelApercu, -1, -1, 32767).addComponent(this.jScrollPane1, -2, 142, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.jLabel5).addComponent(this.jLabFond).addComponent(this.jLabPunaise).addComponent(this.jLabCadre).addComponent(this.jLabText).addComponent(this.jLabel6)).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(41, 41, 41).addComponent(this.jLabel7)).addGroup(jPanel1Layout.createSequentialGroup().addGap(29, 29, 29).addComponent(this.jPanel2, -2, -1, -2))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jCBDefaut).addComponent(this.jCBTout)).addGap(25, 25, 25)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 425 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 426 */     this.jBtValider.setText("OK");
/* 427 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 429 */         FormePostIt.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 432 */     });
/* 433 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 434 */     this.jBtAnnuler.setText("Annuler");
/* 435 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 437 */         FormePostIt.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 440 */     });
/* 441 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/* 442 */     getContentPane().setLayout(layout);
/* 443 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jBtAnnuler, -2, 114, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtValider, -2, 95, -2))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 455 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 467 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt) {
/* 471 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(java.awt.event.ActionEvent evt) {
/* 475 */     String s = this.jTANote.getText().trim();
/* 476 */     s = s.replace("\n", "");
/* 477 */     if (s.length() == 0) {
/* 478 */       s = s + " Vos notes ou remarques ici \n";
/* 479 */       this.postIt.setCommentaire(s);
/* 480 */     } else { this.postIt.setCommentaire(this.jTANote.getText());
/*     */     }
/* 482 */     this.postIt.setClCadre(this.jLabCadre.getBackground());
/* 483 */     this.postIt.setClTexte(this.jLabText.getBackground());
/* 484 */     this.postIt.setClFond(this.jLabFond.getBackground());
/* 485 */     this.postIt.setClPunaise(this.jLabPunaise.getBackground());
/* 486 */     this.postIt.setAligner(getAligner());
/* 487 */     if (this.jCBDefaut.isSelected()) {
/* 488 */       appliquerDefaut();
/*     */     }
/* 490 */     if (this.jCBTout.isSelected()) {
/* 491 */       appliquerTout();
/*     */     }
/* 493 */     this.frm.getPage().repaint();
/* 494 */     dispose();
/*     */   }
/*     */   
/*     */   private void formWindowOpened(java.awt.event.WindowEvent evt)
/*     */   {
/* 499 */     paintGraphe(this.jPanelApercu.getGraphics());
/*     */   }
/*     */   
/*     */   private void jLabPunaiseMouseClicked(java.awt.event.MouseEvent evt) {
/* 503 */     this.jLabPunaise.setBackground(choixDeCouleur(this.jLabPunaise.getBackground(), "choix de couleur Punaise"));
/* 504 */     paintGraphe(this.jPanelApercu.getGraphics());
/*     */   }
/*     */   
/*     */   private void jLabFondMouseClicked(java.awt.event.MouseEvent evt) {
/* 508 */     this.jLabFond.setBackground(choixDeCouleur(this.jLabFond.getBackground(), "choix de couleur Fond"));
/* 509 */     paintGraphe(this.jPanelApercu.getGraphics());
/*     */   }
/*     */   
/*     */   private void jLabCadreMouseClicked(java.awt.event.MouseEvent evt) {
/* 513 */     this.jLabCadre.setBackground(choixDeCouleur(this.jLabCadre.getBackground(), "choix de couleur Cadre"));
/* 514 */     paintGraphe(this.jPanelApercu.getGraphics());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {}
/*     */   
/*     */ 
/*     */ 
/*     */   private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {}
/*     */   
/*     */ 
/*     */ 
/*     */   private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {}
/*     */   
/*     */ 
/*     */ 
/*     */   private void jLabTextMouseClicked(java.awt.event.MouseEvent evt)
/*     */   {
/* 533 */     this.jLabText.setBackground(choixDeCouleur(this.jLabText.getBackground(), "choix de couleur Texte"));
/* 534 */     paintGraphe(this.jPanelApercu.getGraphics());
/*     */   }
/*     */   
/*     */   private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {}
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormePostIt.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */