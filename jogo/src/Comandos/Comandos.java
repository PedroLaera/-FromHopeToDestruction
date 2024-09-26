package Comandos;
import model.Save;
import model.Cena;
import model.Console;
import model.Inventario;
import model.Item;
import repository.CenaDAO;
import repository.InventarioDAO;
import repository.*;

import java.sql.SQLException;
import java.util.List;

public class Comandos {
    private final String[] comando;
    private final Console console;
    private final Inventario inventario;
    private Cena cenaAtual;
    private Integer idSave = 1; // ID fictício para o jogo salvo (será usado mais tarde)

    public Comandos(String comandoBruto) throws SQLException {
        this.console = new Console();
        this.comando = comandoBruto.split(" ");
        this.inventario = new Inventario();

        // Carregar o inventário e a cena inicial do banco de dados
        List<Item> itensInventario = InventarioDAO.getInventarioBySaveId(idSave);
        this.inventario.mostrarInventario();
        this.cenaAtual.getIdCena();

        // Carregar a primeira cena do banco de dados (por exemplo, ID 1);
//        this.cenaAtual = CenaDAO.findCenaById(this.); // Carrega a cena com ID 1
        if (this.cenaAtual != null) {
            this.console.setMensagem("Cena carregada: " + this.cenaAtual.getDescricao());
            this.console.exibirmensagem();
        } else {
            this.console.setMensagem("Erro ao carregar a cena.");
            this.console.exibirmensagem();
        }
    }

    public void processarComando() throws SQLException {
        switch (comando[0].toLowerCase()) {
            case "help":
                help();
                break;
            case "start":
                start();
                break;
            case "get":
                if (comando.length > 1) {
                    getItem(comando[1]);
                } else {
                    console.setMensagem("Você precisa especificar um item para pegar.");
                    console.exibirmensagem();
                }
                break;
            case "use":
                if (comando.length > 1) {
                    useItem(comando[1]);
                } else {
                    console.setMensagem("Você precisa especificar um item para usar.");
                    console.exibirmensagem();
                }
                break;
            case "check":
                if (comando.length > 1) {
                    checkItem(comando[1]);
                } else {
                    console.setMensagem("Você precisa especificar um item para verificar.");
                    console.exibirmensagem();
                }
                break;
            case "next":
                cenaAtual.getIdCenaSeguinte();
                break;
            case "inventory":
                inventario.mostrarInventario();
                break;
            default:
                console.setMensagem("Comando inválido. Digite 'help' para ver a lista de comandos.");
                console.exibirmensagem();
                break;
        }
    }

    // Método help para exibir os comandos disponíveis
    public void help() {
        console.setMensagem("Comandos disponíveis:\n" +
                "- start: Iniciar o jogo\n" +
                "- get [item]: Pegar um item\n" +
                "- use [item]: Usar um item\n" +
                "- check [item]: Verificar um item\n" +
                "- go: Avançar para a próxima cena\n" +
                "- inventory: Ver itens no inventário\n" +
                "- save: Salvar o jogo\n" +
                "- load: Carregar o jogo salvo\n" +
                "- restart: Reiniciar o jogo\n" +
                "- help: Exibir esta mensagem de ajuda\n" +
                "- exit: Sair do jogo");
        console.exibirmensagem();
    }

    public void start() throws SQLException {
        // Verifica se o save já existe, se não, cria um novo save
        Save save = SaveDAO.novoJogo();
        if (save == null) {
            // Se não há save, cria um novo
            SaveDAO.novoJogo();
        }
        console.setMensagem("O jogo começou!\n" + cenaAtual.getDescricao());
        console.exibirmensagem();
    }


    public void getItem(String nomeItem) throws SQLException {
        Item itemEncontrado = null;

        // Procura o item na lista de itens da cena atual
        for (Item item : cenaAtual.getItens()) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                itemEncontrado = item;
                break;
            }
        }

        if (itemEncontrado != null) {
            // Adiciona o item ao inventário
            InventarioDAO.adicionarItemAoInventario(itemEncontrado, idSave);
            console.setMensagem("Você pegou o item: " + nomeItem);

            // Remove o item da cena atual
            cenaAtual.getIdCena(itemEncontrado);


        } else {
            console.setMensagem("Item " + nomeItem + " não encontrado na cena.");
        }
        console.exibirmensagem();
    }


    public void useItem(String nomeItem) throws SQLException {
        if (inventario.contemItem(nomeItem)) {
            console.setMensagem("Você usou o item: " + nomeItem);
            InventarioDAO.removerItemDoInventario(nomeItem, idSave);
            irParaProximaCena(cenaAtual.getIdCenaSeguinte());
        } else {
            console.setMensagem("Você não tem o item: " + nomeItem);
        }

    }

    // Método para verificar um item na cena
    public void checkItem(String nomeItem) throws SQLException {
        Item itemEncontrado = null;
        for (Item item : cenaAtual.getItens()) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                itemEncontrado = item;
                break;
            }
        }

        if (itemEncontrado != null) {
            console.setMensagem("Descrição do item: " + itemEncontrado.getDescricaoPositiva());
        } else {
            console.setMensagem("Item " + nomeItem + " não encontrado na cena.");
        }
        console.exibirmensagem();
    }

    public void irParaProximaCena(Integer cena) throws SQLException {
        if (cenaAtual.getIdCenaSeguinte() != null) {
            cena = cenaAtual.getIdCenaSeguinte();
            console.setMensagem("Você avançou para a próxima cena.\n" + cenaAtual.getDescricao());
        } else {
            console.setMensagem("Não há uma próxima cena disponível.");
        } console.exibirmensagem();
}
}