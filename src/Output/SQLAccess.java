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
/*     */ public class SQLAccess
/*     */ {
/*  25 */   private static String index = "";
/*     */   
/*     */ 
/*     */   private static String getSQLPKey(MLDEntite2 ent, ArrayList<Attribut> listeAttribut)
/*     */   {
/*  30 */     ArrayList<Attribut> liste = new ArrayList();
/*  31 */     String s = "";
/*  32 */     for (int i = 0; i < listeAttribut.size(); i++) {
/*  33 */       if (((Attribut)listeAttribut.get(i)).getKey().equals(Parametres.Cle)) {
/*  34 */         liste.add(listeAttribut.get(i));
/*     */       }
/*     */     }
/*  37 */     for (int i = 0; i < liste.size(); i++) {
/*  38 */       if (s.length() == 0) s = getNomAttribut((Attribut2)liste.get(i)); else {
/*  39 */         s = s + "," + getNomAttribut((Attribut2)liste.get(i));
/*     */       }
/*     */     }
/*  42 */     if (s.length() > 0) {
/*  43 */       String nmPK = getSQLNomTable(ent);
/*  44 */       if (Setting.SQLPrefixerLeNomContrainte2) nmPK = "PK_" + nmPK; else {
/*  45 */         nmPK = nmPK + "_PK";
/*     */       }
/*  47 */       s = "\n\t,CONSTRAINT " + nmPK + " PRIMARY KEY (" + s + ")";
/*     */     }
/*     */     
/*  50 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */   private static ArrayList<Attribut> getListeUnque(ArrayList<Attribut> liste)
/*     */   {
/*  56 */     ArrayList<Attribut> l = new ArrayList();
/*  57 */     for (int i = 0; i < liste.size(); i++) {
/*  58 */       Attribut att = (Attribut)liste.get(i);
/*  59 */       if (att.getKey().equals(Parametres.Unique)) {
/*  60 */         l.add(att);
/*     */       }
/*     */     }
/*  63 */     return l;
/*     */   }
/*     */   
/*     */   private static String getCNTUniqueInterne(MLDEntite2 ent, ArrayList<Attribut> listeAtt) {
/*  67 */     ArrayList<Attribut> l = getListeUnque(listeAtt);
/*  68 */     if (l.size() == 0) return "";
/*  69 */     String sAtt = "";String s = "";
/*     */     
/*  71 */     for (int i = 0; i < l.size(); i++) {
/*  72 */       Attribut2 att = (Attribut2)l.get(i);
/*  73 */       if (Setting.SQLUtiliserCode) sAtt = SQLOutil.remplaceChar(att.getCode()); else
/*  74 */         sAtt = SQLOutil.remplaceChar(att.getNom());
/*  75 */       if (s.length() == 0) s = sAtt; else
/*  76 */         s = s + "," + sAtt;
/*     */     }
/*  78 */     String nmCnt = "";
/*  79 */     if (Setting.SQLUtiliserCode) nmCnt = ent.getCode(); else
/*  80 */       nmCnt = ent.getNom();
/*  81 */     if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/*  82 */       nmCnt = Setting.developpeur + "_" + nmCnt;
/*     */     }
/*  84 */     if (Setting.SQLPrefixerLeNomContrainte2)
/*  85 */       nmCnt = "AK_" + nmCnt; else {
/*  86 */       nmCnt = nmCnt + "_AK";
/*     */     }
/*  88 */     if (ent.getListeCNTALTERNATIVEKEY().size() > 0) nmCnt = nmCnt + "_AK" + "0";
/*  89 */     nmCnt = SQLOutil.remplaceChar(nmCnt);
/*  90 */     s = "\n\t,CONSTRAINT " + nmCnt + " UNIQUE (" + s + ")";
/*  91 */     return s;
/*     */   }
/*     */   
/*     */   private static String getCNTINDEXInterne(MLDEntite2 ent, ArrayList<Attribut> listeAtt) {
/*  95 */     ArrayList<Attribut> l = getListeIndex(listeAtt);
/*  96 */     if (l.size() == 0) return "";
/*  97 */     String sAtt = "";String s = "";
/*     */     
/*  99 */     for (int i = 0; i < l.size(); i++) {
/* 100 */       Attribut2 att = (Attribut2)l.get(i);
/* 101 */       sAtt = getNomAttribut(att);
/*     */       
/* 103 */       if (s.length() == 0) s = sAtt; else
/* 104 */         s = s + "," + sAtt;
/*     */     }
/* 106 */     String nmCnt = getSQLNomTable(ent);
/*     */     
/* 108 */     String nomTable = nmCnt;
/*     */     
/* 110 */     if (Setting.SQLPrefixerLeNomContrainte2)
/* 111 */       nmCnt = "Idx_" + nmCnt; else
/* 112 */       nmCnt = nmCnt + "_Idx";
/* 113 */     nmCnt = SQLOutil.remplaceChar(nmCnt);
/* 114 */     if (s.trim().length() == 0) return "";
/* 115 */     s = "\nCREATE INDEX " + nmCnt + " ON " + nomTable + " (" + s + ");";
/* 116 */     return s;
/*     */   }
/*     */   
/*     */   private static ArrayList<Attribut> getListeIndex(ArrayList<Attribut> liste)
/*     */   {
/* 121 */     ArrayList<Attribut> l = new ArrayList();
/* 122 */     for (int i = 0; i < liste.size(); i++) {
/* 123 */       Attribut att = (Attribut)liste.get(i);
/* 124 */       if (att.getKey().equals(Parametres.Index)) {
/* 125 */         l.add(att);
/*     */       }
/*     */     }
/* 128 */     return l;
/*     */   }
/*     */   
/*     */   private static boolean isDomaine(Attribut att, IhmPageMCD page) {
/* 132 */     ArrayList<Domaine> list = page.getListeDomaine();
/* 133 */     for (int i = 0; i < list.size(); i++) {
/* 134 */       if (att.getType().trim().toUpperCase().equals(((Domaine)list.get(i)).getNom().trim().toUpperCase()))
/* 135 */         return true;
/*     */     }
/* 137 */     return false;
/*     */   }
/*     */   
/*     */   private static String remplacerType(Attribut att) {
/* 141 */     String t = "";
/* 142 */     String type = att.getType();
/* 143 */     String nul = att.isNulle() ? " " : " NOT NULL";
/*     */     
/* 145 */     if (att.getKey().equals(Parametres.Cle)) { nul = " NOT NULL";
/*     */     }
/* 147 */     else if (att.getKey().equals(Parametres.Index)) { nul = " NOT NULL";
/*     */     }
/* 149 */     else if (att.getKey().equals(Parametres.Unique)) { nul = " NOT NULL";
/*     */     }
/*     */     
/*     */ 
/* 153 */     if (type.trim().toUpperCase().equals("AUTO_INCREMENT")) {
/* 154 */       t = "COUNTER NOT NULL";
/*     */     }
/* 156 */     if (type.trim().toUpperCase().equals("VARCHAR")) {
/* 157 */       t = "TEXT (" + att.getLongueur() + ")" + nul;
/*     */     }
/* 159 */     if (type.trim().toUpperCase().equals("INTEGER")) {
/* 160 */       t = "INTEGER " + nul;
/*     */     }
/*     */     
/* 163 */     if (type.trim().toUpperCase().equals("FLOAT")) {
/* 164 */       t = "DOUBLE " + nul;
/*     */     }
/* 166 */     if (type.trim().toUpperCase().equals("BLOB")) {
/* 167 */       t = "LONGBINARY " + nul;
/*     */     }
/* 169 */     if (type.trim().toUpperCase().equals("DECIMAL")) {
/* 170 */       t = "DECIMAL (" + att.getLongueur() + "," + att.getLongDecimale() + ") " + nul;
/*     */     }
/*     */     
/* 173 */     if (type.trim().toUpperCase().equals("MONEY")) {
/* 174 */       t = "MONEY " + nul;
/*     */     }
/*     */     
/* 177 */     if (type.trim().toUpperCase().equals("DOUBLE PRECISION")) {
/* 178 */       t = "DOUBLE " + nul;
/*     */     }
/* 180 */     if (type.trim().toUpperCase().equals("NUMERIC")) {
/* 181 */       t = "NUMERIC (" + att.getLongueur() + "," + att.getLongDecimale() + ") " + nul;
/*     */     }
/* 183 */     if (type.trim().toUpperCase().equals("SMALLINT")) {
/* 184 */       t = "SMALLINT " + nul;
/*     */     }
/* 186 */     if (type.trim().toUpperCase().equals("CHAR")) {
/* 187 */       t = "CHAR (" + att.getLongueur() + ") " + nul;
/*     */     }
/* 189 */     if (type.trim().toUpperCase().equals("DATE")) {
/* 190 */       t = "DATE " + nul;
/*     */     }
/*     */     
/* 193 */     if (type.trim().toUpperCase().equals("BOOL")) {
/* 194 */       t = "LOGICAL " + nul;
/*     */     }
/* 196 */     if (type.trim().toUpperCase().equals("INT")) {
/* 197 */       t = "INT " + nul;
/*     */     }
/* 199 */     if (type.trim().toUpperCase().equals("DATETIME")) {
/* 200 */       t = "DATETIME " + nul;
/*     */     }
/* 202 */     if (type.trim().toUpperCase().equals("DOUBLE")) {
/* 203 */       t = "DOUBLE " + nul;
/*     */     }
/*     */     
/* 206 */     if (type.trim().toUpperCase().equals("LONGBLOB")) {
/* 207 */       t = "LONGBINARY " + nul;
/*     */     }
/* 209 */     if (type.trim().toUpperCase().equals("LONGTEXT")) {
/* 210 */       t = "LONGTEXT " + nul;
/*     */     }
/* 212 */     if (type.trim().toUpperCase().equals("MEDIUMBLOB")) {
/* 213 */       t = "LONGBINARY " + nul;
/*     */     }
/* 215 */     if (type.trim().toUpperCase().equals("MEDIUMINT")) {
/* 216 */       t = "INT " + nul;
/*     */     }
/* 218 */     if (type.trim().toUpperCase().equals("MEDIUMTEXT")) {
/* 219 */       t = " LONGTEXT " + nul;
/*     */     }
/* 221 */     if (type.trim().toUpperCase().equals("REAL")) {
/* 222 */       t = "DOUBLE " + nul;
/*     */     }
/*     */     
/* 225 */     if (type.trim().toUpperCase().equals("TEXT")) {
/* 226 */       t = "LONGTEXT " + nul;
/*     */     }
/* 228 */     if (type.trim().toUpperCase().equals("TIME")) {
/* 229 */       t = "TIME " + nul;
/*     */     }
/* 231 */     if (type.trim().toUpperCase().equals("TIMESTAMP")) {
/* 232 */       t = "DATETIME" + nul;
/*     */     }
/* 234 */     if (type.trim().toUpperCase().equals("TINYBLOB")) {
/* 235 */       t = "LONGBINARY " + nul;
/*     */     }
/* 237 */     if (type.trim().toUpperCase().equals("TINYINT")) {
/* 238 */       t = "INTEGER " + nul;
/*     */     }
/* 240 */     if (type.trim().toUpperCase().equals("TINYTEXT")) {
/* 241 */       t = "LONGTEXT " + nul;
/*     */     }
/* 243 */     if (type.trim().toUpperCase().equals("YEAR")) {
/* 244 */       t = "INTEGER " + nul;
/*     */     }
/*     */     
/* 247 */     return t;
/*     */   }
/*     */   
/*     */   private static String SQLDomaine(Domaine d) {
/* 251 */     String s = "";
/* 252 */     for (int i = 0; i < d.getListeValeurs().size(); i++) {
/* 253 */       s = s + "\"" + (String)d.getListeValeurs().get(i) + "\"";
/* 254 */       if (i + 1 < d.getListeValeurs().size()) {
/* 255 */         s = s + ",";
/*     */       }
/*     */     }
/* 258 */     if (s.length() > 0) {
/* 259 */       s = "TEXT CHECK (value IN (" + s + ")) ";
/*     */     }
/* 261 */     return s;
/*     */   }
/*     */   
/*     */   private static String SQLGetTypeEnum(Attribut attr, String type, IhmPageMCD page) {
/* 265 */     String s = "";
/* 266 */     ArrayList<Domaine> list = page.getListeDomaine();
/* 267 */     Domaine d = null;
/* 268 */     String nul = attr.isNulle() ? " " : " NOT NULL ";
/* 269 */     for (int i = 0; i < list.size(); i++) {
/* 270 */       if (type.equals(((Domaine)list.get(i)).getNom())) {
/* 271 */         d = (Domaine)list.get(i);
/* 272 */         break;
/*     */       }
/*     */     }
/* 275 */     if (d != null) {
/* 276 */       s = SQLDomaine(d);
/*     */     }
/* 278 */     return s;
/*     */   }
/*     */   
/*     */   private static String getType(Attribut att, IhmPageMCD page)
/*     */   {
/* 283 */     if (isDomaine(att, page)) {
/* 284 */       String ss = SQLGetTypeEnum(att, att.getType(), page);
/* 285 */       return ss;
/*     */     }
/* 287 */     return remplacerType(att);
/*     */   }
/*     */   
/*     */ 
/*     */   private static String ajusterNom(String nom, int tailMax)
/*     */   {
/* 293 */     nom = SQLOutil.remplaceChar(nom);
/* 294 */     for (int i = nom.length(); i < tailMax; i++) {
/* 295 */       nom = nom + " ";
/*     */     }
/* 297 */     return nom;
/*     */   }
/*     */   
/*     */   private static int longueurMaxAttribut(ArrayList<Attribut> listeAttributs) {
/* 301 */     int max = 0;
/*     */     
/*     */ 
/* 304 */     for (int i = 0; i < listeAttributs.size(); i++) {
/* 305 */       Attribut2 att = (Attribut2)listeAttributs.get(i);
/* 306 */       String nom;if (Setting.SQLUtiliserCode) {
/* 307 */         nom = att.getCode();
/*     */       } else {
/* 309 */         nom = att.getNom();
/*     */       }
/* 311 */       if (nom.length() > max) {
/* 312 */         max = nom.length();
/*     */       }
/*     */     }
/* 315 */     return max;
/*     */   }
/*     */   
/*     */   private static String SQLAttribut(Attribut att, String tab, IhmPageMCD page, int lg) {
/* 319 */     String s = "";
/* 320 */     String cle = "";
/*     */     String nomAtt;
/* 323 */     if (Setting.SQLUtiliserCode) {
/* 324 */       nomAtt = ((Attribut2)att).getCode();
/*     */     } else {
/* 326 */       nomAtt = att.getNom();
/*     */     }
/*     */     
/* 329 */     if (isDomaine(att, page)) cle = "";
/* 330 */     s = s + ajusterNom(nomAtt, lg) + " " + getType(att, page) + " " + cle;
/* 331 */     return s;
/*     */   }
/*     */   
/*     */   private static String SQLEntite(MLDEntite2 ent, IhmPageMCD page, IhmPageMLD pageMld) {
/* 335 */     String s = "";
/* 337 */     ArrayList<Attribut> listeAttribut; if (ent.isComposer()) {
/* 338 */       listeAttribut = SQLOutil.decomposerLesAttributsMLDEntite(ent);
/*     */     } else {
/* 340 */       listeAttribut = ent.getListeAttributs();
/*     */     }
/*     */     
/* 343 */     int lg = longueurMaxAttribut(listeAttribut);
/*     */     
/* 345 */     String nomTable = getSQLNomTable(ent);
/*     */     
/* 347 */     s = "CREATE TABLE " + SQLOutil.remplaceChar(nomTable) + "(\n\t";
/* 348 */     for (int i = 0; i < listeAttribut.size(); i++) {
/* 349 */       s = s + SQLAttribut((Attribut)listeAttribut.get(i), nomTable, page, lg);
/* 350 */       if (i + 1 < listeAttribut.size()) {
/* 351 */         s = s + ",\n\t";
/*     */       } else {
/* 353 */         String k = getSQLPKey(ent, listeAttribut);
/* 354 */         index += getCNTINDEXInterne(ent, listeAttribut);
/* 355 */         String uniq = getCNTUniqueInterne(ent, listeAttribut);
/* 356 */         s = s + uniq;
/* 357 */         if (k.trim().length() != 0) s = s + "\n\t" + k;
/* 358 */         k = "";
/* 359 */         if (!pageMld.isMutex()) k = getAllcontrainteEntite(ent);
/* 360 */         s = s + k;
/* 361 */         s = s + "\n);\n";
/*     */       }
/*     */     }
/* 364 */     return s;
/*     */   }
/*     */   
/* 367 */   private static String SQLListeEntite(ArrayList<MLDEntite2> listeMLD, IhmPageMCD page, IhmPageMLD pageMld) { index = "";
/* 368 */     String s = "";
/* 369 */     for (int i = 0; i < listeMLD.size(); i++) {
/* 370 */       s = s + "\n------------------------------------------------------------\n";
/* 371 */       s = s + "-- Table: " + ((MLDEntite2)listeMLD.get(i)).getNom();
/* 372 */       s = s + "\n------------------------------------------------------------\n";
/* 373 */       s = s + SQLEntite((MLDEntite2)listeMLD.get(i), page, pageMld) + "\n";
/*     */     }
/*     */     
/* 376 */     return s;
/*     */   }
/*     */   
/*     */   private static String getScriptAllContrainteExterne(IhmPageMLD pageMld)
/*     */   {
/* 381 */     String s = "";
/*     */     
/*     */ 
/*     */ 
/* 385 */     for (int i = 0; i < pageMld.getListeMLDEntite().size(); i++) {
/* 386 */       String ntable = getSQLNomTable((MLDEntite2)pageMld.getListeMLDEntite().get(i));
/* 387 */       String c = ((MLDEntite2)pageMld.getListeMLDEntite().get(i)).getSQLALLContrainteExternal(ntable);
/* 388 */       if (c.trim().length() > 0)
/* 389 */         s = s + c;
/*     */     }
/* 391 */     return s;
/*     */   }
/*     */   
/*     */   public static String getScript(IhmPageMLD pageMld, IhmPageMCD pageMcd) {
/* 395 */     String s = "";
/* 396 */     s = "------------------------------------------------------------\n";
/* 397 */     s = s + "--        Script Access \n";
/* 398 */     s = s + "------------------------------------------------------------\n\n";
/*     */     
/* 400 */     s = s + SQLListeEntite(pageMld.getListeMLDEntite(), pageMcd, pageMld) + "\n";
/*     */     
/* 402 */     String c = "";
/* 403 */     c = c + "\n" + index;
/* 404 */     if (pageMld.isMutex()) {
/* 405 */       c = c + "\n\n" + getAllReference(pageMld);
/*     */     }
/* 407 */     if (c.length() > 0) {
/* 408 */       s = s + c;
/*     */     }
/*     */     
/* 411 */     if (!Principale.isActiverJMerise()) {
/* 412 */       s = SQLOutil.getCentLignes(s);
/*     */     }
/*     */     
/* 415 */     return s;
/*     */   }
/*     */   
/*     */   private static String getSQLNomTable(MLDEntite2 ent)
/*     */   {
/* 420 */     String st = "";String s = "";
/* 421 */     if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 422 */       s = SQLOutil.remplaceChar(Setting.developpeur);
/* 423 */       s = s.toUpperCase();
/*     */     }
/* 425 */     if (Setting.SQLUtiliserCode) {
/* 426 */       st = SQLOutil.remplaceChar(ent.getCode());
/*     */     } else {
/* 428 */       st = SQLOutil.remplaceChar(ent.getNom());
/*     */     }
/* 430 */     if (s.length() == 0) s = st; else
/* 431 */       s = s + "_" + st;
/* 432 */     return s;
/*     */   }
/*     */   
/*     */   private static String getNomAttribut(Attribut2 att) {
/* 436 */     if (Setting.SQLUtiliserCode) return SQLOutil.remplaceChar(att.getCode());
/* 437 */     return SQLOutil.remplaceChar(att.getNom());
/*     */   }
/*     */   
/*     */   private static String getUneContrainteFK(TableReference tab, String num) {
/* 441 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 442 */     String att = "";String attRef = "";
/*     */     
/* 444 */     for (int i = 0; i < liste.size(); i++) {
/* 445 */       if (att.length() == 0) {
/* 446 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 447 */         attRef = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */       else {
/* 450 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 451 */         attRef = attRef + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */     }
/* 454 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 455 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 456 */     String nomCnt = "";
/* 457 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "FK_" + nomTab + "_" + nomTabRef + num; else {
/* 458 */       nomCnt = nomTab + "_" + nomTabRef + num + "_FK";
/*     */     }
/* 460 */     String s = "\nALTER TABLE " + nomTab + "\n\tADD CONSTRAINT " + nomCnt + "\n\tFOREIGN KEY (" + att + ")" + "\n\tREFERENCES " + nomTabRef + "(" + attRef + ");\n";
/*     */     
/* 462 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContrainteFK(MLDEntite2 ent) {
/* 466 */     String s = "";
/* 467 */     for (int i = 0; i < ent.getListeCNTForeingKey().size(); i++) {
/* 468 */       s = s + getUneContrainteFK((TableReference)ent.getListeCNTForeingKey().get(i), new StringBuilder().append(i).append("").toString());
/*     */     }
/* 470 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteAK(TableReference tab, String num) {
/* 474 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 475 */     String att = "";
/*     */     
/* 477 */     for (int i = 0; i < liste.size(); i++) {
/* 478 */       if (att.length() == 0) {
/* 479 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */       else
/*     */       {
/* 483 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */     }
/* 486 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 487 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 488 */     String nomCnt = "";
/* 489 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "AK_" + nomTab + "_" + nomTabRef + num; else {
/* 490 */       nomCnt = nomTab + "_" + nomTabRef + num + "_AK";
/*     */     }
/* 492 */     String s = "\nALTER TABLE " + nomTab + " \n\tADD CONSTRAINT " + nomCnt + " \n\tUNIQUE (" + att + ");\n";
/*     */     
/* 494 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContrainteAK(MLDEntite2 ent) {
/* 498 */     String s = "";
/* 499 */     for (int i = 0; i < ent.getListeCNTALTERNATIVEKEY().size(); i++) {
/* 500 */       s = s + getUneContrainteAK((TableReference)ent.getListeCNTALTERNATIVEKEY().get(i), new StringBuilder().append(i).append("").toString());
/*     */     }
/* 502 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContraintesEntite(MLDEntite2 ent) {
/* 506 */     String s = "";
/* 507 */     s = getAllContrainteFK(ent);
/* 508 */     s = s + getAllContrainteAK(ent);
/* 509 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllReference(IhmPageMLD page) {
/* 513 */     String s = "";
/*     */     
/* 515 */     for (int i = 0; i < page.getListeMLDEntite().size(); i++) {
/* 516 */       s = s + getAllContraintesEntite((MLDEntite2)page.getListeMLDEntite().get(i));
/*     */     }
/* 518 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteFK_Interne(TableReference tab, String num)
/*     */   {
/* 523 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 524 */     String att = "";String attRef = "";
/*     */     
/* 526 */     for (int i = 0; i < liste.size(); i++) {
/* 527 */       if (att.length() == 0) {
/* 528 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 529 */         attRef = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */       else {
/* 532 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 533 */         attRef = attRef + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */     }
/* 536 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 537 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 538 */     String nomCnt = "";
/* 539 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "FK_" + nomTab + "_" + nomTabRef + num; else {
/* 540 */       nomCnt = nomTab + "_" + nomTabRef + num + "_FK";
/*     */     }
/* 542 */     String s = "\n\t,CONSTRAINT " + nomCnt + " FOREIGN KEY (" + att + ")" + " REFERENCES " + nomTabRef + "(" + attRef + ")";
/*     */     
/* 544 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteAK_Interne(TableReference tab, String num)
/*     */   {
/* 549 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 550 */     String att = "";
/*     */     
/* 552 */     for (int i = 0; i < liste.size(); i++) {
/* 553 */       if (att.length() == 0) {
/* 554 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */       else {
/* 557 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */     }
/* 560 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 561 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 562 */     String nomCnt = "";
/* 563 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "AK_" + nomTab + "_" + nomTabRef + num; else {
/* 564 */       nomCnt = nomTab + "_" + nomTabRef + num + "_AK";
/*     */     }
/* 566 */     String s = "\n\t,CONSTRAINT " + nomCnt + " UNIQUE (" + att + ")";
/*     */     
/* 568 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllcontrainteEntite(MLDEntite2 ent) {
/* 572 */     String s = "";
/* 573 */     String nn = "";
/* 574 */     for (int i = 0; i < ent.getListeCNTForeingKey().size(); i++) {
/* 575 */       s = s + getUneContrainteFK_Interne((TableReference)ent.getListeCNTForeingKey().get(i), nn);
/* 576 */       nn = i + "";
/*     */     }
/* 578 */     if (s.length() > 0) s = "\n" + s;
/* 579 */     nn = "";
/* 580 */     for (int i = 0; i < ent.getListeCNTALTERNATIVEKEY().size(); i++) {
/* 581 */       s = s + getUneContrainteAK_Interne((TableReference)ent.getListeCNTALTERNATIVEKEY().get(i), nn);
/* 582 */       nn = i + "";
/*     */     }
/* 584 */     return s;
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
/*     */   public static ArrayList<String> creerListeTable(String script)
/*     */   {
/* 597 */     ArrayList<String> listeTable = new ArrayList();
/*     */     
/* 599 */     String f = "";String d = " ";String table = "";
/* 600 */     int indexx = -1;
/* 601 */     String scriptCREATE = script.substring(0, script.toUpperCase().indexOf("ALTER"));
/* 602 */     String scriptALTER = script.substring(script.toUpperCase().indexOf("ALTER"), script.length());
/* 603 */     indexx = scriptCREATE.toUpperCase().indexOf("CREATE");
/* 604 */     scriptCREATE = scriptCREATE.substring(indexx);
/* 605 */     if (indexx > -1) {
/* 606 */       while (indexx > -1) {
/* 607 */         d = scriptCREATE.substring(0, scriptCREATE.toUpperCase().indexOf(";") + 1);
/* 608 */         scriptCREATE = scriptCREATE.substring(scriptCREATE.indexOf(";") + 1);
/* 609 */         listeTable.add(d);
/* 610 */         indexx = scriptCREATE.toUpperCase().indexOf("CREATE");
/*     */       }
/*     */     }
/*     */     
/* 614 */     indexx = scriptALTER.toUpperCase().indexOf("ALTER");
/* 615 */     scriptALTER = scriptALTER.substring(indexx);
/* 616 */     if (indexx > -1) {
/* 617 */       while (indexx > -1) {
/* 618 */         d = scriptALTER.substring(0, scriptALTER.toUpperCase().indexOf(";") + 1);
/* 619 */         scriptALTER = scriptALTER.substring(scriptALTER.indexOf(";") + 1);
/* 620 */         listeTable.add(d);
/* 621 */         indexx = scriptALTER.toUpperCase().indexOf("ALTER");
/*     */       }
/*     */     }
/*     */     
/* 625 */     return listeTable;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Output\SQLAccess.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */