package fr.matthieuperrin;

import java.util.List;

public record Recherche(boolean french) implements Page {

	public String body() {
		return "<section><h3>" 
				+ (french?"Publications sélectionnées":"Selected publications") 
				+ "</h3>"
				+ toHTML("Abstractions de diffusion de messages", "Broadcast abstractions", List.of(
						new Paper("https://doi.org/10.4230/LIPIcs.DISC.2023.16",
								"Send/Receive Patterns Versus Read/Write Patterns in Crash-Prone Asynchronous Distributed Systems.",
								"DISC (2023)",
								List.of("Mathilde Déprés", "Achour Mostéfaoui", "Michel Raynal"),
								List.of(new Reference("https://doi.org/10.1145/3583668.3594569", "Version courte", "Short version"),
										new Reference("https://doi.org/10.1145/3663338.3663679", "Implémentation tolérante aux Byzantins", "Byzantine-tolerant implementation"),
										new Reference("https://hal.science/hal-04555445/", "Version française", "French version"))),
						new Paper("https://doi.org/10.1016/j.tcs.2021.06.044",
								"Set-constrained delivery broadcast: A communication abstraction for read/write implementable distributed objects.",
								"TCS - Theoretical Computer Science (2021)",
								List.of("Damien Imbs", "Achour Mostéfaoui", "Michel Raynal"),
								List.of(new Reference("https://doi.org/10.1145/3154273.3154296", "Version conférence", "Conference version"),
										new Reference("https://hal.archives-ouvertes.fr/hal-03304269", "pdf", "pdf"),
										new Reference("data/ICDCN_18_SCD_beamer.pdf", "Présentation", "Slides"),
										new Reference("https://doi.org/10.1109/EDCC61798.2024.00036", "Implémentation byzantine", "Byzantine-tolerant implementation"),
										new Reference("https://hal.science/hal-04567086/", "Version byzantine en français", "French Byzantine"))),
						new Paper("https://doi.org/10.4230/LIPIcs.DISC.2017.27",
								"Which Broadcast Abstraction Captures k-Set Agreement?.",
								"DISC (2017)",
								List.of("Damien Imbs", "Achour Mostéfaoui", "Michel Raynal"),
								List.of(new Reference("https://arxiv.org/abs/1705.04835", "pdf", "pdf"))),
						new Paper("https://doi.org/10.4230/LIPIcs.OPODIS.2024.21",
								"No Symmetric Broadcast Abstraction Characterizes k-Set-Agreement in Message-Passing Systems.",
								"OPODIS (2024)",
								List.of("Sylvain Gay", "Achour Mostéfaoui"),
								List.of(new Reference("https://doi.org/10.1145/3662158.3662818", "Version courte", "Short Version"))),
						new Paper("https://doi.org/10.1016/j.ipl.2019.105837",
								"Crash-tolerant causal broadcast in O(n) messages.",
								"Inf. Process. Lett. (2019)",
								List.of("Achour Mostéfaoui", "Michel Raynal", "Jiannong Cao 0001"),
								List.of(new Reference("https://hal.archives-ouvertes.fr/hal-02279523", "pdf", "pdf")))
						))
				+ toHTML("Calculabilité répartie en mémoire partagée", "Distributed computability in shared-memory systems", List.of(
						new Paper("https://doi.org/10.1007/s00446-022-00425-x",
								"Extending the wait-free hierarchy to multi-threaded systems.",
								"Distributed Comput. (2022)",
								List.of("Achour Mostéfaoui", "Grégoire Bonin", "Ludmila Courtillat-Piazza"),
								List.of(new Reference("https://doi.org/10.4230/LIPIcs.DISC.2019.38", "Version courte", "Short version"),
										new Reference("https://doi.org/10.1145/3382734.3405723", "Version conférence", "Conference version"),
										new Reference("data/PODC2020.pdf", "Présentation", "Slides"),
										new Reference("https://youtu.be/PjWRqhEzqeE", "Vidéo", "Vidéo"),
										new Reference("https://hal.science/hal-03205368/", "Version française", "French version"))),

						new Paper("https://doi.org/10.4230/LIPIcs.DISC.2021.11",
								"Wait-Free CAS-Based Algorithms: The Burden of the Past.",
								"DISC (2021)",
								List.of("Denis Bédin", "François Lépine", "Achour Mostéfaoui", "Damien Perez"),
								List.of()),
						new Paper("https://doi.org/10.1016/j.jpdc.2022.01.025",
								"Separating lock-freedom from wait-freedom at every level of the consensus hierarchy.",
								"J. Parallel Distributed Comput. (2022)",
								List.of("Hagit Attiya", "Armando Castañeda", "Danny Hendler"),
								List.of(new Reference("https://doi.org/10.1145/3212734.3212739", "Version conférence", "Conference version"))),
						new Paper("https://doi.org/10.1142/S0129626418500068",
								"A Simple Object that Spans the Whole Consensus Hierarchy.",
								"Parallel Process. Lett. (2018)",
								List.of("Achour Mostéfaoui", "Michel Raynal"),
								List.of(new Reference("https://hal.archives-ouvertes.fr/hal-02053504/document", "pdf", "pdf")))
						))
				+ toHTML("Cohérence faible des données", "Weak data consistency", List.of(
						new Paper((french?"https://iste-editions.fr/products/concurrence-et-coherence-dans-les-systemes-repartis":"https://www.elsevier.com/books/distributed-systems/perrin/978-1-78548-226-7"),
								(french?"Concurrence et cohérence dans les systèmes répartis":"Distributed Systems - Concurrency and Consistency"),
								(french?"Monographie - ISTE Press, 2017":"Monography - Elsevier & ISTE Press, 2017")),
						new Paper("http://www.theses.fr/s79439",
								"Spécification des types de données abstraits dans les systèmes répartis sans-attente",
								(french ? "Thèse de doctorat - Université de Nantes, 2016" : "PhD thesis - University of Nantes, 2016"),
								List.of(),
								List.of(new Reference(french?"data/Presentation_Matthieu_PERRIN.pdf":"data/Presentation_Matthieu_PERRIN_en.pdf", "présentation", "slides"))),
						new Paper("https://doi.org/10.1145/2851141.2851170",
								"Causal consistency: beyond memory.",
								"PPoPP (2016)",
								List.of("Achour Mostéfaoui", "Claude Jard"),
								List.of(new Reference("http://eatcs.org/beatcs/index.php/beatcs/article/view/545", "Version revue vulgarisée", "Vulgarized journal version"),
										new Reference("https://hal.archives-ouvertes.fr/hal-02053316/document", "pdf", "pdf"),
										new Reference("data/presentation_PPoPP.pdf", "Présentation", "Slides"))),
						new Paper("https://doi.org/10.1109/IPDPS.2015.39",
								"Update Consistency for Wait-Free Concurrent Objects.",
								"IPDPS (2015)",
								List.of("Achour Mostéfaoui", "Claude Jard"),
								List.of(new Reference("https://hal.archives-ouvertes.fr/hal-01079112v1", "Version courte", "Short version"),
										new Reference("data/IPDPS_15_UC_beamer.pdf", "Présentation", "Slides"))),
						new Paper("https://doi.org/10.1007/978-3-030-25636-4_31",
								"Does the Operational Model Capture Partition Tolerance in Distributed Systems?",
								"PaCT (2019)",
								List.of("Grégoire Bonin", "Achour Mostéfaoui"),
								List.of()),
						new Paper("https://doi.org/10.1109/TPDS.2022.3209150",
								"Differentiated Consistency for Worldwide Gossips.",
								"IEEE Trans. Parallel Distributed Syst. (2023)",
								List.of("Davide Frey", "Achour Mostéfaoui", "Pierre-Louis Roman", "François Taïani"),
								List.of(new Reference("https://doi.org/10.1109/SRDS.2016.032", "Version conférence", "Conference version"),
										new Reference("https://hal.archives-ouvertes.fr/hal-01344138", "pdf", "pdf")))
						))
				+ toHTML("Cohérence forte et consensus", "Strong consistency and consensus", List.of(
						new Paper("https://doi.org/10.1145/3342195.3387543",
								"State-machine replication for planet-scale systems.",
								"EuroSys (2020)",
								List.of("Vitor Enes", "Carlos Baquero", "Tuanir França Rezende", "Alexey Gotsman", "Pierre Sutra"),
								List.of(new Reference("https://arxiv.org/pdf/2003.11789.pdf", "pdf", "pdf"))),
						new Paper("https://doi.org/10.1007/978-3-662-53426-7_21",
								"On Composition and Implementation of Sequential Consistency.",
								"DISC (2016)",
								List.of("Matoula Petrolia", "Achour Mostéfaoui", "Claude Jard"),
								List.of(new Reference("https://hal.science/hal-01346805", "Version longue", "Long version"))),
						new Paper("https://doi.org/10.1145/3662158.3662824",
								"Brief Announcement: Randomized Consensus: Common Coins Are not the Holy Grail!",
								"PODC (2024)",
								List.of("Achour Mostéfaoui", "Julien Weibel"),
								List.of(new Reference("https://doi.org/10.1109/PRDC47002.2019.00051", "Version préliminaire", "Preliminary version")))
						))
				+ toHTML("Abstractions de mémoire pour les Byzantins", "Memory abstractions for Byzantine processes", List.of(
						new Paper("https://doi.org/10.1145/3700838.3700867",
								"Byzantine-Tolerant Privacy-Preserving Atomic Register.",
								"ICDCN (2025)",
								List.of("Vincent Kowalski", "Achour Mostéfaoui", "Sinchan Sengupta"),
								List.of(new Reference("https://doi.org/10.1007/978-3-031-90203-1_30", "Poster", "Poster"))),
						new Paper("https://doi.org/10.4230/LIPIcs.OPODIS.2023.35",
								"Atomic Register Abstractions for Byzantine-Prone Distributed Systems.",
								"OPODIS (2023)",
								List.of("Vincent Kowalski", "Achour Mostéfaoui"),
								List.of())
						))
				+ toHTML("Modèles de programmation distribuée", "Distributed programming models", List.of(
						new Paper("https://doi.org/10.1142/S0129054116500052",
								"On the Complexity of Concurrent Multiset Rewriting.",
								"Int. J. Found. Comput. Sci. (2016)",
								List.of("Marin Bertier", "Cédric Tedeschi"),
								List.of(new Reference("https://hal.archives-ouvertes.fr/hal-00912554", "pdf", "pdf"))),
						new Paper("https://doi.org/10.1007/978-3-030-59003-1_21",
								"Collaborative SPARQL Query Processing for Decentralized Semantic Data.",
								"DEXA (2020)",
								List.of("Arnaud Grall", "Hala Skaf-Molli", "Pascal Molli"),
								List.of(new Reference("https://hal.archives-ouvertes.fr/hal-03154375", "pdf", "pdf"))),
						new Paper("https://doi.org/10.1007/978-3-319-26850-7_26",
								"Tracking Causal Dependencies in Web Services Orchestrations Defined in ORC.",
								"NETYS (2015)",
								List.of("Claude Jard", "Achour Mostéfaoui"),
								List.of(new Reference("https://hal.archives-ouvertes.fr/hal-01101340", "Version longue", "Long version"),
										new Reference("data/NETYS_15_orc_beamer.pdf", "Présentation", "Slides"),
										new Reference("https://hal.inria.fr/LINA-AELOS/hal-00876651", "Poster", "Poster")))
						))
				+ toHTML("Compatibilité des licences", "License compatibility", List.of(
						new Paper("https://doi.org/10.1007/978-3-030-21348-0_17",
								"Modelling the Compatibility of Licenses.",
								"ESWC - The Extended Semantic Web Conference (2019)",
								List.of("Benjamin Moreau", "Patricia Serrano-Alvarado", "Emmanuel Desmontils"),
								List.of(new Reference("https://doi.org/10.1007/978-3-030-32327-1_26", "Démo", "Demo"),
										new Reference("https://hal.archives-ouvertes.fr/IC_2020/hal-02877913", "Version française", "French version")))
						))
				+ "</section>";
	}

	private String toHTML(String titleFR, String titleEN, List<Paper> papers) {
		String paperlist = "";
		for(var paper : papers) {
			paperlist+= paper.toHTML(french());
		}
		return "<article><h4>%s</h4><ul>%s</ul></article>".formatted((french?titleFR:titleEN), paperlist);
	}

	
	public String footerMessage() {
		return french?
				"La sentinelle de Port Blanc, Penvénan"
				:"Porz Scaff, Plougrescant";
	}
	
	public String footerImage() {
		return french?
				"img/sentinelle.jpg"
				:"img/plougrescant.jpg";
	}
	
}

