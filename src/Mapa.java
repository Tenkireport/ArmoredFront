// Criamos a classe chamada Mapa
public class Mapa {

    // Matriz (tabela) de textos que representa o mapa
    // Cada posição do mapa vai guardar um símbolo (ex: ".")
    String[][] grid;

    // Define o tamanho do mapa (10x10)
    int tamanho = 10;

    // Este é o construtor da classe Mapa (executa quando criamos um Mapa)
    public Mapa(){

        // Criamos uma tabela de 10 linhas e 10 colunas
        grid = new String[tamanho][tamanho];

        // Este laço percorre todas as linhas do mapa
        for(int i = 0; i < grid.length; i++){

            // Este laço percorre todas as colunas do mapa
            for (int j = 0; j < grid[i].length; j++) {

                // Colocamos um ponto "." em cada posição do mapa
                // Isso significa que o local está vazio
                grid[i][j] = ".";
            }
        }
    }

    // Método que mostra o mapa na tela
    public void exibir(){

        // Percorre todas as linhas do mapa
        for(int i = 0; i < grid.length; i++){

            // Percorre todas as colunas do mapa
            for (int j = 0; j < grid[i].length; j++) {

                // Imprime o conteúdo da posição atual do mapa
                System.out.print(grid[i][j] + " ");
            }

            // Pula uma linha depois de imprimir cada linha do mapa
            System.out.println(" ");
        }
    }

    // Método para posicionar um objeto Mecha no mapa
    // m = o objeto Mecha
    // l = linha onde ele será colocado
    // c = coluna onde ele será colocado
    public void posicionar(Mecha m, int l, int c){

        // Guarda a linha dentro do objeto Mecha
        m.l = l;

        // Guarda a coluna dentro do objeto Mecha
        m.c = c;

        // Coloca no mapa a primeira letra do nome do Mecha
        // substring(0,1) pega só a primeira letra do nome
        grid[l][c] = m.name.substring(0,1);
    }

    public void move(Mecha m, int NewL, int NewC){
        if(NewL < 0 || NewC >= tamanho || NewC < 0 || NewL >= tamanho){
            System.out.println("Fora dos limites");
            return;
        }

        if(!grid[NewL][NewC].equals(".")){
            System.out.println("Local ocupado");
            return;
        }

        grid[m.l][m.c] = ".";
        m.l = NewL;
        m.c = NewC;

        grid[m.l][m.c] = m.name.substring(0,1);
    }

    public double calcDist(Mecha m1, Mecha m2){
        int difLinha = m1.l - m2.l;
        int difColuna = m1.c - m2.c;

        double distancia = Math.sqrt((difLinha * difLinha) + (difColuna * difColuna));

        return distancia;
    }

}
