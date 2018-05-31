/*     */ package ihm;
/*     */ 
/*     */ import IhmMCD.IhmEntite;
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmLien;
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD.IhmPostIt;
/*     */ import IhmMCD.IhmRelation;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmLien2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import Merise.Attribut;
/*     */ import Merise.Entite;
/*     */ import Merise.Relation;
/*     */ import Merise2.Attribut2;
/*     */ import Merise2.Entite2;
/*     */ import Merise2.Relation2;
/*     */ import MyExplorerBD.ExplorerPanBD;
/*     */ import Outil.Parametres;
/*     */ import composantSQL.Column;
/*     */ import composantSQL.MyDataBase;
/*     */ import composantSQL.Table;
/*     */ import formes.FormeConnexion;
/*     */ import java.awt.Color;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JSplitPane;
/*     */ import javax.swing.JTable;
/*     */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ 
/*     */ public class FormeInterneRetro extends javax.swing.JInternalFrame
/*     */ {
/*     */   private Principale frm;
/*     */   private ExplorerPanBD explorerBD;
/*     */   private MyDataBase dataBase;
/*     */   private ArrayList<Table> listeTableSel;
/*  53 */   private static int nbRel = 0;
/*     */   private JButton jBtConnecter;
/*     */   
/*     */   public FormeInterneRetro(Principale frm) {
/*  57 */     initComponents();
/*  58 */     this.frm = frm;
/*  59 */     this.dataBase = new MyDataBase("");
/*  60 */     this.dataBase.setFrm(frm);
/*  61 */     this.explorerBD = new ExplorerPanBD(frm);
/*  62 */     this.explorerBD.setVisible(true);
/*  63 */     this.jSplitPane2.setLeftComponent(this.explorerBD);
/*  64 */     this.jSplitPane2.setDividerLocation(this.explorerBD.getWidth() + 200);
/*  65 */     getDataBase().setConnection(frm.getConnection().conn);
/*  66 */     if (getDataBase().getConnection() != null) this.dataBase.getListeTable();
/*  67 */     this.dataBase.remplirTableAttribut();
/*     */     
/*  69 */     remplirListeTable();
/*  70 */     this.explorerBD.ajouterBase(this.dataBase);
/*  71 */     this.listeTableSel = new ArrayList();
/*     */   }
/*     */   
/*     */   private JButton jBtConstruire;
/*     */   private JButton jBtConstruirePartiel;
/*     */   private JButton jBtImporter;
/*     */   
/*  78 */   public void afficherListeVideAttribut() { Object[][] ob = new Object[0][6];
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  88 */     Object[] col = { "Attribut", "Type", "Taille", "Clé", "isNull", "AI" };
/*  89 */     this.jTable1.setModel(new javax.swing.table.DefaultTableModel(ob, col)); }
/*     */   
/*     */   private JButton jBtLegende;
/*     */   
/*  93 */   public void afficherListeAttribut(Table tab) { if (tab == null) return;
/*  94 */     if (tab.getColumnList().size() > 0) afficherColonne((Column)tab.getColumnList().get(0));
/*  95 */     Object[][] ob = new Object[tab.getColumnList().size()][6];
/*  96 */     for (int i = 0; i < tab.getColumnList().size(); i++) {
/*  97 */       ob[i][0] = ((Column)tab.getColumnList().get(i)).getName();
/*  98 */       ob[i][1] = ((Column)tab.getColumnList().get(i)).getType();
/*  99 */       ob[i][2] = Integer.valueOf(((Column)tab.getColumnList().get(i)).getSize());
/* 100 */       ob[i][3] = ((Column)tab.getColumnList().get(i)).getKey();
/* 101 */       ob[i][4] = (((Column)tab.getColumnList().get(i)).isNull() ? "Yes" : "No");
/* 102 */       ob[i][5] = (((Column)tab.getColumnList().get(i)).isAutoInc() ? "Yes" : "No");
/*     */     }
/*     */     
/* 105 */     Object[] col = { "Attribut", "Type", "Taille", "Clé", "isNull", "AI" };
/* 106 */     this.jTable1.setModel(new javax.swing.table.DefaultTableModel(ob, col)); }
/*     */   
/*     */   private JCheckBox jCBAI;
/*     */   private JCheckBox jCBCle;
/* 110 */   public void remplirListeTable() { this.jCBTable.removeAllItems();
/* 111 */     for (int i = 0; i < this.dataBase.getTableList().size(); i++) {
/* 112 */       this.jCBTable.addItem(this.dataBase.getTableList().get(i));
/*     */     }
/*     */   }
/*     */   
/*     */   public void remplirInformation(String nameDB, String typeSql) {
/* 117 */     if (getDataBase() != null) {
/* 118 */       this.jLabBase.setText(nameDB);
/* 119 */       this.jLabType.setText(typeSql);
/* 120 */       this.jCBTable.removeAllItems();
/* 121 */       this.dataBase.getTableList().clear();
/* 122 */       afficherListeVideAttribut();
/*     */     } else {
/* 124 */       this.jLabBase.setText("");
/* 125 */       this.jLabType.setText("");
/*     */     } }
/*     */   
/*     */   private JCheckBox jCBIndex;
/*     */   private JCheckBox jCBNull;
/*     */   private JComboBox jCBTable;
/*     */   private JCheckBox jCBUnique;
/*     */   private JLabel jLabBase;
/*     */   private JLabel jLabNbTable;
/*     */   private JLabel jLabType;
/* 135 */   public MyDataBase getDataBase() { return this.dataBase; }
/*     */   
/*     */   public ExplorerPanBD getExplorerBD()
/*     */   {
/* 139 */     return this.explorerBD;
/*     */   }
/*     */   
/*     */   public Principale getFrm() {
/* 143 */     return this.frm;
/*     */   }
/*     */   
/*     */   public ArrayList<Table> getListeTableSel() {
/* 147 */     return this.listeTableSel;
/*     */   }
/*     */   
/*     */   public void setListeTableSel(ArrayList<Table> listeTableSel) {
/* 151 */     this.listeTableSel = listeTableSel;
/*     */   }
/*     */   
/*     */   public void setDataBase(MyDataBase dataBase) {
/* 155 */     this.dataBase = dataBase;
/*     */   }
/*     */   
/*     */   public void setExplorerBD(ExplorerPanBD explorerBD) {
/* 159 */     this.explorerBD = explorerBD;
/*     */   }
/*     */   
/*     */   public void setFrm(Principale frm) {
/* 163 */     this.frm = frm;
/*     */   }
/*     */   
/*     */   private String getType(String type) {
/* 167 */     for (int i = 0; i < Parametres.DomaineDefini.length; i++) {
/* 168 */       if (type.trim().toUpperCase().equals(Parametres.DomaineDefini[i].trim().toUpperCase())) {
/* 169 */         return Parametres.DomaineDefini[i];
/*     */       }
/*     */     }
/* 172 */     return "INDEFINI";
/*     */   }
/*     */   
/*     */   private boolean tableSansKey(Table tab)
/*     */   {
/* 177 */     for (int i = 0; i < tab.getColumnList().size(); i++) {
/* 178 */       if (((Column)tab.getColumnList().get(i)).getKey().equals(Parametres.Cle)) {
/* 179 */         return false;
/*     */       }
/*     */     }
/* 182 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean estRelation(Table tab)
/*     */   {
/* 190 */     if (tableSansKey(tab)) return false;
/* 191 */     for (int i = 0; i < tab.getColumnList().size(); i++) {
/* 192 */       if ((((Column)tab.getColumnList().get(i)).getKey().equals(Parametres.Cle)) && 
/* 193 */         (((Column)tab.getColumnList().get(i)).getFrkey().trim().length() == 0)) {
/* 194 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 200 */     return true;
/*     */   }
/*     */   
/*     */   private Entite convertirTabEntite(Table tab) {
/* 204 */     Entite2 ent = new Entite2(tab.getName());
/* 205 */     ent.setCommentaire(tab.getComment());
/* 206 */     for (int i = 0; i < tab.getColumnList().size(); i++) {
/* 207 */       Attribut att = new Attribut2(((Column)tab.getColumnList().get(i)).getName(), getType(((Column)tab.getColumnList().get(i)).getType()), ((Column)tab.getColumnList().get(i)).getSize(), 0, ((Column)tab.getColumnList().get(i)).getKey(), ((Column)tab.getColumnList().get(i)).isNull(), ((Column)tab.getColumnList().get(i)).getComment(), ent);
/*     */       
/*     */ 
/* 210 */       att.setEntiteRelation(ent);
/* 211 */       att = corrigerAttribut((Attribut2)att);
/*     */       
/* 213 */       if (((Column)tab.getColumnList().get(i)).getIndex().trim().length() != 0) att.setKey(((Column)tab.getColumnList().get(i)).getIndex());
/* 214 */       if (((Column)tab.getColumnList().get(i)).getFrkey().trim().length() != 0) att.setKey(Parametres.CleEtr);
/* 215 */       ent.getListeAttributs().add(att);
/*     */     }
/* 217 */     return ent;
/*     */   }
/*     */   
/*     */   private Attribut corrigerAttribut(Attribut2 att) {
/* 221 */     if (att.getLongueur() > 255) {
/* 222 */       att.setLongueur(-1);
/*     */     }
/* 224 */     if (att.getLongDecimale() > 255) {
/* 225 */       att.setLongDecimale(-1);
/*     */     }
/* 227 */     return att;
/*     */   }
/*     */   
/*     */   private Relation convertirTabRelation(Table tab)
/*     */   {
/* 232 */     Relation2 ent = new Relation2(tab.getName());
/* 233 */     ent.setCommentaire(tab.getComment());
/* 234 */     for (int i = 0; i < tab.getColumnList().size(); i++) {
/* 235 */       Attribut att = new Attribut2(((Column)tab.getColumnList().get(i)).getName(), getType(((Column)tab.getColumnList().get(i)).getType()), ((Column)tab.getColumnList().get(i)).getSize(), 0, ((Column)tab.getColumnList().get(i)).getKey(), ((Column)tab.getColumnList().get(i)).isNull(), ((Column)tab.getColumnList().get(i)).getComment(), ent);
/*     */       
/*     */ 
/*     */ 
/* 239 */       att = corrigerAttribut((Attribut2)att);
/* 240 */       att.setEntiteRelation(ent);
/*     */       
/* 242 */       if (((Column)tab.getColumnList().get(i)).getIndex().trim().length() != 0) att.setKey(((Column)tab.getColumnList().get(i)).getIndex());
/* 243 */       if (((Column)tab.getColumnList().get(i)).getFrkey().trim().length() != 0) att.setKey(Parametres.CleEtr);
/* 244 */       ent.getListeAttributs().add(att);
/*     */     }
/* 246 */     return ent;
/*     */   }
/*     */   
/*     */   public void construireMCD() {
/* 250 */     this.frm.getPage().effacerAllMCD();
/* 251 */     for (int i = 0; i < this.dataBase.getTableList().size(); i++) {
/* 252 */       if (estRelation((Table)this.dataBase.getTableList().get(i))) {
/* 253 */         this.frm.getPage().getListeEntiteRelation().add(new IhmRelation2(convertirTabRelation((Table)this.dataBase.getTableList().get(i)), i, i, this.frm.isVariable()));
/*     */       } else {
/* 255 */         this.frm.getPage().getListeEntiteRelation().add(new IhmEntite2(convertirTabEntite((Table)this.dataBase.getTableList().get(i)), i, i, this.frm.isVariable()));
/*     */       }
/*     */     }
/* 258 */     this.frm.getPage().repaint();
/*     */   }
/*     */   
/*     */   private IhmEntiteRelation trouverEntRel(String s) {
/* 262 */     for (int i = 0; i < this.frm.getPage().getListeEntiteRelation().size(); i++) {
/* 263 */       if ((this.frm.getPage().getListeEntiteRelation().get(i) instanceof IhmEntite2)) {
/* 264 */         if (((IhmEntite2)this.frm.getPage().getListeEntiteRelation().get(i)).getEntite().getNom().trim().toUpperCase().equals(s.trim().toUpperCase())) {
/* 265 */           return (IhmEntiteRelation)this.frm.getPage().getListeEntiteRelation().get(i);
/*     */         }
/* 267 */       } else if (((IhmRelation2)this.frm.getPage().getListeEntiteRelation().get(i)).getRelation().getNom().trim().toUpperCase().equals(s.trim().toUpperCase())) {
/* 268 */         return (IhmEntiteRelation)this.frm.getPage().getListeEntiteRelation().get(i);
/*     */       }
/*     */     }
/* 271 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   private void construireLienDeRelation(Table tab, IhmRelation rel)
/*     */   {
/* 277 */     for (int i = 0; i < tab.getColumnList().size(); i++) {
/* 278 */       Column c = (Column)tab.getColumnList().get(i);
/* 279 */       if ((c.getKey().equals(Parametres.Cle)) && (c.getTableFrKy().trim().length() != 0)) {
/* 280 */         IhmEntiteRelation ent = trouverEntRel(c.getTableFrKy());
/* 281 */         if (ent != null) {
/* 282 */           this.frm.getPage().getListeLien().add(new IhmLien2((IhmEntite2)ent, (IhmRelation2)rel));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void construireLienEntite(Table tab, IhmEntite ent)
/*     */   {
/* 291 */     for (int i = 0; i < tab.getColumnList().size(); i++) {
/* 292 */       Column c = (Column)tab.getColumnList().get(i);
/* 293 */       if (c.getTableFrKy().trim().length() != 0) {
/* 294 */         IhmEntiteRelation e = trouverEntRel(c.getTableFrKy());
/* 295 */         if ((e instanceof IhmEntite2)) {
/* 296 */           IhmRelation r = new IhmRelation2(new Relation2("relation" + nbRel), 10, 10, this.frm.isTailleVariable());
/* 297 */           r.getRelation().setNom("");
/* 298 */           nbRel += 1;
/* 299 */           IhmLien l = new IhmLien2((IhmEntite2)e, r);
/* 300 */           l.setCardinalite("0,n");
/*     */           
/* 302 */           this.frm.getPage().getListeEntiteRelation().add(r);
/* 303 */           this.frm.getPage().getListeLien().add(l);
/* 304 */           l = new IhmLien2(ent, r);
/* 305 */           if (c.isNull()) l.setCardinalite("0,1"); else
/* 306 */             l.setCardinalite("1,1");
/* 307 */           this.frm.getPage().getListeLien().add(l);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void construireLesLiens()
/*     */   {
/* 316 */     for (int i = 0; i < this.dataBase.getTableList().size(); i++) {
/* 317 */       IhmEntiteRelation ent = trouverEntRel(((Table)this.dataBase.getTableList().get(i)).getName());
/* 318 */       if ((ent instanceof IhmEntite2)) {
/* 319 */         construireLienEntite((Table)this.dataBase.getTableList().get(i), (IhmEntite2)ent);
/*     */       }
/* 321 */       else if ((ent instanceof IhmRelation2)) {
/* 322 */         construireLienDeRelation((Table)this.dataBase.getTableList().get(i), (IhmRelation2)ent);
/*     */       }
/*     */     }
/*     */     
/* 326 */     nbRel = 0;
/*     */   }
/*     */   
/*     */   private IhmEntite trouverEntiteAPartir(int ind) {
/* 330 */     for (int i = ind; i < this.frm.getPage().getListeEntiteRelation().size(); i++) {
/* 331 */       if ((this.frm.getPage().getListeEntiteRelation().get(i) instanceof IhmEntite2))
/* 332 */         return (IhmEntite2)this.frm.getPage().getListeEntiteRelation().get(i);
/*     */     }
/* 334 */     return null;
/*     */   }
/*     */   
/*     */   private IhmRelation trouverRelationAPartir(int ind) {
/* 338 */     for (int i = ind; i < this.frm.getPage().getListeEntiteRelation().size(); i++) {
/* 339 */       if ((this.frm.getPage().getListeEntiteRelation().get(i) instanceof IhmRelation2))
/* 340 */         return (IhmRelation2)this.frm.getPage().getListeEntiteRelation().get(i);
/*     */     }
/* 342 */     return null;
/*     */   }
/*     */   
/*     */   private int heightEntite(IhmEntite ent) {
/* 346 */     int nbAtt = ent.getEntite().getListeAttributs().size();
/* 347 */     int h = this.frm.getPage().getGraphics().getFontMetrics().getHeight();
/* 348 */     return (3 + nbAtt) * h;
/*     */   }
/*     */   
/*     */   private int heightRelation(IhmRelation rel) {
/* 352 */     int nbAtt = rel.getRelation().getListeAttributs().size();
/* 353 */     int h = this.frm.getPage().getGraphics().getFontMetrics().getHeight();
/* 354 */     return (3 + nbAtt) * h;
/*     */   }
/*     */   
/*     */ 
/*     */   public void repositionnerMCD()
/*     */   {
/* 360 */     int x1 = 10;int y1 = 90;int x2 = 800;int xr = 400;
/*     */     
/* 362 */     IhmEntite ent1 = trouverEntiteAPartir(0);
/* 363 */     while (ent1 != null) {
/* 364 */       IhmEntite ent2 = trouverEntiteAPartir(this.frm.getPage().getListeEntiteRelation().indexOf(ent1) + 1);
/* 365 */       if (ent2 != null) {
/* 366 */         ent1.setX(x1);
/* 367 */         ent1.setY(y1);
/* 368 */         ent2.setX(x2);
/* 369 */         ent2.setY(y1);
/* 370 */         int h1 = heightEntite(ent1);int h2 = heightEntite(ent2);
/* 371 */         if (h1 > h2) {
/* 372 */           y1 = y1 + h1 + 10;
/*     */         }
/*     */         else {
/* 375 */           y1 = y1 + h2 + 10;
/*     */         }
/* 377 */         ent1 = trouverEntiteAPartir(this.frm.getPage().getListeEntiteRelation().indexOf(ent2) + 1);
/*     */       } else {
/* 379 */         ent1.setX(x1);
/* 380 */         ent1.setY(y1);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 387 */     ent1 = trouverEntiteAPartir(0);
/* 388 */     IhmRelation rel = trouverRelationAPartir(0);
/* 389 */     x1 = 10;
/* 390 */     y1 = 110;
/* 391 */     while (rel != null) {
/* 392 */       rel.setX(xr);
/* 393 */       rel.setY(y1);
/* 394 */       y1 += heightRelation(rel);
/* 395 */       rel = trouverRelationAPartir(this.frm.getPage().getListeEntiteRelation().indexOf(rel) + 1);
/*     */     }
/*     */   }
/*     */   
/*     */   private Attribut trouverAttribut(IhmEntite ent, String att) {
/* 400 */     for (int i = 0; i < ent.getEntite().getListeAttributs().size(); i++) {
/* 401 */       if (((Attribut)ent.getEntite().getListeAttributs().get(i)).getNom().trim().toUpperCase().equals(att.trim().toUpperCase()))
/* 402 */         return (Attribut)ent.getEntite().getListeAttributs().get(i);
/*     */     }
/* 404 */     return null;
/*     */   }
/*     */   
/*     */   private Attribut trouverAttribut(IhmRelation ent, String att) {
/* 408 */     for (int i = 0; i < ent.getRelation().getListeAttributs().size(); i++) {
/* 409 */       if (((Attribut)ent.getRelation().getListeAttributs().get(i)).getNom().trim().toUpperCase().equals(att.trim().toUpperCase()))
/* 410 */         return (Attribut)ent.getRelation().getListeAttributs().get(i);
/*     */     }
/* 412 */     return null;
/*     */   }
/*     */   
/*     */   private IhmLien estHeritage(IhmRelation rel) {
/* 416 */     int nb = 0;
/* 417 */     IhmLien l = null;
/* 418 */     for (int i = 0; i < this.frm.getPage().getListeLien().size(); i++) {
/* 419 */       if (((IhmLien)this.frm.getPage().getListeLien().get(i)).getRelation().equals(rel)) {
/* 420 */         nb++;
/* 421 */         if (nb >= 2) return null;
/* 422 */         if (nb == 1) l = (IhmLien)this.frm.getPage().getListeLien().get(i);
/*     */       }
/*     */     }
/* 425 */     return l;
/*     */   }
/*     */   
/*     */   public void creerHeritage()
/*     */   {
/* 430 */     for (int i = 0; i < this.frm.getPage().getListeEntiteRelation().size(); i++) {
/* 431 */       if ((this.frm.getPage().getListeEntiteRelation().get(i) instanceof IhmRelation2)) {
/* 432 */         IhmLien l = estHeritage((IhmRelation2)this.frm.getPage().getListeEntiteRelation().get(i));
/* 433 */         if (l != null) {
/* 434 */           Entite2 e = new Entite2(l.getRelation().getRelation().getNom());
/* 435 */           e.setListeAttributs(l.getRelation().getRelation().getListeAttributs());
/* 436 */           IhmEntite2 en = new IhmEntite2(e, 10, 10, this.frm.isTailleVariable());
/* 437 */           this.frm.getPage().getListeEntiteRelation().add(en);
/* 438 */           this.frm.getPage().getListeLienHeritage().add(new IhmMCD2.IhmLienHeritage2(l.getEntite(), en));
/* 439 */           this.frm.getPage().getListeEntiteRelation().remove(l.getRelation());
/* 440 */           this.frm.getPage().getListeLien().remove(l);
/*     */         }
/*     */       }
/*     */     }
/* 444 */     IhmPostIt com = new IhmPostIt("", 5, 5, 250, 50);
/*     */     
/* 446 */     com.setCommentaire("Ce MCD est généré automatiquement par\n JMerise.\n ===> Version d'essai.<===\n");
/* 447 */     com.setSelected(false);
/* 448 */     this.frm.getPage().getListeCommentaire().add(com);
/*     */   }
/*     */   
/*     */   private void supprimerAttribut(String ent, String att) {
/* 452 */     IhmEntiteRelation e = trouverEntRel(ent);
/*     */     
/* 454 */     if (e != null) {
/* 455 */       if ((e instanceof IhmEntite2)) {
/* 456 */         Attribut a = trouverAttribut((IhmEntite2)e, att);
/* 457 */         ((IhmEntite2)e).getEntite().getListeAttributs().remove(a);
/*     */       } else {
/* 459 */         Attribut a = trouverAttribut((IhmRelation2)e, att);
/* 460 */         ((IhmRelation2)e).getRelation().getListeAttributs().remove(a);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void supprimerCleEtrangere()
/*     */   {
/* 468 */     for (int i = 0; i < this.dataBase.getTableList().size(); i++) {
/* 469 */       Table t = (Table)this.dataBase.getTableList().get(i);
/* 470 */       for (int j = 0; j < t.getColumnList().size(); j++) {
/* 471 */         if (((Column)t.getColumnList().get(j)).getTableFrKy().trim().length() > 0) {
/* 472 */           supprimerAttribut(t.getName(), ((Column)t.getColumnList().get(j)).getName());
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void afficherColonne(Column c) {
/* 479 */     if (c == null) {
/* 480 */       this.jTFNom.setText("");
/* 481 */       this.jTFType.setText("");
/* 482 */       this.jTFTaille.setText("");
/* 483 */       this.jCBCle.setSelected(false);
/* 484 */       this.jCBIndex.setSelected(false);
/* 485 */       this.jCBNull.setSelected(false);
/* 486 */       this.jCBAI.setSelected(false);
/* 487 */       this.jCBUnique.setSelected(false);
/*     */     } else {
/* 489 */       this.jTFNom.setText(c.getName());
/* 490 */       this.jTFType.setText(c.getType());
/* 491 */       this.jTFTaille.setText(c.getSize() + "");
/* 492 */       this.jCBCle.setSelected(c.getKey().equals(Parametres.Cle));
/* 493 */       this.jCBIndex.setSelected(c.getIndex().equals(Parametres.Index));
/* 494 */       this.jCBNull.setSelected(c.isNull());
/* 495 */       this.jCBAI.setSelected(c.isAutoInc());
/* 496 */       this.jCBUnique.setSelected(c.getIndex().equals(Parametres.Unique));
/*     */     }
/*     */   }
/*     */   
/*     */   public JComboBox getjCBTable() {
/* 501 */     return this.jCBTable;
/*     */   }
/*     */   
/*     */   public void afficherTable(Table t) {
/* 505 */     int n = -1;
/* 506 */     for (int i = 0; i < this.jCBTable.getItemCount(); i++) {
/* 507 */       if (t.equals((Table)this.jCBTable.getItemAt(i))) {
/* 508 */         n = i;
/* 509 */         break;
/*     */       }
/*     */     }
/* 512 */     if (n > -1) {
/* 513 */       this.jCBTable.setSelectedIndex(n);
/*     */     }
/*     */   }
/*     */   
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JLabel jLabel4;
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JPanel jPanel1;
/*     */   
/*     */   private void initComponents()
/*     */   {
/* 527 */     this.jSplitPane2 = new JSplitPane();
/* 528 */     this.jPanel5 = new JPanel();
/* 529 */     this.jLabNbTable = new JLabel();
/* 530 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/* 531 */     this.jTable1 = new JTable();
/* 532 */     this.jPanel1 = new JPanel();
/* 533 */     this.jLabel2 = new JLabel();
/* 534 */     this.jLabel3 = new JLabel();
/* 535 */     this.jTFNom = new JTextField();
/* 536 */     this.jTFType = new JTextField();
/* 537 */     this.jTFTaille = new JTextField();
/* 538 */     this.jLabel4 = new JLabel();
/* 539 */     this.jCBNull = new JCheckBox();
/* 540 */     this.jCBAI = new JCheckBox();
/* 541 */     this.jCBCle = new JCheckBox();
/* 542 */     this.jCBIndex = new JCheckBox();
/* 543 */     this.jCBUnique = new JCheckBox();
/* 544 */     this.jLabel6 = new JLabel();
/* 545 */     this.jCBTable = new JComboBox();
/* 546 */     this.jPanel2 = new JPanel();
/* 547 */     this.jBtConnecter = new JButton();
/* 548 */     this.jBtImporter = new JButton();
/* 549 */     this.jBtConstruire = new JButton();
/* 550 */     this.jBtLegende = new JButton();
/* 551 */     this.jLabel1 = new JLabel();
/* 552 */     this.jLabel5 = new JLabel();
/* 553 */     this.jLabType = new JLabel();
/* 554 */     this.jLabBase = new JLabel();
/* 555 */     this.jBtConstruirePartiel = new JButton();
/*     */     
/* 557 */     setClosable(true);
/* 558 */     setDefaultCloseOperation(1);
/* 559 */     setIconifiable(true);
/* 560 */     setMaximizable(true);
/* 561 */     setResizable(true);
/* 562 */     setTitle("Rétro Conception");
/* 563 */     setAutoscrolls(true);
/* 564 */     setVisible(true);
/*     */     
/* 566 */     this.jLabNbTable.setText("La colonne séléctionnée  :");
/*     */     
/* 568 */     this.jTable1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/* 569 */     this.jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null }, { null, null, null, null, null, null } }, new String[] { "Attribut", "Type", "Taille", "Clé", "isNull", "AI" }));
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
/* 580 */     this.jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 582 */         FormeInterneRetro.this.jTable1MouseClicked(evt);
/*     */       }
/* 584 */     });
/* 585 */     this.jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
/*     */       public void keyPressed(KeyEvent evt) {
/* 587 */         FormeInterneRetro.this.jTable1KeyPressed(evt);
/*     */       }
/*     */       
/* 590 */       public void keyReleased(KeyEvent evt) { FormeInterneRetro.this.jTable1KeyReleased(evt);
/*     */       }
/* 592 */     });
/* 593 */     this.jScrollPane1.setViewportView(this.jTable1);
/*     */     
/* 595 */     this.jPanel1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */     
/* 597 */     this.jLabel2.setText("Nom");
/*     */     
/* 599 */     this.jLabel3.setText("Type");
/*     */     
/* 601 */     this.jLabel4.setText("Taille");
/*     */     
/* 603 */     this.jCBNull.setText("Null");
/*     */     
/* 605 */     this.jCBAI.setText("AI");
/*     */     
/* 607 */     this.jCBCle.setText("Clé");
/*     */     
/* 609 */     this.jCBIndex.setText("Index");
/*     */     
/* 611 */     this.jCBUnique.setText("Unique");
/*     */     
/* 613 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 614 */     this.jPanel1.setLayout(jPanel1Layout);
/* 615 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jCBNull, -2, 53, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBCle).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBIndex).addGap(5, 5, 5).addComponent(this.jCBUnique, -2, 68, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel3).addComponent(this.jLabel2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTFNom, -1, 191, 32767).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jTFType, -1, 187, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))))).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel4).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTFTaille, -2, 46, -2)).addComponent(this.jCBAI, -2, 46, -2)).addContainerGap()));
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
/* 647 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.jTFNom, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTFType, -2, -1, -2).addComponent(this.jTFTaille, -2, -1, -2).addComponent(this.jLabel4)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(this.jCBAI).addComponent(this.jCBNull).addComponent(this.jCBCle).addComponent(this.jCBIndex).addComponent(this.jCBUnique)).addContainerGap(22, 32767)));
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
/* 670 */     this.jLabel6.setText("Les tables : ");
/*     */     
/* 672 */     this.jCBTable.addItemListener(new java.awt.event.ItemListener() {
/*     */       public void itemStateChanged(ItemEvent evt) {
/* 674 */         FormeInterneRetro.this.jCBTableItemStateChanged(evt);
/*     */       }
/*     */       
/* 677 */     });
/* 678 */     this.jPanel2.setBackground(new Color(204, 204, 204));
/* 679 */     this.jPanel2.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */     
/* 681 */     this.jBtConnecter.setIcon(new ImageIcon(getClass().getResource("/Images/db16.png")));
/* 682 */     this.jBtConnecter.setText("Se connecter");
/* 683 */     this.jBtConnecter.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 685 */         FormeInterneRetro.this.jBtConnecterActionPerformed(evt);
/*     */       }
/*     */       
/* 688 */     });
/* 689 */     this.jBtImporter.setIcon(new ImageIcon(getClass().getResource("/Images/b_import.png")));
/* 690 */     this.jBtImporter.setText("Importer les tables");
/* 691 */     this.jBtImporter.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 693 */         FormeInterneRetro.this.jBtImporterActionPerformed(evt);
/*     */       }
/*     */       
/* 696 */     });
/* 697 */     this.jBtConstruire.setIcon(new ImageIcon(getClass().getResource("/Images/constructionMCD.png")));
/* 698 */     this.jBtConstruire.setText("Construire MCD");
/* 699 */     this.jBtConstruire.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 701 */         FormeInterneRetro.this.jBtConstruireActionPerformed(evt);
/*     */       }
/*     */       
/* 704 */     });
/* 705 */     this.jBtLegende.setIcon(new ImageIcon(getClass().getResource("/Images/colonneIndex16.png")));
/* 706 */     this.jBtLegende.setText("Légende");
/* 707 */     this.jBtLegende.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 709 */         FormeInterneRetro.this.jBtLegendeActionPerformed(evt);
/*     */       }
/*     */       
/* 712 */     });
/* 713 */     this.jLabel1.setText("Type :");
/*     */     
/* 715 */     this.jLabel5.setText("Base de données");
/*     */     
/* 717 */     this.jLabType.setText(".");
/*     */     
/* 719 */     this.jLabBase.setText(".");
/*     */     
/* 721 */     this.jBtConstruirePartiel.setIcon(new ImageIcon(getClass().getResource("/Images/constructionMCD.png")));
/* 722 */     this.jBtConstruirePartiel.setText("Const. Partielle  MCD");
/* 723 */     this.jBtConstruirePartiel.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 725 */         FormeInterneRetro.this.jBtConstruirePartielActionPerformed(evt);
/*     */       }
/*     */       
/* 728 */     });
/* 729 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 730 */     this.jPanel2.setLayout(jPanel2Layout);
/* 731 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel1).addComponent(this.jLabel5).addComponent(this.jLabType).addComponent(this.jLabBase).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jBtConstruire, GroupLayout.Alignment.LEADING, -1, 135, 32767).addComponent(this.jBtConnecter, GroupLayout.Alignment.LEADING, -1, 135, 32767)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jBtConstruirePartiel, -1, 154, 32767).addComponent(this.jBtImporter, -1, 154, 32767)))).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addComponent(this.jBtLegende, -2, 125, -2).addGap(100, 100, 100)))));
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
/* 755 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabType).addGap(9, 9, 9).addComponent(this.jLabel5).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabBase).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtConnecter).addComponent(this.jBtImporter)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtConstruire).addComponent(this.jBtConstruirePartiel)).addGap(18, 18, 18).addComponent(this.jBtLegende).addContainerGap(-1, 32767)));
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
/* 779 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/* 780 */     this.jPanel5.setLayout(jPanel5Layout);
/* 781 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(92, 92, 92).addComponent(this.jLabel6).addGap(18, 18, 18).addComponent(this.jCBTable, 0, 364, 32767).addGap(9, 9, 9)).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 527, 32767).addGap(4, 4, 4))).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(9, 9, 9).addComponent(this.jLabNbTable, -2, 165, -2)).addGroup(jPanel5Layout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel2, -1, -1, 32767).addComponent(this.jPanel1, -1, -1, 32767)))).addContainerGap()));
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
/* 806 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel6).addComponent(this.jCBTable, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -1, 516, 32767)).addGroup(GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup().addComponent(this.jLabNbTable).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel1, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jPanel2, -2, -1, -2))).addContainerGap()));
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
/* 826 */     this.jSplitPane2.setRightComponent(this.jPanel5);
/*     */     
/* 828 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 829 */     getContentPane().setLayout(layout);
/* 830 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSplitPane2, GroupLayout.Alignment.TRAILING, -1, 992, 32767));
/*     */     
/*     */ 
/*     */ 
/* 834 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jSplitPane2, -1, 566, 32767));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 839 */     pack();
/*     */   }
/*     */   
/*     */   private void jCBTableItemStateChanged(ItemEvent evt) {
/* 843 */     afficherListeAttribut((Table)this.jCBTable.getSelectedItem());
/*     */   }
/*     */   
/*     */   private void jBtConnecterActionPerformed(ActionEvent evt) {
/* 847 */     if (getDataBase().getConnection() != null) {
/*     */       try {
/* 849 */         if (getDataBase().getConnection().isClosed()) {
/* 850 */           FormeConnexion f = new FormeConnexion(this.frm, true, getDataBase(), getDataBase().getConnection());
/* 851 */           f.setVisible(true);
/* 852 */           getDataBase().remplirTableAttribut();
/* 853 */           if (getDataBase() != null) {
/* 854 */             remplirInformation(getDataBase().getName(), getDataBase().getTypeSQL());
/*     */           }
/* 856 */           getExplorerBD().supprimerTout();
/* 857 */           getExplorerBD().ajouterBase(getDataBase());
/*     */         }
/* 859 */         else if (javax.swing.JOptionPane.showConfirmDialog(this, "Vous êtes déjà connecté !!.\n Voulez vous vous déconnecter ?", "Connexion ", 0) == 0) {
/* 860 */           FormeConnexion f = new FormeConnexion(this.frm, true, getDataBase(), getDataBase().getConnection());
/* 861 */           f.setVisible(true);
/* 862 */           getDataBase().remplirTableAttribut();
/* 863 */           if (getDataBase() != null) {
/* 864 */             remplirInformation(getDataBase().getName(), getDataBase().getTypeSQL());
/*     */           }
/*     */           
/* 867 */           remplirListeTable();
/* 868 */           getExplorerBD().supprimerTout();
/* 869 */           getExplorerBD().ajouterBase(getDataBase());
/*     */         }
/*     */       }
/*     */       catch (Exception e) {}
/*     */     }
/*     */     else
/*     */     {
/* 876 */       FormeConnexion f = new FormeConnexion(this.frm, true, getDataBase(), getDataBase().getConnection());
/* 877 */       f.setVisible(true);
/* 878 */       getDataBase().remplirTableAttribut();
/* 879 */       if (getDataBase() != null) {
/* 880 */         remplirInformation(getDataBase().getName(), getDataBase().getTypeSQL());
/*     */       }
/*     */       
/* 883 */       remplirListeTable();
/* 884 */       getExplorerBD().supprimerTout();
/* 885 */       getExplorerBD().ajouterBase(getDataBase());
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBtLegendeActionPerformed(ActionEvent evt) {
/* 890 */     new formes.FormeLegendeRetro(this.frm, true).setVisible(true);
/*     */   }
/*     */   
/*     */   private void jBtImporterActionPerformed(ActionEvent evt) {
/* 894 */     if (getDataBase().getConnection() != null) getDataBase().getListeTable();
/* 895 */     getDataBase().remplirTableAttribut();
/*     */     
/* 897 */     remplirListeTable();
/* 898 */     getExplorerBD().supprimerTout();
/* 899 */     getExplorerBD().ajouterBase(getDataBase());
/*     */   }
/*     */   
/*     */   private void jBtConstruireActionPerformed(ActionEvent evt)
/*     */   {
/* 904 */     Principale.testActiverJMerise();
/* 905 */     this.frm.verifierSettingActivation();
/* 906 */     if ((!Principale.isActiverJMerise()) && 
/* 907 */       (this.dataBase.getTableList().size() > 0)) {
/* 908 */       javax.swing.JOptionPane.showMessageDialog(this, "Il faut activer cette version pour construire le MCD ! ");
/* 909 */       return;
/*     */     }
/*     */     
/*     */ 
/* 913 */     this.frm.creerNouveauProjet();
/* 914 */     construireMCD();
/* 915 */     this.frm.getPage().repaint();
/* 916 */     construireLesLiens();
/* 917 */     creerHeritage();
/* 918 */     this.frm.getPage().repaint();
/*     */     
/* 920 */     supprimerCleEtrangere();
/* 921 */     this.frm.getPage().repaint();
/*     */     
/* 923 */     this.frm.getExplorer().initialiserTree();
/* 924 */     this.frm.getPage().repaint();
/* 925 */     if (this.frm.getPage().getListeEntiteRelation().size() > 0) this.frm.getFormeMCD().setModifier(true);
/* 926 */     repositionnerMCD();
/* 927 */     this.frm.getPage().setSelected(false);
/* 928 */     this.frm.getPage().repaint();
/* 929 */     this.frm.getFormeMLD().getPageMld().effacerAllEntite();
/* 930 */     this.frm.getFormeSQL().getPanelsql().getPane().setText("");
/* 931 */     this.frm.getFormeXML().getPanelXML().getPane().setText("");
/* 932 */     this.frm.getFormeMCD().setVisible(true);
/* 933 */     this.frm.getFormeMCD().setModifier(true);
/*     */     try {
/* 935 */       this.frm.getFormeMCD().setIcon(false);
/*     */     } catch (java.beans.PropertyVetoException ex) {
/* 937 */       java.util.logging.Logger.getLogger(ExplorerPanBD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*     */     }
/* 939 */     this.frm.getFormeMCD().toFront();
/*     */   }
/*     */   
/*     */   private JPanel jPanel2;
/*     */   private JPanel jPanel5;
/*     */   private javax.swing.JScrollPane jScrollPane1;
/*     */   private JSplitPane jSplitPane2;
/*     */   
/*     */   private void jTable1KeyPressed(KeyEvent evt) {}
/*     */   
/* 949 */   private void jTable1MouseClicked(MouseEvent evt) { if (this.jCBTable.getSelectedIndex() >= 0) {
/* 950 */       Table t = (Table)this.jCBTable.getSelectedItem();
/* 951 */       if (this.jTable1.getSelectedRow() >= 0)
/* 952 */         afficherColonne((Column)t.getColumnList().get(this.jTable1.getSelectedRow()));
/*     */     } }
/*     */   
/*     */   private JTextField jTFNom;
/*     */   private JTextField jTFTaille;
/*     */   private JTextField jTFType;
/*     */   private JTable jTable1;
/* 959 */   private void jTable1KeyReleased(KeyEvent evt) { if (this.jCBTable.getSelectedIndex() >= 0) {
/* 960 */       Table t = (Table)this.jCBTable.getSelectedItem();
/* 961 */       if (this.jTable1.getSelectedRow() >= 0) {
/* 962 */         afficherColonne((Column)t.getColumnList().get(this.jTable1.getSelectedRow()));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBtConstruirePartielActionPerformed(ActionEvent evt) {}
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\ihm\FormeInterneRetro.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */