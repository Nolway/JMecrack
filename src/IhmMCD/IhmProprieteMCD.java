/*     */ package IhmMCD;
/*     */ 
/*     */ import Outil.ConfigSave;
/*     */ import Outil.Parametres;
/*     */ import Outil.ProprieteMCD;
/*     */ import ihm.FormeInterneMCD;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.GradientPaint;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ 
/*     */ 
/*     */ public class IhmProprieteMCD
/*     */   extends IhmEntiteRelation
/*     */ {
/*     */   public ProprieteMCD proprieteMCD;
/*     */   public FormeInterneMCD mcd;
/*     */   public int xDev;
/*     */   public int yDev;
/*     */   public int xDate;
/*     */   public int yDate;
/*     */   public int xmcd;
/*     */   public int ymcd;
/*  26 */   private static Color clCadre = Color.BLACK;
/*  27 */   private static Color clFond = Color.WHITE;
/*  28 */   private static Color clString = Color.BLACK;
/*  29 */   private static Font fontGras = Parametres.fontGras;
/*     */   private static Font fontNormal;
/*     */   
/*     */   public IhmProprieteMCD(ProprieteMCD proprieteMCD, FormeInterneMCD mcd) {
/*  33 */     super(2, 2, 10, 10, false);
/*  34 */     this.proprieteMCD = proprieteMCD;
/*  35 */     this.mcd = mcd;
/*  36 */     this.xDate = 0;
/*  37 */     this.xDev = 0;
/*  38 */     this.yDate = 0;
/*  39 */     this.yDev = 0;
/*  40 */     this.xmcd = 0;
/*  41 */     this.ymcd = 0;
/*     */   }
/*     */   
/*     */   public void paint(Graphics g) {
/*  45 */     int h = getHauteur(g);
/*  46 */     fontNormal = g.getFont();
/*  47 */     fontGras = Parametres.fontGras;
/*  48 */     calculerXYPropriete(g);
/*  49 */     if (this.mcd.getConfig().isIsOmbre()) dessinerOmbre(g);
/*  50 */     if (!FormeInterneMCD.getEtatColor().equals(Parametres.etatAUCUNEColor)) {
/*  51 */       clFond = Color.CYAN;
/*     */     } else {
/*  53 */       clFond = Color.WHITE;
/*     */     }
/*  55 */     g.setColor(clFond);
/*  56 */     if (this.mcd.getConfig().isIsDegradee()) {
/*  57 */       Graphics2D g2d = (Graphics2D)g;
/*  58 */       g2d.setPaint(new GradientPaint(getX(), getY(), clFond, getX() + getWidth(), getY() + getHeight(), Color.WHITE, true));
/*     */     }
/*  60 */     g.fillRect(getX(), getY(), getWidth(), getHeight());
/*  61 */     g.setColor(clCadre);
/*  62 */     g.drawRect(getX(), getY(), getWidth(), getHeight());
/*  63 */     ecrirePropriete(g, h);
/*     */   }
/*     */   
/*     */   private void ecrirePropriete(Graphics g, int h) {
/*  67 */     g.setColor(clString);
/*  68 */     g.drawString("MCD : " + this.mcd.getProjet().toString(), getX() + 2, this.ymcd);
/*     */     
/*     */ 
/*  71 */     g.drawString("Création : ", getX() + 2, this.ymcd + (int)(h * 1.5D));
/*  72 */     g.drawString("Modification : ", getX() + 2, this.ymcd + h * 3);
/*     */     
/*  74 */     String s = this.proprieteMCD.getCreateur() == null ? "" : this.proprieteMCD.getCreateur();
/*  75 */     g.drawString(s, this.xDev, this.ymcd + (int)(h * 1.5D));
/*     */     
/*  77 */     s = this.proprieteMCD.getDeveloppeur() == null ? "" : this.proprieteMCD.getDeveloppeur();
/*  78 */     g.drawString(s, this.xDev, this.ymcd + h * 3);
/*     */     
/*  80 */     s = this.proprieteMCD.getDateCreation() == null ? "" : this.proprieteMCD.getDateCreation();
/*  81 */     g.drawString(s, this.xDate, this.ymcd + (int)(h * 1.5D));
/*     */     
/*  83 */     s = this.proprieteMCD.getDateDerniereUtilisation() == null ? "" : this.proprieteMCD.getDateDerniereUtilisation();
/*  84 */     g.drawString(s, this.xDate, this.ymcd + h * 3);
/*  85 */     g.setColor(clCadre);
/*  86 */     g.drawLine(getX(), this.ymcd + h / 2, getX() + getWidth(), this.ymcd + h / 2);
/*     */   }
/*     */   
/*     */   public void dessinerOmbre(Graphics g) {
/*  90 */     g.setColor(Color.GRAY);
/*  91 */     g.fillRect(getX() + 4, getY() + 4, getWidth(), getHeight());
/*     */   }
/*     */   
/*     */   public void calculerXYPropriete(Graphics g) {
/*  95 */     int wmcd = g.getFontMetrics().stringWidth("MCD : M" + this.mcd.getProjet().toString());
/*  96 */     String cre = this.proprieteMCD.getCreateur() == null ? "" : this.proprieteMCD.getCreateur();
/*  97 */     String dev = this.proprieteMCD.getDeveloppeur() == null ? "" : this.proprieteMCD.getDeveloppeur();
/*  98 */     String s = dev.length() > cre.length() ? dev : cre;
/*     */     
/* 100 */     int h = g.getFontMetrics().getHeight();
/* 101 */     this.xDev = (getX() + g.getFontMetrics().stringWidth("Modification : M"));
/* 102 */     this.xDate = (this.xDev + g.getFontMetrics().stringWidth(s + "M"));
/*     */     
/* 104 */     cre = this.proprieteMCD.getDateCreation() == null ? "" : this.proprieteMCD.getDateCreation();
/* 105 */     dev = this.proprieteMCD.getDateDerniereUtilisation() == null ? "" : this.proprieteMCD.getDateDerniereUtilisation();
/* 106 */     s = dev.length() > cre.length() ? dev : cre;
/* 107 */     setWidth(this.xDate + g.getFontMetrics().stringWidth(s + "ME") - getX());
/* 108 */     if (wmcd > getWidth()) setWidth(wmcd);
/* 109 */     setHeight(h * 4 + 3);
/*     */     
/* 111 */     this.xmcd = (getX() + 3);
/* 112 */     this.ymcd = h;
/*     */   }
/*     */   
/*     */   public int getHauteur(Graphics g)
/*     */   {
/* 117 */     return g.getFontMetrics().getHeight();
/*     */   }
/*     */   
/*     */   public ProprieteMCD getProprieteMCD() {
/* 121 */     return this.proprieteMCD;
/*     */   }
/*     */   
/*     */   public void setProprieteMCD(ProprieteMCD proprieteMCD) {
/* 125 */     this.proprieteMCD = proprieteMCD;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmProprieteMCD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */