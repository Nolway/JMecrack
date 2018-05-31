/*     */ package verificationAdaptation;
/*     */ 
/*     */ import IhmMCD.IhmEntite;
/*     */ import IhmMCD.IhmLien;
/*     */ import IhmMCD.IhmLienHeritage;
/*     */ import IhmMCD.IhmRelation;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmLien2;
/*     */ import IhmMCD2.IhmLienHeritage2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import Merise.Attribut;
/*     */ import Merise.Entite;
/*     */ import Merise.Relation;
/*     */ import Merise2.Attribut2;
/*     */ import Merise2.Entite2;
/*     */ import Merise2.Relation2;
/*     */ import Outil.Parametres;
/*     */ import Outil.Setting;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VerifEntiteRelation
/*     */ {
/*     */   public static boolean entiteNomVide(IhmEntite ent)
/*     */   {
/*  32 */     if (ent.getEntite().getNom().trim().length() == 0) return true;
/*  33 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean entiteCodeVide(IhmEntite ent) {
/*  37 */     Entite2 ent2 = (Entite2)ent.getEntite();
/*  38 */     if (ent2.getCode().trim().length() == 0) return true;
/*  39 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean entiteNomVide(IhmRelation rel) {
/*  43 */     if (rel.getRelation().getNom().trim().length() == 0) return true;
/*  44 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean relationCodeVide(IhmRelation rel) {
/*  48 */     Relation2 rel2 = (Relation2)rel.getRelation();
/*  49 */     if (rel2.getCode().trim().length() == 0) return true;
/*  50 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean entiteNomCodeReserver(String nom) {
/*  54 */     if (!Setting.SQLVerifierMotReserver2) { return false;
/*     */     }
/*  56 */     nom = nom.trim().toUpperCase();
/*  57 */     String[] tab = Parametres.KeyTab;
/*  58 */     for (int i = 0; i < tab.length; i++) {
/*  59 */       if (tab[i].toUpperCase().equals(nom)) return true;
/*     */     }
/*  61 */     return false;
/*     */   }
/*     */   
/*     */   public static ArrayList<IhmLien> getLienRelation(ArrayList<IhmLien> list, IhmRelation rel)
/*     */   {
/*  66 */     ArrayList<IhmLien> lLien = new ArrayList();
/*     */     
/*  68 */     for (int i = 0; i < list.size(); i++) {
/*  69 */       IhmLien2 lien = (IhmLien2)list.get(i);
/*  70 */       if (lien.getRelation() == rel) {
/*  71 */         lLien.add(lien);
/*     */       }
/*     */     }
/*  74 */     return lLien;
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean entiteSansLien(IhmEntite2 ent, ArrayList<IhmLien> listeLien, ArrayList<IhmLienHeritage> listHeritage)
/*     */   {
/*  80 */     for (int i = 0; i < listeLien.size(); i++) {
/*  81 */       IhmLien2 lien = (IhmLien2)listeLien.get(i);
/*  82 */       if (lien.getEntite() == ent) return false;
/*     */     }
/*  84 */     for (int i = 0; i < listHeritage.size(); i++) {
/*  85 */       IhmLienHeritage2 lienH = (IhmLienHeritage2)listHeritage.get(i);
/*  86 */       if ((lienH.getFils() == ent) || (lienH.getFils() == ent)) { return false;
/*     */       }
/*     */     }
/*  89 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean relationAucunOuUnSeulLien(ArrayList<IhmLien> list, IhmRelation2 rel)
/*     */   {
/*  94 */     int cpt = 0;
/*  95 */     for (int i = 0; i < list.size(); i++) {
/*  96 */       IhmLien2 lien = (IhmLien2)list.get(i);
/*  97 */       if (lien.getRelation() == rel) {
/*  98 */         cpt++;
/*  99 */         if (cpt == 2) return false;
/*     */       }
/*     */     }
/* 102 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void getKeyListeAttribut(ArrayList<Attribut> listeKey, ArrayList<Attribut> listeAtt)
/*     */   {
/* 109 */     for (int i = 0; i < listeAtt.size(); i++) {
/* 110 */       Attribut2 att = (Attribut2)listeAtt.get(i);
/* 111 */       if (att.getListeAttributs().size() == 0) {
/* 112 */         if (att.getKey().equals(Parametres.Cle)) {
/* 113 */           listeKey.add(listeAtt.get(i));
/*     */         }
/*     */       } else {
/* 116 */         getKeyListeAttribut(listeKey, att.getListeAttributs());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static ArrayList<Attribut> getKeyEntite(IhmEntite ent) {
/* 122 */     ArrayList<Attribut> listeKey = new ArrayList();
/* 123 */     getKeyListeAttribut(listeKey, ent.getEntite().getListeAttributs());
/* 124 */     return listeKey;
/*     */   }
/*     */   
/*     */   public static boolean existeKeyEntite(IhmEntite ent) {
/* 128 */     ArrayList<Attribut> l = getKeyEntite(ent);
/* 129 */     if (l.size() > 0) return true;
/* 130 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\verificationAdaptation\VerifEntiteRelation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */