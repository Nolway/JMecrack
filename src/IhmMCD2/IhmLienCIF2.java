/*      */ package IhmMCD2;
/*      */ 
/*      */ import IhmMCD.IhmCIF;
/*      */ import IhmMCD.IhmEntite;
/*      */ import IhmMCD.IhmEntiteRelation;
/*      */ import IhmMCD.IhmLienCif;
/*      */ import IhmMCD.Point;
/*      */ import Merise2.Historique;
/*      */ import ihm.FormeInterneMCD;
/*      */ import java.awt.BasicStroke;
/*      */ import java.awt.Color;
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
/*      */ public class IhmLienCIF2
/*      */   extends IhmLienCif
/*      */   implements Serializable
/*      */ {
/*      */   IhmEntiteRelation entiteRelation;
/*      */   IhmCIF2 cif;
/*      */   String nom;
/*      */   String code;
/*      */   String commentaire;
/*      */   private Color clLienCIF2;
/*      */   private Color clLienTextCIF2;
/*      */   private Color clLienNomCIF2;
/*      */   private Color clLienActiverCIF2;
/*      */   private Color clLienSelectCIF2;
/*      */   ArrayList<IhmPoint> pointCassure;
/*      */   ArrayList<Historique> historique;
/*      */   private boolean fleche;
/*      */   private double zoom;
/*      */   private double tangente;
/*      */   private boolean activer;
/*      */   private boolean selected;
/*      */   int xCard;
/*      */   int yCard;
/*      */   String conversionCIF;
/*      */   boolean correct;
/*      */   private int cote;
/*      */   public static final int COTEDROIT = 3;
/*      */   public static final int COTEHAUT = 2;
/*      */   public static final int COTEGAUCHE = 1;
/*      */   public static final int COTEBAS = 4;
/*      */   float epaisseur;
/*      */   String identifiant;
/*      */   
/*      */   public IhmLienCIF2(IhmEntite entite, IhmCIF cif)
/*      */   {
/*   66 */     super(null, null);
/*   67 */     this.entiteRelation = entite;
/*   68 */     this.cif = ((IhmCIF2)cif);
/*   69 */     this.nom = "";
/*      */     
/*   71 */     this.code = "";
/*   72 */     this.commentaire = "";
/*      */     
/*   74 */     this.clLienCIF2 = FormeInterneMCD.clLienCIF2;
/*   75 */     this.clLienTextCIF2 = FormeInterneMCD.clLienTextCIF2;
/*   76 */     this.clLienNomCIF2 = FormeInterneMCD.clLienNomCIF2;
/*   77 */     this.clLienSelectCIF2 = FormeInterneMCD.clSelected;
/*   78 */     this.clLienActiverCIF2 = FormeInterneMCD.clLienActiverCIF2;
/*      */     
/*   80 */     this.fleche = false;
/*   81 */     this.zoom = FormeInterneMCD.zoom;
/*   82 */     this.tangente = 1.0D;
/*   83 */     this.activer = false;
/*      */     
/*   85 */     this.pointCassure = new ArrayList();
/*   86 */     this.historique = new ArrayList();
/*   87 */     this.historique.add(Historique.getHistoriqueCreation());
/*   88 */     this.selected = false;
/*   89 */     this.epaisseur = FormeInterneMCD.lienContraintes2;
/*   90 */     this.conversionCIF = "";
/*   91 */     this.correct = true;
/*   92 */     this.identifiant = "";
/*      */   }
/*      */   
/*      */   public IhmLienCIF2(IhmEntiteRelation entite, IhmCIF cif, String nom)
/*      */   {
/*   97 */     super(null, null);
/*   98 */     this.entiteRelation = entite;
/*   99 */     this.cif = ((IhmCIF2)cif);
/*  100 */     this.nom = nom;
/*      */     
/*  102 */     this.code = "";
/*  103 */     this.commentaire = "";
/*      */     
/*  105 */     this.clLienCIF2 = FormeInterneMCD.clLienCIF2;
/*  106 */     this.clLienTextCIF2 = FormeInterneMCD.clLienTextCIF2;
/*  107 */     this.clLienNomCIF2 = FormeInterneMCD.clLienNomCIF2;
/*  108 */     this.clLienSelectCIF2 = FormeInterneMCD.clSelected;
/*  109 */     this.clLienActiverCIF2 = FormeInterneMCD.clLienActiverCIF2;
/*      */     
/*  111 */     this.fleche = false;
/*  112 */     this.zoom = FormeInterneMCD.zoom;
/*  113 */     this.tangente = 1.0D;
/*  114 */     this.activer = false;
/*      */     
/*  116 */     this.pointCassure = new ArrayList();
/*  117 */     this.historique = new ArrayList();
/*  118 */     this.historique.add(Historique.getHistoriqueCreation());
/*  119 */     this.selected = false;
/*  120 */     this.epaisseur = FormeInterneMCD.lienContraintes2;
/*  121 */     this.conversionCIF = "";
/*  122 */     this.correct = true;
/*  123 */     this.identifiant = "";
/*      */   }
/*      */   
/*      */   public void paint(Graphics g)
/*      */   {
/*  128 */     Graphics2D g2d = (Graphics2D)g;
/*  129 */     dessinerLien(g2d);
/*  130 */     if (isSelected()) {
/*  131 */       DessinerTousLesPointSansLien(g2d);
/*      */     }
/*      */   }
/*      */   
/*      */   private void DessinerTousLesPointSansLien(Graphics2D gr) {
/*  136 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  137 */       gr.setColor(getClLien());
/*      */       
/*  139 */       if (isSelected()) {
/*  140 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFond());
/*  141 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*      */       }
/*  143 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/*  144 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFondSelect());
/*  145 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void coteIntersectionEntite()
/*      */   {
/*  154 */     int xe = getEntiteRelation().getCentreX();
/*  155 */     int ye = getEntiteRelation().getCentreY();
/*      */     
/*  157 */     int xr = getCif().getCentreX();
/*  158 */     int yr = getCif().getCentreY();
/*      */     
/*  160 */     if (this.pointCassure.size() > 0) {
/*  161 */       xr = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/*  162 */       yr = ((IhmPoint)this.pointCassure.get(0)).getYCentre();
/*      */     }
/*      */     
/*  165 */     int x1 = getEntiteRelation().getX();
/*  166 */     int y1 = getEntiteRelation().getY();
/*  167 */     int x2 = getEntiteRelation().getX();
/*  168 */     int y2 = getEntiteRelation().getY() + getEntiteRelation().getHeight();
/*      */     
/*  170 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/*  171 */       this.cote = 1;
/*  172 */       return;
/*      */     }
/*      */     
/*  175 */     x1 = getEntiteRelation().getX();
/*  176 */     y1 = getEntiteRelation().getY();
/*  177 */     x2 = getEntiteRelation().getX() + getEntiteRelation().getWidth();
/*  178 */     y2 = getEntiteRelation().getY();
/*      */     
/*  180 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/*  181 */       this.cote = 2;
/*  182 */       return;
/*      */     }
/*      */     
/*  185 */     x1 = getEntiteRelation().getX() + getEntiteRelation().getWidth();
/*  186 */     y1 = getEntiteRelation().getY();
/*  187 */     x2 = getEntiteRelation().getX() + getEntiteRelation().getWidth();
/*  188 */     y2 = getEntiteRelation().getY() + getEntiteRelation().getHeight();
/*      */     
/*  190 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/*  191 */       this.cote = 3;
/*  192 */       return;
/*      */     }
/*      */     
/*  195 */     x1 = getEntiteRelation().getX();
/*  196 */     y1 = getEntiteRelation().getY() + getEntiteRelation().getHeight();
/*  197 */     x2 = getEntiteRelation().getX() + getEntiteRelation().getWidth();
/*  198 */     y2 = getEntiteRelation().getY() + getEntiteRelation().getHeight();
/*      */     
/*  200 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/*  201 */       this.cote = 4;
/*  202 */       return;
/*      */     }
/*      */   }
/*      */   
/*      */   private Point getLastPoint() {
/*  207 */     if (this.pointCassure.size() == 0) {
/*  208 */       return new Point(getCif().getCentreX(), getCif().getCentreY());
/*      */     }
/*  210 */     return ((IhmPoint)this.pointCassure.get(0)).getPoint();
/*      */   }
/*      */   
/*      */   private boolean segmentSelect(int xs, int ys, int xt, int yt, int xx, int yy)
/*      */   {
/*  215 */     if (Line2D.linesIntersect(xs, ys, xt, yt, xx - 5, yy - 5, xx + 5, yy + 5)) return true;
/*  216 */     if (Line2D.linesIntersect(xs, ys, xt, yt, xx + 5, yy - 5, xx - 5, yy + 5)) return true;
/*  217 */     return false;
/*      */   }
/*      */   
/*      */   private boolean listePointEdentique(ArrayList<IhmPoint> liste) {
/*  221 */     if (liste.size() != this.pointCassure.size()) return false;
/*  222 */     for (int i = 0; i < liste.size(); i++) {
/*  223 */       if ((((IhmPoint)liste.get(i)).getX() != ((IhmPoint)this.pointCassure.get(i)).getX()) || (((IhmPoint)liste.get(i)).getY() != ((IhmPoint)this.pointCassure.get(i)).getY())) return false;
/*      */     }
/*  225 */     return true;
/*      */   }
/*      */   
/*      */   public boolean egale(IhmLienCIF2 lien) {
/*  229 */     if ((lien.getEntiteRelation() != getEntiteRelation()) || (getCif() != lien.getCif())) return false;
/*  230 */     return listePointEdentique(lien.getPointCassure());
/*      */   }
/*      */   
/*      */   public void supprimerPointSelectionner() {
/*  234 */     int nb = this.pointCassure.size();
/*  235 */     int i = 0;
/*  236 */     while (i < nb) {
/*  237 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/*  238 */         this.pointCassure.remove(i);
/*  239 */         nb--;
/*      */       } else {
/*  241 */         i++;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean deplacerPointSelectionner(int x, int y) {
/*  247 */     int nb = this.pointCassure.size();
/*  248 */     boolean dep = false;
/*  249 */     for (int i = 0; i < nb; i++) {
/*  250 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/*  251 */         dep = true;
/*  252 */         ((IhmPoint)this.pointCassure.get(i)).move(((IhmPoint)this.pointCassure.get(i)).getX() - x, ((IhmPoint)this.pointCassure.get(i)).getY() - y);
/*      */       }
/*      */     }
/*  255 */     return dep;
/*      */   }
/*      */   
/*      */   public int XMaxPointSelectionner() {
/*  259 */     int nb = this.pointCassure.size();
/*  260 */     int xg = 0;
/*  261 */     for (int i = 0; i < nb; i++) {
/*  262 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/*  263 */         (xg < ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth())) {
/*  264 */         xg = ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth();
/*      */       }
/*      */     }
/*      */     
/*  268 */     return xg;
/*      */   }
/*      */   
/*      */   public int YMaxPointSelectionner() {
/*  272 */     int nb = this.pointCassure.size();
/*  273 */     int xg = 0;
/*  274 */     for (int i = 0; i < nb; i++) {
/*  275 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/*  276 */         (xg < ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight())) {
/*  277 */         xg = ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight();
/*      */       }
/*      */     }
/*      */     
/*  281 */     return xg;
/*      */   }
/*      */   
/*      */   public int XMaxAllPoint() {
/*  285 */     int nb = this.pointCassure.size();
/*  286 */     int xg = 0;
/*  287 */     for (int i = 0; i < nb; i++)
/*      */     {
/*  289 */       if (xg < ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth()) {
/*  290 */         xg = ((IhmPoint)this.pointCassure.get(i)).getX() + ((IhmPoint)this.pointCassure.get(i)).getWidth();
/*      */       }
/*      */     }
/*      */     
/*  294 */     return xg;
/*      */   }
/*      */   
/*      */   public int YMaxAllPoint() {
/*  298 */     int nb = this.pointCassure.size();
/*  299 */     int xg = 0;
/*  300 */     for (int i = 0; i < nb; i++)
/*      */     {
/*  302 */       if (xg < ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight()) {
/*  303 */         xg = ((IhmPoint)this.pointCassure.get(i)).getY() + ((IhmPoint)this.pointCassure.get(i)).getHeight();
/*      */       }
/*      */     }
/*      */     
/*  307 */     return xg;
/*      */   }
/*      */   
/*      */   public int XMinPointSelectionner() {
/*  311 */     int nb = this.pointCassure.size();
/*  312 */     int xg = Integer.MAX_VALUE;
/*  313 */     for (int i = 0; i < nb; i++) {
/*  314 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/*  315 */         (xg > ((IhmPoint)this.pointCassure.get(i)).getX())) {
/*  316 */         xg = ((IhmPoint)this.pointCassure.get(i)).getX();
/*      */       }
/*      */     }
/*      */     
/*  320 */     return xg;
/*      */   }
/*      */   
/*      */   public int YMinPointSelectionner() {
/*  324 */     int nb = this.pointCassure.size();
/*  325 */     int xg = Integer.MAX_VALUE;
/*  326 */     for (int i = 0; i < nb; i++) {
/*  327 */       if ((((IhmPoint)this.pointCassure.get(i)).isSelected()) && 
/*  328 */         (xg > ((IhmPoint)this.pointCassure.get(i)).getY())) {
/*  329 */         xg = ((IhmPoint)this.pointCassure.get(i)).getY();
/*      */       }
/*      */     }
/*      */     
/*  333 */     return xg; }
/*      */   
/*      */   private double tangeanteEntite() {
/*      */     int xt;
/*      */     int yt;
/*  338 */     if (this.pointCassure.size() == 0) {
/*  339 */       xt = getCif().getCentreX();
/*  340 */       yt = getCif().getCentreY();
/*      */     } else {
/*  342 */       xt = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/*  343 */       yt = ((IhmPoint)this.pointCassure.get(0)).getYCentre();
/*      */     }
/*  345 */     double d1 = getEntiteRelation().getCentreX() - xt;
/*  346 */     double d2 = getEntiteRelation().getCentreY() - yt;
/*  347 */     return d2 / d1;
/*      */   }
/*      */   
/*      */   private boolean isEntiteMemeX()
/*      */   {
/*  352 */     int x = getCif().getCentreX();
/*      */     
/*  354 */     if (this.pointCassure.size() > 0) {
/*  355 */       x = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/*      */     }
/*  357 */     if (getEntiteRelation().getCentreX() == x) return true;
/*  358 */     return false;
/*      */   }
/*      */   
/*      */   private void calculPointCardinaliteMemeXEntite()
/*      */   {
/*  363 */     int x = getEntiteRelation().getCentreX();
/*  364 */     if (this.cote == 2) {
/*  365 */       this.xCard = x;
/*  366 */       this.yCard = getEntiteRelation().getY();
/*      */     }
/*      */     
/*  369 */     if (this.cote == 4) {
/*  370 */       this.xCard = x;
/*      */       
/*  372 */       this.yCard = (getEntiteRelation().getY() + getEntiteRelation().getHeight());
/*  373 */       if (getEntiteRelation().isOmbre()) { this.yCard += 3;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void calculPointCardinaliteEntite()
/*      */   {
/*  380 */     if (isEntiteMemeX()) {
/*  381 */       calculPointCardinaliteMemeXEntite();
/*      */     }
/*      */     else {
/*  384 */       double tag = tangeanteEntite();
/*  385 */       this.tangente = tag;
/*  386 */       int y1 = getEntiteRelation().getCentreY();
/*  387 */       int x1 = getEntiteRelation().getCentreX();
/*  388 */       if (this.cote == 1) {
/*  389 */         this.xCard = getEntiteRelation().getX();
/*  390 */         this.yCard = ((int)(tag * this.xCard + (y1 - tag * x1)));
/*      */       }
/*      */       
/*      */ 
/*  394 */       if (this.cote == 3) {
/*  395 */         this.xCard = (getEntiteRelation().getX() + getEntiteRelation().getWidth());
/*  396 */         if (getEntiteRelation().isOmbre()) this.xCard += 3;
/*  397 */         this.yCard = ((int)(tag * this.xCard + (y1 - tag * x1)));
/*      */       }
/*      */       
/*  400 */       if (this.cote == 2) {
/*  401 */         int dec = (int)(15.0D - Math.abs(Math.atan(this.tangente)) * 10.0D);
/*  402 */         this.yCard = getEntiteRelation().getY();
/*  403 */         if (getEntiteRelation().isOmbre()) this.yCard += 3;
/*  404 */         this.xCard = ((int)((this.yCard - (y1 - tag * x1)) / tag));
/*      */       }
/*      */       
/*  407 */       if (this.cote == 4) {
/*  408 */         this.yCard = (getEntiteRelation().getY() + getEntiteRelation().getHeight());
/*      */         
/*  410 */         if (getEntiteRelation().isOmbre()) { this.yCard += 4;
/*      */         }
/*  412 */         this.xCard = ((int)((this.yCard - (y1 - tag * x1)) / tag));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void calculerXYCardianlite() {
/*  418 */     coteIntersectionEntite();
/*  419 */     calculPointCardinaliteEntite();
/*      */   }
/*      */   
/*      */   public boolean estDans(int xd, int yd, int xf, int yf) {
/*  423 */     if (getPointCassure().size() > 0) {
/*  424 */       for (int i = 0; i < getPointCassure().size(); i++) {
/*  425 */         if (!((IhmPoint)getPointCassure().get(i)).isSelected()) return false;
/*      */       }
/*  427 */       return true;
/*      */     }
/*      */     
/*  430 */     int x1 = xd;
/*  431 */     int x2 = xf;
/*  432 */     int y1 = yd;
/*  433 */     int y2 = yf;
/*  434 */     if (xd > xf) {
/*  435 */       x1 = xf;
/*  436 */       x2 = xd;
/*      */     }
/*  438 */     if (yd > yf) {
/*  439 */       y1 = yf;
/*  440 */       y2 = yd;
/*      */     }
/*  442 */     Rectangle2D rec = new Rectangle2D.Double(x1, y1, x2 - x1, y2 - y1);
/*  443 */     if ((rec.contains(getEntiteRelation().getCentreX(), getEntiteRelation().getCentreY())) && (rec.contains(getCif().getCentreX(), getCif().getCentreY())))
/*  444 */       return true;
/*  445 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean addBreakPoint(int x, int y)
/*      */   {
/*  452 */     int xs = getEntiteRelation().getCentreX();
/*  453 */     int ys = getEntiteRelation().getCentreY();
/*  454 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  455 */       int xt = ((IhmPoint)this.pointCassure.get(i)).getPoint().getX();
/*  456 */       int yt = ((IhmPoint)this.pointCassure.get(i)).getPoint().getY();
/*  457 */       if (segmentSelect(xs, ys, xt, yt, x, y)) {
/*  458 */         IhmPoint p = new IhmPoint(x, y);
/*  459 */         this.pointCassure.add(i, p);
/*  460 */         p.setSelected(true);
/*  461 */         return true;
/*      */       }
/*  463 */       xs = xt;
/*  464 */       ys = yt;
/*      */     }
/*  466 */     if (segmentSelect(xs, ys, getCif().getCentreX(), getCif().getCentreY(), x, y)) {
/*  467 */       IhmPoint p = new IhmPoint(x, y);
/*  468 */       this.pointCassure.add(p);
/*  469 */       p.setSelected(true);
/*  470 */       return true;
/*      */     }
/*  472 */     return false;
/*      */   }
/*      */   
/*      */   private Point rotation(double x, double y, double tg) {
/*  476 */     Point p = new Point(0, 0);
/*  477 */     double x1 = 0.0D;double y1 = 0.0D;double rac = 0.0D;
/*  478 */     rac = Math.sqrt(Math.pow(tg, 2.0D) + 1.0D);
/*  479 */     x1 = (x - y * tg) / rac;
/*  480 */     y1 = (y + x * tg) / rac;
/*  481 */     p.setX((int)x1);
/*  482 */     p.setY((int)y1);
/*  483 */     return p;
/*      */   }
/*      */   
/*      */   public void dessinerFleche(Graphics2D gr) {
/*  487 */     gr.setColor(this.clLienCIF2);
/*  488 */     if (isActiver()) gr.setColor(getClLienActiverCIF2());
/*  489 */     if (isSelected()) { gr.setColor(getClLienSelectCIF2());
/*      */     }
/*  491 */     Point lp = getLastPoint();
/*      */     
/*  493 */     if (isEntiteMemeX()) {
/*  494 */       if (this.cote == 2) {
/*  495 */         int[] x = new int[3];
/*  496 */         int[] y = new int[3];
/*  497 */         int xfleche = 5;
/*  498 */         int yfleche = 10;
/*  499 */         x[0] = getEntiteRelation().getCentreX();
/*  500 */         y[0] = getEntiteRelation().getY();
/*      */         
/*  502 */         x[1] = (x[0] - xfleche);
/*  503 */         y[1] = (y[0] - yfleche);
/*      */         
/*  505 */         x[2] = (x[0] + xfleche);
/*  506 */         y[2] = (y[0] - yfleche);
/*      */         
/*  508 */         gr.fillPolygon(x, y, 3);
/*      */       }
/*      */       
/*  511 */       if (this.cote == 4) {
/*  512 */         int[] x = new int[3];
/*  513 */         int[] y = new int[3];
/*  514 */         int xfleche = 5;
/*  515 */         int yfleche = 10;
/*  516 */         x[0] = getEntiteRelation().getCentreX();
/*  517 */         y[0] = (getEntiteRelation().getY() + getEntiteRelation().getHeight());
/*  518 */         if (getEntiteRelation().isOmbre()) y[0] += 4;
/*  519 */         x[1] = (x[0] - xfleche);
/*  520 */         y[1] = (y[0] + yfleche);
/*      */         
/*  522 */         x[2] = (x[0] + xfleche);
/*  523 */         y[2] = (y[0] + yfleche);
/*      */         
/*  525 */         gr.fillPolygon(x, y, 3);
/*      */       }
/*  527 */       return;
/*      */     }
/*      */     
/*  530 */     double tan = getEntiteRelation().getCentreY() - lp.getY();
/*  531 */     tan /= (getEntiteRelation().getCentreX() - lp.getX());
/*      */     
/*  533 */     int[] x = new int[3];
/*  534 */     int[] y = new int[3];
/*      */     
/*      */ 
/*      */ 
/*  538 */     int posi = this.cote;
/*      */     
/*  540 */     Point p = new Point(this.xCard, this.yCard);
/*      */     
/*      */ 
/*  543 */     int xfleche = 10;
/*  544 */     int yfleche = 5;
/*      */     
/*  546 */     x[0] = p.getX();
/*  547 */     y[0] = p.getY();
/*  548 */     int dx = x[0];
/*  549 */     int dy = y[0];
/*  550 */     p = rotation(x[0], y[0], tan);
/*  551 */     dx -= p.getX();
/*  552 */     dy -= p.getY();
/*      */     
/*      */ 
/*  555 */     if (posi == 1)
/*      */     {
/*  557 */       x[0] = (p.getX() + dx);
/*  558 */       y[0] = (p.getY() + dy);
/*      */       
/*  560 */       p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/*  561 */       x[1] = p.getX();
/*  562 */       y[1] = p.getY();
/*      */       
/*  564 */       x[1] += dx;
/*  565 */       y[1] += dy;
/*      */       
/*  567 */       p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/*  568 */       x[2] = (p.getX() + dx);
/*  569 */       y[2] = (p.getY() + dy);
/*      */       
/*  571 */       gr.fillPolygon(x, y, 3);
/*      */     }
/*  573 */     if (posi == 3) {
/*  574 */       x[0] = (p.getX() + dx);
/*  575 */       y[0] = (p.getY() + dy);
/*      */       
/*  577 */       p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/*  578 */       x[1] = p.getX();
/*  579 */       y[1] = p.getY();
/*      */       
/*  581 */       x[1] += dx;
/*  582 */       y[1] += dy;
/*      */       
/*      */ 
/*  585 */       p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/*  586 */       x[2] = (p.getX() + dx);
/*  587 */       y[2] = (p.getY() + dy);
/*      */       
/*  589 */       gr.fillPolygon(x, y, 3);
/*      */     }
/*      */     
/*  592 */     if (posi == 4) {
/*  593 */       if (getEntiteRelation().getCentreX() < lp.getX()) {
/*  594 */         x[0] = (p.getX() + dx);
/*  595 */         y[0] = (p.getY() + dy);
/*      */         
/*  597 */         p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/*  598 */         x[1] = (p.getX() + dx);
/*  599 */         y[1] = (p.getY() + dy);
/*      */         
/*  601 */         p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/*  602 */         x[2] = (p.getX() + dx);
/*  603 */         y[2] = (p.getY() + dy);
/*      */       } else {
/*  605 */         x[0] = (p.getX() + dx);
/*  606 */         y[0] = (p.getY() + dy);
/*      */         
/*  608 */         p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/*  609 */         x[1] = (p.getX() + dx);
/*  610 */         y[1] = (p.getY() + dy);
/*      */         
/*  612 */         p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/*  613 */         x[2] = (p.getX() + dx);
/*  614 */         y[2] = (p.getY() + dy);
/*      */       }
/*      */       
/*  617 */       gr.fillPolygon(x, y, 3);
/*      */     }
/*      */     
/*  620 */     if (posi == 2) {
/*  621 */       if (getEntiteRelation().getCentreX() > lp.getX()) {
/*  622 */         tan = lp.getY() - getEntiteRelation().getCentreY();
/*  623 */         tan /= (lp.getX() - getEntiteRelation().getCentreX());
/*      */         
/*  625 */         x[0] = (p.getX() + dx);
/*  626 */         y[0] = (p.getY() + dy);
/*      */         
/*  628 */         p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/*  629 */         x[1] = p.getX();
/*  630 */         y[1] = p.getY();
/*      */         
/*  632 */         x[1] += dx;
/*  633 */         y[1] += dy;
/*      */         
/*  635 */         p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/*  636 */         x[2] = (p.getX() + dx);
/*  637 */         y[2] = (p.getY() + dy);
/*      */       }
/*      */       else {
/*  640 */         x[0] = (p.getX() + dx);
/*  641 */         y[0] = (p.getY() + dy);
/*      */         
/*  643 */         p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/*  644 */         x[1] = p.getX();
/*  645 */         y[1] = p.getY();
/*      */         
/*  647 */         x[1] += dx;
/*  648 */         y[1] += dy;
/*      */         
/*  650 */         p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/*  651 */         x[2] = (p.getX() + dx);
/*  652 */         y[2] = (p.getY() + dy);
/*      */       }
/*  654 */       gr.fillPolygon(x, y, 3);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void DessinerTousLesPoint(Graphics2D gr)
/*      */   {
/*  663 */     int x0 = getEntiteRelation().getCentreX();
/*  664 */     int y0 = getEntiteRelation().getCentreY();
/*  665 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  666 */       gr.setColor(getClLienCIF2());
/*  667 */       if (isActiver()) gr.setColor(getClLienActiverCIF2());
/*  668 */       if (isSelected()) gr.setColor(getClLienSelectCIF2());
/*  669 */       gr.drawLine(x0, y0, ((IhmPoint)this.pointCassure.get(i)).getXCentre(), ((IhmPoint)this.pointCassure.get(i)).getYCentre());
/*  670 */       x0 = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/*  671 */       y0 = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/*  672 */       if (isSelected()) {
/*  673 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFond());
/*  674 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*      */       }
/*  676 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/*  677 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFondSelect());
/*  678 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*      */       }
/*  680 */       x0 = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/*  681 */       y0 = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/*      */     }
/*  683 */     gr.setColor(this.clLienCIF2);
/*  684 */     if (isActiver()) gr.setColor(getClLienActiverCIF2());
/*  685 */     if (isSelected()) { gr.setColor(getClLienSelectCIF2());
/*      */     }
/*  687 */     gr.drawLine(x0, y0, getCif().getCentreX(), getCif().getCentreY());
/*      */   }
/*      */   
/*      */   public void ajouterModification() {
/*  691 */     Historique h = Historique.getHistoriqueModification();
/*  692 */     Historique h1 = (Historique)this.historique.get(this.historique.size() - 1);
/*  693 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur()))) {
/*  694 */       getHistorique().add(h);
/*      */     }
/*      */   }
/*      */   
/*      */   private void dessinerLien(Graphics2D gr) {
/*  699 */     Graphics2D g2d = gr;
/*  700 */     Stroke stro = g2d.getStroke();
/*  701 */     if ((getEntiteRelation() instanceof IhmRelation2)) {
/*  702 */       float[] style = { 5.0F, 5.0F };
/*  703 */       g2d.setStroke(new BasicStroke(this.epaisseur, 0, 0, 10.0F, style, 0.0F));
/*      */       
/*  705 */       DessinerTousLesPoint(g2d);
/*      */     }
/*      */     else {
/*  708 */       float[] style = { 5.0F, 0.0F };
/*  709 */       g2d.setStroke(new BasicStroke(this.epaisseur, 0, 0, 10.0F, style, 0.0F));
/*      */       
/*  711 */       DessinerTousLesPoint(gr);
/*  712 */       if (isFleche()) {
/*  713 */         calculerXYCardianlite();
/*  714 */         dessinerFleche(gr);
/*      */       }
/*      */     }
/*      */     
/*  718 */     g2d.setStroke(stro);
/*      */   }
/*      */   
/*      */ 
/*      */   public void setSelected(boolean selected)
/*      */   {
/*  724 */     this.selected = selected;
/*  725 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  726 */       ((IhmPoint)this.pointCassure.get(i)).setDesigner(selected);
/*  727 */       if (!selected) {
/*  728 */         ((IhmPoint)this.pointCassure.get(i)).setSelected(false);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IhmPoint getSelectedPointCassure(int x, int y)
/*      */   {
/*  735 */     IhmPoint p = null;
/*  736 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  737 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected(x, y)) {
/*  738 */         p = (IhmPoint)this.pointCassure.get(i);
/*      */       }
/*      */     }
/*  741 */     return p;
/*      */   }
/*      */   
/*      */   public boolean isSelected(int x, int y)
/*      */   {
/*  746 */     if (getSelectedPointCassure(x, y) != null) { return true;
/*      */     }
/*      */     
/*      */ 
/*  750 */     int xs = getEntiteRelation().getCentreX();
/*  751 */     int ys = getEntiteRelation().getCentreY();
/*  752 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  753 */       int xt = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/*  754 */       int yt = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/*  755 */       if (segmentSelect(xs, ys, xt, yt, x, y)) {
/*  756 */         return true;
/*      */       }
/*  758 */       xs = xt;
/*  759 */       ys = yt;
/*      */     }
/*      */     
/*  762 */     int xt = getCif().getCentreX();
/*  763 */     int yt = getCif().getCentreY();
/*      */     
/*  765 */     return segmentSelect(xs, ys, xt, yt, x, y);
/*      */   }
/*      */   
/*      */   public void ajouterCopier(ArrayList<Historique> lhis)
/*      */   {
/*  770 */     Historique h = Historique.getHistoriqueCopie();
/*  771 */     Historique h1 = (Historique)lhis.get(lhis.size() - 1);
/*  772 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur())) || (!h.getAction().equals(h1.getAction())))
/*      */     {
/*  774 */       lhis.add(h);
/*      */     }
/*      */   }
/*      */   
/*      */   public ArrayList<Historique> copierHistoriques(ArrayList<Historique> lhis) {
/*  779 */     ArrayList<Historique> l = new ArrayList();
/*  780 */     for (int i = 0; i < lhis.size(); i++) {
/*  781 */       l.add(((Historique)lhis.get(i)).copier());
/*      */     }
/*  783 */     return l;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmPoint> copierListePointDeCassure() {
/*  787 */     ArrayList<IhmPoint> liste = new ArrayList();
/*  788 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  789 */       IhmPoint p = ((IhmPoint)this.pointCassure.get(i)).copier();
/*  790 */       p.setX(p.getX() + 10);
/*  791 */       p.setY(p.getY() + 10);
/*  792 */       p.setSelected(true);
/*  793 */       liste.add(p);
/*      */     }
/*  795 */     return liste;
/*      */   }
/*      */   
/*      */ 
/*      */   public IhmLienCIF2 copier(IhmEntiteRelation ent, IhmCIF rel)
/*      */   {
/*  801 */     IhmLienCIF2 lien = new IhmLienCIF2(ent, rel, getNom());
/*      */     
/*      */ 
/*  804 */     lien.setNom(getNom());
/*  805 */     lien.setClLienCIF2(getClLienCIF2());
/*  806 */     lien.setClLienTextCIF2(getClLienTextCIF2());
/*  807 */     lien.setClLienNomCIF2(getClLienNomCIF2());
/*  808 */     lien.setClLienActiverCIF2(getClLienActiverCIF2());
/*  809 */     lien.setClLienSelectCIF2(getClLienSelectCIF2());
/*      */     
/*      */ 
/*      */ 
/*  813 */     lien.setCommentaire(getCommentaire());
/*      */     
/*  815 */     lien.setCode(getCode());
/*      */     
/*  817 */     lien.setFleche(isFleche());
/*  818 */     lien.setZoom(getZoom());
/*      */     
/*  820 */     lien.setPointCassure(copierListePointDeCassure());
/*  821 */     lien.setHistorique(copierHistoriques(this.historique));
/*  822 */     ajouterCopier(lien.getHistorique());
/*  823 */     return lien;
/*      */   }
/*      */   
/*      */   public static IhmLienCIF2 parseIhmLienCIF(IhmLienCif lien, IhmEntiteRelation newEnt, IhmCIF2 newCif)
/*      */   {
/*  828 */     IhmLienCIF2 l = new IhmLienCIF2(newEnt, newCif, lien.getNom());
/*      */     
/*  830 */     l.setNom(lien.getNom());
/*  831 */     l.setCode(lien.getNom().toUpperCase());
/*      */     
/*  833 */     l.setClLienNomCIF2(IhmLienCif.getClLien());
/*  834 */     l.setClLienCIF2(IhmLienCif.getClLien());
/*  835 */     l.setClLienTextCIF2(IhmLienCif.getClLien());
/*  836 */     l.setFleche(lien.isCible());
/*      */     
/*  838 */     l.setClLienNomCIF2(FormeInterneMCD.clLienNomCIF2);
/*  839 */     l.setClLienCIF2(FormeInterneMCD.clLienCIF2);
/*  840 */     l.setClLienTextCIF2(FormeInterneMCD.clLienTextCIF2);
/*      */     
/*  842 */     l.setCommentaire("");
/*      */     
/*  844 */     if (lien.isCassure()) {
/*  845 */       l.getPointCassure().add(new IhmPoint((int)lien.getxCassure(), (int)lien.getyCassure()));
/*      */     }
/*      */     
/*  848 */     return l;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean isActiver()
/*      */   {
/*  855 */     return this.activer;
/*      */   }
/*      */   
/*      */   public IhmCIF2 getCif()
/*      */   {
/*  860 */     return this.cif;
/*      */   }
/*      */   
/*      */   public Color getClLienActiverCIF2() {
/*  864 */     return this.clLienActiverCIF2;
/*      */   }
/*      */   
/*      */   public Color getClLienCIF2() {
/*  868 */     return this.clLienCIF2;
/*      */   }
/*      */   
/*      */   public Color getClLienNomCIF2() {
/*  872 */     return this.clLienNomCIF2;
/*      */   }
/*      */   
/*      */   public Color getClLienSelectCIF2() {
/*  876 */     return this.clLienSelectCIF2;
/*      */   }
/*      */   
/*      */   public Color getClLienTextCIF2() {
/*  880 */     return this.clLienTextCIF2;
/*      */   }
/*      */   
/*      */   public String getCode() {
/*  884 */     return this.code;
/*      */   }
/*      */   
/*      */   public float getEpaisseur() {
/*  888 */     return this.epaisseur;
/*      */   }
/*      */   
/*      */   public String getCommentaire() {
/*  892 */     return this.commentaire;
/*      */   }
/*      */   
/*      */   public int getCote() {
/*  896 */     return this.cote;
/*      */   }
/*      */   
/*      */   public String getIdentifiant() {
/*  900 */     return this.identifiant;
/*      */   }
/*      */   
/*      */   public IhmEntiteRelation getEntiteRelation() {
/*  904 */     return this.entiteRelation;
/*      */   }
/*      */   
/*      */   public boolean isFleche() {
/*  908 */     return this.fleche;
/*      */   }
/*      */   
/*      */   public ArrayList<Historique> getHistorique() {
/*  912 */     return this.historique;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmPoint> getPointCassure() {
/*  916 */     return this.pointCassure;
/*      */   }
/*      */   
/*      */   public double getTangente() {
/*  920 */     return this.tangente;
/*      */   }
/*      */   
/*      */   public int getxCard() {
/*  924 */     return this.xCard;
/*      */   }
/*      */   
/*      */   public int getyCard() {
/*  928 */     return this.yCard;
/*      */   }
/*      */   
/*      */   public double getZoom() {
/*  932 */     return this.zoom;
/*      */   }
/*      */   
/*      */   public void setActiver(boolean activer) {
/*  936 */     this.activer = activer;
/*      */   }
/*      */   
/*      */   public void setCif(IhmCIF2 cif) {
/*  940 */     this.cif = cif;
/*      */   }
/*      */   
/*      */   public void setEpaisseur(float epaisseur) {
/*  944 */     this.epaisseur = epaisseur;
/*      */   }
/*      */   
/*      */   public void setClLienActiverCIF2(Color clLienActiverCIF2) {
/*  948 */     this.clLienActiverCIF2 = clLienActiverCIF2;
/*      */   }
/*      */   
/*      */   public void setClLienCIF2(Color clLienCIF2) {
/*  952 */     this.clLienCIF2 = clLienCIF2;
/*      */   }
/*      */   
/*      */   public void setClLienNomCIF2(Color clLienNomCIF2) {
/*  956 */     this.clLienNomCIF2 = clLienNomCIF2;
/*      */   }
/*      */   
/*      */   public void setClLienSelectCIF2(Color clLienSelectCIF2) {
/*  960 */     this.clLienSelectCIF2 = clLienSelectCIF2;
/*      */   }
/*      */   
/*      */   public void setClLienTextCIF2(Color clLienTextCIF2) {
/*  964 */     this.clLienTextCIF2 = clLienTextCIF2;
/*      */   }
/*      */   
/*      */   public void setCode(String code) {
/*  968 */     this.code = code;
/*      */   }
/*      */   
/*      */   public void setCommentaire(String commentaire) {
/*  972 */     this.commentaire = commentaire;
/*      */   }
/*      */   
/*      */   public void setIdentifiant(String identifiant) {
/*  976 */     this.identifiant = identifiant;
/*      */   }
/*      */   
/*      */   public void setCote(int cote) {
/*  980 */     this.cote = cote;
/*      */   }
/*      */   
/*      */   public void setEntite(IhmEntiteRelation entite) {
/*  984 */     this.entiteRelation = entite;
/*      */   }
/*      */   
/*      */   public void setFleche(boolean fleche) {
/*  988 */     this.fleche = fleche;
/*      */   }
/*      */   
/*      */   public void setHistorique(ArrayList<Historique> historique) {
/*  992 */     this.historique = historique;
/*      */   }
/*      */   
/*      */   public void setPointCassure(ArrayList<IhmPoint> pointCassure) {
/*  996 */     this.pointCassure = pointCassure;
/*      */   }
/*      */   
/*      */   public void setTangente(double tangente) {
/* 1000 */     this.tangente = tangente;
/*      */   }
/*      */   
/*      */   public void setxCard(int xCard) {
/* 1004 */     this.xCard = xCard;
/*      */   }
/*      */   
/*      */   public void setyCard(int yCard) {
/* 1008 */     this.yCard = yCard;
/*      */   }
/*      */   
/*      */   public void setZoom(double zoom) {
/* 1012 */     this.zoom = zoom;
/*      */   }
/*      */   
/*      */   public void setEntiteRelation(IhmEntiteRelation entiteRelation) {
/* 1016 */     this.entiteRelation = entiteRelation;
/*      */   }
/*      */   
/*      */   public boolean isSelected() {
/* 1020 */     return this.selected;
/*      */   }
/*      */   
/*      */   public String getConversionCIF() {
/* 1024 */     return this.conversionCIF;
/*      */   }
/*      */   
/*      */   public boolean isCorrect() {
/* 1028 */     return this.correct;
/*      */   }
/*      */   
/*      */   public void setConversionCIF(String conversionCIF) {
/* 1032 */     this.conversionCIF = conversionCIF;
/*      */   }
/*      */   
/*      */   public void setCorrect(boolean correct) {
/* 1036 */     this.correct = correct;
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmLienCIF2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */