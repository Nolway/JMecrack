/*     */ package Contrainte;
/*     */ 
/*     */ import IhmMLD2.MLDEntite2;
/*     */ import Merise.Attribut;
/*     */ import Merise2.Attribut2;
/*     */ import Merise2.Historique;
/*     */ import Outil.Setting;
/*     */ import Output.SQLOutil;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
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
/*     */ public class TableReference
/*     */   implements Serializable
/*     */ {
/*     */   String nom;
/*     */   String type;
/*     */   String origine;
/*     */   MLDEntite2 entite;
/*     */   MLDEntite2 entiteRef;
/*     */   ArrayList<AttributReference> listeAttributRef;
/*     */   boolean SQLGenerer;
/*     */   String clText;
/*     */   String clFond;
/*     */   String clText1;
/*     */   String clFond1;
/*     */   private ArrayList<Historique> historique;
/*     */   boolean augmentationPrefix;
/*     */   String augmentation;
/*     */   public static final String TYPE_CNT_FK = "FOREING KEY";
/*     */   public static final String TYPE_CNT_AK = "UNIQUE";
/*     */   public static final String TYPE_CNT_IX = "INDEX";
/*     */   
/*     */   public TableReference(String nom, String type, MLDEntite2 entite, MLDEntite2 entiteRef)
/*     */   {
/*  47 */     this.nom = nom;
/*  48 */     this.type = type;
/*  49 */     this.entite = entite;
/*  50 */     this.entiteRef = entiteRef;
/*  51 */     this.listeAttributRef = new ArrayList();
/*  52 */     this.SQLGenerer = false;
/*  53 */     this.origine = "";
/*  54 */     this.clText = "";
/*  55 */     this.clFond = "";
/*  56 */     this.clText1 = "";
/*  57 */     this.clFond1 = " ";
/*  58 */     this.historique = new ArrayList();
/*  59 */     this.augmentation = "";
/*  60 */     this.augmentationPrefix = false;
/*     */   }
/*     */   
/*     */   public TableReference(String nom, String type) {
/*  64 */     this.nom = nom;
/*  65 */     this.type = type;
/*  66 */     this.entite = null;
/*  67 */     this.entiteRef = null;
/*  68 */     this.listeAttributRef = new ArrayList();
/*  69 */     this.SQLGenerer = false;
/*  70 */     this.origine = "";
/*  71 */     this.clText = "";
/*  72 */     this.clFond = "";
/*  73 */     this.clText1 = "";
/*  74 */     this.clFond1 = " ";
/*  75 */     this.historique = new ArrayList();
/*  76 */     this.augmentation = "";
/*  77 */     this.augmentationPrefix = false;
/*     */   }
/*     */   
/*     */   public MLDEntite2 getEntite() {
/*  81 */     return this.entite;
/*     */   }
/*     */   
/*     */   public MLDEntite2 getEntiteRef() {
/*  85 */     return this.entiteRef;
/*     */   }
/*     */   
/*     */   public ArrayList<AttributReference> getListeAttributRef() {
/*  89 */     return this.listeAttributRef;
/*     */   }
/*     */   
/*     */   public String getNom() {
/*  93 */     return this.nom;
/*     */   }
/*     */   
/*     */   public String getType() {
/*  97 */     return this.type;
/*     */   }
/*     */   
/*     */   public String getOrigine() {
/* 101 */     return this.origine;
/*     */   }
/*     */   
/*     */   public boolean isSQLGenerer() {
/* 105 */     return this.SQLGenerer;
/*     */   }
/*     */   
/*     */   public void setEntite(MLDEntite2 entite) {
/* 109 */     this.entite = entite;
/*     */   }
/*     */   
/*     */   public void setEntiteRef(MLDEntite2 entiteRef) {
/* 113 */     this.entiteRef = entiteRef;
/*     */   }
/*     */   
/*     */   public void setOrigine(String origine) {
/* 117 */     this.origine = origine;
/*     */   }
/*     */   
/*     */   public void setListeAttributRef(ArrayList<AttributReference> listeAttributRef) {
/* 121 */     this.listeAttributRef = listeAttributRef;
/*     */   }
/*     */   
/*     */   public void setNom(String nom) {
/* 125 */     this.nom = nom;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/* 129 */     this.type = type;
/*     */   }
/*     */   
/*     */   public void setSQLGenerer(boolean SQLGenerer) {
/* 133 */     this.SQLGenerer = SQLGenerer;
/*     */   }
/*     */   
/*     */   public void addReference(Attribut att, Attribut attRef)
/*     */   {
/* 138 */     this.listeAttributRef.add(new AttributReference(att, attRef));
/*     */   }
/*     */   
/*     */   private String getToStringListeAttributRef() {
/* 142 */     String s = "";
/* 143 */     for (int i = 0; i < this.listeAttributRef.size(); i++) {
/* 144 */       s = s + "\n\t" + ((AttributReference)this.listeAttributRef.get(i)).toString();
/*     */     }
/* 146 */     return s;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 151 */     String s = "";
/* 152 */     if (this.entite == null) return " ==== Table est null";
/* 153 */     if (this.entiteRef == null) return " ==== Table Ref est null";
/* 154 */     s = "[" + this.entite.getNom() + "," + this.entiteRef.getNom() + "]";
/* 155 */     s = s + getToStringListeAttributRef();
/* 156 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */   private AttributReference retournerAttributReference(Attribut attRef)
/*     */   {
/* 162 */     for (int i = 0; i < this.listeAttributRef.size(); i++) {
/* 163 */       if (((AttributReference)this.listeAttributRef.get(i)).getAttributRef() == attRef)
/* 164 */         return (AttributReference)this.listeAttributRef.get(i);
/*     */     }
/* 166 */     return null;
/*     */   }
/*     */   
/*     */   public void trierListeAttributReferent() {
/* 170 */     if (this.listeAttributRef.size() < 2) return;
/* 171 */     ArrayList<AttributReference> listeTrier = new ArrayList();
/* 172 */     ArrayList<Attribut> listeKeyRef = new ArrayList();
/* 173 */     listeKeyRef = this.entiteRef.getListeKey();
/*     */     
/* 175 */     for (int i = 0; i < listeKeyRef.size(); i++) {
/* 176 */       AttributReference c = retournerAttributReference((Attribut)listeKeyRef.get(i));
/* 177 */       if (c != null) {
/* 178 */         listeTrier.add(c);
/*     */       } else {
/* 180 */         JOptionPane.showMessageDialog(new JFrame(), " Tres grave Reference non trouver: TrierListeAttribut de la classe TableReference");
/*     */       }
/*     */     }
/* 183 */     setListeAttributRef(listeTrier);
/*     */   }
/*     */   
/*     */   private String getSQLAttribut(Attribut2 att) {
/* 187 */     String sAtt = "";
/* 188 */     if (Setting.SQLUtiliserCode) {
/* 189 */       sAtt = SQLOutil.remplaceChar(att.getCode());
/*     */     } else {
/* 191 */       sAtt = SQLOutil.remplaceChar(att.getNom());
/*     */     }
/* 193 */     return sAtt;
/*     */   }
/*     */   
/*     */   private String getSQLNomTable(MLDEntite2 ent) {
/* 197 */     String st = "";String s = "";
/* 198 */     if (Setting.SQLAugmenterNomTableParDeveloppeur2) {
/* 199 */       s = SQLOutil.remplaceChar(Setting.developpeur);
/* 200 */       s = s.toUpperCase();
/*     */     }
/* 202 */     if (Setting.SQLUtiliserCode) {
/* 203 */       st = SQLOutil.remplaceChar(ent.getCode());
/*     */     } else {
/* 205 */       st = SQLOutil.remplaceChar(ent.getNom());
/*     */     }
/* 207 */     if (s.length() == 0) s = st; else
/* 208 */       s = s + "_" + st;
/* 209 */     return s;
/*     */   }
/*     */   
/*     */   public String getSQLForeingKeyContrainte() {
/* 213 */     String s = "";
/* 214 */     String cle = "";String cleRef = "";
/* 215 */     for (int i = 0; i < this.listeAttributRef.size(); i++) {
/* 216 */       s = getSQLAttribut((Attribut2)((AttributReference)this.listeAttributRef.get(i)).getAttribut());
/* 217 */       if (cle.length() == 0) cle = s; else
/* 218 */         cle = cle + ", " + s;
/* 219 */       s = getSQLAttribut((Attribut2)((AttributReference)this.listeAttributRef.get(i)).getAttributRef());
/* 220 */       if (cleRef.length() == 0) cleRef = s; else {
/* 221 */         cleRef = cleRef + ", " + s;
/*     */       }
/*     */     }
/* 224 */     if (cle.length() > 0) {
/* 225 */       s = "\n\t FOREIGN KEY (" + cle + ")\n\t REFERENCES " + getSQLNomTable(this.entiteRef) + "(" + cleRef + ")";
/*     */     }
/*     */     
/* 228 */     return s;
/*     */   }
/*     */   
/*     */   public String getSQLUniqueContrainte() {
/* 232 */     String s = "";
/* 233 */     String cle = "";String cleRef = "";
/* 234 */     for (int i = 0; i < this.listeAttributRef.size(); i++) {
/* 235 */       s = getSQLAttribut((Attribut2)((AttributReference)this.listeAttributRef.get(i)).getAttribut());
/* 236 */       if (cle.length() == 0) cle = s; else {
/* 237 */         cle = cle + "," + s;
/*     */       }
/*     */     }
/* 240 */     if (cle.length() > 0) {
/* 241 */       s = "\n\t UNIQUE (" + cle + ") ";
/*     */     }
/*     */     
/* 244 */     return s;
/*     */   }
/*     */   
/*     */   public void setNomContrainte()
/*     */   {
/* 249 */     String nomCnt = getSQLNomTable(this.entite) + "_" + getSQLNomTable(this.entiteRef);
/* 250 */     setNom(nomCnt);
/*     */   }
/*     */   
/*     */   public String getSQLNomContrainte()
/*     */   {
/* 255 */     String n = "";
/* 256 */     String prefix = "";
/* 257 */     String nomCnt = getNom();
/*     */     
/* 259 */     if (getType().equals("FOREING KEY")) {
/* 260 */       prefix = "FK";
/*     */     } else {
/* 262 */       prefix = "AK";
/*     */     }
/*     */     
/* 265 */     if (Setting.SQLPrefixerLeNomContrainte2) {
/* 266 */       n = prefix + "_" + n + nomCnt;
/*     */     } else {
/* 268 */       n = n + nomCnt + "_" + prefix;
/*     */     }
/* 270 */     if (Setting.SQLUtiliserCode) { n = n.toUpperCase();
/*     */     }
/* 272 */     return n;
/*     */   }
/*     */   
/*     */   public static String getTYPE_CNT_AK() {
/* 276 */     return "UNIQUE";
/*     */   }
/*     */   
/*     */   public static String getTYPE_CNT_FK() {
/* 280 */     return "FOREING KEY";
/*     */   }
/*     */   
/*     */   public static String getTYPE_CNT_IX() {
/* 284 */     return "INDEX";
/*     */   }
/*     */   
/*     */   public String getAugmentation() {
/* 288 */     return this.augmentation;
/*     */   }
/*     */   
/*     */   public boolean isAugmentationPrefix() {
/* 292 */     return this.augmentationPrefix;
/*     */   }
/*     */   
/*     */   public String getClFond() {
/* 296 */     return this.clFond;
/*     */   }
/*     */   
/*     */   public String getClFond1() {
/* 300 */     return this.clFond1;
/*     */   }
/*     */   
/*     */   public String getClText() {
/* 304 */     return this.clText;
/*     */   }
/*     */   
/*     */   public String getClText1() {
/* 308 */     return this.clText1;
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> getHistorique() {
/* 312 */     return this.historique;
/*     */   }
/*     */   
/*     */   public void setAugmentation(String augmentation) {
/* 316 */     this.augmentation = augmentation;
/*     */   }
/*     */   
/*     */   public void setAugmentationPrefix(boolean augmentationPrefix) {
/* 320 */     this.augmentationPrefix = augmentationPrefix;
/*     */   }
/*     */   
/*     */   public void setClFond(String clFond) {
/* 324 */     this.clFond = clFond;
/*     */   }
/*     */   
/*     */   public void setClFond1(String clFond1) {
/* 328 */     this.clFond1 = clFond1;
/*     */   }
/*     */   
/*     */   public void setClText(String clText) {
/* 332 */     this.clText = clText;
/*     */   }
/*     */   
/*     */   public void setClText1(String clText1) {
/* 336 */     this.clText1 = clText1;
/*     */   }
/*     */   
/*     */   public void setHistorique(ArrayList<Historique> historique) {
/* 340 */     this.historique = historique;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Contrainte\TableReference.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */