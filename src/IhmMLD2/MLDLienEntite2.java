/*      */ package IhmMLD2;
/*      */ 
/*      */ import IhmMCD.Point;
/*      */ import IhmMCD2.IhmPoint;
/*      */ import Merise2.Historique;
/*      */ import Outil.Setting;
/*      */ import ihm.FormeInterneMCD;
/*      */ import java.awt.BasicStroke;
/*      */ import java.awt.Color;
/*      */ import java.awt.FontMetrics;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.Stroke;
/*      */ import java.awt.geom.Line2D;
/*      */ import java.awt.geom.Rectangle2D;
/*      */ import java.awt.geom.Rectangle2D.Double;
/*      */ import java.io.Serializable;
/*      */ import java.util.ArrayList;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class MLDLienEntite2
/*      */   implements Serializable
/*      */ {
/*      */   MLDEntite2 source;
/*      */   MLDEntite2 cible;
/*      */   boolean fleche;
/*      */   String nom;
/*      */   String code;
/*      */   String commentaire;
/*      */   private Color clLien;
/*      */   private Color clLienText;
/*      */   private Color clLienFondText;
/*      */   private Color clLienActiver;
/*      */   private Color clLienSelect;
/*      */   ArrayList<IhmPoint> pointCassure;
/*      */   ArrayList<Historique> historique;
/*      */   private double zoom;
/*      */   private double tangente;
/*      */   private boolean activer;
/*      */   private boolean selected;
/*      */   int xCard;
/*      */   int yCard;
/*      */   private int cote;
/*      */   public static final int COTEDROIT = 3;
/*      */   public static final int COTEHAUT = 2;
/*      */   public static final int COTEGAUCHE = 1;
/*      */   public static final int COTEBAS = 4;
/*      */   float epaisseur;
/*      */   Point xyNom;
/*      */   Point whNom;
/*      */   boolean discontinue;
/*      */   
/*      */   public MLDLienEntite2(MLDEntite2 source, MLDEntite2 cible)
/*      */   {
/*   72 */     this.cible = cible;
/*   73 */     this.source = source;
/*   74 */     this.nom = "";
/*      */     
/*   76 */     this.code = "";
/*   77 */     this.commentaire = "";
/*      */     
/*   79 */     this.clLien = FormeInterneMCD.clLien2;
/*   80 */     this.clLienText = FormeInterneMCD.clLienText2;
/*   81 */     this.clLienFondText = FormeInterneMCD.clPage2;
/*      */     
/*   83 */     this.clLienSelect = FormeInterneMCD.clSelected;
/*   84 */     this.clLienActiver = FormeInterneMCD.clLienActiver2;
/*      */     
/*   86 */     this.fleche = false;
/*   87 */     this.zoom = FormeInterneMCD.zoom;
/*   88 */     this.tangente = 1.0D;
/*   89 */     this.activer = false;
/*      */     
/*   91 */     this.pointCassure = new ArrayList();
/*   92 */     this.historique = new ArrayList();
/*   93 */     this.historique.add(Historique.getHistoriqueCreation());
/*   94 */     this.selected = false;
/*   95 */     this.epaisseur = FormeInterneMCD.lienEntiteRelation2;
/*   96 */     this.xyNom = new Point(0, 0);
/*   97 */     this.whNom = new Point(0, 0);
/*   98 */     this.discontinue = false;
/*      */   }
/*      */   
/*      */   public void paint(Graphics g) {
/*  102 */     Graphics2D g2d = (Graphics2D)g;
/*  103 */     dessinerLien(g2d);
/*  104 */     if (!isFleche()) {
/*  105 */       calculerXYCardianlite();
/*      */     }
/*  107 */     dessinerNomLien(g2d);
/*  108 */     if (isSelected()) {
/*  109 */       DessinerTousLesPointSansLien(g2d);
/*      */     }
/*      */   }
/*      */   
/*      */   private void calculerWHNom(Graphics2D g)
/*      */   {
/*  115 */     String n = getNom();
/*  116 */     if (n.trim().length() == 0) return;
/*  117 */     int h = g.getFontMetrics().getHeight();
/*  118 */     int w = g.getFontMetrics().stringWidth(n + ".");
/*  119 */     this.whNom.setX(w);
/*  120 */     this.whNom.setY(h);
/*      */   }
/*      */   
/*      */   private void calculerXYNom() {
/*  124 */     String n = getNom();
/*  125 */     if (n.trim().length() == 0) return;
/*  126 */     if (this.pointCassure.size() == 0) {
/*  127 */       Point p = getPointIntersectSource();
/*  128 */       int x = (this.xCard + p.getX()) / 2;
/*  129 */       int y = (this.yCard + p.getY()) / 2;
/*  130 */       this.xyNom.setX(x);
/*  131 */       this.xyNom.setY(y);
/*  132 */       return;
/*      */     }
/*      */     
/*  135 */     if (this.pointCassure.size() == 1) {
/*  136 */       int x = (this.xCard + ((IhmPoint)this.pointCassure.get(0)).getXCentre()) / 2;
/*  137 */       int y = (this.yCard + ((IhmPoint)this.pointCassure.get(0)).getYCentre()) / 2;
/*  138 */       this.xyNom.setX(x);
/*  139 */       this.xyNom.setY(y);
/*  140 */       return;
/*      */     }
/*      */     
/*  143 */     if (this.pointCassure.size() > 1) {
/*  144 */       int x = (((IhmPoint)this.pointCassure.get(0)).getXCentre() + ((IhmPoint)this.pointCassure.get(1)).getXCentre()) / 2;
/*  145 */       int y = (((IhmPoint)this.pointCassure.get(0)).getYCentre() + ((IhmPoint)this.pointCassure.get(1)).getYCentre()) / 2;
/*  146 */       this.xyNom.setX(x);
/*  147 */       this.xyNom.setY(y);
/*  148 */       return;
/*      */     }
/*      */   }
/*      */   
/*      */   public void setClLienFondText(Color clLienFondText) {
/*  153 */     this.clLienFondText = clLienFondText;
/*      */   }
/*      */   
/*      */   public void supprimerPointDeCassureSelcted() {
/*  157 */     int i = 0;
/*  158 */     while ((i < this.pointCassure.size()) && 
/*  159 */       (isPointDeCassureDeleted())) {
/*  160 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/*  161 */         this.pointCassure.remove(i);
/*      */       } else {
/*  163 */         i++;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isPointDeCassureDeleted() {
/*  169 */     if (getSource() != getCible()) return true;
/*  170 */     if (this.pointCassure.size() > 2) return true;
/*  171 */     return false;
/*      */   }
/*      */   
/*      */   private void dessinerNomLien(Graphics2D g)
/*      */   {
/*  176 */     if (getNom().trim().length() == 0) return;
/*  177 */     if (!Setting.MLDAfficherNomLien2) return;
/*  178 */     calculerXYNom();
/*  179 */     calculerWHNom(g);
/*  180 */     int x = this.xyNom.getX() - this.whNom.getX() / 2;
/*  181 */     g.setColor(this.clLienFondText);
/*      */     
/*  183 */     g.fillRect(x, this.xyNom.getY() - this.whNom.getY() / 2, this.whNom.getX() + 3, this.whNom.getY() + 1);
/*  184 */     g.setColor(this.clLienText);
/*  185 */     if (isSelected()) g.setColor(this.clLienSelect);
/*  186 */     if (isActiver()) g.setColor(this.clLienActiver);
/*  187 */     g.drawString(getNom(), x + 3, this.xyNom.getY() - 3 + this.whNom.getY() / 2);
/*      */   }
/*      */   
/*      */   private boolean isSelectedNom(int x, int y)
/*      */   {
/*  192 */     if ((getNom().trim().length() > 0) && 
/*  193 */       (x > this.xyNom.getX() - this.whNom.getX() / 2) && (x < this.xyNom.getX() + this.whNom.getX() / 2) && (y > this.xyNom.getY() - this.whNom.getY() / 2) && (y < this.xyNom.getY() - this.whNom.getY() / 2 + this.whNom.getY())) {
/*  194 */       return true;
/*      */     }
/*  196 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   private void coteIntersectionEntite()
/*      */   {
/*  202 */     int xe = this.cible.getCentreX();
/*  203 */     int ye = this.cible.getCentreY();
/*      */     
/*  205 */     int xr = this.source.getCentreX();
/*  206 */     int yr = this.source.getCentreY();
/*      */     
/*  208 */     if (this.pointCassure.size() > 0) {
/*  209 */       xr = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/*  210 */       yr = ((IhmPoint)this.pointCassure.get(0)).getYCentre();
/*      */     }
/*      */     
/*  213 */     int x1 = this.cible.getX();
/*  214 */     int y1 = this.cible.getY();
/*  215 */     int x2 = this.cible.getX();
/*  216 */     int y2 = this.cible.getY() + this.cible.getHeight();
/*      */     
/*  218 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/*  219 */       this.cote = 1;
/*  220 */       return;
/*      */     }
/*      */     
/*  223 */     x1 = this.cible.getX();
/*  224 */     y1 = this.cible.getY();
/*  225 */     x2 = this.cible.getX() + this.cible.getWidth();
/*  226 */     y2 = this.cible.getY();
/*      */     
/*  228 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/*  229 */       this.cote = 2;
/*  230 */       return;
/*      */     }
/*      */     
/*  233 */     x1 = this.cible.getX() + this.cible.getWidth();
/*  234 */     y1 = this.cible.getY();
/*  235 */     x2 = this.cible.getX() + this.cible.getWidth();
/*  236 */     y2 = this.cible.getY() + this.cible.getHeight();
/*      */     
/*  238 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/*  239 */       this.cote = 3;
/*  240 */       return;
/*      */     }
/*      */     
/*  243 */     x1 = this.cible.getX();
/*  244 */     y1 = this.cible.getY() + this.cible.getHeight();
/*  245 */     x2 = this.cible.getX() + this.cible.getWidth();
/*  246 */     y2 = this.cible.getY() + this.cible.getHeight();
/*      */     
/*  248 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/*  249 */       this.cote = 4;
/*  250 */       return;
/*      */     }
/*      */   }
/*      */   
/*      */   private Point getLastPoint() {
/*  255 */     if (this.pointCassure.size() == 0) {
/*  256 */       return new Point(this.source.getCentreX(), this.source.getCentreY());
/*      */     }
/*  258 */     return ((IhmPoint)this.pointCassure.get(0)).getPoint();
/*      */   }
/*      */   
/*      */   private boolean segmentSelect(int xs, int ys, int xt, int yt, int xx, int yy)
/*      */   {
/*  263 */     if (Line2D.linesIntersect(xs, ys, xt, yt, xx - 5, yy - 5, xx + 5, yy + 5)) return true;
/*  264 */     if (Line2D.linesIntersect(xs, ys, xt, yt, xx + 5, yy - 5, xx - 5, yy + 5)) return true;
/*  265 */     return false;
/*      */   }
/*      */   
/*      */   private boolean listePointEdentique(ArrayList<IhmPoint> liste) {
/*  269 */     if (liste.size() != this.pointCassure.size()) return false;
/*  270 */     for (int i = 0; i < liste.size(); i++) {
/*  271 */       if ((((IhmPoint)liste.get(i)).getX() != ((IhmPoint)this.pointCassure.get(i)).getX()) || (((IhmPoint)liste.get(i)).getY() != ((IhmPoint)this.pointCassure.get(i)).getY())) return false;
/*      */     }
/*  273 */     return true;
/*      */   }
/*      */   
/*      */   public boolean egale(MLDLienEntite2 lien)
/*      */   {
/*  278 */     if ((lien.cible != this.cible) || (this.source != lien.source)) return false;
/*  279 */     return listePointEdentique(lien.getPointCassure());
/*      */   }
/*      */   
/*      */   public void supprimerPointSelectionner() {
/*  283 */     int nb = this.pointCassure.size();
/*  284 */     int i = 0;
/*  285 */     while (i < nb) {
/*  286 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/*  287 */         this.pointCassure.remove(i);
/*  288 */         nb--;
/*      */       } else {
/*  290 */         i++;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean deplacerPointSelectionner(int x, int y) {
/*  296 */     int nb = this.pointCassure.size();
/*  297 */     boolean dep = false;
/*  298 */     for (int i = 0; i < nb; i++) {
/*  299 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/*  300 */         dep = true;
/*  301 */         ((IhmPoint)this.pointCassure.get(i)).move(((IhmPoint)this.pointCassure.get(i)).getX() - x, ((IhmPoint)this.pointCassure.get(i)).getY() - y);
/*      */       }
/*      */     }
/*  304 */     return dep;
/*      */   }
/*      */   
/*      */   public int XMaxPointSelectionner() {
/*  308 */     int nb = this.pointCassure.size();
/*  309 */     int xg = 0;
/*  310 */     for (int i = 0; i < nb; i++) {
/*  311 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/*  312 */         (xg < ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth())) {
/*  313 */         xg = ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth();
/*      */       }
/*      */     }
/*      */     
/*  317 */     return xg;
/*      */   }
/*      */   
/*      */   public int YMaxPointSelectionner() {
/*  321 */     int nb = this.pointCassure.size();
/*  322 */     int xg = 0;
/*  323 */     for (int i = 0; i < nb; i++) {
/*  324 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/*  325 */         (xg < ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight())) {
/*  326 */         xg = ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight();
/*      */       }
/*      */     }
/*      */     
/*  330 */     return xg;
/*      */   }
/*      */   
/*      */   public int XMaxAllPoint() {
/*  334 */     int nb = this.pointCassure.size();
/*  335 */     int xg = 0;
/*  336 */     for (int i = 0; i < nb; i++)
/*      */     {
/*  338 */       if (xg < ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth()) {
/*  339 */         xg = ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth();
/*      */       }
/*      */     }
/*      */     
/*  343 */     return xg;
/*      */   }
/*      */   
/*      */   public int YMaxAllPoint() {
/*  347 */     int nb = this.pointCassure.size();
/*  348 */     int xg = 0;
/*  349 */     for (int i = 0; i < nb; i++)
/*      */     {
/*  351 */       if (xg < ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight()) {
/*  352 */         xg = ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight();
/*      */       }
/*      */     }
/*      */     
/*  356 */     return xg;
/*      */   }
/*      */   
/*      */   public int XMinPointSelectionner() {
/*  360 */     int nb = this.pointCassure.size();
/*  361 */     int xg = Integer.MAX_VALUE;
/*  362 */     for (int i = 0; i < nb; i++) {
/*  363 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/*  364 */         (xg > ((IhmPoint)this.pointCassure.get(i)).getX())) {
/*  365 */         xg = ((IhmPoint)this.pointCassure.get(i)).getX();
/*      */       }
/*      */     }
/*      */     
/*  369 */     return xg;
/*      */   }
/*      */   
/*      */   public int YMinPointSelectionner() {
/*  373 */     int nb = this.pointCassure.size();
/*  374 */     int xg = Integer.MAX_VALUE;
/*  375 */     for (int i = 0; i < nb; i++) {
/*  376 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/*  377 */         (xg > ((IhmPoint)this.pointCassure.get(i)).getY())) {
/*  378 */         xg = ((IhmPoint)this.pointCassure.get(i)).getY();
/*      */       }
/*      */     }
/*      */     
/*  382 */     return xg; }
/*      */   
/*      */   private double tangeanteEntite() {
/*      */     int xt;
/*      */     int yt;
/*  387 */     if (this.pointCassure.size() == 0) {
/*  388 */       xt = this.source.getCentreX();
/*  389 */       yt = this.source.getCentreY();
/*      */     } else {
/*  391 */       xt = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/*  392 */       yt = ((IhmPoint)this.pointCassure.get(0)).getYCentre();
/*      */     }
/*  394 */     double d1 = this.cible.getCentreX() - xt;
/*  395 */     double d2 = this.cible.getCentreY() - yt;
/*  396 */     return d2 / d1;
/*      */   }
/*      */   
/*      */   private boolean isEntiteMemeX()
/*      */   {
/*  401 */     int x = this.source.getCentreX();
/*      */     
/*  403 */     if (this.pointCassure.size() > 0) {
/*  404 */       x = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/*      */     }
/*  406 */     if (this.cible.getCentreX() == x) return true;
/*  407 */     return false;
/*      */   }
/*      */   
/*      */   private void calculPointCardinaliteMemeXEntite()
/*      */   {
/*  412 */     int x = this.cible.getCentreX();
/*  413 */     if (this.cote == 2) {
/*  414 */       this.xCard = x;
/*  415 */       this.yCard = this.cible.getY();
/*      */     }
/*      */     
/*  418 */     if (this.cote == 4) {
/*  419 */       this.xCard = x;
/*      */       
/*  421 */       this.yCard = (this.cible.getY() + this.cible.getHeight());
/*  422 */       if (this.cible.isOmbre()) { this.yCard += 3;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void calculPointCardinaliteEntite()
/*      */   {
/*  429 */     if (isEntiteMemeX()) {
/*  430 */       calculPointCardinaliteMemeXEntite();
/*      */     }
/*      */     else {
/*  433 */       double tag = tangeanteEntite();
/*  434 */       this.tangente = tag;
/*  435 */       int y1 = this.cible.getCentreY();
/*  436 */       int x1 = this.cible.getCentreX();
/*  437 */       if (this.cote == 1) {
/*  438 */         this.xCard = this.cible.getX();
/*  439 */         this.yCard = ((int)(tag * this.xCard + (y1 - tag * x1)));
/*      */       }
/*      */       
/*      */ 
/*  443 */       if (this.cote == 3) {
/*  444 */         this.xCard = (this.cible.getX() + this.cible.getWidth());
/*  445 */         if (this.cible.isOmbre()) this.xCard += 3;
/*  446 */         this.yCard = ((int)(tag * this.xCard + (y1 - tag * x1)));
/*      */       }
/*      */       
/*  449 */       if (this.cote == 2) {
/*  450 */         int dec = (int)(15.0D - Math.abs(Math.atan(this.tangente)) * 10.0D);
/*  451 */         this.yCard = this.cible.getY();
/*  452 */         if (this.cible.isOmbre()) this.yCard += 3;
/*  453 */         this.xCard = ((int)((this.yCard - (y1 - tag * x1)) / tag));
/*      */       }
/*      */       
/*  456 */       if (this.cote == 4) {
/*  457 */         this.yCard = (this.cible.getY() + this.cible.getHeight());
/*      */         
/*  459 */         if (this.cible.isOmbre()) { this.yCard += 4;
/*      */         }
/*  461 */         this.xCard = ((int)((this.yCard - (y1 - tag * x1)) / tag));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void calculerXYCardianlite() {
/*  467 */     coteIntersectionEntite();
/*  468 */     calculPointCardinaliteEntite();
/*      */   }
/*      */   
/*      */   public boolean estDans(int xd, int yd, int xf, int yf) {
/*  472 */     if (getPointCassure().size() > 0) {
/*  473 */       for (int i = 0; i < getPointCassure().size(); i++) {
/*  474 */         if (!((IhmPoint)getPointCassure().get(i)).isSelected()) return false;
/*      */       }
/*  476 */       return true;
/*      */     }
/*      */     
/*  479 */     int x1 = xd;
/*  480 */     int x2 = xf;
/*  481 */     int y1 = yd;
/*  482 */     int y2 = yf;
/*  483 */     if (xd > xf) {
/*  484 */       x1 = xf;
/*  485 */       x2 = xd;
/*      */     }
/*  487 */     if (yd > yf) {
/*  488 */       y1 = yf;
/*  489 */       y2 = yd;
/*      */     }
/*  491 */     Rectangle2D rec = new Rectangle2D.Double(x1, y1, x2 - x1, y2 - y1);
/*  492 */     if ((rec.contains(this.cible.getCentreX(), this.cible.getCentreY())) && (rec.contains(this.source.getCentreX(), this.source.getCentreY())))
/*  493 */       return true;
/*  494 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean addBreakPoint(int x, int y)
/*      */   {
/*  501 */     int xs = this.cible.getCentreX();
/*  502 */     int ys = this.cible.getCentreY();
/*  503 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  504 */       int xt = ((IhmPoint)this.pointCassure.get(i)).getPoint().getX();
/*  505 */       int yt = ((IhmPoint)this.pointCassure.get(i)).getPoint().getY();
/*  506 */       if (segmentSelect(xs, ys, xt, yt, x, y)) {
/*  507 */         IhmPoint p = new IhmPoint(x, y);
/*  508 */         this.pointCassure.add(i, p);
/*  509 */         p.setSelected(true);
/*  510 */         return true;
/*      */       }
/*  512 */       xs = xt;
/*  513 */       ys = yt;
/*      */     }
/*  515 */     if (segmentSelect(xs, ys, this.source.getCentreX(), this.source.getCentreY(), x, y)) {
/*  516 */       IhmPoint p = new IhmPoint(x, y);
/*  517 */       this.pointCassure.add(p);
/*  518 */       p.setSelected(true);
/*  519 */       return true;
/*      */     }
/*  521 */     return false;
/*      */   }
/*      */   
/*      */   private Point rotation(double x, double y, double tg) {
/*  525 */     Point p = new Point(0, 0);
/*  526 */     double x1 = 0.0D;double y1 = 0.0D;double rac = 0.0D;
/*  527 */     rac = Math.sqrt(Math.pow(tg, 2.0D) + 1.0D);
/*  528 */     x1 = (x - y * tg) / rac;
/*  529 */     y1 = (y + x * tg) / rac;
/*  530 */     p.setX((int)x1);
/*  531 */     p.setY((int)y1);
/*  532 */     return p;
/*      */   }
/*      */   
/*      */   public void dessinerFleche(Graphics2D gr) {
/*  536 */     gr.setColor(this.clLien);
/*  537 */     if (isActiver()) gr.setColor(getClLienActiver());
/*  538 */     if (isSelected()) { gr.setColor(getClLienSelect());
/*      */     }
/*  540 */     Point lp = getLastPoint();
/*      */     
/*  542 */     if (isEntiteMemeX()) {
/*  543 */       if (this.cote == 2) {
/*  544 */         int[] x = new int[3];
/*  545 */         int[] y = new int[3];
/*  546 */         int xfleche = 5;
/*  547 */         int yfleche = 10;
/*  548 */         x[0] = this.cible.getCentreX();
/*  549 */         y[0] = this.cible.getY();
/*      */         
/*  551 */         x[1] = (x[0] - xfleche);
/*  552 */         y[1] = (y[0] - yfleche);
/*      */         
/*  554 */         x[2] = (x[0] + xfleche);
/*  555 */         y[2] = (y[0] - yfleche);
/*      */         
/*  557 */         gr.fillPolygon(x, y, 3);
/*      */       }
/*      */       
/*  560 */       if (this.cote == 4) {
/*  561 */         int[] x = new int[3];
/*  562 */         int[] y = new int[3];
/*  563 */         int xfleche = 5;
/*  564 */         int yfleche = 10;
/*  565 */         x[0] = this.cible.getCentreX();
/*  566 */         y[0] = (this.cible.getY() + this.cible.getHeight());
/*  567 */         if (this.cible.isOmbre()) y[0] += 4;
/*  568 */         x[1] = (x[0] - xfleche);
/*  569 */         y[1] = (y[0] + yfleche);
/*      */         
/*  571 */         x[2] = (x[0] + xfleche);
/*  572 */         y[2] = (y[0] + yfleche);
/*      */         
/*  574 */         gr.fillPolygon(x, y, 3);
/*      */       }
/*  576 */       return;
/*      */     }
/*      */     
/*  579 */     double tan = this.cible.getCentreY() - lp.getY();
/*  580 */     tan /= (this.cible.getCentreX() - lp.getX());
/*      */     
/*  582 */     int[] x = new int[3];
/*  583 */     int[] y = new int[3];
/*      */     
/*      */ 
/*      */ 
/*  587 */     int posi = this.cote;
/*      */     
/*  589 */     Point p = new Point(this.xCard, this.yCard);
/*      */     
/*      */ 
/*  592 */     int xfleche = 10;
/*  593 */     int yfleche = 5;
/*      */     
/*  595 */     x[0] = p.getX();
/*  596 */     y[0] = p.getY();
/*  597 */     int dx = x[0];
/*  598 */     int dy = y[0];
/*  599 */     p = rotation(x[0], y[0], tan);
/*  600 */     dx -= p.getX();
/*  601 */     dy -= p.getY();
/*      */     
/*      */ 
/*  604 */     if (posi == 1)
/*      */     {
/*  606 */       x[0] = (p.getX() + dx);
/*  607 */       y[0] = (p.getY() + dy);
/*      */       
/*  609 */       p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/*  610 */       x[1] = p.getX();
/*  611 */       y[1] = p.getY();
/*      */       
/*  613 */       x[1] += dx;
/*  614 */       y[1] += dy;
/*      */       
/*  616 */       p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/*  617 */       x[2] = (p.getX() + dx);
/*  618 */       y[2] = (p.getY() + dy);
/*      */       
/*  620 */       gr.fillPolygon(x, y, 3);
/*      */     }
/*  622 */     if (posi == 3) {
/*  623 */       x[0] = (p.getX() + dx);
/*  624 */       y[0] = (p.getY() + dy);
/*      */       
/*  626 */       p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/*  627 */       x[1] = p.getX();
/*  628 */       y[1] = p.getY();
/*      */       
/*  630 */       x[1] += dx;
/*  631 */       y[1] += dy;
/*      */       
/*      */ 
/*  634 */       p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/*  635 */       x[2] = (p.getX() + dx);
/*  636 */       y[2] = (p.getY() + dy);
/*      */       
/*  638 */       gr.fillPolygon(x, y, 3);
/*      */     }
/*      */     
/*  641 */     if (posi == 4) {
/*  642 */       if (this.cible.getCentreX() < lp.getX()) {
/*  643 */         x[0] = (p.getX() + dx);
/*  644 */         y[0] = (p.getY() + dy);
/*      */         
/*  646 */         p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/*  647 */         x[1] = (p.getX() + dx);
/*  648 */         y[1] = (p.getY() + dy);
/*      */         
/*  650 */         p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/*  651 */         x[2] = (p.getX() + dx);
/*  652 */         y[2] = (p.getY() + dy);
/*      */       } else {
/*  654 */         x[0] = (p.getX() + dx);
/*  655 */         y[0] = (p.getY() + dy);
/*      */         
/*  657 */         p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/*  658 */         x[1] = (p.getX() + dx);
/*  659 */         y[1] = (p.getY() + dy);
/*      */         
/*  661 */         p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/*  662 */         x[2] = (p.getX() + dx);
/*  663 */         y[2] = (p.getY() + dy);
/*      */       }
/*      */       
/*  666 */       gr.fillPolygon(x, y, 3);
/*      */     }
/*      */     
/*  669 */     if (posi == 2) {
/*  670 */       if (this.cible.getCentreX() > lp.getX()) {
/*  671 */         tan = lp.getY() - this.cible.getCentreY();
/*  672 */         tan /= (lp.getX() - this.cible.getCentreX());
/*      */         
/*  674 */         x[0] = (p.getX() + dx);
/*  675 */         y[0] = (p.getY() + dy);
/*      */         
/*  677 */         p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/*  678 */         x[1] = p.getX();
/*  679 */         y[1] = p.getY();
/*      */         
/*  681 */         x[1] += dx;
/*  682 */         y[1] += dy;
/*      */         
/*  684 */         p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/*  685 */         x[2] = (p.getX() + dx);
/*  686 */         y[2] = (p.getY() + dy);
/*      */       }
/*      */       else {
/*  689 */         x[0] = (p.getX() + dx);
/*  690 */         y[0] = (p.getY() + dy);
/*      */         
/*  692 */         p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/*  693 */         x[1] = p.getX();
/*  694 */         y[1] = p.getY();
/*      */         
/*  696 */         x[1] += dx;
/*  697 */         y[1] += dy;
/*      */         
/*  699 */         p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/*  700 */         x[2] = (p.getX() + dx);
/*  701 */         y[2] = (p.getY() + dy);
/*      */       }
/*  703 */       gr.fillPolygon(x, y, 3);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void DessinerTousLesPoint(Graphics2D gr)
/*      */   {
/*  712 */     int x0 = this.cible.getCentreX();
/*  713 */     int y0 = this.cible.getCentreY();
/*  714 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  715 */       gr.setColor(getClLien());
/*  716 */       if (isActiver()) gr.setColor(getClLienActiver());
/*  717 */       if (isSelected()) gr.setColor(getClLienSelect());
/*  718 */       gr.drawLine(x0, y0, ((IhmPoint)this.pointCassure.get(i)).getXCentre(), ((IhmPoint)this.pointCassure.get(i)).getYCentre());
/*  719 */       x0 = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/*  720 */       y0 = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/*  721 */       if (isSelected()) {
/*  722 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFond());
/*  723 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*      */       }
/*  725 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/*  726 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFondSelect());
/*  727 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*      */       }
/*  729 */       x0 = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/*  730 */       y0 = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/*      */     }
/*  732 */     gr.setColor(this.clLien);
/*  733 */     if (isActiver()) gr.setColor(getClLienActiver());
/*  734 */     if (isSelected()) { gr.setColor(getClLienSelect());
/*      */     }
/*  736 */     gr.drawLine(x0, y0, this.source.getCentreX(), this.source.getCentreY());
/*      */   }
/*      */   
/*      */   private void DessinerTousLesPointSansLien(Graphics2D gr) {
/*  740 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  741 */       gr.setColor(getClLien());
/*      */       
/*  743 */       if (isSelected()) {
/*  744 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFond());
/*  745 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*      */       }
/*  747 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/*  748 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFondSelect());
/*  749 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void ajouterModification()
/*      */   {
/*  756 */     Historique h = Historique.getHistoriqueModification();
/*  757 */     Historique h1 = (Historique)this.historique.get(this.historique.size() - 1);
/*  758 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur()))) {
/*  759 */       getHistorique().add(h);
/*      */     }
/*      */   }
/*      */   
/*      */   private void dessinerLien(Graphics2D gr) {
/*  764 */     Graphics2D g2d = gr;
/*  765 */     Stroke stro = g2d.getStroke();
/*  766 */     int x = 0;
/*  767 */     if (isDiscontinue()) x = 2;
/*  768 */     float[] style = { 8.0F, x };
/*  769 */     g2d.setStroke(new BasicStroke(this.epaisseur, 0, 0, 10.0F, style, 0.0F));
/*      */     
/*  771 */     DessinerTousLesPoint(gr);
/*  772 */     if (isFleche()) {
/*  773 */       calculerXYCardianlite();
/*  774 */       dessinerFleche(gr);
/*      */     }
/*  776 */     g2d.setStroke(stro);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSelected(boolean selected)
/*      */   {
/*  783 */     this.selected = selected;
/*  784 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  785 */       ((IhmPoint)this.pointCassure.get(i)).setDesigner(selected);
/*  786 */       if (!selected) {
/*  787 */         ((IhmPoint)this.pointCassure.get(i)).setSelected(false);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IhmPoint getSelectedPointCassure(int x, int y)
/*      */   {
/*  794 */     IhmPoint p = null;
/*  795 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  796 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected(x, y)) {
/*  797 */         p = (IhmPoint)this.pointCassure.get(i);
/*      */       }
/*      */     }
/*  800 */     return p;
/*      */   }
/*      */   
/*      */   public boolean isSelected(int x, int y)
/*      */   {
/*  805 */     if (getSelectedPointCassure(x, y) != null) return true;
/*  806 */     if (isSelectedNom(x, y)) { return true;
/*      */     }
/*      */     
/*  809 */     int xs = this.cible.getCentreX();
/*  810 */     int ys = this.cible.getCentreY();
/*  811 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  812 */       int xt = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/*  813 */       int yt = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/*  814 */       if (segmentSelect(xs, ys, xt, yt, x, y)) {
/*  815 */         return true;
/*      */       }
/*  817 */       xs = xt;
/*  818 */       ys = yt;
/*      */     }
/*      */     
/*  821 */     int xt = this.source.getCentreX();
/*  822 */     int yt = this.source.getCentreY();
/*      */     
/*  824 */     return segmentSelect(xs, ys, xt, yt, x, y);
/*      */   }
/*      */   
/*      */   public void ajouterCopier(ArrayList<Historique> lhis)
/*      */   {
/*  829 */     Historique h = Historique.getHistoriqueCopie();
/*  830 */     Historique h1 = (Historique)lhis.get(lhis.size() - 1);
/*  831 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur())) || (!h.getAction().equals(h1.getAction())))
/*      */     {
/*  833 */       lhis.add(h);
/*      */     }
/*      */   }
/*      */   
/*      */   public ArrayList<Historique> copierHistoriques(ArrayList<Historique> lhis) {
/*  838 */     ArrayList<Historique> l = new ArrayList();
/*  839 */     for (int i = 0; i < lhis.size(); i++) {
/*  840 */       l.add(((Historique)lhis.get(i)).copier());
/*      */     }
/*  842 */     return l;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmPoint> copierListePointDeCassure() {
/*  846 */     ArrayList<IhmPoint> liste = new ArrayList();
/*  847 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  848 */       IhmPoint p = ((IhmPoint)this.pointCassure.get(i)).copier();
/*  849 */       p.setX(p.getX() + 10);
/*  850 */       p.setY(p.getY() + 10);
/*  851 */       p.setSelected(true);
/*  852 */       liste.add(p);
/*      */     }
/*  854 */     return liste;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private int coteIntersectionSource()
/*      */   {
/*  862 */     int x1 = this.source.getCentreX();
/*  863 */     int y1 = this.source.getCentreY();
/*  864 */     int x2 = this.cible.getCentreX();
/*  865 */     int y2 = this.cible.getCentreY();
/*      */     
/*      */ 
/*  868 */     int x1C = this.source.getX();
/*  869 */     int y1C = this.source.getY();
/*  870 */     int x2C = this.source.getX() + this.source.getWidth();
/*  871 */     int y2C = this.source.getY();
/*  872 */     if (Line2D.linesIntersect(x1, y1, x2, y2, x1C, y1C, x2C, y2C)) {
/*  873 */       return 2;
/*      */     }
/*      */     
/*      */ 
/*  877 */     x1C = this.source.getX();
/*  878 */     y1C = this.source.getY() + this.source.getHeight();
/*  879 */     x2C = this.source.getX() + this.source.getWidth();
/*  880 */     y2C = this.source.getY() + this.source.getHeight();
/*  881 */     if (Line2D.linesIntersect(x1, y1, x2, y2, x1C, y1C, x2C, y2C)) {
/*  882 */       return 4;
/*      */     }
/*      */     
/*      */ 
/*  886 */     x1C = this.source.getX() + this.source.getWidth();
/*  887 */     y1C = this.source.getY();
/*  888 */     x2C = this.source.getX() + this.source.getWidth();
/*  889 */     y2C = this.source.getY() + this.source.getHeight();
/*  890 */     if (Line2D.linesIntersect(x1, y1, x2, y2, x1C, y1C, x2C, y2C)) {
/*  891 */       return 3;
/*      */     }
/*      */     
/*      */ 
/*  895 */     x1C = this.source.getX();
/*  896 */     y1C = this.source.getY();
/*  897 */     x2C = this.source.getX();
/*  898 */     y2C = this.source.getY() + this.source.getHeight();
/*  899 */     if (Line2D.linesIntersect(x1, y1, x2, y2, x1C, y1C, x2C, y2C)) {
/*  900 */       return 1;
/*      */     }
/*  902 */     return 2;
/*      */   }
/*      */   
/*      */   private int pointXIntersection(int x1, int y1, int x2, int y2, int x1C, int y1C, int x2C, int y2C) {
/*  906 */     int ecart = Math.abs(x1C - x2C);
/*      */     
/*  908 */     int xx1 = x1C;
/*  909 */     int xx2 = x2C;
/*      */     
/*  911 */     if (xx1 > xx2) {
/*  912 */       xx1 = x2C;
/*  913 */       xx2 = x1C;
/*      */     }
/*  915 */     int dis = xx2 - xx1;
/*  916 */     dis /= 2;
/*      */     
/*  918 */     while (ecart > 6) {
/*  919 */       if (Line2D.linesIntersect(x1, y1, x2, y2, xx1, y1C, xx2 - dis, y2C)) {
/*  920 */         xx2 -= dis;
/*      */       } else {
/*  922 */         xx1 += dis;
/*      */       }
/*  924 */       dis = (xx2 - xx1) / 2;
/*  925 */       ecart = Math.abs(xx2 - xx1);
/*      */     }
/*  927 */     return (xx1 + xx2) / 2;
/*      */   }
/*      */   
/*      */   private int pointYIntersection(int x1, int y1, int x2, int y2, int x1C, int y1C, int x2C, int y2C)
/*      */   {
/*  932 */     int ecart = Math.abs(y1C - y2C);
/*      */     
/*  934 */     int yy1 = y1C;
/*  935 */     int yy2 = y2C;
/*      */     
/*  937 */     if (yy1 > yy2) {
/*  938 */       yy1 = y2C;
/*  939 */       yy2 = y1C;
/*      */     }
/*  941 */     int dis = yy2 - yy1;
/*  942 */     dis /= 2;
/*      */     
/*  944 */     while (ecart > 6) {
/*  945 */       if (Line2D.linesIntersect(x1, y1, x2, y2, x1C, yy1, x2C, yy2 - dis)) {
/*  946 */         yy2 -= dis;
/*      */       } else {
/*  948 */         yy1 += dis;
/*      */       }
/*  950 */       dis = (yy2 - yy1) / 2;
/*  951 */       ecart = Math.abs(yy2 - yy1);
/*      */     }
/*  953 */     return (yy1 + yy2) / 2;
/*      */   }
/*      */   
/*      */   public Point getPointIntersectSource()
/*      */   {
/*  958 */     Point p = new Point(0, 0);
/*  959 */     int cot = coteIntersectionSource();
/*  960 */     int x1 = this.source.getCentreX();
/*  961 */     int x2 = this.cible.getCentreX();
/*  962 */     int y1 = this.source.getCentreY();
/*  963 */     int y2 = this.cible.getCentreY();
/*      */     
/*      */ 
/*  966 */     if (cot == 2) {
/*  967 */       int x1S = this.source.getX();
/*  968 */       int x2S = this.source.getX() + this.source.getWidth();
/*  969 */       int y1S = this.source.getY();
/*  970 */       int y2S = this.source.getY();
/*      */       
/*  972 */       int xx = pointXIntersection(x1, y1, x2, y2, x1S, y1S, x2S, y2S);
/*  973 */       p.setX(xx);
/*  974 */       p.setY(y2S);
/*  975 */       return p;
/*      */     }
/*      */     
/*  978 */     if (cot == 4) {
/*  979 */       int x1S = this.source.getX();
/*  980 */       int x2S = this.source.getX() + this.source.getWidth();
/*  981 */       int y1S = this.source.getY() + this.source.getHeight();
/*  982 */       int y2S = this.source.getY() + this.source.getHeight();
/*      */       
/*  984 */       int xx = pointXIntersection(x1, y1, x2, y2, x1S, y1S, x2S, y2S);
/*  985 */       p.setX(xx);
/*  986 */       p.setY(y2S);
/*  987 */       return p;
/*      */     }
/*      */     
/*  990 */     if (cot == 1) {
/*  991 */       int x1S = this.source.getX();
/*  992 */       int x2S = this.source.getX();
/*  993 */       int y1S = this.source.getY();
/*  994 */       int y2S = this.source.getY() + this.source.getHeight();
/*      */       
/*  996 */       int yy = pointYIntersection(x1, y1, x2, y2, x1S, y1S, x2S, y2S);
/*  997 */       p.setX(x1S);
/*  998 */       p.setY(yy);
/*  999 */       return p;
/*      */     }
/*      */     
/* 1002 */     if (cot == 3) {
/* 1003 */       int x1S = this.source.getX() + this.source.getWidth();
/* 1004 */       int x2S = this.source.getX() + this.source.getWidth();
/* 1005 */       int y1S = this.source.getY();
/* 1006 */       int y2S = this.source.getY() + this.source.getHeight();
/*      */       
/* 1008 */       int yy = pointYIntersection(x1, y1, x2, y2, x1S, y1S, x2S, y2S);
/* 1009 */       p.setX(x1S);
/* 1010 */       p.setY(yy);
/* 1011 */       return p;
/*      */     }
/*      */     
/* 1014 */     return p;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isActiver()
/*      */   {
/* 1075 */     return this.activer;
/*      */   }
/*      */   
/*      */   public MLDEntite2 getSource()
/*      */   {
/* 1080 */     return this.source;
/*      */   }
/*      */   
/*      */   public Color getClLienActiver() {
/* 1084 */     return this.clLienActiver;
/*      */   }
/*      */   
/*      */   public Color getClLien() {
/* 1088 */     return this.clLien;
/*      */   }
/*      */   
/*      */ 
/*      */   public Color getClLienSelect()
/*      */   {
/* 1094 */     return this.clLienSelect;
/*      */   }
/*      */   
/*      */   public Color getClLienText() {
/* 1098 */     return this.clLienText;
/*      */   }
/*      */   
/*      */   public String getCode() {
/* 1102 */     return this.code;
/*      */   }
/*      */   
/*      */   public float getEpaisseur() {
/* 1106 */     return this.epaisseur;
/*      */   }
/*      */   
/*      */   public String getCommentaire() {
/* 1110 */     return this.commentaire;
/*      */   }
/*      */   
/*      */   public int getCote() {
/* 1114 */     return this.cote;
/*      */   }
/*      */   
/*      */   public MLDEntite2 getCible() {
/* 1118 */     return this.cible;
/*      */   }
/*      */   
/*      */   public boolean isFleche() {
/* 1122 */     return this.fleche;
/*      */   }
/*      */   
/*      */   public ArrayList<Historique> getHistorique() {
/* 1126 */     return this.historique;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmPoint> getPointCassure() {
/* 1130 */     return this.pointCassure;
/*      */   }
/*      */   
/*      */   public double getTangente() {
/* 1134 */     return this.tangente;
/*      */   }
/*      */   
/*      */   public int getxCard() {
/* 1138 */     return this.xCard;
/*      */   }
/*      */   
/*      */   public int getyCard() {
/* 1142 */     return this.yCard;
/*      */   }
/*      */   
/*      */   public double getZoom() {
/* 1146 */     return this.zoom;
/*      */   }
/*      */   
/*      */   public void setActiver(boolean activer) {
/* 1150 */     this.activer = activer;
/*      */   }
/*      */   
/*      */   public void setSource(MLDEntite2 source) {
/* 1154 */     this.source = source;
/*      */   }
/*      */   
/*      */   public void setEpaisseur(float epaisseur) {
/* 1158 */     this.epaisseur = epaisseur;
/*      */   }
/*      */   
/*      */   public void setClLienActiver(Color clLienActiverCIF2) {
/* 1162 */     this.clLienActiver = clLienActiverCIF2;
/*      */   }
/*      */   
/*      */   public void setClLien(Color clLienCIF2) {
/* 1166 */     this.clLien = clLienCIF2;
/*      */   }
/*      */   
/*      */   public void setNom(String nom) {
/* 1170 */     this.nom = nom;
/*      */   }
/*      */   
/*      */   public String getNom() {
/* 1174 */     return this.nom;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setClLienSelect(Color clLienSelectCIF2)
/*      */   {
/* 1182 */     this.clLienSelect = clLienSelectCIF2;
/*      */   }
/*      */   
/*      */   public void setClLienText(Color clLienTextCIF2) {
/* 1186 */     this.clLienText = clLienTextCIF2;
/*      */   }
/*      */   
/*      */   public void setCode(String code) {
/* 1190 */     this.code = code;
/*      */   }
/*      */   
/*      */   public void setCommentaire(String commentaire) {
/* 1194 */     this.commentaire = commentaire;
/*      */   }
/*      */   
/*      */   public void setCote(int cote) {
/* 1198 */     this.cote = cote;
/*      */   }
/*      */   
/*      */   public void setCible(MLDEntite2 entite) {
/* 1202 */     this.cible = entite;
/*      */   }
/*      */   
/*      */   public void setFleche(boolean fleche) {
/* 1206 */     this.fleche = fleche;
/*      */   }
/*      */   
/*      */   public void setHistorique(ArrayList<Historique> historique) {
/* 1210 */     this.historique = historique;
/*      */   }
/*      */   
/*      */   public void setPointCassure(ArrayList<IhmPoint> pointCassure) {
/* 1214 */     this.pointCassure = pointCassure;
/*      */   }
/*      */   
/*      */   public void setTangente(double tangente) {
/* 1218 */     this.tangente = tangente;
/*      */   }
/*      */   
/*      */   public void setxCard(int xCard) {
/* 1222 */     this.xCard = xCard;
/*      */   }
/*      */   
/*      */   public void setyCard(int yCard) {
/* 1226 */     this.yCard = yCard;
/*      */   }
/*      */   
/*      */   public void setZoom(double zoom) {
/* 1230 */     this.zoom = zoom;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isSelected()
/*      */   {
/* 1238 */     return this.selected;
/*      */   }
/*      */   
/*      */   public void setDiscontinue(boolean discontinue) {
/* 1242 */     this.discontinue = discontinue;
/*      */   }
/*      */   
/*      */   public boolean isDiscontinue() {
/* 1246 */     return this.discontinue;
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMLD2\MLDLienEntite2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */