package fr.matthieuperrin;

public record FooterLink(String alt, String src, String href) {
	
	public String toString() {
		return """
				<li>
				  <a href="%s">
				    <img alt="%s" height="20" src="%s">
				  </a>
				</li>
				""".formatted(href, alt, src);
	}
	
	public final static FooterLink HAL        = new FooterLink("Hal", "img/hal.png", "https://cv.archives-ouvertes.fr/matthieu-perrin");
	public final static FooterLink DBLP       = new FooterLink("DBLP", "img/dblp.png", "http://dblp.uni-trier.de/pers/hd/p/Perrin:Matthieu");
	public final static FooterLink SCHOLAR_FR = new FooterLink("Google Scholar", "img/scholar.png", "https://scholar.google.fr/citations?user=WlNyiPkAAAAJ&hl=fr");
	public final static FooterLink SCHOLAR_EN = new FooterLink("Google Scholar", "img/scholar.png", "https://scholar.google.com/citations?user=WlNyiPkAAAAJ&hl=en");
	public final static FooterLink RGATE      = new FooterLink("ResearchGate", "img/researchgate.png", "https://www.researchgate.net/profile/Matthieu_Perrin");

	public final static String linkEN() {
		return "<ul>%s%s%s%s</ul>".formatted(HAL, DBLP, SCHOLAR_EN, RGATE);
	}

	public final static String linkFR() {
		return "<ul>%s%s%s%s</ul>".formatted(HAL, DBLP, SCHOLAR_FR, RGATE);
	}
	
	
}

