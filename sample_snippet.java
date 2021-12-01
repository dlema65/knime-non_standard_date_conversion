// system imports
import org.knime.base.node.jsnippet.expression.AbstractJSnippet;
import org.knime.base.node.jsnippet.expression.Abort;
import org.knime.base.node.jsnippet.expression.Cell;
import org.knime.base.node.jsnippet.expression.ColumnException;
import org.knime.base.node.jsnippet.expression.TypeException;
import static org.knime.base.node.jsnippet.expression.Type.*;
import java.util.Date;
import java.util.Calendar;
import org.w3c.dom.Document;

// imports for input and output fields
import java.time.LocalDateTime;

// Your custom imports:
import java.util.Map;
import java.util.HashMap;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;



// system variables
public class JSnippet extends AbstractJSnippet {
  // Fields for input columns
  /** Input column: "Fechas Ejemplo" */
  public String c_FechasEjemplo;

  // Fields for output columns
  /** Output column: "Fecha Convertida" */
  public LocalDateTime out_FechaConvertida;

// Your custom variables:

static Map<Long, String> monthNameMap = new HashMap<>();
static Map<Long, String> ampmMap = new HashMap<>();

static {
	monthNameMap.put(1L, "Ene");
	monthNameMap.put(2L, "Feb");
	monthNameMap.put(3L, "Mar");
	monthNameMap.put(4L, "Abr");
	monthNameMap.put(5L, "May");
	monthNameMap.put(6L, "Jun");
	monthNameMap.put(7L, "Jul");
	monthNameMap.put(8L, "Ago");
	monthNameMap.put(9L, "Sep");
	monthNameMap.put(10L, "Oct");
	monthNameMap.put(11L, "Nov");
	monthNameMap.put(12L, "Dic");
	
	ampmMap.put(0L, "am");
	ampmMap.put(1L, "pm");
}

// formato MMM dd, yyyy hh:mm[:ss[.SSS]] a

DateTimeFormatter fmt = new DateTimeFormatterBuilder()
		     .parseCaseInsensitive()
			.appendText(ChronoField.MONTH_OF_YEAR, monthNameMap)
		     .appendPattern(" dd, yyyy hh:mm:[ss[.SSS]] ")
		    	.appendText(ChronoField.AMPM_OF_DAY, ampmMap)
		    	.toFormatter(new Locale("es", "CO"));


// expression start
    public void snippet() throws TypeException, ColumnException, Abort {
// Enter your code here:

out_FechaConvertida = LocalDateTime.parse(c_FechasEjemplo, fmt);


// expression end
    }
}
