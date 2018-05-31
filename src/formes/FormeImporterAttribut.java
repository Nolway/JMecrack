/*     */ package formes;
/*     */ 
/*     */ import Merise.Attribut;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ 
/*     */ public class FormeImporterAttribut extends javax.swing.JDialog
/*     */ {
/*     */   private ihm.Principale frm;
/*     */   private ArrayList<Attribut> listeAttribut;
/*     */   private ArrayList<Attribut> listeAttMCD;
/*     */   private Merise.EntiteRelation ent;
/*     */   private IhmMCD.IhmPageMCD page;
/*     */   private boolean modifier;
/*     */   private JButton jBtAjouter;
/*     */   private JButton jBtAnnuler;
/*     */   private JButton jBtSupprimer;
/*     */   private JButton jBtValider;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JList jListAttribut;
/*     */   private javax.swing.JList jListAttributNew;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JPanel jPanel3;
/*     */   private javax.swing.JScrollPane jScrollPane2;
/*     */   private javax.swing.JScrollPane jScrollPane3;
/*     */   
/*     */   public FormeImporterAttribut(ihm.Principale parent, ArrayList<Attribut> list, boolean modal)
/*     */   {
/*  35 */     super(parent, modal);
/*  36 */     this.frm = parent;
/*  37 */     initComponents();
/*  38 */     this.page = this.frm.getPage();
/*  39 */     this.modifier = false;
/*  40 */     this.listeAttribut = new ArrayList();
/*  41 */     this.listeAttMCD = new ArrayList();
/*  42 */     copierListAttributDico(list, this.listeAttribut);
/*  43 */     copierListAttributDico(this.page.getListeAttribut(), this.listeAttMCD);
/*  44 */     this.jListAttribut.setListData(this.listeAttMCD.toArray());
/*  45 */     this.jListAttributNew.setListData(this.listeAttribut.toArray());
/*  46 */     setLocation(300, 100);
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> getListAttribut() {
/*  50 */     return this.listeAttribut;
/*     */   }
/*     */   
/*     */   public boolean isModifier() {
/*  54 */     return this.modifier;
/*     */   }
/*     */   
/*     */   private void copierListAttributDico(ArrayList<Attribut> src, ArrayList<Attribut> cible) {
/*  58 */     for (int i = 0; i < src.size(); i++) {
/*  59 */       cible.add(((Attribut)src.get(i)).copier());
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean existeAttribut(Attribut att) {
/*  64 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/*  65 */       if ((att.getNom().equals(((Attribut)this.listeAttribut.get(i)).getNom())) && (att.getType().equals(((Attribut)this.listeAttribut.get(i)).getType())))
/*  66 */         return true;
/*     */     }
/*  68 */     return false;
/*     */   }
/*     */   
/*     */   private void ajouterAttribut(Attribut att) {
/*  72 */     if (!existeAttribut(att)) this.listeAttribut.add(((Merise2.Attribut2)att).copier());
/*     */   }
/*     */   
/*     */   private void supprimerAttribut()
/*     */   {
/*  77 */     int[] att = this.jListAttributNew.getSelectedIndices();
/*  78 */     for (int i = att.length - 1; i >= 0; i--) {
/*  79 */       this.listeAttribut.remove(att[i]);
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
/*  92 */     this.jPanel1 = new javax.swing.JPanel();
/*  93 */     this.jLabel2 = new javax.swing.JLabel();
/*  94 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/*  95 */     this.jListAttribut = new javax.swing.JList();
/*  96 */     this.jPanel3 = new javax.swing.JPanel();
/*  97 */     this.jScrollPane3 = new javax.swing.JScrollPane();
/*  98 */     this.jListAttributNew = new javax.swing.JList();
/*  99 */     this.jLabel3 = new javax.swing.JLabel();
/* 100 */     this.jBtSupprimer = new JButton();
/* 101 */     this.jPanel2 = new javax.swing.JPanel();
/* 102 */     this.jBtValider = new JButton();
/* 103 */     this.jBtAnnuler = new JButton();
/* 104 */     this.jBtAjouter = new JButton();
/*     */     
/* 106 */     setDefaultCloseOperation(2);
/* 107 */     setTitle("Attribut de l'entité");
/* 108 */     setResizable(false);
/*     */     
/* 110 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 112 */     this.jLabel2.setText("Dictionnaire de données");
/*     */     
/* 114 */     this.jScrollPane2.setViewportView(this.jListAttribut);
/*     */     
/* 116 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 117 */     this.jPanel1.setLayout(jPanel1Layout);
/* 118 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, GroupLayout.Alignment.TRAILING, -1, 279, 32767).addComponent(this.jLabel2)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 127 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 366, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 137 */     this.jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 139 */     this.jListAttributNew.setBackground(new java.awt.Color(212, 228, 226));
/* 140 */     this.jScrollPane3.setViewportView(this.jListAttributNew);
/*     */     
/* 142 */     this.jLabel3.setText("La liste des attributs du MCD");
/*     */     
/* 144 */     this.jBtSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/supprimer.png")));
/* 145 */     this.jBtSupprimer.setText("Supprimer ");
/* 146 */     this.jBtSupprimer.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 148 */         FormeImporterAttribut.this.jBtSupprimerActionPerformed(evt);
/*     */       }
/*     */       
/* 151 */     });
/* 152 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 153 */     this.jPanel3.setLayout(jPanel3Layout);
/* 154 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane3, -1, 282, 32767).addComponent(this.jLabel3).addComponent(this.jBtSupprimer, GroupLayout.Alignment.TRAILING, -2, 126, -2)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 164 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(11, 11, 11).addComponent(this.jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -1, 330, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBtSupprimer).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 176 */     this.jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
/*     */     
/* 178 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 179 */     this.jBtValider.setText("Valider ");
/* 180 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 182 */         FormeImporterAttribut.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 185 */     });
/* 186 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 187 */     this.jBtAnnuler.setText("Annuler ");
/* 188 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 190 */         FormeImporterAttribut.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 193 */     });
/* 194 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 195 */     this.jPanel2.setLayout(jPanel2Layout);
/* 196 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(451, 32767).addComponent(this.jBtAnnuler, -2, 107, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtValider, -2, 98, -2).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 205 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 215 */     this.jBtAjouter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flecheAdroite.PNG")));
/* 216 */     this.jBtAjouter.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 218 */         FormeImporterAttribut.this.jBtAjouterActionPerformed(evt);
/*     */       }
/*     */       
/* 221 */     });
/* 222 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 223 */     getContentPane().setLayout(layout);
/* 224 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtAjouter, -2, 57, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel3, -1, -1, 32767)).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 238 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel3, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767))).addGroup(layout.createSequentialGroup().addGap(195, 195, 195).addComponent(this.jBtAjouter))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 255 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtSupprimerActionPerformed(java.awt.event.ActionEvent evt) {
/* 259 */     supprimerAttribut();
/* 260 */     this.jListAttributNew.setListData(this.listeAttribut.toArray());
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(java.awt.event.ActionEvent evt) {
/* 264 */     this.modifier = true;
/* 265 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(java.awt.event.ActionEvent evt) {
/* 269 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtAjouterActionPerformed(java.awt.event.ActionEvent evt) {
/* 273 */     int[] ind = this.jListAttribut.getSelectedIndices();
/* 274 */     for (int i = 0; i < ind.length; i++) {
/* 275 */       ((Merise2.Attribut2)this.jListAttribut.getSelectedValues()[i]).setAfficher(true);
/* 276 */       ajouterAttribut((Attribut)this.jListAttribut.getSelectedValues()[i]);
/*     */     }
/* 278 */     this.jListAttributNew.setListData(this.listeAttribut.toArray());
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeImporterAttribut.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */