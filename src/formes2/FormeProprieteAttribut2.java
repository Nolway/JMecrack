/*      */ package formes2;
/*      */ 
/*      */ import IhmMCD.IhmPageMCD;
/*      */ import IhmMCD2.IhmEntite2;
/*      */ import IhmMCD2.IhmRelation2;
/*      */ import IhmMLD2.MLDEntite2;
/*      */ import Merise.Attribut;
/*      */ import Merise.Domaine;
/*      */ import Merise2.Attribut2;
/*      */ import formes.FormeImporterAttribut;
/*      */ import formes.FormeSelectAttribut;
/*      */ import formes.FormeText;
/*      */ import ihm.FormeInterneMCD;
/*      */ import ihm.Principale;
/*      */ import java.awt.Color;
/*      */ import java.awt.Cursor;
/*      */ import java.awt.Font;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.FocusEvent;
/*      */ import java.awt.event.ItemEvent;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.awt.event.MouseAdapter;
/*      */ import java.awt.event.MouseEvent;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Map;
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
/*      */ public class FormeProprieteAttribut2 extends javax.swing.JDialog
/*      */ {
/*      */   Principale frm;
/*      */   Attribut2 attribut;
/*      */   ArrayList<Attribut> listeAttribut;
/*      */   Object entite;
/*      */   Attribut2 attributPere;
/*      */   ProprieteEntiteTableModelAttribut tableModel;
/*      */   ProprieteEntiteTableRender tabR;
/*   57 */   public static int profondeur = 0;
/*      */   Map<Attribut, Attribut> listeAttributCorresp;
/*      */   boolean isEntiteMLDModifer;
/*      */   private JButton jBTAjouter;
/*      */   private JButton jBTSupprimer;
/*      */   
/*   63 */   public FormeProprieteAttribut2(Principale parent, boolean modal, Attribut2 att, ArrayList<Attribut> listeAttribut, Object entite, boolean valider) { super(parent, modal);
/*   64 */     this.frm = parent;
/*   65 */     this.attribut = att;
/*   66 */     this.entite = entite;
/*   67 */     this.attributPere = null;
/*   68 */     this.listeAttribut = listeAttribut;
/*      */     
/*   70 */     initComponents();
/*   71 */     remplirCle();
/*   72 */     if (this.attributPere == null) {
/*   73 */       this.jTFAugmentation.setEnabled(false);
/*      */     }
/*   75 */     this.jBtValider.setEnabled(valider);
/*   76 */     initialiserFenetre();
/*   77 */     this.attributPere = this.attribut;
/*   78 */     initialiserLatable();
/*   79 */     setLocation(this.frm.getX() + 300, this.frm.getY() + 40);
/*   80 */     profondeur += 1;
/*   81 */     this.jBtAnnuler.setMnemonic(65);
/*   82 */     this.jBtValider.setMnemonic(10);
/*   83 */     this.isEntiteMLDModifer = false;
/*   84 */     if (this.attribut != null) {
/*   85 */       this.jLabClNom.setBackground(getColor(this.attribut.getClNom()));
/*   86 */       this.jLabClType.setBackground(getColor(this.attribut.getClType()));
/*   87 */       this.jLabClTaille.setBackground(getColor(this.attribut.getClTaille()));
/*   88 */       this.jLabClTailleDec.setBackground(getColor(this.attribut.getClTailleDecimale())); } }
/*      */   
/*      */   private JButton jBtAnnuler;
/*      */   private JButton jBtCommentaire;
/*      */   private JButton jBtDescendre;
/*      */   private JButton jBtDictionnaire;
/*   94 */   public FormeProprieteAttribut2(Principale parent, boolean modal, Attribut2 att, ArrayList<Attribut> listeAttribut, Object entite, boolean valider, Attribut2 attPere) { super(parent, modal);
/*   95 */     this.frm = parent;
/*   96 */     this.attribut = att;
/*   97 */     this.entite = entite;
/*   98 */     this.attributPere = attPere;
/*   99 */     this.listeAttributCorresp = new java.util.HashMap();
/*      */     
/*  101 */     this.listeAttribut = copierAttributs(this.attribut.getListeAttributs());
/*  102 */     initComponents();
/*  103 */     remplirCle();
/*      */     
/*  105 */     if (this.attributPere == null) {
/*  106 */       this.jTFAugmentation.setEnabled(false);
/*      */ 
/*      */     }
/*  109 */     else if ((entite instanceof MLDEntite2)) {
/*  110 */       this.jCBAfficher.setEnabled(false);
/*      */     }
/*      */     
/*  113 */     this.jBtValider.setEnabled(valider);
/*  114 */     initialiserFenetre();
/*  115 */     this.attributPere = this.attribut;
/*  116 */     initialiserLatable();
/*  117 */     setLocation(this.frm.getX() + 300 + 20 * profondeur, this.frm.getY() + 40 + 20 * profondeur);
/*  118 */     profondeur += 1;
/*  119 */     this.jBtAnnuler.setMnemonic(65);
/*  120 */     this.jBtValider.setMnemonic(10);
/*  121 */     if ((entite instanceof MLDEntite2)) {
/*  122 */       desactiverMLDEntite();
/*  123 */       if (attPere == null) {
/*  124 */         this.jTFNom.setEditable(false);
/*  125 */         this.jTFCode.setEditable(false);
/*      */       }
/*      */     }
/*      */     
/*  129 */     this.isEntiteMLDModifer = false;
/*      */     
/*  131 */     if (this.attribut != null) {
/*  132 */       this.jLabClNom.setBackground(getColor(this.attribut.getClNom()));
/*  133 */       this.jLabClType.setBackground(getColor(this.attribut.getClType()));
/*  134 */       this.jLabClTaille.setBackground(getColor(this.attribut.getClTaille()));
/*  135 */       this.jLabClTailleDec.setBackground(getColor(this.attribut.getClTailleDecimale()));
/*      */     }
/*      */   }
/*      */   
/*      */   private void desactiverMLDEntite()
/*      */   {
/*  141 */     this.jTFLongueur.setEnabled(false);
/*  142 */     this.jTFDecimale.setEnabled(false);
/*  143 */     this.jCBCle.setEnabled(false);
/*  144 */     this.jCBHistorisation.setEnabled(false);
/*  145 */     this.jCBNull.setEnabled(false);
/*  146 */     this.jCBunsigned.setEnabled(false);
/*  147 */     this.jCBType.setEnabled(false);
/*  148 */     this.jTACommentaire.setEnabled(true);
/*  149 */     this.jTFAttributPere.setEnabled(false);
/*  150 */     this.jTFAugmentation.setEnabled(false);
/*      */     
/*  152 */     this.jBTAjouter.setEnabled(false);
/*  153 */     this.jBTSupprimer.setEnabled(false);
/*  154 */     this.jBtDictionnaire.setEnabled(false);
/*  155 */     this.jBtImporterAttribut.setEnabled(false);
/*  156 */     this.jBtDescendre.setEnabled(false);
/*  157 */     this.jBtRemonter.setEnabled(false);
/*  158 */     this.jLabClNom.setEnabled(false);
/*  159 */     this.jLabClType.setEnabled(false);
/*  160 */     this.jLabClTaille.setEnabled(false);
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> copierListeAttribut(ArrayList<Attribut> liste)
/*      */   {
/*  165 */     ArrayList<Attribut> l = new ArrayList();
/*      */     
/*  167 */     for (int i = 0; i < liste.size(); i++) {
/*  168 */       Attribut2 at = (Attribut2)((Attribut2)liste.get(i)).copier();
/*  169 */       l.add(at);
/*      */     }
/*  171 */     return l;
/*      */   }
/*      */   
/*      */   public Color getColor(String color) {
/*  175 */     return new Color(Integer.parseInt(color));
/*      */   }
/*      */   
/*      */   public String getColor(Color color) {
/*  179 */     return color.getRGB() + "";
/*      */   }
/*      */   
/*      */   private Color choixDeCouleur(Color color, String titre) {
/*  183 */     Color col = javax.swing.JColorChooser.showDialog(this, titre, color);
/*  184 */     if (col == null) return color;
/*  185 */     return col;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> copierAttributs(ArrayList<Attribut> listeA) {
/*  189 */     if ((this.entite instanceof MLDEntite2)) {
/*  190 */       return copierListeAttrbutMLD(listeA);
/*      */     }
/*  192 */     return copierListeAttribut(listeA);
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> copierListeAttrbutMLD(ArrayList<Attribut> listeA)
/*      */   {
/*  197 */     ArrayList<Attribut> listeC = new ArrayList();
/*  198 */     Attribut2 attpere = null;
/*  199 */     copierListeAttrbutMLD(listeC, attpere, listeA);
/*      */     
/*  201 */     return listeC;
/*      */   }
/*      */   
/*      */   private void copierListeAttrbutMLD(ArrayList<Attribut> listeC, Attribut2 pere, ArrayList<Attribut> listeA)
/*      */   {
/*  206 */     for (int i = 0; i < listeA.size(); i++) {
/*  207 */       Attribut2 att = (Attribut2)listeA.get(i);
/*  208 */       Attribut2 attC = (Attribut2)att.copier();
/*  209 */       this.listeAttributCorresp.put(att, attC);
/*  210 */       attC.getListeAttributs().clear();
/*  211 */       if (pere != null) {
/*  212 */         pere.getListeAttributs().add(attC);
/*      */       } else {
/*  214 */         listeC.add(attC);
/*      */       }
/*  216 */       if (att.getListeAttributs().size() > 0) {
/*  217 */         copierListeAttrbutMLD(listeC, attC, att.getListeAttributs());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void remplirType() {
/*  223 */     this.jCBType.removeAllItems();
/*  224 */     this.jCBType.addItem("");
/*  225 */     for (int i = 0; i < this.frm.getPage().getListeDomaine().size(); i++) {
/*  226 */       this.jCBType.addItem(((Domaine)this.frm.getPage().getListeDomaine().get(i)).getNom());
/*      */     }
/*  228 */     if (this.frm.getPage().getListeDomaine().size() > 0) this.jCBType.addItem("");
/*  229 */     for (int i = 0; i < Outil.Parametres.DomaineDefini.length; i++) {
/*  230 */       if ((!Outil.Parametres.DomaineDefini[i].toUpperCase().equals("ENUM")) && (!Outil.Parametres.DomaineDefini[i].toUpperCase().equals("SET"))) {
/*  231 */         if (Outil.Parametres.DomaineDefini[i].toUpperCase().equals("AUTO_INCREMENT")) {
/*  232 */           if (!(this.entite instanceof IhmRelation2)) this.jCBType.addItem(Outil.Parametres.DomaineDefini[i]);
/*      */         } else {
/*  234 */           this.jCBType.addItem(Outil.Parametres.DomaineDefini[i]);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void initialiserComboBoxCle(String st)
/*      */   {
/*  242 */     if (st.trim().length() == 0) this.jCBCle.setSelectedIndex(0);
/*  243 */     if (st.trim().equals("PRIMARY KEY")) this.jCBCle.setSelectedIndex(1);
/*  244 */     if (st.trim().equals("UNIQUE")) this.jCBCle.setSelectedIndex(2);
/*  245 */     if (st.trim().equals("INDEX")) this.jCBCle.setSelectedIndex(3);
/*  246 */     if (st.trim().equals("FOREING KEY")) this.jCBCle.setSelectedIndex(4);
/*      */   }
/*      */   
/*      */   private void initialiserComboBox(JComboBox combo, String st) {
/*  250 */     int taille = combo.getItemCount();
/*  251 */     if (st == null) {
/*  252 */       combo.setSelectedIndex(0);
/*  253 */       return;
/*      */     }
/*  255 */     for (int i = 0; i < taille; i++) {
/*  256 */       if (combo.getItemAt(i).toString().trim().toUpperCase().equals(st.trim().toUpperCase())) {
/*  257 */         combo.setSelectedIndex(i);
/*  258 */         return;
/*      */       }
/*      */     }
/*  261 */     combo.setSelectedIndex(0);
/*      */   }
/*      */   
/*      */   private void initialiserFenetre() {
/*  265 */     this.jTFNom.setText(this.attribut.getNom());
/*  266 */     this.jTFCode.setText(this.attribut.getCode());
/*  267 */     this.jTFDecimale.setText("" + this.attribut.getLongDecimale());
/*  268 */     this.jTFLongueur.setText("" + this.attribut.getLongueur());
/*      */     
/*  270 */     this.jTFEntite.setText(getNomEntite());
/*  271 */     this.jTFAttributPere.setText(this.attributPere == null ? "" : this.attributPere.getNom());
/*  272 */     this.jTFValDefaut.setText(this.attribut.getValeurDefaut());
/*  273 */     this.jCBAfficher.setSelected(this.attribut.isAfficher());
/*  274 */     this.jCBNull.setSelected(this.attribut.isNulle());
/*      */     
/*  276 */     if (this.jTFAugmentation.isEnabled()) {
/*  277 */       this.jTFAugmentation.setText(this.attribut.getAugmentation());
/*      */     } else {
/*  279 */       this.jTFAugmentation.setText("");
/*      */     }
/*      */     
/*  282 */     this.jTACommentaire.setText(this.attribut.getCommentaire());
/*      */     
/*      */ 
/*  285 */     if (this.attribut.getHistorisation().equals("H")) {
/*  286 */       this.jCBHistorisation.setSelected(true);
/*      */     } else {
/*  288 */       this.jCBHistorisation.setSelected(false);
/*      */     }
/*      */     
/*      */ 
/*  292 */     remplirType();
/*  293 */     if ((this.entite instanceof IhmRelation2)) this.jCBCle.setEnabled(false);
/*  294 */     initialiserComboBoxCle(this.attribut.getKey());
/*  295 */     initialiserComboBox(this.jCBType, this.attribut.getType());
/*  296 */     String s = (String)this.jCBType.getSelectedItem();
/*  297 */     this.jCBunsigned.setEnabled(isActiverUnsigned(s));
/*  298 */     this.jCBunsigned.setSelected(this.attribut.isUnSigned());
/*      */   }
/*      */   
/*      */   public String getNomEntite()
/*      */   {
/*  303 */     if (this.entite == null) return "";
/*  304 */     if ((this.entite instanceof IhmEntite2)) {
/*  305 */       return ((IhmEntite2)this.entite).getEntite().getNom();
/*      */     }
/*      */     
/*  308 */     if ((this.entite instanceof IhmRelation2)) {
/*  309 */       return ((IhmRelation2)this.entite).getRelation().getNom();
/*      */     }
/*      */     
/*  312 */     if ((this.entite instanceof MLDEntite2)) {
/*  313 */       return ((MLDEntite2)this.entite).getNom();
/*      */     }
/*  315 */     return "";
/*      */   }
/*      */   
/*      */   private boolean estEntier(String ent) {
/*  319 */     if (ent.trim().length() == 0) return true;
/*      */     try {
/*  321 */       int nb = Integer.parseInt(ent);
/*  322 */       if (nb >= 0) return true;
/*  323 */       return false;
/*      */     } catch (Exception e) {}
/*  325 */     return false;
/*      */   }
/*      */   
/*      */   private void remplirCle()
/*      */   {
/*  330 */     if ((this.entite instanceof MLDEntite2)) {
/*  331 */       this.jCBCle.addItem("");
/*  332 */       this.jCBCle.addItem("CLE PRIMAIRE");
/*  333 */       this.jCBCle.addItem("CLE ALTERNATIVE");
/*  334 */       this.jCBCle.addItem("INDEX");
/*  335 */       this.jCBCle.addItem("CLE ETRANGERE");
/*      */     }
/*      */     else {
/*  338 */       this.jCBCle.addItem("");
/*  339 */       this.jCBCle.addItem("IDENTIFIANT");
/*  340 */       this.jCBCle.addItem("IDENTIFIANT ALTERNATIF");
/*  341 */       this.jCBCle.addItem("INDEX");
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean correctRemplissageChamps()
/*      */   {
/*  347 */     if (this.jTFNom.getText().trim().length() == 0) {
/*  348 */       JOptionPane.showMessageDialog(this, "ERREUR : Le nom ne doit pas être vide !!! ");
/*  349 */       return false;
/*      */     }
/*  351 */     if (this.jTFCode.getText().trim().length() == 0)
/*      */     {
/*  353 */       JOptionPane.showMessageDialog(this, "ERREUR : Le code ne doit pas être vide !!! ");
/*  354 */       return false;
/*      */     }
/*      */     
/*  357 */     if (this.jCBType.getSelectedIndex() < 0) {
/*  358 */       if (this.listeAttribut.size() == 0) {
/*  359 */         JOptionPane.showMessageDialog(this, "ERREUR : L'attribut doit avoir un type !!! ");
/*  360 */         return false;
/*      */       }
/*      */     } else {
/*  363 */       String typ = this.jCBType.getSelectedItem().toString();
/*  364 */       if (((typ == null) || (typ.trim().length() == 0)) && 
/*  365 */         (this.listeAttribut.size() == 0)) {
/*  366 */         JOptionPane.showMessageDialog(this, "ERREUR : L'attribut doit avoir un type !!! ");
/*  367 */         return false;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  372 */     if (!estEntier(this.jTFLongueur.getText().trim().length() == 0 ? "10" : this.jTFLongueur.getText().trim())) {
/*  373 */       JOptionPane.showMessageDialog(this, "ERREUR : La taille d l'attribut doit être un entier !!! ");
/*  374 */       return false;
/*      */     }
/*      */     
/*  377 */     if (!estEntier(this.jTFDecimale.getText().trim().length() == 0 ? "10" : this.jTFDecimale.getText().trim())) {
/*  378 */       JOptionPane.showMessageDialog(this, "ERREUR : La taille décimale d l'attribut doit être un entier !!! ");
/*  379 */       return false;
/*      */     }
/*      */     
/*  382 */     return true;
/*      */   }
/*      */   
/*      */   private boolean existeDejaNom()
/*      */   {
/*  387 */     String st = this.jTFNom.getText().trim();
/*  388 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/*  389 */       if ((this.listeAttribut.get(i) != this.attribut) && 
/*  390 */         (((Attribut)this.listeAttribut.get(i)).getNom().trim().toUpperCase().equals(st.trim().toUpperCase()))) {
/*  391 */         JOptionPane.showMessageDialog(this, "ERREUR : Le nom de cet attribut existe déja !!! ");
/*  392 */         return true;
/*      */       }
/*      */     }
/*      */     
/*  396 */     return false;
/*      */   }
/*      */   
/*      */   private boolean existeDejaCode() {
/*  400 */     String st = this.jTFCode.getText().trim();
/*  401 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/*  402 */       if ((this.listeAttribut.get(i) != this.attribut) && 
/*  403 */         (((Attribut2)this.listeAttribut.get(i)).getCode().trim().toUpperCase().equals(st.trim().toUpperCase()))) {
/*  404 */         JOptionPane.showMessageDialog(this, "ERREUR : Le code de cet attribut existe déja !!! ");
/*  405 */         return true;
/*      */       }
/*      */     }
/*      */     
/*  409 */     return false;
/*      */   }
/*      */   
/*      */   private String getKey() {
/*  413 */     if ((this.entite instanceof MLDEntite2)) {
/*  414 */       if (this.jCBCle.getSelectedIndex() == 1) {
/*  415 */         return "PRIMARY KEY";
/*      */       }
/*  417 */       if (this.jCBCle.getSelectedIndex() == 2) {
/*  418 */         return "UNIQUE";
/*      */       }
/*  420 */       if (this.jCBCle.getSelectedIndex() == 3) {
/*  421 */         return "INDEX";
/*      */       }
/*  423 */       if (this.jCBCle.getSelectedIndex() == 4) {
/*  424 */         return "FOREING KEY";
/*      */       }
/*      */     } else {
/*  427 */       if (this.jCBCle.getSelectedIndex() == 1) {
/*  428 */         return "PRIMARY KEY";
/*      */       }
/*  430 */       if (this.jCBCle.getSelectedIndex() == 2) {
/*  431 */         return "UNIQUE";
/*      */       }
/*  433 */       if (this.jCBCle.getSelectedIndex() == 3) {
/*  434 */         return "INDEX";
/*      */       }
/*      */     }
/*      */     
/*  438 */     return ""; }
/*      */   private JButton jBtHistorique;
/*      */   private JButton jBtImporterAttribut;
/*      */   private JButton jBtPropriete;
/*      */   
/*  443 */   private void mettreAjourAttribut() { this.attribut.setNom(this.jTFNom.getText().trim());
/*  444 */     this.attribut.setCode(this.jTFCode.getText().trim().toUpperCase());
/*  445 */     this.attribut.setType(this.jCBType.getSelectedItem().toString());
/*  446 */     this.attribut.setKey(getKey());
/*  447 */     this.attribut.setLongueur(this.jTFLongueur.getText().trim().length() == 0 ? -1 : Integer.parseInt(this.jTFLongueur.getText().trim()));
/*  448 */     this.attribut.setLongDecimale(this.jTFDecimale.getText().trim().length() == 0 ? -1 : Integer.parseInt(this.jTFDecimale.getText().trim()));
/*  449 */     this.attribut.setNulle(this.jCBNull.isSelected());
/*  450 */     this.attribut.setAfficher(this.jCBAfficher.isSelected());
/*  451 */     this.attribut.setValeurDefaut(this.jTFValDefaut.getText().trim());
/*  452 */     this.attribut.setCommentaire(this.jTACommentaire.getText());
/*  453 */     this.attribut.ajouterModification();
/*  454 */     this.attribut.setHistorisation(this.jCBHistorisation.isSelected() ? "H" : "");
/*  455 */     this.attribut.setAugmentation(this.jTFAugmentation.getText());
/*      */     
/*  457 */     this.attribut.setClNom(getColor(this.jLabClNom.getBackground()));
/*  458 */     this.attribut.setClCode(getColor(this.jLabClNom.getBackground()));
/*  459 */     this.attribut.setClType(getColor(this.jLabClType.getBackground()));
/*  460 */     this.attribut.setClTaille(getColor(this.jLabClTaille.getBackground()));
/*  461 */     this.attribut.setClTailleDecimale(getColor(this.jLabClTailleDec.getBackground()));
/*      */     
/*      */ 
/*  464 */     if (this.jCBunsigned.isEnabled()) {
/*  465 */       this.attribut.setUnSigned(this.jCBunsigned.isSelected());
/*      */     } else
/*  467 */       this.attribut.setUnSigned(false);
/*      */   }
/*      */   
/*      */   private JButton jBtRemonter;
/*      */   private JButton jBtValider;
/*      */   
/*      */   private JComboBox remplirTypeBox() {
/*  474 */     JComboBox comboBox = new JComboBox();
/*      */     
/*  476 */     comboBox.addItem("");
/*  477 */     for (int i = 0; i < this.frm.getPage().getListeDomaine().size(); i++) {
/*  478 */       comboBox.addItem(((Domaine)this.frm.getPage().getListeDomaine().get(i)).getNom());
/*      */     }
/*  480 */     if (this.frm.getPage().getListeDomaine().size() > 0) comboBox.addItem("");
/*  481 */     for (int i = 0; i < Outil.Parametres.DomaineDefini.length; i++) {
/*  482 */       if ((!Outil.Parametres.DomaineDefini[i].toUpperCase().equals("ENUM")) && (!Outil.Parametres.DomaineDefini[i].toUpperCase().equals("SET")))
/*      */       {
/*  484 */         if (Outil.Parametres.DomaineDefini[i].toUpperCase().equals("AUTO_INCREMENT")) {
/*  485 */           if (!(this.entite instanceof IhmRelation2)) comboBox.addItem(Outil.Parametres.DomaineDefini[i]);
/*      */         } else {
/*  487 */           comboBox.addItem(Outil.Parametres.DomaineDefini[i]);
/*      */         }
/*      */       }
/*      */     }
/*  491 */     return comboBox; }
/*      */   
/*      */   private JButton jButton1;
/*      */   
/*  495 */   private void initialiserLatable() { JComboBox comboBoxType = remplirTypeBox();
/*  496 */     JTextField jtf = new JTextField();
/*  497 */     jtf.setFont(new Font("Tahoma", 1, 14));
/*  498 */     jtf.setBackground(Color.yellow);
/*      */     
/*  500 */     this.tableModel = new ProprieteEntiteTableModelAttribut(this.listeAttribut);
/*  501 */     this.jTableAttribut.setModel(this.tableModel);
/*      */     
/*  503 */     this.jTableAttribut.getColumnModel().getColumn(0).setCellEditor(new ProprieteBoutonCellEditor(this.listeAttribut, this.frm, this.entite, this.attributPere));
/*      */     
/*  505 */     this.jTableAttribut.getColumnModel().getColumn(0).setPreferredWidth(50);
/*  506 */     this.jTableAttribut.getColumnModel().getColumn(1).setPreferredWidth(220);
/*  507 */     this.jTableAttribut.getColumnModel().getColumn(2).setPreferredWidth(170);
/*  508 */     this.jTableAttribut.getColumnModel().getColumn(3).setPreferredWidth(160);
/*  509 */     this.jTableAttribut.getColumnModel().getColumn(4).setPreferredWidth(50);
/*  510 */     this.jTableAttribut.getColumnModel().getColumn(5).setPreferredWidth(50);
/*      */     
/*  512 */     this.jTableAttribut.getColumnModel().getColumn(6).setPreferredWidth(20);
/*  513 */     JCheckBox cbx = new JCheckBox();
/*      */     
/*  515 */     if ((this.entite instanceof MLDEntite2)) {
/*  516 */       comboBoxType.setEnabled(false);
/*  517 */       cbx.setEnabled(false);
/*      */     }
/*      */     
/*  520 */     this.jTableAttribut.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(jtf));
/*  521 */     this.jTableAttribut.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(jtf));
/*  522 */     this.jTableAttribut.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBoxType));
/*  523 */     this.jTableAttribut.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(cbx));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  528 */     this.tabR = new ProprieteEntiteTableRender();
/*  529 */     this.tabR.setListeAttribut(this.listeAttribut);
/*  530 */     this.jTableAttribut.setDefaultRenderer(Object.class, this.tabR);
/*  531 */     this.jTableAttribut.setDefaultRenderer(JButton.class, new ProprieteBoutonCellRender());
/*  532 */     this.jTableAttribut.setDefaultRenderer(Boolean.class, new CheckBoxCellRender());
/*      */     
/*      */ 
/*      */ 
/*  536 */     this.jTableAttribut.setRowHeight(30);
/*      */   }
/*      */   
/*      */   private JCheckBox jCBAfficher;
/*      */   private JComboBox jCBCle;
/*  541 */   public void affectationReferenceAttribut(Attribut att) { if ((this.entite instanceof IhmEntite2)) {
/*  542 */       att.setEntiteRelation(((IhmEntite2)this.entite).getEntite());
/*      */     }
/*  544 */     if ((this.entite instanceof IhmRelation2))
/*  545 */       att.setEntiteRelation(((IhmRelation2)this.entite).getRelation());
/*      */   }
/*      */   
/*      */   private JCheckBox jCBHistorisation;
/*      */   private JCheckBox jCBNull;
/*      */   private JComboBox jCBType;
/*      */   private JCheckBox jCBunsigned;
/*      */   private JLabel jLabClNom;
/*      */   private JLabel jLabClTaille;
/*      */   private JLabel jLabClTailleDec;
/*      */   private JLabel jLabClType;
/*      */   
/*      */   private void remonterAttribut(int index) {
/*  558 */     if (index >= 1) {
/*  559 */       Attribut att = (Attribut)this.listeAttribut.get(index - 1);
/*  560 */       this.listeAttribut.remove(index - 1);
/*  561 */       this.tableModel.removeAttribut(index - 1);
/*      */       
/*  563 */       this.listeAttribut.add(index, att);
/*  564 */       this.tableModel.getListeAttribut().add(index, att);
/*  565 */       this.jTableAttribut.repaint();
/*  566 */       this.jTableAttribut.setRowSelectionInterval(index - 1, index - 1);
/*  567 */       if ((this.entite instanceof MLDEntite2)) {
/*  568 */         this.isEntiteMLDModifer = true;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void descendreAttribut(int index)
/*      */   {
/*  575 */     if (index < this.listeAttribut.size() - 1) {
/*  576 */       Attribut att = (Attribut)this.listeAttribut.get(index + 1);
/*  577 */       this.listeAttribut.remove(index + 1);
/*  578 */       this.tableModel.removeAttribut(index + 1);
/*      */       
/*  580 */       this.listeAttribut.add(index, att);
/*  581 */       this.tableModel.getListeAttribut().add(index, att);
/*  582 */       this.jTableAttribut.repaint();
/*  583 */       this.jTableAttribut.setRowSelectionInterval(index + 1, index + 1);
/*  584 */       if ((this.entite instanceof MLDEntite2)) {
/*  585 */         this.isEntiteMLDModifer = true;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void supprimerSelection() {
/*  591 */     int[] selection = this.jTableAttribut.getSelectedRows();
/*  592 */     for (int i = selection.length - 1; i >= 0; i--) {
/*  593 */       this.tableModel.removeAttribut(selection[i]);
/*  594 */       this.listeAttribut.remove(selection[i]);
/*      */     }
/*      */     
/*  597 */     if (this.listeAttribut.size() == 0) {
/*  598 */       JComboBox comboBoxType = remplirTypeBox();
/*  599 */       JTextField jtf = new JTextField();
/*  600 */       jtf.setFont(new Font("Tahoma", 1, 14));
/*  601 */       jtf.setBackground(Color.yellow);
/*      */       
/*  603 */       this.tableModel = new ProprieteEntiteTableModelAttribut(this.listeAttribut);
/*  604 */       this.jTableAttribut.setModel(this.tableModel);
/*      */       
/*  606 */       this.jTableAttribut.getColumnModel().getColumn(0).setCellEditor(new ProprieteBoutonCellEditor(this.listeAttribut, this.frm, this.entite, this.attributPere));
/*      */       
/*  608 */       this.jTableAttribut.getColumnModel().getColumn(0).setPreferredWidth(50);
/*  609 */       this.jTableAttribut.getColumnModel().getColumn(1).setPreferredWidth(220);
/*  610 */       this.jTableAttribut.getColumnModel().getColumn(2).setPreferredWidth(170);
/*  611 */       this.jTableAttribut.getColumnModel().getColumn(3).setPreferredWidth(160);
/*  612 */       this.jTableAttribut.getColumnModel().getColumn(4).setPreferredWidth(50);
/*  613 */       this.jTableAttribut.getColumnModel().getColumn(5).setPreferredWidth(50);
/*      */       
/*  615 */       this.jTableAttribut.getColumnModel().getColumn(6).setPreferredWidth(20);
/*      */       
/*      */ 
/*      */ 
/*  619 */       this.jTableAttribut.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBoxType));
/*  620 */       this.jTableAttribut.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(jtf));
/*  621 */       this.jTableAttribut.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(jtf));
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  626 */       this.tabR = new ProprieteEntiteTableRender();
/*  627 */       this.tabR.setListeAttribut(this.listeAttribut);
/*  628 */       this.jTableAttribut.setDefaultRenderer(Object.class, this.tabR);
/*  629 */       this.jTableAttribut.setDefaultRenderer(JButton.class, new ProprieteBoutonCellRender());
/*  630 */       this.jTableAttribut.setDefaultRenderer(Boolean.class, new CheckBoxCellRender());
/*      */       
/*      */ 
/*      */ 
/*  634 */       this.jTableAttribut.setRowHeight(30);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean verifierAttributVide()
/*      */   {
/*  640 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/*  641 */       Attribut2 att = (Attribut2)this.listeAttribut.get(i);
/*  642 */       if (att.getNom().trim().length() == 0) {
/*  643 */         JOptionPane.showMessageDialog(this, "La ligne num= " + (i + 1) + ",l'attribut " + att.getNom() + " doit avoir un nom ", "Erreur", 0);
/*  644 */         return false;
/*      */       }
/*  646 */       if ((att.getListeAttributs().size() == 0) && 
/*  647 */         (att.getType().trim().length() == 0)) {
/*  648 */         JOptionPane.showMessageDialog(this, "La ligne num= " + (i + 1) + ",l'attribut " + att.getNom() + " doit avoir un type ", "Erreur", 0);
/*  649 */         return false;
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  654 */     return true;
/*      */   }
/*      */   
/*      */   private boolean verifierExisteAttribut()
/*      */   {
/*  659 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/*  660 */       Attribut att = existeAttribut((Attribut2)this.listeAttribut.get(i), i + 1);
/*  661 */       if (att != null) {
/*  662 */         JOptionPane.showMessageDialog(this, "La ligne num = " + (i + 1) + "," + att.getNom() + " existe dans la liste au moins deux fois !! ", "Erreur", 0);
/*  663 */         return false;
/*      */       }
/*  665 */       if (Outil.Parametres.isMotReserve(((Attribut)this.listeAttribut.get(i)).getNom().trim())) {
/*  666 */         System.out.println("l'attribut est mot reservé");
/*  667 */         JOptionPane.showMessageDialog(this, "La ligne num = " + (i + 1) + ", " + ((Attribut)this.listeAttribut.get(i)).getNom() + " Le nom de l'attribut est un mot réservé !! ", "Erreur", 0);
/*  668 */         return false;
/*      */       }
/*      */       
/*  671 */       if (Outil.Parametres.isMotReserve(((Attribut2)this.listeAttribut.get(i)).getCode().trim())) {
/*  672 */         System.out.println("l'attribut est un mot reservé");
/*  673 */         JOptionPane.showMessageDialog(this, "La ligne num = " + (i + 1) + ", " + ((Attribut2)this.listeAttribut.get(i)).getCode() + " Le code de l'attribut est un mot réservé !! ", "Erreur", 0);
/*  674 */         return false;
/*      */       }
/*      */       
/*  677 */       if (Outil.Setting.attUniq) {
/*  678 */         if (!uniqueAttribut(((Attribut)this.listeAttribut.get(i)).getNom().trim())) {
/*  679 */           JOptionPane.showMessageDialog(this, "La ligne num = " + (i + 1) + ", " + ((Attribut)this.listeAttribut.get(i)).getNom() + " Le nom de l'attribut est utilisé dans d'autres entités du MCD : il n'est pas unique !! ", "Erreur", 0);
/*  680 */           return false;
/*      */         }
/*  682 */         if (!uniqueAttribut(((Attribut2)this.listeAttribut.get(i)).getCode().trim())) {
/*  683 */           JOptionPane.showMessageDialog(this, "La ligne num = " + (i + 1) + ", " + ((Attribut2)this.listeAttribut.get(i)).getCode() + " Le code de l'attribut est utilisé dans d'autres entités du MCD : il n'est pas unique !! ", "Erreur", 0);
/*  684 */           return false;
/*      */         }
/*      */       }
/*      */     }
/*  688 */     return true;
/*      */   }
/*      */   
/*      */   public boolean uniqueAttribut(String att) {
/*  692 */     int n = this.frm.getFormeMCD().getPage().getListeEntiteRelation().size();
/*  693 */     for (int i = 0; i < n; i++) {
/*  694 */       if (((this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i) instanceof IhmEntite2)) && 
/*  695 */         (!uniqueAttributListe(att, ((IhmEntite2)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs()))) {
/*  696 */         return false;
/*      */       }
/*      */       
/*  699 */       if (((this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i) instanceof IhmRelation2)) && 
/*  700 */         (!uniqueAttributListe(att, ((IhmRelation2)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs()))) {
/*  701 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  705 */     return true;
/*      */   }
/*      */   
/*      */   public boolean uniqueAttributListe(String att, ArrayList<Attribut> liste) {
/*  709 */     for (int i = 0; i < liste.size(); i++) {
/*  710 */       if (att.trim().toUpperCase().equals(((Attribut)liste.get(i)).getNom().trim().toUpperCase())) return false;
/*      */     }
/*  712 */     return true;
/*      */   }
/*      */   
/*      */   private Attribut2 existeAttribut(Attribut2 att, int nb) {
/*  716 */     for (int i = nb; i < this.listeAttribut.size(); i++) {
/*  717 */       if ((this.listeAttribut.get(i) != att) && 
/*  718 */         (att.getNom().trim().toUpperCase().equals(((Attribut)this.listeAttribut.get(i)).getNom().trim().toUpperCase()))) {
/*  719 */         return (Attribut2)this.listeAttribut.get(i);
/*      */       }
/*      */     }
/*      */     
/*  723 */     return null;
/*      */   }
/*      */   
/*      */   private boolean verifierAttribut() {
/*  727 */     if ((verifierAttributVide()) && 
/*  728 */       (verifierExisteAttribut())) {
/*  729 */       return true;
/*      */     }
/*      */     
/*  732 */     return false;
/*      */   }
/*      */   
/*      */   private Attribut2 corrigerAttribut(Attribut2 att) {
/*  736 */     if ((this.entite instanceof IhmRelation2)) {
/*  737 */       att.setKey("");
/*  738 */       if (att.getType().toUpperCase().equals("AUTO_INCREMENT")) {
/*  739 */         att.setType("");
/*      */       }
/*      */     }
/*      */     
/*  743 */     att.setKey("");
/*      */     
/*      */ 
/*  746 */     return att;
/*      */   }
/*      */   
/*      */   private ArrayList<Attribut> corrigerAttributs(ArrayList<Attribut> liste) {
/*  750 */     for (int i = 0; i < liste.size(); i++) {
/*  751 */       corrigerAttribut((Attribut2)liste.get(i));
/*      */     }
/*  753 */     return liste;
/*      */   }
/*      */   
/*      */   private Attribut2 existeAttributDansListe(Attribut2 att)
/*      */   {
/*  758 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/*  759 */       if ((this.listeAttribut.get(i) != att) && 
/*  760 */         (att.getNom().trim().toUpperCase().equals(((Attribut)this.listeAttribut.get(i)).getNom().trim().toUpperCase()))) {
/*  761 */         return (Attribut2)this.listeAttribut.get(i);
/*      */       }
/*      */     }
/*      */     
/*  765 */     return null; }
/*      */   private JLabel jLabel1;
/*      */   private JLabel jLabel10;
/*      */   private JLabel jLabel11;
/*      */   
/*  770 */   private void affectationReferenceAttributEntite(ArrayList<Attribut> liste) { for (int i = 0; i < liste.size(); i++) {
/*  771 */       Attribut att = (Attribut)liste.get(i);
/*  772 */       att.setEntiteRelation(((IhmEntite2)this.entite).getEntite());
/*      */     } }
/*      */   
/*      */   private JLabel jLabel12;
/*      */   private JLabel jLabel16;
/*      */   private JLabel jLabel2;
/*      */   
/*  779 */   private void affectationReferenceAttributRelation(ArrayList<Attribut> liste) { for (int i = 0; i < liste.size(); i++) {
/*  780 */       Attribut att = (Attribut)liste.get(i);
/*  781 */       att.setEntiteRelation(((IhmRelation2)this.entite).getRelation());
/*      */     } }
/*      */   
/*      */   private JLabel jLabel20;
/*      */   private JLabel jLabel21;
/*  786 */   private void affectationReferenceAttribut(ArrayList<Attribut> liste) { if ((this.entite instanceof IhmEntite2)) {
/*  787 */       affectationReferenceAttributEntite(liste);
/*      */     }
/*  789 */     if ((this.entite instanceof IhmRelation2)) {
/*  790 */       affectationReferenceAttributRelation(liste);
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean isActiverUnsigned(String s)
/*      */   {
/*  796 */     boolean rep = false;
/*  797 */     s = s.trim().toUpperCase();
/*  798 */     if (s.equals("INT")) {
/*  799 */       return true;
/*      */     }
/*  801 */     if (s.equals("FLOAT")) {
/*  802 */       return true;
/*      */     }
/*  804 */     if (s.equals("MONEY")) {
/*  805 */       return true;
/*      */     }
/*  807 */     if (s.equals("BIGINT")) {
/*  808 */       return true;
/*      */     }
/*  810 */     if (s.equals("DECIMAL")) {
/*  811 */       return true;
/*      */     }
/*  813 */     if (s.equals("DOUBLE")) {
/*  814 */       return true;
/*      */     }
/*  816 */     if (s.equals("DOUBLE PRECISION")) {
/*  817 */       return true;
/*      */     }
/*  819 */     if (s.equals("NUMERIC")) {
/*  820 */       return true;
/*      */     }
/*  822 */     if (s.equals("MEDIUMINT")) {
/*  823 */       return true;
/*      */     }
/*  825 */     if (s.equals("REAL")) {
/*  826 */       return true;
/*      */     }
/*  828 */     if (s.equals("SMALLINT")) {
/*  829 */       return true;
/*      */     }
/*  831 */     if (s.equals("TINYINT")) {
/*  832 */       return true;
/*      */     }
/*  834 */     if (s.equals("INTEGER")) {
/*  835 */       return true;
/*      */     }
/*  837 */     if (s.equals("AUTO_INCREMENT")) {
/*  838 */       return true;
/*      */     }
/*  840 */     return rep;
/*      */   }
/*      */   
/*      */   private void miseAjourListe() {
/*  844 */     int nb = this.jTableAttribut.getModel().getRowCount();
/*  845 */     for (int i = 0; i < nb; i++) {
/*  846 */       if ((this.jTableAttribut.getCellEditor(0, i) instanceof ProprieteBoutonCellEditor)) {
/*  847 */         ((ProprieteBoutonCellEditor)this.jTableAttribut.getCellEditor(0, i)).setListAttribut(this.listeAttribut);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void copierAttributVersAttribut(Attribut2 aC, Attribut2 aS)
/*      */   {
/*  854 */     aC.setNom(aS.getNom());
/*  855 */     aC.setCode(aS.getCode());
/*  856 */     aC.setCommentaire(aS.getCommentaire());
/*  857 */     aC.setValeurDefaut(aS.getValeurDefaut());
/*  858 */     aC.setAfficher(aS.isAfficher());
/*  859 */     aC.setClNom(aS.getClNom());
/*  860 */     aC.setClCode(aS.getClCode());
/*  861 */     aC.setClType(aS.getClType());
/*  862 */     aC.setClTaille(aS.getClTaille());
/*  863 */     aC.setClTailleDecimale(aS.getClTailleDecimale()); }
/*      */   private JLabel jLabel3;
/*      */   private JLabel jLabel4;
/*      */   
/*  867 */   private void MAJListeAttribut() { Object[] tab = this.listeAttributCorresp.keySet().toArray();
/*      */     
/*  869 */     for (int i = 0; i < tab.length; i++) {
/*  870 */       Attribut2 aC = (Attribut2)tab[i];
/*  871 */       Attribut2 aS = (Attribut2)this.listeAttributCorresp.get(aC);
/*  872 */       copierAttributVersAttribut(aC, aS); } }
/*      */   
/*      */   private JLabel jLabel5;
/*      */   private JLabel jLabel6;
/*      */   
/*  877 */   private Attribut getSourceAttribut(Attribut att) { Object[] tab = this.listeAttributCorresp.keySet().toArray();
/*      */     
/*  879 */     for (int i = 0; i < tab.length; i++) {
/*  880 */       Attribut2 aC = (Attribut2)tab[i];
/*  881 */       Attribut2 aS = (Attribut2)this.listeAttributCorresp.get(aC);
/*  882 */       if (aS == att) return aC;
/*      */     }
/*  884 */     return null; }
/*      */   
/*      */   private JLabel jLabel7;
/*      */   
/*  888 */   private ArrayList<Attribut> ordonnerListeAttribut() { ArrayList<Attribut> liste = new ArrayList();
/*      */     
/*      */ 
/*  891 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/*  892 */       Attribut a = getSourceAttribut((Attribut)this.listeAttribut.get(i));
/*  893 */       a = (Attribut)this.listeAttributCorresp.get(a);
/*      */       
/*  895 */       a = getSourceAttribut(a);
/*      */       
/*  897 */       liste.add(a);
/*      */     }
/*      */     
/*  900 */     return liste; }
/*      */   
/*      */   private JLabel jLabel8;
/*      */   
/*  904 */   private boolean MAJAttributsMLD() { if (this.listeAttribut.size() > 0) {
/*  905 */       MAJListeAttribut();
/*  906 */       this.attributPere.setClNom(getColor(this.jLabClNom.getBackground()));
/*  907 */       this.attributPere.setClCode(getColor(this.jLabClNom.getBackground()));
/*  908 */       this.attributPere.setClType(getColor(this.jLabClType.getBackground()));
/*  909 */       this.attributPere.setClTaille(getColor(this.jLabClTaille.getBackground()));
/*  910 */       this.attributPere.setClTailleDecimale(getColor(this.jLabClTailleDec.getBackground()));
/*      */       
/*  912 */       this.attributPere.setListeAttributs(ordonnerListeAttribut());
/*  913 */       this.attributPere.setCommentaire(this.jTACommentaire.getText());
/*  914 */       return true;
/*      */     }
/*      */     
/*  917 */     if (this.jTFNom.getText().trim().length() == 0) {
/*  918 */       JOptionPane.showMessageDialog(this, "Le champ nom ne doit pas être vide  ", "Vérification", 0);
/*      */     }
/*  920 */     else if (this.jTFCode.getText().trim().length() == 0) {
/*  921 */       JOptionPane.showMessageDialog(this, "Le champ code ne doit pas être vide  ", "Vérification", 0);
/*      */     } else {
/*  923 */       this.attributPere.setNom(this.jTFNom.getText().trim());
/*  924 */       this.attributPere.setCode(this.jTFNom.getText().trim().toUpperCase());
/*  925 */       this.attributPere.setAfficher(this.jCBAfficher.isSelected());
/*  926 */       this.attributPere.setCommentaire(this.jTACommentaire.getText());
/*  927 */       this.attributPere.setValeurDefaut(this.jTFValDefaut.getText().trim());
/*  928 */       this.attributPere.setClNom(getColor(this.jLabClNom.getBackground()));
/*  929 */       this.attributPere.setClCode(getColor(this.jLabClNom.getBackground()));
/*  930 */       this.attributPere.setClType(getColor(this.jLabClType.getBackground()));
/*  931 */       this.attributPere.setClTaille(getColor(this.jLabClTaille.getBackground()));
/*  932 */       this.attributPere.setClTailleDecimale(getColor(this.jLabClTailleDec.getBackground()));
/*  933 */       MAJListeAttribut();
/*  934 */       this.attributPere.setListeAttributs(ordonnerListeAttribut());
/*  935 */       return true;
/*      */     }
/*      */     
/*  938 */     return false;
/*      */   }
/*      */   
/*      */   private JLabel jLabel9;
/*      */   private JLabel jLbNom;
/*      */   private JLabel jLbTaille;
/*      */   private JLabel jLbTailleDec;
/*      */   private JLabel jLbType;
/*      */   private JPanel jPanel1;
/*      */   private JPanel jPanel2;
/*      */   private JPanel jPanel3;
/*      */   
/*      */   private void initComponents() {
/*  951 */     this.jBtValider = new JButton();
/*  952 */     this.jBtAnnuler = new JButton();
/*  953 */     this.jTabbedPane1 = new JTabbedPane();
/*  954 */     this.jPanel2 = new JPanel();
/*  955 */     this.jPanel1 = new JPanel();
/*  956 */     this.jLabel8 = new JLabel();
/*  957 */     this.jTFValDefaut = new JTextField();
/*  958 */     this.jScrollPane1 = new JScrollPane();
/*  959 */     this.jTACommentaire = new JTextArea();
/*  960 */     this.jBtCommentaire = new JButton();
/*  961 */     this.jLabel4 = new JLabel();
/*  962 */     this.jCBCle = new JComboBox();
/*  963 */     this.jLabel6 = new JLabel();
/*  964 */     this.jPanel5 = new JPanel();
/*  965 */     this.jLabClNom = new JLabel();
/*  966 */     this.jLbNom = new JLabel();
/*  967 */     this.jLbType = new JLabel();
/*  968 */     this.jLabClType = new JLabel();
/*  969 */     this.jLbTaille = new JLabel();
/*  970 */     this.jLabClTaille = new JLabel();
/*  971 */     this.jLbTailleDec = new JLabel();
/*  972 */     this.jLabClTailleDec = new JLabel();
/*  973 */     this.jTextField1 = new JTextField();
/*  974 */     this.jLabel20 = new JLabel();
/*  975 */     this.jButton1 = new JButton();
/*  976 */     this.jPanel3 = new JPanel();
/*  977 */     this.jCBAfficher = new JCheckBox();
/*  978 */     this.jLabel7 = new JLabel();
/*  979 */     this.jBtHistorique = new JButton();
/*  980 */     this.jLabel10 = new JLabel();
/*  981 */     this.jTFAttributPere = new JTextField();
/*  982 */     this.jTFEntite = new JTextField();
/*  983 */     this.jLabel11 = new JLabel();
/*  984 */     this.jTFAugmentation = new JTextField();
/*  985 */     this.jLabel12 = new JLabel();
/*  986 */     this.jScrollPane3 = new JScrollPane();
/*  987 */     this.jTextArea1 = new JTextArea();
/*  988 */     this.jPanel4 = new JPanel();
/*  989 */     this.jScrollPane2 = new JScrollPane();
/*  990 */     this.jTableAttribut = new JTable();
/*  991 */     this.jBTAjouter = new JButton();
/*  992 */     this.jBTSupprimer = new JButton();
/*  993 */     this.jBtRemonter = new JButton();
/*  994 */     this.jBtPropriete = new JButton();
/*  995 */     this.jBtDescendre = new JButton();
/*  996 */     this.jBtImporterAttribut = new JButton();
/*  997 */     this.jBtDictionnaire = new JButton();
/*  998 */     this.jLabel16 = new JLabel();
/*  999 */     this.jLabel21 = new JLabel();
/* 1000 */     this.jLabel1 = new JLabel();
/* 1001 */     this.jTFNom = new JTextField();
/* 1002 */     this.jTFCode = new JTextField();
/* 1003 */     this.jLabel5 = new JLabel();
/* 1004 */     this.jLabel2 = new JLabel();
/* 1005 */     this.jCBType = new JComboBox();
/* 1006 */     this.jLabel3 = new JLabel();
/* 1007 */     this.jTFLongueur = new JTextField();
/* 1008 */     this.jLabel9 = new JLabel();
/* 1009 */     this.jTFDecimale = new JTextField();
/* 1010 */     this.jCBNull = new JCheckBox();
/* 1011 */     this.jCBunsigned = new JCheckBox();
/* 1012 */     this.jCBHistorisation = new JCheckBox();
/*      */     
/* 1014 */     setDefaultCloseOperation(2);
/* 1015 */     setTitle("Propriétés de l'attribut  ");
/* 1016 */     setResizable(false);
/* 1017 */     addWindowListener(new java.awt.event.WindowAdapter() {
/*      */       public void windowClosed(java.awt.event.WindowEvent evt) {
/* 1019 */         FormeProprieteAttribut2.this.formWindowClosed(evt);
/*      */       }
/*      */       
/* 1022 */     });
/* 1023 */     this.jBtValider.setIcon(new ImageIcon(getClass().getResource("/Images/OK.png")));
/* 1024 */     this.jBtValider.setText("Valider");
/* 1025 */     this.jBtValider.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1027 */         FormeProprieteAttribut2.this.jBtValiderActionPerformed(evt);
/*      */       }
/*      */       
/* 1030 */     });
/* 1031 */     this.jBtAnnuler.setIcon(new ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 1032 */     this.jBtAnnuler.setText("Annuler");
/* 1033 */     this.jBtAnnuler.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1035 */         FormeProprieteAttribut2.this.jBtAnnulerActionPerformed(evt);
/*      */       }
/*      */       
/* 1038 */     });
/* 1039 */     this.jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/*      */     
/* 1041 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
/*      */     
/* 1043 */     this.jLabel8.setText("Val défaut");
/*      */     
/* 1045 */     this.jTFValDefaut.setFont(new Font("Tahoma", 1, 11));
/*      */     
/* 1047 */     this.jTACommentaire.setColumns(20);
/* 1048 */     this.jTACommentaire.setRows(5);
/* 1049 */     this.jScrollPane1.setViewportView(this.jTACommentaire);
/*      */     
/* 1051 */     this.jBtCommentaire.setText("...");
/* 1052 */     this.jBtCommentaire.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1054 */         FormeProprieteAttribut2.this.jBtCommentaireActionPerformed(evt);
/*      */       }
/*      */       
/* 1057 */     });
/* 1058 */     this.jLabel4.setText("Commentaire");
/*      */     
/* 1060 */     this.jCBCle.setFont(new Font("Tahoma", 1, 12));
/*      */     
/* 1062 */     this.jLabel6.setText("Contrainte ");
/*      */     
/* 1064 */     this.jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Couleur"));
/*      */     
/* 1066 */     this.jLabClNom.setBackground(new Color(0, 0, 0));
/* 1067 */     this.jLabClNom.setText("             ");
/* 1068 */     this.jLabClNom.setCursor(new Cursor(12));
/* 1069 */     this.jLabClNom.setOpaque(true);
/* 1070 */     this.jLabClNom.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1072 */         FormeProprieteAttribut2.this.jLabClNomMouseClicked(evt);
/*      */       }
/*      */       
/* 1075 */     });
/* 1076 */     this.jLbNom.setText("Nom");
/* 1077 */     this.jLbNom.setCursor(new Cursor(10));
/* 1078 */     this.jLbNom.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1080 */         FormeProprieteAttribut2.this.jLbNomMouseClicked(evt);
/*      */       }
/*      */       
/* 1083 */     });
/* 1084 */     this.jLbType.setText("Type");
/* 1085 */     this.jLbType.setCursor(new Cursor(11));
/* 1086 */     this.jLbType.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1088 */         FormeProprieteAttribut2.this.jLbTypeMouseClicked(evt);
/*      */       }
/*      */       
/* 1091 */     });
/* 1092 */     this.jLabClType.setBackground(new Color(0, 0, 0));
/* 1093 */     this.jLabClType.setText("             ");
/* 1094 */     this.jLabClType.setCursor(new Cursor(12));
/* 1095 */     this.jLabClType.setOpaque(true);
/* 1096 */     this.jLabClType.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1098 */         FormeProprieteAttribut2.this.jLabClTypeMouseClicked(evt);
/*      */       }
/* 1100 */     });
/* 1101 */     this.jLabClType.addKeyListener(new java.awt.event.KeyAdapter() {
/*      */       public void keyPressed(KeyEvent evt) {
/* 1103 */         FormeProprieteAttribut2.this.jLabClTypeKeyPressed(evt);
/*      */       }
/*      */       
/* 1106 */     });
/* 1107 */     this.jLbTaille.setText("Taille");
/* 1108 */     this.jLbTaille.setCursor(new Cursor(10));
/* 1109 */     this.jLbTaille.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1111 */         FormeProprieteAttribut2.this.jLbTailleMouseClicked(evt);
/*      */       }
/*      */       
/* 1114 */     });
/* 1115 */     this.jLabClTaille.setBackground(new Color(0, 0, 0));
/* 1116 */     this.jLabClTaille.setText("             ");
/* 1117 */     this.jLabClTaille.setCursor(new Cursor(12));
/* 1118 */     this.jLabClTaille.setOpaque(true);
/* 1119 */     this.jLabClTaille.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1121 */         FormeProprieteAttribut2.this.jLabClTailleMouseClicked(evt);
/*      */       }
/*      */       
/* 1124 */     });
/* 1125 */     this.jLbTailleDec.setText("Taille Dec");
/* 1126 */     this.jLbTailleDec.setCursor(new Cursor(11));
/* 1127 */     this.jLbTailleDec.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1129 */         FormeProprieteAttribut2.this.jLbTailleDecMouseClicked(evt);
/*      */       }
/*      */       
/* 1132 */     });
/* 1133 */     this.jLabClTailleDec.setBackground(new Color(0, 0, 0));
/* 1134 */     this.jLabClTailleDec.setText("             ");
/* 1135 */     this.jLabClTailleDec.setCursor(new Cursor(12));
/* 1136 */     this.jLabClTailleDec.setOpaque(true);
/* 1137 */     this.jLabClTailleDec.addMouseListener(new MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/* 1139 */         FormeProprieteAttribut2.this.jLabClTailleDecMouseClicked(evt);
/*      */       }
/*      */       
/* 1142 */     });
/* 1143 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 1144 */     this.jPanel5.setLayout(jPanel5Layout);
/* 1145 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addContainerGap(22, 32767).addComponent(this.jLbNom).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabClNom).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLbType).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabClType).addGap(18, 18, 18).addComponent(this.jLbTaille).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabClTaille).addGap(18, 18, 18).addComponent(this.jLbTailleDec).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jLabClTailleDec).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1166 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabClTailleDec).addComponent(this.jLabClTaille).addComponent(this.jLbType).addComponent(this.jLabClType).addComponent(this.jLbTailleDec).addComponent(this.jLbTaille).addComponent(this.jLbNom).addComponent(this.jLabClNom)).addContainerGap(14, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1181 */     this.jTextField1.setEnabled(false);
/*      */     
/* 1183 */     this.jLabel20.setText("Contrainte sur sa valeur");
/*      */     
/* 1185 */     this.jButton1.setText("...");
/* 1186 */     this.jButton1.setEnabled(false);
/*      */     
/* 1188 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 1189 */     this.jPanel1.setLayout(jPanel1Layout);
/* 1190 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 570, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel6).addComponent(this.jLabel8)).addGap(17, 17, 17).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTFValDefaut, -1, 499, 32767).addComponent(this.jCBCle, 0, 499, 32767))).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel4).addGap(18, 18, 18).addComponent(this.jBtCommentaire).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 44, 32767).addComponent(this.jPanel5, -2, -1, -2)).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel20).addGap(18, 18, 18).addComponent(this.jTextField1, -1, 373, 32767).addGap(18, 18, 18).addComponent(this.jButton1))).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1218 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBCle, -2, 31, -2).addComponent(this.jLabel6)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.jTFValDefaut, -2, 27, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel20).addComponent(this.jTextField1, -2, 27, -2).addComponent(this.jButton1)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jBtCommentaire, -2, 19, -2)).addComponent(this.jPanel5, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -1, 108, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1243 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 1244 */     this.jPanel2.setLayout(jPanel2Layout);
/* 1245 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1252 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1260 */     this.jTabbedPane1.addTab("Propriétés", this.jPanel2);
/*      */     
/* 1262 */     this.jCBAfficher.setText("Afficher dans l'entité");
/*      */     
/* 1264 */     this.jLabel7.setText("Historique");
/*      */     
/* 1266 */     this.jBtHistorique.setText("...");
/* 1267 */     this.jBtHistorique.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1269 */         FormeProprieteAttribut2.this.jBtHistoriqueActionPerformed(evt);
/*      */       }
/*      */       
/* 1272 */     });
/* 1273 */     this.jLabel10.setText("Attribut père");
/*      */     
/* 1275 */     this.jTFAttributPere.setEditable(false);
/*      */     
/* 1277 */     this.jTFEntite.setEditable(false);
/*      */     
/* 1279 */     this.jLabel11.setText("Entité/Relation");
/*      */     
/* 1281 */     this.jTFAugmentation.setEditable(false);
/* 1282 */     this.jTFAugmentation.setFont(new Font("Tahoma", 1, 12));
/*      */     
/* 1284 */     this.jLabel12.setText("Augmentation avec un péfixe du nom de l'attribut");
/*      */     
/* 1286 */     this.jTextArea1.setColumns(20);
/* 1287 */     this.jTextArea1.setEditable(false);
/* 1288 */     this.jTextArea1.setRows(5);
/* 1289 */     this.jScrollPane3.setViewportView(this.jTextArea1);
/*      */     
/* 1291 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/* 1292 */     this.jPanel3.setLayout(jPanel3Layout);
/* 1293 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jCBAfficher, -2, 151, -2).addComponent(this.jScrollPane3, GroupLayout.Alignment.LEADING, -1, 592, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel11).addComponent(this.jLabel10)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTFAttributPere, -1, 503, 32767).addComponent(this.jTFEntite, -1, 503, 32767))).addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup().addComponent(this.jLabel7).addGap(18, 18, 18).addComponent(this.jBtHistorique)).addGroup(GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup().addComponent(this.jLabel12).addGap(18, 18, 18).addComponent(this.jTFAugmentation, -1, 337, 32767))).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1318 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGap(31, 31, 31).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel10).addComponent(this.jTFAttributPere, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel11).addComponent(this.jTFEntite, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFAugmentation, -2, 22, -2).addComponent(this.jLabel12)).addGap(18, 18, 18).addComponent(this.jCBAfficher).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, 32767).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtHistorique, -2, 19, -2).addComponent(this.jLabel7)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane3, -2, -1, -2).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1344 */     this.jTabbedPane1.addTab("Informations", this.jPanel3);
/*      */     
/* 1346 */     this.jTableAttribut.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null } }, new String[] { "Nom", "Code", "Type", "Taille", "Decimale", "Afficher" }));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1364 */     this.jTableAttribut.addKeyListener(new java.awt.event.KeyAdapter() {
/*      */       public void keyPressed(KeyEvent evt) {
/* 1366 */         FormeProprieteAttribut2.this.jTableAttributKeyPressed(evt);
/*      */       }
/* 1368 */     });
/* 1369 */     this.jScrollPane2.setViewportView(this.jTableAttribut);
/*      */     
/* 1371 */     this.jBTAjouter.setIcon(new ImageIcon(getClass().getResource("/Images/Ajouter.png")));
/* 1372 */     this.jBTAjouter.setToolTipText("Ajouter un attribut");
/* 1373 */     this.jBTAjouter.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1375 */         FormeProprieteAttribut2.this.jBTAjouterActionPerformed(evt);
/*      */       }
/*      */       
/* 1378 */     });
/* 1379 */     this.jBTSupprimer.setIcon(new ImageIcon(getClass().getResource("/Images/supprimer.png")));
/* 1380 */     this.jBTSupprimer.setToolTipText("Supprimer un attribut");
/* 1381 */     this.jBTSupprimer.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1383 */         FormeProprieteAttribut2.this.jBTSupprimerActionPerformed(evt);
/*      */       }
/*      */       
/* 1386 */     });
/* 1387 */     this.jBtRemonter.setIcon(new ImageIcon(getClass().getResource("/Images/monter.png")));
/* 1388 */     this.jBtRemonter.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1390 */         FormeProprieteAttribut2.this.jBtRemonterActionPerformed(evt);
/*      */       }
/*      */       
/* 1393 */     });
/* 1394 */     this.jBtPropriete.setIcon(new ImageIcon(getClass().getResource("/Images/oeil.png")));
/* 1395 */     this.jBtPropriete.setText("Propriété");
/* 1396 */     this.jBtPropriete.setToolTipText("Voir propriétés d'un attribut");
/* 1397 */     this.jBtPropriete.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1399 */         FormeProprieteAttribut2.this.jBtProprieteActionPerformed(evt);
/*      */       }
/*      */       
/* 1402 */     });
/* 1403 */     this.jBtDescendre.setIcon(new ImageIcon(getClass().getResource("/Images/descendre.png")));
/* 1404 */     this.jBtDescendre.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1406 */         FormeProprieteAttribut2.this.jBtDescendreActionPerformed(evt);
/*      */       }
/*      */       
/* 1409 */     });
/* 1410 */     this.jBtImporterAttribut.setFont(new Font("Tahoma", 1, 11));
/* 1411 */     this.jBtImporterAttribut.setForeground(new Color(0, 0, 102));
/* 1412 */     this.jBtImporterAttribut.setText("Importer des Attributs ");
/* 1413 */     this.jBtImporterAttribut.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1415 */         FormeProprieteAttribut2.this.jBtImporterAttributActionPerformed(evt);
/*      */       }
/*      */       
/* 1418 */     });
/* 1419 */     this.jBtDictionnaire.setFont(new Font("Tahoma", 1, 11));
/* 1420 */     this.jBtDictionnaire.setForeground(new Color(255, 0, 0));
/* 1421 */     this.jBtDictionnaire.setText("Dictionnaire de données");
/* 1422 */     this.jBtDictionnaire.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1424 */         FormeProprieteAttribut2.this.jBtDictionnaireActionPerformed(evt);
/*      */       }
/*      */       
/* 1427 */     });
/* 1428 */     this.jLabel16.setBackground(new Color(255, 150, 125));
/* 1429 */     this.jLabel16.setText("      ");
/* 1430 */     this.jLabel16.setOpaque(true);
/*      */     
/* 1432 */     this.jLabel21.setText("Attribut composé");
/*      */     
/* 1434 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/* 1435 */     this.jPanel4.setLayout(jPanel4Layout);
/* 1436 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -1, 592, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jBtDictionnaire, -2, 179, -2).addGap(37, 37, 37).addComponent(this.jLabel16, -2, 32, -2).addGap(18, 18, 18).addComponent(this.jLabel21).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, 32767).addComponent(this.jBtImporterAttribut, -2, 197, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addGap(138, 138, 138).addComponent(this.jBtRemonter).addGap(28, 28, 28).addComponent(this.jBtDescendre).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 74, 32767).addComponent(this.jBtPropriete, -2, 118, -2).addGap(46, 46, 46).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jBTAjouter, -1, -1, 32767).addComponent(this.jBTSupprimer, GroupLayout.Alignment.TRAILING, -2, 100, -2)))).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1465 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jBtImporterAttribut).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtDictionnaire).addComponent(this.jLabel16).addComponent(this.jLabel21))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jScrollPane2, -2, 204, -2).addGap(18, 18, 18).addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jBTAjouter).addComponent(this.jBtRemonter).addComponent(this.jBtDescendre).addComponent(this.jBtPropriete)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jBTSupprimer).addGap(35, 35, 35)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1488 */     this.jTabbedPane1.addTab("Sous Attributs", this.jPanel4);
/*      */     
/* 1490 */     this.jLabel1.setText("Nom ");
/*      */     
/* 1492 */     this.jTFNom.setFont(new Font("Tahoma", 1, 12));
/*      */     
/* 1494 */     this.jTFCode.setFont(new Font("Tahoma", 1, 12));
/* 1495 */     this.jTFCode.addMouseListener(new MouseAdapter() {
/*      */       public void mouseEntered(MouseEvent evt) {
/* 1497 */         FormeProprieteAttribut2.this.jTFCodeMouseEntered(evt);
/*      */       }
/*      */       
/* 1500 */       public void mousePressed(MouseEvent evt) { FormeProprieteAttribut2.this.jTFCodeMousePressed(evt);
/*      */       }
/* 1502 */     });
/* 1503 */     this.jTFCode.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/* 1505 */         FormeProprieteAttribut2.this.jTFCodeActionPerformed(evt);
/*      */       }
/* 1507 */     });
/* 1508 */     this.jTFCode.addFocusListener(new java.awt.event.FocusAdapter() {
/*      */       public void focusGained(FocusEvent evt) {
/* 1510 */         FormeProprieteAttribut2.this.jTFCodeFocusGained(evt);
/*      */       }
/* 1512 */     });
/* 1513 */     this.jTFCode.addKeyListener(new java.awt.event.KeyAdapter() {
/*      */       public void keyReleased(KeyEvent evt) {
/* 1515 */         FormeProprieteAttribut2.this.jTFCodeKeyReleased(evt);
/*      */       }
/*      */       
/* 1518 */     });
/* 1519 */     this.jLabel5.setText("Code");
/*      */     
/* 1521 */     this.jLabel2.setText("Type");
/*      */     
/* 1523 */     this.jCBType.setFont(new Font("Tahoma", 1, 12));
/* 1524 */     this.jCBType.addItemListener(new java.awt.event.ItemListener() {
/*      */       public void itemStateChanged(ItemEvent evt) {
/* 1526 */         FormeProprieteAttribut2.this.jCBTypeItemStateChanged(evt);
/*      */       }
/*      */       
/* 1529 */     });
/* 1530 */     this.jLabel3.setText("Taille");
/*      */     
/* 1532 */     this.jTFLongueur.setFont(new Font("Tahoma", 1, 11));
/* 1533 */     this.jTFLongueur.setHorizontalAlignment(0);
/*      */     
/* 1535 */     this.jLabel9.setText(",");
/*      */     
/* 1537 */     this.jTFDecimale.setFont(new Font("Tahoma", 1, 11));
/* 1538 */     this.jTFDecimale.setHorizontalAlignment(0);
/*      */     
/* 1540 */     this.jCBNull.setText("Null");
/* 1541 */     this.jCBNull.setHorizontalAlignment(2);
/*      */     
/* 1543 */     this.jCBunsigned.setText("Unsigned");
/* 1544 */     this.jCBunsigned.setEnabled(false);
/*      */     
/* 1546 */     this.jCBHistorisation.setText("Historisation");
/*      */     
/* 1548 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 1549 */     getContentPane().setLayout(layout);
/* 1550 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTabbedPane1, 0, 0, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(1, 1, 1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jTFNom, -2, 247, -2).addGap(18, 18, 18).addComponent(this.jLabel5).addGap(17, 17, 17).addComponent(this.jTFCode, -1, 271, 32767)).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel2).addComponent(this.jLabel3)).addGap(17, 17, 17).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jCBType, -2, 579, -2).addGroup(layout.createSequentialGroup().addComponent(this.jTFLongueur, -2, 78, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel9, -2, 8, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTFDecimale, -2, 74, -2).addGap(59, 59, 59).addComponent(this.jCBNull, -2, 51, -2).addGap(70, 70, 70).addComponent(this.jCBunsigned).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.jCBHistorisation)))))).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jBtAnnuler).addGap(18, 18, 18).addComponent(this.jBtValider))).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1592 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFNom, -2, 27, -2).addComponent(this.jLabel5).addComponent(this.jTFCode, -2, 27, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jCBType, -2, 27, -2)).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTFLongueur, -2, 28, -2).addComponent(this.jTFDecimale, -2, 27, -2).addComponent(this.jLabel9).addComponent(this.jCBNull, -2, 23, -2).addComponent(this.jCBHistorisation).addComponent(this.jCBunsigned)).addGap(18, 18, 18).addComponent(this.jTabbedPane1, -2, 369, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler)).addContainerGap(-1, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1623 */     pack(); }
/*      */   
/*      */   private JPanel jPanel4;
/*      */   
/* 1627 */   private void jBtValiderActionPerformed(ActionEvent evt) { if ((this.entite instanceof MLDEntite2)) {
/* 1628 */       String rep = verificationAdaptation.VerificationMLD.verifierMLDentite2(this.listeAttribut);
/* 1629 */       if (rep.trim().length() == 0) {
/* 1630 */         if (MAJAttributsMLD()) {
/* 1631 */           if (!this.frm.getFormeMLD().getPageMld().isEntiteModifer()) this.frm.getFormeMLD().getPageMld().setEntiteModifer(this.isEntiteMLDModifer);
/* 1632 */           dispose();
/*      */         }
/* 1634 */         return;
/*      */       }
/* 1636 */       JOptionPane.showMessageDialog(this, "Erreur  :\n " + rep, "Erreur", 0);
/* 1637 */       return;
/*      */     }
/*      */     
/*      */ 
/* 1641 */     if (this.attributPere == null) {
/* 1642 */       if ((correctRemplissageChamps()) && 
/* 1643 */         (!existeDejaNom()) && 
/* 1644 */         (!existeDejaCode()) && 
/* 1645 */         (verifierAttribut())) {
/* 1646 */         mettreAjourAttribut();
/* 1647 */         dispose();
/*      */ 
/*      */       }
/*      */       
/*      */ 
/*      */     }
/* 1653 */     else if ((correctRemplissageChamps()) && 
/* 1654 */       (!existeDejaNom()) && 
/* 1655 */       (!existeDejaCode()) && 
/* 1656 */       (verifierAttribut())) {
/* 1657 */       mettreAjourAttribut();
/* 1658 */       this.attributPere.setListeAttributs(this.listeAttribut);
/* 1659 */       dispose();
/*      */     } }
/*      */   
/*      */   private JPanel jPanel5;
/*      */   private JScrollPane jScrollPane1;
/*      */   private JScrollPane jScrollPane2;
/*      */   private JScrollPane jScrollPane3;
/*      */   private JTextArea jTACommentaire;
/*      */   
/* 1668 */   private void jBtAnnulerActionPerformed(ActionEvent evt) { dispose(); }
/*      */   
/*      */   private JTextField jTFAttributPere;
/*      */   
/* 1672 */   private void jBtHistoriqueActionPerformed(ActionEvent evt) { new FormeHistorique(this.frm, true, this.attribut.getHistorique(), "", "").setVisible(true); }
/*      */   
/*      */   private JTextField jTFAugmentation;
/*      */   
/* 1676 */   private void jTFCodeActionPerformed(ActionEvent evt) { if ((this.jTFCode.getText().trim().length() == 0) && 
/* 1677 */       (this.jTFNom.getText().trim().length() > 0))
/* 1678 */       this.jTFCode.setText(this.jTFNom.getText().trim().toUpperCase());
/*      */   }
/*      */   
/*      */   private JTextField jTFCode;
/*      */   private JTextField jTFDecimale;
/*      */   private JTextField jTFEntite;
/*      */   private JTextField jTFLongueur;
/*      */   
/*      */   private void jTFCodeMouseEntered(MouseEvent evt) {}
/*      */   
/* 1688 */   private void jTFCodeMousePressed(MouseEvent evt) { if ((this.jTFCode.getText().trim().length() == 0) && 
/* 1689 */       (this.jTFNom.getText().trim().length() > 0))
/* 1690 */       this.jTFCode.setText(this.jTFNom.getText().trim().toUpperCase()); }
/*      */   
/*      */   private JTextField jTFNom;
/*      */   private JTextField jTFValDefaut;
/*      */   private JTabbedPane jTabbedPane1;
/*      */   private JTable jTableAttribut;
/*      */   private JTextArea jTextArea1;
/*      */   private JTextField jTextField1;
/*      */   private void jTFCodeKeyReleased(KeyEvent evt) {}
/*      */   
/* 1700 */   private void jTFCodeFocusGained(FocusEvent evt) { if ((this.jTFCode.getText().trim().length() == 0) && 
/* 1701 */       (this.jTFNom.getText().trim().length() > 0)) {
/* 1702 */       this.jTFCode.setText(this.jTFNom.getText().trim().toUpperCase());
/*      */     }
/*      */   }
/*      */   
/*      */   private void jCBTypeItemStateChanged(ItemEvent evt)
/*      */   {
/* 1708 */     if ((this.jCBType.getSelectedItem().toString().trim().toUpperCase().equals("VARCHAR")) && 
/* 1709 */       (this.jTFLongueur.getText().trim().length() == 0)) {
/* 1710 */       this.jTFLongueur.setText(FormeEntite2.longVarchar + "");
/*      */     }
/* 1712 */     if ((this.jCBType.getSelectedItem().toString().trim().toUpperCase().equals("CHAR")) && 
/* 1713 */       (this.jTFLongueur.getText().trim().length() == 0)) {
/* 1714 */       this.jTFLongueur.setText(FormeEntite2.longChar + "");
/*      */     }
/*      */     
/* 1717 */     String s = (String)this.jCBType.getSelectedItem();
/* 1718 */     this.jCBunsigned.setEnabled(isActiverUnsigned(s));
/*      */   }
/*      */   
/*      */   private void jBtCommentaireActionPerformed(ActionEvent evt)
/*      */   {
/* 1723 */     FormeText f = new FormeText(this.frm, true, this.jTACommentaire);
/* 1724 */     f.setTitle("Commentaire Attribut");
/* 1725 */     f.setVisible(true);
/*      */   }
/*      */   
/*      */   private void jBTAjouterActionPerformed(ActionEvent evt) {
/* 1729 */     Attribut2 att = new Attribut2("", "", -1, -1, "", false, "", null);
/* 1730 */     affectationReferenceAttribut(att);
/* 1731 */     att.setClNom(getColor(this.jLabClNom.getBackground()));
/* 1732 */     att.setClCode(getColor(this.jLabClNom.getBackground()));
/* 1733 */     att.setClType(getColor(this.jLabClType.getBackground()));
/* 1734 */     att.setClTaille(getColor(this.jLabClTaille.getBackground()));
/* 1735 */     att.setClTailleDecimale(getColor(this.jLabClTailleDec.getBackground()));
/*      */     
/* 1737 */     this.listeAttribut.add(att);
/* 1738 */     this.tableModel.addAttribut(att);
/* 1739 */     this.jTableAttribut.setRowSelectionInterval(this.listeAttribut.size() - 1, this.listeAttribut.size() - 1);
/*      */   }
/*      */   
/*      */ 
/*      */   private void jBtDescendreActionPerformed(ActionEvent evt)
/*      */   {
/* 1745 */     if (this.jTableAttribut.getSelectedRow() < 0) { return;
/*      */     }
/* 1747 */     if (this.jTableAttribut.getSelectedRow() < this.listeAttribut.size() - 1) {
/* 1748 */       descendreAttribut(this.jTableAttribut.getSelectedRow());
/*      */     }
/*      */   }
/*      */   
/*      */   private void jBtRemonterActionPerformed(ActionEvent evt) {
/* 1753 */     if (this.jTableAttribut.getSelectedRow() >= 0) {
/* 1754 */       remonterAttribut(this.jTableAttribut.getSelectedRow());
/*      */     }
/*      */   }
/*      */   
/*      */   private void jBtProprieteActionPerformed(ActionEvent evt) {
/* 1759 */     if (this.jTableAttribut.getSelectedRow() >= 0) {
/* 1760 */       Attribut2 a = (Attribut2)this.listeAttribut.get(this.jTableAttribut.getSelectedRow());
/* 1761 */       new FormeProprieteAttribut2(this.frm, true, a, a.getListeAttributs(), this.entite, true, this.attributPere).setVisible(true);
/* 1762 */       this.jTableAttribut.repaint();
/*      */     } else {
/* 1764 */       JOptionPane.showMessageDialog(this, "Info : Aucun attribut n'est sélectionné !!! ");
/*      */     }
/*      */   }
/*      */   
/*      */   private void jTableAttributKeyPressed(KeyEvent evt) {
/* 1769 */     if ((evt.getKeyCode() == 10) && 
/* 1770 */       (this.jTableAttribut.getSelectedRow() == this.jTableAttribut.getRowCount() - 1)) {
/* 1771 */       Attribut2 att = new Attribut2("", "", -1, -1, "", false, "", null);
/* 1772 */       att.setClNom(getColor(this.jLabClNom.getBackground()));
/* 1773 */       att.setClCode(getColor(this.jLabClNom.getBackground()));
/* 1774 */       att.setClType(getColor(this.jLabClType.getBackground()));
/* 1775 */       att.setClTaille(getColor(this.jLabClTaille.getBackground()));
/* 1776 */       att.setClTailleDecimale(getColor(this.jLabClTailleDec.getBackground()));
/* 1777 */       affectationReferenceAttribut(att);
/* 1778 */       this.listeAttribut.add(att);
/* 1779 */       this.tableModel.addAttribut(att);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void jBTSupprimerActionPerformed(ActionEvent evt)
/*      */   {
/* 1786 */     supprimerSelection();
/*      */   }
/*      */   
/*      */   private void formWindowClosed(java.awt.event.WindowEvent evt) {
/* 1790 */     profondeur -= 1;
/*      */   }
/*      */   
/*      */   private void jBtDictionnaireActionPerformed(ActionEvent evt) {
/* 1794 */     FormeSelectAttribut fatt = new FormeSelectAttribut(this.frm, true);
/* 1795 */     fatt.setVisible(true);
/* 1796 */     if (fatt.getFermer().equals("OK")) {
/* 1797 */       Attribut2 att = (Attribut2)fatt.getAttributSel();
/* 1798 */       if (att != null) {
/* 1799 */         att = corrigerAttribut(att);
/* 1800 */         att = (Attribut2)att.copier();
/*      */         
/* 1802 */         if ((this.entite instanceof IhmEntite2)) {
/* 1803 */           att.setEntiteRelation(((IhmEntite2)this.entite).getEntite());
/*      */         }
/* 1805 */         if ((this.entite instanceof IhmRelation2)) {
/* 1806 */           att.setEntiteRelation(((IhmRelation2)this.entite).getRelation());
/*      */         }
/* 1808 */         if (existeAttributDansListe(att) == null) {
/* 1809 */           this.listeAttribut.add(att);
/* 1810 */           this.tableModel.addAttribut(att);
/* 1811 */           this.tabR.setListeAttribut(this.listeAttribut);
/* 1812 */           miseAjourListe();
/*      */         }
/*      */         else {
/* 1815 */           JOptionPane.showMessageDialog(this, "Cet attribut existe déjà dans la liste des attributs", "Erreur", 0);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void jBtImporterAttributActionPerformed(ActionEvent evt)
/*      */   {
/* 1823 */     FormeImporterAttribut f = new FormeImporterAttribut(this.frm, this.listeAttribut, true);
/* 1824 */     f.setVisible(true);
/*      */     
/* 1826 */     if (f.isModifier()) {
/* 1827 */       ArrayList<Attribut> listeAtt = f.getListAttribut();
/* 1828 */       listeAtt = corrigerAttributs(listeAtt);
/* 1829 */       affectationReferenceAttribut(listeAtt);
/* 1830 */       this.listeAttribut = listeAtt;
/* 1831 */       this.tableModel.setListeAttribut(this.listeAttribut);
/*      */       
/* 1833 */       this.tabR.setListeAttribut(this.listeAttribut);
/* 1834 */       miseAjourListe();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jLabClNomMouseClicked(MouseEvent evt)
/*      */   {
/* 1840 */     this.jLabClNom.setBackground(choixDeCouleur(this.jLabClNom.getBackground(), "Couleur Nom Attribut"));
/* 1841 */     this.attribut.setClNom(getColor(this.jLabClNom.getBackground()));
/*      */   }
/*      */   
/*      */ 
/*      */   private void jLabClTypeKeyPressed(KeyEvent evt) {}
/*      */   
/*      */   private void jLabClTypeMouseClicked(MouseEvent evt)
/*      */   {
/* 1849 */     this.jLabClType.setBackground(choixDeCouleur(this.jLabClType.getBackground(), "Couleur type Attribut"));
/* 1850 */     this.attribut.setClType(getColor(this.jLabClType.getBackground()));
/*      */   }
/*      */   
/*      */   private void jLabClTailleMouseClicked(MouseEvent evt) {
/* 1854 */     this.jLabClTaille.setBackground(choixDeCouleur(this.jLabClTaille.getBackground(), "Couleur taille Attribut"));
/* 1855 */     this.attribut.setClTaille(getColor(this.jLabClTaille.getBackground()));
/*      */   }
/*      */   
/*      */   private void jLabClTailleDecMouseClicked(MouseEvent evt) {
/* 1859 */     this.jLabClTailleDec.setBackground(choixDeCouleur(this.jLabClTailleDec.getBackground(), "Couleur taille Attribut"));
/* 1860 */     this.attribut.setClTailleDecimale(getColor(this.jLabClTailleDec.getBackground()));
/*      */   }
/*      */   
/*      */   private void jLbTailleDecMouseClicked(MouseEvent evt) {
/* 1864 */     this.jLabClTailleDec.setBackground(this.jLabClTaille.getBackground());
/* 1865 */     this.attribut.setClTailleDecimale(getColor(this.jLabClTailleDec.getBackground()));
/*      */   }
/*      */   
/*      */   private void jLbNomMouseClicked(MouseEvent evt) {
/* 1869 */     this.jLabClNom.setBackground(this.jLabClType.getBackground());
/* 1870 */     this.attribut.setClNom(getColor(this.jLabClNom.getBackground()));
/*      */   }
/*      */   
/*      */   private void jLbTypeMouseClicked(MouseEvent evt) {
/* 1874 */     this.jLabClType.setBackground(this.jLabClNom.getBackground());
/* 1875 */     this.attribut.setClType(getColor(this.jLabClType.getBackground()));
/*      */   }
/*      */   
/*      */   private void jLbTailleMouseClicked(MouseEvent evt) {
/* 1879 */     this.jLabClTaille.setBackground(this.jLabClType.getBackground());
/* 1880 */     this.attribut.setClTaille(getColor(this.jLabClTaille.getBackground()));
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeProprieteAttribut2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */