/*     */ package mythread;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import Outil.Setting;
/*     */ import Output.SQLOutil;
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
/*     */ public class ThreadSite
/*     */   extends Thread
/*     */ {
/*     */   private Principale frm;
/*     */   boolean isProx;
/*     */   
/*     */   public ThreadSite(Principale frm)
/*     */   {
/*  28 */     this.frm = frm;
/*  29 */     this.isProx = false;
/*  30 */     Parametres.dateExec = Parametres.getDateExecution();
/*  31 */     start();
/*     */   }
/*     */   
/*     */   public String getURLActivity2(Principale principale)
/*     */   {
/*  36 */     String s = "";
/*  37 */     String dateFin = Setting.licence.getAss_ifuk();
/*  38 */     String dateDer = Setting.licence.getAss_ukhadim();
/*  39 */     int jj = ThaOutils.getJJInt(dateDer);
/*  40 */     int nbjr = ThaOutils.nombreDeJour(dateFin, dateDer);
/*  41 */     int c = nbjr % jj;
/*     */     
/*  43 */     String datejour = ThaOutils.getDateJour();
/*     */     
/*  45 */     String url = "";
/*     */     
/*     */ 
/*  48 */     String os = System.getProperty("os.name");
/*  49 */     String langue = System.getProperty("user.language");
/*  50 */     String version = Parametres.version;
/*  51 */     String devel = Setting.developpeur;
/*     */     
/*  53 */     if (Setting.licence.isLicence()) {
/*  54 */       version = "A_" + version;
/*     */     } else {
/*  56 */       version = "F_" + version;
/*     */     }
/*     */     
/*  59 */     os = SQLOutil.remplaceChar(os);
/*  60 */     langue = SQLOutil.remplaceChar(langue);
/*  61 */     version = SQLOutil.remplaceChar(version);
/*  62 */     devel = SQLOutil.remplaceChar(devel);
/*  63 */     String m = ThaOutils.getMacControle();
/*     */     
/*  65 */     url = url + "c=" + c + "&";
/*  66 */     url = url + "d=" + ThaOutils.getDateAnglaise(datejour) + "&";
/*  67 */     url = url + "dev=" + devel + "&";
/*  68 */     url = url + "j=" + jj + "&";
/*  69 */     url = url + "m=" + m + "&";
/*     */     
/*  71 */     url = url + "v=" + version + "&";
/*  72 */     url = url + "nb=" + nbjr + "&";
/*  73 */     url = url + "os=" + os + "&";
/*  74 */     url = url + "l=" + langue;
/*     */     
/*     */ 
/*  77 */     s = "http://www.jfreesoft.com/JMerise/activityDay05.php?" + url;
/*     */     
/*  79 */     return s;
/*     */   }
/*     */   
/*     */   public String connexionJfreesoft(String URLName) {
/*  83 */     String s = "";
/*  84 */     DataInputStream di = null;
/*     */     
/*  86 */     byte[] b = new byte[1];
/*  87 */     System.getProperties().put("http.proxyHost", "");
/*  88 */     System.getProperties().put("http.proxyPort", "");
/*  89 */     System.getProperties().put("http.proxyUser", "");
/*  90 */     System.getProperties().put("http.proxyPassword", "");
/*     */     try
/*     */     {
/*  93 */       URL u = new URL(URLName);
/*     */       try {
/*  95 */         HttpURLConnection con = (HttpURLConnection)u.openConnection();
/*  96 */         di = new DataInputStream(con.getInputStream());
/*  97 */         while (-1 != di.read(b, 0, 1)) {
/*  98 */           s = s + new String(b);
/*     */         }
/*     */       } catch (IOException ex) {
/* 101 */         return "ErreurRM 2";
/*     */       }
/*     */     } catch (MalformedURLException ex) {
/* 104 */       return "ErreurRM 1";
/*     */     }
/* 106 */     return s;
/*     */   }
/*     */   
/*     */   public String connexionJfreesoftProxy(String URLName) {
/* 110 */     String s = "";
/* 111 */     String httpProxy = "";
/* 112 */     String log = "";
/* 113 */     String mdp = "";
/* 114 */     String port = "";
/* 115 */     if ((Setting.licence != null) && 
/* 116 */       (Setting.licence.isUseProxy())) {
/* 117 */       httpProxy = Setting.licence.getProxyNom();
/* 118 */       log = Setting.licence.getProxyLogin();
/* 119 */       mdp = Setting.licence.getProxyMdp();
/* 120 */       port = Setting.licence.getProxyPort();
/* 121 */       this.isProx = true;
/*     */     }
/*     */     
/* 124 */     DataInputStream di = null;
/*     */     
/* 126 */     byte[] b = new byte[1];
/*     */     
/* 128 */     System.getProperties().put("http.proxyHost", httpProxy);
/* 129 */     System.getProperties().put("http.proxyPort", port);
/* 130 */     System.getProperties().put("http.proxyUser", log);
/* 131 */     System.getProperties().put("http.proxyPassword", mdp);
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 136 */       URL u = new URL(URLName);
/*     */       try {
/* 138 */         HttpURLConnection con = (HttpURLConnection)u.openConnection();
/* 139 */         di = new DataInputStream(con.getInputStream());
/* 140 */         while (-1 != di.read(b, 0, 1)) {
/* 141 */           s = s + new String(b);
/*     */         }
/*     */       }
/*     */       catch (IOException ex) {
/* 145 */         return "ErreurRM 2";
/*     */       }
/*     */     } catch (MalformedURLException ex) {
/* 148 */       return "ErreurRM 1";
/*     */     }
/* 150 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void run()
/*     */   {
/* 158 */     String s = getURLActivity2(this.frm);
/*     */     
/* 160 */     String rep = connexionJfreesoftProxy(s);
/* 161 */     if (this.isProx) {
/* 162 */       rep = connexionJfreesoft(s);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\mythread\ThreadSite.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */