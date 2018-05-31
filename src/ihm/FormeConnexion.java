/*     */ package ihm;
/*     */ 
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class FormeConnexion extends javax.swing.JDialog
/*     */ {
/*     */   private Principale frm;
/*     */   private javax.swing.JButton jBtChemin;
/*     */   private javax.swing.JButton jButton1;
/*     */   private javax.swing.JButton jButton2;
/*     */   private javax.swing.JLabel jLabel1;
/*     */   private javax.swing.JLabel jLabel2;
/*     */   private javax.swing.JLabel jLabel3;
/*     */   private javax.swing.JLabel jLabel4;
/*     */   private javax.swing.JLabel jLabel5;
/*     */   private javax.swing.JLabel jLabel6;
/*     */   private javax.swing.JLabel jLabel7;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private JTextField jTFBD;
/*     */   private JTextField jTFChemin;
/*     */   private javax.swing.JPasswordField jTFPassword;
/*     */   private JTextField jTFPort;
/*     */   private JTextField jTFServeur;
/*     */   private JTextField jTFTypeSql;
/*     */   private JTextField jTFUser;
/*     */   
/*     */   public FormeConnexion(Principale frm, boolean modal, String typeSQL)
/*     */   {
/*  29 */     super(frm, modal);
/*  30 */     this.frm = frm;
/*  31 */     initComponents();
/*  32 */     setLocation(frm.getX() + 300, frm.getY() + 100);
/*  33 */     this.jButton1.setMnemonic(10);
/*  34 */     this.jButton2.setMnemonic(65);
/*  35 */     initialiserChamp(typeSQL);
/*     */   }
/*     */   
/*     */   private void initialiserChamp(String type) {
/*  39 */     if (type.equals(Output.SQLOutil.SQLMYSQL)) {
/*  40 */       this.jTFTypeSql.setText(Output.SQLOutil.SQLMYSQL);
/*  41 */       this.jTFPort.setText(Output.SQLOutil.PORTMYSQL);
/*  42 */       this.jTFServeur.setText(Output.SQLOutil.SERVERMYSQL);
/*  43 */       this.jTFUser.setText(Output.SQLOutil.USERMYSQL);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  53 */     if (type.equals(Output.SQLOutil.SQLPOSTGRE)) {
/*  54 */       this.jTFTypeSql.setText(Output.SQLOutil.SQLPOSTGRE);
/*  55 */       this.jTFPort.setText(Output.SQLOutil.PORTPOSTGRE);
/*  56 */       this.jTFServeur.setText(Output.SQLOutil.SERVERPOSTGRE);
/*  57 */       this.jTFUser.setText(Output.SQLOutil.USERPOSTGRE);
/*     */     }
/*     */     
/*  60 */     if (type.equals(Output.SQLOutil.SQLFIREBIRD)) {
/*  61 */       this.jTFTypeSql.setText(Output.SQLOutil.SQLFIREBIRD);
/*  62 */       this.jTFPort.setText(Output.SQLOutil.PORTFIREBIRD);
/*  63 */       this.jTFServeur.setText(Output.SQLOutil.SERVERFIREBIRD);
/*  64 */       this.jTFUser.setText(Output.SQLOutil.USERFIREBIRD);
/*     */       
/*  66 */       this.jTFChemin.setEnabled(true);
/*  67 */       this.jBtChemin.setEnabled(true);
/*  68 */       this.jTFBD.setEnabled(false);
/*     */     }
/*     */     
/*  71 */     if (type.equals(Output.SQLOutil.SQLDERBY)) {
/*  72 */       this.jTFTypeSql.setText(Output.SQLOutil.SQLDERBY);
/*  73 */       this.jTFPort.setText(Output.SQLOutil.PORTDERBY);
/*  74 */       this.jTFServeur.setText(Output.SQLOutil.SERVERDERBY);
/*  75 */       this.jTFUser.setText(Output.SQLOutil.USERDERBY);
/*     */     }
/*     */     
/*  78 */     if (type.equals(Output.SQLOutil.SQLITE)) {
/*  79 */       this.jTFTypeSql.setText(Output.SQLOutil.SQLITE);
/*  80 */       this.jTFPort.setEnabled(false);
/*  81 */       this.jTFServeur.setEnabled(false);
/*  82 */       this.jTFUser.setEnabled(false);
/*  83 */       this.jTFBD.setEnabled(true);
/*  84 */       this.jTFPassword.setEnabled(false);
/*  85 */       this.jTFChemin.setEnabled(true);
/*  86 */       this.jBtChemin.setEnabled(true);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void sauvegarderChampSQL(String type)
/*     */   {
/*  93 */     if (type.equals(Output.SQLOutil.SQLMYSQL)) {
/*  94 */       Output.SQLOutil.PORTMYSQL = this.jTFPort.getText();
/*  95 */       Output.SQLOutil.SERVERMYSQL = this.jTFServeur.getText();
/*  96 */       Output.SQLOutil.USERMYSQL = this.jTFUser.getText();
/*     */     }
/*     */     
/*  99 */     if (type.equals(Output.SQLOutil.SQLORACLE)) {
/* 100 */       Output.SQLOutil.PORTORACLE = this.jTFPort.getText();
/* 101 */       Output.SQLOutil.SERVERORACLE = this.jTFServeur.getText();
/* 102 */       Output.SQLOutil.USERORACLE = this.jTFUser.getText();
/*     */     }
/*     */     
/* 105 */     if (type.equals(Output.SQLOutil.SQLPOSTGRE))
/*     */     {
/* 107 */       Output.SQLOutil.PORTPOSTGRE = this.jTFPort.getText();
/* 108 */       Output.SQLOutil.SERVERPOSTGRE = this.jTFServeur.getText();
/* 109 */       Output.SQLOutil.USERPOSTGRE = this.jTFUser.getText();
/*     */     }
/*     */     
/* 112 */     if (type.equals(Output.SQLOutil.SQLFIREBIRD)) {
/* 113 */       Output.SQLOutil.PORTFIREBIRD = this.jTFPort.getText();
/* 114 */       Output.SQLOutil.SERVERFIREBIRD = this.jTFServeur.getText();
/* 115 */       Output.SQLOutil.USERFIREBIRD = this.jTFUser.getText();
/*     */     }
/*     */     
/*     */ 
/* 119 */     if (type.equals(Output.SQLOutil.SQLDERBY)) {
/* 120 */       Output.SQLOutil.PORTDERBY = this.jTFPort.getText();
/* 121 */       Output.SQLOutil.SERVERDERBY = this.jTFServeur.getText();
/* 122 */       Output.SQLOutil.USERDERBY = this.jTFUser.getText();
/*     */     }
/*     */     
/* 125 */     if (type.equals(Output.SQLOutil.SQLITE)) {}
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
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 143 */     this.jPanel1 = new javax.swing.JPanel();
/* 144 */     this.jLabel1 = new javax.swing.JLabel();
/* 145 */     this.jLabel2 = new javax.swing.JLabel();
/* 146 */     this.jLabel3 = new javax.swing.JLabel();
/* 147 */     this.jLabel4 = new javax.swing.JLabel();
/* 148 */     this.jTFBD = new JTextField();
/* 149 */     this.jTFUser = new JTextField();
/* 150 */     this.jTFPassword = new javax.swing.JPasswordField();
/* 151 */     this.jTFTypeSql = new JTextField();
/* 152 */     this.jLabel5 = new javax.swing.JLabel();
/* 153 */     this.jTFServeur = new JTextField();
/* 154 */     this.jLabel6 = new javax.swing.JLabel();
/* 155 */     this.jTFPort = new JTextField();
/* 156 */     this.jBtChemin = new javax.swing.JButton();
/* 157 */     this.jLabel7 = new javax.swing.JLabel();
/* 158 */     this.jTFChemin = new JTextField();
/* 159 */     this.jButton1 = new javax.swing.JButton();
/* 160 */     this.jButton2 = new javax.swing.JButton();
/*     */     
/* 162 */     setDefaultCloseOperation(2);
/* 163 */     setTitle("Connexion au serveur de base de données");
/* 164 */     setResizable(false);
/*     */     
/* 166 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 168 */     this.jLabel1.setText("Type ");
/*     */     
/* 170 */     this.jLabel2.setText("Nom de la  base ");
/*     */     
/* 172 */     this.jLabel3.setText("Utilisateur");
/*     */     
/* 174 */     this.jLabel4.setText("Mot de passe");
/*     */     
/* 176 */     this.jTFBD.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 178 */         FormeConnexion.this.jTFBDActionPerformed(evt);
/*     */       }
/*     */       
/* 181 */     });
/* 182 */     this.jTFUser.setText("root");
/*     */     
/* 184 */     this.jTFTypeSql.setEditable(false);
/*     */     
/* 186 */     this.jLabel5.setText("Serveur");
/*     */     
/* 188 */     this.jTFServeur.setText("localhost");
/*     */     
/* 190 */     this.jLabel6.setText("Port");
/*     */     
/* 192 */     this.jBtChemin.setText("...");
/* 193 */     this.jBtChemin.setEnabled(false);
/* 194 */     this.jBtChemin.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 196 */         FormeConnexion.this.jBtCheminActionPerformed(evt);
/*     */       }
/*     */       
/* 199 */     });
/* 200 */     this.jLabel7.setText("Chemin ");
/*     */     
/* 202 */     this.jTFChemin.setEditable(false);
/* 203 */     this.jTFChemin.setEnabled(false);
/*     */     
/* 205 */     javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this.jPanel1);
/* 206 */     this.jPanel1.setLayout(jPanel1Layout);
/* 207 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel3).addComponent(this.jLabel4).addComponent(this.jLabel2)).addGap(23, 23, 23).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jTFTypeSql, -2, 117, -2).addComponent(this.jTFBD, -1, 281, 32767).addComponent(this.jTFPassword, -1, 281, 32767).addComponent(this.jTFUser, -1, 281, 32767).addComponent(this.jTFServeur, -1, 281, 32767).addComponent(this.jTFChemin, -1, 281, 32767))).addComponent(this.jLabel5).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel7).addGap(345, 345, 345))).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel6).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTFPort, -2, 56, -2)).addComponent(this.jBtChemin)).addContainerGap()));
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
/* 239 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFTypeSql, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jLabel6).addComponent(this.jTFPort, -2, -1, -2).addComponent(this.jTFServeur, -2, -1, -2)).addGap(17, 17, 17).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTFUser, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jTFPassword, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTFBD, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jLabel7).addComponent(this.jTFChemin, -2, -1, -2).addComponent(this.jBtChemin)).addContainerGap(20, 32767)));
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
/*     */ 
/* 272 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 273 */     this.jButton1.setText("Valider");
/* 274 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 276 */         FormeConnexion.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/* 279 */     });
/* 280 */     this.jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 281 */     this.jButton2.setText("Annuler");
/* 282 */     this.jButton2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 284 */         FormeConnexion.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/* 287 */     });
/* 288 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/* 289 */     getContentPane().setLayout(layout);
/* 290 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jButton2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1))).addContainerGap()));
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
/* 302 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap()));
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
/* 314 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
/* 318 */     dispose();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
/* 322 */     if (this.jTFBD.getText().trim().length() == 0) {
/* 323 */       javax.swing.JOptionPane.showMessageDialog(this, "le nom de la base ne doit pas être vide");
/* 324 */       return;
/*     */     }
/* 326 */     if (this.jTFTypeSql.getText().equals(Output.SQLOutil.SQLMYSQL)) {
/* 327 */       if (this.frm.getFormeMCD().getConnexion() == null) this.frm.getFormeMCD().setConnexion(new Outil.Connexion());
/* 328 */       Outil.Connexion.EtablirConnexionMySql(this.frm.getFormeMCD().getConnexion(), this.jTFServeur.getText(), this.jTFBD.getText(), this.jTFUser.getText(), this.jTFPassword.getText(), this.jTFPort.getText());
/*     */     }
/* 330 */     if (this.jTFTypeSql.getText().equals(Output.SQLOutil.SQLPOSTGRE)) {
/* 331 */       Outil.Connexion.EtablirConnexionPostGre(this.frm.getFormeMCD().getConnexion(), this.jTFServeur.getText(), this.jTFBD.getText(), this.jTFUser.getText(), this.jTFPassword.getText(), this.jTFPort.getText());
/*     */     }
/*     */     
/* 334 */     if (this.jTFTypeSql.getText().equals(Output.SQLOutil.SQLORACLE)) {
/* 335 */       Outil.Connexion.EtablirConnexionOracle(this.frm.getFormeMCD().getConnexion(), this.jTFServeur.getText(), this.jTFBD.getText(), this.jTFUser.getText(), this.jTFPassword.getText(), this.jTFPort.getText());
/*     */     }
/*     */     
/* 338 */     if (this.jTFTypeSql.getText().equals(Output.SQLOutil.SQLDERBY)) {
/* 339 */       Outil.Connexion.EtablirConnexionDerby(this.frm.getFormeMCD().getConnexion(), this.jTFServeur.getText(), this.jTFBD.getText(), this.jTFUser.getText(), this.jTFPassword.getText(), this.jTFPort.getText());
/*     */     }
/*     */     
/* 342 */     if (this.jTFTypeSql.getText().equals(Output.SQLOutil.SQLITE)) {
/* 343 */       Outil.Connexion.EtablirConnexionSQLite(this.frm.getFormeMCD().getConnexion(), this.frm, this.jTFChemin.getText(), this.jTFBD.getText());
/*     */     }
/*     */     
/* 346 */     if (this.jTFTypeSql.getText().equals(Output.SQLOutil.SQLFIREBIRD)) {
/* 347 */       Outil.Connexion.EtablirConnexionFireBird(this.frm.getFormeMCD().getConnexion(), this.jTFServeur.getText(), this.jTFBD.getText(), this.jTFUser.getText(), this.jTFPassword.getText(), this.jTFPort.getText(), this.jTFChemin.getText());
/*     */     }
/*     */     
/* 350 */     if (this.frm.getFormeMCD().getConnexion().conn == null) {
/* 351 */       javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Impossible de se connecter !!!!\n Verifier le Connecteur(Driver) existe dans le bon repertoire \nle serveur est bien démarré \nle nom de la base de donnée existe \nle login et le mot de passe sont corrects ");
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 357 */       javax.swing.JOptionPane.showMessageDialog(this, "Connexion réussie :) !!!\n ");
/* 358 */       sauvegarderChampSQL(this.jTFTypeSql.getText());
/* 359 */       dispose();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void jTFBDActionPerformed(java.awt.event.ActionEvent evt) {}
/*     */   
/*     */   private void jBtCheminActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 368 */     if (this.jTFTypeSql.getText().equals(Output.SQLOutil.SQLFIREBIRD)) {
/* 369 */       javax.swing.JFileChooser fileCh = new javax.swing.JFileChooser();
/* 370 */       if (fileCh.showOpenDialog(this.frm) == 0) {
/* 371 */         String ch = fileCh.getSelectedFile().getAbsolutePath();
/* 372 */         if (fileCh.getSelectedFile().getParentFile() != null) {
/* 373 */           this.jTFBD.setText(ch.replace(fileCh.getSelectedFile().getParentFile().getAbsolutePath() + java.io.File.separator, ""));
/* 374 */           this.jTFChemin.setText(ch.replace(java.io.File.separator + this.jTFBD.getText(), ""));
/*     */         } else {
/* 376 */           this.jTFChemin.setText(fileCh.getSelectedFile().getAbsolutePath());
/* 377 */           this.jTFBD.setText(fileCh.getSelectedFile().getParentFile().getAbsolutePath());
/*     */         }
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 383 */       javax.swing.JFileChooser fileCh = new javax.swing.JFileChooser();
/* 384 */       fileCh.setFileSelectionMode(1);
/* 385 */       if (fileCh.showOpenDialog(this.frm) == 0) {
/* 386 */         this.jTFChemin.setText(fileCh.getSelectedFile().getAbsolutePath());
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\ihm\FormeConnexion.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */