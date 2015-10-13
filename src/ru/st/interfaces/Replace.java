package ru.st.interfaces;

import ru.st.interfaces.printer.AdvancePrinter;
import ru.st.interfaces.printer.ConsolePrinter;
import ru.st.interfaces.printer.IPrinter;
import ru.st.interfaces.reader.IReader;
import ru.st.interfaces.reader.PredefinedReader;

public class Replace {
	private final IPrinter printer;
	private final IReader  reader;
	
	public Replace(final IPrinter printer, final IReader  reader) {
		this.printer = printer;
		this.reader = reader;
		
	}
	
	public void replace(){
		final String text = reader.read();
		final String replaceText = text.replace(":)", "::)");
		printer.print(replaceText);
	}
	
	public static void main(String[] args) {
        final IReader reader = new PredefinedReader("привет :) и ещё привет :)");
        final IPrinter printer = new ConsolePrinter();
        final IPrinter advancePrinter = new AdvancePrinter();
        final Replace replace =  new Replace(printer, reader);
        final Replace adPrinter = new Replace(advancePrinter, reader);
        Replace place =  new Replace(printer, reader);
        replace.replace();
        adPrinter.replace();
        place.replace();
    }
	
}
