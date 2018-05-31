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
/*     */ public class SQLite
/*     */ {
/*  25 */   private static String checkE = "";
/*  26 */   private static String index = "";
/*  27 */   private static String indexEnt = "";
/*  28 */   private static String uniq = "";
/*     */   private static boolean isAutoinc;
/*  30 */   private static String prkey = "";
/*     */   
/*     */ 
/*     */   private static String remplacerType(Attribut att)
/*     */   {
/*  35 */     String t = "";
/*  36 */     String type = att.getType();
/*     */     
/*  38 */     String nul = att.isNulle() ? "" : " NOT NULL";
/*  39 */     if (att.getKey().equals(Parametres.Cle)) { nul = " NOT NULL";
/*     */     }
/*  41 */     else if (att.getKey().equals(Parametres.Index)) { nul = " NOT NULL";
/*     */     }
/*  43 */     else if (att.getKey().equals(Parametres.Unique)) { nul = " NOT NULL";
/*     */     }
/*     */     
/*  46 */     if ((type.trim().toUpperCase().equals("INT")) || (type.trim().toUpperCase().equals("TINYINT")) || (type.trim().toUpperCase().equals("INTEGER")) || (type.trim().toUpperCase().equals("SMALLINT")) || (type.trim().toUpperCase().equals("MEDIUMINT")) || (type.trim().toUpperCase().equals("BIGINT")) || (type.trim().toUpperCase().equals("UNSIGNED BIG INT")) || (type.trim().toUpperCase().equals("INT2")) || (type.trim().toUpperCase().equals("INT8")))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  51 */       t = "INTEGER" + nul;
/*     */     }
/*  53 */     if ((type.trim().toUpperCase().equals("VARCHAR")) || (type.trim().toUpperCase().equals("CHAR")) || (type.trim().toUpperCase().equals("LONGTEXT")) || (type.trim().toUpperCase().equals("MEDIUMTEXT")) || (type.trim().toUpperCase().equals("TINYTEXT")) || (type.trim().toUpperCase().equals("TEXT")))
/*     */     {
/*     */ 
/*     */ 
/*  57 */       t = "TEXT" + nul;
/*     */     }
/*  59 */     if ((type.trim().toUpperCase().equals("BLOB")) || (type.trim().toUpperCase().equals("TINYBLOB")) || (type.trim().toUpperCase().equals("LONGBLOB")))
/*     */     {
/*     */ 
/*  62 */       t = "NONE" + nul;
/*     */     }
/*  64 */     if ((type.trim().toUpperCase().equals("FLOAT")) || (type.trim().toUpperCase().equals("REAL")) || (type.trim().toUpperCase().equals("DOUBLE")) || (type.trim().toUpperCase().equals("DOUBLE PRECISION")) || (type.trim().toUpperCase().equals("")) || (type.trim().toUpperCase().equals("")))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  69 */       t = "REAL" + nul;
/*     */     }
/*  71 */     if ((type.trim().toUpperCase().equals("MONEY")) || (type.trim().toUpperCase().equals("NUMERIC")) || (type.trim().toUpperCase().equals("DECIMAL")) || (type.trim().toUpperCase().equals("BOOLEAN")) || (type.trim().toUpperCase().equals("DATE")) || (type.trim().toUpperCase().equals("DATETIME")) || (type.trim().toUpperCase().equals("TIMESTAMP")) || (type.trim().toUpperCase().equals("TIME")) || (type.trim().toUpperCase().equals("YEAR")))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  76 */       t = "NUMERIC" + nul;
/*     */     }
/*     */     
/*  79 */     if (type.trim().toUpperCase().equals("BOOL")) { t = "INTEGER" + nul;
/*     */     }
/*  81 */     if (type.trim().toUpperCase().equals("AUTO_INCREMENT")) {
/*  82 */       t = "INTEGER" + nul;
/*     */     }
/*  84 */     return t;
/*     */   }
/*     */   
/*     */ 
/*     */   private static String getType(Attribut att, IhmPageMCD page)
/*     */   {
/*  90 */     if (isDomaine(att, page)) return SQLGetTypeEnum(att, att.getType(), page);
/*  91 */     return remplacerType(att);
/*     */   }
/*     */   
/*     */   private static boolean isDomaine(Attribut att, IhmPageMCD page) {
/*  95 */     ArrayList<Domaine> list = page.getListeDomaine();
/*  96 */     for (int i = 0; i < list.size(); i++) {
/*  97 */       if (att.getType().trim().toUpperCase().equals(((Domaine)list.get(i)).getNom().trim().toUpperCase()))
/*  98 */         return true;
/*     */     }
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   private static String SQLGetTypeEnum(Attribut attr, String type, IhmPageMCD page) {
/* 104 */     String s = "";
/* 105 */     ArrayList<Domaine> list = page.getListeDomaine();
/* 106 */     Domaine d = null;
/* 107 */     String nul = attr.isNulle() ? " " : " NOT NULL ";
/* 108 */     for (int i = 0; i < list.size(); i++) {
/* 109 */       if (type.equals(((Domaine)list.get(i)).getNom())) {
/* 110 */         d = (Domaine)list.get(i);
/* 111 */         break;
/*     */       }
/*     */     }
/* 114 */     if (d != null) {
/* 115 */       int tail = 0;
/* 116 */       for (int i = 0; i < d.getListeValeurs().size(); i++) {
/* 117 */         if (s.trim().length() == 0) {
/* 118 */           s = "\"" + (String)d.getListeValeurs().get(i) + "\"";
/* 119 */           tail = ((String)d.getListeValeurs().get(i)).length();
/*     */         }
/*     */         else {
/* 122 */           s = s + ",\"" + (String)d.getListeValeurs().get(i) + "\"";
/* 123 */           if (tail < ((String)d.getListeValeurs().get(i)).length()) {
/* 124 */             tail = ((String)d.getListeValeurs().get(i)).length();
/*     */           }
/*     */         }
/*     */       }
/* 128 */       if (checkE.trim().length() == 0) checkE = checkE + "CHECK (" + attr.getNom() + " IN (" + s + "))"; else
/* 129 */         checkE = checkE + ",\n\tCHECK " + attr.getNom() + " IN (" + s + "))";
/* 130 */       s = "Varchar (" + tail + ")" + nul;
/* 131 */       s = "TEXT " + nul;
/*     */     }
/* 133 */     return s;
/*     */   }
/*     */   
/*     */   private static String ajusterNom(String nom, int tailMax) {
/* 137 */     nom = SQLOutil.remplaceChar(nom);
/* 138 */     for (int i = nom.length(); i < tailMax; i++) {
/* 139 */       nom = nom + " ";
/*     */     }
/* 141 */     return nom;
/*     */   }
/*     */   
/*     */   private static int longueurMaxAttribut(ArrayList<Attribut> listeAttributs) {
/* 145 */     int max = 0;
/*     */     
/*     */ 
/* 148 */     for (int i = 0; i < listeAttributs.size(); i++) {
/* 149 */       Attribut2 att = (Attribut2)listeAttributs.get(i);
/* 150 */       String nom; if (Setting.SQLUtiliserCode) {
/* 151 */         nom = att.getCode();
/*     */       } else {
/* 153 */         nom = att.getNom();
/*     */       }
/* 155 */       if (nom.length() > max) {
/* 156 */         max = nom.length();
/*     */       }
/*     */     }
/* 159 */     return max + 2;
/*     */   }
/*     */   
/*     */   private static String SQLAttribut(Attribut att, MLDEntite2 ent, String nomTab, IhmPageMCD pageMcd, int lg) {
/* 163 */     String s = "";
/* 164 */     String cle = "";
/* 165 */     String type = "";
/* 166 */     boolean nul = true;
/*     */     
/*     */     String nomAtt;
/* 170 */     if (Setting.SQLUtiliserCode) {
/* 171 */       nomAtt = ((Attribut2)att).getCode();
/*     */     } else {
/* 173 */       nomAtt = att.getNom();
/*     */     }
/*     */     
/*     */ 
/* 177 */     if (att.getKey().equals(Parametres.Cle)) {
/* 178 */       cle = " PRIMARY KEY";
/* 179 */       nul = false;
/* 180 */       if (prkey.trim().length() == 0) {
/* 181 */         if (att.getType().toUpperCase().equals("AUTO_INCREMENT")) {
/* 182 */           cle = cle + " AUTOINCREMENT";
/* 183 */           isAutoinc = true;
/*     */         }
/* 185 */         prkey = SQLOutil.remplaceChar(nomAtt);
/*     */       } else {
/* 187 */         prkey = prkey + "," + SQLOutil.remplaceChar(nomAtt);
/*     */       } }
/* 189 */     if (att.getKey().equals(Parametres.Unique)) {
/* 190 */       if (uniq.trim().length() == 0) uniq = nomAtt; else {
/* 191 */         uniq = uniq + "," + nomAtt;
/*     */       }
/*     */     }
/* 194 */     if (att.getKey().equals(Parametres.Index)) {
/* 195 */       if (indexEnt.trim().length() == 0) indexEnt = SQLOutil.remplaceChar(nomAtt); else {
/* 196 */         indexEnt = indexEnt + "," + SQLOutil.remplaceChar(nomAtt);
/*     */       }
/*     */     }
/*     */     
/* 200 */     type = getType(att, pageMcd);
/* 201 */     s = ajusterNom(nomAtt, lg) + "  " + type;
/* 202 */     if (isAutoinc) { s = s + cle;
/*     */     }
/* 204 */     return s;
/*     */   }
/*     */   
/*     */   private static String SQLEntite(MLDEntite2 ent, IhmPageMCD pageMcd, IhmPageMLD pageMld) {
/* 208 */     String s = "";
/*     */     
/*     */     ArrayList<Attribut> listeAttribut;
/*     */     
/* 213 */     if (ent.isComposer()) {
/* 214 */       listeAttribut = SQLOutil.decomposerLesAttributsMLDEntite(ent);
/*     */     } else {
/* 216 */       listeAttribut = ent.getListeAttributs();
/*     */     }
/*     */     
/*     */ 
/* 220 */     String nomTable = getSQLNomTable(ent);
/*     */     
/* 222 */     String idx = "";
/* 223 */     if (Setting.SQLPrefixerLeNomContrainte2) idx = "Idx_" + nomTable; else
/* 224 */       idx = nomTable + "_Idx";
/* 225 */     indexEnt = "";
/* 226 */     uniq = "";
/* 227 */     isAutoinc = false;
/* 229 */     String nmPK; if (Setting.SQLPrefixerLeNomContrainte2) {
/* 230 */       String nmAK = "PK_" + nomTable;
/* 231 */       nmPK = "PK_" + nomTable;
/*     */     } else {
/* 233 */       String nmAK = nomTable + "_AK";
/* 234 */       nmPK = nomTable + "_PK";
/*     */     }
/*     */     
/*     */ 
/* 238 */     String e = "CREATE TABLE " + nomTable + "(\n";
/* 239 */     String ref = getAllcontrainteEntite(ent);
/* 240 */     checkE = "";
/* 241 */     prkey = "";
/* 242 */     index = "";
/*     */     
/* 244 */     int lg = longueurMaxAttribut(listeAttribut);
/* 245 */     for (int i = 0; i < listeAttribut.size(); i++) {
/* 246 */       if (s.trim().length() == 0) { s = "\t" + SQLAttribut((Attribut)listeAttribut.get(i), ent, nomTable, pageMcd, lg);
/*     */       } else {
/* 248 */         s = s + " ,\n\t" + SQLAttribut((Attribut)listeAttribut.get(i), ent, nomTable, pageMcd, lg);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 253 */     if ((prkey.trim().length() != 0) && 
/* 254 */       (!isAutoinc)) {
/* 255 */       s = s + ",\n\tCONSTRAINT " + nmPK + " PRIMARY KEY (" + prkey + ")";
/*     */     }
/*     */     
/* 258 */     if (checkE.trim().length() != 0) s = s + " ,\n\t" + checkE;
/* 259 */     if (indexEnt.trim().length() != 0) {
/* 260 */       index = index + "CREATE INDEX " + idx + " ON " + nomTable + " (" + indexEnt + ");\n";
/*     */     }
/*     */     
/* 263 */     if (ref.trim().length() == 0) {
/* 264 */       e = e + s + "\n);\n";
/*     */     } else {
/* 266 */       e = e + s + ref + "\n);\n";
/*     */     }
/* 268 */     return e;
/*     */   }
/*     */   
/*     */   private static String SQLListeEntite(IhmPageMCD pagemcd, IhmPageMLD pagemld) {
/* 272 */     String s = "";
/* 273 */     index = "";
/* 274 */     for (int i = 0; i < pagemld.getListeMLDEntite().size(); i++) {
/* 275 */       s = s + "\n------------------------------------------------------------\n";
/* 276 */       s = s + "-- Table: " + ((MLDEntite2)pagemld.getListeMLDEntite().get(i)).getNom();
/* 277 */       s = s + "\n------------------------------------------------------------\n";
/* 278 */       s = s + SQLEntite((MLDEntite2)pagemld.getListeMLDEntite().get(i), pagemcd, pagemld) + "\n";
/*     */     }
/* 280 */     s = s + "\n" + index;
/* 281 */     return s;
/*     */   }
/*     */   
/*     */   public static String getScript(IhmPageMCD pagemcd, IhmPageMLD pagemld) {
/* 285 */     String s = "------------------------------------------------------------\n";
/* 286 */     s = s + "--        Script SQLite  \n";
/* 287 */     s = s + "------------------------------------------------------------\n\n";
/* 288 */     s = s + SQLListeEntite(pagemcd, pagemld);
/* 289 */     if (!Principale.isActiverJMerise()) {
/* 290 */       s = SQLOutil.getCentLignes(s);
/*     */     }
/* 292 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */   private static String getSQLNomTable(MLDEntite2 ent)
/*     */   {
/* 298 */     String st = "";String s = "";
/* 299 */     if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 300 */       s = SQLOutil.remplaceChar(Setting.developpeur);
/* 301 */       s = s.toUpperCase();
/*     */     }
/* 303 */     if (Setting.SQLUtiliserCode) {
/* 304 */       st = SQLOutil.remplaceChar(ent.getCode());
/*     */     } else {
/* 306 */       st = SQLOutil.remplaceChar(ent.getNom());
/*     */     }
/* 308 */     if (s.length() == 0) s = st; else
/* 309 */       s = s + "_" + st;
/* 310 */     return s;
/*     */   }
/*     */   
/*     */   private static String getNomAttribut(Attribut2 att) {
/* 314 */     if (Setting.SQLUtiliserCode) return SQLOutil.remplaceChar(att.getCode());
/* 315 */     return SQLOutil.remplaceChar(att.getNom());
/*     */   }
/*     */   
/*     */   private static String getUneContrainteFK_Interne(TableReference tab, String num)
/*     */   {
/* 320 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 321 */     String att = "";String attRef = "";
/*     */     
/* 323 */     for (int i = 0; i < liste.size(); i++) {
/* 324 */       if (att.length() == 0) {
/* 325 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 326 */         attRef = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */       else {
/* 329 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 330 */         attRef = attRef + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */     }
/* 333 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 334 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 335 */     String nomCnt = "";
/* 336 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "FK_" + nomTab + "_" + nomTabRef + num; else {
/* 337 */       nomCnt = nomTab + "_" + nomTabRef + num + "_FK";
/*     */     }
/* 339 */     String s = "\n\t,CONSTRAINT " + nomCnt + " FOREIGN KEY (" + att + ")" + " REFERENCES " + nomTabRef + "(" + attRef + ")";
/*     */     
/* 341 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteAK_Interne(TableReference tab, String num)
/*     */   {
/* 346 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 347 */     String att = "";
/*     */     
/* 349 */     for (int i = 0; i < liste.size(); i++) {
/* 350 */       if (att.length() == 0) {
/* 351 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */       else {
/* 354 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */     }
/* 357 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 358 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 359 */     String nomCnt = "";
/* 360 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "AK_" + nomTab + "_" + nomTabRef + num; else {
/* 361 */       nomCnt = nomTab + "_" + nomTabRef + num + "_AK";
/*     */     }
/* 363 */     String s = "\n\t,CONSTRAINT " + nomCnt + " UNIQUE (" + att + ")";
/*     */     
/* 365 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllcontrainteEntite(MLDEntite2 ent) {
/* 369 */     String s = "";
/* 370 */     String nn = "";
/* 371 */     for (int i = 0; i < ent.getListeCNTForeingKey().size(); i++) {
/* 372 */       s = s + getUneContrainteFK_Interne((TableReference)ent.getListeCNTForeingKey().get(i), nn);
/* 373 */       nn = i + "";
/*     */     }
/* 375 */     if (s.length() > 0) s = "\n" + s;
/* 376 */     nn = "";
/* 377 */     for (int i = 0; i < ent.getListeCNTALTERNATIVEKEY().size(); i++) {
/* 378 */       s = s + getUneContrainteAK_Interne((TableReference)ent.getListeCNTALTERNATIVEKEY().get(i), nn);
/* 379 */       nn = i + "";
/*     */     }
/* 381 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */   public static ArrayList<String> creerListeTable(String script)
/*     */   {
/* 387 */     ArrayList<String> listeTable = new ArrayList();
/* 388 */     String d = " ";
/* 389 */     int indexx = -1;
/* 390 */     String scriptCREATE = script;
/*     */     
/* 392 */     indexx = scriptCREATE.toUpperCase().indexOf("CREATE");
/* 393 */     scriptCREATE = scriptCREATE.substring(indexx);
/* 394 */     if (indexx > -1) {
/* 395 */       while (indexx > -1) {
/* 396 */         d = scriptCREATE.substring(0, scriptCREATE.toUpperCase().indexOf(";") + 1);
/* 397 */         scriptCREATE = scriptCREATE.substring(scriptCREATE.indexOf(";") + 1);
/* 398 */         listeTable.add(d);
/* 399 */         indexx = scriptCREATE.toUpperCase().indexOf("CREATE");
/*     */       }
/*     */     }
/*     */     
/* 403 */     return listeTable;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Output\SQLite.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */