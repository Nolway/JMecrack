/*     */ package Outil;
/*     */ 
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD2.ConfigurationMCD2;
/*     */ import IhmMLD.IhmPageMLD;
/*     */ import Merise.Domaine;
/*     */ import com.sun.imageio.plugins.png.PNGImageWriter;
/*     */ import formes.FormeParametre;
/*     */ import formes.PanelImpression;
/*     */ import ihm.Principale;
/*     */ import ihm.Splash;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Image;
/*     */ import java.awt.PrintJob;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.geom.Rectangle2D.Double;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.net.InetAddress;
/*     */ import java.net.NetworkInterface;
/*     */ import java.net.SocketException;
/*     */ import java.net.UnknownHostException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.Properties;
/*     */ import java.util.zip.GZIPInputStream;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.imageio.stream.FileImageOutputStream;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JProgressBar;
/*     */ 
/*     */ public class Parametres
/*     */ {
/*  49 */   public static String[] KeyMySql = { "ACCESSIBLE", "ADD", "ALL", "ALTER", "ANALYZE", "AND", "AS", "ASC", "ASENSITIVE", "AUTO_INCREMENT", "BDB", "BEFORE", "BERKELEYDB", "BETWEEN", "BIGINT", "BINARY", "BLOB", "BOTH", "BY", "CALL", "CASCADE", "CASE", "CHANGE", "CHAR", "CHARACTER", "CHECK", "COLLATE", "COLUMN", "COLUMNS", "CONDITION", "CONNECTION", "CONSTRAINT", "CONTINUE", "CONVERT", "CREATE", "CROSS", "CURRENT_DATE", "CURRENT_TIME", "CURRENT_TIMESTAMP", "CURRENT_USER", "CURSOR", "DATABASE", "DATABASES", "DAY_HOUR", "DAY_MICROSECOND", "DAY_MINUTE", "DAY_SECOND", "DEC", "DECIMAL", "DECLARE", "DEFAULT", "DELAYED", "DELETE", "DESC", "DESCRIBE", "DETERMINISTIC", "DISTINCT", "DISTINCTROW", "DIV", "DOUBLE", "DROP", "DUAL", "EACH", "ELSE", "ELSEIF", "ENCLOSED", "ESCAPED", "EXISTS", "EXIT", "EXPLAIN", "FALSE", "FETCH", "FIELDS", "FLOAT", "FLOAT4", "FLOAT8", "FOR", "FORCE", "FOREIGN", "FOUND", "FRAC_SECOND", "FROM", "FULLTEXT", "GENERAL", "GRANT", "GROUP", "HAVING", "HIGH_PRIORITY", "HOUR_MICROSECOND", "HOUR_MINUTE", "UR_SECOND", "IF", "IGNORE", "IGNORE_SERVER_IDS", "IN", "INDEX", "INFILE", "INNER", "INNODB", "INOUT", "INSENSITIVE", "INSERT", "INT", "INT1", "INT2", "INT3", "INT4", "INT8", "INTEGER", "INTERVAL", "INTO", "IO_THREAD", "IS", "ITERATE", "JOIN", "KEY", "KEYS", "KILL", "LEADING", "LEAVE", "LEFT", "LIKE", "LIMIT", "LINEAR", "LINES", "LOAD", "LOCALTIME", "LOCALTIMESTAMP", "LOCK", "LONG", "LONGBLOB", "LONGTEXT", "LOOP", "LOW_PRIORITY", "MASTER_HEARTBEAT_PERIOD", "MASTER_SERVER_ID", "MASTER_SSL_VERIFY_SERVER_CERT", "MATCH", "MAXVALUE", "MEDIUMBLOB", "MEDIUMINT", "MEDIUMTEXT", "MIDDLEINT", "MINUTE_MICROSECOND", "MINUTE_SECOND", "MOD", "MODIFIES", "NATURAL", "NOT", "NO_WRITE_TO_BINLOG", "NULL", "NUMERIC", "ON", "OPTIMIZE", "OPTION", "OPTIONALLY", "OR", "ORDER", "OUT", "OUTER", "OUTFILE", "PRECISION", "PRIMARY", "PRIVILEGES", "PROCEDURE", "PURGE", "RANGE", "READ", "READS", "READ_WRITE", "REAL", "REFERENCES", "REGEXP", "RELEASE", "RENAME", "REPEAT", "REPLACE", "REQUIRE", "RESIGNAL", "RESTRICT", "RETURN", "REVOKE", "RIGHT", "RLIKE", "SCHEMA", "SCHEMAS", "SECOND_MICROSECOND", "SELECT", "SENSITIVE", "SEPARATOR", "SET", "SHOW", "SIGNAL", "SLOW", "SMALLINT", "SOME", "SONAME", "SPATIAL", "SPECIFIC", "SQL", "SQLEXCEPTION", "SQLSTATE", "SQLWARNING", "SQL_BIG_RESULT", "SQL_CALC_FOUND_ROWS", "SQL_SMALL_RESULT", "SQL_TSI_DAY", "SQL_TSI_FRAC_SECOND", "SQL_TSI_HOUR", "SQL_TSI_MINUTE", "SQL_TSI_MONTH", "SQL_TSI_QUARTER", "SQL_TSI_SECOND", "SQL_TSI_WEEK", "SQL_TSI_YEAR", "SSL", "STARTING", "STRAIGHT_JOIN", "STRIPED", "TABLE", "TABLES", "TERMINATED", "THEN", "TIMESTAMPADD", "TIMESTAMPDIFF", "TINYBLOB", "TINYINT", "TINYTEXT", "TO", "TRAILING", "TRIGGER", "TRUE", "UNDO", "UNION", "UNIQUE", "UNLOCK", "UNSIGNED", "UPDATE", "USAGE", "USE", "USER_RESOURCES", "USING", "UTC_DATE", "UTC_TIME", "UTC_TIMESTAMP", "VALUES", "VARBINARY", "VARCHAR", "VARCHARACTER", "VARYING", "WHEN", "WHERE", "WHILE", "WITH", "WRITE", "XOR", "YEAR_MONTH", "ZEROFILL" };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  72 */   public static String[] DomaineMYSQL = { "Auto_increment", "Varchar", "Char", "Bool", "Date", "Int", "Float", "Money", "BigInt", "Blob", "Datetime", "Decimal", "Double", "Double Precision", "Enum", "Longblob", "Longtext", "Mediumblob", "Mediumint", "Mediumtext", "Numeric", "Real", "Set", "Smallint", "Text", "Time", "TimeStamp", "TinyBlob", "TinyINT", "TinyText", "Year", "Integer" };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  77 */   public static String[] DomaineDefini = DomaineMYSQL;
/*  78 */   public static String[] KeyTab = KeyMySql;
/*     */   
/*     */   public static ArrayList<Domaine> listeDimaine;
/*     */   
/*  82 */   public static String version = "0.5";
/*     */   
/*  84 */   public static String Cle = "PRIMARY KEY";
/*  85 */   public static String Index = "INDEX";
/*  86 */   public static String Unique = "UNIQUE";
/*  87 */   public static String CleAlternative = "ALTERNATIVE KEY";
/*  88 */   public static String CleEtr = "FOREING KEY";
/*     */   
/*     */ 
/*  91 */   public static String etatDefautColor = "DEFAUT";
/*  92 */   public static String etatAUCUNEColor = "AUCUNE";
/*  93 */   public static String etatAVECColor = "AVEC";
/*     */   
/*  95 */   public static String etatColor1 = "AUCUNE";
/*     */   
/*     */   public static Color clEntiteCadre1;
/*     */   
/*     */   public static Color clEntiteFond1;
/*     */   
/*     */   public static Color clEntiteText1;
/*     */   
/*     */   public static Color clRelationCadre1;
/*     */   
/*     */   public static Color clRelationFond1;
/*     */   
/*     */   public static Color clRelationText1;
/*     */   
/*     */   public static Color clCIFCadre1;
/*     */   
/*     */   public static Color clCIFFond1;
/*     */   
/*     */   public static Color clCIFText1;
/*     */   
/*     */   public static Color clContrainteCadre1;
/*     */   
/*     */   public static Color clContrainteFond1;
/*     */   public static Color clContrainteText1;
/*     */   public static Color clLien1;
/*     */   public static Color clLienCnt1;
/*     */   public static Color clString1;
/*     */   public static double xcassure;
/* 123 */   public static Font fontGras = new Font("Arial", 1, 12);
/* 124 */   public static Font fontNormal = new Font("Arial", 0, 12);
/* 125 */   public static Font fontItalic12 = new Font("Arial", 2, 12);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 132 */   public static Font fontGras14 = new Font("Arial", 1, 14);
/* 133 */   public static Font fontDefaut = new Font("Arial", 0, 12);
/*     */   
/*     */ 
/*     */ 
/* 137 */   public static Font fontGras12 = new Font("Arial", 1, 12);
/* 138 */   public static Font fontNormal12 = new Font("Arial", 0, 12);
/*     */   
/*     */ 
/* 141 */   public static Font fontGras10 = new Font("Arial", 1, 10);
/* 142 */   public static Font fontNormal10 = new Font("Arial", 0, 10);
/*     */   
/* 144 */   public static Font fontGras8 = new Font("Arial", 1, 8);
/* 145 */   public static Font fontNormal8 = new Font("Arial", 0, 8);
/*     */   
/*     */ 
/* 148 */   public static Font fontGras6 = new Font("Arial", 1, 6);
/* 149 */   public static Font fontNormal6 = new Font("Arial", 0, 6);
/*     */   
/* 151 */   public static Font fontGras4 = new Font("Arial", 1, 4);
/* 152 */   public static Font fontNormal4 = new Font("Arial", 0, 4);
/*     */   
/*     */   private static Font fontNormalNew;
/*     */   
/*     */   private static Font fontGrasNew;
/* 157 */   public static double prZoom = 1.0D;
/* 158 */   public static int zoomMax = 12; public static int zoomMin = 4; public static int zoom = 12;
/*     */   
/*     */ 
/* 161 */   public static boolean firstExec = false;
/*     */   
/*     */ 
/* 164 */   public static Date dateExec = getDateExecution();
/*     */   
/*     */   public static Image imageCle;
/*     */   public static Image imageCleEtr;
/*     */   public static Image imageClePrimaireEtr;
/*     */   public static Image imageCleUnique;
/*     */   public static Image imageCleIndex;
/*     */   public static Image imageCleEtrAlter;
/*     */   public static Image mcdDefaut;
/*     */   public static Image imaEnt;
/*     */   
/*     */   public static Date getDateExecution()
/*     */   {
/* 177 */     Calendar calendar = Calendar.getInstance();
/* 178 */     calendar.add(10, -10);
/* 179 */     return calendar.getTime();
/*     */   }
/*     */   
/*     */   private static void getNewFont(String zoom) {
/* 183 */     if (zoom.equals("PLUS")) {
/* 184 */       if (fontNormal.equals(fontNormal12)) {
/* 185 */         fontGrasNew = fontGras12;
/* 186 */         fontNormalNew = fontNormal12;
/*     */       }
/*     */       
/* 189 */       if (fontNormal.equals(fontNormal10)) {
/* 190 */         fontGrasNew = fontGras12;
/* 191 */         fontNormalNew = fontNormal12;
/*     */       }
/*     */       
/* 194 */       if (fontNormal.equals(fontNormal8)) {
/* 195 */         fontGrasNew = fontGras10;
/* 196 */         fontNormalNew = fontNormal10;
/*     */       }
/*     */       
/* 199 */       if (fontNormal.equals(fontNormal6)) {
/* 200 */         fontGrasNew = fontGras8;
/* 201 */         fontNormalNew = fontNormal8;
/*     */       }
/*     */       
/* 204 */       if (fontNormal.equals(fontNormal4)) {
/* 205 */         fontGrasNew = fontGras6;
/* 206 */         fontNormalNew = fontNormal6;
/*     */       }
/*     */     }
/* 209 */     if (zoom.equals("MOINS")) {
/* 210 */       if (fontNormal.equals(fontNormal12)) {
/* 211 */         fontGrasNew = fontGras10;
/* 212 */         fontNormalNew = fontNormal10;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 219 */       if (fontNormal.equals(fontNormal10)) {
/* 220 */         fontGrasNew = fontGras8;
/* 221 */         fontNormalNew = fontNormal8;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 228 */       if (fontNormal.equals(fontNormal8)) {
/* 229 */         fontGrasNew = fontGras6;
/* 230 */         fontNormalNew = fontNormal6;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 237 */       if (fontNormal.equals(fontNormal6)) {
/* 238 */         fontGrasNew = fontGras4;
/* 239 */         fontNormalNew = fontNormal4;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 245 */       if (fontNormal.equals(fontNormal4)) {
/* 246 */         fontGrasNew = fontGras4;
/* 247 */         fontNormalNew = fontNormal4;
/*     */       }
/*     */     }
/*     */     
/* 251 */     if (zoom.equals("DEFAUT")) {
/* 252 */       fontGrasNew = fontGras12;
/* 253 */       fontNormalNew = fontNormal12;
/*     */     }
/*     */   }
/*     */   
/*     */   public static double getPourcentageZoom(Graphics g, String zoom) {
/* 258 */     getNewFont(zoom);
/* 259 */     String adam = "  MESSOUCI  ADAM  ";
/* 260 */     g.setFont(fontGras);
/* 261 */     int w2 = g.getFontMetrics().stringWidth(adam);
/* 262 */     g.setFont(fontGrasNew);
/* 263 */     int w1 = g.getFontMetrics().stringWidth(adam);
/* 264 */     g.setFont(fontNormal);
/* 265 */     prZoom = w1 / w2;
/* 266 */     return w1 / w2;
/*     */   }
/*     */   
/*     */   public static double getPourcentageZoomReel(Graphics g, Font font12, Font fontR) {
/* 270 */     String adam = "  MESSOUCI  ADAM  ";
/* 271 */     g.setFont(fontR);
/* 272 */     int w2 = g.getFontMetrics().stringWidth(adam);
/* 273 */     g.setFont(font12);
/* 274 */     int w1 = g.getFontMetrics().stringWidth(adam);
/* 275 */     return w1 / w2;
/*     */   }
/*     */   
/*     */   public static double getPrZoomAct(Graphics g) {
/* 279 */     Font f = g.getFont();
/* 280 */     String adam = "MESSOUCI  ADAM";
/* 281 */     int w2 = g.getFontMetrics().stringWidth(adam);
/* 282 */     g.setFont(fontNormal12);
/* 283 */     int w1 = g.getFontMetrics().stringWidth(adam);
/* 284 */     g.setFont(f);
/* 285 */     w2 = (int)(w2 / w1 * 10.0D);
/* 286 */     return w2 / 10.0D;
/*     */   }
/*     */   
/*     */   public static String corrigerChemin(String s) {
/* 290 */     s = s.replace("%20", " ");
/* 291 */     s = s.replace("%c3%a9", "é");
/* 292 */     s = s.replace("%c3%a8", "è");
/* 293 */     s = s.replace("%c3%aa", "ê");
/* 294 */     s = s.replace("%c3%a0", "à");
/* 295 */     s = s.replace("%c3%a2", "â");
/* 296 */     s = s.replace("%c3%ae", "î");
/* 297 */     s = s.replace("%c3%af", "ï");
/* 298 */     s = s.replace("%c3%a7", "ç");
/* 299 */     s = s.replace("%c3%87", "Ç");
/* 300 */     return s;
/*     */   }
/*     */   
/*     */   public static void setNewFont() {
/* 304 */     fontGras = fontGrasNew;
/* 305 */     fontNormal = fontNormalNew;
/*     */   }
/*     */   
/*     */   public static boolean isMotReserve(String mot)
/*     */   {
/* 310 */     if (!Setting.SQLVerifierMotReserver2) return false;
/* 311 */     for (int i = 0; i < KeyTab.length; i++) {
/* 312 */       if (KeyTab[i].trim().toUpperCase().equals(mot.trim().toUpperCase())) return true;
/*     */     }
/* 314 */     return false;
/*     */   }
/*     */   
/*     */   public static void exporteImage_(IhmPageMCD page, String filename) {
/* 318 */     File file = new File(filename);
/* 319 */     BufferedImage tamponSauvegarde = new BufferedImage(page.getWidth(), page.getHeight(), 1);
/*     */     
/* 321 */     Graphics2D g2 = tamponSauvegarde.createGraphics();
/* 322 */     page.paint(g2);
/*     */     try {
/* 324 */       ImageIO.write(tamponSauvegarde, "PNG", file);
/*     */     } catch (IOException e) {
/* 326 */       JOptionPane.showMessageDialog(null, "Création du fichier impossible", null, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void exporteImageMLD_(IhmPageMLD page, String filename) {
/* 331 */     File file = new File(filename);
/* 332 */     BufferedImage tamponSauvegarde = new BufferedImage(page.getWidth(), page.getHeight(), 1);
/*     */     
/* 334 */     Graphics2D g2 = tamponSauvegarde.createGraphics();
/* 335 */     page.paint(g2);
/*     */     try {
/* 337 */       ImageIO.write(tamponSauvegarde, "PNG", file);
/*     */     } catch (IOException e) {
/* 339 */       JOptionPane.showMessageDialog(null, "Création du fichier impossible", null, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public static BufferedImage pageToImage(IhmPageMCD page) {
/* 344 */     BufferedImage tamponSauvegarde = new BufferedImage(page.getWidth(), page.getHeight(), 1);
/*     */     
/* 346 */     Graphics2D g2 = tamponSauvegarde.createGraphics();
/* 347 */     page.paint(g2);
/* 348 */     return tamponSauvegarde;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void exporteImage(Principale frm, IhmPageMCD mcdComponent, String fileName, int nb)
/*     */   {
/*     */     try
/*     */     {
/* 362 */       File imageFile = new File(fileName);
/*     */       
/* 364 */       int w = mcdComponent.getWidth();
/* 365 */       int h = mcdComponent.getHeight();
/* 366 */       if ((!Principale.isActiverJMerise()) && (
/* 367 */         (w > 1000) || (h > 1000))) {
/* 368 */         if (w > 1000) w = 1000;
/* 369 */         if (h > 1000) h = 1000;
/* 370 */         JOptionPane.showMessageDialog(frm, "Il faut activer cette version pour exporter l'image complète ! ");
/*     */       }
/*     */       
/* 373 */       BufferedImage img = new BufferedImage(w, h, 1);
/*     */       
/*     */ 
/*     */ 
/* 377 */       Graphics g = img.getGraphics();
/* 378 */       Graphics2D g2d = (Graphics2D)g;
/*     */       
/* 380 */       g2d.setColor(Color.ORANGE);
/* 381 */       Rectangle2D r = new Rectangle2D.Double(0.0D, 0.0D, w, h);
/* 382 */       g2d.fill(r);
/*     */       
/* 384 */       mcdComponent.paint(g2d);
/*     */       
/* 386 */       PNGImageWriter writer = new PNGImageWriter(null);
/*     */       FileImageOutputStream outputStream;
/* 388 */       writer.setOutput(outputStream = new FileImageOutputStream(imageFile));
/* 389 */       writer.write(img);
/*     */       
/* 391 */       outputStream.close();
/*     */       
/* 393 */       writer.dispose();
/*     */     }
/*     */     catch (IOException err) {
/* 396 */       exporteImage_(mcdComponent, fileName);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void exporteImageMLD(Principale frm, IhmPageMLD mcdComponent, String fileName, int nb)
/*     */   {
/*     */     try
/*     */     {
/* 409 */       File imageFile = new File(fileName);
/*     */       
/* 411 */       int w = mcdComponent.getWidth();
/* 412 */       int h = mcdComponent.getHeight();
/*     */       
/* 414 */       if ((!Principale.isActiverJMerise()) && (
/* 415 */         (w > 1000) || (h > 1000))) {
/* 416 */         if (w > 1000) w = 1000;
/* 417 */         if (h > 1000) h = 1000;
/* 418 */         JOptionPane.showMessageDialog(frm, "Il faut activer cette version pour exporter l'image complète ! ");
/*     */       }
/*     */       
/*     */ 
/* 422 */       BufferedImage img = new BufferedImage(w, h, 1);
/*     */       
/* 424 */       Graphics g = img.getGraphics();
/* 425 */       Graphics2D g2d = (Graphics2D)g;
/*     */       
/* 427 */       g2d.setColor(Color.ORANGE);
/* 428 */       Rectangle2D r = new Rectangle2D.Double(0.0D, 0.0D, w, h);
/* 429 */       g2d.fill(r);
/*     */       
/* 431 */       mcdComponent.paint(g2d);
/*     */       
/* 433 */       PNGImageWriter writer = new PNGImageWriter(null);
/*     */       FileImageOutputStream outputStream;
/* 435 */       writer.setOutput(outputStream = new FileImageOutputStream(imageFile));
/* 436 */       writer.write(img);
/*     */       
/* 438 */       outputStream.close();
/*     */       
/* 440 */       writer.dispose();
/*     */     }
/*     */     catch (IOException err) {
/* 443 */       exporteImageMLD_(mcdComponent, fileName);
/*     */     }
/*     */   }
/*     */   
/*     */   public static BufferedImage pageToImage(IhmPageMLD page)
/*     */   {
/* 449 */     BufferedImage tamponSauvegarde = new BufferedImage(page.getWidth(), page.getHeight(), 1);
/*     */     
/* 451 */     Graphics2D g2 = tamponSauvegarde.createGraphics();
/* 452 */     page.paint(g2);
/* 453 */     return tamponSauvegarde;
/*     */   }
/*     */   
/*     */   public static Color couleurs(String cl) {
/* 457 */     return new Color(Integer.parseInt(cl));
/*     */   }
/*     */   
/*     */ 
/*     */   private static void saveBlabla(FormeParametre p)
/*     */   {
/* 463 */     p.setCommentaire1("24");
/* 464 */     p.setCommentaire10("32");
/* 465 */     p.setCommentaire2("1110001");
/* 466 */     p.setCommentaire3("123342");
/* 467 */     p.setCommentaire4("AZECEC34D-ZEaz-QDQsd-SDF");
/* 468 */     p.setCommentaire5("zgte000546");
/* 469 */     p.setCommentaire6("dsfçsdf0000-sdf");
/* 470 */     p.setCommentaire7("sxcxvcbgdr-ert-ertert-ertertert-er12");
/* 471 */     p.setCommentaire8("nngtezer-zerzengfjd-66734-ZERr-");
/* 472 */     p.setCommentaire9("567HHHYR-ZTRU-ZER-rrrr-zer-098");
/*     */   }
/*     */   
/*     */   public static boolean saveFormePara(String nomfile, FormeParametre p) {
/* 476 */     File file = new File(nomfile);
/* 477 */     saveBlabla(p);
/*     */     try {
/* 479 */       PrintStream out = new PrintStream(new java.util.zip.GZIPOutputStream(new FileOutputStream(file)));
/* 480 */       out.println("<NOTE>");
/* 481 */       out.println("Toutes modifications de ce fichier entrainent un dysfonctionnement de JMerise");
/* 482 */       out.println("Vous serez le seul responsable des désagréments occasionnés");
/* 483 */       out.println("</NOTE>");
/* 484 */       out.println("<ABOUT>");
/* 485 */       out.println("<NAME> JMerise");
/* 486 */       out.println("</NAME>");
/*     */       
/* 488 */       out.println("<OWNER> MESSOUCI");
/* 489 */       out.println("</OWNER>");
/* 490 */       out.println("<VERSION>" + p.getVersion());
/* 491 */       out.println("</VERSION>");
/*     */       
/* 493 */       out.println("<CREATION> 08/11/2011");
/* 494 */       out.println("</CREATION>");
/*     */       
/* 496 */       out.println("<MODIF> 08/05/2013");
/* 497 */       out.println("</MODIF>");
/*     */       
/* 499 */       out.println("</ABOUT>");
/*     */       
/* 501 */       out.println("<PARAM>");
/* 502 */       out.println("<P1>");
/* 503 */       out.println(p.getAch_hal_ikhadamen());
/* 504 */       out.println("</P1>");
/*     */       
/* 506 */       out.println("<P2>");
/* 507 */       out.println(p.getAchehal_wussan());
/* 508 */       out.println("</P2>");
/*     */       
/* 510 */       out.println("<P3>");
/* 511 */       out.println(p.getAss_i_active());
/* 512 */       out.println("</P3>");
/*     */       
/* 514 */       out.println("<P4>");
/* 515 */       out.println(p.getAss_ifuk());
/* 516 */       out.println("</P4>");
/*     */       
/* 518 */       out.println("<P5>");
/* 519 */       out.println(p.getAss_ivdha());
/* 520 */       out.println("</P5>");
/*     */       
/* 522 */       out.println("<P6>");
/* 523 */       out.println(p.getAss_ukhadim());
/* 524 */       out.println("</P6>");
/*     */       
/* 526 */       out.println("<P7>");
/* 527 */       out.println(p.getCommentaire1());
/* 528 */       out.println("</P7>");
/*     */       
/* 530 */       out.println("<P8>");
/* 531 */       out.println(p.getCommentaire10());
/* 532 */       out.println("</P8>");
/*     */       
/* 534 */       out.println("<P9>");
/* 535 */       out.println(p.getCommentaire2());
/* 536 */       out.println("</P9>");
/*     */       
/* 538 */       out.println("<P10>");
/* 539 */       out.println(p.getCommentaire3());
/* 540 */       out.println("</P10>");
/*     */       
/* 542 */       out.println("<P11>");
/* 543 */       out.println(p.getCommentaire4());
/* 544 */       out.println("</P11>");
/*     */       
/* 546 */       out.println("<P12>");
/* 547 */       out.println(p.getCommentaire5());
/* 548 */       out.println("</P12>");
/*     */       
/* 550 */       out.println("<P13>");
/* 551 */       out.println(p.getCommentaire6());
/* 552 */       out.println("</P13>");
/*     */       
/* 554 */       out.println("<P14>");
/* 555 */       out.println(p.getCommentaire7());
/* 556 */       out.println("</P14>");
/*     */       
/* 558 */       out.println("<P15>");
/* 559 */       out.println(p.getCommentaire8());
/* 560 */       out.println("</P15>");
/*     */       
/* 562 */       out.println("<P16>");
/* 563 */       out.println(p.getCommentaire9());
/* 564 */       out.println("</P16>");
/*     */       
/* 566 */       out.println("<P17>");
/* 567 */       out.println(p.getThassarouts());
/* 568 */       out.println("</P17>");
/*     */       
/* 570 */       out.println("<P18>");
/* 571 */       out.println(p.getVavis());
/* 572 */       out.println("</P18>");
/*     */       
/* 574 */       out.println("</PARAM>");
/* 575 */       out.flush();
/* 576 */       out.close();
/* 577 */       return true;
/*     */     } catch (IOException e) {}
/* 579 */     return false;
/*     */   }
/*     */   
/*     */   public static FormeParametre openFormePara(String nomfile)
/*     */   {
/* 584 */     File file = new File(nomfile);
/* 585 */     FormeParametre para = null;
/*     */     try {
/* 587 */       BufferedReader in = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(file))));
/* 588 */       String st = "";String s = "";
/* 589 */       para = new FormeParametre();
/* 590 */       while ((s = in.readLine()) != null) {
/* 591 */         st = st + s;
/*     */       }
/* 593 */       if (st.trim().length() > 0) {
/* 594 */         para = chargerParam(st);
/*     */       }
/* 596 */       in.close();
/* 597 */       return para;
/*     */     } catch (IOException e) {}
/* 599 */     return para;
/*     */   }
/*     */   
/*     */   private static FormeParametre chargerParam(String st)
/*     */   {
/* 604 */     FormeParametre p = new FormeParametre();
/* 605 */     p.setAch_hal_ikhadamen(st.substring(st.indexOf("<P1>") + 4, st.indexOf("</P1>")));
/*     */     
/* 607 */     p.setAchehal_wussan(st.substring(st.indexOf("<P2>") + 4, st.indexOf("</P2>")));
/* 608 */     p.setAss_i_active(st.substring(st.indexOf("<P3>") + 4, st.indexOf("</P3>")));
/* 609 */     p.setAss_ifuk(st.substring(st.indexOf("<P4>") + 4, st.indexOf("</P4>")));
/* 610 */     p.setAss_ivdha(st.substring(st.indexOf("<P5>") + 4, st.indexOf("</P5>")));
/* 611 */     p.setAss_ukhadim(st.substring(st.indexOf("<P6>") + 4, st.indexOf("</P6>")));
/* 612 */     p.setCommentaire1(st.substring(st.indexOf("<P7>") + 4, st.indexOf("</P7>")));
/* 613 */     p.setCommentaire10(st.substring(st.indexOf("<P8>") + 4, st.indexOf("</P8>")));
/* 614 */     p.setCommentaire2(st.substring(st.indexOf("<P9>") + 4, st.indexOf("</P9>")));
/* 615 */     p.setCommentaire3(st.substring(st.indexOf("<P10>") + 5, st.indexOf("</P10>")));
/* 616 */     p.setCommentaire4(st.substring(st.indexOf("<P11>") + 5, st.indexOf("</P11>")));
/* 617 */     p.setCommentaire5(st.substring(st.indexOf("<P12>") + 5, st.indexOf("</P12>")));
/* 618 */     p.setCommentaire6(st.substring(st.indexOf("<P13>") + 5, st.indexOf("</P13>")));
/* 619 */     p.setCommentaire7(st.substring(st.indexOf("<P14>") + 5, st.indexOf("</P14>")));
/* 620 */     p.setCommentaire8(st.substring(st.indexOf("<P15>") + 5, st.indexOf("</P15>")));
/* 621 */     p.setCommentaire9(st.substring(st.indexOf("<P16>") + 5, st.indexOf("</P16>")));
/* 622 */     p.setThassarouts(st.substring(st.indexOf("<P17>") + 5, st.indexOf("</P17>")));
/* 623 */     p.setVavis(st.substring(st.indexOf("<P18>") + 5, st.indexOf("</P18>")));
/* 624 */     p.setVersion(st.substring(st.indexOf("<VERSION>") + 4, st.indexOf("</VERSION>")));
/*     */     
/* 626 */     return p;
/*     */   }
/*     */   
/*     */   public static int nombreDeJour(Date d1, Date d2) {
/* 630 */     long MILLISECONDS_PER_DAY = 86400000L;
/* 631 */     long delta = d1.getTime() - d2.getTime();
/* 632 */     return (int)(delta / 86400000L);
/*     */   }
/*     */   
/*     */   private static boolean controleCle(Date d1, Date d2, int numjour, String cle) {
/* 636 */     int nb = nombreDeJour(d1, d2);
/* 637 */     if (nb % numjour == Integer.parseInt(cle)) {
/* 638 */       return true;
/*     */     }
/* 640 */     if (firstExec) {
/* 641 */       if ((nb - 1) % numjour == Integer.parseInt(cle)) return true;
/* 642 */       if ((nb + 1) % numjour == Integer.parseInt(cle)) return true;
/*     */     }
/* 644 */     return false;
/*     */   }
/*     */   
/*     */   private static String calculeCle(Date d1, Date d2, int numjour) {
/* 648 */     int nb = nombreDeJour(d1, d2);
/*     */     
/* 650 */     return "" + nb % numjour;
/*     */   }
/*     */   
/*     */   public static boolean verificationErreur(Splash frm, FormeParametre pF, String nomFic, Principale principale) {
/*     */     try {
/* 655 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
/* 656 */       SimpleDateFormat sdfancaise = new SimpleDateFormat("dd/MM/yyyy");
/* 657 */       SimpleDateFormat fjour = new SimpleDateFormat("dd");
/* 658 */       Date now = new Date();
/* 659 */       now = new Date(sdf.format(now));
/* 660 */       int numJour = Integer.parseInt(fjour.format(now));
/* 661 */       Setting.dateFin = pF.getAss_ifuk();
/* 662 */       Date dValidite = new Date(pF.getAss_ifuk());
/* 663 */       Date dDerUse = new Date(pF.getAss_ukhadim());
/*     */       
/* 665 */       int numJDUse = Integer.parseInt(fjour.format(dDerUse));
/* 666 */       if (nombreDeJour(dValidite, now) < 10) {
/* 667 */         if (nombreDeJour(now, dValidite) >= 0) {
/* 668 */           JOptionPane.showMessageDialog(frm, "Date de validité de JMerise est expirée, Veuillez télécharger une nouvelle version \nsur le site www.jfreesoft.com");
/* 669 */           pF.setAss_ukhadim(sdf.format(now));
/* 670 */           pF.setAchehal_wussan(calculeCle(dValidite, now, numJour));
/*     */           
/*     */ 
/* 673 */           principale.getSetting().enregistrerParametre(principale, nomFic, pF, principale.getSetting());
/* 674 */           frm.setDefaultCloseOperation(3);
/* 675 */           frm.dispose();
/* 676 */           return false;
/*     */         }
/* 678 */         if (pF.getThassarouts().indexOf("-EELD-") < 0) {
/* 679 */           JOptionPane.showMessageDialog(frm, "ERREUR : Problème N°7. Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/* 680 */           pF.setThassarouts("TRFFG-EE-EELDC56-ER743");
/* 681 */           pF.setAss_ukhadim(sdf.format(now));
/* 682 */           pF.setAchehal_wussan(calculeCle(dValidite, now, numJour));
/*     */           
/* 684 */           principale.getSetting().enregistrerParametre(principale, nomFic, pF, principale.getSetting());
/*     */           
/* 686 */           frm.setDefaultCloseOperation(3);
/* 687 */           frm.dispose();
/* 688 */           return false;
/*     */         }
/* 690 */         JOptionPane.showMessageDialog(frm, "Date de validité de JMerise expirera le :" + sdfancaise.format(dValidite) + ",\nPensez à télécharger une nouvelle version ");
/* 691 */         pF.setThassarouts("TRFFG-EE-EELDC56-ER743");
/* 692 */         pF.setAss_ukhadim(sdf.format(now));
/* 693 */         pF.setAchehal_wussan(calculeCle(dValidite, now, numJour));
/*     */         
/* 695 */         principale.getSetting().enregistrerParametre(principale, nomFic, pF, principale.getSetting());
/* 696 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 701 */       if (!controleCle(dValidite, dDerUse, numJDUse, pF.getAchehal_wussan())) {
/* 702 */         JOptionPane.showMessageDialog(frm, "ERREUR : Problème N°1. Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/* 703 */         pF.setThassarouts("TRFFG-EE-EELDC56-ER743");
/* 704 */         pF.setAss_ukhadim(sdf.format(now));
/* 705 */         pF.setAchehal_wussan(calculeCle(dValidite, now, numJour));
/*     */         
/* 707 */         principale.getSetting().enregistrerParametre(principale, nomFic, pF, principale.getSetting());
/* 708 */         frm.setDefaultCloseOperation(3);
/* 709 */         frm.dispose();
/* 710 */         return false;
/*     */       }
/*     */       
/* 713 */       if (nombreDeJour(now, dDerUse) < 0) {
/* 714 */         JOptionPane.showMessageDialog(frm, "ERREUR : Problème N°2. Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/* 715 */         pF.setThassarouts("TRFFG-EE-EELDC56-ER743");
/* 716 */         pF.setAss_ukhadim(sdf.format(now));
/* 717 */         pF.setAchehal_wussan(calculeCle(dValidite, now, numJour));
/*     */         
/* 719 */         principale.getSetting().enregistrerParametre(principale, nomFic, pF, principale.getSetting());
/* 720 */         frm.setDefaultCloseOperation(3);
/* 721 */         frm.dispose();
/* 722 */         return false;
/*     */       }
/* 724 */       if (pF.getThassarouts().indexOf("-EELD-") < 0) {
/* 725 */         JOptionPane.showMessageDialog(frm, "ERREUR : Problème N°3. Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/* 726 */         pF.setThassarouts("TRFFG-EE-EELDC56-ER743");
/* 727 */         pF.setAss_ukhadim(sdf.format(now));
/* 728 */         pF.setAchehal_wussan(calculeCle(dValidite, now, numJour));
/*     */         
/*     */ 
/* 731 */         principale.getSetting().enregistrerParametre(principale, nomFic, pF, principale.getSetting());
/* 732 */         frm.setDefaultCloseOperation(3);
/* 733 */         frm.dispose();
/* 734 */         return false;
/*     */       }
/* 736 */       pF.setThassarouts("TRFFG-EELD-EELDC56-ER743");
/* 737 */       pF.setAss_ukhadim(sdf.format(now));
/* 738 */       pF.setAchehal_wussan(calculeCle(dValidite, now, numJour));
/*     */       
/* 740 */       principale.getSetting().enregistrerParametre(principale, nomFic, pF, principale.getSetting());
/* 741 */       return true;
/*     */     } catch (Exception e) {}
/* 743 */     return false;
/*     */   }
/*     */   
/*     */   public static void isValide(Splash frm, Principale principale, String ch)
/*     */   {
/* 748 */     frm.getProgressBar().setValue(65);
/*     */     try {
/* 750 */       Thread.sleep(100L);
/*     */     }
/*     */     catch (InterruptedException e) {}
/* 753 */     principale.setpF(SaveSetting.getFormeParametre(principale.getSetting()));
/* 754 */     frm.getProgressBar().setValue(70);
/*     */     try {
/* 756 */       Thread.sleep(400L);
/*     */     } catch (InterruptedException e) {}
/* 758 */     if (principale.getpF() == null) {
/* 759 */       JOptionPane.showMessageDialog(frm, "ERREUR : Problème N°5.Verifier l'existence du fichier FormPara.clas dans le repertoire 'lib'\n Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/* 760 */       frm.setDefaultCloseOperation(3);
/* 761 */       frm.dispose();
/* 762 */       System.exit(0);
/* 763 */       return;
/*     */     }
/* 765 */     if (!verificationErreur(frm, principale.getpF(), ch, principale)) {
/* 766 */       JOptionPane.showMessageDialog(frm, "ERREUR : Problème N°6. Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/* 767 */       frm.setDefaultCloseOperation(3);
/* 768 */       frm.dispose();
/* 769 */       System.exit(0);
/* 770 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   public static void imprimerMCD(Principale frm, IhmPageMCD page) throws Exception {
/* 775 */     Properties props = new Properties();
/* 776 */     props.setProperty("awt.print.paperSize", "a4");
/* 777 */     props.setProperty("awt.print.destination", "printer");
/* 778 */     String cheminLib = frm.getCheminParametre();
/* 779 */     int ind = cheminLib.indexOf(File.separator + "lib" + File.separator);
/* 780 */     cheminLib = cheminLib.substring(0, ind + 5) + "MRTemp1503.png";
/* 781 */     JOptionPane.showConfirmDialog(frm, "chemin :" + cheminLib);
/* 782 */     exporteImage(frm, page, cheminLib, 0);
/* 783 */     PanelImpression pan = PanelImpression.getPanelImpression(cheminLib);
/* 784 */     PrintJob demandeDImpression = pan.getToolkit().getPrintJob(frm, "Impression", props);
/*     */     
/* 786 */     if (demandeDImpression != null) {
/* 787 */       Graphics gImpr = demandeDImpression.getGraphics();
/* 788 */       pan.printAll(gImpr);
/* 789 */       gImpr.dispose();
/* 790 */       demandeDImpression.end();
/*     */     }
/*     */   }
/*     */   
/*     */   private static String passewC(String s) {
/* 795 */     String ss = s;
/* 796 */     ArrayList<String> l = new ArrayList();
/* 797 */     l.add("a");
/* 798 */     return ss;
/*     */   }
/*     */   
/*     */   public static String passeW(String s) {
/* 802 */     String ss = s;
/* 803 */     ArrayList<String> l = new ArrayList();
/* 804 */     l.add("a");
/* 805 */     return ss;
/*     */   }
/*     */   
/*     */   public static int retournerVal(Graphics g, int n) {
/* 809 */     double d = getPrZoomAct(g);
/* 810 */     d *= n;
/* 811 */     return (int)d;
/*     */   }
/*     */   
/*     */   public static String getMac() {
/* 815 */     String s = "";
/*     */     
/*     */     try
/*     */     {
/* 819 */       InetAddress address = InetAddress.getLocalHost();
/*     */       try
/*     */       {
/* 822 */         NetworkInterface ni = NetworkInterface.getByInetAddress(address);
/* 823 */         byte[] mac = ni.getHardwareAddress();
/*     */         
/*     */ 
/* 826 */         for (int i = 0; i < mac.length; i++) {
/* 827 */           s = s + String.format("%02X%s", new Object[] { Byte.valueOf(mac[i]), i < mac.length - 1 ? "-" : "" });
/*     */         }
/*     */         
/* 830 */         if ((ni.isUp()) && (!ni.isLoopback())) {}
/*     */         
/*     */ 
/*     */ 
/* 834 */         return s;
/*     */       } catch (SocketException ex) {
/* 836 */         return s;
/*     */       }
/*     */     } catch (UnknownHostException ex) {}
/*     */
return s;   }
/*     */   
/*     */   public static boolean checkDate(Date date) {
/* 844 */     if (dateExec.compareTo(date) <= 0) return true;
/* 845 */     return false;
/*     */   }
/*     */   
/*     */   public static Properties load(String filename) throws IOException, java.io.FileNotFoundException
/*     */   {
/* 850 */     Properties properties = new Properties();
/* 851 */     FileInputStream input = new FileInputStream(filename);
/*     */     try {
/* 853 */       properties.load(input);
/* 854 */       return properties;
/*     */     }
/*     */     finally {
/* 857 */       input.close();
/*     */     }
/*     */   }
/*     */   
/*     */   public static String getPath(String ch)
/*     */   {
/*     */     try
/*     */     {
/* 865 */       Properties prop = load(ch);
/*     */       
/* 867 */       if (prop.getProperty("TYPE", "").length() == 0) return "";
/* 868 */       return prop.getProperty("PATH", "");
/*     */     }
/*     */     catch (Exception e) {
/* 871 */       e.printStackTrace(); }
/* 872 */     return "";
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean estMCDJMerise(String nomFichier)
/*     */   {
/* 878 */     boolean rep = false;
/*     */     try
/*     */     {
/* 881 */       FileInputStream fichier = new FileInputStream(nomFichier);
/* 882 */       ObjectInputStream ois = new ObjectInputStream(fichier);
/* 883 */       Object ob = ois.readObject();
/* 884 */       if ((ob instanceof ConfigurationMCD2)) {
/* 885 */         rep = true;
/*     */       }
/* 887 */       else if ((ob instanceof ArrayList)) {
/* 888 */         rep = true;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 894 */       ois.close();
/*     */       
/*     */ 
/*     */ 
/* 898 */       return rep;
/*     */     }
/*     */     catch (IOException e) {
/* 901 */       return false;
/*     */     } catch (ClassNotFoundException e) {}
/* 903 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static Font openFont(String name)
/*     */   {
/* 910 */     Font font = null;
/* 911 */     InputStream is = ClassLoader.getSystemResourceAsStream("Images/font/" + name);
/*     */     
/* 913 */     if (is == null) {
/* 914 */       System.err.println("Utilisation de la Fonte impossible : " + name + " ...");
/* 915 */       System.exit(1);
/*     */     }
/*     */     try
/*     */     {
/* 919 */       font = Font.createFont(0, is);
/*     */     } catch (Exception e) {
/* 921 */       System.err.println("Problème lors de la création de la fonte : " + name + " ...");
/*     */       
/* 923 */       System.exit(1);
/*     */     }
/* 925 */     return font;
/*     */   }
/*     */   
/*     */   public static Font getFont(String name, int style, float size) {
/* 929 */     return openFont(name).deriveFont(style, size);
/*     */   }
/*     */   
/*     */   public static boolean existeFichier(String s) {
/* 933 */     File f = new File(s);
/* 934 */     return f.exists();
/*     */   }
/*     */   
/*     */   public static int getStringAnnee(String aa) {
/* 938 */     String[] tab = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
/* 939 */     for (int i = 0; i < tab.length; i++) {
/* 940 */       if (tab[i].toUpperCase().equals(aa)) {
/* 941 */         return 2018 + i;
/*     */       }
/*     */     }
/* 944 */     return 2018;
/*     */   }
/*     */   
/*     */   public static String getAnneeString(String aaaa) {
/* 948 */     String[] tab = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
/* 949 */     int aa = Integer.parseInt(aaaa);
/* 950 */     aa -= 2018;
/* 951 */     return tab[aa];
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Outil\Parametres.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */