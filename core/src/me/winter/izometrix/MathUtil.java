package me.winter.izometrix;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathUtil
{
	public static double round(double value, int decimals)
	{
	    if (decimals < 0) throw new IllegalArgumentException();

	    return new BigDecimal(value).setScale(decimals, RoundingMode.HALF_UP).doubleValue();
	}
}
