/*    */ package IhmMCD;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.awt.Graphics2D;
/*    */ import java.awt.geom.GeneralPath;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Grid
/*    */ {
/*    */   private int width;
/*    */   private int height;
/* 21 */   public static int cellSize = 50;
/*    */   
/* 23 */   private Color strongColor = new Color(235, 235, 235);
/*    */   
/* 25 */   private Color weakColor = new Color(220, 220, 220);
/*    */   
/*    */   private GeneralPath backgroundGrid;
/*    */   
/*    */   private GeneralPath foregroundGrid;
/*    */   
/*    */   public Grid(int width, int height, int i)
/*    */   {
/* 33 */     this.width = width;
/* 34 */     this.height = height;
/* 35 */     if (i == 1)
/*    */     {
/* 37 */       this.strongColor = new Color(235, 235, 235);
/*    */       
/* 39 */       this.weakColor = new Color(220, 220, 220);
/*    */     }
/*    */     else {
/* 42 */       this.strongColor = new Color(235, 255, 255);
/*    */       
/* 44 */       this.weakColor = new Color(220, 240, 240);
/*    */     }
/*    */   }
/*    */   
/*    */   public GeneralPath generateGrid(int numCells)
/*    */   {
/* 50 */     GeneralPath grid = new GeneralPath();
/*    */     
/* 52 */     for (float i = 0.0F; i <= this.width; i += cellSize / numCells) {
/* 53 */       grid.moveTo(i, 2.0F);
/* 54 */       grid.lineTo(i, this.height);
/*    */     }
/*    */     
/* 57 */     for (float i = 0.0F; i <= this.height; i += cellSize / numCells) {
/* 58 */       grid.moveTo(2.0F, i);
/* 59 */       grid.lineTo(this.width, i);
/*    */     }
/*    */     
/* 62 */     return grid;
/*    */   }
/*    */   
/*    */   public void drawGrid(Graphics2D g2)
/*    */   {
/* 67 */     if (this.backgroundGrid == null) {
/* 68 */       this.backgroundGrid = generateGrid(5);
/*    */     }
/* 70 */     g2.setPaint(this.strongColor);
/* 71 */     g2.draw(this.backgroundGrid);
/*    */     
/* 73 */     if (this.foregroundGrid == null) {
/* 74 */       this.foregroundGrid = generateGrid(1);
/*    */     }
/* 76 */     g2.setPaint(this.weakColor);
/* 77 */     g2.draw(this.foregroundGrid);
/*    */   }
/*    */   
/*    */   public void setHeight(int height) {
/* 81 */     this.height = height;
/*    */   }
/*    */   
/*    */   public void setWidth(int width) {
/* 85 */     this.width = width;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\Grid.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */