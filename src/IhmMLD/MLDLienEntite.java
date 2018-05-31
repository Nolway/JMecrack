/*     */ package IhmMLD;
/*     */ 
/*     */ import IhmMCD.Point;
/*     */ import ihm.FormeInterneMCD;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MLDLienEntite
/*     */   implements Serializable
/*     */ {
/*     */   private MLDEntite relation;
/*     */   private MLDEntite entite;
/*     */   private boolean fleche;
/*     */   private boolean selected;
/*     */   private boolean cassure;
/*     */   private double xCardinal;
/*     */   private double yCardinal;
/*     */   private int cote;
/*     */   private double xCassure;
/*     */   private double yCassure;
/*     */   
/*     */   public MLDLienEntite(MLDEntite relation, MLDEntite entite, boolean fleche)
/*     */   {
/*  31 */     this.relation = entite;
/*  32 */     this.entite = relation;
/*  33 */     this.fleche = fleche;
/*  34 */     this.selected = false;
/*  35 */     this.cassure = false;
/*     */   }
/*     */   
/*     */   public void paint(Graphics g)
/*     */   {
/*  40 */     calculerXYCardinal();
/*  41 */     if (!isCassure()) {
/*  42 */       if (this.selected) {
/*  43 */         g.setColor(Color.red);
/*  44 */         g.drawLine(this.entite.getCentreX(), this.entite.getCentreY(), this.relation.getCentreX(), this.relation.getCentreY());
/*     */       } else {
/*  46 */         g.setColor(FormeInterneMCD.clLien);
/*     */         
/*  48 */         g.drawLine(this.entite.getCentreX(), this.entite.getCentreY(), this.relation.getCentreX(), this.relation.getCentreY());
/*     */       }
/*  50 */       if (isFleche()) dessinerfleche(g);
/*     */     } else {
/*  52 */       if (this.selected) {
/*  53 */         g.setColor(Color.red);
/*  54 */         g.drawLine(this.entite.getCentreX(), this.entite.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/*  55 */         g.drawLine(this.relation.getCentreX(), this.relation.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/*     */         
/*  57 */         g.fillRect((int)this.xCassure - 2, (int)this.yCassure - 2, 4, 4);
/*     */       } else {
/*  59 */         g.setColor(FormeInterneMCD.clLien);
/*  60 */         g.drawLine(this.entite.getCentreX(), this.entite.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/*  61 */         g.drawLine(this.relation.getCentreX(), this.relation.getCentreY(), (int)this.xCassure, (int)this.yCassure);
/*     */       }
/*     */       
/*     */ 
/*  65 */       dessinerfleche(g);
/*     */     }
/*     */   }
/*     */   
/*     */   private Point rotation(double x, double y, double tg) {
/*  70 */     Point p = new Point(0, 0);
/*  71 */     double x1 = 0.0D;double y1 = 0.0D;double rac = 0.0D;
/*  72 */     rac = Math.sqrt(Math.pow(tg, 2.0D) + 1.0D);
/*  73 */     x1 = (x - y * tg) / rac;
/*  74 */     y1 = (y + x * tg) / rac;
/*  75 */     p.setX((int)x1);
/*  76 */     p.setY((int)y1);
/*  77 */     return p;
/*     */   }
/*     */   
/*     */   private void dessinerfleche(Graphics g) {
/*  81 */     double a = calculeA();
/*  82 */     double b = calculeB();
/*     */     
/*     */ 
/*  85 */     Point point = new Point(0, 0);
/*  86 */     if (isCassure()) {
/*  87 */       a = calculeACassureEntite();
/*  88 */       b = calculeBCassureEntite();
/*     */     }
/*  90 */     if (isFleche()) {
/*  91 */       Color cl = g.getColor();
/*  92 */       int dx = (int)this.xCardinal;
/*  93 */       int dy = (int)this.yCardinal;
/*  94 */       int dec = 0;
/*  95 */       if (this.relation.isOmbre()) { dec = 3;
/*     */       }
/*  97 */       if (this.cote == 1)
/*     */       {
/*     */ 
/* 100 */         double x1 = this.relation.getX() + this.relation.getWidth() + 7 + dec;
/* 101 */         double y1 = x1 * a + b;
/* 102 */         double aV = -1.0D / a;
/* 103 */         double bV = y1 - aV * x1;
/* 104 */         int[] x = { dx + dec, (int)((y1 - 5.0D - bV) / aV), (int)((y1 + 5.0D - bV) / aV) };
/* 105 */         int[] y = { dy, (int)(y1 - 5.0D), (int)(y1 + 5.0D) };
/* 106 */         g.setColor(cl);
/* 107 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/*     */ 
/* 111 */       if (this.cote == 2) {
/* 112 */         double y1 = dy;
/* 113 */         double x1 = (y1 - b) / a;
/* 114 */         double aV = -1.0D / a;
/* 115 */         double bV = y1 - aV * x1;
/*     */         
/*     */ 
/* 118 */         double yy1 = 7 + dec;double yy2 = 7 + dec;
/* 119 */         double xx1 = -5.0D;double xx2 = 5.0D;
/* 120 */         point = rotation(xx1, yy1, Math.tan(Math.atan(a) + 1.5707963267948966D));
/* 121 */         xx1 = point.getX() + dx;
/* 122 */         yy1 = point.getY() + dy;
/*     */         
/* 124 */         point = rotation(xx2, yy2, Math.tan(Math.atan(a) + 1.5707963267948966D));
/* 125 */         xx2 = point.getX() + dx;
/* 126 */         yy2 = point.getY() + dy;
/*     */         
/* 128 */         int[] x = { dx, (int)xx1, (int)xx2 };
/* 129 */         int[] y = { dy, (int)yy1, (int)yy2 };
/*     */         
/* 131 */         g.setColor(cl);
/* 132 */         g.fillPolygon(x, y, 3);
/*     */       }
/* 134 */       if (this.cote == 3) {
/* 135 */         double x1 = this.relation.getX() - 7;
/* 136 */         double y1 = x1 * a + b;
/*     */         
/* 138 */         double aV = -1.0D / a;
/* 139 */         double bV = y1 - aV * x1;
/*     */         
/* 141 */         int[] x = { dx, (int)((y1 - 5.0D - bV) / aV), (int)((y1 + 5.0D - bV) / aV) };
/* 142 */         int[] y = { dy, (int)(y1 - 5.0D), (int)(y1 + 5.0D) };
/*     */         
/* 144 */         g.setColor(cl);
/* 145 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/*     */ 
/* 149 */       if (this.cote == 4)
/*     */       {
/* 151 */         double yy1 = -7.0D;double yy2 = -7.0D;
/* 152 */         double xx1 = -5.0D;double xx2 = 5.0D;
/* 153 */         point = rotation(xx1, yy1, Math.tan(Math.atan(a) + 1.5707963267948966D));
/* 154 */         xx1 = point.getX() + dx;
/* 155 */         yy1 = point.getY() + dy;
/*     */         
/* 157 */         point = rotation(xx2, yy2, Math.tan(Math.atan(a) + 1.5707963267948966D));
/* 158 */         xx2 = point.getX() + dx;
/* 159 */         yy2 = point.getY() + dy;
/*     */         
/* 161 */         int[] x = { dx, (int)xx1, (int)xx2 };
/* 162 */         int[] y = { dy, (int)yy1, (int)yy2 };
/* 163 */         g.setColor(cl);
/* 164 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/* 167 */       if (this.cote == 21) {
/* 168 */         int[] x = { dx, dx - 5, dx + 5 };
/* 169 */         int[] y = { dy, dy + 5 + dec, dy + 5 + dec };
/* 170 */         g.setColor(cl);
/* 171 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/*     */ 
/* 175 */       if (this.cote == 41) {
/* 176 */         int[] x = { dx, dx - 5, dx + 5 };
/* 177 */         int[] y = { dy, dy - 5 - dec, dy - 5 - dec };
/* 178 */         g.setColor(cl);
/* 179 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/*     */ 
/* 183 */       if (this.cote == 31) {
/* 184 */         int[] x = { dx, dx - 5, dx - 5 };
/* 185 */         int[] y = { dy, dy + 5, dy - 5 };
/* 186 */         g.setColor(cl);
/* 187 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/* 190 */       if (this.cote == 11) {
/* 191 */         int[] x = { dx, dx + 5 + dec, dx + 5 + dec };
/* 192 */         int[] y = { dy, dy + 5, dy - 5 };
/* 193 */         g.setColor(cl);
/* 194 */         g.fillPolygon(x, y, 3);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private double distance(int x, int y, int x1, int y1)
/*     */   {
/* 202 */     return Math.sqrt(Math.pow(x - x1, 2.0D) + Math.pow(y - y1, 2.0D));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void calculerXYCardinal()
/*     */   {
/* 211 */     if (!isCassure()) {
/* 212 */       double aaa = calculeA();
/* 213 */       double bbb = calculeB();
/* 214 */       if ((this.relation.getCentreX() < this.entite.getCentreX()) && (this.relation.getCentreY() < this.entite.getCentreY())) {
/* 215 */         double yInter1 = aaa * (this.relation.getX() + this.relation.getWidth()) + bbb;
/* 216 */         double xInter1 = this.relation.getX() + this.relation.getWidth();
/*     */         
/* 218 */         double yInter2 = this.relation.getY() + this.relation.getHeight();
/* 219 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 221 */         double dist1 = distance((int)xInter1, (int)yInter1, this.relation.getCentreX(), this.relation.getCentreY());
/* 222 */         double dist2 = distance((int)xInter2, (int)yInter2, this.relation.getCentreX(), this.relation.getCentreY());
/* 223 */         this.xCardinal = xInter1;
/* 224 */         this.yCardinal = yInter1;
/* 225 */         this.cote = 1;
/* 226 */         if (dist2 < dist1) {
/* 227 */           this.xCardinal = xInter2;
/* 228 */           this.yCardinal = yInter2;
/* 229 */           this.cote = 2;
/*     */         }
/*     */       }
/* 232 */       if ((this.relation.getCentreX() > this.entite.getCentreX()) && (this.relation.getCentreY() < this.entite.getCentreY())) {
/* 233 */         double yInter1 = aaa * this.relation.getX() + bbb;
/* 234 */         double xInter1 = this.relation.getX();
/*     */         
/* 236 */         double yInter2 = this.relation.getY() + this.relation.getHeight();
/* 237 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 239 */         double dist1 = distance((int)xInter1, (int)yInter1, this.relation.getCentreX(), this.relation.getCentreY());
/* 240 */         double dist2 = distance((int)xInter2, (int)yInter2, this.relation.getCentreX(), this.relation.getCentreY());
/* 241 */         this.xCardinal = xInter1;
/* 242 */         this.yCardinal = yInter1;
/* 243 */         this.cote = 3;
/* 244 */         if (dist2 < dist1) {
/* 245 */           this.xCardinal = xInter2;
/* 246 */           this.yCardinal = yInter2;
/* 247 */           this.cote = 2;
/*     */         }
/*     */       }
/* 250 */       if ((this.relation.getCentreX() > this.entite.getCentreX()) && (this.relation.getCentreY() > this.entite.getCentreY())) {
/* 251 */         double yInter1 = aaa * this.relation.getX() + bbb;
/* 252 */         double xInter1 = this.relation.getX();
/*     */         
/* 254 */         double yInter2 = this.relation.getY();
/* 255 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 257 */         double dist1 = distance((int)xInter1, (int)yInter1, this.relation.getCentreX(), this.relation.getCentreY());
/* 258 */         double dist2 = distance((int)xInter2, (int)yInter2, this.relation.getCentreX(), this.relation.getCentreY());
/* 259 */         this.xCardinal = xInter1;
/* 260 */         this.yCardinal = yInter1;
/* 261 */         this.cote = 3;
/* 262 */         if (dist2 < dist1) {
/* 263 */           this.xCardinal = xInter2;
/* 264 */           this.yCardinal = yInter2;
/* 265 */           this.cote = 4;
/*     */         }
/*     */       }
/* 268 */       if ((this.relation.getCentreX() < this.entite.getCentreX()) && (this.relation.getCentreY() > this.entite.getCentreY())) {
/* 269 */         double yInter1 = aaa * (this.relation.getX() + this.relation.getWidth()) + bbb;
/* 270 */         double xInter1 = this.relation.getX() + this.relation.getWidth();
/*     */         
/* 272 */         double yInter2 = this.relation.getY();
/* 273 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 275 */         double dist1 = distance((int)xInter1, (int)yInter1, this.relation.getCentreX(), this.relation.getCentreY());
/* 276 */         double dist2 = distance((int)xInter2, (int)yInter2, this.relation.getCentreX(), this.relation.getCentreY());
/* 277 */         this.xCardinal = xInter1;
/* 278 */         this.yCardinal = yInter1;
/* 279 */         this.cote = 1;
/* 280 */         if (dist2 < dist1) {
/* 281 */           this.xCardinal = xInter2;
/* 282 */           this.yCardinal = yInter2;
/* 283 */           this.cote = 4;
/*     */         }
/*     */       }
/* 286 */       if (this.relation.getCentreX() == this.entite.getCentreX()) {
/* 287 */         if (this.relation.getCentreY() > this.entite.getCentreY()) {
/* 288 */           this.xCardinal = this.relation.getCentreX();
/* 289 */           this.yCardinal = (this.relation.getCentreY() - this.relation.getHeight() / 2);
/* 290 */           this.cote = 41;
/*     */         } else {
/* 292 */           this.xCardinal = this.relation.getCentreX();
/* 293 */           this.yCardinal = (this.relation.getCentreY() + this.relation.getHeight() / 2);
/* 294 */           this.cote = 21;
/*     */         }
/*     */       }
/* 297 */       if (this.relation.getCentreY() == this.entite.getCentreY()) {
/* 298 */         if (this.relation.getCentreX() > this.entite.getCentreX()) {
/* 299 */           this.xCardinal = this.relation.getX();
/* 300 */           this.yCardinal = (this.relation.getY() + this.relation.getHeight() / 2);
/* 301 */           this.cote = 31;
/*     */         }
/*     */         else {
/* 304 */           this.xCardinal = (this.relation.getX() + this.relation.getWidth());
/* 305 */           this.yCardinal = (this.relation.getY() + this.relation.getHeight() / 2);
/* 306 */           this.cote = 11;
/*     */         }
/*     */       }
/*     */     } else {
/* 310 */       double aaa = calculeACassureEntite();
/* 311 */       double bbb = calculeBCassureEntite();
/* 312 */       if ((this.relation.getCentreX() < this.xCassure) && (this.relation.getCentreY() < this.yCassure)) {
/* 313 */         double yInter1 = aaa * (this.relation.getX() + this.relation.getWidth()) + bbb;
/* 314 */         double xInter1 = this.relation.getX() + this.relation.getWidth();
/*     */         
/* 316 */         double yInter2 = this.relation.getY() + this.relation.getHeight();
/* 317 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 319 */         double dist1 = distance((int)xInter1, (int)yInter1, this.relation.getCentreX(), this.relation.getCentreY());
/* 320 */         double dist2 = distance((int)xInter2, (int)yInter2, this.relation.getCentreX(), this.relation.getCentreY());
/* 321 */         this.xCardinal = xInter1;
/* 322 */         this.yCardinal = yInter1;
/* 323 */         this.cote = 1;
/* 324 */         if (dist2 < dist1) {
/* 325 */           this.xCardinal = xInter2;
/* 326 */           this.yCardinal = yInter2;
/* 327 */           this.cote = 2;
/*     */         }
/*     */       }
/* 330 */       if ((this.relation.getCentreX() > this.xCassure) && (this.relation.getCentreY() < this.yCassure)) {
/* 331 */         double yInter1 = aaa * this.relation.getX() + bbb;
/* 332 */         double xInter1 = this.relation.getX();
/*     */         
/* 334 */         double yInter2 = this.relation.getY() + this.relation.getHeight();
/* 335 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 337 */         double dist1 = distance((int)xInter1, (int)yInter1, this.relation.getCentreX(), this.relation.getCentreY());
/* 338 */         double dist2 = distance((int)xInter2, (int)yInter2, this.relation.getCentreX(), this.relation.getCentreY());
/* 339 */         this.xCardinal = xInter1;
/* 340 */         this.yCardinal = yInter1;
/* 341 */         this.cote = 3;
/* 342 */         if (dist2 < dist1) {
/* 343 */           this.xCardinal = xInter2;
/* 344 */           this.yCardinal = yInter2;
/* 345 */           this.cote = 2;
/*     */         }
/*     */       }
/* 348 */       if ((this.relation.getCentreX() > this.xCassure) && (this.relation.getCentreY() > this.yCassure)) {
/* 349 */         double yInter1 = aaa * this.relation.getX() + bbb;
/* 350 */         double xInter1 = this.relation.getX();
/*     */         
/* 352 */         double yInter2 = this.relation.getY();
/* 353 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 355 */         double dist1 = distance((int)xInter1, (int)yInter1, this.relation.getCentreX(), this.relation.getCentreY());
/* 356 */         double dist2 = distance((int)xInter2, (int)yInter2, this.relation.getCentreX(), this.relation.getCentreY());
/* 357 */         this.xCardinal = xInter1;
/* 358 */         this.yCardinal = yInter1;
/* 359 */         this.cote = 3;
/* 360 */         if (dist2 < dist1) {
/* 361 */           this.xCardinal = xInter2;
/* 362 */           this.yCardinal = yInter2;
/* 363 */           this.cote = 4;
/*     */         }
/*     */       }
/* 366 */       if ((this.relation.getCentreX() < this.xCassure) && (this.relation.getCentreY() > this.yCassure)) {
/* 367 */         double yInter1 = aaa * (this.relation.getX() + this.relation.getWidth()) + bbb;
/* 368 */         double xInter1 = this.relation.getX() + this.relation.getWidth();
/*     */         
/* 370 */         double yInter2 = this.relation.getY();
/* 371 */         double xInter2 = (yInter2 - bbb) / aaa;
/*     */         
/* 373 */         double dist1 = distance((int)xInter1, (int)yInter1, this.relation.getCentreX(), this.relation.getCentreY());
/* 374 */         double dist2 = distance((int)xInter2, (int)yInter2, this.relation.getCentreX(), this.relation.getCentreY());
/* 375 */         this.xCardinal = xInter1;
/* 376 */         this.yCardinal = yInter1;
/* 377 */         this.cote = 1;
/* 378 */         if (dist2 < dist1) {
/* 379 */           this.xCardinal = xInter2;
/* 380 */           this.yCardinal = yInter2;
/* 381 */           this.cote = 4;
/*     */         }
/*     */       }
/* 384 */       if (this.relation.getCentreX() == this.xCassure) {
/* 385 */         if (this.relation.getCentreY() > this.yCassure) {
/* 386 */           this.xCardinal = this.relation.getCentreX();
/* 387 */           this.yCardinal = (this.relation.getCentreY() - this.relation.getHeight() / 2);
/* 388 */           this.cote = 41;
/*     */         } else {
/* 390 */           this.xCardinal = this.relation.getCentreX();
/* 391 */           this.yCardinal = (this.relation.getCentreY() + this.relation.getHeight() / 2);
/* 392 */           this.cote = 21;
/*     */         }
/*     */       }
/* 395 */       if (this.relation.getCentreY() == this.yCassure) {
/* 396 */         if (this.relation.getCentreX() > this.xCassure) {
/* 397 */           this.xCardinal = this.relation.getX();
/* 398 */           this.yCardinal = (this.relation.getY() + this.relation.getHeight() / 2);
/* 399 */           this.cote = 31;
/*     */         } else {
/* 401 */           this.xCardinal = (this.relation.getX() + this.relation.getWidth());
/* 402 */           this.yCardinal = (this.relation.getY() + this.relation.getHeight() / 2);
/* 403 */           this.cote = 11;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void setEntite(MLDEntite entite)
/*     */   {
/* 412 */     this.entite = entite;
/*     */   }
/*     */   
/*     */   public void setRelation(MLDEntite relation) {
/* 416 */     this.relation = relation;
/*     */   }
/*     */   
/*     */   public MLDEntite getEntite() {
/* 420 */     return this.entite;
/*     */   }
/*     */   
/*     */   public MLDEntite getRelation() {
/* 424 */     return this.relation;
/*     */   }
/*     */   
/*     */   public void setSelected(boolean selected) {
/* 428 */     this.selected = selected;
/*     */   }
/*     */   
/*     */   public boolean isSelected() {
/* 432 */     return this.selected;
/*     */   }
/*     */   
/*     */   public boolean isCassure() {
/* 436 */     return this.cassure;
/*     */   }
/*     */   
/*     */   public void setCassure(boolean cassure) {
/* 440 */     this.cassure = cassure;
/*     */   }
/*     */   
/*     */   public void initPointCassure() {
/* 444 */     this.xCassure = ((this.entite.getCentreX() + this.relation.getCentreX()) / 2);
/* 445 */     this.yCassure = ((this.entite.getCentreY() + this.relation.getCentreY()) / 2);
/*     */   }
/*     */   
/*     */   public void redimentionnerCassure(int x, int y) {
/* 449 */     this.xCassure = x;
/* 450 */     this.yCassure = y;
/*     */   }
/*     */   
/*     */   public double getxCassure() {
/* 454 */     return this.xCassure;
/*     */   }
/*     */   
/*     */   public double getyCassure() {
/* 458 */     return this.yCassure;
/*     */   }
/*     */   
/*     */   private boolean isSelectedDroite(int x, int y)
/*     */   {
/* 463 */     if (!isCassure()) {
/* 464 */       int h = this.entite.getCentreY() - this.relation.getCentreY();
/* 465 */       int w = this.entite.getCentreX() - this.relation.getCentreX();
/* 466 */       if ((Math.abs(w) < 10) && (
/* 467 */         ((this.entite.getCentreX() >= x) && (this.relation.getCentreX() <= x)) || ((this.entite.getCentreX() <= x) && (this.relation.getCentreX() >= x))))
/*     */       {
/* 469 */         if (((this.entite.getCentreY() >= y) && (this.relation.getCentreY() <= y)) || ((this.entite.getCentreY() <= y) && (this.relation.getCentreY() >= y)))
/*     */         {
/* 471 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     else {
/* 476 */       int h = this.entite.getCentreY() - (int)this.yCassure;
/* 477 */       int w = this.entite.getCentreX() - (int)this.xCassure;
/* 478 */       if ((Math.abs(w) < 10) && (
/* 479 */         ((this.entite.getCentreX() >= x) && ((int)this.xCassure <= x)) || ((this.entite.getCentreX() <= x) && ((int)this.xCassure >= x))))
/*     */       {
/* 481 */         if (((this.entite.getCentreY() >= y) && ((int)this.yCassure <= y)) || ((this.entite.getCentreY() <= y) && ((int)this.yCassure >= y)))
/*     */         {
/* 483 */           return true;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 488 */       h = (int)this.yCassure - this.relation.getCentreY();
/* 489 */       w = (int)this.xCassure - this.relation.getCentreX();
/* 490 */       if ((Math.abs(w) < 10) && (
/* 491 */         (((int)this.xCassure >= x) && (this.relation.getCentreX() <= x)) || (((int)this.xCassure <= x) && (this.relation.getCentreX() >= x))))
/*     */       {
/* 493 */         if ((((int)this.yCassure >= y) && (this.relation.getCentreY() <= y)) || (((int)this.yCassure <= y) && (this.relation.getCentreY() >= y)))
/*     */         {
/* 495 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 502 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isSelected(int x, int y)
/*     */   {
/* 507 */     if (isSelectedDroite(x, y)) {
/* 508 */       this.selected = true;
/* 509 */       return true;
/*     */     }
/* 511 */     if (!isCassure()) {
/* 512 */       double aa = calculeA() * x + calculeB() - y;
/* 513 */       if ((aa < 3.0D) && (aa > -3.0D)) {
/* 514 */         if (isDansLeCarre(x, y)) {
/* 515 */           this.selected = true;
/* 516 */           return true;
/*     */         }
/* 518 */         this.selected = false;
/* 519 */         return false;
/*     */       }
/* 521 */       this.selected = false;
/* 522 */       return false;
/*     */     }
/*     */     
/* 525 */     double aa = calculeACassureEntite() * x + calculeBCassureEntite() - y;
/* 526 */     if ((aa < 3.0D) && (aa > -3.0D) && 
/* 527 */       (isDansLeCarreEntite(x, y))) {
/* 528 */       this.selected = true;
/* 529 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 534 */     aa = calculeACassureRelation() * x + calculeBCassureRelation() - y;
/* 535 */     if ((aa < 3.0D) && (aa > -3.0D) && 
/* 536 */       (isDansLeCarreRelation(x, y))) {
/* 537 */       this.selected = true;
/* 538 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 544 */     this.selected = false;
/* 545 */     return false;
/*     */   }
/*     */   
/*     */   private double calculeA()
/*     */   {
/* 550 */     if (this.entite.getCentreX() - this.relation.getCentreX() != 0) {
/* 551 */       double n = (this.entite.getCentreY() - this.relation.getCentreY()) / (this.entite.getCentreX() - this.relation.getCentreX());
/* 552 */       return n;
/*     */     }
/* 554 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeB() {
/* 558 */     if (this.entite.getCentreX() - this.relation.getCentreX() != 0) {
/* 559 */       double n = this.entite.getCentreY() - calculeA() * this.entite.getCentreX();
/* 560 */       return n;
/*     */     }
/* 562 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarre(int x, int y) {
/* 566 */     if (this.entite.getCentreX() != this.relation.getCentreX()) {
/* 567 */       if ((this.entite.getCentreX() <= x) && (this.relation.getCentreX() >= x)) return true;
/* 568 */       if ((this.entite.getCentreX() >= x) && (this.relation.getCentreX() <= x)) return true;
/*     */     } else {
/* 570 */       if ((this.entite.getCentreY() <= y) && (this.relation.getCentreY() >= y)) return true;
/* 571 */       if ((this.entite.getCentreY() >= x) && (this.relation.getCentreY() <= y)) return true;
/*     */     }
/* 573 */     return false;
/*     */   }
/*     */   
/*     */   private double calculeACassureEntite() {
/* 577 */     if (this.relation.getCentreX() - this.xCassure != 0.0D) {
/* 578 */       double n = (this.relation.getCentreY() - this.yCassure) / (this.relation.getCentreX() - this.xCassure);
/* 579 */       return n;
/*     */     }
/* 581 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeBCassureEntite() {
/* 585 */     if (this.relation.getCentreX() - this.xCassure != 0.0D) {
/* 586 */       double n = this.relation.getCentreY() - calculeACassureEntite() * this.relation.getCentreX();
/* 587 */       return n;
/*     */     }
/* 589 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarreEntite(int x, int y) {
/* 593 */     if (this.entite.getCentreX() != this.xCassure) {
/* 594 */       if ((this.entite.getCentreX() <= x) && (this.xCassure >= x)) return true;
/* 595 */       if ((this.entite.getCentreX() >= x) && (this.xCassure <= x)) return true;
/*     */     } else {
/* 597 */       if ((this.entite.getCentreY() <= y) && (this.yCassure >= y)) return true;
/* 598 */       if ((this.entite.getCentreY() >= x) && (this.yCassure <= y)) return true;
/*     */     }
/* 600 */     return false;
/*     */   }
/*     */   
/*     */   private double calculeACassureRelation() {
/* 604 */     if (this.xCassure - this.relation.getCentreX() != 0.0D) {
/* 605 */       double n = (this.yCassure - this.relation.getCentreY()) / (this.xCassure - this.relation.getCentreX());
/* 606 */       return n;
/*     */     }
/* 608 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private double calculeBCassureRelation() {
/* 612 */     if (this.xCassure - this.relation.getCentreX() != 0.0D) {
/* 613 */       double n = this.yCassure - calculeACassureRelation() * this.xCassure;
/* 614 */       return n;
/*     */     }
/* 616 */     return Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   private boolean isDansLeCarreRelation(int x, int y) {
/* 620 */     if (this.xCassure != this.relation.getCentreX()) {
/* 621 */       if ((this.xCassure <= x) && (this.relation.getCentreX() >= x)) return true;
/* 622 */       if ((this.xCassure >= x) && (this.relation.getCentreX() <= x)) return true;
/*     */     } else {
/* 624 */       if ((this.yCassure <= y) && (this.relation.getCentreY() >= y)) return true;
/* 625 */       if ((this.yCassure >= x) && (this.relation.getCentreY() <= y)) return true;
/*     */     }
/* 627 */     return false;
/*     */   }
/*     */   
/*     */   public void setFleche(boolean fleche) {
/* 631 */     this.fleche = fleche;
/*     */   }
/*     */   
/*     */   public int getCote() {
/* 635 */     return this.cote;
/*     */   }
/*     */   
/*     */   public boolean isFleche() {
/* 639 */     return this.fleche;
/*     */   }
/*     */   
/*     */   public void setCote(int cote) {
/* 643 */     this.cote = cote;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMLD\MLDLienEntite.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */