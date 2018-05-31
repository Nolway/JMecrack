/*     */ package formes2;
/*     */ 
/*     */ import IhmMCD.IhmEntite;
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD.IhmRelation;
/*     */ import MenuPop.MenuPopTableProprieteDico;
/*     */ import Merise.Attribut;
/*     */ import Merise.Domaine;
/*     */ import Merise.Relation;
/*     */ import Merise2.Attribut2;
/*     */ import ihm.Principale;
/*     */ import java.awt.Color;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.DefaultCellEditor;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.table.DefaultTableModel;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableColumnModel;
/*     */ 
/*     */ public class FormeDictionnaireDeDonnees2 extends JDialog
/*     */ {
/*     */   Principale frm;
/*  43 */   static int longVarchar = 50;
/*  44 */   static int longChar = 5;
/*     */   MenuPopTableProprieteDico menuPop;
/*     */   ArrayList<Attribut> listeAttribut;
/*     */   ProprieteEntiteTableModelDico tableModel;
/*     */   
/*     */   public FormeDictionnaireDeDonnees2(java.awt.Frame parent, boolean modal, ArrayList<Attribut> listeAttribut)
/*     */   {
/*  51 */     super(parent, modal);
/*  52 */     initComponents();
/*  53 */     this.listeAttribut = copierListeAttrbut(listeAttribut);
/*  54 */     initialiserLatable();
/*  55 */     this.jBtAnnuler.setMnemonic(65);
/*  56 */     this.jBtValider.setMnemonic(10); }
/*     */   
/*     */   private JButton jBTAjouter;
/*     */   private JButton jBTDescendre;
/*     */   private JButton jBTRemonter;
/*  61 */   public FormeDictionnaireDeDonnees2(Principale parent, boolean modal, ArrayList<Attribut> listeAttribut) { super(parent, modal);
/*  62 */     initComponents();
/*  63 */     this.frm = parent;
/*  64 */     this.listeAttribut = copierListeAttrbut(listeAttribut);
/*  65 */     initialiserLatable();
/*  66 */     setLocation(this.frm.getX() + 200, this.frm.getY() + 20);
/*  67 */     this.menuPop = new MenuPopTableProprieteDico(this);
/*     */     
/*  69 */     this.jTableAttribut.setComponentPopupMenu(this.menuPop);
/*     */     
/*  71 */     this.jTableAttribut.setComponentPopupMenu(this.menuPop);
/*  72 */     this.jBtAnnuler.setMnemonic(65);
/*  73 */     this.jBtValider.setMnemonic(10);
/*     */   }
/*     */   
/*     */   private JComboBox remplirType() {
/*  77 */     JComboBox comboBox = new JComboBox();
/*     */     
/*  79 */     comboBox.addItem("");
/*  80 */     for (int i = 0; i < this.frm.getPage().getListeDomaine().size(); i++) {
/*  81 */       comboBox.addItem(((Domaine)this.frm.getPage().getListeDomaine().get(i)).getNom());
/*     */     }
/*  83 */     if (this.frm.getPage().getListeDomaine().size() > 0) comboBox.addItem("");
/*  84 */     for (int i = 0; i < Outil.Parametres.DomaineDefini.length; i++) {
/*  85 */       if ((!Outil.Parametres.DomaineDefini[i].toUpperCase().equals("ENUM")) && (!Outil.Parametres.DomaineDefini[i].toUpperCase().equals("SET")))
/*  86 */         comboBox.addItem(Outil.Parametres.DomaineDefini[i]);
/*     */     }
/*  88 */     return comboBox;
/*     */   }
/*     */   
/*     */   private void initialiserLatable()
/*     */   {
/*  93 */     JComboBox comboBoxType = remplirType();
/*  94 */     JTextField jtf = new JTextField();
/*  95 */     jtf.setFont(new java.awt.Font("Tahoma", 1, 14));
/*  96 */     jtf.setBackground(Color.yellow);
/*     */     
/*     */ 
/*  99 */     this.tableModel = new ProprieteEntiteTableModelDico(this.listeAttribut);
/* 100 */     this.jTableAttribut.setModel(this.tableModel);
/*     */     
/* 102 */     this.jTableAttribut.getColumnModel().getColumn(0).setCellEditor(new ProprieteBoutonCellEditor(this.listeAttribut, this.frm, new Object(), null));
/*     */     
/* 104 */     this.jTableAttribut.getColumnModel().getColumn(0).setPreferredWidth(32);
/* 105 */     this.jTableAttribut.getColumnModel().getColumn(1).setPreferredWidth(250);
/* 106 */     this.jTableAttribut.getColumnModel().getColumn(2).setPreferredWidth(200);
/* 107 */     this.jTableAttribut.getColumnModel().getColumn(3).setPreferredWidth(150);
/* 108 */     this.jTableAttribut.getColumnModel().getColumn(4).setPreferredWidth(30);
/* 109 */     this.jTableAttribut.getColumnModel().getColumn(5).setPreferredWidth(30);
/* 110 */     this.jTableAttribut.getColumnModel().getColumn(6).setPreferredWidth(10);
/*     */     
/*     */ 
/* 113 */     this.jTableAttribut.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBoxType));
/* 114 */     this.jTableAttribut.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(jtf));
/* 115 */     this.jTableAttribut.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(jtf));
/* 116 */     JCheckBox cb = new JCheckBox();
/* 117 */     cb.setEnabled(false);
/* 118 */     this.jTableAttribut.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(cb));
/*     */     
/* 120 */     ProprieteEntiteTableRender tabR = new ProprieteEntiteTableRender();
/* 121 */     tabR.setListeAttribut(this.listeAttribut);
/* 122 */     this.jTableAttribut.setDefaultRenderer(Object.class, tabR);
/* 123 */     this.jTableAttribut.setDefaultRenderer(JButton.class, new ProprieteBoutonCellRender());
/* 124 */     this.jTableAttribut.setDefaultRenderer(Boolean.class, new CheckBoxCellRender());
/*     */     
/*     */ 
/*     */ 
/* 128 */     this.jTableAttribut.setRowHeight(30);
/*     */   }
/*     */   
/*     */   public void supprimerSelection() {
/* 132 */     int[] selection = this.jTableAttribut.getSelectedRows();
/* 133 */     for (int i = selection.length - 1; i >= 0; i--) {
/* 134 */       this.tableModel.removeAttribut(selection[i]);
/* 135 */       this.listeAttribut.remove(selection[i]);
/*     */     }
/*     */     
/*     */ 
/* 139 */     if (this.listeAttribut.size() == 0) {
/* 140 */       JComboBox comboBoxType = remplirType();
/* 141 */       JTextField jtf = new JTextField();
/* 142 */       jtf.setFont(new java.awt.Font("Tahoma", 1, 14));
/* 143 */       jtf.setBackground(Color.YELLOW);
/* 144 */       this.jTableAttribut.getColumnModel().getColumn(0).setCellEditor(new ProprieteBoutonCellEditor(this.listeAttribut, this.frm, new Object(), null));
/*     */       
/* 146 */       this.jTableAttribut.getColumnModel().getColumn(0).setPreferredWidth(32);
/* 147 */       this.jTableAttribut.getColumnModel().getColumn(1).setPreferredWidth(250);
/* 148 */       this.jTableAttribut.getColumnModel().getColumn(2).setPreferredWidth(200);
/* 149 */       this.jTableAttribut.getColumnModel().getColumn(3).setPreferredWidth(150);
/* 150 */       this.jTableAttribut.getColumnModel().getColumn(4).setPreferredWidth(30);
/* 151 */       this.jTableAttribut.getColumnModel().getColumn(5).setPreferredWidth(30);
/* 152 */       this.jTableAttribut.getColumnModel().getColumn(6).setPreferredWidth(10);
/*     */       
/*     */ 
/*     */ 
/* 156 */       this.jTableAttribut.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboBoxType));
/* 157 */       this.jTableAttribut.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(jtf));
/* 158 */       this.jTableAttribut.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(jtf));
/* 159 */       JCheckBox cb = new JCheckBox();
/* 160 */       cb.setEnabled(false);
/* 161 */       this.jTableAttribut.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(cb));
/*     */       
/*     */ 
/* 164 */       ProprieteEntiteTableRender tabR = new ProprieteEntiteTableRender();
/* 165 */       tabR.setListeAttribut(this.listeAttribut);
/* 166 */       this.jTableAttribut.setDefaultRenderer(Object.class, tabR);
/* 167 */       this.jTableAttribut.setDefaultRenderer(JButton.class, new ProprieteBoutonCellRender());
/* 168 */       this.jTableAttribut.setDefaultRenderer(Boolean.class, new CheckBoxCellRender());
/*     */     }
/*     */   }
/*     */   
/*     */   private void remonterAttribut(int index) {
/* 173 */     if (index >= 1) {
/* 174 */       Attribut att = (Attribut)this.listeAttribut.get(index - 1);
/* 175 */       this.listeAttribut.remove(index - 1);
/* 176 */       this.tableModel.removeAttribut(index - 1);
/*     */       
/* 178 */       this.listeAttribut.add(index, att);
/* 179 */       this.tableModel.getListeAttribut().add(index, att);
/* 180 */       this.jTableAttribut.repaint();
/* 181 */       this.jTableAttribut.setRowSelectionInterval(index - 1, index - 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private void descendreAttribut(int index)
/*     */   {
/* 187 */     if (index < this.listeAttribut.size() - 1) {
/* 188 */       Attribut att = (Attribut)this.listeAttribut.get(index + 1);
/* 189 */       this.listeAttribut.remove(index + 1);
/* 190 */       this.tableModel.removeAttribut(index + 1);
/*     */       
/* 192 */       this.listeAttribut.add(index, att);
/* 193 */       this.tableModel.getListeAttribut().add(index, att);
/* 194 */       this.jTableAttribut.repaint();
/* 195 */       this.jTableAttribut.setRowSelectionInterval(index + 1, index + 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private ArrayList<Attribut> copierListeAttrbut(ArrayList<Attribut> liste)
/*     */   {
/* 201 */     ArrayList<Attribut> l = new ArrayList();
/*     */     
/* 203 */     for (int i = 0; i < liste.size(); i++) {
/* 204 */       Attribut2 att = (Attribut2)((Attribut)liste.get(i)).copier();
/* 205 */       att.setUsed(false);
/* 206 */       l.add(att);
/*     */     }
/* 208 */     return l;
/*     */   }
/*     */   
/*     */   private Attribut2 existeAttribut(Attribut2 att) {
/* 212 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/* 213 */       if ((this.listeAttribut.get(i) != att) && 
/* 214 */         (att.getNom().trim().toUpperCase().equals(((Attribut)this.listeAttribut.get(i)).getNom().trim().toUpperCase())) && (att.getType().trim().toUpperCase().equals(((Attribut)this.listeAttribut.get(i)).getType().trim().toUpperCase())))
/*     */       {
/* 216 */         return (Attribut2)this.listeAttribut.get(i);
/*     */       }
/*     */     }
/*     */     
/* 220 */     return null;
/*     */   }
/*     */   
/*     */   private Attribut2 existeAttribut(Attribut2 att, int nb) {
/* 224 */     for (int i = nb; i < this.listeAttribut.size(); i++) {
/* 225 */       if ((this.listeAttribut.get(i) != att) && 
/* 226 */         (att.getNom().trim().toUpperCase().equals(((Attribut)this.listeAttribut.get(i)).getNom().trim().toUpperCase())) && (att.getType().trim().toUpperCase().equals(((Attribut)this.listeAttribut.get(i)).getType().trim().toUpperCase())))
/*     */       {
/* 228 */         return (Attribut2)this.listeAttribut.get(i);
/*     */       }
/*     */     }
/*     */     
/* 232 */     return null;
/*     */   }
/*     */   
/*     */   private Attribut2 existeCodeAttribut(Attribut2 att)
/*     */   {
/* 237 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/* 238 */       if (this.listeAttribut.get(i) != att) {
/* 239 */         String code = ((Attribut2)this.listeAttribut.get(i)).getCode().trim().toUpperCase();
/* 240 */         if (att.getCode().trim().toUpperCase().equals(code)) {
/* 241 */           return (Attribut2)this.listeAttribut.get(i);
/*     */         }
/*     */       }
/*     */     }
/* 245 */     return null;
/*     */   }
/*     */   
/*     */   private Attribut2 existeCodeAttribut(Attribut2 att, int nb)
/*     */   {
/* 250 */     for (int i = nb; i < this.listeAttribut.size(); i++) {
/* 251 */       if (this.listeAttribut.get(i) != att) {
/* 252 */         String code = ((Attribut2)this.listeAttribut.get(i)).getCode().trim().toUpperCase();
/* 253 */         if (att.getCode().trim().toUpperCase().equals(code)) {
/* 254 */           return (Attribut2)this.listeAttribut.get(i);
/*     */         }
/*     */       }
/*     */     }
/* 258 */     return null;
/*     */   }
/*     */   
/*     */   private JButton jBTSupprimerAllAtt;
/*     */   private JButton jBtAnnuler;
/*     */   private JButton jBtExporterDico;
/*     */   private JButton jBtPropriete;
/*     */   private JButton jBtSupprimer;
/*     */   private JButton jBtUtilisation;
/* 267 */   private void actualiserDico() { for (int i = 0; i < this.frm.getPage().getListeEntiteRelation().size(); i++) {
/* 268 */       IhmMCD.IhmEntiteRelation entRel = (IhmMCD.IhmEntiteRelation)this.frm.getPage().getListeEntiteRelation().get(i);
/* 269 */       if ((entRel instanceof IhmEntite)) {
/* 270 */         IhmEntite ent = (IhmEntite)entRel;
/* 271 */         int tail = ent.getEntite().getListeAttributs().size();
/* 272 */         for (int j = 0; j < tail; j++) {
/* 273 */           Attribut2 att = (Attribut2)ent.getEntite().getListeAttributs().get(j);
/* 274 */           Attribut2 attTrouve = existeAttribut(att);
/* 275 */           if (attTrouve == null) {
/* 276 */             att = (Attribut2)att.copier();
/* 277 */             att.setKey("");
/* 278 */             att.setHistorisation("");
/* 279 */             att.setUsed(true);
/* 280 */             this.listeAttribut.add(att);
/* 281 */             this.tableModel.addAttribut(att);
/*     */           } else {
/* 283 */             attTrouve.setUsed(true);
/*     */           }
/*     */         }
/*     */       }
/* 287 */       if ((entRel instanceof IhmRelation)) {
/* 288 */         IhmRelation rel = (IhmRelation)entRel;
/* 289 */         int tail = rel.getRelation().getListeAttributs().size();
/* 290 */         for (int j = 0; j < tail; j++) {
/* 291 */           Attribut2 att = (Attribut2)rel.getRelation().getListeAttributs().get(j);
/* 292 */           Attribut2 attTrouve = existeAttribut(att);
/* 293 */           if (attTrouve == null) {
/* 294 */             att = (Attribut2)att.copier();
/* 295 */             att.isUsed();
/* 296 */             this.listeAttribut.add(att);
/* 297 */             this.tableModel.addAttribut(att);
/*     */           } else {
/* 299 */             attTrouve.setUsed(true);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 304 */     this.jTableAttribut.repaint();
/*     */   }
/*     */   
/*     */   private boolean verifierAttribut()
/*     */   {
/* 309 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/* 310 */       Attribut att = existeAttribut((Attribut2)this.listeAttribut.get(i), i + 1);
/* 311 */       if (att != null) {
/* 312 */         JOptionPane.showMessageDialog(this, "La ligne num= " + (i + 1) + "," + att.getNom() + " existe dans la liste au moins deux fois", "Erreur", 0);
/* 313 */         return false;
/*     */       }
/*     */     }
/* 316 */     return true;
/*     */   }
/*     */   
/*     */   private boolean verifierCodeAttribut()
/*     */   {
/* 321 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/* 322 */       Attribut2 att = existeCodeAttribut((Attribut2)this.listeAttribut.get(i), i + 1);
/* 323 */       if (att != null) {
/* 324 */         JOptionPane.showMessageDialog(this, "La ligne num= " + (i + 1) + "," + att.getCode() + " existe dans la liste au moins deux fois", "Erreur", 0);
/* 325 */         return false;
/*     */       }
/*     */     }
/* 328 */     return true;
/*     */   }
/*     */   
/*     */   private boolean verifierSaisieAttribut(Attribut2 att) {
/* 332 */     if (att.getNom().trim().length() == 0) return false;
/* 333 */     if ((att.getType().trim().length() == 0) && 
/* 334 */       (att.getListeAttributs().size() == 0)) { return false;
/*     */     }
/* 336 */     if ((this.jCBVerifierCode.isSelected()) && (att.getCode().trim().length() == 0)) return false;
/* 337 */     return true;
/*     */   }
/*     */   
/*     */   private boolean verifierSaisieAttribut()
/*     */   {
/* 342 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/* 343 */       if (!verifierSaisieAttribut((Attribut2)this.listeAttribut.get(i))) {
/* 344 */         String msg = " La ligne num " + (i + 1) + ", le nom et le type de l'attribut ne doivent pas être vides";
/* 345 */         if (this.jCBVerifierCode.isSelected()) msg = " La ligne num " + (i + 1) + ", le nom, le code et le type de l'attribut ne doivent pas être vides";
/* 346 */         JOptionPane.showMessageDialog(this, msg, "Erreur", 0);
/* 347 */         return false;
/*     */       }
/*     */     }
/* 350 */     return true;
/*     */   }
/*     */   
/*     */   public Principale getFrm() {
/* 354 */     return this.frm;
/*     */   }
/*     */   
/*     */   private JButton jBtValider;
/*     */   private JButton jButton1;
/*     */   private JButton jButton3;
/*     */   private JButton jButton4;
/*     */   private JCheckBox jCBVerifierCode;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel16;
/*     */   private JLabel jLabel21;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JTable jTableAttribut;
/*     */   private JTextField jTextField1;
/* 370 */   public JTable getjTableAttribut() { return this.jTableAttribut; }
/*     */   
/*     */ 
/*     */   public ProprieteEntiteTableModelDico getTableModel() {
/* 374 */     return this.tableModel;
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> getListeAttribut() {
/* 378 */     return this.listeAttribut;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 391 */     this.jPanel1 = new JPanel();
/* 392 */     this.jScrollPane1 = new JScrollPane();
/* 393 */     this.jTableAttribut = new JTable();
/* 394 */     this.jLabel1 = new JLabel();
/* 395 */     this.jTextField1 = new JTextField();
/* 396 */     this.jBtUtilisation = new JButton();
/* 397 */     this.jButton1 = new JButton();
/* 398 */     this.jBtExporterDico = new JButton();
/* 399 */     this.jBTRemonter = new JButton();
/* 400 */     this.jBTDescendre = new JButton();
/* 401 */     this.jBTAjouter = new JButton();
/* 402 */     this.jBtSupprimer = new JButton();
/* 403 */     this.jBtPropriete = new JButton();
/* 404 */     this.jLabel16 = new JLabel();
/* 405 */     this.jLabel21 = new JLabel();
/* 406 */     this.jButton4 = new JButton();
/* 407 */     this.jBTSupprimerAllAtt = new JButton();
/* 408 */     this.jPanel2 = new JPanel();
/* 409 */     this.jBtAnnuler = new JButton();
/* 410 */     this.jBtValider = new JButton();
/* 411 */     this.jCBVerifierCode = new JCheckBox();
/* 412 */     this.jButton3 = new JButton();
/*     */     
/* 414 */     setDefaultCloseOperation(2);
/* 415 */     setTitle("Dictionnaire de données");
/* 416 */     setResizable(false);
/*     */     
/* 418 */     this.jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */     
/* 420 */     this.jTableAttribut.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null } }, new String[] { "Nom", "Code", "type", "taille", "decimale", "utilisé" })
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 431 */       Class[] types = { Object.class, Object.class, Object.class, Object.class, Object.class, Boolean.class };
/*     */       
/*     */ 
/*     */       public Class getColumnClass(int columnIndex)
/*     */       {
/* 436 */         return this.types[columnIndex];
/*     */       }
/* 438 */     });
/* 439 */     this.jTableAttribut.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mousePressed(MouseEvent evt) {
/* 441 */         FormeDictionnaireDeDonnees2.this.jTableAttributMousePressed(evt);
/*     */       }
/* 443 */     });
/* 444 */     this.jTableAttribut.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyPressed(KeyEvent evt) {
/* 446 */         FormeDictionnaireDeDonnees2.this.jTableAttributKeyPressed(evt);
/*     */       }
/*     */       
/* 449 */       public void keyReleased(KeyEvent evt) { FormeDictionnaireDeDonnees2.this.jTableAttributKeyReleased(evt);
/*     */       }
/* 451 */     });
/* 452 */     this.jScrollPane1.setViewportView(this.jTableAttribut);
/* 453 */     this.jTableAttribut.getColumnModel().getColumn(5).setResizable(false);
/*     */     
/* 455 */     this.jLabel1.setText("Filtre");
/*     */     
/* 457 */     this.jTextField1.setEditable(false);
/*     */     
/* 459 */     this.jBtUtilisation.setIcon(new ImageIcon(getClass().getResource("/Images/utilisation.png")));
/* 460 */     this.jBtUtilisation.setText("Utilisation");
/* 461 */     this.jBtUtilisation.setToolTipText("Vérifier l'utilisation des attributs");
/* 462 */     this.jBtUtilisation.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 464 */         FormeDictionnaireDeDonnees2.this.jBtUtilisationActionPerformed(evt);
/*     */       }
/*     */       
/* 467 */     });
/* 468 */     this.jButton1.setText("Importer ");
/* 469 */     this.jButton1.setEnabled(false);
/*     */     
/* 471 */     this.jBtExporterDico.setText("Exporter");
/* 472 */     this.jBtExporterDico.setEnabled(false);
/* 473 */     this.jBtExporterDico.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 475 */         FormeDictionnaireDeDonnees2.this.jBtExporterDicoActionPerformed(evt);
/*     */       }
/*     */       
/* 478 */     });
/* 479 */     this.jBTRemonter.setIcon(new ImageIcon(getClass().getResource("/Images/monter.png")));
/* 480 */     this.jBTRemonter.setToolTipText("Faire remonter un attribut");
/* 481 */     this.jBTRemonter.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 483 */         FormeDictionnaireDeDonnees2.this.jBTRemonterActionPerformed(evt);
/*     */       }
/*     */       
/* 486 */     });
/* 487 */     this.jBTDescendre.setIcon(new ImageIcon(getClass().getResource("/Images/descendre.png")));
/* 488 */     this.jBTDescendre.setToolTipText("Faire descendre un attribut ");
/* 489 */     this.jBTDescendre.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 491 */         FormeDictionnaireDeDonnees2.this.jBTDescendreActionPerformed(evt);
/*     */       }
/*     */       
/* 494 */     });
/* 495 */     this.jBTAjouter.setIcon(new ImageIcon(getClass().getResource("/Images/Ajouter.png")));
/* 496 */     this.jBTAjouter.setToolTipText("Ajouter un attribut");
/* 497 */     this.jBTAjouter.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 499 */         FormeDictionnaireDeDonnees2.this.jBTAjouterActionPerformed(evt);
/*     */       }
/*     */       
/* 502 */     });
/* 503 */     this.jBtSupprimer.setIcon(new ImageIcon(getClass().getResource("/Images/supprimer.png")));
/* 504 */     this.jBtSupprimer.setToolTipText("Supprimer l'attribut");
/* 505 */     this.jBtSupprimer.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 507 */         FormeDictionnaireDeDonnees2.this.jBtSupprimerActionPerformed(evt);
/*     */       }
/*     */       
/* 510 */     });
/* 511 */     this.jBtPropriete.setIcon(new ImageIcon(getClass().getResource("/Images/oeil.png")));
/* 512 */     this.jBtPropriete.setToolTipText("propriétés de l'attribut");
/* 513 */     this.jBtPropriete.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 515 */         FormeDictionnaireDeDonnees2.this.jBtProprieteActionPerformed(evt);
/*     */       }
/*     */       
/* 518 */     });
/* 519 */     this.jLabel16.setBackground(new Color(255, 150, 125));
/* 520 */     this.jLabel16.setText("      ");
/* 521 */     this.jLabel16.setOpaque(true);
/*     */     
/* 523 */     this.jLabel21.setText("Attribut composé");
/*     */     
/* 525 */     this.jButton4.setText(" Attribut utilisé par ...");
/* 526 */     this.jButton4.setToolTipText("Voir les entités ou les relations qui utilisent l'attribut");
/* 527 */     this.jButton4.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 529 */         FormeDictionnaireDeDonnees2.this.jButton4ActionPerformed(evt);
/*     */       }
/*     */       
/* 532 */     });
/* 533 */     this.jBTSupprimerAllAtt.setText("Supprimer Att. non utilisés");
/* 534 */     this.jBTSupprimerAllAtt.setEnabled(false);
/* 535 */     this.jBTSupprimerAllAtt.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 537 */         FormeDictionnaireDeDonnees2.this.jBTSupprimerAllAttActionPerformed(evt);
/*     */       }
/*     */       
/* 540 */     });
/* 541 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 542 */     this.jPanel1.setLayout(jPanel1Layout);
/* 543 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, GroupLayout.Alignment.TRAILING, -1, 809, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jTextField1, -2, 308, -2).addGap(46, 46, 46).addComponent(this.jLabel16, -2, 32, -2).addGap(18, 18, 18).addComponent(this.jLabel21).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 119, 32767).addComponent(this.jBtUtilisation, -2, 162, -2)).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jBtExporterDico, -1, -1, 32767).addComponent(this.jButton1, -1, 124, 32767)).addGap(41, 41, 41).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.jBTSupprimerAllAtt, -1, -1, 32767).addComponent(this.jButton4, -1, -1, 32767)).addGap(95, 95, 95).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jBTRemonter).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 166, 32767).addComponent(this.jBtPropriete, -2, 65, -2).addGap(36, 36, 36)).addComponent(this.jBTDescendre)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jBtSupprimer, -1, 74, 32767).addComponent(this.jBTAjouter, -2, 74, -2)))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 581 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTextField1, -2, 27, -2).addComponent(this.jBtUtilisation).addComponent(this.jLabel16).addComponent(this.jLabel21)).addGap(9, 9, 9).addComponent(this.jScrollPane1, -1, 408, 32767).addGap(11, 11, 11).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jBTAjouter, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jBtPropriete, GroupLayout.Alignment.LEADING, -2, 25, -2)).addGap(8, 8, 8).addComponent(this.jBtSupprimer)).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton4)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtExporterDico).addComponent(this.jBTSupprimerAllAtt))).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.jBTRemonter).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBTDescendre, -2, 25, -2)))).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 617 */     this.jPanel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */     
/* 619 */     this.jBtAnnuler.setIcon(new ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 620 */     this.jBtAnnuler.setText("Annuler");
/* 621 */     this.jBtAnnuler.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 623 */         FormeDictionnaireDeDonnees2.this.jBtAnnulerActionPerformed(evt);
/*     */       }
/*     */       
/* 626 */     });
/* 627 */     this.jBtValider.setIcon(new ImageIcon(getClass().getResource("/Images/OK.png")));
/* 628 */     this.jBtValider.setText("Valider");
/* 629 */     this.jBtValider.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 631 */         FormeDictionnaireDeDonnees2.this.jBtValiderActionPerformed(evt);
/*     */       }
/*     */       
/* 634 */     });
/* 635 */     this.jCBVerifierCode.setText("Vérifier l'unicité des codes des attributs ");
/*     */     
/* 637 */     this.jButton3.setIcon(new ImageIcon(getClass().getResource("/Images/verifier24.png")));
/* 638 */     this.jButton3.setText("Vérifier les attributs");
/* 639 */     this.jButton3.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 641 */         FormeDictionnaireDeDonnees2.this.jButton3ActionPerformed(evt);
/*     */       }
/*     */       
/* 644 */     });
/* 645 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 646 */     this.jPanel2.setLayout(jPanel2Layout);
/* 647 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jCBVerifierCode, -2, 289, -2).addGap(26, 26, 26).addComponent(this.jButton3, -2, 181, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 102, 32767).addComponent(this.jBtAnnuler, -2, 108, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jBtValider, -2, 101, -2).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 660 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(-1, 32767).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtValider).addComponent(this.jBtAnnuler).addComponent(this.jCBVerifierCode).addComponent(this.jButton3, -2, 24, -2)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 672 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 673 */     getContentPane().setLayout(layout);
/* 674 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jPanel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 683 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel2, -2, -1, -2).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 693 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtValiderActionPerformed(ActionEvent evt) {
/* 697 */     if ((verifierSaisieAttribut()) && 
/* 698 */       (verifierAttribut())) {
/* 699 */       if (this.jCBVerifierCode.isSelected()) {
/* 700 */         if (verifierCodeAttribut()) {
/* 701 */           this.frm.getPage().setListeAttribut(this.listeAttribut);
/* 702 */           dispose();
/*     */         }
/*     */       } else {
/* 705 */         this.frm.getPage().setListeAttribut(this.listeAttribut);
/* 706 */         dispose();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBTAjouterActionPerformed(ActionEvent evt)
/*     */   {
/* 713 */     Attribut2 att = new Attribut2("", "", -1, -1, "", false, "", null);
/* 714 */     this.listeAttribut.add(att);
/* 715 */     this.tableModel.addAttribut(att);
/* 716 */     this.jTableAttribut.setRowSelectionInterval(this.listeAttribut.size() - 1, this.listeAttribut.size() - 1);
/*     */   }
/*     */   
/*     */   private void jBtSupprimerActionPerformed(ActionEvent evt)
/*     */   {
/* 721 */     supprimerSelection();
/*     */   }
/*     */   
/*     */   private void jBtProprieteActionPerformed(ActionEvent evt)
/*     */   {
/* 726 */     if (this.jTableAttribut.getSelectedRow() >= 0) {
/* 727 */       new FormeProprieteAttribut2(this.frm, true, (Attribut2)this.listeAttribut.get(this.jTableAttribut.getSelectedRow()), this.listeAttribut, new Object(), true, null).setVisible(true);
/* 728 */       ((Attribut2)this.listeAttribut.get(this.jTableAttribut.getSelectedRow())).setKey("");
/* 729 */       ((Attribut2)this.listeAttribut.get(this.jTableAttribut.getSelectedRow())).setHistorisation("");
/* 730 */       this.jTableAttribut.repaint();
/*     */     } else {
/* 732 */       JOptionPane.showMessageDialog(this, "Info : Aucun attribut n'est sélectionné !!! ");
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBTDescendreActionPerformed(ActionEvent evt) {
/* 737 */     if (this.jTableAttribut.getSelectedRow() < 0) return;
/* 738 */     if (this.jTableAttribut.getSelectedRow() < this.listeAttribut.size() - 1) {
/* 739 */       descendreAttribut(this.jTableAttribut.getSelectedRow());
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBtUtilisationActionPerformed(ActionEvent evt)
/*     */   {
/* 745 */     actualiserDico();
/* 746 */     JOptionPane.showMessageDialog(this, "Info : Le dictionnaire de données est actualisé !!! ");
/* 747 */     this.jBTSupprimerAllAtt.setEnabled(true);
/* 748 */     this.jBtExporterDico.setEnabled(true);
/*     */   }
/*     */   
/*     */   private void jBTRemonterActionPerformed(ActionEvent evt) {
/* 752 */     if (this.jTableAttribut.getSelectedRow() >= 0) {
/* 753 */       remonterAttribut(this.jTableAttribut.getSelectedRow());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void jTableAttributKeyReleased(KeyEvent evt) {}
/*     */   
/*     */ 
/*     */   private void jTableAttributKeyPressed(KeyEvent evt)
/*     */   {
/* 763 */     if ((evt.getKeyCode() == 10) && 
/* 764 */       (this.jTableAttribut.getSelectedRow() == this.jTableAttribut.getRowCount() - 1)) {
/* 765 */       Attribut2 att = new Attribut2("", "", -1, -1, "", false, "", null);
/* 766 */       this.listeAttribut.add(att);
/* 767 */       this.tableModel.addAttribut(att);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void jButton3ActionPerformed(ActionEvent evt)
/*     */   {
/* 774 */     if ((verifierSaisieAttribut()) && 
/* 775 */       (verifierAttribut())) {
/* 776 */       if (this.jCBVerifierCode.isSelected()) {
/* 777 */         if (verifierCodeAttribut()) {
/* 778 */           JOptionPane.showMessageDialog(this, "Info : les noms et les codes des attributs du dictionnaire de données sont corrects !!! ");
/*     */         }
/*     */       } else {
/* 781 */         JOptionPane.showMessageDialog(this, "Info : les noms des attributs du dictionnaire de données sont corrects !!! ");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void jBtAnnulerActionPerformed(ActionEvent evt)
/*     */   {
/* 789 */     dispose();
/*     */   }
/*     */   
/*     */ 
/*     */   private void jTableAttributMousePressed(MouseEvent evt) {}
/*     */   
/*     */   private void jButton4ActionPerformed(ActionEvent evt)
/*     */   {
/* 797 */     int ind = this.jTableAttribut.getSelectedRow();
/* 798 */     if (ind >= 0) {
/* 799 */       Attribut2 att = (Attribut2)this.listeAttribut.get(ind);
/* 800 */       new FormeUtilisationAttribut(this.frm, this.frm.getPage(), att, true).setVisible(true);
/*     */     } else {
/* 802 */       JOptionPane.showMessageDialog(this, "Aucun attribut n'est seléctionné !! ");
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBTSupprimerAllAttActionPerformed(ActionEvent evt) {
/* 807 */     if (JOptionPane.showConfirmDialog(this, "Etes vous sûr de supprimer tous les attributs non utilisés ?", "Suppression", 0) == 0) {
/* 808 */       int nb = this.listeAttribut.size() - 1;
/* 809 */       while (nb >= 0) {
/* 810 */         if (!((Attribut2)this.listeAttribut.get(nb)).isUsed()) {
/* 811 */           this.tableModel.removeAttribut(nb);
/* 812 */           this.listeAttribut.remove(nb);
/*     */         } else {
/* 814 */           nb--;
/*     */         }
/*     */       }
/*     */       
/* 818 */       this.jTableAttribut.repaint();
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBtExporterDicoActionPerformed(ActionEvent evt)
/*     */   {
/* 824 */     Output.FileExport.exporterDictionnaire(this.frm, this.listeAttribut);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeDictionnaireDeDonnees2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */