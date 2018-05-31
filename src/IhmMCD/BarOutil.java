/*      */ package IhmMCD;
/*      */ 
/*      */ import ihm.FormeInterneMCD;
/*      */ import ihm.Principale;
/*      */ import java.awt.Color;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.util.ArrayList;
/*      */ import javax.swing.ImageIcon;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JToggleButton;
/*      */ import javax.swing.JToolBar;
/*      */ 
/*      */ public class BarOutil extends javax.swing.JPanel
/*      */ {
/*      */   private String etat;
/*      */   private StatutBar statutBar;
/*      */   private boolean afficheRegle;
/*      */   private MenuPop.MenuPopContrainte menuContrainte;
/*      */   private MenuPop.MenuPopInformation menuInformation;
/*      */   private Principale frm;
/*      */   private JToggleButton btCif;
/*      */   private JToggleButton btEntite;
/*      */   private JToggleButton btLien;
/*      */   private JToggleButton btRegle;
/*      */   private JToggleButton btRelation;
/*      */   private JToggleButton btRien;
/*      */   private javax.swing.ButtonGroup buttonGroup1;
/*      */   private JButton jBtActivation;
/*      */   private JButton jBtEnregistrer;
/*      */   private JButton jBtEnregistrerSous;
/*      */   private JButton jBtInfo;
/*      */   private JButton jBtNouveau;
/*      */   private JButton jBtOuvrir;
/*      */   private JButton jButton1;
/*      */   private JButton jButton2;
/*      */   private JButton jButton3;
/*      */   private JButton jButton4;
/*      */   private JButton jButton5;
/*      */   private JButton jButton6;
/*      */   private JButton jButton7;
/*      */   private JButton jButton8;
/*      */   private JLabel jLabPrZoom;
/*      */   private javax.swing.JToolBar.Separator jSeparator1;
/*      */   private javax.swing.JToolBar.Separator jSeparator2;
/*      */   private javax.swing.JToolBar.Separator jSeparator3;
/*      */   private javax.swing.JToolBar.Separator jSeparator4;
/*      */   private JToggleButton jToggleButton1;
/*      */   private JToggleButton jToggleButton2;
/*      */   private JToggleButton jToggleButton3;
/*      */   private JToolBar jToolBar1;
/*      */   
/*      */   public BarOutil(StatutBar statutBar)
/*      */   {
/*   56 */     initComponents();
/*   57 */     this.etat = "RIEN";
/*   58 */     this.jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
/*   59 */     this.jToolBar1.setFloatable(false);
/*   60 */     this.statutBar = statutBar;
/*   61 */     this.afficheRegle = true;
/*   62 */     this.menuContrainte = new MenuPop.MenuPopContrainte(this);
/*   63 */     this.menuInformation = new MenuPop.MenuPopInformation(this.frm);
/*      */   }
/*      */   
/*      */   public MenuPop.MenuPopInformation getMenuInformation() {
/*   67 */     return this.menuInformation;
/*      */   }
/*      */   
/*      */   public void setMenuInformation(MenuPop.MenuPopInformation menuInformation) {
/*   71 */     this.menuInformation = menuInformation;
/*      */   }
/*      */   
/*      */   public String getEtat() {
/*   75 */     return this.etat;
/*      */   }
/*      */   
/*      */   public void setEtat(String etat) {
/*   79 */     this.etat = etat;
/*      */   }
/*      */   
/*      */   public boolean isAfficheRegle() {
/*   83 */     return this.afficheRegle;
/*      */   }
/*      */   
/*      */   public void setAfficheRegle(boolean afficheRegle) {
/*   87 */     this.afficheRegle = afficheRegle;
/*      */   }
/*      */   
/*      */   public JToggleButton getBtRegle()
/*      */   {
/*   92 */     return this.btRegle;
/*      */   }
/*      */   
/*      */   public JToggleButton getBtEntite() {
/*   96 */     return this.btEntite;
/*      */   }
/*      */   
/*      */   public JToggleButton getBtLien() {
/*  100 */     return this.btLien;
/*      */   }
/*      */   
/*      */   public JToggleButton getBtRelation() {
/*  104 */     return this.btRelation;
/*      */   }
/*      */   
/*      */   public JToggleButton getBtRien() {
/*  108 */     return this.btRien;
/*      */   }
/*      */   
/*      */   public void setFrm(Principale frm) {
/*  112 */     this.frm = frm;
/*      */   }
/*      */   
/*      */   public JLabel getjLabPrZoom() {
/*  116 */     return this.jLabPrZoom;
/*      */   }
/*      */   
/*  119 */   public JToolBar getJToolBar() { return this.jToolBar1; }
/*      */   
/*      */   public void afficherBoutonActivation(boolean val)
/*      */   {
/*  123 */     this.jBtActivation.setVisible(val);
/*      */   }
/*      */   
/*      */   private boolean existeDomaine(String domaine) {
/*  127 */     for (int i = 0; i < Outil.Parametres.DomaineDefini.length; i++) {
/*  128 */       if (domaine.trim().toUpperCase().equals(Outil.Parametres.DomaineDefini[i].trim().toUpperCase())) return true;
/*      */     }
/*  130 */     for (int i = 0; i < this.frm.getFormeMCD().getPage().getListeDomaine().size(); i++) {
/*  131 */       if (domaine.trim().toUpperCase().equals(((Merise.Domaine)this.frm.getFormeMCD().getPage().getListeDomaine().get(i)).getNom().trim().toUpperCase())) return true;
/*      */     }
/*  133 */     return false;
/*      */   }
/*      */   
/*      */   private boolean isCorrectDomaine() {
/*  137 */     boolean correc = true;
/*  138 */     for (int i = 0; i < this.frm.getFormeMCD().getPage().getListeEntiteRelation().size(); i++) {
/*  139 */       if (((IhmEntiteRelation)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getClass().getName().toString().equals("IhmMCD2.IhmEntite2")) {
/*  140 */         for (int j = 0; j < ((IhmMCD2.IhmEntite2)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().size(); j++) {
/*  141 */           if (!existeDomaine(((Merise.Attribut)((IhmMCD2.IhmEntite2)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getType())) {
/*  142 */             correc = false;
/*  143 */             this.frm.getConsole().getRapport().append("Le domaine " + ((Merise.Attribut)((IhmMCD2.IhmEntite2)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getType() + " de l'attribut " + ((Merise.Attribut)((IhmMCD2.IhmEntite2)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getEntite().getListeAttributs().get(j)).getNom() + " de l'entite " + ((IhmMCD2.IhmEntite2)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getEntite().getNom() + " n'est pas défini " + "\n");
/*      */           }
/*      */           
/*      */         }
/*      */         
/*      */       } else {
/*  149 */         for (int j = 0; j < ((IhmMCD2.IhmRelation2)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().size(); j++) {
/*  150 */           if (!existeDomaine(((Merise.Attribut)((IhmMCD2.IhmRelation2)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getType())) {
/*  151 */             correc = false;
/*  152 */             this.frm.getConsole().getRapport().append("Le domaine " + ((Merise.Attribut)((IhmMCD2.IhmRelation2)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getType() + " de l'attribut " + ((Merise.Attribut)((IhmMCD2.IhmRelation2)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getRelation().getListeAttributs().get(j)).getNom() + " de la relation " + ((IhmMCD2.IhmRelation2)this.frm.getFormeMCD().getPage().getListeEntiteRelation().get(i)).getRelation().getNom() + " n'est pas défini " + "\n");
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*  159 */     return correc;
/*      */   }
/*      */   
/*      */   public double getZoom(String z, String p)
/*      */   {
/*  164 */     if (z.equals("0.20")) {
/*  165 */       if (p.equals("PLUS")) {
/*  166 */         this.jLabPrZoom.setText("0.30");
/*  167 */         return 0.3D;
/*      */       }
/*  169 */       this.jLabPrZoom.setText("0.20");
/*  170 */       return 0.2D;
/*      */     }
/*  172 */     if (z.equals("0.30")) {
/*  173 */       if (p.equals("PLUS")) {
/*  174 */         this.jLabPrZoom.setText("0.40");
/*  175 */         return 0.4D;
/*      */       }
/*  177 */       this.jLabPrZoom.setText("0.20");
/*  178 */       return 0.2D;
/*      */     }
/*  180 */     if (z.equals("0.40")) {
/*  181 */       if (p.equals("PLUS")) {
/*  182 */         this.jLabPrZoom.setText("0.50");
/*  183 */         return 0.5D;
/*      */       }
/*  185 */       this.jLabPrZoom.setText("0.30");
/*  186 */       return 0.3D;
/*      */     }
/*  188 */     if (z.equals("0.50")) {
/*  189 */       if (p.equals("PLUS")) {
/*  190 */         this.jLabPrZoom.setText("0.60");
/*  191 */         return 0.6D;
/*      */       }
/*  193 */       this.jLabPrZoom.setText("0.40");
/*  194 */       return 0.4D;
/*      */     }
/*  196 */     if (z.equals("0.60")) {
/*  197 */       if (p.equals("PLUS")) {
/*  198 */         this.jLabPrZoom.setText("0.70");
/*  199 */         return 0.7D;
/*      */       }
/*  201 */       this.jLabPrZoom.setText("0.50");
/*  202 */       return 0.5D;
/*      */     }
/*  204 */     if (z.equals("0.70")) {
/*  205 */       if (p.equals("PLUS")) {
/*  206 */         this.jLabPrZoom.setText("0.80");
/*  207 */         return 0.8D;
/*      */       }
/*  209 */       this.jLabPrZoom.setText("0.60");
/*  210 */       return 0.6D;
/*      */     }
/*  212 */     if (z.equals("0.80")) {
/*  213 */       if (p.equals("PLUS")) {
/*  214 */         this.jLabPrZoom.setText("0.90");
/*  215 */         return 0.9D;
/*      */       }
/*  217 */       this.jLabPrZoom.setText("0.70");
/*  218 */       return 0.7D;
/*      */     }
/*  220 */     if (z.equals("0.90")) {
/*  221 */       if (p.equals("PLUS")) {
/*  222 */         this.jLabPrZoom.setText("1.00");
/*  223 */         return 1.0D;
/*      */       }
/*  225 */       this.jLabPrZoom.setText("0.80");
/*  226 */       return 0.8D;
/*      */     }
/*  228 */     if (z.equals("1.00")) {
/*  229 */       if (p.equals("PLUS")) {
/*  230 */         this.jLabPrZoom.setText("1.10");
/*  231 */         return 1.1D;
/*      */       }
/*  233 */       this.jLabPrZoom.setText("0.90");
/*  234 */       return 0.9D;
/*      */     }
/*  236 */     if (z.equals("1.10")) {
/*  237 */       if (p.equals("PLUS")) {
/*  238 */         this.jLabPrZoom.setText("1.20");
/*  239 */         return 1.2D;
/*      */       }
/*  241 */       this.jLabPrZoom.setText("1.00");
/*  242 */       return 1.0D;
/*      */     }
/*  244 */     if (z.equals("1.20")) {
/*  245 */       if (p.equals("PLUS")) {
/*  246 */         this.jLabPrZoom.setText("1.30");
/*  247 */         return 1.3D;
/*      */       }
/*  249 */       this.jLabPrZoom.setText("1.10");
/*  250 */       return 1.1D;
/*      */     }
/*  252 */     if (z.equals("1.30")) {
/*  253 */       if (p.equals("PLUS")) {
/*  254 */         this.jLabPrZoom.setText("1.40");
/*  255 */         return 1.4D;
/*      */       }
/*  257 */       this.jLabPrZoom.setText("1.20");
/*  258 */       return 1.2D;
/*      */     }
/*  260 */     if (z.equals("1.40")) {
/*  261 */       if (p.equals("PLUS")) {
/*  262 */         this.jLabPrZoom.setText("1.50");
/*  263 */         return 1.5D;
/*      */       }
/*  265 */       this.jLabPrZoom.setText("1.30");
/*  266 */       return 1.3D;
/*      */     }
/*  268 */     if (z.equals("1.50")) {
/*  269 */       if (p.equals("PLUS")) {
/*  270 */         this.jLabPrZoom.setText("1.60");
/*  271 */         return 1.6D;
/*      */       }
/*  273 */       this.jLabPrZoom.setText("1.40");
/*  274 */       return 1.4D;
/*      */     }
/*  276 */     if (z.equals("1.60")) {
/*  277 */       if (p.equals("PLUS")) {
/*  278 */         this.jLabPrZoom.setText("1.70");
/*  279 */         return 1.7D;
/*      */       }
/*  281 */       this.jLabPrZoom.setText("1.50");
/*  282 */       return 1.5D;
/*      */     }
/*  284 */     if (z.equals("1.70")) {
/*  285 */       if (p.equals("PLUS")) {
/*  286 */         this.jLabPrZoom.setText("1.80");
/*  287 */         return 1.8D;
/*      */       }
/*  289 */       this.jLabPrZoom.setText("1.60");
/*  290 */       return 1.6D;
/*      */     }
/*  292 */     if (z.equals("1.80")) {
/*  293 */       if (p.equals("PLUS")) {
/*  294 */         this.jLabPrZoom.setText("1.90");
/*  295 */         return 1.9D;
/*      */       }
/*  297 */       this.jLabPrZoom.setText("1.70");
/*  298 */       return 1.7D;
/*      */     }
/*  300 */     if (z.equals("1.90")) {
/*  301 */       if (p.equals("PLUS")) {
/*  302 */         this.jLabPrZoom.setText("2.00");
/*  303 */         return 2.0D;
/*      */       }
/*  305 */       this.jLabPrZoom.setText("1.80");
/*  306 */       return 1.8D;
/*      */     }
/*  308 */     if (z.equals("2.00")) {
/*  309 */       if (p.equals("PLUS")) {
/*  310 */         this.jLabPrZoom.setText("2.00");
/*  311 */         return 2.0D;
/*      */       }
/*  313 */       this.jLabPrZoom.setText("1.90");
/*  314 */       return 1.9D;
/*      */     }
/*  316 */     this.jLabPrZoom.setText("1.00");
/*  317 */     return 1.0D;
/*      */   }
/*      */   
/*      */   public void setZoomPage(double zoom) {
/*  321 */     if (zoom == 0.2D) {
/*  322 */       this.jLabPrZoom.setText("0.20");
/*      */     }
/*  324 */     if (zoom == 0.3D) {
/*  325 */       this.jLabPrZoom.setText("0.30");
/*      */     }
/*  327 */     if (zoom == 0.4D) {
/*  328 */       this.jLabPrZoom.setText("0.40");
/*      */     }
/*  330 */     if (zoom == 0.5D) {
/*  331 */       this.jLabPrZoom.setText("0.50");
/*      */     }
/*  333 */     if (zoom == 0.6D) {
/*  334 */       this.jLabPrZoom.setText("0.60");
/*      */     }
/*  336 */     if (zoom == 0.7D) {
/*  337 */       this.jLabPrZoom.setText("0.70");
/*      */     }
/*  339 */     if (zoom == 0.8D) {
/*  340 */       this.jLabPrZoom.setText("0.80");
/*      */     }
/*  342 */     if (zoom == 0.9D) {
/*  343 */       this.jLabPrZoom.setText("0.90");
/*      */     }
/*  345 */     if (zoom == 1.0D) {
/*  346 */       this.jLabPrZoom.setText("1.00");
/*      */     }
/*  348 */     if (zoom == 1.1D) {
/*  349 */       this.jLabPrZoom.setText("1.10");
/*      */     }
/*  351 */     if (zoom == 1.2D) {
/*  352 */       this.jLabPrZoom.setText("1.20");
/*      */     }
/*  354 */     if (zoom == 1.3D) {
/*  355 */       this.jLabPrZoom.setText("1.30");
/*      */     }
/*  357 */     if (zoom == 1.4D) {
/*  358 */       this.jLabPrZoom.setText("1.40");
/*      */     }
/*  360 */     if (zoom == 1.5D) {
/*  361 */       this.jLabPrZoom.setText("1.50");
/*      */     }
/*  363 */     if (zoom == 1.6D) {
/*  364 */       this.jLabPrZoom.setText("1.60");
/*      */     }
/*  366 */     if (zoom == 1.7D) {
/*  367 */       this.jLabPrZoom.setText("1.70");
/*      */     }
/*  369 */     if (zoom == 1.8D) {
/*  370 */       this.jLabPrZoom.setText("1.80");
/*      */     }
/*  372 */     if (zoom == 1.9D) {
/*  373 */       this.jLabPrZoom.setText("1.90");
/*      */     }
/*  375 */     if (zoom == 2.0D) {
/*  376 */       this.jLabPrZoom.setText("2.00");
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void initComponents()
/*      */   {
/*  399 */     this.buttonGroup1 = new javax.swing.ButtonGroup();
/*  400 */     this.jToolBar1 = new JToolBar();
/*  401 */     this.jBtNouveau = new JButton();
/*  402 */     this.jBtOuvrir = new JButton();
/*  403 */     this.jBtEnregistrer = new JButton();
/*  404 */     this.jBtEnregistrerSous = new JButton();
/*  405 */     this.jButton8 = new JButton();
/*  406 */     this.jButton1 = new JButton();
/*  407 */     this.jSeparator3 = new javax.swing.JToolBar.Separator();
/*  408 */     this.btRien = new JToggleButton();
/*  409 */     this.btEntite = new JToggleButton();
/*  410 */     this.btRelation = new JToggleButton();
/*  411 */     this.btLien = new JToggleButton();
/*  412 */     this.jSeparator1 = new javax.swing.JToolBar.Separator();
/*  413 */     this.btCif = new JToggleButton();
/*  414 */     this.jSeparator2 = new javax.swing.JToolBar.Separator();
/*  415 */     this.btRegle = new JToggleButton();
/*  416 */     this.jToggleButton1 = new JToggleButton();
/*  417 */     this.jToggleButton2 = new JToggleButton();
/*  418 */     this.jToggleButton3 = new JToggleButton();
/*  419 */     this.jButton5 = new JButton();
/*  420 */     this.jLabPrZoom = new JLabel();
/*  421 */     this.jButton6 = new JButton();
/*  422 */     this.jBtInfo = new JButton();
/*  423 */     this.jSeparator4 = new javax.swing.JToolBar.Separator();
/*  424 */     this.jButton2 = new JButton();
/*  425 */     this.jButton3 = new JButton();
/*  426 */     this.jButton4 = new JButton();
/*  427 */     this.jButton7 = new JButton();
/*  428 */     this.jBtActivation = new JButton();
/*      */     
/*  430 */     setToolTipText("");
/*      */     
/*  432 */     this.jToolBar1.setBackground(new Color(204, 204, 204));
/*  433 */     this.jToolBar1.setFloatable(false);
/*  434 */     this.jToolBar1.setBorderPainted(false);
/*  435 */     this.jToolBar1.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/*  437 */         BarOutil.this.jToolBar1MouseClicked(evt);
/*      */       }
/*      */       
/*  440 */     });
/*  441 */     this.jBtNouveau.setBackground(new Color(204, 204, 204));
/*  442 */     this.jBtNouveau.setIcon(new ImageIcon(getClass().getResource("/Images/newG.png")));
/*  443 */     this.jBtNouveau.setToolTipText("Nouveau");
/*  444 */     this.jBtNouveau.setFocusable(false);
/*  445 */     this.jBtNouveau.setHorizontalTextPosition(0);
/*  446 */     this.jBtNouveau.setVerticalTextPosition(3);
/*  447 */     this.jBtNouveau.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  449 */         BarOutil.this.jBtNouveauActionPerformed(evt);
/*      */       }
/*  451 */     });
/*  452 */     this.jToolBar1.add(this.jBtNouveau);
/*      */     
/*  454 */     this.jBtOuvrir.setBackground(new Color(204, 204, 204));
/*  455 */     this.jBtOuvrir.setIcon(new ImageIcon(getClass().getResource("/Images/openG.png")));
/*  456 */     this.jBtOuvrir.setToolTipText("Ouvrir");
/*  457 */     this.jBtOuvrir.setFocusable(false);
/*  458 */     this.jBtOuvrir.setHorizontalTextPosition(0);
/*  459 */     this.jBtOuvrir.setVerticalTextPosition(3);
/*  460 */     this.jBtOuvrir.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  462 */         BarOutil.this.jBtOuvrirActionPerformed(evt);
/*      */       }
/*  464 */     });
/*  465 */     this.jToolBar1.add(this.jBtOuvrir);
/*      */     
/*  467 */     this.jBtEnregistrer.setBackground(new Color(204, 204, 204));
/*  468 */     this.jBtEnregistrer.setIcon(new ImageIcon(getClass().getResource("/Images/saveG.png")));
/*  469 */     this.jBtEnregistrer.setToolTipText("Enregistrer");
/*  470 */     this.jBtEnregistrer.setFocusable(false);
/*  471 */     this.jBtEnregistrer.setHorizontalTextPosition(0);
/*  472 */     this.jBtEnregistrer.setVerticalTextPosition(3);
/*  473 */     this.jBtEnregistrer.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  475 */         BarOutil.this.jBtEnregistrerActionPerformed(evt);
/*      */       }
/*  477 */     });
/*  478 */     this.jToolBar1.add(this.jBtEnregistrer);
/*      */     
/*  480 */     this.jBtEnregistrerSous.setBackground(new Color(204, 204, 204));
/*  481 */     this.jBtEnregistrerSous.setIcon(new ImageIcon(getClass().getResource("/Images/saveasG.png")));
/*  482 */     this.jBtEnregistrerSous.setToolTipText("Enregistrer sous");
/*  483 */     this.jBtEnregistrerSous.setFocusable(false);
/*  484 */     this.jBtEnregistrerSous.setHorizontalTextPosition(0);
/*  485 */     this.jBtEnregistrerSous.setVerticalTextPosition(3);
/*  486 */     this.jBtEnregistrerSous.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  488 */         BarOutil.this.jBtEnregistrerSousActionPerformed(evt);
/*      */       }
/*  490 */     });
/*  491 */     this.jToolBar1.add(this.jBtEnregistrerSous);
/*      */     
/*  493 */     this.jButton8.setBackground(new Color(204, 204, 204));
/*  494 */     this.jButton8.setIcon(new ImageIcon(getClass().getResource("/Images/printG.png")));
/*  495 */     this.jButton8.setToolTipText("Imprimer MCD ou MLD");
/*  496 */     this.jButton8.setFocusable(false);
/*  497 */     this.jButton8.setHorizontalTextPosition(0);
/*  498 */     this.jButton8.setVerticalTextPosition(3);
/*  499 */     this.jButton8.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  501 */         BarOutil.this.jButton8ActionPerformed(evt);
/*      */       }
/*  503 */     });
/*  504 */     this.jToolBar1.add(this.jButton8);
/*      */     
/*  506 */     this.jButton1.setBackground(new Color(204, 204, 204));
/*  507 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Images/image_exportG.png")));
/*  508 */     this.jButton1.setToolTipText("Exporter sous forme d'image");
/*  509 */     this.jButton1.setFocusable(false);
/*  510 */     this.jButton1.setHorizontalTextPosition(0);
/*  511 */     this.jButton1.setVerticalTextPosition(3);
/*  512 */     this.jButton1.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  514 */         BarOutil.this.jButton1ActionPerformed(evt);
/*      */       }
/*  516 */     });
/*  517 */     this.jToolBar1.add(this.jButton1);
/*  518 */     this.jToolBar1.add(this.jSeparator3);
/*      */     
/*  520 */     this.btRien.setBackground(new Color(204, 204, 204));
/*  521 */     this.buttonGroup1.add(this.btRien);
/*  522 */     this.btRien.setIcon(new ImageIcon(getClass().getResource("/Images/main.png")));
/*  523 */     this.btRien.setSelected(true);
/*  524 */     this.btRien.setToolTipText("Mode Selection");
/*  525 */     this.btRien.setFocusable(false);
/*  526 */     this.btRien.setHorizontalTextPosition(0);
/*  527 */     this.btRien.setVerticalTextPosition(3);
/*  528 */     this.btRien.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  530 */         BarOutil.this.btRienActionPerformed(evt);
/*      */       }
/*  532 */     });
/*  533 */     this.jToolBar1.add(this.btRien);
/*      */     
/*  535 */     this.btEntite.setBackground(new Color(204, 204, 204));
/*  536 */     this.buttonGroup1.add(this.btEntite);
/*  537 */     this.btEntite.setIcon(new ImageIcon(getClass().getResource("/Images/entite.png")));
/*  538 */     this.btEntite.setToolTipText("Nouvelle Entité");
/*  539 */     this.btEntite.setFocusable(false);
/*  540 */     this.btEntite.setHorizontalTextPosition(0);
/*  541 */     this.btEntite.setVerticalTextPosition(3);
/*  542 */     this.btEntite.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  544 */         BarOutil.this.btEntiteActionPerformed(evt);
/*      */       }
/*  546 */     });
/*  547 */     this.jToolBar1.add(this.btEntite);
/*      */     
/*  549 */     this.btRelation.setBackground(new Color(204, 204, 204));
/*  550 */     this.buttonGroup1.add(this.btRelation);
/*  551 */     this.btRelation.setIcon(new ImageIcon(getClass().getResource("/Images/relation.png")));
/*  552 */     this.btRelation.setToolTipText("Nouvelle Relation");
/*  553 */     this.btRelation.setFocusable(false);
/*  554 */     this.btRelation.setHorizontalTextPosition(0);
/*  555 */     this.btRelation.setVerticalTextPosition(3);
/*  556 */     this.btRelation.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  558 */         BarOutil.this.btRelationActionPerformed(evt);
/*      */       }
/*  560 */     });
/*  561 */     this.jToolBar1.add(this.btRelation);
/*      */     
/*  563 */     this.btLien.setBackground(new Color(204, 204, 204));
/*  564 */     this.buttonGroup1.add(this.btLien);
/*  565 */     this.btLien.setIcon(new ImageIcon(getClass().getResource("/Images/lien.png")));
/*  566 */     this.btLien.setToolTipText("Nouveau Lien");
/*  567 */     this.btLien.setFocusable(false);
/*  568 */     this.btLien.setHorizontalTextPosition(0);
/*  569 */     this.btLien.setVerticalTextPosition(3);
/*  570 */     this.btLien.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  572 */         BarOutil.this.btLienActionPerformed(evt);
/*      */       }
/*  574 */     });
/*  575 */     this.jToolBar1.add(this.btLien);
/*  576 */     this.jToolBar1.add(this.jSeparator1);
/*      */     
/*  578 */     this.btCif.setBackground(new Color(204, 204, 204));
/*  579 */     this.buttonGroup1.add(this.btCif);
/*  580 */     this.btCif.setIcon(new ImageIcon(getClass().getResource("/Images/Contraintes.png")));
/*  581 */     this.btCif.setToolTipText("Contraintes");
/*  582 */     this.btCif.setFocusable(false);
/*  583 */     this.btCif.setHorizontalTextPosition(0);
/*  584 */     this.btCif.setVerticalTextPosition(3);
/*  585 */     this.btCif.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  587 */         BarOutil.this.btCifActionPerformed(evt);
/*      */       }
/*  589 */     });
/*  590 */     this.jToolBar1.add(this.btCif);
/*  591 */     this.jToolBar1.add(this.jSeparator2);
/*      */     
/*  593 */     this.btRegle.setBackground(new Color(204, 204, 204));
/*  594 */     this.btRegle.setIcon(new ImageIcon(getClass().getResource("/Images/Regle.png")));
/*  595 */     this.btRegle.setSelected(true);
/*  596 */     this.btRegle.setToolTipText("Grille");
/*  597 */     this.btRegle.setFocusable(false);
/*  598 */     this.btRegle.setHorizontalTextPosition(0);
/*  599 */     this.btRegle.setVerticalTextPosition(3);
/*  600 */     this.btRegle.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  602 */         BarOutil.this.btRegleActionPerformed(evt);
/*      */       }
/*  604 */     });
/*  605 */     this.jToolBar1.add(this.btRegle);
/*      */     
/*  607 */     this.jToggleButton1.setBackground(new Color(204, 204, 204));
/*  608 */     this.buttonGroup1.add(this.jToggleButton1);
/*  609 */     this.jToggleButton1.setIcon(new ImageIcon(getClass().getResource("/Images/cadre.png")));
/*  610 */     this.jToggleButton1.setToolTipText("Cadre");
/*  611 */     this.jToggleButton1.setFocusable(false);
/*  612 */     this.jToggleButton1.setHorizontalTextPosition(0);
/*  613 */     this.jToggleButton1.setVerticalTextPosition(3);
/*  614 */     this.jToggleButton1.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  616 */         BarOutil.this.jToggleButton1ActionPerformed(evt);
/*      */       }
/*  618 */     });
/*  619 */     this.jToolBar1.add(this.jToggleButton1);
/*      */     
/*  621 */     this.jToggleButton2.setBackground(new Color(204, 204, 204));
/*  622 */     this.buttonGroup1.add(this.jToggleButton2);
/*  623 */     this.jToggleButton2.setIcon(new ImageIcon(getClass().getResource("/Images/commentaire.png")));
/*  624 */     this.jToggleButton2.setToolTipText("Commentaire");
/*  625 */     this.jToggleButton2.setFocusable(false);
/*  626 */     this.jToggleButton2.setHorizontalTextPosition(0);
/*  627 */     this.jToggleButton2.setVerticalTextPosition(3);
/*  628 */     this.jToggleButton2.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  630 */         BarOutil.this.jToggleButton2ActionPerformed(evt);
/*      */       }
/*  632 */     });
/*  633 */     this.jToolBar1.add(this.jToggleButton2);
/*      */     
/*  635 */     this.jToggleButton3.setBackground(new Color(204, 204, 204));
/*  636 */     this.buttonGroup1.add(this.jToggleButton3);
/*  637 */     this.jToggleButton3.setIcon(new ImageIcon(getClass().getResource("/Images/postit2.png")));
/*  638 */     this.jToggleButton3.setToolTipText("Post it");
/*  639 */     this.jToggleButton3.setFocusable(false);
/*  640 */     this.jToggleButton3.setHorizontalTextPosition(0);
/*  641 */     this.jToggleButton3.setVerticalTextPosition(3);
/*  642 */     this.jToggleButton3.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  644 */         BarOutil.this.jToggleButton3ActionPerformed(evt);
/*      */       }
/*  646 */     });
/*  647 */     this.jToolBar1.add(this.jToggleButton3);
/*      */     
/*  649 */     this.jButton5.setBackground(new Color(204, 204, 204));
/*  650 */     this.jButton5.setIcon(new ImageIcon(getClass().getResource("/Images/zoom+.png")));
/*  651 */     this.jButton5.setToolTipText("Zoom + ");
/*  652 */     this.jButton5.setFocusable(false);
/*  653 */     this.jButton5.setHorizontalTextPosition(0);
/*  654 */     this.jButton5.setVerticalTextPosition(3);
/*  655 */     this.jButton5.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  657 */         BarOutil.this.jButton5ActionPerformed(evt);
/*      */       }
/*  659 */     });
/*  660 */     this.jToolBar1.add(this.jButton5);
/*      */     
/*  662 */     this.jLabPrZoom.setFont(new java.awt.Font("Tahoma", 1, 12));
/*  663 */     this.jLabPrZoom.setForeground(new Color(0, 0, 102));
/*  664 */     this.jLabPrZoom.setHorizontalAlignment(0);
/*  665 */     this.jLabPrZoom.setText("1.00");
/*  666 */     this.jLabPrZoom.setToolTipText("double cliquer pour revenir à 1.00");
/*  667 */     this.jLabPrZoom.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  668 */     this.jLabPrZoom.setMaximumSize(new java.awt.Dimension(41, 33));
/*  669 */     this.jLabPrZoom.setMinimumSize(new java.awt.Dimension(41, 33));
/*  670 */     this.jLabPrZoom.setPreferredSize(new java.awt.Dimension(41, 19));
/*  671 */     this.jLabPrZoom.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(java.awt.event.MouseEvent evt) {
/*  673 */         BarOutil.this.jLabPrZoomMouseClicked(evt);
/*      */       }
/*  675 */     });
/*  676 */     this.jToolBar1.add(this.jLabPrZoom);
/*      */     
/*  678 */     this.jButton6.setBackground(new Color(204, 204, 204));
/*  679 */     this.jButton6.setIcon(new ImageIcon(getClass().getResource("/Images/zoom-.png")));
/*  680 */     this.jButton6.setToolTipText(" zoom -");
/*  681 */     this.jButton6.setFocusable(false);
/*  682 */     this.jButton6.setHorizontalTextPosition(0);
/*  683 */     this.jButton6.setVerticalTextPosition(3);
/*  684 */     this.jButton6.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  686 */         BarOutil.this.jButton6ActionPerformed(evt);
/*      */       }
/*  688 */     });
/*  689 */     this.jToolBar1.add(this.jButton6);
/*      */     
/*  691 */     this.jBtInfo.setBackground(new Color(204, 204, 204));
/*  692 */     this.jBtInfo.setIcon(new ImageIcon(getClass().getResource("/Images/informations.png")));
/*  693 */     this.jBtInfo.setToolTipText("Informations générales");
/*  694 */     this.jBtInfo.setFocusable(false);
/*  695 */     this.jBtInfo.setHorizontalTextPosition(0);
/*  696 */     this.jBtInfo.setVerticalTextPosition(3);
/*  697 */     this.jBtInfo.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  699 */         BarOutil.this.jBtInfoActionPerformed(evt);
/*      */       }
/*  701 */     });
/*  702 */     this.jToolBar1.add(this.jBtInfo);
/*  703 */     this.jToolBar1.add(this.jSeparator4);
/*      */     
/*  705 */     this.jButton2.setBackground(new Color(204, 204, 204));
/*  706 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Images/verifier.png")));
/*  707 */     this.jButton2.setToolTipText("Vérifier MCD");
/*  708 */     this.jButton2.setFocusable(false);
/*  709 */     this.jButton2.setHorizontalTextPosition(0);
/*  710 */     this.jButton2.setVerticalTextPosition(3);
/*  711 */     this.jButton2.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  713 */         BarOutil.this.jButton2ActionPerformed(evt);
/*      */       }
/*  715 */     });
/*  716 */     this.jToolBar1.add(this.jButton2);
/*      */     
/*  718 */     this.jButton3.setBackground(new Color(204, 204, 204));
/*  719 */     this.jButton3.setIcon(new ImageIcon(getClass().getResource("/Images/constructionMLD.png")));
/*  720 */     this.jButton3.setToolTipText("Convertir le MCD");
/*  721 */     this.jButton3.setFocusable(false);
/*  722 */     this.jButton3.setHorizontalTextPosition(0);
/*  723 */     this.jButton3.setVerticalTextPosition(3);
/*  724 */     this.jButton3.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  726 */         BarOutil.this.jButton3ActionPerformed(evt);
/*      */       }
/*  728 */     });
/*  729 */     this.jToolBar1.add(this.jButton3);
/*      */     
/*  731 */     this.jButton4.setBackground(new Color(204, 204, 204));
/*  732 */     this.jButton4.setIcon(new ImageIcon(getClass().getResource("/Images/DB.png")));
/*  733 */     this.jButton4.setToolTipText("Connexion à la base de données");
/*  734 */     this.jButton4.setFocusable(false);
/*  735 */     this.jButton4.setHorizontalTextPosition(0);
/*  736 */     this.jButton4.setVerticalTextPosition(3);
/*  737 */     this.jButton4.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  739 */         BarOutil.this.jButton4ActionPerformed(evt);
/*      */       }
/*  741 */     });
/*  742 */     this.jToolBar1.add(this.jButton4);
/*      */     
/*  744 */     this.jButton7.setBackground(new Color(204, 204, 204));
/*  745 */     this.jButton7.setIcon(new ImageIcon(getClass().getResource("/Images/download.png")));
/*  746 */     this.jButton7.setToolTipText("Téléchargement des MCDs");
/*  747 */     this.jButton7.setFocusable(false);
/*  748 */     this.jButton7.setHorizontalTextPosition(0);
/*  749 */     this.jButton7.setVerticalTextPosition(3);
/*  750 */     this.jButton7.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  752 */         BarOutil.this.jButton7ActionPerformed(evt);
/*      */       }
/*  754 */     });
/*  755 */     this.jToolBar1.add(this.jButton7);
/*      */     
/*  757 */     this.jBtActivation.setBackground(new Color(204, 204, 204));
/*  758 */     this.jBtActivation.setIcon(new ImageIcon(getClass().getResource("/Images/don.png")));
/*  759 */     this.jBtActivation.setToolTipText("Activer JMerise");
/*  760 */     this.jBtActivation.setFocusable(false);
/*  761 */     this.jBtActivation.setHorizontalTextPosition(0);
/*  762 */     this.jBtActivation.setVerticalTextPosition(3);
/*  763 */     this.jBtActivation.addActionListener(new ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  765 */         BarOutil.this.jBtActivationActionPerformed(evt);
/*      */       }
/*  767 */     });
/*  768 */     this.jToolBar1.add(this.jBtActivation);
/*      */     
/*  770 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
/*  771 */     setLayout(layout);
/*  772 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jToolBar1, -1, 988, 32767));
/*      */     
/*      */ 
/*      */ 
/*  776 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jToolBar1, -1, -1, 32767));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private void btEntiteActionPerformed(ActionEvent evt)
/*      */   {
/*  784 */     this.etat = "ENTITE";
/*  785 */     this.btEntite.setSelected(true);
/*  786 */     this.statutBar.setStatutLab("Nouvelle " + this.etat);
/*      */   }
/*      */   
/*      */   private void btRelationActionPerformed(ActionEvent evt) {
/*  790 */     if ((this.frm.getFormeMCD().isSelected()) && (this.frm.getFormeMCD().getPage().sontElleDesEntites())) {
/*  791 */       this.etat = "RIEN";
/*  792 */       this.frm.getFormeMCD().getPage().ajouterRelationDirect();
/*  793 */       this.btRien.setSelected(true);
/*  794 */       this.statutBar.setStatutLab("Mode SELECTION");
/*      */     } else {
/*  796 */       this.etat = "RELATION";
/*  797 */       this.btRelation.setSelected(true);
/*  798 */       this.statutBar.setStatutLab("Nouvelle " + this.etat);
/*      */     }
/*      */   }
/*      */   
/*      */   private void btLienActionPerformed(ActionEvent evt) {
/*  803 */     this.etat = "LIEN";
/*  804 */     this.frm.getPage().entRelaSelect1 = null;
/*  805 */     this.frm.getPage().entRelaSelect2 = null;
/*  806 */     this.frm.getPage().entRelaSelect = null;
/*  807 */     this.btLien.setSelected(true);
/*  808 */     this.statutBar.setStatutLab("Nouveau " + this.etat);
/*      */   }
/*      */   
/*      */   private void btRienActionPerformed(ActionEvent evt) {
/*  812 */     this.etat = "RIEN";
/*  813 */     this.btRien.setSelected(true);
/*  814 */     this.statutBar.setStatutLab("Mode SELECTION");
/*      */   }
/*      */   
/*      */   private void btRegleActionPerformed(ActionEvent evt) {
/*  818 */     this.afficheRegle = (!this.afficheRegle);
/*  819 */     this.frm.getPage().repaint();
/*  820 */     this.frm.getFormeMLD().getPageMld().repaint();
/*      */   }
/*      */   
/*      */   private void btCifActionPerformed(ActionEvent evt) {
/*  824 */     this.menuContrainte.show(this.btCif, 20, 30);
/*  825 */     this.statutBar.setStatutLab("Nouvelle CONTRAINTE");
/*      */   }
/*      */   
/*      */   private void jToggleButton2ActionPerformed(ActionEvent evt) {
/*  829 */     this.etat = "COMMENTAIREIND";
/*  830 */     this.statutBar.setStatutLab("Nouveau COMMENTAIRE");
/*      */   }
/*      */   
/*      */   private void jToggleButton1ActionPerformed(ActionEvent evt) {
/*  834 */     this.etat = "CADRE";
/*  835 */     this.statutBar.setStatutLab("Nouveau " + this.etat);
/*      */   }
/*      */   
/*      */   private void jBtNouveauActionPerformed(ActionEvent evt) {
/*  839 */     Outil.Setting.licence.setNbUsed(Outil.Setting.licence.getNbUsed() + 1);
/*  840 */     this.frm.creerNouveauProjet();
/*      */   }
/*      */   
/*      */   private void jBtOuvrirActionPerformed(ActionEvent evt) {
/*  844 */     if (this.frm.getProjetSel() != null) {
/*  845 */       if (this.frm.getProjetSel().getFormeMCD().isPageMCDVide()) {
/*  846 */         this.frm.getFormeMCD().setModifier(false);
/*  847 */         this.frm.getFormeMCD().ouvrirMCD(true);
/*      */       } else {
/*  849 */         boolean mod = this.frm.getFormeMCD().isModifier();
/*  850 */         IhmProjet pr = this.frm.getProjetSel();
/*  851 */         this.frm.getFormeMCD().setModifier(false);
/*  852 */         this.frm.getFormeMCD().ouvrirMCD(false);
/*  853 */         if (pr != this.frm.getProjetSel()) pr.getFormeMCD().setModifier(mod);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void jBtEnregistrerActionPerformed(ActionEvent evt) {
/*  859 */     this.frm.getFormeMCD().enregistrerMCD();
/*      */   }
/*      */   
/*      */   private void jBtEnregistrerSousActionPerformed(ActionEvent evt) {
/*  863 */     this.frm.getFormeMCD().enregistrerSousMCD();
/*      */   }
/*      */   
/*      */   private void jButton1ActionPerformed(ActionEvent evt) {
/*  867 */     this.frm.getPage().setPreferredSize(new java.awt.Dimension(0, 0));
/*  868 */     this.frm.getPage().setSize(new java.awt.Dimension(0, 0));
/*  869 */     this.frm.getPage().repaint();
/*  870 */     this.frm.getFormeMLD().getPageMld().setPreferredSize(new java.awt.Dimension(0, 0));
/*  871 */     this.frm.getFormeMLD().getPageMld().setSize(new java.awt.Dimension(0, 0));
/*  872 */     this.frm.getFormeMLD().getPageMld().repaint();
/*      */     
/*      */ 
/*  875 */     javax.swing.JFileChooser fileCh = new javax.swing.JFileChooser();
/*  876 */     javax.swing.filechooser.FileNameExtensionFilter filtre = new javax.swing.filechooser.FileNameExtensionFilter("Fichier png", new String[] { "jpg", "jpeg", "png" });
/*  877 */     fileCh.setFileFilter(filtre);
/*  878 */     if (fileCh.showSaveDialog(this.frm) == 0) {
/*  879 */       java.io.File fil = new java.io.File(fileCh.getSelectedFile().getAbsolutePath());
/*  880 */       String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/*  881 */       nomFile = this.frm.prefixNomJPG(nomFile);
/*  882 */       if (this.frm.getFormeMLD().isSelected()) {
/*  883 */         Outil.Parametres.exporteImageMLD(this.frm, this.frm.getFormeMLD().getPageMld(), nomFile, 1);
/*      */       } else
/*  885 */         Outil.Parametres.exporteImage(this.frm, this.frm.getPage(), nomFile, 0);
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton2ActionPerformed(ActionEvent evt) {
/*  890 */     this.frm.getConsole().getRapport().setText("");
/*  891 */     mythread.ThreadVerifMCD2 thread = new mythread.ThreadVerifMCD2(this.frm);
/*      */     
/*  893 */     if (!this.frm.getjMIConsole().isSelected()) {
/*  894 */       this.frm.getjMIConsole().setSelected(true);
/*  895 */       this.frm.getConsole().setVisible(this.frm.getjMIConsole().isSelected());
/*  896 */       if (this.frm.getjMIConsole().isSelected()) {
/*  897 */         this.frm.getConsole().setSize(this.frm.getConsole().getWidth(), 20);
/*  898 */         this.frm.getSplitCon().setDividerLocation(this.frm.getHeight() - 200 - this.frm.getConsole().getHeight());
/*      */       }
/*      */     }
/*  901 */     thread.execute();
/*      */   }
/*      */   
/*      */   private void jButton3ActionPerformed(ActionEvent evt) {
/*  905 */     this.frm.getConsole().getRapport().setText("");
/*  906 */     if (!this.frm.getjMIConsole().isSelected()) {
/*  907 */       this.frm.getjMIConsole().setSelected(true);
/*  908 */       this.frm.getConsole().setVisible(this.frm.getjMIConsole().isSelected());
/*  909 */       if (this.frm.getjMIConsole().isSelected()) {
/*  910 */         this.frm.getConsole().setSize(this.frm.getConsole().getWidth(), 20);
/*  911 */         this.frm.getSplitCon().setDividerLocation(this.frm.getHeight() - 200 - this.frm.getConsole().getHeight());
/*      */       }
/*      */     }
/*      */     
/*  915 */     new mythread.ThreadConstruction(this.frm, this.frm.getPage()).execute();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void jButton4ActionPerformed(ActionEvent evt)
/*      */   {
/*  965 */     if (this.frm.getFormeMCD().getConnexion().conn == null) {
/*  966 */       new ihm.FormeConnexion(this.frm, true, this.frm.getFormeSQL().getPanelsql().getTypeSql()).setVisible(true);
/*      */     } else {
/*      */       try {
/*  969 */         if (this.frm.getFormeMCD().getConnexion().conn.isClosed()) {
/*  970 */           new ihm.FormeConnexion(this.frm, true, this.frm.getFormeSQL().getPanelsql().getTypeSql()).setVisible(true);
/*      */         }
/*  972 */         else if (javax.swing.JOptionPane.showConfirmDialog(this.frm, "Vous êtes déjà connecté !!.\n Voulez vous vous déconnecter ?", "Connexion ", 0) == 0) {
/*  973 */           Outil.Connexion.Deconnecter(this.frm.getFormeMCD().getConnexion());
/*      */         }
/*      */       }
/*      */       catch (java.sql.SQLException ex) {
/*  977 */         java.util.logging.Logger.getLogger(BarOutil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private void jButton5ActionPerformed(ActionEvent evt) {
/*  983 */     double z = getZoom(this.jLabPrZoom.getText(), "PLUS");
/*      */     
/*  985 */     if (Outil.Setting.zoomToutPage) {
/*  986 */       for (int i = 0; i < this.frm.getListeProjet().size(); i++) {
/*  987 */         ((IhmProjet)this.frm.getListeProjet().get(i)).getFormeMCD().getPage().zoom = z;
/*  988 */         ((IhmProjet)this.frm.getListeProjet().get(i)).getFormeMCD().getPage().getConfigurationMCD().zoom = z;
/*  989 */         ((IhmProjet)this.frm.getListeProjet().get(i)).getFormeMLD().getPageMld().setZoom(z);
/*      */       }
/*      */     } else {
/*  992 */       if (this.frm.getFormeMCD().isSelected()) {
/*  993 */         this.frm.getPage().zoom = z;
/*  994 */         this.frm.getPage().getConfigurationMCD().zoom = z;
/*      */       }
/*  996 */       if (this.frm.getFormeMLD().isSelected()) {
/*  997 */         this.frm.getFormeMLD().getPageMld().setZoom(z);
/*      */       }
/*      */     }
/*      */     
/* 1001 */     this.frm.getPage().repaint();
/* 1002 */     this.frm.getFormeMLD().getPageMld().repaint();
/*      */   }
/*      */   
/*      */   private void jButton6ActionPerformed(ActionEvent evt) {
/* 1006 */     double z = getZoom(this.jLabPrZoom.getText(), "MOINS");
/*      */     
/* 1008 */     if (Outil.Setting.zoomToutPage) {
/* 1009 */       for (int i = 0; i < this.frm.getListeProjet().size(); i++) {
/* 1010 */         ((IhmProjet)this.frm.getListeProjet().get(i)).getFormeMCD().getPage().zoom = z;
/* 1011 */         ((IhmProjet)this.frm.getListeProjet().get(i)).getFormeMCD().getPage().getConfigurationMCD().zoom = z;
/* 1012 */         ((IhmProjet)this.frm.getListeProjet().get(i)).getFormeMLD().getPageMld().setZoom(z);
/*      */       }
/*      */     } else {
/* 1015 */       if (this.frm.getFormeMCD().isSelected()) {
/* 1016 */         this.frm.getPage().zoom = z;
/* 1017 */         this.frm.getPage().getConfigurationMCD().zoom = z;
/*      */       }
/* 1019 */       if (this.frm.getFormeMLD().isSelected()) {
/* 1020 */         this.frm.getFormeMLD().getPageMld().setZoom(z);
/*      */       }
/*      */     }
/*      */     
/* 1024 */     this.frm.getPage().repaint();
/* 1025 */     this.frm.getFormeMLD().getPageMld().repaint();
/*      */   }
/*      */   
/*      */   private void jBtInfoActionPerformed(ActionEvent evt)
/*      */   {
/* 1030 */     this.menuInformation.show(this.jBtInfo, 20, 30);
/*      */   }
/*      */   
/*      */   private void jToggleButton3ActionPerformed(ActionEvent evt) {
/* 1034 */     this.etat = "POSTIT";
/* 1035 */     this.statutBar.setStatutLab("Nouveau " + this.etat);
/*      */   }
/*      */   
/*      */ 
/*      */   private void jToolBar1MouseClicked(java.awt.event.MouseEvent evt) {}
/*      */   
/*      */   private void jButton7ActionPerformed(ActionEvent evt)
/*      */   {
/* 1043 */     this.frm.getFormeBibioMCD().setVisible(true);
/*      */   }
/*      */   
/*      */   private void jButton8ActionPerformed(ActionEvent evt)
/*      */   {
/* 1048 */     this.frm.getPage().setPreferredSize(new java.awt.Dimension((int)getSize().getWidth() - 400, (int)getSize().getHeight() - 400));
/* 1049 */     this.frm.getPage().setSize(new java.awt.Dimension((int)getSize().getWidth() - 100, (int)getSize().getHeight() - 100));
/* 1050 */     this.frm.getPage().repaint();
/* 1051 */     this.frm.getFormeMLD().getPageMld().setPreferredSize(new java.awt.Dimension((int)getSize().getWidth() - 400, (int)getSize().getHeight() - 400));
/* 1052 */     this.frm.getFormeMLD().getPageMld().setSize(new java.awt.Dimension((int)getSize().getWidth() - 100, (int)getSize().getHeight() - 100));
/* 1053 */     this.frm.getFormeMLD().getPageMld().repaint();
/* 1054 */     if (this.frm.getFormeMLD().isSelected()) {
/* 1055 */       new mythread.ThreadImprimer(this.frm, this.frm.getFormeMLD().getPageMld(), "MLD : " + this.frm.getProjetSel().toString()).execute();
/*      */     } else {
/* 1057 */       new mythread.ThreadImprimer(this.frm, this.frm.getFormeMCD().getPage(), "MCD : " + this.frm.getProjetSel().toString()).execute();
/*      */     }
/*      */   }
/*      */   
/*      */   private void jBtActivationActionPerformed(ActionEvent evt)
/*      */   {
/* 1063 */     if (java.awt.Desktop.isDesktopSupported())
/*      */     {
/* 1065 */       java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
/*      */       
/*      */ 
/* 1068 */       if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
/*      */         try
/*      */         {
/*      */           try {
/* 1072 */             desktop.browse(new java.net.URI("http://www.jfreesoft.com/JMerise/activation.html"));
/*      */           } catch (java.net.URISyntaxException ex) {
/* 1074 */             java.util.logging.Logger.getLogger(BarOutil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*      */           }
/*      */         } catch (java.io.IOException ex) {
/* 1077 */           java.util.logging.Logger.getLogger(BarOutil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void jLabPrZoomMouseClicked(java.awt.event.MouseEvent evt)
/*      */   {
/* 1086 */     if (evt.getClickCount() == 2) {
/* 1087 */       this.jLabPrZoom.setText("1.00");
/* 1088 */       if (this.frm.getFormeMCD().isSelected()) {
/* 1089 */         this.frm.getPage().zoom = 1.0D;
/* 1090 */         this.frm.getPage().repaint();
/*      */       }
/*      */       
/* 1093 */       if (this.frm.getFormeMLD().isSelected()) {
/* 1094 */         this.frm.getFormeMLD().getPageMld().repaint();
/* 1095 */         this.frm.getFormeMLD().getPageMld().setZoom(1.0D);
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\BarOutil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */