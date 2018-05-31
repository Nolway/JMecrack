/*     */ package mythread;
/*     */ 
/*     */ import Outil.Setting;
/*     */ import Thasaruts.ThaOutils;
/*     */ import Thasaruts.Thassarut;
/*     */ import ihm.Principale;
/*     */ import java.io.DataInputStream;
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
/*     */ public class ThreadIncrementLoad
/*     */   extends Thread
/*     */ {
/*     */   private Principale frm;
/*     */   private String id;
/*     */   boolean isProx;
/*     */   
/*     */   public ThreadIncrementLoad(Principale frm, String id)
/*     */   {
/*  27 */     this.frm = frm;
/*  28 */     this.id = id;
/*  29 */     this.isProx = false;
/*  30 */     start();
/*     */   }
/*     */   
/*     */   public String getURLIncreaseMCD2(Principale principale, String id) {
/*  34 */     String s = "";
/*  35 */     String dateFin = Setting.licence.getAss_ifuk();
/*  36 */     String dateDer = Setting.licence.getAss_ukhadim();
/*  37 */     int jj = ThaOutils.getJJInt(dateDer);
/*  38 */     int nbjr = ThaOutils.nombreDeJour(dateFin, dateDer);
/*  39 */     int c = nbjr % jj;
/*     */     
/*  41 */     String datejour = ThaOutils.getDateJour();
/*     */     
/*  43 */     String url = "";
/*     */     
/*  45 */     url = url + "c=" + c + "&";
/*  46 */     url = url + "d=" + ThaOutils.getDateAnglaise(datejour) + "&";
/*  47 */     url = url + "j=" + jj + "&";
/*  48 */     url = url + "id=" + id + "&";
/*  49 */     url = url + "nb=" + nbjr;
/*     */     
/*  51 */     s = "http://www.jfreesoft.com/increase2.php?" + url;
/*  52 */     return s;
/*     */   }
/*     */   
/*     */   public String connexionJfreesoft(String URLName) {
/*  56 */     String s = "";
/*  57 */     DataInputStream di = null;
/*     */     
/*  59 */     byte[] b = new byte[1];
/*  60 */     System.getProperties().put("http.proxyHost", "");
/*  61 */     System.getProperties().put("http.proxyPort", "");
/*  62 */     System.getProperties().put("http.proxyUser", "");
/*  63 */     System.getProperties().put("http.proxyPassword", "");
/*     */     try
/*     */     {
/*  66 */       URL u = new URL(URLName);
/*     */       try {
/*  68 */         HttpURLConnection con = (HttpURLConnection)u.openConnection();
/*  69 */         di = new DataInputStream(con.getInputStream());
/*  70 */         while (-1 != di.read(b, 0, 1)) {
/*  71 */           s = s + new String(b);
/*     */         }
/*     */       } catch (IOException ex) {
/*  74 */         return "ErreurRM 2";
/*     */       }
/*     */     } catch (MalformedURLException ex) {
/*  77 */       return "ErreurRM 1";
/*     */     }
/*  79 */     return s;
/*     */   }
/*     */   
/*     */   public String connexionJfreesoftProxy(String URLName) {
/*  83 */     String s = "";
/*  84 */     String httpProxy = "";
/*  85 */     String log = "";
/*  86 */     String mdp = "";
/*  87 */     String port = "";
/*  88 */     if ((Setting.licence != null) && 
/*  89 */       (Setting.licence.isUseProxy())) {
/*  90 */       httpProxy = Setting.licence.getProxyNom();
/*  91 */       log = Setting.licence.getProxyLogin();
/*  92 */       mdp = Setting.licence.getProxyMdp();
/*  93 */       port = Setting.licence.getProxyPort();
/*  94 */       this.isProx = true;
/*     */     }
/*     */     
/*  97 */     DataInputStream di = null;
/*     */     
/*  99 */     byte[] b = new byte[1];
/*     */     
/* 101 */     System.getProperties().put("http.proxyHost", httpProxy);
/* 102 */     System.getProperties().put("http.proxyPort", port);
/* 103 */     System.getProperties().put("http.proxyUser", log);
/* 104 */     System.getProperties().put("http.proxyPassword", mdp);
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 109 */       URL u = new URL(URLName);
/*     */       try {
/* 111 */         HttpURLConnection con = (HttpURLConnection)u.openConnection();
/* 112 */         di = new DataInputStream(con.getInputStream());
/* 113 */         while (-1 != di.read(b, 0, 1)) {
/* 114 */           s = s + new String(b);
/*     */         }
/*     */       }
/*     */       catch (IOException ex) {
/* 118 */         return "ErreurRM 2";
/*     */       }
/*     */     } catch (MalformedURLException ex) {
/* 121 */       return "ErreurRM 1";
/*     */     }
/* 123 */     return s;
/*     */   }
/*     */   
/*     */   public void run()
/*     */   {
/* 128 */     String s = getURLIncreaseMCD2(this.frm, this.id);
/*     */     
/* 130 */     String rep = connexionJfreesoftProxy(s);
/* 131 */     if (this.isProx) {
/* 132 */       rep = connexionJfreesoft(s);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\mythread\ThreadIncrementLoad.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */