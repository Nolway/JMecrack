/*     */ package verificationAdaptation;
/*     */ 
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmLienHeritage;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmLienHeritage2;
/*     */ import IhmMLD2.MLDRelationLien;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VerifHeritageLienRelatif
/*     */ {
/*     */   ArrayList<MLDRelationLien> listeRelationLien;
/*     */   
/*     */   public static boolean estDejaUnPere(IhmEntite2 entF, IhmEntite2 entP, ArrayList<IhmLienHeritage> lienH)
/*     */   {
/*  26 */     for (int i = 0; i < lienH.size(); i++) {
/*  27 */       IhmLienHeritage2 lien = (IhmLienHeritage2)lienH.get(i);
/*  28 */       if ((lien.getFils() == entF) && (lien.getPere() == entP)) {
/*  29 */         return true;
/*     */       }
/*     */     }
/*  32 */     return false;
/*     */   }
/*     */   
/*     */   private static ArrayList<IhmEntiteRelation> getPeresHeriDirecteEntite(IhmEntite2 ent, ArrayList<IhmLienHeritage> lienH) {
/*  36 */     ArrayList<IhmEntiteRelation> liste = new ArrayList();
/*     */     
/*  38 */     for (int i = 0; i < lienH.size(); i++) {
/*  39 */       IhmLienHeritage2 lien = (IhmLienHeritage2)lienH.get(i);
/*  40 */       if (lien.getFils() == ent) {
/*  41 */         liste.add(lien.getPere());
/*     */       }
/*     */     }
/*  44 */     return liste;
/*     */   }
/*     */   
/*     */ 
/*     */   private static void getPeresHeritageEntite(ArrayList<IhmEntiteRelation> listePere, IhmEntite2 ent, ArrayList<IhmLienHeritage> lienH)
/*     */   {
/*  50 */     for (int i = 0; i < lienH.size(); i++) {
/*  51 */       IhmLienHeritage2 lien = (IhmLienHeritage2)lienH.get(i);
/*  52 */       if (lien.getFils() == ent) {
/*  53 */         listePere.add(lien.getPere());
/*  54 */         getPeresHeritageEntite(listePere, (IhmEntite2)lien.getPere(), lienH);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static ArrayList<IhmEntiteRelation> getPeresEntite(IhmEntite2 ent, ArrayList<IhmLienHeritage> lienH) {
/*  60 */     ArrayList<IhmEntiteRelation> liste = new ArrayList();
/*  61 */     getPeresHeritageEntite(liste, ent, lienH);
/*  62 */     return liste;
/*     */   }
/*     */   
/*     */   private static boolean existeEntiteDansListePere(IhmEntite2 ent, ArrayList<IhmEntiteRelation> liste) {
/*  66 */     for (int i = 0; i < liste.size(); i++) {
/*  67 */       if (ent == liste.get(i)) return true;
/*     */     }
/*  69 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean isDejaPere(IhmEntite2 entF, IhmEntite2 entP, ArrayList<IhmLienHeritage> lienH) {
/*  73 */     ArrayList<IhmEntiteRelation> liste = getPeresEntite(entF, lienH);
/*  74 */     if (existeEntiteDansListePere(entP, liste)) return true;
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean ADejaPere(IhmEntite2 entF, ArrayList<IhmLienHeritage> lienH) {
/*  79 */     ArrayList<IhmEntiteRelation> liste = getPeresEntite(entF, lienH);
/*  80 */     if (liste.size() > 0) return true;
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean isBoucleHeritage(IhmEntite2 entF, IhmEntite2 entP, ArrayList<IhmLienHeritage> lienH) {
/*  85 */     ArrayList<IhmEntiteRelation> liste = getPeresEntite(entP, lienH);
/*  86 */     if (existeEntiteDansListePere(entF, liste)) return true;
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean estDejaUneSpecialisation(IhmEntite2 entF, IhmEntite2 entP, ArrayList<IhmLienHeritage> lienH) {
/*  91 */     ArrayList<IhmEntiteRelation> liste = getPeresEntite(entP, lienH);
/*  92 */     ArrayList<IhmEntiteRelation> liste1 = getPeresEntite(entF, lienH);
/*  93 */     if (existeDansListe(liste, liste1)) return true;
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean existeDansListe(ArrayList<IhmEntiteRelation> liste, ArrayList<IhmEntiteRelation> liste1) {
/*  98 */     for (int i = 0; i < liste.size(); i++) {
/*  99 */       for (int j = 0; j < liste1.size(); j++) {
/* 100 */         if (liste.get(i) == liste.get(j)) {
/* 101 */           return true;
/*     */         }
/*     */       }
/*     */     }
/* 105 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\verificationAdaptation\VerifHeritageLienRelatif.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */