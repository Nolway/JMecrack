/*    */ package MyXMLEditor;
/*    */ 
/*    */ import javax.swing.text.BadLocationException;
/*    */ import javax.swing.text.DefaultStyledDocument;
/*    */ 
/*    */ public abstract class ColorisedTextPane extends javax.swing.JTextPane
/*    */ {
/*    */   protected javax.swing.text.Style normal;
/*    */   protected String[] words;
/*    */   protected javax.swing.text.Style[] styles;
/*    */   
/*    */   public ColorisedTextPane()
/*    */   {
/* 14 */     setDocument(new DefaultStyledDocument()
/*    */     {
/*    */       public void insertString(int arg0, String arg1, javax.swing.text.AttributeSet arg2) throws BadLocationException {
/* 17 */         super.insertString(arg0, arg1, arg2);
/* 18 */         ColorisedTextPane.this.colorise();
/*    */       }
/*    */       
/*    */       public void remove(int arg0, int arg1) throws BadLocationException {
/* 22 */         super.remove(arg0, arg1);
/* 23 */         ColorisedTextPane.this.colorise();
/*    */       }
/*    */       
/* 26 */     });
/* 27 */     initStyles();
/*    */   }
/*    */   
/*    */   protected abstract void initStyles();
/*    */   
/* 32 */   private void colorise() throws BadLocationException { if (this.words.length < this.styles.length) { throw new ArrayIndexOutOfBoundsException();
/*    */     }
/* 34 */     String content = null;
/*    */     try {
/* 36 */       javax.swing.text.Document d = getDocument();
/* 37 */       content = d.getText(0, d.getLength()).toUpperCase();
/*    */     } catch (BadLocationException e) {
/* 39 */       return;
/*    */     }
/*    */     
/* 42 */     ((DefaultStyledDocument)getDocument()).setCharacterAttributes(0, content.length() - 1, this.normal, true);
/*    */     
/*    */ 
/*    */ 
/* 46 */     for (int i = 0; i < this.words.length; i++)
/*    */     {
/* 48 */       java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(this.words[i], 8);
/*    */       
/* 50 */       java.util.regex.Matcher matcher = pattern.matcher(content);
/*    */       
/* 52 */       while (matcher.find()) {
/* 53 */         ((DefaultStyledDocument)getDocument()).setCharacterAttributes(matcher.start(), matcher.end() - matcher.start(), this.styles[i], false);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyXMLEditor\ColorisedTextPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */