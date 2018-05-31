/*     */ package Output;
/*     */ 
/*     */ import IhmMCD.IhmEntite;
/*     */ import IhmMCD.IhmEntiteRelation;
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD.IhmRelation;
/*     */ import Merise.Attribut;
/*     */ import Merise.Domaine;
/*     */ import Merise.Entite;
/*     */ import Merise.Relation;
/*     */ import Merise2.Attribut2;
/*     */ import MySqlEditor.JTextEditorPan;
/*     */ import ihm.Principale;
/*     */ import java.awt.Desktop;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.filechooser.FileNameExtensionFilter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FileExport
/*     */ {
/*  32 */   static String dico = "";
/*     */   
/*     */   private static void actualiserDico(Principale frm) {
/*  35 */     for (int i = 0; i < frm.getPage().getListeEntiteRelation().size(); i++) {
/*  36 */       if (((IhmEntiteRelation)frm.getPage().getListeEntiteRelation().get(i)).getClass().getName().equals("IhmMCD.IhmEntite")) {
/*  37 */         for (int j = 0; j < ((IhmEntite)frm.getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().size(); j++) {
/*  38 */           frm.getPage().ajouterAttribut(((Attribut)((IhmEntite)frm.getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getNom(), ((Attribut)((IhmEntite)frm.getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getType(), ((Attribut)((IhmEntite)frm.getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getLongueur(), ((Attribut)((IhmEntite)frm.getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getLongDecimale());
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  44 */       if (((IhmEntiteRelation)frm.getPage().getListeEntiteRelation().get(i)).getClass().getName().equals("IhmMCD.IhmRelation")) {
/*  45 */         for (int j = 0; j < ((IhmRelation)frm.getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().size(); j++) {
/*  46 */           frm.getPage().ajouterAttribut(((Attribut)((IhmRelation)frm.getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getNom(), ((Attribut)((IhmRelation)frm.getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getType(), ((Attribut)((IhmRelation)frm.getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getLongueur(), ((Attribut)((IhmRelation)frm.getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getLongDecimale());
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void lanch(String filename)
/*     */   {
/*  57 */     File file = new File(filename);
/*  58 */     if ((!file.exists()) && (file.length() < 0L)) {
/*  59 */       System.out.println("Specified file does not exist!");
/*  60 */       System.exit(0);
/*     */     }
/*  62 */     Desktop desktop = null;
/*  63 */     if (Desktop.isDesktopSupported()) {
/*  64 */       desktop = Desktop.getDesktop();
/*     */     }
/*     */     try {
/*  67 */       desktop.edit(file);
/*     */     } catch (IOException ex) {
/*  69 */       Logger.getLogger(FileExport.class.getName()).log(Level.SEVERE, null, ex);
/*     */     }
/*     */   }
/*     */   
/*     */   private static String getExtentionTxt(String nom) {
/*  74 */     if (!nom.trim().endsWith(".txt")) {
/*  75 */       nom = nom + ".txt";
/*     */     }
/*  77 */     return nom;
/*     */   }
/*     */   
/*     */ 
/*     */   public static String exporterDictionnaire(Principale frm, String txt)
/*     */   {
/*  83 */     JFileChooser fileCh = new JFileChooser();
/*  84 */     FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichier txt", new String[] { "txt" });
/*  85 */     fileCh.setFileFilter(filtre);
/*  86 */     if (fileCh.showSaveDialog(frm) == 0) {
/*  87 */       File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/*  88 */       if (!fil.exists()) {
/*  89 */         String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/*  90 */         nomFile = getExtentionTxt(nomFile);
/*     */         try
/*     */         {
/*  93 */           PrintWriter out = new PrintWriter(nomFile);
/*  94 */           out.write(txt);
/*  95 */           out.close();
/*  96 */           return nomFile;
/*     */         } catch (FileNotFoundException ex) {
/*  98 */           Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*  99 */           return "0";
/*     */         }
/*     */       }
/* 102 */       if (JOptionPane.showConfirmDialog(frm, "Le fichier existe.\n Voulez vous le remplacer ?", "Modification ", 0) == 0) {
/*     */         try
/*     */         {
/* 105 */           PrintWriter out = new PrintWriter(getExtentionTxt(fileCh.getSelectedFile().getAbsolutePath()));
/* 106 */           out.write(txt);
/* 107 */           out.close();
/* 108 */           return getExtentionTxt(fileCh.getSelectedFile().getAbsolutePath());
/*     */         } catch (FileNotFoundException ex) {
/* 110 */           Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/* 111 */           return "0";
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 116 */     return "2";
/*     */   }
/*     */   
/*     */   private static String attributToString(Attribut att) {
/* 120 */     String s = "";
/* 121 */     s = s + "Nom : " + att.getNom() + "\n";
/* 122 */     s = s + "Type : " + att.getType() + "\n";
/* 123 */     s = s + "Taille : " + att.getLongueur() + "," + att.getLongDecimale() + "\n";
/* 124 */     s = s + "Commentaire : " + att.getCommentaire() + "\n";
/* 125 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */   private static void getlisteAttributToString(String p, ArrayList<Attribut> lAtt)
/*     */   {
/* 131 */     for (int i = 0; i < lAtt.size(); i++) {
/* 132 */       Attribut2 att = (Attribut2)lAtt.get(i);
/* 133 */       dico = dico + p + "Nom : " + att.getNom() + "\n";
/* 134 */       dico = dico + p + "Code : " + att.getCode() + "\n";
/* 135 */       dico = dico + p + "Type : " + att.getType().toUpperCase() + "\n";
/*     */       
/* 137 */       dico = dico + p + "Taille : " + (att.getLongueur() < 0 ? "" : Integer.valueOf(att.getLongueur())) + "," + (att.getLongDecimale() < 0 ? "" : Integer.valueOf(att.getLongDecimale())) + "\n";
/* 138 */       dico = dico + p + "Commentaire : " + att.getCommentaire() + "\n";
/* 139 */       if (att.getListeAttributs().size() > 0) {
/* 140 */         dico = dico + p + "Sous attributs  \n";
/* 141 */         p = p + "\t";
/* 142 */         getlisteAttributToString(p, att.getListeAttributs());
/* 143 */         p = p.substring(1, p.length());
/* 144 */         dico = dico + p + "Fin Sous attributs  \n";
/*     */       }
/* 146 */       dico = dico + p + "\n";
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static String DicoToString(ArrayList<Attribut> listeAttribut)
/*     */   {
/* 154 */     dico = "Dictionnaire de données \n\n";
/*     */     
/* 156 */     getlisteAttributToString("", listeAttribut);
/*     */     
/*     */ 
/*     */ 
/* 160 */     return dico;
/*     */   }
/*     */   
/*     */   public static void exporterDictionnaire(Principale frm, ArrayList<Attribut> listeAttribut) {
/* 164 */     actualiserDico(frm);
/* 165 */     String res = exporterDictionnaire(frm, DicoToString(listeAttribut));
/* 166 */     if (res.length() > 1) {
/* 167 */       lanch(res);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static String domaineToString(Domaine d)
/*     */   {
/* 174 */     String s = d.getNom() + "";
/* 175 */     if (d != null) {
/* 176 */       s = "[";
/* 177 */       for (int i = 0; i < d.getListeValeurs().size(); i++) {
/* 178 */         s = s + (String)d.getListeValeurs().get(i) + "";
/* 179 */         if (i + 1 == d.getListeValeurs().size()) s = s + "]"; else
/* 180 */           s = s + ",";
/*     */       }
/*     */     }
/* 183 */     return s;
/*     */   }
/*     */   
/*     */   private static String listeDomaineToString(ArrayList<Domaine> ld) {
/* 187 */     String s = "Liste de domaines :\n";
/* 188 */     for (int i = 0; i < ld.size(); i++) {
/* 189 */       s = s + domaineToString((Domaine)ld.get(i)) + "\n\n";
/*     */     }
/* 191 */     return s;
/*     */   }
/*     */   
/*     */   public static void exporterListeDomaine(Principale frm, ArrayList<Domaine> listeD) {
/* 195 */     actualiserDico(frm);
/* 196 */     String res = exporterDictionnaire(frm, listeDomaineToString(listeD));
/* 197 */     if (res.length() > 1) {
/* 198 */       lanch(res);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Output\FileExport.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */