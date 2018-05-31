/*    */ package Outil;
/*    */ 
/*    */ import formes.FormeParametre;
/*    */ import ihm.Principale;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.ObjectInputStream;
/*    */ import java.io.ObjectOutputStream;
/*    */ import java.io.Serializable;
/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SaveSetting
/*    */   implements Serializable
/*    */ {
/*    */   public String tassarut;
/*    */   public String parametre;
/*    */   public String setting;
/*    */   public String autres;
/*    */   
/*    */   public SaveSetting(String tassarut, String parametre, String setting)
/*    */   {
/* 30 */     this.tassarut = tassarut;
/* 31 */     this.parametre = parametre;
/* 32 */     this.setting = setting;
/* 33 */     this.autres = "";
/*    */   }
/*    */   
/*    */   public SaveSetting() {
/* 37 */     this.tassarut = "";
/* 38 */     this.parametre = "";
/* 39 */     this.setting = "";
/* 40 */     this.autres = "";
/*    */   }
/*    */   
/*    */   public void enregistrerParametre(Principale principale, String chemin, FormeParametre fP, SaveSetting sset)
/*    */   {
/* 45 */     sset.setting = Setting.settingToString();
/* 46 */     sset.parametre = BureauParametre.bureauToString(principale);
/* 47 */     sset.tassarut = fP.parametresToString();
/*    */     try {
/* 49 */       FileOutputStream fichier = new FileOutputStream(chemin);
/* 50 */       ObjectOutputStream oos = new ObjectOutputStream(fichier);
/* 51 */       oos.writeObject(sset);
/* 52 */       oos.flush();
/* 53 */       oos.close();
/*    */     } catch (IOException e) {
/* 55 */       JOptionPane.showMessageDialog(principale, " Une exception est survenue lors de l'écriture dans le fichier parametre \n" + e.toString(), "Exceptions", 0);
/*    */     }
/*    */   }
/*    */   
/*    */   public static SaveSetting ouvrirParametre(Principale frm, String chemin) {
/* 60 */     SaveSetting save = null;
/*    */     try
/*    */     {
/* 63 */       FileInputStream fichier = new FileInputStream(chemin);
/*    */       try
/*    */       {
/* 66 */         ObjectInputStream ois = new ObjectInputStream(fichier);
/*    */         try {
/* 68 */           return (SaveSetting)ois.readObject();
/*    */         }
/*    */         catch (ClassNotFoundException ex) {
/* 71 */           JOptionPane.showMessageDialog(frm, " Une exception est survenue lors de la lecture du fichier lib/parametres.param \n" + ex.toString(), "Exceptions", 0);
/*    */         }
/*    */       } catch (IOException ex) {
/* 74 */         JOptionPane.showMessageDialog(frm, " Une exception est survenue lors de la création du fichier lib/parametres.param \n" + ex.toString(), "Exceptions", 0);
/*    */       }
/*    */       
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 81 */       System.exit(0);
/*    */     }
/*    */     catch (FileNotFoundException ex)
/*    */     {
/* 78 */       JOptionPane.showMessageDialog(frm, "le fichier " + chemin + " n'existe pas \n" + ex.toString(), "Exceptions", 0);
/*    */     }
/*    */     
/*    */ 
/* 82 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static FormeParametre getFormeParametre(SaveSetting s)
/*    */   {
/* 89 */     return FormeParametre.stringToParametres(s.tassarut);
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Outil\SaveSetting.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */