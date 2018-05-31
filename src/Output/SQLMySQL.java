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
/*     */ public class SQLMySQL
/*     */ {
/*     */   private static String getSQLPKey(MLDEntite2 ent, ArrayList<Attribut> listeAttribut)
/*     */   {
/*  27 */     ArrayList<Attribut> liste = new ArrayList();
/*  28 */     String s = "";
/*  29 */     for (int i = 0; i < listeAttribut.size(); i++) {
/*  30 */       if (((Attribut)listeAttribut.get(i)).getKey().equals(Parametres.Cle)) {
/*  31 */         liste.add(listeAttribut.get(i));
/*     */       }
/*     */     }
/*  34 */     for (int i = 0; i < liste.size(); i++) {
/*  35 */       if (s.length() == 0) s = getNomAttribut((Attribut2)liste.get(i)); else {
/*  36 */         s = s + "," + getNomAttribut((Attribut2)liste.get(i));
/*     */       }
/*     */     }
/*  39 */     if (s.length() > 0) {
/*  40 */       String nmPK = getSQLNomTable(ent);
/*  41 */       if (Setting.SQLPrefixerLeNomContrainte2) nmPK = "PK_" + nmPK; else {
/*  42 */         nmPK = nmPK + "_PK";
/*     */       }
/*  44 */       s = "\n\t,CONSTRAINT " + nmPK + " PRIMARY KEY (" + s + ")";
/*     */     }
/*     */     
/*  47 */     return s;
/*     */   }
/*     */   
/*     */   private static ArrayList<Attribut> getListeUnque(ArrayList<Attribut> liste)
/*     */   {
/*  52 */     ArrayList<Attribut> l = new ArrayList();
/*  53 */     for (int i = 0; i < liste.size(); i++) {
/*  54 */       Attribut att = (Attribut)liste.get(i);
/*  55 */       if (att.getKey().equals(Parametres.Unique)) {
/*  56 */         l.add(att);
/*     */       }
/*     */     }
/*  59 */     return l;
/*     */   }
/*     */   
/*     */   private static String getCNTUniqueInterne(MLDEntite2 ent, ArrayList<Attribut> listeAtt) {
/*  63 */     ArrayList<Attribut> l = getListeUnque(listeAtt);
/*  64 */     if (l.size() == 0) return "";
/*  65 */     String sAtt = "";String s = "";
/*     */     
/*  67 */     for (int i = 0; i < l.size(); i++) {
/*  68 */       Attribut2 att = (Attribut2)l.get(i);
/*  69 */       if (Setting.SQLUtiliserCode) sAtt = SQLOutil.remplaceChar(att.getCode()); else
/*  70 */         sAtt = SQLOutil.remplaceChar(att.getNom());
/*  71 */       if (s.length() == 0) s = sAtt; else
/*  72 */         s = s + "," + sAtt;
/*     */     }
/*  74 */     String nmCnt = "";
/*  75 */     if (Setting.SQLUtiliserCode) nmCnt = ent.getCode(); else
/*  76 */       nmCnt = ent.getNom();
/*  77 */     if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/*  78 */       nmCnt = Setting.developpeur + "_" + nmCnt;
/*     */     }
/*  80 */     if (Setting.SQLPrefixerLeNomContrainte2)
/*  81 */       nmCnt = "AK_" + nmCnt; else {
/*  82 */       nmCnt = nmCnt + "_AK";
/*     */     }
/*  84 */     if (ent.getListeCNTALTERNATIVEKEY().size() > 0) nmCnt = nmCnt + "0";
/*  85 */     nmCnt = SQLOutil.remplaceChar(nmCnt);
/*  86 */     s = "\n\t,CONSTRAINT " + nmCnt + " UNIQUE (" + s + ")";
/*  87 */     return s;
/*     */   }
/*     */   
/*     */   private static String getCNTINDEXInterne(MLDEntite2 ent, ArrayList<Attribut> listeAtt) {
/*  91 */     ArrayList<Attribut> l = getListeIndex(listeAtt);
/*  92 */     if (l.size() == 0) return "";
/*  93 */     String sAtt = "";String s = "";
/*     */     
/*  95 */     for (int i = 0; i < l.size(); i++) {
/*  96 */       Attribut2 att = (Attribut2)l.get(i);
/*  97 */       if (Setting.SQLUtiliserCode) sAtt = SQLOutil.remplaceChar(att.getCode()); else
/*  98 */         sAtt = SQLOutil.remplaceChar(att.getNom());
/*  99 */       if (s.length() == 0) s = sAtt; else
/* 100 */         s = s + "," + sAtt;
/*     */     }
/* 102 */     String nmCnt = "";
/* 103 */     if (Setting.SQLUtiliserCode) nmCnt = ent.getCode(); else
/* 104 */       nmCnt = ent.getNom();
/* 105 */     if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 106 */       nmCnt = Setting.developpeur + "_" + nmCnt;
/*     */     }
/* 108 */     if (Setting.SQLPrefixerLeNomContrainte2)
/* 109 */       nmCnt = "Idx_" + nmCnt; else
/* 110 */       nmCnt = nmCnt + "_Idx";
/* 111 */     nmCnt = SQLOutil.remplaceChar(nmCnt);
/*     */     
/* 113 */     s = "\n\t,CONSTRAINT " + nmCnt + " INDEX (" + s + ")";
/* 114 */     return s;
/*     */   }
/*     */   
/*     */   private static ArrayList<Attribut> getListeIndex(ArrayList<Attribut> liste)
/*     */   {
/* 119 */     ArrayList<Attribut> l = new ArrayList();
/* 120 */     for (int i = 0; i < liste.size(); i++) {
/* 121 */       Attribut att = (Attribut)liste.get(i);
/* 122 */       if (att.getKey().equals(Parametres.Index)) {
/* 123 */         l.add(att);
/*     */       }
/*     */     }
/* 126 */     return l;
/*     */   }
/*     */   
/*     */   private static String getSqlString(MLDEntite2 ent, IhmPageMCD pageMcd, IhmPageMLD pageMld) { ArrayList<Attribut> listeAttribut;
/* 131 */     if (ent.isComposer()) {
/* 132 */       listeAttribut = SQLOutil.decomposerLesAttributsMLDEntite(ent);
/*     */     } else {
/* 134 */       listeAttribut = ent.getListeAttributs();
/*     */     }
/*     */     
/* 137 */     int max = longueurMaxAttribut(listeAttribut);
/* 138 */     String sqlStr = "";
/* 139 */     String prKey = Parametres.Cle + " (";
/* 140 */     String index = getCNTINDEXInterne(ent, listeAttribut);
/* 141 */     String uniq = getCNTUniqueInterne(ent, listeAttribut);
/* 142 */     String commentEntite = "";
/*     */     
/*     */ 
/*     */ 
/* 146 */     String nomTable = getSQLNomTable(ent);
/*     */     
/* 148 */     if (listeAttribut.size() == 0) return "";
/* 149 */     sqlStr = sqlStr + "CREATE TABLE " + SQLOutil.remplaceChar(nomTable) + "(\n        ";
/* 150 */     for (int i = 0; i < listeAttribut.size(); i++)
/*     */     {
/*     */ 
/* 153 */       commentEntite = "";
/* 154 */       sqlStr = sqlStr + getConversionToString((Attribut)listeAttribut.get(i), max, pageMcd);
/* 155 */       if (i + 1 == listeAttribut.size())
/*     */       {
/* 157 */         if (Setting.inclureCommentTableSQL) {
/* 158 */           commentEntite = SQLOutil.SQLCommenaire(ent);
/*     */         }
/* 160 */         prKey = getSQLPKey(ent, listeAttribut);
/* 161 */         if (!pageMld.isMutex()) { prKey = prKey + getAllcontrainteEntite(ent);
/*     */         }
/* 163 */         sqlStr = sqlStr + uniq + index + prKey + "\n)ENGINE=InnoDB" + commentEntite + ";\n\n";
/*     */       } else {
/* 165 */         sqlStr = sqlStr + " ,\n        ";
/*     */       } }
/* 167 */     return sqlStr;
/*     */   }
/*     */   
/*     */   private static String getConversionToString(Attribut att, int tailMax, IhmPageMCD pageMcd) {
/* 171 */     String plus = "";
/* 172 */     String typ = "";
/* 173 */     String nul = "";
/* 174 */     String comment = "";
/* 175 */     if ((att.getType().toUpperCase().equals("DECIMAL")) || (att.getType().toUpperCase().equals("DOUBLE PRECISION")))
/*     */     {
/* 177 */       if (att.getLongueur() >= 0) plus = plus + " (" + att.getLongueur();
/* 178 */       if (att.getLongDecimale() >= 0) plus = plus + "," + att.getLongDecimale();
/* 179 */       if (att.getLongueur() >= 0) plus = plus + ")";
/*     */     }
/* 181 */     if ((att.getType().toUpperCase().equals("CHAR")) || (att.getType().toUpperCase().equals("VARCHAR")))
/*     */     {
/* 183 */       if (att.getLongueur() >= 0) plus = plus + " (" + att.getLongueur();
/* 184 */       if (att.getLongueur() >= 0) plus = plus + ")";
/*     */     }
/* 186 */     typ = retournerType(att, pageMcd);
/* 187 */     if (att.getType().equals("Auto_increment")) typ = "Int  Auto_increment ";
/* 188 */     if (att.getType().equals("Money")) typ = "DECIMAL (15,3) ";
/* 189 */     if (!att.isNulle()) nul = " NOT NULL";
/* 190 */     if (att.getKey().equals("PRIMARY KEY")) nul = " NOT NULL";
/* 191 */     if (Setting.inclureCommentAttSQL)
/* 192 */       comment = SQLOutil.SQLCommenaire(att);
/*     */     String nomAtt;
/* 195 */     if (Setting.SQLUtiliserCode) {
/* 196 */       nomAtt = ((Attribut2)att).getCode();
/*     */     } else {
/* 198 */       nomAtt = att.getNom();
/*     */     }
/* 200 */     return ajusterNom(nomAtt, tailMax) + " " + typ + plus + nul + comment;
/*     */   }
/*     */   
/*     */   private static int longueurMaxAttribut(ArrayList<Attribut> listeAttributs) {
/* 204 */     int max = 0;
/*     */     
/*     */ 
/* 207 */     for (int i = 0; i < listeAttributs.size(); i++) {
/* 208 */       Attribut2 att = (Attribut2)listeAttributs.get(i);
/* 209 */       String nom; if (Setting.SQLUtiliserCode) {
/* 210 */         nom = att.getCode();
/*     */       } else {
/* 212 */         nom = att.getNom();
/*     */       }
/* 214 */       if (nom.length() > max) {
/* 215 */         max = nom.length();
/*     */       }
/*     */     }
/* 218 */     return max;
/*     */   }
/*     */   
/*     */   private static String retournerType(Attribut att, IhmPageMCD pageMcd) {
/* 222 */     if (domaineReserve(att.getType(), pageMcd)) return att.getType();
/* 223 */     return retournerTypeDefini(att, pageMcd);
/*     */   }
/*     */   
/*     */   private static String retournerTypeDefini(Attribut att, IhmPageMCD pageMcd) {
/* 227 */     Domaine d = null;
/* 228 */     String s = "";
/* 229 */     for (int i = 0; i < pageMcd.getListeDomaine().size(); i++) {
/* 230 */       if (att.getType().trim().toUpperCase().equals(((Domaine)pageMcd.getListeDomaine().get(i)).getNom().toUpperCase())) {
/* 231 */         d = (Domaine)pageMcd.getListeDomaine().get(i);
/*     */       }
/*     */     }
/* 234 */     if (d != null) {
/* 235 */       s = "Enum (\"";
/* 236 */       for (int i = 0; i < d.getListeValeurs().size(); i++) {
/* 237 */         s = s + (String)d.getListeValeurs().get(i) + "\"";
/* 238 */         if (i + 1 == d.getListeValeurs().size()) s = s + ")"; else
/* 239 */           s = s + ",\"";
/*     */       }
/*     */     }
/* 242 */     return s;
/*     */   }
/*     */   
/*     */   private static boolean domaineReserve(String dom, IhmPageMCD pageMcd)
/*     */   {
/* 247 */     for (int i = 0; i < pageMcd.getListeDomaine().size(); i++) {
/* 248 */       if (dom.trim().toUpperCase().equals(((Domaine)pageMcd.getListeDomaine().get(i)).getNom().toUpperCase())) {
/* 249 */         return false;
/*     */       }
/*     */     }
/* 252 */     return true;
/*     */   }
/*     */   
/*     */   private static String ajusterNom(String nom, int tailMax) {
/* 256 */     nom = SQLOutil.remplaceChar(nom);
/* 257 */     for (int i = nom.length(); i < tailMax; i++) {
/* 258 */       nom = nom + " ";
/*     */     }
/* 260 */     return nom;
/*     */   }
/*     */   
/*     */   public static String SQLListeEntite(IhmPageMLD pageMld, IhmPageMCD pageMcd)
/*     */   {
/* 265 */     String s = "";
/* 266 */     for (int i = 0; i < pageMld.getListeMLDEntite().size(); i++) {
/* 267 */       s = s + "\n#------------------------------------------------------------\n";
/* 268 */       s = s + "# Table: " + ((MLDEntite2)pageMld.getListeMLDEntite().get(i)).getNom();
/* 269 */       s = s + "\n#------------------------------------------------------------\n";
/* 270 */       s = s + "\n" + getSqlString((MLDEntite2)pageMld.getListeMLDEntite().get(i), pageMcd, pageMld);
/*     */     }
/* 272 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String getScript(IhmPageMCD pageMcd, IhmPageMLD pageMld)
/*     */   {
/* 279 */     String s = "#------------------------------------------------------------\n";
/* 280 */     s = s + "#        Script MySQL.\n";
/* 281 */     s = s + "#------------------------------------------------------------\n\n";
/* 282 */     s = s + SQLListeEntite(pageMld, pageMcd);
/*     */     
/* 284 */     if (pageMld.isMutex()) {
/* 285 */       s = s + "\n\n" + getAllReference(pageMld);
/*     */     }
/* 287 */     if (!Principale.isActiverJMerise()) {
/* 288 */       s = SQLOutil.getCentLignes(s);
/*     */     }
/* 290 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static String getSQLNomTable(MLDEntite2 ent)
/*     */   {
/* 297 */     String st = "";String s = "";
/* 298 */     if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 299 */       s = SQLOutil.remplaceChar(Setting.developpeur);
/* 300 */       s = s.toUpperCase();
/*     */     }
/* 302 */     if (Setting.SQLUtiliserCode) {
/* 303 */       st = SQLOutil.remplaceChar(ent.getCode());
/*     */     } else {
/* 305 */       st = SQLOutil.remplaceChar(ent.getNom());
/*     */     }
/* 307 */     if (s.length() == 0) s = st; else
/* 308 */       s = s + "_" + st;
/* 309 */     return s;
/*     */   }
/*     */   
/*     */   private static String getNomAttribut(Attribut2 att) {
/* 313 */     if (Setting.SQLUtiliserCode) return SQLOutil.remplaceChar(att.getCode());
/* 314 */     return SQLOutil.remplaceChar(att.getNom());
/*     */   }
/*     */   
/*     */   private static String getUneContrainteFK(TableReference tab, String num) {
/* 318 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 319 */     String att = "";String attRef = "";
/*     */     
/* 321 */     for (int i = 0; i < liste.size(); i++) {
/* 322 */       if (att.length() == 0) {
/* 323 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 324 */         attRef = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */       else {
/* 327 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 328 */         attRef = attRef + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */     }
/* 331 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 332 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 333 */     String nomCnt = "";
/* 334 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "FK_" + nomTab + "_" + nomTabRef + num; else {
/* 335 */       nomCnt = nomTab + "_" + nomTabRef + num + "_FK";
/*     */     }
/* 337 */     String s = "\nALTER TABLE " + nomTab + "\n\tADD CONSTRAINT " + nomCnt + "\n\tFOREIGN KEY (" + att + ")" + "\n\tREFERENCES " + nomTabRef + "(" + attRef + ");\n";
/*     */     
/* 339 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContrainteFK(MLDEntite2 ent) {
/* 343 */     String s = "";
/* 344 */     for (int i = 0; i < ent.getListeCNTForeingKey().size(); i++) {
/* 345 */       s = s + getUneContrainteFK((TableReference)ent.getListeCNTForeingKey().get(i), new StringBuilder().append(i).append("").toString());
/*     */     }
/* 347 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteAK(TableReference tab, String num) {
/* 351 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 352 */     String att = "";
/*     */     
/* 354 */     for (int i = 0; i < liste.size(); i++) {
/* 355 */       if (att.length() == 0) {
/* 356 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */       else
/*     */       {
/* 360 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */     }
/* 363 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 364 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 365 */     String nomCnt = "";
/* 366 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "AK_" + nomTab + "_" + nomTabRef + num; else {
/* 367 */       nomCnt = nomTab + "_" + nomTabRef + num + "_AK";
/*     */     }
/* 369 */     String s = "\nALTER TABLE " + nomTab + " \n\tADD CONSTRAINT " + nomCnt + " \n\tUNIQUE (" + att + ");\n";
/*     */     
/* 371 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContrainteAK(MLDEntite2 ent) {
/* 375 */     String s = "";
/* 376 */     for (int i = 0; i < ent.getListeCNTALTERNATIVEKEY().size(); i++) {
/* 377 */       s = s + getUneContrainteAK((TableReference)ent.getListeCNTALTERNATIVEKEY().get(i), new StringBuilder().append(i).append("").toString());
/*     */     }
/* 379 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllContraintesEntite(MLDEntite2 ent) {
/* 383 */     String s = "";
/* 384 */     s = getAllContrainteFK(ent);
/* 385 */     s = s + getAllContrainteAK(ent);
/* 386 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllReference(IhmPageMLD page) {
/* 390 */     String s = "";
/*     */     
/* 392 */     for (int i = 0; i < page.getListeMLDEntite().size(); i++) {
/* 393 */       s = s + getAllContraintesEntite((MLDEntite2)page.getListeMLDEntite().get(i));
/*     */     }
/* 395 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteFK_Interne(TableReference tab, String num)
/*     */   {
/* 400 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 401 */     String att = "";String attRef = "";
/*     */     
/* 403 */     for (int i = 0; i < liste.size(); i++) {
/* 404 */       if (att.length() == 0) {
/* 405 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 406 */         attRef = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */       else {
/* 409 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/* 410 */         attRef = attRef + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttributRef());
/*     */       }
/*     */     }
/* 413 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 414 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 415 */     String nomCnt = "";
/* 416 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "FK_" + nomTab + "_" + nomTabRef + num; else {
/* 417 */       nomCnt = nomTab + "_" + nomTabRef + num + "_FK";
/*     */     }
/* 419 */     String s = "\n\t,CONSTRAINT " + nomCnt + " FOREIGN KEY (" + att + ")" + " REFERENCES " + nomTabRef + "(" + attRef + ")";
/*     */     
/* 421 */     return s;
/*     */   }
/*     */   
/*     */   private static String getUneContrainteAK_Interne(TableReference tab, String num)
/*     */   {
/* 426 */     ArrayList<AttributReference> liste = tab.getListeAttributRef();
/* 427 */     String att = "";
/*     */     
/* 429 */     for (int i = 0; i < liste.size(); i++) {
/* 430 */       if (att.length() == 0) {
/* 431 */         att = getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */       else {
/* 434 */         att = att + "," + getNomAttribut((Attribut2)((AttributReference)liste.get(i)).getAttribut());
/*     */       }
/*     */     }
/* 437 */     String nomTab = getSQLNomTable(tab.getEntite());
/* 438 */     String nomTabRef = getSQLNomTable(tab.getEntiteRef());
/* 439 */     String nomCnt = "";
/* 440 */     if (Setting.SQLPrefixerLeNomContrainte2) nomCnt = "AK_" + nomTab + "_" + nomTabRef + num; else {
/* 441 */       nomCnt = nomTab + "_" + nomTabRef + num + "_AK";
/*     */     }
/* 443 */     String s = "\n\t,CONSTRAINT " + nomCnt + " UNIQUE (" + att + ")";
/*     */     
/* 445 */     return s;
/*     */   }
/*     */   
/*     */   private static String getAllcontrainteEntite(MLDEntite2 ent) {
/* 449 */     String s = "";
/* 450 */     String nn = "";
/* 451 */     for (int i = 0; i < ent.getListeCNTForeingKey().size(); i++) {
/* 452 */       s = s + getUneContrainteFK_Interne((TableReference)ent.getListeCNTForeingKey().get(i), nn);
/* 453 */       nn = i + "";
/*     */     }
/* 455 */     if (s.length() > 0) s = "\n" + s;
/* 456 */     nn = "";
/* 457 */     for (int i = 0; i < ent.getListeCNTALTERNATIVEKEY().size(); i++) {
/* 458 */       s = s + getUneContrainteAK_Interne((TableReference)ent.getListeCNTALTERNATIVEKEY().get(i), nn);
/* 459 */       nn = i + "";
/*     */     }
/* 461 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ArrayList<String> creerListeTable(String script)
/*     */   {
/* 469 */     ArrayList<String> listeTable = new ArrayList();
/*     */     
/* 471 */     String f = "";String d = " ";String table = "";
/*     */     
/*     */ 
/* 474 */     int index = -1;
/* 475 */     String scriptALTER; String scriptCREATE; if (script.toUpperCase().indexOf("ALTER") > -1) {
/* 476 */       scriptCREATE = script.substring(0, script.toUpperCase().indexOf("ALTER"));
/* 477 */       scriptALTER = script.substring(script.toUpperCase().indexOf("ALTER"), script.length());
/*     */     } else {
/* 479 */       scriptCREATE = script.substring(0, script.length());
/* 480 */       scriptALTER = "";
/*     */     }
/* 482 */     index = scriptCREATE.toUpperCase().indexOf("CREATE");
/* 483 */     scriptCREATE = scriptCREATE.substring(index);
/*     */     
/* 485 */     if (index > -1) {
/* 486 */       while (index > -1) {
/* 487 */         d = scriptCREATE.substring(0, scriptCREATE.toUpperCase().indexOf(";") + 1);
/* 488 */         scriptCREATE = scriptCREATE.substring(scriptCREATE.indexOf(";") + 1);
/* 489 */         listeTable.add(d);
/* 490 */         index = scriptCREATE.toUpperCase().indexOf("CREATE");
/*     */       }
/*     */     }
/*     */     
/* 494 */     index = scriptALTER.toUpperCase().indexOf("ALTER");
/*     */     
/* 496 */     if (index > -1) {
/* 497 */       scriptALTER = scriptALTER.substring(index);
/* 498 */       while (index > -1) {
/* 499 */         d = scriptALTER.substring(0, scriptALTER.toUpperCase().indexOf(";") + 1);
/* 500 */         scriptALTER = scriptALTER.substring(scriptALTER.indexOf(";") + 1);
/* 501 */         listeTable.add(d);
/* 502 */         index = scriptALTER.toUpperCase().indexOf("ALTER");
/*     */       }
/*     */     }
/*     */     
/* 506 */     return listeTable;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Output\SQLMySQL.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */