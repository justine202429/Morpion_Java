package main;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner ; 

public class main {
	//Sous-programmes
	//Les menus
	static Scanner scanner = new Scanner(System.in);
	public static Boolean ChoixDebFin() {
		int rep  ;
		Boolean choix ;
		System.out.println("Fin ou début de partie ?") ;
		System.out.println("1- Jouons !") ;
		System.out.println("2- On arrête là pour aujourd'hui") ;
		while (true) {
			System.out.println("Quel est ton choix ?") ;
			rep = scanner.nextInt() ;	
			if(rep == 1 || rep == 2) {
				break ; 
			}
			else {
				System.out.println("Entre un nombre valide (1 ou 2).");
			}
		}
		if (rep ==1) {
			choix = true ;
		}
		else {
			choix = false;
		}
		return choix ; 
	}
	
	public static int ChoixModeDeJeu() {
		int choixMDJ = 0 ;
		System.out.println("Ohé loup de mer prêt à nous montrer tes capacités de navigateur à travers le jeu du Morpion ? 2 mode de jeu s'offre à toi : ") ;
		System.out.println("1- Défie un de ses mérinos mal peignés de ton entourage !") ;
		System.out.println("2- Défie un navire de taille") ;
		while (true) {
			System.out.println("Parez à mouillez, à virer ! Quel est ton choix ?") ;
			choixMDJ = scanner.nextInt() ;	
			if(choixMDJ == 1 || choixMDJ == 2) {
				break ; 
			}
			else {
				System.out.println("Foutre ! Entre un nombre valide (1 ou 2).");
			}
		}
		return choixMDJ ; 
	}
	
	public static String ChoixSymbole() {
		String choixS = "";
		System.out.println("Comment te définies tu, plutot pirate X ou plutot moussaillon O") ;
		while(true) {
			choixS = scanner.next() ;
			if (choixS.equals("X") || choixS.equals("O")) {
				break ;
			}
			else {
				System.out.println("Marin d'eau douce ! Entre un caractère valide (X ou O).");
			}
		}
		return choixS  ; 
	}
	
	public static String ChoixPremierCoup() {
		String choixPC = "";
		System.out.println("Ohé ! Du bateau ! Qui tire le premier coup de canon ? Pirate X ou Mousaillon O ?") ;
		while(true) {
			choixPC = scanner.next() ;
			if (choixPC.equals("X") || choixPC.equals("O")) {
				break ;
			}
			else {
				System.out.println("Bois-sans-soif ! Entre un caractère valide (X ou O).");
			}
		}
		return choixPC  ; 
	}
	
	public static int ChoixOption() {
		int choixO = 0 ; 
		System.out.println("Il y a plusieurs défis lors d'un long périple en mer...") ;
		System.out.println("1 - Sois le premier a tracer ton itinéraire sur la carte");
		System.out.println("2 - Attention zone dangereuse à la navigation, vents violents, fortes tempêtes, mers déchaînées");
		System.out.println("3 - Conquéris le plus d'itinéraire sur la totalité de la carte");
		System.out.println("Triple Dieu ! Dans quoi vous aventurez vous ? ") ;
		while(true) {
			choixO = scanner.nextInt() ;
			if (choixO == 1 || choixO == 2 || choixO ==3) {
				break ;
			}
			else {
				System.out.println("Ecrevisse de rampart ! Entre un nombre valide (1, 2 ou 3).");
			}
		}
		return choixO ; 
	}
	
	public static int ChoixNiveau() {
		int choixN  = 0 ;
		System.out.println("Oh hé ! Quel est ton expérience en tant que navigateur ?") ;
		System.out.println("1 - Un début en mer pour les jeunes mousaillons");
		System.out.println("2 - Après plusieurs périples te voilà matelot");
		System.out.println("3 - Seulement pour les loups de mer les plus audacieux");
		System.out.println("Quel est ton choix ? ") ;
		while(true) {
			choixN = scanner.nextInt() ;
			if (choixN == 1 || choixN == 2 || choixN == 3) {
				break;
			}
			else {
				System.out.println("Fripon ! Entre un nombre valide (1, 2 ou 3).");
			}
		}
		return choixN ;   
	}
	
	public static int ChoixPartie() {
		int choixP = 0 ;
		System.out.println("Marin, tu es pressé ?") ;
		System.out.println("1- Rejoins un navire déjà en mer !") ;
		System.out.println("2- Navigue comme bon te semble") ;
		while (true) {
			System.out.println("Quel est ton choix ?") ;
			choixP = scanner.nextInt() ;	
			if(choixP == 1 || choixP == 2) {
				break ; 
			}
			else {
				System.out.println("Foutre ! Entre un nombre valide (1 ou 2).");
			}
		}
		return choixP ; 
	}
	public static int ChoixAlignement() {
		int longalign = 0 ; 
		System.out.println("Quelle est l'étendue de ton périple ?") ;
		System.out.println("3 noeuds");
		System.out.println("4 noeuds");
		System.out.println("5 noeuds");
		System.out.println("Triple Dieu ! Dans quoi vous aventurez vous ? ") ;
		while(true) {
			longalign = scanner.nextInt() ;
			if (longalign == 3 || longalign == 4 || longalign ==5) {
				break ;
			}
			else {
				System.out.println("Ecrevisse de rampart ! Entre un nombre valide (3, 4 ou 5).");
			}
		}
		return longalign ;
	}
	
	//La grille
	public static String [][] Grille(int longu) { 
		String [][] tab = new String[longu][longu] ;
		for (int i = 0; i< longu; i++) {
			for (int j = 0; j< longu; j++) {
				tab[i][j]=".";
			}
		}
		return tab ; 
	}

	public static void AfficherGrille(String [][] grille) {
		// Affichage des numéros de colonnes
	    System.out.print("y/x "); // Espace pour l'alignement avec les lignes
	    for (int i = 1; i <= grille.length; i++) {
	        System.out.print(i + "  ");
	    }
	    System.out.println(); // Nouvelle ligne après l'en-tête des colonnes
	    // Affichage de la grille et des numéros de lignes
	    for (int i = 0; i < grille.length; i++) {
	        System.out.print((i + 1) + "   "); // Numéro de ligne
	        for (int j = 0; j < grille[i].length; j++) {
	            System.out.print(grille[i][j] + "  ");
	        }
	        System.out.println(); // Nouvelle ligne après chaque ligne de la grille
	    }
	}

	//Alignement 
	public static Boolean AlignementL(String[][] grille, int longalig) {
	    Boolean ligne = false;
	    // Parcours des lignes de la grille
	    for (int i = 0; i < grille.length; i++) {
	        // Parcours des positions dans la ligne où un alignement pourrait commencer
	        for (int j = 0; j <= grille[i].length - longalig; j++) {
	            Boolean ligneAlignee = true;
	            String premierSymbole = grille[i][j]; // Premier symbole dans la ligne à la position j
	            // Vérification de l'alignement sur la longueur donnée
	            for (int k = 1; k < longalig; k++) {
	                // Comparaison des symboles suivants avec le premier symbole de la ligne
	                if (!grille[i][j + k].equals(premierSymbole) || (!premierSymbole.equals("X") && !premierSymbole.equals("O"))) {
	                    ligneAlignee = false; // Si les symboles diffèrent ou ne sont ni "X" ni "O", la ligne n'est pas alignée
	                    break;
	                }
	            }
	            if (ligneAlignee) {
	                ligne = true; // Si la ligne est alignée sur la longueur spécifiée, on passe la ligne à vrai et on sort de la boucle
	                break;
	            }
	        }
	    }
	    return ligne; // Renvoie true si au moins une ligne est alignée sur la longueur donnée, sinon renvoie false
	}


	public static Boolean AlignementC(String[][] grille, int longalig) {
	    Boolean colonne = false;

	    // Parcours des colonnes de la grille
	    for (int j = 0; j < grille.length; j++) {
	        // Parcours des positions dans la colonne où un alignement pourrait commencer
	        for (int i = 0; i <= grille.length - longalig; i++) {
	            Boolean colonneAlignee = true;
	            String premierSymbole = grille[i][j]; // Premier symbole dans la colonne à la position i
	            // Vérification de l'alignement sur la longueur donnée
	            for (int k = 1; k < longalig; k++) {
	                // Comparaison des symboles suivants avec le premier symbole de la colonne
	                if (!grille[i + k][j].equals(premierSymbole) || (!premierSymbole.equals("X") && !premierSymbole.equals("O"))) {
	                    colonneAlignee = false; // Si les symboles diffèrent ou ne sont ni "X" ni "O", la colonne n'est pas alignée
	                    break;
	                }
	            }
	            if (colonneAlignee) {
	                colonne = true; // Si la colonne est alignée sur la longueur donnée, on passe la colonne à vrai et on sort de la boucle 
	                break;
	            }
	        }
	    }
	    return colonne; // Renvoie true si au moins une colonne est alignée sur la longueur donnée, sinon renvoie false
	}

	public static Boolean AlignementD1(String[][] grille, int longalig) {
	    Boolean diagonale1 = false; // Supposons que la diagonale n'est pas alignée au départ
	    for (int i = 0; i < grille.length; i++) {
	        for (int j = 0; j < grille[i].length; j++) {
	            // Vérification de l'alignement à partir de la position (i, j)
	            Boolean alignementPartiel = true;
	            String premierSymbole = grille[i][j]; // Premier symbole dans la diagonale à la position (i, j)
	            // Vérification de l'alignement sur la longueur donnée
	            for (int k = 1; k < longalig; k++) {
	                int x = i + k;
	                int y = j + k;
	                // Vérification des limites de la grille
	                if (x >= grille.length || y >= grille[x].length) {
	                    alignementPartiel = false; // Si on dépasse les limites de la grille, l'alignement n'est pas partiellement valide
	                    break;
	                }
	                // Comparaison des symboles suivants avec le premier symbole de la diagonale
	                if (!grille[x][y].equals(premierSymbole) || (!premierSymbole.equals("X") && !premierSymbole.equals("O"))) {
	                    alignementPartiel = false; // Si les symboles diffèrent ou ne sont ni "X" ni "O", l'alignement n'est pas partiellement valide
	                    break;
	                }
	            }
	            if (alignementPartiel) {
	                diagonale1 = true; // Si l'alignement partiel est valide, on passe diagonale1 à vrai et on sort de la boucle 
	                break;
	            }
	        }
	        if (diagonale1) {
	            break; // Si une diagonale alignée est trouvée, on sort de la boucle 
	        }
	    }
	    return diagonale1;
	}
	
	public static Boolean AlignementD2(String[][] grille, int longalig) {
	    Boolean diagonale2 = false; // Supposons que la diagonale n'est pas alignée au départ
	    for (int i = grille.length - 1; i >= 0; i--) {
	        for (int j = 0; j < grille[i].length; j++) {
	            // Vérification de l'alignement à partir de la position (i, j)
	            Boolean alignementPartiel = true;
	            String premierSymbole = grille[i][j]; // Premier symbole dans la diagonale à la position (i, j)
	            // Vérification de l'alignement sur la longueur donnée
	            for (int k = 1; k < longalig; k++) {
	                int x = i - k;
	                int y = j + k;
	                // Vérification des limites de la grille
	                if (x < 0 || y >= grille[x].length) {
	                    alignementPartiel = false; // Si on dépasse les limites de la grille, l'alignement n'est pas partiellement valide
	                    break;
	                }
	                // Comparaison des symboles suivants avec le premier symbole de la diagonale
	                if (!grille[x][y].equals(premierSymbole) || (!premierSymbole.equals("X") && !premierSymbole.equals("O"))) {
	                    alignementPartiel = false; // Si les symboles diffèrent ou ne sont ni "X" ni "O", l'alignement n'est pas partiellement valide
	                    break;
	                }
	            }
	            if (alignementPartiel) {
	                diagonale2 = true; // Si l'alignement partiel est valide, on met diagonale2 à vrai et on sort de la boucle 
	                break;
	            }
	        }
	        if (diagonale2) {
	            break; // Si une diagonale alignée est trouvée, on sort de la boucle 
	        }
	    }
	    return diagonale2;
	}

	public static Boolean Alignement(String [][] grille, int niv) {
		Boolean AL = AlignementL(grille,niv) ;
		Boolean AC = AlignementC(grille,niv) ;
		Boolean AD1 = AlignementD1(grille,niv) ;
		Boolean AD2 = AlignementD2(grille,niv) ;
		if (AL || AC || AD1 || AD2 )
			return true ;
		else 
			return false ; 
	}
	
	//Alignement spéciaux à l'option 3 (avec compteur...)
		public static int CompterAlignementsL(String[][] grille, int longalig, String joueur) {
		    int alignements = 0;
		    for (int i = 0; i < grille.length; i++) {
		        for (int j = 0; j <= grille[i].length - longalig; j++) {
		            boolean ligneAlignee = true;
		            for (int k = 0; k < longalig; k++) {
		                if (!grille[i][j + k].equals(joueur)) {
		                    ligneAlignee = false;
		                    break;
		                }
		            }
		            if (ligneAlignee) {
		                alignements++;
		                j+=(longalig+1) ; 
		            }
		            /*
		            System.out.println("diagL");
		            System.out.println(i);
		            System.out.println(j);*/
		        }
		    }
		    return alignements;
		}
		
		public static int CompterAlignementsC(String[][] grille, int longalig, String joueur) {
		    int alignements = 0;
		    for (int j = 0; j < grille.length; j++) {
		        for (int i = 0; i <= grille.length - longalig; i++) {
		            boolean colonneAlignee = true;
		            for (int k = 0; k < longalig; k++) {
		                if (!grille[i + k][j].equals(joueur)) {
		                    colonneAlignee = false;
		                    break;
		                }
		            }
		            if (colonneAlignee) {
		                alignements++;
		                i+=(longalig+1);
		            }
		            //System.out.println("diagC");
		            //System.out.println(i);
		            //System.out.println(j);
		        }
		    }
		    return alignements;
		}
		
		public static int CompterAlignementsD(String[][] grille, int longalig, String joueur) {
		    int alignements = 0;
		    // Compter les alignements sur la première diagonale
		    for (int i = 0; i < grille.length; i++) {
		        for (int j = 0; j <= grille[i].length - longalig; j++) {
		            boolean diagonaleAlignee = true;
		            for (int k = 0; k < longalig; k++) {
		                int x = i + k;
		                int y = j - k;
		                if (x >= 0 && x < grille[i].length && y >= 0 && y < grille.length) {
	                        if (!grille[y][x].equals(joueur)) {
	                            diagonaleAlignee = false;
	                            break;
	                        }
	                    } else {
	                        diagonaleAlignee = false; // On considère que la diagonale n'est pas alignée si hors limites
	                        break;
	                    }
		            }
		            if (diagonaleAlignee) {
		                alignements++;
		                j+=(longalig+1);
		            }
		            /*
		            System.out.println("diag1");
		            System.out.println(i);
		            System.out.println(j);*/
		        }
		    }
		    // Compter les alignements sur la deuxième diagonale
		    for (int i = grille.length - 1; i >= 0; i--) {
		        for (int j = 0; j <= grille[i].length - longalig; j++) {
		            boolean diagonaleAlignee = true;
		            for (int k = 0; k < longalig; k++) {
		                int x = i - k;
		                int y = j + k;
		                if (x < 0 || y >= grille[x].length || !grille[x][y].equals(joueur)) {
		                    diagonaleAlignee = false;
		                    break;
		                }
		            }
		            if (diagonaleAlignee) {
		                alignements++;
		                j +=(longalig+1);
		            }
		            /*
		            System.out.println("diag2");
		            System.out.println(i);
		            System.out.println(j);*/
		        }
		    }
		    return alignements;
		}
		
		public static int CompterAlignements(String[][] grille, int longalig, String joueur) {
		    int alignements = 0;
		    // Vérification des alignements horizontaux
		    alignements += CompterAlignementsL(grille, longalig, joueur);
		    // Vérification des alignements verticaux
		    alignements += CompterAlignementsC(grille, longalig, joueur);
		    // Vérification des alignements diagonaux
		    alignements += CompterAlignementsD(grille, longalig, joueur);
		    return alignements;
		}
	
	//Demande de la case au joueur 
	public static int[] Case(String[][] grille) {
	    //System.out.println("Entrez des coordonnées au format x,y : ");
	    int[] resultat = new int[2];
	    Scanner scanner = new Scanner(System.in);
	    String input ;
	    String[] coord ;
	    int x ; 
	    int y ;
	    do {
	    	System.out.println("Entre les coordonnées que t'indique ton compas au format x,y : ");
	    	input =  scanner.nextLine();
	    	coord = input.split(",");
	    	x = Integer.parseInt(coord[0]); 
		    y = Integer.parseInt(coord[1]);
	    } while (x<1 || x>grille.length || y<1 || y>grille.length || !grille[y-1][x-1].equals(".") ) ;
	            resultat[0] = x - 1;
	            resultat[1] = y - 1;
	    //System.out.println(Arrays.toString(resultat));
	    return resultat;
	}

	
	//Placer le jeton du joueur dans la case  
	public static String [][] Jeton(int [] coord, String joueur, String [][] grille) {
		int x = coord[0];
		int y = coord[1]; 
		grille[y][x]=joueur ; 
		return grille ; 
	} 
	
	//Changement de joueur 
	public static String Tour(String joueurencours) {
		if (joueurencours.equals("X"))
			joueurencours = "O";
		else 
			joueurencours = "X";
		return joueurencours ; 
	}
	
	//Placer des cases bloquées 
	public static String [][] Bloque(String [][] grille, int niveau){
		int longueur = grille.length ; 
		if (niveau == 1) {
			if (longueur == 6) {
				for (int i=0;i<5;i++) {
					Random random = new Random ();
					int largeur = grille[0].length ;
					int hauteur = grille.length ; 
					int x = random.nextInt(largeur)+1;
					int y = random.nextInt(hauteur)+1;
					if (grille[y-1][x-1].equals(".")) {
						 grille[y-1][x-1]="⛆" ; 
					}
				}
			}
			if (longueur == 7) {
				for (int i=0;i<10;i++) {
					Random random = new Random ();
					int largeur = grille[0].length ;
					int hauteur = grille.length ;
					int x = random.nextInt(largeur)+1;
					int y = random.nextInt(hauteur)+1;
					if (grille[y-1][x-1].equals(".")) {
						 grille[y-1][x-1]="⛆️" ; 
					}
				}
			}
			if (longueur == 8) {
				for (int i=0;i<15;i++) {
					Random random = new Random ();
					int largeur = grille[0].length ;
					int hauteur = grille.length ;
					int x = random.nextInt(largeur)+1;
					int y = random.nextInt(hauteur)+1;
					if (grille[y-1][x-1].equals(".")) {
						 grille[y-1][x-1]="⛆️" ; 
					}
				}
			}
		}
		if (niveau == 2) {
			if (longueur == 6) {
				for (int i=0;i<10;i++) {
					Random random = new Random ();
					int largeur = grille[0].length ;
					int hauteur = grille.length ; 
					int x = random.nextInt(largeur)+1;
					int y = random.nextInt(hauteur)+1;
					if (grille[y-1][x-1].equals(".")) {
						 grille[y-1][x-1]="⛆" ; 
					}
				}
			}
			if (longueur == 7) {
				for (int i=0;i<15;i++) {
					Random random = new Random ();
					int largeur = grille[0].length ;
					int hauteur = grille.length ;
					int x = random.nextInt(largeur)+1;
					int y = random.nextInt(hauteur)+1;
					if (grille[y-1][x-1].equals(".")) {
						 grille[y-1][x-1]="⛆️" ; 
					}
				}
			}
			if (longueur == 8) {
				for (int i=0;i<20;i++) {
					Random random = new Random ();
					int largeur = grille[0].length ;
					int hauteur = grille.length ;
					int x = random.nextInt(largeur)+1;
					int y = random.nextInt(hauteur)+1;
					if (grille[y-1][x-1].equals(".")) {
						 grille[y-1][x-1]="⛆" ; 
					}
				}
			}
		}
		if (niveau == 3) {
			if (longueur == 6) {
				for (int i=0;i<15;i++) {
					Random random = new Random ();
					int largeur = grille[0].length ;
					int hauteur = grille.length ; 
					int x = random.nextInt(largeur)+1;
					int y = random.nextInt(hauteur)+1;
					if (grille[y-1][x-1].equals(".")) {
						 grille[y-1][x-1]="⛆️" ; 
					}
				}
			}
			if (longueur == 7) {
				for (int i=0;i<20;i++) {
					Random random = new Random ();
					int largeur = grille[0].length ;
					int hauteur = grille.length ;
					int x = random.nextInt(largeur)+1;
					int y = random.nextInt(hauteur)+1;
					if (grille[y-1][x-1].equals(".")) {
						 grille[y-1][x-1]="⛆️" ; 
					}
				}
			}
			if (longueur == 8) {
				for (int i=0;i<25;i++) {
					Random random = new Random ();
					int largeur = grille[0].length ;
					int hauteur = grille.length ;
					int x = random.nextInt(largeur)+1;
					int y = random.nextInt(hauteur)+1;
					if (grille[y-1][x-1].equals(".")) {
						 grille[y-1][x-1]="️⛆️" ; 
					}
				}
			}
		}
		return grille ;
	}
	
	//Messages d'encouragement 
	public static void Message() {
		String [] tableau = new String[3];
		tableau[0] = "Hissez ho !";
		tableau[1] = "Pas de quartier !";
		tableau[2] = "A l’abordage !";
		Random random = new Random ();
		int indice = random.nextInt(3);
		System.out.println(tableau[indice]);
	}
	
	//Deux Joueurs 
	public static void DJOption1() {
		int cpt = 0;
		int longalign = ChoixAlignement();
		int longueur = longalign + 3 ;
		String gagnant =""; 
		String [][] grille = Grille(longueur) ; 
		String joueurencours = ChoixPremierCoup() ;
		System.out.println("Larguez les amarres et pas de quartier !");
		AfficherGrille(grille);
		Boolean Aligne = Alignement(grille, longalign);
		while (Aligne == false) {
			if (cpt%3==0) {
				Message();
			}
			Jeton(Case(grille), joueurencours, grille) ;
			cpt ++ ;
			AfficherGrille(grille);
			System.out.println(" ");
			Aligne = Alignement(grille, longalign);
			gagnant = joueurencours ;
			joueurencours = Tour(joueurencours);
		}	
		System.out.println(gagnant + " a gagné !");
	}
	
	public static void DJOption2() {
		int longalign = ChoixAlignement();
		int longueur = longalign + 3 ;
		int cpt = 0;
		String gagnant = "";
		String [][] grille = Grille(longueur) ; 
		int niv = ChoixNiveau() ;
		String joueurencours = ChoixPremierCoup() ;
		grille = Bloque(grille, niv) ;
		System.out.println("Larguez les amarres et pas de quartier !");
		AfficherGrille(grille);
		Boolean Aligne = Alignement(grille, longalign);
		while (Aligne == false) {
			if (cpt%3==0) {
				Message();
			}
			Jeton(Case(grille), joueurencours, grille) ;
			AfficherGrille(grille);
			System.out.println(" ");
			Aligne = Alignement(grille, longalign);
			gagnant = joueurencours ;
			joueurencours = Tour(joueurencours);
		}	
		System.out.println(gagnant + " a gagné !");
	}
	
	public static void DJOption3() {
		int longalign = ChoixAlignement();
		int longueur = longalign + 3 ;
		String[][] grille = Grille(longueur);
		String joueurencours = ChoixPremierCoup() ;
		System.out.println("Larguez les amarres et pas de quartier !");
		AfficherGrille(grille);
		int choixR = 0;
		int cpt = 0;
		int remplie = (longueur)*(longueur);
		while (cpt != remplie) {
			if (cpt%3==0) {
				Message();
			}
			Jeton(Case(grille), joueurencours, grille) ;
			AfficherGrille(grille);
			System.out.println(" ");
			joueurencours = Tour(joueurencours);
			cpt++ ; 
		}
		System.out.println("La grille est remplie !");
		int alignX = CompterAlignements(grille, longalign, "X");
        int alignO = CompterAlignements(grille, longalign, "O");
		if (alignX > alignO) {
			System.out.println("Bravo les pirates l'emportent avec " + alignX + " alignements ! Vous ne vous en sortirez pas comme ca !");
		}
		else if (alignO > alignX) {
			System.out.println("Bravo les marins gagnent la partie avec " + alignO + " alignements ! Le bien triomphe toujours !");
		}
		else {
			while(true) {
				System.out.println("Egalité, les deux joueurs ont réalisé le même nombre d'alignements "+ alignX+ " alignements ! Revanche ?");
				System.out.println("1 - Oui ! Il n'y a pas d'égalité en mer !");
				System.out.println("2 - Non, nous sommmes du genre 'prudent'");
				choixR = scanner.nextInt() ;
				if(choixR == 1 || choixR == 2) {
					break ; 
				}
				else {
					System.out.println("Foutre ! Entre un nombre valide (1 ou 2).");
				}
			}
			if (choixR==1) {
				DJOption3() ;
				}
			else {
				System.out.println("A bientot !");
			}
		}
	}
	
	public static void Test1() {
		int choixR = 0;
		int longalign = ChoixAlignement();
		int longueur = longalign + 3 ;
		String [][] grille = Grille(longueur) ; 
		String joueurencours = ChoixPremierCoup() ;
		String premier = joueurencours ; 
		System.out.println("Larguez les amarres et pas de quartier ! La bataille à déjà commencée, à toi de porter le coup de grâce ");
		for (int cpt = 1; cpt<(longueur*longueur)-1; cpt++) {
			int i ; 
		    int j ;
			do {
				Random random = new Random();
				i = random.nextInt(longueur);
				j = random.nextInt(longueur);
		    } while (!grille[i][j].equals(".")) ;
			grille[i][j]=joueurencours;
			joueurencours=Tour(joueurencours);
		}
		AfficherGrille(grille);
		System.out.println(" ");
		joueurencours = premier ; 
		for (int cpt1 = 0; cpt1<2; cpt1++) {
			Jeton(Case(grille), joueurencours, grille) ;
			AfficherGrille(grille);
			joueurencours = Tour(joueurencours);
		}
		System.out.println("La grille est remplie !");
		int alignX = CompterAlignements(grille, longalign, "X");
        int alignO = CompterAlignements(grille, longalign, "O");
		if (alignX > alignO) {
			System.out.println("Bravo les pirates l'emportent avec " + alignX + " alignements ! Vous ne vous en sortirez pas comme ca !");
		}
		else if (alignO > alignX) {
			System.out.println("Bravo les marins gagnent la partie avec " + alignO + " alignements ! Le bien triomphe toujours !");
		}
		else {
			while(true) {
				System.out.println("Egalité, les deux joueurs ont réalisé le même nombre d'alignements ! Revanche ?");
				System.out.println("1 - Oui ! Il n'y a pas d'égalité en mer !");
				System.out.println("2 - Non, nous sommmes du genre 'prudent'");
				choixR = scanner.nextInt() ;
				if(choixR == 1 || choixR == 2) {
					break ; 
				}
				else {
					System.out.println("Foutre ! Entre un nombre valide (1 ou 2).");
				}
			}
			if (choixR==1) {
				Test1() ;
				}
			else {
				System.out.println("A bientot !");
			}
		}
	}
	public static void Test2() {
		//Grille test où les marins gagnent "O" avec 8 alignements et 4 pour les pirates "X"
		int longalign = 3 ; 
		String [][] grille = {
				{"O","X","O","X","X","X"},
				{"X","X","O","O","O","X"},
				{"O","O","X","O","X","X"},
				{"O","X","X","O","O","X"},
				{"O","X","X","O","O","O"},
				{"X","O","O","O","X","X"}};			
		AfficherGrille(grille);
		System.out.println("La grille est remplie !");
		int alignX = CompterAlignements(grille, longalign, "X");
		int alignO = CompterAlignements(grille, longalign, "O");
		if (alignX > alignO) {
			System.out.println("Bravo les pirates l'emportent avec " + alignX + " alignements ! Vous ne vous en sortirez pas comme ca !");
		}
		else if (alignO > alignX) {
			System.out.println("Bravo les marins gagnent la partie avec " + alignO + " alignements ! Le bien triomphe toujours !");
		}
		else {
			System.out.println("Egalité, les deux joueurs ont réalisé le même nombre d'alignements ! Revanche ?");
		}

	}
	
	//JoueurVsOrdinateur
	public static void JOOption1() {
		int cpt = 0;
		int niv = ChoixNiveau();
		int longalign = ChoixAlignement();
		int longueur = longalign + 3 ;
		String gagnant =""; 
		String [][] grille = Grille(longueur) ; 
		String joueur =  ChoixSymbole() ;
		String joueurencours = ChoixPremierCoup() ;
		int [] coord = new int[2] ;
		int [] coordJ = new int[2] ;
		Random random = new Random();
		coord[0] = random.nextInt(longueur);
		coord[1] = random.nextInt(longueur);
		coordJ[0] = random.nextInt(longueur);
		coordJ[1] = random.nextInt(longueur);
		int nvalignJD1 = 0;
		int nvalignJD2 = 0;
		int ancienaligJL = 0;
		int ancienaligJC = 0;
		int ancienaligJD1 = 0 ;
		int ancienaligJD2 = 0;
		System.out.println("Larguez les amarres et pas de quartier !");
		AfficherGrille(grille);
		Boolean Aligne = Alignement(grille, longalign); 
		while (Aligne == false) {
			if (cpt%3==0) {
				Message();
			}
			if (joueurencours.equals(joueur)) {
				Scanner scanner = new Scanner(System.in);
				String input ;
				String [] coordP ;
				int x ;
				int y ;
				do {
					System.out.println("Entre les coordonnées que t'indique ton compas au format x,y : ") ;
					input = scanner.nextLine();
					coordP = input.split(",");
					x = Integer.parseInt(coordP[0]);
					y = Integer.parseInt(coordP[1]);
				}while(x<1 || x>grille.length || y<1 || y>grille.length || !grille[y-1][x-1].equals("."));
				coordJ[0] = x - 1 ;
				coordJ[1] = y -1 ;
				Jeton(coordJ, joueurencours, grille) ;
			}
			else {
				if (niv==1) {
					int i ; 
				    int j ;
					do {
						i = random.nextInt(longueur);
						j = random.nextInt(longueur);
				    } while (!grille[i][j].equals(".")) ;
					grille[i][j]=joueurencours;
				}
				else if (niv==2) {
					int x = 0;
					int y = 0;
					do {
						// Déclaration d'une liste pour stocker les coordonnées
						List<int[]> voisinage = new ArrayList<>();
						for (int i = -1; i<2; i++) {
							for (int j = -1; j<2; j++) {
								if ((coord[0]+i>=0) && (coord[0]+i<longueur) && (coord[1]+j>=0) && (coord[1]+j<longueur)) {
									//System.out.println(coord[0]+i);
									//System.out.println(coord[1]+j);
									int[] voisin = {coord[0]+i,coord[1]+j};
									voisinage.add(voisin);
								}
							}
						}
						int longueurvoisinage = voisinage.size() ;
						if (longueurvoisinage==0) {
							coord[0] = random.nextInt(longueur);
							coord[1] = random.nextInt(longueur);
						}
						else {
							Random random2 = new Random();
							int paire=random2.nextInt(longueurvoisinage);
							int [] voisinalea = voisinage.get(paire);
							x = voisinalea[0];
							y = voisinalea[1];
							coord[0] = x ;
							coord[1] = y ;
						}
					}while(!grille[x][y].equals("."));
					grille[x][y]=joueurencours ; 
				}
				else if (niv==3){
					int x = 0;
					int y = 0;
					int nvalignJL = CompterAlignementsL(grille, longalign-1, joueur);
					int nvalignJC = CompterAlignementsC(grille, longalign-1, joueur);
					// Compter les alignements sur la première diagonale
				    for (int i = 0; i < grille.length; i++) {
				        for (int j = 0; j <= grille[i].length - longalign-1; j++) {
				            boolean diagonaleAlignee = true;
				            for (int k = 0; k < longalign-1; k++) {
				                int xbis = i + k;
				                int ybis = j - k;
				                if (xbis >= 0 && xbis < grille[i].length && ybis >= 0 && ybis < grille.length) {
			                        if (!grille[ybis][xbis].equals(joueur)) {
			                            diagonaleAlignee = false;
			                            break;
			                        }
			                    } else {
			                        diagonaleAlignee = false; // On considère que la diagonale n'est pas alignée si hors limites
			                        break;
			                    }
				            }
				            if (diagonaleAlignee) {
				            	nvalignJD1+=1;
				                j+=(longalign-1+1);
				            }
				        }
				    }
				    //System.out.println("D1"+nvalignJD1) ;
				    
				    // Compter les alignements sur la deuxième diagonale
				    for (int i = grille.length - 1; i >= 0; i--) {
				        for (int j = 0; j <= grille[i].length - longalign-1; j++) {
				            boolean diagonaleAlignee = true;
				            for (int k = 0; k < longalign-1; k++) {
				                int xtis = i - k;
				                int ytis = j + k;
				                if (xtis < 0 || ytis >= grille[xtis].length || !grille[xtis][ytis].equals(joueur)) {
				                    diagonaleAlignee = false;
				                    break;
				                }
				            }
				            if (diagonaleAlignee) {
				            	nvalignJD2+=1;
				                j +=(longalign-1+1);
				            }
				        }
				    }
				   // System.out.println("D2"+nvalignJD2) ;
					if (nvalignJL!=ancienaligJL) {
						do{
							List<int[]> voisinage = new ArrayList<>();
							if ((coordJ[0]-1>=0) && (coordJ[0]+1<longueur) && (coordJ[1]>=0) && (coordJ[1]<longueur)) {
								int[] voisin1 = {coordJ[0]-1,coordJ[1]} ;
								int[] voisin2 = {coordJ[0]+1,coordJ[1]} ;
							voisinage.add(voisin1);
							voisinage.add(voisin2);
							}
							int longueurvoisinage = voisinage.size() ; 
							if (longueurvoisinage==0) {
								coord[0] = random.nextInt(longueur);
								coord[1] = random.nextInt(longueur);
							}
							else {
								Random random2 = new Random();
								int paire=random2.nextInt(longueurvoisinage);
								int [] voisinalea = voisinage.get(paire);
								y = voisinalea[0];
								x = voisinalea[1];
							}
						}while(!grille[x][y].equals("."));
						grille[x][y]=joueurencours ; 
					}
					else if (nvalignJC!=ancienaligJC) {
						do{
							List<int[]> voisinage = new ArrayList<>();
							if ((coordJ[0]>=0) && (coordJ[0]<longueur) && (coordJ[1]-1>=0) && (coordJ[1]+1<longueur)) {
								int[] voisin1 = {coordJ[0],coordJ[1]-1} ;
								int[] voisin2 = {coordJ[0],coordJ[1]+1} ;
							voisinage.add(voisin1);
							voisinage.add(voisin2);
							}
							int longueurvoisinage = voisinage.size() ; 
							if (longueurvoisinage==0) {
								coord[0] = random.nextInt(longueur);
								coord[1] = random.nextInt(longueur);
							}
							else {
								Random random2 = new Random();
								int paire=random2.nextInt(longueurvoisinage);
								int [] voisinalea = voisinage.get(paire);
								y = voisinalea[0];
								x = voisinalea[1];
							}
						}while(!grille[x][y].equals("."));
						grille[x][y]=joueurencours ; 
					}
					else if (nvalignJD1!=ancienaligJD1) {
						do{
							List<int[]> voisinage = new ArrayList<>();
							if ((coordJ[0]-1>=0) && (coordJ[0]<longueur) && (coordJ[1]>=0) && (coordJ[1]+1<longueur)) {
								int[] voisin1 = {coordJ[0]-1,coordJ[1]+1} ;
							voisinage.add(voisin1);
							}
							else if ((coordJ[0]>=0) && (coordJ[0]+1<longueur) && (coordJ[1]-1>=0) && (coordJ[1]<longueur)) {
								int[] voisin2 = {coordJ[0]+1,coordJ[1]-1} ;
								voisinage.add(voisin2);
							}
							int longueurvoisinage = voisinage.size() ; 
							if (longueurvoisinage==0) {
								coord[0] = random.nextInt(longueur);
								coord[1] = random.nextInt(longueur);
							}
							else {
								Random random2 = new Random();
								int paire=random2.nextInt(longueurvoisinage);
								int [] voisinalea = voisinage.get(paire);
								y = voisinalea[0];
								x = voisinalea[1];
							}
						}while(!grille[x][y].equals("."));
						grille[x][y]=joueurencours ; 
					}
					else if (nvalignJD2!=ancienaligJD2) {
						do{
							List<int[]> voisinage = new ArrayList<>();
							if ((coordJ[0]-1>=0) && (coordJ[0]<longueur) && (coordJ[1]>=0) && (coordJ[1]+1<longueur)) {
								int[] voisin1 = {coordJ[0]-1,coordJ[1]-1} ;
							voisinage.add(voisin1);
							}
							else if ((coordJ[0]>=0) && (coordJ[0]+1<longueur) && (coordJ[1]>=0) && (coordJ[1]+1<longueur)) {
								int[] voisin2 = {coordJ[0]+1,coordJ[1]+1} ;
								voisinage.add(voisin2);
							}
							int longueurvoisinage = voisinage.size() ; 
							if (longueurvoisinage==0) {
								coord[0] = random.nextInt(longueur);
								coord[1] = random.nextInt(longueur);
							}
							else {
								Random random2 = new Random();
								int paire=random2.nextInt(longueurvoisinage);
								int [] voisinalea = voisinage.get(paire);
								y = voisinalea[0];
								x = voisinalea[1];
							}
						}while(!grille[x][y].equals("."));
						grille[x][y]=joueurencours ; 
					}
					else {
						int i ; 
					    int j ;
						do {
							i = random.nextInt(longueur);
							j = random.nextInt(longueur);
					    } while (!grille[i][j].equals(".")) ;
						grille[i][j]=joueurencours;
					}
					ancienaligJL = nvalignJL ;
					ancienaligJC = nvalignJC ;
					ancienaligJD1 = nvalignJD1 ;
					ancienaligJD2 = nvalignJD2 ;
				}
			}
			cpt ++ ;
			AfficherGrille(grille);
			System.out.println(" ");
			Aligne = Alignement(grille, longalign);
			gagnant = joueurencours ;
			joueurencours = Tour(joueurencours);
		}
		System.out.println(gagnant + " a gagné !");
	}	
	
	public static void JOOption2() {
		int cpt = 0;
		int longalign = ChoixAlignement();
		int longueur = longalign + 3 ;
		String gagnant =""; 
		String [][] grille = Grille(longueur) ; 
		int niv = ChoixNiveau() ;
		grille = Bloque(grille, niv); 
		String joueur =  ChoixSymbole() ;
		String joueurencours = ChoixPremierCoup() ;
		int [] coord = new int[2] ;
		int [] coordJ = new int[2] ;
		Random random = new Random();
		coord[0] = random.nextInt(longueur);
		coord[1] = random.nextInt(longueur);
		coordJ[0] = random.nextInt(longueur);
		coordJ[1] = random.nextInt(longueur);
		int nvalignJD1 = 0;
		int nvalignJD2 = 0;
		int ancienaligJL = 0;
		int ancienaligJC = 0;
		int ancienaligJD1 = 0 ;
		int ancienaligJD2 = 0;
		System.out.println("Larguez les amarres et pas de quartier !");
		AfficherGrille(grille);
		Boolean Aligne = Alignement(grille, longalign);
		while (Aligne == false) {
			if (cpt%3==0) {
				Message();
			}
			if (joueurencours.equals(joueur)) {
				Scanner scanner = new Scanner(System.in);
				String input ;
				String [] coordP ;
				int x ;
				int y ;
				do {
					System.out.println("Entre les coordonnées que t'indique ton compas au format x,y : ") ;
					input = scanner.nextLine();
					coordP = input.split(",");
					x = Integer.parseInt(coordP[0]);
					y = Integer.parseInt(coordP[1]);
				}while(x<1 || x>grille.length || y<1 || y>grille.length || !grille[y-1][x-1].equals("."));
				coordJ[0] = x - 1 ;
				coordJ[1] = y -1 ;
				Jeton(coordJ, joueurencours, grille) ;
			}
			else {
				if (niv==1) {
					int i ; 
				    int j ;
					do {
						i = random.nextInt(longueur);
						j = random.nextInt(longueur);
				    } while (!grille[i][j].equals(".")) ;
					grille[i][j]=joueurencours;
				}
				else if (niv==2) {
					int x = 0;
					int y = 0;
					do {
						// Déclaration d'une liste pour stocker les coordonnées
						List<int[]> voisinage = new ArrayList<>();
						for (int i = -1; i<2; i++) {
							for (int j = -1; j<2; j++) {
								if ((coord[0]+i>=0) && (coord[0]+i<longueur) && (coord[1]+j>=0) && (coord[1]+j<longueur)) {
									//System.out.println(coord[0]+i);
									//System.out.println(coord[1]+j);
									int[] voisin = {coord[0]+i,coord[1]+j};
									voisinage.add(voisin);
								}
							}
						}
						int longueurvoisinage = voisinage.size() ;
						if (longueurvoisinage==0) {
							coord[0] = random.nextInt(longueur);
							coord[1] = random.nextInt(longueur);
						}
						else {
							Random random2 = new Random();
							int paire=random2.nextInt(longueurvoisinage);
							int [] voisinalea = voisinage.get(paire);
							x = voisinalea[0];
							y = voisinalea[1];
							coord[0] = x ;
							coord[1] = y ;
						}
					}while(!grille[x][y].equals("."));
					grille[x][y]=joueurencours ; 
				}
				else if (niv==3){
					int x = 0;
					int y = 0;
					int nvalignJL = CompterAlignementsL(grille, longalign-1, joueur);
					int nvalignJC = CompterAlignementsC(grille, longalign-1, joueur);
					// Compter les alignements sur la première diagonale
				    for (int i = 0; i < grille.length; i++) {
				        for (int j = 0; j <= grille[i].length - longalign-1; j++) {
				            boolean diagonaleAlignee = true;
				            for (int k = 0; k < longalign-1; k++) {
				                int xbis = i + k;
				                int ybis = j - k;
				                if (xbis >= 0 && xbis < grille[i].length && ybis >= 0 && ybis < grille.length) {
			                        if (!grille[ybis][xbis].equals(joueur)) {
			                            diagonaleAlignee = false;
			                            break;
			                        }
			                    } else {
			                        diagonaleAlignee = false; // Considérer que la diagonale n'est pas alignée si hors limites
			                        break;
			                    }
				            }
				            if (diagonaleAlignee) {
				            	nvalignJD1+=1;
				                j+=(longalign-1+1);
				            }
				        }
				    }
				    //System.out.println("D1"+nvalignJD1) ;
				    
				    // Compter les alignements sur la deuxième diagonale
				    for (int i = grille.length - 1; i >= 0; i--) {
				        for (int j = 0; j <= grille[i].length - longalign-1; j++) {
				            boolean diagonaleAlignee = true;
				            for (int k = 0; k < longalign-1; k++) {
				                int xtis = i - k;
				                int ytis = j + k;
				                if (xtis < 0 || ytis >= grille[xtis].length || !grille[xtis][ytis].equals(joueur)) {
				                    diagonaleAlignee = false;
				                    break;
				                }
				            }
				            if (diagonaleAlignee) {
				            	nvalignJD2+=1;
				                j +=(longalign-1+1);
				            }
				        }
				    }
				   // System.out.println("D2"+nvalignJD2) ;
					if (nvalignJL!=ancienaligJL) {
						do{
							List<int[]> voisinage = new ArrayList<>();
							if ((coordJ[0]-1>=0) && (coordJ[0]+1<longueur) && (coordJ[1]>=0) && (coordJ[1]<longueur)) {
								int[] voisin1 = {coordJ[0]-1,coordJ[1]} ;
								int[] voisin2 = {coordJ[0]+1,coordJ[1]} ;
							voisinage.add(voisin1);
							voisinage.add(voisin2);
							}
							int longueurvoisinage = voisinage.size() ; 
							if (longueurvoisinage==0) {
								coord[0] = random.nextInt(longueur);
								coord[1] = random.nextInt(longueur);
							}
							else {
								Random random2 = new Random();
								int paire=random2.nextInt(longueurvoisinage);
								int [] voisinalea = voisinage.get(paire);
								y = voisinalea[0];
								x = voisinalea[1];
							}
						}while(!grille[x][y].equals("."));
						grille[x][y]=joueurencours ; 
					}
					else if (nvalignJC!=ancienaligJC) {
						do{
							List<int[]> voisinage = new ArrayList<>();
							if ((coordJ[0]>=0) && (coordJ[0]<longueur) && (coordJ[1]-1>=0) && (coordJ[1]+1<longueur)) {
								int[] voisin1 = {coordJ[0],coordJ[1]-1} ;
								int[] voisin2 = {coordJ[0],coordJ[1]+1} ;
							voisinage.add(voisin1);
							voisinage.add(voisin2);
							}
							int longueurvoisinage = voisinage.size() ; 
							if (longueurvoisinage==0) {
								coord[0] = random.nextInt(longueur);
								coord[1] = random.nextInt(longueur);
							}
							else {
								Random random2 = new Random();
								int paire=random2.nextInt(longueurvoisinage);
								int [] voisinalea = voisinage.get(paire);
								y = voisinalea[0];
								x = voisinalea[1];
							}
						}while(!grille[x][y].equals("."));
						grille[x][y]=joueurencours ; 
					}
					else if (nvalignJD1!=ancienaligJD1) {
						do{
							List<int[]> voisinage = new ArrayList<>();
							if ((coordJ[0]-1>=0) && (coordJ[0]<longueur) && (coordJ[1]>=0) && (coordJ[1]+1<longueur)) {
								int[] voisin1 = {coordJ[0]-1,coordJ[1]+1} ;
							voisinage.add(voisin1);
							}
							else if ((coordJ[0]>=0) && (coordJ[0]+1<longueur) && (coordJ[1]-1>=0) && (coordJ[1]<longueur)) {
								int[] voisin2 = {coordJ[0]+1,coordJ[1]-1} ;
								voisinage.add(voisin2);
							}
							int longueurvoisinage = voisinage.size() ; 
							if (longueurvoisinage==0) {
								coord[0] = random.nextInt(longueur);
								coord[1] = random.nextInt(longueur);
							}
							else {
								Random random2 = new Random();
								int paire=random2.nextInt(longueurvoisinage);
								int [] voisinalea = voisinage.get(paire);
								y = voisinalea[0];
								x = voisinalea[1];
							}
						}while(!grille[x][y].equals("."));
						grille[x][y]=joueurencours ; 
					}
					else if (nvalignJD2!=ancienaligJD2) {
						do{
							List<int[]> voisinage = new ArrayList<>();
							if ((coordJ[0]-1>=0) && (coordJ[0]<longueur) && (coordJ[1]>=0) && (coordJ[1]+1<longueur)) {
								int[] voisin1 = {coordJ[0]-1,coordJ[1]-1} ;
							voisinage.add(voisin1);
							}
							else if ((coordJ[0]>=0) && (coordJ[0]+1<longueur) && (coordJ[1]>=0) && (coordJ[1]+1<longueur)) {
								int[] voisin2 = {coordJ[0]+1,coordJ[1]+1} ;
								voisinage.add(voisin2);
							}
							int longueurvoisinage = voisinage.size() ; 
							if (longueurvoisinage==0) {
								coord[0] = random.nextInt(longueur);
								coord[1] = random.nextInt(longueur);
							}
							else {
								Random random2 = new Random();
								int paire=random2.nextInt(longueurvoisinage);
								int [] voisinalea = voisinage.get(paire);
								y = voisinalea[0];
								x = voisinalea[1];
							}
						}while(!grille[x][y].equals("."));
						grille[x][y]=joueurencours ; 
					}
					else {
						int i ; 
					    int j ;
						do {
							i = random.nextInt(longueur);
							j = random.nextInt(longueur);
					    } while (!grille[i][j].equals(".")) ;
						grille[i][j]=joueurencours;
					}
					ancienaligJL = nvalignJL ;
					ancienaligJC = nvalignJC ;
					ancienaligJD1 = nvalignJD1 ;
					ancienaligJD2 = nvalignJD2 ;
				}
			}
			cpt ++ ;
			AfficherGrille(grille);
			System.out.println(" ");
			Aligne = Alignement(grille, longalign);
			gagnant = joueurencours ;
			joueurencours = Tour(joueurencours); 
		}
		System.out.println(gagnant + " a gagné, bien joué !");
	}
	
	public static void JOOption3() {
		int longalign = ChoixAlignement();
		int longueur = longalign + 3 ;
		String[][] grille = Grille(longueur);
		String joueur =  ChoixSymbole() ;
		String joueurencours = ChoixPremierCoup() ;
		Random random = new Random();
		System.out.println("Larguez les amarres et pas de quartier !");
		AfficherGrille(grille);
		int cpt = 0;
		int remplie = (longueur)*(longueur);
		while (cpt != remplie) {
			if (cpt%3==0) {
				Message();
			}
			if (joueurencours.equals(joueur)) {
				Jeton(Case(grille), joueurencours, grille) ;
			}
			else {
				int i ; 
				int j ;
				do {
					i = random.nextInt(longueur);
					j = random.nextInt(longueur);
				} while (!grille[i][j].equals(".")) ;
					grille[i][j]=joueurencours;
				}
			AfficherGrille(grille);
			System.out.println(" ");
			joueurencours = Tour(joueurencours);
			cpt++;
		}
		System.out.println("La grille est remplie !");
		int alignX = CompterAlignements(grille, longalign, "X");
        int alignO = CompterAlignements(grille, longalign, "O");
        //System.out.println(alignX);
        //System.out.println(alignO);
		if (alignX > alignO) {
			System.out.println("Bravo les pirates l'emportent avec " + alignX + " alignements ! Vous ne vous en sortirez pas comme ca !");
		}
		else  if (alignO > alignX){
			System.out.println("Bravo les marins gagnent la partie avec " + alignO + " alignements ! Le bien triomphe toujours !");
		}
		else {
			System.out.println("Egalité !");
		}
	}
	
	public static void Test3() {
		int longalign = ChoixAlignement();
		int longueur = longalign + 3 ;
		String joueur =  ChoixSymbole() ; 
		String [][] grille = Grille(longueur) ; 
		String joueurencours = ChoixPremierCoup() ;
		String premier = joueurencours ; 
		System.out.println("Larguez les amarres et pas de quartier ! La bataille à déjà commencée, à toi de porter le coup de grâce ");
		for (int cpt = 1; cpt<(longueur*longueur)-1; cpt++) {
			int i ; 
		    int j ;
			do {
				Random random = new Random();
				i = random.nextInt(longueur);
				j = random.nextInt(longueur);
		    } while (!grille[i][j].equals(".")) ;
			grille[i][j]=joueurencours;
			joueurencours=Tour(joueurencours);
		}
		AfficherGrille(grille);
		System.out.println(" ");
		joueurencours = premier ; 
		for (int cpt1 = 0; cpt1<2; cpt1++) {
			if (joueurencours.equals(joueur)) {
				Jeton(Case(grille), joueurencours, grille) ;
			}
			else {
				Random random2 = new Random();
				int i ; 
				int j ;
				do {
					i = random2.nextInt(longueur);
					j = random2.nextInt(longueur);
				} while (!grille[i][j].equals(".")) ;
				grille[i][j]=joueurencours;
			}
			AfficherGrille(grille);
			joueurencours = Tour(joueurencours);
		}
		System.out.println("La grille est remplie !");
		int alignX = CompterAlignements(grille, longalign, "X");
        int alignO = CompterAlignements(grille, longalign, "O");
		if (alignX > alignO) {
			System.out.println("Bravo les pirates l'emportent avec " + alignX + " alignements ! Vous ne vous en sortirez pas comme ca !");
		}
		else if (alignO > alignX) {
			System.out.println("Bravo les marins gagnent la partie avec " + alignO + " alignements ! Le bien triomphe toujours !");
		}
		else {
			System.out.println("Egalité, les deux joueurs ont réalisé le même nombre d'alignements ! Revanche ?");
		}
	}
	
	//Programme de test 
	public static void main (String[] args) {
		Boolean premier = ChoixDebFin();
		while(premier) {
			int mode = ChoixModeDeJeu();
			int option = ChoixOption();
			if (mode == 1) {
				if (option == 1) {
					DJOption1();
					premier = ChoixDebFin();
				}
				else if (option == 2) {
					DJOption2();
					premier = ChoixDebFin();
				}
				else {
					int partie = ChoixPartie();
					if (partie == 2) {
						DJOption3();
						premier = ChoixDebFin();
					}
					else {
						int choixtest = 0;
						System.out.println("Tu préfères participer à la bataille ou observer ?");
						System.out.println("1 - Je suis pas une mauviette, je participe évidemment !");
						System.out.println("2 - J'observe avec ma longue vue ");
						while(true) {
							System.out.println("Ton choix ?");
							choixtest = scanner.nextInt();
							if (choixtest == 1 || choixtest == 2) {
								break;
							}
							else {
								System.out.println("Attention ! Entre un nombre entre 1 et 2");
							}
						}
						if (choixtest==1) {
							Test1();
							premier = ChoixDebFin();
						}
						else {
							Test2();
							premier = ChoixDebFin();
						}
					}
				}
			}
			else {
				if (option == 1) {
					JOOption1();
					premier = ChoixDebFin();
				}
				else if (option == 2) {
					JOOption2();
					premier = ChoixDebFin();
				}
				else {
					int partie2 = ChoixPartie();
					if (partie2 ==2) {
						JOOption3();
						premier = ChoixDebFin();
					}
					else {
						Test3();
						premier = ChoixDebFin();
						
					}
				}
			}
		}
		System.out.println("A bientot !");
	}
}//Fin de la classe main
