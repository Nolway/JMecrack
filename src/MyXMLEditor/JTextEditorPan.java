/*     */ package MyXMLEditor;
/*     */ 
/*     */ import Output.DTDScript;
/*     */ import ihm.FormeInterneMLD;
/*     */ import ihm.FormeInterneXML;
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
/*     */ import javax.swing.JTextField;
/*     */ import javax.swing.JToolBar;
/*     */ import javax.swing.filechooser.FileNameExtensionFilter;
/*     */ import javax.swing.text.BadLocationException;
/*     */ import mythread.ThreadGenererXML;
/*     */ 
/*     */ public class JTextEditorPan extends javax.swing.JPanel
/*     */ {
/*     */   private MyXMLTextPane pane;
/*     */   private JScrollPane scrollPane;
/*     */   private String nomFic;
/*     */   private String cheminFic;
/*  42 */   private String typeDoc = "DTD";
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
/*     */   private JToolBar toolBar;
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
/*     */   private JButton btSave;
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
/*     */   private JButton btSaveAs;
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
/*     */   private JButton btClose;
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
/*     */   private JButton btCopy;
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
/*     */   private JButton btCut;
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
/*     */   private JButton btFind;
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
/*     */   private JButton btPaste;
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
/*     */   private JButton btDTD;
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
/*     */   private JButton btXML;
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
/*     */   private JPopupMenu jPopupMenu;
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
/*     */   private JMenuItem miSave;
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
/*     */   private JMenuItem miSaveAs;
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
/*     */   private JMenuItem miClose;
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
/*     */   private JMenuItem miCopy;
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
/*     */   private JMenuItem miCut;
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
/*     */   private JMenuItem miPaste;
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
/*     */   private StatusBar statusBar;
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
/*     */   private Principale frmPrincipale;
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
/*     */   public JTextEditorPan()
/*     */   {
/* 494 */     this.nomFic = "";
/* 495 */     this.cheminFic = "";
/*     */     
/* 497 */     this.pane = new MyXMLTextPane();
/* 498 */     this.scrollPane = new JScrollPane();
/* 499 */     this.scrollPane.setViewportView(this.pane);
/*     */     
/* 501 */     this.toolBar = new JToolBar();
/* 502 */     this.btSave = new JButton();
/* 503 */     this.btSaveAs = new JButton();
/*     */     
/* 505 */     this.btCopy = new JButton();
/* 506 */     this.btCut = new JButton();
/* 507 */     this.btFind = new JButton();
/* 508 */     this.btPaste = new JButton();
/* 509 */     this.btDTD = new JButton();
/* 510 */     this.btXML = new JButton();
/*     */     
/* 512 */     this.miSave = new JMenuItem("Enregistrer      CTRL S");
/* 513 */     this.miSaveAs = new JMenuItem("Enregistrer sous ");
/*     */     
/* 515 */     this.miCopy = new JMenuItem("Copier         CTRL C");
/* 516 */     this.miCut = new JMenuItem("Couper         CTRL X");
/* 517 */     this.miPaste = new JMenuItem("Coller         CTRL V");
/* 518 */     this.jPopupMenu = new JPopupMenu();
/*     */     
/* 520 */     this.statusBar = new StatusBar();
/* 521 */     this.statusBar.setVisible(false);
/*     */     
/*     */ 
/* 524 */     JSeparator jseparMenuPop = new JSeparator();
/*     */     
/*     */ 
/* 527 */     jseparMenuPop.setOrientation(0);
/*     */     
/* 529 */     this.btSave.setFocusable(false);
/* 530 */     this.btSaveAs.setFocusable(false);
/*     */     
/* 532 */     this.btCopy.setFocusable(false);
/* 533 */     this.btCut.setFocusable(false);
/* 534 */     this.btFind.setFocusable(false);
/* 535 */     this.btPaste.setFocusable(false);
/* 536 */     this.btDTD.setFocusable(false);
/* 537 */     this.btXML.setFocusable(false);
/*     */     
/* 539 */     this.btSave.setIcon(new ImageIcon(getClass().getResource("save.png")));
/* 540 */     this.btSaveAs.setIcon(new ImageIcon(getClass().getResource("saveas.png")));
/*     */     
/* 542 */     this.btCut.setIcon(new ImageIcon(getClass().getResource("cut.png")));
/* 543 */     this.btCopy.setIcon(new ImageIcon(getClass().getResource("copy.png")));
/* 544 */     this.btFind.setIcon(new ImageIcon(getClass().getResource("goto.png")));
/* 545 */     this.btPaste.setIcon(new ImageIcon(getClass().getResource("paste.png")));
/* 546 */     this.btDTD.setIcon(new ImageIcon(getClass().getResource("dtd.png")));
/* 547 */     this.btXML.setIcon(new ImageIcon(getClass().getResource("xml.png")));
/*     */     
/* 549 */     this.btSave.setToolTipText("Enregistrer");
/* 550 */     this.btSaveAs.setToolTipText("Enregistrer sous");
/*     */     
/* 552 */     this.btCut.setToolTipText("Couper");
/* 553 */     this.btCopy.setToolTipText("Copier");
/* 554 */     this.btFind.setToolTipText("Chercher");
/* 555 */     this.btPaste.setToolTipText("Coller");
/* 556 */     this.btDTD.setToolTipText("Générer le DTD du MCD");
/* 557 */     this.btXML.setToolTipText("Générer le XML de tout le travail");
/*     */     
/* 559 */     this.btCut.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 561 */         JTextEditorPan.this.cut();
/*     */       }
/*     */       
/* 564 */     });
/* 565 */     this.btCopy.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 567 */         JTextEditorPan.this.copy();
/*     */       }
/*     */       
/* 570 */     });
/* 571 */     this.btPaste.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 573 */         JTextEditorPan.this.paste();
/*     */       }
/*     */       
/* 576 */     });
/* 577 */     this.btSave.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 579 */         if (JTextEditorPan.this.nomFic.length() == 0) {
/* 580 */           JFileChooser fileCh = new JFileChooser();
/* 582 */           FileNameExtensionFilter filtre; if (JTextEditorPan.this.getTypeDoc().equals("DTD"))
/* 583 */             filtre = new FileNameExtensionFilter("Fichier dtd", new String[] { "dtd" }); else
/* 584 */             filtre = new FileNameExtensionFilter("Fichier xml", new String[] { "xml" });
/* 585 */           fileCh.setFileFilter(filtre);
/* 586 */           if (fileCh.showSaveDialog(JTextEditorPan.this.getFrmPrincipale()) == 0) {
/* 587 */             File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/* 588 */             if (!fil.exists()) {
/* 589 */               String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/* 590 */               if (JTextEditorPan.this.getTypeDoc().equals("DTD")) nomFile = JTextEditorPan.this.getExtentionDTD(nomFile); else {
/* 591 */                 nomFile = JTextEditorPan.this.getExtentionXML(nomFile);
/*     */               }
/*     */               try {
/* 594 */                 PrintWriter out = new PrintWriter(nomFile);
/* 595 */                 out.write(JTextEditorPan.this.pane.getText());
/* 596 */                 out.close();
/*     */               } catch (FileNotFoundException ex) {
/* 598 */                 Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/*     */               
/* 601 */               JTextEditorPan.this.nomFic = nomFile;
/*     */ 
/*     */             }
/* 604 */             else if (JOptionPane.showConfirmDialog(JTextEditorPan.this.getFrmPrincipale(), "Le fichier existe.\n Voulez vous le remplacer ?", "Modification ", 0) == 0)
/*     */             {
/*     */               try {
/* 607 */                 PrintWriter out = new PrintWriter(fileCh.getSelectedFile().getAbsolutePath());
/* 608 */                 out.write(JTextEditorPan.this.pane.getText());
/* 609 */                 out.close();
/*     */               } catch (FileNotFoundException ex) {
/* 611 */                 Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 613 */               JTextEditorPan.this.nomFic = fileCh.getSelectedFile().getAbsolutePath();
/*     */             }
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/*     */           try {
/* 620 */             PrintWriter out = new PrintWriter(JTextEditorPan.this.nomFic);
/* 621 */             out.write(JTextEditorPan.this.pane.getText());
/* 622 */             out.close();
/*     */           } catch (FileNotFoundException ex) {
/* 624 */             Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */           }
/*     */           
/*     */         }
/*     */       }
/* 629 */     });
/* 630 */     this.btSaveAs.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 632 */         if (JTextEditorPan.this.nomFic.length() == 0) {
/* 633 */           JFileChooser fileCh = new JFileChooser();
/* 635 */           FileNameExtensionFilter filtre; if (JTextEditorPan.this.getTypeDoc().equals("DTD"))
/* 636 */             filtre = new FileNameExtensionFilter("Fichier dtd", new String[] { "dtd" }); else
/* 637 */             filtre = new FileNameExtensionFilter("Fichier xml", new String[] { "xml" });
/* 638 */           fileCh.setFileFilter(filtre);
/* 639 */           if (fileCh.showSaveDialog(JTextEditorPan.this.getFrmPrincipale()) == 0) {
/* 640 */             File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/* 641 */             if (!fil.exists()) {
/* 642 */               String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/* 643 */               if (JTextEditorPan.this.getTypeDoc().equals("DTD")) nomFile = JTextEditorPan.this.getExtentionDTD(nomFile); else {
/* 644 */                 nomFile = JTextEditorPan.this.getExtentionXML(nomFile);
/*     */               }
/*     */               try {
/* 647 */                 PrintWriter out = new PrintWriter(nomFile);
/* 648 */                 out.write(JTextEditorPan.this.pane.getText());
/* 649 */                 out.close();
/*     */               } catch (FileNotFoundException ex) {
/* 651 */                 Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/*     */               
/* 654 */               JTextEditorPan.this.nomFic = nomFile;
/*     */ 
/*     */             }
/* 657 */             else if (JOptionPane.showConfirmDialog(JTextEditorPan.this.getFrmPrincipale(), "Le fichier existe.\n Voulez vous le remplacer ?", "Modification ", 0) == 0)
/*     */             {
/*     */               try {
/* 660 */                 PrintWriter out = new PrintWriter(fileCh.getSelectedFile().getAbsolutePath());
/* 661 */                 out.write(JTextEditorPan.this.pane.getText());
/* 662 */                 out.close();
/*     */               } catch (FileNotFoundException ex) {
/* 664 */                 Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 666 */               JTextEditorPan.this.nomFic = fileCh.getSelectedFile().getAbsolutePath();
/*     */             }
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/*     */           try {
/* 673 */             PrintWriter out = new PrintWriter(JTextEditorPan.this.nomFic);
/* 674 */             out.write(JTextEditorPan.this.pane.getText());
/* 675 */             out.close();
/*     */           } catch (FileNotFoundException ex) {
/* 677 */             Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */           }
/*     */           
/*     */         }
/*     */       }
/* 682 */     });
/* 683 */     this.btFind.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/* 686 */         String message = "Recherche : ";
/* 687 */         String reponse = JOptionPane.showInputDialog(JTextEditorPan.this, message, "Recherche", 3);
/* 688 */         if ((reponse != null) && (reponse.trim().length() > 0)) {
/* 689 */           JTextEditorPan.this.pane.words[5] = reponse;
/* 690 */           JTextEditorPan.this.statusBar.getFindField().setText(reponse);
/* 691 */           int position = JTextEditorPan.this.pane.findWord(reponse);
/* 692 */           if (position != -1) {
/* 693 */             JTextEditorPan.this.pane.setCaretPosition(position);
/* 694 */             JTextEditorPan.this.pane.requestFocus();
/*     */           }
/*     */           
/*     */         }
/*     */       }
/* 699 */     });
/* 700 */     this.btDTD.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 702 */         JTextEditorPan.this.frmPrincipale.getFormeXML().getXmlString().setListeEntiteMLD(JTextEditorPan.this.frmPrincipale.getFormeMLD().getPageMld().getListeMLDEntite());
/* 703 */         JTextEditorPan.this.frmPrincipale.getFormeXML().getPanelXML().getPane().setText(JTextEditorPan.this.frmPrincipale.getFormeXML().getXmlString().getXMLString("MCD_XML"));
/* 704 */         JTextEditorPan.this.setTypeDoc("DTD");
/*     */       }
/*     */       
/* 707 */     });
/* 708 */     this.btXML.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 710 */         JTextEditorPan.this.setTypeDoc("XML");
/* 711 */         new ThreadGenererXML(JTextEditorPan.this.frmPrincipale).execute();
/*     */       }
/*     */       
/*     */ 
/* 715 */     });
/* 716 */     this.toolBar.add(this.btSave);
/* 717 */     this.toolBar.add(this.btSaveAs);
/*     */     
/* 719 */     this.toolBar.add(this.btCut);
/* 720 */     this.toolBar.add(this.btCopy);
/* 721 */     this.toolBar.add(this.btPaste);
/* 722 */     this.toolBar.add(this.btFind);
/* 723 */     this.toolBar.add(this.btDTD);
/* 724 */     this.toolBar.add(this.btXML);
/*     */     
/* 726 */     this.miSave.setIcon(new ImageIcon(getClass().getResource("save.png")));
/* 727 */     this.miSaveAs.setIcon(new ImageIcon(getClass().getResource("saveas.png")));
/*     */     
/* 729 */     this.miCut.setIcon(new ImageIcon(getClass().getResource("cut.png")));
/* 730 */     this.miCopy.setIcon(new ImageIcon(getClass().getResource("copy.png")));
/* 731 */     this.miPaste.setIcon(new ImageIcon(getClass().getResource("paste.png")));
/*     */     
/* 733 */     this.miCut.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 735 */         JTextEditorPan.this.cut();
/*     */       }
/*     */       
/* 738 */     });
/* 739 */     this.miCopy.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 741 */         JTextEditorPan.this.copy();
/*     */       }
/*     */       
/* 744 */     });
/* 745 */     this.miPaste.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent e) {
/* 747 */         JTextEditorPan.this.paste();
/*     */       }
/*     */       
/* 750 */     });
/* 751 */     this.miSave.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e)
/*     */       {
/* 755 */         if (JTextEditorPan.this.nomFic.length() == 0) {
/* 756 */           JFileChooser fileCh = new JFileChooser();
/* 758 */           FileNameExtensionFilter filtre; if (JTextEditorPan.this.getTypeDoc().equals("DTD"))
/* 759 */             filtre = new FileNameExtensionFilter("Fichier dtd", new String[] { "dtd" }); else
/* 760 */             filtre = new FileNameExtensionFilter("Fichier xml", new String[] { "xml" });
/* 761 */           fileCh.setFileFilter(filtre);
/* 762 */           if (fileCh.showSaveDialog(JTextEditorPan.this.getFrmPrincipale()) == 0) {
/* 763 */             File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/* 764 */             if (!fil.exists()) {
/* 765 */               String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/* 766 */               if (JTextEditorPan.this.getTypeDoc().equals("DTD")) nomFile = JTextEditorPan.this.getExtentionDTD(nomFile); else {
/* 767 */                 nomFile = JTextEditorPan.this.getExtentionXML(nomFile);
/*     */               }
/*     */               try {
/* 770 */                 PrintWriter out = new PrintWriter(nomFile);
/* 771 */                 out.write(JTextEditorPan.this.pane.getText());
/* 772 */                 out.close();
/*     */               } catch (FileNotFoundException ex) {
/* 774 */                 Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/*     */               
/* 777 */               JTextEditorPan.this.nomFic = nomFile;
/*     */ 
/*     */             }
/* 780 */             else if (JOptionPane.showConfirmDialog(JTextEditorPan.this.getFrmPrincipale(), "Le fichier existe.\n Voulez vous le remplacer ?", "Modification ", 0) == 0)
/*     */             {
/*     */               try {
/* 783 */                 PrintWriter out = new PrintWriter(fileCh.getSelectedFile().getAbsolutePath());
/* 784 */                 out.write(JTextEditorPan.this.pane.getText());
/* 785 */                 out.close();
/*     */               } catch (FileNotFoundException ex) {
/* 787 */                 Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/* 789 */               JTextEditorPan.this.nomFic = fileCh.getSelectedFile().getAbsolutePath();
/*     */             }
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/*     */           try {
/* 796 */             PrintWriter out = new PrintWriter(JTextEditorPan.this.nomFic);
/* 797 */             out.write(JTextEditorPan.this.pane.getText());
/* 798 */             out.close();
/*     */           } catch (FileNotFoundException ex) {
/* 800 */             Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */           }
/*     */           
/*     */         }
/*     */       }
/* 805 */     });
/* 806 */     this.miSaveAs.addActionListener(new ActionListener()
/*     */     {
/*     */       public void actionPerformed(ActionEvent e) {
/* 809 */         JFileChooser fileCh = new JFileChooser();
/* 811 */         FileNameExtensionFilter filtre; if (JTextEditorPan.this.getTypeDoc().equals("DTD"))
/* 812 */           filtre = new FileNameExtensionFilter("Fichier dtd", new String[] { "dtd" }); else
/* 813 */           filtre = new FileNameExtensionFilter("Fichier xml", new String[] { "xml" });
/* 814 */         fileCh.setFileFilter(filtre);
/* 815 */         if (fileCh.showSaveDialog(JTextEditorPan.this.getFrmPrincipale()) == 0) {
/* 816 */           File fil = new File(fileCh.getSelectedFile().getAbsolutePath());
/* 817 */           if (!fil.exists()) {
/* 818 */             String nomFile = fileCh.getSelectedFile().getAbsolutePath();
/* 819 */             if (JTextEditorPan.this.getTypeDoc().equals("DTD")) nomFile = JTextEditorPan.this.getExtentionDTD(nomFile); else {
/* 820 */               nomFile = JTextEditorPan.this.getExtentionXML(nomFile);
/*     */             }
/*     */             try {
/* 823 */               PrintWriter out = new PrintWriter(nomFile);
/* 824 */               out.write(JTextEditorPan.this.pane.getText());
/* 825 */               out.close();
/*     */             } catch (FileNotFoundException ex) {
/* 827 */               Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */             }
/*     */             
/* 830 */             JTextEditorPan.this.nomFic = nomFile;
/*     */ 
/*     */           }
/* 833 */           else if (JOptionPane.showConfirmDialog(JTextEditorPan.this.getFrmPrincipale(), "Le fichier existe.\n Voulez vous le remplacer ?", "Modification ", 0) == 0)
/*     */           {
/*     */             try {
/* 836 */               PrintWriter out = new PrintWriter(fileCh.getSelectedFile().getAbsolutePath());
/* 837 */               out.write(JTextEditorPan.this.pane.getText());
/* 838 */               out.close();
/*     */             } catch (FileNotFoundException ex) {
/* 840 */               Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */             }
/* 842 */             JTextEditorPan.this.nomFic = fileCh.getSelectedFile().getAbsolutePath();
/*     */           }
/*     */           
/*     */         }
/*     */         
/*     */       }
/*     */       
/* 849 */     });
/* 850 */     this.jPopupMenu.add(this.miCut);
/* 851 */     this.jPopupMenu.add(this.miCopy);
/* 852 */     this.jPopupMenu.add(this.miPaste);
/* 853 */     this.jPopupMenu.add(jseparMenuPop);
/* 854 */     this.jPopupMenu.add(this.miSave);
/* 855 */     this.jPopupMenu.add(this.miSaveAs);
/*     */     
/*     */ 
/*     */ 
/* 859 */     this.pane.addMouseListener(new java.awt.event.MouseListener() {
/*     */       public void mousePressed(MouseEvent e) {
/* 861 */         if (e.getButton() == 3) {
/* 862 */           JTextEditorPan.this.jPopupMenu.setLocation(MouseInfo.getPointerInfo().getLocation());
/* 863 */           JTextEditorPan.this.jPopupMenu.show(e.getComponent(), e.getX(), e.getY());
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
/* 881 */     });
/* 882 */     this.statusBar.getLabClose().addMouseListener(new java.awt.event.MouseAdapter() {
/*     */       public void mouseClicked(MouseEvent evt) {
/* 884 */         JTextEditorPan.this.statusBar.setVisible(false);
/* 885 */         JTextEditorPan.this.pane.requestFocus();
/*     */       }
/*     */       
/* 888 */     });
/* 889 */     this.statusBar.getFindField().addKeyListener(new KeyAdapter() {
/*     */       public void keyReleased(KeyEvent evt) {
/* 891 */         int position = JTextEditorPan.this.pane.findWord(JTextEditorPan.this.statusBar.getFindField().getText().trim());
/* 892 */         if (position == -1) {
/* 893 */           JTextEditorPan.this.statusBar.getFindField().setBackground(Color.red);
/*     */         } else {
/* 895 */           JTextEditorPan.this.statusBar.getFindField().setBackground(Color.white);
/* 896 */           JTextEditorPan.this.pane.setCaretPosition(position);
/* 897 */           JTextEditorPan.this.pane.requestFocus();
/* 898 */           JTextEditorPan.this.statusBar.getFindField().requestFocus();
/*     */         }
/*     */         
/* 901 */         JTextEditorPan.this.pane.words[5] = (JTextEditorPan.this.statusBar.getFindField().getText().trim().length() == 0 ? "." : JTextEditorPan.this.statusBar.getFindField().getText().trim());
/*     */         try {
/* 903 */           JTextEditorPan.this.pane.colorise();
/*     */         } catch (BadLocationException ex) {
/* 905 */           Logger.getLogger(JTextEditorPan.class.getName()).log(Level.SEVERE, null, ex);
/*     */         }
/*     */         
/*     */       }
/* 909 */     });
/* 910 */     this.pane.addKeyListener(new KeyAdapter() {
/*     */       public void keyPressed(KeyEvent evt) {
/* 912 */         if (evt.getKeyCode() == 114) {
/* 913 */           if (!JTextEditorPan.this.statusBar.isVisible()) JTextEditorPan.this.statusBar.setVisible(true);
/* 914 */           JTextEditorPan.this.statusBar.getFindField().requestFocus();
/*     */         }
/*     */         
/*     */       }
/* 918 */     });
/* 919 */     setLayout(new BorderLayout());
/* 920 */     add(this.scrollPane, "Center");
/* 921 */     add(this.toolBar, "North");
/* 922 */     add(this.statusBar, "South");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void copy()
/*     */   {
/* 929 */     this.pane.copy();
/*     */   }
/*     */   
/*     */   private void cut() {
/* 933 */     this.pane.cut();
/*     */   }
/*     */   
/*     */   private void paste() {
/* 937 */     this.pane.paste();
/*     */   }
/*     */   
/*     */   public MyXMLTextPane getPane()
/*     */   {
/* 942 */     return this.pane;
/*     */   }
/*     */   
/*     */   public JMenuItem getMiSave() {
/* 946 */     return this.miSave;
/*     */   }
/*     */   
/*     */   public JButton getBtSave() {
/* 950 */     return this.btSave;
/*     */   }
/*     */   
/*     */   public JMenuItem getMiClose() {
/* 954 */     return this.miClose;
/*     */   }
/*     */   
/*     */   public JButton getBtClose() {
/* 958 */     return this.btClose;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Principale getFrmPrincipale()
/*     */   {
/* 966 */     return this.frmPrincipale;
/*     */   }
/*     */   
/*     */   public void setFrmPrincipale(Principale frm) {
/* 970 */     this.frmPrincipale = frm;
/*     */   }
/*     */   
/*     */   private String getExtentionDTD(String nom) {
/* 974 */     if (!nom.trim().toUpperCase().endsWith(".DTD")) {
/* 975 */       nom = nom + ".dtd";
/*     */     }
/* 977 */     return nom;
/*     */   }
/*     */   
/*     */   private String getExtentionXML(String nom) {
/* 981 */     if (!nom.trim().toUpperCase().endsWith(".XML")) {
/* 982 */       nom = nom + ".xml";
/*     */     }
/* 984 */     return nom;
/*     */   }
/*     */   
/*     */   public String getTypeDoc() {
/* 988 */     return this.typeDoc;
/*     */   }
/*     */   
/*     */   public void setTypeDoc(String typeDoc) {
/* 992 */     this.typeDoc = typeDoc;
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyXMLEditor\JTextEditorPan.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */