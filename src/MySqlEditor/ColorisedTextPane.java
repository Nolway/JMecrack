/*    */ package MySqlEditor;
/*    */ 
/*    */ import java.util.regex.Matcher;
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
/* 15 */     setDocument(new DefaultStyledDocument()
/*    */     {
/*    */       public void insertString(int arg0, String arg1, javax.swing.text.AttributeSet arg2) throws BadLocationException {
/* 18 */         super.insertString(arg0, arg1, arg2);
/* 19 */         ColorisedTextPane.this.colorise();
/*    */       }
/*    */       
/*    */       public void remove(int arg0, int arg1) throws BadLocationException {
/* 23 */         super.remove(arg0, arg1);
/* 24 */         ColorisedTextPane.this.colorise();
/*    */       }
/*    */       
/* 27 */     });
/* 28 */     initStyles();
/*    */   }
/*    */   
/*    */   protected abstract void initStyles();
/*    */   
/* 33 */   private void colorise() throws BadLocationException { if (this.words.length < this.styles.length) { throw new ArrayIndexOutOfBoundsException();
/*    */     }
/* 35 */     String content = null;
/*    */     try {
/* 37 */       javax.swing.text.Document d = getDocument();
/* 38 */       content = d.getText(0, d.getLength()).toUpperCase();
/*    */     } catch (BadLocationException e) {
/* 40 */       return;
/*    */     }
/*    */     
/* 43 */     ((DefaultStyledDocument)getDocument()).setCharacterAttributes(0, content.length() - 1, this.normal, true);
/*    */     
/*    */ 
/*    */ 
/* 47 */     for (int i = 0; i < this.words.length; i++)
/*    */     {
/* 49 */       java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(this.words[i], 8);
/*    */       
/* 51 */       Matcher matcher = pattern.matcher(content);
/*    */       
/* 53 */       while (matcher.find()) {
/* 54 */         ((DefaultStyledDocument)getDocument()).setCharacterAttributes(matcher.start(), matcher.end() - matcher.start(), this.styles[i], false);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MySqlEditor\ColorisedTextPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */