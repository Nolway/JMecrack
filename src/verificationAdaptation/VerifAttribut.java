/*     */ package verificationAdaptation;
/*     */ 
/*     */ import Merise.Attribut;
/*     */ import Merise.Domaine;
/*     */ import Merise2.Attribut2;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VerifAttribut
/*     */ {
/*     */   public static boolean nomAttributVide(Attribut2 att)
/*     */   {
/*  24 */     if (att.getNom() == null) return true;
/*  25 */     if (att.getNom().trim().length() == 0) return true;
/*  26 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean codeAttributVide(Attribut2 att) {
/*  30 */     if (att.getListeAttributs().size() > 0) return false;
/*  31 */     if (att.getCode() == null) return true;
/*  32 */     if (att.getCode().trim().length() == 0) return true;
/*  33 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean nomAttributVide(String att) {
/*  37 */     if (att == null) return true;
/*  38 */     if (att.trim().length() == 0) return true;
/*  39 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean codeAttributVide(String att) {
/*  43 */     if (att == null) return true;
/*  44 */     if (att.trim().length() == 0) return true;
/*  45 */     return false;
/*     */   }
/*     */   
/*     */   public static String getNomAttribut(Attribut2 att) {
/*  49 */     String s = "";
/*  50 */     if (Setting.augmentation) {
/*  51 */       s = att.getAugmentation();
/*     */     }
/*  53 */     return s + att.getNom();
/*     */   }
/*     */   
/*     */   public static String getCodeAttribut(Attribut2 att) {
/*  57 */     String s = "";
/*     */     
/*  59 */     if (Setting.augmentation) {
/*  60 */       s = att.getAugmentation();
/*     */     }
/*  62 */     return s + att.getCode();
/*     */   }
/*     */   
/*     */   public static boolean existeNomAttributListe(ArrayList<Attribut> liste, Attribut2 att) {
/*  66 */     String nom = getNomAttribut(att).trim().toUpperCase();
/*     */     
/*  68 */     for (int i = 0; i < liste.size(); i++) {
/*  69 */       if (liste.get(i) != att) {
/*  70 */         String nomL = getNomAttribut((Attribut2)liste.get(i)).trim().toUpperCase();
/*  71 */         if (nom.equals(nomL)) return true;
/*  72 */         if (att.getListeAttributs().size() > 0) {
/*  73 */           boolean rep = existeNomAttributListe(att.getListeAttributs(), att);
/*  74 */           if (rep) return true;
/*     */         }
/*     */       }
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean existeCodeAttributListe(ArrayList<Attribut> liste, Attribut2 att) {
/*  82 */     String code = att.getCode().trim();
/*     */     
/*  84 */     for (int i = 0; i < liste.size(); i++) {
/*  85 */       if (liste.get(i) != att) {
/*  86 */         String codeL = att.getCode();
/*  87 */         if (code.equals(codeL)) return true;
/*  88 */         if (att.getListeAttributs().size() > 0) {
/*  89 */           boolean rep = existeCodeAttributListe(att.getListeAttributs(), att);
/*  90 */           if (rep) return true;
/*     */         }
/*     */       }
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean typeAttributBienDefini(Attribut att, ArrayList<Domaine> listDomaine) {
/*  98 */     if (((Attribut2)att).getListeAttributs().size() > 0) { return true;
/*     */     }
/* 100 */     String[] tab = Parametres.DomaineDefini;
/* 101 */     String type = att.getType().trim().toUpperCase();
/* 102 */     if (type.length() == 0) {
/* 103 */       if (((Attribut2)att).getListeAttributs().size() > 0) {
/* 104 */         return true;
/*     */       }
/* 106 */       return false;
/*     */     }
/*     */     
/* 109 */     for (int i = 0; i < tab.length; i++) {
/* 110 */       if (tab[i].trim().toUpperCase().equals(type)) { return true;
/*     */       }
/*     */     }
/* 113 */     for (int i = 0; i < listDomaine.size(); i++) {
/* 114 */       if (((Domaine)listDomaine.get(i)).getNom().trim().toUpperCase().equals(type)) return true;
/*     */     }
/* 116 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean attributNomReserver(Attribut2 att)
/*     */   {
/* 121 */     if (!Setting.SQLVerifierMotReserver2) { return false;
/*     */     }
/* 123 */     if (att.getListeAttributs().size() > 0) return false;
/* 124 */     String[] tab = Parametres.KeyTab;
/* 125 */     String nom = getNomAttribut(att).trim().toUpperCase();
/* 126 */     for (int i = 0; i < tab.length; i++) {
/* 127 */       if (tab[i].toUpperCase().equals(nom)) { return true;
/*     */       }
/*     */     }
/* 130 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean attributCodeReserver(Attribut2 att) {
/* 134 */     if (!Setting.SQLVerifierMotReserver2) return false;
/* 135 */     if (att.getListeAttributs().size() > 0) return false;
/* 136 */     String code = att.getCode().trim().toUpperCase();
/* 137 */     String[] tab = Parametres.KeyTab;
/* 138 */     for (int i = 0; i < tab.length; i++) {
/* 139 */       if (tab[i].toUpperCase().equals(code)) return true;
/*     */     }
/* 141 */     return false;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String verifierNomEtCodeAttribut(Attribut2 att, ArrayList<Domaine> listDomaine)
/*     */   {
/* 163 */     String msg = "";
/* 164 */     if (nomAttributVide(att)) { msg = msg + "\nLe nom de l'attribut ne doit pas être vide ";
/*     */     }
/* 166 */     if (attributNomReserver(att)) msg = msg + "\nLe nom de l'attribut " + att.getNom() + " est un mot reservé ";
/* 167 */     if (!typeAttributBienDefini(att, listDomaine)) { msg = msg + "\nLe type de l'attribut " + att.getNom() + " : (" + att.getType() + ") n'est pas défini ";
/*     */     }
/*     */     
/* 170 */     if (codeAttributVide(att)) msg = msg + "\nLe code de l'attribut ne doit pas être vide ";
/* 171 */     if (attributCodeReserver(att)) { msg = msg + "\nLe code de l'attribut " + att.getNom() + " est un mot reservé ";
/*     */     }
/*     */     
/* 174 */     return msg;
/*     */   }
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
/*     */   private static String verifierAttributDeLaListe(ArrayList<Attribut> liste, ArrayList<Attribut> listeV, ArrayList<Domaine> listDomaine)
/*     */   {
/* 210 */     String msg = "";
/*     */     
/* 212 */     for (int i = 0; i < liste.size(); i++) {
/* 213 */       Attribut2 att = (Attribut2)liste.get(i);
/* 214 */       msg = msg + verifierNomEtCodeAttribut(att, listDomaine);
/* 215 */       if (existeNomAttribut(att, listeV)) {
/* 216 */         msg = msg + "\nL'attribut " + att.getNom() + " existe plusieurs fois dans la liste ";
/*     */       }
/*     */       
/* 219 */       if (existeCodeAttribut(att, listeV)) {
/* 220 */         msg = msg + "\nLe code de l'attribut " + att.getNom() + " existe plusieurs fois dans la liste ";
/*     */       }
/*     */       
/*     */ 
/* 224 */       if (att.getListeAttributs().size() > 0) {
/* 225 */         msg = msg + verifierAttributDeLaListe(att.getListeAttributs(), listeV, listDomaine);
/*     */       }
/*     */     }
/* 228 */     return msg;
/*     */   }
/*     */   
/*     */   private static String verifierAttributDeLaListeSansAttComposer(ArrayList<Attribut> liste, ArrayList<Attribut> listeV, ArrayList<Domaine> listDomaine)
/*     */   {
/* 233 */     String msg = "";
/*     */     
/* 235 */     for (int i = 0; i < liste.size(); i++) {
/* 236 */       Attribut2 att = (Attribut2)liste.get(i);
/* 237 */       if (att.getListeAttributs().size() == 0) {
/* 238 */         msg = msg + verifierNomEtCodeAttribut(att, listDomaine);
/* 239 */         if (existeNomAttribut(att, listeV)) {
/* 240 */           msg = msg + "\nL'attribut " + att.getNom() + " existe plusieurs fois dans la liste ";
/*     */         }
/*     */         
/* 243 */         if (existeCodeAttribut(att, listeV)) {
/* 244 */           msg = msg + "\nLe code de l'attribut " + att.getNom() + " existe plusieurs fois dans la liste ";
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 249 */       if (att.getListeAttributs().size() > 0) {
/* 250 */         msg = msg + verifierAttributDeLaListe(att.getListeAttributs(), listeV, listDomaine);
/*     */       }
/*     */     }
/* 253 */     return msg;
/*     */   }
/*     */   
/*     */   private static boolean existeNomAttribut(Attribut2 att, ArrayList<Attribut> liste)
/*     */   {
/* 258 */     String nom = getNomAttribut(att);
/*     */     
/* 260 */     boolean rep = false;
/* 261 */     for (int i = 0; i < liste.size(); i++) {
/* 262 */       if (att != liste.get(i)) {
/* 263 */         Attribut2 a = (Attribut2)liste.get(i);
/* 264 */         if (a.getListeAttributs().size() == 0) {
/* 265 */           if (nom.trim().toUpperCase().equals(getNomAttribut(a).trim().toUpperCase())) {
/* 266 */             return true;
/*     */           }
/*     */         } else {
/* 269 */           rep = existeNomAttribut(att, a.getListeAttributs());
/* 270 */           if (rep) return true;
/*     */         }
/*     */       }
/*     */     }
/* 274 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean existeCodeAttribut(Attribut2 att, ArrayList<Attribut> liste) {
/* 278 */     String nom = getCodeAttribut(att);
/*     */     
/* 280 */     boolean rep = false;
/* 281 */     for (int i = 0; i < liste.size(); i++) {
/* 282 */       if (att != liste.get(i)) {
/* 283 */         Attribut2 a = (Attribut2)liste.get(i);
/* 284 */         if (a.getListeAttributs().size() == 0) {
/* 285 */           if (nom.trim().toUpperCase().equals(getCodeAttribut(a).trim().toUpperCase())) {
/* 286 */             return true;
/*     */           }
/*     */         } else {
/* 289 */           rep = existeNomAttribut(att, a.getListeAttributs());
/* 290 */           if (rep) return true;
/*     */         }
/*     */       }
/*     */     }
/* 294 */     return false;
/*     */   }
/*     */   
/*     */   public static String verifierListeAttributs(ArrayList<Attribut> liste, ArrayList<Domaine> listDomaine) {
/* 298 */     return verifierAttributDeLaListe(liste, liste, listDomaine);
/*     */   }
/*     */   
/*     */   public static String verifierListeAttributsSansAttComposer(ArrayList<Attribut> liste, ArrayList<Domaine> listDomaine) {
/* 302 */     return verifierAttributDeLaListeSansAttComposer(liste, liste, listDomaine);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\verificationAdaptation\VerifAttribut.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */