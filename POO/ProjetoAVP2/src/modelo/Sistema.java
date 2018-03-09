
package modelo;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sistema {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		Metodo teste = new Metodo();

		boolean ativado = true;
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		ArrayList<Professor> professores = new ArrayList<Professor>();
		ArrayList<Metodo> metodos = new ArrayList<Metodo>();

		ArrayList<Disciplina> molde = new ArrayList<Disciplina>();
		while (ativado) {
			try {
				int opcao = 0;
				System.out.println("Opcoes :");
				System.out.println("1-Aluno");
				System.out.println("2-Professor");

				opcao = leitor.nextInt();
				if (opcao == 1) {
					System.out.println("Opcoes :");
					System.out
							.println("1-Criar Aluno\n2-Deletar Aluno\n3-Atualizar aluno\n4-Mostrar notas");
					int opcao1 = leitor.nextInt();
					if (opcao1 == 1) {
						System.out.println("Digite um nome:");
						String auxnome = leitor.next();
						Aluno adcAluno = new Aluno(auxnome);
						alunos.add(adcAluno);
					} else if (opcao1 == 2) {
						System.out.println("Qual o aluno ?");
						for (int i = 0; i < alunos.size(); i++) {
							System.out.println(i + "-"
									+ alunos.get(i).getNome());
						}
						alunos.remove(leitor.nextInt());

					} else if (opcao1 == 3) {
						System.out.println("Qual o aluno ?");
						for (int i = 0; i < alunos.size(); i++) {
							System.out.println(i + "-"
									+ alunos.get(i).getNome());
						}

						try {
							int indexAluno = leitor.nextInt();
							Aluno alunoAux = alunos.get(indexAluno);
							System.out.println("Digite o nome que quer por :");
							alunos.get(indexAluno).setNome(leitor.next());

						} catch (Exception ex) {
							System.out.println("Opçao invalida!");
							leitor.next();
							continue;
						}

					} else if (opcao1 == 4) {
						for (Professor prof : professores) {
							System.out.println("Professor " + prof.getNome()
									+ ": ");
							for (Disciplina disci : prof.disciplinas) {
								System.out.print("\tDisciplina "
										+ disci.getNome() + ": ");
								for (Avaliacao ava : disci.getMetodologia().listaAvaliacao) {
									System.out.print(ava.getNome() + "( ");
									for (Subavaliacao subava : ava
											.getListaSubAvl()) {
										System.out
												.print(subava.getNome() + " ");
									}
									System.out.print(")  ");
								}
								System.out.println();
								for (Aluno discentes : disci.getAlunos()) {
									int numNotas = 0;
									System.out.print("\t\t"
											+ discentes.getNome() + " ( ");
									try {
										if (discentes.avaliacoes.get(0).listaSubAvl
												.get(0).nota == null)
											System.out
													.println("Nenhuma nota ainda!)");
									} catch (Exception e) {
										System.out
												.println("Nenhuma nota ainda!)");
									}
									for (Avaliacao ava : discentes.avaliacoes) {
										System.out.print(ava.getNome() + " ");
										for (Subavaliacao subava : ava
												.getListaSubAvl()) {
											System.out.print(subava.getNota()
													+ " ");
											numNotas++;
											discentes.media += subava.getNota();
										}
										System.out.print(")  ");
									}
									discentes.media = discentes.getMedia()
											/ numNotas;
									String result = "";
									if (discentes.media < 4)
										result = "REPROVADO !";
									else if (discentes.media >= 7)
										result = "APROVADO !";
									else if (discentes.media >= 4
											&& discentes.media < 7)
										result = "AVF!!";

									System.out
											.println("Media: "
													+ discentes.media + " - >"
													+ result);
									if (discentes.media >= 4
											&& discentes.media < 7) {
										System.out
												.println("Digite a nota da avf  :");
										float avf = leitor.nextFloat();
										if (((avf + discentes.media) / 2) >= 5) {
											result = "Aprovado pela AVF ! ";
											discentes.media=((avf + discentes.media) / 2);
											System.out.println("Media: "
													+ discentes.media + " - > "
													+ result);
										} else {
											result = "Reprovado Pela avf";
											discentes.media=((avf + discentes.media) / 2);
											System.out.println("Media: "
													+ discentes.media + " - >"
													+ result);
										}
									}
								}
							}
						}
					}

				} else if (opcao == 2) {
					System.out.println("Opcoes :");
					System.out.println("1-Criar professor\n"
							+ "2-Deletar professor\n"
							+ "3-Atualizar professor\n"
							+ "4-Mostrar professores\n"
							+ "5-Gerenciar Disciplina\n");

					int opcao1 = leitor.nextInt();
					if (professores.isEmpty() && opcao1 > 1) {
						System.out.println("Nenhum professor cadastrado");
						continue;
					}
					if (opcao1 == 1) {
						System.out.println("Digite um nome:");
						String auxnome = leitor.next();
						Professor adcProfessor = new Professor(auxnome);
						professores.add(adcProfessor);
					} else if (opcao1 == 2) {
						System.out.println("Qual o professor ? ");
						for (int i = 0; i < professores.size(); i++) {
							System.out.println(i + "-"
									+ professores.get(i).getNome());
						}
						professores.remove(leitor.nextInt());
					} else if (opcao1 == 3) {
						System.out.println("Qual o professor ?");
						for (int i = 0; i < professores.size(); i++) {
							System.out.println(i + "-"
									+ professores.get(i).getNome());
						}
						try {
							int indexProfessor = leitor.nextInt();
							Professor profAux = professores.get(indexProfessor);
							System.out.println("Digite o nome que quer por :");
							professores.get(indexProfessor).setNome(
									leitor.next());

						} catch (Exception ex) {
							System.out.println("Opçao invalida!");
							leitor.next();
							continue;
						}

					} else if (opcao1 == 4) {
						for (Professor professor : professores) {
							System.out.println(professor.getNome());
						}
					} else if (opcao1 == 5) {

						System.out.println("Escolha o professor : ");
						for (Professor pp : professores) {
							System.out.println(professores.indexOf(pp) + " - "
									+ pp.getNome());
						}

						int prof;
						try {
							prof = leitor.nextInt();
						} catch (Exception ex) {
							System.out.println("Opçao invalida!");
							leitor.next();
							continue;
						}
						if (professores.get(prof) != null) {
							System.out.println("Opcoes :");
							System.out.println("1-Criar disciplina\n"
									+ "2-Deletar disciplina\n"
									+ "3-Atualizar disciplina\n"
									+ "4-Mostrar disciplinas e avaliaçoes\n"
									+ "5-Matricular aluno\n"
									+ "6-Definir metodo\n"
									+ "7-Ver alunos por disciplinas\n"
									+ "8-Colocar notas dos alunos\n"
									+ "9-Ver medias dos alunos\n");
							opcao1 = leitor.nextInt();
							if (opcao1 == 1) {
								System.out.println("Digite um nome:");
								String auxnome = leitor.next();
								Disciplina adcDisciplina = new Disciplina(
										auxnome);
								professores.get(prof).disciplinas
										.add(adcDisciplina);
							} else if (opcao1 == 2) {
								System.out.println("Qual a disciplina ?");
								for (int i = 0; i < professores.get(prof).disciplinas
										.size(); i++) {
									System.out.println(i
											+ "-"
											+ professores.get(prof).disciplinas
													.get(i).getNome());
								}
								professores.get(prof).disciplinas.remove(leitor
										.nextInt());
							} else if (opcao1 == 3) {
								System.out
										.println("Digite o nome da disciplina que quiser atualizar :");
								String auxnome = leitor.next();
								for (int i = 0; i < professores.get(prof).disciplinas
										.size(); i++) {
									if (auxnome
											.equals(professores.get(prof).disciplinas
													.get(i).getNome())) {
										System.out
												.println("Digite o nome que quer por :");
										String aux2 = leitor.next();
										professores.get(prof).disciplinas
												.get(i).setNome(aux2);
									}
								}
							} else if (opcao1 == 4) {
								for (Disciplina disciplina : professores
										.get(prof).disciplinas) {
									System.out.println(disciplina.getNome()
											+ ":");
									for (Avaliacao avalia : disciplina
											.getMetodologia()
											.getListaAvaliacao()) {
										System.out.println("\t"
												+ avalia.getNome());
										for (Subavaliacao subavalia : avalia
												.getListaSubAvl()) {
											System.out.println("\t\t"
													+ subavalia.getNome());
										}
									}
								}
							} else if (opcao1 == 5) {
								System.out
										.println("Digite o nome da disciplina :");
								String aux = leitor.next();
								for (int i = 0; i < professores.get(prof).disciplinas
										.size(); i++) {
									if (professores.get(prof).disciplinas
											.get(i).getNome().equals(aux)) {
										System.out
												.println("Digite o nome do aluno : ");
										String aux1 = leitor.next();
										for (Aluno aluno : alunos) {
											if (aux1.equals(aluno.getNome())) {
												professores.get(prof).disciplinas
														.get(i).addAluno(aluno);
											}

										}
									}
								}
							} else if (opcao1 == 7) {
								System.out
										.println("Digite o nome da disciplina:");
								String aux2 = leitor.next();
								for (int i = 0; i < professores.get(prof).disciplinas
										.size(); i++) {
									if (aux2.equals(professores.get(prof).disciplinas
											.get(i).getNome())) {
										for (Disciplina disc : professores
												.get(prof).disciplinas) {
											disc.mostraAlunos();
										}
									}
								}
							} else if (opcao1 == 6) {
								System.out.println("Qual a disciplina ?");
								for (Disciplina dd : professores.get(prof).disciplinas) {
									System.out
											.println(professores.get(prof).disciplinas
													.indexOf(dd)
													+ "-"
													+ dd.getNome());
								}
								int disc;
								try {
									disc = leitor.nextInt();
									professores.get(prof).disciplinas.get(disc);
								} catch (Exception ex) {
									System.out.println("Opçao invalida!");
									leitor.next();
									continue;
								}
								int ava, subava;
								System.out
										.println("Digite o numero de avaliacoes: ");
								ava = leitor.nextInt();

								for (int i = 0; i < ava; i++) {
									System.out
											.println("Digite o nome da avaliação "
													+ (i + 1));
									String nomeAvaliacao = leitor.next();
									professores.get(prof).disciplinas.get(disc)
											.getMetodologia().listaAvaliacao
											.add(new Avaliacao(nomeAvaliacao));
									System.out
											.println("Digite o numero de sub desta avaliaçao:");
									subava = leitor.nextInt();
									for (int j = 0; j < subava; j++) {
										System.out
												.println("Digite o nome da sub :"
														+ (j + 1));
										String nomeSubavaliacao = leitor.next();
										professores.get(prof).disciplinas.get(
												disc).getMetodologia().listaAvaliacao
												.get(i).listaSubAvl
												.add(new Subavaliacao(
														nomeSubavaliacao));
									}

								}
							}// fim op 6
							else if (opcao1 == 8) {

								if (professores.get(prof) != null) {
									System.out.println("Qual a disciplina ?");
									for (Disciplina dd : professores.get(prof).disciplinas) {
										System.out.println(professores
												.get(prof).disciplinas
												.indexOf(dd)
												+ "-" + dd.getNome());
									}
									int disc;
									try {
										disc = leitor.nextInt();
										professores.get(prof).disciplinas
												.get(disc);
									} catch (Exception ex) {
										System.out.println("Opçao invalida!");
										leitor.next();
										continue;
									}

									if (professores.get(prof).disciplinas
											.get(disc).getAlunos().isEmpty()) {
										System.out
												.println("Não há alunos aqui!");
										continue;
									}
									System.out.println("Qual aluno ?");
									for (Aluno alun : professores.get(prof).disciplinas
											.get(disc).getAlunos()) {
										System.out.println(professores
												.get(prof).disciplinas
												.get(disc).getAlunos()
												.indexOf(alun)
												+ "-" + alun.getNome());
									}
									int alu;
									try {
										alu = leitor.nextInt();
										professores.get(prof).disciplinas
												.get(disc).getAlunos().get(alu);
									} catch (Exception ex) {
										System.out.println("Opçao invalida!");
										leitor.next();
										continue;
									}
									{
										ArrayList<Avaliacao> aux = professores
												.get(prof).disciplinas
												.get(disc).getMetodologia().listaAvaliacao;

										for (int i = 0; i < aux.size(); i++) {
											professores.get(prof).disciplinas
													.get(disc).getAlunos()
													.get(alu).avaliacoes
													.add(new Avaliacao(aux.get(
															i).getNome()));
											for (int j = 0; j < aux.get(i)
													.getListaSubAvl().size(); j++) {
												professores.get(prof).disciplinas
														.get(disc).getAlunos()
														.get(alu).avaliacoes
														.get(i).listaSubAvl
														.add(new Subavaliacao(
																aux.get(i)
																		.getListaSubAvl()
																		.get(j).nome));
											}
										}

									}

									for (Avaliacao av : professores.get(prof).disciplinas
											.get(disc).getAlunos().get(alu).avaliacoes) {
										for (Subavaliacao sbavl : av
												.getListaSubAvl()) {
											System.out
													.println("Escreva a nota do(a) "
															+ sbavl.getNome()
															+ " da "
															+ av.getNome());
											float nota = leitor.nextFloat();
											sbavl.setNota(nota);
										}
									}
								}

							} else if (opcao1 == 9) {
								for (Professor prof1 : professores) {
									System.out.println("Professor " + prof1.getNome()
											+ ": ");
									for (Disciplina disci : prof1.disciplinas) {
										System.out.print("\tDisciplina "
												+ disci.getNome() + ": ");
										for (Avaliacao ava : disci.getMetodologia().listaAvaliacao) {
											System.out.print(ava.getNome() + "( ");
											for (Subavaliacao subava : ava
													.getListaSubAvl()) {
												System.out
														.print(subava.getNome() + " ");
											}
											System.out.print(")  ");
										}
										System.out.println();
										for (Aluno discentes : disci.getAlunos()) {
											int numNotas = 0;
											System.out.print("\t\t"
													+ discentes.getNome() + " ( ");
											try {
												if (discentes.avaliacoes.get(0).listaSubAvl
														.get(0).nota == null)
													System.out
															.println("Nenhuma nota ainda!)");
											} catch (Exception e) {
												System.out
														.println("Nenhuma nota ainda!)");
											}
											for (Avaliacao ava : discentes.avaliacoes) {
												System.out.print(ava.getNome() + " ");
												for (Subavaliacao subava : ava
														.getListaSubAvl()) {
													System.out.print(subava.getNota()
															+ " ");
													numNotas++;
													discentes.media += subava.getNota();
												}
												System.out.print(")  ");
											}
											discentes.media = discentes.getMedia()
													/ numNotas;
											String result = "";
											if (discentes.media < 4)
												result = "REPROVADO !";
											else if (discentes.media >= 7)
												result = "APROVADO !";
											else if (discentes.media >= 4
													&& discentes.media < 7)
												result = "AVF!!";

											System.out
													.println("Media: "
															+ discentes.media + " - >"
															+ result);
											if (discentes.media >= 4
													&& discentes.media < 7) {
												System.out
														.println("Digite a nota da avf  :");
												float avf = leitor.nextFloat();
												if (((avf + discentes.media) / 2) >= 5) {
													result = "Aprovado pela AVF ! ";
													discentes.media=((avf + discentes.media) / 2);
													System.out.println("Media: "
															+ discentes.media + " - > "
															+ result);
												} else {
													result = "Reprovado Pela avf";
													discentes.media=((avf + discentes.media) / 2);
													System.out.println("Media: "
															+ discentes.media + " - >"
															+ result);
												}
											}
										}
									}
								}
							}
						}// fim gerenciar disciplina
					}// fim professor

				}
			} catch (Exception ex) {
				System.out.println("Escolha invalida!");
				leitor.next();
			}

		}// fim while
	}
}
