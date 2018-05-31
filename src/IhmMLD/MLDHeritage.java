/*    */ package IhmMLD;
/*    */ 
/*    */ import IhmMCD.IhmEntite;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MLDHeritage
/*    */ {
/*    */   private IhmEntite pere;
/*    */   private ArrayList<IhmEntite> listeFils;
/*    */   
/*    */   public MLDHeritage(IhmEntite pere)
/*    */   {
/* 20 */     this.pere = pere;
/* 21 */     this.listeFils = new ArrayList();
/*    */   }
/*    */   
/*    */   public ArrayList<IhmEntite> getListeFils() {
/* 25 */     return this.listeFils;
/*    */   }
/*    */   
/*    */   public IhmEntite getPere() {
/* 29 */     return this.pere;
/*    */   }
/*    */   
/*    */   public void setListeFils(ArrayList<IhmEntite> listeFils) {
/* 33 */     this.listeFils = listeFils;
/*    */   }
/*    */   
/*    */   public void setPere(IhmEntite pere) {
/* 37 */     this.pere = pere;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMLD\MLDHeritage.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */