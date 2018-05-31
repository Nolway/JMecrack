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
/*     */ public class SQLHsqldb
/*     */ {
/*  25 */   private static String index = "";
/*  26 */   private static String indexEnt = "";
/*  27 */   private static String checkE = "";
/*  28 */   private static String prkey = "";
/*  29 */   private static String uniq = "";
/*     */   
/*     */ 
/*     */   private static String remplacerType(Attribut att)
/*     */   {
/*  34 */     String t = "";
/*  35 */     String type = att.getType();
/*  36 */     String nul = att.isNulle() ? " " : " NOT NULL";
/*     */     
/*  38 */     if (att.getKey().equals(Parametres.Cle)) { nul = " NOT NULL";
/*     */     }
/*  40 */     else if (att.getKey().equals(Parametres.Index)) { nul = " NOT NULL";
/*     */     }
/*  42 */     else if (att.getKey().equals(Parametres.Unique)) { nul = " NOT NULL";
/*     */     }
/*     */     
/*     */ 
/*  46 */     if (type.trim().toUpperCase().equals("AUTO_INCREMENT")) {
/*  47 */       t = "IDENTITY NOT NULL";
/*     */     }
/*  49 */     if (type.trim().toUpperCase().equals("VARCHAR")) {
/*  50 */       t = "VARCHAR (" + att.getLongueur() + ")" + nul;
/*     */     }
/*  52 */     if (type.trim().toUpperCase().equals("INTEGER")) {
/*  53 */       t = "INTEGER " + nul;
/*     */     }
/*     */     
/*  56 */     if (type.trim().toUpperCase().equals("FLOAT")) {
/*  57 */       t = "FLOAT " + nul;
/*     */     }
/*  59 */     if (type.trim().toUpperCase().equals("BLOB")) {
/*  60 */       t = "LONGVARCHAR " + nul;
/*     */     }
/*  62 */     if (type.trim().toUpperCase().equals("DECIMAL")) {
/*  63 */       t = "DECIMAL (" + att.getLongueur() + "," + att.getLongDecimale() + ") " + nul;
/*     */     }
/*     */     
/*  66 */     if (type.trim().toUpperCase().equals("MONEY")) {
/*  67 */       t = "DECIMAL (15,3)" + nul;
/*     */     }
/*     */     
/*  70 */     if (type.trim().toUpperCase().equals("DOUBLE PRECISION")) {
/*  71 */       t = "DOUBLE " + nul;
/*     */     }
/*  73 */     if (type.trim().toUpperCase().equals("NUMERIC")) {
/*  74 */       t = "NUMERIC (" + att.getLongueur() + "," + att.getLongDecimale() + ") " + nul;
/*     */     }
/*  76 */     if (type.trim().toUpperCase().equals("SMALLINT")) {
/*  77 */       t = "SMALLINT " + nul;
/*     */     }
/*  79 */     if (type.trim().toUpperCase().equals("CHAR")) {
/*  80 */       t = "CHAR (" + att.getLongueur() + ") " + nul;
/*     */     }
/*  82 */     if (type.trim().toUpperCase().equals("DATE")) {
/*  83 */       t = "DATE " + nul;
/*     */     }
/*     */     
/*  86 */     if (type.trim().toUpperCase().equals("BOOL")) {
/*  87 */       t = "BOOLEAN " + nul;
/*     */     }
/*  89 */     if (type.trim().toUpperCase().equals("INT")) {
/*  90 */       t = "INTEGER " + nul;
/*     */     }
/*  92 */     if (type.trim().toUpperCase().equals("DATETIME")) {
/*  93 */       t = "DATETIME " + nul;
/*     */     }
/*  95 */     if (type.trim().toUpperCase().equals("DOUBLE")) {
/*  96 */       t = "DOUBLE " + nul;
/*     */     }
/*     */     
/*  99 */     if (type.trim().toUpperCase().equals("LONGBLOB")) {
/* 100 */       t = "LONGVARCHAR " + nul;
/*     */     }
/* 102 */     if (type.trim().toUpperCase().equals("LONGTEXT")) {
/* 103 */       t = "LONGVARCHAR " + nul;
/*     */     }
/* 105 */     if (type.trim().toUpperCase().equals("MEDIUMBLOB")) {
/* 106 */       t = "LONGVARCHAR " + nul;
/*     */     }
/* 108 */     if (type.trim().toUpperCase().equals("MEDIUMINT")) {
/* 109 */       t = "SMALLINT " + nul;
/*     */     }
/* 111 */     if (type.trim().toUpperCase().equals("MEDIUMTEXT")) {
/* 112 */       t = "LONGVARCHAR " + nul;
/*     */     }
/* 114 */     if (type.trim().toUpperCase().equals("REAL")) {
/* 115 */       t = "REAL " + nul;
/*     */     }
/*     */     
/* 118 */     if (type.trim().toUpperCase().equals("TEXT")) {
/* 119 */       t = "LONGVARCHAR " + nul;
/*     */     }
/* 121 */     if (type.trim().toUpperCase().equals("TIME")) {
/* 122 */       t = "TIME " + nul;
/*     */     }
/* 124 */     if (type.trim().toUpperCase().equals("TIMESTAMP")) {
/* 125 */       t = "DATETIME " + nul;
/*     */     }
/* 127 */     if (type.trim().toUpperCase().equals("TINYBLOB")) {
/* 128 */       t = "LONGVARCHAR " + nul;
/*     */     }
/* 130 */     if (type.trim().toUpperCase().equals("TINYINT")) {
/* 131 */       t = "TINYINT " + nul;
/*     */     }
/* 133 */     if (type.trim().toUpperCase().equals("TINYTEXT")) {
/* 134 */       t = "LONGVARCHAR " + nul;
/*     */     }
/* 136 */     if (type.trim().toUpperCase().equals("YEAR")) {
/* 137 */       t = "INTEGER " + nul;
/*     */     }
/*     */     
/* 140 */     return t;
/*     */   }
/*     */   
/*     */   private static boolean isDomaine(Attribut att, IhmPageMCD page) {
/* 144 */     ArrayList<Domaine> list = page.getListeDomaine();
/* 145 */     for (int i = 0; i < list.size(); i++) {
/* 146 */       if (att.getType().trim().toUpperCase().equals(((Domaine)list.get(i)).getNom().trim().toUpperCase()))
/* 147 */         return true;
/*     */     }
/* 149 */     return false;
/*     */   }
/*     */   
/*     */   private static Domaine retourneDomaine(Attribut att, IhmPageMCD page) {
/* 153 */     ArrayList<Domaine> list = page.getListeDomaine();
/* 154 */     for (int i = 0; i < list.size(); i++) {
/* 155 */       if (att.getType().trim().toUpperCase().equals(((Domaine)list.get(i)).getNom().trim().toUpperCase()))
/* 156 */         return (Domaine)list.get(i);
/*     */     }
/* 158 */     return null;
/*     */   }
/*     */   
/*     */   private static String createDomaine(Attribut att, Domaine d) {
/* 162 */     String s = "";
/* 163 */     int tail = 0;
/* 164 */     for (int i = 0; i < d.getListeValeurs().size(); i++) {
/* 165 */       if (s.trim().length() == 0) {
/* 166 */         s = "'" + (String)d.getListeValeurs().get(i) + "'";
/* 167 */         tail = ((String)d.getListeValeurs().get(i)).length();
/*     */       }
/*     */       else {
/* 170 */         s = s + ",'" + (String)d.getListeValeurs().get(i) + "'";
/* 171 */         if (tail < ((String)d.getListeValeurs().get(i)).length()) {
/* 172 */           tail = ((String)d.getListeValeurs().get(i)).length();
/*     */         }
/*     */       }
/*     */     }
/* 176 */     String ss = "VARCHAR (" + tail + ")";
/* 177 */     if (checkE.length() == 0) checkE = "CONSTRAINT CHK_TYPE_" + SQLOutil.remplaceChar(att.getNom()) + " CHECK (" + SQLOutil.remplaceChar(att.getNom()) + " IN (" + s + "))"; else
/* 178 */       checkE = checkE + ",\n\tCONSTRAINT CHK_TYPE_" + SQLOutil.remplaceChar(att.getNom()) + " CHECK (" + SQLOutil.remplaceChar(att.getNom()) + " IN (" + s + "))";
/* 179 */     return ss;
/*     */   }
/*     */   
/*     */   private static String ajusterNom(String nom, int tailMax) {
/* 183 */     nom = SQLOutil.remplaceChar(nom);
/* 184 */     for (int i = nom.length(); i < tailMax; i++) {
/* 185 */       nom = nom + " ";
/*     */     }
/* 187 */     return nom;
/*     */   }
/*     */   
/*     */   private static int longueurMaxAttribut(ArrayList<Attribut> listeAttributs) {
/* 191 */     int max = 0;
/*     */     
/*     */ 
/* 194 */     for (int i = 0; i < listeAttributs.size(); i++) {
/* 195 */       Attribut2 att = (Attribut2)listeAttributs.get(i);
/* 196 */       String nom; if (Setting.SQLUtiliserCode) {
/* 197 */         nom = att.getCode();
/*     */       } else {
/* 199 */         nom = att.getNom();
/*     */       }
/* 201 */       if (nom.length() > max) {
/* 202 */         max = nom.length();
/*     */       }
/*     */     }
/* 205 */     return max + 2;
/*     */   }
/*     */   
/*     */   private static String SQLAttribut(Attribut att, MLDEntite2 ent, IhmPageMCD pageMcd, int lg) {
/* 209 */     String s = "";
/*     */     
/*     */ 
/* 212 */     if (Setting.SQLUtiliserCode) {
/* 213 */       String nomTable = ent.getCode();
/* 214 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 215 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/* 217 */       nomTable = nomTable.toUpperCase();
/*     */     } else {
/* 219 */       String nomTable = ent.getNom();
/* 220 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 221 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/*     */     }
/*     */     
/*     */     String nomAtt;
/* 227 */     if (Setting.SQLUtiliserCode) {
/* 228 */       nomAtt = ((Attribut2)att).getCode();
/*     */     } else {
/* 230 */       nomAtt = att.getNom();
/*     */     }
/*     */     
/*     */ 
/* 234 */     if (isDomaine(att, pageMcd)) {
/* 235 */       s = createDomaine(att, retourneDomaine(att, pageMcd));
/*     */     } else {
/* 237 */       s = remplacerType(att);
/*     */     }
/*     */     
/*     */ 
/* 241 */     if (att.getKey().equals(Parametres.Cle)) {
/* 242 */       if (prkey.trim().length() == 0) prkey = SQLOutil.remplaceChar(nomAtt); else {
/* 243 */         prkey = prkey + "," + SQLOutil.remplaceChar(nomAtt);
/*     */       }
/*     */     }
/* 246 */     if (att.getKey().equals(Parametres.Unique)) {
/* 247 */       if (uniq.trim().length() == 0) uniq = SQLOutil.remplaceChar(nomAtt); else {
/* 248 */         uniq = uniq + "," + SQLOutil.remplaceChar(nomAtt);
/*     */       }
/*     */     }
/* 251 */     if (att.getKey().equals(Parametres.Index)) {
/* 252 */       if (indexEnt.trim().length() == 0) indexEnt = SQLOutil.remplaceChar(nomAtt); else {
/* 253 */         indexEnt = indexEnt + "," + SQLOutil.remplaceChar(nomAtt);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 262 */     s = ajusterNom(nomAtt, lg) + s;
/* 263 */     return s;
/*     */   }
/*     */   
/*     */   private static String SQLEntite(MLDEntite2 ent, IhmPageMCD pageMcd, IhmPageMLD pageMld) {
/* 267 */     String s = "";
/*     */     
/*     */     ArrayList<Attribut> listeAttribut;
/*     */     
/* 272 */     if (ent.isComposer()) {
/* 273 */       listeAttribut = SQLOutil.decomposerLesAttributsMLDEntite(ent);
/*     */     } else
/* 275 */       listeAttribut = ent.getListeAttributs();
/*     */     String nomTable;
/* 277 */     if (Setting.SQLUtiliserCode) {
/* 278 */        nomTable = ent.getCode();
/* 279 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 280 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/* 282 */       nomTable = nomTable.toUpperCase();
/*     */     } else {
/* 284 */       nomTable = ent.getNom();
/* 285 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 286 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/*     */     }
/*     */     
/* 290 */     String idx = "";
/* 291 */     if (Setting.SQLPrefixerLeNomContrainte2) idx = "Idx_" + nomTable; else {
/* 292 */       idx = nomTable + "_Idx";
/*     */     }
/* 294 */     String e = "CREATE TABLE " + SQLOutil.remplaceChar(nomTable) + "(\n";
/*     */     
/* 296 */     checkE = "";
/* 297 */     prkey = "";
/* 298 */     uniq = "";
/* 299 */     indexEnt = "";
/* 300 */     int lg = longueurMaxAttribut(listeAttribut);
/* 301 */     for (int i = 0; i < listeAttribut.size(); i++)
/* 302 */       if (s.trim().length() == 0) { s = "\t" + SQLAttribut((Attribut)listeAttribut.get(i), ent, pageMcd, lg);
/*     */       } else
/* 304 */         s = s + ",\n\t" + SQLAttribut((Attribut)listeAttribut.get(i), ent, pageMcd, lg);
/*     */     String nmAK;
/*     */     String nmPK;
/* 308 */     if (Setting.SQLPrefixerLeNomContrainte2) {
/* 309 */       nmPK = "PK_" + SQLOutil.remplaceChar(nomTable);
/* 310 */       nmAK = "PK_" + SQLOutil.remplaceChar(nomTable);
/*     */     } else {
/* 312 */       nmPK = SQLOutil.remplaceChar(nomTable) + "_PK";
/* 313 */       nmAK = SQLOutil.remplaceChar(nomTable) + "_AK";
/*     */     }
/* 315 */     if (prkey.trim().length() != 0) s = s + "\n\t,CONSTRAINT " + nmPK + " PRIMARY KEY (" + prkey + ")";
/* 316 */     if (checkE.trim().length() != 0) s = s + "\n\t," + checkE;
/* 317 */     if (uniq.trim().length() != 0) s = s + "\n\t,CONSTRAINT " + nmAK + " UNIQUE (" + uniq + ")";
/* 318 */     if (indexEnt.trim().length() != 0) {
/* 319 */       index = index + "CREATE INDEX " + idx + " ON " + SQLOutil.remplaceChar(nomTable) + " (" + indexEnt + ");\n";
/*     */     }
/* 321 */     return e + s + "\n);";
/*     */   }
/*     */   
/*     */   private static String SQLListeEntite(IhmPageMCD pagemcd, IhmPageMLD pagemld) {
/* 325 */     String s = "";
/* 326 */     index = "";
/* 327 */     for (int i = 0; i < pagemld.getListeMLDEntite().size(); i++) {
/* 328 */       s = s + "\n/***************************************************************\n";
/* 329 */       s = s + "   Table: " + ((MLDEntite2)pagemld.getListeMLDEntite().get(i)).getNom();
/* 330 */       s = s + "\n ***************************************************************/\n";
/*     */       
/* 332 */       s = s + SQLEntite((MLDEntite2)pagemld.getListeMLDEntite().get(i), pagemcd, pagemld) + "\n";
/*     */     }
/* 334 */     s = s + "\n\n" + index + "\n\n";
/* 335 */     return s;
/*     */   }
/*     */   
/*     */   public static String getScript(IhmPageMCD pagemcd, IhmPageMLD pagemld)
/*     */   {
/* 340 */     String s = "/* ---------------------------------------------------------------\n";
/* 341 */     s = s + " --        Script HSQLDB.  \n";
/* 342 */     s = s + " ---------------------------------------------------------------*/\n\n";
/*     */     
/* 344 */     s = s + SQLListeEntite(pagemcd, pagemld);
/* 345 */     s = s + getAllReference(pagemld);
/* 346 */     if (!Principale.isActiverJMerise()) {
/* 347 */       s = SQLOutil.getCentLignes(s);
/*     */     }
/* 349 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */   private static String getSQLNomTable(MLDEntite2 ent)
/*     */   {
/* 355 */     String st = "";String s = "";
/* 356 */     if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 357 */       s = SQLOutil.remplaceChar(Setting.developpeur);
/* 358 */       s = s.toUpperCase();
/*     */     }
/* 360 */     if (Setting.SQLUtiliserCode) {
/* 361 */       st = SQLOutil.remplaceChar(ent.getCode());
/*     */     } else {
/* 363 */       st = SQLOutil.remplaceChar(ent.getNom());
/*     */     }
/* 365 */     if (s.length() == 0) s = st; else
/* 366 */       s = s + "_" + st;
/* 367 */     return s;
/*     */   }
/*     */   
/*     */   private static String getNomAttribut(Attribut2 att) {
/* 371 */     if (Setting.SQLUtiliserCode) return SQLOutil.remplaceChar(att.getCode());
/* 372 */     return SQLOutil.remplaceChar(att.getNom());
/*     */   }
/*     */   
/*     */   private static String getUneContrainteFK(TableReference tab, String num) {
/* 376 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 377 */     String att = "";String attRef = "";
/*     */     
/* 379 */     for (int i = 0; i < liste.size(); i++) {
/* 380 */       if (att.length() == 0) {
/* 381 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 382 */         attRef = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */       else {
/* 385 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 386 */         attRef = attRef + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */     }
/* 389 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 390 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 391 */     String nomCnt = "";
/* 392 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "FK_" + nomTab + "_" + nomTabRef + num; else {
/* 393 */       nomCnt = nomTab + "_" + nomTabRef + num + "_FK";
/*     */     }
/* 395 */     String s = "\nALTER TABLE " + nomTab + "\n\tADD CONSTRAINT " + nomCnt + "\n\tFOREIGN KEY (" + att + ")" + "\n\tREFERENCES " + nomTabRef + "(" + attRef + ");\n";
/*     */     
/* 397 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContrainteFK(MLDEntite2 ent) {
/* 401 */     String s = "";
/* 402 */     for (int i = 0; i < ent.getListeCNTForeingKey().size(); i++) {
/* 403 */       s = s + getUneContrainteFK((TableReference)ent.getListeCNTForeingKey().get(i), new StringBuilder().append(i).append("").toString());
/*     */     }
/* 405 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteAK(TableReference tab, String num) {
/* 409 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 410 */     String att = "";
/*     */     
/* 412 */     for (int i = 0; i < liste.size(); i++) {
/* 413 */       if (att.length() == 0) {
/* 414 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */       else
/*     */       {
/* 418 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */     }
/* 421 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 422 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 423 */     String nomCnt = "";
/* 424 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "AK_" + nomTab + "_" + nomTabRef + num; else {
/* 425 */       nomCnt = nomTab + "_" + nomTabRef + num + "_AK";
/*     */     }
/* 427 */     String s = "\nALTER TABLE " + nomTab + "\n\tADD CONSTRAINT " + nomCnt + " \n\tUNIQUE (" + att + ");\n";
/*     */     
/* 429 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContrainteAK(MLDEntite2 ent) {
/* 433 */     String s = "";
/* 434 */     for (int i = 0; i < ent.getListeCNTALTERNATIVEKEY().size(); i++) {
/* 435 */       s = s + getUneContrainteAK((TableReference)ent.getListeCNTALTERNATIVEKEY().get(i), new StringBuilder().append(i).append("").toString());
/*     */     }
/* 437 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContraintesEntite(MLDEntite2 ent) {
/* 441 */     String s = "";
/* 442 */     s = getAllContrainteFK(ent);
/* 443 */     s = s + getAllContrainteAK(ent);
/* 444 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllReference(IhmPageMLD page) {
/* 448 */     String s = "";
/*     */     
/* 450 */     for (int i = 0; i < page.getListeMLDEntite().size(); i++) {
/* 451 */       s = s + getAllContraintesEntite((MLDEntite2)page.getListeMLDEntite().get(i));
/*     */     }
/* 453 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */   public static ArrayList<String> creerListeTable(String script)
/*     */   {
/* 459 */     ArrayList<String> listeTable = new ArrayList();
/* 460 */     String trig = "";
/* 461 */     String f = "";String d = " ";String table = "";
/* 462 */     int indexx = -1;
/* 463 */     String scriptCREATE = script.substring(0, script.toUpperCase().indexOf("ALTER"));
/* 464 */     String scriptALTER = script.substring(script.toUpperCase().indexOf("ALTER"), script.length());
/* 465 */     indexx = scriptCREATE.toUpperCase().indexOf("CREATE");
/* 466 */     scriptCREATE = scriptCREATE.substring(indexx);
/* 467 */     if (indexx > -1) {
/* 468 */       while (indexx > -1)
/*     */       {
/* 470 */         d = scriptCREATE.substring(0, scriptCREATE.toUpperCase().indexOf(";") + 1);
/* 471 */         scriptCREATE = scriptCREATE.substring(scriptCREATE.indexOf(";") + 1);
/* 472 */         listeTable.add(d);
/* 473 */         indexx = scriptCREATE.toUpperCase().indexOf("CREATE");
/*     */       }
/*     */     }
/*     */     
/* 477 */     indexx = scriptALTER.toUpperCase().indexOf("ALTER");
/* 478 */     scriptALTER = scriptALTER.substring(indexx);
/* 479 */     if (indexx > -1) {
/* 480 */       while (indexx > -1) {
/* 481 */         d = scriptALTER.substring(0, scriptALTER.toUpperCase().indexOf(";") + 1);
/* 482 */         scriptALTER = scriptALTER.substring(scriptALTER.indexOf(";") + 1);
/* 483 */         listeTable.add(d);
/* 484 */         indexx = scriptALTER.toUpperCase().indexOf("ALTER");
/*     */       }
/*     */     }
/*     */     
/* 488 */     return listeTable;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Output\SQLHsqldb.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */