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
/*     */ public class SQLFirebird
/*     */ {
/*  25 */   private static String checkE = "";
/*  26 */   private static String index = "";
/*  27 */   private static String prkey = "";
/*  28 */   private static String uniq = "";
/*  29 */   private static String indexEnt = "";
/*  30 */   private static String generateur = "";
/*  31 */   private static String triggers = "";
/*     */   
/*     */   private static String createGen(String ent, String att)
/*     */   {
/*  35 */     return "CREATE GENERATOR gen_" + ent + "_" + att + ";\n" + "SET GENERATOR gen_" + ent + "_" + att + " TO 0;\n\n";
/*     */   }
/*     */   
/*     */   private static String createTriggerGen(String ent, String att)
/*     */   {
/*  40 */     String s = "CREATE TRIGGER " + ent + "_" + att + " FOR " + ent + "\n";
/*  41 */     s = s + "\tACTIVE BEFORE INSERT POSITION 0 \n";
/*  42 */     s = s + "\tAS \n\t BEGIN\n";
/*  43 */     s = s + "\t\t if (NEW." + att + " is NULL ) then NEW." + att + "= GEN_ID(GEN_" + ent + "_" + att + ",1);\n";
/*  44 */     s = s + "\tEND;";
/*  45 */     return s;
/*     */   }
/*     */   
/*     */   private static String createTrriger(String ent, String att)
/*     */   {
/*  50 */     String s = "";
/*  51 */     s = s + createTriggerGen(ent, att) + "\n";
/*     */     
/*  53 */     return s;
/*     */   }
/*     */   
/*     */   private static String remplacerType(Attribut att, MLDEntite2 ent) {
/*  57 */     String t = "";
/*  58 */     String type = att.getType();
/*  59 */     String nul = att.isNulle() ? " " : " NOT NULL ";
/*  60 */     if (att.getKey().equals(Parametres.Cle)) { nul = " NOT NULL ";
/*     */     }
/*  62 */     else if (att.getKey().equals(Parametres.Index)) { nul = " NOT NULL ";
/*     */     }
/*  64 */     else if (att.getKey().equals(Parametres.Unique)) { nul = " NOT NULL ";
/*     */     }
/*     */     
/*  67 */     if (type.trim().toUpperCase().equals("AUTO_INCREMENT")) {
/*  68 */       generateur += createGen(getSQLNomTable(ent), getNomAttribut((Attribut2)att));
/*  69 */       triggers += createTrriger(getSQLNomTable(ent), getNomAttribut((Attribut2)att));
/*  70 */       t = "INTEGER NOT NULL";
/*     */     }
/*  72 */     if (type.trim().toUpperCase().equals("VARCHAR")) {
/*  73 */       t = "VARCHAR (" + att.getLongueur() + ")" + nul;
/*     */     }
/*  75 */     if (type.trim().toUpperCase().equals("INTEGER")) {
/*  76 */       t = "INTEGER" + nul;
/*     */     }
/*     */     
/*  79 */     if (type.trim().toUpperCase().equals("FLOAT")) {
/*  80 */       t = "FLOAT " + nul;
/*     */     }
/*  82 */     if (type.trim().toUpperCase().equals("BLOB")) {
/*  83 */       t = "BLOB " + nul;
/*     */     }
/*  85 */     if (type.trim().toUpperCase().equals("DECIMAL")) {
/*  86 */       t = "DECIMAL(" + att.getLongueur() + "," + att.getLongDecimale() + ") " + nul;
/*     */     }
/*     */     
/*  89 */     if (type.trim().toUpperCase().equals("MONEY")) {
/*  90 */       t = "DECIMAL (15,3)" + nul;
/*     */     }
/*     */     
/*  93 */     if (type.trim().toUpperCase().equals("DOUBLE PRECISION")) {
/*  94 */       t = "DOUBLE PRECISION " + nul;
/*     */     }
/*  96 */     if (type.trim().toUpperCase().equals("NUMERIC")) {
/*  97 */       t = "NUMERIC (" + att.getLongueur() + "," + att.getLongDecimale() + ") " + nul;
/*     */     }
/*  99 */     if (type.trim().toUpperCase().equals("SMALLINT")) {
/* 100 */       t = "SMALLINT " + nul;
/*     */     }
/* 102 */     if (type.trim().toUpperCase().equals("CHAR")) {
/* 103 */       t = "CHAR (" + att.getLongueur() + ") " + nul;
/*     */     }
/* 105 */     if (type.trim().toUpperCase().equals("DATE")) {
/* 106 */       t = "DATE " + nul;
/*     */     }
/*     */     
/* 109 */     if (type.trim().toUpperCase().equals("BOOL")) {
/* 110 */       t = "INTEGER (1) " + nul;
/*     */     }
/* 112 */     if (type.trim().toUpperCase().equals("INT")) {
/* 113 */       t = "INTEGER " + nul;
/*     */     }
/* 115 */     if (type.trim().toUpperCase().equals("DATETIME")) {
/* 116 */       t = "DATE " + nul;
/*     */     }
/* 118 */     if (type.trim().toUpperCase().equals("DOUBLE")) {
/* 119 */       t = "FLOAT " + nul;
/*     */     }
/*     */     
/* 122 */     if (type.trim().toUpperCase().equals("LONGBLOB")) {
/* 123 */       t = "BLOB " + nul;
/*     */     }
/* 125 */     if (type.trim().toUpperCase().equals("LONGTEXT")) {
/* 126 */       t = "VARCHAR (2000) " + nul;
/*     */     }
/* 128 */     if (type.trim().toUpperCase().equals("MEDIUMBLOB")) {
/* 129 */       t = "BLOB " + nul;
/*     */     }
/* 131 */     if (type.trim().toUpperCase().equals("MEDIUMINT")) {
/* 132 */       t = "INTEGER " + nul;
/*     */     }
/* 134 */     if (type.trim().toUpperCase().equals("MEDIUMTEXT")) {
/* 135 */       t = "VARCHAR (2000) " + nul;
/*     */     }
/* 137 */     if (type.trim().toUpperCase().equals("REAL")) {
/* 138 */       t = "FLOAT " + nul;
/*     */     }
/*     */     
/* 141 */     if (type.trim().toUpperCase().equals("TEXT")) {
/* 142 */       t = "VARCHAR (2000) " + nul;
/*     */     }
/* 144 */     if (type.trim().toUpperCase().equals("TIME")) {
/* 145 */       t = "VARCHAR (9) " + nul;
/*     */     }
/* 147 */     if (type.trim().toUpperCase().equals("TIMESTAMP")) {
/* 148 */       t = "VARCHAR (9) " + nul;
/*     */     }
/* 150 */     if (type.trim().toUpperCase().equals("TINYBLOB")) {
/* 151 */       t = "BLOB " + nul;
/*     */     }
/* 153 */     if (type.trim().toUpperCase().equals("TINYINT")) {
/* 154 */       t = "INTEGER " + nul;
/*     */     }
/* 156 */     if (type.trim().toUpperCase().equals("TINYTEXT")) {
/* 157 */       t = "VARCHAR (2000) " + nul;
/*     */     }
/* 159 */     if (type.trim().toUpperCase().equals("YEAR")) {
/* 160 */       t = "INTEGER " + nul;
/*     */     }
/*     */     
/* 163 */     return t;
/*     */   }
/*     */   
/*     */   private static boolean isDomaine(Attribut att, IhmPageMCD page) {
/* 167 */     ArrayList<Domaine> list = page.getListeDomaine();
/* 168 */     for (int i = 0; i < list.size(); i++) {
/* 169 */       if (att.getType().trim().toUpperCase().equals(((Domaine)list.get(i)).getNom().trim().toUpperCase()))
/* 170 */         return true;
/*     */     }
/* 172 */     return false;
/*     */   }
/*     */   
/*     */   private static String createDomaine(Domaine d) {
/* 176 */     String s = "";
/* 177 */     int tail = 0;
/* 178 */     for (int i = 0; i < d.getListeValeurs().size(); i++) {
/* 179 */       if (s.trim().length() == 0) {
/* 180 */         s = "'" + (String)d.getListeValeurs().get(i) + "'";
/* 181 */         tail = ((String)d.getListeValeurs().get(i)).length();
/*     */       }
/*     */       else {
/* 184 */         s = s + ",'" + (String)d.getListeValeurs().get(i) + "'";
/* 185 */         if (tail < ((String)d.getListeValeurs().get(i)).length()) {
/* 186 */           tail = ((String)d.getListeValeurs().get(i)).length();
/*     */         }
/*     */       }
/*     */     }
/* 190 */     s = "CREATE DOMAIN " + d.getNom() + " AS VARCHAR(" + tail + ") CHECK (value IN (" + s + ") OR value IS NULL);";
/* 191 */     return s;
/*     */   }
/*     */   
/*     */   private static String createListeDomaine(ArrayList<Domaine> l) {
/* 195 */     String s = "";
/* 196 */     for (int i = 0; i < l.size(); i++) {
/* 197 */       s = s + createDomaine((Domaine)l.get(i)) + "\n";
/*     */     }
/* 199 */     return s;
/*     */   }
/*     */   
/*     */   private static String ajusterNom(String nom, int tailMax) {
/* 203 */     nom = SQLOutil.remplaceChar(nom);
/* 204 */     for (int i = nom.length(); i < tailMax; i++) {
/* 205 */       nom = nom + " ";
/*     */     }
/* 207 */     return nom;
/*     */   }
/*     */   
/*     */   private static int longueurMaxAttribut(ArrayList<Attribut> listeAttributs) {
/* 211 */     int max = 0;
/*     */     
/*     */ 
/* 214 */     for (int i = 0; i < listeAttributs.size(); i++) {
/* 215 */       Attribut2 att = (Attribut2)listeAttributs.get(i);
/* 216 */       String nom; if (Setting.SQLUtiliserCode) {
/* 217 */         nom = att.getCode();
/*     */       } else {
/* 219 */         nom = att.getNom();
/*     */       }
/* 221 */       if (nom.length() > max) {
/* 222 */         max = nom.length();
/*     */       }
/*     */     }
/* 225 */     return max + 2;
/*     */   }
/*     */   
/*     */   private static String SQLAttribut(Attribut att, MLDEntite2 ent, IhmPageMCD pageMcd, int lg) {
/* 229 */     String s = "";
/*     */     
/* 231 */     if (Setting.SQLUtiliserCode) {
/* 232 */       String nomTable = ent.getCode();
/* 233 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 234 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/* 236 */       nomTable = nomTable.toUpperCase();
/*     */     } else {
/* 238 */       String nomTable = ent.getNom();
/* 239 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 240 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/*     */     }
/*     */     
/*     */     String nomAtt;
/* 246 */     if (Setting.SQLUtiliserCode) {
/* 247 */       nomAtt = ((Attribut2)att).getCode();
/*     */     } else {
/* 249 */       nomAtt = att.getNom();
/*     */     }
/*     */     
/* 252 */     if (isDomaine(att, pageMcd)) {
/* 253 */       s = att.getType();
/*     */     } else {
/* 255 */       s = remplacerType(att, ent);
/*     */     }
/*     */     
/*     */ 
/* 259 */     if (att.getKey().equals(Parametres.Cle)) {
/* 260 */       if (prkey.trim().length() == 0) prkey = SQLOutil.remplaceChar(nomAtt); else {
/* 261 */         prkey = prkey + "," + SQLOutil.remplaceChar(nomAtt);
/*     */       }
/*     */     }
/* 264 */     if (att.getKey().equals(Parametres.Unique)) {
/* 265 */       if (uniq.trim().length() == 0) uniq = SQLOutil.remplaceChar(nomAtt); else {
/* 266 */         uniq = uniq + "," + SQLOutil.remplaceChar(nomAtt);
/*     */       }
/*     */     }
/* 269 */     if (att.getKey().equals(Parametres.Index)) {
/* 270 */       if (indexEnt.trim().length() == 0) indexEnt = SQLOutil.remplaceChar(nomAtt); else {
/* 271 */         indexEnt = indexEnt + "," + SQLOutil.remplaceChar(nomAtt);
/*     */       }
/*     */     }
/*     */     
/* 275 */     s = ajusterNom(nomAtt, lg) + s;
/* 276 */     return s;
/*     */   }
/*     */   
/*     */   private static String SQLEntite(MLDEntite2 ent, IhmPageMCD pageMcd, IhmPageMLD pageMld) {
/* 280 */     String s = "";
/*     */     
/*     */     ArrayList<Attribut> listeAttribut;
/* 284 */     if (ent.isComposer()) {
/* 285 */       listeAttribut = SQLOutil.decomposerLesAttributsMLDEntite(ent);
/*     */     } else {
/* 287 */       listeAttribut = ent.getListeAttributs();
/*     */     }
/*     */     
/*     */     String nomTable;
/* 291 */     if (Setting.SQLUtiliserCode) {
/* 292 */       nomTable = ent.getCode();
/* 293 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 294 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/* 296 */       nomTable = nomTable.toUpperCase();
/*     */     } else {
/* 298 */       nomTable = ent.getNom();
/* 299 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 300 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/*     */     }
/*     */     
/* 304 */     String idx = "";
/* 305 */     if (Setting.SQLPrefixerLeNomContrainte2) idx = "Idx_" + nomTable; else {
/* 306 */       idx = nomTable + "_Idx";
/*     */     }
/* 308 */     String e = "CREATE TABLE " + SQLOutil.remplaceChar(nomTable) + "(\n";
/* 309 */     checkE = "";
/* 310 */     prkey = "";
/* 311 */     uniq = "";
/* 312 */     indexEnt = "";
/* 313 */     int lg = longueurMaxAttribut(listeAttribut);
/* 314 */     for (int i = 0; i < listeAttribut.size(); i++) {
/* 315 */       if (s.trim().length() == 0) { s = "\t" + SQLAttribut((Attribut)listeAttribut.get(i), ent, pageMcd, lg);
/*     */       } else {
/* 317 */         s = s + " ,\n\t" + SQLAttribut((Attribut)listeAttribut.get(i), ent, pageMcd, lg);
/*     */       }
/*     */     }
/* 320 */     if (prkey.trim().length() != 0) s = s + " ,\n\tPRIMARY KEY (" + prkey + ")";
/* 321 */     if (checkE.trim().length() != 0) s = s + " ,\n\t" + checkE;
/* 322 */     if (uniq.trim().length() != 0) { s = s + " ,\n\tUNIQUE (" + uniq + ")";
/*     */     }
/* 324 */     if (indexEnt.trim().length() != 0) {
/* 325 */       index = index + "CREATE INDEX " + idx + " ON " + SQLOutil.remplaceChar(nomTable) + " (" + indexEnt + ");\n";
/*     */     }
/*     */     
/* 328 */     return e + s + "\n);";
/*     */   }
/*     */   
/*     */   private static String SQLListeEntite(IhmPageMCD pagemcd, IhmPageMLD pagemld) {
/* 332 */     String s = "";
/* 333 */     index = "";
/*     */     
/* 335 */     for (int i = 0; i < pagemld.getListeMLDEntite().size(); i++) {
/* 336 */       s = s + "\n/***************************************************************\n";
/* 337 */       s = s + "   Table: " + ((MLDEntite2)pagemld.getListeMLDEntite().get(i)).getNom();
/* 338 */       s = s + "\n ***************************************************************/\n";
/* 339 */       s = s + SQLEntite((MLDEntite2)pagemld.getListeMLDEntite().get(i), pagemcd, pagemld) + "\n";
/*     */     }
/* 341 */     s = s + "\n" + index;
/* 342 */     return s;
/*     */   }
/*     */   
/*     */   public static String getScript(IhmPageMCD pagemcd, IhmPageMLD pagemld) {
/* 346 */     generateur = "";
/* 347 */     triggers = "";
/*     */     
/* 349 */     String s = "/***************************************************************\n";
/* 350 */     s = s + " **        Script Firebird.  \n";
/* 351 */     s = s + " ***************************************************************/\n\n";
/* 352 */     s = s + createListeDomaine(pagemcd.getListeDomaine());
/* 353 */     s = s + SQLListeEntite(pagemcd, pagemld);
/*     */     
/* 355 */     s = s + "\n" + generateur + "\n\n";
/* 356 */     if (triggers.length() != 0) {
/* 357 */       s = s + triggers + "\n";
/*     */     }
/* 359 */     s = s + getAllReference(pagemld);
/* 360 */     if (!Principale.isActiverJMerise()) {
/* 361 */       s = SQLOutil.getCentLignes(s);
/*     */     }
/* 363 */     return s;
/*     */   }
/*     */   
/*     */   private static String getSQLNomTable(MLDEntite2 ent)
/*     */   {
/* 368 */     String st = "";String s = "";
/* 369 */     if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 370 */       s = SQLOutil.remplaceChar(Setting.developpeur);
/* 371 */       s = s.toUpperCase();
/*     */     }
/* 373 */     if (Setting.SQLUtiliserCode) {
/* 374 */       st = SQLOutil.remplaceChar(ent.getCode());
/*     */     } else {
/* 376 */       st = SQLOutil.remplaceChar(ent.getNom());
/*     */     }
/* 378 */     if (s.length() == 0) s = st; else
/* 379 */       s = s + "_" + st;
/* 380 */     return s;
/*     */   }
/*     */   
/*     */   private static String getNomAttribut(Attribut2 att) {
/* 384 */     if (Setting.SQLUtiliserCode) return SQLOutil.remplaceChar(att.getCode());
/* 385 */     return SQLOutil.remplaceChar(att.getNom());
/*     */   }
/*     */   
/*     */   private static String getUneContrainteFK(TableReference tab, String num) {
/* 389 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 390 */     String att = "";String attRef = "";
/*     */     
/* 392 */     for (int i = 0; i < liste.size(); i++) {
/* 393 */       if (att.length() == 0) {
/* 394 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 395 */         attRef = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */       else {
/* 398 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 399 */         attRef = attRef + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */     }
/* 402 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 403 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 404 */     String nomCnt = "";
/* 405 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "FK_" + nomTab + "_" + nomTabRef + num; else {
/* 406 */       nomCnt = nomTab + "_" + nomTabRef + num + "_FK";
/*     */     }
/* 408 */     String s = "\nALTER TABLE " + nomTab + "\n\tADD CONSTRAINT " + nomCnt + "\n\tFOREIGN KEY (" + att + ")" + "\n\tREFERENCES " + nomTabRef + "(" + attRef + ");\n";
/*     */     
/* 410 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContrainteFK(MLDEntite2 ent) {
/* 414 */     String s = "";
/* 415 */     for (int i = 0; i < ent.getListeCNTForeingKey().size(); i++) {
/* 416 */       s = s + getUneContrainteFK((TableReference)ent.getListeCNTForeingKey().get(i), new StringBuilder().append(i).append("").toString());
/*     */     }
/* 418 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteAK(TableReference tab, String num) {
/* 422 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 423 */     String att = "";
/*     */     
/* 425 */     for (int i = 0; i < liste.size(); i++) {
/* 426 */       if (att.length() == 0) {
/* 427 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */       else
/*     */       {
/* 431 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */     }
/* 434 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 435 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 436 */     String nomCnt = "";
/* 437 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "AK_" + nomTab + "_" + nomTabRef + num; else {
/* 438 */       nomCnt = nomTab + "_" + nomTabRef + num + "_AK";
/*     */     }
/* 440 */     String s = "\nALTER TABLE " + nomTab + "\n\tADD CONSTRAINT " + nomCnt + " \n\tUNIQUE (" + att + ");\n";
/*     */     
/* 442 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContrainteAK(MLDEntite2 ent) {
/* 446 */     String s = "";
/* 447 */     for (int i = 0; i < ent.getListeCNTALTERNATIVEKEY().size(); i++) {
/* 448 */       s = s + getUneContrainteAK((TableReference)ent.getListeCNTALTERNATIVEKEY().get(i), new StringBuilder().append(i).append("").toString());
/*     */     }
/* 450 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContraintesEntite(MLDEntite2 ent) {
/* 454 */     String s = "";
/* 455 */     s = getAllContrainteFK(ent);
/* 456 */     s = s + getAllContrainteAK(ent);
/* 457 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllReference(IhmPageMLD page) {
/* 461 */     String s = "";
/*     */     
/* 463 */     for (int i = 0; i < page.getListeMLDEntite().size(); i++) {
/* 464 */       s = s + getAllContraintesEntite((MLDEntite2)page.getListeMLDEntite().get(i));
/*     */     }
/* 466 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */   public static ArrayList<String> creerListeTable(String script)
/*     */   {
/* 472 */     ArrayList<String> listeTable = new ArrayList();
/* 473 */     String trig = "";
/* 474 */     String f = "";String d = " ";String table = "";
/* 475 */     int indexx = -1;
/* 476 */     String scriptCREATE = script.substring(0, script.toUpperCase().indexOf("ALTER"));
/* 477 */     String scriptALTER = script.substring(script.toUpperCase().indexOf("ALTER"), script.length());
/* 478 */     indexx = scriptCREATE.toUpperCase().indexOf("CREATE");
/* 479 */     scriptCREATE = scriptCREATE.substring(indexx);
/* 480 */     if (indexx > -1) {
/* 481 */       while (indexx > -1)
/*     */       {
/* 483 */         d = scriptCREATE.substring(0, scriptCREATE.toUpperCase().indexOf(";") + 1);
/* 484 */         scriptCREATE = scriptCREATE.substring(scriptCREATE.indexOf(";") + 1);
/* 485 */         listeTable.add(d);
/* 486 */         indexx = scriptCREATE.toUpperCase().indexOf("CREATE");
/*     */       }
/*     */     }
/*     */     
/* 490 */     indexx = scriptALTER.toUpperCase().indexOf("ALTER");
/* 491 */     scriptALTER = scriptALTER.substring(indexx);
/* 492 */     if (indexx > -1) {
/* 493 */       while (indexx > -1) {
/* 494 */         d = scriptALTER.substring(0, scriptALTER.toUpperCase().indexOf(";") + 1);
/* 495 */         scriptALTER = scriptALTER.substring(scriptALTER.indexOf(";") + 1);
/* 496 */         listeTable.add(d);
/* 497 */         indexx = scriptALTER.toUpperCase().indexOf("ALTER");
/*     */       }
/*     */     }
/*     */     
/* 501 */     return listeTable;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Output\SQLFirebird.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */