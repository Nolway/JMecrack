/*     */ package verificationAdaptation;
/*     */ 
/*     */ import IhmMLD.IhmPageMLD;
/*     */ import IhmMLD2.MLDEntite2;
/*     */ import Merise.Attribut;
/*     */ import Merise.Domaine;
/*     */ import Merise2.Attribut2;
/*     */ import Outil.Parametres;
/*     */ import Output.SQLOutil;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VerificationMLD
/*     */ {
/*     */   private static boolean isVideNomCodeAttribut(Attribut attribut)
/*     */   {
/*  23 */     Attribut2 att = (Attribut2)attribut;
/*  24 */     if ((att.getNom().trim().length() == 0) || (att.getCode().trim().length() == 0))
/*  25 */       return true;
/*  26 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean isReserverNomCodeAttribut(Attribut attribut) {
/*  30 */     Attribut2 att = (Attribut2)attribut;
/*  31 */     String[] tab = Parametres.KeyTab;
/*  32 */     String nom = att.getNom().trim().toUpperCase();
/*  33 */     String code = att.getCode().trim().toUpperCase();
/*  34 */     for (int i = 0; i < tab.length; i++) {
/*  35 */       if ((tab[i].toUpperCase().equals(nom)) || (tab[i].toUpperCase().equals(code))) { return true;
/*     */       }
/*     */     }
/*  38 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean isDefiniTypeAttribut(Attribut attribut, ArrayList<Domaine> listDomaine) {
/*  42 */     Attribut2 att = (Attribut2)attribut;
/*  43 */     String[] tab = Parametres.DomaineDefini;
/*  44 */     String type = att.getType().trim().toUpperCase();
/*  45 */     if (type.trim().length() == 0) return true;
/*  46 */     for (int i = 0; i < tab.length; i++) {
/*  47 */       if (tab[i].trim().toUpperCase().equals(type)) { return true;
/*     */       }
/*     */     }
/*  50 */     for (int i = 0; i < listDomaine.size(); i++) {
/*  51 */       if (((Domaine)listDomaine.get(i)).getNom().trim().toUpperCase().equals(type)) return true;
/*     */     }
/*  53 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean verifierVideNomCodeListe(ArrayList<Attribut> liste) {
/*  57 */     for (int i = 0; i < liste.size(); i++) {
/*  58 */       if (isVideNomCodeAttribut((Attribut)liste.get(i))) return true;
/*     */     }
/*  60 */     return false;
/*     */   }
/*     */   
/*     */   private static String isReserverNomCodeListe(ArrayList<Attribut> liste) {
/*  64 */     String rep = "";
/*     */     
/*  66 */     for (int i = 0; i < liste.size(); i++) {
/*  67 */       if (isReserverNomCodeAttribut((Attribut)liste.get(i))) {
/*  68 */         Attribut2 att = (Attribut2)liste.get(i);
/*  69 */         rep = rep + "Le  nom ou le code de l'attribut " + att.getNom() + "(" + att.getCode() + ") est un mot reservé\n";
/*     */       }
/*     */     }
/*  72 */     return rep;
/*     */   }
/*     */   
/*     */   private static String isDefiniTypeListe(ArrayList<Attribut> liste, ArrayList<Domaine> listDomaine) {
/*  76 */     String rep = "";
/*     */     
/*  78 */     for (int i = 0; i < liste.size(); i++) {
/*  79 */       if (!isDefiniTypeAttribut((Attribut)liste.get(i), listDomaine)) {
/*  80 */         Attribut2 att = (Attribut2)liste.get(i);
/*  81 */         rep = rep + "Le  type de l'attribut " + att.getNom() + "(" + att.getCode() + ") n'est pas défini\n";
/*     */       }
/*     */     }
/*  84 */     return rep;
/*     */   }
/*     */   
/*     */   private static String isRedondanceNomCode(ArrayList<Attribut> liste)
/*     */   {
/*  89 */     String rep = "";
/*     */     
/*     */ 
/*  92 */     for (int i = 0; i < liste.size(); i++) {
/*  93 */       Attribut2 att1 = (Attribut2)liste.get(i);
/*  94 */       String nom = att1.getNom().trim().toUpperCase();
/*  95 */       String code = att1.getCode().trim().toUpperCase();
/*  96 */       for (int j = i + 1; j < liste.size(); j++) {
/*  97 */         Attribut2 att2 = (Attribut2)liste.get(j);
/*  98 */         if ((att2.getNom().trim().toUpperCase().equals(nom)) || (att2.getCode().trim().toUpperCase().equals(code))) {
/*  99 */           rep = rep + "L'attribut " + att1.getNom() + "(" + code + ") existe en plusieurs fois dans la liste\n";
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 104 */     return rep;
/*     */   }
/*     */   
/*     */   public static String verifierMLDentite(MLDEntite2 ent, ArrayList<Domaine> listDomaine) {
/* 108 */     String rep = "";
/* 109 */     ArrayList<Attribut> liste = SQLOutil.decomposerLesAttributsMLDEntite(ent);
/* 110 */     if (verifierVideNomCodeListe(liste))
/* 111 */       return "\nErreur,dans la table " + ent.getNom() + ", les attributs et les codes des attributs ne doivent pas être vide\n";
/* 112 */     rep = rep + isReserverNomCodeListe(liste);
/* 113 */     rep = rep + isDefiniTypeListe(liste, listDomaine);
/* 114 */     rep = rep + isRedondanceNomCode(liste);
/* 115 */     if (rep.length() > 0) {
/* 116 */       rep = "\nErreur dans la table " + ent.getNom() + "\n" + rep;
/*     */     }
/* 118 */     return rep;
/*     */   }
/*     */   
/*     */   public static String verifierMLDentite2(ArrayList<Attribut> liste) {
/* 122 */     String rep = "";
/* 123 */     liste = SQLOutil.decomposerLesAttributsListe(liste);
/* 124 */     if (verifierVideNomCodeListe(liste))
/* 125 */       return "\n Les attribut et les codes ne doivent pas être vide\n";
/* 126 */     rep = rep + isReserverNomCodeListe(liste);
/* 127 */     rep = rep + isRedondanceNomCode(liste);
/* 128 */     return rep;
/*     */   }
/*     */   
/*     */   public static String verifierMLD(IhmPageMLD page, ArrayList<Domaine> listDomaine) {
/* 132 */     String rep = "";
/* 133 */     ArrayList<MLDEntite2> liste = page.getListeMLDEntite();
/* 134 */     for (int i = 0; i < liste.size(); i++) {
/* 135 */       rep = rep + verifierMLDentite((MLDEntite2)liste.get(i), listDomaine);
/*     */     }
/* 137 */     return rep;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\verificationAdaptation\VerificationMLD.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */