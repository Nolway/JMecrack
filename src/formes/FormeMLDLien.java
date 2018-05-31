/*     */ package formes;
/*     */ 
/*     */ import IhmMCD.IhmLienCommentaire;
/*     */ import IhmMCD.IhmLienContraintes;
/*     */ import IhmMLD.MLDLienEntite;
/*     */ import java.awt.Frame;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.ImageIcon;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JDialog;
import javax.swing.LayoutStyle;
/*     */ import javax.swing.LayoutStyle.ComponentPlacement;
/*     */ 
/*     */ public class FormeMLDLien extends JDialog
/*     */ {
/*     */   private MLDLienEntite lienMld;
/*     */   private IhmLienContraintes lienContr;
/*     */   private IhmLienCommentaire lienComm;
/*     */   private JButton jButton1;
/*     */   private JButton jButton2;
/*     */   private JCheckBox jCBPointCassure;
/*     */   
/*     */   public FormeMLDLien(Frame parent, boolean modal, MLDLienEntite lien, int x, int y)
/*     */   {
/*  30 */     super(parent, modal);
/*  31 */     initComponents();
/*  32 */     setLocation(500, 400);
/*  33 */     this.lienMld = lien;
/*  34 */     this.jCBPointCassure.setSelected(lien.isCassure());
/*  35 */     this.jButton2.setMnemonic(65);
/*  36 */     this.jButton1.setMnemonic(10);
/*     */   }
/*     */   
/*  39 */   public FormeMLDLien(Frame parent, boolean modal, IhmLienCommentaire lienComm, int x, int y) { super(parent, modal);
/*  40 */     initComponents();
/*  41 */     setLocation(500, 400);
/*  42 */     this.lienMld = null;
/*  43 */     this.lienComm = lienComm;
/*  44 */     this.lienContr = null;
/*  45 */     this.jCBPointCassure.setSelected(lienComm.isCassure());
/*  46 */     this.jButton2.setMnemonic(65);
/*  47 */     this.jButton1.setMnemonic(10);
/*     */   }
/*     */   
/*     */   public FormeMLDLien(Frame parent, boolean modal, IhmLienContraintes lienContr, int x, int y) {
/*  51 */     super(parent, modal);
/*  52 */     initComponents();
/*  53 */     setLocation(x, y);
/*  54 */     this.lienMld = null;
/*  55 */     this.lienComm = null;
/*  56 */     this.lienContr = lienContr;
/*  57 */     this.jCBPointCassure.setSelected(lienContr.isCassure());
/*  58 */     this.jButton2.setMnemonic(65);
/*  59 */     this.jButton1.setMnemonic(10);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initComponents()
/*     */   {
/*  71 */     this.jCBPointCassure = new JCheckBox();
/*  72 */     this.jButton2 = new JButton();
/*  73 */     this.jButton1 = new JButton();
/*     */     
/*  75 */     setDefaultCloseOperation(2);
/*  76 */     setTitle("Propriete Lien");
/*  77 */     setResizable(false);
/*     */     
/*  79 */     this.jCBPointCassure.setText("    Point de cassure");
/*  80 */     this.jCBPointCassure.setHorizontalAlignment(11);
/*  81 */     this.jCBPointCassure.setHorizontalTextPosition(4);
/*     */     
/*  83 */     this.jButton2.setIcon(new ImageIcon(getClass().getResource("/Images/Cancel.png")));
/*  84 */     this.jButton2.setText("Annuler");
/*  85 */     this.jButton2.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  87 */         FormeMLDLien.this.jButton2ActionPerformed(evt);
/*     */       }
/*     */       
/*  90 */     });
/*  91 */     this.jButton1.setIcon(new ImageIcon(getClass().getResource("/Images/OK.png")));
/*  92 */     this.jButton1.setText("OK");
/*  93 */     this.jButton1.addActionListener(new ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  95 */         FormeMLDLien.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  98 */     });
/*  99 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 100 */     getContentPane().setLayout(layout);
/* 101 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(78, 32767).addComponent(this.jButton2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton1, -2, 88, -2).addContainerGap()).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jCBPointCassure).addContainerGap(148, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 114 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jCBPointCassure).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 12, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jButton1).addComponent(this.jButton2)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 126 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton2ActionPerformed(ActionEvent evt) {
/* 130 */     dispose();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt) {
/* 134 */     if (this.lienMld != null) {
/* 135 */       if ((!this.lienMld.isCassure()) && (this.jCBPointCassure.isSelected())) {
/* 136 */         this.lienMld.initPointCassure();
/*     */       }
/* 138 */       this.lienMld.setCassure(this.jCBPointCassure.isSelected());
/*     */     }
/* 140 */     else if (this.lienComm != null) {
/* 141 */       if ((!this.lienComm.isCassure()) && (this.jCBPointCassure.isSelected())) {
/* 142 */         this.lienComm.initPointCassure();
/*     */       }
/* 144 */       this.lienComm.setCassure(this.jCBPointCassure.isSelected());
/*     */     }
/* 146 */     else if (this.lienContr != null) {
/* 147 */       if ((!this.lienContr.isCassure()) && (this.jCBPointCassure.isSelected())) {
/* 148 */         this.lienContr.initPointCassure();
/*     */       }
/* 150 */       this.lienContr.setCassure(this.jCBPointCassure.isSelected());
/*     */     }
/* 152 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeMLDLien.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */