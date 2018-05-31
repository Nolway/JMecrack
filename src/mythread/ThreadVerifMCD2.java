/*     */ package mythread;
/*     */ 
/*     */ import IhmMCD.IhmEntite;
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmLien;
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD.IhmRelation;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmLienHeritage2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import Merise.Attribut;
/*     */ import Merise.Entite;
/*     */ import Merise.Relation;
/*     */ import MyExplorer.ConsolePane;
/*     */ import Outil.Parametres;
/*     */ import Outil.Setting;
/*     */ import formes.FormeConstruction;
/*     */ import ihm.Principale;
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JProgressBar;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.SwingWorker;
/*     */ import verificationAdaptation.Verification;
/*     */ 
/*     */ public class ThreadVerifMCD2 extends SwingWorker
/*     */ {
/*     */   private IhmPageMCD pageMcd;
/*     */   private Principale frm;
/*     */   
/*     */   public ThreadVerifMCD2(Principale frm)
/*     */   {
/*  35 */     this.pageMcd = frm.getPage();
/*  36 */     this.frm = frm;
/*  37 */     Verification.preparerLaVerification(this.pageMcd.getListeEntiteRelation(), this.pageMcd.getListeLien());
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isRelationDeuxliens(IhmRelation rel)
/*     */   {
/*  43 */     int nb = 0;
/*  44 */     int n = this.pageMcd.getListeLien().size();
/*  45 */     for (int i = 0; i < n; i++) {
/*  46 */       if (((IhmLien)this.pageMcd.getListeLien().get(i)).getRelation() == rel) nb++;
/*  47 */       if (nb > 2) return false;
/*     */     }
/*  49 */     if (nb == 2) return true;
/*  50 */     return false;
/*     */   }
/*     */   
/*     */   public IhmLien getDeuxiemeLien(IhmRelation rel, IhmLien l) {
/*  54 */     int n = this.pageMcd.getListeLien().size();
/*  55 */     for (int i = 0; i < n; i++) {
/*  56 */       if (!isRelationDeuxliens(rel)) return null;
/*  57 */       if ((((IhmLien)this.pageMcd.getListeLien().get(i)).getRelation() == rel) && 
/*  58 */         (this.pageMcd.getListeLien().get(i) != l)) { return (IhmLien)this.pageMcd.getListeLien().get(i);
/*     */       }
/*     */     }
/*  61 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isLienRelatifCorrecte(IhmLien li1) {
/*  65 */     IhmLien l2 = getDeuxiemeLien(li1.getRelation(), li1);
/*  66 */     if (l2 == null) {
/*  67 */       this.frm.getConsole().getRapport().append("Lien relatif : la relation \"" + li1.getRelation().getRelation().getNom() + "\" contient un seul lien\n");
/*  68 */       return false;
/*     */     }
/*  70 */     if (l2.getEntite().getEntite().getCle().size() == 0) {
/*  71 */       this.frm.getConsole().getRapport().append("Lien relatif : l'entite \"" + l2.getEntite().getEntite().getNom() + "\" ne contient pas de clé primaire \n");
/*  72 */       return false;
/*     */     }
/*  74 */     if (l2.getCardinalite().trim().indexOf("(") >= 0) {
/*  75 */       this.frm.getConsole().getRapport().append("Lien relatif : le lien entre l'entite \"" + l2.getEntite().getEntite().getNom() + "\" et la relation \"" + l2.getRelation().getRelation().getNom() + "\" ne doit pas être un lien faible \n");
/*  76 */       return false;
/*     */     }
/*  78 */     if ((l2.getCardinalite().trim().indexOf("0,n") < 0) && (l2.getCardinalite().trim().indexOf("1,n") < 0)) {
/*  79 */       this.frm.getConsole().getRapport().append("Lien relatif : le lien entre l'entite \"" + l2.getEntite().getEntite().getNom() + "\" et la relation \"" + l2.getRelation().getRelation().getNom() + "\" doit être de type '0,n' ou '1,n'\n");
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isLienRelatifCorrecte() {
/*  87 */     int n = this.pageMcd.getListeLien().size();
/*  88 */     boolean cor = true;
/*  89 */     for (int i = 0; i < n; i++) {
/*  90 */       if (((IhmLien)this.pageMcd.getListeLien().get(i)).getCardinalite().indexOf("(") >= 0) {
/*  91 */         if (((IhmLien)this.pageMcd.getListeLien().get(i)).getCardinalite().indexOf("1,1") >= 0) {
/*  92 */           if (!isLienRelatifCorrecte((IhmLien)this.pageMcd.getListeLien().get(i))) {
/*  93 */             cor = false;
/*     */           }
/*     */         } else {
/*  96 */           this.frm.getConsole().getRapport().append("Lien relatif : le lien entre l'entité \"" + ((IhmLien)this.pageMcd.getListeLien().get(i)).getEntite().getEntite().getNom() + "\" et la relation \"" + ((IhmLien)this.pageMcd.getListeLien().get(i)).getRelation().getRelation().getNom() + "\" doit être de cette forme (1,1)\n");
/*  97 */           cor = false;
/*     */         }
/*     */       }
/*     */     }
/* 101 */     return cor;
/*     */   }
/*     */   
/*     */   public ArrayList<IhmLien> getLienRelatifEntite(IhmEntite ent) {
/* 105 */     ArrayList<IhmLien> l = new ArrayList();
/* 106 */     int n = this.pageMcd.getListeLien().size();
/* 107 */     for (int i = 0; i < n; i++) {
/* 108 */       if ((((IhmLien)this.pageMcd.getListeLien().get(i)).getEntite() == ent) && 
/* 109 */         (((IhmLien)this.pageMcd.getListeLien().get(i)).getCardinalite().equals("(1,1)"))) {
/* 110 */         l.add(this.pageMcd.getListeLien().get(i));
/*     */       }
/*     */     }
/* 113 */     return l;
/*     */   }
/*     */   
/*     */   public boolean isCleAvecLienRelatif(IhmEntite ent) {
/* 117 */     ArrayList<IhmLien> l = getLienRelatifEntite(ent);
/*     */     
/* 119 */     if (l == null) return false;
/* 120 */     if (l.size() == 0) return false;
/* 121 */     for (int i = 0; i < l.size(); i++) {
/* 122 */       IhmLien l2 = getDeuxiemeLien(((IhmLien)l.get(i)).getRelation(), (IhmLien)l.get(i));
/* 123 */       if ((l2 != null) && 
/* 124 */         (l2.getEntite().getEntite().getCle() != null) && 
/* 125 */         (l2.getEntite().getEntite().getCle().size() > 0)) {
/* 126 */         return true;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 131 */     return false;
/*     */   }
/*     */   
/*     */   public boolean islien1101(IhmLien lien) {
/* 135 */     if ((lien.getCardinalite().trim().indexOf("0,1") >= 0) || (lien.getCardinalite().trim().indexOf("1,1") >= 0))
/* 136 */       return true;
/* 137 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isDeuxLien1101(IhmLien lien1, IhmLien lien2) {
/* 141 */     if ((!islien1101(lien1)) && (!islien1101(lien2))) {
/* 142 */       return false;
/*     */     }
/* 144 */     return true;
/*     */   }
/*     */   
/*     */   public boolean relationDisparait(IhmRelation rel) {
/* 148 */     int nb = 0;
/* 149 */     IhmLien l1 = null;IhmLien l2 = null;
/* 150 */     int n = this.pageMcd.getListeLien().size();
/* 151 */     for (int i = 0; i < n; i++) {
/* 152 */       if (((IhmLien)this.pageMcd.getListeLien().get(i)).getRelation() == rel) {
/* 153 */         nb++;
/* 154 */         if (l1 == null) {
/* 155 */           l1 = (IhmLien)this.pageMcd.getListeLien().get(i);
/*     */         }
/* 157 */         else if (l2 == null) {
/* 158 */           l2 = (IhmLien)this.pageMcd.getListeLien().get(i);
/*     */         }
/*     */       }
/*     */       
/* 162 */       if (nb > 2) return false;
/*     */     }
/* 164 */     if (nb == 2) {
/* 165 */       return isDeuxLien1101(l1, l2);
/*     */     }
/* 167 */     return false;
/*     */   }
/*     */   
/*     */   public int getCondition() {
/* 171 */     int n = 0;
/* 172 */     if (Setting.videNomAss) {
/* 173 */       n = 1;
/*     */     }
/* 175 */     if (Setting.redondNomAss) {
/* 176 */       n = 2;
/*     */     }
/* 178 */     if ((Setting.videNomAss) && (Setting.redondNomAss)) {
/* 179 */       n = 3;
/*     */     }
/* 181 */     return n;
/*     */   }
/*     */   
/*     */   public boolean isCorrectVideRelation() {
/* 185 */     int n = this.pageMcd.getListeEntiteRelation().size();
/* 186 */     for (int i = 0; i < n; i++) {
/* 187 */       if (((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmRelation2)) && 
/* 188 */         (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().length() == 0)) {
/* 189 */         if (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getListeAttributs().size() > 1) {
/* 190 */           this.frm.getConsole().getRapport().append("le nom de la relation ne doit pas être vide \n");
/* 191 */           return false;
/*     */         }
/* 193 */         if (!relationDisparait((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i))) {
/* 194 */           this.frm.getConsole().getRapport().append("le nom de la relation ne doit pas être vide \n");
/* 195 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 201 */     return true;
/*     */   }
/*     */   
/*     */   public boolean existeRelationMemeNom(IhmRelation rel) {
/* 205 */     int n = this.pageMcd.getListeEntiteRelation().size();
/* 206 */     for (int i = 0; i < n; i++) {
/* 207 */       if (this.pageMcd.getListeEntiteRelation().get(i) != rel) {
/* 208 */         if ((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmRelation2)) {
/* 209 */           if ((((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().length() > 0) && 
/* 210 */             (rel.getRelation().getNom().trim().toUpperCase().equals(((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase())) && 
/* 211 */             (!relationDisparait((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)))) {
/* 212 */             this.frm.getConsole().getRapport().append("le nom de la relation \"" + rel.getRelation().getNom() + "\"existe en deux ou plusieurs fois \n");
/* 213 */             return true;
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */         }
/* 219 */         else if (((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmEntite2)) && 
/* 220 */           (rel.getRelation().getNom().trim().toUpperCase().equals(((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase()))) {
/* 221 */           this.frm.getConsole().getRapport().append("le nom de la relation \"" + rel.getRelation().getNom() + "\" existe en deux ou plusieurs fois \n");
/* 222 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 228 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isCorrectRedoandanceRelationSansVide() {
/* 232 */     int n = this.pageMcd.getListeEntiteRelation().size();
/* 233 */     boolean corr = true;
/* 234 */     for (int i = 0; i < n; i++) {
/* 235 */       if (((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmRelation2)) && 
/* 236 */         (!relationDisparait((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i))) && 
/* 237 */         (existeRelationMemeNom((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)))) {
/* 238 */         this.frm.getConsole().getRapport().append("la relation \"" + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + "\" existe deja \n");
/* 239 */         corr = false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 245 */     return corr;
/*     */   }
/*     */   
/*     */   public boolean isCorrectRedoandanceRelationAvecVide() {
/* 249 */     int n = this.pageMcd.getListeEntiteRelation().size();
/* 250 */     boolean corr = true;
/* 251 */     for (int i = 0; i < n; i++) {
/* 252 */       if ((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmRelation2)) {
/* 253 */         if (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().length() > 0) {
/* 254 */           if ((!relationDisparait((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i))) && 
/* 255 */             (existeRelationMemeNom((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)))) {
/* 256 */             this.frm.getConsole().getRapport().append("la relation \"" + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + "\" existe deja \n");
/* 257 */             corr = false;
/*     */           }
/*     */           
/*     */         }
/* 261 */         else if (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getListeAttributs().size() == 0) {
/* 262 */           if (!relationDisparait((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i))) {
/* 263 */             this.frm.getConsole().getRapport().append("il existe des relations sans nom qui ne sont pas des relations binaires avec au moins un lien '0,1' ou '1,1' \n");
/*     */             
/* 265 */             corr = false;
/*     */           }
/*     */         } else {
/* 268 */           this.frm.getConsole().getRapport().append("les relations vides avec des attributs doievnt avoir un nom \n");
/* 269 */           corr = false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 275 */     return corr;
/*     */   }
/*     */   
/*     */   public boolean existeRelationVide() {
/* 279 */     int n = this.pageMcd.getListeEntiteRelation().size();
/* 280 */     for (int i = 0; i < n; i++) {
/* 281 */       if (((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmRelation2)) && 
/* 282 */         (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().equals(""))) { return true;
/*     */       }
/*     */     }
/* 285 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isUnique(IhmEntite ent) {
/* 289 */     int n = this.pageMcd.getListeEntiteRelation().size();
/* 290 */     for (int i = 0; i < n; i++) {
/* 291 */       if ((this.pageMcd.getListeEntiteRelation().get(i) != ent) && 
/* 292 */         ((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmEntite2)) && 
/* 293 */         (ent.getEntite().getNom().trim().toUpperCase().equals(((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase()))) {
/* 294 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 299 */     return true;
/*     */   }
/*     */   
/*     */   public boolean entitesUnique() {
/* 303 */     int n = this.pageMcd.getListeEntiteRelation().size();
/* 304 */     for (int i = 0; i < n; i++) {
/* 305 */       if (((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmEntite2)) && 
/* 306 */         (!isUnique((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)))) {
/* 307 */         this.frm.getConsole().getRapport().append("le nom de l'entite \"" + ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom() + "\" existe en deux ou plusieurs fois \n");
/*     */         
/* 309 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 313 */     return true;
/*     */   }
/*     */   
/*     */   public boolean correctionEntiteRelation()
/*     */   {
/* 318 */     int cond = getCondition();
/* 319 */     if (cond == 0) {
/* 320 */       boolean c2 = existeDoublure();
/* 321 */       boolean c4 = isLienRelatifCorrecte();
/* 322 */       boolean c1 = isCorrecteMCD();
/* 323 */       boolean c3 = existeRelationVide();
/*     */       
/* 325 */       if (c3) this.frm.getConsole().getRapport().append("Il existe des relations vides \n");
/* 326 */       if ((c4) && (c1) && (!c2) && (!c3)) return true;
/* 327 */       return false;
/*     */     }
/* 329 */     if (cond == 1)
/*     */     {
/* 331 */       boolean c2 = entitesUnique();
/* 332 */       boolean c5 = isLienRelatifCorrecte();
/* 333 */       boolean c3 = isCorrecteMCD();
/* 334 */       boolean c1 = isCorrectVideRelation();
/* 335 */       boolean c4 = existeDoublureNonVide();
/* 336 */       if ((c5) && (c1) && (c2) && (c3) && (!c4)) return true;
/* 337 */       return false;
/*     */     }
/* 339 */     if (cond == 2) {
/* 340 */       if (existeRelationVide()) {
/* 341 */         this.frm.getConsole().getRapport().append("Il existe des relations vides \n");
/* 342 */         return false;
/*     */       }
/* 344 */       if (entitesUnique()) {
/* 345 */         boolean c3 = isLienRelatifCorrecte();
/* 346 */         boolean c1 = isCorrecteMCD();
/* 347 */         boolean c2 = isCorrectRedoandanceRelationSansVide();
/* 348 */         if ((c3) && (c1) && (c2)) return true;
/* 349 */         return false;
/*     */       }
/* 351 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 355 */     if (cond == 3) {
/* 356 */       if (entitesUnique()) {
/* 357 */         boolean c2 = isCorrecteMCD();
/* 358 */         boolean c1 = isCorrectRedoandanceRelationAvecVide();
/* 359 */         boolean c3 = isLienRelatifCorrecte();
/* 360 */         if ((c1) && (c2) && (c3)) return true;
/* 361 */         return false;
/*     */       }
/* 363 */       return false;
/*     */     }
/*     */     
/* 366 */     return true;
/*     */   }
/*     */   
/*     */   public boolean uniqueAttributListe(Attribut att, ArrayList<Attribut> liste)
/*     */   {
/* 371 */     for (int i = 0; i < liste.size(); i++) {
/* 372 */       if ((att != liste.get(i)) && 
/* 373 */         (att.getNom().trim().toUpperCase().equals(((Attribut)liste.get(i)).getNom().trim().toUpperCase()))) { return false;
/*     */       }
/*     */     }
/* 376 */     return true;
/*     */   }
/*     */   
/*     */   public boolean uniqueAttribut(Attribut att) {
/* 380 */     int n = this.pageMcd.getListeEntiteRelation().size();
/* 381 */     for (int i = 0; i < n; i++) {
/* 382 */       if (((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmEntite2)) && 
/* 383 */         (!uniqueAttributListe(att, ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getListeAttributs()))) {
/* 384 */         return false;
/*     */       }
/*     */       
/* 387 */       if (((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmRelation2)) && 
/* 388 */         (!uniqueAttributListe(att, ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getListeAttributs()))) {
/* 389 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 393 */     return true;
/*     */   }
/*     */   
/*     */   public boolean uniqueAttributToutMCD() {
/* 397 */     int n = this.pageMcd.getListeEntiteRelation().size();
/*     */     
/* 399 */     boolean corr = true;
/*     */     
/* 401 */     for (int i = 0; i < n; i++) {
/* 402 */       if ((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmEntite2)) {
/* 403 */         ArrayList<Attribut> liste = ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getListeAttributs();
/* 404 */         int m = liste.size();
/* 405 */         for (int j = 0; j < m; j++) {
/* 406 */           if (!uniqueAttribut((Attribut)liste.get(j))) {
/* 407 */             corr = false;
/* 408 */             this.frm.getConsole().getRapport().append("attribut : \"" + ((Attribut)liste.get(j)).getNom() + "\" de l'entité " + ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom() + " n'est pas unique dans le MCD \n");
/*     */           }
/*     */         }
/*     */       }
/* 412 */       if ((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmRelation2)) {
/* 413 */         ArrayList<Attribut> liste = ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getListeAttributs();
/* 414 */         int m = liste.size();
/* 415 */         for (int j = 0; j < m; j++) {
/* 416 */           if (!uniqueAttribut((Attribut)liste.get(j))) {
/* 417 */             corr = false;
/* 418 */             this.frm.getConsole().getRapport().append("attribut : " + ((Attribut)liste.get(j)).getNom() + " de la relation " + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + " n'est pas unique dans le MCD \n");
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 423 */     return corr;
/*     */   }
/*     */   
/*     */   private boolean existeDoublureNonVide() {
/* 427 */     boolean trouver = false;
/*     */     
/* 429 */     for (int i = 0; i < this.pageMcd.getListeEntiteRelation().size(); i++) {
/* 430 */       for (int j = i + 1; j < this.pageMcd.getListeEntiteRelation().size(); j++) {
/* 431 */         if (((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) {
/* 432 */           if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) && 
/* 433 */             (((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase().equals(((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(j)).getEntite().getNom().trim().toUpperCase()))) {
/* 434 */             trouver = true;
/* 435 */             this.frm.getConsole().getRapport().append("Il existe deux entités qui ont le même nom : " + ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom() + "\n");
/*     */           }
/*     */           
/*     */ 
/* 439 */           if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2")) && 
/* 440 */             (((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase().equals(((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(j)).getRelation().getNom().trim().toUpperCase()))) {
/* 441 */             trouver = true;
/* 442 */             this.frm.getConsole().getRapport().append("Il existe une entité et une relation qui ont le même nom : " + ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom() + "\n");
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 447 */         if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2")) && 
/* 448 */           (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().length() > 0)) {
/* 449 */           if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) && 
/* 450 */             (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase().equals(((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(j)).getEntite().getNom().trim().toUpperCase()))) {
/* 451 */             trouver = true;
/* 452 */             this.frm.getConsole().getRapport().append("Il existe une entité et une relation qui ont le même nom : " + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + "\n");
/*     */           }
/*     */           
/* 455 */           if (((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2"))
/*     */           {
/* 457 */             if (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase().equals(((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(j)).getRelation().getNom().trim().toUpperCase())) {
/* 458 */               trouver = true;
/* 459 */               this.frm.getConsole().getRapport().append("Il existe deux relation qui ont le même nom : " + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + "\n");
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 467 */     return trouver;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean existeDoublure()
/*     */   {
/* 473 */     boolean trouver = false;
/* 474 */     for (int i = 0; i < this.pageMcd.getListeEntiteRelation().size(); i++) {
/* 475 */       for (int j = i + 1; j < this.pageMcd.getListeEntiteRelation().size(); j++) {
/* 476 */         if (((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2"))
/*     */         {
/* 478 */           if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) && 
/* 479 */             (((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase().equals(((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(j)).getEntite().getNom().trim().toUpperCase()))) {
/* 480 */             trouver = true;
/* 481 */             this.frm.getConsole().getRapport().append("Il existe deux entités qui ont le même nom : " + ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom() + "\n");
/*     */           }
/*     */           
/*     */ 
/* 485 */           if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2")) && 
/* 486 */             (((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase().equals(((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(j)).getRelation().getNom().trim().toUpperCase()))) {
/* 487 */             trouver = true;
/* 488 */             this.frm.getConsole().getRapport().append("Il existe une entité et une relation qui ont le même nom : " + ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom() + "\n");
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 493 */         if (((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2"))
/*     */         {
/* 495 */           if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) && 
/* 496 */             (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase().equals(((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(j)).getEntite().getNom().trim().toUpperCase()))) {
/* 497 */             trouver = true;
/* 498 */             this.frm.getConsole().getRapport().append("Il existe une entité et une relation qui ont le même nom : " + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + "\n");
/*     */           }
/*     */           
/* 501 */           if (((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2"))
/*     */           {
/* 503 */             if (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase().equals(((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(j)).getRelation().getNom().trim().toUpperCase())) {
/* 504 */               trouver = true;
/* 505 */               this.frm.getConsole().getRapport().append("Il existe deux relations qui ont le même nom : " + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + "\n");
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 512 */     return trouver;
/*     */   }
/*     */   
/*     */   private boolean existeCleListeAttribut(ArrayList<Attribut> liste) {
/* 516 */     for (int i = 0; i < liste.size(); i++) {
/* 517 */       if (((Attribut)liste.get(i)).getKey().trim().equals(Parametres.Cle)) return true;
/*     */     }
/* 519 */     return false;
/*     */   }
/*     */   
/*     */   private IhmEntite getPereEntite(IhmEntite ent) {
/* 523 */     for (int i = 0; i < this.pageMcd.getListeLienHeritage().size(); i++) {
/* 524 */       if (ent == ((IhmLienHeritage2)this.pageMcd.getListeLienHeritage().get(i)).getFils()) return (IhmEntite)((IhmLienHeritage2)this.pageMcd.getListeLienHeritage().get(i)).getPere();
/*     */     }
/* 526 */     return null;
/*     */   }
/*     */   
/*     */   private boolean existeCleEntitePere(IhmEntite ent) {
/* 530 */     if (existeCleListeAttribut(ent.getEntite().getListeAttributs())) return true;
/* 531 */     IhmEntite entT = getPereEntite(ent);
/* 532 */     while (entT != null) {
/* 533 */       if (existeCleListeAttribut(entT.getEntite().getListeAttributs())) return true;
/* 534 */       entT = getPereEntite(entT);
/*     */     }
/* 536 */     return false;
/*     */   }
/*     */   
/*     */   private boolean estFilsDe(IhmEntite ent) {
/* 540 */     for (int i = 0; i < this.pageMcd.getListeLienHeritage().size(); i++) {
/* 541 */       if (((IhmLienHeritage2)this.pageMcd.getListeLienHeritage().get(i)).getFils().equals(ent)) return true;
/*     */     }
/* 543 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isLienCorrecte(IhmRelation rel) {
/* 547 */     int nb = 0;
/* 548 */     for (int i = 0; i < this.pageMcd.getListeLien().size(); i++) {
/* 549 */       if (((IhmLien)this.pageMcd.getListeLien().get(i)).getRelation().equals(rel)) {
/* 550 */         nb++;
/* 551 */         if (nb == 2) return true;
/*     */       }
/*     */     }
/* 554 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isCorrecteMCD() {
/* 558 */     boolean trouver = true;
/* 559 */     for (int i = 0; i < this.pageMcd.getListeEntiteRelation().size(); i++) {
/* 560 */       if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) && 
/* 561 */         (!existeCleEntitePere((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i))) && 
/* 562 */         (!estFilsDe((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i))) && 
/* 563 */         (!isCleAvecLienRelatif((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)))) {
/* 564 */         this.frm.getConsole().getRapport().append("L'entite : " + ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom() + " n'a pas d'attribut ou d'attribut clé \n");
/* 565 */         trouver = false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 570 */       if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2")) && 
/* 571 */         (!isLienCorrecte((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)))) {
/* 572 */         trouver = false;
/* 573 */         this.frm.getConsole().getRapport().append("La relation : " + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + " n'a qu'un seul lien \n");
/*     */       }
/*     */     }
/*     */     
/* 577 */     return trouver;
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
/*     */   private boolean verificationCoorect(FormeConstruction frmCons)
/*     */   {
/* 622 */     boolean rep = true;
/*     */     
/* 624 */     frmCons.getjProgBar().setValue(10);
/*     */     
/*     */ 
/*     */ 
/* 628 */     frmCons.getjProgBar().setValue(20);
/* 629 */     String msg = Verification.verifierAllNomEntite(this.pageMcd.getListeEntiteRelation());
/* 630 */     if (msg.trim().length() > 0) {
/* 631 */       this.frm.getConsole().getRapport().append(msg + "\n");
/* 632 */       rep = false;
/*     */     }
/*     */     
/* 635 */     msg = Verification.verifierAllAttributEntite(this.pageMcd.getListeEntiteRelation(), this.pageMcd.getListeDomaine());
/* 636 */     if (msg.trim().length() > 0) {
/* 637 */       this.frm.getConsole().getRapport().append(msg + "\n");
/* 638 */       rep = false;
/*     */     }
/*     */     
/* 641 */     msg = Verification.verifierPatteRelation();
/* 642 */     if (msg.trim().length() > 0) {
/* 643 */       this.frm.getConsole().getRapport().append(msg + "\n");
/* 644 */       rep = false;
/* 645 */       return rep;
/*     */     }
/*     */     
/* 648 */     msg = Verification.verifierExiste2RelLienRelatif();
/* 649 */     if (msg.trim().length() > 0) {
/* 650 */       this.frm.getConsole().getRapport().append(msg + "\n");
/* 651 */       rep = false;
/* 652 */       return rep;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 663 */     msg = Verification.verifierCleEntite(this.pageMcd.getListeEntiteRelation(), this.pageMcd.getListeLienHeritage(), this.pageMcd.getListeLien());
/* 664 */     if (msg.trim().length() > 0) {
/* 665 */       this.frm.getConsole().getRapport().append(msg + "\n");
/* 666 */       rep = false;
/* 667 */       return rep;
/*     */     }
/*     */     
/* 670 */     return rep;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected Object doInBackground()
/*     */     throws Exception
/*     */   {
/* 678 */     this.frm.getConsole().getRapport().setText("");
/*     */     
/* 680 */     FormeConstruction frmCons = new FormeConstruction(this.frm, true);
/* 681 */     frmCons.getjLabNom().setText("Vérification MCD");
/* 682 */     frmCons.setModal(false);
/* 683 */     frmCons.setVisible(true);
/* 684 */     frmCons.getjProgBar().setValue(0);
/*     */     
/* 686 */     frmCons.getjProgBar().setValue(5);
/*     */     
/*     */ 
/* 689 */     boolean rep = verificationCoorect(frmCons);
/* 690 */     frmCons.dispose();
/* 691 */     if (rep) {
/* 692 */       this.frm.getConsole().getRapport().setBackground(Color.CYAN);
/* 693 */       this.frm.getConsole().getRapport().append("Le MCD est correct");
/* 694 */       JOptionPane.showConfirmDialog(frmCons, "le MCD est Correct", "Vérification du MCD ", -1, 1);
/*     */     } else {
/* 696 */       this.frm.getConsole().getRapport().setBackground(Color.WHITE);
/* 697 */       this.frm.getConsole().getRapport().append("ERREUR : Le MCD est incorrect");
/* 698 */       JOptionPane.showConfirmDialog(frmCons, "le MCD n'est pas correct !!! \nVoir messages dans console !", "Vérification du MCD ", -1, 0);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 703 */     return Integer.valueOf(0);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\mythread\ThreadVerifMCD2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */