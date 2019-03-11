package com.oks.service;

import java.text.ParseException;
import java.util.Set;

public interface QuartStrategy {
	
	Set<String> compareStock() throws ParseException;
	
	String getResult() throws ParseException;

}
