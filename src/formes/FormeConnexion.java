/*     */ package formes;
/*     */ 
/*     */ import Output.SQLOutil;
/*     */ import composantSQL.MyDataBase;
/*     */ import java.sql.Connection;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class FormeConnexion extends javax.swing.JDialog
/*     */ {
/*     */   private Connection connection;
/*     */   private MyDataBase db;
/*     */   private ihm.Principale parent;
/*     */   private JButton jBtChemin;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JComboBox jCBTypeDriver;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private javax.swing.JPanel jPanel1;
/*     */   private JTextField jTFBD;
/*     */   private javax.swing.JPasswordField jTFPassword;
/*     */   private JTextField jTFPort;
/*     */   private JTextField jTFServeur;
/*     */   private JTextField jTFUser;
/*     */   
/*     */   public FormeConnexion(ihm.Principale parent, boolean modal, MyDataBase db, Connection connection)
/*     */   {
/*  39 */     super(parent, modal);
/*  40 */     initComponents();
/*  41 */     this.parent = parent;
/*  42 */     setLocation(parent.getX() + 300, parent.getY() + 100);
/*  43 */     this.jButton1.setMnemonic(10);
/*  44 */     this.jButton2.setMnemonic(65);
/*  45 */     this.connection = connection;
/*  46 */     this.jTFBD.setText(db.getName());
/*  47 */     this.db = db;
/*  48 */     if (db != null)
/*  49 */       if (db.getTypeSQL() != null) {
/*  50 */         choixType(db.getTypeSQL());
/*  51 */         initialiserChamp(db.getTypeSQL());
/*     */       } else {
/*  53 */         initialiserChamp(SQLOutil.SQLMYSQL);
/*     */       }
/*     */   }
/*     */   
/*     */   private void initialiserChamp(String type) {
/*  58 */     if (type.equals(SQLOutil.SQLMYSQL)) {
/*  59 */       this.jTFPort.setText(SQLOutil.PORTMYSQL);
/*  60 */       this.jTFServeur.setText(SQLOutil.SERVERMYSQL);
/*  61 */       this.jTFUser.setText(SQLOutil.USERMYSQL);
/*  62 */       this.jTFBD.setText(SQLOutil.DBMYSQL);
/*     */       
/*  64 */       this.jTFPort.setEnabled(true);
/*  65 */       this.jTFServeur.setEnabled(true);
/*  66 */       this.jTFUser.setEnabled(true);
/*  67 */       this.jTFBD.setEnabled(true);
/*  68 */       this.jTFPassword.setEnabled(true);
/*  69 */       this.jBtChemin.setEnabled(false);
/*     */     }
/*     */     
/*     */ 
/*  73 */     if (type.equals(SQLOutil.SQLPOSTGRE)) {
/*  74 */       this.jTFPort.setText(SQLOutil.PORTPOSTGRE);
/*  75 */       this.jTFServeur.setText(SQLOutil.SERVERPOSTGRE);
/*  76 */       this.jTFUser.setText(SQLOutil.USERPOSTGRE);
/*  77 */       this.jTFBD.setText(SQLOutil.DBPOSTGRE);
/*     */       
/*  79 */       this.jTFPort.setEnabled(true);
/*  80 */       this.jTFServeur.setEnabled(true);
/*  81 */       this.jTFUser.setEnabled(true);
/*  82 */       this.jTFBD.setEnabled(true);
/*  83 */       this.jTFPassword.setEnabled(true);
/*  84 */       this.jBtChemin.setEnabled(false);
/*     */     }
/*     */     
/*  87 */     if (type.equals(SQLOutil.SQLDERBY)) {
/*  88 */       this.jTFPort.setText(SQLOutil.PORTDERBY);
/*  89 */       this.jTFServeur.setText(SQLOutil.SERVERDERBY);
/*  90 */       this.jTFUser.setText(SQLOutil.USERDERBY);
/*  91 */       this.jTFBD.setText(SQLOutil.DBDERBY);
/*  92 */       this.jTFPort.setEnabled(true);
/*  93 */       this.jTFServeur.setEnabled(true);
/*  94 */       this.jTFUser.setEnabled(true);
/*  95 */       this.jTFBD.setEnabled(true);
/*  96 */       this.jTFPassword.setEnabled(true);
/*  97 */       this.jBtChemin.setEnabled(false);
/*     */     }
/*     */     
/* 100 */     if (type.equals(SQLOutil.SQLITE)) {
/* 101 */       this.jTFPort.setEnabled(false);
/* 102 */       this.jTFServeur.setEnabled(false);
/* 103 */       this.jTFUser.setEnabled(false);
/* 104 */       this.jTFBD.setEnabled(true);
/* 105 */       this.jTFBD.setText(SQLOutil.DBSQLITE);
/* 106 */       this.jTFPassword.setEnabled(false);
/* 107 */       this.jBtChemin.setEnabled(true);
/*     */     }
/* 109 */     if (type.equals(SQLOutil.HSQLDB))
/*     */     {
/* 111 */       this.jTFPort.setEnabled(false);
/* 112 */       this.jTFServeur.setEnabled(false);
/* 113 */       this.jTFUser.setEnabled(true);
/* 114 */       this.jTFBD.setEnabled(true);
/* 115 */       this.jTFPassword.setEnabled(true);
/* 116 */       this.jBtChemin.setEnabled(true);
/* 117 */       this.jTFUser.setText(SQLOutil.USERHSQLDB);
/*     */     }
/* 119 */     if (type.equals(SQLOutil.SQLFIREBIRD)) {
/* 120 */       this.jTFPort.setText(SQLOutil.PORTFIREBIRD);
/* 121 */       this.jTFServeur.setText(SQLOutil.SERVERFIREBIRD);
/* 122 */       this.jTFUser.setText(SQLOutil.USERFIREBIRD);
/* 123 */       this.jTFBD.setText(SQLOutil.DBFIREBIRD);
/* 124 */       this.jTFPort.setEnabled(true);
/* 125 */       this.jTFServeur.setEnabled(true);
/* 126 */       this.jTFUser.setEnabled(true);
/* 127 */       this.jTFBD.setEnabled(false);
/* 128 */       this.jTFPassword.setEnabled(true);
/* 129 */       this.jBtChemin.setEnabled(true);
/*     */     }
/*     */   }
/*     */   
/*     */   private void choixType(String type)
/*     */   {
/* 135 */     if (type.equals(SQLOutil.SQLMYSQL)) {
/* 136 */       this.jCBTypeDriver.setSelectedIndex(0);
/*     */     }
/* 138 */     if (type.equals(SQLOutil.SQLITE)) {
/* 139 */       this.jCBTypeDriver.setSelectedIndex(1);
/*     */     }
/* 141 */     if (type.equals(SQLOutil.SQLPOSTGRE)) {
/* 142 */       this.jCBTypeDriver.setSelectedIndex(2);
/*     */     }
/*     */     
/* 145 */     if (type.equals(SQLOutil.SQLDERBY)) {
/* 146 */       this.jCBTypeDriver.setSelectedIndex(3);
/*     */     }
/*     */     
/* 149 */     if (type.equals(SQLOutil.SQLFIREBIRD)) {
/* 150 */       this.jCBTypeDriver.setSelectedIndex(4);
/*     */     }
/* 152 */     if (type.equals(SQLOutil.HSQLDB)) {
/* 153 */       this.jCBTypeDriver.setSelectedIndex(5);
/*     */     }
/*     */   }
/*     */   
/*     */   public Connection EtablirConnexionMySql(String server, String bd, String log, String password, String port) {
/*     */     try {
/* 159 */       Class.forName("org.gjt.mm.mysql.Driver");
/*     */       try {
/* 161 */         if (port.trim().length() != 0) server = server + ":" + port;
/* 162 */         String url = "jdbc:mysql://" + server + "/" + bd;
/*     */         
/* 164 */         Connection con = java.sql.DriverManager.getConnection(url, log, password);
/*     */         
/* 166 */         this.db.setConnection(con);
/* 167 */         this.db.setTypeSQL(SQLOutil.SQLMYSQL);
/* 168 */         this.db.setName(bd);
/* 169 */         return con;
/*     */       }
/*     */       catch (Exception E)
/*     */       {
/* 173 */         System.out.println("Pas de pilote !");
/* 174 */         this.db.setConnection(null);
/* 175 */         return null;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/* 180 */       java.util.logging.Logger.getLogger(Outil.Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/* 181 */       this.db.setConnection(null);
/*     */     }
/*     */
return connection;   }
/*     */   
/*     */   public Connection EtablirConnexionPostGre(String server, String bd, String log, String password, String port)
/*     */   {
/*     */     try {
/* 188 */       Class.forName("org.postgresql.Driver");
/*     */       try {
/* 190 */         if (port.trim().length() != 0) server = server + ":" + port;
/* 191 */         String url = "jdbc:postgresql://" + server + "/" + bd;
/*     */         
/* 193 */         Connection con = java.sql.DriverManager.getConnection(url, log, password);
/*     */         
/* 195 */         this.db.setConnection(con);
/* 196 */         this.db.setTypeSQL(SQLOutil.SQLPOSTGRE);
/* 197 */         this.db.setName(bd);
/* 198 */         return con;
/*     */       }
/*     */       catch (Exception E) {
/* 201 */         System.out.println("Pas de pilote !");
/* 202 */         this.db.setConnection(null);
/* 203 */         return null;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/* 207 */       java.util.logging.Logger.getLogger(Outil.Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/* 208 */       this.db.setConnection(null);
/*     */     }
/*     */
return connection;   }
/*     */   
/*     */   public Connection EtablirConnexionFireBird(String server, String bd, String log, String password, String port)
/*     */   {
/*     */     try {
/* 215 */       Class.forName("org.firebirdsql.jdbc.FBDriver");
/*     */       try
/*     */       {
/* 218 */         Connection con = null;
/* 219 */         String dbPath = server + ":" + port + "/" + bd;
/* 220 */         String dbUser = log;
/* 221 */         String dbPassword = password;
/*     */         
/* 223 */         String dbF = "jdbc:firebirdsql://" + dbPath + "?user=" + dbUser + "&password=" + dbPassword;
/*     */         
/* 225 */         con = java.sql.DriverManager.getConnection(dbF);
/*     */         
/* 227 */         this.db.setConnection(con);
/* 228 */         this.db.setTypeSQL(SQLOutil.SQLFIREBIRD);
/* 229 */         this.db.setName(bd);
/*     */         
/* 231 */         return con;
/*     */       }
/*     */       catch (Exception E) {
/* 234 */         System.out.println("Pas de pilote !");
/*     */         
/* 236 */         this.db.setConnection(null);
/* 237 */         return null;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/* 241 */       java.util.logging.Logger.getLogger(Outil.Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */       
/* 243 */       this.db.setConnection(null);
/*     */     }
/*     */
return connection;   }
/*     */   
/*     */   public Connection EtablirConnexionDerby(String server, String bd, String log, String password, String port)
/*     */   {
/*     */     try {
/* 250 */       Class.forName("org.apache.derby.jdbc.ClientDriver");
/*     */       try {
/* 252 */         if (port.trim().length() != 0) server = server + ":" + port;
/* 253 */         String url = "jdbc:derby://" + server + "/" + bd;
/* 255 */         Connection con; if ((log.trim().length() == 0) && (password.trim().length() == 0)) con = java.sql.DriverManager.getConnection(url); else {
/* 256 */           con = java.sql.DriverManager.getConnection(url, log, password);
/*     */         }
/* 258 */         this.db.setConnection(con);
/* 259 */         this.db.setTypeSQL(SQLOutil.SQLPOSTGRE);
/* 260 */         this.db.setName(bd);
/* 261 */         return con;
/*     */       }
/*     */       catch (Exception E) {
/* 264 */         System.out.println("Pas de pilote !");
/* 265 */         this.db.setConnection(null);
/* 266 */         return null;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/* 270 */       java.util.logging.Logger.getLogger(Outil.Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/* 271 */       this.db.setConnection(null);
/*     */     }
/*     */
return connection;   }
/*     */   
/*     */   public Connection EtablirConnexionSQLite(String bd)
/*     */   {
/*     */     try {
/* 278 */       Class.forName("org.sqlite.JDBC");
/*     */       try {
/* 280 */         String url = "jdbc:sqlite:" + bd;
/* 281 */         Connection con = java.sql.DriverManager.getConnection(url);
/* 282 */         this.db.setConnection(con);
/* 283 */         this.db.setTypeSQL(SQLOutil.SQLITE);
/* 284 */         this.db.setName(bd);
/* 285 */         return con;
/*     */       }
/*     */       catch (Exception E) {
/* 288 */         System.out.println("Pas de pilote !");
/* 289 */         this.db.setConnection(null);
/* 290 */         return null;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/* 294 */       java.util.logging.Logger.getLogger(Outil.Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/* 295 */       this.db.setConnection(null);
/*     */     }
/*     */
return connection;   }
/*     */   
/*     */   public Connection EtablirConnexionSQLite(String bd, String log, String passW)
/*     */   {
/*     */     try {
/* 302 */       Class.forName("org.sqlite.JDBC");
/*     */       try {
/* 304 */         String url = "jdbc:sqlite:" + bd;
/* 305 */         Connection con = java.sql.DriverManager.getConnection(url);
/* 306 */         this.db.setConnection(con);
/* 307 */         this.db.setTypeSQL(SQLOutil.SQLITE);
/* 308 */         this.db.setName(bd);
/* 309 */         return con;
/*     */       }
/*     */       catch (Exception E) {
/* 312 */         System.out.println("Pas de pilote !");
/* 313 */         this.db.setConnection(null);
/* 314 */         return null;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/* 318 */       java.util.logging.Logger.getLogger(Outil.Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/* 319 */       this.db.setConnection(null);
/*     */     }
/*     */
return connection;   }
/*     */   
/*     */   public Connection EtablirConnexionHSQLDB(String bd, String log, String passW)
/*     */   {
/*     */     try {
/* 326 */       Class.forName("org.hsqldb.jdbcDriver");
/*     */       try {
/* 328 */         String url = "jdbc:hsqldb:file:" + bd;
/*     */         
/* 330 */         Connection con = java.sql.DriverManager.getConnection(url, log, passW);
/* 331 */         this.db.setConnection(con);
/* 332 */         this.db.setTypeSQL(SQLOutil.HSQLDB);
/* 333 */         this.db.setName(bd);
/* 334 */         return con;
/*     */       }
/*     */       catch (Exception E) {
/* 337 */         System.out.println("Pas de pilote =====!" + E);
/* 338 */         this.db.setConnection(null);
/* 339 */         return null;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/* 343 */       java.util.logging.Logger.getLogger(Outil.Connexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/* 344 */       this.db.setConnection(null);
/*     */     }
/*     */
return connection;   }
/*     */   
/*     */ 
/*     */   public Connection EtablirConnexion(String server, String bd, String log, String password, String port)
/*     */   {
/* 351 */     if (this.jCBTypeDriver.getSelectedItem().toString().equals("MYSQL")) {
/* 352 */       return EtablirConnexionMySql(server, bd, log, password, port);
/*     */     }
/*     */     
/* 355 */     if (this.jCBTypeDriver.getSelectedItem().toString().equals("SQLITE")) {
/* 356 */       return EtablirConnexionSQLite(bd);
/*     */     }
/*     */     
/* 359 */     if (this.jCBTypeDriver.getSelectedItem().toString().equals("POSTGRE")) {
/* 360 */       return EtablirConnexionPostGre(server, bd, log, password, port);
/*     */     }
/*     */     
/* 363 */     if (this.jCBTypeDriver.getSelectedItem().toString().equals("FIREBIRD")) {
/* 364 */       return EtablirConnexionFireBird(server, bd, log, password, port);
/*     */     }
/*     */     
/* 367 */     if (this.jCBTypeDriver.getSelectedItem().toString().equals("DERBY")) {
/* 368 */       return EtablirConnexionDerby(server, bd, log, password, port);
/*     */     }
/* 370 */     if (this.jCBTypeDriver.getSelectedItem().toString().equals("HSQLDB")) {
/* 371 */       return EtablirConnexionHSQLDB(bd, log, password);
/*     */     }
/* 373 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getTypeSql()
/*     */   {
/* 381 */     String t = "";
/* 382 */     if (((String)this.jCBTypeDriver.getSelectedItem()).equals("MYSQL")) t = "MYSQL";
/* 383 */     if (((String)this.jCBTypeDriver.getSelectedItem()).equals("SQLITE")) t = "SQLITE";
/* 384 */     if (((String)this.jCBTypeDriver.getSelectedItem()).equals("POSTGRE")) t = "POSTGRE";
/* 385 */     if (((String)this.jCBTypeDriver.getSelectedItem()).equals("DERBY")) t = "DERBY";
/* 386 */     if (((String)this.jCBTypeDriver.getSelectedItem()).equals("FIREBIRD")) t = "FIREBIRD";
/* 387 */     return t;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void sauvegarderChampSQL(String type)
/*     */   {
/* 394 */     if (type.equals(SQLOutil.SQLMYSQL)) {
/* 395 */       SQLOutil.PORTMYSQL = this.jTFPort.getText();
/* 396 */       SQLOutil.SERVERMYSQL = this.jTFServeur.getText();
/* 397 */       SQLOutil.USERMYSQL = this.jTFUser.getText();
/* 398 */       SQLOutil.PWMYSQL = this.jTFPassword.getText();
/* 399 */       SQLOutil.DBMYSQL = this.jTFBD.getText();
/*     */     }
/*     */     
/* 402 */     if (type.equals(SQLOutil.SQLPOSTGRE)) {
/* 403 */       SQLOutil.PORTPOSTGRE = this.jTFPort.getText();
/* 404 */       SQLOutil.SERVERPOSTGRE = this.jTFServeur.getText();
/* 405 */       SQLOutil.USERPOSTGRE = this.jTFUser.getText();
/* 406 */       SQLOutil.PWPOSTGRE = this.jTFPassword.getText();
/* 407 */       SQLOutil.DBPOSTGRE = this.jTFBD.getText();
/*     */     }
/*     */     
/* 410 */     if (type.equals(SQLOutil.SQLDERBY)) {
/* 411 */       SQLOutil.PORTDERBY = this.jTFPort.getText();
/* 412 */       SQLOutil.SERVERDERBY = this.jTFServeur.getText();
/* 413 */       SQLOutil.USERDERBY = this.jTFUser.getText();
/* 414 */       SQLOutil.PWDERBY = this.jTFPassword.getText();
/* 415 */       SQLOutil.DBDERBY = this.jTFBD.getText();
/*     */     }
/*     */     
/* 418 */     if (type.equals(SQLOutil.SQLITE)) {
/* 419 */       SQLOutil.DBSQLITE = this.jTFBD.getText();
/*     */     }
/*     */     
/* 422 */     if ((!type.equals(SQLOutil.HSQLDB)) || 
/*     */     
/*     */ 
/*     */ 
/* 426 */       (type.equals(SQLOutil.SQLFIREBIRD))) {
/* 427 */       SQLOutil.PORTFIREBIRD = this.jTFPort.getText();
/* 428 */       SQLOutil.SERVERFIREBIRD = this.jTFServeur.getText();
/* 429 */       SQLOutil.USERFIREBIRD = this.jTFUser.getText();
/* 430 */       SQLOutil.PWFIREBIRD = this.jTFPassword.getText();
/* 431 */       SQLOutil.DBFIREBIRD = this.jTFBD.getText();
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
/* 445 */     this.jPanel1 = new javax.swing.JPanel();
/* 446 */     this.jLabel1 = new JLabel();
/* 447 */     this.jLabel2 = new JLabel();
/* 448 */     this.jCBTypeDriver = new JComboBox();
/* 449 */     this.jLabel3 = new JLabel();
/* 450 */     this.jLabel4 = new JLabel();
/* 451 */     this.jTFBD = new JTextField();
/* 452 */     this.jTFUser = new JTextField();
/* 453 */     this.jTFPassword = new javax.swing.JPasswordField();
/* 454 */     this.jLabel6 = new JLabel();
/* 455 */     this.jTFPort = new JTextField();
/* 456 */     this.jLabel5 = new JLabel();
/* 457 */     this.jTFServeur = new JTextField();
/* 458 */     this.jBtChemin = new JButton();
/* 459 */     this.jButton1 = new JButton();
/* 460 */     this.jButton2 = new JButton();
/*     */     
/* 462 */     setDefaultCloseOperation(2);
/* 463 */     setTitle("Connexion au serveur de base de données");
/* 464 */     setResizable(false);
/*     */     
/* 466 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 468 */     this.jLabel1.setText("Type ");
/*     */     
/* 470 */     this.jLabel2.setText("Nom de la  base ");
/*     */     
/* 472 */     this.jCBTypeDriver.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MYSQL", "SQLITE", "POSTGRE", "DERBY", "FIREBIRD" }));
/* 473 */     this.jCBTypeDriver.addItemListener(new java.awt.event.ItemListener() {
/*     */       public void itemStateChanged(java.awt.event.ItemEvent evt) {
/* 475 */         FormeConnexion.this.jCBTypeDriverItemStateChanged(evt);
/*     */       }
/*     */       
/* 478 */     });
/* 479 */     this.jLabel3.setText("Utilisateur");
/*     */     
/* 481 */     this.jLabel4.setText("Mot de passe");
/*     */     
/* 483 */     this.jTFBD.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 485 */         FormeConnexion.this.jTFBDActionPerformed(evt);
/*     */       }
/*     */       
/* 488 */     });
/* 489 */     this.jTFUser.setText("root");
/*     */     
/* 491 */     this.jLabel6.setText("Port");
/*     */     
/* 493 */     this.jLabel5.setText("Serveur");
/*     */     
/* 495 */     this.jBtChemin.setText("...");
/* 496 */     this.jBtChemin.setEnabled(false);
/* 497 */     this.jBtChemin.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 499 */         FormeConnexion.this.jBtCheminActionPerformed(evt);
/*     */       }
/*     */       
/* 502 */     });
/* 503 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 504 */     this.jPanel1.setLayout(jPanel1Layout);
/* 505 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel5).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel4).addGap(38, 38, 38).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBTypeDriver, -2, 145, -2).addComponent(this.jTFServeur, -1, 320, 32767).addComponent(this.jTFUser, -1, 320, 32767).addComponent(this.jTFPassword, -1, 320, 32767).addComponent(this.jTFBD, -1, 320, 32767))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel3).addComponent(this.jLabel2)).addGap(322, 322, 322))).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel6).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTFPort, -2, 56, -2)).addComponent(this.jBtChemin)).addGap(25, 25, 25)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 535 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jCBTypeDriver, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jLabel6).addComponent(this.jTFPort, -2, -1, -2).addComponent(this.jTFServeur, -2, -1, -2)).addGap(11, 11, 11).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTFUser, -2, -1, -2)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFPassword, -2, -1, -2).addComponent(this.jLabel4)).addGap(21, 21, 21).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTFBD, -2, -1, -2).addComponent(this.jBtChemin)).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 564 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/* 565 */     this.jButton1.setText("Valider");
/* 566 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 568 */         FormeConnexion.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/* 571 */     });
/* 572 */     this.jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 573 */     this.jButton2.setText("Annuler");
/* 574 */     this.jButton2.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(java.awt.event.ActionEvent evt) {
/* 576 */         FormeConnexion.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/* 579 */     });
/* 580 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 581 */     getContentPane().setLayout(layout);
/* 582 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1).addGap(16, 16, 16)))));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 596 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton2).addComponent(this.jButton1)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 608 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
/* 612 */     dispose();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
/* 616 */     if (this.connection != null) {
/*     */       try {
/* 618 */         if (!this.connection.isClosed()) {
/* 619 */           if (this.jTFBD.getText().trim().length() == 0) {
/* 620 */             javax.swing.JOptionPane.showMessageDialog(this, "le nom de la base ne doit pas être vide");
/* 621 */             return;
/*     */           }
/*     */           
/* 624 */           this.connection = EtablirConnexion(this.jTFServeur.getText(), this.jTFBD.getText(), this.jTFUser.getText(), this.jTFPassword.getText(), this.jTFPort.getText());
/*     */           
/* 626 */           if (this.connection == null) {
/* 627 */             javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Impossible de se connecter !!!!\n Vérifiez si le Connecteur(Driver) existe dans le bon répertoire \nle serveur est bien démarré \nle nom de la base de donnée existe \nle login et le mot de passe sont corrects ");
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 633 */             javax.swing.JOptionPane.showMessageDialog(this, "Connexion réussie  :) !!!\n ");
/* 634 */             this.db.setName(this.jTFBD.getText());
/* 635 */             this.db.setTypeSQL((String)this.jCBTypeDriver.getSelectedItem());
/* 636 */             this.db.setConnection(this.connection);
/* 637 */             sauvegarderChampSQL(this.jCBTypeDriver.getSelectedItem().toString());
/* 638 */             dispose();
/*     */           }
/*     */         }
/* 641 */         else if (javax.swing.JOptionPane.showConfirmDialog(this, "Vous êtes déjà connecté !!.\n Voulez vous vous déconnecter ?", "Connexion ", 0) == 0) {
/* 642 */           this.db.setConnection(null);
/*     */         }
/*     */       }
/*     */       catch (java.sql.SQLException ex) {
/* 646 */         java.util.logging.Logger.getLogger(FormeConnexion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */       }
/*     */     }
/* 649 */     this.connection = EtablirConnexion(this.jTFServeur.getText(), this.jTFBD.getText(), this.jTFUser.getText(), this.jTFPassword.getText(), this.jTFPort.getText());
/*     */     
/* 651 */     if (this.connection == null) {
/* 652 */       javax.swing.JOptionPane.showMessageDialog(this, "ERREUR : Impossible de se connecter !!!!\n Verifiez si le Connecteur(Driver) existe dans le bon répertoire \nle serveur est bien démarré \nle nom de la base de donnée existe \nle login et le mot de passe sont corrects ");
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 658 */       javax.swing.JOptionPane.showMessageDialog(this, "Connexion réussie :) !!!\n ");
/* 659 */       this.db.setName(this.jTFBD.getText());
/* 660 */       this.db.setTypeSQL((String)this.jCBTypeDriver.getSelectedItem());
/* 661 */       this.db.setConnection(this.connection);
/* 662 */       dispose();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void jTFBDActionPerformed(java.awt.event.ActionEvent evt) {}
/*     */   
/*     */ 
/*     */   private void jBtCheminActionPerformed(java.awt.event.ActionEvent evt)
/*     */   {
/* 672 */     javax.swing.JFileChooser fileCh = new javax.swing.JFileChooser();
/*     */     
/* 674 */     if (fileCh.showOpenDialog(this.parent) == 0) {
/* 675 */       this.jTFBD.setText(fileCh.getSelectedFile().getAbsolutePath());
/*     */     }
/*     */   }
/*     */   
/*     */   private void jCBTypeDriverItemStateChanged(java.awt.event.ItemEvent evt) {
/* 680 */     if (this.jCBTypeDriver.getSelectedItem().toString().equals("MYSQL")) {
/* 681 */       initialiserChamp(SQLOutil.SQLMYSQL);
/*     */     }
/*     */     
/* 684 */     if (this.jCBTypeDriver.getSelectedItem().toString().equals("SQLITE")) {
/* 685 */       initialiserChamp(SQLOutil.SQLITE);
/*     */     }
/*     */     
/* 688 */     if (this.jCBTypeDriver.getSelectedItem().toString().equals("POSTGRE")) {
/* 689 */       initialiserChamp(SQLOutil.SQLPOSTGRE);
/*     */     }
/*     */     
/* 692 */     if (this.jCBTypeDriver.getSelectedItem().toString().equals("DERBY")) {
/* 693 */       initialiserChamp(SQLOutil.SQLDERBY);
/*     */     }
/*     */     
/* 696 */     if (this.jCBTypeDriver.getSelectedItem().toString().equals("FIREBIRD")) {
/* 697 */       initialiserChamp(SQLOutil.SQLFIREBIRD);
/*     */     }
/*     */     
/* 700 */     if (this.jCBTypeDriver.getSelectedItem().toString().equals("HSQLDB")) {
/* 701 */       initialiserChamp(SQLOutil.HSQLDB);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeConnexion.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */