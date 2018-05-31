/*     */ package Thasaruts;
/*     */ 
/*     */ import Outil.Parametres;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Thassarut
/*     */   implements Serializable
/*     */ {
/*     */   private String version;
/*     */   private String typeVersion;
/*     */   private ArrayList<String> allVersion;
/*     */   private ArrayList<String> ip;
/*     */   private String ass_elviaa;
/*     */   private String ass_ivdha;
/*     */   private String ass_ifuk;
/*     */   private String ass_ukhadim;
/*     */   private String thassarouts;
/*     */   private String ass_i_active;
/*     */   private String vavis;
/*     */   private String achehal_wussan;
/*     */   private String ach_hal_ikhadamen;
/*     */   private String owner;
/*     */   private String mail;
/*     */   private String mailActive;
/*     */   private String mdp;
/*     */   private ArrayList<MacActive> mac;
/*     */   private ArrayList<DisqueNum> disque;
/*     */   private String commentaire1;
/*     */   private ArrayList<String> depanne;
/*     */   private ArrayList<String> proxy;
/*     */   private boolean useProxy;
/*     */   private String devSession;
/*     */   private String developpeur;
/*     */   private boolean licence;
/*     */   private String os1;
/*     */   private String os2;
/*     */   private String os3;
/*     */   private int nbUsed;
/*     */   private int nbCle;
/*     */   private int idUser;
/*     */   private int idLic;
/*     */   
/*     */   public Thassarut()
/*     */   {
/*  60 */     this.version = Parametres.version;
/*  61 */     this.typeVersion = "";
/*  62 */     this.allVersion = new ArrayList();
/*  63 */     this.ip = new ArrayList();
/*  64 */     this.ass_elviaa = "";
/*  65 */     this.ass_ivdha = "";
/*  66 */     this.ass_ifuk = "";
/*  67 */     this.ass_ukhadim = "";
/*  68 */     this.thassarouts = "";
/*  69 */     this.ass_i_active = "";
/*  70 */     this.vavis = System.getProperty("user.name");
/*  71 */     this.achehal_wussan = "";
/*  72 */     this.ach_hal_ikhadamen = "0012";
/*     */     
/*  74 */     this.owner = "";
/*  75 */     this.mail = "";
/*  76 */     this.mailActive = "";
/*  77 */     this.mdp = "";
/*  78 */     this.mac = new ArrayList();
/*  79 */     this.disque = new ArrayList();
/*     */     
/*  81 */     this.commentaire1 = "";
/*  82 */     this.depanne = new ArrayList();
/*  83 */     this.proxy = new ArrayList();
/*  84 */     this.useProxy = false;
/*     */     
/*  86 */     this.devSession = System.getProperty("user.name");
/*  87 */     this.developpeur = "";
/*     */     
/*  89 */     this.licence = false;
/*  90 */     this.os1 = "";
/*  91 */     this.os2 = "";
/*  92 */     this.os3 = "";
/*  93 */     this.nbUsed = 0;
/*     */     
/*  95 */     setParametreProxy("", "", "", "");
/*  96 */     this.nbCle = 0;
/*  97 */     this.idLic = -1;
/*  98 */     this.idUser = -1;
/*     */   }
/*     */   
/*     */   public void setParametreProxy(String prox, String log, String mdp, String port)
/*     */   {
/* 103 */     this.proxy.clear();
/* 104 */     this.proxy.add(prox);
/* 105 */     this.proxy.add(log);
/* 106 */     this.proxy.add(mdp);
/* 107 */     this.proxy.add(port);
/*     */   }
/*     */   
/*     */   public void addOS(String sys) {
/* 111 */     if (sys.toUpperCase().contains("WIN")) {
/* 112 */       sys = "WINDOWS";
/*     */     }
/* 114 */     if (sys.toUpperCase().startsWith("LI")) {
/* 115 */       sys = "LINUX";
/*     */     }
/* 117 */     if (sys.toUpperCase().startsWith("MA")) {
/* 118 */       sys = "MAC";
/*     */     }
/* 120 */     if ((this.os1 == null) || (this.os1.length() == 0)) {
/* 121 */       this.os1 = sys;
/* 122 */       return;
/*     */     }
/* 124 */     if (this.os1.equals(sys)) return;
/* 125 */     if ((this.os2 == null) || (this.os2.length() == 0)) {
/* 126 */       this.os2 = sys;
/* 127 */       return;
/*     */     }
/* 129 */     if (this.os2.equals(sys)) return;
/* 130 */     if ((this.os3 == null) || (this.os3.length() == 0)) {
/* 131 */       this.os3 = sys;
/* 132 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean addMac(String mc)
/*     */   {
/* 138 */     if (!ThaOutils.existeMacDansListe(this.mac, mc)) {
/* 139 */       MacActive m = new MacActive(mc.trim(), true);
/* 140 */       this.mac.add(m);
/*     */     }
/* 142 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isMacActiver(String m) {
/* 146 */     for (int i = 0; i < this.mac.size(); i++) {
/* 147 */       if ((((MacActive)this.mac.get(i)).getMac().equals(m.trim())) && 
/* 148 */         (((MacActive)this.mac.get(i)).isActive())) { return true;
/*     */       }
/*     */     }
/* 151 */     return false;
/*     */   }
/*     */   
/*     */   public void addIP(String ip)
/*     */   {
/* 156 */     if (ip == null) return;
/* 157 */     if (ip.length() == 0) return;
/* 158 */     for (int i = 0; i < this.ip.size(); i++) {
/* 159 */       if (((String)this.ip.get(i)).equals(ip)) return;
/*     */     }
/* 161 */     this.ip.add(ip);
/*     */   }
/*     */   
/*     */   public void addDisque(String disq) {
/* 165 */     if (disq == null) return;
/* 166 */     if (disq.length() == 0) return;
/* 167 */     for (int i = 0; i < this.disque.size(); i++) {
/* 168 */       if (((DisqueNum)this.disque.get(i)).getNom().equals(disq)) return;
/*     */     }
/* 170 */     DisqueNum dn = new DisqueNum();
/* 171 */     dn.setNom(disq);
/* 172 */     dn.setNumero("MR112233");
/* 173 */     this.disque.add(dn);
/*     */   }
/*     */   
/*     */   public String getAch_hal_ikhadamen() {
/* 177 */     return this.ach_hal_ikhadamen;
/*     */   }
/*     */   
/*     */   public String getAchehal_wussan() {
/* 181 */     return this.achehal_wussan;
/*     */   }
/*     */   
/*     */   public int getNbCle() {
/* 185 */     return this.nbCle;
/*     */   }
/*     */   
/*     */   public void setNbCle(int nbCle) {
/* 189 */     this.nbCle = nbCle;
/*     */   }
/*     */   
/*     */   public ArrayList<String> getAllVersion() {
/* 193 */     return this.allVersion;
/*     */   }
/*     */   
/*     */   public String getAss_elviaa() {
/* 197 */     return this.ass_elviaa;
/*     */   }
/*     */   
/*     */   public String getAss_i_active() {
/* 201 */     return this.ass_i_active;
/*     */   }
/*     */   
/*     */   public String getAss_ifuk() {
/* 205 */     return this.ass_ifuk;
/*     */   }
/*     */   
/*     */   public String getAss_ivdha() {
/* 209 */     return this.ass_ivdha;
/*     */   }
/*     */   
/*     */   public String getAss_ukhadim() {
/* 213 */     return this.ass_ukhadim;
/*     */   }
/*     */   
/*     */   public String getCommentaire1() {
/* 217 */     return this.commentaire1;
/*     */   }
/*     */   
/*     */   public ArrayList<String> getDepanne() {
/* 221 */     return this.depanne;
/*     */   }
/*     */   
/*     */   public String getDevSession() {
/* 225 */     return this.devSession;
/*     */   }
/*     */   
/*     */   public String getDeveloppeur() {
/* 229 */     return this.developpeur;
/*     */   }
/*     */   
/*     */   public ArrayList<DisqueNum> getDisque() {
/* 233 */     return this.disque;
/*     */   }
/*     */   
/*     */   public ArrayList<String> getIp() {
/* 237 */     return this.ip;
/*     */   }
/*     */   
/*     */   public boolean isLicence() {
/* 241 */     return this.licence;
/*     */   }
/*     */   
/*     */   public ArrayList<MacActive> getMac() {
/* 245 */     return this.mac;
/*     */   }
/*     */   
/*     */   public String getMail() {
/* 249 */     return this.mail;
/*     */   }
/*     */   
/*     */   public String getMailActive() {
/* 253 */     return this.mailActive;
/*     */   }
/*     */   
/*     */   public String getMdp() {
/* 257 */     return this.mdp;
/*     */   }
/*     */   
/*     */   public int getNbUsed() {
/* 261 */     return this.nbUsed;
/*     */   }
/*     */   
/*     */   public String getOs1() {
/* 265 */     return this.os1;
/*     */   }
/*     */   
/*     */   public String getOs2() {
/* 269 */     return this.os2;
/*     */   }
/*     */   
/*     */   public String getOs3() {
/* 273 */     return this.os3;
/*     */   }
/*     */   
/*     */   public String getOwner() {
/* 277 */     return this.owner;
/*     */   }
/*     */   
/*     */   public ArrayList<String> getProxy() {
/* 281 */     return this.proxy;
/*     */   }
/*     */   
/*     */   public String getThassarouts() {
/* 285 */     return this.thassarouts;
/*     */   }
/*     */   
/*     */   public String getTypeVersion() {
/* 289 */     return this.typeVersion;
/*     */   }
/*     */   
/*     */   public boolean isUseProxy() {
/* 293 */     return this.useProxy;
/*     */   }
/*     */   
/*     */   public String getVavis() {
/* 297 */     return this.vavis;
/*     */   }
/*     */   
/*     */   public String getVersion() {
/* 301 */     return this.version;
/*     */   }
/*     */   
/*     */   public void setAch_hal_ikhadamen(String ach_hal_ikhadamen) {
/* 305 */     this.ach_hal_ikhadamen = ach_hal_ikhadamen;
/*     */   }
/*     */   
/*     */   public void setAchehal_wussan(String achehal_wussan) {
/* 309 */     this.achehal_wussan = achehal_wussan;
/*     */   }
/*     */   
/*     */   public void setAllVersion(ArrayList<String> allVersion) {
/* 313 */     this.allVersion = allVersion;
/*     */   }
/*     */   
/*     */   public void setAss_elviaa(String ass_elviaa) {
/* 317 */     this.ass_elviaa = ass_elviaa;
/*     */   }
/*     */   
/*     */   public void setAss_i_active(String ass_i_active) {
/* 321 */     this.ass_i_active = ass_i_active;
/*     */   }
/*     */   
/*     */   public void setAss_ifuk(String ass_ifuk) {
/* 325 */     this.ass_ifuk = ass_ifuk;
/*     */   }
/*     */   
/*     */   public void setAss_ivdha(String ass_ivdha) {
/* 329 */     this.ass_ivdha = ass_ivdha;
/*     */   }
/*     */   
/*     */   public void setAss_ukhadim(String ass_ukhadim) {
/* 333 */     this.ass_ukhadim = ass_ukhadim;
/*     */   }
/*     */   
/*     */   public void setCommentaire1(String commentaire1) {
/* 337 */     this.commentaire1 = commentaire1;
/*     */   }
/*     */   
/*     */   public void setDepanne(ArrayList<String> depanne) {
/* 341 */     this.depanne = depanne;
/*     */   }
/*     */   
/*     */   public void setDevSession(String devSession) {
/* 345 */     this.devSession = devSession;
/*     */   }
/*     */   
/*     */   public void setDeveloppeur(String developpeur) {
/* 349 */     this.developpeur = developpeur;
/*     */   }
/*     */   
/*     */   public void setDisque(ArrayList<DisqueNum> disque) {
/* 353 */     this.disque = disque;
/*     */   }
/*     */   
/*     */   public void setIp(ArrayList<String> ip) {
/* 357 */     this.ip = ip;
/*     */   }
/*     */   
/*     */   public void setLicence(boolean licence) {
/* 361 */     this.licence = licence;
/*     */   }
/*     */   
/*     */   public void setMac(ArrayList<MacActive> mac) {
/* 365 */     this.mac = mac;
/*     */   }
/*     */   
/*     */   public void setMail(String mail) {
/* 369 */     this.mail = mail;
/*     */   }
/*     */   
/*     */   public void setMailActive(String mailActive) {
/* 373 */     this.mailActive = mailActive;
/*     */   }
/*     */   
/*     */   public void setMdp(String mdp) {
/* 377 */     this.mdp = mdp;
/*     */   }
/*     */   
/*     */   public void setNbUsed(int nbUsed) {
/* 381 */     this.nbUsed = nbUsed;
/*     */   }
/*     */   
/*     */   public void setOs1(String os1) {
/* 385 */     this.os1 = os1;
/*     */   }
/*     */   
/*     */   public void setOs2(String os2) {
/* 389 */     this.os2 = os2;
/*     */   }
/*     */   
/*     */   public void setOs3(String os3) {
/* 393 */     this.os3 = os3;
/*     */   }
/*     */   
/*     */   public void setOwner(String owner) {
/* 397 */     this.owner = owner;
/*     */   }
/*     */   
/*     */   public void setProxy(ArrayList<String> proxy) {
/* 401 */     this.proxy = proxy;
/*     */   }
/*     */   
/*     */   public void setThassarouts(String thassarouts) {
/* 405 */     this.thassarouts = thassarouts;
/*     */   }
/*     */   
/*     */   public void setTypeVersion(String typeVersion) {
/* 409 */     this.typeVersion = typeVersion;
/*     */   }
/*     */   
/*     */   public void setUseProxy(boolean useProxy) {
/* 413 */     this.useProxy = useProxy;
/*     */   }
/*     */   
/*     */   public void setVavis(String vavis) {
/* 417 */     this.vavis = vavis;
/*     */   }
/*     */   
/*     */   public void setVersion(String version) {
/* 421 */     this.version = version;
/*     */   }
/*     */   
/*     */   public String getProxyNom() {
/* 425 */     return (String)this.proxy.get(0);
/*     */   }
/*     */   
/*     */   public String getProxyLogin() {
/* 429 */     return (String)this.proxy.get(1);
/*     */   }
/*     */   
/*     */   public String getProxyMdp() {
/* 433 */     return (String)this.proxy.get(2);
/*     */   }
/*     */   
/*     */   public String getProxyPort() {
/* 437 */     return (String)this.proxy.get(3);
/*     */   }
/*     */   
/*     */   public int getIdLic() {
/* 441 */     return this.idLic;
/*     */   }
/*     */   
/*     */   public int getIdUser() {
/* 445 */     return this.idUser;
/*     */   }
/*     */   
/*     */   public void setIdLic(int idLic) {
/* 449 */     this.idLic = idLic;
/*     */   }
/*     */   
/*     */   public void setIdUser(int idUser) {
/* 453 */     this.idUser = idUser;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\Thasaruts\Thassarut.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */