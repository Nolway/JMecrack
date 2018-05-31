/*      */ package vConversion;
/*      */ 
/*      */ import Contrainte.AttributReference;
/*      */ import Contrainte.TableReference;
/*      */ import IhmMCD.IhmEntiteRelation;
/*      */ import IhmMCD.IhmLien;
/*      */ import IhmMCD.IhmLienContrainteHeritage;
/*      */ import IhmMCD.IhmLienHeritage;
/*      */ import IhmMCD.IhmPageMCD;
/*      */ import IhmMCD2.ConfigurationMCD2;
/*      */ import IhmMCD2.IhmEntite2;
/*      */ import IhmMCD2.IhmHeritage2;
/*      */ import IhmMCD2.IhmLien2;
/*      */ import IhmMCD2.IhmLienContrainteHeritage2;
/*      */ import IhmMCD2.IhmLienHeritage2;
/*      */ import IhmMCD2.IhmRelation2;
/*      */ import IhmMLD.IhmPageMLD;
/*      */ import IhmMLD2.MLDEntite2;
/*      */ import IhmMLD2.MLDLienEntite2;
/*      */ import IhmMLD2.MLDReference2;
/*      */ import IhmMLD2.MLDRelationLien;
/*      */ import Merise.Attribut;
/*      */ import Merise.Entite;
/*      */ import Merise.Relation;
/*      */ import Merise2.Attribut2;
/*      */ import Merise2.Entite2;
/*      */ import Outil.Parametres;
/*      */ import Outil.Setting;
/*      */ import java.io.PrintStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import javax.swing.JFrame;
/*      */ import javax.swing.JOptionPane;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Transformation
/*      */ {
/*      */   public ArrayList<MLDRelationLien> listeRelationLien;
/*      */   public ArrayList<MLDEntite2> listeMLDEntite;
/*      */   public ArrayList<MLDLienEntite2> listeMLDLien;
/*      */   public Map<IhmEntiteRelation, MLDEntite2> listeCorrespondance;
/*      */   public ArrayList<MLDReference2> listeReference;
/*      */   public boolean mutex;
/*      */   IhmPageMCD pageMCD;
/*      */   Map<Attribut, ArrayList<String>> dernierCheminHR;
/*      */   public Map<MLDEntite2, ArrayList<Attribut>> correspondanceAttribut;
/*      */   public Map<MLDEntite2, ArrayList<TableReference>> correspondanceCntFK;
/*      */   public Map<MLDEntite2, ArrayList<TableReference>> correspondanceCntAK;
/*      */   
/*      */   public Transformation(ArrayList<MLDRelationLien> listeRelationLien, IhmPageMCD pageMCD)
/*      */   {
/*   61 */     this.listeRelationLien = listeRelationLien;
/*   62 */     this.listeMLDEntite = new ArrayList();
/*   63 */     this.listeMLDLien = new ArrayList();
/*   64 */     this.listeCorrespondance = new HashMap();
/*   65 */     this.pageMCD = pageMCD;
/*   66 */     this.listeReference = new ArrayList();
/*   67 */     this.dernierCheminHR = new HashMap();
/*   68 */     this.correspondanceAttribut = new HashMap();
/*   69 */     this.correspondanceCntFK = new HashMap();
/*   70 */     this.correspondanceCntAK = new HashMap();
/*   71 */     this.mutex = false;
/*      */   }
/*      */   
/*      */   public ArrayList<MLDReference2> getListeReference() {
/*   75 */     return this.listeReference;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void getListeAttributCle(ArrayList<Attribut> listeKey, ArrayList<Attribut> listeAtt)
/*      */   {
/*   96 */     for (int i = 0; i < listeAtt.size(); i++) {
/*   97 */       Attribut2 att = (Attribut2)listeAtt.get(i);
/*   98 */       if (att.getListeAttributs().size() == 0) {
/*   99 */         if ((att.getKey().equals(Parametres.Cle)) && 
/*  100 */           (!((Attribut2)listeAtt.get(i)).isForeingKey())) listeKey.add(listeAtt.get(i));
/*      */       }
/*      */       else {
/*  103 */         getListeAttributCle(listeKey, att.getListeAttributs());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void getListeAttributNonCle(ArrayList<Attribut> listeKey, ArrayList<Attribut> listeAtt)
/*      */   {
/*  110 */     for (int i = 0; i < listeAtt.size(); i++) {
/*  111 */       Attribut2 att = (Attribut2)listeAtt.get(i);
/*  112 */       if (att.getListeAttributs().size() == 0) {
/*  113 */         if ((!att.getKey().equals(Parametres.Cle)) && 
/*  114 */           (!((Attribut2)listeAtt.get(i)).isForeingKey())) listeKey.add(listeAtt.get(i));
/*      */       }
/*      */       else {
/*  117 */         getListeAttributNonCle(listeKey, att.getListeAttributs());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public ArrayList<Attribut> getAttributCleEntite(IhmEntite2 ent) {
/*  123 */     ArrayList<Attribut> listeKey = new ArrayList();
/*  124 */     MLDEntite2 mld = (MLDEntite2)this.listeCorrespondance.get(ent);
/*  125 */     getListeAttributCle(listeKey, mld.getListeAttributs());
/*  126 */     return listeKey;
/*      */   }
/*      */   
/*      */   public ArrayList<Attribut> getAttributNonCleEntite(IhmEntite2 ent) {
/*  130 */     ArrayList<Attribut> listeKey = new ArrayList();
/*  131 */     getListeAttributNonCle(listeKey, ent.getEntite().getListeAttributs());
/*  132 */     return listeKey;
/*      */   }
/*      */   
/*      */   private void recupererLaListeDesAttributsAvecCopie(ArrayList<Attribut> listRecup, ArrayList<Attribut> liste)
/*      */   {
/*  137 */     for (int i = 0; i < liste.size(); i++) {
/*  138 */       Attribut2 att = (Attribut2)liste.get(i);
/*  139 */       if (att.getListeAttributs().size() == 0) {
/*  140 */         Attribut2 a = (Attribut2)att.copier();
/*  141 */         a.setNom(a.getAugmentation() + a.getNom());
/*  142 */         a.setCode((a.getAugmentation() + a.getCode()).toUpperCase());
/*  143 */         listRecup.add(a);
/*      */       } else {
/*  145 */         recupererLaListeDesAttributsAvecCopie(listRecup, att.getListeAttributs());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public ArrayList<Attribut> getAttributEntiteRelation(IhmEntiteRelation eR)
/*      */   {
/*  152 */     ArrayList<Attribut> liste = new ArrayList();
/*  154 */     ArrayList<Attribut> l; if ((eR instanceof IhmEntite2)) {
/*  155 */       l = ((IhmEntite2)eR).getEntite().getListeAttributs();
/*      */     }
/*      */     else {
/*  158 */       l = ((IhmRelation2)eR).getRelation().getListeAttributs();
/*      */     }
/*  160 */     recupererLaListeDesAttributsAvecCopie(liste, l);
/*  161 */     return liste;
/*      */   }
/*      */   
/*      */   public String getNomAttribut(Attribut2 att) {
/*  165 */     String s = "";
/*  166 */     if (Setting.augmentation) {
/*  167 */       s = att.getAugmentation();
/*      */     }
/*  169 */     return s + att.getNom();
/*      */   }
/*      */   
/*      */   public String getCodeAttribut(Attribut2 att) {
/*  173 */     String s = "";
/*      */     
/*  175 */     if (Setting.augmentation) {
/*  176 */       s = att.getAugmentation();
/*      */     }
/*  178 */     return s + att.getCode();
/*      */   }
/*      */   
/*      */   private void fusionListeAttribut(ArrayList<Attribut> liste1, ArrayList<Attribut> liste2) {
/*  182 */     for (int i = 0; i < liste2.size(); i++) {
/*  183 */       liste1.add(i, liste2.get(i));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public MLDRelationLien getLienRelation(IhmRelation2 rel)
/*      */   {
/*  214 */     for (int i = 0; i < this.listeRelationLien.size(); i++) {
/*  215 */       if (((MLDRelationLien)this.listeRelationLien.get(i)).getRelation() == rel) return (MLDRelationLien)this.listeRelationLien.get(i);
/*      */     }
/*  217 */     return null;
/*      */   }
/*      */   
/*      */   private ArrayList<IhmEntiteRelation> getRelationRelatifEntite(IhmEntite2 ent, ArrayList<IhmLien> listeLien) {
/*  221 */     ArrayList<IhmEntiteRelation> l = new ArrayList();
/*      */     
/*  223 */     for (int i = 0; i < listeLien.size(); i++) {
/*  224 */       IhmLien2 lien = (IhmLien2)listeLien.get(i);
/*  225 */       if ((lien.isRelatif()) && 
/*  226 */         (lien.getEntite() == ent)) {
/*  227 */         l.add(lien.getRelation());
/*      */       }
/*      */     }
/*      */     
/*  231 */     return l;
/*      */   }
/*      */   
/*      */   private ArrayList<IhmEntiteRelation> getPeresRelatif(IhmEntite2 ent, ArrayList<IhmLien> listeLien) {
/*  235 */     ArrayList<IhmEntiteRelation> l = new ArrayList();
/*  236 */     ArrayList<IhmEntiteRelation> lsortie = new ArrayList();
/*      */     
/*  238 */     l = getRelationRelatifEntite(ent, listeLien);
/*      */     
/*  240 */     for (int i = 0; i < l.size(); i++) {
/*  241 */       MLDRelationLien rl = getLienRelation((IhmRelation2)l.get(i));
/*  242 */       for (int j = 0; j < rl.getListLien().size(); j++) {
/*  243 */         if (!((IhmLien2)rl.getListLien().get(j)).isRelatif())
/*      */         {
/*  245 */           lsortie.add(((IhmLien2)rl.getListLien().get(j)).getEntite());
/*      */         }
/*      */       }
/*      */     }
/*  249 */     return lsortie;
/*      */   }
/*      */   
/*      */   private ArrayList<IhmEntiteRelation> getPeres(IhmEntite2 ent, ArrayList<IhmLienHeritage> listeHeritage) {
/*  253 */     ArrayList<IhmEntiteRelation> l = new ArrayList();
/*  254 */     for (int i = 0; i < listeHeritage.size(); i++) {
/*  255 */       if (((IhmLienHeritage2)listeHeritage.get(i)).getFils() == ent) {
/*  256 */         l.add(((IhmLienHeritage2)listeHeritage.get(i)).getPere());
/*      */       }
/*      */     }
/*  259 */     return l;
/*      */   }
/*      */   
/*      */   private String getNomEntiteRef(String nom) {
/*  263 */     if (nom == null) return "";
/*  264 */     if (nom.trim().length() == 0) { return "";
/*      */     }
/*  266 */     String n = nom.substring(3, nom.length());
/*  267 */     if (n.indexOf("¤") < 0) return n;
/*  268 */     n = n.substring(0, n.indexOf("¤"));
/*  269 */     return n;
/*      */   }
/*      */   
/*      */ 
/*      */   private void sauvegarderEntite(String nom, ArrayList<Attribut> listeKey)
/*      */   {
/*  275 */     for (int i = 0; i < listeKey.size(); i++) {
/*  276 */       ArrayList<String> listeSt = (ArrayList)this.dernierCheminHR.get(listeKey.get(i));
/*  277 */       if (listeSt == null) {
/*  278 */         listeSt = new ArrayList();
/*  279 */         listeSt.add(nom);
/*  280 */         this.dernierCheminHR.put(listeKey.get(i), listeSt);
/*      */       } else {
/*  282 */         listeSt.add(nom);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void getCleHeritageRelatif(IhmEntite2 ent, String nomEnt, ArrayList<Attribut> listeKey, ArrayList<IhmLienHeritage> listeHeritage, ArrayList<IhmLien> listeLien)
/*      */   {
/*  291 */     String nomH = nomEnt;String nomR = nomEnt;
/*  292 */     ArrayList<IhmEntiteRelation> listePereH; 
				if (Setting.cleMere) {
/*  293 */       listePereH = getPeres(ent, listeHeritage);
/*      */     } else {
/*  295 */       listePereH = new ArrayList();
/*      */     }
/*  297 */     ArrayList<IhmEntiteRelation> listePereR = getPeresRelatif(ent, listeLien);
/*      */     
/*  299 */     for (int i = 0; i < listePereH.size(); i++) {
/*  300 */       nomH = nomEnt + "¤H¤" + ((IhmEntite2)listePereH.get(i)).getEntite().getNom();
/*  301 */       getCleHeritageRelatif((IhmEntite2)listePereH.get(i), nomH, listeKey, listeHeritage, listeLien);
/*      */       
/*  303 */       ArrayList<Attribut> listK = getAttributCleEntite((IhmEntite2)listePereH.get(i));
/*      */       
/*  305 */       sauvegarderEntite(nomH, listK);
/*      */       
/*  307 */       fusionListeAttribut(listeKey, listK);
/*      */     }
/*      */     
/*      */ 
/*  311 */     for (int i = 0; i < listePereR.size(); i++) {
/*  312 */       nomR = nomEnt + "¤R¤" + ((IhmEntite2)listePereR.get(i)).getEntite().getNom();
/*  313 */       getCleHeritageRelatif((IhmEntite2)listePereR.get(i), nomR, listeKey, listeHeritage, listeLien);
/*  314 */       ArrayList<Attribut> listK = getAttributCleEntite((IhmEntite2)listePereR.get(i));
/*  315 */       sauvegarderEntite(nomR, listK);
/*  316 */       fusionListeAttribut(listeKey, listK);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private ArrayList<Attribut> copierListAttributHR(IhmEntite2 ent, ArrayList<Attribut> listeKey)
/*      */   {
/*  323 */     ArrayList<Attribut> liste = new ArrayList();
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  328 */     Object[] tab = this.dernierCheminHR.keySet().toArray();
/*      */     
/*      */ 
/*  331 */     for (int i = 0; i < tab.length; i++) {
/*  332 */       Attribut2 att = (Attribut2)tab[i];
/*  333 */       ArrayList<String> listChemin = (ArrayList)this.dernierCheminHR.get(att);
/*      */       
/*  335 */       for (int j = 0; j < listChemin.size(); j++) {
/*  336 */         att = (Attribut2)tab[i];
/*  337 */         Attribut2 attRef = att;
/*  338 */         att = (Attribut2)att.copier();
/*  339 */         att.setForeingKey(true);
/*  340 */         if (att.getType().toUpperCase().equals("AUTO_INCREMENT")) {
/*  341 */           att.setType("Int");
/*  342 */           if (att.getLongueur() < 0) { att.setLongueur(11);
/*      */           }
/*      */         }
/*  345 */         att.setAugmentation((String)listChemin.get(j));
/*  346 */         att.setDepanne(att.getAugmentation());
/*  347 */         liste.add(att);
/*  348 */         creerReference(ent, att, attRef);
/*      */       }
/*      */     }
/*  351 */     return liste;
/*      */   }
/*      */   
/*      */   private void creerReference(IhmEntite2 ent, Attribut at, Attribut atRef) {
/*  355 */     Attribut2 att = (Attribut2)at;
/*  356 */     Attribut2 attRef = (Attribut2)atRef;
/*  357 */     String nomEntRef = getNomEntiteRef(att.getAugmentation());
/*  358 */     MLDEntite2 mldRef = getMLDEntite(nomEntRef);
/*  359 */     MLDEntite2 mld = (MLDEntite2)this.listeCorrespondance.get(ent);
/*      */     
/*  361 */     MLDReference2 REF = new MLDReference2(mld, mldRef, att, attRef);
/*      */     
/*  363 */     this.listeReference.add(REF);
/*      */   }
/*      */   
/*      */   private boolean contientChemin(String mld, String chAtt, String chAttSuiv)
/*      */   {
/*  368 */     String nom = "¤R¤" + mld + chAttSuiv;
/*  369 */     nom = nom.trim().toUpperCase();
/*      */     
/*  371 */     if (chAtt.trim().toUpperCase().equals(nom)) { return true;
/*      */     }
/*  373 */     nom = "¤H¤" + mld + chAttSuiv;
/*  374 */     nom = nom.trim().toUpperCase();
/*      */     
/*  376 */     if (chAtt.trim().toUpperCase().equals(nom)) return true;
/*  377 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   private MLDReference2 getReferenceSuivante(MLDReference2 ref)
/*      */   {
/*  383 */     Attribut2 att = ref.getAttribut();
/*  384 */     Attribut2 attRef = ref.getAttributRef();
/*  385 */     MLDEntite2 ent = ref.getEntite();
/*  386 */     MLDEntite2 entRef = ref.getEntiteRef();
/*  387 */     String chemin = att.getDepanne().trim().toUpperCase();
/*      */     
/*  389 */     for (int i = 0; i < this.listeReference.size(); i++) {
/*  390 */       if ((((MLDReference2)this.listeReference.get(i)).getEntite() == entRef) && 
/*  391 */         (((MLDReference2)this.listeReference.get(i)).getAttributRef() == attRef))
/*      */       {
/*  393 */         Attribut2 a = ((MLDReference2)this.listeReference.get(i)).getAttribut();
/*  394 */         String chSuiv = a.getDepanne().trim().toUpperCase();
/*  395 */         if (contientChemin(entRef.getNom(), chemin, chSuiv)) {
/*  396 */           return (MLDReference2)this.listeReference.get(i);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  403 */     return null;
/*      */   }
/*      */   
/*      */   private void setSQLGenereFalseReferences() {
/*  407 */     for (int i = 0; i < this.listeReference.size(); i++) {
/*  408 */       ((MLDReference2)this.listeReference.get(i)).setSQLGenerer(false);
/*      */     }
/*      */   }
/*      */   
/*      */   private MLDReference2 getReferenceAvecAttributPlusGrand() {
/*  413 */     MLDReference2 ref = null;
/*  414 */     int max = -1;
/*  415 */     for (int i = 0; i < this.listeReference.size(); i++) {
/*  416 */       if ((((MLDReference2)this.listeReference.get(i)).getAttribut().getDepanne().trim().length() > max) && 
/*  417 */         (!((MLDReference2)this.listeReference.get(i)).iSSQLGenerer())) {
/*  418 */         ref = (MLDReference2)this.listeReference.get(i);
/*  419 */         max = ((MLDReference2)this.listeReference.get(i)).getAttribut().getDepanne().trim().length();
/*      */       }
/*      */     }
/*      */     
/*  423 */     return ref;
/*      */   }
/*      */   
/*      */ 
/*      */   private void traiterAllReferences()
/*      */   {
/*  429 */     MLDReference2 ref = getReferenceAvecAttributPlusGrand();
/*  430 */     while (ref != null) {
/*  431 */       MLDReference2 refSuiv = getReferenceSuivante(ref);
/*  432 */       if (refSuiv != null) {
/*  433 */         ref.setAttributRef(refSuiv.getAttribut());
/*      */       }
/*  435 */       ref.setSQLGenerer(true);
/*  436 */       ref = getReferenceAvecAttributPlusGrand();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void getAllCleEntite(IhmEntite2 ent, ArrayList<IhmLienHeritage> listeHeritage, ArrayList<IhmLien> listeLien)
/*      */   {
/*  443 */     this.dernierCheminHR.clear();
/*  444 */     ArrayList<Attribut> listeKey = new ArrayList();
/*  445 */     getCleHeritageRelatif(ent, "", listeKey, listeHeritage, listeLien);
/*      */     
/*      */ 
/*  448 */     listeKey = copierListAttributHR(ent, listeKey);
/*      */     
/*  450 */     MLDEntite2 mld = (MLDEntite2)this.listeCorrespondance.get(ent);
/*  451 */     if (!fusionDirecte(mld.getListeAttributs(), listeKey))
/*  452 */       fusionListeAttributRedondant(mld.getListeAttributs(), listeKey);
/*  453 */     setForeingKeyListe(listeKey);
/*      */   }
/*      */   
/*      */   private boolean pasDeRedondance(ArrayList<Attribut> liste)
/*      */   {
/*  458 */     for (int i = 0; i < liste.size(); i++) {
/*  459 */       String nom = ((Attribut)liste.get(i)).getNom().trim().toUpperCase();
/*  460 */       for (int j = i + 1; j < liste.size(); j++) {
/*  461 */         if (nom.equals(((Attribut)liste.get(j)).getNom().trim().toUpperCase())) return false;
/*      */       }
/*      */     }
/*  464 */     return true;
/*      */   }
/*      */   
/*      */   private boolean existeListe(ArrayList<Attribut> liste, ArrayList<Attribut> liste1)
/*      */   {
/*  469 */     for (int i = 0; i < liste1.size(); i++) {
/*  470 */       String nom = ((Attribut)liste1.get(i)).getNom();
/*  471 */       if (existeNomDansListe(liste, nom)) return true;
/*      */     }
/*  473 */     return false;
/*      */   }
/*      */   
/*      */   private boolean fusionDirecte(ArrayList<Attribut> liste, ArrayList<Attribut> liste1) {
/*  477 */     if (!pasDeRedondance(liste1)) return false;
/*  478 */     if (existeListe(liste, liste1)) { return false;
/*      */     }
/*  480 */     ArrayList<Attribut> l = getListeKeyHR(liste1, "¤H¤");
/*  481 */     for (int i = 0; i < l.size(); i++) {
/*  482 */       liste.add(i, l.get(i));
/*      */     }
/*      */     
/*  485 */     l = getListeKeyHR(liste1, "¤R¤");
/*  486 */     for (int i = 0; i < l.size(); i++) {
/*  487 */       liste.add(i, l.get(i));
/*      */     }
/*      */     
/*      */ 
/*  491 */     return true;
/*      */   }
/*      */   
/*      */   private boolean existeNomDansListe(ArrayList<Attribut> liste, String nom) {
/*  495 */     nom = nom.trim().toUpperCase();
/*  496 */     for (int i = 0; i < liste.size(); i++) {
/*  497 */       if (((Attribut)liste.get(i)).getNom().trim().toUpperCase().equals(nom)) return true;
/*      */     }
/*  499 */     return false;
/*      */   }
/*      */   
/*      */   private String getOrigineAttribut(Attribut2 att) {
/*  503 */     if (att.getAugmentation().trim().length() == 0) return "";
/*  504 */     String nom = att.getAugmentation().trim();
/*  505 */     int index = nom.indexOf("¤");
/*  506 */     String s = "";
/*      */     
/*  508 */     while (index > -1) {
/*  509 */       s = s + nom.substring(0, index + 1);
/*  510 */       nom = nom.substring(index + 1, nom.length());
/*  511 */       index = index = nom.indexOf("¤");
/*      */     }
/*  513 */     s = s.substring(0, s.length() - 3);
/*  514 */     att.setAugmentation(s);
/*      */     
/*  516 */     return nom;
/*      */   }
/*      */   
/*      */   private boolean existeAttributDansListe(ArrayList<Attribut> liste, Attribut2 att) {
/*  520 */     String nom = att.getNom().trim().toUpperCase();
/*  521 */     for (int i = 0; i < liste.size(); i++) {
/*  522 */       if ((liste.get(i) != att) && 
/*  523 */         (nom.equals(((Attribut)liste.get(i)).getNom().trim().toUpperCase()))) { return true;
/*      */       }
/*      */     }
/*  526 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean changerNomAttributRedondant(ArrayList<Attribut> liste)
/*      */   {
/*  532 */     boolean changement = false;
/*  533 */     for (int i = 0; i < liste.size(); i++) {
/*  534 */       Attribut2 att = (Attribut2)liste.get(i);
/*  535 */       String nom = getOrigineAttribut(att);
/*  536 */       if (nom.length() > 0) {
/*  537 */         if (!att.getNom().trim().toUpperCase().contains(nom.trim().toUpperCase())) {
/*  538 */           att.setNom(att.getNom() + "_" + nom.trim());
/*  539 */           att.setCode(att.getCode() + "_" + nom.trim().toUpperCase());
/*      */         }
/*  541 */         changement = true;
/*      */       }
/*      */     }
/*  544 */     return changement;
/*      */   }
/*      */   
/*      */   private boolean changerNomAttributRedondantAvecNum(ArrayList<Attribut> liste)
/*      */   {
/*  549 */     for (int i = 0; i < liste.size(); i++) {
/*  550 */       Attribut2 att = (Attribut2)liste.get(i);
/*  551 */       att.setNom(att.getNom() + "_" + (i + 1));
/*  552 */       att.setCode(att.getCode() + "_" + (i + 1));
/*      */     }
/*  554 */     return true;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> getListeAttRedondant(ArrayList<Attribut> listeMLD, ArrayList<Attribut> listeKey) {
/*  558 */     ArrayList<Attribut> liste = new ArrayList();
/*  559 */     for (int i = 0; i < listeKey.size(); i++) {
/*  560 */       if (existeAttributDansListe(listeKey, (Attribut2)listeKey.get(i))) {
/*  561 */         liste.add(listeKey.get(i));
/*      */       }
/*  563 */       else if (existeAttributDansListe(listeMLD, (Attribut2)listeKey.get(i))) {
/*  564 */         liste.add(listeKey.get(i));
/*      */       }
/*      */     }
/*      */     
/*  568 */     return liste;
/*      */   }
/*      */   
/*      */   private void fusionListeAttributRedondant(ArrayList<Attribut> listeMLD, ArrayList<Attribut> listeKey)
/*      */   {
/*  573 */     ArrayList<Attribut> liste = getListeAttRedondant(listeMLD, listeKey);
/*  574 */     int nb = 0;
/*      */     
/*  576 */     while ((liste.size() > 0) && 
/*  577 */       (changerNomAttributRedondant(liste))) {
/*  578 */       liste = getListeAttRedondant(listeMLD, listeKey);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  584 */     while (liste.size() > 0) {
/*  585 */       if (changerNomAttributRedondantAvecNum(liste)) {
/*  586 */         liste = getListeAttRedondant(listeMLD, listeKey);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  591 */     ArrayList<Attribut> l = getListeKeyHR(listeKey, "¤H¤");
/*  592 */     for (int i = 0; i < l.size(); i++) {
/*  593 */       listeMLD.add(i, l.get(i));
/*      */     }
/*      */     
/*  596 */     l = getListeKeyHR(listeKey, "¤R¤");
/*  597 */     for (int i = 0; i < l.size(); i++) {
/*  598 */       listeMLD.add(i, l.get(i));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private ArrayList<Attribut> getListeKeyHR(ArrayList<Attribut> listeKey, String type)
/*      */   {
/*  605 */     ArrayList<Attribut> liste = new ArrayList();
/*      */     
/*  607 */     for (int i = 0; i < listeKey.size(); i++) {
/*  608 */       Attribut2 att = (Attribut2)listeKey.get(i);
/*  609 */       if (att.getDepanne().substring(0, 3).toUpperCase().equals(type)) {
/*  610 */         liste.add(att);
/*      */       }
/*      */     }
/*  613 */     return liste;
/*      */   }
/*      */   
/*      */   private void setForeingKeyListe(ArrayList<Attribut> listeK)
/*      */   {
/*  618 */     for (int i = 0; i < listeK.size(); i++)
/*      */     {
/*  620 */       ((Attribut)listeK.get(i)).setKey(Parametres.CleEtr);
/*      */     }
/*      */   }
/*      */   
/*      */   private void setPrimaryKeyAllMLDListe(ArrayList<Attribut> listeK)
/*      */   {
/*  626 */     for (int i = 0; i < listeK.size(); i++)
/*      */     {
/*  628 */       if (((Attribut)listeK.get(i)).getKey().equals(Parametres.CleEtr)) {
/*  629 */         Attribut2 att = (Attribut2)listeK.get(i);
/*  630 */         att.setKey(Parametres.Cle);
/*  631 */         att.setForeingKey(false);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void setPrimaryKeyAllMLEntite() {
/*  637 */     for (int i = 0; i < this.listeMLDEntite.size(); i++) {
/*  638 */       setPrimaryKeyAllMLDListe(((MLDEntite2)this.listeMLDEntite.get(i)).getListeAttributs());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void setProprieteMLDEntite(MLDEntite2 ent, IhmEntite2 e)
/*      */   {
/*  646 */     ent.setClDegradee(e.isClDegradee());
/*  647 */     ent.setVariable(this.pageMCD.getConfigurationMCD().afficheType2);
/*      */     
/*  649 */     ent.setClAttributSelect(e.getClAttributSelect());
/*  650 */     ent.setClCadre2(e.getClCadre2());
/*  651 */     ent.setClCadreTitre2(e.getClCadreTitre2());
/*  652 */     ent.setClFond2(e.getClFond2());
/*  653 */     ent.setClFondTitre2(e.getClFondTitre2());
/*  654 */     ent.setClPrk(e.getClFondTitre2());
/*  655 */     ent.setClLienActiver(e.getClLienActiver());
/*  656 */     ent.setClOmbre(e.getClOmbre());
/*      */     
/*  658 */     ent.setClSelected(e.getClSelected());
/*  659 */     ent.setClText2(e.getClText2());
/*  660 */     ent.setClTextTaille2(e.getClTextTaille2());
/*  661 */     ent.setClTextTailleDec2(e.getClTextTailleDec2());
/*  662 */     ent.setClTextTitre2(e.getClTextTitre2());
/*  663 */     ent.setClTextType2(e.getClTextType2());
/*  664 */     ent.setArrondir(e.isArrondir());
/*  665 */     ent.setAttEspace(e.getAttEspace());
/*  666 */     ent.setAttMajuscule(e.isAttMajuscule());
/*  667 */     ent.setEpaisseur(e.getEpaisseur());
/*  668 */     ent.setOmbre(e.isOmbre());
/*  669 */     ent.setPrkvisible(e.isPrkvisible());
/*  670 */     ent.setPrkImage(e.isPrkImage());
/*      */   }
/*      */   
/*      */   private String getNomHeritage(ArrayList<IhmLienContrainteHeritage> liste, IhmEntiteRelation f, IhmEntiteRelation p) {
/*  674 */     String nom = "";
/*      */     
/*  676 */     for (int i = 0; i < liste.size(); i++) {
/*  677 */       IhmLienContrainteHeritage2 cnt = (IhmLienContrainteHeritage2)liste.get(i);
/*  678 */       if ((cnt.getEntiteRelation() == f) && (cnt.getHeritage().getPere() == p)) {
/*  679 */         return cnt.getNom();
/*      */       }
/*      */     }
/*      */     
/*  683 */     return nom;
/*      */   }
/*      */   
/*      */ 
/*      */   private void ajouterLienRelatif(MLDRelationLien rel)
/*      */   {
/*  689 */     String nom = rel.getRelation().getRelation().getNom().trim();
/*  690 */     if (rel.isIsRelatif()) {
/*  691 */       MLDEntite2 fils; MLDEntite2 pere; if (((IhmLien2)rel.getListLien().get(0)).getCardinalite().equals("(1,1)")) {
/*  692 */         fils = (MLDEntite2)this.listeCorrespondance.get(((IhmLien2)rel.getListLien().get(0)).getEntite());
/*  693 */         pere = (MLDEntite2)this.listeCorrespondance.get(((IhmLien2)rel.getListLien().get(1)).getEntite());
/*      */       } else {
/*  695 */         fils = (MLDEntite2)this.listeCorrespondance.get(((IhmLien2)rel.getListLien().get(1)).getEntite());
/*  696 */         pere = (MLDEntite2)this.listeCorrespondance.get(((IhmLien2)rel.getListLien().get(0)).getEntite());
/*      */       }
/*  698 */       MLDLienEntite2 lien = new MLDLienEntite2(fils, pere);
/*  699 */       lien.setNom(nom + ":" + "<1,1>");
/*  700 */       lien.setFleche(true);
/*  701 */       this.listeMLDLien.add(lien);
/*      */     }
/*      */   }
/*      */   
/*      */   private void ajouterAllLienRelatif()
/*      */   {
/*  707 */     for (int i = 0; i < this.listeRelationLien.size(); i++) {
/*  708 */       if (((MLDRelationLien)this.listeRelationLien.get(i)).isIsRelatif()) {
/*  709 */         ajouterLienRelatif((MLDRelationLien)this.listeRelationLien.get(i));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void setafficherAll(ArrayList<Attribut> liste)
/*      */   {
/*  718 */     for (int i = 0; i < liste.size(); i++) {
/*  719 */       Attribut2 att = (Attribut2)liste.get(i);
/*  720 */       att.setAfficher(true);
/*  721 */       if (att.getListeAttributs().size() > 0) {
/*  722 */         setafficherAll(att.getListeAttributs());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void composerLesAttributsMLDEntite(MLDEntite2 ent) {
/*  728 */     if (ent == null) return;
/*  729 */     if (!ent.isComposer()) {
/*  730 */       ent.setListeAttributs(composerLesAttributs(ent.getListeAttributs()));
/*      */     }
/*      */   }
/*      */   
/*      */   private void composerAttributAllMLDEntite(ArrayList<MLDEntite2> liste) {
/*  735 */     for (int i = 0; i < liste.size(); i++) {
/*  736 */       composerLesAttributsMLDEntite((MLDEntite2)liste.get(i));
/*      */     }
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> composerLesAttributs(ArrayList<Attribut> liste) {
/*  741 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  743 */     setafficherAll(liste);
/*  744 */     ArrayList<Attribut> lp = getAttributPrimaryKey(liste);
/*  745 */     if (lp.size() > 0) {
/*  746 */       Attribut2 att = new Attribut2("Pk_Primary", "", "", -1, -1, "", false, "", null);
/*  747 */       att.setForeingKey(false);
/*  748 */       att.setListeAttributs(lp);
/*  749 */       l.add(att);
/*      */     }
/*  751 */     lp = getAttributPrimaryForeingKey(liste);
/*  752 */     if (lp.size() > 0) {
/*  753 */       Attribut2 att = new Attribut2("PFk_Prim_Forei", "", "", -1, -1, "", false, "", null);
/*  754 */       att.setForeingKey(true);
/*  755 */       att.setListeAttributs(lp);
/*  756 */       l.add(att);
/*      */     }
/*      */     
/*  759 */     lp = getAttributNonCle(liste);
/*  760 */     if (lp.size() > 0) {
/*  761 */       Attribut2 att = new Attribut2("Attributs", "", "", -1, -1, "", false, "", null);
/*  762 */       att.setForeingKey(false);
/*  763 */       att.setListeAttributs(lp);
/*  764 */       l.add(att);
/*      */     }
/*      */     
/*  767 */     lp = getAttributUnique(liste);
/*  768 */     if (lp.size() > 0) {
/*  769 */       Attribut2 att = new Attribut2("Unq_Unique", "", "", -1, -1, "", false, "", null);
/*  770 */       att.setForeingKey(false);
/*  771 */       att.setListeAttributs(lp);
/*  772 */       l.add(att);
/*      */     }
/*      */     
/*  775 */     lp = getAttributIndex(liste);
/*  776 */     if (lp.size() > 0) {
/*  777 */       Attribut2 att = new Attribut2("Idx_Index", "", "", -1, -1, "", false, "", null);
/*  778 */       att.setForeingKey(false);
/*  779 */       att.setListeAttributs(lp);
/*  780 */       l.add(att);
/*      */     }
/*      */     
/*  783 */     lp = getAttributForeingKey(liste);
/*  784 */     if (lp.size() > 0) {
/*  785 */       Attribut2 att = new Attribut2("Fk_Foreign", "", "", -1, -1, "", false, "", null);
/*  786 */       att.setForeingKey(false);
/*  787 */       att.setListeAttributs(lp);
/*  788 */       l.add(att);
/*      */     }
/*      */     
/*  791 */     return l;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> getAttributPrimaryKey(ArrayList<Attribut> liste) {
/*  795 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  797 */     for (int i = 0; i < liste.size(); i++) {
/*  798 */       Attribut2 att = (Attribut2)liste.get(i);
/*  799 */       if ((att.getKey().equals(Parametres.Cle)) && (!att.isForeingKey())) {
/*  800 */         l.add(att);
/*      */       }
/*      */     }
/*  803 */     return l;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> getAttributForeingKey(ArrayList<Attribut> liste) {
/*  807 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  809 */     for (int i = 0; i < liste.size(); i++) {
/*  810 */       Attribut2 att = (Attribut2)liste.get(i);
/*  811 */       if (att.getKey().equals(Parametres.CleEtr)) {
/*  812 */         l.add(att);
/*      */       }
/*      */     }
/*  815 */     return l;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> getAttributPrimaryForeingKey(ArrayList<Attribut> liste) {
/*  819 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  821 */     for (int i = 0; i < liste.size(); i++) {
/*  822 */       Attribut2 att = (Attribut2)liste.get(i);
/*  823 */       if ((att.getKey().equals(Parametres.Cle)) && (att.isForeingKey())) {
/*  824 */         l.add(att);
/*      */       }
/*      */     }
/*  827 */     return l;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> getAttributUnique(ArrayList<Attribut> liste) {
/*  831 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  833 */     for (int i = 0; i < liste.size(); i++) {
/*  834 */       Attribut2 att = (Attribut2)liste.get(i);
/*  835 */       if (att.getKey().equals(Parametres.Unique)) {
/*  836 */         l.add(att);
/*      */       }
/*      */     }
/*  839 */     return l;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> getAttributIndex(ArrayList<Attribut> liste) {
/*  843 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  845 */     for (int i = 0; i < liste.size(); i++) {
/*  846 */       Attribut2 att = (Attribut2)liste.get(i);
/*  847 */       if (att.getKey().equals(Parametres.Index)) {
/*  848 */         l.add(att);
/*      */       }
/*      */     }
/*  851 */     return l;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> getAttributNonCle(ArrayList<Attribut> liste) {
/*  855 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  857 */     for (int i = 0; i < liste.size(); i++) {
/*  858 */       Attribut2 att = (Attribut2)liste.get(i);
/*  859 */       if (att.getKey().trim().length() == 0) {
/*  860 */         l.add(att);
/*      */       }
/*      */     }
/*  863 */     return l;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> getAttributNonCleH(ArrayList<Attribut> liste) {
/*  867 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  869 */     for (int i = 0; i < liste.size(); i++) {
/*  870 */       Attribut2 att = (Attribut2)liste.get(i);
/*  871 */       if (!att.getKey().equals(Parametres.Cle)) {
/*  872 */         l.add(att);
/*      */       }
/*      */     }
/*  875 */     return l;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void convertirEntiteEnMLD(ArrayList<IhmEntiteRelation> liste)
/*      */   {
/*  885 */     for (int i = 0; i < liste.size(); i++) {
/*  886 */       if ((liste.get(i) instanceof IhmEntite2)) {
/*  887 */         IhmEntite2 ent = (IhmEntite2)liste.get(i);
/*      */         
/*  889 */         MLDEntite2 mld = new MLDEntite2("", ent.getX(), ent.getY(), 0, 0, ent.isVariable());
/*  890 */         mld.setNom(ent.getEntite().getNom());
/*  891 */         mld.setCode(((Entite2)ent.getEntite()).getCode());
/*  892 */         mld.setCommentaire(ent.getEntite().getCommentaire());
/*      */         
/*  894 */         setProprieteMLDEntite(mld, ent);
/*  895 */         ArrayList<Attribut> l = getAttributEntiteRelation(ent);
/*      */         
/*  897 */         mld.setListeAttributs(l);
/*  898 */         this.listeCorrespondance.put(ent, mld);
/*  899 */         this.listeMLDEntite.add(mld);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void setCleAllEntiteHeritageRelatif(ArrayList<IhmEntiteRelation> listeEnt, ArrayList<IhmLienHeritage> listeHeritage, ArrayList<IhmLien> listeLien)
/*      */   {
/*  907 */     for (int i = 0; i < listeEnt.size(); i++) {
/*  908 */       if ((listeEnt.get(i) instanceof IhmEntite2)) {
/*  909 */         getAllCleEntite((IhmEntite2)listeEnt.get(i), listeHeritage, listeLien);
/*      */       }
/*      */     }
/*  912 */     if (this.listeReference.size() == 0) { return;
/*      */     }
/*  914 */     traiterAllReferences();
/*      */     
/*  916 */     setSQLGenereFalseReferences();
/*      */     
/*  918 */     setPrimaryKeyAllMLEntite();
/*      */     
/*  920 */     ajouterAllLienRelatif();
/*      */     
/*  922 */     affecterAllContrainteReferenceForEntite();
/*      */     
/*  924 */     traiterAllMLDEntiteAttribut();
/*      */   }
/*      */   
/*      */   private void setSQLGeneratedListeMLDEntite(ArrayList<MLDEntite2> liste, boolean val)
/*      */   {
/*  929 */     for (int i = 0; i < liste.size(); i++) {
/*  930 */       ((MLDEntite2)liste.get(i)).setSQLGenerer(val);
/*      */     }
/*      */   }
/*      */   
/*      */   private MLDEntite2 getNextMLDEntiteRef(ArrayList<MLDEntite2> liste)
/*      */   {
/*  936 */     boolean satisfait = false;
/*  937 */     for (int i = 0; i < liste.size(); i++) {
/*  938 */       if (!((MLDEntite2)liste.get(i)).isSQLGenerer()) {
/*  939 */         ArrayList<TableReference> tRef = ((MLDEntite2)liste.get(i)).getListeCNTForeingKey();
/*  940 */         satisfait = true;
/*      */         
/*  942 */         for (int j = 0; j < tRef.size(); j++) {
/*  943 */           if (!((TableReference)tRef.get(j)).getEntiteRef().isSQLGenerer()) {
/*  944 */             satisfait = false;
/*  945 */             break;
/*      */           }
/*      */         }
/*  948 */         if (satisfait) {
/*  949 */           return (MLDEntite2)liste.get(i);
/*      */         }
/*      */       }
/*      */     }
/*  953 */     return null;
/*      */   }
/*      */   
/*      */   private AttributReference getAttributRef(ArrayList<AttributReference> liste, Attribut att) {
/*  957 */     for (int i = 0; i < liste.size(); i++) {
/*  958 */       if (((AttributReference)liste.get(i)).getAttributRef() == att) return (AttributReference)liste.get(i);
/*      */     }
/*  960 */     return null;
/*      */   }
/*      */   
/*      */   private ArrayList<AttributReference> trierRefInterne(ArrayList<AttributReference> listeRef, ArrayList<Attribut> listeKey) {
/*  964 */     ArrayList<AttributReference> l = new ArrayList();
/*      */     
/*  966 */     for (int i = 0; i < listeKey.size(); i++) {
/*  967 */       AttributReference aRef = getAttributRef(listeRef, (Attribut)listeKey.get(i));
/*  968 */       if (aRef == null) {
/*  969 */         JOptionPane.showMessageDialog(this.pageMCD, "Erreur trierRefInterne dans Transformation");
/*      */       } else {
/*  971 */         l.add(aRef);
/*      */       }
/*      */     }
/*      */     
/*  975 */     return l;
/*      */   }
/*      */   
/*      */   private void afficherListeAttribut(ArrayList<Attribut> liste) {
/*  979 */     for (int i = 0; i < liste.size(); i++) {
/*  980 */       System.out.println(((Attribut)liste.get(i)).getNom());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void reorganiserRefAttinterne(MLDEntite2 ent)
/*      */   {
/*  987 */     for (int i = 0; i < ent.getListeCNTForeingKey().size(); i++) {
/*  988 */       TableReference tab = (TableReference)ent.getListeCNTForeingKey().get(i);
/*  989 */       ArrayList<Attribut> lAtt = new ArrayList();
/*      */       
/*  991 */       getListeAttributCle(lAtt, tab.getEntiteRef().getListeAttributs());
/*  992 */       tab.setListeAttributRef(trierRefInterne(tab.getListeAttributRef(), lAtt));
/*  993 */       afficherListeAttribut(lAtt);
/*      */     }
/*      */   }
/*      */   
/*      */   private void reorganiserInterneAllRefMLDEntite2() {
/*  998 */     setSQLGeneratedListeMLDEntite(this.listeMLDEntite, true);
/*      */     
/* 1000 */     ArrayList<MLDEntite2> l = getlisteMLDEntiteAvecREf();
/* 1001 */     setSQLGeneratedListeMLDEntite(l, false);
/* 1002 */     MLDEntite2 ent = getNextMLDEntiteRef(l);
/*      */     
/* 1004 */     while (ent != null) {
/* 1005 */       reorganiserRefAttinterne(ent);
/* 1006 */       organiserAttMLDentite(ent);
/* 1007 */       ent.setSQLGenerer(true);
/* 1008 */       ent = getNextMLDEntiteRef(l);
/*      */     }
/* 1010 */     setSQLGeneratedListeMLDEntite(this.listeMLDEntite, false);
/*      */   }
/*      */   
/*      */   private ArrayList<MLDEntite2> getlisteMLDEntiteAvecREf()
/*      */   {
/* 1015 */     ArrayList<MLDEntite2> l = new ArrayList();
/* 1016 */     for (int i = 0; i < this.listeMLDEntite.size(); i++) {
/* 1017 */       if (((MLDEntite2)this.listeMLDEntite.get(i)).getListeCNTForeingKey().size() > 0) {
/* 1018 */         l.add(this.listeMLDEntite.get(i));
/*      */       }
/*      */     }
/* 1021 */     return l;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> getlisteAttributRef(TableReference ref) {
/* 1025 */     ArrayList<Attribut> listeAtt = new ArrayList();
/* 1026 */     for (int i = 0; i < ref.getListeAttributRef().size(); i++) {
/* 1027 */       listeAtt.add(((AttributReference)ref.getListeAttributRef().get(i)).getAttribut());
/*      */     }
/* 1029 */     return listeAtt;
/*      */   }
/*      */   
/*      */   private void fusionListeAttributRef(ArrayList<Attribut> liste1, ArrayList<Attribut> liste2)
/*      */   {
/* 1034 */     boolean existe = false;
/* 1035 */     for (int i = 0; i < liste2.size(); i++) {
/* 1036 */       Attribut att2 = (Attribut)liste2.get(i);
/* 1037 */       existe = false;
/* 1038 */       for (int j = 0; j < liste1.size(); j++) {
/* 1039 */         Attribut att1 = (Attribut)liste1.get(j);
/* 1040 */         if (att2 == att1) {
/* 1041 */           existe = true;
/* 1042 */           break;
/*      */         }
/*      */       }
/* 1045 */       if (!existe) {
/* 1046 */         liste1.add(att2);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void organiserAttMLDentite(MLDEntite2 ent) {
/* 1052 */     ArrayList<Attribut> lAtt = new ArrayList();
/* 1053 */     ArrayList<Attribut> liste = new ArrayList();
/* 1054 */     for (int i = 0; i < ent.getListeCNTForeingKey().size(); i++) {
/* 1055 */       lAtt = getlisteAttributRef((TableReference)ent.getListeCNTForeingKey().get(i));
/* 1056 */       fusionListeAttributRef(liste, lAtt);
/*      */     }
/* 1058 */     lAtt = ent.getListeAttributs();
/* 1059 */     fusionListeAttributRef(liste, lAtt);
/* 1060 */     ent.setListeAttributs(liste);
/*      */   }
/*      */   
/*      */   private void traiterAllMLDEntiteAttribut() {
/* 1064 */     reorganiserInterneAllRefMLDEntite2();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void transformerAllRelation()
/*      */   {
/* 1071 */     TransformationRelation.listeCorrespondance = this.listeCorrespondance;
/* 1072 */     TransformationRelation.listeMLDEntite = this.listeMLDEntite;
/* 1073 */     TransformationRelation.listeMLDLien = this.listeMLDLien;
/*      */     
/* 1075 */     TransformationRelation.listeRelationLien = this.listeRelationLien;
/* 1076 */     TransformationRelation.pageMCD = this.pageMCD;
/* 1077 */     for (int i = 0; i < this.listeRelationLien.size(); i++)
/*      */     {
/*      */ 
/* 1080 */       boolean rep = TransformationRelation.transformerRelationGroupe0((MLDRelationLien)this.listeRelationLien.get(i));
/* 1081 */       if (!rep) {
/* 1082 */         if (((MLDRelationLien)this.listeRelationLien.get(i)).getGroupeRelation() == MLDRelationLien.GROUPE_UN) {
/* 1083 */           rep = TransformationRelation.transformerRelationGroupe1((MLDRelationLien)this.listeRelationLien.get(i));
/*      */         }
/* 1085 */         else if (((MLDRelationLien)this.listeRelationLien.get(i)).getGroupeRelation() == MLDRelationLien.GROUPE_DEUX) {
/* 1086 */           rep = TransformationRelation.transformerRelationGroupe2((MLDRelationLien)this.listeRelationLien.get(i));
/*      */         }
/* 1088 */         else if (((MLDRelationLien)this.listeRelationLien.get(i)).getGroupeRelation() == MLDRelationLien.GROUPE_TROIS) {
/* 1089 */           rep = TransformationRelation.transformerRelationGroupe3((MLDRelationLien)this.listeRelationLien.get(i));
/*      */         }
/* 1091 */         else if (((MLDRelationLien)this.listeRelationLien.get(i)).getGroupeRelation() == MLDRelationLien.GROUPE_QUATRE) {
/* 1092 */           rep = TransformationRelation.transformerRelationGroupe4((MLDRelationLien)this.listeRelationLien.get(i));
/*      */         }
/* 1094 */         else if (((MLDRelationLien)this.listeRelationLien.get(i)).getGroupeRelation() == MLDRelationLien.GROUPE_CINQ) {
/* 1095 */           rep = TransformationRelation.transformerRelationGroupe5((MLDRelationLien)this.listeRelationLien.get(i));
/*      */ 
/*      */         }
/* 1098 */         else if (((MLDRelationLien)this.listeRelationLien.get(i)).getGroupeRelation() == MLDRelationLien.GROUPE_SIX) {
/* 1099 */           rep = TransformationRelation.transformerRelationGroupe6((MLDRelationLien)this.listeRelationLien.get(i));
/*      */         }
/*      */       }
/*      */       
/* 1103 */       if (!rep) {
/* 1104 */         JOptionPane.showConfirmDialog(new JFrame(), "GRAVE : Il faut le signaler : La relation " + ((MLDRelationLien)this.listeRelationLien.get(i)).getRelation().getRelation().getNom() + " n'est pas convertie", "Conversion du MCD ", -1, 0);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void ajouterLienHeritage(ArrayList<IhmLienHeritage> liste, ArrayList<IhmLienContrainteHeritage> listeCntH)
/*      */   {
/* 1113 */     String nom = "";
/* 1114 */     for (int i = 0; i < liste.size(); i++) {
/* 1115 */       IhmLienHeritage2 her = (IhmLienHeritage2)liste.get(i);
/* 1116 */       MLDEntite2 fils = (MLDEntite2)this.listeCorrespondance.get(her.getFils());
/* 1117 */       MLDEntite2 pere = (MLDEntite2)this.listeCorrespondance.get(her.getPere());
/* 1118 */       nom = getNomHeritage(listeCntH, fils, pere);
/* 1119 */       nom = nom.trim().length() == 0 ? "Héritage" : nom;
/* 1120 */       MLDLienEntite2 lien = new MLDLienEntite2(fils, pere);
/* 1121 */       lien.setNom(nom);
/* 1122 */       lien.setFleche(true);
/* 1123 */       this.listeMLDLien.add(lien);
/*      */     }
/*      */   }
/*      */   
/*      */   public void structurerAttribut(IhmPageMLD page) {
/* 1128 */     if (Setting.MLDStructurerAtt2) {
/* 1129 */       composerAttributAllMLDEntite(page.getListeMLDEntite());
/*      */     }
/*      */   }
/*      */   
/*      */   public void setMLDEntiteDansPageMLD(IhmPageMLD page, double zoom) {
/* 1134 */     page.setListeMLDEntite(this.listeMLDEntite);
/* 1135 */     page.setListeLien(this.listeMLDLien);
/* 1136 */     page.setZoom(zoom);
/* 1137 */     page.setClPage(this.pageMCD.clPage);
/* 1138 */     page.setMutex(this.mutex);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private MLDEntite2 getMLDEntite(String nomEnt)
/*      */   {
/* 1148 */     nomEnt = nomEnt.trim().toUpperCase();
/*      */     
/* 1150 */     for (int i = 0; i < this.listeMLDEntite.size(); i++) {
/* 1151 */       String nom = ((MLDEntite2)this.listeMLDEntite.get(i)).getNom().trim().toUpperCase();
/* 1152 */       if (nom.equals(nomEnt)) { return (MLDEntite2)this.listeMLDEntite.get(i);
/*      */       }
/*      */     }
/* 1155 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private ArrayList<MLDReference2> getListReference(MLDEntite2 ent, MLDEntite2 entRef)
/*      */   {
/* 1170 */     ArrayList<MLDReference2> liste = new ArrayList();
/*      */     
/* 1172 */     for (int i = 0; i < this.listeReference.size(); i++) {
/* 1173 */       MLDReference2 ref = (MLDReference2)this.listeReference.get(i);
/* 1174 */       if ((!ref.iSSQLGenerer()) && 
/* 1175 */         (ref.getEntite() == ent) && (ref.getEntiteRef() == entRef)) {
/* 1176 */         liste.add(ref);
/* 1177 */         ref.setSQLGenerer(true);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1182 */     return liste;
/*      */   }
/*      */   
/*      */   private MLDReference2 getFirstReference() {
/* 1186 */     for (int i = 0; i < this.listeReference.size(); i++) {
/* 1187 */       if (!((MLDReference2)this.listeReference.get(i)).iSSQLGenerer()) return (MLDReference2)this.listeReference.get(i);
/*      */     }
/* 1189 */     return null;
/*      */   }
/*      */   
/*      */   private void creerTableReference(MLDReference2 ref) {
/* 1193 */     TableReference tab = new TableReference(ref.getEntiteRef().getNom(), "FOREING KEY");
/* 1194 */     tab.setOrigine("HR");
/* 1195 */     tab.setEntite(ref.getEntite());
/* 1196 */     tab.setEntiteRef(ref.getEntiteRef());
/*      */     
/* 1198 */     ArrayList<MLDReference2> liste = getListReference(ref.getEntite(), ref.getEntiteRef());
/*      */     
/* 1200 */     for (int i = 0; i < liste.size(); i++) {
/* 1201 */       tab.addReference(((MLDReference2)liste.get(i)).getAttribut(), ((MLDReference2)liste.get(i)).getAttributRef());
/*      */     }
/* 1203 */     ref.getEntite().getListeCNTForeingKey().add(tab);
/*      */   }
/*      */   
/*      */ 
/*      */   private void affecterAllContrainteReferenceForEntite()
/*      */   {
/* 1209 */     MLDReference2 ref = getFirstReference();
/*      */     
/* 1211 */     while (ref != null) {
/* 1212 */       creerTableReference(ref);
/* 1213 */       ref = getFirstReference();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private static boolean possibleFusiondirect(ArrayList<Attribut> liste, ArrayList<Attribut> liste2)
/*      */   {
/* 1221 */     for (int i = 0; i < liste2.size(); i++) {
/* 1222 */       if (existeAttributDansListe(liste, ((Attribut)liste2.get(i)).getNom())) return false;
/*      */     }
/* 1224 */     return true;
/*      */   }
/*      */   
/*      */   private static boolean existeAttributDansListe(ArrayList<Attribut> liste, String nomAtt)
/*      */   {
/* 1229 */     nomAtt = nomAtt.trim().toUpperCase();
/* 1230 */     for (int i = 0; i < liste.size(); i++) {
/* 1231 */       String n = ((Attribut)liste.get(i)).getNom().trim().toUpperCase();
/* 1232 */       if (nomAtt.equals(n)) return true;
/*      */     }
/* 1234 */     return false;
/*      */   }
/*      */   
/*      */   private static void fusionListeAttributSansRedandonceDirect(ArrayList<Attribut> liste, ArrayList<Attribut> listeA) {
/* 1238 */     for (int i = 0; i < listeA.size(); i++) {
/* 1239 */       liste.add(listeA.get(i));
/*      */     }
/*      */   }
/*      */   
/*      */   private static String getNomEntiteH(String nom) {
/* 1244 */     String n = "";
/* 1245 */     n = nom.substring(0, nom.indexOf("¤"));
/* 1246 */     return n;
/*      */   }
/*      */   
/*      */ 
/*      */   private static void fusionListeAttributSansRedandonce(ArrayList<Attribut> liste, ArrayList<Attribut> listeA)
/*      */   {
/* 1252 */     int nb = 1;
/*      */     
/*      */ 
/* 1255 */     if (possibleFusiondirect(liste, listeA)) {
/* 1256 */       fusionListeAttributSansRedandonceDirect(liste, listeA);
/* 1257 */       return;
/*      */     }
/*      */     
/* 1260 */     for (int i = 0; i < listeA.size(); i++) {
/* 1261 */       Attribut2 att = (Attribut2)listeA.get(i);
/* 1262 */       String nom = att.getNom();
/* 1263 */       String n = nom;
/* 1264 */       String c = att.getCode();
/* 1265 */       if (existeAttributDansListe(liste, nom)) {
/* 1266 */         nom = nom + (getNomEntiteH(att.getAugmentation()).length() > 0 ? "_" + getNomEntiteH(att.getAugmentation()) : "");
/* 1267 */         if (existeAttributDansListe(liste, nom))
/*      */         {
/*      */ 
/* 1270 */           if (existeAttributDansListe(liste, nom)) {
/* 1271 */             while (existeAttributDansListe(liste, nom)) {
/* 1272 */               nom = nom + "_" + nb;
/*      */               
/* 1274 */               nb++;
/*      */             }
/* 1276 */             att.setNom(nom);
/* 1277 */             nom = nom.substring(n.length(), nom.length());
/* 1278 */             att.setCode((att.getCode() + nom).toUpperCase());
/* 1279 */             liste.add(att);
/*      */           } else {
/* 1281 */             att.setNom(nom);
/* 1282 */             nom = nom.substring(n.length(), nom.length());
/* 1283 */             att.setCode((att.getCode() + nom).toUpperCase());
/* 1284 */             liste.add(att);
/*      */           }
/*      */         } else {
/* 1287 */           att.setNom(nom);
/* 1288 */           nom = nom.substring(n.length(), nom.length());
/* 1289 */           att.setCode((att.getCode() + nom).toUpperCase());
/* 1290 */           liste.add(att);
/*      */         }
/*      */       } else {
/* 1293 */         att.setNom(nom);
/* 1294 */         att.setCode(c.toUpperCase());
/* 1295 */         liste.add(att);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private ArrayList<TableReference> getContrainteFK_Heritage(MLDEntite2 mld)
/*      */   {
/* 1304 */     ArrayList<TableReference> liste = new ArrayList();
/* 1305 */     for (int i = 0; i < mld.getListeCNTForeingKey().size(); i++) {
/* 1306 */       if (((TableReference)mld.getListeCNTForeingKey().get(i)).getOrigine().equals("RELATION")) {
/* 1307 */         liste.add(mld.getListeCNTForeingKey().get(i));
/*      */       }
/*      */     }
/* 1310 */     return liste;
/*      */   }
/*      */   
/*      */   private ArrayList<TableReference> getContrainteAK_Heritage(MLDEntite2 mld) {
/* 1314 */     ArrayList<TableReference> liste = new ArrayList();
/*      */     
/* 1316 */     for (int i = 0; i < mld.getListeCNTALTERNATIVEKEY().size(); i++) {
/* 1317 */       if (((TableReference)mld.getListeCNTALTERNATIVEKEY().get(i)).getOrigine().equals("RELATION")) {
/* 1318 */         liste.add(mld.getListeCNTALTERNATIVEKEY().get(i));
/*      */       }
/*      */     }
/* 1321 */     return liste;
/*      */   }
/*      */   
/*      */   private void fusionListeContrainte(ArrayList<TableReference> liste, ArrayList<TableReference> liste1) {
/* 1325 */     liste1 = doublerListeTableReference(liste1);
/* 1326 */     for (int i = 0; i < liste1.size(); i++) {
/* 1327 */       liste.add(liste1.get(i));
/*      */     }
/*      */   }
/*      */   
/*      */   private void setAugmentationListeAttributNom(ArrayList<Attribut> liste, String nom)
/*      */   {
/* 1333 */     for (int i = 0; i < liste.size(); i++) {
/* 1334 */       Attribut2 att = (Attribut2)liste.get(i);
/* 1335 */       att.setAugmentation(nom);
/*      */     }
/*      */   }
/*      */   
/*      */   private void changerAttributDansTableRef(Attribut newAtt, Attribut oldAtt, ArrayList<AttributReference> listeAtt) {
/* 1340 */     for (int i = 0; i < listeAtt.size(); i++) {
/* 1341 */       if (((AttributReference)listeAtt.get(i)).getAttribut() == oldAtt) {
/* 1342 */         ((AttributReference)listeAtt.get(i)).setAttribut(newAtt);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void changerAttributDansListeTableRef(Attribut newAtt, Attribut oldAtt, ArrayList<TableReference> listeTabe) {
/* 1348 */     for (int i = 0; i < listeTabe.size(); i++) {
/* 1349 */       changerAttributDansTableRef(newAtt, oldAtt, ((TableReference)listeTabe.get(i)).getListeAttributRef());
/*      */     }
/*      */   }
/*      */   
/*      */   private void changerMLDEntiteDansListeTableRef(MLDEntite2 newEnt, ArrayList<TableReference> listeTab) {
/* 1354 */     for (int i = 0; i < listeTab.size(); i++) {
/* 1355 */       ((TableReference)listeTab.get(i)).setEntite(newEnt);
/*      */     }
/*      */   }
/*      */   
/*      */   private ArrayList<AttributReference> doublerListeAttributDansTableRef(ArrayList<AttributReference> listeAtt) {
/* 1360 */     ArrayList<AttributReference> l = new ArrayList();
/*      */     
/* 1362 */     for (int i = 0; i < listeAtt.size(); i++) {
/* 1363 */       AttributReference att = new AttributReference(((AttributReference)listeAtt.get(i)).getAttribut(), ((AttributReference)listeAtt.get(i)).getAttributRef());
/* 1364 */       l.add(att);
/*      */     }
/* 1366 */     return l;
/*      */   }
/*      */   
/*      */   private ArrayList<TableReference> doublerListeTableReference(ArrayList<TableReference> listetab) {
/* 1370 */     ArrayList<TableReference> l = new ArrayList();
/*      */     
/* 1372 */     for (int i = 0; i < listetab.size(); i++) {
/* 1373 */       TableReference tab = new TableReference(((TableReference)listetab.get(i)).getNom(), ((TableReference)listetab.get(i)).getType(), ((TableReference)listetab.get(i)).getEntite(), ((TableReference)listetab.get(i)).getEntiteRef());
/* 1374 */       tab.setListeAttributRef(doublerListeAttributDansTableRef(((TableReference)listetab.get(i)).getListeAttributRef()));
/* 1375 */       l.add(tab);
/*      */     }
/* 1377 */     return l;
/*      */   }
/*      */   
/*      */   private void getListeAttributHeritage(IhmEntite2 ent, ArrayList<IhmLienHeritage> listeHeritage, ArrayList<Attribut> listeAtt, ArrayList<TableReference> listeCntFK, ArrayList<TableReference> listeCntAK, String chemin) {
/* 1381 */     ArrayList<IhmEntiteRelation> peres = getPeres(ent, listeHeritage);
/* 1382 */     ArrayList<Attribut> listeAttPere = new ArrayList();
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1387 */     for (int i = 0; i < peres.size(); i++) {
/* 1388 */       MLDEntite2 mldPere = (MLDEntite2)this.listeCorrespondance.get(peres.get(i));
/* 1389 */       listeAttPere = getAttributNonCleH(mldPere.getListeAttributs());
/* 1390 */       setAugmentationListeAttributNom(listeAttPere, chemin + mldPere.getNom() + "¤");
/* 1391 */       fusionListeAttribut(listeAtt, listeAttPere);
/* 1392 */       ArrayList<TableReference> listeFK = getContrainteFK_Heritage(mldPere);
/* 1393 */       fusionListeContrainte(listeCntFK, listeFK);
/* 1394 */       ArrayList<TableReference> listeAK = getContrainteAK_Heritage(mldPere);
/* 1395 */       fusionListeContrainte(listeCntAK, listeAK);
/* 1396 */       listeAttPere.clear();
/* 1397 */       getListeAttributHeritage((IhmEntite2)peres.get(i), listeHeritage, listeAtt, listeCntFK, listeCntAK, chemin + mldPere.getNom() + "¤");
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void sauvegarderListeAttributH(MLDEntite2 ent, ArrayList<Attribut> listeAtt, ArrayList<TableReference> listeFK, ArrayList<TableReference> listeAK)
/*      */   {
/* 1409 */     ArrayList<Attribut> l = new ArrayList();
/* 1410 */     for (int i = 0; i < listeAtt.size(); i++) {
/* 1411 */       Attribut2 oAtt = (Attribut2)listeAtt.get(i);
/* 1412 */       Attribut2 nAtt = (Attribut2)oAtt.copier();
/* 1413 */       changerAttributDansListeTableRef(nAtt, oAtt, listeAK);
/* 1414 */       changerAttributDansListeTableRef(nAtt, oAtt, listeFK);
/* 1415 */       l.add(nAtt);
/*      */     }
/* 1417 */     changerMLDEntiteDansListeTableRef(ent, listeAK);
/* 1418 */     changerMLDEntiteDansListeTableRef(ent, listeFK);
/* 1419 */     this.correspondanceAttribut.put(ent, l);
/* 1420 */     this.correspondanceCntAK.put(ent, listeAK);
/* 1421 */     this.correspondanceCntFK.put(ent, listeFK);
/*      */   }
/*      */   
/*      */   private ArrayList<IhmEntiteRelation> getListeFils(ArrayList<IhmLienHeritage> listeHeritage) {
/* 1425 */     ArrayList<IhmEntiteRelation> l = new ArrayList();
/* 1426 */     for (int i = 0; i < listeHeritage.size(); i++) {
/* 1427 */       if (!existeEntiteListe(((IhmLienHeritage2)listeHeritage.get(i)).getFils(), l)) {
/* 1428 */         l.add(((IhmLienHeritage2)listeHeritage.get(i)).getFils());
/*      */       }
/*      */     }
/* 1431 */     return l;
/*      */   }
/*      */   
/*      */   private boolean existeEntiteListe(IhmEntiteRelation ent, ArrayList<IhmEntiteRelation> liste) {
/* 1435 */     for (int i = 0; i < liste.size(); i++) {
/* 1436 */       if (liste.get(i) == ent) return true;
/*      */     }
/* 1438 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   public void importerAttributHeritage(ArrayList<IhmLienHeritage> listeHeritage)
/*      */   {
/* 1444 */     if (!Setting.attMere) return;
/* 1445 */     ArrayList<IhmEntiteRelation> l = getListeFils(listeHeritage);
/* 1446 */     if (l.size() == 0) { return;
/*      */     }
/*      */     
/*      */ 
/* 1450 */     for (int i = 0; i < l.size(); i++) {
/* 1451 */       ArrayList<Attribut> listeAtt = new ArrayList();
/* 1452 */       ArrayList<TableReference> listeFK = new ArrayList();
/* 1453 */       ArrayList<TableReference> listeAK = new ArrayList();
/* 1454 */       getListeAttributHeritage((IhmEntite2)l.get(i), listeHeritage, listeAtt, listeFK, listeAK, "");
/* 1455 */       sauvegarderListeAttributH((MLDEntite2)this.listeCorrespondance.get(l.get(i)), listeAtt, listeFK, listeAK);
/*      */     }
/*      */     
/* 1458 */     for (int i = 0; i < l.size(); i++) {
/* 1459 */       MLDEntite2 mld = (MLDEntite2)this.listeCorrespondance.get(l.get(i));
/* 1460 */       ArrayList<TableReference> listeFK = (ArrayList)this.correspondanceCntFK.get(mld);
/* 1461 */       fusionListeContrainte(mld.getListeCNTForeingKey(), listeFK);
/* 1462 */       ArrayList<TableReference> listeAK = (ArrayList)this.correspondanceCntAK.get(mld);
/* 1463 */       fusionListeContrainte(mld.getListeCNTALTERNATIVEKEY(), listeAK);
/* 1464 */       ArrayList<Attribut> listeAtt = (ArrayList)this.correspondanceAttribut.get(mld);
/* 1465 */       fusionListeAttributSansRedandonce(mld.getListeAttributs(), listeAtt);
/*      */     }
/* 1467 */     this.listeReference.clear();
/* 1468 */     this.correspondanceAttribut.clear();
/* 1469 */     this.correspondanceCntAK.clear();
/* 1470 */     this.correspondanceCntFK.clear();
/* 1471 */     System.gc();
/*      */   }
/*      */   
/*      */   private boolean isReferentMLDEntite(MLDEntite2 mld)
/*      */   {
/* 1476 */     boolean rep = false;
/*      */     
/*      */ 
/* 1479 */     ArrayList<TableReference> liste = mld.getListeCNTForeingKey();
/* 1480 */     for (int i = 0; i < liste.size(); i++) {
/* 1481 */       MLDEntite2 mldRef = ((TableReference)liste.get(i)).getEntiteRef();
/* 1482 */       if (!mldRef.isSQLGenerer()) {
/* 1483 */         return true;
/*      */       }
/*      */     }
/* 1486 */     liste = mld.getListeCNTALTERNATIVEKEY();
/* 1487 */     for (int i = 0; i < liste.size(); i++) {
/* 1488 */       MLDEntite2 mldRef = ((TableReference)liste.get(i)).getEntiteRef();
/* 1489 */       if (!mldRef.isSQLGenerer()) {
/* 1490 */         return true;
/*      */       }
/*      */     }
/* 1493 */     return false;
/*      */   }
/*      */   
/*      */   private MLDEntite2 getFisrtMLDEntite() {
/* 1497 */     for (int i = 0; i < this.listeMLDEntite.size(); i++) {
/* 1498 */       if ((!((MLDEntite2)this.listeMLDEntite.get(i)).isSQLGenerer()) && 
/* 1499 */         (!isReferentMLDEntite((MLDEntite2)this.listeMLDEntite.get(i)))) {
/* 1500 */         return (MLDEntite2)this.listeMLDEntite.get(i);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1505 */     return null;
/*      */   }
/*      */   
/*      */   private void setExclusionMutuelleFalse() {
/* 1509 */     for (int i = 0; i < this.listeMLDEntite.size(); i++) {
/* 1510 */       if (!((MLDEntite2)this.listeMLDEntite.get(i)).isSQLGenerer()) {
/* 1511 */         ((MLDEntite2)this.listeMLDEntite.get(i)).setMutex(false);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void ordonnerMLDEntite() {
/* 1517 */     if (this.listeMLDEntite.size() == 0) { return;
/*      */     }
/* 1519 */     ArrayList<MLDEntite2> liste = new ArrayList();
/*      */     
/* 1521 */     MLDEntite2 mld = getFisrtMLDEntite();
/* 1522 */     while (mld != null)
/*      */     {
/* 1524 */       liste.add(mld);
/* 1525 */       mld.setSQLGenerer(true);
/* 1526 */       mld = getFisrtMLDEntite();
/*      */     }
/*      */     
/* 1529 */     setExclusionMutuelleFalse();
/*      */     
/* 1531 */     for (int i = 0; i < this.listeMLDEntite.size(); i++) {
/* 1532 */       if (!((MLDEntite2)this.listeMLDEntite.get(i)).isSQLGenerer()) {
/* 1533 */         ((MLDEntite2)this.listeMLDEntite.get(i)).setMutex(true);
/* 1534 */         liste.add(this.listeMLDEntite.get(i));
/* 1535 */         this.mutex = true;
/*      */       }
/*      */     }
/*      */     
/* 1539 */     for (int i = 0; i < liste.size(); i++) {
/* 1540 */       ((MLDEntite2)liste.get(i)).setSQLGenerer(false);
/*      */     }
/*      */     
/* 1543 */     this.listeMLDEntite.clear();
/* 1544 */     this.listeMLDEntite = liste;
/*      */   }
/*      */   
/*      */   public void corrigerTypeDesCle() {
/* 1548 */     for (int i = 0; i < this.listeMLDEntite.size(); i++) {
/* 1549 */       ((MLDEntite2)this.listeMLDEntite.get(i)).corrigerLesTypesDesCles();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\vConversion\Transformation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */