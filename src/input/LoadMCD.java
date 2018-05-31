/*    */ package input;
/*    */ 
/*    */ 
/*    */ public class LoadMCD
/*    */ {
/*    */   String id;
/*    */   
/*    */   String nom;
/*    */   
/*    */   String url;
/*    */   
/*    */   String description;
/*    */   
/*    */   String dateCreation;
/*    */   
/*    */   String user;
/*    */   
/*    */   String image;
/*    */   String nbLoad;
/*    */   
/*    */   public LoadMCD(String nom, String url, String description)
/*    */   {
/* 23 */     this.id = "";
/* 24 */     this.nom = nom;
/* 25 */     this.url = url;
/* 26 */     this.description = description;
/* 27 */     this.dateCreation = "";
/* 28 */     this.user = "JMerise";
/* 29 */     this.image = "";
/* 30 */     this.nbLoad = "0";
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 35 */     return this.nom;
/*    */   }
/*    */   
/*    */   public String getDateCreation() {
/* 39 */     return this.dateCreation;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 43 */     return this.description;
/*    */   }
/*    */   
/*    */   public String getId() {
/* 47 */     return this.id;
/*    */   }
/*    */   
/*    */   public String getImage() {
/* 51 */     return this.image;
/*    */   }
/*    */   
/*    */   public String getNbLoad() {
/* 55 */     return this.nbLoad;
/*    */   }
/*    */   
/*    */   public String getNom() {
/* 59 */     return this.nom;
/*    */   }
/*    */   
/*    */   public String getUrl() {
/* 63 */     return this.url;
/*    */   }
/*    */   
/*    */   public String getUser() {
/* 67 */     return this.user;
/*    */   }
/*    */   
/*    */   public void setDateCreation(String dateCreation) {
/* 71 */     this.dateCreation = dateCreation;
/*    */   }
/*    */   
/*    */   public void setDescription(String description) {
/* 75 */     this.description = description;
/*    */   }
/*    */   
/*    */   public void setId(String id) {
/* 79 */     this.id = id;
/*    */   }
/*    */   
/*    */   public void setImage(String image) {
/* 83 */     this.image = image;
/*    */   }
/*    */   
/*    */   public void setNbLoad(String nbLoad) {
/* 87 */     this.nbLoad = nbLoad;
/*    */   }
/*    */   
/*    */   public void setNom(String nom) {
/* 91 */     this.nom = nom;
/*    */   }
/*    */   
/*    */   public void setUrl(String url) {
/* 95 */     this.url = url;
/*    */   }
/*    */   
/*    */   public void setUser(String user) {
/* 99 */     this.user = user;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\input\LoadMCD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */