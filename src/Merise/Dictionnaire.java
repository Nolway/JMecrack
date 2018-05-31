/*    */ package Merise;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Dictionnaire
/*    */   implements Serializable
/*    */ {
/*    */   private ArrayList<Attribut> listeAtt;
/*    */   
/*    */   public Dictionnaire()
/*    */   {
/* 17 */     this.listeAtt = new ArrayList();
/*    */   }
/*    */   
/*    */   public ArrayList<Attribut> getListeAtt()
/*    */   {
/* 22 */     return this.listeAtt;
/*    */   }
/*    */   
/*    */   public void setListeAtt(ArrayList<Attribut> listeAtt) {
/* 26 */     this.listeAtt = listeAtt;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Merise\Dictionnaire.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */