package cupcake.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import cupcake.entity.AdresseFacturation;
import cupcake.entity.AdresseLivraison;
import cupcake.entity.Article;
import cupcake.entity.ArticleCde;
import cupcake.entity.Client;
import cupcake.entity.Commande;
import cupcake.service.GestionClient;
import cupcake.ui.model.CdeTableModel;
import cupcake.ui.model.ClientTableModel;
import cupcake.ui.model.CommandesTableModel;
import cupcake.ui.panel.PanelAdresseLivraison;
import cupcake.ui.panel.PanelBouton;
import cupcake.ui.panel.PanelCarteClient;
import cupcake.ui.panel.PanelCde;
import cupcake.ui.panel.PanelInfosCde;
import cupcake.ui.panel.PanelMajCde;
import cupcake.ui.panel.PanelRecherche;
import cupcake.ui.panel.PanelTable;
import cupcake.ui.panel.PanelTableCde;
import cupcake.ui.panel.panelListeCommandes;
import cupcake.ui.renderer.ArticleRenderer;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	private GestionClient gestion;
	private ArrayList<Client> clients;

	List<Client> liste;
	private PanelRecherche panelRecherche;
	private PanelTable panelTable;
	private String nom;
	private String prenom;
	private PanelBouton panelBouton;
	private int resultat;
	private PanelCarteClient panelCarteClient;
	// private PanelBoutonValider panelBoutonValider;
	private panelListeCommandes panelListeCommandes;
	// private PanelBoutonCommande panelBoutonCommande;
	// private PanelTableCommandes panelTableCommandes;
	// private PanelInfos panelInfos;
	private PanelTableCde panelTableCde;
	private PanelCde panelCde;
	private PanelInfosCde panelInfosCde;
	ArrayList<ArticleCde> articlesCdes;
	private int rowCde;
	private ArrayList<Commande> cdes;
	private PanelAdresseLivraison panelAdresseLivraison;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		try {

			gestion = new GestionClient();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 390);
		contentPane = new PanelRecherche();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		clients = new ArrayList<Client>();
		contentPane.setLayout(new BorderLayout(0, 0));

		panelRecherche = new PanelRecherche();
		contentPane.add(panelRecherche, BorderLayout.NORTH);
		panelListeCommandes = new panelListeCommandes();
		panelCde = new PanelCde();
		panelAdresseLivraison = new PanelAdresseLivraison();

		// ajout d'un evenement sur le champ du nom dans la main frame
		panelRecherche.getEtNom().addCaretListener(new CaretListener() {

			public void caretUpdate(CaretEvent e) {
				// appel du client lorsque que l'on renseigne les champs dédiés et
				// remplissage du tableau

				LoadClients(true);

			}
		});
		panelRecherche.getEtPrenom().addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent arg0) {
				LoadClients(true);
			}
		});
		panelRecherche.getEtNumclient().addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent arg0) {

				try {
					LoadClients(false);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		panelCarteClient = new PanelCarteClient(); 

		panelBouton = new PanelBouton();
		panelBouton.getBtnCarteClient().setVisible(false);
		contentPane.add(panelBouton, BorderLayout.SOUTH);

		panelTable = new PanelTable(clients);
		contentPane.add(panelTable, BorderLayout.CENTER);
		panelTable.setLayout(new GridLayout(1, 0, 0, 0));
		// installation d'un evenement sur le tableau des clients
		panelTable.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				panelBouton.getBtnCarteClient().setVisible(true);
				// recuperation de la ligne selectionée
				int row = panelTable.getTable().getSelectedRow();
				// recuperation de la valeur a la ligne selectionée à la colonne 0
				resultat = (int) panelTable.getTable().getValueAt(row, 0);

			}

		});
		// installation d'un evenement sur le bouton carte client dans la main frame

		panelBouton.getBtnCarteClient().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					// appel de la methode qui affiche la carte du client selectionné à
					// à la place du panel liste des clients
					Client carteClient = gestion.getCarteClient(resultat);
					contentPane.remove(panelBouton);
					contentPane.remove(panelRecherche);
					contentPane.remove(panelTable);
					contentPane.repaint();
					contentPane.add(panelCarteClient);
					contentPane.revalidate();
					int nbcdes = carteClient.getNbcdes();

					// faire disparaitre le bouton liste des commandes si le nb de
					// commandes est plus petit que 0
					panelCarteClient.getPanelBoutonCommande().getBtnListeDesCommandes()
							.setVisible(nbcdes > 0);
					// affichage des infos de la carte client dans les champs dediés
					panelCarteClient.getEtId().setText(
							Integer.toString(carteClient.getId()));
					panelCarteClient.getEtCp().setText(
							Integer.toString(carteClient.getAdresseFacturation().getCp()));
					panelCarteClient.getEtEmail().setText((carteClient.getEmail()));
					panelCarteClient.getEtNom().setText(carteClient.getNom());
					panelCarteClient.getEtNum()
							.setText(
									Integer.toString(carteClient.getAdresseFacturation()
											.getNumero()));
					panelCarteClient.getEtRue().setText(
							carteClient.getAdresseFacturation().getLibelleVoie());
					panelCarteClient.getEtPrenom().setText(carteClient.getPrenom());
					panelCarteClient.getEtVille().setText(
							carteClient.getAdresseFacturation().getLocalite());
					panelCarteClient.getEtTelFixe().setText(carteClient.getTelFixe());
					panelCarteClient.getEtTelMobile().setText(carteClient.getTelMobile());

				} catch (Exception e) {

					e.printStackTrace();
				}
			}

		});
		// ajout d'un evenement sur le bouton valider dans le panel carte client

		panelCarteClient.getPanelBoutonValider().getBtnValider()
				.addMouseListener(new MouseAdapter() {

					@Override
					// recuperation des valeurs des champs de carte client
					public void mouseClicked(MouseEvent arg0) {
						int id = Integer.parseInt(panelCarteClient.getEtId().getText());
						String nom = panelCarteClient.getEtNom().getText();

						String prenom = panelCarteClient.getEtPrenom().getText();
						String email = panelCarteClient.getEtEmail().getText();
						int numero = Integer
								.parseInt(panelCarteClient.getEtNum().getText());
						int cp = Integer.parseInt(panelCarteClient.getEtCp().getText());
						String rue = panelCarteClient.getEtRue().getText();
						String ville = panelCarteClient.getEtVille().getText();
						String telFixe = panelCarteClient.getEtTelFixe().getText();
						String telMobile = panelCarteClient.getEtTelMobile().getText();

						// affectation des valeurs recuperées afin de preparer l'insertion
						// dans la base de données
						Client client = new Client();
						AdresseFacturation adresseFacturation = new AdresseFacturation();
						adresseFacturation.setCp(cp);
						adresseFacturation.setLibelleVoie(rue);
						adresseFacturation.setNumero(numero);
						adresseFacturation.setLocalite(ville);
						client.setId(id);
						client.setNom(nom);
						client.setPrenom(prenom);
						client.setEmail(email);
						client.setTelFixe(telFixe);
						client.setTelMobile(telMobile);
						client.setAdresseFacturation(adresseFacturation);

						try {
							ArrayList<String> liste = new ArrayList<String>();
							liste.add(ville);
							liste.add(rue);
							liste.add(email);
							liste.add(prenom);
							liste.add(nom);
							liste.add(Integer.toString(numero));
							liste.add(Integer.toString(cp));
							String patternTel = "^([0-9]{10})|(.{0})$";
							String patternEmail = "^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\\.[a-z]{2,4}$";
							boolean checkEmail = Pattern.matches(patternEmail, email);
							boolean CheckTelFixe = Pattern.matches(patternTel, telFixe);
							boolean CheckTelMobile = Pattern.matches(patternTel, telMobile);
							// mise à jour de la base de données avec les nouvelles valeurs
							// venant de la carte client
							if (checkFields(liste)
									&& (CheckEmptyField(telFixe) || CheckEmptyField(telMobile))) {
								if (checkEmail && CheckTelFixe && CheckTelMobile) {
									initTextFieldsCarteclient();
									gestion.updateClient(client);
								} else {
									if (!CheckTelFixe) {
										panelCarteClient.getEtTelFixe().setBorder(
												new LineBorder(Color.RED));
									}
									if (!CheckTelMobile) {
										panelCarteClient.getEtTelMobile().setBorder(
												new LineBorder(Color.RED));
									}
									if (!checkEmail) {
										panelCarteClient.getEtEmail().setBorder(
												new LineBorder(Color.RED));
									}
									javax.swing.JOptionPane.showMessageDialog(null,
											"Ce champ n'est pas valide");
								}

							} else {
								javax.swing.JOptionPane.showMessageDialog(null,
										"Ce champ ne peut pas être vide");

							}

						} catch (Exception e) {

							e.printStackTrace();
						}

					}
				});
		panelCarteClient.getPanelBoutonListeClients().getBtnListeClients()
				.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {
						// retour au panel de la iste des clients
						changePanelClients();
					}

				});
		// ajout d'un evenement sur le bouton de la liste des commandes
		panelCarteClient.getPanelBoutonCommande().getBtnListeDesCommandes()
				.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {

						try {
							// appel de la methode qui ramene la liste des commandes du client
							// dans la liste qui va remplir le tableau
							// de la liste des commandes du client en question

							cdes = gestion.getCdes(resultat);

							Client cli = new Client();

							panelListeCommandes.setCommandes(cdes);
							for (Commande cde : cdes) {
								// recuperation du client
								cli = cde.getClient();

							}
							// initialisation des champs dans le panel liste des commandes
							// prevus à cet effet (panelInfosClient)
							panelListeCommandes.getPanelInfos().getEtNom()
									.setText(cli.getNom());
							panelListeCommandes.getPanelInfos().getEtPrenom()
									.setText(cli.getPrenom());
							panelListeCommandes.getPanelInfos().getEtNumClient()
									.setText(Integer.toString(cli.getId()));
							// remplacement du panneau de la carte client par le panel de la
							// liste des commandes
							changePanel(panelListeCommandes);
						} catch (Exception e) {

							e.printStackTrace();
						}

					}

				});

		// ajout d'un evenement double click sur le tableau
		// de la liste des commandes

		panelListeCommandes.getPanelTableCommandes().getTableCommandes()
				.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						if (e.getClickCount() == 2) {
							GetCdeTableModel().clearCde();
							// initialisation de la liste qui va remplir le tableau
							// des articles commandés
							articlesCdes = null;
							// recuperation de la ligne selectionnée dans le tableau
							// de la liste des cdes
							int row = panelListeCommandes.getPanelTableCommandes()
									.getTableCommandes().getSelectedRow();
							// recuperation de la valeur se trouvant à la ligne
							// selectionée dans la colonne où
							// se trouve le numclient
							int numCde = (int) panelListeCommandes.getPanelTableCommandes()
									.getTableCommandes().getValueAt(row, 0);
							try {
								// appel de la methode qui ramene les informations de
								// la commandes choisie
								Commande cde = gestion.getCde(numCde);
								// remplissage de la liste des infos de la commande
								// choisie
								articlesCdes = cde.getArticlesCde();
								// si aucun article commandé n'existe que cela ne
								// renvoie rien
								if (articlesCdes == null) {

									return;

								}
								String statut;
								// remplissage des champs dans le panel infos cde
								if (!articlesCdes.isEmpty()) {
									panelCde.getPanelInfosCde().getEtNom()
											.setText(cde.getClient().getNom());
									panelCde.getPanelInfosCde().getEtPrenom()
											.setText(cde.getClient().getPrenom());
									panelCde.getPanelInfosCde().getEtNumCde()
											.setText(Integer.toString(cde.getId()));
									panelCde.getPanelInfosCde().getEtStatut()
											.setText(cde.getStatut());

									// recuperation du statut
									statut = panelCde.getPanelInfosCde().getEtStatut().getText()
											.toString();
									// boucle qui ajoute les articles commandés dans le
									// tableau tant qu'il y en a

									for (ArticleCde articlecde : articlesCdes) {
										GetCdeTableModel().addRowCde(articlecde);
									}

									// ajout du statut fermé dans le combo box statut
									// (panel infos cde)

									// si le statut de la cde choisie est fermé , omission
									// du panneau de mise à jour de la cde
									if (statut.equals("fermé")) {
										panelCde.getPanelMajCde().setVisible(false);
									}
									JComboBox comboref = panelCde.getPanelMajCde()
											.getComboReference();
									// initialisation d'une liste qui va recuperer à
									// l'aide la methode getArticles
									// tous les articles de la base
									ArrayList<Article> references = gestion.getArticles();
									comboref.setRenderer(new ArticleRenderer());
									String ref;
									// eclatement de la liste pour recuperer les
									// references et les intitulés des articles

									for (Article article : references) {
										// affectation des valeurs dans le combo box
										// reference
										comboref.addItem(article);
									}
								}
							} catch (Exception e1) {

								e1.printStackTrace();
							}
							// changement du panel liste des commandes apres le
							// double click
							String value = GetCdesTableModel().getValueAt(row, 2).toString();
							changePanel(panelCde);
							if (value.equals("ouvert")) {
								panelCde.getPanelMajCde().setVisible(true);
							}
						}
					}
				});
		panelListeCommandes.getPanelInfos().getBtnCarteClient()
				.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {
						changePanel(panelCarteClient);
					}

				});

		panelListeCommandes.getPanelInfos().getBtnListeDesClients()
				.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {
						changePanel(panelCarteClient);
					}

				});
		// ajout d'un evenement click sur le tableau cde

		this.panelCde.getPanelTableCde().getTable()

		.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {

				// recuperation de la valeur dans le spinner
				// quantite
				JSpinner spinnerQuantite = panelCde.getPanelMajCde()
						.getSpinnerQuantite();
				// recuperation de la valeur dans le combo
				// reference
				// panelCde.getPanelMajCde().getComboReference();
				JComboBox comboref = panelCde.getPanelMajCde().getComboReference();
				// recuperation de la ligne selectionée dans
				// le tableau de la cde
				rowCde = panelCde.getPanelTableCde().getTable().getSelectedRow();
				// initialisation de la valeur du combo
				// quantite par rapport
				// à la quantité de la ligne selectionnées
				spinnerQuantite.setValue(GetCdeTableModel().getValueAt(rowCde, 2));
				// recuperation de la reference a la ligne
				// selectionnées dans le tableau de la cde
				String refint = (String) GetCdeTableModel().getValueAt(rowCde, 1);

				Article art;

				// on parcourt la liste dans le comboref et on
				// compare ce qui est ecrit dans le tableau
				// avec ce qui est ecrit dans la liste et on
				// affiche dans le combo la bonne reference.
				for (int i = 0; i < comboref.getItemCount(); i++) {
					art = (Article) comboref.getItemAt(i);
					if (art.getIntitule().equals(refint)) {
						comboref.setSelectedIndex(i);
					}

				}
			}

		});
		// ajout d'un evenement click sur le bouton Valider dans le
		// panel maj cde
		panelCde.getPanelMajCde().getBtnValider()
				.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {

						// recuperation du numero de commande
						String numCde = panelCde.getPanelInfosCde().getEtNumCde().getText()
								.toString();
						// convertion du numero de commande en integer
						int i = Integer.parseInt(numCde);
						// recuperation du statut choisi

						Article ref = new Article();
						// recuperation de la reference choisie dans
						// le combo ref
						ref = (Article) panelCde.getPanelMajCde().getComboReference()
								.getSelectedItem();
						String refer = ref.getReference();

						// recuperation de la quantité dans le spinner
						// quantite
						int quantite = (int) panelCde.getPanelMajCde().getSpinnerQuantite()
								.getValue();
						// recuperation de la reference à la ligne
						// Selectionée dans le tableau cde et de sa
						// valeur (reference)

						int rowCde = panelCde.getPanelTableCde().getTable()
								.getSelectedRow();
						if (rowCde < 0) {
							javax.swing.JOptionPane.showMessageDialog(null,
									"Veuillez choisir une ligne à modifier");
						} else {

							String oldRef = (String) GetCdeTableModel().getValueAt(rowCde, 0);
							// initialisation de la quantité pour etre
							// entrée dans la base de données
							ArticleCde art = new ArticleCde();
							art.setQuantite(quantite);

							try {

								if (checkMinimum(refer, quantite)) {
									// appel de la methode qui met à jour la
									// commande
									gestion.updateCommande(i, refer, oldRef, quantite);
								}
							} catch (Exception e) {

								e.printStackTrace();
							}
							// rechargement du panel cde
							changePanel(panelCde);
							GetCdeTableModel().clearCde();

							Commande cde1;

							try {
								// rechargement du tableau cde
								cde1 = gestion.getCde(i);
								articlesCdes = cde1.getArticlesCde();
								if (!articlesCdes.isEmpty()) {
									for (ArticleCde articlecde : articlesCdes) {
										GetCdeTableModel().addRowCde(articlecde);

									}
									contentPane.repaint();
									contentPane.revalidate();
								}
							} catch (Exception e) {

								e.printStackTrace();
							}

						}
					}
				});
		panelCde.getPanelMajCde().getBtnSupprimerArticle()
				.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {

						// recuperation du numero de commande
						String numCde = panelCde.getPanelInfosCde().getEtNumCde().getText()
								.toString();
						// convertion du numero de commande en integer
						int i = 0;
						if (!numCde.isEmpty()) {
							i = Integer.parseInt(numCde);
						}
						// recuperation de la reference à la ligne
						// Selectionée dans le tableau cde et de sa
						// valeur (reference)
						int rowCde = panelCde.getPanelTableCde().getTable()
								.getSelectedRow();
						if (rowCde < 0) {
							javax.swing.JOptionPane.showMessageDialog(null,
									"Veuillez choisir une ligne à supprimer");
						} else {
							String oldRef = (String) GetCdeTableModel().getValueAt(rowCde, 0);
							try {
								gestion.deleteArticleCde(i, oldRef);

							} catch (Exception e) {

								e.printStackTrace();
							}

							GetCdeTableModel().clearCde();

							Commande cde1;

							try {
								// rechargement du tableau cde
								cde1 = gestion.getCde(i);
								articlesCdes = cde1.getArticlesCde();
								if (!articlesCdes.isEmpty()) {
									for (ArticleCde articlecde : articlesCdes) {
										GetCdeTableModel().addRowCde(articlecde);
									}
									contentPane.repaint();
									contentPane.revalidate();
								} else {
									contentPane.removeAll();
									contentPane.repaint();
									cdes = gestion.getCdes(resultat);
									if (!cdes.isEmpty()) {
										panelListeCommandes.setCommandes(cdes);
										contentPane.add(panelListeCommandes);
									} else {
										contentPane.add(panelCarteClient);
										panelCarteClient.getPanelBoutonCommande()
												.getBtnListeDesCommandes().setVisible(false);

									}
									contentPane.revalidate();
								}
							} catch (Exception e) {

								e.printStackTrace();
							}

						}
					}

				});
		panelCde.getPanelMajCde().getBtnAjouterArticle()
				.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {
						String numCde = panelCde.getPanelInfosCde().getEtNumCde().getText()
								.toString();
						int i = Integer.parseInt(numCde);

						// recuperation de la reference choisie dans
						// le combo ref
						Article articleCmb = (Article) panelCde.getPanelMajCde()
								.getComboReference().getSelectedItem();

						String refer = articleCmb.getReference();

						// recuperation de la quantité dans le spinner
						// quantite
						int quantite = (int) panelCde.getPanelMajCde().getSpinnerQuantite()
								.getValue();
						try {

							ArticleCde articleCde = getArticleCdeByRef(refer);

							if (articleCde != null) // si existe on met à jour la quantité
							{
								articleCde.setQuantite(articleCde.getQuantite() + quantite);
								if (quantite > 0) {
									gestion.updateCommande(i, refer, refer,
											articleCde.getQuantite());
								} else {
									javax.swing.JOptionPane.showMessageDialog(null,
											"Merci de choisir une quantité supérieure à 0");
								}
							} else // si la reference n'existe pas on ajoute

							if (checkMinimum(refer, quantite)) {
								gestion.addArticleCde(i, refer, quantite);
							}

							Commande cde1 = gestion.getCde(i);
							// rechargement du tableau cde

							articlesCdes = cde1.getArticlesCde();

							if (!articlesCdes.isEmpty()) {
								GetCdeTableModel().clearCde();

								for (ArticleCde articlecde : articlesCdes) {
									GetCdeTableModel().addRowCde(articlecde);
								}

								contentPane.repaint();
								contentPane.revalidate();
							}
						} catch (Exception e) {

							e.printStackTrace();
						}

					}

				});

		panelCde.getPanelMajCde().getBtnModifierStatut()
				.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {

						try {

							gestion.updateStatut(PanelCdeGetNumCde());
							panelCde.getPanelInfosCde().getEtStatut().setText("fermé");
							contentPane.repaint();
							contentPane.revalidate();
							panelCde.getPanelMajCde().setVisible(false);
							contentPane.revalidate();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				});

		panelCde.getPanelBoutonsRetour().getBtnListeCommandes()
				.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {
						try {
							cdes = gestion.getCdes(resultat);
							panelListeCommandes.setCommandes(cdes);
							changePanel(panelListeCommandes);

						} catch (Exception e) {
							e.printStackTrace();
						}

					}

				});
		panelCde.getPanelBoutonsRetour().getBtnCarteClient()
				.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {
						changePanel(panelCarteClient);
					}
				});

		panelCde.getPanelBoutonsRetour().getBtnListeClients()
				.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {
						changePanelClients();
					}
				});
		panelCde.getPanelBoutonsRetour().getBtnAdresseLivraison()
				.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {
						AdresseLivraison adrLiv;
						try {
							adrLiv = gestion.getAdrLivraison(PanelCdeGetNumCde());
							panelAdresseLivraison.getEtNumCde().setText(
									Integer.toString(PanelCdeGetNumCde()));
							panelAdresseLivraison.getEtNom().setText(adrLiv.getNom());
							panelAdresseLivraison.getEtcp().setText(
									Integer.toString(adrLiv.getCp()));
							panelAdresseLivraison.getEtInfosComplementaires().setText(
									adrLiv.getInfoComplementaires());
							panelAdresseLivraison.getEtNum().setText(
									Integer.toString(adrLiv.getNumero()));
							panelAdresseLivraison.getEtPrenom().setText(adrLiv.getPrenom());
							panelAdresseLivraison.getEtRue().setText(adrLiv.getLibelleVoie());
							panelAdresseLivraison.getEtTelFixe().setText(adrLiv.getTelFixe());
							panelAdresseLivraison.getEtTelMobile().setText(
									adrLiv.getTelMobile());
							panelAdresseLivraison.getEtVille().setText(adrLiv.getLocalite());
							panelAdresseLivraison.getEtCodePorte().setText(
									adrLiv.getCodePorte());

							panelAdresseLivraison.getEtEtage().setText(
									Integer.toString(adrLiv.getEtage()));
						} catch (Exception e) {
							e.printStackTrace();
						}
						changePanel(panelAdresseLivraison);
					}
				});
		panelAdresseLivraison.getPanelBoutonValider().getBtnValider()
				.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {

						String nom = panelAdresseLivraison.getEtNom().getText();
						String prenom = panelAdresseLivraison.getEtPrenom().getText();
						int numero = Integer.parseInt(panelAdresseLivraison.getEtNum()
								.getText());
						int cp = Integer
								.parseInt(panelAdresseLivraison.getEtcp().getText());
						String rue = panelAdresseLivraison.getEtRue().getText();
						String ville = panelAdresseLivraison.getEtVille().getText();
						String telFixe = panelAdresseLivraison.getEtTelFixe().getText();
						String telMobile = panelAdresseLivraison.getEtTelMobile().getText();
						String infos = panelAdresseLivraison.getEtInfosComplementaires()
								.getText();
						String codeporte = panelAdresseLivraison.getEtCodePorte().getText();
						int etage = Integer.parseInt(panelAdresseLivraison.getEtEtage()
								.getText());

						AdresseLivraison adrLiv = new AdresseLivraison();

						adrLiv.setCp(cp);
						adrLiv.setLibelleVoie(rue);
						adrLiv.setNumero(numero);
						adrLiv.setLocalite(ville);
						adrLiv.setNom(nom);
						adrLiv.setPrenom(prenom);
						adrLiv.setTelFixe(telFixe);
						adrLiv.setTelMobile(telMobile);
						adrLiv.setInfoComplementaires(infos);
						adrLiv.setCodePorte(codeporte);
						adrLiv.setEtage(etage);
						try {
							ArrayList<String> liv = new ArrayList<String>();
							liv.add(ville);
							liv.add(rue);
							liv.add(prenom);
							liv.add(nom);
							liv.add(Integer.toString(numero));
							liv.add(Integer.toString(cp));
							liv.add(codeporte);
							liv.add(Integer.toString(etage));

							// mise à jour de la base de données avec les nouvelles valeurs
							// venant de l'adresse de livraison

							String patternTel = "^([0-9]{10})|(.{0})$";
							String patternEmail = "^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\\.[a-z]{2,4}$";
							boolean CheckTelFixe = Pattern.matches(patternTel, telFixe);
							boolean CheckTelMobile = Pattern.matches(patternTel, telMobile);
							// mise à jour de la base de données avec les nouvelles valeurs
							// venant de l'adresse de livraison bdd
							if (checkFields(liv)
									&& (CheckEmptyField(telFixe) || CheckEmptyField(telMobile))) {
								if (CheckTelFixe && CheckTelMobile) {
									initTextFieldsAdrLiv();
									gestion.UpdateAdrLivraison(PanelCdeGetNumCde(), adrLiv);
								} else {
									if (!CheckTelFixe) {
										panelAdresseLivraison.getEtTelFixe().setBorder(
												new LineBorder(Color.RED));
									}
									if (!CheckTelMobile) {
										panelAdresseLivraison.getEtTelMobile().setBorder(
												new LineBorder(Color.RED));
									}
									javax.swing.JOptionPane.showMessageDialog(null,
											"Ce champ n'est pas valide");

								}

							} else {
								javax.swing.JOptionPane.showMessageDialog(null,
										"Ce champ ne peut pas être vide");

							}

						} catch (Exception e) {

							e.printStackTrace();
						}
					}

				});
		panelAdresseLivraison.getBtnCarteClient().addMouseListener(
				new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {
						changePanel(panelCarteClient);
					}

				});
		panelAdresseLivraison.getBtnCommande().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				changePanel(panelCde);
			}

		});
		panelAdresseLivraison.getBtnListeClients().addMouseListener(
				new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {
						changePanelClients();
					}

				});
		panelAdresseLivraison.getBtnListeCommande().addMouseListener(
				new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent arg0) {
						changePanel(panelListeCommandes);
					}

				});
	}

	private void changePanelClients() {
		contentPane.removeAll();
		contentPane.repaint();
		contentPane.add(panelBouton);
		contentPane.add(panelTable);
		contentPane.add(panelRecherche);
		// reinitialisation du tableau de la liste des clients
		GetClientTableModel().clear();
		contentPane.revalidate();
	}

	private void changePanel(JPanel panel) {
		contentPane.removeAll();
		contentPane.repaint();
		contentPane.add(panel);
		contentPane.revalidate();
	}

	private void initTextFieldsCarteclient() {
		JTextField[] textFields = { panelCarteClient.getEtTelFixe(),
				panelCarteClient.getEtTelMobile(), panelCarteClient.getEtEmail() };
		for (JTextField f : textFields) {
			f.setBorder(new LineBorder(Color.GRAY));
		}
	}

	private void initTextFieldsAdrLiv() {
		JTextField[] textFields = { panelAdresseLivraison.getEtTelFixe(),
				panelAdresseLivraison.getEtTelMobile() };
		for (JTextField f : textFields) {
			f.setBorder(new LineBorder(Color.GRAY));
		}
	}

	private ArticleCde getArticleCdeByRef(String refer) {
		for (ArticleCde articleCde : articlesCdes) {
			if (articleCde.getArticle().getReference().equals(refer)) {
				return articleCde;
			}
		}
		return null;
	}

	private int PanelCdeGetNumCde() {
		String numCde = panelCde.getPanelInfosCde().getEtNumCde().getText()
				.toString();
		// convertion du numero de commande en integer
		int i = 0;
		if (!numCde.isEmpty()) {
			i = Integer.parseInt(numCde);
		}
		return i;
	}

	private Boolean checkMinimum(String reference, int quantite) {
		if (reference.startsWith("09") && quantite < 10) {
			javax.swing.JOptionPane.showMessageDialog(null,
					"La quantité minimum de cupcakes est de 10 unités");
			return false;
		} else if (reference.startsWith("1") && quantite < 1) {
			javax.swing.JOptionPane.showMessageDialog(null,
					"la quantité minimum est de 1");
			return false;
		}
		return true;
	}

	private boolean CheckEmptyField(String field) {
		if (!field.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	private boolean checkFields(ArrayList<String> liste2) {
		for (String field : liste2) {
			if (!CheckEmptyField(field))
				return false;
		}
		return true;
	}

	// methodes de recuperation des models des tables
	private CdeTableModel GetCdeTableModel() {
		return (CdeTableModel) panelCde.getPanelTableCde().getTable().getModel();
	}

	private CommandesTableModel GetCdesTableModel() {
		return (CommandesTableModel) panelListeCommandes.getPanelTableCommandes()
				.getTableCommandes().getModel();
	}

	private ClientTableModel GetClientTableModel() {
		return (ClientTableModel) panelTable.getTable().getModel();
	}

	// methode qui recupere les clients de la base et qui rempli le tableau des
	// clients
	private void LoadClients(boolean Traitement) {

		try {
			panelBouton.getBtnCarteClient().setVisible(false);
			int i = 0;
			GetClientTableModel().clear();
			if (Traitement) {
				this.nom = panelRecherche.getEtNom().getText();
				this.prenom = panelRecherche.getEtPrenom().getText();
				liste = gestion.getClients(nom, prenom);
			} else {
				String numclient = panelRecherche.getEtNumclient().getText().toString();
				if (numclient.isEmpty()) {
					i = 0;
				} else {
					String patternId = "^[0-9]+$";
					boolean checkId = Pattern.matches(patternId, numclient);
					if (checkId) {
						i = Integer.parseInt(numclient);
					} else {
						javax.swing.JOptionPane.showMessageDialog(null,
								"Ce champ peut contenir uniquement des valeurs numériques");
						Runnable clearText = new Runnable() {
							public void run() {
								panelRecherche.getEtNumclient().setText("");
							}
						};

						SwingUtilities.invokeLater(clearText);
					}
				}
				liste = gestion.getClient(i);
			}
			if (liste == null) {
				return;
			}
			for (Client client : liste) {
				GetClientTableModel().addRow(client);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		ArrayList<Commande> cdes = null;
		try {
			cdes = gestion.getCdes(resultat);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
