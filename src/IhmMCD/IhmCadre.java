/*     */ package IhmMCD;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import java.awt.Color;
/*     */ import java.awt.GradientPaint;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IhmCadre
/*     */   extends IhmEntiteRelation
/*     */   implements Serializable
/*     */ {
/*     */   private Color clCadreCadre;
/*     */   private Color clCadreFond;
/*     */   private String clCadreCadreSt;
/*     */   private String clCadreFondSt;
/*     */   
/*     */   public IhmCadre(int x, int y, int width, int hight)
/*     */   {
/*  26 */     super(x, y, width, hight, false);
/*  27 */     setSelected(true);
/*  28 */     this.clCadreCadre = Color.BLUE;
/*  29 */     this.clCadreFond = Color.WHITE;
/*  30 */     this.clCadreCadreSt = getColeurString(this.clCadreCadre);
/*  31 */     this.clCadreFondSt = getColeurString(this.clCadreFond);
/*     */   }
/*     */   
/*     */   public void paint(Graphics g)
/*     */   {
/*  36 */     if (isOmbre()) dessinerOmbre(g);
/*  37 */     g.setColor(this.clCadreFond);
/*  38 */     Graphics2D g2d = (Graphics2D)g;
/*  39 */     if (isClDegradee()) g2d.setPaint(new GradientPaint(getX(), getY(), this.clCadreFond, getX() + getWidth(), getY() + getHeight(), Color.WHITE, true));
/*  40 */     g.fillRect(getX(), getY(), getWidth(), getHeight());
/*  41 */     g.setColor(this.clCadreCadre);
/*  42 */     g.drawRect(getX(), getY(), getWidth(), getHeight());
/*     */     
/*  44 */     if (isSelected() == true) {
/*  45 */       g.setColor(Color.red);
/*  46 */       g.drawRect(getX(), getY(), getWidth(), getHeight());
/*  47 */       g.setColor(Color.BLACK);
/*  48 */       g.fillRect(getX(), getY() + getHeight() / 2, 4, 4);
/*  49 */       g.fillRect(getX() + getWidth() / 2, getY() - 4, 4, 4);
/*  50 */       g.fillRect(getX() + getWidth() / 2, getY() + getHeight(), 4, 4);
/*  51 */       g.fillRect(getX() + getWidth() - 2, getY() + getHeight() / 2, 4, 4);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dessinerOmbre(Graphics g) {
/*  56 */     Color clgard = g.getColor();
/*  57 */     int n = Parametres.retournerVal(g, 2);
/*  58 */     g.setColor(Color.GRAY);
/*  59 */     g.fillRect(getX() + n, getY() + n, getWidth() + n, getHeight() + n);
/*  60 */     g.setColor(clgard);
/*     */   }
/*     */   
/*     */   public int aggrandir(int x, int y) {
/*  64 */     if ((x > getX()) && (y > getY() + getHeight() / 2) && (x < getX() + 4) && (y < getY() + getHeight() / 2 + 4)) return -1;
/*  65 */     if ((x > getX() + getWidth() / 2) && (y > getY() - 4) && (x < getX() + getWidth() / 2 + 4) && (y < getY())) return -1;
/*  66 */     if ((x > getX() + getWidth() - 4) && (y > getY()) && (x < getX() + getWidth() + 4) && (y < getY() + getHeight())) return 1;
/*  67 */     if ((x > getX()) && (y > getY() + getHeight() - 4) && (x < getX() + getWidth()) && (y < getY() + getHeight() + 4)) return 2;
/*  68 */     return -1;
/*     */   }
/*     */   
/*     */   private Color getCouleurs(String cl) {
/*  72 */     return new Color(Integer.parseInt(cl));
/*     */   }
/*     */   
/*     */   private String getColeurString(Color cl) {
/*  76 */     return cl.getRGB() + "";
/*     */   }
/*     */   
/*     */   public void initialiserCouleurCadre() {
/*  80 */     setClCadreCadre(getCouleurs(this.clCadreCadreSt));
/*  81 */     setClCadreFond(getCouleurs(this.clCadreFondSt));
/*     */   }
/*     */   
/*     */   public Color getClCadreCadre() {
/*  85 */     return this.clCadreCadre;
/*     */   }
/*     */   
/*     */   public Color getClCadreFond() {
/*  89 */     return this.clCadreFond;
/*     */   }
/*     */   
/*     */   public String getClCadreCadreSt() {
/*  93 */     return this.clCadreCadreSt;
/*     */   }
/*     */   
/*     */   public String getClCadreFondSt() {
/*  97 */     return this.clCadreFondSt;
/*     */   }
/*     */   
/*     */   public void setClCadreCadre(Color clCadreCadre) {
/* 101 */     this.clCadreCadre = clCadreCadre;
/*     */   }
/*     */   
/*     */   public void setClCadreFond(Color clCadreFond) {
/* 105 */     this.clCadreFond = clCadreFond;
/*     */   }
/*     */   
/*     */   public void setClCadreCadreSt(String clCadreCadreSt) {
/* 109 */     this.clCadreCadreSt = clCadreCadreSt;
/*     */   }
/*     */   
/*     */   public void setClCadreFondSt(String clCadreFondSt) {
/* 113 */     this.clCadreFondSt = clCadreFondSt;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmCadre.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */