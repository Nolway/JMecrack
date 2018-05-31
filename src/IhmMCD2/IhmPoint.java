/*     */ package IhmMCD2;
/*     */ 
/*     */ import IhmMCD.Point;
/*     */ import java.awt.Color;
/*     */ import java.awt.Graphics2D;
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IhmPoint
/*     */   implements Serializable
/*     */ {
/*     */   private Point point;
/*     */   private boolean selected;
/*     */   private Point centre;
/*     */   private Color clFond;
/*     */   private Color clFondSelect;
/*     */   private int width;
/*     */   private int height;
/*     */   private boolean designer;
/*     */   private double zoom;
/*     */   String identifiant;
/*     */   
/*     */   public IhmPoint(int x, int y)
/*     */   {
/*  32 */     this.width = 8;
/*  33 */     this.height = 8;
/*     */     
/*  35 */     this.point = new Point(x - this.width / 2, y - this.height / 2);
/*  36 */     this.centre = new Point(x, y);
/*  37 */     this.selected = false;
/*  38 */     calculCentre();
/*  39 */     this.clFond = Color.BLACK;
/*  40 */     this.clFondSelect = Color.RED;
/*  41 */     this.designer = false;
/*  42 */     this.zoom = 1.0D;
/*  43 */     this.identifiant = "";
/*     */   }
/*     */   
/*     */   public Point getPoint() {
/*  47 */     return this.point;
/*     */   }
/*     */   
/*     */   public boolean isSelected() {
/*  51 */     return this.selected;
/*     */   }
/*     */   
/*     */   public void setPoint(Point point) {
/*  55 */     this.point = point;
/*     */   }
/*     */   
/*     */   public void paint(Graphics2D gr) {
/*  59 */     Graphics2D g2d = (Graphics2D)gr.create();
/*  60 */     g2d.scale(getZoom(), getZoom());
/*  61 */     if (!isSelected()) {
/*  62 */       if (isDesigner()) {
/*  63 */         gr.setColor(getClFond());
/*  64 */         gr.fillRect(this.point.getX(), this.point.getY(), this.width, this.height);
/*     */       }
/*     */     } else {
/*  67 */       gr.setColor(this.clFondSelect);
/*  68 */       gr.fillRect(this.point.getX(), this.point.getY(), this.width, this.height);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isSelected(int x, int y)
/*     */   {
/*  74 */     if ((getX() < x) && (getX() + getWidth() > x) && (getY() < y) && (getY() + getHeight() > y)) { return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public boolean estDans(int xd, int yd, int xf, int yf)
/*     */   {
/*  81 */     int x1 = xd;
/*  82 */     int x2 = xf;
/*  83 */     int y1 = yd;
/*  84 */     int y2 = yf;
/*  85 */     if (xd > xf) {
/*  86 */       x1 = xf;
/*  87 */       x2 = xd;
/*     */     }
/*  89 */     if (yd > yf) {
/*  90 */       y1 = yf;
/*  91 */       y2 = yd;
/*     */     }
/*     */     
/*     */ 
/*  95 */     if ((getX() > x1) && (getX() < x2) && (getY() > y1) && (getY() < y2) && (getX() + getWidth() > x1) && (getX() + getWidth() < x2) && (getY() + getHeight() > y1) && (getY() + getHeight() < y2))
/*     */     {
/*     */ 
/*     */ 
/*  99 */       return true;
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public void setSelected(boolean select) {
/* 105 */     this.selected = select;
/*     */   }
/*     */   
/*     */   public void move(int x, int y) {
/* 109 */     this.point.setX(x);
/* 110 */     this.point.setY(y);
/* 111 */     calculCentre();
/*     */   }
/*     */   
/*     */   public int getX() {
/* 115 */     return this.point.getX();
/*     */   }
/*     */   
/*     */   public void setX(int x) {
/* 119 */     this.point.setX(x);
/* 120 */     calculCentre();
/*     */   }
/*     */   
/*     */   public void setY(int y) {
/* 124 */     this.point.setY(y);
/* 125 */     calculCentre();
/*     */   }
/*     */   
/*     */   public double getZoom() {
/* 129 */     return this.zoom;
/*     */   }
/*     */   
/*     */   public int getY() {
/* 133 */     return this.point.getY();
/*     */   }
/*     */   
/*     */   public String getIdentifiant() {
/* 137 */     return this.identifiant;
/*     */   }
/*     */   
/*     */   public Point getCentre() {
/* 141 */     return this.centre;
/*     */   }
/*     */   
/*     */   public int getXCentre() {
/* 145 */     return this.centre.getX();
/*     */   }
/*     */   
/*     */   public int getYCentre() {
/* 149 */     return this.centre.getY();
/*     */   }
/*     */   
/*     */   public Color getClFond() {
/* 153 */     return this.clFond;
/*     */   }
/*     */   
/*     */   public int getHeight() {
/* 157 */     return this.height;
/*     */   }
/*     */   
/*     */   public int getWidth() {
/* 161 */     return this.width;
/*     */   }
/*     */   
/*     */   public Color getClFondSelect() {
/* 165 */     return this.clFondSelect;
/*     */   }
/*     */   
/*     */   public boolean isDesigner() {
/* 169 */     return this.designer;
/*     */   }
/*     */   
/*     */   public void calculCentre() {
/* 173 */     this.centre.setX(getX() + this.width / 2);
/* 174 */     this.centre.setY(getY() + this.height / 2);
/*     */   }
/*     */   
/*     */   public void setCentre(Point centre) {
/* 178 */     this.centre = centre;
/*     */   }
/*     */   
/*     */   public void setClFond(Color clFond) {
/* 182 */     this.clFond = clFond;
/*     */   }
/*     */   
/*     */   public void setZoom(double zoom) {
/* 186 */     this.zoom = zoom;
/*     */   }
/*     */   
/*     */   public void setIdentifiant(String identifiant) {
/* 190 */     this.identifiant = identifiant;
/*     */   }
/*     */   
/*     */   public void setClFondSelect(Color clFondSelect) {
/* 194 */     this.clFondSelect = clFondSelect;
/*     */   }
/*     */   
/*     */   public void setDesigner(boolean designer) {
/* 198 */     this.designer = designer;
/*     */   }
/*     */   
/*     */   public void setHeight(int height) {
/* 202 */     this.height = height;
/*     */   }
/*     */   
/*     */   public void setWidth(int width) {
/* 206 */     this.width = width;
/*     */   }
/*     */   
/*     */ 
/*     */   public IhmPoint copier()
/*     */   {
/* 212 */     IhmPoint p = new IhmPoint(getX(), getY());
/*     */     
/* 214 */     p.setSelected(isSelected());
/* 215 */     p.setClFond(getClFond());
/* 216 */     p.setClFondSelect(getClFondSelect());
/* 217 */     p.setDesigner(isDesigner());
/* 218 */     p.setZoom(getZoom());
/* 219 */     return p;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD2\IhmPoint.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */