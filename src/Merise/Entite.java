/*    */ package Merise;
/*    */ 
/*    */ import Outil.Parametres;
/*    */ import java.io.PrintStream;
/*    */ import java.io.Serializable;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Entite
/*    */   extends EntiteRelation
/*    */   implements Serializable
/*    */ {
/*    */   public Entite(String nom)
/*    */   {
/* 18 */     super(nom);
/* 19 */     if (nom.trim().toUpperCase().equals("ENTITE")) {
/* 20 */       setNom(nom + getNumEntite());
/* 21 */       setNumEntite(getNumEntite() + 1);
/*    */     }
/*    */   }
/*    */   
/*    */   public Entite copier()
/*    */   {
/* 27 */     Entite en = new Entite(getNom());
/* 28 */     en.setNom(getNom());
/* 29 */     en.setCommentaire(getCommentaire());
/* 30 */     en.setListeAttributs(copierListeAttribut());
/* 31 */     for (int i = 0; i < en.getListeAttributs().size(); i++) {
/* 32 */       ((Attribut)en.getListeAttributs().get(i)).setEntiteRelation(en);
/*    */     }
/* 34 */     return en;
/*    */   }
/*    */   
/*    */   public ArrayList<Attribut> getCle()
/*    */   {
/* 39 */     ArrayList<Attribut> listeCle = new ArrayList();
/* 40 */     for (int i = 0; i < getListeAttributs().size(); i++) {
/* 41 */       if (Parametres.Cle.equals(((Attribut)getListeAttributs().get(i)).getKey().trim())) {
/* 42 */         listeCle.add(((Attribut)getListeAttributs().get(i)).copier());
/*    */       }
/*    */     }
/*    */     
/* 46 */     return listeCle;
/*    */   }
/*    */   
/*    */   public ArrayList<Attribut> getCleEtrangere() {
/* 50 */     ArrayList<Attribut> listeCle = new ArrayList();
/* 51 */     for (int i = 0; i < getListeAttributs().size(); i++) {
/* 52 */       if (Parametres.CleEtr.equals(((Attribut)getListeAttributs().get(i)).getKey().trim())) {
/* 53 */         listeCle.add(((Attribut)getListeAttributs().get(i)).copier());
/*    */       }
/*    */     }
/*    */     
/* 57 */     return listeCle;
/*    */   }
/*    */   
/*    */   public void afficherListe(ArrayList<Attribut> liste) {
/* 61 */     System.out.println("Liste des cles : " + getNom());
/* 62 */     for (int i = 0; i < liste.size(); i++) {
/* 63 */       System.out.println(((Attribut)liste.get(i)).getNom());
/*    */     }
/*    */   }
/*    */   
/*    */   public void rajouterListeAttribut(ArrayList<Attribut> liste)
/*    */   {
/* 69 */     for (int i = 0; i < liste.size(); i++) {
/* 70 */       getListeAttributs().add(((Attribut)liste.get(i)).copier());
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Merise\Entite.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */