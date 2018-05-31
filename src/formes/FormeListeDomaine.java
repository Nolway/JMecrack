/*     */ package formes;
/*     */ 
/*     */ import Merise.Domaine;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JList;
/*     */ 
/*     */ public class FormeListeDomaine extends javax.swing.JDialog
/*     */ {
/*     */   private ArrayList<Domaine> listeDomaine;
/*     */   private Domaine domaineSel;
/*     */   private ihm.Principale frm;
/*     */   private JButton jBtCreer;
/*     */   private JButton jBtSupprimer;
/*     */   private JButton jBtValider;
/*     */   private JButton jBtVisualiser;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private JList jListDomaine;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   
/*     */   public FormeListeDomaine(ihm.Principale frm, boolean modal, ArrayList<Domaine> listeDomaine)
/*     */   {
/*  30 */     super(frm, modal);
/*  31 */     initComponents();
/*  32 */     this.frm = frm;
/*  33 */     setLocation(frm.getX() + 250, frm.getY() + 100);
/*  34 */     this.listeDomaine = listeDomaine;
/*  35 */     this.domaineSel = null;
/*     */     
/*  37 */     this.jListDomaine.setListData(listeDomaine.toArray());
/*  38 */     this.jBtCreer.setMnemonic(67);
/*  39 */     this.jBtSupprimer.setMnemonic(83);
/*  40 */     this.jBtValider.setMnemonic(10);
/*  41 */     this.jBtVisualiser.setMnemonic(86);
/*     */   }
/*     */   
/*     */   public void afficherDomaine() {
/*  45 */     this.jListDomaine.setListData(this.listeDomaine.toArray());
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
/*  57 */     this.jPanel1 = new javax.swing.JPanel();
/*  58 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  59 */     this.jListDomaine = new JList();
/*  60 */     this.jBtVisualiser = new JButton();
/*  61 */     this.jBtCreer = new JButton();
/*  62 */     this.jBtSupprimer = new JButton();
/*  63 */     this.jLabel1 = new javax.swing.JLabel();
/*  64 */     this.jBtValider = new JButton();
/*     */     
/*  66 */     setDefaultCloseOperation(2);
/*  67 */     setTitle("Liste des domaines");
/*  68 */     setResizable(false);
/*     */     
/*  70 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/*  72 */     this.jListDomaine.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mousePressed(MouseEvent evt) {
/*  74 */         FormeListeDomaine.this.jListDomaineMousePressed(evt);
/*     */       }
/*     */       
/*  77 */       public void mouseReleased(MouseEvent evt) { FormeListeDomaine.this.jListDomaineMouseReleased(evt);
/*     */       }
/*  79 */     });
/*  80 */     this.jListDomaine.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyReleased(java.awt.event.KeyEvent evt) {
/*  82 */         FormeListeDomaine.this.jListDomaineKeyReleased(evt);
/*     */       }
/*  84 */     });
/*  85 */     this.jScrollPane1.setViewportView(this.jListDomaine);
/*     */     
/*  87 */     this.jBtVisualiser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/importer.png")));
/*  88 */     this.jBtVisualiser.setText("Visualiser");
/*  89 */     this.jBtVisualiser.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  91 */         FormeListeDomaine.this.jBtVisualiserActionPerformed(evt);
/*     */       }
/*     */       
/*  94 */     });
/*  95 */     this.jBtCreer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ajouter.png")));
/*  96 */     this.jBtCreer.setText("Créer");
/*  97 */     this.jBtCreer.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  99 */         FormeListeDomaine.this.jBtCreerActionPerformed(evt);
/*     */       }
/*     */       
/* 102 */     });
/* 103 */     this.jBtSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/supprimer.png")));
/* 104 */     this.jBtSupprimer.setText("Supprimer");
/* 105 */     this.jBtSupprimer.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 107 */         FormeListeDomaine.this.jBtSupprimerActionPerformed(evt);
/*     */       }
/*     */       
/* 110 */     });
/* 111 */     this.jLabel1.setText("Liste de domaine :");
/*     */     
/* 113 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 114 */     this.jPanel1.setLayout(jPanel1Layout);
/* 115 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 491, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jBtSupprimer).addGap(100, 100, 100).addComponent(this.jBtCreer, -2, 89, -2).addGap(9, 9, 9)).addComponent(this.jLabel1)).addGap(95, 95, 95).addComponent(this.jBtVisualiser))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 133 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 329, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtSupprimer).addComponent(this.jBtVisualiser).addComponent(this.jBtCreer)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 148 */     this.jBtValider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 149 */     this.jBtValider.setText("Valider");
/* 150 */     this.jBtValider.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 152 */         FormeListeDomaine.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 155 */     });
/* 156 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 157 */     getContentPane().setLayout(layout);
/* 158 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jBtValider, GroupLayout.Alignment.TRAILING)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 167 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtValider).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 177 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtVisualiserActionPerformed(ActionEvent evt) {
/* 181 */     int indx = this.jListDomaine.getSelectedIndex();
/* 182 */     if (indx >= 0) {
/* 183 */       new FormeDomaine(this.frm, true, (Domaine)this.listeDomaine.get(this.jListDomaine.getSelectedIndex())).setVisible(true);
/* 184 */       afficherDomaine();
/* 185 */       this.jListDomaine.setSelectedIndex(indx);
/* 186 */     } else { javax.swing.JOptionPane.showMessageDialog(this, "INFO : Aucun domaine n'est sélectionné !! ");
/*     */     }
/*     */   }
/*     */   
/*     */   private void jListDomaineMousePressed(MouseEvent evt) {}
/*     */   
/*     */   private void jListDomaineMouseReleased(MouseEvent evt)
/*     */   {
/* 194 */     int indx = this.jListDomaine.getSelectedIndex();
/* 195 */     if (evt.getClickCount() == 2) {
/* 196 */       if (indx >= 0)
/* 197 */         new FormeDomaine(this.frm, true, (Domaine)this.listeDomaine.get(this.jListDomaine.getSelectedIndex())).setVisible(true);
/* 198 */       afficherDomaine();
/* 199 */       this.jListDomaine.setSelectedIndex(indx);
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(ActionEvent evt) {
/* 204 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtCreerActionPerformed(ActionEvent evt) {
/* 208 */     new FormeDomaine(this.frm, true, null).setVisible(true);
/* 209 */     afficherDomaine();
/*     */   }
/*     */   
/*     */   private void jBtSupprimerActionPerformed(ActionEvent evt)
/*     */   {
/* 214 */     int[] att = this.jListDomaine.getSelectedIndices();
/* 215 */     for (int i = att.length - 1; i >= 0; i--) {
/* 216 */       this.listeDomaine.remove(att[i]);
/*     */     }
/* 218 */     this.jListDomaine.setListData(this.listeDomaine.toArray());
/*     */   }
/*     */   
/*     */   private void jListDomaineKeyReleased(java.awt.event.KeyEvent evt) {
/* 222 */     int indx = this.jListDomaine.getSelectedIndex();
/* 223 */     if (evt.getKeyCode() == 10) {
/* 224 */       if (indx >= 0)
/* 225 */         new FormeDomaine(this.frm, true, (Domaine)this.listeDomaine.get(this.jListDomaine.getSelectedIndex())).setVisible(true);
/* 226 */       afficherDomaine();
/* 227 */       this.jListDomaine.setSelectedIndex(indx);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeListeDomaine.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */