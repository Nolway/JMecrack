/*    */ package IhmMCD;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Point
/*    */   implements Serializable
/*    */ {
/*    */   private int x;
/*    */   private int y;
/*    */   
/*    */   public Point(int x, int y)
/*    */   {
/* 19 */     this.x = x;
/* 20 */     this.y = y;
/*    */   }
/*    */   
/*    */   public int getX() {
/* 24 */     return this.x;
/*    */   }
/*    */   
/*    */   public int getY() {
/* 28 */     return this.y;
/*    */   }
/*    */   
/*    */   public void setX(int x) {
/* 32 */     this.x = x;
/*    */   }
/*    */   
/*    */   public void setY(int y) {
/* 36 */     this.y = y;
/*    */   }
/*    */   
/*    */   public Point copier() {
/* 40 */     return new Point(getX(), getY());
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\Point.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */