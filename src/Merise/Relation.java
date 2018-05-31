/*    */ package Merise;
/*    */ 
/*    */ import Outil.Parametres;
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Relation
/*    */   extends EntiteRelation
/*    */   implements Serializable
/*    */ {
/*    */   public Relation(String nom)
/*    */   {
/* 18 */     super(nom);
/* 19 */     if (nom.trim().toUpperCase().equals("RELATION")) {
/* 20 */       setNom(nom + getNumRelation());
/* 21 */       setNumRelation(getNumRelation() + 1);
/*    */     }
/*    */   }
/*    */   
/*    */   public Relation copier()
/*    */   {
/* 27 */     Relation re = new Relation(getNom());
/* 28 */     re.setCommentaire(getCommentaire());
/* 29 */     re.setListeAttributs(copierListeAttribut());
/* 30 */     return re;
/*    */   }
/*    */   
/*    */   public ArrayList<Attribut> getCle()
/*    */   {
/* 35 */     ArrayList<Attribut> listeCle = new ArrayList();
/* 36 */     for (int i = 0; i < getListeAttributs().size(); i++) {
/* 37 */       if (Parametres.Cle.trim().toUpperCase().equals(((Attribut)getListeAttributs().get(i)).getKey().trim().toUpperCase()))
/*    */       {
/* 39 */         listeCle.add(getListeAttributs().get(i));
/*    */       }
/*    */     }
/* 42 */     return listeCle;
/*    */   }
/*    */   
/*    */   public void rajouterListeAttribut(ArrayList<Attribut> liste)
/*    */   {
/* 47 */     for (int i = 0; i < liste.size(); i++) {
/* 48 */       getListeAttributs().add(liste.get(i));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Merise\Relation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */