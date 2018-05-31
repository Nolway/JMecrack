/*     */ package IhmMCD;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import Outil.Setting;
/*     */ import ihm.FormeInterneMCD;
/*     */ import java.awt.Color;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IhmLien
/*     */   implements Serializable
/*     */ {
/*     */   private IhmEntite entite;
/*     */   private IhmRelation relation;
/*     */   private String cardinalite;
/*     */   private boolean cardCentre;
/*  25 */   private static Color clLien = FormeInterneMCD.clLien;
/*  26 */   private static Color clLienText = FormeInterneMCD.clString;
/*     */   private boolean selected;
/*     */   private double xCardinal;
/*     */   private double yCardinal;
/*     */   private String nom;
/*     */   private double xCassure;
/*     */   private double yCassure;
/*     */   private boolean cassure;
/*     */   
/*     */   public IhmLien(IhmEntite entite, IhmRelation relation) {
/*  36 */     this.entite = entite;
/*  37 */     this.relation = relation;
/*  38 */     this.cardinalite = "0,n";
/*  39 */     this.selected = true;
/*  40 */     this.cassure = false;
/*  41 */     this.xCassure = -1.0D;
/*  42 */     this.yCassure = -1.0D;
/*  43 */     this.nom = " ";
/*  44 */     initPointCassure();
/*     */   }
/*     */   
/*     */   public void paint(Graphics g) {
/*  48 */     g.setFont(Parametres.fontNormal);
/*  49 */     carculerXYCardinal(g);
/*  50 */     String cardinaliteA = cardinaliteAffiche();
/*  51 */     if (!isCassure()) {
/*  52 */       if (isCardCentre()) {
/*  53 */         calculerXYCardinalCentre();
/*     */       }
/*  55 */       if (this.selected) {
/*  56 */         g.setColor(Color.red);
/*  57 */         g.drawLine(this.entite.getCentreX(), this.entite.getCentreY(), this.relation.getCentreX() + 5, this.relation.getCentreY());
/*  58 */         g.setColor(Color.WHITE);
/*  59 */         rectangleCardinalite(g);
/*     */         
/*  61 */         g.setColor(Color.red);
/*     */         
/*  63 */         g.drawString(cardinaliteA, (int)this.xCardinal, (int)this.yCardinal);
/*  64 */         g.drawString(getNom(), (this.entite.getCentreX() + this.relation.getCentreX()) / 2 + 2, (this.entite.getCentreY() + this.relation.getCentreY()) / 2 - 2);
/*     */       } else {
/*  66 */         g.setColor(clLien);
/*     */         
/*  68 */         g.drawLine(this.entite.getCentreX(), this.entite.getCentreY(), this.relation.getCentreX() + 5, this.relation.getCentreY());
/*  69 */         g.drawString(getNom(), (this.entite.getCentreX() + this.relation.getCentreX()) / 2 + 2, (this.entite.getCentreY() + this.relation.getCentreY()) / 2 - 2);
/*  70 */         g.setColor(Color.WHITE);
/*  71 */         rectangleCardinalite(g);
/*     */         
/*  73 */         g.setColor(clLienText);
/*     */         
/*     */ 
/*  76 */         g.drawString(cardinaliteA, (int)this.xCardinal + 2, (int)this.yCardinal - 2);
/*     */       }
/*     */     } else {
/*  79 */       if (isCardCentre()) { calculerXYCardinalCentre();
/*     */       }
/*  81 */       if (this.selected) {
/*  82 */         g.setColor(Color.red);
/*  83 */         g.drawLine(this.entite.getCentreX(), this.entite.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/*  84 */         g.drawLine(this.relation.getCentreX() + 5, this.relation.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/*  85 */         g.drawString(getNom(), (int)(this.xCassure + 2.0D), (int)this.yCassure);
/*  86 */         g.setColor(Color.black);
/*  87 */         g.fillRect((int)this.xCassure - 2, (int)this.yCassure - 2, 4, 4);
/*  88 */         g.setColor(Color.WHITE);
/*  89 */         rectangleCardinalite(g);
/*     */         
/*  91 */         g.setColor(clLienText);
/*     */         
/*  93 */         g.drawString(cardinaliteA, (int)this.xCardinal + 2, (int)this.yCardinal - 2);
/*     */       }
/*     */       else {
/*  96 */         g.setColor(clLien);
/*  97 */         g.drawLine(this.entite.getCentreX(), this.entite.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/*  98 */         g.drawLine(this.relation.getCentreX() + 5, this.relation.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/*     */         
/*     */ 
/* 101 */         g.drawString(getNom(), (int)(this.xCassure + 2.0D), (int)this.yCassure);
/* 102 */         g.setColor(Color.WHITE);
/* 103 */         rectangleCardinalite(g);
/*     */         
/*     */ 
/* 106 */         g.setColor(clLienText);
/*     */         
/* 108 */         g.drawString(cardinaliteA, (int)this.xCardinal, (int)this.yCardinal);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void rectangleCardinalite(Graphics g)
/*     */   {
/* 115 */     int h = g.getFontMetrics().getHeight();
/* 116 */     int w = g.getFontMetrics().stringWidth(cardinaliteAffiche() + "()");
/* 117 */     g.fillRect((int)this.xCardinal, (int)this.yCardinal - h, w, h);
/*     */   }
/*     */   
/*     */   public void setSelected(boolean selected) {
/* 121 */     this.selected = selected;
/*     */   }
/*     */   
/*     */   private String cardinaliteAffiche() {
/* 125 */     if (this.cardinalite == null) this.cardinalite = "0,n";
/* 126 */     String s = this.cardinalite;
/* 127 */     if (Setting.cardinalite2points) {
/* 128 */       s = s.replace(",", ":");
/*     */     }
/* 130 */     if (Setting.cardinaliteMajuscule) {
/* 131 */       s = s.toUpperCase();
/*     */     }
/* 133 */     return s;
/*     */   }
/*     */   
/*     */   public void initPointCassure() {
/* 137 */     this.xCassure = ((this.entite.getCentreX() + (this.relation.getCentreX() + 5)) / 2);
/* 138 */     this.yCassure = ((this.entite.getCentreY() + this.relation.getCentreY()) / 2);
/*     */   }
/*     */   
/*     */   private boolean isDansCadreCardinalite(int xx, int yy) {
/* 142 */     if ((this.xCardinal < xx) && (this.xCardinal + 15.0D > xx) && (this.yCardinal - 10.0D < yy) && (this.yCardinal > yy)) return true;
/* 143 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isDansCadreNomLien(int xx, int yy) {
/* 147 */     int tail = this.nom == null ? 0 : this.nom.trim().length();
/* 148 */     if ((isCassure()) && 
/* 149 */       (this.xCassure < xx) && (this.xCassure + 5.0D + tail * 8 > xx) && (this.yCassure - 10.0D < yy) && (this.yCassure > yy)) { return true;
/*     */     }
/* 151 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isSelectedDroite(int x, int y)
/*     */   {
/* 161 */     if (!isCassure()) {
/* 162 */       int h = this.entite.getCentreY() - this.relation.getCentreY();
/* 163 */       int w = this.entite.getCentreX() - (this.relation.getCentreX() + 5);
/* 164 */       if ((Math.abs(w) < 10) && (
/* 165 */         ((this.entite.getCentreX() >= x) && (this.relation.getCentreX() + 5 <= x)) || ((this.entite.getCentreX() <= x) && (this.relation.getCentreX() + 5 >= x))))
/*     */       {
/* 167 */         if (((this.entite.getCentreY() >= y) && (this.relation.getCentreY() <= y)) || ((this.entite.getCentreY() <= y) && (this.relation.getCentreY() >= y)))
/*     */         {
/* 169 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 174 */       int h = this.entite.getCentreY() - (int)this.yCassure;
/* 175 */       int w = this.entite.getCentreX() - (int)this.xCassure;
/* 176 */       if ((Math.abs(w) < 10) && (
/* 177 */         ((this.entite.getCentreX() >= x) && ((int)this.xCassure <= x)) || ((this.entite.getCentreX() <= x) && ((int)this.xCassure >= x))))
/*     */       {
/* 179 */         if (((this.entite.getCentreY() >= y) && ((int)this.yCassure <= y)) || ((this.entite.getCentreY() <= y) && ((int)this.yCassure >= y)))
/*     */         {
/* 181 */           return true;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 186 */       h = (int)this.yCassure - this.relation.getCentreY();
/* 187 */       w = (int)this.xCassure - (this.relation.getCentreX() + 5);
/* 188 */       if ((Math.abs(w) < 10) && (
/* 189 */         (((int)this.xCassure >= x) && (this.relation.getCentreX() + 5 <= x)) || (((int)this.xCassure <= x) && (this.relation.getCentreX() + 5 >= x))))
/*     */       {
/* 191 */         if ((((int)this.yCassure >= y) && (this.relation.getCentreY() <= y)) || (((int)this.yCassure <= y) && (this.relation.getCentreY() >= y)))
/*     */         {
/* 193 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 200 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isSelected(int x, int y)
/*     */   {
/* 205 */     if (isDansCadreCardinalite(x, y)) {
/* 206 */       this.selected = true;
/* 207 */       return true;
/*     */     }
/*     */     
/* 210 */     if (isDansCadreNomLien(x, y)) {
/* 211 */       this.selected = true;
/* 212 */       return true;
/*     */     }
/*     */     
/* 215 */     if (isSelectedDroite(x, y)) {
/* 216 */       this.selected = true;
/* 217 */       return true;
/*     */     }
/* 219 */     if (!isCassure()) {
/* 220 */       double aa = calculeA() * x + calculeB() - y;
/* 221 */       if ((aa < 3.0D) && (aa > -3.0D)) {
/* 222 */         if (isDansLeCarre(x, y)) {
/* 223 */           this.selected = true;
/* 224 */           return true;
/*     */         }
/* 226 */         this.selected = false;
/* 227 */         return false;
/*     */       }
/* 229 */       this.selected = false;
/* 230 */       return false;
/*     */     }
/*     */     
/* 233 */     double aa = calculeACassureEntite() * x + calculeBCassureEntite() - y;
/* 234 */     if ((aa < 3.0D) && (aa > -3.0D) && 
/* 235 */       (isDansLeCarreEntite(x, y))) {
/* 236 */       this.selected = true;
/* 237 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 242 */     aa = calculeACassureRelation() * x + calculeBCassureRelation() - y;
/* 243 */     if ((aa < 3.0D) && (aa > -3.0D) && 
/* 244 */       (isDansLeCarreRelation(x, y))) {
/* 245 */       this.selected = true;
/* 246 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 252 */     this.selected = false;
/* 253 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isSelected()
/*     */   {
/* 258 */     return this.selected;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarre(int x, int y) {
/* 262 */     if (this.entite.getCentreX() != this.relation.getCentreX() + 5) {
/* 263 */       if ((this.entite.getCentreX() <= x) && (this.relation.getCentreX() + 5 >= x)) return true;
/* 264 */       if ((this.entite.getCentreX() >= x) && (this.relation.getCentreX() + 5 <= x)) return true;
/*     */     } else {
/* 266 */       if ((this.entite.getCentreY() <= y) && (this.relation.getCentreY() >= y)) return true;
/* 267 */       if ((this.entite.getCentreY() >= x) && (this.relation.getCentreY() <= y)) return true;
/*     */     }
/* 269 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarreEntite(int x, int y) {
/* 273 */     if (this.entite.getCentreX() != this.xCassure) {
/* 274 */       if ((this.entite.getCentreX() <= x) && (this.xCassure >= x)) return true;
/* 275 */       if ((this.entite.getCentreX() >= x) && (this.xCassure <= x)) return true;
/*     */     } else {
/* 277 */       if ((this.entite.getCentreY() <= y) && (this.yCassure >= y)) return true;
/* 278 */       if ((this.entite.getCentreY() >= x) && (this.yCassure <= y)) return true;
/*     */     }
/* 280 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarreRelation(int x, int y) {
/* 284 */     if (this.xCassure != this.relation.getCentreX() + 5) {
/* 285 */       if ((this.xCassure <= x) && (this.relation.getCentreX() + 5 >= x)) return true;
/* 286 */       if ((this.xCassure >= x) && (this.relation.getCentreX() + 5 <= x)) return true;
/*     */     } else {
/* 288 */       if ((this.yCassure <= y) && (this.relation.getCentreY() >= y)) return true;
/* 289 */       if ((this.yCassure >= x) && (this.relation.getCentreY() <= y)) return true;
/*     */     }
/* 291 */     return false;
/*     */   }
/*     */   
/*     */   private double calculeA() {
/* 295 */     if (this.entite.getCentreX() - (this.relation.getCentreX() + 5) != 0) {
/* 296 */       double n = (this.entite.getCentreY() - this.relation.getCentreY()) / (this.entite.getCentreX() - (this.relation.getCentreX() + 5));
/* 297 */       return n;
/*     */     }
/* 299 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeACassureRelation() {
/* 303 */     if (this.xCassure - (this.relation.getCentreX() + 5) != 0.0D) {
/* 304 */       double n = (this.yCassure - this.relation.getCentreY()) / (this.xCassure - (this.relation.getCentreX() + 5));
/* 305 */       return n;
/*     */     }
/* 307 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeACassureEntite() {
/* 311 */     if (this.entite.getCentreX() - this.xCassure != 0.0D) {
/* 312 */       double n = (this.entite.getCentreY() - this.yCassure) / (this.entite.getCentreX() - this.xCassure);
/* 313 */       return n;
/*     */     }
/* 315 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeB() {
/* 319 */     if (this.entite.getCentreX() - (this.relation.getCentreX() + 5) != 0) {
/* 320 */       double n = this.entite.getCentreY() - calculeA() * this.entite.getCentreX();
/* 321 */       return n;
/*     */     }
/* 323 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeBCassureEntite() {
/* 327 */     if (this.entite.getCentreX() - this.xCassure != 0.0D) {
/* 328 */       double n = this.entite.getCentreY() - calculeACassureEntite() * this.entite.getCentreX();
/* 329 */       return n;
/*     */     }
/* 331 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeBCassureRelation() {
/* 335 */     if (this.xCassure - (this.relation.getCentreX() + 5) != 0.0D) {
/* 336 */       double n = this.yCassure - calculeACassureRelation() * this.xCassure;
/* 337 */       return n;
/*     */     }
/* 339 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double distance(int x, int y, int x1, int y1) {
/* 343 */     return Math.sqrt(Math.pow(x - x1, 2.0D) + Math.pow(y - y1, 2.0D));
/*     */   }
/*     */   
/*     */   private void calculerXYCardinalCentre() {
/* 347 */     if (!isCassure()) {
/* 348 */       this.xCardinal = ((int)(this.xCardinal + (this.relation.getCentreX() + 5)) / 2);
/* 349 */       this.yCardinal = ((int)(this.yCardinal + this.relation.getCentreY()) / 2);
/*     */     } else {
/* 351 */       this.xCardinal = ((int)(this.entite.getCentreX() + this.xCassure) / 2);
/* 352 */       this.yCardinal = ((int)(this.entite.getCentreY() + this.yCassure) / 2);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void carculerXYCardinal(Graphics g)
/*     */   {
/* 362 */     if (!isCassure()) {
/* 363 */       double aaa = calculeA();
/* 364 */       double bbb = calculeB();
/* 365 */       if ((this.entite.getCentreX() < this.relation.getCentreX() + 5) && (this.entite.getCentreY() < this.relation.getCentreY())) {
/* 366 */         double yInter1 = aaa * (this.entite.getX() + this.entite.getWidth()) + bbb;
/* 367 */         double xInter1 = this.entite.getX() + this.entite.getWidth();
/*     */         
/* 369 */         double yInter2 = this.entite.getY() + this.entite.getHeight();
/* 370 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 372 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 373 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 374 */         this.xCardinal = (xInter1 + Parametres.retournerVal(g, 5));
/* 375 */         this.yCardinal = (yInter1 + Parametres.retournerVal(g, 17));
/*     */         
/* 377 */         if (dist2 < dist1) {
/* 378 */           this.xCardinal = (xInter2 + Parametres.retournerVal(g, 5));
/* 379 */           this.yCardinal = (yInter2 + Parametres.retournerVal(g, 17));
/*     */         }
/*     */       }
/*     */       
/* 383 */       if ((this.entite.getCentreX() > this.relation.getCentreX() + 5) && (this.entite.getCentreY() < this.relation.getCentreY())) {
/* 384 */         double yInter1 = aaa * this.entite.getX() + bbb;
/* 385 */         double xInter1 = this.entite.getX();
/*     */         
/* 387 */         double yInter2 = this.entite.getY() + this.entite.getHeight();
/* 388 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 390 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 391 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 392 */         this.xCardinal = (xInter1 - Parametres.retournerVal(g, 27));
/* 393 */         this.yCardinal = (yInter1 + Parametres.retournerVal(g, 17));
/* 394 */         if (dist2 < dist1) {
/* 395 */           this.xCardinal = xInter2;
/* 396 */           this.yCardinal = (yInter2 + Parametres.retournerVal(g, 17));
/*     */         }
/*     */       }
/*     */       
/* 400 */       if ((this.entite.getCentreX() > this.relation.getCentreX() + 5) && (this.entite.getCentreY() > this.relation.getCentreY())) {
/* 401 */         double yInter1 = aaa * this.entite.getX() + bbb;
/* 402 */         double xInter1 = this.entite.getX();
/*     */         
/* 404 */         double yInter2 = this.entite.getY();
/* 405 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 407 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 408 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 409 */         this.xCardinal = (xInter1 - Parametres.retournerVal(g, 27));
/* 410 */         this.yCardinal = yInter1;
/* 411 */         if (dist2 < dist1) {
/* 412 */           this.xCardinal = xInter2;
/* 413 */           this.yCardinal = (yInter2 - Parametres.retournerVal(g, 2));
/*     */         }
/*     */       }
/*     */       
/* 417 */       if ((this.entite.getCentreX() < this.relation.getCentreX() + 5) && (this.entite.getCentreY() > this.relation.getCentreY())) {
/* 418 */         double yInter1 = aaa * (this.entite.getX() + this.entite.getWidth()) + bbb;
/* 419 */         double xInter1 = this.entite.getX() + this.entite.getWidth();
/*     */         
/* 421 */         double yInter2 = this.entite.getY();
/* 422 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 424 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 425 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 426 */         this.xCardinal = (xInter1 + Parametres.retournerVal(g, 5));
/* 427 */         this.yCardinal = yInter1;
/* 428 */         if (dist2 < dist1) {
/* 429 */           this.xCardinal = (xInter2 + Parametres.retournerVal(g, 5));
/* 430 */           this.yCardinal = (yInter2 - Parametres.retournerVal(g, 2));
/*     */         }
/*     */       }
/*     */       
/* 434 */       if (this.entite.getCentreX() == this.relation.getCentreX() + 5) {
/* 435 */         if (this.entite.getCentreY() > this.relation.getCentreY()) {
/* 436 */           this.xCardinal = this.entite.getCentreX();
/* 437 */           this.yCardinal = (this.entite.getCentreY() - this.entite.getHeight() / 2 - Parametres.retournerVal(g, 5));
/*     */         } else {
/* 439 */           this.xCardinal = this.entite.getCentreX();
/* 440 */           this.yCardinal = (this.entite.getCentreY() + this.entite.getHeight() / 2 + Parametres.retournerVal(g, 17));
/*     */         }
/*     */       }
/* 443 */       if (this.entite.getCentreY() == this.relation.getCentreY()) {
/* 444 */         if (this.entite.getCentreX() > this.relation.getCentreX()) {
/* 445 */           this.xCardinal = (this.entite.getX() - Parametres.retournerVal(g, 27));
/* 446 */           this.yCardinal = (this.entite.getY() + this.entite.getHeight() / 2);
/*     */         } else {
/* 448 */           this.xCardinal = (this.entite.getX() + this.entite.getWidth() + Parametres.retournerVal(g, 5));
/* 449 */           this.yCardinal = (this.entite.getY() + this.entite.getHeight() / 2);
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 454 */       double aaa = calculeACassureEntite();
/* 455 */       double bbb = calculeBCassureEntite();
/* 456 */       if ((this.entite.getCentreX() < this.xCassure) && (this.entite.getCentreY() < this.yCassure)) {
/* 457 */         double yInter1 = aaa * (this.entite.getX() + this.entite.getWidth()) + bbb;
/* 458 */         double xInter1 = this.entite.getX() + this.entite.getWidth();
/*     */         
/* 460 */         double yInter2 = this.entite.getY() + this.entite.getHeight();
/* 461 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 463 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 464 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 465 */         this.xCardinal = (xInter1 + Parametres.retournerVal(g, 5));
/* 466 */         this.yCardinal = (yInter1 + Parametres.retournerVal(g, 17));
/* 467 */         if (dist2 < dist1) {
/* 468 */           this.xCardinal = (xInter2 + Parametres.retournerVal(g, 5));
/* 469 */           this.yCardinal = (yInter2 + Parametres.retournerVal(g, 17));
/*     */         }
/*     */       }
/*     */       
/* 473 */       if ((this.entite.getCentreX() > this.xCassure) && (this.entite.getCentreY() < this.yCassure)) {
/* 474 */         double yInter1 = aaa * this.entite.getX() + bbb;
/* 475 */         double xInter1 = this.entite.getX();
/*     */         
/* 477 */         double yInter2 = this.entite.getY() + this.entite.getHeight();
/* 478 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 480 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 481 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 482 */         this.xCardinal = (xInter1 - Parametres.retournerVal(g, 27));
/* 483 */         this.yCardinal = (yInter1 + Parametres.retournerVal(g, 17));
/* 484 */         if (dist2 < dist1) {
/* 485 */           this.xCardinal = xInter2;
/* 486 */           this.yCardinal = (yInter2 + Parametres.retournerVal(g, 17));
/*     */         }
/*     */       }
/*     */       
/* 490 */       if ((this.entite.getCentreX() > this.xCassure) && (this.entite.getCentreY() > this.yCassure)) {
/* 491 */         double yInter1 = aaa * this.entite.getX() + bbb;
/* 492 */         double xInter1 = this.entite.getX();
/*     */         
/* 494 */         double yInter2 = this.entite.getY();
/* 495 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 497 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 498 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 499 */         this.xCardinal = (xInter1 - Parametres.retournerVal(g, 27));
/* 500 */         this.yCardinal = yInter1;
/* 501 */         if (dist2 < dist1) {
/* 502 */           this.xCardinal = xInter2;
/* 503 */           this.yCardinal = (yInter2 - Parametres.retournerVal(g, 2));
/*     */         }
/*     */       }
/*     */       
/* 507 */       if ((this.entite.getCentreX() < this.xCassure) && (this.entite.getCentreY() > this.yCassure)) {
/* 508 */         double yInter1 = aaa * (this.entite.getX() + this.entite.getWidth()) + bbb;
/* 509 */         double xInter1 = this.entite.getX() + this.entite.getWidth();
/*     */         
/* 511 */         double yInter2 = this.entite.getY();
/* 512 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 514 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 515 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 516 */         this.xCardinal = (xInter1 + Parametres.retournerVal(g, 5));
/* 517 */         this.yCardinal = yInter1;
/* 518 */         if (dist2 < dist1) {
/* 519 */           this.xCardinal = (xInter2 + Parametres.retournerVal(g, 5));
/* 520 */           this.yCardinal = (yInter2 - Parametres.retournerVal(g, 2));
/*     */         }
/*     */       }
/*     */       
/* 524 */       if (this.entite.getCentreX() == this.xCassure) {
/* 525 */         if (this.entite.getCentreY() > this.yCassure) {
/* 526 */           this.xCardinal = this.entite.getCentreX();
/* 527 */           this.yCardinal = (this.entite.getCentreY() - this.entite.getHeight() / 2 - Parametres.retournerVal(g, 5));
/*     */         } else {
/* 529 */           this.xCardinal = this.entite.getCentreX();
/* 530 */           this.yCardinal = (this.entite.getCentreY() + this.entite.getHeight() / 2 + Parametres.retournerVal(g, 17));
/*     */         }
/*     */       }
/* 533 */       if (this.entite.getCentreY() == this.yCassure) {
/* 534 */         if (this.entite.getCentreX() > this.xCassure) {
/* 535 */           this.xCardinal = (this.entite.getX() - Parametres.retournerVal(g, 25));
/* 536 */           this.yCardinal = (this.entite.getY() + this.entite.getHeight() / 2);
/*     */         } else {
/* 538 */           this.xCardinal = (this.entite.getX() + this.entite.getWidth() + Parametres.retournerVal(g, 5));
/* 539 */           this.yCardinal = (this.entite.getY() + this.entite.getHeight() / 2);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void setCardinalite(String cardinalite)
/*     */   {
/* 548 */     this.cardinalite = cardinalite;
/*     */   }
/*     */   
/*     */   public static Color getClLien() {
/* 552 */     return clLien;
/*     */   }
/*     */   
/*     */   public static void setClLien(Color clLien) {
/* 556 */     clLien = clLien;
/*     */   }
/*     */   
/*     */   public IhmEntite getEntite() {
/* 560 */     return this.entite;
/*     */   }
/*     */   
/*     */   public IhmRelation getRelation() {
/* 564 */     return this.relation;
/*     */   }
/*     */   
/*     */   public String getCardinalite() {
/* 568 */     return this.cardinalite;
/*     */   }
/*     */   
/*     */   public boolean isCardCentre() {
/* 572 */     return this.cardCentre;
/*     */   }
/*     */   
/*     */   public void setCardCentre(boolean cardCentre) {
/* 576 */     this.cardCentre = cardCentre;
/*     */   }
/*     */   
/*     */   public void setCassure(boolean cassure) {
/* 580 */     this.cassure = cassure;
/*     */   }
/*     */   
/*     */   public boolean isCassure() {
/* 584 */     return this.cassure;
/*     */   }
/*     */   
/*     */   public void redimentionnerCassure(int x, int y) {
/* 588 */     if (x <= 0) this.xCassure = 0.0D; else
/* 589 */       this.xCassure = x;
/* 590 */     if (y <= 0) this.yCassure = 0.0D; else
/* 591 */       this.yCassure = y;
/*     */   }
/*     */   
/*     */   public boolean isSelectedCassure(int x, int y) {
/* 595 */     if ((isCassure()) && 
/* 596 */       (Math.abs(x - this.xCassure) <= 4.0D) && (Math.abs(x - this.xCassure) <= 4.0D)) { return true;
/*     */     }
/* 598 */     return false;
/*     */   }
/*     */   
/*     */   public void setxCardinal(double xCardinal) {
/* 602 */     this.xCardinal = xCardinal;
/*     */   }
/*     */   
/*     */   public void setyCassure(double yCassure) {
/* 606 */     this.yCassure = yCassure;
/* 607 */     this.xCassure = Parametres.xcassure;
/*     */   }
/*     */   
/*     */   public double getxCassure() {
/* 611 */     return this.xCassure;
/*     */   }
/*     */   
/*     */   public double getyCassure() {
/* 615 */     return this.yCassure;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 619 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 623 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public static void setClLienText(Color clLienText) {
/* 627 */     clLienText = clLienText;
/*     */   }
/*     */   
/*     */   public IhmLien copier() {
/* 631 */     IhmLien li = new IhmLien(getEntite().copier(), getRelation().copier());
/* 632 */     li.setCardinalite(getCardinalite());
/* 633 */     li.setNom(getNom());
/* 634 */     return li;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmLien.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */