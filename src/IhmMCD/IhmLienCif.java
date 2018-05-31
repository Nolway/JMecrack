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
/*     */ public class IhmLienCif
/*     */   implements Serializable
/*     */ {
/*     */   private IhmEntite entite;
/*     */   private IhmCIF cif;
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
/*     */   public IhmLienCif(IhmEntite entite, IhmCIF cif)
/*     */   {
/*  33 */     this.entite = entite;
/*  34 */     this.cif = cif;
/*  35 */     this.selected = true;
/*  36 */     this.cassure = false;
/*  37 */     this.xCassure = -1.0D;
/*  38 */     this.yCassure = -1.0D;
/*  39 */     this.cible = false;
/*  40 */     this.nom = "";
/*  41 */     initPointCassure();
/*  42 */     this.cote = 0;
/*  43 */     this.droiteA = -1.0D;
/*  44 */     this.droiteB = -1.0D;
/*  45 */     clLien = FormeInterneMCD.clLienCnt;
/*     */   }
/*     */   
/*     */ 
/*     */   public void initPointCassure()
/*     */   {
/*  51 */     this.xCassure = 0.0D;
/*  52 */     this.yCassure = 0.0D;
/*     */   }
/*     */   
/*     */   public void setSelected(boolean selected) {
/*  56 */     this.selected = selected;
/*     */   }
/*     */   
/*     */   public void paint(Graphics g) {
/*  60 */     carculerXYCardinal();
/*  61 */     if (!isCassure()) {
/*  62 */       if (this.selected) {
/*  63 */         g.setColor(Color.red);
/*  64 */         g.drawLine(this.entite.getCentreX(), this.entite.getCentreY(), this.cif.getCentreX(), this.cif.getCentreY());
/*  65 */         dessinerfleche(g);
/*  66 */         g.drawString(getNom(), (this.entite.getCentreX() + this.cif.getCentreX()) / 2 + 2, (this.entite.getCentreY() + this.cif.getCentreY()) / 2 - 2);
/*     */       } else {
/*  68 */         g.setColor(clLien);
/*  69 */         g.drawLine(this.entite.getCentreX(), this.entite.getCentreY(), this.cif.getCentreX(), this.cif.getCentreY());
/*  70 */         dessinerfleche(g);
/*  71 */         g.drawString(getNom(), (this.entite.getCentreX() + this.cif.getCentreX()) / 2 + 2, (this.entite.getCentreY() + this.cif.getCentreY()) / 2 - 2);
/*     */       }
/*     */     }
/*  74 */     else if (this.selected) {
/*  75 */       g.setColor(Color.red);
/*  76 */       g.drawLine(this.entite.getCentreX(), this.entite.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/*  77 */       dessinerfleche(g);
/*     */       
/*  79 */       g.drawLine(this.cif.getCentreX(), this.cif.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/*  80 */       g.drawString(getNom(), (int)(this.xCassure + 2.0D), (int)this.yCassure);
/*  81 */       g.setColor(Color.black);
/*  82 */       g.setColor(Color.black);
/*  83 */       g.fillRect((int)this.xCassure - 2, (int)this.yCassure - 2, 4, 4);
/*     */     } else {
/*  85 */       g.setColor(clLien);
/*  86 */       g.drawLine(this.entite.getCentreX(), this.entite.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/*  87 */       dessinerfleche(g);
/*  88 */       g.drawLine(this.cif.getCentreX(), this.cif.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/*  89 */       g.drawString(getNom(), (int)(this.xCassure + 2.0D), (int)this.yCassure);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private Point rotation(double x, double y, double tg)
/*     */   {
/*  96 */     Point p = new Point(0, 0);
/*  97 */     double x1 = 0.0D;double y1 = 0.0D;double rac = 0.0D;
/*  98 */     rac = Math.sqrt(Math.pow(tg, 2.0D) + 1.0D);
/*  99 */     x1 = (x - y * tg) / rac;
/* 100 */     y1 = (y + x * tg) / rac;
/* 101 */     p.setX((int)x1);
/* 102 */     p.setY((int)y1);
/* 103 */     return p;
/*     */   }
/*     */   
/*     */   private void dessinerfleche(Graphics g) {
/* 107 */     double a = calculeA();
/* 108 */     double b = calculeB();
/*     */     
/*     */ 
/* 111 */     Point point = new Point(0, 0);
/*     */     
/* 113 */     if (isCassure()) {
/* 114 */       a = calculeACassureEntite();
/* 115 */       b = calculeBCassureEntite();
/*     */     }
/* 117 */     if (isCible()) {
/* 118 */       Color cl = g.getColor();
/* 119 */       int dx = (int)this.xCardinal;
/* 120 */       int dy = (int)this.yCardinal;
/* 121 */       int dec = 0;
/* 122 */       if (this.entite.isOmbre()) { dec = 3;
/*     */       }
/* 124 */       if (this.cote == 1) {
/* 125 */         double x1 = this.entite.getX() + this.entite.getWidth() + 5 + dec;
/* 126 */         double y1 = x1 * a + b;
/* 127 */         double aV = -1.0D / a;
/* 128 */         double bV = y1 - aV * x1;
/* 129 */         int[] x = { dx + dec, (int)((y1 - 5.0D - bV) / aV), (int)((y1 + 5.0D - bV) / aV) };
/* 130 */         int[] y = { dy, (int)(y1 - 5.0D), (int)(y1 + 5.0D) };
/* 131 */         g.setColor(cl);
/* 132 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/* 135 */       if (this.cote == 2) {
/* 136 */         double y1 = dy;
/* 137 */         double x1 = (y1 - b) / a;
/* 138 */         double aV = -1.0D / a;
/* 139 */         double bV = y1 - aV * x1;
/*     */         
/*     */ 
/* 142 */         double yy1 = 5 + dec;double yy2 = 5 + dec;
/* 143 */         double xx1 = -5.0D;double xx2 = 5.0D;
/* 144 */         point = rotation(xx1, yy1, Math.tan(Math.atan(a) + 1.5707963267948966D));
/* 145 */         xx1 = point.getX() + dx;
/* 146 */         yy1 = point.getY() + dy;
/*     */         
/* 148 */         point = rotation(xx2, yy2, Math.tan(Math.atan(a) + 1.5707963267948966D));
/* 149 */         xx2 = point.getX() + dx;
/* 150 */         yy2 = point.getY() + dy;
/*     */         
/* 152 */         int[] x = { dx, (int)xx1, (int)xx2 };
/* 153 */         int[] y = { dy, (int)yy1, (int)yy2 };
/*     */         
/* 155 */         g.setColor(cl);
/* 156 */         g.fillPolygon(x, y, 3);
/*     */       }
/* 158 */       if (this.cote == 3) {
/* 159 */         double x1 = this.entite.getX() - 5;
/* 160 */         double y1 = x1 * a + b;
/*     */         
/* 162 */         double aV = -1.0D / a;
/* 163 */         double bV = y1 - aV * x1;
/*     */         
/* 165 */         int[] x = { dx, (int)((y1 - 5.0D - bV) / aV), (int)((y1 + 5.0D - bV) / aV) };
/* 166 */         int[] y = { dy, (int)(y1 - 5.0D), (int)(y1 + 5.0D) };
/*     */         
/* 168 */         g.setColor(cl);
/* 169 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/* 172 */       if (this.cote == 4)
/*     */       {
/* 174 */         double yy1 = -5.0D;double yy2 = -5.0D;
/* 175 */         double xx1 = -5.0D;double xx2 = 5.0D;
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
/* 186 */         g.setColor(cl);
/* 187 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/* 190 */       if (this.cote == 21) {
/* 191 */         int[] x = { dx, dx - 5, dx + 5 };
/* 192 */         int[] y = { dy, dy + 5 + dec, dy + 5 + dec };
/* 193 */         g.setColor(cl);
/* 194 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/*     */ 
/* 198 */       if (this.cote == 41) {
/* 199 */         int[] x = { dx, dx - 5, dx + 5 };
/* 200 */         int[] y = { dy, dy - 5 - dec, dy - 5 - dec };
/* 201 */         g.setColor(cl);
/* 202 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/*     */ 
/* 206 */       if (this.cote == 31) {
/* 207 */         int[] x = { dx, dx + 5 + dec, dx + 5 + dec };
/* 208 */         int[] y = { dy, dy + 5, dy - 5 };
/* 209 */         g.setColor(cl);
/* 210 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/* 213 */       if (this.cote == 11) {
/* 214 */         int[] x = { dx, dx - 5, dx - 5 };
/* 215 */         int[] y = { dy, dy + 5, dy - 5 };
/* 216 */         g.setColor(cl);
/* 217 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void calculerXYCardinalCentre()
/*     */   {
/* 225 */     if (!isCassure()) {
/* 226 */       this.xCardinal = ((this.entite.getCentreX() + this.cif.getCentreX()) / 2);
/* 227 */       this.yCardinal = ((this.entite.getCentreY() + this.cif.getCentreY()) / 2);
/*     */     } else {
/* 229 */       this.xCardinal = ((int)(this.entite.getCentreX() + this.xCassure) / 2);
/* 230 */       this.yCardinal = ((int)(this.entite.getCentreY() + this.yCassure) / 2);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isSelectedDroite(int x, int y)
/*     */   {
/* 236 */     if (!isCassure()) {
/* 237 */       int h = this.entite.getCentreY() - this.cif.getCentreY();
/* 238 */       int w = this.entite.getCentreX() - this.cif.getCentreX();
/* 239 */       if ((Math.abs(w) < 10) && (
/* 240 */         ((this.entite.getCentreX() >= x) && (this.cif.getCentreX() <= x)) || ((this.entite.getCentreX() <= x) && (this.cif.getCentreX() >= x))))
/*     */       {
/* 242 */         if (((this.entite.getCentreY() >= y) && (this.cif.getCentreY() <= y)) || ((this.entite.getCentreY() <= y) && (this.cif.getCentreY() >= y)))
/*     */         {
/* 244 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 249 */       int h = this.entite.getCentreY() - (int)this.yCassure;
/* 250 */       int w = this.entite.getCentreX() - (int)this.xCassure;
/* 251 */       if ((Math.abs(w) < 10) && (
/* 252 */         ((this.entite.getCentreX() >= x) && ((int)this.xCassure <= x)) || ((this.entite.getCentreX() <= x) && ((int)this.xCassure >= x))))
/*     */       {
/* 254 */         if (((this.entite.getCentreY() >= y) && ((int)this.yCassure <= y)) || ((this.entite.getCentreY() <= y) && ((int)this.yCassure >= y)))
/*     */         {
/* 256 */           return true;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 261 */       h = (int)this.yCassure - this.cif.getCentreY();
/* 262 */       w = (int)this.xCassure - this.cif.getCentreX();
/* 263 */       if ((Math.abs(w) < 10) && (
/* 264 */         (((int)this.xCassure >= x) && (this.cif.getCentreX() <= x)) || (((int)this.xCassure <= x) && (this.cif.getCentreX() >= x))))
/*     */       {
/* 266 */         if ((((int)this.yCassure >= y) && (this.cif.getCentreY() <= y)) || (((int)this.yCassure <= y) && (this.cif.getCentreY() >= y)))
/*     */         {
/* 268 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 275 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isSelected(int x, int y)
/*     */   {
/* 280 */     if (isSelectedDroite(x, y)) {
/* 281 */       this.selected = true;
/* 282 */       return true;
/*     */     }
/* 284 */     if (!isCassure()) {
/* 285 */       double aa = calculeA() * x + calculeB() - y;
/* 286 */       if ((aa < 3.0D) && (aa > -3.0D)) {
/* 287 */         if (isDansLeCarre(x, y)) {
/* 288 */           this.selected = true;
/* 289 */           return true;
/*     */         }
/* 291 */         this.selected = false;
/* 292 */         return false;
/*     */       }
/* 294 */       this.selected = false;
/* 295 */       return false;
/*     */     }
/*     */     
/* 298 */     double aa = calculeACassureEntite() * x + calculeBCassureEntite() - y;
/* 299 */     if ((aa < 3.0D) && (aa > -3.0D) && 
/* 300 */       (isDansLeCarreEntite(x, y))) {
/* 301 */       this.selected = true;
/* 302 */       return true;
/*     */     }
/*     */     
/* 305 */     aa = calculeACassureRelation() * x + calculeBCassureRelation() - y;
/* 306 */     if ((aa < 3.0D) && (aa > -3.0D) && 
/* 307 */       (isDansLeCarreRelation(x, y))) {
/* 308 */       this.selected = true;
/* 309 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 313 */     this.selected = false;
/* 314 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarre(int x, int y)
/*     */   {
/* 319 */     if (this.entite.getCentreX() != this.cif.getCentreX()) {
/* 320 */       if ((this.entite.getCentreX() <= x) && (this.cif.getCentreX() >= x)) return true;
/* 321 */       if ((this.entite.getCentreX() >= x) && (this.cif.getCentreX() <= x)) return true;
/*     */     } else {
/* 323 */       if ((this.entite.getCentreY() <= y) && (this.cif.getCentreY() >= y)) return true;
/* 324 */       if ((this.entite.getCentreY() >= x) && (this.cif.getCentreY() <= y)) return true;
/*     */     }
/* 326 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarreEntite(int x, int y) {
/* 330 */     if (this.entite.getCentreX() != this.xCassure) {
/* 331 */       if ((this.entite.getCentreX() <= x) && (this.xCassure >= x)) return true;
/* 332 */       if ((this.entite.getCentreX() >= x) && (this.xCassure <= x)) return true;
/*     */     } else {
/* 334 */       if ((this.entite.getCentreY() <= y) && (this.yCassure >= y)) return true;
/* 335 */       if ((this.entite.getCentreY() >= x) && (this.yCassure <= y)) return true;
/*     */     }
/* 337 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarreRelation(int x, int y) {
/* 341 */     if (this.xCassure != this.cif.getCentreX()) {
/* 342 */       if ((this.xCassure <= x) && (this.cif.getCentreX() >= x)) return true;
/* 343 */       if ((this.xCassure >= x) && (this.cif.getCentreX() <= x)) return true;
/*     */     } else {
/* 345 */       if ((this.yCassure <= y) && (this.cif.getCentreY() >= y)) return true;
/* 346 */       if ((this.yCassure >= x) && (this.cif.getCentreY() <= y)) return true;
/*     */     }
/* 348 */     return false;
/*     */   }
/*     */   
/*     */   private double calculeA() {
/* 352 */     if (this.entite.getCentreX() - this.cif.getCentreX() != 0) {
/* 353 */       double n = (this.entite.getCentreY() - this.cif.getCentreY()) / (this.entite.getCentreX() - this.cif.getCentreX());
/* 354 */       return n;
/*     */     }
/* 356 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeACassureRelation() {
/* 360 */     if (this.xCassure - this.cif.getCentreX() != 0.0D) {
/* 361 */       double n = (this.yCassure - this.cif.getCentreY()) / (this.xCassure - this.cif.getCentreX());
/* 362 */       return n;
/*     */     }
/* 364 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeACassureEntite() {
/* 368 */     if (this.entite.getCentreX() - this.xCassure != 0.0D) {
/* 369 */       double n = (this.entite.getCentreY() - this.yCassure) / (this.entite.getCentreX() - this.xCassure);
/* 370 */       return n;
/*     */     }
/* 372 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeB() {
/* 376 */     if (this.entite.getCentreX() - this.cif.getCentreX() != 0) {
/* 377 */       double n = this.entite.getCentreY() - calculeA() * this.entite.getCentreX();
/* 378 */       return n;
/*     */     }
/* 380 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeBCassureEntite() {
/* 384 */     if (this.entite.getCentreX() - this.xCassure != 0.0D) {
/* 385 */       double n = this.entite.getCentreY() - calculeACassureEntite() * this.entite.getCentreX();
/* 386 */       return n;
/*     */     }
/* 388 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeBCassureRelation() {
/* 392 */     if (this.xCassure - this.cif.getCentreX() != 0.0D) {
/* 393 */       double n = this.yCassure - calculeACassureRelation() * this.xCassure;
/* 394 */       return n;
/*     */     }
/* 396 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double distance(int x, int y, int x1, int y1) {
/* 400 */     return Math.sqrt(Math.pow(x - x1, 2.0D) + Math.pow(y - y1, 2.0D));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void carculerXYCardinal()
/*     */   {
/* 409 */     if (!isCassure()) {
/* 410 */       double aaa = calculeA();
/* 411 */       double bbb = calculeB();
/* 412 */       if ((this.entite.getCentreX() < this.cif.getCentreX()) && (this.entite.getCentreY() < this.cif.getCentreY())) {
/* 413 */         double yInter1 = aaa * (this.entite.getX() + this.entite.getWidth()) + bbb;
/* 414 */         double xInter1 = this.entite.getX() + this.entite.getWidth();
/*     */         
/* 416 */         double yInter2 = this.entite.getY() + this.entite.getHeight();
/* 417 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 419 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 420 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 421 */         this.xCardinal = xInter1;
/* 422 */         this.yCardinal = yInter1;
/* 423 */         this.cote = 1;
/* 424 */         if (dist2 < dist1) {
/* 425 */           this.xCardinal = xInter2;
/* 426 */           this.yCardinal = yInter2;
/* 427 */           this.cote = 2;
/*     */         }
/*     */       }
/* 430 */       if ((this.entite.getCentreX() > this.cif.getCentreX()) && (this.entite.getCentreY() < this.cif.getCentreY())) {
/* 431 */         double yInter1 = aaa * this.entite.getX() + bbb;
/* 432 */         double xInter1 = this.entite.getX();
/*     */         
/* 434 */         double yInter2 = this.entite.getY() + this.entite.getHeight();
/* 435 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 437 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 438 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 439 */         this.xCardinal = xInter1;
/* 440 */         this.yCardinal = yInter1;
/* 441 */         this.cote = 3;
/* 442 */         if (dist2 < dist1) {
/* 443 */           this.xCardinal = xInter2;
/* 444 */           this.yCardinal = yInter2;
/* 445 */           this.cote = 2;
/*     */         }
/*     */       }
/* 448 */       if ((this.entite.getCentreX() > this.cif.getCentreX()) && (this.entite.getCentreY() > this.cif.getCentreY())) {
/* 449 */         double yInter1 = aaa * this.entite.getX() + bbb;
/* 450 */         double xInter1 = this.entite.getX();
/*     */         
/* 452 */         double yInter2 = this.entite.getY();
/* 453 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 455 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 456 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 457 */         this.xCardinal = xInter1;
/* 458 */         this.yCardinal = yInter1;
/* 459 */         this.cote = 3;
/* 460 */         if (dist2 < dist1) {
/* 461 */           this.xCardinal = xInter2;
/* 462 */           this.yCardinal = yInter2;
/* 463 */           this.cote = 4;
/*     */         }
/*     */       }
/* 466 */       if ((this.entite.getCentreX() < this.cif.getCentreX()) && (this.entite.getCentreY() > this.cif.getCentreY())) {
/* 467 */         double yInter1 = aaa * (this.entite.getX() + this.entite.getWidth()) + bbb;
/* 468 */         double xInter1 = this.entite.getX() + this.entite.getWidth();
/*     */         
/* 470 */         double yInter2 = this.entite.getY();
/* 471 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 473 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 474 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 475 */         this.xCardinal = xInter1;
/* 476 */         this.yCardinal = yInter1;
/* 477 */         this.cote = 1;
/* 478 */         if (dist2 < dist1) {
/* 479 */           this.xCardinal = xInter2;
/* 480 */           this.yCardinal = yInter2;
/* 481 */           this.cote = 4;
/*     */         }
/*     */       }
/* 484 */       if (this.entite.getCentreX() == this.cif.getCentreX()) {
/* 485 */         if (this.entite.getCentreY() > this.cif.getCentreY()) {
/* 486 */           this.xCardinal = this.entite.getCentreX();
/* 487 */           this.yCardinal = (this.entite.getCentreY() - this.entite.getHeight() / 2);
/* 488 */           this.cote = 41;
/*     */         } else {
/* 490 */           this.xCardinal = this.entite.getCentreX();
/* 491 */           this.yCardinal = (this.entite.getCentreY() + this.entite.getHeight() / 2);
/* 492 */           this.cote = 21;
/*     */         }
/*     */       }
/* 495 */       if (this.entite.getCentreY() == this.cif.getCentreY()) {
/* 496 */         if (this.entite.getCentreX() > this.cif.getCentreX()) {
/* 497 */           this.xCardinal = this.entite.getX();
/* 498 */           this.yCardinal = (this.entite.getY() + this.entite.getHeight() / 2);
/* 499 */           this.cote = 11;
/*     */         } else {
/* 501 */           this.xCardinal = (this.entite.getX() + this.entite.getWidth());
/* 502 */           this.yCardinal = (this.entite.getY() + this.entite.getHeight() / 2);
/* 503 */           this.cote = 31;
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 508 */       double aaa = calculeACassureEntite();
/* 509 */       double bbb = calculeBCassureEntite();
/* 510 */       if ((this.entite.getCentreX() < this.xCassure) && (this.entite.getCentreY() < this.yCassure)) {
/* 511 */         double yInter1 = aaa * (this.entite.getX() + this.entite.getWidth()) + bbb;
/* 512 */         double xInter1 = this.entite.getX() + this.entite.getWidth();
/*     */         
/* 514 */         double yInter2 = this.entite.getY() + this.entite.getHeight();
/* 515 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 517 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 518 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 519 */         this.xCardinal = xInter1;
/* 520 */         this.yCardinal = yInter1;
/* 521 */         this.cote = 1;
/* 522 */         if (dist2 < dist1) {
/* 523 */           this.xCardinal = xInter2;
/* 524 */           this.yCardinal = yInter2;
/* 525 */           this.cote = 2;
/*     */         }
/*     */       }
/* 528 */       if ((this.entite.getCentreX() > this.xCassure) && (this.entite.getCentreY() < this.yCassure)) {
/* 529 */         double yInter1 = aaa * this.entite.getX() + bbb;
/* 530 */         double xInter1 = this.entite.getX();
/*     */         
/* 532 */         double yInter2 = this.entite.getY() + this.entite.getHeight();
/* 533 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 535 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 536 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 537 */         this.xCardinal = xInter1;
/* 538 */         this.yCardinal = yInter1;
/* 539 */         this.cote = 3;
/* 540 */         if (dist2 < dist1) {
/* 541 */           this.xCardinal = xInter2;
/* 542 */           this.yCardinal = yInter2;
/* 543 */           this.cote = 2;
/*     */         }
/*     */       }
/* 546 */       if ((this.entite.getCentreX() > this.xCassure) && (this.entite.getCentreY() > this.yCassure)) {
/* 547 */         double yInter1 = aaa * this.entite.getX() + bbb;
/* 548 */         double xInter1 = this.entite.getX();
/*     */         
/* 550 */         double yInter2 = this.entite.getY();
/* 551 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 553 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 554 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 555 */         this.xCardinal = xInter1;
/* 556 */         this.yCardinal = yInter1;
/* 557 */         this.cote = 3;
/* 558 */         if (dist2 < dist1) {
/* 559 */           this.xCardinal = xInter2;
/* 560 */           this.yCardinal = yInter2;
/* 561 */           this.cote = 4;
/*     */         }
/*     */       }
/* 564 */       if ((this.entite.getCentreX() < this.xCassure) && (this.entite.getCentreY() > this.yCassure)) {
/* 565 */         double yInter1 = aaa * (this.entite.getX() + this.entite.getWidth()) + bbb;
/* 566 */         double xInter1 = this.entite.getX() + this.entite.getWidth();
/*     */         
/* 568 */         double yInter2 = this.entite.getY();
/* 569 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 571 */         double dist1 = distance((int)xInter1, (int)yInter1, this.entite.getCentreX(), this.entite.getCentreY());
/* 572 */         double dist2 = distance((int)xInter2, (int)yInter2, this.entite.getCentreX(), this.entite.getCentreY());
/* 573 */         this.xCardinal = xInter1;
/* 574 */         this.yCardinal = yInter1;
/* 575 */         this.cote = 1;
/* 576 */         if (dist2 < dist1) {
/* 577 */           this.xCardinal = xInter2;
/* 578 */           this.yCardinal = yInter2;
/* 579 */           this.cote = 4;
/*     */         }
/*     */       }
/* 582 */       if (this.entite.getCentreX() == this.xCassure) {
/* 583 */         if (this.entite.getCentreY() > this.yCassure) {
/* 584 */           this.xCardinal = this.entite.getCentreX();
/* 585 */           this.yCardinal = (this.entite.getCentreY() - this.entite.getHeight() / 2);
/* 586 */           this.cote = 41;
/*     */         } else {
/* 588 */           this.xCardinal = this.entite.getCentreX();
/* 589 */           this.yCardinal = (this.entite.getCentreY() + this.entite.getHeight() / 2);
/* 590 */           this.cote = 21;
/*     */         }
/*     */       }
/* 593 */       if (this.entite.getCentreY() == this.yCassure) {
/* 594 */         if (this.entite.getCentreX() > this.xCassure) {
/* 595 */           this.xCardinal = this.entite.getX();
/* 596 */           this.yCardinal = (this.entite.getY() + this.entite.getHeight() / 2);
/* 597 */           this.cote = 11;
/*     */         } else {
/* 599 */           this.xCardinal = (this.entite.getX() + this.entite.getWidth());
/* 600 */           this.yCardinal = (this.entite.getY() + this.entite.getHeight() / 2);
/* 601 */           this.cote = 31;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isCible()
/*     */   {
/* 610 */     return this.cible;
/*     */   }
/*     */   
/*     */   public void setCible(boolean cible) {
/* 614 */     this.cible = cible;
/*     */   }
/*     */   
/*     */   public static Color getClLien() {
/* 618 */     return clLien;
/*     */   }
/*     */   
/*     */ 
/*     */   public static void setClLien(Color clLien)
/*     */   {
/* 624 */     clLien = clLien;
/*     */   }
/*     */   
/*     */   public IhmEntite getEntite() {
/* 628 */     return this.entite;
/*     */   }
/*     */   
/*     */   public IhmCIF getCif() {
/* 632 */     return this.cif;
/*     */   }
/*     */   
/*     */   public boolean isCardCentre() {
/* 636 */     return this.cardCentre;
/*     */   }
/*     */   
/*     */   public void setCardCentre(boolean cardCentre) {
/* 640 */     this.cardCentre = cardCentre;
/*     */   }
/*     */   
/*     */   public void setCassure(boolean cassure) {
/* 644 */     this.cassure = cassure;
/*     */   }
/*     */   
/*     */   public boolean isCassure() {
/* 648 */     return this.cassure;
/*     */   }
/*     */   
/*     */   public void redimentionnerCassure(int x, int y) {
/* 652 */     if (x <= 0) this.xCassure = 0.0D; else
/* 653 */       this.xCassure = x;
/* 654 */     if (y <= 0) this.yCassure = 0.0D; else {
/* 655 */       this.yCassure = y;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isSelectedCassure(int x, int y)
/*     */   {
/* 661 */     if ((isCassure()) && 
/* 662 */       (Math.abs(x - this.xCassure) <= 4.0D) && (Math.abs(x - this.xCassure) <= 4.0D)) { return true;
/*     */     }
/* 664 */     return false;
/*     */   }
/*     */   
/*     */   public void setxCardinal(double xCardinal) {
/* 668 */     this.xCardinal = xCardinal;
/*     */   }
/*     */   
/*     */   public void setyCassure(double yCassure)
/*     */   {
/* 673 */     this.yCassure = yCassure;
/* 674 */     this.xCassure = Parametres.xcassure;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getxCassure()
/*     */   {
/* 682 */     return this.xCassure;
/*     */   }
/*     */   
/*     */   public double getyCassure() {
/* 686 */     return this.yCassure;
/*     */   }
/*     */   
/*     */   public String getNom() {
/* 690 */     return this.nom;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 694 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public boolean isSelect() {
/* 698 */     return this.selected;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmLienCif.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */