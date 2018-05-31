/*     */ package formes;
/*     */ 
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JLabel;
/*     */ 
/*     */ public class FormeCommentaireIndep extends javax.swing.JDialog
/*     */ {
/*     */   IhmMCD.IhmCommentaireIndip commentaire;
/*     */   private javax.swing.JButton jButton1;
/*     */   private javax.swing.JButton jButton2;
/*     */   private javax.swing.JCheckBox jCBDegradee;
/*     */   private javax.swing.JCheckBox jCBOmbre;
/*     */   private JLabel jLabCadre;
/*     */   private JLabel jLabFond;
/*     */   private JLabel jLabTexte;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private javax.swing.JPanel jPanel2;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private javax.swing.JTextArea jTACommentaire;
/*     */   
/*     */   public FormeCommentaireIndep(java.awt.Frame parent, boolean modal, IhmMCD.IhmCommentaireIndip commentaire, int x, int y)
/*     */   {
/*  27 */     super(parent, modal);
/*  28 */     initComponents();
/*  29 */     setLocation(500, 200);
/*  30 */     this.commentaire = commentaire;
/*  31 */     this.jTACommentaire.setText(commentaire.getCommentaire());
/*  32 */     initialiser();
/*  33 */     this.jButton1.setMnemonic(10);
/*  34 */     this.jButton2.setMnemonic(65);
/*     */   }
/*     */   
/*     */   private String getColeurString(java.awt.Color cl) {
/*  38 */     return cl.getRGB() + "";
/*     */   }
/*     */   
/*     */   private java.awt.Color getCouleurs(String cl) {
/*  42 */     return new java.awt.Color(Integer.parseInt(cl));
/*     */   }
/*     */   
/*     */   private void initialiser() {
/*  46 */     this.jLabFond.setBackground(this.commentaire.getClFond());
/*  47 */     this.jLabCadre.setBackground(this.commentaire.getClCadre());
/*  48 */     this.jLabTexte.setBackground(this.commentaire.getClTexte());
/*  49 */     this.jCBOmbre.setSelected(this.commentaire.isOmbre());
/*  50 */     this.jCBDegradee.setSelected(this.commentaire.isClDegradee());
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
/*  63 */     this.jButton1 = new javax.swing.JButton();
/*  64 */     this.jButton2 = new javax.swing.JButton();
/*  65 */     this.jPanel1 = new javax.swing.JPanel();
/*  66 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  67 */     this.jTACommentaire = new javax.swing.JTextArea();
/*  68 */     this.jLabel1 = new JLabel();
/*  69 */     this.jPanel2 = new javax.swing.JPanel();
/*  70 */     this.jLabel2 = new JLabel();
/*  71 */     this.jLabel3 = new JLabel();
/*  72 */     this.jLabel4 = new JLabel();
/*  73 */     this.jCBOmbre = new javax.swing.JCheckBox();
/*  74 */     this.jCBDegradee = new javax.swing.JCheckBox();
/*  75 */     this.jLabCadre = new JLabel();
/*  76 */     this.jLabFond = new JLabel();
/*  77 */     this.jLabTexte = new JLabel();
/*     */     
/*  79 */     setDefaultCloseOperation(2);
/*  80 */     setTitle("Saisie de commentaire");
/*  81 */     setResizable(false);
/*     */     
/*  83 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/*  84 */     this.jButton1.setText("Ok");
/*  85 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  87 */         FormeCommentaireIndep.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  90 */     });
/*  91 */     this.jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/*  92 */     this.jButton2.setText("Annuler");
/*  93 */     this.jButton2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/*  95 */         FormeCommentaireIndep.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/*  98 */     });
/*  99 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 101 */     this.jTACommentaire.setColumns(20);
/* 102 */     this.jTACommentaire.setRows(5);
/* 103 */     this.jScrollPane1.setViewportView(this.jTACommentaire);
/*     */     
/* 105 */     this.jLabel1.setText("Commentaire :");
/*     */     
/* 107 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 108 */     this.jPanel1.setLayout(jPanel1Layout);
/* 109 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 449, 32767).addComponent(this.jLabel1, -2, 101, -2)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 118 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 137, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 128 */     this.jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
/*     */     
/* 130 */     this.jLabel2.setForeground(new java.awt.Color(0, 51, 204));
/* 131 */     this.jLabel2.setText("Cadre");
/* 132 */     this.jLabel2.setCursor(new java.awt.Cursor(12));
/* 133 */     this.jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 135 */         FormeCommentaireIndep.this.jLabel2MouseClicked(evt);
/*     */       }
/*     */       
/* 138 */     });
/* 139 */     this.jLabel3.setForeground(new java.awt.Color(0, 51, 204));
/* 140 */     this.jLabel3.setText("Fond");
/* 141 */     this.jLabel3.setCursor(new java.awt.Cursor(12));
/* 142 */     this.jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 144 */         FormeCommentaireIndep.this.jLabel3MouseClicked(evt);
/*     */       }
/*     */       
/* 147 */     });
/* 148 */     this.jLabel4.setForeground(new java.awt.Color(0, 51, 204));
/* 149 */     this.jLabel4.setText("Texte");
/* 150 */     this.jLabel4.setCursor(new java.awt.Cursor(12));
/* 151 */     this.jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 153 */         FormeCommentaireIndep.this.jLabel4MouseClicked(evt);
/*     */       }
/*     */       
/* 156 */     });
/* 157 */     this.jCBOmbre.setText("Ombre");
/*     */     
/* 159 */     this.jCBDegradee.setText("Couleur Degradée");
/*     */     
/* 161 */     this.jLabCadre.setBackground(new java.awt.Color(255, 255, 255));
/* 162 */     this.jLabCadre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
/* 163 */     this.jLabCadre.setCursor(new java.awt.Cursor(12));
/* 164 */     this.jLabCadre.setOpaque(true);
/* 165 */     this.jLabCadre.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 167 */         FormeCommentaireIndep.this.jLabCadreMouseClicked(evt);
/*     */       }
/*     */       
/* 170 */     });
/* 171 */     this.jLabFond.setBackground(new java.awt.Color(102, 102, 102));
/* 172 */     this.jLabFond.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
/* 173 */     this.jLabFond.setCursor(new java.awt.Cursor(12));
/* 174 */     this.jLabFond.setOpaque(true);
/* 175 */     this.jLabFond.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 177 */         FormeCommentaireIndep.this.jLabFondMouseClicked(evt);
/*     */       }
/*     */       
/* 180 */     });
/* 181 */     this.jLabTexte.setBackground(new java.awt.Color(0, 0, 0));
/* 182 */     this.jLabTexte.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
/* 183 */     this.jLabTexte.setCursor(new java.awt.Cursor(12));
/* 184 */     this.jLabTexte.setOpaque(true);
/* 185 */     this.jLabTexte.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/* 187 */         FormeCommentaireIndep.this.jLabTexteMouseClicked(evt);
/*     */       }
/*     */       
/* 190 */     });
/* 191 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 192 */     this.jPanel2.setLayout(jPanel2Layout);
/* 193 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel3).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel4).addComponent(this.jLabel2, -2, 51, -2)).addGap(10, 10, 10).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(this.jLabCadre, -1, 59, 32767).addComponent(this.jLabFond, -1, -1, 32767).addComponent(this.jLabTexte, -1, -1, 32767)))).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, 32767).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jCBDegradee).addComponent(this.jCBOmbre, -2, 94, -2)).addGap(44, 44, 44)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 214 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jLabel2).addComponent(this.jLabCadre, -2, 15, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jLabFond, -2, 15, -2).addComponent(this.jCBOmbre)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jLabTexte, -2, 15, -2).addComponent(this.jCBDegradee)).addContainerGap(11, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 234 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 235 */     getContentPane().setLayout(layout);
/* 236 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel2, javax.swing.GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jButton2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1, -2, 77, -2))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 249 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 263 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
/* 267 */     this.commentaire.setCommentaire(this.jTACommentaire.getText());
/* 268 */     this.commentaire.setOmbre(this.jCBOmbre.isSelected());
/* 269 */     this.commentaire.setClDegradee(this.jCBDegradee.isSelected());
/*     */     
/* 271 */     this.commentaire.setClFond(this.jLabFond.getBackground());
/* 272 */     this.commentaire.setClCadre(this.jLabCadre.getBackground());
/* 273 */     this.commentaire.setClTexte(this.jLabTexte.getBackground());
/*     */     
/* 275 */     this.commentaire.setClFondSt(getColeurString(this.jLabFond.getBackground()));
/* 276 */     this.commentaire.setClCadreSt(getColeurString(this.jLabCadre.getBackground()));
/* 277 */     this.commentaire.setClTexteSt(getColeurString(this.jLabTexte.getBackground()));
/* 278 */     dispose();
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
/* 282 */     dispose();
/*     */   }
/*     */   
/*     */   private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {
/* 286 */     this.jLabCadre.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabCadre.getBackground()));
/*     */   }
/*     */   
/*     */   private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {
/* 290 */     this.jLabFond.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabFond.getBackground()));
/*     */   }
/*     */   
/*     */   private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {
/* 294 */     this.jLabTexte.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabTexte.getBackground()));
/*     */   }
/*     */   
/*     */   private void jLabCadreMouseClicked(java.awt.event.MouseEvent evt) {
/* 298 */     this.jLabCadre.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabCadre.getBackground()));
/*     */   }
/*     */   
/*     */   private void jLabFondMouseClicked(java.awt.event.MouseEvent evt) {
/* 302 */     this.jLabFond.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabFond.getBackground()));
/*     */   }
/*     */   
/*     */   private void jLabTexteMouseClicked(java.awt.event.MouseEvent evt) {
/* 306 */     this.jLabTexte.setBackground(javax.swing.JColorChooser.showDialog(getParent(), "choix de couleur", this.jLabTexte.getBackground()));
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeCommentaireIndep.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */