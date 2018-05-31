/*     */ package IhmMCD2;
/*     */ 
/*     */ import IhmMCD.IhmCommentaireIndip;
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmLienCommentaire;
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
/*     */ public class IhmLienCommentaire2
/*     */   extends IhmLienCommentaire
/*     */   implements Serializable
/*     */ {
/*     */   String code;
/*     */   String commentaire;
/*     */   public Color clFond2;
/*     */   public Color clActiver;
/*     */   public Color clSelected;
/*     */   public boolean activer;
/*     */   double zoom;
/*     */   double tangente;
/*     */   int xCard;
/*     */   int yCard;
/*     */   private int cote;
/*     */   public static final int COTEDROIT = 3;
/*     */   public static final int COTEHAUT = 2;
/*     */   public static final int COTEGAUCHE = 1;
/*     */   public static final int COTEBAS = 4;
/*     */   ArrayList<IhmPoint> pointCassure;
/*     */   ArrayList<Historique> historique;
/*     */   float epaisseur;
/*     */   
/*     */   public IhmLienCommentaire2(IhmEntiteRelation entRel, IhmCommentaireIndip commentaire)
/*     */   {
/*  54 */     super(entRel, commentaire);
/*  55 */     this.code = "";
/*  56 */     this.commentaire = "";
/*     */     
/*  58 */     this.clFond2 = FormeInterneMCD.clLienCommentaire2;
/*  59 */     this.clActiver = Color.GRAY;
/*  60 */     this.clSelected = FormeInterneMCD.clSelected;
/*  61 */     this.activer = false;
/*     */     
/*  63 */     this.zoom = FormeInterneMCD.zoom;
/*  64 */     this.tangente = 1.0D;
/*     */     
/*  66 */     super.setSelected(false);
/*     */     
/*  68 */     this.xCard = 0;
/*  69 */     this.yCard = 0;
/*     */     
/*     */ 
/*  72 */     this.pointCassure = new ArrayList();
/*  73 */     this.historique = new ArrayList();
/*  74 */     this.historique.add(Historique.getHistoriqueCreation());
/*     */     
/*  76 */     this.epaisseur = FormeInterneMCD.lienContraintes2;
/*     */   }
/*     */   
/*     */ 
/*     */   public void paint(Graphics g)
/*     */   {
/*  82 */     Graphics2D g2d = (Graphics2D)g;
/*  83 */     dessinerLien(g2d);
/*  84 */     if (isSelected()) {
/*  85 */       DessinerTousLesPointSansLien(g2d);
/*     */     }
/*     */   }
/*     */   
/*     */   private void DessinerTousLesPointSansLien(Graphics2D gr)
/*     */   {
/*  91 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  92 */       gr.setColor(getClLien());
/*     */       
/*  94 */       if (isSelected()) {
/*  95 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFond());
/*  96 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*     */       }
/*  98 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/*  99 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFondSelect());
/* 100 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void dessinerLien(Graphics2D gr)
/*     */   {
/* 107 */     Graphics2D g2d = gr;
/* 108 */     Stroke stro = g2d.getStroke();
/* 109 */     float[] style = { 12.0F, 3.0F };
/* 110 */     g2d.setStroke(new BasicStroke(this.epaisseur, 0, 0, 10.0F, style, 0.0F));
/* 111 */     DessinerTousLesPoint(g2d);
/* 112 */     g2d.setStroke(stro);
/*     */   }
/*     */   
/*     */   public void DessinerTousLesPoint(Graphics2D gr)
/*     */   {
/* 117 */     int x0 = getEntiteRelation().getCentreX();
/* 118 */     int y0 = getEntiteRelation().getCentreY();
/* 119 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 120 */       gr.setColor(getClFond2());
/* 121 */       if (isActiver()) gr.setColor(getClActiver());
/* 122 */       if (isSelect()) gr.setColor(getClSelected());
/* 123 */       gr.drawLine(x0, y0, ((IhmPoint)this.pointCassure.get(i)).getXCentre(), ((IhmPoint)this.pointCassure.get(i)).getYCentre());
/* 124 */       x0 = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/* 125 */       y0 = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/* 126 */       if (isSelect()) {
/* 127 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFond());
/* 128 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*     */       }
/* 130 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/* 131 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFondSelect());
/* 132 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*     */       }
/* 134 */       x0 = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/* 135 */       y0 = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/*     */     }
/* 137 */     gr.setColor(this.clFond2);
/* 138 */     if (isActiver()) gr.setColor(getClActiver());
/* 139 */     if (isSelect()) { gr.setColor(getClSelected());
/*     */     }
/* 141 */     gr.drawLine(x0, y0, getCommentaire().getCentreX(), getCommentaire().getCentreY());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void coteIntersectionEntite()
/*     */   {
/* 150 */     int xe = getEntiteRelation().getCentreX();
/* 151 */     int ye = getEntiteRelation().getCentreY();
/*     */     
/* 153 */     int xr = getCommentaire().getCentreX();
/* 154 */     int yr = getCommentaire().getCentreY();
/*     */     
/* 156 */     if (this.pointCassure.size() > 0) {
/* 157 */       xr = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/* 158 */       yr = ((IhmPoint)this.pointCassure.get(0)).getYCentre();
/*     */     }
/*     */     
/* 161 */     int x1 = getEntiteRelation().getX();
/* 162 */     int y1 = getEntiteRelation().getY();
/* 163 */     int x2 = getEntiteRelation().getX();
/* 164 */     int y2 = getEntiteRelation().getY() + getEntiteRelation().getHeight();
/*     */     
/* 166 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/* 167 */       this.cote = 1;
/* 168 */       return;
/*     */     }
/*     */     
/* 171 */     x1 = getEntiteRelation().getX();
/* 172 */     y1 = getEntiteRelation().getY();
/* 173 */     x2 = getEntiteRelation().getX() + getEntiteRelation().getWidth();
/* 174 */     y2 = getEntiteRelation().getY();
/*     */     
/* 176 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/* 177 */       this.cote = 2;
/* 178 */       return;
/*     */     }
/*     */     
/* 181 */     x1 = getEntiteRelation().getX() + getEntiteRelation().getWidth();
/* 182 */     y1 = getEntiteRelation().getY();
/* 183 */     x2 = getEntiteRelation().getX() + getEntiteRelation().getWidth();
/* 184 */     y2 = getEntiteRelation().getY() + getEntiteRelation().getHeight();
/*     */     
/* 186 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/* 187 */       this.cote = 3;
/* 188 */       return;
/*     */     }
/*     */     
/* 191 */     x1 = getEntiteRelation().getX();
/* 192 */     y1 = getEntiteRelation().getY() + getEntiteRelation().getHeight();
/* 193 */     x2 = getEntiteRelation().getX() + getEntiteRelation().getWidth();
/* 194 */     y2 = getEntiteRelation().getY() + getEntiteRelation().getHeight();
/*     */     
/* 196 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/* 197 */       this.cote = 4;
/* 198 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   private Point getLastPoint() {
/* 203 */     if (this.pointCassure.size() == 0) {
/* 204 */       return new Point(getCommentaire().getCentreX(), getCommentaire().getCentreY());
/*     */     }
/* 206 */     return ((IhmPoint)this.pointCassure.get(0)).getPoint();
/*     */   }
/*     */   
/*     */   private boolean segmentSelect(int xs, int ys, int xt, int yt, int xx, int yy)
/*     */   {
/* 211 */     if (Line2D.linesIntersect(xs, ys, xt, yt, xx - 5, yy - 5, xx + 5, yy + 5)) return true;
/* 212 */     if (Line2D.linesIntersect(xs, ys, xt, yt, xx + 5, yy - 5, xx - 5, yy + 5)) return true;
/* 213 */     return false;
/*     */   }
/*     */   
/*     */   private boolean listePointEdentique(ArrayList<IhmPoint> liste) {
/* 217 */     if (liste.size() != this.pointCassure.size()) return false;
/* 218 */     for (int i = 0; i < liste.size(); i++) {
/* 219 */       if ((((IhmPoint)liste.get(i)).getX() != ((IhmPoint)this.pointCassure.get(i)).getX()) || (((IhmPoint)liste.get(i)).getY() != ((IhmPoint)this.pointCassure.get(i)).getY())) return false;
/*     */     }
/* 221 */     return true;
/*     */   }
/*     */   
/*     */   public boolean egale(IhmLienCommentaire2 lien) {
/* 225 */     if ((lien.getEntiteRelation() != getEntiteRelation()) || (getCommentaire() != lien.getCommentaire())) return false;
/* 226 */     return listePointEdentique(lien.getPointCassure());
/*     */   }
/*     */   
/*     */   public void supprimerPointSelectionner() {
/* 230 */     int nb = this.pointCassure.size();
/* 231 */     int i = 0;
/* 232 */     while (i < nb) {
/* 233 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/* 234 */         this.pointCassure.remove(i);
/* 235 */         nb--;
/*     */       } else {
/* 237 */         i++;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean deplacerPointSelectionner(int x, int y) {
/* 243 */     int nb = this.pointCassure.size();
/* 244 */     boolean dep = false;
/* 245 */     for (int i = 0; i < nb; i++) {
/* 246 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/* 247 */         dep = true;
/* 248 */         ((IhmPoint)this.pointCassure.get(i)).move(((IhmPoint)this.pointCassure.get(i)).getX() - x, ((IhmPoint)this.pointCassure.get(i)).getY() - y);
/*     */       }
/*     */     }
/* 251 */     return dep;
/*     */   }
/*     */   
/*     */   public int XMaxPointSelectionner() {
/* 255 */     int nb = this.pointCassure.size();
/* 256 */     int xg = 0;
/* 257 */     for (int i = 0; i < nb; i++) {
/* 258 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/* 259 */         (xg < ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth())) {
/* 260 */         xg = ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth();
/*     */       }
/*     */     }
/*     */     
/* 264 */     return xg;
/*     */   }
/*     */   
/*     */   public int YMaxPointSelectionner() {
/* 268 */     int nb = this.pointCassure.size();
/* 269 */     int xg = 0;
/* 270 */     for (int i = 0; i < nb; i++) {
/* 271 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/* 272 */         (xg < ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight())) {
/* 273 */         xg = ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight();
/*     */       }
/*     */     }
/*     */     
/* 277 */     return xg;
/*     */   }
/*     */   
/*     */   public int XMaxAllPoint() {
/* 281 */     int nb = this.pointCassure.size();
/* 282 */     int xg = 0;
/* 283 */     for (int i = 0; i < nb; i++)
/*     */     {
/* 285 */       if (xg < ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth()) {
/* 286 */         xg = ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth();
/*     */       }
/*     */     }
/*     */     
/* 290 */     return xg;
/*     */   }
/*     */   
/*     */   public int YMaxAllPoint() {
/* 294 */     int nb = this.pointCassure.size();
/* 295 */     int xg = 0;
/* 296 */     for (int i = 0; i < nb; i++)
/*     */     {
/* 298 */       if (xg < ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight()) {
/* 299 */         xg = ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight();
/*     */       }
/*     */     }
/*     */     
/* 303 */     return xg;
/*     */   }
/*     */   
/*     */   public int XMinPointSelectionner() {
/* 307 */     int nb = this.pointCassure.size();
/* 308 */     int xg = Integer.MAX_VALUE;
/* 309 */     for (int i = 0; i < nb; i++) {
/* 310 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/* 311 */         (xg > ((IhmPoint)this.pointCassure.get(i)).getX())) {
/* 312 */         xg = ((IhmPoint)this.pointCassure.get(i)).getX();
/*     */       }
/*     */     }
/*     */     
/* 316 */     return xg;
/*     */   }
/*     */   
/*     */   public int YMinPointSelectionner() {
/* 320 */     int nb = this.pointCassure.size();
/* 321 */     int xg = Integer.MAX_VALUE;
/* 322 */     for (int i = 0; i < nb; i++) {
/* 323 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/* 324 */         (xg > ((IhmPoint)this.pointCassure.get(i)).getY())) {
/* 325 */         xg = ((IhmPoint)this.pointCassure.get(i)).getY();
/*     */       }
/*     */     }
/*     */     
/* 329 */     return xg; }
/*     */   
/*     */   private double tangeanteEntite() {
/*     */     int xt;
/*     */     int yt;
/* 334 */     if (this.pointCassure.size() == 0) {
/* 335 */       xt = getCommentaire().getCentreX();
/* 336 */       yt = getCommentaire().getCentreY();
/*     */     } else {
/* 338 */       xt = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/* 339 */       yt = ((IhmPoint)this.pointCassure.get(0)).getYCentre();
/*     */     }
/* 341 */     double d1 = getEntiteRelation().getCentreX() - xt;
/* 342 */     double d2 = getEntiteRelation().getCentreY() - yt;
/* 343 */     return d2 / d1;
/*     */   }
/*     */   
/*     */   private boolean isEntiteMemeX()
/*     */   {
/* 348 */     int x = getCommentaire().getCentreX();
/*     */     
/* 350 */     if (this.pointCassure.size() > 0) {
/* 351 */       x = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/*     */     }
/* 353 */     if (getEntiteRelation().getCentreX() == x) return true;
/* 354 */     return false;
/*     */   }
/*     */   
/*     */   private void calculPointCardinaliteMemeXEntite()
/*     */   {
/* 359 */     int x = getEntiteRelation().getCentreX();
/* 360 */     if (this.cote == 2) {
/* 361 */       this.xCard = x;
/* 362 */       this.yCard = getEntiteRelation().getY();
/*     */     }
/*     */     
/* 365 */     if (this.cote == 4) {
/* 366 */       this.xCard = x;
/*     */       
/* 368 */       this.yCard = (getEntiteRelation().getY() + getEntiteRelation().getHeight());
/* 369 */       if (getEntiteRelation().isOmbre()) { this.yCard += 3;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void calculPointCardinaliteEntite()
/*     */   {
/* 376 */     if (isEntiteMemeX()) {
/* 377 */       calculPointCardinaliteMemeXEntite();
/*     */     }
/*     */     else {
/* 380 */       double tag = tangeanteEntite();
/* 381 */       this.tangente = tag;
/* 382 */       int y1 = getEntiteRelation().getCentreY();
/* 383 */       int x1 = getEntiteRelation().getCentreX();
/* 384 */       if (this.cote == 1) {
/* 385 */         this.xCard = getEntiteRelation().getX();
/* 386 */         this.yCard = ((int)(tag * this.xCard + (y1 - tag * x1)));
/*     */       }
/*     */       
/*     */ 
/* 390 */       if (this.cote == 3) {
/* 391 */         this.xCard = (getEntiteRelation().getX() + getEntiteRelation().getWidth());
/* 392 */         if (getEntiteRelation().isOmbre()) this.xCard += 3;
/* 393 */         this.yCard = ((int)(tag * this.xCard + (y1 - tag * x1)));
/*     */       }
/*     */       
/* 396 */       if (this.cote == 2) {
/* 397 */         int dec = (int)(15.0D - Math.abs(Math.atan(this.tangente)) * 10.0D);
/* 398 */         this.yCard = getEntiteRelation().getY();
/* 399 */         if (getEntiteRelation().isOmbre()) this.yCard += 3;
/* 400 */         this.xCard = ((int)((this.yCard - (y1 - tag * x1)) / tag));
/*     */       }
/*     */       
/* 403 */       if (this.cote == 4) {
/* 404 */         this.yCard = (getEntiteRelation().getY() + getEntiteRelation().getHeight());
/*     */         
/* 406 */         if (getEntiteRelation().isOmbre()) { this.yCard += 4;
/*     */         }
/* 408 */         this.xCard = ((int)((this.yCard - (y1 - tag * x1)) / tag));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void calculerXYCardianlite() {
/* 414 */     coteIntersectionEntite();
/* 415 */     calculPointCardinaliteEntite();
/*     */   }
/*     */   
/*     */   public boolean estDans(int xd, int yd, int xf, int yf) {
/* 419 */     if (getPointCassure().size() > 0) {
/* 420 */       for (int i = 0; i < getPointCassure().size(); i++) {
/* 421 */         if (!((IhmPoint)getPointCassure().get(i)).isSelected()) return false;
/*     */       }
/* 423 */       return true;
/*     */     }
/*     */     
/* 426 */     int x1 = xd;
/* 427 */     int x2 = xf;
/* 428 */     int y1 = yd;
/* 429 */     int y2 = yf;
/* 430 */     if (xd > xf) {
/* 431 */       x1 = xf;
/* 432 */       x2 = xd;
/*     */     }
/* 434 */     if (yd > yf) {
/* 435 */       y1 = yf;
/* 436 */       y2 = yd;
/*     */     }
/* 438 */     Rectangle2D rec = new Rectangle2D.Double(x1, y1, x2 - x1, y2 - y1);
/* 439 */     if ((rec.contains(getEntiteRelation().getCentreX(), getEntiteRelation().getCentreY())) && (rec.contains(getCommentaire().getCentreX(), getCommentaire().getCentreY())))
/* 440 */       return true;
/* 441 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean addBreakPoint(int x, int y)
/*     */   {
/* 448 */     int xs = getEntiteRelation().getCentreX();
/* 449 */     int ys = getEntiteRelation().getCentreY();
/* 450 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 451 */       int xt = ((IhmPoint)this.pointCassure.get(i)).getPoint().getX();
/* 452 */       int yt = ((IhmPoint)this.pointCassure.get(i)).getPoint().getY();
/* 453 */       if (segmentSelect(xs, ys, xt, yt, x, y)) {
/* 454 */         IhmPoint p = new IhmPoint(x, y);
/* 455 */         this.pointCassure.add(i, p);
/* 456 */         p.setSelected(true);
/* 457 */         return true;
/*     */       }
/* 459 */       xs = xt;
/* 460 */       ys = yt;
/*     */     }
/* 462 */     if (segmentSelect(xs, ys, getCommentaire().getCentreX(), getCommentaire().getCentreY(), x, y)) {
/* 463 */       IhmPoint p = new IhmPoint(x, y);
/* 464 */       this.pointCassure.add(p);
/* 465 */       p.setSelected(true);
/* 466 */       return true;
/*     */     }
/* 468 */     return false;
/*     */   }
/*     */   
/*     */   private Point rotation(double x, double y, double tg) {
/* 472 */     Point p = new Point(0, 0);
/* 473 */     double x1 = 0.0D;double y1 = 0.0D;double rac = 0.0D;
/* 474 */     rac = Math.sqrt(Math.pow(tg, 2.0D) + 1.0D);
/* 475 */     x1 = (x - y * tg) / rac;
/* 476 */     y1 = (y + x * tg) / rac;
/* 477 */     p.setX((int)x1);
/* 478 */     p.setY((int)y1);
/* 479 */     return p;
/*     */   }
/*     */   
/*     */   public void dessinerFleche(Graphics2D gr) {
/* 483 */     gr.setColor(this.clFond2);
/* 484 */     if (isActiver()) gr.setColor(getClActiver());
/* 485 */     if (isSelect()) { gr.setColor(getClSelected());
/*     */     }
/* 487 */     Point lp = getLastPoint();
/*     */     
/* 489 */     if (isEntiteMemeX()) {
/* 490 */       if (this.cote == 2) {
/* 491 */         int[] x = new int[3];
/* 492 */         int[] y = new int[3];
/* 493 */         int xfleche = 5;
/* 494 */         int yfleche = 10;
/* 495 */         x[0] = getEntiteRelation().getCentreX();
/* 496 */         y[0] = getEntiteRelation().getY();
/*     */         
/* 498 */         x[1] = (x[0] - xfleche);
/* 499 */         y[1] = (y[0] - yfleche);
/*     */         
/* 501 */         x[2] = (x[0] + xfleche);
/* 502 */         y[2] = (y[0] - yfleche);
/*     */         
/* 504 */         gr.fillPolygon(x, y, 3);
/*     */       }
/*     */       
/* 507 */       if (this.cote == 4) {
/* 508 */         int[] x = new int[3];
/* 509 */         int[] y = new int[3];
/* 510 */         int xfleche = 5;
/* 511 */         int yfleche = 10;
/* 512 */         x[0] = getEntiteRelation().getCentreX();
/* 513 */         y[0] = (getEntiteRelation().getY() + getEntiteRelation().getHeight());
/*     */         
/* 515 */         x[1] = (x[0] - xfleche);
/* 516 */         y[1] = (y[0] + yfleche);
/*     */         
/* 518 */         x[2] = (x[0] + xfleche);
/* 519 */         y[2] = (y[0] + yfleche);
/*     */         
/* 521 */         gr.fillPolygon(x, y, 3);
/*     */       }
/* 523 */       return;
/*     */     }
/*     */     
/* 526 */     double tan = getEntiteRelation().getCentreY() - lp.getY();
/* 527 */     tan /= (getEntiteRelation().getCentreX() - lp.getX());
/*     */     
/* 529 */     int[] x = new int[3];
/* 530 */     int[] y = new int[3];
/*     */     
/*     */ 
/*     */ 
/* 534 */     int posi = this.cote;
/*     */     
/* 536 */     Point p = new Point(this.xCard, this.yCard);
/*     */     
/*     */ 
/* 539 */     int xfleche = 10;
/* 540 */     int yfleche = 5;
/*     */     
/* 542 */     x[0] = p.getX();
/* 543 */     y[0] = p.getY();
/* 544 */     int dx = x[0];
/* 545 */     int dy = y[0];
/* 546 */     p = rotation(x[0], y[0], tan);
/* 547 */     dx -= p.getX();
/* 548 */     dy -= p.getY();
/*     */     
/*     */ 
/* 551 */     if (posi == 1)
/*     */     {
/* 553 */       x[0] = (p.getX() + dx);
/* 554 */       y[0] = (p.getY() + dy);
/*     */       
/* 556 */       p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/* 557 */       x[1] = p.getX();
/* 558 */       y[1] = p.getY();
/*     */       
/* 560 */       x[1] += dx;
/* 561 */       y[1] += dy;
/*     */       
/* 563 */       p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/* 564 */       x[2] = (p.getX() + dx);
/* 565 */       y[2] = (p.getY() + dy);
/*     */       
/* 567 */       gr.fillPolygon(x, y, 3);
/*     */     }
/* 569 */     if (posi == 3) {
/* 570 */       x[0] = (p.getX() + dx);
/* 571 */       y[0] = (p.getY() + dy);
/*     */       
/* 573 */       p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/* 574 */       x[1] = p.getX();
/* 575 */       y[1] = p.getY();
/*     */       
/* 577 */       x[1] += dx;
/* 578 */       y[1] += dy;
/*     */       
/*     */ 
/* 581 */       p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/* 582 */       x[2] = (p.getX() + dx);
/* 583 */       y[2] = (p.getY() + dy);
/*     */       
/* 585 */       gr.fillPolygon(x, y, 3);
/*     */     }
/*     */     
/* 588 */     if (posi == 4) {
/* 589 */       if (getEntiteRelation().getCentreX() < lp.getX()) {
/* 590 */         x[0] = (p.getX() + dx);
/* 591 */         y[0] = (p.getY() + dy);
/*     */         
/* 593 */         p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/* 594 */         x[1] = (p.getX() + dx);
/* 595 */         y[1] = (p.getY() + dy);
/*     */         
/* 597 */         p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/* 598 */         x[2] = (p.getX() + dx);
/* 599 */         y[2] = (p.getY() + dy);
/*     */       } else {
/* 601 */         x[0] = (p.getX() + dx);
/* 602 */         y[0] = (p.getY() + dy);
/*     */         
/* 604 */         p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/* 605 */         x[1] = (p.getX() + dx);
/* 606 */         y[1] = (p.getY() + dy);
/*     */         
/* 608 */         p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/* 609 */         x[2] = (p.getX() + dx);
/* 610 */         y[2] = (p.getY() + dy);
/*     */       }
/*     */       
/* 613 */       gr.fillPolygon(x, y, 3);
/*     */     }
/*     */     
/* 616 */     if (posi == 2) {
/* 617 */       if (getEntiteRelation().getCentreX() > lp.getX()) {
/* 618 */         tan = lp.getY() - getEntiteRelation().getCentreY();
/* 619 */         tan /= (lp.getX() - getEntiteRelation().getCentreX());
/*     */         
/* 621 */         x[0] = (p.getX() + dx);
/* 622 */         y[0] = (p.getY() + dy);
/*     */         
/* 624 */         p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/* 625 */         x[1] = p.getX();
/* 626 */         y[1] = p.getY();
/*     */         
/* 628 */         x[1] += dx;
/* 629 */         y[1] += dy;
/*     */         
/* 631 */         p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/* 632 */         x[2] = (p.getX() + dx);
/* 633 */         y[2] = (p.getY() + dy);
/*     */       }
/*     */       else {
/* 636 */         x[0] = (p.getX() + dx);
/* 637 */         y[0] = (p.getY() + dy);
/*     */         
/* 639 */         p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/* 640 */         x[1] = p.getX();
/* 641 */         y[1] = p.getY();
/*     */         
/* 643 */         x[1] += dx;
/* 644 */         y[1] += dy;
/*     */         
/* 646 */         p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/* 647 */         x[2] = (p.getX() + dx);
/* 648 */         y[2] = (p.getY() + dy);
/*     */       }
/* 650 */       gr.fillPolygon(x, y, 3);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSelected(boolean selected)
/*     */   {
/* 662 */     super.setSelected(selected);
/*     */     
/* 664 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 665 */       ((IhmPoint)this.pointCassure.get(i)).setDesigner(selected);
/* 666 */       if (!selected) {
/* 667 */         ((IhmPoint)this.pointCassure.get(i)).setSelected(false);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IhmPoint getSelectedPointCassure(int x, int y)
/*     */   {
/* 674 */     IhmPoint p = null;
/* 675 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 676 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected(x, y)) {
/* 677 */         p = (IhmPoint)this.pointCassure.get(i);
/*     */       }
/*     */     }
/* 680 */     return p;
/*     */   }
/*     */   
/*     */   public boolean isSelected(int x, int y)
/*     */   {
/* 685 */     if (getSelectedPointCassure(x, y) != null) { return true;
/*     */     }
/*     */     
/*     */ 
/* 689 */     int xs = getEntiteRelation().getCentreX();
/* 690 */     int ys = getEntiteRelation().getCentreY();
/* 691 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 692 */       int xt = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/* 693 */       int yt = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/* 694 */       if (segmentSelect(xs, ys, xt, yt, x, y)) {
/* 695 */         return true;
/*     */       }
/* 697 */       xs = xt;
/* 698 */       ys = yt;
/*     */     }
/*     */     
/* 701 */     int xt = getCommentaire().getCentreX();
/* 702 */     int yt = getCommentaire().getCentreY();
/*     */     
/* 704 */     return segmentSelect(xs, ys, xt, yt, x, y);
/*     */   }
/*     */   
/*     */   public boolean isSelected()
/*     */   {
/* 709 */     return super.isSelect();
/*     */   }
/*     */   
/*     */   public IhmEntiteRelation getEntiteRelation() {
/* 713 */     return getEntRel();
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> getHistorique() {
/* 717 */     return this.historique;
/*     */   }
/*     */   
/*     */   public ArrayList<IhmPoint> getPointCassure() {
/* 721 */     return this.pointCassure;
/*     */   }
/*     */   
/*     */   public Color getClSelected() {
/* 725 */     return this.clSelected;
/*     */   }
/*     */   
/*     */   public void setClSelected(Color clSelected) {
/* 729 */     this.clSelected = clSelected;
/*     */   }
/*     */   
/*     */   public void setHistorique(ArrayList<Historique> historique) {
/* 733 */     this.historique = historique;
/*     */   }
/*     */   
/*     */   public void setPointCassure(ArrayList<IhmPoint> pointCassure) {
/* 737 */     this.pointCassure = pointCassure;
/*     */   }
/*     */   
/*     */   public boolean isActiver()
/*     */   {
/* 742 */     return this.activer;
/*     */   }
/*     */   
/*     */   public Color getClActiver() {
/* 746 */     return this.clActiver;
/*     */   }
/*     */   
/*     */   public float getEpaisseur() {
/* 750 */     return this.epaisseur;
/*     */   }
/*     */   
/*     */   public Color getClFond2() {
/* 754 */     return this.clFond2;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 758 */     return this.code;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getCommentaireS()
/*     */   {
/* 764 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public int getCote() {
/* 768 */     return this.cote;
/*     */   }
/*     */   
/*     */   public double getTangente()
/*     */   {
/* 773 */     return this.tangente;
/*     */   }
/*     */   
/*     */   public int getxCard() {
/* 777 */     return this.xCard;
/*     */   }
/*     */   
/*     */   public int getyCard() {
/* 781 */     return this.yCard;
/*     */   }
/*     */   
/*     */   public double getZoom() {
/* 785 */     return this.zoom;
/*     */   }
/*     */   
/*     */   public void setActiver(boolean activer) {
/* 789 */     this.activer = activer;
/*     */   }
/*     */   
/*     */   public void setClActiver(Color clActiver) {
/* 793 */     this.clActiver = clActiver;
/*     */   }
/*     */   
/*     */   public void setClFond2(Color clFond2) {
/* 797 */     this.clFond2 = clFond2;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 801 */     this.code = code;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String commentaire) {
/* 805 */     this.commentaire = commentaire;
/*     */   }
/*     */   
/*     */   public void setCote(int cote) {
/* 809 */     this.cote = cote;
/*     */   }
/*     */   
/*     */   public void setEpaisseur(float epaisseur) {
/* 813 */     this.epaisseur = epaisseur;
/*     */   }
/*     */   
/*     */   public void setTangente(double tangente) {
/* 817 */     this.tangente = tangente;
/*     */   }
/*     */   
/*     */   public void setxCard(int xCard) {
/* 821 */     this.xCard = xCard;
/*     */   }
/*     */   
/*     */   public void setyCard(int yCard) {
/* 825 */     this.yCard = yCard;
/*     */   }
/*     */   
/*     */   public void setZoom(double zoom) {
/* 829 */     this.zoom = zoom;
/*     */   }
/*     */   
/*     */   public ArrayList<IhmPoint> copierListePointDeCassure() {
/* 833 */     ArrayList<IhmPoint> liste = new ArrayList();
/* 834 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 835 */       IhmPoint p = ((IhmPoint)this.pointCassure.get(i)).copier();
/* 836 */       p.setX(p.getX() + 10);
/* 837 */       p.setY(p.getY() + 10);
/* 838 */       p.setSelected(true);
/* 839 */       liste.add(p);
/*     */     }
/* 841 */     return liste;
/*     */   }
/*     */   
/* 844 */   public void ajouterCopier(ArrayList<Historique> lhis) { Historique h = Historique.getHistoriqueCopie();
/* 845 */     Historique h1 = (Historique)lhis.get(lhis.size() - 1);
/* 846 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur())) || (!h.getAction().equals(h1.getAction())))
/*     */     {
/* 848 */       lhis.add(h);
/*     */     }
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> copierHistoriques(ArrayList<Historique> lhis) {
/* 853 */     ArrayList<Historique> l = new ArrayList();
/* 854 */     for (int i = 0; i < lhis.size(); i++) {
/* 855 */       l.add(((Historique)lhis.get(i)).copier());
/*     */     }
/* 857 */     return l;
/*     */   }
/*     */   
/*     */   public IhmLienCommentaire2 copier(IhmCommentaire2 com, IhmEntiteRelation rel) {
/* 861 */     IhmLienCommentaire2 l = new IhmLienCommentaire2(rel, com);
/* 862 */     l.setClFond2(getClFond2());
/* 863 */     l.setClActiver(getClActiver());
/* 864 */     l.setClLien(getClLien());
/* 865 */     l.setNom(getNom());
/* 866 */     l.setCode(getCode());
/* 867 */     l.setCommentaire(getCommentaireS());
/* 868 */     l.setPointCassure(copierListePointDeCassure());
/* 869 */     l.setHistorique(copierHistoriques(this.historique));
/* 870 */     ajouterCopier(l.getHistorique());
/* 871 */     return l;
/*     */   }
/*     */   
/*     */   public static IhmLienCommentaire2 parseLienCommentaire(IhmLienCommentaire lien, IhmCommentaireIndip comm, IhmEntiteRelation rel) {
/* 875 */     IhmLienCommentaire2 l = new IhmLienCommentaire2(rel, comm);
/* 876 */     l.setCommentaire("");
/* 877 */     l.setNom(lien.getNom());
/* 878 */     if (lien.isCassure()) {
/* 879 */       l.getPointCassure().add(new IhmPoint((int)lien.getxCassure(), (int)lien.getyCassure()));
/*     */     }
/*     */     
/* 882 */     return l;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmLienCommentaire2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */