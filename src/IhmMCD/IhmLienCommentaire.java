/*     */ package IhmMCD;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IhmLienCommentaire
/*     */   implements Serializable
/*     */ {
/*     */   private IhmEntiteRelation entRel;
/*     */   private IhmCommentaireIndip commentaire;
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
/*     */   public IhmLienCommentaire(IhmEntiteRelation entRel, IhmCommentaireIndip commentaire)
/*     */   {
/*  33 */     this.entRel = entRel;
/*  34 */     this.commentaire = commentaire;
/*  35 */     this.selected = false;
/*  36 */     this.cassure = false;
/*  37 */     this.xCassure = -1.0D;
/*  38 */     this.yCassure = -1.0D;
/*  39 */     this.cible = false;
/*  40 */     this.nom = "";
/*     */     
/*  42 */     this.cote = 0;
/*  43 */     this.droiteA = -1.0D;
/*  44 */     this.droiteB = -1.0D;
/*  45 */     clLien = Color.GRAY;
/*     */   }
/*     */   
/*     */   public void initPointCassure() {
/*  49 */     this.xCassure = ((this.entRel.getCentreX() + this.commentaire.getCentreX()) / 2);
/*  50 */     this.yCassure = ((this.entRel.getCentreY() + this.commentaire.getCentreY()) / 2);
/*     */   }
/*     */   
/*     */   public void setSelected(boolean selected) {
/*  54 */     this.selected = selected;
/*     */   }
/*     */   
/*     */   public void paint(Graphics g) {
/*  58 */     carculerXYCardinal();
/*  59 */     if (!isCassure())
/*     */     {
/*  61 */       if (this.selected) {
/*  62 */         g.setColor(Color.red);
/*  63 */         dessinerLien(g);
/*     */         
/*  65 */         dessinerfleche(g);
/*  66 */         g.drawString(getNom(), (this.entRel.getCentreX() + this.commentaire.getCentreX()) / 2 + 2, (this.entRel.getCentreY() + this.commentaire.getCentreY()) / 2 - 2);
/*     */       } else {
/*  68 */         g.setColor(Color.GRAY);
/*     */         
/*  70 */         dessinerLien(g);
/*  71 */         dessinerfleche(g);
/*  72 */         g.drawString(getNom(), (this.entRel.getCentreX() + this.commentaire.getCentreX()) / 2 + 2, (this.entRel.getCentreY() + this.commentaire.getCentreY()) / 2 - 2);
/*     */       }
/*     */       
/*     */     }
/*  76 */     else if (this.selected) {
/*  77 */       g.setColor(Color.red);
/*     */       
/*  79 */       dessinerfleche(g);
/*  80 */       dessinerLien(g);
/*  81 */       g.setColor(Color.black);
/*  82 */       g.fillRect((int)this.xCassure - 2, (int)this.yCassure - 2, 4, 4);
/*     */       
/*  84 */       g.drawString(getNom(), (int)(this.xCassure + 2.0D), (int)this.yCassure);
/*  85 */       g.setColor(Color.black);
/*     */     } else {
/*  87 */       g.setColor(Color.GRAY);
/*     */       
/*  89 */       dessinerLien(g);
/*  90 */       dessinerfleche(g);
/*     */       
/*  92 */       g.drawString(getNom(), (int)(this.xCassure + 2.0D), (int)this.yCassure);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void dessinerLien(Graphics g)
/*     */   {
/*  99 */     Graphics2D g2d = (Graphics2D)g;
/* 100 */     float epaisseur = 1.0F;
/* 101 */     float[] style = { 10.0F, 5.0F };
/* 102 */     g2d.setStroke(new BasicStroke(epaisseur, 0, 0, 10.0F, style, 0.0F));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 110 */     if (!isCassure()) {
/* 111 */       g2d.drawLine(this.entRel.getCentreX(), this.entRel.getCentreY(), this.commentaire.getCentreX(), this.commentaire.getCentreY());
/*     */     } else {
/* 113 */       g2d.drawLine(this.entRel.getCentreX(), this.entRel.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/* 114 */       g2d.drawLine((int)this.xCassure, (int)this.yCassure, this.commentaire.getCentreX(), this.commentaire.getCentreY());
/*     */     }
/* 116 */     epaisseur = 1.0F;
/* 117 */     style[0] = 10.0F;
/* 118 */     style[1] = 0.0F;
/* 119 */     g2d.setStroke(new BasicStroke(epaisseur, 0, 0, 1.0F, style, 0.0F));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void dessinerfleche(Graphics g)
/*     */   {
/* 130 */     double a = calculeA();
/* 131 */     double b = calculeB();
/*     */     
/*     */ 
/*     */ 
/* 135 */     if (isCassure()) {
/* 136 */       a = calculeACassureEntite();
/* 137 */       b = calculeBCassureEntite();
/*     */     }
/* 139 */     if (isCible()) {
/* 140 */       Color cl = g.getColor();
/* 141 */       int dx = (int)this.xCardinal;
/* 142 */       int dy = (int)this.yCardinal;
/* 143 */       int dec = 0;
/* 144 */       if (this.entRel.isOmbre()) { dec = 3;
/*     */       }
/* 146 */       if (this.cote == 1) {
/* 147 */         double x1 = this.entRel.getX() + this.entRel.getWidth() + 5 + dec;
/* 148 */         double y1 = x1 * a + b;
/* 149 */         double aV = -1.0D / a;
/* 150 */         double bV = y1 - aV * x1;
/* 151 */         int[] x = { dx + dec, (int)((y1 - 5.0D - bV) / aV), (int)((y1 + 5.0D - bV) / aV) };
/* 152 */         int[] y = { dy, (int)(y1 - 5.0D), (int)(y1 + 5.0D) };
/* 153 */         g.setColor(cl);
/* 154 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/* 157 */       if (this.cote == 2) {
/* 158 */         double y1 = this.entRel.getY() + this.entRel.getHeight() + 5 + dec;
/* 159 */         double x1 = (y1 - b) / a;
/* 160 */         double aV = -1.0D / a;
/* 161 */         double bV = y1 - aV * x1;
/* 162 */         int[] x = { dx, (int)x1 - 5, (int)x1 + 5 };
/* 163 */         int[] y = { dy + dec, (int)(aV * (x1 - 5.0D) + bV), (int)(aV * (x1 + 5.0D) + bV) };
/*     */         
/* 165 */         g.setColor(cl);
/* 166 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/*     */ 
/* 170 */       if (this.cote == 3) {
/* 171 */         double x1 = this.entRel.getX() - 5;
/* 172 */         double y1 = x1 * a + b;
/*     */         
/* 174 */         double aV = -1.0D / a;
/* 175 */         double bV = y1 - aV * x1;
/*     */         
/* 177 */         int[] x = { dx, (int)((y1 - 5.0D - bV) / aV), (int)((y1 + 5.0D - bV) / aV) };
/* 178 */         int[] y = { dy, (int)(y1 - 5.0D), (int)(y1 + 5.0D) };
/*     */         
/* 180 */         g.setColor(cl);
/* 181 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/*     */ 
/* 185 */       if (this.cote == 4) {
/* 186 */         double y1 = this.entRel.getY() - 5;
/* 187 */         double x1 = (y1 - b) / a;
/* 188 */         double aV = -1.0D / a;
/* 189 */         double bV = y1 - aV * x1;
/* 190 */         int[] x = { dx, (int)x1 - 5, (int)x1 + 5 };
/* 191 */         int[] y = { dy, (int)(aV * (x1 - 5.0D) + bV), (int)(aV * (x1 + 5.0D) + bV) };
/*     */         
/* 193 */         g.setColor(cl);
/* 194 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void calculerXYCardinalCentre()
/*     */   {
/* 201 */     if (!isCassure()) {
/* 202 */       this.xCardinal = ((this.entRel.getCentreX() + this.commentaire.getCentreX()) / 2);
/* 203 */       this.yCardinal = ((this.entRel.getCentreY() + this.commentaire.getCentreY()) / 2);
/*     */     } else {
/* 205 */       this.xCardinal = ((int)(this.entRel.getCentreX() + this.xCassure) / 2);
/* 206 */       this.yCardinal = ((int)(this.entRel.getCentreY() + this.yCassure) / 2);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isSelectedDroite(int x, int y)
/*     */   {
/* 212 */     if (!isCassure()) {
/* 213 */       int h = this.entRel.getCentreY() - this.commentaire.getCentreY();
/* 214 */       int w = this.entRel.getCentreX() - this.commentaire.getCentreX();
/* 215 */       if ((Math.abs(w) < 10) && (
/* 216 */         ((this.entRel.getCentreX() >= x) && (this.commentaire.getCentreX() <= x)) || ((this.entRel.getCentreX() <= x) && (this.commentaire.getCentreX() >= x))))
/*     */       {
/* 218 */         if (((this.entRel.getCentreY() >= y) && (this.commentaire.getCentreY() <= y)) || ((this.entRel.getCentreY() <= y) && (this.commentaire.getCentreY() >= y)))
/*     */         {
/* 220 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 225 */       int h = this.entRel.getCentreY() - (int)this.yCassure;
/* 226 */       int w = this.entRel.getCentreX() - (int)this.xCassure;
/* 227 */       if ((Math.abs(w) < 10) && (
/* 228 */         ((this.entRel.getCentreX() >= x) && ((int)this.xCassure <= x)) || ((this.entRel.getCentreX() <= x) && ((int)this.xCassure >= x))))
/*     */       {
/* 230 */         if (((this.entRel.getCentreY() >= y) && ((int)this.yCassure <= y)) || ((this.entRel.getCentreY() <= y) && ((int)this.yCassure >= y)))
/*     */         {
/* 232 */           return true;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 237 */       h = (int)this.yCassure - this.commentaire.getCentreY();
/* 238 */       w = (int)this.xCassure - this.commentaire.getCentreX();
/* 239 */       if ((Math.abs(w) < 10) && (
/* 240 */         (((int)this.xCassure >= x) && (this.commentaire.getCentreX() <= x)) || (((int)this.xCassure <= x) && (this.commentaire.getCentreX() >= x))))
/*     */       {
/* 242 */         if ((((int)this.yCassure >= y) && (this.commentaire.getCentreY() <= y)) || (((int)this.yCassure <= y) && (this.commentaire.getCentreY() >= y)))
/*     */         {
/* 244 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 251 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isSelected(int x, int y)
/*     */   {
/* 256 */     if (isSelectedDroite(x, y)) {
/* 257 */       this.selected = true;
/* 258 */       return true;
/*     */     }
/* 260 */     if (!isCassure()) {
/* 261 */       double aa = calculeA() * x + calculeB() - y;
/* 262 */       if ((aa < 3.0D) && (aa > -3.0D)) {
/* 263 */         if (isDansLeCarre(x, y)) {
/* 264 */           this.selected = true;
/* 265 */           return true;
/*     */         }
/* 267 */         this.selected = false;
/* 268 */         return false;
/*     */       }
/* 270 */       this.selected = false;
/* 271 */       return false;
/*     */     }
/*     */     
/* 274 */     double aa = calculeACassureEntite() * x + calculeBCassureEntite() - y;
/* 275 */     if ((aa < 3.0D) && (aa > -3.0D) && 
/* 276 */       (isDansLeCarreEntite(x, y))) {
/* 277 */       this.selected = true;
/* 278 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 283 */     aa = calculeACassureRelation() * x + calculeBCassureRelation() - y;
/* 284 */     if ((aa < 3.0D) && (aa > -3.0D) && 
/* 285 */       (isDansLeCarreRelation(x, y))) {
/* 286 */       this.selected = true;
/* 287 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 293 */     this.selected = false;
/* 294 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarre(int x, int y)
/*     */   {
/* 299 */     if (this.entRel.getCentreX() != this.commentaire.getCentreX()) {
/* 300 */       if ((this.entRel.getCentreX() <= x) && (this.commentaire.getCentreX() >= x)) return true;
/* 301 */       if ((this.entRel.getCentreX() >= x) && (this.commentaire.getCentreX() <= x)) return true;
/*     */     } else {
/* 303 */       if ((this.entRel.getCentreY() <= y) && (this.commentaire.getCentreY() >= y)) return true;
/* 304 */       if ((this.entRel.getCentreY() >= x) && (this.commentaire.getCentreY() <= y)) return true;
/*     */     }
/* 306 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarreEntite(int x, int y) {
/* 310 */     if (this.entRel.getCentreX() != this.xCassure) {
/* 311 */       if ((this.entRel.getCentreX() <= x) && (this.xCassure >= x)) return true;
/* 312 */       if ((this.entRel.getCentreX() >= x) && (this.xCassure <= x)) return true;
/*     */     } else {
/* 314 */       if ((this.entRel.getCentreY() <= y) && (this.yCassure >= y)) return true;
/* 315 */       if ((this.entRel.getCentreY() >= x) && (this.yCassure <= y)) return true;
/*     */     }
/* 317 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarreRelation(int x, int y) {
/* 321 */     if (this.xCassure != this.commentaire.getCentreX()) {
/* 322 */       if ((this.xCassure <= x) && (this.commentaire.getCentreX() >= x)) return true;
/* 323 */       if ((this.xCassure >= x) && (this.commentaire.getCentreX() <= x)) return true;
/*     */     } else {
/* 325 */       if ((this.yCassure <= y) && (this.commentaire.getCentreY() >= y)) return true;
/* 326 */       if ((this.yCassure >= x) && (this.commentaire.getCentreY() <= y)) return true;
/*     */     }
/* 328 */     return false;
/*     */   }
/*     */   
/*     */   private double calculeA() {
/* 332 */     if (this.entRel.getCentreX() - this.commentaire.getCentreX() != 0) {
/* 333 */       double n = (this.entRel.getCentreY() - this.commentaire.getCentreY()) / (this.entRel.getCentreX() - this.commentaire.getCentreX());
/* 334 */       return n;
/*     */     }
/* 336 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeACassureRelation() {
/* 340 */     if (this.xCassure - this.commentaire.getCentreX() != 0.0D) {
/* 341 */       double n = (this.yCassure - this.commentaire.getCentreY()) / (this.xCassure - this.commentaire.getCentreX());
/* 342 */       return n;
/*     */     }
/* 344 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeACassureEntite() {
/* 348 */     if (this.entRel.getCentreX() - this.xCassure != 0.0D) {
/* 349 */       double n = (this.entRel.getCentreY() - this.yCassure) / (this.entRel.getCentreX() - this.xCassure);
/* 350 */       return n;
/*     */     }
/* 352 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeB() {
/* 356 */     if (this.entRel.getCentreX() - this.commentaire.getCentreX() != 0) {
/* 357 */       double n = this.entRel.getCentreY() - calculeA() * this.entRel.getCentreX();
/* 358 */       return n;
/*     */     }
/* 360 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeBCassureEntite() {
/* 364 */     if (this.entRel.getCentreX() - this.xCassure != 0.0D) {
/* 365 */       double n = this.entRel.getCentreY() - calculeACassureEntite() * this.entRel.getCentreX();
/* 366 */       return n;
/*     */     }
/* 368 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeBCassureRelation() {
/* 372 */     if (this.xCassure - this.commentaire.getCentreX() != 0.0D) {
/* 373 */       double n = this.yCassure - calculeACassureRelation() * this.xCassure;
/* 374 */       return n;
/*     */     }
/* 376 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double distance(int x, int y, int x1, int y1) {
/* 380 */     return Math.sqrt(Math.pow(x - x1, 2.0D) + Math.pow(y - y1, 2.0D));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void carculerXYCardinal()
/*     */   {
/* 389 */     if (!isCassure()) {
/* 390 */       double aaa = calculeA();
/* 391 */       double bbb = calculeB();
/* 392 */       if ((this.entRel.getCentreX() < this.commentaire.getCentreX()) && (this.entRel.getCentreY() < this.commentaire.getCentreY())) {
/* 393 */         double yInter1 = aaa * (this.entRel.getX() + this.entRel.getWidth()) + bbb;
/* 394 */         double xInter1 = this.entRel.getX() + this.entRel.getWidth();
/*     */         
/* 396 */         double yInter2 = this.entRel.getY() + this.entRel.getHeight();
/* 397 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 399 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 400 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 401 */         this.xCardinal = xInter1;
/* 402 */         this.yCardinal = yInter1;
/* 403 */         this.cote = 1;
/* 404 */         if (dist2 < dist1) {
/* 405 */           this.xCardinal = xInter2;
/* 406 */           this.yCardinal = yInter2;
/* 407 */           this.cote = 2;
/*     */         }
/*     */       }
/* 410 */       if ((this.entRel.getCentreX() > this.commentaire.getCentreX()) && (this.entRel.getCentreY() < this.commentaire.getCentreY())) {
/* 411 */         double yInter1 = aaa * this.entRel.getX() + bbb;
/* 412 */         double xInter1 = this.entRel.getX();
/*     */         
/* 414 */         double yInter2 = this.entRel.getY() + this.entRel.getHeight();
/* 415 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 417 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 418 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 419 */         this.xCardinal = xInter1;
/* 420 */         this.yCardinal = yInter1;
/* 421 */         this.cote = 3;
/* 422 */         if (dist2 < dist1) {
/* 423 */           this.xCardinal = xInter2;
/* 424 */           this.yCardinal = yInter2;
/* 425 */           this.cote = 2;
/*     */         }
/*     */       }
/* 428 */       if ((this.entRel.getCentreX() > this.commentaire.getCentreX()) && (this.entRel.getCentreY() > this.commentaire.getCentreY())) {
/* 429 */         double yInter1 = aaa * this.entRel.getX() + bbb;
/* 430 */         double xInter1 = this.entRel.getX();
/*     */         
/* 432 */         double yInter2 = this.entRel.getY();
/* 433 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 435 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 436 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 437 */         this.xCardinal = xInter1;
/* 438 */         this.yCardinal = yInter1;
/* 439 */         this.cote = 3;
/* 440 */         if (dist2 < dist1) {
/* 441 */           this.xCardinal = xInter2;
/* 442 */           this.yCardinal = yInter2;
/* 443 */           this.cote = 4;
/*     */         }
/*     */       }
/* 446 */       if ((this.entRel.getCentreX() < this.commentaire.getCentreX()) && (this.entRel.getCentreY() > this.commentaire.getCentreY())) {
/* 447 */         double yInter1 = aaa * (this.entRel.getX() + this.entRel.getWidth()) + bbb;
/* 448 */         double xInter1 = this.entRel.getX() + this.entRel.getWidth();
/*     */         
/* 450 */         double yInter2 = this.entRel.getY();
/* 451 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 453 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 454 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 455 */         this.xCardinal = xInter1;
/* 456 */         this.yCardinal = yInter1;
/* 457 */         this.cote = 1;
/* 458 */         if (dist2 < dist1) {
/* 459 */           this.xCardinal = xInter2;
/* 460 */           this.yCardinal = yInter2;
/* 461 */           this.cote = 4;
/*     */         }
/*     */       }
/* 464 */       if (this.entRel.getCentreX() == this.commentaire.getCentreX()) {
/* 465 */         if (this.entRel.getCentreY() > this.commentaire.getCentreY()) {
/* 466 */           this.xCardinal = this.entRel.getCentreX();
/* 467 */           this.yCardinal = (this.entRel.getCentreY() - this.entRel.getHeight() / 2 - 5);
/* 468 */           this.cote = 41;
/*     */         } else {
/* 470 */           this.xCardinal = this.entRel.getCentreX();
/* 471 */           this.yCardinal = (this.entRel.getCentreY() + this.entRel.getHeight() / 2 + 17);
/* 472 */           this.cote = 21;
/*     */         }
/*     */       }
/* 475 */       if (this.entRel.getCentreY() == this.commentaire.getCentreY()) {
/* 476 */         if (this.entRel.getCentreX() > this.commentaire.getCentreX()) {
/* 477 */           this.xCardinal = (this.entRel.getX() - 15);
/* 478 */           this.yCardinal = (this.entRel.getY() + this.entRel.getHeight() / 2);
/* 479 */           this.cote = 11;
/*     */         } else {
/* 481 */           this.xCardinal = (this.entRel.getX() + this.entRel.getWidth() + 5);
/* 482 */           this.yCardinal = (this.entRel.getY() + this.entRel.getHeight() / 2);
/* 483 */           this.cote = 31;
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 488 */       double aaa = calculeACassureEntite();
/* 489 */       double bbb = calculeBCassureEntite();
/* 490 */       if ((this.entRel.getCentreX() < this.xCassure) && (this.entRel.getCentreY() < this.yCassure)) {
/* 491 */         double yInter1 = aaa * (this.entRel.getX() + this.entRel.getWidth()) + bbb;
/* 492 */         double xInter1 = this.entRel.getX() + this.entRel.getWidth();
/*     */         
/* 494 */         double yInter2 = this.entRel.getY() + this.entRel.getHeight();
/* 495 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 497 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 498 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 499 */         this.xCardinal = xInter1;
/* 500 */         this.yCardinal = yInter1;
/* 501 */         this.cote = 1;
/* 502 */         if (dist2 < dist1) {
/* 503 */           this.xCardinal = xInter2;
/* 504 */           this.yCardinal = yInter2;
/* 505 */           this.cote = 2;
/*     */         }
/*     */       }
/* 508 */       if ((this.entRel.getCentreX() > this.xCassure) && (this.entRel.getCentreY() < this.yCassure)) {
/* 509 */         double yInter1 = aaa * this.entRel.getX() + bbb;
/* 510 */         double xInter1 = this.entRel.getX();
/*     */         
/* 512 */         double yInter2 = this.entRel.getY() + this.entRel.getHeight();
/* 513 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 515 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 516 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 517 */         this.xCardinal = xInter1;
/* 518 */         this.yCardinal = yInter1;
/* 519 */         this.cote = 3;
/* 520 */         if (dist2 < dist1) {
/* 521 */           this.xCardinal = xInter2;
/* 522 */           this.yCardinal = yInter2;
/* 523 */           this.cote = 2;
/*     */         }
/*     */       }
/* 526 */       if ((this.entRel.getCentreX() > this.xCassure) && (this.entRel.getCentreY() > this.yCassure)) {
/* 527 */         double yInter1 = aaa * this.entRel.getX() + bbb;
/* 528 */         double xInter1 = this.entRel.getX();
/*     */         
/* 530 */         double yInter2 = this.entRel.getY();
/* 531 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 533 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 534 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 535 */         this.xCardinal = xInter1;
/* 536 */         this.yCardinal = yInter1;
/* 537 */         this.cote = 3;
/* 538 */         if (dist2 < dist1) {
/* 539 */           this.xCardinal = xInter2;
/* 540 */           this.yCardinal = yInter2;
/* 541 */           this.cote = 4;
/*     */         }
/*     */       }
/* 544 */       if ((this.entRel.getCentreX() < this.xCassure) && (this.entRel.getCentreY() > this.yCassure)) {
/* 545 */         double yInter1 = aaa * (this.entRel.getX() + this.entRel.getWidth()) + bbb;
/* 546 */         double xInter1 = this.entRel.getX() + this.entRel.getWidth();
/*     */         
/* 548 */         double yInter2 = this.entRel.getY();
/* 549 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 551 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 552 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entRel.getCentreX(), this.entRel.getCentreY());
/* 553 */         this.xCardinal = xInter1;
/* 554 */         this.yCardinal = yInter1;
/* 555 */         this.cote = 1;
/* 556 */         if (dist2 < dist1) {
/* 557 */           this.xCardinal = xInter2;
/* 558 */           this.yCardinal = yInter2;
/* 559 */           this.cote = 4;
/*     */         }
/*     */       }
/* 562 */       if (this.entRel.getCentreX() == this.xCassure) {
/* 563 */         if (this.entRel.getCentreY() > this.yCassure) {
/* 564 */           this.xCardinal = this.entRel.getCentreX();
/* 565 */           this.yCardinal = (this.entRel.getCentreY() - this.entRel.getHeight() / 2 - 5);
/* 566 */           this.cote = 41;
/*     */         } else {
/* 568 */           this.xCardinal = this.entRel.getCentreX();
/* 569 */           this.yCardinal = (this.entRel.getCentreY() + this.entRel.getHeight() / 2 + 17);
/* 570 */           this.cote = 21;
/*     */         }
/*     */       }
/* 573 */       if (this.entRel.getCentreY() == this.yCassure) {
/* 574 */         if (this.entRel.getCentreX() > this.xCassure) {
/* 575 */           this.xCardinal = (this.entRel.getX() - 15);
/* 576 */           this.yCardinal = (this.entRel.getY() + this.entRel.getHeight() / 2);
/* 577 */           this.cote = 11;
/*     */         } else {
/* 579 */           this.xCardinal = (this.entRel.getX() + this.entRel.getWidth() + 5);
/* 580 */           this.yCardinal = (this.entRel.getY() + this.entRel.getHeight() / 2);
/* 581 */           this.cote = 31;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isCible()
/*     */   {
/* 589 */     return this.cible;
/*     */   }
/*     */   
/*     */   public void setCible(boolean cible) {
/* 593 */     this.cible = cible;
/*     */   }
/*     */   
/*     */   public static Color getClLien() {
/* 597 */     return clLien;
/*     */   }
/*     */   
/*     */   public void setClLien(Color clLien)
/*     */   {
/* 602 */     clLien = clLien;
/*     */   }
/*     */   
/*     */   public IhmEntiteRelation getEntRel() {
/* 606 */     return this.entRel;
/*     */   }
/*     */   
/*     */   public IhmCommentaireIndip getCommentaire() {
/* 610 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public boolean isCardCentre() {
/* 614 */     return this.cardCentre;
/*     */   }
/*     */   
/*     */   public void setCardCentre(boolean cardCentre) {
/* 618 */     this.cardCentre = cardCentre;
/*     */   }
/*     */   
/*     */   public void setCassure(boolean cassure) {
/* 622 */     this.cassure = cassure;
/*     */   }
/*     */   
/*     */   public boolean isCassure() {
/* 626 */     return this.cassure;
/*     */   }
/*     */   
/*     */   public void redimentionnerCassure(int x, int y) {
/* 630 */     this.xCassure = x;
/* 631 */     this.yCassure = y;
/*     */   }
/*     */   
/*     */   public boolean isSelectedCassure(int x, int y) {
/* 635 */     if ((isCassure()) && 
/* 636 */       (Math.abs(x - this.xCassure) <= 4.0D) && (Math.abs(x - this.xCassure) <= 4.0D)) { return true;
/*     */     }
/* 638 */     return false;
/*     */   }
/*     */   
/*     */   public void setxCardinal(double xCardinal) {
/* 642 */     this.xCardinal = xCardinal;
/*     */   }
/*     */   
/*     */   public void setyCassure(double yCassure) {
/* 646 */     this.yCassure = yCassure;
/* 647 */     this.xCassure = Parametres.xcassure;
/*     */   }
/*     */   
/*     */   public double getxCassure() {
/* 651 */     return this.xCassure;
/*     */   }
/*     */   
/*     */   public double getyCassure() {
/* 655 */     return this.yCassure;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 659 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 663 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public boolean isSelect() {
/* 667 */     return this.selected;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmLienCommentaire.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */