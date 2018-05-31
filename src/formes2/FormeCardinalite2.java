/*      */ package formes2;
/*      */ 
/*      */ import IhmMCD2.IhmCardinalite;
/*      */ import IhmMCD2.IhmLien2;
/*      */ import java.awt.Color;
/*      */ import java.awt.Graphics;
/*      */ import java.awt.Graphics2D;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.MouseEvent;
/*      */ import javax.swing.GroupLayout;
/*      */ import javax.swing.GroupLayout.Alignment;
/*      */ import javax.swing.GroupLayout.ParallelGroup;
/*      */ import javax.swing.GroupLayout.SequentialGroup;
/*      */ import javax.swing.JButton;
/*      */ import javax.swing.JCheckBox;
/*      */ import javax.swing.JComboBox;
/*      */ import javax.swing.JLabel;
/*      */ import javax.swing.JPanel;
/*      */ import javax.swing.JTextField;
import javax.swing.LayoutStyle;
/*      */ import javax.swing.LayoutStyle.ComponentPlacement;
/*      */ 
/*      */ public class FormeCardinalite2 extends javax.swing.JDialog
/*      */ {
/*      */   ihm.Principale frm;
/*      */   IhmLien2 lien;
/*      */   String ancienneCardinalite;
/*      */   private JButton jBtAnnuler;
/*      */   private JButton jBtHsitorique;
/*      */   private JButton jBtOK;
/*      */   private JComboBox jCBCardinalite;
/*      */   private JCheckBox jCBDefaut;
/*      */   private JCheckBox jCBFleche;
/*      */   private JCheckBox jCBHorloge;
/*      */   private JCheckBox jCBLienRelatif;
/*      */   private JComboBox jCBStabilite;
/*      */   private JCheckBox jCBTout;
/*      */   private JLabel jLabCardinalite;
/*      */   private JLabel jLabLien;
/*      */   private JLabel jLabNom;
/*      */   private JLabel jLabel1;
/*      */   private JLabel jLabel10;
/*      */   private JLabel jLabel12;
/*      */   private JLabel jLabel13;
/*      */   private JLabel jLabel14;
/*      */   private JLabel jLabel15;
/*      */   private JLabel jLabel2;
/*      */   
/*      */   public FormeCardinalite2(ihm.Principale frm, boolean modal, IhmLien2 lien, int x, int y)
/*      */   {
/*   50 */     super(frm, modal);
/*   51 */     initComponents();
/*   52 */     this.frm = frm;
/*   53 */     this.lien = lien;
/*   54 */     this.jBtOK.setMnemonic(10);
/*   55 */     this.jBtAnnuler.setMnemonic(65);
/*   56 */     initData();
/*   57 */     setLocation(frm.getX() + 290, frm.getY() + 120);
/*   58 */     this.ancienneCardinalite = lien.getCardinalite();
/*      */   }
/*      */   
/*      */   public FormeCardinalite2(ihm.Principale frm, boolean modal, IhmLien2 lien, int x, int y, boolean activer) {
/*   62 */     super(frm, modal);
/*   63 */     initComponents();
/*   64 */     this.frm = frm;
/*   65 */     this.lien = lien;
/*   66 */     this.jBtOK.setMnemonic(10);
/*   67 */     this.jBtAnnuler.setMnemonic(65);
/*   68 */     initData();
/*   69 */     setLocation(frm.getX() + 290, frm.getY() + 120);
/*   70 */     this.jBtOK.setEnabled(activer);
/*   71 */     this.ancienneCardinalite = lien.getCardinalite();
/*      */   }
/*      */   
/*      */   private void initData() {
/*   75 */     this.jTFNom.setText(this.lien.getNom());
/*   76 */     this.jTFCode.setText(this.lien.getCode());
/*   77 */     this.jTFNomEntite.setText(this.lien.getEntite().getEntite().getNom());
/*   78 */     this.jTFNomRelation.setText(this.lien.getRelation().getRelation().getNom());
/*   79 */     this.jTACommentaire.setText(this.lien.getCommentaire());
/*   80 */     this.jLabLien.setBackground(this.lien.getClLien2());
/*   81 */     this.jLabCardinalite.setBackground(this.lien.getClLienText2());
/*   82 */     this.jLabNom.setBackground(this.lien.getClLienNom2());
/*   83 */     activerCardinalite();
/*      */     
/*   85 */     this.jCBLienRelatif.setSelected(this.lien.isRelatif());
/*   86 */     this.jCBFleche.setSelected(this.lien.isFleche());
/*   87 */     this.jSpNBCassure.setValue(Integer.valueOf(this.lien.getPointCassure().size()));
/*      */     
/*   89 */     if (this.lien.getHistorisation().length() > 0) {
/*   90 */       this.jCBHorloge.setSelected(true);
/*      */     } else {
/*   92 */       this.jCBHorloge.setSelected(false);
/*      */     }
/*   94 */     setStabilite(this.lien.getCardinalites().getStabilite());
/*      */   }
/*      */   
/*      */   private void activerCardinalite() {
/*   98 */     String c = this.lien.getCardinalite();
/*   99 */     c = c.replace("(", "");
/*  100 */     c = c.replace(")", "");
/*      */     
/*  102 */     this.jTFMax.setEnabled(false);
/*  103 */     this.jTFMin.setEnabled(false);
/*      */     
/*  105 */     this.jTFMin.setText(this.lien.getCardinalites().getMin());
/*  106 */     this.jTFMax.setText(this.lien.getCardinalites().getMax());
/*      */     
/*  108 */     if (c.equals("0,1")) {
/*  109 */       this.jCBCardinalite.setSelectedIndex(1);
/*  110 */       this.jCBLienRelatif.setEnabled(false);
/*  111 */       return;
/*      */     }
/*  113 */     if (c.equals("1,1")) {
/*  114 */       this.jCBCardinalite.setSelectedIndex(2);
/*  115 */       this.jCBLienRelatif.setEnabled(true);
/*  116 */       return;
/*      */     }
/*  118 */     if (c.equals("0,n")) {
/*  119 */       this.jCBCardinalite.setSelectedIndex(3);
/*  120 */       this.jCBLienRelatif.setEnabled(false);
/*  121 */       return;
/*      */     }
/*  123 */     if (c.equals("1,n")) {
/*  124 */       this.jCBCardinalite.setSelectedIndex(4);
/*  125 */       this.jCBLienRelatif.setEnabled(false);
/*  126 */       return;
/*      */     }
/*      */     
/*  129 */     this.jCBCardinalite.setSelectedIndex(0);
/*  130 */     this.jCBLienRelatif.setEnabled(false);
/*  131 */     this.jTFMax.setEnabled(true);
/*  132 */     this.jTFMin.setEnabled(true);
/*  133 */     this.jTFMin.setText(this.lien.getCardinalites().getMin());
/*  134 */     this.jTFMax.setText(this.lien.getCardinalites().getMax());
/*      */   }
/*      */   
/*      */   private String getCardinalite()
/*      */   {
/*  139 */     String c = "";
/*  140 */     if (this.jCBCardinalite.getSelectedIndex() > 0) c = this.jCBCardinalite.getSelectedItem().toString();
/*  141 */     if ((this.jCBLienRelatif.isEnabled()) && 
/*  142 */       (this.jCBLienRelatif.isSelected())) { c = "(" + c + ")";
/*      */     }
/*  144 */     return c;
/*      */   }
/*      */   
/*      */   private void modifierSQLDispatchKey() {
/*  148 */     if (!this.lien.getCardinalite().equals(this.ancienneCardinalite)) {
/*  149 */       ((IhmMCD2.IhmRelation2)this.lien.getRelation()).setDispatchKey("");
/*      */     }
/*      */   }
/*      */   
/*      */   private void dessinerApercu() {
/*  154 */     Graphics g = this.jPanelAprecu.getGraphics();
/*  155 */     g.setFont(new java.awt.Font("Tahoma", 1, 11));
/*      */     
/*  157 */     String nom = this.jTFNom.getText().trim().length() == 0 ? "NomLien" : this.jTFNom.getText().trim();
/*  158 */     String nomEntite = this.lien == null ? "Entite" : this.lien.getEntite().getEntite().getNom();
/*  159 */     String nomRelation = this.lien == null ? "Relation" : this.lien.getRelation().getRelation().getNom();
/*      */     
/*  161 */     nomEntite = nomEntite.substring(0, nomEntite.length() < 15 ? nomEntite.length() : 15);
/*  162 */     nomRelation = nomRelation.substring(0, nomRelation.length() < 15 ? nomRelation.length() : 15);
/*  163 */     nom = nom.substring(0, nom.length() < 10 ? nom.length() : 10);
/*      */     
/*  165 */     int x = g.getFontMetrics().stringWidth(nomEntite);
/*  166 */     int xR = g.getFontMetrics().stringWidth(nomRelation);
/*      */     
/*  168 */     Graphics2D g2d = (Graphics2D)g;
/*      */     
/*  170 */     g.setColor(Color.WHITE);
/*      */     
/*  172 */     java.awt.geom.RoundRectangle2D rRectT = new java.awt.geom.RoundRectangle2D.Double(0.0D, 0.0D, this.jPanelAprecu.getWidth(), this.jPanelAprecu.getHeight(), 0.0D, 0.0D);
/*  173 */     g2d.fill(rRectT);
/*      */     
/*      */ 
/*  176 */     g.setColor(Color.YELLOW);
/*      */     
/*  178 */     if (this.lien != null) {
/*  179 */       g.setColor(((IhmMCD2.IhmEntite2)this.lien.getEntite()).getClFond2());
/*      */     }
/*  181 */     java.awt.geom.RoundRectangle2D rRect = new java.awt.geom.RoundRectangle2D.Double(0.0D, 20.0D, 100.0D, 100.0D, 0.0D, 0.0D);
/*  182 */     g2d.fill(rRect);
/*  183 */     g.setColor(Color.BLACK);
/*      */     
/*  185 */     g2d.draw(rRect);
/*  186 */     g2d.drawLine(0, 40, 100, 40);
/*  187 */     g2d.drawString(nomEntite, (100 - x) / 2, 35);
/*      */     
/*  189 */     g.setColor(Color.GREEN);
/*  190 */     if (this.lien != null) {
/*  191 */       g.setColor(((IhmMCD2.IhmRelation2)this.lien.getRelation()).getClFond2());
/*      */     }
/*  193 */     java.awt.geom.RoundRectangle2D rRectRel = new java.awt.geom.RoundRectangle2D.Double(220.0D, 45.0D, 110.0D, 50.0D, 50.0D, 50.0D);
/*  194 */     g2d.fill(rRectRel);
/*  195 */     g.setColor(Color.BLACK);
/*      */     
/*  197 */     g2d.draw(rRectRel);
/*  198 */     g2d.drawLine(220, 70, 330, 70);
/*  199 */     g2d.drawString(nomRelation, 220 + (110 - xR) / 2, 60);
/*  200 */     int xx = 130;
/*  201 */     g.setColor(this.jLabCardinalite.getBackground());
/*  202 */     String card = this.jCBCardinalite.getSelectedItem().toString();
/*  203 */     if (card.trim().length() == 0) {
/*  204 */       card = this.jTFMin.getText() + "," + this.jTFMax.getText();
/*      */     }
/*  206 */     if (Outil.Setting.cardinaliteMajuscule) card = card.toUpperCase();
/*  207 */     if (Outil.Setting.cardinalite2points) card = card.replace(",", ":");
/*  208 */     if ((this.jCBLienRelatif.isEnabled()) && 
/*  209 */       (this.jCBLienRelatif.isSelected())) {
/*  210 */       card = "(" + card + ")";
/*  211 */       xx = 140;
/*      */     }
/*      */     
/*  214 */     g2d.drawString(card, 112, 74);
/*      */     
/*  216 */     g.setColor(this.jLabLien.getBackground());
/*  217 */     g2d.drawLine(xx, 70, 220, 70);
/*      */     
/*  219 */     g2d.drawLine(100, 70, 110, 70);
/*  220 */     int[] xtab = { 100, 107, 107 };
/*  221 */     int[] ytab = { 70, 65, 75 };
/*  222 */     if (this.jCBFleche.isSelected()) { g2d.fillPolygon(xtab, ytab, 3);
/*      */     }
/*  224 */     g.setColor(this.jLabNom.getBackground());
/*  225 */     g2d.drawString(nom, xx + 10, 68);
/*      */   }
/*      */   
/*      */   private Color choixDeCouleur(Color color, String titre)
/*      */   {
/*  230 */     Color col = javax.swing.JColorChooser.showDialog(this, titre, color);
/*  231 */     if (col == null) return color;
/*  232 */     return col;
/*      */   }
/*      */   
/*      */   private void appliquerCoulerDefaut()
/*      */   {
/*  237 */     ihm.FormeInterneMCD.clLien2 = this.jLabLien.getBackground();
/*  238 */     ihm.FormeInterneMCD.clLienText2 = this.jLabCardinalite.getBackground();
/*  239 */     ihm.FormeInterneMCD.clLienNom2 = this.jLabNom.getBackground();
/*      */   }
/*      */   
/*      */   private void appliquerCoulerToutLien() {
/*  243 */     java.util.ArrayList<IhmMCD.IhmLien> liste = this.frm.getPage().getListeLien();
/*      */     
/*  245 */     for (int i = 0; i < liste.size(); i++) {
/*  246 */       IhmLien2 l = (IhmLien2)liste.get(i);
/*  247 */       l.setClLien2(this.jLabLien.getBackground());
/*  248 */       l.setClLienText2(this.jLabCardinalite.getBackground());
/*  249 */       l.setClLienNom2(this.jLabNom.getBackground());
/*      */     }
/*      */   }
/*      */   
/*      */   private void ajouterPointDeCassure() {
/*  254 */     int nb = this.lien.getPointCassure().size();
/*  255 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/*      */     
/*  257 */     int x = this.lien.getxCard();
/*  258 */     int y = this.lien.getyCard();
/*  259 */     int dx = 0;int dy = 0;
/*      */     
/*      */ 
/*  262 */     if (this.lien.getCoteEntite() == 1) {
/*  263 */       dx = -20;
/*  264 */       dy = 0;
/*  265 */       x = this.lien.getxCard() - 50;
/*  266 */       y = this.lien.getyCard();
/*      */     }
/*  268 */     if (this.lien.getCoteEntite() == 3) {
/*  269 */       dx = 20;
/*  270 */       dy = 0;
/*  271 */       x = this.lien.getxCard() + 50;
/*  272 */       y = this.lien.getyCard();
/*      */     }
/*  274 */     if (this.lien.getCoteEntite() == 2) {
/*  275 */       dx = 0;
/*  276 */       dy = -20;
/*  277 */       x = this.lien.getxCard();
/*  278 */       y = this.lien.getyCard() - 50;
/*      */     }
/*  280 */     if (this.lien.getCoteEntite() == 4) {
/*  281 */       dx = 0;
/*  282 */       dy = 20;
/*  283 */       x = this.lien.getxCard();
/*  284 */       y = this.lien.getyCard() + 50;
/*      */     }
/*      */     
/*      */ 
/*  288 */     if (nb > 0) {
/*  289 */       x = ((IhmMCD2.IhmPoint)this.lien.getPointCassure().get(nb - 1)).getX();
/*  290 */       y = ((IhmMCD2.IhmPoint)this.lien.getPointCassure().get(nb - 1)).getY();
/*      */     }
/*      */     
/*  293 */     for (int i = nb; i < total; i++) {
/*  294 */       IhmMCD2.IhmPoint p = new IhmMCD2.IhmPoint(x + dx, y + dy);
/*  295 */       x += dx;
/*  296 */       y += dy;
/*  297 */       this.lien.getPointCassure().add(p);
/*      */     }
/*      */   }
/*      */   
/*      */   private void supprimerPointDeCassure() {
/*  302 */     int nb = this.lien.getPointCassure().size();
/*  303 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/*  304 */     for (int i = nb; i > total; i--) {
/*  305 */       this.lien.getPointCassure().remove(i - 1);
/*      */     }
/*      */   }
/*      */   
/*      */   private void modifierPointDeCassure() {
/*  310 */     int nb = this.lien.getPointCassure().size();
/*  311 */     int total = ((Integer)this.jSpNBCassure.getValue()).intValue();
/*  312 */     if (total > nb) {
/*  313 */       ajouterPointDeCassure();
/*  314 */       return;
/*      */     }
/*  316 */     if (total < nb) {
/*  317 */       supprimerPointDeCassure();
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean estEntier(String ent) {
/*  322 */     if (ent == null) return false;
/*  323 */     if (ent.trim().length() == 0) return true;
/*      */     try {
/*  325 */       int nb = Integer.parseInt(ent);
/*  326 */       if (nb >= 0) return true;
/*  327 */       return false;
/*      */     } catch (Exception e) {}
/*  329 */     return false;
/*      */   }
/*      */   
/*      */   private String getStabilite()
/*      */   {
/*  334 */     int ind = this.jCBStabilite.getSelectedIndex();
/*  335 */     if (ind == 1) return "D";
/*  336 */     if (ind == 2) return "V";
/*  337 */     return "";
/*      */   }
/*      */   
/*  340 */   private void setStabilite(String stab) { this.jCBStabilite.setSelectedIndex(0);
/*  341 */     if (stab.equals("D")) this.jCBStabilite.setSelectedIndex(1);
/*  342 */     if (stab.equals("V")) this.jCBStabilite.setSelectedIndex(2);
/*      */   }
/*      */   
/*      */   private boolean isCorrectCardinalite()
/*      */   {
/*  347 */     String min = this.jTFMin.getText();
/*  348 */     String max = this.jTFMax.getText();
/*  349 */     if ((min.trim().length() == 0) || (max.trim().length() == 0)) {
/*  350 */       return false;
/*      */     }
/*  352 */     if (!estEntier(min))
/*      */     {
/*  354 */       return false;
/*      */     }
/*  356 */     if (max.trim().toUpperCase().equals("N")) {
/*  357 */       return true;
/*      */     }
/*  359 */     if (!estEntier(max))
/*      */     {
/*  361 */       return false;
/*      */     }
/*  363 */     int mn = Integer.parseInt(min);
/*  364 */     int mx = Integer.parseInt(max);
/*  365 */     if ((mn == 0) && (mx == 0)) return false;
/*  366 */     if (mx < mn) {
/*  367 */       return false;
/*      */     }
/*  369 */     return true;
/*      */   }
/*      */   
/*      */   private void verifierActivation()
/*      */   {
/*  374 */     if (this.lien.getCardinalite().equals(this.ancienneCardinalite)) {
/*  375 */       return;
/*      */     }
/*      */     
/*  378 */     String car = this.lien.getCardinalite();
/*  379 */     car = car.replace("(", "");
/*  380 */     car = car.replace(")", "");
/*  381 */     if ((!car.toUpperCase().equals("0,1")) && (!car.toUpperCase().equals("1,1")) && (!car.toUpperCase().equals("1,N")) && (!car.toUpperCase().equals("0,N"))) {
/*  382 */       javax.swing.JOptionPane.showMessageDialog(this, "Il faut activer cette version pour personnaliser les cardinalités  ! ");
/*  383 */       this.jTFMin.setText("0");
/*  384 */       this.jTFMax.setText("n");
/*  385 */       this.jCBLienRelatif.setSelected(false);
/*  386 */       this.jCBLienRelatif.setEnabled(false);
/*  387 */       this.lien.setCardinalite(getCardinalite());
/*  388 */       this.lien.getCardinalites().setNom(this.lien.getCardinalite());
/*  389 */       this.lien.getCardinalites().setMin(this.jTFMin.getText());
/*  390 */       this.lien.getCardinalites().setMax(this.jTFMax.getText().toLowerCase());
/*  391 */       this.lien.setRelatif(this.jCBLienRelatif.isEnabled() ? this.jCBLienRelatif.isSelected() : false); } }
/*      */   
/*      */   private JLabel jLabel4;
/*      */   private JLabel jLabel5;
/*      */   private JLabel jLabel7;
/*      */   private JLabel jLabel8;
/*      */   private JLabel jLabel9;
/*      */   private JPanel jPanel1;
/*      */   private JPanel jPanel2;
/*      */   private JPanel jPanel3;
/*      */   private JPanel jPanel4;
/*      */   private JPanel jPanel5;
/*      */   private JPanel jPanel6;
/*      */   
/*  405 */   private void initComponents() { this.jLabel1 = new JLabel();
/*  406 */     this.jTFNom = new JTextField();
/*  407 */     this.jLabel2 = new JLabel();
/*  408 */     this.jTFCode = new JTextField();
/*  409 */     this.jTabbedPane1 = new javax.swing.JTabbedPane();
/*  410 */     this.jPanel3 = new JPanel();
/*  411 */     this.jPanel1 = new JPanel();
/*  412 */     this.jLabel7 = new JLabel();
/*  413 */     this.jTFNomEntite = new JTextField();
/*  414 */     this.jLabel8 = new JLabel();
/*  415 */     this.jTFNomRelation = new JTextField();
/*  416 */     this.jLabel9 = new JLabel();
/*  417 */     this.jLabel10 = new JLabel();
/*  418 */     this.jCBStabilite = new JComboBox();
/*  419 */     this.jSpNBCassure = new javax.swing.JSpinner();
/*  420 */     this.jPanel6 = new JPanel();
/*  421 */     this.jCBCardinalite = new JComboBox();
/*  422 */     this.jLabel4 = new JLabel();
/*  423 */     this.jTFMin = new JTextField();
/*  424 */     this.jLabel5 = new JLabel();
/*  425 */     this.jTFMax = new JTextField();
/*  426 */     this.jPanel7 = new JPanel();
/*  427 */     this.jCBLienRelatif = new JCheckBox();
/*  428 */     this.jCBFleche = new JCheckBox();
/*  429 */     this.jCBHorloge = new JCheckBox();
/*  430 */     this.jPanel4 = new JPanel();
/*  431 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*  432 */     this.jTACommentaire = new javax.swing.JTextPane();
/*  433 */     this.jBtHsitorique = new JButton();
/*  434 */     this.jPanel5 = new JPanel();
/*  435 */     this.jPanelAprecu = new JPanel();
/*  436 */     this.jLabel14 = new JLabel();
/*  437 */     this.jPanel2 = new JPanel();
/*  438 */     this.jLabLien = new JLabel();
/*  439 */     this.jLabel12 = new JLabel();
/*  440 */     this.jLabel13 = new JLabel();
/*  441 */     this.jLabel15 = new JLabel();
/*  442 */     this.jLabCardinalite = new JLabel();
/*  443 */     this.jLabNom = new JLabel();
/*  444 */     this.jCBTout = new JCheckBox();
/*  445 */     this.jCBDefaut = new JCheckBox();
/*  446 */     this.jBtOK = new JButton();
/*  447 */     this.jBtAnnuler = new JButton();
/*      */     
/*  449 */     setDefaultCloseOperation(2);
/*  450 */     setTitle("Propriétés du Lien");
/*  451 */     setResizable(false);
/*  452 */     addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  454 */         FormeCardinalite2.this.formMouseClicked(evt);
/*      */       }
/*      */       
/*  457 */     });
/*  458 */     this.jLabel1.setText("Nom ");
/*      */     
/*  460 */     this.jLabel2.setText("Code");
/*      */     
/*  462 */     this.jTabbedPane1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
/*      */       public void mouseMoved(MouseEvent evt) {
/*  464 */         FormeCardinalite2.this.jTabbedPane1MouseMoved(evt);
/*      */       }
/*      */       
/*  467 */     });
/*  468 */     this.jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(102, 0, 0)));
/*      */     
/*  470 */     this.jLabel7.setText("Entité ");
/*      */     
/*  472 */     this.jTFNomEntite.setEditable(false);
/*      */     
/*  474 */     this.jLabel8.setText("Relation");
/*      */     
/*  476 */     this.jTFNomRelation.setEditable(false);
/*      */     
/*  478 */     GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
/*  479 */     this.jPanel1.setLayout(jPanel1Layout);
/*  480 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTFNomEntite, -2, 221, -2).addGap(18, 18, 18).addComponent(this.jLabel8).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTFNomRelation, -1, 231, 32767).addContainerGap()));
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
/*  493 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFNomRelation, -2, -1, -2).addComponent(this.jLabel7).addComponent(this.jTFNomEntite, -2, -1, -2).addComponent(this.jLabel8)).addContainerGap(-1, 32767)));
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
/*  505 */     this.jLabel9.setText("Points de cassure ");
/*      */     
/*  507 */     this.jLabel10.setText("Contrainte de stabilité");
/*      */     
/*  509 */     this.jCBStabilite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "D : Définitive", "V : Vérouillée" }));
/*      */     
/*  511 */     this.jSpNBCassure.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
/*      */     
/*  513 */     this.jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Cardinalités"));
/*      */     
/*  515 */     this.jCBCardinalite.setFont(new java.awt.Font("Tahoma", 1, 14));
/*  516 */     this.jCBCardinalite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "0,1", "1,1", "0,n", "1,n" }));
/*  517 */     this.jCBCardinalite.addItemListener(new java.awt.event.ItemListener() {
/*      */       public void itemStateChanged(java.awt.event.ItemEvent evt) {
/*  519 */         FormeCardinalite2.this.jCBCardinaliteItemStateChanged(evt);
/*      */       }
/*  521 */     });
/*  522 */     this.jCBCardinalite.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  524 */         FormeCardinalite2.this.jCBCardinaliteActionPerformed(evt);
/*      */       }
/*      */       
/*  527 */     });
/*  528 */     this.jLabel4.setText("Min");
/*      */     
/*  530 */     this.jTFMin.setFont(new java.awt.Font("Tahoma", 1, 14));
/*  531 */     this.jTFMin.setHorizontalAlignment(0);
/*      */     
/*  533 */     this.jLabel5.setText("Max");
/*      */     
/*  535 */     this.jTFMax.setFont(new java.awt.Font("Tahoma", 1, 14));
/*  536 */     this.jTFMax.setHorizontalAlignment(0);
/*      */     
/*  538 */     GroupLayout jPanel6Layout = new GroupLayout(this.jPanel6);
/*  539 */     this.jPanel6.setLayout(jPanel6Layout);
/*  540 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addComponent(this.jCBCardinalite, -2, 173, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 52, 32767).addComponent(this.jTFMin, -2, 52, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jTFMax, -2, 47, -2).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup().addComponent(this.jLabel4).addGap(48, 48, 48).addComponent(this.jLabel5).addGap(23, 23, 23)))));
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
/*  558 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel6Layout.createSequentialGroup().addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jLabel5)).addGap(16, 16, 16).addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jCBCardinalite, GroupLayout.Alignment.LEADING).addComponent(this.jTFMax, GroupLayout.Alignment.LEADING, -1, 37, 32767).addComponent(this.jTFMin, GroupLayout.Alignment.LEADING, -1, 37, 32767)).addContainerGap(-1, 32767)));
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
/*  572 */     this.jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
/*      */     
/*  574 */     this.jCBLienRelatif.setText("Lien relatif ");
/*  575 */     this.jCBLienRelatif.setHorizontalAlignment(11);
/*  576 */     this.jCBLienRelatif.setHorizontalTextPosition(4);
/*      */     
/*  578 */     this.jCBFleche.setText("Cible");
/*      */     
/*  580 */     this.jCBHorloge.setText("Historisation");
/*  581 */     this.jCBHorloge.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  583 */         FormeCardinalite2.this.jCBHorlogeActionPerformed(evt);
/*      */       }
/*      */       
/*  586 */     });
/*  587 */     GroupLayout jPanel7Layout = new GroupLayout(this.jPanel7);
/*  588 */     this.jPanel7.setLayout(jPanel7Layout);
/*  589 */     jPanel7Layout.setHorizontalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jCBLienRelatif).addComponent(this.jCBFleche).addComponent(this.jCBHorloge)).addContainerGap(44, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  599 */     jPanel7Layout.setVerticalGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel7Layout.createSequentialGroup().addContainerGap().addComponent(this.jCBLienRelatif).addGap(18, 18, 18).addComponent(this.jCBFleche).addGap(18, 18, 18).addComponent(this.jCBHorloge).addContainerGap(15, 32767)));
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
/*  611 */     GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
/*  612 */     this.jPanel3.setLayout(jPanel3Layout);
/*  613 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jPanel6, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 86, 32767).addComponent(this.jPanel7, -2, -1, -2).addContainerGap()).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jLabel9).addGap(18, 18, 18).addComponent(this.jSpNBCassure, -2, 81, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 156, 32767).addComponent(this.jLabel10).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jCBStabilite, -2, 124, -2).addGap(19, 19, 19)).addGroup(jPanel3Layout.createSequentialGroup().addComponent(this.jPanel1, 0, -1, 32767).addGap(19, 19, 19)))));
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
/*  636 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jPanel6, -2, -1, -2).addComponent(this.jPanel7, -2, -1, -2)).addGap(26, 26, 26).addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel9).addComponent(this.jSpNBCassure, -2, 28, -2).addComponent(this.jLabel10).addComponent(this.jCBStabilite, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.jPanel1, -2, -1, -2).addGap(28, 28, 28)));
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
/*  654 */     this.jTabbedPane1.addTab("Général", this.jPanel3);
/*      */     
/*  656 */     this.jScrollPane1.setViewportView(this.jTACommentaire);
/*      */     
/*  658 */     this.jBtHsitorique.setText("Historique...");
/*  659 */     this.jBtHsitorique.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  661 */         FormeCardinalite2.this.jBtHsitoriqueActionPerformed(evt);
/*      */       }
/*      */       
/*  664 */     });
/*  665 */     GroupLayout jPanel4Layout = new GroupLayout(this.jPanel4);
/*  666 */     this.jPanel4.setLayout(jPanel4Layout);
/*  667 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 591, 32767).addComponent(this.jBtHsitorique)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  676 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 205, 32767).addGap(18, 18, 18).addComponent(this.jBtHsitorique).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  686 */     this.jTabbedPane1.addTab("Commentaire", this.jPanel4);
/*      */     
/*  688 */     this.jPanel5.addComponentListener(new java.awt.event.ComponentAdapter() {
/*      */       public void componentShown(java.awt.event.ComponentEvent evt) {
/*  690 */         FormeCardinalite2.this.jPanel5ComponentShown(evt);
/*      */       }
/*  692 */     });
/*  693 */     this.jPanel5.addFocusListener(new java.awt.event.FocusAdapter() {
/*      */       public void focusGained(java.awt.event.FocusEvent evt) {
/*  695 */         FormeCardinalite2.this.jPanel5FocusGained(evt);
/*      */       }
/*      */       
/*  698 */     });
/*  699 */     this.jPanelAprecu.setBackground(new Color(255, 255, 255));
/*  700 */     this.jPanelAprecu.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  702 */         FormeCardinalite2.this.jPanelAprecuMouseClicked(evt);
/*      */       }
/*      */       
/*  705 */     });
/*  706 */     GroupLayout jPanelAprecuLayout = new GroupLayout(this.jPanelAprecu);
/*  707 */     this.jPanelAprecu.setLayout(jPanelAprecuLayout);
/*  708 */     jPanelAprecuLayout.setHorizontalGroup(jPanelAprecuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 393, 32767));
/*      */     
/*      */ 
/*      */ 
/*  712 */     jPanelAprecuLayout.setVerticalGroup(jPanelAprecuLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 161, 32767));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  717 */     this.jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  718 */     this.jLabel14.setForeground(new Color(0, 0, 153));
/*  719 */     this.jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/oeil.png")));
/*  720 */     this.jLabel14.setText("Aperçu");
/*  721 */     this.jLabel14.setCursor(new java.awt.Cursor(12));
/*  722 */     this.jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  724 */         FormeCardinalite2.this.jLabel14MouseClicked(evt);
/*      */       }
/*      */       
/*  727 */     });
/*  728 */     this.jLabLien.setBackground(new Color(0, 0, 0));
/*  729 */     this.jLabLien.setHorizontalAlignment(0);
/*  730 */     this.jLabLien.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  731 */     this.jLabLien.setCursor(new java.awt.Cursor(12));
/*  732 */     this.jLabLien.setOpaque(true);
/*  733 */     this.jLabLien.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  735 */         FormeCardinalite2.this.jLabLienMouseClicked(evt);
/*      */       }
/*      */       
/*  738 */     });
/*  739 */     this.jLabel12.setHorizontalAlignment(0);
/*  740 */     this.jLabel12.setText("Lien");
/*      */     
/*  742 */     this.jLabel13.setHorizontalAlignment(0);
/*  743 */     this.jLabel13.setText("Nom");
/*      */     
/*  745 */     this.jLabel15.setHorizontalAlignment(0);
/*  746 */     this.jLabel15.setText("Cardinalité ");
/*      */     
/*  748 */     this.jLabCardinalite.setBackground(new Color(255, 51, 0));
/*  749 */     this.jLabCardinalite.setHorizontalAlignment(0);
/*  750 */     this.jLabCardinalite.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  751 */     this.jLabCardinalite.setCursor(new java.awt.Cursor(12));
/*  752 */     this.jLabCardinalite.setOpaque(true);
/*  753 */     this.jLabCardinalite.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  755 */         FormeCardinalite2.this.jLabCardinaliteMouseClicked(evt);
/*      */       }
/*      */       
/*  758 */     });
/*  759 */     this.jLabNom.setBackground(new Color(0, 0, 0));
/*  760 */     this.jLabNom.setHorizontalAlignment(0);
/*  761 */     this.jLabNom.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*  762 */     this.jLabNom.setCursor(new java.awt.Cursor(12));
/*  763 */     this.jLabNom.setOpaque(true);
/*  764 */     this.jLabNom.addMouseListener(new java.awt.event.MouseAdapter() {
/*      */       public void mouseClicked(MouseEvent evt) {
/*  766 */         FormeCardinalite2.this.jLabNomMouseClicked(evt);
/*      */       }
/*      */       
/*  769 */     });
/*  770 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  771 */     this.jPanel2.setLayout(jPanel2Layout);
/*  772 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addComponent(this.jLabel12).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, 32767).addComponent(this.jLabLien, -2, 67, -2)).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel15).addComponent(this.jLabel13)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabNom, -1, 63, 32767).addComponent(this.jLabCardinalite, -1, 63, 32767)))).addContainerGap()));
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
/*  791 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(11, 11, 11).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabLien, -1, 14, 32767).addComponent(this.jLabel12)).addGap(33, 33, 33).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabCardinalite, -1, 14, 32767).addComponent(this.jLabel15)).addGap(37, 37, 37).addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabNom, -1, 14, 32767).addComponent(this.jLabel13)).addContainerGap()));
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
/*  809 */     this.jCBTout.setText("Appliquer à tous les liens ");
/*      */     
/*  811 */     this.jCBDefaut.setText("Couleurs par défaut");
/*      */     
/*  813 */     GroupLayout jPanel5Layout = new GroupLayout(this.jPanel5);
/*  814 */     this.jPanel5.setLayout(jPanel5Layout);
/*  815 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jCBDefaut).addGap(286, 286, 286).addComponent(this.jCBTout).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addComponent(this.jLabel14).addGap(122, 122, 122)).addGroup(jPanel5Layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 51, 32767).addComponent(this.jPanelAprecu, -2, -1, -2).addContainerGap()))));
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
/*  834 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanelAprecu, -2, -1, -2).addGap(11, 11, 11).addComponent(this.jLabel14)).addGroup(jPanel5Layout.createSequentialGroup().addGap(26, 26, 26).addComponent(this.jPanel2, -2, -1, -2))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 36, 32767).addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jCBTout).addComponent(this.jCBDefaut)).addGap(10, 10, 10)));
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
/*  853 */     this.jTabbedPane1.addTab("Affichage", this.jPanel5);
/*      */     
/*  855 */     this.jBtOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/OK.png")));
/*  856 */     this.jBtOK.setText("Valider");
/*  857 */     this.jBtOK.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  859 */         FormeCardinalite2.this.jBtOKActionPerformed(evt);
/*      */       }
/*      */       
/*  862 */     });
/*  863 */     this.jBtAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Cancel.png")));
/*  864 */     this.jBtAnnuler.setText("Annuler");
/*  865 */     this.jBtAnnuler.addActionListener(new java.awt.event.ActionListener() {
/*      */       public void actionPerformed(ActionEvent evt) {
/*  867 */         FormeCardinalite2.this.jBtAnnulerActionPerformed(evt);
/*      */       }
/*      */       
/*  870 */     });
/*  871 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  872 */     getContentPane().setLayout(layout);
/*  873 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jTFNom, -2, 219, -2).addGap(18, 18, 18).addComponent(this.jLabel2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jTFCode, -1, 308, 32767)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.jBtAnnuler, -2, 98, -2).addGap(18, 18, 18).addComponent(this.jBtOK, -2, 122, -2)).addComponent(this.jTabbedPane1, -2, 616, -2))).addContainerGap()));
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
/*  894 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel1).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jTFNom, -2, -1, -2).addComponent(this.jLabel2).addComponent(this.jTFCode, -2, -1, -2))).addGap(18, 18, 18).addComponent(this.jTabbedPane1, -2, 296, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jBtOK).addComponent(this.jBtAnnuler)).addContainerGap(-1, 32767)));
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
/*  913 */     pack();
/*      */   }
/*      */   
/*      */   private void jCBCardinaliteItemStateChanged(java.awt.event.ItemEvent evt) {
/*  917 */     this.jTFMax.setEnabled(false);
/*  918 */     this.jTFMin.setEnabled(false);
/*  919 */     if (!this.jCBCardinalite.getSelectedItem().toString().equals("1,1")) {
/*  920 */       this.jCBLienRelatif.setEnabled(false);
/*      */     } else {
/*  922 */       this.jCBLienRelatif.setEnabled(true);
/*      */     }
/*      */     
/*  925 */     if (this.jCBCardinalite.getSelectedIndex() == 0) {
/*  926 */       this.jTFMax.setEnabled(true);
/*  927 */       this.jTFMin.setEnabled(true);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void jCBCardinaliteActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jBtOKActionPerformed(ActionEvent evt)
/*      */   {
/*  936 */     if ((this.jCBCardinalite.getSelectedIndex() == 0) && 
/*  937 */       (!isCorrectCardinalite())) {
/*  938 */       javax.swing.JOptionPane.showMessageDialog(this.frm, "- La valeur 'Min' doit être supérieure ou égale à 0\n- La valeur  'Max' doit être supérieure à la valeur Min ou égale à 'n'", "Erreur cardinalité", 0);
/*  939 */       return;
/*      */     }
/*      */     
/*  942 */     this.lien.setNom(this.jTFNom.getText().trim());
/*  943 */     this.lien.setCode(this.jTFCode.getText().trim());
/*  944 */     this.lien.setCommentaire(this.jTACommentaire.getText());
/*  945 */     this.lien.setCardinalite(getCardinalite());
/*  946 */     this.lien.getCardinalites().setNom(this.lien.getCardinalite());
/*      */     
/*  948 */     this.lien.getCardinalites().setMin(this.jTFMin.getText());
/*  949 */     this.lien.getCardinalites().setMax(this.jTFMax.getText().toLowerCase());
/*      */     
/*  951 */     this.lien.setFleche(this.jCBFleche.isSelected());
/*  952 */     this.lien.setRelatif(this.jCBLienRelatif.isEnabled() ? this.jCBLienRelatif.isSelected() : false);
/*  953 */     this.lien.setClLien2(this.jLabLien.getBackground());
/*  954 */     this.lien.setClLienNom2(this.jLabNom.getBackground());
/*  955 */     this.lien.setClLienText2(this.jLabCardinalite.getBackground());
/*  956 */     this.lien.ajouterModification();
/*      */     
/*  958 */     if (this.jCBDefaut.isSelected()) {
/*  959 */       appliquerCoulerDefaut();
/*      */     }
/*  961 */     if (this.jCBTout.isSelected()) {
/*  962 */       appliquerCoulerToutLien();
/*      */     }
/*  964 */     if (this.jCBHorloge.isSelected()) {
/*  965 */       this.lien.setHistorisation("H");
/*      */     } else {
/*  967 */       this.lien.setHistorisation("");
/*      */     }
/*      */     
/*  970 */     if (!ihm.Principale.isActiverJMerise()) { verifierActivation();
/*      */     }
/*  972 */     if (!this.lien.isRelatif()) {
/*  973 */       this.lien.getCardinalites().setStabilite(getStabilite());
/*      */     } else {
/*  975 */       this.lien.getCardinalites().setStabilite("");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  980 */     modifierPointDeCassure();
/*  981 */     modifierSQLDispatchKey();
/*      */     
/*  983 */     dispose();
/*      */   }
/*      */   
/*      */   private void jBtAnnulerActionPerformed(ActionEvent evt)
/*      */   {
/*  988 */     dispose();
/*      */   }
/*      */   
/*      */   private void jLabLienMouseClicked(MouseEvent evt) {
/*  992 */     this.jLabLien.setBackground(choixDeCouleur(this.jLabLien.getBackground(), "Couleur Lien"));
/*  993 */     dessinerApercu();
/*      */   }
/*      */   
/*      */ 
/*      */   private void jLabel14MouseClicked(MouseEvent evt)
/*      */   {
/*  999 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabCardinaliteMouseClicked(MouseEvent evt)
/*      */   {
/* 1004 */     this.jLabCardinalite.setBackground(choixDeCouleur(this.jLabCardinalite.getBackground(), "Couleur Cardinalité"));
/* 1005 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jLabNomMouseClicked(MouseEvent evt)
/*      */   {
/* 1010 */     this.jLabNom.setBackground(choixDeCouleur(this.jLabNom.getBackground(), "Couleur Nom du Lien"));
/* 1011 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jPanelAprecuMouseClicked(MouseEvent evt) {
/* 1015 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private void jPanel5ComponentShown(java.awt.event.ComponentEvent evt) {
/* 1019 */     dessinerApercu();
/*      */   }
/*      */   
/*      */   private JPanel jPanel7;
/*      */   private JPanel jPanelAprecu;
/*      */   private javax.swing.JScrollPane jScrollPane1;
/*      */   private javax.swing.JSpinner jSpNBCassure;
/*      */   private javax.swing.JTextPane jTACommentaire;
/*      */   private JTextField jTFCode;
/*      */   
/*      */   private void jPanel5FocusGained(java.awt.event.FocusEvent evt) {}
/*      */   
/*      */   private void jCBHorlogeActionPerformed(ActionEvent evt) {}
/*      */   
/*      */   private void jTabbedPane1MouseMoved(MouseEvent evt) {}
/*      */   
/* 1035 */   private void jBtHsitoriqueActionPerformed(ActionEvent evt) { new FormeHistorique(this.frm, true, this.lien.getHistorique(), "", "").setVisible(true); }
/*      */   
/*      */   private JTextField jTFMax;
/*      */   private JTextField jTFMin;
/*      */   private JTextField jTFNom;
/*      */   private JTextField jTFNomEntite;
/*      */   private JTextField jTFNomRelation;
/*      */   private javax.swing.JTabbedPane jTabbedPane1;
/*      */   private void formMouseClicked(MouseEvent evt) {}
/*      */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes2\FormeCardinalite2.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */