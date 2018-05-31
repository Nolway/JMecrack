/*      */ package formes;
/*      */ 
/*      */ import ihm.FormeInterneMCD;
/*      */ import java.awt.Color;
/*      */ import java.awt.event.MouseEvent;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.GroupLayout.Alignment;
/*      */ import javax.swing.GroupLayout.ParallelGroup;
/*      */ import javax.swing.GroupLayout.SequentialGroup;
/*      */ import javax.swing.JLabel;
/*      */ 
/*      */ public class FormeColor extends javax.swing.JDialog
/*      */ {
/*      */   private PanelApercu panAp;
/*      */   private IhmMCD.IhmPageMCD ihmpan;
/*      */   private boolean petitCareau;
/*      */   private ihm.Principale frm;
/*      */   private javax.swing.ButtonGroup buttonGroup1;
/*      */   private javax.swing.JButton jButton3;
/*      */   private javax.swing.JButton jButton4;
/*      */   private javax.swing.JCheckBox jCBPetitCarreau;
/*      */   private JLabel jLabClCIFCadre;
/*      */   private JLabel jLabClCIFFond;
/*      */   private JLabel jLabClCIFTexte;
/*      */   private JLabel jLabClContrainteCadre;
/*      */   private JLabel jLabClContrainteFond;
/*      */   private JLabel jLabClContrainteTexte;
/*      */   private JLabel jLabClEntiteCadre;
/*      */   private JLabel jLabClEntiteFond;
/*      */   private JLabel jLabClEntiteTexte;
/*      */   private JLabel jLabClLien;
/*      */   private JLabel jLabClLienCnt;
/*      */   private JLabel jLabClLienTexte;
/*      */   private JLabel jLabClRelationCadre;
/*      */   private JLabel jLabClRelationFond;
/*      */   private JLabel jLabClRelationTexte;
/*      */   private JLabel jLabel1;
/*      */   private JLabel jLabel10;
/*      */   private JLabel jLabel14;
/*      */   private JLabel jLabel19;
/*      */   private JLabel jLabel21;
/*      */   
/*      */   public FormeColor(ihm.Principale parent, boolean modal, IhmMCD.IhmPageMCD ihmpan)
/*      */   {
/*   45 */     super(parent, modal);
/*   46 */     this.frm = parent;
/*   47 */     initComponents();
/*   48 */     setLocation(parent.getX() + 250, parent.getY() + 150);
/*   49 */     this.panAp = new PanelApercu(FormeInterneMCD.clEntiteCadre, FormeInterneMCD.clEntiteFond, FormeInterneMCD.clEntiteText, FormeInterneMCD.clRelationCadre, FormeInterneMCD.clRelationFond, FormeInterneMCD.clRelationText, FormeInterneMCD.clCIFCadre, FormeInterneMCD.clCIFFond, FormeInterneMCD.clCIFText, FormeInterneMCD.clContrainteCadre, FormeInterneMCD.clContrainteFond, FormeInterneMCD.clContrainteText, FormeInterneMCD.clLien, FormeInterneMCD.clLienCnt, FormeInterneMCD.clString, ihmpan.getFrm().getBar().isAfficheRegle());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*   54 */     this.panAp.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*   55 */     this.panAp.setSize((int)this.jPanel1.getSize().getWidth(), (int)this.jPanel1.getSize().getHeight());
/*   56 */     this.panAp.setBackground(Color.WHITE);
/*   57 */     this.jPanel1.add(this.panAp);
/*   58 */     initialiserFenetre();
/*   59 */     this.ihmpan = ihmpan;
/*   60 */     this.petitCareau = Outil.Setting.petitCarreau;
/*   61 */     this.jCBPetitCarreau.setSelected(Outil.Setting.petitCarreau);
/*   62 */     this.jButton4.setMnemonic(10);
/*   63 */     this.jButton3.setMnemonic(65);
/*      */   }
/*      */   
/*      */   private void initialiserFenetre() {
/*   67 */     if ((FormeInterneMCD.etatColor.equals(Outil.Parametres.etatDefautColor)) || (FormeInterneMCD.etatColor.equals(Outil.Parametres.etatAUCUNEColor)))
/*      */     {
/*   69 */       this.jLabClEntiteCadre.setEnabled(false);
/*   70 */       this.jLabClEntiteFond.setEnabled(false);
/*   71 */       this.jLabClEntiteTexte.setEnabled(false);
/*      */       
/*   73 */       this.jLabClLienTexte.setEnabled(false);
/*   74 */       this.jLabClLienCnt.setEnabled(false);
/*   75 */       this.jLabClLienTexte.setEnabled(false);
/*      */       
/*   77 */       this.jLabClRelationCadre.setEnabled(false);
/*   78 */       this.jLabClRelationFond.setEnabled(false);
/*   79 */       this.jLabClRelationTexte.setEnabled(false);
/*      */       
/*   81 */       this.jLabClContrainteCadre.setEnabled(false);
/*   82 */       this.jLabClContrainteFond.setEnabled(false);
/*   83 */       this.jLabClContrainteTexte.setEnabled(false);
/*      */       
/*   85 */       this.jLabClCIFCadre.setEnabled(false);
/*   86 */       this.jLabClCIFFond.setEnabled(false);
/*   87 */       this.jLabClCIFTexte.setEnabled(false);
/*      */       
/*   89 */       this.jLabClLien.setEnabled(false);
/*   90 */       this.jLabClLienTexte.setEnabled(false);
/*   91 */       this.jLabClLienCnt.setEnabled(false);
/*      */     }
/*      */     
/*   94 */     if (FormeInterneMCD.etatColor.equals(Outil.Parametres.etatDefautColor)) {
/*   95 */       this.jRadioDefaut.setSelected(true);
/*      */     }
/*   97 */     if (FormeInterneMCD.etatColor.equals(Outil.Parametres.etatAUCUNEColor)) {
/*   98 */       this.jRadioAucune.setSelected(true);
/*      */     }
/*  100 */     if (FormeInterneMCD.etatColor.equals(Outil.Parametres.etatAVECColor)) {
/*  101 */       this.jRadioChoix.setSelected(true);
/*  102 */       initialiserColorFenetre();
/*      */     }
/*      */   }
/*      */   
/*      */   private Color couleurs(String cl)
/*      */   {
/*  108 */     return new Color(Integer.parseInt(cl));
/*      */   }
/*      */   
/*      */   private String getCouleurSt(Color cl) {
/*  112 */     return cl.getRGB() + "";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void initialiserColorFenetre()
/*      */   {
/*  119 */     this.jLabClCIFCadre.setBackground(FormeInterneMCD.clCIFCadre);
/*  120 */     this.jLabClCIFFond.setBackground(FormeInterneMCD.clCIFFond);
/*  121 */     this.jLabClCIFTexte.setBackground(FormeInterneMCD.clCIFText);
/*      */     
/*  123 */     this.jLabClContrainteCadre.setBackground(FormeInterneMCD.clContrainteCadre);
/*  124 */     this.jLabClContrainteFond.setBackground(FormeInterneMCD.clContrainteFond);
/*  125 */     this.jLabClContrainteTexte.setBackground(FormeInterneMCD.clContrainteText);
/*      */     
/*  127 */     this.jLabClEntiteCadre.setBackground(FormeInterneMCD.clEntiteCadre);
/*  128 */     this.jLabClEntiteFond.setBackground(FormeInterneMCD.clEntiteFond);
/*  129 */     this.jLabClEntiteTexte.setBackground(FormeInterneMCD.clEntiteText);
/*      */     
/*  131 */     this.jLabClRelationCadre.setBackground(FormeInterneMCD.clRelationCadre);
/*  132 */     this.jLabClRelationFond.setBackground(FormeInterneMCD.clRelationFond);
/*  133 */     this.jLabClRelationTexte.setBackground(FormeInterneMCD.clRelationText);
/*      */     
/*  135 */     this.jLabClLien.setBackground(FormeInterneMCD.clLien);
/*  136 */     this.jLabClLienCnt.setBackground(FormeInterneMCD.clLienCnt);
/*  137 */     this.jLabClLienTexte.setBackground(FormeInterneMCD.clString);
/*      */   }
/*      */   
/*      */   private void setAllColor()
/*      */   {
/*  142 */     IhmMCD.IhmRelation.setClRelationCadre(FormeInterneMCD.clRelationCadre);
/*  143 */     IhmMCD.IhmRelation.setClRelationFond(FormeInterneMCD.clRelationFond);
/*  144 */     IhmMCD.IhmRelation.setClString(FormeInterneMCD.clRelationText);
/*      */     
/*  146 */     IhmMCD.IhmHeritage.setClRelationCadre(FormeInterneMCD.clRelationCadre);
/*  147 */     IhmMCD.IhmHeritage.setClRelationFond(FormeInterneMCD.clRelationFond);
/*  148 */     IhmMCD.IhmHeritage.setClString(FormeInterneMCD.clRelationText);
/*      */     
/*  150 */     IhmMCD.IhmEntite.setClEntiteCadre(FormeInterneMCD.clEntiteCadre);
/*  151 */     IhmMCD.IhmEntite.setClEntiteFond(FormeInterneMCD.clEntiteFond);
/*  152 */     IhmMCD.IhmEntite.setClString(FormeInterneMCD.clEntiteText);
/*      */     
/*  154 */     IhmMCD.IhmLien.setClLien(FormeInterneMCD.clLien);
/*  155 */     IhmMCD.IhmLien.setClLienText(FormeInterneMCD.clString);
/*  156 */     IhmMCD.IhmLienContraintes.setClLien(FormeInterneMCD.clLienCnt);
/*      */     
/*  158 */     IhmMCD.IhmCIF.setClCIFCadre(FormeInterneMCD.clCIFCadre);
/*  159 */     IhmMCD.IhmCIF.setClCIFFond(FormeInterneMCD.clCIFFond);
/*  160 */     IhmMCD.IhmCIF.setClString(FormeInterneMCD.clCIFText);
/*      */     
/*  162 */     IhmMCD.IhmContrainte.setClContrainteCadre(FormeInterneMCD.clContrainteCadre);
/*  163 */     IhmMCD.IhmContrainte.setClContrainteFond(FormeInterneMCD.clContrainteFond);
/*  164 */     IhmMCD.IhmContrainte.setClString(FormeInterneMCD.clContrainteText);
/*      */     
/*  166 */     IhmMCD.IhmLienHeritage.setClLien(FormeInterneMCD.clLien);
/*  167 */     IhmMCD.IhmLienCif.setClLien(FormeInterneMCD.clLienCnt);
/*  168 */     IhmMCD.IhmLienContrainteHeritage.setClLien(FormeInterneMCD.clLien);
/*      */   }
/*      */   
/*      */   private JLabel jLabel23;
/*      */   private JLabel jLabel25;
/*      */   private JLabel jLabel27;
/*      */   private JLabel jLabel28;
/*      */   private JLabel jLabel3;
/*      */   private JLabel jLabel30;
/*      */   private JLabel jLabel32;
/*      */   
/*      */   private void initComponents() {
/*  180 */     this.buttonGroup1 = new javax.swing.ButtonGroup();
/*  181 */     this.jButton4 = new javax.swing.JButton();
/*  182 */     this.jButton3 = new javax.swing.JButton();
/*  183 */     this.jPanel2 = new javax.swing.JPanel();
/*  184 */     this.jLabel3 = new JLabel();
/*  185 */     this.jLabel4 = new JLabel();
/*  186 */     this.jLabel19 = new JLabel();
/*  187 */     this.jPanel5 = new javax.swing.JPanel();
/*  188 */     this.jLabClEntiteCadre = new JLabel();
/*  189 */     this.jLabel23 = new JLabel();
/*  190 */     this.jLabClEntiteFond = new JLabel();
/*  191 */     this.jLabel25 = new JLabel();
/*  192 */     this.jLabClEntiteTexte = new JLabel();
/*  193 */     this.jLabel27 = new JLabel();
/*  194 */     this.jPanel6 = new javax.swing.JPanel();
/*  195 */     this.jLabClRelationCadre = new JLabel();
/*  196 */     this.jLabel28 = new JLabel();
/*  197 */     this.jLabClRelationFond = new JLabel();
/*  198 */     this.jLabel30 = new JLabel();
/*  199 */     this.jLabClRelationTexte = new JLabel();
/*  200 */     this.jLabel32 = new JLabel();
/*  201 */     this.jPanel7 = new javax.swing.JPanel();
/*  202 */     this.jLabel33 = new JLabel();
/*  203 */     this.jLabClLien = new JLabel();
/*  204 */     this.jLabClLienTexte = new JLabel();
/*  205 */     this.jLabel37 = new JLabel();
/*  206 */     this.jPanel1 = new javax.swing.JPanel();
/*  207 */     this.jLabel1 = new JLabel();
/*  208 */     this.jPanel3 = new javax.swing.JPanel();
/*  209 */     this.jRadioChoix = new javax.swing.JRadioButton();
/*  210 */     this.jRadioAucune = new javax.swing.JRadioButton();
/*  211 */     this.jRadioDefaut = new javax.swing.JRadioButton();
/*  212 */     this.jPanel4 = new javax.swing.JPanel();
/*  213 */     this.jLabel10 = new JLabel();
/*  214 */     this.jLabel14 = new JLabel();
/*  215 */     this.jLabel21 = new JLabel();
/*  216 */     this.jPanel8 = new javax.swing.JPanel();
/*  217 */     this.jLabClContrainteCadre = new JLabel();
/*  218 */     this.jLabel35 = new JLabel();
/*  219 */     this.jLabClContrainteFond = new JLabel();
/*  220 */     this.jLabel39 = new JLabel();
/*  221 */     this.jLabClContrainteTexte = new JLabel();
/*  222 */     this.jLabel41 = new JLabel();
/*  223 */     this.jPanel9 = new javax.swing.JPanel();
/*  224 */     this.jLabClCIFCadre = new JLabel();
/*  225 */     this.jLabel42 = new JLabel();
/*  226 */     this.jLabClCIFFond = new JLabel();
/*  227 */     this.jLabel44 = new JLabel();
/*  228 */     this.jLabClCIFTexte = new JLabel();
/*  229 */     this.jLabel46 = new JLabel();
/*  230 */     this.jPanel10 = new javax.swing.JPanel();
/*  231 */     this.jLabClLienCnt = new JLabel();
/*  232 */     this.jCBPetitCarreau = new javax.swing.JCheckBox();
/*      */     
/*  234 */     setDefaultCloseOperation(2);
/*  235 */     setTitle("Couleurs");
/*  236 */     setResizable(false);
/*      */     
/*  238 */     this.jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/*  239 */     this.jButton4.setText("OK");
/*  240 */     this.jButton4.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  242 */         FormeColor.this.jButton4ActionPerformed(evt);
/*      */       }
/*      */       
/*  245 */     });
/*  246 */     this.jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/*  247 */     this.jButton3.setText("Annuler");
/*  248 */     this.jButton3.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  250 */         FormeColor.this.jButton3ActionPerformed(evt);
/*      */       }
/*      */       
/*  253 */     });
/*  254 */     this.jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  256 */     this.jLabel3.setText("Entité :");
/*      */     
/*  258 */     this.jLabel4.setText("Relations :");
/*      */     
/*  260 */     this.jLabel19.setText("Liens :");
/*      */     
/*  262 */     this.jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  264 */     this.jLabClEntiteCadre.setBackground(new Color(0, 51, 255));
/*  265 */     this.jLabClEntiteCadre.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/*  266 */     this.jLabClEntiteCadre.setOpaque(true);
/*      */     
/*  268 */     this.jLabel23.setForeground(new Color(51, 0, 204));
/*  269 */     this.jLabel23.setText("Fond");
/*  270 */     this.jLabel23.setCursor(new java.awt.Cursor(12));
/*  271 */     this.jLabel23.setHorizontalTextPosition(0);
/*  272 */     this.jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  274 */         FormeColor.this.jLabel23MouseClicked(evt);
/*      */       }
/*      */       
/*  277 */     });
/*  278 */     this.jLabClEntiteFond.setBackground(new Color(255, 153, 51));
/*  279 */     this.jLabClEntiteFond.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/*  280 */     this.jLabClEntiteFond.setOpaque(true);
/*      */     
/*  282 */     this.jLabel25.setForeground(new Color(51, 0, 204));
/*  283 */     this.jLabel25.setText("Cadre");
/*  284 */     this.jLabel25.setCursor(new java.awt.Cursor(12));
/*  285 */     this.jLabel25.setHorizontalTextPosition(0);
/*  286 */     this.jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  288 */         FormeColor.this.jLabel25MouseClicked(evt);
/*      */       }
/*  290 */     });
/*  291 */     this.jLabel25.addKeyListener(new java.awt.event.KeyAdapter() {
/*      */       public void keyPressed(java.awt.event.KeyEvent evt) {
/*  293 */         FormeColor.this.jLabel25KeyPressed(evt);
/*      */       }
/*      */       
/*  296 */     });
/*  297 */     this.jLabClEntiteTexte.setBackground(new Color(0, 0, 0));
/*  298 */     this.jLabClEntiteTexte.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/*  299 */     this.jLabClEntiteTexte.setOpaque(true);
/*      */     
/*  301 */     this.jLabel27.setForeground(new Color(51, 0, 204));
/*  302 */     this.jLabel27.setText("Texte");
/*  303 */     this.jLabel27.setCursor(new java.awt.Cursor(12));
/*  304 */     this.jLabel27.setHorizontalTextPosition(0);
/*  305 */     this.jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  307 */         FormeColor.this.jLabel27MouseClicked(evt);
/*      */       }
/*      */       
/*  310 */     });
/*  311 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  312 */     this.jPanel5.setLayout(jPanel5Layout);
/*  313 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel25, -1, -1, 32767).addComponent(this.jLabClEntiteCadre, -1, 62, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel23, -1, -1, 32767).addComponent(this.jLabClEntiteFond, -1, 58, 32767)).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel5Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabClEntiteTexte, -2, 67, -2)).addGroup(jPanel5Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel27, -1, -1, 32767))).addGap(192, 192, 192)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  333 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel23).addComponent(this.jLabel25).addComponent(this.jLabel27)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabClEntiteTexte, -1, 17, 32767).addComponent(this.jLabClEntiteFond, -1, 17, 32767).addComponent(this.jLabClEntiteCadre, -1, 17, 32767)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  349 */     this.jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  351 */     this.jLabClRelationCadre.setBackground(new Color(0, 51, 255));
/*  352 */     this.jLabClRelationCadre.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/*  353 */     this.jLabClRelationCadre.setOpaque(true);
/*      */     
/*  355 */     this.jLabel28.setForeground(new Color(51, 0, 204));
/*  356 */     this.jLabel28.setText("Fond");
/*  357 */     this.jLabel28.setCursor(new java.awt.Cursor(12));
/*  358 */     this.jLabel28.setHorizontalTextPosition(0);
/*  359 */     this.jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  361 */         FormeColor.this.jLabel28MouseClicked(evt);
/*      */       }
/*      */       
/*  364 */     });
/*  365 */     this.jLabClRelationFond.setBackground(new Color(0, 153, 51));
/*  366 */     this.jLabClRelationFond.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/*  367 */     this.jLabClRelationFond.setOpaque(true);
/*      */     
/*  369 */     this.jLabel30.setForeground(new Color(51, 0, 204));
/*  370 */     this.jLabel30.setText("Cadre");
/*  371 */     this.jLabel30.setCursor(new java.awt.Cursor(12));
/*  372 */     this.jLabel30.setHorizontalTextPosition(0);
/*  373 */     this.jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  375 */         FormeColor.this.jLabel30MouseClicked(evt);
/*      */       }
/*      */       
/*  378 */     });
/*  379 */     this.jLabClRelationTexte.setBackground(new Color(0, 0, 0));
/*  380 */     this.jLabClRelationTexte.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/*  381 */     this.jLabClRelationTexte.setOpaque(true);
/*      */     
/*  383 */     this.jLabel32.setForeground(new Color(51, 0, 204));
/*  384 */     this.jLabel32.setText("Texte");
/*  385 */     this.jLabel32.setCursor(new java.awt.Cursor(12));
/*  386 */     this.jLabel32.setHorizontalTextPosition(0);
/*  387 */     this.jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  389 */         FormeColor.this.jLabel32MouseClicked(evt);
/*      */       }
/*      */       
/*  392 */     });
/*  393 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  394 */     this.jPanel6.setLayout(jPanel6Layout);
/*  395 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel30, -1, -1, 32767).addComponent(this.jLabClRelationCadre, -1, 62, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel28, -1, -1, 32767).addComponent(this.jLabClRelationFond, -1, 58, 32767)).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel6Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabClRelationTexte, -2, 67, -2)).addGroup(jPanel6Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel32, -1, -1, 32767))).addGap(192, 192, 192)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  415 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel28).addComponent(this.jLabel30).addComponent(this.jLabel32)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabClRelationTexte, -1, 17, 32767).addComponent(this.jLabClRelationFond, -1, 17, 32767).addComponent(this.jLabClRelationCadre, -1, 17, 32767)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  431 */     this.jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  433 */     this.jLabel33.setForeground(new Color(51, 0, 204));
/*  434 */     this.jLabel33.setText("Lien");
/*  435 */     this.jLabel33.setCursor(new java.awt.Cursor(12));
/*  436 */     this.jLabel33.setHorizontalTextPosition(0);
/*  437 */     this.jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  439 */         FormeColor.this.jLabel33MouseClicked(evt);
/*      */       }
/*      */       
/*  442 */     });
/*  443 */     this.jLabClLien.setBackground(new Color(0, 51, 255));
/*  444 */     this.jLabClLien.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/*  445 */     this.jLabClLien.setOpaque(true);
/*      */     
/*  447 */     this.jLabClLienTexte.setBackground(new Color(0, 0, 0));
/*  448 */     this.jLabClLienTexte.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/*  449 */     this.jLabClLienTexte.setOpaque(true);
/*      */     
/*  451 */     this.jLabel37.setForeground(new Color(51, 0, 204));
/*  452 */     this.jLabel37.setText("Texte");
/*  453 */     this.jLabel37.setCursor(new java.awt.Cursor(12));
/*  454 */     this.jLabel37.setHorizontalTextPosition(0);
/*  455 */     this.jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  457 */         FormeColor.this.jLabel37MouseClicked(evt);
/*      */       }
/*      */       
/*  460 */     });
/*  461 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  462 */     this.jPanel7.setLayout(jPanel7Layout);
/*  463 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel33, -1, -1, 32767).addComponent(this.jLabClLien, -1, 58, 32767)).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel7Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabClLienTexte, -2, 67, -2)).addGroup(jPanel7Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel37, -1, -1, 32767))).addGap(192, 192, 192)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  479 */     jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel33).addComponent(this.jLabel37)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabClLienTexte, -1, 17, 32767).addComponent(this.jLabClLien, -1, 17, 32767)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  493 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  494 */     this.jPanel2.setLayout(jPanel2Layout);
/*  495 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel19, GroupLayout.Alignment.LEADING).addComponent(this.jLabel4, GroupLayout.Alignment.LEADING).addComponent(this.jLabel3, GroupLayout.Alignment.LEADING, -2, 51, -2).addComponent(this.jPanel6, GroupLayout.Alignment.LEADING, 0, 225, 32767).addComponent(this.jPanel5, GroupLayout.Alignment.LEADING, 0, 225, 32767).addComponent(this.jPanel7, GroupLayout.Alignment.LEADING, -2, 216, -2)).addContainerGap(-1, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  508 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel4).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel6, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jLabel19).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel7, -2, -1, -2).addContainerGap(13, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  526 */     this.jPanel1.setBackground(new Color(255, 255, 255));
/*  527 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  529 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  530 */     this.jPanel1.setLayout(jPanel1Layout);
/*  531 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 223, 32767));
/*      */     
/*      */ 
/*      */ 
/*  535 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 224, 32767));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  540 */     this.jLabel1.setText("Apercu :");
/*      */     
/*  542 */     this.jPanel3.setBackground(new Color(204, 204, 204));
/*  543 */     this.jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  545 */     this.jRadioChoix.setBackground(new Color(204, 204, 204));
/*  546 */     this.buttonGroup1.add(this.jRadioChoix);
/*  547 */     this.jRadioChoix.setSelected(true);
/*  548 */     this.jRadioChoix.setText("Choix");
/*  549 */     this.jRadioChoix.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  551 */         FormeColor.this.jRadioChoixActionPerformed(evt);
/*      */       }
/*      */       
/*  554 */     });
/*  555 */     this.jRadioAucune.setBackground(new Color(204, 204, 204));
/*  556 */     this.buttonGroup1.add(this.jRadioAucune);
/*  557 */     this.jRadioAucune.setText("Aucune");
/*  558 */     this.jRadioAucune.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  560 */         FormeColor.this.jRadioAucuneActionPerformed(evt);
/*      */       }
/*      */       
/*  563 */     });
/*  564 */     this.jRadioDefaut.setBackground(new Color(204, 204, 204));
/*  565 */     this.buttonGroup1.add(this.jRadioDefaut);
/*  566 */     this.jRadioDefaut.setText("Defaut");
/*  567 */     this.jRadioDefaut.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  569 */         FormeColor.this.jRadioDefautActionPerformed(evt);
/*      */       }
/*      */       
/*  572 */     });
/*  573 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  574 */     this.jPanel3.setLayout(jPanel3Layout);
/*  575 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jRadioChoix, -2, 64, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jRadioDefaut).addGap(18, 18, 18).addComponent(this.jRadioAucune).addContainerGap(13, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  586 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRadioChoix, -2, 16, -2).addComponent(this.jRadioDefaut).addComponent(this.jRadioAucune)).addContainerGap(14, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  597 */     this.jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  599 */     this.jLabel10.setText("Contaraintes : ");
/*  600 */     this.jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  602 */         FormeColor.this.jLabel10MouseClicked(evt);
/*      */       }
/*      */       
/*  605 */     });
/*  606 */     this.jLabel14.setText("CIF :");
/*      */     
/*  608 */     this.jLabel21.setForeground(new Color(51, 0, 204));
/*  609 */     this.jLabel21.setText("Lien Contrainte ");
/*  610 */     this.jLabel21.setCursor(new java.awt.Cursor(12));
/*  611 */     this.jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  613 */         FormeColor.this.jLabel21MouseClicked(evt);
/*      */       }
/*      */       
/*  616 */     });
/*  617 */     this.jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  619 */     this.jLabClContrainteCadre.setBackground(new Color(0, 51, 204));
/*  620 */     this.jLabClContrainteCadre.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/*  621 */     this.jLabClContrainteCadre.setOpaque(true);
/*      */     
/*  623 */     this.jLabel35.setForeground(new Color(51, 0, 204));
/*  624 */     this.jLabel35.setText("Fond");
/*  625 */     this.jLabel35.setCursor(new java.awt.Cursor(12));
/*  626 */     this.jLabel35.setHorizontalTextPosition(0);
/*  627 */     this.jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  629 */         FormeColor.this.jLabel35MouseClicked(evt);
/*      */       }
/*      */       
/*  632 */     });
/*  633 */     this.jLabClContrainteFond.setBackground(new Color(255, 255, 0));
/*  634 */     this.jLabClContrainteFond.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/*  635 */     this.jLabClContrainteFond.setOpaque(true);
/*      */     
/*  637 */     this.jLabel39.setForeground(new Color(51, 0, 204));
/*  638 */     this.jLabel39.setText("Cadre");
/*  639 */     this.jLabel39.setCursor(new java.awt.Cursor(12));
/*  640 */     this.jLabel39.setHorizontalTextPosition(0);
/*  641 */     this.jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  643 */         FormeColor.this.jLabel39MouseClicked(evt);
/*      */       }
/*      */       
/*  646 */     });
/*  647 */     this.jLabClContrainteTexte.setBackground(new Color(0, 0, 0));
/*  648 */     this.jLabClContrainteTexte.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/*  649 */     this.jLabClContrainteTexte.setOpaque(true);
/*      */     
/*  651 */     this.jLabel41.setForeground(new Color(51, 0, 204));
/*  652 */     this.jLabel41.setText("Texte");
/*  653 */     this.jLabel41.setCursor(new java.awt.Cursor(12));
/*  654 */     this.jLabel41.setHorizontalTextPosition(0);
/*  655 */     this.jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  657 */         FormeColor.this.jLabel41MouseClicked(evt);
/*      */       }
/*      */       
/*  660 */     });
/*  661 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/*  662 */     this.jPanel8.setLayout(jPanel8Layout);
/*  663 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel39, -1, -1, 32767).addComponent(this.jLabClContrainteCadre, -1, 62, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel35, -1, -1, 32767).addComponent(this.jLabClContrainteFond, -1, 58, 32767)).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel8Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabClContrainteTexte, -2, 67, -2)).addGroup(jPanel8Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel41, -1, -1, 32767))).addGap(192, 192, 192)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  683 */     jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel35).addComponent(this.jLabel39).addComponent(this.jLabel41)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabClContrainteTexte, -1, 17, 32767).addComponent(this.jLabClContrainteFond, -1, 17, 32767).addComponent(this.jLabClContrainteCadre, -1, 17, 32767)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  699 */     this.jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  701 */     this.jLabClCIFCadre.setBackground(new Color(0, 51, 204));
/*  702 */     this.jLabClCIFCadre.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/*  703 */     this.jLabClCIFCadre.setOpaque(true);
/*      */     
/*  705 */     this.jLabel42.setForeground(new Color(51, 0, 204));
/*  706 */     this.jLabel42.setText("Fond");
/*  707 */     this.jLabel42.setCursor(new java.awt.Cursor(12));
/*  708 */     this.jLabel42.setHorizontalTextPosition(0);
/*  709 */     this.jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  711 */         FormeColor.this.jLabel42MouseClicked(evt);
/*      */       }
/*      */       
/*  714 */     });
/*  715 */     this.jLabClCIFFond.setBackground(new Color(255, 51, 0));
/*  716 */     this.jLabClCIFFond.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/*  717 */     this.jLabClCIFFond.setOpaque(true);
/*      */     
/*  719 */     this.jLabel44.setForeground(new Color(51, 0, 204));
/*  720 */     this.jLabel44.setText("Cadre");
/*  721 */     this.jLabel44.setCursor(new java.awt.Cursor(12));
/*  722 */     this.jLabel44.setHorizontalTextPosition(0);
/*  723 */     this.jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  725 */         FormeColor.this.jLabel44MouseClicked(evt);
/*      */       }
/*      */       
/*  728 */     });
/*  729 */     this.jLabClCIFTexte.setBackground(new Color(0, 0, 0));
/*  730 */     this.jLabClCIFTexte.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/*  731 */     this.jLabClCIFTexte.setOpaque(true);
/*      */     
/*  733 */     this.jLabel46.setForeground(new Color(51, 0, 204));
/*  734 */     this.jLabel46.setText("Texte");
/*  735 */     this.jLabel46.setCursor(new java.awt.Cursor(12));
/*  736 */     this.jLabel46.setHorizontalTextPosition(0);
/*  737 */     this.jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  739 */         FormeColor.this.jLabel46MouseClicked(evt);
/*      */       }
/*      */       
/*  742 */     });
/*  743 */     GroupLayout jPanel9Layout = new GroupLayout(this.jPanel9);
/*  744 */     this.jPanel9.setLayout(jPanel9Layout);
/*  745 */     jPanel9Layout.setHorizontalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup().addContainerGap().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel44, -1, -1, 32767).addComponent(this.jLabClCIFCadre, -1, 62, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel42, -1, -1, 32767).addComponent(this.jLabClCIFFond, -1, 58, 32767)).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel9Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabClCIFTexte, -2, 67, -2)).addGroup(jPanel9Layout.createSequentialGroup().addGap(10, 10, 10).addComponent(this.jLabel46, -1, -1, 32767))).addGap(192, 192, 192)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  765 */     jPanel9Layout.setVerticalGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup().addContainerGap().addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel42).addComponent(this.jLabel44).addComponent(this.jLabel46)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel9Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabClCIFTexte, -1, 17, 32767).addComponent(this.jLabClCIFFond, -1, 17, 32767).addComponent(this.jLabClCIFCadre, -1, 17, 32767)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  781 */     this.jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/*  783 */     this.jLabClLienCnt.setBackground(new Color(0, 51, 204));
/*  784 */     this.jLabClLienCnt.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(153, 153, 153)));
/*  785 */     this.jLabClLienCnt.setOpaque(true);
/*      */     
/*  787 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/*  788 */     this.jPanel10.setLayout(jPanel10Layout);
/*  789 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabClLienCnt, -2, 62, -2).addContainerGap(45, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  796 */     jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabClLienCnt, -1, 19, 32767).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  804 */     this.jCBPetitCarreau.setText("Arrière plan en petit carreau.");
/*  805 */     this.jCBPetitCarreau.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  807 */         FormeColor.this.jCBPetitCarreauActionPerformed(evt);
/*      */       }
/*      */       
/*  810 */     });
/*  811 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  812 */     this.jPanel4.setLayout(jPanel4Layout);
/*  813 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel10, -2, 89, -2).addComponent(this.jPanel8, -2, 225, -2).addGroup(jPanel4Layout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.jLabel21, -2, 89, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel10, -2, -1, -2))).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(jPanel4Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel14, -2, 72, -2).addComponent(this.jPanel9, -2, 225, -2)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jCBPetitCarreau).addGap(29, 29, 29)))));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  837 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10).addComponent(this.jLabel14)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel9, -2, -1, -2).addComponent(this.jPanel8, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBPetitCarreau).addComponent(this.jLabel21)).addGap(22, 22, 22)).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addComponent(this.jPanel10, -2, -1, -2).addContainerGap()))));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  860 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  861 */     getContentPane().setLayout(layout);
/*  862 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel4, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1, -2, 54, -2).addComponent(this.jPanel3, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767))).addGroup(layout.createSequentialGroup().addComponent(this.jButton3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton4, -2, 79, -2))).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  881 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel3, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -1, -1, 32767)).addComponent(this.jPanel2, -1, -1, 32767)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel4, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton4).addComponent(this.jButton3)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  902 */     pack();
/*      */   }
/*      */   
/*      */   private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
/*  906 */     if (this.jRadioChoix.isSelected()) {
/*  907 */       FormeInterneMCD.clEntiteCadre = this.jLabClEntiteCadre.getBackground();
/*  908 */       FormeInterneMCD.clEntiteFond = this.jLabClEntiteFond.getBackground();
/*  909 */       FormeInterneMCD.clEntiteText = this.jLabClEntiteTexte.getBackground();
/*      */       
/*  911 */       FormeInterneMCD.clRelationCadre = this.jLabClRelationCadre.getBackground();
/*  912 */       FormeInterneMCD.clRelationFond = this.jLabClRelationFond.getBackground();
/*  913 */       FormeInterneMCD.clRelationText = this.jLabClRelationTexte.getBackground();
/*      */       
/*  915 */       FormeInterneMCD.clCIFCadre = this.jLabClCIFCadre.getBackground();
/*  916 */       FormeInterneMCD.clCIFFond = this.jLabClCIFFond.getBackground();
/*  917 */       FormeInterneMCD.clCIFText = this.jLabClCIFTexte.getBackground();
/*      */       
/*  919 */       FormeInterneMCD.clContrainteCadre = this.jLabClContrainteCadre.getBackground();
/*  920 */       FormeInterneMCD.clContrainteFond = this.jLabClContrainteFond.getBackground();
/*  921 */       FormeInterneMCD.clContrainteText = this.jLabClContrainteTexte.getBackground();
/*      */       
/*  923 */       FormeInterneMCD.clLien = this.jLabClLien.getBackground();
/*  924 */       FormeInterneMCD.clLienCnt = this.jLabClLienCnt.getBackground();
/*  925 */       FormeInterneMCD.clString = this.jLabClLienTexte.getBackground();
/*      */     }
/*      */     
/*  928 */     if (this.jRadioDefaut.isSelected()) {
/*  929 */       FormeInterneMCD.initialiserDefaultColor();
/*  930 */       FormeInterneMCD.etatColor = Outil.Parametres.etatDefautColor;
/*      */     }
/*  932 */     if (this.jRadioAucune.isSelected()) {
/*  933 */       FormeInterneMCD.initialiserAucuneColor();
/*  934 */       FormeInterneMCD.etatColor = Outil.Parametres.etatAUCUNEColor;
/*      */     }
/*  936 */     if (this.jRadioChoix.isSelected()) {
/*  937 */       FormeInterneMCD.etatColor = Outil.Parametres.etatAVECColor;
/*      */     }
/*      */     
/*  940 */     setAllColor();
/*  941 */     this.ihmpan.repaint();
/*  942 */     this.frm.getFormeMCD().setModifier(true);
/*      */     
/*  944 */     dispose();
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
/*  948 */     Outil.Setting.petitCarreau = this.petitCareau;
/*  949 */     dispose();
/*      */   }
/*      */   
/*      */   private void jRadioChoixActionPerformed(java.awt.event.ActionEvent evt) {
/*  953 */     if (this.jRadioChoix.isSelected())
/*      */     {
/*  955 */       this.jLabClEntiteCadre.setEnabled(true);
/*  956 */       this.jLabClEntiteFond.setEnabled(true);
/*  957 */       this.jLabClEntiteTexte.setEnabled(true);
/*      */       
/*  959 */       this.jLabClLienTexte.setEnabled(true);
/*  960 */       this.jLabClLienCnt.setEnabled(true);
/*  961 */       this.jLabClLienTexte.setEnabled(true);
/*      */       
/*  963 */       this.jLabClRelationCadre.setEnabled(true);
/*  964 */       this.jLabClRelationFond.setEnabled(true);
/*  965 */       this.jLabClRelationTexte.setEnabled(true);
/*      */       
/*  967 */       this.jLabClContrainteCadre.setEnabled(true);
/*  968 */       this.jLabClContrainteFond.setEnabled(true);
/*  969 */       this.jLabClContrainteTexte.setEnabled(true);
/*      */       
/*  971 */       this.jLabClCIFCadre.setEnabled(true);
/*  972 */       this.jLabClCIFFond.setEnabled(true);
/*  973 */       this.jLabClCIFTexte.setEnabled(true);
/*      */       
/*  975 */       this.jLabClLien.setEnabled(true);
/*  976 */       this.jLabClLienTexte.setEnabled(true);
/*  977 */       this.jLabClLienCnt.setEnabled(true);
/*      */       
/*  979 */       this.panAp.setClRelationCadre(this.jLabClRelationCadre.getBackground());
/*  980 */       this.panAp.setClRelationFond(this.jLabClRelationFond.getBackground());
/*  981 */       this.panAp.setClRelationText(this.jLabClRelationTexte.getBackground());
/*      */       
/*  983 */       this.panAp.setClEntiteCadre(this.jLabClEntiteCadre.getBackground());
/*  984 */       this.panAp.setClEntiteFond(this.jLabClEntiteFond.getBackground());
/*  985 */       this.panAp.setClEntiteText(this.jLabClEntiteTexte.getBackground());
/*      */       
/*  987 */       this.panAp.setClContrainteCadre(this.jLabClContrainteCadre.getBackground());
/*  988 */       this.panAp.setClContrainteFond(this.jLabClContrainteFond.getBackground());
/*  989 */       this.panAp.setClContrainteText(this.jLabClContrainteTexte.getBackground());
/*      */       
/*  991 */       this.panAp.setClCIFCadre(this.jLabClCIFCadre.getBackground());
/*  992 */       this.panAp.setClCIFFond(this.jLabClCIFFond.getBackground());
/*  993 */       this.panAp.setClCIFText(this.jLabClCIFTexte.getBackground());
/*      */       
/*  995 */       this.panAp.setClString(this.jLabClLienTexte.getBackground());
/*  996 */       this.panAp.setClLien(this.jLabClLien.getBackground());
/*  997 */       this.panAp.setClLienCnt(this.jLabClLienCnt.getBackground());
/*      */       
/*  999 */       this.panAp.repaint();
/*      */     } }
/*      */   
/*      */   private JLabel jLabel33;
/*      */   private JLabel jLabel35;
/*      */   private JLabel jLabel37;
/*      */   
/* 1006 */   private void jRadioAucuneActionPerformed(java.awt.event.ActionEvent evt) { if (this.jRadioAucune.isSelected())
/*      */     {
/* 1008 */       this.jLabClEntiteCadre.setEnabled(false);
/* 1009 */       this.jLabClEntiteFond.setEnabled(false);
/* 1010 */       this.jLabClEntiteTexte.setEnabled(false);
/*      */       
/* 1012 */       this.jLabClLienTexte.setEnabled(false);
/* 1013 */       this.jLabClLienCnt.setEnabled(false);
/* 1014 */       this.jLabClLienTexte.setEnabled(false);
/*      */       
/* 1016 */       this.jLabClRelationCadre.setEnabled(false);
/* 1017 */       this.jLabClRelationFond.setEnabled(false);
/* 1018 */       this.jLabClRelationTexte.setEnabled(false);
/*      */       
/* 1020 */       this.jLabClContrainteCadre.setEnabled(false);
/* 1021 */       this.jLabClContrainteFond.setEnabled(false);
/* 1022 */       this.jLabClContrainteTexte.setEnabled(false);
/*      */       
/* 1024 */       this.jLabClCIFCadre.setEnabled(false);
/* 1025 */       this.jLabClCIFFond.setEnabled(false);
/* 1026 */       this.jLabClCIFTexte.setEnabled(false);
/*      */       
/* 1028 */       this.jLabClLien.setEnabled(false);
/* 1029 */       this.jLabClLienTexte.setEnabled(false);
/* 1030 */       this.jLabClLienCnt.setEnabled(false);
/*      */       
/* 1032 */       this.panAp.setClRelationCadre(Color.BLACK);
/* 1033 */       this.panAp.setClRelationFond(Color.WHITE);
/* 1034 */       this.panAp.setClString(Color.BLACK);
/* 1035 */       this.panAp.setClEntiteCadre(Color.BLACK);
/* 1036 */       this.panAp.setClEntiteFond(Color.WHITE);
/* 1037 */       this.panAp.setClLien(Color.BLACK);
/*      */       
/* 1039 */       this.panAp.setClEntiteCadre(Color.BLACK);
/* 1040 */       this.panAp.setClEntiteFond(Color.WHITE);
/* 1041 */       this.panAp.setClEntiteText(Color.BLACK);
/*      */       
/* 1043 */       this.panAp.setClRelationCadre(Color.BLACK);
/* 1044 */       this.panAp.setClRelationFond(Color.WHITE);
/* 1045 */       this.panAp.setClRelationText(Color.BLACK);
/*      */       
/* 1047 */       this.panAp.setClContrainteCadre(Color.BLACK);
/* 1048 */       this.panAp.setClContrainteFond(Color.WHITE);
/* 1049 */       this.panAp.setClContrainteText(Color.BLACK);
/*      */       
/* 1051 */       this.panAp.setClCIFCadre(Color.BLACK);
/* 1052 */       this.panAp.setClCIFFond(Color.WHITE);
/* 1053 */       this.panAp.setClCIFText(Color.BLACK);
/*      */       
/* 1055 */       this.panAp.setClLien(Color.BLACK);
/* 1056 */       this.panAp.setClLienCnt(Color.BLACK);
/* 1057 */       this.panAp.setClString(Color.BLACK);
/*      */       
/* 1059 */       this.panAp.repaint(); } }
/*      */   
/*      */   private JLabel jLabel39;
/*      */   private JLabel jLabel4;
/*      */   
/* 1064 */   private void jRadioDefautActionPerformed(java.awt.event.ActionEvent evt) { if (this.jRadioDefaut.isSelected()) {
/* 1065 */       FormeInterneMCD.etatColor = Outil.Parametres.etatDefautColor;
/* 1066 */       this.jLabClEntiteCadre.setEnabled(false);
/* 1067 */       this.jLabClEntiteFond.setEnabled(false);
/* 1068 */       this.jLabClEntiteTexte.setEnabled(false);
/*      */       
/* 1070 */       this.jLabClLienTexte.setEnabled(false);
/* 1071 */       this.jLabClLienCnt.setEnabled(false);
/* 1072 */       this.jLabClLienTexte.setEnabled(false);
/*      */       
/* 1074 */       this.jLabClRelationCadre.setEnabled(false);
/* 1075 */       this.jLabClRelationFond.setEnabled(false);
/* 1076 */       this.jLabClRelationTexte.setEnabled(false);
/*      */       
/* 1078 */       this.jLabClContrainteCadre.setEnabled(false);
/* 1079 */       this.jLabClContrainteFond.setEnabled(false);
/* 1080 */       this.jLabClContrainteTexte.setEnabled(false);
/*      */       
/* 1082 */       this.jLabClCIFCadre.setEnabled(false);
/* 1083 */       this.jLabClCIFFond.setEnabled(false);
/* 1084 */       this.jLabClCIFTexte.setEnabled(false);
/*      */       
/* 1086 */       this.jLabClLien.setEnabled(false);
/* 1087 */       this.jLabClLienTexte.setEnabled(false);
/* 1088 */       this.jLabClLienCnt.setEnabled(false);
/*      */       
/* 1090 */       FormeInterneMCD.initialiserDefaultColor();
/* 1091 */       this.panAp.setClEntiteCadre(FormeInterneMCD.clEntiteCadre);
/* 1092 */       this.panAp.setClEntiteFond(FormeInterneMCD.clEntiteFond);
/* 1093 */       this.panAp.setClEntiteText(FormeInterneMCD.clEntiteText);
/*      */       
/* 1095 */       this.panAp.setClRelationCadre(FormeInterneMCD.clRelationCadre);
/* 1096 */       this.panAp.setClRelationFond(FormeInterneMCD.clRelationFond);
/* 1097 */       this.panAp.setClRelationText(FormeInterneMCD.clRelationText);
/*      */       
/* 1099 */       this.panAp.setClContrainteCadre(FormeInterneMCD.clContrainteCadre);
/* 1100 */       this.panAp.setClContrainteFond(FormeInterneMCD.clContrainteFond);
/* 1101 */       this.panAp.setClContrainteText(FormeInterneMCD.clContrainteText);
/*      */       
/* 1103 */       this.panAp.setClCIFCadre(FormeInterneMCD.clCIFCadre);
/* 1104 */       this.panAp.setClCIFFond(FormeInterneMCD.clCIFFond);
/* 1105 */       this.panAp.setClCIFText(FormeInterneMCD.clCIFText);
/*      */       
/* 1107 */       this.panAp.setClLien(FormeInterneMCD.clLien);
/* 1108 */       this.panAp.setClLienCnt(FormeInterneMCD.clLienCnt);
/* 1109 */       this.panAp.setClString(FormeInterneMCD.clString);
/*      */       
/* 1111 */       this.panAp.repaint(); } }
/*      */   
/*      */   private JLabel jLabel41;
/*      */   private JLabel jLabel42;
/*      */   private JLabel jLabel44;
/*      */   private JLabel jLabel46;
/*      */   
/*      */   private void jLabel10MouseClicked(MouseEvent evt) {}
/*      */   
/*      */   private void jLabel25KeyPressed(java.awt.event.KeyEvent evt) {}
/*      */   private javax.swing.JPanel jPanel1;
/*      */   private javax.swing.JPanel jPanel10;
/*      */   private javax.swing.JPanel jPanel2;
/*      */   private javax.swing.JPanel jPanel3;
/*      */   
/* 1126 */   private void jLabel25MouseClicked(MouseEvent evt) { if (this.jRadioChoix.isSelected()) {
/* 1127 */       this.jLabClEntiteCadre.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabClEntiteCadre.getBackground()));
/* 1128 */       this.panAp.setClEntiteCadre(this.jLabClEntiteCadre.getBackground());
/* 1129 */       this.panAp.repaint();
/*      */     } }
/*      */   
/*      */   private javax.swing.JPanel jPanel4;
/*      */   
/* 1134 */   private void jLabel23MouseClicked(MouseEvent evt) { if (this.jRadioChoix.isSelected()) {
/* 1135 */       this.jLabClEntiteFond.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur ", this.jLabClEntiteFond.getBackground()));
/* 1136 */       this.panAp.setClEntiteFond(this.jLabClEntiteFond.getBackground());
/* 1137 */       this.panAp.repaint();
/*      */     } }
/*      */   
/*      */   private javax.swing.JPanel jPanel5;
/*      */   
/* 1142 */   private void jLabel27MouseClicked(MouseEvent evt) { if (this.jRadioChoix.isSelected()) {
/* 1143 */       this.jLabClEntiteTexte.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur ", this.jLabClEntiteTexte.getBackground()));
/* 1144 */       this.panAp.setClEntiteText(this.jLabClEntiteTexte.getBackground());
/* 1145 */       this.panAp.repaint();
/*      */     } }
/*      */   
/*      */   private javax.swing.JPanel jPanel6;
/*      */   
/* 1150 */   private void jLabel30MouseClicked(MouseEvent evt) { if (this.jRadioChoix.isSelected()) {
/* 1151 */       this.jLabClRelationCadre.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabClRelationCadre.getBackground()));
/* 1152 */       this.panAp.setClRelationCadre(this.jLabClRelationCadre.getBackground());
/* 1153 */       this.panAp.repaint(); } }
/*      */   
/*      */   private javax.swing.JPanel jPanel7;
/*      */   private javax.swing.JPanel jPanel8;
/*      */   
/* 1158 */   private void jLabel28MouseClicked(MouseEvent evt) { if (this.jRadioChoix.isSelected()) {
/* 1159 */       this.jLabClRelationFond.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabClRelationFond.getBackground()));
/* 1160 */       this.panAp.setClRelationFond(this.jLabClRelationFond.getBackground());
/* 1161 */       this.panAp.repaint();
/*      */     } }
/*      */   
/*      */   private javax.swing.JPanel jPanel9;
/*      */   
/* 1166 */   private void jLabel32MouseClicked(MouseEvent evt) { if (this.jRadioChoix.isSelected()) {
/* 1167 */       this.jLabClRelationTexte.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabClRelationTexte.getBackground()));
/* 1168 */       this.panAp.setClRelationText(this.jLabClRelationTexte.getBackground());
/* 1169 */       this.panAp.repaint(); } }
/*      */   
/*      */   private javax.swing.JRadioButton jRadioAucune;
/*      */   private javax.swing.JRadioButton jRadioChoix;
/*      */   private javax.swing.JRadioButton jRadioDefaut;
/* 1174 */   private void jLabel33MouseClicked(MouseEvent evt) { if (this.jRadioChoix.isSelected()) {
/* 1175 */       this.jLabClLien.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabClLien.getBackground()));
/* 1176 */       this.panAp.setClLien(this.jLabClLien.getBackground());
/* 1177 */       this.panAp.repaint();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel37MouseClicked(MouseEvent evt) {
/* 1182 */     if (this.jRadioChoix.isSelected()) {
/* 1183 */       this.jLabClLienTexte.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabClLienTexte.getBackground()));
/* 1184 */       this.panAp.setClString(this.jLabClLienTexte.getBackground());
/* 1185 */       this.panAp.repaint();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel21MouseClicked(MouseEvent evt) {
/* 1190 */     if (this.jRadioChoix.isSelected()) {
/* 1191 */       this.jLabClLienCnt.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabClLienCnt.getBackground()));
/* 1192 */       this.panAp.setClLienCnt(this.jLabClLienCnt.getBackground());
/* 1193 */       this.panAp.repaint();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel39MouseClicked(MouseEvent evt) {
/* 1198 */     if (this.jRadioChoix.isSelected()) {
/* 1199 */       this.jLabClContrainteCadre.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabClContrainteCadre.getBackground()));
/* 1200 */       this.panAp.setClContrainteCadre(this.jLabClContrainteCadre.getBackground());
/* 1201 */       this.panAp.repaint();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel35MouseClicked(MouseEvent evt) {
/* 1206 */     if (this.jRadioChoix.isSelected()) {
/* 1207 */       this.jLabClContrainteFond.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabClContrainteFond.getBackground()));
/* 1208 */       this.panAp.setClContrainteFond(this.jLabClContrainteFond.getBackground());
/* 1209 */       this.panAp.repaint();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel41MouseClicked(MouseEvent evt) {
/* 1214 */     if (this.jRadioChoix.isSelected()) {
/* 1215 */       this.jLabClContrainteTexte.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabClContrainteTexte.getBackground()));
/* 1216 */       this.panAp.setClContrainteText(this.jLabClContrainteTexte.getBackground());
/* 1217 */       this.panAp.repaint();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel44MouseClicked(MouseEvent evt) {
/* 1222 */     if (this.jRadioChoix.isSelected()) {
/* 1223 */       this.jLabClCIFCadre.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabClCIFCadre.getBackground()));
/* 1224 */       this.panAp.setClCIFCadre(this.jLabClCIFCadre.getBackground());
/* 1225 */       this.panAp.repaint();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel42MouseClicked(MouseEvent evt) {
/* 1230 */     if (this.jRadioChoix.isSelected()) {
/* 1231 */       this.jLabClCIFFond.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabClCIFFond.getBackground()));
/* 1232 */       this.panAp.setClCIFFond(this.jLabClCIFFond.getBackground());
/* 1233 */       this.panAp.repaint();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabel46MouseClicked(MouseEvent evt) {
/* 1238 */     if (this.jRadioChoix.isSelected()) {
/* 1239 */       this.jLabClCIFTexte.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabClCIFTexte.getBackground()));
/* 1240 */       this.panAp.setClCIFText(this.jLabClCIFTexte.getBackground());
/* 1241 */       this.panAp.repaint();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jCBPetitCarreauActionPerformed(java.awt.event.ActionEvent evt) {
/* 1246 */     Outil.Setting.petitCarreau = this.jCBPetitCarreau.isSelected();
/* 1247 */     this.panAp.repaint();
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeColor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */