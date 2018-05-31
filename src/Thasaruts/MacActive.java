/*    */ package Thasaruts;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MacActive
/*    */   implements Serializable
/*    */ {
/*    */   String mac;
/*    */   boolean active;
/*    */   
/*    */   public MacActive(String mac, boolean active)
/*    */   {
/* 19 */     this.mac = mac;
/* 20 */     this.active = active;
/*    */   }
/*    */   
/*    */   public MacActive() {
/* 24 */     this.mac = "";
/* 25 */     this.active = false;
/*    */   }
/*    */   
/*    */   public boolean isActive() {
/* 29 */     return this.active;
/*    */   }
/*    */   
/*    */   public String getMac() {
/* 33 */     return this.mac;
/*    */   }
/*    */   
/*    */   public void setActive(boolean active) {
/* 37 */     this.active = active;
/*    */   }
/*    */   
/*    */   public void setMac(String mac) {
/* 41 */     this.mac = mac;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Thasaruts\MacActive.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */