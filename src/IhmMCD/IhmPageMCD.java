/*      */ package IhmMCD;
/*      */ 
/*      */ import IhmMCD2.ConfigurationMCD2;
/*      */ import IhmMCD2.IhmCIF2;
/*      */ import IhmMCD2.IhmCadre2;
/*      */ import IhmMCD2.IhmCardinalite;
/*      */ import IhmMCD2.IhmCommentaire2;
/*      */ import IhmMCD2.IhmContrainte2;
/*      */ import IhmMCD2.IhmEntite2;
/*      */ import IhmMCD2.IhmHeritage2;
/*      */ import IhmMCD2.IhmLien2;
/*      */ import IhmMCD2.IhmLienCIF2;
/*      */ import IhmMCD2.IhmLienCommentaire2;
/*      */ import IhmMCD2.IhmLienContrainteHeritage2;
/*      */ import IhmMCD2.IhmLienContraintes2;
/*      */ import IhmMCD2.IhmLienHeritage2;
/*      */ import IhmMCD2.IhmPoint;
/*      */ import IhmMCD2.IhmPostIt2;
/*      */ import IhmMCD2.IhmProprieteMCD2;
/*      */ import IhmMCD2.IhmRelation2;
/*      */ import IhmMLD.IhmPageMLD;
/*      */ import LibraryPan.Library;
/*      */ import LibraryPan.PanelEntiteRelation;
/*      */ import MenuPop.MenuPopPageMCD;
/*      */ import Merise.Attribut;
/*      */ import Merise.Domaine;
/*      */ import Merise.Entite;
/*      */ import Merise.Relation;
/*      */ import Merise2.Attribut2;
/*      */ import Merise2.Entite2;
/*      */ import Merise2.Relation2;
/*      */ import MyExplorer.ExplorerPan;
/*      */ import MyExplorer.NodeRootEntite;
/*      */ import Outil.ConfigSave;
/*      */ import Outil.Parametres;
/*      */ import Outil.ProprieteMCD;
/*      */ import Outil.Setting;
/*      */ import formes.FormeLienHeritageIndep;
/*      */ import formes.FormePostIt;
/*      */ import formes.PanelLoupe;
/*      */ import formes2.FormeCIF2;
/*      */ import formes2.FormeCadre2;
/*      */ import formes2.FormeCardinalite2;
/*      */ import formes2.FormeCommentaire2;
/*      */ import formes2.FormeContrainte2;
/*      */ import formes2.FormeContrainteHeritage2;
/*      */ import formes2.FormeEntite2;
/*      */ import formes2.FormeLienCif2;
/*      */ import formes2.FormeLienCommentaire2;
/*      */ import formes2.FormeLienContraintes2;
/*      */ import formes2.FormeLienHeritageContrainte2;
/*      */ import formes2.FormeProprieteMCD2;
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
/*      */ import java.awt.datatransfer.DataFlavor;
/*      */ import java.awt.datatransfer.Transferable;
/*      */ import java.awt.datatransfer.UnsupportedFlavorException;
/*      */ import java.awt.dnd.DropTargetDragEvent;
/*      */ import java.awt.dnd.DropTargetDropEvent;
/*      */ import java.awt.dnd.DropTargetEvent;
/*      */ import java.awt.dnd.DropTargetListener;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.KeyListener;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.MouseListener;
/*      */ import java.awt.event.MouseMotionListener;
/*      */ import java.awt.event.MouseWheelEvent;
/*      */ import java.awt.event.MouseWheelListener;
/*      */ import java.awt.geom.Rectangle2D;
/*      */ import java.awt.geom.Rectangle2D.Double;
/*      */ import java.awt.print.PrinterException;
/*      */ import java.awt.print.PrinterJob;
/*      */ import java.beans.PropertyVetoException;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.io.Serializable;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ import javax.print.attribute.HashPrintRequestAttributeSet;
/*      */ import javax.print.attribute.standard.OrientationRequested;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JToggleButton;
/*      */ import javax.swing.JTree;
/*      */ import mythread.ThreadOuvrir;
/*      */ import verificationAdaptation.VerifHeritageLienRelatif;
/*      */ 
/*      */ public class IhmPageMCD extends JPanel implements DropTargetListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener, Serializable
/*      */ {
/*      */   private ArrayList<IhmEntiteRelation> listeEntiteRelation;
/*      */   private ArrayList<IhmLien> listeLien;
/*      */   private ArrayList<IhmCIF> listeCIF;
/*      */   private ArrayList<IhmCadre> listeCadre;
/*      */   private ArrayList<IhmLienCif> listelienCIF;
/*      */   private ArrayList<IhmCommentaireIndip> listeCommentaire;
/*      */   private ArrayList<IhmLienCommentaire> listeLienCommentaire;
/*      */   private ArrayList<IhmHeritage> listeHeritage;
/*      */   private ArrayList<IhmLienHeritage> listeLienHeritage;
/*      */   private ArrayList<IhmEntiteRelation> listeContrainte;
/*      */   private ArrayList<IhmLienContrainteHeritage> listeLienContrainteHeritage;
/*      */   private ArrayList<IhmLienContraintes> listeLienContrainte;
/*      */   private ArrayList<Attribut> listeAttribut;
/*      */   private ArrayList<Domaine> listeDomaine;
/*      */   private IhmEntite entiteSel;
/*      */   private IhmRelation relationSel;
/*      */   public IhmEntiteRelation entRelaSelect;
/*      */   public IhmEntiteRelation entRelaSelect1;
/*      */   public IhmEntiteRelation entRelaSelect2;
/*      */   private IhmCIF cifSelect;
/*      */   private IhmCadre cadreSelect;
/*      */   private IhmCommentaireIndip commSelect;
/*      */   private IhmLienCommentaire lienCommSelect;
/*      */   private IhmLienCif lienCifSel;
/*      */   private IhmHeritage heritageSelect;
/*      */   private IhmLienHeritage lienHeritageSel;
/*      */   private IhmLienContrainteHeritage lienContrHeritageSel;
/*      */   private IhmLienContraintes lienContrSel;
/*      */   private IhmEntiteRelation contrainteSel;
/*      */   private IhmLien lienSel;
/*      */   private IhmPoint pointSel;
/*      */   private BarOutil bar;
/*      */   private int Sx;
/*      */   private int Sy;
/*      */   private int Fx;
/*      */   private int Fy;
/*      */   private Principale frm;
/*      */   private StatutBar statuBar;
/*      */   private boolean modeSelect;
/*      */   private boolean debutLien;
/*      */   private MenuPopPageMCD popMenu;
/*      */   private int coteAggrandir;
/*      */   private boolean agrandir;
/*      */   private int x0Souris;
/*      */   private int y0souris;
/*      */   private boolean CTRLButton;
/*      */   private boolean EntiteKey;
/*      */   private boolean relationKey;
/*      */   private boolean LIENKey;
/*      */   private boolean cifKey;
/*      */   private boolean contrainteKey;
/*      */   private int xSelectedMin;
/*      */   private int ySelectedMin;
/*      */   private int xSelectedMax;
/*      */   private int ySelectedMax;
/*      */   private int xgroupe;
/*      */   private int ygroupe;
/*      */   private Grid grid;
/*      */   private boolean boutonGauch;
/*      */   private ArrayList<IhmEntiteRelation> listeGrpSelect;
/*      */   private Map<IhmLien, String> listeLienDouble;
/*  167 */   protected Color fillColor = new Color(175, 203, 229, 90);
/*      */   
/*  169 */   protected Color strokeColor = Color.BLUE;
/*      */   
/*      */   private FormeInterneMCD frmMcd;
/*      */   
/*      */   private ProprieteMCD proprieteMCD;
/*      */   
/*      */   private IhmProprieteMCD ihmProprieteMCD;
/*      */   
/*      */   public IhmProprieteMCD2 ihmProprieteMCD2;
/*      */   ConfigurationMCD2 configurationMCD;
/*      */   public double zoom;
/*      */   public Color clPage;
/*      */   public Color clPetitCareau;
/*      */   
/*      */   public IhmPageMCD(BarOutil bar, Principale frm, FormeInterneMCD frmmcd, StatutBar statuBar)
/*      */   {
/*  185 */     setBackground(Color.white);
/*  186 */     this.clPetitCareau = new Color(220, 220, 255);
/*  187 */     this.frmMcd = frmmcd;
/*      */     
/*  189 */     addMouseListener(this);
/*  190 */     addMouseMotionListener(this);
/*  191 */     addMouseWheelListener(this);
/*      */     
/*  193 */     addKeyListener(this);
/*  194 */     this.listeEntiteRelation = new ArrayList();
/*  195 */     this.listeLien = new ArrayList();
/*  196 */     this.listeCIF = new ArrayList();
/*  197 */     this.listeCadre = new ArrayList();
/*  198 */     this.listelienCIF = new ArrayList();
/*      */     
/*  200 */     this.listeCommentaire = new ArrayList();
/*  201 */     this.listeLienCommentaire = new ArrayList();
/*  202 */     this.listeHeritage = new ArrayList();
/*  203 */     this.listeLienHeritage = new ArrayList();
/*      */     
/*  205 */     this.listeContrainte = new ArrayList();
/*  206 */     this.listeLienContrainte = new ArrayList();
/*  207 */     this.listeAttribut = new ArrayList();
/*  208 */     this.listeDomaine = new ArrayList();
/*  209 */     this.listeLienContrainteHeritage = new ArrayList();
/*  210 */     this.listeGrpSelect = new ArrayList();
/*      */     
/*  212 */     this.contrainteSel = null;
/*  213 */     this.lienContrHeritageSel = null;
/*  214 */     this.lienHeritageSel = null;
/*  215 */     this.lienContrSel = null;
/*  216 */     this.heritageSelect = null;
/*  217 */     this.relationSel = null;
/*  218 */     this.cadreSelect = null;
/*  219 */     this.entRelaSelect = null;
/*  220 */     this.entRelaSelect1 = null;
/*  221 */     this.entRelaSelect2 = null;
/*  222 */     this.cifSelect = null;
/*  223 */     this.commSelect = null;
/*  224 */     this.lienCommSelect = null;
/*  225 */     this.lienCifSel = null;
/*  226 */     this.lienSel = null;
/*  227 */     this.pointSel = null;
/*  228 */     this.proprieteMCD = new ProprieteMCD(Setting.developpeur == null ? "" : Setting.developpeur);
/*  229 */     this.listeLienDouble = new HashMap();
/*  230 */     this.ihmProprieteMCD = new IhmProprieteMCD(this.proprieteMCD, frmmcd);
/*  231 */     this.Sx = 0;
/*  232 */     this.Sy = 0;
/*      */     
/*  234 */     this.bar = bar;
/*  235 */     this.frm = frm;
/*  236 */     this.statuBar = statuBar;
/*  237 */     setAutoscrolls(true);
/*      */     
/*      */ 
/*  240 */     this.modeSelect = false;
/*      */     
/*  242 */     this.debutLien = true;
/*  243 */     this.popMenu = new MenuPopPageMCD(this);
/*      */     
/*  245 */     add(this.popMenu);
/*  246 */     this.coteAggrandir = -1;
/*  247 */     this.CTRLButton = false;
/*  248 */     this.EntiteKey = false;
/*  249 */     this.relationKey = false;
/*  250 */     this.LIENKey = false;
/*  251 */     this.cifKey = false;
/*  252 */     this.contrainteKey = false;
/*      */     
/*  254 */     this.grid = new Grid(getWidth(), getHeight(), 1);
/*  255 */     this.boutonGauch = false;
/*  256 */     this.zoom = FormeInterneMCD.zoom;
/*      */     
/*  258 */     this.clPage = FormeInterneMCD.clPage2;
/*  259 */     this.configurationMCD = new ConfigurationMCD2(Parametres.version, Setting.developpeur);
/*  260 */     setConfigurationMCD(this.frmMcd.miseAjourParametreMCD(this.configurationMCD));
/*  261 */     this.ihmProprieteMCD2 = new IhmProprieteMCD2(this.configurationMCD, true);
/*      */   }
/*      */   
/*      */ 
/*      */   protected void paintComponent(Graphics gr)
/*      */   {
/*  267 */     Graphics2D g = (Graphics2D)gr;
/*      */     
/*      */ 
/*  270 */     int x = 0;int y = 0;
/*      */     
/*  272 */     g.setFont(Parametres.fontNormal);
/*      */     
/*  274 */     g.setColor(this.clPage);
/*  275 */     g.fillRect(0, 0, getSize().width, getSize().height);
/*      */     
/*      */ 
/*  278 */     if (this.bar.isAfficheRegle()) {
/*  279 */       setClPage(Color.WHITE);
/*  280 */       g.setColor(Color.WHITE);
/*  281 */       g.fillRect(0, 0, getSize().width, getSize().height);
/*  282 */       if (Setting.petitCarreau) { afficherGrille(g);
/*      */       } else {
/*  284 */         Graphics2D g2 = g;
/*  285 */         g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*  286 */         this.grid = new Grid(getSize().width, getSize().height, 1);
/*  287 */         this.grid.drawGrid(g2);
/*      */       }
/*      */     } else {
/*  290 */       setClPage(this.clPage);
/*      */     }
/*  292 */     g.scale(this.zoom, this.zoom);
/*  293 */     g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
/*      */     
/*  295 */     if (this.listeCadre == null) return;
/*  296 */     for (int i = 0; i < this.listeCadre.size(); i++) {
/*  297 */       ((IhmCadre)this.listeCadre.get(i)).paint(g);
/*  298 */       if (x < ((IhmCadre)this.listeCadre.get(i)).getX() + ((IhmCadre)this.listeCadre.get(i)).getWidth())
/*  299 */         x = ((IhmCadre)this.listeCadre.get(i)).getX() + ((IhmCadre)this.listeCadre.get(i)).getWidth();
/*  300 */       if (y < ((IhmCadre)this.listeCadre.get(i)).getY() + ((IhmCadre)this.listeCadre.get(i)).getHeight()) {
/*  301 */         y = ((IhmCadre)this.listeCadre.get(i)).getY() + ((IhmCadre)this.listeCadre.get(i)).getHeight();
/*      */       }
/*      */     }
/*  304 */     if ((this.bar.getEtat().equals("LIEN")) && (this.entRelaSelect1 != null)) {
/*  305 */       g.setColor(Color.RED);
/*  306 */       dessinerLien(g);
/*  307 */       scrollRectToVisible(new Rectangle(this.Fx, this.Fy, 1, 1));
/*      */     }
/*      */     
/*  310 */     if ((this.bar.getEtat().equals("RIEN")) && (this.entRelaSelect1 != null) && (this.LIENKey)) {
/*  311 */       g.setColor(Color.RED);
/*  312 */       dessinerLien(g);
/*  313 */       scrollRectToVisible(new Rectangle(this.Fx, this.Fy, 1, 1));
/*      */     }
/*      */     
/*      */ 
/*  317 */     if (this.listeLien == null) return;
/*  318 */     for (int i = 0; i < this.listeLien.size(); i++)
/*      */     {
/*  320 */       ((IhmLien)this.listeLien.get(i)).paint(g);
/*  321 */       int xxx = ((IhmLien2)this.listeLien.get(i)).XMaxAllPoint();
/*  322 */       int yyy = ((IhmLien2)this.listeLien.get(i)).YMaxAllPoint();
/*  323 */       if (xxx > x) x = xxx;
/*  324 */       if (yyy > y) { y = yyy;
/*      */       }
/*      */     }
/*  327 */     if (this.listeLienContrainte == null) return;
/*  328 */     for (int i = 0; i < this.listeLienContrainte.size(); i++)
/*      */     {
/*  330 */       ((IhmLienContraintes)this.listeLienContrainte.get(i)).paint(g);
/*  331 */       int xxx = ((IhmLienContraintes2)this.listeLienContrainte.get(i)).XMaxAllPoint();
/*  332 */       int yyy = ((IhmLienContraintes2)this.listeLienContrainte.get(i)).YMaxAllPoint();
/*  333 */       if (xxx > x) x = xxx;
/*  334 */       if (yyy > y) { y = yyy;
/*      */       }
/*      */     }
/*  337 */     if (this.listeLienCommentaire == null) return;
/*  338 */     for (int i = 0; i < this.listeLienCommentaire.size(); i++) {
/*  339 */       ((IhmLienCommentaire)this.listeLienCommentaire.get(i)).paint(g);
/*  340 */       if ((this.listeLienCommentaire.get(i) instanceof IhmLienCommentaire2)) {
/*  341 */         int xxx = ((IhmLienCommentaire2)this.listeLienCommentaire.get(i)).XMaxAllPoint();
/*  342 */         int yyy = ((IhmLienCommentaire2)this.listeLienCommentaire.get(i)).YMaxAllPoint();
/*  343 */         if (xxx > x) x = xxx;
/*  344 */         if (yyy > y) { y = yyy;
/*      */         }
/*      */       }
/*      */     }
/*  348 */     dessinerHeritageEtContrainte(g);
/*  349 */     for (int i = 0; i < this.listeLienContrainteHeritage.size(); i++) {
/*  350 */       int xxx = ((IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(i)).XMaxAllPoint();
/*  351 */       int yyy = ((IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(i)).YMaxAllPoint();
/*  352 */       if (xxx > x) x = xxx;
/*  353 */       if (yyy > y) { y = yyy;
/*      */       }
/*      */     }
/*  356 */     for (int i = 0; i < this.listeHeritage.size(); i++) {
/*  357 */       if (x < ((IhmHeritage)this.listeHeritage.get(i)).getX() + ((IhmHeritage)this.listeHeritage.get(i)).getWidth())
/*  358 */         x = ((IhmHeritage)this.listeHeritage.get(i)).getX() + ((IhmHeritage)this.listeHeritage.get(i)).getWidth();
/*  359 */       if (y < ((IhmHeritage)this.listeHeritage.get(i)).getY() + ((IhmHeritage)this.listeHeritage.get(i)).getHeight()) {
/*  360 */         y = ((IhmHeritage)this.listeHeritage.get(i)).getY() + ((IhmHeritage)this.listeHeritage.get(i)).getHeight();
/*      */       }
/*      */     }
/*      */     
/*  364 */     if (this.listelienCIF == null) return;
/*  365 */     for (int i = 0; i < this.listelienCIF.size(); i++) {
/*  366 */       ((IhmLienCif)this.listelienCIF.get(i)).paint(g);
/*  367 */       int xxx = ((IhmLienCIF2)this.listelienCIF.get(i)).XMaxAllPoint();
/*  368 */       int yyy = ((IhmLienCIF2)this.listelienCIF.get(i)).YMaxAllPoint();
/*  369 */       if (xxx > x) x = xxx;
/*  370 */       if (yyy > y) { y = yyy;
/*      */       }
/*      */     }
/*  373 */     if (this.listeEntiteRelation == null) return;
/*  374 */     for (int j = 0; j < this.listeEntiteRelation.size(); j++)
/*      */     {
/*      */ 
/*  377 */       ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).paint(g);
/*  378 */       if (x < ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getWidth())
/*  379 */         x = ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getWidth();
/*  380 */       if (y < ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getHeight()) {
/*  381 */         y = ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getHeight();
/*      */       }
/*      */     }
/*  384 */     if (this.listeCIF == null) return;
/*  385 */     for (int i = 0; i < this.listeCIF.size(); i++)
/*      */     {
/*      */ 
/*  388 */       ((IhmCIF)this.listeCIF.get(i)).paint(g);
/*  389 */       if (x < ((IhmCIF)this.listeCIF.get(i)).getX() + ((IhmCIF)this.listeCIF.get(i)).getWidth())
/*  390 */         x = ((IhmCIF)this.listeCIF.get(i)).getX() + ((IhmCIF)this.listeCIF.get(i)).getWidth();
/*  391 */       if (y < ((IhmCIF)this.listeCIF.get(i)).getY() + ((IhmCIF)this.listeCIF.get(i)).getHeight()) {
/*  392 */         y = ((IhmCIF)this.listeCIF.get(i)).getY() + ((IhmCIF)this.listeCIF.get(i)).getHeight();
/*      */       }
/*      */     }
/*  395 */     if (this.listeContrainte == null) return;
/*  396 */     for (int i = 0; i < this.listeContrainte.size(); i++)
/*      */     {
/*      */ 
/*  399 */       ((IhmEntiteRelation)this.listeContrainte.get(i)).paint(g);
/*  400 */       if (x < ((IhmEntiteRelation)this.listeContrainte.get(i)).getX() + ((IhmEntiteRelation)this.listeContrainte.get(i)).getWidth())
/*  401 */         x = ((IhmEntiteRelation)this.listeContrainte.get(i)).getX() + ((IhmEntiteRelation)this.listeContrainte.get(i)).getWidth();
/*  402 */       if (y < ((IhmEntiteRelation)this.listeContrainte.get(i)).getY() + ((IhmEntiteRelation)this.listeContrainte.get(i)).getHeight()) {
/*  403 */         y = ((IhmEntiteRelation)this.listeContrainte.get(i)).getY() + ((IhmEntiteRelation)this.listeContrainte.get(i)).getHeight();
/*      */       }
/*      */     }
/*  406 */     if (this.listeCommentaire == null) { return;
/*      */     }
/*  408 */     for (int i = 0; i < this.listeCommentaire.size(); i++) {
/*  409 */       if ((this.listeCommentaire.get(i) instanceof IhmCommentaire2)) {
/*  410 */         ((IhmCommentaireIndip)this.listeCommentaire.get(i)).setClDegradee(this.frm.isClDegradee());
/*      */       }
/*  412 */       ((IhmCommentaireIndip)this.listeCommentaire.get(i)).paint(g);
/*      */       
/*  414 */       if (x < ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getX() + ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getWidth())
/*  415 */         x = ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getX() + ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getWidth();
/*  416 */       if (y < ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getY() + ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getHeight()) {
/*  417 */         y = ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getY() + ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getHeight();
/*      */       }
/*      */     }
/*  420 */     for (int i = 0; i < this.listeHeritage.size(); i++)
/*      */     {
/*  422 */       ((IhmHeritage)this.listeHeritage.get(i)).paint(g);
/*      */     }
/*  424 */     dessinerPlussieursLiens(g);
/*      */     
/*  426 */     if (Setting.informProprieteMCD) this.ihmProprieteMCD2.paint(g);
/*  427 */     if (x * this.zoom > getWidth()) {
/*  428 */       setPreferredSize(new Dimension((int)(x * this.zoom) + 50, (int)(y * this.zoom) + 50));
/*  429 */       setSize((int)this.frm.getSize().getWidth(), (int)this.frm.getSize().getHeight());
/*      */     }
/*      */     
/*      */ 
/*  433 */     if (y * this.zoom > getHeight()) {
/*  434 */       setPreferredSize(new Dimension((int)(x * this.zoom) + 50, (int)(y * this.zoom) + 50));
/*  435 */       setSize((int)this.frm.getSize().getWidth(), (int)this.frm.getSize().getHeight());
/*      */     }
/*      */     
/*      */ 
/*  439 */     g.setColor(Color.ORANGE);
/*      */     
/*  441 */     if (this.modeSelect) {
/*  442 */       setSelected(false);
/*  443 */       dessinerCadreSelect(g);
/*      */     }
/*      */     
/*  446 */     if (this.CTRLButton) {
/*  447 */       for (int i = 0; i < this.listeGrpSelect.size(); i++) {
/*  448 */         ((IhmEntiteRelation)this.listeGrpSelect.get(i)).setSelected(true);
/*  449 */         ((IhmEntiteRelation)this.listeGrpSelect.get(i)).paint(g);
/*      */       }
/*      */     } else
/*  452 */       calculerXYSelected();
/*  453 */     g.scale(1.0D, 1.0D);
/*      */   }
/*      */   
/*      */   public void cacherAttribut(IhmEntite2 ent)
/*      */   {
/*  458 */     ent.setVariable(false);
/*  459 */     ent.setPrkvisible(false);
/*  460 */     ent.setOmbre(false);
/*  461 */     ent.setClDegradee(false);
/*  462 */     ent.setSelected(false);
/*  463 */     ent.setEpaisseur(FormeProprieteMCD2.EPAISSEUR_FIN);
/*  464 */     ent.setArrondir(true);
/*      */     
/*  466 */     int s = ent.getEntite().getListeAttributs().size();
/*  467 */     if ((s > 0) && (((Attribut2)ent.getEntite().getListeAttributs().get(0)).getListeAttributs().size() > 0)) {
/*  468 */       Attribut2 att = (Attribut2)ent.getEntite().getListeAttributs().get(0);
/*  469 */       att.setAfficher(false);
/*      */     }
/*  471 */     for (int i = 1; i < s; i++) {
/*  472 */       Attribut2 att = (Attribut2)ent.getEntite().getListeAttributs().get(i);
/*  473 */       att.setAfficher(false);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void cacherAttribut(IhmRelation2 rel)
/*      */   {
/*  483 */     rel.setVariable(false);
/*  484 */     rel.setOmbre(false);
/*  485 */     rel.setClDegradee(false);
/*  486 */     rel.setSelected(false);
/*      */     
/*  488 */     int s = rel.getRelation().getListeAttributs().size();
/*  489 */     rel.setEpaisseur(FormeProprieteMCD2.EPAISSEUR_FIN);
/*  490 */     rel.setPrkvisible(false);
/*  491 */     if ((s > 0) && (((Attribut2)rel.getRelation().getListeAttributs().get(0)).getListeAttributs().size() > 0)) {
/*  492 */       Attribut2 att = (Attribut2)rel.getRelation().getListeAttributs().get(0);
/*  493 */       att.setAfficher(false);
/*      */     }
/*  495 */     if ((s > 1) && (((Attribut2)rel.getRelation().getListeAttributs().get(1)).getListeAttributs().size() > 0)) {
/*  496 */       Attribut2 att = (Attribut2)rel.getRelation().getListeAttributs().get(1);
/*  497 */       att.setAfficher(false);
/*      */     }
/*      */     
/*  500 */     for (int i = 2; i < s; i++) {
/*  501 */       Attribut2 att = (Attribut2)rel.getRelation().getListeAttributs().get(i);
/*  502 */       att.setAfficher(false);
/*      */     }
/*      */   }
/*      */   
/*      */   public ArrayList<IhmEntiteRelation> getSelectedEntireRelationPourLibrairie()
/*      */   {
/*  508 */     ArrayList<IhmEntiteRelation> liste = new ArrayList();
/*  509 */     for (int i = 0; i < this.listeEntiteRelation.size(); i++) {
/*  510 */       if (((IhmEntiteRelation)this.listeEntiteRelation.get(i)).isSelected()) {
/*  511 */         if ((this.listeEntiteRelation.get(i) instanceof IhmEntite2)) {
/*  512 */           String nomEnt = ((IhmEntite2)this.listeEntiteRelation.get(i)).getEntite().getNom();
/*  513 */           if (this.frm.getPanLibibrary().getSelectedLibrary().existNumModel(nomEnt) >= 0) {
/*  514 */             if (JOptionPane.showConfirmDialog(this, "Entité " + nomEnt + " existe dans la librairie \nVoulez vous la remplacer ?", "Insertion Librairie ", 0) == 0) {
/*  515 */               IhmEntite2 ent = (IhmEntite2)((IhmEntite2)this.listeEntiteRelation.get(i)).copier();
/*  516 */               ent.setSelected(false);
/*  517 */               ent.setX(1);
/*  518 */               ent.setY(1);
/*  519 */               cacherAttribut(ent);
/*  520 */               liste.add(ent);
/*      */             }
/*      */           } else {
/*  523 */             IhmEntite2 ent = (IhmEntite2)((IhmEntite2)this.listeEntiteRelation.get(i)).copier();
/*  524 */             ent.setSelected(false);
/*  525 */             ent.setX(1);
/*  526 */             ent.setY(1);
/*  527 */             cacherAttribut(ent);
/*  528 */             ent.setNbUsedLibrairie(0);
/*  529 */             liste.add(ent);
/*      */           }
/*      */         }
/*  532 */         else if ((this.listeEntiteRelation.get(i) instanceof IhmRelation2)) {
/*  533 */           String nomEnt = ((IhmRelation2)this.listeEntiteRelation.get(i)).getRelation().getNom();
/*  534 */           if (this.frm.getPanLibibrary().getSelectedLibrary().existNumModel(nomEnt) >= 0) {
/*  535 */             if (JOptionPane.showConfirmDialog(this, "La relation " + nomEnt + " existe dans la librairie \nVoulez vous la remplacer ?", "Insertion Librairie ", 0) == 0) {
/*  536 */               IhmRelation2 ent = (IhmRelation2)((IhmRelation2)this.listeEntiteRelation.get(i)).copier();
/*  537 */               ent.setSelected(false);
/*  538 */               ent.setX(1);
/*  539 */               ent.setY(1);
/*  540 */               cacherAttribut(ent);
/*  541 */               liste.add(ent);
/*      */             }
/*      */           } else {
/*  544 */             IhmRelation2 ent = (IhmRelation2)((IhmRelation2)this.listeEntiteRelation.get(i)).copier();
/*  545 */             ent.setSelected(false);
/*  546 */             ent.setNbUsedLibrairie(0);
/*  547 */             ent.setX(1);
/*  548 */             ent.setY(1);
/*  549 */             cacherAttribut(ent);
/*  550 */             liste.add(ent);
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  557 */     return liste;
/*      */   }
/*      */   
/*      */   public void insererDansLaLibrairie()
/*      */   {
/*  562 */     ArrayList<IhmEntiteRelation> liste = getSelectedEntireRelationPourLibrairie();
/*  563 */     if (liste.size() == 0) {
/*  564 */       JOptionPane.showMessageDialog(this.frm, "Aucune entité ou relation n'est inserée dans la librairie !!", "Insertion Librairie", 0);
/*  565 */       return;
/*      */     }
/*  567 */     this.frm.getPanLibibrary().getSelectedLibrary().addModel(liste);
/*  568 */     this.frm.getPanLibibrary().repaindrePan();
/*      */   }
/*      */   
/*      */   public void setClPage(Color cl) {
/*  572 */     for (int i = 0; i < getListeLien().size(); i++) {
/*  573 */       ((IhmLien2)getListeLien().get(i)).getCardinalites().setClFond2(cl);
/*      */     }
/*  575 */     for (int i = 0; i < getListeLienContrainteHeritage().size(); i++) {
/*  576 */       ((IhmLienContrainteHeritage2)getListeLienContrainteHeritage().get(i)).setClLienFondNom(cl);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public ProprieteMCD getProprieteMCD()
/*      */   {
/*  596 */     return this.proprieteMCD;
/*      */   }
/*      */   
/*      */   public void setProprieteMCD(ProprieteMCD proprieteMCD) {
/*  600 */     this.proprieteMCD = proprieteMCD;
/*  601 */     this.ihmProprieteMCD.setProprieteMCD(proprieteMCD);
/*      */   }
/*      */   
/*      */   private void verifierLien()
/*      */   {
/*  606 */     this.listeLienDouble.clear();
/*  607 */     for (int i = 0; i < this.listeLien.size(); i++) {
/*  608 */       IhmLien2 l = (IhmLien2)this.listeLien.get(i);
/*  609 */       for (int j = i + 1; j < this.listeLien.size(); j++) {
/*  610 */         if (l.egale((IhmLien2)this.listeLien.get(j))) {
/*  611 */           this.listeLienDouble.put(l, "Plusieurs Liens ");
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void dessinerPlussieursLiens(Graphics g) {
/*  618 */     verifierLien();
/*  619 */     Color cl = g.getColor();
/*  620 */     g.setColor(Color.RED);
/*      */     
/*  622 */     Object[] cle = this.listeLienDouble.keySet().toArray();
/*  623 */     for (int i = 0; i < cle.length; i++) {
/*  624 */       int x = (((IhmLien)cle[i]).getEntite().getCentreX() + ((IhmLien)cle[i]).getRelation().getCentreX()) / 2;
/*  625 */       int y = (((IhmLien)cle[i]).getEntite().getCentreY() + ((IhmLien)cle[i]).getRelation().getCentreY()) / 2;
/*  626 */       g.drawString("Plusieurs liens ... ", x, y);
/*      */     }
/*  628 */     g.setColor(cl);
/*      */   }
/*      */   
/*      */   public void redimmentionnerPage() {
/*  632 */     int x = 0;int y = 0;
/*      */     
/*  634 */     if (this.listeCadre == null) return;
/*  635 */     for (int i = 0; i < this.listeCadre.size(); i++) {
/*  636 */       if (x < ((IhmCadre)this.listeCadre.get(i)).getX() + ((IhmCadre)this.listeCadre.get(i)).getWidth())
/*  637 */         x = ((IhmCadre)this.listeCadre.get(i)).getX() + ((IhmCadre)this.listeCadre.get(i)).getWidth();
/*  638 */       if (y < ((IhmCadre)this.listeCadre.get(i)).getY() + ((IhmCadre)this.listeCadre.get(i)).getHeight()) {
/*  639 */         y = ((IhmCadre)this.listeCadre.get(i)).getY() + ((IhmCadre)this.listeCadre.get(i)).getHeight();
/*      */       }
/*      */     }
/*  642 */     if (this.listeEntiteRelation == null) return;
/*  643 */     for (int j = 0; j < this.listeEntiteRelation.size(); j++) {
/*  644 */       if (x < ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getWidth())
/*  645 */         x = ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getWidth();
/*  646 */       if (y < ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getHeight()) {
/*  647 */         y = ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getHeight();
/*      */       }
/*      */     }
/*  650 */     if (this.listeCIF == null) return;
/*  651 */     for (int i = 0; i < this.listeCIF.size(); i++) {
/*  652 */       if (x < ((IhmCIF)this.listeCIF.get(i)).getX() + ((IhmCIF)this.listeCIF.get(i)).getWidth())
/*  653 */         x = ((IhmCIF)this.listeCIF.get(i)).getX() + ((IhmCIF)this.listeCIF.get(i)).getWidth();
/*  654 */       if (y < ((IhmCIF)this.listeCIF.get(i)).getY() + ((IhmCIF)this.listeCIF.get(i)).getHeight()) {
/*  655 */         y = ((IhmCIF)this.listeCIF.get(i)).getY() + ((IhmCIF)this.listeCIF.get(i)).getHeight();
/*      */       }
/*      */     }
/*  658 */     if (this.listeContrainte == null) return;
/*  659 */     for (int i = 0; i < this.listeContrainte.size(); i++) {
/*  660 */       if (x < ((IhmEntiteRelation)this.listeContrainte.get(i)).getX() + ((IhmEntiteRelation)this.listeContrainte.get(i)).getWidth())
/*  661 */         x = ((IhmEntiteRelation)this.listeContrainte.get(i)).getX() + ((IhmEntiteRelation)this.listeContrainte.get(i)).getWidth();
/*  662 */       if (y < ((IhmEntiteRelation)this.listeContrainte.get(i)).getY() + ((IhmEntiteRelation)this.listeContrainte.get(i)).getHeight()) {
/*  663 */         y = ((IhmEntiteRelation)this.listeContrainte.get(i)).getY() + ((IhmEntiteRelation)this.listeContrainte.get(i)).getHeight();
/*      */       }
/*      */     }
/*  666 */     if (this.listeCommentaire == null) return;
/*  667 */     for (int i = 0; i < this.listeCommentaire.size(); i++) {
/*  668 */       if (x < ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getX() + ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getWidth())
/*  669 */         x = ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getX() + ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getWidth();
/*  670 */       if (y < ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getY() + ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getHeight()) {
/*  671 */         y = ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getY() + ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getHeight();
/*      */       }
/*      */     }
/*  674 */     if (x < this.frm.getWidth()) {
/*  675 */       setPreferredSize(new Dimension(x + 50, y + 50));
/*  676 */       setSize((int)this.frm.getSize().getWidth(), (int)this.frm.getSize().getHeight());
/*      */     }
/*      */     
/*      */ 
/*  680 */     if (y < this.frm.getHeight()) {
/*  681 */       setPreferredSize(new Dimension(x + 50, y + 50));
/*  682 */       setSize((int)this.frm.getSize().getWidth(), (int)this.frm.getSize().getHeight());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void effacerAllMCD()
/*      */   {
/*  689 */     getListeEntiteRelation().clear();
/*  690 */     getListeLien().clear();
/*  691 */     getListeCIF().clear();
/*  692 */     getListelienCIF().clear();
/*  693 */     getListeHeritage().clear();
/*  694 */     getListeLienHeritage().clear();
/*  695 */     getListeCommentaire().clear();
/*  696 */     getListeLienCommentaire().clear();
/*  697 */     getListeContrainte().clear();
/*  698 */     getListeLienContrainte().clear();
/*  699 */     getListeCadre().clear();
/*  700 */     getListeAttribut().clear();
/*  701 */     getListeDomaine().clear();
/*  702 */     getListeLienContrainteHeritage().clear();
/*  703 */     this.contrainteSel = null;
/*  704 */     this.lienContrHeritageSel = null;
/*  705 */     this.lienHeritageSel = null;
/*  706 */     this.lienContrSel = null;
/*  707 */     this.heritageSelect = null;
/*  708 */     this.relationSel = null;
/*  709 */     this.cadreSelect = null;
/*  710 */     this.entRelaSelect = null;
/*  711 */     this.entRelaSelect1 = null;
/*  712 */     this.entRelaSelect2 = null;
/*  713 */     this.cifSelect = null;
/*  714 */     this.commSelect = null;
/*  715 */     this.lienCommSelect = null;
/*  716 */     this.lienCifSel = null;
/*  717 */     this.pointSel = null;
/*      */     
/*      */ 
/*  720 */     this.frmMcd.getEntiteNode().removeAllChildren();
/*  721 */     this.frmMcd.getRelationNode().removeAllChildren();
/*  722 */     this.frm.getExplorer().getTree().updateUI();
/*  723 */     this.frm.getFormeMLD().getPageMld().effacerAllEntite();
/*  724 */     setPreferredSize(new Dimension((int)this.frm.getSize().getWidth() - 400, (int)this.frm.getSize().getHeight() - 400));
/*  725 */     setSize(new Dimension((int)this.frm.getSize().getWidth() - 100, (int)this.frm.getSize().getHeight() - 100));
/*  726 */     repaint();
/*      */   }
/*      */   
/*      */   private void dessinerCadreSelect(Graphics g)
/*      */   {
/*  731 */     int w = Math.abs(this.Sx - this.Fx);
/*  732 */     int h = Math.abs(this.Sy - this.Fy);
/*  733 */     int x0 = this.Sx;
/*  734 */     int y0 = this.Sy;
/*  735 */     if (x0 > this.Fx) x0 = this.Sx - w;
/*  736 */     if (y0 > this.Fy) { y0 = this.Sy - h;
/*      */     }
/*      */     
/*  739 */     Graphics2D g2 = (Graphics2D)g;
/*  740 */     Rectangle2D rec = new Rectangle2D.Double(x0, y0, w, h);
/*  741 */     g2.setStroke(new BasicStroke(1.0F));
/*  742 */     g2.setPaint(this.fillColor);
/*  743 */     g2.fill(rec);
/*  744 */     g2.setPaint(this.strokeColor);
/*  745 */     g2.draw(rec);
/*      */   }
/*      */   
/*      */   private void dessinerLien(Graphics g) {
/*  749 */     g.drawLine(this.entRelaSelect1.getCentreX(), this.entRelaSelect1.getCentreY(), this.Fx, this.Fy);
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean isObjectSelect(int sx0, int sy0, int sx1, int sy1, int x, int y)
/*      */   {
/*  755 */     int x0 = sx0;
/*  756 */     int y0 = sy0;
/*  757 */     int x1 = sx1;
/*  758 */     int y1 = sy1;
/*  759 */     if (x0 > sx1) {
/*  760 */       x0 = sx1;
/*  761 */       x1 = sx0;
/*      */     }
/*  763 */     if (y0 > sy1) {
/*  764 */       y0 = sy1;
/*  765 */       y1 = sy0;
/*      */     }
/*  767 */     if ((x >= x0) && (x <= x1) && (y >= y0) && (y <= y1)) return true;
/*  768 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   private void setSelectCollection(int sx0, int sy0, int sx1, int sy1)
/*      */   {
/*  774 */     for (int i = 0; i < this.listeEntiteRelation.size(); i++) {
/*  775 */       boolean vrai = isObjectSelect(sx0, sy0, sx1, sy1, ((IhmEntiteRelation)this.listeEntiteRelation.get(i)).getX(), ((IhmEntiteRelation)this.listeEntiteRelation.get(i)).getY());
/*  776 */       vrai = (vrai) && (isObjectSelect(sx0, sy0, sx1, sy1, ((IhmEntiteRelation)this.listeEntiteRelation.get(i)).getX() + ((IhmEntiteRelation)this.listeEntiteRelation.get(i)).getWidth(), ((IhmEntiteRelation)this.listeEntiteRelation.get(i)).getY() + ((IhmEntiteRelation)this.listeEntiteRelation.get(i)).getHeight()));
/*  777 */       ((IhmEntiteRelation)this.listeEntiteRelation.get(i)).setSelected(vrai);
/*      */     }
/*  779 */     for (int i = 0; i < this.listeCIF.size(); i++) {
/*  780 */       boolean vrai = isObjectSelect(sx0, sy0, sx1, sy1, ((IhmCIF)this.listeCIF.get(i)).getX(), ((IhmCIF)this.listeCIF.get(i)).getY());
/*  781 */       vrai = (vrai) && (isObjectSelect(sx0, sy0, sx1, sy1, ((IhmCIF)this.listeCIF.get(i)).getX() + ((IhmCIF)this.listeCIF.get(i)).getWidth(), ((IhmCIF)this.listeCIF.get(i)).getY() + ((IhmCIF)this.listeCIF.get(i)).getHeight()));
/*  782 */       ((IhmCIF)this.listeCIF.get(i)).setSelected(vrai);
/*      */     }
/*  784 */     for (int i = 0; i < this.listeContrainte.size(); i++) {
/*  785 */       boolean vrai = isObjectSelect(sx0, sy0, sx1, sy1, ((IhmEntiteRelation)this.listeContrainte.get(i)).getX(), ((IhmEntiteRelation)this.listeContrainte.get(i)).getY());
/*  786 */       vrai = (vrai) && (isObjectSelect(sx0, sy0, sx1, sy1, ((IhmEntiteRelation)this.listeContrainte.get(i)).getX() + ((IhmEntiteRelation)this.listeContrainte.get(i)).getWidth(), ((IhmEntiteRelation)this.listeContrainte.get(i)).getY() + ((IhmEntiteRelation)this.listeContrainte.get(i)).getHeight()));
/*  787 */       ((IhmEntiteRelation)this.listeContrainte.get(i)).setSelected(vrai);
/*      */     }
/*      */     
/*  790 */     for (int i = 0; i < this.listeCommentaire.size(); i++) {
/*  791 */       boolean vrai = isObjectSelect(sx0, sy0, sx1, sy1, ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getX(), ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getY());
/*  792 */       vrai = (vrai) && (isObjectSelect(sx0, sy0, sx1, sy1, ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getX() + ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getWeidth(), ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getY() + ((IhmCommentaireIndip)this.listeCommentaire.get(i)).getHight()));
/*  793 */       ((IhmCommentaireIndip)this.listeCommentaire.get(i)).setSelected(vrai);
/*      */     }
/*      */     
/*  796 */     for (int i = 0; i < this.listeHeritage.size(); i++) {
/*  797 */       boolean vrai = isObjectSelect(sx0, sy0, sx1, sy1, ((IhmHeritage)this.listeHeritage.get(i)).getX(), ((IhmHeritage)this.listeHeritage.get(i)).getY());
/*  798 */       vrai = (vrai) && (isObjectSelect(sx0, sy0, sx1, sy1, ((IhmHeritage)this.listeHeritage.get(i)).getX() + ((IhmHeritage)this.listeHeritage.get(i)).getWidth(), ((IhmHeritage)this.listeHeritage.get(i)).getY() + ((IhmHeritage)this.listeHeritage.get(i)).getHeight()));
/*  799 */       ((IhmHeritage)this.listeHeritage.get(i)).setSelected(vrai);
/*      */     }
/*      */     
/*  802 */     for (int i = 0; i < this.listeLien.size(); i++) {
/*  803 */       IhmLien2 li = (IhmLien2)this.listeLien.get(i);
/*  804 */       for (int j = 0; j < li.getPointCassure().size(); j++) {
/*  805 */         if (((IhmPoint)li.getPointCassure().get(j)).estDans(sx0, sy0, sx1, sy1)) {
/*  806 */           ((IhmPoint)li.getPointCassure().get(j)).setSelected(true);
/*      */         }
/*      */       }
/*  809 */       if (li.estDans(sx0, sy0, sx1, sy1)) {
/*  810 */         li.setSelected(true);
/*      */       }
/*      */     }
/*      */     
/*  814 */     for (int i = 0; i < this.listeLienHeritage.size(); i++) {
/*  815 */       boolean vrai = isObjectSelect(sx0, sy0, sx1, sy1, ((IhmLienHeritage2)this.listeLienHeritage.get(i)).getPere().getCentreX(), ((IhmLienHeritage2)this.listeLienHeritage.get(i)).getPere().getCentreY());
/*  816 */       vrai = (vrai) && (isObjectSelect(sx0, sy0, sx1, sy1, ((IhmLienHeritage2)this.listeLienHeritage.get(i)).getFils().getCentreX(), ((IhmLienHeritage2)this.listeLienHeritage.get(i)).getFils().getCentreY()));
/*  817 */       if (((IhmLienHeritage)this.listeLienHeritage.get(i)).isCassure()) vrai = (vrai) && (isObjectSelect(sx0, sy0, sx1, sy1, (int)((IhmLienHeritage)this.listeLienHeritage.get(i)).getxCassure(), (int)((IhmLienHeritage)this.listeLienHeritage.get(i)).getyCassure()));
/*  818 */       ((IhmLienHeritage)this.listeLienHeritage.get(i)).setSelected(vrai);
/*      */     }
/*      */     
/*  821 */     for (int i = 0; i < this.listeLienContrainteHeritage.size(); i++) {
/*  822 */       IhmLienContrainteHeritage2 li = (IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(i);
/*  823 */       for (int j = 0; j < li.getPointCassure().size(); j++) {
/*  824 */         if (((IhmPoint)li.getPointCassure().get(j)).estDans(sx0, sy0, sx1, sy1)) {
/*  825 */           ((IhmPoint)li.getPointCassure().get(j)).setSelected(true);
/*      */         }
/*      */       }
/*  828 */       if (li.estDans(sx0, sy0, sx1, sy1)) {
/*  829 */         li.setSelected(true);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  834 */     for (int i = 0; i < this.listeLienCommentaire.size(); i++) {
/*  835 */       if ((this.listeLienCommentaire.get(i) instanceof IhmLienCommentaire2)) {
/*  836 */         IhmLienCommentaire2 li = (IhmLienCommentaire2)this.listeLienCommentaire.get(i);
/*  837 */         for (int j = 0; j < li.getPointCassure().size(); j++) {
/*  838 */           if (((IhmPoint)li.getPointCassure().get(j)).estDans(sx0, sy0, sx1, sy1)) {
/*  839 */             ((IhmPoint)li.getPointCassure().get(j)).setSelected(true);
/*      */           }
/*      */         }
/*  842 */         if (li.estDans(sx0, sy0, sx1, sy1)) {
/*  843 */           li.setSelected(true);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  848 */     for (int i = 0; i < this.listeLienContrainte.size(); i++) {
/*  849 */       IhmLienContraintes2 li = (IhmLienContraintes2)this.listeLienContrainte.get(i);
/*  850 */       for (int j = 0; j < li.getPointCassure().size(); j++) {
/*  851 */         if (((IhmPoint)li.getPointCassure().get(j)).estDans(sx0, sy0, sx1, sy1)) {
/*  852 */           ((IhmPoint)li.getPointCassure().get(j)).setSelected(true);
/*      */         }
/*      */       }
/*  855 */       if (li.estDans(sx0, sy0, sx1, sy1)) {
/*  856 */         li.setSelected(true);
/*      */       }
/*      */     }
/*      */     
/*  860 */     for (int i = 0; i < this.listelienCIF.size(); i++)
/*      */     {
/*  862 */       IhmLienCIF2 li = (IhmLienCIF2)this.listelienCIF.get(i);
/*  863 */       for (int j = 0; j < li.getPointCassure().size(); j++) {
/*  864 */         if (((IhmPoint)li.getPointCassure().get(j)).estDans(sx0, sy0, sx1, sy1)) {
/*  865 */           ((IhmPoint)li.getPointCassure().get(j)).setSelected(true);
/*      */         }
/*      */       }
/*  868 */       if (li.estDans(sx0, sy0, sx1, sy1)) {
/*  869 */         li.setSelected(true);
/*      */       }
/*      */     }
/*      */     
/*  873 */     for (int i = 0; i < this.listeCadre.size(); i++) {
/*  874 */       boolean vrai = isObjectSelect(sx0, sy0, sx1, sy1, ((IhmCadre)this.listeCadre.get(i)).getX(), ((IhmCadre)this.listeCadre.get(i)).getY());
/*  875 */       vrai = (vrai) && (isObjectSelect(sx0, sy0, sx1, sy1, ((IhmCadre)this.listeCadre.get(i)).getX() + ((IhmCadre)this.listeCadre.get(i)).getWidth(), ((IhmCadre)this.listeCadre.get(i)).getY() + ((IhmCadre)this.listeCadre.get(i)).getHeight()));
/*  876 */       ((IhmCadre)this.listeCadre.get(i)).setSelected(vrai);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void afficherGrille(Graphics gr)
/*      */   {
/*  883 */     int i = 15;
/*      */     
/*      */ 
/*  886 */     gr.setColor(this.clPetitCareau);
/*  887 */     while (i < getSize().getWidth()) {
/*  888 */       gr.drawLine(i, 0, i, (int)getSize().getHeight());
/*  889 */       i += 15;
/*      */     }
/*  891 */     i = 15;
/*  892 */     while (i < getSize().getHeight()) {
/*  893 */       gr.drawLine(0, i, (int)getSize().getWidth(), i);
/*  894 */       i += 15;
/*      */     }
/*      */   }
/*      */   
/*      */   public void setSelected(boolean sel)
/*      */   {
/*  900 */     for (int i = 0; i < this.listeLien.size(); i++) {
/*  901 */       ((IhmLien)this.listeLien.get(i)).setSelected(sel);
/*      */     }
/*  903 */     for (int j = 0; j < this.listeEntiteRelation.size(); j++) {
/*  904 */       ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).setSelected(sel);
/*      */     }
/*  906 */     for (int j = 0; j < this.listeCIF.size(); j++) {
/*  907 */       ((IhmCIF)this.listeCIF.get(j)).setSelected(sel);
/*  908 */       this.cifSelect = null;
/*      */     }
/*  910 */     for (int h = 0; h < this.listeCommentaire.size(); h++) {
/*  911 */       ((IhmCommentaireIndip)this.listeCommentaire.get(h)).setSelected(sel);
/*  912 */       this.commSelect = null;
/*      */     }
/*  914 */     for (int h = 0; h < this.listelienCIF.size(); h++) {
/*  915 */       ((IhmLienCif)this.listelienCIF.get(h)).setSelected(sel);
/*  916 */       this.lienCifSel = null;
/*      */     }
/*  918 */     for (int h = 0; h < this.listeLienHeritage.size(); h++) {
/*  919 */       ((IhmLienHeritage)this.listeLienHeritage.get(h)).setSelected(sel);
/*  920 */       this.lienHeritageSel = null;
/*      */     }
/*  922 */     for (int h = 0; h < this.listeContrainte.size(); h++) {
/*  923 */       ((IhmEntiteRelation)this.listeContrainte.get(h)).setSelected(sel);
/*  924 */       this.contrainteSel = null;
/*      */     }
/*  926 */     for (int h = 0; h < this.listeLienContrainte.size(); h++) {
/*  927 */       ((IhmLienContraintes2)this.listeLienContrainte.get(h)).setSelected(sel);
/*  928 */       this.lienContrSel = null;
/*      */     }
/*      */     
/*  931 */     for (int h = 0; h < this.listeLienCommentaire.size(); h++) {
/*  932 */       ((IhmLienCommentaire)this.listeLienCommentaire.get(h)).setSelected(sel);
/*  933 */       this.lienCommSelect = null;
/*      */     }
/*  935 */     for (int h = 0; h < this.listeCadre.size(); h++) {
/*  936 */       ((IhmCadre)this.listeCadre.get(h)).setSelected(sel);
/*  937 */       this.cadreSelect = null;
/*      */     }
/*  939 */     for (int h = 0; h < this.listeHeritage.size(); h++) {
/*  940 */       ((IhmHeritage)this.listeHeritage.get(h)).setSelected(sel);
/*  941 */       this.heritageSelect = null;
/*      */     }
/*  943 */     for (int h = 0; h < this.listeLienContrainteHeritage.size(); h++) {
/*  944 */       ((IhmLienContrainteHeritage)this.listeLienContrainteHeritage.get(h)).setSelected(sel);
/*  945 */       this.lienContrHeritageSel = null;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private IhmEntiteRelation isSelected(int x, int y)
/*      */   {
/*  954 */     IhmEntiteRelation entre = null;
/*  955 */     for (int i = 0; i < this.listeEntiteRelation.size(); i++) {
/*  956 */       if (((IhmEntiteRelation)this.listeEntiteRelation.get(i)).isSelected(x, y)) {
/*  957 */         if (entre != null) entre.setSelected(false);
/*  958 */         entre = (IhmEntiteRelation)this.listeEntiteRelation.get(i);
/*      */       }
/*      */     }
/*  961 */     return entre;
/*      */   }
/*      */   
/*      */   private IhmEntiteRelation isSelected2(int x, int y) {
/*  965 */     for (int i = 0; i < this.listeCIF.size(); i++) {
/*  966 */       if (((IhmCIF)this.listeCIF.get(i)).isSelected(x, y)) return (IhmEntiteRelation)this.listeCIF.get(i);
/*      */     }
/*  968 */     return null;
/*      */   }
/*      */   
/*      */   private IhmEntiteRelation isSelectedContrainte(int x, int y) {
/*  972 */     IhmContrainte cont = null;
/*  973 */     for (int i = 0; i < this.listeContrainte.size(); i++) {
/*  974 */       if (((IhmEntiteRelation)this.listeContrainte.get(i)).isSelected(x, y)) {
/*  975 */         if (cont != null) cont.setSelected(false);
/*  976 */         cont = (IhmContrainte)this.listeContrainte.get(i);
/*      */       }
/*      */     }
/*  979 */     return cont;
/*      */   }
/*      */   
/*      */   private IhmEntiteRelation isSelectedCommentaire(int x, int y) {
/*  983 */     IhmCommentaireIndip cont = null;
/*  984 */     for (int i = 0; i < this.listeCommentaire.size(); i++) {
/*  985 */       if (((IhmCommentaireIndip)this.listeCommentaire.get(i)).isSelected(x, y)) {
/*  986 */         if (cont != null) cont.setSelected(false);
/*  987 */         cont = (IhmCommentaireIndip)this.listeCommentaire.get(i);
/*      */       }
/*      */     }
/*  990 */     return cont;
/*      */   }
/*      */   
/*      */   private IhmEntiteRelation isSelectedHeritage(int x, int y) {
/*  994 */     IhmHeritage cont = null;
/*  995 */     for (int i = 0; i < this.listeHeritage.size(); i++) {
/*  996 */       if (((IhmHeritage)this.listeHeritage.get(i)).isSelected(x, y)) {
/*  997 */         if (cont != null) cont.setSelected(false);
/*  998 */         cont = (IhmHeritage)this.listeHeritage.get(i);
/*      */       }
/*      */     }
/* 1001 */     return cont;
/*      */   }
/*      */   
/*      */   private IhmLien selectedLien(int x, int y) {
/* 1005 */     IhmLien lie = null;
/* 1006 */     for (int i = 0; i < this.listeLien.size(); i++) {
/* 1007 */       if (((IhmLien)this.listeLien.get(i)).isSelected(x, y)) {
/* 1008 */         if (lie != null) lie.setSelected(false);
/* 1009 */         lie = (IhmLien)this.listeLien.get(i);
/*      */       }
/*      */     }
/* 1012 */     return lie;
/*      */   }
/*      */   
/*      */   private IhmPoint selectedPointCassure(int x, int y, Object lien) {
/* 1016 */     if ((lien instanceof IhmLien2)) {
/* 1017 */       IhmLien2 lie = (IhmLien2)lien;
/* 1018 */       return lie.getSelectedPointCassure(x, y);
/*      */     }
/*      */     
/* 1021 */     if ((lien instanceof IhmLienCIF2)) {
/* 1022 */       IhmLienCIF2 lie = (IhmLienCIF2)lien;
/* 1023 */       return lie.getSelectedPointCassure(x, y);
/*      */     }
/*      */     
/* 1026 */     if ((lien instanceof IhmLienContraintes2)) {
/* 1027 */       IhmLienContraintes2 lie = (IhmLienContraintes2)lien;
/* 1028 */       return lie.getSelectedPointCassure(x, y);
/*      */     }
/*      */     
/* 1031 */     if ((lien instanceof IhmLienCommentaire2)) {
/* 1032 */       IhmLienCommentaire2 lie = (IhmLienCommentaire2)lien;
/* 1033 */       return lie.getSelectedPointCassure(x, y);
/*      */     }
/*      */     
/* 1036 */     if ((lien instanceof IhmLienContrainteHeritage2)) {
/* 1037 */       IhmLienContrainteHeritage2 lie = (IhmLienContrainteHeritage2)lien;
/* 1038 */       return lie.getSelectedPointCassure(x, y);
/*      */     }
/*      */     
/* 1041 */     return null;
/*      */   }
/*      */   
/*      */   private IhmCommentaireIndip selectedCommentaire(int x, int y) {
/* 1045 */     IhmCommentaireIndip comm = null;
/* 1046 */     for (int i = 0; i < this.listeCommentaire.size(); i++) {
/* 1047 */       if (((IhmCommentaireIndip)this.listeCommentaire.get(i)).isSelected(x, y)) {
/* 1048 */         if (comm != null) comm.setSelected(false);
/* 1049 */         comm = (IhmCommentaireIndip)this.listeCommentaire.get(i);
/*      */       }
/*      */     }
/* 1052 */     return comm;
/*      */   }
/*      */   
/*      */   private IhmCadre selectedCadre(int x, int y) {
/* 1056 */     IhmCadre cadreSel = null;
/* 1057 */     for (int i = 0; i < this.listeCadre.size(); i++) {
/* 1058 */       if (((IhmCadre)this.listeCadre.get(i)).isSelected(x, y)) {
/* 1059 */         if (cadreSel != null) cadreSel.setSelected(false);
/* 1060 */         cadreSel = (IhmCadre)this.listeCadre.get(i);
/*      */       }
/*      */     }
/* 1063 */     return cadreSel;
/*      */   }
/*      */   
/*      */   private IhmHeritage selectedHeritageContrainte(int x, int y) {
/* 1067 */     IhmHeritage her = null;
/* 1068 */     for (int i = 0; i < this.listeHeritage.size(); i++) {
/* 1069 */       if (((IhmHeritage)this.listeHeritage.get(i)).isSelected(x, y)) {
/* 1070 */         if (her != null) her.setSelected(false);
/* 1071 */         her = (IhmHeritage)this.listeHeritage.get(i);
/* 1072 */         her.setSelected(true);
/*      */       }
/*      */     }
/* 1075 */     return her;
/*      */   }
/*      */   
/*      */   private IhmCIF selectedCif(int x, int y) {
/* 1079 */     for (int i = 0; i < this.listeCIF.size(); i++) {
/* 1080 */       if (((IhmCIF)this.listeCIF.get(i)).isSelected(x, y)) return (IhmCIF)this.listeCIF.get(i);
/*      */     }
/* 1082 */     return null;
/*      */   }
/*      */   
/*      */   private IhmEntiteRelation selectedContrainte(int x, int y) {
/* 1086 */     for (int i = 0; i < this.listeContrainte.size(); i++) {
/* 1087 */       if (((IhmEntiteRelation)this.listeContrainte.get(i)).isSelected(x, y)) return (IhmEntiteRelation)this.listeContrainte.get(i);
/*      */     }
/* 1089 */     return null;
/*      */   }
/*      */   
/*      */   private IhmLienCif selectedLienCif(int x, int y) {
/* 1093 */     IhmLienCIF2 lie = null;
/*      */     
/* 1095 */     for (int i = 0; i < this.listelienCIF.size(); i++) {
/* 1096 */       if (((IhmLienCIF2)this.listelienCIF.get(i)).isSelected(x, y)) {
/* 1097 */         if (lie != null) lie.setSelected(false);
/* 1098 */         lie = (IhmLienCIF2)this.listelienCIF.get(i);
/*      */       }
/*      */     }
/* 1101 */     return lie;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void desactiverAllLien()
/*      */   {
/* 1109 */     for (int i = 0; i < this.listeLien.size(); i++) {
/* 1110 */       IhmLien2 l = (IhmLien2)this.listeLien.get(i);
/* 1111 */       l.setActiver(false);
/*      */     }
/* 1113 */     for (int i = 0; i < this.listelienCIF.size(); i++) {
/* 1114 */       IhmLienCIF2 lCif = (IhmLienCIF2)this.listelienCIF.get(i);
/* 1115 */       lCif.setActiver(false);
/*      */     }
/*      */     
/* 1118 */     for (int i = 0; i < this.listeLienContrainte.size(); i++) {
/* 1119 */       IhmLienContraintes2 lCnt = (IhmLienContraintes2)this.listeLienContrainte.get(i);
/* 1120 */       lCnt.setActiver(false);
/*      */     }
/*      */     
/* 1123 */     for (int i = 0; i < this.listeLienContrainteHeritage.size(); i++) {
/* 1124 */       IhmLienContrainteHeritage2 lCntH = (IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(i);
/* 1125 */       lCntH.setActiver(false);
/*      */     }
/*      */   }
/*      */   
/*      */   private Color getColorActive(IhmEntiteRelation ent) {
/* 1130 */     if ((ent instanceof IhmEntite2)) {
/* 1131 */       return ((IhmEntite2)ent).getClLienActiver();
/*      */     }
/* 1133 */     if ((ent instanceof IhmRelation2)) {
/* 1134 */       return ((IhmRelation2)ent).getClLienActiver();
/*      */     }
/* 1136 */     return Color.PINK;
/*      */   }
/*      */   
/*      */   public void activerAllLien(IhmEntiteRelation ent) {
/* 1140 */     if (!Setting.activerLien2) { return;
/*      */     }
/* 1142 */     if (((ent instanceof IhmEntite2)) || ((ent instanceof IhmRelation2)))
/*      */     {
/* 1144 */       Color cl = getColorActive(ent);
/* 1145 */       for (int i = 0; i < this.listeLien.size(); i++) {
/* 1146 */         IhmLien2 l = (IhmLien2)this.listeLien.get(i);
/* 1147 */         if ((l.getRelation() == ent) || (l.getEntite() == ent)) {
/* 1148 */           l.setActiver(true);
/* 1149 */           l.setClLienActiver(cl);
/*      */         }
/*      */       }
/*      */       
/*      */ 
/* 1154 */       for (int i = 0; i < this.listeLienContrainteHeritage.size(); i++) {
/* 1155 */         IhmLienContrainteHeritage2 lc = (IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(i);
/* 1156 */         if (lc.getEntiteRelation() == ent) {
/* 1157 */           lc.setActiver(true);
/* 1158 */           lc.setClLienActiverHeritage2(cl);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1163 */     if ((ent instanceof IhmCIF2))
/*      */     {
/* 1165 */       Color cl2 = ((IhmCIF2)ent).getClLienActiver();
/* 1166 */       for (int i = 0; i < this.listelienCIF.size(); i++) {
/* 1167 */         IhmLienCIF2 lc = (IhmLienCIF2)this.listelienCIF.get(i);
/* 1168 */         if (lc.getCif() == ent) {
/* 1169 */           lc.setActiver(true);
/* 1170 */           lc.setClLienActiverCIF2(cl2);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1175 */     if ((ent instanceof IhmContrainte2))
/*      */     {
/* 1177 */       Color cl2 = ((IhmContrainte2)ent).getClLienActiver();
/* 1178 */       for (int i = 0; i < this.listeLienContrainte.size(); i++) {
/* 1179 */         IhmLienContraintes2 lc = (IhmLienContraintes2)this.listeLienContrainte.get(i);
/* 1180 */         if (lc.getContrainte() == ent) {
/* 1181 */           lc.setActiver(true);
/* 1182 */           lc.setClLienActiverContrainte2(cl2);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1187 */     if ((ent instanceof IhmHeritage2))
/*      */     {
/* 1189 */       Color cl2 = ((IhmHeritage2)ent).getClLienActiver();
/* 1190 */       for (int i = 0; i < this.listeLienContrainteHeritage.size(); i++) {
/* 1191 */         IhmLienContrainteHeritage2 lc = (IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(i);
/* 1192 */         if (lc.getHeritage() == ent) {
/* 1193 */           lc.setActiver(true);
/* 1194 */           lc.setClLienActiverHeritage2(cl2);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private IhmLienCommentaire selectedLienCommentaire(int x, int y)
/*      */   {
/* 1202 */     IhmLienCommentaire lie = null;
/* 1203 */     for (int i = 0; i < this.listeLienCommentaire.size(); i++) {
/* 1204 */       if (((IhmLienCommentaire)this.listeLienCommentaire.get(i)).isSelected(x, y)) {
/* 1205 */         if (lie != null) lie.setSelected(false);
/* 1206 */         lie = (IhmLienCommentaire)this.listeLienCommentaire.get(i);
/*      */       }
/*      */     }
/* 1209 */     return lie;
/*      */   }
/*      */   
/*      */   private IhmLienContraintes selectedLienContrainte(int x, int y) {
/* 1213 */     IhmLienContraintes lie = null;
/* 1214 */     for (int i = 0; i < this.listeLienContrainte.size(); i++) {
/* 1215 */       if (((IhmLienContraintes)this.listeLienContrainte.get(i)).isSelected(x, y)) {
/* 1216 */         if (lie != null) ((IhmLienContraintes2)lie).setSelected(false);
/* 1217 */         lie = (IhmLienContraintes)this.listeLienContrainte.get(i);
/*      */       }
/*      */     }
/* 1220 */     return lie;
/*      */   }
/*      */   
/*      */   private IhmLienHeritage selectedLienHeritage(int x, int y) {
/* 1224 */     for (int i = 0; i < this.listeLienHeritage.size(); i++) {
/* 1225 */       if ((!existeLienHeritageDansContrainte(((IhmLienHeritage2)this.listeLienHeritage.get(i)).getPere(), (IhmEntite)((IhmLienHeritage2)this.listeLienHeritage.get(i)).getFils())) && 
/* 1226 */         (((IhmLienHeritage)this.listeLienHeritage.get(i)).isSelected(x, y))) {
/* 1227 */         return (IhmLienHeritage)this.listeLienHeritage.get(i);
/*      */       }
/*      */     }
/* 1230 */     return null;
/*      */   }
/*      */   
/*      */   private boolean isMultipleHeritage(IhmEntite ent)
/*      */   {
/* 1235 */     for (int i = 0; i < this.listeLienHeritage.size(); i++) {
/* 1236 */       if (((IhmLienHeritage2)this.listeLienHeritage.get(i)).getFils() == ent) return true;
/*      */     }
/* 1238 */     return false;
/*      */   }
/*      */   
/*      */   private IhmEntite trouverHeritagePere(IhmEntite ent) {
/* 1242 */     for (int i = 0; i < this.listeLienHeritage.size(); i++) {
/* 1243 */       if (((IhmLienHeritage2)this.listeLienHeritage.get(i)).getFils() == ent) return (IhmEntite)((IhmLienHeritage2)this.listeLienHeritage.get(i)).getPere();
/*      */     }
/* 1245 */     return null;
/*      */   }
/*      */   
/*      */   private boolean isPereFilsDeHeritage(IhmEntite entpere, IhmEntite entFils)
/*      */   {
/* 1250 */     IhmEntite lienEnt = trouverHeritagePere(entpere);
/* 1251 */     while (lienEnt != null) {
/* 1252 */       if (lienEnt == entFils) return true;
/* 1253 */       lienEnt = trouverHeritagePere(lienEnt);
/*      */     }
/* 1255 */     return false;
/*      */   }
/*      */   
/*      */   private void ajouterHeritageIndep(IhmEntite ent2, IhmEntite ent1) {
/* 1259 */     if (ent1 == ent2) return;
/* 1260 */     if (isMultipleHeritage(ent1)) {
/* 1261 */       JOptionPane.showMessageDialog(this.frm, "l'entité :" + ent1.getEntite().getNom() + " posséde déjà un père", "Heritage", 1);
/*      */     }
/* 1263 */     else if (!isPereFilsDeHeritage(ent2, ent1)) {
/* 1264 */       this.frmMcd.setModifier(true);
/* 1265 */       this.lienHeritageSel = new IhmLienHeritage2(ent2, ent1);
/* 1266 */       this.lienHeritageSel.setSelected(true);
/* 1267 */       this.listeLienHeritage.add(this.lienHeritageSel);
/* 1268 */       ajouterContrainteHeritage(ent2, ent1);
/*      */     }
/*      */     else {
/* 1271 */       JOptionPane.showMessageDialog(this.frm, "Le pere ne doit pas être le fils de ... ", "Héritage", 1);
/*      */     }
/*      */   }
/*      */   
/*      */   private void ajouterHeritageIndep2(IhmEntite entP, IhmEntite entF)
/*      */   {
/* 1277 */     if (entF == entP) return;
/* 1278 */     if (!Setting.heritageMult) {
/* 1279 */       if (VerifHeritageLienRelatif.ADejaPere((IhmEntite2)entF, this.listeLienHeritage)) {
/* 1280 */         JOptionPane.showMessageDialog(this.frm, "L'option héritage multigle est désactivée, \ndonc l'entité :" + entF.getEntite().getNom() + " posséde déjà une entité mère ", "Heritage", 1);
/* 1281 */         return;
/*      */       }
/* 1283 */       if (VerifHeritageLienRelatif.isBoucleHeritage((IhmEntite2)entF, (IhmEntite2)entP, this.listeLienHeritage)) {
/* 1284 */         JOptionPane.showMessageDialog(this.frm, "Erreur une entité ne peut pas être une géralisation d'elle même (existe une boucle)", "Héritage", 1);
/* 1285 */         return;
/*      */       }
/*      */       
/* 1288 */       this.frmMcd.setModifier(true);
/* 1289 */       this.lienHeritageSel = new IhmLienHeritage2(entP, entF);
/* 1290 */       this.lienHeritageSel.setSelected(true);
/* 1291 */       this.listeLienHeritage.add(this.lienHeritageSel);
/* 1292 */       ajouterContrainteHeritage(entP, entF);
/* 1293 */       return;
/*      */     }
/*      */     
/*      */ 
/* 1297 */     if (VerifHeritageLienRelatif.estDejaUnPere((IhmEntite2)entF, (IhmEntite2)entP, this.listeLienHeritage)) {
/* 1298 */       JOptionPane.showMessageDialog(this.frm, "L'entité :" + entF.getEntite().getNom() + " est déjà une spécialisation de l'entité " + entP.getEntite().getNom(), "Heritage", 1);
/* 1299 */       return;
/*      */     }
/*      */     
/* 1302 */     if (VerifHeritageLienRelatif.isBoucleHeritage((IhmEntite2)entF, (IhmEntite2)entP, this.listeLienHeritage)) {
/* 1303 */       JOptionPane.showMessageDialog(this.frm, "Une entité ne peut pas être une géralisation d'elle même (existe une boucle)", "Héritage", 1);
/* 1304 */       return;
/*      */     }
/*      */     
/* 1307 */     if ((!Setting.heritageMemeSpecialisation2) && 
/* 1308 */       (VerifHeritageLienRelatif.estDejaUneSpecialisation((IhmEntite2)entF, (IhmEntite2)entP, this.listeLienHeritage))) {
/* 1309 */       JOptionPane.showMessageDialog(this.frm, "L'option Plusieurs spécialisations de la même entité est désactivée, \ndonc l'entité :" + entF.getEntite().getNom() + " est déjà une spécialisation de l'une des entités mères de " + entP.getEntite().getNom(), "Heritage", 1);
/* 1310 */       return;
/*      */     }
/*      */     
/*      */ 
/* 1314 */     this.frmMcd.setModifier(true);
/* 1315 */     this.lienHeritageSel = new IhmLienHeritage2(entP, entF);
/* 1316 */     this.lienHeritageSel.setSelected(true);
/* 1317 */     this.listeLienHeritage.add(this.lienHeritageSel);
/* 1318 */     ajouterContrainteHeritage(entP, entF);
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
/*      */   public boolean ajouterLienContrainte(IhmEntiteRelation ent1, IhmEntiteRelation ent2)
/*      */   {
/* 1340 */     IhmEntiteRelation ent = null;IhmEntiteRelation contr = null;
/* 1341 */     String nomClas = ent1.getClass().getName();
/* 1342 */     boolean sat = false;
/* 1343 */     if ((nomClas.indexOf("IhmEntite2") > 0) || (nomClas.indexOf("IhmRelation2") > 0)) {
/* 1344 */       ent = ent1;
/* 1345 */       nomClas = ent2.getClass().getName();
/* 1346 */       if (nomClas.indexOf("IhmContrainte") > 0) {
/* 1347 */         contr = ent2;
/* 1348 */         sat = true;
/*      */       }
/*      */     }
/* 1351 */     else if (nomClas.indexOf("IhmContrainte") > 0) {
/* 1352 */       contr = ent1;
/* 1353 */       nomClas = ent2.getClass().getName();
/* 1354 */       if ((nomClas.indexOf("IhmEntite2") > 0) || (nomClas.indexOf("IhmRelation2") > 0)) {
/* 1355 */         ent = ent2;
/* 1356 */         sat = true;
/*      */       }
/*      */     }
/*      */     
/* 1360 */     if (sat) {
/* 1361 */       this.lienContrSel = new IhmLienContraintes2(ent, contr);
/* 1362 */       this.listeLienContrainte.add(this.lienContrSel);
/*      */     }
/* 1364 */     return sat;
/*      */   }
/*      */   
/*      */   public boolean ajouterLienCommentaire(IhmEntiteRelation ent1, IhmEntiteRelation ent2) {
/* 1368 */     String classe1 = ent1.getClass().getName();
/* 1369 */     String classe2 = ent2.getClass().getName();
/* 1370 */     if ((classe1.equals("IhmMCD2.IhmCommentaire2")) && (
/* 1371 */       (classe2.equals("IhmMCD2.IhmEntite2")) || (classe2.equals("IhmMCD2.IhmRelation2")) || (classe2.equals("IhmMCD2.IhmCIF2")) || (classe2.equals("IhmMCD2.IhmContrainte2")) || (classe2.equals("IhmMCD2.IhmHeritage2"))))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/* 1376 */       this.lienCommSelect = new IhmLienCommentaire2(ent2, (IhmCommentaireIndip)ent1);
/* 1377 */       this.listeLienCommentaire.add(this.lienCommSelect);
/* 1378 */       return true;
/*      */     }
/*      */     
/* 1381 */     if ((classe2.equals("IhmMCD2.IhmCommentaire2")) && (
/* 1382 */       (classe1.equals("IhmMCD2.IhmEntite2")) || (classe1.equals("IhmMCD2.IhmRelation2")) || (classe1.equals("IhmMCD2.IhmCIF2")) || (classe1.equals("IhmMCD2.IhmContrainte2")) || (classe1.equals("IhmMCD2.IhmHeritage2"))))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/* 1387 */       this.lienCommSelect = new IhmLienCommentaire2(ent1, (IhmCommentaireIndip)ent2);
/* 1388 */       this.listeLienCommentaire.add(this.lienCommSelect);
/* 1389 */       return true;
/*      */     }
/*      */     
/*      */ 
/* 1393 */     return false;
/*      */   }
/*      */   
/*      */   public void majPanelLoupe() {
/* 1397 */     if (this.frm.isLoupe()) {
/* 1398 */       this.frm.getPanelLoupe().setPage(this);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean addBreakPoint(int x, int y) {
/* 1403 */     boolean ajout = false;
/* 1404 */     for (int i = 0; i < this.listeLien.size(); i++) {
/* 1405 */       ajout = ((IhmLien2)this.listeLien.get(i)).addBreakPoint(x, y);
/* 1406 */       if (ajout) {
/* 1407 */         ((IhmLien)this.listeLien.get(i)).setSelected(true);
/* 1408 */         return ajout;
/*      */       }
/*      */     }
/*      */     
/* 1412 */     for (int i = 0; i < this.listelienCIF.size(); i++) {
/* 1413 */       ajout = ((IhmLienCIF2)this.listelienCIF.get(i)).addBreakPoint(x, y);
/* 1414 */       if (ajout) {
/* 1415 */         ((IhmLienCif)this.listelienCIF.get(i)).setSelected(true);
/* 1416 */         return ajout;
/*      */       }
/*      */     }
/*      */     
/* 1420 */     for (int i = 0; i < this.listeLienContrainte.size(); i++) {
/* 1421 */       ajout = ((IhmLienContraintes2)this.listeLienContrainte.get(i)).addBreakPoint(x, y);
/* 1422 */       if (ajout) {
/* 1423 */         ((IhmLienContraintes2)this.listeLienContrainte.get(i)).setSelected(true);
/* 1424 */         return ajout;
/*      */       }
/*      */     }
/*      */     
/* 1428 */     for (int i = 0; i < this.listeLienCommentaire.size(); i++) {
/* 1429 */       if ((this.listeLienCommentaire.get(i) instanceof IhmLienCommentaire2)) {
/* 1430 */         ajout = ((IhmLienCommentaire2)this.listeLienCommentaire.get(i)).addBreakPoint(x, y);
/* 1431 */         if (ajout) {
/* 1432 */           ((IhmLienCommentaire2)this.listeLienCommentaire.get(i)).setSelected(true);
/* 1433 */           return ajout;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1438 */     for (int i = 0; i < this.listeLienContrainteHeritage.size(); i++) {
/* 1439 */       if ((this.listeLienContrainteHeritage.get(i) instanceof IhmLienContrainteHeritage2)) {
/* 1440 */         ajout = ((IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(i)).addBreakPoint(x, y);
/* 1441 */         if (ajout) {
/* 1442 */           ((IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(i)).setSelected(true);
/* 1443 */           return ajout;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1448 */     return false;
/*      */   }
/*      */   
/*      */   private void remiseANullLesSelectionner()
/*      */   {
/* 1453 */     if (this.lienSel != null) {
/* 1454 */       this.lienSel.setSelected(false);
/* 1455 */       this.lienSel = null;
/*      */     }
/* 1457 */     if (this.pointSel != null) {
/* 1458 */       this.pointSel.setSelected(false);
/* 1459 */       this.pointSel = null;
/*      */     }
/* 1461 */     if (this.lienCifSel != null) {
/* 1462 */       this.lienCifSel.setSelected(false);
/* 1463 */       this.lienCifSel = null;
/*      */     }
/* 1465 */     if (this.lienContrSel != null) {
/* 1466 */       this.lienContrSel.setSelected(false);
/* 1467 */       this.lienContrSel = null;
/*      */     }
/*      */     
/* 1470 */     if (this.entRelaSelect != null) {
/* 1471 */       this.entRelaSelect.setSelected(false);
/* 1472 */       this.entRelaSelect = null;
/*      */     }
/*      */     
/* 1475 */     if (this.entRelaSelect1 != null) {
/* 1476 */       this.entRelaSelect1.setSelected(false);
/* 1477 */       this.entRelaSelect1 = null;
/*      */     }
/*      */     
/* 1480 */     if (this.entRelaSelect2 != null) {
/* 1481 */       this.entRelaSelect2.setSelected(false);
/* 1482 */       this.entRelaSelect2 = null;
/*      */     }
/*      */     
/* 1485 */     if (this.cifSelect != null) {
/* 1486 */       this.cifSelect.setSelected(false);
/* 1487 */       this.cifSelect = null;
/*      */     }
/*      */     
/* 1490 */     if (this.contrainteSel != null) {
/* 1491 */       this.contrainteSel.setSelected(false);
/* 1492 */       this.contrainteSel = null;
/*      */     }
/*      */     
/* 1495 */     if (this.commSelect != null) {
/* 1496 */       this.commSelect.setSelected(false);
/* 1497 */       this.commSelect = null;
/*      */     }
/*      */     
/* 1500 */     if (this.lienCommSelect != null) {
/* 1501 */       this.lienCommSelect.setSelected(false);
/* 1502 */       this.lienCommSelect = null;
/*      */     }
/* 1504 */     if (this.heritageSelect != null) {
/* 1505 */       this.heritageSelect.setSelected(false);
/* 1506 */       this.heritageSelect = null;
/*      */     }
/*      */     
/* 1509 */     if (this.lienContrHeritageSel != null) {
/* 1510 */       this.lienContrHeritageSel.setSelected(false);
/* 1511 */       this.lienContrHeritageSel = null;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void ajouterAttributClePourEntite(IhmEntite2 ent)
/*      */   {
/* 1518 */     if (!Setting.isAttributCleParDefautPourEntite) return;
/* 1519 */     Attribut2 att = (Attribut2)Setting.attributCle.copier();
/* 1520 */     att.setEntiteRelation(ent.getEntite());
/* 1521 */     ent.getEntite().getListeAttributs().add(att);
/*      */   }
/*      */   
/*      */   private boolean ajouterLienEntiteRelationRaccourci(IhmEntiteRelation ent1, IhmEntiteRelation ent2) {
/* 1525 */     if (((ent1 instanceof IhmRelation2)) && 
/* 1526 */       ((ent2 instanceof IhmEntite2))) {
/* 1527 */       IhmLien2 l = new IhmLien2((IhmEntite2)ent2, (IhmRelation2)ent1);
/* 1528 */       this.listeLien.add(l);
/* 1529 */       l.setSelected(false);
/* 1530 */       this.entRelaSelect1.setSelected(false);
/* 1531 */       this.entRelaSelect2.setSelected(false);
/*      */       
/* 1533 */       this.entRelaSelect2 = null;
/* 1534 */       this.entRelaSelect1 = null;
/* 1535 */       return true;
/*      */     }
/*      */     
/* 1538 */     if (((ent2 instanceof IhmRelation2)) && 
/* 1539 */       ((ent1 instanceof IhmEntite2))) {
/* 1540 */       IhmLien2 l = new IhmLien2((IhmEntite2)ent1, (IhmRelation2)ent2);
/* 1541 */       this.listeLien.add(l);
/* 1542 */       this.entRelaSelect1.setSelected(false);
/* 1543 */       this.entRelaSelect2.setSelected(false);
/* 1544 */       l.setSelected(false);
/* 1545 */       this.entRelaSelect2 = null;
/* 1546 */       this.entRelaSelect1 = null;
/* 1547 */       return true;
/*      */     }
/*      */     
/* 1550 */     if (((ent1 instanceof IhmEntite2)) && ((ent2 instanceof IhmEntite2)) && 
/* 1551 */       (Setting.desactiverHeritage)) {
/* 1552 */       ajouterRelationDirect((IhmEntite2)ent1, (IhmEntite2)ent2);
/* 1553 */       this.entRelaSelect1.setSelected(false);
/* 1554 */       this.entRelaSelect2.setSelected(false);
/* 1555 */       this.entRelaSelect2 = null;
/* 1556 */       this.entRelaSelect1 = null;
/* 1557 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1563 */     return false;
/*      */   }
/*      */   
/*      */   public void mouseClicked(MouseEvent e) {}
/*      */   
/*      */   public void mousePressed(MouseEvent e)
/*      */   {
/* 1570 */     if (this.CTRLButton) {
/* 1571 */       if (e.getClickCount() == 2) {
/* 1572 */         if (this.bar.getEtat().equals("RIEN")) {
/* 1573 */           remiseANullLesSelectionner();
/* 1574 */           setSelected(false);
/* 1575 */           if (addBreakPoint((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom))) {
/* 1576 */             this.frmMcd.setModifier(true);
/* 1577 */             repaint();
/* 1578 */             return;
/*      */           }
/* 1580 */           repaint();
/*      */         }
/*      */       }
/*      */       else {
/* 1584 */         ajouterSelect((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1585 */         repaint();
/* 1586 */         return;
/*      */       }
/*      */     }
/*      */     
/* 1590 */     if (e.getButton() == 1) {
/* 1591 */       if (!estDansGroupe((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom))) setSelected(false);
/* 1592 */       if (e.getClickCount() == 2) {
/* 1593 */         if (this.bar.getEtat().equals("RIEN")) {
/* 1594 */           proprieteElementSel();
/* 1595 */           if (this.entRelaSelect != null) {
/* 1596 */             if (((int)(e.getX() / this.zoom) > this.entRelaSelect.getX()) && ((int)(e.getY() / this.zoom) > this.entRelaSelect.getY()) && ((int)(e.getX() / this.zoom) < this.entRelaSelect.getX() + this.entRelaSelect.getWidth()) && ((int)(e.getY() / this.zoom) < this.entRelaSelect.getY() + this.entRelaSelect.getHeight()))
/*      */             {
/* 1598 */               if (this.entRelaSelect.getClass().getName().equals("IhmMCD2.IhmEntite2"))
/* 1599 */                 new FormeEntite2(this.frm, true, (IhmEntite2)this.entRelaSelect, this.listeEntiteRelation).setVisible(true); else
/* 1600 */                 new FormeEntite2(this.frm, true, (IhmRelation2)this.entRelaSelect, this.listeEntiteRelation).setVisible(true);
/*      */             }
/* 1602 */             this.frm.getExplorer().getTree().updateUI();
/*      */           }
/* 1604 */           else if (this.lienSel != null) {
/* 1605 */             new FormeCardinalite2(this.frm, true, (IhmLien2)this.lienSel, e.getX(), e.getY()).setVisible(true);
/*      */           } else {
/* 1607 */             this.commSelect = selectedCommentaire((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1608 */             if (this.commSelect != null) {
/* 1609 */               if ((this.commSelect instanceof IhmPostIt2))
/* 1610 */                 new FormePostIt(this.frm, true, (IhmPostIt2)this.commSelect).setVisible(true); else
/* 1611 */                 new FormeCommentaire2(this.frm, true, (IhmCommentaire2)this.commSelect).setVisible(true);
/*      */             } else {
/* 1613 */               this.cifSelect = selectedCif((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1614 */               if (this.cifSelect != null) {
/* 1615 */                 new FormeCIF2(this.frm, true, (IhmCIF2)this.cifSelect).setVisible(true);
/*      */               }
/*      */               else {
/* 1618 */                 this.lienCifSel = selectedLienCif((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1619 */                 if (this.lienCifSel != null) {
/* 1620 */                   new FormeLienCif2(this.frm, true, (IhmLienCIF2)this.lienCifSel, 0, 0).setVisible(true);
/*      */                 } else {
/* 1622 */                   this.lienHeritageSel = selectedLienHeritage((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1623 */                   if (this.lienHeritageSel != null) {
/* 1624 */                     new FormeLienHeritageIndep(this.frm, true, this.lienHeritageSel, (int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom)).setVisible(true);
/*      */                   } else {
/* 1626 */                     this.contrainteSel = selectedContrainte((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1627 */                     if (this.contrainteSel != null) {
/* 1628 */                       new FormeContrainte2(this.frm, true, (IhmContrainte2)this.contrainteSel, (int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom)).setVisible(true);
/*      */                     } else {
/* 1630 */                       this.heritageSelect = selectedHeritageContrainte((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1631 */                       if (this.heritageSelect != null) {
/* 1632 */                         new FormeContrainteHeritage2(this.frm, true, (IhmHeritage2)this.heritageSelect).setVisible(true);
/*      */                       } else {
/* 1634 */                         this.lienContrSel = selectedLienContrainte((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1635 */                         if (this.lienContrSel != null) {
/* 1636 */                           new FormeLienContraintes2(this.frm, true, (IhmLienContraintes2)this.lienContrSel).setVisible(true);
/*      */                         } else {
/* 1638 */                           this.lienCommSelect = selectedLienCommentaire((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1639 */                           if (this.lienCommSelect != null) {
/* 1640 */                             new FormeLienCommentaire2(this.frm, true, (IhmLienCommentaire2)this.lienCommSelect).setVisible(true);
/*      */                           } else {
/* 1642 */                             this.lienContrHeritageSel = selectedLienHeritagecontrainte((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1643 */                             if (this.lienContrHeritageSel != null) {
/* 1644 */                               new FormeLienHeritageContrainte2(this.frm, true, (IhmLienContrainteHeritage2)this.lienContrHeritageSel).setVisible(true);
/*      */                             } else {
/* 1646 */                               this.cadreSelect = selectedCadre((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1647 */                               if (this.cadreSelect != null) {
/* 1648 */                                 new FormeCadre2(this.frm, true, (IhmCadre2)this.cadreSelect).setVisible(true);
/*      */                               }
/*      */                             }
/*      */                           }
/*      */                         }
/*      */                       }
/*      */                     }
/*      */                   }
/*      */                 }
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*      */       } else {
/* 1662 */         if (this.EntiteKey) {
/* 1663 */           this.entRelaSelect = new IhmEntite2(new Entite2("entite"), (int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), this.frmMcd.getConfig().isIsVariable());
/* 1664 */           this.listeEntiteRelation.add(this.entRelaSelect);
/* 1665 */           ajouterAttributClePourEntite((IhmEntite2)this.entRelaSelect);
/*      */           
/* 1667 */           this.frmMcd.setModifier(true);
/* 1668 */           this.frm.getExplorer().ajouterNode((IhmEntite2)this.entRelaSelect, this.frmMcd.getEntiteNode());
/* 1669 */           this.frm.getExplorer().getTree().updateUI();
/* 1670 */           repaint();
/* 1671 */           return;
/*      */         }
/* 1673 */         if (this.relationKey) {
/* 1674 */           this.entRelaSelect = new IhmRelation2(new Relation2("relation"), (int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), this.frmMcd.getConfig().isIsVariable());
/* 1675 */           this.listeEntiteRelation.add(this.entRelaSelect);
/* 1676 */           this.frmMcd.setModifier(true);
/* 1677 */           this.frm.getExplorer().ajouterNode((IhmRelation2)this.entRelaSelect, this.frmMcd.getRelationNode());
/* 1678 */           this.frm.getExplorer().getTree().updateUI();
/* 1679 */           repaint();
/* 1680 */           return;
/*      */         }
/*      */         
/* 1683 */         if (this.cifKey)
/*      */         {
/* 1685 */           this.cifSelect = new IhmCIF2((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), 27, 25);
/* 1686 */           this.listeCIF.add(this.cifSelect);
/* 1687 */           this.frmMcd.setModifier(true);
/* 1688 */           this.cifSelect.setSelected(false);
/* 1689 */           this.cifSelect = null;
/* 1690 */           this.bar.setEtat("RIEN");
/* 1691 */           this.bar.getBtRien().setSelected(true);
/* 1692 */           this.frm.getStatutBar().setStatutLab("Mode SELECTION");
/* 1693 */           repaint();
/* 1694 */           return;
/*      */         }
/*      */         
/* 1697 */         if (this.contrainteKey) {
/* 1698 */           this.contrainteSel = new IhmContrainte2((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), 20, 20);
/* 1699 */           this.listeContrainte.add(this.contrainteSel);
/* 1700 */           this.frmMcd.setModifier(true);
/* 1701 */           this.contrainteSel.setSelected(false);
/* 1702 */           this.contrainteSel = null;
/* 1703 */           this.bar.setEtat("RIEN");
/* 1704 */           this.bar.getBtRien().setSelected(true);
/* 1705 */           this.frm.getStatutBar().setStatutLab("Mode SELECTION");
/* 1706 */           repaint();
/* 1707 */           return;
/*      */         }
/*      */         
/* 1710 */         if (this.LIENKey)
/*      */         {
/* 1712 */           if (this.entRelaSelect1 == null) {
/* 1713 */             this.Sx = ((int)(e.getX() / this.zoom));
/* 1714 */             this.Sy = ((int)(e.getY() / this.zoom));
/* 1715 */             this.Fx = ((int)(e.getX() / this.zoom));
/* 1716 */             this.Fy = ((int)(e.getY() / this.zoom));
/*      */           }
/* 1718 */           if (this.entRelaSelect1 == null) {
/* 1719 */             this.entRelaSelect1 = isSelected((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/*      */           } else {
/* 1721 */             this.entRelaSelect2 = isSelected((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1722 */             if ((this.entRelaSelect2 != null) && 
/* 1723 */               (ajouterLienEntiteRelationRaccourci(this.entRelaSelect1, this.entRelaSelect2))) {
/* 1724 */               repaint();
/*      */             }
/*      */           }
/*      */           
/* 1728 */           repaint();
/* 1729 */           return;
/*      */         }
/* 1731 */         if (this.bar.getEtat().equals("ENTITE")) {
/* 1732 */           this.entRelaSelect = new IhmEntite2(new Entite2("entite"), (int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), this.frmMcd.getConfig().isIsVariable());
/* 1733 */           this.listeEntiteRelation.add(this.entRelaSelect);
/* 1734 */           ajouterAttributClePourEntite((IhmEntite2)this.entRelaSelect);
/*      */           
/* 1736 */           this.frmMcd.setModifier(true);
/* 1737 */           this.frm.getExplorer().ajouterNode((IhmEntite2)this.entRelaSelect, this.frmMcd.getEntiteNode());
/* 1738 */           this.frm.getExplorer().getTree().updateUI();
/* 1739 */           this.bar.setEtat("RIEN");
/* 1740 */           this.bar.getBtRien().setSelected(true);
/* 1741 */           this.frm.getStatutBar().setStatutLab("Mode SELECTION");
/*      */         }
/* 1743 */         if (this.bar.getEtat().equals("RELATION")) {
/* 1744 */           this.entRelaSelect = new IhmRelation2(new Relation2("relation"), (int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), this.frmMcd.getConfig().isIsVariable());
/* 1745 */           this.listeEntiteRelation.add(this.entRelaSelect);
/* 1746 */           this.frmMcd.setModifier(true);
/* 1747 */           this.frm.getExplorer().ajouterNode((IhmRelation2)this.entRelaSelect, this.frmMcd.getRelationNode());
/* 1748 */           this.frm.getExplorer().getTree().updateUI();
/* 1749 */           this.bar.setEtat("RIEN");
/* 1750 */           this.bar.getBtRien().setSelected(true);
/* 1751 */           this.frm.getStatutBar().setStatutLab("Mode SELECTION");
/*      */         }
/* 1753 */         if ((this.bar.getEtat().equals("LIEN")) && 
/* 1754 */           (this.entRelaSelect1 == null)) {
/* 1755 */           this.Sx = ((int)(e.getX() / this.zoom));
/* 1756 */           this.Sy = ((int)(e.getY() / this.zoom));
/* 1757 */           this.Fx = ((int)(e.getX() / this.zoom));
/* 1758 */           this.Fy = ((int)(e.getY() / this.zoom));
/* 1759 */           this.entRelaSelect1 = isSelected((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1760 */           if (this.entRelaSelect1 == null) {
/* 1761 */             this.entRelaSelect1 = isSelected2((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/*      */           }
/* 1763 */           if (this.entRelaSelect1 == null) {
/* 1764 */             this.entRelaSelect1 = isSelectedContrainte((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/*      */           }
/* 1766 */           if (this.entRelaSelect1 == null) {
/* 1767 */             this.entRelaSelect1 = isSelectedCommentaire((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/*      */           }
/* 1769 */           if (this.entRelaSelect1 == null) {
/* 1770 */             this.entRelaSelect1 = isSelectedHeritage((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/*      */           }
/* 1772 */           this.debutLien = false;
/* 1773 */           repaint();
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1779 */         if (this.bar.getEtat().equals("CIF")) {
/* 1780 */           this.cifSelect = new IhmCIF2((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), 27, 25);
/* 1781 */           this.listeCIF.add(this.cifSelect);
/* 1782 */           this.frmMcd.setModifier(true);
/* 1783 */           this.bar.setEtat("RIEN");
/* 1784 */           this.bar.getBtRien().setSelected(true);
/* 1785 */           this.frm.getStatutBar().setStatutLab("Mode SELECTION");
/*      */         }
/* 1787 */         if (this.bar.getEtat().equals("COMMENTAIREIND")) {
/* 1788 */           this.commSelect = new IhmCommentaire2("", (int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), 150, 40);
/* 1789 */           this.listeCommentaire.add(this.commSelect);
/* 1790 */           this.frmMcd.setModifier(true);
/* 1791 */           this.bar.setEtat("RIEN");
/* 1792 */           this.bar.getBtRien().setSelected(true);
/* 1793 */           this.frm.getStatutBar().setStatutLab("Mode SELECTION");
/*      */         }
/*      */         
/* 1796 */         if (this.bar.getEtat().equals("POSTIT")) {
/* 1797 */           this.commSelect = new IhmPostIt2("", (int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), 150, 40);
/* 1798 */           this.listeCommentaire.add(this.commSelect);
/* 1799 */           this.frmMcd.setModifier(true);
/* 1800 */           this.bar.setEtat("RIEN");
/* 1801 */           this.bar.getBtRien().setSelected(true);
/* 1802 */           this.frm.getStatutBar().setStatutLab("Mode SELECTION");
/*      */         }
/*      */         
/* 1805 */         if (this.bar.getEtat().equals("CONTRAINTE=")) {
/* 1806 */           this.contrainteSel = new IhmContrainte2((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), 20, 20);
/*      */           
/* 1808 */           this.listeContrainte.add(this.contrainteSel);
/* 1809 */           this.frmMcd.setModifier(true);
/* 1810 */           this.bar.setEtat("RIEN");
/* 1811 */           this.bar.getBtRien().setSelected(true);
/* 1812 */           this.frm.getStatutBar().setStatutLab("Mode SELECTION");
/*      */         }
/* 1814 */         if (this.bar.getEtat().equals("CADRE")) {
/* 1815 */           this.cadreSelect = new IhmCadre2((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), 300, 200);
/* 1816 */           this.listeCadre.add(this.cadreSelect);
/* 1817 */           this.frmMcd.setModifier(true);
/* 1818 */           this.bar.setEtat("RIEN");
/* 1819 */           this.bar.getBtRien().setSelected(true);
/* 1820 */           this.frm.getStatutBar().setStatutLab("Mode SELECTION");
/*      */         }
/*      */         
/* 1823 */         if (this.bar.getEtat().equals("RIEN")) {
/* 1824 */           desactiverAllLien();
/* 1825 */           if (estDansGroupe((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom))) {
/* 1826 */             this.xgroupe = ((int)(e.getX() / this.zoom));
/* 1827 */             this.ygroupe = ((int)(e.getY() / this.zoom));
/* 1828 */             setCursor(new Cursor(13));
/*      */           } else {
/* 1830 */             this.entRelaSelect = isSelected((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1831 */             if (this.entRelaSelect != null) {
/* 1832 */               activerAllLien(this.entRelaSelect);
/*      */               
/* 1834 */               setCursor(new Cursor(13));
/* 1835 */               this.Sx = ((int)(e.getX() / this.zoom) - this.entRelaSelect.getX());
/* 1836 */               this.Sy = ((int)(e.getY() / this.zoom) - this.entRelaSelect.getY());
/* 1837 */               this.lienSel = null;
/*      */             } else {
/* 1839 */               this.lienSel = selectedLien((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1840 */               if (this.lienSel != null)
/*      */               {
/* 1842 */                 this.lienSel.setSelected(true);
/* 1843 */                 this.pointSel = selectedPointCassure((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), (IhmLien2)this.lienSel);
/* 1844 */                 if (this.pointSel != null) {
/* 1845 */                   this.lienSel.setSelected(false);
/* 1846 */                   this.pointSel.setSelected(true);
/* 1847 */                   setCursor(new Cursor(5));
/* 1848 */                   this.Sx = ((int)(e.getX() / this.zoom) - this.pointSel.getX());
/* 1849 */                   this.Sy = ((int)(e.getY() / this.zoom) - this.pointSel.getY());
/*      */                 }
/*      */               } else {
/* 1852 */                 this.commSelect = selectedCommentaire((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1853 */                 if (this.commSelect != null)
/*      */                 {
/* 1855 */                   setCursor(new Cursor(13));
/* 1856 */                   this.Sx = ((int)(e.getX() / this.zoom) - this.commSelect.getX());
/* 1857 */                   this.Sy = ((int)(e.getY() / this.zoom) - this.commSelect.getY());
/*      */                 } else {
/* 1859 */                   this.cifSelect = selectedCif((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1860 */                   if (this.cifSelect != null) {
/* 1861 */                     activerAllLien(this.cifSelect);
/* 1862 */                     setCursor(new Cursor(13));
/* 1863 */                     this.Sx = ((int)(e.getX() / this.zoom) - this.cifSelect.getX());
/* 1864 */                     this.Sy = ((int)(e.getY() / this.zoom) - this.cifSelect.getY());
/*      */                   } else {
/* 1866 */                     this.lienCifSel = null;
/* 1867 */                     this.lienCifSel = selectedLienCif((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1868 */                     if (this.lienCifSel != null) {
/* 1869 */                       this.lienSel = null;
/* 1870 */                       this.lienCifSel.setSelected(true);
/* 1871 */                       this.pointSel = selectedPointCassure((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), this.lienCifSel);
/* 1872 */                       if (this.pointSel != null) {
/* 1873 */                         this.lienCifSel.setSelected(false);
/* 1874 */                         this.pointSel.setSelected(true);
/* 1875 */                         setCursor(new Cursor(5));
/* 1876 */                         this.Sx = ((int)(e.getX() / this.zoom) - this.pointSel.getX());
/* 1877 */                         this.Sy = ((int)(e.getY() / this.zoom) - this.pointSel.getY());
/*      */                       }
/*      */                     }
/*      */                     else {
/* 1881 */                       this.lienHeritageSel = selectedLienHeritage((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1882 */                       if (this.lienHeritageSel != null) {
/* 1883 */                         setCursor(new Cursor(5));
/* 1884 */                         this.Sx = ((int)((int)(e.getX() / this.zoom) - this.lienHeritageSel.getxCassure()));
/* 1885 */                         this.Sy = ((int)((int)(e.getY() / this.zoom) - this.lienHeritageSel.getyCassure()));
/*      */                       } else {
/* 1887 */                         this.contrainteSel = selectedContrainte((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1888 */                         if (this.contrainteSel != null) {
/* 1889 */                           activerAllLien(this.contrainteSel);
/* 1890 */                           setCursor(new Cursor(13));
/* 1891 */                           this.Sx = ((int)(e.getX() / this.zoom) - this.contrainteSel.getX());
/* 1892 */                           this.Sy = ((int)(e.getY() / this.zoom) - this.contrainteSel.getY());
/*      */                         } else {
/* 1894 */                           this.lienContrSel = null;
/* 1895 */                           this.lienContrSel = selectedLienContrainte((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1896 */                           if (this.lienContrSel != null) {
/* 1897 */                             ((IhmLienContraintes2)this.lienContrSel).setSelected(true);
/* 1898 */                             this.pointSel = selectedPointCassure((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), this.lienContrSel);
/* 1899 */                             if (this.pointSel != null) {
/* 1900 */                               ((IhmLienContraintes2)this.lienContrSel).setSelected(false);
/* 1901 */                               this.pointSel.setSelected(true);
/* 1902 */                               setCursor(new Cursor(5));
/* 1903 */                               this.Sx = ((int)(e.getX() / this.zoom) - this.pointSel.getX());
/* 1904 */                               this.Sy = ((int)(e.getY() / this.zoom) - this.pointSel.getY());
/*      */                             }
/*      */                           } else {
/* 1907 */                             this.lienCommSelect = null;
/* 1908 */                             this.lienCommSelect = selectedLienCommentaire((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1909 */                             if (this.lienCommSelect != null) {
/* 1910 */                               this.lienSel = null;
/* 1911 */                               this.lienCommSelect.setSelected(true);
/* 1912 */                               this.pointSel = selectedPointCassure((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), this.lienCommSelect);
/* 1913 */                               if (this.pointSel != null) {
/* 1914 */                                 this.lienCommSelect.setSelected(false);
/* 1915 */                                 this.pointSel.setSelected(true);
/* 1916 */                                 setCursor(new Cursor(5));
/* 1917 */                                 this.Sx = ((int)(e.getX() / this.zoom) - this.pointSel.getX());
/* 1918 */                                 this.Sy = ((int)(e.getY() / this.zoom) - this.pointSel.getY());
/*      */                               }
/*      */                               
/*      */                             }
/*      */                             else
/*      */                             {
/* 1924 */                               this.heritageSelect = selectedHeritageContrainte((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1925 */                               if (this.heritageSelect != null) {
/* 1926 */                                 activerAllLien(this.heritageSelect);
/* 1927 */                                 setCursor(new Cursor(13));
/* 1928 */                                 this.Sx = ((int)(e.getX() / this.zoom) - this.heritageSelect.getX());
/* 1929 */                                 this.Sy = ((int)(e.getY() / this.zoom) - this.heritageSelect.getY());
/*      */                               }
/*      */                               else {
/* 1932 */                                 this.lienContrHeritageSel = selectedLienHeritagecontrainte((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 1933 */                                 if (this.lienContrHeritageSel != null) {
/* 1934 */                                   this.lienContrHeritageSel.setSelected(true);
/* 1935 */                                   this.pointSel = selectedPointCassure((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom), this.lienContrHeritageSel);
/* 1936 */                                   if (this.pointSel != null) {
/* 1937 */                                     this.lienContrHeritageSel.setSelected(false);
/* 1938 */                                     this.pointSel.setSelected(true);
/* 1939 */                                     setCursor(new Cursor(5));
/* 1940 */                                     this.Sx = ((int)(e.getX() / this.zoom) - this.pointSel.getX());
/* 1941 */                                     this.Sy = ((int)(e.getY() / this.zoom) - this.pointSel.getY());
/*      */                                   }
/*      */                                   
/*      */ 
/*      */                                 }
/*      */                                 else
/*      */                                 {
/*      */ 
/* 1949 */                                   this.cadreSelect = selectedCadre((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/*      */                                   
/* 1951 */                                   if (this.cadreSelect != null) {
/* 1952 */                                     setCursor(new Cursor(13));
/* 1953 */                                     this.Sx = ((int)(e.getX() / this.zoom) - this.cadreSelect.getX());
/* 1954 */                                     this.Sy = ((int)(e.getY() / this.zoom) - this.cadreSelect.getY());
/*      */                                   }
/*      */                                 }
/*      */                               }
/*      */                             }
/*      */                           }
/*      */                         }
/*      */                       }
/*      */                     }
/*      */                   }
/*      */                 }
/*      */               }
/*      */             }
/*      */             
/* 1968 */             majPanelLoupe();
/* 1969 */             if ((this.entRelaSelect == null) && (this.lienSel == null) && (this.commSelect == null) && (this.cifSelect == null) && (this.lienCifSel == null) && (this.lienContrSel == null) && (this.contrainteSel == null) && (this.cadreSelect == null) && (this.lienCommSelect == null) && (this.lienHeritageSel == null) && (this.heritageSelect == null) && (this.lienContrHeritageSel == null))
/*      */             {
/*      */ 
/*      */ 
/* 1973 */               this.modeSelect = true;
/* 1974 */               this.Sx = ((int)(e.getX() / this.zoom));
/* 1975 */               this.Sy = ((int)(e.getY() / this.zoom));
/* 1976 */               this.Fx = ((int)(e.getX() / this.zoom));
/* 1977 */               this.Fy = ((int)(e.getY() / this.zoom));
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */       
/* 1983 */       repaint();
/*      */     } else {
/* 1985 */       this.boutonGauch = true;
/* 1986 */       if (this.bar.getEtat().equals("RIEN")) {
/* 1987 */         this.popMenu.show(this, e.getX(), e.getY());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void mouseReleased(MouseEvent e) {
/* 1993 */     this.boutonGauch = false;
/* 1994 */     if ((this.CTRLButton) || (this.EntiteKey) || (this.relationKey) || (this.cifKey) || (this.contrainteKey)) {
/* 1995 */       return;
/*      */     }
/* 1997 */     if (this.LIENKey) {
/* 1998 */       if (this.entRelaSelect1 != null) {
/* 1999 */         this.entRelaSelect2 = isSelected((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 2000 */         if ((this.entRelaSelect2 != null) && 
/* 2001 */           (ajouterLienEntiteRelationRaccourci(this.entRelaSelect1, this.entRelaSelect2))) {
/* 2002 */           repaint();
/*      */         }
/*      */       }
/*      */       
/* 2006 */       return;
/*      */     }
/*      */     
/* 2009 */     if (estDansGroupe((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom))) {
/* 2010 */       setCursor(new Cursor(13));
/* 2011 */       return;
/*      */     }
/* 2013 */     setCursor(new Cursor(0));
/*      */     
/*      */ 
/* 2016 */     setCursor(new Cursor(0));
/*      */     
/* 2018 */     if (this.modeSelect) {
/* 2019 */       setSelectCollection(this.Sx, this.Sy, this.Fx, this.Fy);
/* 2020 */       this.Fx = this.Sx;
/* 2021 */       this.Fy = this.Sy;
/* 2022 */       this.modeSelect = false;
/* 2023 */       repaint();
/*      */     }
/* 2025 */     if ((this.bar.getEtat().equals("LIEN")) && (!this.debutLien) && (this.entRelaSelect1 != null)) {
/* 2026 */       this.entRelaSelect2 = isSelected((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 2027 */       if (this.entRelaSelect2 == null) this.entRelaSelect2 = isSelected2((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 2028 */       if (this.entRelaSelect2 == null) this.entRelaSelect2 = isSelectedContrainte((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 2029 */       if (this.entRelaSelect2 == null) this.entRelaSelect2 = isSelectedCommentaire((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 2030 */       if (this.entRelaSelect2 == null) this.entRelaSelect2 = isSelectedHeritage((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 2031 */       if (this.entRelaSelect2 != null) {
/* 2032 */         if ((this.entRelaSelect2.getClass().getName().equals("IhmMCD2.IhmRelation2")) && (this.entRelaSelect1.getClass().getName().equals("IhmMCD2.IhmEntite2")))
/*      */         {
/*      */ 
/* 2035 */           this.lienSel = new IhmLien2((IhmEntite)this.entRelaSelect1, (IhmRelation)this.entRelaSelect2);
/* 2036 */           this.listeLien.add(this.lienSel);
/* 2037 */           this.frmMcd.setModifier(true);
/*      */ 
/*      */ 
/*      */         }
/* 2041 */         else if ((this.entRelaSelect1.getClass().getName().equals("IhmMCD2.IhmRelation2")) && (this.entRelaSelect2.getClass().getName().equals("IhmMCD2.IhmEntite2")))
/*      */         {
/*      */ 
/* 2044 */           this.lienSel = new IhmLien2((IhmEntite2)this.entRelaSelect2, (IhmRelation2)this.entRelaSelect1);
/* 2045 */           this.listeLien.add(this.lienSel);
/* 2046 */           this.frmMcd.setModifier(true);
/*      */ 
/*      */ 
/*      */         }
/* 2050 */         else if ((this.entRelaSelect1.getClass().getName().equals("IhmMCD2.IhmCIF2")) && ((this.entRelaSelect2.getClass().getName().equals("IhmMCD2.IhmEntite2")) || (this.entRelaSelect2.getClass().getName().equals("IhmMCD2.IhmRelation2"))))
/*      */         {
/*      */ 
/*      */ 
/* 2054 */           this.lienCifSel = new IhmLienCIF2(this.entRelaSelect2, (IhmCIF2)this.entRelaSelect1, "");
/* 2055 */           this.listelienCIF.add(this.lienCifSel);
/* 2056 */           this.frmMcd.setModifier(true);
/*      */ 
/*      */ 
/*      */         }
/* 2060 */         else if ((this.entRelaSelect2.getClass().getName().equals("IhmMCD2.IhmCIF2")) && ((this.entRelaSelect1.getClass().getName().equals("IhmMCD2.IhmEntite2")) || (this.entRelaSelect1.getClass().getName().equals("IhmMCD2.IhmRelation2"))))
/*      */         {
/*      */ 
/*      */ 
/* 2064 */           this.lienCifSel = new IhmLienCIF2(this.entRelaSelect1, (IhmCIF2)this.entRelaSelect2, "");
/* 2065 */           this.listelienCIF.add(this.lienCifSel);
/* 2066 */           this.frmMcd.setModifier(true);
/*      */ 
/*      */ 
/*      */ 
/*      */         }
/* 2071 */         else if (ajouterLienContrainte(this.entRelaSelect1, this.entRelaSelect2)) {
/* 2072 */           this.frmMcd.setModifier(true);
/*      */ 
/*      */ 
/*      */ 
/*      */         }
/* 2077 */         else if (ajouterLienCommentaire(this.entRelaSelect1, this.entRelaSelect2)) {
/* 2078 */           this.frmMcd.setModifier(true);
/*      */ 
/*      */ 
/*      */ 
/*      */         }
/* 2083 */         else if ((this.entRelaSelect2.getClass().getName().equals("IhmMCD2.IhmEntite2")) && (this.entRelaSelect1.getClass().getName().equals("IhmMCD2.IhmEntite2")))
/*      */         {
/* 2085 */           if (Setting.desactiverHeritage) {
/* 2086 */             ajouterRelationDirect((IhmEntite2)this.entRelaSelect2, (IhmEntite2)this.entRelaSelect1);
/*      */           } else {
/* 2088 */             ajouterHeritageIndep2((IhmEntite2)this.entRelaSelect2, (IhmEntite2)this.entRelaSelect1);
/*      */           }
/* 2090 */         } else if (((this.entRelaSelect2.getClass().getName().equals("IhmMCD2.IhmEntite2")) && (this.entRelaSelect1.getClass().getName().equals("IhmMCD2.IhmHeritage2"))) || ((this.entRelaSelect1.getClass().getName().equals("IhmMCD2.IhmEntite2")) && (this.entRelaSelect2.getClass().getName().equals("IhmMCD2.IhmHeritage2"))))
/*      */         {
/*      */ 
/*      */ 
/* 2094 */           ajouterHeritageIndep2(this.entRelaSelect2, this.entRelaSelect1);
/*      */         }
/* 2096 */         this.entRelaSelect1 = null;
/* 2097 */         this.entRelaSelect2 = null;
/* 2098 */         this.debutLien = true;
/* 2099 */         repaint();
/*      */       } else {
/* 2101 */         this.entRelaSelect1 = null;
/* 2102 */         this.entRelaSelect2 = null;
/* 2103 */         this.debutLien = true;
/*      */       }
/*      */     }
/* 2106 */     majPanelLoupe();
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
/* 2118 */     if ((this.CTRLButton) || (this.EntiteKey) || (this.relationKey) || (this.cifKey) || (this.contrainteKey)) {
/* 2119 */       return;
/*      */     }
/*      */     
/* 2122 */     if (this.LIENKey) {
/* 2123 */       this.Fx = ((int)(e.getX() / this.zoom));
/* 2124 */       this.Fy = ((int)(e.getY() / this.zoom));
/* 2125 */       repaint();
/* 2126 */       scrollRectToVisible(new Rectangle(e.getX() - 2, e.getY() - 2, 4, 4));
/*      */       
/* 2128 */       return;
/*      */     }
/* 2130 */     if ((this.bar.getEtat().equals("RIEN")) && 
/* 2131 */       (!this.boutonGauch)) {
/* 2132 */       if (estDansGroupe((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom))) {
/* 2133 */         if (!this.agrandir) deplacerGroupe(this.xgroupe - (int)(e.getX() / this.zoom), this.ygroupe - (int)(e.getY() / this.zoom));
/* 2134 */         this.xgroupe = ((int)(e.getX() / this.zoom));
/* 2135 */         this.ygroupe = ((int)(e.getY() / this.zoom));
/* 2136 */         repaint();
/*      */       }
/* 2138 */       if (this.entRelaSelect != null) {
/* 2139 */         this.entRelaSelect.redimentionner((int)(e.getX() / this.zoom) - this.Sx, (int)(e.getY() / this.zoom) - this.Sy, this.entRelaSelect.getWidth(), this.entRelaSelect.getHeight());
/* 2140 */         this.frmMcd.setModifier(true);
/* 2141 */         repaint();
/*      */         
/* 2143 */         scrollRectToVisible(new Rectangle(e.getX(), e.getY(), 1, 1));
/*      */       }
/* 2145 */       if ((this.lienSel != null) && 
/* 2146 */         (this.pointSel != null)) {
/* 2147 */         this.pointSel.move((int)(e.getX() / this.zoom) - this.Sx, (int)(e.getY() / this.zoom) - this.Sy);
/* 2148 */         this.frmMcd.setModifier(true);
/* 2149 */         repaint();
/* 2150 */         scrollRectToVisible(new Rectangle(e.getX(), e.getY(), 1, 1));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 2155 */       if (this.commSelect != null) {
/* 2156 */         this.commSelect.redimentionner((int)(e.getX() / this.zoom) - this.Sx, (int)(e.getY() / this.zoom) - this.Sy, this.commSelect.getWeidth(), this.commSelect.getHeight());
/* 2157 */         this.frmMcd.setModifier(true);
/* 2158 */         repaint();
/*      */         
/* 2160 */         scrollRectToVisible(new Rectangle(e.getX(), e.getY(), 1, 1));
/*      */       }
/* 2162 */       if (this.cifSelect != null) {
/* 2163 */         this.cifSelect.redimentionner((int)(e.getX() / this.zoom) - this.Sx, (int)(e.getY() / this.zoom) - this.Sy, this.cifSelect.getWidth(), this.cifSelect.getHeight());
/* 2164 */         this.frmMcd.setModifier(true);
/* 2165 */         repaint();
/*      */         
/* 2167 */         scrollRectToVisible(new Rectangle(e.getX(), e.getY(), 1, 1));
/*      */       }
/*      */       
/* 2170 */       if ((this.lienCifSel != null) && 
/* 2171 */         (this.pointSel != null)) {
/* 2172 */         this.pointSel.move((int)(e.getX() / this.zoom) - this.Sx, (int)(e.getY() / this.zoom) - this.Sy);
/* 2173 */         this.frmMcd.setModifier(true);
/* 2174 */         repaint();
/* 2175 */         scrollRectToVisible(new Rectangle(e.getX(), e.getY(), 1, 1));
/*      */       }
/*      */       
/*      */ 
/* 2179 */       if (this.contrainteSel != null) {
/* 2180 */         this.contrainteSel.redimentionner((int)(e.getX() / this.zoom) - this.Sx, (int)(e.getY() / this.zoom) - this.Sy, this.contrainteSel.getWidth(), this.contrainteSel.getHeight());
/* 2181 */         this.frmMcd.setModifier(true);
/* 2182 */         repaint();
/*      */         
/* 2184 */         scrollRectToVisible(new Rectangle(e.getX(), e.getY(), 1, 1));
/*      */       }
/* 2186 */       if ((this.lienContrSel != null) && 
/* 2187 */         (this.pointSel != null)) {
/* 2188 */         this.pointSel.move((int)(e.getX() / this.zoom) - this.Sx, (int)(e.getY() / this.zoom) - this.Sy);
/* 2189 */         this.frmMcd.setModifier(true);
/* 2190 */         repaint();
/* 2191 */         scrollRectToVisible(new Rectangle(e.getX(), e.getY(), 1, 1));
/*      */       }
/*      */       
/* 2194 */       if (this.lienHeritageSel != null) {
/* 2195 */         this.lienHeritageSel.redimentionnerCassure((int)(e.getX() / this.zoom) - this.Sx, (int)(e.getY() / this.zoom) - this.Sy);
/* 2196 */         this.frmMcd.setModifier(true);
/* 2197 */         repaint();
/*      */       }
/* 2199 */       if ((this.lienCommSelect != null) && 
/* 2200 */         (this.pointSel != null)) {
/* 2201 */         this.pointSel.move((int)(e.getX() / this.zoom) - this.Sx, (int)(e.getY() / this.zoom) - this.Sy);
/* 2202 */         this.frmMcd.setModifier(true);
/* 2203 */         repaint();
/* 2204 */         scrollRectToVisible(new Rectangle(e.getX(), e.getY(), 1, 1));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 2210 */       if (this.heritageSelect != null) {
/* 2211 */         this.heritageSelect.redimentionner((int)(e.getX() / this.zoom) - this.Sx, (int)(e.getY() / this.zoom) - this.Sy, this.heritageSelect.getWidth(), this.heritageSelect.getHeight());
/* 2212 */         this.frmMcd.setModifier(true);
/* 2213 */         repaint();
/*      */         
/* 2215 */         scrollRectToVisible(new Rectangle(e.getX(), e.getY(), 1, 1));
/*      */       }
/*      */       
/* 2218 */       if ((this.lienContrHeritageSel != null) && 
/* 2219 */         (this.pointSel != null)) {
/* 2220 */         this.pointSel.move((int)(e.getX() / this.zoom) - this.Sx, (int)(e.getY() / this.zoom) - this.Sy);
/* 2221 */         this.frmMcd.setModifier(true);
/* 2222 */         repaint();
/* 2223 */         scrollRectToVisible(new Rectangle(e.getX(), e.getY(), 1, 1));
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2230 */       if (this.cadreSelect != null) {
/* 2231 */         if (this.agrandir) {
/* 2232 */           if (this.coteAggrandir == 1) {
/* 2233 */             this.cadreSelect.redimentionner(this.cadreSelect.getX(), this.cadreSelect.getY(), this.cadreSelect.getWidth() + ((int)(e.getX() / this.zoom) - this.x0Souris), this.cadreSelect.getHeight());
/*      */           }
/* 2235 */           else if (this.coteAggrandir == 2) {
/* 2236 */             this.cadreSelect.redimentionner(this.cadreSelect.getX(), this.cadreSelect.getY(), this.cadreSelect.getWidth(), this.cadreSelect.getHeight() + ((int)(e.getY() / this.zoom) - this.y0souris));
/*      */           }
/* 2238 */           repaint();
/* 2239 */           this.x0Souris = ((int)(e.getX() / this.zoom));
/* 2240 */           this.y0souris = ((int)(e.getY() / this.zoom));
/*      */         } else {
/* 2242 */           this.cadreSelect.redimentionner((int)(e.getX() / this.zoom) - this.Sx, (int)(e.getY() / this.zoom) - this.Sy, this.cadreSelect.getWidth(), this.cadreSelect.getHeight());
/* 2243 */           repaint();
/*      */           
/* 2245 */           scrollRectToVisible(new Rectangle(e.getX(), e.getY(), 1, 1));
/*      */         }
/*      */       }
/*      */       
/*      */ 
/* 2250 */       if (this.modeSelect) {
/* 2251 */         this.Fx = ((int)(e.getX() / this.zoom));
/* 2252 */         this.Fy = ((int)(e.getY() / this.zoom));
/* 2253 */         setSelectCollection(this.Sx, this.Sy, this.Fx, this.Fy);
/* 2254 */         repaint();
/*      */       }
/*      */     }
/*      */     
/* 2258 */     if (this.bar.getEtat().equals("LIEN")) {
/* 2259 */       this.Fx = ((int)(e.getX() / this.zoom));
/* 2260 */       this.Fy = ((int)(e.getY() / this.zoom));
/* 2261 */       repaint();
/*      */     }
/*      */   }
/*      */   
/*      */   public void mouseMoved(MouseEvent e)
/*      */   {
/* 2267 */     if ((this.CTRLButton) || (this.EntiteKey) || (this.relationKey) || (this.cifKey) || (this.contrainteKey)) {
/* 2268 */       return;
/*      */     }
/* 2270 */     if (this.bar.getEtat().equals("RIEN")) {
/* 2271 */       if (estDansGroupe((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom))) {
/* 2272 */         this.xgroupe = ((int)(e.getX() / this.zoom));
/* 2273 */         this.ygroupe = ((int)(e.getY() / this.zoom));
/* 2274 */         setCursor(new Cursor(13));
/*      */       }
/*      */       else {
/* 2277 */         setCursor(new Cursor(0));
/*      */       }
/* 2279 */       if ((this.entRelaSelect != null) && 
/* 2280 */         ((int)(e.getX() / this.zoom) > this.entRelaSelect.getX()) && ((int)(e.getY() / this.zoom) > this.entRelaSelect.getY()) && ((int)(e.getX() / this.zoom) < this.entRelaSelect.getX() + this.entRelaSelect.getWidth()) && ((int)(e.getY() / this.zoom) < this.entRelaSelect.getY() + this.entRelaSelect.getHeight()))
/*      */       {
/*      */ 
/* 2283 */         this.Sx = ((int)(e.getX() / this.zoom) - this.entRelaSelect.getX());
/* 2284 */         this.Sy = ((int)(e.getY() / this.zoom) - this.entRelaSelect.getY());
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 2289 */       if ((this.lienSel != null) && 
/* 2290 */         (this.lienSel.isSelectedCassure((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom)))) {
/* 2291 */         this.Sx = ((int)((int)(e.getX() / this.zoom) - this.lienSel.getxCassure()));
/* 2292 */         this.Sy = ((int)((int)(e.getY() / this.zoom) - this.lienSel.getyCassure()));
/*      */       }
/*      */       
/* 2295 */       if (this.commSelect != null) {
/* 2296 */         this.Sx = ((int)(e.getX() / this.zoom) - this.commSelect.getX());
/* 2297 */         this.Sy = ((int)(e.getY() / this.zoom) - this.commSelect.getY());
/*      */       }
/* 2299 */       if (this.cadreSelect != null) {
/* 2300 */         this.coteAggrandir = this.cadreSelect.aggrandir((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/* 2301 */         this.agrandir = false;
/* 2302 */         if (this.coteAggrandir == 1) {
/* 2303 */           setCursor(new Cursor(11));
/* 2304 */           this.x0Souris = ((int)(e.getX() / this.zoom));
/* 2305 */           this.y0souris = ((int)(e.getY() / this.zoom));
/* 2306 */           this.agrandir = true;
/*      */         }
/* 2308 */         if (this.coteAggrandir == 2) {
/* 2309 */           setCursor(new Cursor(8));
/* 2310 */           this.x0Souris = ((int)(e.getX() / this.zoom));
/* 2311 */           this.y0souris = ((int)(e.getY() / this.zoom));
/* 2312 */           this.agrandir = true;
/*      */         }
/* 2314 */         if (this.coteAggrandir == -1) {
/* 2315 */           setCursor(new Cursor(0));
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 2322 */     if (Setting.nbAttAfficher > -1) { afficherImfoBull((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/*      */     }
/* 2324 */     this.statuBar.setCoordonnee((int)(e.getX() / this.zoom), (int)(e.getY() / this.zoom));
/*      */     
/*      */ 
/* 2327 */     repaint();
/*      */   }
/*      */   
/*      */ 
/*      */   public IhmEntiteRelation getEntRelaSelect()
/*      */   {
/* 2333 */     return this.entRelaSelect;
/*      */   }
/*      */   
/*      */   public IhmEntite getEntiteSel() {
/* 2337 */     return this.entiteSel;
/*      */   }
/*      */   
/*      */   public IhmLien getLienSel() {
/* 2341 */     return this.lienSel;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmLien> getListeLien() {
/* 2345 */     return this.listeLien;
/*      */   }
/*      */   
/*      */   public IhmRelation getRelationSel() {
/* 2349 */     return this.relationSel;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmEntiteRelation> getListeEntiteRelation() {
/* 2353 */     return this.listeEntiteRelation;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmCIF> getListeCIF() {
/* 2357 */     return this.listeCIF;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmCommentaireIndip> getListeCommentaire() {
/* 2361 */     return this.listeCommentaire;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmHeritage> getListeHeritage() {
/* 2365 */     return this.listeHeritage;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmLienHeritage> getListeLienHeritage() {
/* 2369 */     return this.listeLienHeritage;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmEntiteRelation> getListeContrainte() {
/* 2373 */     return this.listeContrainte;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmLienContraintes> getListeLienContrainte() {
/* 2377 */     return this.listeLienContrainte;
/*      */   }
/*      */   
/*      */   public void supprimerToutLien(IhmEntite entRel) {
/* 2381 */     int i = 0;
/* 2382 */     while (i < this.listeLien.size()) {
/* 2383 */       if (((IhmLien)this.listeLien.get(i)).getEntite().getEntite().equals(entRel.getEntite())) this.listeLien.remove(i); else
/* 2384 */         i++;
/*      */     }
/* 2386 */     i = 0;
/* 2387 */     while (i < this.listeLienContrainte.size()) {
/* 2388 */       if (((IhmLienContraintes)this.listeLienContrainte.get(i)).getEntRel().equals(entRel)) this.listeLienContrainte.remove(i); else
/* 2389 */         i++;
/*      */     }
/* 2391 */     i = 0;
/* 2392 */     while (i < this.listelienCIF.size()) {
/* 2393 */       if (((IhmLienCIF2)this.listelienCIF.get(i)).getEntiteRelation() == entRel) this.listelienCIF.remove(i); else {
/* 2394 */         i++;
/*      */       }
/*      */     }
/* 2397 */     i = 0;
/* 2398 */     while (i < this.listeLienCommentaire.size()) {
/* 2399 */       if (((IhmLienCommentaire)this.listeLienCommentaire.get(i)).getEntRel().equals(entRel)) this.listeLienCommentaire.remove(i); else {
/* 2400 */         i++;
/*      */       }
/*      */     }
/* 2403 */     deleteLienHeritageAvecContrainte(entRel);
/* 2404 */     i = 0;
/* 2405 */     while (i < this.listeLienHeritage.size()) {
/* 2406 */       if ((((IhmLienHeritage2)this.listeLienHeritage.get(i)).getPere().equals(entRel)) || (((IhmLienHeritage2)this.listeLienHeritage.get(i)).getFils().equals(entRel)))
/* 2407 */         this.listeLienHeritage.remove(i); else {
/* 2408 */         i++;
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
/*      */   public void supprimerToutLien(IhmRelation entRel)
/*      */   {
/* 2422 */     int i = 0;
/* 2423 */     while (i < this.listeLien.size()) {
/* 2424 */       if (((IhmLien)this.listeLien.get(i)).getRelation().getRelation().equals(entRel.getRelation())) this.listeLien.remove(i); else
/* 2425 */         i++;
/*      */     }
/* 2427 */     i = 0;
/* 2428 */     while (i < this.listeLienContrainte.size()) {
/* 2429 */       if (((IhmLienContraintes)this.listeLienContrainte.get(i)).getEntRel().equals(entRel)) this.listeLienContrainte.remove(i); else
/* 2430 */         i++;
/*      */     }
/* 2432 */     i = 0;
/* 2433 */     while (i < this.listeLienCommentaire.size()) {
/* 2434 */       if (((IhmLienCommentaire)this.listeLienCommentaire.get(i)).getEntRel().equals(entRel)) this.listeLienCommentaire.remove(i); else
/* 2435 */         i++;
/*      */     }
/*      */   }
/*      */   
/*      */   public void supprimerToutLien(IhmContrainte entRel) {
/* 2440 */     int i = 0;
/* 2441 */     while (i < this.listeLienContrainte.size()) {
/* 2442 */       if (((IhmLienContraintes)this.listeLienContrainte.get(i)).getContrainte().equals(entRel)) this.listeLienContrainte.remove(i); else
/* 2443 */         i++;
/*      */     }
/* 2445 */     i = 0;
/* 2446 */     while (i < this.listeLienCommentaire.size()) {
/* 2447 */       if (((IhmLienCommentaire)this.listeLienCommentaire.get(i)).getEntRel().equals(entRel)) this.listeLienCommentaire.remove(i); else
/* 2448 */         i++;
/*      */     }
/*      */   }
/*      */   
/*      */   public void supprimerToutLien(IhmCIF cifSup) {
/* 2453 */     int i = 0;
/* 2454 */     while (i < this.listelienCIF.size()) {
/* 2455 */       if (((IhmLienCif)this.listelienCIF.get(i)).getCif().equals(cifSup)) this.listelienCIF.remove(i); else
/* 2456 */         i++;
/*      */     }
/* 2458 */     i = 0;
/* 2459 */     while (i < this.listeLienCommentaire.size()) {
/* 2460 */       if (((IhmLienCommentaire)this.listeLienCommentaire.get(i)).getEntRel().equals(cifSup)) this.listeLienCommentaire.remove(i); else
/* 2461 */         i++;
/*      */     }
/*      */   }
/*      */   
/*      */   public void supprimerToutLien(IhmCommentaireIndip comm) {
/* 2466 */     int i = 0;
/* 2467 */     while (i < this.listeLienCommentaire.size()) {
/* 2468 */       if (((IhmLienCommentaire)this.listeLienCommentaire.get(i)).getCommentaire().equals(comm)) this.listeLienCommentaire.remove(i); else {
/* 2469 */         i++;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void supprimerObjetSelect()
/*      */   {
/* 2476 */     int j = 0;
/* 2477 */     for (int i = 0; i < getListeEntiteRelation().size(); i++) {
/* 2478 */       if (((IhmEntiteRelation)getListeEntiteRelation().get(i)).getClass().getName().equals("IhmMCD2.IhmEntite2")) {
/* 2479 */         if (((IhmEntite2)getListeEntiteRelation().get(i)).isSelected()) {
/* 2480 */           supprimerToutLien((IhmEntite2)getListeEntiteRelation().get(i));
/*      */         }
/*      */       }
/* 2483 */       else if (((IhmRelation2)getListeEntiteRelation().get(i)).isSelected()) {
/* 2484 */         supprimerToutLien((IhmRelation2)getListeEntiteRelation().get(i));
/*      */       }
/*      */     }
/* 2487 */     for (int i = 0; i < getListeContrainte().size(); i++) {
/* 2488 */       if (((IhmContrainte)getListeContrainte().get(i)).isSelected()) {
/* 2489 */         supprimerToutLien((IhmContrainte)getListeContrainte().get(i));
/*      */       }
/*      */     }
/* 2492 */     for (int i = 0; i < getListeCIF().size(); i++) {
/* 2493 */       if (((IhmCIF)getListeCIF().get(i)).isSelected()) {
/* 2494 */         supprimerToutLien((IhmCIF)getListeCIF().get(i));
/*      */       }
/*      */     }
/* 2497 */     for (int i = 0; i < getListeCommentaire().size(); i++) {
/* 2498 */       if (((IhmCommentaireIndip)getListeCommentaire().get(i)).isSelected()) {
/* 2499 */         supprimerToutLien((IhmCommentaireIndip)getListeCommentaire().get(i));
/*      */       }
/*      */     }
/*      */     
/* 2503 */     while (j < getListeEntiteRelation().size()) {
/* 2504 */       if (((IhmEntiteRelation)getListeEntiteRelation().get(j)).getClass().getName().equals("IhmMCD2.IhmEntite2")) {
/* 2505 */         if (((IhmEntite2)getListeEntiteRelation().get(j)).isSelected()) {
/* 2506 */           this.frm.getExplorer().supprimerNode((IhmEntite2)getListeEntiteRelation().get(j), this.frmMcd.getEntiteNode());
/* 2507 */           getListeEntiteRelation().remove(j);
/*      */         }
/*      */         else {
/* 2510 */           j++;
/*      */         }
/* 2512 */       } else if (((IhmRelation2)getListeEntiteRelation().get(j)).isSelected()) {
/* 2513 */         this.frm.getExplorer().supprimerNode((IhmRelation2)getListeEntiteRelation().get(j), this.frmMcd.getRelationNode());
/* 2514 */         this.frm.getExplorer().getTree().updateUI();
/* 2515 */         getListeEntiteRelation().remove(j);
/*      */       } else {
/* 2517 */         j++;
/*      */       }
/*      */     }
/*      */     
/* 2521 */     j = 0;
/* 2522 */     while (j < getListeContrainte().size()) {
/* 2523 */       if (((IhmContrainte)getListeContrainte().get(j)).isSelected())
/* 2524 */         getListeContrainte().remove(j); else {
/* 2525 */         j++;
/*      */       }
/*      */     }
/* 2528 */     j = 0;
/* 2529 */     while (j < getListeCIF().size()) {
/* 2530 */       if (((IhmCIF)getListeCIF().get(j)).isSelected())
/* 2531 */         getListeCIF().remove(j); else {
/* 2532 */         j++;
/*      */       }
/*      */     }
/* 2535 */     j = 0;
/* 2536 */     while (j < getListeCommentaire().size()) {
/* 2537 */       if (((IhmCommentaireIndip)getListeCommentaire().get(j)).isSelected())
/* 2538 */         getListeCommentaire().remove(j); else {
/* 2539 */         j++;
/*      */       }
/*      */     }
/* 2542 */     j = 0;
/* 2543 */     while (j < getListeHeritage().size()) {
/* 2544 */       if (((IhmHeritage)getListeHeritage().get(j)).isSelected())
/* 2545 */         deleteContrainteHeritage((IhmHeritage)getListeHeritage().get(j)); else
/* 2546 */         j++;
/*      */     }
/* 2548 */     j = 0;
/* 2549 */     while (j < getListeLienContrainteHeritage().size()) {
/* 2550 */       if (((IhmLienContrainteHeritage2)getListeLienContrainteHeritage().get(j)).isSelected()) {
/* 2551 */         deleteLienContrainteHeritage((IhmLienContrainteHeritage)getListeLienContrainteHeritage().get(j));
/*      */       }
/*      */       else
/*      */       {
/* 2555 */         ((IhmLienContrainteHeritage2)getListeLienContrainteHeritage().get(j)).supprimerPointSelectionner();
/* 2556 */         j++;
/*      */       }
/*      */     }
/*      */     
/* 2560 */     j = 0;
/* 2561 */     while (j < getListeLien().size()) {
/* 2562 */       if (((IhmLien2)getListeLien().get(j)).isSelected()) {
/* 2563 */         getListeLien().remove(j);
/*      */       }
/*      */       else {
/* 2566 */         ((IhmLien2)getListeLien().get(j)).supprimerPointSelectionner();
/* 2567 */         j++;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2576 */     j = 0;
/* 2577 */     while (j < getListelienCIF().size()) {
/* 2578 */       if (((IhmLienCIF2)getListelienCIF().get(j)).isSelected()) {
/* 2579 */         getListelienCIF().remove(j);
/*      */       }
/*      */       else {
/* 2582 */         ((IhmLienCIF2)getListelienCIF().get(j)).supprimerPointSelectionner();
/* 2583 */         j++;
/*      */       }
/*      */     }
/*      */     
/* 2587 */     j = 0;
/* 2588 */     while (j < getListeLienCommentaire().size()) {
/* 2589 */       if (((IhmLienCommentaire2)getListeLienCommentaire().get(j)).isSelected()) {
/* 2590 */         getListeLienCommentaire().remove(j);
/*      */       }
/*      */       else {
/* 2593 */         ((IhmLienCommentaire2)getListeLienCommentaire().get(j)).supprimerPointSelectionner();
/* 2594 */         j++;
/*      */       }
/*      */     }
/*      */     
/* 2598 */     j = 0;
/*      */     
/* 2600 */     while (j < getListeLienContrainte().size()) {
/* 2601 */       if (((IhmLienContraintes2)getListeLienContrainte().get(j)).isSelected()) {
/* 2602 */         getListeLienContrainte().remove(j);
/*      */       }
/*      */       else {
/* 2605 */         ((IhmLienContraintes2)getListeLienContrainte().get(j)).supprimerPointSelectionner();
/* 2606 */         j++;
/*      */       }
/*      */     }
/*      */     
/* 2610 */     j = 0;
/* 2611 */     while (j < getListeCadre().size()) {
/* 2612 */       if (((IhmCadre)getListeCadre().get(j)).isSelected())
/* 2613 */         getListeCadre().remove(j); else {
/* 2614 */         j++;
/*      */       }
/*      */     }
/* 2617 */     j = 0;
/* 2618 */     while (j < getListeLienCommentaire().size()) {
/* 2619 */       if (((IhmLienCommentaire)getListeLienCommentaire().get(j)).isSelect())
/* 2620 */         getListeLienCommentaire().remove(j); else
/* 2621 */         j++;
/*      */     }
/* 2623 */     j = 0;
/* 2624 */     while (j < getListeLienHeritage().size()) {
/* 2625 */       if (((IhmLienHeritage)getListeLienHeritage().get(j)).isSelect())
/* 2626 */         getListeLienHeritage().remove(j); else
/* 2627 */         j++;
/*      */     }
/* 2629 */     this.frmMcd.setModifier(true);
/* 2630 */     repaint();
/*      */   }
/*      */   
/*      */ 
/*      */   public double getZoom()
/*      */   {
/* 2636 */     return this.zoom;
/*      */   }
/*      */   
/*      */   public void setZoom(double zoom) {
/* 2640 */     this.zoom = zoom;
/*      */   }
/*      */   
/*      */   public void setTailleVariable(boolean variable)
/*      */   {
/* 2645 */     for (int i = 0; i < this.listeEntiteRelation.size(); i++) {
/* 2646 */       ((IhmEntiteRelation)this.listeEntiteRelation.get(i)).setVariable(variable);
/*      */     }
/*      */   }
/*      */   
/*      */   public ArrayList<IhmLienCif> getListelienCIF() {
/* 2651 */     return this.listelienCIF;
/*      */   }
/*      */   
/*      */   public void setListeCIF(ArrayList<IhmCIF> listeCIF) {
/* 2655 */     this.listeCIF = listeCIF;
/*      */   }
/*      */   
/*      */   public void setListeCommentaire(ArrayList<IhmCommentaireIndip> listeCommentaire) {
/* 2659 */     this.listeCommentaire = listeCommentaire;
/*      */   }
/*      */   
/*      */   public void setListeEntiteRelation(ArrayList<IhmEntiteRelation> listeEntiteRelation) {
/* 2663 */     this.listeEntiteRelation = listeEntiteRelation;
/*      */   }
/*      */   
/*      */   public void setListeHeritage(ArrayList<IhmHeritage> listeHeritageG) {
/* 2667 */     this.listeHeritage = listeHeritageG;
/*      */   }
/*      */   
/*      */   public void setListeLien(ArrayList<IhmLien> listeLien) {
/* 2671 */     this.listeLien = listeLien;
/*      */   }
/*      */   
/*      */   public void setListeLienHeritage(ArrayList<IhmLienHeritage> listeLienHeritage) {
/* 2675 */     this.listeLienHeritage = listeLienHeritage;
/*      */   }
/*      */   
/*      */   public void setListelienCIF(ArrayList<IhmLienCif> listelienCIF) {
/* 2679 */     this.listelienCIF = listelienCIF;
/*      */   }
/*      */   
/*      */   public void setListeContrainte(ArrayList<IhmEntiteRelation> listeContrainte) {
/* 2683 */     this.listeContrainte = listeContrainte;
/*      */   }
/*      */   
/*      */   public void setListeLienContrainte(ArrayList<IhmLienContraintes> listeLienContrainte) {
/* 2687 */     this.listeLienContrainte = listeLienContrainte;
/*      */   }
/*      */   
/*      */   public void setListeAttribut(ArrayList<Attribut> listeAttribut) {
/* 2691 */     this.listeAttribut = listeAttribut;
/*      */   }
/*      */   
/*      */   public void setListeDomaine(ArrayList<Domaine> listeDomaine) {
/* 2695 */     this.listeDomaine = listeDomaine;
/*      */   }
/*      */   
/*      */   public IhmCadre getCadreSelect() {
/* 2699 */     return this.cadreSelect;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmCadre> getListeCadre() {
/* 2703 */     return this.listeCadre;
/*      */   }
/*      */   
/*      */   public void setListeCadre(ArrayList<IhmCadre> listeCadre) {
/* 2707 */     this.listeCadre = listeCadre;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmLienCommentaire> getListeLienCommentaire() {
/* 2711 */     return this.listeLienCommentaire;
/*      */   }
/*      */   
/*      */   public void setListeLienCommentaire(ArrayList<IhmLienCommentaire> listeLienCommentaire) {
/* 2715 */     this.listeLienCommentaire = listeLienCommentaire;
/*      */   }
/*      */   
/*      */   public Principale getFrm() {
/* 2719 */     return this.frm;
/*      */   }
/*      */   
/*      */   public IhmCommentaireIndip getCommSelect() {
/* 2723 */     return this.commSelect;
/*      */   }
/*      */   
/*      */   public IhmEntiteRelation getContrainteSel() {
/* 2727 */     return this.contrainteSel;
/*      */   }
/*      */   
/*      */   public IhmLienCif getLienCifSel() {
/* 2731 */     return this.lienCifSel;
/*      */   }
/*      */   
/*      */   public IhmCIF getCifSelect() {
/* 2735 */     return this.cifSelect;
/*      */   }
/*      */   
/*      */   public IhmLienCommentaire getLienCommSelect() {
/* 2739 */     return this.lienCommSelect;
/*      */   }
/*      */   
/*      */   public IhmLienContraintes getLienContrSel() {
/* 2743 */     return this.lienContrSel;
/*      */   }
/*      */   
/*      */   public IhmLienHeritage getLienHeritageSel() {
/* 2747 */     return this.lienHeritageSel;
/*      */   }
/*      */   
/*      */   public ArrayList<Attribut> getListeAttribut() {
/* 2751 */     return this.listeAttribut;
/*      */   }
/*      */   
/*      */   public IhmHeritage getHeritageSelect() {
/* 2755 */     return this.heritageSelect;
/*      */   }
/*      */   
/*      */   public ArrayList<Domaine> getListeDomaine() {
/* 2759 */     return this.listeDomaine;
/*      */   }
/*      */   
/*      */   public IhmLienContrainteHeritage getLienContrHeritageSel() {
/* 2763 */     return this.lienContrHeritageSel;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmLienContrainteHeritage> getListeLienContrainteHeritage() {
/* 2767 */     return this.listeLienContrainteHeritage;
/*      */   }
/*      */   
/*      */   public void setLienContrHeritageSel(IhmLienContrainteHeritage lienContrHeritageSel) {
/* 2771 */     this.lienContrHeritageSel = lienContrHeritageSel;
/*      */   }
/*      */   
/*      */   public void setLienHeritageSel(IhmLienHeritage lienHeritageSel) {
/* 2775 */     this.lienHeritageSel = lienHeritageSel;
/*      */   }
/*      */   
/*      */   public void setListeLienContrainteHeritage(ArrayList<IhmLienContrainteHeritage> listeLienContrainteHeritage) {
/* 2779 */     this.listeLienContrainteHeritage = listeLienContrainteHeritage;
/*      */   }
/*      */   
/*      */   public void ajouterAttribut(String nom, String type, int longueur, int decimal) {
/* 2783 */     boolean trouver = false;
/* 2784 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/* 2785 */       if ((((Attribut)this.listeAttribut.get(i)).getNom().trim().toUpperCase().equals(nom.trim().toUpperCase())) && (((Attribut)this.listeAttribut.get(i)).getType().trim().toUpperCase().equals(type.trim().toUpperCase())))
/*      */       {
/* 2787 */         trouver = true;
/* 2788 */         break;
/*      */       }
/*      */     }
/* 2791 */     if (!trouver) {
/* 2792 */       this.listeAttribut.add(new Attribut(nom, type, longueur, decimal, "", false, "", null));
/*      */     }
/*      */   }
/*      */   
/*      */   public void ajouterAttribut(String nom, String code, String type, int longueur, int decimal) {
/* 2797 */     boolean trouver = false;
/* 2798 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/* 2799 */       if ((((Attribut)this.listeAttribut.get(i)).getNom().trim().toUpperCase().equals(nom.trim().toUpperCase())) && (((Attribut)this.listeAttribut.get(i)).getType().trim().toUpperCase().equals(type.trim().toUpperCase())))
/*      */       {
/* 2801 */         trouver = true;
/* 2802 */         break;
/*      */       }
/*      */     }
/* 2805 */     if (!trouver) {
/* 2806 */       this.listeAttribut.add(new Attribut2(nom, type, longueur, decimal, "", false, "", null));
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean existeAttribut(Attribut2 att) {
/* 2811 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/* 2812 */       if (((Attribut2)this.listeAttribut.get(i)).egale(att)) return true;
/*      */     }
/* 2814 */     return false;
/*      */   }
/*      */   
/*      */   public void ajouterAttribut(Attribut2 att) {
/* 2818 */     if (!existeAttribut(att)) {
/* 2819 */       Attribut2 a = (Attribut2)att.copier();
/* 2820 */       a.setKey("");
/* 2821 */       this.listeAttribut.add(a);
/*      */     }
/*      */   }
/*      */   
/*      */   private void ajouterContrainteHeritage(IhmEntite pere, IhmEntite fils) {
/* 2826 */     Point p = new Point((pere.getCentreX() + fils.getCentreX()) / 2, (pere.getCentreY() + fils.getCentreY()) / 2);
/* 2827 */     IhmHeritage2 cntH = new IhmHeritage2(p.getX(), p.getY(), pere, 0);
/* 2828 */     this.listeHeritage.add(cntH);
/* 2829 */     IhmLienContrainteHeritage2 l = new IhmLienContrainteHeritage2(cntH, pere);
/* 2830 */     l.setNom("Héritage");
/* 2831 */     this.listeLienContrainteHeritage.add(l);
/* 2832 */     this.listeLienContrainteHeritage.add(new IhmLienContrainteHeritage2(cntH, fils));
/*      */   }
/*      */   
/*      */   private void ajouterContrainteHeritage(IhmHeritage her, IhmEntite fils)
/*      */   {
/* 2837 */     this.listeLienContrainteHeritage.add(new IhmLienContrainteHeritage2((IhmHeritage2)her, fils));
/*      */   }
/*      */   
/*      */   private boolean existeLienHeritageDansContrainte(IhmEntiteRelation pere, IhmEntite fils) {
/* 2841 */     for (int i = 0; i < this.listeLienContrainteHeritage.size(); i++) {
/* 2842 */       if (((((IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(i)).getEntiteRelation() == fils) && (((IhmHeritage2)((IhmLienContrainteHeritage)this.listeLienContrainteHeritage.get(i)).getHeritage()).getPere() == pere)) || ((((IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(i)).getEntiteRelation() == pere) && (((IhmHeritage2)((IhmLienContrainteHeritage)this.listeLienContrainteHeritage.get(i)).getHeritage()).getPere() == fils)))
/*      */       {
/*      */ 
/*      */ 
/* 2846 */         return true; }
/*      */     }
/* 2848 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void dessinerHeritageEtContrainte(Graphics g)
/*      */   {
/* 2858 */     for (int i = 0; i < this.listeLienContrainteHeritage.size(); i++) {
/* 2859 */       ((IhmLienContrainteHeritage)this.listeLienContrainteHeritage.get(i)).paint(g);
/*      */     }
/*      */     
/*      */ 
/* 2863 */     for (int i = 0; i < this.listeLienHeritage.size(); i++) {
/* 2864 */       if (!existeLienHeritageDansContrainte(((IhmLienHeritage2)this.listeLienHeritage.get(i)).getPere(), (IhmEntite)((IhmLienHeritage2)this.listeLienHeritage.get(i)).getFils())) {
/* 2865 */         ((IhmLienHeritage)this.listeLienHeritage.get(i)).paint(g);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private IhmLienContrainteHeritage selectedLienHeritagecontrainte(int x, int y) {
/* 2871 */     for (int i = 0; i < this.listeLienContrainteHeritage.size(); i++) {
/* 2872 */       if (((IhmLienContrainteHeritage)this.listeLienContrainteHeritage.get(i)).isSelected(x, y)) {
/* 2873 */         ((IhmLienContrainteHeritage)this.listeLienContrainteHeritage.get(i)).setSelected(true);
/* 2874 */         return (IhmLienContrainteHeritage)this.listeLienContrainteHeritage.get(i);
/*      */       }
/*      */     }
/* 2877 */     return null;
/*      */   }
/*      */   
/*      */   public void supprimerToutLien(IhmHeritage her) {
/* 2881 */     int i = 0;
/* 2882 */     while (i < this.listeLienContrainteHeritage.size()) {
/* 2883 */       if (((IhmLienContrainteHeritage)this.listeLienContrainteHeritage.get(i)).getHeritage().equals(her)) {
/* 2884 */         this.listeLienContrainteHeritage.remove(i);
/*      */       } else
/* 2886 */         i++;
/*      */     }
/* 2888 */     i = 0;
/* 2889 */     while (i < this.listeLienCommentaire.size()) {
/* 2890 */       if (((IhmLienCommentaire)this.listeLienCommentaire.get(i)).getEntRel().equals(her)) this.listeLienCommentaire.remove(i); else
/* 2891 */         i++;
/*      */     }
/*      */   }
/*      */   
/*      */   public void supprimerLienHeritage(IhmLienContrainteHeritage lienH) {
/* 2896 */     int i = 0;
/* 2897 */     IhmLienContrainteHeritage2 lH = (IhmLienContrainteHeritage2)lienH;
/* 2898 */     while (i < this.listeLienHeritage.size()) {
/* 2899 */       if ((lH.getEntiteRelation() == ((IhmLienHeritage2)this.listeLienHeritage.get(i)).getFils()) && (lH.getHeritage().getPere() == ((IhmLienHeritage2)this.listeLienHeritage.get(i)).getPere()))
/*      */       {
/* 2901 */         this.listeLienHeritage.remove(i);
/*      */       } else
/* 2903 */         i++;
/*      */     }
/*      */   }
/*      */   
/*      */   public void supprimerLienHeritage(IhmHeritage her) {
/* 2908 */     int i = 0;
/* 2909 */     while (i < this.listeLienHeritage.size()) {
/* 2910 */       if (((IhmHeritage2)her).getPere() == ((IhmLienHeritage2)this.listeLienHeritage.get(i)).getPere()) {
/* 2911 */         this.listeLienHeritage.remove(i);
/*      */       } else {
/* 2913 */         i++;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void ajouterHeritageIndep(IhmEntiteRelation ent2, IhmEntiteRelation ent1)
/*      */   {
	           IhmHeritage her;
/* 2920 */     if (ent1 == ent2) return;
/* 2921 */     IhmEntite ent; if ((ent2.getClass().getName().equals("IhmMCD2.IhmEntite2")) && (ent1.getClass().getName().equals("IhmMCD2.IhmHeritage2"))) {
/* 2922 */       her = (IhmHeritage2)ent1;
/* 2923 */       ent = (IhmEntite)ent2;
/*      */     } else {
/* 2925 */       if ((ent1.getClass().getName().equals("IhmMCD2.IhmEntite2")) && (ent2.getClass().getName().equals("IhmMCD2.IhmHeritage2"))) {
/* 2926 */         her = (IhmHeritage2)ent2;
/* 2927 */         ent = (IhmEntite)ent1; } else { return; } }

/* 2930 */     if (isMultipleHeritage(ent)) {
/* 2931 */       JOptionPane.showMessageDialog(this.frm, "l'entité :" + ent.getEntite().getNom() + " posséde déjà un père", "Heritage", 1);
/*      */     }
/* 2933 */     else if (!isPereFilsDeHeritage(ent, (IhmEntite2)((IhmHeritage2)her).getPere())) {
/* 2934 */       this.frmMcd.setModifier(true);
/* 2935 */       this.lienHeritageSel = new IhmLienHeritage2((IhmEntite2)((IhmHeritage2)her).getPere(), ent);
/* 2936 */       this.lienHeritageSel.setSelected(true);
/* 2937 */       this.listeLienHeritage.add(this.lienHeritageSel);
/* 2938 */       ajouterContrainteHeritage(her, ent);
/*      */     }
/*      */     else {
/* 2941 */       JOptionPane.showMessageDialog(this.frm, "Le pere ne doit pas être le fils de ... ", "Héritage", 1);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void ajouterHeritageIndep2(IhmEntiteRelation ent2, IhmEntiteRelation ent1)
/*      */   {
				IhmHeritage her;
/* 2950 */     if (ent1 == ent2) return;
/* 2951 */     IhmEntite ent; if ((ent2.getClass().getName().equals("IhmMCD2.IhmEntite2")) && (ent1.getClass().getName().equals("IhmMCD2.IhmHeritage2"))) {
/* 2952 */       her = (IhmHeritage2)ent1;
/* 2953 */       ent = (IhmEntite)ent2;
/*      */     } else {
/* 2955 */       if ((ent1.getClass().getName().equals("IhmMCD2.IhmEntite2")) && (ent2.getClass().getName().equals("IhmMCD2.IhmHeritage2"))) {
/* 2956 */         her = (IhmHeritage2)ent2;
/* 2957 */         ent = (IhmEntite)ent1;
/*      */       } else { return; } }
/* 2961 */     IhmEntite2 entP = (IhmEntite2)((IhmHeritage2)her).getPere();
/* 2962 */     IhmEntite2 entF = (IhmEntite2)ent;
/*      */     
/* 2964 */     if (!Setting.heritageMult) {
/* 2965 */       if (VerifHeritageLienRelatif.ADejaPere(entF, this.listeLienHeritage)) {
/* 2966 */         JOptionPane.showMessageDialog(this.frm, "L'option héritage multigle est désactivée, \ndonc l'entité :" + entF.getEntite().getNom() + " posséde déjà une entité mère ", "Heritage", 1);
/* 2967 */         return;
/*      */       }
/* 2969 */       if (VerifHeritageLienRelatif.isBoucleHeritage(entF, entP, this.listeLienHeritage)) {
/* 2970 */         JOptionPane.showMessageDialog(this.frm, "Erreur une entité ne peut pas être une géralisation d'elle même (existe une boucle)", "Héritage", 1);
/* 2971 */         return;
/*      */       }
/*      */       
/* 2974 */       this.frmMcd.setModifier(true);
/* 2975 */       this.lienHeritageSel = new IhmLienHeritage2((IhmEntite2)((IhmHeritage2)her).getPere(), ent);
/* 2976 */       this.lienHeritageSel.setSelected(true);
/* 2977 */       this.listeLienHeritage.add(this.lienHeritageSel);
/* 2978 */       ajouterContrainteHeritage(her, ent);
/* 2979 */       return;
/*      */     }
/*      */     
/* 2982 */     if (VerifHeritageLienRelatif.estDejaUnPere(entF, entP, this.listeLienHeritage)) {
/* 2983 */       JOptionPane.showMessageDialog(this.frm, "L'entité : " + entF.getEntite().getNom() + " est déjà une spécialisation de l'entité " + entP.getEntite().getNom(), "Heritage", 1);
/* 2984 */       return;
/*      */     }
/*      */     
/* 2987 */     if (VerifHeritageLienRelatif.isBoucleHeritage(entF, entP, this.listeLienHeritage)) {
/* 2988 */       JOptionPane.showMessageDialog(this.frm, "Une entité ne peut pas être une géralisation d'elle même (existe une boucle)", "Héritage", 1);
/* 2989 */       return;
/*      */     }
/*      */     
/* 2992 */     if ((!Setting.heritageMemeSpecialisation2) && 
/* 2993 */       (VerifHeritageLienRelatif.estDejaUneSpecialisation(entF, entP, this.listeLienHeritage))) {
/* 2994 */       JOptionPane.showMessageDialog(this.frm, "L'option Plusieurs spécialisations de la même entité est désactivée, \ndonc l'entité :" + entF.getEntite().getNom() + " est déjà une spécialisation de l'une des entités mères de " + entP.getEntite().getNom(), "Heritage", 1);
/* 2995 */       return;
/*      */     }
/*      */     
/*      */ 
/* 2999 */     this.frmMcd.setModifier(true);
/* 3000 */     this.lienHeritageSel = new IhmLienHeritage2((IhmEntite2)((IhmHeritage2)her).getPere(), ent);
/* 3001 */     this.lienHeritageSel.setSelected(true);
/* 3002 */     this.listeLienHeritage.add(this.lienHeritageSel);
/* 3003 */     ajouterContrainteHeritage(her, ent);
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
/*      */   private int existeLienPourContrainteHeritage(IhmHeritage heri)
/*      */   {
/* 3028 */     int cpt = 0;
/* 3029 */     for (int i = 0; i < this.listeLienContrainteHeritage.size(); i++) {
/* 3030 */       if (((IhmLienContrainteHeritage)this.listeLienContrainteHeritage.get(i)).getHeritage() == heri)
/*      */       {
/*      */ 
/* 3033 */         cpt++;
/*      */       }
/*      */     }
/* 3036 */     return cpt;
/*      */   }
/*      */   
/*      */   private void deleteLienHeritageDirecte(IhmEntite ent, IhmEntite entF) {
/* 3040 */     int i = 0;
/* 3041 */     while (i < this.listeLienHeritage.size()) {
/* 3042 */       if (((((IhmLienHeritage2)this.listeLienHeritage.get(i)).getPere().equals(ent)) && (((IhmLienHeritage2)this.listeLienHeritage.get(i)).getFils().equals(entF))) || ((((IhmLienHeritage2)this.listeLienHeritage.get(i)).getPere().equals(entF)) && (((IhmLienHeritage2)this.listeLienHeritage.get(i)).getFils().equals(ent))))
/*      */       {
/* 3044 */         this.listeLienHeritage.remove(i);
/*      */       } else
/* 3046 */         i++;
/*      */     }
/*      */   }
/*      */   
/*      */   private void ajouterHeritageListe(ArrayList<IhmHeritage> li, IhmHeritage her) {
/* 3051 */     boolean exist = false;
/* 3052 */     for (int i = 0; i < li.size(); i++) {
/* 3053 */       if (((IhmHeritage)li.get(i)).equals(her)) {
/* 3054 */         exist = true;
/* 3055 */         break;
/*      */       }
/*      */     }
/* 3058 */     if (!exist) li.add(her);
/*      */   }
/*      */   
/*      */   private ArrayList<IhmHeritage> getHeritageEntite(IhmEntite ent) {
/* 3062 */     ArrayList<IhmHeritage> li = new ArrayList();
/* 3063 */     int cpt = 0;
/* 3064 */     for (int i = 0; i < this.listeLienContrainteHeritage.size(); i++) {
/* 3065 */       if ((((IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(i)).getEntiteRelation() == ent) || (((IhmHeritage2)((IhmLienContrainteHeritage)this.listeLienContrainteHeritage.get(i)).getHeritage()).getPere() == ent))
/*      */       {
/* 3067 */         ajouterHeritageListe(li, ((IhmLienContrainteHeritage)this.listeLienContrainteHeritage.get(i)).getHeritage());
/*      */       }
/*      */     }
/* 3070 */     return li;
/*      */   }
/*      */   
/*      */   private void deleteContrainteHeritageSansLienHeritage(IhmHeritage her, IhmEntite ent) {
/* 3074 */     int i = 0;
/* 3075 */     while (i < this.listeLienContrainteHeritage.size()) {
/* 3076 */       if ((((IhmLienContrainteHeritage)this.listeLienContrainteHeritage.get(i)).getHeritage() == her) && (((IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(i)).getEntiteRelation() == ent))
/*      */       {
/* 3078 */         this.listeLienContrainteHeritage.remove(i);
/*      */       } else {
/* 3080 */         i++;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void deleteContrainteHeritageSansLienHeritage2(IhmHeritage her) {
/* 3086 */     int i = 0;
/* 3087 */     while (i < this.listeLienContrainteHeritage.size()) {
/* 3088 */       if (((IhmLienContrainteHeritage)this.listeLienContrainteHeritage.get(i)).getHeritage() == her) {
/* 3089 */         this.listeLienContrainteHeritage.remove(i);
/*      */       } else
/* 3091 */         i++;
/*      */     }
/* 3093 */     i = 0;
/* 3094 */     while (i < this.listeLienCommentaire.size()) {
/* 3095 */       if (((IhmLienCommentaire)this.listeLienCommentaire.get(i)).getEntRel() == her) {
/* 3096 */         this.listeLienCommentaire.remove(i);
/*      */       } else
/* 3098 */         i++;
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean unSeulLienHeritage(IhmLienContrainteHeritage her) {
/* 3103 */     int n = getListeLienContrainteHeritage().size();
/* 3104 */     int cpt = 0;
/* 3105 */     for (int i = 0; i < n; i++) {
/* 3106 */       if (((IhmLienContrainteHeritage)getListeLienContrainteHeritage().get(i)).getHeritage().equals(her.getHeritage())) {
/* 3107 */         cpt++;
/*      */       }
/* 3109 */       if (cpt > 2) return false;
/*      */     }
/* 3111 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void deleteLienHeritageAvecContrainte(IhmEntite ent)
/*      */   {
/* 3119 */     ArrayList<IhmHeritage> li = getHeritageEntite(ent);
/*      */     
/* 3121 */     for (int i = 0; i < li.size(); i++) {
/* 3122 */       IhmHeritage her = (IhmHeritage)li.get(i);
/*      */       
/* 3124 */       if (((IhmHeritage2)her).getPere().equals(ent)) {
/* 3125 */         deleteContrainteHeritageSansLienHeritage2(her);
/* 3126 */         this.listeHeritage.remove(her);
/*      */       }
/* 3128 */       else if (existeLienPourContrainteHeritage(her) > 2) {
/* 3129 */         deleteContrainteHeritageSansLienHeritage(her, ent);
/*      */       } else {
/* 3131 */         deleteContrainteHeritageSansLienHeritage2(her);
/*      */         
/* 3133 */         this.listeHeritage.remove(her);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void deleteContrainteHeritage(IhmHeritage her)
/*      */   {
/* 3140 */     int i = 0;
/* 3141 */     while (i < this.listeLienContrainteHeritage.size()) {
/* 3142 */       if (((IhmLienContrainteHeritage)this.listeLienContrainteHeritage.get(i)).getHeritage().equals(her))
/*      */       {
/* 3144 */         deleteLienHeritageDirecte((IhmEntite)((IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(i)).getEntiteRelation(), (IhmEntite)((IhmHeritage2)((IhmLienContrainteHeritage)this.listeLienContrainteHeritage.get(i)).getHeritage()).getPere());
/*      */       }
/*      */       
/* 3147 */       i++;
/*      */     }
/*      */     
/* 3150 */     deleteContrainteHeritageSansLienHeritage2(her);
/* 3151 */     this.listeHeritage.remove(her);
/*      */   }
/*      */   
/*      */   private void deleteLienContrainteHeritage(IhmLienContrainteHeritage lie) {
/* 3155 */     IhmLienContrainteHeritage2 lh = (IhmLienContrainteHeritage2)lie;
/* 3156 */     IhmHeritage her = lh.getHeritage();
/* 3157 */     if (((IhmHeritage2)her).getPere() == lh.getEntiteRelation()) {
/* 3158 */       deleteContrainteHeritage(her);
/*      */     }
/* 3160 */     else if (existeLienPourContrainteHeritage(her) > 2) {
/* 3161 */       deleteLienHeritageDirecte((IhmEntite)lh.getEntiteRelation(), (IhmEntite)lh.getHeritage().getPere());
/*      */       
/* 3163 */       this.listeLienContrainteHeritage.remove(lh);
/*      */     } else {
/* 3165 */       deleteContrainteHeritageSansLienHeritage2(her);
/* 3166 */       deleteLienHeritageDirecte((IhmEntite)lh.getEntiteRelation(), (IhmEntite)lh.getHeritage().getPere());
/* 3167 */       this.listeHeritage.remove(her);
/*      */     }
/*      */     
/* 3170 */     if ((lh != null) && (unSeulLienHeritage(lh))) { her.setNom("");
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void calculerXYSelected()
/*      */   {
/* 3177 */     this.xSelectedMin = Integer.MAX_VALUE;
/* 3178 */     this.ySelectedMin = Integer.MAX_VALUE;
/* 3179 */     this.xSelectedMax = 0;
/* 3180 */     this.ySelectedMax = 0;
/* 3181 */     this.listeGrpSelect.clear();
/* 3182 */     for (int i = 0; i < this.listeLien.size(); i++) {
/* 3183 */       int xx = ((IhmLien2)this.listeLien.get(i)).XMinPointSelectionner();
/* 3184 */       if (this.xSelectedMin > xx) this.xSelectedMin = xx;
/* 3185 */       xx = ((IhmLien2)this.listeLien.get(i)).YMinPointSelectionner();
/* 3186 */       if (this.ySelectedMin > xx) this.ySelectedMin = xx;
/* 3187 */       xx = ((IhmLien2)this.listeLien.get(i)).XMaxPointSelectionner();
/* 3188 */       if (this.xSelectedMax < xx) this.xSelectedMax = xx;
/* 3189 */       xx = ((IhmLien2)this.listeLien.get(i)).YMaxPointSelectionner();
/* 3190 */       if (this.ySelectedMax < xx) { this.ySelectedMax = xx;
/*      */       }
/*      */     }
/* 3193 */     for (int j = 0; j < this.listeEntiteRelation.size(); j++) {
/* 3194 */       if (((IhmEntiteRelation)this.listeEntiteRelation.get(j)).isSelected()) {
/* 3195 */         this.listeGrpSelect.add(this.listeEntiteRelation.get(j));
/* 3196 */         if (this.xSelectedMin > ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX()) {
/* 3197 */           this.xSelectedMin = ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX();
/*      */         }
/* 3199 */         if (this.ySelectedMin > ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY()) {
/* 3200 */           this.ySelectedMin = ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY();
/*      */         }
/* 3202 */         if (this.xSelectedMax < ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getWidth()) {
/* 3203 */           this.xSelectedMax = (((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getWidth());
/*      */         }
/* 3205 */         if (this.ySelectedMax < ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getHeight()) {
/* 3206 */           this.ySelectedMax = (((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getHeight());
/*      */         }
/*      */       }
/*      */     }
/* 3210 */     for (int j = 0; j < this.listeCIF.size(); j++) {
/* 3211 */       if (((IhmCIF)this.listeCIF.get(j)).isSelected()) {
/* 3212 */         this.listeGrpSelect.add(this.listeCIF.get(j));
/*      */         
/* 3214 */         if (this.xSelectedMin > ((IhmCIF)this.listeCIF.get(j)).getX()) {
/* 3215 */           this.xSelectedMin = ((IhmCIF)this.listeCIF.get(j)).getX();
/*      */         }
/* 3217 */         if (this.ySelectedMin > ((IhmCIF)this.listeCIF.get(j)).getY()) {
/* 3218 */           this.ySelectedMin = ((IhmCIF)this.listeCIF.get(j)).getY();
/*      */         }
/* 3220 */         if (this.xSelectedMax < ((IhmCIF)this.listeCIF.get(j)).getX() + ((IhmCIF)this.listeCIF.get(j)).getWidth()) {
/* 3221 */           this.xSelectedMax = (((IhmCIF)this.listeCIF.get(j)).getX() + ((IhmCIF)this.listeCIF.get(j)).getWidth());
/*      */         }
/* 3223 */         if (this.ySelectedMax < ((IhmCIF)this.listeCIF.get(j)).getY() + ((IhmCIF)this.listeCIF.get(j)).getHeight()) {
/* 3224 */           this.ySelectedMax = (((IhmCIF)this.listeCIF.get(j)).getY() + ((IhmCIF)this.listeCIF.get(j)).getHeight());
/*      */         }
/*      */       }
/*      */     }
/* 3228 */     for (int h = 0; h < this.listeCommentaire.size(); h++) {
/* 3229 */       if (((IhmCommentaireIndip)this.listeCommentaire.get(h)).isSelected()) {
/* 3230 */         this.listeGrpSelect.add(this.listeCommentaire.get(h));
/* 3231 */         if (this.xSelectedMin > ((IhmCommentaireIndip)this.listeCommentaire.get(h)).getX()) {
/* 3232 */           this.xSelectedMin = ((IhmCommentaireIndip)this.listeCommentaire.get(h)).getX();
/*      */         }
/* 3234 */         if (this.ySelectedMin > ((IhmCommentaireIndip)this.listeCommentaire.get(h)).getY()) {
/* 3235 */           this.ySelectedMin = ((IhmCommentaireIndip)this.listeCommentaire.get(h)).getY();
/*      */         }
/* 3237 */         if (this.xSelectedMax < ((IhmCommentaireIndip)this.listeCommentaire.get(h)).getX() + ((IhmCommentaireIndip)this.listeCommentaire.get(h)).getWidth()) {
/* 3238 */           this.xSelectedMax = (((IhmCommentaireIndip)this.listeCommentaire.get(h)).getX() + ((IhmCommentaireIndip)this.listeCommentaire.get(h)).getWidth());
/*      */         }
/* 3240 */         if (this.ySelectedMax < ((IhmCommentaireIndip)this.listeCommentaire.get(h)).getY() + ((IhmCommentaireIndip)this.listeCommentaire.get(h)).getHeight()) {
/* 3241 */           this.ySelectedMax = (((IhmCommentaireIndip)this.listeCommentaire.get(h)).getY() + ((IhmCommentaireIndip)this.listeCommentaire.get(h)).getHeight());
/*      */         }
/*      */       }
/*      */     }
/* 3245 */     for (int h = 0; h < this.listelienCIF.size(); h++)
/*      */     {
/* 3247 */       int xx = ((IhmLienCIF2)this.listelienCIF.get(h)).XMinPointSelectionner();
/* 3248 */       if (this.xSelectedMin > xx) this.xSelectedMin = xx;
/* 3249 */       xx = ((IhmLienCIF2)this.listelienCIF.get(h)).YMinPointSelectionner();
/* 3250 */       if (this.ySelectedMin > xx) this.ySelectedMin = xx;
/* 3251 */       xx = ((IhmLienCIF2)this.listelienCIF.get(h)).XMaxPointSelectionner();
/* 3252 */       if (this.xSelectedMax < xx) this.xSelectedMax = xx;
/* 3253 */       xx = ((IhmLienCIF2)this.listelienCIF.get(h)).YMaxPointSelectionner();
/* 3254 */       if (this.ySelectedMax < xx) { this.ySelectedMax = xx;
/*      */       }
/*      */     }
/* 3257 */     for (int h = 0; h < this.listeLienHeritage.size(); h++) {
/* 3258 */       if ((((IhmLienHeritage)this.listeLienHeritage.get(h)).isSelect()) && 
/* 3259 */         (((IhmLienHeritage)this.listeLienHeritage.get(h)).isCassure())) {
/* 3260 */         if (this.xSelectedMin > ((IhmLienHeritage)this.listeLienHeritage.get(h)).getxCassure()) {
/* 3261 */           this.xSelectedMin = ((int)((IhmLienHeritage)this.listeLienHeritage.get(h)).getxCassure());
/*      */         }
/* 3263 */         if (this.ySelectedMin > ((IhmLienHeritage)this.listeLienHeritage.get(h)).getyCassure()) {
/* 3264 */           this.ySelectedMin = ((int)((IhmLienHeritage)this.listeLienHeritage.get(h)).getyCassure());
/*      */         }
/* 3266 */         if (this.xSelectedMax < ((IhmLienHeritage)this.listeLienHeritage.get(h)).getxCassure()) {
/* 3267 */           this.xSelectedMax = ((int)((IhmLienHeritage)this.listeLienHeritage.get(h)).getxCassure());
/*      */         }
/* 3269 */         if (this.ySelectedMax < ((IhmLienHeritage)this.listeLienHeritage.get(h)).getyCassure()) {
/* 3270 */           this.ySelectedMax = ((int)((IhmLienHeritage)this.listeLienHeritage.get(h)).getyCassure());
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 3275 */     for (int h = 0; h < this.listeContrainte.size(); h++) {
/* 3276 */       if (((IhmEntiteRelation)this.listeContrainte.get(h)).isSelected()) {
/* 3277 */         this.listeGrpSelect.add(this.listeContrainte.get(h));
/* 3278 */         if (this.xSelectedMin > ((IhmEntiteRelation)this.listeContrainte.get(h)).getX()) {
/* 3279 */           this.xSelectedMin = ((IhmEntiteRelation)this.listeContrainte.get(h)).getX();
/*      */         }
/* 3281 */         if (this.ySelectedMin > ((IhmEntiteRelation)this.listeContrainte.get(h)).getY()) {
/* 3282 */           this.ySelectedMin = ((IhmEntiteRelation)this.listeContrainte.get(h)).getY();
/*      */         }
/* 3284 */         if (this.xSelectedMax < ((IhmEntiteRelation)this.listeContrainte.get(h)).getX() + ((IhmEntiteRelation)this.listeContrainte.get(h)).getWidth()) {
/* 3285 */           this.xSelectedMax = (((IhmEntiteRelation)this.listeContrainte.get(h)).getX() + ((IhmEntiteRelation)this.listeContrainte.get(h)).getWidth());
/*      */         }
/* 3287 */         if (this.ySelectedMax < ((IhmEntiteRelation)this.listeContrainte.get(h)).getY() + ((IhmEntiteRelation)this.listeContrainte.get(h)).getHeight()) {
/* 3288 */           this.ySelectedMax = (((IhmEntiteRelation)this.listeContrainte.get(h)).getY() + ((IhmEntiteRelation)this.listeContrainte.get(h)).getHeight());
/*      */         }
/*      */       }
/*      */     }
/* 3292 */     for (int h = 0; h < this.listeLienContrainte.size(); h++)
/*      */     {
/* 3294 */       int xx = ((IhmLienContraintes2)this.listeLienContrainte.get(h)).XMinPointSelectionner();
/* 3295 */       if (this.xSelectedMin > xx) this.xSelectedMin = xx;
/* 3296 */       xx = ((IhmLienContraintes2)this.listeLienContrainte.get(h)).YMinPointSelectionner();
/* 3297 */       if (this.ySelectedMin > xx) this.ySelectedMin = xx;
/* 3298 */       xx = ((IhmLienContraintes2)this.listeLienContrainte.get(h)).XMaxPointSelectionner();
/* 3299 */       if (this.xSelectedMax < xx) this.xSelectedMax = xx;
/* 3300 */       xx = ((IhmLienContraintes2)this.listeLienContrainte.get(h)).YMaxPointSelectionner();
/* 3301 */       if (this.ySelectedMax < xx) { this.ySelectedMax = xx;
/*      */       }
/*      */     }
/* 3304 */     for (int h = 0; h < this.listeLienCommentaire.size(); h++) {
/* 3305 */       if ((this.listeLienCommentaire.get(h) instanceof IhmLienCommentaire2)) {
/* 3306 */         int xx = ((IhmLienCommentaire2)this.listeLienCommentaire.get(h)).XMinPointSelectionner();
/* 3307 */         if (this.xSelectedMin > xx) this.xSelectedMin = xx;
/* 3308 */         xx = ((IhmLienCommentaire2)this.listeLienCommentaire.get(h)).YMinPointSelectionner();
/* 3309 */         if (this.ySelectedMin > xx) this.ySelectedMin = xx;
/* 3310 */         xx = ((IhmLienCommentaire2)this.listeLienCommentaire.get(h)).XMaxPointSelectionner();
/* 3311 */         if (this.xSelectedMax < xx) this.xSelectedMax = xx;
/* 3312 */         xx = ((IhmLienCommentaire2)this.listeLienCommentaire.get(h)).YMaxPointSelectionner();
/* 3313 */         if (this.ySelectedMax < xx) { this.ySelectedMax = xx;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 3318 */     for (int h = 0; h < this.listeCadre.size(); h++) {
/* 3319 */       if (((IhmCadre)this.listeCadre.get(h)).isSelected()) {
/* 3320 */         this.listeGrpSelect.add(this.listeCadre.get(h));
/* 3321 */         if (this.xSelectedMin > ((IhmCadre)this.listeCadre.get(h)).getX()) {
/* 3322 */           this.xSelectedMin = ((IhmCadre)this.listeCadre.get(h)).getX();
/*      */         }
/* 3324 */         if (this.ySelectedMin > ((IhmCadre)this.listeCadre.get(h)).getY()) {
/* 3325 */           this.ySelectedMin = ((IhmCadre)this.listeCadre.get(h)).getY();
/*      */         }
/* 3327 */         if (this.xSelectedMax < ((IhmCadre)this.listeCadre.get(h)).getX() + ((IhmCadre)this.listeCadre.get(h)).getWidth()) {
/* 3328 */           this.xSelectedMax = (((IhmCadre)this.listeCadre.get(h)).getX() + ((IhmCadre)this.listeCadre.get(h)).getWidth());
/*      */         }
/* 3330 */         if (this.ySelectedMax < ((IhmCadre)this.listeCadre.get(h)).getY() + ((IhmCadre)this.listeCadre.get(h)).getHeight()) {
/* 3331 */           this.ySelectedMax = (((IhmCadre)this.listeCadre.get(h)).getY() + ((IhmCadre)this.listeCadre.get(h)).getHeight());
/*      */         }
/*      */       }
/*      */     }
/* 3335 */     for (int h = 0; h < this.listeHeritage.size(); h++) {
/* 3336 */       if (((IhmHeritage)this.listeHeritage.get(h)).isSelected()) {
/* 3337 */         this.listeGrpSelect.add(this.listeHeritage.get(h));
/* 3338 */         if (this.xSelectedMin > ((IhmHeritage)this.listeHeritage.get(h)).getX()) {
/* 3339 */           this.xSelectedMin = ((IhmHeritage)this.listeHeritage.get(h)).getX();
/*      */         }
/* 3341 */         if (this.ySelectedMin > ((IhmHeritage)this.listeHeritage.get(h)).getY()) {
/* 3342 */           this.ySelectedMin = ((IhmHeritage)this.listeHeritage.get(h)).getY();
/*      */         }
/* 3344 */         if (this.xSelectedMax < ((IhmHeritage)this.listeHeritage.get(h)).getX() + ((IhmHeritage)this.listeHeritage.get(h)).getWidth()) {
/* 3345 */           this.xSelectedMax = (((IhmHeritage)this.listeHeritage.get(h)).getX() + ((IhmHeritage)this.listeHeritage.get(h)).getWidth());
/*      */         }
/* 3347 */         if (this.ySelectedMax < ((IhmHeritage)this.listeHeritage.get(h)).getY() + ((IhmHeritage)this.listeHeritage.get(h)).getHeight()) {
/* 3348 */           this.ySelectedMax = (((IhmHeritage)this.listeHeritage.get(h)).getY() + ((IhmHeritage)this.listeHeritage.get(h)).getHeight());
/*      */         }
/*      */       }
/*      */     }
/* 3352 */     for (int h = 0; h < this.listeLienContrainteHeritage.size(); h++)
/*      */     {
/* 3354 */       int xx = ((IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(h)).XMinPointSelectionner();
/* 3355 */       if (this.xSelectedMin > xx) this.xSelectedMin = xx;
/* 3356 */       xx = ((IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(h)).YMinPointSelectionner();
/* 3357 */       if (this.ySelectedMin > xx) this.ySelectedMin = xx;
/* 3358 */       xx = ((IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(h)).XMaxPointSelectionner();
/* 3359 */       if (this.xSelectedMax < xx) this.xSelectedMax = xx;
/* 3360 */       xx = ((IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(h)).YMaxPointSelectionner();
/* 3361 */       if (this.ySelectedMax < xx) { this.ySelectedMax = xx;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void alignerGroupe(String type)
/*      */   {
/* 3383 */     int xMin = Integer.MAX_VALUE;
/* 3384 */     int yMin = Integer.MAX_VALUE;
/* 3385 */     int xMax = 0;
/* 3386 */     int yMax = 0;
/* 3387 */     IhmEntiteRelation entiRX = null;IhmEntiteRelation entiRY = null;
/*      */     
/* 3389 */     for (int j = 0; j < this.listeEntiteRelation.size(); j++) {
/* 3390 */       if (((IhmEntiteRelation)this.listeEntiteRelation.get(j)).isSelected()) {
/* 3391 */         if (xMin > ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX()) {
/* 3392 */           xMin = ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX();
/*      */         }
/* 3394 */         if (yMin > ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY()) {
/* 3395 */           yMin = ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY();
/*      */         }
/* 3397 */         if (xMax < ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getWidth()) {
/* 3398 */           xMax = ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getWidth();
/* 3399 */           entiRX = (IhmEntiteRelation)this.listeEntiteRelation.get(j);
/*      */         }
/* 3401 */         if (yMax < ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getHeight()) {
/* 3402 */           yMax = ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getHeight();
/* 3403 */           entiRY = (IhmEntiteRelation)this.listeEntiteRelation.get(j);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 3408 */     for (int j = 0; j < this.listeEntiteRelation.size(); j++) {
/* 3409 */       if (((IhmEntiteRelation)this.listeEntiteRelation.get(j)).isSelected()) {
/* 3410 */         if (type.trim().toUpperCase().equals("TOP")) {
/* 3411 */           ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).setY(yMin);
/*      */         }
/* 3413 */         if (type.trim().toUpperCase().equals("BAS")) {
/* 3414 */           ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).setY(((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY() + (yMax - (((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getHeight())));
/*      */         }
/*      */         
/* 3417 */         if (type.trim().toUpperCase().equals("DROITE")) {
/* 3418 */           ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).setX(((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX() + (xMax - (((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getWidth())));
/*      */         }
/* 3420 */         if (type.trim().toUpperCase().equals("GAUCHE")) {
/* 3421 */           ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).setX(xMin);
/*      */         }
/*      */       }
/*      */     }
/* 3425 */     repaint();
/*      */   }
/*      */   
/*      */   public boolean deplacerGroupe(int x, int y) {
/* 3429 */     this.xSelectedMax += x;
/* 3430 */     this.xSelectedMin += x;
/* 3431 */     this.ySelectedMax += y;
/* 3432 */     this.ySelectedMin += y;
/* 3433 */     calculerXYSelected();
/* 3434 */     if (this.xSelectedMin - x < 0) return false;
/* 3435 */     if (this.ySelectedMin - y < 0) return false;
/* 3436 */     this.frmMcd.setModifier(true);
/* 3437 */     boolean dep = false;
/* 3438 */     for (int i = 0; i < this.listeLien.size(); i++) {
/* 3439 */       dep = ((IhmLien2)this.listeLien.get(i)).deplacerPointSelectionner(x, y);
/*      */     }
/*      */     
/* 3442 */     for (int j = 0; j < this.listeEntiteRelation.size(); j++) {
/* 3443 */       if (((IhmEntiteRelation)this.listeEntiteRelation.get(j)).isSelected()) {
/* 3444 */         dep = true;
/* 3445 */         ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).setX(((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX() - x);
/* 3446 */         ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).setY(((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY() - y);
/*      */       }
/*      */     }
/* 3449 */     for (int j = 0; j < this.listeCIF.size(); j++) {
/* 3450 */       if (((IhmCIF)this.listeCIF.get(j)).isSelected()) {
/* 3451 */         dep = true;
/* 3452 */         ((IhmCIF)this.listeCIF.get(j)).setX(((IhmCIF)this.listeCIF.get(j)).getX() - x);
/* 3453 */         ((IhmCIF)this.listeCIF.get(j)).setY(((IhmCIF)this.listeCIF.get(j)).getY() - y);
/*      */       }
/*      */     }
/*      */     
/* 3457 */     for (int h = 0; h < this.listeCommentaire.size(); h++) {
/* 3458 */       if (((IhmCommentaireIndip)this.listeCommentaire.get(h)).isSelected()) {
/* 3459 */         dep = true;
/* 3460 */         ((IhmCommentaireIndip)this.listeCommentaire.get(h)).setX(((IhmCommentaireIndip)this.listeCommentaire.get(h)).getX() - x);
/* 3461 */         ((IhmCommentaireIndip)this.listeCommentaire.get(h)).setY(((IhmCommentaireIndip)this.listeCommentaire.get(h)).getY() - y);
/*      */       }
/*      */     }
/* 3464 */     for (int i = 0; i < this.listelienCIF.size(); i++) {
/* 3465 */       if (((IhmLienCIF2)this.listelienCIF.get(i)).deplacerPointSelectionner(x, y)) { dep = true;
/*      */       }
/*      */     }
/*      */     
/* 3469 */     for (int h = 0; h < this.listeLienHeritage.size(); h++) {
/* 3470 */       if ((((IhmLienHeritage)this.listeLienHeritage.get(h)).isSelect()) && 
/* 3471 */         (((IhmLienHeritage)this.listeLienHeritage.get(h)).isCassure())) {
/* 3472 */         Parametres.xcassure = ((IhmLienHeritage)this.listeLienHeritage.get(h)).getxCassure() - x;
/* 3473 */         ((IhmLienHeritage)this.listeLienHeritage.get(h)).setyCassure(((IhmLienHeritage)this.listeLienHeritage.get(h)).getyCassure() - y);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 3478 */     for (int h = 0; h < this.listeContrainte.size(); h++) {
/* 3479 */       if (((IhmEntiteRelation)this.listeContrainte.get(h)).isSelected()) {
/* 3480 */         dep = true;
/* 3481 */         ((IhmEntiteRelation)this.listeContrainte.get(h)).setX(((IhmEntiteRelation)this.listeContrainte.get(h)).getX() - x);
/* 3482 */         ((IhmEntiteRelation)this.listeContrainte.get(h)).setY(((IhmEntiteRelation)this.listeContrainte.get(h)).getY() - y);
/*      */       }
/*      */     }
/*      */     
/* 3486 */     for (int i = 0; i < this.listeLienContrainte.size(); i++) {
/* 3487 */       if (((IhmLienContraintes2)this.listeLienContrainte.get(i)).deplacerPointSelectionner(x, y)) { dep = true;
/*      */       }
/*      */     }
/* 3490 */     for (int i = 0; i < this.listeLienCommentaire.size(); i++) {
/* 3491 */       if (((IhmLienCommentaire2)this.listeLienCommentaire.get(i)).deplacerPointSelectionner(x, y)) { dep = true;
/*      */       }
/*      */     }
/* 3494 */     for (int h = 0; h < this.listeCadre.size(); h++) {
/* 3495 */       if (((IhmCadre)this.listeCadre.get(h)).isSelected()) {
/* 3496 */         dep = true;
/* 3497 */         ((IhmCadre)this.listeCadre.get(h)).setX(((IhmCadre)this.listeCadre.get(h)).getX() - x);
/* 3498 */         ((IhmCadre)this.listeCadre.get(h)).setY(((IhmCadre)this.listeCadre.get(h)).getY() - y);
/*      */       }
/*      */     }
/* 3501 */     for (int h = 0; h < this.listeHeritage.size(); h++) {
/* 3502 */       if (((IhmHeritage)this.listeHeritage.get(h)).isSelected()) {
/* 3503 */         dep = true;
/* 3504 */         ((IhmHeritage)this.listeHeritage.get(h)).setX(((IhmHeritage)this.listeHeritage.get(h)).getX() - x);
/* 3505 */         ((IhmHeritage)this.listeHeritage.get(h)).setY(((IhmHeritage)this.listeHeritage.get(h)).getY() - y);
/*      */       }
/*      */     }
/* 3508 */     for (int h = 0; h < this.listeLienContrainteHeritage.size(); h++)
/*      */     {
/* 3510 */       if (((IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(h)).deplacerPointSelectionner(x, y)) { dep = true;
/*      */       }
/*      */     }
/* 3513 */     return dep;
/*      */   }
/*      */   
/*      */   private boolean estDansGroupe(int x, int y) {
/* 3517 */     if ((x > this.xSelectedMin) && (y > this.ySelectedMin) && (x < this.xSelectedMax) && (y < this.ySelectedMax)) {
/* 3518 */       return estDansElement(x, y);
/*      */     }
/* 3520 */     return false;
/*      */   }
/*      */   
/*      */   private boolean estDansElement(int x, int y) {
/* 3524 */     for (int j = 0; j < this.listeEntiteRelation.size(); j++) {
/* 3525 */       if ((((IhmEntiteRelation)this.listeEntiteRelation.get(j)).isSelected()) && 
/* 3526 */         (x > ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX()) && (y > ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY()) && (x < ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getWidth()) && (y < ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getHeight()))
/*      */       {
/*      */ 
/* 3529 */         return true;
/*      */       }
/*      */     }
/*      */     
/* 3533 */     for (int j = 0; j < this.listeCIF.size(); j++) {
/* 3534 */       if ((((IhmCIF)this.listeCIF.get(j)).isSelected()) && 
/* 3535 */         (x > ((IhmCIF)this.listeCIF.get(j)).getX()) && (y > ((IhmCIF)this.listeCIF.get(j)).getY()) && (x < ((IhmCIF)this.listeCIF.get(j)).getX() + ((IhmCIF)this.listeCIF.get(j)).getWidth()) && (y < ((IhmCIF)this.listeCIF.get(j)).getY() + ((IhmCIF)this.listeCIF.get(j)).getHeight()))
/*      */       {
/*      */ 
/* 3538 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 3543 */     for (int j = 0; j < this.listeLien.size(); j++) {
/* 3544 */       if (((IhmLien2)this.listeLien.get(j)).getSelectedPointCassure(x, y) != null) {
/* 3545 */         return true;
/*      */       }
/*      */     }
/*      */     
/* 3549 */     for (int j = 0; j < this.listelienCIF.size(); j++) {
/* 3550 */       if (((IhmLienCIF2)this.listelienCIF.get(j)).getSelectedPointCassure(x, y) != null) {
/* 3551 */         return true;
/*      */       }
/*      */     }
/*      */     
/* 3555 */     for (int j = 0; j < this.listeLienContrainte.size(); j++) {
/* 3556 */       if (((IhmLienContraintes2)this.listeLienContrainte.get(j)).getSelectedPointCassure(x, y) != null) {
/* 3557 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 3562 */     for (int h = 0; h < this.listeCommentaire.size(); h++) {
/* 3563 */       if ((((IhmCommentaireIndip)this.listeCommentaire.get(h)).isSelected()) && 
/* 3564 */         (x > ((IhmCommentaireIndip)this.listeCommentaire.get(h)).getX()) && (y > ((IhmCommentaireIndip)this.listeCommentaire.get(h)).getY()) && (x < ((IhmCommentaireIndip)this.listeCommentaire.get(h)).getX() + ((IhmCommentaireIndip)this.listeCommentaire.get(h)).getWidth()) && (y < ((IhmCommentaireIndip)this.listeCommentaire.get(h)).getY() + ((IhmCommentaireIndip)this.listeCommentaire.get(h)).getHeight()))
/*      */       {
/*      */ 
/* 3567 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 3572 */     for (int j = 0; j < this.listeLienCommentaire.size(); j++) {
/* 3573 */       if (((this.listeLienCommentaire.get(j) instanceof IhmLienCommentaire2)) && 
/* 3574 */         (((IhmLienCommentaire2)this.listeLienCommentaire.get(j)).getSelectedPointCassure(x, y) != null)) {
/* 3575 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 3580 */     for (int h = 0; h < this.listeContrainte.size(); h++) {
/* 3581 */       if ((((IhmEntiteRelation)this.listeContrainte.get(h)).isSelected()) && 
/* 3582 */         (x > ((IhmEntiteRelation)this.listeContrainte.get(h)).getX()) && (y > ((IhmEntiteRelation)this.listeContrainte.get(h)).getY()) && (x < ((IhmEntiteRelation)this.listeContrainte.get(h)).getX() + ((IhmEntiteRelation)this.listeContrainte.get(h)).getWidth()) && (y < ((IhmEntiteRelation)this.listeContrainte.get(h)).getY() + ((IhmEntiteRelation)this.listeContrainte.get(h)).getHeight()))
/*      */       {
/*      */ 
/* 3585 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 3590 */     for (int j = 0; j < this.listeHeritage.size(); j++) {
/* 3591 */       if ((((IhmHeritage)this.listeHeritage.get(j)).isSelected()) && 
/* 3592 */         (x > ((IhmHeritage)this.listeHeritage.get(j)).getX()) && (y > ((IhmHeritage)this.listeHeritage.get(j)).getY()) && (x < ((IhmHeritage)this.listeHeritage.get(j)).getX() + ((IhmHeritage)this.listeHeritage.get(j)).getWidth()) && (y < ((IhmHeritage)this.listeHeritage.get(j)).getY() + ((IhmHeritage)this.listeHeritage.get(j)).getHeight()))
/*      */       {
/*      */ 
/* 3595 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 3600 */     for (int j = 0; j < this.listeLienContrainteHeritage.size(); j++) {
/* 3601 */       if (((IhmLienContrainteHeritage2)this.listeLienContrainteHeritage.get(j)).getSelectedPointCassure(x, y) != null) {
/* 3602 */         return true;
/*      */       }
/*      */     }
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
/* 3617 */     for (int h = 0; h < this.listeHeritage.size(); h++) {
/* 3618 */       if ((((IhmHeritage)this.listeHeritage.get(h)).isSelected()) && 
/* 3619 */         (x > ((IhmHeritage)this.listeHeritage.get(h)).getX()) && (y > ((IhmHeritage)this.listeHeritage.get(h)).getY()) && (x < ((IhmHeritage)this.listeHeritage.get(h)).getX() + ((IhmHeritage)this.listeHeritage.get(h)).getWidth()) && (y < ((IhmHeritage)this.listeHeritage.get(h)).getY() + ((IhmHeritage)this.listeHeritage.get(h)).getHeight()))
/*      */       {
/*      */ 
/* 3622 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 3627 */     return false;
/*      */   }
/*      */   
/*      */   private IhmEntiteRelation estDansEntiteAssociation(int x, int y) {
/* 3631 */     for (int j = 0; j < this.listeEntiteRelation.size(); j++) {
/* 3632 */       if ((((IhmEntiteRelation)this.listeEntiteRelation.get(j)).isSelected()) && 
/* 3633 */         (x > ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX()) && (y > ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY()) && (x < ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getX() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getWidth()) && (y < ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getY() + ((IhmEntiteRelation)this.listeEntiteRelation.get(j)).getHeight()))
/*      */       {
/*      */ 
/* 3636 */         return (IhmEntiteRelation)this.listeEntiteRelation.get(j);
/*      */       }
/*      */     }
/*      */     
/* 3640 */     return null;
/*      */   }
/*      */   
/*      */   private String infoEntite(IhmEntite ent) {
/* 3644 */     String s = "";
/* 3645 */     for (int i = 0; i < ent.getEntite().getListeAttributs().size(); i++) {
/* 3646 */       s = s + ((Attribut)ent.getEntite().getListeAttributs().get(i)).getNom() + "\n";
/*      */     }
/* 3648 */     return s;
/*      */   }
/*      */   
/*      */   private String infoEntite(IhmRelation ent) {
/* 3652 */     String s = "";
/* 3653 */     for (int i = 0; i < ent.getRelation().getListeAttributs().size(); i++) {
/* 3654 */       s = s + ((Attribut)ent.getRelation().getListeAttributs().get(i)).getNom() + "\n";
/*      */     }
/* 3656 */     return s;
/*      */   }
/*      */   
/*      */   private String infoEntite(IhmEntiteRelation ent) {
/* 3660 */     if ((ent instanceof IhmEntite2)) return infoEntite((IhmEntite2)ent);
/* 3661 */     if ((ent instanceof IhmRelation2)) return infoEntite((IhmRelation2)ent);
/* 3662 */     return "";
/*      */   }
/*      */   
/*      */   private void afficherImfoBull(int x, int y) {
/* 3666 */     IhmEntiteRelation ent = estDansEntiteAssociation(x, y);
/* 3667 */     if (ent == null) {
/* 3668 */       setToolTipText("");
/*      */     } else {
/* 3670 */       setToolTipText(infoEntite(ent));
/*      */     }
/*      */   }
/*      */   
/*      */   private void SetAllSelectedElementNull() {
/* 3675 */     this.entiteSel = null;
/* 3676 */     this.relationSel = null;
/* 3677 */     this.entRelaSelect = null;
/* 3678 */     this.entRelaSelect1 = null;
/* 3679 */     this.entRelaSelect2 = null;
/* 3680 */     this.cifSelect = null;
/* 3681 */     this.cadreSelect = null;
/* 3682 */     this.commSelect = null;
/* 3683 */     this.lienCommSelect = null;
/* 3684 */     this.lienCifSel = null;
/* 3685 */     this.heritageSelect = null;
/* 3686 */     this.lienHeritageSel = null;
/* 3687 */     this.lienContrHeritageSel = null;
/* 3688 */     this.lienContrSel = null;
/* 3689 */     this.contrainteSel = null;
/* 3690 */     this.pointSel = null;
/*      */   }
/*      */   
/*      */   private void ajouterSelect(int x, int y)
/*      */   {
/* 3695 */     SetAllSelectedElementNull();
/*      */     
/*      */ 
/* 3698 */     IhmEntiteRelation e = isSelected(x, y);
/* 3699 */     if (e != null) {
/* 3700 */       if (this.listeGrpSelect.indexOf(e) > -1) {
/* 3701 */         e.setSelected(false);
/* 3702 */         this.listeGrpSelect.remove(e);
/*      */       }
/*      */       else {
/* 3705 */         e.setSelected(true);
/* 3706 */         this.listeGrpSelect.add(e);
/*      */       }
/*      */     }
/* 3709 */     e = selectedCommentaire(x, y);
/* 3710 */     if (e != null) {
/* 3711 */       if (this.listeGrpSelect.indexOf(e) > -1) {
/* 3712 */         e.setSelected(false);
/* 3713 */         this.listeGrpSelect.remove(e);
/*      */       }
/*      */       else {
/* 3716 */         e.setSelected(true);
/* 3717 */         this.listeGrpSelect.add(e);
/*      */       }
/*      */     }
/*      */     
/* 3721 */     e = selectedCif(x, y);
/* 3722 */     if (e != null) {
/* 3723 */       if (this.listeGrpSelect.indexOf(e) > -1) {
/* 3724 */         e.setSelected(false);
/* 3725 */         this.listeGrpSelect.remove(e);
/*      */       }
/*      */       else {
/* 3728 */         e.setSelected(true);
/* 3729 */         this.listeGrpSelect.add(e);
/*      */       }
/*      */     }
/* 3732 */     e = selectedContrainte(x, y);
/* 3733 */     if (e != null) {
/* 3734 */       if (this.listeGrpSelect.indexOf(e) > -1) {
/* 3735 */         e.setSelected(false);
/* 3736 */         this.listeGrpSelect.remove(e);
/*      */       }
/*      */       else {
/* 3739 */         e.setSelected(true);
/* 3740 */         this.listeGrpSelect.add(e);
/*      */       }
/*      */     }
/* 3743 */     e = selectedHeritageContrainte(x, y);
/* 3744 */     if (e != null) {
/* 3745 */       if (this.listeGrpSelect.indexOf(e) > -1) {
/* 3746 */         e.setSelected(false);
/* 3747 */         this.listeGrpSelect.remove(e);
/*      */       }
/*      */       else {
/* 3750 */         e.setSelected(true);
/* 3751 */         this.listeGrpSelect.add(e);
/*      */       }
/*      */     }
/* 3754 */     e = selectedCadre(x, y);
/* 3755 */     if (e != null) {
/* 3756 */       if (this.listeGrpSelect.indexOf(e) > -1) {
/* 3757 */         e.setSelected(false);
/* 3758 */         this.listeGrpSelect.remove(e);
/*      */       }
/*      */       else {
/* 3761 */         e.setSelected(true);
/* 3762 */         this.listeGrpSelect.add(e);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void proprieteElementSel()
/*      */   {
/* 3770 */     int sel = 0;
/* 3771 */     if ((this.entRelaSelect == null) && (this.lienSel == null) && (this.commSelect == null) && (this.cifSelect == null) && (this.lienCifSel == null) && (this.lienContrSel == null) && (this.contrainteSel == null) && (this.cadreSelect == null) && (this.lienCommSelect == null) && (this.lienHeritageSel == null) && (this.heritageSelect == null) && (this.lienContrHeritageSel == null))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/* 3776 */       for (int i = 0; i < getListeEntiteRelation().size(); i++) {
/* 3777 */         if (((IhmEntiteRelation)getListeEntiteRelation().get(i)).isSelected()) {
/* 3778 */           sel++;
/* 3779 */           this.entRelaSelect = ((IhmEntiteRelation)getListeEntiteRelation().get(i));
/* 3780 */           if (sel > 1) {
/* 3781 */             this.entRelaSelect = null;
/* 3782 */             return;
/*      */           }
/*      */         }
/*      */       }
/*      */       
/* 3787 */       for (int i = 0; i < getListeCIF().size(); i++) {
/* 3788 */         if (((IhmCIF)getListeCIF().get(i)).isSelected()) {
/* 3789 */           sel++;
/* 3790 */           this.cifSelect = ((IhmCIF)getListeCIF().get(i));
/* 3791 */           if (sel > 1) {
/* 3792 */             this.cifSelect = null;
/* 3793 */             return;
/*      */           }
/*      */         }
/*      */       }
/*      */       
/* 3798 */       for (int i = 0; i < getListeLien().size(); i++) {
/* 3799 */         if (((IhmLien)getListeLien().get(i)).isSelected()) {
/* 3800 */           sel++;
/* 3801 */           this.lienSel = ((IhmLien)getListeLien().get(i));
/* 3802 */           if (sel > 1) {
/* 3803 */             this.lienSel = null;
/* 3804 */             return;
/*      */           }
/*      */         }
/*      */       }
/*      */       
/* 3809 */       for (int i = 0; i < getListeLienContrainte().size(); i++) {
/* 3810 */         if (((IhmLienContraintes)getListeLienContrainte().get(i)).isSelect()) {
/* 3811 */           sel++;
/* 3812 */           this.lienContrSel = ((IhmLienContraintes)getListeLienContrainte().get(i));
/* 3813 */           if (sel > 1) {
/* 3814 */             this.lienContrSel = null;
/* 3815 */             return;
/*      */           }
/*      */         }
/*      */       }
/*      */       
/* 3820 */       for (int i = 0; i < getListeLienCommentaire().size(); i++) {
/* 3821 */         if (((IhmLienCommentaire)getListeLienCommentaire().get(i)).isSelect()) {
/* 3822 */           sel++;
/* 3823 */           this.lienCommSelect = ((IhmLienCommentaire)getListeLienCommentaire().get(i));
/* 3824 */           if (sel > 1) {
/* 3825 */             this.lienCommSelect = null;
/* 3826 */             return;
/*      */           }
/*      */         }
/*      */       }
/*      */       
/* 3831 */       for (int i = 0; i < getListelienCIF().size(); i++) {
/* 3832 */         if (((IhmLienCif)getListelienCIF().get(i)).isSelect()) {
/* 3833 */           sel++;
/* 3834 */           this.lienCifSel = ((IhmLienCif)getListelienCIF().get(i));
/* 3835 */           if (sel > 1) {
/* 3836 */             this.lienCifSel = null;
/* 3837 */             return;
/*      */           }
/*      */         }
/*      */       }
/*      */       
/* 3842 */       for (int i = 0; i < getListeContrainte().size(); i++) {
/* 3843 */         if (((IhmEntiteRelation)getListeContrainte().get(i)).isSelected()) {
/* 3844 */           sel++;
/* 3845 */           this.contrainteSel = ((IhmEntiteRelation)getListeContrainte().get(i));
/* 3846 */           if (sel > 1) {
/* 3847 */             this.contrainteSel = null;
/* 3848 */             return;
/*      */           }
/*      */         }
/*      */       }
/*      */       
/* 3853 */       for (int i = 0; i < getListeCommentaire().size(); i++) {
/* 3854 */         if (((IhmCommentaireIndip)getListeCommentaire().get(i)).isSelected()) {
/* 3855 */           sel++;
/* 3856 */           this.commSelect = ((IhmCommentaireIndip)getListeCommentaire().get(i));
/* 3857 */           if (sel > 1) {
/* 3858 */             this.commSelect = null;
/* 3859 */             return;
/*      */           }
/*      */         }
/*      */       }
/*      */       
/* 3864 */       for (int i = 0; i < getListeHeritage().size(); i++) {
/* 3865 */         if (((IhmHeritage)getListeHeritage().get(i)).isSelected()) {
/* 3866 */           sel++;
/* 3867 */           this.heritageSelect = ((IhmHeritage)getListeHeritage().get(i));
/* 3868 */           if (sel > 1) {
/* 3869 */             this.heritageSelect = null;
/* 3870 */             return;
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean isCTRLButton()
/*      */   {
/* 3880 */     return this.CTRLButton;
/*      */   }
/*      */   
/*      */   public boolean isEntiteKey() {
/* 3884 */     return this.EntiteKey;
/*      */   }
/*      */   
/*      */   public boolean isRelationKey() {
/* 3888 */     return this.relationKey;
/*      */   }
/*      */   
/*      */   public int getxSelectedMin() {
/* 3892 */     return this.xSelectedMin;
/*      */   }
/*      */   
/*      */   public int getySelectedMin() {
/* 3896 */     return this.ySelectedMin;
/*      */   }
/*      */   
/*      */   public int getxSelectedMax() {
/* 3900 */     return this.xSelectedMax;
/*      */   }
/*      */   
/*      */   public int getySelectedMax() {
/* 3904 */     return this.ySelectedMax;
/*      */   }
/*      */   
/*      */   public void setCTRLButton(boolean CTRLButton) {
/* 3908 */     this.CTRLButton = CTRLButton;
/* 3909 */     if (this.LIENKey) {
/* 3910 */       if (this.entRelaSelect1 != null) {
/* 3911 */         this.entRelaSelect1.setSelected(false);
/* 3912 */         this.entRelaSelect1 = null;
/*      */       }
/* 3914 */       if (this.entRelaSelect2 != null) {
/* 3915 */         this.entRelaSelect2.setSelected(false);
/* 3916 */         this.entRelaSelect2 = null;
/*      */       }
/*      */     }
/*      */     
/* 3920 */     this.LIENKey = CTRLButton;
/* 3921 */     this.relationKey = CTRLButton;
/* 3922 */     this.EntiteKey = CTRLButton;
/* 3923 */     this.cifKey = CTRLButton;
/* 3924 */     this.contrainteKey = CTRLButton;
/* 3925 */     if (!this.LIENKey) {
/* 3926 */       this.entRelaSelect1 = null;
/* 3927 */       this.entRelaSelect2 = null;
/*      */     }
/*      */   }
/*      */   
/*      */   public void setEntiteKey(boolean b)
/*      */   {
/* 3933 */     this.EntiteKey = b;
/*      */   }
/*      */   
/*      */   public void setRelationKey(boolean b) {
/* 3937 */     this.relationKey = b;
/*      */   }
/*      */   
/*      */   public void setKey(boolean b) {
/* 3941 */     this.EntiteKey = b;
/* 3942 */     this.relationKey = b;
/* 3943 */     this.CTRLButton = b;
/* 3944 */     this.cifKey = b;
/* 3945 */     this.contrainteKey = b;
/* 3946 */     this.LIENKey = b;
/*      */   }
/*      */   
/*      */   public void setxSelectedMin(int xSelectedMin) {
/* 3950 */     this.xSelectedMin = xSelectedMin;
/*      */   }
/*      */   
/*      */   public void setySelectedMin(int ySelectedMin) {
/* 3954 */     this.ySelectedMin = ySelectedMin;
/*      */   }
/*      */   
/*      */   public void setxSelectedMax(int xSelectedMax) {
/* 3958 */     this.xSelectedMax = xSelectedMax;
/*      */   }
/*      */   
/*      */   public void setySelectedMax(int ySelectedMax) {
/* 3962 */     this.ySelectedMax = ySelectedMax;
/*      */   }
/*      */   
/*      */   public void setFormeMCD(FormeInterneMCD mcd) {
/* 3966 */     this.frmMcd = mcd;
/*      */   }
/*      */   
/*      */   public FormeInterneMCD getFormeMcd() {
/* 3970 */     return this.frmMcd;
/*      */   }
/*      */   
/*      */ 
/*      */   public void keyTyped(KeyEvent e) {}
/*      */   
/*      */ 
/*      */   public void keyPressed(KeyEvent e)
/*      */   {
/* 3979 */     if (e.getKeyCode() == 17) {
/* 3980 */       this.CTRLButton = true;
/*      */     }
/*      */     
/* 3983 */     if (e.getKeyCode() == 90) {
/* 3984 */       this.LIENKey = true;
/*      */     }
/*      */     
/*      */ 
/* 3988 */     if (e.getKeyCode() == 69) {
/* 3989 */       this.EntiteKey = true;
/*      */     }
/*      */     
/* 3992 */     if ((e.getKeyCode() == 82) || (e.getKeyCode() == 65)) {
/* 3993 */       this.relationKey = true;
/*      */     }
/*      */     
/* 3996 */     if (e.getKeyCode() == 81) {
/* 3997 */       this.contrainteKey = true;
/*      */     }
/*      */     
/* 4000 */     if (e.getKeyCode() == 83) {
/* 4001 */       this.cifKey = true;
/*      */     }
/*      */   }
/*      */   
/*      */   public void keyReleased(KeyEvent e)
/*      */   {
/* 4007 */     int dep = 1;
/* 4008 */     if (e.getKeyCode() == 17) {
/* 4009 */       this.CTRLButton = false;
/*      */     }
/*      */     
/* 4012 */     if (e.getKeyCode() == 90) {
/* 4013 */       if (this.entRelaSelect1 != null) {
/* 4014 */         this.entRelaSelect1.setSelected(false);
/* 4015 */         this.entRelaSelect1 = null;
/*      */       }
/* 4017 */       if (this.entRelaSelect2 != null) {
/* 4018 */         this.entRelaSelect2.setSelected(false);
/* 4019 */         this.entRelaSelect2 = null;
/*      */       }
/* 4021 */       this.LIENKey = false;
/* 4022 */       repaint();
/*      */     }
/*      */     
/* 4025 */     if (e.getKeyCode() == 69) {
/* 4026 */       this.EntiteKey = false;
/*      */     }
/*      */     
/* 4029 */     if (e.getKeyCode() == 83) {
/* 4030 */       this.cifKey = false;
/*      */     }
/*      */     
/* 4033 */     if (e.getKeyCode() == 81) {
/* 4034 */       this.contrainteKey = false;
/*      */     }
/*      */     
/* 4037 */     if ((e.getKeyCode() == 82) || (e.getKeyCode() == 65)) {
/* 4038 */       this.relationKey = false;
/*      */     }
/*      */     
/* 4041 */     if (this.CTRLButton) dep = 15; else {
/* 4042 */       dep = 1;
/*      */     }
/*      */     
/* 4045 */     if (e.getKeyCode() == 40) {
/* 4046 */       if (deplacerGroupe(0, -1 * dep)) {}
/*      */       
/*      */ 
/* 4049 */       repaint();
/*      */     }
/* 4051 */     if (e.getKeyCode() == 38) {
/* 4052 */       if (deplacerGroupe(0, 1 * dep)) {}
/*      */       
/*      */ 
/* 4055 */       repaint();
/*      */     }
/* 4057 */     if (e.getKeyCode() == 39) {
/* 4058 */       if (deplacerGroupe(-1 * dep, 0)) {}
/*      */       
/*      */ 
/* 4061 */       repaint();
/*      */     }
/* 4063 */     if (e.getKeyCode() == 37) {
/* 4064 */       if (deplacerGroupe(1 * dep, 0)) {}
/*      */       
/*      */ 
/* 4067 */       repaint();
/*      */     }
/*      */   }
/*      */   
/*      */   public void mouseWheelMoved(MouseWheelEvent e)
/*      */   {
/* 4073 */     if (this.CTRLButton) {
/* 4074 */       int notches = e.getWheelRotation();
/* 4075 */       if (notches < 0) {
/* 4076 */         this.zoom = this.frm.getBar().getZoom(this.frm.getBar().getjLabPrZoom().getText(), "PLUS");
/* 4077 */         repaint();
/*      */       } else {
/* 4079 */         this.zoom = this.frm.getBar().getZoom(this.frm.getBar().getjLabPrZoom().getText(), "MOINS");
/* 4080 */         repaint();
/*      */       }
/*      */     }
/*      */     else {
/* 4084 */       Rectangle r = getVisibleRect();
/* 4085 */       int notches = e.getWheelRotation();
/* 4086 */       if (notches < 0) {
/* 4087 */         if (e.isShiftDown()) scrollRectToVisible(new Rectangle((int)r.getX() - 5, (int)r.getY(), (int)r.getWidth(), (int)r.getHeight())); else {
/* 4088 */           scrollRectToVisible(new Rectangle((int)r.getX(), (int)r.getY() - 5, (int)r.getWidth(), (int)r.getHeight()));
/*      */         }
/* 4090 */         repaint();
/*      */       } else {
/* 4092 */         if (e.isShiftDown()) scrollRectToVisible(new Rectangle((int)r.getX() + 5, (int)r.getY(), (int)r.getWidth(), (int)r.getHeight())); else
/* 4093 */           scrollRectToVisible(new Rectangle((int)r.getX(), (int)r.getY() + 5, (int)r.getWidth(), (int)r.getHeight()));
/* 4094 */         repaint();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public static Point getCoordonneeNewRelation(IhmEntite ent, IhmEntite entNew)
/*      */   {
/* 4103 */     return new Point(-1 * ((ent.getX() - entNew.getX()) / 2) + ent.getX(), -1 * (ent.getY() - entNew.getY()) / 2 + ent.getY());
/*      */   }
/*      */   
/*      */   public ArrayList<IhmLien> getListLienRelation(IhmRelation rel) {
/* 4107 */     ArrayList<IhmLien> liste = new ArrayList();
/* 4108 */     for (int i = 0; i < this.listeLien.size(); i++) {
/* 4109 */       if (((IhmLien)this.listeLien.get(i)).getRelation() == rel) {
/* 4110 */         liste.add(this.listeLien.get(i));
/*      */       }
/*      */     }
/* 4113 */     return liste;
/*      */   }
/*      */   
/*      */   public IhmEntite transformeRelationEntite(IhmRelation rel) {
/* 4117 */     Entite2 e = new Entite2(rel.getRelation().getNom());
/* 4118 */     e.setListeAttributs(rel.getRelation().getListeAttributs());
/* 4119 */     return new IhmEntite2(e, rel.getX(), rel.getY(), rel.isVariable());
/*      */   }
/*      */   
/*      */   public IhmRelation getSelectedRelation() {
/* 4123 */     proprieteElementSel();
/* 4124 */     if ((this.entRelaSelect != null) && (this.entRelaSelect.getClass().getName().equals("IhmMCD2.IhmRelation2"))) {
/* 4125 */       return (IhmRelation)this.entRelaSelect;
/*      */     }
/* 4127 */     return null;
/*      */   }
/*      */   
/*      */   public void transformerRelation()
/*      */   {
/* 4132 */     IhmRelation rel = getSelectedRelation();
/*      */     
/*      */ 
/* 4135 */     if (rel == null) {
/* 4136 */       return;
/*      */     }
/* 4138 */     IhmEntite ent = transformeRelationEntite(rel);
/*      */     
/*      */ 
/*      */ 
/* 4142 */     ArrayList<IhmLien> listeL = getListLienRelation(rel);
/* 4143 */     this.listeEntiteRelation.add(ent);
/* 4144 */     this.frm.getExplorer().ajouterNode((IhmEntite2)ent, this.frmMcd.getEntiteNode());
/* 4145 */     for (int i = 0; i < listeL.size(); i++) {
/* 4146 */       Point p = getCoordonneeNewRelation(((IhmLien)listeL.get(i)).getEntite(), ent);
/* 4147 */       IhmRelation r = new IhmRelation2(new Relation2("relation"), p.getX(), p.getY(), ent.isVariable());
/* 4148 */       IhmLien2 l = new IhmLien2(ent, r);
/* 4149 */       this.frm.getExplorer().ajouterNode(r, this.frmMcd.getRelationNode());
/* 4150 */       l.setCardinalite("(1,1)");
/* 4151 */       l.setRelatif(true);
/* 4152 */       l.getCardinalites().setNom("(1,1)");
/* 4153 */       this.listeLien.add(l);
/* 4154 */       l = new IhmLien2(((IhmLien)listeL.get(i)).getEntite(), r);
/* 4155 */       l.setCardinalite(((IhmLien)listeL.get(i)).getCardinalite());
/* 4156 */       this.listeLien.add(l);
/* 4157 */       this.listeEntiteRelation.add(r);
/*      */     }
/* 4159 */     supprimerToutLien(rel);
/* 4160 */     this.listeEntiteRelation.remove(rel);
/* 4161 */     this.frm.getExplorer().supprimerNode(rel, this.frmMcd.getRelationNode());
/* 4162 */     this.frm.getExplorer().getTree().updateUI();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void ajouterRelationDirect(IhmEntite ent1, IhmEntite ent2)
/*      */   {
/* 4169 */     Point p = getCoordonneeNewRelation(ent1, ent2);
/* 4170 */     IhmRelation2 rel = new IhmRelation2(new Relation2("relation"), p.getX(), p.getY(), ent1.isVariable());
/* 4171 */     this.frm.getExplorer().ajouterNode(rel, this.frmMcd.getRelationNode());
/* 4172 */     this.frm.getExplorer().getTree().updateUI();
/* 4173 */     IhmLien2 lien = new IhmLien2(ent1, rel);
/* 4174 */     this.listeLien.add(lien);
/* 4175 */     lien.setSelected(false);
/* 4176 */     lien = new IhmLien2(ent2, rel);
/* 4177 */     this.listeLien.add(lien);
/* 4178 */     lien.setSelected(false);
/* 4179 */     this.listeEntiteRelation.add(rel);
/* 4180 */     rel.setSelected(false);
/*      */   }
/*      */   
/*      */   public ArrayList<IhmEntiteRelation> getListeGrpSelect() {
/* 4184 */     return this.listeGrpSelect;
/*      */   }
/*      */   
/*      */   public boolean sontElleDesEntites() {
/* 4188 */     if (this.listeGrpSelect.size() < 2) return false;
/* 4189 */     for (int i = 0; i < this.listeGrpSelect.size(); i++) {
/* 4190 */       if (!(this.listeGrpSelect.get(i) instanceof IhmEntite2)) {
/* 4191 */         return false;
/*      */       }
/*      */     }
/* 4194 */     return true;
/*      */   }
/*      */   
/*      */   public void ajouterRelationDirect() {
/* 4198 */     if (sontElleDesEntites()) {
/* 4199 */       Point p = getCoordonneeNewRelation((IhmEntite2)this.listeGrpSelect.get(0), (IhmEntite2)this.listeGrpSelect.get(1));
/* 4200 */       IhmRelation2 rel = new IhmRelation2(new Relation2("relation"), p.getX(), p.getY(), ((IhmEntite2)this.listeGrpSelect.get(0)).isVariable());
/* 4201 */       rel.setSelected(false);
/* 4202 */       this.listeEntiteRelation.add(rel);
/* 4203 */       this.frm.getExplorer().ajouterNode(rel, this.frmMcd.getRelationNode());
/* 4204 */       this.frm.getExplorer().getTree().updateUI();
/*      */       
/*      */ 
/* 4207 */       for (int i = 0; i < this.listeGrpSelect.size(); i++) {
/* 4208 */         IhmEntite ent = (IhmEntite2)this.listeGrpSelect.get(i);
/* 4209 */         IhmLien2 lien = new IhmLien2(ent, rel);
/* 4210 */         this.listeLien.add(lien);
/* 4211 */         lien.setSelected(false);
/*      */       }
/* 4213 */       repaint();
/*      */     }
/*      */   }
/*      */   
/*      */   private void afficherAttribut(IhmEntite2 ent)
/*      */   {
/* 4219 */     for (int i = 0; i < ent.getEntite().getListeAttributs().size(); i++) {
/* 4220 */       ((Attribut2)ent.getEntite().getListeAttributs().get(i)).setAfficher(true);
/*      */     }
/*      */   }
/*      */   
/*      */   private void afficherAttribut(IhmRelation2 rel) {
/* 4225 */     for (int i = 0; i < rel.getRelation().getListeAttributs().size(); i++) {
/* 4226 */       ((Attribut2)rel.getRelation().getListeAttributs().get(i)).setAfficher(true);
/*      */     }
/*      */   }
/*      */   
/*      */   private void adapterEntiteAuMCD(IhmEntite2 ent)
/*      */   {
/* 4232 */     ent.setPrkvisible(getConfigurationMCD().afficherPrk2);
/* 4233 */     ent.setVariable(getConfigurationMCD().afficheType2);
/* 4234 */     ent.setOmbre(getConfigurationMCD().isOmbree2);
/* 4235 */     ent.setEpaisseur(getConfigurationMCD().traitEntiteRelation2);
/* 4236 */     ent.setClOmbre(ConfigurationMCD2.getColor(getConfigurationMCD().clOmbre2));
/* 4237 */     ent.setAttMajuscule(getConfigurationMCD().typeMajuscule2);
/* 4238 */     ent.setArrondir(getConfigurationMCD().arrondirEntite2);
/* 4239 */     ent.setClDegradee(getConfigurationMCD().isDegradee2);
/* 4240 */     ent.setAttEspace(getConfigurationMCD().interLigne2);
/* 4241 */     ent.setSelected(false);
/*      */   }
/*      */   
/*      */   private void adapterRelationAuMCD(IhmRelation2 rel)
/*      */   {
/* 4246 */     rel.setPrkvisible(getConfigurationMCD().afficherPrk2);
/* 4247 */     rel.setVariable(getConfigurationMCD().afficheType2);
/* 4248 */     rel.setOmbre(getConfigurationMCD().isOmbree2);
/* 4249 */     rel.setEpaisseur(getConfigurationMCD().traitEntiteRelation2);
/* 4250 */     rel.setClOmbre(ConfigurationMCD2.getColor(getConfigurationMCD().clOmbre2));
/* 4251 */     rel.setAttMajuscule(getConfigurationMCD().typeMajuscule2);
/* 4252 */     rel.setClDegradee(getConfigurationMCD().isDegradee2);
/* 4253 */     rel.setAttEspace(getConfigurationMCD().interLigne2);
/* 4254 */     rel.setSelected(false);
/*      */   }
/*      */   
/*      */   public void adapterEntiteRelationAuMCD(IhmEntiteRelation ent) {
/* 4258 */     if ((ent instanceof IhmEntite2)) {
/* 4259 */       adapterEntiteAuMCD((IhmEntite2)ent);
/*      */     }
/* 4261 */     if ((ent instanceof IhmRelation2)) {
/* 4262 */       adapterRelationAuMCD((IhmRelation2)ent);
/*      */     }
/*      */   }
/*      */   
/*      */   public void afficherAttribut(IhmEntiteRelation entR) {
/* 4267 */     if ((entR instanceof IhmEntite2)) {
/* 4268 */       afficherAttribut((IhmEntite2)entR);
/*      */     }
/* 4270 */     if ((entR instanceof IhmRelation2)) {
/* 4271 */       afficherAttribut((IhmRelation2)entR);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean insererObjetDeLaLibrairie(String num, int x, int y) {
/* 4276 */     if (num.trim().length() == 0) {
/* 4277 */       return false;
/*      */     }
/* 4279 */     if (num.substring(0, 1).equals("¤")) {
/* 4280 */       num = num.replace("¤", "");
/* 4281 */       int n = Integer.parseInt(num);
/* 4282 */       if (n < 0) { return false;
/*      */       }
/* 4284 */       IhmEntiteRelation ent = (IhmEntiteRelation)this.frm.getPanLibibrary().getSelectedLibrary().getListModels().get(n);
/* 4285 */       if ((ent instanceof IhmEntite2)) {
/* 4286 */         IhmEntite2 e = (IhmEntite2)ent;
/* 4287 */         e = (IhmEntite2)e.copier();
/* 4288 */         e.setX((int)(x / this.zoom));
/* 4289 */         e.setY((int)(y / this.zoom));
/* 4290 */         if (Setting.dragNdropAfficherAttribut) afficherAttribut(e);
/* 4291 */         adapterEntiteAuMCD(e);
/* 4292 */         getListeEntiteRelation().add(e);
/* 4293 */         this.frm.getExplorer().ajouterNode(e, this.frmMcd.getEntiteNode());
/* 4294 */         this.frm.getExplorer().getTree().updateUI();
/* 4295 */         e = (IhmEntite2)ent;
/* 4296 */         e.setNbUsedLibrairie(e.getNbUsedLibrairie() + 1);
/*      */       }
/*      */       
/* 4299 */       if ((ent instanceof IhmRelation2)) {
/* 4300 */         IhmRelation2 e = (IhmRelation2)ent;
/* 4301 */         e = (IhmRelation2)e.copier();
/* 4302 */         e.setX((int)(x / this.zoom));
/* 4303 */         e.setY((int)(y / this.zoom));
/* 4304 */         if (Setting.dragNdropAfficherAttribut) afficherAttribut(e);
/* 4305 */         adapterRelationAuMCD(e);
/* 4306 */         getListeEntiteRelation().add(e);
/* 4307 */         this.frm.getExplorer().ajouterNode(e, this.frmMcd.getRelationNode());
/* 4308 */         this.frm.getExplorer().getTree().updateUI();
/* 4309 */         e = (IhmRelation2)ent;
/* 4310 */         e.setNbUsedLibrairie(e.getNbUsedLibrairie() + 1);
/*      */       }
/* 4312 */       setCTRLButton(false);
/* 4313 */       repaint();
/*      */     }
/* 4315 */     return true;
/*      */   }
/*      */   
/*      */   public void imprimerMCD() throws Exception
/*      */   {
/* 4320 */     PrinterJob job = PrinterJob.getPrinterJob();
/* 4321 */     HashPrintRequestAttributeSet printRequestSet = new HashPrintRequestAttributeSet();
/*      */     
/* 4323 */     printRequestSet.add(OrientationRequested.LANDSCAPE);
/*      */     
/*      */ 
/* 4326 */     if (job.printDialog(printRequestSet)) {
/*      */       try {
/* 4328 */         job.print();
/*      */       } catch (PrinterException ex) {
/* 4330 */         ex.printStackTrace();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isDragAcceptable(DropTargetDragEvent evenement) {
/* 4336 */     return (evenement.getDropAction() & 0x3) != 0;
/*      */   }
/*      */   
/*      */   public boolean isDropAcceptable(DropTargetDropEvent evenement) {
/* 4340 */     return (evenement.getDropAction() & 0x3) != 0;
/*      */   }
/*      */   
/*      */   public void dragEnter(DropTargetDragEvent evenement) {
/* 4344 */     if (!isDragAcceptable(evenement)) { evenement.rejectDrag();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void dragOver(DropTargetDragEvent evenement) {}
/*      */   
/*      */   public void dropActionChanged(DropTargetDragEvent evenement)
/*      */   {
/* 4353 */     if (!isDragAcceptable(evenement)) evenement.rejectDrag();
/*      */   }
/*      */   
/*      */   public void dragExit(DropTargetEvent evenement) {}
/*      */   
/*      */   public void drop(DropTargetDropEvent evenement) {
/* 4359 */     if (!isDropAcceptable(evenement)) {
/* 4360 */       evenement.rejectDrop();
/* 4361 */       return;
/*      */     }
/*      */     
/* 4364 */     evenement.acceptDrop(1);
/* 4365 */     Transferable transferable = evenement.getTransferable();
/*      */     try {
/* 4367 */       String str = (String)transferable.getTransferData(DataFlavor.stringFlavor);
/* 4368 */       if (insererObjetDeLaLibrairie(str, (int)evenement.getLocation().getX(), (int)evenement.getLocation().getY())) {
/* 4369 */         return;
/*      */       }
/*      */     } catch (UnsupportedFlavorException ex) {
/* 4372 */       Logger.getLogger(IhmPageMCD.class.getName()).log(Level.SEVERE, null, ex);
/*      */     } catch (IOException ex) {
/* 4374 */       Logger.getLogger(IhmPageMCD.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/*      */     
/* 4377 */     DataFlavor[] types = transferable.getTransferDataFlavors();
/* 4378 */     for (DataFlavor type : types) {
/*      */       try {
/* 4380 */         if (type.equals(DataFlavor.javaFileListFlavor)) {
/* 4381 */           List listeFichiers = (List)transferable.getTransferData(type);
/* 4382 */           Iterator iterateur = listeFichiers.iterator();
/*      */           
/* 4384 */           if (iterateur.hasNext()) {
/* 4385 */             File fichier = (File)iterateur.next();
/* 4386 */             String nomFile = fichier.getAbsolutePath();
/*      */             
/* 4388 */             IhmProjet proj = this.frm.dejaOuvertProjet(nomFile);
/* 4389 */             if (proj != null) {
/* 4390 */               JOptionPane.showMessageDialog(this.frm, "Le MCD : \" " + nomFile + " \" est déja ouvert !");
/* 4391 */               this.frm.setProjetMain(proj);
/*      */               try {
/* 4393 */                 this.frm.getFormeMCD().setIcon(false);
/* 4394 */                 this.frm.getFormeMCD().toFront();
/*      */               } catch (PropertyVetoException ex) {
/* 4396 */                 Logger.getLogger(IhmPageMCD.class.getName()).log(Level.SEVERE, null, ex);
/*      */               }
/*      */               
/*      */             }
/* 4400 */             else if (Parametres.estMCDJMerise(nomFile)) {
/* 4401 */               if (this.frm.getProjetSel().getFormeMCD().isPageMCDVide()) {
/* 4402 */                 this.frm.getFormeMCD().setModifier(false);
/* 4403 */                 ouvrir(fichier.getAbsolutePath());
/*      */               } else {
/* 4405 */                 this.frm.creerNouveauProjet();
/* 4406 */                 this.frm.getFormeMCD().getPage().effacerAllMCD();
/* 4407 */                 ouvrir(fichier.getAbsolutePath());
/*      */               }
/*      */             }
/*      */             else {
/* 4411 */               JOptionPane.showMessageDialog(this.frm, "Le fichier  \" " + nomFile + " \" n'est pas un fichier JMerise !");
/*      */             }
/*      */             
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (Exception ex)
/*      */       {
/* 4420 */         JOptionPane.showMessageDialog(this.frm, "Erreur s'est produite lors d'ouverture du fichier ", "File drag and drop ", 1);
/*      */       }
/*      */     }
/* 4423 */     evenement.dropComplete(true);
/*      */   }
/*      */   
/*      */   private void ouvrir(String nomFile) {
/* 4427 */     if (this.frm.getProjetSel() != null) {
/* 4428 */       if (this.frm.getProjetSel().getFormeMCD().isPageMCDVide()) {
/* 4429 */         this.frm.getFormeMCD().setModifier(false);
/* 4430 */         new ThreadOuvrir(this.frm, nomFile).execute();
/*      */       } else {
/* 4432 */         boolean mod = this.frm.getFormeMCD().isModifier();
/* 4433 */         FormeInterneMCD mcd = this.frm.getProjetSel().getFormeMCD();
/* 4434 */         this.frm.getFormeMCD().setModifier(false);
/*      */         
/* 4436 */         new ThreadOuvrir(this.frm, nomFile).execute();
/* 4437 */         if (mcd != this.frm.getProjetSel().getFormeMCD()) {
/* 4438 */           mcd.setModifier(mod);
/*      */         }
/*      */       }
/*      */     }
/* 4442 */     this.frm.getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   public ConfigurationMCD2 getConfigurationMCD()
/*      */   {
/* 4447 */     return this.configurationMCD;
/*      */   }
/*      */   
/*      */   public void setConfigurationMCD(ConfigurationMCD2 config) {
/* 4451 */     this.configurationMCD = config;
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmPageMCD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */