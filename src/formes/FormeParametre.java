/*     */ package formes;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import ihm.Principale;
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FormeParametre
/*     */   implements Serializable
/*     */ {
/*     */   private String version;
/*     */   private String ass_ivdha;
/*     */   private String ass_ifuk;
/*     */   private String ass_ukhadim;
/*     */   private String thassarouts;
/*     */   private String ass_i_active;
/*     */   private String vavis;
/*     */   private String achehal_wussan;
/*     */   private String ach_hal_ikhadamen;
/*     */   private String commentaire1;
/*     */   private String commentaire2;
/*     */   private String commentaire3;
/*     */   private String commentaire4;
/*     */   private String commentaire5;
/*     */   private String commentaire6;
/*     */   private String commentaire7;
/*     */   private String commentaire8;
/*     */   private String commentaire9;
/*     */   private String commentaire10;
/*     */   private transient Principale frm;
/*     */   
/*     */   public FormeParametre()
/*     */   {
/*  42 */     this.ass_ivdha = "";
/*  43 */     this.ass_ifuk = "";
/*  44 */     this.ass_ukhadim = "";
/*  45 */     this.thassarouts = "";
/*  46 */     this.ass_i_active = "";
/*  47 */     this.vavis = "";
/*  48 */     this.achehal_wussan = "";
/*  49 */     this.ach_hal_ikhadamen = "";
/*  50 */     this.commentaire1 = "";
/*  51 */     this.commentaire2 = "";
/*  52 */     this.commentaire3 = "";
/*  53 */     this.commentaire4 = "";
/*  54 */     this.commentaire5 = "";
/*  55 */     this.commentaire6 = "";
/*  56 */     this.commentaire7 = "";
/*  57 */     this.commentaire8 = "";
/*  58 */     this.commentaire9 = "";
/*  59 */     this.commentaire10 = "";
/*  60 */     this.version = Parametres.version;
/*     */   }
/*     */   
/*     */   private static String toString(boolean b) {
/*  64 */     if (b) return "true";
/*  65 */     return "false";
/*     */   }
/*     */   
/*     */   private static boolean toBoolean(String b) {
/*  69 */     if (b.equals("true")) return true;
/*  70 */     return false;
/*     */   }
/*     */   
/*     */   public static String valeurChamp(String ch, String settin) {
/*  74 */     String s = settin.substring(settin.indexOf(ch));
/*  75 */     s = s.substring(s.indexOf(">") + 1);
/*  76 */     s = s.substring(0, s.indexOf("<"));
/*  77 */     return s.trim();
/*     */   }
/*     */   
/*     */   public String getAch_hal_ikhadamen() {
/*  81 */     return this.ach_hal_ikhadamen;
/*     */   }
/*     */   
/*     */   public String getAchehal_wussan() {
/*  85 */     return this.achehal_wussan;
/*     */   }
/*     */   
/*     */   public String getAss_i_active() {
/*  89 */     return this.ass_i_active;
/*     */   }
/*     */   
/*     */   public String getAss_ifuk() {
/*  93 */     return this.ass_ifuk;
/*     */   }
/*     */   
/*     */   public String getAss_ivdha() {
/*  97 */     return this.ass_ivdha;
/*     */   }
/*     */   
/*     */   public String getAss_ukhadim() {
/* 101 */     return this.ass_ukhadim;
/*     */   }
/*     */   
/*     */   public String getCommentaire1() {
/* 105 */     return this.commentaire1;
/*     */   }
/*     */   
/*     */   public String getCommentaire10() {
/* 109 */     return this.commentaire10;
/*     */   }
/*     */   
/*     */   public String getCommentaire2() {
/* 113 */     return this.commentaire2;
/*     */   }
/*     */   
/*     */   public String getCommentaire3() {
/* 117 */     return this.commentaire3;
/*     */   }
/*     */   
/*     */   public String getCommentaire4() {
/* 121 */     return this.commentaire4;
/*     */   }
/*     */   
/*     */   public String getCommentaire5() {
/* 125 */     return this.commentaire5;
/*     */   }
/*     */   
/*     */   public String getCommentaire6() {
/* 129 */     return this.commentaire6;
/*     */   }
/*     */   
/*     */   public String getCommentaire7() {
/* 133 */     return this.commentaire7;
/*     */   }
/*     */   
/*     */   public String getCommentaire8() {
/* 137 */     return this.commentaire8;
/*     */   }
/*     */   
/*     */   public String getCommentaire9() {
/* 141 */     return this.commentaire9;
/*     */   }
/*     */   
/*     */   public String getThassarouts() {
/* 145 */     return this.thassarouts;
/*     */   }
/*     */   
/*     */   public String getVavis() {
/* 149 */     return this.vavis;
/*     */   }
/*     */   
/*     */   public Principale getFrm() {
/* 153 */     return this.frm;
/*     */   }
/*     */   
/*     */   public String getVersion() {
/* 157 */     return this.version;
/*     */   }
/*     */   
/*     */   public void setAch_hal_ikhadamen(String ach_hal_ikhadamen) {
/* 161 */     this.ach_hal_ikhadamen = ach_hal_ikhadamen;
/*     */   }
/*     */   
/*     */   public void setAchehal_wussan(String achehal_wussan) {
/* 165 */     this.achehal_wussan = achehal_wussan;
/*     */   }
/*     */   
/*     */   public void setAss_i_active(String ass_i_active) {
/* 169 */     this.ass_i_active = ass_i_active;
/*     */   }
/*     */   
/*     */   public void setAss_ifuk(String ass_ifuk) {
/* 173 */     this.ass_ifuk = ass_ifuk;
/*     */   }
/*     */   
/*     */   public void setAss_ivdha(String ass_ivdha) {
/* 177 */     this.ass_ivdha = ass_ivdha;
/*     */   }
/*     */   
/*     */   public void setAss_ukhadim(String ass_ukhadim) {
/* 181 */     this.ass_ukhadim = ass_ukhadim;
/*     */   }
/*     */   
/*     */   public void setCommentaire1(String commentaire1) {
/* 185 */     this.commentaire1 = commentaire1;
/*     */   }
/*     */   
/*     */   public void setCommentaire10(String commentaire10) {
/* 189 */     this.commentaire10 = commentaire10;
/*     */   }
/*     */   
/*     */   public void setCommentaire2(String commentaire2) {
/* 193 */     this.commentaire2 = commentaire2;
/*     */   }
/*     */   
/*     */   public void setCommentaire3(String commentaire3) {
/* 197 */     this.commentaire3 = commentaire3;
/*     */   }
/*     */   
/*     */   public void setCommentaire4(String commentaire4) {
/* 201 */     this.commentaire4 = commentaire4;
/*     */   }
/*     */   
/*     */   public void setVersion(String version) {
/* 205 */     this.version = version;
/*     */   }
/*     */   
/*     */   public void setCommentaire5(String commentaire5) {
/* 209 */     this.commentaire5 = commentaire5;
/*     */   }
/*     */   
/*     */   public void setCommentaire6(String commentaire6) {
/* 213 */     this.commentaire6 = commentaire6;
/*     */   }
/*     */   
/*     */   public void setCommentaire7(String commentaire7) {
/* 217 */     this.commentaire7 = commentaire7;
/*     */   }
/*     */   
/*     */   public void setCommentaire8(String commentaire8) {
/* 221 */     this.commentaire8 = commentaire8;
/*     */   }
/*     */   
/*     */   public void setCommentaire9(String commentaire9) {
/* 225 */     this.commentaire9 = commentaire9;
/*     */   }
/*     */   
/*     */   public void setThassarouts(String thassarouts) {
/* 229 */     this.thassarouts = thassarouts;
/*     */   }
/*     */   
/*     */   public void setVavis(String vavis) {
/* 233 */     this.vavis = vavis;
/*     */   }
/*     */   
/*     */   public void setFrm(Principale frm) {
/* 237 */     this.frm = frm;
/*     */   }
/*     */   
/*     */   private void miseAJourFormeParametre(FormeParametre p)
/*     */   {
/* 242 */     p.setCommentaire1("24");
/* 243 */     p.setCommentaire10("32");
/* 244 */     p.setCommentaire2("1110001");
/* 245 */     p.setCommentaire3("123342");
/* 246 */     p.setCommentaire4("AZECEC34D-ZEaz-QDQsd-SDF");
/* 247 */     p.setCommentaire5("zgte000546");
/* 248 */     p.setCommentaire6("dsfçsdf0000-sdf");
/* 249 */     p.setCommentaire7("sxcxvcbgdr-ert-ertert-ertertert-er12");
/* 250 */     p.setCommentaire8("nngtezer-zerzengfjd-66734-ZERr-");
/* 251 */     p.setCommentaire9("567HHHYR-ZTRU-ZER-rrrr-zer-098");
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
/*     */   public String parametresToString()
/*     */   {
/* 279 */     String s = "<NOTE>Toutes modifications de ce fichier entraine un dysfonctionnement de JMeriseVous serez le seul responsable des desagrements occasionnes</NOTE><ABOUT><NAME> JMerise</NAME><OWNER> MESSOUCI</OWNER><VERSION>" + Parametres.version + "</VERSION>" + "<CREATION> 08/11/2011" + "</CREATION>" + "<MODIF> 02/05/2017" + "</MODIF>" + "</ABOUT>" + "<PARAM>" + "<P1>" + getAch_hal_ikhadamen() + "</P1>" + "<P2>" + getAchehal_wussan() + "</P2>" + "<P3>" + getAss_i_active() + "</P3>" + "<P4>" + getAss_ifuk() + "</P4>" + "<P5>" + getAss_ivdha() + "</P5>" + "<P6>" + getAss_ukhadim() + "</P6>" + "<P7>" + getCommentaire1() + "</P7>" + "<P8>" + getCommentaire10() + "</P8>" + "<P9>" + getCommentaire2() + "</P9>" + "<P10>" + getCommentaire3() + "</P10>" + "<P11>" + getCommentaire4() + "</P11>" + "<P12>" + getCommentaire5() + "</P12>" + "<P13>" + getCommentaire6() + "</P13>" + "<P14>" + getCommentaire7() + "</P14>" + "<P15>" + getCommentaire8() + "</P15>" + "<P16>" + getCommentaire9() + "</P16>" + "<P17>" + getThassarouts() + "</P17>" + "<P18>" + getVavis() + "</P18>" + "</PARAM>";
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
/* 351 */     return s;
/*     */   }
/*     */   
/*     */   public static FormeParametre stringToParametres(String s) {
/* 355 */     FormeParametre p = new FormeParametre();
/* 356 */     p.setVersion(valeurChamp("VERSION", s));
/* 357 */     p.setAch_hal_ikhadamen(valeurChamp("P1", s));
/* 358 */     p.setAchehal_wussan(valeurChamp("P2", s));
/* 359 */     p.setAss_i_active(valeurChamp("P3", s));
/* 360 */     p.setAss_ifuk(valeurChamp("P4", s));
/* 361 */     p.setAss_ivdha(valeurChamp("P5", s));
/* 362 */     p.setAss_ukhadim(valeurChamp("P6", s));
/* 363 */     p.setCommentaire1(valeurChamp("P7", s));
/* 364 */     p.setCommentaire10(valeurChamp("P8", s));
/* 365 */     p.setCommentaire2(valeurChamp("P9", s));
/* 366 */     p.setCommentaire3(valeurChamp("P10", s));
/* 367 */     p.setCommentaire4(valeurChamp("P11", s));
/* 368 */     p.setCommentaire5(valeurChamp("P12", s));
/* 369 */     p.setCommentaire6(valeurChamp("P13", s));
/* 370 */     p.setCommentaire7(valeurChamp("P14", s));
/* 371 */     p.setCommentaire8(valeurChamp("P15", s));
/* 372 */     p.setCommentaire9(valeurChamp("P16", s));
/* 373 */     p.setThassarouts(valeurChamp("P17", s));
/* 374 */     p.setVavis(valeurChamp("P18", s));
/* 375 */     return p;
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
/*     */   public String toString()
/*     */   {
/* 406 */     String s = this.version + "\n" + this.ass_ivdha + "\n" + this.ass_ifuk + "\n" + this.ass_ukhadim + "\n" + this.thassarouts + "\n" + this.ass_i_active + "\n" + this.vavis + "\n" + this.achehal_wussan + "\n" + this.ach_hal_ikhadamen + "\n" + this.commentaire1 + "\n" + this.commentaire2 + "\n" + this.commentaire3 + "\n" + this.commentaire4 + "\n" + this.commentaire5 + "\n" + this.commentaire6 + "\n" + this.commentaire7 + "\n" + this.commentaire8 + "\n" + this.commentaire9 + "\n" + this.commentaire10 + "\n";
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
/* 423 */     return s;
/*     */   }
/*     */   
/*     */   public static int jour(Date d1, Date d2) {
/* 427 */     long MILLISECONDS_PER_DAY = 86400000L;
/* 428 */     long delta = d1.getTime() - d2.getTime();
/* 429 */     return (int)(delta / 86400000L);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeParametre.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */