/*     */ package formes;
/*     */ 
/*     */ import Merise.Attribut;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ 
/*     */ public class FormeSelectAttribut extends javax.swing.JDialog
/*     */ {
/*     */   private ihm.Principale frm;
/*     */   private ArrayList<Attribut> liste;
/*     */   private String fermer;
/*     */   private Attribut attributSel;
/*     */   private javax.swing.JButton jButton1;
/*     */   private javax.swing.JButton jButton2;
/*     */   private javax.swing.JButton jButton3;
/*     */   private javax.swing.JComboBox jCBTri;
/*     */   private javax.swing.JLabel jLabSel;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JScrollPane jScrollPane2;
/*     */   private javax.swing.JTable jTable1;
/*     */   private javax.swing.JTextField jTextField1;
/*     */   
/*     */   public FormeSelectAttribut(ihm.Principale frm, boolean modal)
/*     */   {
/*  31 */     super(frm, modal);
/*  32 */     initComponents();
/*  33 */     this.frm = frm;
/*  34 */     this.attributSel = null;
/*  35 */     this.fermer = "Annuler";
/*  36 */     setLocation(300, 100);
/*  37 */     this.liste = new ArrayList();
/*  38 */     this.liste = copierListeDansCible(frm.getPage().getListeAttribut(), this.liste);
/*     */     
/*  40 */     afficherListeAttribut(this.liste);
/*  41 */     this.jButton1.setMnemonic(10);
/*  42 */     this.jButton2.setMnemonic(65);
/*     */   }
/*     */   
/*     */   private ArrayList<Attribut> chercherListe(String nom, String type) {
/*  46 */     ArrayList<Attribut> listeAtt = new ArrayList();
/*  47 */     if ((nom.trim().length() == 0) || (type.trim().length() == 0)) return this.frm.getPage().getListeAttribut();
/*  48 */     for (int i = 0; i < this.frm.getPage().getListeAttribut().size(); i++) {
/*  49 */       if ((((Attribut)this.frm.getPage().getListeAttribut().get(i)).getNom().indexOf(nom) >= 0) || (((Attribut)this.frm.getPage().getListeAttribut().get(i)).getType().indexOf(type) >= 0))
/*     */       {
/*  51 */         listeAtt.add(this.frm.getPage().getListeAttribut().get(i)); }
/*     */     }
/*  53 */     return listeAtt;
/*     */   }
/*     */   
/*     */ 
/*     */   private Attribut chercherAttribut(String nom, String type)
/*     */   {
/*  59 */     for (int i = 0; i < this.liste.size(); i++) {
/*  60 */       if ((((Attribut)this.liste.get(i)).getNom().equals(nom)) && (((Attribut)this.liste.get(i)).getType().equals(type)))
/*     */       {
/*  62 */         return (Attribut)this.liste.get(i); }
/*     */     }
/*  64 */     return null;
/*     */   }
/*     */   
/*     */   private void afficherListeAttribut(ArrayList<Attribut> li) {
/*  68 */     Object[][] ob = new Object[li.size()][2];
/*  69 */     if (li != null) {
/*  70 */       for (int i = 0; i < li.size(); i++) {
/*  71 */         ob[i][0] = ((Attribut)li.get(i)).getNom();
/*  72 */         ob[i][1] = ((Attribut)li.get(i)).getType();
/*     */       }
/*     */     }
/*  75 */     Object[] col = { "Nom", "Type" };
/*  76 */     this.jTable1.setModel(new javax.swing.table.DefaultTableModel(ob, col));
/*     */   }
/*     */   
/*     */   public String getFermer() {
/*  80 */     return this.fermer;
/*     */   }
/*     */   
/*     */   public Attribut getAttributSel() {
/*  84 */     return this.attributSel;
/*     */   }
/*     */   
/*     */   private Attribut getAttributPetit(ArrayList<Attribut> liste) {
/*  88 */     Attribut att = null;
/*  89 */     if (liste.size() == 0) return null;
/*  90 */     att = (Attribut)liste.get(0);
/*  91 */     for (int i = 1; i < liste.size(); i++) {
/*  92 */       if (((Attribut)liste.get(i)).getNom().compareToIgnoreCase(att.getNom()) < 0) {
/*  93 */         att = (Attribut)liste.get(i);
/*     */       }
/*     */     }
/*  96 */     return att;
/*     */   }
/*     */   
/*     */   private ArrayList<Attribut> getListeTrieeParNom(ArrayList<Attribut> liste) {
/* 100 */     ArrayList<Attribut> li = new ArrayList();
/*     */     
/* 102 */     while (liste.size() > 0) {
/* 103 */       Attribut att = getAttributPetit(liste);
/* 104 */       if (att == null) break;
/* 105 */       li.add(att);
/* 106 */       liste.remove(att);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 111 */     return li;
/*     */   }
/*     */   
/*     */   private ArrayList<Attribut> getListeAvecType(ArrayList<Attribut> liste, String type) {
/* 115 */     ArrayList<Attribut> li = new ArrayList();
/* 116 */     for (int i = 0; i < liste.size(); i++) {
/* 117 */       if (((Attribut)liste.get(i)).getType().equals(type)) {
/* 118 */         li.add(liste.get(i));
/*     */       }
/*     */     }
/* 121 */     return li;
/*     */   }
/*     */   
/*     */   private ArrayList<Attribut> copierListeDansCible(ArrayList<Attribut> src, ArrayList<Attribut> cible) {
/* 125 */     for (int i = 0; i < src.size(); i++) {
/* 126 */       cible.add(src.get(i));
/*     */     }
/* 128 */     return cible;
/*     */   }
/*     */   
/*     */   private boolean existeType(ArrayList<String> list, String type) {
/* 132 */     for (int i = 0; i < list.size(); i++) {
/* 133 */       if (((String)list.get(i)).toString().equals(type)) return true;
/*     */     }
/* 135 */     return false;
/*     */   }
/*     */   
/*     */   private ArrayList<String> getListeType(ArrayList<Attribut> liste) {
/* 139 */     ArrayList<String> li = new ArrayList();
/* 140 */     for (int i = 0; i < liste.size(); i++) {
/* 141 */       if (!existeType(li, ((Attribut)liste.get(i)).getType())) {
/* 142 */         li.add(((Attribut)liste.get(i)).getType());
/*     */       }
/*     */     }
/* 145 */     return li;
/*     */   }
/*     */   
/*     */   private ArrayList<Attribut> getListeTrieeParType(ArrayList<Attribut> liste) {
/* 149 */     ArrayList<Attribut> lTrier = new ArrayList();
/* 150 */     ArrayList<Attribut> li = new ArrayList();
/* 151 */     ArrayList<String> lType = getListeType(liste);
/*     */     
/* 153 */     for (int i = 0; i < lType.size(); i++) {
/* 154 */       li = getListeAvecType(liste, (String)lType.get(i));
/* 155 */       li = getListeTrieeParNom(li);
/* 156 */       lTrier = copierListeDansCible(li, lTrier);
/*     */     }
/* 158 */     System.gc();
/*     */     
/* 160 */     return lTrier;
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
/*     */   private void initComponents()
/*     */   {
/* 174 */     this.jPanel1 = new javax.swing.JPanel();
/* 175 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/* 176 */     this.jTable1 = new javax.swing.JTable();
/* 177 */     this.jLabel2 = new javax.swing.JLabel();
/* 178 */     this.jLabSel = new javax.swing.JLabel();
/* 179 */     this.jLabel1 = new javax.swing.JLabel();
/* 180 */     this.jTextField1 = new javax.swing.JTextField();
/* 181 */     this.jButton1 = new javax.swing.JButton();
/* 182 */     this.jButton2 = new javax.swing.JButton();
/* 183 */     this.jCBTri = new javax.swing.JComboBox();
/* 184 */     this.jLabel3 = new javax.swing.JLabel();
/* 185 */     this.jButton3 = new javax.swing.JButton();
/*     */     
/* 187 */     setDefaultCloseOperation(2);
/* 188 */     setTitle("Selection attribut");
/* 189 */     setResizable(false);
/*     */     
/* 191 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 193 */     this.jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[0][], new String[] { "Nom", "Type" })
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 201 */       Class[] types = { String.class, String.class };
/*     */       
/*     */ 
/* 204 */       boolean[] canEdit = { false, false };
/*     */       
/*     */ 
/*     */       public Class getColumnClass(int columnIndex)
/*     */       {
/* 209 */         return this.types[columnIndex];
/*     */       }
/*     */       
/*     */       public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 213 */         return this.canEdit[columnIndex];
/*     */       }
/* 215 */     });
/* 216 */     this.jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 218 */         FormeSelectAttribut.this.jTable1MouseClicked(evt);
/*     */       }
/* 220 */     });
/* 221 */     this.jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyPressed(java.awt.event.KeyEvent evt) {
/* 223 */         FormeSelectAttribut.this.jTable1KeyPressed(evt);
/*     */       }
/*     */       
/* 226 */       public void keyReleased(java.awt.event.KeyEvent evt) { FormeSelectAttribut.this.jTable1KeyReleased(evt);
/*     */       }
/* 228 */     });
/* 229 */     this.jScrollPane2.setViewportView(this.jTable1);
/*     */     
/* 231 */     this.jLabel2.setForeground(new java.awt.Color(255, 0, 0));
/* 232 */     this.jLabel2.setText(">>");
/*     */     
/* 234 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 235 */     this.jPanel1.setLayout(jPanel1Layout);
/* 236 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane2, GroupLayout.Alignment.LEADING, -1, 293, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel2).addGap(18, 18, 18).addComponent(this.jLabSel, -1, 259, 32767))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 248 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 334, 32767).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jLabSel)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 260 */     this.jLabel1.setText("Rechercher");
/*     */     
/* 262 */     this.jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyPressed(java.awt.event.KeyEvent evt) {
/* 264 */         FormeSelectAttribut.this.jTextField1KeyPressed(evt);
/*     */       }
/*     */       
/* 267 */     });
/* 268 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 269 */     this.jButton1.setText("OK");
/* 270 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 272 */         FormeSelectAttribut.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/* 275 */     });
/* 276 */     this.jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 277 */     this.jButton2.setText("Annuler");
/* 278 */     this.jButton2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 280 */         FormeSelectAttribut.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/* 283 */     });
/* 284 */     this.jCBTri.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Nom", "Type" }));
/* 285 */     this.jCBTri.addItemListener(new java.awt.event.ItemListener() {
/*     */       public void itemStateChanged(java.awt.event.ItemEvent evt) {
/* 287 */         FormeSelectAttribut.this.jCBTriItemStateChanged(evt);
/*     */       }
/*     */       
/* 290 */     });
/* 291 */     this.jLabel3.setText("Trier");
/*     */     
/* 293 */     this.jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rafraichir.png")));
/* 294 */     this.jButton3.setToolTipText("rafraichir le dico de données");
/*     */     
/* 296 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 297 */     getContentPane().setLayout(layout);
/* 298 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jButton3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, 32767).addComponent(this.jButton2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -2, 77, -2)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel3)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBTri, 0, 250, 32767).addComponent(this.jTextField1, -1, 250, 32767)))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 320 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTextField1, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBTri, -2, -1, -2).addComponent(this.jLabel3)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2).addComponent(this.jButton3)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 341 */     pack();
/*     */   }
/*     */   
/*     */   private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
/* 345 */     if (this.jTable1.getSelectedRow() != -1) {
/* 346 */       this.attributSel = chercherAttribut((String)this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0), (String)this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1));
/* 347 */       this.jLabSel.setText(this.attributSel.getNom() + "  :  " + this.attributSel.getType());
/*     */     }
/*     */   }
/*     */   
/*     */   private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {
/* 352 */     if (this.jTable1.getSelectedRow() != -1) {
/* 353 */       this.attributSel = chercherAttribut((String)this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0), (String)this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1));
/* 354 */       this.jLabSel.setText(this.attributSel.getNom() + "  :  " + this.attributSel.getType());
/*     */     }
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
/* 359 */     dispose();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
/* 363 */     this.fermer = "OK";
/* 364 */     dispose();
/*     */   }
/*     */   
/*     */   private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {
/* 368 */     if (evt.getKeyCode() == 10) {
/* 369 */       afficherListeAttribut(chercherListe(this.jTextField1.getText(), this.jTextField1.getText()));
/* 370 */       this.attributSel = null;
/* 371 */       this.jLabSel.setText(this.attributSel.getNom() + "  :  " + this.attributSel.getType());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {}
/*     */   
/*     */   private void jCBTriItemStateChanged(java.awt.event.ItemEvent evt)
/*     */   {
/* 380 */     if (this.jCBTri.getSelectedItem().toString().equals("Nom")) {
/* 381 */       this.liste = getListeTrieeParNom(this.liste);
/* 382 */       afficherListeAttribut(this.liste);
/*     */     }
/* 384 */     else if (this.jCBTri.getSelectedItem().toString().equals("Type")) {
/* 385 */       this.liste = getListeTrieeParType(this.liste);
/* 386 */       afficherListeAttribut(this.liste);
/*     */     } else {
/* 388 */       this.liste.clear();
/* 389 */       this.liste = copierListeDansCible(this.frm.getPage().getListeAttribut(), this.liste);
/* 390 */       afficherListeAttribut(this.liste);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeSelectAttribut.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */