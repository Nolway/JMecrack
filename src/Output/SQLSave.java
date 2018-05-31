/*    */ package Output;
/*    */ 
/*    */ import Merise2.Historique;
/*    */ import Outil.Parametres;
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SQLSave
/*    */   implements Serializable
/*    */ {
/*    */   String type;
/*    */   String script;
/*    */   String commentaire;
/*    */   String version;
/*    */   String date;
/*    */   String depanne;
/*    */   ArrayList<Historique> historique;
/*    */   
/*    */   public SQLSave(String type, String script)
/*    */   {
/* 26 */     this.type = type;
/* 27 */     this.script = script;
/* 28 */     this.commentaire = "";
/* 29 */     this.version = Parametres.version;
/* 30 */     this.date = "";
/* 31 */     this.depanne = "";
/* 32 */     this.historique = new ArrayList();
/*    */   }
/*    */   
/*    */   public SQLSave() {
/* 36 */     this.type = "";
/* 37 */     this.script = "";
/* 38 */     this.commentaire = "";
/* 39 */     this.version = Parametres.version;
/* 40 */     this.date = "";
/* 41 */     this.depanne = "";
/*    */   }
/*    */   
/*    */   public String getCommentaire() {
/* 45 */     return this.commentaire;
/*    */   }
/*    */   
/*    */   public String getDate() {
/* 49 */     return this.date;
/*    */   }
/*    */   
/*    */   public String getDepanne() {
/* 53 */     return this.depanne;
/*    */   }
/*    */   
/*    */   public String getScript() {
/* 57 */     return this.script;
/*    */   }
/*    */   
/*    */   public String getType() {
/* 61 */     return this.type;
/*    */   }
/*    */   
/*    */   public String getVersion() {
/* 65 */     return this.version;
/*    */   }
/*    */   
/*    */   public void setCommentaire(String commentaire) {
/* 69 */     this.commentaire = commentaire;
/*    */   }
/*    */   
/*    */   public void setDate(String date) {
/* 73 */     this.date = date;
/*    */   }
/*    */   
/*    */   public void setDepanne(String depanne) {
/* 77 */     this.depanne = depanne;
/*    */   }
/*    */   
/*    */   public void setScript(String script) {
/* 81 */     this.script = script;
/*    */   }
/*    */   
/*    */   public void setType(String type) {
/* 85 */     this.type = type;
/*    */   }
/*    */   
/*    */   public void setVersion(String version) {
/* 89 */     this.version = version;
/*    */   }
/*    */   
/*    */   public ArrayList<Historique> getHistorique() {
/* 93 */     return this.historique;
/*    */   }
/*    */   
/*    */   public void setHistorique(ArrayList<Historique> historique) {
/* 97 */     this.historique = historique;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Output\SQLSave.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */