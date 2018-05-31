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
/*     */ public class SQLOracle
/*     */ {
/*  26 */   private static String index = "";
/*  27 */   private static String indexEnt = "";
/*  28 */   private static String checkE = "";
/*  29 */   private static String prkey = "";
/*  30 */   private static String uniq = "";
/*  31 */   private static String sequence = "";
/*  32 */   private static String triggers = "";
/*     */   
/*     */ 
/*     */   private static String getContrainteBoolean(Attribut att)
/*     */   {
/*  37 */     String s = "NUMBER (1)";
/*  38 */     if (!att.isNulle()) s = "NUMBER (1) NOT NULL ";
/*  39 */     if (checkE.length() == 0) checkE = "CONSTRAINT CHK_BOOLEAN_" + getNomAttribut((Attribut2)att) + " CHECK (" + getNomAttribut((Attribut2)att) + " IN (0,1))"; else
/*  40 */       checkE = checkE + ",\n\tCONSTRAINT CHK_BOOLEAN_" + getNomAttribut((Attribut2)att) + " CHECK (" + getNomAttribut((Attribut2)att) + " IN (0,1))";
/*  41 */     return s;
/*     */   }
/*     */   
/*     */   private static String createSeq(String ent, String att) {
/*  45 */     return "CREATE SEQUENCE Seq_" + ent + "_" + att + " START WITH 1 INCREMENT BY 1 NOCYCLE;\n";
/*     */   }
/*     */   
/*     */   private static String createTriggerSeq(String ent, String att) {
/*  49 */     String s = "CREATE OR REPLACE TRIGGER " + ent + "_" + att + "\n";
/*  50 */     s = s + "\tBEFORE INSERT ON " + ent + " \n  FOR EACH ROW \n";
/*  51 */     s = s + "\tWHEN (NEW." + att + " IS NULL) \n\tBEGIN\n";
/*  52 */     s = s + "\t\t select Seq_" + ent + "_" + att + ".NEXTVAL INTO :NEW." + att + " from DUAL; \n";
/*  53 */     s = s + "\tEND;";
/*  54 */     return s;
/*     */   }
/*     */   
/*     */   private static String createTrriger(String ent, String att)
/*     */   {
/*  59 */     String s = "";
/*  60 */     s = s + createTriggerSeq(ent, att) + "\n";
/*     */     
/*  62 */     return s;
/*     */   }
/*     */   
/*     */   private static String remplacerType(Attribut att, MLDEntite2 ent) {
/*  66 */     String t = "";
/*  67 */     String type = att.getType();
/*  68 */     String nul = att.isNulle() ? " " : " NOT NULL ";
/*  69 */     if (att.getKey().equals(Parametres.Cle)) { nul = " NOT NULL ";
/*     */     }
/*  71 */     else if (att.getKey().equals(Parametres.Index)) { nul = "NOT NULL ";
/*     */     }
/*  73 */     else if (att.getKey().equals(Parametres.Unique)) { nul = "NOT NULL ";
/*     */     }
/*     */     
/*  76 */     if (type.trim().toUpperCase().equals("AUTO_INCREMENT")) {
/*  77 */       sequence += createSeq(getSQLNomTable(ent), getNomAttribut((Attribut2)att));
/*  78 */       triggers += createTrriger(getSQLNomTable(ent), getNomAttribut((Attribut2)att));
/*  79 */       t = "NUMBER NOT NULL";
/*     */     }
/*  81 */     if (type.trim().toUpperCase().equals("VARCHAR")) {
/*  82 */       t = "VARCHAR2 (" + att.getLongueur() + ")" + nul;
/*     */     }
/*  84 */     if (type.trim().toUpperCase().equals("INTEGER")) {
/*  85 */       t = "NUMBER (10,0)" + nul;
/*     */     }
/*  87 */     if (type.trim().toUpperCase().equals("FLOAT")) {
/*  88 */       t = "FLOAT " + nul;
/*     */     }
/*  90 */     if (type.trim().toUpperCase().equals("BLOB")) {
/*  91 */       t = "BLOB " + nul;
/*     */     }
/*  93 */     if (type.trim().toUpperCase().equals("DECIMAL")) {
/*  94 */       t = "FLOAT " + nul;
/*     */     }
/*     */     
/*  97 */     if (type.trim().toUpperCase().equals("MONEY")) {
/*  98 */       t = "NUMBER(19, 3) " + nul;
/*     */     }
/* 100 */     if (type.trim().toUpperCase().equals("DOUBLE PRECISION")) {
/* 101 */       t = "FLOAT (24) " + nul;
/*     */     }
/* 103 */     if (type.trim().toUpperCase().equals("NUMERIC")) {
/* 104 */       t = "NUMBER " + nul;
/*     */     }
/* 106 */     if (type.trim().toUpperCase().equals("SMALLINT")) {
/* 107 */       t = "NUMBER(5,0) " + nul;
/*     */     }
/* 109 */     if (type.trim().toUpperCase().equals("CHAR")) {
/* 110 */       t = "CHAR (" + att.getLongueur() + ") " + nul;
/*     */     }
/* 112 */     if (type.trim().toUpperCase().equals("DATE")) {
/* 113 */       t = "DATE " + nul;
/*     */     }
/*     */     
/* 116 */     if (type.trim().toUpperCase().equals("BOOL")) {
/* 117 */       t = getContrainteBoolean(att);
/*     */     }
/* 119 */     if (type.trim().toUpperCase().equals("INT")) {
/* 120 */       t = "NUMBER(10,0) " + nul;
/*     */     }
/* 122 */     if (type.trim().toUpperCase().equals("DATETIME")) {
/* 123 */       t = "DATE " + nul;
/*     */     }
/* 125 */     if (type.trim().toUpperCase().equals("DOUBLE")) {
/* 126 */       t = "FLOAT (24) " + nul;
/*     */     }
/* 128 */     if (type.trim().toUpperCase().equals("LONGBLOB")) {
/* 129 */       t = "BLOB " + nul;
/*     */     }
/* 131 */     if (type.trim().toUpperCase().equals("LONGTEXT")) {
/* 132 */       t = "CLOB " + nul;
/*     */     }
/* 134 */     if (type.trim().toUpperCase().equals("MEDIUMBLOB")) {
/* 135 */       t = "BLOB " + nul;
/*     */     }
/* 137 */     if (type.trim().toUpperCase().equals("MEDIUMINT")) {
/* 138 */       t = "NUMBER(7,0) " + nul;
/*     */     }
/* 140 */     if (type.trim().toUpperCase().equals("MEDIUMTEXT")) {
/* 141 */       t = "CLOB " + nul;
/*     */     }
/* 143 */     if (type.trim().toUpperCase().equals("REAL")) {
/* 144 */       t = "FLOAT (24)" + nul;
/*     */     }
/*     */     
/* 147 */     if (type.trim().toUpperCase().equals("TEXT")) {
/* 148 */       t = "CLOB " + nul;
/*     */     }
/* 150 */     if (type.trim().toUpperCase().equals("TIME")) {
/* 151 */       t = "DATE " + nul;
/*     */     }
/* 153 */     if (type.trim().toUpperCase().equals("TIMESTAMP")) {
/* 154 */       t = "DATE " + nul;
/*     */     }
/* 156 */     if (type.trim().toUpperCase().equals("TINYBLOB")) {
/* 157 */       t = "RAW " + nul;
/*     */     }
/* 159 */     if (type.trim().toUpperCase().equals("TINYINT")) {
/* 160 */       t = "NUMBER(3,0) " + nul;
/*     */     }
/* 162 */     if (type.trim().toUpperCase().equals("TINYTEXT")) {
/* 163 */       t = "VARCHAR2 " + nul;
/*     */     }
/* 165 */     if (type.trim().toUpperCase().equals("YEAR")) {
/* 166 */       t = "NUMBER(4,0) " + nul;
/*     */     }
/* 168 */     return t;
/*     */   }
/*     */   
/*     */   private static boolean isDomaine(Attribut att, IhmPageMCD page) {
/* 172 */     ArrayList<Domaine> list = page.getListeDomaine();
/* 173 */     for (int i = 0; i < list.size(); i++) {
/* 174 */       if (att.getType().trim().toUpperCase().equals(((Domaine)list.get(i)).getNom().trim().toUpperCase()))
/* 175 */         return true;
/*     */     }
/* 177 */     return false;
/*     */   }
/*     */   
/*     */   private static Domaine retourneDomaine(Attribut att, IhmPageMCD page) {
/* 181 */     ArrayList<Domaine> list = page.getListeDomaine();
/* 182 */     for (int i = 0; i < list.size(); i++) {
/* 183 */       if (att.getType().trim().toUpperCase().equals(((Domaine)list.get(i)).getNom().trim().toUpperCase()))
/* 184 */         return (Domaine)list.get(i);
/*     */     }
/* 186 */     return null;
/*     */   }
/*     */   
/*     */   private static String createDomaine(Attribut att, Domaine d) {
/* 190 */     String s = "";
/* 191 */     int tail = 0;
/* 192 */     for (int i = 0; i < d.getListeValeurs().size(); i++) {
/* 193 */       if (s.trim().length() == 0) {
/* 194 */         s = "'" + (String)d.getListeValeurs().get(i) + "'";
/* 195 */         tail = ((String)d.getListeValeurs().get(i)).length();
/*     */       }
/*     */       else {
/* 198 */         s = s + ",'" + (String)d.getListeValeurs().get(i) + "'";
/* 199 */         if (tail < ((String)d.getListeValeurs().get(i)).length()) {
/* 200 */           tail = ((String)d.getListeValeurs().get(i)).length();
/*     */         }
/*     */       }
/*     */     }
/* 204 */     String ss = "VARCHAR2(" + tail + ")";
/* 205 */     if (checkE.length() == 0) checkE = "CONSTRAINT CHK_TYPE_" + SQLOutil.remplaceChar(att.getNom()) + " CHECK (" + SQLOutil.remplaceChar(att.getNom()) + " IN (" + s + "))"; else
/* 206 */       checkE = checkE + ",\n\tCONSTRAINT CHK_TYPE_" + SQLOutil.remplaceChar(att.getNom()) + " CHECK (" + SQLOutil.remplaceChar(att.getNom()) + " IN (" + s + "))";
/* 207 */     return ss;
/*     */   }
/*     */   
/*     */   private static String ajusterNom(String nom, int tailMax) {
/* 211 */     nom = SQLOutil.remplaceChar(nom);
/* 212 */     for (int i = nom.length(); i < tailMax; i++) {
/* 213 */       nom = nom + " ";
/*     */     }
/* 215 */     return nom;
/*     */   }
/*     */   
/*     */   private static int longueurMaxAttribut(ArrayList<Attribut> listeAttributs) {
/* 219 */     int max = 0;
/*     */     
/*     */ 
/* 222 */     for (int i = 0; i < listeAttributs.size(); i++) {
/* 223 */       Attribut2 att = (Attribut2)listeAttributs.get(i);
/* 224 */       String nom; if (Setting.SQLUtiliserCode) {
/* 225 */         nom = att.getCode();
/*     */       } else {
/* 227 */         nom = att.getNom();
/*     */       }
/* 229 */       if (nom.length() > max) {
/* 230 */         max = nom.length();
/*     */       }
/*     */     }
/* 233 */     return max + 2;
/*     */   }
/*     */   
/*     */   private static String SQLAttribut(Attribut att, MLDEntite2 ent, IhmPageMCD pageMcd, int lg) {
/* 237 */     String s = "";
/*     */     
/*     */ 
/* 240 */     if (Setting.SQLUtiliserCode) {
/* 241 */       String nomTable = ent.getCode();
/* 242 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 243 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/* 245 */       nomTable = nomTable.toUpperCase();
/*     */     } else {
/* 247 */       String nomTable = ent.getNom();
/* 248 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 249 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/*     */     }
/*     */     
/* 253 */     String nomAtt = getNomAttribut((Attribut2)att);
/*     */     
/*     */ 
/* 256 */     if (isDomaine(att, pageMcd)) {
/* 257 */       s = createDomaine(att, retourneDomaine(att, pageMcd));
/*     */     } else {
/* 259 */       s = remplacerType(att, ent);
/*     */     }
/*     */     
/*     */ 
/* 263 */     if (att.getKey().equals(Parametres.Cle)) {
/* 264 */       if (prkey.trim().length() == 0) prkey = nomAtt; else {
/* 265 */         prkey = prkey + "," + nomAtt;
/*     */       }
/*     */     }
/* 268 */     if (att.getKey().equals(Parametres.Unique)) {
/* 269 */       if (uniq.trim().length() == 0) uniq = nomAtt; else
/* 270 */         uniq = uniq + "," + nomAtt;
/*     */     }
/* 272 */     if (att.getKey().equals(Parametres.Index)) {
/* 273 */       if (indexEnt.trim().length() == 0) indexEnt = nomAtt; else {
/* 274 */         indexEnt = indexEnt + "," + nomAtt;
/*     */       }
/*     */     }
/* 277 */     s = ajusterNom(nomAtt, lg) + s;
/* 278 */     return s;
/*     */   }
/*     */   
/*     */   private static String SQLEntite(MLDEntite2 ent, IhmPageMCD pageMcd, IhmPageMLD pageMld) {
/* 282 */     String s = "";
/*     */     
/*     */     ArrayList<Attribut> listeAttribut;
/*     */     
/* 287 */     if (ent.isComposer()) {
/* 288 */       listeAttribut = SQLOutil.decomposerLesAttributsMLDEntite(ent);
/*     */     } else
/* 290 */       listeAttribut = ent.getListeAttributs();
/*     */     String nomTable;
/* 292 */     if (Setting.SQLUtiliserCode) {
/* 293 */       nomTable = ent.getCode();
/* 294 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 295 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/* 297 */       nomTable = nomTable.toUpperCase();
/*     */     } else {
/* 299 */       nomTable = ent.getNom();
/* 300 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 301 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/*     */     }
/*     */     
/* 305 */     String idx = "";
/* 306 */     if (Setting.SQLPrefixerLeNomContrainte2) idx = "Idx_" + nomTable; else
/* 307 */       idx = nomTable + "_Idx";
/*     */     String nmAK;
/*     */     String nmPK; if (Setting.SQLPrefixerLeNomContrainte2) {
/* 311 */       nmPK = "PK_" + SQLOutil.remplaceChar(nomTable);
/* 312 */       nmAK = "PK_" + SQLOutil.remplaceChar(nomTable);
/*     */     } else {
/* 314 */       nmPK = SQLOutil.remplaceChar(nomTable) + "_PK";
/* 315 */       nmAK = SQLOutil.remplaceChar(nomTable) + "_AK";
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 320 */     String e = "CREATE TABLE " + SQLOutil.remplaceChar(nomTable) + "(\n";
/*     */     
/* 322 */     checkE = "";
/* 323 */     prkey = "";
/* 324 */     uniq = "";
/* 325 */     indexEnt = "";
/* 326 */     int lg = longueurMaxAttribut(listeAttribut);
/* 327 */     for (int i = 0; i < listeAttribut.size(); i++) {
/* 328 */       if (s.trim().length() == 0) { s = "\t" + SQLAttribut((Attribut)listeAttribut.get(i), ent, pageMcd, lg);
/*     */       } else {
/* 330 */         s = s + " ,\n\t" + SQLAttribut((Attribut)listeAttribut.get(i), ent, pageMcd, lg);
/*     */       }
/*     */     }
/*     */     
/* 334 */     if (prkey.trim().length() != 0) s = s + " ,\n\tCONSTRAINT " + nmPK + " PRIMARY KEY (" + prkey + ")";
/* 335 */     if (checkE.trim().length() != 0) s = s + ",\n\t" + checkE;
/* 336 */     if (uniq.trim().length() != 0) { s = s + " ,\n\tCONSTRAINT " + nmAK + " UNIQUE (" + uniq + ")";
/*     */     }
/* 338 */     if (indexEnt.trim().length() != 0) {
/* 339 */       index = index + "CREATE INDEX " + idx + " ON " + SQLOutil.remplaceChar(nomTable) + " (" + indexEnt + ");\n";
/*     */     }
/* 341 */     if (!pageMld.isMutex()) s = s + getAllcontrainteEntite(ent);
/* 342 */     return e + s + "\n);";
/*     */   }
/*     */   
/*     */   private static String SQLListeEntite(IhmPageMCD pagemcd, IhmPageMLD pagemld) {
/* 346 */     String s = "";
/* 347 */     index = "";
/* 348 */     for (int i = 0; i < pagemld.getListeMLDEntite().size(); i++) {
/* 349 */       s = s + "\n------------------------------------------------------------\n";
/* 350 */       s = s + "-- Table: " + ((MLDEntite2)pagemld.getListeMLDEntite().get(i)).getNom();
/* 351 */       s = s + "\n------------------------------------------------------------\n";
/* 352 */       s = s + SQLEntite((MLDEntite2)pagemld.getListeMLDEntite().get(i), pagemcd, pagemld) + "\n";
/*     */     }
/* 354 */     s = s + "\n\n" + index + "\n\n";
/* 355 */     return s;
/*     */   }
/*     */   
/*     */   public static String getScript(IhmPageMCD pagemcd, IhmPageMLD pagemld) {
/* 359 */     sequence = "";
/* 360 */     triggers = "";
/* 361 */     String s = " ---------------------------------------------------------------\n";
/* 362 */     s = s + " --        Script Oracle.  \n";
/* 363 */     s = s + " ---------------------------------------------------------------\n\n";
/*     */     
/* 365 */     s = s + SQLListeEntite(pagemcd, pagemld);
/* 366 */     s = s + "\n" + sequence + "\n\n";
/* 367 */     if (triggers.length() != 0) {
/* 368 */       s = s + triggers + "\n";
/*     */     }
/*     */     
/* 371 */     if (pagemld.isMutex()) { s = s + getAllReference(pagemld);
/*     */     }
/* 373 */     if (!Principale.isActiverJMerise()) {
/* 374 */       s = SQLOutil.getCentLignes(s);
/*     */     }
/*     */     
/* 377 */     return s;
/*     */   }
/*     */   
/*     */   private static String getSQLNomTable(MLDEntite2 ent) {
/* 381 */     String st = "";String s = "";
/* 382 */     if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 383 */       s = SQLOutil.remplaceChar(Setting.developpeur);
/* 384 */       s = s.toUpperCase();
/*     */     }
/* 386 */     if (Setting.SQLUtiliserCode) {
/* 387 */       st = SQLOutil.remplaceChar(ent.getCode());
/*     */     } else {
/* 389 */       st = SQLOutil.remplaceChar(ent.getNom());
/*     */     }
/* 391 */     if (s.length() == 0) s = st; else
/* 392 */       s = s + "_" + st;
/* 393 */     return s;
/*     */   }
/*     */   
/*     */   private static String getNomAttribut(Attribut2 att) {
/* 397 */     if (Setting.SQLUtiliserCode) return SQLOutil.remplaceChar(att.getCode());
/* 398 */     return SQLOutil.remplaceChar(att.getNom());
/*     */   }
/*     */   
/*     */   private static String getUneContrainteFK(TableReference tab, String num) {
/* 402 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 403 */     String att = "";String attRef = "";
/*     */     
/* 405 */     for (int i = 0; i < liste.size(); i++) {
/* 406 */       if (att.length() == 0) {
/* 407 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 408 */         attRef = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */       else {
/* 411 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 412 */         attRef = attRef + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */     }
/* 415 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 416 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 417 */     String nomCnt = "";
/* 418 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "FK_" + nomTab + "_" + nomTabRef + num; else {
/* 419 */       nomCnt = nomTab + "_" + nomTabRef + num + "_FK";
/*     */     }
/* 421 */     String s = "\nALTER TABLE " + nomTab + "\n\tADD CONSTRAINT " + nomCnt + "\n\tFOREIGN KEY (" + att + ")" + "\n\tREFERENCES " + nomTabRef + "(" + attRef + ");\n";
/*     */     
/* 423 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContrainteFK(MLDEntite2 ent) {
/* 427 */     String s = "";
/* 428 */     for (int i = 0; i < ent.getListeCNTForeingKey().size(); i++) {
/* 429 */       s = s + getUneContrainteFK((TableReference)ent.getListeCNTForeingKey().get(i), new StringBuilder().append(i).append("").toString());
/*     */     }
/* 431 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteAK(TableReference tab, String num) {
/* 435 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 436 */     String att = "";
/*     */     
/* 438 */     for (int i = 0; i < liste.size(); i++) {
/* 439 */       if (att.length() == 0) {
/* 440 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */       else
/*     */       {
/* 444 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */     }
/* 447 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 448 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 449 */     String nomCnt = "";
/* 450 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "AK_" + nomTab + "_" + nomTabRef + num; else {
/* 451 */       nomCnt = nomTab + "_" + nomTabRef + num + "_AK";
/*     */     }
/* 453 */     String s = "\nALTER TABLE " + nomTab + "\n\tADD CONSTRAINT " + nomCnt + " \n\tUNIQUE (" + att + ");\n";
/*     */     
/* 455 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContrainteAK(MLDEntite2 ent) {
/* 459 */     String s = "";
/* 460 */     for (int i = 0; i < ent.getListeCNTALTERNATIVEKEY().size(); i++) {
/* 461 */       s = s + getUneContrainteAK((TableReference)ent.getListeCNTALTERNATIVEKEY().get(i), new StringBuilder().append(i).append("").toString());
/*     */     }
/* 463 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContraintesEntite(MLDEntite2 ent) {
/* 467 */     String s = "";
/* 468 */     s = getAllContrainteFK(ent);
/* 469 */     s = s + getAllContrainteAK(ent);
/* 470 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllReference(IhmPageMLD page) {
/* 474 */     String s = "";
/*     */     
/* 476 */     for (int i = 0; i < page.getListeMLDEntite().size(); i++) {
/* 477 */       s = s + getAllContraintesEntite((MLDEntite2)page.getListeMLDEntite().get(i));
/*     */     }
/* 479 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteFK_Interne(TableReference tab, String num)
/*     */   {
/* 484 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 485 */     String att = "";String attRef = "";
/*     */     
/* 487 */     for (int i = 0; i < liste.size(); i++) {
/* 488 */       if (att.length() == 0) {
/* 489 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 490 */         attRef = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */       else {
/* 493 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 494 */         attRef = attRef + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */     }
/* 497 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 498 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 499 */     String nomCnt = "";
/* 500 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "FK_" + nomTab + "_" + nomTabRef + num; else {
/* 501 */       nomCnt = nomTab + "_" + nomTabRef + num + "_FK";
/*     */     }
/* 503 */     String s = "\n\t,CONSTRAINT " + nomCnt + " FOREIGN KEY (" + att + ")" + " REFERENCES " + nomTabRef + "(" + attRef + ")";
/*     */     
/* 505 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteAK_Interne(TableReference tab, String num)
/*     */   {
/* 510 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 511 */     String att = "";
/*     */     
/* 513 */     for (int i = 0; i < liste.size(); i++) {
/* 514 */       if (att.length() == 0) {
/* 515 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */       else {
/* 518 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */     }
/* 521 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 522 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 523 */     String nomCnt = "";
/* 524 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "AK_" + nomTab + "_" + nomTabRef + num; else {
/* 525 */       nomCnt = nomTab + "_" + nomTabRef + num + "_AK";
/*     */     }
/* 527 */     String s = "\n\t,CONSTRAINT " + nomCnt + " UNIQUE (" + att + ")";
/*     */     
/* 529 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllcontrainteEntite(MLDEntite2 ent) {
/* 533 */     String s = "";
/* 534 */     String nn = "";
/* 535 */     for (int i = 0; i < ent.getListeCNTForeingKey().size(); i++) {
/* 536 */       s = s + getUneContrainteFK_Interne((TableReference)ent.getListeCNTForeingKey().get(i), nn);
/* 537 */       nn = i + "";
/*     */     }
/* 539 */     if (s.length() > 0) s = "\n" + s;
/* 540 */     nn = "";
/* 541 */     for (int i = 0; i < ent.getListeCNTALTERNATIVEKEY().size(); i++) {
/* 542 */       s = s + getUneContrainteAK_Interne((TableReference)ent.getListeCNTALTERNATIVEKEY().get(i), nn);
/* 543 */       nn = i + "";
/*     */     }
/* 545 */     return s;
/*     */   }
/*     */   
/*     */   public static ArrayList<String> creerListeTable(String script) {
/* 549 */     ArrayList<String> listeTable = new ArrayList();
/*     */     
/* 551 */     String trig = "";
/* 552 */     String f = "";String d = " ";String table = "";
/* 553 */     int indexx = -1;
/* 554 */     String scriptCREATE = script.substring(0, script.toUpperCase().indexOf("ALTER"));
/* 555 */     String scriptALTER = script.substring(script.toUpperCase().indexOf("ALTER"), script.length());
/* 556 */     indexx = scriptCREATE.toUpperCase().indexOf("CREATE");
/* 557 */     scriptCREATE = scriptCREATE.substring(indexx);
/* 558 */     if (indexx > -1) {
/* 559 */       while (indexx > -1)
/*     */       {
/* 561 */         d = scriptCREATE.substring(0, scriptCREATE.toUpperCase().indexOf(";") + 1);
/* 562 */         scriptCREATE = scriptCREATE.substring(scriptCREATE.indexOf(";") + 1);
/* 563 */         listeTable.add(d);
/* 564 */         indexx = scriptCREATE.toUpperCase().indexOf("CREATE");
/*     */       }
/*     */     }
/*     */     
/* 568 */     indexx = scriptALTER.toUpperCase().indexOf("ALTER");
/* 569 */     scriptALTER = scriptALTER.substring(indexx);
/* 570 */     if (indexx > -1) {
/* 571 */       while (indexx > -1) {
/* 572 */         d = scriptALTER.substring(0, scriptALTER.toUpperCase().indexOf(";") + 1);
/* 573 */         scriptALTER = scriptALTER.substring(scriptALTER.indexOf(";") + 1);
/* 574 */         listeTable.add(d);
/* 575 */         indexx = scriptALTER.toUpperCase().indexOf("ALTER");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 580 */     return listeTable;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Output\SQLOracle.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */