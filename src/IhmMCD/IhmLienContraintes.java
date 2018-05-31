/*     */ package IhmMCD;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import ihm.FormeInterneMCD;
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IhmLienContraintes
/*     */   implements Serializable
/*     */ {
/*     */   private IhmEntiteRelation entRel;
/*     */   private IhmEntiteRelation contrainte;
/*     */   private boolean cardCentre;
/*     */   private static Color clLien;
/*     */   private boolean selected;
/*     */   private double xCardinal;
/*     */   private double yCardinal;
/*     */   private String nom;
/*     */   private double xCassure;
/*     */   private double yCassure;
/*     */   private boolean cassure;
/*     */   private boolean cible;
/*     */   private int cote;
/*     */   private double droiteA;
/*     */   private double droiteB;
/*     */   
/*     */   public IhmLienContraintes(IhmEntiteRelation entRel, IhmEntiteRelation contrainte)
/*     */   {
/*  35 */     this.entRel = entRel;
/*  36 */     this.contrainte = contrainte;
/*  37 */     clLien = FormeInterneMCD.clLienCnt;
/*  38 */     this.selected = true;
/*  39 */     this.cassure = false;
/*  40 */     this.xCassure = -1.0D;
/*  41 */     this.yCassure = -1.0D;
/*  42 */     this.cible = false;
/*  43 */     this.nom = "";
/*  44 */     initPointCassure();
/*  45 */     this.cote = 0;
/*  46 */     this.droiteA = -1.0D;
/*  47 */     this.droiteB = -1.0D;
/*     */   }
/*     */   
/*     */   public void initPointCassure() {
/*  51 */     this.xCassure = ((this.entRel.getCentreX() + this.contrainte.getCentreX()) / 2);
/*  52 */     this.yCassure = ((this.entRel.getCentreY() + this.contrainte.getCentreY()) / 2);
/*     */   }
/*     */   
/*     */   public void setSelected(boolean selected) {
/*  56 */     this.selected = selected;
/*     */   }
/*     */   
/*     */   public void paint(Graphics g) {
/*  60 */     carculerXYCardinal();
/*  61 */     if (!isCassure())
/*     */     {
/*  63 */       if (this.selected) {
/*  64 */         g.setColor(Color.red);
/*  65 */         dessinerLien(g);
/*     */         
/*  67 */         dessinerfleche(g);
/*  68 */         g.drawString(getNom(), (this.entRel.getCentreX() + this.contrainte.getCentreX()) / 2 + 2, (this.entRel.getCentreY() + this.contrainte.getCentreY()) / 2 - 2);
/*     */       } else {
/*  70 */         g.setColor(clLien);
/*     */         
/*  72 */         dessinerLien(g);
/*  73 */         dessinerfleche(g);
/*  74 */         g.drawString(getNom(), (this.entRel.getCentreX() + this.contrainte.getCentreX()) / 2 + 2, (this.entRel.getCentreY() + this.contrainte.getCentreY()) / 2 - 2);
/*     */       }
/*     */       
/*     */     }
/*  78 */     else if (this.selected) {
/*  79 */       g.setColor(Color.red);
/*     */       
/*  81 */       dessinerfleche(g);
/*  82 */       dessinerLien(g);
/*  83 */       g.setColor(Color.black);
/*  84 */       g.fillRect((int)this.xCassure - 2, (int)this.yCassure - 2, 4, 4);
/*     */       
/*  86 */       g.drawString(getNom(), (int)(this.xCassure + 2.0D), (int)this.yCassure);
/*  87 */       g.setColor(Color.black);
/*     */     } else {
/*  89 */       g.setColor(clLien);
/*     */       
/*  91 */       dessinerLien(g);
/*  92 */       dessinerfleche(g);
/*     */       
/*  94 */       g.drawString(getNom(), (int)(this.xCassure + 2.0D), (int)this.yCassure);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void dessinerLien(Graphics g)
/*     */   {
/* 101 */     if (this.entRel.getClass().getName().equals("IhmMCD2.IhmEntite2")) {
/* 102 */       Graphics2D g2d = (Graphics2D)g;
/* 103 */       float epaisseur = 1.0F;
/* 104 */       float[] style = { 10.0F, 5.0F };
/*     */       
/* 106 */       g2d.setStroke(new BasicStroke(epaisseur, 0, 0, 10.0F, style, 0.0F));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 114 */       if (!isCassure()) {
/* 115 */         g.drawLine(this.entRel.getCentreX(), this.entRel.getCentreY(), this.contrainte.getCentreX(), this.contrainte.getCentreY());
/*     */       } else {
/* 117 */         g.drawLine(this.entRel.getCentreX(), this.entRel.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/* 118 */         g.drawLine((int)this.xCassure, (int)this.yCassure, this.contrainte.getCentreX(), this.contrainte.getCentreY());
/*     */       }
/*     */       
/*     */ 
/* 122 */       epaisseur = 1.0F;
/* 123 */       style[0] = 10.0F;
/* 124 */       style[1] = 0.0F;
/* 125 */       g2d.setStroke(new BasicStroke(epaisseur, 0, 0, 1.0F, style, 0.0F));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/* 134 */     else if (!isCassure()) {
/* 135 */       g.drawLine(this.entRel.getCentreX(), this.entRel.getCentreY(), this.contrainte.getCentreX(), this.contrainte.getCentreY());
/*     */     } else {
/* 137 */       g.drawLine(this.entRel.getCentreX(), this.entRel.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/* 138 */       g.drawLine((int)this.xCassure, (int)this.yCassure, this.contrainte.getCentreX(), this.contrainte.getCentreY());
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerfleche(Graphics g)
/*     */   {
/* 144 */     double a = calculeA();
/* 145 */     double b = calculeB();
/*     */     
/*     */ 
/*     */ 
/* 149 */     if (isCassure()) {
/* 150 */       a = calculeACassureEntite();
/* 151 */       b = calculeBCassureEntite();
/*     */     }
/* 153 */     if (isCible()) {
/* 154 */       Color cl = g.getColor();
/* 155 */       int dx = (int)this.xCardinal;
/* 156 */       int dy = (int)this.yCardinal;
/* 157 */       int dec = 0;
/* 158 */       if (this.entRel.isOmbre()) { dec = 3;
/*     */       }
/* 160 */       if (this.cote == 1) {
/* 161 */         double x1 = this.entRel.getX() + this.entRel.getWidth() + 5 + dec;
/* 162 */         double y1 = x1 * a + b;
/* 163 */         double aV = -1.0D / a;
/* 164 */         double bV = y1 - aV * x1;
/* 165 */         int[] x = { dx + dec, (int)((y1 - 5.0D - bV) / aV), (int)((y1 + 5.0D - bV) / aV) };
/* 166 */         int[] y = { dy, (int)(y1 - 5.0D), (int)(y1 + 5.0D) };
/* 167 */         g.setColor(cl);
/* 168 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/* 171 */       if (this.cote == 2) {
/* 172 */         double y1 = this.entRel.getY() + this.entRel.getHeight() + 5 + dec;
/* 173 */         double x1 = (y1 - b) / a;
/* 174 */         double aV = -1.0D / a;
/* 175 */         double bV = y1 - aV * x1;
/* 176 */         int[] x = { dx, (int)x1 - 5, (int)x1 + 5 };
/* 177 */         int[] y = { dy + dec, (int)(aV * (x1 - 5.0D) + bV), (int)(aV * (x1 + 5.0D) + bV) };
/*     */         
/* 179 */         g.setColor(cl);
/* 180 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/*     */ 
/* 184 */       if (this.cote == 3) {
/* 185 */         double x1 = this.entRel.getX() - 5;
/* 186 */         double y1 = x1 * a + b;
/*     */         
/* 188 */         double aV = -1.0D / a;
/* 189 */         double bV = y1 - aV * x1;
/*     */         
/* 191 */         int[] x = { dx, (int)((y1 - 5.0D - bV) / aV), (int)((y1 + 5.0D - bV) / aV) };
/* 192 */         int[] y = { dy, (int)(y1 - 5.0D), (int)(y1 + 5.0D) };
/*     */         
/* 194 */         g.setColor(cl);
/* 195 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/*     */ 
/* 199 */       if (this.cote == 4) {
/* 200 */         double y1 = this.entRel.getY() - 5;
/* 201 */         double x1 = (y1 - b) / a;
/* 202 */         double aV = -1.0D / a;
/* 203 */         double bV = y1 - aV * x1;
/* 204 */         int[] x = { dx, (int)x1 - 5, (int)x1 + 5 };
/* 205 */         int[] y = { dy, (int)(aV * (x1 - 5.0D) + bV), (int)(aV * (x1 + 5.0D) + bV) };
/*     */         
/* 207 */         g.setColor(cl);
/* 208 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void calculerXYCardinalCentre()
/*     */   {
/* 215 */     if (!isCassure()) {
/* 216 */       this.xCardinal = ((this.entRel.getCentreX() + this.contrainte.getCentreX()) / 2);
/* 217 */       this.yCardinal = ((this.entRel.getCentreY() + this.contrainte.getCentreY()) / 2);
/*     */     } else {
/* 219 */       this.xCardinal = ((int)(this.entRel.getCentreX() + this.xCassure) / 2);
/* 220 */       this.yCardinal = ((int)(this.entRel.getCentreY() + this.yCassure) / 2);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isSelectedDroite(int x, int y)
/*     */   {
/* 226 */     if (!isCassure()) {
/* 227 */       int h = this.entRel.getCentreY() - this.contrainte.getCentreY();
/* 228 */       int w = this.entRel.getCentreX() - this.contrainte.getCentreX();
/* 229 */       if ((Math.abs(w) < 10) && (
/* 230 */         ((this.entRel.getCentreX() >= x) && (this.contrainte.getCentreX() <= x)) || ((this.entRel.getCentreX() <= x) && (this.contrainte.getCentreX() >= x))))
/*     */       {
/* 232 */         if (((this.entRel.getCentreY() >= y) && (this.contrainte.getCentreY() <= y)) || ((this.entRel.getCentreY() <= y) && (this.contrainte.getCentreY() >= y)))
/*     */         {
/* 234 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 239 */       int h = this.entRel.getCentreY() - (int)this.yCassure;
/* 240 */       int w = this.entRel.getCentreX() - (int)this.xCassure;
/* 241 */       if ((Math.abs(w) < 10) && (
/* 242 */         ((this.entRel.getCentreX() >= x) && ((int)this.xCassure <= x)) || ((this.entRel.getCentreX() <= x) && ((int)this.xCassure >= x))))
/*     */       {
/* 244 */         if (((this.entRel.getCentreY() >= y) && ((int)this.yCassure <= y)) || ((this.entRel.getCentreY() <= y) && ((int)this.yCassure >= y)))
/*     */         {
/* 246 */           return true;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 251 */       h = (int)this.yCassure - this.contrainte.getCentreY();
/* 252 */       w = (int)this.xCassure - this.contrainte.getCentreX();
/* 253 */       if ((Math.abs(w) < 10) && (
/* 254 */         (((int)this.xCassure >= x) && (this.contrainte.getCentreX() <= x)) || (((int)this.xCassure <= x) && (this.contrainte.getCentreX() >= x))))
/*     */       {
/* 256 */         if ((((int)this.yCassure >= y) && (this.contrainte.getCentreY() <= y)) || (((int)this.yCassure <= y) && (this.contrainte.getCentreY() >= y)))
/*     */         {
/* 258 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 265 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isSelected(int x, int y)
/*     */   {
/* 270 */     if (isSelectedDroite(x, y)) {
/* 271 */       this.selected = true;
/* 272 */       return true;
/*     */     }
/*     */     
/* 275 */     if (!isCassure()) {
/* 276 */       double aa = calculeA() * x + calculeB() - y;
/* 277 */       if ((aa < 3.0D) && (aa > -3.0D)) {
/* 278 */         if (isDansLeCarre(x, y)) {
/* 279 */           this.selected = true;
/* 280 */           return true;
/*     */         }
/* 282 */         this.selected = false;
/* 283 */         return false;
/*     */       }
/* 285 */       this.selected = false;
/* 286 */       return false;
/*     */     }
/*     */     
/* 289 */     double aa = calculeACassureEntite() * x + calculeBCassureEntite() - y;
/* 290 */     if ((aa < 3.0D) && (aa > -3.0D) && 
/* 291 */       (isDansLeCarreEntite(x, y))) {
/* 292 */       this.selected = true;
/* 293 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 298 */     aa = calculeACassureRelation() * x + calculeBCassureRelation() - y;
/* 299 */     if ((aa < 3.0D) && (aa > -3.0D) && 
/* 300 */       (isDansLeCarreRelation(x, y))) {
/* 301 */       this.selected = true;
/* 302 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 308 */     this.selected = false;
/* 309 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarre(int x, int y)
/*     */   {
/* 314 */     if (this.entRel.getCentreX() != this.contrainte.getCentreX()) {
/* 315 */       if ((this.entRel.getCentreX() <= x) && (this.contrainte.getCentreX() >= x)) return true;
/* 316 */       if ((this.entRel.getCentreX() >= x) && (this.contrainte.getCentreX() <= x)) return true;
/*     */     } else {
/* 318 */       if ((this.entRel.getCentreY() <= y) && (this.contrainte.getCentreY() >= y)) return true;
/* 319 */       if ((this.entRel.getCentreY() >= x) && (this.contrainte.getCentreY() <= y)) return true;
/*     */     }
/* 321 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarreEntite(int x, int y) {
/* 325 */     if (this.entRel.getCentreX() != this.xCassure) {
/* 326 */       if ((this.entRel.getCentreX() <= x) && (this.xCassure >= x)) return true;
/* 327 */       if ((this.entRel.getCentreX() >= x) && (this.xCassure <= x)) return true;
/*     */     } else {
/* 329 */       if ((this.entRel.getCentreY() <= y) && (this.yCassure >= y)) return true;
/* 330 */       if ((this.entRel.getCentreY() >= x) && (this.yCassure <= y)) return true;
/*     */     }
/* 332 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarreRelation(int x, int y) {
/* 336 */     if (this.xCassure != this.contrainte.getCentreX()) {
/* 337 */       if ((this.xCassure <= x) && (this.contrainte.getCentreX() >= x)) return true;
/* 338 */       if ((this.xCassure >= x) && (this.contrainte.getCentreX() <= x)) return true;
/*     */     } else {
/* 340 */       if ((this.yCassure <= y) && (this.contrainte.getCentreY() >= y)) return true;
/* 341 */       if ((this.yCassure >= x) && (this.contrainte.getCentreY() <= y)) return true;
/*     */     }
/* 343 */     return false;
/*     */   }
/*     */   
/*     */   private double calculeA() {
/* 347 */     if (this.entRel.getCentreX() - this.contrainte.getCentreX() != 0) {
/* 348 */       double n = (this.entRel.getCentreY() - this.contrainte.getCentreY()) / (this.entRel.getCentreX() - this.contrainte.getCentreX());
/* 349 */       return n;
/*     */     }
/* 351 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeACassureRelation() {
/* 355 */     if (this.xCassure - this.contrainte.getCentreX() != 0.0D) {
/* 356 */       double n = (this.yCassure - this.contrainte.getCentreY()) / (this.xCassure - this.contrainte.getCentreX());
/* 357 */       return n;
/*     */     }
/* 359 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeACassureEntite() {
/* 363 */     if (this.entRel.getCentreX() - this.xCassure != 0.0D) {
/* 364 */       double n = (this.entRel.getCentreY() - this.yCassure) / (this.entRel.getCentreX() - this.xCassure);
/* 365 */       return n;
/*     */     }
/* 367 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeB() {
/* 371 */     if (this.entRel.getCentreX() - this.contrainte.getCentreX() != 0) {
/* 372 */       double n = this.entRel.getCentreY() - calculeA() * this.entRel.getCentreX();
/* 373 */       return n;
/*     */     }
/* 375 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeBCassureEntite() {
/* 379 */     if (this.entRel.getCentreX() - this.xCassure != 0.0D) {
/* 380 */       double n = this.entRel.getCentreY() - calculeACassureEntite() * this.entRel.getCentreX();
/* 381 */       return n;
/*     */     }
/* 383 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeBCassureRelation() {
/* 387 */     if (this.xCassure - this.contrainte.getCentreX() != 0.0D) {
/* 388 */       double n = this.yCassure - calculeACassureRelation() * this.xCassure;
/* 389 */       return n;
/*     */     }
/* 391 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double distance(int x, int y, int x1, int y1) {
/* 395 */     return Math.sqrt(Math.pow(x - x1, 2.0D) + Math.pow(y - y1, 2.0D));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void carculerXYCardinal()
/*     */   {
/* 404 */     if (!isCassure()) {
/* 405 */       double aaa = calculeA();
/* 406 */       double bbb = calculeB();
/* 407 */       if ((this.entRel.getCentreX() < this.contrainte.getCentreX()) && (this.entRel.getCentreY() < this.contrainte.getCentreY())) {
/* 408 */         double yInter1 = aaa * (this.entRel.getX() + this.entRel.getWidth()) + bbb;
/* 409 */         double xInter1 = this.entRel.getX() + this.entRel.getWidth();
/*     */         
/* 411 */         double yInter2 = this.entRel.getY() + this.entRel.getHeight();
/* 412 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 414 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 415 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 416 */         this.xCardinal = xInter1;
/* 417 */         this.yCardinal = yInter1;
/* 418 */         this.cote = 1;
/* 419 */         if (dist2 < dist1) {
/* 420 */           this.xCardinal = xInter2;
/* 421 */           this.yCardinal = yInter2;
/* 422 */           this.cote = 2;
/*     */         }
/*     */       }
/* 425 */       if ((this.entRel.getCentreX() > this.contrainte.getCentreX()) && (this.entRel.getCentreY() < this.contrainte.getCentreY())) {
/* 426 */         double yInter1 = aaa * this.entRel.getX() + bbb;
/* 427 */         double xInter1 = this.entRel.getX();
/*     */         
/* 429 */         double yInter2 = this.entRel.getY() + this.entRel.getHeight();
/* 430 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 432 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 433 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 434 */         this.xCardinal = xInter1;
/* 435 */         this.yCardinal = yInter1;
/* 436 */         this.cote = 3;
/* 437 */         if (dist2 < dist1) {
/* 438 */           this.xCardinal = xInter2;
/* 439 */           this.yCardinal = yInter2;
/* 440 */           this.cote = 2;
/*     */         }
/*     */       }
/* 443 */       if ((this.entRel.getCentreX() > this.contrainte.getCentreX()) && (this.entRel.getCentreY() > this.contrainte.getCentreY())) {
/* 444 */         double yInter1 = aaa * this.entRel.getX() + bbb;
/* 445 */         double xInter1 = this.entRel.getX();
/*     */         
/* 447 */         double yInter2 = this.entRel.getY();
/* 448 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 450 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 451 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 452 */         this.xCardinal = xInter1;
/* 453 */         this.yCardinal = yInter1;
/* 454 */         this.cote = 3;
/* 455 */         if (dist2 < dist1) {
/* 456 */           this.xCardinal = xInter2;
/* 457 */           this.yCardinal = yInter2;
/* 458 */           this.cote = 4;
/*     */         }
/*     */       }
/* 461 */       if ((this.entRel.getCentreX() < this.contrainte.getCentreX()) && (this.entRel.getCentreY() > this.contrainte.getCentreY())) {
/* 462 */         double yInter1 = aaa * (this.entRel.getX() + this.entRel.getWidth()) + bbb;
/* 463 */         double xInter1 = this.entRel.getX() + this.entRel.getWidth();
/*     */         
/* 465 */         double yInter2 = this.entRel.getY();
/* 466 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 468 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 469 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 470 */         this.xCardinal = xInter1;
/* 471 */         this.yCardinal = yInter1;
/* 472 */         this.cote = 1;
/* 473 */         if (dist2 < dist1) {
/* 474 */           this.xCardinal = xInter2;
/* 475 */           this.yCardinal = yInter2;
/* 476 */           this.cote = 4;
/*     */         }
/*     */       }
/* 479 */       if (this.entRel.getCentreX() == this.contrainte.getCentreX()) {
/* 480 */         if (this.entRel.getCentreY() > this.contrainte.getCentreY()) {
/* 481 */           this.xCardinal = this.entRel.getCentreX();
/* 482 */           this.yCardinal = (this.entRel.getCentreY() - this.entRel.getHeight() / 2 - 5);
/* 483 */           this.cote = 41;
/*     */         } else {
/* 485 */           this.xCardinal = this.entRel.getCentreX();
/* 486 */           this.yCardinal = (this.entRel.getCentreY() + this.entRel.getHeight() / 2 + 17);
/* 487 */           this.cote = 21;
/*     */         }
/*     */       }
/* 490 */       if (this.entRel.getCentreY() == this.contrainte.getCentreY()) {
/* 491 */         if (this.entRel.getCentreX() > this.contrainte.getCentreX()) {
/* 492 */           this.xCardinal = (this.entRel.getX() - 15);
/* 493 */           this.yCardinal = (this.entRel.getY() + this.entRel.getHeight() / 2);
/* 494 */           this.cote = 11;
/*     */         } else {
/* 496 */           this.xCardinal = (this.entRel.getX() + this.entRel.getWidth() + 5);
/* 497 */           this.yCardinal = (this.entRel.getY() + this.entRel.getHeight() / 2);
/* 498 */           this.cote = 31;
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 503 */       double aaa = calculeACassureEntite();
/* 504 */       double bbb = calculeBCassureEntite();
/* 505 */       if ((this.entRel.getCentreX() < this.xCassure) && (this.entRel.getCentreY() < this.yCassure)) {
/* 506 */         double yInter1 = aaa * (this.entRel.getX() + this.entRel.getWidth()) + bbb;
/* 507 */         double xInter1 = this.entRel.getX() + this.entRel.getWidth();
/*     */         
/* 509 */         double yInter2 = this.entRel.getY() + this.entRel.getHeight();
/* 510 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 512 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 513 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 514 */         this.xCardinal = xInter1;
/* 515 */         this.yCardinal = yInter1;
/* 516 */         this.cote = 1;
/* 517 */         if (dist2 < dist1) {
/* 518 */           this.xCardinal = xInter2;
/* 519 */           this.yCardinal = yInter2;
/* 520 */           this.cote = 2;
/*     */         }
/*     */       }
/* 523 */       if ((this.entRel.getCentreX() > this.xCassure) && (this.entRel.getCentreY() < this.yCassure)) {
/* 524 */         double yInter1 = aaa * this.entRel.getX() + bbb;
/* 525 */         double xInter1 = this.entRel.getX();
/*     */         
/* 527 */         double yInter2 = this.entRel.getY() + this.entRel.getHeight();
/* 528 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 530 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 531 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 532 */         this.xCardinal = xInter1;
/* 533 */         this.yCardinal = yInter1;
/* 534 */         this.cote = 3;
/* 535 */         if (dist2 < dist1) {
/* 536 */           this.xCardinal = xInter2;
/* 537 */           this.yCardinal = yInter2;
/* 538 */           this.cote = 2;
/*     */         }
/*     */       }
/* 541 */       if ((this.entRel.getCentreX() > this.xCassure) && (this.entRel.getCentreY() > this.yCassure)) {
/* 542 */         double yInter1 = aaa * this.entRel.getX() + bbb;
/* 543 */         double xInter1 = this.entRel.getX();
/*     */         
/* 545 */         double yInter2 = this.entRel.getY();
/* 546 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 548 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 549 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 550 */         this.xCardinal = xInter1;
/* 551 */         this.yCardinal = yInter1;
/* 552 */         this.cote = 3;
/* 553 */         if (dist2 < dist1) {
/* 554 */           this.xCardinal = xInter2;
/* 555 */           this.yCardinal = yInter2;
/* 556 */           this.cote = 4;
/*     */         }
/*     */       }
/* 559 */       if ((this.entRel.getCentreX() < this.xCassure) && (this.entRel.getCentreY() > this.yCassure)) {
/* 560 */         double yInter1 = aaa * (this.entRel.getX() + this.entRel.getWidth()) + bbb;
/* 561 */         double xInter1 = this.entRel.getX() + this.entRel.getWidth();
/*     */         
/* 563 */         double yInter2 = this.entRel.getY();
/* 564 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 566 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 567 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 568 */         this.xCardinal = xInter1;
/* 569 */         this.yCardinal = yInter1;
/* 570 */         this.cote = 1;
/* 571 */         if (dist2 < dist1) {
/* 572 */           this.xCardinal = xInter2;
/* 573 */           this.yCardinal = yInter2;
/* 574 */           this.cote = 4;
/*     */         }
/*     */       }
/* 577 */       if (this.entRel.getCentreX() == this.xCassure) {
/* 578 */         if (this.entRel.getCentreY() > this.yCassure) {
/* 579 */           this.xCardinal = this.entRel.getCentreX();
/* 580 */           this.yCardinal = (this.entRel.getCentreY() - this.entRel.getHeight() / 2 - 5);
/* 581 */           this.cote = 41;
/*     */         } else {
/* 583 */           this.xCardinal = this.entRel.getCentreX();
/* 584 */           this.yCardinal = (this.entRel.getCentreY() + this.entRel.getHeight() / 2 + 17);
/* 585 */           this.cote = 21;
/*     */         }
/*     */       }
/* 588 */       if (this.entRel.getCentreY() == this.yCassure) {
/* 589 */         if (this.entRel.getCentreX() > this.xCassure) {
/* 590 */           this.xCardinal = (this.entRel.getX() - 15);
/* 591 */           this.yCardinal = (this.entRel.getY() + this.entRel.getHeight() / 2);
/* 592 */           this.cote = 11;
/*     */         } else {
/* 594 */           this.xCardinal = (this.entRel.getX() + this.entRel.getWidth() + 5);
/* 595 */           this.yCardinal = (this.entRel.getY() + this.entRel.getHeight() / 2);
/* 596 */           this.cote = 31;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isCible()
/*     */   {
/* 604 */     return this.cible;
/*     */   }
/*     */   
/*     */   public void setCible(boolean cible) {
/* 608 */     this.cible = cible;
/*     */   }
/*     */   
/*     */   public static Color getClLien() {
/* 612 */     return clLien;
/*     */   }
/*     */   
/*     */   public static void setClLien(Color clLien) {
/* 616 */     clLien = clLien;
/*     */   }
/*     */   
/*     */   public IhmEntiteRelation getEntRel() {
/* 620 */     return this.entRel;
/*     */   }
/*     */   
/*     */   public IhmEntiteRelation getContrainte() {
/* 624 */     return this.contrainte;
/*     */   }
/*     */   
/*     */   public boolean isCardCentre() {
/* 628 */     return this.cardCentre;
/*     */   }
/*     */   
/*     */   public void setCardCentre(boolean cardCentre) {
/* 632 */     this.cardCentre = cardCentre;
/*     */   }
/*     */   
/*     */   public void setCassure(boolean cassure) {
/* 636 */     this.cassure = cassure;
/*     */   }
/*     */   
/*     */   public boolean isCassure() {
/* 640 */     return this.cassure;
/*     */   }
/*     */   
/*     */   public void redimentionnerCassure(int x, int y) {
/* 644 */     this.xCassure = x;
/* 645 */     this.yCassure = y;
/*     */   }
/*     */   
/*     */   public boolean isSelectedCassure(int x, int y) {
/* 649 */     if ((isCassure()) && 
/* 650 */       (Math.abs(x - this.xCassure) <= 4.0D) && (Math.abs(x - this.xCassure) <= 4.0D)) { return true;
/*     */     }
/* 652 */     return false;
/*     */   }
/*     */   
/*     */   public void setxCardinal(double xCardinal) {
/* 656 */     this.xCardinal = xCardinal;
/*     */   }
/*     */   
/*     */   public void setyCassure(double yCassure) {
/* 660 */     this.yCassure = yCassure;
/* 661 */     this.xCassure = Parametres.xcassure;
/*     */   }
/*     */   
/*     */   public double getxCassure() {
/* 665 */     return this.xCassure;
/*     */   }
/*     */   
/*     */   public double getyCassure() {
/* 669 */     return this.yCassure;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 673 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 677 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public boolean isSelect() {
/* 681 */     return this.selected;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmLienContraintes.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */