/*      */ package ihm;
/*      */ 
/*      */ import IhmMCD.BarOutil;
/*      */ import IhmMCD.IhmCIF;
/*      */ import IhmMCD.IhmCommentaireIndip;
/*      */ import IhmMCD.IhmEntite;
/*      */ import IhmMCD.IhmEntiteRelation;
/*      */ import IhmMCD.IhmLien;
/*      */ import IhmMCD.IhmLienCif;
/*      */ import IhmMCD.IhmLienCommentaire;
/*      */ import IhmMCD.IhmLienContrainteHeritage;
/*      */ import IhmMCD.IhmLienContraintes;
/*      */ import IhmMCD.IhmLienHeritage;
/*      */ import IhmMCD.IhmPageMCD;
/*      */ import IhmMCD.IhmProjet;
/*      */ import IhmMCD.IhmRelation;
/*      */ import IhmMCD.StatutBar;
/*      */ import IhmMCD2.ConfigurationMCD2;
/*      */ import IhmMCD2.IhmCIF2;
/*      */ import IhmMCD2.IhmCommentaire2;
/*      */ import IhmMCD2.IhmContrainte2;
/*      */ import IhmMCD2.IhmEntite2;
/*      */ import IhmMCD2.IhmLien2;
/*      */ import IhmMCD2.IhmLienCIF2;
/*      */ import IhmMCD2.IhmLienCommentaire2;
/*      */ import IhmMCD2.IhmLienContraintes2;
/*      */ import IhmMCD2.IhmLienHeritage2;
/*      */ import IhmMCD2.IhmPostIt2;
/*      */ import IhmMCD2.IhmRelation2;
/*      */ import IhmMLD.IhmPageMLD;
/*      */ import LibraryPan.FormeAjouterLibrairie;
/*      */ import LibraryPan.PanelEntiteRelation;
/*      */ import Menu.MyMenuItem;
/*      */ import Merise.Attribut;
/*      */ import Merise.Domaine;
/*      */ import Merise.Entite;
/*      */ import Merise.Relation;
/*      */ import Merise2.Entite2;
/*      */ import Merise2.Relation2;
/*      */ import MyExplorer.ConsolePane;
/*      */ import MyExplorer.ExplorerPan;
/*      */ import MyExplorerBD.ExplorerPanBD;
/*      */ import MySqlEditor.MySqlTextPane;
/*      */ import MyXMLEditor.MyXMLTextPane;
/*      */ import Outil.Connexion;
/*      */ import Outil.DeskParamatres;
/*      */ import Outil.Parametres;
/*      */ import Outil.ProprieteMCD;
/*      */ import Outil.SaveSetting;
/*      */ import Outil.Setting;
/*      */ import Output.DTDScript;
/*      */ import Output.FileExport;
/*      */ import Output.SQLOutil;
/*      */ import Thasaruts.ThaOutils;
/*      */ import Thasaruts.Thassarut;
/*      */ import composantSQL.MyDataBase;
/*      */ import formes.About;
/*      */ import formes.FormeBibioMCD;
/*      */ import formes.FormeConstruction;
/*      */ import formes.FormeCreationCompteJFreeSoft;
/*      */ import formes.FormeImporterDictionnaire;
/*      */ import formes.FormeImporterDomaine;
/*      */ import formes.FormeInformationSite;
/*      */ import formes.FormeLegendeRetro;
/*      */ import formes.FormeListeDomaine;
/*      */ import formes.FormeParametre;
/*      */ import formes.FormeRecherche;
/*      */ import formes.FormeRechercheRemplacer;
/*      */ import formes.FormeSelectTable;
/*      */ import formes.FormeText;
/*      */ import formes.PanelLoupe;
/*      */ import formes2.FormeActivation2;
/*      */ import formes2.FormeConversionRelation;
/*      */ import formes2.FormeDictionnaireDeDonnees2;
/*      */ import formes2.FormeLegendeMCD;
/*      */ import formes2.FormeProprieteMCD2;
/*      */ import formes2.FormeSetting2;
/*      */ import java.awt.BorderLayout;
/*      */ import java.awt.Color;
/*      */ import java.awt.Container;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Desktop;
/*      */ import java.awt.Desktop.Action;
/*      */ import java.awt.Dimension;
/*      */ import java.awt.Font;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.Toolkit;
/*      */ import java.awt.dnd.DragSource;
/*      */ import java.awt.dnd.DropTarget;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.event.WindowEvent;
/*      */ import java.beans.PropertyVetoException;
/*      */ import java.io.BufferedReader;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.io.PrintStream;
/*      */ import java.net.URI;
/*      */ import java.net.URISyntaxException;
/*      */ import java.net.URL;
/*      */ import java.sql.Connection;
/*      */ import java.sql.SQLException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.Map;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ import javax.swing.ButtonGroup;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.GroupLayout.Alignment;
/*      */ import javax.swing.GroupLayout.ParallelGroup;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JCheckBoxMenuItem;
/*      */ import javax.swing.JFileChooser;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JMenu;
/*      */ import javax.swing.JMenuBar;
/*      */ import javax.swing.JMenuItem;
/*      */ import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
/*      */ import javax.swing.JPopupMenu.Separator;
/*      */ import javax.swing.JProgressBar;
/*      */ import javax.swing.JRadioButtonMenuItem;
/*      */ import javax.swing.JSplitPane;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JToggleButton;
/*      */ import javax.swing.JTree;
/*      */ import javax.swing.KeyStroke;
/*      */ import javax.swing.SwingUtilities;
/*      */ import javax.swing.UIManager;
/*      */ import javax.swing.filechooser.FileNameExtensionFilter;
/*      */ import mythread.ThreadConstruction;
/*      */ import mythread.ThreadGenererXML;
/*      */ import mythread.ThreadImprimer;
/*      */ import mythread.ThreadScriptBDD;
/*      */ import mythread.ThreadVerifMCD2;
/*      */ 
/*      */ public class Principale extends javax.swing.JFrame
/*      */ {
/*      */   private BarOutil bar;
/*      */   private StatutBar statutBar;
/*      */   private ExplorerPan explorer;
/*      */   private ConsolePane console;
/*      */   private JSplitPane splitCon;
/*      */   private JSplitPane split;
/*      */   private JSplitPane splitLoupe;
/*      */   private JSplitPane splitDeskLib;
/*      */   private Outil.ConfigSave config;
/*      */   private FormeInterneMCD formeMCD;
/*      */   private FormeInterneSQL formeSQL;
/*      */   private FormeInterneMLD formeMLD;
/*      */   private FormeInterneXML formeXML;
/*      */   private FormeInterneRetro formeRetro;
/*      */   private FormeParametre paraLicence;
/*      */   private ArrayList<MyMenuItem> listeMenu;
/*      */   private MyDeskTopPane desk;
/*      */   private ArrayList<IhmProjet> listeProjet;
/*      */   private IhmProjet projetSel;
/*      */   private ArrayList<IhmEntiteRelation> listeGrpCopier;
/*      */   private ArrayList<Object> listeLienCopier;
/*      */   private IhmEntiteRelation objetCopier;
/*      */   private Map<IhmEntiteRelation, IhmEntiteRelation> listeCorrespondance;
/*      */   private Connexion conn;
/*      */   public SaveSetting setting;
/*      */   private FormeParametre pF;
/*      */   private String cheminParametre;
/*      */   private String cheminLicence;
/*      */   private String cheminDernierMCD;
/*      */   private PanelLoupe panelLoupe;
/*      */   public boolean demarrer;
/*      */   private FormeBibioMCD formeBiblioMCD;
/*      */   private PanelEntiteRelation panLibibrary;
/*  176 */   public static boolean ActiverJMerise = true;
/*      */   private JMenu MIQuitterJMerise;
/*      */   private ButtonGroup buttonGroup1;
/*      */   private ButtonGroup buttonGroup2;
/*      */   private ButtonGroup groupeSQL;
/*      */   
/*  182 */   public Principale(Splash plash) { initComponents();
/*      */     
/*  184 */     plash.getProgressBar().setValue(50);
/*      */     try {
/*  186 */       Thread.sleep(600L);
/*      */     }
/*      */     catch (InterruptedException e) {}
/*  189 */     this.demarrer = false;
/*  190 */     Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
/*  191 */     setPreferredSize(new Dimension((int)dim.getWidth(), (int)dim.getHeight() - 30));
/*  192 */     this.statutBar = new StatutBar();
/*  193 */     this.bar = new BarOutil(this.statutBar);
/*  194 */     this.explorer = new ExplorerPan(this);
/*      */     
/*  196 */     this.panelLoupe = null;
/*  197 */     this.projetSel = new IhmProjet(this);
/*  198 */     this.listeProjet = new ArrayList();
/*  199 */     this.listeProjet.add(this.projetSel);
/*  200 */     this.listeGrpCopier = new ArrayList();
/*  201 */     this.listeLienCopier = new ArrayList();
/*  202 */     this.listeCorrespondance = new java.util.HashMap();
/*  203 */     this.conn = new Connexion();
/*  204 */     setProjetMain(this.projetSel);
/*  205 */     this.formeMLD = this.projetSel.getFormeMLD();
/*  206 */     this.formeSQL = this.projetSel.getFormeSQL();
/*  207 */     this.formeMCD = this.projetSel.getFormeMCD();
/*  208 */     this.formeXML = this.projetSel.getFormeXML();
/*  209 */     this.formeRetro = new FormeInterneRetro(this);
/*      */     
/*  211 */     plash.getProgressBar().setValue(55);
/*      */     try {
/*  213 */       Thread.sleep(600L);
/*      */     }
/*      */     catch (InterruptedException e) {}
/*  216 */     this.desk = new MyDeskTopPane(this);
/*  217 */     this.desk.add(this.formeMCD);
/*  218 */     this.desk.add(this.formeSQL);
/*  219 */     this.desk.add(this.formeMLD);
/*  220 */     this.desk.add(this.formeXML);
/*  221 */     this.desk.add(this.formeRetro);
/*  222 */     this.formeMCD.setLesFenetres(this.formeSQL, this.formeMLD, this.formeXML);
/*      */     
/*  224 */     this.formeMCD.setSize(900, 500);
/*  225 */     this.formeMCD.setLocation(100, 40);
/*  226 */     this.formeSQL.setSize(700, 400);
/*  227 */     this.formeSQL.setLocation(0, 0);
/*  228 */     this.formeMLD.setSize(700, 400);
/*  229 */     this.formeMLD.setLocation(50, 50);
/*      */     
/*  231 */     getFormeXML().setVisible(false);
/*  232 */     this.formeRetro.setVisible(false);
/*  233 */     getFormeSQL().setVisible(false);
/*  234 */     getFormeMLD().setVisible(false);
/*  235 */     getFormeMCD().setVisible(true);
/*  236 */     this.cheminDernierMCD = "";
/*      */     try {
/*  238 */       getFormeMCD().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/*  240 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/*  242 */     getFormeMLD().toFront();
/*  243 */     getFormeMCD().toFront();
/*      */     
/*  245 */     this.panelLoupe = new PanelLoupe(this, this.formeMCD);
/*  246 */     this.console = new ConsolePane();
/*  247 */     this.console.setSize(this.console.getWidth(), 20);
/*      */     
/*  249 */     this.panLibibrary = new PanelEntiteRelation(this);
/*  250 */     this.panLibibrary.setVisible(false);
/*  251 */     this.splitDeskLib = new JSplitPane(1, this.desk, this.panLibibrary);
/*      */     
/*      */ 
/*      */ 
/*  255 */     this.splitCon = new JSplitPane(0, this.splitDeskLib, this.console);
/*      */     
/*      */ 
/*  258 */     this.splitCon.setDividerLocation(getHeight() - 200 - this.console.getHeight());
/*      */     
/*  260 */     this.splitLoupe = new JSplitPane(0, this.explorer, this.panelLoupe);
/*      */     
/*  262 */     this.split = new JSplitPane(1, this.splitLoupe, this.splitCon);
/*  263 */     this.console.setVisible(false);
/*      */     
/*  265 */     getContentPane().setLayout(new BorderLayout());
/*  266 */     getContentPane().add(this.bar, "North");
/*  267 */     getContentPane().add(this.split, "Center");
/*  268 */     getContentPane().add(this.statutBar, "South");
/*      */     
/*  270 */     this.bar.setFrm(this);
/*  271 */     this.bar.getMenuInformation().setFrm(this);
/*  272 */     pack();
/*  273 */     setVisible(true);
/*  274 */     FormeInterneMCD.initialiserDefaultColor();
/*  275 */     Toolkit tk = Toolkit.getDefaultToolkit();
/*      */     
/*      */ 
/*  278 */     this.explorer.expandAll();
/*      */     
/*  280 */     plash.getProgressBar().setValue(60);
/*      */     try
/*      */     {
/*  283 */       Thread.sleep(400L);
/*      */     }
/*      */     catch (InterruptedException e) {}
/*      */     
/*  287 */     setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/mainIcone.png")));
/*  288 */     Parametres.listeDimaine = this.formeMCD.getPage().getListeDomaine();
/*  289 */     this.listeMenu = new ArrayList();
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  295 */     this.demarrer = true;
/*  296 */     this.formeBiblioMCD = new FormeBibioMCD(this, true);
/*      */     
/*      */ 
/*  299 */     DropTarget cible2 = new DropTarget(this.desk, this.desk);
/*  300 */     cible2.setActive(true);
/*  301 */     this.splitDeskLib.setDividerLocation(getWidth() - 500);
/*  302 */     this.panLibibrary.setVisible(true);
/*  303 */     this.panLibibrary.openLibraries();
/*      */     
/*  305 */     DragSource source = DragSource.getDefaultDragSource();
/*  306 */     source.createDefaultDragGestureRecognizer(getPanLibibrary().getPanLibrary(), 3, getPanLibibrary().getPanLibrary());
/*      */     
/*      */ 
/*  309 */     this.splitLoupe.setOneTouchExpandable(true);
/*  310 */     this.splitCon.setOneTouchExpandable(true);
/*  311 */     this.split.setOneTouchExpandable(true);
/*  312 */     this.splitDeskLib.setOneTouchExpandable(true);
/*  313 */     getExplorer().getTree().updateUI();
/*      */     
/*  315 */     Parametres.imageCle = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/clefNoire.png"));
/*  316 */     Parametres.imageCleUnique = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/clefNoireAlterne.png"));
/*  317 */     Parametres.imageCleIndex = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/clefNoireIndex.png"));
/*      */     
/*  319 */     Parametres.imageClePrimaireEtr = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/clefForeing.png"));
/*  320 */     Parametres.imageCleEtr = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/clefPrimaryForeing.png"));
/*  321 */     Parametres.imageCleEtrAlter = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/clefPrimaryForeingAlter.png"));
/*  322 */     Parametres.imaEnt = tk.createImage(getClass().getResource("/Images/entiteP.PNG"));
/*      */     
/*      */ 
/*  325 */     setCheminParametre("");
/*  326 */     setCheminParametre(trouverCheminParametreDESK());
/*  327 */     if (getCheminParametre().length() == 0) {
/*  328 */       JOptionPane.showMessageDialog(this, "ERREUR : Sync05_F01.Le chemin du fichier ParamDesk.class est introuvable !! \n Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/*  329 */       setDefaultCloseOperation(3);
/*  330 */       dispose();
/*  331 */       System.exit(0);
/*      */     }
/*  333 */     if (!Parametres.existeFichier(getCheminParametre())) {
/*  334 */       JOptionPane.showMessageDialog(this, "ERREUR : Sync05_F02. Le fichier 'lib/ParamDesk.class' est introuvable !! \n Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com\n" + getCheminParametre());
/*  335 */       setDefaultCloseOperation(3);
/*  336 */       dispose();
/*  337 */       System.exit(0);
/*      */     }
/*      */     
/*  340 */     if (!DeskParamatres.personnaliserParametreDESK(this, getCheminParametre())) {
/*  341 */       JOptionPane.showMessageDialog(this, "ERREUR : Sync05_L01. Une erreur s'est produite lors de la lecture des paramètres bureau !! \n" + getCheminFichier() + "\nSi l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/*      */     } else {
/*  343 */       DeskParamatres.saveParametreDESK(this, getCheminParametre());
/*      */     }
/*  345 */     setCheminLicence("");
/*  346 */     setCheminLicence(trouverCheminLicence());
/*  347 */     if (getCheminLicence().length() == 0) {
/*  348 */       JOptionPane.showMessageDialog(this, "ERREUR : Sync05_F03.Le chemin du fichier actDesk.class est introuvable !! \n Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/*  349 */       setDefaultCloseOperation(3);
/*  350 */       dispose();
/*  351 */       System.exit(0);
/*      */     }
/*      */     
/*  354 */     boolean premiere = false;
/*  355 */     if (!Parametres.existeFichier(getCheminLicence())) {
/*  356 */       premiere = true;
/*  357 */       new FormeActivation2(this, true, null, "FIRST").setVisible(true);
/*      */     } else {
/*  359 */       Setting.licence = ThaOutils.openLicence2(getCheminLicence());
/*      */     }
/*      */     
/*      */ 
/*  363 */     if (Setting.licence != null)
/*      */     {
/*  365 */       if (!Setting.licence.isLicence()) {
/*  366 */         ActiverJMerise = false;
/*  367 */         ThaOutils.controleSansLicence(this, Setting.licence);
/*  368 */         boolean rep = ThaOutils.saveLicence2(Setting.licence, getCheminLicence());
/*  369 */         if (!rep) JOptionPane.showMessageDialog(this, "ERREUR : s'est produite lors de la sauvegarde du fichier actDesk.class");
/*      */       }
/*  371 */       else if (!ThaOutils.verifierExiteMac(Setting.licence)) {
/*  372 */         FormeActivation2 f = new FormeActivation2(this, true, Setting.licence, "REACTIVER");
/*  373 */         f.setVisible(true);
/*  374 */         if (f.isActiver()) {
/*  375 */           ThaOutils.controleLicence(this, Setting.licence);
/*  376 */           Setting.licence.setLicence(true);
/*  377 */           ActiverJMerise = true;
/*      */         } else {
/*  379 */           JOptionPane.showMessageDialog(this, "ERREUR : Vous n'avez pas effectué l'activation ", "Activation", 0);
/*  380 */           setDefaultCloseOperation(3);
/*  381 */           dispose();
/*  382 */           System.exit(0);
/*      */         }
/*      */       } else {
/*  385 */         ThaOutils.controleLicence(this, Setting.licence);
/*  386 */         Setting.licence.setLicence(true);
/*  387 */         ActiverJMerise = true;
/*      */       }
/*      */     }
/*      */     else {
/*  391 */       if (premiere) JOptionPane.showMessageDialog(this, "ERREUR : Vous n'avez pas effectué l'enregistrement ", "Enregistrement", 0); else {
/*  392 */         JOptionPane.showMessageDialog(this, "ERREUR : Problème de lecture des données de vérification", "Enregistrement", 0);
/*      */       }
/*  394 */       setDefaultCloseOperation(3);
/*  395 */       dispose();
/*  396 */       System.exit(0);
/*      */     }
/*      */     
/*  399 */     this.bar.afficherBoutonActivation(!Setting.licence.isLicence());
/*  400 */     this.jMIFaireDon.setEnabled(!Setting.licence.isLicence());
/*  401 */     this.formeMCD.requestFocus();
/*  402 */     this.formeMCD.getPage().requestFocus();
/*      */     
/*  404 */     initialiserNameUser();
/*      */     
/*  406 */     this.formeMCD.getPage().getProprieteMCD().setHistorique("");
/*  407 */     this.formeMCD.getPage().getProprieteMCD().addHistorique(Setting.developpeur, "Création");
/*      */     
/*      */ 
/*  410 */     ThaOutils.saveLicence2(Setting.licence, getCheminLicence());
/*  411 */     afficherDateFin();
/*      */     
/*  413 */     verifierSettingActivation();
/*      */     
/*  415 */     new mythread.ThreadSite(this); }
/*      */   
/*      */   private ButtonGroup groupeXML;
/*      */   private JCheckBoxMenuItem jCBMenuLoupe;
/*      */   
/*  420 */   public void verifierSettingActivation() { if (Setting.licence.isLicence()) {
/*  421 */       if (ThaOutils.isKeyVerifier(Setting.licence.getThassarouts())) {
/*  422 */         setActiverJMerise(true);
/*      */       } else {
/*  424 */         setActiverJMerise(false);
/*      */       }
/*      */     }
/*      */     else {
/*  428 */       setActiverJMerise(false);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  433 */     if (!isActiverJMerise()) {
/*  434 */       Setting.ouvrirCreerUneCopie2 = false;
/*  435 */       Setting.heritageMult = false;
/*  436 */       Setting.heritageMemeSpecialisation2 = false;
/*  437 */       Setting.attMere = true;
/*  438 */       Setting.cleSiNecessaireMere = false;
/*  439 */       Setting.informProprieteMCD = false;
/*  440 */       Setting.zoomToutPage = false;
/*  441 */       Setting.SQLCardinaliteMax = 3; } }
/*      */   
/*      */   private JMenu jFicRecent;
/*      */   private JCheckBoxMenuItem jMIActiverLien;
/*      */   private JCheckBoxMenuItem jMIArrondirEntite;
/*      */   
/*  447 */   private void initialiserNameUser() { if ((Setting.licence != null) && 
/*  448 */       (!Setting.licence.isLicence()) && 
/*  449 */       (Setting.licence.getDeveloppeur().length() == 0)) {
/*  450 */       String dev = System.getProperty("user.name");
/*  451 */       if ((dev == null) || (dev.length() == 0)) {
/*  452 */         dev = "user";
/*      */       }
/*  454 */       Setting.licence.setDeveloppeur(dev);
/*  455 */       Setting.developpeur = dev;
/*      */     }
/*      */   }
/*      */   
/*      */   private JMenuItem jMIChercher;
/*      */   private JMenuItem jMIColler;
/*      */   private JCheckBoxMenuItem jMIConsole;
/*      */   private JMenuItem jMICopier;
/*      */   
/*  464 */   private void afficherDateFin() { int nj = ThaOutils.nombreDeJour(Setting.licence.getAss_ifuk(), ThaOutils.getDateJour());
/*  465 */     if (nj < 45)
/*  466 */       this.statutBar.setDateFin(".         " + Setting.licence.getAss_ifuk());
/*      */   }
/*      */   
/*      */   public FormeBibioMCD getFormeBibioMCD() {
/*  470 */     return this.formeBiblioMCD;
/*      */   }
/*      */   
/*  473 */   public PanelLoupe getPanelLoupe() { return this.panelLoupe; }
/*      */   
/*      */   public JCheckBoxMenuItem getjCBMenuLoupe()
/*      */   {
/*  477 */     return this.jCBMenuLoupe;
/*      */   }
/*      */   
/*      */   public boolean isLoupe() {
/*  481 */     return this.jCBMenuLoupe.isSelected();
/*      */   }
/*      */   
/*      */   public void setLoupe(boolean val) {
/*  485 */     this.jCBMenuLoupe.setSelected(val);
/*      */   }
/*      */   
/*      */   public String getCheminParametre() {
/*  489 */     return this.cheminParametre;
/*      */   }
/*      */   
/*      */   public void setCheminParametre(String ch) {
/*  493 */     this.cheminParametre = ch;
/*      */   }
/*      */   
/*      */   public String getCheminLicence() {
/*  497 */     return this.cheminLicence;
/*      */   }
/*      */   
/*      */   public void setCheminLicence(String cheminLicence) {
/*  501 */     this.cheminLicence = cheminLicence;
/*      */   }
/*      */   
/*      */ 
/*  505 */   public String getCheminDernierMCD() { return this.cheminDernierMCD; }
/*      */   
/*      */   private JCheckBoxMenuItem jMICouleurDegradee;
/*      */   private JMenuItem jMIDictionnaire;
/*      */   
/*  510 */   public void setCheminDernierMCD(String cheminDernierMCD) { this.cheminDernierMCD = cheminDernierMCD; }
/*      */   
/*      */   private JMenuItem jMIDomaine;
/*      */   private JMenuItem jMIEnregistrer;
/*      */   private JMenuItem jMIEnregistrerSous;
/*      */   
/*  516 */   private String trouverCheminParametreNew() { if (existeFichierPropreties()) {
/*  517 */       String ch = getPathJMerise();
/*  518 */       ch = ch.replace("/", File.separator);
/*  519 */       ch = Parametres.corrigerChemin(ch);
/*  520 */       ch = ch + "configuration.properties";
/*  521 */       String win = System.getProperty("os.name");
/*  522 */       if (win.trim().toUpperCase().indexOf("WIN") < 0) { ch = File.separator + ch;
/*      */       }
/*  524 */       ch = Parametres.getPath(ch);
/*  525 */       if (ch.trim().length() == 0) {
/*  526 */         JOptionPane.showMessageDialog(this, "ERREUR : Problème N°Config 2.0. Impossible de trouver le chemin spécifié dans le fichier configuration !! \n" + ch + "\nSi l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/*  527 */         setDefaultCloseOperation(3);
/*  528 */         dispose();
/*  529 */         System.exit(0);
/*  530 */         return "";
/*      */       }
/*  532 */       ch = ch.replace("/", File.separator);
/*  533 */       ch = Parametres.corrigerChemin(ch);
/*  534 */       ch = ch + File.separator + "Parametres.class";
/*  535 */       ch = System.getProperty("user.home") + File.separator + ch;
/*  536 */       String winn = System.getProperty("os.name");
/*  537 */       if (winn.trim().toUpperCase().indexOf("WIN") < 0) ch = File.separator + ch;
/*  538 */       return ch;
/*      */     }
/*      */     
/*  541 */     String ch = trouverCheminParametre();
/*  542 */     return ch; }
/*      */   
/*      */   private JMenuItem jMIEntite;
/*      */   private JCheckBoxMenuItem jMIExplorer;
/*      */   private JMenuItem jMIExportImage;
/*  547 */   private boolean existeFichierPropreties() { String ch = getPathJMerise();
/*  548 */     ch = ch.replace("/", File.separator);
/*  549 */     ch = ch.replace("\\", File.separator);
/*  550 */     ch = Parametres.corrigerChemin(ch);
/*      */     
/*  552 */     ch = ch + "configuration.properties";
/*      */     
/*  554 */     String win = System.getProperty("os.name");
/*  555 */     if (win.trim().toUpperCase().indexOf("WIN") < 0) { ch = File.separator + ch;
/*      */     }
/*  557 */     File f = new File(ch);
/*      */     
/*  559 */     return f.exists();
/*      */   }
/*      */   
/*      */   private String getPathJMerise() {
/*  563 */     URL url = getClass().getResource("");
/*  564 */     String ch = url.getPath();
/*  565 */     if (ch.indexOf("JMerise.jar") < 0) {
/*  566 */       JOptionPane.showMessageDialog(this, "ERREUR : Problème N°Config 1.0. JMerise.jar est introuvable ou il a été renommé !! \n Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/*  567 */       setDefaultCloseOperation(3);
/*  568 */       dispose();
/*  569 */       System.exit(0);
/*      */     }
/*  571 */     ch = ch.substring(0, ch.indexOf("JMerise.jar"));
/*  572 */     ch = ch.replace("/", File.separator);
/*  573 */     ch = ch.replace("file:" + File.separator, "");
/*  574 */     ch = Parametres.corrigerChemin(ch);
/*      */     
/*  576 */     return ch;
/*      */   }
/*      */   
/*      */   private String trouverCheminParametre() {
/*  580 */     URL url = getClass().getResource("");
/*  581 */     String ch = url.getPath();
/*  582 */     if (ch.indexOf("JMerise.jar") < 0) {
/*  583 */       JOptionPane.showMessageDialog(this, "ERREUR : Problème N°5.1. JMerise.jar est introuvable ou il a été renommé !! \n Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/*  584 */       setDefaultCloseOperation(3);
/*  585 */       dispose();
/*  586 */       System.exit(0);
/*      */     }
/*  588 */     ch = ch.substring(0, ch.indexOf("JMerise.jar"));
/*  589 */     ch = ch.replace("/", File.separator);
/*  590 */     ch = ch.replace("file:" + File.separator, "");
/*      */     
/*  592 */     ch = ch + "lib" + File.separator + "Parametres.class";
/*  593 */     ch = Parametres.corrigerChemin(ch);
/*  594 */     String win = System.getProperty("os.name");
/*      */     
/*  596 */     if (win.trim().toUpperCase().indexOf("WIN") < 0) { ch = File.separator + ch;
/*      */     }
/*  598 */     return ch;
/*      */   }
/*      */   
/*      */   private String trouverCheminParametreDESK() {
/*  602 */     URL url = getClass().getResource("");
/*  603 */     String ch = url.getPath();
/*  604 */     if (ch.indexOf("JMerise.jar") < 0) {
/*  605 */       JOptionPane.showMessageDialog(this, "ERREUR : Sync05_F00. JMerise.jar est introuvable ou il a été renommé !! \n Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/*  606 */       setDefaultCloseOperation(3);
/*  607 */       dispose();
/*  608 */       System.exit(0);
/*      */     }
/*  610 */     ch = ch.substring(0, ch.indexOf("JMerise.jar"));
/*  611 */     ch = ch.replace("/", File.separator);
/*  612 */     ch = ch.replace("file:" + File.separator, "");
/*      */     
/*  614 */     ch = ch + "lib" + File.separator + "ParamDesk.class";
/*  615 */     ch = Parametres.corrigerChemin(ch);
/*  616 */     String win = System.getProperty("os.name");
/*      */     
/*  618 */     if (win.trim().toUpperCase().indexOf("WIN") < 0) { ch = File.separator + ch;
/*      */     }
/*  620 */     return ch;
/*      */   }
/*      */   
/*      */   private String trouverCheminLicence() {
/*  624 */     URL url = getClass().getResource("");
/*  625 */     String ch = url.getPath();
/*  626 */     if (ch.indexOf("JMerise.jar") < 0) {
/*  627 */       JOptionPane.showMessageDialog(this, "ERREUR : Sync05_A02. JMerise.jar est introuvable ou il a été renommé !! \n Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/*  628 */       setDefaultCloseOperation(3);
/*  629 */       dispose();
/*  630 */       System.exit(0);
/*      */     }
/*  632 */     ch = ch.substring(0, ch.indexOf("JMerise.jar"));
/*  633 */     ch = ch.replace("/", File.separator);
/*  634 */     ch = ch.replace("file:" + File.separator, "");
/*      */     
/*  636 */     ch = ch + "lib" + File.separator + "actDesk.class";
/*  637 */     ch = Parametres.corrigerChemin(ch);
/*  638 */     String win = System.getProperty("os.name");
/*      */     
/*  640 */     if (win.trim().toUpperCase().indexOf("WIN") < 0) { ch = File.separator + ch;
/*      */     }
/*  642 */     return ch; }
/*      */   
/*      */   private JMenuItem jMIFaireDon;
/*      */   private JMenuItem jMIGenerer;
/*      */   private JMenuItem jMIImporterAnalyseSI;
/*      */   private JMenuItem jMIImprimer;
/*  648 */   public Connexion getConnection() { return this.conn; }
/*      */   
/*      */   public void setConnection(Connexion conn)
/*      */   {
/*  652 */     this.conn = conn;
/*      */   }
/*      */   
/*      */   public ArrayList<MyMenuItem> getListeMenu() {
/*  656 */     return this.listeMenu;
/*      */   }
/*      */   
/*      */   public SaveSetting getSetting() {
/*  660 */     return this.setting;
/*      */   }
/*      */   
/*      */   public FormeParametre getpF() {
/*  664 */     return this.pF;
/*      */   }
/*      */   
/*      */   public void setpF(FormeParametre pF) {
/*  668 */     this.pF = pF;
/*      */   }
/*      */   
/*      */   public void afficherCadrage(boolean val) {
/*  672 */     if (this.jMIExplorer.isSelected()) {
/*  673 */       this.jCBMenuLoupe.setSelected(val);
/*  674 */       this.panelLoupe.setVisible(this.jCBMenuLoupe.isSelected());
/*  675 */       if (this.jCBMenuLoupe.isSelected()) {
/*  676 */         this.panelLoupe.setSize(this.panelLoupe.getWidth(), 100);
/*  677 */         this.splitLoupe.setDividerLocation(getHeight() - 200 - this.panelLoupe.getHeight());
/*      */       }
/*      */     } else {
/*  680 */       this.jCBMenuLoupe.setSelected(false);
/*  681 */       this.panelLoupe.setVisible(false);
/*  682 */       this.splitLoupe.setVisible(false);
/*  683 */       this.explorer.setVisible(false);
/*      */     }
/*      */   }
/*      */   
/*      */   public void copierObjet()
/*      */   {
/*  689 */     int nb = 0;
/*  690 */     for (int j = 0; j < this.formeMCD.getPage().getListeEntiteRelation().size(); j++) {
/*  691 */       if (((IhmEntiteRelation)this.formeMCD.getPage().getListeEntiteRelation().get(j)).isSelected()) {
/*  692 */         nb++;
/*  693 */         if (nb == 1) {
/*  694 */           this.listeGrpCopier.clear();
/*  695 */           this.listeCorrespondance.clear();
/*  696 */           this.listeLienCopier.clear();
/*      */         }
/*  698 */         this.listeGrpCopier.add(this.formeMCD.getPage().getListeEntiteRelation().get(j));
/*      */       }
/*      */     }
/*  701 */     for (int j = 0; j < this.formeMCD.getPage().getListeCIF().size(); j++) {
/*  702 */       if (((IhmCIF)this.formeMCD.getPage().getListeCIF().get(j)).isSelected()) {
/*  703 */         nb++;
/*  704 */         if (nb == 1) {
/*  705 */           this.listeGrpCopier.clear();
/*  706 */           this.listeLienCopier.clear();
/*  707 */           this.listeCorrespondance.clear();
/*      */         }
/*  709 */         this.listeGrpCopier.add(this.formeMCD.getPage().getListeCIF().get(j));
/*      */       }
/*      */     }
/*      */     
/*  713 */     for (int h = 0; h < this.formeMCD.getPage().getListeCommentaire().size(); h++) {
/*  714 */       if (((IhmCommentaireIndip)this.formeMCD.getPage().getListeCommentaire().get(h)).isSelected()) {
/*  715 */         nb++;
/*  716 */         if (nb == 1) {
/*  717 */           this.listeGrpCopier.clear();
/*  718 */           this.listeLienCopier.clear();
/*  719 */           this.listeCorrespondance.clear();
/*      */         }
/*  721 */         this.listeGrpCopier.add(this.formeMCD.getPage().getListeCommentaire().get(h));
/*      */       }
/*      */     }
/*      */     
/*  725 */     for (int h = 0; h < this.formeMCD.getPage().getListeContrainte().size(); h++) {
/*  726 */       if (((IhmEntiteRelation)this.formeMCD.getPage().getListeContrainte().get(h)).isSelected()) {
/*  727 */         nb++;
/*  728 */         if (nb == 1) {
/*  729 */           this.listeGrpCopier.clear();
/*  730 */           this.listeLienCopier.clear();
/*  731 */           this.listeCorrespondance.clear();
/*      */         }
/*  733 */         this.listeGrpCopier.add(this.formeMCD.getPage().getListeContrainte().get(h));
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
/*      */ 
/*      */ 
/*  750 */     for (int h = 0; h < this.formeMCD.getPage().getListeLien().size(); h++) {
/*  751 */       if (((IhmLien)this.formeMCD.getPage().getListeLien().get(h)).isSelected()) {
/*  752 */         nb++;
/*  753 */         if (nb == 1) {
/*  754 */           this.listeLienCopier.clear();
/*      */         }
/*  756 */         this.listeLienCopier.add(this.formeMCD.getPage().getListeLien().get(h));
/*      */       }
/*      */     }
/*      */     
/*  760 */     for (int h = 0; h < this.formeMCD.getPage().getListeLienCommentaire().size(); h++) {
/*  761 */       if (((IhmLienCommentaire)this.formeMCD.getPage().getListeLienCommentaire().get(h)).isSelect()) {
/*  762 */         nb++;
/*  763 */         if (nb == 1) {
/*  764 */           this.listeLienCopier.clear();
/*      */         }
/*  766 */         this.listeLienCopier.add(this.formeMCD.getPage().getListeLienCommentaire().get(h));
/*      */       }
/*      */     }
/*      */     
/*  770 */     for (int h = 0; h < this.formeMCD.getPage().getListeLienContrainte().size(); h++) {
/*  771 */       if (((IhmLienContraintes)this.formeMCD.getPage().getListeLienContrainte().get(h)).isSelect()) {
/*  772 */         nb++;
/*  773 */         if (nb == 1) {
/*  774 */           this.listeLienCopier.clear();
/*      */         }
/*  776 */         this.listeLienCopier.add(this.formeMCD.getPage().getListeLienContrainte().get(h));
/*      */       }
/*      */     }
/*      */     
/*  780 */     for (int h = 0; h < this.formeMCD.getPage().getListeLienContrainteHeritage().size(); h++) {
/*  781 */       if (((IhmLienContrainteHeritage)this.formeMCD.getPage().getListeLienContrainteHeritage().get(h)).isSelect()) {
/*  782 */         nb++;
/*  783 */         if (nb == 1) {
/*  784 */           this.listeLienCopier.clear();
/*      */         }
/*  786 */         this.listeLienCopier.add(this.formeMCD.getPage().getListeLienContrainteHeritage().get(h));
/*      */       }
/*      */     }
/*      */     
/*  790 */     for (int h = 0; h < this.formeMCD.getPage().getListelienCIF().size(); h++) {
/*  791 */       if (((IhmLienCif)this.formeMCD.getPage().getListelienCIF().get(h)).isSelect()) {
/*  792 */         nb++;
/*  793 */         if (nb == 1) {
/*  794 */           this.listeLienCopier.clear();
/*      */         }
/*  796 */         this.listeLienCopier.add(this.formeMCD.getPage().getListelienCIF().get(h));
/*      */       }
/*      */     }
/*      */     
/*  800 */     for (int h = 0; h < this.formeMCD.getPage().getListeLienHeritage().size(); h++) {
/*  801 */       if (((IhmLienHeritage)this.formeMCD.getPage().getListeLienHeritage().get(h)).isSelect()) {
/*  802 */         nb++;
/*  803 */         if (nb == 1) {
/*  804 */           this.listeLienCopier.clear();
/*      */         }
/*  806 */         this.listeLienCopier.add(this.formeMCD.getPage().getListeLienHeritage().get(h));
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void collerObjet()
/*      */   {
/*  813 */     if (this.listeGrpCopier.size() > 0) { this.formeMCD.getPage().setSelected(false);
/*      */     }
/*  815 */     for (int i = 0; i < this.listeGrpCopier.size(); i++) {
/*  816 */       this.objetCopier = ((IhmEntiteRelation)this.listeGrpCopier.get(i));
/*      */       
/*  818 */       if (this.objetCopier.getClass().getName().equals("IhmMCD2.IhmEntite2")) {
/*  819 */         IhmEntite2 ob = (IhmEntite2)((IhmEntite2)this.objetCopier).copier();
/*  820 */         ob.setVariable(this.jMIVariable.isSelected());
/*  821 */         this.listeCorrespondance.put(this.objetCopier, ob);
/*  822 */         ob.getEntite().setNom("_" + ob.getEntite().getNom());
/*  823 */         ((Entite2)ob.getEntite()).setCode("_" + ((Entite2)ob.getEntite()).getCode());
/*  824 */         ob.setX(ob.getX() + 5);
/*  825 */         ob.setY(ob.getY() + 5);
/*      */         
/*  827 */         ob.setOmbre(this.formeMCD.getPage().getConfigurationMCD().isOmbree2);
/*  828 */         ob.setClDegradee(this.formeMCD.getPage().getConfigurationMCD().isDegradee2);
/*  829 */         ob.setVariable(this.formeMCD.getPage().getConfigurationMCD().afficheType2);
/*  830 */         ob.setPrkvisible(this.formeMCD.getPage().getConfigurationMCD().afficherPrk2);
/*  831 */         ob.setAttMajuscule(this.formeMCD.getPage().getConfigurationMCD().typeMajuscule2);
/*  832 */         ob.setArrondir(this.formeMCD.getPage().getConfigurationMCD().arrondirEntite2);
/*      */         
/*  834 */         ob.setEpaisseur(this.formeMCD.getPage().getConfigurationMCD().traitEntiteRelation2);
/*  835 */         ob.setAttEspace(this.formeMCD.getPage().getConfigurationMCD().interLigne2);
/*      */         
/*  837 */         this.formeMCD.getPage().getListeEntiteRelation().add(ob);
/*  838 */         getExplorer().ajouterNode(ob, this.formeMCD.getEntiteNode());
/*  839 */         getExplorer().getTree().updateUI();
/*      */       }
/*  841 */       if (this.objetCopier.getClass().getName().equals("IhmMCD2.IhmRelation2")) {
/*  842 */         IhmRelation2 ob = (IhmRelation2)((IhmRelation2)this.objetCopier).copier();
/*  843 */         this.listeCorrespondance.put(this.objetCopier, ob);
/*  844 */         ob.getRelation().setNom("_" + ob.getRelation().getNom());
/*  845 */         ((Relation2)ob.getRelation()).setCode("_" + ((Relation2)ob.getRelation()).getCode());
/*  846 */         ob.setX(ob.getX() + 5);
/*  847 */         ob.setY(ob.getY() + 5);
/*      */         
/*  849 */         ob.setOmbre(this.formeMCD.getPage().getConfigurationMCD().isOmbree2);
/*  850 */         ob.setClDegradee(this.formeMCD.getPage().getConfigurationMCD().isDegradee2);
/*  851 */         ob.setVariable(this.formeMCD.getPage().getConfigurationMCD().afficheType2);
/*  852 */         ob.setPrkvisible(this.formeMCD.getPage().getConfigurationMCD().afficherPrk2);
/*  853 */         ob.setAttMajuscule(this.formeMCD.getPage().getConfigurationMCD().typeMajuscule2);
/*      */         
/*  855 */         ob.setEpaisseur(this.formeMCD.getPage().getConfigurationMCD().traitEntiteRelation2);
/*  856 */         ob.setAttEspace(this.formeMCD.getPage().getConfigurationMCD().interLigne2);
/*      */         
/*  858 */         this.formeMCD.getPage().getListeEntiteRelation().add(ob);
/*  859 */         getExplorer().ajouterNode(ob, this.formeMCD.getRelationNode());
/*  860 */         getExplorer().getTree().updateUI();
/*      */       }
/*  862 */       if (this.objetCopier.getClass().getName().equals("IhmMCD2.IhmCIF2")) {
/*  863 */         IhmCIF2 ob = new IhmCIF2(this.objetCopier.getX() + 5, this.objetCopier.getY() + 5, this.objetCopier.getWidth(), this.objetCopier.getHeight());
/*      */         
/*  865 */         ob.setEpaisseur(this.formeMCD.getPage().getConfigurationMCD().traitContraintes2);
/*      */         
/*  867 */         this.formeMCD.getPage().getListeCIF().add(ob);
/*  868 */         this.listeCorrespondance.put(this.objetCopier, ob);
/*      */       }
/*  870 */       if (this.objetCopier.getClass().getName().equals("IhmMCD2.IhmContrainte2")) {
/*  871 */         IhmContrainte2 ob = new IhmContrainte2(this.objetCopier.getX() + 5, this.objetCopier.getY() + 5, this.objetCopier.getWidth(), this.objetCopier.getHeight());
/*      */         
/*  873 */         ob.setEpaisseur(this.formeMCD.getPage().getConfigurationMCD().traitContraintes2);
/*      */         
/*  875 */         ob.setNom(((IhmContrainte2)this.objetCopier).getNom());
/*  876 */         this.formeMCD.getPage().getListeContrainte().add(ob);
/*  877 */         this.listeCorrespondance.put(this.objetCopier, ob);
/*      */       }
/*  879 */       if ((this.objetCopier instanceof IhmPostIt2))
/*      */       {
/*  881 */         IhmPostIt2 ob = ((IhmPostIt2)this.objetCopier).copier();
/*      */         
/*  883 */         ob.setX(this.objetCopier.getX() + 5);
/*  884 */         ob.setY(this.objetCopier.getY() + 5);
/*      */         
/*  886 */         this.formeMCD.getPage().getListeCommentaire().add(ob);
/*  887 */         this.listeCorrespondance.put(this.objetCopier, ob);
/*      */       }
/*  889 */       else if ((this.objetCopier instanceof IhmCommentaire2))
/*      */       {
/*  891 */         IhmCommentaire2 ob = (IhmCommentaire2)((IhmCommentaire2)this.objetCopier).copier();
/*      */         
/*  893 */         ob.setX(this.objetCopier.getX() + 5);
/*  894 */         ob.setY(this.objetCopier.getY() + 5);
/*      */         
/*  896 */         this.formeMCD.getPage().getListeCommentaire().add(ob);
/*  897 */         this.listeCorrespondance.put(this.objetCopier, ob);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  902 */     this.formeMCD.setModifier(true);
/*  903 */     repaint();
/*      */     
/*      */ 
/*  906 */     for (int i = 0; i < this.listeLienCopier.size(); i++) {
/*  907 */       Object objCop = this.listeLienCopier.get(i);
/*  908 */       if ((objCop instanceof IhmLien2)) {
/*  909 */         IhmLien2 l = (IhmLien2)objCop;
/*      */         
/*  911 */         if ((this.listeCorrespondance.get(l.getEntite()) != null) && (this.listeCorrespondance.get(l.getRelation()) != null)) {
/*  912 */           Object ob1 = this.listeCorrespondance.get(l.getEntite());
/*  913 */           Object ob2 = this.listeCorrespondance.get(l.getRelation());
/*  914 */           IhmLien2 lnew = (IhmLien2)l.copier((IhmEntite2)ob1, (IhmRelation2)ob2);
/*  915 */           this.formeMCD.getPage().getListeLien().add(lnew);
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*  920 */       if ((objCop instanceof IhmLienCIF2)) {
/*  921 */         IhmLienCIF2 l = (IhmLienCIF2)objCop;
/*      */         
/*  923 */         if ((this.listeCorrespondance.get(l.getEntiteRelation()) != null) && (this.listeCorrespondance.get(l.getCif()) != null)) {
/*  924 */           Object ob1 = this.listeCorrespondance.get(l.getEntiteRelation());
/*  925 */           Object ob2 = this.listeCorrespondance.get(l.getCif());
/*      */           
/*  927 */           IhmLienCIF2 lnew = l.copier((IhmEntiteRelation)ob1, (IhmCIF2)ob2);
/*      */           
/*  929 */           this.formeMCD.getPage().getListelienCIF().add(lnew);
/*      */         }
/*      */       }
/*  932 */       if ((objCop instanceof IhmLienCommentaire2)) {
/*  933 */         IhmLienCommentaire2 l = (IhmLienCommentaire2)objCop;
/*      */         
/*  935 */         if ((this.listeCorrespondance.get(l.getEntiteRelation()) != null) && (this.listeCorrespondance.get(l.getCommentaire()) != null)) {
/*  936 */           Object ob1 = this.listeCorrespondance.get(l.getCommentaire());
/*  937 */           Object ob2 = this.listeCorrespondance.get(l.getEntRel());
/*  938 */           IhmLienCommentaire2 lnew = l.copier((IhmCommentaire2)ob1, (IhmEntiteRelation)ob2);
/*  939 */           this.formeMCD.getPage().getListeLienCommentaire().add(lnew);
/*      */         }
/*      */       }
/*      */       
/*  943 */       if ((objCop instanceof IhmLienContraintes2)) {
/*  944 */         IhmLienContraintes2 l = (IhmLienContraintes2)objCop;
/*      */         
/*  946 */         if ((this.listeCorrespondance.get(l.getEntiteRelation()) != null) && (this.listeCorrespondance.get(l.getContrainte()) != null)) {
/*  947 */           Object ob1 = this.listeCorrespondance.get(l.getContrainte());
/*  948 */           Object ob2 = this.listeCorrespondance.get(l.getEntiteRelation());
/*  949 */           IhmLienContraintes2 lnew = l.copier((IhmEntiteRelation)ob2, (IhmContrainte2)ob1);
/*  950 */           this.formeMCD.getPage().getListeLienContrainte().add(lnew);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  955 */     this.formeMCD.setModifier(true);
/*  956 */     repaint();
/*      */   }
/*      */   
/*      */   private void remonterItem(MyMenuItem it)
/*      */   {
/*  961 */     int i = this.listeMenu.indexOf(it);
/*      */     
/*  963 */     while (i > 0) {
/*  964 */       String ch = ((MyMenuItem)this.listeMenu.get(i - 1)).getChemin();
/*  965 */       String nom = ((MyMenuItem)this.listeMenu.get(i - 1)).getNom();
/*  966 */       ((MyMenuItem)this.listeMenu.get(i - 1)).setChemin(((MyMenuItem)this.listeMenu.get(i)).getChemin());
/*  967 */       ((MyMenuItem)this.listeMenu.get(i - 1)).setNom(((MyMenuItem)this.listeMenu.get(i)).getNom());
/*  968 */       ((MyMenuItem)this.listeMenu.get(i)).setChemin(ch);
/*  969 */       ((MyMenuItem)this.listeMenu.get(i)).setNom(nom);
/*  970 */       ((MyMenuItem)this.listeMenu.get(i)).setText(((MyMenuItem)this.listeMenu.get(i)).getChemin());
/*  971 */       ((MyMenuItem)this.listeMenu.get(i - 1)).setText(((MyMenuItem)this.listeMenu.get(i - 1)).getChemin());
/*  972 */       i--;
/*      */     }
/*      */   }
/*      */   
/*      */   public void ajouterUnnouveauFichier(String ch) {
/*  977 */     if (ch.trim().length() == 0) return;
/*  978 */     boolean existe = false;
/*  979 */     MyMenuItem it = null;
/*  980 */     for (int i = 0; i < this.listeMenu.size(); i++) {
/*  981 */       if (ch.trim().toUpperCase().equals(((MyMenuItem)this.listeMenu.get(i)).getChemin().trim().toUpperCase())) {
/*  982 */         existe = true;
/*  983 */         it = (MyMenuItem)this.listeMenu.get(i);
/*  984 */         break;
/*      */       }
/*      */     }
/*  987 */     if (existe) {
/*  988 */       remonterItem(it);
/*      */ 
/*      */     }
/*  991 */     else if (this.listeMenu.size() == 5) {
/*  992 */       ((MyMenuItem)this.listeMenu.get(4)).setChemin(ch);
/*  993 */       it = (MyMenuItem)this.listeMenu.get(4);
/*  994 */       remonterItem(it);
/*      */     } else {
/*  996 */       it = new MyMenuItem(this, ch);
/*  997 */       this.listeMenu.add(it);
/*  998 */       this.jFicRecent.add(it);
/*  999 */       remonterItem(it);
/*      */     } }
/*      */   
/*      */   private JCheckBoxMenuItem jMILibrairie;
/*      */   private JMenuItem jMILien;
/*      */   private JMenuItem jMINouveau;
/*      */   private JMenuItem jMINouvelleLibrairie;
/*      */   
/* 1007 */   public FormeInterneMCD getFormeMCD() { return this.formeMCD; }
/*      */   
/*      */   public FormeInterneMLD getFormeMLD()
/*      */   {
/* 1011 */     return this.formeMLD;
/*      */   }
/*      */   
/*      */   public FormeInterneSQL getFormeSQL() {
/* 1015 */     return this.formeSQL;
/*      */   }
/*      */   
/*      */   public FormeInterneXML getFormeXML() {
/* 1019 */     return this.formeXML;
/*      */   }
/*      */   
/*      */   public void setFormeMCD(FormeInterneMCD formeMCD) {
/* 1023 */     this.formeMCD = formeMCD;
/*      */   }
/*      */   
/*      */   public void setFormeMLD(FormeInterneMLD formeMLD) {
/* 1027 */     this.formeMLD = formeMLD;
/*      */   }
/*      */   
/*      */   public void setFormeSQL(FormeInterneSQL formeSQL) {
/* 1031 */     this.formeSQL = formeSQL;
/*      */   }
/*      */   
/*      */   public void setFormeXML(FormeInterneXML formeXML) {
/* 1035 */     this.formeXML = formeXML;
/*      */   }
/*      */   
/*      */   public boolean isTailleVariable() {
/* 1039 */     return this.jMIVariable.isSelected();
/*      */   }
/*      */   
/*      */   public void setTailleVariable(boolean bol) {
/* 1043 */     this.jMIVariable.setSelected(bol);
/*      */   }
/*      */   
/*      */   public boolean isOmbre() {
/* 1047 */     return this.jMIOmbre.isSelected();
/*      */   }
/*      */   
/*      */   public JCheckBoxMenuItem getjMILibrairie() {
/* 1051 */     return this.jMILibrairie;
/*      */   }
/*      */   
/*      */   public static boolean isActiverJMerise() {
/* 1055 */     return ActiverJMerise;
/*      */   }
/*      */   
/*      */   public static void setActiverJMerise(boolean val) {
/* 1059 */     ActiverJMerise = val;
/*      */   }
/*      */   
/*      */   public boolean isOmbreMenu() {
/* 1063 */     return this.jMIOmbre.isSelected();
/*      */   }
/*      */   
/*      */   public JCheckBoxMenuItem getjMIExplorer() {
/* 1067 */     return this.jMIExplorer;
/*      */   }
/*      */   
/*      */   public PanelEntiteRelation getPanLibibrary() {
/* 1071 */     return this.panLibibrary;
/*      */   }
/*      */   
/*      */   public void setOmbre(boolean ombre) {
/* 1075 */     this.jMIOmbre.setSelected(ombre);
/*      */   }
/*      */   
/*      */   public void setCheminFichier(String cheminFichier) {
/* 1079 */     this.formeMCD.setCheminFichier(cheminFichier);
/*      */   }
/*      */   
/*      */   public void setNomFichier(String nomFichier) {
/* 1083 */     this.formeMCD.setNomFichier(nomFichier);
/*      */   }
/*      */   
/*      */   public IhmPageMCD getPage() {
/* 1087 */     return getProjetSel().getFormeMCD().getPage();
/*      */   }
/*      */   
/*      */   public StatutBar getStatutBar() {
/* 1091 */     return this.statutBar;
/*      */   }
/*      */   
/*      */   public BarOutil getBar() {
/* 1095 */     return this.bar;
/*      */   }
/*      */   
/*      */   public JCheckBoxMenuItem getjMIActiverLien() {
/* 1099 */     return this.jMIActiverLien;
/*      */   }
/*      */   
/*      */   public String getCheminFichier() {
/* 1103 */     return this.formeMCD.getCheminFichier();
/*      */   }
/*      */   
/*      */   public String getNomFichier() {
/* 1107 */     return this.formeMCD.getNomFichier();
/*      */   }
/*      */   
/*      */   public JCheckBoxMenuItem getjMIConsole() {
/* 1111 */     return this.jMIConsole;
/*      */   }
/*      */   
/*      */   public JSplitPane getSplitCon() {
/* 1115 */     return this.splitCon;
/*      */   }
/*      */   
/*      */   public JSplitPane getSplit() {
/* 1119 */     return this.split;
/*      */   }
/*      */   
/*      */   public static void testActiverJMerise() {
/* 1123 */     if (ThaOutils.isKeyVerifier(Setting.licence.getThassarouts())) {
/* 1124 */       setActiverJMerise(true);
/*      */     } else {
/* 1126 */       setActiverJMerise(true);
/*      */     }
/*      */   }
/*      */   
/*      */   public ConsolePane getConsole() {
/* 1131 */     return this.console;
/*      */   }
/*      */   
/*      */   public ExplorerPan getExplorer() {
/* 1135 */     return this.explorer;
/*      */   }
/*      */   
/*      */   public boolean isClDegradee() {
/* 1139 */     return this.jMICouleurDegradee.isSelected();
/*      */   }
/*      */   
/*      */   public void setClDegradee(boolean clDegradee) {
/* 1143 */     this.jMICouleurDegradee.setSelected(clDegradee);
/*      */   }
/*      */   
/*      */   public boolean isArrondirAngle() {
/* 1147 */     return this.jMIArrondirEntite.isSelected();
/*      */   }
/*      */   
/*      */   public void setArrondirAngle(boolean arr) {
/* 1151 */     this.jMIArrondirEntite.setSelected(arr);
/*      */   }
/*      */   
/*      */   public boolean isActiverLienSelection() {
/* 1155 */     return this.jMIActiverLien.isSelected();
/*      */   }
/*      */   
/*      */   public void setActiverLienSelection(boolean arr) {
/* 1159 */     this.jMIActiverLien.setSelected(arr);
/*      */   }
/*      */   
/*      */   public boolean isVariable() {
/* 1163 */     return this.jMIVariable.isSelected();
/*      */   }
/*      */   
/*      */   public void setVariable(boolean bol) {
/* 1167 */     this.jMIVariable.setSelected(bol);
/*      */   }
/*      */   
/*      */   public void attendre(int att) {
/* 1171 */     for (int i = 0; i < att; i++) {
/* 1172 */       for (int j = 0; j < att; j++) {}
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void setMenuDegradeeOmbreTypeArrondir(boolean degradee, boolean type, boolean ombre, boolean arrondir)
/*      */   {
/* 1179 */     this.jMIVariable.setSelected(type);
/* 1180 */     this.jMIOmbre.setSelected(ombre);
/* 1181 */     this.jMICouleurDegradee.setSelected(degradee);
/* 1182 */     this.jMIArrondirEntite.setSelected(arrondir);
/*      */   }
/*      */   
/*      */   public String prefixNomMCD(String nom)
/*      */   {
/* 1187 */     if (!nom.trim().toUpperCase().endsWith(".MCD")) nom = nom + ".mcd";
/* 1188 */     return nom;
/*      */   }
/*      */   
/*      */   public String prefixNomJPG(String nom) {
/* 1192 */     if ((!nom.endsWith(".png")) && (!nom.endsWith(".jpeg")) && (!nom.endsWith(".jpg"))) {
/* 1193 */       nom = nom + ".png";
/*      */     }
/* 1195 */     return nom;
/*      */   }
/*      */   
/*      */   public FormeInterneRetro getFormeRetro() {
/* 1199 */     return this.formeRetro;
/*      */   }
/*      */   
/*      */   public void setFormeRetro(FormeInterneRetro formeRetro) {
/* 1203 */     this.formeRetro = formeRetro;
/*      */   }
/*      */   
/*      */   public IhmProjet getProjetSel() {
/* 1207 */     return this.projetSel;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean isRelationDeuxliens(IhmRelation rel)
/*      */   {
/* 1213 */     int nb = 0;
/* 1214 */     int n = getPage().getListeLien().size();
/* 1215 */     for (int i = 0; i < n; i++) {
/* 1216 */       if (((IhmLien)getPage().getListeLien().get(i)).getRelation() == rel) nb++;
/* 1217 */       if (nb > 2) return false;
/*      */     }
/* 1219 */     if (nb == 2) return true;
/* 1220 */     return false;
/*      */   }
/*      */   
/*      */   public IhmLien getDeuxiemeLien(IhmRelation rel, IhmLien l) {
/* 1224 */     int n = getPage().getListeLien().size();
/* 1225 */     for (int i = 0; i < n; i++) {
/* 1226 */       if (!isRelationDeuxliens(rel)) return null;
/* 1227 */       if ((((IhmLien)getPage().getListeLien().get(i)).getRelation() == rel) && 
/* 1228 */         (getPage().getListeLien().get(i) != l)) { return (IhmLien)getPage().getListeLien().get(i);
/*      */       }
/*      */     }
/* 1231 */     return null;
/*      */   }
/*      */   
/*      */   public boolean isLienRelatifCorrecte(IhmLien li1) {
/* 1235 */     IhmLien l2 = getDeuxiemeLien(li1.getRelation(), li1);
/* 1236 */     if (l2 == null) {
/* 1237 */       getConsole().getRapport().append("Lien relatif : la relation \"" + li1.getRelation().getRelation().getNom() + "\" contient un seul lien\n");
/* 1238 */       return false;
/*      */     }
/* 1240 */     if (l2.getEntite().getEntite().getCle().size() == 0) {
/* 1241 */       getConsole().getRapport().append("Lien relatif : l'entite \"" + l2.getEntite().getEntite().getNom() + "\" ne contient pas de clé primaire \n");
/* 1242 */       return false;
/*      */     }
/* 1244 */     if (l2.getCardinalite().trim().indexOf("(") >= 0) {
/* 1245 */       getConsole().getRapport().append("Lien relatif : le lien entre l'entite \"" + l2.getEntite().getEntite().getNom() + "\" et la relation \"" + l2.getRelation().getRelation().getNom() + "\" ne doit pas être un lien faible \n");
/* 1246 */       return false;
/*      */     }
/* 1248 */     if ((l2.getCardinalite().trim().indexOf("0,n") < 0) && (l2.getCardinalite().trim().indexOf("1,n") < 0)) {
/* 1249 */       getConsole().getRapport().append("Lien relatif : le lien entre l'entite \"" + l2.getEntite().getEntite().getNom() + "\" et la relation \"" + l2.getRelation().getRelation().getNom() + "\" doit être de type '0,n' ou '1,n'\n");
/* 1250 */       return false;
/*      */     }
/*      */     
/* 1253 */     return true;
/*      */   }
/*      */   
/*      */   public boolean isLienRelatifCorrecte() {
/* 1257 */     int n = getPage().getListeLien().size();
/* 1258 */     boolean cor = true;
/* 1259 */     for (int i = 0; i < n; i++) {
/* 1260 */       if (((IhmLien)getPage().getListeLien().get(i)).getCardinalite().indexOf("(") >= 0) {
/* 1261 */         if (((IhmLien)getPage().getListeLien().get(i)).getCardinalite().indexOf("1,1") >= 0) {
/* 1262 */           if (!isLienRelatifCorrecte((IhmLien)getPage().getListeLien().get(i)))
/*      */           {
/* 1264 */             cor = false;
/*      */           }
/*      */         } else {
/* 1267 */           getConsole().getRapport().append("Lien relatif : le lien entre l'entité \"" + ((IhmLien)getPage().getListeLien().get(i)).getEntite().getEntite().getNom() + "\" et la relation \"" + ((IhmLien)getPage().getListeLien().get(i)).getRelation().getRelation().getNom() + "\" doit être de cette forme (1,1)\n");
/* 1268 */           cor = false;
/*      */         }
/*      */       }
/*      */     }
/* 1272 */     return cor;
/*      */   }
/*      */   
/*      */   public ArrayList<IhmLien> getLienRelatifEntite(IhmEntite ent) {
/* 1276 */     ArrayList<IhmLien> l = new ArrayList();
/* 1277 */     int n = getPage().getListeLien().size();
/* 1278 */     for (int i = 0; i < n; i++) {
/* 1279 */       if ((((IhmLien)getPage().getListeLien().get(i)).getEntite() == ent) && 
/* 1280 */         (((IhmLien)getPage().getListeLien().get(i)).getCardinalite().equals("(1,1)"))) {
/* 1281 */         l.add(getPage().getListeLien().get(i));
/*      */       }
/*      */     }
/* 1284 */     return l;
/*      */   }
/*      */   
/*      */   public boolean isCleAvecLienRelatif(IhmEntite ent) {
/* 1288 */     ArrayList<IhmLien> l = getLienRelatifEntite(ent);
/*      */     
/* 1290 */     if (l == null) return false;
/* 1291 */     if (l.size() == 0) return false;
/* 1292 */     for (int i = 0; i < l.size(); i++) {
/* 1293 */       IhmLien l2 = getDeuxiemeLien(((IhmLien)l.get(i)).getRelation(), (IhmLien)l.get(i));
/* 1294 */       if ((l2 != null) && 
/* 1295 */         (l2.getEntite().getEntite().getCle() != null) && 
/* 1296 */         (l2.getEntite().getEntite().getCle().size() > 0)) {
/* 1297 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1302 */     return false;
/*      */   }
/*      */   
/*      */   public boolean islien1101(IhmLien lien) {
/* 1306 */     if ((lien.getCardinalite().trim().indexOf("0,1") >= 0) || (lien.getCardinalite().trim().indexOf("1,1") >= 0))
/* 1307 */       return true;
/* 1308 */     return false;
/*      */   }
/*      */   
/*      */   public boolean isDeuxLien1101(IhmLien lien1, IhmLien lien2) {
/* 1312 */     if ((!islien1101(lien1)) && (!islien1101(lien2))) {
/* 1313 */       return false;
/*      */     }
/* 1315 */     return true;
/*      */   }
/*      */   
/*      */   public boolean relationDisparait(IhmRelation rel) {
/* 1319 */     int nb = 0;
/* 1320 */     IhmLien l1 = null;IhmLien l2 = null;
/* 1321 */     int n = getPage().getListeLien().size();
/* 1322 */     for (int i = 0; i < n; i++) {
/* 1323 */       if (((IhmLien)getPage().getListeLien().get(i)).getRelation() == rel) {
/* 1324 */         nb++;
/* 1325 */         if (l1 == null) {
/* 1326 */           l1 = (IhmLien)getPage().getListeLien().get(i);
/*      */         }
/* 1328 */         else if (l2 == null) {
/* 1329 */           l2 = (IhmLien)getPage().getListeLien().get(i);
/*      */         }
/*      */       }
/*      */       
/* 1333 */       if (nb > 2) return false;
/*      */     }
/* 1335 */     if (nb == 2) {
/* 1336 */       return isDeuxLien1101(l1, l2);
/*      */     }
/* 1338 */     return false;
/*      */   }
/*      */   
/*      */   public int getCondition() {
/* 1342 */     int n = 0;
/* 1343 */     if (Setting.videNomAss) {
/* 1344 */       n = 1;
/*      */     }
/* 1346 */     if (Setting.redondNomAss) {
/* 1347 */       n = 2;
/*      */     }
/* 1349 */     if ((Setting.videNomAss) && (Setting.redondNomAss)) {
/* 1350 */       n = 3;
/*      */     }
/* 1352 */     return n;
/*      */   }
/*      */   
/*      */   public boolean isCorrectVideRelation() {
/* 1356 */     int n = getPage().getListeEntiteRelation().size();
/* 1357 */     for (int i = 0; i < n; i++) {
/* 1358 */       if (((getPage().getListeEntiteRelation().get(i) instanceof IhmRelation2)) && 
/* 1359 */         (((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom().trim().length() == 0)) {
/* 1360 */         if (((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().size() > 1) {
/* 1361 */           getConsole().getRapport().append("le nom de la relation ne doit pas être vide \n");
/* 1362 */           return false;
/*      */         }
/* 1364 */         if (!relationDisparait((IhmRelation2)getPage().getListeEntiteRelation().get(i))) {
/* 1365 */           getConsole().getRapport().append("le nom de la relation ne doit pas être vide \n");
/* 1366 */           return false;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1372 */     return true;
/*      */   }
/*      */   
/*      */   public boolean existeRelationMemeNom(IhmRelation rel) {
/* 1376 */     int n = getPage().getListeEntiteRelation().size();
/* 1377 */     for (int i = 0; i < n; i++) {
/* 1378 */       if (getPage().getListeEntiteRelation().get(i) != rel) {
/* 1379 */         if ((getPage().getListeEntiteRelation().get(i) instanceof IhmRelation2)) {
/* 1380 */           if ((((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom().trim().length() > 0) && 
/* 1381 */             (rel.getRelation().getNom().trim().toUpperCase().equals(((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase())) && 
/* 1382 */             (!relationDisparait((IhmRelation2)getPage().getListeEntiteRelation().get(i)))) {
/* 1383 */             getConsole().getRapport().append("le nom de la relation \"" + rel.getRelation().getNom() + "\"existe en deux ou plusieurs fois \n");
/* 1384 */             return true;
/*      */ 
/*      */           }
/*      */           
/*      */ 
/*      */         }
/* 1390 */         else if (((getPage().getListeEntiteRelation().get(i) instanceof IhmEntite2)) && 
/* 1391 */           (rel.getRelation().getNom().trim().toUpperCase().equals(((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase()))) {
/* 1392 */           getConsole().getRapport().append("le nom de la relation \"" + rel.getRelation().getNom() + "\" existe en deux ou plusieurs fois \n");
/* 1393 */           return true;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1399 */     return false;
/*      */   }
/*      */   
/*      */   public boolean isCorrectRedoandanceRelationSansVide() {
/* 1403 */     int n = getPage().getListeEntiteRelation().size();
/* 1404 */     boolean corr = true;
/* 1405 */     for (int i = 0; i < n; i++) {
/* 1406 */       if (((getPage().getListeEntiteRelation().get(i) instanceof IhmRelation2)) && 
/* 1407 */         (!relationDisparait((IhmRelation2)getPage().getListeEntiteRelation().get(i))) && 
/* 1408 */         (existeRelationMemeNom((IhmRelation2)getPage().getListeEntiteRelation().get(i)))) {
/* 1409 */         getConsole().getRapport().append("la relation \"" + ((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom() + "\" existe deja \n");
/* 1410 */         corr = false;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1416 */     return corr;
/*      */   }
/*      */   
/*      */   public boolean isCorrectRedoandanceRelationAvecVide() {
/* 1420 */     int n = getPage().getListeEntiteRelation().size();
/* 1421 */     boolean corr = true;
/* 1422 */     for (int i = 0; i < n; i++) {
/* 1423 */       if ((getPage().getListeEntiteRelation().get(i) instanceof IhmRelation2)) {
/* 1424 */         if (((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom().trim().length() > 0) {
/* 1425 */           if ((!relationDisparait((IhmRelation2)getPage().getListeEntiteRelation().get(i))) && 
/* 1426 */             (existeRelationMemeNom((IhmRelation2)getPage().getListeEntiteRelation().get(i)))) {
/* 1427 */             getConsole().getRapport().append("la relation \"" + ((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom() + "\" existe deja \n");
/* 1428 */             corr = false;
/*      */           }
/*      */           
/*      */         }
/* 1432 */         else if (((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().size() == 0) {
/* 1433 */           if (!relationDisparait((IhmRelation2)getPage().getListeEntiteRelation().get(i))) {
/* 1434 */             getConsole().getRapport().append("il existe des relations sans nom qui ne sont pas des relations binaires avec au moins un lien '0,1' ou '1,1' \n");
/*      */             
/* 1436 */             corr = false;
/*      */           }
/*      */         } else {
/* 1439 */           getConsole().getRapport().append("les relations vides avec des attributs doievnt avoir un nom \n");
/* 1440 */           corr = false;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1446 */     return corr;
/*      */   }
/*      */   
/*      */   public boolean existeRelationVide() {
/* 1450 */     int n = getPage().getListeEntiteRelation().size();
/* 1451 */     for (int i = 0; i < n; i++) {
/* 1452 */       if (((getPage().getListeEntiteRelation().get(i) instanceof IhmRelation2)) && 
/* 1453 */         (((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom().trim().equals(""))) { return true;
/*      */       }
/*      */     }
/* 1456 */     return false;
/*      */   }
/*      */   
/*      */   public boolean isUnique(IhmEntite ent) {
/* 1460 */     int n = getPage().getListeEntiteRelation().size();
/* 1461 */     for (int i = 0; i < n; i++) {
/* 1462 */       if ((getPage().getListeEntiteRelation().get(i) != ent) && 
/* 1463 */         ((getPage().getListeEntiteRelation().get(i) instanceof IhmEntite2)) && 
/* 1464 */         (ent.getEntite().getNom().trim().toUpperCase().equals(((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase()))) {
/* 1465 */         return false;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1470 */     return true;
/*      */   }
/*      */   
/*      */   public boolean entitesUnique() {
/* 1474 */     int n = getPage().getListeEntiteRelation().size();
/* 1475 */     for (int i = 0; i < n; i++) {
/* 1476 */       if (((getPage().getListeEntiteRelation().get(i) instanceof IhmEntite2)) && 
/* 1477 */         (!isUnique((IhmEntite2)getPage().getListeEntiteRelation().get(i)))) {
/* 1478 */         getConsole().getRapport().append("le nom de l'entite \"" + ((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getNom() + "\" existe en deux ou plusieurs fois \n");
/*      */         
/* 1480 */         return false;
/*      */       }
/*      */     }
/*      */     
/* 1484 */     return true;
/*      */   }
/*      */   
/*      */   public boolean correctionEntiteRelation()
/*      */   {
/* 1489 */     int cond = getCondition();
/* 1490 */     if (cond == 0) {
/* 1491 */       boolean c2 = existeDoublure();
/* 1492 */       boolean c4 = isLienRelatifCorrecte();
/* 1493 */       boolean c1 = isCorrecteMCD();
/* 1494 */       boolean c3 = existeRelationVide();
/*      */       
/* 1496 */       if (c3) getConsole().getRapport().append("Il existe des relations vides \n");
/* 1497 */       if ((c4) && (c1) && (!c2) && (!c3)) return true;
/* 1498 */       return false;
/*      */     }
/* 1500 */     if (cond == 1)
/*      */     {
/* 1502 */       boolean c2 = entitesUnique();
/* 1503 */       boolean c5 = isLienRelatifCorrecte();
/* 1504 */       boolean c3 = isCorrecteMCD();
/* 1505 */       boolean c1 = isCorrectVideRelation();
/* 1506 */       boolean c4 = existeDoublureNonVide();
/* 1507 */       if ((c5) && (c1) && (c2) && (c3) && (!c4)) return true;
/* 1508 */       return false;
/*      */     }
/* 1510 */     if (cond == 2) {
/* 1511 */       if (existeRelationVide()) {
/* 1512 */         getConsole().getRapport().append("Il existe des relations vides \n");
/* 1513 */         return false;
/*      */       }
/* 1515 */       if (entitesUnique()) {
/* 1516 */         boolean c3 = isLienRelatifCorrecte();
/* 1517 */         boolean c1 = isCorrecteMCD();
/* 1518 */         boolean c2 = isCorrectRedoandanceRelationSansVide();
/* 1519 */         if ((c3) && (c1) && (c2)) return true;
/* 1520 */         return false;
/*      */       }
/* 1522 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1526 */     if (cond == 3) {
/* 1527 */       if (entitesUnique()) {
/* 1528 */         boolean c2 = isCorrecteMCD();
/* 1529 */         boolean c1 = isCorrectRedoandanceRelationAvecVide();
/* 1530 */         boolean c3 = isLienRelatifCorrecte();
/* 1531 */         if ((c1) && (c2) && (c3)) return true;
/* 1532 */         return false;
/*      */       }
/* 1534 */       return false;
/*      */     }
/*      */     
/* 1537 */     return true; }
/*      */   
/*      */   private JCheckBoxMenuItem jMIOmbre;
/*      */   private JMenuItem jMIQuiter;
/*      */   private JMenuItem jMIRafraichirLibrairie;
/*      */   private JMenuItem jMIRelation;
/*      */   private JMenuItem jMIRemplacer;
/* 1544 */   public boolean uniqueAttributListe(Attribut att, ArrayList<Attribut> liste) { for (int i = 0; i < liste.size(); i++) {
/* 1545 */       if ((att != liste.get(i)) && 
/* 1546 */         (att.getNom().trim().toUpperCase().equals(((Attribut)liste.get(i)).getNom().trim().toUpperCase()))) { return false;
/*      */       }
/*      */     }
/* 1549 */     return true;
/*      */   }
/*      */   
/*      */   public boolean uniqueAttribut(Attribut att) {
/* 1553 */     int n = getPage().getListeEntiteRelation().size();
/* 1554 */     for (int i = 0; i < n; i++) {
/* 1555 */       if (((getPage().getListeEntiteRelation().get(i) instanceof IhmEntite2)) && 
/* 1556 */         (!uniqueAttributListe(att, ((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs()))) {
/* 1557 */         return false;
/*      */       }
/*      */       
/* 1560 */       if (((getPage().getListeEntiteRelation().get(i) instanceof IhmRelation2)) && 
/* 1561 */         (!uniqueAttributListe(att, ((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs()))) {
/* 1562 */         return false;
/*      */       }
/*      */     }
/*      */     
/* 1566 */     return true;
/*      */   }
/*      */   
/*      */   public boolean uniqueAttributToutMCD() {
/* 1570 */     int n = getPage().getListeEntiteRelation().size();
/*      */     
/* 1572 */     boolean corr = true;
/*      */     
/* 1574 */     for (int i = 0; i < n; i++) {
/* 1575 */       if ((getPage().getListeEntiteRelation().get(i) instanceof IhmEntite2)) {
/* 1576 */         ArrayList<Attribut> liste = ((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs();
/* 1577 */         int m = liste.size();
/* 1578 */         for (int j = 0; j < m; j++) {
/* 1579 */           if (!uniqueAttribut((Attribut)liste.get(j))) {
/* 1580 */             corr = false;
/* 1581 */             getConsole().getRapport().append("attribut : \"" + ((Attribut)liste.get(j)).getNom() + "\" de l'entité " + ((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getNom() + " n'est pas unique dans le MCD \n");
/*      */           }
/*      */         }
/*      */       }
/* 1585 */       if ((getPage().getListeEntiteRelation().get(i) instanceof IhmRelation2)) {
/* 1586 */         ArrayList<Attribut> liste = ((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs();
/* 1587 */         int m = liste.size();
/* 1588 */         for (int j = 0; j < m; j++) {
/* 1589 */           if (!uniqueAttribut((Attribut)liste.get(j))) {
/* 1590 */             corr = false;
/* 1591 */             getConsole().getRapport().append("attribut : " + ((Attribut)liste.get(j)).getNom() + " de la relation " + ((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom() + " n'est pas unique dans le MCD \n");
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/* 1596 */     return corr;
/*      */   }
/*      */   
/*      */   private boolean existeDoublureNonVide() {
/* 1600 */     boolean trouver = false;
/*      */     
/* 1602 */     for (int i = 0; i < getPage().getListeEntiteRelation().size(); i++) {
/* 1603 */       for (int j = i + 1; j < getPage().getListeEntiteRelation().size(); j++) {
/* 1604 */         if (((IhmEntiteRelation)getPage().getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) {
/* 1605 */           if ((((IhmEntiteRelation)getPage().getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) && 
/* 1606 */             (((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase().equals(((IhmEntite2)getPage().getListeEntiteRelation().get(j)).getEntite().getNom().trim().toUpperCase()))) {
/* 1607 */             trouver = true;
/* 1608 */             getConsole().getRapport().append("Il existe deux entités qui ont le même nom : " + ((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getNom() + "\n");
/*      */           }
/*      */           
/*      */ 
/* 1612 */           if ((((IhmEntiteRelation)getPage().getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2")) && 
/* 1613 */             (((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase().equals(((IhmRelation2)getPage().getListeEntiteRelation().get(j)).getRelation().getNom().trim().toUpperCase()))) {
/* 1614 */             trouver = true;
/* 1615 */             getConsole().getRapport().append("Il existe une entité et une relation qui ont le même nom : " + ((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getNom() + "\n");
/*      */           }
/*      */         }
/*      */         
/*      */ 
/* 1620 */         if ((((IhmEntiteRelation)getPage().getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2")) && 
/* 1621 */           (((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom().trim().length() > 0)) {
/* 1622 */           if ((((IhmEntiteRelation)getPage().getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) && 
/* 1623 */             (((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase().equals(((IhmEntite2)getPage().getListeEntiteRelation().get(j)).getEntite().getNom().trim().toUpperCase()))) {
/* 1624 */             trouver = true;
/* 1625 */             getConsole().getRapport().append("Il existe une entité et une relation qui ont le même nom : " + ((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom() + "\n");
/*      */           }
/*      */           
/* 1628 */           if (((IhmEntiteRelation)getPage().getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2"))
/*      */           {
/* 1630 */             if (((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase().equals(((IhmRelation2)getPage().getListeEntiteRelation().get(j)).getRelation().getNom().trim().toUpperCase())) {
/* 1631 */               trouver = true;
/* 1632 */               getConsole().getRapport().append("Il existe deux relation qui ont le même nom : " + ((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom() + "\n");
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1640 */     return trouver;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean existeDoublure()
/*      */   {
/* 1646 */     boolean trouver = false;
/* 1647 */     for (int i = 0; i < getPage().getListeEntiteRelation().size(); i++) {
/* 1648 */       for (int j = i + 1; j < getPage().getListeEntiteRelation().size(); j++) {
/* 1649 */         if (((IhmEntiteRelation)getPage().getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2"))
/*      */         {
/* 1651 */           if ((((IhmEntiteRelation)getPage().getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) && 
/* 1652 */             (((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase().equals(((IhmEntite2)getPage().getListeEntiteRelation().get(j)).getEntite().getNom().trim().toUpperCase()))) {
/* 1653 */             trouver = true;
/* 1654 */             getConsole().getRapport().append("Il existe deux entités qui ont le même nom : " + ((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getNom() + "\n");
/*      */           }
/*      */           
/*      */ 
/* 1658 */           if ((((IhmEntiteRelation)getPage().getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2")) && 
/* 1659 */             (((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase().equals(((IhmRelation2)getPage().getListeEntiteRelation().get(j)).getRelation().getNom().trim().toUpperCase()))) {
/* 1660 */             trouver = true;
/* 1661 */             getConsole().getRapport().append("Il existe une entité et une relation qui ont le même nom : " + ((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getNom() + "\n");
/*      */           }
/*      */         }
/*      */         
/*      */ 
/* 1666 */         if (((IhmEntiteRelation)getPage().getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2"))
/*      */         {
/* 1668 */           if ((((IhmEntiteRelation)getPage().getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) && 
/* 1669 */             (((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase().equals(((IhmEntite2)getPage().getListeEntiteRelation().get(j)).getEntite().getNom().trim().toUpperCase()))) {
/* 1670 */             trouver = true;
/* 1671 */             getConsole().getRapport().append("Il existe une entité et une relation qui ont le même nom : " + ((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom() + "\n");
/*      */           }
/*      */           
/* 1674 */           if (((IhmEntiteRelation)getPage().getListeEntiteRelation().get(j)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2"))
/*      */           {
/* 1676 */             if (((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase().equals(((IhmRelation2)getPage().getListeEntiteRelation().get(j)).getRelation().getNom().trim().toUpperCase())) {
/* 1677 */               trouver = true;
/* 1678 */               getConsole().getRapport().append("Il existe deux relation qui ont le même nom : " + ((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom() + "\n");
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 1685 */     return trouver;
/*      */   }
/*      */   
/*      */   private boolean existeCleListeAttribut(ArrayList<Attribut> liste) {
/* 1689 */     for (int i = 0; i < liste.size(); i++) {
/* 1690 */       if (((Attribut)liste.get(i)).getKey().trim().equals(Parametres.Cle)) return true;
/*      */     }
/* 1692 */     return false;
/*      */   }
/*      */   
/*      */   private IhmEntite getPereEntite(IhmEntite ent) {
/* 1696 */     for (int i = 0; i < getPage().getListeLienHeritage().size(); i++) {
/* 1697 */       if (ent == ((IhmLienHeritage2)getPage().getListeLienHeritage().get(i)).getFils()) return (IhmEntite)((IhmLienHeritage2)getPage().getListeLienHeritage().get(i)).getPere();
/*      */     }
/* 1699 */     return null;
/*      */   }
/*      */   
/*      */   private boolean existeCleEntitePere(IhmEntite ent) {
/* 1703 */     if (existeCleListeAttribut(ent.getEntite().getListeAttributs())) return true;
/* 1704 */     IhmEntite entT = getPereEntite(ent);
/* 1705 */     while (entT != null) {
/* 1706 */       if (existeCleListeAttribut(entT.getEntite().getListeAttributs())) return true;
/* 1707 */       entT = getPereEntite(entT);
/*      */     }
/* 1709 */     return false;
/*      */   }
/*      */   
/*      */   private boolean estFilsDe(IhmEntite ent) {
/* 1713 */     for (int i = 0; i < getPage().getListeLienHeritage().size(); i++) {
/* 1714 */       if (((IhmLienHeritage2)getPage().getListeLienHeritage().get(i)).getFils().equals(ent)) return true;
/*      */     }
/* 1716 */     return false;
/*      */   }
/*      */   
/*      */   private boolean isLienCorrecte(IhmRelation rel) {
/* 1720 */     int nb = 0;
/* 1721 */     for (int i = 0; i < getPage().getListeLien().size(); i++) {
/* 1722 */       if (((IhmLien)getPage().getListeLien().get(i)).getRelation().equals(rel)) {
/* 1723 */         nb++;
/* 1724 */         if (nb == 2) return true;
/*      */       }
/*      */     }
/* 1727 */     return false;
/*      */   }
/*      */   
/*      */   public void setFeelAndLookSettingMenu(String fel) {
/* 1731 */     if (fel.equals("JAVA")) {
/* 1732 */       this.jRBFeelJava.setSelected(true);
/* 1733 */       this.jRBFeelNimbus.setSelected(false);
/* 1734 */       this.jRBFeelSystem.setSelected(false);
/*      */     }
/*      */     
/* 1737 */     if (fel.equals("SYSTEME")) {
/* 1738 */       this.jRBFeelJava.setSelected(false);
/* 1739 */       this.jRBFeelNimbus.setSelected(false);
/* 1740 */       this.jRBFeelSystem.setSelected(true);
/*      */     }
/*      */     
/* 1743 */     if (fel.equals("JMERISE")) {
/* 1744 */       this.jRBFeelJava.setSelected(false);
/* 1745 */       this.jRBFeelNimbus.setSelected(true);
/* 1746 */       this.jRBFeelSystem.setSelected(false);
/*      */     }
/*      */   }
/*      */   
/*      */   public void setFeelAndLook(String fel)
/*      */   {
/* 1752 */     if (fel.equals("JAVA")) {
/*      */       try {
/* 1754 */         UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
/*      */         
/* 1756 */         SwingUtilities.updateComponentTreeUI(this);
/* 1757 */         Setting.afficherFAndL2 = "JAVA";
/*      */       } catch (Exception e) {
/* 1759 */         System.out.println("Erreur L&F java");
/* 1760 */         Setting.afficherFAndL2 = "JAVA";
/*      */       }
/*      */     }
/*      */     
/* 1764 */     if (fel.equals("SYSTEME")) {
/*      */       try {
/* 1766 */         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/* 1767 */         SwingUtilities.updateComponentTreeUI(this);
/* 1768 */         Setting.afficherFAndL2 = "SYSTEME";
/*      */       } catch (Exception e) {
/* 1770 */         System.out.println("Erreur L&F votre system");
/* 1771 */         Setting.afficherFAndL2 = "JAVA";
/*      */       }
/*      */     }
/*      */     
/* 1775 */     if (fel.equals("JMERISE")) {
/*      */       try {
/* 1777 */         UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
/*      */         
/* 1779 */         SwingUtilities.updateComponentTreeUI(this);
/* 1780 */         Setting.afficherFAndL2 = "JMERISE";
/*      */       } catch (Exception e) {
/* 1782 */         System.out.println("Erreur Nimbus");
/* 1783 */         Setting.afficherFAndL2 = "JAVA";
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean isCorrecteMCD()
/*      */   {
/* 1790 */     boolean trouver = true;
/* 1791 */     for (int i = 0; i < getPage().getListeEntiteRelation().size(); i++) {
/* 1792 */       if ((((IhmEntiteRelation)getPage().getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) && 
/* 1793 */         (!existeCleEntitePere((IhmEntite2)getPage().getListeEntiteRelation().get(i))) && 
/* 1794 */         (!estFilsDe((IhmEntite2)getPage().getListeEntiteRelation().get(i))) && 
/* 1795 */         (!isCleAvecLienRelatif((IhmEntite2)getPage().getListeEntiteRelation().get(i)))) {
/* 1796 */         getConsole().getRapport().append("L'entite : " + ((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getNom() + " n'a pas d'attribut ou d'attribut clé \n");
/* 1797 */         trouver = false;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 1802 */       if ((((IhmEntiteRelation)getPage().getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmRelation2")) && 
/* 1803 */         (!isLienCorrecte((IhmRelation2)getPage().getListeEntiteRelation().get(i)))) {
/* 1804 */         trouver = false;
/* 1805 */         getConsole().getRapport().append("La relation : " + ((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom() + " n'a qu'un seul lien \n");
/*      */       }
/*      */     }
/*      */     
/* 1809 */     return trouver;
/*      */   }
/*      */   
/*      */   private boolean existeDomaine(String domaine) {
/* 1813 */     for (int i = 0; i < Parametres.DomaineDefini.length; i++) {
/* 1814 */       if (domaine.trim().toUpperCase().equals(Parametres.DomaineDefini[i].trim().toUpperCase())) return true;
/*      */     }
/* 1816 */     for (int i = 0; i < getPage().getListeDomaine().size(); i++) {
/* 1817 */       if (domaine.trim().toUpperCase().equals(((Domaine)getPage().getListeDomaine().get(i)).getNom().trim().toUpperCase())) return true;
/*      */     }
/* 1819 */     return false;
/*      */   }
/*      */   
/*      */   private boolean isCorrectDomaine() {
/* 1823 */     boolean correc = true;
/*      */     
/* 1825 */     for (int i = 0; i < getPage().getListeEntiteRelation().size(); i++) {
/* 1826 */       if (((IhmEntiteRelation)getPage().getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) {
/* 1827 */         for (int j = 0; j < ((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().size(); j++) {
/* 1828 */           if (!existeDomaine(((Attribut)((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getType())) {
/* 1829 */             correc = false;
/* 1830 */             getConsole().getRapport().append("Le domaine " + ((Attribut)((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getType() + " de l'attribut " + ((Attribut)((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getNom() + " de l'entite " + ((IhmEntite2)getPage().getListeEntiteRelation().get(i)).getEntite().getNom() + " n'est pas défini " + "\n");
/*      */           }
/*      */           
/*      */         }
/*      */         
/*      */       } else {
/* 1836 */         for (int j = 0; j < ((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().size(); j++) {
/* 1837 */           if (!existeDomaine(((Attribut)((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getType())) {
/* 1838 */             correc = false;
/* 1839 */             getConsole().getRapport().append("Le domaine " + ((Attribut)((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getType() + " de l'attribut " + ((Attribut)((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getNom() + " de la relation " + ((IhmRelation2)getPage().getListeEntiteRelation().get(i)).getRelation().getNom() + " n'est pas défini " + "\n");
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 1846 */     return correc;
/*      */   }
/*      */   
/*      */ 
/*      */   private String valeurBalise(String s)
/*      */   {
/* 1852 */     s = s.substring(s.indexOf(">") + 1, s.length());
/* 1853 */     return s;
/*      */   }
/*      */   
/*      */   public boolean saveFormeBureau(String nomfile)
/*      */   {
/* 1858 */     File file = new File(nomfile);
/*      */     try {
/* 1860 */       PrintStream out = new PrintStream(new java.util.zip.GZIPOutputStream(new java.io.FileOutputStream(file)));
/* 1861 */       out.println("<NOTE>");
/* 1862 */       out.println("Toutes modifications de ce fichier entraine un dysfonctionnement de JMerise");
/* 1863 */       out.println("Vous serez le seul responsable des désagréments occasionnés");
/* 1864 */       out.println("</NOTE>");
/* 1865 */       out.println("<ABOUT>");
/* 1866 */       out.println("<NAME> JMerise");
/* 1867 */       out.println("</NAME>");
/*      */       
/* 1869 */       out.println("<OWNER> MESSOUCI");
/* 1870 */       out.println("</OWNER>");
/* 1871 */       out.println("<VERSION> 0.5.B");
/* 1872 */       out.println("</VERSION>");
/*      */       
/* 1874 */       out.println("<CREATION> 08/11/2011");
/* 1875 */       out.println("</CREATION>");
/*      */       
/* 1877 */       out.println("<MODIF> 08/02/2017");
/* 1878 */       out.println("</MODIF>");
/*      */       
/* 1880 */       out.println("</ABOUT>");
/*      */       
/* 1882 */       out.println("<PARAM>");
/* 1883 */       out.println("<FenMCD>");
/*      */       
/* 1885 */       out.println("<visible>");
/* 1886 */       out.println(this.formeMCD.isVisible() ? "true" : "false");
/* 1887 */       out.println("</visible>");
/*      */       
/* 1889 */       out.println("<x>");
/* 1890 */       out.println(this.formeMCD.getX() + "");
/* 1891 */       out.println("</x>");
/* 1892 */       out.println("<y>");
/* 1893 */       out.println(this.formeMCD.getY() + "");
/* 1894 */       out.println("</y>");
/*      */       
/* 1896 */       out.println("<w>");
/* 1897 */       out.println(this.formeMCD.getWidth() + "");
/* 1898 */       out.println("</w>");
/*      */       
/* 1900 */       out.println("<h>");
/* 1901 */       out.println(this.formeMCD.getHeight() + "");
/* 1902 */       out.println("</h>");
/*      */       
/* 1904 */       out.println("</FenMCD>");
/*      */       
/* 1906 */       out.println("<FenMLD>");
/* 1907 */       out.println(this.formeMLD.isVisible() ? "true" : "false");
/* 1908 */       out.println("</FenMLD>");
/*      */       
/* 1910 */       out.println("<FenSQL>");
/* 1911 */       out.println(this.formeSQL.isVisible() ? "true" : "false");
/*      */       
/* 1913 */       out.println("</FenSQL>");
/*      */       
/* 1915 */       out.println("<CouleurDef>");
/* 1916 */       out.println(FormeInterneMCD.etatColor);
/* 1917 */       out.println("</CouleurDef>");
/*      */       
/* 1919 */       out.println("<Ombre>");
/* 1920 */       out.println(this.jMIOmbre.isSelected() ? "true" : "false");
/* 1921 */       out.println("</Ombre>");
/*      */       
/*      */ 
/* 1924 */       out.println("<tailleEnt>");
/* 1925 */       out.println(this.jMIVariable.isSelected() ? "true" : "false");
/* 1926 */       out.println("</tailleEnt>");
/*      */       
/* 1928 */       out.println("<coulourDegradee>");
/* 1929 */       out.println(this.jMICouleurDegradee.isSelected() ? "true" : "false");
/* 1930 */       out.println("</coulourDegradee>");
/*      */       
/* 1932 */       out.println("<Fenconsole>");
/* 1933 */       out.println(this.jMIConsole.isSelected() ? "true" : "false");
/* 1934 */       out.println("</Fenconsole>");
/*      */       
/*      */ 
/* 1937 */       out.println("<FenExplorer>");
/* 1938 */       out.println(this.jMIExplorer.isSelected() ? "true" : "false");
/* 1939 */       out.println("</FenExplorer>");
/*      */       
/* 1941 */       out.println("<Grille>");
/* 1942 */       out.println(this.bar.isAfficheRegle() ? "true" : "false");
/* 1943 */       out.println("</Grille>");
/*      */       
/* 1945 */       out.println("<FichierMCD>");
/* 1946 */       out.println("<Fic1>");
/* 1947 */       int i = 0;int nb = this.listeMenu.size();
/* 1948 */       out.println(i < nb ? ((MyMenuItem)this.listeMenu.get(i)).getChemin() : " ");i++;
/* 1949 */       out.println("</Fic1>");
/* 1950 */       out.println("<Fic2>");
/* 1951 */       out.println(i < nb ? ((MyMenuItem)this.listeMenu.get(i)).getChemin() : " ");i++;
/* 1952 */       out.println("</Fic2>");
/*      */       
/* 1954 */       out.println("<Fic3>");
/* 1955 */       out.println(i < nb ? ((MyMenuItem)this.listeMenu.get(i)).getChemin() : " ");i++;
/* 1956 */       out.println("</Fic3>");
/*      */       
/* 1958 */       out.println("<Fic4>");
/* 1959 */       out.println(i < nb ? ((MyMenuItem)this.listeMenu.get(i)).getChemin() : " ");i++;
/* 1960 */       out.println("</Fic4>");
/*      */       
/* 1962 */       out.println("<Fic5>");
/* 1963 */       out.println(i < nb ? ((MyMenuItem)this.listeMenu.get(i)).getChemin() : " ");i++;
/* 1964 */       out.println("</Fic5>");
/*      */       
/* 1966 */       out.println("</FichierMCD>");
/*      */       
/*      */ 
/* 1969 */       out.println("</PARAM>");
/* 1970 */       out.flush();
/* 1971 */       out.close();
/* 1972 */       return true;
/*      */     }
/*      */     catch (IOException e) {}
/* 1975 */     return false;
/*      */   }
/*      */   
/*      */   public boolean openFormeBureau(String nomfile)
/*      */   {
/* 1980 */     File file = new File(nomfile);
/*      */     try {
/* 1982 */       BufferedReader in = new BufferedReader(new java.io.InputStreamReader(new java.util.zip.GZIPInputStream(new java.io.FileInputStream(file))));
/* 1983 */       String st = "";String s = "";
/* 1984 */       while ((s = in.readLine()) != null) {
/* 1985 */         st = st + s;
/*      */       }
/* 1987 */       if (st.trim().length() > 0) {
/*      */         try {
/* 1989 */           initialiserBureau(st);
/*      */         } catch (Exception e) {
/* 1991 */           return false;
/*      */         }
/*      */       }
/* 1994 */       in.close();
/* 1995 */       return true;
/*      */     } catch (IOException e) {}
/* 1997 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   private void initialiserBureau(String st)
/*      */   {
/* 2003 */     String s = st.substring(st.indexOf("<FenMCD>"), st.indexOf("</FenMCD>"));
/* 2004 */     String ch = s.substring(s.indexOf("<visible>"), s.indexOf("</visible>"));
/* 2005 */     ch = valeurBalise(ch);
/* 2006 */     if (ch.equals("true")) {
/* 2007 */       this.formeMCD.setVisible(true);
/*      */     } else {
/* 2009 */       this.formeMCD.setVisible(false);
/*      */     }
/* 2011 */     ch = s.substring(s.indexOf("<x>"), s.indexOf("</x>"));
/* 2012 */     ch = valeurBalise(ch);
/*      */     
/* 2014 */     this.formeMCD.setLocation(Integer.parseInt(ch), Integer.parseInt(valeurBalise(s.substring(s.indexOf("<y>"), s.indexOf("</y>")))));
/*      */     
/* 2016 */     this.formeMCD.setSize(Integer.parseInt(valeurBalise(s.substring(s.indexOf("<w>"), s.indexOf("</w>")))), Integer.parseInt(valeurBalise(s.substring(s.indexOf("<h>"), s.indexOf("</h>")))));
/*      */     
/* 2018 */     s = st.substring(st.indexOf("<FenMLD>"), st.indexOf("</FenMLD>"));
/* 2019 */     if (valeurBalise(s).equals("true")) {
/* 2020 */       this.formeMLD.setVisible(true);
/*      */     } else {
/* 2022 */       this.formeMLD.setVisible(false);
/*      */     }
/*      */     
/* 2025 */     s = st.substring(st.indexOf("<FenSQL>"), st.indexOf("</FenSQL>"));
/* 2026 */     if (valeurBalise(s).equals("true")) {
/* 2027 */       this.formeSQL.setVisible(true);
/*      */     } else {
/* 2029 */       this.formeSQL.setVisible(false);
/*      */     }
/*      */     
/* 2032 */     ch = st.substring(st.indexOf("<CouleurDef>"), st.indexOf("</CouleurDef>"));
/* 2033 */     ch = valeurBalise(ch);
/* 2034 */     if (ch.equals(Parametres.etatAUCUNEColor)) {
/* 2035 */       FormeInterneMCD.initialiserAucuneColor();
/*      */     } else {
/* 2037 */       FormeInterneMCD.initialiserDefaultColor();
/*      */     }
/* 2039 */     ch = st.substring(st.indexOf("<Ombre>"), st.indexOf("</Ombre>"));
/* 2040 */     ch = valeurBalise(ch);
/* 2041 */     if (ch.trim().equals("true")) {
/* 2042 */       this.jMIOmbre.setSelected(true);
/*      */     } else {
/* 2044 */       this.jMIOmbre.setSelected(false);
/*      */     }
/*      */     
/*      */ 
/* 2048 */     ch = st.substring(st.indexOf("<tailleEnt>"), st.indexOf("</tailleEnt>"));
/* 2049 */     ch = valeurBalise(ch);
/* 2050 */     if (ch.trim().equals("true")) {
/* 2051 */       this.jMIVariable.setSelected(true);
/*      */     } else {
/* 2053 */       this.jMIVariable.setSelected(false);
/*      */     }
/* 2055 */     this.formeMCD.getPage().setTailleVariable(this.jMIVariable.isSelected());
/* 2056 */     this.formeMCD.getPage().setTailleVariable(this.jMIVariable.isSelected());
/*      */     
/* 2058 */     ch = st.substring(st.indexOf("<coulourDegradee>"), st.indexOf("</coulourDegradee>"));
/* 2059 */     ch = valeurBalise(ch);
/* 2060 */     if (ch.trim().equals("true")) {
/* 2061 */       this.jMICouleurDegradee.setSelected(true);
/*      */     } else {
/* 2063 */       this.jMICouleurDegradee.setSelected(false);
/*      */     }
/* 2065 */     setClDegradee(this.jMICouleurDegradee.isSelected());
/*      */     
/* 2067 */     ch = st.substring(st.indexOf("<Grille>"), st.indexOf("</Grille>"));
/* 2068 */     ch = valeurBalise(ch);
/* 2069 */     if (ch.trim().equals("true")) {
/* 2070 */       this.bar.getBtRegle().setSelected(true);
/*      */     } else {
/* 2072 */       this.bar.getBtRegle().setSelected(false);
/*      */     }
/* 2074 */     this.bar.setAfficheRegle(this.bar.getBtRegle().isSelected());
/*      */     
/* 2076 */     ch = st.substring(st.indexOf("<Fenconsole>"), st.indexOf("</Fenconsole>"));
/* 2077 */     ch = valeurBalise(ch);
/* 2078 */     if (ch.trim().equals("true")) {
/* 2079 */       this.jMIConsole.setSelected(true);
/*      */     } else {
/* 2081 */       this.jMIConsole.setSelected(false);
/*      */     }
/* 2083 */     this.console.setVisible(this.jMIConsole.isSelected());
/* 2084 */     if (this.jMIConsole.isSelected()) {
/* 2085 */       this.console.setSize(this.console.getWidth(), 20);
/* 2086 */       this.splitCon.setDividerLocation(getHeight() - 200 - this.console.getHeight());
/*      */     }
/*      */     
/*      */ 
/* 2090 */     ch = st.substring(st.indexOf("<FenExplorer>"), st.indexOf("</FenExplorer>"));
/* 2091 */     ch = valeurBalise(ch);
/* 2092 */     if (ch.trim().equals("true")) {
/* 2093 */       this.jMIExplorer.setSelected(true);
/*      */     } else {
/* 2095 */       this.jMIExplorer.setSelected(false);
/*      */     }
/* 2097 */     this.explorer.setVisible(this.jMIExplorer.isSelected());
/* 2098 */     if (this.jMIExplorer.isSelected()) {
/* 2099 */       this.split.setDividerLocation(this.explorer.getWidth());
/*      */     }
/*      */     
/* 2102 */     ch = st.substring(st.indexOf("<Fic1>"), st.indexOf("</Fic1>"));
/* 2103 */     ch = valeurBalise(ch);
/* 2104 */     if ((ch.trim().length() > 0) && 
/* 2105 */       (Parametres.existeFichier(ch))) {
/* 2106 */       ajouterUnnouveauFichier(ch);
/* 2107 */       setCheminFichier(ch);
/*      */     }
/*      */     
/* 2110 */     ch = st.substring(st.indexOf("<Fic2>"), st.indexOf("</Fic2>"));
/* 2111 */     ch = valeurBalise(ch);
/* 2112 */     if ((ch.trim().length() > 0) && 
/* 2113 */       (Parametres.existeFichier(ch))) { ajouterUnnouveauFichier(ch);
/*      */     }
/* 2115 */     ch = st.substring(st.indexOf("<Fic3>"), st.indexOf("</Fic3>"));
/* 2116 */     ch = valeurBalise(ch);
/* 2117 */     if ((ch.trim().length() > 0) && 
/* 2118 */       (Parametres.existeFichier(ch))) { ajouterUnnouveauFichier(ch);
/*      */     }
/* 2120 */     ch = st.substring(st.indexOf("<Fic4>"), st.indexOf("</Fic4>"));
/* 2121 */     ch = valeurBalise(ch);
/* 2122 */     if ((ch.trim().length() > 0) && 
/* 2123 */       (Parametres.existeFichier(ch))) { ajouterUnnouveauFichier(ch);
/*      */     }
/* 2125 */     ch = st.substring(st.indexOf("<Fic5>"), st.indexOf("</Fic5>"));
/* 2126 */     ch = valeurBalise(ch);
/* 2127 */     if ((ch.trim().length() > 0) && 
/* 2128 */       (Parametres.existeFichier(ch))) { ajouterUnnouveauFichier(ch);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void setProjetMain(IhmProjet projet)
/*      */   {
/* 2135 */     this.projetSel = projet;
/* 2136 */     for (int i = 0; i < this.listeProjet.size(); i++) {
/* 2137 */       ((IhmProjet)this.listeProjet.get(i)).setMainProject(false);
/*      */     }
/* 2139 */     this.projetSel.setMainProject(true);
/* 2140 */     setTitle("JMerise : " + this.projetSel.getFormeMCD().getNomFichier());
/* 2141 */     this.formeMCD = this.projetSel.getFormeMCD();
/* 2142 */     this.formeMLD = this.projetSel.getFormeMLD();
/* 2143 */     this.formeSQL = this.projetSel.getFormeSQL();
/* 2144 */     this.formeXML = this.projetSel.getFormeXML();
/* 2145 */     if (this.demarrer) {
/* 2146 */       getPanelLoupe().setFrmInterne(this.formeMCD);
/* 2147 */       getPanelLoupe().repaint();
/*      */     }
/*      */     
/* 2150 */     getExplorer().getTree().updateUI();
/*      */   }
/*      */   
/*      */   public void supprimerProjet(IhmProjet pr) {
/* 2154 */     if (this.listeProjet.size() == 1) {
/* 2155 */       pr.getFormeMCD().setVisible(false);
/* 2156 */       pr.getFormeMLD().setVisible(false);
/* 2157 */       pr.getFormeSQL().setVisible(false);
/* 2158 */       pr.getFormeXML().setVisible(false);
/* 2159 */       this.desk.remove(pr.getFormeMCD());
/* 2160 */       this.desk.remove(pr.getFormeMLD());
/* 2161 */       this.desk.remove(pr.getFormeSQL());
/* 2162 */       this.desk.remove(pr.getFormeXML());
/* 2163 */       pr.getFormeMCD().dispose();
/* 2164 */       pr.getFormeMLD().dispose();
/* 2165 */       pr.getFormeSQL().dispose();
/* 2166 */       pr.getFormeXML().dispose();
/* 2167 */       this.listeProjet.remove(pr);
/* 2168 */       getExplorer().supprimerNode(pr);
/* 2169 */       creerNouveauProjet();
/* 2170 */       this.projetSel = ((IhmProjet)this.listeProjet.get(0));
/*      */       
/* 2172 */       getExplorer().getTree().updateUI();
/*      */     } else {
/* 2174 */       pr.getFormeMCD().setVisible(false);
/* 2175 */       pr.getFormeMLD().setVisible(false);
/* 2176 */       pr.getFormeSQL().setVisible(false);
/* 2177 */       pr.getFormeXML().setVisible(false);
/* 2178 */       this.desk.remove(pr.getFormeMCD());
/* 2179 */       this.desk.remove(pr.getFormeMLD());
/* 2180 */       this.desk.remove(pr.getFormeSQL());
/* 2181 */       this.desk.remove(pr.getFormeXML());
/* 2182 */       pr.getFormeMCD().dispose();
/* 2183 */       pr.getFormeMLD().dispose();
/* 2184 */       pr.getFormeSQL().dispose();
/* 2185 */       pr.getFormeXML().dispose();
/* 2186 */       this.listeProjet.remove(pr);
/* 2187 */       getExplorer().supprimerNode(pr);
/* 2188 */       this.projetSel = ((IhmProjet)this.listeProjet.get(0));
/* 2189 */       this.projetSel.setMainProject(true);
/* 2190 */       this.formeMCD = this.projetSel.getFormeMCD();
/* 2191 */       this.formeMLD = this.projetSel.getFormeMLD();
/* 2192 */       this.formeSQL = this.projetSel.getFormeSQL();
/* 2193 */       this.formeXML = this.projetSel.getFormeXML();
/* 2194 */       this.formeMCD.setVisible(true);
/* 2195 */       this.formeMCD.toFront();
/*      */       
/* 2197 */       getExplorer().getTree().updateUI();
/*      */     }
/*      */   }
/*      */   
/*      */   public void creerNouveauProjet() {
/* 2202 */     testActiverJMerise();
/* 2203 */     verifierSettingActivation();
/* 2204 */     IhmProjet pr = new IhmProjet(this);
/* 2205 */     this.listeProjet.add(pr);
/* 2206 */     this.desk.add(pr.getFormeMCD());
/* 2207 */     this.desk.add(pr.getFormeMLD());
/* 2208 */     this.desk.add(pr.getFormeSQL());
/* 2209 */     this.desk.add(pr.getFormeXML());
/* 2210 */     if (this.projetSel != null) this.projetSel.setMainProject(false);
/* 2211 */     this.projetSel = pr;
/* 2212 */     this.projetSel.setMainProject(true);
/* 2213 */     this.formeMCD = pr.getFormeMCD();
/* 2214 */     this.formeMLD = pr.getFormeMLD();
/* 2215 */     this.formeSQL = pr.getFormeSQL();
/* 2216 */     this.formeXML = pr.getFormeXML();
/*      */     
/*      */ 
/* 2219 */     this.formeMLD.setVisible(false);
/* 2220 */     this.formeSQL.setVisible(false);
/* 2221 */     this.formeXML.setVisible(false);
/*      */     
/* 2223 */     pr.getFormeMCD().setProjet(pr);
/* 2224 */     pr.getFormeMCD().setFormeMLD(this.formeMLD);
/* 2225 */     pr.getFormeMCD().setFormeSQL(this.formeSQL);
/* 2226 */     pr.getFormeMCD().setFormeXML(this.formeXML);
/* 2227 */     getExplorer().expandDernierNode();
/*      */     try {
/* 2229 */       getFormeMCD().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 2231 */       Logger.getLogger(Principale.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 2233 */     getFormeMCD().toFront();
/*      */   }
/*      */   
/*      */   public IhmProjet dejaOuvertProjet(String path) {
/* 2237 */     for (int i = 0; i < this.listeProjet.size(); i++) {
/* 2238 */       if (((IhmProjet)this.listeProjet.get(i)).getFormeMCD().getNomFichier().equals(path)) {
/* 2239 */         return (IhmProjet)this.listeProjet.get(i);
/*      */       }
/*      */     }
/* 2242 */     return null;
/*      */   }
/*      */   
/*      */   public boolean isModifierProjet() {
/* 2246 */     for (int i = 0; i < this.listeProjet.size(); i++) {
/* 2247 */       if (((IhmProjet)this.listeProjet.get(i)).getFormeMCD().isModifier()) {
/* 2248 */         return true;
/*      */       }
/*      */     }
/* 2251 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   private JMenuItem jMISupprimer;
/*      */   
/*      */   private JMenuItem jMISupprimerLibrairie;
/*      */   
/*      */   private JMenuItem jMITransformationHeritage;
/*      */   private JMenuItem jMITransformationRelation;
/*      */   private JMenuItem jMITransformer;
/*      */   private JCheckBoxMenuItem jMIVariable;
/*      */   private JMenuItem jMIVerifier;
/*      */   private JMenuItem jMIVersion;
/*      */   private JMenuItem jMIouvrir;
/*      */   private JMenu jMenu1;
/*      */   private JMenu jMenu10;
/*      */   private JMenu jMenu11;
/*      */   private JMenu jMenu12;
/*      */   private JMenu jMenu13;
/*      */   private JMenu jMenu14;
/*      */   private JMenu jMenu15;
/*      */   private JMenu jMenu16;
/*      */   
/*      */   public void quitterJMerise()
/*      */   {
/* 2277 */     boolean stop = false;
/* 2278 */     if (!isModifierProjet()) {
/* 2279 */       if (JOptionPane.showConfirmDialog(this, "Voulez vous fermer JMerise ?", "Fermeture de JMerise", 0) == 0) {
/* 2280 */         if (!Parametres.checkDate(new Date())) {
/* 2281 */           JOptionPane.showMessageDialog(this, "Erreur N°=> D6, Une Anomalie est détectée au niveau de la synchronisation !\nVos paramétres ne seront pas pris en compte ");
/*      */         } else {
/* 2283 */           if (!DeskParamatres.saveParametreDESK(this, getCheminParametre())) {
/* 2284 */             JOptionPane.showMessageDialog(this, "ERREUR : Problème N°SaveConfig 1.0. sauvegarde du fichier parametre !! \n" + getCheminFichier() + "\nSi l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/*      */           }
/* 2286 */           if (ThaOutils.verifierFermetureLicence2(Setting.licence)) {
/* 2287 */             if (!ThaOutils.saveLicence2(Setting.licence, getCheminLicence())) {
/* 2288 */               JOptionPane.showMessageDialog(this, "Erreur N° D07, Une erreur est détectée lors de la fermeture de JMerise !");
/*      */             }
/*      */           } else {
/* 2291 */             JOptionPane.showMessageDialog(this, "Erreur N°=> D08, Une erreur est détectée lors de la fermeture de JMerise !");
/*      */           }
/*      */         }
/* 2294 */         setDefaultCloseOperation(3);
/* 2295 */         dispose();
/*      */       }
/*      */     } else {
/* 2298 */       if (!Parametres.checkDate(new Date())) {
/* 2299 */         JOptionPane.showMessageDialog(this, "Erreur N°=> D6, Une Anomalie est détectée au niveau de la synchronisation !\nVos paramétres ne seront pas pris en compte ");
/*      */       }
/*      */       else {
/* 2302 */         if (!DeskParamatres.saveParametreDESK(this, getCheminParametre())) {
/* 2303 */           JOptionPane.showMessageDialog(this, "ERREUR : Problème N°SaveConfig 1.0. sauvegarde du fichier parametre !! \n" + getCheminFichier() + "\nSi l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/*      */         }
/* 2305 */         if (ThaOutils.verifierFermetureLicence2(Setting.licence)) {
/* 2306 */           if (!ThaOutils.saveLicence2(Setting.licence, getCheminLicence())) {
/* 2307 */             JOptionPane.showMessageDialog(this, "Erreur N° D07, Une erreur est détectée lors de la fermeture de JMerise !");
/*      */           }
/*      */         } else {
/* 2310 */           JOptionPane.showMessageDialog(this, "Erreur N°=> D08, Une erreur est détectée lors de la fermeture de JMerise !");
/*      */         }
/*      */       }
/*      */       
/* 2314 */       while (this.listeProjet.size() > 1) {
/* 2315 */         if (!((IhmProjet)this.listeProjet.get(0)).getFormeMCD().fermerMCDSansConfirmation()) {
/* 2316 */           stop = true;
/*      */         }
/*      */       }
/*      */       
/* 2320 */       if ((!stop) && 
/* 2321 */         (((IhmProjet)this.listeProjet.get(0)).getFormeMCD().fermerMCDSansConfirmation())) {
/* 2322 */         setDefaultCloseOperation(3);
/* 2323 */         dispose();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void fermerToutMCD()
/*      */   {
/* 2331 */     while (this.listeProjet.size() > 1) {
/* 2332 */       if (!((IhmProjet)this.listeProjet.get(0)).getFormeMCD().fermerMCDSansConfirmation()) {
/* 2333 */         return;
/*      */       }
/*      */     }
/* 2336 */     ((IhmProjet)this.listeProjet.get(0)).getFormeMCD().fermerMCDSansConfirmation();
/*      */   }
/*      */   
/*      */   public ArrayList<IhmProjet> getListeProjet() {
/* 2340 */     return this.listeProjet;
/*      */   }
/*      */   
/*      */   private boolean verificationMLD()
/*      */   {
/* 2345 */     String rep = verificationAdaptation.VerificationMLD.verifierMLD(getFormeMLD().getPageMld(), getFormeMCD().getPage().getListeDomaine());
/* 2346 */     if (rep.length() > 0) {
/* 2347 */       getConsole().getRapport().setBackground(Color.WHITE);
/* 2348 */       getConsole().getRapport().setText("ERREUR : Le MLD contient des erreurs");
/* 2349 */       getConsole().getRapport().append(rep);
/* 2350 */       JOptionPane.showConfirmDialog(this, "Erreur : Le MLD contient certaines erreurs !!! \nVoir messages dans console !", "Vérification du MCD ", -1, 0);
/* 2351 */       return false;
/*      */     }
/* 2353 */     getConsole().getRapport().setText("");
/* 2354 */     return true;
/*      */   }
/*      */   
/*      */   private JMenu jMenu17;
/*      */   private JMenu jMenu2;
/*      */   private JMenu jMenu3;
/*      */   private JMenu jMenu4;
/*      */   private JMenu jMenu5;
/*      */   private JMenu jMenu6;
/*      */   private JMenu jMenu7;
/*      */   private JMenu jMenu8;
/*      */   private JMenu jMenu9;
/*      */   
/*      */   private void initComponents() {
/* 2368 */     this.buttonGroup1 = new ButtonGroup();
/* 2369 */     this.buttonGroup2 = new ButtonGroup();
/* 2370 */     this.groupeSQL = new ButtonGroup();
/* 2371 */     this.groupeXML = new ButtonGroup();
/* 2372 */     this.jMenuBar1 = new JMenuBar();
/* 2373 */     this.MIQuitterJMerise = new JMenu();
/* 2374 */     this.jMINouveau = new JMenuItem();
/* 2375 */     this.jMIouvrir = new JMenuItem();
/* 2376 */     this.jFicRecent = new JMenu();
/* 2377 */     this.jSeparator1 = new JPopupMenu.Separator();
/* 2378 */     this.jMIEnregistrer = new JMenuItem();
/* 2379 */     this.jMIEnregistrerSous = new JMenuItem();
/* 2380 */     this.jMenu15 = new JMenu();
/* 2381 */     this.jMenuItem40 = new JMenuItem();
/* 2382 */     this.jMenuItem41 = new JMenuItem();
/* 2383 */     this.jSeparator2 = new JPopupMenu.Separator();
/* 2384 */     this.jMenuLibrairie = new JMenu();
/* 2385 */     this.jMINouvelleLibrairie = new JMenuItem();
/* 2386 */     this.jMIRafraichirLibrairie = new JMenuItem();
/* 2387 */     this.jMISupprimerLibrairie = new JMenuItem();
/* 2388 */     this.jSeparator22 = new JPopupMenu.Separator();
/* 2389 */     this.jMIImporterAnalyseSI = new JMenuItem();
/* 2390 */     this.jSeparator20 = new JPopupMenu.Separator();
/* 2391 */     this.jMIImprimer = new JMenuItem();
/* 2392 */     this.jMIExportImage = new JMenuItem();
/* 2393 */     this.jSeparator10 = new JPopupMenu.Separator();
/* 2394 */     this.jMIQuiter = new JMenuItem();
/* 2395 */     this.jMenu2 = new JMenu();
/* 2396 */     this.jMenuItem1 = new JMenuItem();
/* 2397 */     this.jSeparator8 = new JPopupMenu.Separator();
/* 2398 */     this.jMICopier = new JMenuItem();
/* 2399 */     this.jMIColler = new JMenuItem();
/* 2400 */     this.jMISupprimer = new JMenuItem();
/* 2401 */     this.jSeparator13 = new JPopupMenu.Separator();
/* 2402 */     this.jMenu8 = new JMenu();
/* 2403 */     this.jMenuItem10 = new JMenuItem();
/* 2404 */     this.jMenuItem11 = new JMenuItem();
/* 2405 */     this.jMenuItem12 = new JMenuItem();
/* 2406 */     this.jMenuItem13 = new JMenuItem();
/* 2407 */     this.jMenu9 = new JMenu();
/* 2408 */     this.jMenuItem14 = new JMenuItem();
/* 2409 */     this.jMenuItem15 = new JMenuItem();
/* 2410 */     this.jSeparator6 = new JPopupMenu.Separator();
/* 2411 */     this.jMIChercher = new JMenuItem();
/* 2412 */     this.jMIRemplacer = new JMenuItem();
/* 2413 */     this.jMenu3 = new JMenu();
/* 2414 */     this.jMIEntite = new JMenuItem();
/* 2415 */     this.jMIRelation = new JMenuItem();
/* 2416 */     this.jMILien = new JMenuItem();
/* 2417 */     this.jSeparator5 = new JPopupMenu.Separator();
/* 2418 */     this.jMITransformer = new JMenuItem();
/* 2419 */     this.jMenuItem55 = new JMenuItem();
/* 2420 */     this.jSeparator19 = new JPopupMenu.Separator();
/* 2421 */     this.jMIDictionnaire = new JMenuItem();
/* 2422 */     this.jMenuItem42 = new JMenuItem();
/* 2423 */     this.jMenuItem48 = new JMenuItem();
/* 2424 */     this.jSeparator16 = new JPopupMenu.Separator();
/* 2425 */     this.jMIDomaine = new JMenuItem();
/* 2426 */     this.jMenuItem43 = new JMenuItem();
/* 2427 */     this.jMenuItem49 = new JMenuItem();
/* 2428 */     this.jSeparator4 = new JPopupMenu.Separator();
/* 2429 */     this.jMenuItem39 = new JMenuItem();
/* 2430 */     this.jMenuItem45 = new JMenuItem();
/* 2431 */     this.jMenuItem7 = new JMenuItem();
/* 2432 */     this.jSeparator23 = new JPopupMenu.Separator();
/* 2433 */     this.jMIVerifier = new JMenuItem();
/* 2434 */     this.jMIGenerer = new JMenuItem();
/* 2435 */     this.jMenu4 = new JMenu();
/* 2436 */     this.jMenu17 = new JMenu();
/* 2437 */     this.jMICouleurDegradee = new JCheckBoxMenuItem();
/* 2438 */     this.jMIOmbre = new JCheckBoxMenuItem();
/* 2439 */     this.jMIActiverLien = new JCheckBoxMenuItem();
/* 2440 */     this.jMIVariable = new JCheckBoxMenuItem();
/* 2441 */     this.jMIArrondirEntite = new JCheckBoxMenuItem();
/* 2442 */     this.jSeparator3 = new JPopupMenu.Separator();
/* 2443 */     this.jMenu6 = new JMenu();
/* 2444 */     this.jRBFeelSystem = new JRadioButtonMenuItem();
/* 2445 */     this.jRBFeelNimbus = new JRadioButtonMenuItem();
/* 2446 */     this.jRBFeelJava = new JRadioButtonMenuItem();
/* 2447 */     this.jSeparator12 = new JPopupMenu.Separator();
/* 2448 */     this.jCBMenuLoupe = new JCheckBoxMenuItem();
/* 2449 */     this.jMIExplorer = new JCheckBoxMenuItem();
/* 2450 */     this.jMIConsole = new JCheckBoxMenuItem();
/* 2451 */     this.jMILibrairie = new JCheckBoxMenuItem();
/* 2452 */     this.jSeparator7 = new JPopupMenu.Separator();
/* 2453 */     this.jMenuItem38 = new JMenuItem();
/* 2454 */     this.jMenu1 = new JMenu();
/* 2455 */     this.jMITransformationRelation = new JMenuItem();
/* 2456 */     this.jMITransformationHeritage = new JMenuItem();
/* 2457 */     this.jSeparator24 = new JPopupMenu.Separator();
/* 2458 */     this.jMenuItem25 = new JMenuItem();
/* 2459 */     this.jMenu11 = new JMenu();
/* 2460 */     this.jMenu12 = new JMenu();
/* 2461 */     this.jMenuItem17 = new JMenuItem();
/* 2462 */     this.jMenuItem20 = new JMenuItem();
/* 2463 */     this.jMenuItem21 = new JMenuItem();
/* 2464 */     this.jMenuItem28 = new JMenuItem();
/* 2465 */     this.jMenuItem29 = new JMenuItem();
/* 2466 */     this.jMenuItem37 = new JMenuItem();
/* 2467 */     this.jMenuItem32 = new JMenuItem();
/* 2468 */     this.jMenuItem33 = new JMenuItem();
/* 2469 */     this.jMenuItem36 = new JMenuItem();
/* 2470 */     this.jMenu13 = new JMenu();
/* 2471 */     this.jMenuItem18 = new JMenuItem();
/* 2472 */     this.jMenuItem22 = new JMenuItem();
/* 2473 */     this.jMenu14 = new JMenu();
/* 2474 */     this.jMenuItem24 = new JMenuItem();
/* 2475 */     this.jMenuItem23 = new JMenuItem();
/* 2476 */     this.jSeparator17 = new JPopupMenu.Separator();
/* 2477 */     this.jMenuItem8 = new JMenuItem();
/* 2478 */     this.jMenuItem9 = new JMenuItem();
/* 2479 */     this.jMenu10 = new JMenu();
/* 2480 */     this.jMenuItem26 = new JMenuItem();
/* 2481 */     this.jMenuItem34 = new JMenuItem();
/* 2482 */     this.jSeparator14 = new JPopupMenu.Separator();
/* 2483 */     this.jMenu16 = new JMenu();
/* 2484 */     this.jMenuItem31 = new JMenuItem();
/* 2485 */     this.jMenuItem30 = new JMenuItem();
/* 2486 */     this.jSeparator15 = new JPopupMenu.Separator();
/* 2487 */     this.jMenuItem16 = new JMenuItem();
/* 2488 */     this.jMenuItem27 = new JMenuItem();
/* 2489 */     this.jMenu7 = new JMenu();
/* 2490 */     this.jMenuItem2 = new JMenuItem();
/* 2491 */     this.jMenuItem3 = new JMenuItem();
/* 2492 */     this.jMenuItem4 = new JMenuItem();
/* 2493 */     this.jMenuItem19 = new JMenuItem();
/* 2494 */     this.jMenuItem35 = new JMenuItem();
/* 2495 */     this.jSeparator9 = new JPopupMenu.Separator();
/* 2496 */     this.jMenuItem5 = new JMenuItem();
/* 2497 */     this.jMenu5 = new JMenu();
/* 2498 */     this.jMenuItem50 = new JMenuItem();
/* 2499 */     this.jMenuItem6 = new JMenuItem();
/* 2500 */     this.jMIVersion = new JMenuItem();
/* 2501 */     this.jSeparator11 = new JPopupMenu.Separator();
/* 2502 */     this.jMenuItem44 = new JMenuItem();
/* 2503 */     this.jMenuItem46 = new JMenuItem();
/* 2504 */     this.jSeparator21 = new JPopupMenu.Separator();
/* 2505 */     this.jMIFaireDon = new JMenuItem();
/*      */     
/* 2507 */     setDefaultCloseOperation(0);
/* 2508 */     setTitle("JMerise");
/* 2509 */     setCursor(new Cursor(0));
/* 2510 */     addMouseListener(new MouseAdapter() {
/*      */       public void mouseExited(MouseEvent evt) {
/* 2512 */         Principale.this.formMouseExited(evt);
/*      */       }
/* 2514 */     });
/* 2515 */     addWindowListener(new java.awt.event.WindowAdapter() {
/*      */       public void windowActivated(WindowEvent evt) {
/* 2517 */         Principale.this.formWindowActivated(evt);
/*      */       }
/*      */       
/* 2520 */       public void windowClosing(WindowEvent evt) { Principale.this.formWindowClosing(evt);
/*      */       }
/* 2522 */     });
/* 2523 */     addFocusListener(new java.awt.event.FocusAdapter() {
/*      */       public void focusLost(FocusEvent evt) {
/* 2525 */         Principale.this.formFocusLost(evt);
/*      */       }
/* 2527 */     });
/* 2528 */     addKeyListener(new java.awt.event.KeyAdapter() {
/*      */       public void keyPressed(KeyEvent evt) {
/* 2530 */         Principale.this.formKeyPressed(evt);
/*      */       }
/*      */       
/* 2533 */     });
/* 2534 */     this.jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(0));
/* 2535 */     this.jMenuBar1.setForeground(new Color(204, 204, 204));
/*      */     
/* 2537 */     this.MIQuitterJMerise.setText("Fichier");
/* 2538 */     this.MIQuitterJMerise.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2540 */         Principale.this.MIQuitterJMeriseActionPerformed(evt);
/*      */       }
/*      */       
/* 2543 */     });
/* 2544 */     this.jMINouveau.setAccelerator(KeyStroke.getKeyStroke(78, 2));
/* 2545 */     this.jMINouveau.setIcon(new ImageIcon(getClass().getResource("/Images/new.png")));
/* 2546 */     this.jMINouveau.setText("Nouveau");
/* 2547 */     this.jMINouveau.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2549 */         Principale.this.jMINouveauActionPerformed(evt);
/*      */       }
/* 2551 */     });
/* 2552 */     this.MIQuitterJMerise.add(this.jMINouveau);
/*      */     
/* 2554 */     this.jMIouvrir.setAccelerator(KeyStroke.getKeyStroke(79, 2));
/* 2555 */     this.jMIouvrir.setIcon(new ImageIcon(getClass().getResource("/Images/open.png")));
/* 2556 */     this.jMIouvrir.setText("Ouvrir");
/* 2557 */     this.jMIouvrir.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2559 */         Principale.this.jMIouvrirActionPerformed(evt);
/*      */       }
/* 2561 */     });
/* 2562 */     this.MIQuitterJMerise.add(this.jMIouvrir);
/*      */     
/* 2564 */     this.jFicRecent.setIcon(new ImageIcon(getClass().getResource("/Images/open.png")));
/* 2565 */     this.jFicRecent.setText("MCD ouvert récemment");
/* 2566 */     this.MIQuitterJMerise.add(this.jFicRecent);
/* 2567 */     this.MIQuitterJMerise.add(this.jSeparator1);
/*      */     
/* 2569 */     this.jMIEnregistrer.setAccelerator(KeyStroke.getKeyStroke(83, 2));
/* 2570 */     this.jMIEnregistrer.setIcon(new ImageIcon(getClass().getResource("/Images/save.png")));
/* 2571 */     this.jMIEnregistrer.setText("Enregistrer");
/* 2572 */     this.jMIEnregistrer.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2574 */         Principale.this.jMIEnregistrerActionPerformed(evt);
/*      */       }
/* 2576 */     });
/* 2577 */     this.MIQuitterJMerise.add(this.jMIEnregistrer);
/*      */     
/* 2579 */     this.jMIEnregistrerSous.setAccelerator(KeyStroke.getKeyStroke(83, 10));
/* 2580 */     this.jMIEnregistrerSous.setIcon(new ImageIcon(getClass().getResource("/Images/saveas.png")));
/* 2581 */     this.jMIEnregistrerSous.setText("Enregistrer sous ");
/* 2582 */     this.jMIEnregistrerSous.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2584 */         Principale.this.jMIEnregistrerSousActionPerformed(evt);
/*      */       }
/* 2586 */     });
/* 2587 */     this.MIQuitterJMerise.add(this.jMIEnregistrerSous);
/*      */     
/* 2589 */     this.jMenu15.setIcon(new ImageIcon(getClass().getResource("/Images/fermer.png")));
/* 2590 */     this.jMenu15.setText("Fermer");
/*      */     
/* 2592 */     this.jMenuItem40.setAccelerator(KeyStroke.getKeyStroke(88, 2));
/* 2593 */     this.jMenuItem40.setIcon(new ImageIcon(getClass().getResource("/Images/fermer.png")));
/* 2594 */     this.jMenuItem40.setText("Fermer MCD");
/* 2595 */     this.jMenuItem40.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2597 */         Principale.this.jMenuItem40ActionPerformed(evt);
/*      */       }
/* 2599 */     });
/* 2600 */     this.jMenu15.add(this.jMenuItem40);
/*      */     
/* 2602 */     this.jMenuItem41.setAccelerator(KeyStroke.getKeyStroke(88, 10));
/* 2603 */     this.jMenuItem41.setIcon(new ImageIcon(getClass().getResource("/Images/fermerTout.png")));
/* 2604 */     this.jMenuItem41.setText("Fermer Tous les MCD");
/* 2605 */     this.jMenuItem41.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2607 */         Principale.this.jMenuItem41ActionPerformed(evt);
/*      */       }
/* 2609 */     });
/* 2610 */     this.jMenu15.add(this.jMenuItem41);
/*      */     
/* 2612 */     this.MIQuitterJMerise.add(this.jMenu15);
/* 2613 */     this.MIQuitterJMerise.add(this.jSeparator2);
/*      */     
/* 2615 */     this.jMenuLibrairie.setIcon(new ImageIcon(getClass().getResource("/Images/Librairie.png")));
/* 2616 */     this.jMenuLibrairie.setText("Librairies");
/*      */     
/* 2618 */     this.jMINouvelleLibrairie.setIcon(new ImageIcon(getClass().getResource("/Images/new.gif")));
/* 2619 */     this.jMINouvelleLibrairie.setText("Nouvelle librairie");
/* 2620 */     this.jMINouvelleLibrairie.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2622 */         Principale.this.jMINouvelleLibrairieActionPerformed(evt);
/*      */       }
/* 2624 */     });
/* 2625 */     this.jMenuLibrairie.add(this.jMINouvelleLibrairie);
/*      */     
/* 2627 */     this.jMIRafraichirLibrairie.setAccelerator(KeyStroke.getKeyStroke(116, 0));
/* 2628 */     this.jMIRafraichirLibrairie.setIcon(new ImageIcon(getClass().getResource("/Images/refresh_mini.png")));
/* 2629 */     this.jMIRafraichirLibrairie.setText("Rafraîchir");
/* 2630 */     this.jMIRafraichirLibrairie.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2632 */         Principale.this.jMIRafraichirLibrairieActionPerformed(evt);
/*      */       }
/* 2634 */     });
/* 2635 */     this.jMenuLibrairie.add(this.jMIRafraichirLibrairie);
/*      */     
/* 2637 */     this.jMISupprimerLibrairie.setIcon(new ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 2638 */     this.jMISupprimerLibrairie.setText("Supprimer");
/* 2639 */     this.jMISupprimerLibrairie.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2641 */         Principale.this.jMISupprimerLibrairieActionPerformed(evt);
/*      */       }
/* 2643 */     });
/* 2644 */     this.jMenuLibrairie.add(this.jMISupprimerLibrairie);
/*      */     
/* 2646 */     this.MIQuitterJMerise.add(this.jMenuLibrairie);
/* 2647 */     this.MIQuitterJMerise.add(this.jSeparator22);
/*      */     
/* 2649 */     this.jMIImporterAnalyseSI.setAccelerator(KeyStroke.getKeyStroke(73, 2));
/* 2650 */     this.jMIImporterAnalyseSI.setIcon(new ImageIcon(getClass().getResource("/Images/analysesi.png")));
/* 2651 */     this.jMIImporterAnalyseSI.setText("Importer .asi");
/* 2652 */     this.jMIImporterAnalyseSI.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2654 */         Principale.this.jMIImporterAnalyseSIActionPerformed(evt);
/*      */       }
/* 2656 */     });
/* 2657 */     this.MIQuitterJMerise.add(this.jMIImporterAnalyseSI);
/* 2658 */     this.MIQuitterJMerise.add(this.jSeparator20);
/*      */     
/* 2660 */     this.jMIImprimer.setAccelerator(KeyStroke.getKeyStroke(80, 10));
/* 2661 */     this.jMIImprimer.setIcon(new ImageIcon(getClass().getResource("/Images/print.png")));
/* 2662 */     this.jMIImprimer.setText("Imprimer");
/* 2663 */     this.jMIImprimer.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2665 */         Principale.this.jMIImprimerActionPerformed(evt);
/*      */       }
/* 2667 */     });
/* 2668 */     this.MIQuitterJMerise.add(this.jMIImprimer);
/*      */     
/* 2670 */     this.jMIExportImage.setAccelerator(KeyStroke.getKeyStroke(69, 2));
/* 2671 */     this.jMIExportImage.setIcon(new ImageIcon(getClass().getResource("/Images/image_export.PNG")));
/* 2672 */     this.jMIExportImage.setText("Exporter sous forme jpg");
/* 2673 */     this.jMIExportImage.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2675 */         Principale.this.jMIExportImageActionPerformed(evt);
/*      */       }
/* 2677 */     });
/* 2678 */     this.MIQuitterJMerise.add(this.jMIExportImage);
/* 2679 */     this.MIQuitterJMerise.add(this.jSeparator10);
/*      */     
/* 2681 */     this.jMIQuiter.setAccelerator(KeyStroke.getKeyStroke(81, 2));
/* 2682 */     this.jMIQuiter.setIcon(new ImageIcon(getClass().getResource("/Images/quit.png")));
/* 2683 */     this.jMIQuiter.setText("Quitter JMerise");
/* 2684 */     this.jMIQuiter.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2686 */         Principale.this.jMIQuiterActionPerformed(evt);
/*      */       }
/* 2688 */     });
/* 2689 */     this.MIQuitterJMerise.add(this.jMIQuiter);
/*      */     
/* 2691 */     this.jMenuBar1.add(this.MIQuitterJMerise);
/*      */     
/* 2693 */     this.jMenu2.setText("Edition");
/*      */     
/* 2695 */     this.jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(80, 2));
/* 2696 */     this.jMenuItem1.setIcon(new ImageIcon(getClass().getResource("/Images/options.png")));
/* 2697 */     this.jMenuItem1.setText("Propriété");
/* 2698 */     this.jMenuItem1.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2700 */         Principale.this.jMenuItem1ActionPerformed(evt);
/*      */       }
/* 2702 */     });
/* 2703 */     this.jMenu2.add(this.jMenuItem1);
/* 2704 */     this.jMenu2.add(this.jSeparator8);
/*      */     
/* 2706 */     this.jMICopier.setAccelerator(KeyStroke.getKeyStroke(67, 2));
/* 2707 */     this.jMICopier.setIcon(new ImageIcon(getClass().getResource("/Images/copy.png")));
/* 2708 */     this.jMICopier.setText("Copier ");
/* 2709 */     this.jMICopier.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2711 */         Principale.this.jMICopierActionPerformed(evt);
/*      */       }
/* 2713 */     });
/* 2714 */     this.jMenu2.add(this.jMICopier);
/*      */     
/* 2716 */     this.jMIColler.setAccelerator(KeyStroke.getKeyStroke(86, 2));
/* 2717 */     this.jMIColler.setIcon(new ImageIcon(getClass().getResource("/Images/paste.png")));
/* 2718 */     this.jMIColler.setText("Coller");
/* 2719 */     this.jMIColler.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2721 */         Principale.this.jMICollerActionPerformed(evt);
/*      */       }
/* 2723 */     });
/* 2724 */     this.jMenu2.add(this.jMIColler);
/*      */     
/* 2726 */     this.jMISupprimer.setAccelerator(KeyStroke.getKeyStroke(127, 0));
/* 2727 */     this.jMISupprimer.setIcon(new ImageIcon(getClass().getResource("/Images/delete.png")));
/* 2728 */     this.jMISupprimer.setText("Supprimer ");
/* 2729 */     this.jMISupprimer.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2731 */         Principale.this.jMISupprimerActionPerformed(evt);
/*      */       }
/* 2733 */     });
/* 2734 */     this.jMenu2.add(this.jMISupprimer);
/* 2735 */     this.jMenu2.add(this.jSeparator13);
/*      */     
/* 2737 */     this.jMenu8.setIcon(new ImageIcon(getClass().getResource("/Images/aligner.png")));
/* 2738 */     this.jMenu8.setText("Aligner");
/*      */     
/* 2740 */     this.jMenuItem10.setAccelerator(KeyStroke.getKeyStroke(82, 1));
/* 2741 */     this.jMenuItem10.setIcon(new ImageIcon(getClass().getResource("/Images/right.png")));
/* 2742 */     this.jMenuItem10.setText("Droite");
/* 2743 */     this.jMenuItem10.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2745 */         Principale.this.jMenuItem10ActionPerformed(evt);
/*      */       }
/* 2747 */     });
/* 2748 */     this.jMenu8.add(this.jMenuItem10);
/*      */     
/* 2750 */     this.jMenuItem11.setAccelerator(KeyStroke.getKeyStroke(76, 1));
/* 2751 */     this.jMenuItem11.setIcon(new ImageIcon(getClass().getResource("/Images/left.png")));
/* 2752 */     this.jMenuItem11.setText("Gauche");
/* 2753 */     this.jMenuItem11.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2755 */         Principale.this.jMenuItem11ActionPerformed(evt);
/*      */       }
/* 2757 */     });
/* 2758 */     this.jMenu8.add(this.jMenuItem11);
/*      */     
/* 2760 */     this.jMenuItem12.setAccelerator(KeyStroke.getKeyStroke(84, 1));
/* 2761 */     this.jMenuItem12.setIcon(new ImageIcon(getClass().getResource("/Images/top.png")));
/* 2762 */     this.jMenuItem12.setText("Haut");
/* 2763 */     this.jMenuItem12.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2765 */         Principale.this.jMenuItem12ActionPerformed(evt);
/*      */       }
/* 2767 */     });
/* 2768 */     this.jMenu8.add(this.jMenuItem12);
/*      */     
/* 2770 */     this.jMenuItem13.setAccelerator(KeyStroke.getKeyStroke(66, 1));
/* 2771 */     this.jMenuItem13.setIcon(new ImageIcon(getClass().getResource("/Images/enbas.png")));
/* 2772 */     this.jMenuItem13.setText("Bas");
/* 2773 */     this.jMenuItem13.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2775 */         Principale.this.jMenuItem13ActionPerformed(evt);
/*      */       }
/* 2777 */     });
/* 2778 */     this.jMenu8.add(this.jMenuItem13);
/*      */     
/* 2780 */     this.jMenu2.add(this.jMenu8);
/*      */     
/* 2782 */     this.jMenu9.setIcon(new ImageIcon(getClass().getResource("/Images/zoom+16.png")));
/* 2783 */     this.jMenu9.setText("Zoom");
/*      */     
/* 2785 */     this.jMenuItem14.setAccelerator(KeyStroke.getKeyStroke(107, 2));
/* 2786 */     this.jMenuItem14.setIcon(new ImageIcon(getClass().getResource("/Images/zoom+16.png")));
/* 2787 */     this.jMenuItem14.setText("Zoom +");
/* 2788 */     this.jMenuItem14.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2790 */         Principale.this.jMenuItem14ActionPerformed(evt);
/*      */       }
/* 2792 */     });
/* 2793 */     this.jMenu9.add(this.jMenuItem14);
/*      */     
/* 2795 */     this.jMenuItem15.setAccelerator(KeyStroke.getKeyStroke(45, 2));
/* 2796 */     this.jMenuItem15.setIcon(new ImageIcon(getClass().getResource("/Images/zoom-16.png")));
/* 2797 */     this.jMenuItem15.setText("Zoom -");
/* 2798 */     this.jMenuItem15.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2800 */         Principale.this.jMenuItem15ActionPerformed(evt);
/*      */       }
/* 2802 */     });
/* 2803 */     this.jMenu9.add(this.jMenuItem15);
/*      */     
/* 2805 */     this.jMenu2.add(this.jMenu9);
/* 2806 */     this.jMenu2.add(this.jSeparator6);
/*      */     
/* 2808 */     this.jMIChercher.setAccelerator(KeyStroke.getKeyStroke(70, 2));
/* 2809 */     this.jMIChercher.setIcon(new ImageIcon(getClass().getResource("/Images/recherche.gif")));
/* 2810 */     this.jMIChercher.setText("Chercher");
/* 2811 */     this.jMIChercher.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2813 */         Principale.this.jMIChercherActionPerformed(evt);
/*      */       }
/* 2815 */     });
/* 2816 */     this.jMenu2.add(this.jMIChercher);
/*      */     
/* 2818 */     this.jMIRemplacer.setAccelerator(KeyStroke.getKeyStroke(72, 2));
/* 2819 */     this.jMIRemplacer.setIcon(new ImageIcon(getClass().getResource("/Images/remplacer.png")));
/* 2820 */     this.jMIRemplacer.setText("Remplacer");
/* 2821 */     this.jMIRemplacer.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2823 */         Principale.this.jMIRemplacerActionPerformed(evt);
/*      */       }
/* 2825 */     });
/* 2826 */     this.jMenu2.add(this.jMIRemplacer);
/*      */     
/* 2828 */     this.jMenuBar1.add(this.jMenu2);
/*      */     
/* 2830 */     this.jMenu3.setText("Merise");
/*      */     
/* 2832 */     this.jMIEntite.setAccelerator(KeyStroke.getKeyStroke(69, 10));
/* 2833 */     this.jMIEntite.setIcon(new ImageIcon(getClass().getResource("/Images/entiteP.PNG")));
/* 2834 */     this.jMIEntite.setText("Nouvelle Entité");
/* 2835 */     this.jMIEntite.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2837 */         Principale.this.jMIEntiteActionPerformed(evt);
/*      */       }
/* 2839 */     });
/* 2840 */     this.jMenu3.add(this.jMIEntite);
/*      */     
/* 2842 */     this.jMIRelation.setAccelerator(KeyStroke.getKeyStroke(65, 10));
/* 2843 */     this.jMIRelation.setIcon(new ImageIcon(getClass().getResource("/Images/relationP.PNG")));
/* 2844 */     this.jMIRelation.setText("Nouvelle Relation ");
/* 2845 */     this.jMIRelation.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2847 */         Principale.this.jMIRelationActionPerformed(evt);
/*      */       }
/* 2849 */     });
/* 2850 */     this.jMenu3.add(this.jMIRelation);
/*      */     
/* 2852 */     this.jMILien.setAccelerator(KeyStroke.getKeyStroke(76, 10));
/* 2853 */     this.jMILien.setIcon(new ImageIcon(getClass().getResource("/Images/lienP.PNG")));
/* 2854 */     this.jMILien.setText("Nouveau Lien");
/* 2855 */     this.jMILien.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2857 */         Principale.this.jMILienActionPerformed(evt);
/*      */       }
/* 2859 */     });
/* 2860 */     this.jMenu3.add(this.jMILien);
/* 2861 */     this.jMenu3.add(this.jSeparator5);
/*      */     
/* 2863 */     this.jMITransformer.setAccelerator(KeyStroke.getKeyStroke(84, 10));
/* 2864 */     this.jMITransformer.setIcon(new ImageIcon(getClass().getResource("/Images/transformeRel.png")));
/* 2865 */     this.jMITransformer.setText("Transformer relation en entité");
/* 2866 */     this.jMITransformer.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2868 */         Principale.this.jMITransformerActionPerformed(evt);
/*      */       }
/* 2870 */     });
/* 2871 */     this.jMenu3.add(this.jMITransformer);
/*      */     
/* 2873 */     this.jMenuItem55.setAccelerator(KeyStroke.getKeyStroke(66, 10));
/* 2874 */     this.jMenuItem55.setIcon(new ImageIcon(getClass().getResource("/Images/ajoutEntiteLib.png")));
/* 2875 */     this.jMenuItem55.setText("Inserer entité ou relation dans la librairie");
/* 2876 */     this.jMenuItem55.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2878 */         Principale.this.jMenuItem55ActionPerformed(evt);
/*      */       }
/* 2880 */     });
/* 2881 */     this.jMenu3.add(this.jMenuItem55);
/* 2882 */     this.jMenu3.add(this.jSeparator19);
/*      */     
/* 2884 */     this.jMIDictionnaire.setAccelerator(KeyStroke.getKeyStroke(68, 2));
/* 2885 */     this.jMIDictionnaire.setIcon(new ImageIcon(getClass().getResource("/Images/dictionnaire2.PNG")));
/* 2886 */     this.jMIDictionnaire.setText("Dictionnaire de données");
/* 2887 */     this.jMIDictionnaire.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2889 */         Principale.this.jMIDictionnaireActionPerformed(evt);
/*      */       }
/* 2891 */     });
/* 2892 */     this.jMenu3.add(this.jMIDictionnaire);
/*      */     
/* 2894 */     this.jMenuItem42.setAccelerator(KeyStroke.getKeyStroke(68, 10));
/* 2895 */     this.jMenuItem42.setIcon(new ImageIcon(getClass().getResource("/Images/b_import.png")));
/* 2896 */     this.jMenuItem42.setText("Importer dictionnaire de données (MCD ouvert)");
/* 2897 */     this.jMenuItem42.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2899 */         Principale.this.jMenuItem42ActionPerformed(evt);
/*      */       }
/* 2901 */     });
/* 2902 */     this.jMenu3.add(this.jMenuItem42);
/*      */     
/* 2904 */     this.jMenuItem48.setAccelerator(KeyStroke.getKeyStroke(68, 3));
/* 2905 */     this.jMenuItem48.setIcon(new ImageIcon(getClass().getResource("/Images/di_export.png")));
/* 2906 */     this.jMenuItem48.setText("Exporter dictionnaire de données");
/* 2907 */     this.jMenuItem48.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2909 */         Principale.this.jMenuItem48ActionPerformed(evt);
/*      */       }
/* 2911 */     });
/* 2912 */     this.jMenu3.add(this.jMenuItem48);
/* 2913 */     this.jMenu3.add(this.jSeparator16);
/*      */     
/* 2915 */     this.jMIDomaine.setAccelerator(KeyStroke.getKeyStroke(77, 2));
/* 2916 */     this.jMIDomaine.setIcon(new ImageIcon(getClass().getResource("/Images/domaine.png")));
/* 2917 */     this.jMIDomaine.setText("Domaine");
/* 2918 */     this.jMIDomaine.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2920 */         Principale.this.jMIDomaineActionPerformed(evt);
/*      */       }
/* 2922 */     });
/* 2923 */     this.jMenu3.add(this.jMIDomaine);
/*      */     
/* 2925 */     this.jMenuItem43.setAccelerator(KeyStroke.getKeyStroke(77, 10));
/* 2926 */     this.jMenuItem43.setIcon(new ImageIcon(getClass().getResource("/Images/domaineImp.png")));
/* 2927 */     this.jMenuItem43.setText("Importer domaine (MCD ouvert)");
/* 2928 */     this.jMenuItem43.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2930 */         Principale.this.jMenuItem43ActionPerformed(evt);
/*      */       }
/* 2932 */     });
/* 2933 */     this.jMenu3.add(this.jMenuItem43);
/*      */     
/* 2935 */     this.jMenuItem49.setAccelerator(KeyStroke.getKeyStroke(77, 3));
/* 2936 */     this.jMenuItem49.setIcon(new ImageIcon(getClass().getResource("/Images/domaineExp.png")));
/* 2937 */     this.jMenuItem49.setText("Exporter la liste de domaines");
/* 2938 */     this.jMenuItem49.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2940 */         Principale.this.jMenuItem49ActionPerformed(evt);
/*      */       }
/* 2942 */     });
/* 2943 */     this.jMenu3.add(this.jMenuItem49);
/* 2944 */     this.jMenu3.add(this.jSeparator4);
/*      */     
/* 2946 */     this.jMenuItem39.setAccelerator(KeyStroke.getKeyStroke(73, 8));
/* 2947 */     this.jMenuItem39.setIcon(new ImageIcon(getClass().getResource("/Images/infoMCD.png")));
/* 2948 */     this.jMenuItem39.setText("Proprièté MCD");
/* 2949 */     this.jMenuItem39.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2951 */         Principale.this.jMenuItem39ActionPerformed(evt);
/*      */       }
/* 2953 */     });
/* 2954 */     this.jMenu3.add(this.jMenuItem39);
/*      */     
/* 2956 */     this.jMenuItem45.setAccelerator(KeyStroke.getKeyStroke(78, 8));
/* 2957 */     this.jMenuItem45.setIcon(new ImageIcon(getClass().getResource("/Images/noteMCD.png")));
/* 2958 */     this.jMenuItem45.setText("Notes / commentaires MCD");
/* 2959 */     this.jMenuItem45.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2961 */         Principale.this.jMenuItem45ActionPerformed(evt);
/*      */       }
/* 2963 */     });
/* 2964 */     this.jMenu3.add(this.jMenuItem45);
/*      */     
/* 2966 */     this.jMenuItem7.setText("Légende dans le MCD et le MLD");
/* 2967 */     this.jMenuItem7.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2969 */         Principale.this.jMenuItem7ActionPerformed(evt);
/*      */       }
/* 2971 */     });
/* 2972 */     this.jMenu3.add(this.jMenuItem7);
/* 2973 */     this.jMenu3.add(this.jSeparator23);
/*      */     
/* 2975 */     this.jMIVerifier.setAccelerator(KeyStroke.getKeyStroke(119, 0));
/* 2976 */     this.jMIVerifier.setIcon(new ImageIcon(getClass().getResource("/Images/verifierP.png")));
/* 2977 */     this.jMIVerifier.setText("Verifier le MCD");
/* 2978 */     this.jMIVerifier.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2980 */         Principale.this.jMIVerifierActionPerformed(evt);
/*      */       }
/* 2982 */     });
/* 2983 */     this.jMenu3.add(this.jMIVerifier);
/*      */     
/* 2985 */     this.jMIGenerer.setAccelerator(KeyStroke.getKeyStroke(120, 0));
/* 2986 */     this.jMIGenerer.setIcon(new ImageIcon(getClass().getResource("/Images/constructionMLDP.png")));
/* 2987 */     this.jMIGenerer.setText("Convertir le MCD");
/* 2988 */     this.jMIGenerer.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2990 */         Principale.this.jMIGenererActionPerformed(evt);
/*      */       }
/* 2992 */     });
/* 2993 */     this.jMenu3.add(this.jMIGenerer);
/*      */     
/* 2995 */     this.jMenuBar1.add(this.jMenu3);
/*      */     
/* 2997 */     this.jMenu4.setText("Paramètres & Configuration");
/* 2998 */     this.jMenu4.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3000 */         Principale.this.jMenu4ActionPerformed(evt);
/*      */       }
/*      */       
/* 3003 */     });
/* 3004 */     this.jMenu17.setIcon(new ImageIcon(getClass().getResource("/Images/colorie.png")));
/* 3005 */     this.jMenu17.setText("Couleurs");
/*      */     
/* 3007 */     this.jMICouleurDegradee.setAccelerator(KeyStroke.getKeyStroke(68, 10));
/* 3008 */     this.jMICouleurDegradee.setSelected(true);
/* 3009 */     this.jMICouleurDegradee.setText("Couleur dégradée");
/* 3010 */     this.jMICouleurDegradee.setIcon(new ImageIcon(getClass().getResource("/Images/couleurDegradee.png")));
/* 3011 */     this.jMICouleurDegradee.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3013 */         Principale.this.jMICouleurDegradeeActionPerformed(evt);
/*      */       }
/* 3015 */     });
/* 3016 */     this.jMenu17.add(this.jMICouleurDegradee);
/*      */     
/* 3018 */     this.jMIOmbre.setAccelerator(KeyStroke.getKeyStroke(79, 8));
/* 3019 */     this.jMIOmbre.setSelected(true);
/* 3020 */     this.jMIOmbre.setText("Ombres");
/* 3021 */     this.jMIOmbre.setIcon(new ImageIcon(getClass().getResource("/Images/Ombre.png")));
/* 3022 */     this.jMIOmbre.addMouseListener(new MouseAdapter() {
/*      */       public void mousePressed(MouseEvent evt) {
/* 3024 */         Principale.this.jMIOmbreMousePressed(evt);
/*      */       }
/* 3026 */     });
/* 3027 */     this.jMIOmbre.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3029 */         Principale.this.jMIOmbreActionPerformed(evt);
/*      */       }
/* 3031 */     });
/* 3032 */     this.jMenu17.add(this.jMIOmbre);
/*      */     
/* 3034 */     this.jMIActiverLien.setSelected(true);
/* 3035 */     this.jMIActiverLien.setText("Activer les liens à la séléction");
/* 3036 */     this.jMIActiverLien.setIcon(new ImageIcon(getClass().getResource("/Images/entiteActivee.png")));
/* 3037 */     this.jMIActiverLien.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3039 */         Principale.this.jMIActiverLienActionPerformed(evt);
/*      */       }
/* 3041 */     });
/* 3042 */     this.jMenu17.add(this.jMIActiverLien);
/*      */     
/* 3044 */     this.jMenu4.add(this.jMenu17);
/*      */     
/* 3046 */     this.jMIVariable.setAccelerator(KeyStroke.getKeyStroke(84, 8));
/* 3047 */     this.jMIVariable.setSelected(true);
/* 3048 */     this.jMIVariable.setText("Afficher type");
/* 3049 */     this.jMIVariable.setIcon(new ImageIcon(getClass().getResource("/Images/variable.png")));
/* 3050 */     this.jMIVariable.addMouseListener(new MouseAdapter() {
/*      */       public void mousePressed(MouseEvent evt) {
/* 3052 */         Principale.this.jMIVariableMousePressed(evt);
/*      */       }
/* 3054 */     });
/* 3055 */     this.jMIVariable.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3057 */         Principale.this.jMIVariableActionPerformed(evt);
/*      */       }
/* 3059 */     });
/* 3060 */     this.jMenu4.add(this.jMIVariable);
/*      */     
/* 3062 */     this.jMIArrondirEntite.setSelected(true);
/* 3063 */     this.jMIArrondirEntite.setText("Arrondir les angles des entités");
/* 3064 */     this.jMIArrondirEntite.setIcon(new ImageIcon(getClass().getResource("/Images/entiteArrondie.png")));
/* 3065 */     this.jMIArrondirEntite.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3067 */         Principale.this.jMIArrondirEntiteActionPerformed(evt);
/*      */       }
/* 3069 */     });
/* 3070 */     this.jMenu4.add(this.jMIArrondirEntite);
/* 3071 */     this.jMenu4.add(this.jSeparator3);
/*      */     
/* 3073 */     this.jMenu6.setIcon(new ImageIcon(getClass().getResource("/Images/fenetre.png")));
/* 3074 */     this.jMenu6.setText("Fenêtre ...  ");
/*      */     
/* 3076 */     this.buttonGroup1.add(this.jRBFeelSystem);
/* 3077 */     this.jRBFeelSystem.setText("Look & Feel votre systéme");
/* 3078 */     this.jRBFeelSystem.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3080 */         Principale.this.jRBFeelSystemActionPerformed(evt);
/*      */       }
/* 3082 */     });
/* 3083 */     this.jMenu6.add(this.jRBFeelSystem);
/*      */     
/* 3085 */     this.buttonGroup1.add(this.jRBFeelNimbus);
/* 3086 */     this.jRBFeelNimbus.setText("Nimbus");
/* 3087 */     this.jRBFeelNimbus.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3089 */         Principale.this.jRBFeelNimbusActionPerformed(evt);
/*      */       }
/* 3091 */     });
/* 3092 */     this.jMenu6.add(this.jRBFeelNimbus);
/*      */     
/* 3094 */     this.buttonGroup1.add(this.jRBFeelJava);
/* 3095 */     this.jRBFeelJava.setSelected(true);
/* 3096 */     this.jRBFeelJava.setText("Look & Feel Java");
/* 3097 */     this.jRBFeelJava.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3099 */         Principale.this.jRBFeelJavaActionPerformed(evt);
/*      */       }
/* 3101 */     });
/* 3102 */     this.jMenu6.add(this.jRBFeelJava);
/*      */     
/* 3104 */     this.jMenu4.add(this.jMenu6);
/* 3105 */     this.jMenu4.add(this.jSeparator12);
/*      */     
/* 3107 */     this.jCBMenuLoupe.setAccelerator(KeyStroke.getKeyStroke(79, 1));
/* 3108 */     this.jCBMenuLoupe.setSelected(true);
/* 3109 */     this.jCBMenuLoupe.setText("Outline");
/* 3110 */     this.jCBMenuLoupe.setIcon(new ImageIcon(getClass().getResource("/Images/outline.png")));
/* 3111 */     this.jCBMenuLoupe.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3113 */         Principale.this.jCBMenuLoupeActionPerformed(evt);
/*      */       }
/* 3115 */     });
/* 3116 */     this.jMenu4.add(this.jCBMenuLoupe);
/*      */     
/* 3118 */     this.jMIExplorer.setAccelerator(KeyStroke.getKeyStroke(88, 1));
/* 3119 */     this.jMIExplorer.setSelected(true);
/* 3120 */     this.jMIExplorer.setText("Explorer");
/* 3121 */     this.jMIExplorer.setIcon(new ImageIcon(getClass().getResource("/Images/explorer.png")));
/* 3122 */     this.jMIExplorer.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3124 */         Principale.this.jMIExplorerActionPerformed(evt);
/*      */       }
/* 3126 */     });
/* 3127 */     this.jMenu4.add(this.jMIExplorer);
/*      */     
/* 3129 */     this.jMIConsole.setAccelerator(KeyStroke.getKeyStroke(67, 1));
/* 3130 */     this.jMIConsole.setText("Console");
/* 3131 */     this.jMIConsole.setIcon(new ImageIcon(getClass().getResource("/Images/console.png")));
/* 3132 */     this.jMIConsole.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3134 */         Principale.this.jMIConsoleActionPerformed(evt);
/*      */       }
/* 3136 */     });
/* 3137 */     this.jMenu4.add(this.jMIConsole);
/*      */     
/* 3139 */     this.jMILibrairie.setSelected(true);
/* 3140 */     this.jMILibrairie.setText("Panel Librairie");
/* 3141 */     this.jMILibrairie.setIcon(new ImageIcon(getClass().getResource("/Images/biblio1.png")));
/* 3142 */     this.jMILibrairie.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3144 */         Principale.this.jMILibrairieActionPerformed(evt);
/*      */       }
/* 3146 */     });
/* 3147 */     this.jMenu4.add(this.jMILibrairie);
/* 3148 */     this.jMenu4.add(this.jSeparator7);
/*      */     
/* 3150 */     this.jMenuItem38.setAccelerator(KeyStroke.getKeyStroke(127, 2));
/* 3151 */     this.jMenuItem38.setText("Affacer le MLD et les scripts du MCD");
/* 3152 */     this.jMenuItem38.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3154 */         Principale.this.jMenuItem38ActionPerformed(evt);
/*      */       }
/* 3156 */     });
/* 3157 */     this.jMenu4.add(this.jMenuItem38);
/*      */     
/* 3159 */     this.jMenu1.setText("Paramètres de transformation ");
/*      */     
/* 3161 */     this.jMITransformationRelation.setText("Transformation des relations");
/* 3162 */     this.jMITransformationRelation.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3164 */         Principale.this.jMITransformationRelationActionPerformed(evt);
/*      */       }
/* 3166 */     });
/* 3167 */     this.jMenu1.add(this.jMITransformationRelation);
/*      */     
/* 3169 */     this.jMITransformationHeritage.setText("Transformation Héritage Entités");
/* 3170 */     this.jMITransformationHeritage.setEnabled(false);
/* 3171 */     this.jMenu1.add(this.jMITransformationHeritage);
/*      */     
/* 3173 */     this.jMenu4.add(this.jMenu1);
/* 3174 */     this.jMenu4.add(this.jSeparator24);
/*      */     
/* 3176 */     this.jMenuItem25.setAccelerator(KeyStroke.getKeyStroke(80, 9));
/* 3177 */     this.jMenuItem25.setIcon(new ImageIcon(getClass().getResource("/Images/parametre.png")));
/* 3178 */     this.jMenuItem25.setText("Configuration des paramètres");
/* 3179 */     this.jMenuItem25.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3181 */         Principale.this.jMenuItem25ActionPerformed(evt);
/*      */       }
/* 3183 */     });
/* 3184 */     this.jMenu4.add(this.jMenuItem25);
/*      */     
/* 3186 */     this.jMenuBar1.add(this.jMenu4);
/*      */     
/* 3188 */     this.jMenu11.setText("Scripts & BdD ");
/*      */     
/* 3190 */     this.jMenu12.setIcon(new ImageIcon(getClass().getResource("/Images/sql16.png")));
/* 3191 */     this.jMenu12.setText("Script SQL");
/*      */     
/* 3193 */     this.jMenuItem17.setIcon(new ImageIcon(getClass().getResource("/Images/mysql.png")));
/* 3194 */     this.jMenuItem17.setText("Mysql");
/* 3195 */     this.jMenuItem17.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3197 */         Principale.this.jMenuItem17ActionPerformed(evt);
/*      */       }
/* 3199 */     });
/* 3200 */     this.jMenu12.add(this.jMenuItem17);
/*      */     
/* 3202 */     this.jMenuItem20.setIcon(new ImageIcon(getClass().getResource("/Images/sqlite.png")));
/* 3203 */     this.jMenuItem20.setText("SQLite");
/* 3204 */     this.jMenuItem20.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3206 */         Principale.this.jMenuItem20ActionPerformed(evt);
/*      */       }
/* 3208 */     });
/* 3209 */     this.jMenu12.add(this.jMenuItem20);
/*      */     
/* 3211 */     this.jMenuItem21.setIcon(new ImageIcon(getClass().getResource("/Images/postgres.png")));
/* 3212 */     this.jMenuItem21.setText("PostgreSql");
/* 3213 */     this.jMenuItem21.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3215 */         Principale.this.jMenuItem21ActionPerformed(evt);
/*      */       }
/* 3217 */     });
/* 3218 */     this.jMenu12.add(this.jMenuItem21);
/*      */     
/* 3220 */     this.jMenuItem28.setIcon(new ImageIcon(getClass().getResource("/Images/derby.png")));
/* 3221 */     this.jMenuItem28.setText("Derby");
/* 3222 */     this.jMenuItem28.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3224 */         Principale.this.jMenuItem28ActionPerformed(evt);
/*      */       }
/* 3226 */     });
/* 3227 */     this.jMenu12.add(this.jMenuItem28);
/*      */     
/* 3229 */     this.jMenuItem29.setIcon(new ImageIcon(getClass().getResource("/Images/firbird.png")));
/* 3230 */     this.jMenuItem29.setText("Firebird");
/* 3231 */     this.jMenuItem29.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3233 */         Principale.this.jMenuItem29ActionPerformed(evt);
/*      */       }
/* 3235 */     });
/* 3236 */     this.jMenu12.add(this.jMenuItem29);
/*      */     
/* 3238 */     this.jMenuItem37.setIcon(new ImageIcon(getClass().getResource("/Images/accessSQL.png")));
/* 3239 */     this.jMenuItem37.setText("Access");
/* 3240 */     this.jMenuItem37.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3242 */         Principale.this.jMenuItem37ActionPerformed(evt);
/*      */       }
/* 3244 */     });
/* 3245 */     this.jMenu12.add(this.jMenuItem37);
/*      */     
/* 3247 */     this.jMenuItem32.setIcon(new ImageIcon(getClass().getResource("/Images/sqlServer.png")));
/* 3248 */     this.jMenuItem32.setText("Sql Server");
/* 3249 */     this.jMenuItem32.setActionCommand("SQLServer");
/* 3250 */     this.jMenuItem32.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3252 */         Principale.this.jMenuItem32ActionPerformed(evt);
/*      */       }
/* 3254 */     });
/* 3255 */     this.jMenu12.add(this.jMenuItem32);
/*      */     
/* 3257 */     this.jMenuItem33.setIcon(new ImageIcon(getClass().getResource("/Images/oracleSQL.png")));
/* 3258 */     this.jMenuItem33.setText("Oracle");
/* 3259 */     this.jMenuItem33.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3261 */         Principale.this.jMenuItem33ActionPerformed(evt);
/*      */       }
/* 3263 */     });
/* 3264 */     this.jMenu12.add(this.jMenuItem33);
/*      */     
/* 3266 */     this.jMenuItem36.setIcon(new ImageIcon(getClass().getResource("/Images/hsqlDB.png")));
/* 3267 */     this.jMenuItem36.setText("HSQLDB (OpenOffice Base)");
/* 3268 */     this.jMenuItem36.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3270 */         Principale.this.jMenuItem36ActionPerformed(evt);
/*      */       }
/* 3272 */     });
/* 3273 */     this.jMenu12.add(this.jMenuItem36);
/*      */     
/* 3275 */     this.jMenu11.add(this.jMenu12);
/*      */     
/* 3277 */     this.jMenu13.setIcon(new ImageIcon(getClass().getResource("/Images/xml.png")));
/* 3278 */     this.jMenu13.setText("XML");
/*      */     
/* 3280 */     this.jMenuItem18.setIcon(new ImageIcon(getClass().getResource("/Images/dtd.png")));
/* 3281 */     this.jMenuItem18.setText(".dtd du MCD");
/* 3282 */     this.jMenuItem18.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3284 */         Principale.this.jMenuItem18ActionPerformed(evt);
/*      */       }
/* 3286 */     });
/* 3287 */     this.jMenu13.add(this.jMenuItem18);
/*      */     
/* 3289 */     this.jMenuItem22.setIcon(new ImageIcon(getClass().getResource("/Images/xml.png")));
/* 3290 */     this.jMenuItem22.setText(".xml du travail");
/* 3291 */     this.jMenuItem22.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3293 */         Principale.this.jMenuItem22ActionPerformed(evt);
/*      */       }
/* 3295 */     });
/* 3296 */     this.jMenu13.add(this.jMenuItem22);
/*      */     
/* 3298 */     this.jMenu11.add(this.jMenu13);
/*      */     
/* 3300 */     this.jMenu14.setText("JSon");
/* 3301 */     this.jMenu14.setEnabled(false);
/*      */     
/* 3303 */     this.jMenuItem24.setText("MCD");
/* 3304 */     this.jMenu14.add(this.jMenuItem24);
/*      */     
/* 3306 */     this.jMenuItem23.setText("De Mon travail");
/* 3307 */     this.jMenu14.add(this.jMenuItem23);
/*      */     
/* 3309 */     this.jMenu11.add(this.jMenu14);
/* 3310 */     this.jMenu11.add(this.jSeparator17);
/*      */     
/* 3312 */     this.jMenuItem8.setAccelerator(KeyStroke.getKeyStroke(116, 0));
/* 3313 */     this.jMenuItem8.setIcon(new ImageIcon(getClass().getResource("/Images/db16.png")));
/* 3314 */     this.jMenuItem8.setText("Connexion à la base de données");
/* 3315 */     this.jMenuItem8.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3317 */         Principale.this.jMenuItem8ActionPerformed(evt);
/*      */       }
/* 3319 */     });
/* 3320 */     this.jMenu11.add(this.jMenuItem8);
/*      */     
/* 3322 */     this.jMenuItem9.setAccelerator(KeyStroke.getKeyStroke(117, 0));
/* 3323 */     this.jMenuItem9.setIcon(new ImageIcon(getClass().getResource("/Images/newTable16.png")));
/* 3324 */     this.jMenuItem9.setText("Exécuter le script SQL");
/* 3325 */     this.jMenuItem9.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3327 */         Principale.this.jMenuItem9ActionPerformed(evt);
/*      */       }
/* 3329 */     });
/* 3330 */     this.jMenu11.add(this.jMenuItem9);
/*      */     
/* 3332 */     this.jMenuBar1.add(this.jMenu11);
/*      */     
/* 3334 */     this.jMenu10.setText("Rétro-Conception");
/*      */     
/* 3336 */     this.jMenuItem26.setIcon(new ImageIcon(getClass().getResource("/Images/db16.png")));
/* 3337 */     this.jMenuItem26.setText("Connecter à une base de données ");
/* 3338 */     this.jMenuItem26.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3340 */         Principale.this.jMenuItem26ActionPerformed(evt);
/*      */       }
/* 3342 */     });
/* 3343 */     this.jMenu10.add(this.jMenuItem26);
/*      */     
/* 3345 */     this.jMenuItem34.setIcon(new ImageIcon(getClass().getResource("/Images/b_import.png")));
/* 3346 */     this.jMenuItem34.setText("Importer les tables");
/* 3347 */     this.jMenuItem34.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3349 */         Principale.this.jMenuItem34ActionPerformed(evt);
/*      */       }
/* 3351 */     });
/* 3352 */     this.jMenu10.add(this.jMenuItem34);
/* 3353 */     this.jMenu10.add(this.jSeparator14);
/*      */     
/* 3355 */     this.jMenu16.setIcon(new ImageIcon(getClass().getResource("/Images/constructionMCD.png")));
/* 3356 */     this.jMenu16.setText("Conception MCD");
/*      */     
/* 3358 */     this.jMenuItem31.setIcon(new ImageIcon(getClass().getResource("/Images/constructionPartielle.png")));
/* 3359 */     this.jMenuItem31.setText("Partielle");
/* 3360 */     this.jMenuItem31.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3362 */         Principale.this.jMenuItem31ActionPerformed(evt);
/*      */       }
/* 3364 */     });
/* 3365 */     this.jMenu16.add(this.jMenuItem31);
/*      */     
/* 3367 */     this.jMenuItem30.setIcon(new ImageIcon(getClass().getResource("/Images/constructionMCD.png")));
/* 3368 */     this.jMenuItem30.setText("Complete");
/* 3369 */     this.jMenuItem30.setEnabled(false);
/* 3370 */     this.jMenuItem30.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3372 */         Principale.this.jMenuItem30ActionPerformed(evt);
/*      */       }
/* 3374 */     });
/* 3375 */     this.jMenu16.add(this.jMenuItem30);
/*      */     
/* 3377 */     this.jMenu10.add(this.jMenu16);
/* 3378 */     this.jMenu10.add(this.jSeparator15);
/*      */     
/* 3380 */     this.jMenuItem16.setAccelerator(KeyStroke.getKeyStroke(82, 8));
/* 3381 */     this.jMenuItem16.setIcon(new ImageIcon(getClass().getResource("/Images/fenetre16.png")));
/* 3382 */     this.jMenuItem16.setText("Voir fenêtre");
/* 3383 */     this.jMenuItem16.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3385 */         Principale.this.jMenuItem16ActionPerformed(evt);
/*      */       }
/* 3387 */     });
/* 3388 */     this.jMenu10.add(this.jMenuItem16);
/*      */     
/* 3390 */     this.jMenuItem27.setIcon(new ImageIcon(getClass().getResource("/Images/colonneIndex16.png")));
/* 3391 */     this.jMenuItem27.setText("Légende");
/* 3392 */     this.jMenuItem27.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3394 */         Principale.this.jMenuItem27ActionPerformed(evt);
/*      */       }
/* 3396 */     });
/* 3397 */     this.jMenu10.add(this.jMenuItem27);
/*      */     
/* 3399 */     this.jMenuBar1.add(this.jMenu10);
/*      */     
/* 3401 */     this.jMenu7.setText("Fenêtre");
/*      */     
/* 3403 */     this.jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(68, 8));
/* 3404 */     this.jMenuItem2.setIcon(new ImageIcon(getClass().getResource("/Images/lienP.PNG")));
/* 3405 */     this.jMenuItem2.setText("Fenêtre MCD");
/* 3406 */     this.jMenuItem2.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3408 */         Principale.this.jMenuItem2ActionPerformed(evt);
/*      */       }
/* 3410 */     });
/* 3411 */     this.jMenu7.add(this.jMenuItem2);
/*      */     
/* 3413 */     this.jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(76, 8));
/* 3414 */     this.jMenuItem3.setIcon(new ImageIcon(getClass().getResource("/Images/mld16.png")));
/* 3415 */     this.jMenuItem3.setText("Fenêtre MLD");
/* 3416 */     this.jMenuItem3.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3418 */         Principale.this.jMenuItem3ActionPerformed(evt);
/*      */       }
/* 3420 */     });
/* 3421 */     this.jMenu7.add(this.jMenuItem3);
/*      */     
/* 3423 */     this.jMenuItem4.setAccelerator(KeyStroke.getKeyStroke(81, 8));
/* 3424 */     this.jMenuItem4.setIcon(new ImageIcon(getClass().getResource("/Images/sql16.png")));
/* 3425 */     this.jMenuItem4.setText("Fenêtre SQL");
/* 3426 */     this.jMenuItem4.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3428 */         Principale.this.jMenuItem4ActionPerformed(evt);
/*      */       }
/* 3430 */     });
/* 3431 */     this.jMenu7.add(this.jMenuItem4);
/*      */     
/* 3433 */     this.jMenuItem19.setAccelerator(KeyStroke.getKeyStroke(88, 8));
/* 3434 */     this.jMenuItem19.setIcon(new ImageIcon(getClass().getResource("/Images/xml.png")));
/* 3435 */     this.jMenuItem19.setText("Fenêtre XML");
/* 3436 */     this.jMenuItem19.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3438 */         Principale.this.jMenuItem19ActionPerformed(evt);
/*      */       }
/* 3440 */     });
/* 3441 */     this.jMenu7.add(this.jMenuItem19);
/*      */     
/* 3443 */     this.jMenuItem35.setAccelerator(KeyStroke.getKeyStroke(82, 8));
/* 3444 */     this.jMenuItem35.setIcon(new ImageIcon(getClass().getResource("/Images/fenetre16.png")));
/* 3445 */     this.jMenuItem35.setText("Fenêtre RetroConception");
/* 3446 */     this.jMenuItem35.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3448 */         Principale.this.jMenuItem35ActionPerformed(evt);
/*      */       }
/* 3450 */     });
/* 3451 */     this.jMenu7.add(this.jMenuItem35);
/* 3452 */     this.jMenu7.add(this.jSeparator9);
/*      */     
/* 3454 */     this.jMenuItem5.setAccelerator(KeyStroke.getKeyStroke(70, 8));
/* 3455 */     this.jMenuItem5.setIcon(new ImageIcon(getClass().getResource("/Images/fenetre.png")));
/* 3456 */     this.jMenuItem5.setText("Fenêtres en cascades");
/* 3457 */     this.jMenuItem5.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3459 */         Principale.this.jMenuItem5ActionPerformed(evt);
/*      */       }
/* 3461 */     });
/* 3462 */     this.jMenu7.add(this.jMenuItem5);
/*      */     
/* 3464 */     this.jMenuBar1.add(this.jMenu7);
/*      */     
/* 3466 */     this.jMenu5.setText("Aide");
/* 3467 */     this.jMenu5.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3469 */         Principale.this.jMenu5ActionPerformed(evt);
/*      */       }
/*      */       
/* 3472 */     });
/* 3473 */     this.jMenuItem50.setAccelerator(KeyStroke.getKeyStroke(123, 0));
/* 3474 */     this.jMenuItem50.setIcon(new ImageIcon(getClass().getResource("/Images/activation2.png")));
/* 3475 */     this.jMenuItem50.setText("Enregistrement");
/* 3476 */     this.jMenuItem50.setEnabled(false);
/* 3477 */     this.jMenuItem50.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3479 */         Principale.this.jMenuItem50ActionPerformed(evt);
/*      */       }
/* 3481 */     });
/* 3482 */     this.jMenu5.add(this.jMenuItem50);
/*      */     
/* 3484 */     this.jMenuItem6.setAccelerator(KeyStroke.getKeyStroke(112, 0));
/* 3485 */     this.jMenuItem6.setIcon(new ImageIcon(getClass().getResource("/Images/help.jpg")));
/* 3486 */     this.jMenuItem6.setText("Aide en ligne");
/* 3487 */     this.jMenuItem6.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3489 */         Principale.this.jMenuItem6ActionPerformed(evt);
/*      */       }
/* 3491 */     });
/* 3492 */     this.jMenu5.add(this.jMenuItem6);
/*      */     
/* 3494 */     this.jMIVersion.setAccelerator(KeyStroke.getKeyStroke(86, 10));
/* 3495 */     this.jMIVersion.setIcon(new ImageIcon(getClass().getResource("/Images/about.png")));
/* 3496 */     this.jMIVersion.setText("A propos");
/* 3497 */     this.jMIVersion.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3499 */         Principale.this.jMIVersionActionPerformed(evt);
/*      */       }
/* 3501 */     });
/* 3502 */     this.jMenu5.add(this.jMIVersion);
/* 3503 */     this.jMenu5.add(this.jSeparator11);
/*      */     
/* 3505 */     this.jMenuItem44.setAccelerator(KeyStroke.getKeyStroke(78, 10));
/* 3506 */     this.jMenuItem44.setIcon(new ImageIcon(getClass().getResource("/Images/infosite.jpg")));
/* 3507 */     this.jMenuItem44.setText("Informations site");
/* 3508 */     this.jMenuItem44.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3510 */         Principale.this.jMenuItem44ActionPerformed(evt);
/*      */       }
/* 3512 */     });
/* 3513 */     this.jMenu5.add(this.jMenuItem44);
/*      */     
/* 3515 */     this.jMenuItem46.setAccelerator(KeyStroke.getKeyStroke(68, 1));
/* 3516 */     this.jMenuItem46.setIcon(new ImageIcon(getClass().getResource("/Images/download16.png")));
/* 3517 */     this.jMenuItem46.setText("Télécharger MCD");
/* 3518 */     this.jMenuItem46.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3520 */         Principale.this.jMenuItem46ActionPerformed(evt);
/*      */       }
/* 3522 */     });
/* 3523 */     this.jMenu5.add(this.jMenuItem46);
/* 3524 */     this.jMenu5.add(this.jSeparator21);
/*      */     
/* 3526 */     this.jMIFaireDon.setAccelerator(KeyStroke.getKeyStroke(113, 0));
/* 3527 */     this.jMIFaireDon.setFont(new Font("Segoe UI", 1, 12));
/* 3528 */     this.jMIFaireDon.setIcon(new ImageIcon(getClass().getResource("/Images/don16.png")));
/* 3529 */     this.jMIFaireDon.setText("Activer JMerise");
/* 3530 */     this.jMIFaireDon.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 3532 */         Principale.this.jMIFaireDonActionPerformed(evt);
/*      */       }
/* 3534 */     });
/* 3535 */     this.jMenu5.add(this.jMIFaireDon);
/*      */     
/* 3537 */     this.jMenuBar1.add(this.jMenu5);
/*      */     
/* 3539 */     setJMenuBar(this.jMenuBar1);
/*      */     
/* 3541 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 3542 */     getContentPane().setLayout(layout);
/* 3543 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 648, 32767));
/*      */     
/*      */ 
/*      */ 
/* 3547 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 352, 32767));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 3552 */     pack();
/*      */   }
/*      */   
/*      */   private void jMIQuiterActionPerformed(ActionEvent evt) {
/* 3556 */     quitterJMerise();
/*      */   }
/*      */   
/*      */   private void jMISupprimerActionPerformed(ActionEvent evt) {
/* 3560 */     if ((this.formeMCD.isSelected()) && 
/* 3561 */       (JOptionPane.showConfirmDialog(this, "Voulez-vous supprimer les éléments sélectionnés ?", "Suppression", 0) == 0)) {
/* 3562 */       this.formeMCD.getPage().supprimerObjetSelect();
/* 3563 */       this.formeMCD.getPage().repaint();
/*      */     }
/*      */     
/* 3566 */     if (getFormeMLD().isSelected()) {
/* 3567 */       getFormeMLD().getPageMld().supprimerLesPointDeCassure();
/* 3568 */       getFormeMLD().getPageMld().repaint();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jMIExportImageActionPerformed(ActionEvent evt)
/*      */   {
/* 3574 */     getPage().setPreferredSize(new Dimension((int)getSize().getWidth() - 400, (int)getSize().getHeight() - 400));
/* 3575 */     getPage().setSize(new Dimension((int)getSize().getWidth() - 100, (int)getSize().getHeight() - 100));
/* 3576 */     getPage().repaint();
/* 3577 */     getFormeMLD().getPageMld().setPreferredSize(new Dimension((int)getSize().getWidth() - 400, (int)getSize().getHeight() - 400));
/* 3578 */     getFormeMLD().getPageMld().setSize(new Dimension((int)getSize().getWidth() - 100, (int)getSize().getHeight() - 100));
/* 3579 */     getFormeMLD().getPageMld().repaint();
/*      */     
/*      */ 
/* 3582 */     JFileChooser fileCh = new JFileChooser();
/* 3583 */     FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichier png", new String[] { "jpg", "jpeg", "png" });
/* 3584 */     fileCh.setFileFilter(filtre);
/* 3585 */     if (this.formeMCD.getCheminFichier().trim().length() != 0) fileCh.setCurrentDirectory(new File(this.formeMCD.getCheminFichier()));
/* 3586 */     if (fileCh.showSaveDialog(this) == 0) {
/* 3587 */       File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/*      */       
/* 3589 */       String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/* 3590 */       this.formeMCD.setCheminFichier(nomFile);
/* 3591 */       nomFile = prefixNomJPG(nomFile);
/*      */       
/* 3593 */       if (getFormeMLD().isSelected()) {
/* 3594 */         Parametres.exporteImageMLD(this, getFormeMLD().getPageMld(), nomFile, 1);
/*      */       } else
/* 3596 */         Parametres.exporteImage(this, this.formeMCD.getPage(), nomFile, 1);
/*      */     }
/* 3598 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMIDictionnaireActionPerformed(ActionEvent evt)
/*      */   {
/* 3603 */     new FormeDictionnaireDeDonnees2(this, true, getPage().getListeAttribut()).setVisible(true);
/* 3604 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMIVersionActionPerformed(ActionEvent evt)
/*      */   {
/* 3609 */     new About(this, true).setVisible(true);
/* 3610 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMINouveauActionPerformed(ActionEvent evt)
/*      */   {
/* 3615 */     Setting.licence.setNbUsed(Setting.licence.getNbUsed() + 1);
/* 3616 */     creerNouveauProjet();
/* 3617 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMIOmbreActionPerformed(ActionEvent evt) {
/* 3621 */     if (getFormeMCD().isSelected()) {
/* 3622 */       getFormeMCD().modifierParametreMCD(this.jMIOmbre.isSelected(), this.jMIVariable.isSelected(), this.jMICouleurDegradee.isSelected(), this.jMIArrondirEntite.isSelected());
/*      */     }
/* 3624 */     if (getFormeMLD().isSelected()) {
/* 3625 */       getFormeMLD().modifierParametreMLD(this.jMIOmbre.isSelected(), this.jMIVariable.isSelected(), this.jMICouleurDegradee.isSelected(), this.jMIArrondirEntite.isSelected());
/*      */     }
/* 3627 */     getFormeMLD().getPageMld().repaint();
/* 3628 */     getPage().repaint();
/*      */   }
/*      */   
/*      */   private void jRBFeelNimbusActionPerformed(ActionEvent evt) {
/*      */     try {
/* 3633 */       UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
/*      */       
/* 3635 */       SwingUtilities.updateComponentTreeUI(this);
/* 3636 */       Setting.afficherFAndL2 = "JMERISE";
/*      */     } catch (Exception e) {
/* 3638 */       System.out.println("Erreur Nimbus");
/* 3639 */       Setting.afficherFAndL2 = "JAVA";
/*      */     }
/*      */   }
/*      */   
/*      */   private void jRBFeelJavaActionPerformed(ActionEvent evt) {
/*      */     try {
/* 3645 */       UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
/*      */       
/* 3647 */       SwingUtilities.updateComponentTreeUI(this);
/* 3648 */       Setting.afficherFAndL2 = "JAVA";
/*      */     } catch (Exception e) {
/* 3650 */       System.out.println("Erreur L&F java");
/* 3651 */       Setting.afficherFAndL2 = "JAVA";
/*      */     }
/*      */   }
/*      */   
/*      */   private void jRBFeelSystemActionPerformed(ActionEvent evt)
/*      */   {
/*      */     try {
/* 3658 */       UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
/* 3659 */       SwingUtilities.updateComponentTreeUI(this);
/* 3660 */       Setting.afficherFAndL2 = "SYSTEME";
/*      */     } catch (Exception e) {
/* 3662 */       System.out.println("Erreur L&F votre system");
/* 3663 */       Setting.afficherFAndL2 = "JAVA";
/*      */     }
/*      */   }
/*      */   
/*      */   private void jMIEntiteActionPerformed(ActionEvent evt) {
/* 3668 */     this.bar.setEtat("ENTITE");
/* 3669 */     this.bar.getBtEntite().setSelected(true);
/* 3670 */     this.statutBar.setStatutLab("Nouvelle ENTITE");
/* 3671 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMIRelationActionPerformed(ActionEvent evt) {
/* 3675 */     if ((getFormeMCD().isSelected()) && (getFormeMCD().getPage().sontElleDesEntites())) {
/* 3676 */       this.bar.setEtat("RIEN");
/* 3677 */       getFormeMCD().getPage().ajouterRelationDirect();
/* 3678 */       this.bar.getBtRien().setSelected(true);
/* 3679 */       this.statutBar.setStatutLab("Mode SELECTION");
/*      */     } else {
/* 3681 */       this.bar.setEtat("RELATION");
/* 3682 */       this.bar.getBtRelation().setSelected(true);
/* 3683 */       this.statutBar.setStatutLab("Nouvelle " + this.bar.getEtat()); } }
/*      */   
/*      */   private JMenuBar jMenuBar1;
/*      */   private JMenuItem jMenuItem1;
/*      */   private JMenuItem jMenuItem10;
/*      */   private JMenuItem jMenuItem11;
/*      */   private JMenuItem jMenuItem12;
/*      */   private JMenuItem jMenuItem13;
/*      */   private JMenuItem jMenuItem14;
/*      */   private JMenuItem jMenuItem15;
/*      */   private JMenuItem jMenuItem16;
/* 3694 */   private void jMILienActionPerformed(ActionEvent evt) { this.bar.setEtat("LIEN");
/* 3695 */     this.bar.getBtLien().setSelected(true);
/* 3696 */     this.statutBar.setStatutLab("Nouveau LIEN");
/* 3697 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMIVariableActionPerformed(ActionEvent evt) {
/* 3701 */     if (getFormeMCD().isSelected()) {
/* 3702 */       getFormeMCD().modifierParametreMCD(this.jMIOmbre.isSelected(), this.jMIVariable.isSelected(), this.jMICouleurDegradee.isSelected(), this.jMIArrondirEntite.isSelected());
/*      */     }
/* 3704 */     if (getFormeMLD().isSelected()) {
/* 3705 */       getFormeMLD().modifierParametreMLD(this.jMIOmbre.isSelected(), this.jMIVariable.isSelected(), this.jMICouleurDegradee.isSelected(), this.jMIArrondirEntite.isSelected());
/*      */     }
/* 3707 */     getFormeMLD().getPageMld().repaint();
/* 3708 */     getPage().repaint();
/*      */   }
/*      */   
/*      */   private void jMIEnregistrerActionPerformed(ActionEvent evt)
/*      */   {
/* 3713 */     this.formeMCD.enregistrerMCD();
/* 3714 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMIouvrirActionPerformed(ActionEvent evt) {
/* 3718 */     if (this.projetSel != null) {
/* 3719 */       if (this.projetSel.getFormeMCD().isPageMCDVide()) {
/* 3720 */         this.formeMCD.setModifier(false);
/* 3721 */         this.formeMCD.ouvrirMCD(true);
/*      */       } else {
/* 3723 */         boolean mod = getFormeMCD().isModifier();
/* 3724 */         FormeInterneMCD mcd = this.projetSel.getFormeMCD();
/* 3725 */         getFormeMCD().setModifier(false);
/* 3726 */         getFormeMCD().ouvrirMCD(false);
/* 3727 */         if (mcd != this.projetSel.getFormeMCD()) {
/* 3728 */           mcd.setModifier(mod);
/*      */         }
/*      */       }
/*      */     }
/* 3732 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMIVerifierActionPerformed(ActionEvent evt) {
/* 3736 */     this.console.getRapport().setText("");
/* 3737 */     ThreadVerifMCD2 thread = new ThreadVerifMCD2(this);
/* 3738 */     if (!this.jMIConsole.isSelected()) {
/* 3739 */       this.jMIConsole.setSelected(true);
/* 3740 */       this.console.setVisible(this.jMIConsole.isSelected());
/* 3741 */       if (this.jMIConsole.isSelected()) {
/* 3742 */         this.console.setSize(this.console.getWidth(), 20);
/* 3743 */         this.splitCon.setDividerLocation(getHeight() - 200 - this.console.getHeight());
/*      */       }
/*      */     }
/*      */     
/* 3747 */     thread.execute();
/*      */   }
/*      */   
/*      */   private void jMIGenererActionPerformed(ActionEvent evt) {
/* 3751 */     this.console.getRapport().setText("");
/* 3752 */     if (!this.jMIConsole.isSelected()) {
/* 3753 */       this.jMIConsole.setSelected(true);
/* 3754 */       this.console.setVisible(this.jMIConsole.isSelected());
/* 3755 */       if (this.jMIConsole.isSelected()) {
/* 3756 */         this.console.setSize(this.console.getWidth(), 20);
/* 3757 */         this.splitCon.setDividerLocation(getHeight() - 200 - this.console.getHeight());
/*      */       }
/*      */     }
/*      */     
/*      */ 
/* 3762 */     FormeConstruction frmCons = new FormeConstruction(this, true);
/* 3763 */     frmCons.getjLabNom().setText("Verification MCD");
/* 3764 */     frmCons.setModal(false);
/* 3765 */     frmCons.getjProgBar().setValue(0);
/*      */     
/*      */ 
/* 3768 */     frmCons.getjProgBar().setValue(50);
/*      */     
/*      */ 
/* 3771 */     getConsole().getRapport().setBackground(Color.CYAN);
/* 3772 */     boolean correct = correctionEntiteRelation();
/*      */     
/* 3774 */     frmCons.getjProgBar().setValue(75);
/* 3775 */     boolean correctDomaine = isCorrectDomaine();
/* 3776 */     frmCons.getjProgBar().setValue(100);
/*      */     
/* 3778 */     if ((correct) && (correctDomaine)) {
/* 3779 */       if (Setting.attUniq) {
/* 3780 */         if (uniqueAttributToutMCD()) {
/* 3781 */           this.console.setVisible(false);
/* 3782 */           this.jMIConsole.setSelected(false);
/*      */           
/* 3784 */           frmCons.dispose();
/* 3785 */           new ThreadConstruction(this, getPage()).execute();
/*      */         }
/*      */         else {
/* 3788 */           frmCons.dispose();
/* 3789 */           getConsole().getRapport().setBackground(Color.WHITE);
/* 3790 */           getConsole().getRapport().append("ERREUR : Le MCD est incorrect");
/*      */         }
/*      */       } else {
/* 3793 */         this.console.setVisible(false);
/* 3794 */         this.jMIConsole.setSelected(false);
/* 3795 */         frmCons.dispose();
/* 3796 */         new ThreadConstruction(this, getPage()).execute();
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 3801 */       frmCons.dispose();
/* 3802 */       getConsole().getRapport().setBackground(Color.WHITE);
/* 3803 */       getConsole().getRapport().append("ERREUR : Le MCD est incorrect");
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void jMIChercherActionPerformed(ActionEvent evt)
/*      */   {
/* 3810 */     FormeRecherche frm = new FormeRecherche(this, true, this.formeMCD.getPage().getListeEntiteRelation());
/* 3811 */     frm.setVisible(true);
/* 3812 */     if ((frm.isResultFermer()) && 
/* 3813 */       (frm.getEntiteSelect() != null)) {
/* 3814 */       double zoom = this.formeMCD.getPage().getZoom();
/*      */       
/* 3816 */       this.formeMCD.getPage().scrollRectToVisible(new Rectangle((int)((frm.getEntiteSelect().getX() - 10) * zoom), (int)(zoom * (frm.getEntiteSelect().getY() - 20)), (int)(zoom * (frm.getEntiteSelect().getWidth() + 30)), (int)(zoom * (frm.getEntiteSelect().getHeight() + 30))));
/* 3817 */       this.formeMCD.getPage().setSelected(false);
/* 3818 */       frm.getEntiteSelect().setSelected(true);
/*      */     }
/*      */     
/* 3821 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void formWindowClosing(WindowEvent evt) {
/* 3825 */     quitterJMerise();
/*      */   }
/*      */   
/*      */   private void jMIExplorerActionPerformed(ActionEvent evt) {
/* 3829 */     this.explorer.setVisible(this.jMIExplorer.isSelected());
/* 3830 */     if (this.jMIExplorer.isSelected()) {
/* 3831 */       this.splitLoupe.setVisible(true);
/* 3832 */       this.explorer.setVisible(this.jMIExplorer.isSelected());
/* 3833 */       this.split.setDividerLocation(this.explorer.getWidth());
/*      */     }
/*      */     else {
/* 3836 */       this.explorer.setVisible(false);
/* 3837 */       this.panelLoupe.setVisible(false);
/* 3838 */       this.jCBMenuLoupe.setSelected(false);
/* 3839 */       this.splitLoupe.setVisible(false);
/*      */     }
/*      */     
/* 3842 */     repaint();
/*      */   }
/*      */   
/*      */   private void jMIConsoleActionPerformed(ActionEvent evt) {
/* 3846 */     this.console.setVisible(this.jMIConsole.isSelected());
/* 3847 */     if (this.jMIConsole.isSelected()) {
/* 3848 */       this.console.setSize(this.console.getWidth(), 20);
/* 3849 */       this.splitCon.setDividerLocation(getHeight() - 200 - this.console.getHeight());
/*      */     }
/*      */   }
/*      */   
/*      */   private void jMIEnregistrerSousActionPerformed(ActionEvent evt)
/*      */   {
/* 3855 */     this.formeMCD.enregistrerSousMCD();
/*      */   }
/*      */   
/*      */   private void jMICopierActionPerformed(ActionEvent evt) {
/* 3859 */     copierObjet();
/* 3860 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMICollerActionPerformed(ActionEvent evt) {
/* 3864 */     collerObjet();
/* 3865 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMICouleurDegradeeActionPerformed(ActionEvent evt) {
/* 3869 */     if (getFormeMCD().isSelected()) {
/* 3870 */       getFormeMCD().modifierParametreMCD(this.jMIOmbre.isSelected(), this.jMIVariable.isSelected(), this.jMICouleurDegradee.isSelected(), this.jMIArrondirEntite.isSelected());
/*      */     }
/* 3872 */     if (getFormeMLD().isSelected()) {
/* 3873 */       getFormeMLD().modifierParametreMLD(this.jMIOmbre.isSelected(), this.jMIVariable.isSelected(), this.jMICouleurDegradee.isSelected(), this.jMIArrondirEntite.isSelected());
/*      */     }
/* 3875 */     getFormeMLD().getPageMld().repaint();
/* 3876 */     getPage().repaint();
/*      */   }
/*      */   
/*      */   private void jMenuItem1ActionPerformed(ActionEvent evt) {
/* 3880 */     this.formeMCD.afficherPropriete(getWidth() / 2, getHeight() / 2);
/* 3881 */     this.formeMCD.getPage().repaint();
/* 3882 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMIDomaineActionPerformed(ActionEvent evt) {
/* 3886 */     new FormeListeDomaine(this, true, getPage().getListeDomaine()).setVisible(true);
/* 3887 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMenuItem2ActionPerformed(ActionEvent evt) {
/* 3891 */     getFormeMCD().setVisible(true);
/*      */     try {
/* 3893 */       getFormeMCD().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 3895 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 3897 */     getFormeMCD().toFront();
/*      */   }
/*      */   
/*      */   private void jMenuItem3ActionPerformed(ActionEvent evt) {
/* 3901 */     getFormeMLD().setVisible(true);
/*      */     try {
/* 3903 */       getFormeMLD().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 3905 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 3907 */     getFormeMLD().toFront();
/*      */   }
/*      */   
/*      */   private void jMenuItem4ActionPerformed(ActionEvent evt) {
/* 3911 */     getFormeSQL().setVisible(true);
/*      */     try {
/* 3913 */       getFormeSQL().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 3915 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 3917 */     getFormeSQL().toFront();
/*      */   }
/*      */   
/*      */   private void jMenuItem5ActionPerformed(ActionEvent evt) {
/* 3921 */     this.formeMCD.setSize(700, 400);
/* 3922 */     this.formeMCD.setLocation(200, 200);
/* 3923 */     this.formeSQL.setSize(700, 400);
/* 3924 */     this.formeSQL.setLocation(100, 100);
/* 3925 */     this.formeMLD.setSize(700, 400);
/* 3926 */     this.formeMLD.setLocation(150, 150);
/* 3927 */     this.formeXML.setSize(700, 400);
/* 3928 */     this.formeXML.setLocation(50, 50);
/* 3929 */     this.formeRetro.setLocation(0, 0);
/*      */     
/* 3931 */     getFormeRetro().setVisible(true);
/* 3932 */     getFormeXML().setVisible(true);
/* 3933 */     getFormeSQL().setVisible(true);
/* 3934 */     getFormeMLD().setVisible(true);
/* 3935 */     getFormeMCD().setVisible(true);
/*      */     try
/*      */     {
/* 3938 */       getFormeRetro().setIcon(false);
/* 3939 */       getFormeSQL().setIcon(false);
/* 3940 */       getFormeMLD().setIcon(false);
/* 3941 */       getFormeMCD().setIcon(false);
/* 3942 */       getFormeXML().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 3944 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 3946 */     getFormeRetro().toFront();
/* 3947 */     getFormeXML().toFront();
/* 3948 */     getFormeSQL().toFront();
/* 3949 */     getFormeMLD().toFront();
/* 3950 */     getFormeMCD().toFront();
/*      */   }
/*      */   
/*      */   private void jMenuItem6ActionPerformed(ActionEvent evt)
/*      */   {
/* 3955 */     if (Desktop.isDesktopSupported())
/*      */     {
/* 3957 */       Desktop desktop = Desktop.getDesktop();
/*      */       
/*      */ 
/* 3960 */       if (desktop.isSupported(Desktop.Action.BROWSE)) {
/*      */         try
/*      */         {
/*      */           try {
/* 3964 */             desktop.browse(new URI("http://www.jfreesoft.com"));
/*      */           } catch (URISyntaxException ex) {
/* 3966 */             Logger.getLogger(Principale.class.getName()).log(Level.SEVERE, null, ex);
/*      */           }
/*      */         } catch (IOException ex) {
/* 3969 */           Logger.getLogger(Principale.class.getName()).log(Level.SEVERE, null, ex);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void jMIImporterAnalyseSIActionPerformed(ActionEvent evt)
/*      */   {
/* 3977 */     if (this.projetSel != null) {
/* 3978 */       if (this.projetSel.getFormeMCD().isPageMCDVide()) {
/* 3979 */         this.formeMCD.setModifier(false);
/* 3980 */         this.formeMCD.importerAnalyseSIMCD(true);
/*      */       } else {
/* 3982 */         boolean mod = getFormeMCD().isModifier();
/* 3983 */         IhmProjet pr = this.projetSel;
/* 3984 */         getFormeMCD().setModifier(false);
/* 3985 */         this.formeMCD.importerAnalyseSIMCD(false);
/* 3986 */         if (pr != this.projetSel) pr.getFormeMCD().setModifier(mod);
/*      */       }
/*      */     }
/* 3989 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void formWindowActivated(WindowEvent evt) {
/* 3993 */     getPage().setKey(false);
/*      */   }
/*      */   
/*      */   private void jMenuItem8ActionPerformed(ActionEvent evt) {
/* 3997 */     if (getFormeMCD().getConnexion().conn == null) {
/* 3998 */       new FormeConnexion(this, true, getFormeSQL().getPanelsql().getTypeSql()).setVisible(true);
/*      */     } else {
/*      */       try {
/* 4001 */         if (getFormeMCD().getConnexion().conn.isClosed()) {
/* 4002 */           new FormeConnexion(this, true, getFormeSQL().getPanelsql().getTypeSql()).setVisible(true);
/*      */         }
/* 4004 */         else if (JOptionPane.showConfirmDialog(this, "Vous êtes déjà connecté !!.\n Voulez vous vous déconnecter ?", "Connexion ", 0) == 0) {
/* 4005 */           Connexion.Deconnecter(getFormeMCD().getConnexion());
/*      */         }
/*      */       }
/*      */       catch (SQLException ex) {
/* 4009 */         Logger.getLogger(Principale.class.getName()).log(Level.SEVERE, null, ex);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void jMenuItem9ActionPerformed(ActionEvent evt)
/*      */   {
/* 4016 */     if ((getFormeMCD().getConnexion().conn != null) && 
/* 4017 */       (!getFormeMCD().getConnexion().typeSql.equals(this.formeSQL.getPanelsql().getTypeSql()))) {
/* 4018 */       getFormeMCD().getConnexion().conn = null;
/*      */     }
/*      */     
/*      */ 
/* 4022 */     if (getFormeMCD().getConnexion().conn != null) {
/*      */       try {
/* 4024 */         if (!getFormeMCD().getConnexion().conn.isClosed()) {
/* 4025 */           ThreadScriptBDD scri = new ThreadScriptBDD(this);
/* 4026 */           scri.execute();
/*      */         } else {
/* 4028 */           JOptionPane.showMessageDialog(this, "ERREUR : Veuillez vous connectez avant d'exécuter le script  !! ");
/*      */         }
/*      */         
/*      */ 
/*      */       }
/*      */       catch (SQLException ex) {}
/*      */     } else {
/* 4035 */       JOptionPane.showMessageDialog(this, "ERREUR : Veuillez vous connecter avant d'exécuter le script  !! ");
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void formKeyPressed(KeyEvent evt) {}
/*      */   
/*      */ 
/*      */   private void jMenuItem10ActionPerformed(ActionEvent evt)
/*      */   {
/* 4045 */     getPage().alignerGroupe("DROITE");
/*      */   }
/*      */   
/*      */   private void jMenuItem11ActionPerformed(ActionEvent evt) {
/* 4049 */     getPage().alignerGroupe("GAUCHE");
/*      */   }
/*      */   
/*      */   private void jMenuItem12ActionPerformed(ActionEvent evt) {
/* 4053 */     getPage().alignerGroupe("TOP");
/*      */   }
/*      */   
/*      */   private void jMenuItem13ActionPerformed(ActionEvent evt) {
/* 4057 */     getPage().alignerGroupe("BAS");
/*      */   }
/*      */   
/*      */   private void jMenuItem16ActionPerformed(ActionEvent evt) {
/* 4061 */     getFormeRetro().setVisible(true);
/*      */     try {
/* 4063 */       getFormeRetro().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 4065 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 4067 */     getFormeRetro().toFront();
/*      */   }
/*      */   
/*      */   private void jMenuItem19ActionPerformed(ActionEvent evt) {
/* 4071 */     getFormeXML().setVisible(true);
/*      */     try {
/* 4073 */       getFormeXML().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 4075 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 4077 */     getFormeXML().toFront();
/*      */   }
/*      */   
/*      */   private void jMenuItem22ActionPerformed(ActionEvent evt) {
/* 4081 */     getFormeXML().setVisible(true);
/*      */     try {
/* 4083 */       getFormeXML().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 4085 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 4087 */     getFormeXML().toFront();
/* 4088 */     getFormeXML().getPanelXML().setTypeDoc("XML");
/* 4089 */     new ThreadGenererXML(this).execute();
/*      */   }
/*      */   
/*      */   private void jMenuItem18ActionPerformed(ActionEvent evt) {
/* 4093 */     getFormeXML().getXmlString().setListeEntiteMLD(getFormeMLD().getPageMld().getListeMLDEntite());
/* 4094 */     getFormeXML().getPanelXML().getPane().setText(getFormeXML().getXmlString().getXMLString("MCD_XML"));
/* 4095 */     getFormeXML().getPanelXML().setTypeDoc("DTD");
/*      */     
/* 4097 */     getFormeXML().setVisible(true);
/*      */     try {
/* 4099 */       getFormeXML().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 4101 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 4103 */     getFormeXML().toFront();
/*      */   }
/*      */   
/*      */   private void jMenuItem15ActionPerformed(ActionEvent evt)
/*      */   {
/* 4108 */     double z = this.bar.getZoom(this.bar.getjLabPrZoom().getText(), "MOINS");
/* 4109 */     getPage().setZoom(z);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 4114 */     getPage().repaint();
/*      */   }
/*      */   
/*      */   private void jMenuItem14ActionPerformed(ActionEvent evt) {
/* 4118 */     double z = this.bar.getZoom(this.bar.getjLabPrZoom().getText(), "PLUS");
/* 4119 */     getPage().setZoom(z);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 4125 */     getPage().repaint();
/*      */   }
/*      */   
/*      */   private void jMenuItem21ActionPerformed(ActionEvent evt)
/*      */   {
/* 4130 */     if (!verificationMLD()) {
/* 4131 */       return;
/*      */     }
/* 4133 */     this.formeSQL.getPanelsql().getPane().setText(Output.SQLPostGre.getScript(this.formeMLD.getPageMld(), this.formeMCD.getPage()));
/* 4134 */     this.formeSQL.getPanelsql().getPane().setCaretPosition(0);
/* 4135 */     this.formeSQL.getPanelsql().setTypeSql(SQLOutil.SQLPOSTGRE);
/* 4136 */     getFormeSQL().setVisible(true);
/*      */     try {
/* 4138 */       getFormeSQL().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 4140 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 4142 */     getFormeSQL().toFront();
/*      */   }
/*      */   
/*      */   private void jMenuItem20ActionPerformed(ActionEvent evt) {
/* 4146 */     if (!verificationMLD()) {
/* 4147 */       return;
/*      */     }
/*      */     
/* 4150 */     this.formeSQL.getPanelsql().getPane().setText(Output.SQLite.getScript(this.formeMCD.getPage(), this.formeMLD.getPageMld()));
/* 4151 */     this.formeSQL.getPanelsql().getPane().setCaretPosition(0);
/* 4152 */     this.formeSQL.getPanelsql().setTypeSql(SQLOutil.SQLITE);
/* 4153 */     getFormeSQL().setVisible(true);
/*      */     try {
/* 4155 */       getFormeSQL().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 4157 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 4159 */     getFormeSQL().toFront();
/*      */   }
/*      */   
/*      */   private void jMenuItem17ActionPerformed(ActionEvent evt)
/*      */   {
/* 4164 */     if (!verificationMLD()) {
/* 4165 */       return;
/*      */     }
/*      */     
/* 4168 */     this.formeSQL.getPanelsql().getPane().setText(Output.SQLMySQL.getScript(this.formeMCD.getPage(), this.formeMLD.getPageMld()));
/* 4169 */     this.formeSQL.getPanelsql().getPane().setCaretPosition(0);
/* 4170 */     this.formeSQL.getPanelsql().setTypeSql(SQLOutil.SQLMYSQL);
/* 4171 */     getFormeSQL().setVisible(true);
/*      */     try {
/* 4173 */       getFormeSQL().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 4175 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 4177 */     getFormeSQL().toFront();
/*      */   }
/*      */   
/*      */   private void jMenuItem27ActionPerformed(ActionEvent evt) {
/* 4181 */     new FormeLegendeRetro(this, true).setVisible(true);
/*      */   }
/*      */   
/*      */   private void jMenuItem26ActionPerformed(ActionEvent evt) {
/* 4185 */     getFormeRetro().setVisible(true);
/*      */     try {
/* 4187 */       getFormeRetro().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 4189 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 4191 */     getFormeRetro().toFront();
/*      */     
/* 4193 */     if (this.formeRetro.getDataBase().getConnection() != null) {
/*      */       try {
/* 4195 */         if (this.formeRetro.getDataBase().getConnection().isClosed()) {
/* 4196 */           formes.FormeConnexion f = new formes.FormeConnexion(this, true, this.formeRetro.getDataBase(), this.formeRetro.getDataBase().getConnection());
/* 4197 */           f.setVisible(true);
/* 4198 */           this.formeRetro.getDataBase().remplirTableAttribut();
/* 4199 */           if (this.formeRetro.getDataBase() != null) {
/* 4200 */             this.formeRetro.remplirInformation(this.formeRetro.getDataBase().getName(), this.formeRetro.getDataBase().getTypeSQL());
/*      */           }
/* 4202 */           this.formeRetro.remplirListeTable();
/* 4203 */           this.formeRetro.getExplorerBD().supprimerTout();
/* 4204 */           this.formeRetro.getExplorerBD().ajouterBase(this.formeRetro.getDataBase());
/*      */         }
/* 4206 */         else if (JOptionPane.showConfirmDialog(this, "Vous êtes déjà connecté !!.\n Voulez vous vous déconnecter ?", "Connexion ", 0) == 0) {
/* 4207 */           formes.FormeConnexion f = new formes.FormeConnexion(this, true, this.formeRetro.getDataBase(), this.formeRetro.getDataBase().getConnection());
/* 4208 */           f.setVisible(true);
/* 4209 */           this.formeRetro.getDataBase().remplirTableAttribut();
/* 4210 */           if (this.formeRetro.getDataBase() != null) {
/* 4211 */             this.formeRetro.remplirInformation(this.formeRetro.getDataBase().getName(), this.formeRetro.getDataBase().getTypeSQL());
/*      */           }
/*      */           
/* 4214 */           this.formeRetro.remplirListeTable();
/* 4215 */           this.formeRetro.getExplorerBD().supprimerTout();
/* 4216 */           this.formeRetro.getExplorerBD().ajouterBase(this.formeRetro.getDataBase());
/*      */         }
/*      */       }
/*      */       catch (Exception e) {}
/*      */     }
/*      */     else
/*      */     {
/* 4223 */       formes.FormeConnexion f = new formes.FormeConnexion(this, true, this.formeRetro.getDataBase(), this.formeRetro.getDataBase().getConnection());
/* 4224 */       f.setVisible(true);
/* 4225 */       this.formeRetro.getDataBase().remplirTableAttribut();
/* 4226 */       if (this.formeRetro.getDataBase() != null) {
/* 4227 */         this.formeRetro.remplirInformation(this.formeRetro.getDataBase().getName(), this.formeRetro.getDataBase().getTypeSQL());
/*      */       }
/*      */       
/* 4230 */       this.formeRetro.remplirListeTable();
/* 4231 */       this.formeRetro.getExplorerBD().supprimerTout();
/* 4232 */       this.formeRetro.getExplorerBD().ajouterBase(this.formeRetro.getDataBase());
/*      */     }
/*      */   }
/*      */   
/*      */   private void jMenuItem34ActionPerformed(ActionEvent evt) {
/* 4237 */     getFormeRetro().setVisible(true);
/*      */     try {
/* 4239 */       getFormeRetro().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 4241 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 4243 */     getFormeRetro().toFront();
/* 4244 */     if (this.formeRetro.getDataBase().getConnection() != null) this.formeRetro.getDataBase().getListeTable();
/* 4245 */     this.formeRetro.getDataBase().remplirTableAttribut();
/*      */     
/* 4247 */     this.formeRetro.remplirListeTable();
/* 4248 */     this.formeRetro.getExplorerBD().supprimerTout();
/* 4249 */     this.formeRetro.getExplorerBD().ajouterBase(this.formeRetro.getDataBase());
/*      */   }
/*      */   
/*      */ 
/*      */   private JMenuItem jMenuItem17;
/*      */   
/*      */   private JMenuItem jMenuItem18;
/*      */   
/*      */   private JMenuItem jMenuItem19;
/*      */   
/*      */   private JMenuItem jMenuItem2;
/*      */   
/*      */   private JMenuItem jMenuItem20;
/*      */   
/*      */   private JMenuItem jMenuItem21;
/*      */   
/*      */   private JMenuItem jMenuItem22;
/*      */   private JMenuItem jMenuItem23;
/*      */   private JMenuItem jMenuItem24;
/*      */   private JMenuItem jMenuItem25;
/*      */   private JMenuItem jMenuItem26;
/*      */   private JMenuItem jMenuItem27;
/*      */   private JMenuItem jMenuItem28;
/*      */   private JMenuItem jMenuItem29;
/*      */   private JMenuItem jMenuItem3;
/*      */   private JMenuItem jMenuItem30;
/*      */   private JMenuItem jMenuItem31;
/*      */   private JMenuItem jMenuItem32;
/*      */   private JMenuItem jMenuItem33;
/*      */   private JMenuItem jMenuItem34;
/*      */   private JMenuItem jMenuItem35;
/*      */   private JMenuItem jMenuItem36;
/*      */   private JMenuItem jMenuItem37;
/*      */   private JMenuItem jMenuItem38;
/*      */   private JMenuItem jMenuItem39;
/*      */   private JMenuItem jMenuItem4;
/*      */   private JMenuItem jMenuItem40;
/*      */   private JMenuItem jMenuItem41;
/*      */   private JMenuItem jMenuItem42;
/*      */   private JMenuItem jMenuItem43;
/*      */   private JMenuItem jMenuItem44;
/*      */   private JMenuItem jMenuItem45;
/*      */   private JMenuItem jMenuItem46;
/*      */   private JMenuItem jMenuItem48;
/*      */   private JMenuItem jMenuItem49;
/*      */   private JMenuItem jMenuItem5;
/*      */   private JMenuItem jMenuItem50;
/*      */   private JMenuItem jMenuItem55;
/*      */   private JMenuItem jMenuItem6;
/*      */   private JMenuItem jMenuItem7;
/*      */   private JMenuItem jMenuItem8;
/*      */   private JMenuItem jMenuItem9;
/*      */   private JMenu jMenuLibrairie;
/*      */   private JRadioButtonMenuItem jRBFeelJava;
/*      */   private JRadioButtonMenuItem jRBFeelNimbus;
/*      */   private JRadioButtonMenuItem jRBFeelSystem;
/*      */   private JPopupMenu.Separator jSeparator1;
/*      */   private JPopupMenu.Separator jSeparator10;
/*      */   private JPopupMenu.Separator jSeparator11;
/*      */   private JPopupMenu.Separator jSeparator12;
/*      */   private JPopupMenu.Separator jSeparator13;
/*      */   private JPopupMenu.Separator jSeparator14;
/*      */   private JPopupMenu.Separator jSeparator15;
/*      */   private JPopupMenu.Separator jSeparator16;
/*      */   private JPopupMenu.Separator jSeparator17;
/*      */   private JPopupMenu.Separator jSeparator19;
/*      */   private JPopupMenu.Separator jSeparator2;
/*      */   private JPopupMenu.Separator jSeparator20;
/*      */   private JPopupMenu.Separator jSeparator21;
/*      */   private JPopupMenu.Separator jSeparator22;
/*      */   private JPopupMenu.Separator jSeparator23;
/*      */   private JPopupMenu.Separator jSeparator24;
/*      */   private JPopupMenu.Separator jSeparator3;
/*      */   private JPopupMenu.Separator jSeparator4;
/*      */   private JPopupMenu.Separator jSeparator5;
/*      */   private JPopupMenu.Separator jSeparator6;
/*      */   private JPopupMenu.Separator jSeparator7;
/*      */   private JPopupMenu.Separator jSeparator8;
/*      */   private JPopupMenu.Separator jSeparator9;
/*      */   private void jMenuItem30ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jMenuItem31ActionPerformed(ActionEvent evt)
/*      */   {
/* 4332 */     FormeSelectTable f = new FormeSelectTable(this, true, this.formeRetro.getDataBase(), this.formeRetro.getListeTableSel());
/* 4333 */     f.setVisible(true);
/* 4334 */     if (f.isValider()) {
/* 4335 */       this.formeRetro.setListeTableSel(f.getListeTableSel());
/*      */     }
/*      */   }
/*      */   
/*      */   private void jMenuItem28ActionPerformed(ActionEvent evt)
/*      */   {
/* 4341 */     if (!verificationMLD()) {
/* 4342 */       return;
/*      */     }
/*      */     
/* 4345 */     this.formeSQL.getPanelsql().getPane().setText(Output.SQLDerby.getScript(this.formeMCD.getPage(), this.formeMLD.getPageMld()));
/* 4346 */     this.formeSQL.getPanelsql().getPane().setCaretPosition(0);
/* 4347 */     this.formeSQL.getPanelsql().setTypeSql(SQLOutil.SQLDERBY);
/* 4348 */     getFormeSQL().setVisible(true);
/*      */     try {
/* 4350 */       getFormeSQL().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 4352 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 4354 */     getFormeSQL().toFront();
/*      */   }
/*      */   
/*      */   private void jMenuItem29ActionPerformed(ActionEvent evt)
/*      */   {
/* 4359 */     if (!verificationMLD()) {
/* 4360 */       return;
/*      */     }
/* 4362 */     this.formeSQL.getPanelsql().getPane().setText(Output.SQLFirebird.getScript(this.formeMCD.getPage(), this.formeMLD.getPageMld()));
/* 4363 */     this.formeSQL.getPanelsql().getPane().setCaretPosition(0);
/* 4364 */     this.formeSQL.getPanelsql().setTypeSql(SQLOutil.SQLFIREBIRD);
/* 4365 */     getFormeSQL().setVisible(true);
/*      */     try {
/* 4367 */       getFormeSQL().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 4369 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 4371 */     getFormeSQL().toFront();
/*      */   }
/*      */   
/*      */   private void jMenuItem25ActionPerformed(ActionEvent evt) {
/* 4375 */     new FormeSetting2(this, true).setVisible(true);
/*      */   }
/*      */   
/*      */   private void jMenuItem35ActionPerformed(ActionEvent evt) {
/* 4379 */     getFormeRetro().setVisible(true);
/*      */     try {
/* 4381 */       getFormeRetro().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 4383 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 4385 */     getFormeRetro().toFront();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void MIQuitterJMeriseActionPerformed(ActionEvent evt) {}
/*      */   
/*      */ 
/*      */   private void jMenuItem39ActionPerformed(ActionEvent evt)
/*      */   {
/* 4395 */     getProjetSel().getFormeMCD().miseAjourParametreMCD(getProjetSel().getFormeMCD().getPage().getConfigurationMCD());
/* 4396 */     new FormeProprieteMCD2(this, true, getProjetSel().getFormeMCD()).setVisible(true);
/*      */   }
/*      */   
/*      */   private void jCBMenuLoupeActionPerformed(ActionEvent evt) {
/* 4400 */     if (this.jMIExplorer.isSelected()) {
/* 4401 */       this.panelLoupe.setVisible(this.jCBMenuLoupe.isSelected());
/* 4402 */       if (this.jCBMenuLoupe.isSelected()) {
/* 4403 */         this.panelLoupe.setSize(this.panelLoupe.getWidth(), 100);
/* 4404 */         this.splitLoupe.setDividerLocation(getHeight() - 200 - this.panelLoupe.getHeight());
/*      */       }
/*      */     } else {
/* 4407 */       this.jCBMenuLoupe.setSelected(false);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jMIImprimerActionPerformed(ActionEvent evt) {
/* 4412 */     getPage().setPreferredSize(new Dimension((int)getSize().getWidth() - 400, (int)getSize().getHeight() - 400));
/* 4413 */     getPage().setSize(new Dimension((int)getSize().getWidth() - 100, (int)getSize().getHeight() - 100));
/* 4414 */     getPage().repaint();
/* 4415 */     getFormeMLD().getPageMld().setPreferredSize(new Dimension((int)getSize().getWidth() - 400, (int)getSize().getHeight() - 400));
/* 4416 */     getFormeMLD().getPageMld().setSize(new Dimension((int)getSize().getWidth() - 100, (int)getSize().getHeight() - 100));
/* 4417 */     getFormeMLD().getPageMld().repaint();
/*      */     
/*      */ 
/* 4420 */     if (getFormeMLD().isSelected()) {
/* 4421 */       new ThreadImprimer(this, getFormeMLD().getPageMld(), "MLD : " + this.projetSel.toString()).execute();
/*      */     }
/*      */     else {
/* 4424 */       new ThreadImprimer(this, getFormeMCD().getPage(), "MCD : " + this.projetSel.toString()).execute();
/*      */     }
/* 4426 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMenuItem37ActionPerformed(ActionEvent evt)
/*      */   {
/* 4431 */     if (!verificationMLD()) {
/* 4432 */       return;
/*      */     }
/*      */     
/* 4435 */     this.formeSQL.getPanelsql().getPane().setText(Output.SQLAccess.getScript(this.formeMLD.getPageMld(), this.formeMCD.getPage()));
/* 4436 */     this.formeSQL.getPanelsql().getPane().setCaretPosition(0);
/* 4437 */     this.formeSQL.getPanelsql().setTypeSql(SQLOutil.SQLACCESS);
/* 4438 */     getFormeSQL().setVisible(true);
/*      */     try {
/* 4440 */       getFormeSQL().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 4442 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 4444 */     getFormeSQL().toFront();
/*      */   }
/*      */   
/*      */   private void jMenuItem40ActionPerformed(ActionEvent evt) {
/* 4448 */     if ((this.projetSel != null) && 
/* 4449 */       (this.projetSel.getFormeMCD().fermerMCD())) { supprimerProjet(this.projetSel);
/*      */     }
/* 4451 */     repaint();
/*      */   }
/*      */   
/*      */   private void jMenuItem41ActionPerformed(ActionEvent evt)
/*      */   {
/* 4456 */     fermerToutMCD();
/* 4457 */     repaint();
/*      */   }
/*      */   
/*      */   private void jMenuItem42ActionPerformed(ActionEvent evt) {
/* 4461 */     new FormeImporterDictionnaire(this, this.projetSel, true).setVisible(true);
/* 4462 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMenuItem43ActionPerformed(ActionEvent evt) {
/* 4466 */     new FormeImporterDomaine(this, this.projetSel, true).setVisible(true);
/* 4467 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMenuItem44ActionPerformed(ActionEvent evt) {
/* 4471 */     new FormeInformationSite(this, true).setVisible(true);
/* 4472 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMenuItem32ActionPerformed(ActionEvent evt)
/*      */   {
/* 4477 */     if (!verificationMLD()) {
/* 4478 */       return;
/*      */     }
/*      */     
/* 4481 */     this.formeSQL.getPanelsql().getPane().setText(Output.SQLServer.getScript(this.formeMLD.getPageMld(), this.formeMCD.getPage()));
/* 4482 */     this.formeSQL.getPanelsql().getPane().setCaretPosition(0);
/* 4483 */     this.formeSQL.getPanelsql().setTypeSql(SQLOutil.SQLSERVER);
/* 4484 */     getFormeSQL().setVisible(true);
/*      */     try {
/* 4486 */       getFormeSQL().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 4488 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 4490 */     getFormeSQL().toFront();
/*      */   }
/*      */   
/*      */   private void jMenuItem45ActionPerformed(ActionEvent evt) {
/* 4494 */     new FormeText(this, true, getProjetSel().getFormeMCD().getPage().getConfigurationMCD(), false).setVisible(true);
/*      */   }
/*      */   
/*      */   private void jMenuItem33ActionPerformed(ActionEvent evt)
/*      */   {
/* 4499 */     if (!verificationMLD()) {
/* 4500 */       return;
/*      */     }
/*      */     
/* 4503 */     this.formeSQL.getPanelsql().getPane().setText(Output.SQLOracle.getScript(this.formeMCD.getPage(), this.formeMLD.getPageMld()));
/* 4504 */     this.formeSQL.getPanelsql().getPane().setCaretPosition(0);
/* 4505 */     this.formeSQL.getPanelsql().setTypeSql(SQLOutil.SQLORACLE);
/* 4506 */     getFormeSQL().setVisible(true);
/*      */     try {
/* 4508 */       getFormeSQL().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 4510 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 4512 */     getFormeSQL().toFront();
/*      */   }
/*      */   
/*      */   private void jMITransformerActionPerformed(ActionEvent evt) {
/* 4516 */     getFormeMCD().getPage().transformerRelation();
/* 4517 */     getFormeMCD().getPage().repaint();
/* 4518 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */ 
/*      */   private void jMenu5ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jMenuItem46ActionPerformed(ActionEvent evt)
/*      */   {
/* 4526 */     getFormeBibioMCD().setVisible(true);
/*      */   }
/*      */   
/*      */   private void jMenuItem36ActionPerformed(ActionEvent evt)
/*      */   {
/* 4531 */     if (!verificationMLD()) {
/* 4532 */       return;
/*      */     }
/*      */     
/* 4535 */     this.formeSQL.getPanelsql().getPane().setText(Output.SQLHsqldb.getScript(this.formeMCD.getPage(), this.formeMLD.getPageMld()));
/* 4536 */     this.formeSQL.getPanelsql().getPane().setCaretPosition(0);
/* 4537 */     this.formeSQL.getPanelsql().setTypeSql(SQLOutil.HSQLDB);
/* 4538 */     getFormeSQL().setVisible(true);
/*      */     try {
/* 4540 */       getFormeSQL().setIcon(false);
/*      */     } catch (PropertyVetoException ex) {
/* 4542 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 4544 */     getFormeSQL().toFront();
/*      */   }
/*      */   
/*      */ 
/*      */   private void jMIFaireDonActionPerformed(ActionEvent evt)
/*      */   {
/* 4550 */     if (Desktop.isDesktopSupported())
/*      */     {
/* 4552 */       Desktop desktop = Desktop.getDesktop();
/*      */       
/*      */ 
/* 4555 */       if (desktop.isSupported(Desktop.Action.BROWSE)) {
/*      */         try
/*      */         {
/*      */           try {
/* 4559 */             desktop.browse(new URI("http://www.jfreesoft.com/JMerise/activation.html"));
/*      */           } catch (URISyntaxException ex) {
/* 4561 */             Logger.getLogger(BarOutil.class.getName()).log(Level.SEVERE, null, ex);
/*      */           }
/*      */         } catch (IOException ex) {
/* 4564 */           Logger.getLogger(BarOutil.class.getName()).log(Level.SEVERE, null, ex);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void formMouseExited(MouseEvent evt) {
/* 4571 */     getPage().setKey(false);
/*      */   }
/*      */   
/*      */   private void formFocusLost(FocusEvent evt) {
/* 4575 */     getPage().setKey(false);
/*      */   }
/*      */   
/*      */   private void jMenuItem48ActionPerformed(ActionEvent evt)
/*      */   {
/* 4580 */     FileExport.exporterDictionnaire(this, getFormeMCD().getPage().getListeAttribut());
/*      */   }
/*      */   
/*      */   private void jMenuItem49ActionPerformed(ActionEvent evt) {
/* 4584 */     FileExport.exporterListeDomaine(this, getFormeMCD().getPage().getListeDomaine());
/*      */   }
/*      */   
/*      */   private void jMenuItem50ActionPerformed(ActionEvent evt) {
/* 4588 */     FormeCreationCompteJFreeSoft frm = new FormeCreationCompteJFreeSoft(this, true);
/* 4589 */     frm.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jMIRemplacerActionPerformed(ActionEvent evt) {
/* 4593 */     FormeRechercheRemplacer frm = new FormeRechercheRemplacer(this, true, this.formeMCD.getPage().getListeEntiteRelation());
/* 4594 */     frm.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jMIVariableMousePressed(MouseEvent evt) {
/* 4598 */     getPage().repaint();
/*      */   }
/*      */   
/*      */   private void jMIOmbreMousePressed(MouseEvent evt) {
/* 4602 */     getPage().repaint();
/*      */   }
/*      */   
/*      */   private void jMIArrondirEntiteActionPerformed(ActionEvent evt) {
/* 4606 */     if (getFormeMCD().isSelected()) {
/* 4607 */       getFormeMCD().modifierParametreMCD(this.jMIOmbre.isSelected(), this.jMIVariable.isSelected(), this.jMICouleurDegradee.isSelected(), this.jMIArrondirEntite.isSelected());
/*      */     }
/* 4609 */     if (getFormeMLD().isSelected()) {
/* 4610 */       getFormeMLD().modifierParametreMLD(this.jMIOmbre.isSelected(), this.jMIVariable.isSelected(), this.jMICouleurDegradee.isSelected(), this.jMIArrondirEntite.isSelected());
/*      */     }
/* 4612 */     getFormeMLD().getPageMld().repaint();
/* 4613 */     getPage().repaint();
/*      */   }
/*      */   
/*      */ 
/*      */   private void jMenu4ActionPerformed(ActionEvent evt) {}
/*      */   
/*      */ 
/*      */   private void jMIActiverLienActionPerformed(ActionEvent evt)
/*      */   {
/* 4622 */     Setting.activerLien2 = this.jMIActiverLien.isSelected();
/*      */   }
/*      */   
/*      */   private void jMINouvelleLibrairieActionPerformed(ActionEvent evt) {
/* 4626 */     new FormeAjouterLibrairie(this, true).setVisible(true);
/* 4627 */     getPage().setCTRLButton(false);
/*      */   }
/*      */   
/*      */   private void jMenuItem55ActionPerformed(ActionEvent evt) {
/* 4631 */     getPage().insererDansLaLibrairie();
/*      */   }
/*      */   
/*      */   private void jMILibrairieActionPerformed(ActionEvent evt) {
/* 4635 */     getPanLibibrary().setVisible(this.jMILibrairie.isSelected());
/* 4636 */     if (getPanLibibrary().isVisible()) {
/* 4637 */       this.splitDeskLib.setVisible(true);
/* 4638 */       this.splitDeskLib.setDividerLocation(getWidth() - 500);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jMIRafraichirLibrairieActionPerformed(ActionEvent evt)
/*      */   {
/* 4644 */     this.panLibibrary.openLibraries();
/*      */   }
/*      */   
/*      */   private void jMISupprimerLibrairieActionPerformed(ActionEvent evt) {
/* 4648 */     String nomLib = getPanLibibrary().getSelectedLibrary().getName();
/* 4649 */     if (JOptionPane.showConfirmDialog(this, "Etes vous sûr de vouloir supprimer la librairie " + nomLib + "?", "Suppression", 0) == 0) {
/* 4650 */       getPanLibibrary().deleteLibrairy(getPanLibibrary().getSelectedLibrary());
/*      */     }
/*      */   }
/*      */   
/*      */   private void jMenuItem7ActionPerformed(ActionEvent evt) {
/* 4655 */     new FormeLegendeMCD(this, true).setVisible(true);
/*      */   }
/*      */   
/*      */   private void jMITransformationRelationActionPerformed(ActionEvent evt) {
/* 4659 */     new FormeConversionRelation(this, true).setVisible(true);
/*      */   }
/*      */   
/*      */   private void jMenuItem38ActionPerformed(ActionEvent evt) {
/* 4663 */     if (getFormeMLD().getPageMld().isPageVide()) return;
/* 4664 */     if (JOptionPane.showConfirmDialog(this, "Voulez-vous supprimer le MLD et et le script ?", "Suppression", 0) == 0) {
/* 4665 */       getFormeMLD().getPageMld().effacerMLD();
/* 4666 */       getFormeSQL().getPanelsql().getPane().setText("");
/* 4667 */       getFormeXML().getPanelxml().getPane().setText("");
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\ihm\Principale.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */