/*      */ package IhmMLD;
/*      */ 
/*      */ import IhmMCD.BarOutil;
/*      */ import IhmMCD.Grid;
/*      */ import IhmMCD.IhmCadre;
/*      */ import IhmMCD.IhmCommentaireIndip;
/*      */ import IhmMCD.IhmLienCommentaire;
/*      */ import IhmMCD2.IhmPoint;
/*      */ import IhmMLD2.MLDEntite2;
/*      */ import IhmMLD2.MLDLienEntite2;
/*      */ import Merise2.EntiteRelationContrainte2;
/*      */ import MyExplorer.ExplorerPan;
/*      */ import MyExplorer.NodeRootMLD;
/*      */ import Outil.Parametres;
/*      */ import Outil.Setting;
/*      */ import formes.PanelLoupe;
/*      */ import formes2.FormeMLDEntite2;
/*      */ import formes2.FormeMLDLien2;
/*      */ import ihm.FormeInterneMCD;
/*      */ import ihm.FormeInterneMLD;
/*      */ import ihm.Principale;
/*      */ import java.awt.BasicStroke;
/*      */ import java.awt.Color;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.RenderingHints;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.KeyListener;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.MouseListener;
/*      */ import java.awt.event.MouseMotionListener;
/*      */ import java.awt.geom.Rectangle2D;
/*      */ import java.awt.geom.Rectangle2D.Double;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JTree;
/*      */ 
/*      */ 
/*      */ public class IhmPageMLD
/*      */   extends JPanel
/*      */   implements MouseListener, MouseMotionListener, KeyListener
/*      */ {
/*      */   private ArrayList<MLDLienEntite2> listeLien;
/*      */   private ArrayList<MLDEntite2> listeMLDEntite;
/*      */   private MLDEntite2 entiteSelect;
/*      */   private MLDLienEntite2 lienSel;
/*      */   private int Sx;
/*      */   private int Sy;
/*      */   private Principale frm;
/*      */   private FormeInterneMLD formeMLD;
/*      */   private Grid grid;
/*      */   private Map<MLDLienEntite2, String> listeLienDouble;
/*      */   private boolean modeSelect;
/*      */   private int Fx;
/*      */   private int Fy;
/*      */   private int xSelectedMin;
/*      */   private int ySelectedMin;
/*      */   private int xSelectedMax;
/*      */   private int ySelectedMax;
/*      */   private int xgroupe;
/*      */   private int ygroupe;
/*      */   private IhmPoint pointSel;
/*   70 */   protected Color fillColor = new Color(175, 203, 29, 90);
/*      */   
/*   72 */   protected Color strokeColor = Color.BLUE;
/*      */   
/*      */   double zoom;
/*      */   
/*      */   public Color clPage;
/*      */   
/*      */   public Color clPetitCareau;
/*      */   
/*      */   boolean mutex;
/*      */   
/*      */   boolean entiteModifer;
/*      */   
/*      */   ArrayList<IhmCadre> listeCadre;
/*      */   
/*      */   ArrayList<IhmCommentaireIndip> listeCommentaire;
/*      */   
/*      */   ArrayList<IhmLienCommentaire> listeLienCommentaire;
/*      */   
/*      */   ArrayList<EntiteRelationContrainte2> listeEntRelContrainte;
/*      */   
/*      */   boolean isMLDModifier;
/*      */   
/*      */ 
/*      */   public IhmPageMLD(FormeInterneMLD formeMLD, ArrayList<MLDLienEntite2> listeLien, ArrayList<MLDEntite2> listeMLDEntite, ArrayList<MLDReference> listeReference, Principale frm)
/*      */   {
/*   97 */     this.clPetitCareau = new Color(255, 230, 200);
/*   98 */     this.formeMLD = formeMLD;
/*   99 */     setBackground(Color.white);
/*  100 */     this.listeLien = listeLien;
/*  101 */     this.listeMLDEntite = listeMLDEntite;
/*      */     
/*  103 */     this.entiteSelect = null;
/*  104 */     this.lienSel = null;
/*      */     
/*  106 */     this.xSelectedMin = Integer.MAX_VALUE;
/*  107 */     this.ySelectedMin = Integer.MAX_VALUE;
/*  108 */     this.xSelectedMax = 0;
/*  109 */     this.ySelectedMax = 0;
/*      */     
/*  111 */     addMouseListener(this);
/*  112 */     addMouseMotionListener(this);
/*  113 */     addKeyListener(this);
/*      */     
/*  115 */     this.zoom = 1.0D;
/*  116 */     this.frm = frm;
/*  117 */     this.grid = new Grid(getSize().width, getSize().height, 2);
/*  118 */     this.listeLienDouble = new HashMap();
/*  119 */     this.modeSelect = true;
/*  120 */     setAutoscrolls(true);
/*  121 */     this.pointSel = null;
/*  122 */     remplirTree();
/*      */     
/*  124 */     this.mutex = false;
/*  125 */     this.entiteModifer = false;
/*      */     
/*  127 */     this.listeCadre = new ArrayList();
/*  128 */     this.listeCommentaire = new ArrayList();
/*  129 */     this.listeLienCommentaire = new ArrayList();
/*  130 */     this.listeEntRelContrainte = new ArrayList();
/*  131 */     this.isMLDModifier = false;
/*      */   }
/*      */   
/*      */ 
/*      */   protected void paintComponent(Graphics gr)
/*      */   {
/*  137 */     int x = 0;int y = 0;
/*  138 */     Graphics2D g = (Graphics2D)gr;
/*  139 */     g.setFont(Parametres.fontNormal);
/*      */     
/*  141 */     if (this.frm.getBar().isAfficheRegle()) {
/*  142 */       g.setColor(Color.WHITE);
/*      */     } else {
/*  144 */       g.setColor(this.clPage);
/*      */     }
/*  146 */     g.fillRect(0, 0, (int)getSize().getWidth(), (int)getSize().getHeight());
/*  147 */     if (this.frm.getBar().isAfficheRegle()) {
/*  148 */       g.setColor(Color.WHITE);
/*  149 */       if (Setting.petitCarreau) { afficherGrille(g);
/*      */       } else {
/*  151 */         Graphics2D g2 = g;
/*  152 */         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*  153 */         this.grid = new Grid(getSize().width, getSize().height, 2);
/*  154 */         this.grid.drawGrid(g2);
/*      */       }
/*      */     } else {
/*  157 */       g.setColor(this.clPage);
/*      */     }
/*      */     
/*  160 */     g.scale(this.zoom, this.zoom);
/*  161 */     g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*      */     
/*  163 */     g.setColor(Color.BLUE);
/*  164 */     for (int i = 0; i < this.listeLien.size(); i++) {
/*  165 */       if (this.frm.getBar().isAfficheRegle()) {
/*  166 */         ((MLDLienEntite2)this.listeLien.get(i)).setClLienFondText(Color.WHITE);
/*      */       } else {
/*  168 */         ((MLDLienEntite2)this.listeLien.get(i)).setClLienFondText(this.clPage);
/*      */       }
/*  170 */       ((MLDLienEntite2)this.listeLien.get(i)).paint(g);
/*  171 */       int xxx = ((MLDLienEntite2)this.listeLien.get(i)).XMaxAllPoint();
/*  172 */       int yyy = ((MLDLienEntite2)this.listeLien.get(i)).YMaxAllPoint();
/*  173 */       if (xxx > x) x = xxx;
/*  174 */       if (yyy > y) { y = yyy;
/*      */       }
/*      */     }
/*  177 */     for (int i = 0; i < this.listeMLDEntite.size(); i++)
/*      */     {
/*  179 */       ((MLDEntite2)this.listeMLDEntite.get(i)).paint(g);
/*  180 */       if (x < ((MLDEntite2)this.listeMLDEntite.get(i)).getX() + ((MLDEntite2)this.listeMLDEntite.get(i)).getWidth())
/*  181 */         x = ((MLDEntite2)this.listeMLDEntite.get(i)).getX() + ((MLDEntite2)this.listeMLDEntite.get(i)).getWidth();
/*  182 */       if (y < ((MLDEntite2)this.listeMLDEntite.get(i)).getY() + ((MLDEntite2)this.listeMLDEntite.get(i)).getHeight()) {
/*  183 */         y = ((MLDEntite2)this.listeMLDEntite.get(i)).getY() + ((MLDEntite2)this.listeMLDEntite.get(i)).getHeight();
/*      */       }
/*      */     }
/*  186 */     dessinerPlussieursLiens(g);
/*  187 */     if (x * this.zoom > getWidth()) {
/*  188 */       setPreferredSize(new Dimension((int)(x * this.zoom) + 50, (int)(y * this.zoom) + 50));
/*  189 */       setSize((int)this.frm.getSize().getWidth(), (int)this.frm.getSize().getHeight());
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  194 */     if (y * this.zoom > getHeight()) {
/*  195 */       setPreferredSize(new Dimension((int)(x * this.zoom) + 50, (int)(y * this.zoom) + 50));
/*  196 */       setSize((int)this.frm.getSize().getWidth(), (int)this.frm.getSize().getHeight());
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  201 */     if (this.modeSelect) {
/*  202 */       setSelected(false);
/*  203 */       dessinerCadreSelect(g);
/*      */     } else {
/*  205 */       calculerXYSelected();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void dessinerCadreSelect(Graphics g)
/*      */   {
/*  212 */     int w = Math.abs(this.Sx - this.Fx);
/*  213 */     int h = Math.abs(this.Sy - this.Fy);
/*  214 */     int x0 = this.Sx;
/*  215 */     int y0 = this.Sy;
/*  216 */     if (x0 > this.Fx) x0 = this.Sx - w;
/*  217 */     if (y0 > this.Fy) y0 = this.Sy - h;
/*  218 */     Graphics2D g2 = (Graphics2D)g;
/*  219 */     Rectangle2D rec = new Rectangle2D.Double(x0, y0, w, h);
/*  220 */     g2.setStroke(new BasicStroke(1.0F));
/*  221 */     g2.setPaint(this.fillColor);
/*  222 */     g2.fill(rec);
/*  223 */     g2.setPaint(this.strokeColor);
/*  224 */     g2.draw(rec);
/*      */   }
/*      */   
/*      */   public void dessinerPlussieursLiens(Graphics g) {
/*  228 */     verifierLien();
/*  229 */     Color cl = g.getColor();
/*  230 */     g.setColor(Color.RED);
/*      */     
/*  232 */     Object[] cle = this.listeLienDouble.keySet().toArray();
/*  233 */     for (int i = 0; i < cle.length; i++) {
/*  234 */       int x = (((MLDLienEntite2)cle[i]).getSource().getCentreX() + ((MLDLienEntite2)cle[i]).getCible().getCentreX()) / 2;
/*  235 */       int y = (((MLDLienEntite2)cle[i]).getSource().getCentreY() + ((MLDLienEntite2)cle[i]).getCible().getCentreY()) / 2;
/*  236 */       g.drawString("Plusieurs liens ... ", x, y);
/*      */     }
/*  238 */     g.setColor(cl);
/*      */   }
/*      */   
/*      */   private void verifierLien()
/*      */   {
/*  243 */     this.listeLienDouble.clear();
/*  244 */     for (int i = 0; i < this.listeLien.size(); i++) {
/*  245 */       MLDLienEntite2 l = (MLDLienEntite2)this.listeLien.get(i);
/*  246 */       if (l.getPointCassure().size() == 0) {
/*  247 */         for (int j = i + 1; j < this.listeLien.size(); j++) {
/*  248 */           if ((((MLDLienEntite2)this.listeLien.get(j)).getPointCassure().size() == 0) && (
/*  249 */             ((l.getSource() == ((MLDLienEntite2)this.listeLien.get(j)).getSource()) && (l.getCible() == ((MLDLienEntite2)this.listeLien.get(j)).getCible())) || ((l.getCible() == ((MLDLienEntite2)this.listeLien.get(j)).getSource()) && (l.getSource() == ((MLDLienEntite2)this.listeLien.get(j)).getCible()))))
/*      */           {
/*  251 */             if (l.getPointCassure().size() == 0) {
/*  252 */               this.listeLienDouble.put(l, "Plusieurs Liens ");
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void setSelectCollection(int sx0, int sy0, int sx1, int sy1)
/*      */   {
/*  262 */     for (int i = 0; i < this.listeMLDEntite.size(); i++) {
/*  263 */       boolean vrai = isObjectSelect(sx0, sy0, sx1, sy1, ((MLDEntite2)this.listeMLDEntite.get(i)).getX(), ((MLDEntite2)this.listeMLDEntite.get(i)).getY());
/*  264 */       vrai = (vrai) && (isObjectSelect(sx0, sy0, sx1, sy1, ((MLDEntite2)this.listeMLDEntite.get(i)).getX() + ((MLDEntite2)this.listeMLDEntite.get(i)).getWidth(), ((MLDEntite2)this.listeMLDEntite.get(i)).getY() + ((MLDEntite2)this.listeMLDEntite.get(i)).getHeight()));
/*  265 */       ((MLDEntite2)this.listeMLDEntite.get(i)).setSelected(vrai);
/*      */     }
/*      */     
/*      */ 
/*  269 */     for (int i = 0; i < this.listeLien.size(); i++) {
/*  270 */       MLDLienEntite2 li = (MLDLienEntite2)this.listeLien.get(i);
/*  271 */       for (int j = 0; j < li.getPointCassure().size(); j++) {
/*  272 */         if (((IhmPoint)li.getPointCassure().get(j)).estDans(sx0, sy0, sx1, sy1)) {
/*  273 */           ((IhmPoint)li.getPointCassure().get(j)).setSelected(true);
/*      */         }
/*      */       }
/*  276 */       if (li.estDans(sx0, sy0, sx1, sy1)) {
/*  277 */         li.setSelected(true);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean isObjectSelect(int sx0, int sy0, int sx1, int sy1, int x, int y)
/*      */   {
/*  291 */     int x0 = sx0;
/*  292 */     int y0 = sy0;
/*  293 */     int x1 = sx1;
/*  294 */     int y1 = sy1;
/*  295 */     if (x0 > sx1) {
/*  296 */       x0 = sx1;
/*  297 */       x1 = sx0;
/*      */     }
/*  299 */     if (y0 > sy1) {
/*  300 */       y0 = sy1;
/*  301 */       y1 = sy0;
/*      */     }
/*  303 */     if ((x >= x0) && (x <= x1) && (y >= y0) && (y <= y1)) return true;
/*  304 */     return false;
/*      */   }
/*      */   
/*      */   private boolean estDansGroupe(int x, int y) {
/*  308 */     if ((x > this.xSelectedMin) && (y > this.ySelectedMin) && (x < this.xSelectedMax) && (y < this.ySelectedMax)) {
/*  309 */       return estDansElement(x, y);
/*      */     }
/*  311 */     return false;
/*      */   }
/*      */   
/*      */   public void deplacerGroupe(int x, int y) {
/*  315 */     this.xSelectedMax += x;
/*  316 */     this.xSelectedMin += x;
/*  317 */     this.ySelectedMax += y;
/*  318 */     this.ySelectedMin += y;
/*  319 */     calculerXYSelected();
/*  320 */     if (this.xSelectedMin - x < 0) return;
/*  321 */     if (this.ySelectedMin - y < 0) { return;
/*      */     }
/*  323 */     for (int j = 0; j < this.listeMLDEntite.size(); j++) {
/*  324 */       if (((MLDEntite2)this.listeMLDEntite.get(j)).isSelected()) {
/*  325 */         ((MLDEntite2)this.listeMLDEntite.get(j)).setX(((MLDEntite2)this.listeMLDEntite.get(j)).getX() - x);
/*  326 */         ((MLDEntite2)this.listeMLDEntite.get(j)).setY(((MLDEntite2)this.listeMLDEntite.get(j)).getY() - y);
/*      */       }
/*      */     }
/*      */     
/*  330 */     for (int j = 0; j < this.listeLien.size(); j++) {
/*  331 */       ((MLDLienEntite2)this.listeLien.get(j)).deplacerPointSelectionner(x, y);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean estDansElement(int x, int y) {
/*  336 */     for (int j = 0; j < this.listeMLDEntite.size(); j++) {
/*  337 */       if ((((MLDEntite2)this.listeMLDEntite.get(j)).isSelected()) && 
/*  338 */         (x > ((MLDEntite2)this.listeMLDEntite.get(j)).getX()) && (y > ((MLDEntite2)this.listeMLDEntite.get(j)).getY()) && (x < ((MLDEntite2)this.listeMLDEntite.get(j)).getX() + ((MLDEntite2)this.listeMLDEntite.get(j)).getWidth()) && (y < ((MLDEntite2)this.listeMLDEntite.get(j)).getY() + ((MLDEntite2)this.listeMLDEntite.get(j)).getHeight()))
/*      */       {
/*      */ 
/*  341 */         return true;
/*      */       }
/*      */     }
/*      */     
/*  345 */     for (int j = 0; j < this.listeLien.size(); j++) {
/*  346 */       if (((MLDLienEntite2)this.listeLien.get(j)).getSelectedPointCassure(x, y) != null) {
/*  347 */         return true;
/*      */       }
/*      */     }
/*  350 */     return false;
/*      */   }
/*      */   
/*      */   public void calculerXYSelected() {
/*  354 */     this.xSelectedMin = Integer.MAX_VALUE;
/*  355 */     this.ySelectedMin = Integer.MAX_VALUE;
/*  356 */     this.xSelectedMax = 0;
/*  357 */     this.ySelectedMax = 0;
/*      */     
/*      */ 
/*  360 */     for (int i = 0; i < this.listeLien.size(); i++) {
/*  361 */       int xx = ((MLDLienEntite2)this.listeLien.get(i)).XMinPointSelectionner();
/*  362 */       if (this.xSelectedMin > xx) this.xSelectedMin = xx;
/*  363 */       xx = ((MLDLienEntite2)this.listeLien.get(i)).YMinPointSelectionner();
/*  364 */       if (this.ySelectedMin > xx) this.ySelectedMin = xx;
/*  365 */       xx = ((MLDLienEntite2)this.listeLien.get(i)).XMaxPointSelectionner();
/*  366 */       if (this.xSelectedMax < xx) this.xSelectedMax = xx;
/*  367 */       xx = ((MLDLienEntite2)this.listeLien.get(i)).YMaxPointSelectionner();
/*  368 */       if (this.ySelectedMax < xx) { this.ySelectedMax = xx;
/*      */       }
/*      */     }
/*  371 */     for (int j = 0; j < this.listeMLDEntite.size(); j++) {
/*  372 */       if (((MLDEntite2)this.listeMLDEntite.get(j)).isSelected())
/*      */       {
/*  374 */         if (this.xSelectedMin > ((MLDEntite2)this.listeMLDEntite.get(j)).getX()) {
/*  375 */           this.xSelectedMin = ((MLDEntite2)this.listeMLDEntite.get(j)).getX();
/*      */         }
/*  377 */         if (this.ySelectedMin > ((MLDEntite2)this.listeMLDEntite.get(j)).getY()) {
/*  378 */           this.ySelectedMin = ((MLDEntite2)this.listeMLDEntite.get(j)).getY();
/*      */         }
/*  380 */         if (this.xSelectedMax < ((MLDEntite2)this.listeMLDEntite.get(j)).getX() + ((MLDEntite2)this.listeMLDEntite.get(j)).getWidth()) {
/*  381 */           this.xSelectedMax = (((MLDEntite2)this.listeMLDEntite.get(j)).getX() + ((MLDEntite2)this.listeMLDEntite.get(j)).getWidth());
/*      */         }
/*  383 */         if (this.ySelectedMax < ((MLDEntite2)this.listeMLDEntite.get(j)).getY() + ((MLDEntite2)this.listeMLDEntite.get(j)).getHeight()) {
/*  384 */           this.ySelectedMax = (((MLDEntite2)this.listeMLDEntite.get(j)).getY() + ((MLDEntite2)this.listeMLDEntite.get(j)).getHeight());
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void remplirTree() {
/*  391 */     if ((this.frm.getExplorer() != null) && 
/*  392 */       (this.formeMLD != null)) {
/*  393 */       this.formeMLD.getRacineMLD().removeAllChildren();
/*  394 */       for (int i = 0; i < this.listeMLDEntite.size(); i++) {
/*  395 */         this.frm.getExplorer().ajouterNode((MLDEntite2)this.listeMLDEntite.get(i), this.formeMLD.getRacineMLD());
/*      */       }
/*  397 */       this.frm.getExplorer().getTree().updateUI();
/*  398 */       repaint();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void effacerMLD()
/*      */   {
/*  405 */     this.listeMLDEntite.clear();
/*  406 */     this.listeLien.clear();
/*  407 */     remplirTree();
/*      */   }
/*      */   
/*      */   private void afficherGrille(Graphics gr) {
/*  411 */     int i = 15;
/*  412 */     gr.setColor(this.clPetitCareau);
/*  413 */     while (i < getSize().getWidth()) {
/*  414 */       gr.drawLine(i, 0, i, (int)getSize().getHeight());
/*  415 */       i += 15;
/*      */     }
/*  417 */     i = 15;
/*  418 */     while (i < getSize().getHeight()) {
/*  419 */       gr.drawLine(0, i, (int)getSize().getWidth(), i);
/*  420 */       i += 15;
/*      */     }
/*      */   }
/*      */   
/*      */   public void setSelected(boolean sel) {
/*  425 */     this.entiteSelect = null;
/*  426 */     for (int i = 0; i < this.listeMLDEntite.size(); i++) {
/*  427 */       ((MLDEntite2)this.listeMLDEntite.get(i)).setSelected(sel);
/*      */     }
/*  429 */     this.lienSel = null;
/*  430 */     this.pointSel = null;
/*  431 */     for (int i = 0; i < this.listeLien.size(); i++) {
/*  432 */       ((MLDLienEntite2)this.listeLien.get(i)).setSelected(sel);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private MLDEntite2 isSelected(int x, int y)
/*      */   {
/*  442 */     MLDEntite2 ent = null;
/*  443 */     for (int i = 0; i < this.listeMLDEntite.size(); i++) {
/*  444 */       if (((MLDEntite2)this.listeMLDEntite.get(i)).isSelected(x, y)) {
/*  445 */         if (ent != null) ent.setSelected(false);
/*  446 */         ent = (MLDEntite2)this.listeMLDEntite.get(i);
/*  447 */         ent.setSelected(true);
/*      */       }
/*      */     }
/*  450 */     return ent;
/*      */   }
/*      */   
/*      */   private MLDLienEntite2 isSelectedLien(int x, int y) {
/*  454 */     MLDLienEntite2 lienM = null;
/*  455 */     for (int i = 0; i < this.listeLien.size(); i++) {
/*  456 */       if (((MLDLienEntite2)this.listeLien.get(i)).isSelected(x, y)) {
/*  457 */         if (lienM != null) {
/*  458 */           lienM.setSelected(false);
/*      */         }
/*  460 */         lienM = (MLDLienEntite2)this.listeLien.get(i);
/*  461 */         lienM.setSelected(true);
/*      */       }
/*      */     }
/*  464 */     return lienM;
/*      */   }
/*      */   
/*      */   public ArrayList<MLDLienEntite2> getListeLien() {
/*  468 */     return this.listeLien;
/*      */   }
/*      */   
/*      */   public ArrayList<MLDEntite2> getListeMLDEntite() {
/*  472 */     return this.listeMLDEntite;
/*      */   }
/*      */   
/*      */   public void setListeLien(ArrayList<MLDLienEntite2> listeLien) {
/*  476 */     this.listeLien = listeLien;
/*      */   }
/*      */   
/*      */   public void setListeMLDEntite(ArrayList<MLDEntite2> listeMLDEntite) {
/*  480 */     this.listeMLDEntite = listeMLDEntite;
/*  481 */     remplirTree();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void majPanelLoupe()
/*      */   {
/*  489 */     if (this.frm.isLoupe()) {
/*  490 */       this.frm.getPanelLoupe().setFrmInterne(this.formeMLD);
/*      */     }
/*      */   }
/*      */   
/*      */   private IhmPoint selectedPointCassure(int x, int y, MLDLienEntite2 lien) {
/*  495 */     return lien.getSelectedPointCassure(x, y);
/*      */   }
/*      */   
/*      */   public void desactiverAllLien() {
/*  499 */     for (int i = 0; i < this.listeLien.size(); i++) {
/*  500 */       ((MLDLienEntite2)this.listeLien.get(i)).setActiver(false);
/*      */     }
/*      */   }
/*      */   
/*      */   public void activerAllLien(MLDEntite2 ent) {
/*  505 */     if (!Setting.activerLien2) { return;
/*      */     }
/*  507 */     Color cl = ent.getClLienActiver();
/*  508 */     for (int i = 0; i < this.listeLien.size(); i++) {
/*  509 */       MLDLienEntite2 l = (MLDLienEntite2)this.listeLien.get(i);
/*  510 */       if ((l.getSource() == ent) || (l.getCible() == ent)) {
/*  511 */         l.setActiver(true);
/*  512 */         l.setClLienActiver(cl);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void remiseANullLesSelectionner()
/*      */   {
/*  519 */     if (this.lienSel != null) {
/*  520 */       this.lienSel.setSelected(false);
/*  521 */       this.lienSel = null;
/*      */     }
/*  523 */     if (this.pointSel != null) {
/*  524 */       this.pointSel.setSelected(false);
/*  525 */       this.pointSel = null;
/*      */     }
/*  527 */     if (this.entiteSelect != null) {
/*  528 */       this.entiteSelect.setSelected(false);
/*  529 */       this.entiteSelect = null;
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean addBreakPoint(int x, int y)
/*      */   {
/*  535 */     boolean ajout = false;
/*  536 */     for (int i = 0; i < this.listeLien.size(); i++) {
/*  537 */       ajout = ((MLDLienEntite2)this.listeLien.get(i)).addBreakPoint(x, y);
/*  538 */       if (ajout) {
/*  539 */         ((MLDLienEntite2)this.listeLien.get(i)).setSelected(true);
/*  540 */         return ajout;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  545 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   public void mouseClicked(MouseEvent e) {}
/*      */   
/*      */ 
/*      */   public void mousePressed(MouseEvent e)
/*      */   {
/*  554 */     if (e.isControlDown()) {
/*  555 */       if ((e.getButton() == 1) && 
/*  556 */         (e.getClickCount() == 2)) {
/*  557 */         remiseANullLesSelectionner();
/*  558 */         setSelected(false);
/*  559 */         if (addBreakPoint((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom))) {
/*  560 */           repaint();
/*  561 */           setIsMLDModifier(true);
/*  562 */           return;
/*      */         }
/*  564 */         repaint();
/*  565 */         return;
/*      */       }
/*      */       
/*  568 */       return;
/*      */     }
/*      */     
/*  571 */     if (e.getButton() == 1) {
/*  572 */       if (e.getClickCount() == 2) {
/*  573 */         setSelected(false);
/*  574 */         repaint();
/*  575 */         this.entiteSelect = isSelected((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/*  576 */         if (this.entiteSelect != null) {
/*  577 */           this.entiteSelect.setSelected(true);
/*  578 */           new FormeMLDEntite2(this.frm, this, this.entiteSelect, true).setVisible(true);
/*      */         } else {
/*  580 */           this.lienSel = isSelectedLien((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/*  581 */           if (this.lienSel != null) {
/*  582 */             new FormeMLDLien2(this.frm, this, this.lienSel, true).setVisible(true);
/*  583 */             repaint();
/*      */           }
/*      */         }
/*      */       } else {
/*  587 */         desactiverAllLien();
/*  588 */         if (!estDansGroupe((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom))) {
/*  589 */           setSelected(false);
/*  590 */           this.modeSelect = true;
/*  591 */           repaint();
/*  592 */           this.entiteSelect = isSelected((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/*  593 */           if (this.entiteSelect != null) {
/*  594 */             this.entiteSelect.setSelected(true);
/*  595 */             activerAllLien(this.entiteSelect);
/*  596 */             repaint();
/*  597 */             this.modeSelect = false;
/*  598 */             setCursor(new Cursor(13));
/*  599 */             this.Sx = ((int)(e.getX() / this.zoom) - this.entiteSelect.getX());
/*  600 */             this.Sy = ((int)(e.getY() / this.zoom) - this.entiteSelect.getY());
/*      */           } else {
/*  602 */             this.lienSel = isSelectedLien((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/*  603 */             if (this.lienSel != null) {
/*  604 */               this.lienSel.setSelected(true);
/*  605 */               this.pointSel = selectedPointCassure((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), this.lienSel);
/*  606 */               if (this.pointSel != null) {
/*  607 */                 this.lienSel.setSelected(false);
/*  608 */                 this.pointSel.setSelected(true);
/*  609 */                 setCursor(new Cursor(5));
/*  610 */                 this.Sx = ((int)(e.getX() / this.zoom) - this.pointSel.getX());
/*  611 */                 this.Sy = ((int)(e.getY() / this.zoom) - this.pointSel.getY());
/*      */               }
/*  613 */               repaint();
/*  614 */               this.modeSelect = false;
/*  615 */               setCursor(new Cursor(13));
/*      */             }
/*      */             else
/*      */             {
/*  619 */               this.Sx = ((int)(e.getX() / this.zoom));
/*  620 */               this.Sy = ((int)(e.getY() / this.zoom));
/*  621 */               this.Fx = this.Sx;
/*  622 */               this.Fy = this.Sy;
/*      */             }
/*      */           }
/*      */         }
/*      */         else {
/*  627 */           this.xgroupe = ((int)(e.getX() / this.zoom));
/*  628 */           this.ygroupe = ((int)(e.getY() / this.zoom));
/*  629 */           this.modeSelect = false;
/*      */         }
/*      */       }
/*      */     }
/*  633 */     majPanelLoupe();
/*      */   }
/*      */   
/*      */   public void mouseReleased(MouseEvent e) {
/*  637 */     setCursor(new Cursor(0));
/*      */     
/*  639 */     if (this.modeSelect) {
/*  640 */       setSelectCollection(this.Sx, this.Sy, this.Fx, this.Fy);
/*  641 */       this.Fx = this.Sx;
/*  642 */       this.Fy = this.Sy;
/*  643 */       this.modeSelect = false;
/*  644 */       repaint();
/*      */     }
/*      */     
/*  647 */     majPanelLoupe();
/*      */   }
/*      */   
/*      */ 
/*      */   public void mouseEntered(MouseEvent e) {}
/*      */   
/*      */ 
/*      */   public void mouseExited(MouseEvent e) {}
/*      */   
/*      */ 
/*      */   public void mouseDragged(MouseEvent e)
/*      */   {
/*  659 */     if ((estDansGroupe((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom))) && (this.entiteSelect == null) && (this.lienSel == null) && (this.pointSel == null)) {
/*  660 */       deplacerGroupe(this.xgroupe - (int)(e.getX() / this.zoom), (int)(this.ygroupe - e.getY() / this.zoom));
/*  661 */       this.xgroupe = ((int)(e.getX() / this.zoom));
/*  662 */       this.ygroupe = ((int)(e.getY() / this.zoom));
/*  663 */       this.modeSelect = false;
/*  664 */       setIsMLDModifier(true);
/*  665 */       repaint();
/*      */     }
/*      */     else {
/*  668 */       if (this.entiteSelect != null) {
/*  669 */         this.entiteSelect.redimentionner((int)(e.getX() / this.zoom) - this.Sx, (int)(e.getY() / this.zoom) - this.Sy, this.entiteSelect.getWidth(), this.entiteSelect.getHeight());
/*  670 */         scrollRectToVisible(new Rectangle(e.getX(), e.getY(), 1, 1));
/*  671 */         setIsMLDModifier(true);
/*  672 */         repaint();
/*      */       }
/*  674 */       if ((this.lienSel != null) && 
/*  675 */         (this.pointSel != null)) {
/*  676 */         if (possibleDeplacer((int)(e.getX() / this.zoom) - this.Sx, (int)(e.getY() / this.zoom) - this.Sy))
/*  677 */           this.pointSel.move((int)(e.getX() / this.zoom) - this.Sx, (int)(e.getY() / this.zoom) - this.Sy);
/*  678 */         setIsMLDModifier(true);
/*  679 */         repaint();
/*  680 */         scrollRectToVisible(new Rectangle(e.getX(), e.getY(), 1, 1));
/*      */       }
/*      */       
/*      */ 
/*  684 */       if ((this.entiteSelect == null) && (this.lienSel == null)) {
/*  685 */         this.Fx = ((int)(e.getX() / this.zoom));
/*  686 */         this.Fy = ((int)(e.getY() / this.zoom));
/*  687 */         setSelectCollection(this.Sx, this.Sy, this.Fx, this.Fy);
/*  688 */         repaint();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void mouseMoved(MouseEvent e) {
/*  694 */     if (estDansGroupe(e.getX(), e.getY())) {
/*  695 */       this.xgroupe = ((int)(e.getX() / this.zoom));
/*  696 */       this.ygroupe = ((int)(e.getY() / this.zoom));
/*  697 */       setCursor(new Cursor(13));
/*      */     }
/*      */     else {
/*  700 */       setCursor(new Cursor(0));
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean possibleDeplacer(int x, int y)
/*      */   {
/*  706 */     if (x < 0) return false;
/*  707 */     if (y < 0) { return false;
/*      */     }
/*  709 */     return true;
/*      */   }
/*      */   
/*      */   public void effacerAllEntite() {
/*  713 */     this.formeMLD.getRacineMLD().removeAllChildren();
/*  714 */     if (this.listeLien != null) {
/*  715 */       this.listeLien.clear();
/*  716 */       setIsMLDModifier(true);
/*      */     }
/*  718 */     if (this.listeMLDEntite != null) {
/*  719 */       this.listeMLDEntite.clear();
/*  720 */       setIsMLDModifier(true);
/*      */     }
/*  722 */     this.listeCadre.clear();
/*  723 */     this.listeCommentaire.clear();
/*  724 */     this.listeEntRelContrainte.clear();
/*  725 */     this.listeLienCommentaire.clear();
/*      */     
/*  727 */     this.frm.getExplorer().getTree().updateUI();
/*  728 */     repaint();
/*      */   }
/*      */   
/*      */   public double getZoom() {
/*  732 */     return this.zoom;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isMutex()
/*      */   {
/*  740 */     return this.mutex;
/*      */   }
/*      */   
/*      */   public void setMutex(boolean mutex) {
/*  744 */     this.mutex = mutex;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setZoom(double zoom)
/*      */   {
/*  752 */     this.zoom = zoom;
/*      */   }
/*      */   
/*      */   public void setClPage(Color clPage) {
/*  756 */     this.clPage = clPage;
/*      */   }
/*      */   
/*      */   public boolean isEntiteModifer() {
/*  760 */     return this.entiteModifer;
/*      */   }
/*      */   
/*      */   public void setEntiteModifer(boolean entiteModifer) {
/*  764 */     this.entiteModifer = entiteModifer;
/*  765 */     if (entiteModifer) {
/*  766 */       this.frm.getFormeMCD().setModifier(true);
/*      */     }
/*      */   }
/*      */   
/*      */   public void supprimerLesPointDeCassure() {
/*  771 */     if (JOptionPane.showConfirmDialog(this.frm, "Voulez-vous supprimer les points de cassure sélectionnés ?", "Suppression", 0) == 0) {
/*  772 */       for (int i = 0; i < this.listeLien.size(); i++) {
/*  773 */         ((MLDLienEntite2)this.listeLien.get(i)).supprimerPointDeCassureSelcted();
/*      */       }
/*      */     }
/*  776 */     repaint();
/*      */   }
/*      */   
/*      */   public void keyTyped(KeyEvent e)
/*      */   {
/*  781 */     JOptionPane.showConfirmDialog(this, "Voulez-vous supprimer les points de cassure sélectionnés ?", "keyTyped", 0);
/*      */   }
/*      */   
/*      */   public void keyPressed(KeyEvent e)
/*      */   {
/*  786 */     JOptionPane.showConfirmDialog(this, "Voulez-vous supprimer les points de cassure sélectionnés ?", "keyPressed", 0);
/*  787 */     if (e.getKeyCode() == 127) {
/*  788 */       supprimerLesPointDeCassure();
/*      */     }
/*      */     
/*  791 */     int dep = 1;
/*  792 */     if (e.isControlDown()) dep = 15; else {
/*  793 */       dep = 1;
/*      */     }
/*      */     
/*  796 */     if (e.getKeyCode() == 40) {
/*  797 */       deplacerGroupe(0, -1 * dep);
/*      */       
/*      */ 
/*  800 */       repaint();
/*      */     }
/*  802 */     if (e.getKeyCode() == 38) {
/*  803 */       deplacerGroupe(0, 1 * dep);
/*      */       
/*  805 */       repaint();
/*      */     }
/*  807 */     if (e.getKeyCode() == 39) {
/*  808 */       deplacerGroupe(-1 * dep, 0);
/*  809 */       repaint();
/*      */     }
/*  811 */     if (e.getKeyCode() == 37) {
/*  812 */       deplacerGroupe(1 * dep, 0);
/*      */       
/*  814 */       repaint();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void keyReleased(KeyEvent e)
/*      */   {
/*  821 */     JOptionPane.showConfirmDialog(this, "Voulez-vous supprimer les points de cassure sélectionnés ?", "keyReleased", 0);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setNomAllcontrainte()
/*      */   {
/*  829 */     for (int i = 0; i < this.listeMLDEntite.size(); i++) {
/*  830 */       ((MLDEntite2)this.listeMLDEntite.get(i)).setNomContraintes();
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isPageVide() {
/*  835 */     if (this.listeMLDEntite.size() > 0) return false;
/*  836 */     if (this.listeLien.size() > 0) return false;
/*  837 */     return true;
/*      */   }
/*      */   
/*      */   public int getFx() {
/*  841 */     return this.Fx;
/*      */   }
/*      */   
/*      */   public int getFy() {
/*  845 */     return this.Fy;
/*      */   }
/*      */   
/*      */   public int getSx() {
/*  849 */     return this.Sx;
/*      */   }
/*      */   
/*      */   public int getSy() {
/*  853 */     return this.Sy;
/*      */   }
/*      */   
/*      */   public Color getClPage() {
/*  857 */     return this.clPage;
/*      */   }
/*      */   
/*      */   public Color getClPetitCareau() {
/*  861 */     return this.clPetitCareau;
/*      */   }
/*      */   
/*      */   public MLDEntite2 getEntiteSelect() {
/*  865 */     return this.entiteSelect;
/*      */   }
/*      */   
/*      */   public Color getFillColor() {
/*  869 */     return this.fillColor;
/*      */   }
/*      */   
/*      */   public FormeInterneMLD getFormeMLD() {
/*  873 */     return this.formeMLD;
/*      */   }
/*      */   
/*      */   public Principale getFrm() {
/*  877 */     return this.frm;
/*      */   }
/*      */   
/*      */   public Grid getGrid() {
/*  881 */     return this.grid;
/*      */   }
/*      */   
/*      */   public MLDLienEntite2 getLienSel() {
/*  885 */     return this.lienSel;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmCadre> getListeCadre() {
/*  889 */     return this.listeCadre;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmCommentaireIndip> getListeCommentaire() {
/*  893 */     return this.listeCommentaire;
/*      */   }
/*      */   
/*      */   public ArrayList<EntiteRelationContrainte2> getListeEntRelContrainte() {
/*  897 */     return this.listeEntRelContrainte;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmLienCommentaire> getListeLienCommentaire() {
/*  901 */     return this.listeLienCommentaire;
/*      */   }
/*      */   
/*      */   public Map<MLDLienEntite2, String> getListeLienDouble() {
/*  905 */     return this.listeLienDouble;
/*      */   }
/*      */   
/*      */   public boolean isModeSelect() {
/*  909 */     return this.modeSelect;
/*      */   }
/*      */   
/*      */   public IhmPoint getPointSel() {
/*  913 */     return this.pointSel;
/*      */   }
/*      */   
/*      */   public Color getStrokeColor() {
/*  917 */     return this.strokeColor;
/*      */   }
/*      */   
/*      */   public int getxSelectedMax() {
/*  921 */     return this.xSelectedMax;
/*      */   }
/*      */   
/*      */   public int getxSelectedMin() {
/*  925 */     return this.xSelectedMin;
/*      */   }
/*      */   
/*      */   public int getXgroupe() {
/*  929 */     return this.xgroupe;
/*      */   }
/*      */   
/*      */   public int getySelectedMax() {
/*  933 */     return this.ySelectedMax;
/*      */   }
/*      */   
/*      */   public int getySelectedMin() {
/*  937 */     return this.ySelectedMin;
/*      */   }
/*      */   
/*      */   public int getYgroupe() {
/*  941 */     return this.ygroupe;
/*      */   }
/*      */   
/*      */   public void setFx(int Fx) {
/*  945 */     this.Fx = Fx;
/*      */   }
/*      */   
/*      */   public void setFy(int Fy) {
/*  949 */     this.Fy = Fy;
/*      */   }
/*      */   
/*      */   public void setSx(int Sx) {
/*  953 */     this.Sx = Sx;
/*      */   }
/*      */   
/*      */   public void setSy(int Sy) {
/*  957 */     this.Sy = Sy;
/*      */   }
/*      */   
/*      */   public void setClPetitCareau(Color clPetitCareau) {
/*  961 */     this.clPetitCareau = clPetitCareau;
/*      */   }
/*      */   
/*      */   public void setEntiteSelect(MLDEntite2 entiteSelect) {
/*  965 */     this.entiteSelect = entiteSelect;
/*      */   }
/*      */   
/*      */   public void setFillColor(Color fillColor) {
/*  969 */     this.fillColor = fillColor;
/*      */   }
/*      */   
/*      */   public void setFormeMLD(FormeInterneMLD formeMLD) {
/*  973 */     this.formeMLD = formeMLD;
/*      */   }
/*      */   
/*      */   public void setFrm(Principale frm) {
/*  977 */     this.frm = frm;
/*      */   }
/*      */   
/*      */   public void setGrid(Grid grid) {
/*  981 */     this.grid = grid;
/*      */   }
/*      */   
/*      */   public void setLienSel(MLDLienEntite2 lienSel) {
/*  985 */     this.lienSel = lienSel;
/*      */   }
/*      */   
/*      */   public void setListeCadre(ArrayList<IhmCadre> listeCadre) {
/*  989 */     this.listeCadre = listeCadre;
/*      */   }
/*      */   
/*      */   public void setListeCommentaire(ArrayList<IhmCommentaireIndip> listeCommentaire) {
/*  993 */     this.listeCommentaire = listeCommentaire;
/*      */   }
/*      */   
/*      */   public void setListeEntRelContrainte(ArrayList<EntiteRelationContrainte2> listeEntRelContrainte) {
/*  997 */     this.listeEntRelContrainte = listeEntRelContrainte;
/*      */   }
/*      */   
/*      */   public void setListeLienCommentaire(ArrayList<IhmLienCommentaire> listeLienCommentaire) {
/* 1001 */     this.listeLienCommentaire = listeLienCommentaire;
/*      */   }
/*      */   
/*      */   public void setListeLienDouble(Map<MLDLienEntite2, String> listeLienDouble) {
/* 1005 */     this.listeLienDouble = listeLienDouble;
/*      */   }
/*      */   
/*      */   public void setModeSelect(boolean modeSelect) {
/* 1009 */     this.modeSelect = modeSelect;
/*      */   }
/*      */   
/*      */   public void setPointSel(IhmPoint pointSel) {
/* 1013 */     this.pointSel = pointSel;
/*      */   }
/*      */   
/*      */   public void setStrokeColor(Color strokeColor) {
/* 1017 */     this.strokeColor = strokeColor;
/*      */   }
/*      */   
/*      */   public void setxSelectedMax(int xSelectedMax) {
/* 1021 */     this.xSelectedMax = xSelectedMax;
/*      */   }
/*      */   
/*      */   public void setxSelectedMin(int xSelectedMin) {
/* 1025 */     this.xSelectedMin = xSelectedMin;
/*      */   }
/*      */   
/*      */   public void setXgroupe(int xgroupe) {
/* 1029 */     this.xgroupe = xgroupe;
/*      */   }
/*      */   
/*      */   public void setySelectedMax(int ySelectedMax) {
/* 1033 */     this.ySelectedMax = ySelectedMax;
/*      */   }
/*      */   
/*      */   public void setySelectedMin(int ySelectedMin) {
/* 1037 */     this.ySelectedMin = ySelectedMin;
/*      */   }
/*      */   
/*      */   public void setYgroupe(int ygroupe) {
/* 1041 */     this.ygroupe = ygroupe;
/*      */   }
/*      */   
/*      */   public boolean isIsMLDModifier() {
/* 1045 */     return this.isMLDModifier;
/*      */   }
/*      */   
/*      */   public void setIsMLDModifier(boolean isMLDModifier) {
/* 1049 */     this.isMLDModifier = isMLDModifier;
/* 1050 */     if (isMLDModifier) {
/* 1051 */       this.frm.getFormeMCD().setModifier(true);
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMLD\IhmPageMLD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */