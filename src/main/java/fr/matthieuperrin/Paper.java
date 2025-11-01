package fr.matthieuperrin;

import java.util.List;

public record Paper(
		String address,
		String title,
		String editor,
		List<String> authors,
		List<Reference> refs
		) {

	public Paper(String address, String title, String editor) {
		this(address, title, editor, List.of(), List.of());
	}
	
	
	public String toHTML(boolean french) {

		String authorlist = ""; 
		for(int i = 0; i<authors.size(); i++) {
			if(i==0) {
				authorlist += french ? "avec " : "with "; 
				authorlist += authors.get(i);
			} else if(i==authors.size() - 1) {
				authorlist += french ? " et " : " and "; 
				authorlist += authors.get(i);
			} else {
				authorlist += ", "; 
				authorlist += authors.get(i);
			}
		}
		if(authorlist != "") authorlist += "<br>";
		
		
		String refslist = "";
		for(var ref : refs) refslist+=ref.toHTML(french);
		if(refslist != "") refslist += "<br>";

		String editor = this.editor;
		if(editor != "") editor = "<i>%s</i><br>".formatted(editor);
		
		return """
				<li>
				  <strong><a href="%s">%s</a></strong><br>
				  %s%s%s
				</li>
				""".formatted(address, title, authorlist, editor, refslist);
	}
	
	public String toJava() {

		String authorlist = ""; 
		for(int i = 0; i<authors.size(); i++) {
			authorlist += (i==0?"\"":", \"") + authors.get(i) + "\"";
		}
		
		String refslist = "";
		for(int i = 0; i<refs.size(); i++) {
			var ref = refs.get(i);
			if(i==0) refslist += ",\n";
			refslist += """
					new Reference(
						"%s",
						"%s", "%s"
					)""".formatted(ref.address(), ref.frenchText(), ref.englishText());
		}

		new Reference(
				"https://hal.archives-ouvertes.fr/hal-02279523/document",
				"article", "article"
				);
		
		return """
				new Paper("%s",
						"%s",
						"%s",
						List.of(%s),
						List.of(%s)
						)""".formatted(address, title, editor, authorlist, refslist);
	}

}

