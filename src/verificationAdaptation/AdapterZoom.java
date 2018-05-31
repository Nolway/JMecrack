/*    */ package verificationAdaptation;
/*    */ 
/*    */ import IhmMCD.IhmEntiteRelation;
/*    */ import IhmMCD.IhmPageMCD;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AdapterZoom
/*    */ {
/*    */   IhmPageMCD page;
/*    */   
/*    */   public static void adapterEntiteRelation(ArrayList<IhmEntiteRelation> liste, double zoom)
/*    */   {
/* 20 */     for (int i = 0; i < liste.size(); i++) {
/* 21 */       ((IhmEntiteRelation)liste.get(i)).redimentionner((int)(((IhmEntiteRelation)liste.get(i)).getX() / zoom), (int)(((IhmEntiteRelation)liste.get(i)).getY() / zoom), ((IhmEntiteRelation)liste.get(i)).getWidth(), ((IhmEntiteRelation)liste.get(i)).getHeight());
/*    */     }
/*    */   }
/*    */   
/*    */   public static void _adapterPageMCDZoom(IhmPageMCD page, double zoom) {
/* 26 */     adapterEntiteRelation(page.getListeEntiteRelation(), zoom);
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\verificationAdaptation\AdapterZoom.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */