/*     */ package ihm;
/*     */ 
/*     */ import IhmMCD.IhmPageMCD;
/*     */ import IhmMCD.IhmProjet;
/*     */ import Outil.Parametres;
/*     */ import java.awt.Cursor;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Image;
/*     */ import java.awt.Toolkit;
/*     */ import java.awt.datatransfer.DataFlavor;
/*     */ import java.awt.datatransfer.Transferable;
/*     */ import java.awt.dnd.DropTargetDragEvent;
/*     */ import java.awt.dnd.DropTargetDropEvent;
/*     */ import java.awt.dnd.DropTargetEvent;
/*     */ import java.awt.dnd.DropTargetListener;
/*     */ import java.beans.PropertyVetoException;
/*     */ import java.io.File;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JDesktopPane;
/*     */ import javax.swing.JOptionPane;
/*     */ import mythread.ThreadOuvrir;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MyDeskTopPane
/*     */   extends JDesktopPane
/*     */   implements DropTargetListener
/*     */ {
/*     */   Image backGround;
/*     */   private Principale frm;
/*     */   
/*     */   public MyDeskTopPane(Principale frm)
/*     */   {
/*  41 */     Toolkit tk = Toolkit.getDefaultToolkit();
/*  42 */     this.backGround = tk.createImage(getClass().getResource("/Images/fond.png"));
/*  43 */     this.frm = frm;
/*     */   }
/*     */   
/*     */   protected void paintComponent(Graphics g)
/*     */   {
/*  48 */     if (this.backGround != null) {
/*  49 */       g.drawImage(this.backGround, 0, 0, getSize().width, getSize().height, this);
/*     */     } else {
/*  51 */       super.paintComponent(g);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isDragAcceptable(DropTargetDragEvent evenement)
/*     */   {
/*  59 */     return (evenement.getDropAction() & 0x3) != 0;
/*     */   }
/*     */   
/*     */   public boolean isDropAcceptable(DropTargetDropEvent evenement) {
/*  63 */     return (evenement.getDropAction() & 0x3) != 0;
/*     */   }
/*     */   
/*     */   public void dragEnter(DropTargetDragEvent evenement) {
/*  67 */     if (!isDragAcceptable(evenement)) evenement.rejectDrag();
/*  68 */     setCursor(this.frm.getCursor());
/*     */   }
/*     */   
/*     */   public void dragOver(DropTargetDragEvent evenement) {
/*  72 */     setCursor(this.frm.getCursor());
/*     */   }
/*     */   
/*     */   public void dropActionChanged(DropTargetDragEvent evenement) {
/*  76 */     if (!isDragAcceptable(evenement)) evenement.rejectDrag();
/*     */   }
/*     */   
/*     */   public void dragExit(DropTargetEvent evenement) {
/*  80 */     setCursor(Cursor.getDefaultCursor());
/*     */   }
/*     */   
/*     */   public void drop(DropTargetDropEvent evenement) {
/*  84 */     setCursor(Cursor.getDefaultCursor());
/*  85 */     if (!isDropAcceptable(evenement)) {
/*  86 */       evenement.rejectDrop();
/*  87 */       return;
/*     */     }
/*  89 */     evenement.acceptDrop(1);
/*  90 */     Transferable transferable = evenement.getTransferable();
/*  91 */     DataFlavor[] types = transferable.getTransferDataFlavors();
/*  92 */     for (DataFlavor type : types) {
/*     */       try {
/*  94 */         if (type.equals(DataFlavor.javaFileListFlavor)) {
/*  95 */           List listeFichiers = (List)transferable.getTransferData(type);
/*  96 */           Iterator iterateur = listeFichiers.iterator();
/*     */           
/*  98 */           if (iterateur.hasNext()) {
/*  99 */             File fichier = (File)iterateur.next();
/* 100 */             String nomFile = fichier.getAbsolutePath();
/* 101 */             IhmProjet proj = this.frm.dejaOuvertProjet(nomFile);
/* 102 */             if (proj != null) {
/* 103 */               JOptionPane.showMessageDialog(this.frm, "Le MCD : \" " + nomFile + " \" est déja ouvert !");
/* 104 */               this.frm.setProjetMain(proj);
/*     */               try {
/* 106 */                 this.frm.getFormeMCD().setIcon(false);
/* 107 */                 this.frm.getFormeMCD().toFront();
/*     */               } catch (PropertyVetoException ex) {
/* 109 */                 Logger.getLogger(MyDeskTopPane.class.getName()).log(Level.SEVERE, null, ex);
/*     */               }
/*     */               
/*     */             }
/* 113 */             else if (Parametres.estMCDJMerise(nomFile)) {
/* 114 */               if (this.frm.getProjetSel().getFormeMCD().isPageMCDVide()) {
/* 115 */                 this.frm.getFormeMCD().setModifier(false);
/* 116 */                 ouvrir(fichier.getAbsolutePath());
/*     */               } else {
/* 118 */                 this.frm.creerNouveauProjet();
/* 119 */                 this.frm.getFormeMCD().getPage().effacerAllMCD();
/* 120 */                 ouvrir(fichier.getAbsolutePath());
/*     */               }
/*     */             }
/*     */             else {
/* 124 */               JOptionPane.showMessageDialog(this.frm, "Le fichier  \" " + nomFile + " \" n'est pas un fichier JMerise !");
/*     */             }
/*     */             
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (Exception ex)
/*     */       {
/* 133 */         JOptionPane.showMessageDialog(this.frm, "Erreur s'est produite lors d'ouverture du fichier ", "File drag and drop ", 1);
/*     */       }
/*     */     }
/* 136 */     evenement.dropComplete(true);
/*     */   }
/*     */   
/*     */   private void ouvrir(String nomFile) {
/* 140 */     if (this.frm.getProjetSel() != null) {
/* 141 */       if (this.frm.getProjetSel().getFormeMCD().isPageMCDVide()) {
/* 142 */         this.frm.getFormeMCD().setModifier(false);
/* 143 */         new ThreadOuvrir(this.frm, nomFile).execute();
/*     */       } else {
/* 145 */         boolean mod = this.frm.getFormeMCD().isModifier();
/* 146 */         FormeInterneMCD mcd = this.frm.getProjetSel().getFormeMCD();
/* 147 */         this.frm.getFormeMCD().setModifier(false);
/*     */         
/* 149 */         new ThreadOuvrir(this.frm, nomFile).execute();
/* 150 */         if (mcd != this.frm.getProjetSel().getFormeMCD()) {
/* 151 */           mcd.setModifier(mod);
/*     */         }
/*     */       }
/*     */     }
/* 155 */     this.frm.getPage().setCTRLButton(false);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\ihm\MyDeskTopPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */