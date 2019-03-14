package cn.hwd.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class HelloTag extends SimpleTagSupport {

	private String message;
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (message != null) {
			/* ��������ʹ����Ϣ */
			JspWriter out = getJspContext().getOut();
		    out.println(message);
		} else {
			/* ����������ʹ����Ϣ */
			StringWriter sw = new StringWriter();
			getJspBody().invoke(sw);
	        getJspContext().getOut().println(sw.toString());
		}
	}

}
