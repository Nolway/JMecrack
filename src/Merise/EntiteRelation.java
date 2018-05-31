/*     */ package Merise;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import java.io.PrintStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EntiteRelation
/*     */   implements Serializable
/*     */ {
/*     */   private String nom;
/*     */   private String commentaire;
/*  19 */   private static int numEntite = 0;
/*  20 */   private static int numRelation = 0;
/*     */   private ArrayList<Attribut> listeAttributs;
/*     */   
/*     */   public EntiteRelation(String nom) {
/*  24 */     this.nom = nom;
/*  25 */     this.listeAttributs = new ArrayList();
/*  26 */     this.commentaire = "";
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> getListeAttributs()
/*     */   {
/*  31 */     return this.listeAttributs;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  35 */     return this.nom;
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/*  39 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public void setListeAttributs(Attribut attribut)
/*     */   {
/*  44 */     this.listeAttributs.add(attribut);
/*     */   }
/*     */   
/*     */   public void setListeAttributs(ArrayList<Attribut> listeAttributs) {
/*  48 */     this.listeAttributs = listeAttributs;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/*  52 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String commentaire) {
/*  56 */     this.commentaire = commentaire;
/*     */   }
/*     */   
/*     */   public void supprimerAttribut(int i) {
/*  60 */     if (this.listeAttributs == null) return;
/*  61 */     if (this.listeAttributs.size() <= i) return;
/*  62 */     if (i < 0) return;
/*  63 */     this.listeAttributs.remove(i);
/*     */   }
/*     */   
/*     */   public Attribut trouverAttribut(String nom) {
/*  67 */     for (int i = 0; i < this.listeAttributs.size(); i++) {
/*  68 */       if (nom.trim().toUpperCase().equals(((Attribut)this.listeAttributs.get(i)).getNom().trim().toUpperCase())) return (Attribut)this.listeAttributs.get(i);
/*     */     }
/*  70 */     return null;
/*     */   }
/*     */   
/*     */   public void supprimerAttribut(String nom) {
/*  74 */     Attribut att = trouverAttribut(nom);
/*  75 */     if (att != null) this.listeAttributs.remove(att);
/*     */   }
/*     */   
/*     */   public static int getNumEntite() {
/*  79 */     return numEntite;
/*     */   }
/*     */   
/*     */   public static int getNumRelation() {
/*  83 */     return numRelation;
/*     */   }
/*     */   
/*     */   public static void setNumEntite(int numEntite) {
/*  87 */     numEntite = numEntite;
/*     */   }
/*     */   
/*     */   public static void setNumRelation(int numRelation) {
/*  91 */     numRelation = numRelation;
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> copierListeAttribut() {
/*  95 */     ArrayList<Attribut> liste = new ArrayList();
/*  96 */     for (int i = 0; i < this.listeAttributs.size(); i++) {
/*  97 */       liste.add(((Attribut)this.listeAttributs.get(i)).copier());
/*     */     }
/*  99 */     return liste;
/*     */   }
/*     */   
/*     */   public EntiteRelation copier() {
/* 103 */     EntiteRelation ent = new EntiteRelation(this.nom);
/* 104 */     ent.setListeAttributs(copierListeAttribut());
/* 105 */     return ent;
/*     */   }
/*     */   
/*     */   public void affecterNomAuAttribut() {
/* 109 */     for (int i = 0; i < this.listeAttributs.size(); i++) {
/* 110 */       ((Attribut)this.listeAttributs.get(i)).setEntiteRelation(this);
/*     */     }
/*     */   }
/*     */   
/*     */   public void afficherlisteAttribut() {
/* 115 */     for (int i = 0; i < this.listeAttributs.size(); i++) {
/* 116 */       System.out.print(((Attribut)this.listeAttributs.get(i)).toString() + "\t");
/*     */     }
/* 118 */     System.out.println("\n");
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> getCle() {
/* 122 */     ArrayList<Attribut> listeCle = new ArrayList();
/* 123 */     for (int i = 0; i < this.listeAttributs.size(); i++) {
/* 124 */       if (Parametres.Cle.trim().toUpperCase().equals(((Attribut)this.listeAttributs.get(i)).getKey().trim().toUpperCase())) {
/* 125 */         listeCle.add(this.listeAttributs.get(i));
/*     */       }
/*     */     }
/* 128 */     return listeCle;
/*     */   }
/*     */   
/*     */   public void rajouterListeAttribut(ArrayList<Attribut> liste) {
/* 132 */     for (int i = 0; i < liste.size(); i++) {
/* 133 */       getListeAttributs().add(liste.get(i));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Merise\EntiteRelation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */