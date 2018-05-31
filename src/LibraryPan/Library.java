/*     */ package LibraryPan;
/*     */ 
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD2.IhmEntite2;
/*     */ import IhmMCD2.IhmRelation2;
/*     */ import Merise.Entite;
/*     */ import Merise.Relation;
/*     */ import Merise2.Historique;
/*     */ import Outil.Setting;
/*     */ import java.awt.Color;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Library
/*     */   implements Serializable
/*     */ {
/*     */   public String name;
/*     */   public String path;
/*     */   public String repertoire;
/*     */   public ArrayList<IhmEntiteRelation> models;
/*     */   public ArrayList<Historique> historique;
/*     */   public String commentaire;
/*     */   public int couleur;
/*     */   
/*     */   public Library(String name)
/*     */   {
/*  40 */     this.name = name;
/*  41 */     this.path = "";
/*  42 */     this.repertoire = "";
/*  43 */     this.commentaire = "";
/*  44 */     this.couleur = Integer.parseInt(Setting.couleurLibrairieSel);
/*  45 */     this.models = new ArrayList();
/*  46 */     this.historique = new ArrayList();
/*  47 */     this.historique.add(Historique.getHistoriqueCreation());
/*     */   }
/*     */   
/*     */   public int getColor() {
/*  51 */     return this.couleur;
/*     */   }
/*     */   
/*     */   public Color getCouleur() {
/*  55 */     return new Color(this.couleur);
/*     */   }
/*     */   
/*     */   public void setCouleur(int couleur) {
/*  59 */     this.couleur = couleur;
/*     */   }
/*     */   
/*     */   public void setCouleur(Color cl) {
/*  63 */     this.couleur = cl.getRGB();
/*     */   }
/*     */   
/*     */   public String getRepertoire() {
/*  67 */     return this.repertoire;
/*     */   }
/*     */   
/*     */   public void setRepertoire(String repertoire) {
/*  71 */     this.repertoire = repertoire;
/*     */   }
/*     */   
/*     */   public String getCommentaire() {
/*  75 */     return this.commentaire;
/*     */   }
/*     */   
/*     */   public ArrayList<Historique> getHistorique() {
/*  79 */     return this.historique;
/*     */   }
/*     */   
/*     */   public void setCommentaire(String commentaire) {
/*  83 */     this.commentaire = commentaire;
/*     */   }
/*     */   
/*     */   public void setHistorique(ArrayList<Historique> historique) {
/*  87 */     this.historique = historique;
/*     */   }
/*     */   
/*     */   public boolean addModel(IhmEntiteRelation model) {
/*  91 */     if (!existModel(getName(model))) {
/*  92 */       this.models.add(model);
/*  93 */       saveLib();
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int getNombreUtilisation(IhmEntiteRelation ent) {
/* 100 */     int nb = 1;
/* 101 */     if ((ent instanceof IhmEntite2)) {
/* 102 */       return ((IhmEntite2)ent).getNbUsedLibrairie();
/*     */     }
/* 104 */     if ((ent instanceof IhmRelation2)) {
/* 105 */       return ((IhmRelation2)ent).getNbUsedLibrairie();
/*     */     }
/* 107 */     return nb;
/*     */   }
/*     */   
/*     */   public void setNombreUtilisation(IhmEntiteRelation ent, int nb) {
/* 111 */     if ((ent instanceof IhmEntite2)) {
/* 112 */       ((IhmEntite2)ent).setNbUsedLibrairie(nb);
/*     */     }
/* 114 */     if ((ent instanceof IhmRelation2)) {
/* 115 */       ((IhmRelation2)ent).setNbUsedLibrairie(nb);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean addModel(ArrayList<IhmEntiteRelation> liste) {
/* 120 */     for (int i = 0; i < liste.size(); i++) {
/* 121 */       int num = existNumModel(getName((IhmEntiteRelation)liste.get(i)));
/* 122 */       if (num < 0) {
/* 123 */         this.models.add(liste.get(i));
/*     */       } else {
/* 125 */         IhmEntiteRelation e = (IhmEntiteRelation)this.models.get(num);
/* 126 */         int nb = getNombreUtilisation(e);
/* 127 */         setNombreUtilisation((IhmEntiteRelation)liste.get(i), nb);
/* 128 */         this.models.remove(num);
/* 129 */         this.models.add(num, liste.get(i));
/*     */       }
/*     */     }
/*     */     
/* 133 */     if (liste.size() > 0) {
/* 134 */       saveLib();
/* 135 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 139 */     return false;
/*     */   }
/*     */   
/*     */   public boolean existModel(String name) {
/* 143 */     for (int i = 0; i < this.models.size(); i++) {
/* 144 */       if (getName((IhmEntiteRelation)this.models.get(i)).equals(name)) return true;
/*     */     }
/* 146 */     return false;
/*     */   }
/*     */   
/*     */   public int existNumModel(String name) {
/* 150 */     name = name.trim().toUpperCase();
/* 151 */     for (int i = 0; i < this.models.size(); i++) {
/* 152 */       if (getName((IhmEntiteRelation)this.models.get(i)).trim().toUpperCase().equals(name)) return i;
/*     */     }
/* 154 */     return -1;
/*     */   }
/*     */   
/*     */   public boolean existModel(String name, int num)
/*     */   {
/* 159 */     for (int i = 0; i < this.models.size(); i++) {
/* 160 */       if ((i != num) && 
/* 161 */         (getName((IhmEntiteRelation)this.models.get(i)).equals(name))) { return true;
/*     */       }
/*     */     }
/* 164 */     return false;
/*     */   }
/*     */   
/*     */   public String getName(IhmEntiteRelation model) {
/* 168 */     if ((model instanceof IhmEntite2)) {
/* 169 */       return ((IhmEntite2)model).getEntite().getNom();
/*     */     }
/* 171 */     if ((model instanceof IhmRelation2)) {
/* 172 */       return ((IhmRelation2)model).getRelation().getNom();
/*     */     }
/* 174 */     return "";
/*     */   }
/*     */   
/*     */   public void replaceModel(IhmEntiteRelation model) {
/* 178 */     for (int i = 0; i < this.models.size(); i++) {
/* 179 */       if (getName((IhmEntiteRelation)this.models.get(i)).equals(getName(model))) {
/* 180 */         this.models.remove(i);
/* 181 */         break;
/*     */       }
/*     */     }
/* 184 */     this.models.add(model);
/* 185 */     saveLib();
/*     */   }
/*     */   
/*     */   public IhmEntiteRelation getModel(String name) {
/* 189 */     for (int i = 0; i < this.models.size(); i++) {
/* 190 */       if (getName((IhmEntiteRelation)this.models.get(i)).equals(name)) return (IhmEntiteRelation)this.models.get(i);
/*     */     }
/* 192 */     return null;
/*     */   }
/*     */   
/*     */   public ArrayList<IhmEntiteRelation> getListModels() {
/* 196 */     return this.models;
/*     */   }
/*     */   
/*     */   public int getSize() {
/* 200 */     return this.models.size();
/*     */   }
/*     */   
/*     */   public String getName() {
/* 204 */     return this.name;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 209 */     return this.name;
/*     */   }
/*     */   
/*     */   public ArrayList<IhmEntiteRelation> getModels() {
/* 213 */     return this.models;
/*     */   }
/*     */   
/*     */   public String getPath() {
/* 217 */     return this.path;
/*     */   }
/*     */   
/*     */   public void setModels(ArrayList<IhmEntiteRelation> models) {
/* 221 */     this.models = models;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/* 225 */     this.name = name;
/*     */   }
/*     */   
/*     */   public void setPath(String path) {
/* 229 */     this.path = path;
/*     */   }
/*     */   
/*     */   public String prefixLib(String nameL) {
/* 233 */     if (nameL.endsWith(".jmlib")) return nameL;
/* 234 */     return nameL + ".jmlib";
/*     */   }
/*     */   
/*     */   public void ajouterModification()
/*     */   {
/* 239 */     Historique h = Historique.getHistoriqueModification();
/* 240 */     Historique h1 = (Historique)this.historique.get(this.historique.size() - 1);
/* 241 */     if ((!h.getDate().equals(h1.getDate())) || (!h.getDeveloppeur().equals(h1.getDeveloppeur()))) {
/* 242 */       this.historique.add(h);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean saveLib() {
/* 247 */     ajouterModification();
/* 248 */     FileOutputStream file = null;
/*     */     try {
/* 250 */       String nomFichier = getPath();
/* 251 */       file = new FileOutputStream(nomFichier);
/* 252 */       ObjectOutputStream oos = null;
/*     */       try {
/* 254 */         oos = new ObjectOutputStream(file);
/*     */       } catch (IOException ex) {
/* 256 */         return false;
/*     */       }
/*     */       
/* 259 */       oos.writeObject(this);
/* 260 */       return true;
/*     */     } catch (IOException ex) {
/* 262 */       Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
/*     */     } finally {
/*     */       try {
/* 265 */         file.close();
/*     */       } catch (IOException ex) {
/* 267 */         Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
/*     */       }
/*     */     }
/* 270 */     return false;
/*     */   }
/*     */   
/*     */   public static Library openLib(String fileName) {
/* 274 */     FileInputStream file = null;
/*     */     try {
/* 276 */       file = new FileInputStream(fileName);
/* 277 */       ObjectInputStream ois = new ObjectInputStream(file);
/* 278 */       Library lib = (Library)ois.readObject();
/* 279 */       return lib;
/*     */     } catch (Exception ex) { Library lib;
/* 281 */       return null;
/*     */     } finally {
/*     */       try {
/* 284 */         file.close();
/*     */       }
/*     */       catch (IOException ex) {}
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean deleteLibFile()
/*     */   {
/* 293 */     String nameF = this.path;
/* 294 */     File f = new File(nameF);
/* 295 */     if (f.exists()) return f.delete();
/* 296 */     return true;
/*     */   }
/*     */   
/*     */   public boolean existeLibFile() {
/* 300 */     String nameF = this.path;
/* 301 */     File f = new File(nameF);
/* 302 */     return f.exists();
/*     */   }
/*     */   
/*     */   public boolean existeLibFile(String name) {
/* 306 */     String nameF = getRepertoire() + prefixLib(name);
/* 307 */     File f = new File(nameF);
/* 308 */     return f.exists();
/*     */   }
/*     */   
/*     */   public boolean renameLibFile(String newPath) {
/* 312 */     String nameF = this.path;
/* 313 */     File fs = new File(nameF);
/* 314 */     if (fs.exists()) {
/* 315 */       File fd = new File(newPath);
/* 316 */       return fs.renameTo(fd);
/*     */     }
/*     */     
/* 319 */     setPath(newPath);
/* 320 */     return saveLib();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\LibraryPan\Library.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */