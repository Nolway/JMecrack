/*    */ package IhmMLD;
/*    */ 
/*    */ import IhmMCD.IhmEntite;
/*    */ import IhmMCD.IhmRelation;
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MLDLien
/*    */ {
/*    */   private IhmRelation relation;
/*    */   private ArrayList<MLDEntiteCardinalite> listeEntite;
/*    */   
/*    */   public MLDLien(IhmRelation relation)
/*    */   {
/* 21 */     this.relation = relation;
/* 22 */     this.listeEntite = new ArrayList();
/*    */   }
/*    */   
/*    */   public ArrayList<MLDEntiteCardinalite> getListeEntite() {
/* 26 */     return this.listeEntite;
/*    */   }
/*    */   
/*    */   public IhmRelation getRelation() {
/* 30 */     return this.relation;
/*    */   }
/*    */   
/*    */   public void setListeEntite(ArrayList<MLDEntiteCardinalite> listeEntite) {
/* 34 */     this.listeEntite = listeEntite;
/*    */   }
/*    */   
/*    */   public void setRelation(IhmRelation relation) {
/* 38 */     this.relation = relation;
/*    */   }
/*    */   
/*    */   public void ajouterMLDEntiteCardinalite(MLDEntiteCardinalite ent) {
/* 42 */     this.listeEntite.add(ent);
/*    */   }
/*    */   
/*    */   public void ajouterIhmEntiteCardinaliteListe(IhmEntite ent, String card, String nomLien) {
/* 46 */     MLDEntiteCardinalite entCar = new MLDEntiteCardinalite(ent.copier(), card, nomLien);
/* 47 */     this.listeEntite.add(entCar);
/*    */   }
/*    */   
/*    */   public void afficherMLDLien()
/*    */   {
/* 52 */     for (int i = 0; i < this.listeEntite.size(); i++) {
/* 53 */       ((MLDEntiteCardinalite)this.listeEntite.get(i)).afficherEntiteCardinalite();
/*    */     }
/* 55 */     System.out.println();
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMLD\MLDLien.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */