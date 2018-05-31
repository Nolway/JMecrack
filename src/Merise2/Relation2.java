/*     */ package Merise2;
/*     */ 
/*     */ import Merise.Attribut;
/*     */ import Merise.EntiteRelation;
/*     */ import Merise.Relation;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Relation2
/*     */   extends Relation
/*     */   implements Serializable
/*     */ {
/*     */   String code;
/*     */   String historisation;
/*     */   private ArrayList<Historique> historique;
/*     */   
/*     */   public Relation2(String nom)
/*     */   {
/*  24 */     super(nom);
/*  25 */     this.code = (nom == null ? "" : nom.trim().toUpperCase());
/*  26 */     this.historisation = "";
/*  27 */     this.historique = new ArrayList();
/*  28 */     this.historique.add(Historique.getHistoriqueCreation());
/*     */   }
/*     */   
/*     */   public void setListeAttributs(Attribut2 attribut) {
/*  32 */     getListeAttributs().add(attribut);
/*     */   }
/*     */   
/*     */ 
/*     */   public Relation2 copier()
/*     */   {
/*  38 */     Relation2 ent = new Relation2(getNom());
/*  39 */     ent.setCode(getCode());
/*  40 */     ent.setHistorisation(getHistorisation());
/*  41 */     ent.setHistorique(copierHistoriques(getHistorique()));
/*  42 */     ent.setListeAttributs(copierListeAttribut());
/*  43 */     return ent;
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> copierHistoriques(ArrayList<Historique> lhis) {
/*  47 */     ArrayList<Historique> l = new ArrayList();
/*  48 */     for (int i = 0; i < lhis.size(); i++) {
/*  49 */       l.add(((Historique)lhis.get(i)).copier());
/*     */     }
/*  51 */     return l;
/*     */   }
/*     */   
/*     */   public void rajouterListeAttribut2(ArrayList<Attribut2> liste) {
/*  55 */     for (int i = 0; i < liste.size(); i++) {
/*  56 */       getListeAttributs().add(liste.get(i));
/*     */     }
/*     */   }
/*     */   
/*     */   public void ajouterModification() {
/*  61 */     Historique h = Historique.getHistoriqueModification();
/*  62 */     Historique h1 = (Historique)this.historique.get(this.historique.size() - 1);
/*  63 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur()))) {
/*  64 */       getHistorique().add(h);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setHistorique(ArrayList<Historique> historique) {
/*  69 */     this.historique = historique;
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> getHistorique() {
/*  73 */     return this.historique;
/*     */   }
/*     */   
/*     */   public Attribut2 transformerAttribut(Attribut att) {
/*  77 */     Attribut2 att2 = new Attribut2(att.getNom(), att.getNom(), att.getLongueur(), att.getLongDecimale(), att.getKey(), att.isNulle(), att.getCommentaire(), att.getEntiteRelation());
/*  78 */     return att2;
/*     */   }
/*     */   
/*     */   public ArrayList<Attribut> transoformerListAttribut(ArrayList<Attribut> list, String ent) {
/*  82 */     ArrayList<Attribut> list2 = new ArrayList();
/*     */     
/*  84 */     for (int i = 0; i < list.size(); i++) {
/*  85 */       Attribut2 att = transformerAttribut((Attribut)list.get(i));
/*  86 */       att.setCode(att.getCode() + "_" + ent);
/*  87 */       list2.add(att);
/*     */     }
/*  89 */     return list2;
/*     */   }
/*     */   
/*     */   public Relation2 transformeEntite(Relation rel)
/*     */   {
/*  94 */     Relation2 rel2 = new Relation2(rel.getNom());
/*  95 */     rel2.setListeAttributs(transoformerListAttribut(rel.getListeAttributs(), rel.getNom()));
/*  96 */     return rel2;
/*     */   }
/*     */   
/*     */   public String getCode() {
/* 100 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/* 104 */     this.code = code;
/*     */   }
/*     */   
/*     */   public String getHistorisation() {
/* 108 */     return this.historisation;
/*     */   }
/*     */   
/*     */   public void setHistorisation(String historisation) {
/* 112 */     this.historisation = historisation;
/*     */   }
/*     */   
/*     */   private static ArrayList<Attribut> parseListeAttribut(ArrayList<Attribut> liste, EntiteRelation r) {
/* 116 */     ArrayList<Attribut> l = new ArrayList();
/*     */     
/* 118 */     for (int i = 0; i < liste.size(); i++) {
/* 119 */       Attribut2 att = Attribut2.parseAttrinut((Attribut)liste.get(i));
/* 120 */       att.setEntiteRelation(r);
/* 121 */       l.add(att);
/*     */     }
/* 123 */     return l;
/*     */   }
/*     */   
/*     */   public static Relation2 parseEntite(Relation ent) {
/* 127 */     Relation2 e = new Relation2(ent.getNom());
/* 128 */     e.setCode(ent.getNom().toUpperCase());
/* 129 */     e.setCommentaire(ent.getCommentaire());
/* 130 */     e.setListeAttributs(parseListeAttribut(ent.getListeAttributs(), e));
/* 131 */     return e;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Merise2\Relation2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */