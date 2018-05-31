/*     */ package IhmMLD;
/*     */ 
/*     */ import IhmMCD.IhmEntite;
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmLien;
/*     */ import IhmMCD.IhmLienHeritage;
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD.IhmRelation;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmLienHeritage2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import Merise.Attribut;
/*     */ import Merise.Entite;
/*     */ import Merise.EntiteRelation;
/*     */ import Merise.Relation;
/*     */ import Outil.Parametres;
/*     */ import Outil.Setting;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public class MLDConstruction
/*     */ {
/*     */   private ArrayList<MLDLien> listeLien;
/*     */   private ArrayList<IhmEntite> listeEntite;
/*     */   private ArrayList<MLDLienEntite> listeLienMLDEntite;
/*     */   private IhmPageMCD page;
/*     */   private ArrayList<MLDEntite> listeEntiteMLD;
/*     */   private ArrayList<MLDReference> listeReference;
/*     */   private String sqlString;
/*     */   private String MLDRString;
/*     */   private Map<IhmRelation, IhmRelation> listeCorrespoRel;
/*     */   
/*     */   public MLDConstruction(IhmPageMCD page)
/*     */   {
/*  46 */     this.page = page;
/*  47 */     this.listeEntite = new ArrayList();
/*     */     
/*  49 */     this.listeLien = new ArrayList();
/*  50 */     this.listeEntiteMLD = new ArrayList();
/*  51 */     this.listeLienMLDEntite = new ArrayList();
/*  52 */     this.listeReference = new ArrayList();
/*  53 */     this.listeCorrespoRel = new HashMap();
/*  54 */     construireListeLien();
/*  55 */     construireEntiteSansLien();
/*  56 */     construireListeEntiteMLD();
/*  57 */     construireEntiteLienRelatif();
/*  58 */     affecterCleDesPeresMLDEntite();
/*     */   }
/*     */   
/*     */   public String getSqlString()
/*     */   {
/*  63 */     return this.sqlString;
/*     */   }
/*     */   
/*     */   public String getMLDRString() {
/*  67 */     return this.MLDRString;
/*     */   }
/*     */   
/*     */   public ArrayList<MLDReference> getListeReference() {
/*  71 */     return this.listeReference;
/*     */   }
/*     */   
/*     */   private void construireListeEntiteMLD()
/*     */   {
/*  76 */     for (int i = 0; i < this.page.getListeEntiteRelation().size(); i++) {
/*  77 */       if (((IhmEntiteRelation)this.page.getListeEntiteRelation().get(i)).getClass().getName().equals("IhmMCD2.IhmEntite2")) {
/*  78 */         MLDEntite ent = new MLDEntite(((IhmEntite2)this.page.getListeEntiteRelation().get(i)).getEntite().getNom(), ((IhmEntite2)this.page.getListeEntiteRelation().get(i)).getEntite().getCommentaire());
/*  79 */         ent.setListeAttribut(((IhmEntite2)this.page.getListeEntiteRelation().get(i)).getEntite().copier().getListeAttributs());
/*  80 */         this.listeEntiteMLD.add(ent);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private MLDLien existeRelationLien(IhmRelation rel) {
/*  86 */     IhmRelation r = (IhmRelation)this.listeCorrespoRel.get(rel);
/*  87 */     if (r == null) return null;
/*  88 */     for (int i = 0; i < this.listeLien.size(); i++) {
/*  89 */       if (r == ((MLDLien)this.listeLien.get(i)).getRelation()) return (MLDLien)this.listeLien.get(i);
/*     */     }
/*  91 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private MLDLien ajouterRelationLien(IhmRelation rel)
/*     */   {
/* 102 */     MLDLien lie = existeRelationLien(rel);
/* 103 */     if (lie == null) {
/* 104 */       IhmRelation r = rel.copier();
/* 105 */       this.listeCorrespoRel.put(rel, r);
/* 106 */       lie = new MLDLien(r);
/* 107 */       this.listeLien.add(lie);
/*     */     }
/* 109 */     return lie;
/*     */   }
/*     */   
/*     */ 
/*     */   private String epurerCardinalite(String car)
/*     */   {
/* 115 */     return car;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void construireListeLien()
/*     */   {
/* 126 */     ArrayList<IhmLien> liste = this.page.getListeLien();
/*     */     
/* 128 */     for (int i = 0; i < liste.size(); i++) {
/* 129 */       MLDLien lien = ajouterRelationLien(((IhmLien)liste.get(i)).getRelation());
/* 130 */       lien.ajouterIhmEntiteCardinaliteListe(((IhmLien)liste.get(i)).getEntite(), epurerCardinalite(((IhmLien)liste.get(i)).getCardinalite()), ((IhmLien)liste.get(i)).getNom());
/*     */     }
/*     */   }
/*     */   
/*     */   private IhmEntite existeEntiteListeLien(IhmEntite ent)
/*     */   {
/* 136 */     for (int i = 0; i < this.listeLien.size(); i++) {
/* 137 */       ArrayList<MLDEntiteCardinalite> listeEntCard = ((MLDLien)this.listeLien.get(i)).getListeEntite();
/* 138 */       for (int j = 0; j < listeEntCard.size(); j++) {
/* 139 */         if (ent.getEntite().getNom().trim().toUpperCase().equals(((MLDEntiteCardinalite)listeEntCard.get(j)).getEntite().getEntite().getNom().trim().toUpperCase())) return ((MLDEntiteCardinalite)listeEntCard.get(j)).getEntite();
/*     */       }
/*     */     }
/* 142 */     return null;
/*     */   }
/*     */   
/*     */   private void construireEntiteSansLien() {
/* 146 */     ArrayList<IhmEntiteRelation> liste = this.page.getListeEntiteRelation();
/* 147 */     for (int i = 0; i < liste.size(); i++) {
/* 148 */       if ((((IhmEntiteRelation)liste.get(i)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) && 
/* 149 */         (existeEntiteListeLien((IhmEntite2)liste.get(i)) == null)) {
/* 150 */         this.listeEntite.add(((IhmEntite2)liste.get(i)).copier());
/*     */       }
/*     */     }
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
/*     */   public boolean isRelatif(MLDLien lien)
/*     */   {
/* 172 */     if (lien == null) return false;
/* 173 */     if (lien.getListeEntite().size() < 2) return false;
/* 174 */     if (((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getCardinalite().indexOf("(") >= 0) return true;
/* 175 */     if (((MLDEntiteCardinalite)lien.getListeEntite().get(1)).getCardinalite().indexOf("(") >= 0) return true;
/* 176 */     return false;
/*     */   }
/*     */   
/*     */   public void construireEntiteLienRelatif()
/*     */   {
/* 181 */     for (int i = 0; i < this.listeLien.size(); i++) {
/* 182 */       if (isRelatif((MLDLien)this.listeLien.get(i))) {
/* 183 */         affecterLesAttributAuFilsRelatif((MLDLien)this.listeLien.get(i));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private IhmLienHeritage getPere(IhmEntite ent)
/*     */   {
/* 191 */     for (int i = 0; i < this.page.getListeLienHeritage().size(); i++) {
/* 192 */       if (((IhmLienHeritage2)this.page.getListeLienHeritage().get(i)).getFils() == ent) {
/* 193 */         return (IhmLienHeritage)this.page.getListeLienHeritage().get(i);
/*     */       }
/*     */     }
/* 196 */     return null;
/*     */   }
/*     */   
/*     */   private int profondeurHeritage() {
/* 200 */     IhmLienHeritage lien = null;
/* 201 */     int cpt = 0;
/* 202 */     int max = 0;
/* 203 */     for (int i = 0; i < this.page.getListeLienHeritage().size(); i++) {
/* 204 */       cpt = 0;
/* 205 */       lien = getPere((IhmEntite)((IhmLienHeritage2)this.page.getListeLienHeritage().get(i)).getFils());
/* 206 */       while (lien != null) {
/* 207 */         cpt++;
/* 208 */         lien = getPere((IhmEntite)((IhmLienHeritage2)lien).getPere());
/*     */       }
/* 210 */       if (cpt > max) max = cpt;
/*     */     }
/* 212 */     return max;
/*     */   }
/*     */   
/*     */   private int profondeurMLDEntiteHeritage(IhmLienHeritage li) {
/* 216 */     IhmLienHeritage lien = null;
/* 217 */     int cpt = 0;
/* 218 */     int max = 0;
/* 219 */     lien = getPere((IhmEntite)((IhmLienHeritage2)li).getFils());
/* 220 */     while (lien != null) {
/* 221 */       cpt++;
/* 222 */       lien = getPere((IhmEntite)((IhmLienHeritage2)lien).getPere());
/*     */     }
/* 224 */     if (cpt > max) max = cpt;
/* 225 */     return max;
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> copierListeAttribut(ArrayList<Attribut> listeA) {
/* 229 */     ArrayList<Attribut> liste = new ArrayList();
/* 230 */     for (int i = 0; i < listeA.size(); i++) {
/* 231 */       liste.add(((Attribut)listeA.get(i)).copier());
/*     */     }
/* 233 */     return liste;
/*     */   }
/*     */   
/*     */   private void affecterCleDesPeresMLDEntite() {
/* 237 */     MLDEntite entFils = null;
/* 238 */     MLDEntite entPere = null;
/* 239 */     int prof = 0;
/* 240 */     int max = profondeurHeritage();
/* 241 */     for (int i = 1; i < max + 1; i++) {
/* 242 */       for (int j = 0; j < this.page.getListeLienHeritage().size(); j++) {
/* 243 */         prof = profondeurMLDEntiteHeritage((IhmLienHeritage)this.page.getListeLienHeritage().get(j));
/* 244 */         if (prof == i) {
/* 245 */           entPere = existeMLDEntiteListe(((IhmEntite)((IhmLienHeritage2)this.page.getListeLienHeritage().get(j)).getPere()).getEntite().getNom());
/* 246 */           entFils = existeMLDEntiteListe(((IhmEntite)((IhmLienHeritage2)this.page.getListeLienHeritage().get(j)).getFils()).getEntite().getNom());
/* 247 */           if (Setting.cleSiNecessaireMere) {
/* 248 */             if ((entFils.getCle() == null) || (entFils.getCle().size() <= 0))
/* 249 */               entFils.setListeAttribut(affecterListeAttlisteHeritage(entFils.getListeAttributs(), entPere.getCle()));
/*     */           } else {
/* 251 */             entFils.setListeAttribut(affecterListeAttlisteHeritage(entFils.getListeAttributs(), entPere.getCle()));
/*     */           }
/* 253 */           this.listeLienMLDEntite.add(new MLDLienEntite(entFils, entPere, false));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void affecterCleEtrangereDesPeresMLDEntite()
/*     */   {
/* 261 */     if (Setting.attMere) {
/* 262 */       MLDEntite entFils = null;
/* 263 */       MLDEntite entPere = null;
/* 264 */       int prof = 0;
/* 265 */       int max = profondeurHeritage();
/* 266 */       for (int i = 1; i < max + 1; i++) {
/* 267 */         for (int j = 0; j < this.page.getListeLienHeritage().size(); j++) {
/* 268 */           prof = profondeurMLDEntiteHeritage((IhmLienHeritage)this.page.getListeLienHeritage().get(j));
/* 269 */           if (prof == i) {
/* 270 */             entPere = existeMLDEntiteListe(((IhmEntite)((IhmLienHeritage2)this.page.getListeLienHeritage().get(j)).getPere()).getEntite().getNom());
/* 271 */             entFils = existeMLDEntiteListe(((IhmEntite)((IhmLienHeritage2)this.page.getListeLienHeritage().get(j)).getFils()).getEntite().getNom());
/* 272 */             entFils.setListeAttribut(affecterListeAttlisteHeritage(entFils.getListeAttributs(), entPere.getNonCle()));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
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
/*     */   private ArrayList<Attribut> affecterListeAttlisteHeritage(ArrayList<Attribut> liste1, ArrayList<Attribut> liste2)
/*     */   {
/* 290 */     for (int i = 0; i < liste2.size(); i++) {
/* 291 */       liste1.add(liste2.get(i));
/*     */     }
/* 293 */     return liste1;
/*     */   }
/*     */   
/*     */   public void afficherLesListes() {
/* 297 */     for (int i = 0; i < this.listeLien.size(); i++) {
/* 298 */       System.out.println("relation === : " + ((MLDLien)this.listeLien.get(i)).getRelation().getRelation().getNom() + "\n\t");
/* 299 */       ((MLDLien)this.listeLien.get(i)).afficherMLDLien();
/*     */     }
/*     */   }
/*     */   
/*     */   public ArrayList<MLDEntite> getListeEntiteMLD() {
/* 304 */     return this.listeEntiteMLD;
/*     */   }
/*     */   
/*     */   public ArrayList<MLDLienEntite> getListeLienMLDEntite() {
/* 308 */     return this.listeLienMLDEntite;
/*     */   }
/*     */   
/*     */   private IhmEntiteRelation trouverIhmEntiteRelation(String nom)
/*     */   {
/* 313 */     for (int i = 0; i < this.page.getListeEntiteRelation().size(); i++) {
/* 314 */       if (((IhmEntiteRelation)this.page.getListeEntiteRelation().get(i)).getClass().getName().equals("IhmMCD2.IhmEntite2")) {
/* 315 */         if (((IhmEntite2)this.page.getListeEntiteRelation().get(i)).getEntite().getNom().equals(nom)) return (IhmEntiteRelation)this.page.getListeEntiteRelation().get(i);
/*     */       }
/* 317 */       else if (((IhmRelation2)this.page.getListeEntiteRelation().get(i)).getRelation().getNom().equals(nom)) { return (IhmEntiteRelation)this.page.getListeEntiteRelation().get(i);
/*     */       }
/*     */     }
/*     */     
/* 321 */     return null;
/*     */   }
/*     */   
/*     */   private void setPostionMLDEntite()
/*     */   {
/* 326 */     for (int i = 0; i < this.listeEntiteMLD.size(); i++) {
/* 327 */       IhmEntiteRelation entRel = trouverIhmEntiteRelation(((MLDEntite)this.listeEntiteMLD.get(i)).getNom());
/* 328 */       if (entRel != null) {
/* 329 */         ((MLDEntite)this.listeEntiteMLD.get(i)).setX(entRel.getX());
/* 330 */         ((MLDEntite)this.listeEntiteMLD.get(i)).setY(entRel.getY());
/* 331 */         ((MLDEntite)this.listeEntiteMLD.get(i)).setWidth(entRel.getWidth());
/* 332 */         ((MLDEntite)this.listeEntiteMLD.get(i)).setHeight(entRel.getHeight());
/*     */       }
/*     */     }
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
/*     */   private int getCasDeLaRelation(MLDLien lien)
/*     */   {
/* 347 */     if (lien.getListeEntite().size() > 2) return 1;
/* 348 */     if (isRelatif(lien)) {
/* 349 */       return 5;
/*     */     }
/* 351 */     if ((((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getCardinalite().trim().equals("0,n")) && (((MLDEntiteCardinalite)lien.getListeEntite().get(1)).getCardinalite().trim().equals("0,n"))) {
/* 352 */       return 1;
/*     */     }
/* 354 */     if ((((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getCardinalite().trim().equals("1,n")) && (((MLDEntiteCardinalite)lien.getListeEntite().get(1)).getCardinalite().trim().equals("0,n"))) {
/* 355 */       return 1;
/*     */     }
/* 357 */     if ((((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getCardinalite().trim().equals("1,n")) && (((MLDEntiteCardinalite)lien.getListeEntite().get(1)).getCardinalite().trim().equals("1,n"))) {
/* 358 */       return 1;
/*     */     }
/* 360 */     if ((((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getCardinalite().trim().equals("0,n")) && (((MLDEntiteCardinalite)lien.getListeEntite().get(1)).getCardinalite().trim().equals("1,n"))) {
/* 361 */       return 1;
/*     */     }
/* 363 */     if ((((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getCardinalite().trim().equals("0,1")) && (((MLDEntiteCardinalite)lien.getListeEntite().get(1)).getCardinalite().trim().equals("1,1"))) {
/* 364 */       return 2;
/*     */     }
/* 366 */     if ((((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getCardinalite().trim().equals("0,1")) && (((MLDEntiteCardinalite)lien.getListeEntite().get(1)).getCardinalite().trim().equals("0,1"))) {
/* 367 */       return 2;
/*     */     }
/* 369 */     if ((((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getCardinalite().trim().equals("1,1")) && (((MLDEntiteCardinalite)lien.getListeEntite().get(1)).getCardinalite().trim().equals("1,1"))) {
/* 370 */       return 2;
/*     */     }
/* 372 */     if ((((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getCardinalite().trim().equals("1,1")) && (((MLDEntiteCardinalite)lien.getListeEntite().get(1)).getCardinalite().trim().equals("0,1"))) {
/* 373 */       return 2;
/*     */     }
/* 375 */     return 0;
/*     */   }
/*     */   
/*     */   private ArrayList<Attribut> affecterListeAttributDansliste(ArrayList<Attribut> liste1, ArrayList<Attribut> liste2) {
/* 379 */     for (int i = 0; i < liste2.size(); i++) {
/* 380 */       liste1.add(liste2.get(i));
/*     */     }
/* 382 */     return liste1;
/*     */   }
/*     */   
/*     */   private ArrayList<Attribut> setEtrangereCle(ArrayList<Attribut> list) {
/* 386 */     if (list == null) return list;
/* 387 */     for (int i = 0; i < list.size(); i++) {
/* 388 */       ((Attribut)list.get(i)).setKey(Parametres.CleEtr);
/*     */     }
/* 390 */     return list;
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
/*     */   public void affecterLesClesALEntite(ArrayList<MLDEntiteCardinalite> liste, MLDEntiteCardinalite ent)
/*     */   {
/* 403 */     for (int i = 0; i < liste.size(); i++) {
/* 404 */       if (!((MLDEntiteCardinalite)liste.get(i)).equals(ent)) {
/* 405 */         ent.getEntite().getEntite().rajouterListeAttribut(((MLDEntiteCardinalite)liste.get(i)).getEntite().getEntite().getCle());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void affecterLesClesATouteEntite(ArrayList<MLDEntiteCardinalite> liste) {
/* 411 */     for (int i = 0; i < liste.size(); i++) {
/* 412 */       affecterLesClesALEntite(liste, (MLDEntiteCardinalite)liste.get(i));
/*     */     }
/*     */   }
/*     */   
/*     */   public void affecterLesAttributAuFils(MLDLien lien) {
/* 417 */     Entite entFils = ((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getEntite().getEntite();
/* 418 */     Entite entPere = ((MLDEntiteCardinalite)lien.getListeEntite().get(1)).getEntite().getEntite();
/*     */     
/* 420 */     if (!entFils.getNom().trim().toUpperCase().equals(entPere.getNom().trim().toUpperCase())) {
/* 421 */       if ((((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getCardinalite().equals("1,n")) || (((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getCardinalite().equals("0,n")))
/*     */       {
/* 423 */         entPere = ((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getEntite().getEntite();
/* 424 */         entFils = ((MLDEntiteCardinalite)lien.getListeEntite().get(1)).getEntite().getEntite();
/*     */       }
/* 426 */       MLDEntite pere = existeMLDEntiteListe(entPere.getNom());
/* 427 */       MLDEntite fils = existeMLDEntiteListe(entFils.getNom());
/* 428 */       if ((fils == null) && (pere == null)) {
/* 429 */         fils = new MLDEntite(entFils.getNom(), entFils.getCommentaire());
/* 430 */         fils.setCommentaire(entFils.getCommentaire());
/* 431 */         fils.setListeAttribut(affecterListeAttributDansliste(entFils.copierListeAttribut(), setEtrangereCle(entPere.getCle())));
/* 432 */         fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), lien.getRelation().getRelation().copierListeAttribut()));
/* 433 */         pere = new MLDEntite(entPere.getNom(), entPere.getCommentaire());
/* 434 */         pere.setCommentaire(entPere.getCommentaire());
/* 435 */         pere.setListeAttribut(entPere.copierListeAttribut());
/* 436 */         this.listeEntiteMLD.add(pere);
/* 437 */         this.listeEntiteMLD.add(fils);
/* 438 */         this.listeLienMLDEntite.add(new MLDLienEntite(fils, pere, true));
/*     */       }
/* 440 */       else if ((fils != null) && (pere != null)) {
/* 441 */         fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), lien.getRelation().getRelation().copierListeAttribut()));
/* 442 */         fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), setEtrangereCle(pere.getCle())));
/* 443 */         this.listeLienMLDEntite.add(new MLDLienEntite(fils, pere, true));
/*     */       } else {
/* 445 */         if (fils != null) {
/* 446 */           fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), setEtrangereCle(entPere.getCle())));
/* 447 */           fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), lien.getRelation().getRelation().copierListeAttribut()));
/* 448 */           pere = new MLDEntite(entPere.getNom(), entPere.getCommentaire());
/* 449 */           pere.setCommentaire(entPere.getCommentaire());
/* 450 */           pere.setListeAttribut(entPere.copierListeAttribut());
/* 451 */           this.listeEntiteMLD.add(pere);
/* 452 */           this.listeLienMLDEntite.add(new MLDLienEntite(fils, pere, true));
/*     */         }
/* 454 */         if (pere != null) {
/* 455 */           fils = new MLDEntite(entFils.getNom(), entFils.getCommentaire());
/* 456 */           fils.setCommentaire(entFils.getCommentaire());
/* 457 */           fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), lien.getRelation().getRelation().copierListeAttribut()));
/* 458 */           fils.setListeAttribut(affecterListeAttributDansliste(entFils.copierListeAttribut(), setEtrangereCle(pere.getCle())));
/* 459 */           this.listeEntiteMLD.add(fils);
/* 460 */           this.listeLienMLDEntite.add(new MLDLienEntite(fils, pere, true));
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 465 */       MLDEntite fils = existeMLDEntiteListe(entFils.getNom());
/* 466 */       if (fils == null) {
/* 467 */         fils = new MLDEntite(entFils.getNom(), entFils.getCommentaire());
/* 468 */         fils.setCommentaire(entFils.getCommentaire());
/* 469 */         fils.setListeAttribut(affecterListeAttributDansliste(entFils.copierListeAttribut(), lien.getRelation().getRelation().copierListeAttribut()));
/* 470 */         fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), setEtrangereCle(fils.getCle())));
/* 471 */         this.listeEntiteMLD.add(fils);
/*     */       } else {
/* 473 */         fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), lien.getRelation().getRelation().copierListeAttribut()));
/* 474 */         fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), setEtrangereCle(fils.getCle())));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void affecterLesAttributAuFilsRelatif(MLDLien lien)
/*     */   {
/* 481 */     Entite entFils = ((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getEntite().getEntite();
/* 482 */     Entite entPere = ((MLDEntiteCardinalite)lien.getListeEntite().get(1)).getEntite().getEntite();
/*     */     
/* 484 */     if (!entFils.getNom().trim().toUpperCase().equals(entPere.getNom().trim().toUpperCase())) {
/* 485 */       if ((((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getCardinalite().equals("1,n")) || (((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getCardinalite().equals("0,n")))
/*     */       {
/* 487 */         entPere = ((MLDEntiteCardinalite)lien.getListeEntite().get(0)).getEntite().getEntite();
/* 488 */         entFils = ((MLDEntiteCardinalite)lien.getListeEntite().get(1)).getEntite().getEntite();
/*     */       }
/* 490 */       MLDEntite pere = existeMLDEntiteListe(entPere.getNom());
/* 491 */       MLDEntite fils = existeMLDEntiteListe(entFils.getNom());
/* 492 */       if ((fils == null) && (pere == null)) {
/* 493 */         fils = new MLDEntite(entFils.getNom(), entFils.getCommentaire());
/* 494 */         fils.setCommentaire(entFils.getCommentaire());
/* 495 */         fils.setListeAttribut(affecterListeAttributDansliste(entFils.copierListeAttribut(), entPere.getCle()));
/* 496 */         fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), lien.getRelation().getRelation().copierListeAttribut()));
/* 497 */         pere = new MLDEntite(entPere.getNom(), entPere.getCommentaire());
/* 498 */         pere.setCommentaire(entPere.getCommentaire());
/* 499 */         pere.setListeAttribut(entPere.copierListeAttribut());
/* 500 */         this.listeEntiteMLD.add(pere);
/* 501 */         this.listeEntiteMLD.add(fils);
/* 502 */         this.listeLienMLDEntite.add(new MLDLienEntite(fils, pere, true));
/*     */       }
/* 504 */       else if ((fils != null) && (pere != null)) {
/* 505 */         fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), lien.getRelation().getRelation().copierListeAttribut()));
/* 506 */         fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), pere.getCle()));
/* 507 */         this.listeLienMLDEntite.add(new MLDLienEntite(fils, pere, true));
/*     */       } else {
/* 509 */         if (fils != null) {
/* 510 */           fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), entPere.getCle()));
/* 511 */           fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), lien.getRelation().getRelation().copierListeAttribut()));
/* 512 */           pere = new MLDEntite(entPere.getNom(), entPere.getCommentaire());
/* 513 */           pere.setCommentaire(entPere.getCommentaire());
/* 514 */           pere.setListeAttribut(entPere.copierListeAttribut());
/* 515 */           this.listeEntiteMLD.add(pere);
/* 516 */           this.listeLienMLDEntite.add(new MLDLienEntite(fils, pere, true));
/*     */         }
/* 518 */         if (pere != null) {
/* 519 */           fils = new MLDEntite(entFils.getNom(), entFils.getCommentaire());
/* 520 */           fils.setCommentaire(entFils.getCommentaire());
/* 521 */           fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), lien.getRelation().getRelation().copierListeAttribut()));
/* 522 */           fils.setListeAttribut(affecterListeAttributDansliste(entFils.copierListeAttribut(), pere.getCle()));
/* 523 */           this.listeEntiteMLD.add(fils);
/* 524 */           this.listeLienMLDEntite.add(new MLDLienEntite(fils, pere, true));
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 529 */       MLDEntite fils = existeMLDEntiteListe(entFils.getNom());
/* 530 */       if (fils == null) {
/* 531 */         fils = new MLDEntite(entFils.getNom(), entFils.getCommentaire());
/* 532 */         fils.setCommentaire(entFils.getCommentaire());
/* 533 */         fils.setListeAttribut(affecterListeAttributDansliste(entFils.copierListeAttribut(), lien.getRelation().getRelation().copierListeAttribut()));
/* 534 */         fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), fils.getCle()));
/* 535 */         this.listeEntiteMLD.add(fils);
/*     */       } else {
/* 537 */         fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), lien.getRelation().getRelation().copierListeAttribut()));
/* 538 */         fils.setListeAttribut(affecterListeAttributDansliste(fils.getListeAttributs(), fils.getCle()));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private MLDEntite existeMLDEntiteListe(String nom)
/*     */   {
/* 546 */     for (int i = 0; i < this.listeEntiteMLD.size(); i++) {
/* 547 */       if (((MLDEntite)this.listeEntiteMLD.get(i)).getNom().trim().toUpperCase().equals(nom.trim().toUpperCase())) return (MLDEntite)this.listeEntiteMLD.get(i);
/*     */     }
/* 549 */     return null;
/*     */   }
/*     */   
/*     */   private void construireListeMLDEntite(ArrayList<MLDEntiteCardinalite> liste, MLDEntite rel)
/*     */   {
/* 554 */     for (int i = 0; i < liste.size(); i++) {
/* 555 */       MLDEntite ent = existeMLDEntiteListe(((MLDEntiteCardinalite)liste.get(i)).getEntite().getEntite().getNom());
/* 556 */       if (ent == null) {
/* 557 */         MLDEntite mld = new MLDEntite(((MLDEntiteCardinalite)liste.get(i)).getEntite().getEntite().getNom(), ((MLDEntiteCardinalite)liste.get(i)).getEntite().getEntite().getCommentaire());
/* 558 */         mld.setCommentaire(((MLDEntiteCardinalite)liste.get(i)).getEntite().getEntite().getCommentaire());
/* 559 */         mld.setListeAttribut(((MLDEntiteCardinalite)liste.get(i)).getEntite().getEntite().copierListeAttribut());
/* 560 */         this.listeEntiteMLD.add(mld);
/* 561 */         if (rel != null) {
/* 562 */           rel.setListeAttribut(affecterListeAttributDansliste(rel.getListeAttributs(), mld.getCle()));
/* 563 */           this.listeLienMLDEntite.add(new MLDLienEntite(rel, mld, true));
/*     */         }
/*     */       }
/* 566 */       else if (rel != null) {
/* 567 */         rel.setListeAttribut(affecterListeAttributDansliste(rel.getListeAttributs(), ent.getCle()));
/* 568 */         this.listeLienMLDEntite.add(new MLDLienEntite(rel, ent, true));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void ajouterMLDEntiteListeCas2(ArrayList<MLDEntiteCardinalite> liste)
/*     */   {
/* 575 */     MLDEntite ent0 = existeMLDEntiteListe(((MLDEntiteCardinalite)liste.get(0)).getEntite().getEntite().getNom());
/* 576 */     MLDEntite ent1 = existeMLDEntiteListe(((MLDEntiteCardinalite)liste.get(1)).getEntite().getEntite().getNom());
/* 577 */     if (!((MLDEntiteCardinalite)liste.get(0)).getEntite().getEntite().getNom().trim().toUpperCase().equals(((MLDEntiteCardinalite)liste.get(1)).getEntite().getEntite().getNom().trim().toUpperCase())) {
/* 578 */       if ((ent0 == null) && (ent1 == null)) {
/* 579 */         ent0 = new MLDEntite(((MLDEntiteCardinalite)liste.get(0)).getEntite().getEntite().getNom(), ((MLDEntiteCardinalite)liste.get(0)).getEntite().getEntite().getCommentaire());
/* 580 */         ent0.setCommentaire(((MLDEntiteCardinalite)liste.get(0)).getEntite().getEntite().getCommentaire());
/* 581 */         ent0.setListeAttribut(affecterListeAttributDansliste(((MLDEntiteCardinalite)liste.get(0)).getEntite().getEntite().copierListeAttribut(), setEtrangereCle(((MLDEntiteCardinalite)liste.get(1)).getEntite().getEntite().getCle())));
/*     */         
/* 583 */         ent1 = new MLDEntite(((MLDEntiteCardinalite)liste.get(1)).getEntite().getEntite().getNom(), ((MLDEntiteCardinalite)liste.get(1)).getEntite().getEntite().getCommentaire());
/* 584 */         ent1.setCommentaire(((MLDEntiteCardinalite)liste.get(1)).getEntite().getEntite().getCommentaire());
/* 585 */         ent1.setListeAttribut(affecterListeAttributDansliste(((MLDEntiteCardinalite)liste.get(1)).getEntite().getEntite().copierListeAttribut(), setEtrangereCle(((MLDEntiteCardinalite)liste.get(0)).getEntite().getEntite().getCle())));
/*     */         
/* 587 */         this.listeEntiteMLD.add(ent0);
/* 588 */         this.listeEntiteMLD.add(ent1);
/* 589 */         this.listeLienMLDEntite.add(new MLDLienEntite(ent0, ent1, false));
/*     */       }
/* 591 */       else if ((ent0 != null) && (ent1 != null)) {
/* 592 */         ent0.setListeAttribut(affecterListeAttributDansliste(ent0.getListeAttributs(), setEtrangereCle(ent1.getCle())));
/* 593 */         ent1.setListeAttribut(affecterListeAttributDansliste(ent1.getListeAttributs(), setEtrangereCle(ent0.getCle())));
/* 594 */         this.listeLienMLDEntite.add(new MLDLienEntite(ent0, ent1, false));
/*     */       } else {
/* 596 */         if (ent0 == null) {
/* 597 */           ent0 = new MLDEntite(((MLDEntiteCardinalite)liste.get(0)).getEntite().getEntite().getNom(), ((MLDEntiteCardinalite)liste.get(0)).getEntite().getEntite().getCommentaire());
/* 598 */           ent0.setCommentaire(((MLDEntiteCardinalite)liste.get(0)).getEntite().getEntite().getCommentaire());
/* 599 */           ent0.setListeAttribut(affecterListeAttributDansliste(((MLDEntiteCardinalite)liste.get(0)).getEntite().getEntite().copierListeAttribut(), setEtrangereCle(ent1.getCle())));
/*     */           
/* 601 */           ent1.setListeAttribut(affecterListeAttributDansliste(ent1.getListeAttributs(), setEtrangereCle(ent0.getCle())));
/* 602 */           this.listeEntiteMLD.add(ent0);
/* 603 */           this.listeLienMLDEntite.add(new MLDLienEntite(ent0, ent1, false));
/*     */         }
/* 605 */         if (ent1 == null) {
/* 606 */           ent1 = new MLDEntite(((MLDEntiteCardinalite)liste.get(1)).getEntite().getEntite().getNom(), ((MLDEntiteCardinalite)liste.get(1)).getEntite().getEntite().getCommentaire());
/* 607 */           ent1.setCommentaire(((MLDEntiteCardinalite)liste.get(1)).getEntite().getEntite().getCommentaire());
/* 608 */           ent1.setListeAttribut(affecterListeAttributDansliste(((MLDEntiteCardinalite)liste.get(1)).getEntite().getEntite().copierListeAttribut(), setEtrangereCle(ent0.getCle())));
/*     */           
/* 610 */           ent0.setListeAttribut(affecterListeAttributDansliste(ent0.getListeAttributs(), setEtrangereCle(ent1.getCle())));
/* 611 */           this.listeEntiteMLD.add(ent1);
/* 612 */           this.listeLienMLDEntite.add(new MLDLienEntite(ent0, ent1, false));
/*     */         }
/*     */         
/*     */       }
/*     */     }
/* 617 */     else if (ent0 == null) {
/* 618 */       ent0 = new MLDEntite(((MLDEntiteCardinalite)liste.get(0)).getEntite().getEntite().getNom(), ((MLDEntiteCardinalite)liste.get(0)).getEntite().getEntite().getCommentaire());
/* 619 */       ent0.setCommentaire(((MLDEntiteCardinalite)liste.get(0)).getEntite().getEntite().getCommentaire());
/* 620 */       ent0.setListeAttribut(affecterListeAttributDansliste(((MLDEntiteCardinalite)liste.get(0)).getEntite().getEntite().copierListeAttribut(), setEtrangereCle(ent1.getCle())));
/*     */       
/* 622 */       ent0.setListeAttribut(affecterListeAttributDansliste(ent0.getListeAttributs(), setEtrangereCle(ent0.getCle())));
/* 623 */       this.listeEntiteMLD.add(ent0);
/*     */     } else {
/* 625 */       ent0.setListeAttribut(affecterListeAttributDansliste(ent0.getListeAttributs(), setEtrangereCle(ent0.getCle())));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void construireMLDEntite(MLDLien lien)
/*     */   {
/* 638 */     int cas = getCasDeLaRelation(lien);
/*     */     
/* 640 */     if (cas == 0) {
/* 641 */       affecterLesAttributAuFils(lien);
/*     */     }
/* 643 */     if (cas == 1)
/*     */     {
/* 645 */       MLDEntite mld = new MLDEntite(lien.getRelation().getRelation().getNom(), lien.getRelation().getRelation().getCommentaire());
/* 646 */       mld.setCommentaire(lien.getRelation().getRelation().getCommentaire());
/* 647 */       mld.setListeAttribut(lien.getRelation().getRelation().copierListeAttribut());
/* 648 */       this.listeEntiteMLD.add(mld);
/* 649 */       construireListeMLDEntite(lien.getListeEntite(), mld);
/*     */     }
/* 651 */     if (cas == 2) {
/* 652 */       if (lien.getRelation().getRelation().getListeAttributs().size() == 0) {
/* 653 */         ajouterMLDEntiteListeCas2(lien.getListeEntite());
/*     */       } else {
/* 655 */         MLDEntite mld = new MLDEntite(lien.getRelation().getRelation().getNom(), lien.getRelation().getRelation().getCommentaire());
/* 656 */         mld.setCommentaire(lien.getRelation().getRelation().getCommentaire());
/* 657 */         mld.setListeAttribut(lien.getRelation().getRelation().copierListeAttribut());
/* 658 */         this.listeEntiteMLD.add(mld);
/* 659 */         construireListeMLDEntite(lien.getListeEntite(), mld);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void construireMLDEntiteSansLien() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Attribut isReferencer(MLDEntite ent, Attribut att)
/*     */   {
/* 676 */     if (ent == null) return null;
/* 677 */     if (att == null) return null;
/* 678 */     if ((att.getKey().trim().equals(Parametres.CleEtr)) || ((!ent.getNom().trim().toUpperCase().equals(att.getEntiteRelation().getNom().trim().toUpperCase())) && (att.getKey().trim().equals(Parametres.Cle))))
/*     */     {
/*     */ 
/*     */ 
/* 682 */       return att;
/*     */     }
/* 684 */     return null;
/*     */   }
/*     */   
/*     */   private void referenceEntite(MLDEntite ent)
/*     */   {
/* 689 */     for (int i = 0; i < ent.getListeAttributs().size(); i++)
/*     */     {
/* 691 */       if (isReferencer(ent, (Attribut)ent.getListeAttributs().get(i)) != null)
/*     */       {
/* 693 */         this.listeReference.add(new MLDReference((Attribut)ent.getListeAttributs().get(i), ((Attribut)ent.getListeAttributs().get(i)).getNom(), ((Attribut)ent.getListeAttributs().get(i)).getEntiteRelation().getNom(), ent.getNom()));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void referenceAllEntite()
/*     */   {
/* 704 */     for (int i = 0; i < this.listeEntiteMLD.size(); i++) {
/* 705 */       referenceEntite((MLDEntite)this.listeEntiteMLD.get(i));
/*     */     }
/*     */   }
/*     */   
/*     */   private void renommerAttributMLDEntite(MLDEntite ent)
/*     */   {
/* 711 */     for (int i = 0; i < ent.getListeAttributs().size(); i++) {
/* 712 */       if (!ent.getNom().trim().toUpperCase().equals(((Attribut)ent.getListeAttributs().get(i)).getEntiteRelation().getNom().trim().toUpperCase())) {
/* 713 */         ((Attribut)ent.getListeAttributs().get(i)).setNom(((Attribut)ent.getListeAttributs().get(i)).getNom() + "_" + ((Attribut)ent.getListeAttributs().get(i)).getEntiteRelation().getNom());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void renommerAttributAllMLDEntite() {
/* 719 */     for (int i = 0; i < this.listeEntiteMLD.size(); i++) {
/* 720 */       renommerAttributMLDEntite((MLDEntite)this.listeEntiteMLD.get(i));
/*     */     }
/*     */   }
/*     */   
/*     */   private int affecterNouveauNom(MLDEntite ent, Attribut att, int cpt) {
/* 725 */     if (!ent.getNom().trim().toUpperCase().equals(att.getEntiteRelation().getNom().trim().toUpperCase())) {
/* 726 */       if (att.getNom().indexOf(att.getEntiteRelation().getNom().trim()) >= 0) {
/* 727 */         att.setNom(att.getNom() + "_" + cpt);
/* 728 */         cpt++;
/*     */       } else {
/* 730 */         att.setNom(att.getNom() + "_" + att.getEntiteRelation().getNom().trim());
/*     */       }
/*     */     } else {
/* 733 */       att.setNom(att.getNom() + "_" + cpt);
/* 734 */       cpt++;
/*     */     }
/*     */     
/* 737 */     return cpt;
/*     */   }
/*     */   
/* 740 */   private void corrigerNomAttribut(MLDEntite ent) { int cpt = 1;
/*     */     
/* 742 */     for (int i = 0; i < ent.getListeAttributs().size(); i++) {
/* 743 */       Attribut att = (Attribut)ent.getListeAttributs().get(i);
/* 744 */       corrigerTypeAttribut(att, ent.getNom());
/* 745 */       for (int j = i + 1; j < ent.getListeAttributs().size(); j++) {
/* 746 */         if (att.getNom().equals(((Attribut)ent.getListeAttributs().get(j)).getNom())) {
/* 747 */           cpt = affecterNouveauNom(ent, (Attribut)ent.getListeAttributs().get(j), cpt);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void corrigerTypeAttribut(Attribut att, String nomEnt)
/*     */   {
/* 756 */     if ((att.getKey().equals(Parametres.CleEtr)) && 
/* 757 */       (att.getType().equals("Auto_increment"))) {
/* 758 */       att.setType("Int");
/* 759 */       att.setLongueur(11);
/* 760 */       att.setLongDecimale(0);
/*     */     }
/*     */     
/* 763 */     if ((att.getKey().equals(Parametres.Cle)) && 
/* 764 */       (att.getType().equals("Auto_increment")) && 
/* 765 */       (!att.getEntiteRelation().getNom().equals(nomEnt))) {
/* 766 */       att.setType("Int");
/* 767 */       att.setLongueur(11);
/* 768 */       att.setLongDecimale(0);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void construireNomAttribut()
/*     */   {
/* 776 */     if (Setting.surchargeNom) renommerAttributAllMLDEntite();
/* 777 */     for (int i = 0; i < this.listeEntiteMLD.size(); i++) {
/* 778 */       corrigerNomAttribut((MLDEntite)this.listeEntiteMLD.get(i));
/*     */     }
/*     */   }
/*     */   
/*     */   public void construireMLD2()
/*     */   {
/* 784 */     for (int i = 0; i < this.listeLien.size(); i++) {
/* 785 */       construireMLDEntite((MLDLien)this.listeLien.get(i));
/*     */     }
/*     */   }
/*     */   
/*     */   public void construireMLDSansRelation3()
/*     */   {
/* 791 */     construireMLDEntiteSansLien();
/*     */   }
/*     */   
/*     */ 
/*     */   public void positionnerMLD4()
/*     */   {
/* 797 */     setPostionMLDEntite();
/*     */   }
/*     */   
/*     */   public void construireReference5()
/*     */   {
/* 802 */     referenceAllEntite();
/*     */   }
/*     */   
/*     */   public void afficherRef() {
/* 806 */     for (int i = 0; i < this.listeReference.size(); i++) {
/* 807 */       System.out.println("attribut : " + ((MLDReference)this.listeReference.get(i)).getAttribut().getNom() + " de la table : " + ((MLDReference)this.listeReference.get(i)).getNomTableAct() + " ===== Reference a : " + ((MLDReference)this.listeReference.get(i)).getNomAttibutRef() + "  == de la table ref : " + ((MLDReference)this.listeReference.get(i)).getNomTableRef());
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMLD\MLDConstruction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */