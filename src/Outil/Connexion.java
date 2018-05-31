/*     */ package Outil;
/*     */ 
/*     */ import Output.SQLOutil;
/*     */ import java.awt.Frame;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Connexion
/*     */ {
/*     */   public Connection conn;
/*  27 */   public String typeSql = "";
/*  28 */   public String base = "";
/*     */   
/*     */   public Connexion() {
/*  31 */     this.conn = null;
/*  32 */     this.typeSql = "";
/*  33 */     this.base = "";
/*     */   }
/*     */   
/*     */   public static Connection EtablirConnexionMySql(Connexion conn, String server, String bd, String log, String password, String port) {
/*  37 */     try { Class.forName("org.gjt.mm.mysql.Driver");
/*     */       try
/*     */       {
/*  40 */         if (port.trim().length() != 0) server = server + ":" + port;
/*  41 */         String url = "jdbc:mysql://" + server + "/" + bd;
/*     */         
/*  43 */         Connection con = DriverManager.getConnection(url, log, password);
/*     */         
/*  45 */         conn.conn = con;
/*  46 */         conn.typeSql = SQLOutil.SQLMYSQL;
/*  47 */         conn.base = bd;
/*  48 */         return con;
/*     */       }
/*     */       catch (Exception E) {
/*  51 */         System.out.println("Pas de pilote !");
/*  52 */         conn.conn = null;
/*  53 */         return null;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/*  57 */       Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
/*  58 */       conn.conn = null;
/*     */     }
/*     */
return null;   }
/*     */   
/*     */   public static Connection EtablirConnexionOracle(Connexion conn, String server, String bd, String log, String password, String port)
/*     */   {
/*     */     try {
/*  65 */       Class.forName("oracle.jdbc.driver.OracleDriver");
/*     */       try
/*     */       {
/*  68 */         if (port.trim().length() != 0) server = server + ":" + port + ":XE";
/*  69 */         String url = "jdbc:oracle:thin:@" + server;
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  77 */         Connection con = DriverManager.getConnection(url, "root", "root");
/*     */         
/*  79 */         conn.conn = con;
/*  80 */         conn.typeSql = SQLOutil.SQLORACLE;
/*  81 */         conn.base = bd;
/*  82 */         return con;
/*     */       }
/*     */       catch (Exception E) {
/*  85 */         System.out.println("Pas de pilote !");
/*  86 */         conn.conn = null;
/*  87 */         return null;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/*  91 */       Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
/*  92 */       conn.conn = null;
/*     */     }
/*     */
return null;   }
/*     */   
/*     */   public static Connection EtablirConnexionPostGre(Connexion conn, String server, String bd, String log, String password, String port)
/*     */   {
/*     */     try {
/*  99 */       Class.forName("org.postgresql.Driver");
/*     */       try
/*     */       {
/* 102 */         if (port.trim().length() != 0) server = server + ":" + port;
/* 103 */         String url = "jdbc:postgresql://" + server + "/" + bd;
/*     */         
/* 105 */         Connection con = DriverManager.getConnection(url, log, password);
/*     */         
/* 107 */         conn.conn = con;
/* 108 */         conn.typeSql = SQLOutil.SQLPOSTGRE;
/* 109 */         conn.base = bd;
/* 110 */         return con;
/*     */       }
/*     */       catch (Exception E) {
/* 113 */         System.out.println("Pas de pilote !");
/* 114 */         conn.conn = null;
/* 115 */         return null;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/* 119 */       Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
/* 120 */       conn.conn = null;
/*     */     }
/*     */
return null;   }
/*     */   
/*     */   public static Connection EtablirConnexionFireBird(Connexion conn, String server, String bd, String log, String password, String port, String chemin)
/*     */   {
/*     */     try {
/* 127 */       Class.forName("org.firebirdsql.jdbc.FBDriver");
/*     */       try
/*     */       {
/* 130 */         Connection con = null;
/* 131 */         String dbPath = server + ":" + port + "/" + chemin + File.separator + bd;
/* 132 */         String dbUser = log;
/* 133 */         String dbPassword = password;
/*     */         
/* 135 */         String db = "jdbc:firebirdsql://" + dbPath + "?user=" + dbUser + "&password=" + dbPassword;
/* 136 */         con = DriverManager.getConnection(db);
/* 137 */         conn.conn = con;
/* 138 */         conn.typeSql = SQLOutil.SQLFIREBIRD;
/* 139 */         conn.base = bd;
/* 140 */         return con;
/*     */       }
/*     */       catch (Exception E) {
/* 143 */         System.out.println("Pas de pilote !");
/* 144 */         conn.conn = null;
/* 145 */         return null;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/* 149 */       Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
/* 150 */       conn.conn = null;
/*     */     }
/*     */
return null;   }
/*     */   
/*     */   public static Connection EtablirConnexionDerby(Connexion conn, String server, String bd, String log, String password, String port)
/*     */   {
/*     */     try {
/* 157 */       Class.forName("org.apache.derby.jdbc.ClientDriver");
/*     */       try
/*     */       {
/* 160 */         if (port.trim().length() != 0) server = server + ":" + port;
/* 161 */         String url = "jdbc:derby://" + server + "/" + bd;
/* 162 */         System.out.println(url);
/* 164 */         Connection con; if ((log.trim().length() == 0) && (password.trim().length() == 0)) con = DriverManager.getConnection(url); else {
/* 165 */           con = DriverManager.getConnection(url, log, password);
/*     */         }
/* 167 */         conn.conn = con;
/* 168 */         conn.typeSql = SQLOutil.SQLDERBY;
/* 169 */         conn.base = bd;
/* 170 */         return con;
/*     */       }
/*     */       catch (Exception E) {
/* 173 */         System.out.println("Pas de pilote !");
/* 174 */         conn.conn = null;
/* 175 */         return null;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/* 179 */       Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
/* 180 */       conn.conn = null;
/*     */     }
/*     */
return null;   }
/*     */   
/*     */   public static Connection EtablirConnexionSQLite(Connexion conn, Frame frm, String chemin, String bd)
/*     */   {
/*     */     try {
/* 187 */       Class.forName("org.sqlite.JDBC");
/*     */       try {
/* 189 */         if (existeFichier(chemin, bd)) {
/* 190 */           if (JOptionPane.showConfirmDialog(frm, bd + " éxite déjà \nVoulez vous remplacer le fichier ?", "Modification ", 0) == 0) {
/* 191 */             File fff = new File(chemin + File.separator + extentionSQLite(bd));
/* 192 */             fff.delete();
/* 193 */             String url = "jdbc:sqlite:" + chemin + File.separator + extentionSQLite(bd);
/* 194 */             Connection con = DriverManager.getConnection(url);
/* 195 */             conn.conn = con;
/* 196 */             conn.typeSql = SQLOutil.SQLITE;
/* 197 */             conn.base = bd;
/* 198 */             return con;
/*     */           }
/* 200 */           conn.conn = null;
/* 201 */           return null;
/*     */         }
/*     */         
/* 204 */         String url = "jdbc:sqlite:" + chemin + File.separator + extentionSQLite(bd);
/* 205 */         Connection con = DriverManager.getConnection(url);
/*     */         
/* 207 */         conn.conn = con;
/* 208 */         conn.typeSql = SQLOutil.SQLITE;
/* 209 */         conn.base = bd;
/* 210 */         return con;
/*     */ 
/*     */       }
/*     */       catch (Exception E)
/*     */       {
/* 215 */         System.out.println("Pas de pilote !");
/* 216 */         conn.conn = null;
/* 217 */         return null;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*     */     catch (ClassNotFoundException ex)
/*     */     {
/* 221 */       Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
/* 222 */       conn.conn = null;
/*     */     }
/*     */
return null;   }
/*     */   
/*     */   private static boolean existeFichier(String ch, String f)
/*     */   {
/* 228 */     String fileCh = ch + File.separator + extentionSQLite(f);
/* 229 */     File fil = new File(fileCh);
/* 230 */     if (fil.exists()) {
/* 231 */       return true;
/*     */     }
/* 233 */     return false;
/*     */   }
/*     */   
/*     */   private static String extentionSQLite(String f)
/*     */   {
/* 238 */     if (f.trim().toUpperCase().endsWith(".DB")) return f;
/* 239 */     return f + ".db";
/*     */   }
/*     */   
/*     */   public static void Deconnecter(Connexion conn) {
/*     */     try {
/* 244 */       conn.conn.close();
/*     */     } catch (SQLException ex) {
/* 246 */       Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   public static ResultSet executer(Connexion conn, String req)
/*     */   {
/*     */     try {
/* 253 */       Statement st = conn.conn.createStatement();
/* 254 */       return st.executeQuery(req);
/*     */     }
/*     */     catch (SQLException ex) {}
/*     */     
/*     */ 
/* 259 */     return null;
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
/*     */   public static int executerMAJ(Connexion conn, String req)
/*     */     throws SQLException
/*     */   {
/* 278 */     int rs = -1;
/* 279 */     Statement st = conn.conn.createStatement();
/* 280 */     rs = st.executeUpdate(req);
/* 281 */     return rs;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Outil\Connexion.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */