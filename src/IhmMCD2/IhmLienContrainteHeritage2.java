/*      */ package IhmMCD2;
/*      */ 
/*      */ import IhmMCD.IhmEntiteRelation;
/*      */ import IhmMCD.IhmLienContrainteHeritage;
/*      */ import IhmMCD.Point;
/*      */ import Merise2.Historique;
/*      */ import Outil.Parametres;
/*      */ import ihm.FormeInterneMCD;
/*      */ import java.awt.BasicStroke;
/*      */ import java.awt.Color;
/*      */ import java.awt.Font;
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
/*      */ public class IhmLienContrainteHeritage2
/*      */   extends IhmLienContrainteHeritage
/*      */   implements Serializable
/*      */ {
/*      */   IhmEntiteRelation entiteRelation;
/*      */   IhmHeritage2 heritage;
/*      */   String nom;
/*      */   String code;
/*      */   String commentaire;
/*      */   private Color clLienHeritage2;
/*      */   private Color clLienNomHeritage2;
/*      */   private Color clLienActiverHeritage2;
/*      */   private Color clLienSelectHeritage2;
/*      */   private Color clLienFondNom;
/*      */   ArrayList<IhmPoint> pointCassure;
/*      */   ArrayList<Historique> historique;
/*      */   private boolean fleche;
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
/*      */   Point nomXY;
/*      */   Point nomWH;
/*      */   Font font;
/*      */   float epaisseur;
/*      */   String conversionHeritage;
/*      */   boolean supprimerFille;
/*      */   boolean supprimerMere;
/*      */   String identifiant;
/*      */   
/*      */   public IhmLienContrainteHeritage2(IhmHeritage2 heritage, IhmEntiteRelation entite)
/*      */   {
/*   72 */     super(null, null);
/*   73 */     this.entiteRelation = entite;
/*   74 */     this.heritage = heritage;
/*   75 */     this.nom = "";
/*      */     
/*   77 */     this.code = "";
/*   78 */     this.commentaire = "";
/*      */     
/*   80 */     this.clLienHeritage2 = FormeInterneMCD.clLienHeritage2;
/*      */     
/*   82 */     this.clLienNomHeritage2 = FormeInterneMCD.clLienNomHeritage2;
/*   83 */     this.clLienSelectHeritage2 = FormeInterneMCD.clSelected;
/*   84 */     this.clLienActiverHeritage2 = FormeInterneMCD.clLienActiverHeritage2;
/*      */     
/*      */ 
/*      */ 
/*   88 */     this.clLienFondNom = FormeInterneMCD.clLienFondNomHeritage2;
/*      */     
/*      */ 
/*   91 */     setFleche(heritage.getPere() == getEntiteRelation());
/*   92 */     this.zoom = FormeInterneMCD.zoom;
/*   93 */     this.tangente = 1.0D;
/*   94 */     this.activer = false;
/*      */     
/*   96 */     this.pointCassure = new ArrayList();
/*   97 */     this.historique = new ArrayList();
/*   98 */     this.historique.add(Historique.getHistoriqueCreation());
/*   99 */     this.selected = false;
/*      */     
/*  101 */     this.nomXY = new Point(0, 0);
/*  102 */     this.nomWH = new Point(0, 0);
/*  103 */     this.font = Parametres.fontNormal;
/*  104 */     this.epaisseur = FormeInterneMCD.lienContraintes2;
/*      */     
/*  106 */     this.conversionHeritage = "";
/*  107 */     this.supprimerFille = false;
/*  108 */     this.supprimerMere = false;
/*  109 */     this.identifiant = "";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void paint(Graphics g)
/*      */   {
/*  116 */     Graphics2D g2d = (Graphics2D)g;
/*  117 */     dessinerLien(g2d);
/*  118 */     if (isSelected()) {
/*  119 */       DessinerTousLesPointSansLien(g2d);
/*      */     }
/*      */   }
/*      */   
/*      */   private void DessinerTousLesPointSansLien(Graphics2D gr) {
/*  124 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  125 */       gr.setColor(getClLien());
/*      */       
/*  127 */       if (isSelected()) {
/*  128 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFond());
/*  129 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*      */       }
/*  131 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/*  132 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFondSelect());
/*  133 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void coteIntersectionEntite()
/*      */   {
/*  143 */     int xe = getEntiteRelation().getCentreX();
/*  144 */     int ye = getEntiteRelation().getCentreY();
/*      */     
/*  146 */     int xr = getHeritage().getCentreX();
/*  147 */     int yr = getHeritage().getCentreY();
/*      */     
/*  149 */     if (this.pointCassure.size() > 0) {
/*  150 */       xr = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/*  151 */       yr = ((IhmPoint)this.pointCassure.get(0)).getYCentre();
/*      */     }
/*      */     
/*  154 */     int x1 = getEntiteRelation().getX();
/*  155 */     int y1 = getEntiteRelation().getY();
/*  156 */     int x2 = getEntiteRelation().getX();
/*  157 */     int y2 = getEntiteRelation().getY() + getEntiteRelation().getHeight();
/*      */     
/*  159 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/*  160 */       this.cote = 1;
/*  161 */       return;
/*      */     }
/*      */     
/*  164 */     x1 = getEntiteRelation().getX();
/*  165 */     y1 = getEntiteRelation().getY();
/*  166 */     x2 = getEntiteRelation().getX() + getEntiteRelation().getWidth();
/*  167 */     y2 = getEntiteRelation().getY();
/*      */     
/*  169 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/*  170 */       this.cote = 2;
/*  171 */       return;
/*      */     }
/*      */     
/*  174 */     x1 = getEntiteRelation().getX() + getEntiteRelation().getWidth();
/*  175 */     y1 = getEntiteRelation().getY();
/*  176 */     x2 = getEntiteRelation().getX() + getEntiteRelation().getWidth();
/*  177 */     y2 = getEntiteRelation().getY() + getEntiteRelation().getHeight();
/*      */     
/*  179 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/*  180 */       this.cote = 3;
/*  181 */       return;
/*      */     }
/*      */     
/*  184 */     x1 = getEntiteRelation().getX();
/*  185 */     y1 = getEntiteRelation().getY() + getEntiteRelation().getHeight();
/*  186 */     x2 = getEntiteRelation().getX() + getEntiteRelation().getWidth();
/*  187 */     y2 = getEntiteRelation().getY() + getEntiteRelation().getHeight();
/*      */     
/*  189 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/*  190 */       this.cote = 4;
/*  191 */       return;
/*      */     }
/*      */   }
/*      */   
/*      */   private Point getLastPoint() {
/*  196 */     if (this.pointCassure.size() == 0) {
/*  197 */       return new Point(getHeritage().getCentreX(), getHeritage().getCentreY());
/*      */     }
/*  199 */     return ((IhmPoint)this.pointCassure.get(0)).getPoint();
/*      */   }
/*      */   
/*      */   private boolean segmentSelect(int xs, int ys, int xt, int yt, int xx, int yy)
/*      */   {
/*  204 */     if (Line2D.linesIntersect(xs, ys, xt, yt, xx - 5, yy - 5, xx + 5, yy + 5)) return true;
/*  205 */     if (Line2D.linesIntersect(xs, ys, xt, yt, xx + 5, yy - 5, xx - 5, yy + 5)) return true;
/*  206 */     return false;
/*      */   }
/*      */   
/*      */   private boolean listePointEdentique(ArrayList<IhmPoint> liste) {
/*  210 */     if (liste.size() != this.pointCassure.size()) return false;
/*  211 */     for (int i = 0; i < liste.size(); i++) {
/*  212 */       if ((((IhmPoint)liste.get(i)).getX() != ((IhmPoint)this.pointCassure.get(i)).getX()) || (((IhmPoint)liste.get(i)).getY() != ((IhmPoint)this.pointCassure.get(i)).getY())) return false;
/*      */     }
/*  214 */     return true;
/*      */   }
/*      */   
/*      */   public boolean egale(IhmLienContrainteHeritage2 lien)
/*      */   {
/*  219 */     if ((lien.getEntiteRelation() != getEntiteRelation()) || (getHeritage() != lien.getHeritage())) return false;
/*  220 */     return listePointEdentique(lien.getPointCassure());
/*      */   }
/*      */   
/*      */   public void supprimerPointSelectionner() {
/*  224 */     int nb = this.pointCassure.size();
/*  225 */     int i = 0;
/*  226 */     while (i < nb) {
/*  227 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/*  228 */         this.pointCassure.remove(i);
/*  229 */         nb--;
/*      */       } else {
/*  231 */         i++;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean deplacerPointSelectionner(int x, int y) {
/*  237 */     int nb = this.pointCassure.size();
/*  238 */     boolean dep = false;
/*  239 */     for (int i = 0; i < nb; i++) {
/*  240 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/*  241 */         dep = true;
/*  242 */         ((IhmPoint)this.pointCassure.get(i)).move(((IhmPoint)this.pointCassure.get(i)).getX() - x, ((IhmPoint)this.pointCassure.get(i)).getY() - y);
/*      */       }
/*      */     }
/*  245 */     return dep;
/*      */   }
/*      */   
/*      */   public int XMaxPointSelectionner() {
/*  249 */     int nb = this.pointCassure.size();
/*  250 */     int xg = 0;
/*  251 */     for (int i = 0; i < nb; i++) {
/*  252 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/*  253 */         (xg < ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth())) {
/*  254 */         xg = ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth();
/*      */       }
/*      */     }
/*      */     
/*  258 */     return xg;
/*      */   }
/*      */   
/*      */   public int YMaxPointSelectionner() {
/*  262 */     int nb = this.pointCassure.size();
/*  263 */     int xg = 0;
/*  264 */     for (int i = 0; i < nb; i++) {
/*  265 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/*  266 */         (xg < ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight())) {
/*  267 */         xg = ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight();
/*      */       }
/*      */     }
/*      */     
/*  271 */     return xg;
/*      */   }
/*      */   
/*      */   public int XMaxAllPoint() {
/*  275 */     int nb = this.pointCassure.size();
/*  276 */     int xg = 0;
/*  277 */     for (int i = 0; i < nb; i++)
/*      */     {
/*  279 */       if (xg < ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth()) {
/*  280 */         xg = ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth();
/*      */       }
/*      */     }
/*      */     
/*  284 */     return xg;
/*      */   }
/*      */   
/*      */   public int YMaxAllPoint() {
/*  288 */     int nb = this.pointCassure.size();
/*  289 */     int xg = 0;
/*  290 */     for (int i = 0; i < nb; i++)
/*      */     {
/*  292 */       if (xg < ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight()) {
/*  293 */         xg = ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight();
/*      */       }
/*      */     }
/*      */     
/*  297 */     return xg;
/*      */   }
/*      */   
/*      */   public int XMinPointSelectionner() {
/*  301 */     int nb = this.pointCassure.size();
/*  302 */     int xg = Integer.MAX_VALUE;
/*  303 */     for (int i = 0; i < nb; i++) {
/*  304 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/*  305 */         (xg > ((IhmPoint)this.pointCassure.get(i)).getX())) {
/*  306 */         xg = ((IhmPoint)this.pointCassure.get(i)).getX();
/*      */       }
/*      */     }
/*      */     
/*  310 */     return xg;
/*      */   }
/*      */   
/*      */   public int YMinPointSelectionner() {
/*  314 */     int nb = this.pointCassure.size();
/*  315 */     int xg = Integer.MAX_VALUE;
/*  316 */     for (int i = 0; i < nb; i++) {
/*  317 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/*  318 */         (xg > ((IhmPoint)this.pointCassure.get(i)).getY())) {
/*  319 */         xg = ((IhmPoint)this.pointCassure.get(i)).getY();
/*      */       }
/*      */     }
/*      */     
/*  323 */     return xg; }
/*      */   
/*      */   private double tangeanteEntite() {
/*      */     int xt;
/*      */     int yt;
/*  328 */     if (this.pointCassure.size() == 0) {
/*  329 */       xt = getHeritage().getCentreX();
/*  330 */       yt = getHeritage().getCentreY();
/*      */     } else {
/*  332 */       xt = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/*  333 */       yt = ((IhmPoint)this.pointCassure.get(0)).getYCentre();
/*      */     }
/*  335 */     double d1 = getEntiteRelation().getCentreX() - xt;
/*  336 */     double d2 = getEntiteRelation().getCentreY() - yt;
/*  337 */     return d2 / d1;
/*      */   }
/*      */   
/*      */   private boolean isEntiteMemeX()
/*      */   {
/*  342 */     int x = getHeritage().getCentreX();
/*      */     
/*  344 */     if (this.pointCassure.size() > 0) {
/*  345 */       x = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/*      */     }
/*  347 */     if (getEntiteRelation().getCentreX() == x) return true;
/*  348 */     return false;
/*      */   }
/*      */   
/*      */   private void calculPointCardinaliteMemeXEntite()
/*      */   {
/*  353 */     int x = getEntiteRelation().getCentreX();
/*  354 */     if (this.cote == 2) {
/*  355 */       this.xCard = x;
/*  356 */       this.yCard = getEntiteRelation().getY();
/*      */     }
/*      */     
/*  359 */     if (this.cote == 4) {
/*  360 */       this.xCard = x;
/*      */       
/*  362 */       this.yCard = (getEntiteRelation().getY() + getEntiteRelation().getHeight());
/*  363 */       if (getEntiteRelation().isOmbre()) { this.yCard += 3;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void calculPointCardinaliteEntite()
/*      */   {
/*  370 */     if (isEntiteMemeX()) {
/*  371 */       calculPointCardinaliteMemeXEntite();
/*      */     }
/*      */     else {
/*  374 */       double tag = tangeanteEntite();
/*  375 */       this.tangente = tag;
/*  376 */       int y1 = getEntiteRelation().getCentreY();
/*  377 */       int x1 = getEntiteRelation().getCentreX();
/*  378 */       if (this.cote == 1) {
/*  379 */         this.xCard = getEntiteRelation().getX();
/*  380 */         this.yCard = ((int)(tag * this.xCard + (y1 - tag * x1)));
/*      */       }
/*      */       
/*      */ 
/*  384 */       if (this.cote == 3) {
/*  385 */         this.xCard = (getEntiteRelation().getX() + getEntiteRelation().getWidth());
/*  386 */         if (getEntiteRelation().isOmbre()) this.xCard += 3;
/*  387 */         this.yCard = ((int)(tag * this.xCard + (y1 - tag * x1)));
/*      */       }
/*      */       
/*  390 */       if (this.cote == 2) {
/*  391 */         int dec = (int)(15.0D - Math.abs(Math.atan(this.tangente)) * 10.0D);
/*  392 */         this.yCard = getEntiteRelation().getY();
/*  393 */         if (getEntiteRelation().isOmbre()) this.yCard += 3;
/*  394 */         this.xCard = ((int)((this.yCard - (y1 - tag * x1)) / tag));
/*      */       }
/*      */       
/*  397 */       if (this.cote == 4) {
/*  398 */         this.yCard = (getEntiteRelation().getY() + getEntiteRelation().getHeight());
/*      */         
/*  400 */         if (getEntiteRelation().isOmbre()) { this.yCard += 4;
/*      */         }
/*  402 */         this.xCard = ((int)((this.yCard - (y1 - tag * x1)) / tag));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void calculerXYCardianlite() {
/*  408 */     coteIntersectionEntite();
/*  409 */     calculPointCardinaliteEntite();
/*      */   }
/*      */   
/*      */   public boolean estDans(int xd, int yd, int xf, int yf) {
/*  413 */     if (getPointCassure().size() > 0) {
/*  414 */       for (int i = 0; i < getPointCassure().size(); i++) {
/*  415 */         if (!((IhmPoint)getPointCassure().get(i)).isSelected()) return false;
/*      */       }
/*  417 */       return true;
/*      */     }
/*      */     
/*  420 */     int x1 = xd;
/*  421 */     int x2 = xf;
/*  422 */     int y1 = yd;
/*  423 */     int y2 = yf;
/*  424 */     if (xd > xf) {
/*  425 */       x1 = xf;
/*  426 */       x2 = xd;
/*      */     }
/*  428 */     if (yd > yf) {
/*  429 */       y1 = yf;
/*  430 */       y2 = yd;
/*      */     }
/*  432 */     Rectangle2D rec = new Rectangle2D.Double(x1, y1, x2 - x1, y2 - y1);
/*  433 */     if ((rec.contains(getEntiteRelation().getCentreX(), getEntiteRelation().getCentreY())) && (rec.contains(getHeritage().getCentreX(), getHeritage().getCentreY())))
/*  434 */       return true;
/*  435 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean addBreakPoint(int x, int y)
/*      */   {
/*  442 */     int xs = getEntiteRelation().getCentreX();
/*  443 */     int ys = getEntiteRelation().getCentreY();
/*  444 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  445 */       int xt = ((IhmPoint)this.pointCassure.get(i)).getPoint().getX();
/*  446 */       int yt = ((IhmPoint)this.pointCassure.get(i)).getPoint().getY();
/*  447 */       if (segmentSelect(xs, ys, xt, yt, x, y)) {
/*  448 */         IhmPoint p = new IhmPoint(x, y);
/*  449 */         this.pointCassure.add(i, p);
/*  450 */         p.setSelected(true);
/*  451 */         return true;
/*      */       }
/*  453 */       xs = xt;
/*  454 */       ys = yt;
/*      */     }
/*  456 */     if (segmentSelect(xs, ys, getHeritage().getCentreX(), getHeritage().getCentreY(), x, y)) {
/*  457 */       IhmPoint p = new IhmPoint(x, y);
/*  458 */       this.pointCassure.add(p);
/*  459 */       p.setSelected(true);
/*  460 */       return true;
/*      */     }
/*  462 */     return false;
/*      */   }
/*      */   
/*      */   private Point rotation(double x, double y, double tg) {
/*  466 */     Point p = new Point(0, 0);
/*  467 */     double x1 = 0.0D;double y1 = 0.0D;double rac = 0.0D;
/*  468 */     rac = Math.sqrt(Math.pow(tg, 2.0D) + 1.0D);
/*  469 */     x1 = (x - y * tg) / rac;
/*  470 */     y1 = (y + x * tg) / rac;
/*  471 */     p.setX((int)x1);
/*  472 */     p.setY((int)y1);
/*  473 */     return p;
/*      */   }
/*      */   
/*      */   public void dessinerFleche(Graphics2D gr) {
/*  477 */     gr.setColor(getClLienHeritage2());
/*  478 */     if (isActiver()) gr.setColor(getClLienActiverHeritage2());
/*  479 */     if (isSelected()) { gr.setColor(getClLienSelectHeritage2());
/*      */     }
/*  481 */     Point lp = getLastPoint();
/*      */     
/*  483 */     if (isEntiteMemeX()) {
/*  484 */       if (this.cote == 2) {
/*  485 */         int[] x = new int[3];
/*  486 */         int[] y = new int[3];
/*  487 */         int xfleche = 10;
/*  488 */         int yfleche = 10;
/*  489 */         x[0] = getEntiteRelation().getCentreX();
/*  490 */         y[0] = getEntiteRelation().getY();
/*      */         
/*  492 */         x[1] = (x[0] - xfleche);
/*  493 */         y[1] = (y[0] - yfleche);
/*      */         
/*  495 */         x[2] = (x[0] + xfleche);
/*  496 */         y[2] = (y[0] - yfleche);
/*  497 */         gr.setColor(getHeritage().getClFond2());
/*  498 */         gr.fillPolygon(x, y, 3);
/*  499 */         gr.setColor(this.clLienHeritage2);
/*  500 */         if (isActiver()) gr.setColor(this.clLienActiverHeritage2);
/*  501 */         if (isSelected()) gr.setColor(this.clLienSelectHeritage2);
/*  502 */         gr.drawPolygon(x, y, 3);
/*      */       }
/*      */       
/*      */ 
/*  506 */       if (this.cote == 4) {
/*  507 */         int[] x = new int[3];
/*  508 */         int[] y = new int[3];
/*  509 */         int xfleche = 10;
/*  510 */         int yfleche = 10;
/*      */         
/*  512 */         x[0] = getEntiteRelation().getCentreX();
/*  513 */         y[0] = (getEntiteRelation().getY() + getEntiteRelation().getHeight());
/*  514 */         if (getEntiteRelation().isOmbre()) { y[0] += 4;
/*      */         }
/*  516 */         x[1] = (x[0] - xfleche);
/*  517 */         y[1] = (y[0] + yfleche);
/*      */         
/*  519 */         x[2] = (x[0] + xfleche);
/*  520 */         y[2] = (y[0] + yfleche);
/*  521 */         gr.setColor(getHeritage().getClFond2());
/*  522 */         gr.fillPolygon(x, y, 3);
/*  523 */         gr.setColor(this.clLienHeritage2);
/*  524 */         if (isActiver()) gr.setColor(this.clLienActiverHeritage2);
/*  525 */         if (isSelected()) gr.setColor(this.clLienSelectHeritage2);
/*  526 */         gr.drawPolygon(x, y, 3);
/*      */       }
/*  528 */       return;
/*      */     }
/*      */     
/*  531 */     double tan = getEntiteRelation().getCentreY() - lp.getY();
/*  532 */     tan /= (getEntiteRelation().getCentreX() - lp.getX());
/*      */     
/*  534 */     int[] x = new int[3];
/*  535 */     int[] y = new int[3];
/*      */     
/*      */ 
/*      */ 
/*  539 */     int posi = this.cote;
/*      */     
/*  541 */     Point p = new Point(this.xCard, this.yCard);
/*      */     
/*      */ 
/*  544 */     int xfleche = 10;
/*  545 */     int yfleche = 10;
/*      */     
/*  547 */     x[0] = p.getX();
/*  548 */     y[0] = p.getY();
/*  549 */     int dx = x[0];
/*  550 */     int dy = y[0];
/*  551 */     p = rotation(x[0], y[0], tan);
/*  552 */     dx -= p.getX();
/*  553 */     dy -= p.getY();
/*      */     
/*      */ 
/*  556 */     if (posi == 1)
/*      */     {
/*  558 */       x[0] = (p.getX() + dx);
/*  559 */       y[0] = (p.getY() + dy);
/*      */       
/*  561 */       p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/*  562 */       x[1] = p.getX();
/*  563 */       y[1] = p.getY();
/*      */       
/*  565 */       x[1] += dx;
/*  566 */       y[1] += dy;
/*      */       
/*  568 */       p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/*  569 */       x[2] = (p.getX() + dx);
/*  570 */       y[2] = (p.getY() + dy);
/*      */       
/*  572 */       gr.setColor(getHeritage().getClFond2());
/*  573 */       gr.fillPolygon(x, y, 3);
/*  574 */       gr.setColor(this.clLienHeritage2);
/*  575 */       if (isActiver()) gr.setColor(this.clLienActiverHeritage2);
/*  576 */       if (isSelected()) gr.setColor(this.clLienSelectHeritage2);
/*  577 */       gr.drawPolygon(x, y, 3);
/*      */     }
/*  579 */     if (posi == 3) {
/*  580 */       x[0] = (p.getX() + dx);
/*  581 */       y[0] = (p.getY() + dy);
/*      */       
/*  583 */       p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/*  584 */       x[1] = p.getX();
/*  585 */       y[1] = p.getY();
/*      */       
/*  587 */       x[1] += dx;
/*  588 */       y[1] += dy;
/*      */       
/*      */ 
/*  591 */       p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/*  592 */       x[2] = (p.getX() + dx);
/*  593 */       y[2] = (p.getY() + dy);
/*      */       
/*  595 */       gr.setColor(getHeritage().getClFond2());
/*  596 */       gr.fillPolygon(x, y, 3);
/*  597 */       gr.setColor(this.clLienHeritage2);
/*  598 */       if (isActiver()) gr.setColor(this.clLienActiverHeritage2);
/*  599 */       if (isSelected()) gr.setColor(this.clLienSelectHeritage2);
/*  600 */       gr.drawPolygon(x, y, 3);
/*      */     }
/*      */     
/*  603 */     if (posi == 4) {
/*  604 */       if (getEntiteRelation().getCentreX() < lp.getX()) {
/*  605 */         x[0] = (p.getX() + dx);
/*  606 */         y[0] = (p.getY() + dy);
/*      */         
/*  608 */         p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/*  609 */         x[1] = (p.getX() + dx);
/*  610 */         y[1] = (p.getY() + dy);
/*      */         
/*  612 */         p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/*  613 */         x[2] = (p.getX() + dx);
/*  614 */         y[2] = (p.getY() + dy);
/*      */       } else {
/*  616 */         x[0] = (p.getX() + dx);
/*  617 */         y[0] = (p.getY() + dy);
/*      */         
/*  619 */         p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/*  620 */         x[1] = (p.getX() + dx);
/*  621 */         y[1] = (p.getY() + dy);
/*      */         
/*  623 */         p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/*  624 */         x[2] = (p.getX() + dx);
/*  625 */         y[2] = (p.getY() + dy);
/*      */       }
/*      */       
/*  628 */       gr.setColor(getHeritage().getClFond2());
/*  629 */       gr.fillPolygon(x, y, 3);
/*  630 */       gr.setColor(this.clLienHeritage2);
/*  631 */       if (isActiver()) gr.setColor(this.clLienActiverHeritage2);
/*  632 */       if (isSelected()) gr.setColor(this.clLienSelectHeritage2);
/*  633 */       gr.drawPolygon(x, y, 3);
/*      */     }
/*      */     
/*  636 */     if (posi == 2) {
/*  637 */       if (getEntiteRelation().getCentreX() > lp.getX()) {
/*  638 */         tan = lp.getY() - getEntiteRelation().getCentreY();
/*  639 */         tan /= (lp.getX() - getEntiteRelation().getCentreX());
/*      */         
/*  641 */         x[0] = (p.getX() + dx);
/*  642 */         y[0] = (p.getY() + dy);
/*      */         
/*  644 */         p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/*  645 */         x[1] = p.getX();
/*  646 */         y[1] = p.getY();
/*      */         
/*  648 */         x[1] += dx;
/*  649 */         y[1] += dy;
/*      */         
/*  651 */         p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/*  652 */         x[2] = (p.getX() + dx);
/*  653 */         y[2] = (p.getY() + dy);
/*      */       }
/*      */       else {
/*  656 */         x[0] = (p.getX() + dx);
/*  657 */         y[0] = (p.getY() + dy);
/*      */         
/*  659 */         p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/*  660 */         x[1] = p.getX();
/*  661 */         y[1] = p.getY();
/*      */         
/*  663 */         x[1] += dx;
/*  664 */         y[1] += dy;
/*      */         
/*  666 */         p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/*  667 */         x[2] = (p.getX() + dx);
/*  668 */         y[2] = (p.getY() + dy);
/*      */       }
/*  670 */       gr.setColor(getHeritage().getClFond2());
/*  671 */       gr.fillPolygon(x, y, 3);
/*  672 */       gr.setColor(this.clLienHeritage2);
/*  673 */       if (isActiver()) gr.setColor(this.clLienActiverHeritage2);
/*  674 */       if (isSelected()) gr.setColor(this.clLienSelectHeritage2);
/*  675 */       gr.drawPolygon(x, y, 3);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void DessinerTousLesPoint(Graphics2D gr)
/*      */   {
/*  684 */     int x0 = getEntiteRelation().getCentreX();
/*  685 */     int y0 = getEntiteRelation().getCentreY();
/*  686 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  687 */       gr.setColor(getClLienHeritage2());
/*  688 */       if (isActiver()) gr.setColor(getClLienActiverHeritage2());
/*  689 */       if (isSelected()) gr.setColor(getClLienSelectHeritage2());
/*  690 */       gr.drawLine(x0, y0, ((IhmPoint)this.pointCassure.get(i)).getXCentre(), ((IhmPoint)this.pointCassure.get(i)).getYCentre());
/*  691 */       x0 = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/*  692 */       y0 = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/*  693 */       if (isSelected()) {
/*  694 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFond());
/*  695 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*      */       }
/*  697 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/*  698 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFondSelect());
/*  699 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*      */       }
/*  701 */       x0 = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/*  702 */       y0 = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/*      */     }
/*  704 */     gr.setColor(getClLienHeritage2());
/*  705 */     if (isActiver()) gr.setColor(getClLienActiverHeritage2());
/*  706 */     if (isSelected()) { gr.setColor(getClLienSelectHeritage2());
/*      */     }
/*  708 */     gr.drawLine(x0, y0, getHeritage().getCentreX(), getHeritage().getCentreY());
/*      */   }
/*      */   
/*      */   public void ajouterModification() {
/*  712 */     Historique h = Historique.getHistoriqueModification();
/*  713 */     Historique h1 = (Historique)this.historique.get(this.historique.size() - 1);
/*  714 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur()))) {
/*  715 */       getHistorique().add(h);
/*      */     }
/*      */   }
/*      */   
/*      */   private void dessinerLien(Graphics2D gr) {
/*  720 */     if ((getEntiteRelation() instanceof IhmRelation2)) {
/*  721 */       Graphics2D g2d = gr;
/*  722 */       Stroke stro = g2d.getStroke();
/*      */       
/*  724 */       float[] style = { 5.0F, 5.0F };
/*  725 */       g2d.setStroke(new BasicStroke(this.epaisseur, 0, 0, 10.0F, style, 0.0F));
/*  726 */       DessinerTousLesPoint(g2d);
/*  727 */       g2d.setStroke(stro);
/*      */     }
/*      */     else {
/*  730 */       Graphics2D g2d = gr;
/*  731 */       Stroke stro = g2d.getStroke();
/*  732 */       float[] style = { 5.0F, 0.0F };
/*  733 */       g2d.setStroke(new BasicStroke(this.epaisseur, 0, 0, 10.0F, style, 0.0F));
/*      */       
/*  735 */       DessinerTousLesPoint(gr);
/*  736 */       if (isFleche()) {
/*  737 */         calculerXYCardianlite();
/*  738 */         dessinerFleche(gr);
/*      */       }
/*  740 */       else if (getNom().trim().length() > 0) {
/*  741 */         calculerXYCardianlite();
/*      */       }
/*      */       
/*  744 */       g2d.setStroke(stro);
/*      */       
/*  746 */       dessinerNomLien(gr);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private int coteRelation(Graphics2D gr)
/*      */   {
/*  753 */     int xL2 = 0;int yL2 = 0;
/*  754 */     int xL1 = getHeritage().getCentreX();
/*  755 */     int yL1 = getHeritage().getCentreY();
/*  756 */     if (this.pointCassure.size() == 0) {
/*  757 */       xL2 = getEntiteRelation().getCentreX();
/*  758 */       yL2 = getEntiteRelation().getCentreY();
/*      */     }
/*  760 */     if (this.pointCassure.size() == 1) {
/*  761 */       xL2 = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/*  762 */       yL2 = ((IhmPoint)this.pointCassure.get(0)).getYCentre();
/*      */     }
/*      */     
/*  765 */     int x1 = getHeritage().getX();
/*  766 */     int y1 = getHeritage().getY();
/*  767 */     int x2 = getHeritage().getX();
/*  768 */     int y2 = getHeritage().getY() + getHeritage().getHeight();
/*      */     
/*  770 */     if (Line2D.linesIntersect(xL1, yL1, xL2, yL2, x1, y1, x2, y2))
/*      */     {
/*  772 */       return 1;
/*      */     }
/*      */     
/*  775 */     x1 = getHeritage().getX();
/*  776 */     y1 = getHeritage().getY();
/*  777 */     x2 = getHeritage().getX() + getHeritage().getWidth();
/*  778 */     y2 = getHeritage().getY();
/*      */     
/*  780 */     if (Line2D.linesIntersect(xL1, yL1, xL2, yL2, x1, y1, x2, y2))
/*      */     {
/*  782 */       return 2;
/*      */     }
/*      */     
/*  785 */     x1 = getHeritage().getX() + getHeritage().getWidth();
/*  786 */     y1 = getHeritage().getY();
/*  787 */     x2 = getHeritage().getX() + getHeritage().getWidth();
/*  788 */     y2 = getHeritage().getY() + getHeritage().getHeight();
/*      */     
/*  790 */     if (Line2D.linesIntersect(xL1, yL1, xL2, yL2, x1, y1, x2, y2))
/*      */     {
/*  792 */       return 3;
/*      */     }
/*      */     
/*  795 */     x1 = getHeritage().getX();
/*  796 */     y1 = getHeritage().getY() + getHeritage().getHeight();
/*  797 */     x2 = getHeritage().getX() + getHeritage().getWidth();
/*  798 */     y2 = getHeritage().getY() + getHeritage().getHeight();
/*      */     
/*  800 */     if (Line2D.linesIntersect(xL1, yL1, xL2, yL2, x1, y1, x2, y2))
/*      */     {
/*  802 */       return 4;
/*      */     }
/*  804 */     return 2;
/*      */   }
/*      */   
/*      */   private Point intersectHoriz(Graphics2D gr, int xL1, int yL1, int xL2, int yL2, int coteR)
/*      */   {
/*  809 */     Point p = new Point(0, 0);
/*      */     
/*  811 */     int y1 = 0;
/*  812 */     int x1 = getHeritage().getX();
/*  813 */     int x2 = getHeritage().getX() + getHeritage().getWidth();
/*  814 */     if (coteR == 2) {
/*  815 */       y1 = getHeritage().getY();
/*      */     }
/*  817 */     if (coteR == 4) {
/*  818 */       y1 = getHeritage().getY() + getHeritage().getHeight();
/*      */     }
/*  820 */     int dis = x2 - x1;
/*  821 */     while (dis > 4) {
/*  822 */       if (Line2D.linesIntersect(x1, y1, x1 + dis / 2, y1, xL1, yL1, xL2, yL2)) {
/*  823 */         x2 -= dis / 2;
/*      */       } else {
/*  825 */         x1 += dis / 2;
/*      */       }
/*  827 */       dis = x2 - x1;
/*      */     }
/*  829 */     p.setX(x1);
/*  830 */     p.setY(y1);
/*  831 */     return p;
/*      */   }
/*      */   
/*      */   private Point intersectVerti(Graphics2D gr, int xL1, int yL1, int xL2, int yL2, int coteR) {
/*  835 */     Point p = new Point(0, 0);
/*      */     
/*  837 */     int x1 = 0;
/*  838 */     int y1 = getHeritage().getY();
/*  839 */     int y2 = getHeritage().getY() + getHeritage().getHeight();
/*  840 */     if (coteR == 1) {
/*  841 */       x1 = getHeritage().getX();
/*      */     }
/*  843 */     if (coteR == 3) {
/*  844 */       x1 = getHeritage().getX() + getHeritage().getWidth();
/*      */     }
/*  846 */     int dis = y2 - y1;
/*  847 */     while (dis > 4) {
/*  848 */       if (Line2D.linesIntersect(x1, y1, x1, y1 + dis / 2, xL1, yL1, xL2, yL2)) {
/*  849 */         y2 -= dis / 2;
/*      */       } else {
/*  851 */         y1 += dis / 2;
/*      */       }
/*  853 */       dis = y2 - y1;
/*      */     }
/*  855 */     p.setX(x1);
/*  856 */     p.setY(y1);
/*  857 */     return p;
/*      */   }
/*      */   
/*      */   private Point getPremierPointNom()
/*      */   {
/*  862 */     Point p = new Point(0, 0);
/*  863 */     if (this.pointCassure.size() == 0) {
/*  864 */       p.setX(this.xCard);
/*  865 */       p.setY(this.yCard);
/*      */     } else {
/*  867 */       p.setX(((IhmPoint)this.pointCassure.get(0)).getX());
/*  868 */       p.setY(((IhmPoint)this.pointCassure.get(0)).getY());
/*      */     }
/*  870 */     return p;
/*      */   }
/*      */   
/*      */   private Point getDernierPointNom(Graphics2D gr) {
/*  874 */     Point p = new Point(0, 0);
/*  875 */     if (this.pointCassure.size() <= 1) {
/*  876 */       p = getPremierPointNom();
/*      */       
/*  878 */       int coteR = coteRelation(gr);
/*      */       
/*  880 */       if ((coteR == 2) || (coteR == 4)) {
/*  881 */         Point p1 = intersectHoriz(gr, p.getX(), p.getY(), getHeritage().getCentreX(), getHeritage().getCentreY(), coteR);
/*  882 */         return p1;
/*      */       }
/*  884 */       if ((coteR == 3) || (coteR == 1)) {
/*  885 */         Point p1 = intersectVerti(gr, p.getX(), p.getY(), getHeritage().getCentreX(), getHeritage().getCentreY(), coteR);
/*  886 */         return p1;
/*      */       }
/*      */     }
/*      */     else {
/*  890 */       p.setX(((IhmPoint)this.pointCassure.get(1)).getX());
/*  891 */       p.setY(((IhmPoint)this.pointCassure.get(1)).getY());
/*      */     }
/*  893 */     return p;
/*      */   }
/*      */   
/*      */   private void calculCoordonneeNom(Graphics2D gr) {
/*  897 */     Point p1 = getPremierPointNom();
/*  898 */     Point p2 = getDernierPointNom(gr);
/*  899 */     int w = gr.getFontMetrics().stringWidth(getNom());
/*  900 */     int h = gr.getFontMetrics().getHeight();
/*  901 */     this.nomXY.setX((p1.getX() + p2.getX()) / 2);
/*  902 */     this.nomXY.setX(this.nomXY.getX() - w / 2);
/*  903 */     this.nomXY.setY((p1.getY() + p2.getY()) / 2);
/*  904 */     this.nomXY.setY(this.nomXY.getY() + h / 2);
/*  905 */     this.nomWH.setX(w + 4);
/*  906 */     this.nomWH.setY(h);
/*      */   }
/*      */   
/*      */   private boolean isSelectedNom(int x, int y)
/*      */   {
/*  911 */     if ((getNom().trim().length() > 0) && 
/*  912 */       (x > this.nomXY.getX()) && (x < this.nomXY.getX() + this.nomWH.getX()) && (y > this.nomXY.getY() - this.nomWH.getY()) && (y < this.nomXY.getY())) {
/*  913 */       return true;
/*      */     }
/*  915 */     return false;
/*      */   }
/*      */   
/*      */   private void dessinerNomLien(Graphics2D gr) {
/*  919 */     if (getNom().trim().length() > 0) {
/*  920 */       calculCoordonneeNom(gr);
/*  921 */       Font f = gr.getFont();
/*  922 */       gr.setFont(this.font);
/*  923 */       gr.setColor(this.clLienFondNom);
/*  924 */       gr.fillRect(this.nomXY.getX(), this.nomXY.getY() - this.nomWH.getY() + 3, this.nomWH.getX(), this.nomWH.getY());
/*  925 */       gr.setColor(this.clLienNomHeritage2);
/*  926 */       if (isActiver()) gr.setColor(this.clLienActiverHeritage2);
/*  927 */       if (isSelected()) gr.setColor(this.clLienSelectHeritage2);
/*  928 */       gr.drawString(getNom().trim(), this.nomXY.getX() + 2, this.nomXY.getY());
/*  929 */       gr.setFont(f);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void setSelected(boolean selected)
/*      */   {
/*  936 */     this.selected = selected;
/*  937 */     super.setSelected(selected);
/*  938 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  939 */       ((IhmPoint)this.pointCassure.get(i)).setDesigner(selected);
/*  940 */       if (!selected) {
/*  941 */         ((IhmPoint)this.pointCassure.get(i)).setSelected(false);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IhmPoint getSelectedPointCassure(int x, int y)
/*      */   {
/*  948 */     IhmPoint p = null;
/*  949 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  950 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected(x, y)) {
/*  951 */         p = (IhmPoint)this.pointCassure.get(i);
/*      */       }
/*      */     }
/*  954 */     return p;
/*      */   }
/*      */   
/*      */   public boolean isSelected(int x, int y)
/*      */   {
/*  959 */     if (getSelectedPointCassure(x, y) != null) return true;
/*  960 */     if (isSelectedNom(x, y)) { return true;
/*      */     }
/*      */     
/*  963 */     int xs = getEntiteRelation().getCentreX();
/*  964 */     int ys = getEntiteRelation().getCentreY();
/*  965 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  966 */       int xt = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/*  967 */       int yt = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/*  968 */       if (segmentSelect(xs, ys, xt, yt, x, y)) {
/*  969 */         return true;
/*      */       }
/*  971 */       xs = xt;
/*  972 */       ys = yt;
/*      */     }
/*      */     
/*  975 */     int xt = getHeritage().getCentreX();
/*  976 */     int yt = getHeritage().getCentreY();
/*      */     
/*  978 */     return segmentSelect(xs, ys, xt, yt, x, y);
/*      */   }
/*      */   
/*      */   public void ajouterCopier(ArrayList<Historique> lhis)
/*      */   {
/*  983 */     Historique h = Historique.getHistoriqueCopie();
/*  984 */     Historique h1 = (Historique)lhis.get(lhis.size() - 1);
/*  985 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur())) || (!h.getAction().equals(h1.getAction())))
/*      */     {
/*  987 */       lhis.add(h);
/*      */     }
/*      */   }
/*      */   
/*      */   public ArrayList<Historique> copierHistoriques(ArrayList<Historique> lhis) {
/*  992 */     ArrayList<Historique> l = new ArrayList();
/*  993 */     for (int i = 0; i < lhis.size(); i++) {
/*  994 */       l.add(((Historique)lhis.get(i)).copier());
/*      */     }
/*  996 */     return l;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmPoint> copierListePointDeCassure() {
/* 1000 */     ArrayList<IhmPoint> liste = new ArrayList();
/* 1001 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 1002 */       IhmPoint p = ((IhmPoint)this.pointCassure.get(i)).copier();
/* 1003 */       p.setX(p.getX() + 10);
/* 1004 */       p.setY(p.getY() + 10);
/* 1005 */       p.setSelected(true);
/* 1006 */       liste.add(p);
/*      */     }
/* 1008 */     return liste;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static IhmLienContrainteHeritage2 parseIhmLienContrainteHeritage(IhmLienContrainteHeritage lien, IhmEntiteRelation newEnt, IhmHeritage2 newHer)
/*      */   {
/* 1015 */     IhmLienContrainteHeritage2 l = new IhmLienContrainteHeritage2(newHer, newEnt);
/*      */     
/* 1017 */     l.setNom(lien.getNom());
/* 1018 */     l.setCode(lien.getNom().toUpperCase());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1024 */     l.setClLienNomHeritage2(FormeInterneMCD.clLienNomHeritage2);
/* 1025 */     l.setClLienHeritage2(FormeInterneMCD.clLienHeritage2);
/*      */     
/*      */ 
/* 1028 */     l.setCommentaire("");
/*      */     
/* 1030 */     if (lien.isCassure()) {
/* 1031 */       l.getPointCassure().add(new IhmPoint((int)lien.getxCassure(), (int)lien.getyCassure()));
/*      */     }
/*      */     
/* 1034 */     return l;
/*      */   }
/*      */   
/*      */   public IhmLienContrainteHeritage2 copier(IhmEntiteRelation ent, IhmHeritage2 cnt)
/*      */   {
/* 1039 */     IhmLienContrainteHeritage2 lien = new IhmLienContrainteHeritage2(cnt, ent);
/*      */     
/* 1041 */     lien.setNom(getNom());
/* 1042 */     lien.setClLienHeritage2(getClLienHeritage2());
/*      */     
/* 1044 */     lien.setClLienNomHeritage2(getClLienNomHeritage2());
/* 1045 */     lien.setClLienActiverHeritage2(getClLienActiverHeritage2());
/* 1046 */     lien.setClLienSelectHeritage2(getClLienSelectHeritage2());
/*      */     
/*      */ 
/*      */ 
/* 1050 */     lien.setCommentaire(getCommentaire());
/*      */     
/* 1052 */     lien.setCode(getCode());
/*      */     
/* 1054 */     lien.setFleche(isFleche());
/* 1055 */     lien.setZoom(getZoom());
/*      */     
/* 1057 */     lien.setPointCassure(copierListePointDeCassure());
/* 1058 */     lien.setHistorique(copierHistoriques(this.historique));
/* 1059 */     ajouterCopier(lien.getHistorique());
/* 1060 */     return lien;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean isActiver()
/*      */   {
/* 1067 */     return this.activer;
/*      */   }
/*      */   
/*      */   public Color getClLienFondNom() {
/* 1071 */     return this.clLienFondNom;
/*      */   }
/*      */   
/*      */   public void setClLienFondNom(Color clLienFondNom) {
/* 1075 */     this.clLienFondNom = clLienFondNom;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public Color getClLienActiverHeritage2()
/*      */   {
/* 1083 */     return this.clLienActiverHeritage2;
/*      */   }
/*      */   
/*      */   public Color getClLienHeritage2() {
/* 1087 */     return this.clLienHeritage2;
/*      */   }
/*      */   
/*      */   public Color getClLienNomHeritage2() {
/* 1091 */     return this.clLienNomHeritage2;
/*      */   }
/*      */   
/*      */   public Color getClLienSelectHeritage2() {
/* 1095 */     return this.clLienSelectHeritage2;
/*      */   }
/*      */   
/*      */   public float getEpaisseur() {
/* 1099 */     return this.epaisseur;
/*      */   }
/*      */   
/*      */ 
/*      */   public String getCode()
/*      */   {
/* 1105 */     return this.code;
/*      */   }
/*      */   
/*      */   public String getCommentaire() {
/* 1109 */     return this.commentaire;
/*      */   }
/*      */   
/*      */   public int getCote() {
/* 1113 */     return this.cote;
/*      */   }
/*      */   
/*      */   public IhmEntiteRelation getEntiteRelation() {
/* 1117 */     return this.entiteRelation;
/*      */   }
/*      */   
/*      */   public boolean isFleche() {
/* 1121 */     return this.fleche;
/*      */   }
/*      */   
/*      */   public String getConversionHeritage() {
/* 1125 */     return this.conversionHeritage;
/*      */   }
/*      */   
/*      */   public String getIdentifiant() {
/* 1129 */     return this.identifiant;
/*      */   }
/*      */   
/*      */   public Font getFont() {
/* 1133 */     return this.font;
/*      */   }
/*      */   
/*      */   public Point getNomWH() {
/* 1137 */     return this.nomWH;
/*      */   }
/*      */   
/*      */   public Point getNomXY() {
/* 1141 */     return this.nomXY;
/*      */   }
/*      */   
/*      */   public boolean isSupprimerFille() {
/* 1145 */     return this.supprimerFille;
/*      */   }
/*      */   
/*      */   public boolean isSupprimerMere() {
/* 1149 */     return this.supprimerMere;
/*      */   }
/*      */   
/*      */   public IhmHeritage2 getHeritage()
/*      */   {
/* 1154 */     return this.heritage;
/*      */   }
/*      */   
/*      */   public ArrayList<Historique> getHistorique() {
/* 1158 */     return this.historique;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmPoint> getPointCassure() {
/* 1162 */     return this.pointCassure;
/*      */   }
/*      */   
/*      */   public boolean isSelected() {
/* 1166 */     return this.selected;
/*      */   }
/*      */   
/*      */   public double getTangente() {
/* 1170 */     return this.tangente;
/*      */   }
/*      */   
/*      */   public int getxCard() {
/* 1174 */     return this.xCard;
/*      */   }
/*      */   
/*      */   public int getyCard() {
/* 1178 */     return this.yCard;
/*      */   }
/*      */   
/*      */   public void setIdentifiant(String identifiant) {
/* 1182 */     this.identifiant = identifiant;
/*      */   }
/*      */   
/*      */   public double getZoom() {
/* 1186 */     return this.zoom;
/*      */   }
/*      */   
/*      */   public void setActiver(boolean activer) {
/* 1190 */     this.activer = activer;
/*      */   }
/*      */   
/*      */   public void setClLienActiverHeritage2(Color clLienActiverHeritage2) {
/* 1194 */     this.clLienActiverHeritage2 = clLienActiverHeritage2;
/*      */   }
/*      */   
/*      */   public void setClLienHeritage2(Color clLienHeritage2) {
/* 1198 */     this.clLienHeritage2 = clLienHeritage2;
/*      */   }
/*      */   
/*      */   public void setClLienNomHeritage2(Color clLienNomHeritage2) {
/* 1202 */     this.clLienNomHeritage2 = clLienNomHeritage2;
/*      */   }
/*      */   
/*      */   public void setClLienSelectHeritage2(Color clLienSelectHeritage2) {
/* 1206 */     this.clLienSelectHeritage2 = clLienSelectHeritage2;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setCode(String code)
/*      */   {
/* 1214 */     this.code = code;
/*      */   }
/*      */   
/*      */   public void setCommentaire(String commentaire) {
/* 1218 */     this.commentaire = commentaire;
/*      */   }
/*      */   
/*      */   public void setCote(int cote) {
/* 1222 */     this.cote = cote;
/*      */   }
/*      */   
/*      */   public void setEpaisseur(float epaisseur) {
/* 1226 */     this.epaisseur = epaisseur;
/*      */   }
/*      */   
/*      */   public void setEntiteRelation(IhmEntiteRelation entiteRelation) {
/* 1230 */     this.entiteRelation = entiteRelation;
/*      */   }
/*      */   
/*      */   public void setFleche(boolean fleche) {
/* 1234 */     this.fleche = fleche;
/*      */   }
/*      */   
/*      */   public void setHeritage(IhmHeritage2 heritage) {
/* 1238 */     this.heritage = heritage;
/*      */   }
/*      */   
/*      */   public void setHistorique(ArrayList<Historique> historique) {
/* 1242 */     this.historique = historique;
/*      */   }
/*      */   
/*      */   public void setPointCassure(ArrayList<IhmPoint> pointCassure) {
/* 1246 */     this.pointCassure = pointCassure;
/*      */   }
/*      */   
/*      */   public void setTangente(double tangente) {
/* 1250 */     this.tangente = tangente;
/*      */   }
/*      */   
/*      */   public void setxCard(int xCard) {
/* 1254 */     this.xCard = xCard;
/*      */   }
/*      */   
/*      */   public void setyCard(int yCard) {
/* 1258 */     this.yCard = yCard;
/*      */   }
/*      */   
/*      */   public void setZoom(double zoom) {
/* 1262 */     this.zoom = zoom;
/*      */   }
/*      */   
/*      */   public boolean isSelect()
/*      */   {
/* 1267 */     return this.selected;
/*      */   }
/*      */   
/*      */   public void setConversionHeritage(String conversionHeritage) {
/* 1271 */     this.conversionHeritage = conversionHeritage;
/*      */   }
/*      */   
/*      */   public void setFont(Font font) {
/* 1275 */     this.font = font;
/*      */   }
/*      */   
/*      */   public void setNomWH(Point nomWH) {
/* 1279 */     this.nomWH = nomWH;
/*      */   }
/*      */   
/*      */   public void setNomXY(Point nomXY) {
/* 1283 */     this.nomXY = nomXY;
/*      */   }
/*      */   
/*      */   public void setSupprimerFille(boolean supprimerFille) {
/* 1287 */     this.supprimerFille = supprimerFille;
/*      */   }
/*      */   
/*      */   public void setSupprimerMere(boolean supprimerMere) {
/* 1291 */     this.supprimerMere = supprimerMere;
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmLienContrainteHeritage2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */