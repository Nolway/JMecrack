/*     */ package input;
/*     */ 
/*     */ import Outil.Setting;
/*     */ import java.io.DataInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.util.Properties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InfoSite
/*     */ {
/*     */   public static String dump(String URLName)
/*     */   {
/*  24 */     String s = "";
/*  25 */     DataInputStream di = null;
/*  26 */     FileOutputStream fo = null;
/*  27 */     byte[] b = new byte[1];
/*  28 */     if (Setting.proxy) {
/*  29 */       System.getProperties().put("http.proxyHost", Setting.proxyHTTP);
/*  30 */       System.getProperties().put("http.proxyPort", Setting.proxyPort);
/*  31 */       System.getProperties().put("http.proxyUser", Setting.proxyLogin);
/*  32 */       System.getProperties().put("http.proxyPassword", Setting.proxyPassW);
/*     */     }
/*     */     else {
/*  35 */       System.getProperties().put("http.proxyHost", "");
/*  36 */       System.getProperties().put("http.proxyPort", "");
/*  37 */       System.getProperties().put("http.proxyUser", "");
/*  38 */       System.getProperties().put("http.proxyPassword", "");
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  43 */       URL u = new URL(URLName);
/*     */       try {
/*  45 */         HttpURLConnection con = (HttpURLConnection)u.openConnection();
/*  46 */         di = new DataInputStream(con.getInputStream());
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  52 */         while (-1 != di.read(b, 0, 1)) {
/*  53 */           s = s + new String(b);
/*     */         }
/*     */       }
/*     */       catch (IOException ex) {
/*  57 */         return "ErreurRM 2";
/*     */       }
/*     */     }
/*     */     catch (MalformedURLException ex) {
/*  61 */       return "ErreurRM 1";
/*     */     }
/*     */     
/*  64 */     return s;
/*     */   }
/*     */   
/*     */   public static String dumpDonation(String URLName) {
/*  68 */     String s = "";
/*  69 */     DataInputStream di = null;
/*  70 */     FileOutputStream fo = null;
/*  71 */     byte[] b = new byte[1];
/*  72 */     if (Setting.proxy) {
/*  73 */       System.getProperties().put("http.proxyHost", Setting.proxyHTTP);
/*  74 */       System.getProperties().put("http.proxyPort", Setting.proxyPort);
/*  75 */       System.getProperties().put("http.proxyUser", Setting.proxyLogin);
/*  76 */       System.getProperties().put("http.proxyPassword", Setting.proxyPassW);
/*     */     }
/*     */     else {
/*  79 */       System.getProperties().put("http.proxyHost", "");
/*  80 */       System.getProperties().put("http.proxyPort", "");
/*  81 */       System.getProperties().put("http.proxyUser", "");
/*  82 */       System.getProperties().put("http.proxyPassword", "");
/*     */     }
/*     */     
/*     */     try
/*     */     {
/*  87 */       URL u = new URL(URLName);
/*     */       try {
/*  89 */         HttpURLConnection con = (HttpURLConnection)u.openConnection();
/*  90 */         di = new DataInputStream(con.getInputStream());
/*  91 */         while (-1 != di.read(b, 0, 1)) {
/*  92 */           s = s + new String(b);
/*     */         }
/*     */       } catch (IOException ex) {
/*  95 */         return "ErreurRM 2";
/*     */       }
/*     */     } catch (MalformedURLException ex) {
/*  98 */       return "ErreurRM 1";
/*     */     }
/* 100 */     return s;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\input\InfoSite.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */