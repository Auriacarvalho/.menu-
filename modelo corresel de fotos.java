import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CarrosselDeFotos extends JFrame {

    private JLabel fotoLabel;
    private JButton btnAnterior;
    private JButton btnProximo;
    private String[] fotos;
    private int indiceAtual;

    public CarrosselDeFotos(String[] fotos) {
        this.fotos = fotos;
        this.indiceAtual = 0;

        setTitle("Carrossel de Fotos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        fotoLabel = new JLabel();
        fotoLabel.setHorizontalAlignment(JLabel.CENTER);
        atualizarFoto();

        btnAnterior = new JButton("Anterior");
        btnProximo = new JButton("Próximo");

        btnAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indiceAtual--;
                if (indiceAtual < 0) {
                    indiceAtual = fotos.length - 1;
                }
                atualizarFoto();
            }
        });

        btnProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indiceAtual++;
                if (indiceAtual >= fotos.length) {
                    indiceAtual = 0;
                }
                atualizarFoto();
            }
        });

        JPanel panelBotoes = new JPanel();
        panelBotoes.add(btnAnterior);
        panelBotoes.add(btnProximo);

        getContentPane().add(fotoLabel, BorderLayout.CENTER);
        getContentPane().add(panelBotoes, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void atualizarFoto() {
        ImageIcon imagemIcon = new ImageIcon(fotos[indiceAtual]);
        Image imagem = imagemIcon.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        fotoLabel.setIcon(new ImageIcon(imagem));
    }

    public static void main(String[] args) {
        String[] fotos = {"caminho/para/imagem1.jpg", "caminho/para/imagem2.jpg", "caminho/para/imagem3.jpg"};
        SwingUtilities.invokeLater(() -> new CarrosselDeFotos(fotos));
    }
}
