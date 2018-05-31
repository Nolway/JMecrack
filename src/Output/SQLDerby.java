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
/*     */ public class SQLDerby
/*     */ {
/*  26 */   private static String checkE = "";
/*  27 */   private static String index = "";
/*  28 */   private static String indexEnt = "";
/*  29 */   private static String prkey = "";
/*  30 */   private static String uniqu = "";
/*     */   
/*     */   private static String remplacerType(String type)
/*     */   {
/*  34 */     String t = "";
/*  35 */     if ((type.trim().toUpperCase().equals("TINYINT")) || (type.trim().toUpperCase().equals("MEDIUMINT")) || (type.trim().toUpperCase().equals("BIGINT")) || (type.trim().toUpperCase().equals("UNSIGNED BIG INT")) || (type.trim().toUpperCase().equals("INT2")) || (type.trim().toUpperCase().equals("INT8")))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  40 */       t = "INTEGER";
/*     */     }
/*  42 */     if ((type.trim().toUpperCase().equals("LONGTEXT")) || (type.trim().toUpperCase().equals("MEDIUMTEXT")) || (type.trim().toUpperCase().equals("TINYTEXT")) || (type.trim().toUpperCase().equals("TEXT")))
/*     */     {
/*     */ 
/*     */ 
/*  46 */       t = "LONG VARCHAR ";
/*     */     }
/*  48 */     if ((type.trim().toUpperCase().equals("BLOB")) || (type.trim().toUpperCase().equals("TINYBLOB")) || (type.trim().toUpperCase().equals("LONGBLOB")))
/*     */     {
/*     */ 
/*  51 */       t = "BLOB";
/*     */     }
/*  53 */     if ((type.trim().toUpperCase().equals("DOUBLE")) || (type.trim().toUpperCase().equals("DOUBLE PRECISION")))
/*     */     {
/*     */ 
/*     */ 
/*  57 */       t = "REAL";
/*     */     }
/*  59 */     if (type.trim().toUpperCase().equals("BOOL"))
/*  60 */       t = "BOOL ";
/*  61 */     if ((type.trim().toUpperCase().equals("DATETIME")) || (type.trim().toUpperCase().equals("YEAR")))
/*     */     {
/*     */ 
/*  64 */       t = "TIME";
/*     */     }
/*     */     
/*  67 */     if (type.trim().toUpperCase().equals("MONEY"))
/*     */     {
/*     */ 
/*  70 */       t = "DECIMAL";
/*     */     }
/*     */     
/*  73 */     if (type.trim().toUpperCase().equals("AUTO_INCREMENT"))
/*  74 */       t = "INT GENERATED ALWAYS AS IDENTITY ";
/*  75 */     if (t.trim().length() == 0) t = type;
/*  76 */     return t;
/*     */   }
/*     */   
/*     */   private static String getType(Attribut att, IhmPageMCD page)
/*     */   {
/*  81 */     if (isDomaine(att, page)) return SQLGetTypeEnum(att.getNom(), att.getType(), page);
/*  82 */     return remplacerType(att.getType());
/*     */   }
/*     */   
/*     */   private static boolean isDomaine(Attribut att, IhmPageMCD page) {
/*  86 */     ArrayList<Domaine> list = page.getListeDomaine();
/*  87 */     for (int i = 0; i < list.size(); i++) {
/*  88 */       if (att.getType().equals(((Domaine)list.get(i)).getNom())) {
/*  89 */         return true;
/*     */       }
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   private static String SQLGetTypeEnum(String att, String type, IhmPageMCD page) {
/*  96 */     String s = "";
/*  97 */     ArrayList<Domaine> list = page.getListeDomaine();
/*  98 */     Domaine d = null;
/*  99 */     for (int i = 0; i < list.size(); i++) {
/* 100 */       if (type.equals(((Domaine)list.get(i)).getNom())) {
/* 101 */         d = (Domaine)list.get(i);
/* 102 */         break;
/*     */       }
/*     */     }
/* 105 */     if (d != null) {
/* 106 */       int tail = 0;
/* 107 */       for (int i = 0; i < d.getListeValeurs().size(); i++) {
/* 108 */         if (s.trim().length() == 0) {
/* 109 */           s = "'" + (String)d.getListeValeurs().get(i) + "'";
/* 110 */           tail = ((String)d.getListeValeurs().get(i)).length();
/*     */         }
/*     */         else {
/* 113 */           s = s + ",'" + (String)d.getListeValeurs().get(i) + "'";
/* 114 */           if (tail < ((String)d.getListeValeurs().get(i)).length()) {
/* 115 */             tail = ((String)d.getListeValeurs().get(i)).length();
/*     */           }
/*     */         }
/*     */       }
/* 119 */       if (checkE.trim().length() == 0) checkE = checkE + "CONSTRAINT " + att + "_chk CHECK (" + att + " IN (" + s + "))"; else
/* 120 */         checkE = checkE + ",\n\tCHECK (" + att + " IN (" + s + "))";
/* 121 */       s = "Varchar (" + tail + ")";
/* 122 */       s = "TEXT ";
/*     */     }
/* 124 */     return s;
/*     */   }
/*     */   
/*     */   private static String ajusterNom(String nom, int tailMax) {
/* 128 */     nom = SQLOutil.remplaceChar(nom);
/* 129 */     for (int i = nom.length(); i < tailMax; i++) {
/* 130 */       nom = nom + " ";
/*     */     }
/* 132 */     return nom;
/*     */   }
/*     */   
/*     */   private static int longueurMaxAttribut(ArrayList<Attribut> listeAttributs) {
/* 136 */     int max = 0;
/*     */     
/*     */ 
/* 139 */     for (int i = 0; i < listeAttributs.size(); i++) {
/* 140 */       Attribut2 att = (Attribut2)listeAttributs.get(i);
/* 141 */       String nom; if (Setting.SQLUtiliserCode) {
/* 142 */         nom = att.getCode();
/*     */       } else {
/* 144 */         nom = att.getNom();
/*     */       }
/* 146 */       if (nom.length() > max) {
/* 147 */         max = nom.length();
/*     */       }
/*     */     }
/* 150 */     return max;
/*     */   }
/*     */   
/*     */   private static String SQLAttribut(Attribut att, MLDEntite2 ent, IhmPageMCD pageMcd, int lg) {
/* 154 */     String s = "";
/* 155 */     String cle = "";
/* 156 */     String notNull = "";
/* 157 */     String type = "";
/* 158 */     boolean nul = true;
/*     */     
/*     */ 
/* 161 */     if (Setting.SQLUtiliserCode) {
/* 162 */       String nomTable = ent.getCode();
/* 163 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 164 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/* 166 */       nomTable = nomTable.toUpperCase();
/*     */     } else {
/* 168 */       String nomTable = ent.getNom();
/* 169 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 170 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/*     */     }
/*     */     
/*     */     String nomAtt;
/* 176 */     if (Setting.SQLUtiliserCode) {
/* 177 */       nomAtt = ((Attribut2)att).getCode();
/*     */     } else {
/* 179 */       nomAtt = att.getNom();
/*     */     }
/*     */     
/*     */ 
/* 183 */     if (att.getKey().equals(Parametres.Cle)) {
/* 184 */       cle = " PRIMARY KEY";
/* 185 */       nul = false;
/* 186 */       if (prkey.trim().length() == 0) prkey = SQLOutil.remplaceChar(nomAtt); else
/* 187 */         prkey = prkey + "," + SQLOutil.remplaceChar(nomAtt);
/*     */     }
/* 189 */     if (att.getKey().equals(Parametres.Unique)) {
/* 190 */       cle = " UNIQUE ";
/* 191 */       nul = false;
/* 192 */       if (uniqu.trim().length() == 0) uniqu = SQLOutil.remplaceChar(nomAtt); else
/* 193 */         uniqu = uniqu + "," + SQLOutil.remplaceChar(nomAtt);
/*     */     }
/* 195 */     if (att.getKey().equals(Parametres.Index)) {
/* 196 */       if (indexEnt.trim().length() == 0) indexEnt = SQLOutil.remplaceChar(nomAtt); else {
/* 197 */         indexEnt = indexEnt + "," + SQLOutil.remplaceChar(nomAtt);
/*     */       }
/*     */     }
/* 200 */     if ((nul) && 
/* 201 */       (!att.isNulle())) {
/* 202 */       notNull = " NOT NULL ";
/*     */     }
/*     */     
/* 205 */     if (att.getType().trim().toUpperCase().equals("AUTO_INCREMENT")) {
/* 206 */       type = "INT GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) ";
/* 207 */       s = ajusterNom(nomAtt, lg) + "  " + type;
/*     */     } else {
/* 209 */       type = getType(att, pageMcd);
/* 210 */       if (type.trim().toUpperCase().equals("VARCHAR")) s = ajusterNom(nomAtt, lg) + "  " + type + " (" + att.getLongueur() + ") " + notNull;
/* 211 */       if (att.getType().trim().toUpperCase().equals("MONEY")) s = ajusterNom(nomAtt, lg) + "  " + type + " (15,3) " + notNull; else
/* 212 */         s = ajusterNom(nomAtt, lg) + "  " + type + notNull;
/*     */     }
/* 214 */     return s;
/*     */   }
/*     */   
/*     */   private static String SQLEntite(MLDEntite2 ent, IhmPageMCD pageMcd, IhmPageMLD pageMld) {
/* 218 */     String s = "";
/*     */     ArrayList<Attribut> listeAttribut;
/* 221 */     if (ent.isComposer()) {
/* 222 */       listeAttribut = SQLOutil.decomposerLesAttributsMLDEntite(ent);
/*     */     } else {
/* 224 */       listeAttribut = ent.getListeAttributs();
/*     */     }
/*     */     String nomTable;
/* 227 */     if (Setting.SQLUtiliserCode) {
/* 228 */       nomTable = ent.getCode();
/* 229 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 230 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/* 232 */       nomTable = nomTable.toUpperCase();
/*     */     } else {
/* 234 */       nomTable = ent.getNom();
/* 235 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 236 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/*     */     }
/*     */     
/* 240 */     String idx = "";
/* 241 */     if (Setting.SQLPrefixerLeNomContrainte2) idx = "Idx_" + nomTable; else {
/* 242 */       idx = nomTable + "_Idx";
/*     */     }
/* 244 */     String e = "CREATE TABLE " + SQLOutil.remplaceChar(nomTable) + "(\n";
/*     */     
/* 246 */     checkE = "";
/* 247 */     prkey = "";
/* 248 */     uniqu = "";
/* 249 */     indexEnt = "";
/* 250 */     int lg = longueurMaxAttribut(listeAttribut);
/* 251 */     for (int i = 0; i < listeAttribut.size(); i++) {
/* 252 */       if (s.trim().length() == 0) { s = "\t" + SQLAttribut((Attribut)listeAttribut.get(i), ent, pageMcd, lg);
/*     */       } else {
/* 254 */         s = s + " ,\n\t" + SQLAttribut((Attribut)listeAttribut.get(i), ent, pageMcd, lg);
/*     */       }
/*     */     }
/* 257 */     if (prkey.trim().length() != 0) s = s + " ,\n\tPRIMARY KEY (" + prkey + ")";
/* 258 */     if (uniqu.trim().length() != 0) s = s + " ,\n\tUNIQUE (" + uniqu + ")";
/* 259 */     if (checkE.trim().length() != 0) s = s + " ,\n\t" + checkE;
/* 260 */     if (indexEnt.trim().length() != 0) {
/* 261 */       index = index + "CREATE INDEX " + idx + " ON " + SQLOutil.remplaceChar(nomTable) + " (" + indexEnt + ");\n";
/*     */     }
/*     */     
/* 264 */     return e + s + "\n);\n";
/*     */   }
/*     */   
/*     */   private static String SQLListeEntite(IhmPageMCD pagemcd, IhmPageMLD pagemld) {
/* 268 */     String s = "";
/* 269 */     index = "";
/*     */     
/* 271 */     for (int i = 0; i < pagemld.getListeMLDEntite().size(); i++) {
/* 272 */       s = s + "\n------------------------------------------------------------\n";
/* 273 */       s = s + "-- Table: " + ((MLDEntite2)pagemld.getListeMLDEntite().get(i)).getNom();
/* 274 */       s = s + "\n------------------------------------------------------------\n";
/* 275 */       s = s + SQLEntite((MLDEntite2)pagemld.getListeMLDEntite().get(i), pagemcd, pagemld) + "\n";
/*     */     }
/* 277 */     s = s + "\n" + index;
/* 278 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */   public static String getScript(IhmPageMCD pagemcd, IhmPageMLD pagemld)
/*     */   {
/* 284 */     String s = "------------------------------------------------------------\n";
/* 285 */     s = s + "--        Script SQL_Derby.  \n";
/* 286 */     s = s + "------------------------------------------------------------\n\n";
/* 287 */     s = s + SQLListeEntite(pagemcd, pagemld);
/* 288 */     String c = getAllReference(pagemld);
/* 289 */     s = s + c;
/* 290 */     if (!Principale.isActiverJMerise()) {
/* 291 */       s = SQLOutil.getCentLignes(s);
/*     */     }
/* 293 */     return s;
/*     */   }
/*     */   
/*     */   private static String supperimerVide(String s) {
/* 297 */     return s.replace(";", "");
/*     */   }
/*     */   
/*     */   public static ArrayList<String> creerListeTable(String script) {
/* 301 */     ArrayList<String> listeTable = new ArrayList();
/* 302 */     String d = " ";
/* 303 */     int indexx = -1;
/* 304 */     String scriptCREATE = script;
/* 305 */     String scriptALTER = script.substring(script.toUpperCase().indexOf("ALTER"), script.length());
/* 306 */     indexx = scriptCREATE.toUpperCase().indexOf("CREATE");
/* 307 */     scriptCREATE = scriptCREATE.substring(indexx);
/* 308 */     if (indexx > -1) {
/* 309 */       while (indexx > -1) {
/* 310 */         d = scriptCREATE.substring(0, scriptCREATE.toUpperCase().indexOf(";") + 1);
/* 311 */         scriptCREATE = scriptCREATE.substring(scriptCREATE.indexOf(";") + 1);
/* 312 */         listeTable.add(supperimerVide(d));
/* 313 */         indexx = scriptCREATE.toUpperCase().indexOf("CREATE");
/*     */       }
/*     */     }
/*     */     
/* 317 */     indexx = scriptALTER.toUpperCase().indexOf("ALTER");
/* 318 */     scriptALTER = scriptALTER.substring(indexx);
/* 319 */     if (indexx > -1) {
/* 320 */       while (indexx > -1) {
/* 321 */         d = scriptALTER.substring(0, scriptALTER.toUpperCase().indexOf(";") + 1);
/* 322 */         scriptALTER = scriptALTER.substring(scriptALTER.indexOf(";") + 1);
/* 323 */         listeTable.add(supperimerVide(d));
/* 324 */         indexx = scriptALTER.toUpperCase().indexOf("ALTER");
/*     */       }
/*     */     }
/* 327 */     return listeTable;
/*     */   }
/*     */   
/*     */ 
/*     */   private static String getSQLNomTable(MLDEntite2 ent)
/*     */   {
/* 333 */     String st = "";String s = "";
/* 334 */     if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 335 */       s = SQLOutil.remplaceChar(Setting.developpeur);
/* 336 */       s = s.toUpperCase();
/*     */     }
/* 338 */     if (Setting.SQLUtiliserCode) {
/* 339 */       st = SQLOutil.remplaceChar(ent.getCode());
/*     */     } else {
/* 341 */       st = SQLOutil.remplaceChar(ent.getNom());
/*     */     }
/* 343 */     if (s.length() == 0) s = st; else
/* 344 */       s = s + "_" + st;
/* 345 */     return s;
/*     */   }
/*     */   
/*     */   private static String getNomAttribut(Attribut2 att) {
/* 349 */     if (Setting.SQLUtiliserCode) return SQLOutil.remplaceChar(att.getCode());
/* 350 */     return SQLOutil.remplaceChar(att.getNom());
/*     */   }
/*     */   
/*     */   private static String getUneContrainteFK(TableReference tab, String num) {
/* 354 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 355 */     String att = "";String attRef = "";
/*     */     
/* 357 */     for (int i = 0; i < liste.size(); i++) {
/* 358 */       if (att.length() == 0) {
/* 359 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 360 */         attRef = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */       else {
/* 363 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 364 */         attRef = attRef + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */     }
/* 367 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 368 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 369 */     String nomCnt = "";
/* 370 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "FK_" + nomTab + "_" + nomTabRef + num; else {
/* 371 */       nomCnt = nomTab + "_" + nomTabRef + num + "_FK";
/*     */     }
/* 373 */     String s = "\nALTER TABLE " + nomTab + "\n\tADD CONSTRAINT " + nomCnt + "\n\tFOREIGN KEY (" + att + ")" + "\n\tREFERENCES " + nomTabRef + "(" + attRef + ");\n";
/*     */     
/* 375 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContrainteFK(MLDEntite2 ent) {
/* 379 */     String s = "";
/* 380 */     for (int i = 0; i < ent.getListeCNTForeingKey().size(); i++) {
/* 381 */       s = s + getUneContrainteFK((TableReference)ent.getListeCNTForeingKey().get(i), new StringBuilder().append(i).append("").toString());
/*     */     }
/* 383 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteAK(TableReference tab, String num) {
/* 387 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 388 */     String att = "";
/*     */     
/* 390 */     for (int i = 0; i < liste.size(); i++) {
/* 391 */       if (att.length() == 0) {
/* 392 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */       else
/*     */       {
/* 396 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */     }
/* 399 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 400 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 401 */     String nomCnt = "";
/* 402 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "AK_" + nomTab + "_" + nomTabRef + num; else {
/* 403 */       nomCnt = nomTab + "_" + nomTabRef + num + "_AK";
/*     */     }
/* 405 */     String s = "\nALTER TABLE " + nomTab + "\n\tADD CONSTRAINT " + nomCnt + " \n\tUNIQUE (" + att + ");\n";
/*     */     
/* 407 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContrainteAK(MLDEntite2 ent) {
/* 411 */     String s = "";
/* 412 */     for (int i = 0; i < ent.getListeCNTALTERNATIVEKEY().size(); i++) {
/* 413 */       s = s + getUneContrainteAK((TableReference)ent.getListeCNTALTERNATIVEKEY().get(i), new StringBuilder().append(i).append("").toString());
/*     */     }
/* 415 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContraintesEntite(MLDEntite2 ent) {
/* 419 */     String s = "";
/* 420 */     s = getAllContrainteFK(ent);
/* 421 */     s = s + getAllContrainteAK(ent);
/* 422 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllReference(IhmPageMLD page) {
/* 426 */     String s = "";
/*     */     
/* 428 */     for (int i = 0; i < page.getListeMLDEntite().size(); i++) {
/* 429 */       s = s + getAllContraintesEntite((MLDEntite2)page.getListeMLDEntite().get(i));
/*     */     }
/* 431 */     return s;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Output\SQLDerby.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */