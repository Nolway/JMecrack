/*     */ package Thasaruts;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import ihm.Principale;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.util.Properties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ThassaroutJfreesoft
/*     */ {
/*  23 */   public static String OK00 = "Erreur Sync num 05_00 : erreur de paramètres !!\nsi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com";
/*  24 */   public static String OK01 = "Erreur Sync num 05_01 : erreur de synchronisation 1 !!\nsi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com";
/*  25 */   public static String OK02 = "Erreur Sync num 05_02 : erreur de synchronisation 2 !!\nsi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com";
/*  26 */   public static String OK03 = "Erreur Sync num 05_03 : plusieurs postes utilisés !!\nsi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com";
/*  27 */   public static String OK04 = "Erreur Sync num 05_04 : erreur de serveur ou clé pas encore activée !!\nsi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com";
/*  28 */   public static String OK05 = "Erreur Sync num 05_05 : erreur de serveur, problème de connexion BDD !!\nsi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com";
/*  29 */   public static String OK07 = "Erreur Sync num 05_07 : erreur de serveur, problème connexion !!\nsi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com";
/*  30 */   public static String OK08 = "Erreur Sync num 05_08 : erreur de serveur Licence !!\nsi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com";
/*  31 */   public static String OK09 = "Erreur Sync num 05_09 : erreur de serveur Licence2 !!\nsi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com";
/*  32 */   public static String OK10 = "Erreur Sync num 05_10 : erreur de synchronisation 10 !!\nsi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com";
/*  33 */   public static String OK11 = "Erreur Sync num 05_11 : erreur de serveur maj Licence !!\nsi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com";
/*  34 */   public static String OK12 = "Erreur Sync num 05_12 : erreur de serveur maj Licence2 !!\nsi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com";
/*  35 */   public static String OKA01 = "Erreur Sync num 05_A01 : erreur de serveur mesaagerie !!\nsi l'erreur persiste contactez le propriétaire : admin@jfreesoft.com";
/*     */   
/*     */   public static String idLic;
/*     */   public static String idUser;
/*     */   public static String dateAchatLic;
/*     */   public static String dateDebutLic;
/*     */   public static String dateFinLic;
/*     */   public static String dateActivationLic;
/*     */   public static String ip1Lic;
/*     */   public static String ip2Lic;
/*     */   public static String ip3Lic;
/*     */   public static String mac1Lic;
/*     */   public static String mac2Lic;
/*     */   public static String mac3Lic;
/*     */   public static String mac4Lic;
/*     */   public static String os1Lic;
/*     */   public static String os2Lic;
/*     */   public static String os3Lic;
/*     */   public static String disque1Lic;
/*     */   public static String disque2Lic;
/*     */   public static String disque3Lic;
/*     */   public static String nbUseLic;
/*     */   public static String dateDerUseLic;
/*     */   public static String numeroLic;
/*     */   public static String dateServeur;
/*     */   public static final String MACDEFAUT = "MRBLANC";
/*     */   
/*     */   public static String getValeur(String balise, String s)
/*     */   {
/*  64 */     String baliseD = "<" + balise + ">";
/*  65 */     String baliseF = "</" + balise + ">";
/*  66 */     s = s.substring(s.indexOf(baliseD), s.indexOf(baliseF));
/*  67 */     s = s.replace(baliseD, "");
/*  68 */     s = s.replace(baliseF, "");
/*  69 */     return s.trim();
/*     */   }
/*     */   
/*     */   public static String getDateServeur(String s) {
/*  73 */     String date = getValeur("REPSERV", s);
/*  74 */     return date.trim();
/*     */   }
/*     */   
/*     */   public static String getReponseServeur(String s) {
/*  78 */     int i = s.indexOf("<REPSERV>");
/*  79 */     if (i < 0) return OKA01;
/*  80 */     String rep = getValeur("REPSERV", s);
/*  81 */     rep = rep.trim();
/*  82 */     if (rep.equals("OK06")) return " ";
/*  83 */     if (rep.equals("OK00")) return OK00;
/*  84 */     if (rep.equals("OK01")) return OK01;
/*  85 */     if (rep.equals("OK02")) return OK02;
/*  86 */     if (rep.equals("OK03")) return OK03;
/*  87 */     if (rep.equals("OK04")) return OK04;
/*  88 */     if (rep.equals("OK05")) return OK05;
/*  89 */     if (rep.equals("OK07")) return OK07;
/*  90 */     if (rep.equals("OK08")) return OK08;
/*  91 */     if (rep.equals("OK09")) return OK09;
/*  92 */     if (rep.equals("OK10")) return OK10;
/*  93 */     if (rep.equals("OK11")) return OK11;
/*  94 */     if (rep.equals("OK12")) return OK12;
/*  95 */     return OKA01;
/*     */   }
/*     */   
/*     */   public static void affecterLesAttributs(String s) {
/*  99 */     idLic = getValeur("IDLIC", s);
/* 100 */     idUser = getValeur("IDUSER", s);
/* 101 */     dateAchatLic = ThaOutils.getDateFrancaise(getValeur("DATEACHAT", s));
/* 102 */     dateDebutLic = ThaOutils.getDateFrancaise(getValeur("DATEDEBUT", s));
/* 103 */     dateFinLic = ThaOutils.getDateFrancaise(getValeur("DATEFIN", s));
/* 104 */     dateActivationLic = ThaOutils.getDateFrancaise(getValeur("DATEACTIVATION", s));
/* 105 */     ip1Lic = getValeur("IP1", s);
/* 106 */     ip2Lic = getValeur("IP2", s);
/* 107 */     ip3Lic = getValeur("IP3", s);
/* 108 */     mac1Lic = getValeur("MAC1", s);
/* 109 */     mac2Lic = getValeur("MAC2", s);
/* 110 */     mac3Lic = getValeur("MAC3", s);
/* 111 */     mac4Lic = getValeur("MAC4", s);
/* 112 */     os1Lic = getValeur("OS1", s);
/* 113 */     os2Lic = getValeur("OS2", s);
/* 114 */     os3Lic = getValeur("OS3", s);
/* 115 */     disque1Lic = getValeur("DISQUE1", s);
/* 116 */     disque2Lic = getValeur("DISQUE2", s);
/* 117 */     disque3Lic = getValeur("DISQUE3", s);
/* 118 */     nbUseLic = getValeur("NBUSE", s);
/* 119 */     dateDerUseLic = ThaOutils.getDateFrancaise(getValeur("DATEDERUSE", s));
/* 120 */     numeroLic = getValeur("NUMERO", s);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String traiterReponseSereur(String s)
/*     */   {
/* 127 */     String rep = getReponseServeur(s);
/* 128 */     if (rep.trim().length() == 0) {
/* 129 */       dateServeur = ThaOutils.getDateFrancaise(getDateServeur(s));
/* 130 */       s = getValeur("LICENCE", s);
/* 131 */       affecterLesAttributs(s);
/*     */     }
/* 133 */     return rep;
/*     */   }
/*     */   
/*     */   public static boolean verifierDateJourDateServeurCorrect()
/*     */   {
/* 138 */     String dateJ = ThaOutils.getDateJour();
/* 139 */     String dateSer = dateServeur;
/* 140 */     int nb = ThaOutils.nombreDeJour(dateSer, dateJ);
/* 141 */     if (Math.abs(nb) < 3) return true;
/* 142 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean verifierDateJourDateAchatCorrect(String dateAchat) {
/* 146 */     String dateJ = ThaOutils.getDateJour();
/* 147 */     int nb = ThaOutils.nombreDeJour(dateJ, dateAchat);
/* 148 */     if (Math.abs(nb) < 3) return false;
/* 149 */     return true;
/*     */   }
/*     */   
/*     */   private static String activerSansProxy(String URLName) {
/* 153 */     String s = "";
/* 154 */     DataInputStream di = null;
/* 155 */     FileOutputStream fo = null;
/* 156 */     byte[] b = new byte[1];
/* 157 */     System.getProperties().put("http.proxyHost", "");
/* 158 */     System.getProperties().put("http.proxyPort", "");
/* 159 */     System.getProperties().put("http.proxyUser", "");
/* 160 */     System.getProperties().put("http.proxyPassword", "");
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 165 */       URL u = new URL(URLName);
/*     */       try {
/* 167 */         HttpURLConnection con = (HttpURLConnection)u.openConnection();
/* 168 */         di = new DataInputStream(con.getInputStream());
/* 169 */         while (-1 != di.read(b, 0, 1)) {
/* 170 */           s = s + new String(b);
/*     */         }
/*     */       } catch (IOException ex) {
/* 173 */         return "ErreurRM2";
/*     */       }
/*     */     } catch (MalformedURLException ex) {
/* 176 */       return "ErreurRM1";
/*     */     }
/* 178 */     return s;
/*     */   }
/*     */   
/*     */   private static String activerAvecProxy(String URLName, String httpProxy, String log, String mdp, String port) {
/* 182 */     String s = "";
/* 183 */     DataInputStream di = null;
/* 184 */     FileOutputStream fo = null;
/* 185 */     byte[] b = new byte[1];
/*     */     
/* 187 */     System.getProperties().put("http.proxyHost", httpProxy);
/* 188 */     System.getProperties().put("http.proxyPort", port);
/* 189 */     System.getProperties().put("http.proxyUser", log);
/* 190 */     System.getProperties().put("http.proxyPassword", mdp);
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 195 */       URL u = new URL(URLName);
/*     */       try {
/* 197 */         HttpURLConnection con = (HttpURLConnection)u.openConnection();
/* 198 */         di = new DataInputStream(con.getInputStream());
/* 199 */         while (-1 != di.read(b, 0, 1)) {
/* 200 */           s = s + new String(b);
/*     */         }
/*     */       } catch (IOException ex) {
/* 203 */         return "ErreurRM 2";
/*     */       }
/*     */     } catch (MalformedURLException ex) {
/* 206 */       return "ErreurRM 1";
/*     */     }
/* 208 */     return s;
/*     */   }
/*     */   
/*     */   public static String activerLicence(String URLName, boolean isProxy, String httpProxy, String log, String mdp, String port) {
/* 212 */     if (isProxy) {
/* 213 */       return activerAvecProxy(URLName, httpProxy, log, mdp, port);
/*     */     }
/* 215 */     return activerSansProxy(URLName);
/*     */   }
/*     */   
/*     */   public static String getUrlActivation(String lic, String dev, String mail, boolean informer) {
/* 219 */     String url = "http://www.jfreesoft.com/JMerise/activer2.php?";
/* 220 */     String sess = System.getProperty("user.name");
/*     */     
/* 222 */     dev = remplaceChar(dev);
/* 223 */     dev = dev.length() > 25 ? dev.substring(0, 25) : dev;
/* 224 */     dev = "dev=" + dev;
/* 225 */     url = url + dev + "&";
/* 226 */     sess = remplaceChar(sess);
/* 227 */     if (sess.length() == 0) sess = "user05";
/* 228 */     sess = sess.length() > 25 ? sess.substring(0, 25) : sess;
/* 229 */     sess = "s=" + sess;
/* 230 */     url = url + sess + "&";
/* 231 */     lic = lic.replace("%", "");
/*     */     
/* 233 */     lic = "k=" + lic;
/* 234 */     url = url + lic + "&";
/* 235 */     String inform = informer ? "1" : "0";
/* 236 */     inform = "in=" + inform;
/* 237 */     url = url + inform + "&";
/*     */     
/* 239 */     url = url + "dis=DISK1" + "&";
/*     */     
/* 241 */     String datej = ThaOutils.getDateJour();
/* 242 */     int jj = ThaOutils.getJJInt(datej);
/* 243 */     int nbjour = ThaOutils.nombreDeJour(datej, "15/03/2018");
/* 244 */     int clej = nbjour % jj;
/*     */     
/* 246 */     url = url + "nb=" + nbjour + "&";
/* 247 */     url = url + "dj=" + jj + "&";
/* 248 */     url = url + "d=" + datej + "&";
/* 249 */     url = url + "c=" + clej + "&";
/*     */     
/* 251 */     mail = remplaceChar(mail);
/* 252 */     url = url + "ma=" + mail + "&";
/* 253 */     String mac = Parametres.getMac();
/* 254 */     if (mac.length() == 0) mac = "MRBLANC";
/* 255 */     url = url + "m=" + mac;
/* 256 */     return url;
/*     */   }
/*     */   
/*     */   public static String getUrlEnregistrement() {
/* 260 */     String url = "http://www.jfreesoft.com/JMerise/enregistrer2.php?";
/* 261 */     String sess = System.getProperty("user.name");
/* 262 */     String heur = System.currentTimeMillis() + "";
/* 263 */     String lic = heur;
/*     */     
/* 265 */     sess = remplaceChar(sess);
/* 266 */     if (sess.length() == 0) sess = "user05";
/* 267 */     sess = sess.length() > 25 ? sess.substring(0, 25) : sess;
/* 268 */     lic = lic + sess.substring(0, 2);
/*     */     
/* 270 */     sess = "s=" + sess;
/* 271 */     url = url + sess + "&";
/* 272 */     numeroLic = lic;
/* 273 */     lic = "k=" + lic;
/* 274 */     url = url + lic + "&";
/*     */     
/* 276 */     url = url + "dis=DISK1" + "&";
/*     */     
/* 278 */     String datej = ThaOutils.getDateJour();
/* 279 */     int jj = ThaOutils.getJJInt(datej);
/* 280 */     int nbjour = ThaOutils.nombreDeJour(datej, "15/03/2018");
/* 281 */     int clej = nbjour % jj;
/*     */     
/* 283 */     url = url + "nb=" + nbjour + "&";
/* 284 */     url = url + "dj=" + jj + "&";
/* 285 */     url = url + "d=" + datej + "&";
/* 286 */     url = url + "c=" + clej + "&";
/*     */     
/* 288 */     String mac = Parametres.getMac();
/* 289 */     if (mac.length() == 0) mac = "MRBLANC";
/* 290 */     url = url + "m=" + mac;
/*     */     
/* 292 */     return url;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String traiterReponseEnregistrer(Principale frm, String s)
/*     */   {
/* 299 */     if (s.indexOf("<DATESERV>") < 0) return OKA01;
/* 300 */     String rep = getReponseServeur(s);
/* 301 */     if (rep.trim().length() > 0) return rep;
/* 302 */     String dateServ = ThaOutils.getDateFrancaise(getValeur("DATESERV", s));
/* 303 */     String dateFinServ = ThaOutils.getDateFrancaise(getValeur("DATESEVFIN", s));
/*     */     
/* 305 */     int nbjour = ThaOutils.nombreDeJour(ThaOutils.getDateJour(), dateServ);
/*     */     
/* 307 */     if ((nbjour > 2) || (nbjour < -2)) {
/* 308 */       return "Erreur de synchronisation avec le serveur. Veuillez vérifier et mettre à jour votre date systeme";
/*     */     }
/* 310 */     dateDebutLic = dateServ;
/* 311 */     dateFinLic = dateFinServ;
/*     */     
/* 313 */     return " ";
/*     */   }
/*     */   
/*     */   public static String traiterReponseActivationS(Principale frm, Thassarut cle, String s) {
/* 317 */     String rep = traiterReponseSereur(s);
/* 318 */     if (rep.trim().length() == 0) {
/* 319 */       cle.setIdLic(Integer.parseInt(idLic));
/* 320 */       cle.setIdUser(Integer.parseInt(idUser));
/* 321 */       cle.setAss_elviaa(dateAchatLic);
/* 322 */       cle.setAss_ivdha(dateDebutLic);
/* 323 */       cle.setAss_ifuk(dateFinLic);
/* 324 */       cle.setAss_i_active(dateActivationLic);
/* 325 */       cle.addIP(ip1Lic);
/* 326 */       cle.addIP(ip2Lic);
/* 327 */       cle.addIP(ip3Lic);
/* 328 */       cle.addMac(mac1Lic);
/* 329 */       cle.addMac(mac2Lic);
/* 330 */       cle.addMac(mac3Lic);
/* 331 */       cle.addMac(mac4Lic);
/* 332 */       cle.setOs1(os1Lic);
/* 333 */       cle.setOs2(os2Lic);
/* 334 */       cle.setOs3(os3Lic);
/* 335 */       cle.addDisque(disque1Lic);
/* 336 */       cle.addDisque(disque2Lic);
/* 337 */       cle.addDisque(disque3Lic);
/* 338 */       cle.setNbUsed(Integer.parseInt(nbUseLic));
/* 339 */       cle.setAss_ukhadim(dateDerUseLic);
/* 340 */       cle.setThassarouts(numeroLic);
/* 341 */       ThaOutils.MAJLicence(cle);
/* 342 */       Outil.Setting.licence = cle;
/*     */     }
/* 344 */     return rep;
/*     */   }
/*     */   
/*     */   public static String remplaceChar(String s)
/*     */   {
/* 349 */     String st = s;
/* 350 */     st = st.trim();
/* 351 */     st = st.replace(" ", "");
/* 352 */     st = st.replace("\"", "");
/* 353 */     st = st.replace("'", "");
/* 354 */     st = st.replace("?", "");
/* 355 */     st = st.replace("<", "");
/* 356 */     st = st.replace(">", "");
/* 357 */     st = st.replace("°", "");
/* 358 */     st = st.replace("#", "");
/* 359 */     st = st.replace("&", "");
/* 360 */     st = st.replace("*", "");
/* 361 */     st = st.replace(",", "");
/* 362 */     st = st.replace(";", "");
/* 363 */     st = st.replace(":", "");
/* 364 */     st = st.replace("!", "");
/*     */     
/* 366 */     st = st.replace("à", "a");
/* 367 */     st = st.replace("â", "a");
/* 368 */     st = st.replace("ä", "a");
/* 369 */     st = st.replace("Ä", "A");
/* 370 */     st = st.replace("Â", "A");
/*     */     
/* 372 */     st = st.replace("é", "e");
/* 373 */     st = st.replace("è", "e");
/* 374 */     st = st.replace("ê", "e");
/* 375 */     st = st.replace("ë", "e");
/* 376 */     st = st.replace("Ë", "E");
/* 377 */     st = st.replace("Ê", "E");
/*     */     
/* 379 */     st = st.replace("ô", "o");
/* 380 */     st = st.replace("Ô", "O");
/*     */     
/* 382 */     st = st.replace("ü", "u");
/* 383 */     st = st.replace("û", "u");
/* 384 */     st = st.replace("ù", "u");
/* 385 */     st = st.replace("Ü", "U");
/* 386 */     st = st.replace("Û", "U");
/*     */     
/* 388 */     st = st.replace("ç", "c");
/* 389 */     st = st.replace("(", "");
/* 390 */     st = st.replace(")", "");
/* 391 */     return st;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Thasaruts\ThassaroutJfreesoft.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */