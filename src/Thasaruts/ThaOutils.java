/*     */ package Thasaruts;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import ihm.Principale;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.Properties;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ThaOutils
/*     */ {
/*  34 */   static String[] tab = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
/*  35 */   static String version = "05";
/*     */   
/*     */   public static boolean isMailCorrect(String mail) {
/*  38 */     if ((mail == null) || (mail.length() == 0)) return false;
/*  39 */     String m = mail;
/*  40 */     int at = mail.indexOf("@");
/*  41 */     if (at <= 0) return false;
/*  42 */     String np = mail.substring(0, at - 1);
/*  43 */     String site = mail.substring(at + 1, mail.length());
/*  44 */     m = site;
/*  45 */     if (site.indexOf("@") >= 0) return false;
/*  46 */     if (site.indexOf(".") < 0) return false;
/*  47 */     m = site.substring(site.indexOf(".") + 1, site.length());
/*  48 */     if (m.indexOf(".") >= 0) { return false;
/*     */     }
/*  50 */     if (m.indexOf("@") >= 0) { return false;
/*     */     }
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public static String genererDefautCle()
/*     */   {
/*  57 */     String mac1 = Parametres.getMac();
/*  58 */     String n = "" + System.currentTimeMillis();
/*  59 */     n = n.substring(n.length() - 6, n.length());
/*     */     
/*  61 */     if ((mac1 == null) || (mac1.length() == 0)) {
/*  62 */       mac1 = "";
/*     */     } else {
/*  64 */       int nb = mac1.length();
/*  65 */       mac1 = mac1.substring(nb / 2, mac1.length());
/*     */     }
/*     */     
/*  68 */     String n2 = "" + System.currentTimeMillis();
/*  69 */     n = n + n2.substring(n2.length() - 6, n2.length());
/*  70 */     n = n + mac1;
/*  71 */     return "RM" + n;
/*     */   }
/*     */   
/*     */   public static String getNomSessionUser() {
/*  75 */     String dev = System.getProperty("user.name");
/*  76 */     if ((dev == null) || (dev.length() == 0)) {
/*  77 */       dev = "user";
/*     */     }
/*  79 */     return dev;
/*     */   }
/*     */   
/*     */   public static String getDateJour()
/*     */   {
/*  84 */     SimpleDateFormat sdfrancaise = new SimpleDateFormat("dd/MM/yyyy");
/*  85 */     Date now = new Date();
/*  86 */     return sdfrancaise.format(now);
/*     */   }
/*     */   
/*     */   public static int nombreDeJour(Date dG, Date dP) {
/*  90 */     long MILLISECONDS_PER_DAY = 86400000L;
/*  91 */     long delta = dG.getTime() - dP.getTime();
/*  92 */     return (int)(delta / 86400000L);
/*     */   }
/*     */   
/*     */   public static int nombreDeJour(String sdG, String sdP) {
/*  96 */     SimpleDateFormat dateFormatFr = new SimpleDateFormat("dd/MM/yyyy");
/*     */     try {
/*  98 */       Date dG = dateFormatFr.parse(sdG);
/*  99 */       Date dP = dateFormatFr.parse(sdP);
/* 100 */       return nombreDeJour(dG, dP);
/*     */     }
/*     */     catch (ParseException ex) {}
/*     */     
/* 104 */     return 0;
/*     */   }
/*     */   
/*     */   public static int getAnnee(String a)
/*     */   {
/* 109 */     for (int i = 0; i < tab.length; i++) {
/* 110 */       if (a.trim().toUpperCase().equals(tab[i].trim().toUpperCase())) {
/* 111 */         return 2018 + i;
/*     */       }
/*     */     }
/* 114 */     return 2018;
/*     */   }
/*     */   
/*     */   public static int getJJInt(String date) {
/*     */     try {
/* 119 */       SimpleDateFormat sdfrancaise = new SimpleDateFormat("dd/MM/yyyy");
/* 120 */       Date dateD = sdfrancaise.parse(date);
/* 121 */       SimpleDateFormat forma = new SimpleDateFormat("dd");
/* 122 */       return Integer.parseInt(forma.format(dateD));
/*     */     } catch (ParseException ex) {
/* 124 */       Logger.getLogger(ThaOutils.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 126 */     return 0;
/*     */   }
/*     */   
/*     */   public static String getJJString(String date) {
/*     */     try {
/* 131 */       SimpleDateFormat sdfrancaise = new SimpleDateFormat("dd/MM/yyyy");
/* 132 */       Date dateD = sdfrancaise.parse(date);
/* 133 */       SimpleDateFormat forma = new SimpleDateFormat("dd");
/* 134 */       return forma.format(dateD);
/*     */     } catch (ParseException ex) {
/* 136 */       Logger.getLogger(ThaOutils.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 138 */     return "00";
/*     */   }
/*     */   
/*     */   public static int getMMInt(String date) {
/*     */     try {
/* 143 */       SimpleDateFormat sdfrancaise = new SimpleDateFormat("dd/MM/yyyy");
/* 144 */       Date dateD = sdfrancaise.parse(date);
/* 145 */       SimpleDateFormat forma = new SimpleDateFormat("MM");
/* 146 */       return Integer.parseInt(forma.format(dateD));
/*     */     } catch (ParseException ex) {
/* 148 */       Logger.getLogger(ThaOutils.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 150 */     return 0;
/*     */   }
/*     */   
/*     */   public static String getMMString(String date) {
/*     */     try {
/* 155 */       SimpleDateFormat sdfrancaise = new SimpleDateFormat("dd/MM/yyyy");
/* 156 */       Date dateD = sdfrancaise.parse(date);
/* 157 */       SimpleDateFormat forma = new SimpleDateFormat("MM");
/* 158 */       return forma.format(dateD);
/*     */     } catch (ParseException ex) {
/* 160 */       Logger.getLogger(ThaOutils.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/* 162 */     return "00";
/*     */   }
/*     */   
/*     */   public static String getDateAnglaise(String s) {
/* 166 */     if (s.length() == 0) return "";
/* 167 */     SimpleDateFormat dateFormatFr = new SimpleDateFormat("dd/MM/yyyy");
/* 168 */     SimpleDateFormat dateFormatAn = new SimpleDateFormat("yyyy/MM/dd");
/*     */     try
/*     */     {
/* 171 */       Date now = dateFormatFr.parse(s);
/* 172 */       GregorianCalendar gc = new GregorianCalendar();
/* 173 */       gc.setTime(now);
/* 174 */       return dateFormatAn.format(gc.getTime());
/*     */     } catch (ParseException ex) {
/* 176 */       Logger.getLogger(ThaOutils.class.getName()).log(Level.SEVERE, null, ex); }
/* 177 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */   public static String getDateFrancaise(String s)
/*     */   {
/* 183 */     SimpleDateFormat dateFormatFr = new SimpleDateFormat("dd/MM/yyyy");
/* 184 */     SimpleDateFormat dateFormatAn = new SimpleDateFormat("yyyy/MM/dd");
/*     */     try
/*     */     {
/* 187 */       Date now = dateFormatAn.parse(s);
/* 188 */       GregorianCalendar gc = new GregorianCalendar();
/* 189 */       gc.setTime(now);
/* 190 */       return dateFormatFr.format(gc.getTime());
/*     */     } catch (ParseException ex) {
/* 192 */       Logger.getLogger(ThaOutils.class.getName()).log(Level.SEVERE, null, ex); }
/* 193 */     return s;
/*     */   }
/*     */   
/*     */   private static String convertDateKeyFr(String d)
/*     */   {
/* 198 */     if (d == null) return "";
/* 199 */     if (d.length() != 5) return "";
/* 200 */     String an = d.substring(0, 1);
/* 201 */     an = getAnnee(an) + "";
/* 202 */     String mm = d.substring(1, 3);
/* 203 */     String jj = d.substring(3, 5);
/*     */     
/* 205 */     return jj + "/" + mm + "/" + an;
/*     */   }
/*     */   
/*     */   private static String convertDateKeyAn(String d) {
/* 209 */     if (d == null) return "";
/* 210 */     if (d.length() != 5) return "";
/* 211 */     String an = d.substring(0, 1);
/* 212 */     an = getAnnee(an) + "";
/* 213 */     String mm = d.substring(1, 3);
/* 214 */     String jj = d.substring(3, 5);
/*     */     
/* 216 */     return an + "/" + mm + "/" + jj;
/*     */   }
/*     */   
/*     */   public static Date stringToDateFR(String s) {
/*     */     try {
/* 221 */       if (s.length() == 0) {
/* 222 */         return null;
/*     */       }
/* 224 */       SimpleDateFormat dateFormatFr = new SimpleDateFormat("dd/MM/yyyy");
/* 225 */       return dateFormatFr.parse(s);
/*     */     }
/*     */     catch (ParseException ex) {
/* 228 */       Logger.getLogger(ThaOutils.class.getName()).log(Level.SEVERE, null, ex); }
/* 229 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public static Date getDateDebutKey(String k)
/*     */   {
/* 235 */     if (k == null) return null;
/* 236 */     if (k.length() < 25) return null;
/* 237 */     String dd = k.substring(8, 13);
/* 238 */     dd = convertDateKeyFr(dd);
/*     */     
/* 240 */     return stringToDateFR(dd);
/*     */   }
/*     */   
/*     */   public static Date getDateFinKey(String k) {
/* 244 */     if (k == null) return null;
/* 245 */     if (k.length() < 25) return null;
/* 246 */     String dd = k.substring(13, 18);
/* 247 */     dd = convertDateKeyFr(dd);
/* 248 */     return stringToDateFR(dd);
/*     */   }
/*     */   
/*     */   private static boolean CTRL1(String k) {
/* 252 */     if (k.length() < 26) return false;
/* 253 */     String d = k.substring(0, 2);
/* 254 */     int dd = Integer.parseInt(d);
/* 255 */     dd = 99 - dd;
/*     */     
/* 257 */     String d2 = k.substring(24, 26);
/* 258 */     int dd2 = Integer.parseInt(d2);
/*     */     
/* 260 */     if (dd == dd2) return true;
/* 261 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean CTRL2(String k) {
/* 265 */     if (k.length() < 26) return false;
/* 266 */     String dD = k.substring(8, 13);
/* 267 */     String dF = k.substring(13, 18);
/* 268 */     dD = convertDateKeyFr(dD);
/* 269 */     dF = convertDateKeyFr(dF);
/*     */     
/* 271 */     int jjD = getJJInt(dD);
/* 272 */     int jjF = getJJInt(dF);
/* 273 */     int mmF = getMMInt(dF);
/* 274 */     int ctr = (jjD + jjF) % mmF % 9;
/* 275 */     String ctr1 = k.substring(21, 22);
/*     */     
/* 277 */     dD = ctr + "";
/*     */     
/* 279 */     if (ctr1.equals(dD)) return true;
/* 280 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean isKeyVerifier(String k) {
/* 284 */     if (k == null) return false;
/* 285 */     if (k.length() < 25) return false;
/* 286 */     boolean rep = CTRL1(k);
/* 287 */     if (!rep) return false;
/* 288 */     rep = CTRL2(k);
/* 289 */     return rep;
/*     */   }
/*     */   
/*     */   public static String getMacControle() {
/* 293 */     String m = Parametres.getMac();
/* 294 */     if (m == null) return "MRBLANC";
/* 295 */     if (m.length() == 0) return "MRBLANC";
/* 296 */     return m;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean existeDansListe(ArrayList<String> liste, String ch)
/*     */   {
/* 304 */     for (int i = 0; i < liste.size(); i++) {
/* 305 */       if (((String)liste.get(i)).trim().toUpperCase().equals(ch.trim().toUpperCase())) {
/* 306 */         return true;
/*     */       }
/*     */     }
/* 309 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean existeMacDansListe(ArrayList<MacActive> liste, String ch) {
/* 313 */     for (int i = 0; i < liste.size(); i++) {
/* 314 */       if (((MacActive)liste.get(i)).getMac().trim().toUpperCase().equals(ch.trim().toUpperCase())) {
/* 315 */         return true;
/*     */       }
/*     */     }
/* 318 */     return false;
/*     */   }
/*     */   
/*     */   public static void afficherListeDisque(ArrayList<DisqueNum> liste) {
/* 322 */     for (int i = 0; i < liste.size(); i++) {
/* 323 */       System.out.println("nom disque =" + ((DisqueNum)liste.get(i)).getNom() + "    son num  =" + ((DisqueNum)liste.get(i)).getNumero());
/*     */     }
/*     */   }
/*     */   
/*     */   public static String connexionJfreesoft(String URLName) {
/* 328 */     String s = "";
/* 329 */     DataInputStream di = null;
/* 330 */     FileOutputStream fo = null;
/* 331 */     byte[] b = new byte[1];
/* 332 */     System.getProperties().put("http.proxyHost", "");
/* 333 */     System.getProperties().put("http.proxyPort", "");
/* 334 */     System.getProperties().put("http.proxyUser", "");
/* 335 */     System.getProperties().put("http.proxyPassword", "");
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 340 */       URL u = new URL(URLName);
/*     */       try {
/* 342 */         HttpURLConnection con = (HttpURLConnection)u.openConnection();
/* 343 */         di = new DataInputStream(con.getInputStream());
/* 344 */         while (-1 != di.read(b, 0, 1)) {
/* 345 */           s = s + new String(b);
/*     */         }
/*     */       } catch (IOException ex) {
/* 348 */         return "ErreurRM 2";
/*     */       }
/*     */     } catch (MalformedURLException ex) {
/* 351 */       return "ErreurRM 1";
/*     */     }
/* 353 */     return s;
/*     */   }
/*     */   
/*     */   public static String connexionJfreesoftProxy(String URLName, String httpProxy, String log, String mdp, String port) {
/* 357 */     String s = "";
/* 358 */     DataInputStream di = null;
/* 359 */     FileOutputStream fo = null;
/* 360 */     byte[] b = new byte[1];
/*     */     
/* 362 */     System.getProperties().put("http.proxyHost", httpProxy);
/* 363 */     System.getProperties().put("http.proxyPort", port);
/* 364 */     System.getProperties().put("http.proxyUser", log);
/* 365 */     System.getProperties().put("http.proxyPassword", mdp);
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 370 */       URL u = new URL(URLName);
/*     */       try {
/* 372 */         HttpURLConnection con = (HttpURLConnection)u.openConnection();
/* 373 */         di = new DataInputStream(con.getInputStream());
/* 374 */         while (-1 != di.read(b, 0, 1)) {
/* 375 */           s = s + new String(b);
/*     */         }
/*     */       }
/*     */       catch (IOException ex) {
/* 379 */         return "ErreurRM 2";
/*     */       }
/*     */     }
/*     */     catch (MalformedURLException ex) {
/* 383 */       return "ErreurRM 1";
/*     */     }
/* 385 */     return s;
/*     */   }
/*     */   
/*     */   public static void controleSansLicence(Principale frm, Thassarut cle)
/*     */   {
/* 390 */     String dateDer = cle.getAss_ukhadim();
/* 391 */     String dateJour = getDateJour();
/* 392 */     String dateFin = cle.getAss_ifuk();
/*     */     
/* 394 */     if ((dateDer == null) || (dateDer.length() == 0) || (dateJour == null) || (dateJour.length() == 0) || (dateFin == null) || (dateFin.length() == 0))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 399 */       JOptionPane.showMessageDialog(frm, "Erreur : impossible de lire le fichier actDesk.class !\nSi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com ", "Erreur", 0);
/* 400 */       frm.setDefaultCloseOperation(3);
/* 401 */       frm.dispose();
/* 402 */       System.exit(0);
/*     */     }
/*     */     
/* 405 */     int jj = getJJInt(dateDer);
/* 406 */     int modulo = Integer.parseInt(cle.getAchehal_wussan());
/* 407 */     int nbjour = nombreDeJour(dateFin, dateDer);
/* 408 */     jj = nbjour % jj;
/*     */     
/* 410 */     if (nombreDeJour(dateJour, dateDer) < 0) {
/* 411 */       JOptionPane.showMessageDialog(frm, "Erreur de synchronisation, Veuillez vérifiez et mettre à jour votre date système !\nSi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com ", "Erreur", 0);
/* 412 */       frm.setDefaultCloseOperation(3);
/* 413 */       frm.dispose();
/* 414 */       System.exit(0);
/*     */     }
/*     */     
/* 417 */     if (nbjour < 0) {
/* 418 */       JOptionPane.showMessageDialog(frm, "La date de validité de JMerise est exprirée, Veuillez télécharger la nouvelle version sur jfreesoft.com  ", "Erreur", 0);
/* 419 */       frm.setDefaultCloseOperation(3);
/* 420 */       frm.dispose();
/* 421 */       System.exit(0);
/*     */     }
/*     */     
/* 424 */     if (nbjour < 31) {
/* 425 */       JOptionPane.showMessageDialog(frm, "La date de validité de JMerise sera expriée le :" + dateFin + ",\nPensez à retélécharger la nouvelle version sur jfreesoft.com avant cette date ", "Erreur", 1);
/*     */     }
/*     */     
/* 428 */     if (jj != modulo) {
/* 429 */       JOptionPane.showMessageDialog(frm, "Erreur JM_05_C1 : lors de la lecture des fichiers JMerise !\nSi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com ", "Erreur", 0);
/* 430 */       frm.setDefaultCloseOperation(3);
/* 431 */       frm.dispose();
/* 432 */       System.exit(0);
/*     */     }
/* 434 */     int nbJDF = nombreDeJour(dateFin, cle.getAss_ivdha());
/*     */     
/* 436 */     if (nbJDF > 380) {
/* 437 */       JOptionPane.showMessageDialog(frm, "Erreur JM_05_KY : lors de la lecture des donnéss dans les fichiers JMerise !\nSi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com ", "Erreur", 0);
/* 438 */       frm.setDefaultCloseOperation(3);
/* 439 */       frm.dispose();
/* 440 */       System.exit(0);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void controleLicence(Principale frm, Thassarut cle)
/*     */   {
/* 448 */     String dateDer = cle.getAss_ukhadim();
/* 449 */     String dateJour = getDateJour();
/* 450 */     String dateFin = cle.getAss_ifuk();
/* 451 */     String macc = getMacControle();
/* 452 */     if ((dateDer == null) || (dateDer.length() == 0) || (dateJour == null) || (dateJour.length() == 0) || (dateFin == null) || (dateFin.length() == 0))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 457 */       JOptionPane.showMessageDialog(frm, "Erreur : impossible de lire le fichier actDesk.class !\nSi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com ", "Erreur", 0);
/* 458 */       frm.setDefaultCloseOperation(3);
/* 459 */       frm.dispose();
/* 460 */       System.exit(0);
/*     */     }
/*     */     
/* 463 */     int jj = getJJInt(dateDer);
/* 464 */     int modulo = Integer.parseInt(cle.getAchehal_wussan());
/* 465 */     int nbjour = nombreDeJour(dateFin, dateDer);
/* 466 */     jj = nbjour % jj;
/*     */     
/* 468 */     if (nombreDeJour(dateJour, dateDer) < 0) {
/* 469 */       JOptionPane.showMessageDialog(frm, "Erreur de synchronisation, Veuillez vérifiez et mettre à jour votre date système !\nSi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com ", "Erreur", 0);
/* 470 */       frm.setDefaultCloseOperation(3);
/* 471 */       frm.dispose();
/* 472 */       System.exit(0);
/*     */     }
/*     */     
/* 475 */     if (nbjour < 0) {
/* 476 */       JOptionPane.showMessageDialog(frm, "La date de validité de JMerise est exprirée, Veuillez télécharger la nouvelle version sur jfreesoft.com  ", "Erreur", 0);
/* 477 */       frm.setDefaultCloseOperation(3);
/* 478 */       frm.dispose();
/* 479 */       System.exit(0);
/*     */     }
/*     */     
/* 482 */     if (jj != modulo) {
/* 483 */       JOptionPane.showMessageDialog(frm, "Erreur JM_05_C1 : lors de la lecture des fichier JMerise !\nSi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com ", "Erreur", 0);
/* 484 */       frm.setDefaultCloseOperation(3);
/* 485 */       frm.dispose();
/* 486 */       System.exit(0);
/*     */     }
/*     */     
/* 489 */     int nbJDF = nombreDeJour(dateJour, cle.getAss_ivdha());
/*     */     
/* 491 */     if (nbJDF < -1) {
/* 492 */       JOptionPane.showMessageDialog(frm, "Erreur JM_05_KY1 : lors de la lecture des donnéss dans les fichiers JMerise !\nSi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com ", "Erreur", 0);
/* 493 */       frm.setDefaultCloseOperation(3);
/* 494 */       frm.dispose();
/* 495 */       System.exit(0);
/*     */     }
/*     */     
/* 498 */     if (!existeMacDansListe(cle.getMac(), macc)) {
/* 499 */       JOptionPane.showMessageDialog(frm, "Erreur JM_05_C02 : erreur de clé d'activation !\nSi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com ", "Erreur", 0);
/* 500 */       frm.setDefaultCloseOperation(3);
/* 501 */       frm.dispose();
/* 502 */       System.exit(0);
/*     */     }
/*     */     
/* 505 */     if (!isKeyVerifier(cle.getThassarouts())) {
/* 506 */       JOptionPane.showMessageDialog(frm, "Erreur JM_05_C03 : erreur de clé d'activation !\nSi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com ", "Erreur", 0);
/* 507 */       frm.setDefaultCloseOperation(3);
/* 508 */       frm.dispose();
/* 509 */       System.exit(0);
/*     */     }
/*     */     
/*     */ 
/* 513 */     if (nbjour < 31) {
/* 514 */       JOptionPane.showMessageDialog(frm, "La date de validité de JMerise sera expriée le :" + dateFin + ",\nPensez à retélécharger la nouvelle version sur jfreesoft.com avant cette date ", "Erreur", 1);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void MAJLicence(Thassarut cle)
/*     */   {
/* 522 */     String dateCle = cle.getAss_ukhadim();
/* 523 */     String datejour = getDateJour();
/* 524 */     int nbJour = nombreDeJour(datejour, dateCle);
/* 525 */     if (nbJour < -1) return;
/* 526 */     String dateFin = cle.getAss_ifuk();
/* 527 */     int jj = getJJInt(datejour);
/* 528 */     nbJour = nombreDeJour(dateFin, datejour);
/* 529 */     jj = nbJour % jj;
/* 530 */     cle.setAchehal_wussan(jj + "");
/* 531 */     cle.setAss_ukhadim(datejour);
/*     */   }
/*     */   
/*     */   public static boolean verifierFermetureLicence2(Thassarut cle) {
/* 535 */     String dateCle = cle.getAss_ukhadim();
/* 536 */     String datejour = getDateJour();
/* 537 */     int nbJour = nombreDeJour(datejour, dateCle);
/* 538 */     if (nbJour < -1) return false;
/* 539 */     nbJour = nombreDeJour(stringToDateFR(datejour), Parametres.dateExec);
/* 540 */     if (nbJour < -1) { return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 547 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Thassarut openLicence2(String nomFichier)
/*     */   {
/* 555 */     Object ob = null;
/*     */     try
/*     */     {
/* 558 */       FileInputStream fichier = new FileInputStream(nomFichier);
/* 559 */       ObjectInputStream ois = new ObjectInputStream(fichier);
/* 560 */       ob = ois.readObject();
/* 561 */       fichier.close();
/* 562 */       if ((ob instanceof Thassarut)) {
/* 563 */         return (Thassarut)ob;
/*     */       }
/* 565 */       return null;
/*     */     } catch (IOException ex) {
/* 567 */       Logger.getLogger(ThaOutils.class.getName()).log(Level.SEVERE, null, ex);
/* 568 */       return null;
/*     */     }
/*     */     catch (ClassNotFoundException ex) {
/* 571 */       Logger.getLogger(ThaOutils.class.getName()).log(Level.SEVERE, null, ex); }
/* 572 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean saveLicence2(Thassarut cle, String nomFichier)
/*     */   {
/* 578 */     FileOutputStream fichier = null;
/*     */     try {
/* 580 */       MAJLicence(cle);
/* 581 */       fichier = new FileOutputStream(nomFichier);
/*     */       
/* 583 */       ObjectOutputStream oos = new ObjectOutputStream(fichier);
/* 584 */       oos.writeObject(cle);
/* 585 */       fichier.close();
/* 586 */       return true;
/*     */     } catch (FileNotFoundException ex) {
/* 588 */       Logger.getLogger(ThaOutils.class.getName()).log(Level.SEVERE, null, ex);
/* 589 */       return false;
/*     */     }
/*     */     catch (IOException ex) {
/* 592 */       Logger.getLogger(ThaOutils.class.getName()).log(Level.SEVERE, null, ex); }
/* 593 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean deleteLicence2(String nomFichier)
/*     */   {
/* 598 */     String nameF = nomFichier;
/* 599 */     File f = new File(nameF);
/* 600 */     if (f.exists()) return f.delete();
/* 601 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean verifierExiteMac(Thassarut cle) {
/* 605 */     String mac = Parametres.getMac();
/*     */     
/* 607 */     if (mac == null) return false;
/* 608 */     if (mac.trim().length() == 0) return false;
/* 609 */     for (int i = 0; i < cle.getMac().size(); i++) {
/* 610 */       if (((MacActive)cle.getMac().get(i)).getMac().equals(mac))
/*     */       {
/* 612 */         return true;
/*     */       }
/*     */     }
/* 615 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Thasaruts\ThaOutils.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */