/*     */ package mythread;
/*     */ 
/*     */ import IhmMCD.Point;
/*     */ import Outil.Parametres;
/*     */ import Outil.Setting;
/*     */ import ihm.Principale;
/*     */ import java.awt.Color;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.Font;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.Graphics2D;
/*     */ import java.awt.RenderingHints;
/*     */ import java.awt.print.PageFormat;
/*     */ import java.awt.print.Paper;
/*     */ import java.awt.print.Printable;
/*     */ import java.awt.print.PrinterException;
/*     */ import java.awt.print.PrinterJob;
/*     */ import java.util.ArrayList;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.SwingWorker;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ThreadImprimer
/*     */   extends SwingWorker
/*     */   implements Printable
/*     */ {
/*     */   private JPanel panel;
/*     */   private PrinterJob printJob;
/*     */   ArrayList<Point> listPage;
/*     */   ArrayList<Point> listNumPage;
/*     */   private String nomMCD;
/*  36 */   private int nbPage = 0;
/*     */   public static final int PORTRAIT = 1;
/*     */   public static final int LANDSCAPE = 0;
/*     */   private Principale frm;
/*     */   PageFormat pageFormat;
/*     */   
/*     */   public ThreadImprimer(Principale frm, JPanel panel, String nomMCD)
/*     */   {
/*  44 */     this.panel = panel;
/*  45 */     this.frm = frm;
/*  46 */     this.nomMCD = nomMCD;
/*  47 */     if ((nomMCD != null) || (nomMCD.length() > 0)) {
/*  48 */       this.nomMCD = this.nomMCD.replace(".mcd", "");
/*  49 */       this.nomMCD = this.nomMCD.replace(".MCD", "");
/*  50 */       this.nomMCD = this.nomMCD.replace("*", "");
/*     */     }
/*     */     
/*  53 */     initPrintablePanel();
/*     */   }
/*     */   
/*     */   public void initPrintablePanel()
/*     */   {
/*  58 */     this.printJob = PrinterJob.getPrinterJob();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLRMargins(int margin)
/*     */   {
/*  65 */     Paper paper = this.pageFormat.getPaper();
/*  66 */     paper.setImageableArea(paper.getImageableX() - margin / 2, paper.getImageableY(), paper.getImageableWidth() + margin, paper.getImageableHeight());
/*  67 */     this.pageFormat.setPaper(paper);
/*     */   }
/*     */   
/*     */   public void setTBMargins(int margin) {
/*  71 */     Paper paper = this.pageFormat.getPaper();
/*  72 */     paper.setImageableArea(paper.getImageableX(), paper.getImageableY() - margin / 2, paper.getImageableWidth(), paper.getImageableHeight() + margin);
/*  73 */     this.pageFormat.setPaper(paper);
/*     */   }
/*     */   
/*     */   public int getNbPageLigne(PageFormat pf) {
/*  77 */     return (int)Math.ceil(this.panel.getSize().getHeight() / pf.getImageableHeight());
/*     */   }
/*     */   
/*     */   public int getNbPageColonne(PageFormat pf) {
/*  81 */     return (int)Math.ceil(this.panel.getSize().getWidth() / pf.getImageableWidth());
/*     */   }
/*     */   
/*     */   public int print(Graphics g, PageFormat pf, int pageIndex) throws PrinterException {
/*  85 */     Graphics2D g2d = (Graphics2D)g;
/*  86 */     g2d.scale(0.5D, 0.5D);
/*  87 */     g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
/*  88 */     g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/*  89 */     g2d.translate(pf.getImageableX() * 2.0D, pf.getImageableY() * 2.0D);
/*     */     
/*  91 */     g2d.translate(-1.0D * ((Point)this.listPage.get(pageIndex)).getY(), -1.0D * ((Point)this.listPage.get(pageIndex)).getX());
/*  92 */     calculerLimitePage(pf);
/*     */     
/*  94 */     this.panel.paint(g2d);
/*  95 */     g2d.translate(1.0D * ((Point)this.listPage.get(pageIndex)).getY(), 1.0D * ((Point)this.listPage.get(pageIndex)).getX());
/*     */     
/*  97 */     g2d.setColor(Color.BLACK);
/*  98 */     g2d.setFont(new Font("Verdanna", 2, 10));
/*  99 */     String s = "R.MESSOUCI_JMerise " + Parametres.version;
/*     */     
/* 101 */     if (Setting.imprimerNumPage) s = s + " page [" + ((Point)this.listNumPage.get(pageIndex)).getX() + "/" + this.nbPage + "," + ((Point)this.listNumPage.get(pageIndex)).getY() + "]";
/* 102 */     if (Setting.imprimerNomDev) s = s + "  DEV : " + Setting.developpeur + "   ";
/* 103 */     if (Setting.imprimerNomMcd) s = s + "  " + this.nomMCD;
/* 104 */     g2d.drawString(s, 10, (int)pf.getImageableHeight() * 2 - 6);
/*     */     
/* 106 */     if (pageIndex >= this.listPage.size())
/*     */     {
/* 108 */       return 1;
/*     */     }
/*     */     
/* 111 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public void calculerLimitePage(PageFormat pf)
/*     */   {
/* 117 */     int x = 0;int y = 0;
/* 118 */     int num = 0;
/* 119 */     this.listPage = new ArrayList();
/* 120 */     this.listNumPage = new ArrayList();
/* 121 */     this.nbPage = 0;
/* 122 */     while (x < this.panel.getSize().getHeight()) {
/* 123 */       y = 0;
/* 124 */       num = 0;
/* 125 */       this.nbPage += 1;
/* 126 */       while (y < this.panel.getSize().getWidth()) {
/* 127 */         this.listPage.add(new Point(x, y));
/* 128 */         y += (int)pf.getImageableWidth() * 2;
/* 129 */         num++;
/* 130 */         this.listNumPage.add(new Point(this.nbPage, num));
/*     */       }
/* 132 */       x += (int)pf.getImageableHeight() * 2;
/*     */     }
/*     */   }
/*     */   
/*     */   protected Object doInBackground()
/*     */     throws Exception
/*     */   {
/* 139 */     if (!Principale.isActiverJMerise()) {
/* 140 */       JOptionPane.showMessageDialog(this.frm, "Il faut activer cette version pour poursuivre l'impression  ! ");
/* 141 */       return Integer.valueOf(0);
/*     */     }
/*     */     try {
/* 144 */       if (this.printJob.printDialog())
/*     */       {
/* 146 */         Paper save = this.printJob.defaultPage().getPaper();
/* 147 */         this.pageFormat = this.printJob.defaultPage();
/* 148 */         this.pageFormat.setOrientation(Setting.getImprimeOrientation());
/* 149 */         setLRMargins(100);
/* 150 */         setTBMargins(100);
/* 151 */         calculerLimitePage(this.pageFormat);
/* 152 */         this.printJob.setPrintable(this, this.pageFormat);
/* 153 */         this.printJob.print();
/* 154 */         this.pageFormat.setPaper(save);
/*     */       }
/*     */     } catch (PrinterException pe) {
/* 157 */       JOptionPane.showMessageDialog(this.frm, "Erreur lors de l'impression du document: " + toString());
/*     */     }
/* 159 */     return Integer.valueOf(0);
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\mythread\ThreadImprimer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */