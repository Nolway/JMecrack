/*     */ package IhmMCD;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import ihm.FormeInterneMCD;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IhmLienHeritage
/*     */   implements Serializable
/*     */ {
/*     */   private IhmEntite entite;
/*     */   private IhmEntite entitefils;
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
/*     */   
/*     */   public IhmLienHeritage(IhmEntite entite, IhmEntite entitefils)
/*     */   {
/*  31 */     this.entite = entite;
/*  32 */     this.entitefils = entitefils;
/*  33 */     setClLien(FormeInterneMCD.clLien);
/*  34 */     this.selected = true;
/*  35 */     this.cassure = false;
/*  36 */     this.xCassure = -1.0D;
/*  37 */     this.yCassure = -1.0D;
/*  38 */     this.cible = true;
/*  39 */     this.nom = "";
/*  40 */     initPointCassure();
/*  41 */     this.cote = 0;
/*     */   }
/*     */   
/*     */   public void initPointCassure() {
/*  45 */     this.xCassure = 0.0D;
/*  46 */     this.yCassure = 0.0D;
/*  47 */     if (this.entite != null) {
/*  48 */       this.xCassure = ((this.entite.getCentreX() + this.entitefils.getCentreX()) / 2);
/*  49 */       this.yCassure = ((this.entite.getCentreY() + this.entitefils.getCentreY()) / 2);
/*     */     }
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
/*  63 */         g.drawLine(this.entite.getCentreX(), this.entite.getCentreY(), this.entitefils.getCentreX(), this.entitefils.getCentreY());
/*  64 */         dessinerfleche(g);
/*  65 */         g.drawString(getNom(), (this.entite.getCentreX() + this.entitefils.getCentreX()) / 2 + 2, (this.entite.getCentreY() + this.entitefils.getCentreY()) / 2 - 2);
/*     */       } else {
/*  67 */         g.setColor(clLien);
/*  68 */         g.drawLine(this.entite.getCentreX(), this.entite.getCentreY(), this.entitefils.getCentreX(), this.entitefils.getCentreY());
/*  69 */         dessinerfleche(g);
/*  70 */         g.drawString(getNom(), (this.entite.getCentreX() + this.entitefils.getCentreX()) / 2 + 2, (this.entite.getCentreY() + this.entitefils.getCentreY()) / 2 - 2);
/*     */       }
/*     */       
/*     */     }
/*  74 */     else if (this.selected) {
/*  75 */       g.setColor(Color.red);
/*  76 */       g.drawLine(this.entite.getCentreX(), this.entite.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/*  77 */       dessinerfleche(g);
/*  78 */       g.drawLine(this.entitefils.getCentreX(), this.entitefils.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/*  79 */       g.drawString(getNom(), (int)(this.xCassure + 2.0D), (int)this.yCassure);
/*  80 */       g.setColor(Color.black);
/*  81 */       g.fillRect((int)this.xCassure - 2, (int)this.yCassure - 2, 4, 4);
/*     */     } else {
/*  83 */       g.setColor(clLien);
/*  84 */       g.drawLine(this.entite.getCentreX(), this.entite.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/*  85 */       dessinerfleche(g);
/*  86 */       g.drawLine(this.entitefils.getCentreX(), this.entitefils.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/*  87 */       g.drawString(getNom(), (int)(this.xCassure + 2.0D), (int)this.yCassure);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private Point rotation(double x, double y, double tg)
/*     */   {
/*  94 */     Point p = new Point(0, 0);
/*  95 */     double x1 = 0.0D;double y1 = 0.0D;double rac = 0.0D;
/*  96 */     rac = Math.sqrt(Math.pow(tg, 2.0D) + 1.0D);
/*  97 */     x1 = (x - y * tg) / rac;
/*  98 */     y1 = (y + x * tg) / rac;
/*  99 */     p.setX((int)x1);
/* 100 */     p.setY((int)y1);
/* 101 */     return p;
/*     */   }
/*     */   
/*     */   private void dessinerfleche(Graphics g) {
/* 105 */     double a = calculeA();
/* 106 */     double b = calculeB();
/*     */     
/* 108 */     Point point = new Point(0, 0);
/*     */     
/* 110 */     if (isCassure()) {
/* 111 */       a = calculeACassureEntite();
/* 112 */       b = calculeBCassureEntite();
/*     */     }
/*     */     
/* 115 */     if (isCible()) {
/* 116 */       Color cl = g.getColor();
/* 117 */       int dx = (int)this.xCardinal;
/* 118 */       int dy = (int)this.yCardinal;
/* 119 */       int dec = 0;
/* 120 */       if (this.entite.isOmbre()) { dec = 3;
/*     */       }
/* 122 */       if (this.cote == 1) {
/* 123 */         double x1 = this.entite.getX() + this.entite.getWidth() + 10;
/* 124 */         double y1 = x1 * a + b;
/* 125 */         double aV = -1.0D / a;
/* 126 */         double bV = y1 - aV * x1;
/* 127 */         int[] x = { dx + dec, (int)((y1 - 10.0D - bV) / aV), (int)((y1 + 10.0D - bV) / aV) };
/* 128 */         int[] y = { dy, (int)(y1 - 10.0D), (int)(y1 + 10.0D) };
/* 129 */         g.setColor(Color.WHITE);
/* 130 */         g.fillPolygon(x, y, 3);
/* 131 */         g.setColor(cl);
/* 132 */         g.drawPolygon(x, y, 3);
/*     */       }
/*     */       
/* 135 */       if (this.cote == 2)
/*     */       {
/*     */ 
/* 138 */         double yy1 = 10 + dec;double yy2 = 10 + dec;
/* 139 */         double xx1 = -10.0D;double xx2 = 10.0D;
/* 140 */         point = rotation(xx1, yy1, Math.tan(Math.atan(a) + 1.5707963267948966D));
/* 141 */         xx1 = point.getX() + dx;
/* 142 */         yy1 = point.getY() + dy;
/*     */         
/* 144 */         point = rotation(xx2, yy2, Math.tan(Math.atan(a) + 1.5707963267948966D));
/* 145 */         xx2 = point.getX() + dx;
/* 146 */         yy2 = point.getY() + dy;
/*     */         
/* 148 */         int[] x = { dx, (int)xx1, (int)xx2 };
/* 149 */         int[] y = { dy, (int)yy1, (int)yy2 };
/*     */         
/* 151 */         g.setColor(Color.WHITE);
/* 152 */         g.fillPolygon(x, y, 3);
/* 153 */         g.setColor(cl);
/* 154 */         g.drawPolygon(x, y, 3);
/*     */       }
/*     */       
/*     */ 
/* 158 */       if (this.cote == 3) {
/* 159 */         double x1 = this.entite.getX() - 10;
/* 160 */         double y1 = x1 * a + b;
/* 161 */         double aV = -1.0D / a;
/* 162 */         double bV = y1 - aV * x1;
/* 163 */         int[] x = { dx, (int)((y1 - 10.0D - bV) / aV), (int)((y1 + 10.0D - bV) / aV) };
/* 164 */         int[] y = { dy, (int)(y1 - 10.0D), (int)(y1 + 10.0D) };
/*     */         
/* 166 */         g.setColor(Color.WHITE);
/* 167 */         g.fillPolygon(x, y, 3);
/* 168 */         g.setColor(cl);
/* 169 */         g.drawPolygon(x, y, 3);
/*     */       }
/* 171 */       if (this.cote == 4)
/*     */       {
/* 173 */         double yy1 = -10.0D;double yy2 = -10.0D;
/* 174 */         double xx1 = -10.0D;double xx2 = 10.0D;
/*     */         
/* 176 */         point = rotation(xx1, yy1, Math.tan(Math.atan(a) + 1.5707963267948966D));
/* 177 */         xx1 = point.getX() + dx;
/* 178 */         yy1 = point.getY() + dy;
/*     */         
/* 180 */         point = rotation(xx2, yy2, Math.tan(Math.atan(a) + 1.5707963267948966D));
/* 181 */         xx2 = point.getX() + dx;
/* 182 */         yy2 = point.getY() + dy;
/*     */         
/* 184 */         int[] x = { dx, (int)xx1, (int)xx2 };
/* 185 */         int[] y = { dy, (int)yy1, (int)yy2 };
/*     */         
/* 187 */         g.setColor(Color.WHITE);
/* 188 */         g.fillPolygon(x, y, 3);
/* 189 */         g.setColor(cl);
/* 190 */         g.drawPolygon(x, y, 3);
/*     */       }
/* 192 */       if (this.cote == 21)
/*     */       {
/* 194 */         double yy1 = dy + 10 + dec;double yy2 = dy + 10 + dec;
/* 195 */         double xx1 = -10 + dx;double xx2 = 10 + dx;
/* 196 */         int[] x = { dx, (int)xx1, (int)xx2 };
/* 197 */         int[] y = { dy + 2, (int)yy1, (int)yy2 };
/*     */         
/* 199 */         g.setColor(Color.WHITE);
/* 200 */         g.fillPolygon(x, y, 3);
/* 201 */         g.setColor(cl);
/* 202 */         g.drawPolygon(x, y, 3);
/*     */       }
/* 204 */       if (this.cote == 41)
/*     */       {
/* 206 */         double yy1 = dy - 10;double yy2 = dy - 10;
/* 207 */         double xx1 = -10 + dx;double xx2 = 10 + dx;
/* 208 */         int[] x = { dx, (int)xx1, (int)xx2 };
/* 209 */         int[] y = { dy + 2, (int)yy1, (int)yy2 };
/*     */         
/* 211 */         g.setColor(Color.WHITE);
/* 212 */         g.fillPolygon(x, y, 3);
/* 213 */         g.setColor(cl);
/* 214 */         g.drawPolygon(x, y, 3);
/*     */       }
/* 216 */       if (this.cote == 31) {
/* 217 */         int[] x = { dx, dx - 10, dx - 10 };
/* 218 */         int[] y = { dy, dy - 10, dy + 10 };
/*     */         
/* 220 */         g.setColor(Color.WHITE);
/* 221 */         g.fillPolygon(x, y, 3);
/* 222 */         g.setColor(cl);
/* 223 */         g.drawPolygon(x, y, 3);
/*     */       }
/* 225 */       if (this.cote == 11) {
/* 226 */         int[] x = { dx, dx + 10, dx + 10 };
/* 227 */         int[] y = { dy, dy - 10, dy + 10 };
/*     */         
/* 229 */         g.setColor(Color.WHITE);
/* 230 */         g.fillPolygon(x, y, 3);
/* 231 */         g.setColor(cl);
/* 232 */         g.drawPolygon(x, y, 3);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isSelectedDroite(int x, int y)
/*     */   {
/* 239 */     if (!isCassure()) {
/* 240 */       int h = this.entite.getCentreY() - this.entitefils.getCentreY();
/* 241 */       int w = this.entite.getCentreX() - this.entitefils.getCentreX();
/* 242 */       if ((Math.abs(w) < 10) && (
/* 243 */         ((this.entite.getCentreX() >= x) && (this.entitefils.getCentreX() <= x)) || ((this.entite.getCentreX() <= x) && (this.entitefils.getCentreX() >= x))))
/*     */       {
/* 245 */         if (((this.entite.getCentreY() >= y) && (this.entitefils.getCentreY() <= y)) || ((this.entite.getCentreY() <= y) && (this.entitefils.getCentreY() >= y)))
/*     */         {
/* 247 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 252 */       int h = this.entite.getCentreY() - (int)this.yCassure;
/* 253 */       int w = this.entite.getCentreX() - (int)this.xCassure;
/* 254 */       if ((Math.abs(w) < 10) && (
/* 255 */         ((this.entite.getCentreX() >= x) && ((int)this.xCassure <= x)) || ((this.entite.getCentreX() <= x) && ((int)this.xCassure >= x))))
/*     */       {
/* 257 */         if (((this.entite.getCentreY() >= y) && ((int)this.yCassure <= y)) || ((this.entite.getCentreY() <= y) && ((int)this.yCassure >= y)))
/*     */         {
/* 259 */           return true;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 264 */       h = (int)this.yCassure - this.entitefils.getCentreY();
/* 265 */       w = (int)this.xCassure - this.entitefils.getCentreX();
/* 266 */       if ((Math.abs(w) < 10) && (
/* 267 */         (((int)this.xCassure >= x) && (this.entitefils.getCentreX() <= x)) || (((int)this.xCassure <= x) && (this.entitefils.getCentreX() >= x))))
/*     */       {
/* 269 */         if ((((int)this.yCassure >= y) && (this.entitefils.getCentreY() <= y)) || (((int)this.yCassure <= y) && (this.entitefils.getCentreY() >= y)))
/*     */         {
/* 271 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 278 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isSelected(int x, int y)
/*     */   {
/* 284 */     if (isSelectedDroite(x, y)) {
/* 285 */       this.selected = true;
/* 286 */       return true;
/*     */     }
/*     */     
/* 289 */     if (!isCassure()) {
/* 290 */       if ((this.entite.getCentreX() - this.entitefils.getCentreX() > -6) && (this.entite.getCentreX() - this.entitefils.getCentreX() < 6) && 
/* 291 */         (x > this.entite.getCentreX()) && (x < this.entitefils.getCentreX())) {
/* 292 */         this.selected = true;
/* 293 */         return true;
/*     */       }
/*     */       
/* 296 */       double aa = calculeA() * x + calculeB() - y;
/* 297 */       if ((aa < 3.0D) && (aa > -3.0D)) {
/* 298 */         if (isDansLeCarre(x, y)) {
/* 299 */           this.selected = true;
/* 300 */           return true;
/*     */         }
/* 302 */         this.selected = false;
/* 303 */         return false;
/*     */       }
/* 305 */       this.selected = false;
/* 306 */       return false;
/*     */     }
/*     */     
/* 309 */     double aa = calculeACassureEntite() * x + calculeBCassureEntite() - y;
/* 310 */     if ((aa < 3.0D) && (aa > -3.0D) && 
/* 311 */       (isDansLeCarreEntite(x, y))) {
/* 312 */       this.selected = true;
/* 313 */       return true;
/*     */     }
/*     */     
/* 316 */     aa = calculeACassureRelation() * x + calculeBCassureRelation() - y;
/* 317 */     if ((aa < 3.0D) && (aa > -3.0D) && 
/* 318 */       (isDansLeCarreRelation(x, y))) {
/* 319 */       this.selected = true;
/* 320 */       return true;
/*     */     }
/*     */     
/* 323 */     this.selected = false;
/* 324 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarre(int x, int y)
/*     */   {
/* 329 */     if (this.entite.getCentreX() != this.entitefils.getCentreX()) {
/* 330 */       if ((this.entite.getCentreX() <= x) && (this.entitefils.getCentreX() >= x)) return true;
/* 331 */       if ((this.entite.getCentreX() >= x) && (this.entitefils.getCentreX() <= x)) return true;
/*     */     } else {
/* 333 */       if ((this.entite.getCentreY() <= y) && (this.entitefils.getCentreY() >= y)) return true;
/* 334 */       if ((this.entite.getCentreY() >= x) && (this.entitefils.getCentreY() <= y)) return true;
/*     */     }
/* 336 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarreEntite(int x, int y) {
/* 340 */     if (this.entite.getCentreX() != this.xCassure) {
/* 341 */       if ((this.entite.getCentreX() <= x) && (this.xCassure >= x)) return true;
/* 342 */       if ((this.entite.getCentreX() >= x) && (this.xCassure <= x)) return true;
/*     */     } else {
/* 344 */       if ((this.entite.getCentreY() <= y) && (this.yCassure >= y)) return true;
/* 345 */       if ((this.entite.getCentreY() >= x) && (this.yCassure <= y)) return true;
/*     */     }
/* 347 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarreRelation(int x, int y) {
/* 351 */     if (this.xCassure != this.entitefils.getCentreX()) {
/* 352 */       if ((this.xCassure <= x) && (this.entitefils.getCentreX() >= x)) return true;
/* 353 */       if ((this.xCassure >= x) && (this.entitefils.getCentreX() <= x)) return true;
/*     */     } else {
/* 355 */       if ((this.yCassure <= y) && (this.entitefils.getCentreY() >= y)) return true;
/* 356 */       if ((this.yCassure >= x) && (this.entitefils.getCentreY() <= y)) return true;
/*     */     }
/* 358 */     return false;
/*     */   }
/*     */   
/*     */   private double calculeA() {
/* 362 */     if (this.entite.getCentreX() - this.entitefils.getCentreX() != 0) {
/* 363 */       double n = (this.entite.getCentreY() - this.entitefils.getCentreY()) / (this.entite.getCentreX() - this.entitefils.getCentreX());
/* 364 */       return n;
/*     */     }
/* 366 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeACassureRelation() {
/* 370 */     if (this.xCassure - this.entitefils.getCentreX() != 0.0D) {
/* 371 */       double n = (this.yCassure - this.entitefils.getCentreY()) / (this.xCassure - this.entitefils.getCentreX());
/* 372 */       return n;
/*     */     }
/* 374 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeACassureEntite() {
/* 378 */     if (this.entite.getCentreX() - this.xCassure != 0.0D) {
/* 379 */       double n = (this.entite.getCentreY() - this.yCassure) / (this.entite.getCentreX() - this.xCassure);
/* 380 */       return n;
/*     */     }
/* 382 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeB() {
/* 386 */     if (this.entite.getCentreX() - this.entitefils.getCentreX() != 0) {
/* 387 */       double n = this.entite.getCentreY() - calculeA() * this.entite.getCentreX();
/* 388 */       return n;
/*     */     }
/* 390 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeBCassureEntite() {
/* 394 */     if (this.entite.getCentreX() - this.xCassure != 0.0D) {
/* 395 */       double n = this.entite.getCentreY() - calculeACassureEntite() * this.entite.getCentreX();
/* 396 */       return n;
/*     */     }
/* 398 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeBCassureRelation() {
/* 402 */     if (this.xCassure - this.entitefils.getCentreX() != 0.0D) {
/* 403 */       double n = this.yCassure - calculeACassureRelation() * this.xCassure;
/* 404 */       return n;
/*     */     }
/* 406 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double distance(int x, int y, int x1, int y1) {
/* 410 */     return Math.sqrt(Math.pow(x - x1, 2.0D) + Math.pow(y - y1, 2.0D));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void carculerXYCardinal()
/*     */   {
/* 419 */     if (!isCassure()) {
/* 420 */       double aaa = calculeA();
/* 421 */       double bbb = calculeB();
/* 422 */       if ((this.entite.getCentreX() < this.entitefils.getCentreX()) && (this.entite.getCentreY() < this.entitefils.getCentreY())) {
/* 423 */         double yInter1 = aaa * (this.entite.getX() + this.entite.getWidth()) + bbb;
/* 424 */         double xInter1 = this.entite.getX() + this.entite.getWidth();
/*     */         
/* 426 */         double yInter2 = this.entite.getY() + this.entite.getHeight();
/* 427 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 429 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 430 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 431 */         this.xCardinal = xInter1;
/* 432 */         this.yCardinal = yInter1;
/* 433 */         this.cote = 1;
/* 434 */         if (dist2 < dist1) {
/* 435 */           this.xCardinal = xInter2;
/* 436 */           this.yCardinal = yInter2;
/* 437 */           this.cote = 2;
/*     */         }
/*     */       }
/* 440 */       if ((this.entite.getCentreX() > this.entitefils.getCentreX()) && (this.entite.getCentreY() < this.entitefils.getCentreY())) {
/* 441 */         double yInter1 = aaa * this.entite.getX() + bbb;
/* 442 */         double xInter1 = this.entite.getX();
/*     */         
/* 444 */         double yInter2 = this.entite.getY() + this.entite.getHeight();
/* 445 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 447 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 448 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 449 */         this.xCardinal = xInter1;
/* 450 */         this.yCardinal = yInter1;
/* 451 */         this.cote = 3;
/* 452 */         if (dist2 < dist1) {
/* 453 */           this.xCardinal = xInter2;
/* 454 */           this.yCardinal = yInter2;
/* 455 */           this.cote = 2;
/*     */         }
/*     */       }
/* 458 */       if ((this.entite.getCentreX() > this.entitefils.getCentreX()) && (this.entite.getCentreY() > this.entitefils.getCentreY())) {
/* 459 */         double yInter1 = aaa * this.entite.getX() + bbb;
/* 460 */         double xInter1 = this.entite.getX();
/*     */         
/* 462 */         double yInter2 = this.entite.getY();
/* 463 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 465 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 466 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 467 */         this.xCardinal = xInter1;
/* 468 */         this.yCardinal = yInter1;
/* 469 */         this.cote = 3;
/* 470 */         if (dist2 < dist1) {
/* 471 */           this.xCardinal = xInter2;
/* 472 */           this.yCardinal = yInter2;
/* 473 */           this.cote = 4;
/*     */         }
/*     */       }
/* 476 */       if ((this.entite.getCentreX() < this.entitefils.getCentreX()) && (this.entite.getCentreY() > this.entitefils.getCentreY())) {
/* 477 */         double yInter1 = aaa * (this.entite.getX() + this.entite.getWidth()) + bbb;
/* 478 */         double xInter1 = this.entite.getX() + this.entite.getWidth();
/*     */         
/* 480 */         double yInter2 = this.entite.getY();
/* 481 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 483 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 484 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 485 */         this.xCardinal = xInter1;
/* 486 */         this.yCardinal = yInter1;
/* 487 */         this.cote = 1;
/* 488 */         if (dist2 < dist1) {
/* 489 */           this.xCardinal = xInter2;
/* 490 */           this.yCardinal = yInter2;
/* 491 */           this.cote = 4;
/*     */         }
/*     */       }
/* 494 */       if (this.entite.getCentreX() == this.entitefils.getCentreX()) {
/* 495 */         if (this.entite.getCentreY() > this.entitefils.getCentreY()) {
/* 496 */           this.xCardinal = this.entite.getCentreX();
/* 497 */           this.yCardinal = (this.entite.getCentreY() - this.entite.getHeight() / 2);
/* 498 */           this.cote = 41;
/*     */         } else {
/* 500 */           this.xCardinal = this.entite.getCentreX();
/* 501 */           this.yCardinal = (this.entite.getCentreY() + this.entite.getHeight() / 2);
/* 502 */           this.cote = 21;
/*     */         }
/*     */       }
/* 505 */       if (this.entite.getCentreY() == this.entitefils.getCentreY()) {
/* 506 */         if (this.entite.getCentreX() > this.entitefils.getCentreX()) {
/* 507 */           this.xCardinal = this.entite.getX();
/* 508 */           this.yCardinal = (this.entite.getY() + this.entite.getHeight() / 2);
/* 509 */           this.cote = 31;
/*     */         }
/*     */         else {
/* 512 */           this.xCardinal = (this.entite.getX() + this.entite.getWidth());
/* 513 */           this.yCardinal = (this.entite.getY() + this.entite.getHeight() / 2);
/* 514 */           this.cote = 11;
/*     */         }
/*     */       }
/*     */     } else {
/* 518 */       double aaa = calculeACassureEntite();
/* 519 */       double bbb = calculeBCassureEntite();
/* 520 */       if ((this.entite.getCentreX() < this.xCassure) && (this.entite.getCentreY() < this.yCassure)) {
/* 521 */         double yInter1 = aaa * (this.entite.getX() + this.entite.getWidth()) + bbb;
/* 522 */         double xInter1 = this.entite.getX() + this.entite.getWidth();
/*     */         
/* 524 */         double yInter2 = this.entite.getY() + this.entite.getHeight();
/* 525 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 527 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 528 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 529 */         this.xCardinal = xInter1;
/* 530 */         this.yCardinal = yInter1;
/* 531 */         this.cote = 1;
/* 532 */         if (dist2 < dist1) {
/* 533 */           this.xCardinal = xInter2;
/* 534 */           this.yCardinal = yInter2;
/* 535 */           this.cote = 2;
/*     */         }
/*     */       }
/* 538 */       if ((this.entite.getCentreX() > this.xCassure) && (this.entite.getCentreY() < this.yCassure)) {
/* 539 */         double yInter1 = aaa * this.entite.getX() + bbb;
/* 540 */         double xInter1 = this.entite.getX();
/*     */         
/* 542 */         double yInter2 = this.entite.getY() + this.entite.getHeight();
/* 543 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 545 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 546 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 547 */         this.xCardinal = xInter1;
/* 548 */         this.yCardinal = yInter1;
/* 549 */         this.cote = 3;
/* 550 */         if (dist2 < dist1) {
/* 551 */           this.xCardinal = xInter2;
/* 552 */           this.yCardinal = yInter2;
/* 553 */           this.cote = 2;
/*     */         }
/*     */       }
/* 556 */       if ((this.entite.getCentreX() > this.xCassure) && (this.entite.getCentreY() > this.yCassure)) {
/* 557 */         double yInter1 = aaa * this.entite.getX() + bbb;
/* 558 */         double xInter1 = this.entite.getX();
/*     */         
/* 560 */         double yInter2 = this.entite.getY();
/* 561 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 563 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 564 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 565 */         this.xCardinal = xInter1;
/* 566 */         this.yCardinal = yInter1;
/* 567 */         this.cote = 3;
/* 568 */         if (dist2 < dist1) {
/* 569 */           this.xCardinal = xInter2;
/* 570 */           this.yCardinal = yInter2;
/* 571 */           this.cote = 4;
/*     */         }
/*     */       }
/* 574 */       if ((this.entite.getCentreX() < this.xCassure) && (this.entite.getCentreY() > this.yCassure)) {
/* 575 */         double yInter1 = aaa * (this.entite.getX() + this.entite.getWidth()) + bbb;
/* 576 */         double xInter1 = this.entite.getX() + this.entite.getWidth();
/*     */         
/* 578 */         double yInter2 = this.entite.getY();
/* 579 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 581 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 582 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 583 */         this.xCardinal = xInter1;
/* 584 */         this.yCardinal = yInter1;
/* 585 */         this.cote = 1;
/* 586 */         if (dist2 < dist1) {
/* 587 */           this.xCardinal = xInter2;
/* 588 */           this.yCardinal = yInter2;
/* 589 */           this.cote = 4;
/*     */         }
/*     */       }
/* 592 */       if (this.entite.getCentreX() == this.xCassure) {
/* 593 */         if (this.entite.getCentreY() > this.yCassure) {
/* 594 */           this.xCardinal = this.entite.getCentreX();
/* 595 */           this.yCardinal = (this.entite.getCentreY() - this.entite.getHeight() / 2);
/* 596 */           this.cote = 41;
/*     */         } else {
/* 598 */           this.xCardinal = this.entite.getCentreX();
/* 599 */           this.yCardinal = (this.entite.getCentreY() + this.entite.getHeight() / 2);
/* 600 */           this.cote = 21;
/*     */         }
/*     */       }
/* 603 */       if (this.entite.getCentreY() == this.yCassure) {
/* 604 */         if (this.entite.getCentreX() > this.xCassure) {
/* 605 */           this.xCardinal = this.entite.getX();
/* 606 */           this.yCardinal = (this.entite.getY() + this.entite.getHeight() / 2);
/* 607 */           this.cote = 31;
/*     */         } else {
/* 609 */           this.xCardinal = (this.entite.getX() + this.entite.getWidth());
/* 610 */           this.yCardinal = (this.entite.getY() + this.entite.getHeight() / 2);
/* 611 */           this.cote = 11;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isCible()
/*     */   {
/* 619 */     return this.cible;
/*     */   }
/*     */   
/*     */   public void setCible(boolean cible) {
/* 623 */     this.cible = cible;
/*     */   }
/*     */   
/*     */   public static Color getClLien() {
/* 627 */     return clLien;
/*     */   }
/*     */   
/*     */   public static void setClLien(Color clLien)
/*     */   {
/* 632 */     clLien = clLien;
/*     */   }
/*     */   
/*     */   public IhmEntite getEntite() {
/* 636 */     return this.entite;
/*     */   }
/*     */   
/*     */   public IhmEntite getEntitefils() {
/* 640 */     return this.entitefils;
/*     */   }
/*     */   
/*     */   public void setEntite(IhmEntite entite) {
/* 644 */     this.entite = entite;
/*     */   }
/*     */   
/*     */   public void setEntitefils(IhmEntite entitefils) {
/* 648 */     this.entitefils = entitefils;
/*     */   }
/*     */   
/*     */   public boolean isCardCentre()
/*     */   {
/* 653 */     return this.cardCentre;
/*     */   }
/*     */   
/*     */   public void setCardCentre(boolean cardCentre) {
/* 657 */     this.cardCentre = cardCentre;
/*     */   }
/*     */   
/*     */   public void setCassure(boolean cassure) {
/* 661 */     this.cassure = cassure;
/*     */   }
/*     */   
/*     */   public boolean isCassure() {
/* 665 */     return this.cassure;
/*     */   }
/*     */   
/*     */   public void redimentionnerCassure(int x, int y) {
/* 669 */     this.xCassure = x;
/* 670 */     this.yCassure = y;
/*     */   }
/*     */   
/*     */   public boolean isSelectedCassure(int x, int y) {
/* 674 */     if ((isCassure()) && 
/* 675 */       (Math.abs(x - this.xCassure) <= 4.0D) && (Math.abs(x - this.xCassure) <= 4.0D)) { return true;
/*     */     }
/* 677 */     return false;
/*     */   }
/*     */   
/*     */   public void setxCardinal(double xCardinal) {
/* 681 */     this.xCardinal = xCardinal;
/*     */   }
/*     */   
/*     */   public void setyCassure(double yCassure) {
/* 685 */     this.yCassure = yCassure;
/* 686 */     this.xCassure = Parametres.xcassure;
/*     */   }
/*     */   
/*     */   public double getxCassure() {
/* 690 */     return this.xCassure;
/*     */   }
/*     */   
/*     */   public double getyCassure() {
/* 694 */     return this.yCassure;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 698 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 702 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public boolean isSelect() {
/* 706 */     return this.selected;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmLienHeritage.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */