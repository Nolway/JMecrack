/*     */ package formes2;
/*     */ 
/*     */ import IhmMCD2.IhmLien2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import IhmMLD2.MLDRelationLien;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class FormeConversionRelation extends javax.swing.JDialog
/*     */ {
/*     */   ihm.Principale frm;
/*     */   IhmMCD.IhmPageMCD page;
/*     */   ArrayList<MLDRelationLien> listeRelationLien;
/*     */   ArrayList<MLDRelationLien> listeRelationConcernee;
/*     */   MLDRelationLien relSelect;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private JCheckBox jCBCreer;
/*     */   private JCheckBox jCBCreerEnt0;
/*     */   private JCheckBox jCBCreerEnt1;
/*     */   private JCheckBox jCBDispar;
/*     */   private JCheckBox jCBDisparEnt0;
/*     */   private JCheckBox jCBDisparEnt1;
/*     */   private JLabel jLabType;
/*     */   private JLabel jLabValider;
/*     */   private JLabel jLabel2;
/*     */   private javax.swing.JList jListRelation;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   
/*     */   public FormeConversionRelation(ihm.Principale parent, boolean modal)
/*     */   {
/*  41 */     super(parent, modal);
/*  42 */     initComponents();
/*  43 */     this.frm = parent;
/*  44 */     this.page = this.frm.getPage();
/*  45 */     setLocation(this.frm.getX() + 250, this.frm.getY() + 100);
/*     */     
/*  47 */     this.listeRelationLien = new ArrayList();
/*  48 */     this.listeRelationConcernee = new ArrayList();
/*  49 */     this.relSelect = null;
/*  50 */     construireLienAllRelation(this.page.getListeEntiteRelation(), this.page.getListeLien());
/*  51 */     copierListeConcerner();
/*  52 */     remplirLaListe();
/*  53 */     this.jLabValider.setVisible(false);
/*     */   }
/*     */   
/*     */ 
/*     */   private void setSelectJCBEntite(String nom, JCheckBox jcb0, JCheckBox jcb1)
/*     */   {
/*  59 */     String nomJcb = jcb0.getText().trim().toUpperCase();
/*  60 */     nomJcb = nomJcb.substring(nomJcb.indexOf(":") + 1, nomJcb.length());
/*     */     
/*  62 */     if (nomJcb.trim().toUpperCase().equals(nom.trim().toUpperCase())) {
/*  63 */       jcb0.setSelected(true);
/*     */     }
/*  65 */     nomJcb = jcb1.getText().trim().toUpperCase();
/*  66 */     nomJcb = nomJcb.substring(nomJcb.indexOf(":") + 1, nomJcb.length());
/*     */     
/*  68 */     if (nomJcb.trim().toUpperCase().equals(nom.trim().toUpperCase())) {
/*  69 */       jcb1.setSelected(true);
/*     */     }
/*     */   }
/*     */   
/*     */   private void setSelectJCBAction(String action, JCheckBox jcbCre, JCheckBox jcBDis)
/*     */   {
/*  75 */     if (action.trim().toUpperCase().equals(MLDRelationLien.CREER)) {
/*  76 */       jcbCre.setSelected(true);
/*     */     }
/*     */     
/*  79 */     if (action.trim().toUpperCase().equals(MLDRelationLien.DISPARAITRE)) {
/*  80 */       jcBDis.setSelected(true);
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
/*     */   private void copierListeConcerner()
/*     */   {
/*  96 */     for (int i = 0; i < this.listeRelationLien.size(); i++) {
/*  97 */       if ((((MLDRelationLien)this.listeRelationLien.get(i)).getGroupeRelation() == MLDRelationLien.GROUPE_QUATRE) || (((MLDRelationLien)this.listeRelationLien.get(i)).getGroupeRelation() == MLDRelationLien.GROUPE_CINQ) || (((MLDRelationLien)this.listeRelationLien.get(i)).getGroupeRelation() == MLDRelationLien.GROUPE_SIX))
/*     */       {
/*     */ 
/* 100 */         this.listeRelationConcernee.add(this.listeRelationLien.get(i));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void activierOption(MLDRelationLien rel)
/*     */   {
/* 107 */     this.jCBCreer.setSelected(false);
/* 108 */     this.jCBDispar.setSelected(false);
/* 109 */     this.jCBCreerEnt0.setSelected(false);
/* 110 */     this.jCBCreerEnt1.setSelected(false);
/* 111 */     this.jCBDisparEnt0.setSelected(false);
/* 112 */     this.jCBDisparEnt1.setSelected(false);
/*     */     
/* 114 */     this.jLabType.setText(rel.getRelation().getRelation().getNom().trim() + " = [ " + ((IhmLien2)rel.getListLien().get(0)).getCardinalite() + " - " + ((IhmLien2)rel.getListLien().get(1)).getCardinalite() + " ]");
/*     */     
/* 116 */     String nom0 = ((IhmLien2)rel.getListLien().get(0)).getCardinalite() + ": " + ((IhmLien2)rel.getListLien().get(0)).getEntite().getEntite().getNom();
/* 117 */     String nom1 = ((IhmLien2)rel.getListLien().get(1)).getCardinalite() + ": " + ((IhmLien2)rel.getListLien().get(1)).getEntite().getEntite().getNom();
/* 118 */     this.jCBCreerEnt0.setText(nom0);
/* 119 */     this.jCBCreerEnt1.setText(nom1);
/* 120 */     this.jCBDisparEnt0.setText(nom0);
/* 121 */     this.jCBDisparEnt1.setText(nom1);
/*     */     
/*     */ 
/* 124 */     String action = rel.getRelation().getDispatchKey();
/*     */     
/* 126 */     if (action.trim().length() > 0) {
/* 127 */       if (action.contains("<ACTION>" + MLDRelationLien.CREER + "</ACTION>")) {
/* 128 */         action = MLDRelationLien.CREER;
/*     */       }
/* 130 */       if (action.contains("<ACTION>" + MLDRelationLien.DISPARAITRE + "</ACTION>")) {
/* 131 */         action = MLDRelationLien.DISPARAITRE;
/*     */       }
/*     */     }
/*     */     
/* 135 */     nom0 = rel.getRelation().getDispatchKey();
/*     */     
/* 137 */     if (nom0.trim().length() > 0) { nom0 = nom0.substring(nom0.indexOf("<ENTITE1>") + 9, nom0.indexOf("</ENTITE1>"));
/*     */     }
/* 139 */     nom1 = rel.getRelation().getDispatchKey();
/* 140 */     if (nom1.trim().length() > 0) { nom1 = nom1.substring(nom1.indexOf("<ENTITE2>") + 9, nom1.indexOf("</ENTITE2>"));
/*     */     }
/*     */     
/* 143 */     if (rel.getGroupeRelation() == MLDRelationLien.GROUPE_QUATRE) {
/* 144 */       this.jCBCreer.setEnabled(true);
/* 145 */       this.jCBDispar.setEnabled(true);
/* 146 */       this.jCBCreerEnt0.setEnabled(false);
/* 147 */       this.jCBCreerEnt1.setEnabled(false);
/* 148 */       this.jCBDisparEnt0.setEnabled(false);
/* 149 */       this.jCBDisparEnt1.setEnabled(false);
/* 150 */       setSelectJCBAction(action, this.jCBCreer, this.jCBDispar);
/*     */     }
/*     */     
/* 153 */     if (rel.getGroupeRelation() == MLDRelationLien.GROUPE_CINQ) {
/* 154 */       this.jCBCreer.setEnabled(false);
/* 155 */       this.jCBDispar.setEnabled(true);
/*     */       
/* 157 */       this.jCBCreerEnt0.setEnabled(false);
/* 158 */       this.jCBCreerEnt1.setEnabled(false);
/* 159 */       this.jCBDisparEnt0.setEnabled(true);
/* 160 */       this.jCBDisparEnt1.setEnabled(true);
/* 161 */       setSelectJCBAction(action, this.jCBCreer, this.jCBDispar);
/* 162 */       setSelectJCBEntite(nom0, this.jCBDisparEnt0, this.jCBDisparEnt1);
/* 163 */       setSelectJCBEntite(nom1, this.jCBDisparEnt0, this.jCBDisparEnt1);
/*     */     }
/*     */     
/* 166 */     if (rel.getGroupeRelation() == MLDRelationLien.GROUPE_SIX) {
/* 167 */       this.jCBCreer.setEnabled(true);
/* 168 */       this.jCBDispar.setEnabled(true);
/* 169 */       this.jCBCreerEnt0.setEnabled(true);
/* 170 */       this.jCBCreerEnt1.setEnabled(true);
/* 171 */       this.jCBDisparEnt0.setEnabled(true);
/* 172 */       this.jCBDisparEnt1.setEnabled(true);
/*     */       
/* 174 */       setSelectJCBAction(action, this.jCBCreer, this.jCBDispar);
/* 175 */       if (this.jCBCreer.isSelected()) {
/* 176 */         setSelectJCBEntite(nom0, this.jCBCreerEnt0, this.jCBCreerEnt1);
/* 177 */         setSelectJCBEntite(nom1, this.jCBCreerEnt0, this.jCBCreerEnt1);
/*     */       }
/* 179 */       if (this.jCBDispar.isSelected()) {
/* 180 */         setSelectJCBEntite(nom0, this.jCBDisparEnt0, this.jCBDisparEnt1);
/* 181 */         setSelectJCBEntite(nom1, this.jCBDisparEnt0, this.jCBDisparEnt1);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private String[] transformerListeEnTableau()
/*     */   {
/* 189 */     String[] tab = new String[this.listeRelationConcernee.size()];
/* 190 */     for (int i = 0; i < this.listeRelationConcernee.size(); i++) {
/* 191 */       tab[i] = ((MLDRelationLien)this.listeRelationConcernee.get(i)).getRelation().getRelation().getNom();
/*     */     }
/* 193 */     return tab;
/*     */   }
/*     */   
/*     */   private void remplirLaListe()
/*     */   {
/* 198 */     this.jListRelation.removeAll();
/*     */     
/*     */ 
/* 201 */     this.jListRelation.setListData(transformerListeEnTableau());
/*     */   }
/*     */   
/*     */ 
/*     */   private void construireLienAllRelation(ArrayList<IhmMCD.IhmEntiteRelation> listeEntRel, ArrayList<IhmMCD.IhmLien> listeLien)
/*     */   {
/* 207 */     this.listeRelationLien.clear();
/*     */     
/* 209 */     for (int i = 0; i < listeEntRel.size(); i++) {
/* 210 */       if ((listeEntRel.get(i) instanceof IhmRelation2)) {
/* 211 */         MLDRelationLien rel = getLienRelation((IhmRelation2)listeEntRel.get(i), listeLien);
/* 212 */         rel.remplirProprietesRelation();
/* 213 */         this.listeRelationLien.add(rel);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public MLDRelationLien getLienRelation(IhmRelation2 rel) {
/* 219 */     for (int i = 0; i < this.listeRelationLien.size(); i++) {
/* 220 */       if (((MLDRelationLien)this.listeRelationLien.get(i)).getRelation() == rel) return (MLDRelationLien)this.listeRelationLien.get(i);
/*     */     }
/* 222 */     return null;
/*     */   }
/*     */   
/*     */   private static MLDRelationLien getLienRelation(IhmRelation2 rel, ArrayList<IhmMCD.IhmLien> listeLien) {
/* 226 */     MLDRelationLien MLDRel = new MLDRelationLien(rel);
/*     */     
/* 228 */     for (int i = 0; i < listeLien.size(); i++) {
/* 229 */       IhmLien2 l = (IhmLien2)listeLien.get(i);
/* 230 */       if (l.getRelation() == rel) {
/* 231 */         MLDRel.addLien(l);
/*     */       }
/*     */     }
/* 234 */     MLDRel.remplirProprietesRelation();
/* 235 */     return MLDRel;
/*     */   }
/*     */   
/*     */   private String getNomEntite(JCheckBox jcb)
/*     */   {
/* 240 */     String nom = jcb.getText().trim();
/* 241 */     nom = nom.substring(nom.indexOf(":") + 1, nom.length()).trim();
/* 242 */     return nom;
/*     */   }
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
/* 254 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 255 */     this.jListRelation = new javax.swing.JList();
/* 256 */     this.jPanel1 = new javax.swing.JPanel();
/* 257 */     this.jCBDispar = new JCheckBox();
/* 258 */     this.jCBCreer = new JCheckBox();
/* 259 */     this.jCBDisparEnt0 = new JCheckBox();
/* 260 */     this.jCBDisparEnt1 = new JCheckBox();
/* 261 */     this.jCBCreerEnt1 = new JCheckBox();
/* 262 */     this.jCBCreerEnt0 = new JCheckBox();
/* 263 */     this.jButton1 = new JButton();
/* 264 */     this.jLabel2 = new JLabel();
/* 265 */     this.jButton2 = new JButton();
/* 266 */     this.jLabType = new JLabel();
/* 267 */     this.jButton3 = new JButton();
/* 268 */     this.jLabValider = new JLabel();
/*     */     
/* 270 */     setDefaultCloseOperation(2);
/* 271 */     setTitle("Paramétres de transformation de la relation ");
/* 272 */     setResizable(false);
/*     */     
/* 274 */     this.jListRelation.setBackground(new java.awt.Color(240, 240, 240));
/* 275 */     this.jListRelation.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 277 */         FormeConversionRelation.this.jListRelationMouseClicked(evt);
/*     */       }
/* 279 */     });
/* 280 */     this.jListRelation.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyReleased(java.awt.event.KeyEvent evt) {
/* 282 */         FormeConversionRelation.this.jListRelationKeyReleased(evt);
/*     */       }
/* 284 */     });
/* 285 */     this.jScrollPane1.setViewportView(this.jListRelation);
/*     */     
/* 287 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Transformation de la relation"));
/*     */     
/* 289 */     this.jCBDispar.setText("Les clés primaires seront reçues par ");
/* 290 */     this.jCBDispar.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 292 */         FormeConversionRelation.this.jCBDisparActionPerformed(evt);
/*     */       }
/*     */       
/* 295 */     });
/* 296 */     this.jCBCreer.setText("Transformer en table  dont la clé primaire ");
/* 297 */     this.jCBCreer.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 299 */         FormeConversionRelation.this.jCBCreerActionPerformed(evt);
/*     */       }
/*     */       
/* 302 */     });
/* 303 */     this.jCBDisparEnt0.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 304 */     this.jCBDisparEnt0.setForeground(new java.awt.Color(102, 0, 0));
/* 305 */     this.jCBDisparEnt0.setText(".......");
/* 306 */     this.jCBDisparEnt0.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 308 */         FormeConversionRelation.this.jCBDisparEnt0ActionPerformed(evt);
/*     */       }
/*     */       
/* 311 */     });
/* 312 */     this.jCBDisparEnt1.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 313 */     this.jCBDisparEnt1.setForeground(new java.awt.Color(0, 0, 102));
/* 314 */     this.jCBDisparEnt1.setText("........");
/* 315 */     this.jCBDisparEnt1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 317 */         FormeConversionRelation.this.jCBDisparEnt1ActionPerformed(evt);
/*     */       }
/*     */       
/* 320 */     });
/* 321 */     this.jCBCreerEnt1.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 322 */     this.jCBCreerEnt1.setForeground(new java.awt.Color(0, 0, 102));
/* 323 */     this.jCBCreerEnt1.setText(".......");
/* 324 */     this.jCBCreerEnt1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 326 */         FormeConversionRelation.this.jCBCreerEnt1ActionPerformed(evt);
/*     */       }
/*     */       
/* 329 */     });
/* 330 */     this.jCBCreerEnt0.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 331 */     this.jCBCreerEnt0.setForeground(new java.awt.Color(102, 0, 0));
/* 332 */     this.jCBCreerEnt0.setText(".......");
/* 333 */     this.jCBCreerEnt0.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 335 */         FormeConversionRelation.this.jCBCreerEnt0ActionPerformed(evt);
/*     */       }
/*     */       
/* 338 */     });
/* 339 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 340 */     this.jPanel1.setLayout(jPanel1Layout);
/* 341 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBCreer).addComponent(this.jCBDispar).addGroup(jPanel1Layout.createSequentialGroup().addGap(32, 32, 32).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBCreerEnt1).addComponent(this.jCBCreerEnt0))))).addGroup(jPanel1Layout.createSequentialGroup().addGap(42, 42, 42).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBDisparEnt1).addComponent(this.jCBDisparEnt0)))).addContainerGap(62, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 362 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jCBCreer).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBCreerEnt0).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBCreerEnt1).addGap(18, 18, 18).addComponent(this.jCBDispar).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBDisparEnt0).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBDisparEnt1).addContainerGap(22, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 380 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 381 */     this.jButton1.setText("Fermer ");
/* 382 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 384 */         FormeConversionRelation.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/* 387 */     });
/* 388 */     this.jLabel2.setText("La liste des relations ");
/*     */     
/* 390 */     this.jButton2.setText("Réinitialiser toutes les relations");
/* 391 */     this.jButton2.setEnabled(false);
/*     */     
/* 393 */     this.jLabType.setFont(new java.awt.Font("Tahoma", 1, 12));
/* 394 */     this.jLabType.setForeground(new java.awt.Color(0, 0, 102));
/* 395 */     this.jLabType.setHorizontalAlignment(0);
/* 396 */     this.jLabType.setText("Cas de relation");
/*     */     
/* 398 */     this.jButton3.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 399 */     this.jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 400 */     this.jButton3.setText("Valider");
/* 401 */     this.jButton3.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 403 */         FormeConversionRelation.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */       
/* 406 */     });
/* 407 */     this.jLabValider.setFont(new java.awt.Font("Tahoma", 1, 12));
/* 408 */     this.jLabValider.setForeground(new java.awt.Color(255, 0, 0));
/* 409 */     this.jLabValider.setHorizontalAlignment(0);
/* 410 */     this.jLabValider.setText("Validée");
/*     */     
/* 412 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 413 */     getContentPane().setLayout(layout);
/* 414 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 430, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabType, -1, 305, 32767).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jButton1, GroupLayout.Alignment.TRAILING, -2, 130, -2).addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabValider, -2, 82, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton3, -2, 115, -2)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton2, -2, 228, -2).addGap(37, 37, 37))))).addComponent(this.jLabel2)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 437 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.jLabType, -1, 27, 32767).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton3, -2, 33, -2).addComponent(this.jLabValider, -2, 23, -2)).addGap(31, 31, 31).addComponent(this.jButton2, -2, 31, -2).addGap(49, 49, 49).addComponent(this.jButton1, -2, 31, -2)).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 455, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 460 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 464 */     dispose();
/*     */   }
/*     */   
/*     */   private void jCBCreerActionPerformed(ActionEvent evt) {
/* 468 */     if (this.jCBCreer.isSelected()) {
/* 469 */       this.jCBDispar.setSelected(false);
/* 470 */       this.jCBDisparEnt0.setSelected(false);
/* 471 */       this.jCBDisparEnt1.setSelected(false);
/*     */     }
/* 473 */     this.jLabValider.setVisible(false);
/*     */   }
/*     */   
/*     */   private void jCBDisparActionPerformed(ActionEvent evt) {
/* 477 */     if (this.jCBDispar.isSelected()) {
/* 478 */       this.jCBCreer.setSelected(false);
/* 479 */       this.jCBCreerEnt0.setSelected(false);
/* 480 */       this.jCBCreerEnt1.setSelected(false);
/*     */     }
/* 482 */     this.jLabValider.setVisible(false);
/*     */   }
/*     */   
/*     */   private void jListRelationMouseClicked(java.awt.event.MouseEvent evt) {
/* 486 */     int id = this.jListRelation.getSelectedIndex();
/* 487 */     if (id >= 0) {
/* 488 */       this.jLabValider.setVisible(false);
/* 489 */       this.relSelect = ((MLDRelationLien)this.listeRelationConcernee.get(id));
/* 490 */       activierOption(this.relSelect);
/*     */     }
/* 492 */     this.jLabValider.setVisible(false);
/*     */   }
/*     */   
/*     */   private void jListRelationKeyReleased(java.awt.event.KeyEvent evt) {
/* 496 */     int id = this.jListRelation.getSelectedIndex();
/* 497 */     if (id >= 0) {
/* 498 */       this.jLabValider.setVisible(false);
/* 499 */       this.relSelect = ((MLDRelationLien)this.listeRelationConcernee.get(id));
/* 500 */       activierOption(this.relSelect);
/*     */     }
/* 502 */     this.jLabValider.setVisible(false);
/*     */   }
/*     */   
/*     */   private void jCBCreerEnt0ActionPerformed(ActionEvent evt) {
/* 506 */     if (this.jCBCreerEnt0.isSelected()) {
/* 507 */       this.jCBCreer.setSelected(true);
/* 508 */       this.jCBDispar.setSelected(false);
/* 509 */       this.jCBCreerEnt1.setSelected(false);
/*     */     }
/* 511 */     this.jLabValider.setVisible(false);
/*     */   }
/*     */   
/*     */   private void jCBCreerEnt1ActionPerformed(ActionEvent evt) {
/* 515 */     if (this.jCBCreerEnt1.isSelected()) {
/* 516 */       this.jCBCreer.setSelected(true);
/* 517 */       this.jCBDispar.setSelected(false);
/* 518 */       this.jCBCreerEnt0.setSelected(false);
/*     */     }
/* 520 */     this.jLabValider.setVisible(false);
/*     */   }
/*     */   
/*     */   private void jCBDisparEnt0ActionPerformed(ActionEvent evt) {
/* 524 */     if (this.relSelect == null) return;
/* 525 */     if (this.relSelect.getGroupeRelation() == MLDRelationLien.GROUPE_CINQ) {
/* 526 */       this.jCBCreer.setSelected(false);
/* 527 */       this.jCBDispar.setSelected(true);
/* 528 */       return;
/*     */     }
/*     */     
/* 531 */     if (this.jCBDisparEnt0.isSelected()) {
/* 532 */       this.jCBCreer.setSelected(false);
/* 533 */       this.jCBDispar.setSelected(true);
/* 534 */       this.jCBDisparEnt1.setSelected(false);
/*     */     }
/* 536 */     this.jLabValider.setVisible(false);
/*     */   }
/*     */   
/*     */   private void jCBDisparEnt1ActionPerformed(ActionEvent evt) {
/* 540 */     if (this.relSelect == null) return;
/* 541 */     if (this.relSelect.getGroupeRelation() == MLDRelationLien.GROUPE_CINQ) {
/* 542 */       this.jCBCreer.setSelected(false);
/* 543 */       this.jCBDispar.setSelected(true);
/* 544 */       return;
/*     */     }
/*     */     
/* 547 */     if (this.jCBDisparEnt1.isSelected()) {
/* 548 */       this.jCBCreer.setSelected(false);
/* 549 */       this.jCBDispar.setSelected(true);
/* 550 */       this.jCBDisparEnt0.setSelected(false);
/*     */     }
/* 552 */     this.jLabValider.setVisible(false);
/*     */   }
/*     */   
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 557 */     if (this.relSelect == null) {
/* 558 */       javax.swing.JOptionPane.showConfirmDialog(this, " Aucune relation n'est séléctionnée ", "Vérification", -1, 0);
/* 559 */       return;
/*     */     }
/*     */     
/* 562 */     if (!ihm.Principale.isActiverJMerise()) {
/* 563 */       javax.swing.JOptionPane.showMessageDialog(this, "Il faut activer cette version pour parametrer la transformation des associations ! ");
/* 564 */       return;
/*     */     }
/*     */     
/* 567 */     this.jLabValider.setVisible(true);
/* 568 */     String s = "";
/* 569 */     if (this.relSelect.getGroupeRelation() == MLDRelationLien.GROUPE_QUATRE) {
/* 570 */       this.relSelect.getRelation().setDispatchKey(s);
/* 571 */       if (this.jCBCreer.isSelected()) {
/* 572 */         s = "<ACTION>" + MLDRelationLien.CREER + "</ACTION><ENTITE1></ENTITE1><ENTITE2></ENTITE2>";
/* 573 */         this.relSelect.getRelation().setDispatchKey(s);
/*     */       }
/* 575 */       if (this.jCBDispar.isSelected()) {
/* 576 */         s = "<ACTION>" + MLDRelationLien.DISPARAITRE + "</ACTION><ENTITE1></ENTITE1><ENTITE2></ENTITE2>";
/* 577 */         this.relSelect.getRelation().setDispatchKey(s);
/*     */       }
/* 579 */       this.frm.getFormeMCD().setModifier(true);
/*     */     }
/*     */     
/*     */ 
/* 583 */     if (this.relSelect.getGroupeRelation() == MLDRelationLien.GROUPE_SIX) {
/* 584 */       this.relSelect.getRelation().setDispatchKey(s);
/*     */       
/* 586 */       if (this.jCBCreer.isSelected()) {
/*     */         String ne;
/* 588 */         if (this.jCBCreerEnt0.isSelected()) {
/* 589 */           ne = "<ENTITE1>" + getNomEntite(this.jCBCreerEnt0) + "</ENTITE1>";
/* 590 */           ne = ne + "<ENTITE2></ENTITE2>";
/*     */         }
/* 592 */         else if (this.jCBCreerEnt1.isSelected()) {
/* 593 */           ne = "<ENTITE1>" + getNomEntite(this.jCBCreerEnt1) + "</ENTITE1>";
/* 594 */           ne = ne + "<ENTITE2></ENTITE2>";
/*     */         } else {
/* 596 */           ne = "<ENTITE1>" + getNomEntite(this.jCBCreerEnt0) + "</ENTITE1>";
/* 597 */           ne = ne + "<ENTITE2></ENTITE2>";
/*     */         }
/*     */         
/* 600 */         this.frm.getFormeMCD().setModifier(true);
/* 601 */         s = "<ACTION>" + MLDRelationLien.CREER + "</ACTION>" + ne;
/* 602 */         this.relSelect.getRelation().setDispatchKey(s);
/*     */       }
/* 604 */       if (this.jCBDispar.isSelected()) {
/* 605 */         this.relSelect.getRelation().setDispatchKey(s);
/* 606 */         String ne; if (this.jCBDisparEnt0.isSelected()) {
/* 607 */           ne = "<ENTITE1>" + getNomEntite(this.jCBDisparEnt0) + "</ENTITE1>";
/* 608 */           ne = ne + "<ENTITE2></ENTITE2>";
/*     */         }
/* 610 */         else if (this.jCBDisparEnt1.isSelected()) {
/* 611 */           ne = "<ENTITE1>" + getNomEntite(this.jCBDisparEnt1) + "</ENTITE1>";
/* 612 */           ne = ne + "<ENTITE2></ENTITE2>";
/*     */         } else {
/* 614 */           ne = "<ENTITE1>" + getNomEntite(this.jCBDisparEnt0) + "</ENTITE1>";
/* 615 */           ne = ne + "<ENTITE2></ENTITE2>";
/*     */         }
/*     */         
/* 618 */         s = "<ACTION>" + MLDRelationLien.DISPARAITRE + "</ACTION>" + ne;
/* 619 */         this.relSelect.getRelation().setDispatchKey(s);
/* 620 */         this.frm.getFormeMCD().setModifier(true);
/*     */       }
/*     */     }
/*     */     
/* 624 */     if (this.relSelect.getGroupeRelation() == MLDRelationLien.GROUPE_CINQ) {
/* 625 */       this.relSelect.getRelation().setDispatchKey(s);
/* 626 */       String ent = "";
/*     */       
/* 628 */       if (this.jCBDispar.isSelected()) {
/* 629 */         s = "<ACTION>" + MLDRelationLien.DISPARAITRE + "</ACTION>";
/* 630 */         if (this.jCBDisparEnt0.isSelected()) {
/* 631 */           ent = ent + "<ENTITE1>" + getNomEntite(this.jCBDisparEnt0) + "</ENTITE1>";
/*     */           
/* 633 */           if (this.jCBDisparEnt1.isSelected()) {
/* 634 */             ent = ent + "<ENTITE2>" + getNomEntite(this.jCBDisparEnt1) + "</ENTITE2>";
/*     */           } else {
/* 636 */             ent = ent + "<ENTITE2></ENTITE2>";
/*     */           }
/*     */           
/*     */         }
/* 640 */         else if (this.jCBDisparEnt1.isSelected()) {
/* 641 */           ent = ent + "<ENTITE1>" + getNomEntite(this.jCBDisparEnt1) + "</ENTITE1>";
/* 642 */           ent = ent + "<ENTITE2></ENTITE2>";
/*     */         } else {
/* 644 */           ent = "";
/*     */         }
/*     */         
/* 647 */         s = s + (ent.trim().length() > 0 ? ent : "<ENTITE1></ENTITE1><ENTITE2></ENTITE2>");
/* 648 */         this.relSelect.getRelation().setDispatchKey(s);
/*     */       } else {
/* 650 */         this.relSelect.getRelation().setDispatchKey("");
/*     */       }
/* 652 */       this.frm.getFormeMCD().setModifier(true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeConversionRelation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */