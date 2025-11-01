package fr.matthieuperrin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) throws IOException {
		delete(new File("docs/"));
		copy("static", "docs");
		new Accueil(true).generatePage("docs/Accueil_fr.html");
		new Accueil(false).generatePage("docs/Accueil_en.html");
		new Recherche(true).generatePage("docs/Recherche_fr.html");
		new Recherche(false).generatePage("docs/Recherche_en.html");
		new Enseignement(true).generatePage("docs/Enseignement_fr.html");
		new Enseignement(false).generatePage("docs/Enseignement_en.html");
	}

	private static void copy(String source, String target) throws IOException {
		File sourceFile = new File(source);
		File targetFile = new File(target);
		if(sourceFile.isDirectory()) {
			if (!targetFile.exists()) {
				targetFile.mkdir();
			}
			for (String child : sourceFile.list()) {
				copy(source + "/" + child, target + "/" + child);
			}
		} else {
			Files.copy(Path.of(source), Path.of(target));
		}
	}

	private static void delete(File folder) throws IOException {
		if (folder.isDirectory()) {
			for (File c : folder.listFiles())
				delete(c);
		}
		Files.deleteIfExists(folder.toPath());
	}

}
