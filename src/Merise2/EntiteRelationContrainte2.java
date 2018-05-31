/*    */ package Merise2;
/*    */ 
/*    */ 
/*    */ public class EntiteRelationContrainte2
/*    */ {
/*    */   String nome;
/*    */   
/*    */   String type;
/*    */   
/*    */   String commentaire;
/*    */   
/*    */   String programme;
/*    */   
/*    */   String corpsCnt;
/*    */   
/*    */   String nomEntiteRelation;
/*    */   
/*    */   String depane;
/*    */   String identifiant;
/*    */   
/*    */   public EntiteRelationContrainte2(String nome, String type)
/*    */   {
/* 23 */     this.nome = nome;
/* 24 */     this.type = type;
/* 25 */     this.commentaire = "";
/* 26 */     this.programme = "";
/* 27 */     this.corpsCnt = "";
/* 28 */     this.nomEntiteRelation = "";
/* 29 */     this.depane = "";
/* 30 */     this.identifiant = "";
/*    */   }
/*    */   
/*    */   public EntiteRelationContrainte2() {
/* 34 */     this.nome = "";
/* 35 */     this.type = "";
/* 36 */     this.commentaire = "";
/* 37 */     this.programme = "";
/* 38 */     this.corpsCnt = "";
/* 39 */     this.nomEntiteRelation = "";
/* 40 */     this.depane = "";
/* 41 */     this.identifiant = "";
/*    */   }
/*    */   
/*    */   public void setCommentaire(String commentaire) {
/* 45 */     this.commentaire = commentaire;
/*    */   }
/*    */   
/*    */   public void setCorpsCnt(String corpsCnt) {
/* 49 */     this.corpsCnt = corpsCnt;
/*    */   }
/*    */   
/*    */   public void setDepane(String depane) {
/* 53 */     this.depane = depane;
/*    */   }
/*    */   
/*    */   public void setNomEntiteRelation(String nomEntiteRelation) {
/* 57 */     this.nomEntiteRelation = nomEntiteRelation;
/*    */   }
/*    */   
/*    */   public void setNome(String nome) {
/* 61 */     this.nome = nome;
/*    */   }
/*    */   
/*    */   public void setProgramme(String programme) {
/* 65 */     this.programme = programme;
/*    */   }
/*    */   
/*    */   public void setType(String type) {
/* 69 */     this.type = type;
/*    */   }
/*    */   
/*    */   public String getCommentaire() {
/* 73 */     return this.commentaire;
/*    */   }
/*    */   
/*    */   public String getCorpsCnt() {
/* 77 */     return this.corpsCnt;
/*    */   }
/*    */   
/*    */   public String getDepane() {
/* 81 */     return this.depane;
/*    */   }
/*    */   
/*    */   public String getNomEntiteRelation() {
/* 85 */     return this.nomEntiteRelation;
/*    */   }
/*    */   
/*    */   public String getNome() {
/* 89 */     return this.nome;
/*    */   }
/*    */   
/*    */   public String getProgramme() {
/* 93 */     return this.programme;
/*    */   }
/*    */   
/*    */   public String getType() {
/* 97 */     return this.type;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Merise2\EntiteRelationContrainte2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */