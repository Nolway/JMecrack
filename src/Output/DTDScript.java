/*     */ package Output;
/*     */ 
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMLD2.MLDEntite2;
/*     */ import Merise.Attribut;
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
/*     */ public class DTDScript
/*     */ {
/*     */   private ArrayList<MLDEntite2> listeEntiteMLD;
/*     */   private ArrayList<IhmEntiteRelation> listeEntiteMCD;
/*     */   private String xmlOutput;
/*     */   
/*     */   public DTDScript(ArrayList<MLDEntite2> listeEntiteMLD, ArrayList<IhmEntiteRelation> listeEntiteMCD)
/*     */   {
/*  25 */     this.listeEntiteMLD = listeEntiteMLD;
/*  26 */     this.listeEntiteMCD = listeEntiteMCD;
/*     */   }
/*     */   
/*     */   private String XMLIntro()
/*     */   {
/*  31 */     return "<?xml version=\"1.0\" encoding =\"ISO-8859-1\" ?>\n";
/*     */   }
/*     */   
/*     */   private String XMLAllList(String db) {
/*  35 */     if (this.listeEntiteMLD.size() == 0) return "";
/*  36 */     String s = "<!ELEMENT " + db + "(";
/*  37 */     String list = "Liste_";
/*     */     
/*  39 */     for (int i = 0; i < this.listeEntiteMLD.size(); i++) { String nomTable;
/*  40 */       if (Setting.SQLUtiliserCode) {
/*  41 */         nomTable = ((MLDEntite2)this.listeEntiteMLD.get(i)).getCode();
/*  42 */         if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/*  43 */           nomTable = Setting.developpeur + "_" + nomTable;
/*     */         }
/*  45 */         nomTable = nomTable.toUpperCase();
/*     */       } else {
/*  47 */         nomTable = ((MLDEntite2)this.listeEntiteMLD.get(i)).getNom();
/*  48 */         if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/*  49 */           nomTable = Setting.developpeur + "_" + nomTable;
/*     */         }
/*     */       }
/*     */       
/*  53 */       s = s + list + nomTable;
/*  54 */       if (i + 1 == this.listeEntiteMLD.size()) {
/*  55 */         s = s + ")>\n";
/*     */       } else {
/*  57 */         s = s + ", ";
/*     */       }
/*     */     }
/*     */     
/*  61 */     return s;
/*     */   }
/*     */   
/*  64 */   private static String ajusterNom(String nom, int tailMax) { nom = SQLOutil.remplaceChar(nom);
/*  65 */     for (int i = nom.length(); i < tailMax; i++) {
/*  66 */       nom = nom + " ";
/*     */     }
/*  68 */     return nom;
/*     */   }
/*     */   
/*     */   private static int longueurMaxAttribut(ArrayList<Attribut> listeAttributs) {
/*  72 */     int max = 0;
/*     */     
/*     */ 
/*  75 */     for (int i = 0; i < listeAttributs.size(); i++) {
/*  76 */       Attribut2 att = (Attribut2)listeAttributs.get(i);
/*  77 */       String nom; if (Setting.SQLUtiliserCode) {
/*  78 */         nom = att.getCode();
/*     */       } else {
/*  80 */         nom = att.getNom();
/*     */       }
/*  82 */       if (nom.length() > max) {
/*  83 */         max = nom.length();
/*     */       }
/*     */     }
/*  86 */     return max + 2;
/*     */   }
/*     */   
/*     */   private String XMLAttribut(MLDEntite2 ent, Attribut att, int lg) {
/*  90 */     String s = "";
/*     */     String nomAtt;
/*  93 */     if (Setting.SQLUtiliserCode) {
/*  94 */       nomAtt = ((Attribut2)att).getCode();
/*     */     } else {
/*  96 */       nomAtt = att.getNom();
/*     */     }
/*     */     
/*     */ 
/* 100 */     s = "   " + ajusterNom(nomAtt, lg);
/* 101 */     if (att.getKey().equals(Parametres.Cle))
/*     */     {
/*     */ 
/*     */ 
/* 105 */       s = s + "   IDREF   #REQUIRED ";
/*     */     }
/*     */     else {
/* 108 */       s = s + "   CDATA   #REQUIRED ";
/*     */     }
/* 110 */     s = s + "\n";
/* 111 */     return s;
/*     */   }
/*     */   
/* 114 */   private String XMLEntite(MLDEntite2 ent) { int lg = 1;
/*     */     
/*     */     ArrayList<Attribut> listeAttribut;
/*     */     
/* 119 */     if (ent.isComposer()) {
/* 120 */       listeAttribut = SQLOutil.decomposerLesAttributsMLDEntite(ent);
/*     */     } else {
/* 122 */       listeAttribut = ent.getListeAttributs();
/*     */     }
/*     */     String nomTable;
/* 125 */     if (Setting.SQLUtiliserCode) {
/* 126 */       nomTable = ent.getCode();
/* 127 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 128 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/* 130 */       nomTable = nomTable.toUpperCase();
/*     */     } else {
/* 132 */       nomTable = ent.getNom();
/* 133 */       if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 134 */         nomTable = Setting.developpeur + "_" + nomTable;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 139 */     if (ent != null) lg = longueurMaxAttribut(listeAttribut);
/* 140 */     String st = "<!ELEMENT  Liste_" + nomTable + "(" + nomTable + "*)>\n";
/* 141 */     st = st + "<!ELEMENT  " + nomTable + "   EMPTY >\n";
/* 142 */     String s = "<!ATTLIST  " + nomTable + "\n";
/* 143 */     for (int i = 0; i < listeAttribut.size(); i++) {
/* 144 */       s = s + XMLAttribut(ent, (Attribut)listeAttribut.get(i), lg);
/*     */     }
/* 146 */     s = s + ">\n";
/* 147 */     return st + s;
/*     */   }
/*     */   
/*     */   public String getXMLString(String dbName) {
/* 151 */     String s = "";
/* 152 */     if (this.listeEntiteMLD.size() == 0) return XMLIntro();
/* 153 */     for (int i = 0; i < this.listeEntiteMLD.size(); i++) {
/* 154 */       s = s + XMLEntite((MLDEntite2)this.listeEntiteMLD.get(i));
/*     */     }
/* 156 */     return XMLIntro() + XMLAllList(dbName) + s;
/*     */   }
/*     */   
/*     */   public ArrayList<IhmEntiteRelation> getListeEntiteMCD() {
/* 160 */     return this.listeEntiteMCD;
/*     */   }
/*     */   
/*     */   public ArrayList<MLDEntite2> getListeEntiteMLD() {
/* 164 */     return this.listeEntiteMLD;
/*     */   }
/*     */   
/*     */   public void setListeEntiteMCD(ArrayList<IhmEntiteRelation> listeEntiteMCD) {
/* 168 */     this.listeEntiteMCD = listeEntiteMCD;
/*     */   }
/*     */   
/*     */   public void setListeEntiteMLD(ArrayList<MLDEntite2> listeEntiteMLD) {
/* 172 */     this.listeEntiteMLD = listeEntiteMLD;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Output\DTDScript.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */