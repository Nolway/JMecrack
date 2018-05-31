/*     */ package formes;
/*     */ 
/*     */ import composantSQL.Table;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ 
/*     */ public class FormeSelectTable extends javax.swing.JDialog
/*     */ {
/*     */   private ArrayList<Table> listeTableSel;
/*     */   private ArrayList<Table> listeTableDispo;
/*     */   private boolean valider;
/*     */   ihm.Principale frm;
/*     */   private JButton jBtAnnuler;
/*     */   private JButton jBtValider;
/*     */   private JButton jButton2;
/*     */   private JButton jButton3;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JList jListDipo;
/*     */   private javax.swing.JList jListSel;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JScrollPane jScrollPane2;
/*     */   
/*     */   public FormeSelectTable(ihm.Principale parent, boolean modal, composantSQL.MyDataBase db, ArrayList<Table> listeSel)
/*     */   {
/*  30 */     super(parent, modal);
/*  31 */     initComponents();
/*  32 */     this.frm = parent;
/*  33 */     setLocation(this.frm.getX() + 250, this.frm.getY() + 100);
/*  34 */     this.listeTableSel = new ArrayList();
/*  35 */     this.listeTableDispo = new ArrayList();
/*  36 */     copierListeTableSel(listeSel);
/*  37 */     copierListeTableDipo(db);
/*  38 */     remplirListe();
/*  39 */     this.valider = false;
/*     */   }
/*     */   
/*     */   public boolean isValider()
/*     */   {
/*  44 */     return this.valider;
/*     */   }
/*     */   
/*     */   public ArrayList<Table> getListeTableSel() {
/*  48 */     return this.listeTableSel;
/*     */   }
/*     */   
/*     */   private void copierListeTableSel(ArrayList<Table> liste) {
/*  52 */     for (int i = 0; i < liste.size(); i++) {
/*  53 */       this.listeTableSel.add(((Table)liste.get(i)).copier());
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean existeTableSel(String nom) {
/*  58 */     for (int i = 0; i < this.listeTableSel.size(); i++) {
/*  59 */       if (((Table)this.listeTableSel.get(i)).getName().trim().toUpperCase().equals(nom.trim().toUpperCase())) return true;
/*     */     }
/*  61 */     return false;
/*     */   }
/*     */   
/*     */   private void copierListeTableDipo(composantSQL.MyDataBase db) {
/*  65 */     for (int i = 0; i < db.getTableList().size(); i++) {
/*  66 */       if (!existeTableSel(((Table)db.getTableList().get(i)).getName())) {
/*  67 */         this.listeTableDispo.add(((Table)db.getTableList().get(i)).copier());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void remplirListe() {
/*  73 */     this.jListSel.setListData(this.listeTableSel.toArray());
/*  74 */     this.jListDipo.setListData(this.listeTableDispo.toArray());
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
/*  87 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  88 */     this.jListDipo = new javax.swing.JList();
/*  89 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/*  90 */     this.jListSel = new javax.swing.JList();
/*  91 */     this.jButton2 = new JButton();
/*  92 */     this.jButton3 = new JButton();
/*  93 */     this.jLabel1 = new javax.swing.JLabel();
/*  94 */     this.jLabel2 = new javax.swing.JLabel();
/*  95 */     this.jBtValider = new JButton();
/*  96 */     this.jBtAnnuler = new JButton();
/*     */     
/*  98 */     setDefaultCloseOperation(2);
/*  99 */     setTitle("Selection des tables");
/*     */     
/* 101 */     this.jScrollPane1.setViewportView(this.jListDipo);
/*     */     
/* 103 */     this.jListSel.setBackground(new java.awt.Color(204, 204, 204));
/* 104 */     this.jScrollPane2.setViewportView(this.jListSel);
/*     */     
/* 106 */     this.jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flecheAdroite.PNG")));
/* 107 */     this.jButton2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 109 */         FormeSelectTable.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/* 112 */     });
/* 113 */     this.jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flecheAGauche.PNG")));
/* 114 */     this.jButton3.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 116 */         FormeSelectTable.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */       
/* 119 */     });
/* 120 */     this.jLabel1.setText("Tables de la bases de données.");
/*     */     
/* 122 */     this.jLabel2.setText("Table à modélisées : ");
/*     */     
/* 124 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 125 */     this.jBtValider.setText("Valider");
/* 126 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 128 */         FormeSelectTable.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 131 */     });
/* 132 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 133 */     this.jBtAnnuler.setText("Annuler");
/* 134 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 136 */         FormeSelectTable.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 139 */     });
/* 140 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 141 */     getContentPane().setLayout(layout);
/* 142 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane1, -1, 256, 32767).addGap(37, 37, 37).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(this.jButton3, -1, -1, 32767).addComponent(this.jButton2, -1, 88, 32767)).addGap(34, 34, 34)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addGap(264, 264, 264))).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, -1, 270, 32767))).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jBtAnnuler).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtValider))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 168 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(163, 163, 163).addComponent(this.jButton2).addGap(56, 56, 56).addComponent(this.jButton3)).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jLabel2)).addGap(2, 2, 2).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, -1, 439, 32767).addComponent(this.jScrollPane2, -1, 439, 32767)))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 193 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 197 */     int[] ind = this.jListDipo.getSelectedIndices();
/* 198 */     for (int i = 0; i < ind.length; i++) {
/* 199 */       this.listeTableSel.add((Table)this.jListDipo.getSelectedValues()[i]);
/*     */     }
/* 201 */     for (int i = ind.length - 1; i >= 0; i--) {
/* 202 */       this.listeTableDispo.remove(ind[i]);
/*     */     }
/* 204 */     this.jListSel.setListData(this.listeTableSel.toArray());
/* 205 */     this.jListDipo.setListData(this.listeTableDispo.toArray());
/*     */   }
/*     */   
/*     */   private void jButton3ActionPerformed(ActionEvent evt) {
/* 209 */     int[] ind = this.jListSel.getSelectedIndices();
/* 210 */     for (int i = 0; i < ind.length; i++) {
/* 211 */       this.listeTableDispo.add((Table)this.jListSel.getSelectedValues()[i]);
/*     */     }
/* 213 */     for (int i = ind.length - 1; i >= 0; i--) {
/* 214 */       this.listeTableSel.remove(ind[i]);
/*     */     }
/* 216 */     this.jListSel.setListData(this.listeTableSel.toArray());
/* 217 */     this.jListDipo.setListData(this.listeTableDispo.toArray());
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(ActionEvent evt) {
/* 221 */     this.valider = true;
/* 222 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtAnnulerActionPerformed(ActionEvent evt)
/*     */   {
/* 227 */     this.valider = false;
/* 228 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeSelectTable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */