/*     */ package IhmMCD;
/*     */ 
/*     */ import java.awt.Graphics;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class IhmEntiteRelation
/*     */   implements Serializable
/*     */ {
/*     */   private Point p0;
/*     */   private int width;
/*     */   private int height;
/*     */   private Point centre;
/*     */   private boolean selected;
/*     */   private boolean ombre;
/*     */   private boolean variable;
/*     */   private boolean clDegradee;
/*     */   
/*     */   public IhmEntiteRelation(Point p0, int width, int hight, boolean isvariable)
/*     */   {
/*  26 */     this.p0 = p0;
/*  27 */     this.width = width;
/*  28 */     this.height = hight;
/*  29 */     this.centre = calculerCentre();
/*  30 */     this.selected = true;
/*  31 */     this.ombre = true;
/*  32 */     this.clDegradee = true;
/*  33 */     this.variable = isvariable;
/*     */   }
/*     */   
/*     */   public IhmEntiteRelation(int x, int y, int width, int hight, boolean isvariable) {
/*  37 */     this.p0 = new Point(x, y);
/*  38 */     this.width = width;
/*  39 */     this.height = hight;
/*  40 */     this.centre = calculerCentre();
/*  41 */     this.ombre = true;
/*  42 */     this.variable = isvariable;
/*  43 */     this.clDegradee = true;
/*     */   }
/*     */   
/*     */   private Point calculerCentre() {
/*  47 */     return new Point(this.p0.getX() + getWidth() / 2, this.p0.getY() + getHeight() / 2);
/*     */   }
/*     */   
/*     */   public int getX() {
/*  51 */     return this.p0.getX();
/*     */   }
/*     */   
/*     */   public int getY()
/*     */   {
/*  56 */     return this.p0.getY();
/*     */   }
/*     */   
/*     */   public int getCentreX() {
/*  60 */     return this.centre.getX();
/*     */   }
/*     */   
/*     */   public int getCentreY() {
/*  64 */     return this.centre.getY();
/*     */   }
/*     */   
/*     */   public boolean isSelected() {
/*  68 */     return this.selected;
/*     */   }
/*     */   
/*     */   public Point getCentre() {
/*  72 */     return this.centre;
/*     */   }
/*     */   
/*     */   public int getHeight() {
/*  76 */     return this.height;
/*     */   }
/*     */   
/*     */   public Point getP0() {
/*  80 */     return this.p0;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/*  84 */     return this.width;
/*     */   }
/*     */   
/*     */   public void setCentre(Point centre) {
/*  88 */     this.centre = centre;
/*     */   }
/*     */   
/*     */   public void setCentreX(int centreX) {
/*  92 */     this.centre.setX(centreX);
/*     */   }
/*     */   
/*     */   public void setCentreY(int centreY) {
/*  96 */     this.centre.setY(centreY);
/*     */   }
/*     */   
/*     */   public void setX(int p0X) {
/* 100 */     this.p0.setX(p0X);
/* 101 */     this.centre = calculerCentre();
/*     */   }
/*     */   
/*     */   public void setY(int p0Y) {
/* 105 */     this.p0.setY(p0Y);
/* 106 */     this.centre = calculerCentre();
/*     */   }
/*     */   
/*     */   public void setP0(Point p0) {
/* 110 */     this.p0 = p0;
/*     */   }
/*     */   
/*     */   public void setHeight(int hight) {
/* 114 */     this.height = hight;
/* 115 */     this.centre = calculerCentre();
/*     */   }
/*     */   
/*     */   public void setWidth(int width)
/*     */   {
/* 120 */     this.width = width;
/* 121 */     this.centre = calculerCentre();
/*     */   }
/*     */   
/*     */   public void setSelected(boolean selected) {
/* 125 */     this.selected = selected;
/*     */   }
/*     */   
/*     */   public void redimentionner(int x, int y, int width, int hight) {
/* 129 */     if (x >= 0) setX(x); else
/* 130 */       setX(0);
/* 131 */     if (y >= 0) setY(y); else
/* 132 */       setY(0);
/* 133 */     setHeight(hight);
/* 134 */     setWidth(width);
/*     */   }
/*     */   
/*     */   public boolean isSelected(int x, int y)
/*     */   {
/* 139 */     if ((this instanceof IhmRelation)) {
/* 140 */       if ((x > getX()) && (y > getY()) && (x < getX() + getWidth()) && (y < getY() + getHeight())) {
/* 141 */         this.selected = true;
/* 142 */         return true;
/*     */       }
/* 144 */       this.selected = false;
/* 145 */       return false;
/*     */     }
/* 147 */     if ((this instanceof IhmCadre)) {
/* 148 */       if ((x > getX()) && (y > getY()) && (x < getX() + getWidth() + 7) && (y < getY() + getHeight() + 7)) {
/* 149 */         this.selected = true;
/* 150 */         return true;
/*     */       }
/* 152 */       this.selected = false;
/* 153 */       return false;
/*     */     }
/* 155 */     if ((x > getX()) && (y > getY()) && (x < getX() + getWidth()) && (y < getY() + getHeight())) {
/* 156 */       this.selected = true;
/* 157 */       return true;
/*     */     }
/* 159 */     this.selected = false;
/* 160 */     return false;
/*     */   }
/*     */   
/*     */   public void setOmbre(boolean ombre)
/*     */   {
/* 165 */     this.ombre = ombre;
/*     */   }
/*     */   
/*     */   public boolean isOmbre() {
/* 169 */     return this.ombre;
/*     */   }
/*     */   
/*     */   public boolean isVariable() {
/* 173 */     return this.variable;
/*     */   }
/*     */   
/*     */   public void setVariable(boolean variable) {
/* 177 */     this.variable = variable;
/*     */   }
/*     */   
/*     */   public boolean isClDegradee() {
/* 181 */     return this.clDegradee;
/*     */   }
/*     */   
/*     */   public void setClDegradee(boolean clDegradee) {
/* 185 */     this.clDegradee = clDegradee;
/*     */   }
/*     */   
/*     */   public abstract void paint(Graphics paramGraphics);
/*     */   
/*     */   public String toString()
/*     */   {
/* 192 */     return super.toString();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmEntiteRelation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */