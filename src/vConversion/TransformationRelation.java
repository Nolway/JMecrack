/*      */ package vConversion;
/*      */ 
/*      */ import Contrainte.TableReference;
/*      */ import IhmMCD.IhmEntite;
/*      */ import IhmMCD.IhmEntiteRelation;
/*      */ import IhmMCD.IhmPageMCD;
/*      */ import IhmMCD2.ConfigurationMCD2;
/*      */ import IhmMCD2.IhmCardinalite;
/*      */ import IhmMCD2.IhmEntite2;
/*      */ import IhmMCD2.IhmLien2;
/*      */ import IhmMCD2.IhmPoint;
/*      */ import IhmMCD2.IhmRelation2;
/*      */ import IhmMLD2.MLDEntite2;
/*      */ import IhmMLD2.MLDLienEntite2;
/*      */ import IhmMLD2.MLDRelationLien;
/*      */ import Merise.Attribut;
/*      */ import Merise.Entite;
/*      */ import Merise.Relation;
/*      */ import Merise2.Attribut2;
/*      */ import Outil.Parametres;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TransformationRelation
/*      */ {
/*   31 */   public static ArrayList<MLDRelationLien> listeRelationLien = new ArrayList();
/*   32 */   public static ArrayList<MLDEntite2> listeMLDEntite = new ArrayList();
/*   33 */   public static ArrayList<MLDLienEntite2> listeMLDLien = new ArrayList();
/*   34 */   public static Map<IhmEntiteRelation, MLDEntite2> listeCorrespondance = new HashMap();
/*      */   public static IhmPageMCD pageMCD;
/*      */   
/*      */   private static void setProprieteMLDEntite(MLDEntite2 ent, IhmRelation2 e)
/*      */   {
/*   39 */     ent.setClDegradee(e.isClDegradee());
/*      */     
/*   41 */     ent.setVariable(pageMCD.getConfigurationMCD().afficheType2);
/*   42 */     ent.setClAttributSelect(e.getClAttributSelect());
/*   43 */     ent.setClCadre2(e.getClCadre2());
/*   44 */     ent.setClCadreTitre2(e.getClCadreTitre2());
/*   45 */     ent.setClFond2(e.getClFond2());
/*   46 */     ent.setClFondTitre2(e.getClFondTitre2());
/*   47 */     ent.setClPrk(e.getClFondTitre2());
/*   48 */     ent.setClLienActiver(e.getClLienActiver());
/*   49 */     ent.setClOmbre(e.getClOmbre());
/*      */     
/*   51 */     ent.setClSelected(e.getClSelected());
/*   52 */     ent.setClText2(e.getClText2());
/*   53 */     ent.setClTextTaille2(e.getClTextTaille2());
/*   54 */     ent.setClTextTailleDec2(e.getClTextTailleDec2());
/*      */     
/*   56 */     ent.setClTextTitre2(e.getClTextTitre2());
/*   57 */     ent.setClTextType2(e.getClTextType2());
/*   58 */     ent.setArrondir(pageMCD.getConfigurationMCD().arrondirEntite2);
/*   59 */     ent.setAttEspace(e.getAttEspace());
/*   60 */     ent.setAttMajuscule(e.isAttMajuscule());
/*   61 */     ent.setEpaisseur(e.getEpaisseur());
/*   62 */     ent.setOmbre(e.isOmbre());
/*   63 */     ent.setPrkvisible(e.isPrkvisible());
/*   64 */     ent.setPrkImage(pageMCD.getConfigurationMCD().afficherPrkImage2);
/*      */   }
/*      */   
/*      */   private static void setForingKeyListAttribut(ArrayList<Attribut> listeAttributs)
/*      */   {
/*   69 */     for (int i = 0; i < listeAttributs.size(); i++) {
/*   70 */       Attribut2 att = (Attribut2)listeAttributs.get(i);
/*   71 */       att.setKey(Parametres.CleEtr);
/*   72 */       if (att.getType().toUpperCase().equals("AUTO_INCREMENT")) {
/*   73 */         att.setType("Int");
/*   74 */         att.setLongueur(11);
/*   75 */         att.setLongDecimale(-1);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private static void setPrimaryAndForingKeyListAttribut(ArrayList<Attribut> listeAttributs, boolean isnull)
/*      */   {
/*   83 */     for (int i = 0; i < listeAttributs.size(); i++) {
/*   84 */       Attribut2 att = (Attribut2)listeAttributs.get(i);
/*   85 */       att.setKey(Parametres.Cle);
/*   86 */       att.setForeingKey(true);
/*   87 */       if (att.getType().toUpperCase().equals("AUTO_INCREMENT")) {
/*   88 */         att.setType("Int");
/*   89 */         att.setLongueur(11);
/*   90 */         att.setLongDecimale(-1);
/*      */       }
/*   92 */       att.setNulle(isnull);
/*      */     }
/*      */   }
/*      */   
/*      */   private static ArrayList<Attribut> copierListAttribut(ArrayList<Attribut> listeAttributs) {
/*   97 */     ArrayList<Attribut> liste = new ArrayList();
/*      */     
/*   99 */     for (int i = 0; i < listeAttributs.size(); i++) {
/*  100 */       Attribut2 att = (Attribut2)listeAttributs.get(i);
/*      */       
/*  102 */       att = (Attribut2)att.copier();
/*      */       
/*  104 */       liste.add(att);
/*      */     }
/*  106 */     return liste;
/*      */   }
/*      */   
/*      */   private static ArrayList<Attribut> copierListAttributCle(MLDEntite2 mld, MLDEntite2 mldRef, MLDRelationLien rel, IhmLien2 lien, ArrayList<Attribut> listeAttributs, boolean unique) {
/*  110 */     ArrayList<Attribut> liste = new ArrayList();
/*      */     
/*      */ 
/*  113 */     TableReference tabFK = new TableReference(mldRef.getNom(), "FOREING KEY");
/*  114 */     tabFK.setEntite(mld);
/*  115 */     tabFK.setEntiteRef(mldRef);
/*  116 */     tabFK.setOrigine("RELATION");
/*      */     
/*  118 */     TableReference tabAK = new TableReference(mldRef.getNom(), "UNIQUE");
/*  119 */     if (unique)
/*      */     {
/*  121 */       tabAK.setOrigine("RELATION");
/*  122 */       tabAK.setEntite(mld);
/*  123 */       tabAK.setEntiteRef(mldRef);
/*  124 */       mld.addContrainteAK_UNIQUE(tabAK);
/*      */     }
/*  126 */     mld.addContrainteFK(tabFK);
/*      */     
/*  128 */     for (int i = 0; i < listeAttributs.size(); i++) {
/*  129 */       Attribut2 att = (Attribut2)listeAttributs.get(i);
/*  130 */       att = (Attribut2)att.copier();
/*  131 */       tabFK.addReference(att, (Attribut)listeAttributs.get(i));
/*  132 */       if (unique) {
/*  133 */         tabAK.addReference(att, (Attribut)listeAttributs.get(i));
/*      */       }
/*  135 */       liste.add(att);
/*  136 */       att.setAugmentation(mldRef.getNom() + "¤" + lien.getNom() + "¤" + rel.getRelation().getRelation().getNom());
/*      */     }
/*  138 */     return liste;
/*      */   }
/*      */   
/*      */   private static ArrayList<Attribut> copierListAttributCle(MLDEntite2 mld, MLDEntite2 mldRef, MLDRelationLien rel, IhmLien2 lien, ArrayList<Attribut> listeAttributs, int min, int max, boolean unique) {
/*  142 */     ArrayList<Attribut> liste = new ArrayList();
/*      */     
/*      */ 
/*  145 */     int nb = 2;
/*  146 */     String nbC = "";
/*      */     
/*      */ 
/*  149 */     TableReference tabFK = new TableReference(mldRef.getNom(), "FOREING KEY");
/*  150 */     tabFK.setEntite(mld);
/*  151 */     tabFK.setEntiteRef(mldRef);
/*  152 */     tabFK.setOrigine("RELATION");
/*  153 */     TableReference tabAK = new TableReference(mldRef.getNom(), "UNIQUE");
/*      */     
/*  155 */     if (unique)
/*      */     {
/*  157 */       tabAK.setOrigine("RELATION");
/*  158 */       tabAK.setEntite(mld);
/*  159 */       tabAK.setEntiteRef(mldRef);
/*  160 */       mld.addContrainteAK_UNIQUE(tabAK);
/*      */     }
/*  162 */     mld.addContrainteFK(tabFK);
/*      */     
/*  164 */     for (int j = 0; j < max; j++)
/*      */     {
/*  166 */       for (int i = 0; i < listeAttributs.size(); i++) {
/*  167 */         Attribut2 att1 = (Attribut2)listeAttributs.get(i);
/*      */         
/*  169 */         Attribut2 att = (Attribut2)att1.copier();
/*  170 */         att.setNom(att.getNom() + nbC);
/*  171 */         att.setCode((att.getCode() + nbC).toUpperCase());
/*  172 */         att.setNulle(true);
/*  173 */         if (j < min) {
/*  174 */           att.setNulle(false);
/*      */         }
/*      */         
/*      */ 
/*  178 */         tabFK.addReference(att, (Attribut)listeAttributs.get(i));
/*  179 */         if (unique) {
/*  180 */           tabAK.addReference(att, (Attribut)listeAttributs.get(i));
/*      */         }
/*  182 */         liste.add(att);
/*  183 */         att.setAugmentation(mldRef.getNom() + "¤" + lien.getNom() + "¤" + rel.getRelation().getRelation().getNom());
/*      */       }
/*      */       
/*  186 */       nb = j + 2;
/*  187 */       nbC = "_" + nb;
/*      */     }
/*  189 */     return liste;
/*      */   }
/*      */   
/*      */   private static String getNomEntiteLien(String nom) {
/*  193 */     String n = "";
/*  194 */     n = nom.substring(0, nom.indexOf("¤"));
/*  195 */     return n;
/*      */   }
/*      */   
/*      */   private static String getNomLien(String nom) {
/*  199 */     String n = "";
/*  200 */     n = nom.substring(nom.indexOf("¤") + 1, nom.length());
/*  201 */     n = n.substring(0, n.indexOf("¤"));
/*  202 */     return n;
/*      */   }
/*      */   
/*      */   private static String getNomRelationLien(String nom) {
/*  206 */     String n = "";
/*  207 */     n = nom.substring(nom.indexOf("¤") + 1, nom.length());
/*  208 */     n = n.substring(n.indexOf("¤") + 1, n.length());
/*      */     
/*  210 */     return n;
/*      */   }
/*      */   
/*      */   public static void getListeAttributCle(ArrayList<Attribut> listeKey, ArrayList<Attribut> listeAtt)
/*      */   {
/*  215 */     for (int i = 0; i < listeAtt.size(); i++) {
/*  216 */       Attribut2 att = (Attribut2)listeAtt.get(i);
/*  217 */       if (att.getListeAttributs().size() == 0) {
/*  218 */         if ((att.getKey().equals(Parametres.Cle)) && 
/*  219 */           (!((Attribut2)listeAtt.get(i)).isForeingKey())) listeKey.add(listeAtt.get(i));
/*      */       }
/*      */       else {
/*  222 */         getListeAttributCle(listeKey, att.getListeAttributs());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static void getListeAttributNonCle(ArrayList<Attribut> listeKey, ArrayList<Attribut> listeAtt)
/*      */   {
/*  229 */     for (int i = 0; i < listeAtt.size(); i++) {
/*  230 */       Attribut2 att = (Attribut2)listeAtt.get(i);
/*  231 */       if (att.getListeAttributs().size() == 0) {
/*  232 */         if ((!att.getKey().equals(Parametres.Cle)) && 
/*  233 */           (!((Attribut2)listeAtt.get(i)).isForeingKey())) listeKey.add(listeAtt.get(i));
/*      */       }
/*      */       else {
/*  236 */         getListeAttributCle(listeKey, att.getListeAttributs());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private static void ajouterPointDecassureReflexive(MLDLienEntite2 l, IhmEntite2 ent)
/*      */   {
/*  244 */     int x = ent.getCentreX() - ent.getWidth();
/*  245 */     int y = ent.getCentreY();
/*      */     
/*  247 */     if (x < 0) x = 6;
/*  248 */     if (y < 0) y = 6;
/*  249 */     IhmPoint p = new IhmPoint(x, y);
/*  250 */     l.getPointCassure().add(p);
/*      */     
/*  252 */     y = ent.getCentreY() - ent.getHeight();
/*  253 */     if (y < 0) { y = 6;
/*      */     }
/*  255 */     p = new IhmPoint(x, y);
/*  256 */     l.getPointCassure().add(p);
/*      */   }
/*      */   
/*      */   private static void creerLienEtCleRelationTernaire(MLDRelationLien rel, MLDEntite2 mld)
/*      */   {
/*  261 */     String nom = "";
/*      */     
/*      */ 
/*      */ 
/*  265 */     ArrayList<Attribut> lK = new ArrayList();
/*  266 */     for (int i = 0; i < rel.getListLien().size(); i++) {
/*  267 */       lK.clear();
/*  268 */       IhmLien2 lien = (IhmLien2)rel.getListLien().get(i);
/*  269 */       MLDEntite2 ent = (MLDEntite2)listeCorrespondance.get(lien.getEntite());
/*  270 */       getListeAttributCle(lK, ent.getListeAttributs());
/*  271 */       lK = copierListAttributCle(mld, ent, rel, lien, lK, false);
/*      */       
/*  273 */       fusionListeAttributSansRedandonce(mld.getListeAttributs(), lK);
/*  274 */       MLDLienEntite2 li = new MLDLienEntite2(mld, ent);
/*  275 */       nom = nom = rel.getRelation().getRelation().getNom() + "_" + ent.getNom() + ":" + lien.getCardinalite();
/*      */       
/*  277 */       li.setNom(nom);
/*  278 */       li.setFleche(true);
/*  279 */       listeMLDLien.add(li);
/*  280 */       if (lien.getCardinalite().substring(0, 1).equals("0")) {
/*  281 */         setPrimaryAndForingKeyListAttribut(lK, true);
/*      */       } else {
/*  283 */         setPrimaryAndForingKeyListAttribut(lK, false);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static int getCardMax(MLDRelationLien rel, IhmLien2 lien)
/*      */   {
/*  292 */     if (rel.getCardinalite(lien).equals("11")) return 1;
/*  293 */     if (rel.getCardinalite(lien).equals("01")) return 1;
/*  294 */     String max = lien.getCardinalites().getMax();
/*  295 */     return Integer.parseInt(max);
/*      */   }
/*      */   
/*      */   private static int getCardMin(MLDRelationLien rel, IhmLien2 lien) {
/*  299 */     if (rel.getCardinalite(lien).equals("11")) return 1;
/*  300 */     if (rel.getCardinalite(lien).equals("01")) return 0;
/*  301 */     String min = lien.getCardinalites().getMin();
/*  302 */     return Integer.parseInt(min);
/*      */   }
/*      */   
/*      */   private static boolean possibleFusiondirect(ArrayList<Attribut> liste, ArrayList<Attribut> liste2) {
/*  306 */     for (int i = 0; i < liste2.size(); i++) {
/*  307 */       if (existeAttributDansListe(liste, ((Attribut)liste2.get(i)).getNom())) return false;
/*      */     }
/*  309 */     return true;
/*      */   }
/*      */   
/*      */   private static void fusionListeAttributSansRedandonceDirect(ArrayList<Attribut> liste, ArrayList<Attribut> listeA) {
/*  313 */     for (int i = 0; i < listeA.size(); i++) {
/*  314 */       liste.add(listeA.get(i));
/*      */     }
/*      */   }
/*      */   
/*      */   private static boolean existeAttributDansListe(ArrayList<Attribut> liste, String nomAtt)
/*      */   {
/*  320 */     nomAtt = nomAtt.trim().toUpperCase();
/*  321 */     for (int i = 0; i < liste.size(); i++) {
/*  322 */       String n = ((Attribut)liste.get(i)).getNom().trim().toUpperCase();
/*  323 */       if (nomAtt.equals(n)) return true;
/*      */     }
/*  325 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   private static void fusionListeAttributSansRedandonce(ArrayList<Attribut> liste, ArrayList<Attribut> listeA)
/*      */   {
/*  331 */     int nb = 1;
/*      */     
/*      */ 
/*  334 */     if (possibleFusiondirect(liste, listeA)) {
/*  335 */       fusionListeAttributSansRedandonceDirect(liste, listeA);
/*  336 */       return;
/*      */     }
/*      */     
/*  339 */     for (int i = 0; i < listeA.size(); i++) {
/*  340 */       Attribut2 att = (Attribut2)listeA.get(i);
/*  341 */       String nom = att.getNom();
/*  342 */       String n = nom;
/*  343 */       String c = att.getCode();
/*  344 */       if (!nom.trim().toUpperCase().contains(getNomEntiteLien(att.getAugmentation()).trim().toUpperCase())) {
/*  345 */         nom = nom + (getNomEntiteLien(att.getAugmentation()).length() > 0 ? "_" + getNomEntiteLien(att.getAugmentation()) : "");
/*  346 */         c = c + (getNomEntiteLien(att.getAugmentation()).length() > 0 ? "_" + getNomEntiteLien(att.getAugmentation()) : "");
/*      */       }
/*  348 */       if (existeAttributDansListe(liste, nom)) {
/*  349 */         nom = nom + (getNomLien(att.getAugmentation()).length() > 0 ? "_" + getNomLien(att.getAugmentation()) : "");
/*  350 */         if (existeAttributDansListe(liste, nom)) {
/*  351 */           nom = nom + (getNomRelationLien(att.getAugmentation()).length() > 0 ? "_" + getNomRelationLien(att.getAugmentation()) : "");
/*      */           
/*  353 */           if (existeAttributDansListe(liste, nom)) {
/*  354 */             while (existeAttributDansListe(liste, nom)) {
/*  355 */               nom = nom + "_" + nb;
/*      */               
/*  357 */               nb++;
/*      */             }
/*  359 */             att.setNom(nom);
/*  360 */             nom = nom.substring(n.length(), nom.length());
/*  361 */             att.setCode((att.getCode() + nom).toUpperCase());
/*  362 */             liste.add(att);
/*      */           } else {
/*  364 */             att.setNom(nom);
/*  365 */             nom = nom.substring(n.length(), nom.length());
/*  366 */             att.setCode((att.getCode() + nom).toUpperCase());
/*  367 */             liste.add(att);
/*      */           }
/*      */         } else {
/*  370 */           att.setNom(nom);
/*  371 */           nom = nom.substring(n.length(), nom.length());
/*  372 */           att.setCode((att.getCode() + nom).toUpperCase());
/*  373 */           liste.add(att);
/*      */         }
/*      */       } else {
/*  376 */         att.setNom(nom);
/*  377 */         att.setCode(c.toUpperCase());
/*  378 */         liste.add(att);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static void fusionListeAttributNonCle(ArrayList<Attribut> liste, ArrayList<Attribut> listeA, String nomRel)
/*      */   {
/*  387 */     int nb = 2;
/*  388 */     for (int i = 0; i < listeA.size(); i++) {
/*  389 */       Attribut2 att = (Attribut2)listeA.get(i);
/*  390 */       String nom = att.getNom();
/*  391 */       String c = att.getCode();
/*  392 */       if (existeAttributDansListe(liste, nom)) {
/*  393 */         nom = nom + "_" + nomRel;
/*  394 */         c = c + "_" + nomRel;
/*  395 */         while (existeAttributDansListe(liste, nom)) {
/*  396 */           nom = nom + nb;
/*  397 */           c = c + nb;
/*  398 */           nb++;
/*      */         }
/*      */       }
/*  401 */       att.setNom(nom);
/*  402 */       att.setCode(c.toUpperCase());
/*  403 */       liste.add(att);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean transformerRelationGroupe0(MLDRelationLien rel)
/*      */   {
/*  413 */     if (rel.isIsRelatif()) {
/*  414 */       if (rel.getRelation().getRelation().getListeAttributs().size() > 0) {
/*  415 */         IhmLien2 lien1; if (((IhmLien2)rel.getListLien().get(0)).isRelatif()) {
/*  416 */           lien1 = (IhmLien2)rel.getListLien().get(0);
/*      */         }
/*      */         else {
/*  419 */           lien1 = (IhmLien2)rel.getListLien().get(1);
/*      */         }
/*      */         
/*  422 */         MLDEntite2 ent1 = (MLDEntite2)listeCorrespondance.get(lien1.getEntite());
/*  423 */         ArrayList<Attribut> lA = new ArrayList();
/*  424 */         getListeAttributNonCle(lA, rel.getRelation().getRelation().getListeAttributs());
/*  425 */         lA = copierListAttribut(lA);
/*  426 */         fusionListeAttributNonCle(ent1.getListeAttributs(), lA, rel.getRelation().getRelation().getNom());
/*      */       }
/*  428 */       return true;
/*      */     }
/*  430 */     if (rel.getTypeRelation() == MLDRelationLien.RELATION_TERNAIRE) {
/*  431 */       MLDEntite2 mld = new MLDEntite2(rel.getRelation().getRelation().getNom(), rel.getRelation().getX(), rel.getRelation().getY(), 0, 0, true);
/*  432 */       mld.setCode(rel.getRelation().getRelation().getNom().trim().toUpperCase());
/*  433 */       mld.setCommentaire(rel.getRelation().getRelation().getCommentaire());
/*  434 */       mld.setTypeEntite("RELATION");
/*      */       
/*  436 */       setProprieteMLDEntite(mld, rel.getRelation());
/*  437 */       ArrayList<Attribut> lA = new ArrayList();
/*  438 */       getListeAttributNonCle(lA, rel.getRelation().getRelation().getListeAttributs());
/*  439 */       lA = copierListAttribut(lA);
/*  440 */       mld.setListeAttributs(lA);
/*  441 */       creerLienEtCleRelationTernaire(rel, mld);
/*  442 */       listeMLDEntite.add(mld);
/*  443 */       return true;
/*      */     }
/*      */     
/*  446 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean transformerRelationGroupe1(MLDRelationLien rel)
/*      */   {
/*  456 */     boolean isnull = false;
/*  457 */     if (rel.getGroupeRelation() == MLDRelationLien.GROUPE_UN) {
/*  458 */       IhmLien2 lien1 = (IhmLien2)rel.getListLien().get(1);
/*  459 */       IhmLien2 lien2 = (IhmLien2)rel.getListLien().get(0);
/*      */       
/*  461 */       if (rel.getCardinalite(lien1).contains("0")) isnull = true;
/*  462 */       MLDEntite2 ent1 = (MLDEntite2)listeCorrespondance.get(lien1.getEntite());
/*  463 */       MLDEntite2 ent2 = (MLDEntite2)listeCorrespondance.get(lien2.getEntite());
/*      */       
/*  465 */       MLDEntite2 mld = new MLDEntite2(rel.getRelation().getRelation().getNom(), rel.getRelation().getX(), rel.getRelation().getY(), 0, 0, true);
/*  466 */       mld.setCode(rel.getRelation().getRelation().getNom().trim().toUpperCase());
/*  467 */       mld.setCommentaire(rel.getRelation().getRelation().getCommentaire());
/*  468 */       mld.setTypeEntite("RELATION");
/*      */       
/*  470 */       setProprieteMLDEntite(mld, rel.getRelation());
/*  471 */       ArrayList<Attribut> lA = new ArrayList();
/*  472 */       getListeAttributNonCle(lA, rel.getRelation().getRelation().getListeAttributs());
/*  473 */       lA = copierListAttribut(lA);
/*  474 */       mld.setListeAttributs(lA);
/*      */       
/*  476 */       ArrayList<Attribut> lK = new ArrayList();
/*  477 */       getListeAttributCle(lK, ent1.getListeAttributs());
/*  478 */       lK = copierListAttributCle(mld, ent1, rel, lien1, lK, false);
/*  479 */       fusionListeAttributSansRedandonce(mld.getListeAttributs(), lK);
/*  480 */       setPrimaryAndForingKeyListAttribut(lK, isnull);
/*      */       
/*  482 */       lK.clear();
/*  483 */       if (rel.getCardinalite(lien2).contains("0")) isnull = true;
/*  484 */       getListeAttributCle(lK, ent2.getListeAttributs());
/*  485 */       lK = copierListAttributCle(mld, ent2, rel, lien2, lK, false);
/*  486 */       fusionListeAttributSansRedandonce(mld.getListeAttributs(), lK);
/*  487 */       setPrimaryAndForingKeyListAttribut(lK, isnull);
/*      */       
/*  489 */       listeMLDEntite.add(mld);
/*      */       
/*  491 */       MLDLienEntite2 li = new MLDLienEntite2(mld, ent2);
/*  492 */       String nom = rel.getRelation().getRelation().getNom() + "_" + ent2.getNom() + ":" + lien2.getCardinalite();
/*      */       
/*  494 */       li.setNom(nom);
/*  495 */       li.setFleche(true);
/*  496 */       listeMLDLien.add(li);
/*  497 */       li = new MLDLienEntite2(mld, ent1);
/*  498 */       nom = rel.getRelation().getRelation().getNom() + "_" + ent1.getNom() + ":" + lien1.getCardinalite();
/*  499 */       li.setNom(nom);
/*  500 */       li.setFleche(true);
/*  501 */       listeMLDLien.add(li);
/*  502 */       return true;
/*      */     }
/*  504 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean transformerRelationGroupe2(MLDRelationLien rel)
/*      */   {
/*  514 */     boolean isnull = false;
/*  515 */     if (rel.getGroupeRelation() == MLDRelationLien.GROUPE_DEUX) {
/*  516 */       IhmLien2 lien1 = (IhmLien2)rel.getListLien().get(1);
/*  517 */       IhmLien2 lien2 = (IhmLien2)rel.getListLien().get(0);
/*      */       
/*  519 */       if (rel.getCardinalite(lien1).contains("0")) isnull = true;
/*  520 */       MLDEntite2 ent1 = (MLDEntite2)listeCorrespondance.get(lien1.getEntite());
/*  521 */       MLDEntite2 ent2 = (MLDEntite2)listeCorrespondance.get(lien2.getEntite());
/*      */       
/*  523 */       MLDEntite2 mld = new MLDEntite2(rel.getRelation().getRelation().getNom(), rel.getRelation().getX(), rel.getRelation().getY(), 0, 0, true);
/*  524 */       mld.setCode(rel.getRelation().getRelation().getNom().trim().toUpperCase());
/*  525 */       mld.setCommentaire(rel.getRelation().getRelation().getCommentaire());
/*  526 */       mld.setTypeEntite("RELATION");
/*      */       
/*  528 */       setProprieteMLDEntite(mld, rel.getRelation());
/*  529 */       ArrayList<Attribut> lA = new ArrayList();
/*  530 */       getListeAttributNonCle(lA, rel.getRelation().getRelation().getListeAttributs());
/*  531 */       lA = copierListAttribut(lA);
/*  532 */       mld.setListeAttributs(lA);
/*      */       
/*  534 */       ArrayList<Attribut> lK = new ArrayList();
/*  535 */       getListeAttributCle(lK, ent1.getListeAttributs());
/*  536 */       lK = copierListAttributCle(mld, ent1, rel, lien1, lK, false);
/*  537 */       fusionListeAttributSansRedandonce(mld.getListeAttributs(), lK);
/*  538 */       setPrimaryAndForingKeyListAttribut(lK, isnull);
/*      */       
/*  540 */       lK.clear();
/*  541 */       if (rel.getCardinalite(lien2).contains("0")) isnull = true;
/*  542 */       getListeAttributCle(lK, ent2.getListeAttributs());
/*  543 */       lK = copierListAttributCle(mld, ent2, rel, lien2, lK, false);
/*  544 */       fusionListeAttributSansRedandonce(mld.getListeAttributs(), lK);
/*  545 */       setPrimaryAndForingKeyListAttribut(lK, isnull);
/*      */       
/*  547 */       listeMLDEntite.add(mld);
/*      */       
/*  549 */       MLDLienEntite2 li = new MLDLienEntite2(mld, ent2);
/*  550 */       String nom = rel.getRelation().getRelation().getNom() + "_" + ent2.getNom() + ":" + lien2.getCardinalite();
/*      */       
/*  552 */       li.setNom(nom);
/*  553 */       li.setFleche(true);
/*  554 */       listeMLDLien.add(li);
/*  555 */       li = new MLDLienEntite2(mld, ent1);
/*  556 */       nom = rel.getRelation().getRelation().getNom() + "_" + ent1.getNom() + ":" + lien1.getCardinalite();
/*  557 */       li.setNom(nom);
/*  558 */       li.setFleche(true);
/*  559 */       listeMLDLien.add(li);
/*  560 */       return true;
/*      */     }
/*  562 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean transformerRelationGroupe3(MLDRelationLien rel)
/*      */   {
/*  571 */     boolean car1101 = false;
/*  572 */     if (rel.getGroupeRelation() == MLDRelationLien.GROUPE_TROIS) {
/*  573 */       IhmLien2 lien1 = (IhmLien2)rel.getListLien().get(0);
/*  574 */       IhmLien2 lien2 = (IhmLien2)rel.getListLien().get(1);
/*      */       
/*  576 */       if ((rel.getCardinalite(lien1).equals("11")) || (rel.getCardinalite(lien2).equals("11"))) {
/*  577 */         if (rel.getCardinalite(lien2).equals("11")) {
/*  578 */           lien1 = (IhmLien2)rel.getListLien().get(1);
/*  579 */           lien2 = (IhmLien2)rel.getListLien().get(0);
/*      */           
/*  581 */           if (rel.getCardinalite(lien2).equals("01")) {
/*  582 */             car1101 = true;
/*      */           }
/*  584 */         } else if (rel.getCardinalite(lien2).equals("01")) {
/*  585 */           car1101 = true;
/*      */         }
/*      */       }
/*  588 */       else if ((rel.getCardinalite(lien1).equals("1Y")) || (rel.getCardinalite(lien2).equals("1Y"))) {
/*  589 */         if (rel.getCardinalite(lien2).equals("1Y")) {
/*  590 */           lien1 = (IhmLien2)rel.getListLien().get(1);
/*  591 */           lien2 = (IhmLien2)rel.getListLien().get(0);
/*      */         }
/*      */       }
/*  594 */       else if (((rel.getCardinalite(lien1).equals("XY")) || (rel.getCardinalite(lien2).equals("XY"))) && 
/*  595 */         (rel.getCardinalite(lien2).equals("XY"))) {
/*  596 */         lien1 = (IhmLien2)rel.getListLien().get(1);
/*  597 */         lien2 = (IhmLien2)rel.getListLien().get(0);
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  603 */       MLDEntite2 ent1 = (MLDEntite2)listeCorrespondance.get(lien1.getEntite());
/*  604 */       MLDEntite2 ent2 = (MLDEntite2)listeCorrespondance.get(lien2.getEntite());
/*      */       
/*  606 */       ArrayList<Attribut> lA = new ArrayList();
/*  607 */       getListeAttributNonCle(lA, rel.getRelation().getRelation().getListeAttributs());
/*  608 */       lA = copierListAttribut(lA);
/*  609 */       fusionListeAttributNonCle(ent1.getListeAttributs(), lA, rel.getRelation().getRelation().getNom());
/*      */       
/*  611 */       int min = getCardMin(rel, lien1);
/*  612 */       int max = getCardMax(rel, lien1);
/*  613 */       ArrayList<Attribut> lK = new ArrayList();
/*  614 */       getListeAttributCle(lK, ent2.getListeAttributs());
/*  615 */       lK = copierListAttributCle(ent1, ent2, rel, lien1, lK, min, max, car1101);
/*  616 */       setForingKeyListAttribut(lK);
/*  617 */       fusionListeAttributSansRedandonce(ent1.getListeAttributs(), lK);
/*      */       
/*  619 */       MLDLienEntite2 li = new MLDLienEntite2(ent1, ent2);
/*  620 */       String nom = rel.getRelation().getRelation().getNom() + ":" + lien1.getCardinalite();
/*  621 */       li.setFleche(true);
/*  622 */       li.setNom(nom);
/*  623 */       if (ent1 == ent2) ajouterPointDecassureReflexive(li, (IhmEntite2)lien1.getEntite());
/*  624 */       listeMLDLien.add(li);
/*  625 */       return true;
/*      */     }
/*  627 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean transformerRelationGroupe4(MLDRelationLien rel)
/*      */   {
/*  637 */     if (rel.getGroupeRelation() == MLDRelationLien.GROUPE_QUATRE) {
/*  638 */       IhmLien2 lien1 = (IhmLien2)rel.getListLien().get(0);
/*  639 */       IhmLien2 lien2 = (IhmLien2)rel.getListLien().get(1);
/*  640 */       if ((rel.getCardinalite(lien1).equals("01")) || (rel.getCardinalite(lien2).equals("01"))) {
/*  641 */         if (rel.getCardinalite(lien2).equals("01")) {
/*  642 */           lien1 = (IhmLien2)rel.getListLien().get(1);
/*  643 */           lien2 = (IhmLien2)rel.getListLien().get(0);
/*      */         }
/*      */       }
/*  646 */       else if (((rel.getCardinalite(lien1).equals("0Y")) || (rel.getCardinalite(lien2).equals("0Y"))) && 
/*  647 */         (rel.getCardinalite(lien2).equals("0Y"))) {
/*  648 */         lien1 = (IhmLien2)rel.getListLien().get(1);
/*  649 */         lien2 = (IhmLien2)rel.getListLien().get(0);
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  654 */       if ((rel.getRelation().getDispatchKey().length() == 0) || (rel.getRelation().getDispatchKey().contains("<ACTION>" + MLDRelationLien.DISPARAITRE + "</ACTION>")))
/*      */       {
/*  656 */         MLDEntite2 ent1 = (MLDEntite2)listeCorrespondance.get(lien1.getEntite());
/*  657 */         MLDEntite2 ent2 = (MLDEntite2)listeCorrespondance.get(lien2.getEntite());
/*      */         
/*  659 */         ArrayList<Attribut> lA = new ArrayList();
/*  660 */         getListeAttributNonCle(lA, rel.getRelation().getRelation().getListeAttributs());
/*  661 */         lA = copierListAttribut(lA);
/*  662 */         fusionListeAttributNonCle(ent1.getListeAttributs(), lA, rel.getRelation().getRelation().getNom());
/*      */         
/*  664 */         int min = getCardMin(rel, lien1);
/*  665 */         int max = getCardMax(rel, lien1);
/*  666 */         ArrayList<Attribut> lK = new ArrayList();
/*  667 */         getListeAttributCle(lK, ent2.getListeAttributs());
/*  668 */         lK = copierListAttributCle(ent1, ent2, rel, lien1, lK, min, max, false);
/*  669 */         setForingKeyListAttribut(lK);
/*  670 */         fusionListeAttributSansRedandonce(ent1.getListeAttributs(), lK);
/*      */         
/*  672 */         MLDLienEntite2 li = new MLDLienEntite2(ent1, ent2);
/*  673 */         String nom = rel.getRelation().getRelation().getNom() + ":" + lien1.getCardinalite();
/*  674 */         li.setFleche(true);
/*  675 */         li.setNom(nom);
/*  676 */         if (ent1 == ent2) ajouterPointDecassureReflexive(li, (IhmEntite2)lien1.getEntite());
/*  677 */         listeMLDLien.add(li);
/*  678 */         return true;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  685 */       boolean isnull = false;
/*      */       
/*  687 */       if (rel.getCardinalite(lien1).contains("0")) isnull = true;
/*  688 */       MLDEntite2 ent1 = (MLDEntite2)listeCorrespondance.get(lien1.getEntite());
/*  689 */       MLDEntite2 ent2 = (MLDEntite2)listeCorrespondance.get(lien2.getEntite());
/*      */       
/*  691 */       MLDEntite2 mld = new MLDEntite2(rel.getRelation().getRelation().getNom(), rel.getRelation().getX(), rel.getRelation().getY(), 0, 0, true);
/*  692 */       mld.setCode(rel.getRelation().getRelation().getNom().trim().toUpperCase());
/*  693 */       mld.setCommentaire(rel.getRelation().getRelation().getCommentaire());
/*  694 */       mld.setTypeEntite("RELATION");
/*      */       
/*  696 */       setProprieteMLDEntite(mld, rel.getRelation());
/*  697 */       ArrayList<Attribut> lA = new ArrayList();
/*  698 */       getListeAttributNonCle(lA, rel.getRelation().getRelation().getListeAttributs());
/*  699 */       lA = copierListAttribut(lA);
/*  700 */       mld.setListeAttributs(lA);
/*      */       
/*  702 */       ArrayList<Attribut> lK = new ArrayList();
/*  703 */       getListeAttributCle(lK, ent1.getListeAttributs());
/*  704 */       lK = copierListAttributCle(mld, ent1, rel, lien1, lK, false);
/*  705 */       fusionListeAttributSansRedandonce(mld.getListeAttributs(), lK);
/*  706 */       setPrimaryAndForingKeyListAttribut(lK, isnull);
/*      */       
/*  708 */       lK.clear();
/*      */       
/*  710 */       int min = getCardMin(rel, lien1);
/*  711 */       int max = getCardMax(rel, lien1);
/*  712 */       lK = new ArrayList();
/*  713 */       getListeAttributCle(lK, ent2.getListeAttributs());
/*  714 */       lK = copierListAttributCle(mld, ent2, rel, lien1, lK, min, max, false);
/*  715 */       setForingKeyListAttribut(lK);
/*  716 */       fusionListeAttributSansRedandonce(mld.getListeAttributs(), lK);
/*      */       
/*      */ 
/*  719 */       listeMLDEntite.add(mld);
/*      */       
/*  721 */       MLDLienEntite2 li = new MLDLienEntite2(mld, ent2);
/*  722 */       String nom = rel.getRelation().getRelation().getNom() + "_" + ent2.getNom() + ":" + lien2.getCardinalite();
/*      */       
/*  724 */       li.setNom(nom);
/*  725 */       li.setFleche(true);
/*  726 */       listeMLDLien.add(li);
/*  727 */       li = new MLDLienEntite2(mld, ent1);
/*  728 */       nom = rel.getRelation().getRelation().getNom() + "_" + ent1.getNom() + ":" + lien1.getCardinalite();
/*  729 */       li.setNom(nom);
/*  730 */       li.setFleche(true);
/*  731 */       listeMLDLien.add(li);
/*      */       
/*  733 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  738 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean transformerRelationGroupe5(MLDRelationLien rel)
/*      */   {
/*  748 */     if (rel.getGroupeRelation() == MLDRelationLien.GROUPE_CINQ)
/*      */     {
/*  750 */       IhmLien2 lien1 = (IhmLien2)rel.getListLien().get(0);
/*  751 */       IhmLien2 lien2 = (IhmLien2)rel.getListLien().get(1);
/*      */       
/*  753 */       if (rel.getRelation().getDispatchKey().trim().length() == 0)
/*      */       {
/*  755 */         MLDEntite2 ent1 = (MLDEntite2)listeCorrespondance.get(lien1.getEntite());
/*  756 */         MLDEntite2 ent2 = (MLDEntite2)listeCorrespondance.get(lien2.getEntite());
/*  757 */         ArrayList<Attribut> lA = new ArrayList();
/*  758 */         getListeAttributNonCle(lA, rel.getRelation().getRelation().getListeAttributs());
/*  759 */         lA = copierListAttribut(lA);
/*      */         
/*  761 */         if (ent1 != ent2) {
/*  762 */           ArrayList<Attribut> lK1 = new ArrayList();
/*  763 */           ArrayList<Attribut> lK2 = new ArrayList();
/*      */           
/*  765 */           getListeAttributCle(lK1, ent1.getListeAttributs());
/*  766 */           getListeAttributCle(lK2, ent2.getListeAttributs());
/*      */           
/*  768 */           fusionListeAttributNonCle(ent1.getListeAttributs(), lA, rel.getRelation().getRelation().getNom());
/*  769 */           lA = copierListAttribut(lA);
/*  770 */           fusionListeAttributNonCle(ent2.getListeAttributs(), lA, rel.getRelation().getRelation().getNom());
/*      */           
/*  772 */           if (listeEgale(lK1, lK2)) {
/*  773 */             MLDLienEntite2 li = new MLDLienEntite2(ent1, ent2);
/*  774 */             String nom = rel.getRelation().getRelation().getNom() + "_" + ent1.getNom() + ":" + lien1.getCardinalite();
/*  775 */             li.setFleche(true);
/*  776 */             li.setNom(nom);
/*  777 */             li.setDiscontinue(true);
/*  778 */             listeMLDLien.add(li);
/*      */             
/*  780 */             li = new MLDLienEntite2(ent2, ent1);
/*  781 */             nom = rel.getRelation().getRelation().getNom() + "_" + ent2.getNom() + ":" + lien2.getCardinalite();
/*  782 */             li.setFleche(true);
/*  783 */             li.setNom(nom);
/*  784 */             li.setDiscontinue(true);
/*  785 */             listeMLDLien.add(li);
/*  786 */             return true;
/*      */           }
/*      */           
/*  789 */           lK1 = copierListAttributCle(ent2, ent1, rel, lien2, lK1, true);
/*  790 */           setForingKeyListAttribut(lK1);
/*  791 */           fusionListeAttributSansRedandonce(ent2.getListeAttributs(), lK1);
/*      */           
/*  793 */           lK2 = copierListAttributCle(ent1, ent2, rel, lien1, lK2, true);
/*  794 */           setForingKeyListAttribut(lK2);
/*  795 */           fusionListeAttributSansRedandonce(ent1.getListeAttributs(), lK2);
/*      */           
/*  797 */           MLDLienEntite2 li = new MLDLienEntite2(ent1, ent2);
/*  798 */           String nom = rel.getRelation().getRelation().getNom() + "_" + ent1.getNom() + ":" + lien1.getCardinalite();
/*  799 */           li.setFleche(true);
/*  800 */           li.setNom(nom);
/*      */           
/*  802 */           listeMLDLien.add(li);
/*      */           
/*  804 */           li = new MLDLienEntite2(ent2, ent1);
/*  805 */           nom = rel.getRelation().getRelation().getNom() + "_" + ent2.getNom() + ":" + lien2.getCardinalite();
/*  806 */           li.setFleche(true);
/*  807 */           li.setNom(nom);
/*      */           
/*  809 */           listeMLDLien.add(li);
/*  810 */           return true;
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*  815 */         fusionListeAttributNonCle(ent1.getListeAttributs(), lA, rel.getRelation().getRelation().getNom());
/*  816 */         ArrayList<Attribut> lK = new ArrayList();
/*  817 */         getListeAttributCle(lK, ent1.getListeAttributs());
/*  818 */         lK = copierListAttributCle(ent1, ent2, rel, lien1, lK, true);
/*  819 */         setForingKeyListAttribut(lK);
/*  820 */         fusionListeAttributSansRedandonce(ent1.getListeAttributs(), lK);
/*      */         
/*  822 */         MLDLienEntite2 li = new MLDLienEntite2(ent1, ent2);
/*  823 */         String nom = rel.getRelation().getRelation().getNom() + ":" + lien1.getCardinalite();
/*  824 */         li.setFleche(true);
/*  825 */         li.setNom(nom);
/*  826 */         ajouterPointDecassureReflexive(li, (IhmEntite2)lien1.getEntite());
/*  827 */         listeMLDLien.add(li);
/*  828 */         return true;
/*      */       }
/*      */       
/*      */ 
/*  832 */       if (rel.getRelation().getDispatchKey().contains("<ACTION>" + MLDRelationLien.DISPARAITRE + "</ACTION>")) {
/*  833 */         if ((rel.getRelation().getDispatchKey().contains("<ENTITE1></ENTITE1>")) && (rel.getRelation().getDispatchKey().contains("<ENTITE2></ENTITE2>")))
/*      */         {
/*  835 */           MLDEntite2 ent1 = (MLDEntite2)listeCorrespondance.get(lien1.getEntite());
/*  836 */           MLDEntite2 ent2 = (MLDEntite2)listeCorrespondance.get(lien2.getEntite());
/*  837 */           ArrayList<Attribut> lA = new ArrayList();
/*  838 */           getListeAttributNonCle(lA, rel.getRelation().getRelation().getListeAttributs());
/*  839 */           lA = copierListAttribut(lA);
/*  840 */           fusionListeAttributNonCle(ent1.getListeAttributs(), lA, rel.getRelation().getRelation().getNom());
/*      */           
/*  842 */           if (ent1 != ent2) {
/*  843 */             lA = copierListAttribut(lA);
/*  844 */             fusionListeAttributNonCle(ent2.getListeAttributs(), lA, rel.getRelation().getRelation().getNom());
/*      */             
/*  846 */             MLDLienEntite2 li = new MLDLienEntite2(ent1, ent2);
/*  847 */             String nom = rel.getRelation().getRelation().getNom() + "_" + ent1.getNom() + ":" + lien1.getCardinalite();
/*  848 */             li.setFleche(true);
/*  849 */             li.setNom(nom);
/*      */             
/*  851 */             listeMLDLien.add(li);
/*      */             
/*  853 */             li = new MLDLienEntite2(ent2, ent1);
/*  854 */             nom = rel.getRelation().getRelation().getNom() + "_" + ent2.getNom() + ":" + lien2.getCardinalite();
/*  855 */             li.setFleche(true);
/*  856 */             li.setNom(nom);
/*      */             
/*  858 */             listeMLDLien.add(li);
/*  859 */             return true;
/*      */           }
/*  861 */           MLDLienEntite2 li = new MLDLienEntite2(ent1, ent1);
/*  862 */           String nom = rel.getRelation().getRelation().getNom() + "_" + ":" + lien2.getCardinalite();
/*  863 */           li.setFleche(true);
/*  864 */           li.setNom(nom);
/*  865 */           li.setDiscontinue(true);
/*  866 */           listeMLDLien.add(li);
/*  867 */           return true;
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*  872 */         if (rel.getRelation().getDispatchKey().contains("<ENTITE2></ENTITE2>"))
/*      */         {
/*  874 */           if (rel.getRelation().getDispatchKey().contains("<ENTITE1>" + ((IhmLien2)rel.getListLien().get(0)).getEntite().getEntite().getNom() + "</ENTITE1>")) {
/*  875 */             lien1 = (IhmLien2)rel.getListLien().get(0);
/*  876 */             lien2 = (IhmLien2)rel.getListLien().get(1);
/*      */           } else {
/*  878 */             lien1 = (IhmLien2)rel.getListLien().get(1);
/*  879 */             lien2 = (IhmLien2)rel.getListLien().get(0);
/*      */           }
/*  881 */           MLDEntite2 ent1 = (MLDEntite2)listeCorrespondance.get(lien1.getEntite());
/*  882 */           MLDEntite2 ent2 = (MLDEntite2)listeCorrespondance.get(lien2.getEntite());
/*      */           
/*  884 */           ArrayList<Attribut> lA = new ArrayList();
/*  885 */           getListeAttributNonCle(lA, rel.getRelation().getRelation().getListeAttributs());
/*  886 */           lA = copierListAttribut(lA);
/*  887 */           fusionListeAttributNonCle(ent1.getListeAttributs(), lA, rel.getRelation().getRelation().getNom());
/*      */           
/*  889 */           ArrayList<Attribut> lK = new ArrayList();
/*  890 */           getListeAttributCle(lK, ent2.getListeAttributs());
/*  891 */           lK = copierListAttributCle(ent1, ent2, rel, lien1, lK, true);
/*  892 */           setForingKeyListAttribut(lK);
/*  893 */           fusionListeAttributSansRedandonce(ent1.getListeAttributs(), lK);
/*      */           
/*  895 */           MLDLienEntite2 li = new MLDLienEntite2(ent1, ent2);
/*  896 */           String nom = rel.getRelation().getRelation().getNom() + ":" + lien1.getCardinalite();
/*  897 */           li.setFleche(true);
/*  898 */           li.setNom(nom);
/*  899 */           if (ent1 == ent2) ajouterPointDecassureReflexive(li, (IhmEntite2)lien1.getEntite());
/*  900 */           listeMLDLien.add(li);
/*  901 */           return true;
/*      */         }
/*      */         
/*      */ 
/*  905 */         MLDEntite2 ent1 = (MLDEntite2)listeCorrespondance.get(lien1.getEntite());
/*  906 */         MLDEntite2 ent2 = (MLDEntite2)listeCorrespondance.get(lien2.getEntite());
/*      */         
/*  908 */         ArrayList<Attribut> lA = new ArrayList();
/*  909 */         getListeAttributNonCle(lA, rel.getRelation().getRelation().getListeAttributs());
/*  910 */         lA = copierListAttribut(lA);
/*  911 */         fusionListeAttributNonCle(ent1.getListeAttributs(), lA, rel.getRelation().getRelation().getNom());
/*      */         
/*  913 */         if (ent1 == ent2)
/*      */         {
/*  915 */           ArrayList<Attribut> lK = new ArrayList();
/*  916 */           getListeAttributCle(lK, ent1.getListeAttributs());
/*  917 */           lK = copierListAttributCle(ent1, ent2, rel, lien1, lK, true);
/*  918 */           setForingKeyListAttribut(lK);
/*  919 */           fusionListeAttributSansRedandonce(ent1.getListeAttributs(), lK);
/*      */           
/*  921 */           MLDLienEntite2 li = new MLDLienEntite2(ent1, ent2);
/*  922 */           String nom = rel.getRelation().getRelation().getNom() + ":" + lien1.getCardinalite();
/*  923 */           li.setFleche(true);
/*  924 */           li.setNom(nom);
/*  925 */           ajouterPointDecassureReflexive(li, (IhmEntite2)lien1.getEntite());
/*  926 */           listeMLDLien.add(li);
/*  927 */           return true;
/*      */         }
/*      */         
/*  930 */         lA = copierListAttribut(lA);
/*  931 */         fusionListeAttributNonCle(ent2.getListeAttributs(), lA, rel.getRelation().getRelation().getNom());
/*  932 */         ArrayList<Attribut> lK1 = new ArrayList();
/*  933 */         ArrayList<Attribut> lK2 = new ArrayList();
/*      */         
/*  935 */         getListeAttributCle(lK1, ent1.getListeAttributs());
/*  936 */         getListeAttributCle(lK2, ent1.getListeAttributs());
/*      */         
/*  938 */         lK1 = copierListAttributCle(ent2, ent1, rel, lien2, lK1, true);
/*  939 */         setForingKeyListAttribut(lK1);
/*  940 */         fusionListeAttributSansRedandonce(ent2.getListeAttributs(), lK1);
/*      */         
/*  942 */         lK2 = copierListAttributCle(ent1, ent2, rel, lien1, lK2, true);
/*  943 */         setForingKeyListAttribut(lK2);
/*  944 */         fusionListeAttributSansRedandonce(ent1.getListeAttributs(), lK2);
/*      */         
/*  946 */         MLDLienEntite2 li = new MLDLienEntite2(ent1, ent2);
/*  947 */         String nom = rel.getRelation().getRelation().getNom() + "_" + ent1.getNom() + ":" + lien1.getCardinalite();
/*  948 */         li.setFleche(true);
/*  949 */         li.setNom(nom);
/*      */         
/*  951 */         listeMLDLien.add(li);
/*      */         
/*  953 */         li = new MLDLienEntite2(ent2, ent1);
/*  954 */         nom = rel.getRelation().getRelation().getNom() + "_" + ent2.getNom() + ":" + lien2.getCardinalite();
/*  955 */         li.setFleche(true);
/*  956 */         li.setNom(nom);
/*  957 */         listeMLDLien.add(li);
/*  958 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  968 */     return false;
/*      */   }
/*      */   
/*      */   private static boolean listeEgale(ArrayList<Attribut> liste1, ArrayList<Attribut> liste2)
/*      */   {
/*  973 */     if (liste1.size() != liste2.size()) { return false;
/*      */     }
/*  975 */     boolean exist = false;
/*  976 */     for (int i = 0; i < liste1.size(); i++) {
/*  977 */       Attribut2 att1 = (Attribut2)liste1.get(i);
/*  978 */       for (int j = 0; j < liste2.size(); j++) {
/*  979 */         Attribut2 att2 = (Attribut2)liste2.get(j);
/*  980 */         if (att1.getNom().trim().toUpperCase().equals(att2.getNom().trim().toUpperCase())) {
/*  981 */           exist = true;
/*  982 */           break;
/*      */         }
/*      */       }
/*  985 */       if (!exist) { return false;
/*      */       }
/*  987 */       exist = false;
/*      */     }
/*      */     
/*      */ 
/*  991 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static boolean transformerRelationGroupe6(MLDRelationLien rel)
/*      */   {
/* 1001 */     if (rel.getGroupeRelation() == MLDRelationLien.GROUPE_SIX)
/*      */     {
/* 1003 */       IhmLien2 lien1 = (IhmLien2)rel.getListLien().get(0);
/* 1004 */       IhmLien2 lien2 = (IhmLien2)rel.getListLien().get(1);
/*      */       
/* 1006 */       if (rel.getRelation().getDispatchKey().trim().length() == 0)
/*      */       {
/* 1008 */         MLDEntite2 ent1 = (MLDEntite2)listeCorrespondance.get(lien1.getEntite());
/* 1009 */         MLDEntite2 ent2 = (MLDEntite2)listeCorrespondance.get(lien2.getEntite());
/*      */         
/* 1011 */         ArrayList<Attribut> lA = new ArrayList();
/* 1012 */         getListeAttributNonCle(lA, rel.getRelation().getRelation().getListeAttributs());
/* 1013 */         lA = copierListAttribut(lA);
/* 1014 */         fusionListeAttributNonCle(ent1.getListeAttributs(), lA, rel.getRelation().getRelation().getNom());
/*      */         
/*      */ 
/* 1017 */         ArrayList<Attribut> lK = new ArrayList();
/* 1018 */         getListeAttributCle(lK, ent2.getListeAttributs());
/* 1019 */         lK = copierListAttributCle(ent1, ent2, rel, lien1, lK, false);
/* 1020 */         setForingKeyListAttribut(lK);
/* 1021 */         fusionListeAttributSansRedandonce(ent1.getListeAttributs(), lK);
/*      */         
/*      */ 
/* 1024 */         MLDLienEntite2 li = new MLDLienEntite2(ent1, ent2);
/* 1025 */         String nom = rel.getRelation().getRelation().getNom() + ":" + lien1.getCardinalite();
/* 1026 */         li.setFleche(true);
/* 1027 */         li.setNom(nom);
/* 1028 */         if (ent1 == ent2) ajouterPointDecassureReflexive(li, (IhmEntite2)lien1.getEntite());
/* 1029 */         listeMLDLien.add(li);
/*      */         
/* 1031 */         return true;
/*      */       }
/*      */       
/* 1034 */       if (rel.getRelation().getDispatchKey().contains("<ACTION>" + MLDRelationLien.DISPARAITRE + "</ACTION>"))
/*      */       {
/* 1036 */         if (!rel.getRelation().getDispatchKey().contains("<ENTITE1>" + lien1.getEntite().getEntite().getNom() + "</ENTITE1>")) {
/* 1037 */           lien1 = (IhmLien2)rel.getListLien().get(1);
/* 1038 */           lien2 = (IhmLien2)rel.getListLien().get(0);
/*      */         }
/* 1040 */         MLDEntite2 ent1 = (MLDEntite2)listeCorrespondance.get(lien1.getEntite());
/* 1041 */         MLDEntite2 ent2 = (MLDEntite2)listeCorrespondance.get(lien2.getEntite());
/*      */         
/* 1043 */         ArrayList<Attribut> lA = new ArrayList();
/* 1044 */         getListeAttributNonCle(lA, rel.getRelation().getRelation().getListeAttributs());
/* 1045 */         lA = copierListAttribut(lA);
/* 1046 */         fusionListeAttributNonCle(ent1.getListeAttributs(), lA, rel.getRelation().getRelation().getNom());
/*      */         
/*      */ 
/* 1049 */         ArrayList<Attribut> lK = new ArrayList();
/* 1050 */         getListeAttributCle(lK, ent2.getListeAttributs());
/* 1051 */         lK = copierListAttributCle(ent1, ent2, rel, lien1, lK, false);
/* 1052 */         setForingKeyListAttribut(lK);
/* 1053 */         fusionListeAttributSansRedandonce(ent1.getListeAttributs(), lK);
/*      */         
/*      */ 
/* 1056 */         MLDLienEntite2 li = new MLDLienEntite2(ent1, ent2);
/* 1057 */         String nom = rel.getRelation().getRelation().getNom() + ":" + lien1.getCardinalite();
/* 1058 */         li.setFleche(true);
/* 1059 */         li.setNom(nom);
/* 1060 */         if (ent1 == ent2) ajouterPointDecassureReflexive(li, (IhmEntite2)lien1.getEntite());
/* 1061 */         listeMLDLien.add(li);
/*      */         
/* 1063 */         return true;
/*      */       }
/*      */       
/*      */ 
/* 1067 */       if (!rel.getRelation().getDispatchKey().contains("<ENTITE1>" + lien1.getEntite().getEntite().getNom() + "</ENTITE1>")) {
/* 1068 */         lien1 = (IhmLien2)rel.getListLien().get(1);
/* 1069 */         lien2 = (IhmLien2)rel.getListLien().get(0);
/*      */       }
/*      */       
/* 1072 */       boolean isnull = false;
/*      */       
/* 1074 */       if (rel.getCardinalite(lien1).contains("0")) isnull = true;
/* 1075 */       MLDEntite2 ent1 = (MLDEntite2)listeCorrespondance.get(lien1.getEntite());
/* 1076 */       MLDEntite2 ent2 = (MLDEntite2)listeCorrespondance.get(lien2.getEntite());
/*      */       
/* 1078 */       MLDEntite2 mld = new MLDEntite2(rel.getRelation().getRelation().getNom(), rel.getRelation().getX(), rel.getRelation().getY(), 0, 0, true);
/* 1079 */       mld.setCode(rel.getRelation().getRelation().getNom().trim().toUpperCase());
/* 1080 */       mld.setCommentaire(rel.getRelation().getRelation().getCommentaire());
/* 1081 */       mld.setTypeEntite("RELATION");
/*      */       
/* 1083 */       setProprieteMLDEntite(mld, rel.getRelation());
/* 1084 */       ArrayList<Attribut> lA = new ArrayList();
/* 1085 */       getListeAttributNonCle(lA, rel.getRelation().getRelation().getListeAttributs());
/* 1086 */       lA = copierListAttribut(lA);
/* 1087 */       mld.setListeAttributs(lA);
/*      */       
/* 1089 */       ArrayList<Attribut> lK = new ArrayList();
/* 1090 */       getListeAttributCle(lK, ent1.getListeAttributs());
/* 1091 */       lK = copierListAttributCle(mld, ent1, rel, lien1, lK, false);
/* 1092 */       fusionListeAttributSansRedandonce(mld.getListeAttributs(), lK);
/* 1093 */       setPrimaryAndForingKeyListAttribut(lK, isnull);
/*      */       
/* 1095 */       lK.clear();
/*      */       
/* 1097 */       int min = getCardMin(rel, lien1);
/* 1098 */       int max = getCardMax(rel, lien1);
/* 1099 */       lK = new ArrayList();
/* 1100 */       getListeAttributCle(lK, ent2.getListeAttributs());
/* 1101 */       lK = copierListAttributCle(mld, ent2, rel, lien1, lK, min, max, true);
/* 1102 */       setForingKeyListAttribut(lK);
/* 1103 */       fusionListeAttributSansRedandonce(mld.getListeAttributs(), lK);
/*      */       
/*      */ 
/* 1106 */       listeMLDEntite.add(mld);
/*      */       
/* 1108 */       MLDLienEntite2 li = new MLDLienEntite2(mld, ent2);
/* 1109 */       String nom = rel.getRelation().getRelation().getNom() + "_" + ent2.getNom() + ":" + lien2.getCardinalite();
/*      */       
/* 1111 */       li.setNom(nom);
/* 1112 */       li.setFleche(true);
/* 1113 */       listeMLDLien.add(li);
/* 1114 */       li = new MLDLienEntite2(mld, ent1);
/* 1115 */       nom = rel.getRelation().getRelation().getNom() + "_" + ent1.getNom() + ":" + lien1.getCardinalite();
/* 1116 */       li.setNom(nom);
/* 1117 */       li.setFleche(true);
/* 1118 */       listeMLDLien.add(li);
/*      */       
/* 1120 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1126 */     return false;
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\vConversion\TransformationRelation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */