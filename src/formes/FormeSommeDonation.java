/*     */ package formes;
/*     */ 
/*     */ import ihm.Principale;
/*     */ import java.awt.Color;
/*     */ import java.awt.Desktop;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.GroupLayout.Alignment;
/*     */ import javax.swing.GroupLayout.ParallelGroup;
/*     */ import javax.swing.GroupLayout.SequentialGroup;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ 
/*     */ public class FormeSommeDonation extends JDialog
/*     */ {
/*     */   Principale frm;
/*     */   private JButton jButton1;
/*     */   private JPanel jPanel2;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JTextArea jTextArea1;
/*     */   
/*     */   public FormeSommeDonation(Principale parent, boolean modal)
/*     */   {
/*  30 */     super(parent, modal);
/*  31 */     initComponents();
/*  32 */     this.frm = parent;
/*  33 */     setLocation(300, 100);
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
/*  45 */     this.jPanel2 = new JPanel();
/*  46 */     this.jScrollPane1 = new JScrollPane();
/*  47 */     this.jTextArea1 = new JTextArea();
/*  48 */     this.jButton1 = new JButton();
/*     */     
/*  50 */     setDefaultCloseOperation(2);
/*  51 */     setTitle("Liste des donateurs");
/*  52 */     setResizable(false);
/*     */     
/*  54 */     this.jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */     
/*  56 */     this.jTextArea1.setColumns(20);
/*  57 */     this.jTextArea1.setEditable(false);
/*  58 */     this.jTextArea1.setFont(new Font("Monospaced", 1, 14));
/*  59 */     this.jTextArea1.setRows(5);
/*  60 */     this.jTextArea1.setText("\n\t*******************************************\n\t*\n\t*    Merci de faire un don pour JMerise \n\t*    en cliquant sur le bouton ci-dessous. \n\t*\n\t*******************************************\n\n\nUn grand MERCI à ces donateurs \n==============================\n\n\tPhilippe M\t\tFrance\n\tPhilippe J\t\tSuisse\n\tJean-Yves D\t\tBelgique\n\tMohamed C\t\tFrance\t\n\tFlorian C\t\tFrance\t\n\tSami B\t\t\tTunisie\t\n\tFlorian G\t\tFrance\t\n\tDominique D\t\tFrance\t\n\tArtisan\t\t\tAlgerie\t    \n\tAlexandre H\t\tFrance\t\n\tiliasse M\t\tFrance\nvoir la liste Complète sur le site ==> menu Aide > informations Site.\n");
/*  61 */     this.jScrollPane1.setViewportView(this.jTextArea1);
/*     */     
/*  63 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  64 */     this.jPanel2.setLayout(jPanel2Layout);
/*  65 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 593, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  72 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 355, 32767).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  80 */     this.jButton1.setFont(new Font("Tahoma", 1, 11));
/*  81 */     this.jButton1.setForeground(new Color(0, 0, 102));
/*  82 */     this.jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/don16.png")));
/*  83 */     this.jButton1.setText("Moi aussi, Je veux faire un don !");
/*  84 */     this.jButton1.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  86 */         FormeSommeDonation.this.jButton1ActionPerformed(evt);
/*     */       }
/*     */       
/*  89 */     });
/*  90 */     GroupLayout layout = new GroupLayout(getContentPane());
/*  91 */     getContentPane().setLayout(layout);
/*  92 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jButton1, -2, 273, -2).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 101 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel2, -1, -1, 32767).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jButton1, -2, 32, -2).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 111 */     pack();
/*     */   }
/*     */   
/*     */   private void jButton1ActionPerformed(ActionEvent evt)
/*     */   {
/* 116 */     if (Desktop.isDesktopSupported())
/*     */     {
/* 118 */       Desktop desktop = Desktop.getDesktop();
/*     */       
/*     */ 
/* 121 */       if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
/*     */         try
/*     */         {
/*     */           try
/*     */           {
/* 126 */             desktop.browse(new java.net.URI("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=5EBMJ2ETL23HE"));
/*     */           } catch (java.net.URISyntaxException ex) {
/* 128 */             Logger.getLogger(FormeSommeDonation.class.getName()).log(Level.SEVERE, null, ex);
/*     */           }
/*     */         } catch (java.io.IOException ex) {
/* 131 */           Logger.getLogger(FormeSommeDonation.class.getName()).log(Level.SEVERE, null, ex);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 136 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeSommeDonation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */