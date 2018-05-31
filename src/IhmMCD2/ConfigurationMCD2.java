/*     */ package IhmMCD2;
/*     */ 
/*     */ import Merise2.Historique;
/*     */ import Outil.ConfigSave;
/*     */ import Outil.Parametres;
/*     */ import Outil.Setting;
/*     */ import java.awt.Color;
/*     */ import java.io.Serializable;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConfigurationMCD2
/*     */   extends ConfigSave
/*     */   implements Serializable
/*     */ {
/*     */   public String nomMCD;
/*     */   public String chemin;
/*     */   public String dateDerniereSauvegarde;
/*     */   public String version;
/*     */   public String auteur;
/*     */   public String etatColor;
/*     */   public String clEntiteCadre2;
/*     */   public String clEntiteFond2;
/*     */   public String clEntiteText2;
/*     */   public String clEntiteFondTitre2;
/*     */   public String clEntiteTextTitre2;
/*     */   public String clEntiteTextType2;
/*     */   public String clEntiteTextTaille2;
/*     */   public String clEntiteTextTailleDec2;
/*     */   public String clEntiteTextCode2;
/*     */   public String clLienActiver2;
/*     */   public String clPrk2;
/*     */   public String clRelationCadre2;
/*     */   public String clRelationFond2;
/*     */   public String clRelationText2;
/*     */   public String clRelationFondTitre2;
/*     */   public String clRelationTextTitre2;
/*     */   public String clRelationTextType2;
/*     */   public String clRelationTextTaille2;
/*     */   public String clRelationTextTailleDec2;
/*     */   public String clRelationTextCode2;
/*     */   public String clLienActiverRelation2;
/*     */   public String clLien2;
/*     */   public String clLienText2;
/*     */   public String clLienNom2;
/*     */   public String clCIFCadre2;
/*     */   public String clCIFFond2;
/*     */   public String clCIFText2;
/*     */   public String clLienActiverCIF2;
/*     */   public String clLienCIF2;
/*     */   public String clLienTextCIF2;
/*     */   public String clLienNomCIF2;
/*     */   public String clLienNomCardinalite2;
/*     */   public String clLienFondCardinalite2;
/*     */   public String clContrainteCadre2;
/*     */   public String clContrainteFond2;
/*     */   public String clContrainteText2;
/*     */   public String clLienContrainte2;
/*     */   public String clLienTextContrainte2;
/*     */   public String clLienNomContrainte2;
/*     */   public String clLienActiverContainte2;
/*     */   public String clCommentaireCadre2;
/*     */   public String clCommentaireFond2;
/*     */   public String clCommentaireText2;
/*     */   public String clLienCommentaire2;
/*     */   public String clPostItCadre2;
/*     */   public String clPostItFond2;
/*     */   public String clPostItText2;
/*     */   public String clPostItPunaise2;
/*     */   public String clHeritageCadre2;
/*     */   public String clHeritageFond2;
/*     */   public String clHeritageText2;
/*     */   public String clLienActiverHeritage2;
/*     */   public String clLienFondNomHeritage2;
/*     */   public String clLienHeritage2;
/*     */   public String clLienTextHeritage2;
/*     */   public String clLienNomHeritage2;
/*     */   public String clSelected;
/*     */   public String clPage2;
/*     */   public String clOmbre2;
/* 107 */   public String alignerPostIt = "GAUCHE";
/* 108 */   public String alignerCommentaire = "GAUCHE";
/* 109 */   public String aligner = "GAUCHE";
/*     */   
/*     */   public boolean afficheType2;
/*     */   
/*     */   public boolean isOmbree2;
/*     */   
/*     */   public boolean isDegradee2;
/*     */   
/*     */   public boolean afficherPrk2;
/*     */   public boolean afficherPrkImage2;
/*     */   public boolean typeMajuscule2;
/*     */   public boolean cardinaliteMajuscule2;
/*     */   public boolean cardinalite2points2;
/*     */   public boolean arrondirEntite2;
/* 123 */   public float interLigne2 = 1.15F;
/*     */   
/*     */   public float traitEntiteRelation2;
/*     */   
/*     */   public float lienEntiteRelation2;
/*     */   
/*     */   public float traitContraintes2;
/*     */   
/*     */   public float lienContraintes2;
/*     */   
/*     */   public double zoom;
/*     */   
/*     */   public String regleGestion;
/*     */   
/*     */   public String Commentaire;
/*     */   
/*     */   public ArrayList<Historique> historique;
/*     */   
/*     */   public int xPropriete;
/*     */   
/*     */   public int yPropriete;
/*     */   public String fontMCD2;
/*     */   public int tailleFont2;
/*     */   boolean afficherCntUnique2;
/*     */   boolean afficherCntIndex2;
/*     */   boolean afficherCntCle2;
/*     */   boolean afficherCntCleEtrangere2;
/*     */   boolean afficherValDefautAtt2;
/*     */   boolean afficherCntAtt2;
/*     */   public String clCntIdxUniqCadre2;
/*     */   public String clCntIdxUniqFond2;
/*     */   public String clCntIdxUniqText2;
/*     */   public boolean MLDAfficheType2;
/*     */   public boolean MLDArrondire2;
/*     */   public boolean MLDOmbree2;
/*     */   public boolean MLDClDegradee2;
/*     */   public double MLDZoom;
/*     */   public String MLDclPage;
/*     */   
/*     */   public ConfigurationMCD2(boolean isVariable, boolean isOmbre, boolean isDegradee, String etatColor, String clEntiteCadre, String clEntiteFond, String clEntiteText, String clRelationCadre, String clRelationFond, String clRelationText, String clCIFCadre, String clCIFFond, String clCIFText, String clContrainteCadre, String clContrainteFond, String clContrainteText, String clLien, String clLienCnt, String clString)
/*     */   {
/* 164 */     super(isVariable, isOmbre, isDegradee, etatColor, clEntiteCadre, clEntiteFond, clEntiteText, clRelationCadre, clRelationFond, clRelationText, clCIFCadre, clCIFFond, clCIFText, clContrainteCadre, clContrainteFond, clContrainteText, clLien, clLienCnt, clString);
/* 165 */     setDateDerniereSauvegarde(getDateJour());
/* 166 */     this.historique = new ArrayList();
/* 167 */     this.historique.add(Historique.getHistoriqueCreation());
/* 168 */     this.xPropriete = 5;
/* 169 */     this.yPropriete = 5;
/*     */     
/* 171 */     this.fontMCD2 = "Arial";
/* 172 */     this.tailleFont2 = 12;
/*     */     
/* 174 */     this.afficherCntUnique2 = false;
/* 175 */     this.afficherCntIndex2 = false;
/* 176 */     this.afficherCntCle2 = false;
/* 177 */     this.afficherCntCleEtrangere2 = false;
/* 178 */     this.afficherValDefautAtt2 = false;
/* 179 */     this.afficherCntAtt2 = false;
/* 180 */     this.clCntIdxUniqCadre2 = getColor(Color.BLACK);
/* 181 */     this.clCntIdxUniqFond2 = getColor(Color.BLACK);
/* 182 */     this.clCntIdxUniqText2 = getColor(Color.BLACK);
/*     */   }
/*     */   
/*     */   public ConfigurationMCD2(String version, String auteur) {
/* 186 */     super(true, true, true, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
/* 187 */     this.version = Parametres.version;
/* 188 */     this.auteur = Setting.developpeur;
/* 189 */     this.historique = new ArrayList();
/* 190 */     this.historique.add(Historique.getHistoriqueCreation());
/* 191 */     this.chemin = "";
/* 192 */     this.nomMCD = "";
/* 193 */     setDateDerniereSauvegarde(getDateJour());
/* 194 */     this.xPropriete = 5;
/* 195 */     this.yPropriete = 5;
/* 196 */     this.fontMCD2 = "Arial";
/* 197 */     this.tailleFont2 = 12;
/* 198 */     this.afficherCntUnique2 = false;
/* 199 */     this.afficherCntIndex2 = false;
/* 200 */     this.afficherCntCle2 = false;
/* 201 */     this.afficherCntCleEtrangere2 = false;
/* 202 */     this.afficherValDefautAtt2 = false;
/* 203 */     this.afficherCntAtt2 = false;
/*     */     
/* 205 */     this.clCntIdxUniqCadre2 = getColor(Color.BLACK);
/* 206 */     this.clCntIdxUniqFond2 = getColor(Color.WHITE);
/* 207 */     this.clCntIdxUniqText2 = getColor(Color.BLACK);
/*     */   }
/*     */   
/*     */   public static Color getColor(String color) {
/* 211 */     return new Color(Integer.parseInt(color));
/*     */   }
/*     */   
/*     */   public static String getColor(Color color) {
/* 215 */     return color.getRGB() + "";
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> getHistorique() {
/* 219 */     return this.historique;
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/* 223 */     return this.Commentaire;
/*     */   }
/*     */   
/*     */   public String getChemin() {
/* 227 */     return this.chemin;
/*     */   }
/*     */   
/*     */   public String getNomMCD() {
/* 231 */     return this.nomMCD;
/*     */   }
/*     */   
/*     */   public String getVersion() {
/* 235 */     return this.version;
/*     */   }
/*     */   
/*     */   public void setChemin(String chemin)
/*     */   {
/* 240 */     this.chemin = chemin;
/*     */   }
/*     */   
/*     */   public void setNomMCD(String nomMCD) {
/* 244 */     this.nomMCD = nomMCD;
/*     */   }
/*     */   
/*     */   public String getDateDerniereSauvegarde() {
/* 248 */     if (this.historique.size() > 0) {
/* 249 */       this.dateDerniereSauvegarde = ((Historique)this.historique.get(this.historique.size() - 1)).getDate();
/*     */     }
/* 251 */     return this.dateDerniereSauvegarde;
/*     */   }
/*     */   
/*     */   public void setDateDerniereSauvegarde(String dateDerniereSauvegarde)
/*     */   {
/* 256 */     this.dateDerniereSauvegarde = dateDerniereSauvegarde;
/*     */   }
/*     */   
/*     */   public void addModifiactionHistorique() {
/* 260 */     Historique h = Historique.getHistoriqueModification();
/* 261 */     Historique hd = (Historique)this.historique.get(this.historique.size() - 1);
/* 262 */     if (((!hd.getDate().equals(h.getDate())) || (!hd.getAction().equals(h.getAction())) || (!hd.getDeveloppeur().equals(h.getDeveloppeur()))) && 
/* 263 */       (nombreDeJour(hd.getDate(), h.getDate()) > 0)) {
/* 264 */       this.historique.add(h);
/* 265 */       this.dateDerniereSauvegarde = h.getDate();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public String getDateDerniereModifiaction()
/*     */   {
/* 272 */     return ((Historique)this.historique.get(this.historique.size() - 1)).getDate();
/*     */   }
/*     */   
/*     */   public String getDateJour()
/*     */   {
/* 277 */     SimpleDateFormat sdfrancaise = new SimpleDateFormat("dd/MM/yyyy");
/* 278 */     Date now = new Date();
/* 279 */     return sdfrancaise.format(now);
/*     */   }
/*     */   
/*     */   private int nombreDeJour(Date d1, Date d2) {
/* 283 */     long MILLISECONDS_PER_DAY = 86400000L;
/* 284 */     long delta = d1.getTime() - d2.getTime();
/* 285 */     return (int)(delta / 86400000L);
/*     */   }
/*     */   
/*     */   private int nombreDeJour(String sd1, String sd2) {
/* 289 */     SimpleDateFormat dateFormatFr = new SimpleDateFormat("dd/MM/yyyy");
/*     */     try {
/* 291 */       Date dD = dateFormatFr.parse(sd1);
/* 292 */       Date dF = dateFormatFr.parse(sd2);
/* 293 */       int nbjour = nombreDeJour(dF, dD);
/* 294 */       long MILLISECONDS_PER_DAY = 86400000L;
/* 295 */       long delta = dF.getTime() - dD.getTime();
/* 296 */       return (int)(delta / 86400000L);
/*     */     } catch (ParseException ex) {
/* 298 */       Logger.getLogger(ConfigurationMCD2.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     
/* 301 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean isCorrectForOpen() {
/* 305 */     String dateF = getDateJour();
/* 306 */     String dateD = getDateDerniereSauvegarde();
/* 307 */     SimpleDateFormat dateFormatFr = new SimpleDateFormat("dd/MM/yyyy");
/*     */     try
/*     */     {
/* 310 */       Date dD = dateFormatFr.parse(dateD);
/* 311 */       Date dF = dateFormatFr.parse(dateF);
/* 312 */       int nbjour = nombreDeJour(dF, dD);
/* 313 */       if (nbjour < -2) return false;
/*     */     }
/*     */     catch (ParseException ex) {
/* 316 */       Logger.getLogger(ConfigurationMCD2.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     
/*     */ 
/* 320 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isCorrectForSave1()
/*     */   {
/* 325 */     String dateJour = getDateJour();
/* 326 */     SimpleDateFormat dateFormatFr = new SimpleDateFormat("dd/MM/yyyy");
/*     */     
/*     */     try
/*     */     {
/* 330 */       Date dj = dateFormatFr.parse(dateJour);
/* 331 */       int nbjour = nombreDeJour(dj, Parametres.dateExec);
/* 332 */       if (nbjour < -1) {
/* 333 */         return false;
/*     */       }
/*     */     }
/*     */     catch (ParseException ex) {
/* 337 */       Logger.getLogger(ConfigurationMCD2.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     
/* 340 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isCorrectForSave2()
/*     */   {
/* 345 */     addModifiactionHistorique();
/* 346 */     String dateModif = getDateDerniereModifiaction();
/* 347 */     SimpleDateFormat dateFormatFr = new SimpleDateFormat("dd/MM/yyyy");
/*     */     
/*     */     try
/*     */     {
/* 351 */       Date dM = dateFormatFr.parse(dateModif);
/* 352 */       int nbjour = nombreDeJour(dM, Parametres.dateExec);
/* 353 */       if (nbjour < -3) {
/* 354 */         return false;
/*     */       }
/*     */     }
/*     */     catch (ParseException ex) {
/* 358 */       Logger.getLogger(ConfigurationMCD2.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */     
/* 361 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\ConfigurationMCD2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */