/*     */ package IhmMCD2;
/*     */ 
/*     */ import IhmMCD.IhmContrainte;
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmLienContraintes;
/*     */ import IhmMCD.Point;
/*     */ import Merise2.Historique;
/*     */ import ihm.FormeInterneMCD;
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Stroke;
/*     */ import java.awt.geom.Line2D;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.geom.Rectangle2D.Double;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
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
/*     */ public class IhmLienContraintes2
/*     */   extends IhmLienContraintes
/*     */   implements Serializable
/*     */ {
/*     */   String nom;
/*     */   String code;
/*     */   String commentaire;
/*     */   private Color clLienContrainte2;
/*     */   private Color clLienTextContrainte2;
/*     */   private Color clLienNomContrainte2;
/*     */   private Color clLienActiverContrainte2;
/*     */   private Color clLienSelectContrainte2;
/*     */   ArrayList<IhmPoint> pointCassure;
/*     */   ArrayList<Historique> historique;
/*     */   private double zoom;
/*     */   private double tangente;
/*     */   private boolean activer;
/*     */   private boolean selected;
/*     */   int xCard;
/*     */   int yCard;
/*     */   private int cote;
/*     */   public static final int COTEDROIT = 3;
/*     */   public static final int COTEHAUT = 2;
/*     */   public static final int COTEGAUCHE = 1;
/*     */   public static final int COTEBAS = 4;
/*     */   float epaisseur;
/*     */   String identifiant;
/*     */   
/*     */   public IhmLienContraintes2(IhmEntiteRelation entRel, IhmEntiteRelation contrainte)
/*     */   {
/*  63 */     super(entRel, contrainte);
/*  64 */     setNom("");
/*     */     
/*  66 */     this.code = "";
/*  67 */     this.commentaire = "";
/*     */     
/*  69 */     this.clLienContrainte2 = FormeInterneMCD.clLienContrainte2;
/*  70 */     this.clLienTextContrainte2 = FormeInterneMCD.clLienTextContrainte2;
/*  71 */     this.clLienNomContrainte2 = FormeInterneMCD.clLienNomContrainte2;
/*  72 */     this.clLienSelectContrainte2 = FormeInterneMCD.clSelected;
/*  73 */     this.clLienActiverContrainte2 = FormeInterneMCD.clLienActiverContainte2;
/*     */     
/*  75 */     setCible(false);
/*  76 */     this.zoom = FormeInterneMCD.zoom;
/*  77 */     this.tangente = 1.0D;
/*  78 */     this.activer = false;
/*     */     
/*  80 */     this.pointCassure = new ArrayList();
/*  81 */     this.historique = new ArrayList();
/*  82 */     this.historique.add(Historique.getHistoriqueCreation());
/*  83 */     setSelected(false);
/*  84 */     this.epaisseur = FormeInterneMCD.lienContraintes2;
/*  85 */     this.identifiant = "";
/*     */   }
/*     */   
/*     */   public void paint(Graphics g)
/*     */   {
/*  90 */     Graphics2D g2d = (Graphics2D)g;
/*  91 */     dessinerLien(g2d);
/*  92 */     if (isSelected()) {
/*  93 */       DessinerTousLesPointSansLien(g2d);
/*     */     }
/*     */   }
/*     */   
/*     */   private void DessinerTousLesPointSansLien(Graphics2D gr) {
/*  98 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  99 */       gr.setColor(getClLien());
/*     */       
/* 101 */       if (isSelected()) {
/* 102 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFond());
/* 103 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*     */       }
/* 105 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/* 106 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFondSelect());
/* 107 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void coteIntersectionEntite()
/*     */   {
/* 116 */     int xe = getEntiteRelation().getCentreX();
/* 117 */     int ye = getEntiteRelation().getCentreY();
/*     */     
/* 119 */     int xr = getContrainte().getCentreX();
/* 120 */     int yr = getContrainte().getCentreY();
/*     */     
/* 122 */     if (this.pointCassure.size() > 0) {
/* 123 */       xr = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/* 124 */       yr = ((IhmPoint)this.pointCassure.get(0)).getYCentre();
/*     */     }
/*     */     
/* 127 */     int x1 = getEntiteRelation().getX();
/* 128 */     int y1 = getEntiteRelation().getY();
/* 129 */     int x2 = getEntiteRelation().getX();
/* 130 */     int y2 = getEntiteRelation().getY() + getEntiteRelation().getHeight();
/*     */     
/* 132 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/* 133 */       this.cote = 1;
/* 134 */       return;
/*     */     }
/*     */     
/* 137 */     x1 = getEntiteRelation().getX();
/* 138 */     y1 = getEntiteRelation().getY();
/* 139 */     x2 = getEntiteRelation().getX() + getEntiteRelation().getWidth();
/* 140 */     y2 = getEntiteRelation().getY();
/*     */     
/* 142 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/* 143 */       this.cote = 2;
/* 144 */       return;
/*     */     }
/*     */     
/* 147 */     x1 = getEntiteRelation().getX() + getEntiteRelation().getWidth();
/* 148 */     y1 = getEntiteRelation().getY();
/* 149 */     x2 = getEntiteRelation().getX() + getEntiteRelation().getWidth();
/* 150 */     y2 = getEntiteRelation().getY() + getEntiteRelation().getHeight();
/*     */     
/* 152 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/* 153 */       this.cote = 3;
/* 154 */       return;
/*     */     }
/*     */     
/* 157 */     x1 = getEntiteRelation().getX();
/* 158 */     y1 = getEntiteRelation().getY() + getEntiteRelation().getHeight();
/* 159 */     x2 = getEntiteRelation().getX() + getEntiteRelation().getWidth();
/* 160 */     y2 = getEntiteRelation().getY() + getEntiteRelation().getHeight();
/*     */     
/* 162 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/* 163 */       this.cote = 4;
/* 164 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   private Point getLastPoint() {
/* 169 */     if (this.pointCassure.size() == 0) {
/* 170 */       return new Point(getContrainte().getCentreX(), getContrainte().getCentreY());
/*     */     }
/* 172 */     return ((IhmPoint)this.pointCassure.get(0)).getPoint();
/*     */   }
/*     */   
/*     */   private boolean segmentSelect(int xs, int ys, int xt, int yt, int xx, int yy)
/*     */   {
/* 177 */     if (Line2D.linesIntersect(xs, ys, xt, yt, xx - 5, yy - 5, xx + 5, yy + 5)) return true;
/* 178 */     if (Line2D.linesIntersect(xs, ys, xt, yt, xx + 5, yy - 5, xx - 5, yy + 5)) return true;
/* 179 */     return false;
/*     */   }
/*     */   
/*     */   private boolean listePointEdentique(ArrayList<IhmPoint> liste) {
/* 183 */     if (liste.size() != this.pointCassure.size()) return false;
/* 184 */     for (int i = 0; i < liste.size(); i++) {
/* 185 */       if ((((IhmPoint)liste.get(i)).getX() != ((IhmPoint)this.pointCassure.get(i)).getX()) || (((IhmPoint)liste.get(i)).getY() != ((IhmPoint)this.pointCassure.get(i)).getY())) return false;
/*     */     }
/* 187 */     return true;
/*     */   }
/*     */   
/*     */   public boolean egale(IhmLienContraintes2 lien) {
/* 191 */     if ((lien.getEntiteRelation() != getEntiteRelation()) || (getContrainte() != lien.getContrainte())) return false;
/* 192 */     return listePointEdentique(lien.getPointCassure());
/*     */   }
/*     */   
/*     */   public void supprimerPointSelectionner() {
/* 196 */     int nb = this.pointCassure.size();
/* 197 */     int i = 0;
/* 198 */     while (i < nb) {
/* 199 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/* 200 */         this.pointCassure.remove(i);
/* 201 */         nb--;
/*     */       } else {
/* 203 */         i++;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean deplacerPointSelectionner(int x, int y) {
/* 209 */     int nb = this.pointCassure.size();
/* 210 */     boolean dep = false;
/* 211 */     for (int i = 0; i < nb; i++) {
/* 212 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/* 213 */         dep = true;
/* 214 */         ((IhmPoint)this.pointCassure.get(i)).move(((IhmPoint)this.pointCassure.get(i)).getX() - x, ((IhmPoint)this.pointCassure.get(i)).getY() - y);
/*     */       }
/*     */     }
/* 217 */     return dep;
/*     */   }
/*     */   
/*     */   public int XMaxPointSelectionner() {
/* 221 */     int nb = this.pointCassure.size();
/* 222 */     int xg = 0;
/* 223 */     for (int i = 0; i < nb; i++) {
/* 224 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/* 225 */         (xg < ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth())) {
/* 226 */         xg = ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth();
/*     */       }
/*     */     }
/*     */     
/* 230 */     return xg;
/*     */   }
/*     */   
/*     */   public int YMaxPointSelectionner() {
/* 234 */     int nb = this.pointCassure.size();
/* 235 */     int xg = 0;
/* 236 */     for (int i = 0; i < nb; i++) {
/* 237 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/* 238 */         (xg < ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight())) {
/* 239 */         xg = ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight();
/*     */       }
/*     */     }
/*     */     
/* 243 */     return xg;
/*     */   }
/*     */   
/*     */   public int XMaxAllPoint() {
/* 247 */     int nb = this.pointCassure.size();
/* 248 */     int xg = 0;
/* 249 */     for (int i = 0; i < nb; i++)
/*     */     {
/* 251 */       if (xg < ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth()) {
/* 252 */         xg = ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth();
/*     */       }
/*     */     }
/*     */     
/* 256 */     return xg;
/*     */   }
/*     */   
/*     */   public int YMaxAllPoint() {
/* 260 */     int nb = this.pointCassure.size();
/* 261 */     int xg = 0;
/* 262 */     for (int i = 0; i < nb; i++)
/*     */     {
/* 264 */       if (xg < ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight()) {
/* 265 */         xg = ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight();
/*     */       }
/*     */     }
/*     */     
/* 269 */     return xg;
/*     */   }
/*     */   
/*     */   public int XMinPointSelectionner() {
/* 273 */     int nb = this.pointCassure.size();
/* 274 */     int xg = Integer.MAX_VALUE;
/* 275 */     for (int i = 0; i < nb; i++) {
/* 276 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/* 277 */         (xg > ((IhmPoint)this.pointCassure.get(i)).getX())) {
/* 278 */         xg = ((IhmPoint)this.pointCassure.get(i)).getX();
/*     */       }
/*     */     }
/*     */     
/* 282 */     return xg;
/*     */   }
/*     */   
/*     */   public int YMinPointSelectionner() {
/* 286 */     int nb = this.pointCassure.size();
/* 287 */     int xg = Integer.MAX_VALUE;
/* 288 */     for (int i = 0; i < nb; i++) {
/* 289 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/* 290 */         (xg > ((IhmPoint)this.pointCassure.get(i)).getY())) {
/* 291 */         xg = ((IhmPoint)this.pointCassure.get(i)).getY();
/*     */       }
/*     */     }
/*     */     
/* 295 */     return xg; }
/*     */   
/*     */   private double tangeanteEntite() {
/*     */     int xt;
/*     */     int yt;
/* 300 */     if (this.pointCassure.size() == 0) {
/* 301 */       xt = getContrainte().getCentreX();
/* 302 */       yt = getContrainte().getCentreY();
/*     */     } else {
/* 304 */       xt = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/* 305 */       yt = ((IhmPoint)this.pointCassure.get(0)).getYCentre();
/*     */     }
/* 307 */     double d1 = getEntiteRelation().getCentreX() - xt;
/* 308 */     double d2 = getEntiteRelation().getCentreY() - yt;
/* 309 */     return d2 / d1;
/*     */   }
/*     */   
/*     */   private boolean isEntiteMemeX()
/*     */   {
/* 314 */     int x = getContrainte().getCentreX();
/*     */     
/* 316 */     if (this.pointCassure.size() > 0) {
/* 317 */       x = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/*     */     }
/* 319 */     if (getEntiteRelation().getCentreX() == x) return true;
/* 320 */     return false;
/*     */   }
/*     */   
/*     */   private void calculPointCardinaliteMemeXEntite()
/*     */   {
/* 325 */     int x = getEntiteRelation().getCentreX();
/* 326 */     if (this.cote == 2) {
/* 327 */       this.xCard = x;
/* 328 */       this.yCard = getEntiteRelation().getY();
/*     */     }
/*     */     
/* 331 */     if (this.cote == 4) {
/* 332 */       this.xCard = x;
/*     */       
/* 334 */       this.yCard = (getEntiteRelation().getY() + getEntiteRelation().getHeight());
/* 335 */       if (getEntiteRelation().isOmbre()) { this.yCard += 3;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void calculPointCardinaliteEntite()
/*     */   {
/* 342 */     if (isEntiteMemeX()) {
/* 343 */       calculPointCardinaliteMemeXEntite();
/*     */     }
/*     */     else {
/* 346 */       double tag = tangeanteEntite();
/* 347 */       this.tangente = tag;
/* 348 */       int y1 = getEntiteRelation().getCentreY();
/* 349 */       int x1 = getEntiteRelation().getCentreX();
/* 350 */       if (this.cote == 1) {
/* 351 */         this.xCard = getEntiteRelation().getX();
/* 352 */         this.yCard = ((int)(tag * this.xCard + (y1 - tag * x1)));
/*     */       }
/*     */       
/*     */ 
/* 356 */       if (this.cote == 3) {
/* 357 */         this.xCard = (getEntiteRelation().getX() + getEntiteRelation().getWidth());
/* 358 */         if (getEntiteRelation().isOmbre()) this.xCard += 3;
/* 359 */         this.yCard = ((int)(tag * this.xCard + (y1 - tag * x1)));
/*     */       }
/*     */       
/* 362 */       if (this.cote == 2) {
/* 363 */         int dec = (int)(15.0D - Math.abs(Math.atan(this.tangente)) * 10.0D);
/* 364 */         this.yCard = getEntiteRelation().getY();
/* 365 */         if (getEntiteRelation().isOmbre()) this.yCard += 3;
/* 366 */         this.xCard = ((int)((this.yCard - (y1 - tag * x1)) / tag));
/*     */       }
/*     */       
/* 369 */       if (this.cote == 4) {
/* 370 */         this.yCard = (getEntiteRelation().getY() + getEntiteRelation().getHeight());
/*     */         
/* 372 */         if (getEntiteRelation().isOmbre()) { this.yCard += 4;
/*     */         }
/* 374 */         this.xCard = ((int)((this.yCard - (y1 - tag * x1)) / tag));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void calculerXYCardianlite() {
/* 380 */     coteIntersectionEntite();
/* 381 */     calculPointCardinaliteEntite();
/*     */   }
/*     */   
/*     */   public boolean estDans(int xd, int yd, int xf, int yf) {
/* 385 */     if (getPointCassure().size() > 0) {
/* 386 */       for (int i = 0; i < getPointCassure().size(); i++) {
/* 387 */         if (!((IhmPoint)getPointCassure().get(i)).isSelected()) return false;
/*     */       }
/* 389 */       return true;
/*     */     }
/*     */     
/* 392 */     int x1 = xd;
/* 393 */     int x2 = xf;
/* 394 */     int y1 = yd;
/* 395 */     int y2 = yf;
/* 396 */     if (xd > xf) {
/* 397 */       x1 = xf;
/* 398 */       x2 = xd;
/*     */     }
/* 400 */     if (yd > yf) {
/* 401 */       y1 = yf;
/* 402 */       y2 = yd;
/*     */     }
/* 404 */     Rectangle2D rec = new Rectangle2D.Double(x1, y1, x2 - x1, y2 - y1);
/* 405 */     if ((rec.contains(getEntiteRelation().getCentreX(), getEntiteRelation().getCentreY())) && (rec.contains(getContrainte().getCentreX(), getContrainte().getCentreY())))
/* 406 */       return true;
/* 407 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean addBreakPoint(int x, int y)
/*     */   {
/* 414 */     int xs = getEntiteRelation().getCentreX();
/* 415 */     int ys = getEntiteRelation().getCentreY();
/* 416 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 417 */       int xt = ((IhmPoint)this.pointCassure.get(i)).getPoint().getX();
/* 418 */       int yt = ((IhmPoint)this.pointCassure.get(i)).getPoint().getY();
/* 419 */       if (segmentSelect(xs, ys, xt, yt, x, y)) {
/* 420 */         IhmPoint p = new IhmPoint(x, y);
/* 421 */         this.pointCassure.add(i, p);
/* 422 */         p.setSelected(true);
/* 423 */         return true;
/*     */       }
/* 425 */       xs = xt;
/* 426 */       ys = yt;
/*     */     }
/* 428 */     if (segmentSelect(xs, ys, getContrainte().getCentreX(), getContrainte().getCentreY(), x, y)) {
/* 429 */       IhmPoint p = new IhmPoint(x, y);
/* 430 */       this.pointCassure.add(p);
/* 431 */       p.setSelected(true);
/* 432 */       return true;
/*     */     }
/* 434 */     return false;
/*     */   }
/*     */   
/*     */   private Point rotation(double x, double y, double tg) {
/* 438 */     Point p = new Point(0, 0);
/* 439 */     double x1 = 0.0D;double y1 = 0.0D;double rac = 0.0D;
/* 440 */     rac = Math.sqrt(Math.pow(tg, 2.0D) + 1.0D);
/* 441 */     x1 = (x - y * tg) / rac;
/* 442 */     y1 = (y + x * tg) / rac;
/* 443 */     p.setX((int)x1);
/* 444 */     p.setY((int)y1);
/* 445 */     return p;
/*     */   }
/*     */   
/*     */   public void dessinerFleche(Graphics2D gr) {
/* 449 */     gr.setColor(this.clLienContrainte2);
/* 450 */     if (isActiver()) gr.setColor(getClLienActiverContrainte2());
/* 451 */     if (isSelect()) { gr.setColor(getClLienSelectContrainte2());
/*     */     }
/* 453 */     Point lp = getLastPoint();
/*     */     
/* 455 */     if (isEntiteMemeX()) {
/* 456 */       if (this.cote == 2) {
/* 457 */         int[] x = new int[3];
/* 458 */         int[] y = new int[3];
/* 459 */         int xfleche = 5;
/* 460 */         int yfleche = 10;
/* 461 */         x[0] = getEntiteRelation().getCentreX();
/* 462 */         y[0] = getEntiteRelation().getY();
/*     */         
/* 464 */         x[1] = (x[0] - xfleche);
/* 465 */         y[1] = (y[0] - yfleche);
/*     */         
/* 467 */         x[2] = (x[0] + xfleche);
/* 468 */         y[2] = (y[0] - yfleche);
/*     */         
/* 470 */         gr.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/* 473 */       if (this.cote == 4) {
/* 474 */         int[] x = new int[3];
/* 475 */         int[] y = new int[3];
/* 476 */         int xfleche = 5;
/* 477 */         int yfleche = 10;
/* 478 */         x[0] = getEntiteRelation().getCentreX();
/* 479 */         y[0] = (getEntiteRelation().getY() + getEntiteRelation().getHeight());
/* 480 */         if (getEntiteRelation().isOmbre()) y[0] += 4;
/* 481 */         x[1] = (x[0] - xfleche);
/* 482 */         y[1] = (y[0] + yfleche);
/*     */         
/* 484 */         x[2] = (x[0] + xfleche);
/* 485 */         y[2] = (y[0] + yfleche);
/*     */         
/* 487 */         gr.fillPolygon(x, y, 3);
/*     */       }
/* 489 */       return;
/*     */     }
/*     */     
/* 492 */     double tan = getEntiteRelation().getCentreY() - lp.getY();
/* 493 */     tan /= (getEntiteRelation().getCentreX() - lp.getX());
/*     */     
/* 495 */     int[] x = new int[3];
/* 496 */     int[] y = new int[3];
/*     */     
/*     */ 
/*     */ 
/* 500 */     int posi = this.cote;
/*     */     
/* 502 */     Point p = new Point(this.xCard, this.yCard);
/*     */     
/*     */ 
/* 505 */     int xfleche = 10;
/* 506 */     int yfleche = 5;
/*     */     
/* 508 */     x[0] = p.getX();
/* 509 */     y[0] = p.getY();
/* 510 */     int dx = x[0];
/* 511 */     int dy = y[0];
/* 512 */     p = rotation(x[0], y[0], tan);
/* 513 */     dx -= p.getX();
/* 514 */     dy -= p.getY();
/*     */     
/*     */ 
/* 517 */     if (posi == 1)
/*     */     {
/* 519 */       x[0] = (p.getX() + dx);
/* 520 */       y[0] = (p.getY() + dy);
/*     */       
/* 522 */       p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/* 523 */       x[1] = p.getX();
/* 524 */       y[1] = p.getY();
/*     */       
/* 526 */       x[1] += dx;
/* 527 */       y[1] += dy;
/*     */       
/* 529 */       p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/* 530 */       x[2] = (p.getX() + dx);
/* 531 */       y[2] = (p.getY() + dy);
/*     */       
/* 533 */       gr.fillPolygon(x, y, 3);
/*     */     }
/* 535 */     if (posi == 3) {
/* 536 */       x[0] = (p.getX() + dx);
/* 537 */       y[0] = (p.getY() + dy);
/*     */       
/* 539 */       p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/* 540 */       x[1] = p.getX();
/* 541 */       y[1] = p.getY();
/*     */       
/* 543 */       x[1] += dx;
/* 544 */       y[1] += dy;
/*     */       
/*     */ 
/* 547 */       p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/* 548 */       x[2] = (p.getX() + dx);
/* 549 */       y[2] = (p.getY() + dy);
/*     */       
/* 551 */       gr.fillPolygon(x, y, 3);
/*     */     }
/*     */     
/* 554 */     if (posi == 4) {
/* 555 */       if (getEntiteRelation().getCentreX() < lp.getX()) {
/* 556 */         x[0] = (p.getX() + dx);
/* 557 */         y[0] = (p.getY() + dy);
/*     */         
/* 559 */         p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/* 560 */         x[1] = (p.getX() + dx);
/* 561 */         y[1] = (p.getY() + dy);
/*     */         
/* 563 */         p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/* 564 */         x[2] = (p.getX() + dx);
/* 565 */         y[2] = (p.getY() + dy);
/*     */       } else {
/* 567 */         x[0] = (p.getX() + dx);
/* 568 */         y[0] = (p.getY() + dy);
/*     */         
/* 570 */         p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/* 571 */         x[1] = (p.getX() + dx);
/* 572 */         y[1] = (p.getY() + dy);
/*     */         
/* 574 */         p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/* 575 */         x[2] = (p.getX() + dx);
/* 576 */         y[2] = (p.getY() + dy);
/*     */       }
/*     */       
/* 579 */       gr.fillPolygon(x, y, 3);
/*     */     }
/*     */     
/* 582 */     if (posi == 2) {
/* 583 */       if (getEntiteRelation().getCentreX() > lp.getX()) {
/* 584 */         tan = lp.getY() - getEntiteRelation().getCentreY();
/* 585 */         tan /= (lp.getX() - getEntiteRelation().getCentreX());
/*     */         
/* 587 */         x[0] = (p.getX() + dx);
/* 588 */         y[0] = (p.getY() + dy);
/*     */         
/* 590 */         p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/* 591 */         x[1] = p.getX();
/* 592 */         y[1] = p.getY();
/*     */         
/* 594 */         x[1] += dx;
/* 595 */         y[1] += dy;
/*     */         
/* 597 */         p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/* 598 */         x[2] = (p.getX() + dx);
/* 599 */         y[2] = (p.getY() + dy);
/*     */       }
/*     */       else {
/* 602 */         x[0] = (p.getX() + dx);
/* 603 */         y[0] = (p.getY() + dy);
/*     */         
/* 605 */         p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/* 606 */         x[1] = p.getX();
/* 607 */         y[1] = p.getY();
/*     */         
/* 609 */         x[1] += dx;
/* 610 */         y[1] += dy;
/*     */         
/* 612 */         p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/* 613 */         x[2] = (p.getX() + dx);
/* 614 */         y[2] = (p.getY() + dy);
/*     */       }
/* 616 */       gr.fillPolygon(x, y, 3);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void DessinerTousLesPoint(Graphics2D gr)
/*     */   {
/* 625 */     int x0 = getEntiteRelation().getCentreX();
/* 626 */     int y0 = getEntiteRelation().getCentreY();
/* 627 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 628 */       gr.setColor(getClLienContrainte2());
/* 629 */       if (isActiver()) gr.setColor(getClLienActiverContrainte2());
/* 630 */       if (isSelect()) gr.setColor(getClLienSelectContrainte2());
/* 631 */       gr.drawLine(x0, y0, ((IhmPoint)this.pointCassure.get(i)).getXCentre(), ((IhmPoint)this.pointCassure.get(i)).getYCentre());
/* 632 */       x0 = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/* 633 */       y0 = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/* 634 */       if (isSelect()) {
/* 635 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFond());
/* 636 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*     */       }
/* 638 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/* 639 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFondSelect());
/* 640 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*     */       }
/* 642 */       x0 = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/* 643 */       y0 = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/*     */     }
/* 645 */     gr.setColor(this.clLienContrainte2);
/* 646 */     if (isActiver()) gr.setColor(getClLienActiverContrainte2());
/* 647 */     if (isSelect()) { gr.setColor(getClLienSelectContrainte2());
/*     */     }
/* 649 */     gr.drawLine(x0, y0, getContrainte().getCentreX(), getContrainte().getCentreY());
/*     */   }
/*     */   
/*     */   public void ajouterModification() {
/* 653 */     Historique h = Historique.getHistoriqueModification();
/* 654 */     Historique h1 = (Historique)this.historique.get(this.historique.size() - 1);
/* 655 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur()))) {
/* 656 */       getHistorique().add(h);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerLien(Graphics2D gr) {
/* 661 */     if ((getEntiteRelation() instanceof IhmEntite2)) {
/* 662 */       Graphics2D g2d = gr;
/* 663 */       Stroke stro = g2d.getStroke();
/*     */       
/* 665 */       float[] style = { 5.0F, 5.0F };
/* 666 */       g2d.setStroke(new BasicStroke(this.epaisseur, 0, 0, 10.0F, style, 0.0F));
/*     */       
/* 668 */       DessinerTousLesPoint(g2d);
/* 669 */       g2d.setStroke(stro);
/*     */     }
/*     */     else {
/* 672 */       Graphics2D g2d = gr;
/* 673 */       Stroke stro = g2d.getStroke();
/* 674 */       float[] style = { 5.0F, 0.0F };
/* 675 */       g2d.setStroke(new BasicStroke(this.epaisseur, 0, 0, 10.0F, style, 0.0F));
/* 676 */       DessinerTousLesPoint(gr);
/* 677 */       if (isCible()) {
/* 678 */         calculerXYCardianlite();
/* 679 */         dessinerFleche(gr);
/*     */       }
/* 681 */       g2d.setStroke(stro);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSelected(boolean selected)
/*     */   {
/* 689 */     this.selected = selected;
/* 690 */     super.setSelected(selected);
/*     */     
/* 692 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 693 */       ((IhmPoint)this.pointCassure.get(i)).setDesigner(selected);
/* 694 */       if (!selected) {
/* 695 */         ((IhmPoint)this.pointCassure.get(i)).setSelected(false);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IhmPoint getSelectedPointCassure(int x, int y)
/*     */   {
/* 702 */     IhmPoint p = null;
/* 703 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 704 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected(x, y)) {
/* 705 */         p = (IhmPoint)this.pointCassure.get(i);
/*     */       }
/*     */     }
/* 708 */     return p;
/*     */   }
/*     */   
/*     */   public boolean isSelected(int x, int y)
/*     */   {
/* 713 */     if (getSelectedPointCassure(x, y) != null) { return true;
/*     */     }
/*     */     
/*     */ 
/* 717 */     int xs = getEntiteRelation().getCentreX();
/* 718 */     int ys = getEntiteRelation().getCentreY();
/* 719 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 720 */       int xt = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/* 721 */       int yt = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/* 722 */       if (segmentSelect(xs, ys, xt, yt, x, y)) {
/* 723 */         return true;
/*     */       }
/* 725 */       xs = xt;
/* 726 */       ys = yt;
/*     */     }
/*     */     
/* 729 */     int xt = getContrainte().getCentreX();
/* 730 */     int yt = getContrainte().getCentreY();
/*     */     
/* 732 */     return segmentSelect(xs, ys, xt, yt, x, y);
/*     */   }
/*     */   
/*     */   public void ajouterCopier(ArrayList<Historique> lhis)
/*     */   {
/* 737 */     Historique h = Historique.getHistoriqueCopie();
/* 738 */     Historique h1 = (Historique)lhis.get(lhis.size() - 1);
/* 739 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur())) || (!h.getAction().equals(h1.getAction())))
/*     */     {
/* 741 */       lhis.add(h);
/*     */     }
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> copierHistoriques(ArrayList<Historique> lhis) {
/* 746 */     ArrayList<Historique> l = new ArrayList();
/* 747 */     for (int i = 0; i < lhis.size(); i++) {
/* 748 */       l.add(((Historique)lhis.get(i)).copier());
/*     */     }
/* 750 */     return l;
/*     */   }
/*     */   
/*     */   public ArrayList<IhmPoint> copierListePointDeCassure() {
/* 754 */     ArrayList<IhmPoint> liste = new ArrayList();
/* 755 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 756 */       IhmPoint p = ((IhmPoint)this.pointCassure.get(i)).copier();
/* 757 */       p.setX(p.getX() + 10);
/* 758 */       p.setY(p.getY() + 10);
/* 759 */       p.setSelected(true);
/* 760 */       liste.add(p);
/*     */     }
/* 762 */     return liste;
/*     */   }
/*     */   
/*     */   public IhmLienContraintes2 copier(IhmEntiteRelation ent, IhmContrainte rel) {
/* 766 */     IhmLienContraintes2 lien = new IhmLienContraintes2(ent, rel);
/*     */     
/*     */ 
/* 769 */     lien.setNom(getNom());
/* 770 */     lien.setClLienContrainte2(getClLienContrainte2());
/* 771 */     lien.setClLienTextContrainte2(getClLienTextContrainte2());
/* 772 */     lien.setClLienNomContrainte2(getClLienNomContrainte2());
/* 773 */     lien.setClLienActiverContrainte2(getClLienActiverContrainte2());
/* 774 */     lien.setClLienSelectContrainte2(getClLienSelectContrainte2());
/*     */     
/*     */ 
/*     */ 
/* 778 */     lien.setCommentaire(getCommentaire());
/*     */     
/* 780 */     lien.setCode(getCode());
/*     */     
/* 782 */     lien.setCible(isCible());
/* 783 */     lien.setZoom(getZoom());
/*     */     
/* 785 */     lien.setPointCassure(copierListePointDeCassure());
/* 786 */     lien.setHistorique(copierHistoriques(this.historique));
/* 787 */     ajouterCopier(lien.getHistorique());
/* 788 */     return lien;
/*     */   }
/*     */   
/*     */   public static IhmLienContraintes2 parseIhmLienContrainte(IhmLienContraintes lien, IhmEntiteRelation newEnt, IhmContrainte newCnt)
/*     */   {
/* 793 */     IhmLienContraintes2 l = new IhmLienContraintes2(newEnt, newCnt);
/*     */     
/* 795 */     l.setNom(lien.getNom());
/* 796 */     l.setCode(lien.getNom().toUpperCase());
/* 797 */     l.setClLienNomContrainte2(FormeInterneMCD.clLienNomContrainte2);
/* 798 */     l.setClLienContrainte2(FormeInterneMCD.clLienContrainte2);
/* 799 */     l.setClLienTextContrainte2(FormeInterneMCD.clLienTextContrainte2);
/* 800 */     l.setCommentaire("");
/*     */     
/* 802 */     if (lien.isCassure()) {
/* 803 */       l.getPointCassure().add(new IhmPoint((int)lien.getxCassure(), (int)lien.getyCassure()));
/*     */     }
/*     */     
/* 806 */     return l;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isSelect()
/*     */   {
/* 816 */     return this.selected;
/*     */   }
/*     */   
/*     */   public IhmEntiteRelation getEntiteRelation() {
/* 820 */     return super.getEntRel();
/*     */   }
/*     */   
/*     */   public boolean isActiver() {
/* 824 */     return this.activer;
/*     */   }
/*     */   
/*     */   public Color getClLienActiverContrainte2() {
/* 828 */     return this.clLienActiverContrainte2;
/*     */   }
/*     */   
/*     */   public Color getClLienContrainte2() {
/* 832 */     return this.clLienContrainte2;
/*     */   }
/*     */   
/*     */   public Color getClLienNomContrainte2() {
/* 836 */     return this.clLienNomContrainte2;
/*     */   }
/*     */   
/*     */   public Color getClLienSelectContrainte2() {
/* 840 */     return this.clLienSelectContrainte2;
/*     */   }
/*     */   
/*     */   public Color getClLienTextContrainte2() {
/* 844 */     return this.clLienTextContrainte2;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 848 */     return this.code;
/*     */   }
/*     */   
/*     */   public float getEpaisseur() {
/* 852 */     return this.epaisseur;
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/* 856 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public int getCote() {
/* 860 */     return this.cote;
/*     */   }
/*     */   
/*     */   public String getIdentifiant() {
/* 864 */     return this.identifiant;
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> getHistorique() {
/* 868 */     return this.historique;
/*     */   }
/*     */   
/*     */   public ArrayList<IhmPoint> getPointCassure() {
/* 872 */     return this.pointCassure;
/*     */   }
/*     */   
/*     */   public double getTangente() {
/* 876 */     return this.tangente;
/*     */   }
/*     */   
/*     */   public int getxCard() {
/* 880 */     return this.xCard;
/*     */   }
/*     */   
/*     */   public int getyCard() {
/* 884 */     return this.yCard;
/*     */   }
/*     */   
/*     */   public double getZoom() {
/* 888 */     return this.zoom;
/*     */   }
/*     */   
/*     */   public void setActiver(boolean activer) {
/* 892 */     this.activer = activer;
/*     */   }
/*     */   
/*     */   public void setClLienActiverContrainte2(Color clLienActiverContrainte2) {
/* 896 */     this.clLienActiverContrainte2 = clLienActiverContrainte2;
/*     */   }
/*     */   
/*     */   public void setClLienContrainte2(Color clLienContrainte2) {
/* 900 */     this.clLienContrainte2 = clLienContrainte2;
/*     */   }
/*     */   
/*     */   public void setClLienNomContrainte2(Color clLienNomContrainte2) {
/* 904 */     this.clLienNomContrainte2 = clLienNomContrainte2;
/*     */   }
/*     */   
/*     */   public void setClLienSelectContrainte2(Color clLienSelectContrainte2) {
/* 908 */     this.clLienSelectContrainte2 = clLienSelectContrainte2;
/*     */   }
/*     */   
/*     */   public void setClLienTextContrainte2(Color clLienTextContrainte2) {
/* 912 */     this.clLienTextContrainte2 = clLienTextContrainte2;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 916 */     this.code = code;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String commentaire) {
/* 920 */     this.commentaire = commentaire;
/*     */   }
/*     */   
/*     */   public void setCote(int cote) {
/* 924 */     this.cote = cote;
/*     */   }
/*     */   
/*     */   public void setEpaisseur(float epaisseur) {
/* 928 */     this.epaisseur = epaisseur;
/*     */   }
/*     */   
/*     */   public void setHistorique(ArrayList<Historique> historique) {
/* 932 */     this.historique = historique;
/*     */   }
/*     */   
/*     */   public void setPointCassure(ArrayList<IhmPoint> pointCassure) {
/* 936 */     this.pointCassure = pointCassure;
/*     */   }
/*     */   
/*     */   public void setIdentifiant(String identifiant) {
/* 940 */     this.identifiant = identifiant;
/*     */   }
/*     */   
/*     */   public void setTangente(double tangente) {
/* 944 */     this.tangente = tangente;
/*     */   }
/*     */   
/*     */   public void setxCard(int xCard) {
/* 948 */     this.xCard = xCard;
/*     */   }
/*     */   
/*     */   public void setyCard(int yCard) {
/* 952 */     this.yCard = yCard;
/*     */   }
/*     */   
/*     */   public void setZoom(double zoom) {
/* 956 */     this.zoom = zoom;
/*     */   }
/*     */   
/*     */   public boolean isSelected() {
/* 960 */     return this.selected;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmLienContraintes2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */