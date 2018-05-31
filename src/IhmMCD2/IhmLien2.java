/*      */ package IhmMCD2;
/*      */ 
/*      */ import IhmMCD.IhmEntite;
/*      */ import IhmMCD.IhmEntiteRelation;
/*      */ import IhmMCD.IhmLien;
/*      */ import IhmMCD.IhmRelation;
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
/*      */ public class IhmLien2
/*      */   extends IhmLien
/*      */   implements Serializable
/*      */ {
/*      */   private IhmCardinalite cardinalites;
/*      */   private Color clLien2;
/*      */   private Color clLienText2;
/*      */   private Color clLienNom2;
/*      */   private Color clLienActiver;
/*      */   private Color clLienSelect;
/*      */   private String commentaire;
/*      */   private String historisation;
/*      */   private String code;
/*      */   private boolean fleche;
/*      */   private boolean relatif;
/*      */   private double zoom;
/*      */   private double tangente;
/*      */   private boolean activer;
/*      */   private Font font;
/*      */   private int coteEntite;
/*      */   private int coteRelation;
/*      */   public static final int COTEDROIT = 3;
/*      */   public static final int COTEHAUT = 2;
/*      */   public static final int COTEGAUCHE = 1;
/*      */   public static final int COTEBAS = 4;
/*      */   ArrayList<IhmPoint> pointCassure;
/*      */   ArrayList<Historique> historique;
/*      */   int xCard;
/*      */   int yCard;
/*      */   int xCardRel;
/*      */   int yCardRel;
/*      */   Point nomXY;
/*      */   Point nomWH;
/*      */   float epaisseur;
/*      */   boolean cardinaliteMajuscule;
/*      */   boolean cardinalite2points;
/*      */   String identifiant;
/*      */   
/*      */   public IhmLien2(IhmEntite entite, IhmRelation relation)
/*      */   {
/*   75 */     super(entite, relation);
/*   76 */     this.cardinalites = new IhmCardinalite("0,n");
/*   77 */     this.pointCassure = new ArrayList();
/*   78 */     this.historique = new ArrayList();
/*   79 */     this.historique.add(Historique.getHistoriqueCreation());
/*   80 */     this.clLien2 = FormeInterneMCD.clLien2;
/*   81 */     this.clLienText2 = FormeInterneMCD.clLienText2;
/*   82 */     this.clLienNom2 = FormeInterneMCD.clLienNom2;
/*   83 */     this.clLienSelect = FormeInterneMCD.clSelected;
/*   84 */     this.clLienActiver = FormeInterneMCD.clLienActiver2;
/*   85 */     this.cardinalites.setClFond2(FormeInterneMCD.clLienFondCardinalite2);
/*   86 */     this.cardinalites.setClText2(FormeInterneMCD.clLienNomCardinalite2);
/*   87 */     this.coteEntite = 0;
/*   88 */     this.coteRelation = 0;
/*   89 */     this.commentaire = "";
/*   90 */     this.historisation = "";
/*   91 */     this.fleche = false;
/*   92 */     this.relatif = false;
/*   93 */     this.activer = false;
/*   94 */     this.zoom = FormeInterneMCD.zoom;
/*   95 */     setNom("");
/*   96 */     this.code = "";
/*   97 */     this.nomXY = new Point(0, 0);
/*   98 */     this.nomWH = new Point(0, 0);
/*   99 */     this.font = Parametres.fontNormal;
/*  100 */     this.epaisseur = FormeInterneMCD.lienEntiteRelation2;
/*  101 */     this.cardinaliteMajuscule = FormeInterneMCD.cardinaliteMajuscule2;
/*  102 */     this.cardinalite2points = FormeInterneMCD.cardinalite2points2;
/*  103 */     ((IhmRelation2)getRelation()).setDispatchKey("");
/*  104 */     this.identifiant = "";
/*      */   }
/*      */   
/*      */ 
/*      */   public void paint(Graphics g)
/*      */   {
/*  110 */     Graphics2D g2d = (Graphics2D)g;
/*      */     
/*  112 */     dessinerLien(g2d);
/*  113 */     if (isSelected()) {
/*  114 */       DessinerTousLesPointSansLien(g2d);
/*      */     }
/*      */   }
/*      */   
/*      */   private void DessinerTousLesPointSansLien(Graphics2D gr)
/*      */   {
/*  120 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  121 */       gr.setColor(getClLien());
/*      */       
/*  123 */       if (isSelected()) {
/*  124 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFond());
/*  125 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*      */       }
/*  127 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/*  128 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFondSelect());
/*  129 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void coteIntersectionEntite()
/*      */   {
/*  138 */     int xe = getEntite().getCentreX();
/*  139 */     int ye = getEntite().getCentreY();
/*  140 */     int xr = getRelation().getCentreX();
/*  141 */     int yr = getRelation().getCentreY();
/*  142 */     if (this.pointCassure.size() > 0) {
/*  143 */       xr = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/*  144 */       yr = ((IhmPoint)this.pointCassure.get(0)).getYCentre();
/*      */     }
/*      */     
/*  147 */     int x1 = getEntite().getX();
/*  148 */     int y1 = getEntite().getY();
/*  149 */     int x2 = getEntite().getX();
/*  150 */     int y2 = getEntite().getY() + getEntite().getHeight();
/*      */     
/*  152 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/*  153 */       this.coteEntite = 1;
/*  154 */       return;
/*      */     }
/*      */     
/*  157 */     x1 = getEntite().getX();
/*  158 */     y1 = getEntite().getY();
/*  159 */     x2 = getEntite().getX() + getEntite().getWidth();
/*  160 */     y2 = getEntite().getY();
/*      */     
/*  162 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/*  163 */       this.coteEntite = 2;
/*  164 */       return;
/*      */     }
/*      */     
/*  167 */     x1 = getEntite().getX() + getEntite().getWidth();
/*  168 */     y1 = getEntite().getY();
/*  169 */     x2 = getEntite().getX() + getEntite().getWidth();
/*  170 */     y2 = getEntite().getY() + getEntite().getHeight();
/*      */     
/*  172 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/*  173 */       this.coteEntite = 3;
/*  174 */       return;
/*      */     }
/*      */     
/*  177 */     x1 = getEntite().getX();
/*  178 */     y1 = getEntite().getY() + getEntite().getHeight();
/*  179 */     x2 = getEntite().getX() + getEntite().getWidth();
/*  180 */     y2 = getEntite().getY() + getEntite().getHeight();
/*      */     
/*  182 */     if (Line2D.linesIntersect(xe, ye, xr, yr, x1, y1, x2, y2)) {
/*  183 */       this.coteEntite = 4;
/*  184 */       return;
/*      */     }
/*      */   }
/*      */   
/*      */   private Point getDernierPoint() {
/*  189 */     if (this.pointCassure.size() == 0) {
/*  190 */       return new Point(getEntite().getCentreX(), getEntite().getCentreY());
/*      */     }
/*  192 */     return ((IhmPoint)this.pointCassure.get(0)).getPoint();
/*      */   }
/*      */   
/*      */   private Point getLastPoint()
/*      */   {
/*  197 */     if (this.pointCassure.size() == 0) {
/*  198 */       return new Point(getRelation().getCentreX(), getRelation().getCentreY());
/*      */     }
/*  200 */     return ((IhmPoint)this.pointCassure.get(0)).getPoint();
/*      */   }
/*      */   
/*      */   private boolean segmentSelect(int xs, int ys, int xt, int yt, int xx, int yy)
/*      */   {
/*  205 */     if (Line2D.linesIntersect(xs, ys, xt, yt, xx - 5, yy - 5, xx + 5, yy + 5)) return true;
/*  206 */     if (Line2D.linesIntersect(xs, ys, xt, yt, xx + 5, yy - 5, xx - 5, yy + 5)) return true;
/*  207 */     return false;
/*      */   }
/*      */   
/*      */   private boolean listePointEdentique(ArrayList<IhmPoint> liste) {
/*  211 */     if (liste.size() != this.pointCassure.size()) return false;
/*  212 */     for (int i = 0; i < liste.size(); i++) {
/*  213 */       if ((((IhmPoint)liste.get(i)).getX() != ((IhmPoint)this.pointCassure.get(i)).getX()) || (((IhmPoint)liste.get(i)).getY() != ((IhmPoint)this.pointCassure.get(i)).getY())) return false;
/*      */     }
/*  215 */     return true;
/*      */   }
/*      */   
/*      */   public boolean egale(IhmLien2 lien) {
/*  219 */     if ((lien.getEntite() != getEntite()) || (getRelation() != lien.getRelation())) return false;
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
/*  329 */       xt = getRelation().getCentreX();
/*  330 */       yt = getRelation().getCentreY();
/*      */     } else {
/*  332 */       xt = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/*  333 */       yt = ((IhmPoint)this.pointCassure.get(0)).getYCentre();
/*      */     }
/*  335 */     double d1 = getEntite().getCentreX() - xt;
/*  336 */     double d2 = getEntite().getCentreY() - yt;
/*      */     
/*  338 */     return d2 / d1; }
/*      */   
/*      */   private double tangeanteRelation() {
/*      */     int xt;
/*      */     int yt;
/*  343 */     if (this.pointCassure.size() == 0) {
/*  344 */       xt = getRelation().getCentreX();
/*  345 */       yt = getRelation().getCentreY();
/*      */     } else {
/*  347 */       xt = ((IhmPoint)this.pointCassure.get(this.pointCassure.size() - 1)).getXCentre();
/*  348 */       yt = ((IhmPoint)this.pointCassure.get(this.pointCassure.size() - 1)).getYCentre();
/*      */     }
/*      */     
/*  351 */     return (getRelation().getCentreY() - yt) / (getRelation().getCentreX() - xt);
/*      */   }
/*      */   
/*      */   private boolean isEntiteMemeX()
/*      */   {
/*  356 */     int x = getRelation().getCentreX();
/*      */     
/*  358 */     if (this.pointCassure.size() > 0) {
/*  359 */       x = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/*      */     }
/*  361 */     if (getEntite().getCentreX() == x) return true;
/*  362 */     return false;
/*      */   }
/*      */   
/*      */   private boolean isRelationMemeX()
/*      */   {
/*  367 */     int x = getEntite().getCentreX();
/*      */     
/*  369 */     if (this.pointCassure.size() > 0) {
/*  370 */       x = ((IhmPoint)this.pointCassure.get(this.pointCassure.size() - 1)).getXCentre();
/*      */     }
/*  372 */     if (getRelation().getCentreX() == x) return true;
/*  373 */     return false;
/*      */   }
/*      */   
/*      */   private void calculPointCardinaliteMemeXEntite()
/*      */   {
/*  378 */     int x = getRelation().getCentreX();
/*  379 */     if (this.coteEntite == 2) {
/*  380 */       this.xCard = x;
/*  381 */       this.yCard = getEntite().getY();
/*  382 */       int yc = getEntite().getY() - 20;
/*  383 */       int xc = getEntite().getCentreX();
/*  384 */       this.cardinalites.setX(xc);
/*  385 */       this.cardinalites.setY(yc);
/*      */     }
/*      */     
/*  388 */     if (this.coteEntite == 4) {
/*  389 */       this.xCard = x;
/*      */       
/*  391 */       this.yCard = (getEntite().getY() + getEntite().getHeight());
/*  392 */       if (getEntite().isOmbre()) this.yCard += 3;
/*  393 */       int yc = this.yCard + 20;
/*  394 */       int xc = getEntite().getCentreX();
/*  395 */       this.cardinalites.setX(xc);
/*  396 */       this.cardinalites.setY(yc);
/*      */     }
/*      */   }
/*      */   
/*      */   private void calculPointCardinaliteEntite() {
/*  401 */     if (isEntiteMemeX()) {
/*  402 */       calculPointCardinaliteMemeXEntite();
/*      */     }
/*      */     else {
/*  405 */       double tag = tangeanteEntite();
/*  406 */       this.tangente = tag;
/*  407 */       int y1 = getEntite().getCentreY();
/*  408 */       int x1 = getEntite().getCentreX();
/*      */       
/*  410 */       if (this.coteEntite == 1) {
/*  411 */         this.xCard = getEntite().getX();
/*  412 */         this.yCard = ((int)(tag * this.xCard + (y1 - tag * x1)));
/*  413 */         int dec = (int)(Math.abs(Math.atan(this.tangente)) * 10.0D);
/*  414 */         int xc = getEntite().getX() - (35 - 2 * dec);
/*      */         
/*  416 */         if (getCardHistrosation().length() > 3) xc -= 10;
/*  417 */         if (this.cardinalites.getStabilite().trim().length() == 1) { xc -= 5;
/*      */         }
/*  419 */         int yc = (int)(tag * xc + (y1 - tag * x1));
/*  420 */         this.cardinalites.setX(xc);
/*  421 */         this.cardinalites.setY(yc);
/*      */       }
/*      */       
/*      */ 
/*  425 */       if (this.coteEntite == 3) {
/*  426 */         this.xCard = (getEntite().getX() + getEntite().getWidth());
/*  427 */         if (getEntite().isOmbre()) this.xCard += 3;
/*  428 */         this.yCard = ((int)(tag * this.xCard + (y1 - tag * x1)));
/*  429 */         int dec = (int)(Math.abs(Math.atan(this.tangente)) * 10.0D);
/*  430 */         int xc = getEntite().getX() + getEntite().getWidth() + (35 - 2 * dec);
/*      */         
/*  432 */         if (getCardHistrosation().length() > 3) xc += 10;
/*  433 */         if (this.cardinalites.getStabilite().trim().length() == 1) xc += 5;
/*  434 */         if (getEntite().isOmbre()) xc += 3;
/*  435 */         int yc = (int)(tag * xc + (y1 - tag * x1));
/*  436 */         this.cardinalites.setX(xc);
/*  437 */         this.cardinalites.setY(yc);
/*      */       }
/*      */       
/*  440 */       if (this.coteEntite == 2) {
/*  441 */         int dec = (int)(10.0D - Math.abs(Math.atan(this.tangente)) * 10.0D);
/*  442 */         this.yCard = getEntite().getY();
/*  443 */         if (getEntite().isOmbre()) this.yCard += 3;
/*  444 */         this.xCard = ((int)((this.yCard - (y1 - tag * x1)) / tag));
/*      */         
/*  446 */         int yc = getEntite().getY() - (20 - dec);
/*  447 */         int xc = (int)((yc - (y1 - tag * x1)) / tag);
/*  448 */         this.cardinalites.setX(xc);
/*  449 */         this.cardinalites.setY(yc);
/*      */       }
/*      */       
/*  452 */       if (this.coteEntite == 4) {
/*  453 */         this.yCard = (getEntite().getY() + getEntite().getHeight());
/*      */         
/*  455 */         if (getEntite().isOmbre()) { this.yCard += 4;
/*      */         }
/*  457 */         this.xCard = ((int)((this.yCard - (y1 - tag * x1)) / tag));
/*      */         
/*  459 */         int dec = (int)(10.0D - Math.abs(Math.atan(this.tangente)) * 10.0D);
/*      */         
/*  461 */         int yc = getEntite().getY() + getEntite().getHeight() + (20 - dec);
/*  462 */         if (getEntite().isOmbre()) yc += 5;
/*  463 */         int xc = (int)((yc - (y1 - tag * x1)) / tag);
/*      */         
/*  465 */         this.cardinalites.setX(xc);
/*  466 */         this.cardinalites.setY(yc);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void calculerXYCardianlite()
/*      */   {
/*  473 */     coteIntersectionEntite();
/*  474 */     calculPointCardinaliteEntite();
/*      */   }
/*      */   
/*      */   private String getCardHistrosation() {
/*  478 */     if (getHistorisation().length() == 0) return "";
/*  479 */     return "  [ " + getHistorisation() + " ]";
/*      */   }
/*      */   
/*      */   public boolean estDans(int xd, int yd, int xf, int yf) {
/*  483 */     if (getPointCassure().size() > 0) {
/*  484 */       for (int i = 0; i < getPointCassure().size(); i++) {
/*  485 */         if (!((IhmPoint)getPointCassure().get(i)).isSelected()) return false;
/*      */       }
/*  487 */       return true;
/*      */     }
/*      */     
/*  490 */     int x1 = xd;
/*  491 */     int x2 = xf;
/*  492 */     int y1 = yd;
/*  493 */     int y2 = yf;
/*  494 */     if (xd > xf) {
/*  495 */       x1 = xf;
/*  496 */       x2 = xd;
/*      */     }
/*  498 */     if (yd > yf) {
/*  499 */       y1 = yf;
/*  500 */       y2 = yd;
/*      */     }
/*  502 */     Rectangle2D rec = new Rectangle2D.Double(x1, y1, x2 - x1, y2 - y1);
/*  503 */     if ((rec.contains(getEntite().getCentreX(), getEntite().getCentreY())) && (rec.contains(getRelation().getCentreX(), getRelation().getCentreY())))
/*  504 */       return true;
/*  505 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   private void ajusteTailleCardinalite(Graphics2D gr)
/*      */   {
/*  511 */     String car = getCardinalite();
/*  512 */     car = car.replace("(", "< ");
/*  513 */     car = car.replace(")", " >");
/*  514 */     if (this.cardinaliteMajuscule) car = car.toUpperCase();
/*  515 */     if (this.cardinalite2points) { car = car.replace(",", ":");
/*      */     }
/*  517 */     if (this.cardinalites.getStabilite().trim().length() == 1) {
/*  518 */       car = this.cardinalites.getStabilite().trim() + " " + car;
/*      */     }
/*      */     
/*  521 */     car = car + getCardHistrosation();
/*      */     
/*  523 */     int tail = gr.getFontMetrics().stringWidth(car) + 2;
/*  524 */     int h = gr.getFontMetrics().getHeight() + 2;
/*  525 */     this.cardinalites.setWidth(tail);
/*  526 */     this.cardinalites.setHeight(h);
/*  527 */     this.cardinalites.setX(this.cardinalites.getX() - tail / 2);
/*  528 */     this.cardinalites.setY(this.cardinalites.getY() - h / 2);
/*      */   }
/*      */   
/*      */   public boolean addBreakPoint(int x, int y)
/*      */   {
/*  533 */     int xs = getEntite().getCentreX();
/*  534 */     int ys = getEntite().getCentreY();
/*  535 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  536 */       int xt = ((IhmPoint)this.pointCassure.get(i)).getPoint().getX();
/*  537 */       int yt = ((IhmPoint)this.pointCassure.get(i)).getPoint().getY();
/*  538 */       if (segmentSelect(xs, ys, xt, yt, x, y)) {
/*  539 */         IhmPoint p = new IhmPoint(x, y);
/*  540 */         this.pointCassure.add(i, p);
/*  541 */         p.setSelected(true);
/*  542 */         return true;
/*      */       }
/*  544 */       xs = xt;
/*  545 */       ys = yt;
/*      */     }
/*  547 */     if (segmentSelect(xs, ys, getRelation().getCentreX(), getRelation().getCentreY(), x, y)) {
/*  548 */       IhmPoint p = new IhmPoint(x, y);
/*  549 */       this.pointCassure.add(p);
/*  550 */       p.setSelected(true);
/*  551 */       return true;
/*      */     }
/*  553 */     return false;
/*      */   }
/*      */   
/*      */   private Point rotation(double x, double y, double tg) {
/*  557 */     Point p = new Point(0, 0);
/*  558 */     double x1 = 0.0D;double y1 = 0.0D;double rac = 0.0D;
/*  559 */     rac = Math.sqrt(Math.pow(tg, 2.0D) + 1.0D);
/*  560 */     x1 = (x - y * tg) / rac;
/*  561 */     y1 = (y + x * tg) / rac;
/*  562 */     p.setX((int)x1);
/*  563 */     p.setY((int)y1);
/*  564 */     return p;
/*      */   }
/*      */   
/*      */   public void dessinerFleche(Graphics2D gr) {
/*  568 */     gr.setColor(this.clLien2);
/*  569 */     if (isActiver()) gr.setColor(getClLienActiver());
/*  570 */     if (isSelected()) { gr.setColor(getClLienSelect());
/*      */     }
/*  572 */     Point lp = getLastPoint();
/*      */     
/*  574 */     if (isEntiteMemeX()) {
/*  575 */       if (this.coteEntite == 2) {
/*  576 */         int[] x = new int[3];
/*  577 */         int[] y = new int[3];
/*  578 */         int xfleche = 5;
/*  579 */         int yfleche = 10;
/*  580 */         x[0] = getEntite().getCentreX();
/*  581 */         y[0] = getEntite().getY();
/*      */         
/*  583 */         x[1] = (x[0] - xfleche);
/*  584 */         y[1] = (y[0] - yfleche);
/*      */         
/*  586 */         x[2] = (x[0] + xfleche);
/*  587 */         y[2] = (y[0] - yfleche);
/*      */         
/*  589 */         gr.fillPolygon(x, y, 3);
/*      */       }
/*      */       
/*  592 */       if (this.coteEntite == 4) {
/*  593 */         int[] x = new int[3];
/*  594 */         int[] y = new int[3];
/*  595 */         int xfleche = 5;
/*  596 */         int yfleche = 10;
/*  597 */         x[0] = getEntite().getCentreX();
/*  598 */         y[0] = (getEntite().getY() + getEntite().getHeight());
/*  599 */         if (getEntite().isOmbre()) y[0] += 4;
/*  600 */         x[1] = (x[0] - xfleche);
/*  601 */         y[1] = (y[0] + yfleche);
/*      */         
/*  603 */         x[2] = (x[0] + xfleche);
/*  604 */         y[2] = (y[0] + yfleche);
/*      */         
/*  606 */         gr.fillPolygon(x, y, 3);
/*      */       }
/*  608 */       return;
/*      */     }
/*      */     
/*  611 */     double tan = getEntite().getCentreY() - lp.getY();
/*  612 */     tan /= (getEntite().getCentreX() - lp.getX());
/*      */     
/*  614 */     int[] x = new int[3];
/*  615 */     int[] y = new int[3];
/*      */     
/*      */ 
/*      */ 
/*  619 */     int posi = this.coteEntite;
/*      */     
/*  621 */     Point p = new Point(this.xCard, this.yCard);
/*      */     
/*      */ 
/*  624 */     int xfleche = 10;
/*  625 */     int yfleche = 5;
/*      */     
/*  627 */     x[0] = p.getX();
/*  628 */     y[0] = p.getY();
/*  629 */     int dx = x[0];
/*  630 */     int dy = y[0];
/*  631 */     p = rotation(x[0], y[0], tan);
/*  632 */     dx -= p.getX();
/*  633 */     dy -= p.getY();
/*      */     
/*      */ 
/*  636 */     if (posi == 1)
/*      */     {
/*  638 */       x[0] = (p.getX() + dx);
/*  639 */       y[0] = (p.getY() + dy);
/*      */       
/*  641 */       p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/*  642 */       x[1] = p.getX();
/*  643 */       y[1] = p.getY();
/*      */       
/*  645 */       x[1] += dx;
/*  646 */       y[1] += dy;
/*      */       
/*  648 */       p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/*  649 */       x[2] = (p.getX() + dx);
/*  650 */       y[2] = (p.getY() + dy);
/*      */       
/*  652 */       gr.fillPolygon(x, y, 3);
/*      */     }
/*  654 */     if (posi == 3) {
/*  655 */       x[0] = (p.getX() + dx);
/*  656 */       y[0] = (p.getY() + dy);
/*      */       
/*  658 */       p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/*  659 */       x[1] = p.getX();
/*  660 */       y[1] = p.getY();
/*      */       
/*  662 */       x[1] += dx;
/*  663 */       y[1] += dy;
/*      */       
/*      */ 
/*  666 */       p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/*  667 */       x[2] = (p.getX() + dx);
/*  668 */       y[2] = (p.getY() + dy);
/*      */       
/*  670 */       gr.fillPolygon(x, y, 3);
/*      */     }
/*      */     
/*  673 */     if (posi == 4) {
/*  674 */       if (getEntite().getCentreX() < lp.getX()) {
/*  675 */         x[0] = (p.getX() + dx);
/*  676 */         y[0] = (p.getY() + dy);
/*      */         
/*  678 */         p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/*  679 */         x[1] = (p.getX() + dx);
/*  680 */         y[1] = (p.getY() + dy);
/*      */         
/*  682 */         p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/*  683 */         x[2] = (p.getX() + dx);
/*  684 */         y[2] = (p.getY() + dy);
/*      */       } else {
/*  686 */         x[0] = (p.getX() + dx);
/*  687 */         y[0] = (p.getY() + dy);
/*      */         
/*  689 */         p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/*  690 */         x[1] = (p.getX() + dx);
/*  691 */         y[1] = (p.getY() + dy);
/*      */         
/*  693 */         p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/*  694 */         x[2] = (p.getX() + dx);
/*  695 */         y[2] = (p.getY() + dy);
/*      */       }
/*      */       
/*  698 */       gr.fillPolygon(x, y, 3);
/*      */     }
/*      */     
/*  701 */     if (posi == 2) {
/*  702 */       if (getEntite().getCentreX() > lp.getX()) {
/*  703 */         tan = lp.getY() - getEntite().getCentreY();
/*  704 */         tan /= (lp.getX() - getEntite().getCentreX());
/*      */         
/*  706 */         x[0] = (p.getX() + dx);
/*  707 */         y[0] = (p.getY() + dy);
/*      */         
/*  709 */         p = rotation(x[0] - xfleche, y[0] + yfleche, tan);
/*  710 */         x[1] = p.getX();
/*  711 */         y[1] = p.getY();
/*      */         
/*  713 */         x[1] += dx;
/*  714 */         y[1] += dy;
/*      */         
/*  716 */         p = rotation(x[0] - xfleche, y[0] - yfleche, tan);
/*  717 */         x[2] = (p.getX() + dx);
/*  718 */         y[2] = (p.getY() + dy);
/*      */       }
/*      */       else {
/*  721 */         x[0] = (p.getX() + dx);
/*  722 */         y[0] = (p.getY() + dy);
/*      */         
/*  724 */         p = rotation(x[0] + xfleche, y[0] + yfleche, tan);
/*  725 */         x[1] = p.getX();
/*  726 */         y[1] = p.getY();
/*      */         
/*  728 */         x[1] += dx;
/*  729 */         y[1] += dy;
/*      */         
/*  731 */         p = rotation(x[0] + xfleche, y[0] - yfleche, tan);
/*  732 */         x[2] = (p.getX() + dx);
/*  733 */         y[2] = (p.getY() + dy);
/*      */       }
/*  735 */       gr.fillPolygon(x, y, 3);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void DessinerTousLesPoint(Graphics2D gr)
/*      */   {
/*  743 */     int x0 = getEntite().getCentreX();
/*  744 */     int y0 = getEntite().getCentreY();
/*  745 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/*  746 */       gr.setColor(getClLien2());
/*  747 */       if (isActiver()) gr.setColor(getClLienActiver());
/*  748 */       if (isSelected()) gr.setColor(getClLienSelect());
/*  749 */       gr.drawLine(x0, y0, ((IhmPoint)this.pointCassure.get(i)).getXCentre(), ((IhmPoint)this.pointCassure.get(i)).getYCentre());
/*  750 */       x0 = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/*  751 */       y0 = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/*  752 */       if (isSelected()) {
/*  753 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFond());
/*  754 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*      */       }
/*  756 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected()) {
/*  757 */         gr.setColor(((IhmPoint)this.pointCassure.get(i)).getClFondSelect());
/*  758 */         gr.fillRect(((IhmPoint)this.pointCassure.get(i)).getX(), ((IhmPoint)this.pointCassure.get(i)).getY(), ((IhmPoint)this.pointCassure.get(i)).getWidth(), ((IhmPoint)this.pointCassure.get(i)).getHeight());
/*      */       }
/*  760 */       x0 = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/*  761 */       y0 = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/*      */     }
/*  763 */     gr.setColor(this.clLien2);
/*  764 */     if (isActiver()) gr.setColor(getClLienActiver());
/*  765 */     if (isSelected()) gr.setColor(getClLienSelect());
/*  766 */     gr.drawLine(x0, y0, getRelation().getCentreX(), getRelation().getCentreY());
/*      */   }
/*      */   
/*      */   public void DessinerCardinalite(Graphics2D gr) {
/*  770 */     String car = getCardinalite();
/*  771 */     car = car.replace("(", "< ");
/*  772 */     car = car.replace(")", " >");
/*  773 */     if (this.cardinaliteMajuscule) car = car.toUpperCase();
/*  774 */     if (this.cardinalite2points) car = car.replace(",", ":");
/*  775 */     if (getCardinalites().getStabilite().trim().length() == 1) {
/*  776 */       car = getCardinalites().getStabilite().trim() + " " + car;
/*      */     }
/*  778 */     car = car + getCardHistrosation();
/*  779 */     gr.setColor(getCardinalites().getClFond2());
/*  780 */     gr.fillRect(this.cardinalites.getX(), this.cardinalites.getY(), this.cardinalites.getWidth() + 2, this.cardinalites.getHeight());
/*      */     
/*  782 */     gr.setColor(this.clLienText2);
/*  783 */     if (isActiver()) gr.setColor(getClLienActiver());
/*  784 */     if (isSelected()) { gr.setColor(getClLienSelect());
/*      */     }
/*  786 */     Font f = gr.getFont();
/*  787 */     gr.setFont(Parametres.fontGras);
/*  788 */     gr.drawString(car, this.cardinalites.getX() + 2, this.cardinalites.getY() + this.cardinalites.getHeight() - 4);
/*  789 */     gr.setFont(f);
/*      */   }
/*      */   
/*      */   public void ajouterModification() {
/*  793 */     Historique h = Historique.getHistoriqueModification();
/*  794 */     Historique h1 = (Historique)this.historique.get(this.historique.size() - 1);
/*  795 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur()))) {
/*  796 */       getHistorique().add(h);
/*      */     }
/*      */   }
/*      */   
/*      */   private void dessinerLien(Graphics2D gr) {
/*  801 */     calculerXYCardianlite();
/*  802 */     ajusteTailleCardinalite(gr);
/*  803 */     Graphics2D g2d = gr;
/*  804 */     Stroke stro = g2d.getStroke();
/*      */     
/*  806 */     float[] style = { 5.0F, 0.0F };
/*  807 */     g2d.setStroke(new BasicStroke(this.epaisseur, 0, 0, 10.0F, style, 0.0F));
/*      */     
/*  809 */     DessinerTousLesPoint(gr);
/*  810 */     DessinerCardinalite(gr);
/*  811 */     if (this.fleche) {
/*  812 */       dessinerFleche(gr);
/*      */     }
/*  814 */     dessinerNomLien(gr);
/*  815 */     g2d.setStroke(stro);
/*      */   }
/*      */   
/*      */ 
/*      */   private void dessinerHorloge(Graphics2D gr) {}
/*      */   
/*      */   private int coteRelation(Graphics2D gr)
/*      */   {
/*  823 */     int xL2 = 0;int yL2 = 0;
/*  824 */     int xL1 = getRelation().getCentreX();
/*  825 */     int yL1 = getRelation().getCentreY();
/*  826 */     if (this.pointCassure.size() == 0) {
/*  827 */       xL2 = getEntite().getCentreX();
/*  828 */       yL2 = getEntite().getCentreY();
/*      */     }
/*  830 */     if (this.pointCassure.size() == 1) {
/*  831 */       xL2 = ((IhmPoint)this.pointCassure.get(0)).getXCentre();
/*  832 */       yL2 = ((IhmPoint)this.pointCassure.get(0)).getYCentre();
/*      */     }
/*      */     
/*  835 */     int x1 = getRelation().getX();
/*  836 */     int y1 = getRelation().getY();
/*  837 */     int x2 = getRelation().getX();
/*  838 */     int y2 = getRelation().getY() + getRelation().getHeight();
/*      */     
/*  840 */     if (Line2D.linesIntersect(xL1, yL1, xL2, yL2, x1, y1, x2, y2))
/*      */     {
/*  842 */       return 1;
/*      */     }
/*      */     
/*  845 */     x1 = getRelation().getX();
/*  846 */     y1 = getRelation().getY();
/*  847 */     x2 = getRelation().getX() + getRelation().getWidth();
/*  848 */     y2 = getRelation().getY();
/*      */     
/*  850 */     if (Line2D.linesIntersect(xL1, yL1, xL2, yL2, x1, y1, x2, y2))
/*      */     {
/*  852 */       return 2;
/*      */     }
/*      */     
/*  855 */     x1 = getRelation().getX() + getRelation().getWidth();
/*  856 */     y1 = getRelation().getY();
/*  857 */     x2 = getRelation().getX() + getRelation().getWidth();
/*  858 */     y2 = getRelation().getY() + getRelation().getHeight();
/*      */     
/*  860 */     if (Line2D.linesIntersect(xL1, yL1, xL2, yL2, x1, y1, x2, y2))
/*      */     {
/*  862 */       return 3;
/*      */     }
/*      */     
/*  865 */     x1 = getRelation().getX();
/*  866 */     y1 = getRelation().getY() + getRelation().getHeight();
/*  867 */     x2 = getRelation().getX() + getRelation().getWidth();
/*  868 */     y2 = getRelation().getY() + getRelation().getHeight();
/*      */     
/*  870 */     if (Line2D.linesIntersect(xL1, yL1, xL2, yL2, x1, y1, x2, y2))
/*      */     {
/*  872 */       return 4;
/*      */     }
/*  874 */     return 2;
/*      */   }
/*      */   
/*      */   private Point intersectHoriz(Graphics2D gr, int xL1, int yL1, int xL2, int yL2, int cote)
/*      */   {
/*  879 */     Point p = new Point(0, 0);
/*      */     
/*  881 */     int y1 = 0;
/*  882 */     int x1 = getRelation().getX();
/*  883 */     int x2 = getRelation().getX() + getRelation().getWidth();
/*  884 */     if (cote == 2) {
/*  885 */       y1 = getRelation().getY();
/*      */     }
/*  887 */     if (cote == 4) {
/*  888 */       y1 = getRelation().getY() + getRelation().getHeight();
/*      */     }
/*  890 */     int dis = x2 - x1;
/*  891 */     while (dis > 4) {
/*  892 */       if (Line2D.linesIntersect(x1, y1, x1 + dis / 2, y1, xL1, yL1, xL2, yL2)) {
/*  893 */         x2 -= dis / 2;
/*      */       } else {
/*  895 */         x1 += dis / 2;
/*      */       }
/*  897 */       dis = x2 - x1;
/*      */     }
/*  899 */     p.setX(x1);
/*  900 */     p.setY(y1);
/*  901 */     return p;
/*      */   }
/*      */   
/*      */   private Point intersectVerti(Graphics2D gr, int xL1, int yL1, int xL2, int yL2, int cote) {
/*  905 */     Point p = new Point(0, 0);
/*      */     
/*  907 */     int x1 = 0;
/*  908 */     int y1 = getRelation().getY();
/*  909 */     int y2 = getRelation().getY() + getRelation().getHeight();
/*  910 */     if (cote == 1) {
/*  911 */       x1 = getRelation().getX();
/*      */     }
/*  913 */     if (cote == 3) {
/*  914 */       x1 = getRelation().getX() + getRelation().getWidth();
/*      */     }
/*  916 */     int dis = y2 - y1;
/*  917 */     while (dis > 4) {
/*  918 */       if (Line2D.linesIntersect(x1, y1, x1, y1 + dis / 2, xL1, yL1, xL2, yL2)) {
/*  919 */         y2 -= dis / 2;
/*      */       } else {
/*  921 */         y1 += dis / 2;
/*      */       }
/*  923 */       dis = y2 - y1;
/*      */     }
/*  925 */     p.setX(x1);
/*  926 */     p.setY(y1);
/*  927 */     return p;
/*      */   }
/*      */   
/*      */   private Point getPremierPointNom()
/*      */   {
/*  932 */     Point p = new Point(0, 0);
/*  933 */     if (this.pointCassure.size() == 0) {
/*  934 */       p.setX(getCardinalites().getX());
/*  935 */       p.setY(getCardinalites().getY());
/*      */     } else {
/*  937 */       p.setX(((IhmPoint)this.pointCassure.get(0)).getX());
/*  938 */       p.setY(((IhmPoint)this.pointCassure.get(0)).getY());
/*      */     }
/*  940 */     return p;
/*      */   }
/*      */   
/*      */   private Point getDernierPointNom(Graphics2D gr) {
/*  944 */     Point p = new Point(0, 0);
/*  945 */     if (this.pointCassure.size() <= 1) {
/*  946 */       p = getPremierPointNom();
/*      */       
/*  948 */       int cote = coteRelation(gr);
/*      */       
/*  950 */       if ((cote == 2) || (cote == 4)) {
/*  951 */         Point p1 = intersectHoriz(gr, p.getX(), p.getY(), getRelation().getCentreX(), getRelation().getCentreY(), cote);
/*  952 */         return p1;
/*      */       }
/*  954 */       if ((cote == 3) || (cote == 1)) {
/*  955 */         Point p1 = intersectVerti(gr, p.getX(), p.getY(), getRelation().getCentreX(), getRelation().getCentreY(), cote);
/*  956 */         return p1;
/*      */       }
/*      */     }
/*      */     else {
/*  960 */       p.setX(((IhmPoint)this.pointCassure.get(1)).getX());
/*  961 */       p.setY(((IhmPoint)this.pointCassure.get(1)).getY());
/*      */     }
/*  963 */     return p;
/*      */   }
/*      */   
/*      */   private void calculCoordonneeNom(Graphics2D gr) {
/*  967 */     Point p1 = getPremierPointNom();
/*  968 */     Point p2 = getDernierPointNom(gr);
/*  969 */     int w = gr.getFontMetrics().stringWidth(getNom());
/*  970 */     int h = gr.getFontMetrics().getHeight();
/*  971 */     this.nomXY.setX((p1.getX() + p2.getX()) / 2);
/*  972 */     this.nomXY.setX(this.nomXY.getX() - w / 2);
/*  973 */     this.nomXY.setY((p1.getY() + p2.getY()) / 2);
/*  974 */     this.nomXY.setY(this.nomXY.getY() + h / 2);
/*  975 */     this.nomWH.setX(w + 4);
/*  976 */     this.nomWH.setY(h);
/*      */   }
/*      */   
/*      */   private boolean isSelectedNom(int x, int y)
/*      */   {
/*  981 */     if ((getNom().trim().length() > 0) && 
/*  982 */       (x > this.nomXY.getX()) && (x < this.nomXY.getX() + this.nomWH.getX()) && (y > this.nomXY.getY() - this.nomWH.getY()) && (y < this.nomXY.getY())) {
/*  983 */       return true;
/*      */     }
/*  985 */     return false;
/*      */   }
/*      */   
/*      */   private void dessinerNomLien(Graphics2D gr) {
/*  989 */     if (getNom().trim().length() > 0) {
/*  990 */       calculCoordonneeNom(gr);
/*  991 */       Font f = gr.getFont();
/*  992 */       gr.setFont(this.font);
/*  993 */       gr.setColor(getCardinalites().getClFond2());
/*  994 */       gr.fillRect(this.nomXY.getX(), this.nomXY.getY() - this.nomWH.getY() + 3, this.nomWH.getX(), this.nomWH.getY());
/*  995 */       gr.setColor(this.clLienNom2);
/*  996 */       if (isActiver()) gr.setColor(this.clLienActiver);
/*  997 */       if (isSelected()) gr.setColor(this.clLienSelect);
/*  998 */       gr.drawString(getNom().trim(), this.nomXY.getX() + 2, this.nomXY.getY());
/*  999 */       gr.setFont(f);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void setSelected(boolean selected)
/*      */   {
/* 1006 */     super.setSelected(selected);
/* 1007 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 1008 */       ((IhmPoint)this.pointCassure.get(i)).setDesigner(selected);
/* 1009 */       if (!selected) {
/* 1010 */         ((IhmPoint)this.pointCassure.get(i)).setSelected(false);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public IhmPoint getSelectedPointCassure(int x, int y)
/*      */   {
/* 1017 */     IhmPoint p = null;
/* 1018 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 1019 */       if (((IhmPoint)this.pointCassure.get(i)).isSelected(x, y)) {
/* 1020 */         p = (IhmPoint)this.pointCassure.get(i);
/*      */       }
/*      */     }
/* 1023 */     return p;
/*      */   }
/*      */   
/*      */   public boolean isSelected(int x, int y)
/*      */   {
/* 1028 */     if (this.cardinalites.isSelected(x, y)) return true;
/* 1029 */     if (isSelectedNom(x, y)) return true;
/* 1030 */     if (getSelectedPointCassure(x, y) != null) { return true;
/*      */     }
/*      */     
/*      */ 
/* 1034 */     int xs = getEntite().getCentreX();
/* 1035 */     int ys = getEntite().getCentreY();
/* 1036 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 1037 */       int xt = ((IhmPoint)this.pointCassure.get(i)).getXCentre();
/* 1038 */       int yt = ((IhmPoint)this.pointCassure.get(i)).getYCentre();
/* 1039 */       if (segmentSelect(xs, ys, xt, yt, x, y)) return true;
/* 1040 */       xs = xt;
/* 1041 */       ys = yt;
/*      */     }
/*      */     
/* 1044 */     int xt = getRelation().getCentreX();
/* 1045 */     int yt = getRelation().getCentreY();
/* 1046 */     return segmentSelect(xs, ys, xt, yt, x, y);
/*      */   }
/*      */   
/*      */ 
/*      */   public IhmCardinalite getCardinalites()
/*      */   {
/* 1052 */     return this.cardinalites;
/*      */   }
/*      */   
/*      */   public String getCardinalite()
/*      */   {
/* 1057 */     String car = super.getCardinalite();
/* 1058 */     if ((car == null) || (car.trim().length() == 0)) {
/* 1059 */       return getCardinalites().getMin() + "," + getCardinalites().getMax();
/*      */     }
/*      */     
/* 1062 */     return car;
/*      */   }
/*      */   
/*      */   public void setCardinalite(String car)
/*      */   {
/* 1067 */     super.setCardinalite(car);
/* 1068 */     getCardinalites().setNom(car);
/* 1069 */     if (!car.equals(getCardinalite())) {
/* 1070 */       ((IhmRelation2)getRelation()).setDispatchKey("");
/*      */     }
/*      */   }
/*      */   
/*      */   public Color getClLien2() {
/* 1075 */     return this.clLien2;
/*      */   }
/*      */   
/*      */   public Color getClLienActiver() {
/* 1079 */     return this.clLienActiver;
/*      */   }
/*      */   
/*      */   public Color getClLienNom2() {
/* 1083 */     return this.clLienNom2;
/*      */   }
/*      */   
/*      */   public Color getClLienText2() {
/* 1087 */     return this.clLienText2;
/*      */   }
/*      */   
/*      */   public String getCommentaire() {
/* 1091 */     return this.commentaire;
/*      */   }
/*      */   
/*      */   public int getCoteEntite() {
/* 1095 */     return this.coteEntite;
/*      */   }
/*      */   
/*      */   public int getCoteRelation() {
/* 1099 */     return this.coteRelation;
/*      */   }
/*      */   
/*      */   public float getEpaisseur() {
/* 1103 */     return this.epaisseur;
/*      */   }
/*      */   
/*      */   public boolean isFleche() {
/* 1107 */     return this.fleche;
/*      */   }
/*      */   
/*      */   public ArrayList<Historique> getHistorique() {
/* 1111 */     return this.historique;
/*      */   }
/*      */   
/*      */   public String getHistorisation() {
/* 1115 */     return this.historisation;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmPoint> getPointCassure() {
/* 1119 */     return this.pointCassure;
/*      */   }
/*      */   
/*      */   public double getTangente() {
/* 1123 */     return this.tangente;
/*      */   }
/*      */   
/*      */   public int getxCard() {
/* 1127 */     return this.xCard;
/*      */   }
/*      */   
/*      */   public int getxCardRel() {
/* 1131 */     return this.xCardRel;
/*      */   }
/*      */   
/*      */   public int getyCard() {
/* 1135 */     return this.yCard;
/*      */   }
/*      */   
/*      */   public int getyCardRel() {
/* 1139 */     return this.yCardRel;
/*      */   }
/*      */   
/*      */   public double getZoom() {
/* 1143 */     return this.zoom;
/*      */   }
/*      */   
/*      */   public String getCode() {
/* 1147 */     return this.code;
/*      */   }
/*      */   
/*      */   public Font getFont() {
/* 1151 */     return this.font;
/*      */   }
/*      */   
/*      */   public String getIdentifiant() {
/* 1155 */     return this.identifiant;
/*      */   }
/*      */   
/*      */   public Point getNomWH() {
/* 1159 */     return this.nomWH;
/*      */   }
/*      */   
/*      */   public Point getNomXY() {
/* 1163 */     return this.nomXY;
/*      */   }
/*      */   
/*      */   public boolean isRelatif() {
/* 1167 */     return this.relatif;
/*      */   }
/*      */   
/*      */   public boolean isActiver() {
/* 1171 */     return this.activer;
/*      */   }
/*      */   
/*      */   public Color getClLienSelect() {
/* 1175 */     return this.clLienSelect;
/*      */   }
/*      */   
/*      */   public boolean isCardinalite2points() {
/* 1179 */     return this.cardinalite2points;
/*      */   }
/*      */   
/*      */   public boolean isCardinaliteMajuscule() {
/* 1183 */     return this.cardinaliteMajuscule;
/*      */   }
/*      */   
/*      */   public void setRelatif(boolean relatif) {
/* 1187 */     this.relatif = relatif;
/* 1188 */     getCardinalites().setRelatif(relatif);
/*      */   }
/*      */   
/*      */   public void setCardinalites(IhmCardinalite cardinalites) {
/* 1192 */     this.cardinalites = cardinalites;
/*      */   }
/*      */   
/*      */   public void setFont(Font font) {
/* 1196 */     this.font = font;
/*      */   }
/*      */   
/*      */   public void setIdentifiant(String identifiant) {
/* 1200 */     this.identifiant = identifiant;
/*      */   }
/*      */   
/*      */   public void setNomWH(Point nomWH) {
/* 1204 */     this.nomWH = nomWH;
/*      */   }
/*      */   
/*      */   public void setNomXY(Point nomXY) {
/* 1208 */     this.nomXY = nomXY;
/*      */   }
/*      */   
/*      */   public void setClLien2(Color clLien2) {
/* 1212 */     this.clLien2 = clLien2;
/*      */   }
/*      */   
/*      */   public void setClLienActiver(Color clLienActiver) {
/* 1216 */     this.clLienActiver = clLienActiver;
/*      */   }
/*      */   
/*      */   public void setClLienNom2(Color clLienNom2) {
/* 1220 */     this.clLienNom2 = clLienNom2;
/*      */   }
/*      */   
/*      */   public void setClLienSelect(Color clLienSelect) {
/* 1224 */     this.clLienSelect = clLienSelect;
/*      */   }
/*      */   
/*      */   public void setClLienText2(Color clLienText2) {
/* 1228 */     this.clLienText2 = clLienText2;
/* 1229 */     this.cardinalites.setClText2(clLienText2);
/*      */   }
/*      */   
/*      */   public void setCommentaire(String commentaire) {
/* 1233 */     this.commentaire = commentaire;
/*      */   }
/*      */   
/*      */   public void setActiver(boolean activer) {
/* 1237 */     this.activer = activer;
/*      */   }
/*      */   
/*      */   public void setCoteEntite(int coteEntite) {
/* 1241 */     this.coteEntite = coteEntite;
/*      */   }
/*      */   
/*      */   public void setCoteRelation(int coteRelation) {
/* 1245 */     this.coteRelation = coteRelation;
/*      */   }
/*      */   
/*      */   public void setFleche(boolean fleche) {
/* 1249 */     this.fleche = fleche;
/*      */   }
/*      */   
/*      */   public void setHistorique(ArrayList<Historique> historique) {
/* 1253 */     this.historique = historique;
/*      */   }
/*      */   
/*      */   public void setHistorisation(String horloge) {
/* 1257 */     this.historisation = horloge;
/*      */   }
/*      */   
/*      */   public void setPointCassure(ArrayList<IhmPoint> pointCassure) {
/* 1261 */     this.pointCassure = pointCassure;
/*      */   }
/*      */   
/*      */   public void setTangente(double tangente) {
/* 1265 */     this.tangente = tangente;
/*      */   }
/*      */   
/*      */   public void setEpaisseur(float epaisseur) {
/* 1269 */     this.epaisseur = epaisseur;
/*      */   }
/*      */   
/*      */   public void setCode(String code) {
/* 1273 */     this.code = code;
/*      */   }
/*      */   
/*      */   public void setxCard(int xCard) {
/* 1277 */     this.xCard = xCard;
/*      */   }
/*      */   
/*      */   public void setxCardRel(int xCardRel) {
/* 1281 */     this.xCardRel = xCardRel;
/*      */   }
/*      */   
/*      */   public void setyCard(int yCard)
/*      */   {
/* 1286 */     this.yCard = yCard;
/*      */   }
/*      */   
/*      */   public void setyCardRel(int yCardRel) {
/* 1290 */     this.yCardRel = yCardRel;
/*      */   }
/*      */   
/*      */   public void setZoom(double zoom) {
/* 1294 */     this.zoom = zoom;
/*      */   }
/*      */   
/*      */   public void setCardinalite2points(boolean cardinalite2points) {
/* 1298 */     this.cardinalite2points = cardinalite2points;
/*      */   }
/*      */   
/*      */   public void setCardinaliteMajuscule(boolean cardinaliteMajuscule) {
/* 1302 */     this.cardinaliteMajuscule = cardinaliteMajuscule;
/*      */   }
/*      */   
/*      */   public void ajouterCopier(ArrayList<Historique> lhis)
/*      */   {
/* 1307 */     Historique h = Historique.getHistoriqueCopie();
/* 1308 */     Historique h1 = (Historique)lhis.get(lhis.size() - 1);
/* 1309 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur())) || (!h.getAction().equals(h1.getAction())))
/*      */     {
/* 1311 */       lhis.add(h);
/*      */     }
/*      */   }
/*      */   
/*      */   public ArrayList<Historique> copierHistoriques(ArrayList<Historique> lhis) {
/* 1316 */     ArrayList<Historique> l = new ArrayList();
/* 1317 */     for (int i = 0; i < lhis.size(); i++) {
/* 1318 */       l.add(((Historique)lhis.get(i)).copier());
/*      */     }
/* 1320 */     return l;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmPoint> copierListePointDeCassure() {
/* 1324 */     ArrayList<IhmPoint> liste = new ArrayList();
/* 1325 */     for (int i = 0; i < this.pointCassure.size(); i++) {
/* 1326 */       IhmPoint p = ((IhmPoint)this.pointCassure.get(i)).copier();
/* 1327 */       p.setX(p.getX() + 10);
/* 1328 */       p.setY(p.getY() + 10);
/* 1329 */       p.setSelected(true);
/* 1330 */       liste.add(p);
/*      */     }
/* 1332 */     return liste;
/*      */   }
/*      */   
/*      */ 
/*      */   public IhmLien copier()
/*      */   {
/* 1338 */     IhmLien2 lien = new IhmLien2(getEntite(), getRelation());
/* 1339 */     lien.setCardinalites(getCardinalites().copier());
/* 1340 */     lien.setCardinalite(getCardinalite());
/* 1341 */     lien.setNom(getNom());
/* 1342 */     lien.setClLien2(getClLien2());
/* 1343 */     lien.setClLienText2(getClLienText2());
/* 1344 */     lien.setClLienNom2(getClLienNom2());
/* 1345 */     lien.setClLienActiver(getClLienActiver());
/* 1346 */     lien.setClLienSelect(getClLienSelect());
/*      */     
/*      */ 
/*      */ 
/* 1350 */     lien.setCommentaire(getCommentaire());
/* 1351 */     lien.setHistorisation(getHistorisation());
/* 1352 */     lien.setCode(getCode());
/*      */     
/* 1354 */     lien.setFleche(isFleche());
/* 1355 */     lien.setRelatif(isRelatif());
/* 1356 */     lien.setZoom(getZoom());
/*      */     
/* 1358 */     lien.setPointCassure(copierListePointDeCassure());
/* 1359 */     lien.setHistorique(copierHistoriques(this.historique));
/* 1360 */     ajouterCopier(lien.getHistorique());
/* 1361 */     return lien;
/*      */   }
/*      */   
/*      */   public IhmLien copier(IhmEntite ent, IhmRelation rel) {
/* 1365 */     IhmLien2 lien = new IhmLien2(ent, rel);
/* 1366 */     lien.setCardinalites(getCardinalites().copier());
/* 1367 */     lien.setCardinalite(getCardinalite());
/* 1368 */     lien.setNom(getNom());
/* 1369 */     lien.setClLien2(getClLien2());
/* 1370 */     lien.setClLienText2(getClLienText2());
/* 1371 */     lien.setClLienNom2(getClLienNom2());
/* 1372 */     lien.setClLienActiver(getClLienActiver());
/* 1373 */     lien.setClLienSelect(getClLienSelect());
/*      */     
/*      */ 
/*      */ 
/* 1377 */     lien.setCommentaire(getCommentaire());
/* 1378 */     lien.setHistorisation(getHistorisation());
/* 1379 */     lien.setCode(getCode());
/*      */     
/* 1381 */     lien.setFleche(isFleche());
/* 1382 */     lien.setRelatif(isRelatif());
/* 1383 */     lien.setZoom(getZoom());
/*      */     
/* 1385 */     lien.setPointCassure(copierListePointDeCassure());
/* 1386 */     lien.setHistorique(copierHistoriques(this.historique));
/* 1387 */     ajouterCopier(lien.getHistorique());
/* 1388 */     return lien;
/*      */   }
/*      */   
/*      */   public static IhmLien2 parseIhmLien(IhmLien lien, IhmEntiteRelation newEnt, IhmEntiteRelation newRel)
/*      */   {
/* 1393 */     IhmLien2 l = new IhmLien2((IhmEntite2)newEnt, (IhmRelation2)newRel);
/* 1394 */     l.setNom(lien.getNom());
/* 1395 */     l.setCode(lien.getNom().toUpperCase());
/* 1396 */     l.setClLienNom2(IhmLien.getClLien());
/* 1397 */     l.setClLien2(IhmLien.getClLien());
/* 1398 */     l.setClLienText2(IhmLien.getClLien());
/*      */     
/* 1400 */     l.setCardinalite(lien.getCardinalite());
/* 1401 */     if (lien.isCassure()) {
/* 1402 */       l.getPointCassure().add(new IhmPoint((int)lien.getxCassure(), (int)lien.getyCassure()));
/*      */     }
/*      */     
/* 1405 */     if (lien.getCardinalite().contains("(")) {
/* 1406 */       l.getCardinalites().setRelatif(true);
/* 1407 */       l.setRelatif(true);
/*      */     }
/*      */     
/* 1410 */     return l;
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmLien2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */