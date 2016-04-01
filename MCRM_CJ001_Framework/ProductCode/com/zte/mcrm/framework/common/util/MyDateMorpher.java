package com.zte.mcrm.framework.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import net.sf.ezmorph.MorphException;
import net.sf.ezmorph.object.AbstractObjectMorpher;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public final class MyDateMorpher extends AbstractObjectMorpher {
	private Date defaultValue;
	private String[] formats;
	private boolean lenient;
	private Locale locale;

	public MyDateMorpher(String[] formats) {
		this(formats, Locale.getDefault(), false);
	}

	public MyDateMorpher(String[] formats, boolean lenient) {
		this(formats, Locale.getDefault(), lenient);
	}

	public MyDateMorpher(String[] formats, Date defaultValue) {
		this(formats, defaultValue, Locale.getDefault(), false);
	}

	public MyDateMorpher(String[] formats, Date defaultValue, Locale locale,
			boolean lenient) {
		super(true);
		if ((formats == null) || (formats.length == 0)) {
			throw new MorphException("invalid array of formats");
		}

		this.formats = formats;

		if (locale == null)
			this.locale = Locale.getDefault();
		else {
			this.locale = locale;
		}

		this.lenient = lenient;
		setDefaultValue(defaultValue);
	}

	public MyDateMorpher(String[] formats, Locale locale) {
		this(formats, locale, false);
	}

	public MyDateMorpher(String[] formats, Locale locale, boolean lenient) {
		if ((formats == null) || (formats.length == 0)) {
			throw new MorphException("invalid array of formats");
		}

		this.formats = formats;

		if (locale == null)
			this.locale = Locale.getDefault();
		else {
			this.locale = locale;
		}

		this.lenient = lenient;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof MyDateMorpher)) {
			return false;
		}

		MyDateMorpher other = (MyDateMorpher) obj;
		EqualsBuilder builder = new EqualsBuilder();
		builder.append(this.formats, other.formats);
		builder.append(this.locale, other.locale);
		builder.append(this.lenient, other.lenient);
		if ((super.isUseDefault()) && (other.isUseDefault())) {
			builder.append(getDefaultValue(), other.getDefaultValue());
			return builder.isEquals();
		}
		if ((!super.isUseDefault()) && (!other.isUseDefault())) {
			return builder.isEquals();
		}
		return false;
	}

	public Date getDefaultValue() {
		return (Date) this.defaultValue.clone();
	}

	@Override
	public int hashCode() {
		HashCodeBuilder builder = new HashCodeBuilder();
		builder.append(this.formats);
		builder.append(this.locale);
		builder.append(this.lenient);
		if (super.isUseDefault()) {
			builder.append(getDefaultValue());
		}
		return builder.toHashCode();
	}

	@Override
	public Object morph(Object value) {
		if ((value == null) || ("".equals(value))) {
			return null;
		}

		if (Date.class.isAssignableFrom(value.getClass())) {
			return value;
		}

		if (!supports(value.getClass())) {
			throw new MorphException(value.getClass() + " is not supported");
		}

		String strValue = (String) value;
		SimpleDateFormat dateParser = null;
		SimpleDateFormat timeParser = null;

		int i = 0;
		if (dateParser == null){
			dateParser = new SimpleDateFormat(this.formats[0], this.locale);
			timeParser = new SimpleDateFormat(this.formats[1], this.locale);
		}
		else {
			dateParser.applyPattern(this.formats[i]);
		}
		dateParser.setLenient(this.lenient);
		try {
			 String stv = strValue.toLowerCase();
			 if(stv.contains("T")||stv.contains("t")){
				 stv = stv.replace("t", " ");
				 stv = stv.replace("T", " ");
			 }
			 if(stv.length()>16||stv.contains("日")){//日期
				 Date date =  timeParser.parse(stv);
				 return date;
			 }else{//时间
				 Date date =  dateParser.parse(stv);
				 return date;
			 }
		} catch (ParseException localParseException) {
			do
				++i;
			while (i < this.formats.length);

			if (super.isUseDefault()) {
				return this.defaultValue;
			}
			throw new MorphException("Unable to parse the date " + value);
		}
	}

	@Override
	public Class morphsTo() {
		return Date.class;
	}

	public void setDefaultValue(Date defaultValue) {
		this.defaultValue = ((Date) defaultValue.clone());
	}

	@Override
	public boolean supports(Class clazz) {
		return String.class.isAssignableFrom(clazz);
	}
}
