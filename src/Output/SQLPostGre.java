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
/*     */ public class SQLPostGre
/*     */ {
/*  25 */   private static String index = "";
/*  26 */   private static String indexEnt = "";
/*  27 */   private static String uniq = "";
/*     */   
/*     */   private static boolean isDomaine(Attribut att, IhmPageMCD page) {
/*  30 */     ArrayList<Domaine> list = page.getListeDomaine();
/*  31 */     for (int i = 0; i < list.size(); i++) {
/*  32 */       if (att.getType().trim().toUpperCase().equals(((Domaine)list.get(i)).getNom().trim().toUpperCase()))
/*  33 */         return true;
/*     */     }
/*  35 */     return false;
/*     */   }
/*     */   
/*     */   private static String remplacerType(Attribut att) {
/*  39 */     String t = "";
/*  40 */     String type = att.getType();
/*  41 */     String nul = att.isNulle() ? " " : " NOT NULL";
/*     */     
/*  43 */     if (att.getKey().equals(Parametres.Cle)) { nul = " NOT NULL";
/*     */     }
/*  45 */     else if (att.getKey().equals(Parametres.Index)) { nul = " NOT NULL";
/*     */     }
/*  47 */     else if (att.getKey().equals(Parametres.Unique)) { nul = " NOT NULL";
/*     */     }
/*     */     
/*     */ 
/*  51 */     if (type.trim().toUpperCase().equals("AUTO_INCREMENT")) {
/*  52 */       t = "SERIAL NOT NULL";
/*     */     }
/*  54 */     if (type.trim().toUpperCase().equals("VARCHAR")) {
/*  55 */       t = "VARCHAR (" + att.getLongueur() + ")" + nul;
/*     */     }
/*  57 */     if (type.trim().toUpperCase().equals("INTEGER")) {
/*  58 */       t = "INTEGER " + nul;
/*     */     }
/*     */     
/*  61 */     if (type.trim().toUpperCase().equals("FLOAT")) {
/*  62 */       t = "FLOAT " + nul;
/*     */     }
/*  64 */     if (type.trim().toUpperCase().equals("BLOB")) {
/*  65 */       t = "BYTEA " + nul;
/*     */     }
/*  67 */     if (type.trim().toUpperCase().equals("DECIMAL")) {
/*  68 */       t = "DECIMAL (" + att.getLongueur() + "," + att.getLongDecimale() + ") " + nul;
/*     */     }
/*     */     
/*  71 */     if (type.trim().toUpperCase().equals("MONEY")) {
/*  72 */       t = "DECIMAL (15,3)" + nul;
/*     */     }
/*     */     
/*  75 */     if (type.trim().toUpperCase().equals("DOUBLE PRECISION")) {
/*  76 */       t = "DOUBLE PRECISION " + nul;
/*     */     }
/*  78 */     if (type.trim().toUpperCase().equals("NUMERIC")) {
/*  79 */       t = "NUMERIC (" + att.getLongueur() + "," + att.getLongDecimale() + ") " + nul;
/*     */     }
/*  81 */     if (type.trim().toUpperCase().equals("SMALLINT")) {
/*  82 */       t = "INT2 " + nul;
/*     */     }
/*  84 */     if (type.trim().toUpperCase().equals("CHAR")) {
/*  85 */       t = "CHAR (" + att.getLongueur() + ") " + nul;
/*     */     }
/*  87 */     if (type.trim().toUpperCase().equals("DATE")) {
/*  88 */       t = "DATE " + nul;
/*     */     }
/*     */     
/*  91 */     if (type.trim().toUpperCase().equals("BOOL")) {
/*  92 */       t = "BOOL " + nul;
/*     */     }
/*  94 */     if (type.trim().toUpperCase().equals("INT")) {
/*  95 */       t = "INT " + nul;
/*     */     }
/*  97 */     if (type.trim().toUpperCase().equals("DATETIME")) {
/*  98 */       t = "DATE " + nul;
/*     */     }
/* 100 */     if (type.trim().toUpperCase().equals("DOUBLE")) {
/* 101 */       t = "FLOAT8 " + nul;
/*     */     }
/*     */     
/* 104 */     if (type.trim().toUpperCase().equals("LONGBLOB")) {
/* 105 */       t = "BYTEA " + nul;
/*     */     }
/* 107 */     if (type.trim().toUpperCase().equals("LONGTEXT")) {
/* 108 */       t = "VARCHAR (2000) " + nul;
/*     */     }
/* 110 */     if (type.trim().toUpperCase().equals("MEDIUMBLOB")) {
/* 111 */       t = "BYTEA " + nul;
/*     */     }
/* 113 */     if (type.trim().toUpperCase().equals("MEDIUMINT")) {
/* 114 */       t = "INTEGER " + nul;
/*     */     }
/* 116 */     if (type.trim().toUpperCase().equals("MEDIUMTEXT")) {
/* 117 */       t = "VARCHAR (2000) " + nul;
/*     */     }
/* 119 */     if (type.trim().toUpperCase().equals("REAL")) {
/* 120 */       t = "FLOAT " + nul;
/*     */     }
/*     */     
/* 123 */     if (type.trim().toUpperCase().equals("TEXT")) {
/* 124 */       t = "VARCHAR (2000) " + nul;
/*     */     }
/* 126 */     if (type.trim().toUpperCase().equals("TIME")) {
/* 127 */       t = "TIMETZ " + nul;
/*     */     }
/* 129 */     if (type.trim().toUpperCase().equals("TIMESTAMP")) {
/* 130 */       t = "TIMESTAMP " + nul;
/*     */     }
/* 132 */     if (type.trim().toUpperCase().equals("TINYBLOB")) {
/* 133 */       t = "BYTEA " + nul;
/*     */     }
/* 135 */     if (type.trim().toUpperCase().equals("TINYINT")) {
/* 136 */       t = "INTEGER " + nul;
/*     */     }
/* 138 */     if (type.trim().toUpperCase().equals("TINYTEXT")) {
/* 139 */       t = "VARCHAR (2000) " + nul;
/*     */     }
/* 141 */     if (type.trim().toUpperCase().equals("YEAR")) {
/* 142 */       t = "INTEGER " + nul;
/*     */     }
/*     */     
/* 145 */     return t;
/*     */   }
/*     */   
/*     */   private static String SQLDomaine(Domaine d) {
/* 149 */     String s = "";
/* 150 */     for (int i = 0; i < d.getListeValeurs().size(); i++) {
/* 151 */       s = s + "'" + (String)d.getListeValeurs().get(i) + "'";
/* 152 */       if (i + 1 < d.getListeValeurs().size()) {
/* 153 */         s = s + ",";
/*     */       }
/*     */     }
/* 156 */     if (s.length() > 0) {
/* 157 */       s = "CREATE TYPE " + SQLOutil.remplaceChar(d.getNom()) + " AS ENUM (" + s + ");";
/*     */     }
/* 159 */     return s;
/*     */   }
/*     */   
/*     */   public static String SQLListeDomaine(ArrayList<Domaine> liste) {
/* 163 */     String s = "";
/* 164 */     for (int i = 0; i < liste.size(); i++) {
/* 165 */       s = s + SQLDomaine((Domaine)liste.get(i)) + "\n";
/*     */     }
/* 167 */     return s;
/*     */   }
/*     */   
/*     */   private static String getType(Attribut att, IhmPageMCD page)
/*     */   {
/* 172 */     if (isDomaine(att, page)) {
/* 173 */       String ss = att.getType().toUpperCase() + (att.isNulle() ? "" : " NOT NULL");
/* 174 */       return ss;
/*     */     }
/* 176 */     return remplacerType(att);
/*     */   }
/*     */   
/*     */ 
/*     */   private static String ajusterNom(String nom, int tailMax)
/*     */   {
/* 182 */     nom = SQLOutil.remplaceChar(nom);
/* 183 */     for (int i = nom.length(); i < tailMax; i++) {
/* 184 */       nom = nom + " ";
/*     */     }
/* 186 */     return nom;
/*     */   }
/*     */   
/*     */   private static int longueurMaxAttribut(ArrayList<Attribut> listeAttributs) {
/* 190 */     int max = 0;
/*     */     
/*     */ 
/* 193 */     for (int i = 0; i < listeAttributs.size(); i++) {
/* 194 */       Attribut2 att = (Attribut2)listeAttributs.get(i);
/* 195 */       String nom; if (Setting.SQLUtiliserCode) {
/* 196 */         nom = att.getCode();
/*     */       } else {
/* 198 */         nom = att.getNom();
/*     */       }
/* 200 */       if (nom.length() > max) {
/* 201 */         max = nom.length();
/*     */       }
/*     */     }
/* 204 */     return max + 2;
/*     */   }
/*     */   
/*     */   private static String SQLAttribut(Attribut att, String tab, IhmPageMCD page, int lg) {
/* 208 */     String s = "";
/* 209 */     String cle = "";
/*     */     
/*     */     String nomAtt;
/* 213 */     if (Setting.SQLUtiliserCode) {
/* 214 */       nomAtt = ((Attribut2)att).getCode();
/*     */     } else {
/* 216 */       nomAtt = att.getNom();
/*     */     }
/*     */     
/* 219 */     if (att.getKey().equals(Parametres.Unique)) {
/* 220 */       if (uniq.trim().length() == 0) uniq = nomAtt; else {
/* 221 */         uniq = uniq + "," + nomAtt;
/*     */       }
/*     */     }
/* 224 */     if (att.getKey().equals(Parametres.Index)) {
/* 225 */       if (indexEnt.trim().length() == 0) indexEnt = SQLOutil.remplaceChar(nomAtt); else {
/* 226 */         indexEnt = indexEnt + "," + SQLOutil.remplaceChar(nomAtt);
/*     */       }
/*     */     }
/* 229 */     s = s + ajusterNom(nomAtt, lg) + " " + getType(att, page) + " " + cle;
/* 230 */     return s;
/*     */   }
/*     */   
/*     */   private static String SQLGetKey(MLDEntite2 ent) {
/* 234 */     String s = "";
/* 235 */     String nomTab = getSQLNomTable(ent);
/*     */     
/*     */     ArrayList<Attribut> listeAttribut;
/* 239 */     if (ent.isComposer()) {
/* 240 */       listeAttribut = SQLOutil.decomposerLesAttributsMLDEntite(ent);
/*     */     } else {
/* 242 */       listeAttribut = ent.getListeAttributs();
/*     */     }
/*     */     
/*     */ 
/* 246 */     for (int i = 0; i < listeAttribut.size(); i++) {
/* 247 */       if (((Attribut)listeAttribut.get(i)).getKey().equals(Parametres.Cle)) {
/* 248 */         String nomAtt = getNomAttribut((Attribut2)listeAttribut.get(i));
/*     */         
/* 250 */         if (s.trim().length() != 0) s = s + ",";
/* 251 */         s = s + SQLOutil.remplaceChar(nomAtt);
/*     */       }
/*     */     }
/* 254 */     String nmCnt = nomTab;
/* 255 */     if (Setting.SQLPrefixerLeNomContrainte2) nmCnt = "PK_" + nmCnt; else {
/* 256 */       nmCnt = nmCnt + "_PK";
/*     */     }
/* 258 */     if (s.trim().length() != 0) {}
/* 259 */     s = "CONSTRAINT " + nmCnt + " PRIMARY KEY (" + s + ")";
/*     */     
/* 261 */     return s;
/*     */   }
/*     */   
/*     */   private static String SQLEntite(MLDEntite2 ent, IhmPageMCD page, IhmPageMLD pageMld) {
/* 265 */     String s = "";
/*     */     
/*     */     ArrayList<Attribut> listeAttribut;
/*     */     
/* 270 */     if (ent.isComposer()) {
/* 271 */       listeAttribut = SQLOutil.decomposerLesAttributsMLDEntite(ent);
/*     */     } else {
/* 273 */       listeAttribut = ent.getListeAttributs();
/*     */     }
/*     */     
/* 276 */     String nomTable = getSQLNomTable(ent);
/*     */     
/* 278 */     String idx = "";
/* 279 */     if (Setting.SQLPrefixerLeNomContrainte2) idx = "Idx_" + nomTable; else
/* 280 */       idx = nomTable + "_Idx";
/* 281 */     indexEnt = "";
/* 282 */     uniq = "";
/*     */     String nmAK; if (Setting.SQLPrefixerLeNomContrainte2) {
/* 285 */       nmAK = "PK_" + nomTable;
/*     */     } else {
/* 287 */       nmAK = nomTable + "_AK";
/*     */     }
/*     */     
/* 290 */     int lg = longueurMaxAttribut(listeAttribut);
/* 291 */     s = "CREATE TABLE public." + SQLOutil.remplaceChar(nomTable) + "(\n\t";
/* 292 */     for (int i = 0; i < listeAttribut.size(); i++) {
/* 293 */       s = s + SQLAttribut((Attribut)listeAttribut.get(i), nomTable, page, lg);
/* 294 */       if (i + 1 < listeAttribut.size()) {
/* 295 */         s = s + ",\n\t";
/*     */       } else {
/* 297 */         String k = SQLGetKey(ent);
/* 298 */         if (indexEnt.trim().length() != 0) {
/* 299 */           index = index + "CREATE INDEX " + idx + " ON public." + nomTable + " (" + indexEnt + ");\n";
/*     */         }
/* 301 */         if (k.trim().length() != 0) { s = s + " ,\n\t" + k;
/*     */         }
/* 303 */         if (uniq.trim().length() != 0) { s = s + " ,\n\tCONSTRAINT " + nmAK + " UNIQUE (" + uniq + ")";
/*     */         }
/* 305 */         if (!pageMld.isMutex()) { s = s + getAllcontrainteEntite(ent);
/*     */         }
/* 307 */         s = s + "\n)WITHOUT OIDS;\n";
/*     */       }
/*     */     }
/* 310 */     return s;
/*     */   }
/*     */   
/*     */   private static String SQLListeEntite(ArrayList<MLDEntite2> listeMLD, IhmPageMCD page, IhmPageMLD pageMld) {
/* 314 */     index = "";
/* 315 */     indexEnt = "";
/* 316 */     String s = "";
/* 317 */     for (int i = 0; i < listeMLD.size(); i++) {
/* 318 */       s = s + "\n------------------------------------------------------------\n";
/* 319 */       s = s + "-- Table: " + ((MLDEntite2)listeMLD.get(i)).getNom();
/* 320 */       s = s + "\n------------------------------------------------------------\n";
/* 321 */       s = s + SQLEntite((MLDEntite2)listeMLD.get(i), page, pageMld) + "\n";
/*     */     }
/*     */     
/* 324 */     return s;
/*     */   }
/*     */   
/*     */   public static String SQLCommenaireAtt(MLDEntite2 ent)
/*     */   {
/* 329 */     String s = "";
/*     */     
/* 331 */     String nomTable = getSQLNomTable(ent);
/*     */     
/*     */     ArrayList<Attribut> listeAttribut;
/* 335 */     if (ent.isComposer()) {
/* 336 */       listeAttribut = SQLOutil.decomposerLesAttributsMLDEntite(ent);
/*     */     } else {
/* 338 */       listeAttribut = ent.getListeAttributs();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 343 */     for (int i = 0; i < listeAttribut.size(); i++) {
/* 344 */       if (((Attribut)listeAttribut.get(i)).getCommentaire().trim().length() > 0) {
/* 345 */         String nomAtt = getNomAttribut((Attribut2)listeAttribut.get(i));
/*     */         
/* 347 */         s = s + "COMMENT ON COLUMN public." + nomTable + "." + nomAtt + " IS '" + SQLOutil.remplacerCharCommentaire(((Attribut)listeAttribut.get(i)).getCommentaire()) + "';\n";
/*     */       }
/*     */     }
/*     */     
/* 351 */     return s;
/*     */   }
/*     */   
/*     */   public static String SQLCommenaireAtt(IhmPageMLD pageMld) {
/* 355 */     String s = "";
/* 356 */     for (int i = 0; i < pageMld.getListeMLDEntite().size(); i++) {
/* 357 */       s = s + SQLCommenaireAtt((MLDEntite2)pageMld.getListeMLDEntite().get(i));
/*     */     }
/* 359 */     return s;
/*     */   }
/*     */   
/*     */   public static String SQLCommenaireTable(IhmPageMLD pageMld) {
/* 363 */     String s = "";
/*     */     
/* 365 */     for (int i = 0; i < pageMld.getListeMLDEntite().size(); i++)
/*     */     {
/* 367 */       if (((MLDEntite2)pageMld.getListeMLDEntite().get(i)).getCommentaire().trim().length() > 0) {
/* 368 */         String nomTable = getSQLNomTable((MLDEntite2)pageMld.getListeMLDEntite().get(i));
/* 369 */         s = s + "COMMENT ON TABLE public." + nomTable + " IS '" + SQLOutil.remplacerCharCommentaire(((MLDEntite2)pageMld.getListeMLDEntite().get(i)).getCommentaire()) + "';\n";
/*     */       }
/*     */     }
/* 372 */     return s;
/*     */   }
/*     */   
/*     */   public static String getScript(IhmPageMLD pageMld, IhmPageMCD pageMcd) {
/* 376 */     String s = "";
/*     */     
/* 378 */     s = "------------------------------------------------------------\n";
/* 379 */     s = s + "--        Script Postgre \n";
/* 380 */     s = s + "------------------------------------------------------------\n\n";
/* 381 */     s = s + SQLListeDomaine(pageMcd.getListeDomaine()) + "\n";
/* 382 */     s = s + SQLListeEntite(pageMld.getListeMLDEntite(), pageMcd, pageMld) + "\n";
/* 383 */     s = s + index + "\n";
/*     */     
/* 385 */     if (Setting.inclureCommentTableSQL) s = s + SQLCommenaireTable(pageMld);
/* 386 */     if (Setting.inclureCommentAttSQL) { s = s + SQLCommenaireAtt(pageMld);
/*     */     }
/* 388 */     if (pageMld.isMutex()) s = s + getAllReference(pageMld);
/* 389 */     if (!Principale.isActiverJMerise()) {
/* 390 */       s = SQLOutil.getCentLignes(s);
/*     */     }
/* 392 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */   private static String getSQLNomTable(MLDEntite2 ent)
/*     */   {
/* 398 */     String st = "";String s = "";
/* 399 */     if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 400 */       s = SQLOutil.remplaceChar(Setting.developpeur);
/* 401 */       s = s.toUpperCase();
/*     */     }
/* 403 */     if (Setting.SQLUtiliserCode) {
/* 404 */       st = SQLOutil.remplaceChar(ent.getCode());
/*     */     } else {
/* 406 */       st = SQLOutil.remplaceChar(ent.getNom());
/*     */     }
/* 408 */     if (s.length() == 0) s = st; else
/* 409 */       s = s + "_" + st;
/* 410 */     return s;
/*     */   }
/*     */   
/*     */   private static String getNomAttribut(Attribut2 att) {
/* 414 */     if (Setting.SQLUtiliserCode) return SQLOutil.remplaceChar(att.getCode());
/* 415 */     return SQLOutil.remplaceChar(att.getNom());
/*     */   }
/*     */   
/*     */   private static String getUneContrainteFK(TableReference tab, String num) {
/* 419 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 420 */     String att = "";String attRef = "";
/*     */     
/* 422 */     for (int i = 0; i < liste.size(); i++) {
/* 423 */       if (att.length() == 0) {
/* 424 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 425 */         attRef = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */       else {
/* 428 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 429 */         attRef = attRef + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */     }
/* 432 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 433 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 434 */     String nomCnt = "";
/* 435 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "FK_" + nomTab + "_" + nomTabRef + num; else {
/* 436 */       nomCnt = nomTab + "_" + nomTabRef + num + "_FK";
/*     */     }
/* 438 */     String s = "\nALTER TABLE public." + nomTab + "\n\tADD CONSTRAINT " + nomCnt + "\n\tFOREIGN KEY (" + att + ")" + "\n\tREFERENCES public." + nomTabRef + "(" + attRef + ");\n";
/*     */     
/* 440 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContrainteFK(MLDEntite2 ent) {
/* 444 */     String s = "";
/* 445 */     for (int i = 0; i < ent.getListeCNTForeingKey().size(); i++) {
/* 446 */       s = s + getUneContrainteFK((TableReference)ent.getListeCNTForeingKey().get(i), new StringBuilder().append(i).append("").toString());
/*     */     }
/* 448 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteAK(TableReference tab, String num) {
/* 452 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 453 */     String att = "";
/*     */     
/* 455 */     for (int i = 0; i < liste.size(); i++) {
/* 456 */       if (att.length() == 0) {
/* 457 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */       else
/*     */       {
/* 461 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */     }
/* 464 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 465 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 466 */     String nomCnt = "";
/* 467 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "AK_" + nomTab + "_" + nomTabRef + num; else {
/* 468 */       nomCnt = nomTab + "_" + nomTabRef + num + "_AK";
/*     */     }
/* 470 */     String s = "\nALTER TABLE public." + nomTab + " \n\tADD CONSTRAINT " + nomCnt + " \n\tUNIQUE (" + att + ");\n";
/*     */     
/* 472 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContrainteAK(MLDEntite2 ent) {
/* 476 */     String s = "";
/* 477 */     for (int i = 0; i < ent.getListeCNTALTERNATIVEKEY().size(); i++) {
/* 478 */       s = s + getUneContrainteAK((TableReference)ent.getListeCNTALTERNATIVEKEY().get(i), new StringBuilder().append(i).append("").toString());
/*     */     }
/* 480 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContraintesEntite(MLDEntite2 ent) {
/* 484 */     String s = "";
/* 485 */     s = getAllContrainteFK(ent);
/* 486 */     s = s + getAllContrainteAK(ent);
/* 487 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllReference(IhmPageMLD page) {
/* 491 */     String s = "";
/*     */     
/* 493 */     for (int i = 0; i < page.getListeMLDEntite().size(); i++) {
/* 494 */       s = s + getAllContraintesEntite((MLDEntite2)page.getListeMLDEntite().get(i));
/*     */     }
/* 496 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteFK_Interne(TableReference tab, String num)
/*     */   {
/* 501 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 502 */     String att = "";String attRef = "";
/*     */     
/* 504 */     for (int i = 0; i < liste.size(); i++) {
/* 505 */       if (att.length() == 0) {
/* 506 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 507 */         attRef = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */       else {
/* 510 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 511 */         attRef = attRef + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */     }
/* 514 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 515 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 516 */     String nomCnt = "";
/* 517 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "FK_" + nomTab + "_" + nomTabRef + num; else {
/* 518 */       nomCnt = nomTab + "_" + nomTabRef + num + "_FK";
/*     */     }
/* 520 */     String s = "\n\t,CONSTRAINT " + nomCnt + " FOREIGN KEY (" + att + ")" + " REFERENCES public." + nomTabRef + "(" + attRef + ")";
/*     */     
/* 522 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteAK_Interne(TableReference tab, String num)
/*     */   {
/* 527 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 528 */     String att = "";
/*     */     
/* 530 */     for (int i = 0; i < liste.size(); i++) {
/* 531 */       if (att.length() == 0) {
/* 532 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */       else {
/* 535 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */     }
/* 538 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 539 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 540 */     String nomCnt = "";
/* 541 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "AK_" + nomTab + "_" + nomTabRef + num; else {
/* 542 */       nomCnt = nomTab + "_" + nomTabRef + num + "_AK";
/*     */     }
/* 544 */     String s = "\n\t,CONSTRAINT " + nomCnt + " UNIQUE (" + att + ")";
/*     */     
/* 546 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllcontrainteEntite(MLDEntite2 ent) {
/* 550 */     String s = "";
/* 551 */     String nn = "";
/* 552 */     for (int i = 0; i < ent.getListeCNTForeingKey().size(); i++) {
/* 553 */       s = s + getUneContrainteFK_Interne((TableReference)ent.getListeCNTForeingKey().get(i), nn);
/* 554 */       nn = i + "";
/*     */     }
/* 556 */     if (s.length() > 0) s = "\n" + s;
/* 557 */     nn = "";
/* 558 */     for (int i = 0; i < ent.getListeCNTALTERNATIVEKEY().size(); i++) {
/* 559 */       s = s + getUneContrainteAK_Interne((TableReference)ent.getListeCNTALTERNATIVEKEY().get(i), nn);
/* 560 */       nn = i + "";
/*     */     }
/* 562 */     return s;
/*     */   }
/*     */   
/*     */   public static ArrayList<String> creerListeTable(String script)
/*     */   {
/* 567 */     ArrayList<String> listeTable = new ArrayList();
/*     */     
/* 569 */     String f = "";String d = " ";String table = "";
/* 570 */     int indexx = -1;
/* 571 */     String scriptCREATE = script.substring(0, script.toUpperCase().indexOf("ALTER"));
/* 572 */     String scriptALTER = script.substring(script.toUpperCase().indexOf("ALTER"), script.length());
/* 573 */     indexx = scriptCREATE.toUpperCase().indexOf("CREATE");
/* 574 */     scriptCREATE = scriptCREATE.substring(indexx);
/* 575 */     if (indexx > -1) {
/* 576 */       while (indexx > -1) {
/* 577 */         d = scriptCREATE.substring(0, scriptCREATE.toUpperCase().indexOf(";") + 1);
/* 578 */         scriptCREATE = scriptCREATE.substring(scriptCREATE.indexOf(";") + 1);
/* 579 */         listeTable.add(d);
/* 580 */         indexx = scriptCREATE.toUpperCase().indexOf("CREATE");
/*     */       }
/*     */     }
/*     */     
/* 584 */     indexx = scriptALTER.toUpperCase().indexOf("ALTER");
/* 585 */     scriptALTER = scriptALTER.substring(indexx);
/* 586 */     if (indexx > -1) {
/* 587 */       while (indexx > -1) {
/* 588 */         d = scriptALTER.substring(0, scriptALTER.toUpperCase().indexOf(";") + 1);
/* 589 */         scriptALTER = scriptALTER.substring(scriptALTER.indexOf(";") + 1);
/* 590 */         listeTable.add(d);
/* 591 */         indexx = scriptALTER.toUpperCase().indexOf("ALTER");
/*     */       }
/*     */     }
/*     */     
/* 595 */     return listeTable;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Output\SQLPostGre.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */