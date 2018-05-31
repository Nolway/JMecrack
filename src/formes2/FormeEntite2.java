/*      */ package formes2;
/*      */ 
/*      */ import IhmMCD.IhmEntiteRelation;
/*      */ import IhmMCD.IhmLien;
/*      */ import IhmMCD.IhmPageMCD;
/*      */ import IhmMCD.IhmRelation;
/*      */ import IhmMCD2.IhmEntite2;
/*      */ import IhmMCD2.IhmLien2;
/*      */ import IhmMCD2.IhmRelation2;
/*      */ import Merise.Attribut;
/*      */ import Merise.Entite;
/*      */ import Merise.Relation;
/*      */ import Merise2.Attribut2;
/*      */ import Merise2.Entite2;
/*      */ import Merise2.Historique;
/*      */ import Merise2.Relation2;
/*      */ import formes.FormeImporterAttribut;
/*      */ import ihm.FormeInterneMCD;
/*      */ import ihm.Principale;
/*      */ import java.awt.Color;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Font;
/*      */ import java.awt.FontMetrics;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.Rectangle;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.ComponentEvent;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.awt.geom.RoundRectangle2D;
/*      */ import java.util.ArrayList;
/*      */ import javax.swing.BorderFactory;
/*      */ import javax.swing.DefaultCellEditor;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.GroupLayout.Alignment;
/*      */ import javax.swing.GroupLayout.ParallelGroup;
/*      */ import javax.swing.GroupLayout.SequentialGroup;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JCheckBox;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JList;
/*      */ import javax.swing.JOptionPane;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JScrollPane;
/*      */ import javax.swing.JTabbedPane;
/*      */ import javax.swing.JTable;
/*      */ import javax.swing.JTextArea;
/*      */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*      */ import javax.swing.LayoutStyle.ComponentPlacement;
/*      */ import javax.swing.table.TableColumn;
/*      */ import javax.swing.table.TableColumnModel;
/*      */ 
/*      */ public class FormeEntite2 extends javax.swing.JDialog
/*      */ {
/*      */   Principale frm;
/*      */   Object entite;
/*      */   ArrayList<IhmEntiteRelation> listeEntiteRelation;
/*      */   ArrayList<IhmLien> listeLien;
/*   65 */   static int longVarchar = 50;
/*   66 */   static int longChar = 5;
/*      */   ArrayList<Attribut> listeAttribut;
/*      */   ProprieteEntiteTableModel tableModel;
/*      */   boolean modifier;
/*      */   MenuPop.MenuPopTablePropriete menuPop;
/*      */   ProprieteEntiteTableRender tabR;
/*      */   String visualisation;
/*      */   private JButton jBTAjouter;
/*      */   private JButton jBTHistorique;
/*      */   private JButton jBtAnnuler;
/*      */   private JButton jBtDescendre;
/*      */   private JButton jBtDisctioonaire;
/*      */   
/*   79 */   public FormeEntite2(Principale parent, boolean modal, Object entite, ArrayList<IhmEntiteRelation> listeEntiteRelation) { super(parent, modal);
/*   80 */     initComponents();
/*      */     
/*   82 */     this.frm = parent;
/*   83 */     this.entite = entite;
/*   84 */     this.listeEntiteRelation = listeEntiteRelation;
/*   85 */     this.listeAttribut = copierListeAttrbut(entite);
/*   86 */     initialiserLatable();
/*   87 */     initialiserDonnee(entite);
/*   88 */     setLocation(this.frm.getX() + 300, this.frm.getY() + 20);
/*   89 */     this.modifier = false;
/*   90 */     setTitre();
/*   91 */     this.menuPop = new MenuPop.MenuPopTablePropriete(this);
/*   92 */     this.listeLien = new ArrayList();
/*   93 */     remplirListeLien();
/*   94 */     remplirListeLienAprecu();
/*   95 */     this.jBtImporterAttribut.setPreferredSize(new java.awt.Dimension(161, 25));
/*   96 */     this.jBtImporterAttribut.setSize(161, 25);
/*      */     
/*      */ 
/*   99 */     this.visualisation = "";
/*  100 */     this.jTableAttribut.setComponentPopupMenu(this.menuPop);
/*      */     
/*  102 */     this.jBtAnnuler.setMnemonic(65);
/*  103 */     this.jBtValider.setMnemonic(10);
/*      */   }
/*      */   
/*      */   public FormeEntite2(Principale parent, boolean modal, Object entite, ArrayList<IhmEntiteRelation> listeEntiteRelation, String visualiser) {
/*  107 */     super(parent, modal);
/*  108 */     initComponents();
/*  109 */     this.frm = parent;
/*  110 */     this.entite = entite;
/*  111 */     this.listeEntiteRelation = listeEntiteRelation;
/*  112 */     this.listeAttribut = copierListeAttrbut(entite);
/*  113 */     initialiserLatable();
/*  114 */     initialiserDonnee(entite);
/*  115 */     setLocation(this.frm.getX() + 300, this.frm.getY() + 20);
/*  116 */     this.modifier = false;
/*  117 */     setTitre();
/*  118 */     this.menuPop = new MenuPop.MenuPopTablePropriete(this);
/*  119 */     this.listeLien = new ArrayList();
/*  120 */     remplirListeLien();
/*  121 */     remplirListeLienAprecu();
/*  122 */     this.jBtImporterAttribut.setPreferredSize(new java.awt.Dimension(161, 25));
/*  123 */     this.jBtImporterAttribut.setSize(161, 25);
/*      */     
/*      */ 
/*      */ 
/*  127 */     this.jCBAppliquerDefaut.setEnabled(false);
/*  128 */     this.jCBAppliquerAtoute.setEnabled(false);
/*      */     
/*  130 */     this.visualisation = visualiser;
/*      */     
/*  132 */     this.jTableAttribut.setComponentPopupMenu(this.menuPop);
/*  133 */     this.jBtAnnuler.setMnemonic(65);
/*  134 */     this.jBtValider.setMnemonic(10);
/*      */   }
/*      */   
/*      */   private void setTitre() {
/*  138 */     if ((this.entite instanceof IhmEntite2)) {
/*  139 */       setTitle("Propriétés de l'entité : " + ((IhmEntite2)this.entite).getEntite().getNom());
/*  140 */       return;
/*      */     }
/*  142 */     if ((this.entite instanceof IhmRelation2)) {
/*  143 */       setTitle("Propriétés de la relation : " + ((IhmRelation)this.entite).getRelation().getNom());
/*  144 */       return;
/*      */     }
/*  146 */     setTitle("Propriétés de la table");
/*      */   }
/*      */   
/*      */   private void remplirListeLien()
/*      */   {
/*  151 */     if ((this.entite instanceof IhmEntiteRelation)) {
/*  152 */       ArrayList<IhmLien> liste = this.frm.getPage().getListeLien();
/*  153 */       for (int i = 0; i < liste.size(); i++) {
/*  154 */         if ((((IhmLien)liste.get(i)).getEntite() == this.entite) || (((IhmLien)liste.get(i)).getRelation() == this.entite)) {
/*  155 */           this.listeLien.add(liste.get(i));
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> copierListeAttrbut(ArrayList<Attribut> liste, Merise.EntiteRelation ent) {
/*  162 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  164 */     for (int i = 0; i < liste.size(); i++) {
/*  165 */       Attribut2 att = (Attribut2)((Attribut)liste.get(i)).copier();
/*  166 */       att.setUsed(false);
/*  167 */       att.setEntiteRelation(ent);
/*  168 */       l.add(att);
/*      */     }
/*      */     
/*  171 */     return l;
/*      */   }
/*      */   
/*      */   public void corrigerTailleAttribut(ArrayList<Attribut> liste) {
/*  175 */     for (int i = 0; i < liste.size(); i++) {
/*  176 */       if ((((Attribut)liste.get(i)).getLongDecimale() > -1) && 
/*  177 */         (((Attribut)liste.get(i)).getLongueur() == -1)) {
/*  178 */         ((Attribut)liste.get(i)).setLongueur(0);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private ArrayList<Attribut> copierListeAttrbut(Object ent)
/*      */   {
/*  186 */     if ((ent instanceof IhmEntite2)) {
/*  187 */       IhmEntite2 e = (IhmEntite2)ent;
/*  188 */       this.jTFNomEntite.setText(e.getEntite().getNom());
/*  189 */       return copierListeAttrbut(e.getEntite().getListeAttributs(), e.getEntite());
/*      */     }
/*  191 */     if ((ent instanceof IhmRelation)) {
/*  192 */       IhmRelation2 e = (IhmRelation2)ent;
/*  193 */       return copierListeAttrbut(e.getRelation().getListeAttributs(), e.getRelation());
/*      */     }
/*      */     
/*  196 */     if ((ent instanceof IhmMLD.MLDEntite)) {
/*  197 */       IhmEntite2 e = (IhmEntite2)ent;
/*  198 */       return copierListeAttrbut(e.getEntite().getListeAttributs());
/*      */     }
/*  200 */     return new ArrayList();
/*      */   }
/*      */   
/*      */   private void initialiserDonnee(Object ent) {
/*  204 */     if ((ent instanceof IhmEntite2)) {
/*  205 */       initialiserDonnee((IhmEntite2)ent);
/*      */     }
/*  207 */     if ((ent instanceof IhmRelation2)) {
/*  208 */       initialiserDonnee((IhmRelation2)ent);
/*      */     }
/*      */   }
/*      */   
/*      */   private void initialiserDonnee(IhmEntite2 ent) {
/*  213 */     this.jTFNomEntite.setText(ent.getEntite().getNom());
/*  214 */     this.jTFCodeEntite.setText(((Entite2)ent.getEntite()).getCode());
/*  215 */     this.jLabCadreTitre.setBackground(ent.getClCadreTitre2());
/*  216 */     this.jLabTexteTaille.setBackground(ent.getClTextTaille2());
/*  217 */     this.jLabTexteTailleDec.setBackground(ent.getClTextTailleDec2());
/*  218 */     this.jLabFond.setBackground(ent.getClFond2());
/*  219 */     this.jLabFondTitre.setBackground(ent.getClFondTitre2());
/*  220 */     this.jLabLienColor.setBackground(ent.getClLienActiver());
/*  221 */     this.jLabTexte.setBackground(ent.getClText2());
/*  222 */     this.jLabTexteType.setBackground(ent.getClTextType2());
/*  223 */     this.jLabTexteTitre.setBackground(ent.getClTextTitre2());
/*  224 */     if (((Entite2)ent.getEntite()).getHistorisation().equals("H")) {
/*  225 */       this.jCBHistorisation.setSelected(true);
/*      */     } else {
/*  227 */       this.jCBHistorisation.setSelected(false);
/*      */     }
/*  229 */     this.jTAcommentaire.setText(ent.getEntite().getCommentaire());
/*      */     
/*  231 */     this.jTFCreationDev.setText(((Historique)ent.getHistorique().get(0)).getDeveloppeur());
/*  232 */     this.jTFCreation.setText(((Historique)ent.getHistorique().get(0)).getDate());
/*      */     
/*  234 */     this.jTFModificationDev.setText(((Historique)ent.getHistorique().get(ent.getHistorique().size() - 1)).getDeveloppeur());
/*  235 */     this.jTFModification.setText(((Historique)ent.getHistorique().get(ent.getHistorique().size() - 1)).getDate());
/*  236 */     this.jCBAppliquerAtoute.setText("Appliquer à toutes les entités ");
/*      */   }
/*      */   
/*      */   private void initialiserDonnee(IhmRelation2 ent)
/*      */   {
/*  241 */     this.jTFNomEntite.setText(ent.getRelation().getNom());
/*  242 */     this.jTFCodeEntite.setText(((Relation2)ent.getRelation()).getCode());
/*  243 */     this.jLabCadreTitre.setBackground(ent.getClCadreTitre2());
/*  244 */     this.jLabFond.setBackground(ent.getClFond2());
/*      */     
/*  246 */     this.jLabFondTitre.setBackground(ent.getClFondTitre2());
/*  247 */     this.jLabLienColor.setBackground(ent.getClLienActiver());
/*  248 */     this.jLabTexte.setBackground(ent.getClText2());
/*  249 */     this.jLabTexteType.setBackground(ent.getClTextType2());
/*  250 */     this.jLabTexteTitre.setBackground(ent.getClTextTitre2());
/*  251 */     this.jLabTexteTaille.setBackground(ent.getClTextTaille2());
/*  252 */     this.jLabTexteTailleDec.setBackground(ent.getClTextTailleDec2());
/*      */     
/*  254 */     this.jTAcommentaire.setText(ent.getRelation().getCommentaire());
/*      */     
/*  256 */     if (((Relation2)ent.getRelation()).getHistorisation().equals("H")) {
/*  257 */       this.jCBHistorisation.setSelected(true);
/*      */     } else {
/*  259 */       this.jCBHistorisation.setSelected(false);
/*      */     }
/*      */     
/*  262 */     this.jTFCreationDev.setText(((Historique)ent.getHistorique().get(0)).getDeveloppeur());
/*  263 */     this.jTFCreation.setText(((Historique)ent.getHistorique().get(0)).getDate());
/*      */     
/*  265 */     this.jTFModificationDev.setText(((Historique)ent.getHistorique().get(ent.getHistorique().size() - 1)).getDeveloppeur());
/*  266 */     this.jTFModification.setText(((Historique)ent.getHistorique().get(ent.getHistorique().size() - 1)).getDate());
/*  267 */     this.jCBAppliquerAtoute.setText("Appliquer à toutes les relations ");
/*  268 */     this.jCBAppliquerDefaut.setText("Appliquer ces couleurs par défaut pour les relations");
/*      */   }
/*      */   
/*      */   private JComboBox remplirCle() {
/*  272 */     JComboBox comboBox = new JComboBox();
/*  273 */     comboBox.addItem("");
/*  274 */     if ((this.entite instanceof IhmEntite2))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*  279 */       comboBox.addItem("IDENTIFIANT");
/*  280 */       comboBox.addItem("IDENTIFIANT ALTERNATIF");
/*  281 */       comboBox.addItem("INDEX");
/*      */     }
/*      */     
/*  284 */     return comboBox;
/*      */   }
/*      */   
/*      */   public boolean uniqueAttributListe(String att, ArrayList<Attribut> liste) {
/*  288 */     for (int i = 0; i < liste.size(); i++) {
/*  289 */       if (att.trim().toUpperCase().equals(((Attribut)liste.get(i)).getNom().trim().toUpperCase())) return false;
/*      */     }
/*  291 */     return true;
/*      */   }
/*      */   
/*      */   public boolean uniqueAttribut(String att) {
/*  295 */     int n = this.frm.getFormeMCD().getPage().getListeEntiteRelation().size();
/*  296 */     for (int i = 0; i < n; i++) {
/*  297 */       if (((this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i) instanceof IhmEntite2)) && 
/*  298 */         (!uniqueAttributListe(att, ((IhmEntite2)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs()))) {
/*  299 */         return false;
/*      */       }
/*      */       
/*  302 */       if (((this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i) instanceof IhmRelation2)) && 
/*  303 */         (!uniqueAttributListe(att, ((IhmRelation2)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs()))) {
/*  304 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  308 */     return true;
/*      */   }
/*      */   
/*      */   private boolean existeEntiteDansListe() {
/*  312 */     IhmEntite2 ent = (IhmEntite2)this.entite;
/*  313 */     for (int i = 0; i < this.listeEntiteRelation.size(); i++) {
/*  314 */       if ((ent != this.listeEntiteRelation.get(i)) && 
/*  315 */         ((this.listeEntiteRelation.get(i) instanceof IhmEntite2)) && 
/*  316 */         (((IhmEntite2)this.listeEntiteRelation.get(i)).getEntite().getNom().trim().toUpperCase().equals(this.jTFNomEntite.getText().trim().toUpperCase()))) {
/*  317 */         JOptionPane.showMessageDialog(this, "Le nom de l'entité éxiste déjà dans la liste des entités", "Erreur", 0);
/*  318 */         return true;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  323 */     return false;
/*      */   }
/*      */   
/*      */   private boolean nomEntiteVide() {
/*  327 */     if (this.jTFNomEntite.getText().trim().length() == 0)
/*      */     {
/*  329 */       return true;
/*      */     }
/*  331 */     return false;
/*      */   }
/*      */   
/*      */   private Attribut2 existeAttribut(Attribut2 att, int nb) {
/*  335 */     for (int i = nb; i < this.listeAttribut.size(); i++) {
/*  336 */       if ((this.listeAttribut.get(i) != att) && 
/*  337 */         (att.getNom().trim().toUpperCase().equals(((Attribut)this.listeAttribut.get(i)).getNom().trim().toUpperCase()))) {
/*  338 */         return (Attribut2)this.listeAttribut.get(i);
/*      */       }
/*      */     }
/*      */     
/*  342 */     return null;
/*      */   }
/*      */   
/*      */   private Attribut2 existeAttributDansListe(Attribut2 att) {
/*  346 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/*  347 */       if ((this.listeAttribut.get(i) != att) && 
/*  348 */         (att.getNom().trim().toUpperCase().equals(((Attribut)this.listeAttribut.get(i)).getNom().trim().toUpperCase()))) {
/*  349 */         return (Attribut2)this.listeAttribut.get(i);
/*      */       }
/*      */     }
/*      */     
/*  353 */     return null;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean verifierExisteAttribut()
/*      */   {
/*  359 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/*  360 */       Attribut att = existeAttribut((Attribut2)this.listeAttribut.get(i), i + 1);
/*  361 */       if (att != null) {
/*  362 */         JOptionPane.showMessageDialog(this, "La ligne num = " + (i + 1) + "," + att.getNom() + " existe dans la liste au moins deux fois !! ", "Erreur", 0);
/*  363 */         return false;
/*      */       }
/*  365 */       if (Outil.Parametres.isMotReserve(((Attribut)this.listeAttribut.get(i)).getNom().trim()))
/*      */       {
/*  367 */         JOptionPane.showMessageDialog(this, "La ligne num = " + (i + 1) + ", " + ((Attribut)this.listeAttribut.get(i)).getNom() + " Le nom de l'attribut est un mot réservé !! ", "Erreur", 0);
/*  368 */         return false;
/*      */       }
/*      */       
/*  371 */       if (Outil.Parametres.isMotReserve(((Attribut2)this.listeAttribut.get(i)).getCode().trim()))
/*      */       {
/*  373 */         JOptionPane.showMessageDialog(this, "La ligne num = " + (i + 1) + ", " + ((Attribut2)this.listeAttribut.get(i)).getCode() + " Le code de l'attribut est un mot réservé !! ", "Erreur", 0);
/*  374 */         return false;
/*      */       }
/*      */       
/*  377 */       if (Outil.Setting.attUniq) {
/*  378 */         if (!uniqueAttribut(((Attribut)this.listeAttribut.get(i)).getNom().trim())) {
/*  379 */           JOptionPane.showMessageDialog(this, "La ligne num = " + (i + 1) + ", " + ((Attribut)this.listeAttribut.get(i)).getNom() + " Le nom de l'attribut est utilisé dans d'autres entités du MCD : il n'est pas unique !! ", "Erreur", 0);
/*  380 */           return false;
/*      */         }
/*  382 */         if (!uniqueAttribut(((Attribut2)this.listeAttribut.get(i)).getCode().trim())) {
/*  383 */           JOptionPane.showMessageDialog(this, "La ligne num = " + (i + 1) + ", " + ((Attribut2)this.listeAttribut.get(i)).getCode() + " Le code de l'attribut est utilisé dans d'autres entités du MCD : il n'est pas unique !! ", "Erreur", 0);
/*  384 */           return false;
/*      */         }
/*      */       }
/*      */     }
/*  388 */     return true;
/*      */   }
/*      */   
/*      */   private boolean verifierAttributVide()
/*      */   {
/*  393 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/*  394 */       Attribut2 att = (Attribut2)this.listeAttribut.get(i);
/*  395 */       if (att.getNom().trim().length() == 0) {
/*  396 */         JOptionPane.showMessageDialog(this, "La ligne num= " + (i + 1) + ",l'attribut " + att.getNom() + " doit avoir un nom ", "Erreur", 0);
/*  397 */         return false;
/*      */       }
/*  399 */       if ((att.getListeAttributs().size() == 0) && 
/*  400 */         (att.getType().trim().length() == 0)) {
/*  401 */         JOptionPane.showMessageDialog(this, "La ligne num= " + (i + 1) + ",l'attribut " + att.getNom() + " doit avoir un type ", "Erreur", 0);
/*  402 */         return false;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  407 */     return true;
/*      */   }
/*      */   
/*      */   private boolean verifierEntite() {
/*  411 */     if (!nomEntiteVide()) {
/*  412 */       if ((!existeEntiteDansListe()) && 
/*  413 */         (verifierAttributVide()) && 
/*  414 */         (verifierExisteAttribut())) {
/*  415 */         return true;
/*      */       }
/*      */       
/*      */     }
/*      */     else {
/*  420 */       JOptionPane.showMessageDialog(this, "Le nom de l'entité ne doit pas être vide ", "Erreur", 0);
/*      */     }
/*  422 */     return false;
/*      */   }
/*      */   
/*      */   private boolean verifierRelation() {
/*  426 */     if (this.jTFNomEntite.getText().trim().length() > 0) {
/*  427 */       if ((verifierAttributVide()) && 
/*  428 */         (verifierExisteAttribut())) {
/*  429 */         return true;
/*      */       }
/*      */     }
/*      */     else {
/*  433 */       if (this.listeAttribut.size() > 0) {
/*  434 */         JOptionPane.showMessageDialog(this, "Le nom de la relation ne doit pas avoir un nom vide", "Erreur", 0);
/*  435 */         return false;
/*      */       }
/*  437 */       return true;
/*      */     }
/*      */     
/*  440 */     return false;
/*      */   }
/*      */   
/*      */   private Attribut2 corrigerAttribut(Attribut2 att) {
/*  444 */     if ((this.entite instanceof IhmRelation2)) {
/*  445 */       att.setKey("");
/*  446 */       if (att.getType().toUpperCase().equals("AUTO_INCREMENT")) {
/*  447 */         att.setType("");
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  452 */     return att;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> corrigerAttributs(ArrayList<Attribut> liste) {
/*  456 */     for (int i = 0; i < liste.size(); i++) {
/*  457 */       corrigerAttribut((Attribut2)liste.get(i));
/*      */     }
/*  459 */     return liste;
/*      */   }
/*      */   
/*      */ 
/*      */   private void affectationReferenceAttributEntite(ArrayList<Attribut> liste)
/*      */   {
/*  465 */     for (int i = 0; i < liste.size(); i++) {
/*  466 */       Attribut att = (Attribut)liste.get(i);
/*  467 */       att.setEntiteRelation(((IhmEntite2)this.entite).getEntite());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void affectationReferenceAttributRelation(ArrayList<Attribut> liste)
/*      */   {
/*  474 */     for (int i = 0; i < liste.size(); i++) {
/*  475 */       Attribut att = (Attribut)liste.get(i);
/*  476 */       att.setEntiteRelation(((IhmRelation2)this.entite).getRelation());
/*      */     }
/*      */   }
/*      */   
/*      */   private void affectationReferenceAttribut(ArrayList<Attribut> liste) {
/*  481 */     if ((this.entite instanceof IhmEntite2)) {
/*  482 */       affectationReferenceAttributEntite(liste);
/*      */     }
/*  484 */     if ((this.entite instanceof IhmRelation2)) {
/*  485 */       affectationReferenceAttributRelation(liste);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public void affectationReferenceAttribut(Attribut att)
/*      */   {
/*  492 */     if ((this.entite instanceof IhmEntite2)) {
/*  493 */       att.setEntiteRelation(((IhmEntite2)this.entite).getEntite());
/*      */     }
/*  495 */     if ((this.entite instanceof IhmRelation2)) {
/*  496 */       att.setEntiteRelation(((IhmRelation2)this.entite).getRelation());
/*      */     }
/*      */   }
/*      */   
/*      */   private JComboBox remplirType()
/*      */   {
/*  502 */     JComboBox comboBox = new JComboBox();
/*      */     
/*  504 */     comboBox.addItem("");
/*  505 */     for (int i = 0; i < this.frm.getPage().getListeDomaine().size(); i++) {
/*  506 */       comboBox.addItem(((Merise.Domaine)this.frm.getPage().getListeDomaine().get(i)).getNom());
/*      */     }
/*  508 */     if (this.frm.getPage().getListeDomaine().size() > 0) comboBox.addItem("");
/*  509 */     for (int i = 0; i < Outil.Parametres.DomaineDefini.length; i++) {
/*  510 */       if ((!Outil.Parametres.DomaineDefini[i].toUpperCase().equals("ENUM")) && (!Outil.Parametres.DomaineDefini[i].toUpperCase().equals("SET")))
/*      */       {
/*  512 */         if (Outil.Parametres.DomaineDefini[i].toUpperCase().equals("AUTO_INCREMENT")) {
/*  513 */           if (!(this.entite instanceof IhmRelation2)) comboBox.addItem(Outil.Parametres.DomaineDefini[i]);
/*      */         } else {
/*  515 */           comboBox.addItem(Outil.Parametres.DomaineDefini[i]);
/*      */         }
/*      */       }
/*      */     }
/*  519 */     return comboBox;
/*      */   }
/*      */   
/*      */   private void initialiserLatable() {
/*  523 */     JComboBox comboBoxCle = remplirCle();
/*  524 */     JComboBox comboBoxType = remplirType();
/*  525 */     JTextField jtf = new JTextField();
/*  526 */     jtf.setFont(new Font("Tahoma", 1, 14));
/*  527 */     jtf.setBackground(Color.yellow);
/*  528 */     boolean isMCD = true;
/*  529 */     if ((this.entite instanceof IhmMLD2.MLDEntite2)) isMCD = false;
/*  530 */     this.tableModel = new ProprieteEntiteTableModel(this.listeAttribut, isMCD);
/*  531 */     this.jTableAttribut.setModel(this.tableModel);
/*      */     
/*  533 */     this.jTableAttribut.getColumnModel().getColumn(0).setCellEditor(new ProprieteBoutonCellEditor(this.listeAttribut, this.frm, this.entite, null));
/*      */     
/*  535 */     this.jTableAttribut.getColumnModel().getColumn(0).setPreferredWidth(35);
/*  536 */     this.jTableAttribut.getColumnModel().getColumn(1).setPreferredWidth(220);
/*  537 */     this.jTableAttribut.getColumnModel().getColumn(2).setPreferredWidth(170);
/*  538 */     this.jTableAttribut.getColumnModel().getColumn(3).setPreferredWidth(120);
/*  539 */     this.jTableAttribut.getColumnModel().getColumn(4).setPreferredWidth(30);
/*  540 */     this.jTableAttribut.getColumnModel().getColumn(5).setPreferredWidth(30);
/*  541 */     this.jTableAttribut.getColumnModel().getColumn(6).setPreferredWidth(120);
/*  542 */     this.jTableAttribut.getColumnModel().getColumn(7).setPreferredWidth(10);
/*  543 */     this.jTableAttribut.getColumnModel().getColumn(8).setPreferredWidth(10);
/*      */     
/*      */ 
/*  546 */     this.jTableAttribut.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBoxType));
/*  547 */     this.jTableAttribut.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(jtf));
/*  548 */     this.jTableAttribut.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(jtf));
/*  549 */     this.jTableAttribut.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboBoxCle));
/*  550 */     this.jTableAttribut.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(new JCheckBox()));
/*      */     
/*  552 */     this.tabR = new ProprieteEntiteTableRender();
/*  553 */     this.tabR.setListeAttribut(this.listeAttribut);
/*  554 */     this.jTableAttribut.setDefaultRenderer(Object.class, this.tabR);
/*  555 */     this.jTableAttribut.setDefaultRenderer(JButton.class, new ProprieteBoutonCellRender());
/*  556 */     this.jTableAttribut.setDefaultRenderer(Boolean.class, new CheckBoxCellRender());
/*      */     
/*      */ 
/*      */ 
/*  560 */     this.jTableAttribut.setRowHeight(30);
/*      */   }
/*      */   
/*      */   public void afficherListeAttribut(ArrayList<Attribut> liste) {
/*  564 */     for (int i = 0; i < liste.size(); i++) {
/*  565 */       System.out.println(((Attribut)liste.get(i)).getConversionToString());
/*      */     }
/*      */   }
/*      */   
/*      */   public void supprimerSelection() {
/*  570 */     int[] selection = this.jTableAttribut.getSelectedRows();
/*  571 */     for (int i = selection.length - 1; i >= 0; i--) {
/*  572 */       this.tableModel.removeAttribut(selection[i]);
/*  573 */       this.listeAttribut.remove(selection[i]);
/*      */     }
/*      */     
/*  576 */     if (this.listeAttribut.size() == 0) {
/*  577 */       JComboBox comboBoxCle = remplirCle();
/*  578 */       JComboBox comboBoxType = remplirType();
/*  579 */       JTextField jtf = new JTextField();
/*  580 */       jtf.setFont(new Font("Tahoma", 1, 14));
/*  581 */       jtf.setBackground(Color.YELLOW);
/*  582 */       this.jTableAttribut.getColumnModel().getColumn(0).setCellEditor(new ProprieteBoutonCellEditor(this.listeAttribut, this.frm, this.entite, null));
/*  583 */       this.jTableAttribut.getColumnModel().getColumn(0).setPreferredWidth(35);
/*  584 */       this.jTableAttribut.getColumnModel().getColumn(1).setPreferredWidth(220);
/*  585 */       this.jTableAttribut.getColumnModel().getColumn(2).setPreferredWidth(170);
/*  586 */       this.jTableAttribut.getColumnModel().getColumn(3).setPreferredWidth(120);
/*  587 */       this.jTableAttribut.getColumnModel().getColumn(4).setPreferredWidth(30);
/*  588 */       this.jTableAttribut.getColumnModel().getColumn(5).setPreferredWidth(30);
/*  589 */       this.jTableAttribut.getColumnModel().getColumn(6).setPreferredWidth(120);
/*  590 */       this.jTableAttribut.getColumnModel().getColumn(7).setPreferredWidth(10);
/*  591 */       this.jTableAttribut.getColumnModel().getColumn(8).setPreferredWidth(10);
/*      */       
/*      */ 
/*  594 */       this.jTableAttribut.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBoxType));
/*  595 */       this.jTableAttribut.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(jtf));
/*  596 */       this.jTableAttribut.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(jtf));
/*  597 */       this.jTableAttribut.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(comboBoxCle));
/*  598 */       this.jTableAttribut.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(new JCheckBox()));
/*      */       
/*  600 */       this.tabR = new ProprieteEntiteTableRender();
/*  601 */       this.tabR.setListeAttribut(this.listeAttribut);
/*  602 */       this.jTableAttribut.setDefaultRenderer(Object.class, this.tabR);
/*  603 */       this.jTableAttribut.setDefaultRenderer(JButton.class, new ProprieteBoutonCellRender());
/*  604 */       this.jTableAttribut.setDefaultRenderer(Boolean.class, new CheckBoxCellRender());
/*      */     }
/*      */   }
/*      */   
/*      */   private void dessinerEntiteNonDegradee() {
/*  609 */     Rectangle rtout = new Rectangle(50, 30, this.jPanelAprecu.getWidth() - 100, this.jPanelAprecu.getHeight() - 60);
/*  610 */     Rectangle r = new Rectangle(50, 80, this.jPanelAprecu.getWidth() - 100, this.jPanelAprecu.getHeight() - 110);
/*      */     
/*  612 */     Graphics g = this.jPanelAprecu.getGraphics();
/*  613 */     g.setFont(new Font("Tahoma", 1, 16));
/*      */     
/*  615 */     String nom = this.jTFNomEntite.getText().trim().length() == 0 ? "Entite" : this.jTFNomEntite.getText().trim();
/*  616 */     int x = g.getFontMetrics().stringWidth(nom);
/*  617 */     x = (this.jPanelAprecu.getWidth() - 100 - x) / 2 + 50;
/*      */     
/*  619 */     g.setColor(this.jLabFondTitre.getBackground());
/*  620 */     g.fillRect((int)rtout.getX(), (int)rtout.getY(), (int)rtout.getWidth(), (int)rtout.getHeight());
/*      */     
/*  622 */     g.setColor(this.jLabFond.getBackground());
/*  623 */     g.fillRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
/*      */     
/*  625 */     g.setColor(this.jLabCadreTitre.getBackground());
/*      */     
/*  627 */     g.drawRect((int)rtout.getX(), (int)rtout.getY(), (int)rtout.getWidth(), (int)rtout.getHeight());
/*      */     
/*  629 */     g.drawRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
/*      */     
/*  631 */     g.setColor(this.jLabTexteTitre.getBackground());
/*  632 */     g.drawString(nom, x, (int)r.getY() - 20);
/*      */     
/*      */ 
/*  635 */     g.setColor(this.jLabTexte.getBackground());
/*  636 */     g.setFont(new Font("Tahoma", 1, 12));
/*  637 */     g.drawString("Attribut1", (int)r.getX() + 20, (int)r.getY() + 40);
/*  638 */     g.drawString("Attribut2", (int)r.getX() + 20, (int)r.getY() + 70);
/*  639 */     g.drawString("Attribut3", (int)r.getX() + 20, (int)r.getY() + 100);
/*  640 */     g.drawString("Attribut3", (int)r.getX() + 20, (int)r.getY() + 130);
/*  641 */     g.setColor(this.jLabTexteType.getBackground());
/*  642 */     g.drawString("VARCHAR(25)", (int)r.getX() + 120, (int)r.getY() + 40);
/*  643 */     g.drawString("INT", (int)r.getX() + 120, (int)r.getY() + 70);
/*  644 */     g.drawString("DATE", (int)r.getX() + 120, (int)r.getY() + 100);
/*  645 */     g.drawString("VARCHAR(50)", (int)r.getX() + 120, (int)r.getY() + 130);
/*      */     
/*  647 */     g.setFont(new Font("Tahoma", 1, 11));
/*  648 */     g.setColor(this.jLabLienColor.getBackground());
/*  649 */     g.drawLine(10, (int)(rtout.getY() + rtout.getHeight() / 2.0D), (int)rtout.getX(), (int)(rtout.getY() + rtout.getHeight() / 2.0D));
/*  650 */     g.drawString("0,n", 10, (int)(rtout.getY() + rtout.getHeight() / 2.0D) - 4);
/*  651 */     g.drawLine((int)(rtout.getX() + rtout.getWidth()), (int)(rtout.getY() + rtout.getHeight() / 2.0D), (int)(rtout.getX() + rtout.getWidth()) + 40, (int)(rtout.getY() + rtout.getHeight() / 2.0D));
/*  652 */     g.drawString("(1,1)", (int)(rtout.getX() + rtout.getWidth()) + 10, (int)(rtout.getY() + rtout.getHeight() / 2.0D) - 4);
/*      */   }
/*      */   
/*      */   private void dessinerEntiteDegradee() {
/*  656 */     Rectangle rtout = new Rectangle(50, 30, this.jPanelAprecu.getWidth() - 100, this.jPanelAprecu.getHeight() - 60);
/*  657 */     Rectangle r = new Rectangle(50, 80, this.jPanelAprecu.getWidth() - 100, this.jPanelAprecu.getHeight() - 110);
/*      */     
/*  659 */     Graphics g = this.jPanelAprecu.getGraphics();
/*  660 */     g.setFont(new Font("Tahoma", 1, 16));
/*      */     
/*  662 */     String nom = this.jTFNomEntite.getText().trim().length() == 0 ? "Entite" : this.jTFNomEntite.getText().trim();
/*  663 */     int x = g.getFontMetrics().stringWidth(nom);
/*  664 */     x = (this.jPanelAprecu.getWidth() - 100 - x) / 2 + 50;
/*      */     
/*  666 */     Graphics2D g2d = (Graphics2D)g;
/*      */     
/*  668 */     g2d.setPaint(new java.awt.GradientPaint((float)rtout.getX(), (float)rtout.getY(), this.jLabFondTitre.getBackground(), (float)rtout.getWidth(), (float)rtout.getHeight(), Color.WHITE, true));
/*  669 */     g.fillRect((int)rtout.getX(), (int)rtout.getY(), (int)rtout.getWidth(), (int)rtout.getHeight());
/*      */     
/*  671 */     g2d.setPaint(new java.awt.GradientPaint((float)r.getX(), (float)r.getY(), this.jLabFond.getBackground(), (float)r.getWidth(), (float)r.getHeight(), Color.WHITE, true));
/*  672 */     g.fillRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
/*      */     
/*      */ 
/*  675 */     g.setColor(this.jLabCadreTitre.getBackground());
/*      */     
/*  677 */     g.drawRect((int)rtout.getX(), (int)rtout.getY(), (int)rtout.getWidth(), (int)rtout.getHeight());
/*      */     
/*  679 */     g.drawRect((int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight());
/*      */     
/*  681 */     g.setColor(this.jLabTexteTitre.getBackground());
/*  682 */     g.drawString(nom, x, (int)r.getY() - 20);
/*      */     
/*      */ 
/*  685 */     g.setColor(this.jLabTexte.getBackground());
/*  686 */     g.setFont(new Font("Tahoma", 1, 12));
/*  687 */     g.drawString("Attribut1", (int)r.getX() + 20, (int)r.getY() + 40);
/*  688 */     g.drawString("Attribut2", (int)r.getX() + 20, (int)r.getY() + 70);
/*  689 */     g.drawString("Attribut3", (int)r.getX() + 20, (int)r.getY() + 100);
/*  690 */     g.drawString("Attribut3", (int)r.getX() + 20, (int)r.getY() + 130);
/*  691 */     g.setColor(this.jLabTexteType.getBackground());
/*  692 */     g.drawString("VARCHAR(25)", (int)r.getX() + 120, (int)r.getY() + 40);
/*  693 */     g.drawString("INT", (int)r.getX() + 120, (int)r.getY() + 70);
/*  694 */     g.drawString("DATE", (int)r.getX() + 120, (int)r.getY() + 100);
/*  695 */     g.drawString("VARCHAR(50)", (int)r.getX() + 120, (int)r.getY() + 130);
/*      */     
/*  697 */     g.setFont(new Font("Tahoma", 1, 11));
/*  698 */     g.setColor(this.jLabLienColor.getBackground());
/*  699 */     g.drawLine(10, (int)(rtout.getY() + rtout.getHeight() / 2.0D), (int)rtout.getX(), (int)(rtout.getY() + rtout.getHeight() / 2.0D));
/*  700 */     g.drawString("0,n", 10, (int)(rtout.getY() + rtout.getHeight() / 2.0D) - 4);
/*  701 */     g.drawLine((int)(rtout.getX() + rtout.getWidth()), (int)(rtout.getY() + rtout.getHeight() / 2.0D), (int)(rtout.getX() + rtout.getWidth()) + 40, (int)(rtout.getY() + rtout.getHeight() / 2.0D));
/*  702 */     g.drawString("(1,1)", (int)(rtout.getX() + rtout.getWidth()) + 10, (int)(rtout.getY() + rtout.getHeight() / 2.0D) - 4);
/*      */   }
/*      */   
/*      */ 
/*      */   private void dessinerFondEnteteRelation(Graphics2D g, int hauteur, int xd, int xf, RoundRectangle2D rRect)
/*      */   {
/*  708 */     int ht = hauteur;
/*  709 */     int xDeb = xd;int xFin = xf;
/*      */     
/*      */ 
/*      */ 
/*  713 */     int y = 89 + hauteur;
/*  714 */     Graphics2D g2d = (Graphics2D)g.create();
/*      */     
/*  716 */     java.awt.Stroke stro = g2d.getStroke();
/*  717 */     float[] style = { 10.0F, 0.0F };
/*  718 */     g2d.setStroke(new java.awt.BasicStroke(2.0F, 0, 0, 10.0F, style, 0.0F));
/*  719 */     g2d.setColor(this.jLabFondTitre.getBackground());
/*  720 */     while (hauteur > 0)
/*      */     {
/*  722 */       while (!rRect.contains(xd, y)) {
/*  723 */         xd++;
/*      */       }
/*      */       
/*  726 */       while (!rRect.contains(xf, y)) {
/*  727 */         xf--;
/*      */       }
/*      */       
/*  730 */       g2d.drawLine(xd, y, xf, y);
/*  731 */       y -= 1;
/*  732 */       hauteur -= 1;
/*      */     }
/*  734 */     g2d.setStroke(stro);
/*      */   }
/*      */   
/*      */   private JButton jBtImporterAttribut;
/*      */   private JButton jBtPropriete;
/*      */   
/*      */   private void dessinerRelationNonDegradee() {
/*  741 */     Graphics g = this.jPanelAprecu.getGraphics();
/*  742 */     g.setFont(new Font("Tahoma", 1, 16));
/*      */     
/*  744 */     String nom = this.jTFNomEntite.getText().trim().length() == 0 ? "Entite" : this.jTFNomEntite.getText().trim();
/*  745 */     int x = g.getFontMetrics().stringWidth(nom);
/*      */     
/*  747 */     Graphics2D g2d = (Graphics2D)g;
/*      */     
/*  749 */     g.setColor(this.jLabFond.getBackground());
/*      */     
/*  751 */     RoundRectangle2D rRect = new java.awt.geom.RoundRectangle2D.Double(40.0D, 90.0D, 250.0D, 100.0D, 100.0D, 100.0D);
/*  752 */     g2d.fill(rRect);
/*      */     
/*  754 */     int xd = 40;
/*  755 */     int xf = 289;
/*      */     
/*  757 */     dessinerFondEnteteRelation(g2d, 50, xd, xf, rRect);
/*      */     
/*      */ 
/*  760 */     g.setColor(this.jLabCadreTitre.getBackground());
/*  761 */     g2d.draw(rRect);
/*  762 */     g.drawLine(40, 140, 290, 140);
/*      */     
/*  764 */     g.setColor(this.jLabTexteTitre.getBackground());
/*      */     
/*  766 */     x = (250 - x) / 2 + 40;
/*  767 */     g.drawString(nom, x, 125);
/*      */     
/*  769 */     g.setFont(new Font("Tahoma", 1, 12));
/*  770 */     g.setColor(this.jLabTexte.getBackground());
/*  771 */     g.drawString("Attribut1  ", 70, 170);
/*      */     
/*  773 */     g.setColor(this.jLabTexteType.getBackground());
/*  774 */     g.drawString("  VARCHAR(50)", 130, 170);
/*      */     
/*  776 */     g.setColor(this.jLabLienColor.getBackground());
/*  777 */     g.drawLine(10, 140, 40, 140);
/*  778 */     g.drawString("0,n", 12, 135);
/*  779 */     g.drawLine(290, 140, 330, 140);
/*  780 */     g.drawString("(1,1)", 300, 135); }
/*      */   
/*      */   private JButton jBtRemonter;
/*      */   private JButton jBtSupprimer;
/*      */   private JButton jBtValider;
/*      */   
/*  786 */   private void dessinerRelationDegradee() { Graphics g = this.jPanelAprecu.getGraphics();
/*  787 */     g.setFont(new Font("Tahoma", 1, 16));
/*      */     
/*  789 */     String nom = this.jTFNomEntite.getText().trim().length() == 0 ? "Entite" : this.jTFNomEntite.getText().trim();
/*  790 */     int x = g.getFontMetrics().stringWidth(nom);
/*      */     
/*  792 */     Graphics2D g2d = (Graphics2D)g;
/*      */     
/*  794 */     g.setColor(this.jLabFond.getBackground());
/*      */     
/*  796 */     RoundRectangle2D rRect = new java.awt.geom.RoundRectangle2D.Double(40.0D, 90.0D, 250.0D, 100.0D, 100.0D, 100.0D);
/*  797 */     g2d.setPaint(new java.awt.GradientPaint(40.0F, 90.0F, this.jLabFond.getBackground(), 250.0F, 100.0F, Color.WHITE, true));
/*  798 */     g2d.fill(rRect);
/*      */     
/*  800 */     int xd = 40;
/*  801 */     int xf = 289;
/*  802 */     dessinerFondEnteteRelation(g2d, 50, xd, xf, rRect);
/*      */     
/*      */ 
/*  805 */     g2d.setColor(this.jLabCadreTitre.getBackground());
/*  806 */     g2d.draw(rRect);
/*  807 */     g.drawLine(40, 140, 290, 140);
/*      */     
/*  809 */     g.setColor(this.jLabTexteTitre.getBackground());
/*      */     
/*  811 */     x = (250 - x) / 2 + 40;
/*  812 */     g.drawString(nom, x, 125);
/*      */     
/*  814 */     g.setFont(new Font("Tahoma", 1, 12));
/*  815 */     g.setColor(this.jLabTexte.getBackground());
/*  816 */     g.drawString("Attribut1 ", 70, 170);
/*  817 */     g.setColor(this.jLabTexteType.getBackground());
/*  818 */     g.drawString("  VARCHAR(50)", 130, 170);
/*  819 */     g.setColor(this.jLabLienColor.getBackground());
/*  820 */     g.drawLine(10, 140, 40, 140);
/*  821 */     g.drawString("0,n", 12, 135);
/*  822 */     g.drawLine(290, 140, 330, 140);
/*  823 */     g.drawString("(1,1)", 300, 135);
/*      */   }
/*      */   
/*      */   private void dessinerEntite()
/*      */   {
/*  828 */     if (this.jCBDegradee.isSelected()) {
/*  829 */       dessinerEntiteDegradee();
/*      */     } else {
/*  831 */       dessinerEntiteNonDegradee();
/*      */     }
/*      */   }
/*      */   
/*      */   private void dessinerRelation() {
/*  836 */     if (this.jCBDegradee.isSelected()) {
/*  837 */       dessinerRelationDegradee();
/*      */     } else
/*  839 */       dessinerRelationNonDegradee();
/*      */   }
/*      */   
/*      */   private JCheckBox jCBAppliquerAtoute;
/*      */   private JCheckBox jCBAppliquerClAttribut;
/*      */   private JCheckBox jCBAppliquerDefaut;
/*      */   private void dessinerEntiteMLD() {}
/*      */   
/*      */   private void dessinerApercu() {
/*  848 */     this.jPanelAprecu.setBackground(Color.WHITE);
/*  849 */     this.jPanelAprecu.getGraphics().fillRect(this.jPanelAprecu.getX(), this.jPanelAprecu.getY(), this.jPanelAprecu.getWidth(), this.jPanelAprecu.getHeight());
/*  850 */     if (this.entite != null) {
/*  851 */       if ((this.entite instanceof IhmEntite2)) {
/*  852 */         dessinerEntite();
/*      */       }
/*  854 */       else if ((this.entite instanceof IhmRelation)) {
/*  855 */         dessinerRelation();
/*      */       } else {
/*  857 */         dessinerEntiteMLD();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void remonterAttribut(int index)
/*      */   {
/*  864 */     if (index >= 1) {
/*  865 */       Attribut att = (Attribut)this.listeAttribut.get(index - 1);
/*  866 */       this.listeAttribut.remove(index - 1);
/*  867 */       this.tableModel.removeAttribut(index - 1);
/*      */       
/*  869 */       this.listeAttribut.add(index, att);
/*  870 */       this.tableModel.getListeAttribut().add(index, att);
/*  871 */       this.jTableAttribut.repaint();
/*  872 */       this.jTableAttribut.setRowSelectionInterval(index - 1, index - 1);
/*      */     }
/*      */   }
/*      */   
/*      */   private void descendreAttribut(int index) {
/*  877 */     if (index < this.listeAttribut.size() - 1) {
/*  878 */       Attribut att = (Attribut)this.listeAttribut.get(index + 1);
/*  879 */       this.listeAttribut.remove(index + 1);
/*  880 */       this.tableModel.removeAttribut(index + 1);
/*      */       
/*  882 */       this.listeAttribut.add(index, att);
/*  883 */       this.tableModel.getListeAttribut().add(index, att);
/*  884 */       this.jTableAttribut.repaint();
/*  885 */       this.jTableAttribut.setRowSelectionInterval(index + 1, index + 1);
/*      */     }
/*      */   }
/*      */   
/*      */   private void ajouterListeAttributDico(ArrayList<Attribut> liste)
/*      */   {
/*  891 */     for (int i = 0; i < liste.size(); i++) {
/*  892 */       Attribut2 att = (Attribut2)liste.get(i);
/*      */       
/*  894 */       this.frm.getPage().ajouterAttribut(att);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean enregistrerEntite() {
/*  899 */     IhmEntite2 ihmEnt = (IhmEntite2)this.entite;
/*  900 */     Entite2 ent = (Entite2)ihmEnt.getEntite();
/*  901 */     ent.setNom(this.jTFNomEntite.getText());
/*  902 */     ent.setCode(this.jTFCodeEntite.getText());
/*  903 */     ihmEnt.setClCadre2(this.jLabCadreTitre.getBackground());
/*  904 */     ihmEnt.setClCadreTitre2(this.jLabCadreTitre.getBackground());
/*  905 */     ihmEnt.setClFond2(this.jLabFond.getBackground());
/*  906 */     ihmEnt.setClFondTitre2(this.jLabFondTitre.getBackground());
/*  907 */     ihmEnt.setClLienActiver(this.jLabLienColor.getBackground());
/*  908 */     ihmEnt.setClText2(this.jLabTexte.getBackground());
/*  909 */     ihmEnt.setClTextType2(this.jLabTexteType.getBackground());
/*  910 */     ihmEnt.setClTextTitre2(this.jLabTexteTitre.getBackground());
/*  911 */     ent.getListeAttributs().clear();
/*  912 */     corrigerTailleAttribut(this.tableModel.getListeAttribut());
/*  913 */     ent.setListeAttributs(this.tableModel.getListeAttribut());
/*  914 */     ent.setCommentaire(this.jTAcommentaire.getText());
/*  915 */     ent.ajouterModification();
/*  916 */     affectationReferenceAttribut(ent.getListeAttributs());
/*      */     
/*  918 */     if (this.visualisation.trim().length() == 0) ajouterListeAttributDico(this.tableModel.getListeAttribut());
/*  919 */     ((Entite2)ihmEnt.getEntite()).setHistorisation(this.jCBHistorisation.isSelected() ? "H" : "");
/*  920 */     if (this.jCBAppliquerDefaut.isSelected())
/*      */     {
/*  922 */       FormeInterneMCD.clEntiteCadre2 = this.jLabCadreTitre.getBackground();
/*  923 */       FormeInterneMCD.clEntiteFond2 = this.jLabFond.getBackground();
/*  924 */       FormeInterneMCD.clEntiteText2 = this.jLabTexte.getBackground();
/*  925 */       FormeInterneMCD.clEntiteTextType2 = this.jLabTexteType.getBackground();
/*  926 */       FormeInterneMCD.clEntiteTextTaille2 = this.jLabTexteTaille.getBackground();
/*  927 */       FormeInterneMCD.clEntiteTextTailleDec2 = this.jLabTexteTailleDec.getBackground();
/*      */       
/*  929 */       FormeInterneMCD.clEntiteFondTitre2 = this.jLabFondTitre.getBackground();
/*  930 */       FormeInterneMCD.clEntiteTextTitre2 = this.jLabTexteTitre.getBackground();
/*  931 */       FormeInterneMCD.clEntiteCadre2 = this.jLabCadreTitre.getBackground();
/*      */       
/*  933 */       FormeInterneMCD.clLienActiver2 = this.jLabLienColor.getBackground();
/*  934 */       this.frm.getFormeMCD().miseAjourParametreMCD(this.frm.getPage().getConfigurationMCD());
/*      */     }
/*  936 */     if (this.jCBAppliquerAtoute.isSelected()) {
/*  937 */       appliquerCouleur();
/*      */     }
/*  939 */     else if (this.jCBAppliquerClAttribut.isSelected()) {
/*  940 */       appliquerCouleurNomType(ihmEnt.getEntite().getListeAttributs(), getColor(this.jLabTexte.getBackground()), getColor(this.jLabTexteType.getBackground()), getColor(this.jLabTexteTaille.getBackground()), getColor(this.jLabTexteTailleDec.getBackground()));
/*      */     }
/*      */     
/*  943 */     ihmEnt.ajouterModification();
/*  944 */     return true;
/*      */   }
/*      */   
/*      */   public boolean enregistrerRelation() {
/*  948 */     IhmRelation2 ihmEnt = (IhmRelation2)this.entite;
/*  949 */     Relation2 ent = (Relation2)ihmEnt.getRelation();
/*  950 */     ent.setNom(this.jTFNomEntite.getText());
/*  951 */     ent.setCode(this.jTFCodeEntite.getText());
/*  952 */     ihmEnt.setClCadre2(this.jLabCadreTitre.getBackground());
/*  953 */     ihmEnt.setClCadreTitre2(this.jLabCadreTitre.getBackground());
/*      */     
/*  955 */     ihmEnt.setClFond2(this.jLabFond.getBackground());
/*  956 */     ihmEnt.setClFondTitre2(this.jLabFondTitre.getBackground());
/*  957 */     ihmEnt.setClLienActiver(this.jLabLienColor.getBackground());
/*  958 */     ihmEnt.setClText2(this.jLabTexte.getBackground());
/*  959 */     ihmEnt.setClTextType2(this.jLabTexteType.getBackground());
/*  960 */     ihmEnt.setClTextTitre2(this.jLabTexteTitre.getBackground());
/*      */     
/*  962 */     corrigerTailleAttribut(this.tableModel.getListeAttribut());
/*  963 */     ent.getListeAttributs().clear();
/*  964 */     ent.setListeAttributs(this.tableModel.getListeAttribut());
/*  965 */     ent.setCommentaire(this.jTAcommentaire.getText());
/*  966 */     ent.ajouterModification();
/*  967 */     affectationReferenceAttribut(ent.getListeAttributs());
/*      */     
/*  969 */     if (this.visualisation.trim().length() == 0) ajouterListeAttributDico(this.tableModel.getListeAttribut());
/*  970 */     ((Relation2)ihmEnt.getRelation()).setHistorisation(this.jCBHistorisation.isSelected() ? "H" : ent.getNom().trim().length() == 0 ? "" : "");
/*      */     
/*  972 */     if (this.jCBAppliquerDefaut.isSelected()) {
/*  973 */       FormeInterneMCD.clRelationCadre2 = this.jLabCadreTitre.getBackground();
/*  974 */       FormeInterneMCD.clRelationFond2 = this.jLabFond.getBackground();
/*  975 */       FormeInterneMCD.clRelationText2 = this.jLabTexte.getBackground();
/*  976 */       FormeInterneMCD.clRelationTextType2 = this.jLabTexteType.getBackground();
/*      */       
/*  978 */       FormeInterneMCD.clRelationTextTaille2 = this.jLabTexteTaille.getBackground();
/*  979 */       FormeInterneMCD.clRelationTextTailleDec2 = this.jLabTexteTailleDec.getBackground();
/*      */       
/*  981 */       FormeInterneMCD.clRelationFondTitre2 = this.jLabFondTitre.getBackground();
/*  982 */       FormeInterneMCD.clRelationTextTitre2 = this.jLabTexteTitre.getBackground();
/*  983 */       FormeInterneMCD.clRelationCadre2 = this.jLabCadreTitre.getBackground();
/*      */       
/*  985 */       FormeInterneMCD.clLienActiverRelation2 = this.jLabLienColor.getBackground();
/*      */       
/*  987 */       this.frm.getFormeMCD().miseAjourParametreMCD(this.frm.getPage().getConfigurationMCD());
/*      */     }
/*      */     
/*  990 */     if (this.jCBAppliquerAtoute.isSelected()) {
/*  991 */       appliquerCouleur();
/*      */     }
/*  993 */     else if (this.jCBAppliquerClAttribut.isSelected()) {
/*  994 */       appliquerCouleurNomType(ihmEnt.getRelation().getListeAttributs(), getColor(this.jLabTexte.getBackground()), getColor(this.jLabTexteType.getBackground()), getColor(this.jLabTexteTaille.getBackground()), getColor(this.jLabTexteTailleDec.getBackground()));
/*      */     }
/*      */     
/*      */ 
/*  998 */     ihmEnt.ajouterModification();
/*      */     
/* 1000 */     return true;
/*      */   }
/*      */   
/*      */   private void appliquerCouleurNomType(ArrayList<Attribut> liste, String clNom, String clType, String clTaille, String clTailleDec)
/*      */   {
/* 1005 */     for (int i = 0; i < liste.size(); i++) {
/* 1006 */       Attribut2 att = (Attribut2)liste.get(i);
/* 1007 */       att.setClNom(clNom);
/* 1008 */       att.setClType(clType);
/* 1009 */       att.setClTaille(clTaille);
/* 1010 */       att.setClTailleDecimale(clTailleDec);
/* 1011 */       if (att.getListeAttributs().size() > 0) {
/* 1012 */         appliquerCouleurNomType(att.getListeAttributs(), clNom, clType, clTaille, clTailleDec);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void appliquerCouleur(IhmEntite2 ihmEnt) {
/* 1018 */     ihmEnt.setClCadre2(this.jLabCadreTitre.getBackground());
/* 1019 */     ihmEnt.setClCadreTitre2(this.jLabCadreTitre.getBackground());
/* 1020 */     ihmEnt.setClFond2(this.jLabFond.getBackground());
/* 1021 */     ihmEnt.setClFondTitre2(this.jLabFondTitre.getBackground());
/* 1022 */     ihmEnt.setClLienActiver(this.jLabLienColor.getBackground());
/* 1023 */     ihmEnt.setClText2(this.jLabTexte.getBackground());
/* 1024 */     ihmEnt.setClTextType2(this.jLabTexteType.getBackground());
/* 1025 */     ihmEnt.setClTextTitre2(this.jLabTexteTitre.getBackground());
/* 1026 */     ihmEnt.setClTextTaille2(this.jLabTexteTaille.getBackground());
/* 1027 */     ihmEnt.setClTextTailleDec2(this.jLabTexteTailleDec.getBackground());
/* 1028 */     appliquerCouleurNomType(ihmEnt.getEntite().getListeAttributs(), getColor(this.jLabTexte.getBackground()), getColor(this.jLabTexteType.getBackground()), getColor(this.jLabTexteTaille.getBackground()), getColor(this.jLabTexteTailleDec.getBackground()));
/*      */   }
/*      */   
/*      */   public void appliquerCouleur(IhmRelation2 ihmEnt) {
/* 1032 */     ihmEnt.setClCadre2(this.jLabCadreTitre.getBackground());
/* 1033 */     ihmEnt.setClCadreTitre2(this.jLabCadreTitre.getBackground());
/* 1034 */     ihmEnt.setClFond2(this.jLabFond.getBackground());
/* 1035 */     ihmEnt.setClFondTitre2(this.jLabFondTitre.getBackground());
/* 1036 */     ihmEnt.setClLienActiver(this.jLabLienColor.getBackground());
/* 1037 */     ihmEnt.setClText2(this.jLabTexte.getBackground());
/* 1038 */     ihmEnt.setClTextType2(this.jLabTexteType.getBackground());
/* 1039 */     ihmEnt.setClTextTitre2(this.jLabTexteTitre.getBackground());
/* 1040 */     ihmEnt.setClTextTaille2(this.jLabTexteTaille.getBackground());
/* 1041 */     ihmEnt.setClTextTailleDec2(this.jLabTexteTailleDec.getBackground());
/* 1042 */     appliquerCouleurNomType(ihmEnt.getRelation().getListeAttributs(), getColor(this.jLabTexte.getBackground()), getColor(this.jLabTexteType.getBackground()), getColor(this.jLabTexteTaille.getBackground()), getColor(this.jLabTexteTailleDec.getBackground()));
/*      */   }
/*      */   
/*      */   public void appliquerCouleur()
/*      */   {
/* 1047 */     if ((this.entite instanceof IhmEntite2)) {
/* 1048 */       for (int i = 0; i < this.listeEntiteRelation.size(); i++) {
/* 1049 */         if ((this.listeEntiteRelation.get(i) instanceof IhmEntite2)) {
/* 1050 */           appliquerCouleur((IhmEntite2)this.listeEntiteRelation.get(i));
/*      */         }
/*      */       }
/*      */     }
/* 1054 */     if ((this.entite instanceof IhmRelation2)) {
/* 1055 */       for (int i = 0; i < this.listeEntiteRelation.size(); i++) {
/* 1056 */         if ((this.listeEntiteRelation.get(i) instanceof IhmRelation2)) {
/* 1057 */           appliquerCouleur((IhmRelation2)this.listeEntiteRelation.get(i));
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public Object getEntite()
/*      */   {
/* 1065 */     return this.entite;
/*      */   }
/*      */   
/*      */   public Principale getFrm() {
/* 1069 */     return this.frm;
/*      */   }
/*      */   
/*      */   public JTable getjTableAttribut() {
/* 1073 */     return this.jTableAttribut;
/*      */   }
/*      */   
/*      */   public ArrayList<Attribut> getListeAttribut() {
/* 1077 */     return this.listeAttribut;
/*      */   }
/*      */   
/*      */   public boolean isModifier() {
/* 1081 */     return this.modifier;
/*      */   }
/*      */   
/*      */   public ProprieteEntiteTableModel getTableModel() {
/* 1085 */     return this.tableModel;
/*      */   }
/*      */   
/*      */   public JLabel getjLabNbreAttribut() {
/* 1089 */     return this.jLabNbreAttribut;
/*      */   }
/*      */   
/*      */   public void setModifier(boolean modifier) {
/* 1093 */     this.modifier = modifier;
/*      */   }
/*      */   
/*      */ 
/*      */   private String getNomLien(IhmLien2 lien)
/*      */   {
/* 1099 */     String n = "";
/* 1100 */     if ((this.entite instanceof IhmEntite2)) {
/* 1101 */       n = n + lien.getEntite().getEntite().getNom() + " -------------------- " + lien.getCardinalite() + " -------------------- ";
/* 1102 */       n = n + (lien.getRelation().getRelation().getNom().trim().length() == 0 ? "Vide" : lien.getRelation().getRelation().getNom());
/*      */     }
/* 1104 */     if ((this.entite instanceof IhmRelation2)) {
/* 1105 */       n = n + (lien.getRelation().getRelation().getNom().trim().length() == 0 ? "Vide" : lien.getRelation().getRelation().getNom());
/* 1106 */       n = n + " -------------------- " + lien.getCardinalite() + " -------------------- " + lien.getEntite().getEntite().getNom();
/*      */     }
/* 1108 */     return n;
/*      */   }
/*      */   
/*      */   private void remplirListeLienAprecu() {
/* 1112 */     String[] tab = new String[this.listeLien.size()];
/* 1113 */     for (int i = 0; i < this.listeLien.size(); i++) {
/* 1114 */       tab[i] = getNomLien((IhmLien2)this.listeLien.get(i));
/*      */     }
/* 1116 */     this.jList.setListData(tab);
/*      */   }
/*      */   
/*      */   private void dessinerApercuLienSelected() {
/* 1120 */     int nb = this.jList.getSelectedIndex();
/* 1121 */     if (nb >= 0) {
/* 1122 */       IhmLien2 li = (IhmLien2)this.listeLien.get(nb);
/* 1123 */       dessinerApercuLien(li);
/*      */     }
/*      */   }
/*      */   
/*      */   private void dessinerApercuLien(IhmLien2 lien) {
/* 1128 */     Graphics g = this.jPanelApercuLien.getGraphics();
/* 1129 */     g.setFont(new Font("Tahoma", 1, 11));
/*      */     
/* 1131 */     String nom = lien.getNom().trim().length() == 0 ? "" : lien.getNom();
/*      */     
/* 1133 */     String nomEntite = lien == null ? "" : lien.getEntite().getEntite().getNom();
/* 1134 */     String nomRelation = lien == null ? "" : lien.getRelation().getRelation().getNom();
/*      */     
/* 1136 */     nomEntite = nomEntite.substring(0, nomEntite.length() < 15 ? nomEntite.length() : 15);
/* 1137 */     nomRelation = nomRelation.substring(0, nomRelation.length() < 15 ? nomRelation.length() : 15);
/* 1138 */     nom = nom.substring(0, nom.length() < 10 ? nom.length() : 10);
/*      */     
/* 1140 */     int x = g.getFontMetrics().stringWidth(nomEntite);
/* 1141 */     int xR = g.getFontMetrics().stringWidth(nomRelation);
/*      */     
/* 1143 */     Graphics2D g2d = (Graphics2D)g;
/*      */     
/* 1145 */     g.setColor(this.jPanelApercuLien.getBackground());
/*      */     
/*      */ 
/* 1148 */     RoundRectangle2D rRectT = new java.awt.geom.RoundRectangle2D.Double(0.0D, 0.0D, this.jPanelApercuLien.getWidth(), this.jPanelApercuLien.getHeight(), 0.0D, 0.0D);
/* 1149 */     g2d.fill(rRectT);
/*      */     
/*      */ 
/* 1152 */     g.setColor(Color.YELLOW);
/*      */     
/* 1154 */     if (lien != null) {
/* 1155 */       g.setColor(((IhmEntite2)lien.getEntite()).getClFond2());
/*      */     }
/* 1157 */     RoundRectangle2D rRect = new java.awt.geom.RoundRectangle2D.Double(100.0D, 20.0D, 100.0D, 100.0D, 0.0D, 0.0D);
/* 1158 */     g2d.fill(rRect);
/* 1159 */     g.setColor(Color.BLACK);
/*      */     
/* 1161 */     g2d.draw(rRect);
/* 1162 */     g2d.drawLine(100, 40, 200, 40);
/* 1163 */     g2d.drawString(nomEntite, 100 + (100 - x) / 2, 35);
/*      */     
/* 1165 */     g.setColor(Color.GREEN);
/* 1166 */     if (lien != null) {
/* 1167 */       g.setColor(((IhmRelation2)lien.getRelation()).getClFond2());
/*      */     }
/* 1169 */     RoundRectangle2D rRectRel = new java.awt.geom.RoundRectangle2D.Double(420.0D, 45.0D, 110.0D, 50.0D, 50.0D, 50.0D);
/* 1170 */     g2d.fill(rRectRel);
/* 1171 */     g.setColor(Color.BLACK);
/*      */     
/* 1173 */     g2d.draw(rRectRel);
/* 1174 */     g2d.drawLine(420, 70, 530, 70);
/* 1175 */     g2d.drawString(nomRelation, 420 + (110 - xR) / 2, 60);
/* 1176 */     int xx = 230;
/* 1177 */     g.setColor(lien.getClLienText2());
/* 1178 */     String card = lien.getCardinalite();
/* 1179 */     if (Outil.Setting.cardinaliteMajuscule) card = card.toUpperCase();
/* 1180 */     if (Outil.Setting.cardinalite2points) card = card.replace(",", ":");
/* 1181 */     if (lien.isRelatif()) {
/* 1182 */       xx = 240;
/*      */     }
/*      */     
/* 1185 */     g2d.drawString(card, 212, 74);
/*      */     
/* 1187 */     g.setColor(lien.getClLien2());
/* 1188 */     g2d.drawLine(200, 70, 208, 70);
/* 1189 */     if (lien.isRelatif()) g2d.drawLine(240, 70, 430, 70); else {
/* 1190 */       g2d.drawLine(235, 70, 430, 70);
/*      */     }
/* 1192 */     int[] xtab = { 200, 207, 207 };
/* 1193 */     int[] ytab = { 70, 65, 75 };
/* 1194 */     if (lien.isFleche()) { g2d.fillPolygon(xtab, ytab, 3);
/*      */     }
/* 1196 */     g.setColor(lien.getClLienNom2());
/* 1197 */     int tail = g.getFontMetrics().stringWidth(nom);
/* 1198 */     g2d.drawString(nom, xx + 10 + (200 - tail) / 2, 68);
/*      */   }
/*      */   
/*      */   private Color choixDeCouleur(Color color, String titre)
/*      */   {
/* 1203 */     Color col = javax.swing.JColorChooser.showDialog(this, titre, color);
/* 1204 */     if (col == null) return color;
/* 1205 */     return col;
/*      */   }
/*      */   
/*      */   private void miseAjourListe() {
/* 1209 */     int nb = this.jTableAttribut.getModel().getRowCount();
/*      */     
/*      */ 
/* 1212 */     for (int i = 0; i < nb; i++) {
/* 1213 */       if ((this.jTableAttribut.getCellEditor(0, i) instanceof ProprieteBoutonCellEditor)) {
/* 1214 */         ((ProprieteBoutonCellEditor)this.jTableAttribut.getCellEditor(0, i)).setListAttribut(this.listeAttribut);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public FormeEntite2 getForme() {
/* 1220 */     return this;
/*      */   }
/*      */   
/*      */   private void changerDispqtch(IhmRelation2 rel, String nomEntAnc, String newEnt)
/*      */   {
/* 1225 */     String ent1 = "<ENTITE1>" + nomEntAnc + "</ENTITE1>";
/* 1226 */     String ent2 = "<ENTITE2>" + nomEntAnc + "</ENTITE2>";
/* 1227 */     if (rel.getDispatchKey().contains(ent1)) {
/* 1228 */       rel.setDispatchKey(rel.getDispatchKey().replace(ent1, "<ENTITE1>" + newEnt + "</ENTITE1>"));
/*      */     }
/* 1230 */     if (rel.getDispatchKey().contains(ent2)) {
/* 1231 */       rel.setDispatchKey(rel.getDispatchKey().replace(ent2, "<ENTITE2>" + newEnt + "</ENTITE2>"));
/*      */     }
/*      */   }
/*      */   
/*      */   private void modifierSQLDispatch(String oldNom, String newNom)
/*      */   {
/* 1237 */     if (oldNom.trim().toUpperCase().equals(newNom.trim().toUpperCase())) return;
/* 1238 */     if ((this.entite instanceof IhmEntite2)) {
/* 1239 */       for (int i = 0; i < this.listeLien.size(); i++) {
/* 1240 */         changerDispqtch((IhmRelation2)((IhmLien)this.listeLien.get(i)).getRelation(), oldNom, newNom);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public Color getColor(String color)
/*      */   {
/* 1248 */     return new Color(Integer.parseInt(color));
/*      */   }
/*      */   
/*      */   public String getColor(Color color) {
/* 1252 */     return color.getRGB() + "";
/*      */   }
/*      */   
/*      */   private JCheckBox jCBDegradee;
/*      */   private JCheckBox jCBHistorisation;
/*      */   private JLabel jLabCadreTitre;
/*      */   private JLabel jLabFond;
/*      */   private JLabel jLabFondTitre;
/*      */   private JLabel jLabLienColor;
/*      */   private JLabel jLabLienColor1;
/*      */   private JLabel jLabNbreAttribut;
/*      */   private JLabel jLabTexte;
/*      */   private JLabel jLabTexteTaille;
/*      */   private JLabel jLabTexteTailleDec;
/*      */   private JLabel jLabTexteTitre;
/*      */   private JLabel jLabTexteType;
/*      */   private JLabel jLabel1;
/*      */   
/*      */   private void appliquerCouleurTaille(ArrayList<Attribut> liste, String clTaille, String clTailleDec)
/*      */   {
/* 1272 */     for (int i = 0; i < liste.size(); i++) {
/* 1273 */       Attribut2 att = (Attribut2)liste.get(i);
/* 1274 */       att.setClTaille(clTaille);
/* 1275 */       att.setClTailleDecimale(clTailleDec);
/* 1276 */       if (att.getListeAttributs().size() > 0) {
/* 1277 */         appliquerCouleurTaille(att.getListeAttributs(), clTaille, clTailleDec);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void appliquerCouleurTailleEntiteRelation(IhmEntiteRelation ent, String clTaille, String clTailleDec) {
/* 1283 */     if ((ent instanceof IhmEntite2)) {
/* 1284 */       appliquerCouleurTaille(((IhmEntite2)ent).getEntite().getListeAttributs(), clTaille, clTailleDec);
/*      */     }
/* 1286 */     if ((ent instanceof IhmRelation2))
/* 1287 */       appliquerCouleurTaille(((IhmRelation2)ent).getRelation().getListeAttributs(), clTaille, clTailleDec);
/*      */   }
/*      */   
/*      */   private JLabel jLabel12;
/*      */   private JLabel jLabel13;
/*      */   
/*      */   private void appliquerCouleurTailleAllEntiteRelation(ArrayList<IhmEntiteRelation> liste, String clTaille, String clTailleDec) {
/* 1294 */     for (int i = 0; i < liste.size(); i++)
/* 1295 */       if ((liste.get(i) instanceof IhmEntite2)) {
/* 1296 */         IhmEntite2 ent = (IhmEntite2)liste.get(i);
/* 1297 */         appliquerCouleurTaille(ent.getEntite().getListeAttributs(), clTaille, clTailleDec);
/*      */       } }
/*      */   
/*      */   private JLabel jLabel14;
/*      */   private JLabel jLabel15;
/*      */   private JLabel jLabel16;
/*      */   private JLabel jLabel17;
/*      */   
/* 1305 */   private void appliquerCouleurTailleAllRelation(ArrayList<IhmEntiteRelation> liste, String clTaille, String clTailleDec) { for (int i = 0; i < liste.size(); i++)
/* 1306 */       if ((liste.get(i) instanceof IhmEntite2)) {
/* 1307 */         IhmEntite2 ent = (IhmEntite2)liste.get(i);
/* 1308 */         appliquerCouleurTaille(ent.getEntite().getListeAttributs(), clTaille, clTailleDec);
/*      */       } }
/*      */   
/*      */   private JLabel jLabel18;
/*      */   private JLabel jLabel19;
/*      */   private JLabel jLabel2;
/*      */   private JLabel jLabel20;
/*      */   private JLabel jLabel21;
/*      */   private JLabel jLabel23;
/*      */   private JLabel jLabel24;
/*      */   private JLabel jLabel25;
/*      */   private JLabel jLabel26;
/*      */   private JLabel jLabel27;
/*      */   private JLabel jLabel3;
/*      */   private JLabel jLabel4;
/*      */   private JLabel jLabel5;
/*      */   private JLabel jLabel6;
/*      */   private JLabel jLabel7;
/*      */   private JLabel jLabel8;
/*      */   private JLabel jLabel9;
/*      */   private JList jList;
/*      */   private JPanel jPanel1;
/*      */   private JPanel jPanel10;
/*      */   private JPanel jPanel11;
/*      */   private JPanel jPanel12;
/*      */   private JPanel jPanel13;
/*      */   private JPanel jPanel14;
/*      */   private JPanel jPanel15;
/*      */   private JPanel jPanel16;
/*      */   private JPanel jPanel17;
/*      */   
/* 1339 */   private void initComponents() { this.jTabbedPane1 = new JTabbedPane();
/* 1340 */     this.jPanel2 = new JPanel();
/* 1341 */     this.jPanel10 = new JPanel();
/* 1342 */     this.jScrollPane1 = new JScrollPane();
/* 1343 */     this.jTableAttribut = new JTable();
/* 1344 */     this.jBtRemonter = new JButton();
/* 1345 */     this.jBtDescendre = new JButton();
/* 1346 */     this.jBtDisctioonaire = new JButton();
/* 1347 */     this.jBtImporterAttribut = new JButton();
/* 1348 */     this.jScrollPane3 = new JScrollPane();
/* 1349 */     this.jTACommentaireAtt = new JTextArea();
/* 1350 */     this.jLabel9 = new JLabel();
/* 1351 */     this.jPanel12 = new JPanel();
/* 1352 */     this.jBTAjouter = new JButton();
/* 1353 */     this.jBtSupprimer = new JButton();
/* 1354 */     this.jBtPropriete = new JButton();
/* 1355 */     this.jLabNbreAttribut = new JLabel();
/* 1356 */     this.jLabel15 = new JLabel();
/* 1357 */     this.jLabel16 = new JLabel();
/* 1358 */     this.jLabel21 = new JLabel();
/* 1359 */     this.jPanel1 = new JPanel();
/* 1360 */     this.jLabel2 = new JLabel();
/* 1361 */     this.jPanel4 = new JPanel();
/* 1362 */     this.jLabel3 = new JLabel();
/* 1363 */     this.jLabel5 = new JLabel();
/* 1364 */     this.jLabel4 = new JLabel();
/* 1365 */     this.jLabel6 = new JLabel();
/* 1366 */     this.jTFCreation = new JTextField();
/* 1367 */     this.jTFModification = new JTextField();
/* 1368 */     this.jTFModificationDev = new JTextField();
/* 1369 */     this.jTFCreationDev = new JTextField();
/* 1370 */     this.jBTHistorique = new JButton();
/* 1371 */     this.jScrollPane2 = new JScrollPane();
/* 1372 */     this.jTAcommentaire = new JTextArea();
/* 1373 */     this.jPanel3 = new JPanel();
/* 1374 */     this.jPanelAprecu = new JPanel();
/* 1375 */     this.jPanel7 = new JPanel();
/* 1376 */     this.jPanel8 = new JPanel();
/* 1377 */     this.jLabel7 = new JLabel();
/* 1378 */     this.jPanel14 = new JPanel();
/* 1379 */     this.jLabel12 = new JLabel();
/* 1380 */     this.jLabel13 = new JLabel();
/* 1381 */     this.jLabTexteTitre = new JLabel();
/* 1382 */     this.jLabFondTitre = new JLabel();
/* 1383 */     this.jLabCadreTitre = new JLabel();
/* 1384 */     this.jLabel17 = new JLabel();
/* 1385 */     this.jPanel15 = new JPanel();
/* 1386 */     this.jLabel18 = new JLabel();
/* 1387 */     this.jLabel19 = new JLabel();
/* 1388 */     this.jLabTexte = new JLabel();
/* 1389 */     this.jLabFond = new JLabel();
/* 1390 */     this.jLabel20 = new JLabel();
/* 1391 */     this.jLabTexteType = new JLabel();
/* 1392 */     this.jPanel16 = new JPanel();
/* 1393 */     this.jLabel24 = new JLabel();
/* 1394 */     this.jLabLienColor = new JLabel();
/* 1395 */     this.jPanel18 = new JPanel();
/* 1396 */     this.jLabTexteTaille = new JLabel();
/* 1397 */     this.jLabel25 = new JLabel();
/* 1398 */     this.jLabel26 = new JLabel();
/* 1399 */     this.jLabTexteTailleDec = new JLabel();
/* 1400 */     this.jCBAppliquerDefaut = new JCheckBox();
/* 1401 */     this.jLabel14 = new JLabel();
/* 1402 */     this.jCBDegradee = new JCheckBox();
/* 1403 */     this.jCBAppliquerAtoute = new JCheckBox();
/* 1404 */     this.jCBAppliquerClAttribut = new JCheckBox();
/* 1405 */     this.jPanel11 = new JPanel();
/* 1406 */     this.jPanelApercuLien = new JPanel();
/* 1407 */     this.jPanel13 = new JPanel();
/* 1408 */     this.jScrollPane4 = new JScrollPane();
/* 1409 */     this.jList = new JList();
/* 1410 */     this.jLabel23 = new JLabel();
/* 1411 */     this.jTFNomEntite = new JTextField();
/* 1412 */     this.jLabel1 = new JLabel();
/* 1413 */     this.jLabel8 = new JLabel();
/* 1414 */     this.jTFCodeEntite = new JTextField();
/* 1415 */     this.jPanel5 = new JPanel();
/* 1416 */     this.jBtAnnuler = new JButton();
/* 1417 */     this.jBtValider = new JButton();
/* 1418 */     this.jCBHistorisation = new JCheckBox();
/*      */     
/* 1420 */     setDefaultCloseOperation(2);
/* 1421 */     setResizable(false);
/*      */     
/* 1423 */     this.jTabbedPane1.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
/*      */     
/* 1425 */     this.jTableAttribut.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, { null, null, null, null, null, null, null } }, new String[] { "Nom", "code", "Type", "Clé", "Taille", "Décimale", "Afficher" })
/*      */     {
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
/* 1449 */       Class[] types = { Object.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class, Boolean.class };
/*      */       
/*      */ 
/*      */       public Class getColumnClass(int columnIndex)
/*      */       {
/* 1454 */         return this.types[columnIndex];
/*      */       }
/* 1456 */     });
/* 1457 */     this.jTableAttribut.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1459 */         FormeEntite2.this.jTableAttributMouseClicked(evt);
/*      */       }
/* 1461 */     });
/* 1462 */     this.jTableAttribut.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
/*      */       public void propertyChange(java.beans.PropertyChangeEvent evt) {
/* 1464 */         FormeEntite2.this.jTableAttributPropertyChange(evt);
/*      */       }
/* 1466 */     });
/* 1467 */     this.jTableAttribut.addKeyListener(new java.awt.event.KeyAdapter() {
/*      */       public void keyPressed(KeyEvent evt) {
/* 1469 */         FormeEntite2.this.jTableAttributKeyPressed(evt);
/*      */       }
/*      */       
/* 1472 */       public void keyReleased(KeyEvent evt) { FormeEntite2.this.jTableAttributKeyReleased(evt);
/*      */       }
/* 1474 */     });
/* 1475 */     this.jScrollPane1.setViewportView(this.jTableAttribut);
/*      */     
/* 1477 */     this.jBtRemonter.setIcon(new ImageIcon(getClass().getResource("/Images/monter.png")));
/* 1478 */     this.jBtRemonter.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1480 */         FormeEntite2.this.jBtRemonterActionPerformed(evt);
/*      */       }
/*      */       
/* 1483 */     });
/* 1484 */     this.jBtDescendre.setIcon(new ImageIcon(getClass().getResource("/Images/descendre.png")));
/* 1485 */     this.jBtDescendre.setPreferredSize(new java.awt.Dimension(49, 30));
/* 1486 */     this.jBtDescendre.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1488 */         FormeEntite2.this.jBtDescendreActionPerformed(evt);
/*      */       }
/*      */       
/* 1491 */     });
/* 1492 */     this.jBtDisctioonaire.setFont(new Font("Tahoma", 1, 11));
/* 1493 */     this.jBtDisctioonaire.setForeground(new Color(255, 0, 51));
/* 1494 */     this.jBtDisctioonaire.setText("Dictionnaire de données ");
/* 1495 */     this.jBtDisctioonaire.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1497 */         FormeEntite2.this.jBtDisctioonaireActionPerformed(evt);
/*      */       }
/*      */       
/* 1500 */     });
/* 1501 */     this.jBtImporterAttribut.setFont(new Font("Tahoma", 1, 11));
/* 1502 */     this.jBtImporterAttribut.setForeground(new Color(0, 0, 153));
/* 1503 */     this.jBtImporterAttribut.setText("Importer des attributs");
/* 1504 */     this.jBtImporterAttribut.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1506 */         FormeEntite2.this.jBtImporterAttributActionPerformed(evt);
/*      */       }
/*      */       
/* 1509 */     });
/* 1510 */     this.jTACommentaireAtt.setColumns(20);
/* 1511 */     this.jTACommentaireAtt.setFont(new Font("Monospaced", 0, 14));
/* 1512 */     this.jTACommentaireAtt.setRows(3);
/* 1513 */     this.jTACommentaireAtt.addFocusListener(new java.awt.event.FocusAdapter() {
/*      */       public void focusLost(FocusEvent evt) {
/* 1515 */         FormeEntite2.this.jTACommentaireAttFocusLost(evt);
/*      */       }
/* 1517 */     });
/* 1518 */     this.jTACommentaireAtt.addKeyListener(new java.awt.event.KeyAdapter() {
/*      */       public void keyPressed(KeyEvent evt) {
/* 1520 */         FormeEntite2.this.jTACommentaireAttKeyPressed(evt);
/*      */       }
/*      */       
/* 1523 */       public void keyReleased(KeyEvent evt) { FormeEntite2.this.jTACommentaireAttKeyReleased(evt);
/*      */       }
/* 1525 */     });
/* 1526 */     this.jScrollPane3.setViewportView(this.jTACommentaireAtt);
/*      */     
/* 1528 */     this.jLabel9.setText("Commentaire attribut ");
/*      */     
/* 1530 */     this.jBTAjouter.setIcon(new ImageIcon(getClass().getResource("/Images/Ajouter.png")));
/* 1531 */     this.jBTAjouter.setToolTipText("Ajouter un attribut");
/* 1532 */     this.jBTAjouter.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1534 */         FormeEntite2.this.jBTAjouterActionPerformed(evt);
/*      */       }
/*      */       
/* 1537 */     });
/* 1538 */     this.jBtSupprimer.setIcon(new ImageIcon(getClass().getResource("/Images/supprimer.png")));
/* 1539 */     this.jBtSupprimer.setToolTipText("supprimer un attribut");
/* 1540 */     this.jBtSupprimer.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1542 */         FormeEntite2.this.jBtSupprimerActionPerformed(evt);
/*      */       }
/*      */       
/* 1545 */     });
/* 1546 */     this.jBtPropriete.setIcon(new ImageIcon(getClass().getResource("/Images/oeil.png")));
/* 1547 */     this.jBtPropriete.setText("Propiétés");
/* 1548 */     this.jBtPropriete.setToolTipText("voir propriétés d'un attribut");
/* 1549 */     this.jBtPropriete.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1551 */         FormeEntite2.this.jBtProprieteActionPerformed(evt);
/*      */       }
/*      */       
/* 1554 */     });
/* 1555 */     GroupLayout jPanel12Layout = new GroupLayout(this.jPanel12);
/* 1556 */     this.jPanel12.setLayout(jPanel12Layout);
/* 1557 */     jPanel12Layout.setHorizontalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup().addContainerGap().addGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jBtPropriete, GroupLayout.Alignment.LEADING, -1, 113, 32767).addComponent(this.jBTAjouter, GroupLayout.Alignment.LEADING, -1, 113, 32767).addComponent(this.jBtSupprimer, GroupLayout.Alignment.LEADING, -1, 113, 32767)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1567 */     jPanel12Layout.setVerticalGroup(jPanel12Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel12Layout.createSequentialGroup().addContainerGap().addComponent(this.jBTAjouter).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtSupprimer).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtPropriete, -1, -1, 32767).addContainerGap()));
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
/* 1579 */     this.jLabNbreAttribut.setText("0");
/*      */     
/* 1581 */     this.jLabel15.setText("Nombre d'attributs");
/*      */     
/* 1583 */     this.jLabel16.setBackground(new Color(255, 150, 125));
/* 1584 */     this.jLabel16.setText("      ");
/* 1585 */     this.jLabel16.setOpaque(true);
/*      */     
/* 1587 */     this.jLabel21.setText("Attribut composé");
/*      */     
/* 1589 */     GroupLayout jPanel10Layout = new GroupLayout(this.jPanel10);
/* 1590 */     this.jPanel10.setLayout(jPanel10Layout);
/* 1591 */     jPanel10Layout.setHorizontalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 843, 32767).addGroup(jPanel10Layout.createSequentialGroup().addComponent(this.jBtDisctioonaire, -2, 235, -2).addGap(41, 41, 41).addComponent(this.jLabel15).addGap(18, 18, 18).addComponent(this.jLabNbreAttribut, -2, 46, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabel16, -2, 32, -2).addGap(18, 18, 18).addComponent(this.jLabel21).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 60, 32767).addComponent(this.jBtImporterAttribut, -2, 212, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addComponent(this.jLabel9).addGap(350, 350, 350).addComponent(this.jBtRemonter, -2, 72, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtDescendre, -2, 68, -2)).addComponent(this.jScrollPane3, -1, 704, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel12, -2, -1, -2))).addContainerGap()));
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
/* 1622 */     jPanel10Layout.setVerticalGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel10Layout.createSequentialGroup().addContainerGap().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtDisctioonaire).addComponent(this.jBtImporterAttribut, -2, 23, -2).addComponent(this.jLabel15).addComponent(this.jLabNbreAttribut, -2, 18, -2).addComponent(this.jLabel16).addComponent(this.jLabel21)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -2, 297, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel10Layout.createSequentialGroup().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel10Layout.createSequentialGroup().addGroup(jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jBtRemonter, -1, -1, 32767).addComponent(this.jBtDescendre, 0, 0, 32767)).addGap(3, 3, 3)).addComponent(this.jLabel9)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -1, 81, 32767)).addComponent(this.jPanel12, -2, -1, -2)).addContainerGap()));
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
/* 1651 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1652 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1653 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel10, -1, -1, 32767));
/*      */     
/*      */ 
/*      */ 
/* 1657 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jPanel10, -2, -1, -2).addContainerGap(-1, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1664 */     this.jTabbedPane1.addTab("Liste d'attribut", this.jPanel2);
/*      */     
/* 1666 */     this.jLabel2.setText("Commentaire");
/*      */     
/* 1668 */     this.jPanel4.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/* 1670 */     this.jLabel3.setText("Création");
/*      */     
/* 1672 */     this.jLabel5.setText("Développeur");
/*      */     
/* 1674 */     this.jLabel4.setText("Modification");
/*      */     
/* 1676 */     this.jLabel6.setText("Développeur");
/*      */     
/* 1678 */     this.jTFCreation.setEditable(false);
/*      */     
/* 1680 */     this.jTFModification.setEditable(false);
/*      */     
/* 1682 */     this.jTFModificationDev.setEditable(false);
/*      */     
/* 1684 */     this.jTFCreationDev.setEditable(false);
/*      */     
/* 1686 */     this.jBTHistorique.setText("Historique");
/* 1687 */     this.jBTHistorique.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1689 */         FormeEntite2.this.jBTHistoriqueActionPerformed(evt);
/*      */       }
/*      */       
/* 1692 */     });
/* 1693 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 1694 */     this.jPanel4.setLayout(jPanel4Layout);
/* 1695 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3).addComponent(this.jLabel5)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jTFCreation).addComponent(this.jTFCreationDev, -1, 217, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 89, 32767).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel4).addComponent(this.jLabel6)).addGap(22, 22, 22).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTFModificationDev, -1, 207, 32767).addComponent(this.jTFModification, -2, 207, -2)).addGap(37, 37, 37).addComponent(this.jBTHistorique, -2, 109, -2).addContainerGap()));
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
/* 1718 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFModificationDev, -2, -1, -2).addComponent(this.jLabel6)).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTFCreation, -2, -1, -2).addComponent(this.jLabel4).addComponent(this.jTFModification, -2, -1, -2).addComponent(this.jBTHistorique)).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jTFCreationDev, -2, -1, -2)))).addContainerGap(-1, 32767)));
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
/* 1740 */     this.jTAcommentaire.setColumns(20);
/* 1741 */     this.jTAcommentaire.setFont(new Font("Monospaced", 1, 14));
/* 1742 */     this.jTAcommentaire.setRows(5);
/* 1743 */     this.jScrollPane2.setViewportView(this.jTAcommentaire);
/*      */     
/* 1745 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1746 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1747 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel2).addGap(0, 0, 0)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel4, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jScrollPane2, -1, 843, 32767)).addContainerGap()))));
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
/* 1761 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 324, 32767).addGap(18, 18, 18).addComponent(this.jPanel4, -2, -1, -2).addContainerGap()));
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
/* 1773 */     this.jTabbedPane1.addTab("Commentaire/historique", this.jPanel1);
/*      */     
/* 1775 */     this.jPanel3.addComponentListener(new java.awt.event.ComponentAdapter() {
/*      */       public void componentShown(ComponentEvent evt) {
/* 1777 */         FormeEntite2.this.jPanel3ComponentShown(evt);
/*      */       }
/* 1779 */     });
/* 1780 */     this.jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
/*      */       public void mouseMoved(MouseEvent evt) {
/* 1782 */         FormeEntite2.this.jPanel3MouseMoved(evt);
/*      */       }
/*      */       
/* 1785 */     });
/* 1786 */     this.jPanelAprecu.setBackground(new Color(255, 255, 255));
/* 1787 */     this.jPanelAprecu.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1788 */     this.jPanelAprecu.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1790 */         FormeEntite2.this.jPanelAprecuMouseClicked(evt);
/*      */       }
/*      */       
/* 1793 */     });
/* 1794 */     GroupLayout jPanelAprecuLayout = new GroupLayout(this.jPanelAprecu);
/* 1795 */     this.jPanelAprecu.setLayout(jPanelAprecuLayout);
/* 1796 */     jPanelAprecuLayout.setHorizontalGroup(jPanelAprecuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 286, 32767));
/*      */     
/*      */ 
/*      */ 
/* 1800 */     jPanelAprecuLayout.setVerticalGroup(jPanelAprecuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 269, 32767));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1805 */     this.jPanel8.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/* 1807 */     this.jLabel7.setText("Couleurs");
/*      */     
/* 1809 */     this.jPanel14.setBorder(BorderFactory.createTitledBorder("Titre"));
/*      */     
/* 1811 */     this.jLabel12.setHorizontalAlignment(0);
/* 1812 */     this.jLabel12.setText("Fond");
/* 1813 */     this.jLabel12.setCursor(new Cursor(9));
/* 1814 */     this.jLabel12.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1816 */         FormeEntite2.this.jLabel12MouseClicked(evt);
/*      */       }
/*      */       
/* 1819 */     });
/* 1820 */     this.jLabel13.setHorizontalAlignment(0);
/* 1821 */     this.jLabel13.setText("Titre");
/*      */     
/* 1823 */     this.jLabTexteTitre.setBackground(new Color(0, 0, 0));
/* 1824 */     this.jLabTexteTitre.setHorizontalAlignment(0);
/* 1825 */     this.jLabTexteTitre.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1826 */     this.jLabTexteTitre.setCursor(new Cursor(12));
/* 1827 */     this.jLabTexteTitre.setOpaque(true);
/* 1828 */     this.jLabTexteTitre.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1830 */         FormeEntite2.this.jLabTexteTitreMouseClicked(evt);
/*      */       }
/*      */       
/* 1833 */     });
/* 1834 */     this.jLabFondTitre.setBackground(new Color(153, 255, 153));
/* 1835 */     this.jLabFondTitre.setHorizontalAlignment(0);
/* 1836 */     this.jLabFondTitre.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1837 */     this.jLabFondTitre.setCursor(new Cursor(12));
/* 1838 */     this.jLabFondTitre.setOpaque(true);
/* 1839 */     this.jLabFondTitre.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1841 */         FormeEntite2.this.jLabFondTitreMouseClicked(evt);
/*      */       }
/*      */       
/* 1844 */     });
/* 1845 */     this.jLabCadreTitre.setBackground(new Color(0, 0, 0));
/* 1846 */     this.jLabCadreTitre.setHorizontalAlignment(0);
/* 1847 */     this.jLabCadreTitre.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1848 */     this.jLabCadreTitre.setCursor(new Cursor(12));
/* 1849 */     this.jLabCadreTitre.setOpaque(true);
/* 1850 */     this.jLabCadreTitre.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1852 */         FormeEntite2.this.jLabCadreTitreMouseClicked(evt);
/*      */       }
/*      */       
/* 1855 */     });
/* 1856 */     this.jLabel17.setHorizontalAlignment(0);
/* 1857 */     this.jLabel17.setText("Cadre");
/*      */     
/* 1859 */     GroupLayout jPanel14Layout = new GroupLayout(this.jPanel14);
/* 1860 */     this.jPanel14.setLayout(jPanel14Layout);
/* 1861 */     jPanel14Layout.setHorizontalGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup().addContainerGap().addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel12, -1, -1, 32767).addComponent(this.jLabFondTitre, -1, 70, 32767)).addGap(85, 85, 85).addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel13, -1, 70, 32767).addComponent(this.jLabTexteTitre, -1, 70, 32767)).addGap(119, 119, 119).addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel17, -1, 63, 32767).addComponent(this.jLabCadreTitre, -1, 63, 32767)).addGap(66, 66, 66)));
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
/* 1878 */     jPanel14Layout.setVerticalGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel14Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel12).addComponent(this.jLabel13).addComponent(this.jLabel17)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel14Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabFondTitre, -1, 17, 32767).addComponent(this.jLabTexteTitre, -1, -1, 32767).addComponent(this.jLabCadreTitre, -1, -1, 32767)).addContainerGap(-1, 32767)));
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
/* 1894 */     this.jPanel15.setBorder(BorderFactory.createTitledBorder("Attributs"));
/*      */     
/* 1896 */     this.jLabel18.setHorizontalAlignment(0);
/* 1897 */     this.jLabel18.setText("Fond");
/* 1898 */     this.jLabel18.setCursor(new Cursor(8));
/* 1899 */     this.jLabel18.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1901 */         FormeEntite2.this.jLabel18MouseClicked(evt);
/*      */       }
/*      */       
/* 1904 */     });
/* 1905 */     this.jLabel19.setHorizontalAlignment(0);
/* 1906 */     this.jLabel19.setText("Nom");
/* 1907 */     this.jLabel19.setCursor(new Cursor(11));
/* 1908 */     this.jLabel19.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1910 */         FormeEntite2.this.jLabel19MouseClicked(evt);
/*      */       }
/*      */       
/* 1913 */     });
/* 1914 */     this.jLabTexte.setBackground(new Color(0, 0, 0));
/* 1915 */     this.jLabTexte.setHorizontalAlignment(0);
/* 1916 */     this.jLabTexte.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1917 */     this.jLabTexte.setCursor(new Cursor(12));
/* 1918 */     this.jLabTexte.setOpaque(true);
/* 1919 */     this.jLabTexte.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1921 */         FormeEntite2.this.jLabTexteMouseClicked(evt);
/*      */       }
/*      */       
/* 1924 */     });
/* 1925 */     this.jLabFond.setBackground(new Color(255, 255, 51));
/* 1926 */     this.jLabFond.setHorizontalAlignment(0);
/* 1927 */     this.jLabFond.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1928 */     this.jLabFond.setCursor(new Cursor(12));
/* 1929 */     this.jLabFond.setOpaque(true);
/* 1930 */     this.jLabFond.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1932 */         FormeEntite2.this.jLabFondMouseClicked(evt);
/*      */       }
/*      */       
/* 1935 */     });
/* 1936 */     this.jLabel20.setHorizontalAlignment(0);
/* 1937 */     this.jLabel20.setText("Type");
/* 1938 */     this.jLabel20.setCursor(new Cursor(10));
/* 1939 */     this.jLabel20.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1941 */         FormeEntite2.this.jLabel20MouseClicked(evt);
/*      */       }
/*      */       
/* 1944 */     });
/* 1945 */     this.jLabTexteType.setBackground(new Color(0, 0, 0));
/* 1946 */     this.jLabTexteType.setHorizontalAlignment(0);
/* 1947 */     this.jLabTexteType.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 1948 */     this.jLabTexteType.setCursor(new Cursor(12));
/* 1949 */     this.jLabTexteType.setOpaque(true);
/* 1950 */     this.jLabTexteType.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1952 */         FormeEntite2.this.jLabTexteTypeMouseClicked(evt);
/*      */       }
/*      */       
/* 1955 */     });
/* 1956 */     GroupLayout jPanel15Layout = new GroupLayout(this.jPanel15);
/* 1957 */     this.jPanel15.setLayout(jPanel15Layout);
/* 1958 */     jPanel15Layout.setHorizontalGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup().addContainerGap().addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel18, -1, -1, 32767).addComponent(this.jLabFond, -1, 70, 32767)).addGap(83, 83, 83).addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel19, -1, -1, 32767).addComponent(this.jLabTexte, -1, 63, 32767)).addGap(128, 128, 128).addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jLabel20, -1, -1, 32767).addComponent(this.jLabTexteType, -1, 68, 32767)).addContainerGap(61, 32767)));
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
/* 1975 */     jPanel15Layout.setVerticalGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel15Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel15Layout.createSequentialGroup().addComponent(this.jLabel18).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabFond, -1, 17, 32767)).addGroup(jPanel15Layout.createSequentialGroup().addComponent(this.jLabel20, -2, 14, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabTexteType, -1, 17, 32767)).addGroup(jPanel15Layout.createSequentialGroup().addComponent(this.jLabel19, -2, 14, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabTexte, -1, 17, 32767))).addContainerGap()));
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
/* 1995 */     this.jPanel16.setBorder(BorderFactory.createTitledBorder("Liens sortants lors de la séléction  "));
/*      */     
/* 1997 */     this.jLabel24.setHorizontalAlignment(0);
/* 1998 */     this.jLabel24.setText("Lien");
/*      */     
/* 2000 */     this.jLabLienColor.setBackground(new Color(0, 0, 204));
/* 2001 */     this.jLabLienColor.setHorizontalAlignment(0);
/* 2002 */     this.jLabLienColor.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 2003 */     this.jLabLienColor.setCursor(new Cursor(12));
/* 2004 */     this.jLabLienColor.setOpaque(true);
/* 2005 */     this.jLabLienColor.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 2007 */         FormeEntite2.this.jLabLienColorMouseClicked(evt);
/*      */       }
/*      */       
/* 2010 */     });
/* 2011 */     GroupLayout jPanel16Layout = new GroupLayout(this.jPanel16);
/* 2012 */     this.jPanel16.setLayout(jPanel16Layout);
/* 2013 */     jPanel16Layout.setHorizontalGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup().addGap(200, 200, 200).addGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabLienColor, -2, 68, -2).addComponent(this.jLabel24, -1, 68, 32767)).addGap(215, 215, 215)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2022 */     jPanel16Layout.setVerticalGroup(jPanel16Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel16Layout.createSequentialGroup().addComponent(this.jLabel24).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabLienColor, -2, 16, -2).addContainerGap(-1, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2031 */     this.jPanel18.setBorder(BorderFactory.createTitledBorder("Couleurs taille attributs"));
/*      */     
/* 2033 */     this.jLabTexteTaille.setBackground(new Color(0, 0, 0));
/* 2034 */     this.jLabTexteTaille.setHorizontalAlignment(0);
/* 2035 */     this.jLabTexteTaille.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 2036 */     this.jLabTexteTaille.setCursor(new Cursor(12));
/* 2037 */     this.jLabTexteTaille.setOpaque(true);
/* 2038 */     this.jLabTexteTaille.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 2040 */         FormeEntite2.this.jLabTexteTailleMouseClicked(evt);
/*      */       }
/*      */       
/* 2043 */     });
/* 2044 */     this.jLabel25.setHorizontalAlignment(0);
/* 2045 */     this.jLabel25.setText("Taille");
/* 2046 */     this.jLabel25.setCursor(new Cursor(10));
/* 2047 */     this.jLabel25.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 2049 */         FormeEntite2.this.jLabel25MouseClicked(evt);
/*      */       }
/*      */       
/* 2052 */     });
/* 2053 */     this.jLabel26.setHorizontalAlignment(0);
/* 2054 */     this.jLabel26.setText("Taille Dec");
/* 2055 */     this.jLabel26.setCursor(new Cursor(10));
/* 2056 */     this.jLabel26.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 2058 */         FormeEntite2.this.jLabel26MouseClicked(evt);
/*      */       }
/*      */       
/* 2061 */     });
/* 2062 */     this.jLabTexteTailleDec.setBackground(new Color(0, 0, 0));
/* 2063 */     this.jLabTexteTailleDec.setHorizontalAlignment(0);
/* 2064 */     this.jLabTexteTailleDec.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 2065 */     this.jLabTexteTailleDec.setCursor(new Cursor(12));
/* 2066 */     this.jLabTexteTailleDec.setOpaque(true);
/* 2067 */     this.jLabTexteTailleDec.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 2069 */         FormeEntite2.this.jLabTexteTailleDecMouseClicked(evt);
/*      */       }
/*      */       
/* 2072 */     });
/* 2073 */     GroupLayout jPanel18Layout = new GroupLayout(this.jPanel18);
/* 2074 */     this.jPanel18.setLayout(jPanel18Layout);
/* 2075 */     jPanel18Layout.setHorizontalGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup().addGap(113, 113, 113).addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel25, -1, -1, 32767).addComponent(this.jLabTexteTaille, -2, 66, -2)).addGap(175, 175, 175).addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel26, -1, 65, 32767).addComponent(this.jLabTexteTailleDec, -1, 65, 32767)).addGap(64, 64, 64)));
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
/* 2088 */     jPanel18Layout.setVerticalGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel18Layout.createSequentialGroup().addGroup(jPanel18Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel18Layout.createSequentialGroup().addComponent(this.jLabel25, -2, 14, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabTexteTaille, -2, 17, -2)).addGroup(jPanel18Layout.createSequentialGroup().addComponent(this.jLabel26, -2, 14, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabTexteTailleDec, -1, 17, 32767))).addGap(10, 10, 10)));
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
/* 2103 */     GroupLayout jPanel8Layout = new GroupLayout(this.jPanel8);
/* 2104 */     this.jPanel8.setLayout(jPanel8Layout);
/* 2105 */     jPanel8Layout.setHorizontalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup().addContainerGap().addGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel18, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel16, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup().addGap(238, 238, 238).addComponent(this.jLabel7)).addComponent(this.jPanel14, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel15, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
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
/* 2119 */     jPanel8Layout.setVerticalGroup(jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel8Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel14, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel15, -2, -1, -2).addGap(18, 18, 18).addComponent(this.jPanel18, -1, 74, 32767).addGap(18, 18, 18).addComponent(this.jPanel16, -2, -1, -2).addGap(33, 33, 33)));
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
/* 2135 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/* 2136 */     this.jPanel7.setLayout(jPanel7Layout);
/* 2137 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel8, -1, -1, 32767).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2144 */     jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel8, -1, -1, 32767).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2152 */     this.jCBAppliquerDefaut.setText("Appliquer ces couleurs par défaut pour les entités");
/* 2153 */     this.jCBAppliquerDefaut.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2155 */         FormeEntite2.this.jCBAppliquerDefautActionPerformed(evt);
/*      */       }
/*      */       
/* 2158 */     });
/* 2159 */     this.jLabel14.setFont(new Font("Tahoma", 1, 11));
/* 2160 */     this.jLabel14.setForeground(new Color(0, 0, 153));
/* 2161 */     this.jLabel14.setIcon(new ImageIcon(getClass().getResource("/Images/oeil.png")));
/* 2162 */     this.jLabel14.setText("Aperçu");
/* 2163 */     this.jLabel14.setCursor(new Cursor(12));
/* 2164 */     this.jLabel14.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 2166 */         FormeEntite2.this.jLabel14MouseClicked(evt);
/*      */       }
/*      */       
/* 2169 */     });
/* 2170 */     this.jCBDegradee.setText("Voir dégradée");
/* 2171 */     this.jCBDegradee.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2173 */         FormeEntite2.this.jCBDegradeeActionPerformed(evt);
/*      */       }
/*      */       
/* 2176 */     });
/* 2177 */     this.jCBAppliquerAtoute.setText("Appliquer à toutes les ");
/*      */     
/* 2179 */     this.jCBAppliquerClAttribut.setText("Appliquer les couleurs des tailles aux attributs ");
/*      */     
/* 2181 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 2182 */     this.jPanel3.setLayout(jPanel3Layout);
/* 2183 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel7, -1, -1, 32767).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jCBAppliquerDefaut).addContainerGap()).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jCBAppliquerClAttribut).addContainerGap()).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jCBAppliquerAtoute).addContainerGap()).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jCBDegradee).addContainerGap()).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jPanelAprecu, -1, -1, 32767).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addComponent(this.jLabel14).addGap(126, 126, 126))))))));
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
/* 2212 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(15, 15, 15).addComponent(this.jPanelAprecu, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel14).addGap(8, 8, 8).addComponent(this.jCBDegradee).addGap(18, 18, 18).addComponent(this.jCBAppliquerDefaut).addGap(8, 8, 8).addComponent(this.jCBAppliquerClAttribut).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBAppliquerAtoute)).addComponent(this.jPanel7, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
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
/* 2234 */     this.jTabbedPane1.addTab("Affichage", this.jPanel3);
/*      */     
/* 2236 */     this.jPanel11.addComponentListener(new java.awt.event.ComponentAdapter() {
/*      */       public void componentShown(ComponentEvent evt) {
/* 2238 */         FormeEntite2.this.jPanel11ComponentShown(evt);
/*      */       }
/*      */       
/* 2241 */     });
/* 2242 */     this.jPanelApercuLien.setBackground(new Color(250, 250, 241));
/* 2243 */     this.jPanelApercuLien.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 2245 */         FormeEntite2.this.jPanelApercuLienMouseClicked(evt);
/*      */       }
/*      */       
/* 2248 */     });
/* 2249 */     GroupLayout jPanelApercuLienLayout = new GroupLayout(this.jPanelApercuLien);
/* 2250 */     this.jPanelApercuLien.setLayout(jPanelApercuLienLayout);
/* 2251 */     jPanelApercuLienLayout.setHorizontalGroup(jPanelApercuLienLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 843, 32767));
/*      */     
/*      */ 
/*      */ 
/* 2255 */     jPanelApercuLienLayout.setVerticalGroup(jPanelApercuLienLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 126, 32767));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 2260 */     this.jPanel13.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/* 2262 */     this.jList.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 2264 */         FormeEntite2.this.jListMouseClicked(evt);
/*      */       }
/*      */       
/* 2267 */       public void mousePressed(MouseEvent evt) { FormeEntite2.this.jListMousePressed(evt);
/*      */       }
/* 2269 */     });
/* 2270 */     this.jList.addKeyListener(new java.awt.event.KeyAdapter() {
/*      */       public void keyReleased(KeyEvent evt) {
/* 2272 */         FormeEntite2.this.jListKeyReleased(evt);
/*      */       }
/* 2274 */     });
/* 2275 */     this.jScrollPane4.setViewportView(this.jList);
/*      */     
/* 2277 */     this.jLabel23.setText("Les Liens");
/*      */     
/* 2279 */     GroupLayout jPanel13Layout = new GroupLayout(this.jPanel13);
/* 2280 */     this.jPanel13.setLayout(jPanel13Layout);
/* 2281 */     jPanel13Layout.setHorizontalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel13Layout.createSequentialGroup().addContainerGap().addGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane4, -1, 821, 32767).addComponent(this.jLabel23)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2290 */     jPanel13Layout.setVerticalGroup(jPanel13Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jLabel23).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane4, -2, 243, -2).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2300 */     GroupLayout jPanel11Layout = new GroupLayout(this.jPanel11);
/* 2301 */     this.jPanel11.setLayout(jPanel11Layout);
/* 2302 */     jPanel11Layout.setHorizontalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup().addContainerGap().addGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanelApercuLien, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel13, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2311 */     jPanel11Layout.setVerticalGroup(jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(this.jPanelApercuLien, -1, -1, 32767).addGap(18, 18, 18).addComponent(this.jPanel13, -2, -1, -2).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2321 */     this.jTabbedPane1.addTab("Liens", this.jPanel11);
/*      */     
/* 2323 */     this.jTFNomEntite.setFont(new Font("Arial", 1, 14));
/* 2324 */     this.jTFNomEntite.addKeyListener(new java.awt.event.KeyAdapter() {
/*      */       public void keyReleased(KeyEvent evt) {
/* 2326 */         FormeEntite2.this.jTFNomEntiteKeyReleased(evt);
/*      */       }
/*      */       
/* 2329 */     });
/* 2330 */     this.jLabel1.setText("Nom");
/*      */     
/* 2332 */     this.jLabel8.setText("Code");
/*      */     
/* 2334 */     this.jTFCodeEntite.setFont(new Font("Arial", 1, 14));
/* 2335 */     this.jTFCodeEntite.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 2337 */         FormeEntite2.this.jTFCodeEntiteMouseClicked(evt);
/*      */       }
/* 2339 */     });
/* 2340 */     this.jTFCodeEntite.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2342 */         FormeEntite2.this.jTFCodeEntiteActionPerformed(evt);
/*      */       }
/* 2344 */     });
/* 2345 */     this.jTFCodeEntite.addFocusListener(new java.awt.event.FocusAdapter() {
/*      */       public void focusGained(FocusEvent evt) {
/* 2347 */         FormeEntite2.this.jTFCodeEntiteFocusGained(evt);
/*      */       }
/*      */       
/* 2350 */     });
/* 2351 */     this.jPanel5.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*      */     
/* 2353 */     this.jBtAnnuler.setIcon(new ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 2354 */     this.jBtAnnuler.setText("Annuler");
/* 2355 */     this.jBtAnnuler.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2357 */         FormeEntite2.this.jBtAnnulerActionPerformed(evt);
/*      */       }
/*      */       
/* 2360 */     });
/* 2361 */     this.jBtValider.setIcon(new ImageIcon(getClass().getResource("/Images/OK.png")));
/* 2362 */     this.jBtValider.setText("Valider");
/* 2363 */     this.jBtValider.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 2365 */         FormeEntite2.this.jBtValiderActionPerformed(evt);
/*      */       }
/*      */       
/* 2368 */     });
/* 2369 */     this.jCBHistorisation.setText("Historisation");
/*      */     
/* 2371 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 2372 */     this.jPanel5.setLayout(jPanel5Layout);
/* 2373 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jCBHistorisation).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 552, 32767).addComponent(this.jBtAnnuler, -2, 108, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtValider, -2, 101, -2).addContainerGap()));
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
/* 2384 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler).addComponent(this.jCBHistorisation)).addContainerGap()));
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
/* 2395 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 2396 */     getContentPane().setLayout(layout);
/* 2397 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1, -2, 35, -2).addGap(18, 18, 18).addComponent(this.jTFNomEntite, -2, 338, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, 32767).addComponent(this.jLabel8).addGap(18, 18, 18).addComponent(this.jTFCodeEntite, -2, 392, -2)).addComponent(this.jTabbedPane1, -1, 870, 32767).addComponent(this.jPanel5, GroupLayout.Alignment.TRAILING, -1, -1, 32767)).addContainerGap()));
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
/* 2414 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFNomEntite, -2, 28, -2).addComponent(this.jLabel1).addComponent(this.jTFCodeEntite, -2, 27, -2).addComponent(this.jLabel8)).addGap(18, 18, 18).addComponent(this.jTabbedPane1, -1, 499, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel5, -2, -1, -2).addContainerGap()));
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
/* 2430 */     pack();
/*      */   }
/*      */   
/*      */   private void jBTAjouterActionPerformed(ActionEvent evt) {
/* 2434 */     Attribut2 att = new Attribut2("", "", -1, -1, "", false, "", null);
/* 2435 */     att.setClNom(getColor(this.jLabTexte.getBackground()));
/* 2436 */     att.setClCode(getColor(this.jLabTexte.getBackground()));
/* 2437 */     att.setClType(getColor(this.jLabTexteType.getBackground()));
/* 2438 */     att.setClTaille(getColor(this.jLabTexteType.getBackground()));
/* 2439 */     att.setClTailleDecimale(getColor(this.jLabTexteType.getBackground()));
/* 2440 */     affectationReferenceAttribut(att);
/* 2441 */     this.listeAttribut.add(att);
/* 2442 */     this.tableModel.addAttribut(att);
/* 2443 */     this.jTableAttribut.setRowSelectionInterval(this.listeAttribut.size() - 1, this.listeAttribut.size() - 1);
/* 2444 */     this.jLabNbreAttribut.setText(this.listeAttribut.size() + "");
/* 2445 */     this.modifier = true;
/*      */   }
/*      */   
/*      */   private void jBtSupprimerActionPerformed(ActionEvent evt) {
/* 2449 */     supprimerSelection();
/* 2450 */     this.jLabNbreAttribut.setText(this.listeAttribut.size() + "");
/*      */   }
/*      */   
/*      */   private void jTableAttributKeyPressed(KeyEvent evt)
/*      */   {
/* 2455 */     if ((evt.getKeyCode() == 10) && 
/* 2456 */       (this.jTableAttribut.getSelectedRow() == this.jTableAttribut.getRowCount() - 1)) {
/* 2457 */       Attribut2 att = new Attribut2("", "", -1, -1, "", false, "", null);
/* 2458 */       att.setClNom(getColor(this.jLabTexte.getBackground()));
/* 2459 */       att.setClCode(getColor(this.jLabTexte.getBackground()));
/* 2460 */       att.setClType(getColor(this.jLabTexteType.getBackground()));
/* 2461 */       att.setClTaille(getColor(this.jLabTexteType.getBackground()));
/* 2462 */       att.setClTailleDecimale(getColor(this.jLabTexteType.getBackground()));
/* 2463 */       affectationReferenceAttribut(att);
/* 2464 */       this.listeAttribut.add(att);
/* 2465 */       this.tableModel.addAttribut(att);
/* 2466 */       this.modifier = true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void jTableAttributPropertyChange(java.beans.PropertyChangeEvent evt) {}
/*      */   
/*      */ 
/*      */ 
/*      */   private void jTACommentaireAttFocusLost(FocusEvent evt) {}
/*      */   
/*      */ 
/*      */   private void jTACommentaireAttKeyPressed(KeyEvent evt) {}
/*      */   
/*      */ 
/*      */   private void jTableAttributKeyReleased(KeyEvent evt)
/*      */   {
/* 2484 */     if (this.jTableAttribut.getSelectedRow() >= 0) {
/* 2485 */       this.jTACommentaireAtt.setText(((Attribut)this.listeAttribut.get(this.jTableAttribut.getSelectedRow())).getCommentaire());
/*      */     }
/* 2487 */     this.jLabNbreAttribut.setText(this.listeAttribut.size() + "");
/*      */   }
/*      */   
/*      */   private void jTableAttributMouseClicked(MouseEvent evt) {
/* 2491 */     if (this.jTableAttribut.getSelectedRow() >= 0) {
/* 2492 */       this.jTACommentaireAtt.setText(((Attribut)this.listeAttribut.get(this.jTableAttribut.getSelectedRow())).getCommentaire());
/*      */     }
/*      */   }
/*      */   
/*      */   private JPanel jPanel18;
/*      */   private JPanel jPanel2;
/*      */   private JPanel jPanel3;
/*      */   private JPanel jPanel4;
/*      */   private JPanel jPanel5;
/*      */   
/*      */   private void jTACommentaireAttKeyReleased(KeyEvent evt) {
/* 2503 */     if (this.jTableAttribut.getSelectedRow() >= 0) {
/* 2504 */       ((Attribut)this.listeAttribut.get(this.jTableAttribut.getSelectedRow())).setCommentaire(this.jTACommentaireAtt.getText().trim());
/*      */     }
/*      */   }
/*      */   
/*      */   private void jBtProprieteActionPerformed(ActionEvent evt) {
/* 2509 */     if (this.jTableAttribut.getSelectedRow() >= 0) {
/* 2510 */       new FormeProprieteAttribut2(this.frm, true, (Attribut2)this.listeAttribut.get(this.jTableAttribut.getSelectedRow()), ((Attribut2)this.listeAttribut.get(this.jTableAttribut.getSelectedRow())).getListeAttributs(), this.entite, true).setVisible(true);
/* 2511 */       this.jTableAttribut.repaint();
/* 2512 */       this.modifier = true;
/*      */     } else {
/* 2514 */       JOptionPane.showMessageDialog(this, "Info : Aucun attribut n'est sélectionné !!! ");
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTFCodeEntiteActionPerformed(ActionEvent evt) {
/* 2519 */     if ((this.jTFCodeEntite.getText().trim().length() == 0) && 
/* 2520 */       (this.jTFNomEntite.getText().length() > 0)) {
/* 2521 */       this.jTFCodeEntite.setText(this.jTFNomEntite.getText().trim().toUpperCase());
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTFCodeEntiteFocusGained(FocusEvent evt)
/*      */   {
/* 2527 */     if ((this.jTFCodeEntite.getText().trim().length() == 0) && 
/* 2528 */       (this.jTFNomEntite.getText().length() > 0)) {
/* 2529 */       this.jTFCodeEntite.setText(this.jTFNomEntite.getText().trim().toUpperCase());
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTFCodeEntiteMouseClicked(MouseEvent evt)
/*      */   {
/* 2535 */     if ((this.jTFCodeEntite.getText().trim().length() == 0) && 
/* 2536 */       (this.jTFNomEntite.getText().length() > 0))
/* 2537 */       this.jTFCodeEntite.setText(this.jTFNomEntite.getText().trim().toUpperCase()); }
/*      */   
/*      */   private JPanel jPanel7;
/*      */   private JPanel jPanel8;
/*      */   private JPanel jPanelApercuLien;
/*      */   private JPanel jPanelAprecu;
/*      */   private JScrollPane jScrollPane1;
/*      */   private JScrollPane jScrollPane2;
/*      */   private void jTFNomEntiteKeyReleased(KeyEvent evt) {}
/*      */   
/* 2547 */   private void jLabFondTitreMouseClicked(MouseEvent evt) { this.jLabFondTitre.setBackground(choixDeCouleur(this.jLabFondTitre.getBackground(), "Couleur Fond Titre"));
/* 2548 */     dessinerApercu();
/* 2549 */     this.modifier = true;
/*      */   }
/*      */   
/*      */   private void jPanelAprecuMouseClicked(MouseEvent evt)
/*      */   {
/* 2554 */     dessinerApercu();
/*      */   }
/*      */   
/*      */ 
/*      */   private void jLabel14MouseClicked(MouseEvent evt)
/*      */   {
/* 2560 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabTexteTitreMouseClicked(MouseEvent evt)
/*      */   {
/* 2565 */     this.jLabTexteTitre.setBackground(choixDeCouleur(this.jLabTexteTitre.getBackground(), "Couleur Texte Titre"));
/* 2566 */     dessinerApercu();
/* 2567 */     this.modifier = true;
/*      */   }
/*      */   
/*      */   private void jLabCadreTitreMouseClicked(MouseEvent evt) {
/* 2571 */     this.jLabCadreTitre.setBackground(choixDeCouleur(this.jLabCadreTitre.getBackground(), "Couleur Trait"));
/* 2572 */     dessinerApercu();
/* 2573 */     this.modifier = true;
/*      */   }
/*      */   
/*      */   private void jLabFondMouseClicked(MouseEvent evt) {
/* 2577 */     if (this.jLabFond.isEnabled()) {
/* 2578 */       this.jLabFond.setBackground(choixDeCouleur(this.jLabFond.getBackground(), "Couleur Fond Attribut"));
/* 2579 */       dessinerApercu();
/* 2580 */       this.modifier = true;
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabTexteMouseClicked(MouseEvent evt)
/*      */   {
/* 2586 */     this.jLabTexte.setBackground(choixDeCouleur(this.jLabTexte.getBackground(), "Couleur Texte Attributs"));
/* 2587 */     dessinerApercu();
/* 2588 */     this.modifier = true;
/*      */   }
/*      */   
/*      */   private void jPanel3ComponentShown(ComponentEvent evt)
/*      */   {
/* 2593 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jBtValiderActionPerformed(ActionEvent evt) {
/* 2597 */     String newNom = this.jTFNomEntite.getText().trim();
/*      */     
/* 2599 */     if ((this.entite instanceof IhmEntite2)) {
/* 2600 */       String oldNom = ((IhmEntite2)this.entite).getEntite().getNom().trim();
/* 2601 */       if (verifierEntite()) {
/* 2602 */         enregistrerEntite();
/* 2603 */         modifierSQLDispatch(oldNom, newNom);
/*      */         
/* 2605 */         dispose();
/*      */       }
/*      */     }
/* 2608 */     if (((this.entite instanceof IhmRelation2)) && 
/* 2609 */       (verifierRelation())) {
/* 2610 */       enregistrerRelation();
/*      */       
/* 2612 */       dispose();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void jBtRemonterActionPerformed(ActionEvent evt)
/*      */   {
/* 2619 */     if (this.jTableAttribut.getSelectedRow() >= 0) {
/* 2620 */       remonterAttribut(this.jTableAttribut.getSelectedRow());
/*      */     }
/* 2622 */     this.modifier = true;
/*      */   }
/*      */   
/*      */   private void jBtDescendreActionPerformed(ActionEvent evt) {
/* 2626 */     if (this.jTableAttribut.getSelectedRow() < this.listeAttribut.size() - 1) {
/* 2627 */       descendreAttribut(this.jTableAttribut.getSelectedRow());
/*      */     }
/* 2629 */     this.modifier = true;
/*      */   }
/*      */   
/*      */   private void jBtAnnulerActionPerformed(ActionEvent evt) {
/* 2633 */     if (this.modifier) {
/* 2634 */       int rep = JOptionPane.showConfirmDialog(this, "Des modifications ont été effectuées, voulez vous enregistrer ces modifications ?", "Fermeture ...", 1);
/* 2635 */       if (rep == 0) {
/* 2636 */         if (verifierEntite()) {
/* 2637 */           enregistrerEntite();
/* 2638 */           dispose();
/*      */         }
/*      */       }
/* 2641 */       else if (rep == 1) {
/* 2642 */         dispose();
/*      */       }
/*      */     }
/*      */     else {
/* 2646 */       dispose();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jCBAppliquerDefautActionPerformed(ActionEvent evt) {
/* 2651 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jBtDisctioonaireActionPerformed(ActionEvent evt) {
/* 2655 */     formes.FormeSelectAttribut fatt = new formes.FormeSelectAttribut(this.frm, true);
/* 2656 */     fatt.setVisible(true);
/* 2657 */     if (fatt.getFermer().equals("OK")) {
/* 2658 */       Attribut2 att = (Attribut2)fatt.getAttributSel();
/* 2659 */       if (att != null) {
/* 2660 */         att = corrigerAttribut(att);
/* 2661 */         att = (Attribut2)att.copier();
/*      */         
/* 2663 */         if ((this.entite instanceof IhmEntite2)) {
/* 2664 */           att.setEntiteRelation(((IhmEntite2)this.entite).getEntite());
/*      */         }
/* 2666 */         if ((this.entite instanceof IhmRelation2)) {
/* 2667 */           att.setEntiteRelation(((IhmRelation2)this.entite).getRelation());
/*      */         }
/* 2669 */         if (existeAttributDansListe(att) == null) {
/* 2670 */           this.listeAttribut.add(att);
/* 2671 */           this.tableModel.addAttribut(att);
/* 2672 */           miseAjourListe();
/*      */         }
/*      */         else {
/* 2675 */           JOptionPane.showMessageDialog(this, "Cet attribut existe déjà dans la liste des attributs", "Erreur", 0);
/*      */         }
/*      */       }
/*      */     }
/*      */     
/* 2680 */     this.jLabNbreAttribut.setText(this.listeAttribut.size() + "");
/*      */   }
/*      */   
/*      */   private void jBtImporterAttributActionPerformed(ActionEvent evt) {
/* 2684 */     FormeImporterAttribut f = new FormeImporterAttribut(this.frm, this.listeAttribut, true);
/* 2685 */     f.setVisible(true);
/*      */     
/* 2687 */     if (f.isModifier()) {
/* 2688 */       ArrayList<Attribut> listeAtt = f.getListAttribut();
/* 2689 */       listeAtt = corrigerAttributs(listeAtt);
/* 2690 */       affectationReferenceAttribut(listeAtt);
/* 2691 */       this.listeAttribut = listeAtt;
/* 2692 */       this.tabR.setListeAttribut(this.listeAttribut);
/* 2693 */       this.tableModel.setListeAttribut(listeAtt);
/* 2694 */       miseAjourListe();
/*      */     }
/* 2696 */     this.jLabNbreAttribut.setText(this.listeAttribut.size() + "");
/*      */   }
/*      */   
/*      */ 
/*      */   private void jPanel3MouseMoved(MouseEvent evt) {}
/*      */   
/*      */   private void jCBDegradeeActionPerformed(ActionEvent evt)
/*      */   {
/* 2704 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jBTHistoriqueActionPerformed(ActionEvent evt) {
/* 2708 */     if ((this.entite instanceof IhmEntite2))
/* 2709 */       new FormeHistorique(this.frm, true, ((IhmEntite2)this.entite).getHistorique(), "", "").setVisible(true);
/* 2710 */     if ((this.entite instanceof IhmRelation2))
/* 2711 */       new FormeHistorique(this.frm, true, ((IhmRelation2)this.entite).getHistorique(), "", "").setVisible(true);
/*      */   }
/*      */   
/*      */   private void jListMousePressed(MouseEvent evt) {
/* 2715 */     dessinerApercuLienSelected();
/* 2716 */     if (evt.getClickCount() == 2) {
/* 2717 */       int nb = this.jList.getSelectedIndex();
/* 2718 */       if (nb >= 0) {
/* 2719 */         IhmLien2 li = (IhmLien2)this.listeLien.get(nb);
/* 2720 */         new FormeCardinalite2(this.frm, true, li, nb, nb, false).setVisible(true);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void jPanelApercuLienMouseClicked(MouseEvent evt) {
/* 2726 */     dessinerApercuLienSelected();
/*      */   }
/*      */   
/*      */   private void jListKeyReleased(KeyEvent evt) {
/* 2730 */     dessinerApercuLienSelected();
/*      */   }
/*      */   
/*      */ 
/* 2734 */   private void jPanel11ComponentShown(ComponentEvent evt) { dessinerApercuLienSelected(); }
/*      */   
/*      */   private JScrollPane jScrollPane3;
/*      */   private JScrollPane jScrollPane4;
/*      */   private JTextArea jTACommentaireAtt;
/*      */   private JTextArea jTAcommentaire;
/*      */   private JTextField jTFCodeEntite;
/*      */   private JTextField jTFCreation;
/*      */   
/*      */   private void jListMouseClicked(MouseEvent evt) {}
/*      */   private JTextField jTFCreationDev;
/*      */   private JTextField jTFModification;
/*      */   
/*      */   private void jLabTexteTypeMouseClicked(MouseEvent evt) {
/* 2748 */     this.jLabTexteType.setBackground(choixDeCouleur(this.jLabTexteType.getBackground(), "Couleur Texte Attributs"));
/* 2749 */     dessinerApercu();
/* 2750 */     this.modifier = true;
/*      */   }
/*      */   
/*      */   private JTextField jTFModificationDev;
/*      */   
/* 2755 */   private void jLabel12MouseClicked(MouseEvent evt) { this.jLabFondTitre.setBackground(this.jLabFond.getBackground());
/* 2756 */     dessinerApercu(); }
/*      */   
/*      */   private JTextField jTFNomEntite;
/*      */   
/* 2760 */   private void jLabel18MouseClicked(MouseEvent evt) { this.jLabFond.setBackground(this.jLabFondTitre.getBackground());
/* 2761 */     dessinerApercu(); }
/*      */   
/*      */   private JTabbedPane jTabbedPane1;
/*      */   
/* 2765 */   private void jLabel19MouseClicked(MouseEvent evt) { this.jLabTexte.setBackground(this.jLabTexteType.getBackground());
/* 2766 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private JTable jTableAttribut;
/* 2770 */   private void jLabel20MouseClicked(MouseEvent evt) { this.jLabTexteType.setBackground(this.jLabTexte.getBackground());
/* 2771 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabTexteTailleMouseClicked(MouseEvent evt) {
/* 2775 */     this.jLabTexteTaille.setBackground(choixDeCouleur(this.jLabTexteTaille.getBackground(), "Couleur Taille Attributs"));
/* 2776 */     dessinerApercu();
/* 2777 */     this.modifier = true;
/*      */   }
/*      */   
/*      */   private void jLabel25MouseClicked(MouseEvent evt)
/*      */   {
/* 2782 */     this.jLabTexteTaille.setBackground(this.jLabTexteType.getBackground());
/* 2783 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabel26MouseClicked(MouseEvent evt) {
/* 2787 */     this.jLabTexteTailleDec.setBackground(this.jLabTexteTaille.getBackground());
/* 2788 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabTexteTailleDecMouseClicked(MouseEvent evt) {
/* 2792 */     this.jLabTexteTailleDec.setBackground(choixDeCouleur(this.jLabTexteTailleDec.getBackground(), "Couleur Taille Attributs"));
/* 2793 */     dessinerApercu();
/* 2794 */     this.modifier = true;
/*      */   }
/*      */   
/*      */   private void jLabLienColorMouseClicked(MouseEvent evt)
/*      */   {
/* 2799 */     this.jLabLienColor.setBackground(choixDeCouleur(this.jLabLienColor.getBackground(), "Couleur des liens lors de la sélection "));
/* 2800 */     dessinerApercu();
/* 2801 */     this.modifier = true;
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeEntite2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */