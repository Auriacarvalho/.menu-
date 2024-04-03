import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CatalogoGUI extends JFrame {

    public CatalogoGUI() {
        setTitle("Catálogo de Cadastro");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Criar alguns itens para o catálogo (para fins de demonstração)
        ItemCatalogo item1 = new ItemCatalogo("Item 1", "Descrição do Item 1", "caminho/para/imagem1.jpg");
        ItemCatalogo item2 = new ItemCatalogo("Item 2", "Descrição do Item 2", "caminho/para/imagem2.jpg");

        // Adicionar itens ao catálogo
        adicionarItem(panel, item1);
        adicionarItem(panel, item2);

        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane);

        setVisible(true);
    }

    private void adicionarItem(JPanel panel, ItemCatalogo item) {
        JPanel itemPanel = new JPanel(new BorderLayout());
        itemPanel.setBorder(BorderFactory.createEtchedBorder());

        JLabel nomeLabel = new JLabel(item.getNome());
        JLabel descricaoLabel = new JLabel(item.getDescricao());

        ImageIcon imagemIcon = new ImageIcon(item.getFotoPath());
        JLabel imagemLabel = new JLabel(imagemIcon);

        itemPanel.add(nomeLabel, BorderLayout.NORTH);
        itemPanel.add(descricaoLabel, BorderLayout.CENTER);
        itemPanel.add(imagemLabel, BorderLayout.SOUTH);

        panel.add(itemPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CatalogoGUI());
    }
}

