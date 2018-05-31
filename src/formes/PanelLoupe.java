/*     */ package formes;
/*     */ 
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMLD.IhmPageMLD;
/*     */ import Outil.Parametres;
/*     */ import ihm.FormeInterneMCD;
/*     */ import ihm.FormeInterneMLD;
/*     */ import ihm.FormeInterneMerise;
/*     */ import ihm.Principale;
/*     */ import java.awt.BasicStroke;
/*     */ import java.awt.Color;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.Rectangle;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.awt.event.MouseListener;
/*     */ import java.awt.event.MouseMotionListener;
/*     */ import java.awt.geom.Rectangle2D;
/*     */ import java.awt.geom.Rectangle2D.Double;
/*     */ import java.awt.image.BufferedImage;
/*     */ import javax.swing.JPanel;
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
/*     */ public class PanelLoupe
/*     */   extends JPanel
/*     */   implements MouseListener, MouseMotionListener
/*     */ {
/*  46 */   BufferedImage imgPage = null;
/*     */   int xSel;
/*     */   int ySel;
/*     */   int wSel;
/*     */   int hSel;
/*     */   int xSouris;
/*     */   int ySouris;
/*  53 */   double wpour; double hpour; FormeInterneMerise frmInterne; Principale frm; protected Color fillColor = new Color(175, 203, 229, 90);
/*  54 */   protected Color strokeColor = Color.BLUE;
/*     */   
/*     */   public PanelLoupe(Principale frm, FormeInterneMerise frmInterne)
/*     */   {
/*  58 */     this.frmInterne = frmInterne;
/*  59 */     this.frm = frm;
/*  60 */     this.xSel = 5;
/*  61 */     this.ySel = 5;
/*  62 */     this.wSel = 100;
/*  63 */     this.hSel = 100;
/*  64 */     setBackground(Color.WHITE);
/*  65 */     setSize(200, 200);
/*  66 */     addMouseListener(this);
/*  67 */     addMouseMotionListener(this);
/*     */   }
/*     */   
/*     */   public void paint(Graphics g)
/*     */   {
/*  72 */     super.paint(g);
/*  73 */     Graphics2D g2d = (Graphics2D)g;
/*  74 */     if (this.imgPage != null) {
/*  75 */       g2d.drawImage(this.imgPage, 0, 0, getWidth(), getHeight(), null);
/*  76 */       calculPourcentage();
/*  77 */       dessinerCadreSelect(g);
/*     */     }
/*     */   }
/*     */   
/*     */   public void calculPourcentage()
/*     */   {
/*  83 */     if ((this.frmInterne instanceof FormeInterneMCD)) {
/*  84 */       this.wpour = (getWidth() / ((FormeInterneMCD)this.frmInterne).getPage().getWidth());
/*  85 */       this.hpour = (getHeight() / ((FormeInterneMCD)this.frmInterne).getPage().getHeight());
/*     */     }
/*  87 */     else if ((this.frmInterne instanceof FormeInterneMLD)) {
/*  88 */       this.wpour = (getWidth() / ((FormeInterneMLD)this.frmInterne).getPageMld().getWidth());
/*  89 */       this.hpour = (getHeight() / ((FormeInterneMLD)this.frmInterne).getPageMld().getHeight());
/*     */     }
/*     */     
/*     */ 
/*  93 */     this.wSel = ((int)(this.frmInterne.getWidth() * this.wpour) - 20);
/*  94 */     this.hSel = ((int)(this.frmInterne.getHeight() * this.hpour) - 30);
/*     */   }
/*     */   
/*     */   public void setFrm(Principale frm)
/*     */   {
/*  99 */     this.frm = frm;
/*     */   }
/*     */   
/*     */   public void setFrmInterne(FormeInterneMerise frmInterne) {
/* 103 */     this.frmInterne = frmInterne;
/* 104 */     if ((frmInterne instanceof FormeInterneMCD))
/* 105 */       this.imgPage = Parametres.pageToImage(((FormeInterneMCD)frmInterne).getPage());
/* 106 */     this.xSel = 5;
/* 107 */     this.ySel = 5;
/*     */   }
/*     */   
/*     */   public void setFrmInterne(FormeInterneMCD frmInterne) {
/* 111 */     this.frmInterne = frmInterne;
/* 112 */     this.imgPage = Parametres.pageToImage(frmInterne.getPage());
/* 113 */     this.xSel = 5;
/* 114 */     this.ySel = 5;
/* 115 */     repaint();
/*     */   }
/*     */   
/*     */   public void setFrmInterne(FormeInterneMLD frmInterne) {
/* 119 */     this.frmInterne = frmInterne;
/* 120 */     this.imgPage = Parametres.pageToImage(frmInterne.getPageMld());
/* 121 */     this.xSel = 5;
/* 122 */     this.ySel = 5;
/* 123 */     repaint();
/*     */   }
/*     */   
/*     */   public void setPage(IhmPageMCD page) {
/* 127 */     this.imgPage = Parametres.pageToImage(page);
/* 128 */     this.xSel = 5;
/* 129 */     this.ySel = 5;
/* 130 */     repaint();
/*     */   }
/*     */   
/*     */   public void setPage(IhmPageMLD page) {
/* 134 */     this.imgPage = Parametres.pageToImage(page);
/* 135 */     repaint();
/*     */   }
/*     */   
/*     */   private void dessinerCadreSelect(Graphics g) {
/* 139 */     Graphics2D g2 = (Graphics2D)g;
/* 140 */     Rectangle2D rec = new Rectangle2D.Double(this.xSel, this.ySel, this.wSel, this.hSel);
/* 141 */     g2.setStroke(new BasicStroke(2.0F));
/* 142 */     g2.setPaint(this.fillColor);
/* 143 */     g2.fill(rec);
/* 144 */     g2.setPaint(this.strokeColor);
/* 145 */     g2.draw(rec);
/*     */   }
/*     */   
/*     */   public void afficherSurfaceSel()
/*     */   {
/* 150 */     int x = this.xSel;
/* 151 */     int y = this.ySel;
/* 152 */     int w = this.wSel;
/* 153 */     int h = this.hSel;
/* 154 */     if (this.hpour != 0.0D) {
/* 155 */       y = (int)(this.ySel / this.hpour);
/* 156 */       h = (int)(this.hSel / this.hpour);
/*     */     }
/* 158 */     if (this.wpour != 0.0D) {
/* 159 */       x = (int)(this.xSel / this.wpour);
/* 160 */       w = (int)(this.wSel / this.wpour);
/*     */     }
/* 162 */     if ((this.frmInterne instanceof FormeInterneMCD)) {
/* 163 */       ((FormeInterneMCD)this.frmInterne).getPage().scrollRectToVisible(new Rectangle(x, y, w - 10, h - 10));
/*     */     }
/* 165 */     if ((this.frmInterne instanceof FormeInterneMLD)) {
/* 166 */       ((FormeInterneMLD)this.frmInterne).getPageMld().scrollRectToVisible(new Rectangle(x, y, w - 10, h - 10));
/*     */     }
/*     */   }
/*     */   
/*     */   private void deplacerSelection(int xx, int yy) {
/* 171 */     if (this.xSel + xx < 0) {
/* 172 */       this.xSel = 1;
/* 173 */       return;
/*     */     }
/* 175 */     if (this.ySel + yy < 0) {
/* 176 */       this.ySel = 1;
/* 177 */       return;
/*     */     }
/* 179 */     if (this.xSel + xx + this.wSel - getWidth() > 10) {
/* 180 */       this.xSel = (getWidth() - this.wSel - 15);
/* 181 */       return;
/*     */     }
/* 183 */     if (this.ySel + yy + this.hSel - getHeight() > 10) {
/* 184 */       this.ySel = (getHeight() - this.hSel - 15);
/* 185 */       return;
/*     */     }
/* 187 */     this.xSel += xx;
/* 188 */     this.ySel += yy;
/*     */   }
/*     */   
/*     */   public boolean isSelect(int x, int y) {
/* 192 */     if ((x > this.xSel) && (y > this.ySel) && (x < this.xSel + this.wSel) && (y < this.ySel + this.hSel)) return true;
/* 193 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void mouseClicked(MouseEvent e) {}
/*     */   
/*     */   public void mousePressed(MouseEvent e)
/*     */   {
/* 201 */     if (isSelect(e.getX(), e.getY())) {
/* 202 */       this.xSouris = e.getX();
/* 203 */       this.ySouris = e.getY();
/* 204 */       setCursor(new Cursor(13));
/*     */     }
/*     */   }
/*     */   
/*     */   public void mouseReleased(MouseEvent e)
/*     */   {
/* 210 */     setCursor(new Cursor(0));
/* 211 */     afficherSurfaceSel();
/*     */   }
/*     */   
/*     */ 
/*     */   public void mouseEntered(MouseEvent e) {}
/*     */   
/*     */ 
/*     */   public void mouseExited(MouseEvent e) {}
/*     */   
/*     */ 
/*     */   public void mouseDragged(MouseEvent e)
/*     */   {
/* 223 */     if (isSelect(e.getX(), e.getY())) {
/* 224 */       deplacerSelection(e.getX() - this.xSouris, e.getY() - this.ySouris);
/* 225 */       afficherSurfaceSel();
/* 226 */       this.xSouris = e.getX();
/* 227 */       this.ySouris = e.getY();
/* 228 */       repaint();
/*     */     }
/*     */   }
/*     */   
/*     */   public void mouseMoved(MouseEvent e) {}
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\PanelLoupe.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */