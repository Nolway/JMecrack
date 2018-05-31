/*     */ package Outil;
/*     */ 
/*     */ import IhmMCD2.ConfigurationMCD2;
/*     */ import Merise2.Attribut2;
/*     */ import Thasaruts.Thassarut;
/*     */ import java.awt.Color;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Setting
/*     */ {
/*  19 */   public static boolean petitCarreau = false;
/*  20 */   public static boolean attUniq = false;
/*  21 */   public static boolean redondNomAss = true;
/*  22 */   public static boolean videNomAss = true;
/*  23 */   public static boolean informProprieteMCD = false;
/*  24 */   public static boolean heritageMult = false;
/*  25 */   public static boolean historiqueSave = true;
/*  26 */   public static boolean attMajuscule = true;
/*     */   
/*  28 */   public static boolean cardinalite2points = true;
/*  29 */   public static boolean cardinaliteMajuscule = true;
/*  30 */   public static boolean desactiverHeritage = false;
/*  31 */   public static boolean prkvisible = true;
/*     */   
/*     */ 
/*  34 */   public static boolean verifTypeAtt = false;
/*  35 */   public static boolean convertTypeAtt = false;
/*     */   
/*     */ 
/*  38 */   public static String SQLDefaut = "";
/*  39 */   public static boolean inclureCommentTableSQL = true;
/*  40 */   public static boolean inclureCommentAttSQL = true;
/*     */   
/*     */ 
/*  43 */   public static String developpeur = "";
/*  44 */   public static String dateDerUse = "";
/*  45 */   public static String dateFin = "";
/*     */   
/*     */ 
/*  48 */   public static boolean cleMere = true;
/*  49 */   public static boolean cleSiNecessaireMere = false;
/*  50 */   public static boolean attMere = true;
/*  51 */   public static boolean surchargeAttMere = false;
/*     */   
/*  53 */   public static boolean surchargeNom = true;
/*  54 */   public static boolean meLaisserChoix = false;
/*     */   
/*     */   public static boolean proxy;
/*     */   
/*  58 */   public static String proxyHTTP = "";
/*  59 */   public static String proxyPort = "";
/*  60 */   public static String proxyLogin = "";
/*  61 */   public static String proxyPassW = "";
/*     */   
/*  63 */   public static int nbAttAfficher = -1;
/*  64 */   public static int nbAfficherFenetreDontion = 1;
/*     */   
/*     */ 
/*  67 */   public static String imprimerOrientation = "PORTRAIT";
/*  68 */   public static boolean imprimerNomMcd = true;
/*  69 */   public static boolean imprimerNomDev = true;
/*  70 */   public static boolean imprimerNumPage = true;
/*  71 */   public static String imprimerMargeG = "";
/*  72 */   public static String imprimerMargeD = "";
/*  73 */   public static String imprimerMargeH = "";
/*  74 */   public static String imprimerMargeB = "";
/*     */   
/*  76 */   public static int afficherDonation = 10;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  81 */   public static boolean augmentation = false;
/*  82 */   public static int augmentationNBCaractere = 3;
/*  83 */   public static boolean augmentationNomComplet = false;
/*     */   
/*     */ 
/*  86 */   public static boolean selectAttribut = true;
/*  87 */   public static boolean zoomToutPage = false;
/*     */   
/*  89 */   public static boolean activerLien2 = true;
/*  90 */   public static boolean isAttributCleParDefautPourEntite = false;
/*  91 */   public static Attribut2 attributCle = new Attribut2("id", "ID", "Auto_increment", -1, -1, Parametres.Cle, false, "", null);
/*  92 */   public static String couleurLibrairieSel = ConfigurationMCD2.getColor(Color.RED);
/*  93 */   public static boolean dragNdropAfficherAttribut = true;
/*  94 */   public static boolean afficherOptionSelectionLib = false;
/*     */   
/*  96 */   public static boolean SQLUtiliserCode = false;
/*  97 */   public static int SQLCardinaliteMax = 3;
/*  98 */   public static boolean agraverSelection2 = true;
/*     */   
/* 100 */   public static boolean MLDStructurerAtt2 = true;
/* 101 */   public static boolean MLDAfficherNomLien2 = true;
/*     */   
/* 103 */   public static boolean ouvrirCreerUneCopie2 = true;
/* 104 */   public static boolean SQLAugmenterNomTableParDeveloppeur2 = false;
/* 105 */   public static boolean heritageMemeSpecialisation2 = false;
/*     */   
/* 107 */   public static boolean SQLPrefixerLeNomContrainte2 = false;
/*     */   
/* 109 */   public static Color clSelected2 = Color.RED;
/*     */   
/* 111 */   public static HashMap<String, String> developpeurs = new HashMap();
/*     */   
/* 113 */   public static String afficherFAndL2 = "JAVA";
/*     */   
/* 115 */   public static Thassarut licence = null;
/*     */   
/* 117 */   public static boolean SQLVerifierMotReserver2 = true;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String getUneSession(String s)
/*     */   {
/* 129 */     if (s.trim().length() == 0) return "";
/* 130 */     return s;
/*     */   }
/*     */   
/*     */   public static int getImprimeOrientation() {
/* 134 */     if (imprimerOrientation.equals("PAYSAGE")) return 2;
/* 135 */     if (imprimerOrientation.equals("PORTRAIT")) return 1;
/* 136 */     return 1;
/*     */   }
/*     */   
/*     */   public static int toInteger(String s) {
/* 140 */     if (s == null) return 0;
/* 141 */     if (s.trim().length() == 0) return 0;
/* 142 */     return Integer.parseInt(s);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void remplirDeveloppeurs(String s) {}
/*     */   
/*     */ 
/*     */   public static String toString(boolean b)
/*     */   {
/* 151 */     if (b) return "true";
/* 152 */     return "false";
/*     */   }
/*     */   
/*     */   public static boolean toBoolean(String b)
/*     */   {
/* 157 */     if (b.equals("true")) return true;
/* 158 */     return false;
/*     */   }
/*     */   
/*     */   public static String valeurChamp(String ch, String settin)
/*     */   {
/* 163 */     String s = settin.substring(settin.indexOf(ch));
/* 164 */     s = s.substring(s.indexOf(">") + 1);
/* 165 */     s = s.substring(0, s.indexOf("<"));
/*     */     
/* 167 */     return s.trim();
/*     */   }
/*     */   
/*     */   public static String getDateJour()
/*     */   {
/* 172 */     SimpleDateFormat sdfrancaise = new SimpleDateFormat("dd/MM/yyyy");
/* 173 */     Date now = new Date();
/* 174 */     return sdfrancaise.format(now);
/*     */   }
/*     */   
/*     */   public static String settingToString() {
/* 178 */     String s = "<setting>";
/*     */     
/* 180 */     s = "<petitCarreau>" + toString(petitCarreau) + "</petitCarreau>\n" + "<attUniq>" + toString(attUniq) + " </attUniq>\n" + "<redondNomAss>" + toString(redondNomAss) + "</redondNomAss>\n" + "<videNomAss>" + toString(videNomAss) + "</videNomAss>\n" + "<informProprieteMCD>" + toString(informProprieteMCD) + "</informProprieteMCD>\n" + "<heritageMult>" + toString(heritageMult) + "</heritageMult>\n" + "<historiqueSave>" + toString(historiqueSave) + "</historiqueSave>\n" + "<attMajuscule>" + toString(attMajuscule) + "</attMajuscule>\n" + "<cardinalite2points>" + toString(cardinalite2points) + "</cardinalite2points>\n" + "<cardinaliteMajuscule>" + toString(cardinaliteMajuscule) + "</cardinaliteMajuscule>\n" + "<desactiverHeritage>" + toString(desactiverHeritage) + "</desactiverHeritage>\n" + "<prkvisible>" + toString(prkvisible) + "</prkvisible>\n" + "<verifTypeAtt>" + toString(verifTypeAtt) + "</verifTypeAtt>\n" + "<convertTypeAtt>" + toString(convertTypeAtt) + "</convertTypeAtt>\n" + "<SQLDefaut>" + SQLDefaut + "</SQLDefaut>\n" + "<inclureCommentTableSQL>" + toString(inclureCommentTableSQL) + "</inclureCommentTableSQL>\n" + "<inclureCommentAttSQL>" + toString(inclureCommentAttSQL) + "</inclureCommentAttSQL>\n" + "<developpeur>" + developpeur + "</developpeur>\n" + "<dateDerUse>" + getDateJour() + "</dateDerUse>\n" + "<proxy>" + toString(proxy) + "</proxy>\n" + "<proxyHTTP>" + proxyHTTP + "</proxyHTTP>\n" + "<proxyPort>" + proxyPort + "</proxyPort>\n" + "<proxyLogin>" + proxyLogin + "</proxyLogin>\n" + "<proxyPassW>" + proxyPassW + "</proxyPassW>\n" + "<cleMere>" + toString(cleMere) + "</cleMere>\n" + "<proxy>" + toString(cleSiNecessaireMere) + "</cleSiNecessaireMere>\n" + "<attMere>" + toString(attMere) + "</attMere>\n" + "<surchargeAttMere>" + toString(surchargeAttMere) + "</surchargeAttMere>\n" + "<surchargeNom>" + toString(surchargeNom) + "</surchargeNom>\n" + "<meLaisserChoix>" + toString(meLaisserChoix) + "</meLaisserChoix>\n" + "<imprimerOrientation>" + imprimerOrientation + "</imprimerOrientation>" + "<imprimerNomMcd>" + toString(imprimerNomMcd) + "</imprimerNomMcd>" + "<imprimerNomDev>" + toString(imprimerNomDev) + "</imprimerNomDev>" + "<imprimerNumPage>" + toString(imprimerNumPage) + "</imprimerNumPage>" + "<imprimerMargeG>" + imprimerMargeG + "</imprimerMargeG>" + "<imprimerMargeD>" + imprimerMargeD + "</imprimerMargeD>" + "<imprimerMargeH>" + imprimerMargeH + "</imprimerMargeH>" + "<imprimerMargeB>" + imprimerMargeB + "</imprimerMargeB>" + "<afficherDonation>" + afficherDonation + "</afficherDonation>" + "</setting>";
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
/* 233 */     return s;
/*     */   }
/*     */   
/*     */   public static void stringToSetting(String s) throws Exception
/*     */   {
/* 238 */     petitCarreau = toBoolean(valeurChamp("petitCarreau", s));
/* 239 */     attUniq = toBoolean(valeurChamp("attUniq", s));
/* 240 */     redondNomAss = toBoolean(valeurChamp("redondNomAss", s));
/* 241 */     videNomAss = toBoolean(valeurChamp("videNomAss", s));
/* 242 */     informProprieteMCD = toBoolean(valeurChamp("informProprieteMCD", s));
/* 243 */     heritageMult = toBoolean(valeurChamp("heritageMult", s));
/* 244 */     historiqueSave = toBoolean(valeurChamp("historiqueSave", s));
/*     */     
/* 246 */     attMajuscule = toBoolean(valeurChamp("attMajuscule", s));
/*     */     
/*     */ 
/* 249 */     cardinalite2points = toBoolean(valeurChamp("cardinalite2points", s));
/* 250 */     cardinaliteMajuscule = toBoolean(valeurChamp("cardinaliteMajuscule", s));
/* 251 */     desactiverHeritage = toBoolean(valeurChamp("desactiverHeritage", s));
/*     */     
/* 253 */     prkvisible = toBoolean(valeurChamp("prkvisible", s));
/*     */     
/*     */ 
/* 256 */     verifTypeAtt = toBoolean(valeurChamp("verifTypeAtt", s));
/* 257 */     convertTypeAtt = toBoolean(valeurChamp("convertTypeAtt", s));
/*     */     
/*     */ 
/* 260 */     SQLDefaut = valeurChamp("SQLDefaut", s);
/* 261 */     inclureCommentTableSQL = toBoolean(valeurChamp("inclureCommentTableSQL", s));
/* 262 */     inclureCommentAttSQL = toBoolean(valeurChamp("inclureCommentAttSQL", s));
/*     */     
/*     */ 
/* 265 */     developpeur = valeurChamp("developpeur", s);
/* 266 */     dateDerUse = valeurChamp("dateDerUse", s);
/*     */     
/*     */ 
/* 269 */     cleMere = toBoolean(valeurChamp("cleMere", s));
/* 270 */     cleSiNecessaireMere = toBoolean(valeurChamp("cleSiNecessaireMere", s));
/* 271 */     attMere = toBoolean(valeurChamp("attMere", s));
/* 272 */     surchargeAttMere = toBoolean(valeurChamp("surchargeAttMere", s));
/*     */     
/* 274 */     surchargeNom = toBoolean(valeurChamp("surchargeNom", s));
/* 275 */     meLaisserChoix = toBoolean(valeurChamp("meLaisserChoix", s));
/*     */     
/*     */ 
/* 278 */     proxy = toBoolean(valeurChamp("proxy", s));
/* 279 */     proxyHTTP = valeurChamp("proxyHTTP", s);
/* 280 */     proxyPort = valeurChamp("proxyPort", s);
/* 281 */     proxyLogin = valeurChamp("proxyLogin", s);
/* 282 */     proxyPassW = valeurChamp("proxyPassW", s);
/*     */     
/*     */ 
/*     */ 
/* 286 */     imprimerOrientation = valeurChamp("imprimerOrientation", s);
/* 287 */     imprimerNomMcd = toBoolean(valeurChamp("imprimerNomMcd", s));
/* 288 */     imprimerNomDev = toBoolean(valeurChamp("imprimerNomDev", s));
/* 289 */     imprimerNumPage = toBoolean(valeurChamp("imprimerNumPage", s));
/* 290 */     imprimerMargeG = valeurChamp("imprimerMargeG", s);
/* 291 */     imprimerMargeD = valeurChamp("imprimerMargeD", s);
/* 292 */     imprimerMargeH = valeurChamp("imprimerMargeH", s);
/* 293 */     imprimerMargeB = valeurChamp("imprimerMargeB", s);
/* 294 */     afficherDonation = toInteger(valeurChamp("afficherDonation", s));
/*     */     
/* 296 */     if (developpeur.trim().toUpperCase().equals("ADAM10112009")) {
/* 297 */       String dev = System.getProperty("user.name");
/* 298 */       developpeur = dev;
/* 299 */       Parametres.firstExec = true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Outil\Setting.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */