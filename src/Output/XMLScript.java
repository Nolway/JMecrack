/*     */ package Output;
/*     */ 
/*     */ import IhmMCD.IhmEntite;
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmLien;
/*     */ import IhmMCD.IhmLienHeritage;
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD.IhmRelation;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmLienHeritage2;
/*     */ import Merise.Attribut;
/*     */ import Merise.Entite;
/*     */ import Merise.Relation;
/*     */ import Outil.Parametres;
/*     */ import formes.FormeConstruction;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JProgressBar;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XMLScript
/*     */ {
/*     */   private static String xmlIntro()
/*     */   {
/*  31 */     String s = "";
/*  32 */     s = s + "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
/*  33 */     s = s + "<work>\n";
/*  34 */     s = s + "\t<about>\n";
/*  35 */     s = s + "\t\t<version num=\"" + Parametres.version + "\"/>\n";
/*  36 */     s = s + "\t\t<author>\n";
/*  37 */     s = s + "\t\t\t<name>MESSOUCI</name>\n";
/*  38 */     s = s + "\t\t\t<email>jmerise@jfreesoft.com</email>\n";
/*  39 */     s = s + "\t\t</author>\n";
/*  40 */     s = s + "\t</about>\n";
/*  41 */     return s;
/*     */   }
/*     */   
/*     */   private static String getBoolean(boolean b) {
/*  45 */     if (b) return "true";
/*  46 */     return "false";
/*     */   }
/*     */   
/*     */   private static String xlmAttribut(Attribut att) {
/*  50 */     String lg = att.getLongueur() + "";
/*  51 */     String ld = att.getLongDecimale() + "";
/*  52 */     String s = "\t\t\t<attribut name =\"" + att.getNom() + "\" type=\"" + att.getType() + "\"" + " size1=\"" + lg + "\"" + " size2=\"" + ld + "\"" + " key=\"" + att.getKey() + "\" isnull=\"" + getBoolean(att.isNulle()) + "\" comment=\"" + att.getCommentaire() + "\"/>";
/*     */     
/*     */ 
/*     */ 
/*  56 */     return s;
/*     */   }
/*     */   
/*     */   private static String xlmListeAttribut(Entite ent) {
/*  60 */     String s = "";
/*     */     
/*  62 */     ArrayList<Attribut> listeAttribut = SQLOutil.decomposerLesAttributsListe(ent.getListeAttributs());
/*  63 */     for (int i = 0; i < listeAttribut.size(); i++) {
/*  64 */       s = s + xlmAttribut((Attribut)listeAttribut.get(i)) + "\n";
/*     */     }
/*  66 */     return s;
/*     */   }
/*     */   
/*     */   private static String xlmListeAttribut(Relation rel) {
/*  70 */     String s = "";
/*     */     
/*  72 */     ArrayList<Attribut> listeAttribut = SQLOutil.decomposerLesAttributsListe(rel.getListeAttributs());
/*     */     
/*  74 */     for (int i = 0; i < listeAttribut.size(); i++) {
/*  75 */       s = s + xlmAttribut((Attribut)listeAttribut.get(i)) + "\n";
/*     */     }
/*  77 */     return s;
/*     */   }
/*     */   
/*     */   private static String xlmIhmEntite(IhmEntite ent) {
/*  81 */     String s = "";
/*  82 */     s = "\t\t<entite name=\"" + ent.getEntite().getNom() + "\" x=\"" + ent.getX() + "\" y=\"" + ent.getY() + "\">\n";
/*  83 */     s = s + xlmListeAttribut(ent.getEntite()) + "\n";
/*  84 */     s = s + "\t\t</entite>\n";
/*  85 */     return s;
/*     */   }
/*     */   
/*     */   private static String xlmIhmEntite(IhmRelation rel) {
/*  89 */     String s = "";
/*  90 */     s = "\t\t<relation name=\"" + rel.getRelation().getNom() + "\" x=\"" + rel.getX() + "\" y=\"" + rel.getY() + "\">\n";
/*  91 */     s = s + xlmListeAttribut(rel.getRelation()) + "\n";
/*  92 */     s = s + "\t\t</relation>\n";
/*  93 */     return s;
/*     */   }
/*     */   
/*     */   private static String xmlListeEntite(ArrayList<IhmEntiteRelation> li) {
/*  97 */     String s = "";
/*  98 */     s = s + "\t<entitiesList>\n";
/*  99 */     for (int i = 0; i < li.size(); i++) {
/* 100 */       if ((li.get(i) instanceof IhmEntite)) {
/* 101 */         s = s + xlmIhmEntite((IhmEntite)li.get(i)) + "\n";
/*     */       }
/* 103 */       if ((li.get(i) instanceof IhmRelation)) {
/* 104 */         s = s + xlmIhmEntite((IhmRelation)li.get(i)) + "\n";
/*     */       }
/*     */     }
/* 107 */     s = s + "\t</entitiesList>\n";
/* 108 */     return s;
/*     */   }
/*     */   
/*     */   private static String xmlLien(IhmLien l) {
/* 112 */     String s = "";
/* 113 */     s = s + "\t\t<link name=\"" + l.getNom() + "\" card=\"" + l.getCardinalite() + "\" elem1=\"" + l.getEntite().getEntite().getNom() + "\" elem2=\"" + l.getRelation().getRelation().getNom() + "\" casse=\"" + getBoolean(l.isCassure()) + "\" x=\"" + l.getxCassure() + "\" y=\"" + l.getyCassure() + "\" />";
/*     */     
/* 115 */     return s;
/*     */   }
/*     */   
/*     */   private static String xmlListeLien(ArrayList<IhmLien> li) {
/* 119 */     String s = "";
/* 120 */     s = s + "\t<LinkList>\n";
/* 121 */     for (int i = 0; i < li.size(); i++) {
/* 122 */       s = s + xmlLien((IhmLien)li.get(i)) + "\n";
/*     */     }
/* 124 */     s = s + "\t</LinkList>\n";
/* 125 */     return s;
/*     */   }
/*     */   
/*     */   private static String xmlHeritage(IhmLienHeritage h) {
/* 129 */     String s = "";
/* 130 */     s = s + "\t\t<hlien name =\"" + h.getNom() + "\" entiPere =\"" + ((IhmEntite2)((IhmLienHeritage2)h).getPere()).getEntite().getNom() + "\" entFils =\"" + ((IhmEntite2)((IhmLienHeritage2)h).getFils()).getEntite().getNom() + "\" />\n";
/*     */     
/*     */ 
/* 133 */     return s;
/*     */   }
/*     */   
/*     */   private static String xmlListeHeritage(ArrayList<IhmLienHeritage> l) {
/* 137 */     String s = "\t<heritageList>\n";
/* 138 */     for (int i = 0; i < l.size(); i++) {
/* 139 */       s = s + xmlHeritage((IhmLienHeritage)l.get(i));
/*     */     }
/* 141 */     s = s + "\t</heritageList>\n";
/* 142 */     return s;
/*     */   }
/*     */   
/*     */   public static String getXmlOfWork(IhmPageMCD page, FormeConstruction frmCons)
/*     */   {
/* 147 */     String s = "";
/* 148 */     s = s + xmlIntro();
/* 149 */     s = s + "<MCD>\n";
/* 150 */     frmCons.getjProgBar().setValue(10);
/* 151 */     s = s + xmlListeEntite(page.getListeEntiteRelation());
/* 152 */     frmCons.getjProgBar().setValue(70);
/* 153 */     s = s + xmlListeLien(page.getListeLien());
/* 154 */     frmCons.getjProgBar().setValue(80);
/* 155 */     s = s + xmlListeHeritage(page.getListeLienHeritage());
/* 156 */     s = s + "</MCD>\n";
/* 157 */     s = s + "</work>\n";
/* 158 */     frmCons.getjProgBar().setValue(90);
/*     */     
/* 160 */     return s;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Output\XMLScript.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */