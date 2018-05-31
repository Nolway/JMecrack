/*    */ package Thasaruts;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileWriter;
/*    */ import java.io.InputStreamReader;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Disque
/*    */ {
/*    */   public static String getSerialNumber(String drive)
/*    */   {
/* 22 */     String result = "";
/*    */     try
/*    */     {
/* 25 */       File file = File.createTempFile("realhowto", ".vbs");
/* 26 */       file.deleteOnExit();
/* 27 */       FileWriter fw = new FileWriter(file);
/*    */       
/* 29 */       String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\nSet colDrives = objFSO.Drives\nSet objDrive = colDrives.item(\"" + drive + "\")\n" + "Wscript.Echo objDrive.SerialNumber";
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 34 */       fw.write(vbs);
/* 35 */       fw.close();
/*    */       
/* 37 */       Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
/* 38 */       BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
/*    */       
/*    */       String line;
/* 41 */       while ((line = input.readLine()) != null) {
/* 42 */         result = result + line;
/*    */       }
/*    */       
/* 45 */       input.close();
/*    */     } catch (Exception e) {
/* 47 */       e.printStackTrace();
/*    */     }
/* 49 */     return result.trim();
/*    */   }
/*    */   
/*    */   public static ArrayList<DisqueNum> getDisques()
/*    */   {
/* 54 */     ArrayList<DisqueNum> liste = new ArrayList();
/*    */     
/*    */ 
/*    */ 
/* 58 */     File[] disques = File.listRoots();
/*    */     
/* 60 */     for (int i = 0; i < disques.length; i++) {
/* 61 */       String nom = disques[i].toString();
/* 62 */       String num = getSerialNumber(nom);
/* 63 */       if (num.length() > 0) {
/* 64 */         DisqueNum dn = new DisqueNum();
/* 65 */         dn.setNom(nom);
/* 66 */         dn.setNumero(num);
/* 67 */         liste.add(dn);
/*    */       }
/*    */     }
/* 70 */     return liste;
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Thasaruts\Disque.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */