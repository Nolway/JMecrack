/*     */ package input;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import Outil.Setting;
/*     */ import Output.SQLOutil;
/*     */ import Thasaruts.Thassarut;
/*     */ import formes.FormeParametre;
/*     */ import ihm.Principale;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ActivityDay
/*     */ {
/*     */   public static int nombreDeJour(Date d1, Date d2)
/*     */   {
/*  21 */     long MILLISECONDS_PER_DAY = 86400000L;
/*  22 */     long delta = d1.getTime() - d2.getTime();
/*  23 */     return (int)(delta / 86400000L);
/*     */   }
/*     */   
/*     */   public static String getURLActivity2(Principale principale) {
/*  27 */     String s = "";
/*  28 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
/*     */     
/*  30 */     SimpleDateFormat fjour = new SimpleDateFormat("dd");
/*     */     
/*  32 */     Date dDerUse = new Date(Setting.licence.getAss_ukhadim());
/*  33 */     Date dValiditeF = new Date(Setting.licence.getAss_ifuk());
/*     */     
/*  35 */     int numJDUse = Integer.parseInt(fjour.format(dDerUse));
/*  36 */     String os = System.getProperty("os.name");
/*  37 */     String langue = System.getProperty("user.language");
/*  38 */     String version = Parametres.version;
/*  39 */     String devel = Setting.developpeur;
/*     */     
/*  41 */     os = SQLOutil.remplaceChar(os);
/*  42 */     langue = SQLOutil.remplaceChar(langue);
/*  43 */     version = SQLOutil.remplaceChar(version);
/*  44 */     devel = SQLOutil.remplaceChar(devel);
/*  45 */     String m = Parametres.getMac();
/*     */     
/*  47 */     s = "http://www.jfreesoft.com/activityDay0392.php?k=" + Setting.licence.getAchehal_wussan() + "&p=" + numJDUse + "&dev=" + devel + "&d=" + sdf.format(dDerUse) + "&d2=" + sdf.format(dValiditeF) + "&v=" + version + "&os=" + os + "&l=" + langue + "&m=" + m;
/*  48 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */   public static String getURLActivity(FormeParametre pF, Principale principale)
/*     */   {
/*  54 */     String s = "";
/*  55 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
/*     */     
/*  57 */     SimpleDateFormat fjour = new SimpleDateFormat("dd");
/*     */     
/*  59 */     Date dDerUse = new Date(pF.getAss_ukhadim());
/*  60 */     Date dValiditeF = new Date(pF.getAss_ifuk());
/*     */     
/*  62 */     int numJDUse = Integer.parseInt(fjour.format(dDerUse));
/*  63 */     String os = System.getProperty("os.name");
/*  64 */     String langue = System.getProperty("user.language");
/*  65 */     String version = Parametres.version;
/*  66 */     String devel = Setting.developpeur;
/*     */     
/*  68 */     os = SQLOutil.remplaceChar(os);
/*  69 */     langue = SQLOutil.remplaceChar(langue);
/*  70 */     version = SQLOutil.remplaceChar(version);
/*  71 */     devel = SQLOutil.remplaceChar(devel);
/*  72 */     String m = Parametres.getMac();
/*     */     
/*  74 */     s = "http://www.jfreesoft.com/activityDay0392.php?k=" + pF.getAchehal_wussan() + "&p=" + numJDUse + "&dev=" + devel + "&d=" + sdf.format(dDerUse) + "&d2=" + sdf.format(dValiditeF) + "&v=" + version + "&os=" + os + "&l=" + langue + "&m=" + m;
/*  75 */     return s;
/*     */   }
/*     */   
/*     */   public static String getURLDontion(FormeParametre pF, Principale principale) {
/*  79 */     String s = "";
/*  80 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
/*     */     
/*  82 */     SimpleDateFormat fjour = new SimpleDateFormat("dd");
/*     */     
/*  84 */     Date dDerUse = new Date(pF.getAss_ukhadim());
/*  85 */     Date dValiditeF = new Date(pF.getAss_ifuk());
/*     */     
/*  87 */     int numJDUse = Integer.parseInt(fjour.format(dDerUse));
/*  88 */     String os = System.getProperty("os.name");
/*  89 */     String langue = System.getProperty("user.language");
/*  90 */     String version = Parametres.version;
/*  91 */     String devel = Setting.developpeur;
/*     */     
/*  93 */     os = SQLOutil.remplaceChar(os);
/*  94 */     langue = SQLOutil.remplaceChar(langue);
/*  95 */     version = SQLOutil.remplaceChar(version);
/*  96 */     devel = SQLOutil.remplaceChar(devel);
/*  97 */     String m = Parametres.getMac();
/*     */     
/*  99 */     s = "http://www.jfreesoft.com/tentedon.php?k=" + pF.getAchehal_wussan() + "&p=" + numJDUse + "&dev=" + devel + "&d=" + sdf.format(dDerUse) + "&d2=" + sdf.format(dValiditeF) + "&v=" + version + "&os=" + os + "&l=" + langue + "&m=" + m;
/* 100 */     return s;
/*     */   }
/*     */   
/*     */   public static String getURLIncreaseMCD(FormeParametre pF, Principale principale, String id) {
/* 104 */     String s = "";
/* 105 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
/*     */     
/* 107 */     SimpleDateFormat fjour = new SimpleDateFormat("dd");
/*     */     
/* 109 */     Date dDerUse = new Date(pF.getAss_ukhadim());
/* 110 */     Date dValiditeF = new Date(pF.getAss_ifuk());
/*     */     
/* 112 */     int numJDUse = Integer.parseInt(fjour.format(dDerUse));
/* 113 */     String os = System.getProperty("os.name");
/* 114 */     String langue = System.getProperty("user.language");
/* 115 */     String version = Parametres.version;
/* 116 */     String devel = Setting.developpeur;
/*     */     
/* 118 */     os = SQLOutil.remplaceChar(os);
/* 119 */     langue = SQLOutil.remplaceChar(langue);
/* 120 */     version = SQLOutil.remplaceChar(version);
/* 121 */     devel = SQLOutil.remplaceChar(devel);
/* 122 */     String m = Parametres.getMac();
/* 123 */     s = "http://www.jfreesoft.com/increase.php?k=" + pF.getAchehal_wussan() + "&p=" + numJDUse + "&dev=" + devel + "&d=" + sdf.format(dDerUse) + "&d2=" + sdf.format(dValiditeF) + "&v=" + version + "&os=" + os + "&l=" + langue + "&m=" + m + "&id=" + id;
/*     */     
/* 125 */     return s;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\input\ActivityDay.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */