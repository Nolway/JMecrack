/*     */ package IhmMCD;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JProgressBar;
/*     */ import javax.swing.JToolBar;
/*     */ 
/*     */ public class StatutBar extends javax.swing.JPanel
/*     */ {
/*     */   private JLabel jLabEnregister;
/*     */   private JLabel jLabStatut;
/*     */   private JLabel jLabX;
/*     */   private JLabel jLabY;
/*     */   private JLabel jLabel1;
/*     */   private JLabel jLabel2;
/*     */   private JLabel jLabel3;
/*     */   private JProgressBar jProgEnregister;
/*     */   private javax.swing.JToolBar.Separator jSeparator1;
/*     */   private JToolBar jToolBar1;
/*     */   
/*     */   public StatutBar()
/*     */   {
/*  25 */     initComponents();
/*  26 */     this.jProgEnregister.setVisible(false);
/*  27 */     this.jLabEnregister.setVisible(false);
/*     */   }
/*     */   
/*     */ 
/*  31 */   public void setStatutLab(String comm) { this.jLabStatut.setText(comm); }
/*     */   
/*     */   public void setCoordonnee(int x, int y) {
/*  34 */     this.jLabX.setText("" + x);
/*  35 */     this.jLabY.setText("" + y);
/*     */   }
/*     */   
/*     */   public void setDateFin(String date)
/*     */   {
/*  40 */     this.jLabel3.setText(date);
/*     */   }
/*     */   
/*     */   public JLabel getjLabEnregister() {
/*  44 */     return this.jLabEnregister;
/*     */   }
/*     */   
/*     */   public JProgressBar getjProgEnregister() {
/*  48 */     return this.jProgEnregister;
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
/*  60 */     this.jToolBar1 = new JToolBar();
/*  61 */     this.jLabStatut = new JLabel();
/*  62 */     this.jLabel2 = new JLabel();
/*  63 */     this.jSeparator1 = new javax.swing.JToolBar.Separator();
/*  64 */     this.jLabX = new JLabel();
/*  65 */     this.jLabel1 = new JLabel();
/*  66 */     this.jLabY = new JLabel();
/*  67 */     this.jLabel3 = new JLabel();
/*  68 */     this.jLabEnregister = new JLabel();
/*  69 */     this.jProgEnregister = new JProgressBar();
/*     */     
/*  71 */     this.jToolBar1.setBackground(new Color(204, 204, 204));
/*  72 */     this.jToolBar1.setFloatable(false);
/*  73 */     this.jToolBar1.setBorderPainted(false);
/*     */     
/*  75 */     this.jLabStatut.setFont(new java.awt.Font("Tahoma", 1, 11));
/*  76 */     this.jLabStatut.setText("Mode SELECTION");
/*  77 */     this.jToolBar1.add(this.jLabStatut);
/*     */     
/*  79 */     this.jLabel2.setText(".                                                         .");
/*  80 */     this.jToolBar1.add(this.jLabel2);
/*  81 */     this.jToolBar1.add(this.jSeparator1);
/*  82 */     this.jToolBar1.add(this.jLabX);
/*     */     
/*  84 */     this.jLabel1.setText(":");
/*  85 */     this.jToolBar1.add(this.jLabel1);
/*  86 */     this.jToolBar1.add(this.jLabY);
/*     */     
/*  88 */     this.jLabel3.setForeground(new Color(153, 0, 0));
/*  89 */     this.jLabel3.setHorizontalAlignment(0);
/*  90 */     this.jLabel3.setText(".                                                                 .");
/*  91 */     this.jToolBar1.add(this.jLabel3);
/*     */     
/*  93 */     this.jLabEnregister.setText("Enregistrer");
/*  94 */     this.jToolBar1.add(this.jLabEnregister);
/*  95 */     this.jToolBar1.add(this.jProgEnregister);
/*     */     
/*  97 */     GroupLayout layout = new GroupLayout(this);
/*  98 */     setLayout(layout);
/*  99 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jToolBar1, -1, 700, 32767));
/*     */     
/*     */ 
/*     */ 
/* 103 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jToolBar1, -1, 22, 32767));
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\IhmMCD\StatutBar.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */