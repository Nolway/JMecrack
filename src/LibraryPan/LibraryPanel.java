/*     */ package LibraryPan;
/*     */ 
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import MenuPop.PopMenuLibrarie;
/*     */ import Merise.Entite;
/*     */ import Merise.Relation;
/*     */ import Outil.Parametres;
/*     */ import Outil.Setting;
/*     */ import formes2.FormeEntite2;
/*     */ import ihm.Principale;
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.Stroke;
/*     */ import java.awt.datatransfer.DataFlavor;
/*     */ import java.awt.datatransfer.Transferable;
/*     */ import java.awt.datatransfer.UnsupportedFlavorException;
/*     */ import java.awt.dnd.DragGestureEvent;
/*     */ import java.awt.dnd.DragGestureListener;
/*     */ import java.awt.dnd.DragSource;
/*     */ import java.awt.dnd.DragSourceDragEvent;
/*     */ import java.awt.dnd.DragSourceDropEvent;
/*     */ import java.awt.dnd.DragSourceEvent;
/*     */ import java.awt.dnd.DragSourceListener;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseMotionListener;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.geom.Rectangle2D.Double;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LibraryPanel
/*     */   extends JPanel
/*     */   implements MouseListener, MouseMotionListener, DragGestureListener, DragSourceListener, Transferable
/*     */ {
/*     */   public Library model;
/*  50 */   public static int heightModel = 80;
/*     */   public int numModel;
/*     */   private PopMenuLibrarie menu;
/*     */   private Principale frmMain;
/*     */   private Font font;
/*     */   int numAction;
/*     */   Color couleurSel;
/*     */   int xSouris;
/*     */   int ySouris;
/*  59 */   protected Color fillColor = new Color(175, 203, 229, 90);
/*  60 */   protected Color fillColorClaire = new Color(250, 250, 250, 190);
/*     */   
/*  62 */   protected Color strokeColor = Color.BLUE;
/*     */   
/*     */   public LibraryPanel(Library model, Principale frmMain)
/*     */   {
/*  66 */     this.model = model;
/*     */     
/*  68 */     this.numModel = -1;
/*  69 */     this.numAction = 0;
/*  70 */     this.frmMain = frmMain;
/*  71 */     this.menu = new PopMenuLibrarie(this, frmMain);
/*     */     
/*  73 */     this.font = Parametres.fontGras;
/*  74 */     addMouseListener(this);
/*  75 */     addMouseMotionListener(this);
/*  76 */     this.couleurSel = new Color(Integer.parseInt(Setting.couleurLibrairieSel));
/*     */   }
/*     */   
/*     */ 
/*     */   protected void paintComponent(Graphics g)
/*     */   {
/*  82 */     g.setColor(Color.white);
/*  83 */     g.setFont(this.font);
/*  84 */     g.fillRect(0, 0, (int)getSize().getWidth(), (int)getSize().getHeight());
/*  85 */     drawModel(g);
/*     */   }
/*     */   
/*     */   public void drawModel(Graphics g)
/*     */   {
/*  90 */     if (this.model != null) {
/*  91 */       int y = 10;
/*     */       
/*  93 */       for (int i = 0; i < this.model.getListModels().size(); i++)
/*     */       {
/*  95 */         Graphics2D g2 = (Graphics2D)g.create(27, y - 1, (int)getSize().getWidth() - 50, heightModel + 10);
/*  96 */         g2.scale(getScaleW((IhmEntiteRelation)this.model.getListModels().get(i)), getScaleH((IhmEntiteRelation)this.model.getListModels().get(i)));
/*     */         
/*  98 */         g2.setColor(Color.WHITE);
/*  99 */         g2.fillRect(0, 0, (int)getSize().getWidth(), heightModel);
/*     */         
/* 101 */         dessinerModel(g2, (IhmEntiteRelation)this.model.getListModels().get(i), (int)getSize().getWidth(), heightModel);
/*     */         
/*     */ 
/* 104 */         if (i == this.numModel) drawRectangleSelect(g, y, true); else
/* 105 */           drawRectangleSelect(g, y, false);
/* 106 */         y = y + heightModel + 20;
/* 107 */         g.setColor(Color.BLACK);
/* 108 */         drawName(g, getName((IhmEntiteRelation)this.model.getListModels().get(i)), y);
/*     */         
/* 110 */         y += 20;
/*     */       }
/*     */       
/* 113 */       int w = (int)getSize().getWidth();
/* 114 */       int h = (int)getSize().getHeight();
/* 115 */       if (h < y) { h = y;
/*     */       }
/*     */       
/* 118 */       setPreferredSize(new Dimension((int)getSize().getSize().getWidth(), h));
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerModel(Graphics2D g, IhmEntiteRelation m, int wg, int hg) {
/* 123 */     if ((m instanceof IhmEntite2)) {
/* 124 */       dessinerEntite(g, (IhmEntite2)m, wg, hg);
/*     */     }
/* 126 */     if ((m instanceof IhmRelation2)) {
/* 127 */       dessinerRelation(g, (IhmRelation2)m, wg, hg);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerEntite(Graphics2D g, IhmEntite2 ent, int wg, int hg) {
/* 132 */     ent.ajousterTaille(g);
/* 133 */     int wE = ent.getWidth();
/* 134 */     int hE = ent.getHeight();
/* 135 */     ent.setY((hg - hE) / 2);
/* 136 */     if (wE < wg) {
/* 137 */       ent.setX((wg - wE) / 2 - 23);
/*     */     }
/*     */     else {
/* 140 */       ent.setX(-25);
/*     */     }
/*     */     
/* 143 */     ent.paint(g);
/*     */   }
/*     */   
/*     */   private void dessinerRelation(Graphics2D g, IhmRelation2 rel, int wg, int hg)
/*     */   {
/* 148 */     rel.ajousterTaille(g);
/* 149 */     int wE = rel.getWidth();
/* 150 */     int hE = rel.getHeight();
/* 151 */     rel.setY((hg - hE) / 2);
/* 152 */     if (wE < wg) {
/* 153 */       rel.setX((wg - wE) / 2 - 23);
/*     */     }
/*     */     else
/*     */     {
/* 157 */       rel.setX(-25);
/*     */     }
/* 159 */     rel.paint(g);
/*     */   }
/*     */   
/*     */   private void dessinerFleches(Graphics g, int x, int y, int w, int h)
/*     */   {
/* 164 */     Graphics2D g2 = (Graphics2D)g;
/* 165 */     this.numAction = -1;
/*     */     
/* 167 */     Font f = g2.getFont();
/* 168 */     g2.setFont(Parametres.fontGras);
/* 169 */     x += 4;
/* 170 */     y += 4;
/* 171 */     Stroke st = g2.getStroke();
/* 172 */     Rectangle2D rec = new Rectangle2D.Double(x, y + 2, 24.0D, 20.0D);
/* 173 */     g2.setStroke(new BasicStroke(1.0F));
/* 174 */     if (this.numModel > 0) {
/* 175 */       if (Setting.afficherOptionSelectionLib) {
/* 176 */         g2.setPaint(this.fillColor);
/* 177 */         g2.fill(rec);
/* 178 */         g2.setPaint(this.strokeColor);
/* 179 */         g2.draw(rec);
/*     */         
/* 181 */         dessinerFlecheHautBas(g, x, y + 2, 24, 20, "HAUT");
/*     */       }
/* 183 */       if (rec.contains(this.xSouris, this.ySouris)) {
/* 184 */         g2.setPaint(this.fillColor);
/* 185 */         g2.fill(rec);
/* 186 */         g2.setPaint(this.strokeColor);
/* 187 */         g2.draw(rec);
/* 188 */         this.numAction = 1;
/* 189 */         dessinerFlecheHautBas(g, x, y + 2, 24, 20, "HAUT");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 196 */     int xx = x - 4;
/*     */     
/* 198 */     xx = x + w - 24;
/* 199 */     rec = new Rectangle2D.Double(xx, y + 2, 24.0D, 20.0D);
/* 200 */     if (Setting.afficherOptionSelectionLib) {
/* 201 */       g2.setPaint(this.fillColor);
/* 202 */       g2.fill(rec);
/* 203 */       g2.setPaint(Color.BLACK);
/* 204 */       g2.draw(rec);
/* 205 */       g2.drawString("P", xx + 7, y + 14 + 2);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 211 */     if (rec.contains(this.xSouris, this.ySouris)) {
/* 212 */       g2.setPaint(this.fillColor);
/* 213 */       g2.fill(rec);
/* 214 */       g2.setPaint(Color.BLACK);
/* 215 */       g2.draw(rec);
/* 216 */       g2.drawString("P", xx + 7, y + 14 + 2);
/* 217 */       this.numAction = 3;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 222 */     y = y + h - 29;
/* 223 */     rec = new Rectangle2D.Double(x, y - 2, 24.0D, 20.0D);
/* 224 */     if (this.numModel < getModel().getListModels().size() - 1) {
/* 225 */       if (Setting.afficherOptionSelectionLib) {
/* 226 */         g2.setPaint(this.fillColor);
/* 227 */         g2.fill(rec);
/* 228 */         g2.setPaint(this.strokeColor);
/* 229 */         g2.draw(rec);
/* 230 */         dessinerFlecheHautBas(g, x, y - 2, 24, 20, "BAS");
/*     */       }
/*     */       
/*     */ 
/* 234 */       if (rec.contains(this.xSouris, this.ySouris)) {
/* 235 */         g2.setPaint(this.fillColor);
/* 236 */         g2.fill(rec);
/* 237 */         g2.setPaint(this.strokeColor);
/* 238 */         g2.draw(rec);
/* 239 */         dessinerFlecheHautBas(g, x, y - 2, 24, 20, "BAS");
/*     */         
/* 241 */         this.numAction = 2;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 246 */     rec = new Rectangle2D.Double(xx, y - 2, 24.0D, 20.0D);
/*     */     
/* 248 */     if (Setting.afficherOptionSelectionLib) {
/* 249 */       g2.setPaint(this.fillColor);
/* 250 */       g2.fill(rec);
/* 251 */       g2.setPaint(Color.RED);
/* 252 */       g2.draw(rec);
/* 253 */       g2.drawString("X", xx + 7, y + 14 - 2);
/*     */     }
/*     */     
/* 256 */     if (rec.contains(this.xSouris, this.ySouris)) {
/* 257 */       g2.setPaint(this.fillColor);
/* 258 */       g2.fill(rec);
/* 259 */       g2.setPaint(Color.RED);
/* 260 */       g2.draw(rec);
/* 261 */       g2.drawString("X", xx + 7, y + 14 - 2);
/* 262 */       this.numAction = 4;
/*     */     }
/* 264 */     g2.setStroke(st);
/* 265 */     g2.setFont(f);
/*     */   }
/*     */   
/*     */   private void drawRectangleSelect(Graphics g, int y, boolean sel) {
/* 269 */     if (sel) g.setColor(this.couleurSel); else
/* 270 */       g.setColor(Color.WHITE);
/* 271 */     int yy = y - 8;
/* 272 */     g.fillRect(14, yy, (int)getSize().getWidth() - 30, 4);
/*     */     
/* 274 */     g.fillRect(14, yy, 5, heightModel + 16);
/* 275 */     g.fillRect(14, yy + heightModel + 12, (int)getSize().getWidth() - 30, 4);
/* 276 */     g.fillRect((int)getSize().getWidth() - 20, yy, 4, heightModel + 16);
/* 277 */     if (sel) {
/* 278 */       dessinerFleches(g, 16, yy, (int)getSize().getWidth() - 42, heightModel + 16);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerFlecheHautBas(Graphics g, int x, int y, int w, int h, String dir) {
/* 283 */     Graphics2D g2 = (Graphics2D)g;
/* 284 */     if (dir.equals("HAUT"))
/*     */     {
/* 286 */       int[] tabX = { x + 1, x + w - 2, x + w / 2 };
/* 287 */       int[] tabY = { y + h - 2, y + h - 2, y + 2 };
/*     */       
/* 289 */       g2.setPaint(this.model.getCouleur());
/* 290 */       g2.fillPolygon(tabX, tabY, 3);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 295 */     if (dir.equals("BAS"))
/*     */     {
/* 297 */       int[] tabX = { x + 1, x + w - 2, x + w / 2 };
/* 298 */       int[] tabY = { y + 2, y + 2, y + h - 2 };
/* 299 */       g2.setPaint(this.model.getCouleur());
/* 300 */       g2.fillPolygon(tabX, tabY, 3);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void drawName(Graphics g, String name, int y)
/*     */   {
/* 309 */     Graphics2D g2 = (Graphics2D)g.create();
/* 310 */     int x = g2.getFontMetrics().stringWidth(name);
/* 311 */     x = ((int)getSize().getWidth() - x) / 2;
/* 312 */     g.drawString(name, x, y);
/*     */   }
/*     */   
/*     */   public String getName(IhmEntiteRelation model) {
/* 316 */     if ((model instanceof IhmEntite2)) {
/* 317 */       return ((IhmEntite2)model).getEntite().getNom();
/*     */     }
/* 319 */     if ((model instanceof IhmRelation2)) {
/* 320 */       return ((IhmRelation2)model).getRelation().getNom();
/*     */     }
/* 322 */     return "";
/*     */   }
/*     */   
/*     */ 
/*     */   public double getScaleW(IhmEntiteRelation mod)
/*     */   {
/* 328 */     return 1.0D;
/*     */   }
/*     */   
/*     */ 
/*     */   public double getScaleH(IhmEntiteRelation mod)
/*     */   {
/* 334 */     return 1.0D;
/*     */   }
/*     */   
/*     */   private int setHeight()
/*     */   {
/* 339 */     int h = 20 + this.model.getListModels().size() * (heightModel + 30);
/* 340 */     return h;
/*     */   }
/*     */   
/*     */   public Library getModel() {
/* 344 */     return this.model;
/*     */   }
/*     */   
/*     */   public void setModel(Library mod) {
/* 348 */     this.model = mod;
/*     */   }
/*     */   
/*     */   public void setCouleurSel(Color couleurSel) {
/* 352 */     this.couleurSel = couleurSel;
/*     */   }
/*     */   
/*     */   public Principale getFrmMain() {
/* 356 */     return this.frmMain;
/*     */   }
/*     */   
/*     */   public boolean addModel(IhmEntiteRelation mod) {
/* 360 */     return this.model.addModel(mod);
/*     */   }
/*     */   
/*     */   public int getModelSelectedNum(int y, int x) {
/* 364 */     int h = 10;
/* 365 */     int hn = 0;
/* 366 */     if (x < 10) return -1;
/* 367 */     if (this.model == null) return -1;
/* 368 */     for (int i = 0; i < this.model.getListModels().size(); i++) {
/* 369 */       hn = 10 + (i + 1) * (heightModel + 40);
/* 370 */       if ((y >= h) && (y <= hn)) return i;
/* 371 */       h = hn;
/*     */     }
/* 373 */     return -1;
/*     */   }
/*     */   
/*     */   private void deplacerHaut(int pos) {
/* 377 */     if (pos > 0) {
/* 378 */       IhmEntiteRelation ent = (IhmEntiteRelation)this.model.getListModels().get(pos);
/* 379 */       this.model.getListModels().remove(pos);
/* 380 */       this.model.getListModels().add(pos - 1, ent);
/*     */     }
/*     */   }
/*     */   
/*     */   private void deplacerBas(int pos) {
/* 385 */     if (pos < this.model.getListModels().size()) {
/* 386 */       IhmEntiteRelation ent = (IhmEntiteRelation)this.model.getListModels().get(pos);
/* 387 */       this.model.getListModels().remove(pos);
/* 388 */       this.model.getListModels().add(pos + 1, ent);
/*     */     }
/*     */   }
/*     */   
/*     */   public void cacherAttribut(IhmEntiteRelation ent) {
/* 393 */     if ((ent instanceof IhmEntite2)) {
/* 394 */       this.frmMain.getPage().cacherAttribut((IhmEntite2)ent);
/*     */     }
/* 396 */     if ((ent instanceof IhmRelation2)) {
/* 397 */       this.frmMain.getPage().cacherAttribut((IhmRelation2)ent);
/*     */     }
/*     */   }
/*     */   
/*     */   private void setNomEntite(IhmEntite2 ent, String nom) {
/* 402 */     ent.getEntite().setNom(nom);
/*     */   }
/*     */   
/*     */   private void setNomEntite(IhmRelation2 ent, String nom) {
/* 406 */     ent.getRelation().setNom(nom);
/*     */   }
/*     */   
/*     */   private void setNomEntite(IhmEntiteRelation ent, String nom) {
/* 410 */     if ((ent instanceof IhmEntite2)) {
/* 411 */       setNomEntite((IhmEntite2)ent, nom);
/*     */     }
/* 413 */     if ((ent instanceof IhmRelation2)) {
/* 414 */       setNomEntite((IhmRelation2)ent, nom);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean exiteEntite(IhmEntite2 ent) {
/* 419 */     String nom = ent.getEntite().getNom();
/* 420 */     for (int i = 0; i < this.model.getListModels().size(); i++) {
/* 421 */       if ((ent != this.model.getListModels().get(i)) && 
/* 422 */         (nom.trim().toUpperCase().equals(getName((IhmEntiteRelation)this.model.getListModels().get(i)).trim().toUpperCase()))) {
/* 423 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 427 */     return false;
/*     */   }
/*     */   
/*     */   private boolean exiteEntite(IhmRelation2 ent) {
/* 431 */     String nom = ent.getRelation().getNom();
/* 432 */     for (int i = 0; i < this.model.getListModels().size(); i++) {
/* 433 */       if ((ent != this.model.getListModels().get(i)) && 
/* 434 */         (nom.trim().toUpperCase().equals(getName((IhmEntiteRelation)this.model.getListModels().get(i)).trim().toUpperCase()))) {
/* 435 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 439 */     return false;
/*     */   }
/*     */   
/*     */   private boolean existeEntiteRelation(IhmEntiteRelation entRel) {
/* 443 */     if ((entRel instanceof IhmEntite2)) {
/* 444 */       return exiteEntite((IhmEntite2)entRel);
/*     */     }
/* 446 */     if ((entRel instanceof IhmRelation2)) {
/* 447 */       return exiteEntite((IhmRelation2)entRel);
/*     */     }
/* 449 */     return false;
/*     */   }
/*     */   
/*     */   public void corrigeNomEntite(IhmEntiteRelation entRel) {
/* 453 */     String nom = getName(entRel);
/* 454 */     int i = 1;
/* 455 */     while (existeEntiteRelation(entRel)) {
/* 456 */       nom = nom + i;
/* 457 */       i++;
/* 458 */       setNomEntite(entRel, nom);
/*     */     }
/*     */   }
/*     */   
/*     */   public IhmEntiteRelation getModelSelected()
/*     */   {
/* 464 */     if (this.numModel == -1) return null;
/* 465 */     return (IhmEntiteRelation)this.model.getListModels().get(this.numModel);
/*     */   }
/*     */   
/*     */ 
/*     */   public void mouseClicked(MouseEvent e) {}
/*     */   
/*     */   public void mousePressed(MouseEvent e)
/*     */   {
/* 473 */     if (e.isControlDown()) {
/* 474 */       this.frmMain.getPage().insererDansLaLibrairie();
/* 475 */       return;
/*     */     }
/* 477 */     if (e.getButton() == 1) {
/* 478 */       this.numModel = getModelSelectedNum(e.getY(), e.getX());
/* 479 */       repaint();
/* 480 */       if (e.getClickCount() == 2) {
/* 481 */         if (this.numModel >= 0) {
/* 482 */           new FormeEntite2(this.frmMain, true, this.model.getListModels().get(this.numModel), new ArrayList(), "VISUALISER").setVisible(true);
/* 483 */           IhmEntiteRelation entRel = (IhmEntiteRelation)this.model.getListModels().get(this.numModel);
/* 484 */           cacherAttribut(entRel);
/* 485 */           corrigeNomEntite(entRel);
/* 486 */           if (!this.model.saveLib()) {
/* 487 */             JOptionPane.showMessageDialog(this.frmMain, "Erreur est survenue lors de la sauvegade de la librairie", "Sauvegarde", 0);
/*     */           }
/*     */         } else {
/* 490 */           new FormeProprieteLibrairie(this.frmMain, true, this.model).setVisible(true);
/* 491 */           repaint();
/*     */         }
/*     */       } else {
/* 494 */         if (this.numAction == 1) {
/* 495 */           deplacerHaut(this.numModel);
/* 496 */           if (!this.model.saveLib()) {
/* 497 */             JOptionPane.showMessageDialog(this.frmMain, "Erreur est survenue lors de la sauvegade de la librairie", "Sauvegarde", 0);
/*     */           }
/*     */         }
/*     */         
/* 501 */         if (this.numAction == 2)
/*     */         {
/* 503 */           deplacerBas(this.numModel);
/* 504 */           if (!this.model.saveLib()) {
/* 505 */             JOptionPane.showMessageDialog(this.frmMain, "Erreur est survenue lors de la sauvegade de la librairie", "Sauvegarde", 0);
/*     */           }
/*     */         }
/*     */         
/* 509 */         if (this.numAction == 3)
/*     */         {
/* 511 */           new FormeEntite2(this.frmMain, true, this.model.getListModels().get(this.numModel), new ArrayList(), "VISUALISER").setVisible(true);
/* 512 */           IhmEntiteRelation entRel = (IhmEntiteRelation)this.model.getListModels().get(this.numModel);
/* 513 */           cacherAttribut(entRel);
/* 514 */           corrigeNomEntite(entRel);
/* 515 */           if (!this.model.saveLib()) {
/* 516 */             JOptionPane.showMessageDialog(this.frmMain, "Erreur est survenue lors de la sauvegade de la librairie", "Sauvegarde", 0);
/*     */           }
/*     */         }
/*     */         
/* 520 */         if (this.numAction == 4)
/*     */         {
/* 522 */           if (JOptionPane.showConfirmDialog(this.frmMain, "Êtes vous sûr de vouloir supprimer \n" + getName((IhmEntiteRelation)getModel().getListModels().get(this.numModel)) + " de la librairie " + getModel().getName() + " ?", "Suppression", 0) == 0) {
/* 523 */             this.model.getListModels().remove(this.numModel);
/* 524 */             if (!this.model.saveLib()) {
/* 525 */               JOptionPane.showMessageDialog(this.frmMain, "Erreur est survenue lors de la sauvegade de la librairie", "Sauvegarde", 0);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 532 */       repaint();
/*     */     }
/*     */     else {
/* 535 */       this.menu.show(this, e.getX(), e.getY());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void mouseReleased(MouseEvent e) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void mouseEntered(MouseEvent e) {}
/*     */   
/*     */ 
/*     */   public void mouseExited(MouseEvent e) {}
/*     */   
/*     */ 
/*     */   public void mouseDragged(MouseEvent e) {}
/*     */   
/*     */ 
/*     */   public void mouseMoved(MouseEvent e)
/*     */   {
/* 556 */     this.numModel = getModelSelectedNum(e.getY(), e.getX());
/* 557 */     if (this.numModel >= 0) {
/* 558 */       this.xSouris = e.getX();
/* 559 */       this.ySouris = e.getY();
/* 560 */       int y = e.getY() - 20 < 0 ? 0 : e.getY() - 20;
/* 561 */       int x = e.getX();
/* 562 */       scrollRectToVisible(new Rectangle(x, y, 1, 40));
/*     */     }
/* 564 */     repaint();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void dragEnter(DragSourceDragEvent dsde) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void dragOver(DragSourceDragEvent dsde) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void dropActionChanged(DragSourceDragEvent dsde) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void dragExit(DragSourceEvent dse) {}
/*     */   
/*     */ 
/*     */   public void dragDropEnd(DragSourceDropEvent dsde) {}
/*     */   
/*     */ 
/*     */   public void dragGestureRecognized(DragGestureEvent dge)
/*     */   {
/* 589 */     dge.startDrag(DragSource.DefaultCopyDrop, this);
/*     */   }
/*     */   
/*     */ 
/*     */   public DataFlavor[] getTransferDataFlavors()
/*     */   {
/* 595 */     return new DataFlavor[] { DataFlavor.stringFlavor };
/*     */   }
/*     */   
/*     */   public boolean isDataFlavorSupported(DataFlavor flavor) {
/* 599 */     return flavor.equals(DataFlavor.stringFlavor);
/*     */   }
/*     */   
/*     */   public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
/* 603 */     if (flavor.equals(DataFlavor.stringFlavor)) {
/* 604 */       String msg = "¤" + this.numModel;
/* 605 */       return new String(msg);
/*     */     }
/*     */     
/* 608 */     throw new UnsupportedFlavorException(flavor);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\LibraryPan\LibraryPanel.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */