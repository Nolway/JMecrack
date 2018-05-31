/*     */ package formes;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class FormeImporterDictionnaire extends javax.swing.JDialog
/*     */ {
/*     */   private ihm.Principale frm;
/*     */   private IhmMCD.IhmProjet projet;
/*     */   private ArrayList<Merise.Attribut> listeAttribut;
/*     */   private javax.swing.JButton jBtAjouter;
/*     */   private javax.swing.JButton jBtAnnuler;
/*     */   private javax.swing.JButton jBtSupprimer;
/*     */   private javax.swing.JButton jBtValider;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JList jListAttribut;
/*     */   private javax.swing.JList jListAttributNew;
/*     */   private javax.swing.JList jListMCD;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JPanel jPanel3;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JScrollPane jScrollPane2;
/*     */   private javax.swing.JScrollPane jScrollPane3;
/*     */   
/*     */   public FormeImporterDictionnaire(ihm.Principale frm, IhmMCD.IhmProjet projet, boolean modal)
/*     */   {
/*  32 */     super(frm, modal);
/*  33 */     initComponents();
/*  34 */     setLocation(frm.getX() + 250, frm.getY() + 100);
/*  35 */     this.frm = frm;
/*  36 */     this.projet = projet;
/*  37 */     this.listeAttribut = new ArrayList();
/*  38 */     copierListAttribut(projet.getFormeMCD().getPage().getListeAttribut());
/*  39 */     remplirListeMCD();
/*  40 */     this.jBtAnnuler.setMnemonic(65);
/*  41 */     this.jBtValider.setMnemonic(10);
/*  42 */     this.jBtSupprimer.setMnemonic(83);
/*  43 */     this.jBtAjouter.setMnemonic(67);
/*     */   }
/*     */   
/*     */   private void copierListAttribut(ArrayList<Merise.Attribut> lA)
/*     */   {
/*  48 */     for (int i = 0; i < this.projet.getFormeMCD().getPage().getListeAttribut().size(); i++) {
/*  49 */       this.listeAttribut.add(((Merise.Attribut)this.projet.getFormeMCD().getPage().getListeAttribut().get(i)).copier());
/*     */     }
/*     */   }
/*     */   
/*     */   private void remplirListeMCD() {
/*  54 */     ArrayList<IhmMCD.IhmProjet> listPro = new ArrayList();
/*  55 */     for (int i = 0; i < this.frm.getListeProjet().size(); i++) {
/*  56 */       if (this.frm.getListeProjet().get(i) != this.projet) listPro.add(this.frm.getListeProjet().get(i));
/*     */     }
/*  58 */     this.jListMCD.setListData(listPro.toArray());
/*  59 */     if (listPro.size() > 0) {
/*  60 */       this.jListMCD.setSelectedIndex(0);
/*  61 */       this.jListAttribut.setListData(((IhmMCD.IhmProjet)listPro.get(0)).getFormeMCD().getPage().getListeAttribut().toArray());
/*     */     }
/*  63 */     this.jListAttributNew.setListData(this.listeAttribut.toArray());
/*     */   }
/*     */   
/*     */   private boolean existeAttribut(Merise.Attribut att) {
/*  67 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/*  68 */       if ((att.getNom().equals(((Merise.Attribut)this.listeAttribut.get(i)).getNom())) && (att.getType().equals(((Merise.Attribut)this.listeAttribut.get(i)).getType())))
/*  69 */         return true;
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   private void ajouterAttribut(Merise.Attribut att) {
/*  75 */     if (!existeAttribut(att)) this.listeAttribut.add(att.copier());
/*     */   }
/*     */   
/*     */   private void supprimerAttribut() {
/*  79 */     int[] att = this.jListAttributNew.getSelectedIndices();
/*  80 */     if (att.length > 0) this.projet.getFormeMCD().setModifier(true);
/*  81 */     for (int i = att.length - 1; i >= 0; i--) {
/*  82 */       this.listeAttribut.remove(att[i]);
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
/*  95 */     this.jPanel1 = new javax.swing.JPanel();
/*  96 */     this.jLabel1 = new javax.swing.JLabel();
/*  97 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  98 */     this.jListMCD = new javax.swing.JList();
/*  99 */     this.jLabel2 = new javax.swing.JLabel();
/* 100 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/* 101 */     this.jListAttribut = new javax.swing.JList();
/* 102 */     this.jPanel2 = new javax.swing.JPanel();
/* 103 */     this.jBtValider = new javax.swing.JButton();
/* 104 */     this.jBtAnnuler = new javax.swing.JButton();
/* 105 */     this.jPanel3 = new javax.swing.JPanel();
/* 106 */     this.jScrollPane3 = new javax.swing.JScrollPane();
/* 107 */     this.jListAttributNew = new javax.swing.JList();
/* 108 */     this.jLabel3 = new javax.swing.JLabel();
/* 109 */     this.jBtSupprimer = new javax.swing.JButton();
/* 110 */     this.jBtAjouter = new javax.swing.JButton();
/*     */     
/* 112 */     setDefaultCloseOperation(2);
/* 113 */     setTitle("Importer des attributs");
/* 114 */     setResizable(false);
/*     */     
/* 116 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 118 */     this.jLabel1.setText("Liste des MCD");
/*     */     
/* 120 */     this.jListMCD.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 122 */         FormeImporterDictionnaire.this.jListMCDMouseClicked(evt);
/*     */       }
/* 124 */     });
/* 125 */     this.jListMCD.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyReleased(java.awt.event.KeyEvent evt) {
/* 127 */         FormeImporterDictionnaire.this.jListMCDKeyReleased(evt);
/*     */       }
/* 129 */     });
/* 130 */     this.jScrollPane1.setViewportView(this.jListMCD);
/*     */     
/* 132 */     this.jLabel2.setText("Liste des attributs du MCD sélectionné ");
/*     */     
/* 134 */     this.jScrollPane2.setViewportView(this.jListAttribut);
/*     */     
/* 136 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 137 */     this.jPanel1.setLayout(jPanel1Layout);
/* 138 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING, -1, 279, 32767).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 279, 32767).addComponent(this.jLabel1, GroupLayout.Alignment.LEADING).addComponent(this.jLabel2, GroupLayout.Alignment.LEADING)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 149 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 92, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 303, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 163 */     this.jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 165 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 166 */     this.jBtValider.setText("Valider ");
/* 167 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 169 */         FormeImporterDictionnaire.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 172 */     });
/* 173 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 174 */     this.jBtAnnuler.setText("Annuler ");
/* 175 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 177 */         FormeImporterDictionnaire.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 180 */     });
/* 181 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 182 */     this.jPanel2.setLayout(jPanel2Layout);
/* 183 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(448, 32767).addComponent(this.jBtAnnuler, -2, 107, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtValider, -2, 98, -2).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 192 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 202 */     this.jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 204 */     this.jListAttributNew.setBackground(new java.awt.Color(212, 228, 226));
/* 205 */     this.jScrollPane3.setViewportView(this.jListAttributNew);
/*     */     
/* 207 */     this.jLabel3.setText("Nouvelle liste des attributs ");
/*     */     
/* 209 */     this.jBtSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/supprimer.png")));
/* 210 */     this.jBtSupprimer.setText("Supprimer ");
/* 211 */     this.jBtSupprimer.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 213 */         FormeImporterDictionnaire.this.jBtSupprimerActionPerformed(evt);
/*     */       }
/*     */       
/* 216 */     });
/* 217 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 218 */     this.jPanel3.setLayout(jPanel3Layout);
/* 219 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -1, 279, 32767).addComponent(this.jLabel3).addComponent(this.jBtSupprimer, GroupLayout.Alignment.TRAILING, -2, 126, -2)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 229 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -1, 385, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtSupprimer).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 241 */     this.jBtAjouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flecheAdroite.PNG")));
/* 242 */     this.jBtAjouter.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 244 */         FormeImporterDictionnaire.this.jBtAjouterActionPerformed(evt);
/*     */       }
/*     */       
/* 247 */     });
/* 248 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 249 */     getContentPane().setLayout(layout);
/* 250 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtAjouter, -2, 57, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -1, -1, 32767)).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 264 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel3, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767))).addGroup(layout.createSequentialGroup().addGap(265, 265, 265).addComponent(this.jBtAjouter))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 281 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt) {
/* 285 */     dispose();
/*     */   }
/*     */   
/*     */   private void jListMCDKeyReleased(java.awt.event.KeyEvent evt) {
/* 289 */     IhmMCD.IhmProjet p = (IhmMCD.IhmProjet)this.jListMCD.getSelectedValue();
/* 290 */     if (p != null) this.jListAttribut.setListData(p.getFormeMCD().getPage().getListeAttribut().toArray());
/*     */   }
/*     */   
/*     */   private void jListMCDMouseClicked(java.awt.event.MouseEvent evt) {
/* 294 */     IhmMCD.IhmProjet p = (IhmMCD.IhmProjet)this.jListMCD.getSelectedValue();
/* 295 */     if (p != null) this.jListAttribut.setListData(p.getFormeMCD().getPage().getListeAttribut().toArray());
/*     */   }
/*     */   
/*     */   private void jBtAjouterActionPerformed(java.awt.event.ActionEvent evt) {
/* 299 */     int[] ind = this.jListAttribut.getSelectedIndices();
/*     */     
/* 301 */     for (int i = 0; i < ind.length; i++) {
/* 302 */       Merise2.Attribut2 att = (Merise2.Attribut2)this.jListAttribut.getSelectedValues()[i];
/* 303 */       att.setKey("");
/* 304 */       att.setAfficher(true);
/* 305 */       att.setHistorisation("");
/* 306 */       ajouterAttribut(att);
/*     */     }
/* 308 */     this.jListAttributNew.setListData(this.listeAttribut.toArray());
/*     */   }
/*     */   
/*     */   private void jBtSupprimerActionPerformed(java.awt.event.ActionEvent evt) {
/* 312 */     supprimerAttribut();
/* 313 */     this.jListAttributNew.setListData(this.listeAttribut.toArray());
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(java.awt.event.ActionEvent evt) {
/* 317 */     this.projet.getFormeMCD().getPage().setListeAttribut(this.listeAttribut);
/* 318 */     this.projet.getFormeMCD().setModifier(true);
/* 319 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeImporterDictionnaire.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */