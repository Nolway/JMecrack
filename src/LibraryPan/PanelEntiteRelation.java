/*     */ package LibraryPan;
/*     */ 
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import Merise.Entite;
/*     */ import Merise.Relation;
/*     */ import Outil.Parametres;
/*     */ import Outil.Setting;
/*     */ import ihm.Principale;
/*     */ import java.awt.Color;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.ItemListener;
/*     */ import java.awt.event.MouseAdapter;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.File;
/*     */ import java.net.URL;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ 
/*     */ public class PanelEntiteRelation extends JPanel
/*     */ {
/*     */   Principale frmMain;
/*     */   ArrayList<Library> libList;
/*     */   Library libSelected;
/*     */   LibraryPanel panDraw;
/*     */   Color couleurSel;
/*     */   String pathLibraries;
/*  43 */   public static int heightModel = 70;
/*     */   private JComboBox jCBLib;
/*     */   
/*     */   public PanelEntiteRelation(Principale frmMain) {
/*  47 */     initComponents();
/*  48 */     this.frmMain = frmMain;
/*  49 */     this.libList = new ArrayList();
/*  50 */     this.libSelected = null;
/*  51 */     this.panDraw = new LibraryPanel(this.libSelected, frmMain);
/*     */     
/*  53 */     this.panDraw.setSize(this.jPanel.getWidth(), this.jPanel.getHeight());
/*  54 */     this.panDraw.setVisible(true);
/*  55 */     this.jPanel.setLayout(new GridLayout());
/*     */     
/*  57 */     JScrollPane sc = new JScrollPane();
/*  58 */     sc.setVisible(true);
/*  59 */     sc.setViewportView(this.panDraw);
/*  60 */     this.jPanel.setAutoscrolls(true);
/*  61 */     this.jPanel.add(sc);
/*  62 */     this.couleurSel = new Color(Integer.parseInt(Setting.couleurLibrairieSel));
/*  63 */     this.jLabLibrairie.setBackground(this.couleurSel);
/*  64 */     this.jLabLibrairie.setOpaque(true);
/*  65 */     insertData();
/*  66 */     this.pathLibraries = getCheminLibrairyMonPoste();
/*     */   }
/*     */   
/*     */   protected void paintComponent(Graphics g)
/*     */   {
/*  71 */     this.panDraw.setPreferredSize(new Dimension(this.jPanel.getWidth() - 25, this.jPanel.getHeight()));
/*  72 */     this.panDraw.setSize(this.jPanel.getWidth() - 25, this.jPanel.getHeight());
/*     */   }
/*     */   
/*     */   private String getCheminLibrairyMonPoste() {
/*  76 */     URL url = getClass().getResource("");
/*  77 */     String ch = url.getPath();
/*  78 */     if (ch.indexOf("JMerise.jar") < 0) {
/*  79 */       JOptionPane.showMessageDialog(this, "ERREUR : Problème N°5.1. JMerise.jar est introuvable ou il a été renommé !! \n Si l'erreur persiste, contactez le responsable de JMerise\n admin@jfreesoft.com ");
/*  80 */       this.frmMain.setDefaultCloseOperation(3);
/*  81 */       this.frmMain.dispose();
/*  82 */       System.exit(0);
/*     */     }
/*  84 */     ch = ch.substring(0, ch.indexOf("JMerise.jar"));
/*  85 */     ch = ch.replace("/", File.separator);
/*  86 */     ch = ch.replace("file:" + File.separator, "");
/*     */     
/*  88 */     ch = ch + "ERLibrary" + File.separator;
/*  89 */     ch = Parametres.corrigerChemin(ch);
/*  90 */     String win = System.getProperty("os.name");
/*     */     
/*  92 */     if (win.trim().toUpperCase().indexOf("WIN") < 0) { ch = File.separator + ch;
/*     */     }
/*  94 */     return ch;
/*     */   }
/*     */   
/*     */ 
/*     */   public Library getSelectedLibrary()
/*     */   {
/* 100 */     return this.libSelected;
/*     */   }
/*     */   
/*     */   public boolean addModel(IhmEntiteRelation mod) {
/* 104 */     this.libSelected.setPath(getPathLibraries());
/* 105 */     boolean rep = this.libSelected.addModel(mod);
/* 106 */     if (rep) {
/* 107 */       this.panDraw.repaint();
/*     */     }
/* 109 */     return rep;
/*     */   }
/*     */   
/*     */   public void replaceModel(IhmEntiteRelation model) {
/* 113 */     this.libSelected.replaceModel(model);
/*     */   }
/*     */   
/*     */   public void insertData() {
/* 117 */     this.jCBLib.removeAllItems();
/* 118 */     for (int i = 0; i < this.libList.size(); i++) {
/* 119 */       this.jCBLib.addItem(this.libList.get(i));
/*     */     }
/*     */   }
/*     */   
/*     */   public void repaindrePan() {
/* 124 */     this.panDraw.repaint();
/*     */   }
/*     */   
/*     */   public void addLibrary(Library lib)
/*     */   {
/* 129 */     lib.setRepertoire(this.pathLibraries);
/* 130 */     lib.setPath(this.pathLibraries + lib.prefixLib(lib.getName()));
/* 131 */     if (lib.saveLib()) {
/* 132 */       this.libList.add(lib);
/* 133 */       this.libSelected = lib;
/* 134 */       this.panDraw.setModel(this.libSelected);
/* 135 */       insertData();
/* 136 */       this.jCBLib.setSelectedItem(Integer.valueOf(this.libList.size() - 1));
/*     */     } else {
/* 138 */       JOptionPane.showMessageDialog(this.frmMain, "Erreur est survenue lors de la création de la librairie", "Création et Sauvegarde librairie", 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public ArrayList<Library> getLibList() {
/* 143 */     return this.libList;
/*     */   }
/*     */   
/*     */   public Library getLibSelected() {
/* 147 */     return this.libSelected;
/*     */   }
/*     */   
/*     */   public void setLibSelected(Library libSelected) {
/* 151 */     this.libSelected = libSelected;
/* 152 */     this.panDraw.setModel(libSelected);
/* 153 */     this.panDraw.repaint();
/* 154 */     this.jCBLib.setSelectedItem(libSelected);
/*     */   }
/*     */   
/*     */   public LibraryPanel getPanLibrary() {
/* 158 */     return this.panDraw;
/*     */   }
/*     */   
/*     */   public void setPathLibraries(String pathLibraries) {
/* 162 */     this.pathLibraries = pathLibraries;
/*     */   }
/*     */   
/*     */   public String getPathLibraries() {
/* 166 */     return this.pathLibraries;
/*     */   }
/*     */   
/*     */   public void setCouleurSel(Color couleurSel) {
/* 170 */     this.jLabLibrairie.setBackground(couleurSel);
/* 171 */     this.couleurSel = couleurSel;
/* 172 */     this.panDraw.setCouleurSel(couleurSel);
/* 173 */     this.panDraw.getModel().setCouleur(couleurSel);
/*     */   }
/*     */   
/*     */   public Color getCouleurSel() {
/* 177 */     return this.couleurSel;
/*     */   }
/*     */   
/*     */   private ArrayList<File> getListFileLibrary(String dir) {
/* 181 */     File file = new File(dir);
/* 182 */     if (!file.exists()) {
/* 183 */       file.mkdir();
/*     */     }
/* 185 */     File[] files = file.listFiles();
/* 186 */     ArrayList<File> filesLib = new ArrayList();
/* 187 */     int count = 0;
/* 188 */     if (files != null) {
/* 189 */       for (int i = 0; i < files.length; i++) {
/* 190 */         if ((!files[i].isDirectory() ? 1 : 0) == 1) {
/* 191 */           filesLib.add(files[i]);
/* 192 */           count++;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 197 */     return filesLib;
/*     */   }
/*     */   
/*     */ 
/*     */   public void removeLibrary(Library lib)
/*     */   {
/* 203 */     if (lib == null) return;
/* 204 */     getLibList().remove(lib);
/* 205 */     if (this.libSelected == lib) {
/* 206 */       if (getLibList().size() > 0) {
/* 207 */         this.libSelected = ((Library)this.libList.get(0));
/* 208 */         this.panDraw.setModel(this.libSelected);
/* 209 */         insertData();
/* 210 */         this.jCBLib.setSelectedItem(this.libSelected);
/* 211 */         this.panDraw.repaint();
/*     */       }
/*     */       else {
/* 214 */         this.libSelected = ((Library)this.libList.get(0));
/* 215 */         this.panDraw.setModel(this.libSelected);
/* 216 */         insertData();
/* 217 */         this.jCBLib.setSelectedItem(this.libSelected);
/* 218 */         this.panDraw.repaint();
/*     */       }
/* 220 */       lib.deleteLibFile();
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean renameLib(Library lib, String Newname)
/*     */   {
/* 226 */     for (int i = 0; i < this.libList.size(); i++) {
/* 227 */       if ((lib != this.libList.get(i)) && 
/* 228 */         (((Library)this.libList.get(i)).getName().trim().toUpperCase().equals(Newname.trim().toUpperCase()))) {
/* 229 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 233 */     lib.setName(Newname);
/* 234 */     lib.deleteLibFile();
/* 235 */     lib.saveLib();
/* 236 */     return true;
/*     */   }
/*     */   
/*     */   public void openLibraries() {
/* 240 */     getLibList().clear();
/* 241 */     this.jCBLib.removeAllItems();
/* 242 */     ArrayList<File> libFile = getListFileLibrary(this.pathLibraries);
/*     */     
/*     */ 
/* 245 */     String pathFile = this.pathLibraries;
/* 246 */     if (libFile != null)
/* 247 */       for (int i = 0; i < libFile.size(); i++) {
/* 248 */         Library lib = Library.openLib(pathFile + ((File)libFile.get(i)).getName());
/*     */         
/* 250 */         if (lib != null) {
/* 251 */           Color cl = lib.getCouleur();
/* 252 */           lib.setPath(pathFile + ((File)libFile.get(i)).getName());
/* 253 */           lib.setName(((File)libFile.get(i)).getName().replace(".jmlib", ""));
/* 254 */           lib.setRepertoire(this.pathLibraries);
/* 255 */           addLibrary(lib);
/* 256 */           lib.setCouleur(cl);
/*     */         }
/*     */       }
/*     */     Library libSel;
/* 260 */     if (getLibList().size() > 0) {
/* 261 */       libSel = (Library)getLibList().get(0);
/* 262 */       setCouleurSel(libSel.getCouleur());
/*     */     } else {
/* 264 */       libSel = new Library("DefaultLib");
/* 265 */       libSel.setPath(this.pathLibraries + libSel.prefixLib(libSel.getName()));
/* 266 */       libSel.setRepertoire(this.pathLibraries);
/* 267 */       if (libSel.saveLib()) {
/* 268 */         addLibrary(libSel);
/*     */       } else {
/* 270 */         JOptionPane.showMessageDialog(this.frmMain, "Erreur est survenue lors de la création de la librairie", "Création et Sauvegarde librairie", 0);
/*     */       }
/*     */     }
/*     */     
/* 274 */     this.libSelected = libSel;
/* 275 */     setLibSelected(this.libSelected);
/* 276 */     getPanLibrary().setModel(this.libSelected);
/*     */   }
/*     */   
/*     */   public String getName(IhmEntiteRelation model)
/*     */   {
/* 281 */     if ((model instanceof IhmEntite2)) {
/* 282 */       return ((IhmEntite2)model).getEntite().getNom();
/*     */     }
/* 284 */     if ((model instanceof IhmRelation2)) {
/* 285 */       return ((IhmRelation2)model).getRelation().getNom();
/*     */     }
/* 287 */     return "";
/*     */   }
/*     */   
/*     */   public void addModelLib(IhmEntiteRelation model) {
/* 291 */     if (this.libSelected != null) {
/* 292 */       if (!addModel(model)) {
/* 293 */         JOptionPane.showMessageDialog(this, "ERREUR : Le modèle existe déja dans la librairie ");
/*     */       } else {
/* 295 */         JOptionPane.showMessageDialog(this, "Le modèle " + getName(model) + " à été bien inseré dans la librairie");
/*     */       }
/*     */     } else {
/* 298 */       JOptionPane.showMessageDialog(this, "Aucune librairie n'est séléctionnée  ");
/*     */     }
/*     */   }
/*     */   
/*     */   public void deleteLibrairy(Library lib)
/*     */   {
/* 304 */     if (lib.deleteLibFile()) {
/* 305 */       getLibList().remove(lib);
/*     */       
/* 307 */       if (getLibList().size() == 0) {
/* 308 */         this.libSelected = new Library("DefaultLib");
/* 309 */         this.libSelected.setPath(this.pathLibraries + this.libSelected.prefixLib(this.libSelected.getName()));
/* 310 */         this.libSelected.setRepertoire(this.pathLibraries);
/* 311 */         if (this.libSelected.saveLib()) {
/* 312 */           addLibrary(this.libSelected);
/*     */         } else {
/* 314 */           JOptionPane.showMessageDialog(this.frmMain, "Erreur est survenue lors de la création de la librairie", "Création et Sauvegarde librairie", 0);
/*     */         }
/*     */       }
/*     */       else {
/* 318 */         this.libSelected = ((Library)getLibList().get(0));
/*     */       }
/*     */       
/* 321 */       insertData();
/* 322 */       repaint();
/* 323 */       setLibSelected(this.libSelected);
/* 324 */       getPanLibrary().setModel(this.libSelected);
/* 325 */       setCouleurSel(this.libSelected.getCouleur());
/*     */     } else {
/* 327 */       JOptionPane.showMessageDialog(this.frmMain, "Une erreur est survenue lors de la suppression de la librairie", "Suppression", 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean renameLibrairy(Library lib, String newPath, String newName) {
/* 332 */     if (lib.renameLibFile(newPath)) {
/* 333 */       lib.setPath(newPath);
/* 334 */       lib.setName(newName);
/* 335 */       return true;
/*     */     }
/* 337 */     JOptionPane.showMessageDialog(this.frmMain, "Une erreur est survenue lors de la ronommage de la librairie", "Renommer Librairie", 0);
/* 338 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private JLabel jLabLibrairie;
/*     */   
/*     */ 
/*     */   private JPanel jPanel;
/*     */   
/*     */ 
/*     */   private void initComponents()
/*     */   {
/* 351 */     this.jLabLibrairie = new JLabel();
/* 352 */     this.jCBLib = new JComboBox();
/* 353 */     this.jPanel = new JPanel();
/*     */     
/* 355 */     setMaximumSize(new Dimension(400, 32767));
/* 356 */     setMinimumSize(new Dimension(225, 0));
/* 357 */     setPreferredSize(new Dimension(225, 410));
/*     */     
/* 359 */     this.jLabLibrairie.setBackground(new Color(255, 0, 0));
/* 360 */     this.jLabLibrairie.setFont(new Font("Tahoma", 1, 12));
/* 361 */     this.jLabLibrairie.setForeground(new Color(255, 255, 255));
/* 362 */     this.jLabLibrairie.setHorizontalAlignment(0);
/* 363 */     this.jLabLibrairie.setText("Librairies");
/* 364 */     this.jLabLibrairie.setToolTipText("Cliquez pour les couleurs et double cliquez pour les propiétés.  ");
/* 365 */     this.jLabLibrairie.setCursor(new Cursor(12));
/* 366 */     this.jLabLibrairie.setOpaque(true);
/* 367 */     this.jLabLibrairie.addMouseListener(new MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 369 */         PanelEntiteRelation.this.jLabLibrairieMouseClicked(evt);
/*     */       }
/*     */       
/* 372 */     });
/* 373 */     this.jCBLib.addItemListener(new ItemListener() {
/*     */       public void itemStateChanged(ItemEvent evt) {
/* 375 */         PanelEntiteRelation.this.jCBLibItemStateChanged(evt);
/*     */       }
/*     */       
/* 378 */     });
/* 379 */     GroupLayout jPanelLayout = new GroupLayout(this.jPanel);
/* 380 */     this.jPanel.setLayout(jPanelLayout);
/* 381 */     jPanelLayout.setHorizontalGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 225, 32767));
/*     */     
/*     */ 
/*     */ 
/* 385 */     jPanelLayout.setVerticalGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 344, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 390 */     GroupLayout layout = new GroupLayout(this);
/* 391 */     setLayout(layout);
/* 392 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabLibrairie, -1, 225, 32767).addComponent(this.jPanel, -1, -1, 32767).addComponent(this.jCBLib, 0, 225, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 398 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabLibrairie, -2, 26, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCBLib, -2, 28, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel, -1, -1, 32767)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void jCBLibItemStateChanged(ItemEvent evt)
/*     */   {
/* 410 */     if (this.jCBLib.getSelectedIndex() >= 0) {
/* 411 */       this.libSelected = ((Library)this.jCBLib.getSelectedItem());
/* 412 */       Color cl = this.libSelected.getCouleur();
/* 413 */       this.panDraw.setModel(this.libSelected);
/* 414 */       setCouleurSel(cl);
/* 415 */       this.panDraw.repaint();
/*     */     }
/*     */   }
/*     */   
/*     */   private void jLabLibrairieMouseClicked(MouseEvent evt) {
/* 420 */     if (evt.getClickCount() == 2) {
/* 421 */       new FormeCouleurLibrairie(this.frmMain, true).setVisible(true);
/*     */     }
/*     */     
/* 424 */     if (evt.getClickCount() == 1) {
/* 425 */       if (this.libSelected == null) return;
/* 426 */       new FormeProprieteLibrairie(this.frmMain, true, this.libSelected).setVisible(true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\LibraryPan\PanelEntiteRelation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */