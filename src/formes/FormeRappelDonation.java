/*     */ package formes;
/*     */ 
/*     */ import ihm.Principale;
/*     */ import java.awt.Color;
/*     */ import java.awt.Desktop;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.io.IOException;
/*     */ import java.net.URISyntaxException;
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
/*     */ public class FormeRappelDonation extends JDialog
/*     */ {
/*     */   Principale frm;
/*     */   private JButton jBtDon;
/*     */   private JPanel jPanel2;
/*     */   private JScrollPane jScrollPane1;
/*     */   private JTextArea jTAMessage;
/*     */   
/*     */   public FormeRappelDonation(Principale parent, boolean modal)
/*     */   {
/*  32 */     super(parent, modal);
/*  33 */     this.frm = parent;
/*  34 */     initComponents();
/*  35 */     setLocation(250, 150);
/*  36 */     this.jTAMessage.setText(getText());
/*     */   }
/*     */   
/*     */   private String getText() {
/*  40 */     String s = "Bonjour " + Outil.Setting.developpeur + ",\n\n";
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  53 */     return s;
/*     */   }
/*     */   
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
/*  66 */     this.jPanel2 = new JPanel();
/*  67 */     this.jBtDon = new JButton();
/*  68 */     this.jScrollPane1 = new JScrollPane();
/*  69 */     this.jTAMessage = new JTextArea();
/*     */     
/*  71 */     setDefaultCloseOperation(2);
/*  72 */     setTitle("Donation JMerise");
/*  73 */     setResizable(false);
/*     */     
/*  75 */     this.jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
/*     */     
/*  77 */     this.jBtDon.setFont(new Font("Tahoma", 1, 11));
/*  78 */     this.jBtDon.setForeground(new Color(0, 0, 153));
/*  79 */     this.jBtDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/don16.png")));
/*  80 */     this.jBtDon.setText("Ok, Je veux faire un don");
/*  81 */     this.jBtDon.addActionListener(new java.awt.event.ActionListener() {
/*     */       public void actionPerformed(ActionEvent evt) {
/*  83 */         FormeRappelDonation.this.jBtDonActionPerformed(evt);
/*     */       }
/*     */       
/*  86 */     });
/*  87 */     GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
/*  88 */     this.jPanel2.setLayout(jPanel2Layout);
/*  89 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup().addContainerGap(552, 32767).addComponent(this.jBtDon, -2, 236, -2).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  96 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(this.jBtDon).addContainerGap(-1, 32767)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 104 */     this.jTAMessage.setColumns(20);
/* 105 */     this.jTAMessage.setEditable(false);
/* 106 */     this.jTAMessage.setFont(new Font("Monospaced", 1, 15));
/* 107 */     this.jTAMessage.setRows(5);
/* 108 */     this.jTAMessage.setText("\n\n\n\n\n\n\n\n\n\n\n");
/* 109 */     this.jScrollPane1.setViewportView(this.jTAMessage);
/*     */     
/* 111 */     GroupLayout layout = new GroupLayout(getContentPane());
/* 112 */     getContentPane().setLayout(layout);
/* 113 */     layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jScrollPane1, GroupLayout.Alignment.LEADING, -1, 800, 32767).addComponent(this.jPanel2, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 122 */     layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -1, 276, 32767).addGap(18, 18, 18).addComponent(this.jPanel2, -2, -1, -2).addContainerGap()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 132 */     pack();
/*     */   }
/*     */   
/*     */   private void jBtDonActionPerformed(ActionEvent evt)
/*     */   {
/* 137 */     if (Desktop.isDesktopSupported()) {
/* 138 */       Desktop desktop = Desktop.getDesktop();
/* 139 */       if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
/*     */         try {
/*     */           try {
/* 142 */             desktop.browse(new java.net.URI("https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=5EBMJ2ETL23HE"));
/* 143 */             new mythread.ThreadDonationSite(this.frm);
/*     */           } catch (URISyntaxException ex) {
/* 145 */             Logger.getLogger(Principale.class.getName()).log(Level.SEVERE, null, ex);
/*     */           }
/*     */         } catch (IOException ex) {
/* 148 */           Logger.getLogger(Principale.class.getName()).log(Level.SEVERE, null, ex);
/*     */         }
/*     */       }
/*     */     }
/* 152 */     dispose();
/*     */   }
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\formes\FormeRappelDonation.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */