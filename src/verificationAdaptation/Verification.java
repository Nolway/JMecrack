/*     */ package verificationAdaptation;
/*     */ 
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmLien;
/*     */ import IhmMCD.IhmLienHeritage;
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmLien2;
/*     */ import IhmMCD2.IhmLienHeritage2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import IhmMLD2.MLDRelationLien;
/*     */ import Merise.Attribut;
/*     */ import Merise.Domaine;
/*     */ import Merise.Entite;
/*     */ import Merise.Relation;
/*     */ import Merise2.Attribut2;
/*     */ import Merise2.Entite2;
/*     */ import Merise2.Relation2;
/*     */ import Outil.Setting;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Verification
/*     */ {
/*  31 */   public static ArrayList<MLDRelationLien> listeRelationLien = new ArrayList();
/*     */   
/*     */   public static void afficherListeRelationLien()
/*     */   {
/*  35 */     for (int i = 0; i < listeRelationLien.size(); i++) {
/*  36 */       System.out.println(listeRelationLien.get(i));
/*     */     }
/*     */   }
/*     */   
/*     */   public static void preparerLaVerification(ArrayList<IhmEntiteRelation> listeEntRel, ArrayList<IhmLien> listeLien) {
/*  41 */     listeRelationLien = new ArrayList();
/*  42 */     traiterAugmentationAllEntiteRelation(listeEntRel);
/*  43 */     construireLienAllRelation(listeEntRel, listeLien);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static void effacerAugmentation(ArrayList<Attribut> list)
/*     */   {
/*  50 */     for (int i = 0; i < list.size(); i++) {
/*  51 */       Attribut2 att = (Attribut2)list.get(i);
/*  52 */       att.setAugmentation("");
/*  53 */       if (att.getListeAttributs().size() > 0) {
/*  54 */         effacerAugmentation(att.getListeAttributs());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void effacerAugmentation(IhmEntiteRelation entR) {
/*  60 */     if ((entR instanceof IhmEntite2)) {
/*  61 */       effacerAugmentation(((IhmEntite2)entR).getEntite().getListeAttributs());
/*     */     }
/*  63 */     if ((entR instanceof IhmEntite2)) {
/*  64 */       effacerAugmentation(((IhmEntite2)entR).getEntite().getListeAttributs());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void affectationAugmentationAvecNomAttribut(ArrayList<Attribut> list, String aug)
/*     */   {
/*  73 */     for (int i = 0; i < list.size(); i++) {
/*  74 */       Attribut2 att = (Attribut2)list.get(i);
/*  75 */       if (att.getListeAttributs().size() > 0)
/*     */       {
/*  77 */         affectationAugmentationAvecNomAttribut(att.getListeAttributs(), aug + att.getNom().trim() + "_");
/*     */       } else {
/*  79 */         att.setAugmentation(aug);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static String completerAugmentation(String aug) {
/*  85 */     int nb = 0;
/*  86 */     if (aug == null) {
/*  87 */       nb = Setting.augmentationNBCaractere;
/*     */     }
/*  89 */     if (aug.trim().length() == 0)
/*     */     {
/*  91 */       nb = Setting.augmentationNBCaractere;
/*     */     }
/*  93 */     if (nb == 0) {
/*  94 */       nb = Setting.augmentationNBCaractere - aug.length();
/*     */     }
/*  96 */     for (int i = 0; i < nb; i++) {
/*  97 */       aug = aug + "_";
/*     */     }
/*  99 */     return aug;
/*     */   }
/*     */   
/*     */   private static String getAugmentationNBAttribut(Attribut2 att, String aug) {
/* 103 */     String x = "";
/* 104 */     if (att.getNom().trim().length() > Setting.augmentationNBCaractere) {
/* 105 */       x = aug + att.getNom().trim().substring(0, Setting.augmentationNBCaractere) + "_";
/*     */     } else {
/* 107 */       x = aug + completerAugmentation(att.getNom());
/*     */     }
/* 109 */     return x;
/*     */   }
/*     */   
/*     */ 
/*     */   private static void affectationAugmentationCaractereAttribut(ArrayList<Attribut> list, String aug)
/*     */   {
/* 115 */     for (int i = 0; i < list.size(); i++) {
/* 116 */       Attribut2 att = (Attribut2)list.get(i);
/* 117 */       if (att.getListeAttributs().size() > 0) {
/* 118 */         String a = getAugmentationNBAttribut(att, aug);
/* 119 */         affectationAugmentationCaractereAttribut(att.getListeAttributs(), a);
/*     */       } else {
/* 121 */         att.setAugmentation(aug);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void traiterAugmentationAllEntiteRelation(ArrayList<IhmEntiteRelation> list)
/*     */   {
/* 128 */     if (Setting.augmentation) {
/* 129 */       if (Setting.augmentationNomComplet) {
/* 130 */         for (int i = 0; i < list.size(); i++) {
/* 131 */           IhmEntiteRelation entRel = (IhmEntiteRelation)list.get(i);
/* 132 */           if ((entRel instanceof IhmEntite2)) {
/* 133 */             affectationAugmentationAvecNomAttribut(((IhmEntite2)entRel).getEntite().getListeAttributs(), "");
/*     */           }
/* 135 */           if ((entRel instanceof IhmRelation2)) {
/* 136 */             affectationAugmentationAvecNomAttribut(((IhmRelation2)entRel).getRelation().getListeAttributs(), "");
/*     */           }
/*     */         }
/*     */       } else {
/* 140 */         for (int i = 0; i < list.size(); i++) {
/* 141 */           IhmEntiteRelation entRel = (IhmEntiteRelation)list.get(i);
/* 142 */           if ((entRel instanceof IhmEntite2)) {
/* 143 */             affectationAugmentationCaractereAttribut(((IhmEntite2)entRel).getEntite().getListeAttributs(), "");
/*     */           }
/* 145 */           if ((entRel instanceof IhmRelation2)) {
/* 146 */             affectationAugmentationCaractereAttribut(((IhmRelation2)entRel).getRelation().getListeAttributs(), "");
/*     */           }
/*     */         }
/*     */       }
/*     */     } else {
/* 151 */       for (int i = 0; i < list.size(); i++) {
/* 152 */         effacerAugmentation((IhmEntiteRelation)list.get(i));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void traiterAugmentationEntiteRelation(IhmEntiteRelation entRel)
/*     */   {
/* 159 */     if (Setting.augmentation) {
/* 160 */       if (Setting.augmentationNomComplet) {
/* 161 */         if ((entRel instanceof IhmEntite2)) {
/* 162 */           affectationAugmentationAvecNomAttribut(((IhmEntite2)entRel).getEntite().getListeAttributs(), "");
/*     */         }
/* 164 */         if ((entRel instanceof IhmRelation2)) {
/* 165 */           affectationAugmentationAvecNomAttribut(((IhmRelation2)entRel).getRelation().getListeAttributs(), "");
/*     */         }
/*     */       }
/*     */       else {
/* 169 */         if ((entRel instanceof IhmEntite2)) {
/* 170 */           affectationAugmentationCaractereAttribut(((IhmEntite2)entRel).getEntite().getListeAttributs(), "");
/*     */         }
/* 172 */         if ((entRel instanceof IhmRelation2)) {
/* 173 */           affectationAugmentationCaractereAttribut(((IhmRelation2)entRel).getRelation().getListeAttributs(), "");
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 178 */       effacerAugmentation(entRel);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static MLDRelationLien getLienRelation(IhmRelation2 rel, ArrayList<IhmLien> listeLien)
/*     */   {
/* 186 */     MLDRelationLien MLDRel = new MLDRelationLien(rel);
/*     */     
/* 188 */     for (int i = 0; i < listeLien.size(); i++) {
/* 189 */       IhmLien2 l = (IhmLien2)listeLien.get(i);
/* 190 */       if (l.getRelation() == rel) {
/* 191 */         MLDRel.addLien(l);
/*     */       }
/*     */     }
/* 194 */     MLDRel.remplirProprietesRelation();
/* 195 */     return MLDRel;
/*     */   }
/*     */   
/*     */   private static void construireLienAllRelation(ArrayList<IhmEntiteRelation> listeEntRel, ArrayList<IhmLien> listeLien) {
/* 199 */     listeRelationLien.clear();
/*     */     
/* 201 */     for (int i = 0; i < listeEntRel.size(); i++) {
/* 202 */       if ((listeEntRel.get(i) instanceof IhmRelation2)) {
/* 203 */         MLDRelationLien rel = getLienRelation((IhmRelation2)listeEntRel.get(i), listeLien);
/* 204 */         rel.remplirProprietesRelation();
/* 205 */         listeRelationLien.add(rel);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static MLDRelationLien getLienRelation(IhmRelation2 rel) {
/* 211 */     for (int i = 0; i < listeRelationLien.size(); i++) {
/* 212 */       if (((MLDRelationLien)listeRelationLien.get(i)).getRelation() == rel) return (MLDRelationLien)listeRelationLien.get(i);
/*     */     }
/* 214 */     return null;
/*     */   }
/*     */   
/*     */   public static boolean relationManqueUnLienLien(IhmRelation2 rel) {
/* 218 */     MLDRelationLien lien = getLienRelation(rel);
/* 219 */     if (lien == null) return true;
/* 220 */     if (lien.getListLien().size() < 2) return true;
/* 221 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean isLienCorrect(IhmLien2 li) {
/* 225 */     if (li.isRelatif()) {
/* 226 */       MLDRelationLien lien = getLienRelation((IhmRelation2)li.getRelation());
/* 227 */       if (!lien.isLienRelatifCorrect()) return false;
/*     */     }
/* 229 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private static boolean existeDejaLienRelatif(IhmEntite2 ent1, IhmEntite2 ent2, MLDRelationLien rel)
/*     */   {
/* 235 */     for (int i = 0; i < listeRelationLien.size(); i++) {
/* 236 */       MLDRelationLien r = (MLDRelationLien)listeRelationLien.get(i);
/* 237 */       if ((rel.getRelation() != r.getRelation()) && 
/* 238 */         (r.isIsRelatif())) {
/* 239 */         IhmEntite2 e1 = (IhmEntite2)((IhmLien2)r.getListLien().get(0)).getEntite();
/* 240 */         IhmEntite2 e2 = (IhmEntite2)((IhmLien2)r.getListLien().get(1)).getEntite();
/* 241 */         if (((ent1 == e1) && (ent2 == e2)) || ((ent1 == e2) && (ent2 == e1)))
/*     */         {
/* 243 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 248 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private static ArrayList<IhmEntiteRelation> getRelationRelatifEntite(IhmEntite2 ent, ArrayList<IhmLien> listeLien)
/*     */   {
/* 256 */     ArrayList<IhmEntiteRelation> l = new ArrayList();
/*     */     
/* 258 */     for (int i = 0; i < listeLien.size(); i++) {
/* 259 */       IhmLien2 lien = (IhmLien2)listeLien.get(i);
/* 260 */       if ((lien.isRelatif()) && 
/* 261 */         (lien.getEntite() == ent)) {
/* 262 */         l.add(lien.getRelation());
/*     */       }
/*     */     }
/*     */     
/* 266 */     return l;
/*     */   }
/*     */   
/*     */   private static ArrayList<IhmEntiteRelation> getPeresRelatif(IhmEntite2 ent, ArrayList<IhmLien> listeLien) {
/* 270 */     ArrayList<IhmEntiteRelation> l = new ArrayList();
/* 271 */     ArrayList<IhmEntiteRelation> lsortie = new ArrayList();
/*     */     
/* 273 */     l = getRelationRelatifEntite(ent, listeLien);
/*     */     
/*     */ 
/*     */ 
/* 277 */     for (int i = 0; i < l.size(); i++) {
/* 278 */       MLDRelationLien rl = getLienRelation((IhmRelation2)l.get(i));
/* 279 */       for (int j = 0; j < rl.getListLien().size(); j++) {
/* 280 */         if (!((IhmLien2)rl.getListLien().get(j)).isRelatif()) {
/* 281 */           lsortie.add(((IhmLien2)rl.getListLien().get(j)).getEntite());
/*     */         }
/*     */       }
/*     */     }
/* 285 */     return lsortie;
/*     */   }
/*     */   
/*     */   private static boolean existeEntiteListe(ArrayList<IhmEntiteRelation> liste, IhmEntite2 ent)
/*     */   {
/* 290 */     String nom = ent.getEntite().getNom().trim().toUpperCase();
/*     */     
/* 292 */     for (int i = 0; i < liste.size(); i++) {
/* 293 */       IhmEntite2 e = (IhmEntite2)liste.get(i);
/* 294 */       if (e.getEntite().getNom().trim().toUpperCase().equals(nom)) return true;
/*     */     }
/* 296 */     return false;
/*     */   }
/*     */   
/*     */   private static ArrayList<IhmEntiteRelation> getPeres(IhmEntite2 ent, ArrayList<IhmLienHeritage> listeHeritage) {
/* 300 */     ArrayList<IhmEntiteRelation> l = new ArrayList();
/* 301 */     for (int i = 0; i < listeHeritage.size(); i++) {
/* 302 */       if (((IhmLienHeritage2)listeHeritage.get(i)).getFils() == ent) {
/* 303 */         l.add(((IhmLienHeritage2)listeHeritage.get(i)).getPere());
/*     */       }
/*     */     }
/* 306 */     return l;
/*     */   }
/*     */   
/*     */   private static ArrayList<IhmEntiteRelation> fusuionListe(ArrayList<IhmEntiteRelation> liste1, ArrayList<IhmEntiteRelation> liste2) {
/* 310 */     for (int i = 0; i < liste2.size(); i++) {
/* 311 */       liste1.add(liste2.get(i));
/*     */     }
/* 313 */     return liste1;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean existeKeyHeritageRelatif(IhmEntite2 ent, ArrayList<IhmLienHeritage> listeHeritage, ArrayList<IhmLien> listeLien)
/*     */   {
/* 338 */     ArrayList<IhmEntiteRelation> listePereH = new ArrayList();
/* 339 */     ArrayList<IhmEntiteRelation> listePereR = new ArrayList();
/*     */     
/* 341 */     boolean rep = false;
/* 342 */     listePereH = getPeres(ent, listeHeritage);
/* 343 */     listePereR = getPeresRelatif(ent, listeLien);
/* 344 */     listePereH = fusuionListe(listePereH, listePereR);
/*     */     
/* 346 */     if (listePereH.size() > 0)
/*     */     {
/* 348 */       afficherListeEntite(listePereH);
/*     */     }
/*     */     
/* 351 */     for (int i = 0; i < listePereH.size(); i++)
/*     */     {
/* 353 */       ArrayList<Attribut> listeA = VerifEntiteRelation.getKeyEntite((IhmEntite2)listePereH.get(i));
/*     */       
/* 355 */       if (listeA.size() > 0) {
/* 356 */         rep = true;
/* 357 */         break;
/*     */       }
/*     */     }
/* 360 */     if (!rep) {
/* 361 */       for (int i = 0; i < listePereH.size(); i++) {
/* 362 */         rep = existeKeyHeritageRelatif((IhmEntite2)listePereH.get(i), listeHeritage, listeLien);
/* 363 */         if (rep) { return true;
/*     */         }
/*     */       }
/*     */     }
/* 367 */     return rep;
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
/*     */   public static String verifierAllNomEntite(ArrayList<IhmEntiteRelation> liste)
/*     */   {
/* 380 */     String msg = "";
/* 381 */     for (int i = 0; i < liste.size(); i++) {
/* 382 */       if ((liste.get(i) instanceof IhmEntite2)) {
/* 383 */         IhmEntite2 ent = (IhmEntite2)liste.get(i);
/* 384 */         if (VerifEntiteRelation.entiteNomVide(ent)) {
/* 385 */           msg = msg + "\n Le nom de l'entité " + ent.getEntite().getNom() + " ne doit pas être vide ";
/*     */         }
/*     */         
/* 388 */         if (VerifEntiteRelation.entiteNomCodeReserver(ent.getEntite().getNom())) {
/* 389 */           msg = msg + "\n Le nom de l'entité " + ent.getEntite().getNom() + " est un mot réservé  ";
/*     */         }
/*     */         
/*     */ 
/* 393 */         if (VerifEntiteRelation.entiteCodeVide(ent)) {
/* 394 */           msg = msg + "\n Le code de l'entité " + ent.getEntite().getNom() + " ne doit pas être vide ";
/*     */         }
/* 396 */         if (VerifEntiteRelation.entiteNomCodeReserver(((Entite2)ent.getEntite()).getCode())) {
/* 397 */           msg = msg + "\n Le code  de l'entité " + ent.getEntite().getNom() + " est un mot réservé  ";
/*     */         }
/*     */         
/* 400 */         for (int j = i + 1; j < liste.size(); j++) {
/* 401 */           if ((liste.get(j) instanceof IhmEntite2)) {
/* 402 */             if (((IhmEntite2)liste.get(j)).getEntite().getNom().trim().toUpperCase().equals(ent.getEntite().getNom().trim().toUpperCase())) {
/* 403 */               msg = msg + "\n L'entité " + ent.getEntite().getNom() + " existe plusieurs fois dans le MCD ";
/*     */             }
/* 405 */             IhmEntite2 entj = (IhmEntite2)liste.get(j);
/* 406 */             if (((Entite2)entj.getEntite()).getCode().trim().toUpperCase().equals(((Entite2)ent.getEntite()).getCode().trim().toUpperCase())) {
/* 407 */               msg = msg + "\n L'entité " + ((Entite2)ent.getEntite()).getCode() + " son code existe plusieurs fois dans le MCD ";
/*     */             }
/*     */           }
/*     */           else {
/* 411 */             IhmRelation2 rel = (IhmRelation2)liste.get(j);
/* 412 */             MLDRelationLien lienR = getLienRelation(rel);
/* 413 */             if (!lienR.isDisparaitre()) {
/* 414 */               if (rel.getRelation().getNom().trim().toUpperCase().equals(ent.getEntite().getNom().trim().toUpperCase())) {
/* 415 */                 msg = msg + "\n L'entié " + ent.getEntite().getNom() + " existe plusieurs fois dans le MCD";
/*     */               }
/* 417 */               if (((Relation2)rel.getRelation()).getCode().trim().toUpperCase().equals(((Entite2)ent.getEntite()).getCode().trim().toUpperCase())) {
/* 418 */                 msg = msg + "\n L'entié " + ent.getEntite().getNom() + " son code existe plusieurs fois dans le MCD";
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       } else {
/* 424 */         IhmRelation2 rel = (IhmRelation2)liste.get(i);
/* 425 */         MLDRelationLien lienR = getLienRelation(rel);
/* 426 */         if (!lienR.isDisparaitre()) {
/* 427 */           if (VerifEntiteRelation.entiteNomVide(rel)) {
/* 428 */             msg = msg + "\nLe nom de la relation entre " + lienR.getListeEntite() + " ne doit pas être vide ";
/*     */           }
/*     */           
/* 431 */           if (VerifEntiteRelation.entiteNomCodeReserver(rel.getRelation().getNom())) {
/* 432 */             msg = msg + "\n Le nom de la relation " + rel.getRelation().getNom() + " est un mot réservé  ";
/*     */           }
/*     */           
/*     */ 
/* 436 */           if (VerifEntiteRelation.relationCodeVide(rel)) {
/* 437 */             msg = msg + "\n Le code de la relation  " + rel.getRelation().getNom() + " ne doit pas être vide ";
/*     */           }
/* 439 */           if (VerifEntiteRelation.entiteNomCodeReserver(((Relation2)rel.getRelation()).getCode())) {
/* 440 */             msg = msg + "\n Le code  de la relation " + rel.getRelation().getNom() + " est un mot réservé  ";
/*     */           }
/*     */           
/*     */ 
/*     */ 
/* 445 */           for (int j = i + 1; j < liste.size(); j++) {
/* 446 */             if ((liste.get(j) instanceof IhmEntite2)) {
/* 447 */               if (((IhmEntite2)liste.get(j)).getEntite().getNom().trim().toUpperCase().equals(rel.getRelation().getNom().trim().toUpperCase())) {
/* 448 */                 msg = msg + "\nLe nom de la relation " + rel.getRelation().getNom() + " existe plusieurs fois dans le MCD";
/*     */               }
/*     */             } else {
/* 451 */               IhmRelation2 rel2 = (IhmRelation2)liste.get(j);
/* 452 */               MLDRelationLien lienR2 = getLienRelation(rel2);
/* 453 */               if ((!lienR2.isDisparaitre()) && 
/* 454 */                 (rel.getRelation().getNom().trim().toUpperCase().equals(rel2.getRelation().getNom().trim().toUpperCase()))) {
/* 455 */                 msg = msg + "\nLe nom de la relation " + rel.getRelation().getNom() + " existe plusieurs fois dans le MCD";
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 464 */     return msg;
/*     */   }
/*     */   
/*     */   public static String verifierAllAttributEntite(ArrayList<IhmEntiteRelation> liste, ArrayList<Domaine> listDomaine)
/*     */   {
/* 469 */     String msg = "";String s = "";
/*     */     
/*     */ 
/*     */ 
/* 473 */     for (int i = 0; i < liste.size(); i++) {
/* 474 */       s = "";
/* 475 */       if ((liste.get(i) instanceof IhmEntite2)) {
/* 476 */         IhmEntite2 ent = (IhmEntite2)liste.get(i);
/* 477 */         s = VerifAttribut.verifierListeAttributs(ent.getEntite().getListeAttributs(), listDomaine);
/* 478 */         if (s.trim().length() > 0) {
/* 479 */           s = "\nVerification des attributs de l'entité " + ent.getEntite().getNom() + ":" + s;
/*     */         }
/*     */       }
/* 482 */       if ((liste.get(i) instanceof IhmRelation2)) {
/* 483 */         IhmRelation2 rel = (IhmRelation2)liste.get(i);
/* 484 */         s = VerifAttribut.verifierListeAttributs(rel.getRelation().getListeAttributs(), listDomaine);
/* 485 */         if (s.trim().length() > 0) {
/* 486 */           s = "\nVerification des attributs de la relation " + rel.getRelation().getNom() + ":" + s;
/*     */         }
/*     */       }
/* 489 */       msg = msg + s;
/*     */     }
/*     */     
/* 492 */     return msg;
/*     */   }
/*     */   
/*     */   public static String verifierPatteRelation()
/*     */   {
/* 497 */     String msg = "";
/*     */     
/* 499 */     for (int i = 0; i < listeRelationLien.size(); i++) {
/* 500 */       if (((MLDRelationLien)listeRelationLien.get(i)).getListLien().size() < 2) {
/* 501 */         IhmRelation2 rel = ((MLDRelationLien)listeRelationLien.get(i)).getRelation();
/* 502 */         msg = msg + "\nLa relation " + rel.getRelation().getNom() + " n'a pas suffisamment de liens";
/*     */       }
/* 504 */       if ((((MLDRelationLien)listeRelationLien.get(i)).isIsRelatif()) && 
/* 505 */         (!((MLDRelationLien)listeRelationLien.get(i)).isRelativeCorrect())) {
/* 506 */         IhmRelation2 rel = ((MLDRelationLien)listeRelationLien.get(i)).getRelation();
/* 507 */         msg = msg + "\nLe lien relatif dans la relation " + rel.getRelation().getNom() + " n'est pas correct";
/*     */       }
/*     */     }
/*     */     
/* 511 */     return msg;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String verifierCleEntite(ArrayList<IhmEntiteRelation> listeE, ArrayList<IhmLienHeritage> listeHeritage, ArrayList<IhmLien> listeLien)
/*     */   {
/* 530 */     String msg = "";
/*     */     
/* 532 */     for (int i = 0; i < listeE.size(); i++)
/*     */     {
/* 534 */       if ((listeE.get(i) instanceof IhmEntite2)) {
/* 535 */         IhmEntite2 ent = (IhmEntite2)listeE.get(i);
/* 536 */         ArrayList<Attribut> listeAtt = VerifEntiteRelation.getKeyEntite(ent);
/* 537 */         if ((listeAtt.size() == 0) && 
/* 538 */           (!VerifEntiteRelation.entiteSansLien(ent, listeLien, listeHeritage)) && 
/* 539 */           (!existeKeyHeritageRelatif(ent, listeHeritage, listeLien))) {
/* 540 */           msg = msg + "\nL'entité " + ent.getEntite().getNom() + " doit avoir un identifiant (clé primaire)";
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 547 */     return msg;
/*     */   }
/*     */   
/*     */   public static String verifierExiste2RelLienRelatif()
/*     */   {
/* 552 */     String msg = "";
/*     */     
/*     */ 
/* 555 */     for (int i = 0; i < listeRelationLien.size(); i++) {
/* 556 */       MLDRelationLien rel = (MLDRelationLien)listeRelationLien.get(i);
/* 557 */       if (rel.isIsRelatif()) {
/* 558 */         IhmEntite2 e1 = (IhmEntite2)((IhmLien2)rel.getListLien().get(0)).getEntite();
/* 559 */         IhmEntite2 e2 = (IhmEntite2)((IhmLien2)rel.getListLien().get(1)).getEntite();
/* 560 */         if (existeDejaLienRelatif(e1, e2, rel)) {
/* 561 */           msg = "\nIl existe plusieurs relations avec des liens relatifs entre " + e1.getEntite().getNom() + " et " + e2.getEntite().getNom();
/*     */         }
/*     */       }
/*     */     }
/* 565 */     return msg;
/*     */   }
/*     */   
/*     */   public static void afficherListeEntite(ArrayList<IhmEntiteRelation> liste) {
/* 569 */     for (int i = 0; i < liste.size(); i++) {
/* 570 */       if ((liste.get(i) instanceof IhmEntite2)) {
/* 571 */         System.out.println(" entite =" + ((IhmEntite2)liste.get(i)).getEntite().getNom());
/*     */       }
/* 573 */       if ((liste.get(i) instanceof IhmRelation2)) {
/* 574 */         System.out.println(" Relation =" + ((IhmRelation2)liste.get(i)).getRelation().getNom());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String verifierPageMCD(IhmPageMCD pageMcd)
/*     */   {
/* 586 */     String msg = "";
/* 587 */     String s = "";
/* 588 */     preparerLaVerification(pageMcd.getListeEntiteRelation(), pageMcd.getListeLien());
/*     */     
/*     */ 
/* 591 */     s = verifierAllNomEntite(pageMcd.getListeEntiteRelation());
/* 592 */     if (s.trim().length() > 0) {
/* 593 */       msg = msg + s;
/*     */     }
/*     */     
/* 596 */     s = verifierAllAttributEntite(pageMcd.getListeEntiteRelation(), pageMcd.getListeDomaine());
/* 597 */     if (s.trim().length() > 0) {
/* 598 */       msg = msg + s;
/*     */     }
/*     */     
/* 601 */     s = verifierPatteRelation();
/* 602 */     if (s.trim().length() > 0) {
/* 603 */       msg = msg + s;
/* 604 */       return msg;
/*     */     }
/*     */     
/* 607 */     s = verifierExiste2RelLienRelatif();
/* 608 */     if (s.trim().length() > 0) {
/* 609 */       msg = msg + s;
/* 610 */       return msg;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 619 */     s = verifierCleEntite(pageMcd.getListeEntiteRelation(), pageMcd.getListeLienHeritage(), pageMcd.getListeLien());
/* 620 */     if (s.trim().length() > 0) {
/* 621 */       msg = msg + s;
/* 622 */       return msg;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 627 */     return msg;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\verificationAdaptation\Verification.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */