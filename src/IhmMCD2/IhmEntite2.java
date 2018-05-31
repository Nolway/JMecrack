/*      */ package IhmMCD2;
/*      */ 
/*      */ import IhmMCD.IhmEntite;
/*      */ import Merise.Attribut;
/*      */ import Merise.Entite;
/*      */ import Merise2.Attribut2;
/*      */ import Merise2.AttributContrainte2;
/*      */ import Merise2.Entite2;
/*      */ import Merise2.Historique;
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
/*      */ import java.awt.Paint;
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
/*      */ public class IhmEntite2
/*      */   extends IhmEntite
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
/*      */   public Color clPrk;
/*      */   public String aligne;
/*      */   public String aligneTitre;
/*      */   public int xType;
/*      */   public int xCle;
/*      */   public double zoom;
/*      */   public ArrayList<Historique> historique;
/*      */   public String alignerAttribut;
/*      */   public String alignerType;
/*      */   public int widthMin;
/*      */   public int widthMax;
/*      */   public int xAttribut;
/*      */   public int hAttribut;
/*      */   public int yAttribut;
/*      */   public int yEntete;
/*      */   public int decalCompose;
/*      */   public double AttEspace;
/*      */   float epaisseur;
/*      */   boolean prkvisible;
/*      */   boolean prkImage;
/*      */   boolean attMajuscule;
/*      */   Color clOmbre;
/*      */   boolean arrondir;
/*   88 */   public Color clFillSelAttribut = new Color(175, 203, 229, 90);
/*   89 */   public Color clStrokeSelAttribut = Color.BLUE;
/*      */   
/*      */   public int nbUsedLibrairie;
/*      */   
/*      */   Attribut attributSelect2;
/*      */   
/*      */   ArrayList<AttributContrainte2> listeIndex2;
/*      */   
/*      */   ArrayList<AttributContrainte2> listeUnique2;
/*      */   
/*      */   ArrayList<AttributContrainte2> listeCle2;
/*      */   
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
/*      */   public IhmEntite2(Entite entite, int x, int y, boolean isvariable)
/*      */   {
/*  121 */     super(entite, x, y, false);
/*      */     
/*  123 */     this.clCadre2 = FormeInterneMCD.clEntiteCadre2;
/*  124 */     this.clFond2 = FormeInterneMCD.clEntiteFond2;
/*  125 */     this.clText2 = FormeInterneMCD.clEntiteText2;
/*  126 */     this.clTextType2 = FormeInterneMCD.clEntiteTextType2;
/*      */     
/*  128 */     this.clCadreTitre2 = FormeInterneMCD.clEntiteCadre2;
/*  129 */     this.clFondTitre2 = FormeInterneMCD.clEntiteFondTitre2;
/*  130 */     this.clTextTitre2 = FormeInterneMCD.clEntiteTextTitre2;
/*  131 */     this.clTextTaille2 = FormeInterneMCD.clEntiteTextTaille2;
/*  132 */     this.clTextTailleDec2 = FormeInterneMCD.clEntiteTextTailleDec2;
/*  133 */     this.clPrk = FormeInterneMCD.clPrk2;
/*      */     
/*  135 */     this.clLienActiver = FormeInterneMCD.clLienActiver2;
/*      */     
/*  137 */     this.font = Parametres.fontGras;
/*  138 */     this.fontTitre = Parametres.fontGras;
/*  139 */     this.fontNormal = Parametres.fontNormal;
/*      */     
/*  141 */     this.clSelected = FormeInterneMCD.clSelected;
/*  142 */     this.arrondir = FormeInterneMCD.arrondirEntite2;
/*      */     
/*  144 */     this.aligne = "";
/*  145 */     this.aligneTitre = "";
/*  146 */     this.zoom = FormeInterneMCD.zoom;
/*      */     
/*  148 */     this.historique = new ArrayList();
/*  149 */     this.historique.add(Historique.getHistoriqueCreation());
/*  150 */     this.decalCompose = 14;
/*      */     
/*  152 */     this.AttEspace = FormeInterneMCD.interLigne2;
/*  153 */     this.epaisseur = FormeInterneMCD.traitEntiteRelation2;
/*  154 */     this.prkvisible = FormeInterneMCD.afficherPrk2;
/*  155 */     this.prkImage = FormeInterneMCD.afficherPrkImage2;
/*  156 */     this.attMajuscule = FormeInterneMCD.typeMajuscule2;
/*  157 */     setVariable(FormeInterneMCD.afficheType2);
/*      */     
/*  159 */     this.clOmbre = FormeInterneMCD.clOmbre2;
/*  160 */     setOmbre(FormeInterneMCD.isOmbree2);
/*  161 */     setClDegradee(FormeInterneMCD.isDegradee2);
/*  162 */     this.nbUsedLibrairie = 0;
/*      */     
/*      */ 
/*  165 */     this.attributSelect2 = null;
/*  166 */     this.listeIndex2 = new ArrayList();
/*  167 */     this.listeUnique2 = new ArrayList();
/*  168 */     this.listeCle2 = new ArrayList();
/*  169 */     this.listeCleEtrangere2 = new ArrayList();
/*      */     
/*  171 */     this.codeEntete2 = "";
/*  172 */     this.codeAttribut2 = "";
/*  173 */     this.codeMethode2 = "";
/*  174 */     this.codeFin2 = "";
/*      */     
/*  176 */     this.augmentation2 = "";
/*  177 */     this.augmentationPrefix2 = false;
/*  178 */     this.mldGenerer2 = true;
/*  179 */     this.afficherCodeEntite2 = false;
/*  180 */     this.afficherCodeAttribut2 = false;
/*  181 */     this.origine2 = "ENTITE";
/*  182 */     this.mldHeritageGenerer2 = true;
/*      */     
/*  184 */     this.afficherCntCle2 = false;
/*  185 */     this.afficherCntCleEtrangere2 = false;
/*  186 */     this.afficherCntIndex2 = false;
/*  187 */     this.afficherCntUnique2 = false;
/*  188 */     this.identifiant = "";
/*      */   }
/*      */   
/*      */ 
/*      */   public void paint(Graphics g)
/*      */   {
/*  194 */     Graphics2D g2d = (Graphics2D)g;
/*  195 */     g2d = (Graphics2D)g.create();
/*      */     
/*  197 */     Stroke stro = g2d.getStroke();
/*  198 */     float[] style = { 5.0F, 0.0F };
/*  199 */     g2d.setStroke(new BasicStroke(this.epaisseur, 0, 0, 10.0F, style, 0.0F));
/*  200 */     ajousterTaille(g2d);
/*  201 */     dessinerOmbre(g2d);
/*  202 */     dessinerFondEntite(g2d);
/*  203 */     dessinerEntete(g2d);
/*      */     
/*  205 */     ecrireAttributs(g2d);
/*  206 */     if (isSelected()) dessinerSelected(g2d);
/*  207 */     g2d.setStroke(stro);
/*      */   }
/*      */   
/*      */   private void dessinerOmbre(Graphics2D g)
/*      */   {
/*  212 */     if (!isOmbre()) return;
/*  213 */     Color clgard = g.getColor();
/*  214 */     g.setColor(this.clOmbre);
/*  215 */     if (this.arrondir) {
/*  216 */       RoundRectangle2D rRect = new RoundRectangle2D.Double(getX() + 5, getY() + 3, getWidth(), getHeight() + 2, 10.0D, 10.0D);
/*  217 */       g.fill(rRect);
/*      */     } else {
/*  219 */       g.fillRect(getX() + 5, getY() + 3, getWidth(), getHeight() + 3);
/*      */     }
/*  221 */     g.setColor(clgard);
/*      */   }
/*      */   
/*      */   private void dessinerPrk(Graphics2D g) {
/*  225 */     if (isAffcher()) {
/*  226 */       Color clgard = g.getColor();
/*  227 */       g.setColor(Color.GRAY);
/*  228 */       Graphics2D g2d = g;
/*  229 */       g.setColor(this.clPrk);
/*  230 */       int larg = g.getFontMetrics().stringWidth("KPrk");
/*  231 */       g.fillRect(getX() + 2, getY(), larg, getHeight() - 2);
/*  232 */       g.setColor(clgard);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean isAffcher() {
/*  237 */     if (isPrkvisible()) {
/*  238 */       for (int i = 0; i < getEntite().getListeAttributs().size(); i++) {
/*  239 */         if (((Attribut2)getEntite().getListeAttributs().get(i)).isAfficher()) return true;
/*      */       }
/*      */     }
/*  242 */     return false;
/*      */   }
/*      */   
/*      */   private void dessinerFondEntite(Graphics2D g)
/*      */   {
/*  247 */     Color clgard = g.getColor();
/*  248 */     g.setColor(Color.GRAY);
/*  249 */     Graphics2D g2d = g;
/*  250 */     g.setColor(this.clFond2);
/*  251 */     if (isClDegradee()) {
/*  252 */       g2d.setPaint(new GradientPaint(getX(), getY(), this.clFond2, getX() + getWidth(), getY() + getHeight(), Color.WHITE, true));
/*      */     }
/*  254 */     if (this.arrondir) {
/*  255 */       RoundRectangle2D rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), 10.0D, 10.0D);
/*  256 */       g.fill(rRect);
/*      */       
/*  258 */       g.setColor(this.clCadre2);
/*  259 */       g.draw(rRect);
/*      */     } else {
/*  261 */       g.fillRect(getX(), getY(), getWidth(), getHeight());
/*      */       
/*  263 */       g.setColor(this.clCadre2);
/*  264 */       g.drawRect(getX(), getY(), getWidth(), getHeight());
/*      */     }
/*  266 */     g.setColor(clgard);
/*      */   }
/*      */   
/*      */   private void dessinerEntete(Graphics2D g) {
/*  270 */     Color clgard = g.getColor();
/*  271 */     Graphics2D g2d = g;
/*  272 */     int h = g.getFontMetrics().getHeight();
/*  273 */     int ht = h + h / 2;
/*  274 */     Paint p = g.getPaint();
/*      */     
/*  276 */     g.setColor(this.clFondTitre2);
/*  277 */     if (isClDegradee())
/*      */     {
/*  279 */       g2d.setPaint(new GradientPaint(getX(), getY(), getClFondTitre2(), getX() + getWidth(), getY() + ht, Color.WHITE, true));
/*      */     }
/*  281 */     if (this.arrondir) {
/*  282 */       RoundRectangle2D rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), ht, 10.0D, 10.0D);
/*  283 */       g.fill(rRect);
/*  284 */       g.setColor(this.clCadreTitre2);
/*  285 */       g.draw(rRect);
/*  286 */       g.setColor(this.clFondTitre2);
/*  287 */       if (isClDegradee()) {
/*  288 */         g.setPaint(p);
/*  289 */         g.setColor(this.clFondTitre2);
/*  290 */         g.fillRect(getX(), getY() + ht - 3, 8, 3);
/*  291 */         g.setColor(Color.WHITE);
/*  292 */         g.fillRect(getX() + getWidth() - 8, getY() + ht - 3, 8, 3);
/*      */       } else {
/*  294 */         g.setColor(this.clFondTitre2);
/*  295 */         g.fillRect(getX(), getY() + ht - 3, 8, 3);
/*  296 */         g.fillRect(getX() + getWidth() - 8, getY() + ht - 3, 8, 3);
/*      */       }
/*  298 */       rRect = new RoundRectangle2D.Double(getX(), getY(), getWidth(), getHeight(), 10.0D, 10.0D);
/*  299 */       g.setColor(this.clCadreTitre2);
/*  300 */       g.draw(rRect);
/*  301 */       g.drawLine(getX(), getY() + ht, getX() + getWidth(), getY() + ht);
/*      */     }
/*      */     else {
/*  304 */       g2d.fillRect(getX(), getY(), getWidth(), ht);
/*  305 */       g.setColor(this.clCadreTitre2);
/*  306 */       g2d.drawRect(getX(), getY(), getWidth(), ht);
/*      */     }
/*  308 */     g.setFont(getFontTitre());
/*  309 */     g.setColor(this.clTextTitre2);
/*  310 */     String s = getEntite().getNom() + getHistrosation();
/*  311 */     g.drawString(s, getX() + (getWidth() - g.getFontMetrics().stringWidth(s)) / 2, getY() + h);
/*  312 */     g.setColor(clgard);
/*      */   }
/*      */   
/*      */   private void dessinerSelected(Graphics2D g)
/*      */   {
/*  317 */     Color clgard = g.getColor();
/*  318 */     g.setColor(this.clSelected);
/*  319 */     Stroke stro = g.getStroke();
/*  320 */     if (Setting.agraverSelection2) {
/*  321 */       g.setColor(this.clLienActiver);
/*  322 */       g.drawRect(getX() - 3, getY() - 3, getWidth() + 6, getHeight() + 6);
/*  323 */       float[] style = { 5.0F, 0.0F };
/*  324 */       g.setStroke(new BasicStroke(4.0F, 0, 0, 10.0F, style, 0.0F));
/*      */       
/*  326 */       g.setColor(this.clSelected);
/*      */     }
/*  328 */     g.drawRect(getX(), getY(), getWidth(), getHeight());
/*      */     
/*  330 */     g.setColor(Color.BLACK);
/*  331 */     g.fillRect(getX() - 1, getY() - 1, 4, 4);
/*  332 */     g.fillRect(getX() - 1, getY() - 2 + getHeight(), 4, 4);
/*  333 */     g.fillRect(getX() - 1 + getWidth(), getY() - 1, 4, 4);
/*  334 */     g.fillRect(getX() - 1 + getWidth(), getY() - 2 + getHeight(), 4, 4);
/*      */     
/*  336 */     g.fillRect(getCentreX() - 1, getY() + getHeight() - 1, 4, 4);
/*  337 */     g.fillRect(getCentreX() - 1, getY() - 1, 4, 4);
/*      */     
/*  339 */     g.fillRect(getX() - 1, getY() + getHeight() / 2 - 1, 4, 4);
/*  340 */     g.fillRect(getX() + getWidth() - 1, getY() + getHeight() / 2 - 1, 4, 4);
/*      */     
/*  342 */     g.setColor(clgard);
/*  343 */     g.setStroke(stro);
/*      */   }
/*      */   
/*      */   private String getTypeAttribut(Attribut2 att) {
/*  347 */     if (att == null) return "";
/*  348 */     String t = "";
/*  349 */     if (att.getType().trim().length() == 0) return "";
/*  350 */     if (att.getType().toUpperCase().equals("AUTO_INCREMENT")) {
/*  351 */       t = att.getType();
/*  352 */       if (att.isUnSigned()) t = "+" + t;
/*  353 */       return t;
/*      */     }
/*      */     
/*  356 */     if ((att.getLongueur() < 0) && (att.getLongDecimale() < 0)) {
/*  357 */       t = att.getType();
/*  358 */       if (att.isUnSigned()) t = "+" + t;
/*  359 */       return t;
/*      */     }
/*  361 */     if (att.getLongueur() < 0) {
/*  362 */       t = att.getType();
/*  363 */       if (att.isUnSigned()) t = "+" + t;
/*  364 */       return t + " (0," + att.getLongDecimale() + ")";
/*      */     }
/*  366 */     if (att.getLongDecimale() > 0) {
/*  367 */       t = att.getType();
/*  368 */       if (att.isUnSigned()) t = "+" + t;
/*  369 */       return t + " (" + att.getLongueur() + "," + att.getLongDecimale() + ")";
/*      */     }
/*  371 */     t = att.getType();
/*  372 */     if (att.isUnSigned()) t = "+" + t;
/*  373 */     return t + " (" + att.getLongueur() + ")";
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private String getTypeAttributSansTaille(Attribut2 att)
/*      */   {
/*  381 */     if (att == null) return "";
/*  382 */     String t = "";
/*  383 */     if (att.getType().trim().length() == 0) return "";
/*  384 */     if (att.getType().toUpperCase().equals("AUTO_INCREMENT")) {
/*  385 */       t = att.getType();
/*  386 */       if (att.isUnSigned()) t = "+" + t;
/*  387 */       return t;
/*      */     }
/*  389 */     t = att.getType();
/*  390 */     if (att.isUnSigned()) t = "+" + t;
/*  391 */     return t;
/*      */   }
/*      */   
/*      */ 
/*      */   private int getWidthType(Graphics2D g)
/*      */   {
/*  397 */     int w = 0;
/*  398 */     int wMax = 0;
/*  399 */     int nb = getEntite().getListeAttributs().size();
/*  400 */     for (int i = 0; i < nb; i++) {
/*  401 */       if (((Attribut2)getEntite().getListeAttributs().get(i)).isAfficher()) {
/*  402 */         w = g.getFontMetrics().stringWidth(getTypeAttribut((Attribut2)getEntite().getListeAttributs().get(i)));
/*  403 */         if (this.attMajuscule) {
/*  404 */           w = g.getFontMetrics().stringWidth(getTypeAttribut((Attribut2)getEntite().getListeAttributs().get(i)).toUpperCase());
/*      */         }
/*  406 */         if (w > wMax) {
/*  407 */           wMax = w + 4;
/*      */         }
/*      */         
/*  410 */         if (((Attribut2)getEntite().getListeAttributs().get(i)).getListeAttributs().size() > 0) {
/*  411 */           wMax = getWidthMaxType(g, (Attribut2)getEntite().getListeAttributs().get(i), wMax);
/*      */         }
/*      */       }
/*      */     }
/*  415 */     return wMax;
/*      */   }
/*      */   
/*      */ 
/*      */   private int getWidthMaxType(Graphics2D g, Attribut2 att, int max)
/*      */   {
/*  421 */     int nb = att.getListeAttributs().size();
/*  422 */     for (int i = 0; i < nb; i++) {
/*  423 */       if (((Attribut2)att.getListeAttributs().get(i)).isAfficher()) {
/*  424 */         int w = g.getFontMetrics().stringWidth(getTypeAttribut((Attribut2)att.getListeAttributs().get(i)));
/*  425 */         if (this.attMajuscule) {
/*  426 */           w = g.getFontMetrics().stringWidth(getTypeAttribut((Attribut2)att.getListeAttributs().get(i)).toUpperCase());
/*      */         }
/*  428 */         if (w > max) {
/*  429 */           max = w + 4;
/*      */         }
/*  431 */         max = getWidthMaxType(g, (Attribut2)att.getListeAttributs().get(i), max);
/*      */       }
/*      */     }
/*  434 */     return max;
/*      */   }
/*      */   
/*      */ 
/*      */   private int getWidthMaxSousAttribut(Graphics2D g, Attribut2 att, int max, int profondeur)
/*      */   {
/*  440 */     profondeur++;
/*  441 */     int nb = att.getListeAttributs().size();
/*  442 */     String pk = Parametres.Cle;
/*  443 */     for (int i = 0; i < nb; i++) {
/*  444 */       if (((Attribut2)att.getListeAttributs().get(i)).isAfficher()) {
/*  445 */         String s = ((Attribut2)att.getListeAttributs().get(i)).getNomHistrosation();
/*  446 */         int w; if (((Attribut)att.getListeAttributs().get(i)).getKey().equals(pk)) {
/*  447 */           g.setFont(this.font);
/*  448 */           w = g.getFontMetrics().stringWidth(s);
/*  449 */           g.setFont(this.fontNormal);
/*  450 */         } else { w = g.getFontMetrics().stringWidth(s); }
/*  451 */         if (w + this.decalCompose * profondeur > max) {
/*  452 */           max = w + this.decalCompose * profondeur;
/*      */         }
/*  454 */         max = getWidthMaxSousAttribut(g, (Attribut2)att.getListeAttributs().get(i), max, profondeur);
/*      */       }
/*      */     }
/*      */     
/*  458 */     return max;
/*      */   }
/*      */   
/*      */   private int getWidthNomAttribut(Graphics2D g)
/*      */   {
/*  463 */     int w = 0;
/*  464 */     int wMax = 0;
/*      */     
/*  466 */     String pk = Parametres.Cle;
/*  467 */     int nb = getEntite().getListeAttributs().size();
/*  468 */     for (int i = 0; i < nb; i++) {
/*  469 */       if (((Attribut2)getEntite().getListeAttributs().get(i)).isAfficher()) {
/*  470 */         String s = ((Attribut2)getEntite().getListeAttributs().get(i)).getNomHistrosation();
/*  471 */         if (((Attribut)getEntite().getListeAttributs().get(i)).getKey().equals(pk)) {
/*  472 */           g.setFont(this.font);
/*  473 */           w = g.getFontMetrics().stringWidth(s);
/*  474 */           g.setFont(this.fontNormal);
/*  475 */         } else { w = g.getFontMetrics().stringWidth(s); }
/*  476 */         if (w > wMax) {
/*  477 */           wMax = w;
/*      */         }
/*  479 */         if (((Attribut2)getEntite().getListeAttributs().get(i)).getListeAttributs().size() > 0) {
/*  480 */           wMax = getWidthMaxSousAttribut(g, (Attribut2)getEntite().getListeAttributs().get(i), wMax, 0);
/*      */         }
/*      */       }
/*      */     }
/*  484 */     return wMax;
/*      */   }
/*      */   
/*      */   private String getHistrosation()
/*      */   {
/*  489 */     Entite2 ent = (Entite2)getEntite();
/*  490 */     if (ent.getHistorisation().length() == 0) return "";
/*  491 */     return "  [ " + ent.getHistorisation() + " ]";
/*      */   }
/*      */   
/*      */   private int calculerWidthEntite(Graphics2D g) {
/*  495 */     String s = getHistrosation();
/*  496 */     int wEntete = g.getFontMetrics().stringWidth(getEntite().getNom() + s + "MESS");
/*  497 */     int wAtt = getWidthNomAttribut(g);
/*  498 */     int wType = 0;
/*  499 */     int wPrk = wPrk = g.getFontMetrics().stringWidth("H");
/*  500 */     if (isVariable()) wType = getWidthType(g);
/*  501 */     if (this.prkvisible) wPrk = g.getFontMetrics().stringWidth("HHHH");
/*  502 */     int wtotal = g.getFontMetrics().stringWidth("H");
/*  503 */     this.xType = (wtotal + wAtt + wPrk);
/*  504 */     wtotal = wtotal + wAtt + wType + wPrk;
/*  505 */     if (wtotal < wEntete) {
/*  506 */       wtotal = wEntete;
/*      */     } else {
/*  508 */       wtotal += g.getFontMetrics().stringWidth("HH");
/*      */     }
/*  510 */     if (!this.prkvisible) {
/*  511 */       this.xType += 3;
/*      */     }
/*  513 */     if (!isVariable()) {
/*  514 */       wtotal += 8;
/*      */     }
/*  516 */     return wtotal - g.getFontMetrics().stringWidth("H");
/*      */   }
/*      */   
/*      */   private int calculerHeightEntite(Graphics2D g) {
/*  520 */     int h = g.getFontMetrics().getHeight();
/*  521 */     int hauteur = 0;
/*  522 */     int nbAfficher = 0;
/*      */     
/*  524 */     int nb = getEntite().getListeAttributs().size();
/*  525 */     if (nb == 0) return (int)(h * 2.5D);
/*  526 */     for (int i = 0; i < nb; i++) {
/*  527 */       Attribut2 att = (Attribut2)getEntite().getListeAttributs().get(i);
/*  528 */       if (att.isAfficher()) {
/*  529 */         int nbAtt = nbAttributProfondeur(att, att.getListeAttributs().size());
/*  530 */         hauteur = (int)((1 + nbAtt) * this.AttEspace * h) + hauteur;
/*  531 */         nbAfficher++;
/*      */       }
/*      */     }
/*  534 */     if (nbAfficher < nb) {
/*  535 */       hauteur += 1 * h;
/*      */     }
/*  537 */     if (nb > 0) {
/*  538 */       hauteur += 2 * h;
/*      */     }
/*      */     
/*  541 */     return hauteur + h;
/*      */   }
/*      */   
/*      */   public void ajousterTaille(Graphics2D g) {
/*  545 */     g.setFont(this.fontTitre);
/*  546 */     int h = calculerHeightEntite(g);
/*  547 */     int w = calculerWidthEntite(g);
/*  548 */     redimentionner(getX(), getY(), w, h);
/*      */   }
/*      */   
/*      */   private void drawTailleType(Attribut2 att, Graphics2D g, int x, int y) {
/*  552 */     String car = getTypeAttribut(att);
/*      */     
/*  554 */     if (!isDrawTaille(car)) { return;
/*      */     }
/*  556 */     String type = att.getType();
/*  557 */     if (att.isUnSigned()) { type = "+" + type;
/*      */     }
/*  559 */     if (this.attMajuscule) {
/*  560 */       type = type.toUpperCase();
/*      */     }
/*      */     
/*  563 */     type = type + " ";
/*      */     
/*  565 */     int wtype = g.getFontMetrics().stringWidth(type);
/*  566 */     g.drawString("(", x + wtype, y);
/*  567 */     Color cl = g.getColor();
/*      */     
/*  569 */     type = type + "(";
/*  570 */     wtype = g.getFontMetrics().stringWidth(type);
/*  571 */     int t = att.getLongueur();
/*  572 */     if (t < 0) { t = 0;
/*      */     }
/*  574 */     g.setColor(getColor(att.getClTaille()));
/*  575 */     g.drawString(t + "", x + wtype, y);
/*      */     
/*  577 */     if (att.getLongDecimale() > -1) {
/*  578 */       type = type + t;
/*  579 */       wtype = g.getFontMetrics().stringWidth(type);
/*  580 */       g.setColor(cl);
/*  581 */       g.drawString(",", x + wtype, y);
/*  582 */       type = type + ",";
/*  583 */       wtype = g.getFontMetrics().stringWidth(type);
/*  584 */       t = att.getLongDecimale();
/*  585 */       g.setColor(getColor(att.getClTailleDecimale()));
/*  586 */       g.drawString(t + "", x + wtype, y);
/*  587 */       type = type + t;
/*  588 */       wtype = g.getFontMetrics().stringWidth(type);
/*  589 */       g.setColor(cl);
/*  590 */       g.drawString(")", x + wtype, y);
/*      */     } else {
/*  592 */       type = type + t;
/*  593 */       wtype = g.getFontMetrics().stringWidth(type);
/*  594 */       g.setColor(cl);
/*  595 */       g.drawString(")", x + wtype, y);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean isDrawTaille(String car)
/*      */   {
/*  602 */     if ((car.contains("(")) && (car.contains(")"))) return true;
/*  603 */     return false;
/*      */   }
/*      */   
/*      */   private void ecrireAttribut(Graphics2D g, Attribut2 att, int x, int y, int profondeur)
/*      */   {
/*  608 */     int dec = g.getFontMetrics().stringWidth("MeSs");
/*  609 */     if (!this.prkvisible) {
/*  610 */       dec = 4 + g.getFontMetrics().stringWidth("H");
/*      */     }
/*  612 */     dec += this.decalCompose * profondeur;
/*  613 */     g.setColor(this.clText2);
/*  614 */     if (isVariable()) {
/*  615 */       g.setFont(this.fontNormal);
/*  616 */       if (this.prkvisible) {
/*  617 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Cle))
/*  618 */           if (this.prkImage) {
/*  619 */             int h = g.getFontMetrics().getHeight();
/*  620 */             g.drawImage(Parametres.imageCle, getX() + 6, y - h + 2, h + 3, h, null);
/*  621 */           } else { g.drawString(" Id", getX() + 3, y);
/*      */           }
/*  623 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Index))
/*  624 */           if (this.prkImage) {
/*  625 */             int h = g.getFontMetrics().getHeight();
/*  626 */             g.drawImage(Parametres.imageCleIndex, getX() + 6, y - h + 2, h + 3, h, null);
/*  627 */           } else { g.drawString("Idx", getX() + 3, y);
/*      */           }
/*  629 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Unique)) {
/*  630 */           if (this.prkImage) {
/*  631 */             int h = g.getFontMetrics().getHeight();
/*  632 */             g.drawImage(Parametres.imageCleUnique, getX() + 6, y - h + 2, h + 3, h, null);
/*  633 */           } else { g.drawString("IdA", getX() + 3, y);
/*      */           }
/*      */         }
/*      */       }
/*  637 */       if (att.getKey().equals(Parametres.Cle)) {
/*  638 */         g.setFont(this.font);
/*  639 */         g.setColor(getColor(att.getClNom()));
/*  640 */         g.drawString(att.getNomHistrosation(), x + dec, y);
/*  641 */         if (this.epaisseur > 1.0F) {
/*  642 */           Stroke stro = g.getStroke();
/*  643 */           float[] style = { 20.0F, 0.0F };
/*  644 */           g.setStroke(new BasicStroke(1.0F, 0, 0, 10.0F, style, 0.0F));
/*  645 */           g.drawLine(getX() + dec, y + 2, getX() + dec + g.getFontMetrics().stringWidth(att.getNomHistrosation()), y + 2);
/*  646 */           g.setStroke(stro);
/*      */         }
/*      */         else {
/*  649 */           g.drawLine(getX() + dec, y + 2, getX() + dec + g.getFontMetrics().stringWidth(att.getNomHistrosation()), y + 2);
/*      */         }
/*  651 */         g.setFont(this.fontNormal);
/*      */       } else {
/*  653 */         g.setColor(getColor(att.getClNom()));
/*  654 */         if (att.getListeAttributs().size() > 0) g.setFont(Parametres.fontItalic12);
/*  655 */         g.drawString(att.getNomHistrosation(), x + dec, y);
/*      */       }
/*      */       
/*  658 */       g.setColor(getColor(att.getClType()));
/*  659 */       if (att.getListeAttributs().size() == 0) {
/*  660 */         if (this.attMajuscule) {
/*  661 */           g.drawString(getTypeAttributSansTaille(att).toUpperCase(), this.xType + x, y);
/*      */         } else {
/*  663 */           g.drawString(getTypeAttributSansTaille(att), this.xType + x, y);
/*      */         }
/*  665 */         drawTailleType(att, g, this.xType + x, y);
/*      */       }
/*      */     } else {
/*  668 */       g.setFont(this.fontNormal);
/*  669 */       if (this.prkvisible) {
/*  670 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Cle)) {
/*  671 */           if (this.prkImage) {
/*  672 */             int h = g.getFontMetrics().getHeight();
/*  673 */             g.drawImage(Parametres.imageCle, getX() + 6, y - h + 2, h + 3, h, null);
/*  674 */           } else { g.drawString(" Id", getX() + 3, y);
/*      */           }
/*      */         }
/*  677 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Index))
/*  678 */           if (this.prkImage) {
/*  679 */             int h = g.getFontMetrics().getHeight();
/*  680 */             g.drawImage(Parametres.imageCleIndex, getX() + 6, y - h + 2, h + 3, h, null);
/*  681 */           } else { g.drawString("Idx", getX() + 3, y);
/*      */           }
/*  683 */         if (att.getKey().trim().toUpperCase().equals(Parametres.Unique)) {
/*  684 */           if (this.prkImage) {
/*  685 */             int h = g.getFontMetrics().getHeight();
/*  686 */             g.drawImage(Parametres.imageCleUnique, getX() + 6, y - h + 2, h + 3, h, null);
/*  687 */           } else { g.drawString("IdA", getX() + 3, y);
/*      */           }
/*      */         }
/*      */       }
/*  691 */       if (att.getKey().equals(Parametres.Cle)) {
/*  692 */         g.setFont(this.font);
/*  693 */         g.setColor(getColor(att.getClNom()));
/*  694 */         g.drawString(att.getNomHistrosation(), x + dec, y);
/*  695 */         if (this.epaisseur > 1.0F) {
/*  696 */           Stroke stro = g.getStroke();
/*  697 */           float[] style = { 20.0F, 0.0F };
/*  698 */           g.setStroke(new BasicStroke(1.0F, 0, 0, 10.0F, style, 0.0F));
/*  699 */           g.drawLine(getX() + dec, y + 2, getX() + dec + g.getFontMetrics().stringWidth(att.getNomHistrosation()), y + 2);
/*  700 */           g.setStroke(stro);
/*      */         } else {
/*  702 */           g.drawLine(getX() + dec, y + 2, getX() + dec + g.getFontMetrics().stringWidth(att.getNomHistrosation()), y + 2);
/*      */         }
/*  704 */         g.setFont(this.fontNormal);
/*      */       } else {
/*  706 */         g.setColor(getColor(att.getClNom()));
/*  707 */         if (att.getListeAttributs().size() > 0) g.setFont(Parametres.fontItalic12);
/*  708 */         g.drawString(att.getNomHistrosation(), x + dec, y);
/*      */       }
/*      */     }
/*  711 */     if (att.getListeAttributs().size() > 0) {
/*  712 */       profondeur++;
/*  713 */       int y1 = y + 4;
/*  714 */       int h = g.getFontMetrics().getHeight();
/*  715 */       for (int i = 0; i < att.getListeAttributs().size(); i++) {
/*  716 */         y += (int)(h * this.AttEspace);
/*  717 */         ecrireAttribut(g, (Attribut2)att.getListeAttributs().get(i), x, y, profondeur);
/*  718 */         int nbAtt = nbAttributProfondeur((Attribut2)att.getListeAttributs().get(i), ((Attribut2)att.getListeAttributs().get(i)).getListeAttributs().size());
/*  719 */         y += (int)(h * (nbAtt * this.AttEspace));
/*      */       }
/*      */       
/*  722 */       int y2 = y + 1;
/*  723 */       g.setColor(this.clText2);
/*  724 */       if (this.epaisseur > 1.0F) {
/*  725 */         Stroke stro = g.getStroke();
/*  726 */         float[] style = { 20.0F, 0.0F };
/*  727 */         g.setStroke(new BasicStroke(1.0F, 0, 0, 10.0F, style, 0.0F));
/*      */         
/*  729 */         g.drawLine(x + dec + 8, y1 + 1, x + dec + 8, y2 + 1);
/*  730 */         g.drawLine(x + dec + 8, y2 + 1, x + dec + 15, y2 + 1);
/*  731 */         g.setStroke(stro);
/*      */       } else {
/*  733 */         g.drawLine(x + dec + 8, y1 + 1, x + dec + 8, y2 + 1);
/*  734 */         g.drawLine(x + dec + 8, y2 + 1, x + dec + 15, y2 + 1);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void ecrireAttributs(Graphics2D g) {
/*  740 */     int nbAfficher = 0;
/*  741 */     if (getEntite().getListeAttributs() != null)
/*      */     {
/*  743 */       int nb = getEntite().getListeAttributs().size();
/*  744 */       int y = g.getFontMetrics().getHeight() * 3;
/*  745 */       int i = 0;
/*  746 */       int h = g.getFontMetrics().getHeight();
/*  747 */       this.yAttribut = y;
/*  748 */       this.hAttribut = h;
/*      */       
/*  750 */       while (i < nb) {
/*  751 */         if (((Attribut2)getEntite().getListeAttributs().get(i)).isAfficher()) {
/*  752 */           ecrireAttribut(g, (Attribut2)getEntite().getListeAttributs().get(i), getX(), getY() + y, 0);
/*  753 */           int nbAtt = nbAttributProfondeur((Attribut2)getEntite().getListeAttributs().get(i), ((Attribut2)getEntite().getListeAttributs().get(i)).getListeAttributs().size());
/*  754 */           y += (int)(h * (this.AttEspace * (nbAtt + 1)));
/*      */           
/*      */ 
/*  757 */           nbAfficher++;
/*      */         }
/*  759 */         i++;
/*      */       }
/*  761 */       if (nbAfficher < getEntite().getListeAttributs().size()) {
/*  762 */         ecrireAttribut(g, "...", getX(), getY() + y);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void ecrireAttribut(Graphics g, String att, int x, int y) {
/*  768 */     int dec = g.getFontMetrics().stringWidth("MeSs");
/*  769 */     g.setColor(this.clText2);
/*  770 */     if (!this.prkvisible) {
/*  771 */       dec = 3;
/*      */     }
/*  773 */     g.drawString(att, x + dec, y);
/*      */   }
/*      */   
/*      */   private int nbAttributProfondeur(Attribut2 att, int nb)
/*      */   {
/*  778 */     if (att.getListeAttributs().size() == 0) { return 0;
/*      */     }
/*  780 */     for (int i = 0; i < att.getListeAttributs().size(); i++) {
/*  781 */       nb += nbAttributProfondeur((Attribut2)att.getListeAttributs().get(i), ((Attribut2)att.getListeAttributs().get(i)).getListeAttributs().size());
/*      */     }
/*  783 */     return nb;
/*      */   }
/*      */   
/*      */   public String getAligne()
/*      */   {
/*  788 */     return this.aligne;
/*      */   }
/*      */   
/*      */   public String getAligneTitre() {
/*  792 */     return this.aligneTitre;
/*      */   }
/*      */   
/*      */   private int getXYAttributSel(int yS) {
/*  796 */     int y = this.yAttribut;
/*  797 */     int i = 0;
/*  798 */     if ((yS < y + 5) && (yS > y - this.hAttribut)) return y - this.hAttribut - 5;
/*  799 */     int h = this.hAttribut;
/*  800 */     y += (int)(h * (this.AttEspace * (i + 1)));
/*  801 */     while (y < getX() + getHeight()) {
/*  802 */       if ((yS < y + 5) && (yS > y - this.hAttribut)) return y - this.hAttribut - 5;
/*  803 */       y += (int)(h * (this.AttEspace * (i + 1)));
/*      */     }
/*  805 */     return y;
/*      */   }
/*      */   
/*      */ 
/*      */   public void dessinerCadreSelect(Graphics g, int y)
/*      */   {
/*  811 */     int y0 = getXYAttributSel(y);
/*  812 */     int w = getWidth();
/*  813 */     int h = this.hAttribut + 10;
/*  814 */     int x0 = getX();
/*      */     
/*  816 */     Graphics2D g2 = (Graphics2D)g;
/*  817 */     Rectangle2D rec = new Rectangle2D.Double(x0, y0, w, h);
/*  818 */     g2.setStroke(new BasicStroke(1.0F));
/*  819 */     g2.setPaint(this.clFillSelAttribut);
/*  820 */     g2.fill(rec);
/*  821 */     g2.setPaint(this.clStrokeSelAttribut);
/*  822 */     g2.draw(rec);
/*      */   }
/*      */   
/*      */   public Color getClCadre2()
/*      */   {
/*  827 */     return this.clCadre2;
/*      */   }
/*      */   
/*      */   public Color getClTextType2() {
/*  831 */     return this.clTextType2;
/*      */   }
/*      */   
/*      */   public Color getClPrk() {
/*  835 */     return this.clPrk;
/*      */   }
/*      */   
/*      */   public Color getClCadreTitre2() {
/*  839 */     return this.clCadreTitre2;
/*      */   }
/*      */   
/*      */   public Color getClFond2()
/*      */   {
/*  844 */     return this.clFond2;
/*      */   }
/*      */   
/*      */   public Color getClFondTitre2()
/*      */   {
/*  849 */     return this.clFondTitre2;
/*      */   }
/*      */   
/*      */   public Color getClText2() {
/*  853 */     return this.clText2;
/*      */   }
/*      */   
/*      */   public Color getClLienActiver() {
/*  857 */     return this.clLienActiver;
/*      */   }
/*      */   
/*      */   public int getxCle() {
/*  861 */     return this.xCle;
/*      */   }
/*      */   
/*      */   public int getxType() {
/*  865 */     return this.xType;
/*      */   }
/*      */   
/*      */   public Color getClTextTitre2() {
/*  869 */     return this.clTextTitre2;
/*      */   }
/*      */   
/*      */   public Font getFont() {
/*  873 */     return this.font;
/*      */   }
/*      */   
/*      */   public Font getFontTitre() {
/*  877 */     return this.fontTitre;
/*      */   }
/*      */   
/*      */   public double getAttEspace() {
/*  881 */     return this.AttEspace;
/*      */   }
/*      */   
/*      */   public float getEpaisseur() {
/*  885 */     return this.epaisseur;
/*      */   }
/*      */   
/*      */   public ArrayList<Historique> getHistorique() {
/*  889 */     return this.historique;
/*      */   }
/*      */   
/*      */   public String getAlignerAttribut() {
/*  893 */     return this.alignerAttribut;
/*      */   }
/*      */   
/*      */   public String getAlignerType() {
/*  897 */     return this.alignerType;
/*      */   }
/*      */   
/*      */   public Color getClAttributSelect() {
/*  901 */     return this.clAttributSelect;
/*      */   }
/*      */   
/*      */   public Color getClSelected() {
/*  905 */     return this.clSelected;
/*      */   }
/*      */   
/*      */   public Font getFontAttribut() {
/*  909 */     return this.fontAttribut;
/*      */   }
/*      */   
/*      */   public Font getFontNormal() {
/*  913 */     return this.fontNormal;
/*      */   }
/*      */   
/*      */   public Font getFontType() {
/*  917 */     return this.fontType;
/*      */   }
/*      */   
/*      */   public int gethAttribut() {
/*  921 */     return this.hAttribut;
/*      */   }
/*      */   
/*      */   public int getWidthMax() {
/*  925 */     return this.widthMax;
/*      */   }
/*      */   
/*      */   public int getWidthMin() {
/*  929 */     return this.widthMin;
/*      */   }
/*      */   
/*      */   public int getxAttribut() {
/*  933 */     return this.xAttribut;
/*      */   }
/*      */   
/*      */   public int getyAttribut() {
/*  937 */     return this.yAttribut;
/*      */   }
/*      */   
/*      */   public int getyEntete() {
/*  941 */     return this.yEntete;
/*      */   }
/*      */   
/*      */   public double getZoom() {
/*  945 */     return this.zoom;
/*      */   }
/*      */   
/*      */   public boolean isArrondir() {
/*  949 */     return this.arrondir;
/*      */   }
/*      */   
/*      */   public boolean isAttMajuscule() {
/*  953 */     return this.attMajuscule;
/*      */   }
/*      */   
/*      */   public int getDecalCompose() {
/*  957 */     return this.decalCompose;
/*      */   }
/*      */   
/*      */   public String getIdentifiant() {
/*  961 */     return this.identifiant;
/*      */   }
/*      */   
/*      */   public boolean isPrkvisible() {
/*  965 */     return this.prkvisible;
/*      */   }
/*      */   
/*      */   public boolean isPrkImage() {
/*  969 */     return this.prkImage;
/*      */   }
/*      */   
/*      */   public Color getClOmbre() {
/*  973 */     return this.clOmbre;
/*      */   }
/*      */   
/*      */   public void setAligne(String aligne) {
/*  977 */     this.aligne = aligne;
/*      */   }
/*      */   
/*      */   public void setAligneTitre(String aligneTitre) {
/*  981 */     this.aligneTitre = aligneTitre;
/*      */   }
/*      */   
/*      */   public void setClCadre2(Color clCadre) {
/*  985 */     this.clCadre2 = clCadre;
/*      */   }
/*      */   
/*      */   public void setAttMajuscule(boolean attMajuscule) {
/*  989 */     this.attMajuscule = attMajuscule;
/*      */   }
/*      */   
/*      */   public void setDecalCompose(int decalCompose) {
/*  993 */     this.decalCompose = decalCompose;
/*      */   }
/*      */   
/*      */   public void setClCadreTitre2(Color clCadreTitre) {
/*  997 */     this.clCadreTitre2 = clCadreTitre;
/*      */   }
/*      */   
/*      */   public void setClFond2(Color clFond) {
/* 1001 */     this.clFond2 = clFond;
/*      */   }
/*      */   
/*      */   public void setClFondTitre2(Color clFondTitre) {
/* 1005 */     this.clFondTitre2 = clFondTitre;
/*      */   }
/*      */   
/*      */   public void setClText2(Color clText) {
/* 1009 */     this.clText2 = clText;
/*      */   }
/*      */   
/*      */   public void setClTextType2(Color clTextType2) {
/* 1013 */     this.clTextType2 = clTextType2;
/*      */   }
/*      */   
/*      */   public void setClTextTitre2(Color clTextTitre) {
/* 1017 */     this.clTextTitre2 = clTextTitre;
/*      */   }
/*      */   
/*      */   public void setClLienActiver(Color clLienActiver) {
/* 1021 */     this.clLienActiver = clLienActiver;
/*      */   }
/*      */   
/*      */   public void setFont(Font font) {
/* 1025 */     this.font = font;
/*      */   }
/*      */   
/*      */   public void setFontTitre(Font fontTitre) {
/* 1029 */     this.fontTitre = fontTitre;
/*      */   }
/*      */   
/*      */   public void setClPrk(Color clPrk) {
/* 1033 */     this.clPrk = clPrk;
/*      */   }
/*      */   
/*      */   public void setxCle(int xCle) {
/* 1037 */     this.xCle = xCle;
/*      */   }
/*      */   
/*      */   public void setxType(int xType) {
/* 1041 */     this.xType = xType;
/*      */   }
/*      */   
/*      */   public void setAttEspace(double AttEspace) {
/* 1045 */     this.AttEspace = AttEspace;
/*      */   }
/*      */   
/*      */   public void setPrkvisible(boolean prkvisible) {
/* 1049 */     this.prkvisible = prkvisible;
/*      */   }
/*      */   
/*      */   public void setPrkImage(boolean prkImage) {
/* 1053 */     this.prkImage = prkImage;
/*      */   }
/*      */   
/*      */   public void setHistorique(ArrayList<Historique> historique) {
/* 1057 */     this.historique = historique;
/*      */   }
/*      */   
/*      */   public void setAlignerAttribut(String alignerAttribut) {
/* 1061 */     this.alignerAttribut = alignerAttribut;
/*      */   }
/*      */   
/*      */   public void setAlignerType(String alignerType) {
/* 1065 */     this.alignerType = alignerType;
/*      */   }
/*      */   
/*      */   public void setClAttributSelect(Color clAttributSelect) {
/* 1069 */     this.clAttributSelect = clAttributSelect;
/*      */   }
/*      */   
/*      */   public void setClSelected(Color clSelected) {
/* 1073 */     this.clSelected = clSelected;
/*      */   }
/*      */   
/*      */   public void setEpaisseur(float epaisseur) {
/* 1077 */     this.epaisseur = epaisseur;
/*      */   }
/*      */   
/*      */   public void setFontAttribut(Font fontAttribut) {
/* 1081 */     this.fontAttribut = fontAttribut;
/*      */   }
/*      */   
/*      */   public void setFontNormal(Font fontNormal) {
/* 1085 */     this.fontNormal = fontNormal;
/*      */   }
/*      */   
/*      */   public void setFontType(Font fontType) {
/* 1089 */     this.fontType = fontType;
/*      */   }
/*      */   
/*      */   public void sethAttribut(int hAttribut) {
/* 1093 */     this.hAttribut = hAttribut;
/*      */   }
/*      */   
/*      */   public void setWidthMax(int widthMax) {
/* 1097 */     this.widthMax = widthMax;
/*      */   }
/*      */   
/*      */   public void setWidthMin(int widthMin) {
/* 1101 */     this.widthMin = widthMin;
/*      */   }
/*      */   
/*      */   public void setxAttribut(int xAttribut) {
/* 1105 */     this.xAttribut = xAttribut;
/*      */   }
/*      */   
/*      */   public void setyAttribut(int yAttribut) {
/* 1109 */     this.yAttribut = yAttribut;
/*      */   }
/*      */   
/*      */   public void setyEntete(int yEntete) {
/* 1113 */     this.yEntete = yEntete;
/*      */   }
/*      */   
/*      */   public void setZoom(double zoom) {
/* 1117 */     this.zoom = zoom;
/*      */   }
/*      */   
/*      */   public void setClOmbre(Color clOmbre) {
/* 1121 */     this.clOmbre = clOmbre;
/*      */   }
/*      */   
/*      */   public void setArrondir(boolean arrondir) {
/* 1125 */     this.arrondir = arrondir;
/*      */   }
/*      */   
/*      */   public void setNbUsedLibrairie(int nbUsedLibrairie) {
/* 1129 */     this.nbUsedLibrairie = nbUsedLibrairie;
/*      */   }
/*      */   
/*      */   public int getNbUsedLibrairie() {
/* 1133 */     return this.nbUsedLibrairie;
/*      */   }
/*      */   
/*      */   public void setIdentifiant(String identifiant) {
/* 1137 */     this.identifiant = identifiant;
/*      */   }
/*      */   
/*      */   public void ajouterCopier(ArrayList<Historique> lhis) {
/* 1141 */     Historique h = Historique.getHistoriqueCopie();
/* 1142 */     Historique h1 = (Historique)lhis.get(lhis.size() - 1);
/* 1143 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur())) || (!h.getAction().equals(h1.getAction())))
/*      */     {
/* 1145 */       lhis.add(h);
/*      */     }
/*      */   }
/*      */   
/*      */   public ArrayList<Historique> copierHistoriques(ArrayList<Historique> lhis) {
/* 1150 */     ArrayList<Historique> l = new ArrayList();
/* 1151 */     for (int i = 0; i < lhis.size(); i++) {
/* 1152 */       l.add(((Historique)lhis.get(i)).copier());
/*      */     }
/* 1154 */     ajouterCopier(l);
/* 1155 */     return l;
/*      */   }
/*      */   
/*      */   public void ajouterModification() {
/* 1159 */     Historique h = Historique.getHistoriqueModification();
/* 1160 */     Historique h1 = (Historique)this.historique.get(this.historique.size() - 1);
/* 1161 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur()))) {
/* 1162 */       getHistorique().add(h);
/*      */     }
/*      */   }
/*      */   
/*      */   public IhmEntite copier()
/*      */   {
/* 1168 */     IhmEntite2 ent = new IhmEntite2(getEntite().copier(), getX(), getY(), true);
/* 1169 */     ent.setClCadre2(getClCadre2());
/* 1170 */     ent.setClCadreTitre2(this.clCadreTitre2);
/* 1171 */     ent.setClDegradee(isClDegradee());
/*      */     
/* 1173 */     ent.setClFond2(this.clFond2);
/* 1174 */     ent.setClPrk(getClPrk());
/* 1175 */     ent.setClFondTitre2(this.clFondTitre2);
/* 1176 */     ent.setClLienActiver(this.clLienActiver);
/*      */     
/* 1178 */     ent.setClText2(this.clText2);
/* 1179 */     ent.setClTextType2(this.clTextType2);
/*      */     
/* 1181 */     ent.setClTextTitre2(this.clTextTitre2);
/* 1182 */     ent.setFont(getFont());
/* 1183 */     ent.setFontTitre(getFontTitre());
/* 1184 */     ent.fontNormal = Parametres.fontNormal;
/*      */     
/* 1186 */     ent.clSelected = Setting.clSelected2;
/* 1187 */     ent.aligne = "";
/* 1188 */     ent.aligneTitre = "";
/* 1189 */     ent.zoom = FormeInterneMCD.zoom;
/*      */     
/* 1191 */     ent.historique = new ArrayList();
/* 1192 */     ent.setHistorique(copierHistoriques(this.historique));
/*      */     
/* 1194 */     ent.setFontAttribut(this.fontAttribut);
/* 1195 */     ent.setFontType(this.fontType);
/* 1196 */     ent.setClAttributSelect(this.clAttributSelect);
/* 1197 */     ent.setAligneTitre(this.aligneTitre);
/* 1198 */     ent.setWidthMin(this.widthMin);
/* 1199 */     ent.setWidthMax(this.widthMax);
/* 1200 */     ent.setAlignerAttribut(this.alignerAttribut);
/* 1201 */     ent.setAlignerType(this.alignerType);
/* 1202 */     ent.setNbUsedLibrairie(this.nbUsedLibrairie);
/* 1203 */     ent.setClTextTaille2(this.clTextTaille2);
/* 1204 */     ent.setClTextTailleDec2(this.clTextTailleDec2);
/* 1205 */     return ent;
/*      */   }
/*      */   
/*      */   public static IhmEntite2 parseIhmEntite(IhmEntite ent)
/*      */   {
/* 1210 */     Entite2 eee = Entite2.parseEntite(ent.getEntite());
/* 1211 */     IhmEntite2 e = new IhmEntite2(eee, ent.getX(), ent.getY(), ent.isVariable());
/*      */     
/* 1213 */     e.setOmbre(ent.isOmbre());
/* 1214 */     e.setClDegradee(ent.isClDegradee());
/*      */     
/* 1216 */     e.setClCadre2(IhmEntite.getClEntiteCadre());
/* 1217 */     e.setClCadreTitre2(IhmEntite.getClEntiteCadre());
/* 1218 */     e.setClFond2(IhmEntite.getClEntiteFond());
/* 1219 */     e.setClFondTitre2(FormeInterneMCD.clEntiteFond2);
/*      */     
/* 1221 */     e.setClText2(IhmEntite.getClString());
/* 1222 */     e.setClTextType2(IhmEntite.getClString());
/* 1223 */     e.setClTextTitre2(IhmEntite.getClString());
/*      */     
/* 1225 */     return e;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isAfficherCodeAttribut2()
/*      */   {
/* 1233 */     return this.afficherCodeAttribut2;
/*      */   }
/*      */   
/*      */   public boolean isAfficherCodeEntite2() {
/* 1237 */     return this.afficherCodeEntite2;
/*      */   }
/*      */   
/*      */   public Attribut getAttributSelect2() {
/* 1241 */     return this.attributSelect2;
/*      */   }
/*      */   
/*      */   public String getAugmentation2() {
/* 1245 */     return this.augmentation2;
/*      */   }
/*      */   
/*      */   public boolean isAugmentationPrefix2() {
/* 1249 */     return this.augmentationPrefix2;
/*      */   }
/*      */   
/*      */   public Color getClFillSelAttribut() {
/* 1253 */     return this.clFillSelAttribut;
/*      */   }
/*      */   
/*      */   public Color getClStrokeSelAttribut() {
/* 1257 */     return this.clStrokeSelAttribut;
/*      */   }
/*      */   
/*      */   public String getCodeAttribut2() {
/* 1261 */     return this.codeAttribut2;
/*      */   }
/*      */   
/*      */   public String getCodeEntete2() {
/* 1265 */     return this.codeEntete2;
/*      */   }
/*      */   
/*      */   public String getCodeFin2() {
/* 1269 */     return this.codeFin2;
/*      */   }
/*      */   
/*      */   public String getCodeMethode2() {
/* 1273 */     return this.codeMethode2;
/*      */   }
/*      */   
/*      */   public ArrayList<AttributContrainte2> getListeIndex2() {
/* 1277 */     return this.listeIndex2;
/*      */   }
/*      */   
/*      */   public ArrayList<AttributContrainte2> getListeUnique2() {
/* 1281 */     return this.listeUnique2;
/*      */   }
/*      */   
/*      */   public ArrayList<AttributContrainte2> getListeCle2() {
/* 1285 */     return this.listeCle2;
/*      */   }
/*      */   
/*      */   public ArrayList<AttributContrainte2> getListeCleEtrangere2() {
/* 1289 */     return this.listeCleEtrangere2;
/*      */   }
/*      */   
/*      */   public boolean isMldGenerer2() {
/* 1293 */     return this.mldGenerer2;
/*      */   }
/*      */   
/*      */   public boolean isMldHeritageGenerer2() {
/* 1297 */     return this.mldHeritageGenerer2;
/*      */   }
/*      */   
/*      */   public String getOrigine2() {
/* 1301 */     return this.origine2;
/*      */   }
/*      */   
/*      */   public void setAfficherCodeAttribut2(boolean afficherCodeAttribut2) {
/* 1305 */     this.afficherCodeAttribut2 = afficherCodeAttribut2;
/*      */   }
/*      */   
/*      */   public void setAfficherCodeEntite2(boolean afficherCodeEntite2) {
/* 1309 */     this.afficherCodeEntite2 = afficherCodeEntite2;
/*      */   }
/*      */   
/*      */   public void setListeCle2(ArrayList<AttributContrainte2> listeCle2) {
/* 1313 */     this.listeCle2 = listeCle2;
/*      */   }
/*      */   
/*      */   public void setListeCleEtrangere2(ArrayList<AttributContrainte2> listeCleEtrangere2) {
/* 1317 */     this.listeCleEtrangere2 = listeCleEtrangere2;
/*      */   }
/*      */   
/*      */   public void setAttributSelect2(Attribut attributSelect2) {
/* 1321 */     this.attributSelect2 = attributSelect2;
/*      */   }
/*      */   
/*      */   public void setAugmentation2(String augmentation2) {
/* 1325 */     this.augmentation2 = augmentation2;
/*      */   }
/*      */   
/*      */   public void setAugmentationPrefix2(boolean augmentationPrefix2) {
/* 1329 */     this.augmentationPrefix2 = augmentationPrefix2;
/*      */   }
/*      */   
/*      */   public void setClFillSelAttribut(Color clFillSelAttribut) {
/* 1333 */     this.clFillSelAttribut = clFillSelAttribut;
/*      */   }
/*      */   
/*      */   public void setClStrokeSelAttribut(Color clStrokeSelAttribut) {
/* 1337 */     this.clStrokeSelAttribut = clStrokeSelAttribut;
/*      */   }
/*      */   
/*      */   public void setCodeAttribut2(String codeAttribut2) {
/* 1341 */     this.codeAttribut2 = codeAttribut2;
/*      */   }
/*      */   
/*      */   public void setCodeEntete2(String codeEntete2) {
/* 1345 */     this.codeEntete2 = codeEntete2;
/*      */   }
/*      */   
/*      */   public void setCodeFin2(String codeFin2) {
/* 1349 */     this.codeFin2 = codeFin2;
/*      */   }
/*      */   
/*      */   public void setCodeMethode2(String codeMethode) {
/* 1353 */     this.codeMethode2 = codeMethode;
/*      */   }
/*      */   
/*      */   public void setListeIndex2(ArrayList<AttributContrainte2> listeIndex2) {
/* 1357 */     this.listeIndex2 = listeIndex2;
/*      */   }
/*      */   
/*      */   public void setListeUnique2(ArrayList<AttributContrainte2> listeUnique2) {
/* 1361 */     this.listeUnique2 = listeUnique2;
/*      */   }
/*      */   
/*      */   public void setMldGenerer2(boolean mldGenerer2) {
/* 1365 */     this.mldGenerer2 = mldGenerer2;
/*      */   }
/*      */   
/*      */   public void setMldHeritageGenerer2(boolean mldHeritageGenerer2) {
/* 1369 */     this.mldHeritageGenerer2 = mldHeritageGenerer2;
/*      */   }
/*      */   
/*      */   public void setOrigine2(String origine2) {
/* 1373 */     this.origine2 = origine2;
/*      */   }
/*      */   
/*      */   public Color getColor(String color) {
/* 1377 */     return new Color(Integer.parseInt(color));
/*      */   }
/*      */   
/*      */   public String getColor(Color color) {
/* 1381 */     return color.getRGB() + "";
/*      */   }
/*      */   
/*      */   public boolean isAfficherCntCle2() {
/* 1385 */     return this.afficherCntCle2;
/*      */   }
/*      */   
/*      */   public boolean isAfficherCntCleEtrangere2() {
/* 1389 */     return this.afficherCntCleEtrangere2;
/*      */   }
/*      */   
/*      */   public boolean isAfficherCntIndex2() {
/* 1393 */     return this.afficherCntIndex2;
/*      */   }
/*      */   
/*      */   public boolean isAfficherCntUnique2() {
/* 1397 */     return this.afficherCntUnique2;
/*      */   }
/*      */   
/*      */   public void setAfficherCntCle2(boolean afficherCntCle2) {
/* 1401 */     this.afficherCntCle2 = afficherCntCle2;
/*      */   }
/*      */   
/*      */   public void setAfficherCntCleEtrangere2(boolean afficherCntCleEtrangere2) {
/* 1405 */     this.afficherCntCleEtrangere2 = afficherCntCleEtrangere2;
/*      */   }
/*      */   
/*      */   public void setAfficherCntIndex2(boolean afficherCntIndex2) {
/* 1409 */     this.afficherCntIndex2 = afficherCntIndex2;
/*      */   }
/*      */   
/*      */   public void setAfficherCntUnique2(boolean afficherCntUnique2) {
/* 1413 */     this.afficherCntUnique2 = afficherCntUnique2;
/*      */   }
/*      */   
/*      */   public Color getClTextTaille2() {
/* 1417 */     return this.clTextTaille2;
/*      */   }
/*      */   
/*      */   public Color getClTextTailleDec2() {
/* 1421 */     return this.clTextTailleDec2;
/*      */   }
/*      */   
/*      */   public void setClTextTaille2(Color clTextTaille2) {
/* 1425 */     this.clTextTaille2 = clTextTaille2;
/*      */   }
/*      */   
/*      */   public void setClTextTailleDec2(Color clTextTailleDec2) {
/* 1429 */     this.clTextTailleDec2 = clTextTailleDec2;
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmEntite2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */