/*     */ package Output;
/*     */ 
/*     */ import Contrainte.AttributReference;
/*     */ import Contrainte.TableReference;
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMLD.IhmPageMLD;
/*     */ import IhmMLD2.MLDEntite2;
/*     */ import Merise.Attribut;
/*     */ import Merise.Domaine;
/*     */ import Merise2.Attribut2;
/*     */ import Outil.Parametres;
/*     */ import Outil.Setting;
/*     */ import ihm.Principale;
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
/*     */ public class SQLServer
/*     */ {
/*  26 */   private static String index = "";
/*  27 */   private static String indexEnt = "";
/*  28 */   private static String uniq = "";
/*     */   
/*     */ 
/*     */   private static boolean isDomaine(Attribut att, IhmPageMCD page)
/*     */   {
/*  33 */     ArrayList<Domaine> list = page.getListeDomaine();
/*  34 */     for (int i = 0; i < list.size(); i++) {
/*  35 */       if (att.getType().trim().toUpperCase().equals(((Domaine)list.get(i)).getNom().trim().toUpperCase()))
/*  36 */         return true;
/*     */     }
/*  38 */     return false;
/*     */   }
/*     */   
/*     */   private static String remplacerType(Attribut att) {
/*  42 */     String t = "";
/*  43 */     String type = att.getType();
/*  44 */     String nul = att.isNulle() ? " " : " NOT NULL";
/*     */     
/*  46 */     if (att.getKey().equals(Parametres.Cle)) { nul = " NOT NULL";
/*     */     }
/*  48 */     else if (att.getKey().equals(Parametres.Index)) { nul = " NOT NULL";
/*     */     }
/*  50 */     else if (att.getKey().equals(Parametres.Unique)) { nul = " NOT NULL";
/*     */     }
/*     */     
/*     */ 
/*  54 */     if (type.trim().toUpperCase().equals("AUTO_INCREMENT")) {
/*  55 */       t = "INT IDENTITY (1,1) NOT NULL";
/*     */     }
/*  57 */     if (type.trim().toUpperCase().equals("VARCHAR")) {
/*  58 */       t = "VARCHAR (" + att.getLongueur() + ")" + nul;
/*     */     }
/*  60 */     if (type.trim().toUpperCase().equals("INTEGER")) {
/*  61 */       t = "INT " + nul;
/*     */     }
/*     */     
/*  64 */     if (type.trim().toUpperCase().equals("FLOAT")) {
/*  65 */       t = "FLOAT " + nul;
/*     */     }
/*     */     
/*  68 */     if (type.trim().toUpperCase().equals("BLOB")) {
/*  69 */       t = "VARBINARY(MAX) " + nul;
/*     */     }
/*  71 */     if (type.trim().toUpperCase().equals("DECIMAL")) {
/*  72 */       t = "DECIMAL (" + att.getLongueur() + "," + att.getLongDecimale() + ") " + nul;
/*     */     }
/*     */     
/*  75 */     if (type.trim().toUpperCase().equals("MONEY")) {
/*  76 */       t = "MONEY " + nul;
/*     */     }
/*     */     
/*  79 */     if (type.trim().toUpperCase().equals("DOUBLE PRECISION")) {
/*  80 */       t = "DOUBLE PRECISION " + nul;
/*     */     }
/*  82 */     if (type.trim().toUpperCase().equals("NUMERIC")) {
/*  83 */       t = "NUMERIC (" + att.getLongueur() + "," + att.getLongDecimale() + ") " + nul;
/*     */     }
/*  85 */     if (type.trim().toUpperCase().equals("SMALLINT")) {
/*  86 */       t = "SMALLINT " + nul;
/*     */     }
/*  88 */     if (type.trim().toUpperCase().equals("CHAR")) {
/*  89 */       t = "CHAR (" + att.getLongueur() + ") " + nul;
/*     */     }
/*  91 */     if (type.trim().toUpperCase().equals("DATE")) {
/*  92 */       t = "DATETIME" + nul;
/*     */     }
/*  94 */     if (type.trim().toUpperCase().equals("BOOL")) {
/*  95 */       t = "bit " + nul;
/*     */     }
/*  97 */     if (type.trim().toUpperCase().equals("INT")) {
/*  98 */       t = "INT " + nul;
/*     */     }
/* 100 */     if (type.trim().toUpperCase().equals("DATETIME")) {
/* 101 */       t = "DATETIME " + nul;
/*     */     }
/*     */     
/* 104 */     if (type.trim().toUpperCase().equals("DOUBLE")) {
/* 105 */       t = "REAL " + nul;
/*     */     }
/* 107 */     if (type.trim().toUpperCase().equals("LONGBLOB")) {
/* 108 */       t = "VARBINARY(MAX) " + nul;
/*     */     }
/* 110 */     if (type.trim().toUpperCase().equals("LONGTEXT")) {
/* 111 */       t = "TEXT " + nul;
/*     */     }
/*     */     
/* 114 */     if (type.trim().toUpperCase().equals("MEDIUMBLOB")) {
/* 115 */       t = "VARBINARY(MAX) " + nul;
/*     */     }
/* 117 */     if (type.trim().toUpperCase().equals("MEDIUMINT")) {
/* 118 */       t = "INT " + nul;
/*     */     }
/* 120 */     if (type.trim().toUpperCase().equals("MEDIUMTEXT")) {
/* 121 */       t = " TEXT " + nul;
/*     */     }
/* 123 */     if (type.trim().toUpperCase().equals("REAL")) {
/* 124 */       t = "REAL " + nul;
/*     */     }
/*     */     
/* 127 */     if (type.trim().toUpperCase().equals("TEXT")) {
/* 128 */       t = "TEXT " + nul;
/*     */     }
/*     */     
/* 131 */     if (type.trim().toUpperCase().equals("TIME")) {
/* 132 */       t = "TIME (2)" + nul;
/*     */     }
/*     */     
/* 135 */     if (type.trim().toUpperCase().equals("TIMESTAMP")) {
/* 136 */       t = "DATETIME" + nul;
/*     */     }
/* 138 */     if (type.trim().toUpperCase().equals("TINYBLOB")) {
/* 139 */       t = "VARBINARY(MAX) " + nul;
/*     */     }
/* 141 */     if (type.trim().toUpperCase().equals("TINYINT")) {
/* 142 */       t = "TINYINT " + nul;
/*     */     }
/* 144 */     if (type.trim().toUpperCase().equals("TINYTEXT")) {
/* 145 */       t = "TEXT " + nul;
/*     */     }
/* 147 */     if (type.trim().toUpperCase().equals("YEAR")) {
/* 148 */       t = "INT " + nul;
/*     */     }
/*     */     
/* 151 */     return t;
/*     */   }
/*     */   
/*     */   private static String SQLDomaine(Domaine d, String att)
/*     */   {
/* 156 */     String s = "";
/* 157 */     for (int i = 0; i < d.getListeValeurs().size(); i++) {
/* 158 */       s = s + "\"" + (String)d.getListeValeurs().get(i) + "\"";
/* 159 */       if (i + 1 < d.getListeValeurs().size()) {
/* 160 */         s = s + ",";
/*     */       }
/*     */     }
/* 163 */     if (s.length() > 0) {
/* 164 */       s = "TEXT CHECK (" + att + " IN (" + s + ")) ";
/*     */     }
/* 166 */     return s;
/*     */   }
/*     */   
/*     */   private static String SQLGetTypeEnum(Attribut attr, String type, IhmPageMCD page) {
/* 170 */     String s = "";
/* 171 */     ArrayList<Domaine> list = page.getListeDomaine();
/* 172 */     Domaine d = null;
/* 173 */     String nul = attr.isNulle() ? " " : " NOT NULL ";
/* 174 */     for (int i = 0; i < list.size(); i++) {
/* 175 */       if (type.equals(((Domaine)list.get(i)).getNom())) {
/* 176 */         d = (Domaine)list.get(i);
/* 177 */         break;
/*     */       }
/*     */     }
/* 180 */     if (d != null) {
/* 181 */       s = SQLDomaine(d, attr.getNom());
/*     */     }
/* 183 */     return s;
/*     */   }
/*     */   
/*     */   private static String getType(Attribut att, IhmPageMCD page)
/*     */   {
/* 188 */     if (isDomaine(att, page)) {
/* 189 */       String ss = SQLGetTypeEnum(att, att.getType(), page);
/* 190 */       return ss;
/*     */     }
/* 192 */     return remplacerType(att);
/*     */   }
/*     */   
/*     */ 
/*     */   private static String ajusterNom(String nom, int tailMax)
/*     */   {
/* 198 */     nom = SQLOutil.remplaceChar(nom);
/* 199 */     for (int i = nom.length(); i < tailMax; i++) {
/* 200 */       nom = nom + " ";
/*     */     }
/* 202 */     return nom;
/*     */   }
/*     */   
/*     */   private static int longueurMaxAttribut(ArrayList<Attribut> listeAttributs) {
/* 206 */     int max = 0;
/*     */     
/*     */ 
/* 209 */     for (int i = 0; i < listeAttributs.size(); i++) {
/* 210 */       Attribut2 att = (Attribut2)listeAttributs.get(i);
/* 211 */       String nom; if (Setting.SQLUtiliserCode) {
/* 212 */         nom = att.getCode();
/*     */       } else {
/* 214 */         nom = att.getNom();
/*     */       }
/* 216 */       if (nom.length() > max) {
/* 217 */         max = nom.length();
/*     */       }
/*     */     }
/* 220 */     return max + 2;
/*     */   }
/*     */   
/*     */   private static String SQLAttribut(Attribut att, String tab, IhmPageMCD page, int lg) {
/* 224 */     String s = "";
/* 225 */     String cle = "";
/*     */     
/*     */     String nomAtt;
/* 229 */     if (Setting.SQLUtiliserCode) {
/* 230 */       nomAtt = ((Attribut2)att).getCode();
/*     */     } else {
/* 232 */       nomAtt = att.getNom();
/*     */     }
/*     */     
/* 235 */     if (att.getKey().equals(Parametres.Unique)) {
/* 236 */       if (uniq.trim().length() == 0) uniq = nomAtt; else {
/* 237 */         uniq = uniq + "," + nomAtt;
/*     */       }
/*     */     }
/* 240 */     if (att.getKey().equals(Parametres.Index)) {
/* 241 */       if (indexEnt.trim().length() == 0) indexEnt = SQLOutil.remplaceChar(nomAtt); else {
/* 242 */         indexEnt = indexEnt + "," + SQLOutil.remplaceChar(nomAtt);
/*     */       }
/*     */     }
/* 245 */     if (isDomaine(att, page)) cle = "";
/* 246 */     s = s + ajusterNom(nomAtt, lg) + " " + getType(att, page) + " " + cle;
/* 247 */     return s;
/*     */   }
/*     */   
/*     */   private static String SQLGetKey(MLDEntite2 ent, String nomTab) {
/* 251 */     String s = "";
/*     */     ArrayList<Attribut> listeAttribut;
/* 254 */     if (ent.isComposer()) {
/* 255 */       listeAttribut = SQLOutil.decomposerLesAttributsMLDEntite(ent);
/*     */     } else {
/* 257 */       listeAttribut = ent.getListeAttributs();
/*     */     }
/*     */     
/*     */ 
/* 261 */     for (int i = 0; i < listeAttribut.size(); i++) {
/* 262 */       if (((Attribut)listeAttribut.get(i)).getKey().equals(Parametres.Cle)) {
/* 263 */         String nomAtt = getNomAttribut((Attribut2)listeAttribut.get(i));
/*     */         
/* 265 */         if (s.trim().length() != 0) s = s + ",";
/* 266 */         s = s + SQLOutil.remplaceChar(nomAtt);
/*     */       }
/*     */     }
/* 269 */     String nmCnt = nomTab;
/* 270 */     if (Setting.SQLPrefixerLeNomContrainte2) nmCnt = "PK_" + nmCnt; else {
/* 271 */       nmCnt = nmCnt + "_PK";
/*     */     }
/* 273 */     if (s.trim().length() != 0) {}
/* 274 */     s = "CONSTRAINT " + nmCnt + " PRIMARY KEY (" + s + ")";
/*     */     
/*     */ 
/*     */ 
/* 278 */     return s;
/*     */   }
/*     */   
/*     */   private static String SQLEntite(MLDEntite2 ent, IhmPageMCD page, IhmPageMLD pageMld) {
/* 282 */     String s = "";
/*     */     
/*     */     ArrayList<Attribut> listeAttribut;
/*     */     
/* 287 */     if (ent.isComposer()) {
/* 288 */       listeAttribut = SQLOutil.decomposerLesAttributsMLDEntite(ent);
/*     */     } else {
/* 290 */       listeAttribut = ent.getListeAttributs();
/*     */     }
/*     */     
/* 293 */     String nomTable = getSQLNomTable(ent);
/*     */     
/* 295 */     String idx = "";
/* 296 */     if (Setting.SQLPrefixerLeNomContrainte2) idx = "Idx_" + nomTable; else
/* 297 */       idx = nomTable + "_Idx";
/* 298 */     indexEnt = "";
/* 299 */     uniq = "";
/*     */     String nmAK;
/* 301 */      if (Setting.SQLPrefixerLeNomContrainte2) {
/* 302 */       nmAK = "AK_" + nomTable;
/*     */     } else {
/* 304 */       nmAK = nomTable + "_AK";
/*     */     }
/*     */     
/*     */ 
/* 308 */     int lg = longueurMaxAttribut(listeAttribut);
/* 309 */     s = "CREATE TABLE " + SQLOutil.remplaceChar(nomTable) + "(\n\t";
/* 310 */     for (int i = 0; i < listeAttribut.size(); i++) {
/* 311 */       s = s + SQLAttribut((Attribut)listeAttribut.get(i), nomTable, page, lg);
/* 312 */       if (i + 1 < listeAttribut.size()) {
/* 313 */         s = s + ",\n\t";
/*     */       } else {
/* 315 */         String k = SQLGetKey(ent, nomTable);
/* 316 */         if (indexEnt.trim().length() != 0) {
/* 317 */           index = index + "CREATE INDEX " + idx + " ON " + nomTable + " (" + indexEnt + ");\n";
/*     */         }
/* 319 */         if (k.trim().length() != 0) { s = s + " ,\n\t" + k;
/*     */         }
/* 321 */         if (uniq.trim().length() != 0) { s = s + " ,\n\tCONSTRAINT " + nmAK + " UNIQUE (" + uniq + ")";
/*     */         }
/* 323 */         if (!pageMld.isMutex()) s = s + getAllcontrainteEntite(ent);
/* 324 */         s = s + "\n);\n";
/*     */       }
/*     */     }
/* 327 */     return s;
/*     */   }
/*     */   
/*     */   private static String SQLListeEntite(ArrayList<MLDEntite2> listeMLD, IhmPageMCD page, IhmPageMLD pageMld) {
/* 331 */     index = "";
/* 332 */     indexEnt = "";
/* 333 */     uniq = "";
/* 334 */     String s = "";
/* 335 */     for (int i = 0; i < listeMLD.size(); i++) {
/* 336 */       s = s + "\n/*------------------------------------------------------------\n";
/* 337 */       s = s + "-- Table: " + ((MLDEntite2)listeMLD.get(i)).getNom();
/* 338 */       s = s + "\n------------------------------------------------------------*/\n";
/*     */       
/* 340 */       s = s + SQLEntite((MLDEntite2)listeMLD.get(i), page, pageMld) + "\n";
/*     */     }
/*     */     
/* 343 */     return s;
/*     */   }
/*     */   
/*     */   public static String getScript(IhmPageMLD pageMld, IhmPageMCD pageMcd) {
/* 347 */     String s = "";
/* 348 */     s = "/*------------------------------------------------------------\n";
/* 349 */     s = s + "*        Script SQLSERVER \n";
/* 350 */     s = s + "------------------------------------------------------------*/\n\n";
/*     */     
/* 352 */     s = s + SQLListeEntite(pageMld.getListeMLDEntite(), pageMcd, pageMld) + "\n";
/* 353 */     s = s + index + "\n";
/* 354 */     if (pageMld.isMutex()) s = s + getAllReference(pageMld);
/* 355 */     if (!Principale.isActiverJMerise()) {
/* 356 */       s = SQLOutil.getCentLignes(s);
/*     */     }
/*     */     
/* 359 */     return s;
/*     */   }
/*     */   
/*     */   private static String getSQLNomTable(MLDEntite2 ent) {
/* 363 */     String st = "";String s = "";
/* 364 */     if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 365 */       s = SQLOutil.remplaceChar(Setting.developpeur);
/* 366 */       s = s.toUpperCase();
/*     */     }
/* 368 */     if (Setting.SQLUtiliserCode) {
/* 369 */       st = SQLOutil.remplaceChar(ent.getCode());
/*     */     } else {
/* 371 */       st = SQLOutil.remplaceChar(ent.getNom());
/*     */     }
/* 373 */     if (s.length() == 0) s = st; else
/* 374 */       s = s + "_" + st;
/* 375 */     return s;
/*     */   }
/*     */   
/*     */   private static String getNomAttribut(Attribut2 att) {
/* 379 */     if (Setting.SQLUtiliserCode) return SQLOutil.remplaceChar(att.getCode());
/* 380 */     return SQLOutil.remplaceChar(att.getNom());
/*     */   }
/*     */   
/*     */   private static String getUneContrainteFK(TableReference tab, String num) {
/* 384 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 385 */     String att = "";String attRef = "";
/*     */     
/* 387 */     for (int i = 0; i < liste.size(); i++) {
/* 388 */       if (att.length() == 0) {
/* 389 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 390 */         attRef = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */       else {
/* 393 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 394 */         attRef = attRef + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */     }
/* 397 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 398 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 399 */     String nomCnt = "";
/* 400 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "FK_" + nomTab + "_" + nomTabRef + num; else {
/* 401 */       nomCnt = nomTab + "_" + nomTabRef + num + "_FK";
/*     */     }
/* 403 */     String s = "\nALTER TABLE " + nomTab + "\n\tADD CONSTRAINT " + nomCnt + "\n\tFOREIGN KEY (" + att + ")" + "\n\tREFERENCES " + nomTabRef + "(" + attRef + ");\n";
/*     */     
/* 405 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContrainteFK(MLDEntite2 ent) {
/* 409 */     String s = "";
/* 410 */     for (int i = 0; i < ent.getListeCNTForeingKey().size(); i++) {
/* 411 */       s = s + getUneContrainteFK((TableReference)ent.getListeCNTForeingKey().get(i), new StringBuilder().append(i).append("").toString());
/*     */     }
/* 413 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteAK(TableReference tab, String num) {
/* 417 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 418 */     String att = "";
/*     */     
/* 420 */     for (int i = 0; i < liste.size(); i++) {
/* 421 */       if (att.length() == 0) {
/* 422 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */       else
/*     */       {
/* 426 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */     }
/* 429 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 430 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 431 */     String nomCnt = "";
/* 432 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "AK_" + nomTab + "_" + nomTabRef + num; else {
/* 433 */       nomCnt = nomTab + "_" + nomTabRef + num + "_AK";
/*     */     }
/* 435 */     String s = "\nALTER TABLE " + nomTab + " \n\tADD CONSTRAINT " + nomCnt + " \n\tUNIQUE (" + att + ");\n";
/*     */     
/* 437 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContrainteAK(MLDEntite2 ent) {
/* 441 */     String s = "";
/* 442 */     for (int i = 0; i < ent.getListeCNTALTERNATIVEKEY().size(); i++) {
/* 443 */       s = s + getUneContrainteAK((TableReference)ent.getListeCNTALTERNATIVEKEY().get(i), new StringBuilder().append(i).append("").toString());
/*     */     }
/* 445 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContraintesEntite(MLDEntite2 ent) {
/* 449 */     String s = "";
/* 450 */     s = getAllContrainteFK(ent);
/* 451 */     s = s + getAllContrainteAK(ent);
/* 452 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllReference(IhmPageMLD page) {
/* 456 */     String s = "";
/*     */     
/* 458 */     for (int i = 0; i < page.getListeMLDEntite().size(); i++) {
/* 459 */       s = s + getAllContraintesEntite((MLDEntite2)page.getListeMLDEntite().get(i));
/*     */     }
/* 461 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteFK_Interne(TableReference tab, String num)
/*     */   {
/* 466 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 467 */     String att = "";String attRef = "";
/*     */     
/* 469 */     for (int i = 0; i < liste.size(); i++) {
/* 470 */       if (att.length() == 0) {
/* 471 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 472 */         attRef = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */       else {
/* 475 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 476 */         attRef = attRef + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */     }
/* 479 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 480 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 481 */     String nomCnt = "";
/* 482 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "FK_" + nomTab + "_" + nomTabRef + num; else {
/* 483 */       nomCnt = nomTab + "_" + nomTabRef + num + "_FK";
/*     */     }
/* 485 */     String s = "\n\t,CONSTRAINT " + nomCnt + " FOREIGN KEY (" + att + ")" + " REFERENCES " + nomTabRef + "(" + attRef + ")";
/*     */     
/* 487 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteAK_Interne(TableReference tab, String num)
/*     */   {
/* 492 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 493 */     String att = "";
/*     */     
/* 495 */     for (int i = 0; i < liste.size(); i++) {
/* 496 */       if (att.length() == 0) {
/* 497 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */       else {
/* 500 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */     }
/* 503 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 504 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 505 */     String nomCnt = "";
/* 506 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "AK_" + nomTab + "_" + nomTabRef + num; else {
/* 507 */       nomCnt = nomTab + "_" + nomTabRef + num + "_AK";
/*     */     }
/* 509 */     String s = "\n\t,CONSTRAINT " + nomCnt + " UNIQUE (" + att + ")";
/*     */     
/* 511 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllcontrainteEntite(MLDEntite2 ent) {
/* 515 */     String s = "";
/* 516 */     String nn = "";
/* 517 */     for (int i = 0; i < ent.getListeCNTForeingKey().size(); i++) {
/* 518 */       s = s + getUneContrainteFK_Interne((TableReference)ent.getListeCNTForeingKey().get(i), nn);
/* 519 */       nn = i + "";
/*     */     }
/* 521 */     if (s.length() > 0) s = "\n" + s;
/* 522 */     nn = "";
/* 523 */     for (int i = 0; i < ent.getListeCNTALTERNATIVEKEY().size(); i++) {
/* 524 */       s = s + getUneContrainteAK_Interne((TableReference)ent.getListeCNTALTERNATIVEKEY().get(i), nn);
/* 525 */       nn = i + "";
/*     */     }
/* 527 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static ArrayList<String> creerListeTable(String script)
/*     */   {
/* 534 */     ArrayList<String> listeTable = new ArrayList();
/*     */     
/* 536 */     String f = "";String d = " ";String table = "";
/* 537 */     int indexx = -1;
/* 538 */     String scriptCREATE = script.substring(0, script.toUpperCase().indexOf("ALTER"));
/* 539 */     String scriptALTER = script.substring(script.toUpperCase().indexOf("ALTER"), script.length());
/* 540 */     indexx = scriptCREATE.toUpperCase().indexOf("CREATE");
/* 541 */     scriptCREATE = scriptCREATE.substring(indexx);
/* 542 */     if (indexx > -1) {
/* 543 */       while (indexx > -1) {
/* 544 */         d = scriptCREATE.substring(0, scriptCREATE.toUpperCase().indexOf(";") + 1);
/* 545 */         scriptCREATE = scriptCREATE.substring(scriptCREATE.indexOf(";") + 1);
/* 546 */         listeTable.add(d);
/* 547 */         indexx = scriptCREATE.toUpperCase().indexOf("CREATE");
/*     */       }
/*     */     }
/*     */     
/* 551 */     indexx = scriptALTER.toUpperCase().indexOf("ALTER");
/* 552 */     scriptALTER = scriptALTER.substring(indexx);
/* 553 */     if (indexx > -1) {
/* 554 */       while (indexx > -1) {
/* 555 */         d = scriptALTER.substring(0, scriptALTER.toUpperCase().indexOf(";") + 1);
/* 556 */         scriptALTER = scriptALTER.substring(scriptALTER.indexOf(";") + 1);
/* 557 */         listeTable.add(d);
/* 558 */         indexx = scriptALTER.toUpperCase().indexOf("ALTER");
/*     */       }
/*     */     }
/*     */     
/* 562 */     return listeTable;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Output\SQLServer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */