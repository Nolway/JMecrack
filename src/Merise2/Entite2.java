/*     */ package Merise2;
/*     */ 
/*     */ import Merise.Attribut;
/*     */ import Merise.Entite;
/*     */ import Merise.EntiteRelation;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Entite2
/*     */   extends Entite
/*     */   implements Serializable
/*     */ {
/*     */   String code;
/*     */   private ArrayList<Historique> historique;
/*     */   String historisation;
/*     */   
/*     */   public Entite2(String nom)
/*     */   {
/*  24 */     super(nom);
/*  25 */     this.code = (nom == null ? "" : nom.trim().toUpperCase());
/*  26 */     this.historisation = "";
/*  27 */     this.historique = new ArrayList();
/*  28 */     this.historique.add(Historique.getHistoriqueCreation());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setListeAttributs(Attribut2 attribut)
/*     */   {
/*  35 */     getListeAttributs().add(attribut);
/*     */   }
/*     */   
/*     */ 
/*     */   public Entite2 copier()
/*     */   {
/*  41 */     Entite2 ent = new Entite2(getNom());
/*  42 */     ent.setCode(getCode());
/*  43 */     ent.setHistorisation(getHistorisation());
/*  44 */     ent.setHistorique(copierHistoriques(getHistorique()));
/*  45 */     ent.setListeAttributs(copierListeAttribut());
/*  46 */     return ent;
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> copierHistoriques(ArrayList<Historique> lhis) {
/*  50 */     ArrayList<Historique> l = new ArrayList();
/*  51 */     for (int i = 0; i < lhis.size(); i++) {
/*  52 */       l.add(((Historique)lhis.get(i)).copier());
/*     */     }
/*  54 */     return l;
/*     */   }
/*     */   
/*     */   public void rajouterListeAttribut2(ArrayList<Attribut2> liste) {
/*  58 */     for (int i = 0; i < liste.size(); i++) {
/*  59 */       getListeAttributs().add(liste.get(i));
/*     */     }
/*     */   }
/*     */   
/*     */   public void ajouterModification() {
/*  64 */     Historique h = Historique.getHistoriqueModification();
/*  65 */     Historique h1 = (Historique)this.historique.get(this.historique.size() - 1);
/*  66 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur()))) {
/*  67 */       getHistorique().add(h);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setHistorique(ArrayList<Historique> historique) {
/*  72 */     this.historique = historique;
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> getHistorique() {
/*  76 */     return this.historique;
/*     */   }
/*     */   
/*     */   public Attribut2 transformerAttribut(Attribut att) {
/*  80 */     Attribut2 att2 = new Attribut2(att.getNom(), att.getNom(), att.getLongueur(), att.getLongDecimale(), att.getKey(), att.isNulle(), att.getCommentaire(), att.getEntiteRelation());
/*  81 */     return att2;
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> transoformerListAttribut(ArrayList<Attribut> list, String ent) {
/*  85 */     ArrayList<Attribut> list2 = new ArrayList();
/*     */     
/*  87 */     for (int i = 0; i < list.size(); i++) {
/*  88 */       Attribut2 att = transformerAttribut((Attribut)list.get(i));
/*  89 */       att.setCode(att.getCode() + "_" + ent);
/*  90 */       list2.add(att);
/*     */     }
/*  92 */     return list2;
/*     */   }
/*     */   
/*     */   public Entite2 transformeEntite(Entite ent)
/*     */   {
/*  97 */     Entite2 ent2 = new Entite2(ent.getNom());
/*  98 */     ent2.setListeAttributs(transoformerListAttribut(ent.getListeAttributs(), ent.getNom()));
/*  99 */     return ent2;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 103 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 107 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getHistorisation() {
/* 111 */     return this.historisation;
/*     */   }
/*     */   
/*     */   public void setHistorisation(String historisation) {
/* 115 */     this.historisation = historisation;
/*     */   }
/*     */   
/*     */   private static ArrayList<Attribut> parseListeAttribut(ArrayList<Attribut> liste, EntiteRelation e) {
/* 119 */     ArrayList<Attribut> l = new ArrayList();
/*     */     
/* 121 */     for (int i = 0; i < liste.size(); i++) {
/* 122 */       Attribut2 att = Attribut2.parseAttrinut((Attribut)liste.get(i));
/* 123 */       att.setEntiteRelation(e);
/* 124 */       l.add(att);
/*     */     }
/* 126 */     return l;
/*     */   }
/*     */   
/*     */   public static Entite2 parseEntite(Entite ent) {
/* 130 */     Entite2 e = new Entite2(ent.getNom());
/* 131 */     e.setCode(ent.getNom().toUpperCase());
/* 132 */     e.setCommentaire(ent.getCommentaire());
/* 133 */     e.setListeAttributs(parseListeAttribut(ent.getListeAttributs(), e));
/* 134 */     return e;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Merise2\Entite2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */