/*     */ package Merise2;
/*     */ 
/*     */ import Merise.Attribut;
/*     */ import Merise.EntiteRelation;
/*     */ import Outil.Parametres;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Attribut2
/*     */   extends Attribut
/*     */   implements Serializable
/*     */ {
/*     */   private String code;
/*     */   private String description;
/*     */   private String valeurDefaut;
/*     */   private boolean unSigned;
/*     */   private boolean afficher;
/*     */   private boolean used;
/*     */   private String depanne;
/*     */   private String colorTxt;
/*     */   private String colorFnd;
/*     */   private String aligne;
/*     */   private int tailleTxt;
/*     */   private String police;
/*     */   private String historisation;
/*     */   private String augmentation;
/*     */   private ArrayList<Historique> historique;
/*     */   protected ArrayList<Attribut> listeAttributs;
/*     */   private boolean foreingKey;
/*     */   private boolean primaryKey;
/*     */   private boolean uniqueKey;
/*     */   private boolean indexKey;
/*     */   private String clNom;
/*     */   private String clCode;
/*     */   private String clType;
/*     */   private String clTaille;
/*     */   private String clTailleDecimale;
/*     */   private String clContrainte;
/*     */   private boolean afficherCode;
/*     */   private boolean augmentationPrefix;
/*     */   private String origine;
/*     */   private String contrainte1;
/*     */   private String contrainte2;
/*     */   private String contrainte3;
/*     */   private String contrainte4;
/*     */   private String identifiant;
/*     */   
/*     */   public Attribut2(String nom, String type, int longueur, int longDecimale, String key, boolean nulle, String commentaire, EntiteRelation entiteRelation)
/*     */   {
/*  66 */     super(nom, type, longueur, longDecimale, key, nulle, commentaire, entiteRelation);
/*  67 */     this.code = (nom == null ? "" : nom.trim().toUpperCase());
/*  68 */     this.description = "";
/*  69 */     this.valeurDefaut = "";
/*  70 */     this.afficher = true;
/*  71 */     this.listeAttributs = new ArrayList();
/*  72 */     this.historique = new ArrayList();
/*  73 */     this.colorTxt = "";
/*  74 */     this.colorFnd = "";
/*  75 */     this.depanne = "";
/*  76 */     this.historique.add(Historique.getHistoriqueCreation());
/*  77 */     this.aligne = "";
/*  78 */     this.tailleTxt = 0;
/*  79 */     this.police = "";
/*  80 */     this.used = false;
/*  81 */     this.unSigned = false;
/*  82 */     this.historisation = "";
/*  83 */     this.augmentation = "";
/*  84 */     this.foreingKey = false;
/*     */     
/*  86 */     if (getLongDecimale() == 0) { setLongDecimale(-1);
/*     */     }
/*  88 */     this.primaryKey = false;
/*  89 */     this.uniqueKey = false;
/*  90 */     this.indexKey = false;
/*  91 */     this.clNom = "0000";
/*  92 */     this.clCode = "0000";
/*  93 */     this.clType = "0000";
/*  94 */     this.clTaille = "0000";
/*  95 */     this.clTailleDecimale = "0000";
/*  96 */     this.clContrainte = "";
/*     */     
/*  98 */     this.afficherCode = false;
/*  99 */     this.augmentationPrefix = false;
/* 100 */     this.origine = "";
/*     */     
/* 102 */     this.contrainte1 = "";
/* 103 */     this.contrainte2 = "";
/* 104 */     this.contrainte3 = "";
/* 105 */     this.contrainte4 = "";
/* 106 */     this.identifiant = "";
/*     */   }
/*     */   
/*     */   public Attribut2(String nom, String code, String type, int longueur, int longDecimale, String key, boolean nulle, String commentaire, EntiteRelation entiteRelation)
/*     */   {
/* 111 */     super(nom, type, longueur, longDecimale, key, nulle, commentaire, entiteRelation);
/* 112 */     this.code = (code == null ? nom.trim().toUpperCase() : code.trim().toUpperCase());
/* 113 */     this.description = "";
/* 114 */     this.valeurDefaut = "";
/* 115 */     this.afficher = true;
/* 116 */     this.listeAttributs = new ArrayList();
/* 117 */     this.historique = new ArrayList();
/* 118 */     this.colorTxt = "";
/* 119 */     this.colorFnd = "";
/* 120 */     this.depanne = "";
/* 121 */     this.historique.add(Historique.getHistoriqueCreation());
/* 122 */     this.aligne = "";
/* 123 */     this.tailleTxt = 0;
/* 124 */     this.police = "";
/* 125 */     this.used = false;
/* 126 */     this.unSigned = false;
/* 127 */     this.historisation = "";
/* 128 */     this.augmentation = "";
/* 129 */     this.foreingKey = false;
/* 130 */     if (getLongDecimale() == 0) { setLongDecimale(-1);
/*     */     }
/* 132 */     this.primaryKey = false;
/* 133 */     this.uniqueKey = false;
/* 134 */     this.indexKey = false;
/* 135 */     this.clNom = "0000";
/* 136 */     this.clCode = "0000";
/* 137 */     this.clType = "0000";
/* 138 */     this.clTaille = "0000";
/* 139 */     this.clTailleDecimale = "0000";
/* 140 */     this.clContrainte = "";
/*     */     
/* 142 */     this.afficherCode = false;
/* 143 */     this.augmentationPrefix = false;
/* 144 */     this.origine = "";
/*     */     
/* 146 */     this.contrainte1 = "";
/* 147 */     this.contrainte2 = "";
/* 148 */     this.contrainte3 = "";
/* 149 */     this.contrainte4 = "";
/* 150 */     this.identifiant = "";
/*     */   }
/*     */   
/*     */   public boolean isAfficher() {
/* 154 */     return this.afficher;
/*     */   }
/*     */   
/*     */   public boolean isUsed() {
/* 158 */     return this.used;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 162 */     return this.code;
/*     */   }
/*     */   
/*     */   public String getColorFnd() {
/* 166 */     return this.colorFnd;
/*     */   }
/*     */   
/*     */   public String getColorTxt() {
/* 170 */     return this.colorTxt;
/*     */   }
/*     */   
/*     */   public String getDepanne() {
/* 174 */     return this.depanne;
/*     */   }
/*     */   
/*     */   public String getHistorisation() {
/* 178 */     return this.historisation;
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> getHistorique() {
/* 182 */     return this.historique;
/*     */   }
/*     */   
/*     */   public boolean isUnSigned() {
/* 186 */     return this.unSigned;
/*     */   }
/*     */   
/*     */   public String getAugmentation() {
/* 190 */     return this.augmentation;
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> getListeAttributs() {
/* 194 */     return this.listeAttributs;
/*     */   }
/*     */   
/*     */   public String getAligne() {
/* 198 */     return this.aligne;
/*     */   }
/*     */   
/*     */   public void setUnSigned(boolean unSigned) {
/* 202 */     this.unSigned = unSigned;
/*     */   }
/*     */   
/*     */   public String getPolice() {
/* 206 */     return this.police;
/*     */   }
/*     */   
/*     */   public int getTailleTxt() {
/* 210 */     return this.tailleTxt;
/*     */   }
/*     */   
/*     */   public String getDescription() {
/* 214 */     return this.description;
/*     */   }
/*     */   
/*     */   public void setListeAttributs(ArrayList<Attribut> listeAttributs) {
/* 218 */     this.listeAttributs = listeAttributs;
/*     */   }
/*     */   
/*     */   public String getValeurDefaut() {
/* 222 */     return this.valeurDefaut;
/*     */   }
/*     */   
/*     */   public boolean isForeingKey() {
/* 226 */     return this.foreingKey;
/*     */   }
/*     */   
/*     */   public boolean isAfficherCode() {
/* 230 */     return this.afficherCode;
/*     */   }
/*     */   
/*     */   public boolean isAugmentationPrefix() {
/* 234 */     return this.augmentationPrefix;
/*     */   }
/*     */   
/*     */   public String getClCode() {
/* 238 */     return this.clCode;
/*     */   }
/*     */   
/*     */   public String getClContrainte() {
/* 242 */     return this.clContrainte;
/*     */   }
/*     */   
/*     */   public String getClNom() {
/* 246 */     return this.clNom;
/*     */   }
/*     */   
/*     */   public String getClTaille() {
/* 250 */     return this.clTaille;
/*     */   }
/*     */   
/*     */   public String getClType() {
/* 254 */     return this.clType;
/*     */   }
/*     */   
/*     */   public String getContrainte1() {
/* 258 */     return this.contrainte1;
/*     */   }
/*     */   
/*     */   public String getContrainte2() {
/* 262 */     return this.contrainte2;
/*     */   }
/*     */   
/*     */   public String getContrainte3() {
/* 266 */     return this.contrainte3;
/*     */   }
/*     */   
/*     */   public String getContrainte4() {
/* 270 */     return this.contrainte4;
/*     */   }
/*     */   
/*     */   public boolean isIndexKey() {
/* 274 */     return this.indexKey;
/*     */   }
/*     */   
/*     */   public String getOrigine() {
/* 278 */     return this.origine;
/*     */   }
/*     */   
/*     */   public String getClTailleDecimale() {
/* 282 */     return this.clTailleDecimale;
/*     */   }
/*     */   
/*     */   public boolean isPrimaryKey() {
/* 286 */     return this.primaryKey;
/*     */   }
/*     */   
/*     */   public boolean isUniqueKey() {
/* 290 */     return this.uniqueKey;
/*     */   }
/*     */   
/*     */   public String getIdentifiant() {
/* 294 */     return this.identifiant;
/*     */   }
/*     */   
/*     */   public void setAfficher(boolean afficher) {
/* 298 */     this.afficher = afficher;
/*     */   }
/*     */   
/*     */   public void setUsed(boolean used) {
/* 302 */     this.used = used;
/*     */   }
/*     */   
/*     */   public String getNomHistrosation() {
/* 306 */     if (getHistorisation().length() == 0) return getNom() + "";
/* 307 */     return getNom() + "  [ " + getHistorisation() + " ]";
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 311 */     this.code = code;
/*     */   }
/*     */   
/*     */   public void setColorFnd(String colorFnd) {
/* 315 */     this.colorFnd = colorFnd;
/*     */   }
/*     */   
/*     */   public void setColorTxt(String colorTxt) {
/* 319 */     this.colorTxt = colorTxt;
/*     */   }
/*     */   
/*     */   public void setDepanne(String depanne) {
/* 323 */     this.depanne = depanne;
/*     */   }
/*     */   
/*     */   public void setDescription(String description) {
/* 327 */     this.description = description;
/*     */   }
/*     */   
/*     */   public void setHistorique(ArrayList<Historique> historique) {
/* 331 */     this.historique = historique;
/*     */   }
/*     */   
/*     */   public void setHistorisation(String historisation) {
/* 335 */     this.historisation = historisation;
/* 336 */     for (int i = 0; i < this.listeAttributs.size(); i++) {
/* 337 */       Attribut2 att = (Attribut2)getListeAttributs().get(i);
/* 338 */       att.setHistorisation(historisation);
/* 339 */       setHistorisation2(att, historisation);
/*     */     }
/*     */   }
/*     */   
/*     */   private void setHistorisation2(Attribut2 a, String hist) {
/* 344 */     for (int i = 0; i < a.getListeAttributs().size(); i++) {
/* 345 */       Attribut2 att = (Attribut2)a.getListeAttributs().get(i);
/* 346 */       att.setHistorisation(hist);
/* 347 */       setHistorisation2(att, hist);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setAugmentation(String augmentation) {
/* 352 */     this.augmentation = augmentation;
/*     */   }
/*     */   
/*     */   public void setValeurDefaut(String valeurDefaut) {
/* 356 */     this.valeurDefaut = valeurDefaut;
/*     */   }
/*     */   
/*     */   public void setAligne(String aligne) {
/* 360 */     this.aligne = aligne;
/*     */   }
/*     */   
/*     */   public void setPolice(String police) {
/* 364 */     this.police = police;
/*     */   }
/*     */   
/*     */   public void setTailleTxt(int tailleTxt) {
/* 368 */     this.tailleTxt = tailleTxt;
/*     */   }
/*     */   
/*     */   public void setForeingKey(boolean foreingKey) {
/* 372 */     this.foreingKey = foreingKey;
/*     */   }
/*     */   
/*     */   public void setAfficherCode(boolean afficherCode) {
/* 376 */     this.afficherCode = afficherCode;
/*     */   }
/*     */   
/*     */   public void setAugmentationPrefix(boolean augmentationPrefix) {
/* 380 */     this.augmentationPrefix = augmentationPrefix;
/*     */   }
/*     */   
/*     */   public void setClCode(String clCode) {
/* 384 */     this.clCode = clCode;
/*     */   }
/*     */   
/*     */   public void setClContrainte(String clContrainte) {
/* 388 */     this.clContrainte = clContrainte;
/*     */   }
/*     */   
/*     */   public void setClNom(String clNom) {
/* 392 */     this.clNom = clNom;
/*     */   }
/*     */   
/*     */   public void setClTaille(String clTaille) {
/* 396 */     this.clTaille = clTaille;
/*     */   }
/*     */   
/*     */   public void setClType(String clType) {
/* 400 */     this.clType = clType;
/*     */   }
/*     */   
/*     */   public void setContrainte1(String contrainte1) {
/* 404 */     this.contrainte1 = contrainte1;
/*     */   }
/*     */   
/*     */   public void setContrainte2(String contrainte2) {
/* 408 */     this.contrainte2 = contrainte2;
/*     */   }
/*     */   
/*     */   public void setContrainte3(String contrainte3) {
/* 412 */     this.contrainte3 = contrainte3;
/*     */   }
/*     */   
/*     */   public void setContrainte4(String contrainte4) {
/* 416 */     this.contrainte4 = contrainte4;
/*     */   }
/*     */   
/*     */   public void setIndexKey(boolean indexKey) {
/* 420 */     this.indexKey = indexKey;
/*     */   }
/*     */   
/*     */   public void setOrigine(String origine) {
/* 424 */     this.origine = origine;
/*     */   }
/*     */   
/*     */   public void setPrimaryKey(boolean primaryKey) {
/* 428 */     this.primaryKey = primaryKey;
/*     */   }
/*     */   
/*     */   public void setUniqueKey(boolean uniqueKey) {
/* 432 */     this.uniqueKey = uniqueKey;
/*     */   }
/*     */   
/*     */   public void setClTailleDecimale(String clTailleDecimale) {
/* 436 */     this.clTailleDecimale = clTailleDecimale;
/*     */   }
/*     */   
/*     */   public void setIdentifiant(String identifiant) {
/* 440 */     this.identifiant = identifiant;
/*     */   }
/*     */   
/*     */   public boolean egale(Attribut2 att) {
/* 444 */     if ((getNom().trim().toUpperCase().equals(att.getNom().trim().toUpperCase())) && 
/* 445 */       (getType().trim().toUpperCase().equals(att.getType().trim().toUpperCase()))) {
/* 446 */       int nb = getListeAttributs().size() > 0 ? 1 : 0;
/* 447 */       int nbA = att.getListeAttributs().size() > 0 ? 1 : 0;
/* 448 */       if (nb == nbA) { return true;
/*     */       }
/*     */     }
/* 451 */     return false;
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> copierHistoriques(ArrayList<Historique> lhis) {
/* 455 */     ArrayList<Historique> l = new ArrayList();
/* 456 */     for (int i = 0; i < lhis.size(); i++) {
/* 457 */       l.add(((Historique)lhis.get(i)).copier());
/*     */     }
/* 459 */     return l;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void copierListeAttribut(Attribut attribut, ArrayList<Attribut> lAtt)
/*     */   {
/* 466 */     ArrayList<Attribut> l = new ArrayList();
/* 467 */     ((Attribut2)attribut).setListeAttributs(l);
/* 468 */     for (int i = 0; i < lAtt.size(); i++) {
/* 469 */       Attribut2 att = (Attribut2)((Attribut2)lAtt.get(i)).copier();
/* 470 */       l.add(att);
/* 471 */       copierListeAttribut(att, ((Attribut2)lAtt.get(i)).getListeAttributs());
/*     */     }
/*     */   }
/*     */   
/*     */   public void setKey(String key)
/*     */   {
/* 477 */     super.setKey(key);
/* 478 */     for (int i = 0; i < getListeAttributs().size(); i++) {
/* 479 */       Attribut2 a = (Attribut2)getListeAttributs().get(i);
/* 480 */       setKey(a, key);
/*     */     }
/*     */   }
/*     */   
/*     */   private void setKey(Attribut2 att, String key) {
/* 485 */     att.setKey(key);
/*     */     
/* 487 */     for (int i = 0; i < att.getListeAttributs().size(); i++) {
/* 488 */       Attribut2 a = (Attribut2)att.getListeAttributs().get(i);
/* 489 */       setKey(a, key);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setEntiteRelation(EntiteRelation entiteRelation)
/*     */   {
/* 495 */     super.setEntiteRelation(entiteRelation);
/* 496 */     for (int i = 0; i < getListeAttributs().size(); i++) {
/* 497 */       Attribut2 a = (Attribut2)getListeAttributs().get(i);
/* 498 */       setEntiteRelation(a, entiteRelation);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setEntiteRelation(Attribut2 att, EntiteRelation entiteRelation) {
/* 503 */     att.setEntiteRelation(entiteRelation);
/*     */     
/* 505 */     for (int i = 0; i < att.getListeAttributs().size(); i++) {
/* 506 */       Attribut2 a = (Attribut2)att.getListeAttributs().get(i);
/* 507 */       setEntiteRelation(a, entiteRelation);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getNombreSousAttribut() {
/* 512 */     if (this.listeAttributs.size() == 0) { return 1;
/*     */     }
/* 514 */     int nb = 1;
/*     */     
/* 516 */     for (int i = 0; i < this.listeAttributs.size(); i++) {
/* 517 */       Attribut2 att = (Attribut2)this.listeAttributs.get(i);
/* 518 */       nb += getNombreSousAttribut();
/*     */     }
/* 520 */     return nb;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getNom()
/*     */   {
/* 526 */     return super.getNom();
/*     */   }
/*     */   
/*     */   public Attribut copier()
/*     */   {
/* 531 */     Attribut2 att = new Attribut2(getNom(), getType(), getLongueur(), getLongDecimale(), getKey(), isNulle(), getCommentaire(), getEntiteRelation());
/* 532 */     att.setAfficher(isAfficher());
/* 533 */     att.setCode(this.code);
/* 534 */     att.setLongueur(getLongueur());
/* 535 */     att.setLongDecimale(getLongDecimale());
/* 536 */     att.setKey(getKey());
/* 537 */     att.setType(getType());
/* 538 */     att.setValeurDefaut(getValeurDefaut());
/* 539 */     att.setDescription(getDescription());
/* 540 */     att.setDepanne(getDepanne());
/* 541 */     att.setColorTxt(getColorTxt());
/* 542 */     att.setColorFnd(getColorFnd());
/* 543 */     att.setTailleTxt(getTailleTxt());
/* 544 */     att.setPolice(getPolice());
/* 545 */     att.setAligne(getAligne());
/* 546 */     att.setUsed(isUsed());
/* 547 */     att.setUnSigned(isUnSigned());
/* 548 */     att.setAugmentation(getAugmentation());
/* 549 */     att.setHistorisation(getHistorisation());
/*     */     
/* 551 */     att.setHistorique(copierHistoriques(getHistorique()));
/* 552 */     copierListeAttribut(att, getListeAttributs());
/* 553 */     att.setForeingKey(isForeingKey());
/*     */     
/* 555 */     att.setPrimaryKey(isPrimaryKey());
/* 556 */     att.setUniqueKey(isUniqueKey());
/* 557 */     att.setIndexKey(isIndexKey());
/* 558 */     att.setClNom(getClNom());
/* 559 */     att.setClCode(getClCode());
/* 560 */     att.setClType(getClType());
/* 561 */     att.setClTaille(getClTaille());
/* 562 */     att.setClTailleDecimale(getClTailleDecimale());
/* 563 */     att.setClContrainte(getClContrainte());
/*     */     
/* 565 */     att.setAfficherCode(isAfficherCode());
/* 566 */     att.setAugmentationPrefix(isAugmentationPrefix());
/* 567 */     att.setOrigine(getOrigine());
/*     */     
/* 569 */     att.setContrainte1(getContrainte1());
/* 570 */     att.setContrainte2(getContrainte2());
/* 571 */     att.setContrainte3(getContrainte3());
/* 572 */     att.setContrainte4(getContrainte4());
/* 573 */     att.setIdentifiant(getIdentifiant());
/*     */     
/* 575 */     return att;
/*     */   }
/*     */   
/*     */   public void ajouterModification() {
/* 579 */     Historique h = Historique.getHistoriqueModification();
/* 580 */     Historique h1 = (Historique)this.historique.get(this.historique.size() - 1);
/* 581 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur()))) {
/* 582 */       getHistorique().add(h);
/*     */     }
/*     */   }
/*     */   
/*     */   public String getConversionToString()
/*     */   {
/* 588 */     String plus = "";
/* 589 */     if (getLongueur() > 0) plus = plus + " (" + getLongueur();
/* 590 */     if (getLongDecimale() > 0) plus = plus + "," + getLongDecimale();
/* 591 */     if (getLongueur() > 0) plus = plus + ")";
/* 592 */     return getNom() + "     " + getType() + plus;
/*     */   }
/*     */   
/*     */   public String getConversionToMLDR()
/*     */   {
/* 597 */     if (getKey().equals(Parametres.Cle)) return " #" + getNom();
/* 598 */     return getNom();
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 603 */     return getNom() + "  : " + getType();
/*     */   }
/*     */   
/*     */   public static Attribut2 parseAttrinut(Attribut att) {
/* 607 */     Attribut2 a = new Attribut2(att.getNom(), att.getNom().toUpperCase(), att.getType(), att.getLongueur(), att.getLongDecimale(), att.getKey(), att.isNulle(), att.getCommentaire(), att.getEntiteRelation());
/*     */     
/*     */ 
/*     */ 
/* 611 */     a.setAfficher(true);
/* 612 */     a.setUsed(false);
/* 613 */     return a;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Merise2\Attribut2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */