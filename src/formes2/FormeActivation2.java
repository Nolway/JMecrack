/*     */ package formes2;
/*     */ 
/*     */ import Outil.Setting;
/*     */ import Thasaruts.ThaOutils;
/*     */ import Thasaruts.ThassaroutJfreesoft;
/*     */ import Thasaruts.Thassarut;
/*     */ import ihm.Principale;
/*     */ import java.awt.Color;
/*     */ import java.awt.Desktop;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.WindowEvent;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.ButtonGroup;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JPasswordField;
/*     */ import javax.swing.JRadioButton;
/*     */ import javax.swing.JTabbedPane;
/*     */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ import javax.swing.event.ChangeEvent;
/*     */ 
/*     */ public class FormeActivation2 extends javax.swing.JDialog
/*     */ {
/*     */   Principale frm;
/*  37 */   public static int nbTest = 0;
/*     */   private String typeActivation;
/*     */   Thassarut licence;
/*     */   boolean activer;
/*     */   private ButtonGroup buttonGroup1;
/*     */   private ButtonGroup buttonGroup2;
/*     */   private JButton jBtActiver;
/*  44 */   public FormeActivation2(Principale parent, boolean modal, Thassarut licence, String type) { super(parent, modal);
/*  45 */     initComponents();
/*  46 */     this.frm = parent;
/*  47 */     this.typeActivation = type;
/*  48 */     this.licence = licence;
/*  49 */     this.jLabActiv.setVisible(false);
/*  50 */     if (licence == null) {
/*  51 */       this.licence = new Thassarut();
/*     */     }
/*  53 */     this.activer = false;
/*     */     
/*  55 */     setLocation(this.frm.getX() + (this.frm.getWidth() - getWidth()) / 2, this.frm.getY() + (this.frm.getHeight() - getHeight()) / 2);
/*  56 */     initData(); }
/*     */   
/*     */   private JButton jBtAvoirCle;
/*     */   private JButton jBtQuitter;
/*  60 */   private void initData() { if (this.typeActivation.equals("REACTIVER")) {
/*  61 */       if (this.licence != null) {
/*  62 */         if (this.licence.isLicence()) {
/*  63 */           this.jTFCLE.setText(this.licence.getThassarouts());
/*  64 */           this.jTFDeveloppeur.setText(Setting.developpeur);
/*  65 */           if (this.jTFDeveloppeur.getText().trim().length() == 0) {
/*  66 */             this.jTFDeveloppeur.setText(Setting.licence.getDeveloppeur());
/*     */           }
/*  68 */           this.jTFMail.setText(this.licence.getMail());
/*     */           
/*  70 */           if (this.licence.isUseProxy()) {
/*  71 */             this.jRBProxy.setSelected(false);
/*  72 */             this.jRBPasDeProxy.setSelected(true);
/*  73 */             this.jTFLogin.setEnabled(true);
/*  74 */             this.jTFPassword.setEnabled(true);
/*  75 */             this.jTFProxy.setEnabled(true);
/*  76 */             this.jTFPort.setEnabled(true);
/*     */           }
/*     */           else {
/*  79 */             this.jRBProxy.setSelected(true);
/*  80 */             this.jRBPasDeProxy.setSelected(false);
/*  81 */             this.jTFLogin.setEnabled(false);
/*  82 */             this.jTFPassword.setEnabled(false);
/*  83 */             this.jTFProxy.setEnabled(false);
/*  84 */             this.jTFPort.setEnabled(false);
/*     */           }
/*  86 */           this.jTFLogin.setText(this.licence.getProxyLogin());
/*  87 */           this.jTFPassword.setText(this.licence.getProxyMdp());
/*  88 */           this.jTFProxy.setText(this.licence.getProxyNom());
/*  89 */           this.jTFPort.setText(this.licence.getProxyPort());
/*     */         }
/*     */       }
/*     */       else {
/*  93 */         this.jTFDeveloppeur.setText(System.getProperty("user.name"));
/*     */       }
/*     */     } else
/*  96 */       this.jTFDeveloppeur.setText(System.getProperty("user.name"));
/*     */   }
/*     */   
/*     */   private JButton jBtTest;
/*     */   private JButton jBtenregistrer;
/*     */   
/* 102 */   public boolean isActiver() { return this.activer; }
/*     */   
/*     */   private JCheckBox jCBInformer;
/*     */   private JLabel jLabActiv;
/*     */   
/* 107 */   private boolean verifierEnregstrement() { if (this.jTFDeveloppeur.getText().length() == 0) {
/* 108 */       JOptionPane.showMessageDialog(this, "Le nom du developpeur (l'utilisateur) ne doit pas être vide");
/* 109 */       return false;
/*     */     }
/* 111 */     return true; }
/*     */   
/*     */   private JLabel jLabel1;
/*     */   
/* 115 */   private boolean verifierActivation() { if (this.jTFDeveloppeur.getText().length() == 0) {
/* 116 */       JOptionPane.showMessageDialog(this, "Le nom du developpeur (l'utilisateur) ne doit pas être vide");
/* 117 */       return false;
/*     */     }
/* 119 */     if (!ThaOutils.isMailCorrect(this.jTFMail.getText().trim())) {
/* 120 */       JOptionPane.showMessageDialog(this, "Votre mail n'est pas correct ");
/* 121 */       return false;
/*     */     }
/* 123 */     return true; }
/*     */   
/*     */   private JLabel jLabel2;
/*     */   
/* 127 */   private boolean isCleCorrect() { if (!ThaOutils.isKeyVerifier(this.jTFCLE.getText().trim())) {
/* 128 */       JOptionPane.showMessageDialog(this, "La clé d'activation n'est pas correcte ");
/* 129 */       return false;
/*     */     }
/* 131 */     return true; }
/*     */   
/*     */   private JLabel jLabel3;
/*     */   
/* 135 */   private boolean isWebSiteDate(String s) { if (s.indexOf("<date>") < 0) return false;
/* 136 */     if (s.indexOf("</date>") < 0) return false;
/* 137 */     return true;
/*     */   }
/*     */   
/*     */   private JLabel jLabel4;
/* 141 */   private boolean verifierDateSyschronisation(String s) { s = s.substring(s.indexOf("<date>"), s.length());
/* 142 */     s = s.substring(6, s.indexOf("</date>"));
/* 143 */     s = s.replace("<", "");
/* 144 */     java.util.Date ds = ThaOutils.stringToDateFR(s);
/* 145 */     java.util.Date dj = ThaOutils.stringToDateFR(ThaOutils.getDateJour());
/* 146 */     int nbj = ThaOutils.nombreDeJour(dj, ds);
/* 147 */     nbj = Math.abs(nbj);
/* 148 */     if (nbj > 2) {
/* 149 */       JOptionPane.showMessageDialog(this, "ERREUR de synchronisation avec le serveur\nVérifiez et mettez à jour votre date système !!");
/* 150 */       return false;
/*     */     }
/* 152 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isConnecterWeb()
/*     */   {
/* 157 */     boolean rep = false;
/* 158 */     String prox = "";
/* 159 */     String log = "";
/* 160 */     String pw = "";
/* 161 */     String port = "";
/* 162 */     if (this.jRBProxy.isSelected()) {
/* 163 */       prox = this.jTFProxy.getText().trim();
/* 164 */       log = this.jTFLogin.getText().trim();
/* 165 */       pw = this.jTFPassword.getText().trim();
/* 166 */       port = this.jTFPort.getText().trim();
/*     */     }
/* 168 */     String s = ThaOutils.connexionJfreesoftProxy("http://www.jfreesoft.com/JMerise/testActive2.php", prox, log, pw, port);
/* 169 */     if (s.indexOf("ErreurRM") >= 0) {
/* 170 */       return false;
/*     */     }
/* 172 */     if (isWebSiteDate(s)) {
/* 173 */       return true;
/*     */     }
/*     */     
/* 176 */     return false;
/*     */   }
/*     */   
/*     */   private boolean verifierExisteMac() {
/* 180 */     String mac = Outil.Parametres.getMac();
/* 181 */     if (mac.length() == 0) mac = "MRBLANC";
/* 182 */     return ThaOutils.existeMacDansListe(this.licence.getMac(), mac);
/*     */   }
/*     */   
/*     */   private JLabel jLabel5;
/*     */   private JLabel jLabel6;
/*     */   private JLabel jLabel8;
/*     */   private JPanel jPanel1;
/*     */   private JPanel jPanel2;
/*     */   private JRadioButton jRBJAI;
/*     */   private JRadioButton jRBJAIPAS;
/*     */   private JRadioButton jRBPasDeProxy;
/*     */   
/*     */   private void initComponents() {
/* 195 */     this.buttonGroup1 = new ButtonGroup();
/* 196 */     this.buttonGroup2 = new ButtonGroup();
/* 197 */     this.jTabbedPane1 = new JTabbedPane();
/* 198 */     this.jPanel1 = new JPanel();
/* 199 */     this.jLabel1 = new JLabel();
/* 200 */     this.jTFMail = new JTextField();
/* 201 */     this.jLabel2 = new JLabel();
/* 202 */     this.jTFCLE = new JTextField();
/* 203 */     this.jRBJAI = new JRadioButton();
/* 204 */     this.jRBJAIPAS = new JRadioButton();
/* 205 */     this.jLabel8 = new JLabel();
/* 206 */     this.jTFDeveloppeur = new JTextField();
/* 207 */     this.jCBInformer = new JCheckBox();
/* 208 */     this.jBtAvoirCle = new JButton();
/* 209 */     this.jLabActiv = new JLabel();
/* 210 */     this.jPanel2 = new JPanel();
/* 211 */     this.jRBPasDeProxy = new JRadioButton();
/* 212 */     this.jRBProxy = new JRadioButton();
/* 213 */     this.jLabel4 = new JLabel();
/* 214 */     this.jTFProxy = new JTextField();
/* 215 */     this.jLabel3 = new JLabel();
/* 216 */     this.jTFLogin = new JTextField();
/* 217 */     this.jTFPassword = new JPasswordField();
/* 218 */     this.jLabel5 = new JLabel();
/* 219 */     this.jTFPort = new JTextField();
/* 220 */     this.jLabel6 = new JLabel();
/* 221 */     this.jBtTest = new JButton();
/* 222 */     this.jBtActiver = new JButton();
/* 223 */     this.jBtenregistrer = new JButton();
/* 224 */     this.jBtQuitter = new JButton();
/*     */     
/* 226 */     setDefaultCloseOperation(2);
/* 227 */     setTitle("Activation et enregistrement JMerise");
/* 228 */     setResizable(false);
/* 229 */     addWindowListener(new java.awt.event.WindowAdapter() {
/*     */       public void windowClosed(WindowEvent evt) {
/* 231 */         FormeActivation2.this.formWindowClosed(evt);
/*     */       }
/*     */       
/* 234 */     });
/* 235 */     this.jLabel1.setText("Mail");
/*     */     
/* 237 */     this.jTFMail.setFont(new Font("Tahoma", 1, 13));
/* 238 */     this.jTFMail.setForeground(new Color(0, 0, 153));
/*     */     
/* 240 */     this.jLabel2.setFont(new Font("Tahoma", 1, 11));
/* 241 */     this.jLabel2.setForeground(new Color(153, 0, 0));
/* 242 */     this.jLabel2.setText("Clé d'activation ");
/*     */     
/* 244 */     this.jTFCLE.setFont(new Font("Tahoma", 1, 13));
/*     */     
/* 246 */     this.buttonGroup1.add(this.jRBJAI);
/* 247 */     this.jRBJAI.setFont(new Font("Tahoma", 1, 12));
/* 248 */     this.jRBJAI.setForeground(new Color(255, 0, 0));
/* 249 */     this.jRBJAI.setSelected(true);
/* 250 */     this.jRBJAI.setText("J'ai un clé d'activation ");
/* 251 */     this.jRBJAI.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 253 */         FormeActivation2.this.jRBJAIActionPerformed(evt);
/*     */       }
/*     */       
/* 256 */     });
/* 257 */     this.buttonGroup1.add(this.jRBJAIPAS);
/* 258 */     this.jRBJAIPAS.setFont(new Font("Tahoma", 0, 12));
/* 259 */     this.jRBJAIPAS.setText("je n'ai pas de clé ");
/* 260 */     this.jRBJAIPAS.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 262 */         FormeActivation2.this.jRBJAIPASActionPerformed(evt);
/*     */       }
/*     */       
/* 265 */     });
/* 266 */     this.jLabel8.setText("Utilisateur");
/*     */     
/* 268 */     this.jTFDeveloppeur.setFont(new Font("Tahoma", 1, 13));
/*     */     
/* 270 */     this.jCBInformer.setSelected(true);
/* 271 */     this.jCBInformer.setText("M'informer des nouveautés JMerise par mail");
/*     */     
/* 273 */     this.jBtAvoirCle.setText("Avoir une clé");
/* 274 */     this.jBtAvoirCle.setEnabled(false);
/* 275 */     this.jBtAvoirCle.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 277 */         FormeActivation2.this.jBtAvoirCleActionPerformed(evt);
/*     */       }
/*     */       
/* 280 */     });
/* 281 */     this.jLabActiv.setFont(new Font("Tahoma", 1, 11));
/* 282 */     this.jLabActiv.setForeground(new Color(255, 0, 0));
/* 283 */     this.jLabActiv.setHorizontalAlignment(0);
/* 284 */     this.jLabActiv.setText(">>>        L'activation de JMerise est obligatoire pour les professionnels         <<<");
/*     */     
/* 286 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/* 287 */     this.jPanel1.setLayout(jPanel1Layout);
/* 288 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jLabel2, -2, 111, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jTFCLE, GroupLayout.Alignment.LEADING, -1, 466, 32767).addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.jRBJAI).addGap(18, 18, 18).addComponent(this.jRBJAIPAS).addGap(18, 18, 18).addComponent(this.jBtAvoirCle, -1, 144, 32767)).addComponent(this.jCBInformer, GroupLayout.Alignment.LEADING))).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel8).addComponent(this.jLabel1, -2, 47, -2)).addGap(29, 29, 29).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTFMail, -1, 504, 32767).addComponent(this.jTFDeveloppeur, -1, 504, 32767).addComponent(this.jLabActiv, -1, 504, 32767)))).addContainerGap()));
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
/* 316 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(12, 32767).addComponent(this.jLabActiv, -2, 19, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel8).addComponent(this.jTFDeveloppeur, -2, 31, -2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.jTFMail, -2, 28, -2)).addGap(18, 18, 18).addComponent(this.jCBInformer).addGap(31, 31, 31).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRBJAI).addComponent(this.jRBJAIPAS).addComponent(this.jBtAvoirCle)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFCLE, -2, 29, -2).addComponent(this.jLabel2)).addContainerGap()));
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
/* 343 */     this.jTabbedPane1.addTab("Activation", this.jPanel1);
/*     */     
/* 345 */     this.buttonGroup2.add(this.jRBPasDeProxy);
/* 346 */     this.jRBPasDeProxy.setSelected(true);
/* 347 */     this.jRBPasDeProxy.setText("Pas de proxy");
/* 348 */     this.jRBPasDeProxy.addChangeListener(new javax.swing.event.ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 350 */         FormeActivation2.this.jRBPasDeProxyStateChanged(evt);
/*     */       }
/*     */       
/* 353 */     });
/* 354 */     this.buttonGroup2.add(this.jRBProxy);
/* 355 */     this.jRBProxy.setText("Parametres proxy");
/* 356 */     this.jRBProxy.addChangeListener(new javax.swing.event.ChangeListener() {
/*     */       public void stateChanged(ChangeEvent evt) {
/* 358 */         FormeActivation2.this.jRBProxyStateChanged(evt);
/*     */       }
/*     */       
/* 361 */     });
/* 362 */     this.jLabel4.setText("Proxy HTTP ");
/*     */     
/* 364 */     this.jTFProxy.setEnabled(false);
/*     */     
/* 366 */     this.jLabel3.setText("Login");
/*     */     
/* 368 */     this.jTFLogin.setEnabled(false);
/*     */     
/* 370 */     this.jTFPassword.setEnabled(false);
/*     */     
/* 372 */     this.jLabel5.setText("Password");
/*     */     
/* 374 */     this.jTFPort.setEnabled(false);
/*     */     
/* 376 */     this.jLabel6.setText("Port");
/*     */     
/* 378 */     this.jBtTest.setText("Tester Connexion ...");
/* 379 */     this.jBtTest.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 381 */         FormeActivation2.this.jBtTestActionPerformed(evt);
/*     */       }
/*     */       
/* 384 */     });
/* 385 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/* 386 */     this.jPanel2.setLayout(jPanel2Layout);
/* 387 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jRBProxy, -2, 133, -2).addContainerGap(462, 32767)).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup().addComponent(this.jRBPasDeProxy, -1, -1, 32767).addGap(303, 303, 303).addComponent(this.jBtTest, -2, 160, -2)).addGroup(jPanel2Layout.createSequentialGroup().addGap(29, 29, 29).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel5, GroupLayout.Alignment.LEADING, -1, 59, 32767).addComponent(this.jLabel3, GroupLayout.Alignment.LEADING, -1, 59, 32767).addComponent(this.jLabel4, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jTFPassword, -1, 328, 32767).addComponent(this.jTFLogin, -1, 328, 32767).addComponent(this.jTFProxy, -2, 328, -2)).addGap(35, 35, 35).addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTFPort, -2, 61, -2))).addGap(43, 43, 43)))));
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
/* 418 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jRBPasDeProxy).addComponent(this.jBtTest)).addGap(18, 18, 18).addComponent(this.jRBProxy).addGap(21, 21, 21).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jTFProxy, -2, -1, -2).addComponent(this.jTFPort, -2, -1, -2).addComponent(this.jLabel6)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.jTFLogin, -2, -1, -2)).addGap(18, 18, 18).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel5).addComponent(this.jTFPassword, -2, -1, -2)).addContainerGap(76, 32767)));
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
/* 444 */     this.jTabbedPane1.addTab("Réseau", this.jPanel2);
/*     */     
/* 446 */     this.jBtActiver.setFont(new Font("Tahoma", 1, 12));
/* 447 */     this.jBtActiver.setForeground(new Color(0, 0, 153));
/* 448 */     this.jBtActiver.setIcon(new ImageIcon(getClass().getResource("/Images/OK.png")));
/* 449 */     this.jBtActiver.setText("Activer JMerise");
/* 450 */     this.jBtActiver.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 452 */         FormeActivation2.this.jBtActiverActionPerformed(evt);
/*     */       }
/*     */       
/* 455 */     });
/* 456 */     this.jBtenregistrer.setIcon(new ImageIcon(getClass().getResource("/Images/OK.png")));
/* 457 */     this.jBtenregistrer.setText("Enregistrer JMerise");
/* 458 */     this.jBtenregistrer.setEnabled(false);
/* 459 */     this.jBtenregistrer.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 461 */         FormeActivation2.this.jBtenregistrerActionPerformed(evt);
/*     */       }
/*     */       
/* 464 */     });
/* 465 */     this.jBtQuitter.setIcon(new ImageIcon(getClass().getResource("/Images/quit.png")));
/* 466 */     this.jBtQuitter.setText("Quitter JMerise");
/* 467 */     this.jBtQuitter.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/* 469 */         FormeActivation2.this.jBtQuitterActionPerformed(evt);
/*     */       }
/*     */       
/* 472 */     });
/* 473 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 474 */     getContentPane().setLayout(layout);
/* 475 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jTabbedPane1, GroupLayout.Alignment.LEADING, 0, 0, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jBtQuitter).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 135, 32767).addComponent(this.jBtenregistrer).addGap(54, 54, 54).addComponent(this.jBtActiver, -2, 147, -2))).addContainerGap(-1, 32767)));
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
/* 489 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jTabbedPane1, -1, 296, 32767).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtQuitter).addComponent(this.jBtActiver, -2, 28, -2).addComponent(this.jBtenregistrer)).addContainerGap()));
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
/* 502 */     pack();
/*     */   }
/*     */   
/*     */   private void jRBJAIActionPerformed(ActionEvent evt) {
/* 506 */     if (this.jRBJAI.isSelected()) {
/* 507 */       this.jBtActiver.setEnabled(true);
/* 508 */       this.jBtenregistrer.setEnabled(false);
/* 509 */       this.jTFMail.setEnabled(true);
/* 510 */       this.jCBInformer.setEnabled(true);
/* 511 */       this.jTFCLE.setEnabled(true);
/* 512 */       this.jBtAvoirCle.setEnabled(false);
/* 513 */       this.jLabActiv.setVisible(false);
/*     */     }
/*     */   }
/*     */   
/*     */   private void jRBJAIPASActionPerformed(ActionEvent evt) {
/* 518 */     if (this.jRBJAIPAS.isSelected()) {
/* 519 */       this.jBtActiver.setEnabled(false);
/* 520 */       this.jBtenregistrer.setEnabled(true);
/* 521 */       this.jTFMail.setEnabled(false);
/* 522 */       this.jCBInformer.setEnabled(false);
/* 523 */       this.jTFCLE.setEnabled(false);
/* 524 */       this.jBtAvoirCle.setEnabled(true);
/* 525 */       this.jLabActiv.setVisible(true);
/*     */     }
/*     */   }
/*     */   
/*     */   private void jRBPasDeProxyStateChanged(ChangeEvent evt) {
/* 530 */     if (this.jRBPasDeProxy.isSelected()) {
/* 531 */       this.jTFProxy.setEnabled(false);
/* 532 */       this.jTFPort.setEnabled(false);
/* 533 */       this.jTFLogin.setEnabled(false);
/* 534 */       this.jTFPassword.setEnabled(false);
/*     */     }
/*     */   }
/*     */   
/*     */   private void jRBProxyStateChanged(ChangeEvent evt) {
/* 539 */     if (this.jRBProxy.isSelected()) {
/* 540 */       this.jTFProxy.setEnabled(true);
/* 541 */       this.jTFPort.setEnabled(true);
/* 542 */       this.jTFLogin.setEnabled(true);
/* 543 */       this.jTFPassword.setEnabled(true);
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBtTestActionPerformed(ActionEvent evt) {
/* 548 */     String s = "";
/* 549 */     if (this.jRBPasDeProxy.isSelected()) {
/* 550 */       String pn = this.jTFProxy.getText().trim();
/* 551 */       String log = this.jTFLogin.getText().trim();
/* 552 */       String pw = this.jTFPassword.getText().trim();
/* 553 */       String port = this.jTFPort.getText().trim();
/* 554 */       s = ThaOutils.connexionJfreesoftProxy("http://www.jfreesoft.com/JMerise/testActive2.php", pn, log, pw, port);
/*     */     } else {
/* 556 */       s = ThaOutils.connexionJfreesoft("http://www.jfreesoft.com/JMerise/testActive2.php");
/*     */     }
/*     */     
/* 559 */     if (s.indexOf("ErreurRM") >= 0) {
/* 560 */       if (this.jRBPasDeProxy.isSelected()) {
/* 561 */         JOptionPane.showMessageDialog(this, "Impossible de se connecter sans les paramètres du proxy, \nVérifier avec paramètres proxy ou la connexion internet");
/*     */       } else {
/* 563 */         JOptionPane.showMessageDialog(this, "Impossible de se connecter avec les paramètres du proxy,\nVérifier la connexion internet");
/*     */       }
/*     */     }
/* 566 */     else if ((isWebSiteDate(s)) && 
/* 567 */       (verifierDateSyschronisation(s)))
/* 568 */       JOptionPane.showMessageDialog(this, "Connexion réussie !!");
/*     */   }
/*     */   
/*     */   private JRadioButton jRBProxy;
/*     */   private JTextField jTFCLE;
/*     */   private JTextField jTFDeveloppeur;
/*     */   private JTextField jTFLogin;
/*     */   
/* 576 */   private void jBtActiverActionPerformed(ActionEvent evt) { if (verifierActivation()) {
/* 577 */       if (isCleCorrect()) {
/* 578 */         if (isConnecterWeb()) {
/* 579 */           if (verifierExisteMac()) {
/* 580 */             this.activer = true;
/* 581 */             dispose();
/*     */           }
/* 583 */           String log = "";
/* 584 */           String prox = "";
/* 585 */           String pw = "";
/* 586 */           String por = "";
/* 587 */           if (this.jRBProxy.isSelected()) {
/* 588 */             log = this.jTFLogin.getText().trim();
/* 589 */             prox = this.jTFProxy.getText().trim();
/* 590 */             pw = this.jTFPassword.getText().trim();
/* 591 */             por = this.jTFPort.getText().trim();
/*     */           }
/* 593 */           String s = ThaOutils.connexionJfreesoftProxy(ThassaroutJfreesoft.getUrlActivation(this.jTFCLE.getText().trim(), this.jTFDeveloppeur.getText().trim(), this.jTFMail.getText().trim(), this.jCBInformer.isSelected()), prox, log, pw, por);
/* 594 */           String rep = ThassaroutJfreesoft.traiterReponseActivationS(this.frm, this.licence, s);
/* 595 */           if (rep.trim().length() == 0)
/*     */           {
/* 597 */             Setting.developpeur = this.jTFDeveloppeur.getText().trim();
/* 598 */             Setting.licence = this.licence;
/* 599 */             Setting.licence.setDeveloppeur(Setting.developpeur);
/* 600 */             Setting.licence.setUseProxy(this.jRBProxy.isSelected());
/* 601 */             Setting.licence.setParametreProxy(prox, log, pw, por);
/* 602 */             Setting.licence.setLicence(true);
/* 603 */             Setting.licence.setMail(this.jTFMail.getText().trim());
/* 604 */             Setting.proxy = this.jRBProxy.isSelected();
/* 605 */             Setting.proxyHTTP = prox;
/* 606 */             Setting.proxyLogin = log;
/* 607 */             Setting.proxyPassW = pw;
/* 608 */             Setting.proxyPort = por;
/* 609 */             Setting.licence = this.licence;
/* 610 */             this.activer = true;
/* 611 */             ThaOutils.MAJLicence(Setting.licence);
/* 612 */             JOptionPane.showMessageDialog(this, "Votre version est activée avec succès !! ", "Activation ", 1);
/* 613 */             dispose();
/*     */           } else {
/* 615 */             JOptionPane.showMessageDialog(this, rep, "Activation ", 0);
/*     */           }
/*     */         }
/*     */         else {
/* 619 */           JOptionPane.showMessageDialog(this, "Problème de connection, Veuillez vérifier votre connexion internet ou vos paramètre dans l'onglet Réseau", "Activation", 0);
/*     */         }
/*     */       }
/*     */       else {
/* 623 */         nbTest += 1;
/* 624 */         if (nbTest > 2) {
/* 625 */           JOptionPane.showMessageDialog(this, "La clé d'activation n'est pas correcte !!\nSi vous avez une clé et le problème persiste, contactez l'administrateur : admin@jfreesoft.com ", "Activation", 0);
/* 626 */           System.exit(0);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 631 */     if (nbTest > 2) {
/* 632 */       JOptionPane.showMessageDialog(this, "L'activation de votre clé est échouée,\nSi vous avez une clé et si le problème persiste, contactez JMerise : admin@jfreesoft.com ");
/* 633 */       dispose();
/*     */     }
/*     */   }
/*     */   
/*     */   private void jBtenregistrerActionPerformed(ActionEvent evt) {
/* 638 */     if (verifierEnregstrement()) {
/* 639 */       if (!isConnecterWeb()) {
/* 640 */         JOptionPane.showMessageDialog(this, "Vérifiez si vous êtes connecté à l'intenet ou bien les paramètres Réseau dans l'onglet Reseau", "Connexion Internet", 0);
/* 641 */         return;
/*     */       }
/* 643 */       String log = "";
/* 644 */       String prox = "";
/* 645 */       String pw = "";
/* 646 */       String por = "";
/* 647 */       if (this.jRBProxy.isSelected()) {
/* 648 */         log = this.jTFLogin.getText().trim();
/* 649 */         prox = this.jTFProxy.getText().trim();
/* 650 */         pw = this.jTFPassword.getText().trim();
/* 651 */         por = this.jTFPort.getText().trim();
/*     */       }
/*     */       
/* 654 */       String s = ThaOutils.connexionJfreesoftProxy(ThassaroutJfreesoft.getUrlEnregistrement(), prox, log, pw, por);
/* 655 */       String rep = ThassaroutJfreesoft.traiterReponseEnregistrer(this.frm, s);
/* 656 */       if (rep.trim().length() == 0) {
/* 657 */         Setting.developpeur = this.jTFDeveloppeur.getText().trim();
/* 658 */         Setting.licence = new Thassarut();
/* 659 */         Setting.licence.setAss_ukhadim(ThaOutils.getDateJour());
/* 660 */         Setting.licence.setAss_ifuk(ThassaroutJfreesoft.dateFinLic);
/* 661 */         Setting.licence.setAss_ivdha(ThaOutils.getDateJour());
/* 662 */         Setting.licence.setAss_elviaa("12/05/2022");
/* 663 */         Setting.licence.setDeveloppeur(this.jTFDeveloppeur.getText().trim());
/* 664 */         Setting.licence.setAss_i_active(ThaOutils.getDateJour());
/* 665 */         Setting.licence.setThassarouts(ThassaroutJfreesoft.numeroLic);
/* 666 */         Setting.licence.setUseProxy(this.jRBProxy.isSelected());
/* 667 */         Setting.licence.setParametreProxy(prox, log, pw, por);
/* 668 */         Setting.licence.setLicence(false);
/* 669 */         Setting.proxy = this.jRBProxy.isSelected();
/* 670 */         Setting.proxyHTTP = prox;
/* 671 */         Setting.proxyLogin = log;
/* 672 */         Setting.proxyPassW = pw;
/* 673 */         Setting.proxyPort = por;
/* 674 */         this.activer = true;
/* 675 */         ThaOutils.MAJLicence(Setting.licence);
/* 676 */         JOptionPane.showMessageDialog(this, "Votre version est enregistrée avec succès !! ", "Enregistrement ", 1);
/* 677 */         dispose();
/*     */       } else {
/* 679 */         JOptionPane.showMessageDialog(this, rep, "Enregistrement ", 0);
/*     */       } } }
/*     */   private JTextField jTFMail;
/*     */   private JPasswordField jTFPassword;
/*     */   private JTextField jTFPort;
/*     */   
/* 685 */   private void jBtQuitterActionPerformed(ActionEvent evt) { this.frm.setDefaultCloseOperation(3);
/* 686 */     dispose();
/* 687 */     this.frm.dispose();
/* 688 */     System.exit(0);
/*     */   }
/*     */   
/*     */   private JTextField jTFProxy;
/*     */   private JTabbedPane jTabbedPane1;
/*     */   private void formWindowClosed(WindowEvent evt) {}
/*     */   
/*     */   private void jBtAvoirCleActionPerformed(ActionEvent evt) {
/* 696 */     if (Desktop.isDesktopSupported())
/*     */     {
/* 698 */       Desktop desktop = Desktop.getDesktop();
/*     */       
/*     */ 
/* 701 */       if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
/*     */         try
/*     */         {
/*     */           try {
/* 705 */             desktop.browse(new java.net.URI("http://www.jfreesoft.com/JMerise/activation.html"));
/*     */           } catch (java.net.URISyntaxException ex) {
/* 707 */             Logger.getLogger(FormeActivation2.class.getName()).log(Level.SEVERE, null, ex);
/*     */           }
/*     */         } catch (java.io.IOException ex) {
/* 710 */           Logger.getLogger(FormeActivation2.class.getName()).log(Level.SEVERE, null, ex);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeActivation2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */