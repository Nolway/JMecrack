/*     */ package MySqlEditor;
/*     */ 
/*     */ import MyExplorer.ConsolePane;
/*     */ import Outil.Connexion;
/*     */ import Output.SQLDerby;
/*     */ import Output.SQLMySQL;
/*     */ import Output.SQLOracle;
/*     */ import Output.SQLOutil;
/*     */ import Output.SQLPostGre;
/*     */ import Output.SQLServer;
/*     */ import ihm.FormeInterneMCD;
/*     */ import ihm.FormeInterneMLD;
/*     */ import ihm.FormeInterneSQL;
/*     */ import ihm.Principale;
/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Color;
/*     */ import java.awt.MouseInfo;
/*     */ import java.awt.PointerInfo;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.awt.event.MouseEvent;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPopupMenu;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JSeparator;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.JTextPane;
/*     */ import javax.swing.JToolBar;
/*     */ import javax.swing.JToolBar.Separator;
/*     */ import javax.swing.filechooser.FileNameExtensionFilter;
/*     */ import javax.swing.text.AttributeSet;
/*     */ import javax.swing.text.BadLocationException;
/*     */ import javax.swing.text.SimpleAttributeSet;
/*     */ import javax.swing.text.StyleContext;
/*     */ import javax.swing.text.TabSet;
/*     */ import javax.swing.text.TabStop;
/*     */ import mythread.ThreadScriptBDD;
/*     */ 
/*     */ public class JTextEditorPan extends javax.swing.JPanel
/*     */ {
/*     */   private MySqlTextPane pane;
/*     */   private JScrollPane scrollPane;
/*     */   private String nomFic;
/*     */   private JToolBar toolBar;
/*     */   private JButton btSave;
/*     */   private JButton btSaveAs;
/*     */   private JButton btClose;
/*     */   private JButton btCopy;
/*     */   private JButton btCut;
/*     */   private JButton btFind;
/*     */   private JButton btPaste;
/*     */   private JButton btSQL;
/*     */   private JButton btRegenererScript;
/*     */   private JPopupMenu jPopupMenu;
/*     */   private JMenuItem miSave;
/*     */   private JMenuItem miSaveAs;
/*     */   private JMenuItem miClose;
/*     */   private JMenuItem miCopy;
/*     */   private JMenuItem miCut;
/*     */   private JMenuItem miPaste;
/*     */   private StatusBar statusBar;
/*     */   private Principale frmPrincipale;
/*     */   private String typeSql;
/*     */   
/*     */   public JTextEditorPan()
/*     */   {
/*  82 */     this.nomFic = "";
/*     */     
/*  84 */     this.pane = new MySqlTextPane();
/*  85 */     this.scrollPane = new JScrollPane();
/*  86 */     this.scrollPane.setViewportView(this.pane);
/*     */     
/*  88 */     this.toolBar = new JToolBar();
/*  89 */     this.btSave = new JButton();
/*  90 */     this.btSaveAs = new JButton();
/*     */     
/*  92 */     this.btCopy = new JButton();
/*  93 */     this.btCut = new JButton();
/*  94 */     this.btFind = new JButton();
/*  95 */     this.btPaste = new JButton();
/*  96 */     this.btSQL = new JButton();
/*  97 */     this.btRegenererScript = new JButton("");
/*     */     
/*  99 */     this.miSave = new JMenuItem("Enregistrer  CTRL S");
/* 100 */     this.miSaveAs = new JMenuItem("Enregistrer sous");
/*     */     
/* 102 */     this.miCopy = new JMenuItem("Copier      CTRL C");
/* 103 */     this.miCut = new JMenuItem("Couper      CTRL X");
/* 104 */     this.miPaste = new JMenuItem("Coller      CTRL V");
/* 105 */     this.jPopupMenu = new JPopupMenu();
/*     */     
/* 107 */     this.statusBar = new StatusBar();
/* 108 */     this.statusBar.setVisible(false);
/*     */     
/*     */ 
/* 111 */     JSeparator jseparMenuPop = new JSeparator();
/*     */     
/*     */ 
/* 114 */     jseparMenuPop.setOrientation(0);
/*     */     
/* 116 */     this.btSave.setFocusable(false);
/* 117 */     this.btSaveAs.setFocusable(false);
/*     */     
/* 119 */     this.btCopy.setFocusable(false);
/* 120 */     this.btCut.setFocusable(false);
/* 121 */     this.btFind.setFocusable(false);
/* 122 */     this.btPaste.setFocusable(false);
/* 123 */     this.btSQL.setFocusable(false);
/* 124 */     this.btRegenererScript.setFocusable(false);
/*     */     
/* 126 */     this.btSave.setIcon(new ImageIcon(getClass().getResource("save.png")));
/* 127 */     this.btSaveAs.setIcon(new ImageIcon(getClass().getResource("saveas.png")));
/*     */     
/* 129 */     this.btCut.setIcon(new ImageIcon(getClass().getResource("cut.png")));
/* 130 */     this.btCopy.setIcon(new ImageIcon(getClass().getResource("copy.png")));
/* 131 */     this.btFind.setIcon(new ImageIcon(getClass().getResource("goto.png")));
/* 132 */     this.btPaste.setIcon(new ImageIcon(getClass().getResource("paste.png")));
/* 133 */     this.btSQL.setIcon(new ImageIcon(getClass().getResource("newTable16.png")));
/* 134 */     this.btRegenererScript.setIcon(new ImageIcon(getClass().getResource("sql16.png")));
/*     */     
/* 136 */     this.btSave.setToolTipText("Enregistrer");
/* 137 */     this.btSaveAs.setToolTipText("Enregistrer sous");
/*     */     
/* 139 */     this.btCut.setToolTipText("Couper");
/* 140 */     this.btCopy.setToolTipText("Copier");
/* 141 */     this.btFind.setToolTipText("Chercher");
/* 142 */     this.btPaste.setToolTipText("Coller");
/* 143 */     this.btSQL.setToolTipText("Exécuter le script sql");
/* 144 */     this.btRegenererScript.setToolTipText("Regénérer le script SQL");
/*     */     
/* 146 */     this.btCut.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 148 */         JTextEditorPan.this.cut();
/*     */       }
/*     */       
/* 151 */     });
/* 152 */     this.btCopy.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 154 */         JTextEditorPan.this.copy();
/*     */       }
/*     */       
/* 157 */     });
/* 158 */     this.btPaste.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 160 */         JTextEditorPan.this.paste();
/*     */       }
/*     */       
/* 163 */     });
/* 164 */     this.btSave.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 166 */         if (JTextEditorPan.this.nomFic.length() == 0) {
/* 167 */           JFileChooser fileCh = new JFileChooser();
/* 168 */           FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichier Sql", new String[] { "sql" });
/* 169 */           fileCh.setFileFilter(filtre);
/* 170 */           if (fileCh.showSaveDialog(JTextEditorPan.this.getFrmPrincipale()) == 0) {
/* 171 */             File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/* 172 */             if (!fil.exists()) {
/* 173 */               String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/* 174 */               nomFile = JTextEditorPan.this.getExtention(nomFile);
/*     */               try
/*     */               {
/* 177 */                 PrintWriter out = new PrintWriter(nomFile);
/* 178 */                 out.write(JTextEditorPan.this.pane.getText());
/* 179 */                 out.close();
/*     */               } catch (FileNotFoundException ex) {
/* 181 */                 Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/*     */               
/* 184 */               JTextEditorPan.this.nomFic = nomFile;
/*     */ 
/*     */             }
/* 187 */             else if (JOptionPane.showConfirmDialog(JTextEditorPan.this.getFrmPrincipale(), "Le fichier existe.\n Voulez vous le remplacer ?", "Modification ", 0) == 0)
/*     */             {
/*     */               try {
/* 190 */                 PrintWriter out = new PrintWriter(fileCh.getSelectedFile().getAbsolutePath());
/* 191 */                 out.write(JTextEditorPan.this.pane.getText());
/* 192 */                 out.close();
/*     */               } catch (FileNotFoundException ex) {
/* 194 */                 Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 196 */               JTextEditorPan.this.nomFic = fileCh.getSelectedFile().getAbsolutePath();
/*     */             }
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/*     */           try {
/* 203 */             PrintWriter out = new PrintWriter(JTextEditorPan.this.nomFic);
/* 204 */             out.write(JTextEditorPan.this.pane.getText());
/* 205 */             out.close();
/*     */           } catch (FileNotFoundException ex) {
/* 207 */             Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */           }
/*     */           
/*     */         }
/*     */       }
/* 212 */     });
/* 213 */     this.btSaveAs.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 215 */         JFileChooser fileCh = new JFileChooser();
/* 216 */         FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichier Sql", new String[] { "sql" });
/* 217 */         fileCh.setFileFilter(filtre);
/* 218 */         if (fileCh.showSaveDialog(JTextEditorPan.this.getFrmPrincipale()) == 0) {
/* 219 */           File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/* 220 */           if (!fil.exists()) {
/* 221 */             String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/* 222 */             nomFile = JTextEditorPan.this.getExtention(nomFile);
/*     */             try
/*     */             {
/* 225 */               PrintWriter out = new PrintWriter(nomFile);
/* 226 */               out.write(JTextEditorPan.this.pane.getText());
/* 227 */               out.close();
/*     */             } catch (FileNotFoundException ex) {
/* 229 */               Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */             }
/*     */             
/* 232 */             JTextEditorPan.this.nomFic = nomFile;
/*     */ 
/*     */           }
/* 235 */           else if (JOptionPane.showConfirmDialog(JTextEditorPan.this.getFrmPrincipale(), "Le fichier existe.\n Voulez vous le remplacer ?", "Modification ", 0) == 0)
/*     */           {
/*     */             try {
/* 238 */               PrintWriter out = new PrintWriter(fileCh.getSelectedFile().getAbsolutePath());
/* 239 */               out.write(JTextEditorPan.this.pane.getText());
/* 240 */               out.close();
/*     */             } catch (FileNotFoundException ex) {
/* 242 */               Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */             }
/* 244 */             JTextEditorPan.this.nomFic = fileCh.getSelectedFile().getAbsolutePath();
/*     */           }
/*     */           
/*     */         }
/*     */         
/*     */       }
/* 250 */     });
/* 251 */     this.btFind.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/* 254 */         String message = "Recherche : ";
/* 255 */         String reponse = JOptionPane.showInputDialog(JTextEditorPan.this, message, "Recherche", 3);
/* 256 */         if ((reponse != null) && (reponse.trim().length() > 0)) {
/* 257 */           JTextEditorPan.this.pane.words[5] = reponse;
/* 258 */           JTextEditorPan.this.statusBar.getFindField().setText(reponse);
/* 259 */           int position = JTextEditorPan.this.pane.findWord(reponse);
/* 260 */           if (position != -1) {
/* 261 */             JTextEditorPan.this.pane.setCaretPosition(position);
/* 262 */             JTextEditorPan.this.pane.requestFocus();
/*     */           }
/*     */           
/*     */         }
/*     */       }
/* 267 */     });
/* 268 */     this.btSQL.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 270 */         if (!JTextEditorPan.this.getFrmPrincipale().getFormeMCD().getConnexion().typeSql.equals(JTextEditorPan.this.getFrmPrincipale().getFormeSQL().getPanelsql().getTypeSql())) {
/* 271 */           JTextEditorPan.this.getFrmPrincipale().getFormeMCD().getConnexion().conn = null;
/*     */         }
/* 273 */         if (JTextEditorPan.this.getFrmPrincipale().getFormeMCD().getConnexion().conn != null) {
/*     */           try {
/* 275 */             if (!JTextEditorPan.this.getFrmPrincipale().getFormeMCD().getConnexion().conn.isClosed()) {
/* 276 */               ThreadScriptBDD scri = new ThreadScriptBDD(JTextEditorPan.this.getFrmPrincipale());
/* 277 */               scri.execute();
/*     */             } else {
/* 279 */               JOptionPane.showMessageDialog(JTextEditorPan.this.getFrmPrincipale(), "MESSAGE : Veuillez vous connectez avant d'exécuter le script  !! ");
/*     */             }
/*     */           }
/*     */           catch (SQLException ex) {
/* 283 */             Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */           }
/*     */         } else {
/* 286 */           JOptionPane.showMessageDialog(JTextEditorPan.this.getFrmPrincipale(), "MESSAGE : Veuillez vous connecter avant d'exécuter le script  !! ");
/*     */         }
/*     */         
/*     */       }
/*     */       
/* 291 */     });
/* 292 */     this.btRegenererScript.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/* 295 */         JTextEditorPan.this.genererScript();
/*     */       }
/*     */       
/* 298 */     });
/* 299 */     this.toolBar.add(this.btSave);
/* 300 */     this.toolBar.add(this.btSaveAs);
/*     */     
/* 302 */     this.toolBar.add(this.btCut);
/* 303 */     this.toolBar.add(this.btCopy);
/* 304 */     this.toolBar.add(this.btPaste);
/* 305 */     this.toolBar.add(this.btFind);
/* 306 */     this.toolBar.add(this.btSQL);
/* 307 */     this.toolBar.add(new JToolBar.Separator());
/* 308 */     this.toolBar.add(this.btRegenererScript);
/*     */     
/* 310 */     this.miSave.setIcon(new ImageIcon(getClass().getResource("save.png")));
/* 311 */     this.miSaveAs.setIcon(new ImageIcon(getClass().getResource("saveas.png")));
/*     */     
/* 313 */     this.miCut.setIcon(new ImageIcon(getClass().getResource("cut.png")));
/* 314 */     this.miCopy.setIcon(new ImageIcon(getClass().getResource("copy.png")));
/* 315 */     this.miPaste.setIcon(new ImageIcon(getClass().getResource("paste.png")));
/*     */     
/* 317 */     this.miCut.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 319 */         JTextEditorPan.this.cut();
/*     */       }
/*     */       
/* 322 */     });
/* 323 */     this.miCopy.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 325 */         JTextEditorPan.this.copy();
/*     */       }
/*     */       
/* 328 */     });
/* 329 */     this.miPaste.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 331 */         JTextEditorPan.this.paste();
/*     */       }
/*     */       
/* 334 */     });
/* 335 */     this.miSave.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 337 */         if (JTextEditorPan.this.nomFic.length() == 0) {
/* 338 */           JFileChooser fileCh = new JFileChooser();
/* 339 */           FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichier Sql", new String[] { "sql" });
/* 340 */           fileCh.setFileFilter(filtre);
/* 341 */           if (fileCh.showSaveDialog(JTextEditorPan.this.getFrmPrincipale()) == 0) {
/* 342 */             File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/* 343 */             if (!fil.exists()) {
/* 344 */               String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/* 345 */               nomFile = JTextEditorPan.this.getExtention(nomFile);
/*     */               try
/*     */               {
/* 348 */                 PrintWriter out = new PrintWriter(nomFile);
/* 349 */                 out.write(JTextEditorPan.this.pane.getText());
/* 350 */                 out.close();
/*     */               } catch (FileNotFoundException ex) {
/* 352 */                 Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/*     */               
/* 355 */               JTextEditorPan.this.nomFic = nomFile;
/*     */ 
/*     */             }
/* 358 */             else if (JOptionPane.showConfirmDialog(JTextEditorPan.this.getFrmPrincipale(), "Le fichier existe.\n Voulez vous le remplacer ?", "Modification ", 0) == 0)
/*     */             {
/*     */               try {
/* 361 */                 PrintWriter out = new PrintWriter(fileCh.getSelectedFile().getAbsolutePath());
/* 362 */                 out.write(JTextEditorPan.this.pane.getText());
/* 363 */                 out.close();
/*     */               } catch (FileNotFoundException ex) {
/* 365 */                 Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 367 */               JTextEditorPan.this.nomFic = fileCh.getSelectedFile().getAbsolutePath();
/*     */             }
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/*     */           try {
/* 374 */             PrintWriter out = new PrintWriter(JTextEditorPan.this.nomFic);
/* 375 */             out.write(JTextEditorPan.this.pane.getText());
/* 376 */             out.close();
/*     */           } catch (FileNotFoundException ex) {
/* 378 */             Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */           }
/*     */           
/*     */         }
/*     */       }
/* 383 */     });
/* 384 */     this.miSaveAs.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 386 */         if (JTextEditorPan.this.nomFic.length() == 0) {
/* 387 */           JFileChooser fileCh = new JFileChooser();
/* 388 */           FileNameExtensionFilter filtre = new FileNameExtensionFilter("Fichier sql", new String[] { "sql" });
/* 389 */           fileCh.setFileFilter(filtre);
/* 390 */           if (fileCh.showSaveDialog(JTextEditorPan.this.getFrmPrincipale()) == 0) {
/* 391 */             File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/* 392 */             if (!fil.exists()) {
/* 393 */               String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/* 394 */               nomFile = JTextEditorPan.this.getExtention(nomFile);
/*     */               try
/*     */               {
/* 397 */                 PrintWriter out = new PrintWriter(nomFile);
/* 398 */                 out.write(JTextEditorPan.this.pane.getText());
/* 399 */                 out.close();
/*     */               } catch (FileNotFoundException ex) {
/* 401 */                 Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/*     */               
/* 404 */               JTextEditorPan.this.nomFic = nomFile;
/*     */ 
/*     */             }
/* 407 */             else if (JOptionPane.showConfirmDialog(JTextEditorPan.this.getFrmPrincipale(), "Le fichier existe.\n Voulez vous le remplacer ?", "Modification ", 0) == 0)
/*     */             {
/*     */               try {
/* 410 */                 PrintWriter out = new PrintWriter(fileCh.getSelectedFile().getAbsolutePath());
/* 411 */                 out.write(JTextEditorPan.this.pane.getText());
/* 412 */                 out.close();
/*     */               } catch (FileNotFoundException ex) {
/* 414 */                 Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 416 */               JTextEditorPan.this.nomFic = fileCh.getSelectedFile().getAbsolutePath();
/*     */             }
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/*     */           try {
/* 423 */             PrintWriter out = new PrintWriter(JTextEditorPan.this.nomFic);
/* 424 */             out.write(JTextEditorPan.this.pane.getText());
/* 425 */             out.close();
/*     */           } catch (FileNotFoundException ex) {
/* 427 */             Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */           }
/*     */           
/*     */         }
/*     */       }
/* 432 */     });
/* 433 */     this.jPopupMenu.add(this.miCut);
/* 434 */     this.jPopupMenu.add(this.miCopy);
/* 435 */     this.jPopupMenu.add(this.miPaste);
/* 436 */     this.jPopupMenu.add(jseparMenuPop);
/* 437 */     this.jPopupMenu.add(this.miSave);
/* 438 */     this.jPopupMenu.add(this.miSaveAs);
/*     */     
/*     */ 
/* 441 */     this.pane.addMouseListener(new java.awt.event.MouseListener() {
/*     */       public void mousePressed(MouseEvent e) {
/* 443 */         if (e.getButton() == 3) {
/* 444 */           JTextEditorPan.this.jPopupMenu.setLocation(MouseInfo.getPointerInfo().getLocation());
/* 445 */           JTextEditorPan.this.jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */       public void mouseClicked(MouseEvent arg0) {}
/*     */       
/*     */ 
/*     */ 
/*     */       public void mouseEntered(MouseEvent e) {}
/*     */       
/*     */ 
/*     */ 
/*     */       public void mouseExited(MouseEvent e) {}
/*     */       
/*     */ 
/*     */       public void mouseReleased(MouseEvent e) {}
/* 463 */     });
/* 464 */     this.statusBar.getLabClose().addMouseListener(new java.awt.event.MouseAdapter()
/*     */     {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 467 */         JTextEditorPan.this.statusBar.setVisible(false);
/* 468 */         JTextEditorPan.this.pane.requestFocus();
/*     */       }
/*     */       
/* 471 */     });
/* 472 */     this.statusBar.getFindField().addKeyListener(new KeyAdapter()
/*     */     {
/*     */       public void keyReleased(KeyEvent evt) {
/* 475 */         int position = JTextEditorPan.this.pane.findWord(JTextEditorPan.this.statusBar.getFindField().getText().trim());
/* 476 */         if (position == -1) {
/* 477 */           JTextEditorPan.this.statusBar.getFindField().setBackground(Color.red);
/*     */         } else {
/* 479 */           JTextEditorPan.this.statusBar.getFindField().setBackground(Color.white);
/* 480 */           JTextEditorPan.this.pane.setCaretPosition(position);
/* 481 */           JTextEditorPan.this.pane.requestFocus();
/* 482 */           JTextEditorPan.this.statusBar.getFindField().requestFocus();
/*     */         }
/*     */         
/* 485 */         JTextEditorPan.this.pane.words[5] = (JTextEditorPan.this.statusBar.getFindField().getText().trim().length() == 0 ? "." : JTextEditorPan.this.statusBar.getFindField().getText().trim());
/*     */         try {
/* 487 */           JTextEditorPan.this.pane.colorise();
/*     */         } catch (BadLocationException ex) {
/* 489 */           Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */         }
/*     */         
/*     */       }
/* 493 */     });
/* 494 */     this.pane.addKeyListener(new KeyAdapter()
/*     */     {
/*     */       public void keyPressed(KeyEvent evt) {
/* 497 */         if (evt.getKeyCode() == 114) {
/* 498 */           if (!JTextEditorPan.this.statusBar.isVisible()) JTextEditorPan.this.statusBar.setVisible(true);
/* 499 */           JTextEditorPan.this.statusBar.getFindField().requestFocus();
/*     */         }
/*     */         
/*     */       }
/* 503 */     });
/* 504 */     setLayout(new BorderLayout());
/* 505 */     add(this.scrollPane, "Center");
/* 506 */     add(this.toolBar, "North");
/* 507 */     add(this.statusBar, "South");
/*     */   }
/*     */   
/*     */ 
/*     */   private void copy()
/*     */   {
/* 513 */     this.pane.copy();
/*     */   }
/*     */   
/*     */   private void cut() {
/* 517 */     this.pane.cut();
/*     */   }
/*     */   
/*     */   private void paste() {
/* 521 */     this.pane.paste();
/*     */   }
/*     */   
/*     */   public MySqlTextPane getPane()
/*     */   {
/* 526 */     return this.pane;
/*     */   }
/*     */   
/*     */   public JMenuItem getMiSave() {
/* 530 */     return this.miSave;
/*     */   }
/*     */   
/*     */   public JButton getBtSave() {
/* 534 */     return this.btSave;
/*     */   }
/*     */   
/*     */   public JMenuItem getMiClose() {
/* 538 */     return this.miClose;
/*     */   }
/*     */   
/*     */   public JButton getBtClose() {
/* 542 */     return this.btClose;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Principale getFrmPrincipale()
/*     */   {
/* 550 */     return this.frmPrincipale;
/*     */   }
/*     */   
/*     */   public void setFrmPrincipale(Principale frm) {
/* 554 */     this.frmPrincipale = frm;
/*     */   }
/*     */   
/*     */   private String getExtention(String nom) {
/* 558 */     if (!nom.trim().endsWith(".sql")) {
/* 559 */       nom = nom + ".sql";
/*     */     }
/* 561 */     return nom;
/*     */   }
/*     */   
/*     */   public String getTypeSql() {
/* 565 */     return this.typeSql;
/*     */   }
/*     */   
/*     */   public void setTypeSql(String typeSql) {
/* 569 */     this.typeSql = typeSql;
/*     */   }
/*     */   
/*     */   public static void setTabSize(JTextPane pane, int size) {
/* 573 */     String tab = "";
/* 574 */     for (int i = 0; i < size; i++) {
/* 575 */       tab = tab + " ";
/*     */     }
/* 577 */     float f = pane.getFontMetrics(pane.getFont()).stringWidth(tab);
/* 578 */     TabStop[] tabs = new TabStop['C'];
/*     */     
/* 580 */     for (int i = 0; i < tabs.length; i++) {
/* 581 */       tabs[i] = new TabStop(f * (i + 1), 0, 0);
/*     */     }
/*     */     
/*     */ 
/* 585 */     TabSet tabset = new TabSet(tabs);
/* 586 */     StyleContext sc = StyleContext.getDefaultStyleContext();
/* 587 */     AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, javax.swing.text.StyleConstants.TabSet, tabset);
/*     */     
/* 589 */     pane.setParagraphAttributes(aset, false);
/*     */   }
/*     */   
/*     */   private void genererScript()
/*     */   {
/* 594 */     String rep = verificationAdaptation.VerificationMLD.verifierMLD(this.frmPrincipale.getFormeMLD().getPageMld(), this.frmPrincipale.getFormeMCD().getPage().getListeDomaine());
/* 595 */     if (rep.length() > 0) {
/* 596 */       this.frmPrincipale.getConsole().getRapport().setBackground(Color.WHITE);
/* 597 */       this.frmPrincipale.getConsole().getRapport().setText("ERREUR : Le MLD contient des erreurs");
/* 598 */       this.frmPrincipale.getConsole().getRapport().append(rep);
/* 599 */       JOptionPane.showConfirmDialog(this.frmPrincipale.getFormeMLD().getPageMld(), "Erreur : Le MLD contient certaines erreurs !!! \nVoir messages dans console !", "Vérification du MCD ", -1, 0);
/* 600 */       return;
/*     */     }
/* 602 */     this.frmPrincipale.getConsole().getRapport().setText("");
/*     */     
/*     */ 
/* 605 */     if (this.typeSql.equals("")) {
/* 606 */       this.frmPrincipale.getFormeSQL().getPanelsql().getPane().setText(SQLMySQL.getScript(this.frmPrincipale.getFormeMCD().getPage(), this.frmPrincipale.getFormeMLD().getPageMld()));
/* 607 */       this.frmPrincipale.getFormeSQL().getPanelsql().setTypeSql(SQLOutil.SQLMYSQL);
/*     */     }
/* 609 */     if (this.typeSql.equals(SQLOutil.SQLACCESS)) {
/* 610 */       this.frmPrincipale.getFormeSQL().getPanelsql().getPane().setText(Output.SQLAccess.getScript(this.frmPrincipale.getFormeMLD().getPageMld(), this.frmPrincipale.getFormeMCD().getPage()));
/*     */     }
/*     */     
/* 613 */     if (this.typeSql.equals(SQLOutil.SQLDERBY)) {
/* 614 */       this.frmPrincipale.getFormeSQL().getPanelsql().getPane().setText(SQLDerby.getScript(this.frmPrincipale.getFormeMCD().getPage(), this.frmPrincipale.getFormeMLD().getPageMld()));
/*     */     }
/*     */     
/* 617 */     if (this.typeSql.equals(SQLOutil.SQLFIREBIRD)) {
/* 618 */       this.frmPrincipale.getFormeSQL().getPanelsql().getPane().setText(Output.SQLFirebird.getScript(this.frmPrincipale.getFormeMCD().getPage(), this.frmPrincipale.getFormeMLD().getPageMld()));
/*     */     }
/*     */     
/* 621 */     if (this.typeSql.equals(SQLOutil.SQLITE)) {
/* 622 */       this.frmPrincipale.getFormeSQL().getPanelsql().getPane().setText(Output.SQLite.getScript(this.frmPrincipale.getFormeMCD().getPage(), this.frmPrincipale.getFormeMLD().getPageMld()));
/*     */     }
/*     */     
/* 625 */     if (this.typeSql.equals(SQLOutil.SQLMYSQL)) {
/* 626 */       this.frmPrincipale.getFormeSQL().getPanelsql().getPane().setText(SQLMySQL.getScript(this.frmPrincipale.getFormeMCD().getPage(), this.frmPrincipale.getFormeMLD().getPageMld()));
/*     */     }
/*     */     
/* 629 */     if (this.typeSql.equals(SQLOutil.SQLPOSTGRE)) {
/* 630 */       this.frmPrincipale.getFormeSQL().getPanelsql().getPane().setText(SQLPostGre.getScript(this.frmPrincipale.getFormeMLD().getPageMld(), this.frmPrincipale.getFormeMCD().getPage()));
/*     */     }
/*     */     
/*     */ 
/* 634 */     if (this.typeSql.equals(SQLOutil.SQLSERVER)) {
/* 635 */       this.frmPrincipale.getFormeSQL().getPanelsql().getPane().setText(SQLServer.getScript(this.frmPrincipale.getFormeMLD().getPageMld(), this.frmPrincipale.getFormeMCD().getPage()));
/*     */     }
/*     */     
/*     */ 
/* 639 */     if (this.typeSql.equals(SQLOutil.SQLORACLE)) {
/* 640 */       this.frmPrincipale.getFormeSQL().getPanelsql().getPane().setText(SQLOracle.getScript(this.frmPrincipale.getFormeMCD().getPage(), this.frmPrincipale.getFormeMLD().getPageMld()));
/*     */     }
/*     */     
/*     */ 
/* 644 */     if (this.typeSql.equals(SQLOutil.HSQLDB)) {
/* 645 */       this.frmPrincipale.getFormeSQL().getPanelsql().getPane().setText(Output.SQLHsqldb.getScript(this.frmPrincipale.getFormeMCD().getPage(), this.frmPrincipale.getFormeMLD().getPageMld()));
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MySqlEditor\JTextEditorPan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */