package br.com.dio.desafio.poo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = initDataBiblioteca();
        System.out.println("**** Bem vindo a Biblioteca " +
                biblioteca.getNome() + " de " +
                biblioteca.getLocal() + "****");
        init(biblioteca);
    }

    private static void init(Biblioteca biblioteca) {
        System.out.println();
        System.out.println("======OPÇÔES======");
        System.out.println("1 - Cadastrar um livro");
        System.out.println("2 - Pesquisar livro pelo Codigo");
        System.out.println("3 - Pesquisar livro pelo Titulo");
        System.out.println("4 - Listar todos os livros");
        System.out.println("5 - Sair");

        Scanner scanner = new Scanner(System.in);
        String response = scanner.next();

        switch (response){
            case "1":
                biblioteca.setLivros(cadastrarLivro(biblioteca.getLivros()));
                break;
            case "2":
                pesquisarLivroCodigo(biblioteca.getLivros());
                break;
            case "3":
                pesquisarLivroTitulo(biblioteca.getLivros());
                break;
            case "4":
                listarTodosLivros(biblioteca.getLivros());
                break;
            case "5":
               System.exit(0);
                break;
            default:
                System.out.println("Opção invalida, tente novamente :( ");
                break;
        }
        init(biblioteca);
    }
    private static Biblioteca initDataBiblioteca() {
        Livro livro = new Livro(1,
                "A mulher do vizinho",
                200,
                50.36);
        livro.setNomeAutor("Fernando Sabino");

        Livro livro1 = new Livro(2,
                "Diário de um banana",
                255,
                39.99);
        livro1.setNomeAutor("Kinney");

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setNome("Biblioteca municipal");
        biblioteca.setLocal("São Paulo");
        biblioteca.setCapacidade(3000);
        biblioteca.setQuantidade(3000);
        biblioteca.getLivros().add(livro);
        biblioteca.getLivros().add(livro1);

        return biblioteca;
    }
    private static String emitirPergunta(String pergunta){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println(pergunta);

        return scanner.next();
    }
    private static Set<Livro> cadastrarLivro(Set<Livro> livrosCadastrados){
        Livro livro = new Livro();

       livro.setTitulo(emitirPergunta("Digite o titulo do livro:"));
       livro.setNumPagina(Integer.parseInt(emitirPergunta("Digite o numero de paginas:")));
       livro.setNomeAutor(emitirPergunta("Digite o nome do Autor:"));
       livro.setValorCompra(Double.parseDouble(emitirPergunta("Digite o valor de compra do livro:")));
       livro.setCodigo(livrosCadastrados.size()+1);
       livrosCadastrados.add(livro);
       System.out.println("****** LIVRO CADASTRADO COM SUCESSO ;) ******");

       return livrosCadastrados;
    }

    private static void pesquisarLivroCodigo(Set<Livro> livrosCadastrados){
        int resposta = Integer.parseInt( emitirPergunta("Digite o codigo do livro a pesquisar"));

        List<Livro> livroEncontrado  = new ArrayList<>();
        livroEncontrado = livrosCadastrados.stream()
                .filter(livro -> livro.getCodigo() == resposta)
                .collect(Collectors.toList());

        if (livroEncontrado.size() > 0){
            System.out.println("Livro encontrado "+ livroEncontrado.get(0).toString());
        } else{
            System.out.println("Desculpe não conseguimos encontrar o livro procurado");
        }
    }

    private static void pesquisarLivroTitulo(Set<Livro> livrosCadastrados){
        String resposta = emitirPergunta("Digite o Titulo do livro a pesquisar");

        List<Livro> livroEncontrado  = new ArrayList<>();
        livroEncontrado = livrosCadastrados.stream()
                .filter(livro -> resposta.equals(livro.getTitulo()))
                .collect(Collectors.toList());

        if (livroEncontrado.size() > 0){
            System.out.println("Livro encontrado "+ livroEncontrado.get(0).toString());
        } else{
            System.out.println("Desculpe não conseguimos encontrar o livro procurado");
        }
    }

    private static void listarTodosLivros(Set<Livro> livrosCadastrados){
        System.out.println("============ LIVROS CADASTRADOS ============");
        System.out.println(livrosCadastrados);
    }

}
