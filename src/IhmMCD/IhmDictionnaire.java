/*     */ package IhmMCD;
/*     */ 
/*     */ import Merise.Attribut;
/*     */ import Merise.Entite;
/*     */ import Merise.Relation;
/*     */ import ihm.Principale;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.table.TableColumn;
/*     */ import javax.swing.table.TableColumnModel;
/*     */ 
/*     */ public class IhmDictionnaire extends javax.swing.JDialog
/*     */ {
/*     */   private ArrayList<Attribut> listeAttribut;
/*     */   private Attribut attributSel;
/*     */   private Boolean creer;
/*  30 */   private javax.swing.table.DefaultTableModel dm = new javax.swing.table.DefaultTableModel();
/*     */   private Principale frm;
/*     */   private JButton jBtImporter;
/*     */   
/*     */   public IhmDictionnaire(Principale frm, boolean modal, ArrayList<Attribut> listeAttribut) {
/*  35 */     super(frm, modal);
/*  36 */     initComponents();
/*  37 */     this.frm = frm;
/*  38 */     this.attributSel = null;
/*  39 */     setLocation(frm.getX() + 250, frm.getY() + 100);
/*  40 */     this.listeAttribut = listeAttribut;
/*  41 */     afficherListeAttribut();
/*  42 */     remplirType();
/*  43 */     this.creer = Boolean.valueOf(false);
/*     */   }
/*     */   
/*     */   private JButton jBtModifier;
/*     */   private JButton jBtSupprimer;
/*  48 */   private void remplirType() { this.jCBType.removeAllItems();
/*  49 */     this.jCBType.addItem("");
/*  50 */     for (int i = 0; i < this.frm.getPage().getListeDomaine().size(); i++) {
/*  51 */       this.jCBType.addItem(((Merise.Domaine)this.frm.getPage().getListeDomaine().get(i)).getNom());
/*     */     }
/*  53 */     if (this.frm.getPage().getListeDomaine().size() > 0) this.jCBType.addItem("");
/*  54 */     for (int i = 0; i < Outil.Parametres.DomaineDefini.length; i++) {
/*  55 */       if ((!Outil.Parametres.DomaineDefini[i].toUpperCase().equals("ENUM")) && (!Outil.Parametres.DomaineDefini[i].toUpperCase().equals("SET")))
/*  56 */         this.jCBType.addItem(Outil.Parametres.DomaineDefini[i]);
/*     */     }
/*     */   }
/*     */   
/*     */   private void afficherListeAttribut() {
/*  61 */     Object[][] ob = new Object[this.listeAttribut.size()][2];
/*  62 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/*  63 */       ob[i][0] = ((Attribut)this.listeAttribut.get(i)).getNom();
/*  64 */       ob[i][1] = ((Attribut)this.listeAttribut.get(i)).getType();
/*     */     }
/*     */     
/*  67 */     Object[] col = { "Nom", "Type" };
/*  68 */     this.jTable1.setModel(new javax.swing.table.DefaultTableModel(ob, col));
/*     */   }
/*     */   
/*     */   private int existeAttribut(String nom, String type) {
/*  72 */     for (int i = 0; i < this.listeAttribut.size(); i++) {
/*  73 */       if ((((Attribut)this.listeAttribut.get(i)).getNom().toUpperCase().equals(nom.toUpperCase())) && (((Attribut)this.listeAttribut.get(i)).getType().toUpperCase().equals(type.toUpperCase())))
/*  74 */         return i;
/*     */     }
/*  76 */     return -1;
/*     */   }
/*     */   
/*     */   private void indexerJCBox(Attribut att) {
/*  80 */     int j = -1;int tail = this.jCBType.getModel().getSize();
/*     */     
/*  82 */     for (int i = 0; i < tail; i++) {
/*  83 */       this.jCBType.setSelectedIndex(i);
/*  84 */       String typ = (String)this.jCBType.getSelectedItem();
/*  85 */       if (att.getType().trim().toUpperCase().equals(typ.trim().toUpperCase())) {
/*  86 */         j = i;
/*  87 */         break;
/*     */       }
/*     */     }
/*  90 */     this.jCBType.setSelectedIndex(j);
/*     */   }
/*     */   
/*     */   private boolean isEntier(String nb) {
/*  94 */     if (nb.trim().length() == 0) return true;
/*     */     try {
/*  96 */       Integer.parseInt(nb);
/*     */     } catch (Exception ex) {
/*  98 */       return false;
/*     */     }
/* 100 */     return true;
/*     */   }
/*     */   
/*     */   private int retournerEntier(String nb) {
/* 104 */     if (nb.trim().length() == 0) return 0;
/* 105 */     if (isEntier(nb)) return Integer.parseInt(nb);
/* 106 */     return 0;
/*     */   }
/*     */   
/*     */   private String verifierSaisie() {
/* 110 */     if (this.jTFNom.getText().trim().length() == 0) return "Nom ne doit pas être vide ";
/* 111 */     if (this.jCBType.getSelectedIndex() == 0) return "Aucun type n'a été désigné ";
/* 112 */     if (!estEntier(this.jTFTaille.getText().trim())) return "La longueur n'est pas un entier";
/* 113 */     if (!estEntier(this.jTFDecimal.getText().trim())) { return "La longueur décimale n'est pas un entier";
/*     */     }
/* 115 */     return "";
/*     */   }
/*     */   
/*     */   private boolean estEntier(String ent) {
/* 119 */     if (ent.trim().length() == 0) return true;
/*     */     try {
/* 121 */       Integer.parseInt(ent);
/* 122 */       return true;
/*     */     } catch (Exception e) {}
/* 124 */     return false;
/*     */   }
/*     */   
/*     */   public void raffraichirDico()
/*     */   {
/* 129 */     for (int i = 0; i < this.frm.getPage().getListeEntiteRelation().size(); i++) {
/* 130 */       if (((IhmEntiteRelation)this.frm.getPage().getListeEntiteRelation().get(i)).getClass().getName().equals("IhmMCD.IhmEntite")) {
/* 131 */         for (int j = 0; j < ((IhmEntite)this.frm.getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().size(); j++) {
/* 132 */           this.frm.getPage().ajouterAttribut(((Attribut)((IhmEntite)this.frm.getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getNom(), ((Attribut)((IhmEntite)this.frm.getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getType(), ((Attribut)((IhmEntite)this.frm.getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getLongueur(), ((Attribut)((IhmEntite)this.frm.getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getLongDecimale());
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 138 */       if (((IhmEntiteRelation)this.frm.getPage().getListeEntiteRelation().get(i)).getClass().getName().equals("IhmMCD.IhmRelation"))
/* 139 */         for (int j = 0; j < ((IhmRelation)this.frm.getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().size(); j++)
/* 140 */           this.frm.getPage().ajouterAttribut(((Attribut)((IhmRelation)this.frm.getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getNom(), ((Attribut)((IhmRelation)this.frm.getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getType(), ((Attribut)((IhmRelation)this.frm.getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getLongueur(), ((Attribut)((IhmRelation)this.frm.getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getLongDecimale());
/*     */     }
/*     */   }
/*     */   
/*     */   private JButton jBtnouveau;
/*     */   private JButton jButton4;
/*     */   private JComboBox jCBType;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private javax.swing.JScrollPane jScrollPane2;
/*     */   private JTextField jTFDecimal;
/*     */   private JTextField jTFNom;
/*     */   private JTextField jTFTaille;
/*     */   private JTable jTable1;
/* 159 */   private void initComponents() { this.jPanel1 = new JPanel();
/* 160 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/* 161 */     this.jTable1 = new JTable();
/* 162 */     this.jLabel1 = new JLabel();
/* 163 */     this.jPanel2 = new JPanel();
/* 164 */     this.jLabel2 = new JLabel();
/* 165 */     this.jTFNom = new JTextField();
/* 166 */     this.jLabel3 = new JLabel();
/* 167 */     this.jCBType = new JComboBox();
/* 168 */     this.jTFTaille = new JTextField();
/* 169 */     this.jLabel4 = new JLabel();
/* 170 */     this.jLabel5 = new JLabel();
/* 171 */     this.jTFDecimal = new JTextField();
/* 172 */     this.jBtnouveau = new JButton();
/* 173 */     this.jBtSupprimer = new JButton();
/* 174 */     this.jBtModifier = new JButton();
/* 175 */     this.jBtImporter = new JButton();
/* 176 */     this.jButton4 = new JButton();
/*     */     
/* 178 */     setDefaultCloseOperation(2);
/* 179 */     setTitle("Dictionnaire de données");
/* 180 */     setResizable(false);
/*     */     
/* 182 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/*     */     
/* 184 */     this.jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[0][], new String[] { "Nom", "Type", "Taille" })
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 192 */       Class[] types = { String.class, String.class, String.class };
/*     */       
/*     */ 
/* 195 */       boolean[] canEdit = { false, false, false };
/*     */       
/*     */ 
/*     */       public Class getColumnClass(int columnIndex)
/*     */       {
/* 200 */         return this.types[columnIndex];
/*     */       }
/*     */       
/*     */       public boolean isCellEditable(int rowIndex, int columnIndex) {
/* 204 */         return this.canEdit[columnIndex];
/*     */       }
/* 206 */     });
/* 207 */     this.jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 209 */         IhmDictionnaire.this.jTable1MouseClicked(evt);
/*     */       }
/* 211 */     });
/* 212 */     this.jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyReleased(java.awt.event.KeyEvent evt) {
/* 214 */         IhmDictionnaire.this.jTable1KeyReleased(evt);
/*     */       }
/* 216 */     });
/* 217 */     this.jScrollPane2.setViewportView(this.jTable1);
/* 218 */     this.jTable1.getColumnModel().getColumn(1).setMinWidth(100);
/* 219 */     this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
/* 220 */     this.jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
/* 221 */     this.jTable1.getColumnModel().getColumn(2).setMinWidth(50);
/* 222 */     this.jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
/* 223 */     this.jTable1.getColumnModel().getColumn(2).setMaxWidth(50);
/*     */     
/* 225 */     this.jLabel1.setText("Liste des attributs : ");
/*     */     
/* 227 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 228 */     this.jPanel1.setLayout(jPanel1Layout);
/* 229 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane2, -1, 672, 32767).addComponent(this.jLabel1)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 238 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -1, 248, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 248 */     this.jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
/* 249 */     this.jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 251 */         IhmDictionnaire.this.jPanel2MouseClicked(evt);
/*     */       }
/*     */       
/* 254 */     });
/* 255 */     this.jLabel2.setText("Nom :");
/*     */     
/* 257 */     this.jLabel3.setText("Type :");
/*     */     
/* 259 */     this.jCBType.setFont(new java.awt.Font("Tahoma", 1, 11));
/* 260 */     this.jCBType.setForeground(new java.awt.Color(0, 0, 153));
/* 261 */     this.jCBType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Auto_increment", "Blob", "Bool", "Char", "Date", "Datetime", "Decimal", "Double", "Double Precision", "Enum", "Float", "Int", "Integer", "Longblob", "Longtext", "Mediumblob", "Mediumint", "Mediumtext", "Numeric", "Real", "Set", "Smallint", "Text", "Time", "TimeStamp", "TinyBlob", "TinyINT", "TinyText", "Varchar", "Year" }));
/*     */     
/* 263 */     this.jLabel4.setText("Taille");
/*     */     
/* 265 */     this.jLabel5.setText("Decimal :");
/*     */     
/* 267 */     this.jBtnouveau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Ajouter.png")));
/* 268 */     this.jBtnouveau.setText("Créer");
/* 269 */     this.jBtnouveau.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 271 */         IhmDictionnaire.this.jBtnouveauActionPerformed(evt);
/*     */       }
/*     */       
/* 274 */     });
/* 275 */     this.jBtSupprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/supprimer.png")));
/* 276 */     this.jBtSupprimer.setText("Supprimer");
/* 277 */     this.jBtSupprimer.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 279 */         IhmDictionnaire.this.jBtSupprimerActionPerformed(evt);
/*     */       }
/*     */       
/* 282 */     });
/* 283 */     this.jBtModifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/modifier.png")));
/* 284 */     this.jBtModifier.setText("Modifier");
/* 285 */     this.jBtModifier.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 287 */         IhmDictionnaire.this.jBtModifierActionPerformed(evt);
/*     */       }
/*     */       
/* 290 */     });
/* 291 */     this.jBtImporter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/importer.png")));
/* 292 */     this.jBtImporter.setText("Actualiser");
/* 293 */     this.jBtImporter.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 295 */         IhmDictionnaire.this.jBtImporterActionPerformed(evt);
/*     */       }
/*     */       
/* 298 */     });
/* 299 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 300 */     this.jPanel2.setLayout(jPanel2Layout);
/* 301 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel2, -2, 48, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTFNom, -2, 194, -2)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel4, -2, 56, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTFTaille, -2, 56, -2).addGap(18, 18, 18).addComponent(this.jLabel5, -2, 58, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTFDecimal, -2, 71, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel3, -2, 47, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCBType, -2, 192, -2).addGap(57, 57, 57)).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jBtImporter, -2, 128, -2).addGap(18, 18, 18))).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jBtnouveau, -1, -1, 32767).addComponent(this.jBtModifier, -1, -1, 32767).addComponent(this.jBtSupprimer, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
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
/* 334 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTFNom, -2, -1, -2).addComponent(this.jCBType, -2, -1, -2).addComponent(this.jLabel3).addComponent(this.jBtnouveau)).addGap(6, 6, 6).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jTFTaille, -2, -1, -2).addComponent(this.jLabel5).addComponent(this.jTFDecimal, -2, -1, -2)).addGap(46, 46, 46)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(45, 32767).addComponent(this.jBtModifier).addGap(11, 11, 11).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtSupprimer).addComponent(this.jBtImporter)).addContainerGap()));
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
/* 361 */     this.jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/* 362 */     this.jButton4.setText("Fermer");
/* 363 */     this.jButton4.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 365 */         IhmDictionnaire.this.jButton4ActionPerformed(evt);
/*     */       }
/*     */       
/* 368 */     });
/* 369 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 370 */     getContentPane().setLayout(layout);
/* 371 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel1, -1, -1, 32767).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton4, -2, 106, -2).addGap(23, 23, 23)))));
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
/* 385 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton4).addContainerGap(-1, 32767)));
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
/* 397 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton4ActionPerformed(ActionEvent evt)
/*     */   {
/* 402 */     dispose();
/*     */   }
/*     */   
/*     */   private void jBtnouveauActionPerformed(ActionEvent evt) {
/* 406 */     new formes.FormeAjouterAttribut(this.frm, true, this.listeAttribut).setVisible(true);
/* 407 */     afficherListeAttribut();
/* 408 */     this.attributSel = null;
/* 409 */     this.jTFNom.setText("");
/* 410 */     this.jTFTaille.setText("");
/* 411 */     this.jTFDecimal.setText("");
/* 412 */     this.jCBType.setSelectedIndex(0);
/* 413 */     this.frm.getFormeMCD().setModifier(true);
/*     */   }
/*     */   
/*     */   private void jTable1KeyReleased(java.awt.event.KeyEvent evt)
/*     */   {
/* 418 */     if (this.jTable1.getSelectedRow() != -1) {
/* 419 */       int j = existeAttribut((String)this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0), (String)this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1));
/* 420 */       this.jTFNom.setText(((Attribut)this.listeAttribut.get(j)).getNom());
/* 421 */       this.jTFTaille.setText("" + ((Attribut)this.listeAttribut.get(j)).getLongueur());
/* 422 */       this.jTFDecimal.setText("" + ((Attribut)this.listeAttribut.get(j)).getLongDecimale());
/* 423 */       indexerJCBox((Attribut)this.listeAttribut.get(j));
/* 424 */       this.attributSel = ((Attribut)this.listeAttribut.get(j));
/*     */     }
/*     */   }
/*     */   
/*     */   private void jPanel2MouseClicked(MouseEvent evt) {
/* 429 */     if ((this.creer.booleanValue()) && 
/* 430 */       (JOptionPane.showConfirmDialog(this, "Voulez vous quitter la creation d'un nouvel attribut ?", "Ajouetr Attribut", 0) == 0))
/*     */     {
/* 432 */       this.jBtnouveau.setText("Nouveau");
/* 433 */       this.jBtSupprimer.setEnabled(true);
/* 434 */       this.creer = Boolean.valueOf(false);
/* 435 */       if (this.jTable1.getSelectedRow() != -1) {
/* 436 */         int j = existeAttribut((String)this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0), (String)this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1));
/* 437 */         this.jTFNom.setText(((Attribut)this.listeAttribut.get(j)).getNom());
/* 438 */         this.jTFTaille.setText("" + ((Attribut)this.listeAttribut.get(j)).getLongueur());
/* 439 */         this.jTFDecimal.setText("" + ((Attribut)this.listeAttribut.get(j)).getLongDecimale());
/* 440 */         indexerJCBox((Attribut)this.listeAttribut.get(j));
/* 441 */         this.attributSel = ((Attribut)this.listeAttribut.get(j));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void jTable1MouseClicked(MouseEvent evt)
/*     */   {
/* 448 */     if (this.creer.booleanValue()) {
/* 449 */       if (JOptionPane.showConfirmDialog(this, "Voulez vous quitter la creation d'un nouvel attribut ?", "Ajouetr Attribut", 0) == 0)
/*     */       {
/* 451 */         this.jBtnouveau.setText("Nouveau");
/* 452 */         this.jBtSupprimer.setEnabled(true);
/* 453 */         this.creer = Boolean.valueOf(false);
/* 454 */         if (this.jTable1.getSelectedRow() != -1) {
/* 455 */           int j = existeAttribut((String)this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0), (String)this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1));
/* 456 */           this.jTFNom.setText(((Attribut)this.listeAttribut.get(j)).getNom());
/* 457 */           this.jTFTaille.setText("" + ((Attribut)this.listeAttribut.get(j)).getLongueur());
/* 458 */           this.jTFDecimal.setText("" + ((Attribut)this.listeAttribut.get(j)).getLongDecimale());
/* 459 */           indexerJCBox((Attribut)this.listeAttribut.get(j));
/* 460 */           this.attributSel = ((Attribut)this.listeAttribut.get(j));
/*     */         }
/*     */         
/*     */       }
/*     */     }
/* 465 */     else if (this.jTable1.getSelectedRow() != -1) {
/* 466 */       int j = existeAttribut((String)this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 0), (String)this.jTable1.getValueAt(this.jTable1.getSelectedRow(), 1));
/* 467 */       this.jTFNom.setText(((Attribut)this.listeAttribut.get(j)).getNom());
/* 468 */       this.jTFTaille.setText("" + ((Attribut)this.listeAttribut.get(j)).getLongueur());
/* 469 */       this.jTFDecimal.setText("" + ((Attribut)this.listeAttribut.get(j)).getLongDecimale());
/* 470 */       indexerJCBox((Attribut)this.listeAttribut.get(j));
/* 471 */       this.attributSel = ((Attribut)this.listeAttribut.get(j));
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBtModifierActionPerformed(ActionEvent evt)
/*     */   {
/* 477 */     if (this.attributSel != null) {
/* 478 */       String err = verifierSaisie();
/* 479 */       if (err.length() == 0) {
/* 480 */         this.attributSel.setNom(this.jTFNom.getText().trim());
/* 481 */         this.attributSel.setType(((String)this.jCBType.getSelectedItem()).trim());
/* 482 */         this.attributSel.setLongueur(Integer.parseInt(this.jTFTaille.getText()));
/* 483 */         this.attributSel.setLongDecimale(Integer.parseInt(this.jTFDecimal.getText()));
/* 484 */         JOptionPane.showMessageDialog(this, "L'attribut a été modifié modifications ");
/* 485 */         afficherListeAttribut();
/* 486 */         this.jTFNom.setText("");
/* 487 */         this.jTFDecimal.setText("");
/* 488 */         this.jTFTaille.setText("");
/* 489 */         this.jCBType.setSelectedIndex(0);
/* 490 */         this.frm.getFormeMCD().setModifier(true);
/*     */       }
/*     */       else {
/* 493 */         JOptionPane.showMessageDialog(this, "Erreur : " + err);
/*     */       }
/*     */     } else {
/* 496 */       JOptionPane.showMessageDialog(this, "Aucun attribut n'est selectionné !! ");
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBtSupprimerActionPerformed(ActionEvent evt) {
/* 501 */     if (this.attributSel != null) {
/* 502 */       if (JOptionPane.showConfirmDialog(this, "Voulez vous supprimer l'attribut ?", "Supprimer Attribut", 0) == 0)
/*     */       {
/* 504 */         this.listeAttribut.remove(this.attributSel);
/* 505 */         afficherListeAttribut();
/* 506 */         this.jTFNom.setText("");
/* 507 */         this.jTFDecimal.setText("");
/* 508 */         this.jTFTaille.setText("");
/* 509 */         this.jCBType.setSelectedIndex(0);
/* 510 */         this.frm.getFormeMCD().setModifier(true);
/* 511 */         this.attributSel = null;
/*     */       }
/*     */     } else {
/* 514 */       JOptionPane.showMessageDialog(this, "Aucun attribut n'est selectionné !! ");
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBtImporterActionPerformed(ActionEvent evt) {
/* 519 */     for (int i = 0; i < this.frm.getPage().getListeEntiteRelation().size(); i++) {
/* 520 */       if (((IhmEntiteRelation)this.frm.getPage().getListeEntiteRelation().get(i)).getClass().getName().equals("IhmMCD.IhmEntite")) {
/* 521 */         for (int j = 0; j < ((IhmEntite)this.frm.getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().size(); j++) {
/* 522 */           this.frm.getPage().ajouterAttribut(((Attribut)((IhmEntite)this.frm.getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getNom(), ((Attribut)((IhmEntite)this.frm.getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getType(), ((Attribut)((IhmEntite)this.frm.getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getLongueur(), ((Attribut)((IhmEntite)this.frm.getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getLongDecimale());
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 528 */       if (((IhmEntiteRelation)this.frm.getPage().getListeEntiteRelation().get(i)).getClass().getName().equals("IhmMCD.IhmRelation")) {
/* 529 */         for (int j = 0; j < ((IhmRelation)this.frm.getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().size(); j++) {
/* 530 */           this.frm.getPage().ajouterAttribut(((Attribut)((IhmRelation)this.frm.getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getNom(), ((Attribut)((IhmRelation)this.frm.getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getType(), ((Attribut)((IhmRelation)this.frm.getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getLongueur(), ((Attribut)((IhmRelation)this.frm.getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getLongDecimale());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 537 */     this.frm.getFormeMCD().setModifier(true);
/* 538 */     afficherListeAttribut();
/* 539 */     this.jTFNom.setText("");
/* 540 */     this.jTFDecimal.setText("");
/* 541 */     this.jTFTaille.setText("");
/* 542 */     this.jCBType.setSelectedIndex(0);
/* 543 */     this.attributSel = null;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmDictionnaire.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */