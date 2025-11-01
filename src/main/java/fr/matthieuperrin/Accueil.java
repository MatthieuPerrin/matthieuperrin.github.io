package fr.matthieuperrin;

public record Accueil(boolean french) implements Page {

	public String body() {
		return """
				<section>
				  <h3>%s</h3>
				  %s
				  %s
				</section>
				""".formatted((french ? "Bienvenue !" : "Welcome!"),about(),contact());
	}

	private String about() {
		return """
				  <article>
				    <h4>%s</h4>
				    <p>%s</p>
				    <p>%s</p>
				  </article>
				""".formatted((french ? "À propos" : "About"),p1(),p2());
	}

	private String p1() {
		if(french())
			return """
					Je suis maître de conférences à 
					<a href="https://www.univ-nantes.fr/">Nantes Université</a> 
					et membre de l'équipe 
					<a href="https://sites.google.com/site/gddlina/">GDD</a> au sein du 
					<a href="https://ls2n.fr/">LS2N</a>.
					Mes intérêts scientifiques concernent le domaine du calcul réparti, et en particulier 
					l'algorithmique dans les systèmes à passage de message, dont la spécification 
					des objets partagés faiblement cohérents et les primitives de diffusion de messages.
					""";
		else 
			return """
					I am an associate professor at 
					<a href="https://www.univ-nantes.fr/">Nantes University</a>
					and a member of the 
					<a href="https://sites.google.com/site/gddlina/">GDD</a> team at 
					<a href="https://ls2n.fr/">LS2N</a>.
					My scientific interests focus on the wide area of distributed computing, 
					and in particular algorithms in message-passing distributed systems,
					including modeling of weakly consistent shared objects and messages broadcast primitives.
					""";

	}

	private String p2() {
		if(french())
			return """
					Précédement, j'ai été postdoctorant au 
					<a href="http://www.technion.ac.il/en/">Technion</a> (Israel Institute of Technology), 
					à Haïfa, en Israël, où je travaillais avec 
					<a href="https://hagit.net.technion.ac.il/">Hagit Attiya</a>, puis au 
					<a href="https://software.imdea.org/">IMDEA Software Institute</a>, 
					à Madrid en Espagne, avec 
					<a href="http://software.imdea.org/~gotsman/">Alexey Gotsman</a>.
					J'ai soutenu ma thèse dans les équipes 
					<a href="https://sites.google.com/site/gddlina/">GDD</a> et 
					<a href="http://www.lina.univ-nantes.fr/?-AeLoS-.php">AeLoS</a> au 
					<a href="http://www.lina.univ-nantes.fr/">LINA</a> 
					(Laboratoire d'Informatique de Nantes Atlantique) à
					<a href="http://www.univ-nantes.fr">l'Université de Nantes</a>, sous la direction de 
					<a href="http://pagesperso.lina.univ-nantes.fr/~jard-c/indexe.php">Claude Jard</a> et 
					<a href="https://www.lina.univ-nantes.fr/?_Achour-MOSTEFAOUI,500_.php">Achour Mostéfaoui</a>. 
					""";
		else 
			return """
					Previously, I was a postdoctoral researcher at 
					<a href="http://www.technion.ac.il/en/">Technion</a> (Israel Institute of Technology), 
					in Haïfa, Israël, where I worked with 
					<a href="https://hagit.net.technion.ac.il/">Hagit Attiya</a> and then at 
					<a href="https://software.imdea.org/">IMDEA Software Institute</a>, in Madrid, Spain, with 
					<a href="http://software.imdea.org/~gotsman/">Alexey Gotsman</a>.
					I defended my PhD thesis in the 
					<a href="https://sites.google.com/site/gddlina/">GDD</a> and 
					<a href="http://www.lina.univ-nantes.fr/?-AeLoS,280-.php">AeLoS</a> teams of the 
					<a href="www.lina.univ-nantes.fr/?lang=en">LINA</a> (Laboratoire d'Informatique de Nantes Atlantique) at 
					the University of Nantes under the supervision of 
					<a href="http://pagesperso.lina.univ-nantes.fr/~jard-c/indexe.php">Claude Jard</a> and 
					<a href="https://www.lina.univ-nantes.fr/?_Achour-MOSTEFAOUI,500_.php">Achour Mostéfaoui</a>. 
					""";
	}

	public String contact() {
		return """
				  <article>
				    <h4>Contact</h4>
				    <table>
				      <tbody>
				        <tr>
				          <th>%s</th>
				          <td>
						    LS2N, Faculté des Sciences et Techniques<br>
						    2, Rue de la Houssinière BP 92208<br>
						    44322 Nantes Cedex 03<br>
						    France
				          </td>
						</tr>
				        <tr><th>%s</th><td>34-410</td></tr>
						<tr>
						  <th>Email</th>
						  <td><a href="mailto:matthieu.perrin@univ-nantes.fr">matthieu.perrin@univ-nantes.fr</a></td>
						</tr>
						<tr><th>%s</th><td>+33 2 51 12 58 32</td></tr>
					  </tbody>
					</table>
				  </article>
				""".formatted(
						(french ? "Adresse" : "Address"),
						(french ? "Bureau" : "Office"),
						(french ? "Téléphone" : "Phone")
						);
	}

	public String footerMessage() {
		return french?
				"Lac du Tachuy, Val d'Aoste, Italie"
				:"South face of Mont Blanc from Deffeyes' hut, Aosta valley, Italy";
	}

	public String footerImage() {
		return french?
				"img/lac.jpg"
				:"img/mont_blanc.jpg";
	}

}

