package fr.matthieuperrin;

public record NavItem(String fr, String en) {
	
	public String asString(String name, boolean french) {
		return """
				<li%s>
				  <a href="%s_%s.html">
				    %s
				  </a>
				</li>
				""".formatted(
						(fr.equals(name) ? " class=\"current\"" : ""), 
						fr,
						(french?"fr":"en"), 
						(french? fr : en));
	}

	public final static NavItem HOME = new NavItem("Accueil", "Home");
	public final static NavItem RESEARCH = new NavItem("Recherche", "Research");
	public final static NavItem TEACHING = new NavItem("Enseignement", "Teaching");

	public static String navItems(String current, boolean french) {
		return NavItem.HOME.asString(current, french)
				+ NavItem.RESEARCH.asString(current, french)
				+ NavItem.TEACHING.asString(current, french);
	}
	
}

