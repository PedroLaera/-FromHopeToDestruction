//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package service;

import java.util.Iterator;
import java.util.List;
import model.Console;
import model.Inventario;
import repository.InventarioDAO;

public class ComandoInventory {
    private Console console = new Console();

    public ComandoInventory() {
    }

    public Console executar(int idSave) {
        try {
            List<Inventario> inventarios = InventarioDAO.findInventariosBySaveId(String.valueOf(idSave));
            if (inventarios.isEmpty()) {
                this.console.setMensagem("Seu inventário está vazio.");
            } else {
                StringBuilder mensagem = new StringBuilder("Itens no seu inventário:\n");
                Iterator var4 = inventarios.iterator();

                while(var4.hasNext()) {
                    Inventario inventario = (Inventario)var4.next();
                    mensagem.append("Item: ").append(inventario.getNomeItem()).append(" - Quantidade: ").append(inventario.getQuantidade()).append("\n");
                }

                this.console.setMensagem(mensagem.toString());
            }
        } catch (Exception var6) {
            Exception e = var6;
            this.console.setMensagem("Erro ao buscar os itens do inventário: " + e.getMessage());
        }

        return this.console;
    }
}
