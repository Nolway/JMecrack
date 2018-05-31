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
/*     */ import Merise.Domaine;
/*     */ import Merise.Entite;
/*     */ import Merise.Relation;
/*     */ import MyExplorer.ConsolePane;
/*     */ import Outil.Parametres;
/*     */ import Outil.Setting;
/*     */ import ihm.Principale;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.SwingWorker;
/*     */ 
/*     */ 
/*     */ public class ThreadVerifMCD
/*     */   extends SwingWorker
/*     */ {
/*     */   private IhmPageMCD pageMcd;
/*     */   private Principale frm;
/*     */   
/*     */   public ThreadVerifMCD(Principale frm)
/*     */   {
/*  33 */     this.pageMcd = frm.getPage();
/*  34 */     this.frm = frm;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isRelationDeuxliens(IhmRelation rel)
/*     */   {
/*  40 */     int nb = 0;
/*  41 */     int n = this.pageMcd.getListeLien().size();
/*  42 */     for (int i = 0; i < n; i++) {
/*  43 */       if (((IhmLien)this.pageMcd.getListeLien().get(i)).getRelation() == rel) nb++;
/*  44 */       if (nb > 2) return false;
/*     */     }
/*  46 */     if (nb == 2) return true;
/*  47 */     return false;
/*     */   }
/*     */   
/*     */   public IhmLien getDeuxiemeLien(IhmRelation rel, IhmLien l) {
/*  51 */     int n = this.pageMcd.getListeLien().size();
/*  52 */     for (int i = 0; i < n; i++) {
/*  53 */       if (!isRelationDeuxliens(rel)) return null;
/*  54 */       if ((((IhmLien)this.pageMcd.getListeLien().get(i)).getRelation() == rel) && 
/*  55 */         (this.pageMcd.getListeLien().get(i) != l)) { return (IhmLien)this.pageMcd.getListeLien().get(i);
/*     */       }
/*     */     }
/*  58 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isLienRelatifCorrecte(IhmLien li1) {
/*  62 */     IhmLien l2 = getDeuxiemeLien(li1.getRelation(), li1);
/*  63 */     if (l2 == null) {
/*  64 */       this.frm.getConsole().getRapport().append("Lien relatif : la relation \"" + li1.getRelation().getRelation().getNom() + "\" contient un seul lien\n");
/*  65 */       return false;
/*     */     }
/*  67 */     if (l2.getEntite().getEntite().getCle().size() == 0) {
/*  68 */       this.frm.getConsole().getRapport().append("Lien relatif : l'entite \"" + l2.getEntite().getEntite().getNom() + "\" ne contient pas de clé primaire \n");
/*  69 */       return false;
/*     */     }
/*  71 */     if (l2.getCardinalite().trim().indexOf("(") >= 0) {
/*  72 */       this.frm.getConsole().getRapport().append("Lien relatif : le lien entre l'entite \"" + l2.getEntite().getEntite().getNom() + "\" et la relation \"" + l2.getRelation().getRelation().getNom() + "\" ne doit pas être un lien faible \n");
/*  73 */       return false;
/*     */     }
/*  75 */     if ((l2.getCardinalite().trim().indexOf("0,n") < 0) && (l2.getCardinalite().trim().indexOf("1,n") < 0)) {
/*  76 */       this.frm.getConsole().getRapport().append("Lien relatif : le lien entre l'entite \"" + l2.getEntite().getEntite().getNom() + "\" et la relation \"" + l2.getRelation().getRelation().getNom() + "\" doit être de type '0,n' ou '1,n'\n");
/*  77 */       return false;
/*     */     }
/*     */     
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isLienRelatifCorrecte() {
/*  84 */     int n = this.pageMcd.getListeLien().size();
/*  85 */     boolean cor = true;
/*  86 */     for (int i = 0; i < n; i++) {
/*  87 */       if (((IhmLien)this.pageMcd.getListeLien().get(i)).getCardinalite().indexOf("(") >= 0) {
/*  88 */         if (((IhmLien)this.pageMcd.getListeLien().get(i)).getCardinalite().indexOf("1,1") >= 0) {
/*  89 */           if (!isLienRelatifCorrecte((IhmLien)this.pageMcd.getListeLien().get(i))) {
/*  90 */             cor = false;
/*     */           }
/*     */         } else {
/*  93 */           this.frm.getConsole().getRapport().append("Lien relatif : le lien entre l'entité \"" + ((IhmLien)this.pageMcd.getListeLien().get(i)).getEntite().getEntite().getNom() + "\" et la relation \"" + ((IhmLien)this.pageMcd.getListeLien().get(i)).getRelation().getRelation().getNom() + "\" doit être de cette forme (1,1)\n");
/*  94 */           cor = false;
/*     */         }
/*     */       }
/*     */     }
/*  98 */     return cor;
/*     */   }
/*     */   
/*     */   public ArrayList<IhmLien> getLienRelatifEntite(IhmEntite ent) {
/* 102 */     ArrayList<IhmLien> l = new ArrayList();
/* 103 */     int n = this.pageMcd.getListeLien().size();
/* 104 */     for (int i = 0; i < n; i++) {
/* 105 */       if ((((IhmLien)this.pageMcd.getListeLien().get(i)).getEntite() == ent) && 
/* 106 */         (((IhmLien)this.pageMcd.getListeLien().get(i)).getCardinalite().equals("(1,1)"))) {
/* 107 */         l.add(this.pageMcd.getListeLien().get(i));
/*     */       }
/*     */     }
/* 110 */     return l;
/*     */   }
/*     */   
/*     */   public boolean isCleAvecLienRelatif(IhmEntite ent) {
/* 114 */     ArrayList<IhmLien> l = getLienRelatifEntite(ent);
/*     */     
/* 116 */     if (l == null) return false;
/* 117 */     if (l.size() == 0) return false;
/* 118 */     for (int i = 0; i < l.size(); i++) {
/* 119 */       IhmLien l2 = getDeuxiemeLien(((IhmLien)l.get(i)).getRelation(), (IhmLien)l.get(i));
/* 120 */       if ((l2 != null) && 
/* 121 */         (l2.getEntite().getEntite().getCle() != null) && 
/* 122 */         (l2.getEntite().getEntite().getCle().size() > 0)) {
/* 123 */         return true;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 128 */     return false;
/*     */   }
/*     */   
/*     */   public boolean islien1101(IhmLien lien) {
/* 132 */     if ((lien.getCardinalite().trim().indexOf("0,1") >= 0) || (lien.getCardinalite().trim().indexOf("1,1") >= 0))
/* 133 */       return true;
/* 134 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isDeuxLien1101(IhmLien lien1, IhmLien lien2) {
/* 138 */     if ((!islien1101(lien1)) && (!islien1101(lien2))) {
/* 139 */       return false;
/*     */     }
/* 141 */     return true;
/*     */   }
/*     */   
/*     */   public boolean relationDisparait(IhmRelation rel) {
/* 145 */     int nb = 0;
/* 146 */     IhmLien l1 = null;IhmLien l2 = null;
/* 147 */     int n = this.pageMcd.getListeLien().size();
/* 148 */     for (int i = 0; i < n; i++) {
/* 149 */       if (((IhmLien)this.pageMcd.getListeLien().get(i)).getRelation() == rel) {
/* 150 */         nb++;
/* 151 */         if (l1 == null) {
/* 152 */           l1 = (IhmLien)this.pageMcd.getListeLien().get(i);
/*     */         }
/* 154 */         else if (l2 == null) {
/* 155 */           l2 = (IhmLien)this.pageMcd.getListeLien().get(i);
/*     */         }
/*     */       }
/*     */       
/* 159 */       if (nb > 2) return false;
/*     */     }
/* 161 */     if (nb == 2) {
/* 162 */       return isDeuxLien1101(l1, l2);
/*     */     }
/* 164 */     return false;
/*     */   }
/*     */   
/*     */   public int getCondition() {
/* 168 */     int n = 0;
/* 169 */     if (Setting.videNomAss) {
/* 170 */       n = 1;
/*     */     }
/* 172 */     if (Setting.redondNomAss) {
/* 173 */       n = 2;
/*     */     }
/* 175 */     if ((Setting.videNomAss) && (Setting.redondNomAss)) {
/* 176 */       n = 3;
/*     */     }
/* 178 */     return n;
/*     */   }
/*     */   
/*     */   public boolean isCorrectVideRelation() {
/* 182 */     int n = this.pageMcd.getListeEntiteRelation().size();
/* 183 */     for (int i = 0; i < n; i++) {
/* 184 */       if (((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmRelation2)) && 
/* 185 */         (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().length() == 0)) {
/* 186 */         if (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getListeAttributs().size() > 1) {
/* 187 */           this.frm.getConsole().getRapport().append("le nom de la relation ne doit pas être vide \n");
/* 188 */           return false;
/*     */         }
/* 190 */         if (!relationDisparait((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i))) {
/* 191 */           this.frm.getConsole().getRapport().append("le nom de la relation ne doit pas être vide \n");
/* 192 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 198 */     return true;
/*     */   }
/*     */   
/*     */   public boolean existeRelationMemeNom(IhmRelation rel) {
/* 202 */     int n = this.pageMcd.getListeEntiteRelation().size();
/* 203 */     for (int i = 0; i < n; i++) {
/* 204 */       if (this.pageMcd.getListeEntiteRelation().get(i) != rel) {
/* 205 */         if ((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmRelation2)) {
/* 206 */           if ((((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().length() > 0) && 
/* 207 */             (rel.getRelation().getNom().trim().toUpperCase().equals(((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase())) && 
/* 208 */             (!relationDisparait((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)))) {
/* 209 */             this.frm.getConsole().getRapport().append("le nom de la relation \"" + rel.getRelation().getNom() + "\"existe en deux ou plusieurs fois \n");
/* 210 */             return true;
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */         }
/* 216 */         else if (((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmEntite2)) && 
/* 217 */           (rel.getRelation().getNom().trim().toUpperCase().equals(((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase()))) {
/* 218 */           this.frm.getConsole().getRapport().append("le nom de la relation \"" + rel.getRelation().getNom() + "\" existe en deux ou plusieurs fois \n");
/* 219 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 225 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isCorrectRedoandanceRelationSansVide() {
/* 229 */     int n = this.pageMcd.getListeEntiteRelation().size();
/* 230 */     boolean corr = true;
/* 231 */     for (int i = 0; i < n; i++) {
/* 232 */       if (((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmRelation2)) && 
/* 233 */         (!relationDisparait((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i))) && 
/* 234 */         (existeRelationMemeNom((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)))) {
/* 235 */         this.frm.getConsole().getRapport().append("la relation \"" + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + "\" existe deja \n");
/* 236 */         corr = false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 242 */     return corr;
/*     */   }
/*     */   
/*     */   public boolean isCorrectRedoandanceRelationAvecVide() {
/* 246 */     int n = this.pageMcd.getListeEntiteRelation().size();
/* 247 */     boolean corr = true;
/* 248 */     for (int i = 0; i < n; i++) {
/* 249 */       if ((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmRelation2)) {
/* 250 */         if (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().length() > 0) {
/* 251 */           if ((!relationDisparait((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i))) && 
/* 252 */             (existeRelationMemeNom((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)))) {
/* 253 */             this.frm.getConsole().getRapport().append("la relation \"" + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + "\" existe deja \n");
/* 254 */             corr = false;
/*     */           }
/*     */           
/*     */         }
/* 258 */         else if (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getListeAttributs().size() == 0) {
/* 259 */           if (!relationDisparait((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i))) {
/* 260 */             this.frm.getConsole().getRapport().append("il existe des relations sans nom qui ne sont pas des relations binaires avec au moins un lien '0,1' ou '1,1' \n");
/*     */             
/* 262 */             corr = false;
/*     */           }
/*     */         } else {
/* 265 */           this.frm.getConsole().getRapport().append("les relations vides avec des attributs doievnt avoir un nom \n");
/* 266 */           corr = false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 272 */     return corr;
/*     */   }
/*     */   
/*     */   public boolean existeRelationVide() {
/* 276 */     int n = this.pageMcd.getListeEntiteRelation().size();
/* 277 */     for (int i = 0; i < n; i++) {
/* 278 */       if (((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmRelation2)) && 
/* 279 */         (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().equals(""))) { return true;
/*     */       }
/*     */     }
/* 282 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isUnique(IhmEntite ent) {
/* 286 */     int n = this.pageMcd.getListeEntiteRelation().size();
/* 287 */     for (int i = 0; i < n; i++) {
/* 288 */       if ((this.pageMcd.getListeEntiteRelation().get(i) != ent) && 
/* 289 */         ((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmEntite2)) && 
/* 290 */         (ent.getEntite().getNom().trim().toUpperCase().equals(((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase()))) {
/* 291 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 296 */     return true;
/*     */   }
/*     */   
/*     */   public boolean entitesUnique() {
/* 300 */     int n = this.pageMcd.getListeEntiteRelation().size();
/* 301 */     for (int i = 0; i < n; i++) {
/* 302 */       if (((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmEntite2)) && 
/* 303 */         (!isUnique((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)))) {
/* 304 */         this.frm.getConsole().getRapport().append("le nom de l'entite \"" + ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom() + "\" existe en deux ou plusieurs fois \n");
/*     */         
/* 306 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 310 */     return true;
/*     */   }
/*     */   
/*     */   public boolean correctionEntiteRelation()
/*     */   {
/* 315 */     int cond = getCondition();
/* 316 */     if (cond == 0) {
/* 317 */       boolean c2 = existeDoublure();
/* 318 */       boolean c4 = isLienRelatifCorrecte();
/* 319 */       boolean c1 = isCorrecteMCD();
/* 320 */       boolean c3 = existeRelationVide();
/*     */       
/* 322 */       if (c3) this.frm.getConsole().getRapport().append("Il existe des relations vides \n");
/* 323 */       if ((c4) && (c1) && (!c2) && (!c3)) return true;
/* 324 */       return false;
/*     */     }
/* 326 */     if (cond == 1)
/*     */     {
/* 328 */       boolean c2 = entitesUnique();
/* 329 */       boolean c5 = isLienRelatifCorrecte();
/* 330 */       boolean c3 = isCorrecteMCD();
/* 331 */       boolean c1 = isCorrectVideRelation();
/* 332 */       boolean c4 = existeDoublureNonVide();
/* 333 */       if ((c5) && (c1) && (c2) && (c3) && (!c4)) return true;
/* 334 */       return false;
/*     */     }
/* 336 */     if (cond == 2) {
/* 337 */       if (existeRelationVide()) {
/* 338 */         this.frm.getConsole().getRapport().append("Il existe des relations vides \n");
/* 339 */         return false;
/*     */       }
/* 341 */       if (entitesUnique()) {
/* 342 */         boolean c3 = isLienRelatifCorrecte();
/* 343 */         boolean c1 = isCorrecteMCD();
/* 344 */         boolean c2 = isCorrectRedoandanceRelationSansVide();
/* 345 */         if ((c3) && (c1) && (c2)) return true;
/* 346 */         return false;
/*     */       }
/* 348 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 352 */     if (cond == 3) {
/* 353 */       if (entitesUnique()) {
/* 354 */         boolean c2 = isCorrecteMCD();
/* 355 */         boolean c1 = isCorrectRedoandanceRelationAvecVide();
/* 356 */         boolean c3 = isLienRelatifCorrecte();
/* 357 */         if ((c1) && (c2) && (c3)) return true;
/* 358 */         return false;
/*     */       }
/* 360 */       return false;
/*     */     }
/*     */     
/* 363 */     return true;
/*     */   }
/*     */   
/*     */   public boolean uniqueAttributListe(Attribut att, ArrayList<Attribut> liste)
/*     */   {
/* 368 */     for (int i = 0; i < liste.size(); i++) {
/* 369 */       if ((att != liste.get(i)) && 
/* 370 */         (att.getNom().trim().toUpperCase().equals(((Attribut)liste.get(i)).getNom().trim().toUpperCase()))) { return false;
/*     */       }
/*     */     }
/* 373 */     return true;
/*     */   }
/*     */   
/*     */   public boolean uniqueAttribut(Attribut att) {
/* 377 */     int n = this.pageMcd.getListeEntiteRelation().size();
/* 378 */     for (int i = 0; i < n; i++) {
/* 379 */       if (((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmEntite2)) && 
/* 380 */         (!uniqueAttributListe(att, ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getListeAttributs()))) {
/* 381 */         return false;
/*     */       }
/*     */       
/* 384 */       if (((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmRelation2)) && 
/* 385 */         (!uniqueAttributListe(att, ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getListeAttributs()))) {
/* 386 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 390 */     return true;
/*     */   }
/*     */   
/*     */   public boolean uniqueAttributToutMCD() {
/* 394 */     int n = this.pageMcd.getListeEntiteRelation().size();
/*     */     
/* 396 */     boolean corr = true;
/*     */     
/* 398 */     for (int i = 0; i < n; i++) {
/* 399 */       if ((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmEntite2)) {
/* 400 */         ArrayList<Attribut> liste = ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getListeAttributs();
/* 401 */         int m = liste.size();
/* 402 */         for (int j = 0; j < m; j++) {
/* 403 */           if (!uniqueAttribut((Attribut)liste.get(j))) {
/* 404 */             corr = false;
/* 405 */             this.frm.getConsole().getRapport().append("attribut : \"" + ((Attribut)liste.get(j)).getNom() + "\" de l'entité " + ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom() + " n'est pas unique dans le MCD \n");
/*     */           }
/*     */         }
/*     */       }
/* 409 */       if ((this.pageMcd.getListeEntiteRelation().get(i) instanceof IhmRelation2)) {
/* 410 */         ArrayList<Attribut> liste = ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getListeAttributs();
/* 411 */         int m = liste.size();
/* 412 */         for (int j = 0; j < m; j++) {
/* 413 */           if (!uniqueAttribut((Attribut)liste.get(j))) {
/* 414 */             corr = false;
/* 415 */             this.frm.getConsole().getRapport().append("attribut : " + ((Attribut)liste.get(j)).getNom() + " de la relation " + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + " n'est pas unique dans le MCD \n");
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 420 */     return corr;
/*     */   }
/*     */   
/*     */   private boolean existeDoublureNonVide() {
/* 424 */     boolean trouver = false;
/*     */     
/* 426 */     for (int i = 0; i < this.pageMcd.getListeEntiteRelation().size(); i++) {
/* 427 */       for (int j = i + 1; j < this.pageMcd.getListeEntiteRelation().size(); j++) {
/* 428 */         if (((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) {
/* 429 */           if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) && 
/* 430 */             (((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase().equals(((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(j)).getEntite().getNom().trim().toUpperCase()))) {
/* 431 */             trouver = true;
/* 432 */             this.frm.getConsole().getRapport().append("Il existe deux entités qui ont le même nom : " + ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom() + "\n");
/*     */           }
/*     */           
/*     */ 
/* 436 */           if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2")) && 
/* 437 */             (((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase().equals(((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(j)).getRelation().getNom().trim().toUpperCase()))) {
/* 438 */             trouver = true;
/* 439 */             this.frm.getConsole().getRapport().append("Il existe une entité et une relation qui ont le même nom : " + ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom() + "\n");
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 444 */         if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2")) && 
/* 445 */           (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().length() > 0)) {
/* 446 */           if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) && 
/* 447 */             (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase().equals(((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(j)).getEntite().getNom().trim().toUpperCase()))) {
/* 448 */             trouver = true;
/* 449 */             this.frm.getConsole().getRapport().append("Il existe une entité et une relation qui ont le même nom : " + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + "\n");
/*     */           }
/*     */           
/* 452 */           if (((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2"))
/*     */           {
/* 454 */             if (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase().equals(((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(j)).getRelation().getNom().trim().toUpperCase())) {
/* 455 */               trouver = true;
/* 456 */               this.frm.getConsole().getRapport().append("Il existe deux relation qui ont le même nom : " + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + "\n");
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 464 */     return trouver;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean existeDoublure()
/*     */   {
/* 470 */     boolean trouver = false;
/* 471 */     for (int i = 0; i < this.pageMcd.getListeEntiteRelation().size(); i++) {
/* 472 */       for (int j = i + 1; j < this.pageMcd.getListeEntiteRelation().size(); j++) {
/* 473 */         if (((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2"))
/*     */         {
/* 475 */           if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) && 
/* 476 */             (((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase().equals(((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(j)).getEntite().getNom().trim().toUpperCase()))) {
/* 477 */             trouver = true;
/* 478 */             this.frm.getConsole().getRapport().append("Il existe deux entités qui ont le même nom : " + ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom() + "\n");
/*     */           }
/*     */           
/*     */ 
/* 482 */           if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2")) && 
/* 483 */             (((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase().equals(((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(j)).getRelation().getNom().trim().toUpperCase()))) {
/* 484 */             trouver = true;
/* 485 */             this.frm.getConsole().getRapport().append("Il existe une entité et une relation qui ont le même nom : " + ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom() + "\n");
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 490 */         if (((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2"))
/*     */         {
/* 492 */           if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) && 
/* 493 */             (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase().equals(((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(j)).getEntite().getNom().trim().toUpperCase()))) {
/* 494 */             trouver = true;
/* 495 */             this.frm.getConsole().getRapport().append("Il existe une entité et une relation qui ont le même nom : " + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + "\n");
/*     */           }
/*     */           
/* 498 */           if (((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2"))
/*     */           {
/* 500 */             if (((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase().equals(((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(j)).getRelation().getNom().trim().toUpperCase())) {
/* 501 */               trouver = true;
/* 502 */               this.frm.getConsole().getRapport().append("Il existe deux relations qui ont le même nom : " + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + "\n");
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 509 */     return trouver;
/*     */   }
/*     */   
/*     */   private boolean existeCleListeAttribut(ArrayList<Attribut> liste) {
/* 513 */     for (int i = 0; i < liste.size(); i++) {
/* 514 */       if (((Attribut)liste.get(i)).getKey().trim().equals(Parametres.Cle)) return true;
/*     */     }
/* 516 */     return false;
/*     */   }
/*     */   
/*     */   private IhmEntite getPereEntite(IhmEntite ent) {
/* 520 */     for (int i = 0; i < this.pageMcd.getListeLienHeritage().size(); i++) {
/* 521 */       if (ent == ((IhmLienHeritage2)this.pageMcd.getListeLienHeritage().get(i)).getFils()) return (IhmEntite)((IhmLienHeritage2)this.pageMcd.getListeLienHeritage().get(i)).getPere();
/*     */     }
/* 523 */     return null;
/*     */   }
/*     */   
/*     */   private boolean existeCleEntitePere(IhmEntite ent) {
/* 527 */     if (existeCleListeAttribut(ent.getEntite().getListeAttributs())) return true;
/* 528 */     IhmEntite entT = getPereEntite(ent);
/* 529 */     while (entT != null) {
/* 530 */       if (existeCleListeAttribut(entT.getEntite().getListeAttributs())) return true;
/* 531 */       entT = getPereEntite(entT);
/*     */     }
/* 533 */     return false;
/*     */   }
/*     */   
/*     */   private boolean estFilsDe(IhmEntite ent) {
/* 537 */     for (int i = 0; i < this.pageMcd.getListeLienHeritage().size(); i++) {
/* 538 */       if (((IhmLienHeritage2)this.pageMcd.getListeLienHeritage().get(i)).getFils().equals(ent)) return true;
/*     */     }
/* 540 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isLienCorrecte(IhmRelation rel) {
/* 544 */     int nb = 0;
/* 545 */     for (int i = 0; i < this.pageMcd.getListeLien().size(); i++) {
/* 546 */       if (((IhmLien)this.pageMcd.getListeLien().get(i)).getRelation().equals(rel)) {
/* 547 */         nb++;
/* 548 */         if (nb == 2) return true;
/*     */       }
/*     */     }
/* 551 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isCorrecteMCD() {
/* 555 */     boolean trouver = true;
/* 556 */     for (int i = 0; i < this.pageMcd.getListeEntiteRelation().size(); i++) {
/* 557 */       if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) && 
/* 558 */         (!existeCleEntitePere((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i))) && 
/* 559 */         (!estFilsDe((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i))) && 
/* 560 */         (!isCleAvecLienRelatif((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)))) {
/* 561 */         this.frm.getConsole().getRapport().append("L'entite : " + ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom() + " n'a pas d'attribut ou d'attribut clé \n");
/* 562 */         trouver = false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 567 */       if ((((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2")) && 
/* 568 */         (!isLienCorrecte((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)))) {
/* 569 */         trouver = false;
/* 570 */         this.frm.getConsole().getRapport().append("La relation : " + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + " n'a qu'un seul lien \n");
/*     */       }
/*     */     }
/*     */     
/* 574 */     return trouver;
/*     */   }
/*     */   
/*     */   private boolean existeDomaine(String domaine) {
/* 578 */     for (int i = 0; i < Parametres.DomaineDefini.length; i++) {
/* 579 */       if (domaine.trim().toUpperCase().equals(Parametres.DomaineDefini[i].trim().toUpperCase())) return true;
/*     */     }
/* 581 */     for (int i = 0; i < this.pageMcd.getListeDomaine().size(); i++) {
/* 582 */       if (domaine.trim().toUpperCase().equals(((Domaine)this.pageMcd.getListeDomaine().get(i)).getNom().trim().toUpperCase())) return true;
/*     */     }
/* 584 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isCorrectDomaine() {
/* 588 */     boolean correc = true;
/*     */     
/* 590 */     for (int i = 0; i < this.pageMcd.getListeEntiteRelation().size(); i++) {
/* 591 */       if (((IhmEntiteRelation)this.pageMcd.getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) {
/* 592 */         for (int j = 0; j < ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getListeAttributs().size(); j++) {
/* 593 */           if (!existeDomaine(((Attribut)((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getType())) {
/* 594 */             correc = false;
/* 595 */             this.frm.getConsole().getRapport().append("Le domaine " + ((Attribut)((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getType() + " de l'attribut " + ((Attribut)((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getNom() + " de l'entite " + ((IhmEntite2)this.pageMcd.getListeEntiteRelation().get(i)).getEntite().getNom() + " n'est pas défini " + "\n");
/*     */           }
/*     */           
/*     */         }
/*     */         
/*     */       } else {
/* 601 */         for (int j = 0; j < ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getListeAttributs().size(); j++) {
/* 602 */           if (!existeDomaine(((Attribut)((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getType())) {
/* 603 */             correc = false;
/* 604 */             this.frm.getConsole().getRapport().append("Le domaine " + ((Attribut)((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getType() + " de l'attribut " + ((Attribut)((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getNom() + " de la relation " + ((IhmRelation2)this.pageMcd.getListeEntiteRelation().get(i)).getRelation().getNom() + " n'est pas défini " + "\n");
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 611 */     return correc;
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
/*     */   protected Object doInBackground()
/*     */     throws Exception
/*     */   {
/* 625 */     JOptionPane.showMessageDialog(this.frm, "C'est une version d'essai\n La vérification n'est pas encore implémentée dans cette version");
/* 626 */     return Integer.valueOf(0);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\mythread\ThreadVerifMCD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */