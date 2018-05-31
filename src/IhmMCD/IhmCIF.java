/*    */ package IhmMCD;
/*    */ 
/*    */ import ihm.FormeInterneMCD;
/*    */ import java.awt.Color;
/*    */ import java.awt.FontMetrics;
/*    */ import java.awt.Graphics;
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IhmCIF
/*    */   extends IhmEntiteRelation
/*    */   implements Serializable
/*    */ {
/*    */   private static Color clCIFCadre;
/*    */   private static Color clCIFFond;
/*    */   private static Color clString;
/*    */   
/*    */   public IhmCIF(int x, int y, int width, int hight)
/*    */   {
/* 23 */     super(x, y, width, hight, false);
/* 24 */     clCIFCadre = FormeInterneMCD.clCIFCadre;
/* 25 */     clCIFFond = FormeInterneMCD.clCIFFond;
/* 26 */     clString = FormeInterneMCD.clCIFText;
/* 27 */     setSelected(true);
/*    */   }
/*    */   
/*    */   public void paint(Graphics g)
/*    */   {
/* 32 */     calculerTaille(g);
/* 33 */     if (isOmbre()) dessinerOmbre(g);
/* 34 */     g.setColor(clCIFFond);
/* 35 */     g.fillOval(getX(), getY(), getWidth(), getHeight());
/* 36 */     g.setColor(clCIFCadre);
/* 37 */     g.drawOval(getX(), getY(), getWidth(), getHeight());
/*    */     
/* 39 */     g.setColor(clString);
/* 40 */     ecrireCif(g);
/*    */     
/* 42 */     if (isSelected() == true)
/*    */     {
/* 44 */       g.setColor(Color.red);
/* 45 */       g.drawOval(getX(), getY(), getWidth(), getHeight());
/*    */       
/* 47 */       ecrireCif(g);
/*    */       
/* 49 */       g.setColor(Color.BLACK);
/*    */     }
/*    */   }
/*    */   
/*    */   private void calculerTaille(Graphics g) {
/* 54 */     int wMax = g.getFontMetrics().stringWidth("CIFR");
/* 55 */     int h = g.getFontMetrics().getHeight();
/* 56 */     h += 2 * h / 3;
/* 57 */     redimentionner(getX(), getY(), wMax, h);
/*    */   }
/*    */   
/*    */   private void ecrireCif(Graphics g) {
/* 61 */     int h = g.getFontMetrics().getHeight();
/* 62 */     g.drawString("CIF", getX() + (getWidth() - g.getFontMetrics().stringWidth("CIF")) / 2, getY() + h + h / 4);
/*    */   }
/*    */   
/*    */   private void dessinerOmbre(Graphics g) {
/* 66 */     Color clgard = g.getColor();
/* 67 */     g.setColor(Color.GRAY);
/*    */     
/* 69 */     g.setColor(clgard);
/*    */   }
/*    */   
/*    */   public IhmCIF copier() {
/* 73 */     return new IhmCIF(getX(), getY(), getWidth(), getHeight());
/*    */   }
/*    */   
/*    */   public static void setClCIFCadre(Color clCIFCadre) {
/* 77 */     clCIFCadre = clCIFCadre;
/*    */   }
/*    */   
/*    */   public static void setClCIFFond(Color clCIFFond) {
/* 81 */     clCIFFond = clCIFFond;
/*    */   }
/*    */   
/*    */   public static void setClString(Color clString) {
/* 85 */     clString = clString;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\IhmCIF.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */