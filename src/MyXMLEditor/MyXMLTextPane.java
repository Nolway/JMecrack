/*    */ package MyXMLEditor;
/*    */ 
/*    */ import java.awt.Color;
/*    */ import java.util.regex.Matcher;
/*    */ import javax.swing.text.Style;
/*    */ import javax.swing.text.StyleConstants;
/*    */ import javax.swing.text.StyleContext;
/*    */ 
/*    */ public class MyXMLTextPane extends ColorisedTextPane
/*    */ {
/*    */   public MyXMLTextPane()
/*    */   {
/* 13 */     initStyles();
/*    */   }
/*    */   
/*    */   protected void initStyles() {
/* 17 */     this.words = new String[] { "<!ELEMENT |<!ATTLIST |ID |IDREF |CDATA ", "[\"][\000-￿]*?\"", "[[<][>]]", "[<!--][\000-￿]*? -->", "EMPTY ", "#REQUIRED ", "" };
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 26 */     StyleContext sc = new StyleContext();
/* 27 */     this.normal = sc.addStyle("normal", null);
/* 28 */     this.normal.addAttribute(StyleConstants.Foreground, Color.BLACK);
/* 29 */     this.normal.addAttribute(StyleConstants.FontSize, new Integer(12));
/* 30 */     this.normal.addAttribute(StyleConstants.FontFamily, "Lucida Console");
/* 31 */     this.normal.addAttribute(StyleConstants.Bold, new Boolean(false));
/* 32 */     this.styles = new Style[7];
/*    */     
/* 34 */     this.styles[0] = sc.addStyle("KeysWord", null);
/* 35 */     this.styles[0].addAttribute(StyleConstants.Foreground, Color.BLUE);
/* 36 */     this.styles[0].addAttribute(StyleConstants.FontSize, new Integer(12));
/* 37 */     this.styles[0].addAttribute(StyleConstants.FontFamily, "Lucida Console");
/* 38 */     this.styles[0].addAttribute(StyleConstants.Bold, new Boolean(true));
/*    */     
/* 40 */     this.styles[1] = sc.addStyle("string", null);
/* 41 */     Color cl = new Color(211, 111, 56);
/* 42 */     this.styles[1].addAttribute(StyleConstants.Foreground, cl);
/* 43 */     this.styles[1].addAttribute(StyleConstants.FontSize, new Integer(12));
/* 44 */     this.styles[1].addAttribute(StyleConstants.FontFamily, "Courier New");
/* 45 */     this.styles[1].addAttribute(StyleConstants.Italic, new Boolean(true));
/*    */     
/*    */ 
/* 48 */     this.styles[2] = sc.addStyle("ponctuation", null);
/* 49 */     this.styles[2].addAttribute(StyleConstants.Foreground, Color.BLACK);
/* 50 */     this.styles[2].addAttribute(StyleConstants.FontSize, new Integer(12));
/* 51 */     this.styles[2].addAttribute(StyleConstants.FontFamily, "Courier New");
/* 52 */     this.styles[2].addAttribute(StyleConstants.Bold, new Boolean(true));
/*    */     
/* 54 */     this.styles[3] = sc.addStyle("comment", null);
/* 55 */     this.styles[3].addAttribute(StyleConstants.Foreground, Color.gray);
/* 56 */     this.styles[3].addAttribute(StyleConstants.FontSize, new Integer(12));
/* 57 */     this.styles[3].addAttribute(StyleConstants.FontFamily, "Courier New");
/* 58 */     this.styles[3].addAttribute(StyleConstants.Italic, new Boolean(true));
/*    */     
/* 60 */     this.styles[4] = sc.addStyle("keyword2", null);
/* 61 */     this.styles[4].addAttribute(StyleConstants.Foreground, Color.GREEN);
/* 62 */     this.styles[4].addAttribute(StyleConstants.FontSize, new Integer(12));
/* 63 */     this.styles[4].addAttribute(StyleConstants.FontFamily, "Courier New");
/* 64 */     this.styles[4].addAttribute(StyleConstants.Italic, new Boolean(true));
/*    */     
/* 66 */     this.styles[5] = sc.addStyle("keyword3", null);
/* 67 */     cl = new Color(211, 111, 76);
/* 68 */     this.styles[5].addAttribute(StyleConstants.Foreground, cl);
/* 69 */     this.styles[5].addAttribute(StyleConstants.FontSize, new Integer(12));
/* 70 */     this.styles[5].addAttribute(StyleConstants.FontFamily, "Courier New");
/* 71 */     this.styles[5].addAttribute(StyleConstants.Italic, new Boolean(true));
/*    */     
/* 73 */     this.styles[6] = sc.addStyle("findWord", null);
/* 74 */     this.styles[6].addAttribute(StyleConstants.Background, Color.yellow);
/*    */   }
/*    */   
/*    */   public int findWord(String txt) {
/* 78 */     String content = null;
/* 79 */     int result = -1;
/*    */     try {
/* 81 */       javax.swing.text.Document d = getDocument();
/* 82 */       content = d.getText(0, d.getLength());
/*    */     } catch (javax.swing.text.BadLocationException e) {
/* 84 */       return result;
/*    */     }
/*    */     
/* 87 */     java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(txt);
/*    */     
/* 89 */     Matcher matcher = pattern.matcher(content);
/* 90 */     while (matcher.find()) {
/* 91 */       ((javax.swing.text.DefaultStyledDocument)getDocument()).setCharacterAttributes(matcher.start(), matcher.end() - matcher.start(), this.styles[5], false);
/* 92 */       if (result == -1) result = matcher.start();
/*    */     }
/* 94 */     return result;
/*    */   }
/*    */   
/*    */   public void colorise()
/*    */     throws javax.swing.text.BadLocationException
/*    */   {}
/*    */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MyXMLEditor\MyXMLTextPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */