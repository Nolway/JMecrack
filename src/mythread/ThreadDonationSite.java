/*    */ package mythread;
/*    */ 
/*    */ import ihm.Principale;
/*    */ import input.ActivityDay;
/*    */ import input.InfoSite;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ThreadDonationSite
/*    */   extends Thread
/*    */ {
/*    */   private Principale frm;
/*    */   
/*    */   public ThreadDonationSite(Principale frm)
/*    */   {
/* 20 */     this.frm = frm;
/* 21 */     start();
/*    */   }
/*    */   
/*    */   public void run()
/*    */   {
/* 26 */     String s = ActivityDay.getURLDontion(this.frm.getpF(), this.frm);
/* 27 */     s = InfoSite.dumpDonation(s);
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\mythread\ThreadDonationSite.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */