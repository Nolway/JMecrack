/*     */ package formes;
/*     */ 
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ 
/*     */ public class FormeRecherche extends javax.swing.JDialog
/*     */ {
/*     */   private ArrayList<IhmEntiteRelation> listeER;
/*     */   private ArrayList<IhmEntiteRelation> listeTrouver;
/*     */   private IhmEntiteRelation entiteSelect;
/*     */   private boolean resultFermer;
/*     */   ihm.Principale frm;
/*     */   private JButton jBtFermer;
/*     */   private JButton jBtOk;
/*     */   private JButton jBtRecherche;
/*     */   private javax.swing.JCheckBox jCBAttribut;
/*     */   private javax.swing.JCheckBox jCBEntite;
/*     */   private javax.swing.JCheckBox jCBRelation;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JList jListResult;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JTextField jTFNom;
/*     */   
/*     */   public FormeRecherche(ihm.Principale parent, boolean modal, ArrayList<IhmEntiteRelation> liste)
/*     */   {
/*  34 */     super(parent, modal);
/*  35 */     initComponents();
/*  36 */     this.frm = parent;
/*  37 */     this.listeER = liste;
/*  38 */     this.entiteSelect = null;
/*  39 */     this.resultFermer = false;
/*  40 */     this.listeTrouver = new ArrayList();
/*  41 */     setLocation(this.frm.getX() + 300, this.frm.getY() + 100);
/*  42 */     this.jBtFermer.setMnemonic(65);
/*  43 */     this.jBtOk.setMnemonic(10);
/*  44 */     this.jBtRecherche.setMnemonic(82);
/*     */   }
/*     */   
/*     */   private boolean estTrouverAttribut(ArrayList<Merise.Attribut> listeAtt, String nom)
/*     */   {
/*  49 */     for (int i = 0; i < listeAtt.size(); i++) {
/*  50 */       if (((Merise.Attribut)listeAtt.get(i)).getNom().trim().toUpperCase().contains(nom.trim().toUpperCase())) return true;
/*     */     }
/*  52 */     return false;
/*     */   }
/*     */   
/*     */   private void trouverEntite(String nom) {
/*  56 */     for (int i = 0; i < this.listeER.size(); i++) {
/*  57 */       if ((((IhmEntiteRelation)this.listeER.get(i)).getClass().getName().equals("IhmMCD2.IhmEntite2")) && 
/*  58 */         (((IhmMCD2.IhmEntite2)this.listeER.get(i)).getEntite().getNom().trim().toUpperCase().contains(nom.trim().toUpperCase())) && 
/*  59 */         (!existeDansTrouver((IhmEntiteRelation)this.listeER.get(i)))) { this.listeTrouver.add(this.listeER.get(i));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void trouverRelation(String nom)
/*     */   {
/*  67 */     for (int i = 0; i < this.listeER.size(); i++) {
/*  68 */       if ((((IhmEntiteRelation)this.listeER.get(i)).getClass().getName().equals("IhmMCD2.IhmRelation2")) && 
/*  69 */         (((IhmMCD2.IhmRelation2)this.listeER.get(i)).getRelation().getNom().trim().toUpperCase().contains(nom.trim().toUpperCase())) && 
/*  70 */         (!existeDansTrouver((IhmEntiteRelation)this.listeER.get(i)))) { this.listeTrouver.add(this.listeER.get(i));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void trouverAttribut(String nom)
/*     */   {
/*  77 */     for (int i = 0; i < this.listeER.size(); i++) {
/*  78 */       if ((((IhmEntiteRelation)this.listeER.get(i)).getClass().getName().equals("IhmMCD2.IhmRelation2")) && 
/*  79 */         (!existeDansTrouver((IhmEntiteRelation)this.listeER.get(i))) && 
/*  80 */         (estTrouverAttribut(((IhmMCD2.IhmRelation2)this.listeER.get(i)).getRelation().getListeAttributs(), nom))) { this.listeTrouver.add(this.listeER.get(i));
/*     */       }
/*     */       
/*     */ 
/*  84 */       if ((((IhmEntiteRelation)this.listeER.get(i)).getClass().getName().equals("IhmMCD2.IhmEntite2")) && 
/*  85 */         (!existeDansTrouver((IhmEntiteRelation)this.listeER.get(i))) && 
/*  86 */         (estTrouverAttribut(((IhmMCD2.IhmEntite2)this.listeER.get(i)).getEntite().getListeAttributs(), nom))) { this.listeTrouver.add(this.listeER.get(i));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean existeDansTrouver(IhmEntiteRelation entRel)
/*     */   {
/*  94 */     if (entRel.getClass().getName().equals("IhmMCD2.IhmEntite2")) {
/*  95 */       for (int i = 0; i < this.listeTrouver.size(); i++) {
/*  96 */         if ((((IhmEntiteRelation)this.listeTrouver.get(i)).getClass().getName().equals("IhmMCD2.IhmRelation2")) && 
/*  97 */           (((IhmMCD2.IhmRelation2)this.listeTrouver.get(i)).getRelation().getNom().trim().toUpperCase().contains(((IhmMCD2.IhmEntite2)entRel).getEntite().getNom().trim().toUpperCase()))) { return true;
/*     */         }
/*  99 */         if ((((IhmEntiteRelation)this.listeTrouver.get(i)).getClass().getName().equals("IhmMCD2.IhmEntite2")) && 
/* 100 */           (((IhmMCD2.IhmEntite2)this.listeTrouver.get(i)).getEntite().getNom().trim().toUpperCase().contains(((IhmMCD2.IhmEntite2)entRel).getEntite().getNom().trim().toUpperCase()))) { return true;
/*     */         }
/*     */       }
/*     */     }
/* 104 */     if (entRel.getClass().getName().equals("IhmMCD2.IhmRelation2")) {
/* 105 */       for (int i = 0; i < this.listeTrouver.size(); i++) {
/* 106 */         if ((((IhmEntiteRelation)this.listeTrouver.get(i)).getClass().getName().equals("IhmMCD2.IhmRelation2")) && 
/* 107 */           (((IhmMCD2.IhmRelation2)this.listeTrouver.get(i)).getRelation().getNom().trim().toUpperCase().contains(((IhmMCD2.IhmRelation2)entRel).getRelation().getNom().trim().toUpperCase()))) { return true;
/*     */         }
/* 109 */         if ((((IhmEntiteRelation)this.listeTrouver.get(i)).getClass().getName().equals("IhmMCD2.IhmEntite2")) && 
/* 110 */           (((IhmMCD2.IhmEntite2)this.listeTrouver.get(i)).getEntite().getNom().trim().toUpperCase().contains(((IhmMCD2.IhmRelation2)entRel).getRelation().getNom().trim().toUpperCase()))) { return true;
/*     */         }
/*     */       }
/*     */     }
/* 114 */     return false;
/*     */   }
/*     */   
/*     */   private void afficherResultat() {
/* 118 */     this.jListResult.setListData(this.listeTrouver.toArray());
/*     */   }
/*     */   
/*     */   private void lancerRecherche() {
/* 122 */     if (this.jTFNom.getText().trim().length() > 0) {
/* 123 */       this.jListResult.removeAll();
/* 124 */       this.listeTrouver.clear();
/* 125 */       if (this.jCBEntite.isSelected()) trouverEntite(this.jTFNom.getText());
/* 126 */       if (this.jCBRelation.isSelected()) trouverRelation(this.jTFNom.getText());
/* 127 */       if (this.jCBAttribut.isSelected()) trouverAttribut(this.jTFNom.getText());
/* 128 */       afficherResultat();
/* 129 */       if (this.listeTrouver.size() > 0) {
/* 130 */         this.entiteSelect = ((IhmEntiteRelation)this.listeTrouver.get(0));
/* 131 */         this.jListResult.setSelectedIndex(0);
/*     */       } else {
/* 133 */         this.entiteSelect = null;
/*     */       }
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
/*     */   private void initComponents()
/*     */   {
/* 147 */     this.jPanel1 = new javax.swing.JPanel();
/* 148 */     this.jLabel1 = new javax.swing.JLabel();
/* 149 */     this.jTFNom = new javax.swing.JTextField();
/* 150 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 151 */     this.jListResult = new javax.swing.JList();
/* 152 */     this.jCBEntite = new javax.swing.JCheckBox();
/* 153 */     this.jCBRelation = new javax.swing.JCheckBox();
/* 154 */     this.jLabel2 = new javax.swing.JLabel();
/* 155 */     this.jCBAttribut = new javax.swing.JCheckBox();
/* 156 */     this.jBtRecherche = new JButton();
/* 157 */     this.jPanel2 = new javax.swing.JPanel();
/* 158 */     this.jBtOk = new JButton();
/* 159 */     this.jBtFermer = new JButton();
/*     */     
/* 161 */     setDefaultCloseOperation(2);
/* 162 */     setTitle("Recherche");
/* 163 */     setResizable(false);
/*     */     
/* 165 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 167 */     this.jLabel1.setText("Rechercher");
/*     */     
/* 169 */     this.jTFNom.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyPressed(java.awt.event.KeyEvent evt) {
/* 171 */         FormeRecherche.this.jTFNomKeyPressed(evt);
/*     */       }
/*     */       
/* 174 */     });
/* 175 */     this.jListResult.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 177 */         FormeRecherche.this.jListResultMouseClicked(evt);
/*     */       }
/* 179 */     });
/* 180 */     this.jListResult.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyReleased(java.awt.event.KeyEvent evt) {
/* 182 */         FormeRecherche.this.jListResultKeyReleased(evt);
/*     */       }
/* 184 */     });
/* 185 */     this.jScrollPane1.setViewportView(this.jListResult);
/*     */     
/* 187 */     this.jCBEntite.setSelected(true);
/* 188 */     this.jCBEntite.setText("Entité");
/*     */     
/* 190 */     this.jCBRelation.setSelected(true);
/* 191 */     this.jCBRelation.setText("Relation");
/*     */     
/* 193 */     this.jLabel2.setText("Résultat de la recherche  ");
/*     */     
/* 195 */     this.jCBAttribut.setSelected(true);
/* 196 */     this.jCBAttribut.setText("Attribut");
/*     */     
/* 198 */     this.jBtRecherche.setText("Recherche ");
/* 199 */     this.jBtRecherche.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 201 */         FormeRecherche.this.jBtRechercheActionPerformed(evt);
/*     */       }
/*     */       
/* 204 */     });
/* 205 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 206 */     this.jPanel1.setLayout(jPanel1Layout);
/* 207 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 510, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1, -2, 77, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTFNom, -1, 423, 32767)).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addGap(13, 13, 13).addComponent(this.jCBEntite, -1, 110, 32767)).addComponent(this.jLabel2, GroupLayout.Alignment.LEADING)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, 32767).addComponent(this.jBtRecherche)).addGroup(jPanel1Layout.createSequentialGroup().addGap(94, 94, 94).addComponent(this.jCBRelation, -1, 119, 32767).addGap(95, 95, 95).addComponent(this.jCBAttribut, -2, 79, -2))))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 234 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1, -2, 17, -2).addComponent(this.jTFNom, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBAttribut).addComponent(this.jCBRelation).addComponent(this.jCBEntite)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(34, 34, 34).addComponent(this.jLabel2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jBtRecherche))).addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, 277, -2).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 258 */     this.jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 260 */     this.jBtOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 261 */     this.jBtOk.setText("Allez à");
/* 262 */     this.jBtOk.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 264 */         FormeRecherche.this.jBtOkActionPerformed(evt);
/*     */       }
/*     */       
/* 267 */     });
/* 268 */     this.jBtFermer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 269 */     this.jBtFermer.setText("Annuler");
/* 270 */     this.jBtFermer.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 272 */         FormeRecherche.this.jBtFermerActionPerformed(evt);
/*     */       }
/*     */       
/* 275 */     });
/* 276 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 277 */     this.jPanel2.setLayout(jPanel2Layout);
/* 278 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(338, 32767).addComponent(this.jBtFermer).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtOk).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 287 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtOk).addComponent(this.jBtFermer)).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 297 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 298 */     getContentPane().setLayout(layout);
/* 299 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 308 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 318 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtRechercheActionPerformed(java.awt.event.ActionEvent evt) {
/* 322 */     lancerRecherche();
/*     */   }
/*     */   
/*     */   private void jBtFermerActionPerformed(java.awt.event.ActionEvent evt) {
/* 326 */     this.listeTrouver.clear();
/* 327 */     dispose();
/*     */   }
/*     */   
/*     */   private void jListResultMouseClicked(java.awt.event.MouseEvent evt) {
/* 331 */     if (this.listeTrouver.size() > 0) {
/* 332 */       this.entiteSelect = ((IhmEntiteRelation)this.jListResult.getSelectedValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void jListResultKeyReleased(java.awt.event.KeyEvent evt) {
/* 337 */     if (this.listeTrouver.size() > 0) {
/* 338 */       this.entiteSelect = ((IhmEntiteRelation)this.jListResult.getSelectedValue());
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBtOkActionPerformed(java.awt.event.ActionEvent evt) {
/* 343 */     this.resultFermer = true;
/* 344 */     dispose();
/*     */   }
/*     */   
/*     */   private void jTFNomKeyPressed(java.awt.event.KeyEvent evt) {
/* 348 */     if (evt.getKeyCode() == 10) {
/* 349 */       lancerRecherche();
/*     */     }
/*     */   }
/*     */   
/*     */   public IhmEntiteRelation getEntiteSelect() {
/* 354 */     return this.entiteSelect;
/*     */   }
/*     */   
/*     */   public boolean isResultFermer() {
/* 358 */     return this.resultFermer;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeRecherche.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */