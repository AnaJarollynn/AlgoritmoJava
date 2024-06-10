import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {

        //Variável Texto (String = Array de Char);

        String nome = "Ana Carolina Nunes";
        System.out.println("Olá, " + nome);

        //Números Inteiros : Byte, Short, Int, Long;

        int numeroInicial = 30;
        int numeroFinal = 13;
    
        int soma = numeroInicial + numeroFinal;
        int subtracao = numeroInicial - numeroFinal;
        int multiplicacao = numeroFinal * numeroFinal;
        int divisaoErrada = numeroInicial / numeroFinal;  //resultado possivelmente errado devido as variáveis serem inteiras

        System.out.println(soma);
        System.out.println(subtracao);
        System.out.println(multiplicacao);
        System.out.println(divisaoErrada);

        //Números Decimais

        double numeroInicialDouble = 30.0;
        double numeroFinalDouble = 13.0;

        double divisaoCerta = numeroInicialDouble /numeroFinalDouble;
        System.out.println(divisaoCerta);

        //ou "forçar" a informação

        double divisaoErradaCorrigida = (double) numeroInicial / numeroFinal;
        System.out.println(divisaoErradaCorrigida);

        //Variáveis Lógicos

        boolean resultado = false;
        System.out.println(resultado);

        //Algoritmo Exemplo

        boolean fimDeSemana = true;
        boolean fazendoSol = true;

        boolean vamosAPraia = fimDeSemana && fazendoSol;
        System.out.println(vamosAPraia);

        //Tabela Verdade

        //Operador && (AND)
        // true && true = true
        // true && false = false
        // false && true = false
        // false && false = false

        //Operador || (OR)
        // true || true = true
        // true || false = true
        // false || true = true
        // false || false = false

        //Operador Alternário
        // ? = Se
        // ? (verdadeiro) : (falso)

        String mensagem = fimDeSemana ? "É fim de semana" : "Não é fim de semana";
        System.out.println(mensagem);

        //Estruturas Condicionais

        int nota = 80;
        int media = 70;

        //Exemplo:
        //nota maior ou igual 70 = aprovado

        if (nota >= media) 
            System.out.println("Aprovado"); //Quando a resposta do 'IF' possui apenas 1 linha, não é necessário as chaves '{}'
        else    
            System.out.println("Reprovado"); //Quando a reposta do 'ELSE' possui apenas 1 linha, não é necessário as chaves '{}'

        // A > 80 | B > 70 | C > 60 | D > 0
        // Verificar Gradução

        nota = 90;
        String graduacao;

        if(nota >= 80)
            graduacao = "A";
        else if (nota < 80 && nota >= 70)
            graduacao = "B";
        else if (nota < 70 && nota > 60)
            graduacao = "C";
        else if (nota < 60 && nota > 0)
            graduacao = "D";
        else
            graduacao = "";

        // Estrutura Switch para verificar as condições de aprovação
        // Default = nenhum dos casos acima

        switch(graduacao){
            case "A":
            case "B":
                System.out.println("Aluno Aprovado");
                break;
            case "C":
            case "D":
                System.out.println("Aluno Reprovado");
                break;
            default:
                System.out.println("Graduação Inválida");
        }

        //Manipulação de Strings e Datas

        //Olá, {nome}. Hoje é {dia-da-semana}, Bom dia!

        nome = "Ana Carolina";
        System.out.println(nome.toUpperCase()); //Maíusculo
        System.out.println(nome.toLowerCase()); //Minusculo
        System.out.println(nome.length()); //Quantidade de Caracteres
        
        //ISO 8601 - Padrão para representar a Data
        LocalDate hoje = LocalDate.now();//Importado de java.time.LocalDate - Olhe no inicio do código a biblioteca

        @SuppressWarnings("deprecation") //Suprimindo o 'aviso' da linha de baixo
        Locale brasil = new Locale("pt","br"); //Adicionando Linguagem e Local
        String diaSemana = hoje.getDayOfWeek().getDisplayName(TextStyle.FULL, brasil); //Colocando o TextStyle (como será escrito) e a localidade
        String saudacao;

        LocalDateTime agora = LocalDateTime.now();

        if(agora.getHour() > 0 && agora.getHour() < 12)
            saudacao = "Bom dia";
        else if (agora.getHour() >= 12 && agora.getHour() < 18)
            saudacao = "Boa tarde";
        else if (agora.getHour() >= 18 && agora.getHour() < 24)
            saudacao = "Boa noite";
        else
            saudacao = "Olá."; //evitar erros (Impossível acontecer, mas evitando excessão)

        // %s = string
        // %i = int
        // %n = quebra de linha
        //printf = não quebra linha automaticamente

        System.out.printf("Olá, %s. Hoje é %s, %s.%n", nome, diaSemana, saudacao.toLowerCase());
        
        //Laços Numéricos

        // Exibir números de 1 até 10
        // Para uma variável que inicia em 1 e vai até 10, mudando 1-por-1, faça:

        for(int i = 1; i <= 10; i++){ // i = index
            System.out.println(i);
        } 
        
        // Tabuada de Multiplicação 1 até 10

        for(int i = 1; i <= 10; i++){ //Apenas retornará para o 'i' quando todas as ações do 'j' forem completadas
            for(int j = 1; j <= 10; j++){ 
                System.out.println(j + " x " + i + " = " + j * i); //Exibindo no terminal de forma mais clara
            } 
        }

        //Vetores ou Arrays
        // São Homogêneos (Todos os elementos devem ser de um mesmo tipo)

        //lista de 5 números
        int[] numeros = new int[5]; //array é orientado a indice, ou seja, posições
        // [0], [1], [2], [3], [4] - 5 posições

        System.out.println(numeros);// '[' quer dizer que é um array 'I' que é de inteiros, após o @ é o local da memória que está alocado

        numeros[0] = 1;
        numeros[1] = 2;
        numeros[2] = 3;
        numeros[3] = 4;
        numeros[4] = 5;

        //Imprimir elementos do Array
        for (int i = 0; i < numeros.length; i++){
            System.out.println(numeros[i]);
        }
        
        String[] nomes = {"Ana", "Pedro", "Jolyne","Jessé"};

        for (int i = 0; i < nomes.length; i++){
            System.out.println(nomes[i]);
        }

        //Imprimindo a lista transformando em string
        System.out.println(Arrays.toString(nomes));
        System.out.println(Arrays.toString(numeros));

        //Fazer verificação do maior número

        int maiorNumero = numeros[0];
        int menorNumero = numeros[0];
        media = 0;

        for (int i = 0; i <numeros.length; i++){
            if (numeros[i] > maiorNumero) //Verificação de Maior Valor
                maiorNumero = numeros[i];
            if(numeros[i] < menorNumero) //Verificação de Menor Valor
                menorNumero = numeros[i];

            media += numeros[i]; //Somando média com o número
        }

        //Imprimindo valores
        System.out.println("Maior Número " + maiorNumero);
        System.out.println("Menor Número " + menorNumero);
        System.out.println("Média: " + media/numeros.length);

        //Chamando a Função - Leia fora do 'Main'
        nome = "José Almeida";
        Saudacao(nome); // Nome é utilizado na Função

        //Criando uma Soma
        double numero1 = 2.5;
        double numero2 = 6.4;

        //ctrl + f12 para entrar no método e verificar o que está acontecendo
        double valorResultado = Soma(numero1,numero2);
        System.out.println(valorResultado);


    }

    //Definir Função/Método (Mais utilizado o nome de método)

    public static void Saudacao(String nomeMencionado){ //Declarar a variável que será mencionada e utilizada dentro do Método
        //Estatico porque o método main é Estático e void não retorna valor
        System.out.println("Hello, " + nomeMencionado); 
    }
    
    public static double Soma(double numero1, double numero2){ //Função Double, ou seja, retorna um valor double
        return numero1 + numero2; //return significa que o return vai voltar o que estiver na frente, no caso atual, o calculo de Soma
    }
}
