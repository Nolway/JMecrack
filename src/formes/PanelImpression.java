/*     */ package formes;
/*     */ 
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Insets;
/*     */ import java.awt.image.BufferedImage;
/*     */ import java.io.File;
/*     */ import javax.imageio.ImageIO;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.border.Border;
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
/*     */ public class PanelImpression
/*     */   extends JPanel
/*     */ {
/*     */   private BufferedImage image;
/*     */   
/*     */   public PanelImpression(BufferedImage image)
/*     */   {
/*  30 */     setImage(image);
/*  31 */     setSize(400, 400);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void recalculateAndResetSize()
/*     */   {
/*  38 */     int width = 0;
/*  39 */     int height = 0;
/*     */     
/*  41 */     if (this.image != null) {
/*  42 */       width += getWidth() * 1;
/*  43 */       height += getHeight() * 1;
/*     */     }
/*  45 */     Dimension size = new Dimension(width, height);
/*  46 */     setSize(size);
/*  47 */     setMinimumSize(size);
/*  48 */     setPreferredSize(size);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setImage(BufferedImage image)
/*     */   {
/*  60 */     this.image = image;
/*  61 */     recalculateAndResetSize();
/*  62 */     repaint();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public BufferedImage getImage()
/*     */   {
/*  70 */     return this.image;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setScale(int value)
/*     */   {
/*  78 */     recalculateAndResetSize();
/*  79 */     repaint();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getScale()
/*     */   {
/*  87 */     return 1;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setBorder(Border border)
/*     */   {
/*  93 */     super.setBorder(border);
/*  94 */     recalculateAndResetSize();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void paintComponent(Graphics graphics)
/*     */   {
/* 107 */     if (this.image != null) {
/* 108 */       Insets insets = getInsets();
/* 109 */       Dimension size = getSize();
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
/* 121 */       graphics.drawImage(this.image, 0, 0, getWidth(), getHeight(), null);
/*     */     }
/*     */   }
/*     */   
/*     */   public static PanelImpression getPanelImpression(String cheminLib)
/*     */     throws Exception
/*     */   {
/* 128 */     BufferedImage image = ImageIO.read(new File(cheminLib));
/* 129 */     PanelImpression pan = new PanelImpression(image);
/* 130 */     return pan;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\PanelImpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */