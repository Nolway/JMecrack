/*     */ package IhmMLD2;
/*     */ 
/*     */ import IhmMCD.IhmEntite;
/*     */ import IhmMCD2.IhmCardinalite;
/*     */ import IhmMCD2.IhmLien2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import Merise.Entite;
/*     */ import Merise.Relation;
/*     */ import Outil.Setting;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MLDRelationLien
/*     */ {
/*     */   IhmRelation2 relation;
/*     */   ArrayList<IhmLien2> listLien;
/*  21 */   public static int RELATION_BI_11_11 = 0;
/*  22 */   public static int RELATION_BI_11_0N = 1;
/*  23 */   public static int RELATION_BI_11_1N = 2;
/*     */   
/*  25 */   public static int RELATION_BI_01_0N = 3;
/*  26 */   public static int RELATION_BI_01_1N = 4;
/*     */   
/*  28 */   public static int RELATION_BI_01_11 = 5;
/*  29 */   public static int RELATION_BI_01_01 = 6;
/*     */   
/*  31 */   public static int RELATION_BI_0N_0N = 7;
/*  32 */   public static int RELATION_BI_0N_1N = 8;
/*  33 */   public static int RELATION_BI_1N_1N = 9;
/*     */   
/*  35 */   public static int RELATION_TERNAIRE = 10;
/*     */   
/*  37 */   public static int RELATION_REFLEXIVE = 11;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  42 */   public static int RELATION_PERS_XN_01 = 21;
/*  43 */   public static int RELATION_PERS_XN_11 = 22;
/*  44 */   public static int RELATION_PERS_XN_0Y = 23;
/*  45 */   public static int RELATION_PERS_XN_1Y = 24;
/*  46 */   public static int RELATION_PERS_XN_XY = 25;
/*  47 */   public static int RELATION_PERS_XN_0N = 26;
/*  48 */   public static int RELATION_PERS_XN_1N = 27;
/*  49 */   public static int RELATION_PERS_XN_XN = 28;
/*     */   
/*  51 */   public static int RELATION_PERS_0Y_01 = 31;
/*  52 */   public static int RELATION_PERS_0Y_11 = 32;
/*  53 */   public static int RELATION_PERS_0Y_0Y = 33;
/*  54 */   public static int RELATION_PERS_0Y_1Y = 34;
/*  55 */   public static int RELATION_PERS_0Y_XY = 35;
/*  56 */   public static int RELATION_PERS_0Y_0N = 36;
/*  57 */   public static int RELATION_PERS_0Y_1N = 37;
/*     */   
/*  59 */   public static int RELATION_PERS_1Y_01 = 41;
/*  60 */   public static int RELATION_PERS_1Y_11 = 42;
/*  61 */   public static int RELATION_PERS_1Y_1Y = 43;
/*  62 */   public static int RELATION_PERS_1Y_XY = 44;
/*  63 */   public static int RELATION_PERS_1Y_0N = 45;
/*  64 */   public static int RELATION_PERS_1Y_1N = 46;
/*     */   
/*  66 */   public static int RELATION_PERS_XY_01 = 51;
/*  67 */   public static int RELATION_PERS_XY_11 = 52;
/*  68 */   public static int RELATION_PERS_XY_XY = 53;
/*  69 */   public static int RELATION_PERS_XY_0N = 54;
/*  70 */   public static int RELATION_PERS_XY_1N = 55;
/*     */   
/*     */ 
/*  73 */   public static String DISPARAITRE = "DISPARAITRE";
/*  74 */   public static String CREER = "CREER";
/*     */   
/*  76 */   public static int GROUPE_UN = 1;
/*  77 */   public static int GROUPE_DEUX = 2;
/*  78 */   public static int GROUPE_TROIS = 3;
/*  79 */   public static int GROUPE_QUATRE = 4;
/*  80 */   public static int GROUPE_CINQ = 5;
/*  81 */   public static int GROUPE_SIX = 6;
/*     */   
/*     */   int typeRelation;
/*     */   
/*     */   boolean relativeCorect;
/*     */   boolean isRelatif;
/*     */   boolean decomposable;
/*     */   boolean reflexive;
/*     */   boolean disparaitre;
/*     */   int groupeRelation;
/*     */   
/*     */   public MLDRelationLien(IhmRelation2 relation)
/*     */   {
/*  94 */     this.relation = relation;
/*  95 */     this.listLien = new ArrayList();
/*  96 */     this.typeRelation = -1;
/*  97 */     this.groupeRelation = -1;
/*     */   }
/*     */   
/*     */   public void addLien(IhmLien2 lien) {
/* 101 */     this.listLien.add(lien);
/*     */   }
/*     */   
/*     */   public boolean isRelationBinaire() {
/* 105 */     if (this.listLien.size() == 2) return true;
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   public int getIntegerCardinalite(String s) {
/* 110 */     if ((s == null) || (s.trim().length() == 0)) return 0;
/* 111 */     return Integer.parseInt(s);
/*     */   }
/*     */   
/*     */   public String getCardinalite(IhmLien2 l) {
/* 115 */     if (l.getCardinalite().trim().equals("0,n")) return "0N";
/* 116 */     if (l.getCardinalite().trim().equals("1,n")) return "1N";
/* 117 */     if (l.getCardinalite().trim().equals("0,1")) return "01";
/* 118 */     if (l.getCardinalite().trim().equals("1,1")) { return "11";
/*     */     }
/* 120 */     String c11 = l.getCardinalite();
/* 121 */     c11 = c11.replace("(", "");
/* 122 */     c11 = c11.replace(")", "");
/* 123 */     if (c11.equals("1,1")) { return "11";
/*     */     }
/* 125 */     String car1 = l.getCardinalites().getMin().toUpperCase();
/* 126 */     String car2 = l.getCardinalites().getMax().toUpperCase();
/*     */     
/* 128 */     if ((!car1.equals("0")) && (!car1.equals("1"))) {
/* 129 */       int c = getIntegerCardinalite(car1);
/* 130 */       if (c > Setting.SQLCardinaliteMax) {
/* 131 */         return "1N";
/*     */       }
/* 133 */       car1 = "X";
/*     */     }
/*     */     
/*     */ 
/* 137 */     if ((!car2.equals("N")) && (!car2.equals("1"))) {
/* 138 */       int c = getIntegerCardinalite(car2);
/* 139 */       if (c > Setting.SQLCardinaliteMax) {
/* 140 */         car2 = "N";
/*     */       } else {
/* 142 */         car2 = "Y";
/*     */       }
/*     */     }
/*     */     
/* 146 */     return car1 + car2;
/*     */   }
/*     */   
/*     */   private boolean estDecomposable() {
/* 150 */     int nb = 0;
/*     */     
/* 152 */     for (int i = 0; i < this.listLien.size(); i++) {
/* 153 */       String car = getCardinalite((IhmLien2)this.listLien.get(i));
/* 154 */       if ((car.equals("01")) || (car.equals("11"))) nb++;
/* 155 */       if ((!car.equals("01")) || (!car.equals("11")) || (!car.equals("0N")) || (!car.equals("1N"))) {
/* 156 */         return false;
/*     */       }
/* 158 */       if (nb > 1) return false;
/*     */     }
/* 160 */     if (nb == 1) return true;
/* 161 */     return false;
/*     */   }
/*     */   
/*     */   private void upDateTypeRelation() {
/* 165 */     this.typeRelation = -1;
/* 166 */     if (this.listLien.size() > 2) {
/* 167 */       this.typeRelation = RELATION_TERNAIRE;
/* 168 */       this.decomposable = estDecomposable();
/*     */     }
/* 170 */     else if (this.listLien.size() == 2) {
/* 171 */       String card1 = getCardinalite((IhmLien2)this.listLien.get(0));
/* 172 */       String card2 = getCardinalite((IhmLien2)this.listLien.get(1));
/* 173 */       String car = card1 + card2;
/*     */       
/* 175 */       if ((car.equals("110N")) || (car.equals("0N11"))) {
/* 176 */         this.typeRelation = RELATION_BI_11_0N;
/* 177 */         return;
/*     */       }
/*     */       
/* 180 */       if ((car.equals("111N")) || (car.equals("1N11"))) {
/* 181 */         this.typeRelation = RELATION_BI_11_1N;
/* 182 */         return;
/*     */       }
/*     */       
/* 185 */       if ((car.equals("010N")) || (car.equals("0N01"))) {
/* 186 */         this.typeRelation = RELATION_BI_01_0N;
/* 187 */         return;
/*     */       }
/*     */       
/* 190 */       if ((car.equals("011N")) || (car.equals("1N01"))) {
/* 191 */         this.typeRelation = RELATION_BI_01_1N;
/* 192 */         return;
/*     */       }
/*     */       
/* 195 */       if ((car.equals("0111")) || (car.equals("1101"))) {
/* 196 */         this.typeRelation = RELATION_BI_01_11;
/* 197 */         return;
/*     */       }
/*     */       
/* 200 */       if (car.equals("0101")) {
/* 201 */         this.typeRelation = RELATION_BI_01_01;
/* 202 */         return;
/*     */       }
/*     */       
/* 205 */       if (car.equals("1111")) {
/* 206 */         this.typeRelation = RELATION_BI_11_11;
/* 207 */         return;
/*     */       }
/*     */       
/* 210 */       if (car.equals("0N0N")) {
/* 211 */         this.typeRelation = RELATION_BI_0N_0N;
/* 212 */         return;
/*     */       }
/*     */       
/* 215 */       if ((car.equals("0N1N")) || (car.equals("1N0N"))) {
/* 216 */         this.typeRelation = RELATION_BI_0N_1N;
/* 217 */         return;
/*     */       }
/*     */       
/* 220 */       if (car.equals("1N1N")) {
/* 221 */         this.typeRelation = RELATION_BI_1N_1N;
/* 222 */         return;
/*     */       }
/* 224 */       getTypeRelationPersonnalisee(car);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void getTypeRelationPersonnalisee(String car)
/*     */   {
/* 231 */     if ((car.equals("XN01")) || (car.equals("01XN"))) {
/* 232 */       this.typeRelation = RELATION_PERS_XN_01;
/* 233 */       return;
/*     */     }
/*     */     
/* 236 */     if ((car.equals("XN11")) || (car.equals("11XN"))) {
/* 237 */       this.typeRelation = RELATION_PERS_XN_11;
/* 238 */       return;
/*     */     }
/*     */     
/* 241 */     if ((car.equals("XN0Y")) || (car.equals("0YXN"))) {
/* 242 */       this.typeRelation = RELATION_PERS_XN_0Y;
/* 243 */       return;
/*     */     }
/*     */     
/* 246 */     if ((car.equals("XN1Y")) || (car.equals("1YXN"))) {
/* 247 */       this.typeRelation = RELATION_PERS_XN_1Y;
/* 248 */       return;
/*     */     }
/* 250 */     if ((car.equals("XNXY")) || (car.equals("XYXN"))) {
/* 251 */       this.typeRelation = RELATION_PERS_XN_XY;
/* 252 */       return;
/*     */     }
/* 254 */     if ((car.equals("XN0N")) || (car.equals("0NXN"))) {
/* 255 */       this.typeRelation = RELATION_PERS_XN_0N;
/* 256 */       return;
/*     */     }
/* 258 */     if ((car.equals("XN1N")) || (car.equals("1NXN"))) {
/* 259 */       this.typeRelation = RELATION_PERS_XN_1N;
/* 260 */       return;
/*     */     }
/* 262 */     if (car.equals("XNXN")) {
/* 263 */       this.typeRelation = RELATION_PERS_XN_XN;
/* 264 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 269 */     if ((car.equals("0Y01")) || (car.equals("010Y"))) {
/* 270 */       this.typeRelation = RELATION_PERS_0Y_01;
/* 271 */       return;
/*     */     }
/* 273 */     if ((car.equals("0Y11")) || (car.equals("110Y"))) {
/* 274 */       this.typeRelation = RELATION_PERS_0Y_11;
/* 275 */       return;
/*     */     }
/* 277 */     if (car.equals("0Y0Y")) {
/* 278 */       this.typeRelation = RELATION_PERS_0Y_0Y;
/* 279 */       return;
/*     */     }
/* 281 */     if ((car.equals("0Y1Y")) || (car.equals("1Y0Y"))) {
/* 282 */       this.typeRelation = RELATION_PERS_0Y_1Y;
/* 283 */       return;
/*     */     }
/*     */     
/* 286 */     if ((car.equals("0YXY")) || (car.equals("XY0Y"))) {
/* 287 */       this.typeRelation = RELATION_PERS_0Y_XY;
/* 288 */       return;
/*     */     }
/*     */     
/* 291 */     if ((car.equals("0Y0N")) || (car.equals("0N0Y"))) {
/* 292 */       this.typeRelation = RELATION_PERS_0Y_0N;
/* 293 */       return;
/*     */     }
/*     */     
/* 296 */     if ((car.equals("0Y1N")) || (car.equals("1N0Y"))) {
/* 297 */       this.typeRelation = RELATION_PERS_0Y_1N;
/* 298 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 303 */     if ((car.equals("1Y01")) || (car.equals("011Y"))) {
/* 304 */       this.typeRelation = RELATION_PERS_1Y_01;
/* 305 */       return;
/*     */     }
/*     */     
/* 308 */     if ((car.equals("1Y11")) || (car.equals("111Y"))) {
/* 309 */       this.typeRelation = RELATION_PERS_1Y_11;
/* 310 */       return;
/*     */     }
/*     */     
/* 313 */     if (car.equals("1Y1Y")) {
/* 314 */       this.typeRelation = RELATION_PERS_1Y_1Y;
/* 315 */       return;
/*     */     }
/*     */     
/* 318 */     if ((car.equals("1YXY")) || (car.equals("XY1Y"))) {
/* 319 */       this.typeRelation = RELATION_PERS_1Y_XY;
/* 320 */       return;
/*     */     }
/*     */     
/* 323 */     if ((car.equals("1Y0N")) || (car.equals("0N1Y"))) {
/* 324 */       this.typeRelation = RELATION_PERS_1Y_0N;
/* 325 */       return;
/*     */     }
/* 327 */     if ((car.equals("1Y1N")) || (car.equals("1N1Y"))) {
/* 328 */       this.typeRelation = RELATION_PERS_1Y_1N;
/* 329 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 335 */     if ((car.equals("XY01")) || (car.equals("01XY"))) {
/* 336 */       this.typeRelation = RELATION_PERS_XY_01;
/* 337 */       return;
/*     */     }
/* 339 */     if ((car.equals("XY11")) || (car.equals("11XY"))) {
/* 340 */       this.typeRelation = RELATION_PERS_XY_11;
/* 341 */       return;
/*     */     }
/* 343 */     if (car.equals("XYXY")) {
/* 344 */       this.typeRelation = RELATION_PERS_XY_XY;
/* 345 */       return;
/*     */     }
/*     */     
/* 348 */     if ((car.equals("XY0N")) || (car.equals("0NXY"))) {
/* 349 */       this.typeRelation = RELATION_PERS_XY_0N;
/* 350 */       return;
/*     */     }
/* 352 */     if ((car.equals("XY1N")) || (car.equals("1NXY"))) {
/* 353 */       this.typeRelation = RELATION_PERS_XY_1N;
/* 354 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isDecomposable()
/*     */   {
/* 361 */     return this.decomposable;
/*     */   }
/*     */   
/*     */   public boolean isReflexive() {
/* 365 */     return this.reflexive;
/*     */   }
/*     */   
/*     */   public ArrayList<IhmLien2> getListLien() {
/* 369 */     return this.listLien;
/*     */   }
/*     */   
/*     */   public IhmRelation2 getRelation() {
/* 373 */     return this.relation;
/*     */   }
/*     */   
/*     */   public boolean isRelativeCorrect() {
/* 377 */     return this.relativeCorect;
/*     */   }
/*     */   
/*     */   public int getGroupeRelation() {
/* 381 */     return this.groupeRelation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isLienRelatifCorrect()
/*     */   {
/* 392 */     if (this.listLien.size() == 2) {
/* 393 */       IhmLien2 l1 = (IhmLien2)this.listLien.get(0);
/* 394 */       IhmLien2 l2 = (IhmLien2)this.listLien.get(1);
/* 395 */       if (l1.getEntite() == l2.getEntite()) return false;
/* 396 */       if ((l1.isRelatif()) && (l2.isRelatif())) { return false;
/*     */       }
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
/* 415 */       return true;
/*     */     }
/* 417 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isRelationRelatve() {
/* 421 */     for (int i = 0; i < this.listLien.size(); i++) {
/* 422 */       if (((IhmLien2)this.listLien.get(i)).isRelatif()) return true;
/*     */     }
/* 424 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isRelationReflexive() {
/* 428 */     if (this.listLien.size() != 2) return false;
/* 429 */     if (((IhmLien2)this.listLien.get(0)).getEntite() == ((IhmLien2)this.listLien.get(1)).getEntite()) { return true;
/*     */     }
/* 431 */     return false;
/*     */   }
/*     */   
/*     */   private boolean ADisparaitre() {
/* 435 */     if ((this.typeRelation == RELATION_TERNAIRE) || (getGroupeRelation() == GROUPE_UN) || (getGroupeRelation() == GROUPE_DEUX))
/*     */     {
/*     */ 
/* 438 */       return false;
/*     */     }
/*     */     
/* 441 */     if ((getGroupeRelation() == GROUPE_TROIS) || (getGroupeRelation() == GROUPE_CINQ)) {
/* 442 */       return true;
/*     */     }
/* 444 */     if ((getGroupeRelation() == GROUPE_QUATRE) || (getGroupeRelation() == GROUPE_SIX)) {
/* 445 */       if (getRelation().getDispatchKey().contains("<ACTION>" + CREER + "</ACTION>")) {
/* 446 */         return false;
/*     */       }
/* 448 */       return true;
/*     */     }
/*     */     
/* 451 */     return true;
/*     */   }
/*     */   
/*     */   private void calculeGroupe() {
/* 455 */     if ((this.typeRelation == RELATION_BI_0N_0N) || (this.typeRelation == RELATION_BI_0N_1N) || (this.typeRelation == RELATION_BI_1N_1N) || (this.typeRelation == RELATION_PERS_XN_0N) || (this.typeRelation == RELATION_PERS_XN_1N) || (this.typeRelation == RELATION_PERS_XN_XN))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 462 */       this.groupeRelation = GROUPE_UN;
/*     */     }
/*     */     
/* 465 */     if ((this.typeRelation == RELATION_PERS_0Y_0Y) || (this.typeRelation == RELATION_PERS_0Y_1Y) || (this.typeRelation == RELATION_PERS_0Y_XY) || (this.typeRelation == RELATION_PERS_1Y_1Y) || (this.typeRelation == RELATION_PERS_1Y_XY) || (this.typeRelation == RELATION_PERS_XY_XY))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 472 */       this.groupeRelation = GROUPE_DEUX;
/*     */     }
/* 474 */     if ((this.typeRelation == RELATION_BI_11_1N) || (this.typeRelation == RELATION_BI_11_0N) || (this.typeRelation == RELATION_PERS_XN_11) || (this.typeRelation == RELATION_PERS_1Y_0N) || (this.typeRelation == RELATION_PERS_1Y_1N) || (this.typeRelation == RELATION_PERS_XY_1N) || (this.typeRelation == RELATION_PERS_XY_0N) || (this.typeRelation == RELATION_PERS_XN_1Y) || (this.typeRelation == RELATION_PERS_XN_XY) || (this.typeRelation == RELATION_PERS_1Y_11) || (this.typeRelation == RELATION_PERS_0Y_11) || (this.typeRelation == RELATION_PERS_XY_11) || (this.typeRelation == RELATION_BI_01_11))
/*     */     {
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
/* 488 */       this.groupeRelation = GROUPE_TROIS;
/*     */     }
/*     */     
/* 491 */     if ((this.typeRelation == RELATION_BI_01_0N) || (this.typeRelation == RELATION_BI_01_1N) || (this.typeRelation == RELATION_PERS_XN_01) || (this.typeRelation == RELATION_PERS_0Y_0N) || (this.typeRelation == RELATION_PERS_0Y_1N) || (this.typeRelation == RELATION_PERS_XN_0Y) || (this.typeRelation == RELATION_PERS_0Y_01) || (this.typeRelation == RELATION_PERS_1Y_01) || (this.typeRelation == RELATION_PERS_XY_01))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 501 */       this.groupeRelation = GROUPE_QUATRE;
/*     */     }
/* 503 */     if (this.typeRelation == RELATION_BI_11_11) {
/* 504 */       this.groupeRelation = GROUPE_CINQ;
/*     */     }
/*     */     
/* 507 */     if (this.typeRelation == RELATION_BI_01_01) {
/* 508 */       this.groupeRelation = GROUPE_SIX;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void remplirProprietesRelation()
/*     */   {
/* 516 */     upDateTypeRelation();
/* 517 */     this.relativeCorect = isLienRelatifCorrect();
/* 518 */     calculeGroupe();
/* 519 */     this.disparaitre = ADisparaitre();
/* 520 */     this.isRelatif = isRelationRelatve();
/* 521 */     this.reflexive = isRelationReflexive();
/*     */   }
/*     */   
/*     */   public boolean isDisparaitre() {
/* 525 */     return this.disparaitre;
/*     */   }
/*     */   
/*     */   public boolean isIsRelatif() {
/* 529 */     return this.isRelatif;
/*     */   }
/*     */   
/*     */   public int getTypeRelation() {
/* 533 */     return this.typeRelation;
/*     */   }
/*     */   
/*     */   public String getListeEntite() {
/* 537 */     String s = "[";
/* 538 */     for (int i = 0; i < this.listLien.size(); i++) {
/* 539 */       s = s + "   " + ((IhmLien2)this.listLien.get(i)).getEntite().getEntite().getNom() + ":" + ((IhmLien2)this.listLien.get(i)).getCardinalite();
/*     */     }
/* 541 */     s = s + "]";
/* 542 */     return s;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 546 */     String s = "\n relation = " + this.relation.getRelation().getNom();
/* 547 */     s = s + "\n\t" + getListeEntite();
/*     */     
/* 549 */     if (this.listLien.size() == 2) {
/* 550 */       String card1 = getCardinalite((IhmLien2)this.listLien.get(0));
/* 551 */       String card2 = getCardinalite((IhmLien2)this.listLien.get(1));
/* 552 */       String car = card1 + card2;
/* 553 */       s = s + "\n\tType= " + car;
/*     */     } else {
/* 555 */       s = s + "\n\tType= Ternaire ==";
/*     */     }
/*     */     
/*     */ 
/* 559 */     return s;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMLD2\MLDRelationLien.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */