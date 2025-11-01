package fr.matthieuperrin;

public record Reference (
		String address,
		String frenchText,
		String englishText
		) {

	public String toHTML(boolean french) {
		return "[ <a href=\"" + address +"\">"+ (french?frenchText:englishText) +"</a> ]";
	}

}
