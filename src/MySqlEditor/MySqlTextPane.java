/*     */ package MySqlEditor;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.regex.Matcher;
/*     */ import javax.swing.text.Style;
/*     */ import javax.swing.text.StyleConstants;
/*     */ import javax.swing.text.StyleContext;
/*     */ 
/*     */ public class MySqlTextPane extends ColorisedTextPane
/*     */ {
/*     */   public MySqlTextPane()
/*     */   {
/*  13 */     initStyles();
/*     */   }
/*     */   
/*     */   protected void initStyles()
/*     */   {
/*  18 */     this.words = new String[] { "ADD |ALL |ALTER |ANALYZE |AND |AS |AUTO_INCREMENT |ASC |ASENSITIVE |BEFORE |BETWEEN |BIGINT |BOOL |BINARY |BLOB |BOTH |BY |CALL |CASCADE |CASE |CHANGE |CHAR |CHARACTER |CHECK |COLLATE |COLUMN |CONDITION |CONSTRAINT |CONTINUE |CONVERT |CREATE |CROSS |CURRENT_DATE |CURRENT_TIME |CURRENT_TIMESTAMP |CURRENT_USER |CURSOR |DATABASE |DATABASES |DAY_HOUR |DAY_MICROSECOND |DAY_MINUTE |DAY_SECOND |DEC |DECIMAL |DECLARE |DEFAULT |DELAYED |DELETE |DESC |DESCRIBE |DETERMINISTIC |DISTINCT |DISTINCTROW |DIV |DOUBLE |DROP |DUAL |EACH |ELSE |ELSEIF |ENCLOSED |ESCAPED |EXISTS |EXIT |EXPLAIN |FALSE |FETCH |FLOAT |FLOAT4 |FLOAT8 | FOR |FORCE |FOREIGN |FROM |FULLTEXT |TEXT |GRANT |GROUP |HAVING |HIGH_PRIORITY |HOUR_MICROSECOND |HOUR_MINUTE |UR_SECOND | IF |IGNORE | IN |INDEX |INFILE |INNER |INOUT |INSENSITIVE |INSERT |INT |INT1 |INT2 |INT3 |INT4 |INT8 |INTEGER |INTERVAL |INTO |IS |ITERATE |JOIN |KEY |KEYS |KILL |LEADING |LEAVE |LEFT |LIKE |LIMIT |LINES |LOAD |LOCALTIME |LOCALTIMESTAMP |LOCK |LONG |LONGBLOB |LONGTEXT |LOOP |LOW_PRIORITY |MATCH |MEDIUMBLOB |MEDIUMINT |MEDIUMTEXT |MIDDLEINT |MINUTE_MICROSECOND |MINUTE_SECOND |MOD |MODIFIES |NATURAL |NOT |NO_WRITE_TO_BINLOG |NULL |NUMERIC | ON |OPTIMIZE |OPTION |OPTIONALLY |OR |ORDER |OUT |OUTER |OUTFILE |PRECISION |PRIMARY |PROCEDURE |PURGE |READ |READS |REAL |REFERENCES |REGEXP |RELEASE |RENAME |REPEAT |REPLACE |REQUIRE |RESTRICT |RETURN |REVOKE |RIGHT |RLIKE |SCHEMA |SCHEMAS |SECOND_MICROSECOND |SELECT |SENSITIVE |SEPARATOR |SET |SHOW |SMALLINT |SONAME |SPATIAL |SPECIFIC |SQL |SQLEXCEPTION |SQLSTATE |SQLWARNING |SQL_BIG_RESULT |SQL_CALC_FOUND_ROWS |SQL_SMALL_RESULT |SSL |STARTING |STRAIGHT_JOIN |TABLE |TERMINATED |THEN |TINYBLOB |TINYINT |TINYTEXT | TO |TRAILING |TRIGGER |TRUE |UNDO |UNION |UNIQUE |UNLOCK |UNSIGNED |UPDATE |USAGE |USE |USING |UTC_DATE |DATE |UTC_TIME |UTC_TIMESTAMP |VALUES |VARBINARY |VARCHAR |VARCHARACTER |VARYING |WHEN |WHERE |WHILE |WITH |WRITE |XOR |YEAR_MONTH |ZEROFILL |ASENSITIVE |CALL |CONDITION |CONTINUE |CURSOR |DECLARE |DETERMINISTIC |EACH |ELSEIF |EXIT |FETCH |INOUT |INSENSITIVE |ITERATE |LEAVE |LOOP |MODIFIES |OUT |READS |RELEASE |REPEAT |RETURN |SCHEMA |SCHEMAS |SENSITIVE |SPECIFIC |SQL |SQLEXCEPTION |SQLSTATE |SQLWARNING |TRIGGER |UNDO |WHILE ", "[\"][\000-￿]*?\"", "[{},;:\\[\\]]", "[/*][\000-￿]*? */", "//.*", "", "[(][0-9]*?[)]|[(][0-9]*?[,][0-9]*?[)]" };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  50 */     StyleContext sc = new StyleContext();
/*  51 */     this.normal = sc.addStyle("normal", null);
/*  52 */     this.normal.addAttribute(StyleConstants.Foreground, Color.BLACK);
/*  53 */     this.normal.addAttribute(StyleConstants.FontSize, new Integer(12));
/*  54 */     this.normal.addAttribute(StyleConstants.FontFamily, "Lucida Console");
/*  55 */     this.normal.addAttribute(StyleConstants.Bold, new Boolean(false));
/*  56 */     this.styles = new Style[7];
/*     */     
/*  58 */     this.styles[0] = sc.addStyle("KeysWord", null);
/*  59 */     this.styles[0].addAttribute(StyleConstants.Foreground, Color.BLUE);
/*  60 */     this.styles[0].addAttribute(StyleConstants.FontSize, new Integer(12));
/*  61 */     this.styles[0].addAttribute(StyleConstants.FontFamily, "Lucida Console");
/*  62 */     this.styles[0].addAttribute(StyleConstants.Bold, new Boolean(true));
/*     */     
/*  64 */     this.styles[1] = sc.addStyle("string", null);
/*  65 */     Color cl = new Color(211, 111, 56);
/*  66 */     this.styles[1].addAttribute(StyleConstants.Foreground, cl);
/*  67 */     this.styles[1].addAttribute(StyleConstants.FontSize, new Integer(12));
/*  68 */     this.styles[1].addAttribute(StyleConstants.FontFamily, "Courier New");
/*  69 */     this.styles[1].addAttribute(StyleConstants.Italic, new Boolean(true));
/*     */     
/*     */ 
/*  72 */     this.styles[2] = sc.addStyle("ponctuation", null);
/*  73 */     this.styles[2].addAttribute(StyleConstants.Foreground, Color.BLACK);
/*  74 */     this.styles[2].addAttribute(StyleConstants.FontSize, new Integer(12));
/*  75 */     this.styles[2].addAttribute(StyleConstants.FontFamily, "Courier New");
/*  76 */     this.styles[2].addAttribute(StyleConstants.Bold, new Boolean(true));
/*     */     
/*  78 */     this.styles[3] = sc.addStyle("comment", null);
/*  79 */     this.styles[3].addAttribute(StyleConstants.Foreground, Color.gray);
/*  80 */     this.styles[3].addAttribute(StyleConstants.FontSize, new Integer(12));
/*  81 */     this.styles[3].addAttribute(StyleConstants.FontFamily, "Courier New");
/*  82 */     this.styles[3].addAttribute(StyleConstants.Italic, new Boolean(true));
/*     */     
/*  84 */     this.styles[4] = sc.addStyle("comment", null);
/*  85 */     this.styles[4].addAttribute(StyleConstants.Foreground, Color.gray);
/*  86 */     this.styles[4].addAttribute(StyleConstants.FontSize, new Integer(12));
/*  87 */     this.styles[4].addAttribute(StyleConstants.FontFamily, "Courier New");
/*  88 */     this.styles[4].addAttribute(StyleConstants.Italic, new Boolean(true));
/*     */     
/*  90 */     this.styles[5] = sc.addStyle("findWord", null);
/*  91 */     this.styles[5].addAttribute(StyleConstants.Background, Color.yellow);
/*     */     
/*  93 */     this.styles[6] = sc.addStyle("Number", null);
/*  94 */     this.styles[6].addAttribute(StyleConstants.Foreground, Color.ORANGE);
/*  95 */     this.styles[6].addAttribute(StyleConstants.FontSize, new Integer(12));
/*  96 */     this.styles[6].addAttribute(StyleConstants.FontFamily, "Lucida Console");
/*  97 */     this.styles[6].addAttribute(StyleConstants.SpaceAbove, new Boolean(true));
/*     */   }
/*     */   
/*     */   public int findWord(String txt)
/*     */   {
/* 102 */     String content = null;
/* 103 */     int result = -1;
/*     */     try {
/* 105 */       javax.swing.text.Document d = getDocument();
/* 106 */       content = d.getText(0, d.getLength());
/*     */     } catch (javax.swing.text.BadLocationException e) {
/* 108 */       return result;
/*     */     }
/*     */     
/* 111 */     java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(txt);
/*     */     
/* 113 */     Matcher matcher = pattern.matcher(content);
/* 114 */     while (matcher.find()) {
/* 115 */       ((javax.swing.text.DefaultStyledDocument)getDocument()).setCharacterAttributes(matcher.start(), matcher.end() - matcher.start(), this.styles[5], false);
/* 116 */       if (result == -1) result = matcher.start();
/*     */     }
/* 118 */     return result;
/*     */   }
/*     */   
/*     */   public void colorise()
/*     */     throws javax.swing.text.BadLocationException
/*     */   {}
/*     */ }


/* Location:              D:\Alexis\Desktop\JMerise\JMerise05\JMerise.jar!\MySqlEditor\MySqlTextPane.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */