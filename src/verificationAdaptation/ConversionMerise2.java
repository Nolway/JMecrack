/*     */ package verificationAdaptation;
/*     */ 
/*     */ import IhmMCD.IhmCIF;
/*     */ import IhmMCD.IhmCommentaireIndip;
/*     */ import IhmMCD.IhmContrainte;
/*     */ import IhmMCD.IhmEntite;
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmHeritage;
/*     */ import IhmMCD.IhmLien;
/*     */ import IhmMCD.IhmLienCif;
/*     */ import IhmMCD.IhmLienCommentaire;
/*     */ import IhmMCD.IhmLienContrainteHeritage;
/*     */ import IhmMCD.IhmLienContraintes;
/*     */ import IhmMCD.IhmLienHeritage;
/*     */ import IhmMCD.IhmPostIt;
/*     */ import IhmMCD.IhmRelation;
/*     */ import IhmMCD2.IhmCIF2;
/*     */ import IhmMCD2.IhmCommentaire2;
/*     */ import IhmMCD2.IhmContrainte2;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmHeritage2;
/*     */ import IhmMCD2.IhmLien2;
/*     */ import IhmMCD2.IhmLienCIF2;
/*     */ import IhmMCD2.IhmLienCommentaire2;
/*     */ import IhmMCD2.IhmLienContrainteHeritage2;
/*     */ import IhmMCD2.IhmLienContraintes2;
/*     */ import IhmMCD2.IhmLienHeritage2;
/*     */ import IhmMCD2.IhmPostIt2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import Merise.Attribut;
/*     */ import Merise.Entite;
/*     */ import Merise.Relation;
/*     */ import Merise2.Attribut2;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ public class ConversionMerise2
/*     */ {
/*  49 */   public static Map<Object, Object> listeCorresp = new HashMap();
/*     */   
/*     */   public static Attribut2 corrigerAttribut(Attribut2 att)
/*     */   {
/*  53 */     if (att.getType().trim().toUpperCase().equals("DATE")) {
/*  54 */       att.setLongueur(-1);
/*  55 */       att.setLongDecimale(-1);
/*  56 */       return att;
/*     */     }
/*     */     
/*  59 */     if (!att.getType().trim().toUpperCase().equals("VARCHAR")) {
/*  60 */       if ((att.getLongueur() == 25) || (att.getLongueur() == 0)) {
/*  61 */         att.setLongueur(-1);
/*     */       }
/*  63 */       if ((att.getLongDecimale() == 25) || (att.getLongDecimale() == 0)) {
/*  64 */         att.setLongueur(-1);
/*     */       }
/*     */     } else {
/*  67 */       att.setLongDecimale(-1);
/*     */     }
/*  69 */     return att;
/*     */   }
/*     */   
/*     */   public static ArrayList<Attribut> conversionListeAttribut(ArrayList<Attribut> listeAtt)
/*     */   {
/*  74 */     ArrayList<Attribut> liste = new ArrayList();
/*     */     
/*  76 */     for (int i = 0; i < listeAtt.size(); i++) {
/*  77 */       Attribut2 a = Attribut2.parseAttrinut((Attribut)listeAtt.get(i));
/*  78 */       a = corrigerAttribut(a);
/*  79 */       liste.add(a);
/*     */     }
/*  81 */     return liste;
/*     */   }
/*     */   
/*     */   public static ArrayList<IhmEntiteRelation> conversionEntitreRelation(ArrayList<IhmEntiteRelation> liste) {
/*  85 */     ArrayList<IhmEntiteRelation> l = new ArrayList();
/*     */     
/*     */ 
/*     */ 
/*  89 */     for (int i = 0; i < liste.size(); i++) {
/*  90 */       IhmEntiteRelation oldEnt = (IhmEntiteRelation)liste.get(i);
/*  91 */       if ((oldEnt instanceof IhmEntite)) {
/*  92 */         IhmEntiteRelation newEnt = IhmEntite2.parseIhmEntite((IhmEntite)oldEnt);
/*  93 */         ((IhmEntite2)newEnt).getEntite().setListeAttributs(conversionListeAttribut(((IhmEntite2)newEnt).getEntite().getListeAttributs()));
/*  94 */         listeCorresp.put(oldEnt, newEnt);
/*  95 */         l.add(newEnt);
/*     */       }
/*  97 */       if ((oldEnt instanceof IhmRelation)) {
/*  98 */         IhmEntiteRelation newEnt = IhmRelation2.parseIhmRelation((IhmRelation)oldEnt);
/*  99 */         ((IhmRelation2)newEnt).getRelation().setListeAttributs(conversionListeAttribut(((IhmRelation2)newEnt).getRelation().getListeAttributs()));
/* 100 */         listeCorresp.put(oldEnt, newEnt);
/* 101 */         l.add(newEnt);
/*     */       }
/*     */     }
/*     */     
/* 105 */     return l;
/*     */   }
/*     */   
/*     */   public static ArrayList<IhmLien> conversionLien(ArrayList<IhmLien> liste) {
/* 109 */     ArrayList<IhmLien> l = new ArrayList();
/*     */     
/*     */ 
/* 112 */     for (int i = 0; i < liste.size(); i++) {
/* 113 */       IhmEntiteRelation ent = ((IhmLien)liste.get(i)).getEntite();
/* 114 */       IhmEntiteRelation rel = ((IhmLien)liste.get(i)).getRelation();
/* 115 */       ent = (IhmEntiteRelation)listeCorresp.get(ent);
/* 116 */       rel = (IhmEntiteRelation)listeCorresp.get(rel);
/*     */       
/* 118 */       IhmLien2 lien = IhmLien2.parseIhmLien((IhmLien)liste.get(i), ent, rel);
/* 119 */       l.add(lien);
/*     */     }
/*     */     
/* 122 */     return l;
/*     */   }
/*     */   
/*     */   public static ArrayList<IhmEntiteRelation> conversionContrainte(ArrayList<IhmEntiteRelation> liste) {
/* 126 */     ArrayList<IhmEntiteRelation> lCont = new ArrayList();
/*     */     
/* 128 */     for (int i = 0; i < liste.size(); i++) {
/* 129 */       IhmContrainte oldCnt = (IhmContrainte)liste.get(i);
/*     */       
/* 131 */       IhmContrainte newCnt = IhmContrainte2.parseContrainte(oldCnt);
/* 132 */       listeCorresp.put(oldCnt, newCnt);
/* 133 */       lCont.add(newCnt);
/*     */     }
/* 135 */     return lCont;
/*     */   }
/*     */   
/*     */   public static ArrayList<IhmLienContraintes> conversionLienContrainte(ArrayList<IhmLienContraintes> liste) {
/* 139 */     ArrayList<IhmLienContraintes> lLienCont = new ArrayList();
/*     */     
/*     */ 
/*     */ 
/* 143 */     for (int i = 0; i < liste.size(); i++) {
/* 144 */       IhmLienContraintes lien = (IhmLienContraintes)liste.get(i);
/* 145 */       IhmContrainte cnt = (IhmContrainte)((IhmLienContraintes)liste.get(i)).getContrainte();
/* 146 */       IhmEntiteRelation ent = ((IhmLienContraintes)liste.get(i)).getEntRel();
/* 147 */       cnt = (IhmContrainte)listeCorresp.get(cnt);
/* 148 */       ent = (IhmEntiteRelation)listeCorresp.get(ent);
/* 149 */       lien = IhmLienContraintes2.parseIhmLienContrainte(lien, ent, cnt);
/* 150 */       lLienCont.add(lien);
/*     */     }
/*     */     
/*     */ 
/* 154 */     return lLienCont;
/*     */   }
/*     */   
/*     */   public static ArrayList<IhmCIF> conversionCIF(ArrayList<IhmCIF> liste) {
/* 158 */     ArrayList<IhmCIF> lCont = new ArrayList();
/*     */     
/* 160 */     for (int i = 0; i < liste.size(); i++) {
/* 161 */       IhmCIF oldCif = (IhmCIF)liste.get(i);
/* 162 */       IhmCIF newCif = IhmCIF2.parseCIF(oldCif);
/* 163 */       listeCorresp.put(oldCif, newCif);
/* 164 */       lCont.add(newCif);
/*     */     }
/* 166 */     return lCont;
/*     */   }
/*     */   
/*     */   public static ArrayList<IhmLienCif> conversionLienCIF(ArrayList<IhmLienCif> liste) {
/* 170 */     ArrayList<IhmLienCif> lLienCont = new ArrayList();
/*     */     
/*     */ 
/*     */ 
/* 174 */     for (int i = 0; i < liste.size(); i++) {
/* 175 */       IhmLienCif lien = (IhmLienCif)liste.get(i);
/* 176 */       IhmCIF cif = ((IhmLienCif)liste.get(i)).getCif();
/* 177 */       IhmEntiteRelation ent = ((IhmLienCif)liste.get(i)).getEntite();
/* 178 */       cif = (IhmCIF2)listeCorresp.get(cif);
/* 179 */       ent = (IhmEntiteRelation)listeCorresp.get(ent);
/* 180 */       lien = IhmLienCIF2.parseIhmLienCIF(lien, ent, (IhmCIF2)cif);
/* 181 */       lLienCont.add(lien);
/*     */     }
/*     */     
/* 184 */     return lLienCont;
/*     */   }
/*     */   
/*     */   public static ArrayList<IhmHeritage> conversionHeritage(ArrayList<IhmHeritage> liste) {
/* 188 */     ArrayList<IhmHeritage> lCont = new ArrayList();
/*     */     
/*     */ 
/* 191 */     for (int i = 0; i < liste.size(); i++) {
/* 192 */       IhmHeritage oldHer = (IhmHeritage)liste.get(i);
/* 193 */       IhmEntiteRelation entRel = (IhmEntiteRelation)listeCorresp.get(oldHer.getEntitePere());
/* 194 */       IhmHeritage newHer = IhmHeritage2.ParseHeritage(oldHer, entRel);
/* 195 */       listeCorresp.put(oldHer, newHer);
/* 196 */       lCont.add(newHer);
/*     */     }
/* 198 */     return lCont;
/*     */   }
/*     */   
/*     */   public static ArrayList<IhmLienHeritage> conversionLienHeritage(ArrayList<IhmLienHeritage> liste) {
/* 202 */     ArrayList<IhmLienHeritage> lLienHeri = new ArrayList();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 207 */     for (int i = 0; i < liste.size(); i++)
/*     */     {
/* 209 */       IhmLienHeritage lien = (IhmLienHeritage)liste.get(i);
/* 210 */       IhmEntiteRelation newPere = (IhmEntiteRelation)listeCorresp.get(lien.getEntite());
/* 211 */       IhmEntiteRelation newFils = (IhmEntiteRelation)listeCorresp.get(lien.getEntitefils());
/* 212 */       IhmLienHeritage2 newlien = IhmLienHeritage2.parseIhmLienHeritage(newPere, newFils);
/*     */       
/* 214 */       lLienHeri.add(newlien);
/*     */     }
/*     */     
/* 217 */     return lLienHeri;
/*     */   }
/*     */   
/*     */   public static ArrayList<IhmLienContrainteHeritage> conversionLienContrainteHeritage(ArrayList<IhmLienContrainteHeritage> liste) {
/* 221 */     ArrayList<IhmLienContrainteHeritage> lLienHeri = new ArrayList();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 226 */     for (int i = 0; i < liste.size(); i++)
/*     */     {
/* 228 */       IhmLienContrainteHeritage lien = (IhmLienContrainteHeritage)liste.get(i);
/* 229 */       IhmEntiteRelation newEntite = (IhmEntiteRelation)listeCorresp.get(lien.getEntite());
/* 230 */       IhmHeritage newHer = (IhmHeritage2)listeCorresp.get(lien.getHeritage());
/*     */       
/* 232 */       IhmLienContrainteHeritage2 newlien = IhmLienContrainteHeritage2.parseIhmLienContrainteHeritage(lien, newEntite, (IhmHeritage2)newHer);
/*     */       
/* 234 */       lLienHeri.add(newlien);
/*     */     }
/*     */     
/* 237 */     return lLienHeri;
/*     */   }
/*     */   
/*     */   public static ArrayList<IhmCommentaireIndip> conversionCommentaire(ArrayList<IhmCommentaireIndip> liste)
/*     */   {
/* 242 */     ArrayList<IhmCommentaireIndip> lComm = new ArrayList();
/*     */     
/*     */ 
/*     */ 
/* 246 */     for (int i = 0; i < liste.size(); i++)
/*     */     {
/* 248 */       IhmCommentaireIndip oldCom = (IhmCommentaireIndip)liste.get(i);
/* 249 */       if ((oldCom instanceof IhmPostIt)) {
/* 250 */         IhmPostIt2 newpost = IhmPostIt2.parsePostIt((IhmPostIt)oldCom);
/* 251 */         listeCorresp.put(oldCom, newpost);
/* 252 */         lComm.add(newpost);
/*     */       }
/*     */       else {
/* 255 */         IhmCommentaire2 newCom = IhmCommentaire2.parseCommenataire(oldCom);
/* 256 */         listeCorresp.put(oldCom, newCom);
/* 257 */         lComm.add(newCom);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 262 */     return lComm;
/*     */   }
/*     */   
/*     */   public static ArrayList<IhmLienCommentaire> conversionLienCommentaire(ArrayList<IhmLienCommentaire> liste)
/*     */   {
/* 267 */     ArrayList<IhmLienCommentaire> lLienCom = new ArrayList();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 273 */     for (int i = 0; i < liste.size(); i++) {
/* 274 */       IhmLienCommentaire lien = (IhmLienCommentaire)liste.get(i);
/*     */       
/* 276 */       IhmCommentaireIndip com = lien.getCommentaire();
/* 277 */       IhmEntiteRelation ent = lien.getEntRel();
/* 278 */       com = (IhmCommentaire2)listeCorresp.get(com);
/* 279 */       ent = (IhmEntiteRelation)listeCorresp.get(ent);
/* 280 */       IhmLienCommentaire2 ll = IhmLienCommentaire2.parseLienCommentaire(lien, com, ent);
/*     */       
/* 282 */       lLienCom.add(ll);
/*     */     }
/*     */     
/* 285 */     return lLienCom;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\verificationAdaptation\ConversionMerise2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */