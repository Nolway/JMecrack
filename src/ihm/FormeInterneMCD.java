/*      */ package ihm;
/*      */ 
/*      */ import IhmMCD.BarOutil;
/*      */ import IhmMCD.IhmCIF;
/*      */ import IhmMCD.IhmContrainte;
/*      */ import IhmMCD.IhmEntite;
/*      */ import IhmMCD.IhmEntiteRelation;
/*      */ import IhmMCD.IhmHeritage;
/*      */ import IhmMCD.IhmLien;
/*      */ import IhmMCD.IhmLienContrainteHeritage;
/*      */ import IhmMCD.IhmPageMCD;
/*      */ import IhmMCD.IhmPostIt;
/*      */ import IhmMCD.IhmProjet;
/*      */ import IhmMCD.IhmRelation;
/*      */ import IhmMCD.StatutBar;
/*      */ import IhmMCD2.ConfigurationMCD2;
/*      */ import IhmMCD2.IhmCIF2;
/*      */ import IhmMCD2.IhmCadre2;
/*      */ import IhmMCD2.IhmCommentaire2;
/*      */ import IhmMCD2.IhmContrainte2;
/*      */ import IhmMCD2.IhmEntite2;
/*      */ import IhmMCD2.IhmHeritage2;
/*      */ import IhmMCD2.IhmLien2;
/*      */ import IhmMCD2.IhmLienContrainteHeritage2;
/*      */ import IhmMCD2.IhmPostIt2;
/*      */ import IhmMCD2.IhmProprieteMCD2;
/*      */ import IhmMCD2.IhmRelation2;
/*      */ import IhmMLD.IhmPageMLD;
/*      */ import MyExplorer.ExplorerPan;
/*      */ import MyExplorer.NodeRootEntite;
/*      */ import MyExplorer.NodeRootMCD;
/*      */ import MyExplorer.NodeRootRelation;
/*      */ import MySqlEditor.MySqlTextPane;
/*      */ import MyXMLEditor.MyXMLTextPane;
/*      */ import Outil.ConfigSave;
/*      */ import Outil.Connexion;
/*      */ import Outil.Parametres;
/*      */ import Outil.ProprieteMCD;
/*      */ import Outil.Setting;
/*      */ import Output.SQLSave;
/*      */ import Thasaruts.Thassarut;
/*      */ import formes.FormeCommentaireIndep;
/*      */ import formes.FormeContrainte;
/*      */ import formes.FormeEntite;
/*      */ import formes.FormeLienCif;
/*      */ import formes.FormeLienHeritageIndep;
/*      */ import formes.FormeMLDLien;
/*      */ import formes.FormePostIt;
/*      */ import formes.FormeProprieteMCD;
/*      */ import formes.FormeRecherche;
/*      */ import formes2.FormeCIF2;
/*      */ import formes2.FormeCadre2;
/*      */ import formes2.FormeCardinalite2;
/*      */ import formes2.FormeContrainte2;
/*      */ import formes2.FormeContrainteHeritage2;
/*      */ import formes2.FormeEntite2;
/*      */ import formes2.FormeLienCif2;
/*      */ import formes2.FormeLienContraintes2;
/*      */ import formes2.FormeLienHeritageContrainte2;
/*      */ import formes2.FormeProprieteMCD2;
/*      */ import java.awt.Color;
/*      */ import java.awt.Container;
/*      */ import java.awt.dnd.DropTarget;
/*      */ import java.beans.PropertyVetoException;
/*      */ import java.io.File;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.io.PrintStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.logging.Level;
/*      */ import java.util.logging.Logger;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JFileChooser;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JProgressBar;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTree;
/*      */ import javax.swing.event.InternalFrameEvent;
/*      */ import javax.swing.event.InternalFrameListener;
/*      */ import javax.swing.filechooser.FileNameExtensionFilter;
/*      */ import mythread.ThreadImporterASI;
/*      */ import mythread.ThreadOuvrir;
/*      */ 
/*      */ public class FormeInterneMCD extends FormeInterneMerise
/*      */ {
/*      */   private IhmPageMCD page;
/*      */   boolean modifier;
/*      */   private String nomFichier;
/*      */   private String cheminFichier;
/*      */   private ConfigSave config;
/*      */   private static Principale formePrincipale;
/*      */   private FormeInterneSQL formeSQL;
/*      */   private FormeInterneMLD formeMLD;
/*      */   private FormeInterneXML formeXML;
/*      */   private NodeRootMCD racineMCD;
/*      */   private NodeRootEntite entiteNode;
/*      */   private NodeRootRelation relationNode;
/*      */   private IhmProjet projet;
/*      */   private Connexion connexion;
/*  102 */   public static String etatColor = "AUCUNE";
/*      */   
/*  104 */   public static Color clEntiteCadre = Color.BLACK;
/*  105 */   public static Color clEntiteFond = Color.WHITE;
/*  106 */   public static Color clEntiteText = Color.BLACK;
/*      */   
/*  108 */   public static Color clRelationCadre = Color.BLACK;
/*  109 */   public static Color clRelationFond = Color.WHITE;
/*  110 */   public static Color clRelationText = Color.BLACK;
/*      */   
/*  112 */   public static Color clCIFCadre = Color.BLACK;
/*  113 */   public static Color clCIFFond = Color.WHITE;
/*  114 */   public static Color clCIFText = Color.BLACK;
/*      */   
/*      */ 
/*  117 */   public static Color clContrainteCadre = Color.BLACK;
/*  118 */   public static Color clContrainteFond = Color.WHITE;
/*  119 */   public static Color clContrainteText = Color.BLACK;
/*      */   
/*      */ 
/*  122 */   public static Color clLien = Color.BLACK;
/*  123 */   public static Color clLienCnt = Color.BLACK;
/*  124 */   public static Color clString = Color.BLACK;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  129 */   public static Color clEntiteCadre2 = Color.BLACK;
/*  130 */   public static Color clEntiteFond2 = Color.WHITE;
/*  131 */   public static Color clEntiteText2 = Color.BLACK;
/*  132 */   public static Color clEntiteTextType2 = Color.BLACK;
/*  133 */   public static Color clEntiteTextTaille2 = Color.BLACK;
/*  134 */   public static Color clEntiteTextTailleDec2 = Color.BLACK;
/*  135 */   public static Color clEntiteTextCode2 = Color.BLACK;
/*      */   
/*  137 */   public static Color clEntiteFondTitre2 = new Color(205, 205, 205);
/*  138 */   public static Color clEntiteTextTitre2 = Color.BLACK;
/*  139 */   public static Color clLienActiver2 = Color.ORANGE;
/*  140 */   public static Color clPrk2 = new Color(250, 250, 250);
/*      */   
/*      */ 
/*  143 */   public static Color clRelationCadre2 = Color.BLACK;
/*  144 */   public static Color clRelationFond2 = Color.WHITE;
/*  145 */   public static Color clRelationText2 = Color.BLACK;
/*  146 */   public static Color clRelationTextType2 = Color.BLACK;
/*  147 */   public static Color clRelationTextTaille2 = Color.BLACK;
/*  148 */   public static Color clRelationTextTailleDec2 = Color.BLACK;
/*  149 */   public static Color clRelationTextCode2 = Color.BLACK;
/*      */   
/*  151 */   public static Color clRelationFondTitre2 = new Color(230, 230, 230);
/*  152 */   public static Color clRelationTextTitre2 = Color.BLACK;
/*  153 */   public static Color clLienActiverRelation2 = Color.GREEN;
/*      */   
/*  155 */   public static Color clLien2 = Color.BLACK;
/*  156 */   public static Color clLienText2 = Color.BLACK;
/*  157 */   public static Color clLienNom2 = Color.BLACK;
/*  158 */   public static Color clLienNomCardinalite2 = Color.BLACK;
/*  159 */   public static Color clLienFondCardinalite2 = Color.WHITE;
/*      */   
/*  161 */   public static Color clCIFCadre2 = Color.BLACK;
/*  162 */   public static Color clCIFFond2 = Color.WHITE;
/*  163 */   public static Color clCIFText2 = Color.BLACK;
/*  164 */   public static Color clLienActiverCIF2 = Color.YELLOW;
/*      */   
/*  166 */   public static Color clLienCIF2 = Color.BLACK;
/*  167 */   public static Color clLienTextCIF2 = Color.BLACK;
/*  168 */   public static Color clLienNomCIF2 = Color.BLACK;
/*      */   
/*  170 */   public static Color clContrainteCadre2 = Color.BLACK;
/*  171 */   public static Color clContrainteFond2 = Color.WHITE;
/*  172 */   public static Color clContrainteText2 = Color.BLACK;
/*      */   
/*  174 */   public static Color clLienContrainte2 = Color.BLACK;
/*  175 */   public static Color clLienTextContrainte2 = Color.BLACK;
/*  176 */   public static Color clLienNomContrainte2 = Color.BLACK;
/*  177 */   public static Color clLienActiverContainte2 = Color.YELLOW;
/*      */   
/*  179 */   public static Color clCommentaireCadre2 = Color.WHITE;
/*  180 */   public static Color clCommentaireFond2 = Color.WHITE;
/*  181 */   public static Color clCommentaireText2 = Color.BLACK;
/*      */   
/*  183 */   public static Color clLienCommentaire2 = Color.GRAY;
/*      */   
/*  185 */   public static Color clPostItCadre2 = new Color(255, 255, 103);
/*  186 */   public static Color clPostItFond2 = new Color(255, 255, 103);
/*  187 */   public static Color clPostItText2 = Color.BLACK;
/*  188 */   public static Color clPostItPunaise2 = Color.BLACK;
/*      */   
/*  190 */   public static Color clHeritageCadre2 = Color.BLACK;
/*  191 */   public static Color clHeritageFond2 = Color.WHITE;
/*  192 */   public static Color clHeritageText2 = Color.BLACK;
/*  193 */   public static Color clLienActiverHeritage2 = Color.YELLOW;
/*      */   
/*  195 */   public static Color clLienHeritage2 = Color.BLACK;
/*      */   
/*  197 */   public static Color clLienNomHeritage2 = Color.BLACK;
/*  198 */   public static Color clLienFondNomHeritage2 = Color.WHITE;
/*  199 */   public static Color clPage2 = Color.WHITE;
/*  200 */   public static Color clOmbre2 = Color.GRAY;
/*      */   
/*  202 */   public static Color clSelected = Color.RED;
/*      */   
/*      */ 
/*  205 */   public static String aligner = "GAUCHE";
/*  206 */   public static String alignerPostIt = "GAUCHE";
/*  207 */   public static String alignerCommentaire = "GAUCHE";
/*      */   
/*  209 */   public static double zoom = 1.0D;
/*  210 */   public static boolean isOmbree2 = false;
/*  211 */   public static boolean isDegradee2 = false;
/*      */   
/*      */ 
/*  214 */   public static boolean cardinaliteMajuscule2 = false;
/*  215 */   public static boolean cardinalite2points2 = false;
/*      */   
/*  217 */   public static boolean afficheType2 = true;
/*      */   
/*  219 */   public static boolean afficherPrk2 = true;
/*  220 */   public static boolean afficherPrkImage2 = true;
/*  221 */   public static boolean typeMajuscule2 = true;
/*  222 */   public static float interLigne2 = 1.15F;
/*      */   
/*  224 */   public static float traitEntiteRelation2 = 1.0F;
/*  225 */   public static float lienEntiteRelation2 = FormeProprieteMCD2.EPAISSEUR_MOYEN;
/*  226 */   public static float traitContraintes2 = 1.0F;
/*  227 */   public static float lienContraintes2 = FormeProprieteMCD2.EPAISSEUR_MOYEN;
/*  228 */   public static boolean arrondirEntite2 = true;
/*      */   
/*      */ 
/*      */ 
/*      */   public FormeInterneMCD(Principale formePrincipale, IhmProjet projet)
/*      */   {
/*  234 */     super(formePrincipale);
/*  235 */     formePrincipale = formePrincipale;
/*      */     
/*  237 */     this.projet = projet;
/*  238 */     this.connexion = new Connexion();
/*  239 */     this.page = new IhmPageMCD(formePrincipale.getBar(), formePrincipale, this, formePrincipale.getStatutBar());
/*  240 */     this.page.setAutoscrolls(true);
/*      */     
/*      */ 
/*  243 */     JScrollPane sc = new JScrollPane();
/*  244 */     sc.setViewportView(this.page);
/*      */     
/*  246 */     this.nomFichier = "";
/*  247 */     this.cheminFichier = "";
/*      */     
/*  249 */     sc.setViewportView(this.page);
/*  250 */     getContentPane().setLayout(new java.awt.BorderLayout());
/*  251 */     getContentPane().add(sc, "Center");
/*  252 */     getContentPane().add(sc);
/*      */     
/*  254 */     this.racineMCD = new NodeRootMCD(this);
/*  255 */     this.entiteNode = new NodeRootEntite();
/*  256 */     this.relationNode = new NodeRootRelation();
/*      */     
/*  258 */     this.racineMCD.add(this.entiteNode);
/*  259 */     this.racineMCD.add(this.relationNode);
/*  260 */     this.modifier = false;
/*  261 */     setSize(900, 500);
/*  262 */     this.config = new ConfigSave(formePrincipale.isTailleVariable(), formePrincipale.isOmbre(), formePrincipale.isClDegradee(), Parametres.etatColor1, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
/*  263 */     this.config.setEtatColor(etatColor);
/*  264 */     setTitle("MCD");
/*  265 */     initColorNewMCD();
/*  266 */     getPage().zoom = Double.parseDouble(formePrincipale.getBar().getjLabPrZoom().getText());
/*  267 */     setFrameIcon(new ImageIcon(getClass().getResource("/Images/lienP.PNG")));
/*      */     
/*  269 */     DropTarget cible = new DropTarget(getPage(), getPage());
/*  270 */     cible.setActive(true);
/*      */     
/*  272 */     addInternalFrameListener(new InternalFrameListener()
/*      */     {
/*      */       public void internalFrameOpened(InternalFrameEvent e) {}
/*      */       
/*      */ 
/*      */ 
/*      */       public void internalFrameClosing(InternalFrameEvent e) {}
/*      */       
/*      */ 
/*      */ 
/*      */       public void internalFrameClosed(InternalFrameEvent e) {}
/*      */       
/*      */ 
/*      */       public void internalFrameIconified(InternalFrameEvent e)
/*      */       {
/*  287 */         FormeInterneMCD.this.setFrameIcon(new ImageIcon(getClass().getResource("/Images/lien24.png")));
/*      */       }
/*      */       
/*      */       public void internalFrameDeiconified(InternalFrameEvent e) {
/*  291 */         FormeInterneMCD.this.setFrameIcon(new ImageIcon(getClass().getResource("/Images/lienP.PNG")));
/*      */       }
/*      */       
/*      */       public void internalFrameActivated(InternalFrameEvent e) {
/*  295 */         FormeInterneMCD.this.getPage().requestFocus();
/*  296 */         FormeInterneMCD.this.getFormePrincipale().setProjetMain(FormeInterneMCD.this.getProjet());
/*  297 */         FormeInterneMCD.this.toFront();
/*  298 */         FormeInterneMCD.this.setTitle("MCD : " + FormeInterneMCD.this.getProjet().toString());
/*  299 */         FormeInterneMCD.this.getFormePrincipale().getPanelLoupe().setFrmInterne(FormeInterneMCD.this.getFormeMCD());
/*  300 */         FormeInterneMCD.this.initialiserParametreMCD(FormeInterneMCD.this.getPage().getConfigurationMCD());
/*  301 */         System.gc();
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */       public void internalFrameDeactivated(InternalFrameEvent e) {}
/*  307 */     });
/*  308 */     getPage().requestFocus();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void initColorNewMCD()
/*      */   {
/*  315 */     if (clCIFCadre == null) {
/*  316 */       if (etatColor.equals(Parametres.etatAUCUNEColor)) {
/*  317 */         initialiserAucuneColor();
/*      */       }
/*      */       else {
/*  320 */         initialiserDefaultColor();
/*      */       }
/*      */     }
/*  323 */     this.config.setEtatColor(etatColor);
/*  324 */     this.config.setClCIFCadre(getCouleurSt(clCIFCadre));
/*  325 */     this.config.setClCIFFond(getCouleurSt(clCIFFond));
/*  326 */     this.config.setClCIFText(getCouleurSt(clCIFText));
/*      */     
/*  328 */     this.config.setClEntiteCadre(getCouleurSt(clEntiteCadre));
/*  329 */     this.config.setClEntiteFond(getCouleurSt(clEntiteFond));
/*  330 */     this.config.setClEntiteText(getCouleurSt(clEntiteText));
/*      */     
/*  332 */     this.config.setClRelationCadre(getCouleurSt(clRelationCadre));
/*  333 */     this.config.setClRelationFond(getCouleurSt(clRelationFond));
/*  334 */     this.config.setClRelationText(getCouleurSt(clRelationText));
/*      */     
/*  336 */     this.config.setClContrainteCadre(getCouleurSt(clContrainteCadre));
/*  337 */     this.config.setClContrainteFond(getCouleurSt(clContrainteFond));
/*  338 */     this.config.setClContrainteText(getCouleurSt(clContrainteText));
/*      */     
/*  340 */     this.config.setClLien(getCouleurSt(clLien));
/*  341 */     this.config.setClLienCnt(getCouleurSt(clLienCnt));
/*  342 */     this.config.setClString(getCouleurSt(clString));
/*      */   }
/*      */   
/*      */   public void setClPage(Color cl) {
/*  346 */     for (int i = 0; i < getPage().getListeLien().size(); i++) {
/*  347 */       ((IhmLien2)getPage().getListeLien().get(i)).getCardinalites().setClFond2(cl);
/*      */     }
/*  349 */     for (int i = 0; i < getPage().getListeLienContrainteHeritage().size(); i++) {
/*  350 */       ((IhmLienContrainteHeritage2)getPage().getListeLienContrainteHeritage().get(i)).setClLienFondNom(cl);
/*      */     }
/*  352 */     clPage2 = cl;
/*  353 */     getPage().clPage = cl;
/*  354 */     clLienFondNomHeritage2 = cl;
/*  355 */     clLienFondCardinalite2 = cl;
/*      */   }
/*      */   
/*      */   public void modifierParametreMCD(boolean isOmbre, boolean istype, boolean isDegradee, boolean isArrondi) {
/*  359 */     ConfigurationMCD2 conf = this.page.getConfigurationMCD();
/*  360 */     conf.isDegradee2 = isDegradee;
/*  361 */     conf.isOmbree2 = isOmbre;
/*  362 */     conf.afficheType2 = istype;
/*  363 */     conf.arrondirEntite2 = isArrondi;
/*      */     
/*  365 */     isDegradee2 = isDegradee;
/*  366 */     isOmbree2 = isOmbre;
/*  367 */     afficheType2 = istype;
/*  368 */     arrondirEntite2 = isArrondi;
/*  369 */     setModifier(true);
/*  370 */     for (int i = 0; i < this.page.getListeEntiteRelation().size(); i++) {
/*  371 */       if ((this.page.getListeEntiteRelation().get(i) instanceof IhmEntite2))
/*      */       {
/*  373 */         ((IhmEntite2)this.page.getListeEntiteRelation().get(i)).setVariable(conf.afficheType2);
/*  374 */         ((IhmEntite2)this.page.getListeEntiteRelation().get(i)).setOmbre(conf.isOmbree2);
/*  375 */         ((IhmEntite2)this.page.getListeEntiteRelation().get(i)).setClDegradee(conf.isDegradee2);
/*  376 */         ((IhmEntite2)this.page.getListeEntiteRelation().get(i)).setArrondir(conf.arrondirEntite2);
/*      */ 
/*      */       }
/*  379 */       else if ((this.page.getListeEntiteRelation().get(i) instanceof IhmRelation2))
/*      */       {
/*  381 */         ((IhmRelation2)this.page.getListeEntiteRelation().get(i)).setVariable(conf.afficheType2);
/*  382 */         ((IhmRelation2)this.page.getListeEntiteRelation().get(i)).setOmbre(conf.isOmbree2);
/*  383 */         ((IhmRelation2)this.page.getListeEntiteRelation().get(i)).setClDegradee(conf.isDegradee2);
/*      */       }
/*      */     }
/*      */     
/*  387 */     for (int i = 0; i < this.page.getListeCIF().size(); i++) {
/*  388 */       ((IhmCIF2)this.page.getListeCIF().get(i)).setOmbre(conf.isOmbree2);
/*  389 */       ((IhmCIF2)this.page.getListeCIF().get(i)).setClDegradee(conf.isDegradee2);
/*      */     }
/*      */     
/*      */ 
/*  393 */     for (int i = 0; i < this.page.getListeContrainte().size(); i++) {
/*  394 */       ((IhmContrainte2)this.page.getListeContrainte().get(i)).setOmbre(conf.isOmbree2);
/*  395 */       ((IhmContrainte2)this.page.getListeContrainte().get(i)).setClDegradee(conf.isDegradee2);
/*      */     }
/*      */     
/*      */ 
/*  399 */     for (int i = 0; i < this.page.getListeHeritage().size(); i++) {
/*  400 */       ((IhmHeritage2)this.page.getListeHeritage().get(i)).setOmbre(conf.isOmbree2);
/*  401 */       ((IhmHeritage2)this.page.getListeHeritage().get(i)).setClDegradee(conf.isDegradee2);
/*      */     }
/*      */     
/*      */ 
/*  405 */     for (int i = 0; i < this.page.getListeCommentaire().size(); i++) {
/*  406 */       if ((this.page.getListeCommentaire().get(i) instanceof IhmCommentaire2)) {
/*  407 */         ((IhmCommentaire2)this.page.getListeCommentaire().get(i)).setOmbre(conf.isOmbree2);
/*  408 */         ((IhmCommentaire2)this.page.getListeCommentaire().get(i)).setClDegradee(conf.isDegradee2);
/*      */       }
/*  410 */       else if ((this.page.getListeCommentaire().get(i) instanceof IhmPostIt2)) {
/*  411 */         ((IhmPostIt2)this.page.getListeCommentaire().get(i)).setClDegradee(conf.isDegradee2);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void initialiserParametreMCD(ConfigurationMCD2 conf)
/*      */   {
/*  420 */     clEntiteCadre2 = ConfigurationMCD2.getColor(conf.clEntiteCadre2);
/*  421 */     clEntiteFond2 = ConfigurationMCD2.getColor(conf.clEntiteFond2);
/*  422 */     clEntiteText2 = ConfigurationMCD2.getColor(conf.clEntiteText2);
/*  423 */     clEntiteTextType2 = ConfigurationMCD2.getColor(conf.clEntiteTextType2);
/*  424 */     clEntiteTextTaille2 = ConfigurationMCD2.getColor(conf.clEntiteTextTaille2);
/*  425 */     clEntiteTextTailleDec2 = ConfigurationMCD2.getColor(conf.clEntiteTextTailleDec2);
/*  426 */     clEntiteTextCode2 = ConfigurationMCD2.getColor(conf.clEntiteTextCode2);
/*      */     
/*  428 */     clPrk2 = ConfigurationMCD2.getColor(conf.clPrk2);
/*      */     
/*  430 */     clEntiteFondTitre2 = ConfigurationMCD2.getColor(conf.clEntiteFondTitre2);
/*  431 */     clEntiteTextTitre2 = ConfigurationMCD2.getColor(conf.clEntiteTextTitre2);
/*  432 */     clLienActiver2 = ConfigurationMCD2.getColor(conf.clLienActiver2);
/*      */     
/*  434 */     clRelationCadre2 = ConfigurationMCD2.getColor(conf.clRelationCadre2);
/*  435 */     clRelationFond2 = ConfigurationMCD2.getColor(conf.clRelationFond2);
/*  436 */     clRelationText2 = ConfigurationMCD2.getColor(conf.clRelationText2);
/*  437 */     clRelationTextType2 = ConfigurationMCD2.getColor(conf.clRelationTextType2);
/*  438 */     clRelationFondTitre2 = ConfigurationMCD2.getColor(conf.clRelationFondTitre2);
/*  439 */     clRelationTextTitre2 = ConfigurationMCD2.getColor(conf.clRelationTextTitre2);
/*  440 */     clRelationTextTaille2 = ConfigurationMCD2.getColor(conf.clRelationTextTaille2);
/*  441 */     clRelationTextTailleDec2 = ConfigurationMCD2.getColor(conf.clRelationTextTailleDec2);
/*  442 */     clRelationTextCode2 = ConfigurationMCD2.getColor(conf.clRelationTextCode2);
/*      */     
/*  444 */     clLienActiverRelation2 = ConfigurationMCD2.getColor(conf.clLienActiverRelation2);
/*      */     
/*  446 */     clSelected = ConfigurationMCD2.getColor(conf.clSelected);
/*      */     
/*  448 */     clLien2 = ConfigurationMCD2.getColor(conf.clLien2);
/*  449 */     clLienText2 = ConfigurationMCD2.getColor(conf.clLienText2);
/*  450 */     clLienNom2 = ConfigurationMCD2.getColor(conf.clLienNom2);
/*  451 */     clLienNomCardinalite2 = ConfigurationMCD2.getColor(conf.clLienNomCardinalite2);
/*  452 */     clLienFondCardinalite2 = ConfigurationMCD2.getColor(conf.clLienFondCardinalite2);
/*      */     
/*  454 */     clCIFCadre2 = ConfigurationMCD2.getColor(conf.clCIFCadre2);
/*  455 */     clCIFFond2 = ConfigurationMCD2.getColor(conf.clCIFFond2);
/*  456 */     clCIFText2 = ConfigurationMCD2.getColor(conf.clCIFText2);
/*  457 */     clLienActiverCIF2 = ConfigurationMCD2.getColor(conf.clLienActiverCIF2);
/*      */     
/*  459 */     clLienCIF2 = ConfigurationMCD2.getColor(conf.clLienCIF2);
/*  460 */     clLienTextCIF2 = ConfigurationMCD2.getColor(conf.clLienTextCIF2);
/*  461 */     clLienNomCIF2 = ConfigurationMCD2.getColor(conf.clLienNomCIF2);
/*      */     
/*  463 */     clContrainteCadre2 = ConfigurationMCD2.getColor(conf.clContrainteCadre2);
/*  464 */     clContrainteFond2 = ConfigurationMCD2.getColor(conf.clContrainteFond2);
/*  465 */     clContrainteText2 = ConfigurationMCD2.getColor(conf.clContrainteText2);
/*      */     
/*  467 */     clLienContrainte2 = ConfigurationMCD2.getColor(conf.clLienContrainte2);
/*  468 */     clLienTextContrainte2 = ConfigurationMCD2.getColor(conf.clLienTextContrainte2);
/*  469 */     clLienNomContrainte2 = ConfigurationMCD2.getColor(conf.clLienNomContrainte2);
/*  470 */     clLienActiverContainte2 = ConfigurationMCD2.getColor(conf.clLienActiverContainte2);
/*      */     
/*  472 */     clCommentaireCadre2 = ConfigurationMCD2.getColor(conf.clCommentaireCadre2);
/*  473 */     clCommentaireFond2 = ConfigurationMCD2.getColor(conf.clCommentaireFond2);
/*  474 */     clCommentaireText2 = ConfigurationMCD2.getColor(conf.clCommentaireText2);
/*  475 */     clLienCommentaire2 = ConfigurationMCD2.getColor(conf.clLienCommentaire2);
/*      */     
/*      */ 
/*  478 */     clPostItCadre2 = ConfigurationMCD2.getColor(conf.clPostItCadre2);
/*  479 */     clPostItFond2 = ConfigurationMCD2.getColor(conf.clPostItFond2);
/*  480 */     clPostItText2 = ConfigurationMCD2.getColor(conf.clPostItText2);
/*  481 */     clPostItPunaise2 = ConfigurationMCD2.getColor(conf.clPostItPunaise2);
/*      */     
/*  483 */     clHeritageCadre2 = ConfigurationMCD2.getColor(conf.clHeritageCadre2);
/*  484 */     clHeritageFond2 = ConfigurationMCD2.getColor(conf.clHeritageFond2);
/*  485 */     clHeritageText2 = ConfigurationMCD2.getColor(conf.clHeritageText2);
/*  486 */     clLienActiverHeritage2 = ConfigurationMCD2.getColor(conf.clLienActiverHeritage2);
/*      */     
/*  488 */     clLienHeritage2 = ConfigurationMCD2.getColor(conf.clLienHeritage2);
/*      */     
/*  490 */     clLienNomHeritage2 = ConfigurationMCD2.getColor(conf.clLienNomHeritage2);
/*  491 */     clLienFondNomHeritage2 = ConfigurationMCD2.getColor(conf.clLienFondNomHeritage2);
/*  492 */     clPage2 = ConfigurationMCD2.getColor(conf.clPage2);
/*  493 */     clOmbre2 = ConfigurationMCD2.getColor(conf.clOmbre2);
/*      */     
/*  495 */     isOmbree2 = conf.isOmbree2;
/*  496 */     isDegradee2 = conf.isDegradee2;
/*      */     
/*  498 */     aligner = conf.aligner;
/*  499 */     alignerPostIt = conf.alignerPostIt;
/*  500 */     alignerCommentaire = conf.alignerCommentaire;
/*  501 */     zoom = conf.zoom;
/*      */     
/*  503 */     cardinaliteMajuscule2 = conf.cardinaliteMajuscule2;
/*  504 */     cardinalite2points2 = conf.cardinalite2points2;
/*  505 */     afficheType2 = conf.afficheType2;
/*      */     
/*  507 */     afficherPrk2 = conf.afficherPrk2;
/*  508 */     afficherPrkImage2 = conf.afficherPrkImage2;
/*      */     
/*  510 */     typeMajuscule2 = conf.typeMajuscule2;
/*  511 */     interLigne2 = conf.interLigne2;
/*      */     
/*  513 */     traitEntiteRelation2 = conf.traitEntiteRelation2;
/*  514 */     lienEntiteRelation2 = conf.lienEntiteRelation2;
/*  515 */     traitContraintes2 = conf.traitContraintes2;
/*  516 */     lienContraintes2 = conf.lienContraintes2;
/*  517 */     arrondirEntite2 = conf.arrondirEntite2;
/*  518 */     formePrincipale.setMenuDegradeeOmbreTypeArrondir(isDegradee2, afficheType2, isOmbree2, arrondirEntite2);
/*  519 */     formePrincipale.getBar().setZoomPage(this.page.zoom);
/*  520 */     setClPage(clPage2);
/*      */     
/*  522 */     this.page.ihmProprieteMCD2.setX(conf.xPropriete);
/*  523 */     this.page.ihmProprieteMCD2.setY(conf.yPropriete);
/*      */   }
/*      */   
/*      */   public ConfigurationMCD2 miseAjourParametreMCD(ConfigurationMCD2 conf)
/*      */   {
/*  528 */     conf.clEntiteCadre2 = ConfigurationMCD2.getColor(clEntiteCadre2);
/*  529 */     conf.clEntiteFond2 = ConfigurationMCD2.getColor(clEntiteFond2);
/*  530 */     conf.clEntiteText2 = ConfigurationMCD2.getColor(clEntiteText2);
/*  531 */     conf.clEntiteTextType2 = ConfigurationMCD2.getColor(clEntiteTextType2);
/*  532 */     conf.clEntiteTextTaille2 = ConfigurationMCD2.getColor(clEntiteTextTaille2);
/*  533 */     conf.clEntiteTextTailleDec2 = ConfigurationMCD2.getColor(clEntiteTextTailleDec2);
/*  534 */     conf.clEntiteTextCode2 = ConfigurationMCD2.getColor(clEntiteTextCode2);
/*      */     
/*  536 */     conf.clPrk2 = ConfigurationMCD2.getColor(clPrk2);
/*      */     
/*  538 */     conf.clEntiteFondTitre2 = ConfigurationMCD2.getColor(clEntiteFondTitre2);
/*  539 */     conf.clEntiteTextTitre2 = ConfigurationMCD2.getColor(clEntiteTextTitre2);
/*  540 */     conf.clLienActiver2 = ConfigurationMCD2.getColor(clLienActiver2);
/*      */     
/*  542 */     conf.clRelationCadre2 = ConfigurationMCD2.getColor(clRelationCadre2);
/*  543 */     conf.clRelationFond2 = ConfigurationMCD2.getColor(clRelationFond2);
/*  544 */     conf.clRelationText2 = ConfigurationMCD2.getColor(clRelationText2);
/*  545 */     conf.clRelationTextType2 = ConfigurationMCD2.getColor(clRelationTextType2);
/*  546 */     conf.clRelationFondTitre2 = ConfigurationMCD2.getColor(clRelationFondTitre2);
/*  547 */     conf.clRelationTextTitre2 = ConfigurationMCD2.getColor(clRelationTextTitre2);
/*  548 */     conf.clRelationTextTaille2 = ConfigurationMCD2.getColor(clRelationTextTaille2);
/*  549 */     conf.clRelationTextTailleDec2 = ConfigurationMCD2.getColor(clRelationTextTailleDec2);
/*  550 */     conf.clRelationTextCode2 = ConfigurationMCD2.getColor(clRelationTextCode2);
/*      */     
/*  552 */     conf.clLienActiverRelation2 = ConfigurationMCD2.getColor(clLienActiverRelation2);
/*      */     
/*  554 */     conf.clSelected = ConfigurationMCD2.getColor(clSelected);
/*      */     
/*  556 */     conf.clLien2 = ConfigurationMCD2.getColor(clLien2);
/*  557 */     conf.clLienText2 = ConfigurationMCD2.getColor(clLienText2);
/*  558 */     conf.clLienNom2 = ConfigurationMCD2.getColor(clLienNom2);
/*  559 */     conf.clLienNomCardinalite2 = ConfigurationMCD2.getColor(clLienNomCardinalite2);
/*  560 */     conf.clLienFondCardinalite2 = ConfigurationMCD2.getColor(clLienFondCardinalite2);
/*      */     
/*  562 */     conf.clCIFCadre2 = ConfigurationMCD2.getColor(clCIFCadre2);
/*  563 */     conf.clCIFFond2 = ConfigurationMCD2.getColor(clCIFFond2);
/*  564 */     conf.clCIFText2 = ConfigurationMCD2.getColor(clCIFText2);
/*  565 */     conf.clLienActiverCIF2 = ConfigurationMCD2.getColor(clLienActiverCIF2);
/*      */     
/*  567 */     conf.clLienCIF2 = ConfigurationMCD2.getColor(clLienCIF2);
/*  568 */     conf.clLienTextCIF2 = ConfigurationMCD2.getColor(clLienTextCIF2);
/*  569 */     conf.clLienNomCIF2 = ConfigurationMCD2.getColor(clLienNomCIF2);
/*      */     
/*  571 */     conf.clContrainteCadre2 = ConfigurationMCD2.getColor(clContrainteCadre2);
/*  572 */     conf.clContrainteFond2 = ConfigurationMCD2.getColor(clContrainteFond2);
/*  573 */     conf.clContrainteText2 = ConfigurationMCD2.getColor(clContrainteText2);
/*      */     
/*  575 */     conf.clLienContrainte2 = ConfigurationMCD2.getColor(clLienContrainte2);
/*  576 */     conf.clLienTextContrainte2 = ConfigurationMCD2.getColor(clLienTextContrainte2);
/*  577 */     conf.clLienNomContrainte2 = ConfigurationMCD2.getColor(clLienNomContrainte2);
/*  578 */     conf.clLienActiverContainte2 = ConfigurationMCD2.getColor(clLienActiverContainte2);
/*      */     
/*  580 */     conf.clCommentaireCadre2 = ConfigurationMCD2.getColor(clCommentaireCadre2);
/*  581 */     conf.clCommentaireFond2 = ConfigurationMCD2.getColor(clCommentaireFond2);
/*  582 */     conf.clCommentaireText2 = ConfigurationMCD2.getColor(clCommentaireText2);
/*      */     
/*  584 */     conf.clLienCommentaire2 = ConfigurationMCD2.getColor(clLienCommentaire2);
/*      */     
/*  586 */     conf.clPostItCadre2 = ConfigurationMCD2.getColor(clPostItCadre2);
/*  587 */     conf.clPostItFond2 = ConfigurationMCD2.getColor(clPostItFond2);
/*  588 */     conf.clPostItText2 = ConfigurationMCD2.getColor(clPostItText2);
/*  589 */     conf.clPostItPunaise2 = ConfigurationMCD2.getColor(clPostItPunaise2);
/*      */     
/*  591 */     conf.clHeritageCadre2 = ConfigurationMCD2.getColor(clHeritageCadre2);
/*  592 */     conf.clHeritageFond2 = ConfigurationMCD2.getColor(clHeritageFond2);
/*  593 */     conf.clHeritageText2 = ConfigurationMCD2.getColor(clHeritageText2);
/*  594 */     conf.clLienActiverHeritage2 = ConfigurationMCD2.getColor(clLienActiverHeritage2);
/*      */     
/*  596 */     conf.clLienHeritage2 = ConfigurationMCD2.getColor(clLienHeritage2);
/*      */     
/*  598 */     conf.clLienNomHeritage2 = ConfigurationMCD2.getColor(clLienNomHeritage2);
/*  599 */     conf.clLienFondNomHeritage2 = ConfigurationMCD2.getColor(clLienFondNomHeritage2);
/*      */     
/*  601 */     conf.isOmbree2 = isOmbree2;
/*  602 */     conf.isDegradee2 = isDegradee2;
/*      */     
/*  604 */     conf.aligner = aligner;
/*  605 */     conf.alignerPostIt = alignerPostIt;
/*  606 */     conf.alignerCommentaire = alignerCommentaire;
/*  607 */     conf.zoom = zoom;
/*      */     
/*  609 */     conf.cardinaliteMajuscule2 = cardinaliteMajuscule2;
/*  610 */     conf.cardinalite2points2 = cardinalite2points2;
/*  611 */     conf.afficheType2 = afficheType2;
/*      */     
/*  613 */     conf.afficherPrk2 = afficherPrk2;
/*  614 */     conf.afficherPrkImage2 = afficherPrkImage2;
/*      */     
/*  616 */     conf.typeMajuscule2 = typeMajuscule2;
/*  617 */     conf.interLigne2 = interLigne2;
/*      */     
/*  619 */     conf.traitEntiteRelation2 = traitEntiteRelation2;
/*  620 */     conf.lienEntiteRelation2 = lienEntiteRelation2;
/*  621 */     conf.traitContraintes2 = traitContraintes2;
/*  622 */     conf.lienContraintes2 = lienContraintes2;
/*  623 */     conf.clPage2 = ConfigurationMCD2.getColor(clPage2);
/*  624 */     conf.clOmbre2 = ConfigurationMCD2.getColor(clOmbre2);
/*  625 */     conf.arrondirEntite2 = arrondirEntite2;
/*      */     
/*      */ 
/*  628 */     return conf;
/*      */   }
/*      */   
/*      */ 
/*      */   public IhmPageMCD getPage()
/*      */   {
/*  634 */     return this.page;
/*      */   }
/*      */   
/*      */   public static boolean isOmbrePage() {
/*  638 */     return getPrincipale().isOmbreMenu();
/*      */   }
/*      */   
/*      */   public static boolean isClDegradeePage() {
/*  642 */     return getPrincipale().isClDegradee();
/*      */   }
/*      */   
/*      */   private static Principale getPrincipale() {
/*  646 */     return formePrincipale;
/*      */   }
/*      */   
/*      */   public String toString()
/*      */   {
/*  651 */     return getTitle();
/*      */   }
/*      */   
/*      */   public void setModifier(boolean modifier) {
/*  655 */     if (((modifier) && (!this.modifier)) || (!modifier)) {
/*  656 */       getPrincipale().getExplorer().getTree().repaint();
/*      */     }
/*  658 */     if ((modifier) && (!this.modifier)) {
/*  659 */       setTitle(getTitle() + "*");
/*      */     }
/*  661 */     this.modifier = modifier;
/*      */   }
/*      */   
/*      */   public boolean isModifier()
/*      */   {
/*  666 */     return this.modifier;
/*      */   }
/*      */   
/*      */   public String getCheminFichier() {
/*  670 */     return this.cheminFichier;
/*      */   }
/*      */   
/*      */   public String getNomFichier() {
/*  674 */     return this.nomFichier;
/*      */   }
/*      */   
/*      */   public void setCheminFichier(String cheminFichier) {
/*  678 */     this.cheminFichier = cheminFichier;
/*      */   }
/*      */   
/*      */   public void setNomFichier(String nomFichier) {
/*  682 */     this.nomFichier = nomFichier;
/*      */   }
/*      */   
/*      */   public void setPage(IhmPageMCD page) {
/*  686 */     this.page = page;
/*      */   }
/*      */   
/*      */   public ConfigSave getConfig() {
/*  690 */     return this.config;
/*      */   }
/*      */   
/*      */   public void setConfig(ConfigSave config) {
/*  694 */     this.config = config;
/*      */   }
/*      */   
/*      */   public void setFormeMLD(FormeInterneMLD formeMLD) {
/*  698 */     this.formeMLD = formeMLD;
/*      */   }
/*      */   
/*      */   public void setFormeSQL(FormeInterneSQL formeSQL) {
/*  702 */     this.formeSQL = formeSQL;
/*      */   }
/*      */   
/*      */   public void setFormeXML(FormeInterneXML formeXML) {
/*  706 */     this.formeXML = formeXML;
/*      */   }
/*      */   
/*      */   public NodeRootEntite getEntiteNode() {
/*  710 */     return this.entiteNode;
/*      */   }
/*      */   
/*      */   public FormeInterneMLD getFormeMLD() {
/*  714 */     return this.projet.getFormeMLD();
/*      */   }
/*      */   
/*      */   public FormeInterneSQL getFormeSQL() {
/*  718 */     return this.projet.getFormeSQL();
/*      */   }
/*      */   
/*      */   public FormeInterneMCD getFormeMCD() {
/*  722 */     return this;
/*      */   }
/*      */   
/*      */   public FormeInterneXML getFormeXML() {
/*  726 */     return this.projet.getFormeXML();
/*      */   }
/*      */   
/*      */   public NodeRootMCD getRacineMCD() {
/*  730 */     return this.racineMCD;
/*      */   }
/*      */   
/*      */   public NodeRootRelation getRelationNode() {
/*  734 */     return this.relationNode;
/*      */   }
/*      */   
/*      */   public IhmProjet getProjet() {
/*  738 */     return this.projet;
/*      */   }
/*      */   
/*      */   public void setProjet(IhmProjet projet) {
/*  742 */     this.projet = projet;
/*      */   }
/*      */   
/*      */   public void setLesFenetres(FormeInterneSQL formeSQL, FormeInterneMLD formeMLD, FormeInterneXML formeXML) {
/*  746 */     this.formeSQL = formeSQL;
/*  747 */     this.formeMLD = formeMLD;
/*  748 */     this.formeXML = formeXML;
/*      */   }
/*      */   
/*      */   public String prefixNomMCD(String nom)
/*      */   {
/*  753 */     if (!nom.toUpperCase().endsWith(".MCD")) nom = nom + ".mcd";
/*  754 */     return nom;
/*      */   }
/*      */   
/*      */   public String prefixNomJPG(String nom) {
/*  758 */     if ((!nom.endsWith(".png")) && (!nom.endsWith(".jpeg")) && (!nom.endsWith(".jpg"))) {
/*  759 */       nom = nom + ".jpg";
/*      */     }
/*  761 */     return nom;
/*      */   }
/*      */   
/*      */   public boolean isPageMCDVide() {
/*  765 */     if (getPage().getListeEntiteRelation().size() > 0) return false;
/*  766 */     if (getPage().getListeContrainte().size() > 0) return false;
/*  767 */     if (getPage().getListeCommentaire().size() > 0) return false;
/*  768 */     if (getPage().getListeCIF().size() > 0) return false;
/*  769 */     if (getPage().getListeHeritage().size() > 0) return false;
/*  770 */     if (getPage().getListeCadre().size() > 0) return false;
/*  771 */     if (getPage().getListeDomaine().size() > 0) return false;
/*  772 */     if (getPage().getListeAttribut().size() > 0) return false;
/*  773 */     return true;
/*      */   }
/*      */   
/*      */   private void enregistrerParamMLD(ConfigurationMCD2 conf) {
/*  777 */     conf.MLDAfficheType2 = getFormePrincipale().getFormeMLD().afficheType2;
/*  778 */     conf.MLDArrondire2 = getFormePrincipale().getFormeMLD().arrondirEntite2;
/*  779 */     conf.MLDClDegradee2 = getFormePrincipale().getFormeMLD().isDegradee2;
/*  780 */     conf.MLDOmbree2 = getFormePrincipale().getFormeMLD().isOmbree2;
/*  781 */     conf.MLDZoom = getFormePrincipale().getFormeMLD().getPageMld().getZoom();
/*  782 */     conf.MLDclPage = ConfigurationMCD2.getColor(getFormePrincipale().getFormeMLD().getPageMld().getClPage());
/*      */   }
/*      */   
/*      */   private SQLSave enregistrerSQL() {
/*  786 */     SQLSave sql = new SQLSave();
/*  787 */     sql.setCommentaire("");
/*  788 */     sql.setDate(this.page.getConfigurationMCD().getDateJour());
/*  789 */     sql.setDepanne("");
/*  790 */     sql.setScript(getFormePrincipale().getFormeSQL().getPanelsql().getPane().getText());
/*  791 */     sql.setType(getFormePrincipale().getFormeSQL().getPanelsql().getTypeSql());
/*  792 */     sql.setVersion(Parametres.version);
/*  793 */     return sql;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean sauvegarderMCD(String nomFichier)
/*      */   {
/*  801 */     if (!Parametres.checkDate(new java.util.Date())) {
/*  802 */       JOptionPane.showMessageDialog(this, "JM 0.5 Erreur N° SAV6, Une Anomalie est détectée au niveau de la synchronisation !\nVotre MCD ne sera pas sauvegardé ");
/*  803 */       return false;
/*      */     }
/*      */     
/*  806 */     this.page.getConfigurationMCD().addModifiactionHistorique();
/*  807 */     this.page.setConfigurationMCD(miseAjourParametreMCD(this.page.getConfigurationMCD()));
/*  808 */     this.page.getConfigurationMCD().zoom = this.page.getZoom();
/*      */     
/*  810 */     enregistrerParamMLD(this.page.getConfigurationMCD());
/*      */     
/*  812 */     if (!this.page.getConfigurationMCD().isCorrectForSave1()) {
/*  813 */       JOptionPane.showMessageDialog(this, "JM 0.5 Erreur N° SAV7, Une Anomalie est détectée au niveau de la synchronisation !\nVotre MCD ne sera pas sauvegardé ");
/*  814 */       return false;
/*      */     }
/*      */     
/*  817 */     if (!this.page.getConfigurationMCD().isCorrectForSave2()) {
/*  818 */       JOptionPane.showMessageDialog(this, "JM 0.5 Erreur N° SAV8, Une Anomalie est détectée au niveau de la synchronisation !\nVotre MCD ne sera pas sauvegardé ");
/*  819 */       return false;
/*      */     }
/*      */     
/*  822 */     if ((Setting.licence.getNbUsed() % 9 == 8) && 
/*  823 */       (!Setting.licence.isLicence())) {
/*  824 */       JOptionPane.showMessageDialog(this, "Vous utilisez régulièrement JMerise, Pensez à l'ACTIVER", "ACTIVATION", 1);
/*      */     }
/*      */     
/*      */ 
/*      */     try
/*      */     {
/*  830 */       formePrincipale.getStatutBar().getjLabEnregister().setVisible(true);
/*  831 */       formePrincipale.getStatutBar().getjProgEnregister().setVisible(true);
/*  832 */       if ((!Principale.isActiverJMerise()) && 
/*  833 */         (this.formeMLD.getPageMld().getListeMLDEntite().size() > 0)) {
/*  834 */         JOptionPane.showMessageDialog(formePrincipale, "Le MLD et le script SQL seront sauvegardés mais\n ils ne seront pas lus à l'ouverture  ! ");
/*      */       }
/*      */       
/*  837 */       FileOutputStream fichier = new FileOutputStream(nomFichier);
/*  838 */       ObjectOutputStream oos = new ObjectOutputStream(fichier);
/*      */       
/*  840 */       oos.writeObject(getPage().getConfigurationMCD());
/*      */       
/*  842 */       formePrincipale.getStatutBar().getjProgEnregister().setValue(10);
/*      */       
/*  844 */       oos.writeObject(getPage().getListeEntiteRelation());
/*      */       
/*  846 */       formePrincipale.getStatutBar().getjProgEnregister().setValue(20);
/*      */       
/*  848 */       oos.writeObject(getPage().getListeLien());
/*      */       
/*  850 */       formePrincipale.getStatutBar().getjProgEnregister().setValue(30);
/*      */       
/*  852 */       oos.writeObject(getPage().getListeCIF());
/*  853 */       formePrincipale.getStatutBar().getjProgEnregister().setValue(40);
/*      */       
/*  855 */       oos.writeObject(getPage().getListelienCIF());
/*  856 */       formePrincipale.getStatutBar().getjProgEnregister().setValue(45);
/*      */       
/*  858 */       oos.writeObject(getPage().getListeCommentaire());
/*  859 */       formePrincipale.getStatutBar().getjProgEnregister().setValue(50);
/*      */       
/*  861 */       oos.writeObject(getPage().getListeLienCommentaire());
/*      */       
/*  863 */       oos.writeObject(getPage().getListeLienHeritage());
/*  864 */       formePrincipale.getStatutBar().getjProgEnregister().setValue(55);
/*      */       
/*      */ 
/*  867 */       oos.writeObject(getPage().getListeHeritage());
/*  868 */       formePrincipale.getStatutBar().getjProgEnregister().setValue(60);
/*      */       
/*  870 */       oos.writeObject(getPage().getListeLienContrainteHeritage());
/*  871 */       formePrincipale.getStatutBar().getjProgEnregister().setValue(65);
/*      */       
/*      */ 
/*  874 */       oos.writeObject(getPage().getListeContrainte());
/*  875 */       formePrincipale.getStatutBar().getjProgEnregister().setValue(60);
/*      */       
/*  877 */       oos.writeObject(getPage().getListeLienContrainte());
/*  878 */       formePrincipale.getStatutBar().getjProgEnregister().setValue(65);
/*      */       
/*  880 */       oos.writeObject(getPage().getListeCadre());
/*  881 */       formePrincipale.getStatutBar().getjProgEnregister().setValue(70);
/*      */       
/*  883 */       oos.writeObject(getPage().getListeAttribut());
/*  884 */       formePrincipale.getStatutBar().getjProgEnregister().setValue(85);
/*      */       
/*  886 */       oos.writeObject(getPage().getListeDomaine());
/*      */       
/*      */ 
/*  889 */       oos.writeObject(enregistrerSQL());
/*      */       
/*  891 */       oos.writeObject(getFormeMLD().getPageMld().getListeMLDEntite());
/*  892 */       oos.writeObject(getFormeMLD().getPageMld().getListeLien());
/*      */       
/*  894 */       oos.writeObject(getFormeMLD().getPageMld().getListeCadre());
/*  895 */       oos.writeObject(getFormeMLD().getPageMld().getListeCommentaire());
/*  896 */       oos.writeObject(getFormeMLD().getPageMld().getListeLienCommentaire());
/*  897 */       oos.writeObject(getFormeMLD().getPageMld().getListeEntRelContrainte());
/*      */       
/*  899 */       getPage().getProprieteMCD().setDateDerniereUtilisation(getPage().getProprieteMCD().getDateJour());
/*      */       
/*  901 */       formePrincipale.getStatutBar().getjProgEnregister().setValue(100);
/*  902 */       formePrincipale.ajouterUnnouveauFichier(nomFichier);
/*  903 */       this.page.getConfigurationMCD().setChemin(nomFichier);
/*  904 */       setModifier(false);
/*      */       
/*  906 */       oos.flush();
/*  907 */       oos.close();
/*      */     }
/*      */     catch (IOException e) {
/*  910 */       formePrincipale.setCursor(0);
/*  911 */       JOptionPane.showMessageDialog(this, " Une exception est survenue lors de l'ouveture \n" + e.toString(), "Exceptions", 0);
/*  912 */       formePrincipale.getStatutBar().getjLabEnregister().setVisible(false);
/*  913 */       formePrincipale.getStatutBar().getjProgEnregister().setVisible(false);
/*  914 */       return false;
/*      */     }
/*  916 */     formePrincipale.getStatutBar().getjLabEnregister().setVisible(false);
/*  917 */     formePrincipale.getStatutBar().getjProgEnregister().setVisible(false);
/*  918 */     formePrincipale.setCursor(0);
/*      */     
/*      */ 
/*      */ 
/*  922 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void enregistrerMCD()
/*      */   {
/*  931 */     if (getNomFichier().length() == 0) {
/*  932 */       JFileChooser fileCh = new JFileChooser();
/*  933 */       FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichier mcd", new String[] { "mcd" });
/*  934 */       fileCh.setFileFilter(filtre);
/*  935 */       if (getFormePrincipale().getCheminDernierMCD().trim().length() != 0) fileCh.setCurrentDirectory(new File(getFormePrincipale().getCheminDernierMCD()));
/*  936 */       if (fileCh.showSaveDialog(this) == 0) {
/*  937 */         File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/*  938 */         if (!fil.exists()) {
/*  939 */           String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/*  940 */           nomFile = prefixNomMCD(nomFile);
/*  941 */           sauvegarderMCD(nomFile);
/*  942 */           setNomFichier(nomFile);
/*  943 */           setCheminFichier(nomFile);
/*  944 */           formePrincipale.setTitle("JMerise : " + getNomFichier());
/*  945 */           setTitle("MCD : " + getProjet().toString());
/*  946 */           setModifier(false);
/*      */         }
/*  948 */         else if (JOptionPane.showConfirmDialog(this, "Le fichier existe.\n Voulez vous le remplacer ?", "Modification ", 0) == 0) {
/*  949 */           IhmProjet proj = getFormePrincipale().dejaOuvertProjet(fileCh.getSelectedFile().getAbsolutePath());
/*  950 */           if (proj != null) {
/*  951 */             JOptionPane.showMessageDialog(formePrincipale, "Vous ne pouvez pas enregistrer :\n \" " + fileCh.getSelectedFile().getAbsolutePath() + " \" car il est déja ouvert !");
/*  952 */             getPage().setCTRLButton(false);
/*  953 */             repaint();
/*  954 */             return;
/*      */           }
/*  956 */           sauvegarderMCD(fileCh.getSelectedFile().getAbsolutePath());
/*  957 */           setNomFichier(fileCh.getSelectedFile().getAbsolutePath());
/*  958 */           setCheminFichier(getNomFichier());
/*  959 */           formePrincipale.setTitle("JMerise : " + getNomFichier());
/*  960 */           setTitle("MCD : " + getProjet().toString());
/*  961 */           setModifier(false);
/*      */         }
/*      */       }
/*      */     }
/*      */     else {
/*  966 */       sauvegarderMCD(getNomFichier());
/*  967 */       formePrincipale.setTitle("JMerise : " + getNomFichier());
/*  968 */       setTitle("MCD : " + getProjet().toString());
/*  969 */       setModifier(false);
/*      */     }
/*  971 */     getPage().setCTRLButton(false);
/*  972 */     repaint();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public void enregistrerSousMCD()
/*      */   {
/*  980 */     JFileChooser fileCh = new JFileChooser();
/*  981 */     FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichier mcd", new String[] { "mcd" });
/*  982 */     fileCh.setFileFilter(filtre);
/*  983 */     if (getFormePrincipale().getCheminDernierMCD().trim().length() != 0) fileCh.setCurrentDirectory(new File(getFormePrincipale().getCheminDernierMCD()));
/*  984 */     if (fileCh.showSaveDialog(this) == 0) {
/*  985 */       File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/*  986 */       if (!fil.exists()) {
/*  987 */         String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/*  988 */         sauvegarderMCD(nomFile);
/*  989 */         setNomFichier(nomFile);
/*  990 */         setCheminFichier(getNomFichier());
/*  991 */         formePrincipale.setTitle("JMerise : " + getNomFichier());
/*  992 */         setTitle("MCD : " + getProjet().toString());
/*  993 */         setModifier(false);
/*      */       }
/*  995 */       else if (JOptionPane.showConfirmDialog(this, "Le fichier existe.\n Voulez vous le remplacer ?", "Modification ", 0) == 0) {
/*  996 */         IhmProjet proj = getFormePrincipale().dejaOuvertProjet(fileCh.getSelectedFile().getAbsolutePath());
/*  997 */         if (proj != null) {
/*  998 */           JOptionPane.showMessageDialog(formePrincipale, "Vous ne pouvez pas enregistrer sous  :\n \" " + fileCh.getSelectedFile().getAbsolutePath() + " \" car il est déja ouvert !");
/*  999 */           getPage().setCTRLButton(false);
/* 1000 */           repaint();
/* 1001 */           return;
/*      */         }
/* 1003 */         sauvegarderMCD(fileCh.getSelectedFile().getAbsolutePath());
/* 1004 */         setNomFichier(fileCh.getSelectedFile().getAbsolutePath());
/* 1005 */         setCheminFichier(getNomFichier());
/* 1006 */         setModifier(false);
/* 1007 */         formePrincipale.setTitle("JMerise : " + getNomFichier());
/* 1008 */         setTitle("MCD : " + getProjet().toString());
/*      */       }
/*      */     }
/*      */     
/* 1012 */     getPage().setCTRLButton(false);
/* 1013 */     repaint();
/*      */   }
/*      */   
/*      */   public void nouveauMCD() {
/* 1017 */     setVisible(true);
/*      */     try {
/* 1019 */       setIcon(false);
/* 1020 */       setSelected(true);
/*      */     } catch (PropertyVetoException ex) {
/* 1022 */       Logger.getLogger(ExplorerPan.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 1024 */     toFront();
/*      */     
/* 1026 */     if (!isModifier()) {
/* 1027 */       this.page.effacerAllMCD();
/* 1028 */       this.formeMLD.getPageMld().effacerAllEntite();
/* 1029 */       this.formeSQL.getPanelsql().getPane().setText("");
/* 1030 */       this.formeXML.getPanelXML().getPane().setText("");
/* 1031 */       this.page.repaint();
/* 1032 */       setNomFichier("");
/* 1033 */       formePrincipale.setTitle("JMerise :" + getNomFichier());
/* 1034 */       setTitle("MCD : " + getProjet().toString());
/* 1035 */       setModifier(false);
/*      */     }
/* 1037 */     else if (this.page.getListeEntiteRelation().size() > 0) {
/* 1038 */       if (JOptionPane.showConfirmDialog(this, "Voulez vous enregistrer les modifications ?", "Modification ", 0) == 0) {
/* 1039 */         if (getCheminFichier().length() == 0) {
/* 1040 */           JFileChooser fileCh = new JFileChooser();
/* 1041 */           FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichier mcd", new String[] { "mcd" });
/* 1042 */           fileCh.setFileFilter(filtre);
/* 1043 */           if (getFormePrincipale().getCheminDernierMCD().trim().length() != 0) fileCh.setCurrentDirectory(new File(getFormePrincipale().getCheminDernierMCD()));
/* 1044 */           if (fileCh.showSaveDialog(this) == 0) {
/* 1045 */             File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/* 1046 */             String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/* 1047 */             nomFile = prefixNomMCD(nomFile);
/* 1048 */             if (!fil.exists())
/*      */             {
/* 1050 */               sauvegarderMCD(nomFile);
/* 1051 */               this.page.effacerAllMCD();
/* 1052 */               this.page.repaint();
/* 1053 */               setNomFichier("");
/* 1054 */               formePrincipale.setTitle("JMerise :" + getNomFichier());
/* 1055 */               setTitle("MCD : " + getProjet().toString());
/* 1056 */               setModifier(false);
/* 1057 */               this.formeMLD.getPageMld().effacerAllEntite();
/* 1058 */               this.formeSQL.getPanelsql().getPane().setText("");
/* 1059 */               this.formeXML.getPanelXML().getPane().setText("");
/*      */             }
/* 1061 */             else if (JOptionPane.showConfirmDialog(this, "Le fichier existe.\n Voulez vous le remplacer ?", "Modification ", 0) == 0) {
/* 1062 */               sauvegarderMCD(nomFile);
/* 1063 */               this.page.effacerAllMCD();
/* 1064 */               this.page.repaint();
/* 1065 */               setCheminFichier(nomFile);
/* 1066 */               setNomFichier(nomFile);
/* 1067 */               formePrincipale.setTitle("JMerise :" + nomFile);
/* 1068 */               setTitle("MCD : " + getProjet().toString());
/* 1069 */               setModifier(false);
/* 1070 */               this.formeMLD.getPageMld().effacerAllEntite();
/* 1071 */               this.formeSQL.getPanelsql().getPane().setText("");
/* 1072 */               this.formeXML.getPanelXML().getPane().setText("");
/*      */             }
/*      */           }
/*      */         }
/*      */         else {
/* 1077 */           sauvegarderMCD(getNomFichier());
/* 1078 */           this.page.effacerAllMCD();
/* 1079 */           this.page.repaint();
/* 1080 */           setNomFichier("");
/* 1081 */           formePrincipale.setTitle("JMerise :" + getNomFichier());
/* 1082 */           setTitle("MCD : " + getProjet().toString());
/* 1083 */           setModifier(false);
/* 1084 */           this.formeMLD.getPageMld().effacerAllEntite();
/* 1085 */           this.formeSQL.getPanelsql().getPane().setText("");
/* 1086 */           this.formeXML.getPanelXML().getPane().setText("");
/*      */         }
/*      */       } else {
/* 1089 */         this.page.effacerAllMCD();
/* 1090 */         this.page.repaint();
/* 1091 */         setNomFichier("");
/* 1092 */         formePrincipale.setTitle("JMerise :" + getNomFichier());
/* 1093 */         setTitle("MCD : " + getProjet().toString());
/* 1094 */         setModifier(false);
/* 1095 */         this.formeMLD.getPageMld().effacerAllEntite();
/* 1096 */         this.formeSQL.getPanelsql().getPane().setText("");
/* 1097 */         this.formeXML.getPanelXML().getPane().setText("");
/*      */       }
/*      */     } else {
/* 1100 */       this.page.effacerAllMCD();
/* 1101 */       this.page.repaint();
/* 1102 */       setNomFichier("");
/* 1103 */       formePrincipale.setTitle("JMerise :" + getNomFichier());
/* 1104 */       setTitle("MCD : " + getProjet().toString());
/* 1105 */       setModifier(false);
/* 1106 */       this.formeMLD.getPageMld().effacerAllEntite();
/* 1107 */       this.formeSQL.getPanelsql().getPane().setText("");
/* 1108 */       this.formeXML.getPanelXML().getPane().setText("");
/*      */     }
/*      */   }
/*      */   
/*      */   public void ouvrirMCD(boolean first)
/*      */   {
/* 1114 */     if ((isModifier()) && 
/* 1115 */       (JOptionPane.showConfirmDialog(this, "Voulez vous enregistrer les modifications ?", "Ouvrir ", 0) == 0)) {
/* 1116 */       if (getCheminFichier().length() == 0) {
/* 1117 */         JFileChooser fileCh = new JFileChooser();
/* 1118 */         FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichier mcd", new String[] { "mcd" });
/* 1119 */         fileCh.setFileFilter(filtre);
/* 1120 */         if (getFormePrincipale().getCheminDernierMCD().trim().length() != 0) fileCh.setCurrentDirectory(new File(getFormePrincipale().getCheminDernierMCD()));
/* 1121 */         if (fileCh.showSaveDialog(this) == 0) {
/* 1122 */           File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/* 1123 */           String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/* 1124 */           nomFile = prefixNomMCD(nomFile);
/* 1125 */           if (!fil.exists())
/*      */           {
/* 1127 */             sauvegarderMCD(nomFile);
/* 1128 */             this.page.effacerAllMCD();
/* 1129 */             this.page.repaint();
/* 1130 */             setNomFichier("");
/* 1131 */             formePrincipale.setTitle("JMerise :" + getNomFichier());
/* 1132 */             setTitle("MCD : " + getProjet().toString());
/* 1133 */             setModifier(false);
/*      */           }
/* 1135 */           else if (JOptionPane.showConfirmDialog(this, "Le fichier existe.\n Voulez vous le remplacer ?", "Modification ", 0) == 0) {
/* 1136 */             sauvegarderMCD(nomFile);
/* 1137 */             this.page.effacerAllMCD();
/* 1138 */             this.page.repaint();
/* 1139 */             setCheminFichier(nomFile);
/* 1140 */             setNomFichier(nomFile);
/* 1141 */             formePrincipale.setCheminDernierMCD(nomFile);
/* 1142 */             formePrincipale.setTitle("JMerise :" + nomFile);
/* 1143 */             setTitle("MCD : " + getProjet().toString());
/* 1144 */             setModifier(false);
/*      */           }
/*      */         }
/*      */       }
/*      */       else {
/* 1149 */         sauvegarderMCD(getNomFichier());
/* 1150 */         this.page.effacerAllMCD();
/* 1151 */         this.page.repaint();
/* 1152 */         setNomFichier("");
/* 1153 */         formePrincipale.setTitle("JMerise :" + getNomFichier());
/* 1154 */         setTitle("MCD : " + getProjet().toString());
/* 1155 */         setModifier(false);
/*      */       }
/*      */     }
/*      */     
/* 1159 */     JFileChooser fileCh = new JFileChooser();
/* 1160 */     FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichier mcd", new String[] { "mcd" });
/* 1161 */     fileCh.setFileFilter(filtre);
/* 1162 */     if (getFormePrincipale().getCheminDernierMCD().trim().length() != 0) fileCh.setCurrentDirectory(new File(getFormePrincipale().getCheminDernierMCD()));
/* 1163 */     if (fileCh.showOpenDialog(this) == 0) {
/* 1164 */       File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/* 1165 */       if (fil.exists()) {
/* 1166 */         String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/* 1167 */         IhmProjet proj = getFormePrincipale().dejaOuvertProjet(nomFile);
/* 1168 */         if (proj != null) {
/* 1169 */           JOptionPane.showMessageDialog(formePrincipale, "Le MCD : \" " + nomFile + " \" est déja ouvert !");
/* 1170 */           formePrincipale.setProjetMain(proj);
/*      */           try {
/* 1172 */             formePrincipale.getFormeMCD().setIcon(false);
/* 1173 */             formePrincipale.getFormeMCD().toFront();
/*      */           } catch (PropertyVetoException ex) {
/* 1175 */             Logger.getLogger(FormeInterneMCD.class.getName()).log(Level.SEVERE, null, ex);
/*      */           }
/*      */         } else {
/* 1178 */           if (!first) getFormePrincipale().creerNouveauProjet();
/* 1179 */           setCheminFichier(nomFile);
/*      */           try {
/* 1181 */             formePrincipale.getFormeMCD().setIcon(false);
/* 1182 */             formePrincipale.getFormeMCD().toFront();
/* 1183 */             formePrincipale.getFormeMCD().setVisible(true);
/*      */           } catch (PropertyVetoException ex) {
/* 1185 */             Logger.getLogger(FormeInterneMCD.class.getName()).log(Level.SEVERE, null, ex);
/*      */           }
/* 1187 */           new ThreadOuvrir(formePrincipale, nomFile).execute();
/*      */         }
/*      */       } else {
/* 1190 */         JOptionPane.showMessageDialog(formePrincipale, "Le fichier n'existe pas ");
/*      */       }
/*      */     }
/* 1193 */     repaint();
/*      */   }
/*      */   
/*      */   public void ouvrirMCDAvecNomFichier(boolean first, String nomFichierMCD) {
/* 1197 */     if (!first) getFormePrincipale().creerNouveauProjet();
/* 1198 */     setCheminFichier(nomFichierMCD);
/*      */     try {
/* 1200 */       formePrincipale.getFormeMCD().setIcon(false);
/* 1201 */       formePrincipale.getFormeMCD().toFront();
/* 1202 */       formePrincipale.getFormeMCD().setVisible(true);
/*      */     } catch (PropertyVetoException ex) {
/* 1204 */       Logger.getLogger(FormeInterneMCD.class.getName()).log(Level.SEVERE, null, ex);
/*      */     }
/* 1206 */     new ThreadOuvrir(formePrincipale, nomFichierMCD).execute();
/*      */   }
/*      */   
/*      */   public void importerAnalyseSIMCD(boolean first) {
/* 1210 */     if ((isModifier()) && 
/* 1211 */       (JOptionPane.showConfirmDialog(formePrincipale, "Voulez vous enregistrer les modifications ?", "Ouvrir ", 0) == 0)) {
/* 1212 */       if (getCheminFichier().length() == 0) {
/* 1213 */         JFileChooser fileCh = new JFileChooser();
/* 1214 */         FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichier mcd", new String[] { "mcd" });
/* 1215 */         fileCh.setFileFilter(filtre);
/* 1216 */         if (getFormePrincipale().getCheminDernierMCD().trim().length() != 0) fileCh.setCurrentDirectory(new File(getFormePrincipale().getCheminDernierMCD()));
/* 1217 */         if (fileCh.showSaveDialog(formePrincipale) == 0) {
/* 1218 */           File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/* 1219 */           String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/* 1220 */           nomFile = prefixNomMCD(nomFile);
/* 1221 */           if (!fil.exists())
/*      */           {
/* 1223 */             sauvegarderMCD(nomFile);
/* 1224 */             this.page.effacerAllMCD();
/* 1225 */             this.page.repaint();
/* 1226 */             setNomFichier("");
/* 1227 */             formePrincipale.setTitle("JMerise :" + getNomFichier());
/* 1228 */             setTitle("MCD : " + getProjet().toString());
/* 1229 */             setModifier(false);
/*      */           }
/* 1231 */           else if (JOptionPane.showConfirmDialog(formePrincipale, "Le fichier existe.\n Voulez vous le remplacer ?", "Modification ", 0) == 0) {
/* 1232 */             sauvegarderMCD(nomFile);
/* 1233 */             this.page.effacerAllMCD();
/* 1234 */             this.page.repaint();
/* 1235 */             setCheminFichier(nomFile);
/* 1236 */             setNomFichier(nomFile);
/* 1237 */             formePrincipale.setTitle("JMerise :" + nomFile);
/* 1238 */             setTitle("MCD : " + getProjet().toString());
/* 1239 */             setModifier(false);
/*      */           }
/*      */         }
/*      */       }
/*      */       else {
/* 1244 */         sauvegarderMCD(getNomFichier());
/* 1245 */         this.page.effacerAllMCD();
/* 1246 */         this.page.repaint();
/* 1247 */         setNomFichier("");
/* 1248 */         formePrincipale.setTitle("JMerise :" + getNomFichier());
/* 1249 */         setTitle("MCD : " + getProjet().toString());
/* 1250 */         setModifier(false);
/*      */       }
/*      */     }
/*      */     
/* 1254 */     JFileChooser fileCh = new JFileChooser();
/* 1255 */     FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichier asi", new String[] { "asi" });
/* 1256 */     fileCh.setFileFilter(filtre);
/* 1257 */     if (getFormePrincipale().getCheminDernierMCD().trim().length() != 0) fileCh.setCurrentDirectory(new File(getFormePrincipale().getCheminDernierMCD()));
/* 1258 */     if (fileCh.showOpenDialog(formePrincipale) == 0) {
/* 1259 */       File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/* 1260 */       if (fil.exists())
/*      */       {
/* 1262 */         if (!first) getFormePrincipale().creerNouveauProjet();
/* 1263 */         String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/* 1264 */         setCheminFichier(nomFile);
/*      */         try {
/* 1266 */           formePrincipale.getFormeMCD().setIcon(false);
/* 1267 */           formePrincipale.getFormeMCD().toFront();
/* 1268 */           formePrincipale.getFormeMCD().setVisible(true);
/*      */         } catch (PropertyVetoException ex) {
/* 1270 */           Logger.getLogger(FormeInterneMCD.class.getName()).log(Level.SEVERE, null, ex);
/*      */         }
/* 1272 */         new ThreadImporterASI(formePrincipale, nomFile).execute();
/* 1273 */         formePrincipale.setTailleVariable(false);
/* 1274 */         formePrincipale.getFormeMCD().getConfig().setIsVariable(false);
/*      */       } else {
/* 1276 */         JOptionPane.showMessageDialog(formePrincipale, "Le fichier n'existe pas ");
/*      */       }
/*      */     }
/* 1279 */     getPage().setCTRLButton(false);
/* 1280 */     repaint();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean fermerMCD()
/*      */   {
/* 1289 */     if (isModifier()) {
/* 1290 */       int retour = JOptionPane.showConfirmDialog(this, "le MCD \"" + (getNomFichier().length() == 0 ? getProjet().toString() : getNomFichier()) + "\" a été modifié, \nVoulez vous l'enregistrer ?", "Fermer MCD", 1);
/*      */       
/*      */ 
/* 1293 */       if (retour == 2) {
/* 1294 */         return false;
/*      */       }
/* 1296 */       if (retour == 0) {
/* 1297 */         if (getCheminFichier().length() == 0) {
/* 1298 */           JFileChooser fileCh = new JFileChooser();
/* 1299 */           FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichier mcd", new String[] { "mcd" });
/* 1300 */           fileCh.setFileFilter(filtre);
/* 1301 */           if (getFormePrincipale().getCheminDernierMCD().trim().length() != 0) fileCh.setCurrentDirectory(new File(getFormePrincipale().getCheminDernierMCD()));
/* 1302 */           if (fileCh.showSaveDialog(formePrincipale) == 0) {
/* 1303 */             File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/* 1304 */             String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/* 1305 */             nomFile = prefixNomMCD(nomFile);
/* 1306 */             if (!fil.exists())
/*      */             {
/* 1308 */               sauvegarderMCD(nomFile);
/*      */               
/* 1310 */               return true;
/*      */             }
/* 1312 */             if (JOptionPane.showConfirmDialog(formePrincipale, "Le fichier existe.\n Voulez vous le remplacer ?", "Modification ", 0) == 0) {
/* 1313 */               sauvegarderMCD(nomFile);
/*      */               
/* 1315 */               return true;
/*      */             }
/* 1317 */             return false;
/*      */           }
/* 1319 */           return false;
/*      */         }
/* 1321 */         sauvegarderMCD(getNomFichier());
/*      */         
/* 1323 */         return true;
/*      */       }
/*      */       
/*      */ 
/* 1327 */       return true;
/*      */     }
/*      */     
/* 1330 */     if (JOptionPane.showConfirmDialog(this, "Voulez vous fermer \n\"" + (getNomFichier().length() == 0 ? getProjet().toString() : getNomFichier()) + "\"  ?", "Fermer MCD ", 0) == 0)
/*      */     {
/* 1332 */       return true;
/*      */     }
/* 1334 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean fermerMCDSansConfirmation()
/*      */   {
/* 1346 */     if (isModifier()) {
/* 1347 */       int retour = JOptionPane.showConfirmDialog(this, "le MCD \"" + (getNomFichier().length() == 0 ? getProjet().toString() : getNomFichier()) + "\" a été modifié, \nVoulez vous l'enregistrer ?", "Fermeture de JMerise", 1);
/*      */       
/*      */ 
/* 1350 */       if (retour == 2) {
/* 1351 */         return false;
/*      */       }
/* 1353 */       if (retour == 0) {
/* 1354 */         if (getCheminFichier().length() == 0) {
/* 1355 */           JFileChooser fileCh = new JFileChooser();
/* 1356 */           FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichier mcd", new String[] { "mcd" });
/* 1357 */           fileCh.setFileFilter(filtre);
/* 1358 */           if (getFormePrincipale().getCheminDernierMCD().trim().length() != 0) fileCh.setCurrentDirectory(new File(getFormePrincipale().getCheminDernierMCD()));
/* 1359 */           if (fileCh.showSaveDialog(formePrincipale) == 0) {
/* 1360 */             File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/* 1361 */             String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/* 1362 */             nomFile = prefixNomMCD(nomFile);
/* 1363 */             if (!fil.exists())
/*      */             {
/* 1365 */               sauvegarderMCD(nomFile);
/* 1366 */               formePrincipale.supprimerProjet(this.projet);
/* 1367 */               return true;
/*      */             }
/* 1369 */             if (JOptionPane.showConfirmDialog(formePrincipale, "Le fichier existe.\n Voulez vous le remplacer ?", "Modification ", 0) == 0) {
/* 1370 */               sauvegarderMCD(nomFile);
/* 1371 */               formePrincipale.supprimerProjet(this.projet);
/* 1372 */             } else { return false;
/*      */             }
/*      */           } else {
/* 1375 */             return false;
/*      */           }
/*      */         } else {
/* 1378 */           sauvegarderMCD(getNomFichier());
/* 1379 */           formePrincipale.supprimerProjet(this.projet);
/* 1380 */           return true;
/*      */         }
/*      */       } else {
/* 1383 */         formePrincipale.supprimerProjet(getProjet());
/* 1384 */         return true;
/*      */       }
/*      */     } else {
/* 1387 */       formePrincipale.supprimerProjet(getProjet());
/* 1388 */       return true;
/*      */     }
/* 1390 */     return true;
/*      */   }
/*      */   
/*      */   public void _afficherPropriete(int x, int y) {
/* 1394 */     this.page.proprieteElementSel();
/*      */     
/* 1396 */     if (this.page.getEntRelaSelect() != null) {
/* 1397 */       if (this.page.getEntRelaSelect().getClass().getName().equals("IhmMCD.IhmEntite"))
/* 1398 */         new FormeEntite(formePrincipale, true, 0, 0, (IhmEntite)this.page.getEntRelaSelect(), this.page.getListeEntiteRelation()).setVisible(true); else
/* 1399 */         new FormeEntite(formePrincipale, true, 0, 0, (IhmRelation)this.page.getEntRelaSelect(), this.page.getListeEntiteRelation()).setVisible(true);
/* 1400 */       formePrincipale.getExplorer().getTree().updateUI();
/* 1401 */       this.page.setCTRLButton(false);
/* 1402 */       return;
/*      */     }
/* 1404 */     if (this.page.getLienSel() != null) {
/* 1405 */       new FormeCardinalite2(formePrincipale, true, (IhmLien2)this.page.getLienSel(), x, y).setVisible(true);
/* 1406 */       this.page.setCTRLButton(false);
/* 1407 */       return;
/*      */     }
/* 1409 */     if (this.page.getCommSelect() != null) {
/* 1410 */       if ((this.page.getCommSelect() instanceof IhmPostIt))
/* 1411 */         new FormePostIt(formePrincipale, true, (IhmPostIt2)this.page.getCommSelect()).setVisible(true); else
/* 1412 */         new FormeCommentaireIndep(formePrincipale, true, this.page.getCommSelect(), x, y).setVisible(true);
/* 1413 */       this.page.setCTRLButton(false);
/* 1414 */       return;
/*      */     }
/* 1416 */     if (this.page.getLienCifSel() != null) {
/* 1417 */       new FormeLienCif(formePrincipale, true, this.page.getLienCifSel(), x, y).setVisible(true);
/* 1418 */       this.page.setCTRLButton(false);
/* 1419 */       return;
/*      */     }
/* 1421 */     if (this.page.getLienHeritageSel() != null) {
/* 1422 */       new FormeLienHeritageIndep(formePrincipale, true, this.page.getLienHeritageSel(), x, y).setVisible(true);
/* 1423 */       this.page.setCTRLButton(false);
/* 1424 */       return;
/*      */     }
/* 1426 */     if (this.page.getContrainteSel() != null) {
/* 1427 */       new FormeContrainte(formePrincipale, true, this.page.getContrainteSel(), x, y).setVisible(true);
/* 1428 */       this.page.setCTRLButton(false);
/* 1429 */       return;
/*      */     }
/* 1431 */     if (this.page.getLienContrSel() != null) {
/* 1432 */       new FormeMLDLien(formePrincipale, true, this.page.getLienContrSel(), x, y).setVisible(true);
/* 1433 */       this.page.setCTRLButton(false);
/* 1434 */       return;
/*      */     }
/* 1436 */     if (this.page.getLienCommSelect() != null) {
/* 1437 */       new FormeMLDLien(formePrincipale, true, this.page.getLienCommSelect(), x, y).setVisible(true);
/* 1438 */       this.page.setCTRLButton(false);
/* 1439 */       return;
/*      */     }
/* 1441 */     if (this.page.getCadreSelect() != null) {
/* 1442 */       new FormeCadre2(formePrincipale, true, (IhmCadre2)this.page.getCadreSelect()).setVisible(true);
/* 1443 */       this.page.setCTRLButton(false);
/* 1444 */       return;
/*      */     }
/* 1446 */     if (this.page.getHeritageSelect() != null) {
/* 1447 */       new FormeContrainteHeritage2(formePrincipale, true, (IhmHeritage2)this.page.getHeritageSelect()).setVisible(true);
/* 1448 */       this.page.setCTRLButton(false);
/* 1449 */       return;
/*      */     }
/*      */     
/* 1452 */     if (this.page.getLienContrHeritageSel() != null) {
/* 1453 */       new FormeLienHeritageContrainte2(formePrincipale, true, (IhmLienContrainteHeritage2)this.page.getLienContrHeritageSel()).setVisible(true);
/* 1454 */       this.page.setCTRLButton(false);
/* 1455 */       return;
/*      */     }
/*      */     
/* 1458 */     new FormeProprieteMCD(formePrincipale, true).setVisible(true);
/* 1459 */     this.page.setCTRLButton(false);
/*      */   }
/*      */   
/*      */   public void afficherPropriete(int x, int y) {
/* 1463 */     getPage().proprieteElementSel();
/* 1464 */     if (this.page.getEntRelaSelect() != null) {
/* 1465 */       if (this.page.getEntRelaSelect().getClass().getName().equals("IhmMCD2.IhmEntite2"))
/* 1466 */         new FormeEntite2(getFormePrincipale(), true, (IhmEntite2)this.page.getEntRelaSelect(), this.page.getListeEntiteRelation()).setVisible(true); else
/* 1467 */         new FormeEntite2(getFormePrincipale(), true, (IhmRelation2)this.page.getEntRelaSelect(), this.page.getListeEntiteRelation()).setVisible(true);
/* 1468 */       getFormePrincipale().getExplorer().getTree().updateUI();
/* 1469 */       this.page.setCTRLButton(false);
/* 1470 */       return;
/*      */     }
/* 1472 */     if (this.page.getCifSelect() != null) {
/* 1473 */       new FormeCIF2(getFormePrincipale(), true, (IhmCIF2)this.page.getCifSelect()).setVisible(true);
/* 1474 */       this.page.setCTRLButton(false);
/* 1475 */       return;
/*      */     }
/*      */     
/* 1478 */     if (this.page.getLienSel() != null) {
/* 1479 */       new FormeCardinalite2(getFormePrincipale(), true, (IhmLien2)this.page.getLienSel(), x, y).setVisible(true);
/* 1480 */       this.page.setCTRLButton(false);
/* 1481 */       return;
/*      */     }
/* 1483 */     if (this.page.getCommSelect() != null) {
/* 1484 */       if ((this.page.getCommSelect() instanceof IhmPostIt))
/* 1485 */         new FormePostIt(getFormePrincipale(), true, (IhmPostIt2)this.page.getCommSelect()).setVisible(true); else
/* 1486 */         new FormeCommentaireIndep(getFormePrincipale(), true, this.page.getCommSelect(), x, y).setVisible(true);
/* 1487 */       this.page.setCTRLButton(false);
/* 1488 */       return;
/*      */     }
/* 1490 */     if (this.page.getLienCifSel() != null) {
/* 1491 */       new FormeLienCif2(getFormePrincipale(), true, (IhmMCD2.IhmLienCIF2)this.page.getLienCifSel(), x, y).setVisible(true);
/* 1492 */       this.page.setCTRLButton(false);
/* 1493 */       return;
/*      */     }
/* 1495 */     if (this.page.getLienHeritageSel() != null) {
/* 1496 */       new FormeLienHeritageIndep(getFormePrincipale(), true, this.page.getLienHeritageSel(), x, y).setVisible(true);
/* 1497 */       this.page.setCTRLButton(false);
/* 1498 */       return;
/*      */     }
/* 1500 */     if (this.page.getContrainteSel() != null) {
/* 1501 */       new FormeContrainte2(getFormePrincipale(), true, (IhmContrainte2)this.page.getContrainteSel(), x, y).setVisible(true);
/* 1502 */       this.page.setCTRLButton(false);
/* 1503 */       return;
/*      */     }
/* 1505 */     if (this.page.getHeritageSelect() != null) {
/* 1506 */       new FormeContrainteHeritage2(getFormePrincipale(), true, (IhmHeritage2)this.page.getHeritageSelect()).setVisible(true);
/* 1507 */       this.page.setCTRLButton(false);
/* 1508 */       return;
/*      */     }
/*      */     
/* 1511 */     if (this.page.getLienContrHeritageSel() != null) {
/* 1512 */       new FormeLienHeritageContrainte2(getFormePrincipale(), true, (IhmLienContrainteHeritage2)this.page.getLienContrHeritageSel()).setVisible(true);
/* 1513 */       this.page.setCTRLButton(false);
/* 1514 */       return;
/*      */     }
/* 1516 */     if (this.page.getLienContrSel() != null) {
/* 1517 */       new FormeLienContraintes2(getFormePrincipale(), true, (IhmMCD2.IhmLienContraintes2)this.page.getLienContrSel()).setVisible(true);
/* 1518 */       this.page.setCTRLButton(false);
/* 1519 */       return;
/*      */     }
/* 1521 */     if (this.page.getLienCommSelect() != null) {
/* 1522 */       new FormeMLDLien(getFormePrincipale(), true, this.page.getLienCommSelect(), x, y).setVisible(true);
/* 1523 */       this.page.setCTRLButton(false);
/* 1524 */       return;
/*      */     }
/* 1526 */     if (this.page.getCadreSelect() != null) {
/* 1527 */       new FormeCadre2(getFormePrincipale(), true, (IhmCadre2)this.page.getCadreSelect()).setVisible(true);
/* 1528 */       this.page.setCTRLButton(false);
/* 1529 */       return;
/*      */     }
/*      */     
/* 1532 */     getFormePrincipale().getProjetSel().getFormeMCD().miseAjourParametreMCD(getFormePrincipale().getProjetSel().getFormeMCD().getPage().getConfigurationMCD());
/* 1533 */     new FormeProprieteMCD2(getFormePrincipale(), true, getFormePrincipale().getProjetSel().getFormeMCD()).setVisible(true);
/*      */     
/* 1535 */     this.page.setCTRLButton(false);
/*      */   }
/*      */   
/*      */   public void rechercherMCD()
/*      */   {
/* 1540 */     FormeRecherche frm = new FormeRecherche(formePrincipale, true, this.page.getListeEntiteRelation());
/* 1541 */     frm.setVisible(true);
/* 1542 */     if ((frm.isResultFermer()) && 
/* 1543 */       (frm.getEntiteSelect() != null)) {
/* 1544 */       this.page.scrollRectToVisible(new java.awt.Rectangle(frm.getEntiteSelect().getX() - 10, frm.getEntiteSelect().getY() - 20, frm.getEntiteSelect().getWidth() + 30, frm.getEntiteSelect().getHeight() + 30));
/* 1545 */       this.page.setSelected(false);
/* 1546 */       frm.getEntiteSelect().setSelected(true);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static void setAllColor()
/*      */   {
/* 1555 */     IhmRelation.setClRelationCadre(clRelationCadre);
/* 1556 */     IhmRelation.setClRelationFond(clRelationFond);
/* 1557 */     IhmRelation.setClString(clRelationText);
/*      */     
/* 1559 */     IhmHeritage.setClRelationCadre(clRelationCadre);
/* 1560 */     IhmHeritage.setClRelationFond(clRelationFond);
/* 1561 */     IhmHeritage.setClString(clRelationText);
/*      */     
/* 1563 */     IhmEntite.setClEntiteCadre(clEntiteCadre);
/* 1564 */     IhmEntite.setClEntiteFond(clEntiteFond);
/* 1565 */     IhmEntite.setClString(clEntiteText);
/*      */     
/* 1567 */     IhmLien.setClLien(clLien);
/* 1568 */     IhmLien.setClLienText(clString);
/* 1569 */     IhmMCD.IhmLienContraintes.setClLien(clLienCnt);
/*      */     
/* 1571 */     IhmCIF.setClCIFCadre(clCIFCadre);
/* 1572 */     IhmCIF.setClCIFFond(clCIFFond);
/* 1573 */     IhmCIF.setClString(clCIFText);
/*      */     
/* 1575 */     IhmContrainte.setClContrainteCadre(clContrainteCadre);
/* 1576 */     IhmContrainte.setClContrainteFond(clContrainteFond);
/* 1577 */     IhmContrainte.setClString(clContrainteText);
/* 1578 */     IhmMCD.IhmLienHeritage.setClLien(clLien);
/* 1579 */     IhmLienContrainteHeritage.setClLien(clLien);
/*      */   }
/*      */   
/*      */   public static void initialiserDefaultColor() {
/* 1583 */     etatColor = Parametres.etatDefautColor;
/* 1584 */     clEntiteCadre = Color.BLUE;
/* 1585 */     clEntiteFond = Color.getHSBColor(100.0F, 100.0F, 100.0F);
/* 1586 */     clEntiteText = Color.BLACK;
/*      */     
/* 1588 */     clRelationCadre = Color.BLUE;
/* 1589 */     clRelationFond = Color.GREEN;
/* 1590 */     clRelationText = Color.BLACK;
/*      */     
/* 1592 */     clCIFCadre = Color.BLUE;
/* 1593 */     clCIFFond = Color.getHSBColor(50.0F, 200.0F, 10.0F);
/* 1594 */     clCIFText = Color.BLACK;
/*      */     
/* 1596 */     clContrainteCadre = Color.BLUE;
/* 1597 */     clContrainteFond = Color.getHSBColor(0.0F, 10.0F, 10.0F);
/* 1598 */     clContrainteText = Color.BLACK;
/*      */     
/* 1600 */     clLien = Color.BLUE;
/* 1601 */     clLienCnt = Color.BLUE;
/* 1602 */     clString = Color.BLACK;
/*      */   }
/*      */   
/*      */   public static void initialiserAucuneColor() {
/*      */     try {
/* 1607 */       etatColor = Parametres.etatAUCUNEColor;
/*      */       
/* 1609 */       clEntiteCadre = Color.BLACK;
/* 1610 */       clEntiteFond = Color.WHITE;
/* 1611 */       clEntiteText = Color.BLACK;
/*      */       
/* 1613 */       clRelationCadre = Color.BLACK;
/* 1614 */       clRelationFond = Color.WHITE;
/* 1615 */       clRelationText = Color.BLACK;
/*      */       
/* 1617 */       clCIFCadre = Color.BLACK;
/* 1618 */       clCIFFond = Color.WHITE;
/* 1619 */       clCIFText = Color.BLACK;
/*      */       
/* 1621 */       clContrainteCadre = Color.BLACK;
/* 1622 */       clContrainteFond = Color.WHITE;
/* 1623 */       clContrainteText = Color.BLACK;
/*      */       
/* 1625 */       clLien = Color.BLACK;
/* 1626 */       clLienCnt = Color.BLACK;
/* 1627 */       clString = Color.BLACK;
/*      */     } catch (Exception ex) {
/* 1629 */       System.out.println("Exception ");
/*      */     }
/*      */   }
/*      */   
/*      */   public static void setEtatColor(String etatColor) {
/* 1634 */     etatColor = etatColor;
/*      */   }
/*      */   
/*      */   public static String getEtatColor() {
/* 1638 */     return etatColor;
/*      */   }
/*      */   
/*      */   public static String getCouleurSt(Color cl) {
/* 1642 */     return cl.getRGB() + "";
/*      */   }
/*      */   
/*      */   public Connexion getConnexion() {
/* 1646 */     return this.connexion;
/*      */   }
/*      */   
/*      */   public void setConnexion(Connexion connexion) {
/* 1650 */     this.connexion = connexion;
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
/*      */   public void initialiserMenu()
/*      */   {
/* 1678 */     setEtatColor(getConfig().getEtatColor() == null ? "AUCUNE" : getConfig().getEtatColor());
/*      */     
/* 1680 */     if (getEtatColor().equals(Parametres.etatAUCUNEColor)) {
/* 1681 */       initialiserAucuneColor();
/*      */     }
/*      */     
/* 1684 */     if (getEtatColor().equals(Parametres.etatDefautColor)) {
/* 1685 */       initialiserDefaultColor();
/*      */     }
/* 1687 */     if (getEtatColor().equals(Parametres.etatAVECColor)) {
/* 1688 */       clEntiteCadre = Parametres.couleurs(getConfig().getClEntiteCadre());
/* 1689 */       clEntiteFond = Parametres.couleurs(getConfig().getClEntiteFond());
/* 1690 */       clEntiteText = Parametres.couleurs(getConfig().getClEntiteText());
/*      */       
/* 1692 */       clRelationCadre = Parametres.couleurs(getConfig().getClRelationCadre());
/* 1693 */       clRelationFond = Parametres.couleurs(getConfig().getClRelationFond());
/* 1694 */       clRelationText = Parametres.couleurs(getConfig().getClRelationText());
/*      */       
/* 1696 */       clCIFCadre = Parametres.couleurs(getConfig().getClCIFCadre());
/* 1697 */       clCIFFond = Parametres.couleurs(getConfig().getClCIFFond());
/* 1698 */       clCIFText = Parametres.couleurs(getConfig().getClCIFText());
/*      */       
/* 1700 */       clContrainteCadre = Parametres.couleurs(getConfig().getClContrainteCadre());
/* 1701 */       clContrainteFond = Parametres.couleurs(getConfig().getClContrainteFond());
/* 1702 */       clContrainteText = Parametres.couleurs(getConfig().getClContrainteText());
/*      */       
/* 1704 */       clLien = Parametres.couleurs(getConfig().getClLien());
/* 1705 */       clLienCnt = Parametres.couleurs(getConfig().getClLienCnt());
/* 1706 */       clString = Parametres.couleurs(getConfig().getClString());
/*      */     }
/* 1708 */     setAllColor();
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\ihm\FormeInterneMCD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */