/*      */ package IhmMCD2;
/*      */ 
/*      */ import IhmMCD.IhmRelation;
/*      */ import Merise.Attribut;
/*      */ import Merise.Relation;
/*      */ import Merise2.Attribut2;
/*      */ import Merise2.AttributContrainte2;
/*      */ import Merise2.Historique;
/*      */ import Merise2.Relation2;
/*      */ import Outil.Parametres;
/*      */ import Outil.Setting;
/*      */ import ihm.FormeInterneMCD;
/*      */ import java.awt.BasicStroke;
/*      */ import java.awt.Color;
/*      */ import java.awt.Font;
/*      */ import java.awt.FontMetrics;
/*      */ import java.awt.GradientPaint;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.Stroke;
/*      */ import java.awt.geom.Rectangle2D;
/*      */ import java.awt.geom.Rectangle2D.Double;
/*      */ import java.awt.geom.RoundRectangle2D;
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
/*      */ 
/*      */ 
/*      */ public class IhmRelation2
/*      */   extends IhmRelation
/*      */   implements Serializable
/*      */ {
/*      */   public Color clCadre2;
/*      */   public Color clFond2;
/*      */   public Color clText2;
/*      */   public Color clTextType2;
/*      */   public Color clCadreTitre2;
/*      */   public Color clFondTitre2;
/*      */   public Color clTextTitre2;
/*      */   public Color clTextTaille2;
/*      */   public Color clTextTailleDec2;
/*      */   public Font font;
/*      */   public Font fontTitre;
/*      */   public Font fontAttribut;
/*      */   public Font fontType;
/*      */   public Font fontNormal;
/*      */   public Color clAttributSelect;
/*      */   public Color clLienActiver;
/*      */   public Color clSelected;
/*      */   public String aligne;
/*      */   public String aligneTitre;
/*      */   public int xType;
/*      */   public int xCle;
/*      */   public double zoom;
/*      */   public ArrayList<Historique> historique;
/*      */   public int widthMin;
/*      */   public int widthMax;
/*      */   public int xAttribut;
/*      */   public String alignerAttribut;
/*      */   public String alignerType;
/*      */   public int hAttribut;
/*      */   public int yAttribut;
/*      */   public int yEntete;
/*      */   public int decalCompose;
/*      */   public double AttEspace;
/*      */   public float epaisseur;
/*      */   public boolean prkvisible;
/*      */   public boolean attMajuscule;
/*      */   public Color clOmbre;
/*      */   public int nbUsedLibrairie;
/*      */   public String dispatchKey;
/*      */   Attribut attributSelect2;
/*      */   ArrayList<AttributContrainte2> listeIndex2;
/*      */   ArrayList<AttributContrainte2> listeUnique2;
/*      */   ArrayList<AttributContrainte2> listeCle2;
/*      */   ArrayList<AttributContrainte2> listeCleEtrangere2;
/*      */   String codeEntete2;
/*      */   String codeAttribut2;
/*      */   String codeMethode2;
/*      */   String codeFin2;
/*      */   String augmentation2;
/*      */   boolean augmentationPrefix2;
/*      */   boolean mldGenerer2;
/*      */   boolean afficherCodeEntite2;
/*      */   boolean afficherCodeAttribut2;
/*      */   String origine2;
/*      */   boolean mldHeritageGenerer2;
/*      */   boolean afficherCntUnique2;
/*      */   boolean afficherCntIndex2;
/*      */   boolean afficherCntCle2;
/*      */   boolean afficherCntCleEtrangere2;
/*      */   String identifiant;
/*      */   
/*      */   public IhmRelation2(Relation entite, int x, int y, boolean isvariable)
/*      */   {
/*  115 */     super(entite, x, y, isvariable);
/*      */     
/*  117 */     this.clCadre2 = FormeInterneMCD.clRelationCadre2;
/*  118 */     this.clFond2 = FormeInterneMCD.clRelationFond2;
/*  119 */     this.clText2 = FormeInterneMCD.clRelationText2;
/*  120 */     this.clTextType2 = FormeInterneMCD.clRelationTextType2;
/*  121 */     this.clCadreTitre2 = FormeInterneMCD.clRelationCadre2;
/*  122 */     this.clFondTitre2 = FormeInterneMCD.clRelationFondTitre2;
/*  123 */     this.clTextTitre2 = FormeInterneMCD.clRelationTextTitre2;
/*  124 */     this.clTextTaille2 = FormeInterneMCD.clRelationTextTaille2;
/*  125 */     this.clTextTailleDec2 = FormeInterneMCD.clRelationTextTailleDec2;
/*      */     
/*  127 */     this.clLienActiver = FormeInterneMCD.clLienActiverRelation2;
/*      */     
/*  129 */     this.font = Parametres.fontGras;
/*  130 */     this.fontTitre = Parametres.fontGras;
/*  131 */     this.fontNormal = Parametres.fontNormal;
/*      */     
/*  133 */     this.clSelected = FormeInterneMCD.clSelected;
/*  134 */     this.aligne = "";
/*  135 */     this.aligneTitre = "";
/*  136 */     this.zoom = FormeInterneMCD.zoom;
/*      */     
/*  138 */     this.historique = new ArrayList();
/*  139 */     this.historique.add(Historique.getHistoriqueCreation());
/*  140 */     this.decalCompose = 14;
/*  141 */     this.AttEspace = FormeInterneMCD.interLigne2;
/*      */     
/*  143 */     this.epaisseur = FormeInterneMCD.traitEntiteRelation2;
/*  144 */     this.prkvisible = FormeInterneMCD.afficherPrk2;
/*  145 */     this.attMajuscule = FormeInterneMCD.typeMajuscule2;
/*  146 */     setVariable(FormeInterneMCD.afficheType2);
/*      */     
/*  148 */     this.clOmbre = FormeInterneMCD.clOmbre2;
/*  149 */     setOmbre(FormeInterneMCD.isOmbree2);
/*  150 */     setClDegradee(FormeInterneMCD.isDegradee2);
/*  151 */     this.nbUsedLibrairie = 0;
/*  152 */     this.dispatchKey = "";
/*      */     
/*      */ 
/*      */ 
/*  156 */     this.attributSelect2 = null;
/*  157 */     this.listeIndex2 = new ArrayList();
/*  158 */     this.listeUnique2 = new ArrayList();
/*  159 */     this.listeCle2 = new ArrayList();
/*  160 */     this.listeCleEtrangere2 = new ArrayList();
/*      */     
/*  162 */     this.codeEntete2 = "";
/*  163 */     this.codeAttribut2 = "";
/*  164 */     this.codeMethode2 = "";
/*  165 */     this.codeFin2 = "";
/*      */     
/*  167 */     this.augmentation2 = "";
/*  168 */     this.augmentationPrefix2 = false;
/*  169 */     this.mldGenerer2 = true;
/*  170 */     this.afficherCodeEntite2 = false;
/*  171 */     this.afficherCodeAttribut2 = false;
/*  172 */     this.origine2 = "RELATION";
/*  173 */     this.mldHeritageGenerer2 = true;
/*      */     
/*  175 */     this.afficherCntCle2 = false;
/*  176 */     this.afficherCntCleEtrangere2 = false;
/*  177 */     this.afficherCntIndex2 = false;
/*  178 */     this.afficherCntUnique2 = false;
/*  179 */     this.identifiant = "";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void paint(Graphics g)
/*      */   {
/*  186 */     Graphics2D g2d = (Graphics2D)g;
/*  187 */     g2d = (Graphics2D)g.create();
/*      */     
/*  189 */     Stroke stro = g2d.getStroke();
/*  190 */     float[] style = { 5.0F, 0.0F };
/*  191 */     g2d.setStroke(new BasicStroke(this.epaisseur, 0, 0, 10.0F, style, 0.0F));
/*      */     
/*      */ 
/*  194 */     ajousterTaille(g2d);
/*  195 */     dessinerOmbre(g2d);
/*  196 */     dessinerFondEntite(g2d);
/*  197 */     dessinerEntete(g2d);
/*      */     
/*  199 */     ecrireAttributs(g2d);
/*  200 */     if (isSelected()) dessinerSelected(g2d);
/*  201 */     g2d.setStroke(stro);
/*      */   }
/*      */   
/*      */   private void dessinerOmbre(Graphics2D g) {
/*  205 */     if (!isOmbre()) return;
/*  206 */     Color clgard = g.getColor();
/*  207 */     RoundRectangle2D rRect = new RoundRectangle2D.Double(getX() + 5, getY() + 3, getWidth(), getHeight() + 2, getHeight() / 2.0D, getHeight());
/*      */     
/*  209 */     if (getWidth() < getHeight()) { rRect = new RoundRectangle2D.Double(getX() + 5, getY() + 3, getWidth(), getHeight() + 2, getHeight() / 4.0D, getHeight());
/*      */     }
/*  211 */     g.setColor(this.clOmbre);
/*  212 */     g.fill(rRect);
/*      */     
/*  214 */     g.setColor(clgard);
/*      */   }
/*      */   
/*      */   private int XDebut(RoundRectangle2D rec, int x, int y) {
/*  218 */     int xd = x;
/*  219 */     while (!rec.contains(xd, y)) { xd++;
/*      */     }
/*  221 */     return xd;
/*      */   }
/*      */   
/*      */   private int XFin(RoundRectangle2D rec, int x, int y) {
/*  225 */     int xd = x;
/*  226 */     while (!rec.contains(xd, y)) xd--;
/*  227 */     return xd;
/*      */   }
/*      */   
/*      */   private String getHistrosation() {
/*  231 */     Relation2 rel = (Relation2)getRelation();
/*  232 */     if (rel.getHistorisation().length() == 0) return "";
/*  233 */     return "  [ " + rel.getHistorisation() + " ]";
/*      */   }
/*      */   
/*      */   private void ajusterWidthNom(Graphics2D g)
/*      */   {
/*  238 */     if ((getRelation().getNom().length() == 0) && (getRelation().getListeAttributs().size() == 0)) {
/*      */       return;
/*      */     }
/*      */     RoundRectangle2D rRect;
/*  243 */     if (getWidth() < getHeight()) rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight() / 4.0D, getHeight()); else {
/*  244 */       rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight() / 2.0D, getHeight());
/*      */     }
/*  246 */     int h = g.getFontMetrics().getHeight();
/*  247 */     String s = getHistrosation();
/*  248 */     int mx = (getWidth() - g.getFontMetrics().stringWidth(getRelation().getNom() + s)) / 2;
/*      */     
/*  250 */     int x = getX() + mx;
/*  251 */     int y = getY() + h + 3;
/*  252 */     int y2 = getY() + 2;
/*  253 */     int x2 = getX() + getWidth() - mx;
/*  254 */     Rectangle2D r = new Rectangle2D.Double(x, y2, x2 - x, h - 2);
/*  255 */     int nb = 1;
/*  256 */     while (!rRect.contains(r)) {
/*  257 */       redimentionner(getX(), getY(), getWidth() + 6, getHeight());
/*  258 */       if (getWidth() < getHeight()) rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight() / 4.0D, getHeight()); else {
/*  259 */         rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight() / 2.0D, getHeight());
/*      */       }
/*  261 */       mx = (getWidth() - g.getFontMetrics().stringWidth(getRelation().getNom() + s)) / 2;
/*  262 */       x = getX() + mx;
/*      */       
/*  264 */       x2 = getX() + getWidth() - mx;
/*  265 */       r = new Rectangle2D.Double(x, y2, x2 - x, h - 2);
/*  266 */       nb++;
/*  267 */       if (getWidth() < getHeight()) rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight() / 4.0D, getHeight()); else {
/*  268 */         rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight() / 2.0D, getHeight());
/*      */       }
/*  270 */       if (nb > 15) {}
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void dessinerFondEntite(Graphics2D g)
/*      */   {
/*  277 */     Color clgard = g.getColor();
/*  278 */     g.setColor(Color.GRAY);
/*  279 */     Graphics2D g2d = g;
/*  280 */     g.setColor(this.clFond2);
/*  281 */     if (isClDegradee())
/*  282 */       g2d.setPaint(new GradientPaint(getX(), getY(), getClFond2(), getX() + getWidth(), getY() + getHeight(), Color.WHITE, true));
/*      */     RoundRectangle2D rRect;
/*  285 */     if (getWidth() < getHeight()) rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight() / 4.0D, getHeight()); else
/*  286 */       rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight() / 2.0D, getHeight());
/*  287 */     g.fill(rRect);
/*      */     
/*  289 */     g.setColor(clgard);
/*      */   }
/*      */   
/*      */   private void dessinerEntete(Graphics2D g) {
/*  293 */     Color clgard = g.getColor();
/*  294 */     Graphics2D g2d = g;
/*  295 */     int h = g.getFontMetrics().getHeight();
/*  296 */     int ht = h + h / 2;
/*      */     
/*  298 */     RoundRectangle2D rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight() / 2.0D, getHeight());
/*  299 */     if (getWidth() < getHeight()) rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight() / 4.0D, getHeight());
/*  300 */     g.setFont(getFontTitre());
/*  301 */     g.setColor(this.clTextTitre2);
/*  302 */     String s = getHistrosation();
/*  303 */     g.drawString(getRelation().getNom() + s, getX() + (getWidth() - g.getFontMetrics().stringWidth(getRelation().getNom() + s)) / 2, getY() + h);
/*      */     
/*  305 */     if (((getRelation().getNom() + s).length() != 0) || (getRelation().getListeAttributs().size() != 0)) {
/*  306 */       g.setColor(this.clCadreTitre2);
/*  307 */       int xd = XDebut(rRect, getX(), getY() + ht);
/*  308 */       int xf = XFin(rRect, getX() + getWidth(), getY() + ht);
/*      */       
/*  310 */       dessinerFondEnteteRelation(g, ht, xd, xf, s);
/*      */     }
/*      */     else {
/*  313 */       g.setColor(this.clCadre2);
/*  314 */       g.draw(rRect);
/*      */     }
/*  316 */     g.setColor(clgard);
/*      */   }
/*      */   
/*      */ 
/*      */   private void dessinerFondEnteteRelation(Graphics2D g, int hauteur, int xd, int xf, String nomRel)
/*      */   {
/*  322 */     int ht = hauteur;
/*  323 */     int xDeb = xd;int xFin = xf;
/*      */     
/*  325 */     RoundRectangle2D rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight() / 2.0D, getHeight());
/*  326 */     if (getWidth() < getHeight()) rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight() / 4.0D, getHeight());
/*  327 */     int y = getY() + hauteur;
/*  328 */     Graphics2D g2d = (Graphics2D)g.create();
/*      */     
/*  330 */     Stroke stro = g2d.getStroke();
/*  331 */     float[] style = { 10.0F, 0.0F };
/*  332 */     g2d.setStroke(new BasicStroke(2.0F, 0, 0, 10.0F, style, 0.0F));
/*  333 */     g2d.setColor(this.clFondTitre2);
/*  334 */     while (hauteur > 0) {
/*  335 */       while (!rRect.contains(xd, y)) xd++;
/*  336 */       while (!rRect.contains(xf, y)) xf--;
/*  337 */       g2d.drawLine(xd, y, xf, y);
/*  338 */       y -= 1;
/*  339 */       hauteur -= 1;
/*      */     }
/*  341 */     g2d.setStroke(stro);
/*  342 */     g2d.setColor(this.clCadre2);
/*  343 */     g2d.drawLine(xDeb, getY() + ht, xFin, getY() + ht);
/*  344 */     g2d.draw(rRect);
/*  345 */     g2d.setColor(this.clTextTitre2);
/*  346 */     g2d.drawString(getRelation().getNom() + nomRel, getX() + (getWidth() - g.getFontMetrics().stringWidth(getRelation().getNom() + nomRel)) / 2, (int)(getY() + ht / 1.5D));
/*      */   }
/*      */   
/*      */   private void dessinerSelected(Graphics2D g)
/*      */   {
/*  351 */     Color clgard = g.getColor();
/*  352 */     g.setColor(this.clSelected);
/*      */     
/*  354 */     RoundRectangle2D rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight() / 2.0D, getHeight());
/*  355 */     if (getWidth() < getHeight()) { rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), getHeight() / 4.0D, getHeight());
/*      */     }
/*  357 */     if (Setting.agraverSelection2) {
/*  358 */       g.setColor(this.clLienActiver);
/*  359 */       RoundRectangle2D rRect2 = new RoundRectangle2D.Double(getX() - 3, getY() - 3, getWidth() + 6, getHeight() + 6, getHeight() / 2.0D, getHeight());
/*  360 */       g.draw(rRect2);
/*  361 */       if (getWidth() < getHeight()) { rRect2 = new RoundRectangle2D.Double(getX() - 3, getY() - 3, getWidth() + 6, getHeight() + 6, getHeight() / 4.0D, getHeight());
/*      */       }
/*  363 */       float[] style = { 5.0F, 0.0F };
/*  364 */       g.setStroke(new BasicStroke(4.0F, 0, 0, 10.0F, style, 0.0F));
/*  365 */       g.setColor(this.clSelected);
/*      */     }
/*      */     
/*      */ 
/*  369 */     g.draw(rRect);
/*      */     
/*      */ 
/*  372 */     g.setColor(Color.BLACK);
/*  373 */     g.fillRect(getX() - 1 + getWidth() / 2, getY() - 1, 4, 4);
/*  374 */     g.fillRect(getX() - 1, getY() - 2 + getHeight() / 2, 4, 4);
/*  375 */     g.fillRect(getX() - 1 + getWidth() / 2, getY() - 1 + getHeight(), 4, 4);
/*  376 */     g.fillRect(getX() - 1 + getWidth(), getY() - 2 + getHeight() / 2, 4, 4);
/*      */     
/*  378 */     g.setColor(clgard);
/*      */   }
/*      */   
/*      */   private String getTypeAttribut(Attribut2 att)
/*      */   {
/*  383 */     if (att == null) return "";
/*  384 */     String t = "";
/*  385 */     if (att.getType().trim().length() == 0) return "";
/*  386 */     if (att.getType().toUpperCase().equals("AUTO_INCREMENT")) {
/*  387 */       t = att.getType();
/*  388 */       if (att.isUnSigned()) t = "+" + t;
/*  389 */       return t;
/*      */     }
/*  391 */     if ((att.getLongueur() < 0) && (att.getLongDecimale() < 0)) {
/*  392 */       t = att.getType();
/*  393 */       if (att.isUnSigned()) t = "+" + t;
/*  394 */       return t;
/*      */     }
/*  396 */     if (att.getLongueur() < 0) {
/*  397 */       t = att.getType();
/*  398 */       if (att.isUnSigned()) t = "+" + t;
/*  399 */       return t + " (0," + att.getLongDecimale() + ")";
/*      */     }
/*  401 */     if (att.getLongDecimale() > 0) {
/*  402 */       t = att.getType();
/*  403 */       if (att.isUnSigned()) t = "+" + t;
/*  404 */       return t + " (" + att.getLongueur() + "," + att.getLongDecimale() + ")";
/*      */     }
/*  406 */     t = att.getType();
/*  407 */     if (att.isUnSigned()) t = "+" + t;
/*  408 */     return t + " (" + att.getLongueur() + ")";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void drawTailleType(Attribut2 att, Graphics2D g, int x, int y)
/*      */   {
/*  417 */     String car = getTypeAttribut(att);
/*      */     
/*  419 */     if (!isDrawTaille(car)) { return;
/*      */     }
/*  421 */     String type = att.getType();
/*  422 */     if (att.isUnSigned()) { type = "+" + type;
/*      */     }
/*  424 */     if (this.attMajuscule) {
/*  425 */       type = type.toUpperCase();
/*      */     }
/*      */     
/*  428 */     type = type + " ";
/*      */     
/*  430 */     int wtype = g.getFontMetrics().stringWidth(type);
/*  431 */     g.drawString("(", x + wtype, y);
/*  432 */     Color cl = g.getColor();
/*      */     
/*  434 */     type = type + "(";
/*  435 */     wtype = g.getFontMetrics().stringWidth(type);
/*  436 */     int t = att.getLongueur();
/*  437 */     if (t < 0) { t = 0;
/*      */     }
/*  439 */     g.setColor(getColor(att.getClTaille()));
/*  440 */     g.drawString(t + "", x + wtype, y);
/*      */     
/*  442 */     if (att.getLongDecimale() > -1) {
/*  443 */       type = type + t;
/*  444 */       wtype = g.getFontMetrics().stringWidth(type);
/*  445 */       g.setColor(cl);
/*  446 */       g.drawString(",", x + wtype, y);
/*  447 */       type = type + ",";
/*  448 */       wtype = g.getFontMetrics().stringWidth(type);
/*  449 */       t = att.getLongDecimale();
/*  450 */       g.setColor(getColor(att.getClTailleDecimale()));
/*  451 */       g.drawString(t + "", x + wtype, y);
/*  452 */       type = type + t;
/*  453 */       wtype = g.getFontMetrics().stringWidth(type);
/*  454 */       g.setColor(cl);
/*  455 */       g.drawString(")", x + wtype, y);
/*      */     } else {
/*  457 */       type = type + t;
/*  458 */       wtype = g.getFontMetrics().stringWidth(type);
/*  459 */       g.setColor(cl);
/*  460 */       g.drawString(")", x + wtype, y);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean isDrawTaille(String car)
/*      */   {
/*  467 */     if ((car.contains("(")) && (car.contains(")"))) return true;
/*  468 */     return false;
/*      */   }
/*      */   
/*      */   private String getTypeAttributSansTaille(Attribut2 att) {
/*  472 */     if (att == null) return "";
/*  473 */     String t = "";
/*  474 */     if (att.getType().trim().length() == 0) return "";
/*  475 */     if (att.getType().toUpperCase().equals("AUTO_INCREMENT")) {
/*  476 */       t = att.getType();
/*  477 */       if (att.isUnSigned()) t = "+" + t;
/*  478 */       return t;
/*      */     }
/*  480 */     t = att.getType();
/*  481 */     if (att.isUnSigned()) t = "+" + t;
/*  482 */     return t;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private int getWidthType(Graphics2D g)
/*      */   {
/*  489 */     int w = 0;
/*  490 */     int wMax = 0;
/*  491 */     int nb = getRelation().getListeAttributs().size();
/*  492 */     for (int i = 0; i < nb; i++) {
/*  493 */       if (((Attribut2)getRelation().getListeAttributs().get(i)).isAfficher()) {
/*  494 */         w = g.getFontMetrics().stringWidth(getTypeAttribut((Attribut2)getRelation().getListeAttributs().get(i)));
/*  495 */         if (this.attMajuscule) {
/*  496 */           w = g.getFontMetrics().stringWidth(getTypeAttribut((Attribut2)getRelation().getListeAttributs().get(i)).toUpperCase());
/*      */         }
/*  498 */         if (w > wMax)
/*  499 */           wMax = w;
/*  500 */         if (((Attribut2)getRelation().getListeAttributs().get(i)).getListeAttributs().size() > 0) {
/*  501 */           wMax = getWidthMaxType(g, (Attribut2)getRelation().getListeAttributs().get(i), wMax);
/*      */         }
/*      */       }
/*      */     }
/*  505 */     return wMax;
/*      */   }
/*      */   
/*      */ 
/*      */   private int getWidthMaxType(Graphics2D g, Attribut2 att, int max)
/*      */   {
/*  511 */     int nb = att.getListeAttributs().size();
/*  512 */     for (int i = 0; i < nb; i++) {
/*  513 */       if (((Attribut2)att.getListeAttributs().get(i)).isAfficher()) {
/*  514 */         int w = g.getFontMetrics().stringWidth(getTypeAttribut((Attribut2)att.getListeAttributs().get(i)));
/*  515 */         if (this.attMajuscule) {
/*  516 */           w = g.getFontMetrics().stringWidth(getTypeAttribut((Attribut2)att.getListeAttributs().get(i)).toUpperCase());
/*      */         }
/*  518 */         if (w > max) {
/*  519 */           max = w;
/*      */         }
/*  521 */         max = getWidthMaxType(g, (Attribut2)att.getListeAttributs().get(i), max);
/*      */       }
/*      */     }
/*  524 */     return max;
/*      */   }
/*      */   
/*      */   private int getWidthNomAttribut(Graphics2D g)
/*      */   {
/*  529 */     int w = 0;
/*  530 */     int wMax = 0;
/*  531 */     int nb = getRelation().getListeAttributs().size();
/*  532 */     for (int i = 0; i < nb; i++) {
/*  533 */       if (((Attribut2)getRelation().getListeAttributs().get(i)).isAfficher()) {
/*  534 */         w = g.getFontMetrics().stringWidth(((Attribut2)getRelation().getListeAttributs().get(i)).getNomHistrosation());
/*  535 */         if (w > wMax) {
/*  536 */           wMax = w;
/*      */         }
/*  538 */         if (((Attribut2)getRelation().getListeAttributs().get(i)).getListeAttributs().size() > 0) {
/*  539 */           wMax = getWidthMaxSousAttribut(g, (Attribut2)getRelation().getListeAttributs().get(i), wMax, 0);
/*      */         }
/*      */       }
/*      */     }
/*  543 */     return wMax;
/*      */   }
/*      */   
/*      */   private int getWidthMaxSousAttribut(Graphics2D g, Attribut2 att, int max, int profondeur)
/*      */   {
/*  548 */     int w = 0;
/*      */     
/*  550 */     profondeur++;
/*  551 */     int nb = att.getListeAttributs().size();
/*  552 */     for (int i = 0; i < nb; i++) {
/*  553 */       if (((Attribut2)att.getListeAttributs().get(i)).isAfficher()) {
/*  554 */         w = g.getFontMetrics().stringWidth(((Attribut2)att.getListeAttributs().get(i)).getNomHistrosation());
/*  555 */         if (w + this.decalCompose * profondeur > max) {
/*  556 */           max = w + this.decalCompose * profondeur;
/*      */         }
/*  558 */         max = getWidthMaxSousAttribut(g, (Attribut2)att.getListeAttributs().get(i), max, profondeur);
/*      */       }
/*      */     }
/*  561 */     return max;
/*      */   }
/*      */   
/*      */ 
/*      */   private int calculerWidthEntite(Graphics2D g)
/*      */   {
/*  567 */     int wEntete = g.getFontMetrics().stringWidth(getRelation().getNom() + getHistrosation() + "MESS");
/*  568 */     int wAtt = getWidthNomAttribut(g);
/*  569 */     int wType = 0;
/*  570 */     int wPrk = 0;
/*      */     
/*  572 */     if ((getRelation().getNom().trim().length() == 0) && (getRelation().getListeAttributs().size() == 0))
/*      */     {
/*  574 */       return 40;
/*      */     }
/*      */     
/*  577 */     if (isVariable()) wType = getWidthType(g);
/*  578 */     if (this.prkvisible) wPrk = 0;
/*  579 */     int wtotal = g.getFontMetrics().stringWidth("H");
/*  580 */     this.xType = (wtotal + wAtt + wPrk);
/*  581 */     wtotal = wtotal + wAtt + wType + wPrk;
/*      */     
/*  583 */     wtotal += g.getFontMetrics().stringWidth("HHHH");
/*      */     
/*      */ 
/*  586 */     if (wtotal < wEntete) {
/*  587 */       wtotal = wEntete;
/*      */     } else {
/*  589 */       wtotal += g.getFontMetrics().stringWidth("HH");
/*      */     }
/*  591 */     if (!this.prkvisible) {
/*  592 */       this.xType += 3;
/*      */     }
/*  594 */     return wtotal + g.getFontMetrics().stringWidth("H");
/*      */   }
/*      */   
/*      */   private int nbAttributProfondeur(Attribut2 att, int nb) {
/*  598 */     if (att.getListeAttributs().size() == 0) { return 0;
/*      */     }
/*  600 */     for (int i = 0; i < att.getListeAttributs().size(); i++) {
/*  601 */       nb += nbAttributProfondeur((Attribut2)att.getListeAttributs().get(i), ((Attribut2)att.getListeAttributs().get(i)).getListeAttributs().size());
/*      */     }
/*  603 */     return nb;
/*      */   }
/*      */   
/*      */   private int calculerHeightEntite(Graphics2D g)
/*      */   {
/*  608 */     int h = g.getFontMetrics().getHeight();
/*  609 */     if ((getRelation().getNom().length() == 0) && (getRelation().getListeAttributs().size() == 0)) return h * 2;
/*  610 */     int hauteur = 0;
/*  611 */     int nbAfficher = 0;
/*      */     
/*  613 */     int nb = getRelation().getListeAttributs().size();
/*  614 */     if (nb == 0) {
/*  615 */       if (getRelation().getNom().length() == 0) return h * 2;
/*  616 */       return (int)(h * 2.5D);
/*      */     }
/*  618 */     for (int i = 0; i < nb; i++) {
/*  619 */       Attribut2 att = (Attribut2)getRelation().getListeAttributs().get(i);
/*  620 */       if (att.isAfficher()) {
/*  621 */         int nbAtt = nbAttributProfondeur(att, att.getListeAttributs().size());
/*  622 */         hauteur = (int)((1 + nbAtt) * this.AttEspace * h) + hauteur;
/*  623 */         nbAfficher++;
/*      */       }
/*      */     }
/*  626 */     if (nbAfficher < nb) {
/*  627 */       hauteur += 1 * h;
/*      */     }
/*  629 */     if (nb > 0) {
/*  630 */       hauteur += 2 * h;
/*      */     }
/*      */     
/*  633 */     return hauteur - (int)(0.25D * h);
/*      */   }
/*      */   
/*      */   public void ajousterTaille(Graphics2D g) {
/*  637 */     g.setFont(this.fontTitre);
/*  638 */     int h = calculerHeightEntite(g);
/*  639 */     int w = calculerWidthEntite(g);
/*  640 */     redimentionner(getX(), getY(), w, h);
/*  641 */     setWidth(w);
/*  642 */     setHeight(h);
/*  643 */     ajusterWidthNom(g);
/*      */   }
/*      */   
/*      */   private void ecrireAttribut(Graphics2D g, Attribut2 att, int x, int y, int profondeur) {
/*  647 */     int dec = 2;
/*  648 */     dec += this.decalCompose * profondeur;
/*  649 */     g.setColor(this.clText2);
/*  650 */     if (isVariable()) {
/*  651 */       g.setFont(this.fontNormal);
/*  652 */       if (this.prkvisible) {
/*  653 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Cle)) g.drawString("PrK", x + 3, y);
/*  654 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Index)) g.drawString("Idx", x + 3, y);
/*  655 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Unique)) { g.drawString("Uni", x + 3, y);
/*      */         }
/*      */       }
/*      */       
/*  659 */       if (att.getKey().equals(Parametres.Cle))
/*      */       {
/*  661 */         g.setFont(this.font);
/*  662 */         g.setColor(getColor(att.getClNom()));
/*  663 */         g.drawString(att.getNomHistrosation(), x + dec, y);
/*  664 */         g.drawLine(x + dec, y + 1, x + dec + g.getFontMetrics().stringWidth(att.getNomHistrosation()), y + 1);
/*  665 */         g.setFont(this.fontNormal);
/*      */       } else {
/*  667 */         g.setColor(getColor(att.getClNom()));
/*  668 */         if (att.getListeAttributs().size() > 0) g.setFont(Parametres.fontItalic12);
/*  669 */         g.drawString(att.getNomHistrosation(), x + dec, y);
/*      */       }
/*  671 */       if (att.getListeAttributs().size() == 0)
/*      */       {
/*  673 */         g.setColor(getColor(att.getClType()));
/*  674 */         if (this.attMajuscule) {
/*  675 */           g.drawString(getTypeAttributSansTaille(att).toUpperCase(), this.xType + x, y);
/*      */         } else {
/*  677 */           g.drawString(getTypeAttributSansTaille(att), this.xType + x, y);
/*      */         }
/*  679 */         drawTailleType(att, g, this.xType + x, y);
/*      */       }
/*      */     } else {
/*  682 */       g.setFont(this.fontNormal);
/*  683 */       if (this.prkvisible) {
/*  684 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Cle)) g.drawString("PrK", x + 3, y);
/*  685 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Index)) g.drawString("Idx", x + 3, y);
/*  686 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Unique)) { g.drawString("Uni", x + 3, y);
/*      */         }
/*      */       }
/*  689 */       if (att.getKey().equals(Parametres.Cle)) {
/*  690 */         g.setFont(this.font);
/*  691 */         g.setColor(getColor(att.getClNom()));
/*  692 */         g.drawString(att.getNomHistrosation(), x + dec, y);
/*  693 */         g.drawLine(x + dec, y + 1, x + dec + g.getFontMetrics().stringWidth(att.getNomHistrosation()), y + 1);
/*  694 */         g.setFont(this.fontNormal);
/*      */       } else {
/*  696 */         g.setColor(getColor(att.getClNom()));
/*  697 */         if (att.getListeAttributs().size() > 0) g.setFont(Parametres.fontItalic12);
/*  698 */         g.drawString(att.getNomHistrosation(), x + dec, y);
/*      */       }
/*      */     }
/*  701 */     if (att.getListeAttributs().size() > 0) {
/*  702 */       profondeur++;
/*  703 */       int y1 = y + 4;
/*  704 */       int h = g.getFontMetrics().getHeight();
/*  705 */       for (int i = 0; i < att.getListeAttributs().size(); i++) {
/*  706 */         y += (int)(h * this.AttEspace);
/*  707 */         ecrireAttribut(g, (Attribut2)att.getListeAttributs().get(i), x, y, profondeur);
/*  708 */         int nbAtt = nbAttributProfondeur((Attribut2)att.getListeAttributs().get(i), ((Attribut2)att.getListeAttributs().get(i)).getListeAttributs().size());
/*  709 */         y += (int)(h * (nbAtt * this.AttEspace));
/*      */       }
/*      */       
/*  712 */       int y2 = y + 1;
/*  713 */       g.setColor(this.clText2);
/*  714 */       g.drawLine(x + dec + 8, y1 + 1, x + dec + 8, y2);
/*  715 */       g.drawLine(x + dec + 8, y2 + 1, x + dec + 15, y2 + 1);
/*      */     }
/*      */   }
/*      */   
/*      */   private void ecrireAttribut(Graphics2D g, Attribut2 att, int x, int y)
/*      */   {
/*  721 */     int dec = 2;
/*      */     
/*      */ 
/*      */ 
/*  725 */     g.setColor(this.clText2);
/*  726 */     if (isVariable()) {
/*  727 */       g.setFont(this.fontNormal);
/*  728 */       if (this.prkvisible) {
/*  729 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Cle)) g.drawString("PrK", x + 3, y);
/*  730 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Index)) g.drawString("Idx", x + 3, y);
/*  731 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Unique)) { g.drawString("Uni", x + 3, y);
/*      */         }
/*      */       }
/*      */       
/*  735 */       if (att.getKey().equals(Parametres.Cle))
/*      */       {
/*  737 */         g.setFont(this.font);
/*  738 */         g.drawString(att.getNomHistrosation(), x + dec, y);
/*  739 */         g.drawLine(x + dec, y + 1, x + dec + g.getFontMetrics().stringWidth(att.getNomHistrosation()), y + 1);
/*  740 */         g.setFont(this.fontNormal);
/*      */       } else {
/*  742 */         g.setColor(getColor(att.getClNom()));
/*  743 */         g.drawString(att.getNomHistrosation(), x + dec, y);
/*      */       }
/*  745 */       g.setColor(getColor(att.getClType()));
/*  746 */       if (this.attMajuscule) {
/*  747 */         g.drawString(getTypeAttributSansTaille(att).toUpperCase(), this.xType + x, y);
/*      */       } else {
/*  749 */         g.drawString(getTypeAttributSansTaille(att), this.xType + x, y);
/*      */       }
/*  751 */       drawTailleType(att, g, this.xType + x, y);
/*      */     } else {
/*  753 */       g.setFont(this.fontNormal);
/*  754 */       if (this.prkvisible) {
/*  755 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Cle)) g.drawString("PrK", x + 3, y);
/*  756 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Index)) g.drawString("Idx", x + 3, y);
/*  757 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Unique)) { g.drawString("Uni", x + 3, y);
/*      */         }
/*      */       }
/*  760 */       if (att.getKey().equals(Parametres.Cle)) {
/*  761 */         g.setFont(this.font);
/*  762 */         g.setColor(getColor(att.getClNom()));
/*  763 */         g.drawString(att.getNomHistrosation(), x + dec, y);
/*  764 */         g.drawLine(x + dec, y + 1, x + dec + g.getFontMetrics().stringWidth(att.getNomHistrosation()), y + 1);
/*  765 */         g.setFont(this.fontNormal);
/*      */       } else {
/*  767 */         g.setColor(getColor(att.getClNom()));
/*  768 */         g.drawString(att.getNomHistrosation(), x + dec, y);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void ecrireAttributs(Graphics2D g)
/*      */   {
/*  775 */     int nbAfficher = 0;
/*  776 */     int wPrk = g.getFontMetrics().stringWidth("HHHH");
/*  777 */     if (getRelation().getListeAttributs() != null)
/*      */     {
/*  779 */       int nb = getRelation().getListeAttributs().size();
/*  780 */       int y = (int)(g.getFontMetrics().getHeight() * 2.5D);
/*  781 */       int i = 0;
/*  782 */       int h = g.getFontMetrics().getHeight();
/*      */       
/*  784 */       while (i < nb) {
/*  785 */         if (((Attribut2)getRelation().getListeAttributs().get(i)).isAfficher()) {
/*  786 */           ecrireAttribut(g, (Attribut2)getRelation().getListeAttributs().get(i), getX() + wPrk, getY() + y, 0);
/*  787 */           int nbAtt = nbAttributProfondeur((Attribut2)getRelation().getListeAttributs().get(i), ((Attribut2)getRelation().getListeAttributs().get(i)).getListeAttributs().size());
/*  788 */           y += (int)(h * (this.AttEspace * (nbAtt + 1)));
/*      */           
/*  790 */           nbAfficher++;
/*      */         }
/*  792 */         i++;
/*      */       }
/*  794 */       if (nbAfficher < getRelation().getListeAttributs().size()) {
/*  795 */         ecrireAttribut(g, "...", getX() + wPrk, getY() + y);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void ecrireAttribut(Graphics g, String att, int x, int y) {
/*  801 */     int dec = g.getFontMetrics().stringWidth("MeSs");
/*  802 */     g.setColor(this.clText2);
/*  803 */     if (!this.prkvisible) {
/*  804 */       dec = 3;
/*      */     }
/*  806 */     g.drawString(att, x + dec, y);
/*      */   }
/*      */   
/*      */   public String getAligne() {
/*  810 */     return this.aligne;
/*      */   }
/*      */   
/*      */   public String getAligneTitre() {
/*  814 */     return this.aligneTitre;
/*      */   }
/*      */   
/*      */   public Color getClCadre2() {
/*  818 */     return this.clCadre2;
/*      */   }
/*      */   
/*      */   public Color getClCadreTitre2()
/*      */   {
/*  823 */     return this.clCadreTitre2;
/*      */   }
/*      */   
/*      */   public Color getClFond2()
/*      */   {
/*  828 */     return this.clFond2;
/*      */   }
/*      */   
/*      */   public Color getClFondTitre2() {
/*  832 */     return this.clFondTitre2;
/*      */   }
/*      */   
/*      */   public Color getClText2() {
/*  836 */     return this.clText2;
/*      */   }
/*      */   
/*      */   public boolean isAttMajuscule() {
/*  840 */     return this.attMajuscule;
/*      */   }
/*      */   
/*      */   public int getDecalCompose() {
/*  844 */     return this.decalCompose;
/*      */   }
/*      */   
/*      */   public boolean isPrkvisible() {
/*  848 */     return this.prkvisible;
/*      */   }
/*      */   
/*      */   public void setClTextType2(Color clTextType2) {
/*  852 */     this.clTextType2 = clTextType2;
/*      */   }
/*      */   
/*      */   public Color getClTextType2() {
/*  856 */     return this.clTextType2;
/*      */   }
/*      */   
/*      */   public Color getClLienActiver() {
/*  860 */     return this.clLienActiver;
/*      */   }
/*      */   
/*      */   public int getxCle() {
/*  864 */     return this.xCle;
/*      */   }
/*      */   
/*      */   public int getxType() {
/*  868 */     return this.xType;
/*      */   }
/*      */   
/*      */   public Color getClTextTitre2() {
/*  872 */     return this.clTextTitre2;
/*      */   }
/*      */   
/*      */   public Font getFont() {
/*  876 */     return this.font;
/*      */   }
/*      */   
/*      */   public Font getFontTitre() {
/*  880 */     return this.fontTitre;
/*      */   }
/*      */   
/*      */   public ArrayList<Historique> getHistorique() {
/*  884 */     return this.historique;
/*      */   }
/*      */   
/*      */   public Color getClOmbre() {
/*  888 */     return this.clOmbre;
/*      */   }
/*      */   
/*      */   public String getDispatchKey() {
/*  892 */     return this.dispatchKey;
/*      */   }
/*      */   
/*      */   public void setDispatchKey(String dispatchKey) {
/*  896 */     this.dispatchKey = dispatchKey;
/*      */   }
/*      */   
/*      */   public void setAligne(String aligne) {
/*  900 */     this.aligne = aligne;
/*      */   }
/*      */   
/*      */   public void setAligneTitre(String aligneTitre) {
/*  904 */     this.aligneTitre = aligneTitre;
/*      */   }
/*      */   
/*      */   public void setClCadre2(Color clCadre) {
/*  908 */     this.clCadre2 = clCadre;
/*      */   }
/*      */   
/*      */   public void setClCadreTitre2(Color clCadreTitre) {
/*  912 */     this.clCadreTitre2 = clCadreTitre;
/*      */   }
/*      */   
/*      */   public void setClFond2(Color clFond) {
/*  916 */     this.clFond2 = clFond;
/*      */   }
/*      */   
/*      */   public void setClFondTitre2(Color clFondTitre) {
/*  920 */     this.clFondTitre2 = clFondTitre;
/*      */   }
/*      */   
/*      */   public void setClText2(Color clText) {
/*  924 */     this.clText2 = clText;
/*      */   }
/*      */   
/*      */   public void setClTextTitre2(Color clTextTitre) {
/*  928 */     this.clTextTitre2 = clTextTitre;
/*      */   }
/*      */   
/*      */   public void setClLienActiver(Color clLienActiver) {
/*  932 */     this.clLienActiver = clLienActiver;
/*      */   }
/*      */   
/*      */   public void setAttEspace(double AttEspace) {
/*  936 */     this.AttEspace = AttEspace;
/*      */   }
/*      */   
/*      */   public void setEpaisseur(float epaisseur) {
/*  940 */     this.epaisseur = epaisseur;
/*      */   }
/*      */   
/*      */   public void setFont(Font font) {
/*  944 */     this.font = font;
/*      */   }
/*      */   
/*      */   public void setFontTitre(Font fontTitre) {
/*  948 */     this.fontTitre = fontTitre;
/*      */   }
/*      */   
/*      */   public void setxCle(int xCle) {
/*  952 */     this.xCle = xCle;
/*      */   }
/*      */   
/*      */   public void setxType(int xType) {
/*  956 */     this.xType = xType;
/*      */   }
/*      */   
/*      */   public void setHistorique(ArrayList<Historique> historique) {
/*  960 */     this.historique = historique;
/*      */   }
/*      */   
/*      */   public void setClOmbre(Color clOmbre) {
/*  964 */     this.clOmbre = clOmbre;
/*      */   }
/*      */   
/*      */   public String getAlignerAttribut() {
/*  968 */     return this.alignerAttribut;
/*      */   }
/*      */   
/*      */   public String getAlignerType() {
/*  972 */     return this.alignerType;
/*      */   }
/*      */   
/*      */   public Color getClSelected() {
/*  976 */     return this.clSelected;
/*      */   }
/*      */   
/*      */   public int gethAttribut() {
/*  980 */     return this.hAttribut;
/*      */   }
/*      */   
/*      */   public int getWidthMax() {
/*  984 */     return this.widthMax;
/*      */   }
/*      */   
/*      */   public int getWidthMin() {
/*  988 */     return this.widthMin;
/*      */   }
/*      */   
/*      */   public int getxAttribut() {
/*  992 */     return this.xAttribut;
/*      */   }
/*      */   
/*      */   public double getAttEspace() {
/*  996 */     return this.AttEspace;
/*      */   }
/*      */   
/*      */   public float getEpaisseur() {
/* 1000 */     return this.epaisseur;
/*      */   }
/*      */   
/*      */   public String getIdentifiant() {
/* 1004 */     return this.identifiant;
/*      */   }
/*      */   
/*      */   public int getyAttribut() {
/* 1008 */     return this.yAttribut;
/*      */   }
/*      */   
/*      */   public double getZoom() {
/* 1012 */     return this.zoom;
/*      */   }
/*      */   
/*      */   public Color getClAttributSelect() {
/* 1016 */     return this.clAttributSelect;
/*      */   }
/*      */   
/*      */   public Font getFontAttribut() {
/* 1020 */     return this.fontAttribut;
/*      */   }
/*      */   
/*      */   public Font getFontNormal() {
/* 1024 */     return this.fontNormal;
/*      */   }
/*      */   
/*      */   public Font getFontType() {
/* 1028 */     return this.fontType;
/*      */   }
/*      */   
/*      */   public int getyEntete() {
/* 1032 */     return this.yEntete;
/*      */   }
/*      */   
/*      */   public int getNbUsedLibrairie() {
/* 1036 */     return this.nbUsedLibrairie;
/*      */   }
/*      */   
/*      */   public void setAlignerAttribut(String alignerAttribut) {
/* 1040 */     this.alignerAttribut = alignerAttribut;
/*      */   }
/*      */   
/*      */   public void setAlignerType(String alignerType) {
/* 1044 */     this.alignerType = alignerType;
/*      */   }
/*      */   
/*      */   public void setClAttributSelect(Color clAttributSelect) {
/* 1048 */     this.clAttributSelect = clAttributSelect;
/*      */   }
/*      */   
/*      */   public void setClSelected(Color clSelected) {
/* 1052 */     this.clSelected = clSelected;
/*      */   }
/*      */   
/*      */   public void setFontAttribut(Font fontAttribut) {
/* 1056 */     this.fontAttribut = fontAttribut;
/*      */   }
/*      */   
/*      */   public void setFontNormal(Font fontNormal) {
/* 1060 */     this.fontNormal = fontNormal;
/*      */   }
/*      */   
/*      */   public void setFontType(Font fontType) {
/* 1064 */     this.fontType = fontType;
/*      */   }
/*      */   
/*      */   public void sethAttribut(int hAttribut) {
/* 1068 */     this.hAttribut = hAttribut;
/*      */   }
/*      */   
/*      */   public void setWidthMax(int widthMax) {
/* 1072 */     this.widthMax = widthMax;
/*      */   }
/*      */   
/*      */   public void setWidthMin(int widthMin) {
/* 1076 */     this.widthMin = widthMin;
/*      */   }
/*      */   
/*      */   public void setxAttribut(int xAttribut) {
/* 1080 */     this.xAttribut = xAttribut;
/*      */   }
/*      */   
/*      */   public void setyAttribut(int yAttribut) {
/* 1084 */     this.yAttribut = yAttribut;
/*      */   }
/*      */   
/*      */   public void setyEntete(int yEntete) {
/* 1088 */     this.yEntete = yEntete;
/*      */   }
/*      */   
/*      */   public void setZoom(double zoom) {
/* 1092 */     this.zoom = zoom;
/*      */   }
/*      */   
/*      */   public void setAttMajuscule(boolean attMajuscule) {
/* 1096 */     this.attMajuscule = attMajuscule;
/*      */   }
/*      */   
/*      */   public void setDecalCompose(int decalCompose) {
/* 1100 */     this.decalCompose = decalCompose;
/*      */   }
/*      */   
/*      */   public void setPrkvisible(boolean prkvisible) {
/* 1104 */     this.prkvisible = prkvisible;
/*      */   }
/*      */   
/*      */   public void setNbUsedLibrairie(int nbUsedLibrairie) {
/* 1108 */     this.nbUsedLibrairie = nbUsedLibrairie;
/*      */   }
/*      */   
/*      */   public void setIdentifiant(String identifiant) {
/* 1112 */     this.identifiant = identifiant;
/*      */   }
/*      */   
/*      */   public void ajouterCopier(ArrayList<Historique> lhis) {
/* 1116 */     Historique h = Historique.getHistoriqueCopie();
/* 1117 */     Historique h1 = (Historique)lhis.get(lhis.size() - 1);
/* 1118 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur())) || (!h.getAction().equals(h1.getAction())))
/*      */     {
/* 1120 */       lhis.add(h);
/*      */     }
/*      */   }
/*      */   
/*      */   public ArrayList<Historique> copierHistoriques(ArrayList<Historique> lhis) {
/* 1125 */     ArrayList<Historique> l = new ArrayList();
/* 1126 */     for (int i = 0; i < lhis.size(); i++) {
/* 1127 */       l.add(((Historique)lhis.get(i)).copier());
/*      */     }
/* 1129 */     ajouterCopier(lhis);
/* 1130 */     return l;
/*      */   }
/*      */   
/*      */   public IhmRelation copier()
/*      */   {
/* 1135 */     IhmRelation2 ent = new IhmRelation2(getRelation().copier(), getX(), getY(), true);
/* 1136 */     ent.setClCadre2(getClCadre2());
/* 1137 */     ent.setClCadreTitre2(this.clCadreTitre2);
/* 1138 */     ent.setClDegradee(isClDegradee());
/*      */     
/* 1140 */     ent.setClFond2(this.clFond2);
/* 1141 */     ent.setClFondTitre2(this.clFondTitre2);
/* 1142 */     ent.setClLienActiver(this.clLienActiver);
/* 1143 */     ent.setClText2(this.clText2);
/* 1144 */     ent.setClTextType2(this.clTextType2);
/* 1145 */     ent.setClTextTitre2(this.clTextTitre2);
/* 1146 */     ent.setFont(getFont());
/* 1147 */     ent.setFontTitre(getFontTitre());
/* 1148 */     ent.fontNormal = Parametres.fontNormal;
/*      */     
/* 1150 */     ent.clSelected = Setting.clSelected2;
/* 1151 */     ent.aligne = "";
/* 1152 */     ent.aligneTitre = "";
/* 1153 */     ent.zoom = FormeInterneMCD.zoom;
/*      */     
/* 1155 */     ent.historique = new ArrayList();
/* 1156 */     ent.setHistorique(copierHistoriques(this.historique));
/*      */     
/* 1158 */     ent.setFontAttribut(this.fontAttribut);
/* 1159 */     ent.setFontType(this.fontType);
/* 1160 */     ent.setClAttributSelect(this.clAttributSelect);
/* 1161 */     ent.setAligneTitre(this.aligneTitre);
/* 1162 */     ent.setWidthMin(this.widthMin);
/* 1163 */     ent.setWidthMax(this.widthMax);
/* 1164 */     ent.setAlignerAttribut(this.alignerAttribut);
/* 1165 */     ent.setAlignerType(this.alignerType);
/* 1166 */     ent.setNbUsedLibrairie(this.nbUsedLibrairie);
/*      */     
/* 1168 */     return ent;
/*      */   }
/*      */   
/*      */   public void ajouterModification() {
/* 1172 */     Historique h = Historique.getHistoriqueModification();
/* 1173 */     Historique h1 = (Historique)this.historique.get(this.historique.size() - 1);
/* 1174 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur()))) {
/* 1175 */       getHistorique().add(h);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static IhmRelation2 parseIhmRelation(IhmRelation ent)
/*      */   {
/* 1182 */     Relation2 eee = Relation2.parseEntite(ent.getRelation());
/* 1183 */     IhmRelation2 e = new IhmRelation2(eee, ent.getX(), ent.getY(), ent.isVariable());
/*      */     
/* 1185 */     e.setOmbre(ent.isOmbre());
/* 1186 */     e.setClDegradee(ent.isClDegradee());
/*      */     
/* 1188 */     e.setClCadre2(IhmRelation.getClRelationCadre());
/* 1189 */     e.setClCadreTitre2(IhmRelation.getClRelationCadre());
/* 1190 */     e.setClFond2(IhmRelation.getClRelationFond());
/* 1191 */     e.setClFondTitre2(FormeInterneMCD.clRelationFond2);
/* 1192 */     e.setClText2(IhmRelation.getClString());
/* 1193 */     e.setClTextType2(IhmRelation.getClString());
/* 1194 */     e.setClTextTitre2(IhmRelation.getClString());
/*      */     
/* 1196 */     return e;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean isAfficherCodeAttribut2()
/*      */   {
/* 1202 */     return this.afficherCodeAttribut2;
/*      */   }
/*      */   
/*      */   public boolean isAfficherCodeEntite2() {
/* 1206 */     return this.afficherCodeEntite2;
/*      */   }
/*      */   
/*      */   public Attribut getAttributSelect2() {
/* 1210 */     return this.attributSelect2;
/*      */   }
/*      */   
/*      */   public String getAugmentation2() {
/* 1214 */     return this.augmentation2;
/*      */   }
/*      */   
/*      */   public boolean isAugmentationPrefix2() {
/* 1218 */     return this.augmentationPrefix2;
/*      */   }
/*      */   
/*      */   public String getCodeAttribut2() {
/* 1222 */     return this.codeAttribut2;
/*      */   }
/*      */   
/*      */   public String getCodeEntete2() {
/* 1226 */     return this.codeEntete2;
/*      */   }
/*      */   
/*      */   public String getCodeFin2() {
/* 1230 */     return this.codeFin2;
/*      */   }
/*      */   
/*      */   public String getCodeMethode2() {
/* 1234 */     return this.codeMethode2;
/*      */   }
/*      */   
/*      */   public ArrayList<AttributContrainte2> getListeCle2() {
/* 1238 */     return this.listeCle2;
/*      */   }
/*      */   
/*      */   public ArrayList<AttributContrainte2> getListeCleEtrangere2() {
/* 1242 */     return this.listeCleEtrangere2;
/*      */   }
/*      */   
/*      */   public ArrayList<AttributContrainte2> getListeIndex2() {
/* 1246 */     return this.listeIndex2;
/*      */   }
/*      */   
/*      */   public ArrayList<AttributContrainte2> getListeUnique2() {
/* 1250 */     return this.listeUnique2;
/*      */   }
/*      */   
/*      */   public boolean isMldGenerer2() {
/* 1254 */     return this.mldGenerer2;
/*      */   }
/*      */   
/*      */   public boolean isMldHeritageGenerer2() {
/* 1258 */     return this.mldHeritageGenerer2;
/*      */   }
/*      */   
/*      */   public String getOrigine2() {
/* 1262 */     return this.origine2;
/*      */   }
/*      */   
/*      */   public void setAfficherCodeAttribut2(boolean afficherCodeAttribut2) {
/* 1266 */     this.afficherCodeAttribut2 = afficherCodeAttribut2;
/*      */   }
/*      */   
/*      */   public void setAfficherCodeEntite2(boolean afficherCodeEntite2) {
/* 1270 */     this.afficherCodeEntite2 = afficherCodeEntite2;
/*      */   }
/*      */   
/*      */   public void setAttributSelect2(Attribut attributSelect2) {
/* 1274 */     this.attributSelect2 = attributSelect2;
/*      */   }
/*      */   
/*      */   public void setAugmentation2(String augmentation2) {
/* 1278 */     this.augmentation2 = augmentation2;
/*      */   }
/*      */   
/*      */   public void setAugmentationPrefix2(boolean augmentationPrefix2) {
/* 1282 */     this.augmentationPrefix2 = augmentationPrefix2;
/*      */   }
/*      */   
/*      */   public void setCodeAttribut2(String codeAttribut2) {
/* 1286 */     this.codeAttribut2 = codeAttribut2;
/*      */   }
/*      */   
/*      */   public void setCodeEntete2(String codeEntete2) {
/* 1290 */     this.codeEntete2 = codeEntete2;
/*      */   }
/*      */   
/*      */   public void setCodeFin2(String codeFin2) {
/* 1294 */     this.codeFin2 = codeFin2;
/*      */   }
/*      */   
/*      */   public void setCodeMethode2(String codeMethode) {
/* 1298 */     this.codeMethode2 = codeMethode;
/*      */   }
/*      */   
/*      */   public void setListeCle2(ArrayList<AttributContrainte2> listeCle2) {
/* 1302 */     this.listeCle2 = listeCle2;
/*      */   }
/*      */   
/*      */   public void setListeCleEtrangere2(ArrayList<AttributContrainte2> listeCleEtrangere2) {
/* 1306 */     this.listeCleEtrangere2 = listeCleEtrangere2;
/*      */   }
/*      */   
/*      */   public void setListeIndex2(ArrayList<AttributContrainte2> listeIndex2) {
/* 1310 */     this.listeIndex2 = listeIndex2;
/*      */   }
/*      */   
/*      */   public void setListeUnique2(ArrayList<AttributContrainte2> listeUnique2) {
/* 1314 */     this.listeUnique2 = listeUnique2;
/*      */   }
/*      */   
/*      */   public void setMldGenerer2(boolean mldGenerer2) {
/* 1318 */     this.mldGenerer2 = mldGenerer2;
/*      */   }
/*      */   
/*      */   public void setMldHeritageGenerer2(boolean mldHeritageGenerer2) {
/* 1322 */     this.mldHeritageGenerer2 = mldHeritageGenerer2;
/*      */   }
/*      */   
/*      */   public void setOrigine2(String origine2) {
/* 1326 */     this.origine2 = origine2;
/*      */   }
/*      */   
/*      */   public Color getColor(String color) {
/* 1330 */     return new Color(Integer.parseInt(color));
/*      */   }
/*      */   
/*      */   public String getColor(Color color) {
/* 1334 */     return color.getRGB() + "";
/*      */   }
/*      */   
/*      */   public boolean isAfficherCntCle2() {
/* 1338 */     return this.afficherCntCle2;
/*      */   }
/*      */   
/*      */   public boolean isAfficherCntCleEtrangere2() {
/* 1342 */     return this.afficherCntCleEtrangere2;
/*      */   }
/*      */   
/*      */   public boolean isAfficherCntIndex2() {
/* 1346 */     return this.afficherCntIndex2;
/*      */   }
/*      */   
/*      */   public boolean isAfficherCntUnique2() {
/* 1350 */     return this.afficherCntUnique2;
/*      */   }
/*      */   
/*      */   public void setAfficherCntCle2(boolean afficherCntCle2) {
/* 1354 */     this.afficherCntCle2 = afficherCntCle2;
/*      */   }
/*      */   
/*      */   public void setAfficherCntCleEtrangere2(boolean afficherCntCleEtrangere2) {
/* 1358 */     this.afficherCntCleEtrangere2 = afficherCntCleEtrangere2;
/*      */   }
/*      */   
/*      */   public void setAfficherCntIndex2(boolean afficherCntIndex2) {
/* 1362 */     this.afficherCntIndex2 = afficherCntIndex2;
/*      */   }
/*      */   
/*      */   public void setAfficherCntUnique2(boolean afficherCntUnique2) {
/* 1366 */     this.afficherCntUnique2 = afficherCntUnique2;
/*      */   }
/*      */   
/*      */   public Color getClTextTaille2() {
/* 1370 */     return this.clTextTaille2;
/*      */   }
/*      */   
/*      */   public Color getClTextTailleDec2() {
/* 1374 */     return this.clTextTailleDec2;
/*      */   }
/*      */   
/*      */   public void setClTextTaille2(Color clTextTaille2) {
/* 1378 */     this.clTextTaille2 = clTextTaille2;
/*      */   }
/*      */   
/*      */   public void setClTextTailleDec2(Color clTextTailleDec2) {
/* 1382 */     this.clTextTailleDec2 = clTextTailleDec2;
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmRelation2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */