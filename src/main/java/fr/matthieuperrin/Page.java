package fr.matthieuperrin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

public interface Page {

	String body();
	boolean french();
	
	default String name() {
		return getClass().getSimpleName();
	}

	default String description() {
		return french() ?
				"Bienvenue sur la page personelle de Matthieu Perrin"
				: "Welcome to Matthieu Perrin's personal Web page";
	}

	default String keywords() {
		return french() ?
				"Matthieu, Perrin, Nantes, LS2N, GDD, informatique, Nantes Université"
				: "Matthieu, Perrin, Nantes, LS2N, GDD, computer science, Nantes University";
	}

	default String headerImage() {
		return "img/moi.jpg";
	}

	default String headerText() {
		if(french()) {
			return """
					<h1>Matthieu Perrin</h1>
					<h2>
					  Maître de conférences<br> 
					  à Nantes Université<br>
					  LS2N, équipe GDD
					</h2>
					""";
		} else {
			return """
					<h1>Matthieu Perrin</h1>
					<h2>
					  Associate professor<br> 
					  at Nantes University<br>
					  LS2N, GDD team
					</h2>
					""";
		}
	}

	String footerMessage();
	String footerImage();

	default String page() {
		return """
				<!DOCTYPE html>
				  <html>
				    <head>
				      <meta charset="utf-8" />
				      <title>Matthieu Perrin</title>
				      <meta name="viewport" content="initial-scale=1.0, user-scalable=yes" />
				      <meta name="description" content="%s" />
				      <meta name="keywords" content="%s" />
				      <meta name="author" content="Matthieu Perrin" />
				      <!--[if lt IE 9]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
				      <link rel="stylesheet" href="style.css" type="text/css" />
				    </head>
				    <body>
				      <div class="container">
					    <header>%s</header>
					    <nav>%s</nav>
				        %s
				        <div class="links">%s</div>
				        <footer>%s</footer>
				      </div>
				    </body>
				  </html>
				""".formatted(
						description(),
						keywords(),
						header(), 
						nav(), 
						body(), 
						link(), 
						footer());
	}

	default String header() {
		return """
				<img alt="" src="%s">
				<section>%s</section>
				""".formatted(headerImage(), headerText());
	}

	default String nav() {
		String other_language = french() ? "en" : "fr";
		return """
				<ul>%s</ul>
				<a class="lang" href=%s_%s.html>
				<img alt="%s" height="20" src="img/flag_%s_small.png" </img>
				</a>
				""".formatted(NavItem.navItems(name(), french()), name(), other_language, other_language, other_language);
	}
	
	default String link() {
		return "%s<p class=\"up\">%s</p>".formatted(
				(french() ? FooterLink.linkFR() : FooterLink.linkEN()),
				lastUpdate());
	}

	default String footer() {
		String message = footerMessage();
		return """
				  <img alt="%s" title="%s" width="%s" src="%s">
				""".formatted(message, message, "100%", footerImage());
	}

	default void generatePage(String path) throws IOException {
		Files.createFile(Path.of(path));
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, false))) {
			writer.write(page());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	default String lastUpdate() {
		var now = LocalDateTime.now();
		return now.getDayOfMonth() + "/" + now.getMonthValue() + "/" + now.getYear();
	}

	default String language() {
		return french() ? "fr" : "en";
	}

}