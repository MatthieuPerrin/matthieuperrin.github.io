package fr.matthieuperrin;

public record Enseignement(boolean french) implements Page {

	public String body() {
		return "<section><h3>"
				+(french?"Responsabilités pédagogiques":"Teaching responsabilities")
				+"</h3>"
				
				+ Course("Parcours ALMA", "ALMA track", 
						"Master Informatique", "Master in Computer Science", 
						"Je suis co-responsable avec Hala Skaf-Molli "
						+ "du parcours ALMA (Architectures Logicielles et Distribuées) "
						+ "du Master Informatique de Nantes Université. "
						+ "Le parcours forme aux architectures logicielles robustes "
						+ "et aux systèmes distribués (modélisation, algorithmique, fiabilité), "
						+ "avec des applications vers le génie logiciel, "
						+ "les plates-formes distribuées, les données et l'intelligence artificielle. "
						+ "Il associe des enseignements de haut niveau et des projets de recherche, "
						+ "en lien étroit avec les laboratoires du LS2N.", 
						"I am co-director with Hala Skaf-Molli of the ALMA track "
						+ "(Software Architectures and Distributed Systems) "
						+ "within the Master in Computer Science at Nantes Université. "
						+ "The track focuses on robust software architectures "
						+ "and distributed systems (modelling, algorithms, reliability), "
						+ "with applications to software engineering, "
						+ "distributed platforms, data and artificial intelligence."
						+ "It combines advanced coursework with research-oriented projects, "
						+ "in close collaboration with the LS2N laboratory.", 
						"https://sciences-techniques.univ-nantes.fr/formations/masters/master-informatique")				
				
				+ Course("Langages et Automates", "Languages and Automata", 
						"Licence 2, Informatique et Info-Maths", "Bachelor, Year 2 — CS and Math-CS", 
						"Ce cours introduit les langages formels et les automates finis, "
						+ "bases théoriques de la compilation et de l’analyse de programmes. "
						+ "Les étudiants y découvrent les expressions rationnelles, "
						+ "la déterminisation, la minimisation d’automates et les "
						+ "grammaires algébriques, avec des travaux pratiques sur "
						+ "l'analyse lexicale et syntaxique.", 
						"This course introduces formal languages and finite automata, "
						+ "which form the theoretical basis of compilers and program analysis. "
						+ "Students study regular expressions, determinization and minimization "
						+ "of automata, and context-free grammars, "
						+ "with practical sessions on lexical and syntax analysis.", 
						"https://github.com/LangagesEtAutomates/")				
				
				+ Course("Calculabilité et Complexité", "Computability and Complexity", 
						"Licence 3, Informatique et Info-Maths", "Bachelor, Year 3 — CS and Math-CS", 
						"Le cours présente les fondements de la calculabilité, "
						+ "à travers les machines de Turing, "
						+ "les langages décidables et indécidables, "
						+ "ainsi que les notions de réduction "
						+ "et de problèmes NP-complets. "
						+ "Il met l’accent sur la modélisation des problèmes de décision "
						+ "et la compréhension des limites du calcul effectif.",
						"The course presents the foundations of computability, "
						+ "including Turing machines, decidable and undecidable languages, "
						+ "reductions, and NP-completeness. "
						+ "It focuses on problem modeling and on understanding the limits of effective computation.", 
						"https://github.com/CalculabiliteEtComplexite")
				
				+ Course("Programmation Concurrente en Multi-thread", "Concurrent Multithread Programming", 
						"Master 1, ALMA", "Master 1 — ALMA track",
						"Ce module explore la programmation parallèle sur systèmes multi-cœurs, "
						+ "en particulier les mécanismes de synchronisation (verrous, sections critiques, objets partagés) "
						+ "et les structures concurrentes. Les étudiants développent et "
						+ "évaluent des programmes Java multi-threads, "
						+ "de la synchronisation basique aux algorithmes d'exclusion mutuelle.", 
						"This module explores parallel programming on multicore systems, "
						+ "focusing on synchronization mechanisms (locks, critical sections, shared objects) "
						+ "and concurrent data structures. Students design and evaluate Java multithreaded "
						+ "programs, progressing from basic synchronization to mutual exclusion algorithms.", 
						"https://github.com/ProgrammationMultiThread/")

				+ Course("Programmation Distribuée", "Distributed Programming", 
						"Master 1, ALMA", "Master 1 — ALMA track", 
						"Le cours aborde l'algorithmique des systèmes concurrents, "
						+ "en étudiant les notions de terminaison non bloquante, "
						+ "de hiérarchie de consensus, et de preuves de correction. "
						+ "Les étudiants conçoivent des implémentations d’objets partagés "
						+ "garantissant la linéarisation, et des preuves d'impossibilité.",
						"The course studies non-blocking algorithmic design in concurrent systems, "
						+ "with a focus on termination properties, the consensus hierarchy, "
						+ "and proofs of correctness. "
						+ "Students implement shared objects ensuring linearizability "
						+ "and impossibility proofs.", 
						"https://github.com/AlgorithmiqueConcurrente/")

				+ Course("Services de Communication et Systèmes Distribués", "Communication Services and Distributed Systems", 
						"Master 2, ALMA", "Master 2 — ALMA track", 
						"Ce module traite de l'algorithmique répartie dans les "
						+ "systèmes à passage de messages, soumis à des pannes "
						+ "et retards de communication. Il couvre les abstractions "
						+ "de diffusion de messages (reliable, causal, total order), "
						+ "la tolérance aux fautes, les registres distribués (ABD), "
						+ "le consensus et la machine à états répliquée.", 
						"This module focuses on distributed algorithms in message-passing "
						+ "systems subject to crashes and asynchrony. It covers broadcast abstractions "
						+ "(reliable, causal, total order), fault tolerance, distributed registers (ABD), "
						+ "consensus, and replicated state machines.", 
						"https://github.com/DistributedComputing/")
				+ "</section>";
	}

	private String Course(String titleFR, String titleEN, 
			String levelFR, String levelEN, 
			String descFR, String descEN, String url) {
		return """
				<article>
				  <h4><a href="%s">%s</a> (%s)</h4>
				  <p>%s</p>
				</article>""".formatted(
				url,
						(french?titleFR:titleEN),
						(french?levelFR:levelEN),
						(french?descFR:descEN));
	}
	
	public String footerMessage() {
		return french?
				"Budapest, Hongrie"
				:"Chicago, Illinois, USA";
	}

	public String footerImage() {
		return french?
				"img/budapest.jpg"
				:"img/chicago.jpg";
	}

}




