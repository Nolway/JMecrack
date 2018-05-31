/*     */ package formes;
/*     */ 
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class FormeRechercheRemplacer extends javax.swing.JDialog
/*     */ {
/*     */   private ArrayList<IhmEntiteRelation> listeER;
/*     */   private ArrayList<IhmEntiteRelation> listeTrouver;
/*     */   private IhmEntiteRelation entiteSelect;
/*     */   private boolean resultFermer;
/*     */   ihm.Principale frm;
/*     */   private javax.swing.JButton jBtFermer;
/*     */   private javax.swing.JButton jBtRecherche;
/*     */   private javax.swing.JButton jButton1;
/*     */   private javax.swing.JButton jButton2;
/*     */   private javax.swing.JCheckBox jCBAttribut;
/*     */   private javax.swing.JCheckBox jCBEntite;
/*     */   private javax.swing.JCheckBox jCBRelation;
/*     */   private javax.swing.JLabel jLabRecherche;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JList jListResult;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JTextField jTFNom;
/*     */   private javax.swing.JTextField jTFRemplace;
/*     */   
/*     */   public FormeRechercheRemplacer(ihm.Principale parent, boolean modal, ArrayList<IhmEntiteRelation> liste)
/*     */   {
/*  39 */     super(parent, modal);
/*  40 */     this.frm = parent;
/*  41 */     initComponents();
/*  42 */     this.listeER = liste;
/*  43 */     this.entiteSelect = null;
/*  44 */     this.resultFermer = false;
/*  45 */     this.listeTrouver = new ArrayList();
/*  46 */     setLocation(this.frm.getX() + 300, this.frm.getY() + 100);
/*  47 */     this.jBtFermer.setMnemonic(70);
/*  48 */     this.jBtRecherche.setMnemonic(82);
/*  49 */     this.jLabRecherche.setText("");
/*     */   }
/*     */   
/*     */   private boolean estTrouverAttribut(ArrayList<Merise.Attribut> listeAtt, String nom) {
/*  53 */     for (int i = 0; i < listeAtt.size(); i++) {
/*  54 */       if (((Merise.Attribut)listeAtt.get(i)).getNom().trim().toUpperCase().contains(nom.trim().toUpperCase())) return true;
/*     */     }
/*  56 */     return false;
/*     */   }
/*     */   
/*     */   private void trouverEntite(String nom) {
/*  60 */     for (int i = 0; i < this.listeER.size(); i++) {
/*  61 */       if ((((IhmEntiteRelation)this.listeER.get(i)).getClass().getName().equals("IhmMCD2.IhmEntite2")) && 
/*  62 */         (((IhmEntite2)this.listeER.get(i)).getEntite().getNom().trim().toUpperCase().contains(nom.trim().toUpperCase())) && 
/*  63 */         (!existeDansTrouver((IhmEntiteRelation)this.listeER.get(i)))) { this.listeTrouver.add(this.listeER.get(i));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void trouverRelation(String nom)
/*     */   {
/*  71 */     for (int i = 0; i < this.listeER.size(); i++) {
/*  72 */       if ((((IhmEntiteRelation)this.listeER.get(i)).getClass().getName().equals("IhmMCD2.IhmRelation2")) && 
/*  73 */         (((IhmRelation2)this.listeER.get(i)).getRelation().getNom().trim().toUpperCase().contains(nom.trim().toUpperCase())) && 
/*  74 */         (!existeDansTrouver((IhmEntiteRelation)this.listeER.get(i)))) { this.listeTrouver.add(this.listeER.get(i));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void trouverAttribut(String nom)
/*     */   {
/*  81 */     for (int i = 0; i < this.listeER.size(); i++) {
/*  82 */       if ((((IhmEntiteRelation)this.listeER.get(i)).getClass().getName().equals("IhmMCD2.IhmRelation2")) && 
/*  83 */         (!existeDansTrouver((IhmEntiteRelation)this.listeER.get(i))) && 
/*  84 */         (estTrouverAttribut(((IhmRelation2)this.listeER.get(i)).getRelation().getListeAttributs(), nom))) { this.listeTrouver.add(this.listeER.get(i));
/*     */       }
/*     */       
/*     */ 
/*  88 */       if ((((IhmEntiteRelation)this.listeER.get(i)).getClass().getName().equals("IhmMCD2.IhmEntite2")) && 
/*  89 */         (!existeDansTrouver((IhmEntiteRelation)this.listeER.get(i))) && 
/*  90 */         (estTrouverAttribut(((IhmEntite2)this.listeER.get(i)).getEntite().getListeAttributs(), nom))) { this.listeTrouver.add(this.listeER.get(i));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean existeDansTrouver(IhmEntiteRelation entRel)
/*     */   {
/*  98 */     if (entRel.getClass().getName().equals("IhmMCD2.IhmEntite2")) {
/*  99 */       for (int i = 0; i < this.listeTrouver.size(); i++) {
/* 100 */         if ((((IhmEntiteRelation)this.listeTrouver.get(i)).getClass().getName().equals("IhmMCD2.IhmRelation2")) && 
/* 101 */           (((IhmRelation2)this.listeTrouver.get(i)).getRelation().getNom().trim().toUpperCase().contains(((IhmEntite2)entRel).getEntite().getNom().trim().toUpperCase()))) { return true;
/*     */         }
/* 103 */         if ((((IhmEntiteRelation)this.listeTrouver.get(i)).getClass().getName().equals("IhmMCD2.IhmEntite2")) && 
/* 104 */           (((IhmEntite2)this.listeTrouver.get(i)).getEntite().getNom().trim().toUpperCase().contains(((IhmEntite2)entRel).getEntite().getNom().trim().toUpperCase()))) { return true;
/*     */         }
/*     */       }
/*     */     }
/* 108 */     if (entRel.getClass().getName().equals("IhmMCD2.IhmRelation2")) {
/* 109 */       for (int i = 0; i < this.listeTrouver.size(); i++) {
/* 110 */         if ((((IhmEntiteRelation)this.listeTrouver.get(i)).getClass().getName().equals("IhmMCD2.IhmRelation2")) && 
/* 111 */           (((IhmRelation2)this.listeTrouver.get(i)).getRelation().getNom().trim().toUpperCase().contains(((IhmRelation2)entRel).getRelation().getNom().trim().toUpperCase()))) { return true;
/*     */         }
/* 113 */         if ((((IhmEntiteRelation)this.listeTrouver.get(i)).getClass().getName().equals("IhmMCD2.IhmEntite2")) && 
/* 114 */           (((IhmEntite2)this.listeTrouver.get(i)).getEntite().getNom().trim().toUpperCase().contains(((IhmRelation2)entRel).getRelation().getNom().trim().toUpperCase()))) { return true;
/*     */         }
/*     */       }
/*     */     }
/* 118 */     return false;
/*     */   }
/*     */   
/*     */   private void afficherResultat() {
/* 122 */     this.jListResult.setListData(this.listeTrouver.toArray());
/*     */   }
/*     */   
/*     */   private void lancerRecherche()
/*     */   {
/* 127 */     if (this.jTFNom.getText().trim().length() > 0) {
/* 128 */       this.jListResult.removeAll();
/* 129 */       this.listeTrouver.clear();
/* 130 */       if (this.jCBEntite.isSelected()) trouverEntite(this.jTFNom.getText());
/* 131 */       if (this.jCBRelation.isSelected()) trouverRelation(this.jTFNom.getText());
/* 132 */       if (this.jCBAttribut.isSelected()) trouverAttribut(this.jTFNom.getText());
/* 133 */       afficherResultat();
/* 134 */       if (this.listeTrouver.size() > 0) {
/* 135 */         this.entiteSelect = ((IhmEntiteRelation)this.listeTrouver.get(0));
/* 136 */         this.jListResult.setSelectedIndex(0);
/*     */       } else {
/* 138 */         this.entiteSelect = null;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/* 143 */   public void remplacerEntiteRelation(String nom, String newName) { for (int i = 0; i < this.listeTrouver.size(); i++) {
/* 144 */       if ((this.listeTrouver.get(i) instanceof IhmEntite2)) {
/* 145 */         IhmEntite2 ent = (IhmEntite2)this.listeTrouver.get(i);
/* 146 */         if (ent.getEntite().getNom().contains(nom)) {
/* 147 */           ent.getEntite().setNom(ent.getEntite().getNom().replace(nom, newName));
/*     */         }
/*     */       }
/* 150 */       if ((this.listeTrouver.get(i) instanceof IhmRelation2)) {
/* 151 */         IhmRelation2 rel = (IhmRelation2)this.listeTrouver.get(i);
/* 152 */         if (rel.getRelation().getNom().contains(nom)) {
/* 153 */           rel.getRelation().setNom(rel.getRelation().getNom().replace(nom, newName));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void remplacerEntite(String nom, String newName) {
/* 160 */     for (int i = 0; i < this.listeTrouver.size(); i++) {
/* 161 */       if ((this.listeTrouver.get(i) instanceof IhmEntite2)) {
/* 162 */         IhmEntite2 ent = (IhmEntite2)this.listeTrouver.get(i);
/* 163 */         if (ent.getEntite().getNom().contains(nom)) {
/* 164 */           ent.getEntite().setNom(ent.getEntite().getNom().replace(nom, newName));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void remplacerRelation(String nom, String newName)
/*     */   {
/* 172 */     for (int i = 0; i < this.listeTrouver.size(); i++) {
/* 173 */       if ((this.listeTrouver.get(i) instanceof IhmRelation2)) {
/* 174 */         IhmRelation2 rel = (IhmRelation2)this.listeTrouver.get(i);
/* 175 */         if (rel.getRelation().getNom().contains(nom)) {
/* 176 */           rel.getRelation().setNom(rel.getRelation().getNom().replace(nom, newName));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void remplacerEntiteRelationAttribut(String nom, String newName)
/*     */   {
/* 184 */     ArrayList<Merise.Attribut> listeAtt = new ArrayList();
/* 185 */     for (int i = 0; i < this.listeTrouver.size(); i++) {
/* 186 */       if ((this.listeTrouver.get(i) instanceof IhmEntite2)) {
/* 187 */         IhmEntite2 ent = (IhmEntite2)this.listeTrouver.get(i);
/* 188 */         listeAtt = ent.getEntite().getListeAttributs();
/* 189 */         if (ent.getEntite().getNom().contains(nom)) {
/* 190 */           ent.getEntite().setNom(ent.getEntite().getNom().replace(nom, newName));
/*     */         }
/* 192 */         remplacerAttribut(listeAtt, nom, newName);
/*     */       }
/* 194 */       if ((this.listeTrouver.get(i) instanceof IhmRelation2)) {
/* 195 */         IhmRelation2 rel = (IhmRelation2)this.listeTrouver.get(i);
/* 196 */         listeAtt = rel.getRelation().getListeAttributs();
/* 197 */         remplacerAttribut(listeAtt, nom, newName);
/* 198 */         if (rel.getRelation().getNom().contains(nom)) {
/* 199 */           rel.getRelation().setNom(rel.getRelation().getNom().replace(nom, newName));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void remplacerEntiteAttribut(String nom, String newName)
/*     */   {
/* 208 */     ArrayList<Merise.Attribut> listeAtt = new ArrayList();
/* 209 */     for (int i = 0; i < this.listeTrouver.size(); i++) {
/* 210 */       if ((this.listeTrouver.get(i) instanceof IhmEntite2)) {
/* 211 */         IhmEntite2 ent = (IhmEntite2)this.listeTrouver.get(i);
/* 212 */         listeAtt = ent.getEntite().getListeAttributs();
/* 213 */         remplacerAttribut(listeAtt, nom, newName);
/* 214 */         if (ent.getEntite().getNom().contains(nom)) {
/* 215 */           ent.getEntite().setNom(ent.getEntite().getNom().replace(nom, newName));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void remplacerRelationAttribut(String nom, String newName)
/*     */   {
/* 224 */     ArrayList<Merise.Attribut> listeAtt = new ArrayList();
/* 225 */     for (int i = 0; i < this.listeTrouver.size(); i++)
/*     */     {
/* 227 */       if ((this.listeTrouver.get(i) instanceof IhmRelation2)) {
/* 228 */         IhmRelation2 rel = (IhmRelation2)this.listeTrouver.get(i);
/* 229 */         listeAtt = rel.getRelation().getListeAttributs();
/* 230 */         remplacerAttribut(listeAtt, nom, newName);
/* 231 */         if (rel.getRelation().getNom().contains(nom)) {
/* 232 */           rel.getRelation().setNom(rel.getRelation().getNom().replace(nom, newName));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void remplacerAttribut(ArrayList<Merise.Attribut> listeAtt, String nom, String newName)
/*     */   {
/* 243 */     for (int i = 0; i < listeAtt.size(); i++) {
/* 244 */       if (((Merise.Attribut)listeAtt.get(i)).getNom().contains(nom)) {
/* 245 */         ((Merise.Attribut)listeAtt.get(i)).setNom(((Merise.Attribut)listeAtt.get(i)).getNom().replace(nom, newName));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void remplacerAttribut(String nom, String newName) {
/* 251 */     ArrayList<Merise.Attribut> listeAtt = new ArrayList();
/* 252 */     for (int i = 0; i < this.listeTrouver.size(); i++) {
/* 253 */       if ((this.listeTrouver.get(i) instanceof IhmEntite2)) {
/* 254 */         IhmEntite2 ent = (IhmEntite2)this.listeTrouver.get(i);
/* 255 */         listeAtt = ent.getEntite().getListeAttributs();
/* 256 */         remplacerAttribut(listeAtt, nom, newName);
/*     */       }
/* 258 */       if ((this.listeTrouver.get(i) instanceof IhmRelation2)) {
/* 259 */         IhmRelation2 rel = (IhmRelation2)this.listeTrouver.get(i);
/* 260 */         listeAtt = rel.getRelation().getListeAttributs();
/* 261 */         remplacerAttribut(listeAtt, nom, newName);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void remplacerEntitieRelationNom(IhmEntiteRelation entRel, String nom, String newNom)
/*     */   {
/* 268 */     if ((entRel instanceof IhmEntite2)) {
/* 269 */       IhmEntite2 ent = (IhmEntite2)entRel;
/* 270 */       ent.getEntite().setNom(ent.getEntite().getNom().replace(nom, newNom));
/*     */     }
/* 272 */     if ((entRel instanceof IhmRelation2)) {
/* 273 */       IhmRelation2 rel = (IhmRelation2)entRel;
/* 274 */       rel.getRelation().setNom(rel.getRelation().getNom().replace(nom, newNom));
/*     */     }
/*     */   }
/*     */   
/*     */   public void remplacerEntitieNom(IhmEntiteRelation entRel, String nom, String newNom) {
/* 279 */     if ((entRel instanceof IhmEntite2)) {
/* 280 */       IhmEntite2 ent = (IhmEntite2)entRel;
/* 281 */       ent.getEntite().setNom(ent.getEntite().getNom().replace(nom, newNom));
/*     */     }
/*     */   }
/*     */   
/*     */   public void remplacerRelationNom(IhmEntiteRelation entRel, String nom, String newNom) {
/* 286 */     if ((entRel instanceof IhmRelation2)) {
/* 287 */       IhmRelation2 rel = (IhmRelation2)entRel;
/* 288 */       rel.getRelation().setNom(rel.getRelation().getNom().replace(nom, newNom));
/*     */     }
/*     */   }
/*     */   
/*     */   public void remplacerEntitieRelationNomEtAttribut(IhmEntiteRelation entRel, String nom, String newNom) {
/* 293 */     ArrayList<Merise.Attribut> listeAtt = new ArrayList();
/* 294 */     if ((entRel instanceof IhmEntite2)) {
/* 295 */       IhmEntite2 ent = (IhmEntite2)entRel;
/* 296 */       ent.getEntite().setNom(ent.getEntite().getNom().replace(nom, newNom));
/* 297 */       listeAtt = ent.getEntite().getListeAttributs();
/* 298 */       remplacerAttribut(listeAtt, nom, newNom);
/*     */     }
/* 300 */     if ((entRel instanceof IhmRelation2)) {
/* 301 */       IhmRelation2 rel = (IhmRelation2)entRel;
/* 302 */       rel.getRelation().setNom(rel.getRelation().getNom().replace(nom, newNom));
/* 303 */       listeAtt = rel.getRelation().getListeAttributs();
/* 304 */       remplacerAttribut(listeAtt, nom, newNom);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void remplacerAttribut(IhmEntiteRelation entRel, String nom, String newNom)
/*     */   {
/* 312 */     ArrayList<Merise.Attribut> listeAtt = new ArrayList();
/* 313 */     if ((entRel instanceof IhmEntite2)) {
/* 314 */       IhmEntite2 ent = (IhmEntite2)entRel;
/* 315 */       listeAtt = ent.getEntite().getListeAttributs();
/* 316 */       remplacerAttribut(listeAtt, nom, newNom);
/*     */     }
/* 318 */     if ((entRel instanceof IhmRelation2)) {
/* 319 */       IhmRelation2 rel = (IhmRelation2)entRel;
/* 320 */       listeAtt = rel.getRelation().getListeAttributs();
/* 321 */       remplacerAttribut(listeAtt, nom, newNom);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void remplacerEntitieNomEtAttribut(IhmEntiteRelation entRel, String nom, String newNom)
/*     */   {
/* 329 */     ArrayList<Merise.Attribut> listeAtt = new ArrayList();
/* 330 */     if ((entRel instanceof IhmEntite2)) {
/* 331 */       IhmEntite2 ent = (IhmEntite2)entRel;
/* 332 */       ent.getEntite().setNom(ent.getEntite().getNom().replace(nom, newNom));
/* 333 */       listeAtt = ent.getEntite().getListeAttributs();
/* 334 */       remplacerAttribut(listeAtt, nom, newNom);
/*     */     }
/*     */   }
/*     */   
/*     */   public void remplacerRelationNomEtAttribut(IhmEntiteRelation entRel, String nom, String newNom)
/*     */   {
/* 340 */     ArrayList<Merise.Attribut> listeAtt = new ArrayList();
/* 341 */     if ((entRel instanceof IhmRelation2)) {
/* 342 */       IhmRelation2 rel = (IhmRelation2)entRel;
/* 343 */       rel.getRelation().setNom(rel.getRelation().getNom().replace(nom, newNom));
/* 344 */       listeAtt = rel.getRelation().getListeAttributs();
/* 345 */       remplacerAttribut(listeAtt, nom, newNom);
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
/* 359 */     this.jPanel1 = new javax.swing.JPanel();
/* 360 */     this.jLabel1 = new javax.swing.JLabel();
/* 361 */     this.jTFNom = new javax.swing.JTextField();
/* 362 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 363 */     this.jListResult = new javax.swing.JList();
/* 364 */     this.jCBEntite = new javax.swing.JCheckBox();
/* 365 */     this.jCBRelation = new javax.swing.JCheckBox();
/* 366 */     this.jCBAttribut = new javax.swing.JCheckBox();
/* 367 */     this.jLabel2 = new javax.swing.JLabel();
/* 368 */     this.jBtRecherche = new javax.swing.JButton();
/* 369 */     this.jLabel3 = new javax.swing.JLabel();
/* 370 */     this.jTFRemplace = new javax.swing.JTextField();
/* 371 */     this.jButton1 = new javax.swing.JButton();
/* 372 */     this.jButton2 = new javax.swing.JButton();
/* 373 */     this.jLabRecherche = new javax.swing.JLabel();
/* 374 */     this.jPanel2 = new javax.swing.JPanel();
/* 375 */     this.jBtFermer = new javax.swing.JButton();
/*     */     
/* 377 */     setDefaultCloseOperation(2);
/* 378 */     setTitle("Chercher et remplacer ");
/* 379 */     setResizable(false);
/*     */     
/* 381 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 383 */     this.jLabel1.setText("Rechercher");
/*     */     
/* 385 */     this.jTFNom.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyPressed(java.awt.event.KeyEvent evt) {
/* 387 */         FormeRechercheRemplacer.this.jTFNomKeyPressed(evt);
/*     */       }
/*     */       
/* 390 */     });
/* 391 */     this.jListResult.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 393 */         FormeRechercheRemplacer.this.jListResultMouseClicked(evt);
/*     */       }
/* 395 */     });
/* 396 */     this.jListResult.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyReleased(java.awt.event.KeyEvent evt) {
/* 398 */         FormeRechercheRemplacer.this.jListResultKeyReleased(evt);
/*     */       }
/* 400 */     });
/* 401 */     this.jScrollPane1.setViewportView(this.jListResult);
/*     */     
/* 403 */     this.jCBEntite.setSelected(true);
/* 404 */     this.jCBEntite.setText("Entité");
/*     */     
/* 406 */     this.jCBRelation.setSelected(true);
/* 407 */     this.jCBRelation.setText("Relation");
/*     */     
/* 409 */     this.jCBAttribut.setSelected(true);
/* 410 */     this.jCBAttribut.setText("Attribut");
/*     */     
/* 412 */     this.jLabel2.setText("Résultat de la recherche  ");
/*     */     
/* 414 */     this.jBtRecherche.setText("Recherche ");
/* 415 */     this.jBtRecherche.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 417 */         FormeRechercheRemplacer.this.jBtRechercheActionPerformed(evt);
/*     */       }
/*     */       
/* 420 */     });
/* 421 */     this.jLabel3.setText("Remplacer");
/*     */     
/* 423 */     this.jButton1.setText("Remplacer");
/* 424 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 426 */         FormeRechercheRemplacer.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/* 429 */     });
/* 430 */     this.jButton2.setText("Remplacer tout");
/* 431 */     this.jButton2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 433 */         FormeRechercheRemplacer.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/* 436 */     });
/* 437 */     this.jLabRecherche.setForeground(new java.awt.Color(0, 0, 102));
/* 438 */     this.jLabRecherche.setText("qsdqsdqsdqsdqsdqsdqsdqsdqsdqsdqsdqsdqsdqsdqsdqsdqsdsd");
/*     */     
/* 440 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 441 */     this.jPanel1.setLayout(jPanel1Layout);
/* 442 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 596, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBEntite, GroupLayout.Alignment.TRAILING, -2, 93, -2).addComponent(this.jLabel2, GroupLayout.Alignment.TRAILING)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabRecherche, -1, 320, 32767).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jCBRelation, -2, 103, -2).addGap(62, 62, 62).addComponent(this.jCBAttribut, -2, 105, -2))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, -2).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jBtRecherche, GroupLayout.Alignment.TRAILING, -1, 117, 32767).addComponent(this.jButton1, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jButton2, GroupLayout.Alignment.TRAILING, -1, -1, 32767))).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3, -2, 63, -2).addComponent(this.jLabel1, -2, 69, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jTFRemplace, -1, 517, 32767).addComponent(this.jTFNom, GroupLayout.Alignment.LEADING, -1, 517, 32767)))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 474 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFNom, -2, -1, -2)).addGap(11, 11, 11).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTFRemplace, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtRecherche).addComponent(this.jCBAttribut).addComponent(this.jCBEntite).addComponent(this.jCBRelation)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jLabRecherche)).addComponent(this.jButton2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 211, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 504 */     this.jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 506 */     this.jBtFermer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 507 */     this.jBtFermer.setText("Fermer");
/* 508 */     this.jBtFermer.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 510 */         FormeRechercheRemplacer.this.jBtFermerActionPerformed(evt);
/*     */       }
/*     */       
/* 513 */     });
/* 514 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 515 */     this.jPanel2.setLayout(jPanel2Layout);
/* 516 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(519, 32767).addComponent(this.jBtFermer).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 523 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jBtFermer).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 531 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 532 */     getContentPane().setLayout(layout);
/* 533 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 542 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 552 */     pack();
/*     */   }
/*     */   
/*     */ 
/*     */   private void jListResultMouseClicked(java.awt.event.MouseEvent evt) {}
/*     */   
/*     */ 
/*     */   private void jListResultKeyReleased(java.awt.event.KeyEvent evt) {}
/*     */   
/*     */ 
/*     */   private void jBtRechercheActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 564 */     this.jLabRecherche.setText(this.jTFNom.getText());
/* 565 */     lancerRecherche();
/* 566 */     if (this.listeTrouver.size() != 0) {
/* 567 */       this.entiteSelect = ((IhmEntiteRelation)this.listeTrouver.get(0));
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBtFermerActionPerformed(java.awt.event.ActionEvent evt) {
/* 572 */     this.listeTrouver.clear();
/* 573 */     dispose();
/*     */   }
/*     */   
/*     */   private void jTFNomKeyPressed(java.awt.event.KeyEvent evt) {
/* 577 */     if (evt.getKeyCode() == 10) {
/* 578 */       this.jLabRecherche.setText(this.jTFNom.getText());
/* 579 */       lancerRecherche();
/*     */     }
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 585 */     this.jTFRemplace.setText(this.jTFRemplace.getText().trim());
/*     */     
/* 587 */     if (this.jTFRemplace.getText().trim().length() == 0) {
/* 588 */       javax.swing.JOptionPane.showMessageDialog(this.frm, "Le champ Remplacer ne doit pas être vide !");
/* 589 */       return;
/*     */     }
/*     */     
/* 592 */     if (this.entiteSelect == null) {
/* 593 */       javax.swing.JOptionPane.showMessageDialog(this.frm, "Aucune entité ou relation trouvée n'est selectionnée !");
/* 594 */       return;
/*     */     }
/*     */     
/* 597 */     boolean r = false;boolean e = false;boolean a = false;
/*     */     
/* 599 */     if (this.jCBRelation.isSelected()) {
/* 600 */       r = true;
/*     */     }
/* 602 */     if (this.jCBEntite.isSelected()) {
/* 603 */       e = true;
/*     */     }
/* 605 */     if (this.jCBAttribut.isSelected()) {
/* 606 */       a = true;
/*     */     }
/*     */     
/* 609 */     if (e) {
/* 610 */       if (r) {
/* 611 */         if (a) {
/* 612 */           remplacerEntitieNomEtAttribut(this.entiteSelect, this.jLabRecherche.getText(), this.jTFRemplace.getText());
/*     */         }
/*     */         else {
/* 615 */           remplacerEntitieRelationNom(this.entiteSelect, this.jLabRecherche.getText(), this.jTFRemplace.getText());
/*     */         }
/*     */       }
/* 618 */       else if (a)
/*     */       {
/* 620 */         remplacerEntitieNomEtAttribut(this.entiteSelect, this.jLabRecherche.getText(), this.jTFRemplace.getText());
/*     */       }
/*     */       else {
/* 623 */         remplacerEntitieNom(this.entiteSelect, this.jLabRecherche.getText(), this.jTFRemplace.getText());
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 628 */     else if (r) {
/* 629 */       if (a)
/*     */       {
/* 631 */         remplacerRelationNomEtAttribut(this.entiteSelect, this.jLabRecherche.getText(), this.jTFRemplace.getText());
/*     */       }
/*     */       else {
/* 634 */         remplacerRelationNom(this.entiteSelect, this.jLabRecherche.getText(), this.jTFRemplace.getText());
/*     */       }
/*     */     }
/* 637 */     else if (a)
/*     */     {
/* 639 */       remplacerAttribut(this.entiteSelect, this.jLabRecherche.getText(), this.jTFRemplace.getText());
/*     */     } else {
/* 641 */       javax.swing.JOptionPane.showMessageDialog(this.frm, "Aucune case n'est cochée pour effectuer le remplacement!");
/*     */     }
/*     */     
/*     */ 
/* 645 */     this.frm.getPage().repaint();
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
/* 649 */     boolean r = false;boolean e = false;boolean a = false;
/* 650 */     this.jTFRemplace.setText(this.jTFRemplace.getText().trim());
/*     */     
/* 652 */     if (this.jTFRemplace.getText().trim().length() == 0) {
/* 653 */       javax.swing.JOptionPane.showMessageDialog(this.frm, "Le champ Remplacer ne doit pas être vide !");
/* 654 */       return;
/*     */     }
/*     */     
/* 657 */     if (this.jCBRelation.isSelected()) {
/* 658 */       r = true;
/*     */     }
/* 660 */     if (this.jCBEntite.isSelected()) {
/* 661 */       e = true;
/*     */     }
/* 663 */     if (this.jCBAttribut.isSelected()) {
/* 664 */       a = true;
/*     */     }
/*     */     
/* 667 */     if (e) {
/* 668 */       if (r) {
/* 669 */         if (a)
/*     */         {
/* 671 */           remplacerEntiteRelationAttribut(this.jLabRecherche.getText(), this.jTFRemplace.getText());
/*     */         }
/*     */         else {
/* 674 */           remplacerEntiteRelation(this.jLabRecherche.getText(), this.jTFRemplace.getText());
/*     */         }
/*     */       }
/* 677 */       else if (a)
/*     */       {
/* 679 */         remplacerEntiteAttribut(this.jLabRecherche.getText(), this.jTFRemplace.getText());
/*     */       }
/*     */       else {
/* 682 */         remplacerAttribut(this.jLabRecherche.getText(), this.jTFRemplace.getText());
/*     */       }
/*     */       
/*     */ 
/*     */     }
/* 687 */     else if (r) {
/* 688 */       if (a)
/*     */       {
/* 690 */         remplacerRelationAttribut(this.jLabRecherche.getText(), this.jTFRemplace.getText());
/*     */       }
/*     */       else {
/* 693 */         remplacerRelation(this.jLabRecherche.getText(), this.jTFRemplace.getText());
/*     */       }
/*     */     }
/* 696 */     else if (a)
/*     */     {
/* 698 */       remplacerAttribut(this.jLabRecherche.getText(), this.jTFRemplace.getText());
/*     */     } else {
/* 700 */       javax.swing.JOptionPane.showMessageDialog(this.frm, "Aucune case n'est cochée pour effectuer le remplacement!");
/*     */     }
/*     */     
/*     */ 
/* 704 */     this.frm.getPage().repaint();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeRechercheRemplacer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */