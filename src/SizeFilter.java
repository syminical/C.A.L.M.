
//theworldisquiethere

import javax.swing.text.*;

public class SizeFilter extends DocumentFilter {  

	private final int maxLength;

 	public SizeFilter (int maxLength) {  

    		this.maxLength = maxLength;

 	}  

	 public void insertString (DocumentFilter.FilterBypass fb, int offset, String str, AttributeSet attr) throws BadLocationException {
  	 	
		str = str.replace("\n", "");

		if ((fb.getDocument().getLength() + str.length()) <= this.maxLength)
            	
			super.insertString(fb, offset, str, attr);

	 }  

 	public void replace (DocumentFilter.FilterBypass fb, int offset, int length, String str, AttributeSet attrs) throws BadLocationException {
    
		str = str.replace("\n", "");		

		if ((fb.getDocument().getLength() + str.length()) <= this.maxLength)
            
			super.replace(fb, offset, length, str, attrs);

 	}

}
