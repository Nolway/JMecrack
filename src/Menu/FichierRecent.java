/*    */ package Menu;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FichierRecent
/*    */ {
/*    */   private String nom;
/*    */   
/*    */ 
/*    */   private String chemin;
/*    */   
/*    */ 
/*    */ 
/*    */   public FichierRecent(String chemin)
/*    */   {
/* 17 */     this.nom = "";
/* 18 */     this.chemin = chemin;
/*    */   }
/*    */   
/*    */   public String getChemin() {
/* 22 */     return this.chemin;
/*    */   }
/*    */   
/*    */   public String getNom() {
/* 26 */     return this.nom;
/*    */   }
/*    */   
/*    */   public void setChemin(String chemin) {
/* 30 */     this.chemin = chemin;
/*    */   }
/*    */   
/*    */   public void setNom(String nom) {
/* 34 */     this.nom = nom;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 39 */     return this.chemin;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Menu\FichierRecent.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */